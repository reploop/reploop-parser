package com.qiyi.walle.parser.protobuf.tree;

public class LongValue extends Value {
    long val;

    public LongValue(long val) {
        this.val = val;
    }

    public long getVal() {
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
