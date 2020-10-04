package org.reploop.parser.protobuf;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.reploop.parser.ParserDriver;
import org.reploop.parser.protobuf.tree.ProtoProgram;
import org.reploop.parser.protobuf.v2.Protobuf2Lexer;
import org.reploop.parser.protobuf.v2.Protobuf2Parser;
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
public class ProtobufParser extends ParserDriver<Node, Protobuf2Lexer, Protobuf2Parser> {
    private static final Logger LOG = LoggerFactory.getLogger(ProtobufParser.class);

    public ProtoProgram program(Path file) {
        return (ProtoProgram) parse(file, Protobuf2Parser::program);
    }

    public ProtoProgram program(Reader file) {
        try {
            return (ProtoProgram) parse(file, Protobuf2Parser::program);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Node parse(Path file, Function<Protobuf2Parser, ParserRuleContext> func) {
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
    protected Protobuf2Parser parser(CommonTokenStream tokenStream) {
        return new Protobuf2Parser(tokenStream);
    }

    @Override
    protected Protobuf2Lexer lexer(CharStream charStream) {
        return new Protobuf2Lexer(charStream);
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
