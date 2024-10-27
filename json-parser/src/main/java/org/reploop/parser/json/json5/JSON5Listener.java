// Generated from org/reploop/parser/json/json5/JSON5.g4 by ANTLR 4.13.2
package org.reploop.parser.json.json5;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JSON5Parser}.
 */
public interface JSON5Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JSON5Parser#json5}.
	 * @param ctx the parse tree
	 */
	void enterJson5(JSON5Parser.Json5Context ctx);
	/**
	 * Exit a parse tree produced by {@link JSON5Parser#json5}.
	 * @param ctx the parse tree
	 */
	void exitJson5(JSON5Parser.Json5Context ctx);
	/**
	 * Enter a parse tree produced by {@link JSON5Parser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(JSON5Parser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSON5Parser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(JSON5Parser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSON5Parser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(JSON5Parser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSON5Parser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(JSON5Parser.PairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 */
	void enterStringKey(JSON5Parser.StringKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 */
	void exitStringKey(JSON5Parser.StringKeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierKey(JSON5Parser.IdentifierKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierKey(JSON5Parser.IdentifierKeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 */
	void enterLiteralKey(JSON5Parser.LiteralKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 */
	void exitLiteralKey(JSON5Parser.LiteralKeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 */
	void enterNumberKey(JSON5Parser.NumberKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberKey}
	 * labeled alternative in {@link JSON5Parser#key}.
	 * @param ctx the parse tree
	 */
	void exitNumberKey(JSON5Parser.NumberKeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(JSON5Parser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(JSON5Parser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumberValue(JSON5Parser.NumberValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumberValue(JSON5Parser.NumberValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterObjValue(JSON5Parser.ObjValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitObjValue(JSON5Parser.ObjValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(JSON5Parser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(JSON5Parser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void enterLiteralValue(JSON5Parser.LiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalValue}
	 * labeled alternative in {@link JSON5Parser#value}.
	 * @param ctx the parse tree
	 */
	void exitLiteralValue(JSON5Parser.LiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSON5Parser#arr}.
	 * @param ctx the parse tree
	 */
	void enterArr(JSON5Parser.ArrContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSON5Parser#arr}.
	 * @param ctx the parse tree
	 */
	void exitArr(JSON5Parser.ArrContext ctx);
	/**
	 * Enter a parse tree produced by {@link JSON5Parser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(JSON5Parser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link JSON5Parser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(JSON5Parser.NumberContext ctx);
}