package gnu.kawa.slib;

import gnu.expr.ModuleMethod;
import gnu.text.Char;

public class printf extends gnu.expr.ModuleBody
{
  static boolean stdio$Clhex$Mnupper$Mncase$Qu;
  static final ModuleMethod stdio$Cliprintf;
  public static final ModuleMethod fprintf;
  public static final ModuleMethod printf;
  public static final ModuleMethod sprintf;
  static final gnu.math.IntNum Lit0;
  static final gnu.math.IntNum Lit1;
  static final Char Lit2;
  static final Char Lit3;
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    


    stdio$Clhex$Mnupper$Mncase$Qu = kawa.lib.strings.isString$Eq("-F", kawa.lib.numbers.number$To$String(Lit0, 16), new CharSequence[0]);
  }
  
  public class frame4
    extends gnu.expr.ModuleBody
  {
    Object proc;
    Object str;
    int n;
    final ModuleMethod lambda$Fn8;
    
    public frame4()
    {
      void tmp19_16 = new ModuleMethod(this, 19, null, 16388);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:106");
      lambda$Fn8 = tmp19_16;
    }
    
    /* Error */
    public Object lambda17real(Object n, Object i, gnu.mapping.Procedure cont)
    {
      // Byte code:
      //   0: new 211	gnu/kawa/slib/printf$frame7
      //   3: dup
      //   4: invokespecial 212	gnu/kawa/slib/printf$frame7:<init>	()V
      //   7: dup
      //   8: aload_0
      //   9: putfield 213	gnu/kawa/slib/printf$frame7:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   12: astore 4
      //   14: aload 4
      //   16: aload_3
      //   17: putfield 217	gnu/kawa/slib/printf$frame7:cont	Lgnu/mapping/Procedure;
      //   20: aload_2
      //   21: aload 4
      //   23: getfield 220	gnu/kawa/slib/printf$frame7:lambda$Fn12	Lgnu/expr/ModuleMethod;
      //   26: astore 6
      //   28: astore 5
      //   30: aload 5
      //   32: aload_1
      //   33: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   36: checkcast 78	java/lang/Number
      //   39: invokevirtual 82	java/lang/Number:intValue	()I
      //   42: iconst_1
      //   43: isub
      //   44: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   47: invokestatic 172	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   50: ifeq +171 -> 221
      //   53: bipush 35
      //   55: aload_0
      //   56: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   59: ldc 58
      //   61: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   64: dup
      //   65: astore 7
      //   67: checkcast 58	java/lang/CharSequence
      //   70: aload 5
      //   72: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   75: dup
      //   76: astore 7
      //   78: checkcast 78	java/lang/Number
      //   81: invokevirtual 82	java/lang/Number:intValue	()I
      //   84: invokestatic 88	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   87: if_icmpne +134 -> 221
      //   90: aload_0
      //   91: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   94: ldc 58
      //   96: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   99: dup
      //   100: astore 8
      //   102: checkcast 58	java/lang/CharSequence
      //   105: iconst_1
      //   106: aload 5
      //   108: getstatic 176	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   111: invokestatic 182	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   114: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   117: dup
      //   118: astore 8
      //   120: checkcast 78	java/lang/Number
      //   123: invokevirtual 82	java/lang/Number:intValue	()I
      //   126: invokestatic 88	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   129: istore 7
      //   131: iload 7
      //   133: lookupswitch	default:+70->203, 46:+43->176, 100:+56->189, 101:+56->189, 105:+56->189
      //   176: getstatic 44	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   179: aload 6
      //   181: aload 5
      //   183: invokevirtual 184	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   186: goto +45 -> 231
      //   189: iconst_1
      //   190: aload 5
      //   192: getstatic 223	gnu/kawa/slib/printf:Lit42	Lgnu/math/IntNum;
      //   195: invokestatic 182	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   198: astore 5
      //   200: goto -170 -> 30
      //   203: invokestatic 160	gnu/kawa/slib/printf$frame4:lambda20parseError	()Z
      //   206: ifeq +9 -> 215
      //   209: getstatic 166	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   212: goto +19 -> 231
      //   215: getstatic 169	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   218: goto +13 -> 231
      //   221: getstatic 44	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   224: aload 6
      //   226: aload 5
      //   228: invokevirtual 184	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   231: areturn
      //   232: new 68	gnu/mapping/WrongType
      //   235: dup_x1
      //   236: swap
      //   237: ldc 70
      //   239: iconst_1
      //   240: aload 7
      //   242: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   245: athrow
      //   246: new 68	gnu/mapping/WrongType
      //   249: dup_x1
      //   250: swap
      //   251: ldc 70
      //   253: iconst_2
      //   254: aload 7
      //   256: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   259: athrow
      //   260: new 68	gnu/mapping/WrongType
      //   263: dup_x1
      //   264: swap
      //   265: ldc 70
      //   267: iconst_1
      //   268: aload 8
      //   270: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   273: athrow
      //   274: new 68	gnu/mapping/WrongType
      //   277: dup_x1
      //   278: swap
      //   279: ldc 70
      //   281: iconst_2
      //   282: aload 8
      //   284: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   287: athrow
      // Line number table:
      //   Java source line #75	-> byte code offset #0
      //   Java source line #76	-> byte code offset #20
      //   Java source line #77	-> byte code offset #20
      //   Java source line #78	-> byte code offset #21
      //   Java source line #37	-> byte code offset #26
      //   Java source line #38	-> byte code offset #30
      //   Java source line #39	-> byte code offset #55
      //   Java source line #40	-> byte code offset #90
      //   Java source line #42	-> byte code offset #179
      //   Java source line #41	-> byte code offset #189
      //   Java source line #44	-> byte code offset #221
      //   Java source line #39	-> byte code offset #232
      //   Java source line #40	-> byte code offset #260
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	232	0	this	frame4
      //   0	231	1	n	Object
      //   0	231	2	i	Object
      //   0	231	3	cont	gnu.mapping.Procedure
      //   12	10	4	$heapFrame	printf.frame7
      //   28	199	5	i	Object
      //   26	1	6	localModuleMethod	ModuleMethod
      //   30	195	6	cont	Object
      //   65	12	7	localObject1	Object
      //   129	126	7	tmp	int
      //   100	183	8	localObject2	Object
      //   232	1	11	localClassCastException1	ClassCastException
      //   246	1	12	localClassCastException2	ClassCastException
      //   260	1	13	localClassCastException3	ClassCastException
      //   274	1	14	localClassCastException4	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   67	70	232	java/lang/ClassCastException
      //   78	84	246	java/lang/ClassCastException
      //   102	105	260	java/lang/ClassCastException
      //   120	126	274	java/lang/ClassCastException
    }
    
    /* Error */
    Object lambda18(Object i, Object sgn, Object digs, Object ex)
    {
      // Byte code:
      //   0: new 2	gnu/kawa/slib/printf$frame5
      //   3: dup
      //   4: invokespecial 6	gnu/kawa/slib/printf$frame5:<init>	()V
      //   7: dup
      //   8: aload_0
      //   9: putfield 10	gnu/kawa/slib/printf$frame5:staticLink	Lgnu/kawa/slib/printf$frame4;
      //   12: astore 5
      //   14: aload 5
      //   16: aload_2
      //   17: putfield 14	gnu/kawa/slib/printf$frame5:sgn	Ljava/lang/Object;
      //   20: aload 5
      //   22: aload_3
      //   23: putfield 17	gnu/kawa/slib/printf$frame5:digs	Ljava/lang/Object;
      //   26: aload 5
      //   28: aload 4
      //   30: putfield 20	gnu/kawa/slib/printf$frame5:ex	Ljava/lang/Object;
      //   33: aload_1
      //   34: aload_0
      //   35: getfield 26	gnu/kawa/slib/printf$frame4:n	I
      //   38: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   41: invokestatic 38	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   44: ifeq +31 -> 75
      //   47: getstatic 44	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   50: aload_0
      //   51: getfield 47	gnu/kawa/slib/printf$frame4:proc	Ljava/lang/Object;
      //   54: aload 5
      //   56: getfield 14	gnu/kawa/slib/printf$frame5:sgn	Ljava/lang/Object;
      //   59: aload 5
      //   61: getfield 17	gnu/kawa/slib/printf$frame5:digs	Ljava/lang/Object;
      //   64: aload 5
      //   66: getfield 20	gnu/kawa/slib/printf$frame5:ex	Ljava/lang/Object;
      //   69: invokevirtual 53	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   72: goto +201 -> 273
      //   75: aload_0
      //   76: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   79: ldc 58
      //   81: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   84: dup
      //   85: astore 6
      //   87: checkcast 58	java/lang/CharSequence
      //   90: aload_1
      //   91: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   94: dup
      //   95: astore 6
      //   97: checkcast 78	java/lang/Number
      //   100: invokevirtual 82	java/lang/Number:intValue	()I
      //   103: invokestatic 88	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   106: invokestatic 94	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   109: getstatic 100	gnu/kawa/slib/printf:Lit64	Lgnu/lists/PairWithPosition;
      //   112: invokestatic 106	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   115: invokestatic 112	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   118: ifeq +23 -> 141
      //   121: aload_0
      //   122: aload_0
      //   123: getfield 26	gnu/kawa/slib/printf$frame4:n	I
      //   126: invokestatic 32	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   129: aload_1
      //   130: aload 5
      //   132: getfield 116	gnu/kawa/slib/printf$frame5:lambda$Fn9	Lgnu/expr/ModuleMethod;
      //   135: invokevirtual 120	gnu/kawa/slib/printf$frame4:lambda17real	(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
      //   138: goto +135 -> 273
      //   141: aload_0
      //   142: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   145: ldc 58
      //   147: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   150: dup
      //   151: astore 6
      //   153: checkcast 58	java/lang/CharSequence
      //   156: aload_1
      //   157: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   160: dup
      //   161: astore 6
      //   163: checkcast 78	java/lang/Number
      //   166: invokevirtual 82	java/lang/Number:intValue	()I
      //   169: invokestatic 88	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   172: invokestatic 94	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   175: getstatic 124	gnu/kawa/slib/printf:Lit65	Lgnu/text/Char;
      //   178: invokestatic 129	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   181: ifeq +89 -> 270
      //   184: aload_0
      //   185: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   188: ldc 58
      //   190: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   193: dup
      //   194: astore 6
      //   196: checkcast 58	java/lang/CharSequence
      //   199: invokestatic 137	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   202: aload 5
      //   204: swap
      //   205: putfield 140	gnu/kawa/slib/printf$frame5:num	Ljava/lang/Object;
      //   208: aload 5
      //   210: getfield 140	gnu/kawa/slib/printf$frame5:num	Ljava/lang/Object;
      //   213: invokestatic 112	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   216: ifeq +36 -> 252
      //   219: aload 5
      //   221: getfield 140	gnu/kawa/slib/printf$frame5:num	Ljava/lang/Object;
      //   224: ldc 78
      //   226: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   229: dup
      //   230: astore 6
      //   232: checkcast 78	java/lang/Number
      //   235: invokestatic 146	kawa/lib/numbers:realPart	(Ljava/lang/Number;)Ljava/lang/Number;
      //   238: invokestatic 150	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
      //   241: aload 5
      //   243: getfield 153	gnu/kawa/slib/printf$frame5:lambda$Fn10	Lgnu/expr/ModuleMethod;
      //   246: invokestatic 156	gnu/kawa/slib/printf:stdio$ClParseFloat	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   249: goto +24 -> 273
      //   252: invokestatic 160	gnu/kawa/slib/printf$frame4:lambda20parseError	()Z
      //   255: ifeq +9 -> 264
      //   258: getstatic 166	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   261: goto +12 -> 273
      //   264: getstatic 169	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   267: goto +6 -> 273
      //   270: getstatic 169	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   273: areturn
      //   274: new 68	gnu/mapping/WrongType
      //   277: dup_x1
      //   278: swap
      //   279: ldc 70
      //   281: iconst_1
      //   282: aload 6
      //   284: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   287: athrow
      //   288: new 68	gnu/mapping/WrongType
      //   291: dup_x1
      //   292: swap
      //   293: ldc 70
      //   295: iconst_2
      //   296: aload 6
      //   298: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   301: athrow
      //   302: new 68	gnu/mapping/WrongType
      //   305: dup_x1
      //   306: swap
      //   307: ldc 70
      //   309: iconst_1
      //   310: aload 6
      //   312: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   315: athrow
      //   316: new 68	gnu/mapping/WrongType
      //   319: dup_x1
      //   320: swap
      //   321: ldc 70
      //   323: iconst_2
      //   324: aload 6
      //   326: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   329: athrow
      //   330: new 68	gnu/mapping/WrongType
      //   333: dup_x1
      //   334: swap
      //   335: ldc -125
      //   337: iconst_1
      //   338: aload 6
      //   340: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   343: athrow
      //   344: new 68	gnu/mapping/WrongType
      //   347: dup_x1
      //   348: swap
      //   349: ldc -114
      //   351: iconst_1
      //   352: aload 6
      //   354: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   357: athrow
      // Line number table:
      //   Java source line #106	-> byte code offset #0
      //   Java source line #107	-> byte code offset #33
      //   Java source line #108	-> byte code offset #33
      //   Java source line #109	-> byte code offset #75
      //   Java source line #110	-> byte code offset #121
      //   Java source line #111	-> byte code offset #130
      //   Java source line #116	-> byte code offset #141
      //   Java source line #119	-> byte code offset #184
      //   Java source line #120	-> byte code offset #208
      //   Java source line #121	-> byte code offset #219
      //   Java source line #122	-> byte code offset #219
      //   Java source line #123	-> byte code offset #241
      //   Java source line #128	-> byte code offset #252
      //   Java source line #109	-> byte code offset #274
      //   Java source line #116	-> byte code offset #302
      //   Java source line #119	-> byte code offset #330
      //   Java source line #122	-> byte code offset #344
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	274	0	this	frame4
      //   0	273	1	i	Object
      //   0	273	2	sgn	Object
      //   0	273	3	digs	Object
      //   0	273	4	ex	Object
      //   12	230	5	$heapFrame	printf.frame5
      //   85	268	6	localObject	Object
      //   274	1	7	localClassCastException1	ClassCastException
      //   288	1	8	localClassCastException2	ClassCastException
      //   302	1	9	localClassCastException3	ClassCastException
      //   316	1	10	localClassCastException4	ClassCastException
      //   330	1	11	localClassCastException5	ClassCastException
      //   344	1	12	localClassCastException6	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   87	90	274	java/lang/ClassCastException
      //   97	103	288	java/lang/ClassCastException
      //   153	156	302	java/lang/ClassCastException
      //   163	169	316	java/lang/ClassCastException
      //   196	199	330	java/lang/ClassCastException
      //   232	235	344	java/lang/ClassCastException
    }
    
    public static boolean lambda20parseError()
    {
      return false;
    }
    
    /* Error */
    public Object lambda23sign(Object n, Object i, gnu.mapping.Procedure cont)
    {
      // Byte code:
      //   0: aload_2
      //   1: aload_1
      //   2: invokestatic 172	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   5: ifeq +94 -> 99
      //   8: aload_0
      //   9: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   12: ldc 58
      //   14: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   17: dup
      //   18: astore 5
      //   20: checkcast 58	java/lang/CharSequence
      //   23: aload_2
      //   24: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   27: dup
      //   28: astore 5
      //   30: checkcast 78	java/lang/Number
      //   33: invokevirtual 82	java/lang/Number:intValue	()I
      //   36: invokestatic 88	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   39: istore 4
      //   41: iload 4
      //   43: tableswitch	default:+45->88, 43:+25->68, 44:+45->88, 45:+25->68
      //   68: aload_3
      //   69: iconst_1
      //   70: aload_2
      //   71: getstatic 176	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   74: invokestatic 182	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   77: iload 4
      //   79: invokestatic 94	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   82: invokevirtual 184	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   85: goto +17 -> 102
      //   88: aload_3
      //   89: aload_2
      //   90: getstatic 187	gnu/kawa/slib/printf:Lit17	Lgnu/text/Char;
      //   93: invokevirtual 184	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   96: goto +6 -> 102
      //   99: getstatic 193	gnu/mapping/Values:empty	Lgnu/mapping/Values;
      //   102: areturn
      //   103: new 68	gnu/mapping/WrongType
      //   106: dup_x1
      //   107: swap
      //   108: ldc 70
      //   110: iconst_1
      //   111: aload 5
      //   113: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   116: athrow
      //   117: new 68	gnu/mapping/WrongType
      //   120: dup_x1
      //   121: swap
      //   122: ldc 70
      //   124: iconst_2
      //   125: aload 5
      //   127: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   130: athrow
      // Line number table:
      //   Java source line #45	-> byte code offset #0
      //   Java source line #46	-> byte code offset #0
      //   Java source line #47	-> byte code offset #8
      //   Java source line #48	-> byte code offset #41
      //   Java source line #49	-> byte code offset #69
      //   Java source line #50	-> byte code offset #89
      //   Java source line #47	-> byte code offset #103
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	frame4
      //   0	102	1	n	Object
      //   0	102	2	i	Object
      //   0	102	3	cont	gnu.mapping.Procedure
      //   39	39	4	c	int
      //   18	108	5	localObject	Object
      //   103	1	6	localClassCastException1	ClassCastException
      //   117	1	7	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   20	23	103	java/lang/ClassCastException
      //   30	36	117	java/lang/ClassCastException
    }
    
    /* Error */
    public Object lambda24digits(Object n, Object i, gnu.mapping.Procedure cont)
    {
      // Byte code:
      //   0: aload_2
      //   1: astore 4
      //   3: aload 4
      //   5: aload_1
      //   6: invokestatic 196	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   9: istore 5
      //   11: iload 5
      //   13: ifeq +11 -> 24
      //   16: iload 5
      //   18: ifne +105 -> 123
      //   21: goto +90 -> 111
      //   24: aload_0
      //   25: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   28: ldc 58
      //   30: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   33: dup
      //   34: astore 7
      //   36: checkcast 58	java/lang/CharSequence
      //   39: aload 4
      //   41: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   44: dup
      //   45: astore 7
      //   47: checkcast 78	java/lang/Number
      //   50: invokevirtual 82	java/lang/Number:intValue	()I
      //   53: invokestatic 88	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   56: invokestatic 202	kawa/lib/rnrs/unicode:isCharNumeric	(I)Z
      //   59: istore 6
      //   61: iload 6
      //   63: ifeq +11 -> 74
      //   66: iload 6
      //   68: ifeq +55 -> 123
      //   71: goto +40 -> 111
      //   74: bipush 35
      //   76: aload_0
      //   77: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   80: ldc 58
      //   82: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   85: dup
      //   86: astore 7
      //   88: checkcast 58	java/lang/CharSequence
      //   91: aload 4
      //   93: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   96: dup
      //   97: astore 7
      //   99: checkcast 78	java/lang/Number
      //   102: invokevirtual 82	java/lang/Number:intValue	()I
      //   105: invokestatic 88	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   108: if_icmpne +15 -> 123
      //   111: iconst_1
      //   112: aload 4
      //   114: getstatic 176	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   117: invokestatic 182	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   120: goto -119 -> 1
      //   123: aload_3
      //   124: aload 4
      //   126: aload_2
      //   127: aload 4
      //   129: invokestatic 38	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   132: ifeq +8 -> 140
      //   135: ldc -52
      //   137: goto +48 -> 185
      //   140: aload_0
      //   141: getfield 56	gnu/kawa/slib/printf$frame4:str	Ljava/lang/Object;
      //   144: ldc 58
      //   146: invokestatic 64	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   149: dup
      //   150: astore 5
      //   152: checkcast 58	java/lang/CharSequence
      //   155: aload_2
      //   156: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   159: dup
      //   160: astore 5
      //   162: checkcast 78	java/lang/Number
      //   165: invokevirtual 82	java/lang/Number:intValue	()I
      //   168: aload 4
      //   170: invokestatic 76	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   173: dup
      //   174: astore 5
      //   176: checkcast 78	java/lang/Number
      //   179: invokevirtual 82	java/lang/Number:intValue	()I
      //   182: invokestatic 209	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   185: invokevirtual 184	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   188: areturn
      //   189: new 68	gnu/mapping/WrongType
      //   192: dup_x1
      //   193: swap
      //   194: ldc 70
      //   196: iconst_1
      //   197: aload 7
      //   199: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   202: athrow
      //   203: new 68	gnu/mapping/WrongType
      //   206: dup_x1
      //   207: swap
      //   208: ldc 70
      //   210: iconst_2
      //   211: aload 7
      //   213: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   216: athrow
      //   217: new 68	gnu/mapping/WrongType
      //   220: dup_x1
      //   221: swap
      //   222: ldc 70
      //   224: iconst_1
      //   225: aload 7
      //   227: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   230: athrow
      //   231: new 68	gnu/mapping/WrongType
      //   234: dup_x1
      //   235: swap
      //   236: ldc 70
      //   238: iconst_2
      //   239: aload 7
      //   241: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   244: athrow
      //   245: new 68	gnu/mapping/WrongType
      //   248: dup_x1
      //   249: swap
      //   250: ldc -50
      //   252: iconst_1
      //   253: aload 5
      //   255: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   258: athrow
      //   259: new 68	gnu/mapping/WrongType
      //   262: dup_x1
      //   263: swap
      //   264: ldc -50
      //   266: iconst_2
      //   267: aload 5
      //   269: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   272: athrow
      //   273: new 68	gnu/mapping/WrongType
      //   276: dup_x1
      //   277: swap
      //   278: ldc -50
      //   280: iconst_3
      //   281: aload 5
      //   283: invokespecial 73	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   286: athrow
      // Line number table:
      //   Java source line #51	-> byte code offset #0
      //   Java source line #52	-> byte code offset #0
      //   Java source line #53	-> byte code offset #3
      //   Java source line #54	-> byte code offset #24
      //   Java source line #55	-> byte code offset #74
      //   Java source line #52	-> byte code offset #111
      //   Java source line #56	-> byte code offset #123
      //   Java source line #54	-> byte code offset #189
      //   Java source line #55	-> byte code offset #217
      //   Java source line #56	-> byte code offset #245
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	189	0	this	frame4
      //   0	188	1	n	Object
      //   0	188	2	i	Object
      //   0	188	3	cont	gnu.mapping.Procedure
      //   1	168	4	j	Object
      //   9	273	5	x	boolean
      //   59	8	6	x	boolean
      //   34	206	7	localObject1	Object
      //   189	1	8	localClassCastException1	ClassCastException
      //   203	1	9	localClassCastException2	ClassCastException
      //   217	1	10	localClassCastException3	ClassCastException
      //   231	1	11	localClassCastException4	ClassCastException
      //   245	1	12	localClassCastException5	ClassCastException
      //   259	1	13	localClassCastException6	ClassCastException
      //   273	1	14	localClassCastException7	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   36	39	189	java/lang/ClassCastException
      //   47	53	203	java/lang/ClassCastException
      //   88	91	217	java/lang/ClassCastException
      //   99	105	231	java/lang/ClassCastException
      //   152	155	245	java/lang/ClassCastException
      //   162	168	259	java/lang/ClassCastException
      //   176	182	273	java/lang/ClassCastException
    }
    
    public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, gnu.mapping.CallContext paramCallContext)
    {
      if (selector == 19) { value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0; } return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) { if (selector == 19) return lambda18(paramObject1, paramObject2, paramObject3, paramObject4); return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
    }
  }
  
  static Object stdio$ClParseFloat(Object str, Object proc)
  {
    frame4 $heapFrame = new frame4();str = str;proc = proc;
    try { n = kawa.lib.strings.stringLength((CharSequence)(localObject = gnu.mapping.Promise.force(str, CharSequence.class)));
      





































































      return $heapFrame.lambda17real(Integer.valueOf(n), Lit13, lambda$Fn8);
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject;
      throw new gnu.mapping.WrongType(
      





































































        localClassCastException, "string-length", 1, localObject);
    }
  }
  












  public class frame13
    extends gnu.expr.ModuleBody
  {
    CharSequence str;
    











    public frame13() {}
    











    public Object lambda32dig(Object i)
    {
      try
      {
        int c = kawa.lib.strings.stringRef(str, ((Number)(localObject = gnu.mapping.Promise.force(i))).intValue());
        return kawa.lib.rnrs.unicode.isCharNumeric(c) ? 
          kawa.lib.numbers.string$To$Number(kawa.lib.strings.$make$string$(new Object[] { Char.make(c) })) : printf.Lit13;
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new gnu.mapping.WrongType(
          localClassCastException, "string-ref", 2, localObject);
      }
    }
  }
  





  static final Char Lit4;
  




  static final Char Lit5;
  




  static final Char Lit6;
  




  static final Char Lit7;
  




  static final Char Lit8;
  




  static final Char Lit9;
  




  static final Char Lit10;
  




  static final Char Lit11;
  




  static final Char Lit12;
  




  static final gnu.math.IntNum Lit13;
  




  static final Char Lit14;
  




  static final Char Lit15;
  




  static final Char Lit16;
  




  static final Char Lit17;
  




  static final Char Lit18;
  




  static final Char Lit19;
  




  static final Char Lit20;
  




  static final Char Lit21;
  




  static final Char Lit22;
  




  static final gnu.lists.PairWithPosition Lit23;
  




  static final gnu.mapping.SimpleSymbol Lit24;
  




  static final Char Lit25;
  




  static final Char Lit26;
  




  static final Char Lit27;
  




  static final Char Lit28;
  




  static final Char Lit29;
  




  static final Char Lit30;
  




  static final Char Lit31;
  




  static final Char Lit32;
  




  static final Char Lit33;
  




  static final Char Lit34;
  




  static final Char Lit35;
  




  static final Char Lit36;
  




  static final gnu.math.IntNum Lit37;
  




  static final Char Lit38;
  




  static final Char Lit39;
  




  static final Char Lit40;
  




  static final Char Lit41;
  




  static final gnu.math.IntNum Lit42;
  




  static final Char Lit43;
  




  static final Char Lit44;
  




  static final Char Lit45;
  




  static final gnu.math.IntNum Lit46;
  




  static final Char Lit47;
  




  static final gnu.math.IntNum Lit48;
  




  static final gnu.math.IntNum Lit49;
  




  static final gnu.math.IntNum Lit50;
  




  static final gnu.math.IntNum Lit51;
  




  static final gnu.math.IntNum Lit52;
  




  static final gnu.lists.FVector Lit53;
  



  static final gnu.lists.PairWithPosition Lit54;
  



  static final gnu.mapping.SimpleSymbol Lit55;
  



  static final Char Lit56;
  



  static final Char Lit57;
  



  static final Char Lit58;
  



  static final Char Lit59;
  



  static final Char Lit60;
  



  static final Char Lit61;
  



  static final gnu.mapping.SimpleSymbol Lit62;
  



  static final gnu.mapping.SimpleSymbol Lit63;
  



  static final gnu.lists.PairWithPosition Lit64;
  



  static final Char Lit65;
  



  static final gnu.lists.PairWithPosition Lit66;
  



  static final gnu.math.IntNum Lit67;
  



  static final gnu.math.IntNum Lit68;
  



  public static printf $instance;
  



  static final gnu.mapping.SimpleSymbol Lit69;
  



  static final gnu.mapping.SimpleSymbol Lit70 = gnu.mapping.Symbol.valueOf("fprintf");
  



  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 23:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 22: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 21: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 20: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  

  public class frame
    extends gnu.expr.ModuleBody
  {
    Object out;
    Object format$Mnstring;
    Object fc;
    gnu.math.IntNum pos;
    
    public boolean lambda1isEndOfFormat(Object fl)
    {
      try
      {
        return gnu.math.IntNum.compare(pos, ((Number)(localObject = gnu.mapping.Promise.force(fl))).longValue()) >= 0; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "gnu.math.IntNum.compare(integer,long)", 2, localObject); } }
    
    public gnu.bytecode.Type.NeverReturns lambda14incomplete() { throw gnu.expr.Special.reachedUnexpected; }
    

    public Object lambda5out$St(Object strs)
    {
      for (;;)
      {
        Object strs = strs;
        boolean x = kawa.lib.lists.isNull(strs);
        Object localObject1; try { if (!gnu.expr.KawaConvert.isTrue(kawa.standard.Scheme.applyToArgs.apply2(out, kawa.lib.lists.car((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(strs, gnu.lists.Pair.class)))))) {} } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
            localClassCastException1, "car", 1, localObject1); } try { tmpTernaryOp = kawa.lib.lists.cdr((gnu.lists.Pair)(localObject1 = gnu.mapping.Promise.force(strs, gnu.lists.Pair.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "cdr", 1, localObject1); } } return x ? Boolean.FALSE : x ? Boolean.TRUE : kawa.lib.strings.isString(strs) ? kawa.standard.Scheme.applyToArgs.apply2(out, strs) : Boolean.FALSE;
    }
    
    public frame() {}
    
    /* Error */
    public void lambda2mustAdvance(Object fl)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_0
      //   2: getfield 6	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
      //   5: iconst_1
      //   6: invokestatic 12	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
      //   9: putfield 6	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
      //   12: aload_0
      //   13: getfield 6	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
      //   16: aload_1
      //   17: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   20: dup
      //   21: astore_2
      //   22: checkcast 20	java/lang/Number
      //   25: invokevirtual 24	java/lang/Number:longValue	()J
      //   28: invokestatic 38	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
      //   31: iflt +11 -> 42
      //   34: aload_0
      //   35: invokevirtual 42	gnu/kawa/slib/printf$frame:lambda14incomplete	()Lgnu/bytecode/Type$NeverReturns;
      //   38: getstatic 48	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
      //   41: athrow
      //   42: aload_0
      //   43: aload_0
      //   44: getfield 52	gnu/kawa/slib/printf$frame:format$Mnstring	Ljava/lang/Object;
      //   47: ldc 54
      //   49: invokestatic 57	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   52: dup
      //   53: astore_2
      //   54: checkcast 54	java/lang/CharSequence
      //   57: aload_0
      //   58: getfield 6	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
      //   61: dup
      //   62: astore_2
      //   63: invokevirtual 63	java/lang/Number:intValue	()I
      //   66: invokestatic 69	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   69: invokestatic 75	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   72: putfield 78	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
      //   75: return
      //   76: new 28	gnu/mapping/WrongType
      //   79: dup_x1
      //   80: swap
      //   81: ldc 30
      //   83: iconst_2
      //   84: aload_2
      //   85: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   88: athrow
      //   89: new 28	gnu/mapping/WrongType
      //   92: dup_x1
      //   93: swap
      //   94: ldc 59
      //   96: iconst_1
      //   97: aload_2
      //   98: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   101: athrow
      //   102: new 28	gnu/mapping/WrongType
      //   105: dup_x1
      //   106: swap
      //   107: ldc 59
      //   109: iconst_2
      //   110: aload_2
      //   111: invokespecial 34	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   114: athrow
      // Line number table:
      //   Java source line #197	-> byte code offset #0
      //   Java source line #198	-> byte code offset #0
      //   Java source line #199	-> byte code offset #12
      //   Java source line #200	-> byte code offset #42
      //   Java source line #199	-> byte code offset #76
      //   Java source line #200	-> byte code offset #89
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	76	0	this	frame
      //   0	75	1	fl	Object
      //   21	90	2	localObject	Object
      //   76	1	3	localClassCastException1	ClassCastException
      //   89	1	4	localClassCastException2	ClassCastException
      //   102	1	5	localClassCastException3	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   22	28	76	java/lang/ClassCastException
      //   54	57	89	java/lang/ClassCastException
      //   63	66	102	java/lang/ClassCastException
    }
  }
  
  public class frame1
    extends gnu.expr.ModuleBody
  {
    gnu.mapping.Procedure format$Mnreal = new ModuleMethod(this, 1, printf.Lit55, 61444);
    Object fc;
    printf.frame0 staticLink;
    final ModuleMethod lambda$Fn5;
    
    /* Error */
    public Object applyN(ModuleMethod arg1, Object[] arg2)
    {
      // Byte code:
      //   0: aload_1
      //   1: getfield 396	gnu/expr/ModuleMethod:selector	I
      //   4: tableswitch	default:+109->113, 1:+24->28, 2:+68->72
      //   28: aload_0
      //   29: aload_2
      //   30: iconst_0
      //   31: aaload
      //   32: aload_2
      //   33: iconst_1
      //   34: aaload
      //   35: aload_2
      //   36: iconst_2
      //   37: aaload
      //   38: aload_2
      //   39: iconst_3
      //   40: aaload
      //   41: aload_2
      //   42: arraylength
      //   43: iconst_4
      //   44: isub
      //   45: istore_3
      //   46: iload_3
      //   47: anewarray 55	java/lang/Object
      //   50: goto +11 -> 61
      //   53: dup
      //   54: iload_3
      //   55: aload_2
      //   56: iload_3
      //   57: iconst_4
      //   58: iadd
      //   59: aaload
      //   60: aastore
      //   61: iinc 3 -1
      //   64: iload_3
      //   65: ifge -12 -> 53
      //   68: invokevirtual 313	gnu/kawa/slib/printf$frame1:lambda11formatReal$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   71: areturn
      //   72: aload_0
      //   73: aload_2
      //   74: iconst_0
      //   75: aaload
      //   76: aload_2
      //   77: iconst_1
      //   78: aaload
      //   79: aload_2
      //   80: iconst_2
      //   81: aaload
      //   82: aload_2
      //   83: arraylength
      //   84: iconst_3
      //   85: isub
      //   86: istore_3
      //   87: iload_3
      //   88: anewarray 55	java/lang/Object
      //   91: goto +11 -> 102
      //   94: dup
      //   95: iload_3
      //   96: aload_2
      //   97: iload_3
      //   98: iconst_3
      //   99: iadd
      //   100: aaload
      //   101: aastore
      //   102: iinc 3 -1
      //   105: iload_3
      //   106: ifge -12 -> 94
      //   109: invokevirtual 419	gnu/kawa/slib/printf$frame1:lambda13$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   112: areturn
      //   113: aload_0
      //   114: aload_1
      //   115: aload_2
      //   116: invokespecial 422	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
      //   119: areturn
      // Line number table:
      //   Java source line #386	-> byte code offset #28
      //   Java source line #402	-> byte code offset #72
    }
    
    public void apply(gnu.mapping.CallContext paramCallContext)
    {
      ModuleMethod.applyError();
    }
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
    {
      switch (selector) {case 2:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
      case 1: 
        values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
    





    Object lambda13$V(Object sgn, Object digs, Object expon, Object[] argsArray)
    {
      gnu.lists.LList localLList1;
      




      gnu.lists.LList imag = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
      


      return kawa.standard.Scheme.apply.apply2(staticLink.pad, kawa.standard.Scheme.apply.applyN(new Object[] { format$Mnreal, staticLink.signed ? Boolean.TRUE : Boolean.FALSE, sgn, digs, expon, imag }));
    }
    
    /* Error */
    public Object lambda12f(Object digs, Object exp, Object strip$Mn0s)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 120
      //   3: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   6: dup
      //   7: astore 5
      //   9: checkcast 120	java/lang/CharSequence
      //   12: iconst_1
      //   13: aload_2
      //   14: aload_0
      //   15: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   18: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   21: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   24: aload_3
      //   25: invokestatic 31	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   28: ifeq +7 -> 35
      //   31: aload_2
      //   32: goto +6 -> 38
      //   35: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   38: invokestatic 140	gnu/kawa/slib/printf:stdio$ClRoundString	(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   41: astore 4
      //   43: aload_2
      //   44: getstatic 136	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   47: invokestatic 341	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   50: ifeq +219 -> 269
      //   53: aload_2
      //   54: ldc -104
      //   56: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   59: dup
      //   60: astore 6
      //   62: checkcast 152	java/lang/Number
      //   65: invokestatic 170	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   68: ifeq +9 -> 77
      //   71: getstatic 136	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   74: goto +34 -> 108
      //   77: bipush 48
      //   79: aload 4
      //   81: ldc 120
      //   83: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   86: dup
      //   87: astore 6
      //   89: checkcast 120	java/lang/CharSequence
      //   92: iconst_0
      //   93: invokestatic 148	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   96: if_icmpne +9 -> 105
      //   99: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   102: goto +6 -> 108
      //   105: getstatic 136	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   108: astore 5
      //   110: iconst_2
      //   111: anewarray 55	java/lang/Object
      //   114: dup
      //   115: iconst_0
      //   116: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   119: aastore
      //   120: dup
      //   121: iconst_1
      //   122: iconst_1
      //   123: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   126: aload_2
      //   127: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   130: aastore
      //   131: invokestatic 286	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
      //   134: astore 6
      //   136: aload 4
      //   138: ldc 120
      //   140: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   143: dup
      //   144: astore 8
      //   146: checkcast 120	java/lang/CharSequence
      //   149: aload 5
      //   151: dup
      //   152: astore 8
      //   154: invokevirtual 155	java/lang/Number:intValue	()I
      //   157: aload 6
      //   159: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   162: dup
      //   163: astore 8
      //   165: checkcast 152	java/lang/Number
      //   168: invokevirtual 155	java/lang/Number:intValue	()I
      //   171: invokestatic 164	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   174: astore 7
      //   176: aload 4
      //   178: ldc 120
      //   180: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   183: dup
      //   184: astore 9
      //   186: checkcast 120	java/lang/CharSequence
      //   189: aload 6
      //   191: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   194: dup
      //   195: astore 9
      //   197: checkcast 152	java/lang/Number
      //   200: invokevirtual 155	java/lang/Number:intValue	()I
      //   203: aload 4
      //   205: ldc 120
      //   207: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   210: dup
      //   211: astore 9
      //   213: checkcast 120	java/lang/CharSequence
      //   216: invokestatic 161	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   219: invokestatic 164	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   222: astore 8
      //   224: aload 7
      //   226: aload 8
      //   228: ldc 49
      //   230: iconst_0
      //   231: anewarray 120	java/lang/CharSequence
      //   234: invokestatic 178	kawa/lib/strings:isString$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
      //   237: ifeq +19 -> 256
      //   240: aload_0
      //   241: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   244: getfield 96	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
      //   247: ifne +9 -> 256
      //   250: getstatic 347	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
      //   253: goto +10 -> 263
      //   256: ldc -76
      //   258: aload 8
      //   260: invokestatic 296	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   263: invokestatic 309	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   266: goto +168 -> 434
      //   269: aload_0
      //   270: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   273: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   276: ldc -104
      //   278: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   281: dup
      //   282: astore 5
      //   284: checkcast 152	java/lang/Number
      //   287: invokestatic 170	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   290: ifeq +27 -> 317
      //   293: aload_0
      //   294: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   297: getfield 96	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
      //   300: ifeq +9 -> 309
      //   303: ldc_w 349
      //   306: goto +5 -> 311
      //   309: ldc -35
      //   311: invokestatic 174	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   314: goto +120 -> 434
      //   317: aload_3
      //   318: invokestatic 31	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   321: ifeq +42 -> 363
      //   324: aload 4
      //   326: ldc 120
      //   328: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   331: dup
      //   332: astore 6
      //   334: checkcast 120	java/lang/CharSequence
      //   337: ldc 49
      //   339: iconst_0
      //   340: anewarray 120	java/lang/CharSequence
      //   343: invokestatic 178	kawa/lib/strings:isString$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
      //   346: ifeq +11 -> 357
      //   349: ldc -35
      //   351: invokestatic 174	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   354: goto +12 -> 366
      //   357: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   360: goto +6 -> 366
      //   363: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   366: astore 5
      //   368: aload 5
      //   370: invokestatic 31	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   373: ifeq +8 -> 381
      //   376: aload 5
      //   378: goto +56 -> 434
      //   381: ldc_w 349
      //   384: iconst_2
      //   385: anewarray 55	java/lang/Object
      //   388: dup
      //   389: iconst_0
      //   390: aload_0
      //   391: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   394: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   397: aastore
      //   398: dup
      //   399: iconst_1
      //   400: iconst_m1
      //   401: getstatic 257	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   404: aload_2
      //   405: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   408: aastore
      //   409: invokestatic 354	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
      //   412: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   415: dup
      //   416: astore 6
      //   418: checkcast 152	java/lang/Number
      //   421: invokevirtual 155	java/lang/Number:intValue	()I
      //   424: bipush 48
      //   426: invokestatic 360	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
      //   429: aload 4
      //   431: invokestatic 364	gnu/lists/LList:list3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   434: areturn
      //   435: new 127	gnu/mapping/WrongType
      //   438: dup_x1
      //   439: swap
      //   440: ldc -127
      //   442: iconst_0
      //   443: aload 5
      //   445: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   448: athrow
      //   449: new 127	gnu/mapping/WrongType
      //   452: dup_x1
      //   453: swap
      //   454: ldc_w 343
      //   457: iconst_1
      //   458: aload 6
      //   460: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   463: athrow
      //   464: new 127	gnu/mapping/WrongType
      //   467: dup_x1
      //   468: swap
      //   469: ldc -114
      //   471: iconst_1
      //   472: aload 6
      //   474: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   477: athrow
      //   478: new 127	gnu/mapping/WrongType
      //   481: dup_x1
      //   482: swap
      //   483: ldc -106
      //   485: iconst_1
      //   486: aload 8
      //   488: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   491: athrow
      //   492: new 127	gnu/mapping/WrongType
      //   495: dup_x1
      //   496: swap
      //   497: ldc -106
      //   499: iconst_2
      //   500: aload 8
      //   502: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   505: athrow
      //   506: new 127	gnu/mapping/WrongType
      //   509: dup_x1
      //   510: swap
      //   511: ldc -106
      //   513: iconst_3
      //   514: aload 8
      //   516: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   519: athrow
      //   520: new 127	gnu/mapping/WrongType
      //   523: dup_x1
      //   524: swap
      //   525: ldc -106
      //   527: iconst_1
      //   528: aload 9
      //   530: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   533: athrow
      //   534: new 127	gnu/mapping/WrongType
      //   537: dup_x1
      //   538: swap
      //   539: ldc -106
      //   541: iconst_2
      //   542: aload 9
      //   544: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   547: athrow
      //   548: new 127	gnu/mapping/WrongType
      //   551: dup_x1
      //   552: swap
      //   553: ldc -99
      //   555: iconst_1
      //   556: aload 9
      //   558: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   561: athrow
      //   562: new 127	gnu/mapping/WrongType
      //   565: dup_x1
      //   566: swap
      //   567: ldc_w 343
      //   570: iconst_1
      //   571: aload 5
      //   573: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   576: athrow
      //   577: new 127	gnu/mapping/WrongType
      //   580: dup_x1
      //   581: swap
      //   582: ldc_w 351
      //   585: iconst_1
      //   586: aload 6
      //   588: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   591: athrow
      //   592: new 127	gnu/mapping/WrongType
      //   595: dup_x1
      //   596: swap
      //   597: ldc_w 356
      //   600: iconst_1
      //   601: aload 6
      //   603: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   606: athrow
      // Line number table:
      //   Java source line #307	-> byte code offset #0
      //   Java source line #308	-> byte code offset #0
      //   Java source line #309	-> byte code offset #0
      //   Java source line #310	-> byte code offset #43
      //   Java source line #311	-> byte code offset #53
      //   Java source line #312	-> byte code offset #79
      //   Java source line #313	-> byte code offset #105
      //   Java source line #311	-> byte code offset #110
      //   Java source line #314	-> byte code offset #110
      //   Java source line #311	-> byte code offset #136
      //   Java source line #315	-> byte code offset #136
      //   Java source line #311	-> byte code offset #176
      //   Java source line #316	-> byte code offset #176
      //   Java source line #317	-> byte code offset #203
      //   Java source line #318	-> byte code offset #224
      //   Java source line #319	-> byte code offset #226
      //   Java source line #322	-> byte code offset #256
      //   Java source line #323	-> byte code offset #269
      //   Java source line #324	-> byte code offset #293
      //   Java source line #325	-> byte code offset #317
      //   Java source line #310	-> byte code offset #368
      //   Java source line #327	-> byte code offset #381
      //   Java source line #328	-> byte code offset #384
      //   Java source line #309	-> byte code offset #435
      //   Java source line #311	-> byte code offset #449
      //   Java source line #312	-> byte code offset #464
      //   Java source line #315	-> byte code offset #478
      //   Java source line #316	-> byte code offset #520
      //   Java source line #317	-> byte code offset #548
      //   Java source line #323	-> byte code offset #562
      //   Java source line #325	-> byte code offset #577
      //   Java source line #328	-> byte code offset #592
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	435	0	this	frame1
      //   0	434	1	digs	Object
      //   0	434	2	exp	Object
      //   0	434	3	strip$Mn0s	Object
      //   41	389	4	digs	Object
      //   7	1	5	localObject1	Object
      //   108	175	5	i0	Object
      //   366	206	5	x	Object
      //   60	28	6	localObject2	Object
      //   134	468	6	i1	Object
      //   174	51	7	idigs	CharSequence
      //   144	20	8	localObject3	Object
      //   222	293	8	fdigs	CharSequence
      //   184	373	9	localObject4	Object
      //   435	1	14	localClassCastException1	ClassCastException
      //   449	1	15	localClassCastException2	ClassCastException
      //   464	1	16	localClassCastException3	ClassCastException
      //   478	1	17	localClassCastException4	ClassCastException
      //   492	1	18	localClassCastException5	ClassCastException
      //   506	1	19	localClassCastException6	ClassCastException
      //   520	1	20	localClassCastException7	ClassCastException
      //   534	1	21	localClassCastException8	ClassCastException
      //   548	1	22	localClassCastException9	ClassCastException
      //   562	1	23	localClassCastException10	ClassCastException
      //   577	1	24	localClassCastException11	ClassCastException
      //   592	1	25	localClassCastException12	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   9	12	435	java/lang/ClassCastException
      //   62	65	449	java/lang/ClassCastException
      //   89	92	464	java/lang/ClassCastException
      //   146	149	478	java/lang/ClassCastException
      //   154	157	492	java/lang/ClassCastException
      //   165	171	506	java/lang/ClassCastException
      //   186	189	520	java/lang/ClassCastException
      //   197	203	534	java/lang/ClassCastException
      //   213	216	548	java/lang/ClassCastException
      //   284	287	562	java/lang/ClassCastException
      //   334	337	577	java/lang/ClassCastException
      //   418	424	592	java/lang/ClassCastException
    }
    
    /* Error */
    public Object lambda11formatReal$V(Object signed$Qu, Object sgn, Object digs, Object exp, Object[] argsArray)
    {
      // Byte code:
      //   0: aload 5
      //   2: iconst_0
      //   3: invokestatic 6	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
      //   6: dup
      //   7: astore 7
      //   9: astore 6
      //   11: aload 6
      //   13: invokestatic 12	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   16: ifeq +1010 -> 1026
      //   19: bipush 45
      //   21: aload_2
      //   22: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   25: invokestatic 24	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   28: if_icmpne +8 -> 36
      //   31: ldc 26
      //   33: goto +32 -> 65
      //   36: aload_1
      //   37: invokestatic 31	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   40: ifeq +8 -> 48
      //   43: ldc 33
      //   45: goto +20 -> 65
      //   48: aload_0
      //   49: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   52: getfield 45	gnu/kawa/slib/printf$frame0:blank	Z
      //   55: ifeq +8 -> 63
      //   58: ldc 47
      //   60: goto +5 -> 65
      //   63: ldc 49
      //   65: aload_0
      //   66: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   69: invokevirtual 59	java/lang/Object:hashCode	()I
      //   72: lookupswitch	default:+942->1014, 69:+108->180, 70:+124->196, 71:+150->222, 75:+921->993, 101:+645->717, 102:+76->148, 103:+92->164, 107:+667->739
      //   148: aload_0
      //   149: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   152: getstatic 65	gnu/kawa/slib/printf:Lit3	Lgnu/text/Char;
      //   155: invokestatic 71	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   158: ifeq +856 -> 1014
      //   161: goto +48 -> 209
      //   164: aload_0
      //   165: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   168: getstatic 74	gnu/kawa/slib/printf:Lit38	Lgnu/text/Char;
      //   171: invokestatic 71	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   174: ifeq +840 -> 1014
      //   177: goto +58 -> 235
      //   180: aload_0
      //   181: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   184: getstatic 77	gnu/kawa/slib/printf:Lit26	Lgnu/text/Char;
      //   187: invokestatic 71	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   190: ifeq +824 -> 1014
      //   193: goto +537 -> 730
      //   196: aload_0
      //   197: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   200: getstatic 80	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
      //   203: invokestatic 71	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   206: ifeq +808 -> 1014
      //   209: aload_0
      //   210: aload_3
      //   211: aload 4
      //   213: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   216: invokevirtual 90	gnu/kawa/slib/printf$frame1:lambda12f	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   219: goto +801 -> 1020
      //   222: aload_0
      //   223: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   226: getstatic 93	gnu/kawa/slib/printf:Lit27	Lgnu/text/Char;
      //   229: invokestatic 71	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   232: ifeq +782 -> 1014
      //   235: aload_3
      //   236: aload 4
      //   238: astore 8
      //   240: astore 7
      //   242: aload_0
      //   243: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   246: getfield 96	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
      //   249: ifeq +7 -> 256
      //   252: iconst_0
      //   253: goto +4 -> 257
      //   256: iconst_1
      //   257: istore 9
      //   259: aload_0
      //   260: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   263: iconst_0
      //   264: putfield 96	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
      //   267: iconst_m1
      //   268: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   271: aload_0
      //   272: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   275: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   278: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   281: aload 8
      //   283: aload_0
      //   284: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   287: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   290: iconst_0
      //   291: anewarray 55	java/lang/Object
      //   294: invokestatic 115	gnu/kawa/functions/NumberCompare:$Ls$Eq$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
      //   297: ifeq +48 -> 345
      //   300: aload_0
      //   301: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   304: iconst_m1
      //   305: aload_0
      //   306: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   309: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   312: aload 8
      //   314: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   317: putfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   320: aload_0
      //   321: aload 7
      //   323: aload 8
      //   325: iload 9
      //   327: ifeq +9 -> 336
      //   330: getstatic 118	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   333: goto +6 -> 339
      //   336: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   339: invokevirtual 90	gnu/kawa/slib/printf$frame1:lambda12f	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   342: goto +678 -> 1020
      //   345: aload_0
      //   346: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   349: iconst_m1
      //   350: aload_0
      //   351: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   354: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   357: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   360: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   363: putfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   366: aload 7
      //   368: aload 8
      //   370: iload 9
      //   372: ifeq +9 -> 381
      //   375: getstatic 118	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   378: goto +9 -> 387
      //   381: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   384: goto +3 -> 387
      //   387: astore 11
      //   389: astore 10
      //   391: astore 9
      //   393: aload 9
      //   395: ldc 120
      //   397: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   400: dup
      //   401: astore 13
      //   403: checkcast 120	java/lang/CharSequence
      //   406: iconst_1
      //   407: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   410: aload_0
      //   411: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   414: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   417: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   420: aload 11
      //   422: invokestatic 31	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   425: ifeq +9 -> 434
      //   428: getstatic 136	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   431: goto +6 -> 437
      //   434: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   437: invokestatic 140	gnu/kawa/slib/printf:stdio$ClRoundString	(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   440: astore 12
      //   442: bipush 48
      //   444: aload 12
      //   446: ldc 120
      //   448: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   451: dup
      //   452: astore 14
      //   454: checkcast 120	java/lang/CharSequence
      //   457: iconst_0
      //   458: invokestatic 148	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   461: if_icmpne +9 -> 470
      //   464: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   467: goto +6 -> 473
      //   470: getstatic 136	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   473: astore 13
      //   475: aload 12
      //   477: ldc 120
      //   479: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   482: dup
      //   483: astore 15
      //   485: checkcast 120	java/lang/CharSequence
      //   488: iconst_1
      //   489: aload 13
      //   491: invokevirtual 155	java/lang/Number:intValue	()I
      //   494: iadd
      //   495: aload 12
      //   497: ldc 120
      //   499: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   502: dup
      //   503: astore 15
      //   505: checkcast 120	java/lang/CharSequence
      //   508: invokestatic 161	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   511: invokestatic 164	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   514: astore 14
      //   516: aload 13
      //   518: invokestatic 170	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   521: ifeq +8 -> 529
      //   524: aload 10
      //   526: goto +12 -> 538
      //   529: iconst_m1
      //   530: aload 10
      //   532: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   535: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   538: astore 15
      //   540: aload 12
      //   542: ldc 120
      //   544: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   547: dup
      //   548: astore 16
      //   550: checkcast 120	java/lang/CharSequence
      //   553: aload 13
      //   555: dup
      //   556: astore 16
      //   558: invokevirtual 155	java/lang/Number:intValue	()I
      //   561: iconst_1
      //   562: aload 13
      //   564: invokevirtual 155	java/lang/Number:intValue	()I
      //   567: iadd
      //   568: invokestatic 164	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   571: invokestatic 174	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   574: dup
      //   575: aload 14
      //   577: ldc 49
      //   579: iconst_0
      //   580: anewarray 120	java/lang/CharSequence
      //   583: invokestatic 178	kawa/lib/strings:isString$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
      //   586: ifeq +18 -> 604
      //   589: aload_0
      //   590: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   593: getfield 96	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
      //   596: ifne +8 -> 604
      //   599: ldc 49
      //   601: goto +5 -> 606
      //   604: ldc -76
      //   606: aload 14
      //   608: aload_0
      //   609: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   612: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   615: dup
      //   616: astore 16
      //   618: invokestatic 24	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   621: invokestatic 188	kawa/lib/rnrs/unicode:isCharUpperCase	(I)Z
      //   624: ifeq +8 -> 632
      //   627: ldc -66
      //   629: goto +5 -> 634
      //   632: ldc -64
      //   634: aload 15
      //   636: ldc -62
      //   638: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   641: dup
      //   642: astore 16
      //   644: invokestatic 200	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   647: invokestatic 206	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   650: ifeq +8 -> 658
      //   653: ldc 26
      //   655: goto +5 -> 660
      //   658: ldc 33
      //   660: invokestatic 210	gnu/lists/LList:chain4	(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   663: getstatic 213	gnu/kawa/slib/printf:Lit50	Lgnu/math/IntNum;
      //   666: aload 15
      //   668: getstatic 216	gnu/kawa/slib/printf:Lit51	Lgnu/math/IntNum;
      //   671: iconst_0
      //   672: anewarray 55	java/lang/Object
      //   675: invokestatic 219	gnu/kawa/functions/NumberCompare:$Ls$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
      //   678: ifeq +8 -> 686
      //   681: ldc -35
      //   683: goto +5 -> 688
      //   686: ldc 49
      //   688: invokestatic 225	gnu/lists/LList:chain1	(Lgnu/lists/Pair;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   691: aload 15
      //   693: ldc -104
      //   695: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   698: dup
      //   699: astore 16
      //   701: checkcast 152	java/lang/Number
      //   704: invokestatic 230	kawa/lib/numbers:abs	(Ljava/lang/Number;)Ljava/lang/Number;
      //   707: invokestatic 234	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
      //   710: invokestatic 225	gnu/lists/LList:chain1	(Lgnu/lists/Pair;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   713: pop
      //   714: goto +306 -> 1020
      //   717: aload_0
      //   718: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   721: getstatic 237	gnu/kawa/slib/printf:Lit40	Lgnu/text/Char;
      //   724: invokestatic 71	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   727: ifeq +287 -> 1014
      //   730: aload_3
      //   731: aload 4
      //   733: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   736: goto -349 -> 387
      //   739: aload_0
      //   740: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   743: getstatic 240	gnu/kawa/slib/printf:Lit47	Lgnu/text/Char;
      //   746: invokestatic 71	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   749: ifeq +265 -> 1014
      //   752: aload_3
      //   753: aload 4
      //   755: ldc 49
      //   757: astore 9
      //   759: astore 8
      //   761: astore 7
      //   763: aload 8
      //   765: ldc -62
      //   767: invokestatic 123	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   770: dup
      //   771: astore 12
      //   773: invokestatic 200	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   776: invokestatic 206	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   779: ifeq +24 -> 803
      //   782: getstatic 246	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
      //   785: iconst_m1
      //   786: aload 8
      //   788: getstatic 249	gnu/kawa/slib/printf:Lit52	Lgnu/math/IntNum;
      //   791: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   794: getstatic 249	gnu/kawa/slib/printf:Lit52	Lgnu/math/IntNum;
      //   797: invokevirtual 254	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   800: goto +21 -> 821
      //   803: getstatic 246	gnu/kawa/functions/DivideOp:quotient	Lgnu/kawa/functions/DivideOp;
      //   806: iconst_m1
      //   807: aload 8
      //   809: getstatic 100	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   812: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   815: getstatic 249	gnu/kawa/slib/printf:Lit52	Lgnu/math/IntNum;
      //   818: invokevirtual 254	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   821: astore 11
      //   823: getstatic 257	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
      //   826: iconst_1
      //   827: aload 11
      //   829: getstatic 260	gnu/kawa/slib/printf:Lit46	Lgnu/math/IntNum;
      //   832: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   835: getstatic 264	gnu/kawa/slib/printf:Lit53	Lgnu/lists/FVector;
      //   838: invokestatic 270	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
      //   841: invokestatic 276	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   844: iconst_0
      //   845: anewarray 55	java/lang/Object
      //   848: invokestatic 219	gnu/kawa/functions/NumberCompare:$Ls$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Z
      //   851: ifeq +8 -> 859
      //   854: aload 11
      //   856: goto +6 -> 862
      //   859: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   862: astore 10
      //   864: aload 10
      //   866: invokestatic 31	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   869: ifeq +117 -> 986
      //   872: iconst_m1
      //   873: aload 8
      //   875: getstatic 282	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
      //   878: getstatic 249	gnu/kawa/slib/printf:Lit52	Lgnu/math/IntNum;
      //   881: aload 10
      //   883: invokevirtual 254	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   886: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   889: astore 8
      //   891: aload_0
      //   892: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   895: iconst_2
      //   896: anewarray 55	java/lang/Object
      //   899: dup
      //   900: iconst_0
      //   901: getstatic 136	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   904: aastore
      //   905: dup
      //   906: iconst_1
      //   907: iconst_m1
      //   908: aload_0
      //   909: getfield 39	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
      //   912: getfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   915: aload 8
      //   917: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   920: aastore
      //   921: invokestatic 286	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
      //   924: putfield 103	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   927: iconst_2
      //   928: anewarray 55	java/lang/Object
      //   931: dup
      //   932: iconst_0
      //   933: aload_0
      //   934: aload 7
      //   936: aload 8
      //   938: getstatic 86	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   941: invokevirtual 90	gnu/kawa/slib/printf$frame1:lambda12f	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   944: aastore
      //   945: dup
      //   946: iconst_1
      //   947: aload 9
      //   949: getstatic 264	gnu/kawa/slib/printf:Lit53	Lgnu/lists/FVector;
      //   952: iconst_1
      //   953: aload 10
      //   955: getstatic 260	gnu/kawa/slib/printf:Lit46	Lgnu/math/IntNum;
      //   958: invokestatic 109	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   961: invokestatic 18	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   964: dup
      //   965: astore 11
      //   967: checkcast 152	java/lang/Number
      //   970: invokevirtual 155	java/lang/Number:intValue	()I
      //   973: invokestatic 292	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
      //   976: invokestatic 296	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   979: aastore
      //   980: invokestatic 301	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   983: goto +37 -> 1020
      //   986: aload 7
      //   988: aload 8
      //   990: goto -752 -> 238
      //   993: aload_0
      //   994: getfield 53	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
      //   997: getstatic 304	gnu/kawa/slib/printf:Lit33	Lgnu/text/Char;
      //   1000: invokestatic 71	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   1003: ifeq +11 -> 1014
      //   1006: aload_3
      //   1007: aload 4
      //   1009: ldc 47
      //   1011: goto -254 -> 757
      //   1014: ldc_w 306
      //   1017: goto +3 -> 1020
      //   1020: invokestatic 309	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   1023: goto +50 -> 1073
      //   1026: iconst_3
      //   1027: anewarray 55	java/lang/Object
      //   1030: dup
      //   1031: iconst_0
      //   1032: aload_0
      //   1033: aload_1
      //   1034: aload_2
      //   1035: aload_3
      //   1036: aload 4
      //   1038: iconst_0
      //   1039: anewarray 55	java/lang/Object
      //   1042: invokevirtual 313	gnu/kawa/slib/printf$frame1:lambda11formatReal$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   1045: aastore
      //   1046: dup
      //   1047: iconst_1
      //   1048: getstatic 318	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   1051: aload_0
      //   1052: getfield 322	gnu/kawa/slib/printf$frame1:format$Mnreal	Lgnu/mapping/Procedure;
      //   1055: getstatic 118	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   1058: aload 6
      //   1060: invokevirtual 325	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   1063: aastore
      //   1064: dup
      //   1065: iconst_2
      //   1066: getstatic 329	gnu/kawa/slib/printf:Lit54	Lgnu/lists/PairWithPosition;
      //   1069: aastore
      //   1070: invokestatic 301	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   1073: areturn
      //   1074: new 127	gnu/mapping/WrongType
      //   1077: dup_x1
      //   1078: swap
      //   1079: ldc -127
      //   1081: iconst_0
      //   1082: aload 13
      //   1084: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1087: athrow
      //   1088: new 127	gnu/mapping/WrongType
      //   1091: dup_x1
      //   1092: swap
      //   1093: ldc -114
      //   1095: iconst_1
      //   1096: aload 14
      //   1098: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1101: athrow
      //   1102: new 127	gnu/mapping/WrongType
      //   1105: dup_x1
      //   1106: swap
      //   1107: ldc -106
      //   1109: iconst_1
      //   1110: aload 15
      //   1112: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1115: athrow
      //   1116: new 127	gnu/mapping/WrongType
      //   1119: dup_x1
      //   1120: swap
      //   1121: ldc -99
      //   1123: iconst_1
      //   1124: aload 15
      //   1126: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1129: athrow
      //   1130: new 127	gnu/mapping/WrongType
      //   1133: dup_x1
      //   1134: swap
      //   1135: ldc -106
      //   1137: iconst_1
      //   1138: aload 16
      //   1140: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1143: athrow
      //   1144: new 127	gnu/mapping/WrongType
      //   1147: dup_x1
      //   1148: swap
      //   1149: ldc -106
      //   1151: iconst_2
      //   1152: aload 16
      //   1154: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1157: athrow
      //   1158: new 127	gnu/mapping/WrongType
      //   1161: dup_x1
      //   1162: swap
      //   1163: ldc -74
      //   1165: iconst_1
      //   1166: aload 16
      //   1168: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1171: athrow
      //   1172: new 127	gnu/mapping/WrongType
      //   1175: dup_x1
      //   1176: swap
      //   1177: ldc -54
      //   1179: iconst_1
      //   1180: aload 16
      //   1182: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1185: athrow
      //   1186: new 127	gnu/mapping/WrongType
      //   1189: dup_x1
      //   1190: swap
      //   1191: ldc -29
      //   1193: iconst_1
      //   1194: aload 16
      //   1196: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1199: athrow
      //   1200: new 127	gnu/mapping/WrongType
      //   1203: dup_x1
      //   1204: swap
      //   1205: ldc -54
      //   1207: iconst_1
      //   1208: aload 12
      //   1210: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1213: athrow
      //   1214: new 127	gnu/mapping/WrongType
      //   1217: dup_x1
      //   1218: swap
      //   1219: ldc_w 288
      //   1222: iconst_2
      //   1223: aload 11
      //   1225: invokespecial 133	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1228: athrow
      // Line number table:
      //   Java source line #386	-> byte code offset #0
      //   Java source line #387	-> byte code offset #11
      //   Java source line #388	-> byte code offset #19
      //   Java source line #389	-> byte code offset #19
      //   Java source line #390	-> byte code offset #36
      //   Java source line #391	-> byte code offset #65
      //   Java source line #393	-> byte code offset #210
      //   Java source line #394	-> byte code offset #235
      //   Java source line #346	-> byte code offset #238
      //   Java source line #347	-> byte code offset #242
      //   Java source line #348	-> byte code offset #259
      //   Java source line #349	-> byte code offset #267
      //   Java source line #350	-> byte code offset #300
      //   Java source line #351	-> byte code offset #320
      //   Java source line #353	-> byte code offset #345
      //   Java source line #354	-> byte code offset #366
      //   Java source line #330	-> byte code offset #387
      //   Java source line #331	-> byte code offset #393
      //   Java source line #332	-> byte code offset #393
      //   Java source line #331	-> byte code offset #442
      //   Java source line #333	-> byte code offset #442
      //   Java source line #331	-> byte code offset #475
      //   Java source line #334	-> byte code offset #475
      //   Java source line #335	-> byte code offset #475
      //   Java source line #331	-> byte code offset #516
      //   Java source line #336	-> byte code offset #516
      //   Java source line #337	-> byte code offset #540
      //   Java source line #338	-> byte code offset #540
      //   Java source line #339	-> byte code offset #575
      //   Java source line #342	-> byte code offset #608
      //   Java source line #343	-> byte code offset #634
      //   Java source line #344	-> byte code offset #663
      //   Java source line #345	-> byte code offset #691
      //   Java source line #392	-> byte code offset #730
      //   Java source line #395	-> byte code offset #752
      //   Java source line #355	-> byte code offset #757
      //   Java source line #356	-> byte code offset #763
      //   Java source line #358	-> byte code offset #763
      //   Java source line #356	-> byte code offset #763
      //   Java source line #359	-> byte code offset #763
      //   Java source line #360	-> byte code offset #782
      //   Java source line #361	-> byte code offset #803
      //   Java source line #362	-> byte code offset #823
      //   Java source line #363	-> byte code offset #823
      //   Java source line #362	-> byte code offset #854
      //   Java source line #365	-> byte code offset #864
      //   Java source line #366	-> byte code offset #872
      //   Java source line #367	-> byte code offset #891
      //   Java source line #368	-> byte code offset #927
      //   Java source line #369	-> byte code offset #934
      //   Java source line #371	-> byte code offset #952
      //   Java source line #373	-> byte code offset #986
      //   Java source line #396	-> byte code offset #1006
      //   Java source line #398	-> byte code offset #1026
      //   Java source line #399	-> byte code offset #1051
      //   Java source line #332	-> byte code offset #1074
      //   Java source line #333	-> byte code offset #1088
      //   Java source line #335	-> byte code offset #1102
      //   Java source line #338	-> byte code offset #1130
      //   Java source line #342	-> byte code offset #1158
      //   Java source line #343	-> byte code offset #1172
      //   Java source line #345	-> byte code offset #1186
      //   Java source line #359	-> byte code offset #1200
      //   Java source line #371	-> byte code offset #1214
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1074	0	this	frame1
      //   0	1073	1	signed$Qu	Object
      //   0	1073	2	sgn	Object
      //   0	1073	3	digs	Object
      //   0	1073	4	exp	Object
      //   0	1073	5	argsArray	Object[]
      //   0	1073	6	rest	gnu.lists.LList
      //   242	472	7	digs	Object
      //   763	230	7	digs	Object
      //   242	472	8	exp	Object
      //   763	230	8	exp	Object
      //   259	128	9	strip$Mn0s	boolean
      //   393	321	9	digs	Object
      //   763	230	9	sep	String
      //   393	321	10	exp	Object
      //   864	129	10	uind	Object
      //   393	321	11	strip$Mn0s	Object
      //   823	39	11	i	Object
      //   442	272	12	digs	Object
      //   475	239	13	istrt	gnu.math.IntNum
      //   516	198	14	fdigs	CharSequence
      //   540	174	15	exp	Object
      // Exception table:
      //   from	to	target	type
      //   403	406	1074	java/lang/ClassCastException
      //   454	457	1088	java/lang/ClassCastException
      //   485	488	1102	java/lang/ClassCastException
      //   505	508	1116	java/lang/ClassCastException
      //   550	553	1130	java/lang/ClassCastException
      //   558	561	1144	java/lang/ClassCastException
      //   618	621	1158	java/lang/ClassCastException
      //   644	647	1172	java/lang/ClassCastException
      //   701	704	1186	java/lang/ClassCastException
      //   773	776	1200	java/lang/ClassCastException
      //   967	973	1214	java/lang/ClassCastException
    }
    
    public frame1()
    {
      void tmp37_34 = new ModuleMethod(this, 2, null, 61443);
      tmp37_34.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:402");
      lambda$Fn5 = tmp37_34;
    }
  }
  
  public class frame0
    extends gnu.expr.ModuleBody
  {
    Object os;
    Object pr;
    gnu.mapping.Procedure pad = new ModuleMethod(this, 3, printf.Lit62, 61441);
    boolean alternate$Mnform;
    boolean blank;
    boolean signed;
    Object precision;
    boolean leading$Mn0s;
    boolean left$Mnadjust;
    Object width;
    Object args;
    printf.frame staticLink;
    final ModuleMethod lambda$Fn1;
    final ModuleMethod lambda$Fn2;
    final ModuleMethod lambda$Fn3;
    final ModuleMethod lambda$Fn4;
    
    public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
    {
      if (selector == 3) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
    }
    










































































































































































































































    public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
    {
      switch (selector) {case 7:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 6: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 5: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
      case 4: 
        value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
    Object lambda7(Object s) { try { pr = gnu.kawa.functions.AddOp.apply2(1, pr, Integer.valueOf(kawa.lib.strings.stringLength((CharSequence)(localObject = gnu.mapping.Promise.force(s, CharSequence.class)))));
        return kawa.standard.Scheme.applyToArgs.apply2(staticLink.out, s);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new gnu.mapping.WrongType(
          localClassCastException, "string-length", 1, localObject);
      }
    }
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      switch (selector) {case 4:  return lambda7(paramObject);
      

      case 5: 
        return lambda8(paramObject) ? Boolean.TRUE : Boolean.FALSE;
      





      case 6: 
        return lambda9(paramObject) ? Boolean.TRUE : Boolean.FALSE;
      







      case 7: 
        return lambda10(paramObject) ? Boolean.TRUE : Boolean.FALSE; } return super.apply1(paramModuleMethod, paramObject);
    }
    
    public frame0()
    {
      void tmp37_34 = new ModuleMethod(this, 4, null, 4097);
      tmp37_34.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:473");
      lambda$Fn1 = tmp37_34;
      void tmp64_61 = new ModuleMethod(this, 5, null, 4097);
      tmp64_61.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:477");
      lambda$Fn2 = tmp64_61;
      void tmp92_89 = new ModuleMethod(this, 6, null, 4097);
      tmp92_89.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:485");
      lambda$Fn3 = tmp92_89;
      void tmp120_117 = new ModuleMethod(this, 7, null, 4097);
      tmp120_117.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:495");
      lambda$Fn4 = tmp120_117;
    }
    
    /* Error */
    public Object lambda3pad$V(Object pre, Object[] argsArray)
    {
      // Byte code:
      //   0: aload_2
      //   1: iconst_0
      //   2: invokestatic 6	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
      //   5: dup
      //   6: astore 4
      //   8: astore_3
      //   9: aload_1
      //   10: ldc 8
      //   12: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   15: dup
      //   16: astore 4
      //   18: checkcast 8	java/lang/CharSequence
      //   21: invokestatic 30	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   24: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   27: aload_3
      //   28: astore 5
      //   30: astore 4
      //   32: aload 4
      //   34: aload_0
      //   35: getfield 42	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
      //   38: invokestatic 48	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   41: ifeq +11 -> 52
      //   44: aload_1
      //   45: aload_3
      //   46: invokestatic 54	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   49: goto +210 -> 259
      //   52: aload 5
      //   54: invokestatic 58	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   57: ifeq +144 -> 201
      //   60: aload_0
      //   61: getfield 62	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
      //   64: ifeq +54 -> 118
      //   67: aload_1
      //   68: iconst_2
      //   69: anewarray 64	java/lang/Object
      //   72: dup
      //   73: iconst_0
      //   74: aload_3
      //   75: aastore
      //   76: dup
      //   77: iconst_1
      //   78: iconst_m1
      //   79: aload_0
      //   80: getfield 42	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
      //   83: aload 4
      //   85: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   88: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   91: dup
      //   92: astore 6
      //   94: checkcast 75	java/lang/Number
      //   97: invokevirtual 79	java/lang/Number:intValue	()I
      //   100: bipush 32
      //   102: invokestatic 85	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
      //   105: invokestatic 89	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   108: aastore
      //   109: invokestatic 95	kawa/standard/append:append$V	([Ljava/lang/Object;)Ljava/lang/Object;
      //   112: invokestatic 54	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   115: goto +144 -> 259
      //   118: aload_0
      //   119: getfield 98	gnu/kawa/slib/printf$frame0:leading$Mn0s	Z
      //   122: ifeq +41 -> 163
      //   125: aload_1
      //   126: iconst_m1
      //   127: aload_0
      //   128: getfield 42	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
      //   131: aload 4
      //   133: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   136: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   139: dup
      //   140: astore 6
      //   142: checkcast 75	java/lang/Number
      //   145: invokevirtual 79	java/lang/Number:intValue	()I
      //   148: bipush 48
      //   150: invokestatic 85	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
      //   153: aload_3
      //   154: invokestatic 54	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   157: invokestatic 54	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   160: goto +99 -> 259
      //   163: iconst_m1
      //   164: aload_0
      //   165: getfield 42	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
      //   168: aload 4
      //   170: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   173: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   176: dup
      //   177: astore 6
      //   179: checkcast 75	java/lang/Number
      //   182: invokevirtual 79	java/lang/Number:intValue	()I
      //   185: bipush 32
      //   187: invokestatic 85	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
      //   190: aload_1
      //   191: aload_3
      //   192: invokestatic 54	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   195: invokestatic 54	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
      //   198: goto +61 -> 259
      //   201: iconst_1
      //   202: aload 4
      //   204: aload 5
      //   206: ldc 100
      //   208: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   211: dup
      //   212: astore 6
      //   214: checkcast 100	gnu/lists/Pair
      //   217: invokestatic 105	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   220: ldc 8
      //   222: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   225: dup
      //   226: astore 6
      //   228: checkcast 8	java/lang/CharSequence
      //   231: invokestatic 30	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   234: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   237: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   240: aload 5
      //   242: ldc 100
      //   244: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   247: dup
      //   248: astore 6
      //   250: checkcast 100	gnu/lists/Pair
      //   253: invokestatic 109	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   256: goto -228 -> 28
      //   259: areturn
      //   260: new 18	gnu/mapping/WrongType
      //   263: dup_x1
      //   264: swap
      //   265: ldc 20
      //   267: iconst_1
      //   268: aload 4
      //   270: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   273: athrow
      //   274: new 18	gnu/mapping/WrongType
      //   277: dup_x1
      //   278: swap
      //   279: ldc 81
      //   281: iconst_1
      //   282: aload 6
      //   284: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   287: athrow
      //   288: new 18	gnu/mapping/WrongType
      //   291: dup_x1
      //   292: swap
      //   293: ldc 81
      //   295: iconst_1
      //   296: aload 6
      //   298: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   301: athrow
      //   302: new 18	gnu/mapping/WrongType
      //   305: dup_x1
      //   306: swap
      //   307: ldc 81
      //   309: iconst_1
      //   310: aload 6
      //   312: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   315: athrow
      //   316: new 18	gnu/mapping/WrongType
      //   319: dup_x1
      //   320: swap
      //   321: ldc 102
      //   323: iconst_1
      //   324: aload 6
      //   326: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   329: athrow
      //   330: new 18	gnu/mapping/WrongType
      //   333: dup_x1
      //   334: swap
      //   335: ldc 20
      //   337: iconst_1
      //   338: aload 6
      //   340: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   343: athrow
      //   344: new 18	gnu/mapping/WrongType
      //   347: dup_x1
      //   348: swap
      //   349: ldc 107
      //   351: iconst_1
      //   352: aload 6
      //   354: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   357: athrow
      // Line number table:
      //   Java source line #256	-> byte code offset #0
      //   Java source line #257	-> byte code offset #9
      //   Java source line #259	-> byte code offset #32
      //   Java source line #260	-> byte code offset #52
      //   Java source line #261	-> byte code offset #60
      //   Java source line #262	-> byte code offset #67
      //   Java source line #263	-> byte code offset #68
      //   Java source line #265	-> byte code offset #78
      //   Java source line #267	-> byte code offset #125
      //   Java source line #268	-> byte code offset #126
      //   Java source line #269	-> byte code offset #153
      //   Java source line #271	-> byte code offset #163
      //   Java source line #272	-> byte code offset #190
      //   Java source line #274	-> byte code offset #201
      //   Java source line #257	-> byte code offset #260
      //   Java source line #265	-> byte code offset #274
      //   Java source line #268	-> byte code offset #288
      //   Java source line #271	-> byte code offset #302
      //   Java source line #274	-> byte code offset #316
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	260	0	this	frame0
      //   0	259	1	pre	Object
      //   0	259	2	argsArray	Object[]
      //   0	192	3	strs	gnu.lists.LList
      //   6	11	4	localObject1	Object
      //   30	239	4	len	Object
      //   28	1	5	localLList1	gnu.lists.LList
      //   32	209	5	ss	Object
      //   92	261	6	localObject2	Object
      //   260	1	9	localClassCastException1	ClassCastException
      //   274	1	10	localClassCastException2	ClassCastException
      //   288	1	11	localClassCastException3	ClassCastException
      //   302	1	12	localClassCastException4	ClassCastException
      //   316	1	13	localClassCastException5	ClassCastException
      //   330	1	14	localClassCastException6	ClassCastException
      //   344	1	15	localClassCastException7	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   18	21	260	java/lang/ClassCastException
      //   94	100	274	java/lang/ClassCastException
      //   142	148	288	java/lang/ClassCastException
      //   179	185	302	java/lang/ClassCastException
      //   214	217	316	java/lang/ClassCastException
      //   228	231	330	java/lang/ClassCastException
      //   250	253	344	java/lang/ClassCastException
    }
    
    /* Error */
    public Object lambda4readFormatNumber(Object fl)
    {
      // Byte code:
      //   0: getstatic 186	gnu/kawa/slib/printf:Lit61	Lgnu/text/Char;
      //   3: aload_0
      //   4: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   7: getfield 189	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
      //   10: invokestatic 194	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   13: ifeq +54 -> 67
      //   16: aload_0
      //   17: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   20: aload_1
      //   21: invokevirtual 198	gnu/kawa/slib/printf$frame:lambda2mustAdvance	(Ljava/lang/Object;)V
      //   24: aload_0
      //   25: getfield 201	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
      //   28: ldc 100
      //   30: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   33: dup
      //   34: astore_3
      //   35: checkcast 100	gnu/lists/Pair
      //   38: invokestatic 105	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   41: astore_2
      //   42: aload_0
      //   43: aload_0
      //   44: getfield 201	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
      //   47: ldc 100
      //   49: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   52: dup
      //   53: astore_3
      //   54: checkcast 100	gnu/lists/Pair
      //   57: invokestatic 109	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   60: putfield 201	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
      //   63: aload_2
      //   64: goto +99 -> 163
      //   67: aload_0
      //   68: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   71: getfield 189	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
      //   74: getstatic 159	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   77: astore_3
      //   78: astore_2
      //   79: aload_0
      //   80: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   83: getfield 189	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
      //   86: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   89: dup
      //   90: astore 4
      //   92: invokestatic 207	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   95: invokestatic 215	kawa/lib/rnrs/unicode:isCharNumeric	(I)Z
      //   98: ifeq +64 -> 162
      //   101: aload_0
      //   102: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   105: aload_1
      //   106: invokevirtual 198	gnu/kawa/slib/printf$frame:lambda2mustAdvance	(Ljava/lang/Object;)V
      //   109: aload_0
      //   110: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   113: getfield 189	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
      //   116: iconst_1
      //   117: getstatic 221	gnu/kawa/functions/MultiplyOp:$St	Lgnu/kawa/functions/MultiplyOp;
      //   120: aload_3
      //   121: getstatic 224	gnu/kawa/slib/printf:Lit51	Lgnu/math/IntNum;
      //   124: invokevirtual 132	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   127: aload_2
      //   128: dup
      //   129: instanceof 226
      //   132: ifeq +9 -> 141
      //   135: checkcast 226	[Ljava/lang/Object;
      //   138: goto +12 -> 150
      //   141: iconst_1
      //   142: anewarray 64	java/lang/Object
      //   145: dup_x1
      //   146: swap
      //   147: iconst_0
      //   148: swap
      //   149: aastore
      //   150: invokestatic 230	kawa/lib/strings:$make$string$	([Ljava/lang/Object;)Ljava/lang/CharSequence;
      //   153: invokestatic 234	kawa/lib/numbers:string$To$Number	(Ljava/lang/CharSequence;)Ljava/lang/Object;
      //   156: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   159: goto -82 -> 77
      //   162: aload_3
      //   163: areturn
      //   164: new 18	gnu/mapping/WrongType
      //   167: dup_x1
      //   168: swap
      //   169: ldc 102
      //   171: iconst_1
      //   172: aload_3
      //   173: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   176: athrow
      //   177: new 18	gnu/mapping/WrongType
      //   180: dup_x1
      //   181: swap
      //   182: ldc 107
      //   184: iconst_1
      //   185: aload_3
      //   186: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   189: athrow
      //   190: new 18	gnu/mapping/WrongType
      //   193: dup_x1
      //   194: swap
      //   195: ldc -47
      //   197: iconst_1
      //   198: aload 4
      //   200: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   203: athrow
      // Line number table:
      //   Java source line #243	-> byte code offset #0
      //   Java source line #244	-> byte code offset #0
      //   Java source line #245	-> byte code offset #0
      //   Java source line #246	-> byte code offset #16
      //   Java source line #247	-> byte code offset #24
      //   Java source line #248	-> byte code offset #42
      //   Java source line #249	-> byte code offset #63
      //   Java source line #251	-> byte code offset #67
      //   Java source line #254	-> byte code offset #79
      //   Java source line #255	-> byte code offset #101
      //   Java source line #252	-> byte code offset #116
      //   Java source line #253	-> byte code offset #127
      //   Java source line #251	-> byte code offset #162
      //   Java source line #254	-> byte code offset #162
      //   Java source line #247	-> byte code offset #164
      //   Java source line #248	-> byte code offset #177
      //   Java source line #254	-> byte code offset #190
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	164	0	this	frame0
      //   0	163	1	fl	Object
      //   41	23	2	ans	Object
      //   78	50	2	c	Object
      //   34	44	3	localObject1	Object
      //   79	107	3	accum	Object
      //   90	109	4	localObject2	Object
      //   164	1	7	localClassCastException1	ClassCastException
      //   177	1	8	localClassCastException2	ClassCastException
      //   190	1	9	localClassCastException3	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   35	38	164	java/lang/ClassCastException
      //   54	57	177	java/lang/ClassCastException
      //   92	95	190	java/lang/ClassCastException
    }
    
    /* Error */
    public Object lambda6integerConvert(Object s, gnu.math.IntNum radix, Object fixcase)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 237	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   4: ldc -122
      //   6: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   9: dup
      //   10: astore 4
      //   12: invokestatic 140	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   15: invokestatic 148	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   18: ifne +45 -> 63
      //   21: aload_0
      //   22: iconst_0
      //   23: putfield 98	gnu/kawa/slib/printf$frame0:leading$Mn0s	Z
      //   26: aload_0
      //   27: getfield 237	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   30: ldc 75
      //   32: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   35: dup
      //   36: astore 4
      //   38: checkcast 75	java/lang/Number
      //   41: invokestatic 243	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
      //   44: ifeq +19 -> 63
      //   47: getstatic 159	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   50: aload_1
      //   51: invokestatic 194	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   54: ifeq +9 -> 63
      //   57: ldc -11
      //   59: astore_1
      //   60: goto +3 -> 63
      //   63: aload_1
      //   64: invokestatic 250	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
      //   67: ifeq +21 -> 88
      //   70: aload_1
      //   71: ldc -4
      //   73: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   76: dup
      //   77: astore 4
      //   79: checkcast 252	gnu/mapping/Symbol
      //   82: invokestatic 258	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
      //   85: goto +89 -> 174
      //   88: aload_1
      //   89: invokestatic 261	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
      //   92: ifeq +28 -> 120
      //   95: aload_1
      //   96: ldc 75
      //   98: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   101: dup
      //   102: astore 4
      //   104: checkcast 75	java/lang/Number
      //   107: aload_2
      //   108: dup
      //   109: astore 4
      //   111: invokevirtual 79	java/lang/Number:intValue	()I
      //   114: invokestatic 267	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;I)Ljava/lang/CharSequence;
      //   117: goto +57 -> 174
      //   120: aload_1
      //   121: invokestatic 172	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   124: ifeq +7 -> 131
      //   127: iconst_0
      //   128: goto +4 -> 132
      //   131: iconst_1
      //   132: istore 4
      //   134: iload 4
      //   136: ifeq +11 -> 147
      //   139: iload 4
      //   141: ifeq +19 -> 160
      //   144: goto +10 -> 154
      //   147: aload_1
      //   148: invokestatic 58	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   151: ifeq +9 -> 160
      //   154: ldc_w 269
      //   157: goto +17 -> 174
      //   160: aload_1
      //   161: invokestatic 272	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
      //   164: ifeq +7 -> 171
      //   167: aload_1
      //   168: goto +6 -> 174
      //   171: ldc_w 274
      //   174: astore_1
      //   175: aload_3
      //   176: invokestatic 172	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   179: ifeq +12 -> 191
      //   182: getstatic 118	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   185: aload_3
      //   186: aload_1
      //   187: invokevirtual 132	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   190: astore_1
      //   191: getstatic 278	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
      //   194: ldc -11
      //   196: aload_1
      //   197: invokevirtual 132	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   200: invokestatic 172	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   203: ifeq +8 -> 211
      //   206: ldc -11
      //   208: goto +171 -> 379
      //   211: getstatic 281	gnu/kawa/slib/printf:Lit18	Lgnu/text/Char;
      //   214: aload_1
      //   215: ldc 8
      //   217: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   220: dup
      //   221: astore 5
      //   223: checkcast 8	java/lang/CharSequence
      //   226: iconst_0
      //   227: invokestatic 287	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   230: invokestatic 291	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   233: invokestatic 194	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   236: ifeq +41 -> 277
      //   239: aload_1
      //   240: ldc 8
      //   242: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   245: dup
      //   246: astore 5
      //   248: checkcast 8	java/lang/CharSequence
      //   251: iconst_1
      //   252: aload_1
      //   253: ldc 8
      //   255: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   258: dup
      //   259: astore 5
      //   261: checkcast 8	java/lang/CharSequence
      //   264: invokestatic 30	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   267: invokestatic 153	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   270: astore_1
      //   271: ldc_w 293
      //   274: goto +105 -> 379
      //   277: aload_0
      //   278: getfield 296	gnu/kawa/slib/printf$frame0:signed	Z
      //   281: ifeq +9 -> 290
      //   284: ldc_w 298
      //   287: goto +92 -> 379
      //   290: aload_0
      //   291: getfield 301	gnu/kawa/slib/printf$frame0:blank	Z
      //   294: ifeq +9 -> 303
      //   297: ldc_w 303
      //   300: goto +79 -> 379
      //   303: aload_0
      //   304: getfield 306	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
      //   307: ifeq +70 -> 377
      //   310: aload_2
      //   311: invokevirtual 309	java/lang/Object:hashCode	()I
      //   314: lookupswitch	default:+58->372, 8:+42->356, 16:+26->340
      //   340: aload_2
      //   341: getstatic 312	gnu/kawa/slib/printf:Lit37	Lgnu/math/IntNum;
      //   344: invokestatic 194	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   347: ifeq +25 -> 372
      //   350: ldc_w 314
      //   353: goto +26 -> 379
      //   356: aload_2
      //   357: getstatic 317	gnu/kawa/slib/printf:Lit46	Lgnu/math/IntNum;
      //   360: invokestatic 194	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   363: ifeq +9 -> 372
      //   366: ldc_w 269
      //   369: goto +10 -> 379
      //   372: ldc -11
      //   374: goto +5 -> 379
      //   377: ldc -11
      //   379: astore 4
      //   381: aload_0
      //   382: aload 4
      //   384: iconst_2
      //   385: anewarray 64	java/lang/Object
      //   388: dup
      //   389: iconst_0
      //   390: aload_1
      //   391: ldc 8
      //   393: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   396: dup
      //   397: astore 5
      //   399: checkcast 8	java/lang/CharSequence
      //   402: invokestatic 30	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   405: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   408: aload_0
      //   409: getfield 237	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   412: invokestatic 320	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   415: ifeq +49 -> 464
      //   418: iconst_m1
      //   419: aload_0
      //   420: getfield 237	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
      //   423: aload_1
      //   424: ldc 8
      //   426: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   429: dup
      //   430: astore 5
      //   432: checkcast 8	java/lang/CharSequence
      //   435: invokestatic 30	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   438: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   441: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   444: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   447: dup
      //   448: astore 5
      //   450: checkcast 75	java/lang/Number
      //   453: invokevirtual 79	java/lang/Number:intValue	()I
      //   456: bipush 48
      //   458: invokestatic 85	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
      //   461: goto +5 -> 466
      //   464: ldc -11
      //   466: aastore
      //   467: dup
      //   468: iconst_1
      //   469: aload_1
      //   470: aastore
      //   471: invokevirtual 324	gnu/kawa/slib/printf$frame0:lambda3pad$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   474: areturn
      //   475: new 18	gnu/mapping/WrongType
      //   478: dup_x1
      //   479: swap
      //   480: ldc -114
      //   482: iconst_1
      //   483: aload 4
      //   485: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   488: athrow
      //   489: new 18	gnu/mapping/WrongType
      //   492: dup_x1
      //   493: swap
      //   494: ldc -17
      //   496: iconst_1
      //   497: aload 4
      //   499: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   502: athrow
      //   503: new 18	gnu/mapping/WrongType
      //   506: dup_x1
      //   507: swap
      //   508: ldc -2
      //   510: iconst_1
      //   511: aload 4
      //   513: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   516: athrow
      //   517: new 18	gnu/mapping/WrongType
      //   520: dup_x1
      //   521: swap
      //   522: ldc_w 263
      //   525: iconst_1
      //   526: aload 4
      //   528: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   531: athrow
      //   532: new 18	gnu/mapping/WrongType
      //   535: dup_x1
      //   536: swap
      //   537: ldc_w 263
      //   540: iconst_2
      //   541: aload 4
      //   543: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   546: athrow
      //   547: new 18	gnu/mapping/WrongType
      //   550: dup_x1
      //   551: swap
      //   552: ldc_w 283
      //   555: iconst_1
      //   556: aload 5
      //   558: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   561: athrow
      //   562: new 18	gnu/mapping/WrongType
      //   565: dup_x1
      //   566: swap
      //   567: ldc -106
      //   569: iconst_1
      //   570: aload 5
      //   572: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   575: athrow
      //   576: new 18	gnu/mapping/WrongType
      //   579: dup_x1
      //   580: swap
      //   581: ldc 20
      //   583: iconst_1
      //   584: aload 5
      //   586: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   589: athrow
      //   590: new 18	gnu/mapping/WrongType
      //   593: dup_x1
      //   594: swap
      //   595: ldc 20
      //   597: iconst_1
      //   598: aload 5
      //   600: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   603: athrow
      //   604: new 18	gnu/mapping/WrongType
      //   607: dup_x1
      //   608: swap
      //   609: ldc 20
      //   611: iconst_1
      //   612: aload 5
      //   614: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   617: athrow
      //   618: new 18	gnu/mapping/WrongType
      //   621: dup_x1
      //   622: swap
      //   623: ldc 81
      //   625: iconst_1
      //   626: aload 5
      //   628: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   631: athrow
      // Line number table:
      //   Java source line #276	-> byte code offset #0
      //   Java source line #277	-> byte code offset #0
      //   Java source line #278	-> byte code offset #21
      //   Java source line #279	-> byte code offset #26
      //   Java source line #280	-> byte code offset #47
      //   Java source line #281	-> byte code offset #57
      //   Java source line #282	-> byte code offset #63
      //   Java source line #283	-> byte code offset #88
      //   Java source line #284	-> byte code offset #120
      //   Java source line #285	-> byte code offset #160
      //   Java source line #286	-> byte code offset #171
      //   Java source line #287	-> byte code offset #175
      //   Java source line #288	-> byte code offset #191
      //   Java source line #289	-> byte code offset #211
      //   Java source line #290	-> byte code offset #239
      //   Java source line #291	-> byte code offset #271
      //   Java source line #292	-> byte code offset #284
      //   Java source line #293	-> byte code offset #297
      //   Java source line #295	-> byte code offset #310
      //   Java source line #299	-> byte code offset #377
      //   Java source line #300	-> byte code offset #381
      //   Java source line #301	-> byte code offset #390
      //   Java source line #302	-> byte code offset #418
      //   Java source line #303	-> byte code offset #418
      //   Java source line #301	-> byte code offset #464
      //   Java source line #277	-> byte code offset #475
      //   Java source line #279	-> byte code offset #489
      //   Java source line #282	-> byte code offset #503
      //   Java source line #283	-> byte code offset #517
      //   Java source line #289	-> byte code offset #547
      //   Java source line #290	-> byte code offset #562
      //   Java source line #301	-> byte code offset #590
      //   Java source line #303	-> byte code offset #604
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	475	0	this	frame0
      //   0	474	1	s	Object
      //   0	474	2	radix	gnu.math.IntNum
      //   0	474	3	fixcase	Object
      //   10	100	4	localObject1	Object
      //   132	8	4	x	boolean
      //   379	163	4	pre	String
      //   221	406	5	localObject2	Object
      //   475	1	8	localClassCastException1	ClassCastException
      //   489	1	9	localClassCastException2	ClassCastException
      //   503	1	10	localClassCastException3	ClassCastException
      //   517	1	11	localClassCastException4	ClassCastException
      //   532	1	12	localClassCastException5	ClassCastException
      //   547	1	13	localClassCastException6	ClassCastException
      //   562	1	14	localClassCastException7	ClassCastException
      //   576	1	15	localClassCastException8	ClassCastException
      //   590	1	16	localClassCastException9	ClassCastException
      //   604	1	17	localClassCastException10	ClassCastException
      //   618	1	18	localClassCastException11	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   12	15	475	java/lang/ClassCastException
      //   38	41	489	java/lang/ClassCastException
      //   79	82	503	java/lang/ClassCastException
      //   104	107	517	java/lang/ClassCastException
      //   111	114	532	java/lang/ClassCastException
      //   223	226	547	java/lang/ClassCastException
      //   248	251	562	java/lang/ClassCastException
      //   261	264	576	java/lang/ClassCastException
      //   399	402	590	java/lang/ClassCastException
      //   432	435	604	java/lang/ClassCastException
      //   450	456	618	java/lang/ClassCastException
    }
    
    /* Error */
    boolean lambda8(Object s)
    {
      // Byte code:
      //   0: iconst_m1
      //   1: aload_0
      //   2: getfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   5: aload_1
      //   6: ldc 8
      //   8: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   11: dup
      //   12: astore_3
      //   13: checkcast 8	java/lang/CharSequence
      //   16: invokestatic 30	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   19: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   22: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   25: astore_2
      //   26: aload_0
      //   27: aload_2
      //   28: ldc -122
      //   30: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   33: dup
      //   34: astore_3
      //   35: invokestatic 140	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   38: invokestatic 148	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   41: ifeq +53 -> 94
      //   44: getstatic 118	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   47: aload_0
      //   48: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   51: getfield 127	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
      //   54: aload_1
      //   55: ldc 8
      //   57: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   60: dup
      //   61: astore_3
      //   62: checkcast 8	java/lang/CharSequence
      //   65: iconst_0
      //   66: aload_0
      //   67: getfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   70: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   73: dup
      //   74: astore_3
      //   75: checkcast 75	java/lang/Number
      //   78: invokevirtual 79	java/lang/Number:intValue	()I
      //   81: invokestatic 153	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   84: invokevirtual 132	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   87: pop
      //   88: getstatic 159	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   91: goto +19 -> 110
      //   94: getstatic 118	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   97: aload_0
      //   98: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   101: getfield 127	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
      //   104: aload_1
      //   105: invokevirtual 132	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   108: pop
      //   109: aload_2
      //   110: putfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   113: aload_2
      //   114: ldc -122
      //   116: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   119: dup
      //   120: astore_3
      //   121: invokestatic 140	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   124: invokestatic 164	kawa/lib/numbers:isPositive	(Lgnu/math/RealNum;)Z
      //   127: ireturn
      //   128: new 18	gnu/mapping/WrongType
      //   131: dup_x1
      //   132: swap
      //   133: ldc 20
      //   135: iconst_1
      //   136: aload_3
      //   137: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   140: athrow
      //   141: new 18	gnu/mapping/WrongType
      //   144: dup_x1
      //   145: swap
      //   146: ldc -114
      //   148: iconst_1
      //   149: aload_3
      //   150: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   153: athrow
      //   154: new 18	gnu/mapping/WrongType
      //   157: dup_x1
      //   158: swap
      //   159: ldc -106
      //   161: iconst_1
      //   162: aload_3
      //   163: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   166: athrow
      //   167: new 18	gnu/mapping/WrongType
      //   170: dup_x1
      //   171: swap
      //   172: ldc -106
      //   174: iconst_3
      //   175: aload_3
      //   176: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   179: athrow
      //   180: new 18	gnu/mapping/WrongType
      //   183: dup_x1
      //   184: swap
      //   185: ldc -95
      //   187: iconst_1
      //   188: aload_3
      //   189: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   192: athrow
      // Line number table:
      //   Java source line #477	-> byte code offset #0
      //   Java source line #478	-> byte code offset #0
      //   Java source line #479	-> byte code offset #26
      //   Java source line #480	-> byte code offset #44
      //   Java source line #481	-> byte code offset #94
      //   Java source line #482	-> byte code offset #113
      //   Java source line #478	-> byte code offset #128
      //   Java source line #479	-> byte code offset #141
      //   Java source line #480	-> byte code offset #154
      //   Java source line #482	-> byte code offset #180
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	128	0	this	frame0
      //   0	127	1	s	Object
      //   0	114	2	sl	Object
      //   12	177	3	localObject1	Object
      //   128	1	4	localClassCastException1	ClassCastException
      //   141	1	5	localClassCastException2	ClassCastException
      //   154	1	6	localClassCastException3	ClassCastException
      //   167	1	7	localClassCastException4	ClassCastException
      //   180	1	8	localClassCastException5	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   13	16	128	java/lang/ClassCastException
      //   35	38	141	java/lang/ClassCastException
      //   62	65	154	java/lang/ClassCastException
      //   75	81	167	java/lang/ClassCastException
      //   121	124	180	java/lang/ClassCastException
    }
    
    /* Error */
    boolean lambda9(Object s)
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_m1
      //   2: aload_0
      //   3: getfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   6: aload_1
      //   7: ldc 8
      //   9: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   12: dup
      //   13: astore_2
      //   14: checkcast 8	java/lang/CharSequence
      //   17: invokestatic 30	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   20: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   23: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   26: putfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   29: aload_0
      //   30: getfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   33: invokestatic 172	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   36: ifne +21 -> 57
      //   39: getstatic 118	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   42: aload_0
      //   43: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   46: getfield 127	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
      //   49: aload_1
      //   50: invokevirtual 132	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   53: pop
      //   54: goto +88 -> 142
      //   57: aload_0
      //   58: getfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   61: ldc -122
      //   63: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   66: dup
      //   67: astore_2
      //   68: invokestatic 140	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   71: invokestatic 148	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   74: ifeq +46 -> 120
      //   77: getstatic 118	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   80: aload_0
      //   81: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   84: getfield 127	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
      //   87: aload_0
      //   88: getfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   91: invokevirtual 132	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   94: pop
      //   95: aload_0
      //   96: getstatic 178	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   99: putfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   102: getstatic 118	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   105: aload_0
      //   106: getfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
      //   109: getfield 127	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
      //   112: aload_1
      //   113: invokevirtual 132	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   116: pop
      //   117: goto +25 -> 142
      //   120: aload_0
      //   121: iconst_2
      //   122: anewarray 64	java/lang/Object
      //   125: dup
      //   126: iconst_0
      //   127: aload_0
      //   128: getfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   131: aastore
      //   132: dup
      //   133: iconst_1
      //   134: aload_1
      //   135: aastore
      //   136: invokestatic 182	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   139: putfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   142: iconst_1
      //   143: ireturn
      //   144: new 18	gnu/mapping/WrongType
      //   147: dup_x1
      //   148: swap
      //   149: ldc 20
      //   151: iconst_1
      //   152: aload_2
      //   153: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   156: athrow
      //   157: new 18	gnu/mapping/WrongType
      //   160: dup_x1
      //   161: swap
      //   162: ldc -114
      //   164: iconst_1
      //   165: aload_2
      //   166: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   169: athrow
      // Line number table:
      //   Java source line #485	-> byte code offset #0
      //   Java source line #486	-> byte code offset #0
      //   Java source line #487	-> byte code offset #29
      //   Java source line #488	-> byte code offset #57
      //   Java source line #489	-> byte code offset #77
      //   Java source line #490	-> byte code offset #95
      //   Java source line #491	-> byte code offset #102
      //   Java source line #492	-> byte code offset #120
      //   Java source line #486	-> byte code offset #144
      //   Java source line #488	-> byte code offset #157
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	this	frame0
      //   0	143	1	s	Object
      //   13	153	2	localObject	Object
      //   144	1	3	localClassCastException1	ClassCastException
      //   157	1	4	localClassCastException2	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   14	17	144	java/lang/ClassCastException
      //   68	71	157	java/lang/ClassCastException
    }
    
    /* Error */
    boolean lambda10(Object s)
    {
      // Byte code:
      //   0: iconst_m1
      //   1: aload_0
      //   2: getfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   5: aload_1
      //   6: ldc 8
      //   8: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   11: dup
      //   12: astore_3
      //   13: checkcast 8	java/lang/CharSequence
      //   16: invokestatic 30	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   19: invokestatic 36	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   22: invokestatic 70	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   25: astore_2
      //   26: aload_2
      //   27: ldc -122
      //   29: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   32: dup
      //   33: astore_3
      //   34: invokestatic 140	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   37: invokestatic 148	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
      //   40: ifeq +57 -> 97
      //   43: aload_0
      //   44: iconst_2
      //   45: anewarray 64	java/lang/Object
      //   48: dup
      //   49: iconst_0
      //   50: aload_0
      //   51: getfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   54: aastore
      //   55: dup
      //   56: iconst_1
      //   57: aload_1
      //   58: ldc 8
      //   60: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   63: dup
      //   64: astore_3
      //   65: checkcast 8	java/lang/CharSequence
      //   68: iconst_0
      //   69: aload_0
      //   70: getfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   73: invokestatic 73	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   76: dup
      //   77: astore_3
      //   78: checkcast 75	java/lang/Number
      //   81: invokevirtual 79	java/lang/Number:intValue	()I
      //   84: invokestatic 153	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   87: aastore
      //   88: invokestatic 182	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   91: putfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   94: goto +25 -> 119
      //   97: aload_0
      //   98: iconst_2
      //   99: anewarray 64	java/lang/Object
      //   102: dup
      //   103: iconst_0
      //   104: aload_0
      //   105: getfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   108: aastore
      //   109: dup
      //   110: iconst_1
      //   111: aload_1
      //   112: aastore
      //   113: invokestatic 182	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   116: putfield 167	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
      //   119: aload_0
      //   120: aload_2
      //   121: putfield 112	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
      //   124: aload_2
      //   125: ldc -122
      //   127: invokestatic 14	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   130: dup
      //   131: astore_3
      //   132: invokestatic 140	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
      //   135: invokestatic 164	kawa/lib/numbers:isPositive	(Lgnu/math/RealNum;)Z
      //   138: ireturn
      //   139: new 18	gnu/mapping/WrongType
      //   142: dup_x1
      //   143: swap
      //   144: ldc 20
      //   146: iconst_1
      //   147: aload_3
      //   148: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   151: athrow
      //   152: new 18	gnu/mapping/WrongType
      //   155: dup_x1
      //   156: swap
      //   157: ldc -114
      //   159: iconst_1
      //   160: aload_3
      //   161: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   164: athrow
      //   165: new 18	gnu/mapping/WrongType
      //   168: dup_x1
      //   169: swap
      //   170: ldc -106
      //   172: iconst_1
      //   173: aload_3
      //   174: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   177: athrow
      //   178: new 18	gnu/mapping/WrongType
      //   181: dup_x1
      //   182: swap
      //   183: ldc -106
      //   185: iconst_3
      //   186: aload_3
      //   187: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   190: athrow
      //   191: new 18	gnu/mapping/WrongType
      //   194: dup_x1
      //   195: swap
      //   196: ldc -95
      //   198: iconst_1
      //   199: aload_3
      //   200: invokespecial 24	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   203: athrow
      // Line number table:
      //   Java source line #495	-> byte code offset #0
      //   Java source line #496	-> byte code offset #0
      //   Java source line #497	-> byte code offset #26
      //   Java source line #498	-> byte code offset #43
      //   Java source line #499	-> byte code offset #57
      //   Java source line #500	-> byte code offset #97
      //   Java source line #501	-> byte code offset #119
      //   Java source line #502	-> byte code offset #124
      //   Java source line #496	-> byte code offset #139
      //   Java source line #497	-> byte code offset #152
      //   Java source line #499	-> byte code offset #165
      //   Java source line #502	-> byte code offset #191
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	139	0	this	frame0
      //   0	138	1	s	Object
      //   0	125	2	sl	Object
      //   12	188	3	localObject1	Object
      //   139	1	4	localClassCastException1	ClassCastException
      //   152	1	5	localClassCastException2	ClassCastException
      //   165	1	6	localClassCastException3	ClassCastException
      //   178	1	7	localClassCastException4	ClassCastException
      //   191	1	8	localClassCastException5	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   13	16	139	java/lang/ClassCastException
      //   34	37	152	java/lang/ClassCastException
      //   65	68	165	java/lang/ClassCastException
      //   78	84	178	java/lang/ClassCastException
      //   132	135	191	java/lang/ClassCastException
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
      //   1: getfield 375	gnu/expr/ModuleMethod:selector	I
      //   4: iconst_3
      //   5: if_icmpne +41 -> 46
      //   8: goto +3 -> 11
      //   11: aload_0
      //   12: aload_2
      //   13: iconst_0
      //   14: aaload
      //   15: aload_2
      //   16: arraylength
      //   17: iconst_1
      //   18: isub
      //   19: istore_3
      //   20: iload_3
      //   21: anewarray 64	java/lang/Object
      //   24: goto +11 -> 35
      //   27: dup
      //   28: iload_3
      //   29: aload_2
      //   30: iload_3
      //   31: iconst_1
      //   32: iadd
      //   33: aaload
      //   34: aastore
      //   35: iinc 3 -1
      //   38: iload_3
      //   39: ifge -12 -> 27
      //   42: invokevirtual 324	gnu/kawa/slib/printf$frame0:lambda3pad$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   45: areturn
      //   46: aload_0
      //   47: aload_1
      //   48: aload_2
      //   49: invokespecial 423	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
      //   52: areturn
      // Line number table:
      //   Java source line #256	-> byte code offset #11
    }
  }
  
  public class frame2
    extends gnu.expr.ModuleBody
  {
    Object port;
    gnu.math.IntNum cnt;
    final ModuleMethod lambda$Fn6;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 8) return lambda15(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 8) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
    boolean lambda15(Object x) { if (kawa.lib.strings.isString(x)) {}
      try { cnt = gnu.math.IntNum.add(cnt, kawa.lib.strings.stringLength((CharSequence)(localObject = gnu.mapping.Promise.force(x, CharSequence.class))));kawa.lib.ports.display(x, port);tmpTernaryOp = true;
        break label65; cnt = gnu.math.IntNum.add(cnt, 1);kawa.lib.ports.display(x, port); label65: return true;
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new gnu.mapping.WrongType(
          localClassCastException, "string-length", 1, localObject);
      }
    }
    
    public frame2()
    {
      void tmp19_16 = new ModuleMethod(this, 8, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:547");
      lambda$Fn6 = tmp19_16;
    }
  }
  
  public static gnu.math.IntNum fprintf$V(Object port, Object format, Object[] argsArray)
  {
    frame2 $heapFrame = new frame2();port = port; gnu.lists.LList localLList1; gnu.lists.LList args = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    cnt = Lit13;
    kawa.standard.Scheme.apply
    



      .apply4(stdio$Cliprintf, lambda$Fn6, format, args);
    return cnt; }
  
  public static Object printf$V(Object format, Object[] argsArray) { gnu.lists.LList localLList1; gnu.lists.LList args = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    return kawa.standard.Scheme.apply.apply4(fprintf, (gnu.kawa.io.OutPort)kawa.lib.ports.current$Mnoutput$Mnport.getValue(), format, args);
  }
  
  /* Error */
  static Object stdio$ClIprintf$V(Object out, Object formatString, Object[] argsArray)
  {
    // Byte code:
    //   0: new 38	gnu/kawa/slib/printf$frame
    //   3: dup
    //   4: invokespecial 42	gnu/kawa/slib/printf$frame:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: putfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   15: aload 4
    //   17: aload_1
    //   18: putfield 49	gnu/kawa/slib/printf$frame:format$Mnstring	Ljava/lang/Object;
    //   21: aload_2
    //   22: iconst_0
    //   23: invokestatic 55	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   26: dup
    //   27: astore 5
    //   29: astore_3
    //   30: getstatic 61	kawa/standard/Scheme:isEqual	Lgnu/kawa/functions/IsEqual;
    //   33: ldc 63
    //   35: aload 4
    //   37: getfield 49	gnu/kawa/slib/printf$frame:format$Mnstring	Ljava/lang/Object;
    //   40: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   46: ifne +3599 -> 3645
    //   49: getstatic 78	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   52: aload 4
    //   54: swap
    //   55: putfield 81	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
    //   58: aload 4
    //   60: getfield 49	gnu/kawa/slib/printf$frame:format$Mnstring	Ljava/lang/Object;
    //   63: ldc 26
    //   65: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   68: dup
    //   69: astore 6
    //   71: checkcast 26	java/lang/CharSequence
    //   74: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   77: istore 5
    //   79: aload 4
    //   81: getfield 49	gnu/kawa/slib/printf$frame:format$Mnstring	Ljava/lang/Object;
    //   84: ldc 26
    //   86: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   89: dup
    //   90: astore 6
    //   92: checkcast 26	java/lang/CharSequence
    //   95: iconst_0
    //   96: invokestatic 106	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   99: invokestatic 112	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   102: aload 4
    //   104: swap
    //   105: putfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   108: aload_3
    //   109: astore 6
    //   111: new 117	gnu/kawa/slib/printf$frame0
    //   114: dup
    //   115: invokespecial 118	gnu/kawa/slib/printf$frame0:<init>	()V
    //   118: dup
    //   119: aload 4
    //   121: putfield 122	gnu/kawa/slib/printf$frame0:staticLink	Lgnu/kawa/slib/printf$frame;
    //   124: astore 7
    //   126: aload 7
    //   128: aload 6
    //   130: putfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   133: aload 4
    //   135: aload 4
    //   137: getfield 81	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
    //   140: iconst_1
    //   141: invokestatic 131	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   144: putfield 81	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
    //   147: aload 4
    //   149: getfield 81	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
    //   152: iload 5
    //   154: i2l
    //   155: invokestatic 135	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
    //   158: iflt +14 -> 172
    //   161: aload 4
    //   163: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   166: putfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   169: goto +41 -> 210
    //   172: aload 4
    //   174: aload 4
    //   176: getfield 49	gnu/kawa/slib/printf$frame:format$Mnstring	Ljava/lang/Object;
    //   179: ldc 26
    //   181: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   184: dup
    //   185: astore 8
    //   187: checkcast 26	java/lang/CharSequence
    //   190: aload 4
    //   192: getfield 81	gnu/kawa/slib/printf$frame:pos	Lgnu/math/IntNum;
    //   195: dup
    //   196: astore 8
    //   198: invokevirtual 147	java/lang/Number:intValue	()I
    //   201: invokestatic 106	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   204: invokestatic 112	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   207: putfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   210: aload 4
    //   212: iload 5
    //   214: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   217: invokevirtual 156	gnu/kawa/slib/printf$frame:lambda1isEndOfFormat	(Ljava/lang/Object;)Z
    //   220: istore 8
    //   222: iload 8
    //   224: ifeq +20 -> 244
    //   227: iload 8
    //   229: ifeq +9 -> 238
    //   232: getstatic 159	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   235: goto +3413 -> 3648
    //   238: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   241: goto +3407 -> 3648
    //   244: getstatic 163	gnu/kawa/slib/printf:Lit2	Lgnu/text/Char;
    //   247: aload 4
    //   249: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   252: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   255: ifeq +294 -> 549
    //   258: aload 4
    //   260: iload 5
    //   262: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: invokevirtual 173	gnu/kawa/slib/printf$frame:lambda2mustAdvance	(Ljava/lang/Object;)V
    //   268: aload 4
    //   270: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   273: astore 9
    //   275: aload 9
    //   277: invokevirtual 178	java/lang/Object:hashCode	()I
    //   280: lookupswitch	default:+230->510, 10:+178->458, 70:+96->376, 78:+196->476, 84:+82->362, 102:+68->348, 110:+164->444, 116:+130->410
    //   348: aload 9
    //   350: getstatic 181	gnu/kawa/slib/printf:Lit3	Lgnu/text/Char;
    //   353: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   356: ifeq +154 -> 510
    //   359: goto +28 -> 387
    //   362: aload 9
    //   364: getstatic 184	gnu/kawa/slib/printf:Lit4	Lgnu/text/Char;
    //   367: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   370: ifeq +140 -> 510
    //   373: goto +48 -> 421
    //   376: aload 9
    //   378: getstatic 187	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
    //   381: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   384: ifeq +126 -> 510
    //   387: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   390: aload 4
    //   392: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   395: getstatic 194	gnu/kawa/slib/printf:Lit6	Lgnu/text/Char;
    //   398: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   401: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   404: ifeq +139 -> 543
    //   407: goto +128 -> 535
    //   410: aload 9
    //   412: getstatic 197	gnu/kawa/slib/printf:Lit7	Lgnu/text/Char;
    //   415: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   418: ifeq +92 -> 510
    //   421: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   424: aload 4
    //   426: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   429: getstatic 200	gnu/kawa/slib/printf:Lit8	Lgnu/text/Char;
    //   432: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   435: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   438: ifeq +105 -> 543
    //   441: goto +94 -> 535
    //   444: aload 9
    //   446: getstatic 203	gnu/kawa/slib/printf:Lit9	Lgnu/text/Char;
    //   449: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   452: ifeq +58 -> 510
    //   455: goto +32 -> 487
    //   458: aload 9
    //   460: getstatic 206	gnu/kawa/slib/printf:Lit10	Lgnu/text/Char;
    //   463: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   466: ifeq +44 -> 510
    //   469: iconst_1
    //   470: ifeq +73 -> 543
    //   473: goto +62 -> 535
    //   476: aload 9
    //   478: getstatic 209	gnu/kawa/slib/printf:Lit11	Lgnu/text/Char;
    //   481: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   484: ifeq +26 -> 510
    //   487: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   490: aload 4
    //   492: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   495: getstatic 206	gnu/kawa/slib/printf:Lit10	Lgnu/text/Char;
    //   498: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   501: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   504: ifeq +39 -> 543
    //   507: goto +28 -> 535
    //   510: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   513: aload 4
    //   515: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   518: aload 4
    //   520: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   523: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   526: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   529: ifeq +14 -> 543
    //   532: goto +3 -> 535
    //   535: aload 7
    //   537: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   540: goto -431 -> 109
    //   543: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   546: goto +3102 -> 3648
    //   549: getstatic 212	gnu/kawa/slib/printf:Lit12	Lgnu/text/Char;
    //   552: aload 4
    //   554: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   557: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   560: ifeq +3049 -> 3609
    //   563: aload 4
    //   565: iload 5
    //   567: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   570: invokevirtual 173	gnu/kawa/slib/printf$frame:lambda2mustAdvance	(Ljava/lang/Object;)V
    //   573: iconst_0
    //   574: aload 7
    //   576: swap
    //   577: putfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   580: iconst_0
    //   581: aload 7
    //   583: swap
    //   584: putfield 218	gnu/kawa/slib/printf$frame0:signed	Z
    //   587: iconst_0
    //   588: aload 7
    //   590: swap
    //   591: putfield 221	gnu/kawa/slib/printf$frame0:blank	Z
    //   594: iconst_0
    //   595: aload 7
    //   597: swap
    //   598: putfield 224	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
    //   601: iconst_0
    //   602: aload 7
    //   604: swap
    //   605: putfield 227	gnu/kawa/slib/printf$frame0:leading$Mn0s	Z
    //   608: getstatic 230	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
    //   611: aload 7
    //   613: swap
    //   614: putfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   617: getstatic 78	gnu/kawa/slib/printf:Lit1	Lgnu/math/IntNum;
    //   620: aload 7
    //   622: swap
    //   623: putfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   626: aload 7
    //   628: getfield 240	gnu/kawa/slib/printf$frame0:pad	Lgnu/mapping/Procedure;
    //   631: aload 7
    //   633: swap
    //   634: putfield 240	gnu/kawa/slib/printf$frame0:pad	Lgnu/mapping/Procedure;
    //   637: aload 4
    //   639: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   642: astore 9
    //   644: aload 9
    //   646: invokevirtual 178	java/lang/Object:hashCode	()I
    //   649: lookupswitch	default:+171->820, 32:+75->724, 35:+51->700, 43:+123->772, 45:+147->796, 48:+99->748
    //   700: aload 9
    //   702: getstatic 243	gnu/kawa/slib/printf:Lit14	Lgnu/text/Char;
    //   705: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   708: ifeq +112 -> 820
    //   711: aload 7
    //   713: iconst_1
    //   714: putfield 224	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
    //   717: iconst_0
    //   718: ifne +122 -> 840
    //   721: goto +106 -> 827
    //   724: aload 9
    //   726: getstatic 246	gnu/kawa/slib/printf:Lit15	Lgnu/text/Char;
    //   729: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   732: ifeq +88 -> 820
    //   735: aload 7
    //   737: iconst_1
    //   738: putfield 221	gnu/kawa/slib/printf$frame0:blank	Z
    //   741: iconst_0
    //   742: ifne +98 -> 840
    //   745: goto +82 -> 827
    //   748: aload 9
    //   750: getstatic 249	gnu/kawa/slib/printf:Lit16	Lgnu/text/Char;
    //   753: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   756: ifeq +64 -> 820
    //   759: aload 7
    //   761: iconst_1
    //   762: putfield 227	gnu/kawa/slib/printf$frame0:leading$Mn0s	Z
    //   765: iconst_0
    //   766: ifne +74 -> 840
    //   769: goto +58 -> 827
    //   772: aload 9
    //   774: getstatic 252	gnu/kawa/slib/printf:Lit17	Lgnu/text/Char;
    //   777: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   780: ifeq +40 -> 820
    //   783: aload 7
    //   785: iconst_1
    //   786: putfield 218	gnu/kawa/slib/printf$frame0:signed	Z
    //   789: iconst_0
    //   790: ifne +50 -> 840
    //   793: goto +34 -> 827
    //   796: aload 9
    //   798: getstatic 255	gnu/kawa/slib/printf:Lit18	Lgnu/text/Char;
    //   801: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   804: ifeq +16 -> 820
    //   807: aload 7
    //   809: iconst_1
    //   810: putfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   813: iconst_0
    //   814: ifne +26 -> 840
    //   817: goto +10 -> 827
    //   820: iconst_1
    //   821: ifne +19 -> 840
    //   824: goto +3 -> 827
    //   827: aload 4
    //   829: iload 5
    //   831: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   834: invokevirtual 173	gnu/kawa/slib/printf$frame:lambda2mustAdvance	(Ljava/lang/Object;)V
    //   837: goto -200 -> 637
    //   840: aload 7
    //   842: getfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   845: ifeq +9 -> 854
    //   848: aload 7
    //   850: iconst_0
    //   851: putfield 227	gnu/kawa/slib/printf$frame0:leading$Mn0s	Z
    //   854: aload 7
    //   856: getfield 218	gnu/kawa/slib/printf$frame0:signed	Z
    //   859: ifeq +9 -> 868
    //   862: aload 7
    //   864: iconst_0
    //   865: putfield 221	gnu/kawa/slib/printf$frame0:blank	Z
    //   868: aload 7
    //   870: aload 7
    //   872: iload 5
    //   874: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   877: invokevirtual 259	gnu/kawa/slib/printf$frame0:lambda4readFormatNumber	(Ljava/lang/Object;)Ljava/lang/Object;
    //   880: putfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   883: aload 7
    //   885: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   888: ldc_w 261
    //   891: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   894: dup
    //   895: astore 9
    //   897: invokestatic 267	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   900: invokestatic 273	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   903: ifeq +25 -> 928
    //   906: aload 7
    //   908: iconst_1
    //   909: putfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   912: aload 7
    //   914: getstatic 279	gnu/kawa/functions/AddOp:$Mn	Lgnu/kawa/functions/AddOp;
    //   917: aload 7
    //   919: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   922: invokevirtual 282	gnu/mapping/Procedure:apply1	(Ljava/lang/Object;)Ljava/lang/Object;
    //   925: putfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   928: getstatic 285	gnu/kawa/slib/printf:Lit19	Lgnu/text/Char;
    //   931: aload 4
    //   933: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   936: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   939: ifeq +28 -> 967
    //   942: aload 4
    //   944: iload 5
    //   946: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   949: invokevirtual 173	gnu/kawa/slib/printf$frame:lambda2mustAdvance	(Ljava/lang/Object;)V
    //   952: aload 7
    //   954: aload 7
    //   956: iload 5
    //   958: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   961: invokevirtual 259	gnu/kawa/slib/printf$frame0:lambda4readFormatNumber	(Ljava/lang/Object;)Ljava/lang/Object;
    //   964: putfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   967: aload 4
    //   969: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   972: astore 9
    //   974: aload 9
    //   976: invokevirtual 178	java/lang/Object:hashCode	()I
    //   979: lookupswitch	default:+85->1064, 76:+33->1012, 104:+61->1040, 108:+47->1026
    //   1012: aload 9
    //   1014: getstatic 288	gnu/kawa/slib/printf:Lit20	Lgnu/text/Char;
    //   1017: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1020: ifeq +44 -> 1064
    //   1023: goto +28 -> 1051
    //   1026: aload 9
    //   1028: getstatic 291	gnu/kawa/slib/printf:Lit21	Lgnu/text/Char;
    //   1031: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1034: ifeq +30 -> 1064
    //   1037: goto +14 -> 1051
    //   1040: aload 9
    //   1042: getstatic 294	gnu/kawa/slib/printf:Lit22	Lgnu/text/Char;
    //   1045: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1048: ifeq +16 -> 1064
    //   1051: aload 4
    //   1053: iload 5
    //   1055: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1058: invokevirtual 173	gnu/kawa/slib/printf$frame:lambda2mustAdvance	(Ljava/lang/Object;)V
    //   1061: goto +3 -> 1064
    //   1064: aload 7
    //   1066: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   1069: invokestatic 299	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   1072: ifeq +76 -> 1148
    //   1075: aload 4
    //   1077: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   1080: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1083: dup
    //   1084: astore 9
    //   1086: invokestatic 305	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   1089: invokestatic 313	kawa/lib/rnrs/unicode:charDowncase	(I)I
    //   1092: invokestatic 112	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   1095: getstatic 317	gnu/kawa/slib/printf:Lit23	Lgnu/lists/PairWithPosition;
    //   1098: invokestatic 320	kawa/lib/lists:memv	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1101: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1104: ifeq +44 -> 1148
    //   1107: iconst_4
    //   1108: anewarray 175	java/lang/Object
    //   1111: dup
    //   1112: iconst_0
    //   1113: getstatic 324	gnu/kawa/slib/printf:Lit24	Lgnu/mapping/SimpleSymbol;
    //   1116: aastore
    //   1117: dup
    //   1118: iconst_1
    //   1119: ldc_w 326
    //   1122: aastore
    //   1123: dup
    //   1124: iconst_2
    //   1125: aload_3
    //   1126: invokevirtual 329	gnu/lists/LList:size	()I
    //   1129: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1132: aastore
    //   1133: dup
    //   1134: iconst_3
    //   1135: aload 4
    //   1137: getfield 49	gnu/kawa/slib/printf$frame:format$Mnstring	Ljava/lang/Object;
    //   1140: aastore
    //   1141: invokestatic 335	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   1144: getstatic 341	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   1147: athrow
    //   1148: aload 4
    //   1150: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   1153: astore 9
    //   1155: aload 9
    //   1157: invokevirtual 178	java/lang/Object:hashCode	()I
    //   1160: lookupswitch	default:+2339->3499, 37:+1278->2438, 65:+284->1444, 66:+298->1458, 67:+312->1472, 68:+228->1388, 69:+242->1402, 70:+256->1416, 71:+270->1430, 73:+340->1500, 75:+354->1514, 79:+326->1486, 83:+382->1542, 85:+368->1528, 88:+396->1556, 97:+730->1890, 98:+546->1706, 99:+628->1788, 100:+518->1678, 101:+532->1692, 102:+490->1650, 103:+504->1664, 105:+1720->2880, 107:+1405->2565, 111:+1323->2483, 115:+1816->2976, 117:+1734->2894, 120:+2245->3405
    //   1388: aload 9
    //   1390: getstatic 344	gnu/kawa/slib/printf:Lit25	Lgnu/text/Char;
    //   1393: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1396: ifeq +2103 -> 3499
    //   1399: goto +1506 -> 2905
    //   1402: aload 9
    //   1404: getstatic 347	gnu/kawa/slib/printf:Lit26	Lgnu/text/Char;
    //   1407: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1410: ifeq +2089 -> 3499
    //   1413: goto +1163 -> 2576
    //   1416: aload 9
    //   1418: getstatic 187	gnu/kawa/slib/printf:Lit5	Lgnu/text/Char;
    //   1421: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1424: ifeq +2075 -> 3499
    //   1427: goto +1149 -> 2576
    //   1430: aload 9
    //   1432: getstatic 350	gnu/kawa/slib/printf:Lit27	Lgnu/text/Char;
    //   1435: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1438: ifeq +2061 -> 3499
    //   1441: goto +1135 -> 2576
    //   1444: aload 9
    //   1446: getstatic 353	gnu/kawa/slib/printf:Lit28	Lgnu/text/Char;
    //   1449: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1452: ifeq +2047 -> 3499
    //   1455: goto +446 -> 1901
    //   1458: aload 9
    //   1460: getstatic 356	gnu/kawa/slib/printf:Lit29	Lgnu/text/Char;
    //   1463: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1466: ifeq +2033 -> 3499
    //   1469: goto +248 -> 1717
    //   1472: aload 9
    //   1474: getstatic 359	gnu/kawa/slib/printf:Lit30	Lgnu/text/Char;
    //   1477: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1480: ifeq +2019 -> 3499
    //   1483: goto +316 -> 1799
    //   1486: aload 9
    //   1488: getstatic 362	gnu/kawa/slib/printf:Lit31	Lgnu/text/Char;
    //   1491: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1494: ifeq +2005 -> 3499
    //   1497: goto +997 -> 2494
    //   1500: aload 9
    //   1502: getstatic 365	gnu/kawa/slib/printf:Lit32	Lgnu/text/Char;
    //   1505: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1508: ifeq +1991 -> 3499
    //   1511: goto +1394 -> 2905
    //   1514: aload 9
    //   1516: getstatic 368	gnu/kawa/slib/printf:Lit33	Lgnu/text/Char;
    //   1519: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1522: ifeq +1977 -> 3499
    //   1525: goto +1051 -> 2576
    //   1528: aload 9
    //   1530: getstatic 371	gnu/kawa/slib/printf:Lit34	Lgnu/text/Char;
    //   1533: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1536: ifeq +1963 -> 3499
    //   1539: goto +1366 -> 2905
    //   1542: aload 9
    //   1544: getstatic 374	gnu/kawa/slib/printf:Lit35	Lgnu/text/Char;
    //   1547: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1550: ifeq +1949 -> 3499
    //   1553: goto +1434 -> 2987
    //   1556: aload 9
    //   1558: getstatic 377	gnu/kawa/slib/printf:Lit36	Lgnu/text/Char;
    //   1561: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1564: ifeq +1935 -> 3499
    //   1567: aload 4
    //   1569: aload 7
    //   1571: aload 7
    //   1573: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   1576: ldc_w 379
    //   1579: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1582: dup
    //   1583: astore 10
    //   1585: checkcast 379	gnu/lists/Pair
    //   1588: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   1591: getstatic 387	gnu/kawa/slib/printf:Lit37	Lgnu/math/IntNum;
    //   1594: getstatic 36	gnu/kawa/slib/printf:stdio$Clhex$Mnupper$Mncase$Qu	Z
    //   1597: ifeq +9 -> 1606
    //   1600: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1603: goto +6 -> 1609
    //   1606: getstatic 391	kawa/lib/rnrs/unicode:string$Mnupcase	Lgnu/expr/ModuleMethod;
    //   1609: invokevirtual 395	gnu/kawa/slib/printf$frame0:lambda6integerConvert	(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
    //   1612: invokevirtual 398	gnu/kawa/slib/printf$frame:lambda5out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1615: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1618: ifeq +26 -> 1644
    //   1621: aload 7
    //   1623: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   1626: ldc_w 379
    //   1629: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1632: dup
    //   1633: astore 10
    //   1635: checkcast 379	gnu/lists/Pair
    //   1638: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   1641: goto -1532 -> 109
    //   1644: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1647: goto +2001 -> 3648
    //   1650: aload 9
    //   1652: getstatic 181	gnu/kawa/slib/printf:Lit3	Lgnu/text/Char;
    //   1655: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1658: ifeq +1841 -> 3499
    //   1661: goto +915 -> 2576
    //   1664: aload 9
    //   1666: getstatic 405	gnu/kawa/slib/printf:Lit38	Lgnu/text/Char;
    //   1669: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1672: ifeq +1827 -> 3499
    //   1675: goto +901 -> 2576
    //   1678: aload 9
    //   1680: getstatic 408	gnu/kawa/slib/printf:Lit39	Lgnu/text/Char;
    //   1683: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1686: ifeq +1813 -> 3499
    //   1689: goto +1216 -> 2905
    //   1692: aload 9
    //   1694: getstatic 411	gnu/kawa/slib/printf:Lit40	Lgnu/text/Char;
    //   1697: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1700: ifeq +1799 -> 3499
    //   1703: goto +873 -> 2576
    //   1706: aload 9
    //   1708: getstatic 414	gnu/kawa/slib/printf:Lit41	Lgnu/text/Char;
    //   1711: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1714: ifeq +1785 -> 3499
    //   1717: aload 4
    //   1719: aload 7
    //   1721: aload 7
    //   1723: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   1726: ldc_w 379
    //   1729: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1732: dup
    //   1733: astore 10
    //   1735: checkcast 379	gnu/lists/Pair
    //   1738: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   1741: getstatic 417	gnu/kawa/slib/printf:Lit42	Lgnu/math/IntNum;
    //   1744: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1747: invokevirtual 395	gnu/kawa/slib/printf$frame0:lambda6integerConvert	(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
    //   1750: invokevirtual 398	gnu/kawa/slib/printf$frame:lambda5out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1753: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1756: ifeq +26 -> 1782
    //   1759: aload 7
    //   1761: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   1764: ldc_w 379
    //   1767: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1770: dup
    //   1771: astore 10
    //   1773: checkcast 379	gnu/lists/Pair
    //   1776: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   1779: goto -1670 -> 109
    //   1782: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1785: goto +1863 -> 3648
    //   1788: aload 9
    //   1790: getstatic 420	gnu/kawa/slib/printf:Lit43	Lgnu/text/Char;
    //   1793: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1796: ifeq +1703 -> 3499
    //   1799: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   1802: aload 4
    //   1804: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   1807: aload 7
    //   1809: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   1812: ldc_w 379
    //   1815: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1818: dup
    //   1819: astore 10
    //   1821: checkcast 379	gnu/lists/Pair
    //   1824: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   1827: dup
    //   1828: instanceof 422
    //   1831: ifeq +9 -> 1840
    //   1834: checkcast 422	[Ljava/lang/Object;
    //   1837: goto +12 -> 1849
    //   1840: iconst_1
    //   1841: anewarray 175	java/lang/Object
    //   1844: dup_x1
    //   1845: swap
    //   1846: iconst_0
    //   1847: swap
    //   1848: aastore
    //   1849: invokestatic 426	kawa/lib/strings:$make$string$	([Ljava/lang/Object;)Ljava/lang/CharSequence;
    //   1852: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1855: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   1858: ifeq +26 -> 1884
    //   1861: aload 7
    //   1863: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   1866: ldc_w 379
    //   1869: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1872: dup
    //   1873: astore 10
    //   1875: checkcast 379	gnu/lists/Pair
    //   1878: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   1881: goto -1772 -> 109
    //   1884: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1887: goto +1761 -> 3648
    //   1890: aload 9
    //   1892: getstatic 429	gnu/kawa/slib/printf:Lit44	Lgnu/text/Char;
    //   1895: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1898: ifeq +1601 -> 3499
    //   1901: ldc 63
    //   1903: aload 7
    //   1905: swap
    //   1906: putfield 432	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
    //   1909: aload 7
    //   1911: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   1914: aload 7
    //   1916: swap
    //   1917: putfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   1920: aload 7
    //   1922: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   1925: ldc_w 379
    //   1928: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1931: dup
    //   1932: astore 10
    //   1934: checkcast 379	gnu/lists/Pair
    //   1937: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   1940: aload 7
    //   1942: getfield 224	gnu/kawa/slib/printf$frame0:alternate$Mnform	Z
    //   1945: ifeq +9 -> 1954
    //   1948: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1951: goto +6 -> 1957
    //   1954: getstatic 159	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   1957: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   1960: aload 7
    //   1962: getfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   1965: ifeq +42 -> 2007
    //   1968: aload 7
    //   1970: getfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   1973: ldc_w 261
    //   1976: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   1979: dup
    //   1980: astore 10
    //   1982: invokestatic 267	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   1985: invokestatic 273	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   1988: ifeq +19 -> 2007
    //   1991: aload 7
    //   1993: getstatic 230	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
    //   1996: putfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   1999: aload 7
    //   2001: getfield 438	gnu/kawa/slib/printf$frame0:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   2004: goto +65 -> 2069
    //   2007: aload 7
    //   2009: getfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   2012: ifeq +11 -> 2023
    //   2015: aload 7
    //   2017: getfield 441	gnu/kawa/slib/printf$frame0:lambda$Fn2	Lgnu/expr/ModuleMethod;
    //   2020: goto +49 -> 2069
    //   2023: aload 7
    //   2025: getfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   2028: ldc_w 261
    //   2031: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2034: dup
    //   2035: astore 10
    //   2037: invokestatic 267	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2040: invokestatic 273	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   2043: ifeq +21 -> 2064
    //   2046: aload 7
    //   2048: aload 7
    //   2050: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   2053: putfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   2056: aload 7
    //   2058: getfield 444	gnu/kawa/slib/printf$frame0:lambda$Fn3	Lgnu/expr/ModuleMethod;
    //   2061: goto +8 -> 2069
    //   2064: aload 7
    //   2066: getfield 447	gnu/kawa/slib/printf$frame0:lambda$Fn4	Lgnu/expr/ModuleMethod;
    //   2069: invokestatic 453	gnu/kawa/slib/genwrite:genericWrite	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2072: pop
    //   2073: aload 7
    //   2075: getfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   2078: ifeq +88 -> 2166
    //   2081: aload 7
    //   2083: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   2086: ldc_w 261
    //   2089: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2092: dup
    //   2093: astore 10
    //   2095: invokestatic 267	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2098: invokestatic 273	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   2101: ifeq +65 -> 2166
    //   2104: aload 7
    //   2106: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   2109: aload 7
    //   2111: getfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   2114: invokestatic 458	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2117: ifeq +298 -> 2415
    //   2120: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2123: aload 4
    //   2125: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   2128: iconst_m1
    //   2129: aload 7
    //   2131: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   2134: aload 7
    //   2136: getfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   2139: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2142: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2145: dup
    //   2146: astore 10
    //   2148: checkcast 143	java/lang/Number
    //   2151: invokevirtual 147	java/lang/Number:intValue	()I
    //   2154: bipush 32
    //   2156: invokestatic 467	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   2159: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2162: pop
    //   2163: goto +252 -> 2415
    //   2166: aload 7
    //   2168: getfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   2171: ifeq +83 -> 2254
    //   2174: aload 7
    //   2176: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   2179: iconst_m1
    //   2180: aload 7
    //   2182: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   2185: aload 7
    //   2187: getfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   2190: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2193: invokestatic 458	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2196: ifeq +219 -> 2415
    //   2199: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2202: aload 4
    //   2204: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   2207: iconst_m1
    //   2208: aload 7
    //   2210: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   2213: iconst_m1
    //   2214: aload 7
    //   2216: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   2219: aload 7
    //   2221: getfield 435	gnu/kawa/slib/printf$frame0:pr	Ljava/lang/Object;
    //   2224: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2227: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2230: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2233: dup
    //   2234: astore 10
    //   2236: checkcast 143	java/lang/Number
    //   2239: invokevirtual 147	java/lang/Number:intValue	()I
    //   2242: bipush 32
    //   2244: invokestatic 467	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   2247: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2250: pop
    //   2251: goto +164 -> 2415
    //   2254: aload 7
    //   2256: getfield 432	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
    //   2259: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   2262: ifeq +7 -> 2269
    //   2265: iconst_0
    //   2266: goto +4 -> 2270
    //   2269: iconst_1
    //   2270: istore 10
    //   2272: iload 10
    //   2274: ifeq +6 -> 2280
    //   2277: goto +138 -> 2415
    //   2280: aload 7
    //   2282: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   2285: aload 7
    //   2287: getfield 432	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
    //   2290: ldc 26
    //   2292: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2295: dup
    //   2296: astore 11
    //   2298: checkcast 26	java/lang/CharSequence
    //   2301: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   2304: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2307: invokestatic 470	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2310: ifeq +23 -> 2333
    //   2313: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2316: aload 4
    //   2318: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   2321: aload 7
    //   2323: getfield 432	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
    //   2326: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2329: pop
    //   2330: goto +85 -> 2415
    //   2333: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2336: aload 4
    //   2338: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   2341: iconst_m1
    //   2342: aload 7
    //   2344: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   2347: aload 7
    //   2349: getfield 432	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
    //   2352: ldc 26
    //   2354: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2357: dup
    //   2358: astore 11
    //   2360: checkcast 26	java/lang/CharSequence
    //   2363: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   2366: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2369: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2372: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2375: dup
    //   2376: astore 11
    //   2378: checkcast 143	java/lang/Number
    //   2381: invokevirtual 147	java/lang/Number:intValue	()I
    //   2384: bipush 32
    //   2386: invokestatic 467	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   2389: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2392: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   2395: ifeq +20 -> 2415
    //   2398: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2401: aload 4
    //   2403: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   2406: aload 7
    //   2408: getfield 432	gnu/kawa/slib/printf$frame0:os	Ljava/lang/Object;
    //   2411: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2414: pop
    //   2415: aload 7
    //   2417: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2420: ldc_w 379
    //   2423: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2426: dup
    //   2427: astore 10
    //   2429: checkcast 379	gnu/lists/Pair
    //   2432: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   2435: goto -2326 -> 109
    //   2438: aload 9
    //   2440: getstatic 212	gnu/kawa/slib/printf:Lit12	Lgnu/text/Char;
    //   2443: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2446: ifeq +1053 -> 3499
    //   2449: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   2452: aload 4
    //   2454: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   2457: getstatic 212	gnu/kawa/slib/printf:Lit12	Lgnu/text/Char;
    //   2460: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2463: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   2466: ifeq +11 -> 2477
    //   2469: aload 7
    //   2471: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2474: goto -2365 -> 109
    //   2477: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2480: goto +1168 -> 3648
    //   2483: aload 9
    //   2485: getstatic 473	gnu/kawa/slib/printf:Lit45	Lgnu/text/Char;
    //   2488: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2491: ifeq +1008 -> 3499
    //   2494: aload 4
    //   2496: aload 7
    //   2498: aload 7
    //   2500: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2503: ldc_w 379
    //   2506: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2509: dup
    //   2510: astore 10
    //   2512: checkcast 379	gnu/lists/Pair
    //   2515: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   2518: getstatic 476	gnu/kawa/slib/printf:Lit46	Lgnu/math/IntNum;
    //   2521: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2524: invokevirtual 395	gnu/kawa/slib/printf$frame0:lambda6integerConvert	(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
    //   2527: invokevirtual 398	gnu/kawa/slib/printf$frame:lambda5out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2530: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   2533: ifeq +26 -> 2559
    //   2536: aload 7
    //   2538: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2541: ldc_w 379
    //   2544: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2547: dup
    //   2548: astore 10
    //   2550: checkcast 379	gnu/lists/Pair
    //   2553: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   2556: goto -2447 -> 109
    //   2559: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2562: goto +1086 -> 3648
    //   2565: aload 9
    //   2567: getstatic 479	gnu/kawa/slib/printf:Lit47	Lgnu/text/Char;
    //   2570: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2573: ifeq +926 -> 3499
    //   2576: aload 4
    //   2578: aload 7
    //   2580: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2583: ldc_w 379
    //   2586: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2589: dup
    //   2590: astore 10
    //   2592: checkcast 379	gnu/lists/Pair
    //   2595: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   2598: aload 4
    //   2600: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   2603: astore 11
    //   2605: astore 10
    //   2607: new 481	gnu/kawa/slib/printf$frame1
    //   2610: dup
    //   2611: invokespecial 482	gnu/kawa/slib/printf$frame1:<init>	()V
    //   2614: dup
    //   2615: aload 7
    //   2617: putfield 485	gnu/kawa/slib/printf$frame1:staticLink	Lgnu/kawa/slib/printf$frame0;
    //   2620: astore 12
    //   2622: aload 12
    //   2624: aload 11
    //   2626: putfield 486	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
    //   2629: aload 7
    //   2631: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   2634: ldc_w 261
    //   2637: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2640: dup
    //   2641: astore 13
    //   2643: invokestatic 267	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   2646: invokestatic 273	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   2649: ifeq +14 -> 2663
    //   2652: aload 7
    //   2654: getstatic 489	gnu/kawa/slib/printf:Lit48	Lgnu/math/IntNum;
    //   2657: putfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   2660: goto +58 -> 2718
    //   2663: aload 7
    //   2665: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   2668: ldc -113
    //   2670: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2673: dup
    //   2674: astore 13
    //   2676: checkcast 143	java/lang/Number
    //   2679: invokestatic 495	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   2682: ifeq +36 -> 2718
    //   2685: aload 12
    //   2687: getfield 486	gnu/kawa/slib/printf$frame1:fc	Ljava/lang/Object;
    //   2690: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2693: invokestatic 305	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
    //   2696: invokestatic 500	java/lang/Character:toUpperCase	(I)I
    //   2699: bipush 103
    //   2701: invokestatic 500	java/lang/Character:toUpperCase	(I)I
    //   2704: if_icmpne +14 -> 2718
    //   2707: aload 7
    //   2709: getstatic 503	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
    //   2712: putfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   2715: goto +3 -> 2718
    //   2718: aload 10
    //   2720: invokestatic 506	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
    //   2723: ifeq +25 -> 2748
    //   2726: aload 10
    //   2728: ldc -113
    //   2730: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2733: dup
    //   2734: astore 14
    //   2736: checkcast 143	java/lang/Number
    //   2739: invokestatic 512	kawa/lib/numbers:exact$To$Inexact	(Ljava/lang/Number;)Ljava/lang/Number;
    //   2742: invokestatic 515	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   2745: goto +47 -> 2792
    //   2748: aload 10
    //   2750: invokestatic 518	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   2753: ifeq +8 -> 2761
    //   2756: aload 10
    //   2758: goto +34 -> 2792
    //   2761: aload 10
    //   2763: invokestatic 523	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
    //   2766: ifeq +23 -> 2789
    //   2769: aload 10
    //   2771: ldc_w 525
    //   2774: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2777: dup
    //   2778: astore 14
    //   2780: checkcast 525	gnu/mapping/Symbol
    //   2783: invokestatic 531	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   2786: goto +6 -> 2792
    //   2789: ldc_w 533
    //   2792: astore 13
    //   2794: aload 12
    //   2796: getfield 536	gnu/kawa/slib/printf$frame1:format$Mnreal	Lgnu/mapping/Procedure;
    //   2799: aload 12
    //   2801: swap
    //   2802: putfield 536	gnu/kawa/slib/printf$frame1:format$Mnreal	Lgnu/mapping/Procedure;
    //   2805: aload 13
    //   2807: aload 12
    //   2809: getfield 539	gnu/kawa/slib/printf$frame1:lambda$Fn5	Lgnu/expr/ModuleMethod;
    //   2812: invokestatic 542	gnu/kawa/slib/printf:stdio$ClParseFloat	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2815: astore 14
    //   2817: aload 14
    //   2819: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   2822: ifeq +8 -> 2830
    //   2825: aload 14
    //   2827: goto +15 -> 2842
    //   2830: aload 7
    //   2832: ldc_w 533
    //   2835: iconst_0
    //   2836: anewarray 175	java/lang/Object
    //   2839: invokevirtual 546	gnu/kawa/slib/printf$frame0:lambda3pad$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2842: invokevirtual 398	gnu/kawa/slib/printf$frame:lambda5out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2845: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   2848: ifeq +26 -> 2874
    //   2851: aload 7
    //   2853: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2856: ldc_w 379
    //   2859: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2862: dup
    //   2863: astore 10
    //   2865: checkcast 379	gnu/lists/Pair
    //   2868: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   2871: goto -2762 -> 109
    //   2874: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2877: goto +771 -> 3648
    //   2880: aload 9
    //   2882: getstatic 549	gnu/kawa/slib/printf:Lit56	Lgnu/text/Char;
    //   2885: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2888: ifeq +611 -> 3499
    //   2891: goto +14 -> 2905
    //   2894: aload 9
    //   2896: getstatic 552	gnu/kawa/slib/printf:Lit57	Lgnu/text/Char;
    //   2899: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2902: ifeq +597 -> 3499
    //   2905: aload 4
    //   2907: aload 7
    //   2909: aload 7
    //   2911: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2914: ldc_w 379
    //   2917: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2920: dup
    //   2921: astore 10
    //   2923: checkcast 379	gnu/lists/Pair
    //   2926: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   2929: getstatic 555	gnu/kawa/slib/printf:Lit51	Lgnu/math/IntNum;
    //   2932: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2935: invokevirtual 395	gnu/kawa/slib/printf$frame0:lambda6integerConvert	(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
    //   2938: invokevirtual 398	gnu/kawa/slib/printf$frame:lambda5out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2941: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   2944: ifeq +26 -> 2970
    //   2947: aload 7
    //   2949: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2952: ldc_w 379
    //   2955: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2958: dup
    //   2959: astore 10
    //   2961: checkcast 379	gnu/lists/Pair
    //   2964: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   2967: goto -2858 -> 109
    //   2970: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   2973: goto +675 -> 3648
    //   2976: aload 9
    //   2978: getstatic 558	gnu/kawa/slib/printf:Lit58	Lgnu/text/Char;
    //   2981: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   2984: ifeq +515 -> 3499
    //   2987: aload 7
    //   2989: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   2992: ldc_w 379
    //   2995: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   2998: dup
    //   2999: astore 11
    //   3001: checkcast 379	gnu/lists/Pair
    //   3004: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   3007: invokestatic 523	kawa/lib/misc:isSymbol	(Ljava/lang/Object;)Z
    //   3010: ifeq +41 -> 3051
    //   3013: aload 7
    //   3015: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   3018: ldc_w 379
    //   3021: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3024: dup
    //   3025: astore 11
    //   3027: checkcast 379	gnu/lists/Pair
    //   3030: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   3033: ldc_w 525
    //   3036: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3039: dup
    //   3040: astore 11
    //   3042: checkcast 525	gnu/mapping/Symbol
    //   3045: invokestatic 531	kawa/lib/misc:symbol$To$String	(Lgnu/mapping/Symbol;)Ljava/lang/String;
    //   3048: goto +55 -> 3103
    //   3051: aload 7
    //   3053: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   3056: ldc_w 379
    //   3059: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3062: dup
    //   3063: astore 11
    //   3065: checkcast 379	gnu/lists/Pair
    //   3068: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   3071: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   3074: ifne +9 -> 3083
    //   3077: ldc_w 560
    //   3080: goto +23 -> 3103
    //   3083: aload 7
    //   3085: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   3088: ldc_w 379
    //   3091: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3094: dup
    //   3095: astore 11
    //   3097: checkcast 379	gnu/lists/Pair
    //   3100: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   3103: astore 10
    //   3105: aload 7
    //   3107: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   3110: ldc_w 261
    //   3113: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3116: dup
    //   3117: astore 12
    //   3119: invokestatic 267	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   3122: invokestatic 273	kawa/lib/numbers:isNegative	(Lgnu/math/RealNum;)Z
    //   3125: istore 11
    //   3127: iload 11
    //   3129: ifeq +11 -> 3140
    //   3132: iload 11
    //   3134: ifne +72 -> 3206
    //   3137: goto +33 -> 3170
    //   3140: aload 7
    //   3142: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   3145: aload 10
    //   3147: ldc 26
    //   3149: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3152: dup
    //   3153: astore 12
    //   3155: checkcast 26	java/lang/CharSequence
    //   3158: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   3161: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3164: invokestatic 563	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3167: ifne +39 -> 3206
    //   3170: aload 10
    //   3172: ldc 26
    //   3174: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3177: dup
    //   3178: astore 11
    //   3180: checkcast 26	java/lang/CharSequence
    //   3183: iconst_0
    //   3184: aload 7
    //   3186: getfield 236	gnu/kawa/slib/printf$frame0:precision	Ljava/lang/Object;
    //   3189: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3192: dup
    //   3193: astore 11
    //   3195: checkcast 143	java/lang/Number
    //   3198: invokevirtual 147	java/lang/Number:intValue	()I
    //   3201: invokestatic 568	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   3204: astore 10
    //   3206: aload 4
    //   3208: aload 7
    //   3210: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   3213: aload 10
    //   3215: ldc 26
    //   3217: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3220: dup
    //   3221: astore 11
    //   3223: checkcast 26	java/lang/CharSequence
    //   3226: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   3229: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3232: invokestatic 470	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3235: ifeq +8 -> 3243
    //   3238: aload 10
    //   3240: goto +127 -> 3367
    //   3243: aload 7
    //   3245: getfield 215	gnu/kawa/slib/printf$frame0:left$Mnadjust	Z
    //   3248: ifeq +56 -> 3304
    //   3251: aload 10
    //   3253: iconst_m1
    //   3254: aload 7
    //   3256: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   3259: aload 10
    //   3261: ldc 26
    //   3263: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3266: dup
    //   3267: astore 11
    //   3269: checkcast 26	java/lang/CharSequence
    //   3272: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   3275: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3278: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3281: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3284: dup
    //   3285: astore 11
    //   3287: checkcast 143	java/lang/Number
    //   3290: invokevirtual 147	java/lang/Number:intValue	()I
    //   3293: bipush 32
    //   3295: invokestatic 467	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   3298: invokestatic 572	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   3301: goto +66 -> 3367
    //   3304: iconst_m1
    //   3305: aload 7
    //   3307: getfield 233	gnu/kawa/slib/printf$frame0:width	Ljava/lang/Object;
    //   3310: aload 10
    //   3312: ldc 26
    //   3314: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3317: dup
    //   3318: astore 11
    //   3320: checkcast 26	java/lang/CharSequence
    //   3323: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   3326: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3329: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3332: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3335: dup
    //   3336: astore 11
    //   3338: checkcast 143	java/lang/Number
    //   3341: invokevirtual 147	java/lang/Number:intValue	()I
    //   3344: aload 7
    //   3346: getfield 227	gnu/kawa/slib/printf$frame0:leading$Mn0s	Z
    //   3349: ifeq +8 -> 3357
    //   3352: bipush 48
    //   3354: goto +5 -> 3359
    //   3357: bipush 32
    //   3359: invokestatic 467	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   3362: aload 10
    //   3364: invokestatic 572	gnu/lists/LList:list2	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   3367: invokevirtual 398	gnu/kawa/slib/printf$frame:lambda5out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3370: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   3373: ifeq +26 -> 3399
    //   3376: aload 7
    //   3378: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   3381: ldc_w 379
    //   3384: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3387: dup
    //   3388: astore 11
    //   3390: checkcast 379	gnu/lists/Pair
    //   3393: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   3396: goto -3287 -> 109
    //   3399: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3402: goto +246 -> 3648
    //   3405: aload 9
    //   3407: getstatic 575	gnu/kawa/slib/printf:Lit59	Lgnu/text/Char;
    //   3410: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   3413: ifeq +86 -> 3499
    //   3416: aload 4
    //   3418: aload 7
    //   3420: aload 7
    //   3422: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   3425: ldc_w 379
    //   3428: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3431: dup
    //   3432: astore 10
    //   3434: checkcast 379	gnu/lists/Pair
    //   3437: invokestatic 384	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   3440: getstatic 387	gnu/kawa/slib/printf:Lit37	Lgnu/math/IntNum;
    //   3443: getstatic 36	gnu/kawa/slib/printf:stdio$Clhex$Mnupper$Mncase$Qu	Z
    //   3446: ifeq +9 -> 3455
    //   3449: getstatic 578	kawa/lib/rnrs/unicode:string$Mndowncase	Lgnu/expr/ModuleMethod;
    //   3452: goto +6 -> 3458
    //   3455: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3458: invokevirtual 395	gnu/kawa/slib/printf$frame0:lambda6integerConvert	(Ljava/lang/Object;Lgnu/math/IntNum;Ljava/lang/Object;)Ljava/lang/Object;
    //   3461: invokevirtual 398	gnu/kawa/slib/printf$frame:lambda5out$St	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3464: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   3467: ifeq +26 -> 3493
    //   3470: aload 7
    //   3472: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   3475: ldc_w 379
    //   3478: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   3481: dup
    //   3482: astore 10
    //   3484: checkcast 379	gnu/lists/Pair
    //   3487: invokestatic 402	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   3490: goto -3381 -> 109
    //   3493: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3496: goto +152 -> 3648
    //   3499: aload 4
    //   3501: iload 5
    //   3503: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3506: invokevirtual 156	gnu/kawa/slib/printf$frame:lambda1isEndOfFormat	(Ljava/lang/Object;)Z
    //   3509: ifeq +12 -> 3521
    //   3512: aload 4
    //   3514: invokevirtual 582	gnu/kawa/slib/printf$frame:lambda14incomplete	()Lgnu/bytecode/Type$NeverReturns;
    //   3517: getstatic 341	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   3520: athrow
    //   3521: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3524: aload 4
    //   3526: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   3529: getstatic 212	gnu/kawa/slib/printf:Lit12	Lgnu/text/Char;
    //   3532: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3535: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   3538: ifeq +65 -> 3603
    //   3541: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3544: aload 4
    //   3546: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   3549: aload 4
    //   3551: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   3554: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3557: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   3560: ifeq +37 -> 3597
    //   3563: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3566: aload 4
    //   3568: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   3571: getstatic 585	gnu/kawa/slib/printf:Lit60	Lgnu/text/Char;
    //   3574: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3577: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   3580: ifeq +11 -> 3591
    //   3583: aload 7
    //   3585: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   3588: goto -3479 -> 109
    //   3591: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3594: goto +54 -> 3648
    //   3597: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3600: goto +48 -> 3648
    //   3603: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3606: goto +42 -> 3648
    //   3609: getstatic 191	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
    //   3612: aload 4
    //   3614: getfield 46	gnu/kawa/slib/printf$frame:out	Ljava/lang/Object;
    //   3617: aload 4
    //   3619: getfield 115	gnu/kawa/slib/printf$frame:fc	Ljava/lang/Object;
    //   3622: invokevirtual 69	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3625: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   3628: ifeq +11 -> 3639
    //   3631: aload 7
    //   3633: getfield 125	gnu/kawa/slib/printf$frame0:args	Ljava/lang/Object;
    //   3636: goto -3527 -> 109
    //   3639: getstatic 141	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   3642: goto +6 -> 3648
    //   3645: getstatic 591	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   3648: areturn
    //   3649: new 91	gnu/mapping/WrongType
    //   3652: dup_x1
    //   3653: swap
    //   3654: ldc 93
    //   3656: iconst_1
    //   3657: aload 6
    //   3659: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3662: athrow
    //   3663: new 91	gnu/mapping/WrongType
    //   3666: dup_x1
    //   3667: swap
    //   3668: ldc 102
    //   3670: iconst_1
    //   3671: aload 6
    //   3673: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3676: athrow
    //   3677: new 91	gnu/mapping/WrongType
    //   3680: dup_x1
    //   3681: swap
    //   3682: ldc 102
    //   3684: iconst_1
    //   3685: aload 8
    //   3687: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3690: athrow
    //   3691: new 91	gnu/mapping/WrongType
    //   3694: dup_x1
    //   3695: swap
    //   3696: ldc 102
    //   3698: iconst_2
    //   3699: aload 8
    //   3701: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3704: athrow
    //   3705: new 91	gnu/mapping/WrongType
    //   3708: dup_x1
    //   3709: swap
    //   3710: ldc_w 269
    //   3713: iconst_1
    //   3714: aload 9
    //   3716: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3719: athrow
    //   3720: new 91	gnu/mapping/WrongType
    //   3723: dup_x1
    //   3724: swap
    //   3725: ldc_w 307
    //   3728: iconst_1
    //   3729: aload 9
    //   3731: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3734: athrow
    //   3735: new 91	gnu/mapping/WrongType
    //   3738: dup_x1
    //   3739: swap
    //   3740: ldc_w 381
    //   3743: iconst_1
    //   3744: aload 10
    //   3746: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3749: athrow
    //   3750: new 91	gnu/mapping/WrongType
    //   3753: dup_x1
    //   3754: swap
    //   3755: ldc_w 400
    //   3758: iconst_1
    //   3759: aload 10
    //   3761: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3764: athrow
    //   3765: new 91	gnu/mapping/WrongType
    //   3768: dup_x1
    //   3769: swap
    //   3770: ldc_w 381
    //   3773: iconst_1
    //   3774: aload 10
    //   3776: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3779: athrow
    //   3780: new 91	gnu/mapping/WrongType
    //   3783: dup_x1
    //   3784: swap
    //   3785: ldc_w 400
    //   3788: iconst_1
    //   3789: aload 10
    //   3791: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3794: athrow
    //   3795: new 91	gnu/mapping/WrongType
    //   3798: dup_x1
    //   3799: swap
    //   3800: ldc_w 381
    //   3803: iconst_1
    //   3804: aload 10
    //   3806: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3809: athrow
    //   3810: new 91	gnu/mapping/WrongType
    //   3813: dup_x1
    //   3814: swap
    //   3815: ldc_w 400
    //   3818: iconst_1
    //   3819: aload 10
    //   3821: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3824: athrow
    //   3825: new 91	gnu/mapping/WrongType
    //   3828: dup_x1
    //   3829: swap
    //   3830: ldc_w 381
    //   3833: iconst_1
    //   3834: aload 10
    //   3836: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3839: athrow
    //   3840: new 91	gnu/mapping/WrongType
    //   3843: dup_x1
    //   3844: swap
    //   3845: ldc_w 269
    //   3848: iconst_1
    //   3849: aload 10
    //   3851: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3854: athrow
    //   3855: new 91	gnu/mapping/WrongType
    //   3858: dup_x1
    //   3859: swap
    //   3860: ldc_w 269
    //   3863: iconst_1
    //   3864: aload 10
    //   3866: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3869: athrow
    //   3870: new 91	gnu/mapping/WrongType
    //   3873: dup_x1
    //   3874: swap
    //   3875: ldc_w 269
    //   3878: iconst_1
    //   3879: aload 10
    //   3881: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3884: athrow
    //   3885: new 91	gnu/mapping/WrongType
    //   3888: dup_x1
    //   3889: swap
    //   3890: ldc_w 463
    //   3893: iconst_1
    //   3894: aload 10
    //   3896: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3899: athrow
    //   3900: new 91	gnu/mapping/WrongType
    //   3903: dup_x1
    //   3904: swap
    //   3905: ldc_w 463
    //   3908: iconst_1
    //   3909: aload 10
    //   3911: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3914: athrow
    //   3915: new 91	gnu/mapping/WrongType
    //   3918: dup_x1
    //   3919: swap
    //   3920: ldc 93
    //   3922: iconst_1
    //   3923: aload 11
    //   3925: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3928: athrow
    //   3929: new 91	gnu/mapping/WrongType
    //   3932: dup_x1
    //   3933: swap
    //   3934: ldc 93
    //   3936: iconst_1
    //   3937: aload 11
    //   3939: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3942: athrow
    //   3943: new 91	gnu/mapping/WrongType
    //   3946: dup_x1
    //   3947: swap
    //   3948: ldc_w 463
    //   3951: iconst_1
    //   3952: aload 11
    //   3954: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3957: athrow
    //   3958: new 91	gnu/mapping/WrongType
    //   3961: dup_x1
    //   3962: swap
    //   3963: ldc_w 400
    //   3966: iconst_1
    //   3967: aload 10
    //   3969: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3972: athrow
    //   3973: new 91	gnu/mapping/WrongType
    //   3976: dup_x1
    //   3977: swap
    //   3978: ldc_w 381
    //   3981: iconst_1
    //   3982: aload 10
    //   3984: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   3987: athrow
    //   3988: new 91	gnu/mapping/WrongType
    //   3991: dup_x1
    //   3992: swap
    //   3993: ldc_w 400
    //   3996: iconst_1
    //   3997: aload 10
    //   3999: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4002: athrow
    //   4003: new 91	gnu/mapping/WrongType
    //   4006: dup_x1
    //   4007: swap
    //   4008: ldc_w 381
    //   4011: iconst_1
    //   4012: aload 10
    //   4014: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4017: athrow
    //   4018: new 91	gnu/mapping/WrongType
    //   4021: dup_x1
    //   4022: swap
    //   4023: ldc_w 269
    //   4026: iconst_1
    //   4027: aload 13
    //   4029: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4032: athrow
    //   4033: new 91	gnu/mapping/WrongType
    //   4036: dup_x1
    //   4037: swap
    //   4038: ldc_w 491
    //   4041: iconst_1
    //   4042: aload 13
    //   4044: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4047: athrow
    //   4048: new 91	gnu/mapping/WrongType
    //   4051: dup_x1
    //   4052: swap
    //   4053: ldc_w 508
    //   4056: iconst_1
    //   4057: aload 14
    //   4059: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4062: athrow
    //   4063: new 91	gnu/mapping/WrongType
    //   4066: dup_x1
    //   4067: swap
    //   4068: ldc_w 527
    //   4071: iconst_1
    //   4072: aload 14
    //   4074: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4077: athrow
    //   4078: new 91	gnu/mapping/WrongType
    //   4081: dup_x1
    //   4082: swap
    //   4083: ldc_w 400
    //   4086: iconst_1
    //   4087: aload 10
    //   4089: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4092: athrow
    //   4093: new 91	gnu/mapping/WrongType
    //   4096: dup_x1
    //   4097: swap
    //   4098: ldc_w 381
    //   4101: iconst_1
    //   4102: aload 10
    //   4104: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4107: athrow
    //   4108: new 91	gnu/mapping/WrongType
    //   4111: dup_x1
    //   4112: swap
    //   4113: ldc_w 400
    //   4116: iconst_1
    //   4117: aload 10
    //   4119: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4122: athrow
    //   4123: new 91	gnu/mapping/WrongType
    //   4126: dup_x1
    //   4127: swap
    //   4128: ldc_w 381
    //   4131: iconst_1
    //   4132: aload 11
    //   4134: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4137: athrow
    //   4138: new 91	gnu/mapping/WrongType
    //   4141: dup_x1
    //   4142: swap
    //   4143: ldc_w 381
    //   4146: iconst_1
    //   4147: aload 11
    //   4149: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4152: athrow
    //   4153: new 91	gnu/mapping/WrongType
    //   4156: dup_x1
    //   4157: swap
    //   4158: ldc_w 527
    //   4161: iconst_1
    //   4162: aload 11
    //   4164: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4167: athrow
    //   4168: new 91	gnu/mapping/WrongType
    //   4171: dup_x1
    //   4172: swap
    //   4173: ldc_w 381
    //   4176: iconst_1
    //   4177: aload 11
    //   4179: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4182: athrow
    //   4183: new 91	gnu/mapping/WrongType
    //   4186: dup_x1
    //   4187: swap
    //   4188: ldc_w 381
    //   4191: iconst_1
    //   4192: aload 11
    //   4194: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4197: athrow
    //   4198: new 91	gnu/mapping/WrongType
    //   4201: dup_x1
    //   4202: swap
    //   4203: ldc_w 269
    //   4206: iconst_1
    //   4207: aload 12
    //   4209: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4212: athrow
    //   4213: new 91	gnu/mapping/WrongType
    //   4216: dup_x1
    //   4217: swap
    //   4218: ldc 93
    //   4220: iconst_1
    //   4221: aload 12
    //   4223: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4226: athrow
    //   4227: new 91	gnu/mapping/WrongType
    //   4230: dup_x1
    //   4231: swap
    //   4232: ldc_w 565
    //   4235: iconst_1
    //   4236: aload 11
    //   4238: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4241: athrow
    //   4242: new 91	gnu/mapping/WrongType
    //   4245: dup_x1
    //   4246: swap
    //   4247: ldc_w 565
    //   4250: iconst_3
    //   4251: aload 11
    //   4253: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4256: athrow
    //   4257: new 91	gnu/mapping/WrongType
    //   4260: dup_x1
    //   4261: swap
    //   4262: ldc 93
    //   4264: iconst_1
    //   4265: aload 11
    //   4267: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4270: athrow
    //   4271: new 91	gnu/mapping/WrongType
    //   4274: dup_x1
    //   4275: swap
    //   4276: ldc 93
    //   4278: iconst_1
    //   4279: aload 11
    //   4281: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4284: athrow
    //   4285: new 91	gnu/mapping/WrongType
    //   4288: dup_x1
    //   4289: swap
    //   4290: ldc_w 463
    //   4293: iconst_1
    //   4294: aload 11
    //   4296: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4299: athrow
    //   4300: new 91	gnu/mapping/WrongType
    //   4303: dup_x1
    //   4304: swap
    //   4305: ldc 93
    //   4307: iconst_1
    //   4308: aload 11
    //   4310: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4313: athrow
    //   4314: new 91	gnu/mapping/WrongType
    //   4317: dup_x1
    //   4318: swap
    //   4319: ldc_w 463
    //   4322: iconst_1
    //   4323: aload 11
    //   4325: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4328: athrow
    //   4329: new 91	gnu/mapping/WrongType
    //   4332: dup_x1
    //   4333: swap
    //   4334: ldc_w 400
    //   4337: iconst_1
    //   4338: aload 11
    //   4340: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4343: athrow
    //   4344: new 91	gnu/mapping/WrongType
    //   4347: dup_x1
    //   4348: swap
    //   4349: ldc_w 381
    //   4352: iconst_1
    //   4353: aload 10
    //   4355: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4358: athrow
    //   4359: new 91	gnu/mapping/WrongType
    //   4362: dup_x1
    //   4363: swap
    //   4364: ldc_w 400
    //   4367: iconst_1
    //   4368: aload 10
    //   4370: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   4373: athrow
    // Line number table:
    //   Java source line #186	-> byte code offset #0
    //   Java source line #187	-> byte code offset #30
    //   Java source line #188	-> byte code offset #33
    //   Java source line #189	-> byte code offset #49
    //   Java source line #190	-> byte code offset #58
    //   Java source line #191	-> byte code offset #79
    //   Java source line #193	-> byte code offset #108
    //   Java source line #197	-> byte code offset #108
    //   Java source line #201	-> byte code offset #108
    //   Java source line #203	-> byte code offset #108
    //   Java source line #206	-> byte code offset #108
    //   Java source line #209	-> byte code offset #108
    //   Java source line #193	-> byte code offset #108
    //   Java source line #216	-> byte code offset #108
    //   Java source line #217	-> byte code offset #133
    //   Java source line #193	-> byte code offset #133
    //   Java source line #194	-> byte code offset #133
    //   Java source line #195	-> byte code offset #147
    //   Java source line #196	-> byte code offset #172
    //   Java source line #218	-> byte code offset #210
    //   Java source line #219	-> byte code offset #210
    //   Java source line #218	-> byte code offset #222
    //   Java source line #222	-> byte code offset #244
    //   Java source line #223	-> byte code offset #258
    //   Java source line #224	-> byte code offset #268
    //   Java source line #228	-> byte code offset #390
    //   Java source line #226	-> byte code offset #424
    //   Java source line #225	-> byte code offset #490
    //   Java source line #230	-> byte code offset #513
    //   Java source line #231	-> byte code offset #535
    //   Java source line #232	-> byte code offset #549
    //   Java source line #233	-> byte code offset #563
    //   Java source line #234	-> byte code offset #573
    //   Java source line #239	-> byte code offset #608
    //   Java source line #240	-> byte code offset #617
    //   Java source line #243	-> byte code offset #626
    //   Java source line #256	-> byte code offset #626
    //   Java source line #276	-> byte code offset #637
    //   Java source line #306	-> byte code offset #637
    //   Java source line #256	-> byte code offset #637
    //   Java source line #408	-> byte code offset #637
    //   Java source line #409	-> byte code offset #637
    //   Java source line #413	-> byte code offset #711
    //   Java source line #412	-> byte code offset #735
    //   Java source line #414	-> byte code offset #759
    //   Java source line #411	-> byte code offset #783
    //   Java source line #410	-> byte code offset #807
    //   Java source line #416	-> byte code offset #827
    //   Java source line #417	-> byte code offset #840
    //   Java source line #418	-> byte code offset #854
    //   Java source line #420	-> byte code offset #868
    //   Java source line #421	-> byte code offset #883
    //   Java source line #422	-> byte code offset #906
    //   Java source line #423	-> byte code offset #912
    //   Java source line #424	-> byte code offset #928
    //   Java source line #425	-> byte code offset #942
    //   Java source line #426	-> byte code offset #952
    //   Java source line #427	-> byte code offset #967
    //   Java source line #429	-> byte code offset #1051
    //   Java source line #430	-> byte code offset #1051
    //   Java source line #433	-> byte code offset #1064
    //   Java source line #434	-> byte code offset #1075
    //   Java source line #437	-> byte code offset #1107
    //   Java source line #206	-> byte code offset #1107
    //   Java source line #207	-> byte code offset #1107
    //   Java source line #208	-> byte code offset #1125
    //   Java source line #439	-> byte code offset #1148
    //   Java source line #528	-> byte code offset #1569
    //   Java source line #529	-> byte code offset #1571
    //   Java source line #530	-> byte code offset #1594
    //   Java source line #531	-> byte code offset #1621
    //   Java source line #533	-> byte code offset #1719
    //   Java source line #534	-> byte code offset #1759
    //   Java source line #442	-> byte code offset #1802
    //   Java source line #468	-> byte code offset #1901
    //   Java source line #469	-> byte code offset #1920
    //   Java source line #470	-> byte code offset #1920
    //   Java source line #471	-> byte code offset #1960
    //   Java source line #472	-> byte code offset #1991
    //   Java source line #473	-> byte code offset #1999
    //   Java source line #477	-> byte code offset #2015
    //   Java source line #483	-> byte code offset #2023
    //   Java source line #484	-> byte code offset #2046
    //   Java source line #485	-> byte code offset #2056
    //   Java source line #495	-> byte code offset #2064
    //   Java source line #503	-> byte code offset #2073
    //   Java source line #504	-> byte code offset #2104
    //   Java source line #505	-> byte code offset #2104
    //   Java source line #507	-> byte code offset #2174
    //   Java source line #508	-> byte code offset #2174
    //   Java source line #509	-> byte code offset #2199
    //   Java source line #510	-> byte code offset #2254
    //   Java source line #503	-> byte code offset #2272
    //   Java source line #511	-> byte code offset #2280
    //   Java source line #512	-> byte code offset #2333
    //   Java source line #513	-> byte code offset #2341
    //   Java source line #514	-> byte code offset #2398
    //   Java source line #515	-> byte code offset #2415
    //   Java source line #535	-> byte code offset #2452
    //   Java source line #520	-> byte code offset #2496
    //   Java source line #521	-> byte code offset #2536
    //   Java source line #537	-> byte code offset #2578
    //   Java source line #306	-> byte code offset #2603
    //   Java source line #307	-> byte code offset #2629
    //   Java source line #330	-> byte code offset #2629
    //   Java source line #346	-> byte code offset #2629
    //   Java source line #355	-> byte code offset #2629
    //   Java source line #307	-> byte code offset #2629
    //   Java source line #375	-> byte code offset #2629
    //   Java source line #376	-> byte code offset #2652
    //   Java source line #377	-> byte code offset #2663
    //   Java source line #379	-> byte code offset #2707
    //   Java source line #380	-> byte code offset #2718
    //   Java source line #381	-> byte code offset #2718
    //   Java source line #382	-> byte code offset #2726
    //   Java source line #383	-> byte code offset #2748
    //   Java source line #384	-> byte code offset #2761
    //   Java source line #385	-> byte code offset #2789
    //   Java source line #386	-> byte code offset #2794
    //   Java source line #401	-> byte code offset #2805
    //   Java source line #402	-> byte code offset #2807
    //   Java source line #401	-> byte code offset #2817
    //   Java source line #407	-> byte code offset #2830
    //   Java source line #537	-> byte code offset #2851
    //   Java source line #517	-> byte code offset #2907
    //   Java source line #518	-> byte code offset #2947
    //   Java source line #446	-> byte code offset #2987
    //   Java source line #447	-> byte code offset #2987
    //   Java source line #448	-> byte code offset #3051
    //   Java source line #449	-> byte code offset #3083
    //   Java source line #450	-> byte code offset #3105
    //   Java source line #451	-> byte code offset #3140
    //   Java source line #452	-> byte code offset #3170
    //   Java source line #453	-> byte code offset #3206
    //   Java source line #454	-> byte code offset #3208
    //   Java source line #455	-> byte code offset #3208
    //   Java source line #457	-> byte code offset #3251
    //   Java source line #458	-> byte code offset #3253
    //   Java source line #460	-> byte code offset #3304
    //   Java source line #461	-> byte code offset #3304
    //   Java source line #462	-> byte code offset #3344
    //   Java source line #464	-> byte code offset #3376
    //   Java source line #523	-> byte code offset #3418
    //   Java source line #524	-> byte code offset #3420
    //   Java source line #525	-> byte code offset #3443
    //   Java source line #526	-> byte code offset #3470
    //   Java source line #540	-> byte code offset #3512
    //   Java source line #541	-> byte code offset #3521
    //   Java source line #542	-> byte code offset #3609
    //   Java source line #190	-> byte code offset #3649
    //   Java source line #191	-> byte code offset #3663
    //   Java source line #196	-> byte code offset #3677
    //   Java source line #421	-> byte code offset #3705
    //   Java source line #434	-> byte code offset #3720
    //   Java source line #529	-> byte code offset #3735
    //   Java source line #531	-> byte code offset #3750
    //   Java source line #533	-> byte code offset #3765
    //   Java source line #534	-> byte code offset #3780
    //   Java source line #442	-> byte code offset #3795
    //   Java source line #470	-> byte code offset #3825
    //   Java source line #471	-> byte code offset #3840
    //   Java source line #483	-> byte code offset #3855
    //   Java source line #503	-> byte code offset #3870
    //   Java source line #505	-> byte code offset #3885
    //   Java source line #509	-> byte code offset #3900
    //   Java source line #511	-> byte code offset #3915
    //   Java source line #513	-> byte code offset #3929
    //   Java source line #515	-> byte code offset #3958
    //   Java source line #520	-> byte code offset #3973
    //   Java source line #521	-> byte code offset #3988
    //   Java source line #537	-> byte code offset #4003
    //   Java source line #375	-> byte code offset #4018
    //   Java source line #377	-> byte code offset #4033
    //   Java source line #382	-> byte code offset #4048
    //   Java source line #384	-> byte code offset #4063
    //   Java source line #537	-> byte code offset #4078
    //   Java source line #517	-> byte code offset #4093
    //   Java source line #518	-> byte code offset #4108
    //   Java source line #447	-> byte code offset #4123
    //   Java source line #448	-> byte code offset #4168
    //   Java source line #449	-> byte code offset #4183
    //   Java source line #450	-> byte code offset #4198
    //   Java source line #451	-> byte code offset #4213
    //   Java source line #452	-> byte code offset #4227
    //   Java source line #455	-> byte code offset #4257
    //   Java source line #458	-> byte code offset #4271
    //   Java source line #461	-> byte code offset #4300
    //   Java source line #464	-> byte code offset #4329
    //   Java source line #524	-> byte code offset #4344
    //   Java source line #526	-> byte code offset #4359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3648	0	out	Object
    //   0	3648	1	formatString	Object
    //   0	3648	2	argsArray	Object[]
    //   0	3648	3	args	gnu.lists.LList
    //   9	3639	4	$heapFrame	frame
    //   108	3534	5	fl	int
    //   111	3531	6	args	Object
    //   126	3516	7	$heapFrame	frame0
    //   222	3420	8	x	boolean
    //   275	271	9	tmp	Object
    //   644	183	9	tmp	Object
    //   974	90	9	tmp	Object
    //   1155	2454	9	tmp	Object
    //   2272	143	10	x	boolean
    //   2607	235	10	num	Object
    //   3105	297	10	s	Object
    //   2607	235	11	fc	Object
    //   3127	43	11	x	boolean
    //   2622	220	12	$heapFrame	frame1
    //   2794	48	13	str	Object
    //   2817	25	14	x	Object
    // Exception table:
    //   from	to	target	type
    //   71	74	3649	java/lang/ClassCastException
    //   92	95	3663	java/lang/ClassCastException
    //   187	190	3677	java/lang/ClassCastException
    //   198	201	3691	java/lang/ClassCastException
    //   897	900	3705	java/lang/ClassCastException
    //   1086	1089	3720	java/lang/ClassCastException
    //   1585	1588	3735	java/lang/ClassCastException
    //   1635	1638	3750	java/lang/ClassCastException
    //   1735	1738	3765	java/lang/ClassCastException
    //   1773	1776	3780	java/lang/ClassCastException
    //   1821	1824	3795	java/lang/ClassCastException
    //   1875	1878	3810	java/lang/ClassCastException
    //   1934	1937	3825	java/lang/ClassCastException
    //   1982	1985	3840	java/lang/ClassCastException
    //   2037	2040	3855	java/lang/ClassCastException
    //   2095	2098	3870	java/lang/ClassCastException
    //   2148	2154	3885	java/lang/ClassCastException
    //   2236	2242	3900	java/lang/ClassCastException
    //   2298	2301	3915	java/lang/ClassCastException
    //   2360	2363	3929	java/lang/ClassCastException
    //   2378	2384	3943	java/lang/ClassCastException
    //   2429	2432	3958	java/lang/ClassCastException
    //   2512	2515	3973	java/lang/ClassCastException
    //   2550	2553	3988	java/lang/ClassCastException
    //   2592	2595	4003	java/lang/ClassCastException
    //   2643	2646	4018	java/lang/ClassCastException
    //   2676	2679	4033	java/lang/ClassCastException
    //   2736	2739	4048	java/lang/ClassCastException
    //   2780	2783	4063	java/lang/ClassCastException
    //   2865	2868	4078	java/lang/ClassCastException
    //   2923	2926	4093	java/lang/ClassCastException
    //   2961	2964	4108	java/lang/ClassCastException
    //   3001	3004	4123	java/lang/ClassCastException
    //   3027	3030	4138	java/lang/ClassCastException
    //   3042	3045	4153	java/lang/ClassCastException
    //   3065	3068	4168	java/lang/ClassCastException
    //   3097	3100	4183	java/lang/ClassCastException
    //   3119	3122	4198	java/lang/ClassCastException
    //   3155	3158	4213	java/lang/ClassCastException
    //   3180	3183	4227	java/lang/ClassCastException
    //   3195	3201	4242	java/lang/ClassCastException
    //   3223	3226	4257	java/lang/ClassCastException
    //   3269	3272	4271	java/lang/ClassCastException
    //   3287	3293	4285	java/lang/ClassCastException
    //   3320	3323	4300	java/lang/ClassCastException
    //   3338	3344	4314	java/lang/ClassCastException
    //   3390	3393	4329	java/lang/ClassCastException
    //   3434	3437	4344	java/lang/ClassCastException
    //   3484	3487	4359	java/lang/ClassCastException
  }
  
  /* Error */
  static Object stdio$ClRoundString(CharSequence str, Object ndigs, Object strip$Mn0s)
  {
    // Byte code:
    //   0: new 674	gnu/kawa/slib/printf$frame13
    //   3: dup
    //   4: invokespecial 675	gnu/kawa/slib/printf$frame13:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: putfield 678	gnu/kawa/slib/printf$frame13:str	Ljava/lang/CharSequence;
    //   13: aload_3
    //   14: getfield 678	gnu/kawa/slib/printf$frame13:str	Ljava/lang/CharSequence;
    //   17: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   20: iconst_1
    //   21: isub
    //   22: istore 4
    //   24: aload_1
    //   25: getstatic 230	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
    //   28: invokestatic 681	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   31: ifeq +8 -> 39
    //   34: ldc 63
    //   36: goto +434 -> 470
    //   39: iload 4
    //   41: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: aload_1
    //   45: invokestatic 684	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   48: ifeq +10 -> 58
    //   51: aload_3
    //   52: getfield 678	gnu/kawa/slib/printf$frame13:str	Ljava/lang/CharSequence;
    //   55: goto +415 -> 470
    //   58: iload 4
    //   60: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: aload_1
    //   64: invokestatic 681	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   67: ifeq +127 -> 194
    //   70: iconst_2
    //   71: anewarray 175	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: getstatic 230	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: iconst_m1
    //   83: aload_2
    //   84: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   87: ifeq +7 -> 94
    //   90: aload_2
    //   91: goto +4 -> 95
    //   94: aload_1
    //   95: iload 4
    //   97: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: aastore
    //   104: invokestatic 688	kawa/lib/numbers:max	([Ljava/lang/Object;)Ljava/lang/Object;
    //   107: astore 6
    //   109: aload 6
    //   111: ldc -113
    //   113: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   116: dup
    //   117: astore 7
    //   119: checkcast 143	java/lang/Number
    //   122: invokestatic 495	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   125: ifeq +10 -> 135
    //   128: aload_3
    //   129: getfield 678	gnu/kawa/slib/printf$frame13:str	Ljava/lang/CharSequence;
    //   132: goto +338 -> 470
    //   135: iconst_2
    //   136: anewarray 175	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_3
    //   142: getfield 678	gnu/kawa/slib/printf$frame13:str	Ljava/lang/CharSequence;
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload 6
    //   150: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: dup
    //   154: astore 7
    //   156: checkcast 143	java/lang/Number
    //   159: invokevirtual 147	java/lang/Number:intValue	()I
    //   162: aload_3
    //   163: getfield 678	gnu/kawa/slib/printf$frame13:str	Ljava/lang/CharSequence;
    //   166: iload 4
    //   168: invokestatic 106	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   171: invokestatic 692	kawa/lib/rnrs/unicode:isCharNumeric	(I)Z
    //   174: ifeq +8 -> 182
    //   177: bipush 48
    //   179: goto +5 -> 184
    //   182: bipush 35
    //   184: invokestatic 467	kawa/lib/strings:makeString	(II)Lgnu/lists/FString;
    //   187: aastore
    //   188: invokestatic 696	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
    //   191: goto +279 -> 470
    //   194: aload_3
    //   195: getfield 678	gnu/kawa/slib/printf$frame13:str	Ljava/lang/CharSequence;
    //   198: iconst_0
    //   199: iconst_1
    //   200: aload_1
    //   201: getstatic 503	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
    //   204: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   207: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: dup
    //   211: astore 7
    //   213: checkcast 143	java/lang/Number
    //   216: invokevirtual 147	java/lang/Number:intValue	()I
    //   219: invokestatic 568	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   222: astore 6
    //   224: aload_3
    //   225: iconst_1
    //   226: getstatic 503	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
    //   229: aload_1
    //   230: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: invokevirtual 699	gnu/kawa/slib/printf$frame13:lambda32dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   236: astore 7
    //   238: aload 7
    //   240: getstatic 702	gnu/kawa/slib/printf:Lit67	Lgnu/math/IntNum;
    //   243: invokestatic 458	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   246: istore 8
    //   248: iload 8
    //   250: ifeq +11 -> 261
    //   253: iload 8
    //   255: ifeq +213 -> 468
    //   258: goto +94 -> 352
    //   261: aload 7
    //   263: getstatic 702	gnu/kawa/slib/printf:Lit67	Lgnu/math/IntNum;
    //   266: invokestatic 684	gnu/kawa/functions/NumberCompare:$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   269: ifeq +199 -> 468
    //   272: iconst_1
    //   273: getstatic 417	gnu/kawa/slib/printf:Lit42	Lgnu/math/IntNum;
    //   276: aload_1
    //   277: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   280: astore 9
    //   282: aload 9
    //   284: iload 4
    //   286: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: invokestatic 458	gnu/kawa/functions/NumberCompare:$Gr	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   292: ifeq +25 -> 317
    //   295: aload_3
    //   296: aload_1
    //   297: invokevirtual 699	gnu/kawa/slib/printf$frame13:lambda32dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   303: checkcast 143	java/lang/Number
    //   306: invokevirtual 147	java/lang/Number:intValue	()I
    //   309: iconst_1
    //   310: iand
    //   311: ifeq +157 -> 468
    //   314: goto +38 -> 352
    //   317: aload_3
    //   318: aload 9
    //   320: invokevirtual 699	gnu/kawa/slib/printf$frame13:lambda32dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   323: ldc -113
    //   325: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   328: dup
    //   329: astore 10
    //   331: checkcast 143	java/lang/Number
    //   334: invokestatic 495	kawa/lib/numbers:isZero	(Ljava/lang/Number;)Z
    //   337: ifeq +15 -> 352
    //   340: iconst_1
    //   341: aload 9
    //   343: getstatic 503	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
    //   346: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   349: goto -69 -> 280
    //   352: aload_1
    //   353: astore 9
    //   355: aload_3
    //   356: aload 9
    //   358: invokevirtual 699	gnu/kawa/slib/printf$frame13:lambda32dig	(Ljava/lang/Object;)Ljava/lang/Object;
    //   361: astore 10
    //   363: aload 10
    //   365: getstatic 705	gnu/kawa/slib/printf:Lit68	Lgnu/math/IntNum;
    //   368: invokestatic 681	gnu/kawa/functions/NumberCompare:$Ls	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   371: ifeq +58 -> 429
    //   374: aload 6
    //   376: dup
    //   377: astore 11
    //   379: checkcast 707	gnu/lists/CharSeq
    //   382: aload 9
    //   384: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   387: dup
    //   388: astore 11
    //   390: checkcast 143	java/lang/Number
    //   393: invokevirtual 147	java/lang/Number:intValue	()I
    //   396: iconst_1
    //   397: aload 10
    //   399: getstatic 503	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
    //   402: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: ldc -113
    //   407: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   410: dup
    //   411: astore 11
    //   413: checkcast 143	java/lang/Number
    //   416: invokestatic 515	kawa/lib/numbers:number$To$String	(Ljava/lang/Number;)Ljava/lang/CharSequence;
    //   419: iconst_0
    //   420: invokestatic 106	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   423: invokestatic 715	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   426: goto +42 -> 468
    //   429: aload 6
    //   431: dup
    //   432: astore 11
    //   434: checkcast 707	gnu/lists/CharSeq
    //   437: aload 9
    //   439: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   442: dup
    //   443: astore 11
    //   445: checkcast 143	java/lang/Number
    //   448: invokevirtual 147	java/lang/Number:intValue	()I
    //   451: bipush 48
    //   453: invokestatic 715	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
    //   456: iconst_m1
    //   457: aload 9
    //   459: getstatic 503	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
    //   462: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: goto -112 -> 353
    //   468: aload 6
    //   470: astore 5
    //   472: aload_2
    //   473: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   476: ifeq +102 -> 578
    //   479: aload 5
    //   481: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   484: iconst_1
    //   485: isub
    //   486: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   489: astore 6
    //   491: aload 6
    //   493: aload_2
    //   494: invokestatic 470	gnu/kawa/functions/NumberCompare:$Ls$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   497: istore 7
    //   499: iload 7
    //   501: ifeq +11 -> 512
    //   504: iload 7
    //   506: ifeq +60 -> 566
    //   509: goto +27 -> 536
    //   512: bipush 48
    //   514: aload 5
    //   516: aload 6
    //   518: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   521: dup
    //   522: astore 8
    //   524: checkcast 143	java/lang/Number
    //   527: invokevirtual 147	java/lang/Number:intValue	()I
    //   530: invokestatic 106	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
    //   533: if_icmpeq +33 -> 566
    //   536: aload 5
    //   538: iconst_0
    //   539: iconst_1
    //   540: aload 6
    //   542: getstatic 503	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
    //   545: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   548: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   551: dup
    //   552: astore 8
    //   554: checkcast 143	java/lang/Number
    //   557: invokevirtual 147	java/lang/Number:intValue	()I
    //   560: invokestatic 568	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   563: goto +17 -> 580
    //   566: iconst_m1
    //   567: aload 6
    //   569: getstatic 503	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
    //   572: invokestatic 461	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   575: goto -86 -> 489
    //   578: aload 5
    //   580: areturn
    //   581: new 91	gnu/mapping/WrongType
    //   584: dup_x1
    //   585: swap
    //   586: ldc_w 491
    //   589: iconst_1
    //   590: aload 7
    //   592: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   595: athrow
    //   596: new 91	gnu/mapping/WrongType
    //   599: dup_x1
    //   600: swap
    //   601: ldc_w 463
    //   604: iconst_1
    //   605: aload 7
    //   607: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   610: athrow
    //   611: new 91	gnu/mapping/WrongType
    //   614: dup_x1
    //   615: swap
    //   616: ldc_w 565
    //   619: iconst_3
    //   620: aload 7
    //   622: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   625: athrow
    //   626: new 91	gnu/mapping/WrongType
    //   629: dup_x1
    //   630: swap
    //   631: ldc_w 491
    //   634: iconst_1
    //   635: aload 10
    //   637: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   640: athrow
    //   641: new 91	gnu/mapping/WrongType
    //   644: dup_x1
    //   645: swap
    //   646: ldc_w 709
    //   649: iconst_1
    //   650: aload 11
    //   652: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   655: athrow
    //   656: new 91	gnu/mapping/WrongType
    //   659: dup_x1
    //   660: swap
    //   661: ldc_w 709
    //   664: iconst_2
    //   665: aload 11
    //   667: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   670: athrow
    //   671: new 91	gnu/mapping/WrongType
    //   674: dup_x1
    //   675: swap
    //   676: ldc_w 711
    //   679: iconst_1
    //   680: aload 11
    //   682: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   685: athrow
    //   686: new 91	gnu/mapping/WrongType
    //   689: dup_x1
    //   690: swap
    //   691: ldc_w 709
    //   694: iconst_1
    //   695: aload 11
    //   697: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   700: athrow
    //   701: new 91	gnu/mapping/WrongType
    //   704: dup_x1
    //   705: swap
    //   706: ldc_w 709
    //   709: iconst_2
    //   710: aload 11
    //   712: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   715: athrow
    //   716: new 91	gnu/mapping/WrongType
    //   719: dup_x1
    //   720: swap
    //   721: ldc 102
    //   723: iconst_2
    //   724: aload 8
    //   726: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   729: athrow
    //   730: new 91	gnu/mapping/WrongType
    //   733: dup_x1
    //   734: swap
    //   735: ldc_w 565
    //   738: iconst_3
    //   739: aload 8
    //   741: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   744: athrow
    // Line number table:
    //   Java source line #138	-> byte code offset #0
    //   Java source line #139	-> byte code offset #13
    //   Java source line #141	-> byte code offset #24
    //   Java source line #142	-> byte code offset #39
    //   Java source line #143	-> byte code offset #58
    //   Java source line #144	-> byte code offset #70
    //   Java source line #145	-> byte code offset #109
    //   Java source line #147	-> byte code offset #135
    //   Java source line #148	-> byte code offset #148
    //   Java source line #149	-> byte code offset #162
    //   Java source line #150	-> byte code offset #162
    //   Java source line #149	-> byte code offset #177
    //   Java source line #153	-> byte code offset #194
    //   Java source line #154	-> byte code offset #224
    //   Java source line #159	-> byte code offset #224
    //   Java source line #160	-> byte code offset #238
    //   Java source line #161	-> byte code offset #261
    //   Java source line #162	-> byte code offset #272
    //   Java source line #163	-> byte code offset #282
    //   Java source line #164	-> byte code offset #295
    //   Java source line #165	-> byte code offset #317
    //   Java source line #166	-> byte code offset #340
    //   Java source line #168	-> byte code offset #352
    //   Java source line #169	-> byte code offset #355
    //   Java source line #170	-> byte code offset #363
    //   Java source line #171	-> byte code offset #374
    //   Java source line #172	-> byte code offset #396
    //   Java source line #173	-> byte code offset #396
    //   Java source line #175	-> byte code offset #429
    //   Java source line #176	-> byte code offset #456
    //   Java source line #177	-> byte code offset #468
    //   Java source line #178	-> byte code offset #472
    //   Java source line #179	-> byte code offset #479
    //   Java source line #180	-> byte code offset #491
    //   Java source line #181	-> byte code offset #512
    //   Java source line #182	-> byte code offset #536
    //   Java source line #183	-> byte code offset #566
    //   Java source line #178	-> byte code offset #578
    //   Java source line #145	-> byte code offset #581
    //   Java source line #148	-> byte code offset #596
    //   Java source line #153	-> byte code offset #611
    //   Java source line #165	-> byte code offset #626
    //   Java source line #171	-> byte code offset #641
    //   Java source line #173	-> byte code offset #671
    //   Java source line #175	-> byte code offset #686
    //   Java source line #181	-> byte code offset #716
    //   Java source line #182	-> byte code offset #730
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	str	CharSequence
    //   0	580	1	ndigs	Object
    //   0	580	2	strip$Mn0s	Object
    //   7	349	3	$heapFrame	frame13
    //   22	263	4	n	int
    //   470	109	5	res	CharSequence
    //   107	42	6	padlen	Object
    //   222	247	6	res	CharSequence
    //   489	79	6	i	Object
    //   117	95	7	localObject1	Object
    //   236	26	7	ldig	Object
    //   497	124	7	x	boolean
    //   246	494	8	x	boolean
    //   280	62	9	i	Object
    //   353	105	9	i	Object
    //   329	1	10	localObject2	Object
    //   361	275	10	d	Object
    //   377	334	11	localObject3	Object
    //   581	1	18	localClassCastException1	ClassCastException
    //   596	1	19	localClassCastException2	ClassCastException
    //   611	1	20	localClassCastException3	ClassCastException
    //   626	1	21	localClassCastException4	ClassCastException
    //   641	1	22	localClassCastException5	ClassCastException
    //   656	1	23	localClassCastException6	ClassCastException
    //   671	1	24	localClassCastException7	ClassCastException
    //   686	1	25	localClassCastException8	ClassCastException
    //   701	1	26	localClassCastException9	ClassCastException
    //   716	1	27	localClassCastException10	ClassCastException
    //   730	1	28	localClassCastException11	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   119	122	581	java/lang/ClassCastException
    //   156	162	596	java/lang/ClassCastException
    //   213	219	611	java/lang/ClassCastException
    //   331	334	626	java/lang/ClassCastException
    //   379	382	641	java/lang/ClassCastException
    //   390	396	656	java/lang/ClassCastException
    //   413	416	671	java/lang/ClassCastException
    //   434	437	686	java/lang/ClassCastException
    //   445	451	701	java/lang/ClassCastException
    //   524	530	716	java/lang/ClassCastException
    //   554	560	730	java/lang/ClassCastException
  }
  
  /* Error */
  public static Object sprintf$V(Object str, Object format, Object[] argsArray)
  {
    // Byte code:
    //   0: new 631	gnu/kawa/slib/printf$frame3
    //   3: dup
    //   4: invokespecial 632	gnu/kawa/slib/printf$frame3:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: putfield 635	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
    //   15: aload_2
    //   16: iconst_0
    //   17: invokestatic 55	gnu/lists/LList:makeList	([Ljava/lang/Object;I)Lgnu/lists/LList;
    //   20: dup
    //   21: astore 5
    //   23: astore_3
    //   24: getstatic 230	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
    //   27: aload 4
    //   29: swap
    //   30: putfield 637	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
    //   33: aload 4
    //   35: getfield 635	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
    //   38: invokestatic 518	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   41: ifeq +11 -> 52
    //   44: aload 4
    //   46: getfield 635	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
    //   49: goto +87 -> 136
    //   52: aload 4
    //   54: getfield 635	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
    //   57: invokestatic 506	kawa/lib/numbers:isNumber	(Ljava/lang/Object;)Z
    //   60: ifeq +26 -> 86
    //   63: aload 4
    //   65: getfield 635	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
    //   68: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: dup
    //   72: astore 5
    //   74: checkcast 143	java/lang/Number
    //   77: invokevirtual 147	java/lang/Number:intValue	()I
    //   80: invokestatic 640	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   83: goto +53 -> 136
    //   86: aload 4
    //   88: getfield 635	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
    //   91: invokestatic 75	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   94: ifne +11 -> 105
    //   97: bipush 100
    //   99: invokestatic 640	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
    //   102: goto +34 -> 136
    //   105: iconst_3
    //   106: anewarray 175	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: getstatic 643	gnu/kawa/slib/printf:Lit63	Lgnu/mapping/SimpleSymbol;
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: ldc_w 645
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: aload 4
    //   125: getfield 635	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
    //   128: aastore
    //   129: invokestatic 335	kawa/lib/exceptions:error	([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
    //   132: getstatic 341	gnu/expr/Special:reachedUnexpected	Ljava/lang/RuntimeException;
    //   135: athrow
    //   136: aload 4
    //   138: swap
    //   139: putfield 648	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
    //   142: aload 4
    //   144: getfield 648	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
    //   147: ldc 26
    //   149: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   152: dup
    //   153: astore 5
    //   155: checkcast 26	java/lang/CharSequence
    //   158: invokestatic 100	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
    //   161: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: aload 4
    //   166: swap
    //   167: putfield 651	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
    //   170: getstatic 603	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   173: getstatic 606	gnu/kawa/slib/printf:stdio$Cliprintf	Lgnu/expr/ModuleMethod;
    //   176: aload 4
    //   178: getfield 654	gnu/kawa/slib/printf$frame3:lambda$Fn7	Lgnu/expr/ModuleMethod;
    //   181: aload_1
    //   182: aload_3
    //   183: invokevirtual 612	gnu/mapping/Procedure:apply4	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   186: pop
    //   187: aload 4
    //   189: getfield 635	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
    //   192: invokestatic 518	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
    //   195: ifeq +11 -> 206
    //   198: aload 4
    //   200: getfield 637	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
    //   203: goto +64 -> 267
    //   206: aload 4
    //   208: getfield 651	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
    //   211: aload 4
    //   213: getfield 637	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
    //   216: invokestatic 169	gnu/kawa/functions/IsEqv:apply	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   219: ifeq +11 -> 230
    //   222: aload 4
    //   224: getfield 648	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
    //   227: goto +40 -> 267
    //   230: aload 4
    //   232: getfield 648	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
    //   235: ldc 26
    //   237: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   240: dup
    //   241: astore 5
    //   243: checkcast 26	java/lang/CharSequence
    //   246: iconst_0
    //   247: aload 4
    //   249: getfield 637	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
    //   252: invokestatic 301	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   255: dup
    //   256: astore 5
    //   258: checkcast 143	java/lang/Number
    //   261: invokevirtual 147	java/lang/Number:intValue	()I
    //   264: invokestatic 568	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
    //   267: areturn
    //   268: new 91	gnu/mapping/WrongType
    //   271: dup_x1
    //   272: swap
    //   273: ldc_w 463
    //   276: iconst_1
    //   277: aload 5
    //   279: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   282: athrow
    //   283: new 91	gnu/mapping/WrongType
    //   286: dup_x1
    //   287: swap
    //   288: ldc 93
    //   290: iconst_1
    //   291: aload 5
    //   293: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: new 91	gnu/mapping/WrongType
    //   300: dup_x1
    //   301: swap
    //   302: ldc_w 565
    //   305: iconst_1
    //   306: aload 5
    //   308: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //   312: new 91	gnu/mapping/WrongType
    //   315: dup_x1
    //   316: swap
    //   317: ldc_w 565
    //   320: iconst_3
    //   321: aload 5
    //   323: invokespecial 96	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   326: athrow
    // Line number table:
    //   Java source line #557	-> byte code offset #0
    //   Java source line #558	-> byte code offset #24
    //   Java source line #559	-> byte code offset #33
    //   Java source line #560	-> byte code offset #52
    //   Java source line #561	-> byte code offset #97
    //   Java source line #562	-> byte code offset #105
    //   Java source line #558	-> byte code offset #142
    //   Java source line #563	-> byte code offset #142
    //   Java source line #564	-> byte code offset #170
    //   Java source line #565	-> byte code offset #176
    //   Java source line #584	-> byte code offset #181
    //   Java source line #585	-> byte code offset #182
    //   Java source line #586	-> byte code offset #187
    //   Java source line #587	-> byte code offset #206
    //   Java source line #588	-> byte code offset #230
    //   Java source line #560	-> byte code offset #268
    //   Java source line #563	-> byte code offset #283
    //   Java source line #588	-> byte code offset #297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	str	Object
    //   0	267	1	format	Object
    //   0	267	2	argsArray	Object[]
    //   0	183	3	args	gnu.lists.LList
    //   7	241	4	$heapFrame	frame3
    //   21	301	5	localObject	Object
    //   268	1	6	localClassCastException1	ClassCastException
    //   283	1	7	localClassCastException2	ClassCastException
    //   297	1	8	localClassCastException3	ClassCastException
    //   312	1	9	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   74	80	268	java/lang/ClassCastException
    //   155	158	283	java/lang/ClassCastException
    //   243	246	297	java/lang/ClassCastException
    //   258	264	312	java/lang/ClassCastException
  }
  
  static
  {
    Lit69 = gnu.mapping.Symbol.valueOf("stdio:iprintf");
    Lit68 = gnu.math.IntNum.valueOf(9);
    Lit67 = gnu.math.IntNum.valueOf(5);
    Lit66 = gnu.lists.PairWithPosition.make(printf.Lit40 = Char.valueOf(101), gnu.lists.PairWithPosition.make(printf.Lit58 = Char.valueOf(115), gnu.lists.PairWithPosition.make(printf.Lit3 = Char.valueOf(102), gnu.lists.PairWithPosition.make(printf.Lit39 = Char.valueOf(100), gnu.lists.PairWithPosition.make(printf.Lit21 = Char.valueOf(108), gnu.lists.PairWithPosition.make(printf.Lit26 = Char.valueOf(69), gnu.lists.PairWithPosition.make(printf.Lit35 = Char.valueOf(83), gnu.lists.PairWithPosition.make(printf.Lit5 = Char.valueOf(70), gnu.lists.PairWithPosition.make(printf.Lit25 = Char.valueOf(68), gnu.lists.PairWithPosition.make(printf.Lit20 = Char.valueOf(76), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266284), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266280), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266276), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266272), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266268), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266264), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266256), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266252), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 266247);
    Lit65 = Char.valueOf(64);
    Lit64 = gnu.lists.PairWithPosition.make(printf.Lit17 = Char.valueOf(43), gnu.lists.PairWithPosition.make(printf.Lit18 = Char.valueOf(45), gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 446503), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 446498);
    Lit63 = gnu.mapping.Symbol.valueOf("sprintf");
    Lit62 = gnu.mapping.Symbol.valueOf("pad");
    Lit61 = Char.valueOf(42);
    Lit60 = Char.valueOf(63);
    Lit59 = Char.valueOf(120);
    Lit57 = Char.valueOf(117);
    Lit56 = Char.valueOf(105);
    Lit55 = gnu.mapping.Symbol.valueOf("format-real");
    Lit54 = gnu.lists.PairWithPosition.make("i", gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1638411);
    Object[] tmp359_356 = new Object[17];
    Object[] tmp360_359 = tmp359_356;
    tmp360_359[0] = "y";
    Object[] tmp366_360 = tmp360_359;
    tmp366_360[1] = "z";
    Object[] tmp372_366 = tmp366_360;
    tmp372_366[2] = "a";
    Object[] tmp378_372 = tmp372_366;
    tmp378_372[3] = "f";
    Object[] tmp384_378 = tmp378_372;
    tmp384_378[4] = "p";
    Object[] tmp390_384 = tmp384_378;
    tmp390_384[5] = "n";
    Object[] tmp396_390 = tmp390_384;
    tmp396_390[6] = "u";
    Object[] tmp403_396 = tmp396_390;
    tmp403_396[7] = "m";
    Object[] tmp410_403 = tmp403_396;
    tmp410_403[8] = "";
    Object[] tmp416_410 = tmp410_403;
    tmp416_410[9] = "k";
    Object[] tmp423_416 = tmp416_410;
    tmp423_416[10] = "M";
    Object[] tmp430_423 = tmp423_416;
    tmp430_423[11] = "G";
    Object[] tmp437_430 = tmp430_423;
    tmp437_430[12] = "T";
    Object[] tmp444_437 = tmp437_430;
    tmp444_437[13] = "P";
    Object[] tmp451_444 = tmp444_437;
    tmp451_444[14] = "E";
    Object[] tmp458_451 = tmp451_444;
    tmp458_451[15] = "Z";
    tmp458_451[16] = "Y";
    Lit53 = gnu.lists.FVector.make(tmp359_356);
    Lit52 = gnu.math.IntNum.valueOf(3);
    Lit51 = gnu.math.IntNum.valueOf(10);
    Lit50 = gnu.math.IntNum.valueOf(-10);
    Lit49 = gnu.math.IntNum.valueOf(1);
    Lit48 = gnu.math.IntNum.valueOf(6);
    Lit47 = Char.valueOf(107);
    Lit46 = gnu.math.IntNum.valueOf(8);
    Lit45 = Char.valueOf(111);
    Lit44 = Char.valueOf(97);
    Lit43 = Char.valueOf(99);
    Lit42 = gnu.math.IntNum.valueOf(2);
    Lit41 = Char.valueOf(98);
    Lit38 = Char.valueOf(103);
    Lit37 = gnu.math.IntNum.valueOf(16);
    Lit36 = Char.valueOf(88);
    Lit34 = Char.valueOf(85);
    Lit33 = Char.valueOf(75);
    Lit32 = Char.valueOf(73);
    Lit31 = Char.valueOf(79);
    Lit30 = Char.valueOf(67);
    Lit29 = Char.valueOf(66);
    Lit28 = Char.valueOf(65);
    Lit27 = Char.valueOf(71);
    Lit24 = gnu.mapping.Symbol.valueOf("printf");
    Lit23 = gnu.lists.PairWithPosition.make(Lit43, gnu.lists.PairWithPosition.make(Lit58, gnu.lists.PairWithPosition.make(Lit44, gnu.lists.PairWithPosition.make(Lit39, gnu.lists.PairWithPosition.make(Lit56, gnu.lists.PairWithPosition.make(Lit57, gnu.lists.PairWithPosition.make(Lit45, gnu.lists.PairWithPosition.make(Lit59, gnu.lists.PairWithPosition.make(Lit41, gnu.lists.PairWithPosition.make(Lit3, gnu.lists.PairWithPosition.make(Lit40, gnu.lists.PairWithPosition.make(Lit38, gnu.lists.PairWithPosition.make(Lit47, gnu.lists.LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785876), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785872), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785868), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1785864), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781800), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781796), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781792), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781788), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781784), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781780), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781776), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781772), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm", 1781767);
    Lit22 = Char.valueOf(104);
    Lit19 = Char.valueOf(46);
    Lit16 = Char.valueOf(48);
    Lit15 = Char.valueOf(32);
    Lit14 = Char.valueOf(35);
    Lit13 = gnu.math.IntNum.valueOf(0);
    Lit12 = Char.valueOf(37);
    Lit11 = Char.valueOf(78);
    Lit10 = Char.valueOf(10);
    Lit9 = Char.valueOf(110);
    Lit8 = Char.valueOf(9);
    Lit7 = Char.valueOf(116);
    Lit6 = Char.valueOf(12);
    Lit4 = Char.valueOf(84);
    Lit2 = Char.valueOf(92);
    Lit1 = gnu.math.IntNum.valueOf(-1);
    Lit0 = gnu.math.IntNum.valueOf(-15);
    $instance = new printf();
    printf localPrintf = $instance;
    stdio$Cliprintf = new ModuleMethod(localPrintf, 20, Lit69, 61442);
    fprintf = new ModuleMethod(localPrintf, 21, Lit70, 61442);
    printf = new ModuleMethod(localPrintf, 22, Lit24, 61441);
    sprintf = new ModuleMethod(localPrintf, 23, Lit63, 61442);
    $runBody$();
  }
  
  public printf()
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
    //   1: getfield 751	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+177->181, 20:+32->36, 21:+69->73, 22:+106->110, 23:+140->144
    //   36: aload_2
    //   37: iconst_0
    //   38: aaload
    //   39: aload_2
    //   40: iconst_1
    //   41: aaload
    //   42: aload_2
    //   43: arraylength
    //   44: iconst_2
    //   45: isub
    //   46: istore_3
    //   47: iload_3
    //   48: anewarray 175	java/lang/Object
    //   51: goto +11 -> 62
    //   54: dup
    //   55: iload_3
    //   56: aload_2
    //   57: iload_3
    //   58: iconst_2
    //   59: iadd
    //   60: aaload
    //   61: aastore
    //   62: iinc 3 -1
    //   65: iload_3
    //   66: ifge -12 -> 54
    //   69: invokestatic 770	gnu/kawa/slib/printf:stdio$ClIprintf$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   72: areturn
    //   73: aload_2
    //   74: iconst_0
    //   75: aaload
    //   76: aload_2
    //   77: iconst_1
    //   78: aaload
    //   79: aload_2
    //   80: arraylength
    //   81: iconst_2
    //   82: isub
    //   83: istore_3
    //   84: iload_3
    //   85: anewarray 175	java/lang/Object
    //   88: goto +11 -> 99
    //   91: dup
    //   92: iload_3
    //   93: aload_2
    //   94: iload_3
    //   95: iconst_2
    //   96: iadd
    //   97: aaload
    //   98: aastore
    //   99: iinc 3 -1
    //   102: iload_3
    //   103: ifge -12 -> 91
    //   106: invokestatic 774	gnu/kawa/slib/printf:fprintf$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/math/IntNum;
    //   109: areturn
    //   110: aload_2
    //   111: iconst_0
    //   112: aaload
    //   113: aload_2
    //   114: arraylength
    //   115: iconst_1
    //   116: isub
    //   117: istore_3
    //   118: iload_3
    //   119: anewarray 175	java/lang/Object
    //   122: goto +11 -> 133
    //   125: dup
    //   126: iload_3
    //   127: aload_2
    //   128: iload_3
    //   129: iconst_1
    //   130: iadd
    //   131: aaload
    //   132: aastore
    //   133: iinc 3 -1
    //   136: iload_3
    //   137: ifge -12 -> 125
    //   140: invokestatic 777	gnu/kawa/slib/printf:printf$V	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   143: areturn
    //   144: aload_2
    //   145: iconst_0
    //   146: aaload
    //   147: aload_2
    //   148: iconst_1
    //   149: aaload
    //   150: aload_2
    //   151: arraylength
    //   152: iconst_2
    //   153: isub
    //   154: istore_3
    //   155: iload_3
    //   156: anewarray 175	java/lang/Object
    //   159: goto +11 -> 170
    //   162: dup
    //   163: iload_3
    //   164: aload_2
    //   165: iload_3
    //   166: iconst_2
    //   167: iadd
    //   168: aaload
    //   169: aastore
    //   170: iinc 3 -1
    //   173: iload_3
    //   174: ifge -12 -> 162
    //   177: invokestatic 780	gnu/kawa/slib/printf:sprintf$V	(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   180: areturn
    //   181: aload_0
    //   182: aload_1
    //   183: aload_2
    //   184: invokespecial 784	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   187: areturn
    // Line number table:
    //   Java source line #186	-> byte code offset #36
    //   Java source line #544	-> byte code offset #73
    //   Java source line #554	-> byte code offset #110
    //   Java source line #557	-> byte code offset #144
  }
  
  public class frame3
    extends gnu.expr.ModuleBody
  {
    Object s;
    Object cnt;
    Object end;
    Object str;
    final ModuleMethod lambda$Fn7;
    
    public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
    {
      if (selector == 9) return lambda16(paramObject) ? Boolean.TRUE : Boolean.FALSE; return super.apply1(paramModuleMethod, paramObject); } public void apply(gnu.mapping.CallContext paramCallContext) { ModuleMethod.applyError(); } public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext) { if (selector == 9) { value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
    }
    
    /* Error */
    boolean lambda16(Object x)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 6	kawa/lib/strings:isString	(Ljava/lang/Object;)Z
      //   4: ifeq +282 -> 286
      //   7: aload_0
      //   8: getfield 12	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
      //   11: invokestatic 17	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   14: ifeq +16 -> 30
      //   17: aload_0
      //   18: getfield 12	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
      //   21: invokestatic 17	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   24: ifeq +176 -> 200
      //   27: goto +38 -> 65
      //   30: iconst_m1
      //   31: aload_0
      //   32: getfield 20	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
      //   35: aload_0
      //   36: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   39: invokestatic 29	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   42: aload_1
      //   43: ldc 31
      //   45: invokestatic 37	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   48: dup
      //   49: astore_2
      //   50: checkcast 31	java/lang/CharSequence
      //   53: invokestatic 51	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   56: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   59: invokestatic 63	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   62: ifeq +138 -> 200
      //   65: iconst_2
      //   66: anewarray 65	java/lang/Object
      //   69: dup
      //   70: iconst_0
      //   71: aload_1
      //   72: ldc 31
      //   74: invokestatic 37	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   77: dup
      //   78: astore_2
      //   79: checkcast 31	java/lang/CharSequence
      //   82: invokestatic 51	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   85: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   88: aastore
      //   89: dup
      //   90: iconst_1
      //   91: iconst_m1
      //   92: aload_0
      //   93: getfield 20	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
      //   96: aload_0
      //   97: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   100: invokestatic 29	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   103: aastore
      //   104: invokestatic 71	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
      //   107: getstatic 77	gnu/kawa/slib/printf:Lit13	Lgnu/math/IntNum;
      //   110: astore_3
      //   111: astore_2
      //   112: aload_3
      //   113: aload_2
      //   114: invokestatic 63	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   117: ifne +347 -> 464
      //   120: aload_0
      //   121: getfield 80	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
      //   124: ldc 82
      //   126: invokestatic 37	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   129: dup
      //   130: astore 4
      //   132: checkcast 82	gnu/lists/CharSeq
      //   135: aload_0
      //   136: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   139: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   142: dup
      //   143: astore 4
      //   145: checkcast 89	java/lang/Number
      //   148: invokevirtual 93	java/lang/Number:intValue	()I
      //   151: aload_1
      //   152: ldc 31
      //   154: invokestatic 37	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   157: dup
      //   158: astore 4
      //   160: checkcast 31	java/lang/CharSequence
      //   163: aload_3
      //   164: dup
      //   165: astore 4
      //   167: invokevirtual 93	java/lang/Number:intValue	()I
      //   170: invokestatic 99	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   173: invokestatic 103	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
      //   176: aload_0
      //   177: iconst_1
      //   178: aload_0
      //   179: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   182: getstatic 106	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   185: invokestatic 29	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   188: putfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   191: aload_3
      //   192: iconst_1
      //   193: invokestatic 112	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
      //   196: astore_3
      //   197: goto -85 -> 112
      //   200: aload_0
      //   201: iconst_2
      //   202: anewarray 65	java/lang/Object
      //   205: dup
      //   206: iconst_0
      //   207: aload_0
      //   208: getfield 80	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
      //   211: ldc 31
      //   213: invokestatic 37	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   216: dup
      //   217: astore_2
      //   218: checkcast 31	java/lang/CharSequence
      //   221: iconst_0
      //   222: aload_0
      //   223: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   226: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   229: dup
      //   230: astore_2
      //   231: checkcast 89	java/lang/Number
      //   234: invokevirtual 93	java/lang/Number:intValue	()I
      //   237: invokestatic 117	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   240: aastore
      //   241: dup
      //   242: iconst_1
      //   243: aload_1
      //   244: aastore
      //   245: invokestatic 121	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   248: putfield 80	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
      //   251: aload_0
      //   252: aload_0
      //   253: getfield 80	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
      //   256: ldc 31
      //   258: invokestatic 37	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   261: dup
      //   262: astore_2
      //   263: checkcast 31	java/lang/CharSequence
      //   266: invokestatic 51	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   269: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   272: putfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   275: aload_0
      //   276: aload_0
      //   277: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   280: putfield 20	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
      //   283: goto +181 -> 464
      //   286: aload_0
      //   287: getfield 12	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
      //   290: invokestatic 17	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   293: ifeq +17 -> 310
      //   296: aload_0
      //   297: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   300: aload_0
      //   301: getfield 20	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
      //   304: invokestatic 63	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   307: goto +4 -> 311
      //   310: iconst_0
      //   311: istore_2
      //   312: iload_2
      //   313: ifeq +6 -> 319
      //   316: goto +148 -> 464
      //   319: aload_0
      //   320: getfield 12	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
      //   323: invokestatic 17	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   326: ifne +70 -> 396
      //   329: aload_0
      //   330: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   333: aload_0
      //   334: getfield 20	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
      //   337: invokestatic 63	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   340: ifeq +56 -> 396
      //   343: aload_0
      //   344: iconst_2
      //   345: anewarray 65	java/lang/Object
      //   348: dup
      //   349: iconst_0
      //   350: aload_0
      //   351: getfield 80	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
      //   354: aastore
      //   355: dup
      //   356: iconst_1
      //   357: bipush 100
      //   359: invokestatic 125	kawa/lib/strings:makeString	(I)Lgnu/lists/FString;
      //   362: aastore
      //   363: invokestatic 121	kawa/lib/strings:stringAppend	([Ljava/lang/Object;)Lgnu/lists/FString;
      //   366: putfield 80	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
      //   369: aload_0
      //   370: aload_0
      //   371: getfield 80	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
      //   374: ldc 31
      //   376: invokestatic 37	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   379: dup
      //   380: astore_3
      //   381: checkcast 31	java/lang/CharSequence
      //   384: invokestatic 51	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   387: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   390: putfield 20	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
      //   393: goto +3 -> 396
      //   396: aload_0
      //   397: getfield 80	gnu/kawa/slib/printf$frame3:s	Ljava/lang/Object;
      //   400: ldc 82
      //   402: invokestatic 37	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   405: dup
      //   406: astore_3
      //   407: checkcast 82	gnu/lists/CharSeq
      //   410: aload_0
      //   411: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   414: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   417: dup
      //   418: astore_3
      //   419: checkcast 89	java/lang/Number
      //   422: invokevirtual 93	java/lang/Number:intValue	()I
      //   425: aload_1
      //   426: invokestatic 130	kawa/lib/characters:isChar	(Ljava/lang/Object;)Z
      //   429: ifeq +15 -> 444
      //   432: aload_1
      //   433: invokestatic 87	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   436: dup
      //   437: astore_3
      //   438: invokestatic 136	gnu/text/Char:castToCharacter	(Ljava/lang/Object;)I
      //   441: goto +5 -> 446
      //   444: bipush 63
      //   446: invokestatic 103	kawa/lib/strings:stringSet$Ex	(Lgnu/lists/CharSeq;II)V
      //   449: aload_0
      //   450: iconst_1
      //   451: aload_0
      //   452: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   455: getstatic 106	gnu/kawa/slib/printf:Lit49	Lgnu/math/IntNum;
      //   458: invokestatic 29	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   461: putfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   464: aload_0
      //   465: getfield 12	gnu/kawa/slib/printf$frame3:str	Ljava/lang/Object;
      //   468: invokestatic 17	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   471: ifeq +21 -> 492
      //   474: aload_0
      //   475: getfield 23	gnu/kawa/slib/printf$frame3:cnt	Ljava/lang/Object;
      //   478: aload_0
      //   479: getfield 20	gnu/kawa/slib/printf$frame3:end	Ljava/lang/Object;
      //   482: invokestatic 63	gnu/kawa/functions/NumberCompare:$Gr$Eq	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   485: ifeq +7 -> 492
      //   488: iconst_0
      //   489: goto +4 -> 493
      //   492: iconst_1
      //   493: ireturn
      //   494: new 41	gnu/mapping/WrongType
      //   497: dup_x1
      //   498: swap
      //   499: ldc 43
      //   501: iconst_1
      //   502: aload_2
      //   503: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   506: athrow
      //   507: new 41	gnu/mapping/WrongType
      //   510: dup_x1
      //   511: swap
      //   512: ldc 43
      //   514: iconst_1
      //   515: aload_2
      //   516: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   519: athrow
      //   520: new 41	gnu/mapping/WrongType
      //   523: dup_x1
      //   524: swap
      //   525: ldc 84
      //   527: iconst_1
      //   528: aload 4
      //   530: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   533: athrow
      //   534: new 41	gnu/mapping/WrongType
      //   537: dup_x1
      //   538: swap
      //   539: ldc 84
      //   541: iconst_2
      //   542: aload 4
      //   544: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   547: athrow
      //   548: new 41	gnu/mapping/WrongType
      //   551: dup_x1
      //   552: swap
      //   553: ldc 95
      //   555: iconst_1
      //   556: aload 4
      //   558: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   561: athrow
      //   562: new 41	gnu/mapping/WrongType
      //   565: dup_x1
      //   566: swap
      //   567: ldc 95
      //   569: iconst_2
      //   570: aload 4
      //   572: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   575: athrow
      //   576: new 41	gnu/mapping/WrongType
      //   579: dup_x1
      //   580: swap
      //   581: ldc 114
      //   583: iconst_1
      //   584: aload_2
      //   585: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   588: athrow
      //   589: new 41	gnu/mapping/WrongType
      //   592: dup_x1
      //   593: swap
      //   594: ldc 114
      //   596: iconst_3
      //   597: aload_2
      //   598: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   601: athrow
      //   602: new 41	gnu/mapping/WrongType
      //   605: dup_x1
      //   606: swap
      //   607: ldc 43
      //   609: iconst_1
      //   610: aload_2
      //   611: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   614: athrow
      //   615: new 41	gnu/mapping/WrongType
      //   618: dup_x1
      //   619: swap
      //   620: ldc 43
      //   622: iconst_1
      //   623: aload_3
      //   624: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   627: athrow
      //   628: new 41	gnu/mapping/WrongType
      //   631: dup_x1
      //   632: swap
      //   633: ldc 84
      //   635: iconst_1
      //   636: aload_3
      //   637: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   640: athrow
      //   641: new 41	gnu/mapping/WrongType
      //   644: dup_x1
      //   645: swap
      //   646: ldc 84
      //   648: iconst_2
      //   649: aload_3
      //   650: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   653: athrow
      //   654: new 41	gnu/mapping/WrongType
      //   657: dup_x1
      //   658: swap
      //   659: ldc 84
      //   661: iconst_3
      //   662: aload_3
      //   663: invokespecial 47	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   666: athrow
      // Line number table:
      //   Java source line #565	-> byte code offset #0
      //   Java source line #566	-> byte code offset #0
      //   Java source line #567	-> byte code offset #7
      //   Java source line #568	-> byte code offset #65
      //   Java source line #570	-> byte code offset #112
      //   Java source line #571	-> byte code offset #120
      //   Java source line #572	-> byte code offset #176
      //   Java source line #569	-> byte code offset #191
      //   Java source line #573	-> byte code offset #200
      //   Java source line #574	-> byte code offset #200
      //   Java source line #575	-> byte code offset #251
      //   Java source line #576	-> byte code offset #275
      //   Java source line #577	-> byte code offset #286
      //   Java source line #566	-> byte code offset #312
      //   Java source line #578	-> byte code offset #319
      //   Java source line #579	-> byte code offset #343
      //   Java source line #580	-> byte code offset #369
      //   Java source line #581	-> byte code offset #396
      //   Java source line #582	-> byte code offset #449
      //   Java source line #583	-> byte code offset #464
      //   Java source line #567	-> byte code offset #494
      //   Java source line #568	-> byte code offset #507
      //   Java source line #571	-> byte code offset #520
      //   Java source line #574	-> byte code offset #576
      //   Java source line #575	-> byte code offset #602
      //   Java source line #580	-> byte code offset #615
      //   Java source line #581	-> byte code offset #628
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	494	0	this	frame3
      //   0	493	1	x	Object
      //   49	30	2	localObject1	Object
      //   111	152	2	lend	Object
      //   311	300	2	x	boolean
      //   110	1	3	localIntNum	gnu.math.IntNum
      //   112	551	3	i	Object
      //   130	441	4	localObject2	Object
      //   494	1	8	localClassCastException1	ClassCastException
      //   507	1	9	localClassCastException2	ClassCastException
      //   520	1	10	localClassCastException3	ClassCastException
      //   534	1	11	localClassCastException4	ClassCastException
      //   548	1	12	localClassCastException5	ClassCastException
      //   562	1	13	localClassCastException6	ClassCastException
      //   576	1	14	localClassCastException7	ClassCastException
      //   589	1	15	localClassCastException8	ClassCastException
      //   602	1	16	localClassCastException9	ClassCastException
      //   615	1	17	localClassCastException10	ClassCastException
      //   628	1	18	localClassCastException11	ClassCastException
      //   641	1	19	localClassCastException12	ClassCastException
      //   654	1	20	localClassCastException13	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   50	53	494	java/lang/ClassCastException
      //   79	82	507	java/lang/ClassCastException
      //   132	135	520	java/lang/ClassCastException
      //   145	151	534	java/lang/ClassCastException
      //   160	163	548	java/lang/ClassCastException
      //   167	170	562	java/lang/ClassCastException
      //   218	221	576	java/lang/ClassCastException
      //   231	237	589	java/lang/ClassCastException
      //   263	266	602	java/lang/ClassCastException
      //   381	384	615	java/lang/ClassCastException
      //   407	410	628	java/lang/ClassCastException
      //   419	425	641	java/lang/ClassCastException
      //   438	441	654	java/lang/ClassCastException
    }
    
    public frame3()
    {
      void tmp19_16 = new ModuleMethod(this, 9, null, 4097);
      tmp19_16.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/printf.scm:565");
      lambda$Fn7 = tmp19_16;
    }
  }
}
