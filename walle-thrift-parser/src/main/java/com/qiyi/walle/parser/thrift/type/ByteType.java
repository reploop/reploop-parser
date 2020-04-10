package com.qiyi.walle.parser.thrift.type;

import com.qiyi.walle.parser.thrift.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 18
 */
public class ByteType extends FieldType {
    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitByteType(this, context);
    }

    public ByteType() {
        super("byte");
    }
}
