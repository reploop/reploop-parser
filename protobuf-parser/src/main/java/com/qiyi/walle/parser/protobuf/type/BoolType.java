package com.qiyi.walle.parser.protobuf.type;

import com.qiyi.walle.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 18
 */
public class BoolType extends FieldType {
    public BoolType() {
        super("boolean");
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitBoolType(this, context);
    }
}
