package org.reploop.parser.thrift.tree;

import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.Node;

import java.util.List;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
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
        return "Raise{" + "fields=" + fields + '}';
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
