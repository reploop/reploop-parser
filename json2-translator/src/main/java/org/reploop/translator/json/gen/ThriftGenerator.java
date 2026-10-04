package org.reploop.translator.json.gen;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.BoolValue;
import org.reploop.parser.protobuf.tree.CommonPair;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.FieldModifier;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.tree.Option;
import org.reploop.parser.protobuf.tree.StringValue;
import org.reploop.parser.protobuf.tree.Value;
import org.reploop.parser.protobuf.type.BoolType;
import org.reploop.parser.protobuf.type.ByteStringType;
import org.reploop.parser.protobuf.type.ByteType;
import org.reploop.parser.protobuf.type.DoubleType;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.parser.protobuf.type.FloatType;
import org.reploop.parser.protobuf.type.IntType;
import org.reploop.parser.protobuf.type.ListType;
import org.reploop.parser.protobuf.type.LongType;
import org.reploop.parser.protobuf.type.MapType;
import org.reploop.parser.protobuf.type.SetType;
import org.reploop.parser.protobuf.type.ShortType;
import org.reploop.parser.protobuf.type.StringType;
import org.reploop.parser.protobuf.type.StructType;
import org.reploop.translator.json.bean.BeanContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.reploop.translator.json.support.Constants.ABSTRACT_ATTR;
import static org.reploop.translator.json.support.Constants.DOT;
import static org.reploop.translator.json.support.Constants.EXTENDS_ATTR;
import static org.reploop.translator.json.support.Constants.IMPORT;
import static org.reploop.translator.json.support.Constants.INCLUDE;
import static org.reploop.translator.json.support.Constants.ORIGINAL_NAME;
import static org.reploop.translator.json.support.Constants.PARENT_DIR;
import static org.reploop.translator.json.support.Constants.PARENT_PATH;
import static org.reploop.translator.json.support.Constants.SEP;
import static org.reploop.translator.json.support.Constants.THRIFT;
import static org.reploop.translator.json.support.NameSupport.isObject;

public class ThriftGenerator extends AstVisitor<Node, BeanContext> {

    private static final Logger LOG = LoggerFactory.getLogger(ThriftGenerator.class);

    private <N extends Node> List<N> visit(List<N> nodes, Function<N, N> visit) {
        return nodes.stream().map(visit).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public Node visitNode(Node node, BeanContext context) {
        return node;
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, BeanContext context) {
        return (FieldType) process(fieldType, context);
    }

    private void comments(List<String> comments, BeanContext context) {
        if (null != comments && !comments.isEmpty()) {
            comments.forEach(c -> context.append(c).newLine());
        }
    }

    @Override
    public Option visitOption(Option option, BeanContext context) {
        return (Option) process(option, context);
    }

    @Override
    public StringValue visitStringValue(StringValue node, BeanContext context) {
        context.append(node.getValue());
        return node;
    }

    @Override
    public Value visitValue(Value node, BeanContext context) {
        return (Value) process(node, context);
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, BeanContext context) {
        String key = node.getKey();
        Value value = node.getValue();
        String expected = context.getExpectedKey();
        if (key.equals(expected)) {
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
        context.append(INCLUDE).whitespace().quote();
        QualifiedName fqn = QualifiedName.of(((StringValue) value).getValue());
        String path = fqn.allParts()
                .stream()
                .map(part -> PARENT_DIR.equals(part) ? PARENT_PATH : part)
                .collect(Collectors.joining(SEP));
        context.append(path).append(DOT).append(THRIFT);
        context.quote().newLine();
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
        context.append(String.valueOf(node.getIndex())).colon().whitespace();
        var modifier = Optional.ofNullable(node.getModifier()).orElse(FieldModifier.optional);
        if (modifier != FieldModifier.optional && modifier != FieldModifier.required) {
            modifier = FieldModifier.optional;
        }
        context.append(modifier.name()).whitespace();
        visitFieldType(node.getType(), context);
        String name = node.getName();
        var options = node.getOptions();
        for (var option : options) {
            if (option instanceof CommonPair) {
                String key = ((CommonPair) option).getKey();
                if (ORIGINAL_NAME.equals(key)) {
                    Value value = ((CommonPair) option).getValue();
                    name = ((StringValue) value).getValue();
                }
            }
        }
        context.whitespace().append(name).semicolon().newLine();
        return node;
    }

    @Override
    public ListType visitListType(ListType listType, BeanContext context) {
        context.append("list").openAngle();
        visitFieldType(listType.getElementType(), context);
        context.closeAngle();
        return listType;
    }

    @Override
    public IntType visitIntType(IntType intType, BeanContext context) {
        context.append("i32");
        return intType;
    }

    @Override
    public BoolType visitBoolType(BoolType boolType, BeanContext context) {
        context.append("bool");
        return boolType;
    }

    @Override
    public DoubleType visitDoubleType(DoubleType doubleType, BeanContext context) {
        context.append("double");
        return doubleType;
    }

    @Override
    public ByteType visitByteType(ByteType byteType, BeanContext context) {
        context.append("byte");
        return byteType;
    }

    @Override
    public FloatType visitFloatType(FloatType floatType, BeanContext context) {
        context.append("double");
        return floatType;
    }

    @Override
    public LongType visitLongType(LongType longType, BeanContext context) {
        context.append("i64");
        return longType;
    }

    @Override
    public ShortType visitShortType(ShortType shortType, BeanContext context) {
        context.append("i16");
        return shortType;
    }

    @Override
    public StructType visitStructType(StructType structType, BeanContext context) {
        QualifiedName fqn = structType.getName();
        if (isObject(fqn)) {
            context.append("string");
        } else
            context.append(fqn);
        return structType;
    }

    @Override
    public ByteStringType visitByteStringType(ByteStringType byteStringType, BeanContext context) {
        context.append("binary");
        return byteStringType;
    }

    @Override
    public StringType visitStringType(StringType stringType, BeanContext context) {
        context.append("string");
        return stringType;
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
    public SetType visitSetType(SetType setType, BeanContext context) {
        context.append("set").openAngle();
        visitFieldType(setType.getElementType(), context);
        context.closeAngle().whitespace();
        return setType;
    }

    @Override
    public Message visitMessage(Message node, BeanContext context) {
        QualifiedName name = node.getName();
        context.setExpectedKey(IMPORT);
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.clearExpectedKey();
        name.prefix()
                .ifPresent(prefix -> context.append("namespace")
                        .whitespace()
                        .append("*")
                        .whitespace()
                        .append(prefix)
                        .newLine());
        context.append("struct").whitespace().append(name.suffix()).whitespace().openBrace().indent().newLine();
        var fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        context.dedent().newLine().closeBrace();
        var messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        return new Message(name, node.getComments(), fields, messages, node.getEnumerations(), null, node.getOptions());
    }

}