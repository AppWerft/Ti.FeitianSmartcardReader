package gnu.ecmascript;

import gnu.expr.QuoteExp;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.lists.Sequence;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.Hashtable;

public class Lexer extends gnu.text.Lexer
{
  private boolean prevWasCR = false;
  
  public Lexer(InPort port)
  {
    super(port);
  }
  
  public static final Char lparenToken = Char.make(40);
  public static final Char rparenToken = Char.make(41);
  public static final Char lbraceToken = Char.make(123);
  public static final Char rbraceToken = Char.make(125);
  public static final Char lbracketToken = Char.make(91);
  public static final Char rbracketToken = Char.make(93);
  public static final Char dotToken = Char.make(46);
  public static final Char condToken = Char.make(63);
  public static final Char commaToken = Char.make(44);
  public static final Char colonToken = Char.make(58);
  public static final Char equalToken = Char.make(61);
  public static final Char tildeToken = Char.make(126);
  public static final Char notToken = Char.make(33);
  public static final Char semicolonToken = Char.make(59);
  public static final Object eolToken = Char.make(10);
  public static final Object eofToken = Sequence.eofValue;
  public static final Reserved elseToken = new Reserved("else", 38);
  
  public static final Reserved newToken = new Reserved("new", 39);
  
  static Hashtable reserved;
  
  static synchronized void initReserved()
  {
    if (reserved == null)
    {
      reserved = new Hashtable(20);
      reserved.put("null", new QuoteExp(null));
      reserved.put("true", new QuoteExp(Boolean.TRUE));
      reserved.put("false", new QuoteExp(Boolean.FALSE));
      
      reserved.put("var", new Reserved("var", 30));
      reserved.put("if", new Reserved("if", 31));
      reserved.put("while", new Reserved("while", 32));
      reserved.put("for", new Reserved("for", 33));
      reserved.put("continue", new Reserved("continue", 34));
      
      reserved.put("break", new Reserved("break", 35));
      reserved.put("return", new Reserved("return", 36));
      reserved.put("with", new Reserved("with", 37));
      reserved.put("function", new Reserved("function", 41));
      
      reserved.put("this", new Reserved("this", 40));
      reserved.put("else", elseToken);
      reserved.put("new", newToken);
    }
  }
  
  public static Object checkReserved(String name) {
    if (reserved == null)
      initReserved();
    return reserved.get(name);
  }
  
  public Double getNumericLiteral(int c)
    throws IOException
  {
    int radix = 10;
    if (c == 48)
    {
      c = read();
      if ((c == 120) || (c == 88))
      {
        radix = 16;
        c = read();
      }
      else if ((c != 46) && (c != 101) && (c != 69))
      {
        radix = 8;
      } }
    int i = port.pos;
    if (c >= 0)
      i--;
    port.pos = i;
    long ival = readDigitsInBuffer(port, 0L, radix);
    boolean digit_seen = port.pos > i;
    if ((digit_seen) && (port.pos < port.limit))
    {
      c = port.buffer[port.pos];
      if ((!Character.isLetterOrDigit((char)c)) && (c != 46)) {
        double dval;
        double dval;
        if (ival >= 0L) {
          dval = ival;
        } else {
          dval = IntNum.valueOf(port.buffer, i, port.pos - i, radix, false).doubleValue();
        }
        return new Double(dval);
      }
    }
    if (radix != 10)
      error("invalid character in non-decimal number");
    StringBuffer str = new StringBuffer(20);
    if (digit_seen) {
      str.append(port.buffer, i, port.pos - i);
    }
    
    int point_loc = -1;
    int exp = 0;
    boolean exp_seen = false;
    for (;;)
    {
      c = port.read();
      if (Character.digit((char)c, radix) >= 0)
      {
        digit_seen = true;
        str.append((char)c);
      }
      else {
        switch (c)
        {
        case 46: 
          if (point_loc >= 0) {
            error("duplicate '.' in number");
          }
          else {
            point_loc = str.length();
            str.append('.');
          }
          break; }
      } }
    int next;
    if ((radix == 10) && (((next = port.peek()) == 43) || (next == 45) || (Character.digit((char)next, 10) >= 0)))
    {

      if (!digit_seen)
        error("mantissa with no digits");
      exp = readOptionalExponent();
      exp_seen = true;
      c = read();
    }
    



    if (c >= 0) {
      port.unread();
    }
    if (exp != 0)
    {
      str.append('e');
      str.append(exp);
    }
    return new Double(str.toString());
  }
  
  public String getStringLiteral(char quote)
    throws IOException, SyntaxException
  {
    int i = port.pos;
    int start = i;
    int limit = port.limit;
    char[] buffer = port.buffer;
    for (; 
        i < limit; i++)
    {
      char c = buffer[i];
      if (c == quote)
      {
        port.pos = (i + 1);
        return new String(buffer, start, i - start);
      }
      if ((c == '\\') || (c == '\n') || (c == '\r'))
        break;
    }
    port.pos = i;
    StringBuffer sbuf = new StringBuffer();
    sbuf.append(buffer, start, i - start);
    for (;;)
    {
      int ch = port.read();
      if (ch == quote)
        return sbuf.toString();
      if (ch < 0)
        eofError("unterminated string literal");
      if ((ch == 10) || (ch == 13))
        fatal("string literal not terminated before end of line");
      if (ch == 92)
      {
        ch = port.read();
        int val;
        switch (ch)
        {
        case -1: 
          eofError("eof following '\\' in string");
        case 10: case 13: 
          fatal("line terminator following '\\' in string");
        case 34: case 39: case 92: 
          break;
        case 98:  ch = 8; break;
        case 116:  ch = 9; break;
        case 110:  ch = 10; break;
        case 102:  ch = 12; break;
        case 114:  ch = 13; break;
        case 117: case 120: 
          val = 0;
          i = ch == 120 ? 2 : 4; for (;;) { i--; if (i < 0)
              break;
            int d = port.read();
            if (d < 0) {
              eofError("eof following '\\" + (char)ch + "' in string");
            }
            d = Character.forDigit((char)d, 16);
            if (d < 0)
            {
              error("invalid char following '\\" + (char)ch + "' in string");
              
              val = 63;
              break; }
            val = 16 * val + d;
          }
          ch = val;
          break;
        default: 
          if ((ch >= 48) && (ch <= 55))
          {
            val = 0;
            i = 3; for (;;) { i--; if (i < 0)
                break;
              int d = port.read();
              if (d < 0)
                eofError("eof in octal escape in string literal");
              d = Character.forDigit((char)d, 8);
              if (d < 0)
              {
                port.unread_quick();
                break;
              }
              val = 8 * val + d;
            }
            ch = val;
          }
          break;
        }
      }
      sbuf.append((char)ch);
    }
  }
  
  public String getIdentifier(int ch)
    throws IOException
  {
    int i = port.pos;
    int start = i - 1;
    int limit = port.limit;
    char[] buffer = port.buffer;
    while ((i < limit) && (Character.isJavaIdentifierPart(buffer[i])))
      i++;
    port.pos = i;
    if (i < limit)
      return new String(buffer, start, i - start);
    StringBuffer sbuf = new StringBuffer();
    sbuf.append(buffer, start, i - start);
    for (;;)
    {
      ch = port.read();
      if (ch < 0)
        break label145;
      if (!Character.isJavaIdentifierPart((char)ch)) break;
      sbuf.append((char)ch);
    }
    
    port.unread_quick();
    
    label145:
    
    return sbuf.toString();
  }
  

  public Object maybeAssignment(Object token)
    throws IOException, SyntaxException
  {
    int ch = read();
    if (ch == 61)
    {
      error("assignment operation not implemented");
    }
    
    if (ch >= 0)
      port.unread_quick();
    return token;
  }
  


















  public Object getToken()
    throws IOException, SyntaxException
  {
    int ch = read();
    for (;;)
    {
      if (ch < 0)
        return eofToken;
      if (!Character.isWhitespace((char)ch))
        break;
      if (ch == 13)
      {
        prevWasCR = true;
        return eolToken;
      }
      if ((ch == 10) && (!prevWasCR))
        return eolToken;
      prevWasCR = false;
      ch = read();
    }
    
    switch (ch)
    {
    case 46: 
      ch = port.peek();
      if ((ch >= 48) && (ch <= 57))
        return new QuoteExp(getNumericLiteral(46));
      return dotToken;
    case 48: case 49: case 50: case 51: case 52: 
    case 53: case 54: case 55: case 56: case 57: 
      return new QuoteExp(getNumericLiteral(ch));
    case 34: case 39: 
      return new QuoteExp(getStringLiteral((char)ch));
    case 40:  return lparenToken;
    case 41:  return rparenToken;
    case 91:  return lbracketToken;
    case 93:  return rbracketToken;
    case 123:  return lbraceToken;
    case 125:  return rbraceToken;
    case 63:  return condToken;
    case 58:  return colonToken;
    case 59:  return semicolonToken;
    case 44:  return commaToken;
    case 61: 
      if (port.peek() == 61)
      {
        port.skip_quick();
        return Reserved.opEqual;
      }
      return equalToken;
    case 33: 
      if (port.peek() == 61)
      {
        port.skip_quick();
        return Reserved.opNotEqual;
      }
      return notToken;
    case 126: 
      return tildeToken;
    case 42:  return maybeAssignment(Reserved.opTimes);
    case 47:  return maybeAssignment(Reserved.opDivide);
    case 94:  return maybeAssignment(Reserved.opBitXor);
    case 37:  return maybeAssignment(Reserved.opRemainder);
    case 43: 
      if (port.peek() == 43)
      {
        port.skip_quick();
        return maybeAssignment(Reserved.opPlusPlus);
      }
      return maybeAssignment(Reserved.opPlus);
    case 45: 
      if (port.peek() == 45)
      {
        port.skip_quick();
        return maybeAssignment(Reserved.opMinusMinus);
      }
      return maybeAssignment(Reserved.opMinus);
    case 38: 
      if (port.peek() == 38)
      {
        port.skip_quick();
        return maybeAssignment(Reserved.opBoolAnd);
      }
      return maybeAssignment(Reserved.opBitAnd);
    case 124: 
      if (port.peek() == 124)
      {
        port.skip_quick();
        return maybeAssignment(Reserved.opBoolOr);
      }
      return maybeAssignment(Reserved.opBitOr);
    case 62: 
      ch = port.peek();
      switch (ch)
      {
      case 62: 
        port.skip_quick();
        if (port.peek() == 62)
        {
          port.skip_quick();
          return maybeAssignment(Reserved.opRshiftUnsigned);
        }
        return maybeAssignment(Reserved.opRshiftSigned);
      case 61: 
        port.skip_quick();
        return Reserved.opGreaterEqual;
      }
      return Reserved.opGreater;
    
    case 60: 
      ch = port.peek();
      switch (ch)
      {
      case 60: 
        port.skip_quick();
        return maybeAssignment(Reserved.opLshift);
      case 61: 
        port.skip_quick();
        return Reserved.opLessEqual;
      }
      return Reserved.opLess;
    }
    
    if (Character.isJavaIdentifierStart((char)ch))
    {
      String word = getIdentifier(ch).intern();
      Object token = checkReserved(word);
      if (token != null)
        return token;
      return word;
    }
    return Char.make((char)ch);
  }
  
  public static Object getToken(InPort inp)
    throws IOException, SyntaxException
  {
    return new Lexer(inp).getToken();
  }
  
  public static void main(String[] args)
  {
    InPort inp = InPort.inDefault();
    Lexer reader = new Lexer(inp);
    try
    {
      for (;;)
      {
        Object token = reader.getToken();
        OutPort out = OutPort.outDefault();
        out.print("token:");
        out.print(token);
        out.println(" [class:" + token.getClass() + "]");
        if (token == Sequence.eofValue)
          break;
      }
      return;
    } catch (Exception ex) {
      System.err.println("caught exception:" + ex); return;
    }
  }
}
