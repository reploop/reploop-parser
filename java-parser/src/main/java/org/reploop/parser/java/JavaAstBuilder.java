package org.reploop.parser.java;

import org.antlr.v4.runtime.TokenStream;
import org.reploop.parser.java.base.JavaParser;
import org.reploop.parser.java.base.JavaParserBaseVisitor;

public class JavaAstBuilder extends JavaParserBaseVisitor<Node> {

	final TokenStream tokenStream;

	public JavaAstBuilder(TokenStream tokenStream) {
		this.tokenStream = tokenStream;
	}

	@Override
	public Node visitExpression(JavaParser.ExpressionContext ctx) {
		return super.visitExpression(ctx);
	}

}
