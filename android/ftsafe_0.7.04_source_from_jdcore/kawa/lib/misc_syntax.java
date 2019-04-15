package kawa.lib; import gnu.lists.PairWithPosition;

public class misc_syntax extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$define$Mnconstant; public static final kawa.lang.Macro provide; public static final kawa.lang.Macro test$Mnbegin; public static final kawa.lang.Macro module$Mnuri; public static final kawa.lang.Macro resource$Mnurl; public static misc_syntax $instance; static final gnu.mapping.SimpleSymbol Lit0; static final kawa.lang.SyntaxPattern Lit1; static final kawa.lang.SyntaxTemplate Lit2; static final kawa.lang.SyntaxTemplate Lit3; static final kawa.lang.SyntaxTemplate Lit4; static final kawa.lang.SyntaxPattern Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final kawa.lang.SyntaxRules Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final kawa.lang.SyntaxPattern Lit9; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; } static final gnu.mapping.SimpleSymbol Lit10; static final kawa.lang.SyntaxRules Lit11; static final Object[] Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14; static final gnu.mapping.SimpleSymbol Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final PairWithPosition Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final gnu.mapping.SimpleSymbol Lit19; static final gnu.mapping.SimpleSymbol Lit20 = gnu.mapping.Symbol.valueOf("%test-begin");
  
  static Object lambda1(Object form) {
    Object localObject1 = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(3, null); kawa.lang.TemplateScope localTemplateScope; Object localObject2; if (Lit1.match(form, arrayOfObject, 0))
    {
      localTemplateScope = kawa.lang.TemplateScope.make();
      




      localObject2 = gnu.mapping.Promise.force(std_syntax.syntaxObject$To$Datum(Lit3.execute(arrayOfObject, localTemplateScope)), gnu.mapping.Symbol.class); } try { { "%provide%" }[1] = misc.symbol$To$String((gnu.mapping.Symbol)tmp75_72);tmp45_42[0] = std_syntax.datum$To$SyntaxObject(form, misc.string$To$Symbol(strings.stringAppend({ "%provide%" }))); Object[] tmp95_45 = tmp45_42;tmp95_45[1] = Lit4.execute(arrayOfObject, localTemplateScope);{ Lit2.execute(arrayOfObject, localTemplateScope) }[1] = kawa.lang.Quote.consX$V(tmp95_45);tmpTernaryOp = kawa.lang.Quote.append$V({ Lit2.execute(arrayOfObject, localTemplateScope) });
      


      return Lit5.match(form, arrayOfObject, 0) ? prim_syntax.reportSyntaxError(form, new Object[] { "provide requires a quoted feature-name" }) : kawa.standard.syntax_case.error("syntax-case", form);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new gnu.mapping.WrongType(
      


        localClassCastException, "symbol->string", 1, localObject2);
    }
  }
  
  static
  {
    Lit19 = gnu.mapping.Symbol.valueOf("srfi-64");Lit18 = gnu.mapping.Symbol.valueOf("else");Lit17 = PairWithPosition.make(Lit19, PairWithPosition.make(gnu.mapping.Values.empty, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90142), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90133);Lit16 = gnu.mapping.Symbol.valueOf("cond-expand");Lit15 = gnu.mapping.Symbol.valueOf("begin");Lit14 = gnu.mapping.Symbol.valueOf("quasiquote");Lit13 = gnu.mapping.Symbol.valueOf("$lookup$");Lit12 = new Object[0]; kawa.lang.SyntaxRule[] tmp111_108 = new kawa.lang.SyntaxRule[1]; Object[] tmp145_142 = new Object[6]; Object[] tmp146_145 = tmp145_142;tmp146_145[0] = PairWithPosition.make(Lit13, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("gnu.kawa.io.URLPath"), gnu.lists.Pair.make(gnu.lists.Pair.make(Lit14, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("valueOf"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 163847); Object[] tmp194_146 = tmp146_145;tmp194_146[1] = Lit13; Object[] tmp200_194 = tmp194_146; gnu.mapping.SimpleSymbol tmp211_208 = gnu.mapping.Symbol.valueOf("module-uri");Lit8 = tmp211_208;tmp200_194[2] = PairWithPosition.make(Lit13, gnu.lists.Pair.make(PairWithPosition.make(tmp211_208, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 167947), gnu.lists.Pair.make(gnu.lists.Pair.make(Lit14, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("resolve"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 167947); Object[] tmp264_200 = tmp200_194;tmp264_200[3] = gnu.lists.Pair.make(gnu.lists.Pair.make(Lit14, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("toURL"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty); Object[] tmp291_264 = tmp264_200;tmp291_264[4] = gnu.lists.Pair.make(gnu.lists.Pair.make(Lit14, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("openConnection"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty);tmp291_264[5] = gnu.lists.Pair.make(gnu.lists.Pair.make(Lit14, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("getURL"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty);tmp111_108[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit12, 1, "misc_syntax.scm:39"), "\001", "\021\030\004\b\b\021\030\f\b\021\030\fa\b\021\030\f)\021\030\024\b\003\030\034\030$\030,", tmp145_142, 0);Lit11 = new kawa.lang.SyntaxRules(Lit12, tmp111_108, 1, misc_syntax.Lit10 = gnu.mapping.Symbol.valueOf("resource-url"));Lit9 = new kawa.lang.SyntaxPattern("\f\030\b", Lit12, 0, "misc_syntax.scm:33"); kawa.lang.SyntaxRule[] tmp397_394 = new kawa.lang.SyntaxRule[2]; kawa.lang.SyntaxRule[] tmp398_397 = tmp397_394; Object[] tmp431_428 = new Object[4]; Object[] tmp432_431 = tmp431_428;tmp432_431[0] = Lit15; Object[] tmp438_432 = tmp432_431; gnu.mapping.SimpleSymbol tmp514_511 = gnu.mapping.Symbol.valueOf("test-begin");Lit6 = tmp514_511;tmp438_432[1] = PairWithPosition.make(Lit16, PairWithPosition.make(Lit17, PairWithPosition.make(PairWithPosition.make(Lit18, PairWithPosition.make(PairWithPosition.make(gnu.mapping.Symbol.valueOf("import"), PairWithPosition.make(PairWithPosition.make(gnu.mapping.Symbol.valueOf("except"), PairWithPosition.make(PairWithPosition.make(gnu.mapping.Symbol.valueOf("srfi"), PairWithPosition.make(gnu.math.IntNum.valueOf(64), PairWithPosition.make(gnu.mapping.Symbol.valueOf("testing"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94251), PairWithPosition.make(tmp514_511, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94269), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94251), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94243), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94243), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94235), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94235), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94229), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 94229), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90133), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 90120); Object[] tmp621_438 = tmp438_432;tmp621_438[2] = Lit20;tmp621_438[3] = PairWithPosition.make(Boolean.FALSE, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 98336);tmp398_397[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit12, 1, "misc_syntax.scm:20"), "\001", "\021\030\004\021\030\f\b\021\030\024\t\003\030\034", tmp431_428, 0); Object[] tmp681_678 = new Object[3]; Object[] tmp682_681 = tmp681_678;tmp682_681[0] = Lit15; Object[] tmp688_682 = tmp682_681;tmp688_682[1] = PairWithPosition.make(Lit16, PairWithPosition.make(Lit17, PairWithPosition.make(PairWithPosition.make(Lit18, PairWithPosition.make(PairWithPosition.make(gnu.mapping.Symbol.valueOf("require"), PairWithPosition.make(PairWithPosition.make(gnu.mapping.Symbol.valueOf("quote"), PairWithPosition.make(Lit19, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110646), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110646), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110645), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110636), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110636), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110630), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110630), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110613), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 110600);tmp688_682[2] = Lit20;tmp398_397[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit12, 2, "misc_syntax.scm:25"), "\001\001", "\021\030\004\021\030\f\b\021\030\024\t\003\b\013", tmp681_678, 0);Lit7 = new kawa.lang.SyntaxRules(Lit12, tmp397_394, 2, Lit6);Lit5 = new kawa.lang.SyntaxPattern("\f\030\003", Lit12, 1, "misc_syntax.scm:15");Lit4 = new kawa.lang.SyntaxTemplate("\001\001\001", "\030\004", new Object[] { gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("::"), PairWithPosition.make(gnu.mapping.Symbol.valueOf("int"), PairWithPosition.make(gnu.math.IntNum.valueOf(123), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 57360), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm", 57356)) }, 0);Lit3 = new kawa.lang.SyntaxTemplate("\001\001\001", "\023", Lit12, 0);Lit2 = new kawa.lang.SyntaxTemplate("\001\001\001", "\030\004", new Object[] { gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("define-constant"), gnu.lists.LList.Empty) }, 0);Lit1 = new kawa.lang.SyntaxPattern("\f\007,\f\017\f\027\b\b", Lit12, 3, "misc_syntax.scm:5");Lit0 = gnu.mapping.Symbol.valueOf("provide");$instance = new misc_syntax();$Prvt$define$Mnconstant = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");misc_syntax localMisc_syntax1 = $instance;provide = kawa.lang.Macro.make(Lit0, new gnu.expr.ModuleMethod(localMisc_syntax1, 1, null, 4097), "kawa.lib.misc_syntax");test$Mnbegin = kawa.lang.Macro.make(Lit6, Lit7, "kawa.lib.misc_syntax");
    




























    misc_syntax localMisc_syntax2 = $instance; void tmp1080_1077 = new gnu.expr.ModuleMethod(localMisc_syntax2, 2, null, 4097);tmp1080_1077.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/misc_syntax.scm:31");module$Mnuri = kawa.lang.Macro.make(Lit8, tmp1080_1077, "kawa.lib.misc_syntax");resource$Mnurl = kawa.lang.Macro.make(Lit10, Lit11, "kawa.lib.misc_syntax");$runBody$(); } public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { switch (selector) {case 2:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; case 1:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject) { switch (selector) {case 1:  return lambda1(paramObject); case 2:  return lambda2(paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  static Object lambda2(Object form) { Object localObject = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(0, null);
    

    return Lit9.match(form, arrayOfObject, 0) ? gnu.kawa.functions.GetModuleClass.getModuleClassURI(gnu.expr.Compilation.getCurrent()) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
  public misc_syntax()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
}
