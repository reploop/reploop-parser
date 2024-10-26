package org.reploop.parser.json;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.reploop.parser.ParserDriver;
import org.reploop.parser.json.base.JSON5Lexer;
import org.reploop.parser.json.base.JSON5Parser;

public class Json5Parser extends ParserDriver<Node, JSON5Lexer, JSON5Parser> {
  @Override
  protected JSON5Parser parser(CommonTokenStream tokenStream) {
    return new JSON5Parser(tokenStream);
  }

  @Override
  protected JSON5Lexer lexer(CharStream charStream) {
    return new JSON5Lexer(charStream);
  }

  @Override
  protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
    return new Json5AstBuilder(tokenStream);
  }
}
