package org.reploop.parser.thrift.type;

import org.reploop.parser.thrift.AstVisitor;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public class MapType extends FieldType {
    @Override
    public <R, C> R accept(AstVisitor<R, C> visitor, C context) {
        return visitor.visitMapType(this, context);
    }

    FieldType keyType;
    FieldType valueType;

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
}
