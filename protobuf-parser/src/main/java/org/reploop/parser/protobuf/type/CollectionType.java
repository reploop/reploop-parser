package org.reploop.parser.protobuf.type;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-05 18
 */
public abstract class CollectionType extends FieldType {

    FieldType elementType;

    public CollectionType(FieldType elementType) {
        this("Collection", elementType);
    }


    public CollectionType(String name, FieldType elementType) {
        super(name);
        this.elementType = elementType;
    }

    public FieldType getElementType() {
        return elementType;
    }

    @Override
    public String toString() {
        return getName() + "<" + getElementType() + ">";
    }
}
