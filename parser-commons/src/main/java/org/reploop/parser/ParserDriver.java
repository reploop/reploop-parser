package org.reploop.parser;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.function.Function;

import static java.nio.charset.StandardCharsets.UTF_8;

public abstract class ParserDriver<Node, L extends Lexer, P extends Parser> {
  private static final Logger LOG = LoggerFactory.getLogger(ParserDriver.class);

  protected abstract P parser(CommonTokenStream tokenStream);

  protected abstract L lexer(CharStream charStream);

  protected abstract AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream);

  protected ParseTreeListener parseListener() {
    return null;
  }

  protected ANTLRErrorListener errorListener() {
    return null;
  }

  public Node parse(Path file, Function<P, ParserRuleContext> func) {
    try (Reader reader
           = new InputStreamReader(new FileInputStream(file.toFile()), UTF_8)) {
      return parse(reader, func);
    } catch (IOException e) {
      LOG.error("Cannot read file {}", file, e);
    } catch (StackOverflowError e) {
      LOG.error("File {} is too large to parse.", file, e);
    }
    return null;
  }

  public Node parse(InputStream is, Function<P, ParserRuleContext> func) {
    try {
      return parse(CharStreams.fromStream(is, UTF_8), func);
    } catch (IOException e) {
      LOG.error("Cannot read from stream", e);
    } catch (StackOverflowError e) {
      LOG.error("Content is too large to parse.", e);
    }
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
