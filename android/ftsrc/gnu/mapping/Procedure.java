package gnu.mapping;

import gnu.bytecode.Type;
import gnu.expr.Expression;





public abstract class Procedure
  extends PropertySet
{
  private static final String sourceLocationKey = "source-location";
  private static final Symbol setterKey = Namespace.EmptyNamespace.getSymbol("setter");
  






  public static final Symbol validateApplyKey = Namespace.EmptyNamespace.getSymbol("validate-apply");
  

  public static final Symbol validateXApplyKey = Namespace.EmptyNamespace.getSymbol("validate-xapply");
  
  public static final Symbol compilerXKey = Namespace.EmptyNamespace.getSymbol("compile-apply");
  



  public static final LazyPropertyKey<?> compilerKey = new LazyPropertyKey("compiler");
  

  public void setSourceLocation(String file, int line)
  {
    setProperty("source-location", file + ":" + line);
  }
  
  public String getSourceLocation()
  {
    Object value = getProperty("source-location", null);
    return value == null ? null : value.toString();
  }
  

  public Procedure() {}
  

  public Procedure(String n)
  {
    setName(n);
  }
  
  public abstract Object applyN(Object[] paramArrayOfObject) throws Throwable;
  
  public abstract Object apply0() throws Throwable;
  
  public abstract Object apply1(Object paramObject) throws Throwable;
  
  public abstract Object apply2(Object paramObject1, Object paramObject2) throws Throwable;
  
  public abstract Object apply3(Object paramObject1, Object paramObject2, Object paramObject3) throws Throwable;
  
  public abstract Object apply4(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) throws Throwable;
  
  public final int minArgs()
  {
    return minArgs(numArgs());
  }
  
  public final int maxArgs()
  {
    return maxArgs(numArgs());
  }
  



  public int numArgs()
  {
    return 61440;
  }
  
  public static int minArgs(int num) { return num & 0xFFF; }
  
  public static int maxArgs(int num) { return num >> 12; }
  






  public static void checkArgCount(Procedure proc, int argCount)
  {
    int num = proc.numArgs();
    if ((argCount < minArgs(num)) || ((num >= 0) && (argCount > maxArgs(num))))
    {
      throw new WrongArguments(proc, argCount);
    }
  }
  











  public void apply(CallContext ctx)
    throws Throwable
  {
    apply(this, ctx);
  }
  
  public static void apply(Procedure proc, CallContext ctx)
    throws Throwable
  {
    int count = count;
    Object result; Object result; if ((where == 0) && (count != 0)) {
      result = proc.applyN(values);
    }
    else {
      switch (count)
      {
      case 0: 
        result = proc.apply0();
        break;
      case 1: 
        result = proc.apply1(ctx.getNextArg());
        break;
      case 2: 
        result = proc.apply2(ctx.getNextArg(), ctx.getNextArg());
        break;
      case 3: 
        result = proc.apply3(ctx.getNextArg(), ctx.getNextArg(), ctx.getNextArg());
        
        break;
      case 4: 
        result = proc.apply4(ctx.getNextArg(), ctx.getNextArg(), ctx.getNextArg(), ctx.getNextArg());
        
        break;
      default: 
        result = proc.applyN(ctx.getArgs());
      }
      
    }
    ctx.writeValue(result);
  }
  



  public int match0(CallContext ctx)
  {
    int num = numArgs();
    int min = minArgs(num);
    if (min > 0)
      return 0xFFF10000 | min;
    if (num < 0)
      return matchN(ProcedureN.noArgs, ctx);
    count = 0;
    where = 0;
    next = 0;
    proc = this;
    return 0;
  }
  



  public int match1(Object arg1, CallContext ctx)
  {
    int num = numArgs();
    int min = minArgs(num);
    if (min > 1)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      int max = maxArgs(num);
      if (max < 1)
        return 0xFFF20000 | max;
      value1 = arg1;
      count = 1;
      where = 1;
      next = 0;
      proc = this;
      return 0;
    }
    Object[] args = { arg1 };
    return matchN(args, ctx);
  }
  



  public int match2(Object arg1, Object arg2, CallContext ctx)
  {
    int num = numArgs();
    int min = minArgs(num);
    if (min > 2)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      int max = maxArgs(num);
      if (max < 2)
        return 0xFFF20000 | max;
      value1 = arg1;
      value2 = arg2;
      count = 2;
      where = 33;
      
      next = 0;
      proc = this;
      return 0;
    }
    Object[] args = { arg1, arg2 };
    return matchN(args, ctx);
  }
  



  public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx)
  {
    int num = numArgs();
    int min = minArgs(num);
    if (min > 3)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      int max = maxArgs(num);
      if (max < 3)
        return 0xFFF20000 | max;
      value1 = arg1;
      value2 = arg2;
      value3 = arg3;
      count = 3;
      where = 801;
      

      next = 0;
      proc = this;
      return 0;
    }
    Object[] args = { arg1, arg2, arg3 };
    return matchN(args, ctx);
  }
  




  public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx)
  {
    int num = numArgs();
    int min = minArgs(num);
    if (min > 4)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      int max = maxArgs(num);
      if (max < 4)
        return 0xFFF20000 | max;
      value1 = arg1;
      value2 = arg2;
      value3 = arg3;
      value4 = arg4;
      count = 4;
      where = 17185;
      


      next = 0;
      proc = this;
      return 0;
    }
    Object[] args = { arg1, arg2, arg3, arg4 };
    return matchN(args, ctx);
  }
  
  public int matchN(Object[] args, CallContext ctx)
  {
    int num = numArgs();
    int min = minArgs(num);
    if (args.length < min)
      return 0xFFF10000 | min;
    if (num >= 0)
    {
      switch (args.length)
      {
      case 0: 
        return match0(ctx);
      case 1: 
        return match1(args[0], ctx);
      case 2: 
        return match2(args[0], args[1], ctx);
      case 3: 
        return match3(args[0], args[1], args[2], ctx);
      case 4: 
        return match4(args[0], args[1], args[2], args[3], ctx);
      }
      int max = maxArgs(num);
      if (args.length > max) {
        return 0xFFF20000 | max;
      }
    }
    values = args;
    count = args.length;
    where = 0;
    next = 0;
    proc = this;
    return 0;
  }
  

  public void check0(CallContext ctx)
  {
    int code = match0(ctx);
    if (code != 0)
    {
      throw MethodProc.matchFailAsException(code, this, ProcedureN.noArgs);
    }
  }
  

  public void check1(Object arg1, CallContext ctx)
  {
    int code = match1(arg1, ctx);
    if (code != 0)
    {
      Object[] args = { arg1 };
      throw MethodProc.matchFailAsException(code, this, args);
    }
  }
  

  public void check2(Object arg1, Object arg2, CallContext ctx)
  {
    int code = match2(arg1, arg2, ctx);
    if (code != 0)
    {
      Object[] args = { arg1, arg2 };
      throw MethodProc.matchFailAsException(code, this, args);
    }
  }
  

  public void check3(Object arg1, Object arg2, Object arg3, CallContext ctx)
  {
    int code = match3(arg1, arg2, arg3, ctx);
    if (code != 0)
    {
      Object[] args = { arg1, arg2, arg3 };
      throw MethodProc.matchFailAsException(code, this, args);
    }
  }
  


  public void check4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx)
  {
    int code = match4(arg1, arg2, arg3, arg4, ctx);
    if (code != 0)
    {
      Object[] args = { arg1, arg2, arg3, arg4 };
      throw MethodProc.matchFailAsException(code, this, args);
    }
  }
  

  public void checkN(Object[] args, CallContext ctx)
  {
    int code = matchN(args, ctx);
    if (code != 0)
    {
      throw MethodProc.matchFailAsException(code, this, args);
    }
  }
  
  public Procedure getSetter()
  {
    if (!(this instanceof HasSetter))
    {
      Object setter = getProperty(setterKey, null);
      if ((setter instanceof Procedure))
        return (Procedure)setter;
      throw new RuntimeException("procedure '" + getName() + "' has no setter");
    }
    int num_args = numArgs();
    if (num_args == 0)
      return new Setter0(this);
    if (num_args == 4097)
      return new Setter1(this);
    return new Setter(this);
  }
  
  public void setSetter(Procedure setter)
  {
    if ((this instanceof HasSetter)) {
      throw new RuntimeException("procedure '" + getName() + "' has builtin setter - cannot be modified");
    }
    setProperty(setterKey, setter);
  }
  
  public void set0(Object result)
    throws Throwable
  {
    getSetter().apply1(result);
  }
  
  public void set1(Object arg1, Object value) throws Throwable
  {
    getSetter().apply2(arg1, value);
  }
  
  public void setN(Object[] args) throws Throwable
  {
    getSetter().applyN(args);
  }
  




  public boolean isSideEffectFree()
  {
    return false;
  }
  

  public Type getReturnType(Expression[] args)
  {
    return Type.objectType;
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer();
    sbuf.append("#<procedure ");
    String n = getName();
    if (n == null)
      n = getSourceLocation();
    if (n == null)
      n = getClass().getName();
    sbuf.append(n);
    sbuf.append('>');
    return sbuf.toString();
  }
}
