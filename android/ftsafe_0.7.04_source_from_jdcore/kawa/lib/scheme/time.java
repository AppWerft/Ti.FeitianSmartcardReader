package kawa.lib.scheme; import gnu.kawa.reflect.StaticFieldLocation;

public class time extends gnu.expr.ModuleBody { public static final StaticFieldLocation current$Mnsecond; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  public static final StaticFieldLocation current$Mnjiffy; public static final StaticFieldLocation jiffies$Mnper$Mnsecond; static { current$Mnsecond = StaticFieldLocation.make("kawa.lib.system", "current$Mnsecond");current$Mnjiffy = StaticFieldLocation.make("kawa.lib.system", "current$Mnjiffy");jiffies$Mnper$Mnsecond = StaticFieldLocation.make("kawa.lib.system", "jiffies$Mnper$Mnsecond");$runBody$(); } public static time $instance = new time();
  
  public time()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
