package org.reploop.parser.json;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.reploop.parser.json.base.JSON5BaseVisitor;
import org.reploop.parser.json.base.JSON5Parser;
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
 * JSON5 AST builder.
 */
public class Json5AstBuilder extends JSON5BaseVisitor<Node> {
    private CommonTokenStream tokens;

    public Json5AstBuilder() {
    }

    public Json5AstBuilder(CommonTokenStream tokens) {
        this.tokens = tokens;
    }

    @Override
    public Json visitJson5(JSON5Parser.Json5Context ctx) {
        return new Json((Value) visit(ctx.value()));
    }

    @Override
    public Entity visitObj(JSON5Parser.ObjContext ctx) {
        return new Entity(visit(ctx.pair(), Pair.class));
    }

    @Override
    public Pair visitPair(JSON5Parser.PairContext ctx) {
        return super.visitPair(ctx);
    }

    @Override
    public Key visitKey(JSON5Parser.KeyContext ctx) {
        ctx.STRING();
        Optional<String> os = terminalNode(ctx.STRING(), this::stripQuotationMark);
        text = ctx.STRING().getText();
        text = ctx.IDENTIFIER().getText();
        text = ctx.NUMERIC_LITERAL().getText();
        text = ctx.LITERAL().getSymbol().getText();
    }

    private Optional<String> terminalNode(TerminalNode node, Function<String, String> handler) {
        if (null != node) {
            String value = node.getText();
            if (null != handler) {
                value = handler.apply(value);
            }
            return Optional.of(value);
        }
        return Optional.empty();
    }

    @Override
    public Value visitValue(JSON5Parser.ValueContext ctx) {
        return super.visitValue(ctx);
    }

    @Override
    public Array visitArr(JSON5Parser.ArrContext ctx) {
        return super.visitArr(ctx);
    }

    @Override
    public Number visitNumber(JSON5Parser.NumberContext ctx) {
        return super.visitNumber(ctx);
    }

    public Json visitJson(JsonBaseParser.JsonContext ctx) {
        Value value = (Value) visit(ctx.value());
        return new Json(value);
    }

    public Entity visitObj(JsonBaseParser.ObjContext ctx) {
        return new Entity(visit(ctx.pair(), Pair.class));
    }

    private String stripQuotationMark(String text) {
        return strip(text, "\"");
    }

    private String removeAllWhitespace(String text) {
        return text.replaceAll("\\s+", "");
    }

    public Pair visitPair(JsonBaseParser.PairContext ctx) {
        // The key in the Key-Value pair should not have any whitespace.
        String text = removeAllWhitespace(stripQuotationMark(ctx.STRING().getText()));
        Value value = (Value) visit(ctx.value());
        return new Pair(text, value);
    }

    public Array visitArr(JsonBaseParser.ArrContext ctx) {
        return new Array(visit(ctx.value(), Value.class));
    }

    public Text visitStringValue(JsonBaseParser.StringValueContext ctx) {
        return new Text(stripQuotationMark(ctx.STRING().getText()));
    }

    private <D extends Comparable<D>, T, E> Optional<E> castIf(D val, T min, T max, Function<T, D> to, Function<D, E> cast) {
        D minVal = to.apply(min);
        D maxVal = to.apply(max);
        if (val.compareTo(minVal) >= 0 && val.compareTo(maxVal) <= 0) {
            return Optional.of(cast.apply(val));
        }
        return Optional.empty();
    }

    public Number visitNumberValue(JsonBaseParser.NumberValueContext ctx) {
        String val = ctx.NUMBER().getText();
        try {
            // Try integer first
            return toNumber(val);
        } catch (NumberFormatException e) {
            try {
                // Then it's must be floating-point number.
                return toFloat(val);
            } catch (NumberFormatException ex) {
                throw new IllegalStateException(val, e);
            }
        }
    }

    /**
     * Test number value by its legal range to tell its type.
     *
     * @param val value literal
     * @return the type of the number
     */
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

    public Entity visitObjValue(JsonBaseParser.ObjValueContext ctx) {
        return visitObj(ctx.obj());
    }

    public Array visitArrValue(JsonBaseParser.ArrValueContext ctx) {
        return visitArr(ctx.arr());
    }

    public Bool visitTrueValue(JsonBaseParser.TrueValueContext ctx) {
        return new Bool(Boolean.TRUE);
    }

    public Bool visitFalseValue(JsonBaseParser.FalseValueContext ctx) {
        return new Bool(Boolean.FALSE);
    }

    public Null visitNullValue(JsonBaseParser.NullValueContext ctx) {
        return new Null();
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
