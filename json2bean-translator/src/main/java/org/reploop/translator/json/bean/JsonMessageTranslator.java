package org.reploop.translator.json.bean;

import com.google.common.collect.Iterables;
import org.reploop.parser.QualifiedName;
import org.reploop.parser.json.AstVisitor;
import org.reploop.parser.json.tree.Number;
import org.reploop.parser.json.tree.*;
import org.reploop.parser.protobuf.Node;
import org.reploop.parser.protobuf.tree.Field;
import org.reploop.parser.protobuf.tree.FieldModifier;
import org.reploop.parser.protobuf.tree.Message;
import org.reploop.parser.protobuf.type.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Long.max;
import static org.apache.commons.lang3.math.NumberUtils.toLong;
import static org.reploop.parser.QualifiedName.of;

public class JsonMessageTranslator extends AstVisitor<Node, JsonMessageContext> {
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
        FieldType valueType = null;

        List<JsonMessageContext> contexts = new ArrayList<>();
        for (Pair pair : pairs) {
            JsonMessageContext ctx = new JsonMessageContext(of(context.getName(), pair.getKey()));
            Field field = visitPair(pair, ctx);
            long n;
            long max = Long.MIN_VALUE;
            if (numberedKey && Long.MIN_VALUE != (n = toLong(field.getName(), Long.MIN_VALUE))) {
                valueType = field.getType();
                max = max(n, max);
                keyType = keyType(max);
            } else {
                numberedKey = false;
            }
            fields.add(field);
            contexts.add(ctx);
        }
        if (!numberedKey) {
            QualifiedName fqn = context.getName();
            Message m = new Message(fqn, fields);
            context.addNamedMessage(fqn, m);
            contexts.forEach(jmc -> context.addNamedMessages(jmc.getNamedMessages()));
            return new StructType(fqn);
        } else {
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

    private FieldType reduce(Collection<FieldType> types) {
        if (types.size() == 1) {
            return Iterables.getOnlyElement(types);
        } else {
            return Iterables.getLast(types);
        }
    }

    @Override
    public ListType visitArray(Array array, JsonMessageContext context) {
        List<org.reploop.parser.json.tree.Value> values = array.getValues();
        Set<FieldType> types = values.stream()
            .map(value -> visitValue(value, context)).collect(Collectors.toSet());
        if (types.size() > 1) {
            System.err.println(types);
        }
        return new ListType(reduce(types));
    }
}
