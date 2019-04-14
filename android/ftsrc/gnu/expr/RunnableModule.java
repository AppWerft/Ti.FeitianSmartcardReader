package gnu.expr;

import gnu.mapping.CallContext;

public abstract interface RunnableModule
{
  public abstract void run(CallContext paramCallContext)
    throws Throwable;
}
