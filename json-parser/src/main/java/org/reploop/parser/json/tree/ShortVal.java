package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;

import java.util.Objects;

public class ShortVal extends Number {
    private short value;

    public ShortVal(short value) {
        this.value = value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitShort(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortVal shortVal = (ShortVal) o;
        return value == shortVal.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
