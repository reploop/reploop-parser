package com.qiyi.walle.parser.thrift.tree;

import com.qiyi.walle.parser.thrift.AstVisitor;
import com.qiyi.walle.parser.thrift.Node;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-07-03 10
 */
public class EnumField extends Node {
    private String name;
    private Optional<Integer> index;
    private List<String> comments;

    public EnumField(String name, Optional<Integer> index) {
        this(name, index, Collections.emptyList());
    }

    public EnumField(String name, Optional<Integer> index, List<String> comments) {
        this.name = name;
        this.index = index;
        this.comments = comments;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitEnumField(this, context);
    }

    public List<String> getComments() {
        return comments;
    }

    public String getName() {
        return name;
    }

    public Optional<Integer> getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnumField enumField = (EnumField) o;

        if (index != null ? !index.equals(enumField.index) : enumField.index != null) return false;
        if (!name.equals(enumField.name)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "EnumField{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (index != null ? index.hashCode() : 0);
        return result;
    }
}
