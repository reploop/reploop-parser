package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;

import java.util.List;
import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-10-14 20
 */
public class Array extends Value {
    private final List<Value> values;

    public Array(List<Value> values) {
        this.values = values;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitArray(this, context);
    }

    public List<Value> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return Objects.equals(values, array.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
