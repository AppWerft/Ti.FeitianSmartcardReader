package gnu.kawa.slib;

import gnu.kawa.reflect.StaticFieldLocation;

public class receive extends gnu.expr.ModuleBody {
  public static final StaticFieldLocation $Prvt$call$Mnwith$Mnvalues;
  public static final StaticFieldLocation $Prvt$lambda;
  public static final kawa.lang.Macro receive;
  public static receive $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final kawa.lang.SyntaxRules Lit1;
  
  public receive() {
    gnu.expr.ModuleInfo.register(this);
  }
  
  static {
    kawa.lang.SyntaxRule[] tmp18_15 = new kawa.lang.SyntaxRule[1]; Object[] tmp47_44 = new Object[2]; Object[] tmp48_47 = tmp47_44;tmp48_47[0] = gnu.mapping.Symbol.valueOf("call-with-values");tmp48_47[1] = gnu.mapping.Symbol.valueOf("lambda");tmp18_15[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", Lit2, 3, "receive.scm:22"), "\001\001\003", "\021\030\0049\021\030\f\t\020\b\013\b\021\030\f\t\003\b\025\023", tmp47_44, 1);Lit1 = new kawa.lang.SyntaxRules(Lit2, tmp18_15, 3, receive.Lit0 = gnu.mapping.Symbol.valueOf("receive"));$instance = new receive();$Prvt$call$Mnwith$Mnvalues = StaticFieldLocation.make("gnu.kawa.functions.CallWithValues", "callWithValues");$Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");receive = kawa.lang.Macro.make(Lit0, Lit1, "gnu.kawa.slib.receive");$runBody$(); } private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; } static final Object[] Lit2 = new Object[0];
}
