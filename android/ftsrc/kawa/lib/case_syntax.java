package kawa.lib; import kawa.lang.SyntaxTemplate;

public class case_syntax extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;$LsCaseClause$Gr = Lit0;
  }
  

  public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$let;
  
  public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$else;
  
  public static final Object $LsCaseClause$Gr;
  
  public static final Class $LsCaseExp$Gr;
  
  public static final Class $LsExpression$Gr;
  
  public static final Class $LsQuoteExp$Gr;
  
  public static final gnu.expr.ModuleMethod syntax$Mnform$Mn$Grdatum;
  
  public static final gnu.expr.ModuleMethod clause$Mndatums$Mn$Grexps;
  
  public static final gnu.expr.ModuleMethod syntax$Mn$Grcase$Mnclauses;
  
  public static final gnu.expr.ModuleMethod case$Mnclause$Mn$Grexpression;
  
  public static final kawa.lang.Macro jdField_case;
  
  public static final kawa.lang.Macro $Pccase;
  
  static final Class Lit0;
  static final gnu.bytecode.ClassType Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  public static case_syntax $instance;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final gnu.mapping.SimpleSymbol Lit6;
  static final gnu.mapping.SimpleSymbol Lit7;
  static final gnu.mapping.SimpleSymbol Lit8;
  static final kawa.lang.SyntaxRules Lit9;
  static final gnu.mapping.SimpleSymbol Lit10;
  static final kawa.lang.SyntaxPattern Lit11;
  static final SyntaxTemplate Lit12;
  static final SyntaxTemplate Lit13;
  static final SyntaxTemplate Lit14;
  static final gnu.bytecode.ClassType Lit15;
  static final SyntaxTemplate Lit16;
  static final SyntaxTemplate Lit17;
  static final kawa.lang.SyntaxPattern Lit18;
  static final SyntaxTemplate Lit19;
  static final SyntaxTemplate Lit20;
  static final SyntaxTemplate Lit21;
  static final Object[] Lit22;
  static final Object[] Lit23;
  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 5:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static Object syntaxForm$To$Datum(Object obj) { return (obj instanceof kawa.lang.SyntaxForm) ? 
      ((kawa.lang.SyntaxForm)gnu.mapping.Promise.force(obj, kawa.lang.SyntaxForm.class)).getDatum() : obj; }
  

























  public int match2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 4:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 3: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public Object apply2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { switch (selector) {case 3:  return syntax$To$CaseClauses(paramObject1, paramObject2);
    










    case 4: 
      return caseClause$To$Expression(paramObject1, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  static
  {
    (case_syntax.Lit23 = new Object[1])[0] = gnu.mapping.Symbol.valueOf("else");Lit22 = new Object[0];Lit21 = new SyntaxTemplate("\001\003", "\003", Lit22, 0);Lit20 = new SyntaxTemplate("\001\003", "\b\r\013", Lit22, 1);Lit19 = new SyntaxTemplate("\001\003", "\003", Lit22, 0);Lit18 = new kawa.lang.SyntaxPattern("\f\030\f\007\r\017\b\b\b", Lit22, 2, "case_syntax.scm:67");Lit17 = new SyntaxTemplate("\001\003\003", "\003", Lit22, 0);Lit16 = new SyntaxTemplate("\001\003\003", "\021\030\004\b\025\023", Lit23, 1);Lit15 = gnu.bytecode.ClassType.make("gnu.expr.CaseExp$CaseClause");Lit14 = new SyntaxTemplate("\001\003\003", "\003", Lit22, 0);Lit13 = new SyntaxTemplate("\001\003\003", "\b\r\013", Lit22, 1);Lit12 = new SyntaxTemplate("\001\003\003", "\003", Lit22, 0);Lit11 = new kawa.lang.SyntaxPattern("\f\030\f\007\r\017\b\b\026<\f\002\r\027\020\b\b\b", Lit23, 3, "case_syntax.scm:58");Lit10 = gnu.mapping.Symbol.valueOf("%case"); kawa.lang.SyntaxRule[] tmp251_248 = new kawa.lang.SyntaxRule[1]; Object[] tmp284_281 = new Object[3]; Object[] tmp285_284 = tmp284_281;tmp285_284[0] = gnu.mapping.Symbol.valueOf("let"); Object[] tmp293_285 = tmp285_284;tmp293_285[1] = gnu.mapping.Symbol.valueOf("tmp");tmp293_285[2] = Lit10;tmp251_248[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\r\017\b\b\b", Lit22, 2, "case_syntax.scm:51"), "\001\003", "\021\030\0041\b\021\030\f\b\003\b\021\030\024\021\030\f\b\r\013", tmp284_281, 1);Lit9 = new kawa.lang.SyntaxRules(Lit22, tmp251_248, 2, case_syntax.Lit8 = gnu.mapping.Symbol.valueOf("case"));Lit7 = gnu.mapping.Symbol.valueOf("case-clause->expression");Lit6 = gnu.mapping.Symbol.valueOf("syntax->case-clauses");Lit5 = gnu.mapping.Symbol.valueOf("clause-datums->exps");Lit4 = gnu.mapping.Symbol.valueOf("syntax-form->datum");Lit3 = gnu.mapping.Symbol.valueOf("begin");Lit2 = gnu.mapping.Symbol.valueOf("=>");Lit1 = gnu.bytecode.ClassType.make("gnu.expr.Expression");Lit0 = gnu.expr.CaseExp.CaseClause.class;$LsQuoteExp$Gr = gnu.expr.QuoteExp.class;$LsExpression$Gr = gnu.expr.Expression.class;$LsCaseExp$Gr = gnu.expr.CaseExp.class;$instance = new case_syntax();$Prvt$let = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "let");$Prvt$else = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.std_syntax", "else");case_syntax localCase_syntax1 = $instance;syntax$Mnform$Mn$Grdatum = new gnu.expr.ModuleMethod(localCase_syntax1, 1, Lit4, 4097);clause$Mndatums$Mn$Grexps = new gnu.expr.ModuleMethod(localCase_syntax1, 2, Lit5, 4097);syntax$Mn$Grcase$Mnclauses = new gnu.expr.ModuleMethod(localCase_syntax1, 3, Lit6, 8194);case$Mnclause$Mn$Grexpression = new gnu.expr.ModuleMethod(localCase_syntax1, 4, Lit7, 8194);case = kawa.lang.Macro.make(Lit8, Lit9, "kawa.lib.case_syntax");
    




















































    case_syntax localCase_syntax2 = $instance; void tmp553_550 = new gnu.expr.ModuleMethod(localCase_syntax2, 5, null, 4097);tmp553_550.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/case_syntax.scm:56");$Pccase = kawa.lang.Macro.makeSkipScanForm(Lit10, tmp553_550, "kawa.lib.case_syntax");$runBody$();
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return syntaxForm$To$Datum(paramObject);
    



    case 2: 
      return clauseDatums$To$Exps(paramObject);
    




































    case 5: 
      return lambda1(paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  static Object lambda1(Object x) { Object localObject1 = x;Object[] arrayOfObject = kawa.lang.SyntaxPattern.allocVars(3, null);
    

    kawa.lang.TemplateScope localTemplateScope1 = kawa.lang.TemplateScope.make();int i = 0;
    
    Object localObject2 = kawa.lang.TemplateScope.make();
    localObject2 = kawa.lang.TemplateScope.make();localObject2 = syntax$To$CaseClauses(Lit13.execute(arrayOfObject, (kawa.lang.TemplateScope)localObject2), Lit14.execute(arrayOfObject, (kawa.lang.TemplateScope)localObject2)); int k; i = (k = gnu.kawa.functions.MakeSplice.count(localObject2)) + i; gnu.expr.CaseExp.CaseClause[] tmp89_86 = new gnu.expr.CaseExp.CaseClause[i];int m = 0;gnu.kawa.functions.MakeSplice.copyTo(tmp89_86, m, k, localObject2, Lit15);m += k;
    
    kawa.lang.TemplateScope localTemplateScope2 = kawa.lang.TemplateScope.make();
    localTemplateScope2 = kawa.lang.TemplateScope.make();
    

    localTemplateScope2 = kawa.lang.TemplateScope.make();int j = 0;
    
    localObject2 = kawa.lang.TemplateScope.make();
    localObject2 = kawa.lang.TemplateScope.make();localObject2 = syntax$To$CaseClauses(Lit20.execute(arrayOfObject, (kawa.lang.TemplateScope)localObject2), Lit21.execute(arrayOfObject, (kawa.lang.TemplateScope)localObject2));j = (k = gnu.kawa.functions.MakeSplice.count(localObject2)) + j; gnu.expr.CaseExp.CaseClause[] tmp233_230 = new gnu.expr.CaseExp.CaseClause[j];m = 0;gnu.kawa.functions.MakeSplice.copyTo(tmp233_230, m, k, localObject2, Lit15);m += k;return Lit18.match(x, arrayOfObject, 0) ? new gnu.expr.CaseExp(kawa.lang.SyntaxForms.rewrite(Lit19.execute(arrayOfObject, localTemplateScope2)), tmp233_230) : Lit11.match(x, arrayOfObject, 0) ? new gnu.expr.CaseExp(kawa.lang.SyntaxForms.rewrite(Lit12.execute(arrayOfObject, localTemplateScope1)), tmp89_86, new gnu.expr.CaseExp.CaseClause(caseClause$To$Expression(Lit16.execute(arrayOfObject, localTemplateScope2), Lit17.execute(arrayOfObject, localTemplateScope2)))) : kawa.standard.syntax_case.error("syntax-case", x);
  }
  
  /* Error */
  public static Object clauseDatums$To$Exps(Object datums)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 38	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +9 -> 13
    //   7: getstatic 44	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   10: goto +70 -> 80
    //   13: invokestatic 50	gnu/expr/Compilation:getCurrent	()Lgnu/expr/Compilation;
    //   16: dup
    //   17: astore_2
    //   18: checkcast 52	kawa/lang/Translator
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: ldc 64
    //   26: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: dup
    //   30: astore_3
    //   31: checkcast 64	gnu/lists/Pair
    //   34: iconst_0
    //   35: invokevirtual 70	kawa/lang/Translator:rewrite_car	(Lgnu/lists/Pair;Z)Lgnu/expr/Expression;
    //   38: astore_2
    //   39: aload_0
    //   40: ldc 64
    //   42: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: astore_3
    //   47: checkcast 64	gnu/lists/Pair
    //   50: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   53: invokestatic 79	kawa/lib/case_syntax:syntaxForm$To$Datum	(Ljava/lang/Object;)Ljava/lang/Object;
    //   56: aload_2
    //   57: invokestatic 84	gnu/expr/QuoteExp:getInstance	(Ljava/lang/Object;Lgnu/text/SourceLocator;)Lgnu/expr/QuoteExp;
    //   60: aload_0
    //   61: ldc 64
    //   63: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   66: dup
    //   67: astore_3
    //   68: checkcast 64	gnu/lists/Pair
    //   71: invokestatic 88	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   74: invokestatic 91	kawa/lib/case_syntax:clauseDatums$To$Exps	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: invokestatic 95	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   80: areturn
    //   81: new 56	gnu/mapping/WrongType
    //   84: dup_x1
    //   85: swap
    //   86: ldc 58
    //   88: bipush -2
    //   90: aload_2
    //   91: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   94: athrow
    //   95: new 56	gnu/mapping/WrongType
    //   98: dup_x1
    //   99: swap
    //   100: ldc 66
    //   102: iconst_2
    //   103: aload_3
    //   104: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   107: athrow
    //   108: new 56	gnu/mapping/WrongType
    //   111: dup_x1
    //   112: swap
    //   113: ldc 72
    //   115: iconst_1
    //   116: aload_3
    //   117: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   120: athrow
    //   121: new 56	gnu/mapping/WrongType
    //   124: dup_x1
    //   125: swap
    //   126: ldc 86
    //   128: iconst_1
    //   129: aload_3
    //   130: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   133: athrow
    // Line number table:
    //   Java source line #17	-> byte code offset #0
    //   Java source line #18	-> byte code offset #0
    //   Java source line #19	-> byte code offset #13
    //   Java source line #20	-> byte code offset #22
    //   Java source line #21	-> byte code offset #39
    //   Java source line #22	-> byte code offset #39
    //   Java source line #23	-> byte code offset #39
    //   Java source line #24	-> byte code offset #56
    //   Java source line #25	-> byte code offset #60
    //   Java source line #19	-> byte code offset #81
    //   Java source line #20	-> byte code offset #95
    //   Java source line #23	-> byte code offset #108
    //   Java source line #25	-> byte code offset #121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	datums	Object
    //   21	2	1	tr	kawa.lang.Translator
    //   17	1	2	localCompilation	gnu.expr.Compilation
    //   38	53	2	datum	gnu.expr.Expression
    //   30	100	3	localObject	Object
    //   81	1	5	localClassCastException1	ClassCastException
    //   95	1	6	localClassCastException2	ClassCastException
    //   108	1	7	localClassCastException3	ClassCastException
    //   121	1	8	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	21	81	java/lang/ClassCastException
    //   31	34	95	java/lang/ClassCastException
    //   47	50	108	java/lang/ClassCastException
    //   68	71	121	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object syntax$To$CaseClauses(Object s$Mnclauses, Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 38	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifne +125 -> 129
    //   7: aload_0
    //   8: ldc 64
    //   10: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_3
    //   15: checkcast 64	gnu/lists/Pair
    //   18: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 64
    //   25: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   28: dup
    //   29: astore 4
    //   31: checkcast 64	gnu/lists/Pair
    //   34: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_0
    //   39: ldc 64
    //   41: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: astore 5
    //   47: checkcast 64	gnu/lists/Pair
    //   50: invokestatic 88	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   53: astore 4
    //   55: new 97	gnu/expr/CaseExp$CaseClause
    //   58: dup
    //   59: iconst_0
    //   60: istore 5
    //   62: aload_3
    //   63: invokestatic 91	kawa/lib/case_syntax:clauseDatums$To$Exps	(Ljava/lang/Object;)Ljava/lang/Object;
    //   66: astore 6
    //   68: aload 6
    //   70: invokestatic 103	gnu/kawa/functions/MakeSplice:count	(Ljava/lang/Object;)I
    //   73: dup
    //   74: istore 7
    //   76: iload 5
    //   78: iadd
    //   79: istore 5
    //   81: iload 5
    //   83: anewarray 105	gnu/expr/Expression
    //   86: dup
    //   87: iconst_0
    //   88: istore 8
    //   90: iload 8
    //   92: iload 7
    //   94: aload 6
    //   96: getstatic 109	kawa/lib/case_syntax:Lit1	Lgnu/bytecode/ClassType;
    //   99: invokestatic 113	gnu/kawa/functions/MakeSplice:copyTo	(Ljava/lang/Object;IILjava/lang/Object;Lgnu/bytecode/Type;)V
    //   102: iload 8
    //   104: iload 7
    //   106: iadd
    //   107: istore 8
    //   109: aload_2
    //   110: aload_1
    //   111: invokestatic 117	kawa/lib/case_syntax:caseClause$To$Expression	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/Expression;
    //   114: invokespecial 120	gnu/expr/CaseExp$CaseClause:<init>	([Lgnu/expr/Expression;Lgnu/expr/Expression;)V
    //   117: aload 4
    //   119: aload_1
    //   120: invokestatic 124	kawa/lib/case_syntax:syntax$To$CaseClauses	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: invokestatic 95	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   126: goto +6 -> 132
    //   129: getstatic 44	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   132: areturn
    //   133: new 56	gnu/mapping/WrongType
    //   136: dup_x1
    //   137: swap
    //   138: ldc 72
    //   140: iconst_1
    //   141: aload_3
    //   142: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   145: athrow
    //   146: new 56	gnu/mapping/WrongType
    //   149: dup_x1
    //   150: swap
    //   151: ldc 72
    //   153: iconst_1
    //   154: aload 4
    //   156: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   159: athrow
    //   160: new 56	gnu/mapping/WrongType
    //   163: dup_x1
    //   164: swap
    //   165: ldc 86
    //   167: iconst_1
    //   168: aload 5
    //   170: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   173: athrow
    // Line number table:
    //   Java source line #28	-> byte code offset #0
    //   Java source line #29	-> byte code offset #0
    //   Java source line #30	-> byte code offset #7
    //   Java source line #31	-> byte code offset #22
    //   Java source line #30	-> byte code offset #38
    //   Java source line #32	-> byte code offset #38
    //   Java source line #33	-> byte code offset #55
    //   Java source line #34	-> byte code offset #55
    //   Java source line #35	-> byte code offset #62
    //   Java source line #36	-> byte code offset #109
    //   Java source line #37	-> byte code offset #117
    //   Java source line #29	-> byte code offset #129
    //   Java source line #30	-> byte code offset #133
    //   Java source line #31	-> byte code offset #146
    //   Java source line #32	-> byte code offset #160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	s$Mnclauses	Object
    //   0	132	1	key	Object
    //   21	89	2	clause	Object
    //   14	1	3	localObject1	Object
    //   37	105	3	datums	Object
    //   29	1	4	localObject2	Object
    //   53	102	4	rest	Object
    //   45	1	5	localObject3	Object
    //   60	109	5	i	int
    //   66	29	6	localObject4	Object
    //   74	33	7	j	int
    //   88	20	8	k	int
    //   133	1	12	localClassCastException1	ClassCastException
    //   146	1	13	localClassCastException2	ClassCastException
    //   160	1	14	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	133	java/lang/ClassCastException
    //   31	34	146	java/lang/ClassCastException
    //   47	50	160	java/lang/ClassCastException
  }
  
  /* Error */
  public static gnu.expr.Expression caseClause$To$Expression(Object s$Mnclause, Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 38	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: istore_2
    //   5: iload_2
    //   6: ifeq +10 -> 16
    //   9: iload_2
    //   10: ifeq +42 -> 52
    //   13: goto +23 -> 36
    //   16: aload_0
    //   17: ldc 64
    //   19: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   22: dup
    //   23: astore_3
    //   24: checkcast 64	gnu/lists/Pair
    //   27: invokestatic 88	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   30: invokestatic 38	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   33: ifeq +19 -> 52
    //   36: aload_0
    //   37: iconst_1
    //   38: anewarray 126	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: ldc -128
    //   45: aastore
    //   46: invokestatic 134	kawa/lib/prim_syntax:reportSyntaxError	(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/Expression;
    //   49: goto +92 -> 141
    //   52: aload_0
    //   53: ldc 64
    //   55: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   58: dup
    //   59: astore 4
    //   61: checkcast 64	gnu/lists/Pair
    //   64: invokestatic 88	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   67: astore_3
    //   68: aload_3
    //   69: ldc 64
    //   71: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   74: dup
    //   75: astore 5
    //   77: checkcast 64	gnu/lists/Pair
    //   80: invokestatic 75	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   83: getstatic 138	kawa/lib/case_syntax:Lit2	Lgnu/mapping/SimpleSymbol;
    //   86: if_acmpne +41 -> 127
    //   89: iconst_2
    //   90: anewarray 126	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_3
    //   96: ldc 64
    //   98: invokestatic 28	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   101: dup
    //   102: astore 5
    //   104: checkcast 64	gnu/lists/Pair
    //   107: invokestatic 88	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload_1
    //   114: invokestatic 142	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   117: aastore
    //   118: invokestatic 148	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   121: invokestatic 142	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
    //   124: goto +4 -> 128
    //   127: aload_3
    //   128: astore 4
    //   130: getstatic 151	kawa/lib/case_syntax:Lit3	Lgnu/mapping/SimpleSymbol;
    //   133: aload 4
    //   135: invokestatic 95	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   138: invokestatic 157	kawa/lang/SyntaxForms:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   141: areturn
    //   142: new 56	gnu/mapping/WrongType
    //   145: dup_x1
    //   146: swap
    //   147: ldc 86
    //   149: iconst_1
    //   150: aload_3
    //   151: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   154: athrow
    //   155: new 56	gnu/mapping/WrongType
    //   158: dup_x1
    //   159: swap
    //   160: ldc 86
    //   162: iconst_1
    //   163: aload 4
    //   165: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    //   169: new 56	gnu/mapping/WrongType
    //   172: dup_x1
    //   173: swap
    //   174: ldc 72
    //   176: iconst_1
    //   177: aload 5
    //   179: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   182: athrow
    //   183: new 56	gnu/mapping/WrongType
    //   186: dup_x1
    //   187: swap
    //   188: ldc 86
    //   190: iconst_1
    //   191: aload 5
    //   193: invokespecial 62	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    // Line number table:
    //   Java source line #41	-> byte code offset #0
    //   Java source line #42	-> byte code offset #0
    //   Java source line #43	-> byte code offset #36
    //   Java source line #44	-> byte code offset #52
    //   Java source line #45	-> byte code offset #68
    //   Java source line #46	-> byte code offset #89
    //   Java source line #45	-> byte code offset #127
    //   Java source line #48	-> byte code offset #130
    //   Java source line #42	-> byte code offset #142
    //   Java source line #44	-> byte code offset #155
    //   Java source line #45	-> byte code offset #169
    //   Java source line #46	-> byte code offset #183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	s$Mnclause	Object
    //   0	141	1	key	Object
    //   4	6	2	x	boolean
    //   23	1	3	localObject1	Object
    //   67	84	3	exp	Object
    //   59	1	4	localObject2	Object
    //   128	36	4	exp	Object
    //   75	117	5	localObject3	Object
    //   142	1	8	localClassCastException1	ClassCastException
    //   155	1	9	localClassCastException2	ClassCastException
    //   169	1	10	localClassCastException3	ClassCastException
    //   183	1	11	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   24	27	142	java/lang/ClassCastException
    //   61	64	155	java/lang/ClassCastException
    //   77	80	169	java/lang/ClassCastException
    //   104	107	183	java/lang/ClassCastException
  }
  
  public case_syntax()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
}
