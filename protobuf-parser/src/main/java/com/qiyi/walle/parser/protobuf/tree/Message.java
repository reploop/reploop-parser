package com.qiyi.walle.parser.protobuf.tree;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.protobuf.AstVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 10
 */
public class Message extends Entity {
    List<String> comments;
    List<Field> fields;
    List<Message> messages;
    List<Enumeration> enumerations;
    List<Option> options = new ArrayList<>();

    public Message(QualifiedName name, List<Field> fields) {
        super(name);
        this.fields = fields;
    }

    public Message(QualifiedName name, List<Field> fields, List<Message> messages) {
        super(name);
        this.fields = fields;
        this.messages = messages;
    }

    public Message(QualifiedName name,
                   List<Field> fields,
                   List<Message> messages,
                   List<Enumeration> enumerations, List<Option> options) {
        this(name, Collections.emptyList(), fields, messages, enumerations, options);
    }

    public Message(QualifiedName name,
                   List<String> comments,
                   List<Field> fields,
                   List<Message> messages,
                   List<Enumeration> enumerations,
                   List<Option> options) {
        super(name);
        this.comments = comments;
        this.fields = fields;
        this.messages = messages;
        this.enumerations = enumerations;
        this.options = options;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitMessage(this, context);
    }

    public List<Option> getOptions() {
        return options;
    }

    public List<String> getComments() {
        return comments;
    }


    public List<Field> getFields() {
        return fields;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Enumeration> getEnumerations() {
        return enumerations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(name, message.name) &&
                Objects.equals(fields, message.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fields);
    }

    @Override
    public String toString() {
        return "Message{" +
                "name=" + name +
                ", comments=" + comments +
                ", fields=" + fields +
                ", messages=" + messages +
                ", enumerations=" + enumerations +
                '}';
    }
}
