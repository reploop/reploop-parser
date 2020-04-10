package org.reploop.parser.mysql.tree;

import com.google.common.base.MoreObjects;

public abstract class TableName extends Node {
    String name;

    public TableName(String name) {
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
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}
