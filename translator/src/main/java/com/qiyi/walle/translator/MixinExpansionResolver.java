package com.qiyi.walle.translator;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.qiyi.walle.parser.Classpath;
import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.protobuf.tree.*;
import com.qiyi.walle.parser.protobuf.tree.Entity;
import com.qiyi.walle.parser.protobuf.tree.Enumeration;
import com.qiyi.walle.parser.protobuf.type.*;
import org.reploop.parser.thrift.AstVisitor;
import com.qiyi.walle.parser.thrift.Node;
import com.qiyi.walle.parser.thrift.generator.GeneratorContext;
import com.qiyi.walle.parser.thrift.tree.*;
import com.qiyi.walle.parser.thrift.tree.Field;
import com.qiyi.walle.parser.thrift.tree.Function;
import com.qiyi.walle.parser.thrift.tree.IntValue;
import com.qiyi.walle.parser.thrift.tree.Service;
import com.qiyi.walle.parser.thrift.tree.StringValue;
import com.qiyi.walle.parser.thrift.tree.StructValue;
import com.qiyi.walle.parser.thrift.tree.Value;
import com.qiyi.walle.parser.thrift.type.CollectionType;
import com.qiyi.walle.parser.thrift.type.FieldType;
import com.qiyi.walle.parser.thrift.type.StructType;
import com.qiyi.walle.parser.thrift.type.WrapperType;

import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-09-30 14
 */
public class MixinExpansionResolver extends AstVisitor<Node, Classpath<ThriftProgram>> {

    private final Classpath<ProtoProgram> cpp;

    public MixinExpansionResolver(Classpath<ProtoProgram> cpp) {
        this.cpp = cpp;
    }

    @Override
    public Node visitNode(Node node, Classpath<ThriftProgram> context) {
        return node;
    }

    private Optional<Entity> search(List<Entity> entities,
                                    QualifiedName name) {
        if (null != entities) {
            for (Entity entity : entities) {
                if (null == entity) {
                    continue;
                }
                if (entity.getName().equals(name)) {
                    return Optional.of(entity);
                }
                if (entity instanceof Message) {
                    Message message = (Message) entity;
                    List<Entity> nest = entities(message, Message::getMessages, Message::getEnumerations);
                    Optional<Entity> optional = search(nest, name);
                    if (optional.isPresent()) {
                        return optional;
                    }
                }
            }
        }
        return Optional.empty();
    }

    java.util.function.Function<Entity, List<Entity>> flat = entity -> {
        List<Entity> entities = new ArrayList<>();
        if (entity instanceof Message) {
            List<Message> messageList = ((Message) entity).getMessages();
            if (null != messageList) {
                entities.addAll(messageList);
            }
            List<Enumeration> enumerations = ((Message) entity).getEnumerations();
            if (null != enumerations) {
                entities.addAll(enumerations);
            }
        }
        return entities;
    };

    public <E> List<Entity> entities(E entity, java.util.function.Function<E, List<Message>> mp,
                                     java.util.function.Function<E, List<Enumeration>> ep) {
        List<Entity> entities = new ArrayList<>();
        List<Message> messages = mp.apply(entity);
        if (null != messages) {
            entities.addAll(messages);
        }
        List<Enumeration> enumerations = ep.apply(entity);
        if (null != enumerations) {
            entities.addAll(enumerations);
        }
        return entities;
    }

    private Optional<Entity> search(ProtoProgram program, QualifiedName name) {
        List<Entity> entities = entities(program, ProtoProgram::getMessages, ProtoProgram::getEnumerations);
        return search(entities, name);
    }

    public Optional<Entity> search(FieldType fieldType) {
        return search(fieldType.getName());
    }

    public Optional<Entity> search(QualifiedName name) {
        Optional<Path> path = cpp.names()
                .entrySet()
                .stream()
                .filter(entry -> {
                    Set<QualifiedName> names = entry.getValue();
                    return null != names && names.contains(name);
                }).map(Map.Entry::getKey)
                .findAny();
        if (path.isPresent()) {
            ProtoProgram program = cpp.entity(path.get());
            if (null != program) {
                return search(program, name);
            }
        }
        return Optional.empty();
    }

    private QualifiedName suffix = QualifiedName.of("knowledge.pub.Common.User");
    private Comparator<Field> comparator = (f1, f2) -> {
        FieldType ft1 = f1.getFieldType();
        FieldType ft2 = f2.getFieldType();
        boolean fb1 = ft1.getName().endsWith(suffix);
        boolean fb2 = ft2.getName().endsWith(suffix);
        int c = 0;
        if (fb1 && fb2) {
            c = 0;
        } else if (fb1) {
            c = 1;
        } else if (fb2) {
            c = -1;
        }
        if (0 == c) {
            c = Boolean.compare(f2.isRequired(), f1.isRequired());
        }
        return c;
    };

    private List<Field> adapt(List<com.qiyi.walle.parser.protobuf.tree.Field> from) {
        return from.stream()
                .map(this::adapt)
                .filter(Objects::nonNull)
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private List<QualifiedName> exceptions = new ArrayList<>();

    {
        exceptions.add(QualifiedName.of("knowledge.pub.Common.RpcStatus"));
        exceptions.add(QualifiedName.of("knowledge.pub.Common.RpcStatusInfo"));
    }

    private FieldType adapt(com.qiyi.walle.parser.protobuf.type.FieldType from) {
        QualifiedName name = from.getName();
        for (QualifiedName qn : exceptions) {
            if (name.endsWith(qn)) {
                return null;
            }
        }
        if (from instanceof com.qiyi.walle.parser.protobuf.type.StructType) {
            return new StructType(from.getName());
        } else if (from instanceof ListType) {
            return new com.qiyi.walle.parser.thrift.type.ListType(adapt(((ListType) from).getElementType()));
        } else if (from instanceof LongType) {
            return new com.qiyi.walle.parser.thrift.type.LongType();
        } else if (from instanceof IntType) {
            return new com.qiyi.walle.parser.thrift.type.IntType();
        } else if (from instanceof StringType) {
            return new com.qiyi.walle.parser.thrift.type.StringType();
        } else if (from instanceof BoolType) {
            return new com.qiyi.walle.parser.thrift.type.BoolType();
        } else if (from instanceof SetType) {
            return new com.qiyi.walle.parser.thrift.type.SetType(adapt(((SetType) from).getElementType()));
        } else if (from instanceof ByteType) {
            return new com.qiyi.walle.parser.thrift.type.ByteType();
        } else if (from instanceof ShortType) {
            return new com.qiyi.walle.parser.thrift.type.ShortType();
        } else if (from instanceof DoubleType) {
            return new com.qiyi.walle.parser.thrift.type.DoubleType();
        } else if (from instanceof FloatType) {
            return new com.qiyi.walle.parser.thrift.type.FloatType();
        } else if (from instanceof ByteStringType) {
            return new WrapperType(from.getName());
        }
        throw new IllegalArgumentException(from.toString());
    }

    private Optional<Value> adapt(com.qiyi.walle.parser.protobuf.tree.Value value) {
        Value val = null;
        if (null != value) {
            if (value instanceof com.qiyi.walle.parser.protobuf.tree.IntValue) {
                val = new IntValue(((com.qiyi.walle.parser.protobuf.tree.IntValue) value).getValue());
            } else if (value instanceof com.qiyi.walle.parser.protobuf.tree.StringValue) {
                val = new StringValue(((com.qiyi.walle.parser.protobuf.tree.StringValue) value).getValue());
            } else if (value instanceof BoolValue) {
                val = new BooleanValue(((BoolValue) value).getValue());
            } else if (value instanceof com.qiyi.walle.parser.protobuf.tree.StructValue) {
                val = new StructValue(((com.qiyi.walle.parser.protobuf.tree.StructValue) value).getName());
            }
        }
        return Optional.ofNullable(val);
    }

    private Field adapt(com.qiyi.walle.parser.protobuf.tree.Field from) {
        FieldType type = adapt(from.getType());
        if (null != type) {
            if (from.getName().equals("code")
                    && type instanceof com.qiyi.walle.parser.thrift.type.StringType) {
                return null;
            }
            Integer index = from.getIndex();
            FieldModifier md = from.getModifier();
            boolean required = md == FieldModifier.required;
            if (md == FieldModifier.repeated) {
                if (type instanceof com.qiyi.walle.parser.thrift.type.IntType
                        || type instanceof com.qiyi.walle.parser.thrift.type.LongType) {
                    required = true;
                }
                type = new com.qiyi.walle.parser.thrift.type.ListType(type);
            }
            Optional<com.qiyi.walle.parser.protobuf.tree.Value> value = from.getValue();
            Optional<Value> val = adapt(value.orElse(null));
            return new Field(from.getComments(), type, index, from.getName(), required, val);
        }
        return null;
    }

    private List<Field> fields(Optional<Entity> entity) {
        if (entity.isPresent()) {
            Entity e = entity.get();
            if (e instanceof Message) {
                Message message = (Message) e;
                return adapt(message.getFields());
            }
        }
        return Collections.emptyList();
    }

    private FunctionType convert(FunctionType ft, Field field) {
        if (ft instanceof ReturnType) {
            return new ReturnType(field.getFieldType());
        } else if (ft instanceof VoidType) {
            return ft;
        }
        throw new IllegalArgumentException(ft.toString());
    }

    /**
     * Function overload. Keep the response and function name same with original function, but parameters are different.
     *
     * @param node      the original function
     * @param arguments expanded arguments
     * @return all functions.
     */
    private List<Function> requestExpanse(Function node, List<Field> arguments, int least) {
        List<Function> functions = new ArrayList<>();
        Function newFunc = new Function(node.getComments(), node.isOneWay(), node.getName(), node.getReturnType(), arguments, node.getExceptions());
        StringBuilder body = getBody(Iterables.getOnlyElement(node.getParameters()), newFunc);
        newFunc.setBody(body.toString());
        functions.add(newFunc);
        functions.addAll(over(newFunc, arguments, least));
        return functions;
    }

    private List<Function> over(Function node, List<Field> arguments, int least) {
        List<Function> functions = new ArrayList<>();
        Function newFunc;
        StringBuilder body;
        int len = arguments.size();
        for (int i = least + 1; i < len; i++) {
            int lastIdx = len - i;
            Field last = arguments.get(lastIdx);
            List<Field> params = arguments.subList(0, lastIdx);
            newFunc = new Function(node.getComments(), node.isOneWay(), node.getName(), node.getReturnType(), params, node.getExceptions());
            body = getBody(newFunc, last);
            newFunc.setBody(body.toString());

            functions.add(newFunc);
        }
        return functions;
    }

    private List<Function> responseExpanse(Function node, List<Field> results, List<Field> arguments, int least) {
        List<Function> functions = new ArrayList<>();
        for (Field result : results) {
            Optional<QualifiedName> prefix = node.getName().prefix();
            String suffix = node.getName().suffix();
            suffix += CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, result.getName().suffix());
            QualifiedName name = QualifiedName.of(prefix, suffix);
            FunctionType type = convert(node.getReturnType(), result);
            Function newFunc = new Function(node.getComments(), node.isOneWay(), name, type, arguments, node.getExceptions());
            StringBuilder body = proxy(node, result, arguments);
            newFunc.setBody(body.toString());
            functions.add(newFunc);
            functions.addAll(over(newFunc, arguments, least));
        }
        return functions;
    }

    /**
     * We only expanse functions have exactly one parameter of struct type.
     */
    private List<Function> expanse(Function node, Classpath<ThriftProgram> context) {
        List<Field> params = node.getParameters();
        if (null == params || params.size() != 1) {
            return Collections.emptyList();
        }
        Field field = params.get(0);
        com.qiyi.walle.parser.thrift.type.FieldType fieldType = field.getFieldType();

        Optional<Entity> response = Optional.empty();
        FunctionType ft = node.getReturnType();
        if (ft instanceof ReturnType) {
            response = search(((ReturnType) ft).getFieldType());
        }
        List<Field> results = fields(response);

        Optional<Entity> request = search(fieldType);
        List<Field> arguments = fields(request);

        if (arguments.size() > 0 && results.size() > 0) {
            List<Function> functions = new ArrayList<>();
            int least = 0;
            for (int i = 0; i < arguments.size(); i++) {
                Field arg = arguments.get(i);
                FieldType at = arg.getFieldType();
                if (arg.isRequired() && !at.getName().endsWith(suffix)) {
                    least = i;
                }
            }
            functions.addAll(requestExpanse(node, arguments, least));
            functions.addAll(responseExpanse(node, results, arguments, least));
            return functions;
        }
        return Collections.emptyList();
    }

    private static final String NEW_LINE = "\r\n";
    private static final String WHITE_SPACE = " ";

    private String type(QualifiedName name) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, name.suffix());
    }

    private StringBuilder indent(StringBuilder content) {
        return indent(content, 4);
    }

    private StringBuilder indent(StringBuilder content, int indent) {
        for (int i = 0; i < indent; i++) {
            content.append(' ');
        }
        return content;
    }

    private void defaultValue(Field last, StringBuilder code) {
        FieldType type = last.getFieldType();
        if (type.getName().suffix().equals("User")) {
            code.append("getUser()");
        } else {
            if (type instanceof com.qiyi.walle.parser.thrift.type.BoolType) {
                Value value = last.getValue().orElse(new BooleanValue(false));
                code.append(value);
            } else if (type instanceof com.qiyi.walle.parser.thrift.type.IntType) {
                Value value = last.getValue().orElse(new IntValue(0));
                code.append(value);
            } else if (type instanceof com.qiyi.walle.parser.thrift.type.LongType) {
                Value value = last.getValue().orElse(new IntValue(0));
                code.append(value).append("L");
            } else if (type instanceof com.qiyi.walle.parser.thrift.type.ListType) {
                FieldType ft = ((com.qiyi.walle.parser.thrift.type.ListType) type).getElementType();
                code.append("Collections.<").append(ft.getName()).append(">emptyList()");
            } else if (type instanceof com.qiyi.walle.parser.thrift.type.StringType) {
                code.append("\"\"");
            } else if (type instanceof StructType || type instanceof WrapperType) {
                Optional<Value> value = last.getValue();
                if (value.isPresent()) {
                    code.append(type.getName()).append(".").append(value.get());
                } else {
                    code.append("null");
                }
            }
        }
    }

    private StringBuilder getBody(Function node, Field last) {
        GeneratorContext gc = new GeneratorContext();
        MixinCodeGenerator mcg = new MixinCodeGenerator(null, null);
        StringBuilder bb = mcg.visitLiteralNode(new LiteralNode("return "), gc);
        bb.append(node.getName()).append("(");
        for (Field p : node.getParameters()) {
            bb.append(p.getName()).append(", ");
        }
        defaultValue(last, bb);
        bb.append(");").append(NEW_LINE);
        return bb;
    }

    private StringBuilder getBody(Field request, Function f) {
        GeneratorContext gc = new GeneratorContext();
        MixinCodeGenerator mcg = new MixinCodeGenerator(null, null);
        List<Field> params = f.getParameters();
        StringBuilder bb = buildRequest(request, params, gc, mcg);
        bb.append("return ").append(f.getName()).append("(").append(request.getName()).append(");").append(NEW_LINE);
        return bb;
    }

    private StringBuilder buildRequest(Field request, List<Field> params, GeneratorContext gc, MixinCodeGenerator mcg) {
        StringBuilder bb = mcg.visitFieldType(request.getFieldType(), gc);
        bb.append(WHITE_SPACE).append(request.getName()).append(WHITE_SPACE).append("=").append(WHITE_SPACE);
        mcg.visitFieldType(request.getFieldType(), gc).append(".newBuilder()").append(NEW_LINE);
        gc.indent();
        for (Field p : params) {
            String op;
            FieldType pft = p.getFieldType();
            if (pft instanceof CollectionType) {
                op = ".addAll";
            } else {
                op = ".set";
            }
            LiteralNode ln = new LiteralNode(op);
            mcg.visitLiteralNode(ln, gc);
            bb.append(type(p.getName())).append("(").append(p.getName()).append(")").append(NEW_LINE);
        }
        mcg.visitLiteralNode(new LiteralNode(".build();"), gc).append(NEW_LINE);
        gc.dedent();
        return bb;
    }

    private StringBuilder proxy(Function node, Field result, List<Field> params) {
        GeneratorContext gc = new GeneratorContext();
        MixinCodeGenerator mcg = new MixinCodeGenerator(null, null);

        StringBuilder bb = mcg.visitFunctionType(node.getReturnType(), gc);
        bb.append(WHITE_SPACE).append("response").append(WHITE_SPACE).append("=").append(WHITE_SPACE);
        bb.append(node.getName()).append("(");
        String sep = ", ";
        for (int i = 0; i < params.size(); i++) {
            if (0 != i) {
                bb.append(sep);
            }
            bb.append(params.get(i).getName());
        }
        bb.append(");").append(NEW_LINE);

        String fieldName = type(result.getName());
        mcg.visitLiteralNode(new LiteralNode("return response.get"), gc).append(fieldName);
        if (result.getFieldType() instanceof com.qiyi.walle.parser.thrift.type.ListType) {
            bb.append("List");
        }
        bb.append("();").append(NEW_LINE);
        return bb;
    }

    @Override
    public com.qiyi.walle.parser.thrift.tree.Entity visitEntity(com.qiyi.walle.parser.thrift.tree.Entity node, Classpath<ThriftProgram> context) {
        return (com.qiyi.walle.parser.thrift.tree.Entity) process(node, context);
    }

    @Override
    public Service visitService(Service node, Classpath<ThriftProgram> context) {
        List<Function> fb = new ArrayList<>();
        List<Function> functions = node.getFunctions();
        if (null != functions) {
            // #1 Add all functions
            fb.addAll(functions);
            // #2 Try to expanse the parameters.
            functions.stream()
                    .map(f -> expanse(f, context))
                    .flatMap(Collection::stream)
                    .filter(Objects::nonNull)
                    .forEach(fb::add);
        }
        Collections.sort(fb);
        return new Service(node.getName(), node.getComments(), fb);
    }

    StringBuilder content;

    @Override
    public ThriftProgram visitProgram(ThriftProgram node, Classpath<ThriftProgram> context) {
        ImmutableList.Builder<com.qiyi.walle.parser.thrift.tree.Entity> eb = new ImmutableList.Builder<>();
        List<com.qiyi.walle.parser.thrift.tree.Entity> entities = node.getEntities();
        if (null != entities) {
            entities.forEach(entity -> eb.add(visitEntity(entity, context)));
        }
        ThriftProgram program = new ThriftProgram(node.getComments(), node.getHeaders(), eb.build());
        program.setFile(node.getFile());
        return program;
    }
}
