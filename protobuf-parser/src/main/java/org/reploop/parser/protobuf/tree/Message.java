package org.reploop.parser.protobuf.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A protobuf Message.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 10
 */
public class Message extends Entity {
    List<String> comments;
    List<Field> fields;
    List<Message> messages;
    List<Enumeration> enumerations;
    List<Service> services;
    List<Option> options;

    public Message(QualifiedName name, List<Field> fields) {
        this(name, fields, Collections.emptyList());
    }

    public Message(QualifiedName name, List<Field> fields, List<Message> messages) {
        this(name, fields, messages, Collections.emptyList(), new ArrayList<>());
    }

    public Message(QualifiedName name,
                   List<Field> fields,
                   List<Message> messages,
                   List<Enumeration> enumerations,
                   List<Option> options) {
        this(name, Collections.emptyList(), fields, messages, enumerations, Collections.emptyList(), options);
    }

    public Message(QualifiedName name,
                   List<Field> fields,
                   List<Message> messages,
                   List<Enumeration> enumerations,
                   List<Service> services,
                   List<Option> options) {
        this(name, Collections.emptyList(), fields, messages, enumerations, services, options);
    }

    public Message(QualifiedName name,
                   List<String> comments,
                   List<Field> fields,
                   List<Message> messages,
                   List<Enumeration> enumerations,
                   List<Service> services,
                   List<Option> options) {
        super(name);
        this.comments = comments;
        this.fields = fields;
        this.messages = messages;
        this.enumerations = enumerations;
        this.services = services;
        this.options = options;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitMessage(this, context);
    }

    public List<Service> getServices() {
        return services;
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
