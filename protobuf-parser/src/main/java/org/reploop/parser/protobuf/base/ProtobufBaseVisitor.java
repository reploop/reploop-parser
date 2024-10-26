// Generated from com/reploop/walle/parser/protobuf/base/ProtobufBase.g4 by ANTLR 4.8
package org.reploop.parser.protobuf.base;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by
 * {@link ProtobufBaseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with
 * no return type.
 */
public interface ProtobufBaseVisitor<T> extends ParseTreeVisitor<T> {

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ProtobufBaseParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by the {@code namespaceDefinition} labeled alternative
	 * in {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceDefinition(ProtobufBaseParser.NamespaceDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code includeDefinition} labeled alternative in
	 * {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDefinition(ProtobufBaseParser.IncludeDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code syntaxDefinition} labeled alternative in
	 * {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxDefinition(ProtobufBaseParser.SyntaxDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#syntax}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntax(ProtobufBaseParser.SyntaxContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespace(ProtobufBaseParser.NamespaceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(ProtobufBaseParser.IncludeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(ProtobufBaseParser.MessageContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(ProtobufBaseParser.OptionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code optionPair} labeled alternative in
	 * {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionPair(ProtobufBaseParser.OptionPairContext ctx);

	/**
	 * Visit a parse tree produced by the {@code defaultPair} labeled alternative in
	 * {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultPair(ProtobufBaseParser.DefaultPairContext ctx);

	/**
	 * Visit a parse tree produced by the {@code commonPair} labeled alternative in
	 * {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonPair(ProtobufBaseParser.CommonPairContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#enumeration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeration(ProtobufBaseParser.EnumerationContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#nameIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameIndex(ProtobufBaseParser.NameIndexContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(ProtobufBaseParser.FieldContext ctx);

	/**
	 * Visit a parse tree produced by the {@code syntaxName} labeled alternative in
	 * {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxName(ProtobufBaseParser.SyntaxNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code packageName} labeled alternative in
	 * {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(ProtobufBaseParser.PackageNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code messageName} labeled alternative in
	 * {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageName(ProtobufBaseParser.MessageNameContext ctx);

	/**
	 * Visit a parse tree produced by the {@code idName} labeled alternative in
	 * {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdName(ProtobufBaseParser.IdNameContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#multiOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiOptions(ProtobufBaseParser.MultiOptionsContext ctx);

	/**
	 * Visit a parse tree produced by the {@code intValue} labeled alternative in
	 * {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(ProtobufBaseParser.IntValueContext ctx);

	/**
	 * Visit a parse tree produced by the {@code floatValue} labeled alternative in
	 * {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatValue(ProtobufBaseParser.FloatValueContext ctx);

	/**
	 * Visit a parse tree produced by the {@code boolValue} labeled alternative in
	 * {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(ProtobufBaseParser.BoolValueContext ctx);

	/**
	 * Visit a parse tree produced by the {@code stringValue} labeled alternative in
	 * {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(ProtobufBaseParser.StringValueContext ctx);

	/**
	 * Visit a parse tree produced by the {@code structValue} labeled alternative in
	 * {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructValue(ProtobufBaseParser.StructValueContext ctx);

	/**
	 * Visit a parse tree produced by the {@code primitiveType} labeled alternative in
	 * {@link ProtobufBaseParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(ProtobufBaseParser.PrimitiveTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code messageOrEnumType} labeled alternative in
	 * {@link ProtobufBaseParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageOrEnumType(ProtobufBaseParser.MessageOrEnumTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#extensions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensions(ProtobufBaseParser.ExtensionsContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#extend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtend(ProtobufBaseParser.ExtendContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(ProtobufBaseParser.ServiceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ProtobufBaseParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ProtobufBaseParser.FunctionContext ctx);

}