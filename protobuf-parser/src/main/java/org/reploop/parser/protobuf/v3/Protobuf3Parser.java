// Generated from org/reploop/parser/protobuf/v3/Protobuf3.g4 by ANTLR 4.9.3
package org.reploop.parser.protobuf.v3;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Protobuf3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SYNTAX=1, IMPORT=2, WEAK=3, PUBLIC=4, PACKAGE=5, OPTION=6, REPEATED=7, 
		ONEOF=8, MAP=9, INT32=10, INT64=11, UINT32=12, UINT64=13, SINT32=14, SINT64=15, 
		FIXED32=16, FIXED64=17, SFIXED32=18, SFIXED64=19, BOOL=20, STRING=21, 
		DOUBLE=22, FLOAT=23, BYTES=24, RESERVED=25, TO=26, MAX=27, ENUM=28, MESSAGE=29, 
		SERVICE=30, RPC=31, STREAM=32, RETURNS=33, PROTO3_LIT_SINGLE=34, PROTO3_LIT_DOBULE=35, 
		SEMI=36, EQ=37, LP=38, RP=39, LB=40, RB=41, LC=42, RC=43, LT=44, GT=45, 
		DOT=46, COMMA=47, COLON=48, PLUS=49, MINUS=50, STR_LIT=51, BOOL_LIT=52, 
		FLOAT_LIT=53, INT_LIT=54, IDENTIFIER=55, WS=56, LINE_COMMENT=57, COMMENT=58;
	public static final int
		RULE_proto = 0, RULE_syntax = 1, RULE_importStatement = 2, RULE_packageStatement = 3, 
		RULE_optionStatement = 4, RULE_optionName = 5, RULE_field = 6, RULE_fieldOptions = 7, 
		RULE_fieldOption = 8, RULE_fieldNumber = 9, RULE_oneof = 10, RULE_oneofField = 11, 
		RULE_mapField = 12, RULE_keyType = 13, RULE_type_ = 14, RULE_reserved = 15, 
		RULE_ranges = 16, RULE_range_ = 17, RULE_reservedFieldNames = 18, RULE_topLevelDef = 19, 
		RULE_enumDef = 20, RULE_enumBody = 21, RULE_enumElement = 22, RULE_enumField = 23, 
		RULE_enumValueOptions = 24, RULE_enumValueOption = 25, RULE_messageDef = 26, 
		RULE_messageBody = 27, RULE_messageElement = 28, RULE_serviceDef = 29, 
		RULE_serviceElement = 30, RULE_rpc = 31, RULE_constant = 32, RULE_blockLit = 33, 
		RULE_emptyStatement = 34, RULE_ident = 35, RULE_fullIdent = 36, RULE_messageName = 37, 
		RULE_enumName = 38, RULE_fieldName = 39, RULE_oneofName = 40, RULE_mapName = 41, 
		RULE_serviceName = 42, RULE_rpcName = 43, RULE_messageType = 44, RULE_enumType = 45, 
		RULE_intLit = 46, RULE_strLit = 47, RULE_boolLit = 48, RULE_floatLit = 49, 
		RULE_keywords = 50;
	private static String[] makeRuleNames() {
		return new String[] {
			"proto", "syntax", "importStatement", "packageStatement", "optionStatement", 
			"optionName", "field", "fieldOptions", "fieldOption", "fieldNumber", 
			"oneof", "oneofField", "mapField", "keyType", "type_", "reserved", "ranges", 
			"range_", "reservedFieldNames", "topLevelDef", "enumDef", "enumBody", 
			"enumElement", "enumField", "enumValueOptions", "enumValueOption", "messageDef", 
			"messageBody", "messageElement", "serviceDef", "serviceElement", "rpc", 
			"constant", "blockLit", "emptyStatement", "ident", "fullIdent", "messageName", 
			"enumName", "fieldName", "oneofName", "mapName", "serviceName", "rpcName", 
			"messageType", "enumType", "intLit", "strLit", "boolLit", "floatLit", 
			"keywords"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'syntax'", "'import'", "'weak'", "'public'", "'package'", "'option'", 
			"'repeated'", "'oneof'", "'map'", "'int32'", "'int64'", "'uint32'", "'uint64'", 
			"'sint32'", "'sint64'", "'fixed32'", "'fixed64'", "'sfixed32'", "'sfixed64'", 
			"'bool'", "'string'", "'double'", "'float'", "'bytes'", "'reserved'", 
			"'to'", "'max'", "'enum'", "'message'", "'service'", "'rpc'", "'stream'", 
			"'returns'", "'\"proto3\"'", "''proto3''", "';'", "'='", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", "'<'", "'>'", "'.'", "','", "':'", "'+'", 
			"'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SYNTAX", "IMPORT", "WEAK", "PUBLIC", "PACKAGE", "OPTION", "REPEATED", 
			"ONEOF", "MAP", "INT32", "INT64", "UINT32", "UINT64", "SINT32", "SINT64", 
			"FIXED32", "FIXED64", "SFIXED32", "SFIXED64", "BOOL", "STRING", "DOUBLE", 
			"FLOAT", "BYTES", "RESERVED", "TO", "MAX", "ENUM", "MESSAGE", "SERVICE", 
			"RPC", "STREAM", "RETURNS", "PROTO3_LIT_SINGLE", "PROTO3_LIT_DOBULE", 
			"SEMI", "EQ", "LP", "RP", "LB", "RB", "LC", "RC", "LT", "GT", "DOT", 
			"COMMA", "COLON", "PLUS", "MINUS", "STR_LIT", "BOOL_LIT", "FLOAT_LIT", 
			"INT_LIT", "IDENTIFIER", "WS", "LINE_COMMENT", "COMMENT"
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
	public String getGrammarFileName() { return "Protobuf3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Protobuf3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProtoContext extends ParserRuleContext {
		public SyntaxContext syntax() {
			return getRuleContext(SyntaxContext.class,0);
		}
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<PackageStatementContext> packageStatement() {
			return getRuleContexts(PackageStatementContext.class);
		}
		public PackageStatementContext packageStatement(int i) {
			return getRuleContext(PackageStatementContext.class,i);
		}
		public List<OptionStatementContext> optionStatement() {
			return getRuleContexts(OptionStatementContext.class);
		}
		public OptionStatementContext optionStatement(int i) {
			return getRuleContext(OptionStatementContext.class,i);
		}
		public List<TopLevelDefContext> topLevelDef() {
			return getRuleContexts(TopLevelDefContext.class);
		}
		public TopLevelDefContext topLevelDef(int i) {
			return getRuleContext(TopLevelDefContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public ProtoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterProto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitProto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitProto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProtoContext proto() throws RecognitionException {
		ProtoContext _localctx = new ProtoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_proto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			syntax();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << PACKAGE) | (1L << OPTION) | (1L << ENUM) | (1L << MESSAGE) | (1L << SERVICE) | (1L << SEMI))) != 0)) {
				{
				setState(108);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IMPORT:
					{
					setState(103);
					importStatement();
					}
					break;
				case PACKAGE:
					{
					setState(104);
					packageStatement();
					}
					break;
				case OPTION:
					{
					setState(105);
					optionStatement();
					}
					break;
				case ENUM:
				case MESSAGE:
				case SERVICE:
					{
					setState(106);
					topLevelDef();
					}
					break;
				case SEMI:
					{
					setState(107);
					emptyStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(112);
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

	public static class SyntaxContext extends ParserRuleContext {
		public TerminalNode SYNTAX() { return getToken(Protobuf3Parser.SYNTAX, 0); }
		public TerminalNode EQ() { return getToken(Protobuf3Parser.EQ, 0); }
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public TerminalNode PROTO3_LIT_SINGLE() { return getToken(Protobuf3Parser.PROTO3_LIT_SINGLE, 0); }
		public TerminalNode PROTO3_LIT_DOBULE() { return getToken(Protobuf3Parser.PROTO3_LIT_DOBULE, 0); }
		public SyntaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterSyntax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitSyntax(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitSyntax(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SyntaxContext syntax() throws RecognitionException {
		SyntaxContext _localctx = new SyntaxContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_syntax);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(SYNTAX);
			setState(114);
			match(EQ);
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==PROTO3_LIT_SINGLE || _la==PROTO3_LIT_DOBULE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(116);
			match(SEMI);
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

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Protobuf3Parser.IMPORT, 0); }
		public StrLitContext strLit() {
			return getRuleContext(StrLitContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public TerminalNode WEAK() { return getToken(Protobuf3Parser.WEAK, 0); }
		public TerminalNode PUBLIC() { return getToken(Protobuf3Parser.PUBLIC, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(IMPORT);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WEAK || _la==PUBLIC) {
				{
				setState(119);
				_la = _input.LA(1);
				if ( !(_la==WEAK || _la==PUBLIC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(122);
			strLit();
			setState(123);
			match(SEMI);
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

	public static class PackageStatementContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(Protobuf3Parser.PACKAGE, 0); }
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public PackageStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterPackageStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitPackageStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitPackageStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageStatementContext packageStatement() throws RecognitionException {
		PackageStatementContext _localctx = new PackageStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_packageStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(PACKAGE);
			setState(126);
			fullIdent();
			setState(127);
			match(SEMI);
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

	public static class OptionStatementContext extends ParserRuleContext {
		public TerminalNode OPTION() { return getToken(Protobuf3Parser.OPTION, 0); }
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Protobuf3Parser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public OptionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOptionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOptionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitOptionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionStatementContext optionStatement() throws RecognitionException {
		OptionStatementContext _localctx = new OptionStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_optionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(OPTION);
			setState(130);
			optionName();
			setState(131);
			match(EQ);
			setState(132);
			constant();
			setState(133);
			match(SEMI);
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

	public static class OptionNameContext extends ParserRuleContext {
		public List<FullIdentContext> fullIdent() {
			return getRuleContexts(FullIdentContext.class);
		}
		public FullIdentContext fullIdent(int i) {
			return getRuleContext(FullIdentContext.class,i);
		}
		public TerminalNode LP() { return getToken(Protobuf3Parser.LP, 0); }
		public TerminalNode RP() { return getToken(Protobuf3Parser.RP, 0); }
		public TerminalNode DOT() { return getToken(Protobuf3Parser.DOT, 0); }
		public OptionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOptionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOptionName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitOptionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OptionNameContext optionName() throws RecognitionException {
		OptionNameContext _localctx = new OptionNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_optionName);
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SYNTAX:
			case IMPORT:
			case WEAK:
			case PUBLIC:
			case PACKAGE:
			case OPTION:
			case REPEATED:
			case ONEOF:
			case MAP:
			case INT32:
			case INT64:
			case UINT32:
			case UINT64:
			case SINT32:
			case SINT64:
			case FIXED32:
			case FIXED64:
			case SFIXED32:
			case SFIXED64:
			case BOOL:
			case STRING:
			case DOUBLE:
			case FLOAT:
			case BYTES:
			case RESERVED:
			case TO:
			case MAX:
			case ENUM:
			case MESSAGE:
			case SERVICE:
			case RPC:
			case STREAM:
			case RETURNS:
			case BOOL_LIT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				fullIdent();
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(LP);
				setState(137);
				fullIdent();
				setState(138);
				match(RP);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(139);
					match(DOT);
					setState(140);
					fullIdent();
					}
				}

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

	public static class FieldContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Protobuf3Parser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public TerminalNode REPEATED() { return getToken(Protobuf3Parser.REPEATED, 0); }
		public TerminalNode LB() { return getToken(Protobuf3Parser.LB, 0); }
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public TerminalNode RB() { return getToken(Protobuf3Parser.RB, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(145);
				match(REPEATED);
				}
				break;
			}
			setState(148);
			type_();
			setState(149);
			fieldName();
			setState(150);
			match(EQ);
			setState(151);
			fieldNumber();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(152);
				match(LB);
				setState(153);
				fieldOptions();
				setState(154);
				match(RB);
				}
			}

			setState(158);
			match(SEMI);
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

	public static class FieldOptionsContext extends ParserRuleContext {
		public List<FieldOptionContext> fieldOption() {
			return getRuleContexts(FieldOptionContext.class);
		}
		public FieldOptionContext fieldOption(int i) {
			return getRuleContext(FieldOptionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Protobuf3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Protobuf3Parser.COMMA, i);
		}
		public FieldOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitFieldOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldOptionsContext fieldOptions() throws RecognitionException {
		FieldOptionsContext _localctx = new FieldOptionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			fieldOption();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(161);
				match(COMMA);
				setState(162);
				fieldOption();
				}
				}
				setState(167);
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

	public static class FieldOptionContext extends ParserRuleContext {
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Protobuf3Parser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FieldOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitFieldOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldOptionContext fieldOption() throws RecognitionException {
		FieldOptionContext _localctx = new FieldOptionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			optionName();
			setState(169);
			match(EQ);
			setState(170);
			constant();
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

	public static class FieldNumberContext extends ParserRuleContext {
		public IntLitContext intLit() {
			return getRuleContext(IntLitContext.class,0);
		}
		public FieldNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitFieldNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNumberContext fieldNumber() throws RecognitionException {
		FieldNumberContext _localctx = new FieldNumberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fieldNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			intLit();
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

	public static class OneofContext extends ParserRuleContext {
		public TerminalNode ONEOF() { return getToken(Protobuf3Parser.ONEOF, 0); }
		public OneofNameContext oneofName() {
			return getRuleContext(OneofNameContext.class,0);
		}
		public TerminalNode LC() { return getToken(Protobuf3Parser.LC, 0); }
		public TerminalNode RC() { return getToken(Protobuf3Parser.RC, 0); }
		public List<OptionStatementContext> optionStatement() {
			return getRuleContexts(OptionStatementContext.class);
		}
		public OptionStatementContext optionStatement(int i) {
			return getRuleContext(OptionStatementContext.class,i);
		}
		public List<OneofFieldContext> oneofField() {
			return getRuleContexts(OneofFieldContext.class);
		}
		public OneofFieldContext oneofField(int i) {
			return getRuleContext(OneofFieldContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public OneofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneof; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOneof(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOneof(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitOneof(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneofContext oneof() throws RecognitionException {
		OneofContext _localctx = new OneofContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_oneof);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(ONEOF);
			setState(175);
			oneofName();
			setState(176);
			match(LC);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYNTAX) | (1L << IMPORT) | (1L << WEAK) | (1L << PUBLIC) | (1L << PACKAGE) | (1L << OPTION) | (1L << REPEATED) | (1L << ONEOF) | (1L << MAP) | (1L << INT32) | (1L << INT64) | (1L << UINT32) | (1L << UINT64) | (1L << SINT32) | (1L << SINT64) | (1L << FIXED32) | (1L << FIXED64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << BOOL) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << BYTES) | (1L << RESERVED) | (1L << TO) | (1L << MAX) | (1L << ENUM) | (1L << MESSAGE) | (1L << SERVICE) | (1L << RPC) | (1L << STREAM) | (1L << RETURNS) | (1L << SEMI) | (1L << DOT) | (1L << BOOL_LIT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(177);
					optionStatement();
					}
					break;
				case 2:
					{
					setState(178);
					oneofField();
					}
					break;
				case 3:
					{
					setState(179);
					emptyStatement();
					}
					break;
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(RC);
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

	public static class OneofFieldContext extends ParserRuleContext {
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Protobuf3Parser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public TerminalNode LB() { return getToken(Protobuf3Parser.LB, 0); }
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public TerminalNode RB() { return getToken(Protobuf3Parser.RB, 0); }
		public OneofFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneofField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOneofField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOneofField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitOneofField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneofFieldContext oneofField() throws RecognitionException {
		OneofFieldContext _localctx = new OneofFieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_oneofField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			type_();
			setState(188);
			fieldName();
			setState(189);
			match(EQ);
			setState(190);
			fieldNumber();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(191);
				match(LB);
				setState(192);
				fieldOptions();
				setState(193);
				match(RB);
				}
			}

			setState(197);
			match(SEMI);
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

	public static class MapFieldContext extends ParserRuleContext {
		public TerminalNode MAP() { return getToken(Protobuf3Parser.MAP, 0); }
		public TerminalNode LT() { return getToken(Protobuf3Parser.LT, 0); }
		public KeyTypeContext keyType() {
			return getRuleContext(KeyTypeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Protobuf3Parser.COMMA, 0); }
		public Type_Context type_() {
			return getRuleContext(Type_Context.class,0);
		}
		public TerminalNode GT() { return getToken(Protobuf3Parser.GT, 0); }
		public MapNameContext mapName() {
			return getRuleContext(MapNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Protobuf3Parser.EQ, 0); }
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public TerminalNode LB() { return getToken(Protobuf3Parser.LB, 0); }
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public TerminalNode RB() { return getToken(Protobuf3Parser.RB, 0); }
		public MapFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMapField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMapField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitMapField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapFieldContext mapField() throws RecognitionException {
		MapFieldContext _localctx = new MapFieldContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mapField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(MAP);
			setState(200);
			match(LT);
			setState(201);
			keyType();
			setState(202);
			match(COMMA);
			setState(203);
			type_();
			setState(204);
			match(GT);
			setState(205);
			mapName();
			setState(206);
			match(EQ);
			setState(207);
			fieldNumber();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(208);
				match(LB);
				setState(209);
				fieldOptions();
				setState(210);
				match(RB);
				}
			}

			setState(214);
			match(SEMI);
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

	public static class KeyTypeContext extends ParserRuleContext {
		public TerminalNode INT32() { return getToken(Protobuf3Parser.INT32, 0); }
		public TerminalNode INT64() { return getToken(Protobuf3Parser.INT64, 0); }
		public TerminalNode UINT32() { return getToken(Protobuf3Parser.UINT32, 0); }
		public TerminalNode UINT64() { return getToken(Protobuf3Parser.UINT64, 0); }
		public TerminalNode SINT32() { return getToken(Protobuf3Parser.SINT32, 0); }
		public TerminalNode SINT64() { return getToken(Protobuf3Parser.SINT64, 0); }
		public TerminalNode FIXED32() { return getToken(Protobuf3Parser.FIXED32, 0); }
		public TerminalNode FIXED64() { return getToken(Protobuf3Parser.FIXED64, 0); }
		public TerminalNode SFIXED32() { return getToken(Protobuf3Parser.SFIXED32, 0); }
		public TerminalNode SFIXED64() { return getToken(Protobuf3Parser.SFIXED64, 0); }
		public TerminalNode BOOL() { return getToken(Protobuf3Parser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(Protobuf3Parser.STRING, 0); }
		public KeyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterKeyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitKeyType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitKeyType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyTypeContext keyType() throws RecognitionException {
		KeyTypeContext _localctx = new KeyTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_keyType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT32) | (1L << INT64) | (1L << UINT32) | (1L << UINT64) | (1L << SINT32) | (1L << SINT64) | (1L << FIXED32) | (1L << FIXED64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << BOOL) | (1L << STRING))) != 0)) ) {
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

	public static class Type_Context extends ParserRuleContext {
		public TerminalNode DOUBLE() { return getToken(Protobuf3Parser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(Protobuf3Parser.FLOAT, 0); }
		public TerminalNode INT32() { return getToken(Protobuf3Parser.INT32, 0); }
		public TerminalNode INT64() { return getToken(Protobuf3Parser.INT64, 0); }
		public TerminalNode UINT32() { return getToken(Protobuf3Parser.UINT32, 0); }
		public TerminalNode UINT64() { return getToken(Protobuf3Parser.UINT64, 0); }
		public TerminalNode SINT32() { return getToken(Protobuf3Parser.SINT32, 0); }
		public TerminalNode SINT64() { return getToken(Protobuf3Parser.SINT64, 0); }
		public TerminalNode FIXED32() { return getToken(Protobuf3Parser.FIXED32, 0); }
		public TerminalNode FIXED64() { return getToken(Protobuf3Parser.FIXED64, 0); }
		public TerminalNode SFIXED32() { return getToken(Protobuf3Parser.SFIXED32, 0); }
		public TerminalNode SFIXED64() { return getToken(Protobuf3Parser.SFIXED64, 0); }
		public TerminalNode BOOL() { return getToken(Protobuf3Parser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(Protobuf3Parser.STRING, 0); }
		public TerminalNode BYTES() { return getToken(Protobuf3Parser.BYTES, 0); }
		public MessageTypeContext messageType() {
			return getRuleContext(MessageTypeContext.class,0);
		}
		public EnumTypeContext enumType() {
			return getRuleContext(EnumTypeContext.class,0);
		}
		public Type_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterType_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitType_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitType_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_Context type_() throws RecognitionException {
		Type_Context _localctx = new Type_Context(_ctx, getState());
		enterRule(_localctx, 28, RULE_type_);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(DOUBLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(FLOAT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				match(INT32);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				match(INT64);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				match(UINT32);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
				match(UINT64);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(224);
				match(SINT32);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(225);
				match(SINT64);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(226);
				match(FIXED32);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(227);
				match(FIXED64);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(228);
				match(SFIXED32);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(229);
				match(SFIXED64);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(230);
				match(BOOL);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(231);
				match(STRING);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(232);
				match(BYTES);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(233);
				messageType();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(234);
				enumType();
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

	public static class ReservedContext extends ParserRuleContext {
		public TerminalNode RESERVED() { return getToken(Protobuf3Parser.RESERVED, 0); }
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public RangesContext ranges() {
			return getRuleContext(RangesContext.class,0);
		}
		public ReservedFieldNamesContext reservedFieldNames() {
			return getRuleContext(ReservedFieldNamesContext.class,0);
		}
		public ReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitReserved(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitReserved(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReservedContext reserved() throws RecognitionException {
		ReservedContext _localctx = new ReservedContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_reserved);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(RESERVED);
			setState(240);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_LIT:
				{
				setState(238);
				ranges();
				}
				break;
			case PROTO3_LIT_SINGLE:
			case PROTO3_LIT_DOBULE:
			case STR_LIT:
				{
				setState(239);
				reservedFieldNames();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(242);
			match(SEMI);
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

	public static class RangesContext extends ParserRuleContext {
		public List<Range_Context> range_() {
			return getRuleContexts(Range_Context.class);
		}
		public Range_Context range_(int i) {
			return getRuleContext(Range_Context.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Protobuf3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Protobuf3Parser.COMMA, i);
		}
		public RangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ranges; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterRanges(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitRanges(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangesContext ranges() throws RecognitionException {
		RangesContext _localctx = new RangesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ranges);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			range_();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(245);
				match(COMMA);
				setState(246);
				range_();
				}
				}
				setState(251);
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

	public static class Range_Context extends ParserRuleContext {
		public List<IntLitContext> intLit() {
			return getRuleContexts(IntLitContext.class);
		}
		public IntLitContext intLit(int i) {
			return getRuleContext(IntLitContext.class,i);
		}
		public TerminalNode TO() { return getToken(Protobuf3Parser.TO, 0); }
		public TerminalNode MAX() { return getToken(Protobuf3Parser.MAX, 0); }
		public Range_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterRange_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitRange_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitRange_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Range_Context range_() throws RecognitionException {
		Range_Context _localctx = new Range_Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_range_);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			intLit();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(253);
				match(TO);
				setState(256);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT_LIT:
					{
					setState(254);
					intLit();
					}
					break;
				case MAX:
					{
					setState(255);
					match(MAX);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	public static class ReservedFieldNamesContext extends ParserRuleContext {
		public List<StrLitContext> strLit() {
			return getRuleContexts(StrLitContext.class);
		}
		public StrLitContext strLit(int i) {
			return getRuleContext(StrLitContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Protobuf3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Protobuf3Parser.COMMA, i);
		}
		public ReservedFieldNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reservedFieldNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterReservedFieldNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitReservedFieldNames(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitReservedFieldNames(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReservedFieldNamesContext reservedFieldNames() throws RecognitionException {
		ReservedFieldNamesContext _localctx = new ReservedFieldNamesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_reservedFieldNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			strLit();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(261);
				match(COMMA);
				setState(262);
				strLit();
				}
				}
				setState(267);
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

	public static class TopLevelDefContext extends ParserRuleContext {
		public MessageDefContext messageDef() {
			return getRuleContext(MessageDefContext.class,0);
		}
		public EnumDefContext enumDef() {
			return getRuleContext(EnumDefContext.class,0);
		}
		public ServiceDefContext serviceDef() {
			return getRuleContext(ServiceDefContext.class,0);
		}
		public TopLevelDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterTopLevelDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitTopLevelDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitTopLevelDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelDefContext topLevelDef() throws RecognitionException {
		TopLevelDefContext _localctx = new TopLevelDefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_topLevelDef);
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MESSAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				messageDef();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				enumDef();
				}
				break;
			case SERVICE:
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				serviceDef();
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

	public static class EnumDefContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(Protobuf3Parser.ENUM, 0); }
		public EnumNameContext enumName() {
			return getRuleContext(EnumNameContext.class,0);
		}
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public EnumDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEnumDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDefContext enumDef() throws RecognitionException {
		EnumDefContext _localctx = new EnumDefContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_enumDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(ENUM);
			setState(274);
			enumName();
			setState(275);
			enumBody();
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

	public static class EnumBodyContext extends ParserRuleContext {
		public TerminalNode LC() { return getToken(Protobuf3Parser.LC, 0); }
		public TerminalNode RC() { return getToken(Protobuf3Parser.RC, 0); }
		public List<EnumElementContext> enumElement() {
			return getRuleContexts(EnumElementContext.class);
		}
		public EnumElementContext enumElement(int i) {
			return getRuleContext(EnumElementContext.class,i);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEnumBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(LC);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYNTAX) | (1L << IMPORT) | (1L << WEAK) | (1L << PUBLIC) | (1L << PACKAGE) | (1L << OPTION) | (1L << REPEATED) | (1L << ONEOF) | (1L << MAP) | (1L << INT32) | (1L << INT64) | (1L << UINT32) | (1L << UINT64) | (1L << SINT32) | (1L << SINT64) | (1L << FIXED32) | (1L << FIXED64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << BOOL) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << BYTES) | (1L << RESERVED) | (1L << TO) | (1L << MAX) | (1L << ENUM) | (1L << MESSAGE) | (1L << SERVICE) | (1L << RPC) | (1L << STREAM) | (1L << RETURNS) | (1L << SEMI) | (1L << BOOL_LIT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(278);
				enumElement();
				}
				}
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(284);
			match(RC);
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

	public static class EnumElementContext extends ParserRuleContext {
		public OptionStatementContext optionStatement() {
			return getRuleContext(OptionStatementContext.class,0);
		}
		public EnumFieldContext enumField() {
			return getRuleContext(EnumFieldContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public EnumElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEnumElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumElementContext enumElement() throws RecognitionException {
		EnumElementContext _localctx = new EnumElementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_enumElement);
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				optionStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				enumField();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				emptyStatement();
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

	public static class EnumFieldContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Protobuf3Parser.EQ, 0); }
		public IntLitContext intLit() {
			return getRuleContext(IntLitContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public TerminalNode MINUS() { return getToken(Protobuf3Parser.MINUS, 0); }
		public EnumValueOptionsContext enumValueOptions() {
			return getRuleContext(EnumValueOptionsContext.class,0);
		}
		public EnumFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEnumField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumFieldContext enumField() throws RecognitionException {
		EnumFieldContext _localctx = new EnumFieldContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_enumField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			ident();
			setState(292);
			match(EQ);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(293);
				match(MINUS);
				}
			}

			setState(296);
			intLit();
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LB) {
				{
				setState(297);
				enumValueOptions();
				}
			}

			setState(300);
			match(SEMI);
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

	public static class EnumValueOptionsContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(Protobuf3Parser.LB, 0); }
		public List<EnumValueOptionContext> enumValueOption() {
			return getRuleContexts(EnumValueOptionContext.class);
		}
		public EnumValueOptionContext enumValueOption(int i) {
			return getRuleContext(EnumValueOptionContext.class,i);
		}
		public TerminalNode RB() { return getToken(Protobuf3Parser.RB, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Protobuf3Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Protobuf3Parser.COMMA, i);
		}
		public EnumValueOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumValueOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumValueOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumValueOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEnumValueOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumValueOptionsContext enumValueOptions() throws RecognitionException {
		EnumValueOptionsContext _localctx = new EnumValueOptionsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_enumValueOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(LB);
			setState(303);
			enumValueOption();
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(304);
				match(COMMA);
				setState(305);
				enumValueOption();
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(311);
			match(RB);
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

	public static class EnumValueOptionContext extends ParserRuleContext {
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(Protobuf3Parser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public EnumValueOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumValueOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumValueOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumValueOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEnumValueOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumValueOptionContext enumValueOption() throws RecognitionException {
		EnumValueOptionContext _localctx = new EnumValueOptionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_enumValueOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			optionName();
			setState(314);
			match(EQ);
			setState(315);
			constant();
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

	public static class MessageDefContext extends ParserRuleContext {
		public TerminalNode MESSAGE() { return getToken(Protobuf3Parser.MESSAGE, 0); }
		public MessageNameContext messageName() {
			return getRuleContext(MessageNameContext.class,0);
		}
		public MessageBodyContext messageBody() {
			return getRuleContext(MessageBodyContext.class,0);
		}
		public MessageDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitMessageDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageDefContext messageDef() throws RecognitionException {
		MessageDefContext _localctx = new MessageDefContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_messageDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(MESSAGE);
			setState(318);
			messageName();
			setState(319);
			messageBody();
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

	public static class MessageBodyContext extends ParserRuleContext {
		public TerminalNode LC() { return getToken(Protobuf3Parser.LC, 0); }
		public TerminalNode RC() { return getToken(Protobuf3Parser.RC, 0); }
		public List<MessageElementContext> messageElement() {
			return getRuleContexts(MessageElementContext.class);
		}
		public MessageElementContext messageElement(int i) {
			return getRuleContext(MessageElementContext.class,i);
		}
		public MessageBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitMessageBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageBodyContext messageBody() throws RecognitionException {
		MessageBodyContext _localctx = new MessageBodyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_messageBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(LC);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYNTAX) | (1L << IMPORT) | (1L << WEAK) | (1L << PUBLIC) | (1L << PACKAGE) | (1L << OPTION) | (1L << REPEATED) | (1L << ONEOF) | (1L << MAP) | (1L << INT32) | (1L << INT64) | (1L << UINT32) | (1L << UINT64) | (1L << SINT32) | (1L << SINT64) | (1L << FIXED32) | (1L << FIXED64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << BOOL) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << BYTES) | (1L << RESERVED) | (1L << TO) | (1L << MAX) | (1L << ENUM) | (1L << MESSAGE) | (1L << SERVICE) | (1L << RPC) | (1L << STREAM) | (1L << RETURNS) | (1L << SEMI) | (1L << DOT) | (1L << BOOL_LIT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(322);
				messageElement();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
			match(RC);
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

	public static class MessageElementContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public EnumDefContext enumDef() {
			return getRuleContext(EnumDefContext.class,0);
		}
		public MessageDefContext messageDef() {
			return getRuleContext(MessageDefContext.class,0);
		}
		public OptionStatementContext optionStatement() {
			return getRuleContext(OptionStatementContext.class,0);
		}
		public OneofContext oneof() {
			return getRuleContext(OneofContext.class,0);
		}
		public MapFieldContext mapField() {
			return getRuleContext(MapFieldContext.class,0);
		}
		public ReservedContext reserved() {
			return getRuleContext(ReservedContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public MessageElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitMessageElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageElementContext messageElement() throws RecognitionException {
		MessageElementContext _localctx = new MessageElementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_messageElement);
		try {
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				field();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				enumDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(332);
				messageDef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(333);
				optionStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(334);
				oneof();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(335);
				mapField();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(336);
				reserved();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(337);
				emptyStatement();
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

	public static class ServiceDefContext extends ParserRuleContext {
		public TerminalNode SERVICE() { return getToken(Protobuf3Parser.SERVICE, 0); }
		public ServiceNameContext serviceName() {
			return getRuleContext(ServiceNameContext.class,0);
		}
		public TerminalNode LC() { return getToken(Protobuf3Parser.LC, 0); }
		public TerminalNode RC() { return getToken(Protobuf3Parser.RC, 0); }
		public List<ServiceElementContext> serviceElement() {
			return getRuleContexts(ServiceElementContext.class);
		}
		public ServiceElementContext serviceElement(int i) {
			return getRuleContext(ServiceElementContext.class,i);
		}
		public ServiceDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterServiceDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitServiceDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitServiceDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceDefContext serviceDef() throws RecognitionException {
		ServiceDefContext _localctx = new ServiceDefContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_serviceDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(SERVICE);
			setState(341);
			serviceName();
			setState(342);
			match(LC);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPTION) | (1L << RPC) | (1L << SEMI))) != 0)) {
				{
				{
				setState(343);
				serviceElement();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(349);
			match(RC);
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

	public static class ServiceElementContext extends ParserRuleContext {
		public OptionStatementContext optionStatement() {
			return getRuleContext(OptionStatementContext.class,0);
		}
		public RpcContext rpc() {
			return getRuleContext(RpcContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ServiceElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterServiceElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitServiceElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitServiceElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceElementContext serviceElement() throws RecognitionException {
		ServiceElementContext _localctx = new ServiceElementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_serviceElement);
		try {
			setState(354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				optionStatement();
				}
				break;
			case RPC:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				rpc();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
				emptyStatement();
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

	public static class RpcContext extends ParserRuleContext {
		public TerminalNode RPC() { return getToken(Protobuf3Parser.RPC, 0); }
		public RpcNameContext rpcName() {
			return getRuleContext(RpcNameContext.class,0);
		}
		public List<TerminalNode> LP() { return getTokens(Protobuf3Parser.LP); }
		public TerminalNode LP(int i) {
			return getToken(Protobuf3Parser.LP, i);
		}
		public List<MessageTypeContext> messageType() {
			return getRuleContexts(MessageTypeContext.class);
		}
		public MessageTypeContext messageType(int i) {
			return getRuleContext(MessageTypeContext.class,i);
		}
		public List<TerminalNode> RP() { return getTokens(Protobuf3Parser.RP); }
		public TerminalNode RP(int i) {
			return getToken(Protobuf3Parser.RP, i);
		}
		public TerminalNode RETURNS() { return getToken(Protobuf3Parser.RETURNS, 0); }
		public TerminalNode LC() { return getToken(Protobuf3Parser.LC, 0); }
		public TerminalNode RC() { return getToken(Protobuf3Parser.RC, 0); }
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public List<TerminalNode> STREAM() { return getTokens(Protobuf3Parser.STREAM); }
		public TerminalNode STREAM(int i) {
			return getToken(Protobuf3Parser.STREAM, i);
		}
		public List<OptionStatementContext> optionStatement() {
			return getRuleContexts(OptionStatementContext.class);
		}
		public OptionStatementContext optionStatement(int i) {
			return getRuleContext(OptionStatementContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public RpcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterRpc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitRpc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitRpc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpcContext rpc() throws RecognitionException {
		RpcContext _localctx = new RpcContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_rpc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(RPC);
			setState(357);
			rpcName();
			setState(358);
			match(LP);
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(359);
				match(STREAM);
				}
				break;
			}
			setState(362);
			messageType();
			setState(363);
			match(RP);
			setState(364);
			match(RETURNS);
			setState(365);
			match(LP);
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(366);
				match(STREAM);
				}
				break;
			}
			setState(369);
			messageType();
			setState(370);
			match(RP);
			setState(381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LC:
				{
				setState(371);
				match(LC);
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPTION || _la==SEMI) {
					{
					setState(374);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case OPTION:
						{
						setState(372);
						optionStatement();
						}
						break;
					case SEMI:
						{
						setState(373);
						emptyStatement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(378);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(379);
				match(RC);
				}
				break;
			case SEMI:
				{
				setState(380);
				match(SEMI);
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

	public static class ConstantContext extends ParserRuleContext {
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public IntLitContext intLit() {
			return getRuleContext(IntLitContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(Protobuf3Parser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(Protobuf3Parser.PLUS, 0); }
		public FloatLitContext floatLit() {
			return getRuleContext(FloatLitContext.class,0);
		}
		public StrLitContext strLit() {
			return getRuleContext(StrLitContext.class,0);
		}
		public BoolLitContext boolLit() {
			return getRuleContext(BoolLitContext.class,0);
		}
		public BlockLitContext blockLit() {
			return getRuleContext(BlockLitContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_constant);
		int _la;
		try {
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				fullIdent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(384);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(387);
				intLit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(388);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(391);
				floatLit();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(392);
				strLit();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(393);
				boolLit();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(394);
				blockLit();
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

	public static class BlockLitContext extends ParserRuleContext {
		public TerminalNode LC() { return getToken(Protobuf3Parser.LC, 0); }
		public TerminalNode RC() { return getToken(Protobuf3Parser.RC, 0); }
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(Protobuf3Parser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(Protobuf3Parser.COLON, i);
		}
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public BlockLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterBlockLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitBlockLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitBlockLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockLitContext blockLit() throws RecognitionException {
		BlockLitContext _localctx = new BlockLitContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_blockLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(LC);
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYNTAX) | (1L << IMPORT) | (1L << WEAK) | (1L << PUBLIC) | (1L << PACKAGE) | (1L << OPTION) | (1L << REPEATED) | (1L << ONEOF) | (1L << MAP) | (1L << INT32) | (1L << INT64) | (1L << UINT32) | (1L << UINT64) | (1L << SINT32) | (1L << SINT64) | (1L << FIXED32) | (1L << FIXED64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << BOOL) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << BYTES) | (1L << RESERVED) | (1L << TO) | (1L << MAX) | (1L << ENUM) | (1L << MESSAGE) | (1L << SERVICE) | (1L << RPC) | (1L << STREAM) | (1L << RETURNS) | (1L << BOOL_LIT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(398);
				ident();
				setState(399);
				match(COLON);
				setState(400);
				constant();
				}
				}
				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(407);
			match(RC);
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

	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(Protobuf3Parser.SEMI, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(SEMI);
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

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(Protobuf3Parser.IDENTIFIER, 0); }
		public KeywordsContext keywords() {
			return getRuleContext(KeywordsContext.class,0);
		}
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ident);
		try {
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(IDENTIFIER);
				}
				break;
			case SYNTAX:
			case IMPORT:
			case WEAK:
			case PUBLIC:
			case PACKAGE:
			case OPTION:
			case REPEATED:
			case ONEOF:
			case MAP:
			case INT32:
			case INT64:
			case UINT32:
			case UINT64:
			case SINT32:
			case SINT64:
			case FIXED32:
			case FIXED64:
			case SFIXED32:
			case SFIXED64:
			case BOOL:
			case STRING:
			case DOUBLE:
			case FLOAT:
			case BYTES:
			case RESERVED:
			case TO:
			case MAX:
			case ENUM:
			case MESSAGE:
			case SERVICE:
			case RPC:
			case STREAM:
			case RETURNS:
			case BOOL_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				keywords();
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

	public static class FullIdentContext extends ParserRuleContext {
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(Protobuf3Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Protobuf3Parser.DOT, i);
		}
		public FullIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFullIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFullIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitFullIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FullIdentContext fullIdent() throws RecognitionException {
		FullIdentContext _localctx = new FullIdentContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_fullIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			ident();
			setState(420);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(416);
				match(DOT);
				setState(417);
				ident();
				}
				}
				setState(422);
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

	public static class MessageNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public MessageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitMessageName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageNameContext messageName() throws RecognitionException {
		MessageNameContext _localctx = new MessageNameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_messageName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			ident();
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

	public static class EnumNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public EnumNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEnumName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumNameContext enumName() throws RecognitionException {
		EnumNameContext _localctx = new EnumNameContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_enumName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			ident();
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
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			ident();
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

	public static class OneofNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public OneofNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneofName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOneofName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOneofName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitOneofName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OneofNameContext oneofName() throws RecognitionException {
		OneofNameContext _localctx = new OneofNameContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_oneofName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			ident();
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

	public static class MapNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public MapNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMapName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMapName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitMapName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapNameContext mapName() throws RecognitionException {
		MapNameContext _localctx = new MapNameContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_mapName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			ident();
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

	public static class ServiceNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ServiceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterServiceName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitServiceName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitServiceName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ServiceNameContext serviceName() throws RecognitionException {
		ServiceNameContext _localctx = new ServiceNameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_serviceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			ident();
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

	public static class RpcNameContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public RpcNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterRpcName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitRpcName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitRpcName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpcNameContext rpcName() throws RecognitionException {
		RpcNameContext _localctx = new RpcNameContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_rpcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			ident();
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

	public static class MessageTypeContext extends ParserRuleContext {
		public MessageNameContext messageName() {
			return getRuleContext(MessageNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(Protobuf3Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Protobuf3Parser.DOT, i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public MessageTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitMessageType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageTypeContext messageType() throws RecognitionException {
		MessageTypeContext _localctx = new MessageTypeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_messageType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(437);
				match(DOT);
				}
			}

			setState(445);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(440);
					ident();
					setState(441);
					match(DOT);
					}
					} 
				}
				setState(447);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(448);
			messageName();
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

	public static class EnumTypeContext extends ParserRuleContext {
		public EnumNameContext enumName() {
			return getRuleContext(EnumNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(Protobuf3Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Protobuf3Parser.DOT, i);
		}
		public List<IdentContext> ident() {
			return getRuleContexts(IdentContext.class);
		}
		public IdentContext ident(int i) {
			return getRuleContext(IdentContext.class,i);
		}
		public EnumTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitEnumType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumTypeContext enumType() throws RecognitionException {
		EnumTypeContext _localctx = new EnumTypeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_enumType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(450);
				match(DOT);
				}
			}

			setState(458);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(453);
					ident();
					setState(454);
					match(DOT);
					}
					} 
				}
				setState(460);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			setState(461);
			enumName();
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

	public static class IntLitContext extends ParserRuleContext {
		public TerminalNode INT_LIT() { return getToken(Protobuf3Parser.INT_LIT, 0); }
		public IntLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterIntLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitIntLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitIntLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntLitContext intLit() throws RecognitionException {
		IntLitContext _localctx = new IntLitContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_intLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(INT_LIT);
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

	public static class StrLitContext extends ParserRuleContext {
		public TerminalNode STR_LIT() { return getToken(Protobuf3Parser.STR_LIT, 0); }
		public TerminalNode PROTO3_LIT_SINGLE() { return getToken(Protobuf3Parser.PROTO3_LIT_SINGLE, 0); }
		public TerminalNode PROTO3_LIT_DOBULE() { return getToken(Protobuf3Parser.PROTO3_LIT_DOBULE, 0); }
		public StrLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterStrLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitStrLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitStrLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrLitContext strLit() throws RecognitionException {
		StrLitContext _localctx = new StrLitContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_strLit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PROTO3_LIT_SINGLE) | (1L << PROTO3_LIT_DOBULE) | (1L << STR_LIT))) != 0)) ) {
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

	public static class BoolLitContext extends ParserRuleContext {
		public TerminalNode BOOL_LIT() { return getToken(Protobuf3Parser.BOOL_LIT, 0); }
		public BoolLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterBoolLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitBoolLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitBoolLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLitContext boolLit() throws RecognitionException {
		BoolLitContext _localctx = new BoolLitContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_boolLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(BOOL_LIT);
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

	public static class FloatLitContext extends ParserRuleContext {
		public TerminalNode FLOAT_LIT() { return getToken(Protobuf3Parser.FLOAT_LIT, 0); }
		public FloatLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFloatLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFloatLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitFloatLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FloatLitContext floatLit() throws RecognitionException {
		FloatLitContext _localctx = new FloatLitContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_floatLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(FLOAT_LIT);
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

	public static class KeywordsContext extends ParserRuleContext {
		public TerminalNode SYNTAX() { return getToken(Protobuf3Parser.SYNTAX, 0); }
		public TerminalNode IMPORT() { return getToken(Protobuf3Parser.IMPORT, 0); }
		public TerminalNode WEAK() { return getToken(Protobuf3Parser.WEAK, 0); }
		public TerminalNode PUBLIC() { return getToken(Protobuf3Parser.PUBLIC, 0); }
		public TerminalNode PACKAGE() { return getToken(Protobuf3Parser.PACKAGE, 0); }
		public TerminalNode OPTION() { return getToken(Protobuf3Parser.OPTION, 0); }
		public TerminalNode REPEATED() { return getToken(Protobuf3Parser.REPEATED, 0); }
		public TerminalNode ONEOF() { return getToken(Protobuf3Parser.ONEOF, 0); }
		public TerminalNode MAP() { return getToken(Protobuf3Parser.MAP, 0); }
		public TerminalNode INT32() { return getToken(Protobuf3Parser.INT32, 0); }
		public TerminalNode INT64() { return getToken(Protobuf3Parser.INT64, 0); }
		public TerminalNode UINT32() { return getToken(Protobuf3Parser.UINT32, 0); }
		public TerminalNode UINT64() { return getToken(Protobuf3Parser.UINT64, 0); }
		public TerminalNode SINT32() { return getToken(Protobuf3Parser.SINT32, 0); }
		public TerminalNode SINT64() { return getToken(Protobuf3Parser.SINT64, 0); }
		public TerminalNode FIXED32() { return getToken(Protobuf3Parser.FIXED32, 0); }
		public TerminalNode FIXED64() { return getToken(Protobuf3Parser.FIXED64, 0); }
		public TerminalNode SFIXED32() { return getToken(Protobuf3Parser.SFIXED32, 0); }
		public TerminalNode SFIXED64() { return getToken(Protobuf3Parser.SFIXED64, 0); }
		public TerminalNode BOOL() { return getToken(Protobuf3Parser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(Protobuf3Parser.STRING, 0); }
		public TerminalNode DOUBLE() { return getToken(Protobuf3Parser.DOUBLE, 0); }
		public TerminalNode FLOAT() { return getToken(Protobuf3Parser.FLOAT, 0); }
		public TerminalNode BYTES() { return getToken(Protobuf3Parser.BYTES, 0); }
		public TerminalNode RESERVED() { return getToken(Protobuf3Parser.RESERVED, 0); }
		public TerminalNode TO() { return getToken(Protobuf3Parser.TO, 0); }
		public TerminalNode MAX() { return getToken(Protobuf3Parser.MAX, 0); }
		public TerminalNode ENUM() { return getToken(Protobuf3Parser.ENUM, 0); }
		public TerminalNode MESSAGE() { return getToken(Protobuf3Parser.MESSAGE, 0); }
		public TerminalNode SERVICE() { return getToken(Protobuf3Parser.SERVICE, 0); }
		public TerminalNode RPC() { return getToken(Protobuf3Parser.RPC, 0); }
		public TerminalNode STREAM() { return getToken(Protobuf3Parser.STREAM, 0); }
		public TerminalNode RETURNS() { return getToken(Protobuf3Parser.RETURNS, 0); }
		public TerminalNode BOOL_LIT() { return getToken(Protobuf3Parser.BOOL_LIT, 0); }
		public KeywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterKeywords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitKeywords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Protobuf3Visitor ) return ((Protobuf3Visitor<? extends T>)visitor).visitKeywords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordsContext keywords() throws RecognitionException {
		KeywordsContext _localctx = new KeywordsContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_keywords);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYNTAX) | (1L << IMPORT) | (1L << WEAK) | (1L << PUBLIC) | (1L << PACKAGE) | (1L << OPTION) | (1L << REPEATED) | (1L << ONEOF) | (1L << MAP) | (1L << INT32) | (1L << INT64) | (1L << UINT32) | (1L << UINT64) | (1L << SINT32) | (1L << SINT64) | (1L << FIXED32) | (1L << FIXED64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << BOOL) | (1L << STRING) | (1L << DOUBLE) | (1L << FLOAT) | (1L << BYTES) | (1L << RESERVED) | (1L << TO) | (1L << MAX) | (1L << ENUM) | (1L << MESSAGE) | (1L << SERVICE) | (1L << RPC) | (1L << STREAM) | (1L << RETURNS) | (1L << BOOL_LIT))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3<\u01dc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\2\3\2\3\2\3\2\7\2o\n\2\f\2\16\2r\13\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\5\4{\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0090\n\7\5\7\u0092\n\7\3\b\5\b\u0095\n"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009f\n\b\3\b\3\b\3\t\3\t\3\t\7"+
		"\t\u00a6\n\t\f\t\16\t\u00a9\13\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\7\f\u00b7\n\f\f\f\16\f\u00ba\13\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00c6\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d7\n\16\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00ee\n\20\3\21\3\21\3\21\5\21\u00f3\n\21\3\21\3"+
		"\21\3\22\3\22\3\22\7\22\u00fa\n\22\f\22\16\22\u00fd\13\22\3\23\3\23\3"+
		"\23\3\23\5\23\u0103\n\23\5\23\u0105\n\23\3\24\3\24\3\24\7\24\u010a\n\24"+
		"\f\24\16\24\u010d\13\24\3\25\3\25\3\25\5\25\u0112\n\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\7\27\u011a\n\27\f\27\16\27\u011d\13\27\3\27\3\27\3\30"+
		"\3\30\3\30\5\30\u0124\n\30\3\31\3\31\3\31\5\31\u0129\n\31\3\31\3\31\5"+
		"\31\u012d\n\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u0135\n\32\f\32\16\32"+
		"\u0138\13\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\7\35\u0146\n\35\f\35\16\35\u0149\13\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\5\36\u0155\n\36\3\37\3\37\3\37\3\37\7\37\u015b"+
		"\n\37\f\37\16\37\u015e\13\37\3\37\3\37\3 \3 \3 \5 \u0165\n \3!\3!\3!\3"+
		"!\5!\u016b\n!\3!\3!\3!\3!\3!\5!\u0172\n!\3!\3!\3!\3!\3!\7!\u0179\n!\f"+
		"!\16!\u017c\13!\3!\3!\5!\u0180\n!\3\"\3\"\5\"\u0184\n\"\3\"\3\"\5\"\u0188"+
		"\n\"\3\"\3\"\3\"\3\"\5\"\u018e\n\"\3#\3#\3#\3#\3#\7#\u0195\n#\f#\16#\u0198"+
		"\13#\3#\3#\3$\3$\3%\3%\5%\u01a0\n%\3&\3&\3&\7&\u01a5\n&\f&\16&\u01a8\13"+
		"&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\5.\u01b9\n.\3.\3.\3."+
		"\7.\u01be\n.\f.\16.\u01c1\13.\3.\3.\3/\5/\u01c6\n/\3/\3/\3/\7/\u01cb\n"+
		"/\f/\16/\u01ce\13/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\64\2\2\65\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdf\2\b\3\2$%\3\2\5\6\3\2\f\27\3\2\63\64\4"+
		"\2$%\65\65\4\2\3#\66\66\2\u01f3\2h\3\2\2\2\4s\3\2\2\2\6x\3\2\2\2\b\177"+
		"\3\2\2\2\n\u0083\3\2\2\2\f\u0091\3\2\2\2\16\u0094\3\2\2\2\20\u00a2\3\2"+
		"\2\2\22\u00aa\3\2\2\2\24\u00ae\3\2\2\2\26\u00b0\3\2\2\2\30\u00bd\3\2\2"+
		"\2\32\u00c9\3\2\2\2\34\u00da\3\2\2\2\36\u00ed\3\2\2\2 \u00ef\3\2\2\2\""+
		"\u00f6\3\2\2\2$\u00fe\3\2\2\2&\u0106\3\2\2\2(\u0111\3\2\2\2*\u0113\3\2"+
		"\2\2,\u0117\3\2\2\2.\u0123\3\2\2\2\60\u0125\3\2\2\2\62\u0130\3\2\2\2\64"+
		"\u013b\3\2\2\2\66\u013f\3\2\2\28\u0143\3\2\2\2:\u0154\3\2\2\2<\u0156\3"+
		"\2\2\2>\u0164\3\2\2\2@\u0166\3\2\2\2B\u018d\3\2\2\2D\u018f\3\2\2\2F\u019b"+
		"\3\2\2\2H\u019f\3\2\2\2J\u01a1\3\2\2\2L\u01a9\3\2\2\2N\u01ab\3\2\2\2P"+
		"\u01ad\3\2\2\2R\u01af\3\2\2\2T\u01b1\3\2\2\2V\u01b3\3\2\2\2X\u01b5\3\2"+
		"\2\2Z\u01b8\3\2\2\2\\\u01c5\3\2\2\2^\u01d1\3\2\2\2`\u01d3\3\2\2\2b\u01d5"+
		"\3\2\2\2d\u01d7\3\2\2\2f\u01d9\3\2\2\2hp\5\4\3\2io\5\6\4\2jo\5\b\5\2k"+
		"o\5\n\6\2lo\5(\25\2mo\5F$\2ni\3\2\2\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2nm"+
		"\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\3\3\2\2\2rp\3\2\2\2st\7\3\2\2"+
		"tu\7\'\2\2uv\t\2\2\2vw\7&\2\2w\5\3\2\2\2xz\7\4\2\2y{\t\3\2\2zy\3\2\2\2"+
		"z{\3\2\2\2{|\3\2\2\2|}\5`\61\2}~\7&\2\2~\7\3\2\2\2\177\u0080\7\7\2\2\u0080"+
		"\u0081\5J&\2\u0081\u0082\7&\2\2\u0082\t\3\2\2\2\u0083\u0084\7\b\2\2\u0084"+
		"\u0085\5\f\7\2\u0085\u0086\7\'\2\2\u0086\u0087\5B\"\2\u0087\u0088\7&\2"+
		"\2\u0088\13\3\2\2\2\u0089\u0092\5J&\2\u008a\u008b\7(\2\2\u008b\u008c\5"+
		"J&\2\u008c\u008f\7)\2\2\u008d\u008e\7\60\2\2\u008e\u0090\5J&\2\u008f\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u0089\3\2\2\2\u0091"+
		"\u008a\3\2\2\2\u0092\r\3\2\2\2\u0093\u0095\7\t\2\2\u0094\u0093\3\2\2\2"+
		"\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\5\36\20\2\u0097\u0098"+
		"\5P)\2\u0098\u0099\7\'\2\2\u0099\u009e\5\24\13\2\u009a\u009b\7*\2\2\u009b"+
		"\u009c\5\20\t\2\u009c\u009d\7+\2\2\u009d\u009f\3\2\2\2\u009e\u009a\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7&\2\2\u00a1"+
		"\17\3\2\2\2\u00a2\u00a7\5\22\n\2\u00a3\u00a4\7\61\2\2\u00a4\u00a6\5\22"+
		"\n\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\21\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\5\f\7"+
		"\2\u00ab\u00ac\7\'\2\2\u00ac\u00ad\5B\"\2\u00ad\23\3\2\2\2\u00ae\u00af"+
		"\5^\60\2\u00af\25\3\2\2\2\u00b0\u00b1\7\n\2\2\u00b1\u00b2\5R*\2\u00b2"+
		"\u00b8\7,\2\2\u00b3\u00b7\5\n\6\2\u00b4\u00b7\5\30\r\2\u00b5\u00b7\5F"+
		"$\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7-\2\2\u00bc\27\3\2\2\2\u00bd\u00be"+
		"\5\36\20\2\u00be\u00bf\5P)\2\u00bf\u00c0\7\'\2\2\u00c0\u00c5\5\24\13\2"+
		"\u00c1\u00c2\7*\2\2\u00c2\u00c3\5\20\t\2\u00c3\u00c4\7+\2\2\u00c4\u00c6"+
		"\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c8\7&\2\2\u00c8\31\3\2\2\2\u00c9\u00ca\7\13\2\2\u00ca\u00cb\7.\2\2"+
		"\u00cb\u00cc\5\34\17\2\u00cc\u00cd\7\61\2\2\u00cd\u00ce\5\36\20\2\u00ce"+
		"\u00cf\7/\2\2\u00cf\u00d0\5T+\2\u00d0\u00d1\7\'\2\2\u00d1\u00d6\5\24\13"+
		"\2\u00d2\u00d3\7*\2\2\u00d3\u00d4\5\20\t\2\u00d4\u00d5\7+\2\2\u00d5\u00d7"+
		"\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\7&\2\2\u00d9\33\3\2\2\2\u00da\u00db\t\4\2\2\u00db\35\3\2\2\2\u00dc"+
		"\u00ee\7\30\2\2\u00dd\u00ee\7\31\2\2\u00de\u00ee\7\f\2\2\u00df\u00ee\7"+
		"\r\2\2\u00e0\u00ee\7\16\2\2\u00e1\u00ee\7\17\2\2\u00e2\u00ee\7\20\2\2"+
		"\u00e3\u00ee\7\21\2\2\u00e4\u00ee\7\22\2\2\u00e5\u00ee\7\23\2\2\u00e6"+
		"\u00ee\7\24\2\2\u00e7\u00ee\7\25\2\2\u00e8\u00ee\7\26\2\2\u00e9\u00ee"+
		"\7\27\2\2\u00ea\u00ee\7\32\2\2\u00eb\u00ee\5Z.\2\u00ec\u00ee\5\\/\2\u00ed"+
		"\u00dc\3\2\2\2\u00ed\u00dd\3\2\2\2\u00ed\u00de\3\2\2\2\u00ed\u00df\3\2"+
		"\2\2\u00ed\u00e0\3\2\2\2\u00ed\u00e1\3\2\2\2\u00ed\u00e2\3\2\2\2\u00ed"+
		"\u00e3\3\2\2\2\u00ed\u00e4\3\2\2\2\u00ed\u00e5\3\2\2\2\u00ed\u00e6\3\2"+
		"\2\2\u00ed\u00e7\3\2\2\2\u00ed\u00e8\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ed"+
		"\u00ea\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\37\3\2\2"+
		"\2\u00ef\u00f2\7\33\2\2\u00f0\u00f3\5\"\22\2\u00f1\u00f3\5&\24\2\u00f2"+
		"\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7&"+
		"\2\2\u00f5!\3\2\2\2\u00f6\u00fb\5$\23\2\u00f7\u00f8\7\61\2\2\u00f8\u00fa"+
		"\5$\23\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc#\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0104\5^\60\2"+
		"\u00ff\u0102\7\34\2\2\u0100\u0103\5^\60\2\u0101\u0103\7\35\2\2\u0102\u0100"+
		"\3\2\2\2\u0102\u0101\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u00ff\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105%\3\2\2\2\u0106\u010b\5`\61\2\u0107\u0108\7\61\2\2"+
		"\u0108\u010a\5`\61\2\u0109\u0107\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\'\3\2\2\2\u010d\u010b\3\2\2\2\u010e"+
		"\u0112\5\66\34\2\u010f\u0112\5*\26\2\u0110\u0112\5<\37\2\u0111\u010e\3"+
		"\2\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112)\3\2\2\2\u0113\u0114"+
		"\7\36\2\2\u0114\u0115\5N(\2\u0115\u0116\5,\27\2\u0116+\3\2\2\2\u0117\u011b"+
		"\7,\2\2\u0118\u011a\5.\30\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011e\u011f\7-\2\2\u011f-\3\2\2\2\u0120\u0124\5\n\6\2\u0121\u0124"+
		"\5\60\31\2\u0122\u0124\5F$\2\u0123\u0120\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0122\3\2\2\2\u0124/\3\2\2\2\u0125\u0126\5H%\2\u0126\u0128\7\'\2\2\u0127"+
		"\u0129\7\64\2\2\u0128\u0127\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012a\3"+
		"\2\2\2\u012a\u012c\5^\60\2\u012b\u012d\5\62\32\2\u012c\u012b\3\2\2\2\u012c"+
		"\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\7&\2\2\u012f\61\3\2\2\2"+
		"\u0130\u0131\7*\2\2\u0131\u0136\5\64\33\2\u0132\u0133\7\61\2\2\u0133\u0135"+
		"\5\64\33\2\u0134\u0132\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2"+
		"\u0136\u0137\3\2\2\2\u0137\u0139\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a"+
		"\7+\2\2\u013a\63\3\2\2\2\u013b\u013c\5\f\7\2\u013c\u013d\7\'\2\2\u013d"+
		"\u013e\5B\"\2\u013e\65\3\2\2\2\u013f\u0140\7\37\2\2\u0140\u0141\5L\'\2"+
		"\u0141\u0142\58\35\2\u0142\67\3\2\2\2\u0143\u0147\7,\2\2\u0144\u0146\5"+
		":\36\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\7-"+
		"\2\2\u014b9\3\2\2\2\u014c\u0155\5\16\b\2\u014d\u0155\5*\26\2\u014e\u0155"+
		"\5\66\34\2\u014f\u0155\5\n\6\2\u0150\u0155\5\26\f\2\u0151\u0155\5\32\16"+
		"\2\u0152\u0155\5 \21\2\u0153\u0155\5F$\2\u0154\u014c\3\2\2\2\u0154\u014d"+
		"\3\2\2\2\u0154\u014e\3\2\2\2\u0154\u014f\3\2\2\2\u0154\u0150\3\2\2\2\u0154"+
		"\u0151\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155;\3\2\2\2"+
		"\u0156\u0157\7 \2\2\u0157\u0158\5V,\2\u0158\u015c\7,\2\2\u0159\u015b\5"+
		"> \2\u015a\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\7-"+
		"\2\2\u0160=\3\2\2\2\u0161\u0165\5\n\6\2\u0162\u0165\5@!\2\u0163\u0165"+
		"\5F$\2\u0164\u0161\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0163\3\2\2\2\u0165"+
		"?\3\2\2\2\u0166\u0167\7!\2\2\u0167\u0168\5X-\2\u0168\u016a\7(\2\2\u0169"+
		"\u016b\7\"\2\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016d\5Z.\2\u016d\u016e\7)\2\2\u016e\u016f\7#\2\2\u016f\u0171"+
		"\7(\2\2\u0170\u0172\7\"\2\2\u0171\u0170\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173\u0174\5Z.\2\u0174\u017f\7)\2\2\u0175\u017a\7,\2\2"+
		"\u0176\u0179\5\n\6\2\u0177\u0179\5F$\2\u0178\u0176\3\2\2\2\u0178\u0177"+
		"\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b"+
		"\u017d\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u0180\7-\2\2\u017e\u0180\7&\2"+
		"\2\u017f\u0175\3\2\2\2\u017f\u017e\3\2\2\2\u0180A\3\2\2\2\u0181\u018e"+
		"\5J&\2\u0182\u0184\t\5\2\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u018e\5^\60\2\u0186\u0188\t\5\2\2\u0187\u0186\3\2"+
		"\2\2\u0187\u0188\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018e\5d\63\2\u018a"+
		"\u018e\5`\61\2\u018b\u018e\5b\62\2\u018c\u018e\5D#\2\u018d\u0181\3\2\2"+
		"\2\u018d\u0183\3\2\2\2\u018d\u0187\3\2\2\2\u018d\u018a\3\2\2\2\u018d\u018b"+
		"\3\2\2\2\u018d\u018c\3\2\2\2\u018eC\3\2\2\2\u018f\u0196\7,\2\2\u0190\u0191"+
		"\5H%\2\u0191\u0192\7\62\2\2\u0192\u0193\5B\"\2\u0193\u0195\3\2\2\2\u0194"+
		"\u0190\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197\u0199\3\2\2\2\u0198\u0196\3\2\2\2\u0199\u019a\7-\2\2\u019a"+
		"E\3\2\2\2\u019b\u019c\7&\2\2\u019cG\3\2\2\2\u019d\u01a0\79\2\2\u019e\u01a0"+
		"\5f\64\2\u019f\u019d\3\2\2\2\u019f\u019e\3\2\2\2\u01a0I\3\2\2\2\u01a1"+
		"\u01a6\5H%\2\u01a2\u01a3\7\60\2\2\u01a3\u01a5\5H%\2\u01a4\u01a2\3\2\2"+
		"\2\u01a5\u01a8\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7K"+
		"\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9\u01aa\5H%\2\u01aaM\3\2\2\2\u01ab\u01ac"+
		"\5H%\2\u01acO\3\2\2\2\u01ad\u01ae\5H%\2\u01aeQ\3\2\2\2\u01af\u01b0\5H"+
		"%\2\u01b0S\3\2\2\2\u01b1\u01b2\5H%\2\u01b2U\3\2\2\2\u01b3\u01b4\5H%\2"+
		"\u01b4W\3\2\2\2\u01b5\u01b6\5H%\2\u01b6Y\3\2\2\2\u01b7\u01b9\7\60\2\2"+
		"\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bf\3\2\2\2\u01ba\u01bb"+
		"\5H%\2\u01bb\u01bc\7\60\2\2\u01bc\u01be\3\2\2\2\u01bd\u01ba\3\2\2\2\u01be"+
		"\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c2\3\2"+
		"\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c3\5L\'\2\u01c3[\3\2\2\2\u01c4\u01c6"+
		"\7\60\2\2\u01c5\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01cc\3\2\2\2"+
		"\u01c7\u01c8\5H%\2\u01c8\u01c9\7\60\2\2\u01c9\u01cb\3\2\2\2\u01ca\u01c7"+
		"\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd"+
		"\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d0\5N(\2\u01d0]\3\2\2\2\u01d1"+
		"\u01d2\78\2\2\u01d2_\3\2\2\2\u01d3\u01d4\t\6\2\2\u01d4a\3\2\2\2\u01d5"+
		"\u01d6\7\66\2\2\u01d6c\3\2\2\2\u01d7\u01d8\7\67\2\2\u01d8e\3\2\2\2\u01d9"+
		"\u01da\t\7\2\2\u01dag\3\2\2\2-npz\u008f\u0091\u0094\u009e\u00a7\u00b6"+
		"\u00b8\u00c5\u00d6\u00ed\u00f2\u00fb\u0102\u0104\u010b\u0111\u011b\u0123"+
		"\u0128\u012c\u0136\u0147\u0154\u015c\u0164\u016a\u0171\u0178\u017a\u017f"+
		"\u0183\u0187\u018d\u0196\u019f\u01a6\u01b8\u01bf\u01c5\u01cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}