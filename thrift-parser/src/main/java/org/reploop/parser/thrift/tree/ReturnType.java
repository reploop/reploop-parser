package org.reploop.parser.thrift.tree;

import org.reploop.parser.thrift.AstVisitor;
import org.reploop.parser.thrift.type.FieldType;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-09 18
 */
public class ReturnType extends FunctionType {
    final FieldType fieldType;

    public ReturnType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitReturnType(this, context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnType that = (ReturnType) o;
        return Objects.equals(fieldType, that.fieldType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldType);
    }

    @Override
    public String toString() {
        return "ReturnType{" +
                "fieldType=" + fieldType +
                '}';
    }
}
