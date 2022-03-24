package org.reploop.translator.json.bean;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.AstVisitor;
import org.reploop.parser.json.JsonParser;
import org.reploop.parser.json.base.JsonBaseParser;
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

import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;
import static org.apache.commons.text.StringEscapeUtils.unescapeJson;
import static org.reploop.translator.json.support.TypeSupport.isLegalIdentifier;
import static org.reploop.translator.json.support.TypeSupport.typeNumberSpec;

/**
 * Translate JSON AST to protobuf message, and it's type.
 */
public class JsonMessageTranslator extends AstVisitor<Node, JsonMessageContext> {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageTranslator.class);
    private static final String OS = "Object";
    private static final StructType OBJECT = new StructType(OS);
    private static final int DEFAULT_INDEX = 0;
    private final JsonNumberTypeAdaptor jsonNumberTypeAdaptor;
    private final FieldTypeComparator fieldTypeComparator;
    private final JsonParser jsonParser;

    public JsonMessageTranslator() {
        this(new JsonNumberTypeAdaptor(), new FieldTypeComparator(), new JsonParser());
    }

    public JsonMessageTranslator(JsonNumberTypeAdaptor jsonNumberTypeAdaptor,
                                 FieldTypeComparator fieldTypeComparator,
                                 JsonParser jsonParser) {
        this.jsonNumberTypeAdaptor = jsonNumberTypeAdaptor;
        this.fieldTypeComparator = fieldTypeComparator;
        this.jsonParser = jsonParser;
    }

    @Override
    public Node visitNode(org.reploop.parser.json.Node node, JsonMessageContext context) {
        return process(node, context);
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

    private Optional<FieldType> ifValueLiterals(String l, JsonMessageContext context) {
        if (isParsable(l)) {
            try {
                StringReader reader = new StringReader(l);
                Value value = (Value) jsonParser.parse(reader, JsonBaseParser::value);
                return Optional.ofNullable(visitValue(value, context));
            } catch (Exception e) {
                LOGGER.error("Cannot parse {} to value", l, e);
            }
        }
        return empty();
    }

    @Override
    public FieldType visitObject(Entity entity, JsonMessageContext context) {
        List<Pair> pairs = entity.getPairs();
        List<Field> fields = new ArrayList<>();

        List<JsonMessageContext> contexts = new ArrayList<>();
        List<FieldType> keyTypes = new ArrayList<>();
        List<FieldType> valueTypes = new ArrayList<>();

        // In case of illegal key, use Map instead of object
        boolean anyIllegalIdentifier = pairs.stream()
                .filter(Objects::nonNull)
                .map(Pair::getKey)
                .filter(Objects::nonNull)
                .anyMatch(key -> !isLegalIdentifier(key));

        for (Pair pair : pairs) {
            JsonMessageContext ctx;
            Field field;
            if (anyIllegalIdentifier) {
                // If we find illegal identifier key, then treat this pair as an entry in Map.
                // Do not add level, keeps to the parent's level
                ctx = new JsonMessageContext(context.getName());
                // Test the key type, Use string type by default.
                FieldType keyType = ifValueLiterals(pair.getKey(), ctx).orElse(new StringType());
                keyTypes.add(keyType);
                // Visit the pair, and infer the value type.
                field = visitPair(pair, ctx);
                valueTypes.add(field.getType());
            } else {
                ctx = new JsonMessageContext(QualifiedName.of(context.getName(), pair.getKey()));
                field = visitPair(pair, ctx);
            }
            fields.add(field);
            contexts.add(ctx);
        }
        // Merge contexts
        contexts.forEach(jmc -> context.addNamedMessages(jmc.getNamedMessages()));

        if (anyIllegalIdentifier) {
            Optional<FieldType> ovt = typeOf(valueTypes);
            FieldType valueType = ovt.orElse(OBJECT);
            if (diffType(valueType, valueTypes)) {
                LOGGER.warn("Value of different types, Use Object instead.");
                valueType = OBJECT;
            }
            // Map key as string by default
            FieldType keyType = typeOf(keyTypes).orElse(new StringType());
            return new MapType(keyType, valueType);
        } else {
            QualifiedName fqn = context.getName();
            Message m = new Message(fqn, fields, emptyList(), emptyList(), emptyList());
            context.addNamedMessage(fqn, m);
            return new StructType(fqn);
        }
    }

    @Override
    public LongType visitLong(LongVal value, JsonMessageContext context) {
        return new LongType();
    }

    /**
     * Infer null value's type as Object.
     */
    @Override
    public StructType visitNull(Null value, JsonMessageContext context) {
        return OBJECT;
    }

    @Override
    public FieldType visitNumber(Number value, JsonMessageContext context) {
        return (FieldType) process(value, context);
    }

    @Override
    public Field visitPair(Pair pair, JsonMessageContext context) {
        FieldType fieldType = visitValue(pair.getValue(), context);
        // Use a default index, in order to compare different fields.
        return new Field(FieldModifier.optional, DEFAULT_INDEX, pair.getKey(), fieldType, empty(), emptyList());
    }

    @Override
    public FieldType visitText(Text value, JsonMessageContext context) {
        String val = value.getVal();
        if (context.isJsonRawValue()) {
            if (isNullOrEmpty(val)) {
                return visitNull(new Null(), context);
            }
            String text = unescapeJson(val);
            try {
                Json json = (Json) jsonParser.parse(new StringReader(text), JsonBaseParser::json);
                return visitJson(json, context);
            } catch (Exception e) {
                LOGGER.warn("Cannot process raw json {}", val, e);
            }
        }
        return new StringType();
    }

    @Override
    public FieldType visitValue(org.reploop.parser.json.tree.Value value, JsonMessageContext context) {
        return (FieldType) process(value, context);
    }

    @Override
    public ListType visitArray(Array array, JsonMessageContext context) {
        List<FieldType> types = Stream.ofNullable(array.getValues())
                .filter(Objects::nonNull)
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
            if (fieldType instanceof NumberType) {
                Optional<NumberSpec> ons = typeNumberSpec(types);
                if (ons.isPresent()) {
                    fieldType = jsonNumberTypeAdaptor.visitFieldType(fieldType, ons.get());
                }
            }
            return Optional.of(fieldType);
        }
        return empty();
    }

    /**
     * Heterogeneous or homogeneous type
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
