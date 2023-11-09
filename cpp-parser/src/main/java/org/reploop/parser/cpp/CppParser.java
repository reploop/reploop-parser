package org.reploop.parser.cpp;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.reploop.parser.ParserDriver;
import org.reploop.parser.cpp.base.CPP14Lexer;
import org.reploop.parser.cpp.base.CPP14Parser;

public class CppParser extends ParserDriver<Node, CPP14Lexer, CPP14Parser> {
  @Override
  protected CPP14Parser parser(CommonTokenStream tokenStream) {
    return new CPP14Parser(tokenStream);
  }

  @Override
  protected CPP14Lexer lexer(CharStream charStream) {
    return new CPP14Lexer(charStream);
  }

  @Override
  protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
    return new CppAstBuilder(tokenStream);
  }
}
