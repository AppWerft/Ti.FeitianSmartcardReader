package kawa.lib;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.kawa.functions.Convert;
import gnu.kawa.reflect.Invoke;
import kawa.lib.kawa.expressions;


















































































































































public class IterableScanner
  extends ScanHelper
{
  public boolean useGeneric;
  public Declaration iteratorDecl;
  
  private void $finit$() { useGeneric = true; }
  
  public void init(Expression arg) {
    Expression seqArg = expressions.visitExp(arg);
    if (useGeneric)
    {

      iteratorDecl = comp.letVariable(null, null, expressions.applyExp$V(Invoke.invokeStatic, new Object[] { compile_map.Lit11, compile_map.Lit12, seqArg }));
    }
    else {
      expressions.applyExp$V(Convert.as, new Object[] { compile_map.Lit3, seqArg });
      
      iteratorDecl = comp.letVariable(null, compile_map.Lit13, expressions.applyExp$V(Invoke.invoke, new Object[] { seqArg, compile_map.Lit14 })); }
    iteratorDecl.setLocation(arg); }
  
  public Expression test() { return expressions.applyExp$V(Invoke.invoke, new Object[] { iteratorDecl, compile_map.Lit15 }); }
  
  public Declaration eval() {
    return comp.letVariable(null, null, expressions.applyExp$V(Invoke.invoke, new Object[] { iteratorDecl, compile_map.Lit16 }));
  }
  
  public IterableScanner()
  {
    $finit$();
  }
}
