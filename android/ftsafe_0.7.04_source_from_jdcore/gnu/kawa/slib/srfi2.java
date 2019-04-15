package gnu.kawa.slib; import kawa.lang.SyntaxTemplate;

public class srfi2 extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$and; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$let; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$begin; public static final kawa.lang.Macro and$Mnlet$St; public static srfi2 $instance; static final gnu.mapping.SimpleSymbol Lit0; static final kawa.lang.SyntaxPattern Lit1; static final SyntaxTemplate Lit2; static final kawa.lang.SyntaxPattern Lit3; static final SyntaxTemplate Lit4; static final kawa.lang.SyntaxPattern Lit5; static final SyntaxTemplate Lit6; static final kawa.lang.SyntaxPattern Lit7; static final SyntaxTemplate Lit8; static final SyntaxTemplate Lit9; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; } static final SyntaxTemplate Lit10; static final kawa.lang.SyntaxPattern Lit11; static final SyntaxTemplate Lit12; static final kawa.lang.SyntaxPattern Lit13; static final SyntaxTemplate Lit14; static final kawa.lang.SyntaxPattern Lit15; static final SyntaxTemplate Lit16; static { Lit23 = gnu.mapping.Symbol.valueOf("and");(srfi2.Lit22 = new Object[1])[0] = Lit23;Lit21 = new Object[0];Lit20 = new SyntaxTemplate("\001", "\004", new Object[] { Boolean.TRUE }, 0);Lit19 = new kawa.lang.SyntaxPattern("\f\007\f\b\b", Lit21, 1, "srfi2.scm:24");Lit18 = new SyntaxTemplate("\001\001\000", "\013", Lit21, 0);Lit17 = new SyntaxTemplate("\001\001\000", "\021\030\004\t\013\b\t\003\b\022", Lit22, 0);Lit16 = new SyntaxTemplate("\001\001\000", "\013", Lit21, 0);Lit15 = new kawa.lang.SyntaxPattern("\f\007\034\f\017\023\b", Lit21, 3, "srfi2.scm:20");Lit14 = new SyntaxTemplate("\001\001\000", "\021\030\004\t\013\b\t\003\b\022", Lit22, 0);Lit13 = new kawa.lang.SyntaxPattern("\f\007,\034\f\017\b\023\b", Lit21, 3, "srfi2.scm:18"); Object[] tmp213_210 = new Object[2]; Object[] tmp214_213 = tmp213_210;tmp214_213[0] = Lit24;tmp214_213[1] = Lit23;Lit12 = new SyntaxTemplate("\001\001\001\000", "\021\030\004)\b\t\013\b\023\b\021\030\f\t\013\b\t\003\b\032", tmp213_210, 0);Lit11 = new kawa.lang.SyntaxPattern("\f\007<,\f\017\f\027\b\033\b", Lit21, 4, "srfi2.scm:15");Lit10 = new SyntaxTemplate("\001\001", "\013", Lit21, 0);Lit9 = new SyntaxTemplate("\001\001", "\013", Lit21, 0);Lit8 = new SyntaxTemplate("\001\001", "\013", Lit21, 0);Lit7 = new kawa.lang.SyntaxPattern("\f\007\034\f\017\b\b", Lit21, 2, "srfi2.scm:11");Lit6 = new SyntaxTemplate("\001\001", "\013", Lit21, 0);Lit5 = new kawa.lang.SyntaxPattern("\f\007,\034\f\017\b\b\b", Lit21, 2, "srfi2.scm:9");Lit4 = new SyntaxTemplate("\001\001\001", "\021\030\004)\b\t\013\b\023\b\013", new Object[] { Lit24 }, 0);Lit3 = new kawa.lang.SyntaxPattern("\f\007<,\f\017\f\027\b\b\b", Lit21, 3, "srfi2.scm:7");Lit2 = new SyntaxTemplate("\001\003\001\000", "\t\003\b\021\r\013\b\b\021\030\004\t\023\032", new Object[] { gnu.mapping.Symbol.valueOf("begin") }, 1);Lit1 = new kawa.lang.SyntaxPattern("\f\007,\r\017\b\b\b\f\027\033", Lit21, 4, "srfi2.scm:5");Lit0 = gnu.mapping.Symbol.valueOf("and-let*");$instance = new srfi2();$Prvt$and = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "and");$Prvt$let = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "let");$Prvt$begin = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.begin", "begin");srfi2 localSrfi2 = $instance;and$Mnlet$St = kawa.lang.Macro.make(Lit0, new gnu.expr.ModuleMethod(localSrfi2, 1, null, 4097), "gnu.kawa.slib.srfi2");$runBody$(); } static final SyntaxTemplate Lit17; static final SyntaxTemplate Lit18; static final kawa.lang.SyntaxPattern Lit19; static final SyntaxTemplate Lit20; static final Object[] Lit21; static final Object[] Lit22; static final gnu.mapping.SimpleSymbol Lit23; static final gnu.mapping.SimpleSymbol Lit24 = gnu.mapping.Symbol.valueOf("let");
  
  static Object lambda1(Object form) {
    Object localObject = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(4, null);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();
    localTemplateScope = kawa.lang.TemplateScope.make();
    localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();
    

    localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();
    localTemplateScope = kawa.lang.TemplateScope.make();
    localTemplateScope = kawa.lang.TemplateScope.make();
    
    localTemplateScope = kawa.lang.TemplateScope.make();return Lit19.match(form, arrayOfObject, 0) ? Lit20.execute(arrayOfObject, localTemplateScope) : Lit15.match(form, arrayOfObject, 0) ? kawa.lib.prim_syntax.reportSyntaxError(Lit18.execute(arrayOfObject, localTemplateScope), new Object[] { "expected a variable name" }) : kawa.lib.std_syntax.isIdentifier(Lit16.execute(arrayOfObject, localTemplateScope)) ? Lit17.execute(arrayOfObject, localTemplateScope) : Lit13.match(form, arrayOfObject, 0) ? Lit14.execute(arrayOfObject, localTemplateScope) : Lit11.match(form, arrayOfObject, 0) ? Lit12.execute(arrayOfObject, localTemplateScope) : Lit7.match(form, arrayOfObject, 0) ? kawa.lib.prim_syntax.reportSyntaxError(Lit10.execute(arrayOfObject, localTemplateScope), new Object[] { "expected a variable name" }) : kawa.lib.std_syntax.isIdentifier(Lit8.execute(arrayOfObject, localTemplateScope)) ? Lit9.execute(arrayOfObject, localTemplateScope) : Lit5.match(form, arrayOfObject, 0) ? Lit6.execute(arrayOfObject, localTemplateScope) : Lit3.match(form, arrayOfObject, 0) ? Lit4.execute(arrayOfObject, localTemplateScope) : Lit1.match(form, arrayOfObject, 0) ? Lit2.execute(arrayOfObject, localTemplateScope) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  
  public srfi2()
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
