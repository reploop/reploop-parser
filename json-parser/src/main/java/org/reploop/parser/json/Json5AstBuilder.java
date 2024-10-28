package org.reploop.parser.json;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.checkerframework.checker.units.qual.C;
import org.reploop.parser.json.json5.JSON5BaseVisitor;
import org.reploop.parser.json.json5.JSON5Parser;
import org.reploop.parser.json.tree.*;
import org.reploop.parser.json.tree.Number;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class Json5AstBuilder extends JSON5BaseVisitor<Node> {

	private CommonTokenStream tokenStream;

	public Json5AstBuilder(CommonTokenStream tokenStream) {
		this.tokenStream = tokenStream;
	}

	@Override
	public Array visitArr(JSON5Parser.ArrContext ctx) {
		var values = visit(ctx.value(), Value.class);
		return new Array(values);
	}

	@Override
	public Number visitNumberValue(JSON5Parser.NumberValueContext ctx) {
		return visitNumber(ctx.number());
	}

	@Override
	public Text visitStringValue(JSON5Parser.StringValueContext ctx) {
		return visitIfPresent(ctx.STRING(), Text.class).orElseThrow();
	}

	@Override
	public Entity visitObjValue(JSON5Parser.ObjValueContext ctx) {
		return visitObj(ctx.obj());
	}

	@Override
	public Array visitArrayValue(JSON5Parser.ArrayValueContext ctx) {
		return visitArr(ctx.arr());
	}

	private int sign(TerminalNode node) {
		return visitIfPresent(node, Text.class).map(Text::getVal).map(s -> {
			switch (s) {
				case "-":
					return -1;
				case "+":
				default:
					return 1;
			}
		}).orElse(1);
	}

	@Override
	public Number visitNumber(JSON5Parser.NumberContext ctx) {
		int sign = sign(ctx.SYMBOL());
		var ol = visitIfPresent(ctx.NUMERIC_LITERAL(), Text.class).map(Text::getVal).map(s -> {
			switch (s) {
				case "Infinity":
					return new Infinity(sign);
				case "NaN":
					return new NaN();
			}
			throw new IllegalArgumentException(s);
		});
		if (ol.isPresent()) {
			return ol.get();
		}
		var ot = visitIfPresent(ctx.NUMBER(), Text.class);
		return ot.map(Text::getVal).map(v -> {
			if (v.startsWith("0x") || v.startsWith("0X")) {
				return new IntVal(Integer.parseInt(v.substring(2), 16));
			}
			return new DoubleVal(sign * Double.parseDouble(v));
		}).orElseThrow();
	}

	@Override
	public Entity visitObj(JSON5Parser.ObjContext ctx) {
		var pairs = visit(ctx.pair(), Pair.class);
		return new Entity(pairs);
	}

	@Override
	public Text visitTerminal(TerminalNode node) {
		return new Text(node.getText());
	}

	@Override
	public Pair visitPair(JSON5Parser.PairContext ctx) {
		var key = visit(ctx.key(), Text.class);
		var value = visit(ctx.value(), Value.class);
		return new Pair(key.getVal(), value);
	}

	@Override
	public Value visitLiteralValue(JSON5Parser.LiteralValueContext ctx) {
		var ot = visitIfPresent(ctx.LITERAL(), Text.class);
		if (ot.isPresent()) {
			switch (ot.get().getVal()) {
				case "true":
					return new Bool(true);
				case "false":
					return new Bool(false);
				case "null":
					return new Null();
			}
		}
		throw new IllegalStateException(ctx.getText());
	}

	@Override
	public Json5 visitJson5(JSON5Parser.Json5Context ctx) {
		var value = visit(ctx.value(), Value.class);
		return new Json5(value);
	}

	protected <R> Optional<R> visitIfPresent(ParserRuleContext context, Class<R> clazz) {
		if (nonNull(context)) {
			return Optional.of(visit(context, clazz));
		}
		return Optional.empty();
	}

	protected <R> Optional<R> visitIfPresent(TerminalNode node, Class<R> clazz) {
		if (nonNull(node)) {
			return Optional.of(clazz.cast(node.accept(this)));
		}
		return Optional.empty();
	}

	protected <R> R visit(ParserRuleContext context, Class<R> clazz) {
		return clazz.cast(visit(context));
	}

	protected <C extends ParserRuleContext, R extends Node> List<R> visit(List<C> contexts, Class<R> clazz) {
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
