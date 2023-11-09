package org.reploop.parser.cpp;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

public class CppAstBuilder extends AbstractParseTreeVisitor<Node> {
  private final CommonTokenStream tokenStream;

  public CppAstBuilder(CommonTokenStream tokenStream) {
    this.tokenStream = tokenStream;
  }
}
