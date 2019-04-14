package gnu.kawa.slib; import gnu.expr.ModuleMethod;

public class XStrings extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; } public int match2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject1;value2 = paramObject2;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); } public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, gnu.mapping.CallContext paramCallContext) { if (selector == 1) { value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0; } return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext); } public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2) { if (selector == 1) return substring(paramObject1, paramObject2); return super.apply2(paramModuleMethod, paramObject1, paramObject2); } public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3) { if (selector == 1) return substring(paramObject1, paramObject2, paramObject3); return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3);
  }
  

  public static final ModuleMethod substring;
  
  public static final ModuleMethod string$Mnlength;
  
  static final gnu.math.IntNum Lit0;
  public static XStrings $instance;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2 = gnu.mapping.Symbol.valueOf("string-length");
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    if (selector == 3) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 3) return stringLength(paramObject); return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static Object stringLength(Object string) { return string == gnu.mapping.Values.empty ? gnu.mapping.Values.empty : Integer.valueOf(((String)gnu.mapping.Promise.force(string, String.class)).length()); }
  
  public static Object substring(Object paramObject1, Object paramObject2)
  {
    return substring(paramObject1, paramObject2, Lit0);
  }
  
  /* Error */
  public static Object substring(Object string, Object start, Object length)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 26	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   4: if_acmpne +7 -> 11
    //   7: iconst_1
    //   8: goto +4 -> 12
    //   11: iconst_0
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq +10 -> 24
    //   17: iload_3
    //   18: ifeq +46 -> 64
    //   21: goto +37 -> 58
    //   24: aload_1
    //   25: getstatic 26	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   28: if_acmpne +7 -> 35
    //   31: iconst_1
    //   32: goto +4 -> 36
    //   35: iconst_0
    //   36: istore 4
    //   38: iload 4
    //   40: ifeq +11 -> 51
    //   43: iload 4
    //   45: ifeq +19 -> 64
    //   48: goto +10 -> 58
    //   51: aload_2
    //   52: getstatic 26	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   55: if_acmpne +9 -> 64
    //   58: getstatic 26	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   61: goto +95 -> 156
    //   64: aload_0
    //   65: ldc 28
    //   67: invokestatic 34	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   70: dup
    //   71: astore 5
    //   73: checkcast 28	java/lang/String
    //   76: astore 4
    //   78: aload 4
    //   80: invokevirtual 48	java/lang/String:length	()I
    //   83: istore 5
    //   85: aload_1
    //   86: invokestatic 51	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   89: dup
    //   90: astore 7
    //   92: checkcast 53	java/lang/Number
    //   95: invokevirtual 56	java/lang/Number:intValue	()I
    //   98: istore 6
    //   100: iload 6
    //   102: iconst_1
    //   103: isub
    //   104: istore 7
    //   106: aload_2
    //   107: invokestatic 51	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   110: dup
    //   111: astore 9
    //   113: checkcast 53	java/lang/Number
    //   116: invokevirtual 56	java/lang/Number:intValue	()I
    //   119: istore 8
    //   121: iload 5
    //   123: iload 7
    //   125: isub
    //   126: istore 9
    //   128: iload 8
    //   130: iload 9
    //   132: if_icmple +8 -> 140
    //   135: iload 9
    //   137: goto +5 -> 142
    //   140: iload 8
    //   142: istore 10
    //   144: aload 4
    //   146: iload 7
    //   148: iload 7
    //   150: iload 10
    //   152: iadd
    //   153: invokevirtual 63	java/lang/String:substring	(II)Ljava/lang/String;
    //   156: areturn
    //   157: new 38	gnu/mapping/WrongType
    //   160: dup_x1
    //   161: swap
    //   162: ldc 40
    //   164: bipush -2
    //   166: aload 5
    //   168: invokespecial 44	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: new 38	gnu/mapping/WrongType
    //   175: dup_x1
    //   176: swap
    //   177: ldc 58
    //   179: bipush -2
    //   181: aload 7
    //   183: invokespecial 44	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: new 38	gnu/mapping/WrongType
    //   190: dup_x1
    //   191: swap
    //   192: ldc 60
    //   194: bipush -2
    //   196: aload 9
    //   198: invokespecial 44	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   201: athrow
    // Line number table:
    //   Java source line #1	-> byte code offset #0
    //   Java source line #2	-> byte code offset #0
    //   Java source line #3	-> byte code offset #24
    //   Java source line #2	-> byte code offset #38
    //   Java source line #4	-> byte code offset #51
    //   Java source line #6	-> byte code offset #64
    //   Java source line #7	-> byte code offset #78
    //   Java source line #6	-> byte code offset #85
    //   Java source line #8	-> byte code offset #85
    //   Java source line #6	-> byte code offset #100
    //   Java source line #9	-> byte code offset #100
    //   Java source line #6	-> byte code offset #106
    //   Java source line #10	-> byte code offset #106
    //   Java source line #6	-> byte code offset #121
    //   Java source line #11	-> byte code offset #121
    //   Java source line #6	-> byte code offset #128
    //   Java source line #12	-> byte code offset #128
    //   Java source line #13	-> byte code offset #144
    //   Java source line #6	-> byte code offset #157
    //   Java source line #8	-> byte code offset #172
    //   Java source line #10	-> byte code offset #187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	string	Object
    //   0	156	1	start	Object
    //   0	156	2	length	Object
    //   12	6	3	x	boolean
    //   36	8	4	x	boolean
    //   76	69	4	s	String
    //   71	1	5	localObject1	Object
    //   83	84	5	slen	int
    //   98	3	6	sindex	int
    //   90	1	7	localObject2	Object
    //   104	78	7	index	int
    //   119	22	8	len	int
    //   111	1	9	localObject3	Object
    //   126	71	9	avail	int
    //   142	11	10	rlen	int
    //   157	1	15	localClassCastException1	ClassCastException
    //   172	1	16	localClassCastException2	ClassCastException
    //   187	1	17	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   73	76	157	java/lang/ClassCastException
    //   92	98	172	java/lang/ClassCastException
    //   113	119	187	java/lang/ClassCastException
  }
  
  static
  {
    Lit1 = gnu.mapping.Symbol.valueOf("substring");
    Lit0 = gnu.math.IntNum.valueOf(Integer.MAX_VALUE);
    $instance = new XStrings();
    XStrings localXStrings = $instance;
    substring = new ModuleMethod(localXStrings, 1, Lit1, 12290);
    string$Mnlength = new ModuleMethod(localXStrings, 3, Lit2, 4097);
    $runBody$();
  }
  
  public XStrings()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
