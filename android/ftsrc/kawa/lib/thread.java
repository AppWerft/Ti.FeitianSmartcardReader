package kawa.lib; import gnu.expr.ModuleMethod;

public class thread extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$lambda; public static final kawa.lang.Macro future; public static final ModuleMethod sleep; public static final ModuleMethod runnable; public static final ModuleMethod $Prvt$$Pcmake$Mnfuture; public static thread $instance; static final gnu.mapping.SimpleSymbol Lit0; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  static final gnu.mapping.SimpleSymbol Lit1; static final kawa.lang.SyntaxRules Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final Object[] Lit5 = new Object[0]; static { Lit4 = gnu.mapping.Symbol.valueOf("runnable");Lit3 = gnu.mapping.Symbol.valueOf("%make-future"); kawa.lang.SyntaxRule[] tmp34_31 = new kawa.lang.SyntaxRule[1]; Object[] tmp63_60 = new Object[2]; Object[] tmp64_63 = tmp63_60;tmp64_63[0] = Lit3;tmp64_63[1] = gnu.mapping.Symbol.valueOf("lambda");tmp34_31[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit5, 1, "thread.scm:13"), "\001", "\021\030\004\b\021\030\f\t\020\b\003", tmp63_60, 0);Lit2 = new kawa.lang.SyntaxRules(Lit5, tmp34_31, 1, thread.Lit1 = gnu.mapping.Symbol.valueOf("future"));Lit0 = gnu.mapping.Symbol.valueOf("sleep");$instance = new thread();$Prvt$lambda = gnu.kawa.reflect.StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");thread localThread = $instance;sleep = new ModuleMethod(localThread, 1, Lit0, 4097);
    
    future = kawa.lang.Macro.make(Lit1, Lit2, "kawa.lib.thread");$Prvt$$Pcmake$Mnfuture = new ModuleMethod(localThread, 2, Lit3, 4097);runnable = new ModuleMethod(localThread, 3, Lit4, 4097);$runBody$();
  }
  
  public static void sleep(gnu.math.Quantity time) { kawa.standard.sleep.sleep(time); }
  





  public static gnu.mapping.Future $PcMakeFuture(gnu.mapping.Procedure p)
  {
    gnu.mapping.Future f = new gnu.mapping.Future(p);
    f.start();
    return f;
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { sleep((gnu.math.Quantity)gnu.mapping.Promise.force(paramObject, gnu.math.Quantity.class));return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      












        localClassCastException1, "sleep", 1, paramObject);
    }
    try
    {
      return $PcMakeFuture(gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(paramObject, gnu.mapping.Procedure.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "%make-future", 1, paramObject);
    }
    
    try
    {
      return runnable(gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(paramObject, gnu.mapping.Procedure.class))); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "runnable", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static gnu.mapping.RunnableClosure runnable(gnu.mapping.Procedure p) { return new gnu.mapping.RunnableClosure(p); }
  
  public thread()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 109	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+130->134, 1:+98->102, 2:+63->67, 3:+28->32
    //   32: aload_3
    //   33: aload_2
    //   34: ldc 111
    //   36: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: dup
    //   40: invokestatic 123	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   43: ifnull +6 -> 49
    //   46: goto +6 -> 52
    //   49: ldc 124
    //   51: ireturn
    //   52: putfield 128	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   55: aload_3
    //   56: aload_1
    //   57: putfield 132	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   60: aload_3
    //   61: iconst_1
    //   62: putfield 135	gnu/mapping/CallContext:pc	I
    //   65: iconst_0
    //   66: ireturn
    //   67: aload_3
    //   68: aload_2
    //   69: ldc 111
    //   71: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   74: dup
    //   75: invokestatic 123	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   78: ifnull +6 -> 84
    //   81: goto +6 -> 87
    //   84: ldc 124
    //   86: ireturn
    //   87: putfield 128	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   90: aload_3
    //   91: aload_1
    //   92: putfield 132	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   95: aload_3
    //   96: iconst_1
    //   97: putfield 135	gnu/mapping/CallContext:pc	I
    //   100: iconst_0
    //   101: ireturn
    //   102: aload_3
    //   103: aload_2
    //   104: ldc -119
    //   106: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   109: dup
    //   110: instanceof 137
    //   113: ifne +6 -> 119
    //   116: ldc 124
    //   118: ireturn
    //   119: putfield 128	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   122: aload_3
    //   123: aload_1
    //   124: putfield 132	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   127: aload_3
    //   128: iconst_1
    //   129: putfield 135	gnu/mapping/CallContext:pc	I
    //   132: iconst_0
    //   133: ireturn
    //   134: aload_0
    //   135: aload_1
    //   136: aload_2
    //   137: aload_3
    //   138: invokespecial 141	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   141: ireturn
    // Line number table:
    //   Java source line #21	-> byte code offset #32
    //   Java source line #16	-> byte code offset #67
    //   Java source line #7	-> byte code offset #102
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
