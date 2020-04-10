package com.qiyi.walle.parser.protobuf.type;

import com.qiyi.walle.parser.QualifiedName;
import com.qiyi.walle.parser.protobuf.AstVisitor;

import java.util.Objects;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 18
 */
public class StructType extends FieldType {

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitStructType(this, context);
    }

    public StructType(QualifiedName name) {
        super(name);
    }

    public StructType(String name) {
        super(name);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StructType that = (StructType) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

}
