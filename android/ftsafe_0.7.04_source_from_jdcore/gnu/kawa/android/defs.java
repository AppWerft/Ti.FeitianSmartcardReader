package gnu.kawa.android; import kawa.lang.SyntaxTemplate;

public class defs extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation current$Mnactivity; public static final Class Button; public static final Class EditText; public static final Class ImageView; public static final Class LinearLayout; public static final Class ScrollView; public static final Class TextView; public static final Class View; public static final kawa.lang.Macro activity; @gnu.expr.SourceName(name="android.view.View", uri="gnu.kawa.reflect/ObjectBuilder")
  public static final String android$Dtview$DtView; static final kawa.lang.SyntaxPattern Lit0; static final SyntaxTemplate Lit1; static final SyntaxTemplate Lit2; static final kawa.lang.SyntaxPattern Lit3; static final SyntaxTemplate Lit4; static final SyntaxTemplate Lit5; static final kawa.lang.SyntaxPattern Lit6; static final SyntaxTemplate Lit7; static final SyntaxTemplate Lit8; static final kawa.lang.SyntaxPattern Lit9; public static defs $instance; static final gnu.mapping.SimpleSymbol Lit10; static final kawa.lang.SyntaxPattern Lit11; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; } static final SyntaxTemplate Lit12; static final SyntaxTemplate Lit13; static final SyntaxTemplate Lit14; static final Object[] Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final gnu.mapping.SimpleSymbol Lit19; static final gnu.lists.PairWithPosition Lit20; static final gnu.lists.PairWithPosition Lit21; static final gnu.mapping.SimpleSymbol Lit22; static final gnu.lists.PairWithPosition Lit23; static final gnu.mapping.SimpleSymbol Lit24; static final gnu.lists.PairWithPosition Lit25 = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("current-activity"), gnu.lists.PairWithPosition.make(defs.Lit20 = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("this"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106542), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110641), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110623), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 110622);
  












  static Object $PcProcessActivity(Object form)
  {
    Object localObject = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(3, null);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();
    


    localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();
    



    localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();localTemplateScope = kawa.lang.TemplateScope.make();return Lit9.match(form, arrayOfObject, 0) ? gnu.lists.LList.Empty : Lit6.match(form, arrayOfObject, 0) ? kawa.lib.lists.cons(Lit7.execute(arrayOfObject, localTemplateScope), $PcProcessActivity(Lit8.execute(arrayOfObject, localTemplateScope))) : Lit3.match(form, arrayOfObject, 0) ? kawa.lib.lists.cons(Lit4.execute(arrayOfObject, localTemplateScope), $PcProcessActivity(Lit5.execute(arrayOfObject, localTemplateScope))) : Lit0.match(form, arrayOfObject, 0) ? kawa.lib.lists.cons(Lit1.execute(arrayOfObject, localTemplateScope), $PcProcessActivity(Lit2.execute(arrayOfObject, localTemplateScope))) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
  static Object lambda1(Object form) {
    Object localObject = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(3, null);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();
    return Lit11.match(form, arrayOfObject, 0) ? kawa.lang.Quote.append$V(new Object[] { Lit12.execute(arrayOfObject, localTemplateScope), kawa.lang.Quote.append$V(new Object[] {$PcProcessActivity(Lit13.execute(arrayOfObject, localTemplateScope)), Lit14.execute(arrayOfObject, localTemplateScope) }) }) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
  static
  {
    Lit24 = gnu.mapping.Symbol.valueOf("parameterize");Lit23 = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("invoke-special"), gnu.lists.PairWithPosition.make(defs.Lit17 = gnu.mapping.Symbol.valueOf("android.app.Activity"), gnu.lists.PairWithPosition.make(Lit20, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("quote"), gnu.lists.PairWithPosition.make(defs.Lit18 = gnu.mapping.Symbol.valueOf("onCreate"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106550), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106550), gnu.lists.PairWithPosition.make(defs.Lit19 = gnu.mapping.Symbol.valueOf("savedInstanceState"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106559), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106549), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106542), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106521), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 106505);Lit22 = gnu.mapping.Symbol.valueOf("void");Lit21 = gnu.lists.PairWithPosition.make(Lit18, gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit19, gnu.lists.PairWithPosition.make(defs.Lit16 = gnu.mapping.Symbol.valueOf("::"), gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("android.os.Bundle"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102449), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102446), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102426), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102426), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 102416);Lit15 = new Object[0];Lit14 = new SyntaxTemplate("\001\001\000", "\020", Lit15, 0);Lit13 = new SyntaxTemplate("\001\001\000", "\022", Lit15, 0); Object[] tmp302_299 = new Object[2]; Object[] tmp303_302 = tmp302_299;tmp303_302[0] = gnu.mapping.Symbol.valueOf("define-simple-class");tmp303_302[1] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit17, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 155680), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 155680);Lit12 = new SyntaxTemplate("\001\001\000", "\021\030\004\t\013\030\f", tmp302_299, 0);Lit11 = new kawa.lang.SyntaxPattern("\f\007\f\017\023", Lit15, 3, "defs.scm:37");Lit10 = gnu.mapping.Symbol.valueOf("activity");Lit9 = new kawa.lang.SyntaxPattern("\b", Lit15, 0, "defs.scm:33");Lit8 = new SyntaxTemplate("\001\000", "\n", Lit15, 0);Lit7 = new SyntaxTemplate("\001\000", "\003", Lit15, 0);Lit6 = new kawa.lang.SyntaxPattern("\f\007\013", Lit15, 2, "defs.scm:31");Lit5 = new SyntaxTemplate("\003\001\000", "\022", Lit15, 0); Object[] tmp490_487 = new Object[7]; Object[] tmp491_490 = tmp490_487;tmp491_490[0] = Lit21; Object[] tmp497_491 = tmp491_490;tmp497_491[1] = Lit16; Object[] tmp503_497 = tmp497_491;tmp503_497[2] = Lit22; Object[] tmp509_503 = tmp503_497;tmp509_503[3] = Lit23; Object[] tmp515_509 = tmp509_503;tmp515_509[4] = Lit24; Object[] tmp521_515 = tmp515_509;tmp521_515[5] = Lit25;tmp521_515[6] = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("$lookup$"), gnu.lists.Pair.make(Lit20, gnu.lists.Pair.make(gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("quasiquote"), gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("setContentView"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/android/defs.scm", 118815);Lit4 = new SyntaxTemplate("\003\001\000", "\021\030\004\021\030\f\021\030\024\021\030\034\b\021\030$\021\030,\021\005\003\b\021\0304\b\013", tmp490_487, 1);Lit3 = new kawa.lang.SyntaxPattern("T\f\002\r\007\000\b\026\f\017\b\023", new Object[] { gnu.mapping.Symbol.valueOf("on-create-view") }, 3, "defs.scm:24");Lit2 = new SyntaxTemplate("\003\000", "\n", Lit15, 0); Object[] tmp649_646 = new Object[6]; Object[] tmp650_649 = tmp649_646;tmp650_649[0] = Lit21; Object[] tmp656_650 = tmp650_649;tmp656_650[1] = Lit16; Object[] tmp662_656 = tmp656_650;tmp662_656[2] = Lit22; Object[] tmp668_662 = tmp662_656;tmp668_662[3] = Lit23; Object[] tmp674_668 = tmp668_662;tmp674_668[4] = Lit24;tmp674_668[5] = Lit25;Lit1 = new SyntaxTemplate("\003\000", "\021\030\004\021\030\f\021\030\024\021\030\034\b\021\030$\021\030,\b\005\003", tmp649_646, 1);Lit0 = new kawa.lang.SyntaxPattern("<\f\002\r\007\000\b\b\013", new Object[] { gnu.mapping.Symbol.valueOf("on-create") }, 2, "defs.scm:18");View = android.view.View.class;TextView = android.widget.TextView.class;ScrollView = android.widget.ScrollView.class;LinearLayout = android.widget.LinearLayout.class;ImageView = android.widget.ImageView.class;EditText = android.widget.EditText.class;Button = android.widget.Button.class;$instance = new defs();current$Mnactivity = gnu.kawa.reflect.StaticFieldLocation.make("gnu.kawa.android.utils", "current$Mnactivity");
    
    defs localDefs = $instance;activity = kawa.lang.Macro.make(Lit10, new gnu.expr.ModuleMethod(localDefs, 1, null, 4097), "gnu.kawa.android.defs");
    





































    android$Dtview$DtView = "gnu.kawa.android.ViewBuilder";$runBody$();
  }
  
  public defs()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    if (selector == 1)
    {
      value1 = paramObject;
      proc = paramModuleMethod;
      pc = 1;
      return 0;
    }
    return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (selector == 1) {
      return lambda1(paramObject);
    }
    return super.apply1(paramModuleMethod, paramObject);
  }
}
