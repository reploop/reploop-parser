package org.reploop.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;

public abstract class ParserDriver<Node, L extends Lexer, P extends Parser> {

    protected abstract P parser(CommonTokenStream tokenStream);

    protected abstract L lexer(CharStream charStream);

    protected abstract AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream);

    protected ParseTreeListener parseListener() {
        return null;
    }

    protected ANTLRErrorListener errorListener() {
        return null;
    }

    public Node parse(Reader reader, Function<P, ParserRuleContext> func) throws IOException, StackOverflowError {
        return parse(CharStreams.fromReader(reader), func);
    }

    public Node parse(CharStream charStream, Function<P, ParserRuleContext> func) throws StackOverflowError {
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
