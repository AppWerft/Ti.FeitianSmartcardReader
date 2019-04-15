package kawa.lib;

import gnu.kawa.util.ExitCalled;
import gnu.mapping.Procedure;
import kawa.lang.CalledContinuation;


public class HandlerLink
{
  public Procedure handlerProc;
  public HandlerLink outer;
  
  public static HandlerLink push(Procedure handler)
  {
    void tmp7_4 = new HandlerLink();74handlerProc = handler; void tmp12_7 = tmp7_4;
    127outer = ((HandlerLink)ExceptionClasses.current$Mnhandler.get());HandlerLink new = tmp12_7;
    ExceptionClasses.current$Mnhandler.set(new);
    return new; }
  
  public void pop() { ExceptionClasses.current$Mnhandler.set(outer); }
  
  public Throwable handle(Throwable ex) { ExceptionClasses.current$Mnhandler.set(outer);
    boolean x = ex instanceof CalledContinuation; if (x ? !x : 
      !(ex instanceof ExitCalled)) {
      Object cause = ExceptionWithValue.unwrap(ex);
      handlerProc.apply1(cause); }
    return ex;
  }
  
  public HandlerLink() {}
}
