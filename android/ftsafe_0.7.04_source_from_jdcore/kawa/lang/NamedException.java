package kawa.lang;

import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.io.CharArrayOutPort;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;











public class NamedException
  extends RuntimeException
{
  Symbol name;
  Object[] args;
  static SimpleSymbol miscErrorSymbol = Symbol.valueOf("misc-error");
  
  public NamedException(Symbol name, Object[] args)
  {
    this.name = name;
    this.args = args;
  }
  
  public static NamedException makeError(Object... args) {
    Object[] xargs = new Object[args.length + 1];
    xargs[0] = miscErrorSymbol;
    System.arraycopy(args, 0, xargs, 1, args.length);
    return new NamedException(null, xargs);
  }
  
  public Object applyHandler(Object key, Procedure handler) throws Throwable
  {
    if ((key != name) && (key != Boolean.TRUE))
      throw this;
    return handler.applyN(args);
  }
  
  public Object getObjectMessage() {
    return name == null ? args[1] : name;
  }
  
  public LList getObjectIrritants() {
    return LList.makeList(args, name == null ? 2 : 1);
  }
  
  public String toString() {
    CharArrayOutPort buf = new CharArrayOutPort();
    buf.append("#<ERROR");
    int len = args.length;
    
    int i = name == null ? 1 : 0;
    DisplayFormat format = DisplayFormat.schemeDisplayFormat;
    for (; i < len; i++) {
      buf.append(' ');
      format.format(args[i], buf);
      format = DisplayFormat.schemeWriteFormat;
    }
    buf.append(">");
    return buf.toString();
  }
}
