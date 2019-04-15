package gnu.kawa.lispexpr;

import gnu.expr.Special;
import gnu.kawa.io.InPort;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

public class ReaderExtendedLiteral extends ReaderConstituent
{
  static final Symbol qstringSymbol = Symbol.valueOf("$string$");
  static final Symbol formatSymbol = Symbol.valueOf("$format$");
  static final Symbol sprintfSymbol = Symbol.valueOf("$sprintf$");
  static final Symbol startEnclosedSymbol = Symbol.valueOf("$<<$");
  static final Symbol endEnclosedSymbol = Symbol.valueOf("$>>$");
  
  public ReaderExtendedLiteral() { super(2); }
  
  public Object read(Lexer in, int ch, int count) throws IOException, SyntaxException
  {
    LispReader reader = (LispReader)in;
    int startPos = tokenBufferLength;
    ReadTable rtable = ReadTable.getCurrent();
    int startLine = reader.getLineNumber() + 1;
    int startColumn = reader.getColumnNumber() - 2;
    in.tokenBufferAppend(ch);
    int next = reader.read();
    next = scanTag(reader, next);
    Object result;
    Object result; if ((next == 123) || (next == 91)) {
      int len = tokenBufferLength - startPos - 1;
      String tag = len == 0 ? null : new String(tokenBuffer, startPos + 1, len);
      
      tokenBufferLength = startPos;
      result = readNamedLiteral(reader, rtable, tag, next, startLine, startColumn);
    } else {
      result = reader.readAndHandleToken(next, startPos, rtable);
    }
    return result;
  }
  
  protected int enclosedExprDelim(int ch, LispReader reader) {
    return ch == 91 ? 93 : -1;
  }
  

  public Object readNamedLiteral(LispReader reader, ReadTable rtable, String tag, int next, int startLine, int startColumn)
    throws IOException, SyntaxException
  {
    Object operator = tag == null ? qstringSymbol : LispLanguage.constructNamespace.getSymbol(tag);
    
    Pair result = gnu.lists.PairWithPosition.make(operator, null, reader.getName(), startLine, startColumn);
    

    Pair rtail = result;
    int endDelimiter = enclosedExprDelim(next, reader);
    if ((endDelimiter >= 0) && (tag != null)) {
      int line = reader.getLineNumber() + 1;
      int column = reader.getColumnNumber();
      rtail = readEnclosed(reader, rtable, rtail, next, endDelimiter);
      Pair endMarker = reader.makePair(endEnclosedSymbol, LList.Empty, reader.getLineNumber() + 1, reader.getColumnNumber());
      

      rtail.setCdrBackdoor(endMarker);
      rtail = endMarker;
      next = reader.read();
    }
    if (next == 123) {
      readContent(reader, '}', rtail);
    }
    else if (tag == null) {
      reader.error("unexpected character after &");
    } else
      reader.unread(next);
    return result;
  }
  
  protected Object checkDelim(LispReader reader, int next, int delimiter) throws IOException, SyntaxException
  {
    return (next == delimiter) || (next < 0) ? Special.eof : null;
  }
  
  protected boolean isNestableStartDelim(int next) {
    return next == 123;
  }
  
  protected boolean isNestableEndDelim(int next) {
    return next == 125;
  }
  
  public Pair readContent(LispReader reader, char delimiter, Pair head) throws IOException, SyntaxException
  {
    Pair resultTail = head;
    tokenBufferLength = 0;
    int braceNesting = 1;
    




    int lineStart = -1;
    int nonSpace = -1;
    for (;;) {
      Object item = null;
      int line = reader.getLineNumber() + 1;
      int column = reader.getColumnNumber();
      int next = reader.readCodePoint();
      if ((next == 13) || (next == 10))
      {


        if ((lineStart < 0) && (nonSpace < 0)) {
          lineStart = 0;
        } else
          lineStart = tokenBufferLength + 1;
        nonSpace = -1;
      }
      else if ((nonSpace < 0) && (next != 32) && (next != 9)) {
        nonSpace = tokenBufferLength;
      }
      if (next < 0) {
        reader.error("unexpected end-of-file");
        item = Special.eof;
      } else {
        if (next == delimiter) if (isNestableEndDelim(next)) { braceNesting--; if (braceNesting != 0) {}
          }
          else {
            item = Special.eof;
            break label481; } if (next == 38) {
          int next1 = reader.peek();
          if (next1 == 124) {
            int skipped = 0;
            int blen = tokenBufferLength;
            if (lineStart < 0) {
              reader.error('e', reader.getName(), line, column + 1, "invalid '&|'");

            }
            else if (nonSpace != tokenBufferLength) {
              reader.error('e', reader.getName(), line, nonSpace - lineStart + 1, "non-whitespace before '&|'");

            }
            else
            {

              tokenBufferLength = lineStart; }
            reader.skip();
            continue; }
          if (next1 == 45) {
            reader.skip();
            boolean complained = false;
            for (;;) {
              next = reader.read();
              if ((next == 13) || (next == 10))
                break;
              if ((!complained) && (next != 32) && (next != 9)) {
                reader.error('e', reader.getName(), reader.getLineNumber() + 1, reader.getColumnNumber(), "non-whitespace after '&-'");
                


                complained = true;
              }
            }
            lineStart = tokenBufferLength;
            nonSpace = -1;
            continue; }
          if (next1 == 35) {
            reader.skip();
            next = reader.read();
            if (next == 124) {
              ReaderNestedComment.getLispInstance().readNestedComment(reader);
            }
            else
              readCharRef(reader, next);
          }
        } else {
          if (isNestableStartDelim(next))
            braceNesting++;
          reader.tokenBufferAppend(next);
          if ((next == 93) && (delimiter == '<') && 
            (reader.peek() == 93)) {
            reader.skip();
            reader.tokenBufferAppend(93);
            if (reader.peek() == 62) {
              reader.error('w', reader.getName(), line, column + 1, "literal ']]>' is only valid following '<![CDATA['");
            }
          }
          

          next = 32; } }
      label481:
      if ((tokenBufferLength > 0) && ((next == delimiter) || (next == 38) || (next < 0)))
      {
        String text = reader.tokenBufferString();
        tokenBufferLength = 0;
        Object tnode = wrapText(text);
        Pair pair = gnu.lists.PairWithPosition.make(tnode, reader.makeNil(), null, -1, -1);
        
        resultTail.setCdrBackdoor(pair);
        resultTail = pair;
      }
      if (next == 38) {
        ReadTable rtable = ReadTable.getCurrent();
        next = reader.read();
        int endDelimiter = enclosedExprDelim(next, reader);
        if ((endDelimiter >= 0) || (next == 40)) {
          Pair qq = reader.makePair(startEnclosedSymbol, LList.Empty, line, column);
          

          resultTail.setCdrBackdoor(qq);
          resultTail = qq;
          resultTail = readEnclosed(reader, rtable, resultTail, next, endDelimiter);
          item = endEnclosedSymbol;
        }
        else if ((next == 126) || (next == 37)) {
          boolean sawQuote = false;
          boolean printfStyle = next == 37;
          
          int magic = next;
          do {
            do { for (;;) { reader.tokenBufferAppend(next);
                next = reader.read();
                if ((next < 0) || (next == 10)) {
                  reader.error('e', "non-terminated format specifier");
                  boolean needEnclosed = false;
                  break label896;
                }
                if (sawQuote) {
                  sawQuote = false;
                } else { if ((next != 39) || (magic != 126)) break;
                  sawQuote = true;
                }
              }
            } while (((next >= 48) && (next <= 57)) || (next == 43) || (next == 45) || (next == 32) || (printfStyle ? (next == 46) && (next == 42) : (next == 44) || (next == 35) || (next == 118) || (next == 86) || (next == 58) || (next == 64)));
            








            reader.tokenBufferAppend(next);
            next = reader.read();
            if ((next == 91) || (next == 40)) {
              boolean needEnclosed = true;
              break;
            } } while (next == magic);
          reader.unread(next);
          boolean needEnclosed = false;
          

          label896:
          

          String fmt = reader.tokenBufferString();
          endDelimiter = enclosedExprDelim(next, reader);
          tokenBufferLength = 0;
          Pair ffmt = reader.makePair(fmt, LList.Empty, line, column);
          Object fun = printfStyle ? sprintfSymbol : formatSymbol;
          Pair fhead = reader.makePair(fun, ffmt, line, column);
          
          if (needEnclosed)
            readEnclosed(reader, rtable, ffmt, next, endDelimiter);
          item = fhead;
        }
        else {
          int startPos = tokenBufferLength;
          next = scanTag(reader, next);
          String str = new String(tokenBuffer, startPos, tokenBufferLength - startPos);
          
          tokenBufferLength = startPos;
          reader.unread(next);
          if ((next == 91) || (next == 123)) {
            item = readNamedLiteral(reader, rtable, str, reader.read(), line, column);
          }
          else if (next == 59) {
            item = checkEntity(reader, str);
          } else {
            reader.error('e', "expected '[', '{', or ';'");
          }
        }
      }
      else {
        item = checkDelim(reader, next, delimiter);
      }
      if (item == Special.eof)
        break;
      if (item != null) {
        Pair pair = gnu.lists.PairWithPosition.make(item, reader.makeNil(), reader.getName(), line, column + 1);
        

        resultTail.setCdrBackdoor(pair);
        resultTail = pair;
      }
    }
    return resultTail;
  }
  
  protected Object wrapText(String text) {
    return text;
  }
  
  protected Object readEnclosedSingleExpression(LispReader reader, ReadTable readTable, int ch) throws IOException, SyntaxException
  {
    if (ch == 40) {
      reader.unread(ch);
      return reader.readObject();
    }
    int endDelimiter = enclosedExprDelim(ch, reader);
    Pair head = new Pair(null, LList.Empty);
    int line = reader.getLineNumber() + 1;
    int column = reader.getColumnNumber() + 1;
    Pair tail = readEnclosedExpressions(reader, readTable, head, endDelimiter);
    if (head == tail) {
      reader.error('e', reader.getName(), line, column, "missing expression");
      
      return "<missing>";
    }
    Pair first = (Pair)head.getCdr();
    if (first.getCdr() != LList.Empty) {
      reader.error('e', reader.getName(), line, column, "too many expressions");
    }
    return first.getCar();
  }
  
  protected Pair readEnclosed(LispReader reader, ReadTable readTable, Pair last, int startDelimiter, int endDelimiter)
    throws IOException, SyntaxException
  {
    if (startDelimiter == 40) {
      return reader.readValuesAndAppend(40, readTable, last);
    }
    return readEnclosedExpressions(reader, readTable, last, endDelimiter);
  }
  




  protected Pair readEnclosedExpressions(LispReader reader, ReadTable readTable, Pair last, int endDelimiter)
    throws IOException, SyntaxException
  {
    InPort port = reader.getPort();
    char saveReadState = reader.pushNesting('[');
    int startLine = port.getLineNumber();
    int startColumn = port.getColumnNumber();
    try {
      int line;
      for (;;) { line = port.getLineNumber();
        int column = port.getColumnNumber();
        int ch = port.read();
        if (ch == endDelimiter)
          break;
        if (ch < 0) {
          reader.eofError("unexpected EOF in list starting here", startLine + 1, startColumn);
        }
        last = reader.readValuesAndAppend(ch, readTable, last);
      }
      return last;
    }
    finally
    {
      reader.popNesting(saveReadState);
    }
  }
  
  private int scanTag(LispReader reader, int next) throws IOException, SyntaxException
  {
    if (gnu.xml.XName.isNameStart(next)) {
      do {
        reader.tokenBufferAppend(next);
        next = reader.read();
      } while (gnu.xml.XName.isNamePart(next));


    }
    else if ((next == 96) || (next == 60) || (next == 62)) {
      int nextnext = reader.peek();
      if ((next == 62) && (nextnext == 62)) {
        reader.tokenBufferAppend(next);
        reader.skip();
        nextnext = reader.peek();
      }
      if ((nextnext == 123) || (nextnext == 91)) {
        reader.tokenBufferAppend(next);
        next = reader.read();
      }
    }
    return next;
  }
  
  Object checkEntity(LispReader reader, String str) throws IOException, SyntaxException
  {
    int next = reader.read();
    if (next != 59) {
      reader.unread(next);
      reader.error("invalid entity reference");
    }
    return LispLanguage.entityNamespace.getSymbol(str);
  }
  
  void readCharRef(LispReader reader, int next)
    throws IOException, SyntaxException
  {
    int base;
    if (next == 120) {
      int base = 16;
      next = reader.read();
    } else {
      base = 10; }
    int value = 0;
    while (next >= 0) {
      char ch = (char)next;
      int digit = Character.digit(ch, base);
      if (digit < 0)
        break;
      if (value >= 134217728)
        break;
      value *= base;
      value += digit;
      next = reader.read();
    }
    if (next != 59) {
      reader.unread(next);
      reader.error("invalid character reference");

    }
    else if (((value > 0) && (value <= 55295)) || ((value >= 57344) && (value <= 65533)) || ((value >= 65536) && (value <= 1114111)))
    {

      reader.tokenBufferAppend(value);
    }
    else {
      reader.error("invalid character value " + value);
    }
  }
}
