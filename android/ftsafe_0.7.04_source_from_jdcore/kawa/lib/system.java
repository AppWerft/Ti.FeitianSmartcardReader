package kawa.lib; import gnu.expr.ModuleMethod;

public class system extends gnu.expr.ModuleBody { public static final gnu.kawa.reflect.StaticFieldLocation $Prvt$$string$Mnwith$Mndelimiter$Mnmarks$; public static final ModuleMethod make$Mnprocess; public static final ModuleMethod open$Mninput$Mnpipe; public static final ModuleMethod system; public static final ModuleMethod convert$Mnvector$Mnto$Mnstring$Mnarray; public static final ModuleMethod convert$Mnlist$Mnto$Mnstring$Mnarray; public static final ModuleMethod tokenize$Mnstring$Mnto$Mnstring$Mnarray; public static final ModuleMethod tokenize$Mnstring$Mnusing$Mnshell; public static gnu.mapping.Procedure command$Mnparse; public static final ModuleMethod compile$Mnfile; public static final ModuleMethod process$Mncommand$Mnline$Mnassignments; public static final ModuleMethod get$Mnenvironment$Mnvariable; public static final ModuleMethod get$Mnenvironment$Mnvariables; public static final ModuleMethod current$Mnsecond; public static final ModuleMethod current$Mnjiffy; public static final ModuleMethod jiffies$Mnper$Mnsecond; @gnu.expr.SourceName(name="cmd", uri="http://kawa.gnu.org/construct", prefix="$construct$")
  public static final kawa.lang.Macro cmd; @gnu.expr.SourceName(name="sh", uri="http://kawa.gnu.org/construct", prefix="$construct$")
  public static final kawa.lang.Macro sh; public static final kawa.lang.Macro run$Mnprocess$Mnusing$Mnsh; public static final kawa.lang.Macro pipe$Mnprocess; public static final gnu.expr.GenericProc $Pcpipe$Mnprocess; public static final ModuleMethod process$Mnexit$Mnwait; public static final ModuleMethod process$Mnexit$Mnok$Qu; static final gnu.math.IntNum Lit0; static final gnu.expr.Keyword Lit1; public static system $instance; static final gnu.mapping.SimpleSymbol Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14; static final gnu.mapping.SimpleSymbol Lit15; static final gnu.mapping.Symbol Lit16; static final kawa.lang.SyntaxRules Lit17; static final gnu.mapping.Symbol Lit18; static final kawa.lang.SyntaxRules Lit19; static final gnu.mapping.SimpleSymbol Lit20; static final kawa.lang.SyntaxRules Lit21; static final gnu.mapping.SimpleSymbol Lit22; static final kawa.lang.SyntaxRules Lit23; static final gnu.mapping.SimpleSymbol Lit24; static final gnu.mapping.SimpleSymbol Lit25; static final Object[] Lit26; static final gnu.mapping.SimpleSymbol Lit27; static final gnu.mapping.SimpleSymbol Lit28; static final gnu.mapping.SimpleSymbol Lit29; static final gnu.mapping.Namespace Lit30 = gnu.mapping.Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
  


















  public static java.io.InputStream openInputPipe(Object command)
  {
    return makeProcess(command, null).getInputStream();
  }
  

  public static int system(Object command)
  {
    return makeProcess(command, null).waitFor();
  }
  








































  public static String[] tokenizeStringUsingShell(Object string)
  {
    String[] arr = new String[3];
    arr[0] = "/bin/sh";
    arr[1] = "-c"; Object 
      tmp23_20 = gnu.mapping.Promise.force(string, String.class);tmp23_20;arr[2] = (tmp23_20 == null ? null : tmp23_20.toString());
    return arr;
  }
  






  public static void compileFile(CharSequence source, String output)
  {
    gnu.text.SourceMessages messages = new gnu.text.SourceMessages();
    
    gnu.expr.Compilation comp = kawa.lang.CompileFile.read(source.toString(), messages);
    explicit = true;
    if (messages.seenErrors()) {
      throw new gnu.text.SyntaxException(messages);
    }
    
    comp.compileToArchive(comp.getModule(), output);
    if (messages.seenErrors()) {
      throw new gnu.text.SyntaxException(messages);
    }
  }
  

















  public int match0(ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 14:  proc = paramModuleMethod;pc = 0;return 0;
    case 13: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 12: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 11: 
      proc = paramModuleMethod;pc = 0;return 0;
    case 9: 
      proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext);
  }
  
  public static Object getEnvironmentVariable(CharSequence name) {
    String r = System.getenv(name.toString());
    return r == null ? Boolean.FALSE : r;
  }
  
  public static Object getEnvironmentVariables() { java.util.Iterator it = System.getenv().entrySet().iterator();
    for (;;) { Object r = gnu.lists.LList.Empty;
      if (it.hasNext()) {}
      try { java.util.Map.Entry e = (java.util.Map.Entry)(localObject1 = gnu.mapping.Promise.force(it.next(), java.util.Map.Entry.class));
        tmpTernaryOp = lists.cons(lists.cons((String)e.getKey(), (String)e.getValue()), r);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject1;
        throw new gnu.mapping.WrongType(localClassCastException, "e", -2, localObject1);
      }
    }
    return r;
  }
  

  public static double currentSecond()
  {
    return System.currentTimeMillis() * 0.001D;
  }
  
  public static long currentJiffy() { return System.nanoTime(); }
  
  public static long jiffiesPerSecond() { return 1000000000; }
  
  public Object apply0(ModuleMethod paramModuleMethod)
  {
    switch (selector) {case 9:  processCommandLineAssignments();return gnu.mapping.Values.empty;
    




    case 11: 
      return getEnvironmentVariables();
    





    case 12: 
      return Double.valueOf(currentSecond());
    
    case 13: 
      return Long.valueOf(currentJiffy());
    
    case 14: 
      return Long.valueOf(jiffiesPerSecond()); } return super.apply0(paramModuleMethod);
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    
















































































    command$Mnparse = gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.isEqual.apply2(System.getProperty("file.separator"), "/")) ? tokenize$Mnstring$Mnusing$Mnshell : tokenize$Mnstring$Mnto$Mnstring$Mnarray;
    























































    $Pcpipe$Mnprocess
      .setProperty(Lit1, "kawa.lib.compile_misc:pipeProcessValidateApply");
  }
  
  static
  {
    Lit29 = gnu.mapping.Symbol.valueOf("$string-with-delimiter-marks$");Lit28 = gnu.mapping.Symbol.valueOf("run-process");Lit27 = gnu.mapping.Symbol.valueOf("%simple-construct-builder");Lit26 = new Object[0];Lit25 = gnu.mapping.Symbol.valueOf("process-exit-ok?");Lit24 = gnu.mapping.Symbol.valueOf("process-exit-wait"); kawa.lang.SyntaxRule[] tmp75_72 = new kawa.lang.SyntaxRule[2]; kawa.lang.SyntaxRule[] tmp76_75 = tmp75_72;tmp76_75[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\b", Lit26, 1, "system.scm:136"), "\001", "\003", Lit26, 0); Object[] tmp145_142 = new Object[2]; Object[] tmp146_145 = tmp145_142; gnu.mapping.SimpleSymbol tmp154_151 = gnu.mapping.Symbol.valueOf("pipe-process");Lit22 = tmp154_151;tmp146_145[0] = tmp154_151;tmp146_145[1] = gnu.mapping.Symbol.valueOf("%pipe-process");tmp76_75[1] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\f\007\f\017\023", Lit26, 3, "system.scm:137"), "\001\001\000", "\021\030\0049\021\030\f\t\003\b\013\022", tmp145_142, 0);Lit23 = new kawa.lang.SyntaxRules(Lit26, tmp75_72, 3, Lit22); kawa.lang.SyntaxRule[] tmp193_190 = new kawa.lang.SyntaxRule[1]; Object[] tmp226_223 = new Object[3]; Object[] tmp227_226 = tmp226_223;tmp227_226[0] = Lit28; Object[] tmp233_227 = tmp227_226;tmp233_227[1] = gnu.expr.Keyword.make("shell");tmp233_227[2] = Boolean.TRUE;tmp193_190[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit26, 1, "system.scm:131"), "\000", "\021\030\004\021\030\f\t\024\002", tmp226_223, 0);Lit21 = new kawa.lang.SyntaxRules(Lit26, tmp193_190, 1, system.Lit20 = gnu.mapping.Symbol.valueOf("run-process-using-sh")); kawa.lang.SyntaxRule[] tmp280_277 = new kawa.lang.SyntaxRule[1]; Object[] tmp313_310 = new Object[3]; Object[] tmp314_313 = tmp313_310;tmp314_313[0] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit27, kawa.lang.TemplateScope.make("kawa.lib.syntax")); Object[] tmp333_314 = tmp314_313;tmp333_314[1] = Lit20;tmp333_314[2] = Lit29;tmp280_277[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit26, 1, "system.scm:128"), "\000", "\t\004\021\030\f\021\030\024\t\020\002", tmp313_310, 0);Lit19 = new kawa.lang.SyntaxRules(Lit26, tmp280_277, 1, system.Lit18 = gnu.mapping.Symbol.make(Lit30, "sh")); kawa.lang.SyntaxRule[] tmp380_377 = new kawa.lang.SyntaxRule[1]; Object[] tmp413_410 = new Object[3]; Object[] tmp414_413 = tmp413_410;tmp414_413[0] = new kawa.lang.SyntaxForms.SimpleSyntaxForm(Lit27, kawa.lang.TemplateScope.make("kawa.lib.syntax")); Object[] tmp433_414 = tmp414_413;tmp433_414[1] = Lit28;tmp433_414[2] = Lit29;tmp380_377[0] = new kawa.lang.SyntaxRule(new kawa.lang.SyntaxPattern("\f\030\003", Lit26, 1, "system.scm:127"), "\000", "\t\004\021\030\f\021\030\024\t\020\002", tmp413_410, 0);Lit17 = new kawa.lang.SyntaxRules(Lit26, tmp380_377, 1, system.Lit16 = gnu.mapping.Symbol.make(Lit30, "cmd"));Lit15 = gnu.mapping.Symbol.valueOf("jiffies-per-second");Lit14 = gnu.mapping.Symbol.valueOf("current-jiffy");Lit13 = gnu.mapping.Symbol.valueOf("current-second");Lit12 = gnu.mapping.Symbol.valueOf("get-environment-variables");Lit11 = gnu.mapping.Symbol.valueOf("get-environment-variable");Lit10 = gnu.mapping.Symbol.valueOf("process-command-line-assignments");Lit9 = gnu.mapping.Symbol.valueOf("compile-file");Lit8 = gnu.mapping.Symbol.valueOf("tokenize-string-using-shell");Lit7 = gnu.mapping.Symbol.valueOf("tokenize-string-to-string-array");Lit6 = gnu.mapping.Symbol.valueOf("convert-list-to-string-array");Lit5 = gnu.mapping.Symbol.valueOf("convert-vector-to-string-array");Lit4 = gnu.mapping.Symbol.valueOf("system");Lit3 = gnu.mapping.Symbol.valueOf("open-input-pipe");Lit2 = gnu.mapping.Symbol.valueOf("make-process");Lit1 = gnu.expr.Keyword.make("validate-apply");Lit0 = gnu.math.IntNum.valueOf(0);$instance = new system();$Prvt$$string$Mnwith$Mndelimiter$Mnmarks$ = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.syntax", "$string$Mnwith$Mndelimiter$Mnmarks$");system localSystem1 = $instance;make$Mnprocess = new ModuleMethod(localSystem1, 1, Lit2, 8194);open$Mninput$Mnpipe = new ModuleMethod(localSystem1, 2, Lit3, 4097);system = new ModuleMethod(localSystem1, 3, Lit4, 4097);convert$Mnvector$Mnto$Mnstring$Mnarray = new ModuleMethod(localSystem1, 4, Lit5, 4097);convert$Mnlist$Mnto$Mnstring$Mnarray = new ModuleMethod(localSystem1, 5, Lit6, 4097);tokenize$Mnstring$Mnto$Mnstring$Mnarray = new ModuleMethod(localSystem1, 6, Lit7, 4097);tokenize$Mnstring$Mnusing$Mnshell = new ModuleMethod(localSystem1, 7, Lit8, 4097);compile$Mnfile = new ModuleMethod(localSystem1, 8, Lit9, 8194);process$Mncommand$Mnline$Mnassignments = new ModuleMethod(localSystem1, 9, Lit10, 0);get$Mnenvironment$Mnvariable = new ModuleMethod(localSystem1, 10, Lit11, 4097);get$Mnenvironment$Mnvariables = new ModuleMethod(localSystem1, 11, Lit12, 0);current$Mnsecond = new ModuleMethod(localSystem1, 12, Lit13, 0);current$Mnjiffy = new ModuleMethod(localSystem1, 13, Lit14, 0);jiffies$Mnper$Mnsecond = new ModuleMethod(localSystem1, 14, Lit15, 0);cmd = kawa.lang.Macro.make(Lit16, Lit17, "kawa.lib.system");sh = kawa.lang.Macro.make(Lit18, Lit19, "kawa.lib.system");run$Mnprocess$Mnusing$Mnsh = kawa.lang.Macro.make(Lit20, Lit21, "kawa.lib.system");pipe$Mnprocess = kawa.lang.Macro.make(Lit22, Lit23, "kawa.lib.system"); void 
    







































































































































      tmp958_955 = new gnu.expr.GenericProc("%pipe-process");
    
    system $instance = $instance; void tmp977_974 = new ModuleMethod($instance, 15, null, 8194);tmp977_974.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/system.scm:142");tmp958_955.add(tmp977_974);$Pcpipe$Mnprocess = tmp958_955;process$Mnexit$Mnwait = new ModuleMethod(localSystem1, 16, Lit24, 4097);process$Mnexit$Mnok$Qu = new ModuleMethod(localSystem1, 17, Lit25, 4097);$runBody$();
  }
  
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    switch (selector) {case 1:  return makeProcess(paramObject1, paramObject2);
    }
    
    










































































    try
    {
      Object tmp61_58 = gnu.mapping.Promise.force(paramObject2, String.class);tmp61_58;compileFile((CharSequence)gnu.mapping.Promise.force(paramObject1, CharSequence.class), tmp61_58 == null ? null : tmp61_58.toString());return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(
      





















































        localClassCastException, "compile-file", 1, paramObject1); } return lambda1(paramObject1, paramObject2);return super.apply2(paramModuleMethod, paramObject1, paramObject2); }
  public static RuntimeException lambda1(Object e1, Object e2) { return new RuntimeException("%pipe-process called"); }
  
  public static int processExitWait(Process process) {
    return process.waitFor();
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 2:  return openInputPipe(paramObject);
    




    case 3: 
      return Integer.valueOf(system(paramObject));
    





    case 4: 
      return convertVectorToStringArray(paramObject);
    




    case 5: 
      return convertListToStringArray(paramObject);
    






    case 6: 
      Object tmp113_110 = gnu.mapping.Promise.force(paramObject, String.class);tmp113_110;return tokenizeStringToStringArray(tmp113_110 == null ? null : tmp113_110.toString());
    


















    case 7: 
      return tokenizeStringUsingShell(paramObject);
    }
    
    
























    for (;;)
    {
      try
      {
        return getEnvironmentVariable((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
        








































          localClassCastException1, "get-environment-variable", 1, paramObject);
      }
      try
      {
        return Integer.valueOf(processExitWait((Process)gnu.mapping.Promise.force(paramObject, Process.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "process-exit-wait", 1, paramObject);
      }
      try {
        return isProcessExitOk((Process)gnu.mapping.Promise.force(paramObject, Process.class)) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "process-exit-ok?", 1, paramObject); } } return super.apply1(paramModuleMethod, paramObject); }
  public static boolean isProcessExitOk(Process process) { return process.waitFor() == 0; }
  
  /* Error */
  public static Process makeProcess(Object args, Object env)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	kawa/lib/vectors:isVector	(Ljava/lang/Object;)Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: invokestatic 22	kawa/lib/system:convertVectorToStringArray	(Ljava/lang/Object;)Ljava/lang/Object;
    //   11: goto +61 -> 72
    //   14: aload_0
    //   15: invokestatic 27	kawa/lib/lists:isList	(Ljava/lang/Object;)Z
    //   18: ifeq +10 -> 28
    //   21: aload_0
    //   22: invokestatic 30	kawa/lib/system:convertListToStringArray	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: goto +47 -> 72
    //   28: aload_0
    //   29: invokestatic 35	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   32: ifeq +13 -> 45
    //   35: getstatic 39	kawa/lib/system:command$Mnparse	Lgnu/mapping/Procedure;
    //   38: aload_0
    //   39: invokevirtual 44	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: goto +30 -> 72
    //   45: aload_0
    //   46: instanceof 46
    //   49: ifeq +7 -> 56
    //   52: aload_0
    //   53: goto +19 -> 72
    //   56: iconst_1
    //   57: anewarray 48	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: ldc 50
    //   64: aastore
    //   65: invokestatic 56	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   68: getstatic 62	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   71: athrow
    //   72: astore_2
    //   73: invokestatic 68	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   76: astore_3
    //   77: aload_3
    //   78: aload_2
    //   79: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   82: dup
    //   83: astore 5
    //   85: checkcast 46	[Ljava/lang/String;
    //   88: aload_1
    //   89: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: dup
    //   93: astore 5
    //   95: checkcast 46	[Ljava/lang/String;
    //   98: invokevirtual 87	java/lang/Runtime:exec	([Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/Process;
    //   101: areturn
    //   102: new 77	gnu/mapping/WrongType
    //   105: dup_x1
    //   106: swap
    //   107: ldc 79
    //   109: iconst_2
    //   110: aload 5
    //   112: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   115: athrow
    //   116: new 77	gnu/mapping/WrongType
    //   119: dup_x1
    //   120: swap
    //   121: ldc 79
    //   123: iconst_3
    //   124: aload 5
    //   126: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   129: athrow
    // Line number table:
    //   Java source line #7	-> byte code offset #0
    //   Java source line #8	-> byte code offset #0
    //   Java source line #9	-> byte code offset #0
    //   Java source line #10	-> byte code offset #14
    //   Java source line #11	-> byte code offset #28
    //   Java source line #12	-> byte code offset #52
    //   Java source line #13	-> byte code offset #56
    //   Java source line #8	-> byte code offset #73
    //   Java source line #14	-> byte code offset #73
    //   Java source line #8	-> byte code offset #77
    //   Java source line #16	-> byte code offset #77
    //   Java source line #19	-> byte code offset #77
    //   Java source line #20	-> byte code offset #101
    //   Java source line #19	-> byte code offset #102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	args	Object
    //   0	101	1	env	Object
    //   72	7	2	arargs	Object
    //   76	2	3	runtime	Runtime
    //   83	42	5	localObject1	Object
    //   102	1	5	localClassCastException1	ClassCastException
    //   116	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   85	88	102	java/lang/ClassCastException
    //   95	98	116	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object convertVectorToStringArray(Object vec)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 103
    //   3: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore_2
    //   8: checkcast 103	gnu/lists/FVector
    //   11: invokestatic 112	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
    //   14: istore_1
    //   15: iload_1
    //   16: anewarray 114	java/lang/String
    //   19: astore_2
    //   20: getstatic 118	kawa/lib/system:Lit0	Lgnu/math/IntNum;
    //   23: astore_3
    //   24: aload_3
    //   25: iload_1
    //   26: i2l
    //   27: invokestatic 124	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
    //   30: ifeq +56 -> 86
    //   33: aload_2
    //   34: aload_3
    //   35: invokevirtual 129	java/lang/Number:intValue	()I
    //   38: aload_0
    //   39: ldc 103
    //   41: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: astore 4
    //   47: checkcast 103	gnu/lists/FVector
    //   50: aload_3
    //   51: dup
    //   52: astore 4
    //   54: invokevirtual 129	java/lang/Number:intValue	()I
    //   57: invokestatic 135	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   60: ldc 114
    //   62: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   65: dup
    //   66: ifnonnull +8 -> 74
    //   69: pop
    //   70: aconst_null
    //   71: goto +6 -> 77
    //   74: invokevirtual 139	java/lang/Object:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: aload_3
    //   79: iconst_1
    //   80: invokestatic 143	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   83: goto -60 -> 23
    //   86: aload_2
    //   87: areturn
    //   88: new 77	gnu/mapping/WrongType
    //   91: dup_x1
    //   92: swap
    //   93: ldc 108
    //   95: iconst_1
    //   96: aload_2
    //   97: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   100: athrow
    //   101: new 77	gnu/mapping/WrongType
    //   104: dup_x1
    //   105: swap
    //   106: ldc -125
    //   108: iconst_1
    //   109: aload 4
    //   111: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   114: athrow
    //   115: new 77	gnu/mapping/WrongType
    //   118: dup_x1
    //   119: swap
    //   120: ldc -125
    //   122: iconst_2
    //   123: aload 4
    //   125: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   128: athrow
    // Line number table:
    //   Java source line #37	-> byte code offset #0
    //   Java source line #38	-> byte code offset #0
    //   Java source line #39	-> byte code offset #15
    //   Java source line #40	-> byte code offset #20
    //   Java source line #41	-> byte code offset #24
    //   Java source line #42	-> byte code offset #33
    //   Java source line #40	-> byte code offset #78
    //   Java source line #41	-> byte code offset #86
    //   Java source line #38	-> byte code offset #88
    //   Java source line #42	-> byte code offset #101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	vec	Object
    //   14	12	1	count	int
    //   7	1	2	localObject1	Object
    //   19	78	2	arr	String[]
    //   23	56	3	i	gnu.math.IntNum
    //   45	79	4	localObject2	Object
    //   88	1	6	localClassCastException1	ClassCastException
    //   101	1	7	localClassCastException2	ClassCastException
    //   115	1	8	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   8	11	88	java/lang/ClassCastException
    //   47	50	101	java/lang/ClassCastException
    //   54	57	115	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object convertListToStringArray(Object lst)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 149	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   4: istore_1
    //   5: iload_1
    //   6: anewarray 114	java/lang/String
    //   9: astore_2
    //   10: aload_0
    //   11: iconst_0
    //   12: istore 4
    //   14: astore_3
    //   15: aload_3
    //   16: invokestatic 152	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   19: ifeq +7 -> 26
    //   22: aload_2
    //   23: goto +55 -> 78
    //   26: aload_3
    //   27: ldc -102
    //   29: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   32: dup
    //   33: astore 6
    //   35: checkcast 154	gnu/lists/Pair
    //   38: astore 5
    //   40: aload_2
    //   41: iload 4
    //   43: aload 5
    //   45: invokevirtual 160	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   48: ldc 114
    //   50: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   53: dup
    //   54: ifnonnull +8 -> 62
    //   57: pop
    //   58: aconst_null
    //   59: goto +6 -> 65
    //   62: invokevirtual 139	java/lang/Object:toString	()Ljava/lang/String;
    //   65: aastore
    //   66: aload 5
    //   68: invokevirtual 163	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   71: iinc 4 1
    //   74: astore_3
    //   75: goto -60 -> 15
    //   78: areturn
    //   79: new 77	gnu/mapping/WrongType
    //   82: dup_x1
    //   83: swap
    //   84: ldc -100
    //   86: bipush -2
    //   88: aload 6
    //   90: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   93: athrow
    // Line number table:
    //   Java source line #44	-> byte code offset #0
    //   Java source line #45	-> byte code offset #0
    //   Java source line #46	-> byte code offset #5
    //   Java source line #47	-> byte code offset #10
    //   Java source line #48	-> byte code offset #15
    //   Java source line #49	-> byte code offset #26
    //   Java source line #50	-> byte code offset #40
    //   Java source line #51	-> byte code offset #66
    //   Java source line #49	-> byte code offset #79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	lst	Object
    //   5	73	1	count	int
    //   10	68	2	arr	String[]
    //   15	63	3	p	Object
    //   15	63	4	i	int
    //   40	38	5	pp	gnu.lists.Pair
    // Exception table:
    //   from	to	target	type
    //   35	38	79	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object tokenizeStringToStringArray(String string)
  {
    // Byte code:
    //   0: new 165	java/util/StringTokenizer
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 168	java/util/StringTokenizer:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: getstatic 174	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   12: astore_3
    //   13: aload_1
    //   14: invokevirtual 178	java/util/StringTokenizer:hasMoreTokens	()Z
    //   17: ifeq +14 -> 31
    //   20: aload_1
    //   21: invokevirtual 181	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   24: aload_3
    //   25: invokestatic 185	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   28: goto -16 -> 12
    //   31: aload_3
    //   32: astore_2
    //   33: aload_2
    //   34: invokestatic 149	gnu/lists/Sequences:getSize	(Ljava/lang/Object;)I
    //   37: istore_3
    //   38: iload_3
    //   39: anewarray 114	java/lang/String
    //   42: astore 4
    //   44: aload_2
    //   45: iload_3
    //   46: iconst_1
    //   47: isub
    //   48: istore 6
    //   50: astore 5
    //   52: aload 5
    //   54: invokestatic 152	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   57: ifeq +8 -> 65
    //   60: aload 4
    //   62: goto +58 -> 120
    //   65: aload 5
    //   67: ldc -102
    //   69: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   72: dup
    //   73: astore 8
    //   75: checkcast 154	gnu/lists/Pair
    //   78: astore 7
    //   80: aload 4
    //   82: iload 6
    //   84: aload 7
    //   86: invokevirtual 160	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   89: ldc 114
    //   91: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   94: dup
    //   95: ifnonnull +8 -> 103
    //   98: pop
    //   99: aconst_null
    //   100: goto +6 -> 106
    //   103: invokevirtual 139	java/lang/Object:toString	()Ljava/lang/String;
    //   106: aastore
    //   107: aload 7
    //   109: invokevirtual 163	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   112: iinc 6 -1
    //   115: astore 5
    //   117: goto -65 -> 52
    //   120: areturn
    //   121: new 77	gnu/mapping/WrongType
    //   124: dup_x1
    //   125: swap
    //   126: ldc -100
    //   128: bipush -2
    //   130: aload 8
    //   132: invokespecial 83	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    // Line number table:
    //   Java source line #53	-> byte code offset #0
    //   Java source line #54	-> byte code offset #0
    //   Java source line #56	-> byte code offset #9
    //   Java source line #63	-> byte code offset #13
    //   Java source line #65	-> byte code offset #20
    //   Java source line #56	-> byte code offset #20
    //   Java source line #57	-> byte code offset #20
    //   Java source line #60	-> byte code offset #20
    //   Java source line #56	-> byte code offset #31
    //   Java source line #64	-> byte code offset #31
    //   Java source line #54	-> byte code offset #33
    //   Java source line #66	-> byte code offset #33
    //   Java source line #54	-> byte code offset #38
    //   Java source line #67	-> byte code offset #38
    //   Java source line #68	-> byte code offset #44
    //   Java source line #69	-> byte code offset #52
    //   Java source line #70	-> byte code offset #65
    //   Java source line #71	-> byte code offset #80
    //   Java source line #72	-> byte code offset #107
    //   Java source line #70	-> byte code offset #121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	string	String
    //   9	111	1	toks	java.util.StringTokenizer
    //   33	87	2	rlist	Object
    //   13	19	3	list	Object
    //   38	82	3	count	int
    //   44	76	4	arr	String[]
    //   52	68	5	p	Object
    //   52	68	6	i	int
    //   80	40	7	pp	gnu.lists.Pair
    // Exception table:
    //   from	to	target	type
    //   75	78	121	java/lang/ClassCastException
  }
  
  public static void processCommandLineAssignments() {}
  
  public system()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 527	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+289->293, 2:+272->276, 3:+255->259, 4:+238->242, 5:+221->225, 6:+199->203, 7:+182->186, 8:+289->293, 9:+289->293, 10:+146->150, 11:+289->293, 12:+289->293, 13:+289->293, 14:+289->293, 15:+289->293, 16:+113->117, 17:+80->84
    //   84: aload_3
    //   85: aload_2
    //   86: ldc 93
    //   88: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   91: dup
    //   92: instanceof 93
    //   95: ifne +7 -> 102
    //   98: ldc_w 538
    //   101: ireturn
    //   102: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   105: aload_3
    //   106: aload_1
    //   107: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   110: aload_3
    //   111: iconst_1
    //   112: putfield 533	gnu/mapping/CallContext:pc	I
    //   115: iconst_0
    //   116: ireturn
    //   117: aload_3
    //   118: aload_2
    //   119: ldc 93
    //   121: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   124: dup
    //   125: instanceof 93
    //   128: ifne +7 -> 135
    //   131: ldc_w 538
    //   134: ireturn
    //   135: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   138: aload_3
    //   139: aload_1
    //   140: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   143: aload_3
    //   144: iconst_1
    //   145: putfield 533	gnu/mapping/CallContext:pc	I
    //   148: iconst_0
    //   149: ireturn
    //   150: aload_3
    //   151: aload_2
    //   152: ldc -28
    //   154: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   157: dup
    //   158: instanceof 228
    //   161: ifeq +6 -> 167
    //   164: goto +7 -> 171
    //   167: ldc_w 538
    //   170: ireturn
    //   171: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   174: aload_3
    //   175: aload_1
    //   176: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   179: aload_3
    //   180: iconst_1
    //   181: putfield 533	gnu/mapping/CallContext:pc	I
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_3
    //   187: aload_2
    //   188: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   191: aload_3
    //   192: aload_1
    //   193: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   196: aload_3
    //   197: iconst_1
    //   198: putfield 533	gnu/mapping/CallContext:pc	I
    //   201: iconst_0
    //   202: ireturn
    //   203: aload_3
    //   204: aload_2
    //   205: ldc 114
    //   207: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   210: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   213: aload_3
    //   214: aload_1
    //   215: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   218: aload_3
    //   219: iconst_1
    //   220: putfield 533	gnu/mapping/CallContext:pc	I
    //   223: iconst_0
    //   224: ireturn
    //   225: aload_3
    //   226: aload_2
    //   227: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   230: aload_3
    //   231: aload_1
    //   232: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   235: aload_3
    //   236: iconst_1
    //   237: putfield 533	gnu/mapping/CallContext:pc	I
    //   240: iconst_0
    //   241: ireturn
    //   242: aload_3
    //   243: aload_2
    //   244: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   247: aload_3
    //   248: aload_1
    //   249: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   252: aload_3
    //   253: iconst_1
    //   254: putfield 533	gnu/mapping/CallContext:pc	I
    //   257: iconst_0
    //   258: ireturn
    //   259: aload_3
    //   260: aload_2
    //   261: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   264: aload_3
    //   265: aload_1
    //   266: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   269: aload_3
    //   270: iconst_1
    //   271: putfield 533	gnu/mapping/CallContext:pc	I
    //   274: iconst_0
    //   275: ireturn
    //   276: aload_3
    //   277: aload_2
    //   278: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   281: aload_3
    //   282: aload_1
    //   283: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   286: aload_3
    //   287: iconst_1
    //   288: putfield 533	gnu/mapping/CallContext:pc	I
    //   291: iconst_0
    //   292: ireturn
    //   293: aload_0
    //   294: aload_1
    //   295: aload_2
    //   296: aload_3
    //   297: invokespecial 546	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   300: ireturn
    // Line number table:
    //   Java source line #148	-> byte code offset #84
    //   Java source line #145	-> byte code offset #117
    //   Java source line #106	-> byte code offset #150
    //   Java source line #74	-> byte code offset #186
    //   Java source line #53	-> byte code offset #203
    //   Java source line #44	-> byte code offset #225
    //   Java source line #37	-> byte code offset #242
    //   Java source line #29	-> byte code offset #259
    //   Java source line #22	-> byte code offset #276
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 527	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+138->142, 1:+112->116, 8:+62->66, 15:+36->40
    //   40: aload 4
    //   42: aload_2
    //   43: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   46: aload 4
    //   48: aload_3
    //   49: putfield 549	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   52: aload 4
    //   54: aload_1
    //   55: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   58: aload 4
    //   60: iconst_2
    //   61: putfield 533	gnu/mapping/CallContext:pc	I
    //   64: iconst_0
    //   65: ireturn
    //   66: aload 4
    //   68: aload_2
    //   69: ldc -28
    //   71: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   74: dup
    //   75: instanceof 228
    //   78: ifeq +6 -> 84
    //   81: goto +7 -> 88
    //   84: ldc_w 538
    //   87: ireturn
    //   88: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   91: aload 4
    //   93: aload_3
    //   94: ldc 114
    //   96: invokestatic 106	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   99: putfield 549	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   102: aload 4
    //   104: aload_1
    //   105: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   108: aload 4
    //   110: iconst_2
    //   111: putfield 533	gnu/mapping/CallContext:pc	I
    //   114: iconst_0
    //   115: ireturn
    //   116: aload 4
    //   118: aload_2
    //   119: putfield 542	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   122: aload 4
    //   124: aload_3
    //   125: putfield 549	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   128: aload 4
    //   130: aload_1
    //   131: putfield 530	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   134: aload 4
    //   136: iconst_2
    //   137: putfield 533	gnu/mapping/CallContext:pc	I
    //   140: iconst_0
    //   141: ireturn
    //   142: aload_0
    //   143: aload_1
    //   144: aload_2
    //   145: aload_3
    //   146: aload 4
    //   148: invokespecial 553	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   151: ireturn
    // Line number table:
    //   Java source line #142	-> byte code offset #40
    //   Java source line #87	-> byte code offset #66
    //   Java source line #7	-> byte code offset #116
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
