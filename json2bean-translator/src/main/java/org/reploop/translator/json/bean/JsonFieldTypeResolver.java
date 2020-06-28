package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.*;

import java.util.List;
import java.util.Optional;

public class JsonFieldTypeResolver extends AstVisitor<Node, JsonMessageContext> {
    @Override
    public Node visitNode(Node node, JsonMessageContext context) {
        return node;
    }

    @Override
    public ListType visitListType(ListType listType, JsonMessageContext context) {
        FieldType eleType = visitFieldType(listType.getElementType(), context);
        return new ListType(eleType);
    }

    @Override
    public SetType visitSetType(SetType setType, JsonMessageContext context) {
        FieldType eleType = visitFieldType(setType.getElementType(), context);
        return new SetType(eleType);
    }

    @Override
    public MapType visitMapType(MapType mapType, JsonMessageContext context) {
        FieldType keyType = visitFieldType(mapType.getKeyType(), context);
        FieldType valType = visitFieldType(mapType.getValueType(), context);
        return new MapType(keyType, valType);
    }

    private QualifiedName replaceIfPresent(QualifiedName name, JsonMessageContext context) {
        Optional<QualifiedName> oq = context.getIdentityName(name);
        if (oq.isEmpty()) {
            return name;
        } else {
            return replaceIfPresent(oq.get(), context);
        }
    }

    @Override
    public StructType visitStructType(StructType structType, JsonMessageContext context) {
        QualifiedName fqn = replaceIfPresent(structType.getName(), context);
        context.addDependency(fqn);
        return new StructType(fqn);
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, JsonMessageContext context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, JsonMessageContext context) {
        FieldType ft = visitFieldType(node.getType(), context);
        return new Field(node.getModifier(), node.getIndex(), node.getName(), ft, node.getValue(), node.getComments());
    }

    @Override
    public Message visitMessage(Message node, JsonMessageContext context) {
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        return new Message(node.getName(), node.getComments(), fields, messages, node.getEnumerations(), node.getOptions());
    }
}
