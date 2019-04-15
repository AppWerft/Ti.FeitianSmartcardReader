package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;

public class ppfile extends ModuleBody
{
  public static final ModuleMethod pprint$Mnfilter$Mnfile;
  public static final ModuleMethod pprint$Mnfile;
  static final gnu.text.Char Lit0;
  static final ModuleMethod lambda$Fn3;
  public static ppfile $instance;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2 = gnu.mapping.Symbol.valueOf("pprint-file");
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext) { if (selector == 3) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); } public static Object pprintFilterFile$V(Object inport, Object filter, Object[] argsArray) { ; frame $heapFrame = new frame();filter = filter; gnu.lists.LList localLList1; optarg = (localLList1 = gnu.lists.LList.makeList(argsArray, 0));
    



    Object fun = fun$Fn1;
    try
    {
      return kawa.lib.ports.isInputPort(inport) ? $heapFrame.lambda1fun(inport) : kawa.lib.ports.callWithInputFile(gnu.kawa.io.Path.valueOf(localObject1 = gnu.mapping.Promise.force(inport, gnu.kawa.io.Path.class)), fun$Fn1); } catch (ClassCastException localClassCastException) { Object localObject1; throw new gnu.mapping.WrongType(localClassCastException, "call-with-input-file", 1, localObject1); } }
  public class frame extends ModuleBody { public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 2) return lambda1fun(paramObject); return super.apply1(paramModuleMethod, paramObject); } public void apply(CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext) { if (selector == 2) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    
    gnu.lists.LList optarg;
    Object filter;
    final ModuleMethod fun$Fn1;
    /* Error */
    public Object lambda1fun(Object port)
    {
      // Byte code:
      //   0: new 2	gnu/kawa/slib/ppfile$frame0
      //   3: dup
      //   4: invokespecial 6	gnu/kawa/slib/ppfile$frame0:<init>	()V
      //   7: dup
      //   8: aload_0
      //   9: putfield 10	gnu/kawa/slib/ppfile$frame0:staticLink	Lgnu/kawa/slib/ppfile$frame;
      //   12: astore_2
      //   13: aload_2
      //   14: aload_1
      //   15: putfield 14	gnu/kawa/slib/ppfile$frame0:port	Ljava/lang/Object;
      //   18: aload_2
      //   19: getfield 18	gnu/kawa/slib/ppfile$frame0:fun$Fn2	Lgnu/expr/ModuleMethod;
      //   22: astore_3
      //   23: aload_0
      //   24: getfield 24	gnu/kawa/slib/ppfile$frame:optarg	Lgnu/lists/LList;
      //   27: invokestatic 30	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   30: ifeq +15 -> 45
      //   33: getstatic 36	kawa/lib/ports:current$Mnoutput$Mnport	Lgnu/mapping/LocationProc;
      //   36: invokevirtual 42	gnu/mapping/LocationProc:getValue	()Ljava/lang/Object;
      //   39: checkcast 44	gnu/kawa/io/OutPort
      //   42: goto +16 -> 58
      //   45: aload_0
      //   46: getfield 24	gnu/kawa/slib/ppfile$frame:optarg	Lgnu/lists/LList;
      //   49: dup
      //   50: astore 5
      //   52: checkcast 46	gnu/lists/Pair
      //   55: invokestatic 58	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   58: astore 4
      //   60: aload 4
      //   62: invokestatic 61	kawa/lib/ports:isOutputPort	(Ljava/lang/Object;)Z
      //   65: ifeq +12 -> 77
      //   68: aload_2
      //   69: aload 4
      //   71: invokevirtual 65	gnu/kawa/slib/ppfile$frame0:lambda2fun	(Ljava/lang/Object;)Ljava/lang/Object;
      //   74: goto +23 -> 97
      //   77: aload 4
      //   79: ldc 67
      //   81: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   84: dup
      //   85: astore 5
      //   87: invokestatic 77	gnu/kawa/io/Path:valueOf	(Ljava/lang/Object;)Lgnu/kawa/io/Path;
      //   90: aload_2
      //   91: getfield 18	gnu/kawa/slib/ppfile$frame0:fun$Fn2	Lgnu/expr/ModuleMethod;
      //   94: invokestatic 83	kawa/lib/ports:callWithOutputFile	(Lgnu/kawa/io/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   97: areturn
      //   98: new 50	gnu/mapping/WrongType
      //   101: dup_x1
      //   102: swap
      //   103: ldc 52
      //   105: iconst_1
      //   106: aload 5
      //   108: invokespecial 55	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   111: athrow
      //   112: new 50	gnu/mapping/WrongType
      //   115: dup_x1
      //   116: swap
      //   117: ldc 79
      //   119: iconst_1
      //   120: aload 5
      //   122: invokespecial 55	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   125: athrow
      // Line number table:
      //   Java source line #27	-> byte code offset #0
      //   Java source line #34	-> byte code offset #18
      //   Java source line #29	-> byte code offset #23
      //   Java source line #30	-> byte code offset #23
      //   Java source line #31	-> byte code offset #60
      //   Java source line #32	-> byte code offset #68
      //   Java source line #33	-> byte code offset #77
      //   Java source line #30	-> byte code offset #98
      //   Java source line #33	-> byte code offset #112
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	98	0	this	frame
      //   0	97	1	port	Object
      //   12	79	2	$heapFrame	ppfile.frame0
      //   22	2	3	fun	gnu.mapping.Procedure
      //   58	20	4	outport	Object
      //   50	71	5	localObject1	Object
      //   98	1	6	localClassCastException1	ClassCastException
      //   112	1	7	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   52	55	98	java/lang/ClassCastException
      //   87	90	112	java/lang/ClassCastException
    }
    
    public frame()
    {
      void tmp19_16 = new ModuleMethod(this, 2, "fun", 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/ppfile.scm:27");
      fun$Fn1 = tmp19_16;
    }
  }
  
  public static Object pprintFile(Object paramObject)
  {
    return pprintFile(paramObject, (gnu.kawa.io.OutPort)kawa.lib.ports.current$Mnoutput$Mnport.getValue()); } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, CallContext paramCallContext) { if (selector == 5) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { switch (selector) {case 4:  return lambda3(paramObject);
    case 5: 
      return pprintFile(paramObject); } return super.apply1(paramModuleMethod, paramObject); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 5) return pprintFile(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  
  public static Object pprintFile(Object ifile, Object oport) { return pprintFilterFile$V(ifile, lambda$Fn3, new Object[] { oport }); } static Object lambda3(Object x) { return x;
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (selector) {case 5:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 4: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }
  
  static
  {
    Lit1 = gnu.mapping.Symbol.valueOf("pprint-filter-file");
    Lit0 = gnu.text.Char.valueOf(10);
    $instance = new ppfile();
    ppfile localPpfile = $instance;
    pprint$Mnfilter$Mnfile = new ModuleMethod(localPpfile, 3, Lit1, 61442);
    void tmp69_66 = new ModuleMethod(localPpfile, 4, null, 4097);
    tmp69_66.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/ppfile.scm:70");
    lambda$Fn3 = tmp69_66;
    pprint$Mnfile = new ModuleMethod(localPpfile, 5, Lit2, 8193);
    $runBody$();
  }
  
  public ppfile()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object applyN(ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 145	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_3
    //   5: if_icmpne +43 -> 48
    //   8: goto +3 -> 11
    //   11: aload_2
    //   12: iconst_0
    //   13: aaload
    //   14: aload_2
    //   15: iconst_1
    //   16: aaload
    //   17: aload_2
    //   18: arraylength
    //   19: iconst_2
    //   20: isub
    //   21: istore_3
    //   22: iload_3
    //   23: anewarray 92	java/lang/Object
    //   26: goto +11 -> 37
    //   29: dup
    //   30: iload_3
    //   31: aload_2
    //   32: iload_3
    //   33: iconst_2
    //   34: iadd
    //   35: aaload
    //   36: aastore
    //   37: iinc 3 -1
    //   40: iload_3
    //   41: ifge -12 -> 29
    //   44: invokestatic 96	gnu/kawa/slib/ppfile:pprintFilterFile$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   47: areturn
    //   48: aload_0
    //   49: aload_1
    //   50: aload_2
    //   51: invokespecial 194	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: areturn
    // Line number table:
    //   Java source line #22	-> byte code offset #11
  }
}
