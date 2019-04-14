package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.LambdaExp;
import kawa.lang.Translator;

public class thisRef extends kawa.lang.Syntax
{
  public static final thisRef thisSyntax = new thisRef();
  static { thisSyntax.setName("this"); }
  
  public gnu.expr.Expression rewriteForm(gnu.lists.Pair form, Translator tr)
  {
    if (form.getCdr() == gnu.lists.LList.Empty)
    {
      LambdaExp method = curMethodLambda;
      Declaration firstParam = method == null ? null : method.firstDecl();
      if ((firstParam == null) || (!firstParam.isThisParameter()))
      {
        firstParam = null;
        if ((method == null) || (nameDecl == null)) {
          tr.error('e', "use of 'this' not in a named method");
        } else if (nameDecl.isStatic()) {
          tr.error('e', "use of 'this' in a static method");
        }
        else {
          firstParam = new Declaration(gnu.expr.ThisExp.THIS_NAME);
          method.add(null, firstParam);
          nameDecl.setFlag(4096L);
        }
      }
      return new gnu.expr.ThisExp(firstParam);
    }
    
    return tr.syntaxError("this with parameter not implemented");
  }
  
  public thisRef() {}
}
