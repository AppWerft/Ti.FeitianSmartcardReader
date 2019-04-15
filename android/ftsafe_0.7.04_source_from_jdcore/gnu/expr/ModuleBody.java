package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public abstract class ModuleBody extends gnu.mapping.Procedure0 implements RunnableModule
{
  protected boolean runDone;
  private static boolean mainPrintValues;
  private static int exitCounter;
  
  public ModuleBody() {}
  
  public void apply(CallContext ctx) throws Throwable
  {
    if (pc == 0) {
      run(ctx);
    }
  }
  

  public void run(CallContext ctx)
    throws Throwable
  {}
  
  public void run()
  {
    synchronized (this)
    {
      if (runDone)
        return;
      runDone = true;
    }
    run(gnu.lists.VoidConsumer.instance);
  }
  

  public void run(Consumer out)
  {
    CallContext ctx = CallContext.getInstance();
    Consumer save = consumer;
    consumer = out;
    Throwable th;
    try
    {
      run(ctx);
      th = null;
    }
    catch (Throwable ex)
    {
      th = ex;
    }
    runCleanup(ctx, th, save);
  }
  
  public static void runCleanup(CallContext ctx, Throwable th, Consumer save)
  {
    if (th == null)
    {
      try
      {
        ctx.runUntilDone();
      }
      catch (Throwable ex)
      {
        th = ex;
      }
    }
    consumer = save;
    if (th != null)
    {
      gnu.mapping.WrappedException.rethrow(th);
    }
  }
  
  public Object apply0() throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    match0(ctx);
    return ctx.runUntilValue();
  }
  



  public static boolean getMainPrintValues()
  {
    return mainPrintValues;
  }
  
  public static void setMainPrintValues(boolean value)
  {
    mainPrintValues = value;
  }
  



  public static synchronized void exitIncrement()
  {
    if (exitCounter == 0)
      exitCounter += 1;
    exitCounter += 1;
  }
  





  public static synchronized void exitDecrement()
  {
    int counter = exitCounter;
    if (counter > 0)
    {
      counter--;
      if (counter == 0)
      {
        System.exit(0);
      }
      else {
        exitCounter = counter;
      }
    }
  }
  
  public final void runAsMain()
  {
    runAsMain(this);
  }
  

  public static void runAsMain(RunnableModule module)
  {
    boolean registered = gnu.kawa.io.WriterManager.instance.registerShutdownHook();
    try
    {
      gnu.kawa.util.ExitCalled.push();
      CallContext ctx = CallContext.getInstance();
      if (getMainPrintValues())
      {
        OutPort out = OutPort.outDefault();
        consumer = kawa.Shell.getOutputConsumer(out);
        module.run(ctx);
        ctx.runUntilDone();
        out.freshLine();
      }
      else
      {
        consumer = gnu.lists.VoidConsumer.instance;
        module.run(ctx);
        ctx.runUntilDone();
      }
      if (!registered)
        OutPort.runCleanups();
      exitDecrement();
    }
    catch (gnu.kawa.util.ExitCalled ex)
    {
      throw ex;
    }
    catch (Throwable ex)
    {
      ex.printStackTrace();
      OutPort.runCleanups();
      System.exit(-1);
    }
    finally
    {
      gnu.kawa.util.ExitCalled.pop();
    }
  }
  









  public Object apply0(ModuleMethod method)
    throws Throwable
  {
    return applyN(method, gnu.mapping.Values.noArgs);
  }
  
  public Object apply1(ModuleMethod method, Object arg1)
    throws Throwable
  {
    Object[] args = new Object[1];
    args[0] = arg1;
    return applyN(method, args);
  }
  
  public Object apply2(ModuleMethod method, Object arg1, Object arg2)
    throws Throwable
  {
    Object[] args = new Object[2];
    args[0] = arg1;
    args[1] = arg2;
    return applyN(method, args);
  }
  

  public Object apply3(ModuleMethod method, Object arg1, Object arg2, Object arg3)
    throws Throwable
  {
    Object[] args = new Object[3];
    args[0] = arg1;
    args[1] = arg2;
    args[2] = arg3;
    return applyN(method, args);
  }
  

  public Object apply4(ModuleMethod method, Object arg1, Object arg2, Object arg3, Object arg4)
    throws Throwable
  {
    Object[] args = new Object[4];
    args[0] = arg1;
    args[1] = arg2;
    args[2] = arg3;
    args[3] = arg4;
    return applyN(method, args);
  }
  
  public Object applyN(ModuleMethod method, Object[] args)
    throws Throwable
  {
    int count = args.length;
    int num = method.numArgs();
    if ((count >= (num & 0xFFF)) && ((num < 0) || (count <= num >> 12)))
    {

      switch (count)
      {
      case 0: 
        return apply0(method);
      case 1: 
        return apply1(method, args[0]);
      case 2: 
        return apply2(method, args[0], args[1]);
      case 3: 
        return apply3(method, args[0], args[1], args[2]);
      case 4: 
        return apply4(method, args[0], args[1], args[2], args[3]);
      }
    }
    throw new gnu.mapping.WrongArguments(method, count);
  }
  
  public int match0(ModuleMethod proc, CallContext ctx)
  {
    int num = proc.numArgs();
    int min = num & 0xFFF;
    if (min > 0)
      return 0xFFF10000 | min;
    if (num < 0)
      return matchN(proc, gnu.mapping.ProcedureN.noArgs, ctx);
    count = 0;
    where = 0;
    next = 0;
    proc = proc;
    return 0;
  }
  
  public int match1(ModuleMethod proc, Object arg1, CallContext ctx)
  {
    int num = proc.numArgs();
    int min = num & 0xFFF;
    if (min > 1)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      int max = num >> 12;
      if (max < 1)
        return 0xFFF20000 | max;
      value1 = arg1;
      count = 1;
      where = 1;
      next = 0;
      proc = proc;
      
      return 0;
    }
    where = 0;
    Object[] args = { arg1 };
    return matchN(proc, args, ctx);
  }
  

  public int match2(ModuleMethod proc, Object arg1, Object arg2, CallContext ctx)
  {
    int num = proc.numArgs();
    int min = num & 0xFFF;
    if (min > 2)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      int max = num >> 12;
      if (max < 2)
        return 0xFFF20000 | max;
      value1 = arg1;
      value2 = arg2;
      count = 2;
      where = 33;
      
      next = 0;
      proc = proc;
      return 0;
    }
    where = 0;
    Object[] args = { arg1, arg2 };
    return matchN(proc, args, ctx);
  }
  

  public int match3(ModuleMethod proc, Object arg1, Object arg2, Object arg3, CallContext ctx)
  {
    int num = proc.numArgs();
    int min = num & 0xFFF;
    if (min > 3)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      int max = num >> 12;
      if (max < 3)
        return 0xFFF20000 | max;
      value1 = arg1;
      value2 = arg2;
      value3 = arg3;
      count = 3;
      where = 801;
      

      next = 0;
      proc = proc;
      
      return 0;
    }
    where = 0;
    Object[] args = { arg1, arg2, arg3 };
    return matchN(proc, args, ctx);
  }
  

  public int match4(ModuleMethod proc, Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx)
  {
    int num = proc.numArgs();
    int min = num & 0xFFF;
    if (min > 4)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      int max = num >> 12;
      if (max < 4)
        return 0xFFF20000 | max;
      value1 = arg1;
      value2 = arg2;
      value3 = arg3;
      value4 = arg4;
      count = 4;
      where = 17185;
      


      next = 0;
      proc = proc;
      
      return 0;
    }
    where = 0;
    Object[] args = { arg1, arg2, arg3, arg4 };
    return matchN(proc, args, ctx);
  }
  
  public int matchN(ModuleMethod proc, Object[] args, CallContext ctx)
  {
    int num = proc.numArgs();
    int min = num & 0xFFF;
    if (args.length < min)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      switch (args.length)
      {
      case 0: 
        return match0(proc, ctx);
      case 1: 
        return match1(proc, args[0], ctx);
      case 2: 
        return match2(proc, args[0], args[1], ctx);
      case 3: 
        return match3(proc, args[0], args[1], args[2], ctx);
      case 4: 
        return match4(proc, args[0], args[1], args[2], args[3], ctx);
      }
      int max = num >> 12;
      if (args.length > max) {
        return 0xFFF20000 | max;
      }
    }
    values = args;
    count = args.length;
    where = 0;
    next = 0;
    proc = proc;
    

    return 0;
  }
}
