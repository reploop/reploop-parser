package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.support.Constants;

import java.util.List;

/**
 * Collect all deps this class needs including parent class info.
 * Java classes is not counted.
 */
public class DependencyResolver extends AstVisitor<Node, MessageContext> {
    @Override
    public Node visitNode(Node node, MessageContext context) {
        return node;
    }

    @Override
    public StructType visitStructType(StructType structType, MessageContext context) {
        context.addDependency(structType.getName());
        return structType;
    }

    @Override
    public Enumeration visitEnumeration(Enumeration node, MessageContext context) {
        context.addDependency(node.getName());
        return node;
    }

    @Override
    public MapType visitMapType(MapType mapType, MessageContext context) {
        FieldType key = visitFieldType(mapType.getKeyType(), context);
        FieldType val = visitFieldType(mapType.getValueType(), context);
        return new MapType(key, val);
    }

    @Override
    public ListType visitListType(ListType listType, MessageContext context) {
        return new ListType(visitFieldType(listType.getElementType(), context));
    }

    @Override
    public SetType visitSetType(SetType setType, MessageContext context) {
        return new SetType(visitFieldType(setType.getElementType(), context));
    }

    @Override
    public CollectionType visitCollectionType(CollectionType collectionType, MessageContext context) {
        return (CollectionType) process(collectionType, context);
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, MessageContext context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, MessageContext context) {
        FieldType fieldType = visitFieldType(node.getType(), context);
        return new Field(node.getModifier(), node.getIndex(), node.getName(), fieldType, node.getValue(), node.getComments());
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
        String key = node.getKey();
        if (Constants.EXTENDS_ATTR.equals(key)) {
            Value value = node.getValue();
            if (value instanceof StringValue) {
                QualifiedName val = QualifiedName.of(((StringValue) value).getValue());
                context.addDependency(val);
            }
        }
        return node;
    }

    @Override
    public Option visitOption(Option option, MessageContext context) {
        return (Option) process(option, context);
    }

    @Override
    public Function visitFunction(Function node, MessageContext context) {
        var requestType = visitFieldType(node.getRequestType(), context);
        var responseType = visitFieldType(node.getResponseType(), context);
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        return new Function(node.getName(), requestType, responseType, options);
    }

    @Override
    public Service visitService(Service node, MessageContext context) {
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        List<Function> functions = visitIfPresent(node.getFunctions(), function -> visitFunction(function, context));
        return new Service(node.getName(), options, functions);
    }

    @Override
    public Message visitMessage(Message node, MessageContext context) {
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), m -> visitMessage(m, context));
        List<Enumeration> enums = visitIfPresent(node.getEnumerations(), e -> visitEnumeration(e, context));
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        List<Service> services = visitIfPresent(node.getServices(), service -> visitService(service, context));
        return new Message(node.getName(), node.getComments(), fields, messages, enums, services, options);
    }
}
