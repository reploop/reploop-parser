package org.reploop.parser.commons;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class ParserHelper<Node> implements ParseTreeVisitor<Node> {
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
