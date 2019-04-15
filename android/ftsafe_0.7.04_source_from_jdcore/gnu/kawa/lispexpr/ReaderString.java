package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.text.Lexer;
import gnu.text.SyntaxException;

public class ReaderString extends ReadTableEntry
{
  public ReaderString() {}
  
  public Object read(Lexer in, int ch, int count) throws java.io.IOException, SyntaxException
  {
    return readString(in, ch, count);
  }
  






  public static String readString(Lexer in, int ch, int count)
    throws java.io.IOException, SyntaxException
  {
    int startPos = tokenBufferLength;
    InPort port = in.getPort();
    char saveReadState = '\000';
    int c = ch;
    
    if ((port instanceof InPort))
    {
      saveReadState = readState;
      readState = ((char)ch);
    }
    try
    {
      int t;
      for (;;) {
        int prev = c;
        

        if (prev == 13)
        {
          c = port.read();
          if (c != 10) {}

        }
        else if ((pos < limit) && (prev != 10)) {
          c = buffer[(pos++)];
        } else {
          c = port.read(); }
        if (c == ch) {
          break;
        }
        
        switch (c)
        {
        case 13: 
          int t;
          if (port.getConvertCR()) {
            t = 10;
          }
          else {
            t = 13;
            
            c = 32;
          }
          in.tokenBufferAppend(t);
          break;
        case 92: 
          if ((in instanceof LispReader)) {
            c = ((LispReader)in).readEscape();
          } else
            c = port.read();
          if (c == -2)
          {
            c = 10; }
          break;
        

        default: 
          if (c < 0)
            in.eofError("unexpected EOF in string literal");
          in.tokenBufferAppend(c);
        }
        
      }
      
      return new String(tokenBuffer, startPos, tokenBufferLength - startPos).intern();



    }
    finally
    {


      tokenBufferLength = startPos;
      if ((port instanceof InPort)) {
        readState = saveReadState;
      }
    }
  }
}
