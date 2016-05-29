// Generated from D:/Ákos/Dropbox/bcpraca3/src/main/java/com/akos/language\Orbbasic.g4 by ANTLR 4.5.1
package com.akos.language;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OrbbasicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GT=1, LT=2, EQ=3, NOT=4, AND=5, OR=6, TIMES=7, DIV=8, MOD=9, PLUS=10, 
		MINUS=11, BINSHL=12, BINSHR=13, BINAND=14, BINOR=15, SQRT=16, RND=17, 
		ABS=18, IF=19, THEN=20, ELSE=21, FOR=22, TO=23, STEP=24, NEXT=25, GOTO=26, 
		GOSUB=27, ON=28, COMMA=29, QMARK=30, LPAREN=31, RPAREN=32, PRINT=33, INPUT=34, 
		DELAY=35, END=36, RGB=37, LEDC=38, BACKLED=39, RANDOM=40, GOROLL=41, HEADING=42, 
		RAW=43, LOCATE=44, BASFLG=45, DATA=46, RSTR=47, READ=48, TRON=49, TROFF=50, 
		RESET=51, SLEEP=52, MACRUN=53, MACKILL=54, MACSTAT=55, SYSVARNAME=56, 
		VARLETTER=57, LISTLETTER=58, COMMENT=59, STRINGLITERAL=60, NUMBER=61, 
		WS=62;
	public static final int
		RULE_prog = 0, RULE_line = 1, RULE_linenumber = 2, RULE_statement = 3, 
		RULE_printstmt = 4, RULE_printlist = 5, RULE_conditionalstmt = 6, RULE_forstmt = 7, 
		RULE_nextstmt = 8, RULE_branchstmt = 9, RULE_idxbranchstmt = 10, RULE_input = 11, 
		RULE_delay = 12, RULE_end = 13, RULE_rgb = 14, RULE_ledc = 15, RULE_backled = 16, 
		RULE_random = 17, RULE_goroll = 18, RULE_heading = 19, RULE_raw = 20, 
		RULE_locate = 21, RULE_basflg = 22, RULE_data = 23, RULE_rstr = 24, RULE_read = 25, 
		RULE_tron = 26, RULE_troff = 27, RULE_reset_ = 28, RULE_sleep = 29, RULE_macrun = 30, 
		RULE_mackill = 31, RULE_macstat = 32, RULE_vardecl = 33, RULE_varname = 34, 
		RULE_varassign = 35, RULE_neq = 36, RULE_number = 37, RULE_func = 38, 
		RULE_sqrtfunc = 39, RULE_rndfunc = 40, RULE_absfunc = 41, RULE_signExpr = 42, 
		RULE_multExpr = 43, RULE_addExpr = 44, RULE_relExpr = 45, RULE_expression = 46;
	public static final String[] ruleNames = {
		"prog", "line", "linenumber", "statement", "printstmt", "printlist", "conditionalstmt", 
		"forstmt", "nextstmt", "branchstmt", "idxbranchstmt", "input", "delay", 
		"end", "rgb", "ledc", "backled", "random", "goroll", "heading", "raw", 
		"locate", "basflg", "data", "rstr", "read", "tron", "troff", "reset_", 
		"sleep", "macrun", "mackill", "macstat", "vardecl", "varname", "varassign", 
		"neq", "number", "func", "sqrtfunc", "rndfunc", "absfunc", "signExpr", 
		"multExpr", "addExpr", "relExpr", "expression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'>'", "'<'", "'='", "'!'", "'and'", "'or'", "'*'", "'/'", "'%'", 
		"'+'", "'-'", "'{'", "'}'", "'&'", "'|'", "'sqrt'", "'rnd'", "'abs'", 
		"'if'", "'then'", "'else'", "'for'", "'to'", "'step'", "'next'", "'goto'", 
		"'gosub'", "'on'", "','", "'?'", "'('", "')'", "'print'", "'input'", "'delay'", 
		"'end'", "'RGB'", "'LEDC'", "'backLED'", "'random'", "'goroll'", "'heading'", 
		"'raw'", "'locate'", "'x'", "'data'", "'rstr'", "'read'", "'tron'", "'troff'", 
		"'reset'", "'sleep'", "'macrun'", "'mackill'", "'macstat'", null, null, 
		"'Z'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GT", "LT", "EQ", "NOT", "AND", "OR", "TIMES", "DIV", "MOD", "PLUS", 
		"MINUS", "BINSHL", "BINSHR", "BINAND", "BINOR", "SQRT", "RND", "ABS", 
		"IF", "THEN", "ELSE", "FOR", "TO", "STEP", "NEXT", "GOTO", "GOSUB", "ON", 
		"COMMA", "QMARK", "LPAREN", "RPAREN", "PRINT", "INPUT", "DELAY", "END", 
		"RGB", "LEDC", "BACKLED", "RANDOM", "GOROLL", "HEADING", "RAW", "LOCATE", 
		"BASFLG", "DATA", "RSTR", "READ", "TRON", "TROFF", "RESET", "SLEEP", "MACRUN", 
		"MACKILL", "MACSTAT", "SYSVARNAME", "VARLETTER", "LISTLETTER", "COMMENT", 
		"STRINGLITERAL", "NUMBER", "WS"
	};
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
	public String getGrammarFileName() { return "Orbbasic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OrbbasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(OrbbasicParser.EOF, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				line();
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMENT || _la==NUMBER );
			setState(99);
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

	public static class LineContext extends ParserRuleContext {
		public LinenumberContext linenumber() {
			return getRuleContext(LinenumberContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(OrbbasicParser.COMMENT, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(105);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(101);
				linenumber();
				setState(102);
				statement();
				}
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(COMMENT);
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

	public static class LinenumberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(OrbbasicParser.NUMBER, 0); }
		public LinenumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linenumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterLinenumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitLinenumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitLinenumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinenumberContext linenumber() throws RecognitionException {
		LinenumberContext _localctx = new LinenumberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_linenumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(NUMBER);
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

	public static class StatementContext extends ParserRuleContext {
		public PrintstmtContext printstmt() {
			return getRuleContext(PrintstmtContext.class,0);
		}
		public ConditionalstmtContext conditionalstmt() {
			return getRuleContext(ConditionalstmtContext.class,0);
		}
		public ForstmtContext forstmt() {
			return getRuleContext(ForstmtContext.class,0);
		}
		public NextstmtContext nextstmt() {
			return getRuleContext(NextstmtContext.class,0);
		}
		public BranchstmtContext branchstmt() {
			return getRuleContext(BranchstmtContext.class,0);
		}
		public IdxbranchstmtContext idxbranchstmt() {
			return getRuleContext(IdxbranchstmtContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public DelayContext delay() {
			return getRuleContext(DelayContext.class,0);
		}
		public EndContext end() {
			return getRuleContext(EndContext.class,0);
		}
		public RgbContext rgb() {
			return getRuleContext(RgbContext.class,0);
		}
		public LedcContext ledc() {
			return getRuleContext(LedcContext.class,0);
		}
		public BackledContext backled() {
			return getRuleContext(BackledContext.class,0);
		}
		public RandomContext random() {
			return getRuleContext(RandomContext.class,0);
		}
		public GorollContext goroll() {
			return getRuleContext(GorollContext.class,0);
		}
		public HeadingContext heading() {
			return getRuleContext(HeadingContext.class,0);
		}
		public RawContext raw() {
			return getRuleContext(RawContext.class,0);
		}
		public LocateContext locate() {
			return getRuleContext(LocateContext.class,0);
		}
		public BasflgContext basflg() {
			return getRuleContext(BasflgContext.class,0);
		}
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public RstrContext rstr() {
			return getRuleContext(RstrContext.class,0);
		}
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public TronContext tron() {
			return getRuleContext(TronContext.class,0);
		}
		public TroffContext troff() {
			return getRuleContext(TroffContext.class,0);
		}
		public Reset_Context reset_() {
			return getRuleContext(Reset_Context.class,0);
		}
		public SleepContext sleep() {
			return getRuleContext(SleepContext.class,0);
		}
		public MacrunContext macrun() {
			return getRuleContext(MacrunContext.class,0);
		}
		public MackillContext mackill() {
			return getRuleContext(MackillContext.class,0);
		}
		public MacstatContext macstat() {
			return getRuleContext(MacstatContext.class,0);
		}
		public VarassignContext varassign() {
			return getRuleContext(VarassignContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(138);
			switch (_input.LA(1)) {
			case QMARK:
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				printstmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				conditionalstmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				forstmt();
				}
				break;
			case NEXT:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				nextstmt();
				}
				break;
			case GOTO:
			case GOSUB:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				branchstmt();
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 6);
				{
				setState(114);
				idxbranchstmt();
				}
				break;
			case INPUT:
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				input();
				}
				break;
			case DELAY:
				enterOuterAlt(_localctx, 8);
				{
				setState(116);
				delay();
				}
				break;
			case END:
				enterOuterAlt(_localctx, 9);
				{
				setState(117);
				end();
				}
				break;
			case RGB:
				enterOuterAlt(_localctx, 10);
				{
				setState(118);
				rgb();
				}
				break;
			case LEDC:
				enterOuterAlt(_localctx, 11);
				{
				setState(119);
				ledc();
				}
				break;
			case BACKLED:
				enterOuterAlt(_localctx, 12);
				{
				setState(120);
				backled();
				}
				break;
			case RANDOM:
				enterOuterAlt(_localctx, 13);
				{
				setState(121);
				random();
				}
				break;
			case GOROLL:
				enterOuterAlt(_localctx, 14);
				{
				setState(122);
				goroll();
				}
				break;
			case HEADING:
				enterOuterAlt(_localctx, 15);
				{
				setState(123);
				heading();
				}
				break;
			case RAW:
				enterOuterAlt(_localctx, 16);
				{
				setState(124);
				raw();
				}
				break;
			case LOCATE:
				enterOuterAlt(_localctx, 17);
				{
				setState(125);
				locate();
				}
				break;
			case BASFLG:
				enterOuterAlt(_localctx, 18);
				{
				setState(126);
				basflg();
				}
				break;
			case DATA:
				enterOuterAlt(_localctx, 19);
				{
				setState(127);
				data();
				}
				break;
			case RSTR:
				enterOuterAlt(_localctx, 20);
				{
				setState(128);
				rstr();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 21);
				{
				setState(129);
				read();
				}
				break;
			case TRON:
				enterOuterAlt(_localctx, 22);
				{
				setState(130);
				tron();
				}
				break;
			case TROFF:
				enterOuterAlt(_localctx, 23);
				{
				setState(131);
				troff();
				}
				break;
			case RESET:
				enterOuterAlt(_localctx, 24);
				{
				setState(132);
				reset_();
				}
				break;
			case SLEEP:
				enterOuterAlt(_localctx, 25);
				{
				setState(133);
				sleep();
				}
				break;
			case MACRUN:
				enterOuterAlt(_localctx, 26);
				{
				setState(134);
				macrun();
				}
				break;
			case MACKILL:
				enterOuterAlt(_localctx, 27);
				{
				setState(135);
				mackill();
				}
				break;
			case MACSTAT:
				enterOuterAlt(_localctx, 28);
				{
				setState(136);
				macstat();
				}
				break;
			case SYSVARNAME:
			case VARLETTER:
				enterOuterAlt(_localctx, 29);
				{
				setState(137);
				varassign();
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

	public static class PrintstmtContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(OrbbasicParser.PRINT, 0); }
		public TerminalNode QMARK() { return getToken(OrbbasicParser.QMARK, 0); }
		public PrintlistContext printlist() {
			return getRuleContext(PrintlistContext.class,0);
		}
		public PrintstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterPrintstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitPrintstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitPrintstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintstmtContext printstmt() throws RecognitionException {
		PrintstmtContext _localctx = new PrintstmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_printstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !(_la==QMARK || _la==PRINT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(142);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(141);
				printlist();
				}
				break;
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

	public static class PrintlistContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(OrbbasicParser.COMMA, 0); }
		public List<PrintlistContext> printlist() {
			return getRuleContexts(PrintlistContext.class);
		}
		public PrintlistContext printlist(int i) {
			return getRuleContext(PrintlistContext.class,i);
		}
		public PrintlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterPrintlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitPrintlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitPrintlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintlistContext printlist() throws RecognitionException {
		PrintlistContext _localctx = new PrintlistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_printlist);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			expression();
			setState(146);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(145);
				match(COMMA);
				}
			}

			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(148);
					printlist();
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ConditionalstmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(OrbbasicParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(OrbbasicParser.THEN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(OrbbasicParser.ELSE, 0); }
		public ConditionalstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterConditionalstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitConditionalstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitConditionalstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalstmtContext conditionalstmt() throws RecognitionException {
		ConditionalstmtContext _localctx = new ConditionalstmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_conditionalstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(IF);
			setState(155);
			expression();
			setState(156);
			match(THEN);
			setState(157);
			statement();
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(158);
				match(ELSE);
				setState(159);
				statement();
				}
				break;
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

	public static class ForstmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(OrbbasicParser.FOR, 0); }
		public VarassignContext varassign() {
			return getRuleContext(VarassignContext.class,0);
		}
		public TerminalNode TO() { return getToken(OrbbasicParser.TO, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode STEP() { return getToken(OrbbasicParser.STEP, 0); }
		public ForstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitForstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitForstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForstmtContext forstmt() throws RecognitionException {
		ForstmtContext _localctx = new ForstmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(FOR);
			setState(163);
			varassign();
			setState(164);
			match(TO);
			setState(165);
			expression();
			setState(168);
			_la = _input.LA(1);
			if (_la==STEP) {
				{
				setState(166);
				match(STEP);
				setState(167);
				expression();
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

	public static class NextstmtContext extends ParserRuleContext {
		public TerminalNode NEXT() { return getToken(OrbbasicParser.NEXT, 0); }
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public NextstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterNextstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitNextstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitNextstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NextstmtContext nextstmt() throws RecognitionException {
		NextstmtContext _localctx = new NextstmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nextstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(NEXT);
			setState(172);
			_la = _input.LA(1);
			if (_la==SYSVARNAME || _la==VARLETTER) {
				{
				setState(171);
				vardecl();
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

	public static class BranchstmtContext extends ParserRuleContext {
		public TerminalNode GOTO() { return getToken(OrbbasicParser.GOTO, 0); }
		public LinenumberContext linenumber() {
			return getRuleContext(LinenumberContext.class,0);
		}
		public TerminalNode GOSUB() { return getToken(OrbbasicParser.GOSUB, 0); }
		public BranchstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branchstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterBranchstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitBranchstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitBranchstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchstmtContext branchstmt() throws RecognitionException {
		BranchstmtContext _localctx = new BranchstmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_branchstmt);
		try {
			setState(178);
			switch (_input.LA(1)) {
			case GOTO:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(GOTO);
				setState(175);
				linenumber();
				}
				break;
			case GOSUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(GOSUB);
				setState(177);
				linenumber();
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

	public static class IdxbranchstmtContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(OrbbasicParser.ON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GOTO() { return getToken(OrbbasicParser.GOTO, 0); }
		public TerminalNode GOSUB() { return getToken(OrbbasicParser.GOSUB, 0); }
		public List<TerminalNode> COMMA() { return getTokens(OrbbasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OrbbasicParser.COMMA, i);
		}
		public List<LinenumberContext> linenumber() {
			return getRuleContexts(LinenumberContext.class);
		}
		public LinenumberContext linenumber(int i) {
			return getRuleContext(LinenumberContext.class,i);
		}
		public IdxbranchstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idxbranchstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterIdxbranchstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitIdxbranchstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitIdxbranchstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdxbranchstmtContext idxbranchstmt() throws RecognitionException {
		IdxbranchstmtContext _localctx = new IdxbranchstmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_idxbranchstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(ON);
			setState(181);
			expression();
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==GOTO || _la==GOSUB) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(183);
				match(COMMA);
				setState(184);
				linenumber();
				}
				}
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
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

	public static class InputContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(OrbbasicParser.INPUT, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(OrbbasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OrbbasicParser.COMMA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(INPUT);
			setState(190);
			varname();
			setState(196);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(191);
				match(COMMA);
				setState(192);
				expression();
				setState(193);
				match(COMMA);
				setState(194);
				expression();
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

	public static class DelayContext extends ParserRuleContext {
		public TerminalNode DELAY() { return getToken(OrbbasicParser.DELAY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DelayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delay; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterDelay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitDelay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitDelay(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelayContext delay() throws RecognitionException {
		DelayContext _localctx = new DelayContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_delay);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(DELAY);
			setState(199);
			expression();
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

	public static class EndContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(OrbbasicParser.END, 0); }
		public EndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndContext end() throws RecognitionException {
		EndContext _localctx = new EndContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(END);
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

	public static class RgbContext extends ParserRuleContext {
		public TerminalNode RGB() { return getToken(OrbbasicParser.RGB, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OrbbasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OrbbasicParser.COMMA, i);
		}
		public RgbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rgb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterRgb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitRgb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitRgb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RgbContext rgb() throws RecognitionException {
		RgbContext _localctx = new RgbContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rgb);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(RGB);
			setState(204);
			expression();
			setState(205);
			match(COMMA);
			setState(206);
			expression();
			setState(207);
			match(COMMA);
			setState(208);
			expression();
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

	public static class LedcContext extends ParserRuleContext {
		public TerminalNode LEDC() { return getToken(OrbbasicParser.LEDC, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LedcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ledc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterLedc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitLedc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitLedc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LedcContext ledc() throws RecognitionException {
		LedcContext _localctx = new LedcContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ledc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(LEDC);
			setState(211);
			expression();
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

	public static class BackledContext extends ParserRuleContext {
		public TerminalNode BACKLED() { return getToken(OrbbasicParser.BACKLED, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BackledContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_backled; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterBackled(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitBackled(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitBackled(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BackledContext backled() throws RecognitionException {
		BackledContext _localctx = new BackledContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_backled);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(BACKLED);
			setState(214);
			expression();
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

	public static class RandomContext extends ParserRuleContext {
		public TerminalNode RANDOM() { return getToken(OrbbasicParser.RANDOM, 0); }
		public RandomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_random; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterRandom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitRandom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitRandom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RandomContext random() throws RecognitionException {
		RandomContext _localctx = new RandomContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_random);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(RANDOM);
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

	public static class GorollContext extends ParserRuleContext {
		public TerminalNode GOROLL() { return getToken(OrbbasicParser.GOROLL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OrbbasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OrbbasicParser.COMMA, i);
		}
		public GorollContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goroll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterGoroll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitGoroll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitGoroll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GorollContext goroll() throws RecognitionException {
		GorollContext _localctx = new GorollContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_goroll);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(GOROLL);
			setState(219);
			expression();
			setState(220);
			match(COMMA);
			setState(221);
			expression();
			setState(222);
			match(COMMA);
			setState(223);
			expression();
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

	public static class HeadingContext extends ParserRuleContext {
		public TerminalNode HEADING() { return getToken(OrbbasicParser.HEADING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public HeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitHeading(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitHeading(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadingContext heading() throws RecognitionException {
		HeadingContext _localctx = new HeadingContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_heading);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(HEADING);
			setState(226);
			expression();
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

	public static class RawContext extends ParserRuleContext {
		public TerminalNode RAW() { return getToken(OrbbasicParser.RAW, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OrbbasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OrbbasicParser.COMMA, i);
		}
		public RawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterRaw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitRaw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitRaw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RawContext raw() throws RecognitionException {
		RawContext _localctx = new RawContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_raw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(RAW);
			setState(229);
			expression();
			setState(230);
			match(COMMA);
			setState(231);
			expression();
			setState(232);
			match(COMMA);
			setState(233);
			expression();
			setState(234);
			match(COMMA);
			setState(235);
			expression();
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

	public static class LocateContext extends ParserRuleContext {
		public TerminalNode LOCATE() { return getToken(OrbbasicParser.LOCATE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(OrbbasicParser.COMMA, 0); }
		public LocateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterLocate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitLocate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitLocate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocateContext locate() throws RecognitionException {
		LocateContext _localctx = new LocateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_locate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(LOCATE);
			setState(238);
			expression();
			setState(239);
			match(COMMA);
			setState(240);
			expression();
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

	public static class BasflgContext extends ParserRuleContext {
		public TerminalNode BASFLG() { return getToken(OrbbasicParser.BASFLG, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BasflgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basflg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterBasflg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitBasflg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitBasflg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasflgContext basflg() throws RecognitionException {
		BasflgContext _localctx = new BasflgContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_basflg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(BASFLG);
			setState(243);
			expression();
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

	public static class DataContext extends ParserRuleContext {
		public TerminalNode DATA() { return getToken(OrbbasicParser.DATA, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OrbbasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OrbbasicParser.COMMA, i);
		}
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(DATA);
			setState(246);
			expression();
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(247);
				match(COMMA);
				setState(248);
				expression();
				}
				}
				setState(253);
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

	public static class RstrContext extends ParserRuleContext {
		public TerminalNode RSTR() { return getToken(OrbbasicParser.RSTR, 0); }
		public RstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rstr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterRstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitRstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitRstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RstrContext rstr() throws RecognitionException {
		RstrContext _localctx = new RstrContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_rstr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(RSTR);
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

	public static class ReadContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(OrbbasicParser.READ, 0); }
		public List<VardeclContext> vardecl() {
			return getRuleContexts(VardeclContext.class);
		}
		public VardeclContext vardecl(int i) {
			return getRuleContext(VardeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OrbbasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OrbbasicParser.COMMA, i);
		}
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_read);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(READ);
			setState(257);
			vardecl();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(258);
				match(COMMA);
				setState(259);
				vardecl();
				}
				}
				setState(264);
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

	public static class TronContext extends ParserRuleContext {
		public TerminalNode TRON() { return getToken(OrbbasicParser.TRON, 0); }
		public TronContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tron; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterTron(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitTron(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitTron(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TronContext tron() throws RecognitionException {
		TronContext _localctx = new TronContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_tron);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(TRON);
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

	public static class TroffContext extends ParserRuleContext {
		public TerminalNode TROFF() { return getToken(OrbbasicParser.TROFF, 0); }
		public TroffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_troff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterTroff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitTroff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitTroff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TroffContext troff() throws RecognitionException {
		TroffContext _localctx = new TroffContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_troff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(TROFF);
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

	public static class Reset_Context extends ParserRuleContext {
		public TerminalNode RESET() { return getToken(OrbbasicParser.RESET, 0); }
		public Reset_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reset_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterReset_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitReset_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitReset_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reset_Context reset_() throws RecognitionException {
		Reset_Context _localctx = new Reset_Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_reset_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(RESET);
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

	public static class SleepContext extends ParserRuleContext {
		public TerminalNode SLEEP() { return getToken(OrbbasicParser.SLEEP, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OrbbasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OrbbasicParser.COMMA, i);
		}
		public LinenumberContext linenumber() {
			return getRuleContext(LinenumberContext.class,0);
		}
		public SleepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sleep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterSleep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitSleep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitSleep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SleepContext sleep() throws RecognitionException {
		SleepContext _localctx = new SleepContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sleep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(SLEEP);
			setState(272);
			expression();
			setState(273);
			match(COMMA);
			setState(274);
			expression();
			setState(275);
			match(COMMA);
			setState(276);
			linenumber();
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

	public static class MacrunContext extends ParserRuleContext {
		public TerminalNode MACRUN() { return getToken(OrbbasicParser.MACRUN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MacrunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macrun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterMacrun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitMacrun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitMacrun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacrunContext macrun() throws RecognitionException {
		MacrunContext _localctx = new MacrunContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_macrun);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(MACRUN);
			setState(279);
			expression();
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

	public static class MackillContext extends ParserRuleContext {
		public TerminalNode MACKILL() { return getToken(OrbbasicParser.MACKILL, 0); }
		public MackillContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mackill; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterMackill(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitMackill(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitMackill(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MackillContext mackill() throws RecognitionException {
		MackillContext _localctx = new MackillContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_mackill);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(MACKILL);
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

	public static class MacstatContext extends ParserRuleContext {
		public TerminalNode MACSTAT() { return getToken(OrbbasicParser.MACSTAT, 0); }
		public MacstatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macstat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterMacstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitMacstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitMacstat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MacstatContext macstat() throws RecognitionException {
		MacstatContext _localctx = new MacstatContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_macstat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(MACSTAT);
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

	public static class VardeclContext extends ParserRuleContext {
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode SYSVARNAME() { return getToken(OrbbasicParser.SYSVARNAME, 0); }
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitVardecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitVardecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_vardecl);
		try {
			setState(287);
			switch (_input.LA(1)) {
			case VARLETTER:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				varname();
				}
				break;
			case SYSVARNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				match(SYSVARNAME);
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

	public static class VarnameContext extends ParserRuleContext {
		public TerminalNode VARLETTER() { return getToken(OrbbasicParser.VARLETTER, 0); }
		public VarnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterVarname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitVarname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitVarname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarnameContext varname() throws RecognitionException {
		VarnameContext _localctx = new VarnameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(VARLETTER);
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

	public static class VarassignContext extends ParserRuleContext {
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public TerminalNode EQ() { return getToken(OrbbasicParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varassign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterVarassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitVarassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitVarassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarassignContext varassign() throws RecognitionException {
		VarassignContext _localctx = new VarassignContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_varassign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			vardecl();
			setState(292);
			match(EQ);
			setState(293);
			expression();
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

	public static class NeqContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(OrbbasicParser.NOT, 0); }
		public NeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterNeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitNeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitNeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NeqContext neq() throws RecognitionException {
		NeqContext _localctx = new NeqContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_neq);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(NOT);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(OrbbasicParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(NUMBER);
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

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode STRINGLITERAL() { return getToken(OrbbasicParser.STRINGLITERAL, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public SqrtfuncContext sqrtfunc() {
			return getRuleContext(SqrtfuncContext.class,0);
		}
		public RndfuncContext rndfunc() {
			return getRuleContext(RndfuncContext.class,0);
		}
		public AbsfuncContext absfunc() {
			return getRuleContext(AbsfuncContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(OrbbasicParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OrbbasicParser.RPAREN, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_func);
		try {
			setState(309);
			switch (_input.LA(1)) {
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(STRINGLITERAL);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				number();
				}
				break;
			case SYSVARNAME:
			case VARLETTER:
				enterOuterAlt(_localctx, 3);
				{
				setState(301);
				vardecl();
				}
				break;
			case SQRT:
				enterOuterAlt(_localctx, 4);
				{
				setState(302);
				sqrtfunc();
				}
				break;
			case RND:
				enterOuterAlt(_localctx, 5);
				{
				setState(303);
				rndfunc();
				}
				break;
			case ABS:
				enterOuterAlt(_localctx, 6);
				{
				setState(304);
				absfunc();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 7);
				{
				setState(305);
				match(LPAREN);
				setState(306);
				expression();
				setState(307);
				match(RPAREN);
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

	public static class SqrtfuncContext extends ParserRuleContext {
		public TerminalNode SQRT() { return getToken(OrbbasicParser.SQRT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public SqrtfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqrtfunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterSqrtfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitSqrtfunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitSqrtfunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqrtfuncContext sqrtfunc() throws RecognitionException {
		SqrtfuncContext _localctx = new SqrtfuncContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_sqrtfunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(SQRT);
			setState(314);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(312);
				expression();
				}
				break;
			case 2:
				{
				setState(313);
				number();
				}
				break;
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

	public static class RndfuncContext extends ParserRuleContext {
		public TerminalNode RND() { return getToken(OrbbasicParser.RND, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public RndfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rndfunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterRndfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitRndfunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitRndfunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RndfuncContext rndfunc() throws RecognitionException {
		RndfuncContext _localctx = new RndfuncContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_rndfunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(RND);
			setState(319);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(317);
				expression();
				}
				break;
			case 2:
				{
				setState(318);
				number();
				}
				break;
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

	public static class AbsfuncContext extends ParserRuleContext {
		public TerminalNode ABS() { return getToken(OrbbasicParser.ABS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public AbsfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absfunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterAbsfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitAbsfunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitAbsfunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsfuncContext absfunc() throws RecognitionException {
		AbsfuncContext _localctx = new AbsfuncContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_absfunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(ABS);
			setState(324);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(322);
				expression();
				}
				break;
			case 2:
				{
				setState(323);
				number();
				}
				break;
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

	public static class SignExprContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode NOT() { return getToken(OrbbasicParser.NOT, 0); }
		public List<TerminalNode> PLUS() { return getTokens(OrbbasicParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(OrbbasicParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(OrbbasicParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(OrbbasicParser.MINUS, i);
		}
		public SignExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterSignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitSignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitSignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignExprContext signExpr() throws RecognitionException {
		SignExprContext _localctx = new SignExprContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_signExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(326);
				match(NOT);
				}
			}

			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(329);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
			func();
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

	public static class MultExprContext extends ParserRuleContext {
		public List<SignExprContext> signExpr() {
			return getRuleContexts(SignExprContext.class);
		}
		public SignExprContext signExpr(int i) {
			return getRuleContext(SignExprContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(OrbbasicParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(OrbbasicParser.TIMES, i);
		}
		public List<TerminalNode> DIV() { return getTokens(OrbbasicParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(OrbbasicParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(OrbbasicParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(OrbbasicParser.MOD, i);
		}
		public List<TerminalNode> BINSHL() { return getTokens(OrbbasicParser.BINSHL); }
		public TerminalNode BINSHL(int i) {
			return getToken(OrbbasicParser.BINSHL, i);
		}
		public List<TerminalNode> BINSHR() { return getTokens(OrbbasicParser.BINSHR); }
		public TerminalNode BINSHR(int i) {
			return getToken(OrbbasicParser.BINSHR, i);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_multExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			signExpr();
			setState(342);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(338);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << MOD) | (1L << BINSHL) | (1L << BINSHR))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(339);
					signExpr();
					}
					} 
				}
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class AddExprContext extends ParserRuleContext {
		public List<MultExprContext> multExpr() {
			return getRuleContexts(MultExprContext.class);
		}
		public MultExprContext multExpr(int i) {
			return getRuleContext(MultExprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(OrbbasicParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(OrbbasicParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(OrbbasicParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(OrbbasicParser.MINUS, i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_addExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			multExpr();
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(346);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(347);
					multExpr();
					}
					} 
				}
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class RelExprContext extends ParserRuleContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(OrbbasicParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(OrbbasicParser.GT, i);
		}
		public List<TerminalNode> LT() { return getTokens(OrbbasicParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(OrbbasicParser.LT, i);
		}
		public List<TerminalNode> EQ() { return getTokens(OrbbasicParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(OrbbasicParser.EQ, i);
		}
		public List<NeqContext> neq() {
			return getRuleContexts(NeqContext.class);
		}
		public NeqContext neq(int i) {
			return getRuleContext(NeqContext.class,i);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitRelExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitRelExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_relExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			addExpr();
			setState(363);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(358);
					switch (_input.LA(1)) {
					case GT:
						{
						setState(354);
						match(GT);
						}
						break;
					case LT:
						{
						setState(355);
						match(LT);
						}
						break;
					case EQ:
						{
						setState(356);
						match(EQ);
						}
						break;
					case NOT:
						{
						setState(357);
						neq();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(360);
					addExpr();
					}
					} 
				}
				setState(365);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class ExpressionContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public List<RelExprContext> relExpr() {
			return getRuleContexts(RelExprContext.class);
		}
		public RelExprContext relExpr(int i) {
			return getRuleContext(RelExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(OrbbasicParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(OrbbasicParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(OrbbasicParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(OrbbasicParser.OR, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OrbbasicListener ) ((OrbbasicListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OrbbasicVisitor ) return ((OrbbasicVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_expression);
		int _la;
		try {
			int _alt;
			setState(375);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				func();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(367);
				relExpr();
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(368);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(369);
						relExpr();
						}
						} 
					}
					setState(374);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u017c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\6\2b\n\2\r\2\16\2c\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\5\3l\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5\u008d\n\5\3\6\3\6\5\6\u0091\n\6\3\7\3\7\5\7\u0095\n\7\3\7\7\7"+
		"\u0098\n\7\f\7\16\7\u009b\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a3\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ab\n\t\3\n\3\n\5\n\u00af\n\n\3\13\3\13\3"+
		"\13\3\13\5\13\u00b5\n\13\3\f\3\f\3\f\3\f\3\f\6\f\u00bc\n\f\r\f\16\f\u00bd"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c7\n\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\7\31\u00fc\n\31\f\31\16\31\u00ff\13\31\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\7\33\u0107\n\33\f\33\16\33\u010a\13\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3"+
		"\"\3\"\3#\3#\5#\u0122\n#\3$\3$\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\5(\u0138\n(\3)\3)\3)\5)\u013d\n)\3*\3*\3*\5*\u0142\n"+
		"*\3+\3+\3+\5+\u0147\n+\3,\5,\u014a\n,\3,\7,\u014d\n,\f,\16,\u0150\13,"+
		"\3,\3,\3-\3-\3-\7-\u0157\n-\f-\16-\u015a\13-\3.\3.\3.\7.\u015f\n.\f.\16"+
		".\u0162\13.\3/\3/\3/\3/\3/\5/\u0169\n/\3/\7/\u016c\n/\f/\16/\u016f\13"+
		"/\3\60\3\60\3\60\3\60\7\60\u0175\n\60\f\60\16\60\u0178\13\60\5\60\u017a"+
		"\n\60\3\60\2\2\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^\2\7\4\2  ##\3\2\34\35\3\2\f\r\4\2\t\13\16"+
		"\17\3\2\7\b\u0189\2a\3\2\2\2\4k\3\2\2\2\6m\3\2\2\2\b\u008c\3\2\2\2\n\u008e"+
		"\3\2\2\2\f\u0092\3\2\2\2\16\u009c\3\2\2\2\20\u00a4\3\2\2\2\22\u00ac\3"+
		"\2\2\2\24\u00b4\3\2\2\2\26\u00b6\3\2\2\2\30\u00bf\3\2\2\2\32\u00c8\3\2"+
		"\2\2\34\u00cb\3\2\2\2\36\u00cd\3\2\2\2 \u00d4\3\2\2\2\"\u00d7\3\2\2\2"+
		"$\u00da\3\2\2\2&\u00dc\3\2\2\2(\u00e3\3\2\2\2*\u00e6\3\2\2\2,\u00ef\3"+
		"\2\2\2.\u00f4\3\2\2\2\60\u00f7\3\2\2\2\62\u0100\3\2\2\2\64\u0102\3\2\2"+
		"\2\66\u010b\3\2\2\28\u010d\3\2\2\2:\u010f\3\2\2\2<\u0111\3\2\2\2>\u0118"+
		"\3\2\2\2@\u011b\3\2\2\2B\u011d\3\2\2\2D\u0121\3\2\2\2F\u0123\3\2\2\2H"+
		"\u0125\3\2\2\2J\u0129\3\2\2\2L\u012b\3\2\2\2N\u0137\3\2\2\2P\u0139\3\2"+
		"\2\2R\u013e\3\2\2\2T\u0143\3\2\2\2V\u0149\3\2\2\2X\u0153\3\2\2\2Z\u015b"+
		"\3\2\2\2\\\u0163\3\2\2\2^\u0179\3\2\2\2`b\5\4\3\2a`\3\2\2\2bc\3\2\2\2"+
		"ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\2\2\3f\3\3\2\2\2gh\5\6\4\2hi\5\b\5"+
		"\2il\3\2\2\2jl\7=\2\2kg\3\2\2\2kj\3\2\2\2l\5\3\2\2\2mn\7?\2\2n\7\3\2\2"+
		"\2o\u008d\5\n\6\2p\u008d\5\16\b\2q\u008d\5\20\t\2r\u008d\5\22\n\2s\u008d"+
		"\5\24\13\2t\u008d\5\26\f\2u\u008d\5\30\r\2v\u008d\5\32\16\2w\u008d\5\34"+
		"\17\2x\u008d\5\36\20\2y\u008d\5 \21\2z\u008d\5\"\22\2{\u008d\5$\23\2|"+
		"\u008d\5&\24\2}\u008d\5(\25\2~\u008d\5*\26\2\177\u008d\5,\27\2\u0080\u008d"+
		"\5.\30\2\u0081\u008d\5\60\31\2\u0082\u008d\5\62\32\2\u0083\u008d\5\64"+
		"\33\2\u0084\u008d\5\66\34\2\u0085\u008d\58\35\2\u0086\u008d\5:\36\2\u0087"+
		"\u008d\5<\37\2\u0088\u008d\5> \2\u0089\u008d\5@!\2\u008a\u008d\5B\"\2"+
		"\u008b\u008d\5H%\2\u008co\3\2\2\2\u008cp\3\2\2\2\u008cq\3\2\2\2\u008c"+
		"r\3\2\2\2\u008cs\3\2\2\2\u008ct\3\2\2\2\u008cu\3\2\2\2\u008cv\3\2\2\2"+
		"\u008cw\3\2\2\2\u008cx\3\2\2\2\u008cy\3\2\2\2\u008cz\3\2\2\2\u008c{\3"+
		"\2\2\2\u008c|\3\2\2\2\u008c}\3\2\2\2\u008c~\3\2\2\2\u008c\177\3\2\2\2"+
		"\u008c\u0080\3\2\2\2\u008c\u0081\3\2\2\2\u008c\u0082\3\2\2\2\u008c\u0083"+
		"\3\2\2\2\u008c\u0084\3\2\2\2\u008c\u0085\3\2\2\2\u008c\u0086\3\2\2\2\u008c"+
		"\u0087\3\2\2\2\u008c\u0088\3\2\2\2\u008c\u0089\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008b\3\2\2\2\u008d\t\3\2\2\2\u008e\u0090\t\2\2\2\u008f\u0091"+
		"\5\f\7\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\13\3\2\2\2\u0092"+
		"\u0094\5^\60\2\u0093\u0095\7\37\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3"+
		"\2\2\2\u0095\u0099\3\2\2\2\u0096\u0098\5\f\7\2\u0097\u0096\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\r\3\2\2\2"+
		"\u009b\u0099\3\2\2\2\u009c\u009d\7\25\2\2\u009d\u009e\5^\60\2\u009e\u009f"+
		"\7\26\2\2\u009f\u00a2\5\b\5\2\u00a0\u00a1\7\27\2\2\u00a1\u00a3\5\b\5\2"+
		"\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\17\3\2\2\2\u00a4\u00a5"+
		"\7\30\2\2\u00a5\u00a6\5H%\2\u00a6\u00a7\7\31\2\2\u00a7\u00aa\5^\60\2\u00a8"+
		"\u00a9\7\32\2\2\u00a9\u00ab\5^\60\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\21\3\2\2\2\u00ac\u00ae\7\33\2\2\u00ad\u00af\5D#\2\u00ae\u00ad"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\23\3\2\2\2\u00b0\u00b1\7\34\2\2\u00b1"+
		"\u00b5\5\6\4\2\u00b2\u00b3\7\35\2\2\u00b3\u00b5\5\6\4\2\u00b4\u00b0\3"+
		"\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\25\3\2\2\2\u00b6\u00b7\7\36\2\2\u00b7"+
		"\u00b8\5^\60\2\u00b8\u00bb\t\3\2\2\u00b9\u00ba\7\37\2\2\u00ba\u00bc\5"+
		"\6\4\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\27\3\2\2\2\u00bf\u00c0\7$\2\2\u00c0\u00c6\5F$\2\u00c1"+
		"\u00c2\7\37\2\2\u00c2\u00c3\5^\60\2\u00c3\u00c4\7\37\2\2\u00c4\u00c5\5"+
		"^\60\2\u00c5\u00c7\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\31\3\2\2\2\u00c8\u00c9\7%\2\2\u00c9\u00ca\5^\60\2\u00ca\33\3\2\2\2\u00cb"+
		"\u00cc\7&\2\2\u00cc\35\3\2\2\2\u00cd\u00ce\7\'\2\2\u00ce\u00cf\5^\60\2"+
		"\u00cf\u00d0\7\37\2\2\u00d0\u00d1\5^\60\2\u00d1\u00d2\7\37\2\2\u00d2\u00d3"+
		"\5^\60\2\u00d3\37\3\2\2\2\u00d4\u00d5\7(\2\2\u00d5\u00d6\5^\60\2\u00d6"+
		"!\3\2\2\2\u00d7\u00d8\7)\2\2\u00d8\u00d9\5^\60\2\u00d9#\3\2\2\2\u00da"+
		"\u00db\7*\2\2\u00db%\3\2\2\2\u00dc\u00dd\7+\2\2\u00dd\u00de\5^\60\2\u00de"+
		"\u00df\7\37\2\2\u00df\u00e0\5^\60\2\u00e0\u00e1\7\37\2\2\u00e1\u00e2\5"+
		"^\60\2\u00e2\'\3\2\2\2\u00e3\u00e4\7,\2\2\u00e4\u00e5\5^\60\2\u00e5)\3"+
		"\2\2\2\u00e6\u00e7\7-\2\2\u00e7\u00e8\5^\60\2\u00e8\u00e9\7\37\2\2\u00e9"+
		"\u00ea\5^\60\2\u00ea\u00eb\7\37\2\2\u00eb\u00ec\5^\60\2\u00ec\u00ed\7"+
		"\37\2\2\u00ed\u00ee\5^\60\2\u00ee+\3\2\2\2\u00ef\u00f0\7.\2\2\u00f0\u00f1"+
		"\5^\60\2\u00f1\u00f2\7\37\2\2\u00f2\u00f3\5^\60\2\u00f3-\3\2\2\2\u00f4"+
		"\u00f5\7/\2\2\u00f5\u00f6\5^\60\2\u00f6/\3\2\2\2\u00f7\u00f8\7\60\2\2"+
		"\u00f8\u00fd\5^\60\2\u00f9\u00fa\7\37\2\2\u00fa\u00fc\5^\60\2\u00fb\u00f9"+
		"\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"\61\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7\61\2\2\u0101\63\3\2\2\2"+
		"\u0102\u0103\7\62\2\2\u0103\u0108\5D#\2\u0104\u0105\7\37\2\2\u0105\u0107"+
		"\5D#\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\65\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7\63\2"+
		"\2\u010c\67\3\2\2\2\u010d\u010e\7\64\2\2\u010e9\3\2\2\2\u010f\u0110\7"+
		"\65\2\2\u0110;\3\2\2\2\u0111\u0112\7\66\2\2\u0112\u0113\5^\60\2\u0113"+
		"\u0114\7\37\2\2\u0114\u0115\5^\60\2\u0115\u0116\7\37\2\2\u0116\u0117\5"+
		"\6\4\2\u0117=\3\2\2\2\u0118\u0119\7\67\2\2\u0119\u011a\5^\60\2\u011a?"+
		"\3\2\2\2\u011b\u011c\78\2\2\u011cA\3\2\2\2\u011d\u011e\79\2\2\u011eC\3"+
		"\2\2\2\u011f\u0122\5F$\2\u0120\u0122\7:\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0120\3\2\2\2\u0122E\3\2\2\2\u0123\u0124\7;\2\2\u0124G\3\2\2\2\u0125"+
		"\u0126\5D#\2\u0126\u0127\7\5\2\2\u0127\u0128\5^\60\2\u0128I\3\2\2\2\u0129"+
		"\u012a\7\6\2\2\u012aK\3\2\2\2\u012b\u012c\7?\2\2\u012cM\3\2\2\2\u012d"+
		"\u0138\7>\2\2\u012e\u0138\5L\'\2\u012f\u0138\5D#\2\u0130\u0138\5P)\2\u0131"+
		"\u0138\5R*\2\u0132\u0138\5T+\2\u0133\u0134\7!\2\2\u0134\u0135\5^\60\2"+
		"\u0135\u0136\7\"\2\2\u0136\u0138\3\2\2\2\u0137\u012d\3\2\2\2\u0137\u012e"+
		"\3\2\2\2\u0137\u012f\3\2\2\2\u0137\u0130\3\2\2\2\u0137\u0131\3\2\2\2\u0137"+
		"\u0132\3\2\2\2\u0137\u0133\3\2\2\2\u0138O\3\2\2\2\u0139\u013c\7\22\2\2"+
		"\u013a\u013d\5^\60\2\u013b\u013d\5L\'\2\u013c\u013a\3\2\2\2\u013c\u013b"+
		"\3\2\2\2\u013dQ\3\2\2\2\u013e\u0141\7\23\2\2\u013f\u0142\5^\60\2\u0140"+
		"\u0142\5L\'\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142S\3\2\2\2\u0143"+
		"\u0146\7\24\2\2\u0144\u0147\5^\60\2\u0145\u0147\5L\'\2\u0146\u0144\3\2"+
		"\2\2\u0146\u0145\3\2\2\2\u0147U\3\2\2\2\u0148\u014a\7\6\2\2\u0149\u0148"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014e\3\2\2\2\u014b\u014d\t\4\2\2\u014c"+
		"\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\5N(\2\u0152W"+
		"\3\2\2\2\u0153\u0158\5V,\2\u0154\u0155\t\5\2\2\u0155\u0157\5V,\2\u0156"+
		"\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159Y\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u0160\5X-\2\u015c\u015d"+
		"\t\4\2\2\u015d\u015f\5X-\2\u015e\u015c\3\2\2\2\u015f\u0162\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161[\3\2\2\2\u0162\u0160\3\2\2\2"+
		"\u0163\u016d\5Z.\2\u0164\u0169\7\3\2\2\u0165\u0169\7\4\2\2\u0166\u0169"+
		"\7\5\2\2\u0167\u0169\5J&\2\u0168\u0164\3\2\2\2\u0168\u0165\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016c\5Z"+
		".\2\u016b\u0168\3\2\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e]\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u017a\5N(\2\u0171"+
		"\u0176\5\\/\2\u0172\u0173\t\6\2\2\u0173\u0175\5\\/\2\u0174\u0172\3\2\2"+
		"\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u017a"+
		"\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u0170\3\2\2\2\u0179\u0171\3\2\2\2\u017a"+
		"_\3\2\2\2\35ck\u008c\u0090\u0094\u0099\u00a2\u00aa\u00ae\u00b4\u00bd\u00c6"+
		"\u00fd\u0108\u0121\u0137\u013c\u0141\u0146\u0149\u014e\u0158\u0160\u0168"+
		"\u016d\u0176\u0179";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}