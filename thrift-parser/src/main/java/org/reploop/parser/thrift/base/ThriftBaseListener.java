// Generated from org/reploop/parser/thrift/base/ThriftBase.g4 by ANTLR 4.13.1
package org.reploop.parser.thrift.base;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ThriftBaseParser}.
 */
public interface ThriftBaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ThriftBaseParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ThriftBaseParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code includeDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDefinition(ThriftBaseParser.IncludeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code includeDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDefinition(ThriftBaseParser.IncludeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cppIncludeDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void enterCppIncludeDefinition(ThriftBaseParser.CppIncludeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cppIncludeDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void exitCppIncludeDefinition(ThriftBaseParser.CppIncludeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code namespaceDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceDefinition(ThriftBaseParser.NamespaceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code namespaceDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceDefinition(ThriftBaseParser.NamespaceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(ThriftBaseParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(ThriftBaseParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#cppInclude}.
	 * @param ctx the parse tree
	 */
	void enterCppInclude(ThriftBaseParser.CppIncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#cppInclude}.
	 * @param ctx the parse tree
	 */
	void exitCppInclude(ThriftBaseParser.CppIncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(ThriftBaseParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(ThriftBaseParser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#namespaceScope}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceScope(ThriftBaseParser.NamespaceScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#namespaceScope}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceScope(ThriftBaseParser.NamespaceScopeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinition(ThriftBaseParser.ConstantDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinition(ThriftBaseParser.ConstantDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeDefinitionDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinitionDefinition(ThriftBaseParser.TypeDefinitionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeDefinitionDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinitionDefinition(ThriftBaseParser.TypeDefinitionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code serviceDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterServiceDefinition(ThriftBaseParser.ServiceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code serviceDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitServiceDefinition(ThriftBaseParser.ServiceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typedefDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypedefDefinition(ThriftBaseParser.TypedefDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typedefDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypedefDefinition(ThriftBaseParser.TypedefDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enumerationDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEnumerationDefinition(ThriftBaseParser.EnumerationDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enumerationDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEnumerationDefinition(ThriftBaseParser.EnumerationDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code senumDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterSenumDefinition(ThriftBaseParser.SenumDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code senumDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitSenumDefinition(ThriftBaseParser.SenumDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterStructDefinition(ThriftBaseParser.StructDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitStructDefinition(ThriftBaseParser.StructDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exceptionDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterExceptionDefinition(ThriftBaseParser.ExceptionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exceptionDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitExceptionDefinition(ThriftBaseParser.ExceptionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#typedef}.
	 * @param ctx the parse tree
	 */
	void enterTypedef(ThriftBaseParser.TypedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#typedef}.
	 * @param ctx the parse tree
	 */
	void exitTypedef(ThriftBaseParser.TypedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration(ThriftBaseParser.EnumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration(ThriftBaseParser.EnumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#enumDef}.
	 * @param ctx the parse tree
	 */
	void enterEnumDef(ThriftBaseParser.EnumDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#enumDef}.
	 * @param ctx the parse tree
	 */
	void exitEnumDef(ThriftBaseParser.EnumDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#senum}.
	 * @param ctx the parse tree
	 */
	void enterSenum(ThriftBaseParser.SenumContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#senum}.
	 * @param ctx the parse tree
	 */
	void exitSenum(ThriftBaseParser.SenumContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#senumDef}.
	 * @param ctx the parse tree
	 */
	void enterSenumDef(ThriftBaseParser.SenumDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#senumDef}.
	 * @param ctx the parse tree
	 */
	void exitSenumDef(ThriftBaseParser.SenumDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(ThriftBaseParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(ThriftBaseParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#constValue}.
	 * @param ctx the parse tree
	 */
	void enterConstValue(ThriftBaseParser.ConstValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#constValue}.
	 * @param ctx the parse tree
	 */
	void exitConstValue(ThriftBaseParser.ConstValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#structHead}.
	 * @param ctx the parse tree
	 */
	void enterStructHead(ThriftBaseParser.StructHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#structHead}.
	 * @param ctx the parse tree
	 */
	void exitStructHead(ThriftBaseParser.StructHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#struct}.
	 * @param ctx the parse tree
	 */
	void enterStruct(ThriftBaseParser.StructContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#struct}.
	 * @param ctx the parse tree
	 */
	void exitStruct(ThriftBaseParser.StructContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#xsdAttributes}.
	 * @param ctx the parse tree
	 */
	void enterXsdAttributes(ThriftBaseParser.XsdAttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#xsdAttributes}.
	 * @param ctx the parse tree
	 */
	void exitXsdAttributes(ThriftBaseParser.XsdAttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#xception}.
	 * @param ctx the parse tree
	 */
	void enterXception(ThriftBaseParser.XceptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#xception}.
	 * @param ctx the parse tree
	 */
	void exitXception(ThriftBaseParser.XceptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#service}.
	 * @param ctx the parse tree
	 */
	void enterService(ThriftBaseParser.ServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#service}.
	 * @param ctx the parse tree
	 */
	void exitService(ThriftBaseParser.ServiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(ThriftBaseParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(ThriftBaseParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#raise}.
	 * @param ctx the parse tree
	 */
	void enterRaise(ThriftBaseParser.RaiseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#raise}.
	 * @param ctx the parse tree
	 */
	void exitRaise(ThriftBaseParser.RaiseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(ThriftBaseParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(ThriftBaseParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#fieldID}.
	 * @param ctx the parse tree
	 */
	void enterFieldID(ThriftBaseParser.FieldIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#fieldID}.
	 * @param ctx the parse tree
	 */
	void exitFieldID(ThriftBaseParser.FieldIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void enterFieldValue(ThriftBaseParser.FieldValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#fieldValue}.
	 * @param ctx the parse tree
	 */
	void exitFieldValue(ThriftBaseParser.FieldValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnType}
	 * labeled alternative in {@link ThriftBaseParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(ThriftBaseParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnType}
	 * labeled alternative in {@link ThriftBaseParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(ThriftBaseParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link ThriftBaseParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(ThriftBaseParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link ThriftBaseParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(ThriftBaseParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#primitives}.
	 * @param ctx the parse tree
	 */
	void enterPrimitives(ThriftBaseParser.PrimitivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#primitives}.
	 * @param ctx the parse tree
	 */
	void exitPrimitives(ThriftBaseParser.PrimitivesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mapType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterMapType(ThriftBaseParser.MapTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mapType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitMapType(ThriftBaseParser.MapTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterSetType(ThriftBaseParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitSetType(ThriftBaseParser.SetTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterListType(ThriftBaseParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitListType(ThriftBaseParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(ThriftBaseParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(ThriftBaseParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterStructType(ThriftBaseParser.StructTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitStructType(ThriftBaseParser.StructTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#commaOrSemicolon}.
	 * @param ctx the parse tree
	 */
	void enterCommaOrSemicolon(ThriftBaseParser.CommaOrSemicolonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#commaOrSemicolon}.
	 * @param ctx the parse tree
	 */
	void exitCommaOrSemicolon(ThriftBaseParser.CommaOrSemicolonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ThriftBaseParser#cppType}.
	 * @param ctx the parse tree
	 */
	void enterCppType(ThriftBaseParser.CppTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ThriftBaseParser#cppType}.
	 * @param ctx the parse tree
	 */
	void exitCppType(ThriftBaseParser.CppTypeContext ctx);
}