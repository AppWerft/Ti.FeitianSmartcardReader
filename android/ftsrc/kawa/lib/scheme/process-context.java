package kawa.lib.scheme; import gnu.kawa.reflect.StaticFieldLocation;

public class process-context extends gnu.expr.ModuleBody { public static final StaticFieldLocation command$Mnline; public static final StaticFieldLocation exit; public static final StaticFieldLocation emergency$Mnexit; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  public static final StaticFieldLocation get$Mnenvironment$Mnvariable; public static final StaticFieldLocation get$Mnenvironment$Mnvariables; public static process-context $instance = new process-context(); static { command$Mnline = StaticFieldLocation.make("kawa.lib.rnrs.programs", "command$Mnline");exit = StaticFieldLocation.make("kawa.lib.rnrs.programs", "exit");emergency$Mnexit = StaticFieldLocation.make("kawa.lib.rnrs.programs", "emergency$Mnexit");
    get$Mnenvironment$Mnvariable = StaticFieldLocation.make("kawa.lib.system", "get$Mnenvironment$Mnvariable");get$Mnenvironment$Mnvariables = StaticFieldLocation.make("kawa.lib.system", "get$Mnenvironment$Mnvariables");$runBody$();
  }
  
  public process-context()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
