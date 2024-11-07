// Generated from org/reploop/parser/json/json5/JSON5.g4 by ANTLR 4.13.2
package org.reploop.parser.json.json5;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class JSON5Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, SINGLE_LINE_COMMENT=7, 
		MULTI_LINE_COMMENT=8, LITERAL=9, STRING=10, NUMBER=11, NUMERIC_LITERAL=12, 
		SYMBOL=13, IDENTIFIER=14, WS=15;
	public static final int
		RULE_json5 = 0, RULE_obj = 1, RULE_pair = 2, RULE_key = 3, RULE_value = 4, 
		RULE_arr = 5, RULE_number = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"json5", "obj", "pair", "key", "value", "arr", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "','", "'}'", "':'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", 
			"LITERAL", "STRING", "NUMBER", "NUMERIC_LITERAL", "SYMBOL", "IDENTIFIER", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JSON5.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JSON5Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Json5Context extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(JSON5Parser.EOF, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public Json5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterJson5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitJson5(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitJson5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Json5Context json5() throws RecognitionException {
		Json5Context _localctx = new Json5Context(_ctx, getState());
		enterRule(_localctx, 0, RULE_json5);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15906L) != 0)) {
				{
				setState(14);
				value();
				}
			}

			setState(17);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjContext extends ParserRuleContext {
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_obj);
		int _la;
		try {
			int _alt;
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(19);
				match(T__0);
				setState(20);
				pair();
				setState(25);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(21);
						match(T__1);
						setState(22);
						pair();
						}
						} 
					}
					setState(27);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(28);
					match(T__1);
					}
				}

				setState(31);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				match(T__0);
				setState(34);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PairContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			key();
			setState(38);
			match(T__3);
			setState(39);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyContext extends ParserRuleContext {
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
	 
		public KeyContext() { }
		public void copyFrom(KeyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberKeyContext extends KeyContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(JSON5Parser.NUMERIC_LITERAL, 0); }
		public NumberKeyContext(KeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterNumberKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitNumberKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitNumberKey(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierKeyContext extends KeyContext {
		public TerminalNode IDENTIFIER() { return getToken(JSON5Parser.IDENTIFIER, 0); }
		public IdentifierKeyContext(KeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterIdentifierKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitIdentifierKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitIdentifierKey(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringKeyContext extends KeyContext {
		public TerminalNode STRING() { return getToken(JSON5Parser.STRING, 0); }
		public StringKeyContext(KeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterStringKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitStringKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitStringKey(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralKeyContext extends KeyContext {
		public TerminalNode LITERAL() { return getToken(JSON5Parser.LITERAL, 0); }
		public LiteralKeyContext(KeyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterLiteralKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitLiteralKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitLiteralKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_key);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringKeyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(STRING);
				}
				break;
			case IDENTIFIER:
				_localctx = new IdentifierKeyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(IDENTIFIER);
				}
				break;
			case LITERAL:
				_localctx = new LiteralKeyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(LITERAL);
				}
				break;
			case NUMERIC_LITERAL:
				_localctx = new NumberKeyContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				match(NUMERIC_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringValueContext extends ValueContext {
		public TerminalNode STRING() { return getToken(JSON5Parser.STRING, 0); }
		public StringValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjValueContext extends ValueContext {
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ObjValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterObjValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitObjValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitObjValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberValueContext extends ValueContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterNumberValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitNumberValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitNumberValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValueContext extends ValueContext {
		public ArrContext arr() {
			return getRuleContext(ArrContext.class,0);
		}
		public ArrayValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitArrayValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralValueContext extends ValueContext {
		public TerminalNode LITERAL() { return getToken(JSON5Parser.LITERAL, 0); }
		public LiteralValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(STRING);
				}
				break;
			case NUMBER:
			case NUMERIC_LITERAL:
			case SYMBOL:
				_localctx = new NumberValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				number();
				}
				break;
			case T__0:
				_localctx = new ObjValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				obj();
				}
				break;
			case T__4:
				_localctx = new ArrayValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(50);
				arr();
				}
				break;
			case LITERAL:
				_localctx = new LiteralValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				match(LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ArrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterArr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitArr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitArr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrContext arr() throws RecognitionException {
		ArrContext _localctx = new ArrContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arr);
		int _la;
		try {
			int _alt;
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(T__4);
				setState(55);
				value();
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(56);
						match(T__1);
						setState(57);
						value();
						}
						} 
					}
					setState(62);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(63);
					match(T__1);
					}
				}

				setState(66);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(T__4);
				setState(69);
				match(T__5);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(JSON5Parser.NUMERIC_LITERAL, 0); }
		public TerminalNode NUMBER() { return getToken(JSON5Parser.NUMBER, 0); }
		public TerminalNode SYMBOL() { return getToken(JSON5Parser.SYMBOL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSON5Listener ) ((JSON5Listener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSON5Visitor ) return ((JSON5Visitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYMBOL) {
				{
				setState(72);
				match(SYMBOL);
				}
			}

			setState(75);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==NUMERIC_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000fN\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0003\u0000\u0010"+
		"\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u0018\b\u0001\n\u0001\f\u0001\u001b\t\u0001\u0001\u0001"+
		"\u0003\u0001\u001e\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001$\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003.\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"5\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		";\b\u0005\n\u0005\f\u0005>\t\u0005\u0001\u0005\u0003\u0005A\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005G\b\u0005\u0001"+
		"\u0006\u0003\u0006J\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0000"+
		"\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0001\u0001\u0000\u000b"+
		"\fU\u0000\u000f\u0001\u0000\u0000\u0000\u0002#\u0001\u0000\u0000\u0000"+
		"\u0004%\u0001\u0000\u0000\u0000\u0006-\u0001\u0000\u0000\u0000\b4\u0001"+
		"\u0000\u0000\u0000\nF\u0001\u0000\u0000\u0000\fI\u0001\u0000\u0000\u0000"+
		"\u000e\u0010\u0003\b\u0004\u0000\u000f\u000e\u0001\u0000\u0000\u0000\u000f"+
		"\u0010\u0001\u0000\u0000\u0000\u0010\u0011\u0001\u0000\u0000\u0000\u0011"+
		"\u0012\u0005\u0000\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013"+
		"\u0014\u0005\u0001\u0000\u0000\u0014\u0019\u0003\u0004\u0002\u0000\u0015"+
		"\u0016\u0005\u0002\u0000\u0000\u0016\u0018\u0003\u0004\u0002\u0000\u0017"+
		"\u0015\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019"+
		"\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a"+
		"\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c"+
		"\u001e\u0005\u0002\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f"+
		" \u0005\u0003\u0000\u0000 $\u0001\u0000\u0000\u0000!\"\u0005\u0001\u0000"+
		"\u0000\"$\u0005\u0003\u0000\u0000#\u0013\u0001\u0000\u0000\u0000#!\u0001"+
		"\u0000\u0000\u0000$\u0003\u0001\u0000\u0000\u0000%&\u0003\u0006\u0003"+
		"\u0000&\'\u0005\u0004\u0000\u0000\'(\u0003\b\u0004\u0000(\u0005\u0001"+
		"\u0000\u0000\u0000).\u0005\n\u0000\u0000*.\u0005\u000e\u0000\u0000+.\u0005"+
		"\t\u0000\u0000,.\u0005\f\u0000\u0000-)\u0001\u0000\u0000\u0000-*\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000"+
		".\u0007\u0001\u0000\u0000\u0000/5\u0005\n\u0000\u000005\u0003\f\u0006"+
		"\u000015\u0003\u0002\u0001\u000025\u0003\n\u0005\u000035\u0005\t\u0000"+
		"\u00004/\u0001\u0000\u0000\u000040\u0001\u0000\u0000\u000041\u0001\u0000"+
		"\u0000\u000042\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u00005\t\u0001"+
		"\u0000\u0000\u000067\u0005\u0005\u0000\u00007<\u0003\b\u0004\u000089\u0005"+
		"\u0002\u0000\u00009;\u0003\b\u0004\u0000:8\u0001\u0000\u0000\u0000;>\u0001"+
		"\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000?A\u0005\u0002\u0000"+
		"\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000"+
		"\u0000\u0000BC\u0005\u0006\u0000\u0000CG\u0001\u0000\u0000\u0000DE\u0005"+
		"\u0005\u0000\u0000EG\u0005\u0006\u0000\u0000F6\u0001\u0000\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000G\u000b\u0001\u0000\u0000\u0000HJ\u0005\r\u0000"+
		"\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KL\u0007\u0000\u0000\u0000L\r\u0001\u0000\u0000\u0000\n\u000f"+
		"\u0019\u001d#-4<@FI";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}