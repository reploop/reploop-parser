package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2017-01-23 16
 */
public class Null extends Value {

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitNull(this, context);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Null;
    }

    @Override
    public String toString() {
        return "null";
    }
}
