package org.reploop.parser.thrift;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.reploop.parser.ParserDriver;
import org.reploop.parser.thrift.base.ThriftBaseLexer;
import org.reploop.parser.thrift.base.ThriftBaseParser;
import org.reploop.parser.thrift.tree.ThriftProgram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.function.Function;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-07-03 00
 */
public class ThriftParser extends ParserDriver<Node, ThriftBaseLexer, ThriftBaseParser> {
    private static final Logger LOG = LoggerFactory.getLogger(ThriftParser.class);

    public ThriftProgram program(Path file) {
        return (ThriftProgram) parse(file, ThriftBaseParser::program);
    }

    public ThriftProgram program(Reader file) {
        try {
            return (ThriftProgram) parse(file, ThriftBaseParser::program);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Node parse(Path file, Function<ThriftBaseParser, ParserRuleContext> func) {
        try (Reader reader
                     = new InputStreamReader(new FileInputStream(file.toFile()), StandardCharsets.UTF_8)) {
            return parse(reader, func);
        } catch (IOException e) {
            LOG.error("Cannot read thrift file {}", file, e);
        } catch (StackOverflowError e) {
            LOG.error("File {} is too large to parse.", file, e);
        }
        return null;
    }

    @Override
    protected ThriftBaseParser parser(CommonTokenStream tokenStream) {
        return new ThriftBaseParser(tokenStream);
    }

    @Override
    protected ThriftBaseLexer lexer(CharStream charStream) {
        return new ThriftBaseLexer(charStream);
    }

    @Override
    protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
        return new ThriftAstBuilder(tokenStream);
    }

    @Override
    protected ParseTreeListener parseListener() {
        return new PostProcessor();
    }

    @Override
    protected ANTLRErrorListener errorListener() {
        return new ThriftErrorListener();
    }
}
