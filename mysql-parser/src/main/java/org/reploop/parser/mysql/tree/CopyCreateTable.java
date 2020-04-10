package org.reploop.parser.mysql.tree;

public abstract class CopyCreateTable extends CreateTable {
    public CopyCreateTable(String tableName, boolean temporary, boolean ifNotExists) {
        super(tableName, temporary, ifNotExists);
    }
}
