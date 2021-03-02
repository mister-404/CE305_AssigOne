// Generated from /Users/bkb/Documents/Uni/CE305_AssigOne/src/ANTLR_SRC/AssigOneGrammar.g4 by ANTLR 4.9.1
package AssigOneGrammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AssigOneGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, FLOAT=4, ID=5, INT=6, NEW_LINE=7, WS=8, ENDSTMT=9, 
		MUL=10, DIV=11, ADD=12, SUB=13, POW=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "FLOAT", "ID", "INT", "NEW_LINE", "WS", "ENDSTMT", 
			"MUL", "DIV", "ADD", "SUB", "POW"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "')'", null, null, null, null, null, "';'", "'*'", 
			"'/'", "'+'", "'-'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "FLOAT", "ID", "INT", "NEW_LINE", "WS", "ENDSTMT", 
			"MUL", "DIV", "ADD", "SUB", "POW"
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


	public AssigOneGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AssigOneGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20M\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\5"+
		"\5\'\n\5\3\5\3\5\3\5\3\6\6\6-\n\6\r\6\16\6.\3\7\6\7\62\n\7\r\7\16\7\63"+
		"\3\b\5\b\67\n\b\3\b\3\b\3\t\6\t<\n\t\r\t\16\t=\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\5\4\2C\\c|\3\2\62;"+
		"\4\2\13\13\"\"\2Q\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5"+
		"!\3\2\2\2\7#\3\2\2\2\t&\3\2\2\2\13,\3\2\2\2\r\61\3\2\2\2\17\66\3\2\2\2"+
		"\21;\3\2\2\2\23A\3\2\2\2\25C\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33I\3\2\2"+
		"\2\35K\3\2\2\2\37 \7?\2\2 \4\3\2\2\2!\"\7*\2\2\"\6\3\2\2\2#$\7+\2\2$\b"+
		"\3\2\2\2%\'\5\r\7\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\60\2\2)*\5\r\7"+
		"\2*\n\3\2\2\2+-\t\2\2\2,+\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\f\3\2"+
		"\2\2\60\62\t\3\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2"+
		"\2\2\64\16\3\2\2\2\65\67\7\17\2\2\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2"+
		"\2\289\7\f\2\29\20\3\2\2\2:<\t\4\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3"+
		"\2\2\2>?\3\2\2\2?@\b\t\2\2@\22\3\2\2\2AB\7=\2\2B\24\3\2\2\2CD\7,\2\2D"+
		"\26\3\2\2\2EF\7\61\2\2F\30\3\2\2\2GH\7-\2\2H\32\3\2\2\2IJ\7/\2\2J\34\3"+
		"\2\2\2KL\7`\2\2L\36\3\2\2\2\b\2&.\63\66=\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}