package kawa.lib.kawa; import gnu.expr.ModuleMethod;

public class expressions extends gnu.expr.ModuleBody { public static final ModuleMethod $Mn$Grexp; public static final ModuleMethod get$Mnvisitor; public static final ModuleMethod get$Mncompilation; public static final ModuleMethod visit$Mnexp; public static final kawa.lang.Macro syntax$Mnas$Mnexp; public static final kawa.lang.Macro define$Mnvalidate; public static final ModuleMethod apply$Mnexp; public static final ModuleMethod begin$Mnexp; public static final ModuleMethod if$Mnexp; public static final ModuleMethod set$Mnexp; public static final ModuleMethod apply$Mnto$Mnargs$Mnexp; public static final Class Declaration; public static final Class Expression; public static final Class ApplyExp; public static final Class QuoteExp; public static final Class ReferenceExp; public static final Class Compilation; public static final Class Type; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$define; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$cond; public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$let; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$else;
  static final gnu.bytecode.ClassType Lit0;
  public static expressions $instance;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final kawa.lang.SyntaxPattern Lit6;
  static final kawa.lang.SyntaxTemplate Lit7;
  static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final kawa.lang.SyntaxRules Lit14; static final Object[] Lit15; static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final gnu.lists.PairWithPosition Lit18;
  static { Lit22 = gnu.mapping.Symbol.valueOf("$lookup$");Lit21 = gnu.mapping.Symbol.valueOf("else");Lit20 = gnu.mapping.Symbol.valueOf("visitor");Lit19 = gnu.mapping.Symbol.valueOf("eq?");Lit18 = gnu.lists.PairWithPosition.make(null, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340017);Lit17 = gnu.mapping.Symbol.valueOf("ex");Lit16 = gnu.mapping.Symbol.valueOf("::");Lit15 = new Object[0]; kawa.lang.SyntaxRule[] tmp96_93 = new kawa.lang.SyntaxRule[1]; Object[] tmp130_127 = new Object[20]; Object[] tmp131_130 = tmp130_127;tmp131_130[0] = gnu.mapping.Symbol.valueOf("define"); Object[] tmp139_131 = tmp131_130;tmp139_131[1] = Lit16; Object[] tmp145_139 = tmp139_131;tmp145_139[2] = gnu.mapping.Symbol.valueOf("gnu.expr.ApplyExp"); Object[] tmp154_145 = tmp145_139;tmp154_145[3] = Lit20; Object[] tmp160_154 = tmp154_145;tmp160_154[4] = gnu.mapping.Symbol.valueOf("gnu.expr.InlineCalls"); Object[] tmp169_160 = tmp160_154;tmp169_160[5] = gnu.mapping.Symbol.valueOf("gnu.bytecode.Type"); Object[] tmp178_169 = tmp169_160;tmp178_169[6] = gnu.lists.PairWithPosition.make(Lit16, gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("gnu.mapping.Procedure"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 331797), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 331795); Object[] tmp212_178 = tmp178_169;tmp212_178[7] = gnu.mapping.Symbol.valueOf("gnu.expr.Expression"); Object[] tmp222_212 = tmp212_178;tmp222_212[8] = gnu.mapping.Symbol.valueOf("let"); Object[] tmp231_222 = tmp222_212;tmp231_222[9] = Lit17; Object[] tmp238_231 = tmp231_222;tmp238_231[10] = gnu.mapping.Symbol.valueOf("cond"); Object[] tmp247_238 = tmp238_231;tmp247_238[11] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit21, Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340011), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340011); Object[] tmp278_247 = tmp247_238;tmp278_247[12] = gnu.lists.PairWithPosition.make(gnu.lists.PairWithPosition.make(Lit19, gnu.lists.PairWithPosition.make(Lit17, Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344093), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344088), Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344087); Object[] tmp321_278 = tmp278_247;tmp321_278[13] = Lit19; Object[] tmp328_321 = tmp321_278;tmp328_321[14] = Lit22; Object[] tmp335_328 = tmp328_321;tmp335_328[15] = gnu.lists.Pair.make(gnu.lists.Pair.make(Lit23, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("visitArgs"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty); Object[] tmp363_335 = tmp335_328;tmp363_335[16] = gnu.lists.PairWithPosition.make(Lit20, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 356391); Object[] tmp382_363 = tmp363_335;tmp382_363[17] = Lit21; Object[] tmp389_382 = tmp382_363;tmp389_382[18] = gnu.lists.PairWithPosition.make(Lit22, gnu.lists.Pair.make(Lit20, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit23, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("visit"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 368665);tmp389_382[19] = gnu.lists.PairWithPosition.make(Lit22, gnu.lists.Pair.make(Lit17, gnu.lists.Pair.make(gnu.lists.Pair.make(Lit23, gnu.lists.Pair.make(gnu.mapping.Symbol.valueOf("maybeSetLine"), gnu.lists.LList.Empty)), gnu.lists.LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 368680);tmp96_93[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007<\f\017\f\027\f\037\b\r' \b\b", Lit15, 5, "expressions.scm:76"), "\001\001\001\001\003", "\021\030\004ù\t\003\t\013\021\030\f\021\030\024\021\030\034\021\030\f\021\030$\t\023\021\030\f\021\030,\t\033\0304\021\030\f\021\030<\b\021\030D\b\021\030L\021\030\f\021\030<\b\021\030T\021%#\030\\\b\021\030T\021\030d±A\021\030l\021\030L\b\013Q9\021\030t\t\013\030|\030\b\013\b\021\030\b\021\030)\021\030\b\013\b\023", tmp130_127, 1);Lit14 = new kawa.lang.SyntaxRules(Lit15, tmp96_93, 5, expressions.Lit13 = gnu.mapping.Symbol.valueOf("define-validate"));Lit12 = gnu.mapping.Symbol.valueOf("set-exp");Lit11 = gnu.mapping.Symbol.valueOf("if-exp");Lit10 = gnu.mapping.Symbol.valueOf("begin-exp");Lit9 = gnu.mapping.Symbol.valueOf("apply-to-args-exp");Lit8 = gnu.mapping.Symbol.valueOf("apply-exp");Lit7 = new kawa.lang.SyntaxTemplate("\001", "\003", Lit15, 0);Lit6 = new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit15, 1, "expressions.scm:41");Lit5 = gnu.mapping.Symbol.valueOf("syntax-as-exp");Lit4 = gnu.mapping.Symbol.valueOf("visit-exp");Lit3 = gnu.mapping.Symbol.valueOf("get-compilation");Lit2 = gnu.mapping.Symbol.valueOf("get-visitor");Lit1 = gnu.mapping.Symbol.valueOf("->exp");Lit0 = gnu.bytecode.ClassType.make("gnu.expr.Expression");Type = gnu.bytecode.Type.class;Compilation = gnu.expr.Compilation.class;ReferenceExp = gnu.expr.ReferenceExp.class;QuoteExp = gnu.expr.QuoteExp.class;ApplyExp = gnu.expr.ApplyExp.class;Expression = gnu.expr.Expression.class;Declaration = gnu.expr.Declaration.class;$instance = new expressions();$Prvt$define = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
    $Prvt$cond = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "cond");$Prvt$let = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "let");$Prvt$else = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "else");expressions localExpressions1 = $instance;$Mn$Grexp = new ModuleMethod(localExpressions1, 1, Lit1, 4097);get$Mnvisitor = new ModuleMethod(localExpressions1, 2, Lit2, 0);get$Mncompilation = new ModuleMethod(localExpressions1, 3, Lit3, 0);visit$Mnexp = new ModuleMethod(localExpressions1, 4, Lit4, 8193);
    




















    expressions localExpressions2 = $instance; void tmp820_817 = new ModuleMethod(localExpressions2, 6, null, 4097);tmp820_817.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm:39");syntax$Mnas$Mnexp = kawa.lang.Macro.make(Lit5, tmp820_817, "kawa.lib.kawa.expressions");apply$Mnexp = new ModuleMethod(localExpressions1, 7, Lit8, 61441);apply$Mnto$Mnargs$Mnexp = new ModuleMethod(localExpressions1, 8, Lit9, 61441);begin$Mnexp = new ModuleMethod(localExpressions1, 9, Lit10, 61440);if$Mnexp = new ModuleMethod(localExpressions1, 10, Lit11, 12290);set$Mnexp = new ModuleMethod(localExpressions1, 12, Lit12, 8194);define$Mnvalidate = kawa.lang.Macro.make(Lit13, Lit14, "kawa.lib.kawa.expressions");$runBody$(); } static final gnu.mapping.SimpleSymbol Lit19; static final gnu.mapping.SimpleSymbol Lit20; static final gnu.mapping.SimpleSymbol Lit21; static final gnu.mapping.SimpleSymbol Lit22; static final gnu.mapping.SimpleSymbol Lit23 = gnu.mapping.Symbol.valueOf("quasiquote");
  



















  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 6:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 4: 
      Object tmp68_65 = gnu.mapping.Promise.force(paramObject, gnu.expr.Expression.class);
      































      if (!(tmp68_65 instanceof gnu.expr.Expression)) return -786431; value1 = tmp68_65;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }
  

  public static gnu.expr.Expression $To$Exp(Object obj)
  {
    return (obj instanceof gnu.expr.Declaration) ? new gnu.expr.ReferenceExp((gnu.expr.Declaration)gnu.mapping.Promise.force(obj, gnu.expr.Declaration.class)) : (obj instanceof gnu.expr.Expression) ? (gnu.expr.Expression)gnu.mapping.Promise.force(obj, gnu.expr.Expression.class) : gnu.expr.QuoteExp.getInstance(obj);
  }
  
  public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 3:  proc = paramModuleMethod;pc = 0;return 0;
    case 2: 
      proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); }
  public static gnu.expr.InlineCalls getVisitor() { return (gnu.expr.InlineCalls)gnu.expr.InlineCalls.currentVisitor.get();
  }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (selector) {case 2:  return getVisitor();
    
    case 3: 
      return getCompilation(); } return super.apply0(paramModuleMethod); }
  public static gnu.expr.Compilation getCompilation() { return getVisitor().getCompilation(); }
  































  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 12:  Object tmp48_45 = gnu.mapping.Promise.force(paramObject1, gnu.expr.Declaration.class);
      
































































      if (!(tmp48_45 instanceof gnu.expr.Declaration)) return -786431; value1 = tmp48_45;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 10: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 4: 
      Object tmp116_113 = gnu.mapping.Promise.force(paramObject1, gnu.expr.Expression.class);
      































      if (!(tmp116_113 instanceof gnu.expr.Expression)) return -786431; value1 = tmp116_113; Object tmp139_136 = gnu.mapping.Promise.force(paramObject2, gnu.bytecode.Type.class); if (!(tmp139_136 instanceof gnu.bytecode.Type)) return -786430; value2 = tmp139_136;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }
  
  public static gnu.expr.Expression visitExp(gnu.expr.Expression exp, gnu.bytecode.Type required) { return getVisitor().visit(exp, required);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return $To$Exp(paramObject);
    }
    
    








    try
    {
      return visitExp((gnu.expr.Expression)gnu.mapping.Promise.force(paramObject, gnu.expr.Expression.class)); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(
      




        localClassCastException, "visit-exp", 1, paramObject); } return lambda1(paramObject);return super.apply1(paramModuleMethod, paramObject); }
  static Object lambda1(Object form) { Object localObject = form;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(1, null);
    
    kawa.lang.TemplateScope localTemplateScope = kawa.lang.TemplateScope.make();return Lit6.match(form, arrayOfObject, 0) ? kawa.lang.SyntaxForms.rewrite(Lit7.execute(arrayOfObject, localTemplateScope)) : kawa.standard.syntax_case.error("syntax-case", form);
  }
  












  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 9:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 8: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 7: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); } public static gnu.expr.ApplyExp applyExp$V(Object func, Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList args = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    int i = 2;gnu.expr.Expression localExpression = $To$Exp(func);
    Object localObject = gnu.kawa.functions.Map.map1($Mn$Grexp, args); int j; i = (j = gnu.kawa.functions.MakeSplice.count(localObject)) + i;int k = 2;gnu.kawa.functions.MakeSplice.copyTo(new Object[] { ApplyExp, localExpression }, k, j, localObject);k += j;return (gnu.expr.ApplyExp)gnu.mapping.Promise.force(gnu.kawa.reflect.Invoke.make.applyN(tmp54_49), gnu.expr.ApplyExp.class); }
  
  public static Object applyToArgsExp$V(Object func, Object[] argsArray) { gnu.lists.LList localLList1;
    gnu.lists.LList args = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    gnu.expr.Expression fexp = $To$Exp(func);
    gnu.expr.Compilation comp = getCompilation();
    gnu.expr.Expression applyFunction = comp.applyFunction(fexp);
    
    int i = 2;gnu.expr.Expression localExpression1 = $To$Exp(func);
    Object localObject = gnu.kawa.functions.Map.map1($Mn$Grexp, args); int j; i = (j = gnu.kawa.functions.MakeSplice.count(localObject)) + i;int k = 2;gnu.kawa.functions.MakeSplice.copyTo(new Object[] { ApplyExp, localExpression1 }, k, j, localObject);k += j;
    i = 3;localExpression1 = $To$Exp(func);
    localObject = gnu.kawa.functions.Map.map1($Mn$Grexp, args);i = (j = gnu.kawa.functions.MakeSplice.count(localObject)) + i;k = 3;gnu.kawa.functions.MakeSplice.copyTo(new Object[] { ApplyExp, applyFunction, localExpression1 }, k, j, localObject);k += j;return applyFunction == null ? gnu.kawa.reflect.Invoke.make.applyN(tmp81_76) : gnu.kawa.reflect.Invoke.make.applyN(tmp162_157); }
  
  public static gnu.expr.BeginExp beginExp$V(Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList args = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    int i = 0;
    Object localObject = gnu.kawa.functions.Map.map1($Mn$Grexp, args); int j; i = (j = gnu.kawa.functions.MakeSplice.count(localObject)) + i; gnu.expr.Expression[] tmp36_33 = new gnu.expr.Expression[i];int k = 0;gnu.kawa.functions.MakeSplice.copyTo(tmp36_33, k, j, localObject, Lit0);k += j;return new gnu.expr.BeginExp(tmp36_33); }
  
  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, gnu.mapping.CallContext paramCallContext) { if (selector == 10) { value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0; } return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext); } public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3) { if (selector == 10) return ifExp(paramObject1, paramObject2, paramObject3); return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3); }
  public static gnu.expr.IfExp ifExp(Object a, Object b, Object c) { if (c == null) {} try { tmpTernaryOp = ((gnu.expr.Expression)(localObject = gnu.mapping.Promise.force(c, gnu.expr.Expression.class)));return new gnu.expr.IfExp($To$Exp(a), $To$Exp(b), $To$Exp(c)); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "gnu.expr.IfExp.<init>(gnu.expr.Expression,gnu.expr.Expression,gnu.expr.Expression)", 3, localObject);
    } }
  
  public static gnu.expr.SetExp setExp(gnu.expr.Declaration var, Object val) { gnu.expr.SetExp se = new gnu.expr.SetExp(var, $To$Exp(val));
    se.setContextDecl(var);
    var.setCanWrite(true);
    se.setBinding(var);
    var.noteValueFromSet(se);
    return se;
  }
  
  public static gnu.expr.Expression visitExp(gnu.expr.Expression paramExpression)
  {
    return visitExp(paramExpression, null);
  }
  
  public static gnu.expr.IfExp ifExp(Object paramObject1, Object paramObject2)
  {
    return ifExp(paramObject1, paramObject2, null);
  }
  
  public expressions()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 354	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+79->83, 4:+36->40, 10:+59->63, 12:+65->69
    //   40: aload_2
    //   41: ldc 12
    //   43: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   46: checkcast 12	gnu/expr/Expression
    //   49: aload_3
    //   50: ldc_w 379
    //   53: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   56: checkcast 379	gnu/bytecode/Type
    //   59: invokestatic 57	kawa/lib/kawa/expressions:visitExp	(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    //   62: areturn
    //   63: aload_2
    //   64: aload_3
    //   65: invokestatic 421	kawa/lib/kawa/expressions:ifExp	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/IfExp;
    //   68: areturn
    //   69: aload_2
    //   70: ldc 20
    //   72: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   75: checkcast 20	gnu/expr/Declaration
    //   78: aload_3
    //   79: invokestatic 427	kawa/lib/kawa/expressions:setExp	(Lgnu/expr/Declaration;Ljava/lang/Object;)Lgnu/expr/SetExp;
    //   82: areturn
    //   83: aload_0
    //   84: aload_1
    //   85: aload_2
    //   86: aload_3
    //   87: invokespecial 431	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: areturn
    //   91: new 139	gnu/mapping/WrongType
    //   94: dup_x1
    //   95: swap
    //   96: ldc_w 408
    //   99: iconst_1
    //   100: aload_2
    //   101: invokespecial 144	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   104: athrow
    //   105: new 139	gnu/mapping/WrongType
    //   108: dup_x1
    //   109: swap
    //   110: ldc_w 408
    //   113: iconst_2
    //   114: aload_3
    //   115: invokespecial 144	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   118: athrow
    //   119: new 139	gnu/mapping/WrongType
    //   122: dup_x1
    //   123: swap
    //   124: ldc_w 423
    //   127: iconst_1
    //   128: aload_2
    //   129: invokespecial 144	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   132: athrow
    // Line number table:
    //   Java source line #33	-> byte code offset #40
    //   Java source line #63	-> byte code offset #63
    //   Java source line #66	-> byte code offset #69
    //   Java source line #33	-> byte code offset #91
    //   Java source line #34	-> byte code offset #105
    //   Java source line #66	-> byte code offset #119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	expressions
    //   0	133	1	paramModuleMethod	ModuleMethod
    //   0	133	2	paramObject1	Object
    //   0	133	3	paramObject2	Object
    //   91	1	4	localClassCastException1	ClassCastException
    //   105	1	5	localClassCastException2	ClassCastException
    //   119	1	6	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   46	49	91	java/lang/ClassCastException
    //   56	59	105	java/lang/ClassCastException
    //   75	78	119	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 354	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+101->105, 7:+28->32, 8:+62->66, 9:+96->100
    //   32: aload_2
    //   33: iconst_0
    //   34: aaload
    //   35: aload_2
    //   36: arraylength
    //   37: iconst_1
    //   38: isub
    //   39: istore_3
    //   40: iload_3
    //   41: anewarray 94	java/lang/Object
    //   44: goto +11 -> 55
    //   47: dup
    //   48: iload_3
    //   49: aload_2
    //   50: iload_3
    //   51: iconst_1
    //   52: iadd
    //   53: aaload
    //   54: aastore
    //   55: iinc 3 -1
    //   58: iload_3
    //   59: ifge -12 -> 47
    //   62: invokestatic 439	kawa/lib/kawa/expressions:applyExp$V	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/ApplyExp;
    //   65: areturn
    //   66: aload_2
    //   67: iconst_0
    //   68: aaload
    //   69: aload_2
    //   70: arraylength
    //   71: iconst_1
    //   72: isub
    //   73: istore_3
    //   74: iload_3
    //   75: anewarray 94	java/lang/Object
    //   78: goto +11 -> 89
    //   81: dup
    //   82: iload_3
    //   83: aload_2
    //   84: iload_3
    //   85: iconst_1
    //   86: iadd
    //   87: aaload
    //   88: aastore
    //   89: iinc 3 -1
    //   92: iload_3
    //   93: ifge -12 -> 81
    //   96: invokestatic 443	kawa/lib/kawa/expressions:applyToArgsExp$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   99: areturn
    //   100: aload_2
    //   101: invokestatic 447	kawa/lib/kawa/expressions:beginExp$V	([Ljava/lang/Object;)Lgnu/expr/BeginExp;
    //   104: areturn
    //   105: aload_0
    //   106: aload_1
    //   107: aload_2
    //   108: invokespecial 450	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   111: areturn
    // Line number table:
    //   Java source line #44	-> byte code offset #32
    //   Java source line #49	-> byte code offset #66
    //   Java source line #59	-> byte code offset #100
  }
}
