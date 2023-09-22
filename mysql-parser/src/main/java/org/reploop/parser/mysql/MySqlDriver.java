package org.reploop.parser.mysql;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.reploop.parser.ParserDriver;
import org.reploop.parser.mysql.base.MySQLLexer;
import org.reploop.parser.mysql.base.MySQLParser;
import org.reploop.parser.mysql.tree.Node;

import java.io.IOException;
import java.io.StringReader;
import java.util.function.Function;

public class MySqlDriver extends ParserDriver<Node, MySQLLexer, MySQLParser> {

  public Node parse(String sql, Function<MySQLParser, ParserRuleContext> func) throws IOException, StackOverflowError {
    return parse(new StringReader(sql), func);
  }

  @Override
  protected MySQLParser parser(CommonTokenStream tokenStream) {
    return new MySQLParser(tokenStream);
  }

  @Override
  protected MySQLLexer lexer(CharStream charStream) {
    return new MySQLLexer(charStream);
  }

  @Override
  protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
    return new MySqlAstBuilder(tokenStream);
  }
}
