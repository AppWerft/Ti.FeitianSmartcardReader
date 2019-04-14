package kawa.lib.scheme; import gnu.kawa.reflect.StaticFieldLocation;

public class file extends gnu.expr.ModuleBody { public static final StaticFieldLocation file$Mnexists$Qu; public static final StaticFieldLocation delete$Mnfile; public static final StaticFieldLocation open$Mninput$Mnfile; public static final StaticFieldLocation open$Mnbinary$Mninput$Mnfile; public static final StaticFieldLocation open$Mnoutput$Mnfile; public static final StaticFieldLocation open$Mnbinary$Mnoutput$Mnfile; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  public static final StaticFieldLocation call$Mnwith$Mninput$Mnfile; public static final StaticFieldLocation call$Mnwith$Mnoutput$Mnfile; public static final StaticFieldLocation with$Mninput$Mnfrom$Mnfile; public static final StaticFieldLocation with$Mnoutput$Mnto$Mnfile; public static file $instance = new file(); static { file$Mnexists$Qu = StaticFieldLocation.make("kawa.lib.files", "file$Mnexists$Qu");delete$Mnfile = StaticFieldLocation.make("kawa.lib.files", "delete$Mnfile");
    open$Mninput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "open$Mninput$Mnfile");open$Mnbinary$Mninput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "open$Mnbinary$Mninput$Mnfile");open$Mnoutput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "open$Mnoutput$Mnfile");open$Mnbinary$Mnoutput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "open$Mnbinary$Mnoutput$Mnfile");call$Mnwith$Mninput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "call$Mnwith$Mninput$Mnfile");call$Mnwith$Mnoutput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "call$Mnwith$Mnoutput$Mnfile");with$Mninput$Mnfrom$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "with$Mninput$Mnfrom$Mnfile");with$Mnoutput$Mnto$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "with$Mnoutput$Mnto$Mnfile");$runBody$();
  }
  
  public file()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
