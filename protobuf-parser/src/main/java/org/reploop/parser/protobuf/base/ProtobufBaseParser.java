// Generated from com/reploop/walle/parser/protobuf/base/ProtobufBase.g4 by ANTLR 4.8
package org.reploop.parser.protobuf.base;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProtobufBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9,
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17,
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, FieldModifier=24,
		ScalarType=25, BOOL_LITERAL=26, FLOAT=27, ID=28, INT=29, STRING=30, LINE_COMMENT=31,
		COMMENT=32, WS=33;
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
			null, "';'", "'package'", "'import'", "'message'", "'{'", "'}'", "'option'",
			"'('", "')'", "'.'", "'='", "'default'", "'enum'", "'syntax'", "'['",
			"','", "']'", "'extensions'", "'to'", "'extend'", "'service'", "'rpc'",
			"'returns'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			"FieldModifier", "ScalarType", "BOOL_LITERAL", "FLOAT", "ID", "INT",
			"STRING", "LINE_COMMENT", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "ProtobufBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProtobufBaseParser(TokenStream input) {
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitProgram(this);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__6) | (1L << STRING))) != 0)) {
				{
				setState(40);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(38);
					option();
					}
					break;
				case T__1:
				case T__2:
				case STRING:
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
				case T__3:
					{
					setState(45);
					message();
					}
					break;
				case T__12:
					{
					setState(46);
					enumeration();
					}
					break;
				case T__20:
					{
					setState(47);
					service();
					}
					break;
				case T__19:
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__12) | (1L << T__19) | (1L << T__20))) != 0) );
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterSyntaxDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitSyntaxDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitSyntaxDefinition(this);
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterIncludeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitIncludeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitIncludeDefinition(this);
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterNamespaceDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitNamespaceDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitNamespaceDefinition(this);
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
			case T__1:
				_localctx = new NamespaceDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				namespace();
				}
				break;
			case T__2:
				_localctx = new IncludeDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				include();
				}
				break;
			case STRING:
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
		public TerminalNode STRING() { return getToken(ProtobufBaseParser.STRING, 0); }
		public SyntaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterSyntax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitSyntax(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitSyntax(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyntaxContext syntax() throws RecognitionException {
		SyntaxContext _localctx = new SyntaxContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_syntax);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(STRING);
			setState(59);
			match(T__0);
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
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitNamespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitNamespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__1);
			setState(62);
			match(ID);
			setState(63);
			match(T__0);
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
		public TerminalNode STRING() { return getToken(ProtobufBaseParser.STRING, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitInclude(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__2);
			setState(66);
			match(STRING);
			setState(67);
			match(T__0);
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
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitMessage(this);
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
			setState(69);
			match(T__3);
			setState(70);
			match(ID);
			setState(71);
			match(T__4);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(78);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(72);
					option();
					}
					break;
				case T__3:
					{
					setState(73);
					message();
					}
					break;
				case T__12:
					{
					setState(74);
					enumeration();
					}
					break;
				case T__9:
				case FieldModifier:
				case ScalarType:
				case ID:
					{
					setState(75);
					field();
					}
					break;
				case T__19:
					{
					setState(76);
					extend();
					}
					break;
				case T__17:
					{
					setState(77);
					extensions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__17) | (1L << T__19) | (1L << FieldModifier) | (1L << ScalarType) | (1L << ID))) != 0) );
			setState(82);
			match(T__5);
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__6);
			setState(85);
			pair();
			setState(86);
			match(T__0);
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
		public List<TerminalNode> ID() { return getTokens(ProtobufBaseParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProtobufBaseParser.ID, i);
		}
		public OptionPairContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterOptionPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitOptionPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitOptionPair(this);
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterDefaultPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitDefaultPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitDefaultPair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CommonPairContext extends PairContext {
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public CommonPairContext(PairContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterCommonPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitCommonPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitCommonPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pair);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				_localctx = new OptionPairContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(T__7);
				setState(89);
				((OptionPairContext)_localctx).name = match(ID);
				setState(90);
				match(T__8);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(91);
					match(T__9);
					setState(92);
					((OptionPairContext)_localctx).attr = match(ID);
					}
				}

				setState(95);
				match(T__10);
				setState(96);
				value();
				}
				break;
			case T__11:
				_localctx = new DefaultPairContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(T__11);
				setState(98);
				match(T__10);
				setState(99);
				value();
				}
				break;
			case ID:
				_localctx = new CommonPairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				match(ID);
				setState(101);
				match(T__10);
				setState(102);
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
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterEnumeration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitEnumeration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitEnumeration(this);
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
			setState(105);
			match(T__12);
			setState(106);
			match(ID);
			setState(107);
			match(T__4);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				nameIndex();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(113);
			match(T__5);
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
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
		public TerminalNode INT() { return getToken(ProtobufBaseParser.INT, 0); }
		public MultiOptionsContext multiOptions() {
			return getRuleContext(MultiOptionsContext.class,0);
		}
		public NameIndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameIndex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterNameIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitNameIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitNameIndex(this);
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
			setState(115);
			match(ID);
			setState(116);
			match(T__10);
			setState(117);
			match(INT);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(118);
				multiOptions();
				}
			}

			setState(121);
			match(T__0);
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
		public TerminalNode INT() { return getToken(ProtobufBaseParser.INT, 0); }
		public TerminalNode FieldModifier() { return getToken(ProtobufBaseParser.FieldModifier, 0); }
		public MultiOptionsContext multiOptions() {
			return getRuleContext(MultiOptionsContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitField(this);
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
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FieldModifier) {
				{
				setState(123);
				match(FieldModifier);
				}
			}

			setState(126);
			fieldType();
			setState(127);
			fieldName();
			setState(128);
			match(T__10);
			setState(129);
			match(INT);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(130);
				multiOptions();
				}
			}

			setState(133);
			match(T__0);
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterMessageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitMessageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitMessageName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdNameContext extends FieldNameContext {
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
		public IdNameContext(FieldNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterIdName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitIdName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitIdName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PackageNameContext extends FieldNameContext {
		public PackageNameContext(FieldNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitPackageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitPackageName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SyntaxNameContext extends FieldNameContext {
		public SyntaxNameContext(FieldNameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterSyntaxName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitSyntaxName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitSyntaxName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fieldName);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				_localctx = new SyntaxNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(T__13);
				}
				break;
			case T__1:
				_localctx = new PackageNameContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(T__1);
				}
				break;
			case T__3:
				_localctx = new MessageNameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(T__3);
				}
				break;
			case ID:
				_localctx = new IdNameContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterMultiOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitMultiOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitMultiOptions(this);
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
			setState(141);
			match(T__14);
			setState(142);
			pair();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(143);
				match(T__15);
				setState(144);
				pair();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			match(T__16);
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
		public TerminalNode STRING() { return getToken(ProtobufBaseParser.STRING, 0); }
		public StringValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntValueContext extends ValueContext {
		public TerminalNode INT() { return getToken(ProtobufBaseParser.INT, 0); }
		public IntValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterIntValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitIntValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitIntValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructValueContext extends ValueContext {
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
		public StructValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterStructValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitStructValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitStructValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatValueContext extends ValueContext {
		public TerminalNode FLOAT() { return getToken(ProtobufBaseParser.FLOAT, 0); }
		public FloatValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterFloatValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitFloatValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitFloatValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolValueContext extends ValueContext {
		public TerminalNode BOOL_LITERAL() { return getToken(ProtobufBaseParser.BOOL_LITERAL, 0); }
		public BoolValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterBoolValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitBoolValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitBoolValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_value);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				match(FLOAT);
				}
				break;
			case BOOL_LITERAL:
				_localctx = new BoolValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(BOOL_LITERAL);
				}
				break;
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				match(STRING);
				}
				break;
			case ID:
				_localctx = new StructValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
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
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
		public MessageOrEnumTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterMessageOrEnumType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitMessageOrEnumType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitMessageOrEnumType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveTypeContext extends FieldTypeContext {
		public TerminalNode ScalarType() { return getToken(ProtobufBaseParser.ScalarType, 0); }
		public PrimitiveTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fieldType);
		int _la;
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ScalarType:
				_localctx = new PrimitiveTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(ScalarType);
				}
				break;
			case T__9:
			case ID:
				_localctx = new MessageOrEnumTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(160);
					match(T__9);
					}
				}

				setState(163);
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
		public TerminalNode INT() { return getToken(ProtobufBaseParser.INT, 0); }
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
		public ExtensionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extensions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterExtensions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitExtensions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitExtensions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtensionsContext extensions() throws RecognitionException {
		ExtensionsContext _localctx = new ExtensionsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_extensions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__17);
			setState(167);
			((ExtensionsContext)_localctx).from = match(INT);
			setState(168);
			match(T__18);
			setState(169);
			((ExtensionsContext)_localctx).to = match(ID);
			setState(170);
			match(T__0);
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
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterExtend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitExtend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitExtend(this);
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
			setState(172);
			match(T__19);
			setState(173);
			match(ID);
			setState(174);
			match(T__4);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175);
				field();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << FieldModifier) | (1L << ScalarType) | (1L << ID))) != 0) );
			setState(180);
			match(T__5);
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
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitService(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitService(this);
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
			setState(182);
			match(T__20);
			setState(183);
			match(ID);
			setState(184);
			match(T__4);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
					{
					setState(185);
					option();
					}
					break;
				case T__21:
					{
					setState(186);
					function();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 || _la==T__21 );
			setState(191);
			match(T__5);
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
		public TerminalNode ID() { return getToken(ProtobufBaseParser.ID, 0); }
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
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProtobufBaseListener ) ((ProtobufBaseListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProtobufBaseVisitor ) return ((ProtobufBaseVisitor<? extends T>)visitor).visitFunction(this);
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
			setState(193);
			match(T__21);
			setState(194);
			match(ID);
			setState(195);
			match(T__7);
			setState(196);
			((FunctionContext)_localctx).requestType = fieldType();
			setState(197);
			match(T__8);
			setState(198);
			match(T__22);
			setState(199);
			match(T__7);
			setState(200);
			((FunctionContext)_localctx).responseType = fieldType();
			setState(201);
			match(T__8);
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(202);
				match(T__0);
				}
				break;
			case T__4:
			case T__5:
			case T__6:
			case T__21:
				{
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(203);
					match(T__4);
					setState(207);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(204);
						option();
						}
						}
						setState(209);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(210);
					match(T__5);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00da\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\2\3\2\6"+
		"\2\64\n\2\r\2\16\2\65\3\3\3\3\3\3\5\3;\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7Q\n\7\r\7\16\7"+
		"R\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t`\n\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\tj\n\t\3\n\3\n\3\n\3\n\6\np\n\n\r\n\16\nq\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\5\13z\n\13\3\13\3\13\3\f\5\f\177\n\f\3\f\3\f\3\f\3"+
		"\f\3\f\5\f\u0086\n\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u008e\n\r\3\16\3\16\3"+
		"\16\3\16\7\16\u0094\n\16\f\16\16\16\u0097\13\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u00a0\n\17\3\20\3\20\5\20\u00a4\n\20\3\20\5\20\u00a7"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\6\22\u00b3\n\22"+
		"\r\22\16\22\u00b4\3\22\3\22\3\23\3\23\3\23\3\23\3\23\6\23\u00be\n\23\r"+
		"\23\16\23\u00bf\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u00d0\n\24\f\24\16\24\u00d3\13\24\3\24\5\24\u00d6"+
		"\n\24\5\24\u00d8\n\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&\2\2\2\u00eb\2,\3\2\2\2\4:\3\2\2\2\6<\3\2\2\2\b?\3\2\2\2\nC\3"+
		"\2\2\2\fG\3\2\2\2\16V\3\2\2\2\20i\3\2\2\2\22k\3\2\2\2\24u\3\2\2\2\26~"+
		"\3\2\2\2\30\u008d\3\2\2\2\32\u008f\3\2\2\2\34\u009f\3\2\2\2\36\u00a6\3"+
		"\2\2\2 \u00a8\3\2\2\2\"\u00ae\3\2\2\2$\u00b8\3\2\2\2&\u00c3\3\2\2\2(+"+
		"\5\16\b\2)+\5\4\3\2*(\3\2\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2"+
		"-\63\3\2\2\2.,\3\2\2\2/\64\5\f\7\2\60\64\5\22\n\2\61\64\5$\23\2\62\64"+
		"\5\"\22\2\63/\3\2\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\65"+
		"\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\3\3\2\2\2\67;\5\b\5\28;\5\n\6"+
		"\29;\5\6\4\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;\5\3\2\2\2<=\7 \2\2=>\7\3"+
		"\2\2>\7\3\2\2\2?@\7\4\2\2@A\7\36\2\2AB\7\3\2\2B\t\3\2\2\2CD\7\5\2\2DE"+
		"\7 \2\2EF\7\3\2\2F\13\3\2\2\2GH\7\6\2\2HI\7\36\2\2IP\7\7\2\2JQ\5\16\b"+
		"\2KQ\5\f\7\2LQ\5\22\n\2MQ\5\26\f\2NQ\5\"\22\2OQ\5 \21\2PJ\3\2\2\2PK\3"+
		"\2\2\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3"+
		"\2\2\2ST\3\2\2\2TU\7\b\2\2U\r\3\2\2\2VW\7\t\2\2WX\5\20\t\2XY\7\3\2\2Y"+
		"\17\3\2\2\2Z[\7\n\2\2[\\\7\36\2\2\\_\7\13\2\2]^\7\f\2\2^`\7\36\2\2_]\3"+
		"\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\r\2\2bj\5\34\17\2cd\7\16\2\2de\7\r\2\2"+
		"ej\5\34\17\2fg\7\36\2\2gh\7\r\2\2hj\5\34\17\2iZ\3\2\2\2ic\3\2\2\2if\3"+
		"\2\2\2j\21\3\2\2\2kl\7\17\2\2lm\7\36\2\2mo\7\7\2\2np\5\24\13\2on\3\2\2"+
		"\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\b\2\2t\23\3\2\2\2uv\7\36"+
		"\2\2vw\7\r\2\2wy\7\37\2\2xz\5\32\16\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|"+
		"\7\3\2\2|\25\3\2\2\2}\177\7\32\2\2~}\3\2\2\2~\177\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\u0081\5\36\20\2\u0081\u0082\5\30\r\2\u0082\u0083\7\r\2\2"+
		"\u0083\u0085\7\37\2\2\u0084\u0086\5\32\16\2\u0085\u0084\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\3\2\2\u0088\27\3\2\2"+
		"\2\u0089\u008e\7\20\2\2\u008a\u008e\7\4\2\2\u008b\u008e\7\6\2\2\u008c"+
		"\u008e\7\36\2\2\u008d\u0089\3\2\2\2\u008d\u008a\3\2\2\2\u008d\u008b\3"+
		"\2\2\2\u008d\u008c\3\2\2\2\u008e\31\3\2\2\2\u008f\u0090\7\21\2\2\u0090"+
		"\u0095\5\20\t\2\u0091\u0092\7\22\2\2\u0092\u0094\5\20\t\2\u0093\u0091"+
		"\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7\23\2\2\u0099\33\3\2\2"+
		"\2\u009a\u00a0\7\37\2\2\u009b\u00a0\7\35\2\2\u009c\u00a0\7\34\2\2\u009d"+
		"\u00a0\7 \2\2\u009e\u00a0\7\36\2\2\u009f\u009a\3\2\2\2\u009f\u009b\3\2"+
		"\2\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\35\3\2\2\2\u00a1\u00a7\7\33\2\2\u00a2\u00a4\7\f\2\2\u00a3\u00a2\3\2\2"+
		"\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\7\36\2\2\u00a6"+
		"\u00a1\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7\37\3\2\2\2\u00a8\u00a9\7\24\2"+
		"\2\u00a9\u00aa\7\37\2\2\u00aa\u00ab\7\25\2\2\u00ab\u00ac\7\36\2\2\u00ac"+
		"\u00ad\7\3\2\2\u00ad!\3\2\2\2\u00ae\u00af\7\26\2\2\u00af\u00b0\7\36\2"+
		"\2\u00b0\u00b2\7\7\2\2\u00b1\u00b3\5\26\f\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b7\7\b\2\2\u00b7#\3\2\2\2\u00b8\u00b9\7\27\2\2\u00b9\u00ba"+
		"\7\36\2\2\u00ba\u00bd\7\7\2\2\u00bb\u00be\5\16\b\2\u00bc\u00be\5&\24\2"+
		"\u00bd\u00bb\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\b\2\2\u00c2"+
		"%\3\2\2\2\u00c3\u00c4\7\30\2\2\u00c4\u00c5\7\36\2\2\u00c5\u00c6\7\n\2"+
		"\2\u00c6\u00c7\5\36\20\2\u00c7\u00c8\7\13\2\2\u00c8\u00c9\7\31\2\2\u00c9"+
		"\u00ca\7\n\2\2\u00ca\u00cb\5\36\20\2\u00cb\u00d7\7\13\2\2\u00cc\u00d8"+
		"\7\3\2\2\u00cd\u00d1\7\7\2\2\u00ce\u00d0\5\16\b\2\u00cf\u00ce\3\2\2\2"+
		"\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4"+
		"\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d6\7\b\2\2\u00d5\u00cd\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00cc\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d8\'\3\2\2\2\32*,\63\65:PR_iqy~\u0085\u008d\u0095\u009f\u00a3"+
		"\u00a6\u00b4\u00bd\u00bf\u00d1\u00d5\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}