package org.reploop.translator.json.type;

import org.reploop.parser.protobuf.type.*;

import java.util.Comparator;

public class FieldTypeComparator implements Comparator<FieldType> {
    @Override
    public int compare(FieldType f0, FieldType f1) {
        Integer o0 = valueTypeOrder(f0);
        Integer o1 = valueTypeOrder(f1);
        return o0.compareTo(o1);
    }

    private Integer valueTypeOrder(FieldType type) {
        if (type instanceof CollectionType) {
            return valueTypeOrder(((CollectionType) type).getElementType());
        }
        if (type instanceof MapType) {
            return valueTypeOrder(((MapType) type).getValueType());
        }
        // bits range from 8 to 64
        if (type instanceof NumberType) {
            return ((NumberType) type).bits();
        }
        if (type instanceof StructType && type.getName().suffix().equals("Object")) {
            return Integer.MIN_VALUE;
        }
        return 0;
    }

}
