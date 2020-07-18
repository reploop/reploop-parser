package org.reploop.parser.protobuf;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.reploop.parser.ParserDriver;
import org.reploop.parser.protobuf.base.ProtobufBaseLexer;
import org.reploop.parser.protobuf.base.ProtobufBaseParser;
import org.reploop.parser.protobuf.tree.ProtoProgram;
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
 * Protobuf Schema Parser.
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-07 09
 */
public class ProtobufParser extends ParserDriver<Node, ProtobufBaseLexer, ProtobufBaseParser> {
    private static final Logger LOG = LoggerFactory.getLogger(ProtobufParser.class);

    public ProtoProgram program(Path file) {
        return (ProtoProgram) parse(file, ProtobufBaseParser::program);
    }

    public ProtoProgram program(Reader file) {
        try {
            return (ProtoProgram) parse(file, ProtobufBaseParser::program);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Node parse(Path file, Function<ProtobufBaseParser, ParserRuleContext> func) {
        try (Reader reader
                     = new InputStreamReader(new FileInputStream(file.toFile()), StandardCharsets.UTF_8)) {
            return parse(reader, func);
        } catch (IOException e) {
            LOG.error("Cannot read protobuf file {}", file, e);
        } catch (StackOverflowError e) {
            LOG.error("File {} is too large to parse.", file, e);
        }
        return null;
    }

    @Override
    protected ProtobufBaseParser parser(CommonTokenStream tokenStream) {
        return new ProtobufBaseParser(tokenStream);
    }

    @Override
    protected ProtobufBaseLexer lexer(CharStream charStream) {
        return new ProtobufBaseLexer(charStream);
    }

    @Override
    protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
        return new ProtobufAstBuilder(tokenStream);
    }

    @Override
    protected ParseTreeListener parseListener() {
        return new PostProcessor();
    }

    @Override
    protected ANTLRErrorListener errorListener() {
        return new ProtobufErrorListener();
    }
}
