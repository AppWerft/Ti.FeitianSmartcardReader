package kawa.lib.scheme; import gnu.mapping.CallContext;

public class load extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.kawa.reflect.StaticFieldLocation load; static { load = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.load", "load");$runBody$(); } public static load $instance = new load();
  
  public load()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
