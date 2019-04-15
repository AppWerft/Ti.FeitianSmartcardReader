package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderVector
  extends ReadTableEntry
{
  char close;
  
  public ReaderVector(char close)
  {
    this.close = close;
  }
  
  public Object read(Lexer in, int ch, int count, int sharingIndex)
    throws IOException, SyntaxException
  {
    return readVector((LispReader)in, in.getPort(), count, close, sharingIndex);
  }
  
  public static FVector readVector(LispReader lexer, InPort port, int count, char close, int sharingIndex)
    throws IOException, SyntaxException
  {
    char saveReadState = ' ';
    if ((port instanceof InPort))
    {
      saveReadState = readState;
      readState = (close == ']' ? '[' : '(');
    }
    int startLine = port.getLineNumber();
    int startColumn = port.getColumnNumber() - 1;
    try
    {
      FVector result = new FVector();
      lexer.bindSharedObject(sharingIndex, result);
      
      ReadTable rtable = ReadTable.getCurrent();
      Pair head = new Pair(null, LList.Empty);
      Pair last = head;
      int ch;
      for (;;) {
        ch = lexer.read();
        if (ch < 0) {
          lexer.eofError("unexpected EOF in vector starting here", startLine + 1, startColumn);
        }
        if (ch == close)
          break;
        last = lexer.readValuesAndAppend(ch, rtable, last);
      }
      result.replaceAll(((LList)head.getCdr()).toArray());
      result.setReadOnly();
      return result;

    }
    finally
    {
      if ((port instanceof InPort)) {
        readState = saveReadState;
      }
    }
  }
}
