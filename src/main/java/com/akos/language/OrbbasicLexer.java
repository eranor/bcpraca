// Generated from D:/projects/java/bcpraca3/src/main/java/com/akos/language\Orbbasic.g4 by ANTLR 4.5.1
package com.akos.language;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OrbbasicLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            GT = 1, LT = 2, EQ = 3, NOT = 4, AND = 5, OR = 6, TIMES = 7, DIV = 8, MOD = 9, PLUS = 10,
            MINUS = 11, BINSHL = 12, BINSHR = 13, BINAND = 14, BINOR = 15, SQRT = 16, RND = 17,
            ABS = 18, IF = 19, THEN = 20, ELSE = 21, FOR = 22, TO = 23, STEP = 24, NEXT = 25, GOTO = 26,
            GOSUB = 27, ON = 28, COMMA = 29, QMARK = 30, LPAREN = 31, RPAREN = 32, PRINT = 33, DELAY = 34,
            BACKLED = 35, SYSVARNAME = 36, VARLETTER = 37, LISTLETTER = 38, COMMENT = 39, NUMBER = 40,
            WS = 41;
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

    public static final String[] ruleNames = {
            "GT", "LT", "EQ", "NOT", "AND", "OR", "TIMES", "DIV", "MOD", "PLUS", "MINUS",
            "BINSHL", "BINSHR", "BINAND", "BINOR", "SQRT", "RND", "ABS", "IF", "THEN",
            "ELSE", "FOR", "TO", "STEP", "NEXT", "GOTO", "GOSUB", "ON", "COMMA", "QMARK",
            "LPAREN", "RPAREN", "PRINT", "DELAY", "BACKLED", "SYSVARNAME", "VARLETTER",
            "LISTLETTER", "CHAR", "COMMENT", "DIGIT", "NUMBER", "WS"
    };

    private static final String[] _LITERAL_NAMES = {
            null, "'>'", "'<'", "'='", "'!'", "'and'", "'or'", "'*'", "'/'", "'%'",
            "'+'", "'-'", "'{'", "'}'", "'&'", "'|'", "'sqrt'", "'rnd'", "'abs'",
            "'if'", "'then'", "'else'", "'for'", "'to'", "'step'", "'next'", "'goto'",
            "'gosub'", "'on'", "','", "'?'", "'('", "')'", "'print'", "'delay'", "'backLED'",
            null, null, "'Z'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "GT", "LT", "EQ", "NOT", "AND", "OR", "TIMES", "DIV", "MOD", "PLUS",
            "MINUS", "BINSHL", "BINSHR", "BINAND", "BINOR", "SQRT", "RND", "ABS",
            "IF", "THEN", "ELSE", "FOR", "TO", "STEP", "NEXT", "GOTO", "GOSUB", "ON",
            "COMMA", "QMARK", "LPAREN", "RPAREN", "PRINT", "DELAY", "BACKLED", "SYSVARNAME",
            "VARLETTER", "LISTLETTER", "COMMENT", "NUMBER", "WS"
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
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "Orbbasic.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2+\u0148\b\1\4\2\t" +
                    "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
                    "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
                    "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
                    "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!" +
                    "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4" +
                    ",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3" +
                    "\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20" +
                    "\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23" +
                    "\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27" +
                    "\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32" +
                    "\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35" +
                    "\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#" +
                    "\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%" +
                    "\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%" +
                    "\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%" +
                    "\u0107\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%" +
                    "\3%\3%\3%\3%\3%\3%\3%\5%\u0124\n%\3&\5&\u0127\n&\3\'\3\'\3(\3(\3)\3)\7" +
                    ")\u012f\n)\f)\16)\u0132\13)\3*\3*\3+\6+\u0137\n+\r+\16+\u0138\3+\3+\7" +
                    "+\u013d\n+\f+\16+\u0140\13+\3,\6,\u0143\n,\r,\16,\u0144\3,\3,\2\2-\3\3" +
                    "\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21" +
                    "!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!" +
                    "A\"C#E$G%I&K\'M(O\2Q)S\2U*W+\3\2\n\3\2CE\3\2Z\\\4\2UUXX\3\2z{\4\2C[c{" +
                    "\5\2\f\f\17\17$$\4\2GGgg\5\2\13\f\17\17\"\"\u0158\2\3\3\2\2\2\2\5\3\2" +
                    "\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21" +
                    "\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2" +
                    "\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3" +
                    "\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3" +
                    "\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3" +
                    "\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2" +
                    "\2\2M\3\2\2\2\2Q\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7" +
                    "]\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2\re\3\2\2\2\17h\3\2\2\2\21j\3\2\2\2\23" +
                    "l\3\2\2\2\25n\3\2\2\2\27p\3\2\2\2\31r\3\2\2\2\33t\3\2\2\2\35v\3\2\2\2" +
                    "\37x\3\2\2\2!z\3\2\2\2#\177\3\2\2\2%\u0083\3\2\2\2\'\u0087\3\2\2\2)\u008a" +
                    "\3\2\2\2+\u008f\3\2\2\2-\u0094\3\2\2\2/\u0098\3\2\2\2\61\u009b\3\2\2\2" +
                    "\63\u00a0\3\2\2\2\65\u00a5\3\2\2\2\67\u00aa\3\2\2\29\u00b0\3\2\2\2;\u00b3" +
                    "\3\2\2\2=\u00b5\3\2\2\2?\u00b7\3\2\2\2A\u00b9\3\2\2\2C\u00bb\3\2\2\2E" +
                    "\u00c1\3\2\2\2G\u00c7\3\2\2\2I\u0123\3\2\2\2K\u0126\3\2\2\2M\u0128\3\2" +
                    "\2\2O\u012a\3\2\2\2Q\u012c\3\2\2\2S\u0133\3\2\2\2U\u0136\3\2\2\2W\u0142" +
                    "\3\2\2\2YZ\7@\2\2Z\4\3\2\2\2[\\\7>\2\2\\\6\3\2\2\2]^\7?\2\2^\b\3\2\2\2" +
                    "_`\7#\2\2`\n\3\2\2\2ab\7c\2\2bc\7p\2\2cd\7f\2\2d\f\3\2\2\2ef\7q\2\2fg" +
                    "\7t\2\2g\16\3\2\2\2hi\7,\2\2i\20\3\2\2\2jk\7\61\2\2k\22\3\2\2\2lm\7\'" +
                    "\2\2m\24\3\2\2\2no\7-\2\2o\26\3\2\2\2pq\7/\2\2q\30\3\2\2\2rs\7}\2\2s\32" +
                    "\3\2\2\2tu\7\177\2\2u\34\3\2\2\2vw\7(\2\2w\36\3\2\2\2xy\7~\2\2y \3\2\2" +
                    "\2z{\7u\2\2{|\7s\2\2|}\7t\2\2}~\7v\2\2~\"\3\2\2\2\177\u0080\7t\2\2\u0080" +
                    "\u0081\7p\2\2\u0081\u0082\7f\2\2\u0082$\3\2\2\2\u0083\u0084\7c\2\2\u0084" +
                    "\u0085\7d\2\2\u0085\u0086\7u\2\2\u0086&\3\2\2\2\u0087\u0088\7k\2\2\u0088" +
                    "\u0089\7h\2\2\u0089(\3\2\2\2\u008a\u008b\7v\2\2\u008b\u008c\7j\2\2\u008c" +
                    "\u008d\7g\2\2\u008d\u008e\7p\2\2\u008e*\3\2\2\2\u008f\u0090\7g\2\2\u0090" +
                    "\u0091\7n\2\2\u0091\u0092\7u\2\2\u0092\u0093\7g\2\2\u0093,\3\2\2\2\u0094" +
                    "\u0095\7h\2\2\u0095\u0096\7q\2\2\u0096\u0097\7t\2\2\u0097.\3\2\2\2\u0098" +
                    "\u0099\7v\2\2\u0099\u009a\7q\2\2\u009a\60\3\2\2\2\u009b\u009c\7u\2\2\u009c" +
                    "\u009d\7v\2\2\u009d\u009e\7g\2\2\u009e\u009f\7r\2\2\u009f\62\3\2\2\2\u00a0" +
                    "\u00a1\7p\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7z\2\2\u00a3\u00a4\7v\2\2" +
                    "\u00a4\64\3\2\2\2\u00a5\u00a6\7i\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7" +
                    "v\2\2\u00a8\u00a9\7q\2\2\u00a9\66\3\2\2\2\u00aa\u00ab\7i\2\2\u00ab\u00ac" +
                    "\7q\2\2\u00ac\u00ad\7u\2\2\u00ad\u00ae\7w\2\2\u00ae\u00af\7d\2\2\u00af" +
                    "8\3\2\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7p\2\2\u00b2:\3\2\2\2\u00b3\u00b4" +
                    "\7.\2\2\u00b4<\3\2\2\2\u00b5\u00b6\7A\2\2\u00b6>\3\2\2\2\u00b7\u00b8\7" +
                    "*\2\2\u00b8@\3\2\2\2\u00b9\u00ba\7+\2\2\u00baB\3\2\2\2\u00bb\u00bc\7r" +
                    "\2\2\u00bc\u00bd\7t\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0" +
                    "\7v\2\2\u00c0D\3\2\2\2\u00c1\u00c2\7f\2\2\u00c2\u00c3\7g\2\2\u00c3\u00c4" +
                    "\7n\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7{\2\2\u00c6F\3\2\2\2\u00c7\u00c8" +
                    "\7d\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7m\2\2\u00cb" +
                    "\u00cc\7N\2\2\u00cc\u00cd\7G\2\2\u00cd\u00ce\7F\2\2\u00ceH\3\2\2\2\u00cf" +
                    "\u00d0\7v\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7o\2\2\u00d2\u00d3\7g\2\2" +
                    "\u00d3\u00d4\7t\2\2\u00d4\u00d5\3\2\2\2\u00d5\u0124\t\2\2\2\u00d6\u00d7" +
                    "\7e\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7t\2\2\u00d9\u0124\7n\2\2\u00da" +
                    "\u00db\7u\2\2\u00db\u00dc\7r\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7g\2\2" +
                    "\u00de\u0124\7f\2\2\u00df\u00e0\7{\2\2\u00e0\u00e1\7c\2\2\u00e1\u0124" +
                    "\7y\2\2\u00e2\u00e3\7r\2\2\u00e3\u00e4\7k\2\2\u00e4\u00e5\7v\2\2\u00e5" +
                    "\u00e6\7e\2\2\u00e6\u0124\7j\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7q\2\2" +
                    "\u00e9\u00ea\7n\2\2\u00ea\u0124\7n\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed" +
                    "\7e\2\2\u00ed\u00ee\7e\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7n\2\2\u00f0" +
                    "\u00f1\3\2\2\2\u00f1\u0124\t\3\2\2\u00f2\u00f3\7i\2\2\u00f3\u00f4\7{\2" +
                    "\2\u00f4\u00f5\7t\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\3\2\2\2\u00f7\u0124" +
                    "\t\3\2\2\u00f8\u00f9\t\4\2\2\u00f9\u00fa\7d\2\2\u00fa\u00fb\7c\2\2\u00fb" +
                    "\u00fc\7v\2\2\u00fc\u0124\7v\2\2\u00fd\u00fe\7e\2\2\u00fe\u00ff\7o\2\2" +
                    "\u00ff\u0107\7f\2\2\u0100\u0101\7u\2\2\u0101\u0102\7r\2\2\u0102\u0107" +
                    "\7f\2\2\u0103\u0104\7j\2\2\u0104\u0105\7f\2\2\u0105\u0107\7i\2\2\u0106" +
                    "\u00fd\3\2\2\2\u0106\u0100\3\2\2\2\u0106\u0103\3\2\2\2\u0107\u0108\3\2" +
                    "\2\2\u0108\u0109\7x\2\2\u0109\u010a\7c\2\2\u010a\u0124\7n\2\2\u010b\u010c" +
                    "\7k\2\2\u010c\u010d\7u\2\2\u010d\u010e\7e\2\2\u010e\u010f\7q\2\2\u010f" +
                    "\u0110\7p\2\2\u0110\u0124\7p\2\2\u0111\u0112\7f\2\2\u0112\u0113\7u\2\2" +
                    "\u0113\u0114\7j\2\2\u0114\u0115\7c\2\2\u0115\u0116\7m\2\2\u0116\u0124" +
                    "\7g\2\2\u0117\u0118\7c\2\2\u0118\u0119\7e\2\2\u0119\u011a\7e\2\2\u011a" +
                    "\u011b\7g\2\2\u011b\u011c\7n\2\2\u011c\u011d\7q\2\2\u011d\u011e\7p\2\2" +
                    "\u011e\u0124\7g\2\2\u011f\u0120\t\5\2\2\u0120\u0121\7r\2\2\u0121\u0122" +
                    "\7q\2\2\u0122\u0124\7u\2\2\u0123\u00cf\3\2\2\2\u0123\u00d6\3\2\2\2\u0123" +
                    "\u00da\3\2\2\2\u0123\u00df\3\2\2\2\u0123\u00e2\3\2\2\2\u0123\u00e7\3\2" +
                    "\2\2\u0123\u00eb\3\2\2\2\u0123\u00f2\3\2\2\2\u0123\u00f8\3\2\2\2\u0123" +
                    "\u0106\3\2\2\2\u0123\u010b\3\2\2\2\u0123\u0111\3\2\2\2\u0123\u0117\3\2" +
                    "\2\2\u0123\u011f\3\2\2\2\u0124J\3\2\2\2\u0125\u0127\t\6\2\2\u0126\u0125" +
                    "\3\2\2\2\u0127L\3\2\2\2\u0128\u0129\7\\\2\2\u0129N\3\2\2\2\u012a\u012b" +
                    "\n\7\2\2\u012bP\3\2\2\2\u012c\u0130\7^\2\2\u012d\u012f\5O(\2\u012e\u012d" +
                    "\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131" +
                    "R\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\4\62;\2\u0134T\3\2\2\2\u0135" +
                    "\u0137\5S*\2\u0136\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2" +
                    "\2\u0138\u0139\3\2\2\2\u0139\u013e\3\2\2\2\u013a\u013b\t\b\2\2\u013b\u013d" +
                    "\5U+\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e" +
                    "\u013f\3\2\2\2\u013fV\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0143\t\t\2\2" +
                    "\u0142\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145" +
                    "\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\b,\2\2\u0147X\3\2\2\2\n\2\u0106" +
                    "\u0123\u0126\u0130\u0138\u013e\u0144\3\2\3\2";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}