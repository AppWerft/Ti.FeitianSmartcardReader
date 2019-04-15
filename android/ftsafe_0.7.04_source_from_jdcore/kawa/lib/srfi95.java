package kawa.lib;

import gnu.expr.ModuleMethod;

public class srfi95 extends gnu.expr.ModuleBody
{
  public static final ModuleMethod sorted$Qu;
  public static final ModuleMethod merge;
  public static final ModuleMethod merge$Ex;
  public static final ModuleMethod sort;
  public static final ModuleMethod sort$Ex;
  public static final ModuleMethod $Pcsort$Mnlist;
  public static final ModuleMethod $Pcsort$Mnvector;
  public static final ModuleMethod $Pcvector$Mnsort$Ex;
  static final ModuleMethod identity;
  static final gnu.math.IntNum Lit0;
  static final gnu.math.IntNum Lit1;
  
  private static void $runBody$() {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
  }
  










  static Object identity(Object x) { return x; } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 1) return identity(paramObject); return super.apply1(paramModuleMethod, paramObject);
  }
  













  static final gnu.math.IntNum Lit2;
  












  static final gnu.math.IntNum Lit3;
  












  public static srfi95 $instance;
  












  static final gnu.mapping.SimpleSymbol Lit4;
  












  static final gnu.mapping.SimpleSymbol Lit5;
  











  static final gnu.mapping.SimpleSymbol Lit6;
  











  static final gnu.mapping.SimpleSymbol Lit7;
  











  static final gnu.mapping.SimpleSymbol Lit8;
  











  static final gnu.mapping.SimpleSymbol Lit9;
  











  static final gnu.mapping.SimpleSymbol Lit10;
  











  static final gnu.mapping.SimpleSymbol Lit11;
  











  static final gnu.mapping.SimpleSymbol Lit12 = gnu.mapping.Symbol.valueOf("sort");
  











  public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 14:  Object tmp56_53 = gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class);
      


















































































































































































































      if (!(tmp56_53 instanceof gnu.lists.Sequence)) return -786431; value1 = tmp56_53;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 12: 
      Object tmp98_95 = gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class);
      


































































































































































































      if (!(tmp98_95 instanceof gnu.lists.Sequence)) return -786431; value1 = tmp98_95;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 9: 
      Object tmp140_137 = gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class);
      













































































































































































      if (!(tmp140_137 instanceof gnu.lists.Sequence)) return -786431; value1 = tmp140_137;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0;
    case 2: 
      value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext);
  }
  



































































































































































  public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 14:  Object tmp80_77 = gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class);
      


















































































































































































































      if (!(tmp80_77 instanceof gnu.lists.Sequence)) return -786431; value1 = tmp80_77;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 12: 
      Object tmp129_126 = gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class);
      


































































































































































































      if (!(tmp129_126 instanceof gnu.lists.Sequence)) return -786431; value1 = tmp129_126;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 11: 
      Object tmp178_175 = gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class);
      



























































































































































































      if (!(tmp178_175 instanceof gnu.lists.Sequence)) return -786431; value1 = tmp178_175;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 9: 
      Object tmp227_224 = gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class);
      













































































































































































      if (!(tmp227_224 instanceof gnu.lists.Sequence)) return -786431; value1 = tmp227_224;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 8: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 6: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 4: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
    case 2: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0; } return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
  }
  








































































  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 6:  value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0;
    case 4: 
      value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0; } return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext); } public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) { switch (selector) {case 4:  return merge(paramObject1, paramObject2, paramObject3, paramObject4);
    















































    case 6: 
      return merge$Ex(paramObject1, paramObject2, paramObject3, paramObject4); } return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4); }
  public static Object merge$Ex(Object a, Object b, Object less$Qu, Object key) { return sort$ClMerge$Ex(a, b, less$Qu, key); }
  
  public static Object $PcVectorSort$Ex(gnu.lists.Sequence seq, Object less$Qu, Object key)
  {
    for (;; 
        
































































        )
    {
      gnu.math.IntNum localIntNum1 = Lit3;Object sorted = $PcSortList(rank$Mn1Array$To$List(seq), less$Qu, key);
      
      gnu.math.IntNum i;
      if (!lists.isNull(sorted)) {}
      try { ((gnu.mapping.Procedure)gnu.mapping.Promise.force(gnu.kawa.functions.Setter.setter.apply1(seq), gnu.mapping.Procedure.class)).apply2(i, lists.car((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(sorted, gnu.lists.Pair.class))));localObject1 = gnu.mapping.Promise.force(sorted, gnu.lists.Pair.class); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(localClassCastException1, "car", 1, localObject1);
      }
    }
    return seq;
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {case 2:  return isSorted(paramObject1, paramObject2);
    }
    
    





























































































































    try
    {
      return sort$Ex((gnu.lists.Sequence)gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class), paramObject2); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      



































        localClassCastException1, "sort!", 1, paramObject1);
    }
    try
    {
      return $PcSortVector((gnu.lists.Sequence)gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class), paramObject2); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "%sort-vector", 1, paramObject1);
    }
    











    try
    {
      return sort((gnu.lists.Sequence)gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class), paramObject2); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "sort", 1, paramObject1); } return super.apply2(paramModuleMethod, paramObject1, paramObject2);
  }
  
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    switch (selector) {case 2:  return isSorted(paramObject1, paramObject2, paramObject3);
    
























    case 4: 
      return merge(paramObject1, paramObject2, paramObject3);
    















































    case 6: 
      return merge$Ex(paramObject1, paramObject2, paramObject3);
    
    case 8: 
      return $PcSortList(paramObject1, paramObject2, paramObject3);
    }
    
    













































    try
    {
      return sort$Ex((gnu.lists.Sequence)gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class), paramObject2, paramObject3); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      



































        localClassCastException1, "sort!", 1, paramObject1);
    }
    try
    {
      return $PcVectorSort$Ex((gnu.lists.Sequence)gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class), paramObject2, paramObject3); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "%vector-sort!", 1, paramObject1);
    }
    


    try
    {
      return $PcSortVector((gnu.lists.Sequence)gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class), paramObject2, paramObject3); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "%sort-vector", 1, paramObject1);
    }
    











    try
    {
      return sort((gnu.lists.Sequence)gnu.mapping.Promise.force(paramObject1, gnu.lists.Sequence.class), paramObject2, paramObject3); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "sort", 1, paramObject1); } return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  
  public static Object sort(gnu.lists.Sequence seq, Object less$Qu, Object key) {
    return lists.isList(seq) ? $PcSortList(kawa.standard.append.append$V(new Object[] { seq, gnu.lists.LList.Empty }), less$Qu, key) : $PcSortVector(seq, less$Qu, key);
  }
  
  public static Object isSorted(Object paramObject1, Object paramObject2)
  {
    return isSorted(paramObject1, paramObject2, identity);
  }
  
  /* Error */
  public static Object isSorted(Object seq, Object less$Qu, Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   4: ifeq +9 -> 13
    //   7: getstatic 32	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   10: goto +347 -> 357
    //   13: aload_0
    //   14: instanceof 34
    //   17: ifeq +182 -> 199
    //   20: aload_0
    //   21: ldc 34
    //   23: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   26: dup
    //   27: astore 4
    //   29: checkcast 34	gnu/lists/Sequence
    //   32: astore_3
    //   33: iconst_m1
    //   34: aload_3
    //   35: invokeinterface 54 1 0
    //   40: iadd
    //   41: istore 4
    //   43: iload 4
    //   45: iconst_1
    //   46: if_icmpgt +7 -> 53
    //   49: iconst_1
    //   50: goto +4 -> 54
    //   53: iconst_0
    //   54: istore 5
    //   56: iload 5
    //   58: ifeq +20 -> 78
    //   61: iload 5
    //   63: ifeq +9 -> 72
    //   66: getstatic 32	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   69: goto +288 -> 357
    //   72: getstatic 57	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   75: goto +282 -> 357
    //   78: iconst_m1
    //   79: iload 4
    //   81: iadd
    //   82: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   88: aload_2
    //   89: aload_3
    //   90: iload 4
    //   92: invokeinterface 73 2 0
    //   97: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: astore 7
    //   102: astore 6
    //   104: aload 6
    //   106: ldc 81
    //   108: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   111: dup
    //   112: astore 9
    //   114: invokestatic 87	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   117: invokestatic 95	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   120: istore 8
    //   122: iload 8
    //   124: ifeq +20 -> 144
    //   127: iload 8
    //   129: ifeq +9 -> 138
    //   132: getstatic 32	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   135: goto +222 -> 357
    //   138: getstatic 57	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   141: goto +216 -> 357
    //   144: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   147: aload_2
    //   148: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   151: aload_3
    //   152: aload 6
    //   154: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: astore 9
    //   162: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   165: aload_1
    //   166: aload 9
    //   168: aload 7
    //   170: invokevirtual 98	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   176: ifeq +17 -> 193
    //   179: iconst_1
    //   180: getstatic 107	kawa/lib/srfi95:Lit0	Lgnu/math/IntNum;
    //   183: aload 6
    //   185: invokestatic 112	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: aload 9
    //   190: goto -90 -> 100
    //   193: getstatic 57	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   196: goto +161 -> 357
    //   199: aload_0
    //   200: ldc 114
    //   202: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   205: dup
    //   206: astore_3
    //   207: checkcast 114	gnu/lists/Pair
    //   210: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   213: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   216: ifeq +9 -> 225
    //   219: getstatic 32	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   222: goto +135 -> 357
    //   225: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   228: aload_2
    //   229: aload_0
    //   230: ldc 114
    //   232: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   235: dup
    //   236: astore_3
    //   237: checkcast 114	gnu/lists/Pair
    //   240: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   243: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   246: aload_0
    //   247: ldc 114
    //   249: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   252: dup
    //   253: astore_3
    //   254: checkcast 114	gnu/lists/Pair
    //   257: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   260: astore 4
    //   262: astore_3
    //   263: aload 4
    //   265: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   268: istore 5
    //   270: iload 5
    //   272: ifeq +20 -> 292
    //   275: iload 5
    //   277: ifeq +9 -> 286
    //   280: getstatic 32	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   283: goto +74 -> 357
    //   286: getstatic 57	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   289: goto +68 -> 357
    //   292: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   295: aload_2
    //   296: aload 4
    //   298: ldc 114
    //   300: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   303: dup
    //   304: astore 7
    //   306: checkcast 114	gnu/lists/Pair
    //   309: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   312: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   315: astore 6
    //   317: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   320: aload_1
    //   321: aload 6
    //   323: aload_3
    //   324: invokevirtual 98	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   327: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   330: ifne +24 -> 354
    //   333: aload 6
    //   335: aload 4
    //   337: ldc 114
    //   339: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   342: dup
    //   343: astore 7
    //   345: checkcast 114	gnu/lists/Pair
    //   348: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   351: goto -91 -> 260
    //   354: getstatic 57	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   357: areturn
    //   358: new 44	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc 46
    //   365: bipush -2
    //   367: aload 4
    //   369: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   372: athrow
    //   373: new 44	gnu/mapping/WrongType
    //   376: dup_x1
    //   377: swap
    //   378: ldc 89
    //   380: iconst_1
    //   381: aload 9
    //   383: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   386: athrow
    //   387: new 44	gnu/mapping/WrongType
    //   390: dup_x1
    //   391: swap
    //   392: ldc 116
    //   394: iconst_1
    //   395: aload_3
    //   396: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   399: athrow
    //   400: new 44	gnu/mapping/WrongType
    //   403: dup_x1
    //   404: swap
    //   405: ldc 121
    //   407: iconst_1
    //   408: aload_3
    //   409: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   412: athrow
    //   413: new 44	gnu/mapping/WrongType
    //   416: dup_x1
    //   417: swap
    //   418: ldc 116
    //   420: iconst_1
    //   421: aload_3
    //   422: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   425: athrow
    //   426: new 44	gnu/mapping/WrongType
    //   429: dup_x1
    //   430: swap
    //   431: ldc 121
    //   433: iconst_1
    //   434: aload 7
    //   436: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   439: athrow
    //   440: new 44	gnu/mapping/WrongType
    //   443: dup_x1
    //   444: swap
    //   445: ldc 116
    //   447: iconst_1
    //   448: aload 7
    //   450: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   453: athrow
    // Line number table:
    //   Java source line #44	-> byte code offset #0
    //   Java source line #45	-> byte code offset #0
    //   Java source line #46	-> byte code offset #13
    //   Java source line #47	-> byte code offset #20
    //   Java source line #48	-> byte code offset #33
    //   Java source line #49	-> byte code offset #43
    //   Java source line #50	-> byte code offset #78
    //   Java source line #51	-> byte code offset #85
    //   Java source line #52	-> byte code offset #104
    //   Java source line #53	-> byte code offset #144
    //   Java source line #54	-> byte code offset #162
    //   Java source line #55	-> byte code offset #179
    //   Java source line #56	-> byte code offset #199
    //   Java source line #58	-> byte code offset #225
    //   Java source line #59	-> byte code offset #246
    //   Java source line #60	-> byte code offset #263
    //   Java source line #61	-> byte code offset #292
    //   Java source line #62	-> byte code offset #317
    //   Java source line #63	-> byte code offset #333
    //   Java source line #47	-> byte code offset #358
    //   Java source line #52	-> byte code offset #373
    //   Java source line #56	-> byte code offset #387
    //   Java source line #58	-> byte code offset #400
    //   Java source line #59	-> byte code offset #413
    //   Java source line #61	-> byte code offset #426
    //   Java source line #63	-> byte code offset #440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	seq	Object
    //   0	357	1	less$Qu	Object
    //   0	357	2	key	Object
    //   32	222	3	arr	gnu.lists.Sequence
    //   262	160	3	last	Object
    //   27	1	4	localObject1	Object
    //   41	220	4	dimax	int
    //   260	1	4	localObject2	Object
    //   263	105	4	next	Object
    //   54	8	5	x	boolean
    //   268	8	5	x	boolean
    //   102	82	6	idx	Object
    //   315	19	6	nxt	Object
    //   100	1	7	localObject3	Object
    //   104	345	7	last	Object
    //   120	8	8	x	boolean
    //   112	1	9	localObject4	Object
    //   160	222	9	nxt	Object
    //   358	1	18	localClassCastException1	ClassCastException
    //   373	1	19	localClassCastException2	ClassCastException
    //   387	1	20	localClassCastException3	ClassCastException
    //   400	1	21	localClassCastException4	ClassCastException
    //   413	1	22	localClassCastException5	ClassCastException
    //   426	1	23	localClassCastException6	ClassCastException
    //   440	1	24	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   29	32	358	java/lang/ClassCastException
    //   114	117	373	java/lang/ClassCastException
    //   207	210	387	java/lang/ClassCastException
    //   237	240	400	java/lang/ClassCastException
    //   254	257	413	java/lang/ClassCastException
    //   306	309	426	java/lang/ClassCastException
    //   345	348	440	java/lang/ClassCastException
  }
  
  public static Object merge(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return merge(paramObject1, paramObject2, paramObject3, identity);
  }
  
  /* Error */
  public static Object merge(Object a, Object b, Object isLess, Object key)
  {
    // Byte code:
    //   0: new 129	kawa/lib/srfi95$frame
    //   3: dup
    //   4: invokespecial 132	kawa/lib/srfi95$frame:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_2
    //   12: putfield 136	kawa/lib/srfi95$frame:less$Qu	Ljava/lang/Object;
    //   15: aload 4
    //   17: aload_3
    //   18: putfield 139	kawa/lib/srfi95$frame:key	Ljava/lang/Object;
    //   21: aload_0
    //   22: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   25: ifeq +7 -> 32
    //   28: aload_1
    //   29: goto +131 -> 160
    //   32: aload_1
    //   33: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   36: ifeq +7 -> 43
    //   39: aload_0
    //   40: goto +120 -> 160
    //   43: aload 4
    //   45: aload_0
    //   46: ldc 114
    //   48: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   51: dup
    //   52: astore 5
    //   54: checkcast 114	gnu/lists/Pair
    //   57: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   60: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   63: aload 4
    //   65: getfield 139	kawa/lib/srfi95$frame:key	Ljava/lang/Object;
    //   68: aload_0
    //   69: ldc 114
    //   71: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   74: dup
    //   75: astore 5
    //   77: checkcast 114	gnu/lists/Pair
    //   80: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   83: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: aload_0
    //   87: ldc 114
    //   89: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 5
    //   95: checkcast 114	gnu/lists/Pair
    //   98: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   101: aload_1
    //   102: ldc 114
    //   104: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   107: dup
    //   108: astore 5
    //   110: checkcast 114	gnu/lists/Pair
    //   113: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   116: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   119: aload 4
    //   121: getfield 139	kawa/lib/srfi95$frame:key	Ljava/lang/Object;
    //   124: aload_1
    //   125: ldc 114
    //   127: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   130: dup
    //   131: astore 5
    //   133: checkcast 114	gnu/lists/Pair
    //   136: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   139: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: aload_1
    //   143: ldc 114
    //   145: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   148: dup
    //   149: astore 5
    //   151: checkcast 114	gnu/lists/Pair
    //   154: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   157: invokevirtual 143	kawa/lib/srfi95$frame:lambda1loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: areturn
    //   161: new 44	gnu/mapping/WrongType
    //   164: dup_x1
    //   165: swap
    //   166: ldc 121
    //   168: iconst_1
    //   169: aload 5
    //   171: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   174: athrow
    //   175: new 44	gnu/mapping/WrongType
    //   178: dup_x1
    //   179: swap
    //   180: ldc 121
    //   182: iconst_1
    //   183: aload 5
    //   185: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   188: athrow
    //   189: new 44	gnu/mapping/WrongType
    //   192: dup_x1
    //   193: swap
    //   194: ldc 116
    //   196: iconst_1
    //   197: aload 5
    //   199: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   202: athrow
    //   203: new 44	gnu/mapping/WrongType
    //   206: dup_x1
    //   207: swap
    //   208: ldc 121
    //   210: iconst_1
    //   211: aload 5
    //   213: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   216: athrow
    //   217: new 44	gnu/mapping/WrongType
    //   220: dup_x1
    //   221: swap
    //   222: ldc 121
    //   224: iconst_1
    //   225: aload 5
    //   227: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   230: athrow
    //   231: new 44	gnu/mapping/WrongType
    //   234: dup_x1
    //   235: swap
    //   236: ldc 116
    //   238: iconst_1
    //   239: aload 5
    //   241: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    // Line number table:
    //   Java source line #71	-> byte code offset #0
    //   Java source line #72	-> byte code offset #21
    //   Java source line #73	-> byte code offset #32
    //   Java source line #75	-> byte code offset #43
    //   Java source line #76	-> byte code offset #101
    //   Java source line #75	-> byte code offset #161
    //   Java source line #76	-> byte code offset #203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	a	Object
    //   0	160	1	b	Object
    //   0	160	2	isLess	Object
    //   0	160	3	key	Object
    //   7	113	4	$heapFrame	frame
    //   52	188	5	localObject	Object
    //   161	1	6	localClassCastException1	ClassCastException
    //   175	1	7	localClassCastException2	ClassCastException
    //   189	1	8	localClassCastException3	ClassCastException
    //   203	1	9	localClassCastException4	ClassCastException
    //   217	1	10	localClassCastException5	ClassCastException
    //   231	1	11	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   54	57	161	java/lang/ClassCastException
    //   77	80	175	java/lang/ClassCastException
    //   95	98	189	java/lang/ClassCastException
    //   110	113	203	java/lang/ClassCastException
    //   133	136	217	java/lang/ClassCastException
    //   151	154	231	java/lang/ClassCastException
  }
  
  public static Object merge$Ex(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return merge$Ex(paramObject1, paramObject2, paramObject3, identity);
  }
  
  /* Error */
  static Object sort$ClMerge$Ex(Object a, Object b, Object isLess, Object key)
  {
    // Byte code:
    //   0: new 262	kawa/lib/srfi95$frame1
    //   3: dup
    //   4: invokespecial 263	kawa/lib/srfi95$frame1:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_2
    //   12: putfield 264	kawa/lib/srfi95$frame1:less$Qu	Ljava/lang/Object;
    //   15: aload 4
    //   17: aload_3
    //   18: putfield 265	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   21: aload_0
    //   22: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   25: ifeq +7 -> 32
    //   28: aload_1
    //   29: goto +256 -> 285
    //   32: aload_1
    //   33: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   36: ifeq +7 -> 43
    //   39: aload_0
    //   40: goto +245 -> 285
    //   43: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   46: aload 4
    //   48: getfield 265	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   51: aload_0
    //   52: ldc 114
    //   54: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   57: dup
    //   58: astore 6
    //   60: checkcast 114	gnu/lists/Pair
    //   63: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   66: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   69: astore 5
    //   71: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   74: aload 4
    //   76: getfield 265	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   79: aload_1
    //   80: ldc 114
    //   82: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   85: dup
    //   86: astore 7
    //   88: checkcast 114	gnu/lists/Pair
    //   91: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   94: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   97: astore 6
    //   99: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   102: aload 4
    //   104: getfield 264	kawa/lib/srfi95$frame1:less$Qu	Ljava/lang/Object;
    //   107: aload 6
    //   109: aload 5
    //   111: invokevirtual 98	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   114: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   117: ifeq +87 -> 204
    //   120: aload_1
    //   121: ldc 114
    //   123: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   126: dup
    //   127: astore 7
    //   129: checkcast 114	gnu/lists/Pair
    //   132: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   135: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   138: ifeq +22 -> 160
    //   141: aload_1
    //   142: ldc 114
    //   144: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   147: dup
    //   148: astore 7
    //   150: checkcast 114	gnu/lists/Pair
    //   153: aload_0
    //   154: invokestatic 197	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   157: goto +43 -> 200
    //   160: aload 4
    //   162: aload_1
    //   163: aload_0
    //   164: aload 5
    //   166: aload_1
    //   167: ldc 114
    //   169: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: dup
    //   173: astore 7
    //   175: checkcast 114	gnu/lists/Pair
    //   178: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   181: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   184: aload 4
    //   186: getfield 265	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   189: aload_1
    //   190: invokestatic 268	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   193: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: invokevirtual 272	kawa/lib/srfi95$frame1:lambda3loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: aload_1
    //   201: goto +84 -> 285
    //   204: aload_0
    //   205: ldc 114
    //   207: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   210: dup
    //   211: astore 7
    //   213: checkcast 114	gnu/lists/Pair
    //   216: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   219: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   222: ifeq +22 -> 244
    //   225: aload_0
    //   226: ldc 114
    //   228: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   231: dup
    //   232: astore 7
    //   234: checkcast 114	gnu/lists/Pair
    //   237: aload_1
    //   238: invokestatic 197	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   241: goto +43 -> 284
    //   244: aload 4
    //   246: aload_0
    //   247: aload_0
    //   248: ldc 114
    //   250: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   253: dup
    //   254: astore 7
    //   256: checkcast 114	gnu/lists/Pair
    //   259: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   262: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   265: aload 4
    //   267: getfield 265	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
    //   270: aload_0
    //   271: invokestatic 268	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
    //   274: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   277: aload_1
    //   278: aload 6
    //   280: invokevirtual 272	kawa/lib/srfi95$frame1:lambda3loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: aload_0
    //   285: areturn
    //   286: new 44	gnu/mapping/WrongType
    //   289: dup_x1
    //   290: swap
    //   291: ldc 121
    //   293: iconst_1
    //   294: aload 6
    //   296: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   299: athrow
    //   300: new 44	gnu/mapping/WrongType
    //   303: dup_x1
    //   304: swap
    //   305: ldc 121
    //   307: iconst_1
    //   308: aload 7
    //   310: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   313: athrow
    //   314: new 44	gnu/mapping/WrongType
    //   317: dup_x1
    //   318: swap
    //   319: ldc 116
    //   321: iconst_1
    //   322: aload 7
    //   324: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   327: athrow
    //   328: new 44	gnu/mapping/WrongType
    //   331: dup_x1
    //   332: swap
    //   333: ldc -62
    //   335: iconst_1
    //   336: aload 7
    //   338: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   341: athrow
    //   342: new 44	gnu/mapping/WrongType
    //   345: dup_x1
    //   346: swap
    //   347: ldc 116
    //   349: iconst_1
    //   350: aload 7
    //   352: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   355: athrow
    //   356: new 44	gnu/mapping/WrongType
    //   359: dup_x1
    //   360: swap
    //   361: ldc 116
    //   363: iconst_1
    //   364: aload 7
    //   366: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   369: athrow
    //   370: new 44	gnu/mapping/WrongType
    //   373: dup_x1
    //   374: swap
    //   375: ldc -62
    //   377: iconst_1
    //   378: aload 7
    //   380: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   383: athrow
    //   384: new 44	gnu/mapping/WrongType
    //   387: dup_x1
    //   388: swap
    //   389: ldc 116
    //   391: iconst_1
    //   392: aload 7
    //   394: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   397: athrow
    // Line number table:
    //   Java source line #88	-> byte code offset #0
    //   Java source line #89	-> byte code offset #21
    //   Java source line #100	-> byte code offset #21
    //   Java source line #101	-> byte code offset #32
    //   Java source line #103	-> byte code offset #43
    //   Java source line #104	-> byte code offset #71
    //   Java source line #105	-> byte code offset #99
    //   Java source line #106	-> byte code offset #102
    //   Java source line #107	-> byte code offset #120
    //   Java source line #108	-> byte code offset #141
    //   Java source line #109	-> byte code offset #160
    //   Java source line #110	-> byte code offset #200
    //   Java source line #112	-> byte code offset #204
    //   Java source line #113	-> byte code offset #225
    //   Java source line #114	-> byte code offset #244
    //   Java source line #115	-> byte code offset #284
    //   Java source line #103	-> byte code offset #286
    //   Java source line #104	-> byte code offset #300
    //   Java source line #107	-> byte code offset #314
    //   Java source line #108	-> byte code offset #328
    //   Java source line #109	-> byte code offset #342
    //   Java source line #112	-> byte code offset #356
    //   Java source line #113	-> byte code offset #370
    //   Java source line #114	-> byte code offset #384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	a	Object
    //   0	285	1	b	Object
    //   0	285	2	isLess	Object
    //   0	285	3	key	Object
    //   7	259	4	$heapFrame	frame1
    //   69	1	5	localObject1	Object
    //   99	66	5	kcara	Object
    //   58	1	6	localObject2	Object
    //   97	198	6	kcarb	Object
    //   86	307	7	localObject3	Object
    //   286	1	10	localClassCastException1	ClassCastException
    //   300	1	11	localClassCastException2	ClassCastException
    //   314	1	12	localClassCastException3	ClassCastException
    //   328	1	13	localClassCastException4	ClassCastException
    //   342	1	14	localClassCastException5	ClassCastException
    //   356	1	15	localClassCastException6	ClassCastException
    //   370	1	16	localClassCastException7	ClassCastException
    //   384	1	17	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   60	63	286	java/lang/ClassCastException
    //   88	91	300	java/lang/ClassCastException
    //   129	132	314	java/lang/ClassCastException
    //   150	153	328	java/lang/ClassCastException
    //   175	178	342	java/lang/ClassCastException
    //   213	216	356	java/lang/ClassCastException
    //   234	237	370	java/lang/ClassCastException
    //   256	259	384	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object $PcSortList(Object seq, Object isLess, Object key)
  {
    // Byte code:
    //   0: new 151	kawa/lib/srfi95$frame0
    //   3: dup
    //   4: invokespecial 152	kawa/lib/srfi95$frame0:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 155	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   13: aload_3
    //   14: aload_1
    //   15: putfield 156	kawa/lib/srfi95$frame0:less$Qu	Ljava/lang/Object;
    //   18: aload_2
    //   19: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   22: ifeq +9 -> 31
    //   25: getstatic 159	kawa/lib/lists:car	Lgnu/expr/GenericProc;
    //   28: goto +6 -> 34
    //   31: getstatic 16	kawa/lib/srfi95:identity	Lgnu/expr/ModuleMethod;
    //   34: astore 4
    //   36: aload_2
    //   37: invokestatic 103	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   40: ifeq +189 -> 229
    //   43: aload_3
    //   44: getfield 155	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   47: astore 5
    //   49: aload 5
    //   51: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   54: istore 6
    //   56: iload 6
    //   58: ifeq +6 -> 64
    //   61: goto +80 -> 141
    //   64: aload 5
    //   66: ldc 114
    //   68: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   71: dup
    //   72: astore 7
    //   74: checkcast 114	gnu/lists/Pair
    //   77: getstatic 69	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   80: aload_2
    //   81: aload 5
    //   83: ldc 114
    //   85: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   88: dup
    //   89: astore 7
    //   91: checkcast 114	gnu/lists/Pair
    //   94: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   97: invokevirtual 79	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   100: aload 5
    //   102: ldc 114
    //   104: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   107: dup
    //   108: astore 7
    //   110: checkcast 114	gnu/lists/Pair
    //   113: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   116: invokestatic 165	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   119: invokestatic 169	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   122: aload 5
    //   124: ldc 114
    //   126: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   129: dup
    //   130: astore 7
    //   132: checkcast 114	gnu/lists/Pair
    //   135: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   138: goto -91 -> 47
    //   141: aload_3
    //   142: aload_3
    //   143: aload 4
    //   145: aload_3
    //   146: getfield 155	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   149: invokestatic 175	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   152: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: invokevirtual 178	kawa/lib/srfi95$frame0:lambda2step	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: putfield 155	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   161: aload_3
    //   162: getfield 155	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   165: astore 5
    //   167: aload 5
    //   169: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   172: istore 6
    //   174: iload 6
    //   176: ifeq +6 -> 182
    //   179: goto +43 -> 222
    //   182: aload 5
    //   184: ldc 114
    //   186: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   189: dup
    //   190: astore 7
    //   192: checkcast 114	gnu/lists/Pair
    //   195: aload 5
    //   197: invokestatic 182	kawa/lib/lists:cdar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   200: invokestatic 169	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   203: aload 5
    //   205: ldc 114
    //   207: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   210: dup
    //   211: astore 7
    //   213: checkcast 114	gnu/lists/Pair
    //   216: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   219: goto -54 -> 165
    //   222: aload_3
    //   223: getfield 155	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   226: goto +19 -> 245
    //   229: aload_3
    //   230: aload 4
    //   232: aload_3
    //   233: getfield 155	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
    //   236: invokestatic 175	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   239: invokestatic 63	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: invokevirtual 178	kawa/lib/srfi95$frame0:lambda2step	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: areturn
    //   246: new 44	gnu/mapping/WrongType
    //   249: dup_x1
    //   250: swap
    //   251: ldc -95
    //   253: iconst_1
    //   254: aload 7
    //   256: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   259: athrow
    //   260: new 44	gnu/mapping/WrongType
    //   263: dup_x1
    //   264: swap
    //   265: ldc 121
    //   267: iconst_1
    //   268: aload 7
    //   270: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   273: athrow
    //   274: new 44	gnu/mapping/WrongType
    //   277: dup_x1
    //   278: swap
    //   279: ldc 121
    //   281: iconst_1
    //   282: aload 7
    //   284: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   287: athrow
    //   288: new 44	gnu/mapping/WrongType
    //   291: dup_x1
    //   292: swap
    //   293: ldc 116
    //   295: iconst_1
    //   296: aload 7
    //   298: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   301: athrow
    //   302: new 44	gnu/mapping/WrongType
    //   305: dup_x1
    //   306: swap
    //   307: ldc -95
    //   309: iconst_1
    //   310: aload 7
    //   312: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   315: athrow
    //   316: new 44	gnu/mapping/WrongType
    //   319: dup_x1
    //   320: swap
    //   321: ldc 116
    //   323: iconst_1
    //   324: aload 7
    //   326: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   329: athrow
    // Line number table:
    //   Java source line #124	-> byte code offset #0
    //   Java source line #125	-> byte code offset #18
    //   Java source line #126	-> byte code offset #18
    //   Java source line #146	-> byte code offset #18
    //   Java source line #150	-> byte code offset #18
    //   Java source line #125	-> byte code offset #18
    //   Java source line #154	-> byte code offset #36
    //   Java source line #155	-> byte code offset #43
    //   Java source line #146	-> byte code offset #47
    //   Java source line #147	-> byte code offset #49
    //   Java source line #148	-> byte code offset #64
    //   Java source line #149	-> byte code offset #122
    //   Java source line #156	-> byte code offset #141
    //   Java source line #157	-> byte code offset #161
    //   Java source line #150	-> byte code offset #165
    //   Java source line #151	-> byte code offset #167
    //   Java source line #152	-> byte code offset #182
    //   Java source line #153	-> byte code offset #203
    //   Java source line #158	-> byte code offset #222
    //   Java source line #160	-> byte code offset #229
    //   Java source line #148	-> byte code offset #246
    //   Java source line #149	-> byte code offset #288
    //   Java source line #152	-> byte code offset #302
    //   Java source line #153	-> byte code offset #316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	seq	Object
    //   0	245	1	isLess	Object
    //   0	245	2	key	Object
    //   7	226	3	$heapFrame	frame0
    //   18	213	4	keyer	gnu.mapping.Procedure
    //   47	76	5	lst	Object
    //   165	39	5	lst	Object
    //   54	3	6	x	boolean
    //   172	3	6	x	boolean
    //   72	253	7	localObject1	Object
    //   246	1	10	localClassCastException1	ClassCastException
    //   260	1	11	localClassCastException2	ClassCastException
    //   274	1	12	localClassCastException3	ClassCastException
    //   288	1	13	localClassCastException4	ClassCastException
    //   302	1	14	localClassCastException5	ClassCastException
    //   316	1	15	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   74	77	246	java/lang/ClassCastException
    //   91	94	260	java/lang/ClassCastException
    //   110	113	274	java/lang/ClassCastException
    //   132	135	288	java/lang/ClassCastException
    //   192	195	302	java/lang/ClassCastException
    //   213	216	316	java/lang/ClassCastException
  }
  
  public static Object sort$Ex(gnu.lists.Sequence paramSequence, Object paramObject)
  {
    return sort$Ex(paramSequence, paramObject, Boolean.FALSE);
  }
  
  /* Error */
  public static Object sort$Ex(gnu.lists.Sequence seq, Object less$Qu, Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 189	kawa/lib/lists:isList	(Ljava/lang/Object;)Z
    //   4: ifeq +186 -> 190
    //   7: aload_0
    //   8: aload_1
    //   9: aload_2
    //   10: invokestatic 192	kawa/lib/srfi95:$PcSortList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: astore_3
    //   14: aload_3
    //   15: aload_0
    //   16: if_acmpeq +170 -> 186
    //   19: aload_3
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 114
    //   26: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: dup
    //   30: astore 5
    //   32: checkcast 114	gnu/lists/Pair
    //   35: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   38: aload_0
    //   39: if_acmpeq +22 -> 61
    //   42: aload 4
    //   44: ldc 114
    //   46: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: astore 5
    //   52: checkcast 114	gnu/lists/Pair
    //   55: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   58: goto -38 -> 20
    //   61: aload 4
    //   63: ldc 114
    //   65: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   68: dup
    //   69: astore 5
    //   71: checkcast 114	gnu/lists/Pair
    //   74: aload_3
    //   75: invokestatic 197	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   78: aload_0
    //   79: dup
    //   80: astore 6
    //   82: checkcast 114	gnu/lists/Pair
    //   85: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   88: astore 5
    //   90: aload_0
    //   91: dup
    //   92: astore 7
    //   94: checkcast 114	gnu/lists/Pair
    //   97: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   100: astore 6
    //   102: aload_0
    //   103: dup
    //   104: astore 7
    //   106: checkcast 114	gnu/lists/Pair
    //   109: aload_3
    //   110: ldc 114
    //   112: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   115: dup
    //   116: astore 7
    //   118: checkcast 114	gnu/lists/Pair
    //   121: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   124: invokestatic 169	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   127: aload_0
    //   128: dup
    //   129: astore 7
    //   131: checkcast 114	gnu/lists/Pair
    //   134: aload_3
    //   135: ldc 114
    //   137: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   140: dup
    //   141: astore 7
    //   143: checkcast 114	gnu/lists/Pair
    //   146: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   149: invokestatic 197	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   152: aload_3
    //   153: ldc 114
    //   155: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   158: dup
    //   159: astore 7
    //   161: checkcast 114	gnu/lists/Pair
    //   164: aload 5
    //   166: invokestatic 169	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   169: aload_3
    //   170: ldc 114
    //   172: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   175: dup
    //   176: astore 7
    //   178: checkcast 114	gnu/lists/Pair
    //   181: aload 6
    //   183: invokestatic 197	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
    //   186: aload_0
    //   187: goto +9 -> 196
    //   190: aload_0
    //   191: aload_1
    //   192: aload_2
    //   193: invokestatic 200	kawa/lib/srfi95:$PcVectorSort$Ex	(Lgnu/lists/Sequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: areturn
    //   197: new 44	gnu/mapping/WrongType
    //   200: dup_x1
    //   201: swap
    //   202: ldc 116
    //   204: iconst_1
    //   205: aload 5
    //   207: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   210: athrow
    //   211: new 44	gnu/mapping/WrongType
    //   214: dup_x1
    //   215: swap
    //   216: ldc 116
    //   218: iconst_1
    //   219: aload 5
    //   221: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   224: athrow
    //   225: new 44	gnu/mapping/WrongType
    //   228: dup_x1
    //   229: swap
    //   230: ldc -62
    //   232: iconst_1
    //   233: aload 5
    //   235: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: new 44	gnu/mapping/WrongType
    //   242: dup_x1
    //   243: swap
    //   244: ldc 121
    //   246: iconst_1
    //   247: aload 6
    //   249: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   252: athrow
    //   253: new 44	gnu/mapping/WrongType
    //   256: dup_x1
    //   257: swap
    //   258: ldc 116
    //   260: iconst_1
    //   261: aload 7
    //   263: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    //   267: new 44	gnu/mapping/WrongType
    //   270: dup_x1
    //   271: swap
    //   272: ldc -95
    //   274: iconst_1
    //   275: aload 7
    //   277: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: new 44	gnu/mapping/WrongType
    //   284: dup_x1
    //   285: swap
    //   286: ldc 121
    //   288: iconst_1
    //   289: aload 7
    //   291: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   294: athrow
    //   295: new 44	gnu/mapping/WrongType
    //   298: dup_x1
    //   299: swap
    //   300: ldc -62
    //   302: iconst_1
    //   303: aload 7
    //   305: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   308: athrow
    //   309: new 44	gnu/mapping/WrongType
    //   312: dup_x1
    //   313: swap
    //   314: ldc 116
    //   316: iconst_1
    //   317: aload 7
    //   319: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   322: athrow
    //   323: new 44	gnu/mapping/WrongType
    //   326: dup_x1
    //   327: swap
    //   328: ldc -95
    //   330: iconst_1
    //   331: aload 7
    //   333: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   336: athrow
    //   337: new 44	gnu/mapping/WrongType
    //   340: dup_x1
    //   341: swap
    //   342: ldc -62
    //   344: iconst_1
    //   345: aload 7
    //   347: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   350: athrow
    // Line number table:
    //   Java source line #175	-> byte code offset #0
    //   Java source line #176	-> byte code offset #0
    //   Java source line #177	-> byte code offset #7
    //   Java source line #178	-> byte code offset #14
    //   Java source line #179	-> byte code offset #19
    //   Java source line #180	-> byte code offset #22
    //   Java source line #179	-> byte code offset #42
    //   Java source line #181	-> byte code offset #61
    //   Java source line #182	-> byte code offset #78
    //   Java source line #183	-> byte code offset #102
    //   Java source line #184	-> byte code offset #152
    //   Java source line #185	-> byte code offset #186
    //   Java source line #187	-> byte code offset #190
    //   Java source line #180	-> byte code offset #197
    //   Java source line #179	-> byte code offset #211
    //   Java source line #181	-> byte code offset #225
    //   Java source line #182	-> byte code offset #239
    //   Java source line #183	-> byte code offset #267
    //   Java source line #184	-> byte code offset #323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	seq	gnu.lists.Sequence
    //   0	196	1	less$Qu	Object
    //   0	196	2	key	Object
    //   13	157	3	ret	Object
    //   20	42	4	crt	Object
    //   30	59	5	localObject1	Object
    //   102	132	5	scar	Object
    //   80	1	6	localSequence	gnu.lists.Sequence
    //   100	148	6	scdr	Object
    //   92	254	7	localObject2	Object
    //   197	1	10	localClassCastException1	ClassCastException
    //   211	1	11	localClassCastException2	ClassCastException
    //   225	1	12	localClassCastException3	ClassCastException
    //   239	1	13	localClassCastException4	ClassCastException
    //   253	1	14	localClassCastException5	ClassCastException
    //   267	1	15	localClassCastException6	ClassCastException
    //   281	1	16	localClassCastException7	ClassCastException
    //   295	1	17	localClassCastException8	ClassCastException
    //   309	1	18	localClassCastException9	ClassCastException
    //   323	1	19	localClassCastException10	ClassCastException
    //   337	1	20	localClassCastException11	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   32	35	197	java/lang/ClassCastException
    //   52	55	211	java/lang/ClassCastException
    //   71	74	225	java/lang/ClassCastException
    //   82	85	239	java/lang/ClassCastException
    //   94	97	253	java/lang/ClassCastException
    //   106	109	267	java/lang/ClassCastException
    //   118	121	281	java/lang/ClassCastException
    //   131	134	295	java/lang/ClassCastException
    //   143	146	309	java/lang/ClassCastException
    //   161	164	323	java/lang/ClassCastException
    //   178	181	337	java/lang/ClassCastException
  }
  
  /* Error */
  static Object rank$Mn1Array$To$List(gnu.lists.Sequence seq)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 54 1 0
    //   6: iconst_1
    //   7: isub
    //   8: getstatic 254	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   11: astore_2
    //   12: istore_1
    //   13: iload_1
    //   14: ifge +7 -> 21
    //   17: aload_2
    //   18: goto +21 -> 39
    //   21: aload_0
    //   22: iload_1
    //   23: invokeinterface 73 2 0
    //   28: aload_2
    //   29: invokestatic 165	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   32: astore_2
    //   33: iinc 1 -1
    //   36: goto -23 -> 13
    //   39: areturn
    // Line number table:
    //   Java source line #162	-> byte code offset #0
    //   Java source line #163	-> byte code offset #0
    //   Java source line #165	-> byte code offset #13
    //   Java source line #166	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	seq	gnu.lists.Sequence
    //   13	26	1	idx	int
    //   13	26	2	lst	Object
  }
  
  public static gnu.lists.FVector $PcSortVector(gnu.lists.Sequence paramSequence, Object paramObject)
  {
    return $PcSortVector(paramSequence, paramObject, Boolean.FALSE);
  }
  
  /* Error */
  public static gnu.lists.FVector $PcSortVector(gnu.lists.Sequence seq, Object less$Qu, Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 54 1 0
    //   6: istore_3
    //   7: iload_3
    //   8: invokestatic 232	kawa/lib/vectors:makeVector	(I)Lgnu/lists/FVector;
    //   11: astore 4
    //   13: aload_0
    //   14: invokestatic 204	kawa/lib/srfi95:rank$Mn1Array$To$List	(Lgnu/lists/Sequence;)Ljava/lang/Object;
    //   17: aload_1
    //   18: aload_2
    //   19: invokestatic 192	kawa/lib/srfi95:$PcSortList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   22: getstatic 207	kawa/lib/srfi95:Lit3	Lgnu/math/IntNum;
    //   25: astore 6
    //   27: astore 5
    //   29: aload 5
    //   31: invokestatic 26	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   34: ifne +57 -> 91
    //   37: aload 4
    //   39: aload 6
    //   41: dup
    //   42: astore 7
    //   44: invokevirtual 237	java/lang/Number:intValue	()I
    //   47: aload 5
    //   49: ldc 114
    //   51: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: dup
    //   55: astore 7
    //   57: checkcast 114	gnu/lists/Pair
    //   60: invokestatic 123	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   63: invokestatic 243	kawa/lib/vectors:vectorSet$Ex	(Lgnu/lists/FVector;ILjava/lang/Object;)V
    //   66: aload 5
    //   68: ldc 114
    //   70: invokestatic 40	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   73: dup
    //   74: astore 7
    //   76: checkcast 114	gnu/lists/Pair
    //   79: invokestatic 119	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   82: aload 6
    //   84: iconst_1
    //   85: invokestatic 222	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   88: goto -63 -> 25
    //   91: aload 4
    //   93: areturn
    //   94: new 44	gnu/mapping/WrongType
    //   97: dup_x1
    //   98: swap
    //   99: ldc -17
    //   101: iconst_2
    //   102: aload 7
    //   104: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   107: athrow
    //   108: new 44	gnu/mapping/WrongType
    //   111: dup_x1
    //   112: swap
    //   113: ldc 121
    //   115: iconst_1
    //   116: aload 7
    //   118: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   121: athrow
    //   122: new 44	gnu/mapping/WrongType
    //   125: dup_x1
    //   126: swap
    //   127: ldc 116
    //   129: iconst_1
    //   130: aload 7
    //   132: invokespecial 50	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    // Line number table:
    //   Java source line #196	-> byte code offset #0
    //   Java source line #197	-> byte code offset #0
    //   Java source line #198	-> byte code offset #7
    //   Java source line #199	-> byte code offset #13
    //   Java source line #202	-> byte code offset #29
    //   Java source line #203	-> byte code offset #37
    //   Java source line #200	-> byte code offset #66
    //   Java source line #201	-> byte code offset #82
    //   Java source line #199	-> byte code offset #91
    //   Java source line #202	-> byte code offset #91
    //   Java source line #203	-> byte code offset #94
    //   Java source line #200	-> byte code offset #122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	seq	gnu.lists.Sequence
    //   0	93	1	less$Qu	Object
    //   0	93	2	key	Object
    //   6	2	3	dim	int
    //   11	81	4	newra	gnu.lists.FVector
    //   27	40	5	sorted	Object
    //   25	1	6	localIntNum1	gnu.math.IntNum
    //   29	54	6	i	gnu.math.IntNum
    //   42	89	7	localObject1	Object
    //   94	1	9	localClassCastException1	ClassCastException
    //   108	1	10	localClassCastException2	ClassCastException
    //   122	1	11	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   44	47	94	java/lang/ClassCastException
    //   57	60	108	java/lang/ClassCastException
    //   76	79	122	java/lang/ClassCastException
  }
  
  public static Object sort(gnu.lists.Sequence paramSequence, Object paramObject)
  {
    return sort(paramSequence, paramObject, Boolean.FALSE);
  }
  
  static
  {
    Lit11 = gnu.mapping.Symbol.valueOf("%sort-vector");
    Lit10 = gnu.mapping.Symbol.valueOf("%vector-sort!");
    Lit9 = gnu.mapping.Symbol.valueOf("sort!");
    Lit8 = gnu.mapping.Symbol.valueOf("%sort-list");
    Lit7 = gnu.mapping.Symbol.valueOf("merge!");
    Lit6 = gnu.mapping.Symbol.valueOf("merge");
    Lit5 = gnu.mapping.Symbol.valueOf("sorted?");
    Lit4 = gnu.mapping.Symbol.valueOf("identity");
    Lit3 = gnu.math.IntNum.valueOf(0);
    Lit2 = gnu.math.IntNum.valueOf(1);
    Lit1 = gnu.math.IntNum.valueOf(2);
    Lit0 = gnu.math.IntNum.valueOf(-1);
    $instance = new srfi95();
    srfi95 localSrfi95 = $instance;
    identity = new ModuleMethod(localSrfi95, 1, Lit4, 4097);
    sorted$Qu = new ModuleMethod(localSrfi95, 2, Lit5, 12290);
    merge = new ModuleMethod(localSrfi95, 4, Lit6, 16387);
    merge$Ex = new ModuleMethod(localSrfi95, 6, Lit7, 16387);
    $Pcsort$Mnlist = new ModuleMethod(localSrfi95, 8, Lit8, 12291);
    sort$Ex = new ModuleMethod(localSrfi95, 9, Lit9, 12290);
    $Pcvector$Mnsort$Ex = new ModuleMethod(localSrfi95, 11, Lit10, 12291);
    $Pcsort$Mnvector = new ModuleMethod(localSrfi95, 12, Lit11, 12290);
    sort = new ModuleMethod(localSrfi95, 14, Lit12, 12290);
    $runBody$();
  }
  
  public srfi95()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  public class frame
    extends gnu.expr.ModuleBody
  {
    Object key;
    Object less$Qu;
    
    public frame() {}
    
    /* Error */
    public Object lambda1loop(Object x, Object kx, Object a, Object y, Object ky, Object b)
    {
      // Byte code:
      //   0: getstatic 6	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: aload_0
      //   4: getfield 12	kawa/lib/srfi95$frame:less$Qu	Ljava/lang/Object;
      //   7: aload 5
      //   9: aload_2
      //   10: invokevirtual 18	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   13: invokestatic 24	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   16: ifeq +97 -> 113
      //   19: aload 6
      //   21: invokestatic 29	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   24: ifeq +16 -> 40
      //   27: aload 4
      //   29: aload_1
      //   30: aload_3
      //   31: invokestatic 33	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   34: invokestatic 33	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   37: goto +166 -> 203
      //   40: aload 4
      //   42: aload_0
      //   43: aload_1
      //   44: aload_2
      //   45: aload_3
      //   46: aload 6
      //   48: ldc 35
      //   50: invokestatic 41	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   53: dup
      //   54: astore 7
      //   56: checkcast 35	gnu/lists/Pair
      //   59: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   62: getstatic 6	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   65: aload_0
      //   66: getfield 57	kawa/lib/srfi95$frame:key	Ljava/lang/Object;
      //   69: aload 6
      //   71: ldc 35
      //   73: invokestatic 41	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   76: dup
      //   77: astore 7
      //   79: checkcast 35	gnu/lists/Pair
      //   82: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   85: invokevirtual 61	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   88: aload 6
      //   90: ldc 35
      //   92: invokestatic 41	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   95: dup
      //   96: astore 7
      //   98: checkcast 35	gnu/lists/Pair
      //   101: invokestatic 65	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   104: invokevirtual 69	kawa/lib/srfi95$frame:lambda1loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   107: invokestatic 33	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   110: goto +93 -> 203
      //   113: aload_3
      //   114: invokestatic 29	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   117: ifeq +17 -> 134
      //   120: aload_1
      //   121: aload 4
      //   123: aload 6
      //   125: invokestatic 33	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   128: invokestatic 33	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   131: goto +72 -> 203
      //   134: aload_1
      //   135: aload_0
      //   136: aload_3
      //   137: ldc 35
      //   139: invokestatic 41	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   142: dup
      //   143: astore 7
      //   145: checkcast 35	gnu/lists/Pair
      //   148: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   151: getstatic 6	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   154: aload_0
      //   155: getfield 57	kawa/lib/srfi95$frame:key	Ljava/lang/Object;
      //   158: aload_3
      //   159: ldc 35
      //   161: invokestatic 41	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   164: dup
      //   165: astore 7
      //   167: checkcast 35	gnu/lists/Pair
      //   170: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   173: invokevirtual 61	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   176: aload_3
      //   177: ldc 35
      //   179: invokestatic 41	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   182: dup
      //   183: astore 7
      //   185: checkcast 35	gnu/lists/Pair
      //   188: invokestatic 65	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   191: aload 4
      //   193: aload 5
      //   195: aload 6
      //   197: invokevirtual 69	kawa/lib/srfi95$frame:lambda1loop	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   200: invokestatic 33	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   203: areturn
      //   204: new 45	gnu/mapping/WrongType
      //   207: dup_x1
      //   208: swap
      //   209: ldc 47
      //   211: iconst_1
      //   212: aload 7
      //   214: invokespecial 51	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   217: athrow
      //   218: new 45	gnu/mapping/WrongType
      //   221: dup_x1
      //   222: swap
      //   223: ldc 47
      //   225: iconst_1
      //   226: aload 7
      //   228: invokespecial 51	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   231: athrow
      //   232: new 45	gnu/mapping/WrongType
      //   235: dup_x1
      //   236: swap
      //   237: ldc 63
      //   239: iconst_1
      //   240: aload 7
      //   242: invokespecial 51	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   245: athrow
      //   246: new 45	gnu/mapping/WrongType
      //   249: dup_x1
      //   250: swap
      //   251: ldc 47
      //   253: iconst_1
      //   254: aload 7
      //   256: invokespecial 51	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   259: athrow
      //   260: new 45	gnu/mapping/WrongType
      //   263: dup_x1
      //   264: swap
      //   265: ldc 47
      //   267: iconst_1
      //   268: aload 7
      //   270: invokespecial 51	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   273: athrow
      //   274: new 45	gnu/mapping/WrongType
      //   277: dup_x1
      //   278: swap
      //   279: ldc 63
      //   281: iconst_1
      //   282: aload 7
      //   284: invokespecial 51	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   287: athrow
      // Line number table:
      //   Java source line #79	-> byte code offset #0
      //   Java source line #80	-> byte code offset #19
      //   Java source line #81	-> byte code offset #27
      //   Java source line #82	-> byte code offset #40
      //   Java source line #84	-> byte code offset #113
      //   Java source line #85	-> byte code offset #120
      //   Java source line #86	-> byte code offset #134
      //   Java source line #82	-> byte code offset #204
      //   Java source line #86	-> byte code offset #246
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	204	0	this	frame
      //   0	203	1	x	Object
      //   0	203	2	kx	Object
      //   0	203	3	a	Object
      //   0	203	4	y	Object
      //   0	203	5	ky	Object
      //   0	203	6	b	Object
      //   54	229	7	localObject	Object
      //   204	1	8	localClassCastException1	ClassCastException
      //   218	1	9	localClassCastException2	ClassCastException
      //   232	1	10	localClassCastException3	ClassCastException
      //   246	1	11	localClassCastException4	ClassCastException
      //   260	1	12	localClassCastException5	ClassCastException
      //   274	1	13	localClassCastException6	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   56	59	204	java/lang/ClassCastException
      //   79	82	218	java/lang/ClassCastException
      //   98	101	232	java/lang/ClassCastException
      //   145	148	246	java/lang/ClassCastException
      //   167	170	260	java/lang/ClassCastException
      //   185	188	274	java/lang/ClassCastException
    }
  }
  
  public class frame0
    extends gnu.expr.ModuleBody
  {
    Object seq;
    Object less$Qu;
    
    public frame0() {}
    
    /* Error */
    public Object lambda2step(Object keyer, Object n)
    {
      // Byte code:
      //   0: aload_2
      //   1: getstatic 6	kawa/lib/srfi95:Lit1	Lgnu/math/IntNum;
      //   4: invokestatic 12	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   7: ifeq +54 -> 61
      //   10: getstatic 18	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
      //   13: aload_2
      //   14: getstatic 6	kawa/lib/srfi95:Lit1	Lgnu/math/IntNum;
      //   17: invokevirtual 24	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   20: astore_3
      //   21: aload_0
      //   22: aload_1
      //   23: aload_3
      //   24: invokevirtual 29	kawa/lib/srfi95$frame0:lambda2step	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   27: astore 4
      //   29: iconst_m1
      //   30: aload_2
      //   31: aload_3
      //   32: invokestatic 34	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   35: astore 5
      //   37: aload_0
      //   38: aload_1
      //   39: aload 5
      //   41: invokevirtual 29	kawa/lib/srfi95$frame0:lambda2step	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   44: astore 6
      //   46: aload 4
      //   48: aload 6
      //   50: aload_0
      //   51: getfield 38	kawa/lib/srfi95$frame0:less$Qu	Ljava/lang/Object;
      //   54: aload_1
      //   55: invokestatic 42	kawa/lib/srfi95:sort$ClMerge$Ex	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   58: goto +250 -> 308
      //   61: aload_2
      //   62: getstatic 6	kawa/lib/srfi95:Lit1	Lgnu/math/IntNum;
      //   65: invokestatic 45	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   68: ifeq +178 -> 246
      //   71: aload_0
      //   72: getfield 48	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   75: ldc 50
      //   77: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   80: dup
      //   81: astore 4
      //   83: checkcast 50	gnu/lists/Pair
      //   86: invokestatic 71	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   89: astore_3
      //   90: aload_0
      //   91: getfield 48	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   94: invokestatic 75	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   97: astore 4
      //   99: aload_0
      //   100: getfield 48	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   103: astore 5
      //   105: aload_0
      //   106: aload_0
      //   107: getfield 48	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   110: invokestatic 78	kawa/lib/lists:cddr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   113: putfield 48	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   116: getstatic 84	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   119: aload_0
      //   120: getfield 38	kawa/lib/srfi95$frame0:less$Qu	Ljava/lang/Object;
      //   123: aload_1
      //   124: ldc 20
      //   126: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   129: checkcast 20	gnu/mapping/Procedure
      //   132: aload 4
      //   134: invokevirtual 87	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   137: aload_1
      //   138: ldc 20
      //   140: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   143: checkcast 20	gnu/mapping/Procedure
      //   146: aload_3
      //   147: invokevirtual 87	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   150: invokevirtual 91	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   153: invokestatic 97	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   156: ifeq +52 -> 208
      //   159: aload 5
      //   161: ldc 50
      //   163: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   166: dup
      //   167: astore 6
      //   169: checkcast 50	gnu/lists/Pair
      //   172: aload 4
      //   174: invokestatic 103	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   177: aload 5
      //   179: ldc 50
      //   181: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   184: dup
      //   185: astore 6
      //   187: checkcast 50	gnu/lists/Pair
      //   190: invokestatic 107	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   193: ldc 50
      //   195: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   198: dup
      //   199: astore 6
      //   201: checkcast 50	gnu/lists/Pair
      //   204: aload_3
      //   205: invokestatic 103	kawa/lib/lists:setCar$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   208: aload 5
      //   210: ldc 50
      //   212: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   215: dup
      //   216: astore 6
      //   218: checkcast 50	gnu/lists/Pair
      //   221: invokestatic 107	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   224: ldc 50
      //   226: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   229: dup
      //   230: astore 6
      //   232: checkcast 50	gnu/lists/Pair
      //   235: getstatic 115	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   238: invokestatic 118	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   241: aload 5
      //   243: goto +65 -> 308
      //   246: aload_2
      //   247: getstatic 121	kawa/lib/srfi95:Lit2	Lgnu/math/IntNum;
      //   250: invokestatic 45	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   253: ifeq +52 -> 305
      //   256: aload_0
      //   257: getfield 48	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   260: astore_3
      //   261: aload_0
      //   262: aload_0
      //   263: getfield 48	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   266: ldc 50
      //   268: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   271: dup
      //   272: astore 4
      //   274: checkcast 50	gnu/lists/Pair
      //   277: invokestatic 107	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   280: putfield 48	kawa/lib/srfi95$frame0:seq	Ljava/lang/Object;
      //   283: aload_3
      //   284: ldc 50
      //   286: invokestatic 56	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   289: dup
      //   290: astore 4
      //   292: checkcast 50	gnu/lists/Pair
      //   295: getstatic 115	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   298: invokestatic 118	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   301: aload_3
      //   302: goto +6 -> 308
      //   305: getstatic 115	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   308: areturn
      //   309: new 60	gnu/mapping/WrongType
      //   312: dup_x1
      //   313: swap
      //   314: ldc 62
      //   316: iconst_1
      //   317: aload 4
      //   319: invokespecial 66	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   322: athrow
      //   323: new 60	gnu/mapping/WrongType
      //   326: dup_x1
      //   327: swap
      //   328: ldc 99
      //   330: iconst_1
      //   331: aload 6
      //   333: invokespecial 66	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   336: athrow
      //   337: new 60	gnu/mapping/WrongType
      //   340: dup_x1
      //   341: swap
      //   342: ldc 105
      //   344: iconst_1
      //   345: aload 6
      //   347: invokespecial 66	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   350: athrow
      //   351: new 60	gnu/mapping/WrongType
      //   354: dup_x1
      //   355: swap
      //   356: ldc 99
      //   358: iconst_1
      //   359: aload 6
      //   361: invokespecial 66	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   364: athrow
      //   365: new 60	gnu/mapping/WrongType
      //   368: dup_x1
      //   369: swap
      //   370: ldc 105
      //   372: iconst_1
      //   373: aload 6
      //   375: invokespecial 66	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   378: athrow
      //   379: new 60	gnu/mapping/WrongType
      //   382: dup_x1
      //   383: swap
      //   384: ldc 109
      //   386: iconst_1
      //   387: aload 6
      //   389: invokespecial 66	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   392: athrow
      //   393: new 60	gnu/mapping/WrongType
      //   396: dup_x1
      //   397: swap
      //   398: ldc 105
      //   400: iconst_1
      //   401: aload 4
      //   403: invokespecial 66	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   406: athrow
      //   407: new 60	gnu/mapping/WrongType
      //   410: dup_x1
      //   411: swap
      //   412: ldc 109
      //   414: iconst_1
      //   415: aload 4
      //   417: invokespecial 66	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   420: athrow
      // Line number table:
      //   Java source line #126	-> byte code offset #0
      //   Java source line #127	-> byte code offset #0
      //   Java source line #128	-> byte code offset #21
      //   Java source line #127	-> byte code offset #29
      //   Java source line #129	-> byte code offset #29
      //   Java source line #127	-> byte code offset #37
      //   Java source line #130	-> byte code offset #37
      //   Java source line #131	-> byte code offset #46
      //   Java source line #132	-> byte code offset #61
      //   Java source line #133	-> byte code offset #90
      //   Java source line #134	-> byte code offset #99
      //   Java source line #135	-> byte code offset #105
      //   Java source line #136	-> byte code offset #116
      //   Java source line #137	-> byte code offset #159
      //   Java source line #138	-> byte code offset #177
      //   Java source line #139	-> byte code offset #208
      //   Java source line #140	-> byte code offset #241
      //   Java source line #141	-> byte code offset #246
      //   Java source line #142	-> byte code offset #261
      //   Java source line #143	-> byte code offset #283
      //   Java source line #144	-> byte code offset #301
      //   Java source line #132	-> byte code offset #309
      //   Java source line #137	-> byte code offset #323
      //   Java source line #138	-> byte code offset #337
      //   Java source line #139	-> byte code offset #365
      //   Java source line #142	-> byte code offset #393
      //   Java source line #143	-> byte code offset #407
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	309	0	this	frame0
      //   0	308	1	keyer	Object
      //   0	308	2	n	Object
      //   20	70	3	j	Object
      //   105	100	3	x	Object
      //   260	42	3	p	Object
      //   27	71	4	a	Object
      //   105	311	4	y	Object
      //   35	5	5	k	Object
      //   103	139	5	p	Object
      //   44	344	6	b	Object
      //   309	1	11	localClassCastException1	ClassCastException
      //   323	1	12	localClassCastException2	ClassCastException
      //   337	1	13	localClassCastException3	ClassCastException
      //   351	1	14	localClassCastException4	ClassCastException
      //   365	1	15	localClassCastException5	ClassCastException
      //   379	1	16	localClassCastException6	ClassCastException
      //   393	1	17	localClassCastException7	ClassCastException
      //   407	1	18	localClassCastException8	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   83	86	309	java/lang/ClassCastException
      //   169	172	323	java/lang/ClassCastException
      //   187	190	337	java/lang/ClassCastException
      //   201	204	351	java/lang/ClassCastException
      //   218	221	365	java/lang/ClassCastException
      //   232	235	379	java/lang/ClassCastException
      //   274	277	393	java/lang/ClassCastException
      //   292	295	407	java/lang/ClassCastException
    }
  }
  
  public class frame1
    extends gnu.expr.ModuleBody
  {
    Object key;
    Object less$Qu;
    
    public frame1() {}
    
    /* Error */
    public Object lambda3loop(Object r, Object a, Object kcara, Object b, Object kcarb)
    {
      // Byte code:
      //   0: getstatic 6	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   3: aload_0
      //   4: getfield 12	kawa/lib/srfi95$frame1:less$Qu	Ljava/lang/Object;
      //   7: aload 5
      //   9: aload_3
      //   10: invokevirtual 18	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   13: invokestatic 24	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   16: ifeq +106 -> 122
      //   19: aload_1
      //   20: ldc 26
      //   22: invokestatic 32	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   25: dup
      //   26: astore 6
      //   28: checkcast 26	gnu/lists/Pair
      //   31: aload 4
      //   33: invokestatic 48	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   36: aload 4
      //   38: ldc 26
      //   40: invokestatic 32	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   43: dup
      //   44: astore 6
      //   46: checkcast 26	gnu/lists/Pair
      //   49: invokestatic 53	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   52: invokestatic 56	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   55: ifeq +26 -> 81
      //   58: aload 4
      //   60: ldc 26
      //   62: invokestatic 32	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   65: dup
      //   66: astore 6
      //   68: checkcast 26	gnu/lists/Pair
      //   71: aload_2
      //   72: invokestatic 48	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   75: getstatic 62	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   78: goto +140 -> 218
      //   81: aload 4
      //   83: aload 4
      //   85: ldc 26
      //   87: invokestatic 32	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   90: dup
      //   91: astore 6
      //   93: checkcast 26	gnu/lists/Pair
      //   96: invokestatic 53	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   99: getstatic 6	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   102: aload_0
      //   103: getfield 65	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
      //   106: aload 4
      //   108: invokestatic 69	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   111: invokevirtual 73	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   114: astore 5
      //   116: astore 4
      //   118: astore_1
      //   119: goto -119 -> 0
      //   122: aload_1
      //   123: ldc 26
      //   125: invokestatic 32	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   128: dup
      //   129: astore 6
      //   131: checkcast 26	gnu/lists/Pair
      //   134: aload_2
      //   135: invokestatic 48	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   138: aload_2
      //   139: ldc 26
      //   141: invokestatic 32	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   144: dup
      //   145: astore 6
      //   147: checkcast 26	gnu/lists/Pair
      //   150: invokestatic 53	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   153: invokestatic 56	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   156: ifeq +26 -> 182
      //   159: aload_2
      //   160: ldc 26
      //   162: invokestatic 32	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   165: dup
      //   166: astore 6
      //   168: checkcast 26	gnu/lists/Pair
      //   171: aload 4
      //   173: invokestatic 48	kawa/lib/lists:setCdr$Ex	(Lgnu/lists/Pair;Ljava/lang/Object;)V
      //   176: getstatic 62	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   179: goto +39 -> 218
      //   182: aload_2
      //   183: aload_2
      //   184: ldc 26
      //   186: invokestatic 32	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   189: dup
      //   190: astore 6
      //   192: checkcast 26	gnu/lists/Pair
      //   195: invokestatic 53	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   198: getstatic 6	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   201: aload_0
      //   202: getfield 65	kawa/lib/srfi95$frame1:key	Ljava/lang/Object;
      //   205: aload_2
      //   206: invokestatic 69	kawa/lib/lists:cadr	(Ljava/lang/Object;)Ljava/lang/Object;
      //   209: invokevirtual 73	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   212: astore_3
      //   213: astore_2
      //   214: astore_1
      //   215: goto -215 -> 0
      //   218: areturn
      //   219: new 36	gnu/mapping/WrongType
      //   222: dup_x1
      //   223: swap
      //   224: ldc 38
      //   226: iconst_1
      //   227: aload 6
      //   229: invokespecial 42	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   232: athrow
      //   233: new 36	gnu/mapping/WrongType
      //   236: dup_x1
      //   237: swap
      //   238: ldc 50
      //   240: iconst_1
      //   241: aload 6
      //   243: invokespecial 42	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   246: athrow
      //   247: new 36	gnu/mapping/WrongType
      //   250: dup_x1
      //   251: swap
      //   252: ldc 38
      //   254: iconst_1
      //   255: aload 6
      //   257: invokespecial 42	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   260: athrow
      //   261: new 36	gnu/mapping/WrongType
      //   264: dup_x1
      //   265: swap
      //   266: ldc 50
      //   268: iconst_1
      //   269: aload 6
      //   271: invokespecial 42	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   274: athrow
      //   275: new 36	gnu/mapping/WrongType
      //   278: dup_x1
      //   279: swap
      //   280: ldc 38
      //   282: iconst_1
      //   283: aload 6
      //   285: invokespecial 42	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   288: athrow
      //   289: new 36	gnu/mapping/WrongType
      //   292: dup_x1
      //   293: swap
      //   294: ldc 50
      //   296: iconst_1
      //   297: aload 6
      //   299: invokespecial 42	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   302: athrow
      //   303: new 36	gnu/mapping/WrongType
      //   306: dup_x1
      //   307: swap
      //   308: ldc 38
      //   310: iconst_1
      //   311: aload 6
      //   313: invokespecial 42	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   316: athrow
      //   317: new 36	gnu/mapping/WrongType
      //   320: dup_x1
      //   321: swap
      //   322: ldc 50
      //   324: iconst_1
      //   325: aload 6
      //   327: invokespecial 42	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   330: athrow
      // Line number table:
      //   Java source line #89	-> byte code offset #0
      //   Java source line #90	-> byte code offset #0
      //   Java source line #91	-> byte code offset #19
      //   Java source line #92	-> byte code offset #36
      //   Java source line #93	-> byte code offset #58
      //   Java source line #94	-> byte code offset #81
      //   Java source line #96	-> byte code offset #122
      //   Java source line #97	-> byte code offset #138
      //   Java source line #98	-> byte code offset #159
      //   Java source line #99	-> byte code offset #182
      //   Java source line #91	-> byte code offset #219
      //   Java source line #92	-> byte code offset #233
      //   Java source line #93	-> byte code offset #247
      //   Java source line #94	-> byte code offset #261
      //   Java source line #96	-> byte code offset #275
      //   Java source line #97	-> byte code offset #289
      //   Java source line #98	-> byte code offset #303
      //   Java source line #99	-> byte code offset #317
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	219	0	this	frame1
      //   0	218	1	r	Object
      //   0	218	2	a	Object
      //   0	218	3	kcara	Object
      //   0	218	4	b	Object
      //   0	218	5	kcarb	Object
      // Exception table:
      //   from	to	target	type
      //   28	31	219	java/lang/ClassCastException
      //   46	49	233	java/lang/ClassCastException
      //   68	71	247	java/lang/ClassCastException
      //   93	96	261	java/lang/ClassCastException
      //   131	134	275	java/lang/ClassCastException
      //   147	150	289	java/lang/ClassCastException
      //   168	171	303	java/lang/ClassCastException
      //   192	195	317	java/lang/ClassCastException
    }
  }
}
