package org.reploop.parser.mysql;

import org.reploop.parser.ParserDriver;
import org.reploop.parser.mysql.base.MySqlLexer;
import org.reploop.parser.mysql.base.MySqlParser;
import org.reploop.parser.mysql.tree.Node;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.io.IOException;
import java.io.StringReader;
import java.util.function.Function;

public class MySqlDriver extends ParserDriver<Node, MySqlLexer, MySqlParser> {

    public Node parse(String sql, Function<MySqlParser, ParserRuleContext> func) throws IOException, StackOverflowError {
        return parse(new StringReader(sql), func);
    }

    @Override
    protected MySqlParser parser(CommonTokenStream tokenStream) {
        return new MySqlParser(tokenStream);
    }

    @Override
    protected MySqlLexer lexer(CharStream charStream) {
        return new MySqlLexer(charStream);
    }

    @Override
    protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
        return new MySqlAstBuilder(tokenStream);
    }
}
