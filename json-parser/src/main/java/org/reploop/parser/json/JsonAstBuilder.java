package org.reploop.parser.json;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.reploop.parser.json.base.JsonBaseBaseVisitor;
import org.reploop.parser.json.base.JsonBaseParser;
import org.reploop.parser.json.tree.Number;
import org.reploop.parser.json.tree.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.strip;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2016-10-14 20
 */
public class JsonAstBuilder extends JsonBaseBaseVisitor<Node> {
    private CommonTokenStream tokens;

    public JsonAstBuilder(CommonTokenStream tokens) {
        this.tokens = tokens;
    }

    @Override
    public Json visitJson(JsonBaseParser.JsonContext ctx) {
        Value value = (Value) visit(ctx.value());
        return new Json(value);
    }

    @Override
    public Entity visitObj(JsonBaseParser.ObjContext ctx) {
        return new Entity(visit(ctx.pair(), Pair.class));
    }

    @Override
    public Pair visitPair(JsonBaseParser.PairContext ctx) {
        String text = strip(ctx.STRING().getText(), "\"").replaceAll("\\s+", "");
        return new Pair(text, visit(ctx.value(), Value.class));
    }

    @Override
    public Array visitArr(JsonBaseParser.ArrContext ctx) {
        return new Array(visit(ctx.value(), Value.class));
    }

    @Override
    public Text visitStringValue(JsonBaseParser.StringValueContext ctx) {
        return new Text(ctx.STRING().getText());
    }

    private <D extends Comparable<D>, T, E> Optional<E> castIf(D val, T min, T max, Function<T, D> to, Function<D, E> cast) {
        D minVal = to.apply(min);
        D maxVal = to.apply(max);
        if (val.compareTo(minVal) >= 0 && val.compareTo(maxVal) <= 0) {
            return Optional.of(cast.apply(val));
        }
        return Optional.empty();
    }

    @Override
    public Number visitNumberValue(JsonBaseParser.NumberValueContext ctx) {
        String val = ctx.NUMBER().getText();
        try {
            return toNumber(val);
        } catch (NumberFormatException e) {
            try {
                return toFloat(val);
            } catch (NumberFormatException ex) {
                throw new IllegalStateException(val, e);
            }
        }
    }

    private Number toNumber(String val) {
        Long value = Long.valueOf(val);
        Optional<ByteVal> ob = castIf(value, Byte.MIN_VALUE, Byte.MAX_VALUE, Byte::longValue, vb -> new ByteVal(vb.byteValue()));
        if (ob.isPresent()) {
            return ob.get();
        }
        Optional<ShortVal> os = castIf(value, Short.MIN_VALUE, Short.MAX_VALUE, Short::longValue, vs -> new ShortVal(vs.shortValue()));
        if (os.isPresent()) {
            return os.get();
        }
        Optional<IntVal> oi = castIf(value, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer::longValue, vi -> new IntVal(vi.intValue()));
        if (oi.isPresent()) {
            return oi.get();
        }
        return new LongVal(value);
    }

    private Number toFloat(String val) {
        double value = Double.parseDouble(val);
        Optional<FloatVal> of = castIf(value, Float.MIN_VALUE, Float.MAX_VALUE, Float::doubleValue, vf -> new FloatVal(vf.floatValue()));
        if (of.isPresent()) {
            return of.get();
        }
        return new DoubleVal(value);
    }

    @Override
    public Entity visitObjValue(JsonBaseParser.ObjValueContext ctx) {
        return visitObj(ctx.obj());
    }

    @Override
    public Array visitArrValue(JsonBaseParser.ArrValueContext ctx) {
        return visitArr(ctx.arr());
    }

    @Override
    public Bool visitTrueValue(JsonBaseParser.TrueValueContext ctx) {
        return new Bool(true);
    }

    @Override
    public Bool visitFalseValue(JsonBaseParser.FalseValueContext ctx) {
        return new Bool(false);
    }

    @Override
    public Null visitNullValue(JsonBaseParser.NullValueContext ctx) {
        return new Null();
    }

    private <R> R visit(ParserRuleContext context, Class<R> clazz) {
        return clazz.cast(visit(context));
    }

    private <R> Optional<R> visitIfPresent(ParserRuleContext context, Class<R> clazz) {
        return Optional.ofNullable(context)
            .map(this::visit)
            .map(clazz::cast);
    }


    private <C extends ParserRuleContext, R extends Node> List<R> visit(List<C> contexts, Class<R> clazz) {
        if (null != contexts) {
            return contexts.stream()
                .map(this::visit)
                .filter(Objects::nonNull)
                .map(clazz::cast)
                .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
