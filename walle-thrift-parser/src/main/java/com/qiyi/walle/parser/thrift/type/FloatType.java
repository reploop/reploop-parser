package com.qiyi.walle.parser.thrift.type;

import com.qiyi.walle.parser.thrift.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 12
 */
public class FloatType extends FieldType {
    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitFloatType(this, context);
    }

    public FloatType() {
        super("float");
    }
}
