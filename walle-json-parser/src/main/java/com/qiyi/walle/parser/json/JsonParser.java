package com.qiyi.walle.parser.json;

import com.qiyi.walle.parser.ParserDriver;
import com.qiyi.walle.parser.json.base.JsonBaseLexer;
import com.qiyi.walle.parser.json.base.JsonBaseParser;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * What's this about?
 *
 * @author George Cao(caozhangzhi at qiyi.com)
 * @since 2017-01-23 14
 */
public class JsonParser extends ParserDriver<Node, JsonBaseLexer, JsonBaseParser> {

    @Override
    protected JsonBaseParser parser(CommonTokenStream tokenStream) {
        return new JsonBaseParser(tokenStream);
    }

    @Override
    protected JsonBaseLexer lexer(CharStream charStream) {
        return new JsonBaseLexer(charStream);
    }

    @Override
    protected AbstractParseTreeVisitor<Node> visitor(CommonTokenStream tokenStream) {
        return new JsonAstBuilder(tokenStream);
    }

    @Override
    protected ANTLRErrorListener errorListener() {
        return new JsonErrorListener();
    }
}
