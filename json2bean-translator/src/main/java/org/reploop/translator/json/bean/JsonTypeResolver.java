package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.support.Constants;

import java.util.List;
import java.util.Optional;

/**
 * Resolve type. Replace same types.
 */
public class JsonTypeResolver extends AstVisitor<Node, JsonMessageContext> {
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
    public CommonPair visitCommonPair(CommonPair node, JsonMessageContext context) {
        String key = node.getKey();
        if (Constants.EXTENDS_ATTR.equals(key)) {
            Value value = node.getValue();
            if (value instanceof StringValue) {
                QualifiedName qn = QualifiedName.of(((StringValue) value).getValue());
                QualifiedName fqn = replaceIfPresent(qn, context);
                return new CommonPair(Constants.EXTENDS_ATTR, new StringValue(fqn.toString()));
            }
        }
        return node;
    }

    @Override
    public DefaultPair visitDefaultPair(DefaultPair node, JsonMessageContext context) {
        return node;
    }

    @Override
    public OptionPair visitOptionPair(OptionPair node, JsonMessageContext context) {
        return node;
    }

    @Override
    public Option visitOption(Option option, JsonMessageContext context) {
        return (Option) process(option, context);
    }

    @Override
    public Message visitMessage(Message node, JsonMessageContext context) {
        QualifiedName fqn = replaceIfPresent(node.getName(), context);
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        return new Message(fqn, node.getComments(), fields, messages, node.getEnumerations(), options);
    }
}
