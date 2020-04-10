package com.qiyi.walle.parser.protobuf.tree;

public class DoubleValue extends Value {
    double val;

    public DoubleValue(double val) {
        this.val = val;
    }


    public double getVal() {
        return val;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}
