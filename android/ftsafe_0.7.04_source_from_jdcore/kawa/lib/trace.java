package kawa.lib; import gnu.mapping.CallContext;

public class trace extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  

  public static final kawa.lang.Macro $Pcdo$Mntrace;
  public static final kawa.lang.Macro trace;
  public static final kawa.lang.Macro untrace;
  public static final gnu.expr.ModuleMethod disassemble;
  public static trace $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final kawa.lang.SyntaxRules Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final kawa.lang.SyntaxRules Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final kawa.lang.SyntaxRules Lit5;
  static final gnu.mapping.SimpleSymbol Lit6;
  static final Object[] Lit7;
  static final gnu.mapping.SimpleSymbol Lit8 = gnu.mapping.Symbol.valueOf("begin");
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    if (selector != 1) {} try { return disassemble(gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(paramObject, gnu.mapping.Procedure.class))); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(localClassCastException, "disassemble", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static Object disassemble(gnu.mapping.Procedure proc) { ; int i = $ctx.startFromContext(); try { gnu.expr.PrimProcedure.disassemble$X(proc, $ctx = CallContext.getInstance()); } finally { $ctx.cleanupFromContext(i);throw finally; } return $ctx.getFromContext(i);
  }
  
  static
  {
    Lit7 = new Object[0];
    Lit6 = gnu.mapping.Symbol.valueOf("disassemble");
    kawa.lang.SyntaxRule[] tmp34_31 = new kawa.lang.SyntaxRule[1];
    Object[] tmp63_60 = new Object[3];
    Object[] tmp64_63 = tmp63_60;
    tmp64_63[0] = Lit8;
    Object[] tmp70_64 = tmp64_63;
    gnu.mapping.SimpleSymbol tmp77_74 = gnu.mapping.Symbol.valueOf("%do-trace");
    Lit0 = tmp77_74;
    tmp70_64[1] = tmp77_74;
    tmp70_64[2] = gnu.lists.PairWithPosition.make(Boolean.FALSE, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 77851);
    tmp34_31[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\r\007\000\b\b", Lit7, 1, "trace.scm:18"), "\003", "\021\030\004\b\005\021\030\f\t\003\030\024", tmp63_60, 1);
    Lit5 = new kawa.lang.SyntaxRules(Lit7, tmp34_31, 1, trace.Lit4 = gnu.mapping.Symbol.valueOf("untrace"));
    kawa.lang.SyntaxRule[] tmp129_126 = new kawa.lang.SyntaxRule[1];
    Object[] tmp158_155 = new Object[3];
    Object[] tmp159_158 = tmp158_155;
    tmp159_158[0] = Lit8;
    Object[] tmp165_159 = tmp159_158;
    tmp165_159[1] = Lit0;
    tmp165_159[2] = gnu.lists.PairWithPosition.make(Boolean.TRUE, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 57371);
    tmp129_126[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\r\007\000\b\b", Lit7, 1, "trace.scm:13"), "\003", "\021\030\004\b\005\021\030\f\t\003\030\024", tmp158_155, 1);
    Lit3 = new kawa.lang.SyntaxRules(Lit7, tmp129_126, 1, trace.Lit2 = gnu.mapping.Symbol.valueOf("trace"));
    kawa.lang.SyntaxRule[] tmp218_215 = new kawa.lang.SyntaxRule[1];
    Object[] tmp247_244 = new Object[4];
    Object[] tmp248_247 = tmp247_244;
    tmp248_247[0] = gnu.mapping.Symbol.valueOf("set!");
    Object[] tmp256_248 = tmp248_247;
    tmp256_248[1] = gnu.mapping.Symbol.valueOf("invoke-static");
    Object[] tmp264_256 = tmp256_248;
    tmp264_256[2] = gnu.mapping.Symbol.valueOf("<kawa.standard.TracedProcedure>");
    tmp264_256[3] = gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("quote"), gnu.lists.PairWithPosition.make(gnu.mapping.Symbol.valueOf("doTrace"), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 32806), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/trace.scm", 32806);
    tmp218_215[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\b", Lit7, 2, "trace.scm:5"), "\001\001", "\021\030\004\t\003\b\021\030\f\021\030\024\021\030\034\t\003\b\013", tmp247_244, 0);
    Lit1 = new kawa.lang.SyntaxRules(Lit7, tmp218_215, 2, Lit0);
    $instance = new trace();
    $Pcdo$Mntrace = kawa.lang.Macro.make(Lit0, Lit1, "kawa.lib.trace");
    trace = kawa.lang.Macro.make(Lit2, Lit3, "kawa.lib.trace");
    untrace = kawa.lang.Macro.make(Lit4, Lit5, "kawa.lib.trace");
    trace localTrace = $instance;
    disassemble = new gnu.expr.ModuleMethod(localTrace, 1, Lit6, 4097);
    $runBody$();
  }
  
  public trace()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 104	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_1
    //   5: if_icmpne +41 -> 46
    //   8: goto +3 -> 11
    //   11: aload_3
    //   12: aload_2
    //   13: ldc 106
    //   15: invokestatic 112	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: invokestatic 118	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   22: ifnull +6 -> 28
    //   25: goto +6 -> 31
    //   28: ldc 119
    //   30: ireturn
    //   31: putfield 123	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   34: aload_3
    //   35: aload_1
    //   36: putfield 127	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   39: aload_3
    //   40: iconst_1
    //   41: putfield 130	gnu/mapping/CallContext:pc	I
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: aload_1
    //   48: aload_2
    //   49: aload_3
    //   50: invokespecial 134	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   53: ireturn
    // Line number table:
    //   Java source line #21	-> byte code offset #11
  }
  
  public void apply(CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
}
