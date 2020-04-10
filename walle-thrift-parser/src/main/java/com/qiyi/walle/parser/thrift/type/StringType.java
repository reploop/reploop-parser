package com.qiyi.walle.parser.thrift.type;

import com.qiyi.walle.parser.thrift.AstVisitor;

/**
 * Say something?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 5/9/13 4:19 PM
 */
public class StringType extends FieldType {
    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitStringType(this, context);
    }


    public StringType() {
        super("String");
    }
}
