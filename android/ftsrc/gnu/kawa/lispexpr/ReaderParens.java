package gnu.kawa.lispexpr;

import gnu.kawa.io.InPort;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public final class ReaderParens extends ReadTableEntry
{
  char open;
  char close;
  int kind;
  Object command;
  private static ReaderParens instance;
  
  public int getKind()
  {
    return kind;
  }
  


  public static ReaderParens getInstance(char open, char close)
  {
    return getInstance(open, close, 5);
  }
  
  public static ReaderParens getInstance(char open, char close, int kind)
  {
    if ((open == '(') && (close == ')') && (kind == 5))
    {
      if (instance == null)
        instance = new ReaderParens(open, close, kind, null);
      return instance;
    }
    

    return new ReaderParens(open, close, kind, null);
  }
  

  public static ReaderParens getInstance(char open, char close, int kind, Object command)
  {
    if (command == null) {
      return getInstance(open, close, kind);
    }
    return new ReaderParens(open, close, kind, command);
  }
  
  public ReaderParens(char open, char close, int kind, Object command)
  {
    this.open = open;
    this.close = close;
    this.kind = kind;
    this.command = command;
  }
  



  public Object read(Lexer in, int ch, int count, int sharingIndex)
    throws IOException, SyntaxException
  {
    Object p = null;
    if (command != null)
    {
      InPort port = in.getPort();
      int startLine = port.getLineNumber();
      int startColumn = port.getColumnNumber();
      


      p = ((LispReader)in).makePair(command, startLine, startColumn - 1);
      ((LispReader)in).bindSharedObject(sharingIndex, p);
      sharingIndex = -1;
    }
    
    return readList((LispReader)in, p, ch, count, close, sharingIndex);
  }
  

  public static Object readList(LispReader lexer, Object last, int ch, int count, int close, int sharingIndex)
    throws IOException, SyntaxException
  {
    InPort port = lexer.getPort();
    char saveReadState = lexer.pushNesting(close == 93 ? '[' : '(');
    int startLine = port.getLineNumber();
    int startColumn = port.getColumnNumber();
    try
    {
      Object list = last == null ? lexer.makeNil() : last;
      boolean sawDot = false;
      boolean sawDotCdr = false;
      ReadTable readTable = ReadTable.getCurrent();
      int line;
      for (;;) {
        line = port.getLineNumber();
        int column = port.getColumnNumber();
        ch = port.read();
        if (ch == close)
          break;
        if (ch < 0) {
          if (lexer.isTentative()) {
            Object value = gnu.lists.Pair.incompleteListMarker;
            if (last == null) {
              list = value;
            } else
              lexer.setCdr(last, value);
            return list;
          }
          lexer.eofError("unexpected EOF in list starting here", startLine + 1, startColumn);
        }
        
        ReadTableEntry entry;
        if (ch == 46)
        {
          ch = port.peek();
          ReadTableEntry entry = readTable.lookup(ch);
          int kind = entry.getKind();
          if ((kind == 1) || (kind == 5) || (kind == 0))
          {


            port.skip();
            column++;
            if (ch == close)
            {
              lexer.error("unexpected '" + (char)close + "' after '.'");
              
              break;
            }
            if (ch < 0) {
              lexer.eofError("unexpected EOF in list starting here", startLine + 1, startColumn);
            }
            if (sawDot)
            {
              lexer.error("multiple '.' in list");
              sawDotCdr = false;
              list = lexer.makeNil();
              last = null;
            }
            sawDot = true;

          }
          else
          {
            ch = 46;
            entry = ReadTableEntry.getConstituentInstance();
          }
        }
        else {
          entry = readTable.lookup(ch); }
        Object first = null;
        if ((!sawDot) && (last == null))
        {
          first = lexer.makePair(null, startLine, startColumn - 1);
          lexer.bindSharedObject(sharingIndex, first);
        }
        Object value = lexer.readValues(ch, entry, readTable, -1);
        if (value != gnu.mapping.Values.empty)
        {
          value = lexer.handlePostfix(value, readTable, line, column);
          





          if (sawDotCdr)
          {
            lexer.error("multiple values after '.'");
            last = null;
            list = lexer.makeNil();
            sawDotCdr = false;
          }
          else {
            if (sawDot)
            {
              sawDotCdr = true;


            }
            else if (last == null)
            {
              lexer.setCar(first, value);
              value = first;
              sharingIndex = -1;
            }
            else {
              value = lexer.makePair(value, line, column);
            }
            if (last == null) {
              list = value;
            } else
              lexer.setCdr(last, value);
            last = value;
          } } }
      if ((sawDot) && (!sawDotCdr))
        lexer.error("missing value after '.'");
      return lexer.bindSharedObject(sharingIndex, list);
    }
    finally
    {
      lexer.popNesting(saveReadState);
    }
  }
}
