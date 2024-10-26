// Generated from org/reploop/parser/thrift/base/ThriftBase.g4 by ANTLR 4.13.2
package org.reploop.parser.thrift.base;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ThriftBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		XsdAll=53, XsdOptional=54, XsdNillable=55, FieldRequiredness=56, ONEWAY=57, 
		ID=58, ST_ID=59, LITERAL=60, INT=61, DOUBLE=62, FLOAT=63, STRING=64, LINE_COMMENT=65, 
		COMMENT=66, WS=67;
	public static final int
		RULE_program = 0, RULE_header = 1, RULE_include = 2, RULE_cppInclude = 3, 
		RULE_namespace = 4, RULE_namespaceScope = 5, RULE_definition = 6, RULE_typeDefinition = 7, 
		RULE_typedef = 8, RULE_enumeration = 9, RULE_enumDef = 10, RULE_senum = 11, 
		RULE_senumDef = 12, RULE_constant = 13, RULE_constValue = 14, RULE_structHead = 15, 
		RULE_struct = 16, RULE_xsdAttributes = 17, RULE_xception = 18, RULE_service = 19, 
		RULE_function = 20, RULE_raise = 21, RULE_field = 22, RULE_fieldID = 23, 
		RULE_fieldValue = 24, RULE_functionType = 25, RULE_primitives = 26, RULE_fieldType = 27, 
		RULE_commaOrSemicolon = 28, RULE_cppType = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "header", "include", "cppInclude", "namespace", "namespaceScope", 
			"definition", "typeDefinition", "typedef", "enumeration", "enumDef", 
			"senum", "senumDef", "constant", "constValue", "structHead", "struct", 
			"xsdAttributes", "xception", "service", "function", "raise", "field", 
			"fieldID", "fieldValue", "functionType", "primitives", "fieldType", "commaOrSemicolon", 
			"cppType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'include'", "'cpp_include'", "'namespace'", "'smalltalk.category'", 
			"'smalltalk.prefix'", "'xsd_namespace'", "'php_namespace'", "'*'", "'cpp'", 
			"'java'", "'py'", "'perl'", "'rb'", "'cocoa'", "'csharp'", "'typedef'", 
			"'enum'", "'{'", "'}'", "'='", "'senum'", "'const'", "'['", "']'", "':'", 
			"'struct'", "'union'", "'xsd_attrs'", "'exception'", "'service'", "'extends'", 
			"'('", "')'", "'throws'", "'void'", "'string'", "'binary'", "'slist'", 
			"'bool'", "'byte'", "'i16'", "'i32'", "'i64'", "'double'", "'map'", "'<'", 
			"','", "'>'", "'set'", "'list'", "';'", "'cpp_type'", "'xsd_all'", "'xsd_optional'", 
			"'xsd_nillable'", null, "'oneway'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "XsdAll", "XsdOptional", "XsdNillable", 
			"FieldRequiredness", "ONEWAY", "ID", "ST_ID", "LITERAL", "INT", "DOUBLE", 
			"FLOAT", "STRING", "LINE_COMMENT", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "ThriftBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ThriftBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<HeaderContext> header() {
			return getRuleContexts(HeaderContext.class);
		}
		public HeaderContext header(int i) {
			return getRuleContext(HeaderContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 254L) != 0)) {
				{
				{
				setState(60);
				header();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1818427392L) != 0)) {
				{
				{
				setState(66);
				definition();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class CppIncludeDefinitionContext extends HeaderContext {
		public CppIncludeContext cppInclude() {
			return getRuleContext(CppIncludeContext.class,0);
		}
		public CppIncludeDefinitionContext(HeaderContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterCppIncludeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitCppIncludeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitCppIncludeDefinition(this);
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
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterIncludeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitIncludeDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitIncludeDefinition(this);
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
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterNamespaceDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitNamespaceDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitNamespaceDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new IncludeDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				include();
				}
				break;
			case T__1:
				_localctx = new CppIncludeDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				cppInclude();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
				_localctx = new NamespaceDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				namespace();
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
	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(ThriftBaseParser.LITERAL, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitInclude(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__0);
			setState(78);
			match(LITERAL);
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
	public static class CppIncludeContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(ThriftBaseParser.LITERAL, 0); }
		public CppIncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cppInclude; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterCppInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitCppInclude(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitCppInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CppIncludeContext cppInclude() throws RecognitionException {
		CppIncludeContext _localctx = new CppIncludeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cppInclude);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__1);
			setState(81);
			match(LITERAL);
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
		public NamespaceScopeContext namespaceScope() {
			return getRuleContext(NamespaceScopeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public TerminalNode ST_ID() { return getToken(ThriftBaseParser.ST_ID, 0); }
		public TerminalNode LITERAL() { return getToken(ThriftBaseParser.LITERAL, 0); }
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitNamespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitNamespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_namespace);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(T__2);
				setState(84);
				namespaceScope();
				setState(85);
				match(ID);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(T__3);
				setState(88);
				match(ST_ID);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				match(T__4);
				setState(90);
				match(ID);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				match(T__5);
				setState(92);
				match(LITERAL);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				match(T__6);
				setState(94);
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
	public static class NamespaceScopeContext extends ParserRuleContext {
		public NamespaceScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterNamespaceScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitNamespaceScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitNamespaceScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceScopeContext namespaceScope() throws RecognitionException {
		NamespaceScopeContext _localctx = new NamespaceScopeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_namespaceScope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 65280L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	 
		public DefinitionContext() { }
		public void copyFrom(DefinitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeDefinitionDefinitionContext extends DefinitionContext {
		public TypeDefinitionContext typeDefinition() {
			return getRuleContext(TypeDefinitionContext.class,0);
		}
		public TypeDefinitionDefinitionContext(DefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterTypeDefinitionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitTypeDefinitionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitTypeDefinitionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDefinitionContext extends DefinitionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantDefinitionContext(DefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterConstantDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitConstantDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitConstantDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ServiceDefinitionContext extends DefinitionContext {
		public ServiceContext service() {
			return getRuleContext(ServiceContext.class,0);
		}
		public ServiceDefinitionContext(DefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterServiceDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitServiceDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitServiceDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_definition);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				_localctx = new ConstantDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				constant();
				}
				break;
			case T__15:
			case T__16:
			case T__20:
			case T__25:
			case T__26:
			case T__28:
				_localctx = new TypeDefinitionDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				typeDefinition();
				}
				break;
			case T__29:
				_localctx = new ServiceDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				service();
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
	public static class TypeDefinitionContext extends ParserRuleContext {
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
	 
		public TypeDefinitionContext() { }
		public void copyFrom(TypeDefinitionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EnumerationDefinitionContext extends TypeDefinitionContext {
		public EnumerationContext enumeration() {
			return getRuleContext(EnumerationContext.class,0);
		}
		public EnumerationDefinitionContext(TypeDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterEnumerationDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitEnumerationDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitEnumerationDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypedefDefinitionContext extends TypeDefinitionContext {
		public TypedefContext typedef() {
			return getRuleContext(TypedefContext.class,0);
		}
		public TypedefDefinitionContext(TypeDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterTypedefDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitTypedefDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitTypedefDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExceptionDefinitionContext extends TypeDefinitionContext {
		public XceptionContext xception() {
			return getRuleContext(XceptionContext.class,0);
		}
		public ExceptionDefinitionContext(TypeDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterExceptionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitExceptionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitExceptionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SenumDefinitionContext extends TypeDefinitionContext {
		public SenumContext senum() {
			return getRuleContext(SenumContext.class,0);
		}
		public SenumDefinitionContext(TypeDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterSenumDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitSenumDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitSenumDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructDefinitionContext extends TypeDefinitionContext {
		public StructContext struct() {
			return getRuleContext(StructContext.class,0);
		}
		public StructDefinitionContext(TypeDefinitionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterStructDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitStructDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitStructDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typeDefinition);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__15:
				_localctx = new TypedefDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				typedef();
				}
				break;
			case T__16:
				_localctx = new EnumerationDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				enumeration();
				}
				break;
			case T__20:
				_localctx = new SenumDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				senum();
				}
				break;
			case T__25:
			case T__26:
				_localctx = new StructDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				struct();
				}
				break;
			case T__28:
				_localctx = new ExceptionDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				xception();
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
	public static class TypedefContext extends ParserRuleContext {
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public TypedefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterTypedef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitTypedef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitTypedef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedefContext typedef() throws RecognitionException {
		TypedefContext _localctx = new TypedefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typedef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__15);
			setState(112);
			fieldType();
			setState(113);
			match(ID);
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
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public List<EnumDefContext> enumDef() {
			return getRuleContexts(EnumDefContext.class);
		}
		public EnumDefContext enumDef(int i) {
			return getRuleContext(EnumDefContext.class,i);
		}
		public EnumerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterEnumeration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitEnumeration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitEnumeration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationContext enumeration() throws RecognitionException {
		EnumerationContext _localctx = new EnumerationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enumeration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(T__16);
			setState(116);
			match(ID);
			setState(117);
			match(T__17);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(118);
				enumDef();
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
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
	public static class EnumDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public TerminalNode INT() { return getToken(ThriftBaseParser.INT, 0); }
		public CommaOrSemicolonContext commaOrSemicolon() {
			return getRuleContext(CommaOrSemicolonContext.class,0);
		}
		public EnumDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterEnumDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitEnumDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitEnumDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDefContext enumDef() throws RecognitionException {
		EnumDefContext _localctx = new EnumDefContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enumDef);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(ID);
				setState(127);
				match(T__19);
				setState(128);
				match(INT);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__46 || _la==T__50) {
					{
					setState(129);
					commaOrSemicolon();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(ID);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__46 || _la==T__50) {
					{
					setState(133);
					commaOrSemicolon();
					}
				}

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
	public static class SenumContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public List<SenumDefContext> senumDef() {
			return getRuleContexts(SenumDefContext.class);
		}
		public SenumDefContext senumDef(int i) {
			return getRuleContext(SenumDefContext.class,i);
		}
		public SenumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterSenum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitSenum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitSenum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SenumContext senum() throws RecognitionException {
		SenumContext _localctx = new SenumContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_senum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__20);
			setState(139);
			match(ID);
			setState(140);
			match(T__17);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LITERAL) {
				{
				{
				setState(141);
				senumDef();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
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
	public static class SenumDefContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(ThriftBaseParser.LITERAL, 0); }
		public CommaOrSemicolonContext commaOrSemicolon() {
			return getRuleContext(CommaOrSemicolonContext.class,0);
		}
		public SenumDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senumDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterSenumDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitSenumDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitSenumDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SenumDefContext senumDef() throws RecognitionException {
		SenumDefContext _localctx = new SenumDefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_senumDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(LITERAL);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__50) {
				{
				setState(150);
				commaOrSemicolon();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public ConstValueContext constValue() {
			return getRuleContext(ConstValueContext.class,0);
		}
		public CommaOrSemicolonContext commaOrSemicolon() {
			return getRuleContext(CommaOrSemicolonContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__21);
			setState(154);
			fieldType();
			setState(155);
			match(ID);
			setState(156);
			match(T__19);
			setState(157);
			constValue();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__50) {
				{
				setState(158);
				commaOrSemicolon();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConstValueContext extends ParserRuleContext {
		public List<ConstValueContext> constValue() {
			return getRuleContexts(ConstValueContext.class);
		}
		public ConstValueContext constValue(int i) {
			return getRuleContext(ConstValueContext.class,i);
		}
		public List<CommaOrSemicolonContext> commaOrSemicolon() {
			return getRuleContexts(CommaOrSemicolonContext.class);
		}
		public CommaOrSemicolonContext commaOrSemicolon(int i) {
			return getRuleContext(CommaOrSemicolonContext.class,i);
		}
		public TerminalNode LITERAL() { return getToken(ThriftBaseParser.LITERAL, 0); }
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public TerminalNode INT() { return getToken(ThriftBaseParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(ThriftBaseParser.DOUBLE, 0); }
		public ConstValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterConstValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitConstValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitConstValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstValueContext constValue() throws RecognitionException {
		ConstValueContext _localctx = new ConstValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constValue);
		int _la;
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(T__22);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8358680908408291328L) != 0)) {
					{
					{
					setState(162);
					constValue();
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__46 || _la==T__50) {
						{
						setState(163);
						commaOrSemicolon();
						}
					}

					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(171);
				match(T__23);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(T__17);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8358680908408291328L) != 0)) {
					{
					{
					setState(173);
					constValue();
					setState(174);
					match(T__24);
					setState(175);
					constValue();
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__46 || _la==T__50) {
						{
						setState(176);
						commaOrSemicolon();
						}
					}

					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				match(T__18);
				}
				break;
			case LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				match(LITERAL);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				match(ID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				match(INT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				match(DOUBLE);
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
	public static class StructHeadContext extends ParserRuleContext {
		public StructHeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structHead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterStructHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitStructHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitStructHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructHeadContext structHead() throws RecognitionException {
		StructHeadContext _localctx = new StructHeadContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_structHead);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_la = _input.LA(1);
			if ( !(_la==T__25 || _la==T__26) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructContext extends ParserRuleContext {
		public StructHeadContext structHead() {
			return getRuleContext(StructHeadContext.class,0);
		}
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public TerminalNode XsdAll() { return getToken(ThriftBaseParser.XsdAll, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public StructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructContext struct() throws RecognitionException {
		StructContext _localctx = new StructContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_struct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			structHead();
			setState(194);
			match(ID);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==XsdAll) {
				{
				setState(195);
				match(XsdAll);
				}
			}

			setState(198);
			match(T__17);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(199);
				field();
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
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
	public static class XsdAttributesContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public XsdAttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xsdAttributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterXsdAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitXsdAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitXsdAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XsdAttributesContext xsdAttributes() throws RecognitionException {
		XsdAttributesContext _localctx = new XsdAttributesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_xsdAttributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__27);
			setState(208);
			match(T__17);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(209);
				field();
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
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
	public static class XceptionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public XceptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xception; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterXception(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitXception(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitXception(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XceptionContext xception() throws RecognitionException {
		XceptionContext _localctx = new XceptionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_xception);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__28);
			setState(218);
			match(ID);
			setState(219);
			match(T__17);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(220);
				field();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
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
	public static class ServiceContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ThriftBaseParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ThriftBaseParser.ID, i);
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
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitService(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitService(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceContext service() throws RecognitionException {
		ServiceContext _localctx = new ServiceContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_service);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__29);
			setState(229);
			match(ID);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__30) {
				{
				setState(230);
				match(T__30);
				setState(231);
				match(ID);
				}
			}

			setState(234);
			match(T__17);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 434104748472270848L) != 0)) {
				{
				{
				setState(235);
				function();
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241);
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
	public static class FunctionContext extends ParserRuleContext {
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public TerminalNode ONEWAY() { return getToken(ThriftBaseParser.ONEWAY, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public RaiseContext raise() {
			return getRuleContext(RaiseContext.class,0);
		}
		public CommaOrSemicolonContext commaOrSemicolon() {
			return getRuleContext(CommaOrSemicolonContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ONEWAY) {
				{
				setState(243);
				match(ONEWAY);
				}
			}

			setState(246);
			functionType();
			setState(247);
			match(ID);
			setState(248);
			match(T__31);
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INT) {
				{
				{
				setState(249);
				field();
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(255);
			match(T__32);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(256);
				raise();
				}
			}

			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__50) {
				{
				setState(259);
				commaOrSemicolon();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class RaiseContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public RaiseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterRaise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitRaise(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitRaise(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RaiseContext raise() throws RecognitionException {
		RaiseContext _localctx = new RaiseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_raise);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(T__33);
			setState(263);
			match(T__31);
			setState(265); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(264);
				field();
				}
				}
				setState(267); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT );
			setState(269);
			match(T__32);
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
		public FieldIDContext fieldID() {
			return getRuleContext(FieldIDContext.class,0);
		}
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public TerminalNode FieldRequiredness() { return getToken(ThriftBaseParser.FieldRequiredness, 0); }
		public FieldValueContext fieldValue() {
			return getRuleContext(FieldValueContext.class,0);
		}
		public TerminalNode XsdOptional() { return getToken(ThriftBaseParser.XsdOptional, 0); }
		public TerminalNode XsdNillable() { return getToken(ThriftBaseParser.XsdNillable, 0); }
		public XsdAttributesContext xsdAttributes() {
			return getRuleContext(XsdAttributesContext.class,0);
		}
		public CommaOrSemicolonContext commaOrSemicolon() {
			return getRuleContext(CommaOrSemicolonContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			fieldID();
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FieldRequiredness) {
				{
				setState(272);
				match(FieldRequiredness);
				}
			}

			setState(275);
			fieldType();
			setState(276);
			match(ID);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(277);
				fieldValue();
				}
			}

			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==XsdOptional) {
				{
				setState(280);
				match(XsdOptional);
				}
			}

			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==XsdNillable) {
				{
				setState(283);
				match(XsdNillable);
				}
			}

			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(286);
				xsdAttributes();
				}
			}

			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__46 || _la==T__50) {
				{
				setState(289);
				commaOrSemicolon();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class FieldIDContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ThriftBaseParser.INT, 0); }
		public FieldIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterFieldID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitFieldID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitFieldID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldIDContext fieldID() throws RecognitionException {
		FieldIDContext _localctx = new FieldIDContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fieldID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(INT);
			setState(293);
			match(T__24);
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
	public static class FieldValueContext extends ParserRuleContext {
		public ConstValueContext constValue() {
			return getRuleContext(ConstValueContext.class,0);
		}
		public FieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitFieldValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitFieldValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldValueContext fieldValue() throws RecognitionException {
		FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_fieldValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(T__19);
			setState(296);
			constValue();
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
	public static class FunctionTypeContext extends ParserRuleContext {
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
	 
		public FunctionTypeContext() { }
		public void copyFrom(FunctionTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidTypeContext extends FunctionTypeContext {
		public VoidTypeContext(FunctionTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitVoidType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitVoidType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeContext extends FunctionTypeContext {
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public ReturnTypeContext(FunctionTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_functionType);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__48:
			case T__49:
			case ID:
				_localctx = new ReturnTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				fieldType();
				}
				break;
			case T__34:
				_localctx = new VoidTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(T__34);
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
	public static class PrimitivesContext extends ParserRuleContext {
		public PrimitivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterPrimitives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitPrimitives(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitPrimitives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitivesContext primitives() throws RecognitionException {
		PrimitivesContext _localctx = new PrimitivesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primitives);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 35115652612096L) != 0)) ) {
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
	public static class StructTypeContext extends FieldTypeContext {
		public TerminalNode ID() { return getToken(ThriftBaseParser.ID, 0); }
		public StructTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterStructType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitStructType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitStructType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MapTypeContext extends FieldTypeContext {
		public FieldTypeContext key;
		public FieldTypeContext value;
		public List<FieldTypeContext> fieldType() {
			return getRuleContexts(FieldTypeContext.class);
		}
		public FieldTypeContext fieldType(int i) {
			return getRuleContext(FieldTypeContext.class,i);
		}
		public CppTypeContext cppType() {
			return getRuleContext(CppTypeContext.class,0);
		}
		public MapTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterMapType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitMapType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitMapType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SetTypeContext extends FieldTypeContext {
		public FieldTypeContext element;
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public CppTypeContext cppType() {
			return getRuleContext(CppTypeContext.class,0);
		}
		public SetTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterSetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitSetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitSetType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListTypeContext extends FieldTypeContext {
		public FieldTypeContext element;
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public CppTypeContext cppType() {
			return getRuleContext(CppTypeContext.class,0);
		}
		public ListTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitListType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends FieldTypeContext {
		public PrimitivesContext primitives() {
			return getRuleContext(PrimitivesContext.class,0);
		}
		public PrimitiveTypeContext(FieldTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_fieldType);
		int _la;
		try {
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__44:
				_localctx = new MapTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				match(T__44);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__51) {
					{
					setState(305);
					cppType();
					}
				}

				setState(308);
				match(T__45);
				setState(309);
				((MapTypeContext)_localctx).key = fieldType();
				setState(310);
				match(T__46);
				setState(311);
				((MapTypeContext)_localctx).value = fieldType();
				setState(312);
				match(T__47);
				}
				break;
			case T__48:
				_localctx = new SetTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(T__48);
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__51) {
					{
					setState(315);
					cppType();
					}
				}

				setState(318);
				match(T__45);
				setState(319);
				((SetTypeContext)_localctx).element = fieldType();
				setState(320);
				match(T__47);
				}
				break;
			case T__49:
				_localctx = new ListTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				match(T__49);
				setState(323);
				match(T__45);
				setState(324);
				((ListTypeContext)_localctx).element = fieldType();
				setState(325);
				match(T__47);
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__51) {
					{
					setState(326);
					cppType();
					}
				}

				}
				break;
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
				_localctx = new PrimitiveTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(329);
				primitives();
				}
				break;
			case ID:
				_localctx = new StructTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(330);
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
	public static class CommaOrSemicolonContext extends ParserRuleContext {
		public CommaOrSemicolonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commaOrSemicolon; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterCommaOrSemicolon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitCommaOrSemicolon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitCommaOrSemicolon(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommaOrSemicolonContext commaOrSemicolon() throws RecognitionException {
		CommaOrSemicolonContext _localctx = new CommaOrSemicolonContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_commaOrSemicolon);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_la = _input.LA(1);
			if ( !(_la==T__46 || _la==T__50) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class CppTypeContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(ThriftBaseParser.LITERAL, 0); }
		public CppTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cppType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).enterCppType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ThriftBaseListener ) ((ThriftBaseListener)listener).exitCppType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ThriftBaseVisitor ) return ((ThriftBaseVisitor<? extends T>)visitor).visitCppType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CppTypeContext cppType() throws RecognitionException {
		CppTypeContext _localctx = new CppTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_cppType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__51);
			setState(336);
			match(LITERAL);
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
		"\u0004\u0001C\u0153\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0005\u0000"+
		">\b\u0000\n\u0000\f\u0000A\t\u0000\u0001\u0000\u0005\u0000D\b\u0000\n"+
		"\u0000\f\u0000G\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"L\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004`\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006g\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007n\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\tx\b\t\n\t\f"+
		"\t{\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0083"+
		"\b\n\u0001\n\u0001\n\u0003\n\u0087\b\n\u0003\n\u0089\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u008f\b\u000b\n\u000b\f\u000b"+
		"\u0092\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0003\f\u0098\b"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00a0\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00a5\b\u000e\u0005\u000e\u00a7"+
		"\b\u000e\n\u000e\f\u000e\u00aa\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00b2\b\u000e\u0005\u000e"+
		"\u00b4\b\u000e\n\u000e\f\u000e\u00b7\t\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00be\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00c5\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u00c9\b\u0010\n\u0010\f\u0010\u00cc\t\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00d3\b\u0011\n\u0011\f\u0011\u00d6\t\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00de\b\u0012\n"+
		"\u0012\f\u0012\u00e1\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00e9\b\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u00ed\b\u0013\n\u0013\f\u0013\u00f0\t\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0003\u0014\u00f5\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u00fb\b\u0014\n\u0014\f\u0014\u00fe"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0102\b\u0014\u0001\u0014"+
		"\u0003\u0014\u0105\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0004\u0015"+
		"\u010a\b\u0015\u000b\u0015\f\u0015\u010b\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u0112\b\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u0117\b\u0016\u0001\u0016\u0003\u0016\u011a\b\u0016"+
		"\u0001\u0016\u0003\u0016\u011d\b\u0016\u0001\u0016\u0003\u0016\u0120\b"+
		"\u0016\u0001\u0016\u0003\u0016\u0123\b\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0003"+
		"\u0019\u012d\b\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u0133\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u013d\b\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0148\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u014c\b\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0000\u0000\u001e\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:\u0000\u0004\u0001\u0000\b\u000f\u0001\u0000\u001a\u001b\u0001\u0000"+
		"$,\u0002\u0000//33\u016b\u0000?\u0001\u0000\u0000\u0000\u0002K\u0001\u0000"+
		"\u0000\u0000\u0004M\u0001\u0000\u0000\u0000\u0006P\u0001\u0000\u0000\u0000"+
		"\b_\u0001\u0000\u0000\u0000\na\u0001\u0000\u0000\u0000\ff\u0001\u0000"+
		"\u0000\u0000\u000em\u0001\u0000\u0000\u0000\u0010o\u0001\u0000\u0000\u0000"+
		"\u0012s\u0001\u0000\u0000\u0000\u0014\u0088\u0001\u0000\u0000\u0000\u0016"+
		"\u008a\u0001\u0000\u0000\u0000\u0018\u0095\u0001\u0000\u0000\u0000\u001a"+
		"\u0099\u0001\u0000\u0000\u0000\u001c\u00bd\u0001\u0000\u0000\u0000\u001e"+
		"\u00bf\u0001\u0000\u0000\u0000 \u00c1\u0001\u0000\u0000\u0000\"\u00cf"+
		"\u0001\u0000\u0000\u0000$\u00d9\u0001\u0000\u0000\u0000&\u00e4\u0001\u0000"+
		"\u0000\u0000(\u00f4\u0001\u0000\u0000\u0000*\u0106\u0001\u0000\u0000\u0000"+
		",\u010f\u0001\u0000\u0000\u0000.\u0124\u0001\u0000\u0000\u00000\u0127"+
		"\u0001\u0000\u0000\u00002\u012c\u0001\u0000\u0000\u00004\u012e\u0001\u0000"+
		"\u0000\u00006\u014b\u0001\u0000\u0000\u00008\u014d\u0001\u0000\u0000\u0000"+
		":\u014f\u0001\u0000\u0000\u0000<>\u0003\u0002\u0001\u0000=<\u0001\u0000"+
		"\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@E\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"BD\u0003\f\u0006\u0000CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000"+
		"EC\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0001\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000HL\u0003\u0004\u0002\u0000IL\u0003"+
		"\u0006\u0003\u0000JL\u0003\b\u0004\u0000KH\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000L\u0003\u0001\u0000\u0000"+
		"\u0000MN\u0005\u0001\u0000\u0000NO\u0005<\u0000\u0000O\u0005\u0001\u0000"+
		"\u0000\u0000PQ\u0005\u0002\u0000\u0000QR\u0005<\u0000\u0000R\u0007\u0001"+
		"\u0000\u0000\u0000ST\u0005\u0003\u0000\u0000TU\u0003\n\u0005\u0000UV\u0005"+
		":\u0000\u0000V`\u0001\u0000\u0000\u0000WX\u0005\u0004\u0000\u0000X`\u0005"+
		";\u0000\u0000YZ\u0005\u0005\u0000\u0000Z`\u0005:\u0000\u0000[\\\u0005"+
		"\u0006\u0000\u0000\\`\u0005<\u0000\u0000]^\u0005\u0007\u0000\u0000^`\u0005"+
		"<\u0000\u0000_S\u0001\u0000\u0000\u0000_W\u0001\u0000\u0000\u0000_Y\u0001"+
		"\u0000\u0000\u0000_[\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"`\t\u0001\u0000\u0000\u0000ab\u0007\u0000\u0000\u0000b\u000b\u0001\u0000"+
		"\u0000\u0000cg\u0003\u001a\r\u0000dg\u0003\u000e\u0007\u0000eg\u0003&"+
		"\u0013\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001"+
		"\u0000\u0000\u0000g\r\u0001\u0000\u0000\u0000hn\u0003\u0010\b\u0000in"+
		"\u0003\u0012\t\u0000jn\u0003\u0016\u000b\u0000kn\u0003 \u0010\u0000ln"+
		"\u0003$\u0012\u0000mh\u0001\u0000\u0000\u0000mi\u0001\u0000\u0000\u0000"+
		"mj\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000ml\u0001\u0000\u0000"+
		"\u0000n\u000f\u0001\u0000\u0000\u0000op\u0005\u0010\u0000\u0000pq\u0003"+
		"6\u001b\u0000qr\u0005:\u0000\u0000r\u0011\u0001\u0000\u0000\u0000st\u0005"+
		"\u0011\u0000\u0000tu\u0005:\u0000\u0000uy\u0005\u0012\u0000\u0000vx\u0003"+
		"\u0014\n\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000yw\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000"+
		"{y\u0001\u0000\u0000\u0000|}\u0005\u0013\u0000\u0000}\u0013\u0001\u0000"+
		"\u0000\u0000~\u007f\u0005:\u0000\u0000\u007f\u0080\u0005\u0014\u0000\u0000"+
		"\u0080\u0082\u0005=\u0000\u0000\u0081\u0083\u00038\u001c\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0089"+
		"\u0001\u0000\u0000\u0000\u0084\u0086\u0005:\u0000\u0000\u0085\u0087\u0003"+
		"8\u001c\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000"+
		"\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088~\u0001\u0000\u0000"+
		"\u0000\u0088\u0084\u0001\u0000\u0000\u0000\u0089\u0015\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0005\u0015\u0000\u0000\u008b\u008c\u0005:\u0000\u0000"+
		"\u008c\u0090\u0005\u0012\u0000\u0000\u008d\u008f\u0003\u0018\f\u0000\u008e"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u0093\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0005\u0013\u0000\u0000\u0094\u0017\u0001\u0000\u0000\u0000\u0095"+
		"\u0097\u0005<\u0000\u0000\u0096\u0098\u00038\u001c\u0000\u0097\u0096\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0019\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0005\u0016\u0000\u0000\u009a\u009b\u0003"+
		"6\u001b\u0000\u009b\u009c\u0005:\u0000\u0000\u009c\u009d\u0005\u0014\u0000"+
		"\u0000\u009d\u009f\u0003\u001c\u000e\u0000\u009e\u00a0\u00038\u001c\u0000"+
		"\u009f\u009e\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a0\u001b\u0001\u0000\u0000\u0000\u00a1\u00a8\u0005\u0017\u0000\u0000"+
		"\u00a2\u00a4\u0003\u001c\u000e\u0000\u00a3\u00a5\u00038\u001c\u0000\u00a4"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a6\u00a2\u0001\u0000\u0000\u0000\u00a7"+
		"\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a8\u0001\u0000\u0000\u0000\u00ab\u00be\u0005\u0018\u0000\u0000\u00ac"+
		"\u00b5\u0005\u0012\u0000\u0000\u00ad\u00ae\u0003\u001c\u000e\u0000\u00ae"+
		"\u00af\u0005\u0019\u0000\u0000\u00af\u00b1\u0003\u001c\u000e\u0000\u00b0"+
		"\u00b2\u00038\u001c\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00be"+
		"\u0005\u0013\u0000\u0000\u00b9\u00be\u0005<\u0000\u0000\u00ba\u00be\u0005"+
		":\u0000\u0000\u00bb\u00be\u0005=\u0000\u0000\u00bc\u00be\u0005>\u0000"+
		"\u0000\u00bd\u00a1\u0001\u0000\u0000\u0000\u00bd\u00ac\u0001\u0000\u0000"+
		"\u0000\u00bd\u00b9\u0001\u0000\u0000\u0000\u00bd\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000"+
		"\u0000\u00be\u001d\u0001\u0000\u0000\u0000\u00bf\u00c0\u0007\u0001\u0000"+
		"\u0000\u00c0\u001f\u0001\u0000\u0000\u0000\u00c1\u00c2\u0003\u001e\u000f"+
		"\u0000\u00c2\u00c4\u0005:\u0000\u0000\u00c3\u00c5\u00055\u0000\u0000\u00c4"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u00ca\u0005\u0012\u0000\u0000\u00c7"+
		"\u00c9\u0003,\u0016\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0013\u0000\u0000\u00ce!\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0005\u001c\u0000\u0000\u00d0\u00d4\u0005"+
		"\u0012\u0000\u0000\u00d1\u00d3\u0003,\u0016\u0000\u00d2\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\u0013"+
		"\u0000\u0000\u00d8#\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\u001d\u0000"+
		"\u0000\u00da\u00db\u0005:\u0000\u0000\u00db\u00df\u0005\u0012\u0000\u0000"+
		"\u00dc\u00de\u0003,\u0016\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0013\u0000\u0000\u00e3"+
		"%\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005\u001e\u0000\u0000\u00e5\u00e8"+
		"\u0005:\u0000\u0000\u00e6\u00e7\u0005\u001f\u0000\u0000\u00e7\u00e9\u0005"+
		":\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u00ee\u0005\u0012"+
		"\u0000\u0000\u00eb\u00ed\u0003(\u0014\u0000\u00ec\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f1\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005\u0013\u0000"+
		"\u0000\u00f2\'\u0001\u0000\u0000\u0000\u00f3\u00f5\u00059\u0000\u0000"+
		"\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000"+
		"\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f7\u00032\u0019\u0000\u00f7"+
		"\u00f8\u0005:\u0000\u0000\u00f8\u00fc\u0005 \u0000\u0000\u00f9\u00fb\u0003"+
		",\u0016\u0000\u00fa\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000"+
		"\u0000\u0000\u00ff\u0101\u0005!\u0000\u0000\u0100\u0102\u0003*\u0015\u0000"+
		"\u0101\u0100\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u0102\u0104\u0001\u0000\u0000\u0000\u0103\u0105\u00038\u001c\u0000\u0104"+
		"\u0103\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105"+
		")\u0001\u0000\u0000\u0000\u0106\u0107\u0005\"\u0000\u0000\u0107\u0109"+
		"\u0005 \u0000\u0000\u0108\u010a\u0003,\u0016\u0000\u0109\u0108\u0001\u0000"+
		"\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0005!\u0000\u0000\u010e+\u0001\u0000\u0000\u0000"+
		"\u010f\u0111\u0003.\u0017\u0000\u0110\u0112\u00058\u0000\u0000\u0111\u0110"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u00036\u001b\u0000\u0114\u0116\u0005"+
		":\u0000\u0000\u0115\u0117\u00030\u0018\u0000\u0116\u0115\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0119\u0001\u0000\u0000"+
		"\u0000\u0118\u011a\u00056\u0000\u0000\u0119\u0118\u0001\u0000\u0000\u0000"+
		"\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011c\u0001\u0000\u0000\u0000"+
		"\u011b\u011d\u00057\u0000\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0001\u0000\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e"+
		"\u0120\u0003\"\u0011\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\u0001\u0000\u0000\u0000\u0120\u0122\u0001\u0000\u0000\u0000\u0121\u0123"+
		"\u00038\u001c\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0122\u0123\u0001"+
		"\u0000\u0000\u0000\u0123-\u0001\u0000\u0000\u0000\u0124\u0125\u0005=\u0000"+
		"\u0000\u0125\u0126\u0005\u0019\u0000\u0000\u0126/\u0001\u0000\u0000\u0000"+
		"\u0127\u0128\u0005\u0014\u0000\u0000\u0128\u0129\u0003\u001c\u000e\u0000"+
		"\u01291\u0001\u0000\u0000\u0000\u012a\u012d\u00036\u001b\u0000\u012b\u012d"+
		"\u0005#\u0000\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012b\u0001"+
		"\u0000\u0000\u0000\u012d3\u0001\u0000\u0000\u0000\u012e\u012f\u0007\u0002"+
		"\u0000\u0000\u012f5\u0001\u0000\u0000\u0000\u0130\u0132\u0005-\u0000\u0000"+
		"\u0131\u0133\u0003:\u001d\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0132"+
		"\u0133\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0005.\u0000\u0000\u0135\u0136\u00036\u001b\u0000\u0136\u0137\u0005"+
		"/\u0000\u0000\u0137\u0138\u00036\u001b\u0000\u0138\u0139\u00050\u0000"+
		"\u0000\u0139\u014c\u0001\u0000\u0000\u0000\u013a\u013c\u00051\u0000\u0000"+
		"\u013b\u013d\u0003:\u001d\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013c"+
		"\u013d\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e"+
		"\u013f\u0005.\u0000\u0000\u013f\u0140\u00036\u001b\u0000\u0140\u0141\u0005"+
		"0\u0000\u0000\u0141\u014c\u0001\u0000\u0000\u0000\u0142\u0143\u00052\u0000"+
		"\u0000\u0143\u0144\u0005.\u0000\u0000\u0144\u0145\u00036\u001b\u0000\u0145"+
		"\u0147\u00050\u0000\u0000\u0146\u0148\u0003:\u001d\u0000\u0147\u0146\u0001"+
		"\u0000\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u014c\u0001"+
		"\u0000\u0000\u0000\u0149\u014c\u00034\u001a\u0000\u014a\u014c\u0005:\u0000"+
		"\u0000\u014b\u0130\u0001\u0000\u0000\u0000\u014b\u013a\u0001\u0000\u0000"+
		"\u0000\u014b\u0142\u0001\u0000\u0000\u0000\u014b\u0149\u0001\u0000\u0000"+
		"\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014c7\u0001\u0000\u0000\u0000"+
		"\u014d\u014e\u0007\u0003\u0000\u0000\u014e9\u0001\u0000\u0000\u0000\u014f"+
		"\u0150\u00054\u0000\u0000\u0150\u0151\u0005<\u0000\u0000\u0151;\u0001"+
		"\u0000\u0000\u0000(?EK_fmy\u0082\u0086\u0088\u0090\u0097\u009f\u00a4\u00a8"+
		"\u00b1\u00b5\u00bd\u00c4\u00ca\u00d4\u00df\u00e8\u00ee\u00f4\u00fc\u0101"+
		"\u0104\u010b\u0111\u0116\u0119\u011c\u011f\u0122\u012c\u0132\u013c\u0147"+
		"\u014b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}