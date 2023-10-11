package org.reploop.translator.json.bean;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;
import static org.apache.commons.text.StringEscapeUtils.unescapeJson;
import static org.reploop.translator.json.support.Constants.DATE_PATTERN;
import static org.reploop.translator.json.support.Constants.DATE_TIMEZONE;
import static org.reploop.translator.json.support.NameSupport.IMPORT_LOCAL_DATETIME;
import static org.reploop.translator.json.support.TypeSupport.isLegalIdentifier;
import static org.reploop.translator.json.support.TypeSupport.typeNumberSpec;

import com.google.common.collect.ImmutableList;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.AstVisitor;
import org.reploop.parser.json.JsonParser;
import org.reploop.parser.json.base.JsonBaseParser;
import org.reploop.parser.json.tree.Array;
import org.reploop.parser.json.tree.Bool;
import org.reploop.parser.json.tree.ByteVal;
import org.reploop.parser.json.tree.DoubleVal;
import org.reploop.parser.json.tree.Entity;
import org.reploop.parser.json.tree.FloatVal;
import org.reploop.parser.json.tree.IntVal;
import org.reploop.parser.json.tree.Json;
import org.reploop.parser.json.tree.LongVal;
import org.reploop.parser.json.tree.Null;
import org.reploop.parser.json.tree.Number;
import org.reploop.parser.json.tree.Pair;
import org.reploop.parser.json.tree.ShortVal;
import org.reploop.parser.json.tree.Text;
import org.reploop.parser.json.tree.Value;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.CommonPair;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.FieldModifier;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.tree.Option;
import org.reploop.parser.protobuf.tree.StringValue;
import org.reploop.parser.protobuf.type.BoolType;
import org.reploop.parser.protobuf.type.ByteType;
import org.reploop.parser.protobuf.type.DoubleType;
import org.reploop.parser.protobuf.type.FieldType;
import org.reploop.parser.protobuf.type.FloatType;
import org.reploop.parser.protobuf.type.IntType;
import org.reploop.parser.protobuf.type.ListType;
import org.reploop.parser.protobuf.type.LongType;
import org.reploop.parser.protobuf.type.MapType;
import org.reploop.parser.protobuf.type.NumberType;
import org.reploop.parser.protobuf.type.SetType;
import org.reploop.parser.protobuf.type.ShortType;
import org.reploop.parser.protobuf.type.StringType;
import org.reploop.parser.protobuf.type.StructType;
import org.reploop.translator.json.type.FieldTypeComparator;
import org.reploop.translator.json.type.NumberSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Translate JSON AST to protobuf message, and it's type.
 */
public class JsonMessageTranslator extends AstVisitor<Node, MessageContext> {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageTranslator.class);
  private static final String OS = "Object";
  private static final StructType OBJECT = new StructType(OS);
  private static final int DEFAULT_INDEX = 0;
  private final NumberTypeAdaptor jsonNumberTypeAdaptor;
  private final FieldTypeComparator fieldTypeComparator;
  private final JsonParser jsonParser;

  public JsonMessageTranslator() {
    this(new NumberTypeAdaptor(), new FieldTypeComparator(), new JsonParser());
  }

  public JsonMessageTranslator(NumberTypeAdaptor jsonNumberTypeAdaptor,
                               FieldTypeComparator fieldTypeComparator,
                               JsonParser jsonParser) {
    this.jsonNumberTypeAdaptor = jsonNumberTypeAdaptor;
    this.fieldTypeComparator = fieldTypeComparator;
    this.jsonParser = jsonParser;
  }

  @Override
  public Node visitNode(org.reploop.parser.json.Node node, MessageContext context) {
    return process(node, context);
  }

  @Override
  public FieldType visitJson(Json json, MessageContext context) {
    return visitValue(json.getValue(), context);
  }

  @Override
  public BoolType visitBool(Bool bool, MessageContext context) {
    return new BoolType();
  }

  @Override
  public FloatType visitFloat(FloatVal floatVal, MessageContext context) {
    return new FloatType();
  }

  @Override
  public ByteType visitByte(ByteVal bool, MessageContext context) {
    return new ByteType();
  }

  @Override
  public ShortType visitShort(ShortVal bool, MessageContext context) {
    return new ShortType();
  }

  @Override
  public IntType visitInt(IntVal bool, MessageContext context) {
    return new IntType();
  }

  @Override
  public DoubleType visitDouble(DoubleVal value, MessageContext context) {
    return new DoubleType();
  }

  private Optional<FieldType> ifValueLiterals(String l, MessageContext context) {
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
  public FieldType visitObject(Entity entity, MessageContext context) {
    List<Pair> pairs = entity.getPairs();
    List<Field> fields = new ArrayList<>();

    List<MessageContext> contexts = new ArrayList<>();
    List<FieldType> keyTypes = new ArrayList<>();
    List<FieldType> valueTypes = new ArrayList<>();

    // In case of illegal key, use Map instead of object
    boolean anyIllegalIdentifier = pairs.stream()
      .filter(Objects::nonNull)
      .map(Pair::getKey)
      .filter(Objects::nonNull)
      .anyMatch(key -> !isLegalIdentifier(key));

    for (Pair pair : pairs) {
      MessageContext ctx;
      Field field;
      if (anyIllegalIdentifier) {
        // If we find illegal identifier key, then treat this pair as an entry in Map.
        // Do not add level, keeps to the parent's level
        ctx = new MessageContext(context.getName());
        // Test the key type, Use string type by default.
        FieldType keyType = ifValueLiterals(pair.getKey(), ctx).orElse(new StringType());
        keyTypes.add(keyType);
        // Visit the pair, and infer the value type.
        field = visitPair(pair, ctx);
        valueTypes.add(field.getType());
      } else {
        ctx = new MessageContext(QualifiedName.of(context.getName(), pair.getKey()));
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
  public LongType visitLong(LongVal value, MessageContext context) {
    return new LongType();
  }

  /**
   * Infer null value's type as Object.
   */
  @Override
  public StructType visitNull(Null value, MessageContext context) {
    return OBJECT;
  }

  @Override
  public FieldType visitNumber(Number value, MessageContext context) {
    return (FieldType) process(value, context);
  }

  @Override
  public Field visitPair(Pair pair, MessageContext context) {
    FieldType fieldType = visitValue(pair.getValue(), context);
    var od = context.hasDateFormat();
    var obs = ImmutableList.<Option>builder();
    if (od.isPresent() && fieldType instanceof StringType) {
      String format = od.get();
      obs.add(new CommonPair(DATE_PATTERN, new StringValue(format)));
      context.hasTimeZone()
        .map(StringValue::new)
        .map(timezone -> new CommonPair(DATE_TIMEZONE, timezone))
        .ifPresent(obs::add);
    }
    FieldModifier modifier = FieldModifier.optional;
    if (fieldType instanceof ListType || fieldType instanceof SetType) {
      modifier = FieldModifier.repeated;
    } else if (fieldType instanceof MapType) {
      modifier = null;
    }
    // Use a default index, in order to compare different fields.
    return new Field(modifier, DEFAULT_INDEX, pair.getKey(), fieldType, Optional.empty(),
      Collections.emptyList(), obs.build());
  }

  @Override
  public FieldType visitText(Text value, MessageContext context) {
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
  public FieldType visitValue(org.reploop.parser.json.tree.Value value, MessageContext context) {
    return (FieldType) process(value, context);
  }

  @Override
  public ListType visitArray(Array array, MessageContext context) {
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
    if (null != types && !types.isEmpty()) {
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
