package kawa.lib.rnrs.arithmetic; import gnu.kawa.reflect.StaticFieldLocation;

public class bitwise extends gnu.expr.ModuleBody { public static final StaticFieldLocation bitwise$Mnbit$Mnset$Qu; public static final StaticFieldLocation bitwise$Mncopy$Mnbit; public static final StaticFieldLocation bitwise$Mncopy$Mnbit$Mnfield; public static final StaticFieldLocation bitwise$Mnbit$Mnfield; public static final StaticFieldLocation bitwise$Mnif; public static final StaticFieldLocation bitwise$Mnbit$Mncount; public static final StaticFieldLocation bitwise$Mnlength; public static final StaticFieldLocation bitwise$Mnfirst$Mnbit$Mnset; public static final StaticFieldLocation bitwise$Mnrotate$Mnbit$Mnfield; public static final StaticFieldLocation bitwise$Mnreverse$Mnbit$Mnfield; public static final StaticFieldLocation bitwise$Mnnot; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  public static final StaticFieldLocation bitwise$Mnand; public static final StaticFieldLocation bitwise$Mnior; public static final StaticFieldLocation bitwise$Mnxor; public static final StaticFieldLocation bitwise$Mnarithmetic$Mnshift; public static final StaticFieldLocation bitwise$Mnarithmetic$Mnshift$Mnleft; public static final StaticFieldLocation bitwise$Mnarithmetic$Mnshift$Mnright; public static bitwise $instance = new bitwise(); static { bitwise$Mnbit$Mnset$Qu = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnbit$Mnset$Qu");bitwise$Mncopy$Mnbit = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mncopy$Mnbit");bitwise$Mncopy$Mnbit$Mnfield = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mncopy$Mnbit$Mnfield");bitwise$Mnbit$Mnfield = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnbit$Mnfield");bitwise$Mnif = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnif");bitwise$Mnbit$Mncount = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnbit$Mncount");bitwise$Mnlength = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnlength");bitwise$Mnfirst$Mnbit$Mnset = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnfirst$Mnbit$Mnset");bitwise$Mnrotate$Mnbit$Mnfield = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnrotate$Mnbit$Mnfield");bitwise$Mnreverse$Mnbit$Mnfield = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnreverse$Mnbit$Mnfield");
    

    bitwise$Mnand = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "and");bitwise$Mnior = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ior");bitwise$Mnnot = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "not");bitwise$Mnxor = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "xor");
    


    bitwise$Mnarithmetic$Mnshift = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashift");
    bitwise$Mnarithmetic$Mnshift$Mnleft = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashiftl");
    bitwise$Mnarithmetic$Mnshift$Mnright = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashiftr");$runBody$();
  }
  
  public bitwise()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
