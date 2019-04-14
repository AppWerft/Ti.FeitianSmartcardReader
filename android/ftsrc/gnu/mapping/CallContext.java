package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.math.IntNum;





public class CallContext
{
  static ThreadLocal currentContext = new ThreadLocal();
  public Procedure proc;
  public int pc;
  
  public CallContext() {}
  
  public static void setInstance(CallContext ctx) {
    Thread thread = Thread.currentThread();
    
    currentContext.set(ctx);
  }
  







  public static CallContext getOnlyInstance()
  {
    return (CallContext)currentContext.get();
  }
  

  public static CallContext getInstance()
  {
    CallContext ctx = getOnlyInstance();
    if (ctx == null)
    {
      ctx = new CallContext();
      setInstance(ctx);
    }
    return ctx;
  }
  












  private ValueStack vstack = new ValueStack();
  

  public Consumer consumer = vstack;
  
  public Object value1;
  
  public Object value2;
  
  public Object value3;
  
  public Object value4;
  
  public Object[] values;
  
  public int ivalue1;
  
  public int ivalue2;
  
  public int count;
  
  public int next;
  
  public int where;
  
  public static final int ARG_IN_VALUES_ARRAY = 0;
  public static final int ARG_IN_VALUE1 = 1;
  public static final int ARG_IN_VALUE2 = 2;
  public static final int ARG_IN_VALUE3 = 3;
  public static final int ARG_IN_VALUE4 = 4;
  public static final int ARG_IN_IVALUE1 = 5;
  public static final int ARG_IN_IVALUE2 = 6;
  public Object[][] evalFrames;
  
  Object getArgAsObject(int i)
  {
    if (i < 8)
    {
      switch (where >> 4 * i & 0xF) {
      case 1: 
        return value1;
      case 2:  return value2;
      case 3:  return value3;
      case 4:  return value4;
      case 5:  return IntNum.make(ivalue1);
      case 6:  return IntNum.make(ivalue2);
      }
    }
    return values[i];
  }
  
  public int getArgCount() { return count; }
  






  public Object getNextArg()
  {
    if (next >= count)
      throw new WrongArguments(null, count);
    return getArgAsObject(next++);
  }
  
  public int getNextIntArg()
  {
    if (next >= count)
      throw new WrongArguments(null, count);
    Object arg = getArgAsObject(next++);
    return ((Number)arg).intValue();
  }
  



  public Object getNextArg(Object defaultValue)
  {
    if (next >= count)
      return defaultValue;
    return getArgAsObject(next++);
  }
  
  public int getNextIntArg(int defaultValue)
  {
    if (next >= count)
      return defaultValue;
    return ((Number)getArgAsObject(next++)).intValue();
  }
  

  public final Object[] getRestArgsArray(int next)
  {
    Object[] args = new Object[count - next];
    int i = 0;
    while (next < count)
    {
      args[(i++)] = getArgAsObject(next++);
    }
    return args;
  }
  


  public final LList getRestArgsList(int next)
  {
    LList nil = LList.Empty;
    LList list = nil;
    Pair last = null;
    while (next < count)
    {
      Pair pair = new Pair(getArgAsObject(next++), nil);
      if (last == null) {
        list = pair;
      } else
        last.setCdr(pair);
      last = pair;
    }
    return list;
  }
  



  public void lastArg()
  {
    if (next < count)
      throw new WrongArguments(null, count);
    values = null;
  }
  
  public Object[] getArgs()
  {
    if (where == 0) {
      return values;
    }
    
    int n = count;
    next = 0;
    Object[] args = new Object[n];
    for (int i = 0; i < n; i++)
      args[i] = getNextArg();
    return args;
  }
  
  public void runUntilDone()
    throws Throwable
  {
    for (;;)
    {
      Procedure proc = this.proc;
      if (proc == null) {
        break;
      }
      








      this.proc = null;
      proc.apply(this);
    }
  }
  






  public final int startFromContext()
  {
    if ((vstack.gapStart == vstack.gapStartOnPush) && (consumer == vstack) && (vstack.lastObject == vstack))
    {

      return -1;
    }
    vstack.push();
    vstack.consumerOnPush = consumer;
    vstack.oindexOnPush = vstack.oindex;
    vstack.gapStartOnPush = vstack.gapStart;
    consumer = vstack;
    return vstack.gapStart;
  }
  

  public final Object getFromContext(int saved)
    throws Throwable
  {
    runUntilDone();
    Object result = ((ValueStack)consumer).getValue();
    cleanupFromContext(saved);
    return result;
  }
  






  public final void cleanupFromContext(int saved)
  {
    vstack.gapStart = vstack.gapStartOnPush;
    int oindexOnPush = vstack.oindexOnPush;
    int i = vstack.oindex; for (;;) { i--; if (i < oindexOnPush) break;
      vstack.objects[i] = null; }
    vstack.oindex = oindexOnPush;
    vstack.lastObject = vstack;
    if (saved >= 0) {
      consumer = vstack.consumerOnPush;
      vstack.pop(saved);
    }
  }
  








  public final Object runUntilValue()
    throws Throwable
  {
    Consumer consumerSave = consumer;
    ValueStack vst = vstack;
    consumer = vst;
    Object lastSave = lastObject;
    lastObject = vst;
    int dindexSave = gapStart;
    int gapStartOnPushSave = gapStartOnPush;
    vstack.gapStartOnPush = gapStart;
    int oindexSave = oindex;
    try {
      runUntilDone();
      return vst.getValue();
    } finally {
      consumer = consumerSave;
      gapStart = dindexSave;
      oindex = oindexSave;
      gapStartOnPush = gapStartOnPushSave;
      lastObject = lastSave;
    }
  }
  

  public final void runUntilValue(Consumer out)
    throws Throwable
  {
    Consumer consumerSave = consumer;
    consumer = out;
    try
    {
      runUntilDone();
    }
    finally
    {
      consumer = consumerSave;
    }
  }
  

  public void writeValue(Object value)
  {
    Values.writeValues(value, consumer);
  }
}
