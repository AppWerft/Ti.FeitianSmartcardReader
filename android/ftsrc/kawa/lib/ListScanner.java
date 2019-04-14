package kawa.lib;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import kawa.lib.kawa.expressions;
import kawa.standard.Scheme;






































































































































































public class ListScanner
  extends ScanHelper
{
  public Declaration listDecl;
  public Declaration pairDecl;
  
  public void init(Expression arg)
  {
    Expression listArg = expressions.visitExp(arg);
    listDecl = comp.letVariable(null, null, listArg);
    listDecl.setLocation(arg); }
  
  public Expression test() { return expressions.applyExp$V(Scheme.not, new Object[] { expressions.applyExp$V(Scheme.isEq, new Object[] { listDecl, LList.Empty }) }); }
  
  public Declaration eval() {
    Declaration pDecl = comp.letVariable(null, null, expressions.applyExp$V(Convert.cast, new Object[] { compile_map.Lit17, listDecl }));
    
    pairDecl = pDecl;
    
    return comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[] { pDecl, compile_map.Lit18 }));
  }
  
  public Expression incr(Declaration value) { return expressions.setExp(listDecl, expressions.applyExp$V(Invoke.invoke, new Object[] { pairDecl, compile_map.Lit19 })); }
  
  public ListScanner() {}
}
