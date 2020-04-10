package com.qiyi.walle.parser.thrift;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-07-03 00
 */
public abstract class Node {
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitNode(this, context);
    }

    // Force subclasses to have a proper equals and hashcode implementation
    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
