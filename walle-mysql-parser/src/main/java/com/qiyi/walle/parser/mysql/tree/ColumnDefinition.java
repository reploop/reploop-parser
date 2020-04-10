package com.qiyi.walle.parser.mysql.tree;

import com.google.common.base.MoreObjects;

public class ColumnDefinition extends Node {

    DataType dataType;

    public ColumnDefinition(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("dataType", dataType)
                .toString();
    }
}
