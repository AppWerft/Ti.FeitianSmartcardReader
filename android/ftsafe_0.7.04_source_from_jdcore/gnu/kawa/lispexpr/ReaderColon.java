package gnu.kawa.lispexpr;

import gnu.text.Lexer;

public class ReaderColon extends ReadTableEntry
{
  public ReaderColon() {}
  
  public int getKind() {
    return 6;
  }
  
  public Object read(Lexer in, int ch, int count) throws java.io.IOException, gnu.text.SyntaxException
  {
    LispReader reader = (LispReader)in;
    ReadTable rtable = ReadTable.getCurrent();
    int startPos = tokenBufferLength;
    if (ch == postfixLookupOperator)
    {
      int next = reader.read();
      if (next == 58) {
        return rtable.makeSymbol("::");
      }
      reader.tokenBufferAppend(ch);
      ch = next;
    }
    return reader.readAndHandleToken(ch, startPos, rtable);
  }
}
