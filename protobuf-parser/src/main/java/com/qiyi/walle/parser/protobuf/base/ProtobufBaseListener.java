// Generated from com/qiyi/walle/parser/protobuf/base/ProtobufBase.g4 by ANTLR 4.8
package com.qiyi.walle.parser.protobuf.base;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProtobufBaseParser}.
 */
public interface ProtobufBaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ProtobufBaseParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ProtobufBaseParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code namespaceDefinition}
	 * labeled alternative in {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceDefinition(ProtobufBaseParser.NamespaceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code namespaceDefinition}
	 * labeled alternative in {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceDefinition(ProtobufBaseParser.NamespaceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code includeDefinition}
	 * labeled alternative in {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDefinition(ProtobufBaseParser.IncludeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code includeDefinition}
	 * labeled alternative in {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDefinition(ProtobufBaseParser.IncludeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code syntaxDefinition}
	 * labeled alternative in {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void enterSyntaxDefinition(ProtobufBaseParser.SyntaxDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code syntaxDefinition}
	 * labeled alternative in {@link ProtobufBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void exitSyntaxDefinition(ProtobufBaseParser.SyntaxDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#syntax}.
	 * @param ctx the parse tree
	 */
	void enterSyntax(ProtobufBaseParser.SyntaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#syntax}.
	 * @param ctx the parse tree
	 */
	void exitSyntax(ProtobufBaseParser.SyntaxContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(ProtobufBaseParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(ProtobufBaseParser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(ProtobufBaseParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(ProtobufBaseParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(ProtobufBaseParser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(ProtobufBaseParser.MessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(ProtobufBaseParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(ProtobufBaseParser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code optionPair}
	 * labeled alternative in {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterOptionPair(ProtobufBaseParser.OptionPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code optionPair}
	 * labeled alternative in {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitOptionPair(ProtobufBaseParser.OptionPairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defaultPair}
	 * labeled alternative in {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterDefaultPair(ProtobufBaseParser.DefaultPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defaultPair}
	 * labeled alternative in {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitDefaultPair(ProtobufBaseParser.DefaultPairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commonPair}
	 * labeled alternative in {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterCommonPair(ProtobufBaseParser.CommonPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commonPair}
	 * labeled alternative in {@link ProtobufBaseParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitCommonPair(ProtobufBaseParser.CommonPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration(ProtobufBaseParser.EnumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration(ProtobufBaseParser.EnumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#nameIndex}.
	 * @param ctx the parse tree
	 */
	void enterNameIndex(ProtobufBaseParser.NameIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#nameIndex}.
	 * @param ctx the parse tree
	 */
	void exitNameIndex(ProtobufBaseParser.NameIndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(ProtobufBaseParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(ProtobufBaseParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code syntaxName}
	 * labeled alternative in {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterSyntaxName(ProtobufBaseParser.SyntaxNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code syntaxName}
	 * labeled alternative in {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitSyntaxName(ProtobufBaseParser.SyntaxNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code packageName}
	 * labeled alternative in {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(ProtobufBaseParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code packageName}
	 * labeled alternative in {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(ProtobufBaseParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code messageName}
	 * labeled alternative in {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterMessageName(ProtobufBaseParser.MessageNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code messageName}
	 * labeled alternative in {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitMessageName(ProtobufBaseParser.MessageNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idName}
	 * labeled alternative in {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterIdName(ProtobufBaseParser.IdNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idName}
	 * labeled alternative in {@link ProtobufBaseParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitIdName(ProtobufBaseParser.IdNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#multiOptions}.
	 * @param ctx the parse tree
	 */
	void enterMultiOptions(ProtobufBaseParser.MultiOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#multiOptions}.
	 * @param ctx the parse tree
	 */
	void exitMultiOptions(ProtobufBaseParser.MultiOptionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(ProtobufBaseParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(ProtobufBaseParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatVal}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFloatVal(ProtobufBaseParser.FloatValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatVal}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFloatVal(ProtobufBaseParser.FloatValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolValue}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(ProtobufBaseParser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolValue}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(ProtobufBaseParser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(ProtobufBaseParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(ProtobufBaseParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structValue}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStructValue(ProtobufBaseParser.StructValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structValue}
	 * labeled alternative in {@link ProtobufBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStructValue(ProtobufBaseParser.StructValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveType}
	 * labeled alternative in {@link ProtobufBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(ProtobufBaseParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveType}
	 * labeled alternative in {@link ProtobufBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(ProtobufBaseParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code messageOrEnumType}
	 * labeled alternative in {@link ProtobufBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterMessageOrEnumType(ProtobufBaseParser.MessageOrEnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code messageOrEnumType}
	 * labeled alternative in {@link ProtobufBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitMessageOrEnumType(ProtobufBaseParser.MessageOrEnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#extensions}.
	 * @param ctx the parse tree
	 */
	void enterExtensions(ProtobufBaseParser.ExtensionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#extensions}.
	 * @param ctx the parse tree
	 */
	void exitExtensions(ProtobufBaseParser.ExtensionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#extend}.
	 * @param ctx the parse tree
	 */
	void enterExtend(ProtobufBaseParser.ExtendContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#extend}.
	 * @param ctx the parse tree
	 */
	void exitExtend(ProtobufBaseParser.ExtendContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#service}.
	 * @param ctx the parse tree
	 */
	void enterService(ProtobufBaseParser.ServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#service}.
	 * @param ctx the parse tree
	 */
	void exitService(ProtobufBaseParser.ServiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProtobufBaseParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ProtobufBaseParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProtobufBaseParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ProtobufBaseParser.FunctionContext ctx);
}