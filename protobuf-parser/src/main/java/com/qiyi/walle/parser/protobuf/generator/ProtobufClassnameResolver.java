package com.qiyi.walle.parser.protobuf.generator;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;

import com.qiyi.walle.parser.Classpath;
import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.protobuf.AstVisitor;
import com.qiyi.walle.parser.protobuf.Node;
import com.qiyi.walle.parser.protobuf.tree.Entity;
import com.qiyi.walle.parser.protobuf.tree.Enumeration;
import com.qiyi.walle.parser.protobuf.tree.Field;
import com.qiyi.walle.parser.protobuf.tree.Function;
import com.qiyi.walle.parser.protobuf.tree.Header;
import com.qiyi.walle.parser.protobuf.tree.Include;
import com.qiyi.walle.parser.protobuf.tree.Message;
import com.qiyi.walle.parser.protobuf.tree.Namespace;
import com.qiyi.walle.parser.protobuf.tree.Option;
import com.qiyi.walle.parser.protobuf.tree.ProtoProgram;
import com.qiyi.walle.parser.protobuf.tree.Service;
import com.qiyi.walle.parser.protobuf.type.FieldType;
import com.qiyi.walle.parser.protobuf.type.StructType;

import org.apache.commons.lang3.StringUtils;

import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-05-18 14
 */
public class ProtobufClassnameResolver extends AstVisitor<Node, Classpath<ProtoProgram>> {

    @Override
    public Node visitNode(Node node, Classpath<ProtoProgram> context) {
        return node;
    }

    @Override
    public Option visitOption(Option option, Classpath<ProtoProgram> context) {
        return (Option) process(option, context);
    }

    private Optional<QualifiedName> search(Set<QualifiedName> dependencies, QualifiedName qn) {
        if (null != dependencies) {
            return dependencies.stream()
                    .filter(d -> d.endsWith(qn))
                    .findFirst();
        }
        return Optional.empty();
    }

    private Optional<QualifiedName> resolve(QualifiedName qn, Classpath<ProtoProgram> context) {
        return resolve(qn, context.current(), context);
    }

    private Optional<QualifiedName> resolve(QualifiedName qn, Path file, Classpath<ProtoProgram> context) {
        ProtoProgram program = context.entity(file);
        List<Header> headers = program.getHeaders();
        Optional<QualifiedName> oqn = headers.stream()
                .filter(header -> header instanceof Namespace)
                .map(header -> QualifiedName.of(Namespace.class.cast(header).getName()))
                .findFirst();
        if (oqn.isPresent()) {
            QualifiedName n = oqn.get();
            String classname = outerClassName(file, context);
            QualifiedName prefix = QualifiedName.of(n, classname);
            if (qn.startsWith(n)) {
                if (isNullOrEmpty(classname)) {
                    return Optional.of(qn);
                } else {
                    if (qn.startsWith(prefix)) {
                        return Optional.of(prefix);
                    } else {
                        return qn.insertsAfter(n, classname);
                    }
                }
            } else if (1 == qn.size()) {
                return Optional.of(QualifiedName.of(prefix, qn));
            }
        }
        return Optional.empty();
    }

    @Override
    public StructType visitStructType(StructType structType, Classpath<ProtoProgram> context) {
        QualifiedName qn = structType.getName();
        Set<Path> dependencies = new LinkedHashSet<>();
        Path current = context.current();
        dependencies.add(current);
        Set<Path> files = context.files(current);
        if (null != files) {
            dependencies.addAll(files);
        }
        for (Path file : dependencies) {
            Optional<QualifiedName> name = resolve(qn, file, context);
            if (name.isPresent()) {
                Optional<QualifiedName> resolved = search(context.names(file), name.get());
                if (resolved.isPresent()) {
                    return new StructType(resolved.get());
                }
            }
        }
        // Best guess.
        Optional<QualifiedName> fqn = resolve(qn, context);
        QualifiedName name = fqn.orElse(qn);
        for (Path file : dependencies) {
            Optional<QualifiedName> resolved = search(context.names(file), name);
            if (resolved.isPresent()) {
                return new StructType(resolved.get());
            }
        }
        return new StructType(name);
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, Classpath<ProtoProgram> context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, Classpath<ProtoProgram> context) {
        FieldType type = visitFieldType(node.getType(), context);
        String name = node.getName();
        if (name.contains("_")) {
            name = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, node.getName());
            name = name.replace("C2f", "C2F");
        }
        return new Field(node.getModifier(), node.getIndex(), name, type, node.getValue(), node.getComments());
    }

    private String outerClassName(Classpath<ProtoProgram> context) {
        return outerClassName(context.current(), context);
    }

    private String outerClassName(Path file, Classpath<ProtoProgram> context) {
        ProtoProgram program = context.entity(file);
        if (null == program) {
            throw new IllegalStateException("Cannot find program for " + context.current());
        }
        return program.getOuterClassName();
    }

    private Message visitFieldsOfMessage(Message node, Classpath<ProtoProgram> context) {
        List<Message> messages = node.getMessages();
        ImmutableList.Builder<Message> mb = new ImmutableList.Builder<>();
        if (null != messages) {
            messages.forEach(message -> mb.add(visitFieldsOfMessage(message, context)));
        }
        List<Field> fields = node.getFields();
        ImmutableList.Builder<Field> fb = new ImmutableList.Builder<>();
        if (null != fields) {
            fields.forEach(field -> fb.add(visitField(field, context)));
        }
        return new Message(node.getName(), node.getComments(), fb.build(), mb.build(), node.getEnumerations(), node.getOptions());
    }

    @Override
    public Message visitMessage(Message node, Classpath<ProtoProgram> context) {
        QualifiedName name = resolveQualifiedName(node, context);
        context.name(name);

        List<Message> messages = node.getMessages();
        ImmutableList.Builder<Message> mb = new ImmutableList.Builder<>();
        if (null != messages) {
            messages.forEach(message -> mb.add(visitMessage(message, context)));
        }
        List<Enumeration> enumerations = node.getEnumerations();
        ImmutableList.Builder<Enumeration> eb = new ImmutableList.Builder<>();
        if (null != enumerations) {
            enumerations.forEach(enumeration -> eb.add(visitEnumeration(enumeration, context)));
        }
        return new Message(name, node.getComments(), node.getFields(), mb.build(), eb.build(), node.getOptions());
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, Classpath<ProtoProgram> context) {
        QualifiedName name = resolveQualifiedName(node, context);
        context.name(name);
        return new Enumeration(name, node.getComments(), node.getFields());
    }

    private QualifiedName resolveQualifiedName(Entity entity, Classpath<ProtoProgram> context) {
        String classname = outerClassName(context);
        QualifiedName name = entity.getName();
        if (!isNullOrEmpty(classname)) {
            QualifiedName namespace = context.namespace();
            Optional<QualifiedName> qn = entity.getName().insertsAfter(namespace, classname);
            if (qn.isPresent()) {
                name = qn.get();
            }
        }
        return name;
    }

    @Override
    public Function visitFunction(Function function, Classpath<ProtoProgram> context) {
        FieldType ct = visitFieldType(function.getRequestType(), context);
        FieldType rt = visitFieldType(function.getResponseType(), context);
        return new Function(function.getName(), ct, rt, function.getOptions());
    }

    @Override
    public Service visitService(Service node, Classpath<ProtoProgram> context) {
        ImmutableList.Builder<Function> fb = new ImmutableList.Builder<>();
        List<Function> functions = node.getFunctions();
        if (null != functions) {
            functions.forEach(f -> fb.add(visitFunction(f, context)));
        }
        return new Service(node.getName(), node.getOptions(), fb.build());
    }

    @Override
    public Namespace visitNamespace(Namespace node, Classpath<ProtoProgram> context) {
        context.namespace(QualifiedName.of(node.getName()));
        return node;
    }

    @Override
    public Include visitInclude(Include node, Classpath<ProtoProgram> context) {
        String file = StringUtils.strip(node.getFile(), "\"");
        Path current = context.current();
        Path include = context.path().resolve(file).normalize();
        ProtoProgram pp = context.entity(include);
        if (!context.parsed(include) && null != pp) {
            // #1 Set the current file
            context.current(include);
            // #2 Reserve the current namespace
            QualifiedName namespace = context.namespace();
            ProtoProgram proto = visitProtobufProgram(pp, context);
            // #3 Update entity
            context.entity(include, proto);
            // #4 Restore current file
            context.current(current);
            // #5 Restore current namespace
            context.namespace(namespace);
        }
        return node;
    }

    @Override
    public Header visitHeader(Header node, Classpath<ProtoProgram> context) {
        return (Header) process(node, context);
    }

    @Override
    public ProtoProgram visitProtobufProgram(ProtoProgram node, Classpath<ProtoProgram> context) {
        if (!node.getFile().equals(context.current())) {
            throw new IllegalStateException(node.getFile().toString());
        }
        if (isNullOrEmpty(node.getOuterClassName())) {
            return node;
        }
        List<Header> headers = node.getHeaders();
        ImmutableList.Builder<Header> hb = new ImmutableList.Builder<>();
        if (null != headers) {
            headers.forEach(header -> hb.add(visitHeader(header, context)));
        }
        ImmutableList.Builder<Message> tmb = new ImmutableList.Builder<>();
        List<Message> messages = node.getMessages();
        if (null != messages) {
            messages.forEach(message -> tmb.add(visitMessage(message, context)));
        }
        messages = tmb.build();
        ImmutableList.Builder<Message> mb = new ImmutableList.Builder<>();
        if (null != messages) {
            messages.forEach(message -> mb.add(visitFieldsOfMessage(message, context)));
        }

        ImmutableList.Builder<Enumeration> eb = new ImmutableList.Builder<>();
        List<Enumeration> enumerations = node.getEnumerations();
        if (null != enumerations) {
            enumerations.forEach(message -> eb.add(visitEnumeration(message, context)));
        }
        ImmutableList.Builder<Service> sb = new ImmutableList.Builder<>();
        List<Service> services = node.getServices();
        if (null != services) {
            services.forEach(service -> sb.add(visitService(service, context)));
        }

        ProtoProgram program = new ProtoProgram(node.getComments(), node.getOptions(), hb.build(), mb.build(), eb.build(), sb.build());
        program.setOuterClassName(node.getOuterClassName());
        program.setFile(node.getFile());
        return program;
    }
}
