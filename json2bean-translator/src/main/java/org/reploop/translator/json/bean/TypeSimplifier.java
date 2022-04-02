package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.*;

import java.util.List;

import static org.reploop.translator.json.support.Constants.EXTENDS_ATTR;
import static org.reploop.translator.json.support.Constants.IMPORT;
import static org.reploop.translator.json.support.NameSupport.shouldExplicitImport;

/**
 * Full qualified name to simple name.
 */
public class TypeSimplifier extends AstVisitor<Node, MessageContext> {
    @Override
    public Node visitNode(Node node, MessageContext context) {
        return node;
    }

    @Override
    public ListType visitListType(ListType listType, MessageContext context) {
        FieldType eleType = visitFieldType(listType.getElementType(), context);
        return new ListType(eleType);
    }

    @Override
    public SetType visitSetType(SetType setType, MessageContext context) {
        FieldType eleType = visitFieldType(setType.getElementType(), context);
        return new SetType(eleType);
    }

    @Override
    public MapType visitMapType(MapType mapType, MessageContext context) {
        FieldType keyType = visitFieldType(mapType.getKeyType(), context);
        FieldType valType = visitFieldType(mapType.getValueType(), context);
        return new MapType(keyType, valType);
    }

    @Override
    public StructType visitStructType(StructType node, MessageContext context) {
        QualifiedName fqn = node.getName();
        if (shouldExplicitImport(fqn, context.getName())) {
            addDependency(fqn, context);
        }
        return new StructType(fqn.suffix());
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, MessageContext context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, MessageContext context) {
        FieldType ft = visitFieldType(node.getType(), context);
        return new Field(node.getModifier(), node.getIndex(), node.getName(), ft, node.getValue(), node.getComments(), node.getOptions());
    }

    protected void addDependency(QualifiedName fqn, MessageContext context) {
        context.addDependency(fqn);
    }

    protected boolean supportExtends() {
        return true;
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
        String key = node.getKey();
        Value value = node.getValue();
        if (EXTENDS_ATTR.equals(key)) {
            if (value instanceof StringValue) {
                if (supportExtends()) {
                    QualifiedName fqn = QualifiedName.of(((StringValue) value).getValue());
                    if (shouldExplicitImport(fqn, context.getName())) {
                        addDependency(fqn, context);
                    }
                    return new CommonPair(EXTENDS_ATTR, new StringValue(fqn.suffix()));
                }
            }
        } else if (IMPORT.equals(key)) {
            if (value instanceof StringValue) {
                QualifiedName fqn = QualifiedName.of(((StringValue) value).getValue());
                if (shouldExplicitImport(fqn, context.getName())) {
                    addDependency(fqn, context);
                }
                // We add all imports to deps, so ignore this option temperately.
                return null;
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
        FieldType responseType = visitFieldType(node.getResponseType(), context);
        FieldType requestType = visitFieldType(node.getRequestType(), context);
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
        QualifiedName fqn = node.getName();
        context.setName(fqn);
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        List<Service> services = visitIfPresent(node.getServices(), service -> visitService(service, context));
        context.getDependencies()
            .stream()
            .map(QualifiedName::toString)
            .map(dep -> new CommonPair(IMPORT, new StringValue(dep)))
            .forEach(options::add);
        return new Message(fqn, node.getComments(), fields, messages, node.getEnumerations(), services, options);
    }
}
