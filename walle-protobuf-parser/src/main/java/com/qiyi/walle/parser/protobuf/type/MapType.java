package com.qiyi.walle.parser.protobuf.type;

import com.qiyi.walle.parser.protobuf.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2015-06-05 18
 */
public class MapType extends FieldType {
    private FieldType keyType;
    private FieldType valueType;

    public MapType(FieldType keyType, FieldType valueType) {
        super("Map");
        this.keyType = keyType;
        this.valueType = valueType;
    }

    public FieldType getKeyType() {
        return keyType;
    }

    public FieldType getValueType() {
        return valueType;
    }

    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitMapType(this, context);
    }

    @Override
    public String toString() {
        return name + "<" + keyType + ", " + valueType + ">";
    }
}
