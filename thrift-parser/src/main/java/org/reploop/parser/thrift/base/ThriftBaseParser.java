// Generated from org/reploop/parser/thrift/base/ThriftBase.g4 by ANTLR 4.9.1
package org.reploop.parser.thrift.base;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ThriftBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << T__29))) != 0)) {
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__22) | (1L << ID) | (1L << LITERAL) | (1L << INT) | (1L << DOUBLE))) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__22) | (1L << ID) | (1L << LITERAL) | (1L << INT) | (1L << DOUBLE))) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__48) | (1L << T__49) | (1L << ONEWAY) | (1L << ID))) != 0)) {
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
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3E\u0155\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\7\2@"+
		"\n\2\f\2\16\2C\13\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\3\3\3\3\3\5\3N\n\3\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6b\n\6\3\7\3\7\3\b\3\b\3\b\5\bi\n\b\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13z\n\13\f\13\16\13}\13\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\5\f\u0085\n\f\3\f\3\f\5\f\u0089\n\f\5\f\u008b\n\f"+
		"\3\r\3\r\3\r\3\r\7\r\u0091\n\r\f\r\16\r\u0094\13\r\3\r\3\r\3\16\3\16\5"+
		"\16\u009a\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a2\n\17\3\20\3\20"+
		"\3\20\5\20\u00a7\n\20\7\20\u00a9\n\20\f\20\16\20\u00ac\13\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u00b4\n\20\7\20\u00b6\n\20\f\20\16\20\u00b9"+
		"\13\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c0\n\20\3\21\3\21\3\22\3\22\3"+
		"\22\5\22\u00c7\n\22\3\22\3\22\7\22\u00cb\n\22\f\22\16\22\u00ce\13\22\3"+
		"\22\3\22\3\23\3\23\3\23\7\23\u00d5\n\23\f\23\16\23\u00d8\13\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\7\24\u00e0\n\24\f\24\16\24\u00e3\13\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\5\25\u00eb\n\25\3\25\3\25\7\25\u00ef\n\25\f\25"+
		"\16\25\u00f2\13\25\3\25\3\25\3\26\5\26\u00f7\n\26\3\26\3\26\3\26\3\26"+
		"\7\26\u00fd\n\26\f\26\16\26\u0100\13\26\3\26\3\26\5\26\u0104\n\26\3\26"+
		"\5\26\u0107\n\26\3\27\3\27\3\27\6\27\u010c\n\27\r\27\16\27\u010d\3\27"+
		"\3\27\3\30\3\30\5\30\u0114\n\30\3\30\3\30\3\30\5\30\u0119\n\30\3\30\5"+
		"\30\u011c\n\30\3\30\5\30\u011f\n\30\3\30\5\30\u0122\n\30\3\30\5\30\u0125"+
		"\n\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\5\33\u012f\n\33\3\34\3\34"+
		"\3\35\3\35\5\35\u0135\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35"+
		"\u013f\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u014a\n"+
		"\35\3\35\3\35\5\35\u014e\n\35\3\36\3\36\3\37\3\37\3\37\3\37\2\2 \2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\6\3\2\n\21"+
		"\3\2\34\35\3\2&.\4\2\61\61\65\65\2\u016d\2A\3\2\2\2\4M\3\2\2\2\6O\3\2"+
		"\2\2\bR\3\2\2\2\na\3\2\2\2\fc\3\2\2\2\16h\3\2\2\2\20o\3\2\2\2\22q\3\2"+
		"\2\2\24u\3\2\2\2\26\u008a\3\2\2\2\30\u008c\3\2\2\2\32\u0097\3\2\2\2\34"+
		"\u009b\3\2\2\2\36\u00bf\3\2\2\2 \u00c1\3\2\2\2\"\u00c3\3\2\2\2$\u00d1"+
		"\3\2\2\2&\u00db\3\2\2\2(\u00e6\3\2\2\2*\u00f6\3\2\2\2,\u0108\3\2\2\2."+
		"\u0111\3\2\2\2\60\u0126\3\2\2\2\62\u0129\3\2\2\2\64\u012e\3\2\2\2\66\u0130"+
		"\3\2\2\28\u014d\3\2\2\2:\u014f\3\2\2\2<\u0151\3\2\2\2>@\5\4\3\2?>\3\2"+
		"\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BG\3\2\2\2CA\3\2\2\2DF\5\16\b\2ED\3"+
		"\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\3\3\2\2\2IG\3\2\2\2JN\5\6\4\2KN"+
		"\5\b\5\2LN\5\n\6\2MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\5\3\2\2\2OP\7\3\2\2"+
		"PQ\7>\2\2Q\7\3\2\2\2RS\7\4\2\2ST\7>\2\2T\t\3\2\2\2UV\7\5\2\2VW\5\f\7\2"+
		"WX\7<\2\2Xb\3\2\2\2YZ\7\6\2\2Zb\7=\2\2[\\\7\7\2\2\\b\7<\2\2]^\7\b\2\2"+
		"^b\7>\2\2_`\7\t\2\2`b\7>\2\2aU\3\2\2\2aY\3\2\2\2a[\3\2\2\2a]\3\2\2\2a"+
		"_\3\2\2\2b\13\3\2\2\2cd\t\2\2\2d\r\3\2\2\2ei\5\34\17\2fi\5\20\t\2gi\5"+
		"(\25\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\17\3\2\2\2jp\5\22\n\2kp\5\24\13"+
		"\2lp\5\30\r\2mp\5\"\22\2np\5&\24\2oj\3\2\2\2ok\3\2\2\2ol\3\2\2\2om\3\2"+
		"\2\2on\3\2\2\2p\21\3\2\2\2qr\7\22\2\2rs\58\35\2st\7<\2\2t\23\3\2\2\2u"+
		"v\7\23\2\2vw\7<\2\2w{\7\24\2\2xz\5\26\f\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7\25\2\2\177\25\3\2\2\2\u0080\u0081"+
		"\7<\2\2\u0081\u0082\7\26\2\2\u0082\u0084\7?\2\2\u0083\u0085\5:\36\2\u0084"+
		"\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u008b\3\2\2\2\u0086\u0088\7<"+
		"\2\2\u0087\u0089\5:\36\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008b\3\2\2\2\u008a\u0080\3\2\2\2\u008a\u0086\3\2\2\2\u008b\27\3\2\2"+
		"\2\u008c\u008d\7\27\2\2\u008d\u008e\7<\2\2\u008e\u0092\7\24\2\2\u008f"+
		"\u0091\5\32\16\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3"+
		"\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095"+
		"\u0096\7\25\2\2\u0096\31\3\2\2\2\u0097\u0099\7>\2\2\u0098\u009a\5:\36"+
		"\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\33\3\2\2\2\u009b\u009c"+
		"\7\30\2\2\u009c\u009d\58\35\2\u009d\u009e\7<\2\2\u009e\u009f\7\26\2\2"+
		"\u009f\u00a1\5\36\20\2\u00a0\u00a2\5:\36\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\35\3\2\2\2\u00a3\u00aa\7\31\2\2\u00a4\u00a6\5\36\20\2\u00a5"+
		"\u00a7\5:\36\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2"+
		"\2\2\u00a8\u00a4\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00c0\7\32"+
		"\2\2\u00ae\u00b7\7\24\2\2\u00af\u00b0\5\36\20\2\u00b0\u00b1\7\33\2\2\u00b1"+
		"\u00b3\5\36\20\2\u00b2\u00b4\5:\36\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3"+
		"\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00af\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2"+
		"\2\2\u00ba\u00c0\7\25\2\2\u00bb\u00c0\7>\2\2\u00bc\u00c0\7<\2\2\u00bd"+
		"\u00c0\7?\2\2\u00be\u00c0\7@\2\2\u00bf\u00a3\3\2\2\2\u00bf\u00ae\3\2\2"+
		"\2\u00bf\u00bb\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\37\3\2\2\2\u00c1\u00c2\t\3\2\2\u00c2!\3\2\2\2\u00c3\u00c4"+
		"\5 \21\2\u00c4\u00c6\7<\2\2\u00c5\u00c7\7\67\2\2\u00c6\u00c5\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00cc\7\24\2\2\u00c9\u00cb\5"+
		".\30\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7\25"+
		"\2\2\u00d0#\3\2\2\2\u00d1\u00d2\7\36\2\2\u00d2\u00d6\7\24\2\2\u00d3\u00d5"+
		"\5.\30\2\u00d4\u00d3\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6"+
		"\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7\25"+
		"\2\2\u00da%\3\2\2\2\u00db\u00dc\7\37\2\2\u00dc\u00dd\7<\2\2\u00dd\u00e1"+
		"\7\24\2\2\u00de\u00e0\5.\30\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2"+
		"\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e4\u00e5\7\25\2\2\u00e5\'\3\2\2\2\u00e6\u00e7\7 \2\2\u00e7"+
		"\u00ea\7<\2\2\u00e8\u00e9\7!\2\2\u00e9\u00eb\7<\2\2\u00ea\u00e8\3\2\2"+
		"\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00f0\7\24\2\2\u00ed"+
		"\u00ef\5*\26\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2"+
		"\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f4\7\25\2\2\u00f4)\3\2\2\2\u00f5\u00f7\7;\2\2\u00f6\u00f5\3\2\2\2"+
		"\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\5\64\33\2\u00f9\u00fa"+
		"\7<\2\2\u00fa\u00fe\7\"\2\2\u00fb\u00fd\5.\30\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2"+
		"\2\2\u0100\u00fe\3\2\2\2\u0101\u0103\7#\2\2\u0102\u0104\5,\27\2\u0103"+
		"\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0107\5:"+
		"\36\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107+\3\2\2\2\u0108\u0109"+
		"\7$\2\2\u0109\u010b\7\"\2\2\u010a\u010c\5.\30\2\u010b\u010a\3\2\2\2\u010c"+
		"\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u0110\7#\2\2\u0110-\3\2\2\2\u0111\u0113\5\60\31\2\u0112\u0114"+
		"\7:\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0116\58\35\2\u0116\u0118\7<\2\2\u0117\u0119\5\62\32\2\u0118\u0117\3"+
		"\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u011c\78\2\2\u011b"+
		"\u011a\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011f\79"+
		"\2\2\u011e\u011d\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120"+
		"\u0122\5$\23\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0124\3\2"+
		"\2\2\u0123\u0125\5:\36\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"/\3\2\2\2\u0126\u0127\7?\2\2\u0127\u0128\7\33\2\2\u0128\61\3\2\2\2\u0129"+
		"\u012a\7\26\2\2\u012a\u012b\5\36\20\2\u012b\63\3\2\2\2\u012c\u012f\58"+
		"\35\2\u012d\u012f\7%\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\65\3\2\2\2\u0130\u0131\t\4\2\2\u0131\67\3\2\2\2\u0132\u0134\7/\2\2\u0133"+
		"\u0135\5<\37\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\u0137\7\60\2\2\u0137\u0138\58\35\2\u0138\u0139\7\61\2\2\u0139"+
		"\u013a\58\35\2\u013a\u013b\7\62\2\2\u013b\u014e\3\2\2\2\u013c\u013e\7"+
		"\63\2\2\u013d\u013f\5<\37\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0140\3\2\2\2\u0140\u0141\7\60\2\2\u0141\u0142\58\35\2\u0142\u0143\7"+
		"\62\2\2\u0143\u014e\3\2\2\2\u0144\u0145\7\64\2\2\u0145\u0146\7\60\2\2"+
		"\u0146\u0147\58\35\2\u0147\u0149\7\62\2\2\u0148\u014a\5<\37\2\u0149\u0148"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014e\3\2\2\2\u014b\u014e\5\66\34\2"+
		"\u014c\u014e\7<\2\2\u014d\u0132\3\2\2\2\u014d\u013c\3\2\2\2\u014d\u0144"+
		"\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014c\3\2\2\2\u014e9\3\2\2\2\u014f"+
		"\u0150\t\5\2\2\u0150;\3\2\2\2\u0151\u0152\7\66\2\2\u0152\u0153\7>\2\2"+
		"\u0153=\3\2\2\2*AGMaho{\u0084\u0088\u008a\u0092\u0099\u00a1\u00a6\u00aa"+
		"\u00b3\u00b7\u00bf\u00c6\u00cc\u00d6\u00e1\u00ea\u00f0\u00f6\u00fe\u0103"+
		"\u0106\u010d\u0113\u0118\u011b\u011e\u0121\u0124\u012e\u0134\u013e\u0149"+
		"\u014d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}