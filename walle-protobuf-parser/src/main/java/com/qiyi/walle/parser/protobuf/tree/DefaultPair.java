package com.qiyi.walle.parser.protobuf.tree;

import com.qiyi.walle.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-08 17
 */
public class DefaultPair extends Pair {
    public DefaultPair(Value value) {
        super("default", value);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitDefaultPair(this, context);
    }
}
