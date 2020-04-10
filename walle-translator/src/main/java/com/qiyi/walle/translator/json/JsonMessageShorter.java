package com.qiyi.walle.translator.json;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.protobuf.AstVisitor;
import com.qiyi.walle.parser.protobuf.Node;
import com.qiyi.walle.parser.protobuf.tree.*;
import com.qiyi.walle.parser.protobuf.type.FieldType;
import com.qiyi.walle.parser.protobuf.type.ListType;
import com.qiyi.walle.parser.protobuf.type.StructType;

import java.util.ArrayList;
import java.util.List;

public class JsonMessageShorter extends AstVisitor<Node, List<Option>> {
    @Override
    public Node visitNode(Node node, List<Option> context) {
        return node;
    }

    private boolean include(QualifiedName qn, List<Option> context) {
        if (qn.prefix().isPresent()) {
            boolean collision = false;
            for (Option option : context) {
                if (option instanceof CommonPair) {
                    CommonPair pair = (CommonPair) option;
                    Value value = pair.getValue();
                    if (value instanceof StringValue) {
                        String val = ((StringValue) value).getValue();
                        if (val.endsWith(qn.suffix())) {
                            collision = true;
                            break;
                        }
                    }
                }
            }
            CommonPair pair = new CommonPair("import", new StringValue(qn.toString()));
            if (!collision) {
                context.add(pair);
                return true;
            }
        }
        return false;
    }

    @Override
    public StructType visitStructType(StructType structType, List<Option> context) {
        QualifiedName qn = structType.getName();
        if (include(qn, context)) {
            return new StructType(qn.suffix());
        }
        return structType;
    }

    @Override
    public ListType visitListType(ListType listType, List<Option> context) {
        FieldType fieldType = visitFieldType(listType.getElementType(), context);
        return new ListType(fieldType);
    }

    @Override
    public FieldType visitFieldType(FieldType fieldType, List<Option> context) {
        return (FieldType) process(fieldType, context);
    }

    @Override
    public Field visitField(Field node, List<Option> context) {
        FieldType fieldType = visitFieldType(node.getType(), context);
        return new Field(node.getModifier(), node.getIndex(), node.getName(), fieldType, node.getValue(), node.getComments());
    }

    private List<Option> createIfNull(Message message) {
        if (null == message.getOptions()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(message.getOptions());
    }

    @Override
    public Message visitMessage(Message node, List<Option> context) {
        List<Message> messages = visitIfPresent(node.getMessages(), message -> visitMessage(message, createIfNull(message)));
        List<Field> fields = visitIfPresent(node.getFields(), field -> visitField(field, context));
        return new Message(node.getName(), node.getComments(), fields, messages, node.getEnumerations(), context);
    }
}
