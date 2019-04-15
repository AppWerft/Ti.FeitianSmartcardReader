package gnu.commonlisp.lisp; import gnu.expr.ModuleMethod;

public class primitives extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  

  static final gnu.mapping.Location loc$typep;
  
  static final gnu.mapping.Location loc$null;
  
  public static final ModuleMethod car;
  
  public static final ModuleMethod first;
  
  public static final ModuleMethod cdr;
  
  public static final ModuleMethod rest;
  
  public static final ModuleMethod second;
  
  public static final ModuleMethod third;
  
  public static final ModuleMethod nthcdr;
  
  public static final ModuleMethod nth;
  
  public static final ModuleMethod $N1$Mn;
  
  public static final ModuleMethod $N1$Pl;
  
  public static final ModuleMethod acons;
  
  public static final ModuleMethod listp;
  
  public static final ModuleMethod numberp;
  
  public static final ModuleMethod atom;
  
  public static final ModuleMethod eql;
  
  public static final ModuleMethod complement;
  
  public static final ModuleMethod member$Mnwith$Mntest;
  
  public static final ModuleMethod member$Mnwith$Mnkey;
  
  public static final ModuleMethod member$Mnplain;
  
  public static final ModuleMethod member;
  
  public static final ModuleMethod apply;
  
  public static final ModuleMethod funcall;
  
  public static final ModuleMethod minusp;
  
  public static final ModuleMethod plusp;
  
  public static final kawa.lang.Macro flet;
  
  public static final kawa.lang.Macro labels;
  
  public static final kawa.lang.Macro multiple$Mnvalue$Mnbind;
  
  public static final ModuleMethod floor;
  
  static final gnu.math.IntNum Lit0;
  
  static final gnu.math.IntNum Lit1;
  
  static final gnu.expr.Keyword Lit2;
  
  static final gnu.expr.Keyword Lit3;
  
  static final gnu.expr.Keyword Lit4;
  
  static final gnu.mapping.SimpleSymbol Lit5;
  
  public static primitives $instance;
  
  static final gnu.mapping.SimpleSymbol Lit6;
  
  static final gnu.mapping.SimpleSymbol Lit7;
  
  static final gnu.mapping.SimpleSymbol Lit8;
  
  static final gnu.mapping.SimpleSymbol Lit9;
  
  static final gnu.mapping.SimpleSymbol Lit10;
  
  static final gnu.mapping.SimpleSymbol Lit11;
  
  static final gnu.mapping.SimpleSymbol Lit12;
  
  static final gnu.mapping.SimpleSymbol Lit13;
  
  static final gnu.mapping.SimpleSymbol Lit14;
  
  static final gnu.mapping.SimpleSymbol Lit15;
  
  static final gnu.mapping.SimpleSymbol Lit16;
  
  static final gnu.mapping.SimpleSymbol Lit17;
  
  static final gnu.mapping.SimpleSymbol Lit18;
  
  static final gnu.mapping.SimpleSymbol Lit19;
  
  static final gnu.mapping.SimpleSymbol Lit20;
  
  static final gnu.mapping.SimpleSymbol Lit21;
  
  static final gnu.mapping.SimpleSymbol Lit22;
  
  static final gnu.mapping.SimpleSymbol Lit23;
  
  static final gnu.mapping.SimpleSymbol Lit24;
  
  static final gnu.mapping.SimpleSymbol Lit25;
  
  static final gnu.mapping.SimpleSymbol Lit26;
  
  static final gnu.mapping.SimpleSymbol Lit27;
  static final gnu.mapping.SimpleSymbol Lit28;
  static final gnu.mapping.SimpleSymbol Lit29;
  static final gnu.mapping.SimpleSymbol Lit30;
  static final gnu.mapping.SimpleSymbol Lit31;
  static final gnu.mapping.SimpleSymbol Lit32;
  static final kawa.lang.SyntaxRules Lit33;
  static final gnu.mapping.SimpleSymbol Lit34;
  static final kawa.lang.SyntaxRules Lit35;
  static final gnu.mapping.SimpleSymbol Lit36;
  static final kawa.lang.SyntaxRules Lit37;
  static final gnu.mapping.SimpleSymbol Lit38;
  static final Object[] Lit39;
  static final gnu.mapping.SimpleSymbol Lit40 = gnu.mapping.Symbol.valueOf("lambda");
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 26:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 25: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 24: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 17: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 15: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 14: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 13: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 11: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 10: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 7: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 6: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 5: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 4: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 3: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static Object car(Object x) { return gnu.commonlisp.lang.Lisp2.isTrueLisp(x) ? 
      ((gnu.lists.Pair)gnu.mapping.Promise.force(x, gnu.lists.Pair.class)).getCar() : gnu.lists.LList.Empty; }
  

  public static Object first(Object x)
  {
    return car(x);
  }
  
  public static Object cdr(Object x) { return gnu.commonlisp.lang.Lisp2.isTrueLisp(x) ? 
      ((gnu.lists.Pair)gnu.mapping.Promise.force(x, gnu.lists.Pair.class)).getCdr() : gnu.lists.LList.Empty; }
  

  public static Object rest(Object x)
  {
    return cdr(x);
  }
  
  public static Object second(Object x) { return first(rest(x)); }
  
  public static Object third(Object x) {
    return first(rest(rest(x)));
  }
  















































































































  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 26:  value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 20: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 16: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 9: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 8: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); }
  public static Object nthcdr(Object n, Object lst) { try { Object localObject1; int n = ((Number)(localObject1 = gnu.mapping.Promise.force(n))).intValue();
      Object localObject2 = lst;i = Integer.valueOf(n);
      Object result;
      return result;
    }
    catch (ClassCastException localClassCastException)
    {
      Object i;
      throw new gnu.mapping.WrongType(
      

        localClassCastException, "n", -2, i);
    } }
  
  public static Object nth(Object n, Object x) { return first(nthcdr(n, x)); }
  
  public static Object $N1$Mn(Object x) { return gnu.kawa.functions.AddOp.apply2(-1, x, Lit1); }
  public static Object $N1$Pl(Object x) { return gnu.kawa.functions.AddOp.apply2(1, x, Lit1); }
  























  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 19:  value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 12: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0; } return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext); }
  public static gnu.lists.Pair acons(Object key, Object datum, Object alist) { return kawa.lib.lists.cons(kawa.lib.lists.cons(key, datum), alist); }
  
  public static Object listp(Object obj) {
    try { return ((gnu.mapping.Procedure)gnu.mapping.Promise.force(loc$typep.get(), gnu.mapping.Procedure.class)).apply2(obj, gnu.kawa.lispexpr.LangObjType.listType); } catch (gnu.mapping.UnboundLocationException localUnboundLocationException) { gnu.mapping.UnboundLocationException tmp22_22 = localUnboundLocationException;tmp22_22.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 39, 3);throw tmp22_22;
    } }
  
  public static Object numberp(Object obj) { try { return ((gnu.mapping.Procedure)gnu.mapping.Promise.force(loc$typep.get(), gnu.mapping.Procedure.class)).apply2(obj, gnu.kawa.lispexpr.LangObjType.numericType); } catch (gnu.mapping.UnboundLocationException localUnboundLocationException) { gnu.mapping.UnboundLocationException tmp22_22 = localUnboundLocationException;tmp22_22.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 42, 3);throw tmp22_22;
    } }
  
  public static boolean atom(Object obj) { return !kawa.lib.lists.isPair(obj); }
  

  public static boolean eql(Object x, Object y) { return gnu.kawa.functions.IsEqv.apply(x, y); }
  
  public static gnu.mapping.Procedure complement(Object pred) { frame $heapFrame = new frame();pred = pred;
    return lambda$Fn1; } public class frame extends gnu.expr.ModuleBody { Object pred; public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject) { if (selector == 1) return lambda1$V(paramArrayOfObject) ? gnu.commonlisp.lang.Lisp2.TRUE : gnu.lists.LList.Empty; return super.applyN(paramModuleMethod, paramArrayOfObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); } final ModuleMethod lambda$Fn1; boolean lambda1$V(Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList arguments = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
      return !gnu.commonlisp.lang.Lisp2.isTrueLisp(primitives.apply$V(pred, new Object[] { arguments })); }
    public frame() { void tmp18_15 = new ModuleMethod(this, 1, null, 61440);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp:51");
      lambda$Fn1 = tmp18_15; } }
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, gnu.mapping.CallContext paramCallContext) { if (selector == 18) { value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0; } return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext); } public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) { if (selector == 18) return memberWithTest(paramObject1, paramObject2, paramObject3, paramObject4); return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (selector) {case 12:  return acons(paramObject1, paramObject2, paramObject3);
    






















    case 19: 
      return memberWithKey(paramObject1, paramObject2, paramObject3); } return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  































  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 23:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 22: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 21: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); } public static Object member$V(Object x, Object lst, Object[] argsArray) { Object key = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit2, gnu.lists.LList.Empty);Object GS$Dt35 = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit3, gnu.expr.Special.undefined);Object GS$Dt36 = gnu.expr.Keyword.searchForKeyword(argsArray, 0, Lit4, gnu.expr.Special.undefined);gnu.mapping.SimpleSymbol localSimpleSymbol = GS$Dt35 == gnu.expr.Special.undefined ? gnu.lists.LList.Empty : Lit5;Object test$Mnnot$Mnsupplied = GS$Dt36 == gnu.expr.Special.undefined ? gnu.lists.LList.Empty : Lit5; Object test$Mnsupplied; gnu.lists.EmptyList localEmptyList = gnu.commonlisp.lang.Lisp2.isTrueLisp(test$Mnsupplied) ? GS$Dt35 : gnu.lists.LList.Empty;Object test$Mnnot = gnu.commonlisp.lang.Lisp2.isTrueLisp(test$Mnnot$Mnsupplied) ? GS$Dt36 : gnu.lists.LList.Empty;
    try {
      Object test;
      gnu.lists.LList lst = (gnu.lists.LList)(localObject1 = gnu.mapping.Promise.force(lst, gnu.lists.LList.class));
      






      return gnu.commonlisp.lang.Lisp2.isTrueLisp(key) ? memberWithKey(x, lst, key) : gnu.commonlisp.lang.Lisp2.isTrueLisp(test$Mnnot$Mnsupplied) ? memberWithTest(x, lst, complement(test$Mnnot), key) : gnu.commonlisp.lang.Lisp2.isTrueLisp(test$Mnsupplied) ? memberWithTest(x, lst, test, key) : memberPlain(x, lst);
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject1;
      throw new gnu.mapping.WrongType(
      






        localClassCastException, "lst", -2, localObject1); } }
  
  public static Object apply$V(Object func, Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList args = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    







    return (PrimOps.symbolp(func) ? (gnu.mapping.Procedure)gnu.mapping.Promise.force(PrimOps.symbolFunction(func), gnu.mapping.Procedure.class) : (gnu.mapping.Procedure)gnu.mapping.Promise.force(func, gnu.mapping.Procedure.class)).applyN(gnu.kawa.functions.Apply.getArguments(args, 0, apply)); }
  
  public static Object funcall$V(Object func, Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList args = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    return apply$V(func, new Object[] { args });
  }
  
  public static boolean minusp(Object x) { return gnu.kawa.functions.NumberCompare.$Ls(x, Lit0); }
  
  public static boolean plusp(Object x) {
    return gnu.kawa.functions.NumberCompare.$Gr(x, Lit0);
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 2:  return car(paramObject);
    


    case 3: 
      return first(paramObject);
    
    case 4: 
      return cdr(paramObject);
    


    case 5: 
      return rest(paramObject);
    
    case 6: 
      return second(paramObject);
    
    case 7: 
      return third(paramObject);
    









    case 10: 
      return $N1$Mn(paramObject);
    case 11:  return $N1$Pl(paramObject);
    


    case 13: 
      return listp(paramObject);
    
    case 14: 
      return numberp(paramObject);
    
    case 15: 
      return atom(paramObject) ? gnu.commonlisp.lang.Lisp2.TRUE : gnu.lists.LList.Empty;
    



    case 17: 
      return complement(paramObject);
    














































    case 24: 
      return minusp(paramObject) ? gnu.commonlisp.lang.Lisp2.TRUE : gnu.lists.LList.Empty;
    
    case 25: 
      return plusp(paramObject) ? gnu.commonlisp.lang.Lisp2.TRUE : gnu.lists.LList.Empty;
    
































    case 26: 
      return floor(paramObject); } return super.apply1(paramModuleMethod, paramObject);
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {case 8:  return nthcdr(paramObject1, paramObject2);
    



    case 9: 
      return nth(paramObject1, paramObject2);
    















    case 16: 
      return eql(paramObject1, paramObject2) ? gnu.commonlisp.lang.Lisp2.TRUE : gnu.lists.LList.Empty;
    
















    case 20: 
      return memberPlain(paramObject1, paramObject2);
    




































































    case 26: 
      return floor(paramObject1, paramObject2); } return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  public static gnu.mapping.Values floor(Object number, Object divisor) { return gnu.mapping.Values.values2(gnu.kawa.functions.DivideOp.div.apply2(number, divisor), gnu.kawa.functions.DivideOp.remainder.apply2(number, divisor)); }
  
  /* Error */
  public static Object memberWithTest(Object x, Object lst, Object test, Object key)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 30
    //   3: invokestatic 24	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore 5
    //   9: checkcast 30	gnu/lists/LList
    //   12: astore 4
    //   14: getstatic 164	gnu/commonlisp/lisp/primitives:loc$null	Lgnu/mapping/Location;
    //   17: invokevirtual 117	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   20: ldc 127
    //   22: invokestatic 24	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   25: checkcast 127	gnu/mapping/Procedure
    //   28: aload 4
    //   30: invokevirtual 167	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: invokestatic 16	gnu/commonlisp/lang/Lisp2:isTrueLisp	(Ljava/lang/Object;)Z
    //   36: ifeq +9 -> 45
    //   39: getstatic 34	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   42: goto +54 -> 96
    //   45: aload_2
    //   46: iconst_2
    //   47: anewarray 169	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_0
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: aload_3
    //   57: iconst_1
    //   58: anewarray 169	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload 4
    //   65: invokestatic 40	gnu/commonlisp/lisp/primitives:car	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: aastore
    //   69: invokestatic 173	gnu/commonlisp/lisp/primitives:funcall$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   72: aastore
    //   73: invokestatic 173	gnu/commonlisp/lisp/primitives:funcall$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   76: invokestatic 16	gnu/commonlisp/lang/Lisp2:isTrueLisp	(Ljava/lang/Object;)Z
    //   79: ifeq +8 -> 87
    //   82: aload 4
    //   84: goto +12 -> 96
    //   87: aload 4
    //   89: invokestatic 46	gnu/commonlisp/lisp/primitives:cdr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore_1
    //   93: goto -93 -> 0
    //   96: areturn
    //   97: new 64	gnu/mapping/WrongType
    //   100: dup_x1
    //   101: swap
    //   102: ldc -95
    //   104: bipush -2
    //   106: aload 5
    //   108: invokespecial 70	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   111: athrow
    //   112: dup
    //   113: ldc 121
    //   115: bipush 56
    //   117: bipush 10
    //   119: invokevirtual 125	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   122: athrow
    // Line number table:
    //   Java source line #54	-> byte code offset #0
    //   Java source line #55	-> byte code offset #0
    //   Java source line #56	-> byte code offset #14
    //   Java source line #57	-> byte code offset #45
    //   Java source line #58	-> byte code offset #87
    //   Java source line #55	-> byte code offset #97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	x	Object
    //   0	96	1	lst	Object
    //   0	96	2	test	Object
    //   0	96	3	key	Object
    //   14	82	4	lst	gnu.lists.LList
    // Exception table:
    //   from	to	target	type
    //   9	12	97	java/lang/ClassCastException
    //   17	20	112	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object memberWithKey(Object x, Object lst, Object key)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 30
    //   3: invokestatic 24	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore 4
    //   9: checkcast 30	gnu/lists/LList
    //   12: astore_3
    //   13: getstatic 164	gnu/commonlisp/lisp/primitives:loc$null	Lgnu/mapping/Location;
    //   16: invokevirtual 117	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   19: ldc 127
    //   21: invokestatic 24	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: checkcast 127	gnu/mapping/Procedure
    //   27: aload_3
    //   28: invokevirtual 167	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: invokestatic 16	gnu/commonlisp/lang/Lisp2:isTrueLisp	(Ljava/lang/Object;)Z
    //   34: ifeq +9 -> 43
    //   37: getstatic 34	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   40: goto +37 -> 77
    //   43: aload_0
    //   44: aload_2
    //   45: iconst_1
    //   46: anewarray 169	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload_3
    //   52: invokestatic 40	gnu/commonlisp/lisp/primitives:car	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: aastore
    //   56: invokestatic 173	gnu/commonlisp/lisp/primitives:funcall$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: invokestatic 176	gnu/commonlisp/lisp/primitives:eql	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   62: ifeq +7 -> 69
    //   65: aload_3
    //   66: goto +11 -> 77
    //   69: aload_3
    //   70: invokestatic 46	gnu/commonlisp/lisp/primitives:cdr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: astore_1
    //   74: goto -74 -> 0
    //   77: areturn
    //   78: new 64	gnu/mapping/WrongType
    //   81: dup_x1
    //   82: swap
    //   83: ldc -95
    //   85: bipush -2
    //   87: aload 4
    //   89: invokespecial 70	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   92: athrow
    //   93: dup
    //   94: ldc 121
    //   96: bipush 62
    //   98: bipush 10
    //   100: invokevirtual 125	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   103: athrow
    // Line number table:
    //   Java source line #60	-> byte code offset #0
    //   Java source line #61	-> byte code offset #0
    //   Java source line #62	-> byte code offset #13
    //   Java source line #63	-> byte code offset #43
    //   Java source line #64	-> byte code offset #69
    //   Java source line #61	-> byte code offset #78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	x	Object
    //   0	77	1	lst	Object
    //   0	77	2	key	Object
    //   13	64	3	lst	gnu.lists.LList
    // Exception table:
    //   from	to	target	type
    //   9	12	78	java/lang/ClassCastException
    //   16	19	93	gnu/mapping/UnboundLocationException
  }
  
  /* Error */
  public static Object memberPlain(Object x, Object lst)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 30
    //   3: invokestatic 24	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_3
    //   8: checkcast 30	gnu/lists/LList
    //   11: astore_2
    //   12: getstatic 164	gnu/commonlisp/lisp/primitives:loc$null	Lgnu/mapping/Location;
    //   15: invokevirtual 117	gnu/mapping/Location:get	()Ljava/lang/Object;
    //   18: ldc 127
    //   20: invokestatic 24	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   23: checkcast 127	gnu/mapping/Procedure
    //   26: aload_2
    //   27: invokevirtual 167	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: invokestatic 16	gnu/commonlisp/lang/Lisp2:isTrueLisp	(Ljava/lang/Object;)Z
    //   33: ifeq +9 -> 42
    //   36: getstatic 34	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   39: goto +26 -> 65
    //   42: aload_0
    //   43: aload_2
    //   44: invokestatic 40	gnu/commonlisp/lisp/primitives:car	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: invokestatic 176	gnu/commonlisp/lisp/primitives:eql	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   50: ifeq +7 -> 57
    //   53: aload_2
    //   54: goto +11 -> 65
    //   57: aload_2
    //   58: invokestatic 46	gnu/commonlisp/lisp/primitives:cdr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: astore_1
    //   62: goto -62 -> 0
    //   65: areturn
    //   66: new 64	gnu/mapping/WrongType
    //   69: dup_x1
    //   70: swap
    //   71: ldc -95
    //   73: bipush -2
    //   75: aload_3
    //   76: invokespecial 70	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   79: athrow
    //   80: dup
    //   81: ldc 121
    //   83: bipush 68
    //   85: bipush 10
    //   87: invokevirtual 125	gnu/mapping/UnboundLocationException:setLine	(Ljava/lang/String;II)V
    //   90: athrow
    // Line number table:
    //   Java source line #66	-> byte code offset #0
    //   Java source line #67	-> byte code offset #0
    //   Java source line #68	-> byte code offset #12
    //   Java source line #69	-> byte code offset #42
    //   Java source line #70	-> byte code offset #57
    //   Java source line #67	-> byte code offset #66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	x	Object
    //   0	65	1	lst	Object
    //   12	53	2	lst	gnu.lists.LList
    // Exception table:
    //   from	to	target	type
    //   8	11	66	java/lang/ClassCastException
    //   15	18	80	gnu/mapping/UnboundLocationException
  }
  
  public static gnu.mapping.Values floor(Object paramObject)
  {
    return floor(paramObject, Lit1);
  }
  
  static
  {
    Lit39 = new Object[0];
    Lit38 = gnu.mapping.Symbol.valueOf("floor");
    kawa.lang.SyntaxRule[] tmp36_33 = new kawa.lang.SyntaxRule[1];
    Object[] tmp69_66 = new Object[2];
    Object[] tmp70_69 = tmp69_66;
    tmp70_69[0] = gnu.mapping.Symbol.valueOf("call-with-values");
    tmp70_69[1] = Lit40;
    tmp36_33[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\r\027\020\b\b", Lit39, 3, "primitives.lisp:133"), "\001\001\003", "\021\030\0049\021\030\f\t\020\b\013\b\021\030\f\t\003\b\025\023", tmp69_66, 1);
    Lit37 = new kawa.lang.SyntaxRules(Lit39, tmp36_33, 3, primitives.Lit36 = gnu.mapping.Symbol.valueOf("multiple-value-bind"));
    kawa.lang.SyntaxRule[] tmp117_114 = new kawa.lang.SyntaxRule[1];
    Object[] tmp150_147 = new Object[5];
    Object[] tmp151_150 = tmp150_147;
    gnu.mapping.SimpleSymbol tmp159_156 = gnu.mapping.Symbol.valueOf("flet");
    Lit32 = tmp159_156;
    tmp151_150[0] = tmp159_156;
    Object[] tmp164_151 = tmp151_150;
    tmp164_151[1] = gnu.lists.PairWithPosition.make(gnu.mapping.Values.empty, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/commonlisp/lisp/primitives.lisp", 483359);
    Object[] tmp181_164 = tmp164_151;
    tmp181_164[2] = gnu.mapping.Symbol.valueOf("set!");
    Object[] tmp190_181 = tmp181_164;
    tmp190_181[3] = gnu.mapping.Symbol.valueOf("function");
    tmp190_181[4] = Lit40;
    tmp117_114[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030lM\f\007\f\017\r\027\020\b\b\000\030\b\r\037\030\b\b", Lit39, 4, "primitives.lisp:117"), "\003\003\005\003", "\021\030\004A\b\005\t\003\t\013\030\f\005\021\030\024)\021\030\034\b\003\b\021\030$\t\013\b\025\023\b\035\033", tmp150_147, 2);
    Lit35 = new kawa.lang.SyntaxRules(Lit39, tmp117_114, 4, primitives.Lit34 = gnu.mapping.Symbol.valueOf("labels"));
    kawa.lang.SyntaxRule[] tmp237_234 = new kawa.lang.SyntaxRule[1];
    Object[] tmp270_267 = new Object[2];
    Object[] tmp271_270 = tmp270_267;
    tmp271_270[0] = gnu.mapping.Symbol.valueOf("%flet");
    tmp271_270[1] = Lit40;
    tmp237_234[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030lM\f\007\f\017\r\027\020\b\b\000\030\b\r\037\030\b\b", Lit39, 4, "primitives.lisp:110"), "\003\003\005\003", "\021\030\004i\b\005\t\003\b\021\030\f\t\013\b\025\023\b\035\033", tmp270_267, 2);
    Lit33 = new kawa.lang.SyntaxRules(Lit39, tmp237_234, 4, Lit32);
    Lit31 = gnu.mapping.Symbol.valueOf("plusp");
    Lit30 = gnu.mapping.Symbol.valueOf("minusp");
    Lit29 = gnu.mapping.Symbol.valueOf("funcall");
    Lit28 = gnu.mapping.Symbol.valueOf("apply");
    Lit27 = gnu.mapping.Symbol.valueOf("member");
    Lit26 = gnu.mapping.Symbol.valueOf("member-plain");
    Lit25 = gnu.mapping.Symbol.valueOf("member-with-key");
    Lit24 = gnu.mapping.Symbol.valueOf("member-with-test");
    Lit23 = gnu.mapping.Symbol.valueOf("complement");
    Lit22 = gnu.mapping.Symbol.valueOf("eql");
    Lit21 = gnu.mapping.Symbol.valueOf("atom");
    Lit20 = gnu.mapping.Symbol.valueOf("numberp");
    Lit19 = gnu.mapping.Symbol.valueOf("listp");
    Lit18 = gnu.mapping.Symbol.valueOf("acons");
    Lit17 = gnu.mapping.Symbol.valueOf("1+");
    Lit16 = gnu.mapping.Symbol.valueOf("1-");
    Lit15 = gnu.mapping.Symbol.valueOf("nth");
    Lit14 = gnu.mapping.Symbol.valueOf("nthcdr");
    Lit13 = gnu.mapping.Symbol.valueOf("third");
    Lit12 = gnu.mapping.Symbol.valueOf("second");
    Lit11 = gnu.mapping.Symbol.valueOf("rest");
    Lit10 = gnu.mapping.Symbol.valueOf("cdr");
    Lit9 = gnu.mapping.Symbol.valueOf("first");
    Lit8 = gnu.mapping.Symbol.valueOf("car");
    Lit7 = gnu.mapping.Symbol.valueOf("null");
    Lit6 = gnu.mapping.Symbol.valueOf("typep");
    Lit5 = gnu.mapping.Symbol.valueOf("t");
    Lit4 = gnu.expr.Keyword.make("test-not");
    Lit3 = gnu.expr.Keyword.make("test");
    Lit2 = gnu.expr.Keyword.make("key");
    Lit1 = gnu.math.IntNum.valueOf(1);
    Lit0 = gnu.math.IntNum.valueOf(0);
    $instance = new primitives();
    loc$typep = gnu.mapping.DynamicLocation.getInstance(Lit6, gnu.mapping.Symbol.FUNCTION);
    loc$null = gnu.mapping.DynamicLocation.getInstance(Lit7, gnu.mapping.Symbol.FUNCTION);
    primitives localPrimitives = $instance;
    car = new ModuleMethod(localPrimitives, 2, Lit8, 4097);
    first = new ModuleMethod(localPrimitives, 3, Lit9, 4097);
    cdr = new ModuleMethod(localPrimitives, 4, Lit10, 4097);
    rest = new ModuleMethod(localPrimitives, 5, Lit11, 4097);
    second = new ModuleMethod(localPrimitives, 6, Lit12, 4097);
    third = new ModuleMethod(localPrimitives, 7, Lit13, 4097);
    nthcdr = new ModuleMethod(localPrimitives, 8, Lit14, 8194);
    nth = new ModuleMethod(localPrimitives, 9, Lit15, 8194);
    $N1$Mn = new ModuleMethod(localPrimitives, 10, Lit16, 4097);
    $N1$Pl = new ModuleMethod(localPrimitives, 11, Lit17, 4097);
    acons = new ModuleMethod(localPrimitives, 12, Lit18, 12291);
    listp = new ModuleMethod(localPrimitives, 13, Lit19, 4097);
    numberp = new ModuleMethod(localPrimitives, 14, Lit20, 4097);
    atom = new ModuleMethod(localPrimitives, 15, Lit21, 4097);
    eql = new ModuleMethod(localPrimitives, 16, Lit22, 8194);
    complement = new ModuleMethod(localPrimitives, 17, Lit23, 4097);
    member$Mnwith$Mntest = new ModuleMethod(localPrimitives, 18, Lit24, 16388);
    member$Mnwith$Mnkey = new ModuleMethod(localPrimitives, 19, Lit25, 12291);
    member$Mnplain = new ModuleMethod(localPrimitives, 20, Lit26, 8194);
    member = new ModuleMethod(localPrimitives, 21, Lit27, 61442);
    apply = new ModuleMethod(localPrimitives, 22, Lit28, 61441);
    funcall = new ModuleMethod(localPrimitives, 23, Lit29, 61441);
    minusp = new ModuleMethod(localPrimitives, 24, Lit30, 4097);
    plusp = new ModuleMethod(localPrimitives, 25, Lit31, 4097);
    flet = kawa.lang.Macro.make(Lit32, Lit33, "gnu.commonlisp.lisp.primitives");
    labels = kawa.lang.Macro.make(Lit34, Lit35, "gnu.commonlisp.lisp.primitives");
    multiple$Mnvalue$Mnbind = kawa.lang.Macro.make(Lit36, Lit37, "gnu.commonlisp.lisp.primitives");
    floor = new ModuleMethod(localPrimitives, 26, Lit38, 8193);
    $runBody$();
  }
  
  public primitives()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 487	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+133->137, 21:+28->32, 22:+65->69, 23:+99->103
    //   32: aload_2
    //   33: iconst_0
    //   34: aaload
    //   35: aload_2
    //   36: iconst_1
    //   37: aaload
    //   38: aload_2
    //   39: arraylength
    //   40: iconst_2
    //   41: isub
    //   42: istore_3
    //   43: iload_3
    //   44: anewarray 169	java/lang/Object
    //   47: goto +11 -> 58
    //   50: dup
    //   51: iload_3
    //   52: aload_2
    //   53: iload_3
    //   54: iconst_2
    //   55: iadd
    //   56: aaload
    //   57: aastore
    //   58: iinc 3 -1
    //   61: iload_3
    //   62: ifge -12 -> 50
    //   65: invokestatic 578	gnu/commonlisp/lisp/primitives:member$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   68: areturn
    //   69: aload_2
    //   70: iconst_0
    //   71: aaload
    //   72: aload_2
    //   73: arraylength
    //   74: iconst_1
    //   75: isub
    //   76: istore_3
    //   77: iload_3
    //   78: anewarray 169	java/lang/Object
    //   81: goto +11 -> 92
    //   84: dup
    //   85: iload_3
    //   86: aload_2
    //   87: iload_3
    //   88: iconst_1
    //   89: iadd
    //   90: aaload
    //   91: aastore
    //   92: iinc 3 -1
    //   95: iload_3
    //   96: ifge -12 -> 84
    //   99: invokestatic 244	gnu/commonlisp/lisp/primitives:apply$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: areturn
    //   103: aload_2
    //   104: iconst_0
    //   105: aaload
    //   106: aload_2
    //   107: arraylength
    //   108: iconst_1
    //   109: isub
    //   110: istore_3
    //   111: iload_3
    //   112: anewarray 169	java/lang/Object
    //   115: goto +11 -> 126
    //   118: dup
    //   119: iload_3
    //   120: aload_2
    //   121: iload_3
    //   122: iconst_1
    //   123: iadd
    //   124: aaload
    //   125: aastore
    //   126: iinc 3 -1
    //   129: iload_3
    //   130: ifge -12 -> 118
    //   133: invokestatic 173	gnu/commonlisp/lisp/primitives:funcall$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   136: areturn
    //   137: aload_0
    //   138: aload_1
    //   139: aload_2
    //   140: invokespecial 581	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   143: areturn
    // Line number table:
    //   Java source line #72	-> byte code offset #32
    //   Java source line #85	-> byte code offset #69
    //   Java source line #96	-> byte code offset #103
  }
}
