package com.qiyi.walle.parser.mysql.tree;

public abstract class QueryCreateTable extends CreateTable {
    public QueryCreateTable(String tableName, boolean temporary, boolean ifNotExists) {
        super(tableName, temporary, ifNotExists);
    }
}
