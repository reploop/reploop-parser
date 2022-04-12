package org.reploop.translator.json.driver;

import com.google.common.base.CaseFormat;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.parser.protobuf.type.StructType;
import org.reploop.translator.json.bean.MessageContext;

import static org.reploop.translator.json.support.Constants.IMPORT;

public class ProtoPathResolver extends AstVisitor<Node, MessageContext> {

    @Override
    public Node visitNode(Node node, MessageContext context) {
        return node;
    }

    @Override
    public Option visitOption(Option node, MessageContext context) {
        return (Option) process(node, context);
    }

    private String format(String name, MessageContext context) {
        return CaseFormat.UPPER_CAMEL.to(context.getFormat(), name);
    }

    @Override
    public StructType visitStructType(StructType structType, MessageContext context) {
        return structType;
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, MessageContext context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
        String key = node.getKey();
        if (IMPORT.equals(key)) {
            Value value = node.getValue();
            QualifiedName fqn = QualifiedName.of(((StringValue) value).getValue());
            QualifiedName name = context.getName();
            if (fqn.equals(name)) {
                // Try to import the current file here, just ignore.
                return null;
            }
            fqn = QualifiedName.of(fqn.prefix(), format(fqn.suffix(), context));
            return new CommonPair(IMPORT, new StringValue(fqn.toString()));
        }
        return node;
    }

    @Override
    public Message visitMessage(Message node, MessageContext context) {
        context.setName(node.getName());
        var options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        var messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, context));
        return new Message(node.getName(), node.getComments(), node.getFields(), messages, node.getEnumerations(), node.getServices(), options);

    }
}
