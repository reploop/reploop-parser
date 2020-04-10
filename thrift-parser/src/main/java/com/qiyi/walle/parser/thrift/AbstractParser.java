package com.qiyi.walle.parser.thrift;

import com.qiyi.walle.parser.thrift.base.ThriftBaseLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi@iqiyi.com)
 * @since 2015-06-07 09
 */
public abstract class AbstractParser {


    protected ParserRuleContext parse(InputStream input,
                                      Function<CommonTokenStream, Parser> supplier,
                                      Function<Parser, ParserRuleContext> func) throws IOException, StackOverflowError {
        ThriftBaseLexer lexer = new ThriftBaseLexer(new ANTLRInputStream(input));
        CommonTokenStream token = new CommonTokenStream(lexer);
        Parser parser = supplier.apply(token);

        parser.addParseListener(new PostProcessor());

        ThriftErrorListener errorListener = new ThriftErrorListener();
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        ParserRuleContext tree;
        try {
            // first, try parsing with potentially faster SLL mode
            parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
            tree = func.apply(parser);
        } catch (ParseCancellationException ex) {
            // if we fail, parse with LL mode
            token.reset(); // rewind input stream
            parser.reset();

            parser.getInterpreter().setPredictionMode(PredictionMode.LL);
            tree = func.apply(parser);
        }
        return tree;
    }
}
