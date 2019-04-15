package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.lists.Sequence;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SyntaxException;

public class ReaderIgnoreRestOfLine extends ReadTableEntry
{
  public ReaderIgnoreRestOfLine() {}
  
  static ReaderIgnoreRestOfLine instance = new ReaderIgnoreRestOfLine();
  
  public static ReaderIgnoreRestOfLine getInstance() { return instance; }
  
  public boolean checkEncodingSpec = true;
  
  public Object read(Lexer in, int ch, int count) throws java.io.IOException, SyntaxException
  {
    InPort port = in.getPort();
    StringBuilder buf = null;
    if (((port instanceof gnu.kawa.io.BinaryInPort)) && (checkEncodingSpec)) {
      int lineno = port.getLineNumber();
      if ((lineno == 0) || (lineno == 1))
        buf = new StringBuilder();
    }
    do {
      ch = in.read();
      if (ch < 0)
        return Sequence.eofValue;
      if (buf != null)
        buf.append((char)ch);
    } while ((ch != 10) && (ch != 13));
    if (buf != null) {
      ((LispReader)in).checkEncodingSpec(buf.toString());
    }
    in.unread(ch);
    return Values.empty;
  }
}
