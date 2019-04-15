package gnu.kawa.slib; import gnu.expr.ModuleMethod;

public class pp extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final ModuleMethod pretty$Mnprint;
  static final gnu.math.IntNum Lit0;
  
  public static Object prettyPrint(Object paramObject) { return prettyPrint(paramObject, (gnu.kawa.io.OutPort)kawa.lib.ports.current$Mnoutput$Mnport.getValue()); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 2) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext) { if (selector == 2) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 2) return prettyPrint(paramObject); return super.apply1(paramModuleMethod, paramObject); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 2) return prettyPrint(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  public class frame extends gnu.expr.ModuleBody { public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 1) return lambda1(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda1(Object s) { kawa.lib.ports.display(s, port);return true;
    }
    
    Object port;
    final ModuleMethod lambda$Fn1;
    public frame()
    {
      void tmp18_15 = new ModuleMethod(this, 1, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/pp.scm:9");
      lambda$Fn1 = tmp18_15;
    }
  }
  
  public static pp $instance;
  static final gnu.mapping.SimpleSymbol Lit1 = gnu.mapping.Symbol.valueOf("pretty-print");
  public static Object prettyPrint(Object obj, Object port)
  {
    frame $heapFrame = new frame();port = port;
    return genwrite.genericWrite(obj, Boolean.FALSE, Lit0, lambda$Fn1);
  }
  
  static
  {
    Lit0 = gnu.math.IntNum.valueOf(79);
    $instance = new pp();
    pp localPp = $instance;
    pretty$Mnprint = new ModuleMethod(localPp, 2, Lit1, 8193);
    $runBody$();
  }
  
  public pp()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
