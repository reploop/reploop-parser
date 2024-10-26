// Generated from org/reploop/parser/json/base/JsonBase.g4 by ANTLR 4.13.1
package org.reploop.parser.json.base;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JsonBaseParser}.
 */
public interface JsonBaseListener extends ParseTreeListener {

	/**
	 * Enter a parse tree produced by {@link JsonBaseParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(JsonBaseParser.JsonContext ctx);

	/**
	 * Exit a parse tree produced by {@link JsonBaseParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(JsonBaseParser.JsonContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsonBaseParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(JsonBaseParser.ObjContext ctx);

	/**
	 * Exit a parse tree produced by {@link JsonBaseParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(JsonBaseParser.ObjContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsonBaseParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(JsonBaseParser.PairContext ctx);

	/**
	 * Exit a parse tree produced by {@link JsonBaseParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(JsonBaseParser.PairContext ctx);

	/**
	 * Enter a parse tree produced by {@link JsonBaseParser#arr}.
	 * @param ctx the parse tree
	 */
	void enterArr(JsonBaseParser.ArrContext ctx);

	/**
	 * Exit a parse tree produced by {@link JsonBaseParser#arr}.
	 * @param ctx the parse tree
	 */
	void exitArr(JsonBaseParser.ArrContext ctx);

	/**
	 * Enter a parse tree produced by the {@code stringValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(JsonBaseParser.StringValueContext ctx);

	/**
	 * Exit a parse tree produced by the {@code stringValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(JsonBaseParser.StringValueContext ctx);

	/**
	 * Enter a parse tree produced by the {@code numberValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumberValue(JsonBaseParser.NumberValueContext ctx);

	/**
	 * Exit a parse tree produced by the {@code numberValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumberValue(JsonBaseParser.NumberValueContext ctx);

	/**
	 * Enter a parse tree produced by the {@code objValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterObjValue(JsonBaseParser.ObjValueContext ctx);

	/**
	 * Exit a parse tree produced by the {@code objValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitObjValue(JsonBaseParser.ObjValueContext ctx);

	/**
	 * Enter a parse tree produced by the {@code arrValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterArrValue(JsonBaseParser.ArrValueContext ctx);

	/**
	 * Exit a parse tree produced by the {@code arrValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitArrValue(JsonBaseParser.ArrValueContext ctx);

	/**
	 * Enter a parse tree produced by the {@code trueValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterTrueValue(JsonBaseParser.TrueValueContext ctx);

	/**
	 * Exit a parse tree produced by the {@code trueValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitTrueValue(JsonBaseParser.TrueValueContext ctx);

	/**
	 * Enter a parse tree produced by the {@code falseValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFalseValue(JsonBaseParser.FalseValueContext ctx);

	/**
	 * Exit a parse tree produced by the {@code falseValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFalseValue(JsonBaseParser.FalseValueContext ctx);

	/**
	 * Enter a parse tree produced by the {@code nullValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNullValue(JsonBaseParser.NullValueContext ctx);

	/**
	 * Exit a parse tree produced by the {@code nullValue} labeled alternative in
	 * {@link JsonBaseParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNullValue(JsonBaseParser.NullValueContext ctx);

}