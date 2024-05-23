// Generated from org/reploop/parser/json/base/JsonBase.g4 by ANTLR 4.13.1
package org.reploop.parser.json.base;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JsonBaseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JsonBaseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JsonBaseParser#json}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJson(JsonBaseParser.JsonContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonBaseParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(JsonBaseParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonBaseParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPair(JsonBaseParser.PairContext ctx);
	/**
	 * Visit a parse tree produced by {@link JsonBaseParser#arr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr(JsonBaseParser.ArrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(JsonBaseParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberValue(JsonBaseParser.NumberValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjValue(JsonBaseParser.ObjValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrValue}
	 * labeled alternative in {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrValue(JsonBaseParser.ArrValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueValue}
	 * labeled alternative in {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueValue(JsonBaseParser.TrueValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseValue}
	 * labeled alternative in {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseValue(JsonBaseParser.FalseValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullValue}
	 * labeled alternative in {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullValue(JsonBaseParser.NullValueContext ctx);
}