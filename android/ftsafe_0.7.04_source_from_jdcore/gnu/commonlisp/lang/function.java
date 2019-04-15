package gnu.commonlisp.lang;

import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class function extends Syntax
{
  Syntax lambda;
  
  public function(Syntax lambda)
  {
    this.lambda = lambda;
  }
  
  public gnu.expr.Expression rewriteForm(Pair form, Translator tr)
  {
    Object obj = form.getCdr();
    if ((obj instanceof Pair))
    {
      Pair pair = (Pair)obj;
      if (pair.getCdr() != gnu.lists.LList.Empty)
        return tr.syntaxError("too many forms after 'function'");
      Object name = pair.getCar();
      if (((name instanceof String)) || ((name instanceof gnu.mapping.Symbol)))
      {
        gnu.expr.Declaration decl = tr.lookup(name, 2);
        gnu.expr.ReferenceExp rexp = new gnu.expr.ReferenceExp(name, decl);
        rexp.setProcedureName(true);
        rexp.setFlag(2);
        return rexp;
      }
      if ((name instanceof Pair))
      {
        pair = (Pair)name;
        name = pair.getCar();
        if ((name instanceof String) ? "lambda".equals(name) : ((name instanceof gnu.mapping.Symbol)) && ("lambda".equals(((gnu.mapping.Symbol)name).getName())))
        {

          return lambda.rewriteForm(pair, tr); }
      }
    }
    return tr.syntaxError("function must be followed by name or lambda expression");
  }
}
