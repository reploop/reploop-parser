package com.qiyi.walle.parser.protobuf.tree;

import com.qiyi.walle.parser.protobuf.Node;

public class NullValue extends Node {
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
