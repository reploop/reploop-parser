package org.reploop.translator.json.gen;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.support.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.reploop.translator.json.support.Constants.*;
import static org.reploop.translator.json.support.NameSupport.autoImported;

public class ProtoGenerator extends AstVisitor<Node, BeanContext> {
    private static final Converter<String, String> LC_UC = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);
    private static final Logger LOG = LoggerFactory.getLogger(ProtoGenerator.class);

    private <N extends Node> List<N> visit(List<N> nodes, Function<N, N> visit) {
        return nodes.stream()
            .map(visit)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    @Override
    public Node visitNode(Node node, BeanContext context) {
        return node;
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, BeanContext context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public StringType visitStringType(StringType stringType, BeanContext context) {
        context.append("string");
        return stringType;
    }

    private void comments(List<String> comments, BeanContext context) {
        if (null != comments && !comments.isEmpty()) {
            comments.forEach(c -> context.append(c).newLine());
        }
    }

    @Override
    public StructType visitStructType(StructType structType, BeanContext context) {
        QualifiedName fqn = structType.getName();
        if (autoImported(fqn)) {
            context.append("string");
        } else {
            context.append(fqn);
        }
        return structType;
    }


    @Override
    public Option visitOption(Option option, BeanContext context) {
        return (Option) process(option, context);
    }

    @Override
    public StringValue visitStringValue(StringValue node, BeanContext context) {
        context.quote().append(node.getValue()).quote();
        return node;
    }

    @Override
    public BoolValue visitBoolValue(BoolValue node, BeanContext context) {
        context.append(String.valueOf(node.getValue()));
        return node;
    }

    @Override
    public IntValue visitIntValue(IntValue node, BeanContext context) {
        context.append(String.valueOf(node.getValue()));
        return node;
    }

    @Override
    public Value visitValue(Value node, BeanContext context) {
        return (Value) process(node, context);
    }

    @Override
    public MapType visitMapType(MapType mapType, BeanContext context) {
        context.append("map").openAngle();
        visitFieldType(mapType.getKeyType(), context);
        context.comma().whitespace();
        visitFieldType(mapType.getValueType(), context);
        context.closeAngle();
        return mapType;
    }

    @Override
    public ListType visitListType(ListType listType, BeanContext context) {
        visitFieldType(listType.getElementType(), context);
        return listType;
    }

    @Override
    public IntType visitIntType(IntType intType, BeanContext context) {
        context.append("int32");
        return intType;
    }

    @Override
    public LongType visitLongType(LongType longType, BeanContext context) {
        context.append("int64");
        return longType;
    }

    @Override
    public BoolType visitBoolType(BoolType boolType, BeanContext context) {
        context.append("bool");
        return boolType;
    }

    @Override
    public ByteStringType visitByteStringType(ByteStringType byteStringType, BeanContext context) {
        context.append("bytes");
        return byteStringType;
    }

    @Override
    public DoubleType visitDoubleType(DoubleType doubleType, BeanContext context) {
        context.append("double");
        return doubleType;
    }

    @Override
    public FloatType visitFloatType(FloatType floatType, BeanContext context) {
        context.append("float");
        return floatType;
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, BeanContext context) {
        String key = node.getKey();
        Value value = node.getValue();
        String expected = context.getExpectedKey();
        if (Strings.isNullOrEmpty(expected)) {
            context.append(key).whitespace().append(EQ).whitespace();
            visitValue(value, context);
        } else if (key.equals(expected)) {
            switch (key) {
                case IMPORT:
                    visitImport(context, key, value);
                    break;
                case EXTENDS_ATTR:
                    visitExtendsAttr(context, value);
                    break;
                case ABSTRACT_ATTR:
                    visitAbstractAttr(context, value);
                    break;
            }
        }
        return node;
    }

    private void visitImport(BeanContext context, String key, Value value) {
        context.append(key).whitespace().quote();
        QualifiedName fqn = QualifiedName.of(((StringValue) value).getValue());
        String path = String.join(DOT, fqn.join(SEP), PROTO);
        context.append(path);
        context.quote().semicolon().newLine();
    }

    private void visitAbstractAttr(BeanContext context, Value value) {
        if (value instanceof BoolValue) {
            Boolean isAbstract = ((BoolValue) value).getValue();
            if (isAbstract) {
                context.append(ABSTRACT_ATTR).whitespace();
            }
        }
    }

    private void visitExtendsAttr(BeanContext context, Value value) {
        if (value instanceof StringValue) {
            context.append(EXTENDS_ATTR).whitespace();
            visitValue(value, context);
            context.whitespace();
        }
    }

    @Override
    public Field visitField(Field node, BeanContext context) {
        comments(node.getComments(), context);
        Optional.ofNullable(node.getModifier())
            .ifPresent(modifier -> context.append(modifier.name()).whitespace());
        visitFieldType(node.getType(), context);

        String name = node.getName();
        List<Option> nodeOptions = node.getOptions();
        for (Option option : nodeOptions) {
            if (option instanceof CommonPair && ORIGINAL_NAME.equals(((CommonPair) option).getKey())) {
                Value value = ((CommonPair) option).getValue();
                if (value instanceof StringValue) {
                    name = ((StringValue) value).getValue();
                }
            }
        }
        context.whitespace().append(name).whitespace().append(Constants.EQ).whitespace().append(String.valueOf(node.getIndex()));
        context.semicolon().newLine();
        return node;
    }

    @Override
    public EnumField visitEnumField(EnumField node, BeanContext context) {
        comments(node.getComments(), context);
        context.append(node.getName()).whitespace().append(EQ).whitespace().append(String.valueOf(node.getIndex())).semicolon().newLine();
        return node;
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, BeanContext context) {
        context.append("enum").whitespace().append(node.getName().suffix()).openBrace().newLine();
        visitIfPresent(node.getFields(), enumField -> visitEnumField(enumField, context));
        context.closeParen().semicolon().newLine();
        return node;
    }


    @Override
    public SyntaxPair visitSyntaxPair(SyntaxPair node, BeanContext context) {
        context.append(node.getKey()).whitespace().append(EQ).whitespace();
        visitValue(node.getValue(), context);
        context.semicolon().newLine();
        return node;
    }

    @Override
    public OptionPair visitOptionPair(OptionPair node, BeanContext context) {
        context.append("option").whitespace().append(node.getName()).whitespace().append(EQ).whitespace();
        visitValue(node.getValue(), context);
        context.semicolon().newLine();
        return node;
    }

    @Override
    public Extend visitExtend(Extend node, BeanContext context) {
        visitImport(context, IMPORT, new StringValue("google.protobuf.descriptor"));
        context.append("extend").whitespace().append(node.getName()).whitespace().openBrace().indent().newLine();
        visitIfPresent(node.getFields(), field -> visitField(field, context));
        context.dedent().newLine().closeBrace().newLine();
        return node;
    }

    public void visitExtend(Message node, BeanContext context) {
        var pairs = node.getFields().stream()
            .map(Field::getOptions)
            .flatMap(Collection::stream)
            .filter(o -> o instanceof CommonPair)
            .map(o -> (CommonPair) o)
            .collect(Collectors.groupingBy(CommonPair::getKey, Collectors.reducing(null, new BinaryOperator<CommonPair>() {
                @Override
                public CommonPair apply(CommonPair pair1, CommonPair pair2) {
                    if (null != pair1) {
                        return pair1;
                    }
                    return pair2;
                }
            })));
        if (!pairs.isEmpty()) {
            QualifiedName eqn = QualifiedName.of("google.protobuf.FieldOptions");
            var fb = ImmutableList.<Field>builder();
            int index = 1;
            for (CommonPair pair : pairs.values()) {
                Value value = pair.getValue();
                FieldType type;
                if (value instanceof StringValue) {
                    type = new StringType();
                } else if (value instanceof BoolValue) {
                    type = new BoolType();
                } else if (value instanceof IntValue) {
                    type = new IntType();
                } else if (value instanceof LongValue) {
                    type = new LongType();
                } else if (value instanceof FloatValue) {
                    type = new FloatType();
                } else if (value instanceof DoubleValue) {
                    type = new DoubleType();
                } else {
                    throw new IllegalStateException(value.toString());
                }
                FieldModifier modifier = FieldModifier.optional;
                Field field = new Field(modifier, index++, pair.getKey(), type);
                fb.add(field);
            }
            Extend extend = new Extend(eqn, fb.build());
            visitExtend(extend, context);
        }
    }

    @Override
    public Namespace visitNamespace(Namespace node, BeanContext context) {
        context.append("package").whitespace().append(node.getName()).semicolon().newLine();
        return node;
    }

    @Override
    public Header visitHeader(Header node, BeanContext context) {
        return (Header) process(node, context);
    }

    @Override
    public ProtoProgram visitProtobufProgram(ProtoProgram node, BeanContext context) {
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        visitIfPresent(node.getHeaders(), header -> visitHeader(header, context));
        visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        return node;
    }

    @Override
    public Message visitMessage(Message node, BeanContext context) {
        QualifiedName name = node.getName();
        context.setExpectedKey(IMPORT);
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.clearExpectedKey();

        context.append("message").whitespace().append(name.suffix()).whitespace().openBrace().indent().newLine();
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        context.dedent().newLine().closeBrace();
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        List<Enumeration> enumerations = visitIfPresent(node.getEnumerations(), enumeration -> visitEnumeration(enumeration, context));
        return new Message(name, node.getComments(), fields, messages, enumerations, node.getServices(), node.getOptions());
    }
}
