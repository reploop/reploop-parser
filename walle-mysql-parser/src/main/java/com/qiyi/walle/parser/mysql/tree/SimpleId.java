package com.qiyi.walle.parser.mysql.tree;

import com.google.common.base.MoreObjects;

public class SimpleId extends UID {
    String name;

    public SimpleId(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
