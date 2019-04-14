package gnu.kawa.slib;

import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class cut extends gnu.expr.ModuleBody
{
  public static final Macro cut;
  public static final Macro cute;
  public static final StaticFieldLocation $Prvt$let;
  public static final StaticFieldLocation $Prvt$apply;
  public static final StaticFieldLocation $Prvt$begin;
  public static final StaticFieldLocation $Prvt$lambda;
  public static final Macro $Prvt$srfi$Mn26$Mninternal$Mncut;
  public static final Macro $Prvt$srfi$Mn26$Mninternal$Mncute;
  public static cut $instance;
  static final SimpleSymbol Lit0;
  static final SyntaxRules Lit1;
  static final SimpleSymbol Lit2;
  static final SyntaxRules Lit3;
  static final SimpleSymbol Lit4;
  static final SyntaxRules Lit5;
  static final SimpleSymbol Lit6;
  static final SyntaxRules Lit7;
  static final Object[] Lit8;
  static final SimpleSymbol Lit9;
  static final SimpleSymbol Lit10;
  static final SimpleSymbol Lit11;
  static final SimpleSymbol Lit12;
  static final SimpleSymbol Lit13;
  static final PairWithPosition Lit14;
  static final Object[] Lit15;
  static final Object[] Lit16;
  static final SimpleSymbol Lit17;
  static final SimpleSymbol Lit18;
  static final Object[] Lit19;
  static final Object[] Lit20;
  
  private static void $runBody$()
  {
    ;
    Consumer $result = getInstanceconsumer; }
  
  static { SimpleSymbol tmp14_11 = Symbol.valueOf("srfi-26-internal-cut");Lit0 = tmp14_11;(cut.Lit20 = new Object[1])[0] = tmp14_11; SimpleSymbol tmp33_30 = Symbol.valueOf("<>");Lit13 = tmp33_30;(cut.Lit19 = new Object[1])[0] = tmp33_30;Lit18 = Symbol.valueOf("rest-slot");Lit17 = Symbol.valueOf("apply"); SimpleSymbol tmp68_65 = Symbol.valueOf("<...>");Lit9 = tmp68_65;(cut.Lit16 = new Object[1])[0] = tmp68_65; Object[] tmp81_78 = (cut.Lit15 = new Object[2]);tmp81_78[0] = Lit13;tmp81_78[1] = Lit9;Lit14 = PairWithPosition.make(cut.Lit12 = Symbol.valueOf("x"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/cut.scm", 364616);Lit11 = Symbol.valueOf("lambda");Lit10 = Symbol.valueOf("let");Lit8 = new Object[0]; SyntaxRule[] tmp148_145 = new SyntaxRule[1]; Object[] tmp177_174 = new Object[1]; SimpleSymbol tmp184_181 = Symbol.valueOf("srfi-26-internal-cute");Lit2 = tmp184_181;tmp177_174[0] = tmp184_181;tmp148_145[0] = new SyntaxRule(new SyntaxPattern("\f\030\003", Lit8, 1, "cut.scm:111"), "\000", "\021\030\004\t\020\t\020\t\020\002", tmp177_174, 0);Lit7 = new SyntaxRules(Lit8, tmp148_145, 1, cut.Lit6 = Symbol.valueOf("cute"));Lit5 = new SyntaxRules(Lit8, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\030\003", Lit8, 1, "cut.scm:106"), "\000", "\021\030\004\t\020\t\020\002", Lit20, 0) }, 1, cut.Lit4 = Symbol.valueOf("cut")); SyntaxRule[] tmp281_278 = new SyntaxRule[4]; SyntaxRule[] tmp282_281 = tmp281_278; Object[] tmp311_308 = new Object[2]; Object[] tmp312_311 = tmp311_308;tmp312_311[0] = Lit10;tmp312_311[1] = Lit11;tmp282_281[0] = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b\f\017<\f\027\r\037\030\b\b\b", Lit8, 4, "cut.scm:83"), "\003\001\001\003", "\021\030\004\t\013\b\021\030\f\031\b\005\003\b\t\023\b\035\033", tmp311_308, 1); SyntaxRule[] tmp328_282 = tmp282_281; Object[] tmp357_354 = new Object[5]; Object[] tmp358_357 = tmp357_354;tmp358_357[0] = Lit10; Object[] tmp364_358 = tmp358_357;tmp364_358[1] = Lit11; Object[] tmp370_364 = tmp364_358;tmp370_364[2] = Lit12; Object[] tmp376_370 = tmp370_364;tmp376_370[3] = Lit17;tmp376_370[4] = Lit14;tmp328_282[1] = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b\f\017<\f\027\r\037\030\b\b\f\002\b", Lit16, 4, "cut.scm:87"), "\003\001\001\003", "\021\030\004\t\013\b\021\030\f)\021\005\003\030\024\b\021\030\034\t\023\021\035\033\030$", tmp357_354, 1); SyntaxRule[] tmp392_328 = tmp328_282; Object[] tmp421_418 = new Object[3]; Object[] tmp422_421 = tmp421_418;tmp422_421[0] = Lit2; Object[] tmp428_422 = tmp422_421;tmp428_422[1] = Lit14;tmp428_422[2] = Lit14;tmp392_328[2] = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b\f\017,\r\027\020\b\b\f\002\033", Lit19, 4, "cut.scm:92"), "\003\001\003\000", "\021\030\004)\021\005\003\030\f\t\013)\021\025\023\030\024\032", tmp421_418, 1); Object[] tmp472_469 = new Object[3]; Object[] tmp473_472 = tmp472_469;tmp473_472[0] = Lit2; Object[] tmp479_473 = tmp473_472;tmp479_473[1] = Lit12;tmp479_473[2] = Lit14;tmp392_328[3] = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017,\r\027\020\b\b\f\037#", Lit8, 5, "cut.scm:97"), "\001\001\003\001\000", "\021\030\004\t\0039)\021\030\f\b\033\013)\021\025\023\030\024\"", tmp472_469, 1);Lit3 = new SyntaxRules(Lit15, tmp281_278, 5, Lit2); SyntaxRule[] tmp516_513 = new SyntaxRule[4]; SyntaxRule[] tmp517_516 = tmp516_513; Object[] tmp546_543 = new Object[2]; Object[] tmp547_546 = tmp546_543;tmp547_546[0] = Lit11;tmp547_546[1] = Symbol.valueOf("begin");tmp517_516[0] = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b<\f\017\r\027\020\b\b\b", Lit8, 3, "cut.scm:60"), "\003\001\003", "\021\030\004\031\b\005\003\b)\021\030\f\b\013\b\025\023", tmp546_543, 1); SyntaxRule[] tmp565_517 = tmp517_516; Object[] tmp597_594 = new Object[4]; Object[] tmp598_597 = tmp597_594;tmp598_597[0] = Lit11; Object[] tmp604_598 = tmp598_597;tmp604_598[1] = Lit18; Object[] tmp610_604 = tmp604_598;tmp610_604[2] = Lit17;tmp610_604[3] = PairWithPosition.make(Lit18, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/cut.scm", 258110);tmp565_517[1] = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b<\f\017\r\027\020\b\b\f\002\b", Lit16, 3, "cut.scm:62"), "\003\001\003", "\021\030\004)\021\005\003\030\f\b\021\030\024\t\013\021\025\023\030\034", tmp597_594, 1); SyntaxRule[] tmp637_565 = tmp565_517; Object[] tmp670_667 = new Object[3]; Object[] tmp671_670 = tmp670_667;tmp671_670[0] = Lit0; Object[] tmp677_671 = tmp671_670;tmp677_671[1] = Lit14;tmp677_671[2] = Lit14;tmp637_565[2] = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b,\r\017\b\b\b\f\002\023", Lit19, 3, "cut.scm:66"), "\003\003\000", "\021\030\004)\021\005\003\030\f)\021\r\013\030\024\022", tmp670_667, 1);tmp637_565[3] = new SyntaxRule(new SyntaxPattern("\f\030,\r\007\000\b\b,\r\017\b\b\b\f\027\033", Lit8, 4, "cut.scm:68"), "\003\003\001\000", "\021\030\004\031\b\005\003)\021\r\013\b\023\032", Lit20, 1);Lit1 = new SyntaxRules(Lit15, tmp516_513, 4, Lit0);$instance = new cut();$Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");$Prvt$apply = StaticFieldLocation.make("kawa.standard.Scheme", "apply");$Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");$Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");$Prvt$srfi$Mn26$Mninternal$Mncut = Macro.make(Lit0, Lit1, "gnu.kawa.slib.cut");$Prvt$srfi$Mn26$Mninternal$Mncute = Macro.make(Lit2, Lit3, "gnu.kawa.slib.cut");cut = Macro.make(Lit4, Lit5, "gnu.kawa.slib.cut");cute = Macro.make(Lit6, Lit7, "gnu.kawa.slib.cut");$runBody$();
  }
  
  public cut()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
