package gnu.q2.lang;

import gnu.kawa.io.InPort;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.SyntaxException;

public class Q2Read extends gnu.kawa.lispexpr.LispReader
{
  int curIndentation;
  boolean resetNeeded;
  String expressionStartFile;
  int expressionStartLine;
  int expressionStartColumn;
  
  void init()
  {
    port.readState = ' ';
  }
  
  public Q2Read(InPort port)
  {
    super(port);
    init();
  }
  
  public Q2Read(InPort port, gnu.text.SourceMessages messages)
  {
    super(port, messages);
    init();
  }
  



  int skipIndentation()
    throws java.io.IOException, SyntaxException
  {
    int numTabs = 0;int numSpaces = 0;
    int ch = port.read();
    while (ch == 9)
    {
      numTabs++;
      ch = port.read();
    }
    while (ch == 32)
    {
      numSpaces++;
      ch = port.read();
    }
    if (ch < 0)
      return -1;
    port.unread();
    return (numTabs << 16) + numSpaces;
  }
  












  Object readIndentCommand(boolean singleLine)
    throws java.io.IOException, SyntaxException
  {
    int startIndentation = curIndentation;
    LList rresult = LList.Empty;
    Object obj = LList.Empty;
    gnu.lists.PairWithPosition pair = null;gnu.lists.PairWithPosition last = null;
    Object prev = null;
    gnu.kawa.lispexpr.ReadTable rtable = gnu.kawa.lispexpr.ReadTable.getCurrent();
    
    for (;;)
    {
      int ch = read();
      if (ch < 0)
        break;
      if ((ch != 32) && (ch != 9))
      {
        unread();
        if (ch == 41)
          break;
        if ((ch == 13) || (ch == 10))
        {
          Operator rhsNeeded = null;
          if (singleLine)
          {
            if ((!(prev instanceof gnu.mapping.Symbol)) || (Q2.instance.selfEvaluatingSymbol(prev)))
              break;
            gnu.expr.Compilation comp = gnu.expr.Compilation.getCurrent();
            gnu.expr.Expression func = ((kawa.lang.Translator)comp).rewrite(prev, true);
            gnu.expr.Declaration decl;
            Object value;
            if ((!(func instanceof gnu.expr.ReferenceExp)) || ((decl = ((gnu.expr.ReferenceExp)func).getBinding()) == null) || (!((value = decl.getConstantValue()) instanceof Operator)) || ((flags & 0x2) == 0)) {
              break;
            }
            

            rhsNeeded = (Operator)value;
          }
          




          ch = read();
          port.mark(Integer.MAX_VALUE);
          resetNeeded = true;
          int subIndentation = skipIndentation();
          if ((subIndentation == -1) && (rhsNeeded != null))
            eofError("missing right operand after " + rhsNeeded.getName());
          LList qresult = LList.Empty;
          curIndentation = subIndentation;
          

          while (curIndentation != -1)
          {
            if (subIndentation != curIndentation) {
              break;
            }
            
            int comparedIndent = Q2.compareIndentation(subIndentation, startIndentation);
            if (comparedIndent == Integer.MIN_VALUE)
            {
              error('e', "cannot compare indentation - mix of tabs and spaces");
              break;
            }
            if ((comparedIndent == -1) || (comparedIndent == 1))
            {
              error('e', "indentation must differ by 2 or more");
            } else {
              if (comparedIndent <= 0) {
                break;
              }
            }
            

            int line = port.getLineNumber();
            int column = port.getColumnNumber();
            Object val = readIndentCommand(false);
            if (val == LList.Empty)
              break;
            qresult = makePair(val, qresult, line, column);
          }
          if (qresult != LList.Empty)
          {
            qresult = new Pair(kawa.standard.begin.begin, LList.reverseInPlace(qresult));
            
            rresult = new Pair(qresult, rresult);
          }
          prev = qresult;
          break;
        }
        int line = port.getLineNumber();
        int column = port.getColumnNumber();
        ch = port.read();
        if (ch < 0)
          break;
        Object val = readValues(ch, rtable, -1);
        prev = val;
        if (val != gnu.mapping.Values.empty) {
          val = handlePostfix(val, rtable, line, column);
          rresult = makePair(val, rresult, line, column);
        }
      } }
    return makeCommand(LList.reverseInPlace(rresult));
  }
  
  Object makeCommand(Object command)
  {
    return command;
  }
  
  boolean singleLine()
  {
    return (isInteractive()) && (nesting <= 1);
  }
  
  public Object readCommand()
    throws java.io.IOException, SyntaxException
  {
    int indent = skipIndentation();
    if (indent < 0)
      return gnu.lists.Sequence.eofValue;
    curIndentation = indent;
    char saveReadState = pushNesting('-');
    try
    {
      Object result = readIndentCommand(singleLine());
      int column; if (resetNeeded)
      {
        resetNeeded = false;
        int line = port.getLineNumber();
        column = port.getColumnNumber();
        port.reset(); }
      Pair presult;
      if ((result instanceof Pair))
      {
        presult = (Pair)result;
        if ((presult.getCdr() == LList.Empty) && (presult.getCar() == gnu.expr.Special.eof))
        {
          return gnu.expr.Special.eof; }
      }
      return result;
    }
    finally
    {
      popNesting(saveReadState);
    }
  }
  























































































































































































  public static Object readObject(InPort port)
    throws java.io.IOException, SyntaxException
  {
    return new Q2Read(port).readObject();
  }
  





  void saveExpressionStartPosition()
  {
    expressionStartFile = port.getName();
    expressionStartLine = port.getLineNumber();
    expressionStartColumn = port.getColumnNumber();
  }
  
  static class ReadTableEntry extends gnu.kawa.lispexpr.ReaderDispatchMisc
  {
    ReadTableEntry() {}
    
    public Object read(gnu.text.Lexer in, int ch, int count) throws java.io.IOException, SyntaxException {
      switch (ch) {
      case 40: 
        return readParens(in);
      case 59:  return gnu.mapping.Symbol.valueOf(";"); }
      throw new Error();
    }
    

    public Object readParens(gnu.text.Lexer in)
      throws java.io.IOException, SyntaxException
    {
      Q2Read reader = (Q2Read)in;
      char saveReadState = reader.pushNesting('(');
      int startLine = reader.getLineNumber();
      int startColumn = reader.getColumnNumber();
      try
      {
        Object result = reader.readIndentCommand(false);
        InPort port = reader.getPort();
        int ch = port.peek();
        String msg; if (ch == 41) {
          port.skip();
        } else {
          msg = "missing ')' after '(' starting here";
          if (ch < 0) {
            reader.eofError(msg, startLine + 1, startColumn);
          } else {
            reader.error('e', port.getName(), startLine + 1, startColumn, msg);
          }
        }
        if (resetNeeded)
        {
          resetNeeded = false;
          port.mark(0);
        }
        return reader.makeCommand(result);
      }
      finally
      {
        reader.popNesting(saveReadState);
      }
    }
  }
}
