package gnu.expr;

import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;
import java.lang.reflect.Method;
import kawa.SourceMethodType;





public class ModuleMethod
  extends MethodProc
{
  public ModuleBody module;
  public int selector;
  protected int numArgs;
  
  public ModuleMethod(ModuleBody module, int selector, Object name, int numArgs)
  {
    init(module, selector, name, numArgs);
  }
  

  public ModuleMethod(ModuleBody module, int selector, Object name, int numArgs, Object argTypes)
  {
    init(module, selector, name, numArgs);
    this.argTypes = argTypes;
  }
  

  public ModuleMethod init(ModuleBody module, int selector, Object name, int numArgs)
  {
    this.module = module;
    this.selector = selector;
    this.numArgs = numArgs;
    if (name != null)
      setSymbol(name);
    return this;
  }
  



  protected void resolveParameterTypes()
  {
    Method method = null;
    String name = getName();
    if (name != null)
    {
      try
      {
        Class moduleClass = module.getClass();
        Method[] methods = moduleClass.getDeclaredMethods();
        String mangledName = Mangling.mangleNameIfNeeded(name);
        int i = methods.length; for (;;) { i--; if (i < 0)
            break;
          if (methods[i].getName().equals(mangledName))
          {
            if (method != null)
            {
              method = null;
              break;
            }
            method = methods[i];
          }
        }
        if (method != null)
        {
          Language lang = Language.getDefaultLanguage();
          if (lang != null)
          {
            Class[] parameterClasses = method.getParameterTypes();
            int numParamTypes = parameterClasses.length;
            Type[] atypes = new Type[numParamTypes];
            String[] annotTypes;
            try {
              SourceMethodType sourceType = (SourceMethodType)method.getAnnotation(SourceMethodType.class);
              annotTypes = sourceType == null ? null : sourceType.value();
            } catch (Throwable ex) {
              annotTypes = null;
            }
            int i = numParamTypes; for (;;) { i--; if (i < 0)
                break;
              atypes[i] = lang.getTypeFor(parameterClasses[i]);
              if (annotTypes != null) {
                atypes[i] = PrimProcedure.decodeType(atypes[i], annotTypes, i + 1, null, lang);
              }
            }
            

            argTypes = atypes;
          }
        }
      }
      catch (Exception ex) {}
    }
    

    if (argTypes == null)
      super.resolveParameterTypes();
  }
  
  public int numArgs() { return numArgs; }
  
  public int match0(CallContext ctx)
  {
    count = 0;
    where = 0;
    return module.match0(this, ctx);
  }
  
  public int match1(Object arg1, CallContext ctx)
  {
    count = 1;
    where = 1;
    return module.match1(this, arg1, ctx);
  }
  
  public int match2(Object arg1, Object arg2, CallContext ctx)
  {
    count = 2;
    where = 33;
    
    return module.match2(this, arg1, arg2, ctx);
  }
  
  public int match3(Object arg1, Object arg2, Object arg3, CallContext ctx)
  {
    count = 3;
    where = 801;
    

    return module.match3(this, arg1, arg2, arg3, ctx);
  }
  

  public int match4(Object arg1, Object arg2, Object arg3, Object arg4, CallContext ctx)
  {
    count = 4;
    where = 17185;
    


    return module.match4(this, arg1, arg2, arg3, arg4, ctx);
  }
  
  public int matchN(Object[] args, CallContext ctx)
  {
    int num = numArgs();
    int min = minArgs(num);
    int nargs = args.length;
    if (nargs < min)
      return 0xFFF10000 | min;
    int max = maxArgs(num);
    if ((max > 0) && (nargs > max))
      return 0xFFF20000 | max;
    count = nargs;
    where = 0;
    return module.matchN(this, args, ctx);
  }
  




  public void apply(CallContext ctx)
    throws Throwable
  {
    Object result;
    



    switch (pc)
    {
    case 0: 
      result = apply0();
      break;
    case 1: 
      result = apply1(value1);
      break;
    case 2: 
      result = apply2(value1, value2);
      break;
    case 3: 
      result = apply3(value1, value2, value3);
      break;
    case 4: 
      result = apply4(value1, value2, value3, value4);
      break;
    case 5: 
      result = applyN(values);
      break;
    default: 
      throw new Error("internal error - apply " + this);
    }
    ctx.writeValue(result);
  }
  
  public Object apply0()
    throws Throwable
  {
    return module.apply0(this);
  }
  
  public Object apply1(Object arg1)
    throws Throwable
  {
    return module.apply1(this, arg1);
  }
  
  public Object apply2(Object arg1, Object arg2)
    throws Throwable
  {
    return module.apply2(this, arg1, arg2);
  }
  
  public Object apply3(Object arg1, Object arg2, Object arg3)
    throws Throwable
  {
    return module.apply3(this, arg1, arg2, arg3);
  }
  
  public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4)
    throws Throwable
  {
    return module.apply4(this, arg1, arg2, arg3, arg4);
  }
  
  public Object applyN(Object[] args)
    throws Throwable
  {
    return module.applyN(this, args);
  }
  
  public static Object apply0Default(ModuleMethod method)
    throws Throwable
  {
    return module.applyN(method, Values.noArgs);
  }
  
  public static Object apply1Default(ModuleMethod method, Object arg1)
    throws Throwable
  {
    Object[] args = new Object[1];
    args[0] = arg1;
    return module.applyN(method, args);
  }
  
  public static Object apply2Default(ModuleMethod method, Object arg1, Object arg2)
    throws Throwable
  {
    Object[] args = new Object[2];
    args[0] = arg1;
    args[1] = arg2;
    return module.applyN(method, args);
  }
  

  public static Object apply3Default(ModuleMethod method, Object arg1, Object arg2, Object arg3)
    throws Throwable
  {
    Object[] args = new Object[3];
    args[0] = arg1;
    args[1] = arg2;
    args[2] = arg3;
    return module.applyN(method, args);
  }
  

  public static Object apply4Default(ModuleMethod method, Object arg1, Object arg2, Object arg3, Object arg4)
    throws Throwable
  {
    Object[] args = new Object[4];
    args[0] = arg1;
    args[1] = arg2;
    args[2] = arg3;
    args[3] = arg4;
    return module.applyN(method, args);
  }
  
  public static Object applyNDefault(ModuleMethod method, Object[] args)
    throws Throwable
  {
    int count = args.length;
    int num = method.numArgs();
    ModuleBody module = method.module;
    if ((count >= (num & 0xFFF)) && ((num < 0) || (count <= num >> 12)))
    {

      switch (count)
      {
      case 0: 
        return module.apply0(method);
      case 1: 
        return module.apply1(method, args[0]);
      case 2: 
        return module.apply2(method, args[0], args[1]);
      case 3: 
        return module.apply3(method, args[0], args[1], args[2]);
      case 4: 
        return module.apply4(method, args[0], args[1], args[2], args[3]);
      }
    }
    throw new WrongArguments(method, count);
  }
  


  public static void applyError()
  {
    throw new Error("internal error - bad selector");
  }
}
