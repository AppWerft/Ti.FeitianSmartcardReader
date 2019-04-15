package kawa.lang;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;





public class Continuation
  extends MethodProc
{
  public boolean invoked;
  static int counter;
  int id;
  
  public Continuation(CallContext ctx) {}
  
  public void apply(CallContext ctx)
  {
    if (invoked) {
      throw new GenericError("implementation restriction: continuation can only be used once");
    }
    throw new CalledContinuation(values, this, ctx);
  }
  

  public static void handleException$X(Throwable ex, Continuation cont, CallContext ctx)
    throws Throwable
  {
    CalledContinuation cex;
    if ((!(ex instanceof CalledContinuation)) || (continuation != cont))
    {
      throw ex; }
    CalledContinuation cex; invoked = true;
    Object[] values = values;
    int nvalues = values.length;
    for (int i = 0; i < nvalues; i++) {
      consumer.writeObject(values[i]);
    }
  }
  
  public static Object handleException(Throwable ex, Continuation cont) throws Throwable
  {
    CalledContinuation cex;
    if ((!(ex instanceof CalledContinuation)) || (continuation != cont))
    {
      throw ex; }
    CalledContinuation cex; invoked = true;
    return Values.make(values);
  }
  
  public final String toString()
  {
    return "#<continuation " + id + (invoked ? " (invoked)>" : ">");
  }
}
