package com.qiyi.walle.parser.java;

import com.qiyi.walle.parser.java.base.JavaParser;
import com.qiyi.walle.parser.java.base.JavaParserBaseVisitor;
import org.antlr.v4.runtime.TokenStream;

public class JavaAstBuilder extends JavaParserBaseVisitor<Node> {
    TokenStream tokenStream;

    public JavaAstBuilder(TokenStream tokenStream) {
        this.tokenStream = tokenStream;
    }

    @Override
    public Node visitExpression(JavaParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }
}
