package com.qiyi.walle.parser.mysql;

import com.qiyi.walle.parser.ParserDriver;
import com.qiyi.walle.parser.mysql.base.MySqlLexer;
import com.qiyi.walle.parser.mysql.base.MySqlParser;
import com.qiyi.walle.parser.mysql.tree.Node;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.util.function.Function;

public class MySqlDriver extends ParserDriver<Node, MySqlLexer, MySqlParser> {

    public Node parse(Path sql, Function<MySqlParser, ParserRuleContext> func) throws IOException, StackOverflowError {
        return parse(CharStreams.fromPath(sql), func);
    }

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
