package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class syntax_error
  extends Syntax
{
  public static final syntax_error syntax_error = new syntax_error();
  static { syntax_error.setName("syntax-error"); }
  
  public Expression rewrite(Object obj, Translator tr)
  {
    CharArrayOutPort buf = new CharArrayOutPort();
    int words = 0;
    DisplayFormat format = DisplayFormat.schemeDisplayFormat;
    while ((obj instanceof Pair))
    {
      Pair pair = (Pair)obj;
      if (words > 0)
        buf.append(' ');
      format.format(Translator.stripSyntax(pair.getCar()), buf);
      format = DisplayFormat.schemeWriteFormat;
      obj = pair.getCdr();
      words++;
    }
    if (obj != LList.Empty)
    {
      if (words > 0)
        buf.append(' ');
      format.format(obj, buf);
    }
    return tr.syntaxError(buf.toString());
  }
  
  public static Expression error(Object form, Object[] message)
  {
    StringBuffer buffer = new StringBuffer();
    int len = message.length;
    if ((message == null) || (len == 0)) {
      buffer.append("invalid syntax");
    }
    else {
      for (int i = 0; i < len; i++)
        buffer.append(message[i]);
    }
    Translator tr = (Translator)Compilation.getCurrent();
    if (tr == null)
      throw new RuntimeException(buffer.toString());
    Object savePos = tr.pushPositionOf(form);
    try
    {
      return tr.syntaxError(buffer.toString());
    }
    finally
    {
      tr.popPositionOf(savePos);
    }
  }
  
  public syntax_error() {}
}
