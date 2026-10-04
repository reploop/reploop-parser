package org.reploop.parser.protobuf.type;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.protobuf.AstVisitor;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public class StructType extends FieldType {

    public StructType(QualifiedName name) {
        super(name);
    }

    public StructType(String name) {
        super(name);
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitStructType(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        StructType that = (StructType) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

}
