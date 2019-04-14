package kawa.lib.scheme; import gnu.kawa.reflect.StaticFieldLocation;

public class lazy extends gnu.expr.ModuleBody { public static final StaticFieldLocation promise$Qu; public static final StaticFieldLocation make$Mnpromise; public static final StaticFieldLocation force; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  public static final StaticFieldLocation delay; public static final StaticFieldLocation delay$Mnforce; public static lazy $instance = new lazy(); static { promise$Qu = StaticFieldLocation.make("kawa.lib.misc", "promise$Qu");make$Mnpromise = StaticFieldLocation.make("kawa.lib.misc", "make$Mnpromise");force = StaticFieldLocation.make("kawa.lib.misc", "force");
    delay = StaticFieldLocation.make("kawa.lib.std_syntax", "delay");delay$Mnforce = StaticFieldLocation.make("kawa.lib.std_syntax", "delay$Mnforce");$runBody$();
  }
  
  public lazy()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
