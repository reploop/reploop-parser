// Generated from org/reploop/parser/protobuf/v2/Protobuf2.g4 by ANTLR 4.8
package org.reploop.parser.protobuf.v2;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Protobuf2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9,
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17,
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24,
		T__24=25, FieldModifier=26, ScalarType=27, BOOL_LITERAL=28, FLOAT=29,
		ID=30, INT=31, STRING=32, LINE_COMMENT=33, COMMENT=34, WS=35;
	public static final int
		RULE_program = 0, RULE_header = 1, RULE_syntax = 2, RULE_namespace = 3,
		RULE_include = 4, RULE_message = 5, RULE_option = 6, RULE_pair = 7, RULE_enumeration = 8,
		RULE_nameIndex = 9, RULE_field = 10, RULE_fieldName = 11, RULE_multiOptions = 12,
		RULE_value = 13, RULE_fieldType = 14, RULE_extensions = 15, RULE_extend = 16,
		RULE_service = 17, RULE_function = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "header", "syntax", "namespace", "include", "message", "option",
			"pair", "enumeration", "nameIndex", "field", "fieldName", "multiOptions",
			"value", "fieldType", "extensions", "extend", "service", "function"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'syntax'", "'='", "'\"proto2\"'", "''proto2''", "';'", "'package'",
			"'import'", "'message'", "'{'", "'}'", "'option'", "'('", "')'", "'.'",
			"'default'", "'enum'", "'['", "','", "']'", "'extensions'", "'to'", "'extend'",
			"'service'", "'rpc'", "'returns'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, "FieldModifier", "ScalarType", "BOOL_LITERAL", "FLOAT", "ID",
			"INT", "STRING", "LINE_COMMENT", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "Protobuf2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Protobuf2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<HeaderContext> header() {
			return getRuleContexts(HeaderContext.class);
		}
		public HeaderContext header(int i) {
			return getRuleContext(HeaderContext.class,i);
		}
		public List<MessageContext> message() {
			return getRuleContexts(MessageContext.class);
		}
		public MessageContext message(int i) {
			return getRuleContext(MessageContext.class,i);
		}
		public List<EnumerationContext> enumeration() {
			return getRuleContexts(EnumerationContext.class);
		}
		public EnumerationContext enumeration(int i) {
			return getRuleContext(EnumerationContext.class,i);
		}
		public List<ServiceContext> service() {
			return getRuleContexts(ServiceContext.class);
		}
		public ServiceContext service(int i) {
			return getRuleContext(ServiceContext.class,i);
		}
		public List<ExtendContext> extend() {
			return getRuleContexts(ExtendContext.class);
		}
		public ExtendContext extend(int i) {
			return getRuleContext(ExtendContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__6) | (1L << T__10))) != 0)) {
				{
				setState(40);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(38);
					option();
					}
					break;
				case T__0:
				case T__5:
				case T__6:
					{
					setState(39);
					header();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(49);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(45);
					message();
					}
					break;
				case T__15:
					{
					setState(46);
					enumeration();
					}
					break;
				case T__22:
					{
					setState(47);
					service();
					}
					break;
				case T__21:
					{
					setState(48);
					extend();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__15) | (1L << T__21) | (1L << T__22))) != 0) );
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

	public static class HeaderContext extends ParserRuleContext {
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }

		public HeaderContext() { }
		public void copyFrom(HeaderContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SyntaxDefinitionContext extends HeaderContext {
		public SyntaxContext syntax() {
			return getRuleContext(SyntaxContext.class,0);
		}
		public SyntaxDefinitionContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterSyntaxDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitSyntaxDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitSyntaxDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncludeDefinitionContext extends HeaderContext {
		public IncludeContext include() {
			return getRuleContext(IncludeContext.class,0);
		}
		public IncludeDefinitionContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterIncludeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitIncludeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitIncludeDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NamespaceDefinitionContext extends HeaderContext {
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public NamespaceDefinitionContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterNamespaceDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitNamespaceDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitNamespaceDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new NamespaceDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				namespace();
				}
				break;
			case T__6:
				_localctx = new IncludeDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				include();
				}
				break;
			case T__0:
				_localctx = new SyntaxDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				syntax();
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

	public static class SyntaxContext extends ParserRuleContext {
		public SyntaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterSyntax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitSyntax(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitSyntax(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyntaxContext syntax() throws RecognitionException {
		SyntaxContext _localctx = new SyntaxContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_syntax);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__0);
			setState(59);
			match(T__1);
			setState(60);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(61);
			match(T__4);
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

	public static class NamespaceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitNamespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitNamespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__5);
			setState(64);
			match(ID);
			setState(65);
			match(T__4);
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

	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Protobuf2Parser.STRING, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitInclude(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__6);
			setState(68);
			match(STRING);
			setState(69);
			match(T__4);
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

	public static class MessageContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<MessageContext> message() {
			return getRuleContexts(MessageContext.class);
		}
		public MessageContext message(int i) {
			return getRuleContext(MessageContext.class,i);
		}
		public List<EnumerationContext> enumeration() {
			return getRuleContexts(EnumerationContext.class);
		}
		public EnumerationContext enumeration(int i) {
			return getRuleContext(EnumerationContext.class,i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<ExtendContext> extend() {
			return getRuleContexts(ExtendContext.class);
		}
		public ExtendContext extend(int i) {
			return getRuleContext(ExtendContext.class,i);
		}
		public List<ExtensionsContext> extensions() {
			return getRuleContexts(ExtensionsContext.class);
		}
		public ExtensionsContext extensions(int i) {
			return getRuleContext(ExtensionsContext.class,i);
		}
		public MessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageContext message() throws RecognitionException {
		MessageContext _localctx = new MessageContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_message);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__7);
			setState(72);
			match(ID);
			setState(73);
			match(T__8);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__10) | (1L << T__13) | (1L << T__15) | (1L << T__19) | (1L << T__21) | (1L << FieldModifier) | (1L << ScalarType) | (1L << ID))) != 0)) {
				{
				setState(80);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(74);
					option();
					}
					break;
				case T__7:
					{
					setState(75);
					message();
					}
					break;
				case T__15:
					{
					setState(76);
					enumeration();
					}
					break;
				case T__13:
				case FieldModifier:
				case ScalarType:
				case ID:
					{
					setState(77);
					field();
					}
					break;
				case T__21:
					{
					setState(78);
					extend();
					}
					break;
				case T__19:
					{
					setState(79);
					extensions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(T__9);
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

	public static class OptionContext extends ParserRuleContext {
		public PairContext pair() {
			return getRuleContext(PairContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__10);
			setState(88);
			pair();
			setState(89);
			match(T__4);
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

	public static class PairContext extends ParserRuleContext {
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }

		public PairContext() { }
		public void copyFrom(PairContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OptionPairContext extends PairContext {
		public Token name;
		public Token attr;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(Protobuf2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(Protobuf2Parser.ID, i);
		}
		public OptionPairContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterOptionPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitOptionPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitOptionPair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefaultPairContext extends PairContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DefaultPairContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterDefaultPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitDefaultPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitDefaultPair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CommonPairContext extends PairContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public CommonPairContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterCommonPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitCommonPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitCommonPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pair);
		int _la;
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				_localctx = new OptionPairContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(T__11);
				setState(92);
				((OptionPairContext)_localctx).name = match(ID);
				setState(93);
				match(T__12);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(94);
					match(T__13);
					setState(95);
					((OptionPairContext)_localctx).attr = match(ID);
					}
				}

				setState(98);
				match(T__1);
				setState(99);
				value();
				}
				break;
			case T__14:
				_localctx = new DefaultPairContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(T__14);
				setState(101);
				match(T__1);
				setState(102);
				value();
				}
				break;
			case ID:
				_localctx = new CommonPairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				match(ID);
				setState(104);
				match(T__1);
				setState(105);
				value();
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

	public static class EnumerationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public List<NameIndexContext> nameIndex() {
			return getRuleContexts(NameIndexContext.class);
		}
		public NameIndexContext nameIndex(int i) {
			return getRuleContext(NameIndexContext.class,i);
		}
		public EnumerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterEnumeration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitEnumeration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitEnumeration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationContext enumeration() throws RecognitionException {
		EnumerationContext _localctx = new EnumerationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_enumeration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__15);
			setState(109);
			match(ID);
			setState(110);
			match(T__8);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				nameIndex();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(116);
			match(T__9);
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

	public static class NameIndexContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public TerminalNode INT() { return getToken(Protobuf2Parser.INT, 0); }
		public MultiOptionsContext multiOptions() {
			return getRuleContext(MultiOptionsContext.class,0);
		}
		public NameIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterNameIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitNameIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitNameIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameIndexContext nameIndex() throws RecognitionException {
		NameIndexContext _localctx = new NameIndexContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nameIndex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(ID);
			setState(119);
			match(T__1);
			setState(120);
			match(INT);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(121);
				multiOptions();
				}
			}

			setState(124);
			match(T__4);
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

	public static class FieldContext extends ParserRuleContext {
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(Protobuf2Parser.INT, 0); }
		public TerminalNode FieldModifier() { return getToken(Protobuf2Parser.FieldModifier, 0); }
		public MultiOptionsContext multiOptions() {
			return getRuleContext(MultiOptionsContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FieldModifier) {
				{
				setState(126);
				match(FieldModifier);
				}
			}

			setState(129);
			fieldType();
			setState(130);
			fieldName();
			setState(131);
			match(T__1);
			setState(132);
			match(INT);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(133);
				multiOptions();
				}
			}

			setState(136);
			match(T__4);
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

	public static class FieldNameContext extends ParserRuleContext {
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }

		public FieldNameContext() { }
		public void copyFrom(FieldNameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MessageNameContext extends FieldNameContext {
		public MessageNameContext(FieldNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterMessageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitMessageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitMessageName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdNameContext extends FieldNameContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public IdNameContext(FieldNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterIdName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitIdName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitIdName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PackageNameContext extends FieldNameContext {
		public PackageNameContext(FieldNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitPackageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitPackageName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SyntaxNameContext extends FieldNameContext {
		public SyntaxNameContext(FieldNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterSyntaxName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitSyntaxName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitSyntaxName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fieldName);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new SyntaxNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(T__0);
				}
				break;
			case T__5:
				_localctx = new PackageNameContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(T__5);
				}
				break;
			case T__7:
				_localctx = new MessageNameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(T__7);
				}
				break;
			case ID:
				_localctx = new IdNameContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				match(ID);
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

	public static class MultiOptionsContext extends ParserRuleContext {
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public MultiOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterMultiOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitMultiOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitMultiOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiOptionsContext multiOptions() throws RecognitionException {
		MultiOptionsContext _localctx = new MultiOptionsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_multiOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__16);
			setState(145);
			pair();
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(146);
				match(T__17);
				setState(147);
				pair();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			match(T__18);
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
	public static class StringValueContext extends ValueContext {
		public TerminalNode STRING() { return getToken(Protobuf2Parser.STRING, 0); }
		public StringValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValueContext extends ValueContext {
		public TerminalNode INT() { return getToken(Protobuf2Parser.INT, 0); }
		public IntValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterIntValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitIntValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitIntValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructValueContext extends ValueContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public StructValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterStructValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitStructValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitStructValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatValueContext extends ValueContext {
		public TerminalNode FLOAT() { return getToken(Protobuf2Parser.FLOAT, 0); }
		public FloatValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterFloatValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitFloatValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitFloatValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValueContext extends ValueContext {
		public TerminalNode BOOL_LITERAL() { return getToken(Protobuf2Parser.BOOL_LITERAL, 0); }
		public BoolValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_value);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(FLOAT);
				}
				break;
			case BOOL_LITERAL:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(BOOL_LITERAL);
				}
				break;
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				match(STRING);
				}
				break;
			case ID:
				_localctx = new StructValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				match(ID);
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

	public static class FieldTypeContext extends ParserRuleContext {
		public FieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldType; }

		public FieldTypeContext() { }
		public void copyFrom(FieldTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MessageOrEnumTypeContext extends FieldTypeContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public MessageOrEnumTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterMessageOrEnumType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitMessageOrEnumType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitMessageOrEnumType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveTypeContext extends FieldTypeContext {
		public TerminalNode ScalarType() { return getToken(Protobuf2Parser.ScalarType, 0); }
		public PrimitiveTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fieldType);
		int _la;
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ScalarType:
				_localctx = new PrimitiveTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(ScalarType);
				}
				break;
			case T__13:
			case ID:
				_localctx = new MessageOrEnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(163);
					match(T__13);
					}
				}

				setState(166);
				match(ID);
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

	public static class ExtensionsContext extends ParserRuleContext {
		public Token from;
		public Token to;
		public TerminalNode INT() { return getToken(Protobuf2Parser.INT, 0); }
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public ExtensionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extensions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterExtensions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitExtensions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitExtensions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionsContext extensions() throws RecognitionException {
		ExtensionsContext _localctx = new ExtensionsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_extensions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__19);
			setState(170);
			((ExtensionsContext)_localctx).from = match(INT);
			setState(171);
			match(T__20);
			setState(172);
			((ExtensionsContext)_localctx).to = match(ID);
			setState(173);
			match(T__4);
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

	public static class ExtendContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public ExtendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterExtend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitExtend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitExtend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendContext extend() throws RecognitionException {
		ExtendContext _localctx = new ExtendContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_extend);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__21);
			setState(176);
			match(ID);
			setState(177);
			match(T__8);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(178);
				field();
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << FieldModifier) | (1L << ScalarType) | (1L << ID))) != 0) );
			setState(183);
			match(T__9);
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

	public static class ServiceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitService(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitService(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceContext service() throws RecognitionException {
		ServiceContext _localctx = new ServiceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_service);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__22);
			setState(186);
			match(ID);
			setState(187);
			match(T__8);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(190);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__10:
					{
					setState(188);
					option();
					}
					break;
				case T__23:
					{
					setState(189);
					function();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 || _la==T__23 );
			setState(194);
			match(T__9);
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

	public static class FunctionContext extends ParserRuleContext {
		public FieldTypeContext requestType;
		public FieldTypeContext responseType;
		public TerminalNode ID() { return getToken(Protobuf2Parser.ID, 0); }
		public List<FieldTypeContext> fieldType() {
			return getRuleContexts(FieldTypeContext.class);
		}
		public FieldTypeContext fieldType(int i) {
			return getRuleContext(FieldTypeContext.class,i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf2Listener ) ((Protobuf2Listener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf2Visitor ) return ((Protobuf2Visitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__23);
			setState(197);
			match(ID);
			setState(198);
			match(T__11);
			setState(199);
			((FunctionContext)_localctx).requestType = fieldType();
			setState(200);
			match(T__12);
			setState(201);
			match(T__24);
			setState(202);
			match(T__11);
			setState(203);
			((FunctionContext)_localctx).responseType = fieldType();
			setState(204);
			match(T__12);
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(205);
				match(T__4);
				}
				break;
			case T__8:
			case T__9:
			case T__10:
			case T__23:
				{
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(206);
					match(T__8);
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__10) {
						{
						{
						setState(207);
						option();
						}
						}
						setState(212);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(213);
					match(T__9);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u00dd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\2\3\2\6"+
		"\2\64\n\2\r\2\16\2\65\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7S\n\7"+
		"\f\7\16\7V\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\tc\n\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tm\n\t\3\n\3\n\3\n\3\n\6\ns\n\n\r\n\16"+
		"\nt\3\n\3\n\3\13\3\13\3\13\3\13\5\13}\n\13\3\13\3\13\3\f\5\f\u0082\n\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u0089\n\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u0091\n"+
		"\r\3\16\3\16\3\16\3\16\7\16\u0097\n\16\f\16\16\16\u009a\13\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00a3\n\17\3\20\3\20\5\20\u00a7\n\20\3"+
		"\20\5\20\u00aa\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\6\22\u00b6\n\22\r\22\16\22\u00b7\3\22\3\22\3\23\3\23\3\23\3\23\3\23\6"+
		"\23\u00c1\n\23\r\23\16\23\u00c2\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00d3\n\24\f\24\16\24\u00d6\13\24"+
		"\3\24\5\24\u00d9\n\24\5\24\u00db\n\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&\2\3\3\2\5\6\2\u00ee\2,\3\2\2\2\4:\3\2\2\2\6<\3"+
		"\2\2\2\bA\3\2\2\2\nE\3\2\2\2\fI\3\2\2\2\16Y\3\2\2\2\20l\3\2\2\2\22n\3"+
		"\2\2\2\24x\3\2\2\2\26\u0081\3\2\2\2\30\u0090\3\2\2\2\32\u0092\3\2\2\2"+
		"\34\u00a2\3\2\2\2\36\u00a9\3\2\2\2 \u00ab\3\2\2\2\"\u00b1\3\2\2\2$\u00bb"+
		"\3\2\2\2&\u00c6\3\2\2\2(+\5\16\b\2)+\5\4\3\2*(\3\2\2\2*)\3\2\2\2+.\3\2"+
		"\2\2,*\3\2\2\2,-\3\2\2\2-\63\3\2\2\2.,\3\2\2\2/\64\5\f\7\2\60\64\5\22"+
		"\n\2\61\64\5$\23\2\62\64\5\"\22\2\63/\3\2\2\2\63\60\3\2\2\2\63\61\3\2"+
		"\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\3\3\2"+
		"\2\2\67;\5\b\5\28;\5\n\6\29;\5\6\4\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;"+
		"\5\3\2\2\2<=\7\3\2\2=>\7\4\2\2>?\t\2\2\2?@\7\7\2\2@\7\3\2\2\2AB\7\b\2"+
		"\2BC\7 \2\2CD\7\7\2\2D\t\3\2\2\2EF\7\t\2\2FG\7\"\2\2GH\7\7\2\2H\13\3\2"+
		"\2\2IJ\7\n\2\2JK\7 \2\2KT\7\13\2\2LS\5\16\b\2MS\5\f\7\2NS\5\22\n\2OS\5"+
		"\26\f\2PS\5\"\22\2QS\5 \21\2RL\3\2\2\2RM\3\2\2\2RN\3\2\2\2RO\3\2\2\2R"+
		"P\3\2\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2"+
		"WX\7\f\2\2X\r\3\2\2\2YZ\7\r\2\2Z[\5\20\t\2[\\\7\7\2\2\\\17\3\2\2\2]^\7"+
		"\16\2\2^_\7 \2\2_b\7\17\2\2`a\7\20\2\2ac\7 \2\2b`\3\2\2\2bc\3\2\2\2cd"+
		"\3\2\2\2de\7\4\2\2em\5\34\17\2fg\7\21\2\2gh\7\4\2\2hm\5\34\17\2ij\7 \2"+
		"\2jk\7\4\2\2km\5\34\17\2l]\3\2\2\2lf\3\2\2\2li\3\2\2\2m\21\3\2\2\2no\7"+
		"\22\2\2op\7 \2\2pr\7\13\2\2qs\5\24\13\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2"+
		"tu\3\2\2\2uv\3\2\2\2vw\7\f\2\2w\23\3\2\2\2xy\7 \2\2yz\7\4\2\2z|\7!\2\2"+
		"{}\5\32\16\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\7\7\2\2\177\25\3\2\2\2"+
		"\u0080\u0082\7\34\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\5\36\20\2\u0084\u0085\5\30\r\2\u0085\u0086\7\4\2"+
		"\2\u0086\u0088\7!\2\2\u0087\u0089\5\32\16\2\u0088\u0087\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\7\7\2\2\u008b\27\3\2\2"+
		"\2\u008c\u0091\7\3\2\2\u008d\u0091\7\b\2\2\u008e\u0091\7\n\2\2\u008f\u0091"+
		"\7 \2\2\u0090\u008c\3\2\2\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\31\3\2\2\2\u0092\u0093\7\23\2\2\u0093\u0098\5\20"+
		"\t\2\u0094\u0095\7\24\2\2\u0095\u0097\5\20\t\2\u0096\u0094\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\25\2\2\u009c\33\3\2\2\2\u009d\u00a3"+
		"\7!\2\2\u009e\u00a3\7\37\2\2\u009f\u00a3\7\36\2\2\u00a0\u00a3\7\"\2\2"+
		"\u00a1\u00a3\7 \2\2\u00a2\u009d\3\2\2\2\u00a2\u009e\3\2\2\2\u00a2\u009f"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\35\3\2\2\2\u00a4"+
		"\u00aa\7\35\2\2\u00a5\u00a7\7\20\2\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3"+
		"\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\7 \2\2\u00a9\u00a4\3\2\2\2\u00a9"+
		"\u00a6\3\2\2\2\u00aa\37\3\2\2\2\u00ab\u00ac\7\26\2\2\u00ac\u00ad\7!\2"+
		"\2\u00ad\u00ae\7\27\2\2\u00ae\u00af\7 \2\2\u00af\u00b0\7\7\2\2\u00b0!"+
		"\3\2\2\2\u00b1\u00b2\7\30\2\2\u00b2\u00b3\7 \2\2\u00b3\u00b5\7\13\2\2"+
		"\u00b4\u00b6\5\26\f\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5"+
		"\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7\f\2\2\u00ba"+
		"#\3\2\2\2\u00bb\u00bc\7\31\2\2\u00bc\u00bd\7 \2\2\u00bd\u00c0\7\13\2\2"+
		"\u00be\u00c1\5\16\b\2\u00bf\u00c1\5&\24\2\u00c0\u00be\3\2\2\2\u00c0\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\7\f\2\2\u00c5%\3\2\2\2\u00c6\u00c7\7\32\2\2"+
		"\u00c7\u00c8\7 \2\2\u00c8\u00c9\7\16\2\2\u00c9\u00ca\5\36\20\2\u00ca\u00cb"+
		"\7\17\2\2\u00cb\u00cc\7\33\2\2\u00cc\u00cd\7\16\2\2\u00cd\u00ce\5\36\20"+
		"\2\u00ce\u00da\7\17\2\2\u00cf\u00db\7\7\2\2\u00d0\u00d4\7\13\2\2\u00d1"+
		"\u00d3\5\16\b\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3"+
		"\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00d9\7\f\2\2\u00d8\u00d0\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2"+
		"\2\2\u00da\u00cf\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\'\3\2\2\2\32*,\63\65"+
		":RTblt|\u0081\u0088\u0090\u0098\u00a2\u00a6\u00a9\u00b7\u00c0\u00c2\u00d4"+
		"\u00d8\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}