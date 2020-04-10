package org.reploop.parser.thrift.type;

import com.qiyi.walle.parser.thrift.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 18
 */
public class ListType extends CollectionType {
    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitListType(this, context);
    }

    public ListType(FieldType elementType) {
        super("List", elementType);
    }
}
