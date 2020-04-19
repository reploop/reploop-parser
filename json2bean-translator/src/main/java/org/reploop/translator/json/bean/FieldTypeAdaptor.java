package org.reploop.translator.json.bean;

import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.type.NumberSpec;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FieldTypeAdaptor extends AstVisitor<FieldType, NumberSpec> {

    @Override
    public FieldType visitNode(Node node, NumberSpec context) {
        return process(node, context);
    }

    @Override
    public ListType visitListType(ListType listType, NumberSpec context) {
        FieldType elementType = visitFieldType(listType.getElementType(), context);
        return new ListType(elementType);
    }

    @Override
    public SetType visitSetType(SetType setType, NumberSpec context) {
        FieldType elementType = visitFieldType(setType.getElementType(), context);
        return new SetType(elementType);
    }

    @Override
    public MapType visitMapType(MapType mapType, NumberSpec context) {
        FieldType valueType = visitFieldType(mapType.getValueType(), context);
        return new MapType(mapType.getKeyType(), valueType);
    }

    private static final Map<Integer, FieldType> fieldTypeMap;

    static {
        Map<Integer, FieldType> map = new HashMap<>();
        ByteType byteType = new ByteType();
        map.put(byteType.bits(), byteType);
        ShortType shortType = new ShortType();
        map.put(shortType.bits(), shortType);
        IntType intType = new IntType();
        map.put(intType.bits(), intType);
        LongType longType = new LongType();
        map.put(longType.bits(), longType);

        fieldTypeMap = Collections.unmodifiableMap(map);
    }

    @Override
    public FieldType visitIntType(IntType intType, NumberSpec context) {
        if (context.isFloating()) {
            return visitFloatType(new FloatType(), context);
        }
        return fieldTypeMap.get(context.getBits());
    }

    @Override
    public FieldType visitByteType(ByteType byteType, NumberSpec context) {
        if (context.isFloating()) {
            return visitFloatType(new FloatType(), context);
        }
        return fieldTypeMap.get(context.getBits());
    }

    @Override
    public FieldType visitShortType(ShortType shortType, NumberSpec context) {
        if (context.isFloating()) {
            return visitFloatType(new FloatType(), context);
        }
        return fieldTypeMap.get(context.getBits());
    }

    @Override
    public FieldType visitLongType(LongType longType, NumberSpec context) {
        if (context.isFloating()) {
            return visitDoubleType(new DoubleType(), context);
        }
        return fieldTypeMap.get(context.getBits());
    }

    @Override
    public FieldType visitFloatType(FloatType floatType, NumberSpec context) {
        int bits = floatType.bits();
        if (context.getBits() == bits) {
            return floatType;
        }
        return visitDoubleType(new DoubleType(), context);
    }

    @Override
    public FieldType visitDoubleType(DoubleType doubleType, NumberSpec context) {
        int bits = doubleType.bits();
        if (context.getBits() == bits) {
            return doubleType;
        }
        throw new IllegalStateException(context.toString());
    }
}
