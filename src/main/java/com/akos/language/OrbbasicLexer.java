// Generated from D:/Ákos/Dropbox/bcpraca3/src/main/java/com/akos/language\Orbbasic.g4 by ANTLR 4.5.1
package com.akos.language;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OrbbasicLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"GT", "LT", "EQ", "NOT", "AND", "OR", "TIMES", "DIV", "MOD", "PLUS", "MINUS", 
		"BINSHL", "BINSHR", "BINAND", "BINOR", "SQRT", "RND", "ABS", "IF", "THEN", 
		"ELSE", "FOR", "TO", "STEP", "NEXT", "GOTO", "GOSUB", "ON", "COMMA", "QMARK", 
		"LPAREN", "RPAREN", "PRINT", "INPUT", "DELAY", "END", "RGB", "LEDC", "BACKLED", 
		"RANDOM", "GOROLL", "HEADING", "RAW", "LOCATE", "BASFLG", "DATA", "RSTR", 
		"READ", "TRON", "TROFF", "RESET", "SLEEP", "MACRUN", "MACKILL", "MACSTAT", 
		"SYSVARNAME", "VARLETTER", "LISTLETTER", "CHAR", "COMMENT", "DIGIT", "STRINGLITERAL", 
		"NUMBER", "WS"
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


	public OrbbasicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Orbbasic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2@\u01ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)"+
		"\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3-\3-\3-\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38"+
		"\38\38\38\38\38\38\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\59\u01a4\n9\39\39\39\39"+
		"\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39\39"+
		"\59\u01c1\n9\3:\5:\u01c4\n:\3;\3;\3<\3<\3=\3=\7=\u01cc\n=\f=\16=\u01cf"+
		"\13=\3>\3>\3?\3?\7?\u01d5\n?\f?\16?\u01d8\13?\3?\3?\3@\6@\u01dd\n@\r@"+
		"\16@\u01de\3@\3@\7@\u01e3\n@\f@\16@\u01e6\13@\3A\6A\u01e9\nA\rA\16A\u01ea"+
		"\3A\3A\2\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w\2y={\2}>\177?\u0081@\3\2\n\3\2CE\3\2Z\\\4\2UUXX\3"+
		"\2z{\4\2C[c{\5\2\f\f\17\17$$\4\2GGgg\5\2\13\f\17\17\"\"\u01ff\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3"+
		"\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2y\3\2\2\2\2}\3\2\2\2\2\177\3"+
		"\2\2\2\2\u0081\3\2\2\2\3\u0083\3\2\2\2\5\u0085\3\2\2\2\7\u0087\3\2\2\2"+
		"\t\u0089\3\2\2\2\13\u008b\3\2\2\2\r\u008f\3\2\2\2\17\u0092\3\2\2\2\21"+
		"\u0094\3\2\2\2\23\u0096\3\2\2\2\25\u0098\3\2\2\2\27\u009a\3\2\2\2\31\u009c"+
		"\3\2\2\2\33\u009e\3\2\2\2\35\u00a0\3\2\2\2\37\u00a2\3\2\2\2!\u00a4\3\2"+
		"\2\2#\u00a9\3\2\2\2%\u00ad\3\2\2\2\'\u00b1\3\2\2\2)\u00b4\3\2\2\2+\u00b9"+
		"\3\2\2\2-\u00be\3\2\2\2/\u00c2\3\2\2\2\61\u00c5\3\2\2\2\63\u00ca\3\2\2"+
		"\2\65\u00cf\3\2\2\2\67\u00d4\3\2\2\29\u00da\3\2\2\2;\u00dd\3\2\2\2=\u00df"+
		"\3\2\2\2?\u00e1\3\2\2\2A\u00e3\3\2\2\2C\u00e5\3\2\2\2E\u00eb\3\2\2\2G"+
		"\u00f1\3\2\2\2I\u00f7\3\2\2\2K\u00fb\3\2\2\2M\u00ff\3\2\2\2O\u0104\3\2"+
		"\2\2Q\u010c\3\2\2\2S\u0113\3\2\2\2U\u011a\3\2\2\2W\u0122\3\2\2\2Y\u0126"+
		"\3\2\2\2[\u012d\3\2\2\2]\u012f\3\2\2\2_\u0134\3\2\2\2a\u0139\3\2\2\2c"+
		"\u013e\3\2\2\2e\u0143\3\2\2\2g\u0149\3\2\2\2i\u014f\3\2\2\2k\u0155\3\2"+
		"\2\2m\u015c\3\2\2\2o\u0164\3\2\2\2q\u01c0\3\2\2\2s\u01c3\3\2\2\2u\u01c5"+
		"\3\2\2\2w\u01c7\3\2\2\2y\u01c9\3\2\2\2{\u01d0\3\2\2\2}\u01d2\3\2\2\2\177"+
		"\u01dc\3\2\2\2\u0081\u01e8\3\2\2\2\u0083\u0084\7@\2\2\u0084\4\3\2\2\2"+
		"\u0085\u0086\7>\2\2\u0086\6\3\2\2\2\u0087\u0088\7?\2\2\u0088\b\3\2\2\2"+
		"\u0089\u008a\7#\2\2\u008a\n\3\2\2\2\u008b\u008c\7c\2\2\u008c\u008d\7p"+
		"\2\2\u008d\u008e\7f\2\2\u008e\f\3\2\2\2\u008f\u0090\7q\2\2\u0090\u0091"+
		"\7t\2\2\u0091\16\3\2\2\2\u0092\u0093\7,\2\2\u0093\20\3\2\2\2\u0094\u0095"+
		"\7\61\2\2\u0095\22\3\2\2\2\u0096\u0097\7\'\2\2\u0097\24\3\2\2\2\u0098"+
		"\u0099\7-\2\2\u0099\26\3\2\2\2\u009a\u009b\7/\2\2\u009b\30\3\2\2\2\u009c"+
		"\u009d\7}\2\2\u009d\32\3\2\2\2\u009e\u009f\7\177\2\2\u009f\34\3\2\2\2"+
		"\u00a0\u00a1\7(\2\2\u00a1\36\3\2\2\2\u00a2\u00a3\7~\2\2\u00a3 \3\2\2\2"+
		"\u00a4\u00a5\7u\2\2\u00a5\u00a6\7s\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8"+
		"\7v\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac"+
		"\7f\2\2\u00ac$\3\2\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7d\2\2\u00af\u00b0"+
		"\7u\2\2\u00b0&\3\2\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7h\2\2\u00b3(\3"+
		"\2\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7j\2\2\u00b6\u00b7\7g\2\2\u00b7"+
		"\u00b8\7p\2\2\u00b8*\3\2\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7n\2\2\u00bb"+
		"\u00bc\7u\2\2\u00bc\u00bd\7g\2\2\u00bd,\3\2\2\2\u00be\u00bf\7h\2\2\u00bf"+
		"\u00c0\7q\2\2\u00c0\u00c1\7t\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7v\2\2\u00c3"+
		"\u00c4\7q\2\2\u00c4\60\3\2\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7v\2\2\u00c7"+
		"\u00c8\7g\2\2\u00c8\u00c9\7r\2\2\u00c9\62\3\2\2\2\u00ca\u00cb\7p\2\2\u00cb"+
		"\u00cc\7g\2\2\u00cc\u00cd\7z\2\2\u00cd\u00ce\7v\2\2\u00ce\64\3\2\2\2\u00cf"+
		"\u00d0\7i\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7q\2\2"+
		"\u00d3\66\3\2\2\2\u00d4\u00d5\7i\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7"+
		"u\2\2\u00d7\u00d8\7w\2\2\u00d8\u00d9\7d\2\2\u00d98\3\2\2\2\u00da\u00db"+
		"\7q\2\2\u00db\u00dc\7p\2\2\u00dc:\3\2\2\2\u00dd\u00de\7.\2\2\u00de<\3"+
		"\2\2\2\u00df\u00e0\7A\2\2\u00e0>\3\2\2\2\u00e1\u00e2\7*\2\2\u00e2@\3\2"+
		"\2\2\u00e3\u00e4\7+\2\2\u00e4B\3\2\2\2\u00e5\u00e6\7r\2\2\u00e6\u00e7"+
		"\7t\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea\7v\2\2\u00ea"+
		"D\3\2\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7p\2\2\u00ed\u00ee\7r\2\2\u00ee"+
		"\u00ef\7w\2\2\u00ef\u00f0\7v\2\2\u00f0F\3\2\2\2\u00f1\u00f2\7f\2\2\u00f2"+
		"\u00f3\7g\2\2\u00f3\u00f4\7n\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7{\2\2"+
		"\u00f6H\3\2\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7f\2"+
		"\2\u00faJ\3\2\2\2\u00fb\u00fc\7T\2\2\u00fc\u00fd\7I\2\2\u00fd\u00fe\7"+
		"D\2\2\u00feL\3\2\2\2\u00ff\u0100\7N\2\2\u0100\u0101\7G\2\2\u0101\u0102"+
		"\7F\2\2\u0102\u0103\7E\2\2\u0103N\3\2\2\2\u0104\u0105\7d\2\2\u0105\u0106"+
		"\7c\2\2\u0106\u0107\7e\2\2\u0107\u0108\7m\2\2\u0108\u0109\7N\2\2\u0109"+
		"\u010a\7G\2\2\u010a\u010b\7F\2\2\u010bP\3\2\2\2\u010c\u010d\7t\2\2\u010d"+
		"\u010e\7c\2\2\u010e\u010f\7p\2\2\u010f\u0110\7f\2\2\u0110\u0111\7q\2\2"+
		"\u0111\u0112\7o\2\2\u0112R\3\2\2\2\u0113\u0114\7i\2\2\u0114\u0115\7q\2"+
		"\2\u0115\u0116\7t\2\2\u0116\u0117\7q\2\2\u0117\u0118\7n\2\2\u0118\u0119"+
		"\7n\2\2\u0119T\3\2\2\2\u011a\u011b\7j\2\2\u011b\u011c\7g\2\2\u011c\u011d"+
		"\7c\2\2\u011d\u011e\7f\2\2\u011e\u011f\7k\2\2\u011f\u0120\7p\2\2\u0120"+
		"\u0121\7i\2\2\u0121V\3\2\2\2\u0122\u0123\7t\2\2\u0123\u0124\7c\2\2\u0124"+
		"\u0125\7y\2\2\u0125X\3\2\2\2\u0126\u0127\7n\2\2\u0127\u0128\7q\2\2\u0128"+
		"\u0129\7e\2\2\u0129\u012a\7c\2\2\u012a\u012b\7v\2\2\u012b\u012c\7g\2\2"+
		"\u012cZ\3\2\2\2\u012d\u012e\7z\2\2\u012e\\\3\2\2\2\u012f\u0130\7f\2\2"+
		"\u0130\u0131\7c\2\2\u0131\u0132\7v\2\2\u0132\u0133\7c\2\2\u0133^\3\2\2"+
		"\2\u0134\u0135\7t\2\2\u0135\u0136\7u\2\2\u0136\u0137\7v\2\2\u0137\u0138"+
		"\7t\2\2\u0138`\3\2\2\2\u0139\u013a\7t\2\2\u013a\u013b\7g\2\2\u013b\u013c"+
		"\7c\2\2\u013c\u013d\7f\2\2\u013db\3\2\2\2\u013e\u013f\7v\2\2\u013f\u0140"+
		"\7t\2\2\u0140\u0141\7q\2\2\u0141\u0142\7p\2\2\u0142d\3\2\2\2\u0143\u0144"+
		"\7v\2\2\u0144\u0145\7t\2\2\u0145\u0146\7q\2\2\u0146\u0147\7h\2\2\u0147"+
		"\u0148\7h\2\2\u0148f\3\2\2\2\u0149\u014a\7t\2\2\u014a\u014b\7g\2\2\u014b"+
		"\u014c\7u\2\2\u014c\u014d\7g\2\2\u014d\u014e\7v\2\2\u014eh\3\2\2\2\u014f"+
		"\u0150\7u\2\2\u0150\u0151\7n\2\2\u0151\u0152\7g\2\2\u0152\u0153\7g\2\2"+
		"\u0153\u0154\7r\2\2\u0154j\3\2\2\2\u0155\u0156\7o\2\2\u0156\u0157\7c\2"+
		"\2\u0157\u0158\7e\2\2\u0158\u0159\7t\2\2\u0159\u015a\7w\2\2\u015a\u015b"+
		"\7p\2\2\u015bl\3\2\2\2\u015c\u015d\7o\2\2\u015d\u015e\7c\2\2\u015e\u015f"+
		"\7e\2\2\u015f\u0160\7m\2\2\u0160\u0161\7k\2\2\u0161\u0162\7n\2\2\u0162"+
		"\u0163\7n\2\2\u0163n\3\2\2\2\u0164\u0165\7o\2\2\u0165\u0166\7c\2\2\u0166"+
		"\u0167\7e\2\2\u0167\u0168\7u\2\2\u0168\u0169\7v\2\2\u0169\u016a\7c\2\2"+
		"\u016a\u016b\7v\2\2\u016bp\3\2\2\2\u016c\u016d\7v\2\2\u016d\u016e\7k\2"+
		"\2\u016e\u016f\7o\2\2\u016f\u0170\7g\2\2\u0170\u0171\7t\2\2\u0171\u0172"+
		"\3\2\2\2\u0172\u01c1\t\2\2\2\u0173\u0174\7e\2\2\u0174\u0175\7v\2\2\u0175"+
		"\u0176\7t\2\2\u0176\u01c1\7n\2\2\u0177\u0178\7u\2\2\u0178\u0179\7r\2\2"+
		"\u0179\u017a\7g\2\2\u017a\u017b\7g\2\2\u017b\u01c1\7f\2\2\u017c\u017d"+
		"\7{\2\2\u017d\u017e\7c\2\2\u017e\u01c1\7y\2\2\u017f\u0180\7r\2\2\u0180"+
		"\u0181\7k\2\2\u0181\u0182\7v\2\2\u0182\u0183\7e\2\2\u0183\u01c1\7j\2\2"+
		"\u0184\u0185\7t\2\2\u0185\u0186\7q\2\2\u0186\u0187\7n\2\2\u0187\u01c1"+
		"\7n\2\2\u0188\u0189\7c\2\2\u0189\u018a\7e\2\2\u018a\u018b\7e\2\2\u018b"+
		"\u018c\7g\2\2\u018c\u018d\7n\2\2\u018d\u018e\3\2\2\2\u018e\u01c1\t\3\2"+
		"\2\u018f\u0190\7i\2\2\u0190\u0191\7{\2\2\u0191\u0192\7t\2\2\u0192\u0193"+
		"\7q\2\2\u0193\u0194\3\2\2\2\u0194\u01c1\t\3\2\2\u0195\u0196\t\4\2\2\u0196"+
		"\u0197\7d\2\2\u0197\u0198\7c\2\2\u0198\u0199\7v\2\2\u0199\u01c1\7v\2\2"+
		"\u019a\u019b\7e\2\2\u019b\u019c\7o\2\2\u019c\u01a4\7f\2\2\u019d\u019e"+
		"\7u\2\2\u019e\u019f\7r\2\2\u019f\u01a4\7f\2\2\u01a0\u01a1\7j\2\2\u01a1"+
		"\u01a2\7f\2\2\u01a2\u01a4\7i\2\2\u01a3\u019a\3\2\2\2\u01a3\u019d\3\2\2"+
		"\2\u01a3\u01a0\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\7x\2\2\u01a6\u01a7"+
		"\7c\2\2\u01a7\u01c1\7n\2\2\u01a8\u01a9\7k\2\2\u01a9\u01aa\7u\2\2\u01aa"+
		"\u01ab\7e\2\2\u01ab\u01ac\7q\2\2\u01ac\u01ad\7p\2\2\u01ad\u01c1\7p\2\2"+
		"\u01ae\u01af\7f\2\2\u01af\u01b0\7u\2\2\u01b0\u01b1\7j\2\2\u01b1\u01b2"+
		"\7c\2\2\u01b2\u01b3\7m\2\2\u01b3\u01c1\7g\2\2\u01b4\u01b5\7c\2\2\u01b5"+
		"\u01b6\7e\2\2\u01b6\u01b7\7e\2\2\u01b7\u01b8\7g\2\2\u01b8\u01b9\7n\2\2"+
		"\u01b9\u01ba\7q\2\2\u01ba\u01bb\7p\2\2\u01bb\u01c1\7g\2\2\u01bc\u01bd"+
		"\t\5\2\2\u01bd\u01be\7r\2\2\u01be\u01bf\7q\2\2\u01bf\u01c1\7u\2\2\u01c0"+
		"\u016c\3\2\2\2\u01c0\u0173\3\2\2\2\u01c0\u0177\3\2\2\2\u01c0\u017c\3\2"+
		"\2\2\u01c0\u017f\3\2\2\2\u01c0\u0184\3\2\2\2\u01c0\u0188\3\2\2\2\u01c0"+
		"\u018f\3\2\2\2\u01c0\u0195\3\2\2\2\u01c0\u01a3\3\2\2\2\u01c0\u01a8\3\2"+
		"\2\2\u01c0\u01ae\3\2\2\2\u01c0\u01b4\3\2\2\2\u01c0\u01bc\3\2\2\2\u01c1"+
		"r\3\2\2\2\u01c2\u01c4\t\6\2\2\u01c3\u01c2\3\2\2\2\u01c4t\3\2\2\2\u01c5"+
		"\u01c6\7\\\2\2\u01c6v\3\2\2\2\u01c7\u01c8\n\7\2\2\u01c8x\3\2\2\2\u01c9"+
		"\u01cd\7^\2\2\u01ca\u01cc\5w<\2\u01cb\u01ca\3\2\2\2\u01cc\u01cf\3\2\2"+
		"\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01cez\3\2\2\2\u01cf\u01cd"+
		"\3\2\2\2\u01d0\u01d1\4\62;\2\u01d1|\3\2\2\2\u01d2\u01d6\7$\2\2\u01d3\u01d5"+
		"\n\7\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u01d9\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01da\7$"+
		"\2\2\u01da~\3\2\2\2\u01db\u01dd\5{>\2\u01dc\u01db\3\2\2\2\u01dd\u01de"+
		"\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e4\3\2\2\2\u01e0"+
		"\u01e1\t\b\2\2\u01e1\u01e3\5\177@\2\u01e2\u01e0\3\2\2\2\u01e3\u01e6\3"+
		"\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e5\3\2\2\2\u01e5\u0080\3\2\2\2\u01e6"+
		"\u01e4\3\2\2\2\u01e7\u01e9\t\t\2\2\u01e8\u01e7\3\2\2\2\u01e9\u01ea\3\2"+
		"\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec"+
		"\u01ed\bA\2\2\u01ed\u0082\3\2\2\2\13\2\u01a3\u01c0\u01c3\u01cd\u01d6\u01de"+
		"\u01e4\u01ea\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}