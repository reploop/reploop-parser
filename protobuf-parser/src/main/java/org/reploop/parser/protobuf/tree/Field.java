package org.reploop.parser.protobuf.tree;


import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.type.FieldType;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 10
 */
public class Field extends Node {
    FieldModifier modifier;
    Integer index;
    String name;
    FieldType type;
    Optional<Value> value;
    List<String> comments;

    public Field(FieldModifier modifier,
                 Integer index,
                 String name,
                 FieldType type,
                 Optional<Value> value,
                 List<String> comments) {
        this.modifier = modifier;
        this.index = index;
        this.name = name;
        this.type = type;
        this.value = value;
        this.comments = comments;
    }

    public Optional<Value> getValue() {
        return value;
    }

    public List<String> getComments() {
        return comments;
    }

    public FieldModifier getModifier() {
        return modifier;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public FieldType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(modifier, field.modifier) &&
            Objects.equals(index, field.index) &&
            Objects.equals(name, field.name) &&
            Objects.equals(type, field.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modifier, index, name, type);
    }

    @Override
    public String toString() {
        return "Field{" +
            "modifier=" + modifier +
            ", index=" + index +
            ", name='" + name + '\'' +
            ", type=" + type +
            ", value=" + value +
            ", comments=" + comments +
            '}';
    }
}
