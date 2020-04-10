package org.reploop.parser.json.tree;


import org.reploop.parser.json.AstVisitor;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2017-01-23 18
 */
public class DoubleVal extends Number {
    private double val;

    public DoubleVal(double val) {
        this.val = val;
    }

    public double getVal() {
        return val;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitDouble(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleVal d = (DoubleVal) o;
        return Double.compare(d.val, val) == 0;
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
