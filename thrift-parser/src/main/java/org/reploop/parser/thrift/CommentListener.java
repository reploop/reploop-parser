package org.reploop.parser.thrift;

import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.reploop.parser.thrift.base.ThriftBaseBaseListener;
import org.reploop.parser.thrift.base.ThriftBaseLexer;
import org.reploop.parser.thrift.base.ThriftBaseParser;

import java.util.List;

/**
 * What's this about?
 *
 * @author George Cao(georgecao@outlook.com)
 * @since 2015-06-10 15
 */
public class CommentListener extends ThriftBaseBaseListener {

	BufferedTokenStream tokens;

	TokenStreamRewriter rewriter;

	public CommentListener(BufferedTokenStream tokens) {
		this.tokens = tokens;
		this.rewriter = new TokenStreamRewriter(tokens);
	}

	@Override
	public void exitProgram(ThriftBaseParser.ProgramContext ctx) {
		Token startToken = ctx.getStart();
		int startIndex = startToken.getTokenIndex();
		List<Token> channel = tokens.getHiddenTokensToLeft(startIndex, ThriftBaseLexer.HIDDEN);
		if (null != channel) {
			Token commentToken = channel.get(0);
			if (null != commentToken) {
				String comment = commentToken.getText();
				rewriter.insertBefore(startIndex, comment);
				rewriter.replace(commentToken, "\n");
			}
		}
	}

	@Override
	public void exitService(ThriftBaseParser.ServiceContext ctx) {
		Token startToken = ctx.getStart();
		int startIndex = startToken.getTokenIndex();
		List<Token> channel = tokens.getHiddenTokensToLeft(startIndex, ThriftBaseLexer.HIDDEN);
		if (null != channel) {
			Token commentToken = channel.get(0);
			if (null != commentToken) {
				String comment = commentToken.getText();
				rewriter.insertBefore(startIndex, comment);
				rewriter.replace(commentToken, "\n");
			}
		}
	}

	@Override
	public void exitFunction(ThriftBaseParser.FunctionContext ctx) {
		Token startToken = ctx.getStart();
		int startIndex = startToken.getTokenIndex();
		List<Token> channel = tokens.getHiddenTokensToLeft(startIndex, ThriftBaseLexer.HIDDEN);
		if (null != channel) {
			Token commentToken = channel.get(0);
			if (null != commentToken) {
				String comment = commentToken.getText();
				rewriter.insertBefore(startIndex, comment);
				rewriter.replace(commentToken, "\n");
			}
		}
	}

	@Override
	public void exitField(ThriftBaseParser.FieldContext ctx) {
		Token startToken = ctx.getStart();
		int startIndex = startToken.getTokenIndex();
		List<Token> channel = tokens.getHiddenTokensToLeft(startIndex, ThriftBaseLexer.HIDDEN);
		if (null != channel) {
			Token commentToken = channel.get(0);
			if (null != commentToken) {
				String comment = commentToken.getText();
				rewriter.insertBefore(startIndex, comment);
				rewriter.replace(commentToken, "\n");
			}
		}
	}

}
