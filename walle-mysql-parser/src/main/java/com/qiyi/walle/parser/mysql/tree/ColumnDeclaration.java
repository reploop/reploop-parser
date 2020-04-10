package com.qiyi.walle.parser.mysql.tree;

import com.google.common.base.MoreObjects;

public class ColumnDeclaration extends CreateDefinition {
    UID id;
    ColumnDefinition definition;


    public ColumnDeclaration(UID id, ColumnDefinition definition) {
        this.id = id;
        this.definition = definition;
    }

    public UID getId() {
        return id;
    }

    public void setId(UID id) {
        this.id = id;
    }

    public ColumnDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(ColumnDefinition definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("definition", definition)
                .toString();
    }
}
