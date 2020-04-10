package org.reploop.parser.protobuf.tree;


import org.reploop.parser.protobuf.Node;

import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 11
 */
public class EnumField extends Node {
    List<String> comments;
    String name;
    Integer index;

    public EnumField(List<String> comments, String name, Integer index) {
        this.comments = comments;
        this.name = name;
        this.index = index;
    }

    public List<String> getComments() {
        return comments;
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnumField enumField = (EnumField) o;
        return Objects.equals(name, enumField.name) &&
                Objects.equals(index, enumField.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, index);
    }

    @Override
    public String toString() {
        return "EnumField{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
