package org.reploop.translator.json.gen;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.translator.json.bean.BeanContext;
import org.reploop.translator.json.bean.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.reploop.translator.json.support.Constants.*;

public class BeanGenerator extends AstVisitor<Node, BeanContext> {
    private static final Logger LOG = LoggerFactory.getLogger(BeanGenerator.class);
    private static final Converter<String, String> LC_UC = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);

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
        context.append(fieldType.toString());
        return fieldType;
    }

    private void comments(List<String> comments, BeanContext context) {
        if (null != comments && comments.size() > 0) {
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
        if (EXTENDS_ATTR.equals(context.getExpectedKey())) {
            context.setSuperClass(QualifiedName.of(node.getValue()));
        }
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
        context.append(key).whitespace();
        visitValue(value, context);
        context.semicolon().newLine();
    }

    private void visitAbstractAttr(BeanContext context, Value value) {
        if (value instanceof BoolValue) {
            Boolean isAbstract = ((BoolValue) value).getValue();
            if (isAbstract) {
                context.setAbstractClass(true);
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

    private void accessor(List<Field> fields, BeanContext context) {
        for (Field field : fields) {
            if (fromParent(field)) {
                LOG.info("Do NOT generate getter and setter for a field from it's parent class {}.", context.getName());
                continue;
            }
            getter(field, context);
            setter(field, context);
        }
    }

    private boolean fromParent(Field field) {
        boolean parent = false;
        var options = field.getOptions();
        for (Option option : options) {
            if (option instanceof CommonPair && PARENT_TAG.equals(((CommonPair) option).getKey())) {
                Value value = ((CommonPair) option).getValue();
                if (value instanceof BoolValue) {
                    parent = ((BoolValue) value).getValue();
                    if (parent) {
                        break;
                    }
                }
            }
        }
        return parent;
    }

    private void getter(Field node, BeanContext context) {
        context.newLine().append("public").whitespace();
        visitFieldType(node.getType(), context);
        context.whitespace().append("get").append(LC_UC.convert(node.getName())).openParen().closeParen().whitespace().openBrace().indent().newLine();
        context.append("return").whitespace().append(node.getName()).semicolon().dedent().newLine();
        context.closeBrace().newLine();
    }

    private void setter(Field node, BeanContext context) {
        context.newLine().append("public").whitespace().append("void").whitespace().append("set").append(LC_UC.convert(node.getName())).openParen();
        visitFieldType(node.getType(), context);
        context.whitespace().append(node.getName()).closeParen().whitespace().openBrace().indent().newLine();
        context.append("this.").append(node.getName()).append(" = ").append(node.getName()).semicolon().dedent().newLine();
        context.closeBrace().newLine();
    }

    private void toString(List<Field> fields, BeanContext context) {
        context.newLine().append("@Override").newLine();
        context.append("public").whitespace().append("String").whitespace().append("toString").openParen().closeParen().whitespace().openBrace().indent().newLine();
        context.append("return").whitespace().append("MoreObjects.toStringHelper(this)").indent().indent().newLine();
        for (Field field : fields) {
            context.append(".add").openParen().quote().append(field.getName()).quote().append(",").whitespace().append("get").append(LC_UC.convert(field.getName())).openParen().closeParen().closeParen().newLine();
        }
        context.append(".toString()").semicolon().dedent().dedent().dedent().newLine();
        context.closeBrace().newLine();
    }

    @Override
    public Field visitField(Field node, BeanContext context) {
        if (fromParent(node)) {
            return node;
        }
        comments(node.getComments(), context);
        var options = node.getOptions();
        Map<String, String> keyMap = new LinkedHashMap<>();
        keyMap.put(DATE_PATTERN, "pattern");
        keyMap.put(DATE_TIMEZONE, "timezone");
        Map<String, Value> valueMap = new HashMap<>();
        for (Option option : options) {
            if (option instanceof CommonPair) {
                String key = ((CommonPair) option).getKey();
                Value value = ((CommonPair) option).getValue();
                switch (key) {
                    case DATE_PATTERN:
                    case DATE_TIMEZONE:
                        valueMap.put(key, value);
                        break;
                    case ORIGINAL_NAME:
                        context.append("@JsonProperty(\"");
                        visitValue(value, context);
                        context.append("\")").newLine();
                        break;
                }
            }
        }
        if (!valueMap.isEmpty()) {
            boolean first = true;
            context.append("@JsonFormat").openParen();
            for (Map.Entry<String, String> entry : keyMap.entrySet()) {
                String key = entry.getKey();
                String name = entry.getValue();
                Value value = valueMap.get(key);
                if (null != value) {
                    if (first) {
                        first = false;
                        context.comma().whitespace();
                    }
                    context.append(key).append("=\"");
                    visitValue(value, context);
                    context.append("\"");
                }
            }
            context.closeParen().newLine();
        }
        context.append("private").whitespace();
        visitFieldType(node.getType(), context);
        context.whitespace().append(node.getName()).semicolon().newLine();
        return node;
    }

    public void builder(Message message, List<Field> fields, BeanContext context) {
        String name = message.getName().suffix();
        String builderName = name + "Builder";
        // static builder method.
        // We allow a class inherits  from the other class which is either concrete or abstract class.
        // So we just generate a different build method name in case of method signature conflicts.
        context.newLine();
        context.append("public static Builder new").append(builderName).append("()").whitespace().openBrace();
        context.indent().newLine();
        context.append("return new Builder();");
        context.dedent().newLine().closeBrace().newLine();

        // Start define builder class
        context.newLine();
        context.append("public static class Builder").whitespace().openBrace();
        // start class body
        context.indent().newLine();
        String attr = "data";
        context.append("private final").whitespace().append(name).whitespace().append(attr).append(" = new ").append(name).append("();").newLine();

        // build method for each field.
        // Include parent class's fields by default.
        for (Field field : fields) {
            context.newLine();
            context.append("public Builder ").append(field.getName()).openParen();
            visitFieldType(field.getType(), context);
            context.whitespace().append(field.getName()).closeParen().whitespace().openBrace();
            context.indent().newLine();
            String fieldName = field.getName();
            if (attr.equals(fieldName)) {
                context.append("this.");
            }
            context.append("data.").append("set").append(LC_UC.convert(fieldName)).openParen().append(fieldName).closeParen().semicolon().newLine();
            context.append("return this;");
            context.dedent().newLine().closeBrace().newLine();
        }

        // the build method.
        context.newLine();
        context.append("public").whitespace().append(message.getName().suffix()).whitespace().append("build()").whitespace().openBrace();
        context.indent().newLine();
        context.append("return data;");
        context.dedent().newLine().closeBrace().newLine();
        // end class body
        context.dedent().newLine().closeBrace().newLine();
    }

    @Override
    public Message visitMessage(Message node, BeanContext context) {
        MessageContext ctx = new MessageContext();
        QualifiedName name = node.getName();
        name.prefix().ifPresent(ns -> context.append("package").whitespace().append(ns).semicolon().newLine().newLine());
        // Options
        context.setExpectedKey(IMPORT);
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.clearExpectedKey();

        comments(node.getComments(), context);
        context.append("public").whitespace();
        context.setExpectedKey(ABSTRACT_ATTR);
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.clearExpectedKey();

        context.append("class").whitespace().append(name.suffix()).whitespace();
        context.setExpectedKey(EXTENDS_ATTR);
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.clearExpectedKey();

        context.append("implements Serializable").whitespace().openBrace().indent().newLine();
        context.append("private static final long serialVersionUID = 1L;").newLine();

        List<Message> messages = visit(node.getMessages(), m -> visitMessage(m, context));
        List<Field> fields = visit(node.getFields(), n -> visitField(n, context));
        // Getters and setters
        accessor(fields, context);

        // Generate a default String toString() implements.
        toString(fields, context);

        // Generate builder pattern code
        if (!context.isAbstractClass()) {
            builder(node, fields, context);
        }
        context.dedent().newLine().closeBrace().newLine();
        return new Message(name, node.getComments(), fields, messages, node.getEnumerations(), null, node.getOptions());
    }
}
