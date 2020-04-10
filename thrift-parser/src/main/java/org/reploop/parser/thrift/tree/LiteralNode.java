package org.reploop.parser.thrift.tree;

import com.qiyi.walle.parser.thrift.AstVisitor;
import com.qiyi.walle.parser.thrift.Node;

/**
 * Created by caozhangzhi on 2015/6/6.
 */
public class LiteralNode extends Node {
    String value;

    public LiteralNode(String value) {
        this.value = value;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitLiteralNode(this, context);
    }

    public String getValue() {
        return value;
    }

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
