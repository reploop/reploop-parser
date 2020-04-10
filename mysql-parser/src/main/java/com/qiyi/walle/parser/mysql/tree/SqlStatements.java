package com.qiyi.walle.parser.mysql.tree;

import com.google.common.base.MoreObjects;

import java.util.List;

public class SqlStatements extends Node {
    List<SqlStatement> statements;

    public SqlStatements(List<SqlStatement> statements) {
        this.statements = statements;
    }

    public List<SqlStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<SqlStatement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("statements", statements)
                .toString();
    }
}
