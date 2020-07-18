package org.reploop.parser.protobuf.tree;

import org.reploop.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-08 17
 */
public class CommonPair extends Pair {

    public CommonPair(String key, Value value) {
        super(key, value);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitCommonPair(this, context);
    }
}
