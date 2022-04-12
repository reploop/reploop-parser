package org.reploop.translator.json.driver;

import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.EnumField;
import org.reploop.parser.protobuf.tree.Enumeration;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.translator.json.bean.IndexContext;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MessageIndexSorter extends AstVisitor<Node, IndexContext> {
    @Override
    public Node visitNode(Node node, IndexContext context) {
        return node;
    }

    @Override
    public Field visitField(Field node, IndexContext context) {
        return new Field(node.getModifier(), context.getAndIncrement(), node.getName(), node.getType(), node.getValue(), node.getComments(), node.getOptions());
    }

    @Override
    public EnumField visitEnumField(EnumField node, IndexContext context) {
        return new EnumField(node.getComments(), node.getName(), context.getAndIncrement());
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, IndexContext context) {
        List<EnumField> fields = node.getFields();
        fields = fields.stream().sorted(Comparator.comparing(EnumField::getName)).collect(Collectors.toList());
        fields = visitIfPresent(fields, field -> visitEnumField(field, context));
        return new Enumeration(node.getName(), node.getComments(), fields);
    }

    @Override
    public Message visitMessage(Message node, IndexContext context) {
        List<Field> fields = node.getFields();
        fields = fields.stream().sorted(Comparator.comparing(Field::getName)).collect(Collectors.toList());
        List<Field> ordered = visitIfPresent(fields, field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, new IndexContext()));
        List<Enumeration> enumerations = visitIfPresent(node.getEnumerations(), enumeration -> visitEnumeration(enumeration, new IndexContext()));
        return new Message(node.getName(), node.getComments(), ordered, messages, enumerations, node.getServices(), node.getOptions());

    }
}
