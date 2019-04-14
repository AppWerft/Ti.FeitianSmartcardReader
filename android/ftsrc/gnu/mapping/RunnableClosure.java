package gnu.mapping;

import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import java.util.concurrent.Callable;










public class RunnableClosure<T>
  implements Callable<T>, Runnable
{
  T result;
  CallContext context;
  private InPort in;
  private OutPort out;
  private OutPort err;
  Throwable exception;
  Procedure action;
  String name;
  static int nrunnables = 0;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public RunnableClosure(Procedure action)
  {
    setName("r" + nrunnables++);
    this.action = action;
  }
  

  public RunnableClosure(Procedure action, InPort in, OutPort out, OutPort err)
  {
    this(action);
    this.in = in;
    this.out = out;
    this.err = err;
  }
  
  public final CallContext getCallContext() {
    return context;
  }
  
  public void run()
  {
    try {
      Environment env = Environment.getCurrent();
      String name = getName();
      if ((env != null) && (env.getSymbol() == null) && (name != null))
      {
        env.setName(name);
      }
      if (context == null) {
        context = CallContext.getInstance();
      } else
        CallContext.setInstance(context);
      if (in != null)
        InPort.setInDefault(in);
      if (out != null)
        OutPort.setOutDefault(out);
      if (err != null)
        OutPort.setErrDefault(err);
      result = action.apply0();
    }
    catch (Error ex)
    {
      throw ex;
    }
    catch (Throwable ex)
    {
      exception = ex;
    }
  }
  


  public Object getResult()
    throws Throwable
  {
    Throwable ex = exception;
    if (ex != null)
      throw ex;
    return result;
  }
  
  public T call()
    throws Exception
  {
    run();
    Throwable ex = exception;
    if (ex != null)
    {
      if ((ex instanceof Exception))
        throw ((Exception)ex);
      if ((ex instanceof Error)) {
        throw ((Error)ex);
      }
      throw new RuntimeException(ex);
    }
    return result;
  }
  
  public String toString() {
    StringBuffer buf = new StringBuffer();
    buf.append("#<runnable ");
    buf.append(getName());
    buf.append(">");
    return buf.toString();
  }
}
