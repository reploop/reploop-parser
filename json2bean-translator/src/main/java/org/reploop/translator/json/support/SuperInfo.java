package org.reploop.translator.json.support;

import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.Message;

import java.util.List;
import java.util.Set;

public class SuperInfo {
    private List<Message> messages;
    private Set<Field> fields;

    public SuperInfo(List<Message> messages, Set<Field> fields) {
        this.messages = messages;
        this.fields = fields;
    }

    public SuperInfo addMessage(Message message) {
        messages.add(message);
        return this;
    }

    public SuperInfo addField(Field field) {
        fields.add(field);
        return this;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public Set<Field> getFields() {
        return fields;
    }
}
