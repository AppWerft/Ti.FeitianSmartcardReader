package kawa.standard;

import gnu.expr.CatchClause;
import gnu.expr.Expression;
import gnu.lists.FVector;
import kawa.lang.Translator;

public class try_catch
{
  public try_catch() {}
  
  public static Expression rewrite(Object try_part, Object clauses)
  {
    Translator tr = (Translator)gnu.expr.Compilation.getCurrent();
    Expression try_part_exp = tr.rewrite(try_part);
    CatchClause prev = null;
    CatchClause chain = null;
    FVector vec = (FVector)clauses;
    int n = vec.size();
    for (int i = 0; i < n; i++)
    {
      Expression cl = SchemeCompilation.lambda.rewrite(vec.get(i), tr);
      if ((cl instanceof gnu.expr.ErrorExp))
        return cl;
      if (!(cl instanceof gnu.expr.LambdaExp))
        return tr.syntaxError("internal error with try-catch");
      CatchClause ccl = new CatchClause((gnu.expr.LambdaExp)cl);
      if (prev == null) {
        chain = ccl;
      } else
        prev.setNext(ccl);
      prev = ccl;
    }
    if ((try_part_exp instanceof gnu.expr.ErrorExp))
      return try_part_exp;
    gnu.expr.TryExp texp = new gnu.expr.TryExp(try_part_exp, null);
    texp.setCatchClauses(chain);
    return texp;
  }
}
