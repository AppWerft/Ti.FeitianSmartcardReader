package kawa.lib.scheme; import gnu.kawa.reflect.StaticFieldLocation;

public class complex extends gnu.expr.ModuleBody { public static final StaticFieldLocation make$Mnrectangular; public static final StaticFieldLocation make$Mnpolar; public static final StaticFieldLocation real$Mnpart; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  public static final StaticFieldLocation imag$Mnpart; public static final StaticFieldLocation magnitude; static { make$Mnrectangular = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnrectangular");make$Mnpolar = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnpolar");real$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "real$Mnpart");imag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "imag$Mnpart");magnitude = StaticFieldLocation.make("kawa.lib.numbers", "magnitude");angle = StaticFieldLocation.make("kawa.lib.numbers", "angle");$runBody$(); } public static final StaticFieldLocation angle; public static complex $instance = new complex();
  
  public complex()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
