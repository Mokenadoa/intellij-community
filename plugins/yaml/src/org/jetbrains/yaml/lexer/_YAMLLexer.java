/* The following code was generated by JFlex 1.4.3 on 11/25/11 2:05 PM */

package org.jetbrains.yaml.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.yaml.YAMLTokenTypes;

/* Auto generated File */

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 11/25/11 2:05 PM from the specification file
 * <tt>/home/oleg/work/IDEA/tools/lexer/../../plugins/yaml/src/org/jetbrains/yaml/lexer/yaml.flex</tt>
 */
public class _YAMLLexer implements FlexLexer, YAMLTokenTypes {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int VALUE_OR_KEY = 6;
  public static final int YYINITIAL = 0;
  public static final int BRACES = 2;
  public static final int VALUE = 4;
  public static final int INDENT_VALUE = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\2\1\1\25\0\1\6\1\0\1\16\1\3\1\0\1\14"+
    "\1\0\1\17\3\0\1\26\1\22\1\5\1\10\1\0\12\7\1\11"+
    "\3\0\1\24\1\23\1\0\32\4\1\20\1\15\1\21\1\0\1\4"+
    "\1\0\32\4\1\12\1\25\1\13\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\7\0\1\1\1\2\1\3\1\4\3\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\1\1\13\1\5\1\6"+
    "\1\1\1\14\1\15\1\10\1\12\3\1\1\16\1\17"+
    "\1\20\7\0\1\21\2\22\1\0\2\23\1\24\1\0"+
    "\2\24\1\0\1\24\3\14\1\24\1\14\3\15\1\24"+
    "\1\15\2\25\2\26\1\0\2\24\1\0\1\24\2\0"+
    "\2\27\1\30\2\24\1\0\1\24\1\0\2\24\1\0"+
    "\3\14\1\0\3\15\5\24\2\0\1\24\3\14\1\24"+
    "\1\14\3\15\1\24\1\15\1\24\1\0\3\24\1\0"+
    "\3\14\3\15\1\24\1\14\1\15";

  private static int [] zzUnpackAction() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\27\0\56\0\105\0\134\0\163\0\212\0\241"+
    "\0\241\0\270\0\317\0\346\0\375\0\u0114\0\241\0\241"+
    "\0\241\0\241\0\241\0\241\0\u012b\0\u0142\0\u0159\0\u012b"+
    "\0\u0170\0\u0187\0\u019e\0\u012b\0\u012b\0\u01b5\0\u01cc\0\u01e3"+
    "\0\u01fa\0\241\0\u0211\0\u0228\0\241\0\u023f\0\u0256\0\346"+
    "\0\u026d\0\u0284\0\u029b\0\241\0\u02b2\0\u02c9\0\241\0\u02e0"+
    "\0\u012b\0\u012b\0\u02f7\0\u030e\0\u0325\0\u033c\0\u0353\0\u036a"+
    "\0\u0381\0\u0398\0\u012b\0\u03af\0\u03c6\0\u03dd\0\u03f4\0\u040b"+
    "\0\241\0\u0422\0\241\0\u0439\0\u0450\0\u01e3\0\u0467\0\u0467"+
    "\0\u047e\0\u0495\0\241\0\241\0\u04ac\0\241\0\u04c3\0\u04da"+
    "\0\u04f1\0\u0508\0\u0508\0\u051f\0\u0536\0\u054d\0\241\0\u0564"+
    "\0\u057b\0\u0592\0\u05a9\0\u05c0\0\u05d7\0\u05ee\0\u0605\0\u061c"+
    "\0\u04f1\0\u0633\0\u0633\0\u064a\0\u0661\0\u0678\0\u068f\0\u06a6"+
    "\0\u06bd\0\u0605\0\u06d4\0\u06eb\0\u0702\0\u0719\0\u0730\0\u0747"+
    "\0\u0747\0\u075e\0\u0775\0\u078c\0\u078c\0\u07a3\0\u07ba\0\u07d1"+
    "\0\u07e8\0\u07ff\0\u0816\0\u082d\0\u0844\0\u085b";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\12\2\10"+
    "\1\16\1\17\1\20\4\10\1\21\1\22\1\23\1\24"+
    "\3\10\1\25\1\11\1\26\1\13\2\25\1\26\2\25"+
    "\1\16\1\27\1\30\1\31\1\25\1\32\1\33\1\21"+
    "\1\34\1\23\1\35\1\36\1\37\2\25\1\11\1\26"+
    "\1\13\1\40\1\25\1\26\2\25\1\16\1\27\1\30"+
    "\1\31\1\25\1\32\1\33\1\21\1\34\1\23\1\35"+
    "\1\36\1\37\1\25\1\41\1\42\1\43\3\41\1\43"+
    "\20\41\4\0\1\44\23\0\1\45\1\46\3\0\1\46"+
    "\45\0\1\47\32\0\1\12\3\0\1\12\20\0\1\13"+
    "\1\0\25\13\4\0\1\50\2\51\1\50\1\52\1\53"+
    "\16\0\1\54\1\55\2\0\1\56\1\55\21\0\1\57"+
    "\1\60\3\0\1\60\20\0\1\61\1\0\1\62\1\0"+
    "\2\61\1\62\2\61\1\0\1\63\1\0\1\64\4\61"+
    "\2\0\4\61\2\0\1\26\3\0\1\26\32\0\1\65"+
    "\14\0\1\61\1\0\1\62\1\0\2\61\1\62\2\61"+
    "\1\0\1\66\1\0\1\64\4\61\2\0\4\61\1\32"+
    "\1\67\1\32\1\67\5\32\1\67\1\70\1\67\1\71"+
    "\1\72\1\73\2\32\2\67\4\32\1\33\1\74\1\33"+
    "\1\74\5\33\1\74\1\75\1\74\1\76\1\77\1\33"+
    "\1\100\1\33\2\74\4\33\1\0\1\101\1\102\3\0"+
    "\1\102\21\0\1\103\1\104\2\0\1\105\1\104\17\0"+
    "\1\105\1\61\1\0\1\62\1\0\1\106\1\107\1\110"+
    "\1\106\1\111\1\53\1\63\1\0\1\64\4\61\2\0"+
    "\4\61\1\41\1\0\25\41\2\0\1\43\3\0\1\43"+
    "\24\0\1\44\2\112\1\44\1\5\1\113\17\0\1\46"+
    "\3\0\1\46\25\0\1\113\20\0\1\113\4\0\1\50"+
    "\2\51\1\50\23\0\1\50\23\0\1\114\1\115\3\0"+
    "\1\115\22\0\1\55\3\0\1\55\25\0\1\116\23\0"+
    "\1\60\3\0\1\60\20\0\1\61\1\0\1\62\1\0"+
    "\2\61\1\62\2\61\1\0\1\117\1\0\1\64\4\61"+
    "\2\0\5\61\1\0\1\62\1\0\2\61\1\62\2\61"+
    "\1\0\1\120\1\0\1\64\4\61\2\0\4\61\4\0"+
    "\1\121\22\0\1\122\1\0\2\123\2\122\1\123\2\122"+
    "\1\123\1\124\1\62\1\125\4\122\2\123\4\122\15\67"+
    "\1\126\1\127\10\67\1\32\1\67\1\32\1\67\5\32"+
    "\1\67\1\130\1\67\1\71\1\72\1\73\2\32\2\67"+
    "\5\32\1\67\1\32\1\67\5\32\1\67\1\131\1\67"+
    "\1\71\1\72\1\73\2\32\2\67\5\32\1\0\1\32"+
    "\1\67\5\32\1\67\1\70\1\67\1\71\4\32\2\67"+
    "\4\32\15\74\1\132\1\74\1\133\7\74\1\33\1\74"+
    "\1\33\1\74\5\33\1\74\1\134\1\74\1\76\1\77"+
    "\1\33\1\100\1\33\2\74\5\33\1\74\1\33\1\74"+
    "\5\33\1\74\1\135\1\74\1\76\1\77\1\33\1\100"+
    "\1\33\2\74\5\33\1\0\1\33\1\74\5\33\1\74"+
    "\1\75\1\74\1\76\4\33\2\74\4\33\1\61\1\0"+
    "\1\62\1\0\2\61\1\62\2\61\1\0\1\63\1\0"+
    "\1\64\2\61\1\33\1\61\2\0\4\61\2\0\1\102"+
    "\3\0\1\102\22\0\1\104\3\0\1\104\21\0\1\103"+
    "\1\104\3\0\1\104\20\0\1\61\1\0\1\62\1\0"+
    "\1\106\1\107\1\110\1\106\1\61\1\0\1\63\1\0"+
    "\1\64\4\61\2\0\5\61\1\0\1\62\1\0\1\106"+
    "\1\61\1\62\2\61\1\0\1\63\1\0\1\64\4\61"+
    "\2\0\4\61\4\0\1\44\2\112\1\44\21\0\1\115"+
    "\3\0\1\115\20\0\1\61\1\0\1\62\1\0\1\136"+
    "\1\61\1\62\2\61\1\0\1\117\1\0\1\64\4\61"+
    "\2\0\4\61\1\137\1\0\10\137\1\140\1\61\13\137"+
    "\1\61\1\0\1\62\1\0\1\141\1\142\1\143\1\141"+
    "\1\61\1\0\1\63\1\144\1\64\4\61\2\0\4\61"+
    "\1\122\1\0\2\123\2\122\1\123\2\122\1\123\1\66"+
    "\1\62\1\125\4\122\2\123\5\122\1\0\2\123\1\145"+
    "\1\122\1\123\2\122\1\123\1\124\1\62\1\125\4\122"+
    "\2\123\5\122\1\0\2\123\2\122\1\123\2\122\1\123"+
    "\1\120\1\62\1\125\4\122\2\123\4\122\1\67\1\0"+
    "\25\67\1\32\1\67\1\32\1\67\1\146\4\32\1\67"+
    "\1\130\1\67\1\71\1\72\1\73\2\32\2\67\4\32"+
    "\1\147\1\67\10\147\1\150\1\32\1\147\1\151\1\152"+
    "\10\147\1\74\1\0\25\74\17\0\1\74\7\0\1\33"+
    "\1\74\1\33\1\74\1\153\4\33\1\74\1\134\1\74"+
    "\1\76\1\77\1\33\1\100\1\33\2\74\4\33\1\154"+
    "\1\74\10\154\1\155\1\33\1\154\1\156\1\154\1\157"+
    "\7\154\1\61\1\0\1\62\1\0\1\136\1\160\1\161"+
    "\1\136\1\61\1\0\1\63\1\162\1\64\4\61\2\0"+
    "\4\61\1\137\1\0\10\137\1\120\1\61\14\137\1\0"+
    "\2\137\1\163\5\137\1\140\1\61\13\137\1\61\1\0"+
    "\1\62\1\0\1\141\1\142\1\143\1\141\1\61\1\0"+
    "\1\63\1\0\1\64\4\61\2\0\5\61\1\0\1\62"+
    "\1\0\2\61\1\62\2\61\1\0\1\63\1\62\1\64"+
    "\4\61\2\0\4\61\1\122\1\0\2\123\1\145\1\164"+
    "\1\165\1\145\1\122\1\123\1\66\1\162\1\125\4\122"+
    "\2\123\4\122\1\32\1\67\1\32\1\67\1\146\2\166"+
    "\1\146\1\32\1\67\1\70\1\167\1\71\1\72\1\73"+
    "\2\32\2\67\4\32\1\147\1\67\10\147\1\131\1\32"+
    "\1\147\1\151\1\152\11\147\1\67\2\147\1\170\5\147"+
    "\1\150\1\32\1\147\1\151\1\152\11\147\1\0\10\147"+
    "\1\131\1\32\13\147\1\33\1\74\1\33\1\74\1\153"+
    "\2\171\1\153\1\33\1\74\1\75\1\172\1\76\1\77"+
    "\1\33\1\100\1\33\2\74\4\33\1\154\1\74\10\154"+
    "\1\135\1\33\1\154\1\156\1\154\1\157\10\154\1\74"+
    "\2\154\1\173\5\154\1\155\1\33\1\154\1\156\1\154"+
    "\1\157\10\154\1\0\10\154\1\135\1\33\13\154\1\137"+
    "\1\0\10\137\1\120\1\61\3\137\1\154\7\137\1\61"+
    "\1\0\1\62\1\0\1\136\1\160\1\161\1\136\1\61"+
    "\1\0\1\63\1\0\1\64\4\61\2\0\5\61\1\0"+
    "\1\62\1\0\2\61\1\62\2\61\1\0\1\63\1\61"+
    "\1\64\4\61\2\0\4\61\1\137\1\0\2\137\1\163"+
    "\2\174\1\163\2\137\1\120\1\162\13\137\1\122\1\0"+
    "\2\123\1\145\1\164\1\165\1\145\1\122\1\123\1\66"+
    "\1\62\1\125\4\122\2\123\4\122\1\32\1\67\1\32"+
    "\1\67\1\146\2\166\1\146\1\32\1\67\1\70\1\67"+
    "\1\71\1\72\1\73\2\32\2\67\5\32\1\67\1\32"+
    "\1\67\5\32\1\67\1\70\1\32\1\71\1\72\1\73"+
    "\2\32\2\67\4\32\1\147\1\67\2\147\1\170\2\175"+
    "\1\170\2\147\1\131\1\167\1\147\1\151\1\152\10\147"+
    "\1\33\1\74\1\33\1\74\1\153\2\171\1\153\1\33"+
    "\1\74\1\75\1\74\1\76\1\77\1\33\1\100\1\33"+
    "\2\74\5\33\1\74\1\33\1\74\5\33\1\74\1\75"+
    "\1\33\1\76\1\77\1\33\1\100\1\33\2\74\4\33"+
    "\1\154\1\74\2\154\1\173\2\176\1\173\2\154\1\135"+
    "\1\172\1\154\1\156\1\154\1\157\7\154\1\137\1\0"+
    "\2\137\1\163\2\174\1\163\2\137\1\120\1\61\13\137"+
    "\1\147\1\67\2\147\1\170\2\175\1\170\2\147\1\131"+
    "\1\32\1\147\1\151\1\152\10\147\1\154\1\74\2\154"+
    "\1\173\2\176\1\173\2\154\1\135\1\33\1\154\1\156"+
    "\1\154\1\157\7\154";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2162];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\7\0\2\11\5\1\6\11\15\1\1\11\1\1\1\0"+
    "\1\11\2\1\3\0\1\1\1\11\1\1\1\0\1\11"+
    "\2\1\1\0\2\1\1\0\13\1\1\11\1\1\1\11"+
    "\1\1\1\0\2\1\1\0\1\1\1\0\2\11\1\1"+
    "\1\11\2\1\1\0\1\1\1\0\2\1\1\0\1\11"+
    "\2\1\1\0\10\1\2\0\14\1\1\0\3\1\1\0"+
    "\11\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[126];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** For the backwards DFA of general lookahead statements */
  private boolean [] zzFin = new boolean [ZZ_BUFFERSIZE+1];

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private int valueIndent = 0;
  private boolean afterEOL = false;
  private int braceCount = 0;
  private IElementType valueTokenType = null;
  private int previousState = YYINITIAL;
    
  private char previousChar() {
    return getChar(-1);
  }

  private char getChar(final int offset) {
    final int loc = getTokenStart()  + offset;
    return 0 <= loc && loc < zzBuffer.length() ? zzBuffer.charAt(loc) : (char) -1;
  }

  private char getCharAfter(final int offset) {
    final int loc = getTokenEnd()  + offset;
    return 0 <= loc && loc < zzBuffer.length() ? zzBuffer.charAt(loc) : (char) -1;
  }



  public _YAMLLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public _YAMLLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 72) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++]:zzBufferL.charAt(zzCurrentPosL++);
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++]:zzBufferL.charAt(zzCurrentPosL++);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 24: 
          { braceCount = 0;
                                    yybegin(YYINITIAL);
                                    return DOCUMENT_MARKER;
          }
        case 25: break;
        case 17: 
          { if (zzMarkedPos == zzEndRead){
                                      return SCALAR_KEY;
                                    }
                                    return TEXT;
          }
        case 26: break;
        case 5: 
          { braceCount++;
                                    if (braceCount != 0 && yystate() != BRACES) {
                                      previousState = yystate();
                                    }
                                    yybegin(braceCount == 0 ? previousState: BRACES);
                                    return LBRACE;
          }
        case 27: break;
        case 21: 
          // lookahead expression with fixed base length
          zzMarkedPos = zzStartRead + 1;
          { yybegin(INDENT_VALUE);
                                    //System.out.println("Started SCALAR_TEXT state");
                                    valueIndent = 0; // initialization
                                    afterEOL = false;
                                    valueTokenType = SCALAR_TEXT;
                                    yypushback(1);
          }
        case 28: break;
        case 7: 
          { braceCount++;
                                    if (braceCount != 0 && yystate() != BRACES) {
                                      previousState = yystate();
                                    }
                                    yybegin(braceCount == 0 ? previousState: BRACES);
                                    return LBRACKET;
          }
        case 29: break;
        case 4: 
          { return COMMENT;
          }
        case 30: break;
        case 15: 
          { afterEOL = true;
                                            //System.out.println("Matched EOL:");
                                            if (valueIndent < 0) {
                                                yybegin(YYINITIAL);
                                                //System.out.println("return to initial state");
                                            }
                                            else if (valueIndent == 0) {
                                                valueIndent --;
                                            }
                                            return EOL;
          }
        case 31: break;
        case 20: 
          { if (braceCount <= 0) {
                                      char c;
                                      while ((c = getCharAfter(0)) == ' ' || c == ','){
                                        zzMarkedPos++;
                                      }
                                    }
                                    return TEXT;
          }
        case 32: break;
        case 22: 
          // general lookahead, find correct zzMarkedPos
          { int zzFState = 6;
            int zzFPos = zzStartRead;
            if (zzFin.length <= zzBufferL.length()) { zzFin = new boolean[zzBufferL.length()+1]; }
            boolean zzFinL[] = zzFin;
            while (zzFState != -1 && zzFPos < zzMarkedPos) {
              if ((zzAttrL[zzFState] & 1) == 1) { zzFinL[zzFPos] = true; } 
              zzInput = zzBufferL.charAt(zzFPos++);
              zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMapL[zzInput] ];
            }
            if (zzFState != -1 && (zzAttrL[zzFState] & 1) == 1) { zzFinL[zzFPos] = true; } 

            zzFState = 5;
            zzFPos = zzMarkedPos;
            while (!zzFinL[zzFPos] || (zzAttrL[zzFState] & 1) != 1) {
              zzInput = zzBufferL.charAt(--zzFPos);
              zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMapL[zzInput] ];
            };
            zzMarkedPos = zzFPos;
          }
          { yybegin(INDENT_VALUE);
                                    //System.out.println("Started SCALAR_LIST state");
                                    valueIndent = 0; // initialization
                                    afterEOL = false;
                                    valueTokenType = SCALAR_LIST;
                                    yypushback(yylength());
          }
        case 33: break;
        case 10: 
          { return QUESTION;
          }
        case 34: break;
        case 9: 
          { if (braceCount > 0) {
                                      yybegin(BRACES);
                                      return COMMA;
                                    }
                                    return TEXT;
          }
        case 35: break;
        case 14: 
          { if (afterEOL){
                                                yypushback(yylength());
                                                yybegin(YYINITIAL);
                                                //System.out.println("return to initial state");

                                            } else {
                                                afterEOL = false;
                                                if (valueIndent < 0) {
                                                    //System.out.println("Matched TEXT:" + yytext());
                                                    return TEXT;
                                                }
                                                //System.out.println("Matched ValueContext:" + yytext());
                                                return valueTokenType;
                                            }
          }
        case 36: break;
        case 19: 
          // lookahead expression with fixed base length
          zzMarkedPos = zzStartRead + 1;
          { return COLON;
          }
        case 37: break;
        case 2: 
          { yybegin(YYINITIAL);
                                    return EOL;
          }
        case 38: break;
        case 12: 
          { return SCALAR_DSTRING;
          }
        case 39: break;
        case 6: 
          { braceCount--;
                                    if (yystate() == BRACES && braceCount == 0){
                                      yybegin(previousState);
                                    }
                                    return RBRACE;
          }
        case 40: break;
        case 16: 
          { afterEOL = false;
                                            //System.out.println("Matched WHITESPACE:" + yytext());
                                            final int matched = yylength();
                                            if (valueIndent < 0){
                                                valueIndent = matched;
                                                //System.out.println("Indent selected:" + valueIndent);
                                            }
                                            else if (valueIndent > matched) {
                                                yybegin(YYINITIAL);
                                                //System.out.println("return to initial state");
                                            }
                                            return previousChar() == '\n' ? INDENT : WHITESPACE;
          }
        case 41: break;
        case 1: 
          { return TEXT;
          }
        case 42: break;
        case 13: 
          { return SCALAR_STRING;
          }
        case 43: break;
        case 8: 
          { braceCount--;
                                    if (yystate() == BRACES && braceCount == 0){
                                      yybegin(previousState);
                                    }
                                    return RBRACKET;
          }
        case 44: break;
        case 3: 
          { final char prev = previousChar();
                                    return prev == (char)-1 || prev == '\n' ? INDENT : WHITESPACE;
          }
        case 45: break;
        case 18: 
          // lookahead expression with fixed base length
          zzMarkedPos = zzStartRead + 1;
          { yybegin(VALUE_OR_KEY);
                                    return SEQUENCE_MARKER;
          }
        case 46: break;
        case 23: 
          // general lookahead, find correct zzMarkedPos
          { int zzFState = 4;
            int zzFPos = zzStartRead;
            if (zzFin.length <= zzBufferL.length()) { zzFin = new boolean[zzBufferL.length()+1]; }
            boolean zzFinL[] = zzFin;
            while (zzFState != -1 && zzFPos < zzMarkedPos) {
              if ((zzAttrL[zzFState] & 1) == 1) { zzFinL[zzFPos] = true; } 
              zzInput = zzBufferL.charAt(zzFPos++);
              zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMapL[zzInput] ];
            }
            if (zzFState != -1 && (zzAttrL[zzFState] & 1) == 1) { zzFinL[zzFPos] = true; } 

            zzFState = 5;
            zzFPos = zzMarkedPos;
            while (!zzFinL[zzFPos] || (zzAttrL[zzFState] & 1) != 1) {
              zzInput = zzBufferL.charAt(--zzFPos);
              zzFState = zzTransL[ zzRowMapL[zzFState] + zzCMapL[zzInput] ];
            };
            zzMarkedPos = zzFPos;
          }
          { yybegin(VALUE);
                                    return SCALAR_KEY;
          }
        case 47: break;
        case 11: 
          { return WHITESPACE;
          }
        case 48: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
