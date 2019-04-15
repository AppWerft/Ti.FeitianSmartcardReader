package gnu.xquery.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.expr.NameLookup;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.SingletonType;
import gnu.kawa.xml.ElementType;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.NodeType;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.math.IntNum;
import gnu.text.Lexer;
import gnu.text.SourceError;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.xml.NamespaceBinding;
import gnu.xml.XName;
import gnu.xquery.util.CastableAs;
import gnu.xquery.util.NamedCollator;
import gnu.xquery.util.ValuesFilter;
import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import kawa.lang.Translator.FormStack;
import kawa.standard.require;

public class XQParser extends Lexer
{
  int curToken;
  Object curValue;
  int parseContext;
  boolean seenDeclaration;
  String libraryModuleNamespace;
  Map<String, SourceLocator> seenImports;
  int curLine;
  int curColumn;
  XQuery interpreter;
  int seenPosition;
  int seenLast;
  public static boolean warnOldVersion = true;
  public static boolean warnHidePreviousDeclaration = false;
  

  static final Symbol DOT_VARNAME = Symbol.makeUninterned("$dot$");
  

  static final Symbol POSITION_VARNAME = Symbol.makeUninterned("$position$");
  

  static final Symbol LAST_VARNAME = Symbol.makeUninterned("$last$");
  
  public static final InstanceOf instanceOf = new InstanceOf(XQuery.getInstance(), "instance");
  
  public static final CastableAs castableAs = CastableAs.castableAs;
  public static final gnu.kawa.functions.Convert treatAs = gnu.kawa.functions.Convert.cast;
  
  NamedCollator defaultCollator = null;
  



  char defaultEmptyOrder = 'L';
  
  boolean emptyOrderDeclarationSeen;
  private Path baseURI = null;
  boolean baseURIDeclarationSeen;
  boolean boundarySpacePreserve;
  boolean boundarySpaceDeclarationSeen;
  
  public void setStaticBaseUri(String uri) {
    try {
      baseURI = fixupStaticBaseUri(URIPath.valueOf(uri));
    }
    catch (Exception ex)
    {
      Throwable th = (ex instanceof WrappedException) ? ((WrappedException)ex).getCause() : ex;
      

      error('e', "invalid URI: " + th.getMessage());
    }
  }
  
  static Path fixupStaticBaseUri(Path path)
  {
    path = path.getAbsolute();
    if ((path instanceof gnu.kawa.io.FilePath))
      path = URIPath.valueOf(path.toURI());
    return path;
  }
  
  public String getStaticBaseUri()
  {
    Path path = baseURI;
    if (path == null)
    {
      Environment env = Environment.getCurrent();
      Object value = env.get(Symbol.make("", "base-uri"), null, null);
      if (value != null)
      {
        if ((value instanceof Path)) {
          path = path;
        } else {
          path = URIPath.valueOf(value.toString());
        }
      }
      InPort port;
      if ((path == null) && ((port = getPort()) != null))
      {
        path = port.getPath();
        if ((path != null) && (!path.isPlainFile())) {
          path = null;
        }
      }
      if (path == null) {
        path = Path.currentPath();
      }
      path = fixupStaticBaseUri(path);
      baseURI = path;
    }
    
    return path.toString();
  }
  
  public String resolveAgainstBaseUri(String uri)
  {
    if (Path.uriSchemeSpecified(uri))
      return uri;
    String base = getStaticBaseUri();
    Path basePath = Path.valueOf(base);
    return basePath.resolve(uri).toString();
  }
  


  boolean orderingModeUnordered;
  
  boolean orderingModeSeen;
  
  boolean copyNamespacesDeclarationSeen;
  
  int copyNamespacesMode = 3;
  

  boolean constructionModeStrip;
  

  boolean constructionModeDeclarationSeen;
  
  public Namespace[] functionNamespacePath = XQuery.defaultFunctionNamespacePath;
  
  Declaration[] flworDecls;
  
  int flworDeclsFirst;
  
  int flworDeclsCount;
  int parseCount;
  int commentCount;
  String errorIfComment;
  static final int EOF_TOKEN = -1;
  static final int EOL_TOKEN = 10;
  static final char INTEGER_TOKEN = '0';
  static final char DECIMAL_TOKEN = '1';
  static final char DOUBLE_TOKEN = '2';
  static final int STRING_TOKEN = 34;
  static final int SLASHSLASH_TOKEN = 68;
  static final int DOTDOT_TOKEN = 51;
  
  final int skipSpace()
    throws IOException, SyntaxException
  {
    return skipSpace(true);
  }
  
  final int skipSpace(boolean verticalToo)
    throws IOException, SyntaxException
  {
    for (;;)
    {
      int ch = read();
      if (ch == 40)
      {
        if (!checkNext(':'))
          return 40;
        skipComment();
      }
      else if (ch == 123)
      {
        ch = read();
        if (ch != 45)
        {
          unread(ch);
          return 123;
        }
        ch = read();
        if (ch != 45)
        {
          unread(ch);
          unread(45);
          return 123;
        }
        skipOldComment();
      }
      else if (verticalToo ? (ch < 0) || (!Character.isWhitespace((char)ch)) : (ch != 32) && (ch != 9))
      {

        return ch;
      }
    }
  }
  
  final void skipToSemicolon() throws IOException
  {
    for (;;)
    {
      int next = read();
      if ((next < 0) || (next == 59)) {
        break;
      }
    }
  }
  
  final void skipOldComment() throws IOException, SyntaxException
  {
    int seenDashes = 0;
    int startLine = getLineNumber() + 1;
    int startColumn = getColumnNumber() - 2;
    warnOldVersion("use (: :) instead of old-style comment {-- --}");
    for (;;)
    {
      int ch = read();
      if (ch == 45) {
        seenDashes++;
      } else { if ((ch == 125) && (seenDashes >= 2))
          return;
        if (ch < 0)
        {
          curLine = startLine;
          curColumn = startColumn;
          eofError("non-terminated comment starting here");
        }
        else {
          seenDashes = 0;
        }
      }
    }
  }
  
  final void skipComment() throws IOException, SyntaxException {
    commentCount += 1;
    int startLine = getLineNumber() + 1;
    int startColumn = getColumnNumber() - 1;
    if (errorIfComment != null)
    {
      curLine = startLine;
      curColumn = startColumn;
      error('e', errorIfComment);
    }
    int prev = 0;
    int commentNesting = 0;
    char saveReadState = pushNesting(':');
    for (;;)
    {
      int ch = read();
      if (ch == 58)
      {
        if (prev == 40)
        {
          commentNesting++;
          ch = 0;
        }
      }
      else if ((ch == 41) && (prev == 58))
      {
        if (commentNesting == 0)
        {
          popNesting(saveReadState);
          return;
        }
        commentNesting--;
      }
      else if (ch < 0)
      {
        curLine = startLine;
        curColumn = startColumn;
        eofError("non-terminated comment starting here");
      }
      prev = ch;
    }
  }
  

  final int peekNonSpace(String message)
    throws IOException, SyntaxException
  {
    int ch = skipSpace();
    if (ch < 0)
      eofError(message);
    unread(ch);
    return ch;
  }
  

  static final int COLON_EQUAL_TOKEN = 76;
  
  static final int COLON_COLON_TOKEN = 88;
  
  static final int NCNAME_TOKEN = 65;
  
  static final int NCNAME_COLON_TOKEN = 67;
  
  static final int QNAME_TOKEN = 81;
  
  static final int ARROW_TOKEN = 82;
  
  static final int FNAME_TOKEN = 70;
  
  static final int IMPORT_MODULE_TOKEN = 73;
  
  static final int IMPORT_SCHEMA_TOKEN = 84;
  
  static final int MODULE_NAMESPACE_TOKEN = 77;
  
  static final int DECLARE_NAMESPACE_TOKEN = 78;
  
  static final int DECLARE_BOUNDARY_SPACE_TOKEN = 83;
  
  static final int DEFAULT_ELEMENT_TOKEN = 69;
  
  static final int DEFAULT_FUNCTION_TOKEN = 79;
  
  static final int DEFAULT_COLLATION_TOKEN = 71;
  
  static final int DEFAULT_ORDER_TOKEN = 72;
  
  static final int DECLARE_FUNCTION_TOKEN = 80;
  
  static final int DECLARE_VARIABLE_TOKEN = 86;
  
  static final int DECLARE_BASE_URI_TOKEN = 66;
  
  static final int DECLARE_ORDERING_TOKEN = 85;
  
  static final int DECLARE_CONSTRUCTION_TOKEN = 75;
  
  static final int DECLARE_OPTION_TOKEN = 111;
  
  static final int DECLARE_COPY_NAMESPACES_TOKEN = 76;
  
  static final int DEFINE_QNAME_TOKEN = 87;
  
  static final int XQUERY_VERSION_TOKEN = 89;
  
  static final int OP_AXIS_FIRST = 100;
  
  static final int COUNT_OP_AXIS = 13;
  
  static final int AXIS_ANCESTOR = 0;
  
  static final int AXIS_ANCESTOR_OR_SELF = 1;
  
  static final int AXIS_ATTRIBUTE = 2;
  
  static final int AXIS_CHILD = 3;
  
  static final int AXIS_DESCENDANT = 4;
  
  static final int AXIS_DESCENDANT_OR_SELF = 5;
  
  static final int AXIS_FOLLOWING = 6;
  
  static final int AXIS_FOLLOWING_SIBLING = 7;
  
  static final int AXIS_NAMESPACE = 8;
  
  static final int AXIS_PARENT = 9;
  
  static final int AXIS_PRECEDING = 10;
  
  static final int AXIS_PRECEDING_SIBLING = 11;
  
  static final int AXIS_SELF = 12;
  
  static final int OP_WHERE = 196;
  
  static final int PRAGMA_START_TOKEN = 197;
  
  static final int OP_BASE = 400;
  static final int OP_OR = 400;
  static final int OP_AND = 401;
  static final int OP_EQU = 402;
  static final int OP_NEQ = 403;
  static final int OP_LSS = 404;
  static final int OP_GRT = 405;
  static final int OP_LEQ = 406;
  static final int OP_GEQ = 407;
  static final int OP_IS = 408;
  static final int OP_ISNOT = 409;
  static final int OP_GRTGRT = 410;
  static final int OP_LSSLSS = 411;
  static final int OP_RANGE_TO = 412;
  static final int OP_ADD = 413;
  static final int OP_SUB = 414;
  static final int OP_MUL = 415;
  static final int OP_DIV = 416;
  static final int OP_IDIV = 417;
  static final int OP_MOD = 418;
  static final int OP_UNION = 419;
  static final int OP_INTERSECT = 420;
  static final int OP_EXCEPT = 421;
  static final int OP_INSTANCEOF = 422;
  static final int OP_TREAT_AS = 423;
  static final int OP_CASTABLE_AS = 424;
  static final int OP_CAST_AS = 425;
  static final int OP_EQ = 426;
  static final int OP_NE = 427;
  static final int OP_LT = 428;
  static final int OP_LE = 429;
  static final int OP_GT = 430;
  static final int OP_GE = 431;
  static final int OP_NODE = 230;
  static final int OP_TEXT = 231;
  static final int OP_COMMENT = 232;
  static final int OP_PI = 233;
  static final int OP_DOCUMENT = 234;
  static final int OP_ELEMENT = 235;
  static final int OP_ATTRIBUTE = 236;
  static final int OP_ITEM = 237;
  static final int OP_EMPTY_SEQUENCE = 238;
  static final int OP_SCHEMA_ATTRIBUTE = 239;
  static final int OP_SCHEMA_ELEMENT = 240;
  static final int IF_LPAREN_TOKEN = 241;
  static final int TYPESWITCH_LPAREN_TOKEN = 242;
  static final int FOR_DOLLAR_TOKEN = 243;
  static final int LET_DOLLAR_TOKEN = 244;
  static final int SOME_DOLLAR_TOKEN = 245;
  static final int EVERY_DOLLAR_TOKEN = 246;
  static final int CASE_DOLLAR_TOKEN = 247;
  static final int VALIDATE_LBRACE_TOKEN = 248;
  static final int ORDERED_LBRACE_TOKEN = 249;
  static final int UNORDERED_LBRACE_TOKEN = 250;
  static final int ELEMENT_TOKEN = 251;
  static final int ATTRIBUTE_TOKEN = 252;
  static final int TEXT_TOKEN = 253;
  static final int COMMENT_TOKEN = 254;
  static final int PI_TOKEN = 255;
  static final int DOCUMENT_TOKEN = 256;
  private int saveToken;
  private Object saveValue;
  private boolean warnedOldStyleKindTest;
  public void mark()
    throws IOException
  {
    super.mark();
    saveToken = curToken;
    saveValue = curValue;
  }
  
  public void reset()
    throws IOException
  {
    curToken = saveToken;
    curValue = saveValue;
    super.reset();
  }
  
  private int setToken(int token, int width)
  {
    curToken = token;
    curLine = (port.getLineNumber() + 1);
    curColumn = (port.getColumnNumber() + 1 - width);
    return token;
  }
  
  void checkSeparator(char ch)
  {
    if (XName.isNameStart(ch)) {
      error('e', "missing separator", "XPST0003");
    }
  }
  
  int getRawToken() throws IOException, SyntaxException
  {
    int next;
    for (;;)
    {
      next = readUnicodeChar();
      if (next < 0)
        return setToken(-1, 0);
      if ((next == 10) || (next == 13))
      {
        if (nesting <= 0) {
          return setToken(10, 0);
        }
      } else if (next == 40)
      {
        if (checkNext(':')) {
          skipComment();
        } else { if (checkNext('#')) {
            return setToken(197, 2);
          }
          return setToken(40, 1);
        }
      } else if (next == 123)
      {
        if (!checkNext('-'))
          return setToken(123, 1);
        next = read();
        if (next != 45)
        {

          unread();
          unread();
          return setToken(123, 1);
        }
        skipOldComment();
      }
      else if ((next != 32) && (next != 9)) { break;
      }
    }
    tokenBufferLength = 0;
    curLine = (port.getLineNumber() + 1);
    curColumn = port.getColumnNumber();
    char ch = (char)next;
    switch (ch) {
    case '$': case ')': case ',': 
    case ';': case '?': case '@': 
    case '[': case ']': case '}': 
      break;
    case ':': 
      if (checkNext('=')) {
        ch = 'L';
      } else if (checkNext(':'))
        ch = 'X';
      break;
    case '|': 
      ch = 'ƣ';
      break;
    case '*': 
      ch = 'Ɵ';
      break;
    case '+': 
      ch = 'Ɲ';
      break;
    case '-': 
      ch = 'ƞ';
      break;
    case '!': 
      if (checkNext('='))
        ch = 'Ɠ';
      break;
    case '/': 
      if (checkNext('/'))
        ch = 'D';
      break;
    case '=': 
      if (checkNext('>'))
        ch = 'R';
      ch = 'ƒ';
      break;
    case '>': 
      ch = checkNext('>') ? 'ƚ' : checkNext('=') ? 'Ɨ' : 'ƕ';
      
      break;
    case '<': 
      ch = checkNext('<') ? 'ƛ' : checkNext('=') ? 'Ɩ' : 'Ɣ';
      
      break;
    case '"': case '\'': 
      char saveReadState = pushNesting((char)next);
      for (;;)
      {
        next = readUnicodeChar();
        if (next < 0)
          eofError("unexpected end-of-file in string starting here");
        if (next == 38)
        {
          parseEntityOrCharRef();
        }
        else {
          if (ch == next)
          {
            next = peek();
            if (ch != next)
              break;
            next = read();
          }
          tokenBufferAppend(next);
        } }
      popNesting(saveReadState);
      ch = '"';
      break;
    case '#': case '%': case '&': case '(': case '.': case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H': case 'I': case 'J': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': case 'Z': case '\\': case '^': case '_': case '`': case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h': case 'i': case 'j': case 'k': case 'l': case 'm': case 'n': case 'o': case 'p': case 'q': case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x': case 'y': case 'z': case '{': default: 
      if ((Character.isDigit(ch)) || ((ch == '.') && (Character.isDigit((char)peek()))))
      {

        boolean seenDot = ch == '.';
        for (;;)
        {
          tokenBufferAppend(ch);
          next = read();
          if (next >= 0)
          {
            ch = (char)next;
            if (ch == '.')
            {
              if (!seenDot) {
                seenDot = true;
              }
            } else if (!Character.isDigit(ch)) break;
          }
        }
        if ((next == 101) || (next == 69))
        {
          tokenBufferAppend((char)next);
          next = read();
          if ((next == 43) || (next == 45))
          {
            tokenBufferAppend(next);
            next = read();
          }
          int expDigits = 0;
          

          while (next >= 0)
          {
            ch = (char)next;
            if (!Character.isDigit(ch))
            {
              checkSeparator(ch);
              unread();
              break;
            }
            tokenBufferAppend(ch);
            next = read();
            expDigits++;
          }
          if (expDigits == 0)
            error('e', "no digits following exponent", "XPST0003");
          ch = '2';
        }
        else
        {
          ch = seenDot ? '1' : '0';
          if (next >= 0)
          {
            checkSeparator((char)next);
            unread(next);
          }
        }
      }
      else if (ch == '.')
      {
        if (checkNext('.')) {
          ch = '3';
        }
      }
      else if (XName.isNameStart(ch))
      {
        for (;;)
        {
          tokenBufferAppend(ch);
          next = read();
          ch = (char)next;
          if (!XName.isNamePart(ch))
            break;
        }
        if (next < 0) {
          ch = 'A';
        }
        else {
          if (next != 58) {
            ch = 'A';
          }
          else {
            next = read();
            if (next < 0)
              eofError("unexpected end-of-file after NAME ':'");
            ch = (char)next;
            if (XName.isNameStart(ch))
            {
              tokenBufferAppend(58);
              for (;;)
              {
                tokenBufferAppend(ch);
                next = read();
                ch = (char)next;
                if (!XName.isNamePart(ch))
                  break;
              }
              ch = 'Q';
            }
            else if (ch == '=')
            {
              unread(ch);
              ch = 'A';
            }
            else {
              ch = 'C';
            } }
          unread(next);
        }
      }
      else if ((ch >= ' ') && (ch < '')) {
        syntaxError("invalid character '" + ch + '\'');
      } else {
        syntaxError("invalid character '\\u" + Integer.toHexString(ch) + '\''); }
      break; }
    curToken = ch;
    return ch;
  }
  




  public void getDelimited(String delimiter)
    throws IOException, SyntaxException
  {
    if (!readDelimited(delimiter)) {
      eofError("unexpected end-of-file looking for '" + delimiter + '\'');
    }
  }
  
  public void appendNamedEntity(String name) {
    name = name.intern();
    char ch = '?';
    if (name == "lt") {
      ch = '<';
    } else if (name == "gt") {
      ch = '>';
    } else if (name == "amp") {
      ch = '&';
    } else if (name == "quot") {
      ch = '"';
    } else if (name == "apos") {
      ch = '\'';
    } else
      error("unknown enity reference: '" + name + "'");
    tokenBufferAppend(ch);
  }
  
  boolean match(String word1, String word2, boolean force)
    throws IOException, SyntaxException
  {
    if (match(word1))
    {
      mark();
      getRawToken();
      if (match(word2))
      {
        reset();
        getRawToken();
        return true;
      }
      reset();
      if (force)
      {
        error('e', "'" + word1 + "' must be followed by '" + word2 + "'", "XPST0003");
        
        return true;
      }
    }
    return false;
  }
  



  int peekOperator()
    throws IOException, SyntaxException
  {
    while (curToken == 10)
    {
      if (nesting == 0)
        return 10;
      getRawToken();
    }
    if (curToken == 65)
    {
      int len = tokenBufferLength;
      char c1;
      char c2; switch (len)
      {
      case 2: 
        c1 = tokenBuffer[0];
        c2 = tokenBuffer[1];
        if ((c1 == 'o') && (c2 == 'r')) {
          curToken = 400;
        } else if ((c1 == 't') && (c2 == 'o')) {
          curToken = 412;
        } else if ((c1 == 'i') && (c2 == 's')) {
          curToken = 408;
        } else if ((c1 == 'e') && (c2 == 'q')) {
          curToken = 426;
        } else if ((c1 == 'n') && (c2 == 'e')) {
          curToken = 427;
        } else if (c1 == 'g')
        {
          if (c2 == 'e') { curToken = 431;
          } else if (c2 == 't') curToken = 430;
        }
        else if (c1 == 'l')
        {
          if (c2 == 'e') { curToken = 429;
          } else if (c2 == 't') { curToken = 428;
          }
        }
        break;
      case 3: 
        c1 = tokenBuffer[0];
        c2 = tokenBuffer[1];
        char c3 = tokenBuffer[2];
        if (c1 == 'a')
        {
          if ((c2 == 'n') && (c3 == 'd')) {
            curToken = 401;
          }
        } else if (c1 == 'm') {
          if ((c2 == 'u') && (c3 == 'l'))
            curToken = 415;
          if ((c2 == 'o') && (c3 == 'd')) {
            curToken = 418;
          }
        } else if ((c1 == 'd') && 
          (c2 == 'i') && (c3 == 'v')) {
          curToken = 416;
        }
        break;
      case 4: 
        if (match("idiv")) {
          curToken = 417;
        } else if (match("cast", "as", true))
          curToken = 425;
        break;
      case 5: 
        if (match("where")) {
          curToken = 196;
        } else if (match("isnot")) {
          curToken = 409;
        } else if (match("union")) {
          curToken = 419;
        } else if (match("treat", "as", true))
          curToken = 423;
        break;
      case 6: 
        if (match("except"))
          curToken = 421;
        break;
      case 8: 
        if (match("instance", "of", true)) {
          curToken = 422;
        } else if (match("castable", "as", true))
          curToken = 424;
        break;
      case 9: 
        if (match("intersect"))
          curToken = 420;
        break;
      case 10: 
        if (match("instanceof"))
        {
          warnOldVersion("use 'instanceof of' (two words) instead of 'instanceof'");
          curToken = 422;
        }
        
        break;
      }
      
    }
    return curToken;
  }
  





  private boolean lookingAt(String word0, String word1)
    throws IOException, SyntaxException
  {
    if (!word0.equals(curValue))
      return false;
    int i = 0;
    int len = word1.length();
    for (;;)
    {
      int ch = read();
      if (i == len)
      {
        if (ch < 0)
          return true;
        if (!XName.isNamePart((char)ch))
        {
          unread();
          return true;
        }
        i++;
      }
      else {
        if ((ch < 0) || (ch != word1.charAt(i++))) break;
      }
    }
    port.skip(-i);
    return false;
  }
  

  int getAxis()
  {
    String name = new String(tokenBuffer, 0, tokenBufferLength).intern();
    
    int i = 13; for (;;) { i--; if (i >= 0)
        if (axisNames[i] == name) break;
    }
    if ((i < 0) || (i == 8))
    {

      error('e', "unknown axis name '" + name + '\'', "XPST0003");
      i = 3;
    }
    return (char)(100 + i);
  }
  



  int peekOperand()
    throws IOException, SyntaxException
  {
    while (curToken == 10)
      getRawToken();
    if ((curToken == 65) || (curToken == 81))
    {
      int next = skipSpace(nesting != 0);
      switch (tokenBuffer[0])
      {
      case 'a': 
        if (match("attribute"))
        {
          if (next == 40)
            return this.curToken = 'ì';
          if ((next == 123) || (XName.isNameStart((char)next)))
          {
            unread();
            return this.curToken = 'ü';
          }
        }
        
        break;
      case 'c': 
        if (match("comment"))
        {
          if (next == 40)
            return this.curToken = 'è';
          if (next == 123)
          {
            unread();
            return this.curToken = 'þ';
          }
        }
        break;
      case 'd': 
        if ((next == 123) && (match("document")))
        {
          unread();
          return this.curToken = 'Ā';
        }
        if ((next == 40) && (match("document-node")))
          return this.curToken = 'ê';
        break;
      case 'e': 
        if (match("element"))
        {
          if (next == 40)
            return this.curToken = 'ë';
          if ((next == 123) || (XName.isNameStart((char)next)))
          {
            unread();
            return this.curToken = 'û';
          }
        }
        else {
          if ((next == 40) && (match("empty-sequence")))
            return this.curToken = 'î';
          if ((next == 36) && (match("every")))
            return this.curToken = 'ö';
        }
        break;
      case 'f':  if ((next == 36) && (match("for")))
          return this.curToken = 'ó';
        break;
      case 'i': 
        if ((next == 40) && (match("if")))
          return this.curToken = 'ñ';
        if ((next == 40) && (match("item")))
          return this.curToken = 'í';
        break;
      case 'l': 
        if ((next == 36) && (match("let")))
          return this.curToken = 'ô';
        break;
      case 'n': 
        if ((next == 40) && (match("node")))
          return this.curToken = 'æ';
        break;
      case 'o': 
        if ((next == 123) && (match("ordered")))
          return this.curToken = 'ù';
        break;
      case 'p': 
        if (match("processing-instruction"))
        {
          if (next == 40)
            return this.curToken = 'é';
          if ((next == 123) || (XName.isNameStart((char)next)))
          {
            unread();
            return this.curToken = 'ÿ';
          }
        }
        
        break;
      case 's': 
        if ((next == 36) && (match("some")))
          return this.curToken = 'õ';
        if ((next == 40) && (match("schema-attribute")))
          return this.curToken = 'ï';
        if ((next == 40) && (match("schema-element")))
          return this.curToken = 'ð';
        break;
      case 't': 
        if (match("text"))
        {
          if (next == 40)
            return this.curToken = 'ç';
          if (next == 123)
          {
            unread();
            return this.curToken = 'ý';
          }
        }
        if ((next == 40) && (match("typeswitch")))
          return this.curToken = 'ò';
        break;
      case 'u': 
        if ((next == 123) && (match("unordered")))
          return this.curToken = 'ú';
        break;
      case 'v': 
        if ((next == 123) && (match("validate")))
          return this.curToken = 'ø';
        break;
      }
      if ((next == 40) && (peek() != 58))
      {
        return this.curToken = 70;
      }
      if ((next == 58) && (peek() == 58))
        return this.curToken = getAxis();
      String name = new String(tokenBuffer, 0, tokenBufferLength);
      curValue = name;
      switch (next)
      {
      case 98: 
        if (lookingAt("declare", "ase-uri"))
          return this.curToken = 66;
        if (lookingAt("declare", "oundary-space"))
          return this.curToken = 83;
        break;
      case 99: 
        if (lookingAt("declare", "onstruction"))
          return this.curToken = 75;
        if (lookingAt("declare", "opy-namespaces"))
          return this.curToken = 76;
        break;
      case 100: 
        if (lookingAt("declare", "efault"))
        {
          getRawToken();
          if (match("function"))
            return this.curToken = 79;
          if (match("element"))
            return this.curToken = 69;
          if (match("collation"))
            return this.curToken = 71;
          if (match("order"))
            return this.curToken = 72;
          error("unrecognized/unimplemented 'declare default'");
          skipToSemicolon();
          return peekOperand();
        }
      case 101: 
        if (lookingAt("default", "lement"))
        {
          warnOldVersion("replace 'default element' by 'declare default element namespace'");
          return this.curToken = 69;
        }
        break;
      case 102: 
        if (lookingAt("declare", "unction"))
          return this.curToken = 80;
        if (lookingAt("define", "unction"))
        {
          warnOldVersion("replace 'define function' by 'declare function'");
          return this.curToken = 80;
        }
        if (lookingAt("default", "unction"))
        {
          warnOldVersion("replace 'default function' by 'declare default function namespace'");
          return this.curToken = 79;
        }
        break;
      case 109: 
        if (lookingAt("import", "odule"))
          return this.curToken = 73;
        break;
      case 110: 
        if (lookingAt("declare", "amespace"))
          return this.curToken = 78;
        if (lookingAt("default", "amespace"))
        {
          warnOldVersion("replace 'default namespace' by 'declare default element namespace'");
          return this.curToken = 69;
        }
        if (lookingAt("module", "amespace"))
          return this.curToken = 77;
        break;
      case 111: 
        if (lookingAt("declare", "rdering"))
          return this.curToken = 85;
        if (lookingAt("declare", "ption"))
          return this.curToken = 111;
        break;
      case 115: 
        if (lookingAt("import", "chema"))
          return this.curToken = 84;
        break;
      case 118: 
        if (lookingAt("declare", "ariable"))
          return this.curToken = 86;
        if (lookingAt("define", "ariable"))
        {
          warnOldVersion("replace 'define variable' by 'declare variable'");
          return this.curToken = 86;
        }
        if (lookingAt("xquery", "ersion"))
          return this.curToken = 89;
        break;
      case 120: 
        if (lookingAt("declare", "mlspace"))
        {
          warnOldVersion("replace 'define xmlspace' by 'declare boundary-space'");
          return this.curToken = 83;
        }
        break;
      }
      if (next >= 0)
      {
        unread();
        if ((XName.isNameStart((char)next)) && (curValue.equals("define")))
        {
          getRawToken();
          curToken = 87;
        }
      }
      return curToken;
    }
    if (curToken == 67)
    {
      int next = read();
      if (next == 58) {
        curToken = getAxis();
      } else
        unread(next);
    }
    return curToken;
  }
  

  void checkAllowedNamespaceDeclaration(String prefix, String uri, boolean inConstructor)
  {
    boolean xmlPrefix = "xml".equals(prefix);
    if ("http://www.w3.org/XML/1998/namespace".equals(uri))
    {
      if ((!xmlPrefix) || (!inConstructor)) {
        error('e', "namespace uri cannot be the same as the prefined xml namespace", "XQST0070");
      }
    }
    else if ((xmlPrefix) || ("xmlns".equals(prefix))) {
      error('e', "namespace prefix cannot be 'xml' or 'xmlns'", "XQST0070");
    }
  }
  
  void pushNamespace(String prefix, String uri)
  {
    if (uri.length() == 0)
      uri = null;
    prologNamespaces = new NamespaceBinding(prefix, uri, prologNamespaces);
  }
  
  public XQParser(InPort port, SourceMessages messages, XQuery interp)
  {
    super(port, messages);
    interpreter = interp;
    nesting = 1;
    

    NamespaceBinding ns = builtinNamespaces;
    prologNamespaces = ns;
  }
  
  public void setInteractive(boolean v)
  {
    if (isInteractive() != v)
      if (v) nesting -= 1; else nesting += 1;
    super.setInteractive(v);
  }
  
  private static final int priority(int opcode)
  {
    switch (opcode)
    {
    case 400: 
      return 1;
    case 401: 
      return 2;
    case 402: case 403: case 404: 
    case 405: case 406: case 407: 
    case 408: case 409: case 410: 
    case 411: case 426: case 427: 
    case 428: case 429: 
    case 430: case 431: 
      return 3;
    case 412: 
      return 4;
    case 413: case 414: 
      return 5;
    case 415: case 416: case 417: case 418: 
      return 6;
    case 419: 
      return 7;
    case 420: case 421: 
      return 8;
    case 422: 
      return 9;
    case 423: 
      return 10;
    case 424: 
      return 11;
    case 425: 
      return 12;
    }
    return 0;
  }
  


  static Expression makeBinary(Expression func, Expression exp1, Expression exp2)
  {
    Expression[] args = new Expression[2];
    args[0] = exp1;
    args[1] = exp2;
    return new ApplyExp(func, args);
  }
  
  static Expression makeExprSequence(Expression exp1, Expression exp2) {
    return new ApplyExp(gnu.kawa.functions.AppendValues.appendValues, new Expression[] { exp1, exp2 });
  }
  
  Expression makeBinary(int op, Expression exp1, Expression exp2)
    throws IOException, SyntaxException
  {
    Expression func;
    switch (op)
    {
    case 413: 
      func = makeFunctionExp("gnu.xquery.util.ArithOp", "add", "+");
      break;
    case 414: 
      func = makeFunctionExp("gnu.xquery.util.ArithOp", "sub", "-");
      break;
    case 415: 
      func = makeFunctionExp("gnu.xquery.util.ArithOp", "mul", "*");
      break;
    case 416: 
      func = makeFunctionExp("gnu.xquery.util.ArithOp", "div", "div");
      break;
    case 417: 
      func = makeFunctionExp("gnu.xquery.util.ArithOp", "idiv", "idiv");
      break;
    case 418: 
      func = makeFunctionExp("gnu.xquery.util.ArithOp", "mod", "mod");
      break;
    case 426: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "valEq", "eq");
      break;
    case 427: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "valNe", "ne");
      break;
    case 428: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "valLt", "lt");
      break;
    case 429: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "valLe", "le");
      break;
    case 430: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "valGt", "gt");
      break;
    case 431: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "valGe", "ge");
      break;
    case 402: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "=");
      break;
    case 403: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "!=");
      break;
    case 404: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "<");
      break;
    case 406: 
      func = makeFunctionExp("gnu.xquery.util.Compare", "<=");
      break;
    case 405: 
      func = makeFunctionExp("gnu.xquery.util.Compare", ">");
      break;
    case 407: 
      func = makeFunctionExp("gnu.xquery.util.Compare", ">=");
      break;
    case 408: 
      func = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Eq", "is");
      break;
    case 409: 
      func = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Ne", "isnot");
      break;
    case 410: 
      func = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Gr", ">>");
      break;
    case 411: 
      func = makeFunctionExp("gnu.kawa.xml.NodeCompare", "$Ls", "<<");
      break;
    case 412: 
      func = makeFunctionExp("kawa.lib.xquery.Xutils", "integerRange");
      break;
    case 419: 
      func = makeFunctionExp("gnu.kawa.xml.UnionNodes", "unionNodes");
      break;
    case 420: 
      func = makeFunctionExp("gnu.kawa.xml.IntersectNodes", "intersectNodes");
      
      break;
    case 421: 
      func = makeFunctionExp("gnu.kawa.xml.IntersectNodes", "exceptNodes");
      break;
    case 422: case 423: case 424: case 425: default: 
      return syntaxError("unimplemented binary op: " + op);
    }
    return makeBinary(func, exp1, exp2);
  }
  
  private void parseSimpleKindType()
    throws IOException, SyntaxException
  {
    getRawToken();
    if (curToken == 41) {
      getRawToken();
    } else {
      error("expected ')'");
    }
  }
  
  public Expression parseNamedNodeType(boolean attribute) throws IOException, SyntaxException
  {
    Expression tname = null;
    getRawToken();
    Expression qname; if (curToken == 41)
    {
      Expression qname = QuoteExp.getInstance(ElementType.MATCH_ANY_QNAME);
      getRawToken();
    }
    else {
      Expression qname;
      if ((curToken == 81) || (curToken == 65)) {
        qname = parseNameTest(attribute);
      }
      else {
        if (curToken != 415)
          syntaxError("expected QName or *");
        qname = QuoteExp.getInstance(ElementType.MATCH_ANY_QNAME);
      }
      
      getRawToken();
      if (curToken == 44)
      {
        getRawToken();
        if ((curToken == 81) || (curToken == 65))
        {
          tname = parseDataType();
        }
        else
          syntaxError("expected QName");
      }
      if (curToken == 41) {
        getRawToken();
      } else
        error("expected ')' after element");
    }
    return makeNamedNodeType(attribute, qname, tname);
  }
  

  static Expression makeNamedNodeType(boolean attribute, Expression qname, Expression tname)
  {
    Expression[] name = new Expression[2];
    ClassType nodeType = ClassType.make(attribute ? "gnu.kawa.xml.AttributeType" : "gnu.kawa.xml.ElementType");
    

    ApplyExp elt = new ApplyExp(nodeType.getDeclaredMethod("make", 1), new Expression[] { qname });
    
    elt.setFlag(4);
    if (tname == null) {
      return elt;
    }
    

    return new BeginExp(tname, elt);
  }
  


  private void warnOldStyleKindTest()
  {
    if (warnedOldStyleKindTest)
      return;
    error('w', "old-style KindTest - first one here");
    warnedOldStyleKindTest = true;
  }
  

  public Expression parseOptionalTypeDeclaration()
    throws IOException, SyntaxException
  {
    if (!match("as"))
      return null;
    getRawToken();
    return parseDataType();
  }
  
  public Expression parseDataType()
    throws IOException, SyntaxException
  {
    Expression etype = parseItemType();
    int max;
    int min; int max; if (etype == null)
    {
      if (curToken != 238)
        return syntaxError("bad syntax - expected DataType");
      parseSimpleKindType();
      if ((curToken == 63) || (curToken == 413) || (curToken == 415))
      {
        getRawToken();
        return syntaxError("occurrence-indicator meaningless after empty-sequence()");
      }
      etype = QuoteExp.getInstance(gnu.kawa.reflect.OccurrenceType.emptySequenceType);
      int min = 0;
      max = 0;
    } else { int max;
      if (curToken == 63)
      {
        int min = 0;
        max = 1;
      } else { int max;
        if (curToken == 413)
        {
          int min = 1;
          max = -1;
        } else { int max;
          if (curToken == 415)
          {
            int min = 0;
            max = -1;
          }
          else
          {
            min = 1;
            max = 1;
          } } } }
    if (parseContext == 67)
    {
      if (max != 1)
        return syntaxError("type to 'cast as' or 'castable as' must be a 'SingleType'");
    }
    if (min != max)
    {
      getRawToken();
      Expression[] args = { etype, QuoteExp.getInstance(IntNum.make(min)), QuoteExp.getInstance(IntNum.make(max)) };
      

      ApplyExp otype = new ApplyExp(proc_OccurrenceType_getInstance, args);
      

      otype.setFlag(4);
      return otype;
    }
    return etype;
  }
  
  static PrimProcedure proc_OccurrenceType_getInstance = new PrimProcedure(ClassType.make("gnu.kawa.reflect.OccurrenceType").getDeclaredMethod("getInstance", 3));
  

  public Expression parseMaybeKindTest()
    throws IOException, SyntaxException
  {
    Type type;
    
    switch (curToken)
    {
    case 235: 
    case 236: 
      return parseNamedNodeType(curToken == 236);
    
    case 231: 
      parseSimpleKindType();
      type = NodeType.textNodeTest;
      break;
    
    case 232: 
      parseSimpleKindType();
      type = NodeType.commentNodeTest;
      break;
    
    case 234: 
      parseSimpleKindType();
      type = NodeType.documentNodeTest;
      break;
    
    case 230: 
      parseSimpleKindType();
      type = NodeType.anyNodeTest;
      break;
    
    case 233: 
      getRawToken();
      String piTarget = null;
      if ((curToken == 65) || (curToken == 34))
      {
        piTarget = new String(tokenBuffer, 0, tokenBufferLength);
        getRawToken();
      }
      if (curToken == 41) {
        getRawToken();
      } else
        error("expected ')'");
      type = gnu.kawa.xml.ProcessingInstructionType.getInstance(piTarget);
      break;
    
    default: 
      return null;
    }
    return QuoteExp.getInstance(type);
  }
  
  public Expression parseItemType()
    throws IOException, SyntaxException
  {
    peekOperand();
    Expression etype = parseMaybeKindTest();
    
    if (etype != null) {
      Type type;
      if (parseContext == 67)
      {
        type = gnu.kawa.xml.XDataType.anyAtomicType;
      } else
        return etype;
    } else { Type type;
      if (curToken == 237)
      {
        parseSimpleKindType();
        type = SingletonType.getInstance();
      } else {
        if ((curToken == 65) || (curToken == 81))
        {
          String tname = new String(tokenBuffer, 0, tokenBufferLength);
          ReferenceExp rexp = new ReferenceExp(tname);
          rexp.setFlag(16);
          maybeSetLine(rexp, curLine, curColumn);
          getRawToken();
          return rexp;
        }
        
        return null; } }
    Type type; return QuoteExp.getInstance(type);
  }
  




  Object parseURILiteral()
    throws IOException, SyntaxException
  {
    getRawToken();
    if (curToken != 34)
      return declError("expected a URILiteral");
    String str = new String(tokenBuffer, 0, tokenBufferLength);
    str = gnu.xml.TextUtils.replaceWhitespace(str, true);
    



    return str;
  }
  
  Expression parseExpr()
    throws IOException, SyntaxException
  {
    return parseExprSingle();
  }
  
  final Expression parseExprSingle()
    throws IOException, SyntaxException
  {
    int startLine = curLine;
    int startColumn = curColumn;
    peekOperand();
    switch (curToken)
    {




    case 241: 
      return parseIfExpr();
    case 242: 
      return parseTypeSwitch();
    case 243: 
      return parseFLWRExpression(true);
    case 244: 
      return parseFLWRExpression(false);
    case 245: 
      return parseQuantifiedExpr(false);
    case 246: 
      return parseQuantifiedExpr(true); }
    
    return parseBinaryExpr(priority(400));
  }
  

  Expression parseBinaryExpr(int prio)
    throws IOException, SyntaxException
  {
    Expression exp = parseUnaryExpr();
    for (;;)
    {
      int token = peekOperator();
      if ((token == 10) || ((token == 404) && (peek() == 47)))
      {

        return exp; }
      int tokPriority = priority(token);
      if (tokPriority < prio)
        return exp;
      char saveReadState = pushNesting('%');
      getRawToken();
      popNesting(saveReadState);
      if ((token >= 422) && (token <= 425))
      {
        if ((token == 425) || (token == 424))
          parseContext = 67;
        Expression type = parseDataType();
        parseContext = 0;
        Expression[] args = new Expression[2];
        Expression func;
        switch (token)
        {
        case 422: 
          args[0] = exp;
          args[1] = type;
          func = makeFunctionExp("gnu.xquery.lang.XQParser", "instanceOf");
          
          break;
        case 424: 
          args[0] = exp;
          args[1] = type;
          func = new ReferenceExp(XQResolveNames.castableAsDecl);
          break;
        case 423: 
          args[0] = type;
          args[1] = exp;
          func = makeFunctionExp("gnu.xquery.lang.XQParser", "treatAs");
          
          break;
        default: 
          args[0] = type;
          args[1] = exp;
          func = new ReferenceExp(XQResolveNames.castAsDecl);
        }
        
        exp = new ApplyExp(func, args);
      }
      else if (token == 422)
      {
        Expression[] args = { exp, parseDataType() };
        exp = new ApplyExp(makeFunctionExp("gnu.xquery.lang.XQParser", "instanceOf"), args);

      }
      else
      {

        Expression exp2 = parseBinaryExpr(tokPriority + 1);
        if (token == 401) {
          exp = new IfExp(booleanValue(exp), booleanValue(exp2), XQuery.falseExp);
        } else if (token == 400) {
          exp = new IfExp(booleanValue(exp), XQuery.trueExp, booleanValue(exp2));
        } else {
          exp = makeBinary(token, exp, exp2);
        }
      }
    }
  }
  
  Expression parseUnaryExpr() throws IOException, SyntaxException
  {
    Expression exp;
    if ((curToken == 414) || (curToken == 413))
    {
      int op = curToken;
      getRawToken();
      Expression exp = parseUnaryExpr();
      Expression func = makeFunctionExp("gnu.xquery.util.ArithOp", op == 413 ? "plus" : "minus", op == 413 ? "+" : "-");
      


      exp = new ApplyExp(func, new Expression[] { exp });
    }
    else {
      exp = parseUnionExpr(); }
    return exp;
  }
  
  Expression parseUnionExpr()
    throws IOException, SyntaxException
  {
    Expression exp = parseIntersectExceptExpr();
    for (;;)
    {
      int op = peekOperator();
      if (op != 419)
        break;
      getRawToken();
      Expression exp2 = parseIntersectExceptExpr();
      exp = makeBinary(op, exp, exp2);
    }
    return exp;
  }
  
  Expression parseIntersectExceptExpr()
    throws IOException, SyntaxException
  {
    Expression exp = parsePathExpr();
    for (;;)
    {
      int op = peekOperator();
      if ((op != 420) && (op != 421))
        break;
      getRawToken();
      Expression exp2 = parsePathExpr();
      exp = makeBinary(op, exp, exp2);
    }
    return exp;
  }
  
  Expression parsePathExpr()
    throws IOException, SyntaxException
  {
    Expression step1;
    if ((curToken == 47) || (curToken == 68))
    {
      Declaration dotDecl = comp.lexical.lookup(DOT_VARNAME, false);
      Expression dot;
      Expression dot; if (dotDecl == null) {
        dot = syntaxError("context item is undefined", "XPDY0002");
      } else
        dot = new ReferenceExp(DOT_VARNAME, dotDecl);
      Expression step1 = new ApplyExp(ClassType.make("gnu.xquery.util.NodeUtils").getDeclaredMethod("rootDocument", 1), new Expression[] { dot });
      

      int next = skipSpace(nesting != 0);
      unread(next);
      if ((next < 0) || (next == 41) || (next == 125))
      {
        getRawToken();
        return step1;
      }
    }
    else {
      step1 = parseStepExpr(); }
    return parseRelativePathExpr(step1);
  }
  



  Expression parseNameTest(boolean attribute)
    throws IOException, SyntaxException
  {
    String local = null;String prefix = null;
    if (curToken == 81)
    {
      int colon = tokenBufferLength;
      while (tokenBuffer[(--colon)] != ':') {}
      prefix = new String(tokenBuffer, 0, colon);
      colon++;
      local = new String(tokenBuffer, colon, tokenBufferLength - colon);
    }
    else {
      if (curToken == 415)
      {
        int next = read();
        local = "";
        if (next != 58) {
          unread(next);
        }
        else {
          next = read();
          if (next < 0)
            eofError("unexpected end-of-file after '*:'");
          if (XName.isNameStart((char)next))
          {
            unread();
            getRawToken();
            if (curToken != 65) {
              syntaxError("invalid name test");
            } else {
              local = new String(tokenBuffer, 0, tokenBufferLength).intern();
            }
          }
          else if (next != 42) {
            syntaxError("missing local-name after '*:'");
          } }
        return QuoteExp.getInstance(Symbol.makeUninterned(local));
      }
      if (curToken == 65)
      {
        local = new String(tokenBuffer, 0, tokenBufferLength);
        if (attribute)
          return new QuoteExp(Namespace.EmptyNamespace.getSymbol(local.intern()));
        prefix = null;
      }
      else if (curToken == 67)
      {
        prefix = new String(tokenBuffer, 0, tokenBufferLength);
        int next = read();
        if (next != 42)
          syntaxError("invalid characters after 'NCName:'");
        local = "";
      } }
    if (prefix != null)
      prefix = prefix.intern();
    Expression[] args = new Expression[3];
    args[0] = new ApplyExp(new ReferenceExp(XQResolveNames.resolvePrefixDecl), new Expression[] { QuoteExp.getInstance(prefix) });
    
    args[1] = new QuoteExp(local == null ? "" : local);
    args[2] = new QuoteExp(prefix);
    ApplyExp make = new ApplyExp(Compilation.typeSymbol.getDeclaredMethod("make", 3), args);
    

    make.setFlag(4);
    return make;
  }
  
  Expression parseNodeTest(int axis)
    throws IOException, SyntaxException
  {
    int token = peekOperand();
    Expression[] args = new Expression[1];
    
    Expression etype = parseMaybeKindTest();
    
    if (etype != null)
    {
      args[0] = etype;
    }
    else if ((curToken == 65) || (curToken == 81) || (curToken == 67) || (curToken == 415))
    {

      args[0] = makeNamedNodeType(axis == 2 ? 1 : false, parseNameTest(axis == 2 ? 1 : false), null);
    }
    else
    {
      if (axis >= 0) {
        return syntaxError("unsupported axis '" + axisNames[axis] + "::'");
      }
      return null;
    }
    Declaration dotDecl = comp.lexical.lookup(DOT_VARNAME, false);
    Expression dot;
    Expression dot; if (dotDecl == null) {
      dot = syntaxError("node test when context item is undefined", "XPDY0002");
    } else
      dot = new ReferenceExp(DOT_VARNAME, dotDecl);
    if (etype == null)
      getRawToken();
    Expression makeAxisStep;
    Expression makeAxisStep;
    if ((axis == 3) || (axis == -1)) {
      makeAxisStep = makeChildAxisStep; } else { Expression makeAxisStep;
      if (axis == 4) {
        makeAxisStep = makeDescendantAxisStep;
      }
      else {
        String axisName;
        switch (axis) {
        case 5: 
          axisName = "DescendantOrSelf"; break;
        case 12:  axisName = "Self"; break;
        case 9:  axisName = "Parent"; break;
        case 0:  axisName = "Ancestor"; break;
        case 1:  axisName = "AncestorOrSelf"; break;
        case 6:  axisName = "Following"; break;
        case 7:  axisName = "FollowingSibling"; break;
        case 10:  axisName = "Preceding"; break;
        case 11:  axisName = "PrecedingSibling"; break;
        case 2:  axisName = "Attribute"; break;
        case 3: case 4: case 8: default:  throw new Error();
        }
        makeAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml." + axisName + "Axis", "make", 1));
      }
    }
    

    ApplyExp mkAxis = new ApplyExp(makeAxisStep, args);
    mkAxis.setFlag(4);
    return new ApplyExp(mkAxis, new Expression[] { dot });
  }
  
  public static QuoteExp makeChildAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml.ChildAxis", "make", 1));
  
  public static QuoteExp makeDescendantAxisStep = QuoteExp.getInstance(new PrimProcedure("gnu.kawa.xml.DescendantAxis", "make", 1));
  
  int enclosedExpressionsSeen;
  
  Expression parseRelativePathExpr(Expression exp)
    throws IOException, SyntaxException
  {
    Expression beforeSlashSlash = null;
    
    while ((curToken == 47) || (curToken == 68))
    {
      boolean descendants = curToken == 68;
      
      LambdaExp lexp = new LambdaExp(3);
      Declaration dotDecl = lexp.addDeclaration(DOT_VARNAME);
      dotDecl.setFlag(262144L);
      dotDecl.setType(NodeType.anyNodeTest);
      dotDecl.noteValueUnknown();
      lexp.addDeclaration(POSITION_VARNAME, LangPrimType.intType);
      lexp.addDeclaration(LAST_VARNAME, LangPrimType.intType);
      comp.push(lexp);
      if (descendants)
      {
        curToken = 47;
        Expression dot = new ReferenceExp(DOT_VARNAME, dotDecl);
        Expression[] args = { dot };
        gnu.kawa.xml.TreeScanner op = gnu.kawa.xml.DescendantOrSelfAxis.anyNode;
        body = new ApplyExp(op, args);
        beforeSlashSlash = exp;
      }
      else
      {
        getRawToken();
        Expression exp2 = parseStepExpr();
        
        Expression func;
        
        ApplyExp aexp;
        if ((beforeSlashSlash != null) && ((exp2 instanceof ApplyExp)) && (((func = ((ApplyExp)exp2).getFunction()) instanceof ApplyExp)) && ((aexp = (ApplyExp)func).getFunction() == makeChildAxisStep))
        {



          aexp.setFunction(makeDescendantAxisStep);
          exp = beforeSlashSlash;
        }
        
        body = exp2;
        beforeSlashSlash = null;
      }
      comp.pop(lexp);
      


































      Expression[] args = { exp, lexp };
      exp = new ApplyExp(gnu.xquery.util.RelativeStep.relativeStep, args);
    }
    return exp;
  }
  

  Expression parseStepExpr()
    throws IOException, SyntaxException
  {
    if ((curToken == 46) || (curToken == 51))
    {
      int axis = curToken == 46 ? 12 : 9;
      getRawToken();
      Declaration dotDecl = comp.lexical.lookup(DOT_VARNAME, false);
      Expression exp;
      Expression exp; if (dotDecl == null) {
        exp = syntaxError("context item is undefined", "XPDY0002");
      } else
        exp = new ReferenceExp(DOT_VARNAME, dotDecl);
      if (axis == 9)
      {
        Expression[] args = { exp };
        exp = new ApplyExp(gnu.kawa.xml.ParentAxis.make(NodeType.anyNodeTest), args);
      }
      

      return parseStepQualifiers(exp, axis == 12 ? -1 : axis);
    }
    int axis = peekOperand() - 100;
    Expression unqualifiedStep;
    Expression unqualifiedStep; if ((axis >= 0) && (axis < 13))
    {
      getRawToken();
      unqualifiedStep = parseNodeTest(axis);
    } else { Expression unqualifiedStep;
      if (curToken == 64)
      {
        getRawToken();
        axis = 2;
        unqualifiedStep = parseNodeTest(axis);
      } else { Expression unqualifiedStep;
        if (curToken == 236)
        {
          axis = 2;
          unqualifiedStep = parseNodeTest(axis);
        }
        else
        {
          unqualifiedStep = parseNodeTest(-1);
          if (unqualifiedStep != null)
          {
            axis = 3;
          }
          else
          {
            axis = -1;
            unqualifiedStep = parsePrimaryExpr();
          }
        } } }
    return parseStepQualifiers(unqualifiedStep, axis);
  }
  


  Expression parseStepQualifiers(Expression exp, int axis)
    throws IOException, SyntaxException
  {
    while (curToken == 91)
    {
      int startLine = getLineNumber() + 1;
      int startColumn = getColumnNumber() + 1;
      int saveSeenPosition = seenPosition;
      int saveSawLast = seenLast;
      getRawToken();
      LambdaExp lexp = new LambdaExp(3);
      maybeSetLine(lexp, startLine, startColumn);
      Declaration dot = lexp.addDeclaration(DOT_VARNAME);
      if (axis >= 0) {
        dot.setType(NodeType.anyNodeTest);
      } else
        dot.setType(SingletonType.getInstance());
      lexp.addDeclaration(POSITION_VARNAME, Type.intType);
      lexp.addDeclaration(LAST_VARNAME, Type.intType);
      comp.push(lexp);
      dot.noteValueUnknown();
      Expression cond = parseExprSequence(93, false);
      if (curToken == -1)
        eofError("missing ']' - unexpected end-of-file");
      Procedure valuesFilter;
      Procedure valuesFilter;
      if (axis < 0)
      {
        char kind = 'P';
        valuesFilter = ValuesFilter.exprFilter;
      } else { Procedure valuesFilter;
        if ((axis == 0) || (axis == 1) || (axis == 9) || (axis == 10) || (axis == 11))
        {


          char kind = 'R';
          valuesFilter = ValuesFilter.reverseFilter;
        }
        else
        {
          char kind = 'F';
          valuesFilter = ValuesFilter.forwardFilter;
        }
      }
      


      maybeSetLine(cond, startLine, startColumn);
      comp.pop(lexp);
      body = cond;
      getRawToken();
      Expression[] args = { exp, lexp };
      exp = new ApplyExp(valuesFilter, args);
    }
    





    return exp;
  }
  






  Expression parsePrimaryExpr()
    throws IOException, SyntaxException
  {
    Expression exp = parseMaybePrimaryExpr();
    if (exp == null)
    {
      exp = syntaxError("missing expression");
      if (curToken != -1)
        getRawToken();
      return exp;
    }
    return exp;
  }
  
  void parseEntityOrCharRef()
    throws IOException, SyntaxException
  {
    int next = read();
    if (next == 35)
    {

      next = read();
      int base; if (next == 120)
      {
        int base = 16;
        next = read();
      }
      else {
        base = 10; }
      int value = 0;
      while (next >= 0)
      {
        char ch = (char)next;
        int digit = Character.digit(ch, base);
        if (digit < 0)
          break;
        if (value >= 134217728)
          break;
        value *= base;
        value += digit;
        next = read();
      }
      if (next != 59)
      {
        unread();
        error("invalid character reference");

      }
      else if (((value > 0) && (value <= 55295)) || ((value >= 57344) && (value <= 65533)) || ((value >= 65536) && (value <= 1114111)))
      {

        tokenBufferAppend(value);
      } else {
        error('e', "invalid character value " + value, "XQST0090");
      }
    }
    else {
      int saveLength = tokenBufferLength;
      while (next >= 0)
      {
        char ch = (char)next;
        if (!XName.isNamePart(ch))
          break;
        tokenBufferAppend(ch);
        next = read();
      }
      if (next != 59)
      {
        unread();
        error("invalid entity reference");
        return;
      }
      String ref = new String(tokenBuffer, saveLength, tokenBufferLength - saveLength);
      
      tokenBufferLength = saveLength;
      appendNamedEntity(ref);
    }
  }
  



  public static Expression makeText = makeFunctionExp("gnu.kawa.xml.MakeText", "makeText");
  






  void parseContent(char delimiter, Vector result)
    throws IOException, SyntaxException
  {
    tokenBufferLength = 0;
    int startSize = result.size();
    int prevEnclosed = startSize - 1;
    boolean skipBoundarySpace = (!boundarySpacePreserve) && (delimiter == '<');
    boolean skippable = skipBoundarySpace;
    for (;;)
    {
      int next = read();
      if (next == delimiter)
      {
        if (delimiter == '<')
        {
          next = read();
          Expression text = null;
          if (tokenBufferLength > 0)
          {


            FString str = new FString(tokenBuffer, 0, tokenBufferLength);
            text = new QuoteExp(str);
          }
          tokenBufferLength = 0;
          if (next == 47)
          {
            if ((text == null) || (skippable)) break;
            result.addElement(text); break;
          }
          
          Expression content = parseXMLConstructor(next, true);
          boolean isCDATA = false;
          boolean emptyCDATA = false;
          if ((content instanceof ApplyExp))
          {
            ApplyExp aexp = (ApplyExp)content;
            if (aexp.getFunction() == makeCDATA)
            {
              isCDATA = true;
              String str = (String)aexp.getArg(0).valueIfConstant();
              emptyCDATA = (str != null) && (str.length() == 0);
            }
          }
          if ((text != null) && ((!skippable) || (isCDATA)))
            result.addElement(text);
          if (isCDATA) {
            skippable = false;
          } else
            skippable = skipBoundarySpace;
          if (!emptyCDATA)
            result.addElement(content);
          tokenBufferLength = 0;
          continue;
        }
        if (checkNext(delimiter))
        {
          tokenBufferAppend(delimiter);
          continue;
        }
      }
      if ((next == delimiter) || (next < 0) || (next == 123))
      {
        int postBrace = next == 123 ? read() : -1;
        if (postBrace == 123)
        {
          tokenBufferAppend(123);
          skippable = false;
        }
        else
        {
          FString text;
          FString text;
          if ((tokenBufferLength > 0) && (!skippable)) {
            text = new FString(tokenBuffer, 0, tokenBufferLength);
          } else { if ((next != 123) || (prevEnclosed != result.size())) {
              break label407;
            }
            text = new FString();
          }
          
          result.addElement(new QuoteExp(text));
          label407:
          tokenBufferLength = 0;
          if (next == delimiter)
            break;
          if (next < 0) {
            eofError("unexpected end-of-file");
          }
          else {
            unread(postBrace);
            enclosedExpressionsSeen += 1;
            Expression exp = parseEnclosedExpr();
            result.addElement(exp);
            tokenBufferLength = 0;
            prevEnclosed = result.size();
            skippable = skipBoundarySpace;
          }
        }
      } else if (next == 125)
      {
        next = read();
        if (next == 125)
        {
          tokenBufferAppend(125);
          skippable = false;
        }
        else
        {
          error("unexpected '}' in element content");
          unread(next);
        }
      }
      else if (next == 38)
      {
        parseEntityOrCharRef();
        skippable = false;
      }
      else
      {
        if ((delimiter != '<') && ((next == 9) || (next == 10) || (next == 13)))
        {
          next = 32; }
        if (next == 60)
          error('e', "'<' must be quoted in a direct attribute value");
        if (skippable)
          skippable = Character.isWhitespace((char)next);
        tokenBufferAppend((char)next);
      }
    }
  }
  



  Expression parseEnclosedExpr()
    throws IOException, SyntaxException
  {
    String saveErrorIfComment = errorIfComment;
    errorIfComment = null;
    char saveReadState = pushNesting('{');
    peekNonSpace("unexpected end-of-file after '{'");
    int startLine = getLineNumber() + 1;
    int startColumn = getColumnNumber() + 1;
    getRawToken();
    Expression exp = parseExpr();
    

    while (curToken != 125)
    {
      if ((curToken == -1) || (curToken == 41) || (curToken == 93))
      {
        exp = syntaxError("missing '}'");
        break;
      }
      if (curToken != 44) {
        exp = syntaxError("missing '}' or ','");
      } else {
        getRawToken();
      }
      exp = makeExprSequence(exp, parseExpr());
    }
    
    maybeSetLine(exp, startLine, startColumn);
    popNesting(saveReadState);
    errorIfComment = saveErrorIfComment;
    return exp;
  }
  

  public static Expression booleanValue(Expression exp)
  {
    Expression[] args = { exp };
    Expression string = makeFunctionExp("gnu.xquery.util.BooleanValue", "booleanValue");
    
    return new ApplyExp(string, args);
  }
  
  static final Expression makeCDATA = makeFunctionExp("gnu.kawa.xml.MakeCDATA", "makeCDATA");
  
  Compilation comp;
  

  Expression parseXMLConstructor(int next, boolean inElementContent)
    throws IOException, SyntaxException
  {
    Expression exp;
    
    Expression exp;
    if (next == 33)
    {
      next = read();
      Expression exp; if ((next == 45) && (peek() == 45))
      {
        skip();
        getDelimited("-->");
        boolean bad = false;
        int i = tokenBufferLength;
        boolean sawHyphen = true;
        for (;;) { i--; if (i < 0)
            break;
          boolean curHyphen = tokenBuffer[i] == '-';
          if ((sawHyphen) && (curHyphen))
          {
            bad = true;
            break;
          }
          sawHyphen = curHyphen; }
        Expression exp;
        if (bad) {
          exp = syntaxError("consecutive or final hyphen in XML comment");
        }
        else {
          Expression[] args = { new QuoteExp(new String(tokenBuffer, 0, tokenBufferLength)) };
          
          exp = new ApplyExp(makeFunctionExp("gnu.kawa.xml.CommentConstructor", "commentConstructor"), args);
        }
      }
      else {
        Expression exp;
        if ((next == 91) && (read() == 67) && (read() == 68) && (read() == 65) && (read() == 84) && (read() == 65) && (read() == 91))
        {


          if (!inElementContent)
            error('e', "CDATA section must be in element content");
          getDelimited("]]>");
          Expression[] args = { new QuoteExp(new String(tokenBuffer, 0, tokenBufferLength)) };
          
          exp = new ApplyExp(makeCDATA, args);
        }
        else {
          exp = syntaxError("'<!' must be followed by '--' or '[CDATA['");
        } } } else { Expression exp;
      if (next == 63)
      {
        next = peek();
        if ((next < 0) || (!XName.isNameStart((char)next)) || (getRawToken() != 65))
        {
          syntaxError("missing target after '<?'"); }
        String target = new String(tokenBuffer, 0, tokenBufferLength);
        int nspaces = 0;
        for (;;)
        {
          int ch = read();
          if (ch < 0)
            break;
          if (!Character.isWhitespace((char)ch))
          {
            unread();
            break;
          }
          nspaces++;
        }
        getDelimited("?>");
        if ((nspaces == 0) && (tokenBufferLength > 0))
          syntaxError("target must be followed by space or '?>'");
        String content = new String(tokenBuffer, 0, tokenBufferLength);
        Expression[] args = { new QuoteExp(target), new QuoteExp(content) };
        exp = new ApplyExp(makeFunctionExp("gnu.kawa.xml.MakeProcInst", "makeProcInst"), args);
      }
      else {
        Expression exp;
        if ((next < 0) || (!XName.isNameStart((char)next))) {
          exp = syntaxError("expected QName after '<'");
        }
        else {
          unread(next);
          getRawToken();
          char saveReadState = pushNesting('<');
          exp = parseElementConstructor();
          if (!inElementContent)
            exp = wrapWithBaseUri(exp);
          popNesting(saveReadState);
        } } }
    return exp;
  }
  


  static ApplyExp castQName(Expression value, boolean element)
  {
    Declaration fdecl = element ? XQResolveNames.xsQNameDecl : XQResolveNames.xsQNameIgnoreDefaultDecl;
    
    return new ApplyExp(new ReferenceExp(fdecl), new Expression[] { value });
  }
  










  Expression parseElementConstructor()
    throws IOException, SyntaxException
  {
    String startTag = new String(tokenBuffer, 0, tokenBufferLength);
    Vector<Expression> vec = new Vector();
    
    vec.add(castQName(new QuoteExp(startTag), true));
    errorIfComment = "comment not allowed in element start tag";
    NamespaceBinding nsBindings = null;
    int ch;
    for (;;)
    {
      boolean sawSpace = false;
      ch = read();
      while ((ch >= 0) && (Character.isWhitespace((char)ch)))
      {
        ch = read();
        sawSpace = true;
      }
      if ((ch < 0) || (ch == 62) || (ch == 47))
        break;
      if (!sawSpace)
        syntaxError("missing space before attribute");
      unread(ch);
      getRawToken();
      int vecSize = vec.size();
      if ((curToken != 65) && (curToken != 81))
        break;
      String attrName = new String(tokenBuffer, 0, tokenBufferLength);
      int startLine = getLineNumber() + 1;
      int startColumn = getColumnNumber() + 1 - tokenBufferLength;
      String definingNamespace = null;
      if (curToken == 65)
      {
        if (attrName.equals("xmlns")) {
          definingNamespace = "";
        }
        
      }
      else if (attrName.startsWith("xmlns:")) {
        definingNamespace = attrName.substring(6).intern();
      }
      Expression makeAttr = definingNamespace != null ? null : MakeAttribute.makeAttributeExp;
      

      vec.addElement(castQName(new QuoteExp(attrName), false));
      ch = skipSpace();
      if (ch != 61)
      {
        errorIfComment = null;
        return syntaxError("missing '=' after attribute");
      }
      ch = skipSpace();
      int enclosedExpressionsStart = enclosedExpressionsSeen;
      if (ch == 123)
      {
        warnOldVersion("enclosed attribute value expression should be quoted");
        vec.addElement(parseEnclosedExpr());
      }
      else {
        parseContent((char)ch, vec); }
      int n = vec.size() - vecSize;
      if (definingNamespace != null)
      {
        String ns = "";
        if (n == 1) {
          ns = "";
        } else if (enclosedExpressionsSeen > enclosedExpressionsStart) {
          syntaxError("enclosed expression not allowed in namespace declaration");
        }
        else {
          ns = ((Expression)vec.get(vecSize + 1)).valueIfConstant().toString().intern();
        }
        
        vec.setSize(vecSize);
        checkAllowedNamespaceDeclaration(definingNamespace, ns, true);
        if (definingNamespace == "")
          definingNamespace = null;
        for (NamespaceBinding nsb = nsBindings; 
            nsb != null; nsb = nsb.getNext())
        {
          if (nsb.getPrefix() == definingNamespace)
          {
            error('e', "duplicate namespace prefix '" + definingNamespace + '\'', "XQST0071");
            



            break;
          }
        }
        nsBindings = new NamespaceBinding(definingNamespace, ns == "" ? null : ns, nsBindings);


      }
      else
      {

        Expression[] args = new Expression[n];
        int i = n; for (;;) { i--; if (i < 0) break;
          args[i] = ((Expression)vec.elementAt(vecSize + i)); }
        vec.setSize(vecSize);
        ApplyExp aexp = new ApplyExp(makeAttr, args);
        maybeSetLine(aexp, startLine, startColumn);
        vec.addElement(aexp);
      }
    }
    errorIfComment = null;
    boolean empty = false;
    if (ch == 47)
    {
      ch = read();
      if (ch == 62) {
        empty = true;
      } else
        unread(ch);
    }
    if (!empty)
    {
      if (ch != 62)
        return syntaxError("missing '>' after start element");
      parseContent('<', vec);
      ch = peek();
      if (ch >= 0)
      {
        if (!XName.isNameStart((char)ch))
          return syntaxError("invalid tag syntax after '</'");
        getRawToken();
        String tag = new String(tokenBuffer, 0, tokenBufferLength);
        if (!tag.equals(startTag))
          return syntaxError("'<" + startTag + ">' closed by '</" + tag + ">'");
        errorIfComment = "comment not allowed in element end tag";
        ch = skipSpace();
        errorIfComment = null;
      }
      if (ch != 62)
        return syntaxError("missing '>' after end element");
    }
    Expression[] args = new Expression[vec.size()];
    vec.copyInto(args);
    MakeElement mkElement = new MakeElement();
    copyNamespacesMode = copyNamespacesMode;
    


    mkElement.setNamespaceNodes(nsBindings);
    Expression result = new ApplyExp(new QuoteExp(mkElement), args);
    return result;
  }
  
  Expression wrapWithBaseUri(Expression exp)
  {
    if (getStaticBaseUri() == null)
      return exp;
    return new ApplyExp(gnu.kawa.xml.MakeWithBaseUri.makeWithBaseUri, new Expression[] { new ApplyExp(new ReferenceExp(XQResolveNames.staticBaseUriDecl), Expression.noExpressions), exp }).setLine(exp);
  }
  








  Expression parseParenExpr()
    throws IOException, SyntaxException
  {
    getRawToken();
    char saveReadState = pushNesting('(');
    Expression exp = parseExprSequence(41, true);
    popNesting(saveReadState);
    if (curToken == -1)
      eofError("missing ')' - unexpected end-of-file");
    return exp;
  }
  
  Expression parseExprSequence(int rightToken, boolean optional)
    throws IOException, SyntaxException
  {
    if ((curToken == rightToken) || (curToken == -1))
    {
      if (!optional)
        syntaxError("missing expression");
      return QuoteExp.voidObjectExp;
    }
    Expression exp = null;
    for (;;)
    {
      Expression exp1 = parseExprSingle();
      
      exp = exp == null ? exp1 : makeExprSequence(exp, exp1);
      if ((curToken == rightToken) || (curToken == -1))
        break;
      if ((nesting == 0) && (curToken == 10))
        return exp;
      if (curToken != 44) {
        return syntaxError(rightToken == 41 ? "expected ')'" : "confused by syntax error");
      }
      getRawToken();
    }
    return exp;
  }
  
  Expression parseTypeSwitch()
    throws IOException, SyntaxException
  {
    char save = pushNesting('t');
    Expression selector = parseParenExpr();
    getRawToken();
    Object varName = null;
    
    Vector vec = new Vector();
    vec.addElement(selector);
    while (match("case"))
    {
      pushNesting('c');
      getRawToken();
      Declaration decl; if (curToken == 36)
      {
        Declaration decl = parseVariableDeclaration();
        if (decl == null)
          return syntaxError("missing Variable after '$'");
        getRawToken();
        if (match("as")) {
          getRawToken();
        } else {
          error('e', "missing 'as'");
        }
      } else {
        decl = new Declaration("(arg)"); }
      decl.setTypeExp(parseDataType());
      popNesting('t');
      LambdaExp lexp = new LambdaExp(1);
      lexp.addDeclaration(decl);
      if (match("return")) {
        getRawToken();
      } else
        error("missing 'return' after 'case'");
      comp.push(lexp);
      pushNesting('r');
      Expression caseExpr = parseExpr();
      body = caseExpr;
      popNesting('t');
      comp.pop(lexp);
      vec.addElement(lexp);
    }
    
    if (match("default"))
    {
      LambdaExp lexp = new LambdaExp(1);
      getRawToken();
      Declaration decl;
      if (curToken == 36)
      {
        Declaration decl = parseVariableDeclaration();
        if (decl == null)
          return syntaxError("missing Variable after '$'");
        getRawToken();
      }
      else {
        decl = new Declaration("(arg)"); }
      lexp.addDeclaration(decl);
      
      if (match("return")) {
        getRawToken();
      } else
        error("missing 'return' after 'default'");
      comp.push(lexp);
      Expression defaultExpr = parseExpr();
      body = defaultExpr;
      comp.pop(lexp);
      vec.addElement(lexp);
    }
    else
    {
      error(comp.isPedantic() ? 'e' : 'w', "no 'default' clause in 'typeswitch'", "XPST0003");
    }
    

    popNesting(save);
    Expression[] args = new Expression[vec.size()];
    vec.copyInto(args);
    return new ApplyExp(makeFunctionExp("gnu.kawa.reflect.TypeSwitch", "typeSwitch"), args);
  }
  






  Expression parseMaybePrimaryExpr()
    throws IOException, SyntaxException
  {
    int startLine = curLine;
    int startColumn = curColumn;
    int token = peekOperand();
    Expression exp;
    Expression exp;
    Expression exp;
    Object name;
    Vector vec; Expression[] args; switch (token)
    {
    case 40: 
      exp = parseParenExpr();
      break;
    
    case 197: 
      Stack extArgs = new Stack();
      for (;;)
      {
        getRawToken();
        Expression qname;
        Expression qname; if ((curToken != 81) && (curToken != 65)) {
          qname = syntaxError("missing pragma name");
        } else
          qname = QuoteExp.getInstance(new String(tokenBuffer, 0, tokenBufferLength));
        extArgs.push(qname);
        StringBuffer sbuf = new StringBuffer();
        
        int spaces = -1;
        int ch; do { ch = read();spaces++;
        } while ((ch >= 0) && (Character.isWhitespace((char)ch)));
        while ((ch != 35) || (peek() != 41))
        {
          if (ch < 0)
            eofError("pragma ended by end-of-file");
          if (spaces == 0)
            error("missing space between pragma and extension content");
          spaces = 1;
          sbuf.append((char)ch);
          ch = read();
        }
        read();
        extArgs.push(QuoteExp.getInstance(sbuf.toString()));
        getRawToken();
        if (curToken != 197)
          break;
      }
      if (curToken == 123)
      {
        getRawToken();
        if (curToken != 125)
        {
          char saveReadState = pushNesting('{');
          extArgs.push(parseExprSequence(125, false));
          popNesting(saveReadState);
          if (curToken == -1)
            eofError("missing '}' - unexpected end-of-file");
        }
        Expression[] args = new Expression[extArgs.size()];
        extArgs.copyInto(args);
        exp = new ApplyExp(new ReferenceExp(XQResolveNames.handleExtensionDecl), args);
      }
      else {
        exp = syntaxError("missing '{' after pragma"); }
      break;
    
    case 123: 
      exp = syntaxError("saw unexpected '{' - assume you meant '('");
      parseEnclosedExpr();
      break;
    
    case 404: 
      int next = read();
      if (next == 47)
      {
        getRawToken();
        String msg;
        String msg; if ((curToken == 65) || (curToken == 81) || (curToken == 67))
        {
          msg = "saw end tag '</" + new String(tokenBuffer, 0, tokenBufferLength) + ">' not in an element constructor";
        } else
          msg = "saw end tag '</' not in an element constructor";
        curLine = startLine;
        curColumn = startColumn;
        exp = syntaxError(msg);
        while ((curToken != 405) && (curToken != -1) && (curToken != 10))
          getRawToken();
        return exp;
      }
      

      exp = parseXMLConstructor(next, false);
      maybeSetLine(exp, startLine, startColumn);
      
      break;
    
    case 34: 
      exp = new QuoteExp(new String(tokenBuffer, 0, tokenBufferLength).intern());
      break;
    
    case 48: 
      exp = new QuoteExp(IntNum.valueOf(tokenBuffer, 0, tokenBufferLength, 10, false));
      
      break;
    
    case 49: 
    case 50: 
      String str = new String(tokenBuffer, 0, tokenBufferLength);
      try {
        Object val;
        Object val;
        if (token == 49) {
          val = new java.math.BigDecimal(str);
        } else
          val = new Double(str);
        exp = new QuoteExp(val);
      }
      catch (Exception ex)
      {
        exp = syntaxError("invalid decimal literal: '" + str + "'");
      }
    
    case 36: 
      name = parseVariable();
      if (name == null)
        return syntaxError("missing Variable");
      exp = new ReferenceExp(name);
      maybeSetLine(exp, curLine, curColumn);
      break;
    case 70: 
      name = new String(tokenBuffer, 0, tokenBufferLength);
      char save = pushNesting('(');
      getRawToken();
      vec = new Vector(10);
      if (curToken != 41)
      {
        for (;;)
        {
          Expression arg = parseExpr();
          vec.addElement(arg);
          if (curToken == 41)
            break;
          if (curToken != 44)
            return syntaxError("missing ')' after function call");
          getRawToken();
        }
      }
      args = new Expression[vec.size()];
      
      vec.copyInto(args);
      ReferenceExp rexp = new ReferenceExp(name, null);
      rexp.setProcedureName(true);
      exp = new ApplyExp(rexp, args);
      maybeSetLine(exp, startLine, startColumn);
      popNesting(save);
      break;
    
    case 251: 
    case 252: 
    case 253: 
    case 254: 
    case 255: 
    case 256: 
      getRawToken();
      vec = new Vector();
      
      Expression func;
      if ((token == 251) || (token == 252))
      {
        Expression element;
        if ((curToken == 65) || (curToken == 81)) {
          element = parseNameTest(token != 251); } else { Expression element;
          if (curToken == 123) {
            element = parseEnclosedExpr();
          } else
            return syntaxError("missing element/attribute name"); }
        Expression element; vec.addElement(castQName(element, token == 251));
        Expression func; Expression func; if (token == 251)
        {
          MakeElement mk = new MakeElement();
          copyNamespacesMode = copyNamespacesMode;
          func = new QuoteExp(mk);
        }
        else {
          func = MakeAttribute.makeAttributeExp; }
        getRawToken();
      } else { Expression func;
        if (token == 256) {
          func = makeFunctionExp("gnu.kawa.xml.DocumentConstructor", "documentConstructor");
        } else { Expression func;
          if (token == 254) {
            func = makeFunctionExp("gnu.kawa.xml.CommentConstructor", "commentConstructor");
          }
          else if (token == 255) {
            Expression target;
            Expression target;
            if (curToken == 65) {
              target = new QuoteExp(new String(tokenBuffer, 0, tokenBufferLength).intern());
            } else { Expression target;
              if (curToken == 123)
              {
                target = parseEnclosedExpr();
              }
              else
              {
                target = syntaxError("expected NCName or '{' after 'processing-instruction'");
                if (curToken != 81)
                  return target;
              } }
            vec.addElement(target);
            Expression func = makeFunctionExp("gnu.kawa.xml.MakeProcInst", "makeProcInst");
            
            getRawToken();
          }
          else {
            func = makeFunctionExp("gnu.kawa.xml.MakeText", "makeText");
          } } }
      char saveReadState = pushNesting('{');
      peekNonSpace("unexpected end-of-file after '{'");
      if (curToken != 123)
        return syntaxError("missing '{'");
      getRawToken();
      if ((token == 253) || (token == 254) || (token == 255))
      {
        vec.addElement(parseExprSequence(125, token == 255));
      } else if (curToken != 125)
      {
        vec.addElement(parseExpr());
        while (curToken == 44)
        {
          getRawToken();
          vec.addElement(parseExpr());
        }
      }
      popNesting(saveReadState);
      if (curToken != 125)
        return syntaxError("missing '}'");
      args = new Expression[vec.size()];
      vec.copyInto(args);
      exp = new ApplyExp(func, args);
      maybeSetLine(exp, startLine, startColumn);
      if ((token == 256) || (token == 251)) {
        exp = wrapWithBaseUri(exp);
      }
      break;
    case 249: 
    case 250: 
      getRawToken();
      exp = parseExprSequence(125, false);
      break;
    
    default: 
      return null;
    }
    
    







    getRawToken();
    return exp;
  }
  
  public Expression parseIfExpr()
    throws IOException, SyntaxException
  {
    char saveReadState1 = pushNesting('i');
    getRawToken();
    char saveReadState2 = pushNesting('(');
    Expression cond = parseExprSequence(41, false);
    popNesting(saveReadState2);
    if (curToken == -1)
      eofError("missing ')' - unexpected end-of-file");
    getRawToken();
    if (!match("then")) {
      syntaxError("missing 'then'");
    } else
      getRawToken();
    Expression thenPart = parseExpr();
    if (!match("else")) {
      syntaxError("missing 'else'");
    } else
      getRawToken();
    popNesting(saveReadState1);
    Expression elsePart = parseExpr();
    return new IfExp(booleanValue(cond), thenPart, elsePart);
  }
  
  public boolean match(String word)
  {
    if (curToken != 65)
      return false;
    int len = word.length();
    if (tokenBufferLength != len)
      return false;
    int i = len; for (;;) { i--; if (i < 0)
        break;
      char cs = word.charAt(i);
      char cb = tokenBuffer[i];
      if (cs != cb)
        return false;
    }
    return true;
  }
  

  public Object parseVariable()
    throws IOException, SyntaxException
  {
    if (curToken == 36) {
      getRawToken();
    } else
      syntaxError("missing '$' before variable name");
    String str = new String(tokenBuffer, 0, tokenBufferLength);
    

    if (curToken == 81)
      return str;
    if (curToken == 65) {
      return Namespace.EmptyNamespace.getSymbol(str.intern());
    }
    return null;
  }
  
  public Declaration parseVariableDeclaration()
    throws IOException, SyntaxException
  {
    Object name = parseVariable();
    if (name == null)
      return null;
    Declaration decl = new Declaration(name);
    maybeSetLine(decl, getLineNumber() + 1, getColumnNumber() + 1 - tokenBufferLength);
    
    return decl;
  }
  
  public Expression parseFLWRExpression(boolean isFor)
    throws IOException, SyntaxException
  {
    int flworDeclsSave = flworDeclsFirst;
    flworDeclsFirst = flworDeclsCount;
    Expression exp = parseFLWRInner(isFor);
    
    if (match("order"))
    {
      char saveNesting = pushNesting(isFor ? 'f' : 'l');
      getRawToken();
      if (match("by")) {
        getRawToken();
      } else
        error("missing 'by' following 'order'");
      Stack specs = new Stack();
      for (;;)
      {
        boolean descending = false;
        char emptyOrder = defaultEmptyOrder;
        
        LambdaExp lexp = new LambdaExp(flworDeclsCount - flworDeclsFirst);
        for (int i = flworDeclsFirst; i < flworDeclsCount; i++)
          lexp.addDeclaration(flworDecls[i].getSymbol());
        comp.push(lexp);
        body = parseExprSingle();
        comp.pop(lexp);
        specs.push(lexp);
        
        if (match("ascending")) {
          getRawToken();
        } else if (match("descending"))
        {
          getRawToken();
          descending = true;
        }
        if (match("empty"))
        {
          getRawToken();
          if (match("greatest"))
          {
            getRawToken();
            emptyOrder = 'G';
          }
          else if (match("least"))
          {
            getRawToken();
            emptyOrder = 'L';
          }
          else {
            error("'empty' sequence order must be 'greatest' or 'least'");
          }
        }
        specs.push(new QuoteExp((descending ? "D" : "A") + emptyOrder));
        Object collation = defaultCollator;
        if (match("collation"))
        {
          Object uri = parseURILiteral();
          if ((uri instanceof String))
          {
            try
            {
              String uriString = resolveAgainstBaseUri((String)uri);
              collation = NamedCollator.make(uriString);
            }
            catch (Exception name)
            {
              error('e', "unknown collation '" + uri + "'", "XQST0076");
            }
          }
          getRawToken();
        }
        specs.push(new QuoteExp(collation));
        if (curToken != 44)
          break;
        getRawToken();
      }
      if (!match("return"))
        return syntaxError("expected 'return' clause");
      getRawToken();
      
      LambdaExp lexp = new LambdaExp(flworDeclsCount - flworDeclsFirst);
      
      for (int i = flworDeclsFirst; i < flworDeclsCount; i++)
        lexp.addDeclaration(flworDecls[i].getSymbol());
      popNesting(saveNesting);
      comp.push(lexp);
      body = parseExprSingle();
      comp.pop(lexp);
      int nspecs = specs.size();
      Expression[] args = new Expression[2 + nspecs];
      args[0] = exp;
      args[1] = lexp;
      for (int i = 0; i < nspecs; i++)
        args[(2 + i)] = ((Expression)specs.elementAt(i));
      return new ApplyExp(makeFunctionExp("gnu.xquery.util.OrderedMap", "orderedMap"), args);
    }
    


    flworDeclsCount = flworDeclsFirst;
    flworDeclsFirst = flworDeclsSave;
    return exp;
  }
  








  public Expression parseFLWRInner(boolean isFor)
    throws IOException, SyntaxException
  {
    char saveNesting = pushNesting(isFor ? 'f' : 'l');
    curToken = 36;
    Declaration decl = parseVariableDeclaration();
    if (decl == null)
      return syntaxError("missing Variable - saw " + tokenString());
    if (flworDecls == null) {
      flworDecls = new Declaration[8];
    } else if (flworDeclsCount >= flworDecls.length)
    {
      Declaration[] tmp = new Declaration[2 * flworDeclsCount];
      System.arraycopy(flworDecls, 0, tmp, 0, flworDeclsCount);
      flworDecls = tmp;
    }
    flworDecls[(flworDeclsCount++)] = decl;
    getRawToken();
    
    Expression type = parseOptionalTypeDeclaration();
    LambdaExp lexp = null;
    Declaration posDecl = null;
    if (isFor)
    {
      boolean sawAt = match("at");
      lexp = new LambdaExp(sawAt ? 2 : 1);
      if (sawAt)
      {
        getRawToken();
        if (curToken == 36)
        {
          posDecl = parseVariableDeclaration();
          getRawToken();
        }
        if (posDecl == null)
          syntaxError("missing Variable after 'at'");
      }
      if (match("in")) {
        getRawToken();
      }
      else {
        if (curToken == 76)
          getRawToken();
        syntaxError("missing 'in' in 'for' clause");
      }
      comp.push(lexp);
    }
    else
    {
      if (curToken == 76) {
        getRawToken();
      }
      else {
        if (match("in"))
          getRawToken();
        syntaxError("missing ':=' in 'let' clause");
      }
      comp.letStart();
    }
    Expression init = parseExprSingle();
    if (isFor)
    {
      lexp.addDeclaration(decl);
      decl.noteValueUnknown();
      decl.setFlag(262144L);
    }
    else
    {
      if (type != null)
        init = Compilation.makeCoercion(init, type);
      comp.letVariable(decl, init);
      comp.letEnter();
    }
    if (type != null)
      decl.setTypeExp(type);
    popNesting(saveNesting);
    if (posDecl != null)
    {
      lexp.addDeclaration(posDecl);
      posDecl.setType(LangPrimType.intType);
      posDecl.noteValueUnknown();
      posDecl.setFlag(262144L); }
    Expression body;
    Expression body;
    if (curToken == 44)
    {
      getRawToken();
      if (curToken != 36)
        return syntaxError("missing $NAME after ','");
      body = parseFLWRInner(isFor);
    } else { Expression body;
      if (match("for"))
      {
        getRawToken();
        if (curToken != 36)
          return syntaxError("missing $NAME after 'for'");
        body = parseFLWRInner(true);
      } else { Expression body;
        if (match("let"))
        {
          getRawToken();
          if (curToken != 36)
            return syntaxError("missing $NAME after 'let'");
          body = parseFLWRInner(false);

        }
        else
        {
          char save = pushNesting('w');
          Expression cond; Expression cond; if (curToken == 196)
          {
            getRawToken();
            cond = parseExprSingle();
          } else { Expression cond;
            if (match("where"))
            {
              cond = parseExprSingle();
            }
            else
              cond = null; }
          popNesting(save);
          boolean sawStable = match("stable");
          if (sawStable)
            getRawToken();
          boolean sawReturn = match("return");
          boolean sawOrder = match("order");
          if ((!sawReturn) && (!sawOrder) && (!match("let")) && (!match("for")))
            return syntaxError("missing 'return' clause");
          if (!sawOrder)
            peekNonSpace("unexpected eof-of-file after 'return'");
          int bodyLine = getLineNumber() + 1;
          int bodyColumn = getColumnNumber() + 1;
          if (sawReturn)
            getRawToken();
          Expression body; if (sawOrder)
          {
            int ndecls = flworDeclsCount - flworDeclsFirst;
            Expression[] args = new Expression[ndecls];
            for (int i = 0; i < ndecls; i++)
              args[i] = new ReferenceExp(flworDecls[(flworDeclsFirst + i)]);
            body = new ApplyExp(new PrimProcedure("gnu.xquery.util.OrderedMap", "makeTuple$V", 1), args);

          }
          else
          {
            body = parseExprSingle(); }
          if (cond != null)
            body = new IfExp(booleanValue(cond), body, QuoteExp.voidExp);
          maybeSetLine(body, bodyLine, bodyColumn);
        } } }
    if (isFor)
    {
      comp.pop(lexp);
      body = body;
      Expression[] args = { lexp, init };
      return new ApplyExp(makeFunctionExp("gnu.kawa.functions.ValuesMap", min_args == 1 ? "valuesMap" : "valuesMapWithPos"), args);
    }
    



    return comp.letDone(body);
  }
  


  public Expression parseQuantifiedExpr(boolean isEvery)
    throws IOException, SyntaxException
  {
    char saveNesting = pushNesting(isEvery ? 'e' : 's');
    curToken = 36;
    Declaration decl = parseVariableDeclaration();
    if (decl == null)
      return syntaxError("missing Variable token:" + curToken);
    getRawToken();
    
    LambdaExp lexp = new LambdaExp(1);
    lexp.addDeclaration(decl);
    decl.noteValueUnknown();
    decl.setFlag(262144L);
    decl.setTypeExp(parseOptionalTypeDeclaration());
    
    if (match("in")) {
      getRawToken();
    }
    else {
      if (curToken == 76)
        getRawToken();
      syntaxError("missing 'in' in QuantifiedExpr");
    }
    Expression[] inits = { parseExprSingle() };
    popNesting(saveNesting);
    comp.push(lexp);
    Expression body;
    Expression body; if (curToken == 44)
    {
      getRawToken();
      if (curToken != 36)
        return syntaxError("missing $NAME after ','");
      body = parseQuantifiedExpr(isEvery);
    }
    else
    {
      boolean sawSatisfies = match("satisfies");
      if ((!sawSatisfies) && (!match("every")) && (!match("some")))
        return syntaxError("missing 'satisfies' clause");
      peekNonSpace("unexpected eof-of-file after 'satisfies'");
      int bodyLine = getLineNumber() + 1;
      int bodyColumn = getColumnNumber() + 1;
      if (sawSatisfies)
        getRawToken();
      body = parseExprSingle();
      maybeSetLine(body, bodyLine, bodyColumn);
    }
    comp.pop(lexp);
    body = body;
    Expression[] args = { lexp, inits[0] };
    return new ApplyExp(makeFunctionExp("kawa.lib.xquery.Xutils", isEvery ? "every" : "some"), args);
  }
  


  public Expression parseFunctionDefinition(int declLine, int declColumn)
    throws IOException, SyntaxException
  {
    if ((curToken != 81) && (curToken != 65))
      return syntaxError("missing function name");
    String name = new String(tokenBuffer, 0, tokenBufferLength);
    getMessages().setLine(port.getName(), curLine, curColumn);
    Symbol sym = namespaceResolve(name, true);
    String uri = sym.getNamespaceURI();
    if ((uri == "http://www.w3.org/XML/1998/namespace") || (uri == "http://www.w3.org/2001/XMLSchema") || (uri == "http://www.w3.org/2001/XMLSchema-instance") || (uri == "http://www.w3.org/2005/xpath-functions"))
    {



      error('e', "cannot declare function in standard namespace '" + uri + '\'', "XQST0045");


    }
    else if (uri == "")
    {
      error(comp.isPedantic() ? 'e' : 'w', "cannot declare function in empty namespace", "XQST0060");


    }
    else if ((libraryModuleNamespace != null) && (uri != libraryModuleNamespace) && ((!"http://www.w3.org/2005/xquery-local-functions".equals(uri)) || (comp.isPedantic())))
    {

      error('e', "function not in namespace of library module", "XQST0048");
    }
    getRawToken();
    if (curToken != 40)
      return syntaxError("missing parameter list:" + curToken);
    getRawToken();
    LambdaExp lexp = new LambdaExp();
    maybeSetLine(lexp, declLine, declColumn);
    lexp.setSymbol(sym);
    Declaration decl = comp.currentScope().addDeclaration(sym);
    if (comp.isStatic())
      decl.setFlag(2048L);
    lexp.setFlag(2048);
    decl.setCanRead(true);
    decl.setProcedureDecl(true);
    maybeSetLine(decl, declLine, declColumn);
    comp.push(lexp);
    if (curToken != 41)
    {
      for (;;)
      {

        Declaration param = parseVariableDeclaration();
        if (param == null) {
          error("missing parameter name");
        }
        else {
          lexp.addDeclaration(param);
          getRawToken();
          min_args += 1;
          max_args += 1;
          param.setTypeExp(parseOptionalTypeDeclaration());
        }
        if (curToken == 41)
          break;
        if (curToken != 44)
        {
          Expression err = syntaxError("missing ',' in parameter list");
          for (;;)
          {
            getRawToken();
            if ((curToken < 0) || (curToken == 59) || (curToken == 59))
              return err;
            if (curToken == 41)
              break label546;
            if (curToken == 44) {
              break;
            }
          }
        } else {
          getRawToken();
        } } }
    label546:
    getRawToken();
    Expression retType = parseOptionalTypeDeclaration();
    body = parseEnclosedExpr();
    comp.pop(lexp);
    if (retType != null)
      lexp.setCoercedReturnValue(retType, interpreter);
    SetExp sexp = new SetExp(decl, lexp);
    sexp.setDefining(true);
    decl.noteValue(lexp);
    return sexp;
  }
  
  public Object readObject()
    throws IOException, SyntaxException
  {
    return parse(null);
  }
  


  String defaultElementNamespace = "";
  



  NamespaceBinding constructorNamespaces = NamespaceBinding.predefinedXML;
  


  NamespaceBinding prologNamespaces;
  


  static NamespaceBinding builtinNamespaces;
  


  public static final QuoteExp getExternalFunction;
  


  public static final String[] axisNames;
  


  protected Symbol namespaceResolve(String name, boolean function)
  {
    int colon = name.indexOf(':');
    String prefix = function ? "(functions)" : colon >= 0 ? name.substring(0, colon).intern() : XQuery.DEFAULT_ELEMENT_PREFIX;
    

    String uri = gnu.xquery.util.QNameUtils.lookupPrefix(prefix, constructorNamespaces, prologNamespaces);
    

    if (uri == null)
    {
      if (colon < 0) {
        uri = "";
      } else if (!comp.isPedantic())
      {
        try
        {
          Class cl = Class.forName(prefix);
          uri = "class:" + prefix;
        }
        catch (Exception ex)
        {
          uri = null;
        }
      }
      if (uri == null)
      {
        getMessages().error('e', "unknown namespace prefix '" + prefix + "'", "XPST0081");
        

        uri = "(unknown namespace)";
      }
    }
    String local = colon < 0 ? name : name.substring(colon + 1);
    return Symbol.make(uri, local, prefix);
  }
  
  void parseSeparator()
    throws IOException, SyntaxException
  {
    int startLine = port.getLineNumber() + 1;
    int startColumn = port.getColumnNumber() + 1;
    int next = skipSpace(nesting != 0);
    if (next == 59)
      return;
    if ((warnOldVersion) && (next != 10))
    {
      curLine = startLine;
      curColumn = startColumn;
      error('w', "missing ';' after declaration");
    }
    if (next >= 0) {
      unread(next);
    }
  }
  





  public Expression parse(Compilation comp)
    throws IOException, SyntaxException
  {
    this.comp = comp;
    int ch = skipSpace();
    if (ch < 0)
      return null;
    parseCount += 1;
    unread(ch);
    int startLine = getLineNumber() + 1;
    int startColumn = getColumnNumber() + 1;
    

    if ((ch == 35) && (startLine == 1) && (startColumn == 1))
    {
      read();
      if (((ch = read()) != 33) || ((ch = read()) != 47))
        error("'#' is only allowed in initial '#!/PROGRAM'");
      while ((ch != 13) && (ch != 10) && (ch >= 0)) {
        ch = read();
      }
    }
    if (getRawToken() == -1)
      return null;
    peekOperand();
    
    if ((curToken == 65) && ("namespace".equals((String)curValue)))
    {

      if (warnOldVersion)
        error('w', "use 'declare namespace' instead of 'namespace'");
      curToken = 78;
    }
    int declLine;
    int declColumn;
    int next;
    String prefix;
    String uri;
    Object val;
    switch (curToken)
    {
    case 87: 
      declLine = getLineNumber() + 1;
      declColumn = getColumnNumber() + 1;
      next = peekNonSpace("unexpected end-of-file after 'define QName'");
      if (next == 40)
      {
        syntaxError("'missing 'function' after 'define'");
        curToken = 65;
        return parseFunctionDefinition(declLine, declColumn);
      }
      
      return syntaxError("missing keyword after 'define'");
    
    case 80: 
      declLine = getLineNumber() + 1;
      declColumn = getColumnNumber() + 1;
      getRawToken();
      peekNonSpace("unexpected end-of-file after 'define function'");
      char save = pushNesting('d');
      exp = parseFunctionDefinition(declLine, declColumn);
      popNesting(save);
      parseSeparator();
      maybeSetLine(exp, startLine, startColumn);
      seenDeclaration = true;
      return exp;
    
    case 86: 
      getRawToken();
      Declaration decl = parseVariableDeclaration();
      if (decl == null)
        return syntaxError("missing Variable");
      Object name = decl.getSymbol();
      if ((name instanceof String))
      {
        getMessages().setLine(this.port.getName(), curLine, curColumn);
        decl.setSymbol(namespaceResolve((String)name, false));
      }
      if (libraryModuleNamespace != null)
      {
        String uri = ((Symbol)decl.getSymbol()).getNamespaceURI();
        if ((uri != libraryModuleNamespace) && ((!"http://www.w3.org/2005/xquery-local-functions".equals(uri)) || (comp.isPedantic())))
        {
          error('e', "variable not in namespace of library module", "XQST0048");
        }
      }
      comp.currentScope().addDeclaration(decl);
      getRawToken();
      Expression type = parseOptionalTypeDeclaration();
      decl.setCanRead(true);
      
      decl.setFlag(16384L);
      Expression init = null;
      boolean sawEq = false;
      if ((curToken == 402) || (curToken == 76))
      {
        if (curToken == 402)
          error("declare variable contains '=' instead of ':='");
        getRawToken();
        sawEq = true;
      }
      if (curToken == 123)
      {
        warnOldVersion("obsolete '{' in variable declaration");
        init = parseEnclosedExpr();
        parseSeparator();
      }
      else if (match("external"))
      {
        Expression[] args = { castQName(new QuoteExp(decl.getSymbol()), false), type == null ? QuoteExp.nullExp : type };
        



        init = new ApplyExp(getExternalFunction, args);
        maybeSetLine(init, curLine, curColumn);
        getRawToken();
      }
      else
      {
        init = parseExpr();
        Expression err = null;
        if ((!sawEq) || (init == null))
          err = syntaxError("expected ':= init' or 'external'");
        if (init == null)
          init = err;
      }
      if (type != null)
        init = Compilation.makeCoercion(init, type);
      decl.noteValue(init);
      exp = SetExp.makeDefinition(decl, init);
      maybeSetLine(exp, startLine, startColumn);
      seenDeclaration = true;
      return exp;
    
    case 77: 
    case 78: 
      int command = curToken;
      if ((command == 77) && (libraryModuleNamespace != null))
      {
        error('e', "duplicate module declaration");
      } else if ((seenDeclaration) && (!isInteractive()))
        error('e', "namespace declared after function/variable/option");
      next = skipSpace(nesting != 0);
      if (next >= 0)
      {
        unread();
        if (XName.isNameStart((char)next))
        {
          getRawToken();
          if (curToken != 65)
            return syntaxError("missing namespace prefix");
          String prefix = new String(tokenBuffer, 0, tokenBufferLength);
          getRawToken();
          if (curToken != 402)
            return syntaxError("missing '=' in namespace declaration");
          getRawToken();
          if (curToken != 34)
            return syntaxError("missing uri in namespace declaration");
          String uri = new String(tokenBuffer, 0, tokenBufferLength).intern();
          prefix = prefix.intern();
          for (NamespaceBinding ns = prologNamespaces; 
              ns != builtinNamespaces; 
              ns = ns.getNext())
          {
            if (ns.getPrefix() == prefix)
            {
              error('e', "duplicate declarations for the same namespace prefix '" + prefix + "'", "XQST0033");
              


              break;
            }
          }
          pushNamespace(prefix, uri);
          checkAllowedNamespaceDeclaration(prefix, uri, false);
          parseSeparator();
          if (command == 77)
          {
            ModuleExp module = comp.getModule();
            String className = Compilation.mangleURI(uri) + '.' + XQuery.makeClassName(module.getFileName());
            
            module.setName(className);
            mainClass = new ClassType(className);
            module.setType(mainClass);
            ModuleManager manager = ModuleManager.getInstance();
            ModuleInfo info = manager.find(comp);
            info.setNamespaceUri(uri);
            module.setType(mainClass);
            if (uri.length() == 0)
              return syntaxError("zero-length module namespace", "XQST0088");
            libraryModuleNamespace = uri;
          }
          return QuoteExp.voidExp;
        }
      }
    
    case 84: 
      fatal("'import schema' not implemented", "XQST0009");
    
    case 73: 
      getRawToken();
      prefix = null;
      if (match("namespace"))
      {
        getRawToken();
        if (curToken != 65)
          return syntaxError("missing namespace prefix");
        prefix = new String(tokenBuffer, 0, tokenBufferLength);
        getRawToken();
        if (curToken != 402)
          return syntaxError("missing '=' in namespace declaration");
        getRawToken();
      }
      if (curToken != 34)
        return syntaxError("missing uri in namespace declaration");
      if (tokenBufferLength == 0)
        return syntaxError("zero-length target namespace", "XQST0088");
      uri = new String(tokenBuffer, 0, tokenBufferLength).intern();
      if (prefix != null)
      {
        checkAllowedNamespaceDeclaration(prefix, uri, false);
        pushNamespace(prefix.intern(), uri);
      }
      getRawToken();
      
      ModuleManager.getInstance().find(comp);
      
      if (seenImports == null)
        seenImports = new java.util.HashMap();
      SourceLocator oldImport = (SourceLocator)seenImports.get(uri);
      Declaration loc = new Declaration(uri);
      maybeSetLine(loc, startLine, startColumn);
      if (oldImport != null) {
        comp.error('e', "duplicate import of '" + uri + "'", "XQST0047", loc);
        
        comp.error('e', "(this is the previous import)", null, oldImport);
        return QuoteExp.voidExp;
      }
      seenImports.put(uri, loc);
      

      ModuleExp module = comp.getModule();
      Translator.FormStack formStack = new Translator.FormStack(comp);
      String packageName = Compilation.mangleURI(uri);
      comp.setLine(this.port.getName(), startLine, startColumn);
      if (match("at"))
      {
        for (;;)
        {
          getRawToken();
          if (curToken != 34)
            return syntaxError("missing module location");
          String at = new String(tokenBuffer, 0, tokenBufferLength);
          String className = Compilation.mangleURI(uri) + '.' + XQuery.makeClassName(at);
          

          ModuleInfo info = require.lookupModuleFromSourcePath(at, module);
          if (info == null)
            comp.error('e', "malformed URL: " + at);
          require.importDefinitions(className, info, null, formStack, module, comp);
          
          next = skipSpace(nesting != 0);
          if (next != 44)
          {
            unread(next);
            break;
          }
        }
        parseSeparator();
      }
      else
      {
        ModuleManager manager = ModuleManager.getInstance();
        int n = 0;
        try
        {
          manager.loadPackageInfo(packageName);



        }
        catch (ClassNotFoundException ex) {}catch (Exception ex)
        {


          error('e', "error loading map for " + uri + " - " + ex);
        }
        for (int i = 0;; i++)
        {
          ModuleInfo info = manager.getModule(i);
          if (info == null)
            break;
          if (uri.equals(info.getNamespaceUri()))
          {
            n++;
            require.importDefinitions(info.getClassName(), info, null, formStack, module, comp);
          } }
        if (n == 0)
          error('e', "no module found for " + uri);
        String at = null;
        if (curToken != 59)
          parseSeparator();
      }
      if ((pendingImports != null) && (pendingImports.size() > 0))
      {
        error('e', "module import forms a cycle", "XQST0073");
      }
      LList forms = (LList)formStack.getFirst();
      Expression[] inits = new Expression[forms.size()];
      forms.toArray(inits);
      return BeginExp.canonicalize(inits);
    
    case 71: 
      if ((defaultCollator != null) && (!isInteractive()))
        error('e', "duplicate default collation declaration", "XQST0038");
      val = parseURILiteral();
      if ((val instanceof Expression))
        return (Expression)val;
      String collation = (String)val;
      try
      {
        collation = resolveAgainstBaseUri(collation);
        defaultCollator = NamedCollator.make(collation);
      }
      catch (Exception ex)
      {
        defaultCollator = NamedCollator.codepointCollation;
        error('e', "unknown collation '" + collation + "'", "XQST0038");
      }
      parseSeparator();
      return QuoteExp.voidExp;
    
    case 69: 
    case 79: 
      boolean forFunctions = curToken == 79;
      prefix = forFunctions ? "(functions)" : XQuery.DEFAULT_ELEMENT_PREFIX;
      
      if (prologNamespaces.resolve(prefix, builtinNamespaces) != null) {
        error('e', "duplicate default namespace declaration", "XQST0066");

      }
      else if ((seenDeclaration) && (!isInteractive()))
        error('e', "default namespace declared after function/variable/option");
      getRawToken();
      if (match("namespace")) {
        getRawToken();
      }
      else {
        String msg = "expected 'namespace' keyword";
        if ((curToken != 34) && (curToken != 402)) {
          return declError(msg);
        }
        warnOldVersion(msg);
      }
      if ((curToken == 402) || (curToken == 76))
      {
        warnOldVersion("extra '=' in default namespace declaration");
        getRawToken();
      }
      if (curToken != 34)
        return declError("missing namespace uri");
      uri = new String(tokenBuffer, 0, tokenBufferLength).intern();
      if (forFunctions)
      {
        functionNamespacePath = new Namespace[1];
        functionNamespacePath[0] = Namespace.valueOf(uri);
      }
      else
      {
        defaultElementNamespace = uri;
      }
      pushNamespace(prefix, uri);
      checkAllowedNamespaceDeclaration(prefix, uri, false);
      parseSeparator();
      return QuoteExp.voidExp;
    
    case 83: 
      getRawToken();
      if (curToken == 402)
      {
        warnOldVersion("obsolate '=' in boundary-space declaration");
        getRawToken();
      }
      if ((boundarySpaceDeclarationSeen) && (!isInteractive()))
        syntaxError("duplicate 'declare boundary-space' seen", "XQST0068");
      boundarySpaceDeclarationSeen = true;
      if (match("preserve")) {
        boundarySpacePreserve = true;
      } else if (match("strip")) {
        boundarySpacePreserve = false;
      } else if (match("skip"))
      {
        warnOldVersion("update: declare boundary-space skip -> strip");
        boundarySpacePreserve = false;
      }
      else {
        return syntaxError("boundary-space declaration must be preserve or strip"); }
      parseSeparator();
      return QuoteExp.voidExp;
    
    case 75: 
      getRawToken();
      if ((constructionModeDeclarationSeen) && (!isInteractive()))
        syntaxError("duplicate 'declare construction' seen", "XQST0067");
      constructionModeDeclarationSeen = true;
      if (match("strip")) {
        constructionModeStrip = true;
      } else if (match("preserve")) {
        constructionModeStrip = false;
      } else
        return syntaxError("construction declaration must be strip or preserve");
      parseSeparator();
      return QuoteExp.voidExp;
    
    case 76: 
      getRawToken();
      if ((copyNamespacesDeclarationSeen) && (!isInteractive()))
        syntaxError("duplicate 'declare copy-namespaces' seen", "XQST0055");
      copyNamespacesDeclarationSeen = true;
      if (match("preserve")) {
        copyNamespacesMode |= 0x1;
      } else if (match("no-preserve")) {
        copyNamespacesMode &= 0xFFFFFFFE;
      } else
        return syntaxError("expected 'preserve' or 'no-preserve' after 'declare copy-namespaces'");
      getRawToken();
      if (curToken != 44)
        return syntaxError("missing ',' in copy-namespaces declaration");
      getRawToken();
      if (match("inherit")) {
        copyNamespacesMode |= 0x2;
      } else if (match("no-inherit")) {
        copyNamespacesMode &= 0xFFFFFFFD;
      } else
        return syntaxError("expected 'inherit' or 'no-inherit' in copy-namespaces declaration");
      parseSeparator();
      return QuoteExp.voidExp;
    
    case 72: 
      getRawToken();
      boolean sawEmpty = match("empty");
      if ((emptyOrderDeclarationSeen) && (!isInteractive()))
        syntaxError("duplicate 'declare default empty order' seen", "XQST0069");
      emptyOrderDeclarationSeen = true;
      if (sawEmpty) {
        getRawToken();
      } else
        syntaxError("expected 'empty greatest' or 'empty least'");
      if (match("greatest")) {
        defaultEmptyOrder = 'G';
      } else if (match("least")) {
        defaultEmptyOrder = 'L';
      } else
        return syntaxError("expected 'empty greatest' or 'empty least'");
      parseSeparator();
      return QuoteExp.voidExp;
    
    case 111: 
      getRawToken();
      if (curToken != 81) {
        syntaxError("expected QName after 'declare option'");
      }
      else {
        String str = new String(tokenBuffer, 0, tokenBufferLength);
        getMessages().setLine(this.port.getName(), curLine, curColumn);
        Symbol sym = namespaceResolve(str, false);
        getRawToken();
        if (curToken != 34) {
          syntaxError("expected string literal after 'declare option " + str + '\'');
        }
        else
          handleOption(sym, new String(tokenBuffer, 0, tokenBufferLength));
      }
      parseSeparator();
      seenDeclaration = true;
      return QuoteExp.voidExp;
    
    case 85: 
      if ((orderingModeSeen) && (!isInteractive()))
        syntaxError("duplicate 'declare ordering' seen", "XQST0065");
      orderingModeSeen = true;
      getRawToken();
      if (match("ordered")) {
        orderingModeUnordered = false;
      } else if (match("unordered")) {
        orderingModeUnordered = true;
      } else
        return syntaxError("ordering declaration must be ordered or unordered");
      parseSeparator();
      return QuoteExp.voidExp;
    
    case 89: 
      if (parseCount != 1) {
        error('e', "'xquery version' does not start module");
      } else if (commentCount > 0)
        error('w', "comments should not precede 'xquery version'");
      getRawToken();
      if (curToken == 34)
      {
        String version = new String(tokenBuffer, 0, tokenBufferLength);
        if (!version.equals("1.0"))
          error('e', "unrecognized xquery version " + version, "XQST0031");
        getRawToken();
      }
      else {
        return syntaxError("missing version string after 'xquery version'"); }
      if (match("encoding"))
      {
        getRawToken();
        if (curToken != 34) {
          return syntaxError("invalid encoding specification");
        }
        
        String encoding = new String(tokenBuffer, 0, tokenBufferLength);
        int i = tokenBufferLength;
        boolean bad = i == 0;
        for (;;) { i--; if ((i < 0) || (bad))
            break;
          ch = tokenBuffer[i];
          if (((ch < 65) || (ch > 90)) && ((ch < 97) || (ch > 122)) && (
          
            (i == 0) || (((ch < 48) || (ch > 57)) && (ch != 46) && (ch != 95) && (ch != 45))))
          {

            bad = true; }
        }
        if (bad)
          error('e', "invalid encoding name syntax", "XQST0087");
        InPort port = getPort();
        if ((port instanceof BinaryInPort)) {
          try {
            ((BinaryInPort)port).setCharset(encoding);
          } catch (UnsupportedCharsetException ex) {
            error('e', "unrecognized encoding name");
          } catch (Exception ex) {
            error('e', "cannot set encoding name here");
          }
        }
        
        getRawToken();
      }
      
      if (curToken != 59)
        syntaxError("missing ';'");
      return QuoteExp.voidExp;
    
    case 66: 
      if ((baseURIDeclarationSeen) && (!isInteractive()))
        syntaxError("duplicate 'declare base-uri' seen", "XQST0032");
      baseURIDeclarationSeen = true;
      val = parseURILiteral();
      if ((val instanceof Expression))
        return (Expression)val;
      parseSeparator();
      setStaticBaseUri((String)val);
      return QuoteExp.voidExp;
    }
    Expression exp = parseExprSequence(-1, true);
    if (curToken == 10)
      unread(10);
    maybeSetLine(exp, startLine, startColumn);
    if (libraryModuleNamespace != null)
      error('e', "query body in a library module", "XPST0003");
    return exp;
  }
  
  static
  {
    NamespaceBinding ns = NamespaceBinding.predefinedXML;
    ns = new NamespaceBinding("xml", "http://www.w3.org/XML/1998/namespace", ns);
    ns = new NamespaceBinding("xs", "http://www.w3.org/2001/XMLSchema", ns);
    ns = new NamespaceBinding("xsi", "http://www.w3.org/2001/XMLSchema-instance", ns);
    ns = new NamespaceBinding("fn", "http://www.w3.org/2005/xpath-functions", ns);
    ns = new NamespaceBinding("html", "http://www.w3.org/1999/xhtml", ns);
    ns = new NamespaceBinding("kawa", "http://kawa.gnu.org/", ns);
    ns = new NamespaceBinding("qexo", "http://qexo.gnu.org/", ns);
    ns = new NamespaceBinding("local", "http://www.w3.org/2005/xquery-local-functions", ns);
    builtinNamespaces = ns;
    
























































    getExternalFunction = QuoteExp.getInstance(new PrimProcedure("gnu.xquery.lang.XQuery", "getExternal", 2));
    
































































































































































































































































































































































































































































































































































































    axisNames = new String[13];
    

    axisNames[0] = "ancestor";
    axisNames[1] = "ancestor-or-self";
    axisNames[2] = "attribute";
    axisNames[3] = "child";
    axisNames[4] = "descendant";
    axisNames[5] = "descendant-or-self";
    axisNames[6] = "following";
    axisNames[7] = "following-sibling";
    axisNames[8] = "namespace";
    axisNames[9] = "parent";
    axisNames[10] = "preceding";
    axisNames[11] = "preceding-sibling";
    axisNames[12] = "self";
  }
  
  public static Expression makeFunctionExp(String className, String name)
  {
    return makeFunctionExp(className, gnu.expr.Mangling.mangleNameIfNeeded(name), name);
  }
  



  public static Expression makeFunctionExp(String className, String fieldName, String name)
  {
    return new ReferenceExp(name, Declaration.getDeclarationValueFromStatic(className, fieldName, name));
  }
  



  String tokenString()
  {
    switch (curToken)
    {
    case 34: 
      StringBuffer sbuf = new StringBuffer();
      sbuf.append('"');
      for (int i = 0; i < tokenBufferLength; i++)
      {
        char ch = tokenBuffer[i];
        if (ch == '"')
          sbuf.append('"');
        sbuf.append(ch);
      }
      sbuf.append('"');
      return sbuf.toString();
    case 70: 
      return new String(tokenBuffer, 0, tokenBufferLength) + " + '('";
    case 65: 
    case 81: 
      return new String(tokenBuffer, 0, tokenBufferLength);
    case -1: 
      return "<EOF>";
    }
    if ((curToken >= 100) && (curToken - 100 < 13))
    {
      return axisNames[(curToken - 100)] + "::-axis(" + curToken + ")"; }
    if ((curToken >= 32) && (curToken < 127))
      return Integer.toString(curToken) + "='" + (char)curToken + "'";
    return Integer.toString(curToken);
  }
  

  public void error(char severity, String message, String code)
  {
    SourceMessages messages = getMessages();
    SourceError err = new SourceError(severity, port.getName(), curLine, curColumn, message);
    
    code = code;
    messages.error(err);
  }
  
  public void error(char severity, String message)
  {
    error(severity, message, null);
  }
  
  public Expression declError(String message)
    throws IOException, SyntaxException
  {
    if (isInteractive())
      return syntaxError(message);
    error(message);
    

    while ((curToken != 59) && (curToken != -1))
    {
      getRawToken();
    }
    return new ErrorExp(message);
  }
  





  public Expression syntaxError(String message, String code)
    throws IOException, SyntaxException
  {
    error('e', message, code);
    if (isInteractive())
    {
      curToken = 0;
      curValue = null;
      nesting = 0;
      getPortreadState = '\n';
      for (;;)
      {
        int ch = read();
        if (ch < 0)
          break;
        if ((ch == 13) || (ch == 10))
        {
          unread(ch);
          break;
        }
      }
      throw new SyntaxException(getMessages());
    }
    return new ErrorExp(message);
  }
  
  public Expression syntaxError(String message)
    throws IOException, SyntaxException
  {
    return syntaxError(message, "XPST0003");
  }
  
  public void eofError(String msg) throws SyntaxException
  {
    fatal(msg, "XPST0003");
  }
  
  public void fatal(String msg, String code) throws SyntaxException
  {
    SourceMessages messages = getMessages();
    SourceError err = new SourceError('f', port.getName(), curLine, curColumn, msg);
    
    code = code;
    messages.error(err);
    throw new SyntaxException(messages);
  }
  
  void warnOldVersion(String message)
  {
    if ((warnOldVersion) || (comp.isPedantic())) {
      error(comp.isPedantic() ? 'e' : 'w', message);
    }
  }
  
  public void maybeSetLine(Expression exp, int line, int column) {
    String file = getName();
    if ((file != null) && (exp.getFileName() == null) && (!(exp instanceof QuoteExp)))
    {

      exp.setFile(file);
      exp.setLine(line, column);
    }
  }
  
  public void maybeSetLine(Declaration decl, int line, int column)
  {
    String file = getName();
    if (file != null)
    {
      decl.setFile(file);
      decl.setLine(line, column);
    }
  }
  
  public void handleOption(Symbol name, String value) {}
}
