package kawa.lib;

import gnu.expr.Expression;

public abstract class ScanHelper { public abstract void init(Expression paramExpression);
  
  public abstract Expression test();
  
  public abstract gnu.expr.Declaration eval();
  
  public Expression incr(gnu.expr.Declaration value) { return gnu.expr.QuoteExp.voidExp; }
  
  public gnu.expr.Compilation comp;
  public ScanHelper() {}
}
