package gnu.kawa.slib;

import gnu.expr.ModuleMethod;

public class genwrite extends gnu.expr.ModuleBody { private static void $runBody$() { ;
    gnu.lists.Consumer $result = getInstanceconsumer; } public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, gnu.mapping.CallContext paramCallContext) { if (selector == 12) { value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0; } return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext); } public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) { if (selector == 12) return genericWrite(paramObject1, paramObject2, paramObject3, paramObject4); return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public static final ModuleMethod generic$Mnwrite;
  public static final ModuleMethod reverse$Mnstring$Mnappend;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  public class frame
    extends gnu.expr.ModuleBody
  {
    Object width;
    Object display$Qu;
    Object output;
    
    /* Error */
    public Object lambda21wr(Object obj, Object col)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 58	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   4: ifeq +237 -> 241
      //   7: aload_1
      //   8: aload_2
      //   9: astore 4
      //   11: astore_3
      //   12: aload_3
      //   13: invokestatic 132	gnu/kawa/slib/genwrite$frame:lambda3isReadMacro	(Ljava/lang/Object;)Z
      //   16: ifeq +24 -> 40
      //   19: aload_0
      //   20: aload_3
      //   21: invokestatic 135	gnu/kawa/slib/genwrite$frame:lambda5readMacroBody	(Ljava/lang/Object;)Ljava/lang/Object;
      //   24: aload_0
      //   25: aload_3
      //   26: invokestatic 138	gnu/kawa/slib/genwrite$frame:lambda6readMacroPrefix	(Ljava/lang/Object;)Ljava/lang/Object;
      //   29: aload 4
      //   31: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   34: invokevirtual 144	gnu/kawa/slib/genwrite$frame:lambda21wr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   37: goto +284 -> 321
      //   40: aload_3
      //   41: aload 4
      //   43: goto +3 -> 46
      //   46: astore 6
      //   48: astore 5
      //   50: aload 5
      //   52: invokestatic 58	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   55: ifeq +175 -> 230
      //   58: aload 5
      //   60: ldc 2
      //   62: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   65: dup
      //   66: astore 7
      //   68: checkcast 2	gnu/lists/Pair
      //   71: invokestatic 27	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   74: aload 6
      //   76: invokestatic 84	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   79: ifeq +34 -> 113
      //   82: aload_0
      //   83: aload 5
      //   85: ldc 2
      //   87: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   90: dup
      //   91: astore 7
      //   93: checkcast 2	gnu/lists/Pair
      //   96: invokestatic 23	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   99: aload_0
      //   100: ldc -110
      //   102: aload 6
      //   104: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   107: invokevirtual 144	gnu/kawa/slib/genwrite$frame:lambda21wr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   110: goto +6 -> 116
      //   113: getstatic 129	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   116: astore 8
      //   118: astore 7
      //   120: aload 8
      //   122: invokestatic 84	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   125: ifne +8 -> 133
      //   128: aload 8
      //   130: goto +191 -> 321
      //   133: aload 7
      //   135: invokestatic 58	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   138: ifeq +50 -> 188
      //   141: aload 7
      //   143: ldc 2
      //   145: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   148: dup
      //   149: astore 9
      //   151: checkcast 2	gnu/lists/Pair
      //   154: invokestatic 27	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   157: aload_0
      //   158: aload 7
      //   160: ldc 2
      //   162: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   165: dup
      //   166: astore 9
      //   168: checkcast 2	gnu/lists/Pair
      //   171: invokestatic 23	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   174: aload_0
      //   175: ldc -108
      //   177: aload 8
      //   179: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   182: invokevirtual 144	gnu/kawa/slib/genwrite$frame:lambda21wr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   185: goto -69 -> 116
      //   188: aload 7
      //   190: invokestatic 61	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   193: ifeq +14 -> 207
      //   196: aload_0
      //   197: ldc -106
      //   199: aload 8
      //   201: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   204: goto +117 -> 321
      //   207: aload_0
      //   208: ldc -106
      //   210: aload_0
      //   211: aload 7
      //   213: aload_0
      //   214: ldc -104
      //   216: aload 8
      //   218: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   221: invokevirtual 144	gnu/kawa/slib/genwrite$frame:lambda21wr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   224: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   227: goto +94 -> 321
      //   230: aload_0
      //   231: ldc -102
      //   233: aload 6
      //   235: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   238: goto +83 -> 321
      //   241: aload_1
      //   242: invokestatic 61	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   245: ifeq +8 -> 253
      //   248: aload_1
      //   249: aload_2
      //   250: goto -204 -> 46
      //   253: aload_1
      //   254: invokestatic 159	kawa/lib/vectors:isVector	(Ljava/lang/Object;)Z
      //   257: ifeq +27 -> 284
      //   260: aload_1
      //   261: ldc -95
      //   263: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   266: dup
      //   267: astore_3
      //   268: checkcast 161	gnu/lists/FVector
      //   271: invokestatic 167	kawa/lib/vectors:vector$To$List	(Lgnu/lists/FVector;)Lgnu/lists/LList;
      //   274: aload_0
      //   275: ldc -87
      //   277: aload_2
      //   278: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   281: goto -235 -> 46
      //   284: aload_0
      //   285: iconst_0
      //   286: iconst_2
      //   287: anewarray 29	java/lang/Object
      //   290: dup
      //   291: iconst_0
      //   292: aload_0
      //   293: getfield 172	gnu/kawa/slib/genwrite$frame:display$Qu	Ljava/lang/Object;
      //   296: invokestatic 84	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   299: ifeq +8 -> 307
      //   302: ldc -82
      //   304: goto +5 -> 309
      //   307: ldc -80
      //   309: aastore
      //   310: dup
      //   311: iconst_1
      //   312: aload_1
      //   313: aastore
      //   314: invokestatic 182	gnu/kawa/functions/Format:formatToString	(I[Ljava/lang/Object;)Ljava/lang/String;
      //   317: aload_2
      //   318: invokevirtual 141	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   321: areturn
      //   322: new 12	gnu/mapping/WrongType
      //   325: dup_x1
      //   326: swap
      //   327: ldc 25
      //   329: iconst_1
      //   330: aload 7
      //   332: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   335: athrow
      //   336: new 12	gnu/mapping/WrongType
      //   339: dup_x1
      //   340: swap
      //   341: ldc 14
      //   343: iconst_1
      //   344: aload 7
      //   346: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   349: athrow
      //   350: new 12	gnu/mapping/WrongType
      //   353: dup_x1
      //   354: swap
      //   355: ldc 25
      //   357: iconst_1
      //   358: aload 9
      //   360: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   363: athrow
      //   364: new 12	gnu/mapping/WrongType
      //   367: dup_x1
      //   368: swap
      //   369: ldc 14
      //   371: iconst_1
      //   372: aload 9
      //   374: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   377: athrow
      //   378: new 12	gnu/mapping/WrongType
      //   381: dup_x1
      //   382: swap
      //   383: ldc -93
      //   385: iconst_1
      //   386: aload_3
      //   387: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   390: athrow
      // Line number table:
      //   Java source line #29	-> byte code offset #0
      //   Java source line #31	-> byte code offset #0
      //   Java source line #36	-> byte code offset #0
      //   Java source line #31	-> byte code offset #0
      //   Java source line #47	-> byte code offset #0
      //   Java source line #31	-> byte code offset #9
      //   Java source line #32	-> byte code offset #12
      //   Java source line #33	-> byte code offset #19
      //   Java source line #34	-> byte code offset #40
      //   Java source line #36	-> byte code offset #46
      //   Java source line #37	-> byte code offset #50
      //   Java source line #38	-> byte code offset #58
      //   Java source line #39	-> byte code offset #74
      //   Java source line #40	-> byte code offset #120
      //   Java source line #41	-> byte code offset #133
      //   Java source line #42	-> byte code offset #141
      //   Java source line #43	-> byte code offset #188
      //   Java source line #44	-> byte code offset #207
      //   Java source line #45	-> byte code offset #230
      //   Java source line #48	-> byte code offset #241
      //   Java source line #49	-> byte code offset #253
      //   Java source line #50	-> byte code offset #284
      //   Java source line #38	-> byte code offset #322
      //   Java source line #39	-> byte code offset #336
      //   Java source line #42	-> byte code offset #350
      //   Java source line #49	-> byte code offset #378
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	322	0	this	frame
      //   0	321	1	obj	Object
      //   0	321	2	col	Object
      //   12	226	3	expr	Object
      //   12	226	4	col	Object
      //   50	188	5	l	Object
      //   50	188	6	col	Object
      //   120	107	7	l	Object
      //   120	107	8	col	Object
      // Exception table:
      //   from	to	target	type
      //   68	71	322	java/lang/ClassCastException
      //   93	96	336	java/lang/ClassCastException
      //   151	154	350	java/lang/ClassCastException
      //   168	171	364	java/lang/ClassCastException
      //   268	271	378	java/lang/ClassCastException
    }
    
    /* Error */
    public static Object lambda6readMacroPrefix(Object l)
    {
      // Byte code:
      //   0: aload_0
      //   1: ldc 2
      //   3: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   6: dup
      //   7: astore_2
      //   8: checkcast 2	gnu/lists/Pair
      //   11: invokestatic 23	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   14: astore_1
      //   15: aload_0
      //   16: ldc 2
      //   18: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   21: dup
      //   22: astore_2
      //   23: checkcast 2	gnu/lists/Pair
      //   26: invokestatic 27	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   29: pop
      //   30: aload_1
      //   31: invokevirtual 33	java/lang/Object:hashCode	()I
      //   34: lookupswitch	default:+102->136, -279091325:+42->76, 107953788:+72->106, 881169219:+87->121, 1896636553:+57->91
      //   76: aload_1
      //   77: getstatic 39	gnu/kawa/slib/genwrite:Lit29	Lgnu/mapping/SimpleSymbol;
      //   80: invokestatic 45	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   83: ifeq +53 -> 136
      //   86: ldc 67
      //   88: goto +54 -> 142
      //   91: aload_1
      //   92: getstatic 48	gnu/kawa/slib/genwrite:Lit30	Lgnu/mapping/SimpleSymbol;
      //   95: invokestatic 45	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   98: ifeq +38 -> 136
      //   101: ldc 69
      //   103: goto +39 -> 142
      //   106: aload_1
      //   107: getstatic 51	gnu/kawa/slib/genwrite:Lit31	Lgnu/mapping/SimpleSymbol;
      //   110: invokestatic 45	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   113: ifeq +23 -> 136
      //   116: ldc 71
      //   118: goto +24 -> 142
      //   121: aload_1
      //   122: getstatic 54	gnu/kawa/slib/genwrite:Lit32	Lgnu/mapping/SimpleSymbol;
      //   125: invokestatic 45	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   128: ifeq +8 -> 136
      //   131: ldc 73
      //   133: goto +9 -> 142
      //   136: getstatic 79	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   139: goto +3 -> 142
      //   142: areturn
      //   143: new 12	gnu/mapping/WrongType
      //   146: dup_x1
      //   147: swap
      //   148: ldc 14
      //   150: iconst_1
      //   151: aload_2
      //   152: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   155: athrow
      //   156: new 12	gnu/mapping/WrongType
      //   159: dup_x1
      //   160: swap
      //   161: ldc 25
      //   163: iconst_1
      //   164: aload_2
      //   165: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   168: athrow
      // Line number table:
      //   Java source line #18	-> byte code offset #0
      //   Java source line #19	-> byte code offset #0
      //   Java source line #20	-> byte code offset #30
      //   Java source line #19	-> byte code offset #143
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	142	0	l	Object
      //   30	112	1	head	Object
      // Exception table:
      //   from	to	target	type
      //   8	11	143	java/lang/ClassCastException
      //   23	26	156	java/lang/ClassCastException
    }
    
    public static Object lambda5readMacroBody(Object l)
    {
      return kawa.lib.lists.cadr(l);
    }
    
    /* Error */
    public static boolean lambda3isReadMacro(Object l)
    {
      // Byte code:
      //   0: aload_0
      //   1: ldc 2
      //   3: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   6: dup
      //   7: astore_2
      //   8: checkcast 2	gnu/lists/Pair
      //   11: invokestatic 23	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   14: astore_1
      //   15: aload_0
      //   16: ldc 2
      //   18: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   21: dup
      //   22: astore_3
      //   23: checkcast 2	gnu/lists/Pair
      //   26: invokestatic 27	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   29: astore_2
      //   30: aload_1
      //   31: invokevirtual 33	java/lang/Object:hashCode	()I
      //   34: lookupswitch	default:+125->159, -279091325:+42->76, 107953788:+68->102, 881169219:+81->115, 1896636553:+55->89
      //   76: aload_1
      //   77: getstatic 39	gnu/kawa/slib/genwrite:Lit29	Lgnu/mapping/SimpleSymbol;
      //   80: invokestatic 45	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   83: ifeq +76 -> 159
      //   86: goto +39 -> 125
      //   89: aload_1
      //   90: getstatic 48	gnu/kawa/slib/genwrite:Lit30	Lgnu/mapping/SimpleSymbol;
      //   93: invokestatic 45	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   96: ifeq +63 -> 159
      //   99: goto +26 -> 125
      //   102: aload_1
      //   103: getstatic 51	gnu/kawa/slib/genwrite:Lit31	Lgnu/mapping/SimpleSymbol;
      //   106: invokestatic 45	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   109: ifeq +50 -> 159
      //   112: goto +13 -> 125
      //   115: aload_1
      //   116: getstatic 54	gnu/kawa/slib/genwrite:Lit32	Lgnu/mapping/SimpleSymbol;
      //   119: invokestatic 45	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   122: ifeq +37 -> 159
      //   125: aload_2
      //   126: astore_3
      //   127: aload_3
      //   128: invokestatic 58	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   131: ifeq +24 -> 155
      //   134: aload_3
      //   135: ldc 2
      //   137: invokestatic 8	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   140: dup
      //   141: astore 4
      //   143: checkcast 2	gnu/lists/Pair
      //   146: invokestatic 27	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   149: invokestatic 61	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   152: goto +11 -> 163
      //   155: iconst_0
      //   156: goto +7 -> 163
      //   159: iconst_0
      //   160: goto +3 -> 163
      //   163: ireturn
      //   164: new 12	gnu/mapping/WrongType
      //   167: dup_x1
      //   168: swap
      //   169: ldc 14
      //   171: iconst_1
      //   172: aload_2
      //   173: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   176: athrow
      //   177: new 12	gnu/mapping/WrongType
      //   180: dup_x1
      //   181: swap
      //   182: ldc 25
      //   184: iconst_1
      //   185: aload_3
      //   186: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   189: athrow
      //   190: new 12	gnu/mapping/WrongType
      //   193: dup_x1
      //   194: swap
      //   195: ldc 25
      //   197: iconst_1
      //   198: aload 4
      //   200: invokespecial 18	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   203: athrow
      // Line number table:
      //   Java source line #8	-> byte code offset #0
      //   Java source line #9	-> byte code offset #0
      //   Java source line #10	-> byte code offset #0
      //   Java source line #11	-> byte code offset #30
      //   Java source line #12	-> byte code offset #125
      //   Java source line #9	-> byte code offset #126
      //   Java source line #10	-> byte code offset #164
      //   Java source line #9	-> byte code offset #190
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	l	Object
      //   30	133	1	head	Object
      //   30	133	2	tail	Object
      //   127	29	3	l	Object
      // Exception table:
      //   from	to	target	type
      //   8	11	164	java/lang/ClassCastException
      //   23	26	177	java/lang/ClassCastException
      //   143	146	190	java/lang/ClassCastException
    }
    
    public Object lambda1out(Object str, Object col)
    {
      if ((!gnu.expr.KawaConvert.isTrue(col)) || (gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply2(output, str)))) {} try { tmpTernaryOp = gnu.kawa.functions.AddOp.apply2(1, col, Integer.valueOf(kawa.lib.strings.stringLength((CharSequence)(localObject = gnu.mapping.Promise.force(str, CharSequence.class))))); break label58; tmpTernaryOp = Boolean.FALSE; label58: return Boolean.FALSE; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "string-length", 1, localObject);
      }
    }
    
    public frame() {}
  }
  
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final gnu.mapping.SimpleSymbol Lit6;
  static final gnu.mapping.SimpleSymbol Lit7;
  static final gnu.mapping.SimpleSymbol Lit8;
  static final gnu.mapping.SimpleSymbol Lit9;
  static final gnu.mapping.SimpleSymbol Lit10;
  static final gnu.mapping.SimpleSymbol Lit11;
  static final gnu.mapping.SimpleSymbol Lit12;
  static final gnu.math.IntNum Lit13;
  static final gnu.math.IntNum Lit14;
  static final gnu.math.IntNum Lit15;
  static final gnu.math.IntNum Lit16;
  public class frame0 extends gnu.expr.ModuleBody
  {
    gnu.mapping.Procedure pp$MnDO = new ModuleMethod(this, 11, genwrite.Lit28, 12291);
    gnu.mapping.Procedure pp$MnBEGIN = new ModuleMethod(this, 10, genwrite.Lit27, 12291);
    gnu.mapping.Procedure pp$MnLET = new ModuleMethod(this, 9, genwrite.Lit26, 12291);
    gnu.mapping.Procedure pp$MnAND = new ModuleMethod(this, 8, genwrite.Lit25, 12291);
    gnu.mapping.Procedure pp$MnCASE = new ModuleMethod(this, 7, genwrite.Lit24, 12291);
    gnu.mapping.Procedure pp$MnCOND = new ModuleMethod(this, 6, genwrite.Lit23, 12291);
    gnu.mapping.Procedure pp$MnIF = new ModuleMethod(this, 5, genwrite.Lit22, 12291);
    gnu.mapping.Procedure pp$MnLAMBDA = new ModuleMethod(this, 4, genwrite.Lit21, 12291);
    gnu.mapping.Procedure pp$Mnexpr$Mnlist = new ModuleMethod(this, 3, genwrite.Lit20, 12291);
    gnu.mapping.Procedure pp$Mnexpr = new ModuleMethod(this, 2, genwrite.Lit19, 12291);
    genwrite.frame staticLink;
    
    public Object lambda19indent(Object to, Object col)
    {
      tmpTernaryOp = (gnu.expr.KawaConvert.isTrue(col) ? col : gnu.expr.KawaConvert.isTrue(staticLink.lambda1out(kawa.lib.strings.makeString(1, 10), col)) ? genwrite.Lit13 : Boolean.FALSE;
      break label142;
      Object localObject1 = 
      









        gnu.kawa.functions.AddOp.apply2(-1, to, col);Object n = to;
      Object col;
      if (gnu.kawa.functions.NumberCompare.$Gr(n, genwrite.Lit13)) {}
      try
      {
        tmpTernaryOp = staticLink.lambda1out(kawa.lib.strings.substring("        ", 0, ((Number)(localObject2 = gnu.mapping.Promise.force(n))).intValue()), col);
        label142:
        return 
        






          gnu.kawa.functions.NumberCompare.$Ls(to, col) ? 
          Boolean.FALSE : col;
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject2;
        throw new gnu.mapping.WrongType(localClassCastException, "substring", 3, localObject2);
      }
    }
    



    public Object lambda4pr(Object obj, Object col, Object extra, Object pp$Mnpair)
    {
      void tmp7_4 = new genwrite.frame1();74staticLink = this;genwrite.frame1 $heapFrame = tmp7_4;
      boolean x = kawa.lib.lists.isPair(obj); if (x ? x : kawa.lib.vectors.isVector(obj)) {
        result = gnu.lists.LList.Empty;
        left = kawa.lib.numbers.min(new Object[] { gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(-1, gnu.kawa.functions.AddOp.apply2(-1, staticLink.width, col), extra), genwrite.Lit16), genwrite.Lit17 });
        
        genwrite.genericWrite(obj, staticLink.display$Qu, Boolean.FALSE, lambda$Fn1);
      }
      



      try
      {
        tmpTernaryOp = lambda9ppList(kawa.lib.vectors.vector$To$List((gnu.lists.FVector)(localObject = gnu.mapping.Promise.force(obj, gnu.lists.FVector.class))), staticLink.lambda1out("#", col), extra, pp$Mnexpr);
        return kawa.lib.lists.isPair(obj) ? kawa.standard.Scheme.applyToArgs.apply4(pp$Mnpair, obj, col, extra) : gnu.kawa.functions.NumberCompare.$Gr(left, genwrite.Lit13) ? staticLink.lambda1out(genwrite.reverseStringAppend(result), col) : staticLink.lambda21wr(obj, col);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new gnu.mapping.WrongType(
          localClassCastException, "vector->list", 1, localObject);
      }
    }
    






































































































    public int match3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, gnu.mapping.CallContext paramCallContext)
    {
      switch (selector) {case 11:  value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 10: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 9: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 8: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 7: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 6: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 5: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 4: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 3: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0;
      case 2: 
        value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;proc = paramModuleMethod;pc = 3;return 0; } return super.match3(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramCallContext);
    }
    
























    public Object lambda9ppList(Object l, Object col, Object extra, gnu.mapping.Procedure pp$Mnitem)
    {
      Object col = staticLink.lambda1out("(", col);
      return lambda22ppDown(l, col, col, extra, pp$Mnitem);
    }
    
    public Object lambda22ppDown(Object l, Object col1, Object col2, Object extra, Object pp$Mnitem) { for (;;) { Object localObject1 = col1;Object l = l;
        Object col; if ((!gnu.expr.KawaConvert.isTrue(col)) || 
          (kawa.lib.lists.isPair(l))) {}
        Object localObject3; try { Object localObject2; rest = kawa.lib.lists.cdr((gnu.lists.Pair)(localObject2 = gnu.mapping.Promise.force(l, gnu.lists.Pair.class)));
          extra = kawa.lib.lists.isNull(rest) ? gnu.kawa.functions.AddOp.apply2(1, extra, genwrite.Lit16) : genwrite.Lit13;
        }
        catch (ClassCastException localClassCastException1)
        {
          Object rest;
          Object extra;
          throw new gnu.mapping.WrongType(
          









            localClassCastException1, "cdr", 1, extra);
        }
        try
        {
          tmpTernaryOp = lambda4pr(kawa.lib.lists.car((gnu.lists.Pair)(localObject3 = gnu.mapping.Promise.force(l, gnu.lists.Pair.class))), lambda19indent(col2, col), extra, pp$Mnitem); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "car", 1, localObject3);
        }
      }
      




      tmpTernaryOp = staticLink.lambda1out(")", lambda4pr(l, lambda19indent(col2, staticLink.lambda1out(".", lambda19indent(col2, col))), gnu.kawa.functions.AddOp.apply2(1, extra, genwrite.Lit16), pp$Mnitem));return kawa.lib.lists.isNull(l) ? staticLink.lambda1out(")", col) : Boolean.FALSE;
    }
    





























    public Object lambda10ppExprList(Object l, Object col, Object extra)
    {
      return lambda9ppList(l, col, extra, pp$Mnexpr);
    }
    
    public Object lambda11ppLAMBDA(Object expr, Object col, Object extra) { return lambda7ppGeneral(expr, col, extra, Boolean.FALSE, pp$Mnexpr$Mnlist, Boolean.FALSE, pp$Mnexpr); }
    
    public Object lambda12ppIF(Object expr, Object col, Object extra) {
      return lambda7ppGeneral(expr, col, extra, Boolean.FALSE, pp$Mnexpr, Boolean.FALSE, pp$Mnexpr);
    }
    
    public Object lambda13ppCOND(Object expr, Object col, Object extra) { return lambda8ppCall(expr, col, extra, pp$Mnexpr$Mnlist); }
    
    public Object lambda14ppCASE(Object expr, Object col, Object extra) {
      return lambda7ppGeneral(expr, col, extra, Boolean.FALSE, pp$Mnexpr, Boolean.FALSE, pp$Mnexpr$Mnlist);
    }
    
    public Object lambda15ppAND(Object expr, Object col, Object extra) { return lambda8ppCall(expr, col, extra, pp$Mnexpr); }
    




    public Object lambda17ppBEGIN(Object expr, Object col, Object extra)
    {
      return lambda7ppGeneral(expr, col, extra, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, pp$Mnexpr);
    }
    
    public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      switch (selector) {case 2:  return lambda2ppExpr(paramObject1, paramObject2, paramObject3);
      













































































      case 3: 
        return lambda10ppExprList(paramObject1, paramObject2, paramObject3);
      
      case 4: 
        return lambda11ppLAMBDA(paramObject1, paramObject2, paramObject3);
      
      case 5: 
        return lambda12ppIF(paramObject1, paramObject2, paramObject3);
      
      case 6: 
        return lambda13ppCOND(paramObject1, paramObject2, paramObject3);
      
      case 7: 
        return lambda14ppCASE(paramObject1, paramObject2, paramObject3);
      
      case 8: 
        return lambda15ppAND(paramObject1, paramObject2, paramObject3);
      
      case 9: 
        return lambda16ppLET(paramObject1, paramObject2, paramObject3);
      


      case 10: 
        return lambda17ppBEGIN(paramObject1, paramObject2, paramObject3);
      
      case 11: 
        return lambda18ppDO(paramObject1, paramObject2, paramObject3); } return super.apply3(paramModuleMethod, paramObject1, paramObject2, paramObject3); }
    public Object lambda18ppDO(Object expr, Object col, Object extra) { return lambda7ppGeneral(expr, col, extra, Boolean.FALSE, pp$Mnexpr$Mnlist, pp$Mnexpr$Mnlist, pp$Mnexpr);
    }
    
    public frame0() {}
    
    /* Error */
    public Object lambda2ppExpr(Object expr, Object col, Object extra)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 6	gnu/kawa/slib/genwrite$frame:lambda3isReadMacro	(Ljava/lang/Object;)Z
      //   4: ifeq +31 -> 35
      //   7: aload_0
      //   8: aload_1
      //   9: invokestatic 10	gnu/kawa/slib/genwrite$frame:lambda5readMacroBody	(Ljava/lang/Object;)Ljava/lang/Object;
      //   12: aload_0
      //   13: getfield 16	gnu/kawa/slib/genwrite$frame0:staticLink	Lgnu/kawa/slib/genwrite$frame;
      //   16: aload_1
      //   17: invokestatic 19	gnu/kawa/slib/genwrite$frame:lambda6readMacroPrefix	(Ljava/lang/Object;)Ljava/lang/Object;
      //   20: aload_2
      //   21: invokevirtual 23	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   24: aload_3
      //   25: aload_0
      //   26: getfield 27	gnu/kawa/slib/genwrite$frame0:pp$Mnexpr	Lgnu/mapping/Procedure;
      //   29: invokevirtual 31	gnu/kawa/slib/genwrite$frame0:lambda4pr	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   32: goto +467 -> 499
      //   35: aload_1
      //   36: ldc 33
      //   38: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   41: dup
      //   42: astore 5
      //   44: checkcast 33	gnu/lists/Pair
      //   47: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   50: astore 4
      //   52: aload 4
      //   54: invokestatic 59	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
      //   57: ifeq +431 -> 488
      //   60: aload 4
      //   62: astore 6
      //   64: aload 6
      //   66: invokevirtual 65	java/lang/Object:hashCode	()I
      //   69: lookupswitch	default:+329->398, -1335633477:+115->184, -1110092857:+243->312, -1106174827:+193->262, 3211:+293->362, 3357:+275->344, 3555:+161->230, 96727:+207->276, 107035:+129->198, 3046192:+311->380, 3059490:+175->244, 3318127:+147->216, 3526655:+261->330, 93616297:+225->294
      //   184: aload 6
      //   186: getstatic 71	gnu/kawa/slib/genwrite:Lit0	Lgnu/mapping/SimpleSymbol;
      //   189: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   192: ifeq +206 -> 398
      //   195: goto +128 -> 323
      //   198: aload 6
      //   200: getstatic 80	gnu/kawa/slib/genwrite:Lit1	Lgnu/mapping/SimpleSymbol;
      //   203: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   206: ifeq +192 -> 398
      //   209: aload_0
      //   210: getfield 83	gnu/kawa/slib/genwrite$frame0:pp$MnLET	Lgnu/mapping/Procedure;
      //   213: goto +191 -> 404
      //   216: aload 6
      //   218: getstatic 86	gnu/kawa/slib/genwrite:Lit2	Lgnu/mapping/SimpleSymbol;
      //   221: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   224: ifeq +174 -> 398
      //   227: goto +96 -> 323
      //   230: aload 6
      //   232: getstatic 89	gnu/kawa/slib/genwrite:Lit3	Lgnu/mapping/SimpleSymbol;
      //   235: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   238: ifeq +160 -> 398
      //   241: goto +46 -> 287
      //   244: aload 6
      //   246: getstatic 92	gnu/kawa/slib/genwrite:Lit4	Lgnu/mapping/SimpleSymbol;
      //   249: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   252: ifeq +146 -> 398
      //   255: aload_0
      //   256: getfield 95	gnu/kawa/slib/genwrite$frame0:pp$MnCOND	Lgnu/mapping/Procedure;
      //   259: goto +145 -> 404
      //   262: aload 6
      //   264: getstatic 98	gnu/kawa/slib/genwrite:Lit5	Lgnu/mapping/SimpleSymbol;
      //   267: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   270: ifeq +128 -> 398
      //   273: goto +50 -> 323
      //   276: aload 6
      //   278: getstatic 101	gnu/kawa/slib/genwrite:Lit6	Lgnu/mapping/SimpleSymbol;
      //   281: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   284: ifeq +114 -> 398
      //   287: aload_0
      //   288: getfield 104	gnu/kawa/slib/genwrite$frame0:pp$MnAND	Lgnu/mapping/Procedure;
      //   291: goto +113 -> 404
      //   294: aload 6
      //   296: getstatic 107	gnu/kawa/slib/genwrite:Lit7	Lgnu/mapping/SimpleSymbol;
      //   299: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   302: ifeq +96 -> 398
      //   305: aload_0
      //   306: getfield 110	gnu/kawa/slib/genwrite$frame0:pp$MnBEGIN	Lgnu/mapping/Procedure;
      //   309: goto +95 -> 404
      //   312: aload 6
      //   314: getstatic 113	gnu/kawa/slib/genwrite:Lit8	Lgnu/mapping/SimpleSymbol;
      //   317: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   320: ifeq +78 -> 398
      //   323: aload_0
      //   324: getfield 116	gnu/kawa/slib/genwrite$frame0:pp$MnLAMBDA	Lgnu/mapping/Procedure;
      //   327: goto +77 -> 404
      //   330: aload 6
      //   332: getstatic 119	gnu/kawa/slib/genwrite:Lit9	Lgnu/mapping/SimpleSymbol;
      //   335: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   338: ifeq +60 -> 398
      //   341: goto +14 -> 355
      //   344: aload 6
      //   346: getstatic 122	gnu/kawa/slib/genwrite:Lit10	Lgnu/mapping/SimpleSymbol;
      //   349: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   352: ifeq +46 -> 398
      //   355: aload_0
      //   356: getfield 125	gnu/kawa/slib/genwrite$frame0:pp$MnIF	Lgnu/mapping/Procedure;
      //   359: goto +45 -> 404
      //   362: aload 6
      //   364: getstatic 128	gnu/kawa/slib/genwrite:Lit11	Lgnu/mapping/SimpleSymbol;
      //   367: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   370: ifeq +28 -> 398
      //   373: aload_0
      //   374: getfield 131	gnu/kawa/slib/genwrite$frame0:pp$MnDO	Lgnu/mapping/Procedure;
      //   377: goto +27 -> 404
      //   380: aload 6
      //   382: getstatic 134	gnu/kawa/slib/genwrite:Lit12	Lgnu/mapping/SimpleSymbol;
      //   385: invokestatic 77	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   388: ifeq +10 -> 398
      //   391: aload_0
      //   392: getfield 137	gnu/kawa/slib/genwrite$frame0:pp$MnCASE	Lgnu/mapping/Procedure;
      //   395: goto +9 -> 404
      //   398: getstatic 143	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   401: goto +3 -> 404
      //   404: astore 5
      //   406: aload 5
      //   408: invokestatic 148	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   411: ifeq +17 -> 428
      //   414: getstatic 154	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   417: aload 5
      //   419: aload_1
      //   420: aload_2
      //   421: aload_3
      //   422: invokevirtual 159	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   425: goto +74 -> 499
      //   428: aload 4
      //   430: ldc -95
      //   432: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   435: dup
      //   436: astore 6
      //   438: checkcast 161	gnu/mapping/Symbol
      //   441: invokestatic 167	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
      //   444: invokestatic 173	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   447: iconst_5
      //   448: if_icmple +26 -> 474
      //   451: aload_0
      //   452: aload_1
      //   453: aload_2
      //   454: aload_3
      //   455: getstatic 143	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   458: getstatic 143	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   461: getstatic 143	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   464: aload_0
      //   465: getfield 27	gnu/kawa/slib/genwrite$frame0:pp$Mnexpr	Lgnu/mapping/Procedure;
      //   468: invokevirtual 177	gnu/kawa/slib/genwrite$frame0:lambda7ppGeneral	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   471: goto +28 -> 499
      //   474: aload_0
      //   475: aload_1
      //   476: aload_2
      //   477: aload_3
      //   478: aload_0
      //   479: getfield 27	gnu/kawa/slib/genwrite$frame0:pp$Mnexpr	Lgnu/mapping/Procedure;
      //   482: invokevirtual 181	gnu/kawa/slib/genwrite$frame0:lambda8ppCall	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   485: goto +14 -> 499
      //   488: aload_0
      //   489: aload_1
      //   490: aload_2
      //   491: aload_3
      //   492: aload_0
      //   493: getfield 27	gnu/kawa/slib/genwrite$frame0:pp$Mnexpr	Lgnu/mapping/Procedure;
      //   496: invokevirtual 184	gnu/kawa/slib/genwrite$frame0:lambda9ppList	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   499: areturn
      //   500: new 43	gnu/mapping/WrongType
      //   503: dup_x1
      //   504: swap
      //   505: ldc 45
      //   507: iconst_1
      //   508: aload 5
      //   510: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   513: athrow
      //   514: new 43	gnu/mapping/WrongType
      //   517: dup_x1
      //   518: swap
      //   519: ldc -93
      //   521: iconst_1
      //   522: aload 6
      //   524: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   527: athrow
      // Line number table:
      //   Java source line #83	-> byte code offset #0
      //   Java source line #84	-> byte code offset #0
      //   Java source line #85	-> byte code offset #7
      //   Java source line #86	-> byte code offset #12
      //   Java source line #87	-> byte code offset #24
      //   Java source line #88	-> byte code offset #25
      //   Java source line #89	-> byte code offset #35
      //   Java source line #90	-> byte code offset #52
      //   Java source line #91	-> byte code offset #60
      //   Java source line #200	-> byte code offset #62
      //   Java source line #201	-> byte code offset #64
      //   Java source line #92	-> byte code offset #406
      //   Java source line #93	-> byte code offset #414
      //   Java source line #94	-> byte code offset #428
      //   Java source line #96	-> byte code offset #451
      //   Java source line #97	-> byte code offset #474
      //   Java source line #98	-> byte code offset #488
      //   Java source line #89	-> byte code offset #500
      //   Java source line #94	-> byte code offset #514
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	500	0	this	frame0
      //   0	499	1	expr	Object
      //   0	499	2	col	Object
      //   0	499	3	extra	Object
      //   52	447	4	head	Object
      //   406	79	5	proc	Object
      //   64	340	6	head	Object
      // Exception table:
      //   from	to	target	type
      //   44	47	500	java/lang/ClassCastException
      //   438	441	514	java/lang/ClassCastException
    }
    
    /* Error */
    public Object lambda7ppGeneral(Object expr, Object col, Object extra, Object named$Qu, Object pp$Mn1, Object pp$Mn2, gnu.mapping.Procedure pp$Mn3)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 33
      //   3: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   6: dup
      //   7: astore 9
      //   9: checkcast 33	gnu/lists/Pair
      //   12: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   15: astore 8
      //   17: aload_1
      //   18: ldc 33
      //   20: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   23: dup
      //   24: astore 10
      //   26: checkcast 33	gnu/lists/Pair
      //   29: invokestatic 191	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   32: astore 9
      //   34: aload_0
      //   35: getfield 16	gnu/kawa/slib/genwrite$frame0:staticLink	Lgnu/kawa/slib/genwrite$frame;
      //   38: aload 8
      //   40: aload_0
      //   41: getfield 16	gnu/kawa/slib/genwrite$frame0:staticLink	Lgnu/kawa/slib/genwrite$frame;
      //   44: ldc_w 308
      //   47: aload_2
      //   48: invokevirtual 23	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   51: invokevirtual 306	gnu/kawa/slib/genwrite$frame:lambda21wr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   54: astore 10
      //   56: aload 4
      //   58: invokestatic 148	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   61: ifeq +347 -> 408
      //   64: aload 9
      //   66: invokestatic 194	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   69: ifeq +339 -> 408
      //   72: aload 9
      //   74: ldc 33
      //   76: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   79: dup
      //   80: astore 12
      //   82: checkcast 33	gnu/lists/Pair
      //   85: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   88: astore 11
      //   90: aload 9
      //   92: ldc 33
      //   94: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   97: dup
      //   98: astore 13
      //   100: checkcast 33	gnu/lists/Pair
      //   103: invokestatic 191	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   106: astore 12
      //   108: aload_0
      //   109: getfield 16	gnu/kawa/slib/genwrite$frame0:staticLink	Lgnu/kawa/slib/genwrite$frame;
      //   112: aload 11
      //   114: aload_0
      //   115: getfield 16	gnu/kawa/slib/genwrite$frame0:staticLink	Lgnu/kawa/slib/genwrite$frame;
      //   118: ldc_w 324
      //   121: aload 10
      //   123: invokevirtual 23	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   126: invokevirtual 306	gnu/kawa/slib/genwrite$frame:lambda21wr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   129: astore 13
      //   131: aload 12
      //   133: iconst_1
      //   134: aload_2
      //   135: getstatic 327	gnu/kawa/slib/genwrite:Lit18	Lgnu/math/IntNum;
      //   138: invokestatic 216	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   141: aload 13
      //   143: iconst_1
      //   144: aload 13
      //   146: getstatic 268	gnu/kawa/slib/genwrite:Lit16	Lgnu/math/IntNum;
      //   149: invokestatic 216	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   152: astore 17
      //   154: astore 16
      //   156: astore 15
      //   158: astore 14
      //   160: aload 5
      //   162: invokestatic 148	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   165: ifeq +98 -> 263
      //   168: aload 14
      //   170: invokestatic 194	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   173: ifeq +90 -> 263
      //   176: aload 14
      //   178: ldc 33
      //   180: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   183: dup
      //   184: astore 19
      //   186: checkcast 33	gnu/lists/Pair
      //   189: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   192: astore 18
      //   194: aload 14
      //   196: ldc 33
      //   198: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   201: dup
      //   202: astore 20
      //   204: checkcast 33	gnu/lists/Pair
      //   207: invokestatic 191	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   210: astore 19
      //   212: aload 19
      //   214: invokestatic 315	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   217: ifeq +14 -> 231
      //   220: iconst_1
      //   221: aload_3
      //   222: getstatic 268	gnu/kawa/slib/genwrite:Lit16	Lgnu/math/IntNum;
      //   225: invokestatic 216	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   228: goto +6 -> 234
      //   231: getstatic 210	gnu/kawa/slib/genwrite:Lit13	Lgnu/math/IntNum;
      //   234: astore 20
      //   236: aload 19
      //   238: aload 15
      //   240: aload_0
      //   241: aload 18
      //   243: aload_0
      //   244: aload 17
      //   246: aload 16
      //   248: invokevirtual 318	gnu/kawa/slib/genwrite$frame0:lambda19indent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   251: aload 20
      //   253: aload 5
      //   255: invokevirtual 31	gnu/kawa/slib/genwrite$frame0:lambda4pr	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   258: aload 17
      //   260: goto +11 -> 271
      //   263: aload 14
      //   265: aload 15
      //   267: aload 16
      //   269: aload 17
      //   271: astore 21
      //   273: astore 20
      //   275: astore 19
      //   277: astore 18
      //   279: aload 6
      //   281: invokestatic 148	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   284: ifeq +96 -> 380
      //   287: aload 18
      //   289: invokestatic 194	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   292: ifeq +88 -> 380
      //   295: aload 18
      //   297: ldc 33
      //   299: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   302: dup
      //   303: astore 23
      //   305: checkcast 33	gnu/lists/Pair
      //   308: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   311: astore 22
      //   313: aload 18
      //   315: ldc 33
      //   317: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   320: dup
      //   321: astore 24
      //   323: checkcast 33	gnu/lists/Pair
      //   326: invokestatic 191	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   329: astore 23
      //   331: aload 23
      //   333: invokestatic 315	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   336: ifeq +14 -> 350
      //   339: iconst_1
      //   340: aload_3
      //   341: getstatic 268	gnu/kawa/slib/genwrite:Lit16	Lgnu/math/IntNum;
      //   344: invokestatic 216	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   347: goto +6 -> 353
      //   350: getstatic 210	gnu/kawa/slib/genwrite:Lit13	Lgnu/math/IntNum;
      //   353: astore 24
      //   355: aload 23
      //   357: aload 19
      //   359: aload_0
      //   360: aload 22
      //   362: aload_0
      //   363: aload 21
      //   365: aload 20
      //   367: invokevirtual 318	gnu/kawa/slib/genwrite$frame0:lambda19indent	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   370: aload 24
      //   372: aload 6
      //   374: invokevirtual 31	gnu/kawa/slib/genwrite$frame0:lambda4pr	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   377: goto +9 -> 386
      //   380: aload 18
      //   382: aload 19
      //   384: aload 20
      //   386: astore 24
      //   388: astore 23
      //   390: astore 22
      //   392: aload_0
      //   393: aload 22
      //   395: aload 24
      //   397: aload 23
      //   399: aload_3
      //   400: aload 7
      //   402: invokevirtual 312	gnu/kawa/slib/genwrite$frame0:lambda22ppDown	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   405: goto +27 -> 432
      //   408: aload 9
      //   410: iconst_1
      //   411: aload_2
      //   412: getstatic 327	gnu/kawa/slib/genwrite:Lit18	Lgnu/math/IntNum;
      //   415: invokestatic 216	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   418: aload 10
      //   420: iconst_1
      //   421: aload 10
      //   423: getstatic 268	gnu/kawa/slib/genwrite:Lit16	Lgnu/math/IntNum;
      //   426: invokestatic 216	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   429: goto -277 -> 152
      //   432: areturn
      //   433: new 43	gnu/mapping/WrongType
      //   436: dup_x1
      //   437: swap
      //   438: ldc 45
      //   440: iconst_1
      //   441: aload 9
      //   443: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   446: athrow
      //   447: new 43	gnu/mapping/WrongType
      //   450: dup_x1
      //   451: swap
      //   452: ldc -67
      //   454: iconst_1
      //   455: aload 10
      //   457: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   460: athrow
      //   461: new 43	gnu/mapping/WrongType
      //   464: dup_x1
      //   465: swap
      //   466: ldc 45
      //   468: iconst_1
      //   469: aload 12
      //   471: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   474: athrow
      //   475: new 43	gnu/mapping/WrongType
      //   478: dup_x1
      //   479: swap
      //   480: ldc -67
      //   482: iconst_1
      //   483: aload 13
      //   485: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   488: athrow
      //   489: new 43	gnu/mapping/WrongType
      //   492: dup_x1
      //   493: swap
      //   494: ldc 45
      //   496: iconst_1
      //   497: aload 19
      //   499: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   502: athrow
      //   503: new 43	gnu/mapping/WrongType
      //   506: dup_x1
      //   507: swap
      //   508: ldc -67
      //   510: iconst_1
      //   511: aload 20
      //   513: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   516: athrow
      //   517: new 43	gnu/mapping/WrongType
      //   520: dup_x1
      //   521: swap
      //   522: ldc 45
      //   524: iconst_1
      //   525: aload 23
      //   527: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   530: athrow
      //   531: new 43	gnu/mapping/WrongType
      //   534: dup_x1
      //   535: swap
      //   536: ldc -67
      //   538: iconst_1
      //   539: aload 24
      //   541: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   544: athrow
      // Line number table:
      //   Java source line #132	-> byte code offset #0
      //   Java source line #134	-> byte code offset #0
      //   Java source line #142	-> byte code offset #0
      //   Java source line #150	-> byte code offset #0
      //   Java source line #134	-> byte code offset #0
      //   Java source line #153	-> byte code offset #0
      //   Java source line #154	-> byte code offset #17
      //   Java source line #153	-> byte code offset #34
      //   Java source line #155	-> byte code offset #34
      //   Java source line #156	-> byte code offset #56
      //   Java source line #157	-> byte code offset #72
      //   Java source line #158	-> byte code offset #90
      //   Java source line #157	-> byte code offset #108
      //   Java source line #159	-> byte code offset #108
      //   Java source line #160	-> byte code offset #131
      //   Java source line #134	-> byte code offset #152
      //   Java source line #135	-> byte code offset #160
      //   Java source line #136	-> byte code offset #176
      //   Java source line #137	-> byte code offset #194
      //   Java source line #136	-> byte code offset #212
      //   Java source line #138	-> byte code offset #212
      //   Java source line #139	-> byte code offset #236
      //   Java source line #140	-> byte code offset #263
      //   Java source line #142	-> byte code offset #271
      //   Java source line #143	-> byte code offset #279
      //   Java source line #144	-> byte code offset #295
      //   Java source line #145	-> byte code offset #313
      //   Java source line #144	-> byte code offset #331
      //   Java source line #146	-> byte code offset #331
      //   Java source line #147	-> byte code offset #355
      //   Java source line #148	-> byte code offset #380
      //   Java source line #150	-> byte code offset #386
      //   Java source line #151	-> byte code offset #392
      //   Java source line #161	-> byte code offset #408
      //   Java source line #153	-> byte code offset #433
      //   Java source line #154	-> byte code offset #447
      //   Java source line #157	-> byte code offset #461
      //   Java source line #158	-> byte code offset #475
      //   Java source line #136	-> byte code offset #489
      //   Java source line #137	-> byte code offset #503
      //   Java source line #144	-> byte code offset #517
      //   Java source line #145	-> byte code offset #531
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	433	0	this	frame0
      //   0	432	1	expr	Object
      //   0	432	2	col	Object
      //   0	432	3	extra	Object
      //   0	432	4	named$Qu	Object
      //   0	432	5	pp$Mn1	Object
      //   0	432	6	pp$Mn2	Object
      //   0	432	7	pp$Mn3	gnu.mapping.Procedure
      //   15	24	8	head	Object
      //   7	1	9	localObject1	Object
      //   32	410	9	rest	Object
      //   24	1	10	localObject2	Object
      //   54	402	10	col$St	Object
      //   88	25	11	name	Object
      //   80	1	12	localObject3	Object
      //   106	364	12	rest	Object
      //   98	1	13	localObject4	Object
      //   129	355	13	col$St$St	Object
      //   158	106	14	rest	Object
      //   156	1	15	localObject5	Object
      //   160	106	15	col1	Object
      //   154	1	16	localObject6	Object
      //   160	108	16	col2	Object
      //   152	1	17	localObject7	Object
      //   160	110	17	col3	Object
      //   192	50	18	val1	Object
      //   277	104	18	rest	Object
      //   184	1	19	localObject8	Object
      //   210	66	19	rest	Object
      //   279	219	19	col1	Object
      //   202	1	20	localObject9	Object
      //   234	40	20	extra	Object
      //   279	233	20	col2	Object
      //   271	1	21	localObject10	Object
      //   279	85	21	col3	Object
      //   311	50	22	val1	Object
      //   390	4	22	rest	Object
      //   303	1	23	localObject11	Object
      //   329	60	23	rest	Object
      //   392	134	23	col1	Object
      //   321	1	24	localObject12	Object
      //   353	34	24	extra	Object
      //   392	148	24	col2	Object
      //   433	1	43	localClassCastException1	ClassCastException
      //   447	1	44	localClassCastException2	ClassCastException
      //   461	1	45	localClassCastException3	ClassCastException
      //   475	1	46	localClassCastException4	ClassCastException
      //   489	1	47	localClassCastException5	ClassCastException
      //   503	1	48	localClassCastException6	ClassCastException
      //   517	1	49	localClassCastException7	ClassCastException
      //   531	1	50	localClassCastException8	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   9	12	433	java/lang/ClassCastException
      //   26	29	447	java/lang/ClassCastException
      //   82	85	461	java/lang/ClassCastException
      //   100	103	475	java/lang/ClassCastException
      //   186	189	489	java/lang/ClassCastException
      //   204	207	503	java/lang/ClassCastException
      //   305	308	517	java/lang/ClassCastException
      //   323	326	531	java/lang/ClassCastException
    }
    
    /* Error */
    public Object lambda8ppCall(Object expr, Object col, Object extra, gnu.mapping.Procedure pp$Mnitem)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 16	gnu/kawa/slib/genwrite$frame0:staticLink	Lgnu/kawa/slib/genwrite$frame;
      //   4: aload_1
      //   5: ldc 33
      //   7: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   10: dup
      //   11: astore 6
      //   13: checkcast 33	gnu/lists/Pair
      //   16: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   19: aload_0
      //   20: getfield 16	gnu/kawa/slib/genwrite$frame0:staticLink	Lgnu/kawa/slib/genwrite$frame;
      //   23: ldc_w 308
      //   26: aload_2
      //   27: invokevirtual 23	gnu/kawa/slib/genwrite$frame:lambda1out	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   30: invokevirtual 306	gnu/kawa/slib/genwrite$frame:lambda21wr	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   33: astore 5
      //   35: aload_2
      //   36: invokestatic 148	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   39: ifeq +39 -> 78
      //   42: aload_0
      //   43: aload_1
      //   44: ldc 33
      //   46: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   49: dup
      //   50: astore 6
      //   52: checkcast 33	gnu/lists/Pair
      //   55: invokestatic 191	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   58: aload 5
      //   60: iconst_1
      //   61: aload 5
      //   63: getstatic 268	gnu/kawa/slib/genwrite:Lit16	Lgnu/math/IntNum;
      //   66: invokestatic 216	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   69: aload_3
      //   70: aload 4
      //   72: invokevirtual 312	gnu/kawa/slib/genwrite$frame0:lambda22ppDown	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   75: goto +6 -> 81
      //   78: getstatic 143	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   81: areturn
      //   82: new 43	gnu/mapping/WrongType
      //   85: dup_x1
      //   86: swap
      //   87: ldc 45
      //   89: iconst_1
      //   90: aload 6
      //   92: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   95: athrow
      //   96: new 43	gnu/mapping/WrongType
      //   99: dup_x1
      //   100: swap
      //   101: ldc -67
      //   103: iconst_1
      //   104: aload 6
      //   106: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   109: athrow
      // Line number table:
      //   Java source line #103	-> byte code offset #0
      //   Java source line #104	-> byte code offset #0
      //   Java source line #105	-> byte code offset #35
      //   Java source line #106	-> byte code offset #42
      //   Java source line #104	-> byte code offset #82
      //   Java source line #106	-> byte code offset #96
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	frame0
      //   0	81	1	expr	Object
      //   0	81	2	col	Object
      //   0	81	3	extra	Object
      //   0	81	4	pp$Mnitem	gnu.mapping.Procedure
      //   33	29	5	col$St	Object
      //   11	94	6	localObject1	Object
      //   82	1	7	localClassCastException1	ClassCastException
      //   96	1	8	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   13	16	82	java/lang/ClassCastException
      //   52	55	96	java/lang/ClassCastException
    }
    
    /* Error */
    public Object lambda16ppLET(Object expr, Object col, Object extra)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 33
      //   3: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   6: dup
      //   7: astore 5
      //   9: checkcast 33	gnu/lists/Pair
      //   12: invokestatic 191	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   15: astore 4
      //   17: aload 4
      //   19: invokestatic 194	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   22: ifeq +25 -> 47
      //   25: aload 4
      //   27: ldc 33
      //   29: invokestatic 39	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   32: dup
      //   33: astore 6
      //   35: checkcast 33	gnu/lists/Pair
      //   38: invokestatic 54	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   41: invokestatic 59	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
      //   44: goto +4 -> 48
      //   47: iconst_0
      //   48: istore 5
      //   50: aload_0
      //   51: aload_1
      //   52: aload_2
      //   53: aload_3
      //   54: iload 5
      //   56: ifeq +9 -> 65
      //   59: getstatic 197	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   62: goto +6 -> 68
      //   65: getstatic 143	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   68: aload_0
      //   69: getfield 187	gnu/kawa/slib/genwrite$frame0:pp$Mnexpr$Mnlist	Lgnu/mapping/Procedure;
      //   72: getstatic 143	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   75: aload_0
      //   76: getfield 27	gnu/kawa/slib/genwrite$frame0:pp$Mnexpr	Lgnu/mapping/Procedure;
      //   79: invokevirtual 177	gnu/kawa/slib/genwrite$frame0:lambda7ppGeneral	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   82: areturn
      //   83: new 43	gnu/mapping/WrongType
      //   86: dup_x1
      //   87: swap
      //   88: ldc -67
      //   90: iconst_1
      //   91: aload 5
      //   93: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   96: athrow
      //   97: new 43	gnu/mapping/WrongType
      //   100: dup_x1
      //   101: swap
      //   102: ldc 45
      //   104: iconst_1
      //   105: aload 6
      //   107: invokespecial 49	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   110: athrow
      // Line number table:
      //   Java source line #181	-> byte code offset #0
      //   Java source line #182	-> byte code offset #0
      //   Java source line #183	-> byte code offset #17
      //   Java source line #184	-> byte code offset #50
      //   Java source line #182	-> byte code offset #83
      //   Java source line #183	-> byte code offset #97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	83	0	this	frame0
      //   0	82	1	expr	Object
      //   0	82	2	col	Object
      //   0	82	3	extra	Object
      //   15	11	4	rest	Object
      //   7	1	5	localObject1	Object
      //   48	44	5	named$Qu	boolean
      //   33	73	6	localObject2	Object
      //   83	1	8	localClassCastException1	ClassCastException
      //   97	1	9	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   9	12	83	java/lang/ClassCastException
      //   35	38	97	java/lang/ClassCastException
    }
    
    public void apply(gnu.mapping.CallContext paramCallContext)
    {
      ModuleMethod.applyError();
    }
  }
  
  public static Object genericWrite(Object obj, Object isDisplay, Object width, Object output)
  {
    frame $heapFrame = new frame();display$Qu = isDisplay;width = width;output = output;
    












































    Object obj = 
    

































































































































































      obj; void tmp56_53 = new frame0();5653staticLink = $heapFrame;frame0 $heapFrame = tmp56_53;pp$Mnexpr = pp$Mnexpr;pp$Mnexpr$Mnlist = pp$Mnexpr$Mnlist;pp$MnLAMBDA = pp$MnLAMBDA;pp$MnIF = pp$MnIF;pp$MnCOND = pp$MnCOND;pp$MnCASE = pp$MnCASE;pp$MnAND = pp$MnAND;pp$MnLET = pp$MnLET;pp$MnBEGIN = pp$MnBEGIN;pp$MnDO = pp$MnDO;
    return gnu.expr.KawaConvert.isTrue(width) ? $heapFrame.lambda1out(kawa.lib.strings.makeString(1, 10), $heapFrame.lambda4pr(obj, Lit13, Lit13, pp$Mnexpr)) : $heapFrame.lambda21wr(obj, Lit13);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) {
    if (selector == 13) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { if (selector == 13) return reverseStringAppend(paramObject); return super.apply1(paramModuleMethod, paramObject);
  }
  
  static final gnu.math.IntNum Lit17;
  static final gnu.math.IntNum Lit18;
  static final gnu.mapping.SimpleSymbol Lit19;
  static final gnu.mapping.SimpleSymbol Lit20;
  static final gnu.mapping.SimpleSymbol Lit21;
  static final gnu.mapping.SimpleSymbol Lit22;
  static final gnu.mapping.SimpleSymbol Lit23;
  static final gnu.mapping.SimpleSymbol Lit24;
  static final gnu.mapping.SimpleSymbol Lit25;
  
  public static Object reverseStringAppend(Object l)
  {
    return lambda23revStringAppend(l, Lit13);
  }
  
  static final gnu.mapping.SimpleSymbol Lit26;
  static final gnu.mapping.SimpleSymbol Lit27;
  static final gnu.mapping.SimpleSymbol Lit28;
  static final gnu.mapping.SimpleSymbol Lit29;
  static final gnu.mapping.SimpleSymbol Lit30;
  static final gnu.mapping.SimpleSymbol Lit31;
  static final gnu.mapping.SimpleSymbol Lit32;
  public static genwrite $instance;
  static final gnu.mapping.SimpleSymbol Lit33;
  static final gnu.mapping.SimpleSymbol Lit34 = gnu.mapping.Symbol.valueOf("reverse-string-append");
  /* Error */
  public static Object lambda23revStringAppend(Object l, Object i)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 101	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
    //   4: ifeq +188 -> 192
    //   7: aload_0
    //   8: ldc 103
    //   10: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   13: dup
    //   14: astore_3
    //   15: checkcast 103	gnu/lists/Pair
    //   18: invokestatic 121	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   21: astore_2
    //   22: aload_2
    //   23: ldc 123
    //   25: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   28: dup
    //   29: astore 4
    //   31: checkcast 123	java/lang/CharSequence
    //   34: invokestatic 129	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   37: istore_3
    //   38: aload_0
    //   39: ldc 103
    //   41: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: astore 5
    //   47: checkcast 103	gnu/lists/Pair
    //   50: invokestatic 133	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   53: iconst_1
    //   54: aload_1
    //   55: iload_3
    //   56: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: invokestatic 96	gnu/kawa/slib/genwrite:lambda23revStringAppend	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: astore 4
    //   67: getstatic 82	gnu/kawa/slib/genwrite:Lit13	Lgnu/math/IntNum;
    //   70: iconst_m1
    //   71: iconst_m1
    //   72: aload 4
    //   74: ldc 123
    //   76: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   79: dup
    //   80: astore 5
    //   82: checkcast 123	java/lang/CharSequence
    //   85: invokestatic 129	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   88: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aload_1
    //   92: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   95: iload_3
    //   96: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore 6
    //   104: astore 5
    //   106: aload 5
    //   108: iload_3
    //   109: i2l
    //   110: invokestatic 151	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
    //   113: ifge +74 -> 187
    //   116: aload 4
    //   118: ldc -103
    //   120: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   123: dup
    //   124: astore 7
    //   126: checkcast 153	gnu/lists/CharSeq
    //   129: aload 6
    //   131: invokestatic 158	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: dup
    //   135: astore 7
    //   137: checkcast 160	java/lang/Number
    //   140: invokevirtual 164	java/lang/Number:intValue	()I
    //   143: aload_2
    //   144: ldc 123
    //   146: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   149: dup
    //   150: astore 7
    //   152: checkcast 123	java/lang/CharSequence
    //   155: aload 5
    //   157: dup
    //   158: astore 7
    //   160: invokevirtual 164	java/lang/Number:intValue	()I
    //   163: invokestatic 170	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   166: invokestatic 174	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   169: aload 5
    //   171: iconst_1
    //   172: invokestatic 178	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   175: iconst_1
    //   176: aload 6
    //   178: getstatic 181	gnu/kawa/slib/genwrite:Lit16	Lgnu/math/IntNum;
    //   181: invokestatic 145	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: goto -82 -> 102
    //   187: aload 4
    //   189: goto +18 -> 207
    //   192: aload_1
    //   193: invokestatic 158	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: dup
    //   197: astore_2
    //   198: checkcast 160	java/lang/Number
    //   201: invokevirtual 164	java/lang/Number:intValue	()I
    //   204: invokestatic 186	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   207: areturn
    //   208: new 113	gnu/mapping/WrongType
    //   211: dup_x1
    //   212: swap
    //   213: ldc 115
    //   215: iconst_1
    //   216: aload_3
    //   217: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: new 113	gnu/mapping/WrongType
    //   224: dup_x1
    //   225: swap
    //   226: ldc 125
    //   228: iconst_1
    //   229: aload 4
    //   231: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   234: athrow
    //   235: new 113	gnu/mapping/WrongType
    //   238: dup_x1
    //   239: swap
    //   240: ldc -125
    //   242: iconst_1
    //   243: aload 5
    //   245: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   248: athrow
    //   249: new 113	gnu/mapping/WrongType
    //   252: dup_x1
    //   253: swap
    //   254: ldc 125
    //   256: iconst_1
    //   257: aload 5
    //   259: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   262: athrow
    //   263: new 113	gnu/mapping/WrongType
    //   266: dup_x1
    //   267: swap
    //   268: ldc -101
    //   270: iconst_1
    //   271: aload 7
    //   273: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   276: athrow
    //   277: new 113	gnu/mapping/WrongType
    //   280: dup_x1
    //   281: swap
    //   282: ldc -101
    //   284: iconst_2
    //   285: aload 7
    //   287: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   290: athrow
    //   291: new 113	gnu/mapping/WrongType
    //   294: dup_x1
    //   295: swap
    //   296: ldc -90
    //   298: iconst_1
    //   299: aload 7
    //   301: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   304: athrow
    //   305: new 113	gnu/mapping/WrongType
    //   308: dup_x1
    //   309: swap
    //   310: ldc -90
    //   312: iconst_2
    //   313: aload 7
    //   315: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   318: athrow
    //   319: new 113	gnu/mapping/WrongType
    //   322: dup_x1
    //   323: swap
    //   324: ldc -73
    //   326: iconst_1
    //   327: aload_2
    //   328: invokespecial 118	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   331: athrow
    // Line number table:
    //   Java source line #222	-> byte code offset #0
    //   Java source line #223	-> byte code offset #0
    //   Java source line #224	-> byte code offset #7
    //   Java source line #225	-> byte code offset #22
    //   Java source line #224	-> byte code offset #38
    //   Java source line #226	-> byte code offset #38
    //   Java source line #227	-> byte code offset #67
    //   Java source line #228	-> byte code offset #106
    //   Java source line #230	-> byte code offset #116
    //   Java source line #231	-> byte code offset #169
    //   Java source line #228	-> byte code offset #187
    //   Java source line #233	-> byte code offset #192
    //   Java source line #224	-> byte code offset #208
    //   Java source line #225	-> byte code offset #221
    //   Java source line #226	-> byte code offset #235
    //   Java source line #227	-> byte code offset #249
    //   Java source line #230	-> byte code offset #263
    //   Java source line #233	-> byte code offset #319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	l	Object
    //   0	207	1	i	Object
    //   21	307	2	str	Object
    //   14	1	3	localObject1	Object
    //   37	180	3	len	int
    //   29	1	4	localObject2	Object
    //   65	165	4	result	Object
    //   45	36	5	localObject3	Object
    //   104	154	5	j	gnu.math.IntNum
    //   102	1	6	localObject4	Object
    //   106	71	6	k	Object
    //   124	190	7	localObject5	Object
    //   208	1	12	localClassCastException1	ClassCastException
    //   221	1	13	localClassCastException2	ClassCastException
    //   235	1	14	localClassCastException3	ClassCastException
    //   249	1	15	localClassCastException4	ClassCastException
    //   263	1	16	localClassCastException5	ClassCastException
    //   277	1	17	localClassCastException6	ClassCastException
    //   291	1	18	localClassCastException7	ClassCastException
    //   305	1	19	localClassCastException8	ClassCastException
    //   319	1	20	localClassCastException9	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	18	208	java/lang/ClassCastException
    //   31	34	221	java/lang/ClassCastException
    //   47	50	235	java/lang/ClassCastException
    //   82	85	249	java/lang/ClassCastException
    //   126	129	263	java/lang/ClassCastException
    //   137	143	277	java/lang/ClassCastException
    //   152	155	291	java/lang/ClassCastException
    //   160	163	305	java/lang/ClassCastException
    //   198	204	319	java/lang/ClassCastException
  }
  
  static
  {
    Lit33 = gnu.mapping.Symbol.valueOf("generic-write");
    Lit32 = gnu.mapping.Symbol.valueOf("unquote-splicing");
    Lit31 = gnu.mapping.Symbol.valueOf("quote");
    Lit30 = gnu.mapping.Symbol.valueOf("quasiquote");
    Lit29 = gnu.mapping.Symbol.valueOf("unquote");
    Lit28 = gnu.mapping.Symbol.valueOf("pp-DO");
    Lit27 = gnu.mapping.Symbol.valueOf("pp-BEGIN");
    Lit26 = gnu.mapping.Symbol.valueOf("pp-LET");
    Lit25 = gnu.mapping.Symbol.valueOf("pp-AND");
    Lit24 = gnu.mapping.Symbol.valueOf("pp-CASE");
    Lit23 = gnu.mapping.Symbol.valueOf("pp-COND");
    Lit22 = gnu.mapping.Symbol.valueOf("pp-IF");
    Lit21 = gnu.mapping.Symbol.valueOf("pp-LAMBDA");
    Lit20 = gnu.mapping.Symbol.valueOf("pp-expr-list");
    Lit19 = gnu.mapping.Symbol.valueOf("pp-expr");
    Lit18 = gnu.math.IntNum.valueOf(2);
    Lit17 = gnu.math.IntNum.valueOf(50);
    Lit16 = gnu.math.IntNum.valueOf(1);
    Lit15 = gnu.math.IntNum.valueOf(8);
    Lit14 = gnu.math.IntNum.valueOf(7);
    Lit13 = gnu.math.IntNum.valueOf(0);
    Lit12 = gnu.mapping.Symbol.valueOf("case");
    Lit11 = gnu.mapping.Symbol.valueOf("do");
    Lit10 = gnu.mapping.Symbol.valueOf("if");
    Lit9 = gnu.mapping.Symbol.valueOf("set!");
    Lit8 = gnu.mapping.Symbol.valueOf("lambda");
    Lit7 = gnu.mapping.Symbol.valueOf("begin");
    Lit6 = gnu.mapping.Symbol.valueOf("and");
    Lit5 = gnu.mapping.Symbol.valueOf("letrec");
    Lit4 = gnu.mapping.Symbol.valueOf("cond");
    Lit3 = gnu.mapping.Symbol.valueOf("or");
    Lit2 = gnu.mapping.Symbol.valueOf("let*");
    Lit1 = gnu.mapping.Symbol.valueOf("let");
    Lit0 = gnu.mapping.Symbol.valueOf("define");
    $instance = new genwrite();
    genwrite localGenwrite = $instance;
    generic$Mnwrite = new ModuleMethod(localGenwrite, 12, Lit33, 16388);
    reverse$Mnstring$Mnappend = new ModuleMethod(localGenwrite, 13, Lit34, 4097);
    $runBody$();
  }
  
  public genwrite()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
}
