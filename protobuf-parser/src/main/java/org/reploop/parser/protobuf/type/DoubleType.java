package org.reploop.parser.protobuf.type;

import com.qiyi.walle.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 18
 */
public class DoubleType extends FieldType {
    public DoubleType() {
        super("double");
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitDoubleType(this, context);
    }
}
