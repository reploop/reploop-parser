package org.reploop.parser.json;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.reploop.parser.ParserDriver;
import org.reploop.parser.json.base.JsonBaseLexer;
import org.reploop.parser.json.base.JsonBaseParser;

/**
 * JSON parser.
 *
 * @author George Cao(georgecao@outlook.com)
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
