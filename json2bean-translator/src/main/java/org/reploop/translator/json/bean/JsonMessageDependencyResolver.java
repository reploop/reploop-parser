package org.reploop.translator.json.bean;

import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.Enumeration;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.*;

import java.util.List;

public class JsonMessageDependencyResolver extends AstVisitor<Node, JsonMessageContext> {
    @Override
    public Node visitNode(Node node, JsonMessageContext context) {
        return node;
    }

    @Override
    public StructType visitStructType(StructType structType, JsonMessageContext context) {
        context.addDependency(structType.getName());
        return structType;
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, JsonMessageContext context) {
        context.addDependency(node.getName());
        return node;
    }

    @Override
    public MapType visitMapType(MapType mapType, JsonMessageContext context) {
        FieldType key = visitFieldType(mapType.getKeyType(), context);
        FieldType val = visitFieldType(mapType.getValueType(), context);
        return new MapType(key, val);
    }

    @Override
    public ListType visitListType(ListType listType, JsonMessageContext context) {
        return new ListType(visitFieldType(listType.getElementType(), context));
    }

    @Override
    public SetType visitSetType(SetType setType, JsonMessageContext context) {
        return new SetType(visitFieldType(setType.getElementType(), context));
    }

    @Override
    public CollectionType visitCollectionType(CollectionType collectionType, JsonMessageContext context) {
        return (CollectionType) process(collectionType, context);
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, JsonMessageContext context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, JsonMessageContext context) {
        FieldType fieldType = visitFieldType(node.getType(), context);
        return new Field(node.getModifier(), node.getIndex(), node.getName(), fieldType, node.getValue(), node.getComments());
    }

    @Override
    public Message visitMessage(Message node, JsonMessageContext context) {
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), m -> visitMessage(m, context));
        List<Enumeration> enums = visitIfPresent(node.getEnumerations(), e -> visitEnumeration(e, context));
        return new Message(node.getName(), node.getComments(), fields, messages, enums, node.getOptions());
    }
}
