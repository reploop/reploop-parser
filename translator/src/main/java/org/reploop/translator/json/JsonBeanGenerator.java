package org.reploop.translator.json;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.FieldType;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonBeanGenerator extends AstVisitor<Node, JsonBeanContext> {

    private <N extends Node> List<N> visit(List<N> nodes, Function<N, N> visit) {
        return nodes.stream()
                .map(visit)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public Node visitNode(Node node, JsonBeanContext context) {
        return node;
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, JsonBeanContext context) {
        context.append(fieldType.toString());
        return fieldType;
    }

    private void comments(List<String> comments, JsonBeanContext context) {
        if (null != comments && comments.size() > 0) {
            comments.forEach(c -> context.append(c).newLine());
        }
    }

    @Override
    public Option visitOption(Option option, JsonBeanContext context) {
        return (Option) process(option, context);
    }


    @Override
    public StringValue visitStringValue(StringValue node, JsonBeanContext context) {
        context.append(node.getValue());
        return node;
    }

    @Override
    public Value visitValue(Value node, JsonBeanContext context) {
        return (Value) process(node, context);
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, JsonBeanContext context) {
        String key = node.getKey();
        if (key.equals("import")) {
            context.append(key).whitespace();
            visitValue(node.getValue(), context);
            context.comma().newLine();
        }
        return node;
    }

    private static final Converter<String, String> LC_UC = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);

    private void accessor(List<Field> fields, JsonBeanContext context) {
        for (Field field : fields) {
            getter(field, context);
            setter(field, context);
        }
    }

    private void getter(Field node, JsonBeanContext context) {
        context.newLine().append("public").whitespace();
        visitFieldType(node.getType(), context);
        context.whitespace().append("get").append(LC_UC.convert(node.getName())).openParen().closeParen().whitespace().openBrace().indent().newLine();
        context.append("return").whitespace().append(node.getName()).comma().dedent().newLine();
        context.closeBrace().newLine();
    }

    private void setter(Field node, JsonBeanContext context) {
        context.newLine().append("public").whitespace().append("void").whitespace().append("set").append(LC_UC.convert(node.getName())).openParen();
        visitFieldType(node.getType(), context);
        context.whitespace().append(node.getName()).closeParen().whitespace().openBrace().indent().newLine();
        context.append("this.").append(node.getName()).append(" = ").append(node.getName()).comma().dedent().newLine();
        context.closeBrace().newLine();
    }

    private void toString(List<Field> fields, JsonBeanContext context) {
        context.newLine().append("@Override").newLine();
        context.append("public").whitespace().append("String").whitespace().append("toString").openParen().closeParen().whitespace().openBrace().indent().newLine();
        context.append("return").whitespace().append("MoreObjects.toStringHelper(this)").indent().indent().newLine();
        for (Field field : fields) {
            context.append(".add").openParen().quote().append(field.getName()).quote().append(",").whitespace().append(field.getName()).closeParen().newLine();
        }
        context.append(".toString()").comma().dedent().dedent().dedent().newLine();
        context.closeBrace().newLine();
    }

    @Override
    public Field visitField(Field node, JsonBeanContext context) {
        comments(node.getComments(), context);
        context.append("private").whitespace();
        visitFieldType(node.getType(), context);
        context.whitespace().append(node.getName()).comma().newLine();
        return node;
    }

    public void builder(Message message, List<Field> fields, JsonBeanContext context) {
        // static builder method
        context.newLine();
        context.append("public static Builder newBuilder()").whitespace().openBrace();
        context.indent().newLine();
        context.append("return new Builder();");
        context.dedent().newLine().closeBrace().newLine();

        // Start define builder class
        String name = message.getName().suffix();
        context.newLine();
        context.append("public static class Builder").whitespace().openBrace();
        // start class body
        context.indent().newLine();
        context.append("private").whitespace().append(name).whitespace().append("data = new ").append(name).append("();").newLine();

        // build method for each field.
        for (Field field : fields) {
            context.newLine();
            context.append("public Builder ").append(field.getName()).openParen();
            visitFieldType(field.getType(), context);
            context.whitespace().append(field.getName()).closeParen().whitespace().openBrace();
            context.indent().newLine();
            context.append("data.").append("set").append(LC_UC.convert(field.getName())).openParen().append(field.getName()).closeParen().comma().newLine();
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
    public Message visitMessage(Message node, JsonBeanContext context) {
        QualifiedName name = node.getName();
        name.prefix().ifPresent(ns -> context.append("package").whitespace().append(ns).comma().newLine().newLine());
        // Options
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.append("import com.fasterxml.jackson.annotation.JsonIgnoreProperties;").newLine();
        context.append("import com.fasterxml.jackson.annotation.JsonProperty;").newLine();
        context.append("import java.util.List;").newLine();
        context.append("import java.util.Map;").newLine();
        context.append("import java.io.Serializable;").newLine();
        context.append("import com.google.common.base.MoreObjects;").newLine().newLine();
        comments(node.getComments(), context);
        context.append("public").whitespace().append("class").whitespace().append(name.suffix()).whitespace().append("implements Serializable").whitespace().openBrace().indent().newLine();
        context.append("private static final long serialVersionUID = 71L;").newLine();

        List<Message> messages = visit(node.getMessages(), m -> visitMessage(m, context));
        List<Field> fields = visit(node.getFields(), n -> visitField(n, context));
        accessor(fields, context);
        toString(fields, context);

        builder(node, fields, context);

        context.dedent().newLine().closeBrace().newLine();
        return new Message(name, node.getComments(), fields, messages, node.getEnumerations(), node.getOptions());
    }
}
