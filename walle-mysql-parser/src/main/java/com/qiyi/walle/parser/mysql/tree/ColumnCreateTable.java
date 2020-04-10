package com.qiyi.walle.parser.mysql.tree;

import com.google.common.base.MoreObjects;

import java.util.List;

public class ColumnCreateTable extends CreateTable {
    List<CreateDefinition> definitions;
    List<TableOption> options;

    public ColumnCreateTable(String tableName, boolean temporary, boolean ifNotExists) {
        super(tableName, temporary, ifNotExists);
    }


    public List<CreateDefinition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<CreateDefinition> definitions) {
        this.definitions = definitions;
    }

    public List<TableOption> getOptions() {
        return options;
    }

    public void setOptions(List<TableOption> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("definitions", definitions)
                .add("options", options)
                .add("tableName", tableName)
                .add("temporary", temporary)
                .add("ifNotExists", ifNotExists)
                .toString();
    }
}
