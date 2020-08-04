package org.reploop.translator.json.bean;

import org.reploop.parser.protobuf.AstVisitor;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.type.NumberSpec;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

/**
 * Prefer float-point number first. then choose type of largest bits.
 */
public class JsonNumberTypeAdaptor extends AstVisitor<FieldType, NumberSpec> {

    private static final Map<Integer, FieldType> integerTypeMap;
    private static final Map<Integer, FieldType> floatingTypeMap;

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
        integerTypeMap = Collections.unmodifiableMap(map);

        Map<Integer, FieldType> mf = new HashMap<>();
        FloatType floatType = new FloatType();
        mf.put(floatType.bits(), floatType);
        DoubleType doubleType = new DoubleType();
        mf.put(doubleType.bits(), doubleType);
        floatingTypeMap = Collections.unmodifiableMap(mf);
    }

    private final int minBits;
    /**
     * 32 bits integer or floating-point number
     */
    private final static int MIN_BITS = 32;

    public JsonNumberTypeAdaptor(int minBits) {
        this.minBits = minBits;
    }

    /**
     * We use Integer or Float as a start.
     */
    public JsonNumberTypeAdaptor() {
        this(MIN_BITS);
    }

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

    @Override
    public FieldType visitIntType(IntType intType, NumberSpec context) {
        if (context.isFloating()) {
            return visitFloatType(new FloatType(), context);
        }
        return integerType(context);
    }

    private FieldType integerType(NumberSpec context) {
        return type(integerTypeMap, context);
    }

    private FieldType floatingType(NumberSpec context) {
        return type(floatingTypeMap, context);
    }

    private FieldType type(Map<Integer, FieldType> bitsTypeMap, NumberSpec context) {
        int bits = max(minBits, context.getBits());
        FieldType type = bitsTypeMap.get(bits);
        if (null == type) {
            throw new IllegalStateException("Type with bits " + bits + " does not exists. Current spec is " + context.toString());
        }
        return type;
    }

    @Override
    public FieldType visitByteType(ByteType byteType, NumberSpec context) {
        if (context.isFloating()) {
            return visitFloatType(new FloatType(), context);
        }
        return integerType(context);
    }

    @Override
    public FieldType visitShortType(ShortType shortType, NumberSpec context) {
        if (context.isFloating()) {
            return visitFloatType(new FloatType(), context);
        }
        return integerType(context);
    }

    @Override
    public FieldType visitLongType(LongType longType, NumberSpec context) {
        if (context.isFloating()) {
            return visitDoubleType(new DoubleType(), context);
        }
        return integerType(context);
    }

    @Override
    public FieldType visitFloatType(FloatType floatType, NumberSpec context) {
        return floatingType(context);
    }

    @Override
    public FieldType visitDoubleType(DoubleType doubleType, NumberSpec context) {
        return floatingType(context);
    }
}
