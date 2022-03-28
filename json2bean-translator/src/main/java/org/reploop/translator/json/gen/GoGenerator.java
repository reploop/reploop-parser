package org.reploop.translator.json.gen;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import org.apache.commons.lang3.StringUtils;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.translator.json.bean.BeanContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.reploop.translator.json.support.Constants.*;

public class GoGenerator extends AstVisitor<Node, BeanContext> {
    private static Logger LOG = LoggerFactory.getLogger(GoGenerator.class);

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

    private static final Converter<String, String> LC_UC = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.UPPER_CAMEL);

    private void accessor(List<Field> fields, BeanContext context) {
        for (Field field : fields) {
            getter(field, context);
            setter(field, context);
        }
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
            context.append(".add").openParen().quote().append(field.getName()).quote().append(",").whitespace().append(field.getName()).closeParen().newLine();
        }
        context.append(".toString()").semicolon().dedent().dedent().dedent().newLine();
        context.closeBrace().newLine();
    }

    @Override
    public Field visitField(Field node, BeanContext context) {
        comments(node.getComments(), context);
        context.append("private").whitespace();
        visitFieldType(node.getType(), context);
        context.whitespace().append(node.getName()).semicolon().newLine();
        return node;
    }

    public void builder(Message message, List<Field> fields, BeanContext context) {
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
        String attr = "data";
        context.append("private final").whitespace().append(name).whitespace().append(attr).append(" = new ").append(name).append("();").newLine();

        // build method for each field.
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
        QualifiedName name = node.getName();
        name.prefix().ifPresent(ns -> context.append("package").whitespace().append(ns).semicolon().newLine().newLine());
        // Options
        context.setExpectedKey(IMPORT);
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.append("import com.fasterxml.jackson.annotation.JsonIgnoreProperties;").newLine();
        context.append("import java.io.Serializable;").newLine();
        context.append("import com.google.common.base.MoreObjects;").newLine().newLine();
        comments(node.getComments(), context);
        context.append("public").whitespace();
        context.setExpectedKey(ABSTRACT_ATTR);
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.append("class").whitespace().append(name.suffix()).whitespace();
        context.setExpectedKey(EXTENDS_ATTR);
        visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        context.append("implements Serializable").whitespace().openBrace().indent().newLine();
        context.append("private static final long serialVersionUID = 1L;").newLine();

        List<Message> messages = visit(node.getMessages(), m -> visitMessage(m, context));
        List<Field> fields = visit(node.getFields(), n -> visitField(n, context));
        accessor(fields, context);

        boolean isAbstract = isAbstract(node);
        QualifiedName pqn = getParentInfo(node);

        toString(fields, context);
        //builder(node, fields, context);

        context.dedent().newLine().closeBrace().newLine();
        return new Message(name, node.getComments(), fields, messages, node.getEnumerations(), null, node.getOptions());
    }

    private String strip(String value) {
        String v = StringUtils.stripStart(value, IMPORT);
        return StringUtils.stripEnd(v.trim(), SEMICOLON);
    }

    private QualifiedName getParentInfo(Message node) {
        BeanContext extendContext = new BeanContext(node.getName());
        extendContext.setExpectedKey(EXTENDS_ATTR);
        visitIfPresent(node.getOptions(), option -> visitOption(option, extendContext));
        String parentInfo = extendContext.toString();
        int i;
        if ((i = parentInfo.indexOf(EXTENDS_ATTR)) >= 0) {
            String qn = parentInfo.substring(i + EXTENDS_ATTR.length()).trim();
            List<String> deps = Stream.ofNullable(node.getComments())
                    .filter(Objects::nonNull)
                    .flatMap(Collection::stream)
                    .map(this::strip)
                    .filter(dep -> dep.endsWith(qn))
                    .collect(Collectors.toList());
            if (deps.size() == 1) {
                return QualifiedName.of(deps.get(0));
            }
            LOG.warn("Maybe imports conflict: {}", qn);
            return QualifiedName.of(qn);
        }
        return null;
    }

    private boolean isAbstract(Message node) {
        BeanContext abstractContext = new BeanContext(node.getName());
        abstractContext.setExpectedKey(ABSTRACT_ATTR);
        visitIfPresent(node.getOptions(), option -> visitOption(option, abstractContext));
        return ABSTRACT_ATTR.length() <= abstractContext.toString().length();
    }
}
