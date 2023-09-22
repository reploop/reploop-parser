// Generated from java-escape by ANTLR 4.11.1
package org.reploop.parser.thrift.base;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ThriftBaseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ThriftBaseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ThriftBaseParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code includeDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDefinition(ThriftBaseParser.IncludeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cppIncludeDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCppIncludeDefinition(ThriftBaseParser.CppIncludeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namespaceDefinition}
	 * labeled alternative in {@link ThriftBaseParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceDefinition(ThriftBaseParser.NamespaceDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(ThriftBaseParser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#cppInclude}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCppInclude(ThriftBaseParser.CppIncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#namespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespace(ThriftBaseParser.NamespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#namespaceScope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceScope(ThriftBaseParser.NamespaceScopeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinition(ThriftBaseParser.ConstantDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDefinitionDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinitionDefinition(ThriftBaseParser.TypeDefinitionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code serviceDefinition}
	 * labeled alternative in {@link ThriftBaseParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceDefinition(ThriftBaseParser.ServiceDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typedefDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedefDefinition(ThriftBaseParser.TypedefDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code enumerationDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerationDefinition(ThriftBaseParser.EnumerationDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code senumDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenumDefinition(ThriftBaseParser.SenumDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDefinition(ThriftBaseParser.StructDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exceptionDefinition}
	 * labeled alternative in {@link ThriftBaseParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionDefinition(ThriftBaseParser.ExceptionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#typedef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedef(ThriftBaseParser.TypedefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#enumeration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeration(ThriftBaseParser.EnumerationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#enumDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDef(ThriftBaseParser.EnumDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#senum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenum(ThriftBaseParser.SenumContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#senumDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSenumDef(ThriftBaseParser.SenumDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(ThriftBaseParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#constValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstValue(ThriftBaseParser.ConstValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#structHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructHead(ThriftBaseParser.StructHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct(ThriftBaseParser.StructContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#xsdAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXsdAttributes(ThriftBaseParser.XsdAttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#xception}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXception(ThriftBaseParser.XceptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#service}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitService(ThriftBaseParser.ServiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(ThriftBaseParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#raise}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaise(ThriftBaseParser.RaiseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(ThriftBaseParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#fieldID}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldID(ThriftBaseParser.FieldIDContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#fieldValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldValue(ThriftBaseParser.FieldValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnType}
	 * labeled alternative in {@link ThriftBaseParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(ThriftBaseParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link ThriftBaseParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(ThriftBaseParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#primitives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitives(ThriftBaseParser.PrimitivesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mapType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapType(ThriftBaseParser.MapTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code setType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(ThriftBaseParser.SetTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(ThriftBaseParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primitiveType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(ThriftBaseParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structType}
	 * labeled alternative in {@link ThriftBaseParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(ThriftBaseParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#commaOrSemicolon}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaOrSemicolon(ThriftBaseParser.CommaOrSemicolonContext ctx);
	/**
	 * Visit a parse tree produced by {@link ThriftBaseParser#cppType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCppType(ThriftBaseParser.CppTypeContext ctx);
}