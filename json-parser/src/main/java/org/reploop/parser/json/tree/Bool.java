package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2017-01-23 18
 */
public class Bool extends Value {
    boolean val;

    public Bool(boolean val) {
        this.val = val;
    }

    public boolean getVal() {
        return val;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitBool(this, context);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bool bool = (Bool) o;
        return val == bool.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
