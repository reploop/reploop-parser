package org.reploop.parser.protobuf.type;

import org.reploop.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 18
 */
public class ByteType extends FieldType implements IntegerType {
    public ByteType() {
        super("Byte");
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitByteType(this, context);
    }

    @Override
    public int bits() {
        return 8;
    }
}
