package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.AstVisitor;
import org.reploop.parser.json.tree.Number;
import org.reploop.parser.json.tree.*;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.FieldModifier;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.*;
import org.reploop.translator.json.type.FieldTypeComparator;
import org.reploop.translator.json.type.NumberSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Long.max;
import static org.apache.commons.lang3.math.NumberUtils.toLong;
import static org.reploop.parser.QualifiedName.of;
import static org.reploop.translator.json.bean.Support.typeNumberSpec;

public class JsonMessageTranslator extends AstVisitor<Node, JsonMessageContext> {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageTranslator.class);
    private static final StructType OBJECT = new StructType("Object");
    private final FieldTypeAdaptor fieldTypeAdaptor = new FieldTypeAdaptor();
    private final FieldTypeComparator fieldTypeComparator = new FieldTypeComparator();

    @Override
    public Node visitNode(org.reploop.parser.json.Node node, JsonMessageContext context) {
        return process(node, context);
    }

    public FieldType visitJson(Json json) {
        return visitJson(json, new JsonMessageContext("$"));
    }

    @Override
    public FieldType visitJson(Json json, JsonMessageContext context) {
        return visitValue(json.getValue(), context);
    }

    @Override
    public BoolType visitBool(Bool bool, JsonMessageContext context) {
        return new BoolType();
    }

    @Override
    public FloatType visitFloat(FloatVal floatVal, JsonMessageContext context) {
        return new FloatType();
    }

    @Override
    public ByteType visitByte(ByteVal bool, JsonMessageContext context) {
        return new ByteType();
    }

    @Override
    public ShortType visitShort(ShortVal bool, JsonMessageContext context) {
        return new ShortType();
    }

    @Override
    public IntType visitInt(IntVal bool, JsonMessageContext context) {
        return new IntType();
    }

    @Override
    public DoubleType visitDouble(DoubleVal value, JsonMessageContext context) {
        return new DoubleType();
    }

    private FieldType keyType(Long value) {
        return new LongType();
    }

    @Override
    public FieldType visitObject(Entity entity, JsonMessageContext context) {
        List<Pair> pairs = entity.getPairs();
        List<Field> fields = new ArrayList<>();

        // In case digit key, then use Map
        boolean numberedKey = true;
        FieldType keyType = null;

        List<JsonMessageContext> contexts = new ArrayList<>();
        List<FieldType> valueTypes = new ArrayList<>();
        for (Pair pair : pairs) {
            JsonMessageContext ctx = new JsonMessageContext(of(context.getName(), pair.getKey()));
            Field field = visitPair(pair, ctx);
            long n;
            long max = Long.MIN_VALUE;
            if (numberedKey && Long.MIN_VALUE != (n = toLong(field.getName(), Long.MIN_VALUE))) {
                valueTypes.add(field.getType());
                max = max(n, max);
                keyType = keyType(max);
            } else {
                numberedKey = false;
            }
            fields.add(field);
            contexts.add(ctx);
        }
        // Merge contexts
        contexts.forEach(jmc -> context.addNamedMessages(jmc.getNamedMessages()));

        if (!numberedKey) {
            QualifiedName fqn = context.getName();
            Message m = new Message(fqn, fields);
            context.addNamedMessage(fqn, m);
            return new StructType(fqn);
        } else {
            Optional<FieldType> ovt = typeOf(valueTypes);
            FieldType valueType = ovt.orElse(OBJECT);
            if (diffType(valueType, valueTypes)) {
                LOGGER.warn("Value of different types, Use Object instead.");
                valueType = OBJECT;
            }
            return new MapType(keyType, valueType);
        }
    }

    @Override
    public LongType visitLong(LongVal value, JsonMessageContext context) {
        return new LongType();
    }

    @Override
    public StructType visitNull(Null value, JsonMessageContext context) {
        return new StructType("Object");
    }

    @Override
    public FieldType visitNumber(Number value, JsonMessageContext context) {
        return (FieldType) process(value, context);
    }

    @Override
    public Field visitPair(Pair pair, JsonMessageContext context) {
        FieldType fieldType = visitValue(pair.getValue(), context);
        return new Field(FieldModifier.required, 0, pair.getKey(), fieldType, Optional.empty(), Collections.emptyList());
    }

    @Override
    public StringType visitText(Text value, JsonMessageContext context) {
        return new StringType();
    }

    @Override
    public FieldType visitValue(org.reploop.parser.json.tree.Value value, JsonMessageContext context) {
        return (FieldType) process(value, context);
    }

    @Override
    public ListType visitArray(Array array, JsonMessageContext context) {
        List<org.reploop.parser.json.tree.Value> values = array.getValues();
        List<FieldType> types = Stream.ofNullable(values)
            .flatMap(Collection::stream)
            .map(value -> visitValue(value, context))
            .collect(Collectors.toList());
        Optional<FieldType> oft = typeOf(types);
        // Empty array, we cannot infer element type, so Object it is.
        FieldType fieldType = oft.orElse(OBJECT);
        return new ListType(fieldType);
    }

    private Optional<FieldType> typeOf(List<FieldType> types) {
        if (null != types && types.size() > 0) {
            FieldType fieldType = types.stream().max(fieldTypeComparator).get();
            Optional<NumberSpec> ons = typeNumberSpec(types);
            if (ons.isPresent()) {
                fieldType = fieldTypeAdaptor.visitFieldType(fieldType, ons.get());
            }
            return Optional.of(fieldType);
        }
        return Optional.empty();
    }

    /**
     * Heterogeneous type
     *
     * @param valueType  expected value type
     * @param valueTypes all value types
     * @return true if all value types are heterogeneous type.
     */
    private boolean diffType(FieldType valueType, List<FieldType> valueTypes) {
        Set<FieldType> uniq = new HashSet<>();
        if (null != valueTypes) {
            for (FieldType ft : valueTypes) {
                if (ft instanceof NumberType && valueType instanceof NumberType) {
                    uniq.add(valueType);
                } else {
                    uniq.add(ft);
                }
            }
        }
        return uniq.size() > 1;
    }
}
