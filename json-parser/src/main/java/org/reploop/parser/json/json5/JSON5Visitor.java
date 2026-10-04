// Generated from org/reploop/parser/json/json5/JSON5.g4 by ANTLR 4.13.2
package org.reploop.parser.json.json5;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JSON5Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JSON5Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JSON5Parser#json5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson5(JSON5Parser.Json5Context ctx);
	/**
	 * Visit a parse tree produced by {@link JSON5Parser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(JSON5Parser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSON5Parser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(JSON5Parser.PairContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringKey(JSON5Parser.StringKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierKey(JSON5Parser.IdentifierKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralKey(JSON5Parser.LiteralKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberKey(JSON5Parser.NumberKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(JSON5Parser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberValue(JSON5Parser.NumberValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjValue(JSON5Parser.ObjValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(JSON5Parser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralValue(JSON5Parser.LiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSON5Parser#arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr(JSON5Parser.ArrContext ctx);
	/**
	 * Visit a parse tree produced by {@link JSON5Parser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(JSON5Parser.NumberContext ctx);
}