// Generated from LittleDuckParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LittleDuckParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, MAIN=2, END=3, VAR=4, INT=5, FLOAT=6, VOID=7, IF=8, ELSE=9, 
		WHILE=10, DO=11, PRINT=12, ID=13, CTE_INT=14, CTE_FLOAT=15, CTE_STRING=16, 
		PLUS=17, MINUS=18, MULT=19, DIV=20, ASSIGN=21, EQ_COMP=22, NEQ=23, LT=24, 
		GT=25, LPAREN=26, RPAREN=27, LBRACE=28, RBRACE=29, SEMICOLON=30, COMMA=31, 
		COLON=32, DOT=33, WS=34;
	public static final int
		RULE_programa = 0, RULE_dec_vars = 1, RULE_dec_var_aux = 2, RULE_lista_ids = 3, 
		RULE_tipo = 4, RULE_bloque_principal = 5, RULE_bloque = 6, RULE_estatuto = 7, 
		RULE_asignacion = 8, RULE_escritura = 9, RULE_print_args = 10, RULE_condicion = 11, 
		RULE_ciclo_w = 12, RULE_ciclo_do_w = 13, RULE_expresion = 14, RULE_exp_comp = 15, 
		RULE_exp_arit = 16, RULE_termino = 17, RULE_factor = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "dec_vars", "dec_var_aux", "lista_ids", "tipo", "bloque_principal", 
			"bloque", "estatuto", "asignacion", "escritura", "print_args", "condicion", 
			"ciclo_w", "ciclo_do_w", "expresion", "exp_comp", "exp_arit", "termino", 
			"factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'main'", "'end'", "'var'", "'int'", "'float'", "'void'", 
			"'if'", "'else'", "'while'", "'do'", "'print'", null, null, null, null, 
			"'+'", "'-'", "'*'", "'/'", "'='", "'=='", "'!='", "'<'", "'>'", "'('", 
			"')'", "'{'", "'}'", "';'", "','", "':'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "MAIN", "END", "VAR", "INT", "FLOAT", "VOID", "IF", 
			"ELSE", "WHILE", "DO", "PRINT", "ID", "CTE_INT", "CTE_FLOAT", "CTE_STRING", 
			"PLUS", "MINUS", "MULT", "DIV", "ASSIGN", "EQ_COMP", "NEQ", "LT", "GT", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMICOLON", "COMMA", "COLON", 
			"DOT", "WS"
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
	public String getGrammarFileName() { return "LittleDuckParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LittleDuckParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(LittleDuckParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(LittleDuckParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(LittleDuckParser.SEMICOLON, 0); }
		public Bloque_principalContext bloque_principal() {
			return getRuleContext(Bloque_principalContext.class,0);
		}
		public TerminalNode END() { return getToken(LittleDuckParser.END, 0); }
		public TerminalNode DOT() { return getToken(LittleDuckParser.DOT, 0); }
		public Dec_varsContext dec_vars() {
			return getRuleContext(Dec_varsContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(PROGRAM);
			setState(39);
			match(ID);
			setState(40);
			match(SEMICOLON);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(41);
				dec_vars();
				}
			}

			setState(44);
			bloque_principal();
			setState(45);
			match(END);
			setState(46);
			match(DOT);
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
	public static class Dec_varsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LittleDuckParser.VAR, 0); }
		public List<Dec_var_auxContext> dec_var_aux() {
			return getRuleContexts(Dec_var_auxContext.class);
		}
		public Dec_var_auxContext dec_var_aux(int i) {
			return getRuleContext(Dec_var_auxContext.class,i);
		}
		public Dec_varsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterDec_vars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitDec_vars(this);
		}
	}

	public final Dec_varsContext dec_vars() throws RecognitionException {
		Dec_varsContext _localctx = new Dec_varsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(VAR);
			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(49);
				dec_var_aux();
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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
	public static class Dec_var_auxContext extends ParserRuleContext {
		public Lista_idsContext lista_ids() {
			return getRuleContext(Lista_idsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(LittleDuckParser.COLON, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LittleDuckParser.SEMICOLON, 0); }
		public Dec_var_auxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec_var_aux; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterDec_var_aux(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitDec_var_aux(this);
		}
	}

	public final Dec_var_auxContext dec_var_aux() throws RecognitionException {
		Dec_var_auxContext _localctx = new Dec_var_auxContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dec_var_aux);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			lista_ids();
			setState(55);
			match(COLON);
			setState(56);
			tipo();
			setState(57);
			match(SEMICOLON);
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
	public static class Lista_idsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LittleDuckParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LittleDuckParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LittleDuckParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LittleDuckParser.COMMA, i);
		}
		public Lista_idsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_ids; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterLista_ids(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitLista_ids(this);
		}
	}

	public final Lista_idsContext lista_ids() throws RecognitionException {
		Lista_idsContext _localctx = new Lista_idsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lista_ids);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(ID);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(60);
				match(COMMA);
				setState(61);
				match(ID);
				}
				}
				setState(66);
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
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(LittleDuckParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LittleDuckParser.FLOAT, 0); }
		public TerminalNode VOID() { return getToken(LittleDuckParser.VOID, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 224L) != 0)) ) {
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
	public static class Bloque_principalContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(LittleDuckParser.MAIN, 0); }
		public TerminalNode LPAREN() { return getToken(LittleDuckParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LittleDuckParser.RPAREN, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Bloque_principalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque_principal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterBloque_principal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitBloque_principal(this);
		}
	}

	public final Bloque_principalContext bloque_principal() throws RecognitionException {
		Bloque_principalContext _localctx = new Bloque_principalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bloque_principal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(MAIN);
			setState(70);
			match(LPAREN);
			setState(71);
			match(RPAREN);
			setState(72);
			bloque();
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
	public static class BloqueContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(LittleDuckParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LittleDuckParser.RBRACE, 0); }
		public List<EstatutoContext> estatuto() {
			return getRuleContexts(EstatutoContext.class);
		}
		public EstatutoContext estatuto(int i) {
			return getRuleContext(EstatutoContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterBloque(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitBloque(this);
		}
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(LBRACE);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15616L) != 0)) {
				{
				{
				setState(75);
				estatuto();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			match(RBRACE);
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
	public static class EstatutoContext extends ParserRuleContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public CondicionContext condicion() {
			return getRuleContext(CondicionContext.class,0);
		}
		public Ciclo_wContext ciclo_w() {
			return getRuleContext(Ciclo_wContext.class,0);
		}
		public Ciclo_do_wContext ciclo_do_w() {
			return getRuleContext(Ciclo_do_wContext.class,0);
		}
		public EscrituraContext escritura() {
			return getRuleContext(EscrituraContext.class,0);
		}
		public EstatutoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estatuto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterEstatuto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitEstatuto(this);
		}
	}

	public final EstatutoContext estatuto() throws RecognitionException {
		EstatutoContext _localctx = new EstatutoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_estatuto);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				asignacion();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				condicion();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				ciclo_w();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				ciclo_do_w();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				escritura();
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
	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LittleDuckParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(LittleDuckParser.ASSIGN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LittleDuckParser.SEMICOLON, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitAsignacion(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(ID);
			setState(91);
			match(ASSIGN);
			setState(92);
			expresion();
			setState(93);
			match(SEMICOLON);
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
	public static class EscrituraContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(LittleDuckParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(LittleDuckParser.LPAREN, 0); }
		public Print_argsContext print_args() {
			return getRuleContext(Print_argsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LittleDuckParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LittleDuckParser.SEMICOLON, 0); }
		public EscrituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escritura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterEscritura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitEscritura(this);
		}
	}

	public final EscrituraContext escritura() throws RecognitionException {
		EscrituraContext _localctx = new EscrituraContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_escritura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(PRINT);
			setState(96);
			match(LPAREN);
			setState(97);
			print_args();
			setState(98);
			match(RPAREN);
			setState(99);
			match(SEMICOLON);
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
	public static class Print_argsContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LittleDuckParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LittleDuckParser.COMMA, i);
		}
		public List<TerminalNode> CTE_STRING() { return getTokens(LittleDuckParser.CTE_STRING); }
		public TerminalNode CTE_STRING(int i) {
			return getToken(LittleDuckParser.CTE_STRING, i);
		}
		public Print_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterPrint_args(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitPrint_args(this);
		}
	}

	public final Print_argsContext print_args() throws RecognitionException {
		Print_argsContext _localctx = new Print_argsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_print_args);
		int _la;
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case CTE_INT:
			case CTE_FLOAT:
			case PLUS:
			case MINUS:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				expresion();
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(102);
					match(COMMA);
					setState(103);
					expresion();
					}
					}
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case CTE_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(CTE_STRING);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(110);
					match(COMMA);
					setState(113);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
					case CTE_INT:
					case CTE_FLOAT:
					case PLUS:
					case MINUS:
					case LPAREN:
						{
						setState(111);
						expresion();
						}
						break;
					case CTE_STRING:
						{
						setState(112);
						match(CTE_STRING);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CondicionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LittleDuckParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(LittleDuckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LittleDuckParser.RPAREN, 0); }
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LittleDuckParser.ELSE, 0); }
		public CondicionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterCondicion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitCondicion(this);
		}
	}

	public final CondicionContext condicion() throws RecognitionException {
		CondicionContext _localctx = new CondicionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_condicion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(IF);
			setState(123);
			match(LPAREN);
			setState(124);
			expresion();
			setState(125);
			match(RPAREN);
			setState(126);
			bloque();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(127);
				match(ELSE);
				setState(128);
				bloque();
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
	public static class Ciclo_wContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LittleDuckParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(LittleDuckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LittleDuckParser.RPAREN, 0); }
		public TerminalNode DO() { return getToken(LittleDuckParser.DO, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public Ciclo_wContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ciclo_w; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterCiclo_w(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitCiclo_w(this);
		}
	}

	public final Ciclo_wContext ciclo_w() throws RecognitionException {
		Ciclo_wContext _localctx = new Ciclo_wContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ciclo_w);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(WHILE);
			setState(132);
			match(LPAREN);
			setState(133);
			expresion();
			setState(134);
			match(RPAREN);
			setState(135);
			match(DO);
			setState(136);
			bloque();
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
	public static class Ciclo_do_wContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(LittleDuckParser.DO, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(LittleDuckParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(LittleDuckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LittleDuckParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LittleDuckParser.SEMICOLON, 0); }
		public Ciclo_do_wContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ciclo_do_w; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterCiclo_do_w(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitCiclo_do_w(this);
		}
	}

	public final Ciclo_do_wContext ciclo_do_w() throws RecognitionException {
		Ciclo_do_wContext _localctx = new Ciclo_do_wContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ciclo_do_w);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(DO);
			setState(139);
			bloque();
			setState(140);
			match(WHILE);
			setState(141);
			match(LPAREN);
			setState(142);
			expresion();
			setState(143);
			match(RPAREN);
			setState(144);
			match(SEMICOLON);
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
	public static class ExpresionContext extends ParserRuleContext {
		public List<Exp_compContext> exp_comp() {
			return getRuleContexts(Exp_compContext.class);
		}
		public Exp_compContext exp_comp(int i) {
			return getRuleContext(Exp_compContext.class,i);
		}
		public List<TerminalNode> EQ_COMP() { return getTokens(LittleDuckParser.EQ_COMP); }
		public TerminalNode EQ_COMP(int i) {
			return getToken(LittleDuckParser.EQ_COMP, i);
		}
		public List<TerminalNode> NEQ() { return getTokens(LittleDuckParser.NEQ); }
		public TerminalNode NEQ(int i) {
			return getToken(LittleDuckParser.NEQ, i);
		}
		public List<TerminalNode> LT() { return getTokens(LittleDuckParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(LittleDuckParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(LittleDuckParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(LittleDuckParser.GT, i);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitExpresion(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expresion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			exp_comp();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) {
				{
				{
				setState(147);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(148);
				exp_comp();
				}
				}
				setState(153);
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
	public static class Exp_compContext extends ParserRuleContext {
		public List<Exp_aritContext> exp_arit() {
			return getRuleContexts(Exp_aritContext.class);
		}
		public Exp_aritContext exp_arit(int i) {
			return getRuleContext(Exp_aritContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(LittleDuckParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LittleDuckParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LittleDuckParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LittleDuckParser.MINUS, i);
		}
		public Exp_compContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_comp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterExp_comp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitExp_comp(this);
		}
	}

	public final Exp_compContext exp_comp() throws RecognitionException {
		Exp_compContext _localctx = new Exp_compContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exp_comp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			exp_arit();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(155);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(156);
				exp_arit();
				}
				}
				setState(161);
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
	public static class Exp_aritContext extends ParserRuleContext {
		public List<TerminoContext> termino() {
			return getRuleContexts(TerminoContext.class);
		}
		public TerminoContext termino(int i) {
			return getRuleContext(TerminoContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(LittleDuckParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(LittleDuckParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LittleDuckParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LittleDuckParser.DIV, i);
		}
		public Exp_aritContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_arit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterExp_arit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitExp_arit(this);
		}
	}

	public final Exp_aritContext exp_arit() throws RecognitionException {
		Exp_aritContext _localctx = new Exp_aritContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_exp_arit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			termino();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				{
				setState(163);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(164);
				termino();
				}
				}
				setState(169);
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
	public static class TerminoContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(LittleDuckParser.LPAREN, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LittleDuckParser.RPAREN, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(LittleDuckParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LittleDuckParser.MINUS, 0); }
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterTermino(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitTermino(this);
		}
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_termino);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(LPAREN);
				setState(171);
				expresion();
				setState(172);
				match(RPAREN);
				}
				break;
			case ID:
			case CTE_INT:
			case CTE_FLOAT:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(174);
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

				setState(177);
				factor();
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
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LittleDuckParser.ID, 0); }
		public TerminalNode CTE_INT() { return getToken(LittleDuckParser.CTE_INT, 0); }
		public TerminalNode CTE_FLOAT() { return getToken(LittleDuckParser.CTE_FLOAT, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LittleDuckParserListener ) ((LittleDuckParserListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 57344L) != 0)) ) {
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
		"\u0004\u0001\"\u00b7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000+\b\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0004\u00013\b\u0001\u000b\u0001\f\u00014\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003?\b\u0003\n\u0003\f\u0003B\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u0006M\b\u0006\n\u0006\f\u0006P\t\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007Y\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005\ni\b"+
		"\n\n\n\f\nl\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nr\b\n\u0005\nt"+
		"\b\n\n\n\f\nw\t\n\u0003\ny\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0082\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u0096\b\u000e\n\u000e\f\u000e\u0099\t\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u009e\b\u000f\n\u000f\f\u000f\u00a1"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00a6\b\u0010"+
		"\n\u0010\f\u0010\u00a9\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u00b0\b\u0011\u0001\u0011\u0003\u0011\u00b3"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0000\u0013\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$\u0000\u0005\u0001\u0000\u0005\u0007\u0001\u0000\u0016\u0019\u0001"+
		"\u0000\u0011\u0012\u0001\u0000\u0013\u0014\u0001\u0000\r\u000f\u00b5\u0000"+
		"&\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u00046\u0001"+
		"\u0000\u0000\u0000\u0006;\u0001\u0000\u0000\u0000\bC\u0001\u0000\u0000"+
		"\u0000\nE\u0001\u0000\u0000\u0000\fJ\u0001\u0000\u0000\u0000\u000eX\u0001"+
		"\u0000\u0000\u0000\u0010Z\u0001\u0000\u0000\u0000\u0012_\u0001\u0000\u0000"+
		"\u0000\u0014x\u0001\u0000\u0000\u0000\u0016z\u0001\u0000\u0000\u0000\u0018"+
		"\u0083\u0001\u0000\u0000\u0000\u001a\u008a\u0001\u0000\u0000\u0000\u001c"+
		"\u0092\u0001\u0000\u0000\u0000\u001e\u009a\u0001\u0000\u0000\u0000 \u00a2"+
		"\u0001\u0000\u0000\u0000\"\u00b2\u0001\u0000\u0000\u0000$\u00b4\u0001"+
		"\u0000\u0000\u0000&\'\u0005\u0001\u0000\u0000\'(\u0005\r\u0000\u0000("+
		"*\u0005\u001e\u0000\u0000)+\u0003\u0002\u0001\u0000*)\u0001\u0000\u0000"+
		"\u0000*+\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0003\n\u0005"+
		"\u0000-.\u0005\u0003\u0000\u0000./\u0005!\u0000\u0000/\u0001\u0001\u0000"+
		"\u0000\u000002\u0005\u0004\u0000\u000013\u0003\u0004\u0002\u000021\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u00005\u0003\u0001\u0000\u0000\u000067\u0003\u0006"+
		"\u0003\u000078\u0005 \u0000\u000089\u0003\b\u0004\u00009:\u0005\u001e"+
		"\u0000\u0000:\u0005\u0001\u0000\u0000\u0000;@\u0005\r\u0000\u0000<=\u0005"+
		"\u001f\u0000\u0000=?\u0005\r\u0000\u0000><\u0001\u0000\u0000\u0000?B\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"A\u0007\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0007\u0000"+
		"\u0000\u0000D\t\u0001\u0000\u0000\u0000EF\u0005\u0002\u0000\u0000FG\u0005"+
		"\u001a\u0000\u0000GH\u0005\u001b\u0000\u0000HI\u0003\f\u0006\u0000I\u000b"+
		"\u0001\u0000\u0000\u0000JN\u0005\u001c\u0000\u0000KM\u0003\u000e\u0007"+
		"\u0000LK\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000"+
		"\u0000\u0000NO\u0001\u0000\u0000\u0000OQ\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000QR\u0005\u001d\u0000\u0000R\r\u0001\u0000\u0000\u0000"+
		"SY\u0003\u0010\b\u0000TY\u0003\u0016\u000b\u0000UY\u0003\u0018\f\u0000"+
		"VY\u0003\u001a\r\u0000WY\u0003\u0012\t\u0000XS\u0001\u0000\u0000\u0000"+
		"XT\u0001\u0000\u0000\u0000XU\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000"+
		"\u0000XW\u0001\u0000\u0000\u0000Y\u000f\u0001\u0000\u0000\u0000Z[\u0005"+
		"\r\u0000\u0000[\\\u0005\u0015\u0000\u0000\\]\u0003\u001c\u000e\u0000]"+
		"^\u0005\u001e\u0000\u0000^\u0011\u0001\u0000\u0000\u0000_`\u0005\f\u0000"+
		"\u0000`a\u0005\u001a\u0000\u0000ab\u0003\u0014\n\u0000bc\u0005\u001b\u0000"+
		"\u0000cd\u0005\u001e\u0000\u0000d\u0013\u0001\u0000\u0000\u0000ej\u0003"+
		"\u001c\u000e\u0000fg\u0005\u001f\u0000\u0000gi\u0003\u001c\u000e\u0000"+
		"hf\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000ky\u0001\u0000\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000mu\u0005\u0010\u0000\u0000nq\u0005\u001f\u0000\u0000or\u0003"+
		"\u001c\u000e\u0000pr\u0005\u0010\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qp\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000\u0000sn\u0001\u0000\u0000"+
		"\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xe\u0001"+
		"\u0000\u0000\u0000xm\u0001\u0000\u0000\u0000y\u0015\u0001\u0000\u0000"+
		"\u0000z{\u0005\b\u0000\u0000{|\u0005\u001a\u0000\u0000|}\u0003\u001c\u000e"+
		"\u0000}~\u0005\u001b\u0000\u0000~\u0081\u0003\f\u0006\u0000\u007f\u0080"+
		"\u0005\t\u0000\u0000\u0080\u0082\u0003\f\u0006\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0017\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0005\n\u0000\u0000\u0084\u0085\u0005\u001a"+
		"\u0000\u0000\u0085\u0086\u0003\u001c\u000e\u0000\u0086\u0087\u0005\u001b"+
		"\u0000\u0000\u0087\u0088\u0005\u000b\u0000\u0000\u0088\u0089\u0003\f\u0006"+
		"\u0000\u0089\u0019\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u000b\u0000"+
		"\u0000\u008b\u008c\u0003\f\u0006\u0000\u008c\u008d\u0005\n\u0000\u0000"+
		"\u008d\u008e\u0005\u001a\u0000\u0000\u008e\u008f\u0003\u001c\u000e\u0000"+
		"\u008f\u0090\u0005\u001b\u0000\u0000\u0090\u0091\u0005\u001e\u0000\u0000"+
		"\u0091\u001b\u0001\u0000\u0000\u0000\u0092\u0097\u0003\u001e\u000f\u0000"+
		"\u0093\u0094\u0007\u0001\u0000\u0000\u0094\u0096\u0003\u001e\u000f\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000\u0000\u0000"+
		"\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000"+
		"\u0098\u001d\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000"+
		"\u009a\u009f\u0003 \u0010\u0000\u009b\u009c\u0007\u0002\u0000\u0000\u009c"+
		"\u009e\u0003 \u0010\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a1"+
		"\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a0\u001f\u0001\u0000\u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a7\u0003\"\u0011\u0000\u00a3\u00a4\u0007"+
		"\u0003\u0000\u0000\u00a4\u00a6\u0003\"\u0011\u0000\u00a5\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8!\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u001a\u0000"+
		"\u0000\u00ab\u00ac\u0003\u001c\u000e\u0000\u00ac\u00ad\u0005\u001b\u0000"+
		"\u0000\u00ad\u00b3\u0001\u0000\u0000\u0000\u00ae\u00b0\u0007\u0002\u0000"+
		"\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3\u0003$\u0012\u0000"+
		"\u00b2\u00aa\u0001\u0000\u0000\u0000\u00b2\u00af\u0001\u0000\u0000\u0000"+
		"\u00b3#\u0001\u0000\u0000\u0000\u00b4\u00b5\u0007\u0004\u0000\u0000\u00b5"+
		"%\u0001\u0000\u0000\u0000\u000f*4@NXjqux\u0081\u0097\u009f\u00a7\u00af"+
		"\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}