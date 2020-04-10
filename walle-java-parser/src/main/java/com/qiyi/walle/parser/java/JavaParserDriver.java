package com.qiyi.walle.parser.java;

import com.qiyi.walle.parser.ParserDriver;
import com.qiyi.walle.parser.java.base.JavaLexer;
import com.qiyi.walle.parser.java.base.JavaParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.function.Function;

public class JavaParserDriver extends ParserDriver<Node, JavaLexer, JavaParser> {
    private static final Logger LOG = LoggerFactory.getLogger(JavaParserDriver.class);

    @Override
    protected JavaParser parser(CommonTokenStream tokenStream) {
        return new JavaParser(tokenStream);
    }

    @Override
    protected JavaLexer lexer(CharStream charStream) {
        return new JavaLexer(charStream);
    }

    public Node parse(Path file, Function<JavaParser, ParserRuleContext> func) {
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
    protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
        return new JavaAstBuilder(tokenStream);
    }
}
