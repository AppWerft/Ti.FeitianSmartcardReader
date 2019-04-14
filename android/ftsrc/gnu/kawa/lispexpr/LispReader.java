package gnu.kawa.lispexpr;

import gnu.bytecode.PrimType;
import gnu.expr.Special;
import gnu.kawa.io.InPort;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Values;
import gnu.math.Complex;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Quaternion;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.text.Char;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;

public class LispReader extends gnu.text.Lexer
{
  boolean returnMutablePairs;
  GeneralHashTable<Integer, Object> sharedStructureTable;
  boolean inQuasiSyntax;
  
  public LispReader(InPort port)
  {
    super(port);
  }
  
  public LispReader(InPort port, SourceMessages messages)
  {
    super(port, messages);
  }
  
  public void setReturnMutablePairs(boolean v)
  {
    returnMutablePairs = v;
  }
  






  public Object bindSharedObject(int sharingIndex, Object value)
  {
    if (sharingIndex >= 0) {
      GeneralHashTable<Integer, Object> map = sharedStructureTable;
      if (map == null) {
        map = new GeneralHashTable();
        sharedStructureTable = map;
      }
      Integer key = Integer.valueOf(sharingIndex);
      if (map.get(key, this) != this)
        error('w', "a duplicate #n= definition was read");
      map.put(key, value);
    }
    return value;
  }
  



  public final void readNestedComment(char start1, char start2, char end1, char end2)
    throws IOException, SyntaxException
  {
    int commentNesting = 1;
    int startLine = port.getLineNumber();
    int startColumn = port.getColumnNumber();
    StringBuilder buf = null;
    if (((port instanceof gnu.kawa.io.BinaryInPort)) && ((startLine == 0) || (startLine == 1)))
      buf = new StringBuilder();
    do {
      int c = read();
      if (buf != null)
        buf.append((char)c);
      if (c == end1) {
        c = read();
        if (buf != null)
          buf.append((char)c);
        if (c == end2)
          commentNesting--;
      } else if (c == start1) {
        c = read();
        if (c == start2)
          commentNesting++;
      }
      if (c < 0) {
        eofError("unexpected end-of-file in " + start1 + start2 + " comment starting here", startLine + 1, startColumn - 1);
        

        return;
      }
    } while (commentNesting > 0);
    if (buf != null)
      checkEncodingSpec(buf.toString());
  }
  
  public void checkEncodingSpec(String line) {
    java.util.regex.Matcher m = java.util.regex.Pattern.compile("coding[:=]\\s*([-a-zA-Z0-9]+)").matcher(line);
    
    if (m.find()) {
      String enc = m.group(1);
      try {
        ((gnu.kawa.io.BinaryInPort)getPort()).setCharset(enc);
      } catch (java.nio.charset.UnsupportedCharsetException ex) {
        error('e', "unrecognized encoding name " + enc);
      } catch (Exception ex) {
        error('e', "cannot set encoding name here");
      }
    }
  }
  


  char readCase = lookupReadCase();
  public static final char TOKEN_ESCAPE_CHAR = '￿';
  protected boolean seenEscapes;
  static final int SCM_COMPLEX = 1;
  public static final int SCM_NUMBERS = 1;
  
  public char getReadCase() {
    return readCase; }
  public void setReadCase(char readCase) { this.readCase = readCase;
  }
  
  static char lookupReadCase()
  {
    // Byte code:
    //   0: invokestatic 39	gnu/mapping/Environment:getCurrent	()Lgnu/mapping/Environment;
    //   3: ldc 40
    //   5: ldc 41
    //   7: invokevirtual 42	gnu/mapping/Environment:get	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   10: invokevirtual 43	java/lang/Object:toString	()Ljava/lang/String;
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 44	java/lang/String:length	()I
    //   18: ifle +65 -> 83
    //   21: aload_0
    //   22: iconst_0
    //   23: invokevirtual 45	java/lang/String:charAt	(I)C
    //   26: istore_1
    //   27: iload_1
    //   28: bipush 80
    //   30: if_icmpne +6 -> 36
    //   33: goto +48 -> 81
    //   36: iload_1
    //   37: bipush 117
    //   39: if_icmpne +9 -> 48
    //   42: bipush 85
    //   44: istore_1
    //   45: goto +36 -> 81
    //   48: iload_1
    //   49: bipush 100
    //   51: if_icmpeq +15 -> 66
    //   54: iload_1
    //   55: bipush 108
    //   57: if_icmpeq +9 -> 66
    //   60: iload_1
    //   61: bipush 76
    //   63: if_icmpne +9 -> 72
    //   66: bipush 68
    //   68: istore_1
    //   69: goto +12 -> 81
    //   72: iload_1
    //   73: bipush 105
    //   75: if_icmpne +6 -> 81
    //   78: bipush 73
    //   80: istore_1
    //   81: iload_1
    //   82: ireturn
    //   83: goto +4 -> 87
    //   86: astore_0
    //   87: iconst_0
    //   88: ireturn
    // Line number table:
    //   Java source line #135	-> byte code offset #0
    //   Java source line #137	-> byte code offset #14
    //   Java source line #139	-> byte code offset #21
    //   Java source line #140	-> byte code offset #27
    //   Java source line #141	-> byte code offset #36
    //   Java source line #142	-> byte code offset #42
    //   Java source line #143	-> byte code offset #48
    //   Java source line #144	-> byte code offset #66
    //   Java source line #145	-> byte code offset #72
    //   Java source line #146	-> byte code offset #78
    //   Java source line #147	-> byte code offset #81
    //   Java source line #152	-> byte code offset #83
    //   Java source line #150	-> byte code offset #86
    //   Java source line #153	-> byte code offset #87
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	9	0	read_case_string	String
    //   86	2	0	ex	Exception
    //   26	56	1	read_case	char
    // Exception table:
    //   from	to	target	type
    //   0	82	86	java/lang/Exception
  }
  
  public Object readValues(int ch, ReadTable rtable, int sharingIndex)
    throws IOException, SyntaxException
  {
    return readValues(ch, rtable.lookup(ch), rtable, sharingIndex);
  }
  


  public Object readValues(int ch, ReadTableEntry entry, ReadTable rtable, int sharingIndex)
    throws IOException, SyntaxException
  {
    seenEscapes = false;
    return entry.read(this, ch, -1, sharingIndex);
  }
  
  public Pair readValuesAndAppend(int ch, ReadTable rtable, Pair last) throws IOException, SyntaxException
  {
    int line = port.getLineNumber();
    int column = port.getColumnNumber() - 1;
    Object values = readValues(ch, rtable, -1);
    int index = 0;
    int next = Values.nextIndex(values, index);
    if (next >= 0) {
      for (;;) {
        Object value = Values.nextValue(values, index);
        index = next;
        if (value == gnu.expr.QuoteExp.voidExp)
          value = Values.empty;
        next = Values.nextIndex(values, index);
        if (next < 0)
          value = handlePostfix(value, rtable, line, column);
        Pair pair = makePair(value, line, column);
        setCdr(last, pair);
        last = pair;
        if (next < 0)
          break;
      }
    }
    return last;
  }
  
  protected Object readAndHandleToken(int ch, int startPos, ReadTable rtable)
    throws IOException, SyntaxException
  {
    readToken(ch, rtable);
    return handleToken(startPos, rtable);
  }
  

  protected Object handleToken(int startPos, ReadTable rtable)
    throws IOException, SyntaxException
  {
    char readCase = getReadCase();
    int endPos = tokenBufferLength;
    if (!seenEscapes)
    {
      Object value = parseNumber(tokenBuffer, startPos, endPos - startPos, '\000', 0, 0x1 | extraFlags);
      
      if ((value != null) && (!(value instanceof String)))
      {
        tokenBufferLength = startPos;
        return value;
      }
    }
    








    if (readCase == 'I')
    {
      int upperCount = 0;
      int lowerCount = 0;
      for (int i = startPos; i < endPos; i++)
      {
        char ci = tokenBuffer[i];
        if (ci == 65535) {
          i++;
        } else if (Character.isLowerCase(ci)) {
          lowerCount++;
        } else if (Character.isUpperCase(ci))
          upperCount++;
      }
      if (lowerCount == 0) {
        readCase = 'D';
      } else if (upperCount == 0) {
        readCase = 'U';
      } else {
        readCase = 'P';
      }
    }
    boolean handleUri = (endPos >= startPos + 2) && (tokenBuffer[(endPos - 1)] == '}') && (tokenBuffer[(endPos - 2)] != 65535) && (peek() == 58);
    



    int packageMarker = -1;
    int lbrace = -1;int rbrace = -1;int braceNesting = 0;
    int j = startPos;
    boolean uriBad = false;
    for (int i = startPos; i < endPos; i++)
    {
      char ci = tokenBuffer[i];
      if (ci == 65535)
      {
        i++; if (i < endPos) {
          tokenBuffer[(j++)] = tokenBuffer[i];
        }
      } else {
        if (handleUri)
        {
          if (ci == '{')
          {
            if (lbrace < 0) {
              lbrace = j;
            } else if (braceNesting == 0)
              uriBad = true;
            braceNesting++;
          }
          else if (ci == '}')
          {
            braceNesting--;
            if (braceNesting < 0) {
              uriBad = true;
            } else if (braceNesting == 0)
            {
              if (rbrace < 0) {
                rbrace = j;
              } else
                uriBad = true;
            }
          }
        }
        if (braceNesting <= 0)
        {
          if (ci == ':') {
            packageMarker = packageMarker >= 0 ? -1 : j;
          } else if (readCase == 'U') {
            ci = Character.toUpperCase(ci);
          } else if (readCase == 'D')
            ci = Character.toLowerCase(ci); }
        tokenBuffer[(j++)] = ci;
      } }
    endPos = j;
    
    int len = endPos - startPos;
    Object result;
    Object result;
    if ((lbrace >= 0) && (rbrace > lbrace))
    {
      String prefix = lbrace > 0 ? new String(tokenBuffer, startPos, lbrace - startPos) : null;
      lbrace++;
      String uri = new String(tokenBuffer, lbrace, rbrace - lbrace);
      int ch = read();
      ch = read();
      Object rightOperand = readValues(ch, rtable.lookup(ch), rtable, -1);
      if (!(rightOperand instanceof gnu.mapping.SimpleSymbol)) {
        error("expected identifier in symbol after '{URI}:'");
      }
      result = gnu.mapping.Symbol.valueOf(rightOperand.toString(), uri, prefix);
    } else { Object result;
      if ((initialColonIsKeyword) && (packageMarker == startPos) && (len > 1))
      {
        startPos++;
        String str = new String(tokenBuffer, startPos, endPos - startPos);
        result = gnu.expr.Keyword.make(str.intern());
      } else { Object result;
        if ((finalColonIsKeyword) && (packageMarker != -1) && (packageMarker == endPos - 1) && ((len > 1) || (seenEscapes)))
        {

          String str = new String(tokenBuffer, startPos, len - 1);
          result = gnu.expr.Keyword.make(str.intern());
        }
        else {
          if ((len == 1) && (tokenBuffer[startPos] == '.') && (!seenEscapes))
            error("invalid use of '.' token");
          result = rtable.makeSymbol(new String(tokenBuffer, startPos, len));
        } } }
    tokenBufferLength = startPos;
    return result;
  }
  










  void readToken(int ch, ReadTable rtable)
    throws IOException, SyntaxException
  {
    boolean inEscapes = false;
    int braceNesting = 0;
    for (;; ch = read())
    {
      if (ch < 0)
      {
        if (!inEscapes) break;
        eofError("unexpected EOF between escapes");
      }
      

      ReadTableEntry entry = rtable.lookup(ch);
      int kind = entry.getKind();
      if (kind == 0)
      {
        if (inEscapes)
        {
          tokenBufferAppend(65535);
          tokenBufferAppend(ch);
        }
        else {
          if (ch == 125) { braceNesting--; if (braceNesting >= 0)
            {
              tokenBufferAppend(ch);
              continue;
            } }
          unread(ch);
          break;
        }
      } else { if ((ch == postfixLookupOperator) && (!inEscapes))
        {
          int next = port.peek();
          if (next == postfixLookupOperator)
          {
            unread(ch);
            break;
          }
          if (validPostfixLookupStart(next, rtable)) {
            kind = 5;
          }
        }
        if (kind == 3)
        {
          ch = read();
          if (ch < 0)
            eofError("unexpected EOF after single escape");
          if ((hexEscapeAfterBackslash) && ((inEscapes) || (ch == 120) || (ch == 88)))
          {


            ch = readEscape(ch); }
          if (ch >= 0)
          {
            tokenBufferAppend(65535);
            tokenBufferAppend(ch);
          }
          seenEscapes = true;

        }
        else if (kind == 4)
        {
          inEscapes = !inEscapes;
          seenEscapes = true;

        }
        else if (inEscapes)
        {

          tokenBufferAppend(65535);
          tokenBufferAppend(ch);

        }
        else
        {
          switch (kind)
          {
          case 2: 
            if ((ch == 123) && (entry == ReadTableEntry.brace)) {
              braceNesting++;
            }
          case 6: 
            tokenBufferAppend(ch);
            break;
          case 4: 
            inEscapes = true;
            seenEscapes = true;
            break;
          case 5: 
            unread(ch);
            return;
          
          case 1: 
            unread(ch);
            return;
          }
        }
      }
    }
  }
  
  public String readTokenString(int ch, ReadTable rtable) throws IOException, SyntaxException {
    int startPos = tokenBufferLength;
    if (ch >= 0)
      tokenBufferAppend(ch);
    readToken(read(), rtable);
    int length = tokenBufferLength - startPos;
    String str = new String(tokenBuffer, startPos, length);
    tokenBufferLength = startPos;
    return str;
  }
  
  public Object readObject() throws IOException, SyntaxException {
    return readObject(-1, false);
  }
  
  public Object readObject(int sharingIndex, boolean topLevel)
    throws IOException, SyntaxException
  {
    char saveReadState = port.readState;
    int startPos = tokenBufferLength;
    port.readState = ' ';
    try
    {
      ReadTable rtable = ReadTable.getCurrent();
      int line;
      int column;
      do { line = port.getLineNumber();
        column = port.getColumnNumber();
        int ch = port.read();
        if (ch < 0)
          return gnu.lists.Sequence.eofValue;
        value = readValues(ch, rtable, sharingIndex);
      } while (value == Values.empty);
      
      Object value = handlePostfix(value, rtable, line, column);
      if ((topLevel) && (!(value instanceof Pair)))
      {

        value = makePair(kawa.standard.begin.begin, makePair(value, line, column), line, column);
      }
      
      return value;

    }
    finally
    {
      tokenBufferLength = startPos;
      port.readState = saveReadState;
    }
  }
  
  protected boolean validPostfixLookupStart(int ch, ReadTable rtable) throws IOException
  {
    if ((ch < 0) || (ch == postfixLookupOperator))
      return false;
    if (ch == 44)
      return true;
    if (ch == 64)
      return true;
    int kind = rtable.lookup(ch).getKind();
    return (kind == 2) || (kind == 6) || (kind == 4) || (kind == 3);
  }
  





  protected Object handlePostfix(Object value, ReadTable rtable, int line, int column)
    throws IOException, SyntaxException
  {
    if (value == gnu.expr.QuoteExp.voidExp)
      value = Values.empty;
    for (;;) {
      int ch = port.peek();
      
      if ((ch == 91) && (ReadTable.defaultBracketMode == -2)) {
        port.read();
        Object lst = ReaderParens.readList(this, null, ch, 1, 93, -1);
        value = makePair(value, lst, line, column);
        value = makePair(LispLanguage.bracket_apply_sym, value, line, column);
      } else {
        if (ch != postfixLookupOperator)
          break;
        port.read();
        int ch2 = port.peek();
        Object rightOperand;
        Object rightOperand; if (ch2 == 64) {
          error('w', "deprecated cast syntax TYPE:@ (use ->TYPE instead)");
          
          rightOperand = readAndHandleToken(92, 0, rtable);
        } else {
          if (!validPostfixLookupStart(ch2, rtable)) {
            unread();
            break;
          }
          ch = port.read();
          rightOperand = readValues(ch, rtable.lookup(ch), rtable, -1);
        }
        value = LList.list2(value, LList.list2(LispLanguage.quasiquote_sym, rightOperand));
        
        value = makePair(LispLanguage.lookup_sym, value, line, column);
      }
    }
    


    return value;
  }
  
  private boolean isPotentialNumber(char[] buffer, int start, int end)
  {
    int sawDigits = 0;
    for (int i = start; i < end; i++)
    {
      char ch = buffer[i];
      if (Character.isDigit(ch)) {
        sawDigits++;
      } else if ((ch == '-') || (ch == '+'))
      {
        if (i + 1 == end)
          return false;
      } else {
        if (ch == '#')
          return true;
        if ((Character.isLetter(ch)) || (ch == '/') || (ch == '_') || (ch == '^'))
        {




          if (i == start) {
            return false;
          }
        } else if (ch != '.')
          return false;
      } }
    return sawDigits > 0;
  }
  






  public static Object parseNumber(CharSequence str, int radix)
  {
    int len = str.length();
    int where;
    char[] buf; int where; char[] buf; if (((str instanceof FString)) && ((where = ((FString)str).getSegmentReadOnly(0, len)) >= 0))
    {
      buf = ((FString)str).getBuffer();
    } else {
      where = 0;
      buf = str.toString().toCharArray();
    }
    return parseNumber(buf, where, len, '\000', radix, 1);
  }
  



  public static final int SCM_ANGLE = 2;
  

  public static final int SCM_COLATITUDE = 4;
  

  public static final int SCM_LEXPONENT_IS_BIGDECIMAL = 8;
  

  boolean deprecatedXmlEnlosedReported;
  

  public static Object parseNumber(char[] buffer, int start, int count, char exactness, int radix, int flags)
  {
    int end = start + count;
    int pos = start;
    if (pos >= end)
      return "no digits";
    char ch = buffer[(pos++)];
    while (ch == '#')
    {
      if (pos >= end)
        return "no digits";
      ch = buffer[(pos++)];
      switch (ch) {
      case 'B': 
      case 'b': 
        if (radix > 0)
          return "duplicate radix specifier";
        radix = 2;
        break;
      case 'O': case 'o': 
        if (radix > 0)
          return "duplicate radix specifier";
        radix = 8;
        break;
      case 'D': case 'd': 
        if (radix > 0)
          return "duplicate radix specifier";
        radix = 10;
        break;
      case 'X': case 'x': 
        if (radix > 0)
          return "duplicate radix specifier";
        radix = 16;
        break;
      case 'E': case 'I': 
      case 'e': case 'i': 
        if (exactness != 0)
        {
          if (exactness == ' ') {
            return "non-prefix exactness specifier";
          }
          return "duplicate exactness specifier";
        }
        exactness = ch;
        break;
      default: 
        int value = 0;
        for (;;)
        {
          int dig = Character.digit(ch, 10);
          if (dig < 0)
            break;
          value = 10 * value + dig;
          if (pos >= end)
            return "missing letter after '#'";
          ch = buffer[(pos++)];
        }
        if ((ch == 'R') || (ch == 'r'))
        {
          if (radix > 0)
            return "duplicate radix specifier";
          if ((value < 2) || (value > 35))
            return "invalid radix specifier";
          radix = value;
        }
        else {
          return "unknown modifier '#" + ch + '\''; }
        break; }
      if (pos >= end)
        return "no digits";
      ch = buffer[(pos++)];
    }
    if (exactness == 0)
      exactness = ' ';
    if (radix < 0) {
      radix = -radix;
    } else if (radix == 0)
    {
      radix = 10;
    }
    

















    boolean negative = ch == '-';
    boolean numeratorNegative = negative;
    boolean sign_seen = (ch == '-') || (ch == '+');
    if (sign_seen)
    {
      if (pos >= end)
        return "no digits following sign";
      ch = buffer[(pos++)];
    }
    

    if (((ch == 'i') || (ch == 'I')) && ((pos == end) || (buffer[pos] == '+') || (buffer[pos] == '-')) && (start == pos - 2) && ((flags & 0x1) != 0))
    {

      char sign = buffer[start];
      if ((sign != '+') && (sign != '-'))
        return "no digits";
      if (pos < end) {
        Object jmag = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
        
        if ((jmag instanceof String))
          return jmag;
        if (!(jmag instanceof Quaternion))
          return "invalid numeric constant (" + jmag + ")";
        Quaternion qjmag = (Quaternion)jmag;
        RealNum re = qjmag.re();
        RealNum im = qjmag.im();
        if ((!re.isZero()) || (!im.isZero()))
          return "invalid numeric constant";
        if ((exactness == 'i') || (exactness == 'I')) {
          return Quaternion.make(0.0D, negative ? -1.0D : 1.0D, qjmag.doubleJmagValue(), qjmag.doubleKmagValue());
        }
        
        return Quaternion.make(IntNum.zero(), negative ? IntNum.minusOne() : IntNum.one(), qjmag.jm(), qjmag.km());
      }
      

      if ((exactness == 'i') || (exactness == 'I'))
        return new gnu.math.DComplex(0.0D, negative ? -1.0D : 1.0D);
      return negative ? Complex.imMinusOne() : Complex.imOne();
    }
    
    if (((ch == 'j') || (ch == 'J')) && ((pos == end) || (buffer[pos] == '+') || (buffer[pos] == '-')) && (start == pos - 2) && ((flags & 0x1) != 0))
    {

      char sign = buffer[start];
      if ((sign != '+') && (sign != '-'))
        return "no digits";
      if (pos < end) {
        Object kmag = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
        
        if ((kmag instanceof String))
          return kmag;
        if (!(kmag instanceof Quaternion))
          return "invalid numeric constant (" + kmag + ")";
        Quaternion qkmag = (Quaternion)kmag;
        RealNum re = qkmag.re();
        RealNum im = qkmag.im();
        RealNum jm = qkmag.jm();
        if ((!re.isZero()) || (!im.isZero()) || (!jm.isZero()))
          return "invalid numeric constant";
        if ((exactness == 'i') || (exactness == 'I')) {
          return Quaternion.make(0.0D, 0.0D, negative ? -1.0D : 1.0D, qkmag.doubleKmagValue());
        }
        return Quaternion.make(IntNum.zero(), IntNum.zero(), negative ? IntNum.minusOne() : IntNum.one(), qkmag.km());
      }
      

      if ((exactness == 'i') || (exactness == 'I'))
        return new gnu.math.DQuaternion(0.0D, 0.0D, 0.0D, negative ? -1.0D : 1.0D);
      return negative ? Quaternion.jmMinusOne() : Quaternion.jmOne();
    }
    
    if (((ch == 'k') || (ch == 'K')) && (pos == end) && (start == pos - 2) && ((flags & 0x1) != 0))
    {
      char sign = buffer[start];
      if ((sign != '+') && (sign != '-'))
        return "no digits";
      if ((exactness == 'i') || (exactness == 'I'))
        return new gnu.math.DQuaternion(0.0D, 0.0D, 0.0D, negative ? -1.0D : 1.0D);
      return negative ? Quaternion.kmMinusOne() : Quaternion.kmOne();
    }
    
    int realStart = pos - 1;
    boolean hash_seen = false;
    int exp_seen = -1;
    int digits_start = -1;
    int decimal_point = -1;
    boolean copy_needed = false;
    boolean underscore_seen = false;
    IntNum numerator = null;
    long lvalue = 0L;
    
    for (;;)
    {
      int digit = Character.digit(ch, radix);
      if (digit >= 0)
      {
        if ((hash_seen) && (decimal_point < 0))
          return "digit after '#' in number";
        if (digits_start < 0)
          digits_start = pos - 1;
        lvalue = radix * lvalue + digit;
      }
      else
      {
        switch (ch)
        {














        case '.': 
          if (decimal_point >= 0)
            return "duplicate '.' in number";
          if (radix != 10)
            return "'.' in non-decimal number";
          decimal_point = pos - 1;
          break;
        case 'D': case 'E': case 'F': case 'L': case 'S': 
        case 'd': case 'e': case 'f': case 'l': case 's': 
          if ((pos == end) || (radix != 10))
          {
            pos--;
          }
          else {
            char next = buffer[pos];
            int exp_pos = pos - 1;
            if ((next == '+') || (next == '-'))
            {
              pos++; if ((pos >= end) || (Character.digit(buffer[pos], 10) < 0))
              {
                return "missing exponent digits";
              }
            } else if (Character.digit(next, 10) < 0)
            {
              pos--;
              break label1659;
            }
            if (exp_seen >= 0)
              return "duplicate exponent";
            if (radix != 10)
              return "exponent in non-decimal number";
            if (digits_start < 0)
              return "mantissa with no digits";
            exp_seen = exp_pos;
            do
            {
              pos++;
              if (pos >= end) break; } while (Character.digit(buffer[pos], 10) >= 0); }
          break;
        
        case '/': 
          if (numerator != null)
            return "multiple fraction symbol '/'";
          if (digits_start < 0)
            return "no digits before fraction symbol '/'";
          if ((exp_seen >= 0) || (decimal_point >= 0))
            return "fraction symbol '/' following exponent or '.'";
          numerator = valueOf(buffer, digits_start, pos - digits_start, radix, negative, lvalue);
          
          digits_start = -1;
          lvalue = 0L;
          negative = false;
          hash_seen = false;
          underscore_seen = false;
          break;
        default: 
          pos--;
          break; }
        
      }
      if (pos == end)
        break;
      ch = buffer[(pos++)];
    }
    label1659:
    char infnan = '\000';
    
    if (digits_start < 0)
    {
      if ((sign_seen) && (pos + 4 < end) && (buffer[(pos + 3)] == '.') && (buffer[(pos + 4)] == '0'))
      {

        char b0 = buffer[pos];
        char b1;
        char b2; if (((b0 == 'i') || (b0 == 'I')) && (((b1 = buffer[(pos + 1)]) == 'n') || (b1 == 'N')) && (((b2 = buffer[(pos + 2)]) == 'f') || (b2 == 'F')))
        {


          infnan = 'i'; } else { char b1;
          char b2;
          if (((b0 == 'n') || (b0 == 'N')) && (((b1 = buffer[(pos + 1)]) == 'a') || (b1 == 'A')) && (((b2 = buffer[(pos + 2)]) == 'n') || (b2 == 'N')))
          {


            infnan = 'n'; }
        }
      }
      if (infnan == 0)
        return "no digits";
      pos += 5;
    }
    





    boolean inexact = ((hash_seen) || (!underscore_seen)) || ((exactness == 'i') || (exactness == 'I') || ((exactness == ' ') && (hash_seen)));
    
    RealNum number = null;
    char exp_char = '\000';
    if (infnan != 0)
    {
      inexact = true;
      double d = infnan == 'i' ? Double.POSITIVE_INFINITY : NaN.0D;
      number = new DFloNum(negative ? -d : d);
    }
    else if ((exp_seen >= 0) || (decimal_point >= 0))
    {
      if ((digits_start > decimal_point) && (decimal_point >= 0))
        digits_start = decimal_point;
      if (numerator != null)
        return "floating-point number after fraction symbol '/'";
      if ((exactness == 'e') || (exactness == 'E')) {
        int exp = 0;
        IntNum inumber;
        IntNum inumber; if (decimal_point < 0) {
          inumber = valueOf(buffer, digits_start, exp_seen - digits_start, radix, negative, lvalue);

        }
        else
        {
          StringBuilder sbuf = new StringBuilder();
          if (negative)
            sbuf.append('-');
          sbuf.append(buffer, digits_start, decimal_point - digits_start);
          decimal_point++;
          int fracdigits = (exp_seen >= 0 ? exp_seen : pos) - decimal_point;
          
          sbuf.append(buffer, decimal_point, fracdigits);
          inumber = IntNum.valueOf(sbuf.toString());
          exp -= fracdigits;
        }
        if (exp_seen >= 0) {
          exp += Integer.parseInt(new String(buffer, exp_seen + 1, pos - (exp_seen + 1)));
        }
        
        if (exp > 0) {
          number = IntNum.times(inumber, IntNum.power(IntNum.ten(), exp));
        } else if (exp < 0) {
          number = RatNum.make(inumber, IntNum.power(IntNum.ten(), -exp));
        } else
          number = inumber;
      } else {
        String str = new String(buffer, digits_start, pos - digits_start);
        if (exp_seen >= 0) {
          exp_char = Character.toLowerCase(buffer[exp_seen]);
          if (exp_char != 'e') {
            int prefix = exp_seen - digits_start;
            str = str.substring(0, prefix) + 'e' + str.substring(prefix + 1);
          }
        }
        double d = gnu.lists.Convert.parseDouble(str);
        number = new DFloNum(negative ? -d : d);
      }
    }
    else
    {
      IntNum iresult = valueOf(buffer, digits_start, pos - digits_start, radix, negative, lvalue);
      
      if (numerator == null) {
        number = iresult;



      }
      else if (iresult.isZero())
      {
        boolean numeratorZero = numerator.isZero();
        if (inexact) {
          number = new DFloNum(numeratorNegative ? Double.NEGATIVE_INFINITY : numeratorZero ? NaN.0D : Double.POSITIVE_INFINITY);
        }
        else {
          if (numeratorZero) {
            return "0/0 is undefined";
          }
          number = RatNum.make(numerator, iresult);
        }
      }
      else {
        number = RatNum.make(numerator, iresult);
      }
      
      if ((inexact) && (number.isExact()))
      {
        number = new DFloNum((numeratorNegative) && (number.isZero()) ? -0.0D : number.doubleValue());
      }
    }
    
    if ((exactness == 'e') || (exactness == 'E')) {
      number = number.toExact();
    }
    if (pos < end)
    {
      ch = buffer[(pos++)];
      
      if (ch == '@')
      {
        Object angle = parseNumber(buffer, pos, end - pos, exactness, radix, flags | 0x2);
        
        if ((angle instanceof String))
          return angle;
        if ((!(angle instanceof RealNum)) && (!(angle instanceof RealNum[])))
          return "invalid complex polar constant";
        if ((angle instanceof RealNum[])) {
          RealNum[] polars = (RealNum[])angle;
          if ((number.isZero()) && ((!polars[0].isExact()) || (!polars[1].isExact()) || (!polars[2].isExact())))
          {

            return new DFloNum(0.0D); }
          return Quaternion.polar(number, polars[0], polars[1], polars[2]);
        }
        
        RealNum rangle = (RealNum)angle;
        

        if ((number.isZero()) && (!rangle.isExact())) {
          return new DFloNum(0.0D);
        }
        return Complex.polar(number, rangle);
      }
      if (ch == '%')
      {
        Object colatitude = parseNumber(buffer, pos, end - pos, exactness, radix, flags | 0x4);
        

        if ((colatitude instanceof String))
          return colatitude;
        if ((!(colatitude instanceof RealNum)) && (!(colatitude instanceof RealNum[])))
        {
          return "invalid quaternion polar constant"; }
        if ((flags & 0x2) == 0)
        {
          RealNum rangle = IntNum.zero();
          RealNum rlongitude;
          RealNum rcolatitude; RealNum rlongitude; if ((colatitude instanceof RealNum)) {
            RealNum rcolatitude = (RealNum)colatitude;
            rlongitude = IntNum.zero();
          } else {
            RealNum[] polars = (RealNum[])colatitude;
            rcolatitude = polars[1];
            rlongitude = polars[2];
          }
          


          if ((number.isZero()) && ((!rcolatitude.isExact()) || (!rlongitude.isExact())))
          {
            return new DFloNum(0.0D); }
          return Quaternion.polar(number, rangle, rcolatitude, rlongitude);
        }
        
        if ((colatitude instanceof RealNum[])) {
          RealNum[] polars = (RealNum[])colatitude;
          polars[0] = number;
          return polars;
        }
        return new RealNum[] { number, (RealNum)colatitude, IntNum.zero() };
      }
      if (ch == '&')
      {
        Object longitude = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
        
        if ((longitude instanceof String))
          return longitude;
        if (!(longitude instanceof RealNum))
          return "invalid quaternion polar constant";
        RealNum rlongitude = (RealNum)longitude;
        if ((flags & 0x6) == 0)
        {



          if ((number.isZero()) && (!rlongitude.isExact()))
            return new DFloNum(0.0D);
          return Quaternion.polar(number, IntNum.zero(), IntNum.zero(), rlongitude);
        }
        
        if ((flags & 0x4) != 0)
          return new RealNum[] { IntNum.zero(), number, rlongitude };
        return new RealNum[] { number, IntNum.zero(), rlongitude };
      }
      
      if ((ch == '-') || (ch == '+'))
      {
        pos--;
        Object imag = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
        
        if ((imag instanceof String))
          return imag;
        if (!(imag instanceof Quaternion))
          return "invalid numeric constant (" + imag + ")";
        Quaternion cimag = (Quaternion)imag;
        RealNum re = cimag.re();
        if (!re.isZero())
          return "invalid numeric constant";
        return Quaternion.make(number, cimag.im(), cimag.jm(), cimag.km());
      }
      
      int lcount = 0;
      for (;;)
      {
        if (!Character.isLetter(ch))
        {
          pos--;
          break;
        }
        lcount++;
        if (pos == end)
          break;
        ch = buffer[(pos++)];
      }
      
      if (lcount == 1) {
        char prev = buffer[(pos - 1)];
        if ((prev == 'i') || (prev == 'I')) {
          if (pos < end) {
            Object jmag = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
            
            if ((jmag instanceof String))
              return jmag;
            if (!(jmag instanceof Quaternion))
              return "invalid numeric constant (" + jmag + ")";
            Quaternion qjmag = (Quaternion)jmag;
            RealNum re = qjmag.re();
            RealNum im = qjmag.im();
            if ((!re.isZero()) || (!im.isZero()))
              return "invalid numeric constant";
            return Quaternion.make(IntNum.zero(), number, qjmag.jm(), qjmag.km());
          }
          
          return Complex.make(IntNum.zero(), number);
        }
        if ((prev == 'j') || (prev == 'J')) {
          if (pos < end) {
            Object kmag = parseNumber(buffer, pos, end - pos, exactness, radix, flags);
            
            if ((kmag instanceof String))
              return kmag;
            if (!(kmag instanceof Quaternion))
              return "invalid numeric constant (" + kmag + ")";
            Quaternion qkmag = (Quaternion)kmag;
            RealNum re = qkmag.re();
            RealNum im = qkmag.im();
            RealNum jm = qkmag.jm();
            if ((!re.isZero()) || (!im.isZero()) || (!jm.isZero()))
              return "invalid numeric constant";
            return Quaternion.make(IntNum.zero(), IntNum.zero(), number, qkmag.km());
          }
          
          return Quaternion.make(IntNum.zero(), IntNum.zero(), number, IntNum.zero());
        }
        
        if ((prev == 'k') || (prev == 'K')) {
          if (pos < end)
            return "junk after imaginary suffix 'k'";
          return Quaternion.make(IntNum.zero(), IntNum.zero(), IntNum.zero(), number);
        }
      }
      
      return "excess junk after number";
    }
    if (((number instanceof DFloNum)) && (exp_char > 0) && (exp_char != 'e'))
    {
      double d = number.doubleValue();
      switch (exp_char) {
      case 'f': 
      case 's': 
        return Float.valueOf((float)d);
      case 'd': 
        return Double.valueOf(d);
      case 'l': 
        if ((flags & 0x8) != 0)
          return java.math.BigDecimal.valueOf(d);
        break;
      }
    }
    return number;
  }
  






  private static IntNum valueOf(char[] buffer, int digits_start, int number_of_digits, int radix, boolean negative, long lvalue)
  {
    if (number_of_digits + radix <= 28) {
      return IntNum.make(negative ? -lvalue : lvalue);
    }
    return IntNum.valueOf(buffer, digits_start, number_of_digits, radix, negative);
  }
  




  public int readEscape()
    throws IOException, SyntaxException
  {
    int c = read();
    if (c < 0)
    {
      eofError("unexpected EOF in character literal");
      return -1;
    }
    return readEscape(c);
  }
  
  public final int readEscape(int c)
    throws IOException, SyntaxException
  {
    switch ((char)c) {
    case 'a': 
      c = 7; break;
    case 'b':  c = 8; break;
    case 't':  c = 9; break;
    case 'n':  c = 10; break;
    case 'v':  c = 11; break;
    case 'f':  c = 12; break;
    case 'r':  c = 13; break;
    case 'e':  c = 27; break;
    case '"':  c = 34; break;
    case '|':  c = 124; break;
    case '\\':  c = 92; break;
    case '\t': 
    case '\n': 
    case '\r': 
    case ' ': 
      for (;;)
      {
        if (c < 0)
        {
          eofError("unexpected EOF in literal");
          return -1;
        }
        if (c == 10)
          break;
        if (c == 13)
        {
          if (peek() == 10)
            skip();
          c = 10;
          break;
        }
        if ((c != 32) && (c != 9))
        {
          unread(c);
          break;
        }
        c = read();
      }
      if (c == 10)
      {

        do
        {
          c = read();
          if (c < 0)
          {
            eofError("unexpected EOF in literal");
            return -1;
          }
        } while ((c == 32) || (c == 9));
        
        unread(c);
        return -2;
      }
      break;
    case 'M': 
      c = read();
      if (c != 45)
      {
        error("Invalid escape character syntax");
        return 63;
      }
      c = read();
      if (c == 92)
        c = readEscape();
      return c | 0x80;
    case 'C': 
      c = read();
      if (c != 45)
      {
        error("Invalid escape character syntax");
        return 63;
      }
    
    case '^': 
      c = read();
      if (c == 92)
        c = readEscape();
      if (c == 63)
        return 127;
      return c & 0x9F;
    
    case '0': 
    case '1': 
    case '2': 
    case '3': 
    case '4': 
    case '5': 
    case '6': 
    case '7': 
      c -= 48;
      int count = 0; for (;;) { count++; if (count >= 3)
          break;
        int d = read();
        int v = Character.digit((char)d, 8);
        if (v >= 0) {
          c = (c << 3) + v;
        }
        else {
          if (d < 0) break;
          unread(d); break;
        }
      }
      
      break;
    case 'u': 
      c = 0;
      int i = 4; for (;;) { i--; if (i < 0)
          break;
        int d = read();
        if (d < 0)
          eofError("premature EOF in \\u escape");
        int v = Character.digit((char)d, 16);
        if (v < 0)
          error("non-hex character following \\u");
        c = 16 * c + v;
      }
      break;
    case 'X': 
    case 'x': 
      return readHexEscape();
    }
    
    return c;
  }
  
  public int readHexEscape()
    throws IOException, SyntaxException
  {
    int c = 0;
    
    for (;;)
    {
      int d = read();
      int v = Character.digit((char)d, 16);
      if (v >= 0) {
        c = (c << 4) + v;
      }
      else {
        if (d == 59) {
          break;
        }
        if (d < 0) break;
        unread(d); break;
      }
    }
    

    return c;
  }
  
  public final Object readObject(int c)
    throws IOException, SyntaxException
  {
    unread(c);
    return readObject();
  }
  


  public Object readCommand()
    throws IOException, SyntaxException
  {
    return readObject(-1, true);
  }
  
  protected Object makeNil()
  {
    return LList.Empty;
  }
  
  protected Pair makePair(Object car, int line, int column)
  {
    return makePair(car, LList.Empty, line, column);
  }
  
  protected Pair makePair(Object car, Object cdr, int line, int column)
  {
    String pname = port.getName();
    if ((!returnMutablePairs) && (pname != null) && (line >= 0)) {
      return gnu.lists.PairWithPosition.make(car, cdr, pname, line + 1, column + 1);
    }
    
    return Pair.make(car, cdr);
  }
  
  protected Pair makePair2(Object car, Object cadr, Object cddr, int line, int column)
  {
    return makePair(car, makePair(cadr, cddr, line, column), line, column);
  }
  
  protected void setCar(Object pair, Object car)
  {
    ((Pair)pair).setCarBackdoor(car);
  }
  
  protected void setCdr(Object pair, Object cdr)
  {
    ((Pair)pair).setCdrBackdoor(cdr);
  }
  





  public static Object readNumberWithRadix(int previous, LispReader reader, int radix)
    throws IOException, SyntaxException
  {
    int startPos = tokenBufferLength - previous;
    ReadTable rtable = ReadTable.getCurrent();
    for (;;) {
      reader.readToken(reader.read(), rtable);
      
      int ch = reader.peek();
      if (ch != 35)
        break;
      reader.tokenBufferAppend(ch);
      reader.skip();
    }
    int endPos = tokenBufferLength;
    if (startPos == endPos)
    {
      reader.error("missing numeric token");
      return IntNum.zero();
    }
    Object result = parseNumber(tokenBuffer, startPos, endPos - startPos, '\000', radix, 0);
    
    if ((result instanceof String))
    {
      reader.error((String)result);
      return IntNum.zero();
    }
    if (result == null)
    {
      reader.error("invalid numeric constant");
      return IntNum.zero();
    }
    
    return result;
  }
  
  public static Object readCharacter(LispReader reader)
    throws IOException, SyntaxException
  {
    int ch = reader.read();
    if (ch < 0)
      reader.eofError("unexpected EOF in character literal");
    int startPos = tokenBufferLength;
    reader.tokenBufferAppend(ch);
    reader.readToken(reader.read(), ReadTable.getCurrent());
    char[] tokenBuffer = reader.tokenBuffer;
    int length = tokenBufferLength - startPos;
    if ((length == 1) || (length == 2)) {
      ch = Character.codePointAt(tokenBuffer, startPos, tokenBufferLength);
      
      if ((ch > 65535) || (length == 1))
        return Char.make(ch);
    }
    String name = new String(tokenBuffer, startPos, length);
    ch = Char.nameToChar(name);
    if (ch >= 0)
      return Char.make(ch);
    ch = tokenBuffer[startPos];
    if ((ch == 120) || (ch == 88))
    {
      int value = 0;
      for (int i = 1;; i++)
      {
        if (i == length)
          return Char.make(value);
        int v = Character.digit(tokenBuffer[(startPos + i)], 16);
        if (v < 0)
          break;
        value = 16 * value + v;
        if (value > 1114111) {
          reader.error("character scalar value greater than #x10FFFF");
          return Char.make(63);
        }
      }
    }
    
    ch = Character.digit(ch, 8);
    if (ch >= 0)
    {
      int value = ch;
      for (int i = 1;; i++)
      {
        if (i == length)
          return Char.make(value);
        ch = Character.digit(tokenBuffer[(startPos + i)], 8);
        if (ch < 0)
          break;
        value = 8 * value + ch;
      }
    }
    reader.error("unknown character name: " + name);
    return Char.make(63);
  }
  
  public static Object readSpecial(LispReader reader)
    throws IOException, SyntaxException
  {
    int ch = reader.read();
    if (ch < 0) {
      reader.eofError("unexpected EOF in #! special form");
    }
    
    if (((ch == 47) || (ch == 32)) && (reader.getLineNumber() == 0) && (reader.getColumnNumber() == 3))
    {


      String filename = reader.getName();
      if ((filename != null) && (gnu.expr.ApplicationMainSupport.commandName.get(null) == null))
      {

        gnu.expr.ApplicationMainSupport.commandName.set(filename);
      }
      
      boolean sawBackslash = false;
      for (;;)
      {
        ch = reader.read();
        if (ch < 0)
          break;
        if (ch == 92) {
          sawBackslash = true;
        } else if ((ch == 10) || (ch == 13))
        {
          if (!sawBackslash)
            break;
          sawBackslash = false;
        }
        else if ((sawBackslash) && (ch != 32) && (ch != 9)) {
          sawBackslash = false;
        } }
      return Values.empty;
    }
    
    String name = reader.readTokenString(ch, ReadTable.getCurrent());
    if (name.equals("optional"))
      return Special.optional;
    if (name.equals("rest"))
      return Special.rest;
    if (name.equals("key"))
      return Special.key;
    if (name.equals("eof"))
      return Special.eof;
    if (name.equals("void"))
    {
      return gnu.expr.QuoteExp.voidExp; }
    if (name.equals("default"))
      return Special.dfault;
    if (name.equals("undefined"))
      return Special.undefined;
    if (name.equals("abstract"))
      return Special.abstractSpecial;
    if (name.equals("native"))
      return Special.nativeSpecial;
    if (name.equals("null"))
      return null;
    if (name.equals("fold-case"))
    {
      readCase = 'D';
      return Values.empty;
    }
    if (name.equals("no-fold-case"))
    {
      readCase = 'P';
      return Values.empty;
    }
    reader.error("unknown named constant #!" + name);
    return null;
  }
  
  public static Object readGeneralArray(LispReader in, int rank, PrimType elementType)
    throws IOException, SyntaxException
  {
    if (rank == -1)
      rank = 1;
    int[] dimensions = new int[rank];
    int[] lowBounds = null;
    boolean error = false;
    int ch = in.read();
    boolean baddim = false;
    int explicitDims = 0;
    if ((ch == 64) || (ch == 58)) {
      for (int r = 0; r < rank; r++) {
        if (ch == 64) {
          ch = in.read();
          boolean neg = ch == 45;
          if (!neg)
            in.unread(ch);
          int low = in.readIntDigits();
          if (low < 0) {
            in.error("expected low-bound after '@'");
            low = 0;
          }
          if (lowBounds == null)
            lowBounds = new int[rank];
          lowBounds[r] = (neg ? -low : low);
          ch = in.read();
          if ((ch != 58) && (r == rank - 1))
            break;
        }
        if (ch == 58) {
          explicitDims++;
          int dim = in.readIntDigits();
          if (dim < 0) {
            in.error("expected dimension after ':'");
            error = true;
          }
          
          dimensions[r] = dim;
          ch = in.read();
        } else if (ch != 64) {
          in.error("missing bounds-specifier (seen " + r + " of " + rank + ")");
          
          error = true;
        }
      }
    }
    
    if ((ch == 64) || (ch == 58)) {
      in.error("too many bounds-specifiers for rank-" + rank + " array");
      
      error = true;
    }
    while ((ch >= 0) && (Character.isWhitespace(ch)))
      ch = in.read();
    SourceLocator sloc = gnu.lists.PairWithPosition.make(null, null, in.getName(), in.getLineNumber() + 1, in.getColumnNumber());
    

    in.unread(ch);
    Object data = in.readObject();
    if (explicitDims == 0) {
      if (!dimensionsFromNested(0, dimensions, data)) {
        in.error("array value is not a nested true list");
        error = true;
      }
    } else if (explicitDims < rank) {
      in.error("only " + explicitDims + " array lengths specified - must be all " + rank + " or none");
      error = true;
    }
    if (error)
      return LList.Empty;
    int size = 1;
    int d = dimensions.length; for (;;) { d--; if (d < 0) break;
      size *= dimensions[d]; }
    Object buffer = elementType == null ? new Object[size] : java.lang.reflect.Array.newInstance(elementType.getReflectClass(), size);
    
    SourceMessages messages = in.getMessages();
    fromNested(buffer, 0, 0, dimensions, data, elementType, sloc, messages);
    return gnu.kawa.functions.Arrays.makeFromSimple(dimensions, lowBounds, buffer, elementType);
  }
  

  static boolean dimensionsFromNested(int dim, int[] dimensions, Object data)
  {
    int rank = dimensions.length;
    if (dim == rank)
      return true;
    java.util.List seq = gnu.lists.Sequences.asSequenceOrNull(data);
    if (seq == null)
      return false;
    int len;
    int len; if ((seq instanceof Pair)) {
      len = LList.listLength(seq, false);
    } else
      len = seq.size();
    if (len < 0)
      return false;
    if (len > dimensions[dim])
      dimensions[dim] = len;
    for (Object el : seq) {
      if (!dimensionsFromNested(dim + 1, dimensions, el))
        return false;
    }
    return true;
  }
  
  static void fromNested(Object buffer, int index, int dim, int[] dimensions, Object value, PrimType elementType, SourceLocator sloc, SourceMessages messages) {
    int rank = dimensions.length;
    int stride; if (dim == rank) {
      char sig1 = elementType == null ? 'L' : elementType.getSignature().charAt(0);
      
      if ((sig1 == 'B') || (sig1 == 'S') || (sig1 == 'I') || (sig1 == 'J')) {
        String msg = null;
        if (!(value instanceof IntNum)) {
          msg = "expected integer value";
        } else {
          Object nvalue = LangPrimType.convertIntegerLiteral((IntNum)value, elementType, true);
          if (nvalue == null) {
            msg = "integer " + value + " not in range of " + elementType.getName();
          } else
            value = nvalue;
        }
        if (msg != null) {
          messages.error('e', sloc, msg);
          value = LangPrimType.convertIntegerLiteral(IntNum.zero(), elementType, true);
        }
      }
      
      if ((sig1 == 'F') || (sig1 == 'D')) {
        RealNum rvalue = RealNum.asRealNumOrNull(value);
        if (rvalue != null) {
          if (sig1 == 'F') {
            value = Float.valueOf(rvalue.floatValue());
          } else
            value = Double.valueOf(rvalue.doubleValue());
        } else {
          messages.error('e', sloc, "expected real value");
        }
      }
      java.lang.reflect.Array.set(buffer, index, value);
    } else {
      dim++;
      stride = 1;
      for (int i = dim; i < rank; i++)
        stride *= dimensions[i];
      while ((value instanceof Pair)) {
        Pair pair = (Pair)value;
        if ((pair instanceof SourceLocator))
          sloc = (SourceLocator)pair;
        fromNested(buffer, index, dim, dimensions, pair.getCar(), elementType, sloc, messages);
        
        value = pair.getCdr();
        index += stride;
      }
      for (Object el : gnu.lists.Sequences.coerceToSequence(value)) {
        fromNested(buffer, index, dim, dimensions, el, elementType, sloc, messages);
        
        index += stride;
      }
    }
  }
}
