package org.reploop.parser.json.tree;

import org.reploop.parser.json.AstVisitor;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2017-01-23 18
 */
public class LongVal extends Number {
    private long val;

    public LongVal(long val) {
        this.val = val;
    }

    public long getVal() {
        return val;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitLong(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongVal aLongVal = (LongVal) o;
        return val == aLongVal.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
