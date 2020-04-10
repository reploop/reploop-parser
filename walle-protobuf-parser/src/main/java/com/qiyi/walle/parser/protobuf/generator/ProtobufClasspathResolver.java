package com.qiyi.walle.parser.protobuf.generator;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;

import com.qiyi.walle.parser.Classpath;
import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.protobuf.AstVisitor;
import com.qiyi.walle.parser.protobuf.Node;
import com.qiyi.walle.parser.protobuf.ProtobufParser;
import com.qiyi.walle.parser.protobuf.tree.BoolValue;
import com.qiyi.walle.parser.protobuf.tree.CommonPair;
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
import com.qiyi.walle.parser.protobuf.tree.StringValue;
import com.qiyi.walle.parser.protobuf.tree.Value;
import com.qiyi.walle.parser.protobuf.type.FieldType;
import com.qiyi.walle.parser.protobuf.type.StructType;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Strings.isNullOrEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Collect all message and it's type.
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-08-29 03
 */
public class ProtobufClasspathResolver extends AstVisitor<Node, Classpath<ProtoProgram>> {
    private static final Logger LOG = LoggerFactory.getLogger(ProtobufClasspathResolver.class);

    private static final String JAVA_OUTER_CLASSNAME = "java_outer_classname";
    private static final String JAVA_MULTIPLE_FILES = "java_multiple_files";
    /**
     * The .proto file starts with a package declaration, which helps to prevent naming conflicts
     * between different projects. In Java, the package name is used as the Java package unless you
     * have explicitly specified a java_package, as we have here. Even if you do provide a
     * java_package, you should still define a normal package as well to avoid name collisions in
     * the Protocol Buffers name space as well as in non-Java languages.
     */
    private static final String JAVA_PACKAGE = "java_package";
    private final ProtobufParser parser;

    public ProtobufClasspathResolver(ProtobufParser parser) {
        this.parser = parser;
    }

    @Override
    public Node visitNode(Node node, Classpath<ProtoProgram> context) {
        return node;
    }

    private String filename(Path filename) {
        return filename(filename.toString());
    }

    private String filename(String name) {
        int idx;
        if ((idx = name.lastIndexOf(".")) > 0) {
            return name.substring(0, idx);
        }
        return name;
    }

    private String format(String javaOuterClassname) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, javaOuterClassname);
    }

    private String javaOuterClassname(Path file) {
        return format(filename(file.getFileName()));
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, Classpath<ProtoProgram> context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, Classpath<ProtoProgram> context) {
        FieldType type = visitFieldType(node.getType(), context);
        return new Field(node.getModifier(), node.getIndex(), node.getName(), type, node.getValue(), node.getComments());
    }

    private <E extends Entity> Optional<Field> resolve(List<E> entities, Field field) {
        if (null != entities && entities.size() > 0) {
            FieldType type = field.getType();
            if (type instanceof StructType) {
                QualifiedName typeName = type.getName();
                if (typeName.size() == 1) {
                    for (E entity : entities) {
                        if (entity.getName().endsWith(typeName)) {
                            FieldType ft = new StructType(entity.getName());
                            return Optional.of(new Field(field.getModifier(), field.getIndex(), field.getName(), ft, field.getValue(), field.getComments()));
                        }
                    }
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Message visitMessage(Message node, Classpath<ProtoProgram> context) {
        QualifiedName fullName = getQualifiedFullName(node, context);

        Classpath<ProtoProgram> nestContext = context.copy();
        nestContext.namespace(fullName);

        ImmutableList.Builder<Message> mb = new ImmutableList.Builder<>();
        List<Message> messages = node.getMessages();
        if (null != messages) {
            messages.forEach(message -> mb.add(visitMessage(message, nestContext)));
        }
        ImmutableList<Message> ml = mb.build();
        context.names(nestContext.names());

        ImmutableList.Builder<Enumeration> eb = new ImmutableList.Builder<>();
        List<Enumeration> enumerations = node.getEnumerations();
        if (null != enumerations) {
            enumerations.forEach(enumeration -> eb.add(visitEnumeration(enumeration, nestContext)));
        }
        ImmutableList<Enumeration> el = eb.build();
        ImmutableList.Builder<Field> fb = new ImmutableList.Builder<>();
        List<Field> fields = node.getFields();
        if (null != fields) {
            for (Field field : fields) {
                Field f = visitField(field, nestContext);
                Optional<Field> mf = resolve(ml, field);
                if (mf.isPresent()) {
                    fb.add(mf.get());
                    continue;
                }
                Optional<Field> ef = resolve(el, field);
                if (ef.isPresent()) {
                    fb.add(ef.get());
                    continue;
                }
                fb.add(f);
            }
        }
        return new Message(fullName, node.getComments(), fb.build(), ml, el, node.getOptions());
    }

    private QualifiedName getQualifiedFullName(Enumeration node, Classpath<ProtoProgram> context) {
        QualifiedName qfn = getQualifiedFullName(node.getName(), context);
        context.name(qfn);
        return qfn;
    }

    private QualifiedName getQualifiedFullName(Message node, Classpath<ProtoProgram> context) {
        QualifiedName qfn = getQualifiedFullName(node.getName(), context);
        context.name(qfn);
        return qfn;
    }

    private QualifiedName getQualifiedFullName(QualifiedName name, Classpath<ProtoProgram> context) {
        QualifiedName namespace = context.namespace();
        return QualifiedName.of(namespace, name);
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, Classpath<ProtoProgram> context) {
        QualifiedName fullName = getQualifiedFullName(node, context);
        return new Enumeration(fullName, node.getComments(), node.getFields());
    }

    @Override
    public Include visitInclude(Include node, Classpath<ProtoProgram> context) {
        String file = StringUtils.strip(node.getFile(), "\"");
        Path current = context.current();
        QualifiedName namespace = context.namespace();
        Path include = context.path().resolve(file).normalize();
        context.file(include);
        if (!context.files().containsKey(include)) {
            ProtoProgram program = context.entity(include);
            if (null == program) {
                try {
                    program = parser.program(include);
                } catch (Exception e) {
                    LOG.error("Cannot parse proto file {}", include, e);
                }
            }
            if (null != program) {
                try {
                    program.setFile(include);
                    // Recursively
                    context.current(include);
                    context.entity(include, program);
                    program = visitProtobufProgram(program, context);
                    // Add this entity to the context.
                    context.entity(include, program);
                    // Restore current file and namespace.
                    context.current(current);
                    context.namespace(namespace);
                } catch (Exception e) {
                    LOG.error("Cannot resolve program {}", include, e);
                }
            } else {
                context.files().get(current).remove(include);
            }
        }
        return node;
    }

    @Override
    public Namespace visitNamespace(Namespace node, Classpath<ProtoProgram> context) {
        String ns = node.getName();
        context.namespace(QualifiedName.of(ns));
        return node;
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, Classpath<ProtoProgram> context) {
        String key = node.getKey();
        Value value = node.getValue();
        if (JAVA_OUTER_CLASSNAME.equals(key)) {
            ProtoProgram program = context.entity(context.current());
            String outerClassname = program.getOuterClassName();
            String val;
            if (!isNullOrEmpty(outerClassname) &&
                    value instanceof StringValue
                    && isNotEmpty(val = ((StringValue) value).getValue())) {
                outerClassname = StringUtils.strip(val, "\"");
                program.setOuterClassName(outerClassname);
            }
        } else if (JAVA_MULTIPLE_FILES.equals(key)) {
            Boolean val;
            if (value instanceof BoolValue
                    && null != (val = ((BoolValue) value).getValue())
                    && val) {
                // Just one class per file, like common Java.
                ProtoProgram program = context.entity(context.current());
                program.setOuterClassName(StringUtils.EMPTY);
            }
        } else if (JAVA_PACKAGE.equals(key)) {
            String val;
            if (value instanceof StringValue
                    && isNotEmpty(val = ((StringValue) value).getValue())) {
                context.namespace(QualifiedName.of(val));
            }
        }
        return node;
    }

    @Override
    public Option visitOption(Option option, Classpath<ProtoProgram> context) {
        return (Option) process(option, context);
    }

    @Override
    public Header visitHeader(Header node, Classpath<ProtoProgram> context) {
        return (Header) process(node, context);
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
    public StructType visitStructType(StructType structType, Classpath<ProtoProgram> context) {
        QualifiedName name = structType.getName();
        return new StructType(name);
    }

    @Override
    public ProtoProgram visitProtobufProgram(ProtoProgram node, Classpath<ProtoProgram> context) {
        try {
            String outerClassName = javaOuterClassname(context.current());
            node.setOuterClassName(outerClassName);
            ImmutableList.Builder<Header> hb = new ImmutableList.Builder<>();
            List<Header> headers = node.getHeaders();
            if (null != headers) {
                headers.forEach(header -> hb.add(visitHeader(header, context)));
            }
            ImmutableList.Builder<Option> ob = new ImmutableList.Builder<>();
            List<Option> options = node.getOptions();
            if (null != options) {
                options.forEach(option -> ob.add(visitOption(option, context)));
            }
            ImmutableList.Builder<Message> mb = new ImmutableList.Builder<>();
            List<Message> messages = node.getMessages();
            if (null != messages) {
                messages.forEach(message -> mb.add(visitMessage(message, context)));
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

            ProtoProgram program = new ProtoProgram(node.getComments(), ob.build(), hb.build(), mb.build(), eb.build(), sb.build());
            program.setOuterClassName(node.getOuterClassName());
            program.setFile(node.getFile());

            return program;
        } catch (Exception e) {
            LOG.error("Cannot resolve this program {}", node.getFile(), e);
        }
        return null;
    }
}
