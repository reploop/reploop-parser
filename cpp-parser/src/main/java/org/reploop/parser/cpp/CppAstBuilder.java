package org.reploop.parser.cpp;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.reploop.parser.cpp.base.CPP14Parser;
import org.reploop.parser.cpp.base.CPP14ParserBaseVisitor;
import org.reploop.parser.cpp.tree.AttributeSpecifier;
import org.reploop.parser.cpp.tree.AttributeSpecifiers;
import org.reploop.parser.cpp.tree.DeclSpecifier;
import org.reploop.parser.cpp.tree.DeclSpecifiers;
import org.reploop.parser.cpp.tree.Declaration;
import org.reploop.parser.cpp.tree.Declarations;
import org.reploop.parser.cpp.tree.Program;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class CppAstBuilder extends CPP14ParserBaseVisitor<Node> {

	private final CommonTokenStream tokenStream;

	public CppAstBuilder(CommonTokenStream tokenStream) {
		this.tokenStream = tokenStream;
	}

	@Override
	public Node visitSimpleDeclaration(CPP14Parser.SimpleDeclarationContext ctx) {
		ctx.declSpecifierSeq();
		ctx.initDeclaratorList();
		ctx.attributeSpecifierSeq();
		return super.visitSimpleDeclaration(ctx);
	}

	@Override
	public AttributeSpecifiers visitAttributeSpecifierSeq(CPP14Parser.AttributeSpecifierSeqContext ctx) {
		var specifiers = visit(ctx.attributeSpecifier(), AttributeSpecifier.class);
		return new AttributeSpecifiers(specifiers);
	}

	@Override
	public DeclSpecifiers visitDeclSpecifierSeq(CPP14Parser.DeclSpecifierSeqContext ctx) {
		var specifiers = visit(ctx.declSpecifier(), DeclSpecifier.class);
		return new DeclSpecifiers(specifiers);
	}

	@Override
	public Node visitDeclSpecifier(CPP14Parser.DeclSpecifierContext ctx) {
		ctx.functionSpecifier();
		return super.visitDeclSpecifier(ctx);
	}

	@Override
	public Node visitBlockDeclaration(CPP14Parser.BlockDeclarationContext ctx) {
		ctx.simpleDeclaration();
		return super.visitBlockDeclaration(ctx);
	}

	@Override
	public Declarations visitDeclarationseq(CPP14Parser.DeclarationseqContext ctx) {
		var ds = visit(ctx.declaration(), Declaration.class);
		return new Declarations(ds);
	}

	@Override
	public Program visitTranslationUnit(CPP14Parser.TranslationUnitContext ctx) {
		var seq = visitIfPresent(ctx.declarationseq(), Declarations.class);
		return new Program(seq);
	}

	private <R> R visitIfPresent(ParserRuleContext context, Class<R> clazz) {
		if (nonNull(context)) {
			return visit(context, clazz);
		}
		return null;
	}

	private <R> R visit(ParserRuleContext context, Class<R> clazz) {
		return clazz.cast(visit(context));
	}

	private <C extends ParserRuleContext, R extends Node> List<R> visit(List<C> contexts, Class<R> clazz) {
		if (null != contexts) {
			return contexts.stream()
				.map(this::visit)
				.filter(Objects::nonNull)
				.map(clazz::cast)
				.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
