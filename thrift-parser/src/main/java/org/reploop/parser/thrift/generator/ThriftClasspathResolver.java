package org.reploop.parser.thrift.generator;

import com.qiyi.walle.parser.thrift.ThriftParser;
import org.apache.commons.lang3.StringUtils;
import org.reploop.parser.Classpath;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.Node;
import org.reploop.parser.thrift.tree.Enum;
import org.reploop.parser.thrift.tree.Exception;
import org.reploop.parser.thrift.tree.*;
import org.reploop.parser.thrift.type.*;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * Resolve the dependencies for thrift.
 *
 * Some thrift byte buffer is some protobuf message, we try to find out the real message here too.
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-12 15
 */
public class ThriftClasspathResolver extends AstVisitor<Node, Classpath<ThriftProgram>> {

    private ThriftParser parser;

    public ThriftClasspathResolver(ThriftParser parser) {
        this.parser = parser;
    }

    @Override
    public Node visitNode(Node node, Classpath<ThriftProgram> context) {
        return node;
    }

    @Override
    public Include visitInclude(Include node, Classpath<ThriftProgram> context) {
        String file = StringUtils.strip(node.getFile(), "\"");
        Path current = context.current();
        Path parent = current.getParent();
        QualifiedName namespace = context.namespace();
        Path include = parent.resolve(file).normalize();
        context.files()
                .computeIfAbsent(current, p -> new HashSet<>())
                .add(include);
        ThriftProgram program = context.entity(include);
        if (null == program) {
            program = parser.program(include);
            if (null != program) {
                program.setFile(include);
                context.entity(include, program);
                // Parse include file recursively.
                context.current(include);
                context.path(include.getParent());
                ThriftProgram tp = visitProgram(program, context);
                // Replace the original entity.
                context.entity(include, tp);
                // Restore the classpath.
                context.path(parent);
                context.current(current);
                context.namespace(namespace);
            }
        }
        return node;
    }

    @Override
    public Namespace visitNamespace(Namespace node, Classpath<ThriftProgram> context) {
        if (node.getScope().support(Lang.JAVA)) {
            String ns = node.getNamespace();
            if (!isNullOrEmpty(ns)) {
                context.namespace(QualifiedName.of(ns));
            }
        }
        return node;
    }

    @Override
    public MapType visitMapType(MapType mapType, Classpath<ThriftProgram> context) {
        return new MapType(visit(mapType.getKeyType(), context, FieldType.class),
                visit(mapType.getValueType(), context, FieldType.class));
    }

    @Override
    public SetType visitSetType(SetType setType, Classpath<ThriftProgram> context) {
        return new SetType(visit(setType.getElementType(), context, FieldType.class));
    }

    @Override
    public ListType visitListType(ListType listType, Classpath<ThriftProgram> context) {
        return new ListType(visit(listType.getElementType(), context, FieldType.class));
    }

    @Override
    public CollectionType visitCollectionType(CollectionType collectionType, Classpath<ThriftProgram> context) {
        return (CollectionType) process(collectionType, context);
    }

    @Override
    public StructType visitStructType(StructType structType, Classpath<ThriftProgram> context) {
        QualifiedName name = structType.getName();
        String structName = name.suffix();
        Optional<QualifiedName> prefix = name.prefix();
        Optional<String> file = prefix.map(QualifiedName::suffix).map(f -> f + ".thrift");
        Optional<Set<Path>> includes = Optional.ofNullable(context.files().get(context.current()));
        if (file.isPresent() && includes.isPresent()) {
            Optional<Path> dep = includes.get()
                    .stream()
                    .filter(include -> include.endsWith(file.get()))
                    .findFirst();
            Set<QualifiedName> names = dep.map(context::names).orElse(Collections.emptySet());
            Optional<QualifiedName> fullName = names.stream()
                    .filter(qualifiedName -> qualifiedName.suffix().equals(structName))
                    .findFirst();
            if (fullName.isPresent()) {
                return new StructType(fullName.get());
            }
        }
        return new StructType(QualifiedName.of(context.namespace(), structName));
    }

    @Override
    public Entity visitEntity(Entity node, Classpath<ThriftProgram> context) {
        return (Entity) process(node, context);
    }

    private QualifiedName fullName(QualifiedName name, Classpath<ThriftProgram> context) {
        return QualifiedName.of(context.namespace(), name);
    }

    @Override
    public Exception visitException(Exception node, Classpath<ThriftProgram> context) {
        QualifiedName fn = fullName(node.getName(), context);
        context.name(fn);
        return new Exception(node.getComments(),
                fn,
                visit(node.getFields(), context, Field.class));
    }

    @Override
    public Enum visitEnum(Enum node, Classpath<ThriftProgram> context) {
        QualifiedName fn = fullName(node.getName(), context);
        context.name(fn);
        return new Enum(node.getComments(), fn,
                visit(node.getFields(), context, EnumField.class));
    }

    @Override
    public Struct visitStruct(Struct node, Classpath<ThriftProgram> context) {
        QualifiedName fn = fullName(node.getName(), context);
        context.name(fn);
        return new Struct(node.getComments(), fn,
                visit(node.getFields(), context, Field.class));
    }

    public Header visitHeader(Header node, Classpath<ThriftProgram> context) {
        return (Header) process(node, context);
    }


    private <R extends Node, C extends Node> Optional<R> visitIfPresent(Optional<C> node,
                                                                        Classpath<ThriftProgram> context,
                                                                        Class<R> clazz) {
        return node.map(n -> process(n, context))
                .map(clazz::cast);
    }

    private <R extends Node, C extends Node> Optional<List<R>> visitIfShow(Optional<List<C>> nodes,
                                                                           Classpath<ThriftProgram> context,
                                                                           Class<R> clazz) {
        return nodes.map(list -> visit(list, context, clazz));
    }

    private <R extends Node, C extends Node> R visit(C node,
                                                     Classpath<ThriftProgram> context,
                                                     Class<R> clazz) {
        Node value = process(node, context);
        if (null != value) {
            return clazz.cast(value);
        }
        return null;
    }

    private <R extends Node, C extends Node> List<R> visit(List<C> nodes,
                                                           Classpath<ThriftProgram> context,
                                                           Class<R> clazz) {
        if (null != nodes) {
            return nodes.stream()
                    .filter(node -> null != node)
                    .map(node -> process(node, context))
                    .filter(node -> null != node)
                    .map(clazz::cast)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public ThriftProgram visitProgram(ThriftProgram node, Classpath<ThriftProgram> context) {
        Path file = node.getFile();
        ThriftProgram program = new ThriftProgram(node.getComments(),
                visit(node.getHeaders(), context, Header.class),
                visit(node.getEntities(), context, Entity.class));
        program.setFile(file);
        return program;
    }

    @Override
    public Field visitField(Field node, Classpath<ThriftProgram> context) {
        return new Field(node.getComments(),
                visit(node.getFieldType(), context, FieldType.class),
                node.getFiledId(),
                node.getName(),
                node.isRequired());
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, Classpath<ThriftProgram> context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public ReturnType visitReturnType(ReturnType node, Classpath<ThriftProgram> context) {
        return new ReturnType(visit(node.getFieldType(), context, FieldType.class));
    }

    @Override
    public Function visitFunction(Function node, Classpath<ThriftProgram> context) {
        return new Function(node.getComments(),
                node.isOneWay(),
                node.getName(),
                visit(node.getReturnType(), context, FunctionType.class),
                visit(node.getParameters(), context, Field.class),
                visitIfShow(node.getExceptions(), context, Field.class));
    }

    @Override
    public Service visitService(Service node, Classpath<ThriftProgram> context) {
        QualifiedName fn = fullName(node.getName(), context);
        context.name(fn);
        return new Service(node.getParent(),
                fn,
                node.getComments(),
                visit(node.getFunctions(), context, Function.class));
    }
}
