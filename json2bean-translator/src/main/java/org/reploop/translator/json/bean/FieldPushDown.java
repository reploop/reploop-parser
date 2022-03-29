package org.reploop.translator.json.bean;

import com.google.common.collect.ImmutableList;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.*;
import org.reploop.translator.json.support.Constants;

import java.util.List;

import static org.reploop.translator.json.support.Constants.IMPORT;
import static org.reploop.translator.json.support.Constants.PARENT_TAG;

/**
 * Add fields of the super class to the subclass. In order to generate a handy builder.
 */
public class FieldPushDown extends AstVisitor<Node, BeanContext> {
    @Override
    public Node visitNode(Node node, BeanContext context) {
        return node;
    }

    @Override
    public Option visitOption(Option option, BeanContext context) {
        return (Option) process(option, context);
    }

    @Override
    public CommonPair visitCommonPair(CommonPair node, BeanContext context) {
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
    public Message visitMessage(Message node, BeanContext context) {
        context.setName(node.getName());
        List<Option> options = visitIfPresent(node.getOptions(), option -> visitOption(option, context));
        QualifiedName superClass = context.getSuperClass();
        var sup = context.dep(superClass);
        var fields = ImmutableList.<Field>builder().addAll(node.getFields());
        sup.ifPresent(message -> {
            BeanContext bc = new BeanContext(message.getName(), context.getDeps());
            Message parent = visitMessage(message, bc);
            List<Field> parentFields = parent.getFields();
            for (Field pf : parentFields) {
                var fieldOptions = ImmutableList.<Option>builder().addAll(pf.getOptions());
                fieldOptions.add(new CommonPair(PARENT_TAG, new BoolValue(true)));
                Field nf = new Field(pf.getModifier(), pf.getIndex(), pf.getName(), pf.getType(), pf.getValue(), pf.getComments(), fieldOptions.build());
                fields.add(nf);
            }
            var parentOptions = parent.getOptions();
            for (Option option : parentOptions) {
                if (option instanceof CommonPair && IMPORT.equals(((CommonPair) option).getKey())) {
                    options.add(option);
                }
            }
        });
        return new Message(node.getName(), node.getComments(), fields.build(), node.getMessages(), node.getEnumerations(), node.getServices(), options);
    }
}
