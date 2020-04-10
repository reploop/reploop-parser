package com.qiyi.walle.parser.protobuf.type;

import com.google.protobuf.ByteString;
import com.qiyi.walle.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 18
 */
public class ByteStringType extends FieldType {
    public ByteStringType() {
        super(ByteString.class.getName());
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitByteStringType(this, context);
    }
}
