package org.reploop.parser.protobuf.tree;

import org.reploop.parser.protobuf.AstVisitor;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2016-10-14 00
 */
public class FloatValue extends Value {
    private final float value;

    public FloatValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitFloatValue(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FloatValue)) return false;
        FloatValue that = (FloatValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Float.toString(value);
    }
}
