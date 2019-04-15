package gnu.commonlisp.lang;

import gnu.lists.Pair;

public class UnwindProtect extends kawa.lang.Syntax
{
  public UnwindProtect() {}
  
  public gnu.expr.Expression rewrite(Object obj, kawa.lang.Translator tr)
  {
    if (!(obj instanceof Pair))
      return tr.syntaxError("invalid syntax for unwind-protect");
    Pair pair = (Pair)obj;
    return new gnu.expr.TryExp(tr.rewrite(pair.getCar()), tr.rewrite_body(pair.getCdr()));
  }
}
