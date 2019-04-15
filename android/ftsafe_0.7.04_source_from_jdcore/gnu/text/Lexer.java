package gnu.text;

import gnu.kawa.io.InPort;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;




public class Lexer
  extends Reader
{
  protected InPort port;
  private boolean interactive;
  protected boolean tentative;
  protected int nesting;
  
  public Lexer(InPort port)
  {
    this.port = port;
  }
  
  public Lexer(InPort port, SourceMessages messages)
  {
    this.port = port;
    this.messages = messages;
  }
  






  public char pushNesting(char promptChar)
  {
    nesting += 1;
    InPort port = getPort();
    char save = readState;
    readState = promptChar;
    return save;
  }
  



  public void popNesting(char save)
  {
    InPort port = getPort();
    readState = save;
    nesting -= 1;
  }
  
  public final InPort getPort()
  {
    return port;
  }
  
  public void close() throws IOException {
    port.close();
  }
  
  public int read() throws IOException
  {
    return port.read();
  }
  
  @Deprecated
  public int readUnicodeChar()
    throws IOException
  {
    return port.readCodePoint();
  }
  
  public int readCodePoint()
    throws IOException
  {
    return port.readCodePoint();
  }
  
  public int read(char[] buf, int offset, int length)
    throws IOException
  {
    return port.read(buf, offset, length);
  }
  
  public void unread(int ch) throws IOException
  {
    if (ch >= 0) {
      port.unread();
    }
  }
  
  public int peek() throws IOException {
    return port.peek();
  }
  
  public void skip() throws IOException
  {
    port.skip();
  }
  
  protected void unread() throws IOException
  {
    port.unread();
  }
  
  protected void unread_quick() throws IOException
  {
    port.unread_quick();
  }
  






  public boolean checkNext(char ch)
    throws IOException
  {
    int r = port.read();
    if (r == ch)
      return true;
    if (r >= 0)
      port.unread_quick();
    return false;
  }
  
  protected void skip_quick() throws IOException
  {
    port.skip_quick();
  }
  
  SourceMessages messages = null;
  
  public SourceMessages getMessages() { return messages; }
  
  public void setMessages(SourceMessages messages) { this.messages = messages; }
  



  public boolean checkErrors(PrintWriter out, int max)
  {
    return (messages != null) && (messages.checkErrors(out, max));
  }
  
  public SourceError getErrors() {
    return messages == null ? null : messages.getErrors();
  }
  
  public boolean seenErrors() { return (messages != null) && (messages.seenErrors()); }
  
  public void clearErrors() { if (messages != null) messages.clearErrors();
  }
  
  public void error(char severity, String filename, int line, int column, String message)
  {
    if (messages == null)
      messages = new SourceMessages();
    messages.error(severity, filename, line, column, message);
  }
  
  public void error(char severity, String message)
  {
    int line = port.getLineNumber();
    int column = port.getColumnNumber();
    error(severity, port.getName(), line + 1, column >= 0 ? column + 1 : 0, message);
  }
  

  public void error(String message)
  {
    error('e', message);
  }
  
  public void fatal(String message) throws SyntaxException
  {
    error('f', message);
    throw new SyntaxException(messages);
  }
  
  public void eofError(String msg) throws SyntaxException
  {
    fatal(msg);
  }
  
  public void eofError(String message, int startLine, int startColumn)
    throws SyntaxException
  {
    error('f', port.getName(), startLine, startColumn, message);
    throw new SyntaxException(messages);
  }
  





  public int readOptionalExponent()
    throws IOException
  {
    int sign = read();
    boolean overflow = false;
    int c;
    int c; if ((sign == 43) || (sign == 45)) {
      c = read();
    }
    else {
      c = sign;
      sign = 0; }
    int value;
    int value;
    if ((c < 0) || ((value = Character.digit((char)c, 10)) < 0))
    {
      if (sign != 0)
        error("exponent sign not followed by digit");
      value = 1;
    }
    else
    {
      int max = 214748363;
      for (;;)
      {
        c = read();
        int d = Character.digit((char)c, 10);
        if (d < 0)
          break;
        if (value > max)
          overflow = true;
        value = 10 * value + d;
      }
    }
    if (c >= 0)
      unread(c);
    if (sign == 45)
      value = -value;
    if (overflow)
      return sign == 45 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    return value;
  }
  




  public boolean readDelimited(String delimiter)
    throws IOException, SyntaxException
  {
    tokenBufferLength = 0;
    int dlen = delimiter.length();
    char last = delimiter.charAt(dlen - 1);
    for (;;)
    {
      int ch = read();
      if (ch < 0)
        return false;
      int j;
      int dstart;
      if ((ch == last) && ((dstart = tokenBufferLength - (j = dlen - 1)) >= 0))
      {

        do
        {

          if (j == 0)
          {
            tokenBufferLength = dstart;
            return true;
          }
          j--;
        }
        while (tokenBuffer[(dstart + j)] == delimiter.charAt(j));
      }
      tokenBufferAppend((char)ch);
    }
  }
  





  public static long readDigitsInBuffer(InPort port, long ival, int radix)
  {
    int i = pos;
    if (i >= limit) {
      return ival;
    }
    for (;;) {
      char c = buffer[i];
      int dval = Character.digit(c, radix);
      if (dval < 0)
        break;
      if (ival == -2L) {
        ival = dval;
      } else if (ival != -1L)
      {
        if (ival > (Long.MAX_VALUE - dval) / radix) {
          ival = -1L;
        } else
          ival = ival * radix + dval; }
      i++; if (i >= limit)
        break;
    }
    pos = i;
    return ival;
  }
  
  public static long readDigits(InPort port, int radix) throws IOException {
    long ival = -2L;
    for (;;) {
      ival = readDigitsInBuffer(port, ival, radix);
      if (pos >= limit) if (port.peek() < 0)
          break;
    }
    return ival;
  }
  
  public int readIntDigits() throws IOException {
    long lval = readDigits(port, 10);
    int ival = (int)lval;
    if ((ival == -1) || (ival != lval))
      return Integer.MAX_VALUE;
    return ival < 0 ? -1 : ival;
  }
  
  public String getName() { return port.getName(); }
  
  public int getLineNumber()
  {
    return port.getLineNumber();
  }
  
  public int getColumnNumber() { return port.getColumnNumber(); }
  
  public boolean isInteractive() { return interactive; }
  public void setInteractive(boolean v) { interactive = v; }
  


  public boolean isTentative() { return tentative; }
  public void setTentative(boolean v) { tentative = v; }
  

  public char[] tokenBuffer = new char[100];
  

  public int tokenBufferLength = 0;
  

  public void tokenBufferAppend(int ch)
  {
    if (ch >= 65536)
    {
      tokenBufferAppend((ch - 65536 >> 10) + 55296);
      ch = (ch & 0x3FF) + 56320;
    }
    
    int len = tokenBufferLength;
    char[] buffer = tokenBuffer;
    if (len == tokenBuffer.length)
    {
      tokenBuffer = new char[2 * len];
      System.arraycopy(buffer, 0, tokenBuffer, 0, len);
      buffer = tokenBuffer;
    }
    buffer[len] = ((char)ch);
    tokenBufferLength = (len + 1);
  }
  
  public String tokenBufferString()
  {
    return new String(tokenBuffer, 0, tokenBufferLength);
  }
  
  private int saveTokenBufferLength = -1;
  

  public void mark()
    throws IOException
  {
    if (saveTokenBufferLength >= 0)
      throw new Error("internal error: recursive call to mark not allowed");
    port.mark(Integer.MAX_VALUE);
    saveTokenBufferLength = tokenBufferLength;
  }
  

  public void reset()
    throws IOException
  {
    if (saveTokenBufferLength < 0)
      throw new Error("internal error: reset called without prior mark");
    port.reset();
    saveTokenBufferLength = -1;
  }
}
