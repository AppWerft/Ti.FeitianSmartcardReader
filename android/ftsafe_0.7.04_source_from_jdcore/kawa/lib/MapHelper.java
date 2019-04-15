package kawa.lib;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.kawa.functions.MakeSplice;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import kawa.lib.kawa.expressions;














public abstract class MapHelper
{
  public Compilation comp;
  public ScanHelper[] scanners;
  
  public abstract ScanHelper makeScanner(Expression paramExpression, Type paramType);
  
  public void initialize(ApplyExp paramApplyExp, Compilation paramCompilation) {}
  
  public Expression applyFunction(Object func, Object args)
  {
    int i = 1;Object localObject = args; int j; i = (j = MakeSplice.count(localObject)) + i;int k = 1;MakeSplice.copyTo(new Object[] { func }, k, j, localObject);k += j;return (Expression)Promise.force(expressions.apply$Mnto$Mnargs$Mnexp.applyN(tmp27_23), Expression.class); }
  
  public Expression doCollect(Expression result) { return result; }
  
  public Expression collectResult(Expression result) { return result; }
  
  public MapHelper() {}
}
