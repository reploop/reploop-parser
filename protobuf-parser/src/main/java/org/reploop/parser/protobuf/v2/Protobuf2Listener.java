// Generated from org/reploop/parser/protobuf/v2/Protobuf2.g4 by ANTLR 4.9.3
package org.reploop.parser.protobuf.v2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Protobuf2Parser}.
 */
public interface Protobuf2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Protobuf2Parser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Protobuf2Parser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code namespaceDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceDefinition(Protobuf2Parser.NamespaceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code namespaceDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceDefinition(Protobuf2Parser.NamespaceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code includeDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDefinition(Protobuf2Parser.IncludeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code includeDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDefinition(Protobuf2Parser.IncludeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code syntaxDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 */
	void enterSyntaxDefinition(Protobuf2Parser.SyntaxDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code syntaxDefinition}
	 * labeled alternative in {@link Protobuf2Parser#header}.
	 * @param ctx the parse tree
	 */
	void exitSyntaxDefinition(Protobuf2Parser.SyntaxDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#syntax}.
	 * @param ctx the parse tree
	 */
	void enterSyntax(Protobuf2Parser.SyntaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#syntax}.
	 * @param ctx the parse tree
	 */
	void exitSyntax(Protobuf2Parser.SyntaxContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(Protobuf2Parser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(Protobuf2Parser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(Protobuf2Parser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(Protobuf2Parser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(Protobuf2Parser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(Protobuf2Parser.MessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(Protobuf2Parser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(Protobuf2Parser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code optionPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 */
	void enterOptionPair(Protobuf2Parser.OptionPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code optionPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 */
	void exitOptionPair(Protobuf2Parser.OptionPairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defaultPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 */
	void enterDefaultPair(Protobuf2Parser.DefaultPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defaultPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 */
	void exitDefaultPair(Protobuf2Parser.DefaultPairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commonPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 */
	void enterCommonPair(Protobuf2Parser.CommonPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commonPair}
	 * labeled alternative in {@link Protobuf2Parser#pair}.
	 * @param ctx the parse tree
	 */
	void exitCommonPair(Protobuf2Parser.CommonPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#enumeration}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration(Protobuf2Parser.EnumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#enumeration}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration(Protobuf2Parser.EnumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#nameIndex}.
	 * @param ctx the parse tree
	 */
	void enterNameIndex(Protobuf2Parser.NameIndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#nameIndex}.
	 * @param ctx the parse tree
	 */
	void exitNameIndex(Protobuf2Parser.NameIndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(Protobuf2Parser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(Protobuf2Parser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by the {@code syntaxName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterSyntaxName(Protobuf2Parser.SyntaxNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code syntaxName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitSyntaxName(Protobuf2Parser.SyntaxNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code packageName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(Protobuf2Parser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code packageName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(Protobuf2Parser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code messageName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterMessageName(Protobuf2Parser.MessageNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code messageName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitMessageName(Protobuf2Parser.MessageNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterIdName(Protobuf2Parser.IdNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idName}
	 * labeled alternative in {@link Protobuf2Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitIdName(Protobuf2Parser.IdNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#multiOptions}.
	 * @param ctx the parse tree
	 */
	void enterMultiOptions(Protobuf2Parser.MultiOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#multiOptions}.
	 * @param ctx the parse tree
	 */
	void exitMultiOptions(Protobuf2Parser.MultiOptionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(Protobuf2Parser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(Protobuf2Parser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterFloatValue(Protobuf2Parser.FloatValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitFloatValue(Protobuf2Parser.FloatValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterBoolValue(Protobuf2Parser.BoolValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitBoolValue(Protobuf2Parser.BoolValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(Protobuf2Parser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(Protobuf2Parser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterStructValue(Protobuf2Parser.StructValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structValue}
	 * labeled alternative in {@link Protobuf2Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitStructValue(Protobuf2Parser.StructValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveType}
	 * labeled alternative in {@link Protobuf2Parser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(Protobuf2Parser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveType}
	 * labeled alternative in {@link Protobuf2Parser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(Protobuf2Parser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code messageOrEnumType}
	 * labeled alternative in {@link Protobuf2Parser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterMessageOrEnumType(Protobuf2Parser.MessageOrEnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code messageOrEnumType}
	 * labeled alternative in {@link Protobuf2Parser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitMessageOrEnumType(Protobuf2Parser.MessageOrEnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#extensions}.
	 * @param ctx the parse tree
	 */
	void enterExtensions(Protobuf2Parser.ExtensionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#extensions}.
	 * @param ctx the parse tree
	 */
	void exitExtensions(Protobuf2Parser.ExtensionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#extend}.
	 * @param ctx the parse tree
	 */
	void enterExtend(Protobuf2Parser.ExtendContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#extend}.
	 * @param ctx the parse tree
	 */
	void exitExtend(Protobuf2Parser.ExtendContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#service}.
	 * @param ctx the parse tree
	 */
	void enterService(Protobuf2Parser.ServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#service}.
	 * @param ctx the parse tree
	 */
	void exitService(Protobuf2Parser.ServiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf2Parser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(Protobuf2Parser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf2Parser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(Protobuf2Parser.FunctionContext ctx);
}