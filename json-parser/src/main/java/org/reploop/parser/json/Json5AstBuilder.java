package org.reploop.parser.json;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.reploop.parser.json.base.JSON5BaseVisitor;
import org.reploop.parser.json.base.JSON5Parser;
import org.reploop.parser.json.tree.Array;
import org.reploop.parser.json.tree.Bool;
import org.reploop.parser.json.tree.Entity;
import org.reploop.parser.json.tree.FloatVal;
import org.reploop.parser.json.tree.Infinity;
import org.reploop.parser.json.tree.IntVal;
import org.reploop.parser.json.tree.Json;
import org.reploop.parser.json.tree.NaN;
import org.reploop.parser.json.tree.Null;
import org.reploop.parser.json.tree.Number;
import org.reploop.parser.json.tree.Pair;
import org.reploop.parser.json.tree.Text;
import org.reploop.parser.json.tree.Value;

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
  public Number visitNumber(JSON5Parser.NumberContext ctx) {
    int sign = visitIfPresent(ctx.SYMBOL(), Text.class)
      .map(Text::getVal)
      .map(s -> {
        switch (s) {
          case "-":
            return -1;
          case "+":
          default:
            return 1;
        }
      }).orElse(1);
    var ol = visitIfPresent(ctx.NUMERIC_LITERAL(), Text.class)
      .map(Text::getVal)
      .map(s -> {
        switch (s) {
          case "Infinity":
            return new Infinity();
          case "NaN":
            return new NaN();
        }
        throw new IllegalArgumentException(s);
      });
    if (ol.isPresent()) {
      return ol.get();
    }
    var ot = visitIfPresent(ctx.NUMBER(), Text.class);
    return ot.map(Text::getVal)
      .map(v -> {
        if (v.startsWith("0x") || v.startsWith("0X")) {
          return new IntVal(Integer.parseInt(v.substring(2), 16));
        } else {
          return new FloatVal(Float.parseFloat(v));
        }
      }).get();
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
  public Text visitKey(JSON5Parser.KeyContext ctx) {
    return (Text) visitChildren(ctx);
  }

  @Override
  public Pair visitPair(JSON5Parser.PairContext ctx) {
    var key = visitKey(ctx.key());
    var value = visitValue(ctx.value());
    return new Pair(key.getVal(), value);
  }

  @Override
  public Value visitValue(JSON5Parser.ValueContext ctx) {
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
    return (Value) visitChildren(ctx);
  }

  @Override
  public Json visitJson5(JSON5Parser.Json5Context ctx) {
    var value = visitValue(ctx.value());
    return new Json(value);
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
