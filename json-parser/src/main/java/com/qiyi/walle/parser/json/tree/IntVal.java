package com.qiyi.walle.parser.json.tree;

import com.qiyi.walle.parser.json.AstVisitor;

public class IntVal extends Number {
    private int value;

    public IntVal(int value) {
        this.value = value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitInt(this, context);
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntVal intVal = (IntVal) o;
        return value == intVal.value;
    }

    @Override
    public String toString() {
        Integer i;
        return String.valueOf(value);
    }
}
