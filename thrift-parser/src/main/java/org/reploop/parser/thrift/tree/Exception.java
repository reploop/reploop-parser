package org.reploop.parser.thrift.tree;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.thrift.AstVisitor;

import java.util.List;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public class Exception extends Entity {
    List<Field> fields;

    public Exception(List<String> comments, QualifiedName name, List<Field> fields) {
        super(name, comments);
        this.fields = fields;
    }

    public Exception(String name, List<Field> fields) {
        super(name);
        this.fields = fields;
    }

    public List<Field> getFields() {
        return fields;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitException(this, context);
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
        return "Exception{" +
                "fields=" + fields +
                '}';
    }

}
