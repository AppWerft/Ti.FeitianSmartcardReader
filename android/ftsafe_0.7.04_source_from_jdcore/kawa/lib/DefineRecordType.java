package kawa.lib;

import gnu.kawa.reflect.StaticFieldLocation;

public class DefineRecordType extends gnu.expr.ModuleBody { public static final kawa.lang.Macro define$Mnrecord$Mntype;
  public static final StaticFieldLocation $Prvt$define;
  public static final StaticFieldLocation $Prvt$let;
  public static final StaticFieldLocation $Prvt$begin;
  public static final StaticFieldLocation $Prvt$define$Mnclass;
  public static final StaticFieldLocation $Prvt$instance$Qu;
  public static final StaticFieldLocation $Prvt$slot$Mnref;
  public static final StaticFieldLocation $Prvt$slot$Mnset$Ex;
  public static final StaticFieldLocation $Prvt$make;
  public static final StaticFieldLocation $Prvt$quote;
  public static final kawa.lang.Macro $Prvt$$Pcdefine$Mnrecord$Mnfield;
  public static DefineRecordType $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final kawa.lang.SyntaxRules Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final kawa.lang.SyntaxRules Lit3; static final Object[] Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7;
  private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.lists.PairWithPosition Lit10; static final gnu.mapping.SimpleSymbol Lit11;
  static { Lit12 = gnu.mapping.Symbol.valueOf("slot-set!");Lit11 = gnu.mapping.Symbol.valueOf("begin");Lit10 = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("value"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/DefineRecordType.scm", 253992);Lit9 = gnu.mapping.Symbol.valueOf("quote");Lit8 = gnu.mapping.Symbol.valueOf("slot-ref");Lit7 = gnu.mapping.Symbol.valueOf("::");Lit6 = gnu.mapping.Symbol.valueOf("obj");Lit5 = gnu.mapping.Symbol.valueOf("define");Lit4 = new Object[0]; kawa.lang.SyntaxRule[] tmp100_97 = new kawa.lang.SyntaxRule[2]; kawa.lang.SyntaxRule[] tmp101_100 = tmp100_97; Object[] tmp130_127 = new Object[5]; Object[] tmp131_130 = tmp130_127;tmp131_130[0] = Lit5; Object[] tmp137_131 = tmp131_130;tmp137_131[1] = Lit6; Object[] tmp143_137 = tmp137_131;tmp143_137[2] = Lit7; Object[] tmp149_143 = tmp143_137;tmp149_143[3] = Lit8;tmp149_143[4] = Lit9;tmp101_100[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\b", Lit4, 3, "DefineRecordType.scm:55"), "\001\001\001", "\021\030\004Y\t\023\b\021\030\f\021\030\024\b\003\b\021\030\034\021\030\f\b\021\030$\b\013", tmp130_127, 0); Object[] tmp194_191 = new Object[10]; Object[] tmp195_194 = tmp194_191;tmp195_194[0] = Lit11; Object[] tmp201_195 = tmp195_194;tmp201_195[1] = Lit5; Object[] tmp207_201 = tmp201_195;tmp207_201[2] = Lit6; Object[] tmp213_207 = tmp207_201;tmp213_207[3] = Lit7; Object[] tmp219_213 = tmp213_207;tmp219_213[4] = Lit8; Object[] tmp225_219 = tmp219_213;tmp225_219[5] = Lit9; Object[] tmp231_225 = tmp225_219;tmp231_225[6] = Lit10; Object[] tmp238_231 = tmp231_225;tmp238_231[7] = gnu.mapping.Symbol.valueOf("<void>"); Object[] tmp247_238 = tmp238_231;tmp247_238[8] = Lit12;tmp247_238[9] = Lit10;tmp101_100[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", Lit4, 4, "DefineRecordType.scm:58"), "\001\001\001\001", "\021\030\004á\021\030\fY\t\023\b\021\030\024\021\030\034\b\003\b\021\030$\021\030\024\b\021\030,\b\013\b\021\030\fi\t\033A\021\030\024\021\030\034\b\003\0304\021\030\034\021\030<\b\021\030D\021\030\024)\021\030,\b\013\030L", tmp194_191, 0);Lit3 = new kawa.lang.SyntaxRules(Lit4, tmp100_97, 4, DefineRecordType.Lit2 = gnu.mapping.Symbol.valueOf("%define-record-field")); kawa.lang.SyntaxRule[] tmp292_289 = new kawa.lang.SyntaxRule[1]; Object[] tmp323_320 = new Object[17]; Object[] tmp324_323 = tmp323_320;tmp324_323[0] = Lit11; Object[] tmp330_324 = tmp324_323;tmp330_324[1] = gnu.mapping.Symbol.valueOf("define-class"); Object[] tmp338_330 = tmp330_324;tmp338_330[2] = gnu.expr.Keyword.make("interface"); Object[] tmp346_338 = tmp338_330;tmp346_338[3] = Boolean.FALSE; Object[] tmp352_346 = tmp346_338;tmp352_346[4] = Lit5; Object[] tmp358_352 = tmp352_346;tmp358_352[5] = gnu.lists.PairWithPosition.make(Lit6, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/DefineRecordType.scm", 167963); Object[] tmp375_358 = tmp358_352;tmp375_358[6] = Lit7; Object[] tmp382_375 = tmp375_358;tmp382_375[7] = gnu.mapping.Symbol.valueOf("<boolean>"); Object[] tmp392_382 = tmp382_375;tmp392_382[8] = gnu.mapping.Symbol.valueOf("instance?"); Object[] tmp402_392 = tmp392_382;tmp402_392[9] = Lit6; Object[] tmp409_402 = tmp402_392;tmp409_402[10] = gnu.mapping.Symbol.valueOf("let"); Object[] tmp418_409 = tmp409_402;tmp418_409[11] = Lit13; Object[] tmp425_418 = tmp418_409;tmp425_418[12] = gnu.mapping.Symbol.valueOf("make"); Object[] tmp434_425 = tmp425_418;tmp434_425[13] = Lit12; Object[] tmp441_434 = tmp434_425;tmp441_434[14] = Lit9; Object[] tmp448_441 = tmp441_434;tmp448_441[15] = gnu.lists.PairWithPosition.make(Lit13, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/DefineRecordType.scm", 188421);tmp448_441[16] = Lit2;tmp292_289[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007<\f\017\r\027\020\b\b\f\037-\f'\f/3 \030\b", Lit4, 7, "DefineRecordType.scm:34"), "\001\001\003\001\003\003\002", "\021\030\004\021\030\f\t\003\t\020\021\030\024\t\034\b%\b#¹\021\030$!\t\033\030,\021\0304\021\030<\b\021\030D\021\030L\b\003ǁ\021\030$)\t\013\b\025\023\021\0304\t\003\b\021\030Ty\b\021\030\\\021\0304\t\003\b\021\030d\b\003\021\030\004\b\025\021\030l\021\030\\)\021\030t\b\023\b\023\030|\b%\021\030\t\003\t#\t+2", tmp323_320, 1);Lit1 = new kawa.lang.SyntaxRules(Lit4, tmp292_289, 7, DefineRecordType.Lit0 = gnu.mapping.Symbol.valueOf("define-record-type"));$instance = new DefineRecordType();$Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
    $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
    $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
    $Prvt$define$Mnclass = StaticFieldLocation.make("kawa.standard.define_class", "define_class");
    
    $Prvt$instance$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "instanceOf");
    $Prvt$slot$Mnref = StaticFieldLocation.make("gnu.kawa.reflect.SlotGet", "slotRef");
    $Prvt$slot$Mnset$Ex = StaticFieldLocation.make("gnu.kawa.reflect.SlotSet", "set$Mnfield$Ex");
    $Prvt$make = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "make");
    $Prvt$quote = StaticFieldLocation.make("kawa.lang.Quote", "plainQuote");define$Mnrecord$Mntype = kawa.lang.Macro.make(Lit0, Lit1, "kawa.lib.DefineRecordType");$Prvt$$Pcdefine$Mnrecord$Mnfield = kawa.lang.Macro.make(Lit2, Lit3, "kawa.lib.DefineRecordType");$runBody$(); } static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13 = gnu.mapping.Symbol.valueOf("tmp");
  
  public DefineRecordType()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
