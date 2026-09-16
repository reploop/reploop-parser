package org.reploop.parser.thrift.type;

import org.reploop.parser.thrift.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 12
 */
public class FloatType extends FieldType {

    public FloatType() {
        super("float");
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitFloatType(this, context);
    }

}
