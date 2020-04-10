package com.qiyi.walle.parser.protobuf.type;

import com.qiyi.walle.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
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
