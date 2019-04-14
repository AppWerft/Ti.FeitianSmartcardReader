package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;





public class ReaderTypespec
  extends ReaderConstituent
{
  public ReaderTypespec()
  {
    super(6);
  }
  
  public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException
  {
    if (!(in instanceof LispReader))
      return super.read(in, ch, count);
    int endChar = ch == 60 ? 62 : -2;
    LispReader reader = (LispReader)in;
    int startPos = tokenBufferLength;
    InPort port = in.getPort();
    ReadTable rtable = ReadTable.getCurrent();
    char saveReadState = '\000';
    in.tokenBufferAppend(ch);
    int c = ch;
    
    if ((port instanceof InPort))
    {
      saveReadState = readState;
      readState = ((char)ch);
    }
    try
    {
      boolean got_open_square = false;
      

      for (;;)
      {
        int prev = c;
        
        if ((pos < limit) && (prev != 10)) {
          c = buffer[(pos++)];
        } else
          c = port.read();
        if (c == 92)
        {
          in.tokenBufferAppend(65535);
          seenEscapes = true;
        } else {
          if ((c == endChar) && (!got_open_square))
          {
            reader.readToken(62, rtable);
            
            break label271;
          }
          
          int kind;
          if (((got_open_square) || (c != 91) || (1 != (got_open_square = 1))) && ((!got_open_square) || (c != 93) || (0 != (got_open_square = 0))) && ((kind = rtable.lookup(c).getKind()) != 2) && (kind != 6)) {
            break;
          }
          




          in.tokenBufferAppend(c);
        }
      }
      
      int kind;
      in.unread(c);
      

      label271:
      
      return reader.handleToken(startPos, rtable);
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
