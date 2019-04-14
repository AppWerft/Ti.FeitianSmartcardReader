package kawa.lib.scheme; import gnu.kawa.reflect.StaticFieldLocation;

public class write extends gnu.expr.ModuleBody { public static final StaticFieldLocation write$Mnsimple; public static final StaticFieldLocation write; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  public static final StaticFieldLocation write$Mnshared; public static final StaticFieldLocation display; static { write$Mnsimple = StaticFieldLocation.make("kawa.lib.ports", "write$Mnsimple");write = StaticFieldLocation.make("kawa.lib.ports", "write");write$Mnshared = StaticFieldLocation.make("kawa.lib.ports", "write$Mnshared");display = StaticFieldLocation.make("kawa.lib.ports", "display");$runBody$(); } public static write $instance = new write();
  
  public write()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
