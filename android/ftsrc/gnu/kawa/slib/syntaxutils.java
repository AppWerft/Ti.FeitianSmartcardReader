package gnu.kawa.slib;

import gnu.lists.PairWithPosition;

public class syntaxutils extends gnu.expr.ModuleBody { private static void $runBody$() { ;
    gnu.lists.Consumer $result = getInstanceconsumer;
  }
  

  public static final gnu.expr.ModuleMethod expand;
  
  public static final kawa.lang.Macro $Prvt$typecase$Pc;
  
  public static final kawa.lang.Macro $Prvt$$Ex;
  
  static final gnu.expr.Keyword Lit0;
  
  static final PairWithPosition Lit1;
  
  static final gnu.expr.Keyword Lit2;
  
  static final PairWithPosition Lit3;
  
  static final PairWithPosition Lit4;
  
  static final PairWithPosition Lit5;
  
  static final gnu.math.IntNum Lit6;
  
  static final gnu.math.IntNum Lit7;
  
  static final PairWithPosition Lit8;
  
  static final PairWithPosition Lit9;
  
  static final PairWithPosition Lit10;
  
  static final PairWithPosition Lit11;
  static final PairWithPosition Lit12;
  static final PairWithPosition Lit13;
  static final gnu.mapping.SimpleSymbol Lit14;
  static final PairWithPosition Lit15;
  static final PairWithPosition Lit16;
  static final PairWithPosition Lit17;
  static final PairWithPosition Lit18;
  static final PairWithPosition Lit19;
  static final PairWithPosition Lit20;
  public static syntaxutils $instance;
  static final gnu.mapping.SimpleSymbol Lit21;
  static final kawa.lang.SyntaxRules Lit22;
  static final gnu.mapping.SimpleSymbol Lit23;
  static final kawa.lang.SyntaxRules Lit24;
  static final gnu.mapping.SimpleSymbol Lit25;
  static final Object[] Lit26;
  static final gnu.mapping.SimpleSymbol Lit27;
  static final gnu.mapping.SimpleSymbol Lit28;
  static final gnu.mapping.SimpleSymbol Lit29;
  static final Object[] Lit30;
  static final gnu.mapping.SimpleSymbol Lit31;
  static final gnu.mapping.SimpleSymbol Lit32;
  static final gnu.mapping.SimpleSymbol Lit33;
  static final gnu.mapping.SimpleSymbol Lit34;
  static final gnu.mapping.SimpleSymbol Lit35;
  static final gnu.mapping.SimpleSymbol Lit36 = gnu.mapping.Symbol.valueOf("lambda");
  public int matchN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    if (selector == 1) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); } public static Object expand$V(Object sexp, Object[] argsArray) { Object tmp8_5 = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit0);
    

































































    if (tmp8_5 == gnu.expr.Special.dfault) tmp8_5; Object env = kawa.lib.misc.interactionEnvironment();
    return unrewrite(rewriteForm$V(kawa.lang.Quote.append$V(new Object[] { Lit1, kawa.lang.Quote.consX$V(new Object[] { sexp, gnu.lists.LList.Empty }) }), new Object[] { Lit0, env }));
  }
  














  static Object unrewrite(gnu.expr.Expression exp)
  {
    if ((exp instanceof gnu.expr.LetExp)) localExpression1 = exp; try { gnu.expr.LetExp exp = (gnu.expr.LetExp)exp;
      tmpTernaryOp = unrewriteLet(exp);
    }
    catch (ClassCastException localClassCastException2)
    {
      for (;;)
      {
        gnu.expr.Expression eclause;
        try
        {
          gnu.expr.QuoteExp exp = (gnu.expr.QuoteExp)exp;
          
          tmpTernaryOp = unrewriteQuote(exp); continue;
          if ((exp instanceof gnu.expr.SetExp)) localExpression1 = exp; } catch (ClassCastException localClassCastException2) { gnu.expr.SetExp exp; gnu.expr.ClassExp exp; gnu.expr.LambdaExp exp; gnu.expr.ReferenceExp exp; gnu.expr.ApplyExp exp; gnu.expr.BeginExp exp; gnu.expr.IfExp exp; throw new gnu.mapping.WrongType(localClassCastException2, "exp", -2, eclause); } try { exp = (gnu.expr.SetExp)exp;
          


          tmpTernaryOp = kawa.lang.Quote.append$V(new Object[] { Lit3, kawa.lang.Quote.consX$V(new Object[] { exp.getSymbol(), kawa.lang.Quote.consX$V(new Object[] { unrewrite(exp.getNewValue()), gnu.lists.LList.Empty }) }) }); continue;
          if ((exp instanceof gnu.expr.ClassExp)) localExpression1 = exp; } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "exp", -2, eclause); } try { exp = (gnu.expr.ClassExp)exp;
          



          tmpTernaryOp = unrewriteClass(exp); continue;
          if ((exp instanceof gnu.expr.LambdaExp)) localExpression1 = exp; } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "exp", -2, eclause); } try { exp = (gnu.expr.LambdaExp)exp;
          






          tmpTernaryOp = kawa.lang.Quote.append$V(new Object[] { Lit4, kawa.lang.Quote.consX$V(new Object[] { unrewriteArglist(exp), kawa.lang.Quote.consX$V(new Object[] {unrewrite(body), gnu.lists.LList.Empty }) }) }); continue;
          if ((exp instanceof gnu.expr.ReferenceExp)) localExpression1 = exp; } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "exp", -2, eclause); } try { exp = (gnu.expr.ReferenceExp)exp;
          







          tmpTernaryOp = exp.getSymbol(); continue;
          if ((exp instanceof gnu.expr.ApplyExp)) localExpression1 = exp; } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "exp", -2, eclause); } try { exp = (gnu.expr.ApplyExp)exp;
          








          tmpTernaryOp = unrewriteApply(exp); continue;
          if ((exp instanceof gnu.expr.BeginExp)) localExpression1 = exp; } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "exp", -2, eclause); } try { exp = (gnu.expr.BeginExp)exp;
          









          tmpTernaryOp = kawa.lang.Quote.append$V(new Object[] { Lit1, unrewrite$St(exp.getExpressions()) }); continue;
          if ((exp instanceof gnu.expr.IfExp)) localExpression1 = exp; } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "exp", -2, eclause); } try { exp = (gnu.expr.IfExp)exp; Object[] 
          












            tmp353_350 = new Object[2];
          eclause = exp.getElseClause();tmp353_350[0] = 
            (eclause == null ? gnu.lists.LList.Empty : 
            gnu.lists.LList.list1(unrewrite(eclause))); Object[] tmp378_353 = tmp353_350;tmp378_353[1] = gnu.lists.LList.Empty;{unrewrite(exp.getThenClause()) }[1] = kawa.lang.Quote.append$V(tmp378_353);{ unrewrite(exp.getTest()) }[1] = kawa.lang.Quote.consX$V(tmp347_337);{ Lit5 }[1] = kawa.lang.Quote.consX$V(tmp331_321);tmpTernaryOp = kawa.lang.Quote.append$V(tmp315_309);
          return exp;
        }
        catch (ClassCastException localClassCastException9)
        {
          throw new gnu.mapping.WrongType(localClassCastException9, "exp", -2, eclause); } } throw new gnu.mapping.WrongType(
      
















        localClassCastException1, "exp", -2, eclause);
    }
    if ((exp instanceof gnu.expr.QuoteExp)) { localExpression1 = exp;
    }
  }
  



















































  static gnu.lists.LList unrewrite$St(gnu.expr.Expression[] exps)
  {
    gnu.lists.LList pack = gnu.lists.LList.Empty;
    gnu.math.IntNum localIntNum1 = Lit6;Object len = Integer.valueOf(exps.length);
    gnu.math.IntNum i;
    while (!gnu.kawa.functions.NumberCompare.$Eq(i, len)) {
      Object v = unrewrite(exps[i.intValue()]);pack = kawa.lib.lists.cons(v, pack);i = gnu.math.IntNum.add(i, 1);
    }
    return kawa.lib.lists.reverse$Ex(pack);
  }
  


  static Object unrewriteLet(gnu.expr.LetExp exp)
  {
    Object[] tmp16_13 = new Object[2];gnu.lists.LList pack = gnu.lists.LList.Empty;
    gnu.math.IntNum localIntNum1 = Lit6;gnu.expr.Declaration decl = 
      exp.firstDecl();
    
    gnu.math.IntNum i;
    
    Object v = gnu.lists.LList.list2(decl.getSymbol(), unrewrite(decl.getInitValue()));pack = kawa.lib.lists.cons(v, pack);0[decl.nextDecl()] = kawa.lib.lists.reverse$Ex(pack); Object[] tmp75_16 = tmp16_13;tmp75_16[1] = 
      kawa.lang.Quote.consX$V(new Object[] {unrewrite(exp.getBody()), gnu.lists.LList.Empty });1[tmp16_13] = kawa.lang.Quote.consX$V(tmp75_16);return kawa.lang.Quote.append$V(new Object[] { Lit11 });
  }
  
  static Object unrewriteQuote(gnu.expr.QuoteExp exp) { Object val = exp.getValue();
    
    for (gnu.math.Numeric.asNumericOrNull(val) != null;; ) { for (;;) { try { Object localObject1; gnu.math.Numeric val = gnu.kawa.lispexpr.LangObjType.coerceNumeric(localObject1 = gnu.mapping.Promise.force(val, gnu.math.Numeric.class));val = val;
          

          tmpTernaryOp = val; continue;
          if (!(val instanceof Boolean)) {} } catch (ClassCastException localClassCastException1) { Object val; boolean val; label325: throw new gnu.mapping.WrongType(
          





            localClassCastException1, "val", -2, name);
        }
        try
        {
          val = gnu.expr.KawaConvert.isTrue(val = gnu.mapping.Promise.force(val));tmpTernaryOp = Boolean.FALSE; } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "val", -2, name); } if ((val instanceof gnu.text.Char)) {} try { int val = gnu.text.Char.castToCharacter(val = gnu.mapping.Promise.force(val));tmpTernaryOp = gnu.text.Char.make(val); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "val", -2, name); } if ((val instanceof gnu.expr.Keyword)) {} try { gnu.expr.Keyword val = (gnu.expr.Keyword)(val = gnu.mapping.Promise.force(val, gnu.expr.Keyword.class));tmpTernaryOp = val; } catch (ClassCastException localClassCastException4) { CharSequence val; throw new gnu.mapping.WrongType(localClassCastException4, "val", -2, name); } } if (!(val instanceof CharSequence)) {} } for (!(val instanceof gnu.bytecode.Type);; ) { try { gnu.bytecode.Type val = (gnu.bytecode.Type)(val = gnu.mapping.Promise.force(val, gnu.bytecode.Type.class));name = 
        


          val.getName();tmpTernaryOp = kawa.lib.misc.string$To$Symbol(gnu.kawa.functions.Format.formatToString(0, new Object[] { "<~a>", name })); break label325; if (!(val instanceof Class)) {} } catch (ClassCastException localClassCastException6) { Class val; throw new gnu.mapping.WrongType(localClassCastException6, "val", -2, name);
      }
    }
    



    return gnu.kawa.functions.IsEqv.apply(val, gnu.mapping.Values.empty) ? exp : kawa.lang.Quote.append$V(new Object[] { Lit12, kawa.lang.Quote.consX$V(new Object[] { val, gnu.lists.LList.Empty }) });
  }
  

  public static Object lambda1loop(gnu.expr.Declaration decl)
  {
    while (decl.getType() == gnu.expr.Compilation.typeProcedure)
    {
      decl = decl.nextDecl();
    }
    
    return decl == null ? gnu.lists.LList.Empty : kawa.lib.lists.cons(gnu.lists.LList.list3(decl.getSymbol(), Lit14, decl.getType()), lambda1loop(decl.nextDecl())); }
  static Object unrewriteClass(gnu.expr.ClassExp exp) { return kawa.lang.Quote.append$V(new Object[] { Lit13, kawa.lang.Quote.consX$V(new Object[] { unrewrite$St(supers), kawa.lang.Quote.append$V(new Object[] { lambda1loop(exp.firstDecl()), kawa.lang.Quote.append$V(new Object[] { lambda2loop(firstChild), gnu.lists.LList.Empty }) }) }) }); }
  
  public static Object lambda2loop(gnu.expr.LambdaExp child)
  {
    return child == null ? gnu.lists.LList.Empty : kawa.lib.lists.cons(unrewriteMethod(child), lambda2loop(nextSibling));
  }
  















  static Object unrewriteApply(gnu.expr.ApplyExp exp)
  {
    gnu.expr.Expression fun = exp.getFunction();
    gnu.lists.LList args = unrewrite$St(exp.getArgs());
    if ((fun instanceof gnu.expr.ReferenceExp)) {} try { gnu.expr.Expression localExpression1; gnu.expr.ReferenceExp fun = (gnu.expr.ReferenceExp)(localExpression1 = fun);
      tmpTernaryOp = fun.getBinding();gnu.expr.Declaration fbinding = null;
      

      gnu.expr.Declaration apply$Mnto$Mnargs = gnu.expr.Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "applyToArgs");
      fval = exp.getFunctionValue();
      








      Object x = (fval instanceof gnu.kawa.functions.GetNamedPart) ? kawa.lang.Quote.append$V(new Object[] { Lit20, args }) : (fval instanceof gnu.kawa.functions.Convert) ? kawa.lang.Quote.append$V(new Object[] { Lit19, args }) : Boolean.FALSE;
      

      return gnu.expr.KawaConvert.isTrue(x) ? x : (fbinding != null) && (apply$Mnto$Mnargs != null) && (field == field) ? args : kawa.lang.Quote.consX$V(new Object[] { unrewrite(fun), args });
    }
    catch (ClassCastException localClassCastException)
    {
      Object fval;
      throw new gnu.mapping.WrongType(
      
















        localClassCastException, "fun", -2, fval);
    }
  }
  
  /* Error */
  static gnu.expr.Expression rewriteForm$V(Object exp, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: getstatic 66	gnu/kawa/slib/syntaxutils:Lit2	Lgnu/expr/Keyword;
    //   5: invokestatic 22	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    //   8: dup
    //   9: getstatic 28	gnu/expr/Special:dfault	Lgnu/expr/Special;
    //   12: if_acmpne +7 -> 19
    //   15: pop
    //   16: invokestatic 72	gnu/expr/Language:getDefaultLanguage	()Lgnu/expr/Language;
    //   19: ldc 68
    //   21: invokestatic 78	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: dup
    //   25: astore 4
    //   27: checkcast 68	gnu/expr/Language
    //   30: astore_2
    //   31: aload_1
    //   32: iconst_0
    //   33: getstatic 16	gnu/kawa/slib/syntaxutils:Lit0	Lgnu/expr/Keyword;
    //   36: invokestatic 22	gnu/expr/Keyword:searchForKeyword	([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    //   39: dup
    //   40: getstatic 28	gnu/expr/Special:dfault	Lgnu/expr/Special;
    //   43: if_acmpne +7 -> 50
    //   46: pop
    //   47: invokestatic 34	kawa/lib/misc:interactionEnvironment	()Lgnu/mapping/Environment;
    //   50: astore_3
    //   51: aload_3
    //   52: ldc 90
    //   54: invokestatic 78	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   57: dup
    //   58: astore 5
    //   60: checkcast 90	gnu/mapping/Environment
    //   63: aload_2
    //   64: invokestatic 97	gnu/expr/NameLookup:getInstance	(Lgnu/mapping/Environment;Lgnu/expr/Language;)Lgnu/expr/NameLookup;
    //   67: astore 4
    //   69: new 99	gnu/text/SourceMessages
    //   72: dup
    //   73: invokespecial 102	gnu/text/SourceMessages:<init>	()V
    //   76: astore 5
    //   78: aload_2
    //   79: aload 5
    //   81: aload 4
    //   83: invokevirtual 106	gnu/expr/Language:getCompilation	(Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)Lgnu/expr/Compilation;
    //   86: dup
    //   87: astore 7
    //   89: checkcast 108	kawa/lang/Translator
    //   92: astore 6
    //   94: aload 6
    //   96: aconst_null
    //   97: invokevirtual 114	kawa/lang/Translator:pushNewModule	(Lgnu/text/Lexer;)Lgnu/expr/ModuleExp;
    //   100: pop
    //   101: aload 6
    //   103: invokestatic 120	gnu/expr/Compilation:setSaveCurrent	(Lgnu/expr/Compilation;)Lgnu/expr/Compilation;
    //   106: astore 7
    //   108: aload 6
    //   110: aload_0
    //   111: invokevirtual 124	kawa/lang/Translator:rewrite	(Ljava/lang/Object;)Lgnu/expr/Expression;
    //   114: astore 8
    //   116: jsr +14 -> 130
    //   119: goto +20 -> 139
    //   122: astore 9
    //   124: jsr +6 -> 130
    //   127: aload 9
    //   129: athrow
    //   130: astore 10
    //   132: aload 7
    //   134: invokestatic 128	gnu/expr/Compilation:restoreCurrent	(Lgnu/expr/Compilation;)V
    //   137: ret 10
    //   139: aload 8
    //   141: areturn
    //   142: new 82	gnu/mapping/WrongType
    //   145: dup_x1
    //   146: swap
    //   147: ldc 84
    //   149: iconst_2
    //   150: aload 4
    //   152: invokespecial 88	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   155: athrow
    //   156: new 82	gnu/mapping/WrongType
    //   159: dup_x1
    //   160: swap
    //   161: ldc 92
    //   163: iconst_1
    //   164: aload 5
    //   166: invokespecial 88	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   169: athrow
    //   170: new 82	gnu/mapping/WrongType
    //   173: dup_x1
    //   174: swap
    //   175: ldc 110
    //   177: bipush -2
    //   179: aload 7
    //   181: invokespecial 88	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   184: athrow
    // Line number table:
    //   Java source line #71	-> byte code offset #0
    //   Java source line #74	-> byte code offset #51
    //   Java source line #75	-> byte code offset #51
    //   Java source line #76	-> byte code offset #69
    //   Java source line #75	-> byte code offset #78
    //   Java source line #78	-> byte code offset #78
    //   Java source line #75	-> byte code offset #94
    //   Java source line #79	-> byte code offset #94
    //   Java source line #75	-> byte code offset #101
    //   Java source line #80	-> byte code offset #101
    //   Java source line #81	-> byte code offset #108
    //   Java source line #82	-> byte code offset #108
    //   Java source line #83	-> byte code offset #132
    //   Java source line #75	-> byte code offset #156
    //   Java source line #78	-> byte code offset #170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	exp	Object
    //   0	141	1	argsArray	Object[]
    //   0	79	2	lang	gnu.expr.Language
    //   0	52	3	env	Object
    //   25	1	4	localObject1	Object
    //   67	84	4	namelookup	gnu.expr.NameLookup
    //   58	1	5	localObject2	Object
    //   76	89	5	messages	gnu.text.SourceMessages
    //   92	17	6	translator	kawa.lang.Translator
    //   87	1	7	localCompilation1	gnu.expr.Compilation
    //   106	74	7	saved$Mncomp	gnu.expr.Compilation
    //   114	26	8	localExpression	gnu.expr.Expression
    //   122	6	9	localObject3	Object
    //   130	1	10	localObject4	Object
    //   142	1	14	localClassCastException1	ClassCastException
    //   156	1	15	localClassCastException2	ClassCastException
    //   170	1	16	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   108	122	122	finally
    //   27	30	142	java/lang/ClassCastException
    //   60	63	156	java/lang/ClassCastException
    //   89	92	170	java/lang/ClassCastException
  }
  
  /* Error */
  static Object unrewriteArglist(gnu.expr.LambdaExp exp)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 215	gnu/expr/LambdaExp:min_args	I
    //   4: istore_1
    //   5: aload_0
    //   6: getfield 218	gnu/expr/LambdaExp:max_args	I
    //   9: invokestatic 224	gnu/math/IntNum:make	(I)Lgnu/math/IntNum;
    //   12: invokestatic 230	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   15: istore_2
    //   16: aload_0
    //   17: getfield 234	gnu/expr/LambdaExp:keywords	[Lgnu/expr/Keyword;
    //   20: ifnonnull +7 -> 27
    //   23: iconst_0
    //   24: goto +4 -> 28
    //   27: iconst_1
    //   28: istore_3
    //   29: aload_0
    //   30: getfield 237	gnu/expr/LambdaExp:opt_args	I
    //   33: istore 4
    //   35: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   38: astore 5
    //   40: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   43: astore 6
    //   45: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   48: astore 7
    //   50: getstatic 243	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   53: astore 8
    //   55: aload_0
    //   56: invokevirtual 247	gnu/expr/LambdaExp:firstDecl	()Lgnu/expr/Declaration;
    //   59: getstatic 251	gnu/kawa/slib/syntaxutils:Lit6	Lgnu/math/IntNum;
    //   62: astore 10
    //   64: astore 9
    //   66: aload 9
    //   68: ifnull +181 -> 249
    //   71: aload 9
    //   73: invokevirtual 254	gnu/expr/Declaration:getSymbol	()Ljava/lang/Object;
    //   76: astore 11
    //   78: aload 10
    //   80: iload_1
    //   81: i2l
    //   82: invokestatic 258	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
    //   85: ifge +15 -> 100
    //   88: aload 11
    //   90: aload 5
    //   92: invokestatic 264	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   95: astore 5
    //   97: goto +138 -> 235
    //   100: aload 10
    //   102: iload_1
    //   103: i2l
    //   104: iload 4
    //   106: i2l
    //   107: ladd
    //   108: invokestatic 258	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
    //   111: ifge +15 -> 126
    //   114: aload 11
    //   116: aload 6
    //   118: invokestatic 264	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   121: astore 6
    //   123: goto +112 -> 235
    //   126: iload_2
    //   127: ifeq +24 -> 151
    //   130: aload 10
    //   132: iload_1
    //   133: i2l
    //   134: iload 4
    //   136: i2l
    //   137: ladd
    //   138: invokestatic 258	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
    //   141: ifne +10 -> 151
    //   144: aload 11
    //   146: astore 8
    //   148: goto +87 -> 235
    //   151: iload_3
    //   152: ifeq +51 -> 203
    //   155: aload 10
    //   157: iload_2
    //   158: ifeq +9 -> 167
    //   161: getstatic 267	gnu/kawa/slib/syntaxutils:Lit7	Lgnu/math/IntNum;
    //   164: goto +6 -> 170
    //   167: getstatic 251	gnu/kawa/slib/syntaxutils:Lit6	Lgnu/math/IntNum;
    //   170: iload_1
    //   171: iload 4
    //   173: iadd
    //   174: invokestatic 271	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   177: aload_0
    //   178: getfield 234	gnu/expr/LambdaExp:keywords	[Lgnu/expr/Keyword;
    //   181: arraylength
    //   182: invokestatic 271	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   185: invokestatic 274	gnu/math/IntNum:compare	(Lgnu/math/IntNum;Lgnu/math/IntNum;)I
    //   188: ifge +15 -> 203
    //   191: aload 11
    //   193: aload 7
    //   195: invokestatic 264	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   198: astore 7
    //   200: goto +35 -> 235
    //   203: aload 9
    //   205: invokevirtual 278	gnu/expr/Declaration:isThisParameter	()Z
    //   208: istore 12
    //   210: iload 12
    //   212: ifeq +6 -> 218
    //   215: goto +20 -> 235
    //   218: iconst_1
    //   219: anewarray 36	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: ldc_w 280
    //   227: aastore
    //   228: invokestatic 286	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   231: getstatic 290	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   234: athrow
    //   235: aload 9
    //   237: invokevirtual 293	gnu/expr/Declaration:nextDecl	()Lgnu/expr/Declaration;
    //   240: aload 10
    //   242: iconst_1
    //   243: invokestatic 271	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   246: goto -184 -> 62
    //   249: iconst_2
    //   250: anewarray 36	java/lang/Object
    //   253: dup
    //   254: iconst_0
    //   255: aload 5
    //   257: ldc 42
    //   259: invokestatic 78	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   262: dup
    //   263: astore 9
    //   265: checkcast 42	gnu/lists/LList
    //   268: invokestatic 298	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   271: aastore
    //   272: dup
    //   273: iconst_1
    //   274: iconst_2
    //   275: anewarray 36	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: iload 4
    //   282: invokestatic 304	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: invokestatic 308	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   288: ifeq +9 -> 297
    //   291: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   294: goto +35 -> 329
    //   297: iconst_2
    //   298: anewarray 36	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: getstatic 311	gnu/kawa/slib/syntaxutils:Lit8	Lgnu/lists/PairWithPosition;
    //   306: aastore
    //   307: dup
    //   308: iconst_1
    //   309: aload 6
    //   311: ldc 42
    //   313: invokestatic 78	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   316: dup
    //   317: astore 9
    //   319: checkcast 42	gnu/lists/LList
    //   322: invokestatic 298	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   325: aastore
    //   326: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: iconst_2
    //   333: anewarray 36	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: iload_2
    //   339: ifeq +40 -> 379
    //   342: iconst_2
    //   343: anewarray 36	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: getstatic 314	gnu/kawa/slib/syntaxutils:Lit9	Lgnu/lists/PairWithPosition;
    //   351: aastore
    //   352: dup
    //   353: iconst_1
    //   354: iconst_2
    //   355: anewarray 36	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload 8
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   368: aastore
    //   369: invokestatic 52	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   372: aastore
    //   373: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   376: goto +6 -> 382
    //   379: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   382: aastore
    //   383: dup
    //   384: iconst_1
    //   385: iconst_2
    //   386: anewarray 36	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: iload_3
    //   392: ifeq +38 -> 430
    //   395: iconst_2
    //   396: anewarray 36	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: getstatic 317	gnu/kawa/slib/syntaxutils:Lit10	Lgnu/lists/PairWithPosition;
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: aload 7
    //   409: ldc 42
    //   411: invokestatic 78	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   414: dup
    //   415: astore 9
    //   417: checkcast 42	gnu/lists/LList
    //   420: invokestatic 298	kawa/lib/lists:reverse	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   423: aastore
    //   424: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   427: goto +6 -> 433
    //   430: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   433: aastore
    //   434: dup
    //   435: iconst_1
    //   436: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   439: aastore
    //   440: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   443: aastore
    //   444: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   447: aastore
    //   448: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   451: aastore
    //   452: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   455: areturn
    //   456: new 82	gnu/mapping/WrongType
    //   459: dup_x1
    //   460: swap
    //   461: ldc_w 295
    //   464: iconst_1
    //   465: aload 9
    //   467: invokespecial 88	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   470: athrow
    //   471: new 82	gnu/mapping/WrongType
    //   474: dup_x1
    //   475: swap
    //   476: ldc_w 295
    //   479: iconst_1
    //   480: aload 9
    //   482: invokespecial 88	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   485: athrow
    //   486: new 82	gnu/mapping/WrongType
    //   489: dup_x1
    //   490: swap
    //   491: ldc_w 295
    //   494: iconst_1
    //   495: aload 9
    //   497: invokespecial 88	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   500: athrow
    // Line number table:
    //   Java source line #107	-> byte code offset #0
    //   Java source line #108	-> byte code offset #0
    //   Java source line #109	-> byte code offset #5
    //   Java source line #108	-> byte code offset #16
    //   Java source line #110	-> byte code offset #16
    //   Java source line #108	-> byte code offset #29
    //   Java source line #111	-> byte code offset #29
    //   Java source line #108	-> byte code offset #35
    //   Java source line #117	-> byte code offset #55
    //   Java source line #121	-> byte code offset #71
    //   Java source line #122	-> byte code offset #78
    //   Java source line #123	-> byte code offset #88
    //   Java source line #124	-> byte code offset #100
    //   Java source line #125	-> byte code offset #114
    //   Java source line #126	-> byte code offset #130
    //   Java source line #127	-> byte code offset #144
    //   Java source line #128	-> byte code offset #155
    //   Java source line #129	-> byte code offset #161
    //   Java source line #131	-> byte code offset #191
    //   Java source line #132	-> byte code offset #203
    //   Java source line #122	-> byte code offset #210
    //   Java source line #134	-> byte code offset #218
    //   Java source line #118	-> byte code offset #235
    //   Java source line #119	-> byte code offset #240
    //   Java source line #135	-> byte code offset #249
    //   Java source line #136	-> byte code offset #280
    //   Java source line #137	-> byte code offset #297
    //   Java source line #138	-> byte code offset #342
    //   Java source line #140	-> byte code offset #395
    //   Java source line #135	-> byte code offset #456
    //   Java source line #137	-> byte code offset #471
    //   Java source line #140	-> byte code offset #486
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	455	0	exp	gnu.expr.LambdaExp
    //   4	167	1	min	int
    //   15	324	2	rest$Qu	boolean
    //   28	364	3	key$Qu	boolean
    //   33	248	4	opt	int
    //   38	218	5	required	Object
    //   43	267	6	optional	Object
    //   48	360	7	key	Object
    //   53	308	8	rest	Object
    //   64	432	9	decl	gnu.expr.Declaration
    //   62	1	10	localIntNum1	gnu.math.IntNum
    //   66	175	10	i	gnu.math.IntNum
    //   76	116	11	var	Object
    //   208	3	12	x	boolean
    //   456	1	14	localClassCastException1	ClassCastException
    //   471	1	15	localClassCastException2	ClassCastException
    //   486	1	16	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   265	268	456	java/lang/ClassCastException
    //   319	322	471	java/lang/ClassCastException
    //   417	420	486	java/lang/ClassCastException
  }
  
  /* Error */
  static gnu.lists.Pair unrewriteMethod(gnu.expr.LambdaExp exp)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 480	gnu/expr/LambdaExp:nameDecl	Lgnu/expr/Declaration;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 481	gnu/expr/LambdaExp:getName	()Ljava/lang/String;
    //   9: astore_2
    //   10: aload_1
    //   11: aconst_null
    //   12: if_acmpeq +14 -> 26
    //   15: aload_1
    //   16: getstatic 484	gnu/expr/Declaration:STATIC_SPECIFIED	I
    //   19: i2l
    //   20: invokevirtual 488	gnu/expr/Declaration:getFlag	(J)Z
    //   23: goto +4 -> 27
    //   26: iconst_0
    //   27: istore 4
    //   29: iload 4
    //   31: ifeq +8 -> 39
    //   34: iload 4
    //   36: goto +15 -> 51
    //   39: aload_2
    //   40: ldc_w 490
    //   43: if_acmpne +7 -> 50
    //   46: iconst_1
    //   47: goto +4 -> 51
    //   50: iconst_0
    //   51: istore_3
    //   52: aload_1
    //   53: aconst_null
    //   54: if_acmpeq +14 -> 68
    //   57: aload_1
    //   58: getstatic 493	gnu/expr/Declaration:PRIVATE_ACCESS	I
    //   61: i2l
    //   62: invokevirtual 488	gnu/expr/Declaration:getFlag	(J)Z
    //   65: goto +4 -> 69
    //   68: iconst_0
    //   69: istore 4
    //   71: aload_1
    //   72: aconst_null
    //   73: if_acmpeq +14 -> 87
    //   76: aload_1
    //   77: getstatic 496	gnu/expr/Declaration:PROTECTED_ACCESS	I
    //   80: i2l
    //   81: invokevirtual 488	gnu/expr/Declaration:getFlag	(J)Z
    //   84: goto +4 -> 88
    //   87: iconst_0
    //   88: istore 5
    //   90: iconst_2
    //   91: anewarray 36	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_2
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: iconst_2
    //   101: anewarray 36	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: invokestatic 170	gnu/kawa/slib/syntaxutils:unrewriteArglist	(Lgnu/expr/LambdaExp;)Ljava/lang/Object;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   116: aastore
    //   117: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   120: aastore
    //   121: invokestatic 52	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   124: iconst_2
    //   125: anewarray 36	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: iload_3
    //   131: ifeq +9 -> 140
    //   134: getstatic 499	gnu/kawa/slib/syntaxutils:Lit15	Lgnu/lists/PairWithPosition;
    //   137: goto +6 -> 143
    //   140: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: iconst_2
    //   147: anewarray 36	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: iload 4
    //   154: ifeq +11 -> 165
    //   157: iload 4
    //   159: ifeq +60 -> 219
    //   162: goto +8 -> 170
    //   165: iload 5
    //   167: ifeq +52 -> 219
    //   170: iconst_2
    //   171: anewarray 36	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: getstatic 502	gnu/kawa/slib/syntaxutils:Lit16	Lgnu/lists/PairWithPosition;
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: iconst_2
    //   183: anewarray 36	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: iload 4
    //   190: ifeq +9 -> 199
    //   193: getstatic 505	gnu/kawa/slib/syntaxutils:Lit17	Lgnu/lists/PairWithPosition;
    //   196: goto +6 -> 202
    //   199: getstatic 508	gnu/kawa/slib/syntaxutils:Lit18	Lgnu/lists/PairWithPosition;
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   208: aastore
    //   209: invokestatic 52	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   212: aastore
    //   213: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   216: goto +6 -> 222
    //   219: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   222: aastore
    //   223: dup
    //   224: iconst_1
    //   225: iconst_2
    //   226: anewarray 36	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_0
    //   232: getfield 174	gnu/expr/LambdaExp:body	Lgnu/expr/Expression;
    //   235: invokestatic 63	gnu/kawa/slib/syntaxutils:unrewrite	(Lgnu/expr/Expression;)Ljava/lang/Object;
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: getstatic 46	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   244: aastore
    //   245: invokestatic 52	kawa/lang/Quote:consX$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   248: aastore
    //   249: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   252: aastore
    //   253: invokestatic 55	kawa/lang/Quote:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
    //   256: invokestatic 512	gnu/lists/Pair:make	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   259: areturn
    // Line number table:
    //   Java source line #188	-> byte code offset #0
    //   Java source line #189	-> byte code offset #0
    //   Java source line #190	-> byte code offset #5
    //   Java source line #189	-> byte code offset #10
    //   Java source line #191	-> byte code offset #10
    //   Java source line #192	-> byte code offset #16
    //   Java source line #191	-> byte code offset #29
    //   Java source line #193	-> byte code offset #39
    //   Java source line #189	-> byte code offset #52
    //   Java source line #194	-> byte code offset #52
    //   Java source line #195	-> byte code offset #58
    //   Java source line #189	-> byte code offset #71
    //   Java source line #196	-> byte code offset #71
    //   Java source line #197	-> byte code offset #77
    //   Java source line #198	-> byte code offset #90
    //   Java source line #199	-> byte code offset #106
    //   Java source line #201	-> byte code offset #152
    //   Java source line #202	-> byte code offset #170
    //   Java source line #203	-> byte code offset #231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	exp	gnu.expr.LambdaExp
    //   5	254	1	decl	gnu.expr.Declaration
    //   10	249	2	name	String
    //   52	207	3	static$Qu	boolean
    //   29	22	4	x	boolean
    //   71	188	4	private$Qu	boolean
    //   90	169	5	protected$Qu	boolean
  }
  
  static
  {
    Lit35 = gnu.mapping.Symbol.valueOf("as");
    Lit34 = gnu.mapping.Symbol.valueOf("else");
    Lit33 = gnu.mapping.Symbol.valueOf("let");
    Lit32 = gnu.mapping.Symbol.valueOf("cond");
    Lit31 = gnu.mapping.Symbol.valueOf("begin");
    gnu.mapping.SimpleSymbol tmp69_66 = gnu.mapping.Symbol.valueOf("or");
    Lit29 = tmp69_66;
    (syntaxutils.Lit30 = new Object[1])[0] = tmp69_66;
    Lit28 = gnu.mapping.Symbol.valueOf("quote");
    Lit27 = gnu.mapping.Symbol.valueOf("eql");
    Lit26 = new Object[0];
    Lit25 = gnu.mapping.Symbol.valueOf("expand");
    kawa.lang.SyntaxRule[] tmp119_116 = new kawa.lang.SyntaxRule[1];
    Object[] tmp152_149 = new Object[2];
    Object[] tmp153_152 = tmp152_149;
    tmp153_152[0] = gnu.mapping.Symbol.valueOf("invoke");
    tmp153_152[1] = Lit28;
    tmp119_116[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", Lit26, 3, "syntaxutils.scm:49"), "\001\001\003", "\021\030\004\t\013)\021\030\f\b\003\b\025\023", tmp152_149, 1);
    Lit24 = new kawa.lang.SyntaxRules(Lit26, tmp119_116, 3, syntaxutils.Lit23 = gnu.mapping.Symbol.valueOf("!"));
    Object[] tmp197_194 = new Object[2];
    Object[] tmp198_197 = tmp197_194;
    tmp198_197[0] = Lit27;
    tmp198_197[1] = Lit29;
    kawa.lang.SyntaxRule[] tmp214_211 = new kawa.lang.SyntaxRule[6];
    kawa.lang.SyntaxRule[] tmp215_214 = tmp214_211;
    tmp215_214[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007<\f\002\r\017\b\b\b\r\027\020\b\b", new Object[] { Boolean.TRUE }, 3, "syntaxutils.scm:17"), "\001\003\003", "\021\030\004\b\r\013", new Object[] { Lit31 }, 1);
    kawa.lang.SyntaxRule[] tmp266_215 = tmp215_214;
    Object[] tmp306_303 = new Object[5];
    Object[] tmp307_306 = tmp306_303;
    tmp307_306[0] = Lit32;
    Object[] tmp313_307 = tmp307_306;
    tmp313_307[1] = gnu.mapping.Symbol.valueOf("eqv?");
    Object[] tmp322_313 = tmp313_307;
    tmp322_313[2] = Lit28;
    Object[] tmp328_322 = tmp322_313;
    tmp328_322[3] = Lit34;
    gnu.mapping.SimpleSymbol tmp341_338 = gnu.mapping.Symbol.valueOf("typecase%");
    Lit21 = tmp341_338;
    tmp328_322[4] = tmp341_338;
    tmp266_215[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\\,\f\002\f\017\b\r\027\020\b\b\r\037\030\b\b", new Object[] { Lit27 }, 4, "syntaxutils.scm:19"), "\001\001\003\003", "\021\030\004yY\021\030\f\t\003\b\021\030\024\b\013\b\025\023\b\021\030\034\b\021\030$\t\003\b\035\033", tmp306_303, 1);
    kawa.lang.SyntaxRule[] tmp351_266 = tmp266_215;
    tmp351_266[2] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\\,\f\002\f\017\b\r\027\020\b\b\r\037\030\b\b", Lit30, 4, "syntaxutils.scm:22"), "\001\001\003\003", "\021\030\004\t\003)\t\013\b\025\023\b\035\033", new Object[] { Lit21 }, 1);
    kawa.lang.SyntaxRule[] tmp395_351 = tmp351_266;
    Object[] tmp429_426 = new Object[6];
    Object[] tmp430_429 = tmp429_426;
    tmp430_429[0] = Lit33;
    Object[] tmp436_430 = tmp430_429;
    tmp436_430[1] = gnu.mapping.Symbol.valueOf("f");
    Object[] tmp445_436 = tmp436_430;
    tmp445_436[2] = Lit36;
    Object[] tmp451_445 = tmp445_436;
    tmp451_445[3] = Lit31;
    Object[] tmp457_451 = tmp451_445;
    tmp457_451[4] = Lit21;
    tmp457_451[5] = Boolean.TRUE;
    tmp395_351[3] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007l<\f\002\r\017\b\b\b\r\027\020\b\b\r\037\030\b\b", Lit30, 4, "syntaxutils.scm:24"), "\001\003\003\003", "\021\030\004\b\021\030\f\b\021\030\024\021\b\003\b\021\030\034\b\025\023\b\021\030$\t\003I\r\t\013\b\021\030\f\b\003\b\t,\b\021\030$\t\003\b\035\033", tmp429_426, 1);
    kawa.lang.SyntaxRule[] tmp473_395 = tmp395_351;
    Object[] tmp507_504 = new Object[7];
    Object[] tmp508_507 = tmp507_504;
    tmp508_507[0] = Lit32;
    Object[] tmp514_508 = tmp508_507;
    tmp514_508[1] = gnu.mapping.Symbol.valueOf("instance?");
    Object[] tmp523_514 = tmp514_508;
    tmp523_514[2] = Lit33;
    Object[] tmp529_523 = tmp523_514;
    gnu.mapping.SimpleSymbol tmp537_534 = gnu.mapping.Symbol.valueOf("::");
    Lit14 = tmp537_534;
    tmp529_523[3] = tmp537_534;
    Object[] tmp542_529 = tmp529_523;
    tmp542_529[4] = Lit31;
    Object[] tmp548_542 = tmp542_529;
    tmp548_542[5] = Lit34;
    tmp548_542[6] = Lit21;
    tmp473_395[4] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007<\f\017\r\027\020\b\b\r\037\030\b\b", Lit26, 4, "syntaxutils.scm:29"), "\001\001\003\003", "\021\030\004ñ9\021\030\f\t\003\b\013\b\021\030\024Q\b\t\003\021\030\034\t\013\b\003\b\021\030$\b\025\023\b\021\030,\b\021\0304\t\003\b\035\033", tmp507_504, 1);
    Object[] tmp598_595 = new Object[6];
    Object[] tmp599_598 = tmp598_595;
    tmp599_598[0] = gnu.mapping.Symbol.valueOf("error");
    Object[] tmp608_599 = tmp599_598;
    tmp608_599[1] = "typecase% failed";
    Object[] tmp614_608 = tmp608_599;
    tmp614_608[2] = Lit23;
    Object[] tmp620_614 = tmp614_608;
    tmp620_614[3] = gnu.mapping.Symbol.valueOf("getClass");
    Object[] tmp629_620 = tmp620_614;
    tmp629_620[4] = Lit35;
    tmp629_620[5] = gnu.mapping.Symbol.valueOf("<object>");
    tmp473_395[5] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit26, 1, "syntaxutils.scm:34"), "\001", "\021\030\004\t\f\t\003\b\021\030\024\021\030\034\b\021\030$\021\030,\b\003", tmp598_595, 0);
    Lit22 = new kawa.lang.SyntaxRules(tmp197_194, tmp214_211, 4, Lit21);
    Lit20 = PairWithPosition.make(gnu.mapping.Symbol.valueOf(":"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 913424);
    Lit19 = PairWithPosition.make(Lit35, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 905232);
    Lit18 = PairWithPosition.make(Lit28, PairWithPosition.make(gnu.mapping.Symbol.valueOf("protected"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827441), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827441);
    Lit17 = PairWithPosition.make(Lit28, PairWithPosition.make(gnu.mapping.Symbol.valueOf("private"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827431), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827431);
    Lit16 = PairWithPosition.make(gnu.expr.Keyword.make("access"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 827406);
    Lit15 = PairWithPosition.make(gnu.expr.Keyword.make("allocation"), PairWithPosition.make(PairWithPosition.make(Lit28, PairWithPosition.make(gnu.mapping.Symbol.valueOf("static"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819236), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819236), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819235), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 819222);
    Lit13 = PairWithPosition.make(gnu.mapping.Symbol.valueOf("class"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 708612);
    Lit12 = PairWithPosition.make(Lit28, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 696332);
    Lit11 = PairWithPosition.make(Lit33, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 618500);
    Lit10 = PairWithPosition.make(gnu.expr.Special.key, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 573462);
    Lit9 = PairWithPosition.make(gnu.expr.Special.rest, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 565271);
    Lit8 = PairWithPosition.make(gnu.expr.Special.optional, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 561165);
    Lit7 = gnu.math.IntNum.valueOf(1);
    Lit6 = gnu.math.IntNum.valueOf(0);
    Lit5 = PairWithPosition.make(gnu.mapping.Symbol.valueOf("if"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 409607);
    Lit4 = PairWithPosition.make(Lit36, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 385031);
    Lit3 = PairWithPosition.make(gnu.mapping.Symbol.valueOf("set"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 372743);
    Lit2 = gnu.expr.Keyword.make("lang");
    Lit1 = PairWithPosition.make(Lit31, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/syntaxutils.scm", 278557);
    Lit0 = gnu.expr.Keyword.make("env");
    $instance = new syntaxutils();
    $Prvt$typecase$Pc = kawa.lang.Macro.make(Lit21, Lit22, "gnu.kawa.slib.syntaxutils");
    $Prvt$$Ex = kawa.lang.Macro.make(Lit23, Lit24, "gnu.kawa.slib.syntaxutils");
    syntaxutils localSyntaxutils = $instance;
    expand = new gnu.expr.ModuleMethod(localSyntaxutils, 1, Lit25, 61441);
    $runBody$();
  }
  
  public syntaxutils()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
  
  /* Error */
  public Object applyN(gnu.expr.ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 607	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_1
    //   5: if_icmpne +40 -> 45
    //   8: goto +3 -> 11
    //   11: aload_2
    //   12: iconst_0
    //   13: aaload
    //   14: aload_2
    //   15: arraylength
    //   16: iconst_1
    //   17: isub
    //   18: istore_3
    //   19: iload_3
    //   20: anewarray 36	java/lang/Object
    //   23: goto +11 -> 34
    //   26: dup
    //   27: iload_3
    //   28: aload_2
    //   29: iload_3
    //   30: iconst_1
    //   31: iadd
    //   32: aaload
    //   33: aastore
    //   34: iinc 3 -1
    //   37: iload_3
    //   38: ifge -12 -> 26
    //   41: invokestatic 629	gnu/kawa/slib/syntaxutils:expand$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: areturn
    //   45: aload_0
    //   46: aload_1
    //   47: aload_2
    //   48: invokespecial 633	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   51: areturn
    // Line number table:
    //   Java source line #67	-> byte code offset #11
  }
}
