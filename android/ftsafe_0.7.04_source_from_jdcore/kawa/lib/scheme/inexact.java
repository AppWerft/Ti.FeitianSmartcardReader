package kawa.lib.scheme; import gnu.kawa.reflect.StaticFieldLocation;

public class inexact extends gnu.expr.ModuleBody { public static final StaticFieldLocation finite$Qu; public static final StaticFieldLocation infinite$Qu; public static final StaticFieldLocation nan$Qu; public static final StaticFieldLocation exp; public static final StaticFieldLocation log; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  public static final StaticFieldLocation sin; public static final StaticFieldLocation cos; public static final StaticFieldLocation tan; public static final StaticFieldLocation asin; public static final StaticFieldLocation acos; static { finite$Qu = StaticFieldLocation.make("kawa.lib.numbers", "finite$Qu");infinite$Qu = StaticFieldLocation.make("kawa.lib.numbers", "infinite$Qu");nan$Qu = StaticFieldLocation.make("kawa.lib.numbers", "nan$Qu");exp = StaticFieldLocation.make("kawa.lib.numbers", "exp");log = StaticFieldLocation.make("kawa.lib.numbers", "log");sin = StaticFieldLocation.make("kawa.lib.numbers", "sin");cos = StaticFieldLocation.make("kawa.lib.numbers", "cos");tan = StaticFieldLocation.make("kawa.lib.numbers", "tan");asin = StaticFieldLocation.make("kawa.lib.numbers", "asin");acos = StaticFieldLocation.make("kawa.lib.numbers", "acos");atan = StaticFieldLocation.make("kawa.lib.numbers", "atan");sqrt = StaticFieldLocation.make("kawa.lib.numbers", "sqrt");$runBody$(); } public static final StaticFieldLocation atan; public static final StaticFieldLocation sqrt; public static inexact $instance = new inexact();
  
  public inexact()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
