package org.reploop.translator.json.type;

import org.reploop.parser.protobuf.type.*;

import java.util.Comparator;

/**
 * String > number > Object
 */
public class FieldTypeComparator implements Comparator<FieldType> {
    @Override
    public int compare(FieldType f0, FieldType f1) {
        Integer o0 = valueTypeOrder(f0);
        Integer o1 = valueTypeOrder(f1);
        return o0.compareTo(o1);
    }

    /**
     * It's only number, string and object need to compare.
     * StructType should not be different from each other, so they are same.
     *
     * <p>
     * String > Number
     * String > Object
     * Number > Object
     * </p>
     *
     * @param type The file type.
     * @return compare result.
     */
    private Integer valueTypeOrder(FieldType type) {
        if (type instanceof CollectionType) {
            return valueTypeOrder(((CollectionType) type).getElementType());
        }
        if (type instanceof MapType) {
            return valueTypeOrder(((MapType) type).getValueType());
        }
        // String > Number
        if (type instanceof StringType) {
            // Longest bits of number type is 64, so string is larger than number type.
            return 128;
        }
        // bits range from 8 to 64
        if (type instanceof NumberType) {
            return ((NumberType) type).bits();
        }
        // The minimal one is Object type.
        if (type instanceof StructType && type.getName().suffix().equals("Object")) {
            return Integer.MIN_VALUE;
        }
        // Between the number and the object.
        return Integer.MIN_VALUE + 1;
    }

}
