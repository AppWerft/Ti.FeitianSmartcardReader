package kawa.lib.rnrs;

import gnu.expr.ModuleMethod;

public class lists extends gnu.expr.ModuleBody { public static final ModuleMethod find;
  public static final ModuleMethod for$Mnall; public static final ModuleMethod exists; public static final ModuleMethod filter; public static final ModuleMethod partition; public static final ModuleMethod fold$Mnleft; public static final ModuleMethod fold$Mnright; public static final ModuleMethod remp; public static final ModuleMethod remove; public static final ModuleMethod remv; public static final ModuleMethod remq; public static final ModuleMethod memp; public static final gnu.kawa.reflect.StaticFieldLocation member; public static final gnu.kawa.reflect.StaticFieldLocation memv; public static final gnu.kawa.reflect.StaticFieldLocation memq; public static final ModuleMethod assp; public static final gnu.kawa.reflect.StaticFieldLocation assoc; public static final gnu.kawa.reflect.StaticFieldLocation assv;
  private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.kawa.reflect.StaticFieldLocation assq;
  public static final ModuleMethod cons$St; public static lists $instance; static final gnu.mapping.SimpleSymbol Lit0; static final gnu.mapping.SimpleSymbol Lit1; static final gnu.mapping.SimpleSymbol Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final gnu.mapping.SimpleSymbol Lit6;
  static { Lit12 = gnu.mapping.Symbol.valueOf("assp");Lit11 = gnu.mapping.Symbol.valueOf("memp");Lit10 = gnu.mapping.Symbol.valueOf("remq");Lit9 = gnu.mapping.Symbol.valueOf("remv");Lit8 = gnu.mapping.Symbol.valueOf("remove");Lit7 = gnu.mapping.Symbol.valueOf("remp");Lit6 = gnu.mapping.Symbol.valueOf("fold-right");Lit5 = gnu.mapping.Symbol.valueOf("fold-left");Lit4 = gnu.mapping.Symbol.valueOf("partition");Lit3 = gnu.mapping.Symbol.valueOf("filter");Lit2 = gnu.mapping.Symbol.valueOf("exists");Lit1 = gnu.mapping.Symbol.valueOf("for-all");Lit0 = gnu.mapping.Symbol.valueOf("find");$instance = new lists();memq = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.lists", "memq");memv = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.lists", "memv");member = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.lists", "member");assq = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.lists", "assq");assv = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.lists", "assv");assoc = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.lists", "assoc");lists localLists = $instance;find = new ModuleMethod(localLists, 5, Lit0, 8194);for$Mnall = new ModuleMethod(localLists, 6, Lit1, 61442);exists = new ModuleMethod(localLists, 7, Lit2, 61442);filter = new ModuleMethod(localLists, 8, Lit3, 8194);partition = new ModuleMethod(localLists, 9, Lit4, 8194);fold$Mnleft = new ModuleMethod(localLists, 10, Lit5, 61443);fold$Mnright = new ModuleMethod(localLists, 11, Lit6, 61443);remp = new ModuleMethod(localLists, 12, Lit7, 8194);remove = new ModuleMethod(localLists, 13, Lit8, 8194);remv = new ModuleMethod(localLists, 14, Lit9, 8194);remq = new ModuleMethod(localLists, 15, Lit10, 8194);memp = new ModuleMethod(localLists, 16, Lit11, 8194);assp = new ModuleMethod(localLists, 17, Lit12, 8194);cons$St = new ModuleMethod(localLists, 18, Lit13, 61440);$runBody$(); } static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13 = gnu.mapping.Symbol.valueOf("cons*");
  
  public class frame3 extends gnu.expr.ModuleBody { gnu.mapping.Procedure proc;
    final ModuleMethod lambda$Fn4;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 4) return lambda6(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 4) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda6(Object x) { return !gnu.expr.KawaConvert.isTrue(proc.apply1(x));
    }
    
    public frame3()
    {
      void tmp18_15 = new ModuleMethod(this, 4, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:16");
      lambda$Fn4 = tmp18_15;
    }
  }
  
  static gnu.mapping.Procedure complement(gnu.mapping.Procedure proc)
  {
    frame3 $heapFrame = new frame3();proc = proc;
    return lambda$Fn4;
  }
  
  static gnu.mapping.Values car$PlCdr(gnu.lists.Pair pair) {
    return gnu.mapping.Values.values2(kawa.lib.lists.car(pair), kawa.lib.lists.cdr(pair));
  }
  
















  static gnu.lists.Pair $PcCars$PlCdrs$SlPair(gnu.lists.LList lists)
  {
    Object localObject1 = $PcCars$PlCdrs(lists);int i = 0;i = gnu.mapping.Values.incrPos(localObject1, i);Object localObject2 = gnu.mapping.Values.getFromPos(localObject1, i);i = gnu.mapping.Values.incrPos(localObject1, i);Object cdrs = gnu.mapping.Values.getFromPosFinal(localObject1, i);
    Object cars; return kawa.lib.lists.cons(cars, cdrs);
  }
  









  static gnu.lists.LList $PcCars$Pl(gnu.lists.LList lists, Object lastElt)
  {
    frame6 $heapFrame = new frame6();last$Mnelt = lastElt;
    
    return (gnu.lists.LList)gnu.mapping.Promise.force($heapFrame.lambda9recur(lists), gnu.lists.LList.class); }
  public class frame6 extends gnu.expr.ModuleBody { public frame6() {} public Object lambda9recur(Object lists) { if (kawa.lib.lists.isPair(lists)) {} try { tmpTernaryOp = kawa.lib.lists.cons(kawa.lib.lists.caar(lists), lambda9recur(kawa.lib.lists.cdr((gnu.lists.Pair)(localObject = gnu.mapping.Promise.force(lists, gnu.lists.Pair.class)))));
        return gnu.lists.LList.list1(last$Mnelt);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new gnu.mapping.WrongType(
          localClassCastException, "cdr", 1, localObject);
      }
    }
    































































































































    Object last$Mnelt;
  }
  






























































































































  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 18:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 11: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 10: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 7: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 6: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  



































  public class frame
    extends gnu.expr.ModuleBody
  {
    gnu.mapping.Procedure combine;
    


































    Object nil;
    



































    public frame() {}
    



































    public Object lambda1recur(Object lists)
    {
      Object cdrs = lists.$PcCdrs(lists);
      try {
        return kawa.lib.lists.isNull(cdrs) ? nil : kawa.standard.Scheme.apply.apply2(combine, lists.$PcCars$Pl((gnu.lists.LList)(localObject1 = gnu.mapping.Promise.force(lists, gnu.lists.LList.class)), lambda1recur(cdrs))); } catch (ClassCastException localClassCastException) { Object localObject1; throw new gnu.mapping.WrongType(localClassCastException, "%cars+", 0, localObject1);
      }
    }
    
    /* Error */
    public Object lambda2recur(Object list)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 12	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   4: ifeq +10 -> 14
      //   7: aload_0
      //   8: getfield 18	kawa/lib/rnrs/lists$frame:nil	Ljava/lang/Object;
      //   11: goto +44 -> 55
      //   14: aload_1
      //   15: ldc 61
      //   17: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   20: dup
      //   21: astore_3
      //   22: checkcast 61	gnu/lists/Pair
      //   25: invokestatic 66	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   28: astore_2
      //   29: aload_0
      //   30: getfield 28	kawa/lib/rnrs/lists$frame:combine	Lgnu/mapping/Procedure;
      //   33: aload_2
      //   34: aload_0
      //   35: aload_1
      //   36: ldc 61
      //   38: invokestatic 36	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   41: dup
      //   42: astore_3
      //   43: checkcast 61	gnu/lists/Pair
      //   46: invokestatic 70	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   49: invokevirtual 73	kawa/lib/rnrs/lists$frame:lambda2recur	(Ljava/lang/Object;)Ljava/lang/Object;
      //   52: invokevirtual 59	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   55: areturn
      //   56: new 40	gnu/mapping/WrongType
      //   59: dup_x1
      //   60: swap
      //   61: ldc 63
      //   63: iconst_1
      //   64: aload_3
      //   65: invokespecial 46	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   68: athrow
      //   69: new 40	gnu/mapping/WrongType
      //   72: dup_x1
      //   73: swap
      //   74: ldc 68
      //   76: iconst_1
      //   77: aload_3
      //   78: invokespecial 46	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   81: athrow
      // Line number table:
      //   Java source line #237	-> byte code offset #0
      //   Java source line #238	-> byte code offset #14
      //   Java source line #239	-> byte code offset #29
      //   Java source line #238	-> byte code offset #56
      //   Java source line #239	-> byte code offset #69
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	56	0	this	frame
      //   0	55	1	list	Object
      //   28	6	2	head	Object
      //   21	57	3	localObject1	Object
      //   56	1	4	localClassCastException1	ClassCastException
      //   69	1	5	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   22	25	56	java/lang/ClassCastException
      //   43	46	69	java/lang/ClassCastException
    }
  }
  
  public static Object foldRight$V(gnu.mapping.Procedure combine, Object nil, gnu.lists.LList list1, Object[] argsArray)
  {
    frame $heapFrame = new frame();combine = combine;nil = nil; gnu.lists.LList localLList1; gnu.lists.LList lists = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    




















    return kawa.lib.lists.isPair(lists) ? $heapFrame.lambda1recur(kawa.lib.lists.cons(list1, lists)) : $heapFrame.lambda2recur(list1);
  }
  













  public static gnu.lists.LList remp(gnu.mapping.Procedure proc, gnu.lists.LList lst) { return (gnu.lists.LList)gnu.mapping.Promise.force(filter(complement(proc), lst), gnu.lists.LList.class); }
  
  public class frame0 extends gnu.expr.ModuleBody {
    Object obj;
    final ModuleMethod lambda$Fn1;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) {
      if (selector == 1) return lambda3(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda3(Object o) { return !gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(o, obj));
    }
    
    public frame0()
    {
      void tmp18_15 = new ModuleMethod(this, 1, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:259");
      lambda$Fn1 = tmp18_15;
    }
  }
  
  public static gnu.lists.LList remove(Object obj, gnu.lists.LList lst)
  {
    frame0 $heapFrame = new frame0();obj = obj;
    



    return (gnu.lists.LList)gnu.mapping.Promise.force(filter(lambda$Fn1, lst), gnu.lists.LList.class);
  }
  
  public class frame1 extends gnu.expr.ModuleBody {
    Object obj;
    final ModuleMethod lambda$Fn2;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 2) return lambda4(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 2) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda4(Object o) { return !gnu.kawa.functions.IsEqv.apply(o, obj);
    }
    
    public frame1()
    {
      void tmp18_15 = new ModuleMethod(this, 2, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:266");
      lambda$Fn2 = tmp18_15;
    }
  }
  
  public static gnu.lists.LList remv(Object obj, gnu.lists.LList lst)
  {
    frame1 $heapFrame = new frame1();obj = obj;
    



    return (gnu.lists.LList)gnu.mapping.Promise.force(filter(lambda$Fn2, lst), gnu.lists.LList.class);
  }
  
  public class frame2 extends gnu.expr.ModuleBody {
    Object obj;
    final ModuleMethod lambda$Fn3;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 3) return lambda5(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 3) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } boolean lambda5(Object o) { return o != obj;
    }
    
    public frame2()
    {
      void tmp18_15 = new ModuleMethod(this, 3, null, 4097);
      tmp18_15.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/rnrs/lists.scm:273");
      lambda$Fn3 = tmp18_15;
    }
  }
  
  public static gnu.lists.LList remq(Object obj, gnu.lists.LList lst)
  {
    frame2 $heapFrame = new frame2();obj = obj;
    



    return (gnu.lists.LList)gnu.mapping.Promise.force(filter(lambda$Fn3, lst), gnu.lists.LList.class);
  }
  

















































  public static Object cons$St(Object... args)
  {
    return gnu.lists.LList.consX(args);
  }
  
  /* Error */
  public static Object find(gnu.mapping.Procedure proc, gnu.lists.LList lst)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_2
    //   3: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   6: ifeq +9 -> 15
    //   9: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: goto +52 -> 64
    //   15: aload_2
    //   16: ldc 24
    //   18: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   21: dup
    //   22: astore 4
    //   24: checkcast 24	gnu/lists/Pair
    //   27: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   30: astore_3
    //   31: aload_0
    //   32: aload_3
    //   33: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   39: ifeq +7 -> 46
    //   42: aload_3
    //   43: goto +21 -> 64
    //   46: aload_2
    //   47: ldc 24
    //   49: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   52: dup
    //   53: astore 4
    //   55: checkcast 24	gnu/lists/Pair
    //   58: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   61: goto -60 -> 1
    //   64: areturn
    //   65: new 34	gnu/mapping/WrongType
    //   68: dup_x1
    //   69: swap
    //   70: ldc 36
    //   72: iconst_1
    //   73: aload 4
    //   75: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   78: athrow
    //   79: new 34	gnu/mapping/WrongType
    //   82: dup_x1
    //   83: swap
    //   84: ldc 56
    //   86: iconst_1
    //   87: aload 4
    //   89: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   92: athrow
    // Line number table:
    //   Java source line #65	-> byte code offset #0
    //   Java source line #66	-> byte code offset #0
    //   Java source line #72	-> byte code offset #0
    //   Java source line #73	-> byte code offset #2
    //   Java source line #74	-> byte code offset #15
    //   Java source line #75	-> byte code offset #31
    //   Java source line #76	-> byte code offset #46
    //   Java source line #74	-> byte code offset #65
    //   Java source line #76	-> byte code offset #79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	proc	gnu.mapping.Procedure
    //   0	64	1	lst	gnu.lists.LList
    //   2	62	2	list	Object
    //   31	33	3	x	Object
    // Exception table:
    //   from	to	target	type
    //   24	27	65	java/lang/ClassCastException
    //   55	58	79	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object forAll$V(gnu.mapping.Procedure proc, gnu.lists.LList list1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 64	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 67	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +202 -> 215
    //   16: aload_1
    //   17: aload_3
    //   18: invokestatic 71	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   21: invokestatic 77	kawa/lib/rnrs/lists:$PcCars$PlCdrs	(Lgnu/lists/LList;)Ljava/lang/Object;
    //   24: astore 4
    //   26: iconst_0
    //   27: istore 5
    //   29: aload 4
    //   31: iload 5
    //   33: invokestatic 83	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   36: istore 5
    //   38: aload 4
    //   40: iload 5
    //   42: invokestatic 87	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   45: astore 6
    //   47: aload 4
    //   49: iload 5
    //   51: invokestatic 83	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   54: istore 5
    //   56: aload 4
    //   58: iload 5
    //   60: invokestatic 90	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   63: astore 7
    //   65: aload 6
    //   67: invokestatic 67	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   70: ifeq +7 -> 77
    //   73: iconst_0
    //   74: goto +4 -> 78
    //   77: iconst_1
    //   78: istore 8
    //   80: iload 8
    //   82: ifeq +20 -> 102
    //   85: iload 8
    //   87: ifeq +9 -> 96
    //   90: getstatic 93	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   93: goto +241 -> 334
    //   96: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   99: goto +235 -> 334
    //   102: aload 6
    //   104: aload 7
    //   106: astore 10
    //   108: astore 9
    //   110: aload 10
    //   112: ldc 60
    //   114: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: dup
    //   118: astore 12
    //   120: checkcast 60	gnu/lists/LList
    //   123: invokestatic 77	kawa/lib/rnrs/lists:$PcCars$PlCdrs	(Lgnu/lists/LList;)Ljava/lang/Object;
    //   126: astore 11
    //   128: iconst_0
    //   129: istore 12
    //   131: aload 11
    //   133: iload 12
    //   135: invokestatic 83	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   138: istore 12
    //   140: aload 11
    //   142: iload 12
    //   144: invokestatic 87	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   147: astore 13
    //   149: aload 11
    //   151: iload 12
    //   153: invokestatic 83	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   156: istore 12
    //   158: aload 11
    //   160: iload 12
    //   162: invokestatic 90	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   165: astore 14
    //   167: aload 13
    //   169: invokestatic 67	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   172: ifeq +31 -> 203
    //   175: getstatic 101	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   178: aload_0
    //   179: aload 9
    //   181: invokevirtual 105	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   187: ifeq +10 -> 197
    //   190: aload 13
    //   192: aload 14
    //   194: goto -88 -> 106
    //   197: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   200: goto +134 -> 334
    //   203: getstatic 101	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   206: aload_0
    //   207: aload 9
    //   209: invokevirtual 105	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: goto +122 -> 334
    //   215: aload_1
    //   216: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   219: istore 4
    //   221: iload 4
    //   223: ifeq +20 -> 243
    //   226: iload 4
    //   228: ifeq +9 -> 237
    //   231: getstatic 93	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   234: goto +100 -> 334
    //   237: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   240: goto +94 -> 334
    //   243: aload_1
    //   244: dup
    //   245: astore 5
    //   247: checkcast 24	gnu/lists/Pair
    //   250: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   253: aload_1
    //   254: dup
    //   255: astore 5
    //   257: checkcast 24	gnu/lists/Pair
    //   260: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   263: astore 6
    //   265: astore 5
    //   267: aload 6
    //   269: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   272: ifeq +12 -> 284
    //   275: aload_0
    //   276: aload 5
    //   278: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   281: goto +53 -> 334
    //   284: aload_0
    //   285: aload 5
    //   287: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   293: ifeq +38 -> 331
    //   296: aload 6
    //   298: ldc 24
    //   300: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   303: dup
    //   304: astore 7
    //   306: checkcast 24	gnu/lists/Pair
    //   309: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   312: aload 6
    //   314: ldc 24
    //   316: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   319: dup
    //   320: astore 7
    //   322: checkcast 24	gnu/lists/Pair
    //   325: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   328: goto -65 -> 263
    //   331: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   334: areturn
    //   335: new 34	gnu/mapping/WrongType
    //   338: dup_x1
    //   339: swap
    //   340: ldc 95
    //   342: iconst_0
    //   343: aload 12
    //   345: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   348: athrow
    //   349: new 34	gnu/mapping/WrongType
    //   352: dup_x1
    //   353: swap
    //   354: ldc 36
    //   356: iconst_1
    //   357: aload 5
    //   359: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   362: athrow
    //   363: new 34	gnu/mapping/WrongType
    //   366: dup_x1
    //   367: swap
    //   368: ldc 56
    //   370: iconst_1
    //   371: aload 5
    //   373: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   376: athrow
    //   377: new 34	gnu/mapping/WrongType
    //   380: dup_x1
    //   381: swap
    //   382: ldc 36
    //   384: iconst_1
    //   385: aload 7
    //   387: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   390: athrow
    //   391: new 34	gnu/mapping/WrongType
    //   394: dup_x1
    //   395: swap
    //   396: ldc 56
    //   398: iconst_1
    //   399: aload 7
    //   401: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   404: athrow
    // Line number table:
    //   Java source line #79	-> byte code offset #0
    //   Java source line #80	-> byte code offset #9
    //   Java source line #95	-> byte code offset #9
    //   Java source line #97	-> byte code offset #16
    //   Java source line #98	-> byte code offset #65
    //   Java source line #99	-> byte code offset #102
    //   Java source line #100	-> byte code offset #110
    //   Java source line #101	-> byte code offset #167
    //   Java source line #102	-> byte code offset #175
    //   Java source line #103	-> byte code offset #203
    //   Java source line #105	-> byte code offset #215
    //   Java source line #106	-> byte code offset #243
    //   Java source line #107	-> byte code offset #267
    //   Java source line #108	-> byte code offset #275
    //   Java source line #109	-> byte code offset #284
    //   Java source line #100	-> byte code offset #335
    //   Java source line #106	-> byte code offset #349
    //   Java source line #109	-> byte code offset #377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	proc	gnu.mapping.Procedure
    //   0	334	1	list1	gnu.lists.LList
    //   0	334	2	argsArray	Object[]
    //   0	18	3	lists	gnu.lists.LList
    //   6	51	4	localObject1	Object
    //   219	8	4	x	boolean
    //   27	32	5	i	int
    //   245	11	5	localLList1	gnu.lists.LList
    //   265	107	5	head	Object
    //   45	1	6	localObject2	Object
    //   65	199	6	heads	Object
    //   267	46	6	tail	Object
    //   63	337	7	tails	Object
    //   78	8	8	x	boolean
    //   108	100	9	heads	Object
    //   106	1	10	localObject3	Object
    //   110	1	10	tails	Object
    //   126	33	11	localObject4	Object
    //   118	1	12	localObject5	Object
    //   129	215	12	j	int
    //   147	1	13	localObject6	Object
    //   167	24	13	next$Mnheads	Object
    //   165	28	14	next$Mntails	Object
    //   335	1	23	localClassCastException1	ClassCastException
    //   349	1	24	localClassCastException2	ClassCastException
    //   363	1	25	localClassCastException3	ClassCastException
    //   377	1	26	localClassCastException4	ClassCastException
    //   391	1	27	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   120	123	335	java/lang/ClassCastException
    //   247	250	349	java/lang/ClassCastException
    //   257	260	363	java/lang/ClassCastException
    //   306	309	377	java/lang/ClassCastException
    //   322	325	391	java/lang/ClassCastException
  }
  
  /* Error */
  static Object $PcCars$PlCdrs(gnu.lists.LList lists)
  {
    // Byte code:
    //   0: new 198	kawa/lang/Continuation
    //   3: dup
    //   4: invokestatic 6	gnu/mapping/CallContext:getInstance	()Lgnu/mapping/CallContext;
    //   7: dup
    //   8: astore_2
    //   9: invokespecial 201	kawa/lang/Continuation:<init>	(Lgnu/mapping/CallContext;)V
    //   12: astore_1
    //   13: aload_1
    //   14: astore 4
    //   16: new 203	kawa/lib/rnrs/lists$frame4
    //   19: dup
    //   20: invokespecial 204	kawa/lib/rnrs/lists$frame4:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: aload 4
    //   29: putfield 208	kawa/lib/rnrs/lists$frame4:abort	Lkawa/lang/Continuation;
    //   32: aload 5
    //   34: aload_0
    //   35: invokevirtual 211	kawa/lib/rnrs/lists$frame4:lambda7recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: aload_1
    //   39: iconst_1
    //   40: putfield 215	kawa/lang/Continuation:invoked	Z
    //   43: astore_3
    //   44: goto +8 -> 52
    //   47: aload_1
    //   48: invokestatic 219	kawa/lang/Continuation:handleException	(Ljava/lang/Throwable;Lkawa/lang/Continuation;)Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: areturn
    // Line number table:
    //   Java source line #22	-> byte code offset #0
    //   Java source line #23	-> byte code offset #0
    //   Java source line #26	-> byte code offset #0
    //   Java source line #27	-> byte code offset #14
    //   Java source line #28	-> byte code offset #32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	lists	gnu.lists.LList
    //   12	36	1	localContinuation1	kawa.lang.Continuation
    //   0	9	2	$ctx	gnu.mapping.CallContext
    //   43	10	3	localObject	Object
    //   14	14	4	abort	kawa.lang.Continuation
    //   23	10	5	$heapFrame	frame4
    // Exception table:
    //   from	to	target	type
    //   13	47	47	finally
  }
  
  /* Error */
  public static Object exists$V(gnu.mapping.Procedure proc, gnu.lists.LList list1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokestatic 64	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 4
    //   8: astore_3
    //   9: aload_3
    //   10: invokestatic 67	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   13: ifeq +157 -> 170
    //   16: aload_1
    //   17: aload_3
    //   18: invokestatic 71	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   21: invokestatic 77	kawa/lib/rnrs/lists:$PcCars$PlCdrs	(Lgnu/lists/LList;)Ljava/lang/Object;
    //   24: astore 4
    //   26: iconst_0
    //   27: istore 5
    //   29: aload 4
    //   31: iload 5
    //   33: invokestatic 83	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   36: istore 5
    //   38: aload 4
    //   40: iload 5
    //   42: invokestatic 87	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   45: astore 6
    //   47: aload 4
    //   49: iload 5
    //   51: invokestatic 83	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   54: istore 5
    //   56: aload 4
    //   58: iload 5
    //   60: invokestatic 90	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   63: astore 7
    //   65: aload 6
    //   67: invokestatic 67	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   70: ifeq +94 -> 164
    //   73: aload 6
    //   75: aload 7
    //   77: astore 9
    //   79: astore 8
    //   81: aload 9
    //   83: ldc 60
    //   85: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   88: dup
    //   89: astore 11
    //   91: checkcast 60	gnu/lists/LList
    //   94: invokestatic 111	kawa/lib/rnrs/lists:$PcCars$PlCdrs$SlPair	(Lgnu/lists/LList;)Lgnu/lists/Pair;
    //   97: astore 10
    //   99: aload 10
    //   101: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   104: astore 11
    //   106: aload 10
    //   108: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   111: astore 12
    //   113: aload 11
    //   115: invokestatic 67	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   118: ifeq +34 -> 152
    //   121: getstatic 101	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   124: aload_0
    //   125: aload 8
    //   127: invokevirtual 105	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   130: astore 13
    //   132: aload 13
    //   134: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   137: ifeq +8 -> 145
    //   140: aload 13
    //   142: goto +135 -> 277
    //   145: aload 11
    //   147: aload 12
    //   149: goto -72 -> 77
    //   152: getstatic 101	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   155: aload_0
    //   156: aload 8
    //   158: invokevirtual 105	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: goto +116 -> 277
    //   164: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   167: goto +110 -> 277
    //   170: aload_1
    //   171: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   174: ifne +100 -> 274
    //   177: aload_1
    //   178: dup
    //   179: astore 4
    //   181: checkcast 24	gnu/lists/Pair
    //   184: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   187: aload_1
    //   188: dup
    //   189: astore 4
    //   191: checkcast 24	gnu/lists/Pair
    //   194: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   197: astore 5
    //   199: astore 4
    //   201: aload 5
    //   203: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   206: ifeq +12 -> 218
    //   209: aload_0
    //   210: aload 4
    //   212: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   215: goto +62 -> 277
    //   218: aload_0
    //   219: aload 4
    //   221: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   224: astore 6
    //   226: aload 6
    //   228: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   231: ifeq +8 -> 239
    //   234: aload 6
    //   236: goto +41 -> 277
    //   239: aload 5
    //   241: ldc 24
    //   243: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   246: dup
    //   247: astore 7
    //   249: checkcast 24	gnu/lists/Pair
    //   252: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   255: aload 5
    //   257: ldc 24
    //   259: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   262: dup
    //   263: astore 7
    //   265: checkcast 24	gnu/lists/Pair
    //   268: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   271: goto -74 -> 197
    //   274: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   277: areturn
    //   278: new 34	gnu/mapping/WrongType
    //   281: dup_x1
    //   282: swap
    //   283: ldc 107
    //   285: iconst_0
    //   286: aload 11
    //   288: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   291: athrow
    //   292: new 34	gnu/mapping/WrongType
    //   295: dup_x1
    //   296: swap
    //   297: ldc 36
    //   299: iconst_1
    //   300: aload 4
    //   302: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   305: athrow
    //   306: new 34	gnu/mapping/WrongType
    //   309: dup_x1
    //   310: swap
    //   311: ldc 56
    //   313: iconst_1
    //   314: aload 4
    //   316: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   319: athrow
    //   320: new 34	gnu/mapping/WrongType
    //   323: dup_x1
    //   324: swap
    //   325: ldc 36
    //   327: iconst_1
    //   328: aload 7
    //   330: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   333: athrow
    //   334: new 34	gnu/mapping/WrongType
    //   337: dup_x1
    //   338: swap
    //   339: ldc 56
    //   341: iconst_1
    //   342: aload 7
    //   344: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   347: athrow
    // Line number table:
    //   Java source line #111	-> byte code offset #0
    //   Java source line #112	-> byte code offset #9
    //   Java source line #127	-> byte code offset #9
    //   Java source line #129	-> byte code offset #16
    //   Java source line #130	-> byte code offset #65
    //   Java source line #131	-> byte code offset #73
    //   Java source line #132	-> byte code offset #81
    //   Java source line #133	-> byte code offset #99
    //   Java source line #132	-> byte code offset #106
    //   Java source line #134	-> byte code offset #106
    //   Java source line #135	-> byte code offset #113
    //   Java source line #136	-> byte code offset #121
    //   Java source line #137	-> byte code offset #152
    //   Java source line #139	-> byte code offset #170
    //   Java source line #140	-> byte code offset #177
    //   Java source line #141	-> byte code offset #201
    //   Java source line #142	-> byte code offset #209
    //   Java source line #143	-> byte code offset #218
    //   Java source line #132	-> byte code offset #278
    //   Java source line #140	-> byte code offset #292
    //   Java source line #143	-> byte code offset #320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	proc	gnu.mapping.Procedure
    //   0	277	1	list1	gnu.lists.LList
    //   0	277	2	argsArray	Object[]
    //   0	18	3	lists	gnu.lists.LList
    //   6	184	4	localObject1	Object
    //   199	116	4	head	Object
    //   27	32	5	i	int
    //   197	1	5	localObject2	Object
    //   201	55	5	tail	Object
    //   45	1	6	localObject3	Object
    //   65	9	6	heads	Object
    //   224	11	6	x	Object
    //   63	280	7	tails	Object
    //   79	78	8	heads	Object
    //   77	1	9	localObject4	Object
    //   81	1	9	tails	Object
    //   97	10	10	split	gnu.lists.Pair
    //   89	1	11	localObject5	Object
    //   104	183	11	next$Mnheads	Object
    //   111	37	12	next$Mntails	Object
    //   130	11	13	x	Object
    //   278	1	21	localClassCastException1	ClassCastException
    //   292	1	22	localClassCastException2	ClassCastException
    //   306	1	23	localClassCastException3	ClassCastException
    //   320	1	24	localClassCastException4	ClassCastException
    //   334	1	25	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   91	94	278	java/lang/ClassCastException
    //   181	184	292	java/lang/ClassCastException
    //   191	194	306	java/lang/ClassCastException
    //   249	252	320	java/lang/ClassCastException
    //   265	268	334	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object filter(gnu.mapping.Procedure proc, gnu.lists.LList lst)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 115	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   4: astore_3
    //   5: astore_2
    //   6: aload_2
    //   7: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   10: ifeq +21 -> 31
    //   13: aload_3
    //   14: ldc 60
    //   16: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: astore 4
    //   22: checkcast 60	gnu/lists/LList
    //   25: invokestatic 121	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   28: goto +66 -> 94
    //   31: aload_2
    //   32: ldc 24
    //   34: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: dup
    //   38: astore 5
    //   40: checkcast 24	gnu/lists/Pair
    //   43: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   46: astore 4
    //   48: aload_2
    //   49: ldc 24
    //   51: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: dup
    //   55: astore 6
    //   57: checkcast 24	gnu/lists/Pair
    //   60: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   63: astore 5
    //   65: aload_0
    //   66: aload 4
    //   68: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   74: ifeq +14 -> 88
    //   77: aload 5
    //   79: aload 4
    //   81: aload_3
    //   82: invokestatic 71	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   85: goto -81 -> 4
    //   88: aload 5
    //   90: astore_2
    //   91: goto -85 -> 6
    //   94: areturn
    //   95: new 34	gnu/mapping/WrongType
    //   98: dup_x1
    //   99: swap
    //   100: ldc 117
    //   102: iconst_1
    //   103: aload 4
    //   105: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   108: athrow
    //   109: new 34	gnu/mapping/WrongType
    //   112: dup_x1
    //   113: swap
    //   114: ldc 36
    //   116: iconst_1
    //   117: aload 5
    //   119: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   122: athrow
    //   123: new 34	gnu/mapping/WrongType
    //   126: dup_x1
    //   127: swap
    //   128: ldc 56
    //   130: iconst_1
    //   131: aload 6
    //   133: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   136: athrow
    // Line number table:
    //   Java source line #146	-> byte code offset #0
    //   Java source line #147	-> byte code offset #0
    //   Java source line #157	-> byte code offset #0
    //   Java source line #158	-> byte code offset #6
    //   Java source line #159	-> byte code offset #13
    //   Java source line #160	-> byte code offset #31
    //   Java source line #161	-> byte code offset #48
    //   Java source line #162	-> byte code offset #65
    //   Java source line #163	-> byte code offset #77
    //   Java source line #164	-> byte code offset #88
    //   Java source line #159	-> byte code offset #95
    //   Java source line #160	-> byte code offset #109
    //   Java source line #161	-> byte code offset #123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	proc	gnu.mapping.Procedure
    //   0	94	1	lst	gnu.lists.LList
    //   6	88	2	list	Object
    //   6	88	3	res	Object
    //   65	29	4	head	Object
    //   65	29	5	tail	Object
    // Exception table:
    //   from	to	target	type
    //   22	25	95	java/lang/ClassCastException
    //   40	43	109	java/lang/ClassCastException
    //   57	60	123	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object partition(gnu.mapping.Procedure proc, gnu.lists.LList lst)
  {
    // Byte code:
    //   0: aload_1
    //   1: getstatic 115	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   4: getstatic 115	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   7: astore 4
    //   9: astore_3
    //   10: astore_2
    //   11: aload_2
    //   12: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   15: ifeq +40 -> 55
    //   18: aload_3
    //   19: ldc 60
    //   21: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   24: dup
    //   25: astore 5
    //   27: checkcast 60	gnu/lists/LList
    //   30: invokestatic 121	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   33: aload 4
    //   35: ldc 60
    //   37: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: dup
    //   41: astore 5
    //   43: checkcast 60	gnu/lists/LList
    //   46: invokestatic 121	kawa/lib/lists:reverse$Ex	(Lgnu/lists/LList;)Lgnu/lists/LList;
    //   49: invokestatic 125	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
    //   52: goto +77 -> 129
    //   55: aload_2
    //   56: ldc 24
    //   58: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 6
    //   64: checkcast 24	gnu/lists/Pair
    //   67: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   70: astore 5
    //   72: aload_2
    //   73: ldc 24
    //   75: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: dup
    //   79: astore 7
    //   81: checkcast 24	gnu/lists/Pair
    //   84: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   87: astore 6
    //   89: aload_0
    //   90: aload 5
    //   92: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   98: ifeq +16 -> 114
    //   101: aload 6
    //   103: aload 5
    //   105: aload_3
    //   106: invokestatic 71	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   109: astore_3
    //   110: astore_2
    //   111: goto -100 -> 11
    //   114: aload 6
    //   116: aload 5
    //   118: aload 4
    //   120: invokestatic 71	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   123: astore 4
    //   125: astore_2
    //   126: goto -115 -> 11
    //   129: areturn
    //   130: new 34	gnu/mapping/WrongType
    //   133: dup_x1
    //   134: swap
    //   135: ldc 117
    //   137: iconst_1
    //   138: aload 5
    //   140: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   143: athrow
    //   144: new 34	gnu/mapping/WrongType
    //   147: dup_x1
    //   148: swap
    //   149: ldc 117
    //   151: iconst_1
    //   152: aload 5
    //   154: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   157: athrow
    //   158: new 34	gnu/mapping/WrongType
    //   161: dup_x1
    //   162: swap
    //   163: ldc 36
    //   165: iconst_1
    //   166: aload 6
    //   168: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: new 34	gnu/mapping/WrongType
    //   175: dup_x1
    //   176: swap
    //   177: ldc 56
    //   179: iconst_1
    //   180: aload 7
    //   182: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   185: athrow
    // Line number table:
    //   Java source line #166	-> byte code offset #0
    //   Java source line #167	-> byte code offset #0
    //   Java source line #178	-> byte code offset #0
    //   Java source line #179	-> byte code offset #11
    //   Java source line #180	-> byte code offset #18
    //   Java source line #181	-> byte code offset #55
    //   Java source line #182	-> byte code offset #72
    //   Java source line #183	-> byte code offset #89
    //   Java source line #184	-> byte code offset #101
    //   Java source line #185	-> byte code offset #114
    //   Java source line #180	-> byte code offset #130
    //   Java source line #181	-> byte code offset #158
    //   Java source line #182	-> byte code offset #172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	proc	gnu.mapping.Procedure
    //   0	129	1	lst	gnu.lists.LList
    //   11	118	2	list	Object
    //   11	118	3	in	Object
    //   11	118	4	out	Object
    //   89	40	5	head	Object
    //   89	40	6	tail	Object
    // Exception table:
    //   from	to	target	type
    //   27	30	130	java/lang/ClassCastException
    //   43	46	144	java/lang/ClassCastException
    //   64	67	158	java/lang/ClassCastException
    //   81	84	172	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object foldLeft$V(gnu.mapping.Procedure combine, Object nil, gnu.lists.LList list1, Object[] argsArray)
  {
    // Byte code:
    //   0: aload_3
    //   1: iconst_0
    //   2: invokestatic 64	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   5: dup
    //   6: astore 5
    //   8: astore 4
    //   10: aload 4
    //   12: invokestatic 67	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   15: ifeq +100 -> 115
    //   18: aload_2
    //   19: aload 4
    //   21: invokestatic 71	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   24: aload_1
    //   25: astore 6
    //   27: astore 5
    //   29: aload 5
    //   31: ldc 60
    //   33: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: dup
    //   37: astore 8
    //   39: checkcast 60	gnu/lists/LList
    //   42: invokestatic 77	kawa/lib/rnrs/lists:$PcCars$PlCdrs	(Lgnu/lists/LList;)Ljava/lang/Object;
    //   45: astore 7
    //   47: iconst_0
    //   48: istore 8
    //   50: aload 7
    //   52: iload 8
    //   54: invokestatic 83	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   57: istore 8
    //   59: aload 7
    //   61: iload 8
    //   63: invokestatic 87	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   66: astore 9
    //   68: aload 7
    //   70: iload 8
    //   72: invokestatic 83	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
    //   75: istore 8
    //   77: aload 7
    //   79: iload 8
    //   81: invokestatic 90	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
    //   84: astore 10
    //   86: aload 9
    //   88: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   91: ifeq +8 -> 99
    //   94: aload 6
    //   96: goto +79 -> 175
    //   99: aload 10
    //   101: getstatic 101	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   104: aload_0
    //   105: aload 6
    //   107: aload 9
    //   109: invokevirtual 129	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   112: goto -87 -> 25
    //   115: aload_2
    //   116: aload_1
    //   117: astore 6
    //   119: astore 5
    //   121: aload 5
    //   123: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   126: ifeq +8 -> 134
    //   129: aload 6
    //   131: goto +44 -> 175
    //   134: aload 5
    //   136: ldc 24
    //   138: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   141: dup
    //   142: astore 7
    //   144: checkcast 24	gnu/lists/Pair
    //   147: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   150: aload_0
    //   151: aload 6
    //   153: aload 5
    //   155: ldc 24
    //   157: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   160: dup
    //   161: astore 7
    //   163: checkcast 24	gnu/lists/Pair
    //   166: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   169: invokevirtual 105	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: goto -55 -> 117
    //   175: areturn
    //   176: new 34	gnu/mapping/WrongType
    //   179: dup_x1
    //   180: swap
    //   181: ldc 95
    //   183: iconst_0
    //   184: aload 8
    //   186: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   189: athrow
    //   190: new 34	gnu/mapping/WrongType
    //   193: dup_x1
    //   194: swap
    //   195: ldc 56
    //   197: iconst_1
    //   198: aload 7
    //   200: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   203: athrow
    //   204: new 34	gnu/mapping/WrongType
    //   207: dup_x1
    //   208: swap
    //   209: ldc 36
    //   211: iconst_1
    //   212: aload 7
    //   214: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   217: athrow
    // Line number table:
    //   Java source line #188	-> byte code offset #0
    //   Java source line #189	-> byte code offset #10
    //   Java source line #202	-> byte code offset #10
    //   Java source line #204	-> byte code offset #18
    //   Java source line #205	-> byte code offset #29
    //   Java source line #206	-> byte code offset #86
    //   Java source line #207	-> byte code offset #99
    //   Java source line #209	-> byte code offset #115
    //   Java source line #210	-> byte code offset #121
    //   Java source line #211	-> byte code offset #134
    //   Java source line #205	-> byte code offset #176
    //   Java source line #211	-> byte code offset #190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	combine	gnu.mapping.Procedure
    //   0	175	1	nil	Object
    //   0	175	2	list1	gnu.lists.LList
    //   0	175	3	argsArray	Object[]
    //   0	20	4	lists	gnu.lists.LList
    //   6	1	5	localLList1	gnu.lists.LList
    //   27	3	5	lists	Object
    //   119	35	5	list	Object
    //   25	1	6	localObject1	Object
    //   29	89	6	ans	Object
    //   121	31	6	ans	Object
    //   45	168	7	localObject2	Object
    //   37	1	8	localObject3	Object
    //   48	137	8	i	int
    //   66	1	9	localObject4	Object
    //   86	22	9	cars	Object
    //   84	16	10	cdrs	Object
    //   176	1	17	localClassCastException1	ClassCastException
    //   190	1	18	localClassCastException2	ClassCastException
    //   204	1	19	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   39	42	176	java/lang/ClassCastException
    //   144	147	190	java/lang/ClassCastException
    //   163	166	204	java/lang/ClassCastException
  }
  
  /* Error */
  static Object $PcCdrs(Object lists)
  {
    // Byte code:
    //   0: new 198	kawa/lang/Continuation
    //   3: dup
    //   4: invokestatic 6	gnu/mapping/CallContext:getInstance	()Lgnu/mapping/CallContext;
    //   7: dup
    //   8: astore_2
    //   9: invokespecial 201	kawa/lang/Continuation:<init>	(Lgnu/mapping/CallContext;)V
    //   12: astore_1
    //   13: aload_1
    //   14: astore 4
    //   16: new 221	kawa/lib/rnrs/lists$frame5
    //   19: dup
    //   20: invokespecial 222	kawa/lib/rnrs/lists$frame5:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: aload 4
    //   29: putfield 223	kawa/lib/rnrs/lists$frame5:abort	Lkawa/lang/Continuation;
    //   32: aload 5
    //   34: aload_0
    //   35: invokevirtual 226	kawa/lib/rnrs/lists$frame5:lambda8recur	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: aload_1
    //   39: iconst_1
    //   40: putfield 215	kawa/lang/Continuation:invoked	Z
    //   43: astore_3
    //   44: goto +8 -> 52
    //   47: aload_1
    //   48: invokestatic 219	kawa/lang/Continuation:handleException	(Ljava/lang/Throwable;Lkawa/lang/Continuation;)Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_3
    //   53: areturn
    // Line number table:
    //   Java source line #44	-> byte code offset #0
    //   Java source line #45	-> byte code offset #0
    //   Java source line #47	-> byte code offset #0
    //   Java source line #48	-> byte code offset #14
    //   Java source line #49	-> byte code offset #32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	lists	Object
    //   12	36	1	localContinuation1	kawa.lang.Continuation
    //   0	9	2	$ctx	gnu.mapping.CallContext
    //   43	10	3	localObject	Object
    //   14	14	4	abort	kawa.lang.Continuation
    //   23	10	5	$heapFrame	frame5
    // Exception table:
    //   from	to	target	type
    //   13	47	47	finally
  }
  
  /* Error */
  public static Object memp(gnu.mapping.Procedure proc, gnu.lists.LList lst)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_2
    //   3: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   6: ifeq +9 -> 15
    //   9: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: goto +48 -> 60
    //   15: aload_0
    //   16: aload_2
    //   17: ldc 24
    //   19: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   22: dup
    //   23: astore_3
    //   24: checkcast 24	gnu/lists/Pair
    //   27: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   30: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   36: ifeq +7 -> 43
    //   39: aload_2
    //   40: goto +20 -> 60
    //   43: aload_2
    //   44: ldc 24
    //   46: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: astore_3
    //   51: checkcast 24	gnu/lists/Pair
    //   54: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   57: goto -56 -> 1
    //   60: areturn
    //   61: new 34	gnu/mapping/WrongType
    //   64: dup_x1
    //   65: swap
    //   66: ldc 36
    //   68: iconst_1
    //   69: aload_3
    //   70: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: new 34	gnu/mapping/WrongType
    //   77: dup_x1
    //   78: swap
    //   79: ldc 56
    //   81: iconst_1
    //   82: aload_3
    //   83: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   86: athrow
    // Line number table:
    //   Java source line #276	-> byte code offset #0
    //   Java source line #277	-> byte code offset #0
    //   Java source line #288	-> byte code offset #0
    //   Java source line #289	-> byte code offset #2
    //   Java source line #290	-> byte code offset #16
    //   Java source line #291	-> byte code offset #43
    //   Java source line #290	-> byte code offset #61
    //   Java source line #291	-> byte code offset #74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	proc	gnu.mapping.Procedure
    //   0	60	1	lst	gnu.lists.LList
    //   2	58	2	list	Object
    // Exception table:
    //   from	to	target	type
    //   24	27	61	java/lang/ClassCastException
    //   51	54	74	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object assp(gnu.mapping.Procedure proc, gnu.lists.LList alist)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_2
    //   3: invokestatic 16	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   6: ifeq +9 -> 15
    //   9: getstatic 22	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: goto +51 -> 63
    //   15: aload_0
    //   16: aload_2
    //   17: invokestatic 183	kawa/lib/lists:caar	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: invokevirtual 49	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: invokestatic 54	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   26: ifeq +20 -> 46
    //   29: aload_2
    //   30: ldc 24
    //   32: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   35: dup
    //   36: astore_3
    //   37: checkcast 24	gnu/lists/Pair
    //   40: invokestatic 43	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   43: goto +20 -> 63
    //   46: aload_2
    //   47: ldc 24
    //   49: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   52: dup
    //   53: astore_3
    //   54: checkcast 24	gnu/lists/Pair
    //   57: invokestatic 58	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   60: goto -59 -> 1
    //   63: areturn
    //   64: new 34	gnu/mapping/WrongType
    //   67: dup_x1
    //   68: swap
    //   69: ldc 36
    //   71: iconst_1
    //   72: aload_3
    //   73: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   76: athrow
    //   77: new 34	gnu/mapping/WrongType
    //   80: dup_x1
    //   81: swap
    //   82: ldc 56
    //   84: iconst_1
    //   85: aload_3
    //   86: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   89: athrow
    // Line number table:
    //   Java source line #299	-> byte code offset #0
    //   Java source line #300	-> byte code offset #0
    //   Java source line #311	-> byte code offset #0
    //   Java source line #312	-> byte code offset #2
    //   Java source line #313	-> byte code offset #16
    //   Java source line #314	-> byte code offset #46
    //   Java source line #313	-> byte code offset #64
    //   Java source line #314	-> byte code offset #77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	proc	gnu.mapping.Procedure
    //   0	63	1	alist	gnu.lists.LList
    //   2	61	2	alist	Object
    // Exception table:
    //   from	to	target	type
    //   37	40	64	java/lang/ClassCastException
    //   54	57	77	java/lang/ClassCastException
  }
  
  public lists()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 378	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+587->591, 5:+523->527, 6:+587->591, 7:+587->591, 8:+459->463, 9:+395->399, 10:+587->591, 11:+587->591, 12:+331->335, 13:+286->290, 14:+241->245, 15:+196->200, 16:+132->136, 17:+68->72
    //   72: aload 4
    //   74: aload_2
    //   75: ldc 45
    //   77: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   80: dup
    //   81: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   84: ifnull +6 -> 90
    //   87: goto +7 -> 94
    //   90: ldc_w 385
    //   93: ireturn
    //   94: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   97: aload 4
    //   99: aload_3
    //   100: ldc 60
    //   102: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   105: dup
    //   106: instanceof 60
    //   109: ifeq +6 -> 115
    //   112: goto +7 -> 119
    //   115: ldc_w 389
    //   118: ireturn
    //   119: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   122: aload 4
    //   124: aload_1
    //   125: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   128: aload 4
    //   130: iconst_2
    //   131: putfield 396	gnu/mapping/CallContext:pc	I
    //   134: iconst_0
    //   135: ireturn
    //   136: aload 4
    //   138: aload_2
    //   139: ldc 45
    //   141: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   144: dup
    //   145: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   148: ifnull +6 -> 154
    //   151: goto +7 -> 158
    //   154: ldc_w 385
    //   157: ireturn
    //   158: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   161: aload 4
    //   163: aload_3
    //   164: ldc 60
    //   166: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   169: dup
    //   170: instanceof 60
    //   173: ifeq +6 -> 179
    //   176: goto +7 -> 183
    //   179: ldc_w 389
    //   182: ireturn
    //   183: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   186: aload 4
    //   188: aload_1
    //   189: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   192: aload 4
    //   194: iconst_2
    //   195: putfield 396	gnu/mapping/CallContext:pc	I
    //   198: iconst_0
    //   199: ireturn
    //   200: aload 4
    //   202: aload_2
    //   203: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   206: aload 4
    //   208: aload_3
    //   209: ldc 60
    //   211: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   214: dup
    //   215: instanceof 60
    //   218: ifeq +6 -> 224
    //   221: goto +7 -> 228
    //   224: ldc_w 389
    //   227: ireturn
    //   228: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   231: aload 4
    //   233: aload_1
    //   234: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   237: aload 4
    //   239: iconst_2
    //   240: putfield 396	gnu/mapping/CallContext:pc	I
    //   243: iconst_0
    //   244: ireturn
    //   245: aload 4
    //   247: aload_2
    //   248: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   251: aload 4
    //   253: aload_3
    //   254: ldc 60
    //   256: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   259: dup
    //   260: instanceof 60
    //   263: ifeq +6 -> 269
    //   266: goto +7 -> 273
    //   269: ldc_w 389
    //   272: ireturn
    //   273: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   276: aload 4
    //   278: aload_1
    //   279: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   282: aload 4
    //   284: iconst_2
    //   285: putfield 396	gnu/mapping/CallContext:pc	I
    //   288: iconst_0
    //   289: ireturn
    //   290: aload 4
    //   292: aload_2
    //   293: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   296: aload 4
    //   298: aload_3
    //   299: ldc 60
    //   301: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   304: dup
    //   305: instanceof 60
    //   308: ifeq +6 -> 314
    //   311: goto +7 -> 318
    //   314: ldc_w 389
    //   317: ireturn
    //   318: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   321: aload 4
    //   323: aload_1
    //   324: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   327: aload 4
    //   329: iconst_2
    //   330: putfield 396	gnu/mapping/CallContext:pc	I
    //   333: iconst_0
    //   334: ireturn
    //   335: aload 4
    //   337: aload_2
    //   338: ldc 45
    //   340: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   343: dup
    //   344: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   347: ifnull +6 -> 353
    //   350: goto +7 -> 357
    //   353: ldc_w 385
    //   356: ireturn
    //   357: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   360: aload 4
    //   362: aload_3
    //   363: ldc 60
    //   365: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   368: dup
    //   369: instanceof 60
    //   372: ifeq +6 -> 378
    //   375: goto +7 -> 382
    //   378: ldc_w 389
    //   381: ireturn
    //   382: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   385: aload 4
    //   387: aload_1
    //   388: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   391: aload 4
    //   393: iconst_2
    //   394: putfield 396	gnu/mapping/CallContext:pc	I
    //   397: iconst_0
    //   398: ireturn
    //   399: aload 4
    //   401: aload_2
    //   402: ldc 45
    //   404: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   407: dup
    //   408: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   411: ifnull +6 -> 417
    //   414: goto +7 -> 421
    //   417: ldc_w 385
    //   420: ireturn
    //   421: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   424: aload 4
    //   426: aload_3
    //   427: ldc 60
    //   429: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   432: dup
    //   433: instanceof 60
    //   436: ifeq +6 -> 442
    //   439: goto +7 -> 446
    //   442: ldc_w 389
    //   445: ireturn
    //   446: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   449: aload 4
    //   451: aload_1
    //   452: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   455: aload 4
    //   457: iconst_2
    //   458: putfield 396	gnu/mapping/CallContext:pc	I
    //   461: iconst_0
    //   462: ireturn
    //   463: aload 4
    //   465: aload_2
    //   466: ldc 45
    //   468: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   471: dup
    //   472: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   475: ifnull +6 -> 481
    //   478: goto +7 -> 485
    //   481: ldc_w 385
    //   484: ireturn
    //   485: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   488: aload 4
    //   490: aload_3
    //   491: ldc 60
    //   493: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   496: dup
    //   497: instanceof 60
    //   500: ifeq +6 -> 506
    //   503: goto +7 -> 510
    //   506: ldc_w 389
    //   509: ireturn
    //   510: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   513: aload 4
    //   515: aload_1
    //   516: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   519: aload 4
    //   521: iconst_2
    //   522: putfield 396	gnu/mapping/CallContext:pc	I
    //   525: iconst_0
    //   526: ireturn
    //   527: aload 4
    //   529: aload_2
    //   530: ldc 45
    //   532: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   535: dup
    //   536: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   539: ifnull +6 -> 545
    //   542: goto +7 -> 549
    //   545: ldc_w 385
    //   548: ireturn
    //   549: putfield 388	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   552: aload 4
    //   554: aload_3
    //   555: ldc 60
    //   557: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   560: dup
    //   561: instanceof 60
    //   564: ifeq +6 -> 570
    //   567: goto +7 -> 574
    //   570: ldc_w 389
    //   573: ireturn
    //   574: putfield 392	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   577: aload 4
    //   579: aload_1
    //   580: putfield 393	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   583: aload 4
    //   585: iconst_2
    //   586: putfield 396	gnu/mapping/CallContext:pc	I
    //   589: iconst_0
    //   590: ireturn
    //   591: aload_0
    //   592: aload_1
    //   593: aload_2
    //   594: aload_3
    //   595: aload 4
    //   597: invokespecial 400	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   600: ireturn
    // Line number table:
    //   Java source line #299	-> byte code offset #72
    //   Java source line #276	-> byte code offset #136
    //   Java source line #268	-> byte code offset #200
    //   Java source line #261	-> byte code offset #245
    //   Java source line #254	-> byte code offset #290
    //   Java source line #242	-> byte code offset #335
    //   Java source line #166	-> byte code offset #399
    //   Java source line #146	-> byte code offset #463
    //   Java source line #65	-> byte code offset #527
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
    //   1: getfield 378	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+242->246, 5:+68->72, 6:+242->246, 7:+242->246, 8:+90->94, 9:+112->116, 10:+242->246, 11:+242->246, 12:+134->138, 13:+156->160, 14:+170->174, 15:+184->188, 16:+198->202, 17:+220->224
    //   72: aload_2
    //   73: ldc 45
    //   75: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   81: aload_3
    //   82: ldc 60
    //   84: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   87: checkcast 60	gnu/lists/LList
    //   90: invokestatic 417	kawa/lib/rnrs/lists:find	(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
    //   93: areturn
    //   94: aload_2
    //   95: ldc 45
    //   97: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   100: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   103: aload_3
    //   104: ldc 60
    //   106: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   109: checkcast 60	gnu/lists/LList
    //   112: invokestatic 156	kawa/lib/rnrs/lists:filter	(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
    //   115: areturn
    //   116: aload_2
    //   117: ldc 45
    //   119: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   122: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   125: aload_3
    //   126: ldc 60
    //   128: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   131: checkcast 60	gnu/lists/LList
    //   134: invokestatic 421	kawa/lib/rnrs/lists:partition	(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
    //   137: areturn
    //   138: aload_2
    //   139: ldc 45
    //   141: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   144: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   147: aload_3
    //   148: ldc 60
    //   150: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   153: checkcast 60	gnu/lists/LList
    //   156: invokestatic 425	kawa/lib/rnrs/lists:remp	(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   159: areturn
    //   160: aload_2
    //   161: aload_3
    //   162: ldc 60
    //   164: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   167: checkcast 60	gnu/lists/LList
    //   170: invokestatic 429	kawa/lib/rnrs/lists:remove	(Ljava/lang/Object;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   173: areturn
    //   174: aload_2
    //   175: aload_3
    //   176: ldc 60
    //   178: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   181: checkcast 60	gnu/lists/LList
    //   184: invokestatic 432	kawa/lib/rnrs/lists:remv	(Ljava/lang/Object;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   187: areturn
    //   188: aload_2
    //   189: aload_3
    //   190: ldc 60
    //   192: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   195: checkcast 60	gnu/lists/LList
    //   198: invokestatic 435	kawa/lib/rnrs/lists:remq	(Ljava/lang/Object;Lgnu/lists/LList;)Lgnu/lists/LList;
    //   201: areturn
    //   202: aload_2
    //   203: ldc 45
    //   205: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   211: aload_3
    //   212: ldc 60
    //   214: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   217: checkcast 60	gnu/lists/LList
    //   220: invokestatic 438	kawa/lib/rnrs/lists:memp	(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
    //   223: areturn
    //   224: aload_2
    //   225: ldc 45
    //   227: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   230: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   233: aload_3
    //   234: ldc 60
    //   236: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   239: checkcast 60	gnu/lists/LList
    //   242: invokestatic 441	kawa/lib/rnrs/lists:assp	(Lgnu/mapping/Procedure;Lgnu/lists/LList;)Ljava/lang/Object;
    //   245: areturn
    //   246: aload_0
    //   247: aload_1
    //   248: aload_2
    //   249: aload_3
    //   250: invokespecial 444	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: areturn
    //   254: new 34	gnu/mapping/WrongType
    //   257: dup_x1
    //   258: swap
    //   259: ldc_w 415
    //   262: iconst_1
    //   263: aload_2
    //   264: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   267: athrow
    //   268: new 34	gnu/mapping/WrongType
    //   271: dup_x1
    //   272: swap
    //   273: ldc_w 415
    //   276: iconst_2
    //   277: aload_3
    //   278: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   281: athrow
    //   282: new 34	gnu/mapping/WrongType
    //   285: dup_x1
    //   286: swap
    //   287: ldc_w 418
    //   290: iconst_1
    //   291: aload_2
    //   292: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   295: athrow
    //   296: new 34	gnu/mapping/WrongType
    //   299: dup_x1
    //   300: swap
    //   301: ldc_w 418
    //   304: iconst_2
    //   305: aload_3
    //   306: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   309: athrow
    //   310: new 34	gnu/mapping/WrongType
    //   313: dup_x1
    //   314: swap
    //   315: ldc_w 419
    //   318: iconst_1
    //   319: aload_2
    //   320: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   323: athrow
    //   324: new 34	gnu/mapping/WrongType
    //   327: dup_x1
    //   328: swap
    //   329: ldc_w 419
    //   332: iconst_2
    //   333: aload_3
    //   334: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   337: athrow
    //   338: new 34	gnu/mapping/WrongType
    //   341: dup_x1
    //   342: swap
    //   343: ldc_w 422
    //   346: iconst_1
    //   347: aload_2
    //   348: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   351: athrow
    //   352: new 34	gnu/mapping/WrongType
    //   355: dup_x1
    //   356: swap
    //   357: ldc_w 422
    //   360: iconst_2
    //   361: aload_3
    //   362: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   365: athrow
    //   366: new 34	gnu/mapping/WrongType
    //   369: dup_x1
    //   370: swap
    //   371: ldc_w 426
    //   374: iconst_2
    //   375: aload_3
    //   376: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   379: athrow
    //   380: new 34	gnu/mapping/WrongType
    //   383: dup_x1
    //   384: swap
    //   385: ldc_w 430
    //   388: iconst_2
    //   389: aload_3
    //   390: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   393: athrow
    //   394: new 34	gnu/mapping/WrongType
    //   397: dup_x1
    //   398: swap
    //   399: ldc_w 433
    //   402: iconst_2
    //   403: aload_3
    //   404: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   407: athrow
    //   408: new 34	gnu/mapping/WrongType
    //   411: dup_x1
    //   412: swap
    //   413: ldc_w 436
    //   416: iconst_1
    //   417: aload_2
    //   418: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   421: athrow
    //   422: new 34	gnu/mapping/WrongType
    //   425: dup_x1
    //   426: swap
    //   427: ldc_w 436
    //   430: iconst_2
    //   431: aload_3
    //   432: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   435: athrow
    //   436: new 34	gnu/mapping/WrongType
    //   439: dup_x1
    //   440: swap
    //   441: ldc_w 439
    //   444: iconst_1
    //   445: aload_2
    //   446: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   449: athrow
    //   450: new 34	gnu/mapping/WrongType
    //   453: dup_x1
    //   454: swap
    //   455: ldc_w 439
    //   458: iconst_2
    //   459: aload_3
    //   460: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   463: athrow
    // Line number table:
    //   Java source line #65	-> byte code offset #72
    //   Java source line #146	-> byte code offset #94
    //   Java source line #166	-> byte code offset #116
    //   Java source line #242	-> byte code offset #138
    //   Java source line #254	-> byte code offset #160
    //   Java source line #261	-> byte code offset #174
    //   Java source line #268	-> byte code offset #188
    //   Java source line #276	-> byte code offset #202
    //   Java source line #299	-> byte code offset #224
    //   Java source line #65	-> byte code offset #254
    //   Java source line #146	-> byte code offset #282
    //   Java source line #166	-> byte code offset #310
    //   Java source line #242	-> byte code offset #338
    //   Java source line #254	-> byte code offset #366
    //   Java source line #261	-> byte code offset #380
    //   Java source line #268	-> byte code offset #394
    //   Java source line #276	-> byte code offset #408
    //   Java source line #299	-> byte code offset #436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	lists
    //   0	464	1	paramModuleMethod	ModuleMethod
    //   0	464	2	paramObject1	Object
    //   0	464	3	paramObject2	Object
    //   254	1	4	localClassCastException1	ClassCastException
    //   268	1	5	localClassCastException2	ClassCastException
    //   282	1	6	localClassCastException3	ClassCastException
    //   296	1	7	localClassCastException4	ClassCastException
    //   310	1	8	localClassCastException5	ClassCastException
    //   324	1	9	localClassCastException6	ClassCastException
    //   338	1	10	localClassCastException7	ClassCastException
    //   352	1	11	localClassCastException8	ClassCastException
    //   366	1	12	localClassCastException9	ClassCastException
    //   380	1	13	localClassCastException10	ClassCastException
    //   394	1	14	localClassCastException11	ClassCastException
    //   408	1	15	localClassCastException12	ClassCastException
    //   422	1	16	localClassCastException13	ClassCastException
    //   436	1	17	localClassCastException14	ClassCastException
    //   450	1	18	localClassCastException15	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   78	81	254	java/lang/ClassCastException
    //   87	90	268	java/lang/ClassCastException
    //   100	103	282	java/lang/ClassCastException
    //   109	112	296	java/lang/ClassCastException
    //   122	125	310	java/lang/ClassCastException
    //   131	134	324	java/lang/ClassCastException
    //   144	147	338	java/lang/ClassCastException
    //   153	156	352	java/lang/ClassCastException
    //   167	170	366	java/lang/ClassCastException
    //   181	184	380	java/lang/ClassCastException
    //   195	198	394	java/lang/ClassCastException
    //   208	211	408	java/lang/ClassCastException
    //   217	220	422	java/lang/ClassCastException
    //   230	233	436	java/lang/ClassCastException
    //   239	242	450	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 378	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+291->295, 6:+52->56, 7:+109->113, 10:+166->170, 11:+226->230, 18:+286->290
    //   56: aload_2
    //   57: iconst_0
    //   58: aaload
    //   59: ldc 45
    //   61: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: astore_3
    //   66: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   69: aload_2
    //   70: iconst_1
    //   71: aaload
    //   72: ldc 60
    //   74: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   77: dup
    //   78: astore_3
    //   79: checkcast 60	gnu/lists/LList
    //   82: aload_2
    //   83: arraylength
    //   84: iconst_2
    //   85: isub
    //   86: istore_3
    //   87: iload_3
    //   88: anewarray 448	java/lang/Object
    //   91: goto +11 -> 102
    //   94: dup
    //   95: iload_3
    //   96: aload_2
    //   97: iload_3
    //   98: iconst_2
    //   99: iadd
    //   100: aaload
    //   101: aastore
    //   102: iinc 3 -1
    //   105: iload_3
    //   106: ifge -12 -> 94
    //   109: invokestatic 452	kawa/lib/rnrs/lists:forAll$V	(Lgnu/mapping/Procedure;Lgnu/lists/LList;[Ljava/lang/Object;)Ljava/lang/Object;
    //   112: areturn
    //   113: aload_2
    //   114: iconst_0
    //   115: aaload
    //   116: ldc 45
    //   118: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   121: dup
    //   122: astore_3
    //   123: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   126: aload_2
    //   127: iconst_1
    //   128: aaload
    //   129: ldc 60
    //   131: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   134: dup
    //   135: astore_3
    //   136: checkcast 60	gnu/lists/LList
    //   139: aload_2
    //   140: arraylength
    //   141: iconst_2
    //   142: isub
    //   143: istore_3
    //   144: iload_3
    //   145: anewarray 448	java/lang/Object
    //   148: goto +11 -> 159
    //   151: dup
    //   152: iload_3
    //   153: aload_2
    //   154: iload_3
    //   155: iconst_2
    //   156: iadd
    //   157: aaload
    //   158: aastore
    //   159: iinc 3 -1
    //   162: iload_3
    //   163: ifge -12 -> 151
    //   166: invokestatic 456	kawa/lib/rnrs/lists:exists$V	(Lgnu/mapping/Procedure;Lgnu/lists/LList;[Ljava/lang/Object;)Ljava/lang/Object;
    //   169: areturn
    //   170: aload_2
    //   171: iconst_0
    //   172: aaload
    //   173: ldc 45
    //   175: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   178: dup
    //   179: astore_3
    //   180: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   183: aload_2
    //   184: iconst_1
    //   185: aaload
    //   186: aload_2
    //   187: iconst_2
    //   188: aaload
    //   189: ldc 60
    //   191: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   194: dup
    //   195: astore_3
    //   196: checkcast 60	gnu/lists/LList
    //   199: aload_2
    //   200: arraylength
    //   201: iconst_3
    //   202: isub
    //   203: istore_3
    //   204: iload_3
    //   205: anewarray 448	java/lang/Object
    //   208: goto +11 -> 219
    //   211: dup
    //   212: iload_3
    //   213: aload_2
    //   214: iload_3
    //   215: iconst_3
    //   216: iadd
    //   217: aaload
    //   218: aastore
    //   219: iinc 3 -1
    //   222: iload_3
    //   223: ifge -12 -> 211
    //   226: invokestatic 462	kawa/lib/rnrs/lists:foldLeft$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/lists/LList;[Ljava/lang/Object;)Ljava/lang/Object;
    //   229: areturn
    //   230: aload_2
    //   231: iconst_0
    //   232: aaload
    //   233: ldc 45
    //   235: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   238: dup
    //   239: astore_3
    //   240: invokestatic 414	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   243: aload_2
    //   244: iconst_1
    //   245: aaload
    //   246: aload_2
    //   247: iconst_2
    //   248: aaload
    //   249: ldc 60
    //   251: invokestatic 30	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   254: dup
    //   255: astore_3
    //   256: checkcast 60	gnu/lists/LList
    //   259: aload_2
    //   260: arraylength
    //   261: iconst_3
    //   262: isub
    //   263: istore_3
    //   264: iload_3
    //   265: anewarray 448	java/lang/Object
    //   268: goto +11 -> 279
    //   271: dup
    //   272: iload_3
    //   273: aload_2
    //   274: iload_3
    //   275: iconst_3
    //   276: iadd
    //   277: aaload
    //   278: aastore
    //   279: iinc 3 -1
    //   282: iload_3
    //   283: ifge -12 -> 271
    //   286: invokestatic 467	kawa/lib/rnrs/lists:foldRight$V	(Lgnu/mapping/Procedure;Ljava/lang/Object;Lgnu/lists/LList;[Ljava/lang/Object;)Ljava/lang/Object;
    //   289: areturn
    //   290: aload_2
    //   291: invokestatic 469	kawa/lib/rnrs/lists:cons$St	([Ljava/lang/Object;)Ljava/lang/Object;
    //   294: areturn
    //   295: aload_0
    //   296: aload_1
    //   297: aload_2
    //   298: invokespecial 473	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   301: areturn
    //   302: new 34	gnu/mapping/WrongType
    //   305: dup_x1
    //   306: swap
    //   307: ldc_w 446
    //   310: iconst_1
    //   311: aload_3
    //   312: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   315: athrow
    //   316: new 34	gnu/mapping/WrongType
    //   319: dup_x1
    //   320: swap
    //   321: ldc_w 446
    //   324: iconst_2
    //   325: aload_3
    //   326: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   329: athrow
    //   330: new 34	gnu/mapping/WrongType
    //   333: dup_x1
    //   334: swap
    //   335: ldc_w 453
    //   338: iconst_1
    //   339: aload_3
    //   340: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   343: athrow
    //   344: new 34	gnu/mapping/WrongType
    //   347: dup_x1
    //   348: swap
    //   349: ldc_w 453
    //   352: iconst_2
    //   353: aload_3
    //   354: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   357: athrow
    //   358: new 34	gnu/mapping/WrongType
    //   361: dup_x1
    //   362: swap
    //   363: ldc_w 458
    //   366: iconst_1
    //   367: aload_3
    //   368: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   371: athrow
    //   372: new 34	gnu/mapping/WrongType
    //   375: dup_x1
    //   376: swap
    //   377: ldc_w 458
    //   380: iconst_3
    //   381: aload_3
    //   382: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   385: athrow
    //   386: new 34	gnu/mapping/WrongType
    //   389: dup_x1
    //   390: swap
    //   391: ldc_w 464
    //   394: iconst_1
    //   395: aload_3
    //   396: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   399: athrow
    //   400: new 34	gnu/mapping/WrongType
    //   403: dup_x1
    //   404: swap
    //   405: ldc_w 464
    //   408: iconst_3
    //   409: aload_3
    //   410: invokespecial 40	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   413: athrow
    // Line number table:
    //   Java source line #79	-> byte code offset #56
    //   Java source line #111	-> byte code offset #113
    //   Java source line #188	-> byte code offset #170
    //   Java source line #214	-> byte code offset #230
    //   Java source line #322	-> byte code offset #290
    //   Java source line #79	-> byte code offset #302
    //   Java source line #111	-> byte code offset #330
    //   Java source line #188	-> byte code offset #358
    //   Java source line #214	-> byte code offset #386
    // Exception table:
    //   from	to	target	type
    //   66	69	302	java/lang/ClassCastException
    //   79	82	316	java/lang/ClassCastException
    //   123	126	330	java/lang/ClassCastException
    //   136	139	344	java/lang/ClassCastException
    //   180	183	358	java/lang/ClassCastException
    //   196	199	372	java/lang/ClassCastException
    //   240	243	386	java/lang/ClassCastException
    //   256	259	400	java/lang/ClassCastException
  }
  
  public class frame4
    extends gnu.expr.ModuleBody
  {
    kawa.lang.Continuation abort;
    
    public frame4() {}
    
    /* Error */
    public Object lambda7recur(Object lists)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 6	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   4: ifeq +194 -> 198
      //   7: aload_1
      //   8: ldc 8
      //   10: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   13: dup
      //   14: astore_3
      //   15: checkcast 8	gnu/lists/Pair
      //   18: invokestatic 30	kawa/lib/rnrs/lists:car$PlCdr	(Lgnu/lists/Pair;)Lgnu/mapping/Values;
      //   21: astore_2
      //   22: iconst_0
      //   23: istore_3
      //   24: aload_2
      //   25: iload_3
      //   26: invokestatic 36	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
      //   29: istore_3
      //   30: aload_2
      //   31: iload_3
      //   32: invokestatic 40	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   35: astore 4
      //   37: aload_2
      //   38: iload_3
      //   39: invokestatic 36	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
      //   42: istore_3
      //   43: aload_2
      //   44: iload_3
      //   45: invokestatic 43	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   48: astore 5
      //   50: aload 4
      //   52: invokestatic 46	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   55: ifeq +19 -> 74
      //   58: aload_0
      //   59: getfield 52	kawa/lib/rnrs/lists$frame4:abort	Lkawa/lang/Continuation;
      //   62: getstatic 58	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   65: getstatic 58	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   68: invokevirtual 64	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   71: goto +136 -> 207
      //   74: aload 4
      //   76: ldc 8
      //   78: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   81: dup
      //   82: astore 7
      //   84: checkcast 8	gnu/lists/Pair
      //   87: invokestatic 30	kawa/lib/rnrs/lists:car$PlCdr	(Lgnu/lists/Pair;)Lgnu/mapping/Values;
      //   90: astore 6
      //   92: iconst_0
      //   93: istore 7
      //   95: aload 6
      //   97: iload 7
      //   99: invokestatic 36	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
      //   102: istore 7
      //   104: aload 6
      //   106: iload 7
      //   108: invokestatic 40	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   111: astore 8
      //   113: aload 6
      //   115: iload 7
      //   117: invokestatic 36	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
      //   120: istore 7
      //   122: aload 6
      //   124: iload 7
      //   126: invokestatic 43	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   129: astore 9
      //   131: aload_0
      //   132: aload 5
      //   134: invokevirtual 68	kawa/lib/rnrs/lists$frame4:lambda7recur	(Ljava/lang/Object;)Ljava/lang/Object;
      //   137: astore 10
      //   139: iconst_0
      //   140: istore 11
      //   142: aload 10
      //   144: iload 11
      //   146: invokestatic 36	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
      //   149: istore 11
      //   151: aload 10
      //   153: iload 11
      //   155: invokestatic 40	gnu/mapping/Values:getFromPos	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   158: astore 12
      //   160: aload 10
      //   162: iload 11
      //   164: invokestatic 36	gnu/mapping/Values:incrPos	(Ljava/lang/Object;I)I
      //   167: istore 11
      //   169: aload 10
      //   171: iload 11
      //   173: invokestatic 43	gnu/mapping/Values:getFromPosFinal	(Ljava/lang/Object;I)Ljava/lang/Object;
      //   176: astore 13
      //   178: aload 8
      //   180: aload 12
      //   182: invokestatic 72	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   185: aload 9
      //   187: aload 13
      //   189: invokestatic 72	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   192: invokestatic 76	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
      //   195: goto +12 -> 207
      //   198: getstatic 58	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   201: getstatic 58	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   204: invokestatic 76	gnu/mapping/Values:values2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Values$Values2;
      //   207: areturn
      //   208: new 18	gnu/mapping/WrongType
      //   211: dup_x1
      //   212: swap
      //   213: ldc 20
      //   215: iconst_0
      //   216: aload_3
      //   217: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   220: athrow
      //   221: new 18	gnu/mapping/WrongType
      //   224: dup_x1
      //   225: swap
      //   226: ldc 20
      //   228: iconst_0
      //   229: aload 7
      //   231: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   234: athrow
      // Line number table:
      //   Java source line #29	-> byte code offset #0
      //   Java source line #30	-> byte code offset #7
      //   Java source line #31	-> byte code offset #50
      //   Java source line #32	-> byte code offset #74
      //   Java source line #33	-> byte code offset #131
      //   Java source line #32	-> byte code offset #178
      //   Java source line #34	-> byte code offset #178
      //   Java source line #35	-> byte code offset #198
      //   Java source line #30	-> byte code offset #208
      //   Java source line #32	-> byte code offset #221
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	208	0	this	frame4
      //   0	207	1	lists	Object
      //   21	23	2	localValues1	gnu.mapping.Values
      //   14	1	3	localObject1	Object
      //   23	194	3	i	int
      //   35	1	4	localObject2	Object
      //   50	25	4	list	Object
      //   48	85	5	other$Mnlists	Object
      //   90	33	6	localValues2	gnu.mapping.Values
      //   82	1	7	localObject3	Object
      //   93	137	7	j	int
      //   111	1	8	localObject4	Object
      //   131	48	8	a	Object
      //   129	57	9	d	Object
      //   137	33	10	localObject5	Object
      //   140	32	11	k	int
      //   158	1	12	localObject6	Object
      //   178	3	12	cars	Object
      //   176	12	13	cdrs	Object
      //   208	1	19	localClassCastException1	ClassCastException
      //   221	1	20	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   15	18	208	java/lang/ClassCastException
      //   84	87	221	java/lang/ClassCastException
    }
  }
  
  public class frame5
    extends gnu.expr.ModuleBody
  {
    kawa.lang.Continuation abort;
    
    public frame5() {}
    
    /* Error */
    public Object lambda8recur(Object lists)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 6	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   4: ifeq +76 -> 80
      //   7: aload_1
      //   8: ldc 8
      //   10: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   13: dup
      //   14: astore_3
      //   15: checkcast 8	gnu/lists/Pair
      //   18: invokestatic 27	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   21: astore_2
      //   22: aload_2
      //   23: invokestatic 30	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   26: ifeq +16 -> 42
      //   29: aload_0
      //   30: getfield 36	kawa/lib/rnrs/lists$frame5:abort	Lkawa/lang/Continuation;
      //   33: getstatic 42	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   36: invokevirtual 48	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
      //   39: goto +44 -> 83
      //   42: aload_2
      //   43: ldc 8
      //   45: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   48: dup
      //   49: astore_3
      //   50: checkcast 8	gnu/lists/Pair
      //   53: invokestatic 52	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   56: aload_0
      //   57: aload_1
      //   58: ldc 8
      //   60: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   63: dup
      //   64: astore_3
      //   65: checkcast 8	gnu/lists/Pair
      //   68: invokestatic 52	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   71: invokevirtual 55	kawa/lib/rnrs/lists$frame5:lambda8recur	(Ljava/lang/Object;)Ljava/lang/Object;
      //   74: invokestatic 59	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   77: goto +6 -> 83
      //   80: getstatic 42	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   83: areturn
      //   84: new 18	gnu/mapping/WrongType
      //   87: dup_x1
      //   88: swap
      //   89: ldc 20
      //   91: iconst_1
      //   92: aload_3
      //   93: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   96: athrow
      //   97: new 18	gnu/mapping/WrongType
      //   100: dup_x1
      //   101: swap
      //   102: ldc 50
      //   104: iconst_1
      //   105: aload_3
      //   106: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   109: athrow
      //   110: new 18	gnu/mapping/WrongType
      //   113: dup_x1
      //   114: swap
      //   115: ldc 50
      //   117: iconst_1
      //   118: aload_3
      //   119: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   122: athrow
      // Line number table:
      //   Java source line #50	-> byte code offset #0
      //   Java source line #51	-> byte code offset #7
      //   Java source line #52	-> byte code offset #22
      //   Java source line #53	-> byte code offset #42
      //   Java source line #51	-> byte code offset #84
      //   Java source line #53	-> byte code offset #97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	84	0	this	frame5
      //   0	83	1	lists	Object
      //   21	22	2	lis	Object
      //   14	105	3	localObject1	Object
      //   84	1	4	localClassCastException1	ClassCastException
      //   97	1	5	localClassCastException2	ClassCastException
      //   110	1	6	localClassCastException3	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   15	18	84	java/lang/ClassCastException
      //   50	53	97	java/lang/ClassCastException
      //   65	68	110	java/lang/ClassCastException
    }
  }
}
