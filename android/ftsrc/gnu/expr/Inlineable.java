package gnu.expr;

public abstract interface Inlineable
{
  public abstract void compile(ApplyExp paramApplyExp, Compilation paramCompilation, Target paramTarget);
}
