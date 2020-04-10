package com.qiyi.walle.parser.thrift.tree;

import com.qiyi.walle.parser.thrift.AstVisitor;
import com.qiyi.walle.parser.thrift.Node;

import java.util.List;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 17
 */
public class Raise extends Node {
    List<Field> fields;

    public Raise(List<Field> fields) {
        this.fields = fields;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitRaise(this, context);
    }

    public List<Field> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Raise{");
        sb.append("fields=").append(fields);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
