package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.FieldType;

import java.util.*;

public class JsonMessageContext {
    private QualifiedName name;
    private TreeMap<QualifiedName, List<Message>> namedMessages;
    private FieldType fieldType;

    public JsonMessageContext(QualifiedName name, TreeMap<QualifiedName, List<Message>> namedMessages) {
        this.name = name;
        this.namedMessages = namedMessages;
    }

    public JsonMessageContext(QualifiedName name) {
        this.name = name;
    }

    public JsonMessageContext(String name) {
        this(QualifiedName.of(name));
    }

    public JsonMessageContext() {
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public QualifiedName getName() {
        return name;
    }

    public void setName(String name) {
        setName(QualifiedName.of(name));
    }

    public void setName(QualifiedName name) {
        this.name = name;
    }

    public Map<QualifiedName, List<Message>> getNamedMessages() {
        return namedMessages;
    }

    public JsonMessageContext addNamedMessages(Map<QualifiedName, List<Message>> messageMap) {
        if (null != messageMap) {
            messageMap.forEach(this::addNamedMessage);
        }
        return this;
    }

    public JsonMessageContext addMessages(List<Message> messages) {
        return addNamedMessage(name, messages);
    }

    public JsonMessageContext addMessage(Message message) {
        return addMessages(Collections.singletonList(message));
    }

    public JsonMessageContext addNamedMessage(QualifiedName name, Message message) {
        return addNamedMessage(name, Collections.singletonList(message));
    }

    public JsonMessageContext addNamedMessage(QualifiedName name, List<Message> messages) {
        if (namedMessages == null) {
            namedMessages = new TreeMap<>();
        }
        namedMessages.computeIfAbsent(name, key -> new ArrayList<>()).addAll(messages);
        return this;
    }

    public void setNamedMessages(TreeMap<QualifiedName, List<Message>> namedMessages) {
        this.namedMessages = namedMessages;
    }

    public boolean isJsonRawValue(QualifiedName name) {
        String expected = "$.log.entries.response.content.text";
        return name.toString().equals(expected);
    }

    public boolean isJsonRawValue() {
        return isJsonRawValue(name);
    }
}
