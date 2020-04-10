package com.qiyi.walle.parser.json.tree;

import com.qiyi.walle.parser.json.AstVisitor;

import java.util.Objects;

public class ByteVal extends Number {
    private byte value;

    public ByteVal(byte value) {
        this.value = value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitByte(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ByteVal byteVal = (ByteVal) o;
        return value == byteVal.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
