// Generated from org/reploop/parser/protobuf/v2/Protobuf2.g4 by ANTLR 4.8
package org.reploop.parser.protobuf.v2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Protobuf2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Protobuf2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(Protobuf2Parser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namespaceDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceDefinition(Protobuf2Parser.NamespaceDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code includeDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDefinition(Protobuf2Parser.IncludeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code syntaxDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxDefinition(Protobuf2Parser.SyntaxDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#syntax}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntax(Protobuf2Parser.SyntaxContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespace(Protobuf2Parser.NamespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(Protobuf2Parser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessage(Protobuf2Parser.MessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(Protobuf2Parser.OptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code optionPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionPair(Protobuf2Parser.OptionPairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultPair(Protobuf2Parser.DefaultPairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commonPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonPair(Protobuf2Parser.CommonPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#enumeration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeration(Protobuf2Parser.EnumerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#nameIndex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameIndex(Protobuf2Parser.NameIndexContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(Protobuf2Parser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by the {@code syntaxName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyntaxName(Protobuf2Parser.SyntaxNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code packageName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(Protobuf2Parser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code messageName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageName(Protobuf2Parser.MessageNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdName(Protobuf2Parser.IdNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#multiOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiOptions(Protobuf2Parser.MultiOptionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(Protobuf2Parser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatValue(Protobuf2Parser.FloatValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolValue(Protobuf2Parser.BoolValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(Protobuf2Parser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructValue(Protobuf2Parser.StructValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primitiveType}
	 * labeled alternative in {@link Protobuf2Parser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(Protobuf2Parser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code messageOrEnumType}
	 * labeled alternative in {@link Protobuf2Parser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageOrEnumType(Protobuf2Parser.MessageOrEnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#extensions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensions(Protobuf2Parser.ExtensionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#extend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtend(Protobuf2Parser.ExtendContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(Protobuf2Parser.ServiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Protobuf2Parser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(Protobuf2Parser.FunctionContext ctx);
}