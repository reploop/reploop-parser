package org.reploop.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.function.Function;

public abstract class ParserDriver<NODE, L extends Lexer, P extends Parser> {
    private static final Logger LOG = LoggerFactory.getLogger(ParserDriver.class);

    /**
     * Initialize a {@link Parser}.
     *
     * @param tokenStream source token stream to parse
     * @return concrete instance of the {@link Parser}
     * @see #lexer(CharStream)
     */
    protected abstract P parser(CommonTokenStream tokenStream);

    /**
     * Initialize a {@link  Lexer}.
     *
     * @param charStream source token stream provided
     * @return concrete instance of {@link  Lexer}
     */
    protected abstract L lexer(CharStream charStream);

    /**
     * Initialize a {@link AbstractParseTreeVisitor}.
     *
     * @param tokenStream the source token stream.
     * @return the visitor
     */
    protected abstract AbstractParseTreeVisitor<NODE> visitor(CommonTokenStream tokenStream);

    protected ParseTreeListener parseListener() {
        return null;
    }

    protected ANTLRErrorListener errorListener() {
        return null;
    }

    /**
     * Parse the source to build AST.
     *
     * @param file the JSON source file
     * @param func the entry point which must matches the source
     * @return AST
     */
    public NODE parse(Path file, Function<P, ParserRuleContext> func) {
        try (Reader reader
                 = new InputStreamReader(new FileInputStream(file.toFile()), StandardCharsets.UTF_8)) {
            return parse(reader, func);
        } catch (IOException e) {
            LOG.error("Cannot read source file {}", file, e);
        } catch (StackOverflowError e) {
            LOG.error("File {} is too large to parse.", file, e);
        }
        return null;
    }

    public NODE parse(Reader reader, Function<P, ParserRuleContext> func) throws IOException, StackOverflowError {
        return parse(CharStreams.fromReader(reader), func);
    }

    public NODE parse(CharStream charStream, Function<P, ParserRuleContext> func) throws StackOverflowError {
        L lexer = lexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        P parser = parser(tokenStream);

        ParseTreeListener parseListener = parseListener();
        if (null != parseListener) {
            parser.addParseListener(parseListener);
        }

        ANTLRErrorListener errorListener = errorListener();
        if (null != errorListener) {
            // For lexer
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);

            // For parser
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);
        }

        ParserRuleContext context;
        try {
            // Try the fastest prediction mode first.
            parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
            context = func.apply(parser);
        } catch (ParseCancellationException e) {
            // if we fail, parse with LL mode
            tokenStream.seek(0); // rewind input stream
            parser.reset();

            parser.getInterpreter().setPredictionMode(PredictionMode.LL);
            context = func.apply(parser);
        }
        return visitor(tokenStream).visit(context);
    }
}
