package com.qiyi.walle.translator.json;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.parser.protobuf.type.ListType;
import org.reploop.parser.protobuf.type.StructType;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MessageDuplicateResolver extends AstVisitor<Node, JsonMessageContext> {
    @Override
    public Node visitNode(Node node, JsonMessageContext context) {
        return node;
    }

    private <N extends Node> List<N> visit(List<N> nodes, Function<N, N> visit) {
        return nodes.stream()
            .map(visit)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, JsonMessageContext context) {
        return (FieldType) process(fieldType, context);
    }

    private QualifiedName resolve(QualifiedName name, JsonMessageContext context) {
        QualifiedName qn = context.dup(name).orElse(name);
        if (null != context.getNamespace() && !qn.endsWith("Object")) {
            qn = QualifiedName.of(context.getNamespace(), qn);
        }
        return qn;
    }

    @Override
    public Message visitMessage(Message node, JsonMessageContext context) {
        List<Field> fields = visit(node.getFields(), n -> visitField(n, context));
        List<Message> messages = visit(node.getMessages(), m -> visitMessage(m, context));
        QualifiedName qn = resolve(node.getName(), context);
        return new Message(qn, node.getComments(), fields, messages, node.getEnumerations(), node.getOptions());
    }

    @Override
    public StructType visitStructType(StructType structType, JsonMessageContext context) {
        QualifiedName qn = resolve(structType.getName(), context);
        return new StructType(qn);
    }

    @Override
    public Field visitField(Field node, JsonMessageContext context) {
        FieldType type = visitFieldType(node.getType(), context);
        return new Field(node.getModifier(), node.getIndex(), node.getName(), type, node.getValue(), node.getComments());
    }

    @Override
    public ListType visitListType(ListType listType, JsonMessageContext context) {
        FieldType type = visitFieldType(listType.getElementType(), context);
        return new ListType(type);
    }
}
