package kawa.lib; import gnu.expr.ModuleMethod;

public class parameters extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  

  public static final ModuleMethod make$Mnparameter;
  public static final ModuleMethod as$Mnlocation$Pc;
  public static parameters $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1 = gnu.mapping.Symbol.valueOf("as-location%");
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 3:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 1) return makeParameter(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  public static gnu.mapping.LocationProc makeParameter(Object init, Object converter) { if (converter != null)
      init = kawa.standard.Scheme.applyToArgs.apply2(converter, init);
    gnu.mapping.ThreadLocation loc = new gnu.mapping.ThreadLocation();
    loc.setGlobal(init);
    try { return new gnu.mapping.LocationProc(loc, (gnu.mapping.Procedure)(localObject = gnu.mapping.Promise.force(converter, gnu.mapping.Procedure.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "gnu.mapping.LocationProc.<init>(gnu.mapping.Location,gnu.mapping.Procedure)", 2, localObject);
    }
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return makeParameter(paramObject);
    




    case 3: 
      return asLocation$Pc(paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static gnu.mapping.Location asLocation$Pc(Object param) { if ((param instanceof gnu.mapping.LocationProc)) {}
    try { tmpTernaryOp = ((gnu.mapping.LocationProc)(localObject = gnu.mapping.Promise.force(param, gnu.mapping.LocationProc.class))).getLocation();
      return (gnu.mapping.Location)gnu.mapping.Promise.force(param, gnu.mapping.Location.class);
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
        localClassCastException, "gnu.mapping.LocationProc.getLocation()", 1, localObject);
    }
  }
  
  public static gnu.mapping.LocationProc makeParameter(Object paramObject)
  {
    return makeParameter(paramObject, null);
  }
  
  static
  {
    Lit0 = gnu.mapping.Symbol.valueOf("make-parameter");
    $instance = new parameters();
    parameters localParameters = $instance;
    make$Mnparameter = new ModuleMethod(localParameters, 1, Lit0, 8193);
    as$Mnlocation$Pc = new ModuleMethod(localParameters, 3, Lit1, 4097);
    $runBody$();
  }
  
  public parameters()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
