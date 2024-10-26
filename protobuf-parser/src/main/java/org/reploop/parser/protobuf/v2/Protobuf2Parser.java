// Generated from org/reploop/parser/protobuf/v2/Protobuf2.g4 by ANTLR 4.13.2
package org.reploop.parser.protobuf.v2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Protobuf2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2242L) != 0)) {
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 12648704L) != 0) );
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1280395520L) != 0)) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1275084800L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
		"\u0004\u0001#\u00db\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0005\u0000)\b\u0000\n\u0000\f\u0000,\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u00002\b\u0000"+
		"\u000b\u0000\f\u00003\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"9\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"Q\b\u0005\n\u0005\f\u0005T\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007a\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007k\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0004\bq\b\b\u000b"+
		"\b\f\br\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t{\b\t\u0001"+
		"\t\u0001\t\u0001\n\u0003\n\u0080\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u0087\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u008f\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u0095\b\f\n\f\f\f\u0098\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00a1\b\r\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00a5\b\u000e\u0001\u000e\u0003\u000e\u00a8\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u00b4\b\u0010\u000b\u0010\f"+
		"\u0010\u00b5\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0004\u0011\u00bf\b\u0011\u000b\u0011\f\u0011"+
		"\u00c0\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00d1\b\u0012\n\u0012\f\u0012"+
		"\u00d4\t\u0012\u0001\u0012\u0003\u0012\u00d7\b\u0012\u0003\u0012\u00d9"+
		"\b\u0012\u0001\u0012\u0000\u0000\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0001\u0001"+
		"\u0000\u0003\u0004\u00ec\u0000*\u0001\u0000\u0000\u0000\u00028\u0001\u0000"+
		"\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000"+
		"\bC\u0001\u0000\u0000\u0000\nG\u0001\u0000\u0000\u0000\fW\u0001\u0000"+
		"\u0000\u0000\u000ej\u0001\u0000\u0000\u0000\u0010l\u0001\u0000\u0000\u0000"+
		"\u0012v\u0001\u0000\u0000\u0000\u0014\u007f\u0001\u0000\u0000\u0000\u0016"+
		"\u008e\u0001\u0000\u0000\u0000\u0018\u0090\u0001\u0000\u0000\u0000\u001a"+
		"\u00a0\u0001\u0000\u0000\u0000\u001c\u00a7\u0001\u0000\u0000\u0000\u001e"+
		"\u00a9\u0001\u0000\u0000\u0000 \u00af\u0001\u0000\u0000\u0000\"\u00b9"+
		"\u0001\u0000\u0000\u0000$\u00c4\u0001\u0000\u0000\u0000&)\u0003\f\u0006"+
		"\u0000\')\u0003\u0002\u0001\u0000(&\u0001\u0000\u0000\u0000(\'\u0001\u0000"+
		"\u0000\u0000),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001"+
		"\u0000\u0000\u0000+1\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		"-2\u0003\n\u0005\u0000.2\u0003\u0010\b\u0000/2\u0003\"\u0011\u000002\u0003"+
		" \u0010\u00001-\u0001\u0000\u0000\u00001.\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000010\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u00004\u0001\u0001\u0000"+
		"\u0000\u000059\u0003\u0006\u0003\u000069\u0003\b\u0004\u000079\u0003\u0004"+
		"\u0002\u000085\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000087\u0001"+
		"\u0000\u0000\u00009\u0003\u0001\u0000\u0000\u0000:;\u0005\u0001\u0000"+
		"\u0000;<\u0005\u0002\u0000\u0000<=\u0007\u0000\u0000\u0000=>\u0005\u0005"+
		"\u0000\u0000>\u0005\u0001\u0000\u0000\u0000?@\u0005\u0006\u0000\u0000"+
		"@A\u0005\u001e\u0000\u0000AB\u0005\u0005\u0000\u0000B\u0007\u0001\u0000"+
		"\u0000\u0000CD\u0005\u0007\u0000\u0000DE\u0005 \u0000\u0000EF\u0005\u0005"+
		"\u0000\u0000F\t\u0001\u0000\u0000\u0000GH\u0005\b\u0000\u0000HI\u0005"+
		"\u001e\u0000\u0000IR\u0005\t\u0000\u0000JQ\u0003\f\u0006\u0000KQ\u0003"+
		"\n\u0005\u0000LQ\u0003\u0010\b\u0000MQ\u0003\u0014\n\u0000NQ\u0003 \u0010"+
		"\u0000OQ\u0003\u001e\u000f\u0000PJ\u0001\u0000\u0000\u0000PK\u0001\u0000"+
		"\u0000\u0000PL\u0001\u0000\u0000\u0000PM\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000"+
		"\u0000TR\u0001\u0000\u0000\u0000UV\u0005\n\u0000\u0000V\u000b\u0001\u0000"+
		"\u0000\u0000WX\u0005\u000b\u0000\u0000XY\u0003\u000e\u0007\u0000YZ\u0005"+
		"\u0005\u0000\u0000Z\r\u0001\u0000\u0000\u0000[\\\u0005\f\u0000\u0000\\"+
		"]\u0005\u001e\u0000\u0000]`\u0005\r\u0000\u0000^_\u0005\u000e\u0000\u0000"+
		"_a\u0005\u001e\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000bc\u0005\u0002\u0000\u0000ck\u0003\u001a"+
		"\r\u0000de\u0005\u000f\u0000\u0000ef\u0005\u0002\u0000\u0000fk\u0003\u001a"+
		"\r\u0000gh\u0005\u001e\u0000\u0000hi\u0005\u0002\u0000\u0000ik\u0003\u001a"+
		"\r\u0000j[\u0001\u0000\u0000\u0000jd\u0001\u0000\u0000\u0000jg\u0001\u0000"+
		"\u0000\u0000k\u000f\u0001\u0000\u0000\u0000lm\u0005\u0010\u0000\u0000"+
		"mn\u0005\u001e\u0000\u0000np\u0005\t\u0000\u0000oq\u0003\u0012\t\u0000"+
		"po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000"+
		"\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0005\n\u0000"+
		"\u0000u\u0011\u0001\u0000\u0000\u0000vw\u0005\u001e\u0000\u0000wx\u0005"+
		"\u0002\u0000\u0000xz\u0005\u001f\u0000\u0000y{\u0003\u0018\f\u0000zy\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|}\u0005\u0005\u0000\u0000}\u0013\u0001\u0000\u0000\u0000~\u0080\u0005"+
		"\u001a\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0003\u001c"+
		"\u000e\u0000\u0082\u0083\u0003\u0016\u000b\u0000\u0083\u0084\u0005\u0002"+
		"\u0000\u0000\u0084\u0086\u0005\u001f\u0000\u0000\u0085\u0087\u0003\u0018"+
		"\f\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0005\u0000"+
		"\u0000\u0089\u0015\u0001\u0000\u0000\u0000\u008a\u008f\u0005\u0001\u0000"+
		"\u0000\u008b\u008f\u0005\u0006\u0000\u0000\u008c\u008f\u0005\b\u0000\u0000"+
		"\u008d\u008f\u0005\u001e\u0000\u0000\u008e\u008a\u0001\u0000\u0000\u0000"+
		"\u008e\u008b\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0017\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0005\u0011\u0000\u0000\u0091\u0096\u0003\u000e\u0007\u0000"+
		"\u0092\u0093\u0005\u0012\u0000\u0000\u0093\u0095\u0003\u000e\u0007\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000"+
		"\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0005\u0013\u0000\u0000\u009a\u0019\u0001\u0000\u0000\u0000"+
		"\u009b\u00a1\u0005\u001f\u0000\u0000\u009c\u00a1\u0005\u001d\u0000\u0000"+
		"\u009d\u00a1\u0005\u001c\u0000\u0000\u009e\u00a1\u0005 \u0000\u0000\u009f"+
		"\u00a1\u0005\u001e\u0000\u0000\u00a0\u009b\u0001\u0000\u0000\u0000\u00a0"+
		"\u009c\u0001\u0000\u0000\u0000\u00a0\u009d\u0001\u0000\u0000\u0000\u00a0"+
		"\u009e\u0001\u0000\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u001b\u0001\u0000\u0000\u0000\u00a2\u00a8\u0005\u001b\u0000\u0000\u00a3"+
		"\u00a5\u0005\u000e\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a8\u0005\u001e\u0000\u0000\u00a7\u00a2\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a8\u001d\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005\u0014\u0000\u0000\u00aa\u00ab\u0005\u001f\u0000\u0000\u00ab"+
		"\u00ac\u0005\u0015\u0000\u0000\u00ac\u00ad\u0005\u001e\u0000\u0000\u00ad"+
		"\u00ae\u0005\u0005\u0000\u0000\u00ae\u001f\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0005\u0016\u0000\u0000\u00b0\u00b1\u0005\u001e\u0000\u0000\u00b1"+
		"\u00b3\u0005\t\u0000\u0000\u00b2\u00b4\u0003\u0014\n\u0000\u00b3\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\n\u0000\u0000\u00b8!\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0005\u0017\u0000\u0000\u00ba\u00bb\u0005"+
		"\u001e\u0000\u0000\u00bb\u00be\u0005\t\u0000\u0000\u00bc\u00bf\u0003\f"+
		"\u0006\u0000\u00bd\u00bf\u0003$\u0012\u0000\u00be\u00bc\u0001\u0000\u0000"+
		"\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\n\u0000\u0000"+
		"\u00c3#\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0018\u0000\u0000\u00c5"+
		"\u00c6\u0005\u001e\u0000\u0000\u00c6\u00c7\u0005\f\u0000\u0000\u00c7\u00c8"+
		"\u0003\u001c\u000e\u0000\u00c8\u00c9\u0005\r\u0000\u0000\u00c9\u00ca\u0005"+
		"\u0019\u0000\u0000\u00ca\u00cb\u0005\f\u0000\u0000\u00cb\u00cc\u0003\u001c"+
		"\u000e\u0000\u00cc\u00d8\u0005\r\u0000\u0000\u00cd\u00d9\u0005\u0005\u0000"+
		"\u0000\u00ce\u00d2\u0005\t\u0000\u0000\u00cf\u00d1\u0003\f\u0006\u0000"+
		"\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d5\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d7\u0005\n\u0000\u0000\u00d6\u00ce\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000\u00d8"+
		"\u00cd\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9"+
		"%\u0001\u0000\u0000\u0000\u0018(*138PR`jrz\u007f\u0086\u008e\u0096\u00a0"+
		"\u00a4\u00a7\u00b5\u00be\u00c0\u00d2\u00d6\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}