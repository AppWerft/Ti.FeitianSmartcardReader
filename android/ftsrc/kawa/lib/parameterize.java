package kawa.lib; import gnu.mapping.Symbol;

public class parameterize extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$as$Mnlocation$Pc; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$begin; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$quasiquote; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$let$St; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$try$Mnfinally; public static final kawa.lang.Macro parameterize$Pc; public static final kawa.lang.Macro parameterize; public static parameterize $instance; static final gnu.mapping.SimpleSymbol Lit0; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; } static final kawa.lang.SyntaxRules Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final kawa.lang.SyntaxRules Lit3; static final Object[] Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11 = Symbol.valueOf("save"); static { Lit10 = Symbol.valueOf("quasiquote");Lit9 = Symbol.valueOf("gnu.mapping.Location");Lit8 = Symbol.valueOf("$lookup$");Lit7 = Symbol.valueOf("v");Lit6 = Symbol.valueOf("p");Lit5 = Symbol.valueOf("begin");Lit4 = new Object[0]; kawa.lang.SyntaxRule[] tmp74_71 = new kawa.lang.SyntaxRule[2]; kawa.lang.SyntaxRule[] tmp75_74 = tmp74_71;tmp75_74[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\b\003", Lit4, 1, "parameterize.scm:22"), "\000", "\021\030\004\002", new Object[] { Lit5 }, 0); Object[] tmp143_140 = new Object[1]; gnu.mapping.SimpleSymbol tmp150_147 = Symbol.valueOf("parameterize%");Lit0 = tmp150_147;tmp143_140[0] = tmp150_147;tmp75_74[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<,\f\007\f\017\b\023\033", Lit4, 4, "parameterize.scm:24"), "\001\001\000\000", "\021\030\0041!\t\003\b\013\022\t\020\032", tmp143_140, 0);Lit3 = new kawa.lang.SyntaxRules(Lit4, tmp74_71, 4, parameterize.Lit2 = Symbol.valueOf("parameterize")); kawa.lang.SyntaxRule[] tmp187_184 = new kawa.lang.SyntaxRule[2]; kawa.lang.SyntaxRule[] tmp188_187 = tmp187_184; Object[] tmp217_214 = new Object[2]; Object[] tmp218_217 = tmp217_214;tmp218_217[0] = Symbol.valueOf("try-finally");tmp218_217[1] = Lit5;tmp188_187[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\b\f\007\013", Lit4, 2, "parameterize.scm:8"), "\001\000", "\021\030\004!\021\030\f\n\b\021\030\f\003", tmp217_214, 0); Object[] tmp265_262 = new Object[9]; Object[] tmp266_265 = tmp265_262;tmp266_265[0] = Symbol.valueOf("let*"); Object[] tmp274_266 = tmp266_265;tmp274_266[1] = Lit6; Object[] tmp280_274 = tmp274_266;tmp280_274[2] = Symbol.valueOf("::"); Object[] tmp288_280 = tmp280_274;tmp288_280[3] = Symbol.valueOf("<gnu.mapping.Location>"); Object[] tmp296_288 = tmp288_280;tmp296_288[4] = Symbol.valueOf("as-location%"); Object[] tmp304_296 = tmp296_288;tmp304_296[5] = Lit7; Object[] tmp310_304 = tmp304_296;tmp310_304[6] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit11, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit8, gnu.lists.Pair.make(Lit9, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit10, gnu.lists.Pair.make(Symbol.valueOf("setWithSave"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61453), gnu.lists.PairWithPosition.make(Lit6, gnu.lists.PairWithPosition.make(Lit7, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61488), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61486), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61452), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61452), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61446), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 61446); Object[] tmp413_310 = tmp310_304;tmp413_310[7] = Lit0;tmp413_310[8] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit8, gnu.lists.Pair.make(Lit9, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit10, gnu.lists.Pair.make(Symbol.valueOf("setRestore"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 69643), gnu.lists.PairWithPosition.make(Lit6, gnu.lists.PairWithPosition.make(Lit11, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 69677), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 69675), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/parameterize.scm", 69642);tmp188_187[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030<,\f\007\f\017\b\023\f\037#", Lit4, 5, "parameterize.scm:12"), "\001\001\000\001\000", "\021\030\004Áy\021\030\f\021\030\024\021\030\034\b\021\030$\b\003)\021\030,\b\013\0304\b\021\030<\t\022!\021\030D\033\"", tmp265_262, 0);Lit1 = new kawa.lang.SyntaxRules(Lit4, tmp187_184, 5, Lit0);$instance = new parameterize();$Prvt$as$Mnlocation$Pc = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.parameters", "as$Mnlocation$Pc");
    $Prvt$begin = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.begin", "begin");$Prvt$quasiquote = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lang.Quote", "quasiQuote");
    $Prvt$let$St = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
    $Prvt$try$Mnfinally = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.syntax", "try$Mnfinally");parameterize$Pc = kawa.lang.Macro.make(Lit0, Lit1, "kawa.lib.parameterize");parameterize = kawa.lang.Macro.make(Lit2, Lit3, "kawa.lib.parameterize");$runBody$();
  }
  
  public parameterize()
  {
    gnu.expr.ModuleInfo.register(this);
  }
}
