package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.translator.json.support.Constants;

import java.util.List;

/**
 * Resolve type. Replace same types.
 */
public class MessageInheritResolver extends AstVisitor<Node, MessageContext> {
    @Override
    public Node visitNode(Node node, MessageContext context) {
        return node;
    }

    @Override
    public Option visitOption(Option option, MessageContext context) {
        return (Option) process(option, context);
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, MessageContext context) {
        String key = node.getKey();
        if (Constants.EXTENDS_ATTR.equals(key)) {
            Value value = node.getValue();
            if (value instanceof StringValue) {
                String parent = ((StringValue) value).getValue();
                context.setSuperClass(QualifiedName.of(parent));
            }
        }
        return node;
    }

    @Override
    public Message visitMessage(Message node, MessageContext context) {
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        QualifiedName superClass = context.getSuperClass();
        return new Message();
    }
}
