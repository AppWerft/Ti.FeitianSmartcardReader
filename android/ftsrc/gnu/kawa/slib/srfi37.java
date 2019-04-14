package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.math.IntNum;

public class srfi37 extends ModuleBody
{
  public static final ModuleMethod option;
  public static final ModuleMethod option$Mnnames;
  public static final ModuleMethod option$Mnrequired$Mnarg$Qu;
  public static final ModuleMethod option$Mnoptional$Mnarg$Qu;
  public static final ModuleMethod option$Mnprocessor;
  public static final ModuleMethod option$Qu;
  public static final ModuleMethod args$Mnfold;
  static final gnu.bytecode.ClassType option$Mntype;
  static final IntNum Lit0;
  static final IntNum Lit1;
  static final IntNum Lit2;
  public static srfi37 $instance;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7;
  static final SimpleSymbol Lit8;
  static final SimpleSymbol Lit9 = Symbol.valueOf("args-fold");
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
  }
  






  public static boolean isOption(Object obj) { return obj instanceof option-type; } public static Object optionNames(option-type obj) { return names; } public static Object isOptionRequiredArg(option-type obj) { return required$Mnarg$Qu; } public static Object isOptionOptionalArg(option-type obj) { return optional$Mnarg$Qu; } public static Object optionProcessor(option-type obj) { return processor; }
  public int match4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, CallContext paramCallContext) { if (selector == 12) { value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0; } return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext); } public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) { if (selector == 12) return option(paramObject1, paramObject2, paramObject3, paramObject4); return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, CallContext paramCallContext)
  {
    switch (selector) {case 16:  Object tmp51_48 = Promise.force(paramObject, option-type.class);
      

















































      if (!(tmp51_48 instanceof option-type)) return -786431; value1 = tmp51_48;proc = paramModuleMethod;pc = 1;return 0;
    case 15: 
      Object tmp83_80 = Promise.force(paramObject, option-type.class);
      
















































      if (!(tmp83_80 instanceof option-type)) return -786431; value1 = tmp83_80;proc = paramModuleMethod;pc = 1;return 0;
    case 14: 
      Object tmp115_112 = Promise.force(paramObject, option-type.class);
      















































      if (!(tmp115_112 instanceof option-type)) return -786431; value1 = tmp115_112;proc = paramModuleMethod;pc = 1;return 0;
    case 13: 
      Object tmp147_144 = Promise.force(paramObject, option-type.class);
      














































      if (!(tmp147_144 instanceof option-type)) return -786431; value1 = tmp147_144;proc = paramModuleMethod;pc = 1;return 0;
    case 11: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); } public Object apply1(ModuleMethod paramModuleMethod, Object paramObject) { switch (selector) {case 11:  return isOption(paramObject) ? Boolean.TRUE : Boolean.FALSE; }
    try { return optionNames((option-type)Promise.force(paramObject, option-type.class));
    }
    catch (ClassCastException localClassCastException1) {
      throw new gnu.mapping.WrongType(localClassCastException1, "option-names", 1, paramObject);
    }
    try
    {
      return isOptionRequiredArg((option-type)Promise.force(paramObject, option-type.class));
    } catch (ClassCastException localClassCastException2) {
      throw new gnu.mapping.WrongType(localClassCastException2, "option-required-arg?", 1, paramObject);
    }
    try
    {
      return isOptionOptionalArg((option-type)Promise.force(paramObject, option-type.class));
    } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "option-optional-arg?", 1, paramObject); } try { return optionProcessor((option-type)Promise.force(paramObject, option-type.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "option-processor", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext) { if (selector == 17) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  
  public class option-type
  {
    public Object names;
    public Object required$Mnarg$Qu;
    public Object optional$Mnarg$Qu;
    public Object processor;
    
    public option-type() {}
  }
  
  public class frame
    extends ModuleBody
  {
    Object operand$Mnproc;
    Object unrecognized$Mnoption$Mnproc;
    Object options;
    
    public frame() {}
    
    /* Error */
    public Object lambda1scanArgs(Object args, Object seeds)
    {
      // Byte code:
      //   0: new 228	gnu/kawa/slib/srfi37$frame3
      //   3: dup
      //   4: invokespecial 229	gnu/kawa/slib/srfi37$frame3:<init>	()V
      //   7: dup
      //   8: aload_0
      //   9: putfield 230	gnu/kawa/slib/srfi37$frame3:staticLink	Lgnu/kawa/slib/srfi37$frame;
      //   12: astore_3
      //   13: aload_1
      //   14: invokestatic 6	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   17: ifeq +16 -> 33
      //   20: getstatic 176	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   23: getstatic 216	kawa/lib/misc:values	Lgnu/expr/ModuleMethod;
      //   26: aload_2
      //   27: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   30: goto +891 -> 921
      //   33: aload_1
      //   34: ldc 20
      //   36: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   39: dup
      //   40: astore 5
      //   42: checkcast 20	gnu/lists/Pair
      //   45: invokestatic 39	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   48: astore 4
      //   50: aload_1
      //   51: ldc 20
      //   53: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   56: dup
      //   57: astore 5
      //   59: checkcast 20	gnu/lists/Pair
      //   62: invokestatic 54	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   65: aload_3
      //   66: swap
      //   67: putfield 231	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   70: ldc -23
      //   72: aload 4
      //   74: ldc 95
      //   76: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   79: dup
      //   80: astore 5
      //   82: checkcast 95	java/lang/CharSequence
      //   85: iconst_0
      //   86: anewarray 95	java/lang/CharSequence
      //   89: invokestatic 239	kawa/lib/strings:isString$Eq	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z
      //   92: ifeq +15 -> 107
      //   95: aload_0
      //   96: aload_3
      //   97: getfield 231	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   100: aload_2
      //   101: invokevirtual 242	gnu/kawa/slib/srfi37$frame:lambda10scanOperands	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   104: goto +817 -> 921
      //   107: aload 4
      //   109: ldc 95
      //   111: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   114: dup
      //   115: astore 6
      //   117: checkcast 95	java/lang/CharSequence
      //   120: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   123: iconst_4
      //   124: if_icmple +166 -> 290
      //   127: bipush 45
      //   129: aload 4
      //   131: ldc 95
      //   133: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   136: dup
      //   137: astore 6
      //   139: checkcast 95	java/lang/CharSequence
      //   142: iconst_0
      //   143: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   146: if_icmpne +138 -> 284
      //   149: bipush 45
      //   151: aload 4
      //   153: ldc 95
      //   155: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   158: dup
      //   159: astore 6
      //   161: checkcast 95	java/lang/CharSequence
      //   164: iconst_1
      //   165: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   168: if_icmpne +110 -> 278
      //   171: bipush 61
      //   173: aload 4
      //   175: ldc 95
      //   177: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   180: dup
      //   181: astore 6
      //   183: checkcast 95	java/lang/CharSequence
      //   186: iconst_2
      //   187: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   190: if_icmpeq +82 -> 272
      //   193: getstatic 245	gnu/kawa/slib/srfi37:Lit0	Lgnu/math/IntNum;
      //   196: astore 6
      //   198: aload 6
      //   200: aload 4
      //   202: ldc 95
      //   204: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   207: dup
      //   208: astore 7
      //   210: checkcast 95	java/lang/CharSequence
      //   213: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   216: i2l
      //   217: invokestatic 109	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
      //   220: ifne +9 -> 229
      //   223: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   226: goto +67 -> 293
      //   229: bipush 61
      //   231: aload 4
      //   233: ldc 95
      //   235: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   238: dup
      //   239: astore 7
      //   241: checkcast 95	java/lang/CharSequence
      //   244: aload 6
      //   246: dup
      //   247: astore 7
      //   249: invokevirtual 120	java/lang/Number:intValue	()I
      //   252: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   255: if_icmpne +8 -> 263
      //   258: aload 6
      //   260: goto +33 -> 293
      //   263: aload 6
      //   265: iconst_1
      //   266: invokestatic 153	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
      //   269: goto -73 -> 196
      //   272: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   275: goto +18 -> 293
      //   278: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   281: goto +12 -> 293
      //   284: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   287: goto +6 -> 293
      //   290: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   293: astore 5
      //   295: aload 5
      //   297: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   300: ifeq +193 -> 493
      //   303: aload 4
      //   305: ldc 95
      //   307: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   310: dup
      //   311: astore 7
      //   313: checkcast 95	java/lang/CharSequence
      //   316: iconst_2
      //   317: aload 5
      //   319: invokestatic 247	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   322: dup
      //   323: astore 7
      //   325: checkcast 116	java/lang/Number
      //   328: invokevirtual 120	java/lang/Number:intValue	()I
      //   331: invokestatic 188	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   334: astore 6
      //   336: aload 4
      //   338: ldc 95
      //   340: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   343: dup
      //   344: astore 8
      //   346: checkcast 95	java/lang/CharSequence
      //   349: iconst_1
      //   350: aload 5
      //   352: getstatic 250	gnu/kawa/slib/srfi37:Lit1	Lgnu/math/IntNum;
      //   355: invokestatic 255	gnu/kawa/functions/AddOp:apply2	(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   358: invokestatic 247	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
      //   361: dup
      //   362: astore 8
      //   364: checkcast 116	java/lang/Number
      //   367: invokevirtual 120	java/lang/Number:intValue	()I
      //   370: aload 4
      //   372: ldc 95
      //   374: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   377: dup
      //   378: astore 8
      //   380: checkcast 95	java/lang/CharSequence
      //   383: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   386: invokestatic 188	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   389: astore 7
      //   391: aload_0
      //   392: aload 6
      //   394: invokevirtual 134	gnu/kawa/slib/srfi37$frame:lambda3findOption	(Ljava/lang/Object;)Ljava/lang/Object;
      //   397: astore 9
      //   399: aload 9
      //   401: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   404: ifeq +8 -> 412
      //   407: aload 9
      //   409: goto +21 -> 430
      //   412: aload 6
      //   414: invokestatic 140	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   417: getstatic 258	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   420: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   423: aload_0
      //   424: getfield 143	gnu/kawa/slib/srfi37$frame:unrecognized$Mnoption$Mnproc	Ljava/lang/Object;
      //   427: invokestatic 149	gnu/kawa/slib/srfi37:option	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/srfi37$option-type;
      //   430: astore 8
      //   432: getstatic 172	gnu/kawa/functions/ApplyWithValues:applyWithValues	Lgnu/kawa/functions/ApplyWithValues;
      //   435: getstatic 176	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   438: iconst_5
      //   439: anewarray 178	java/lang/Object
      //   442: dup
      //   443: iconst_0
      //   444: aload 8
      //   446: ldc -101
      //   448: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   451: dup
      //   452: astore 9
      //   454: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   457: invokestatic 183	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   460: aastore
      //   461: dup
      //   462: iconst_1
      //   463: aload 8
      //   465: aastore
      //   466: dup
      //   467: iconst_2
      //   468: aload 6
      //   470: aastore
      //   471: dup
      //   472: iconst_3
      //   473: aload 7
      //   475: aastore
      //   476: dup
      //   477: iconst_4
      //   478: aload_2
      //   479: aastore
      //   480: invokevirtual 192	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   483: aload_3
      //   484: getfield 261	gnu/kawa/slib/srfi37$frame3:lambda$Fn7	Lgnu/expr/ModuleMethod;
      //   487: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   490: goto +431 -> 921
      //   493: aload 4
      //   495: ldc 95
      //   497: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   500: dup
      //   501: astore 6
      //   503: checkcast 95	java/lang/CharSequence
      //   506: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   509: iconst_3
      //   510: if_icmple +294 -> 804
      //   513: bipush 45
      //   515: aload 4
      //   517: ldc 95
      //   519: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   522: dup
      //   523: astore 6
      //   525: checkcast 95	java/lang/CharSequence
      //   528: iconst_0
      //   529: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   532: if_icmpne +272 -> 804
      //   535: bipush 45
      //   537: aload 4
      //   539: ldc 95
      //   541: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   544: dup
      //   545: astore 6
      //   547: checkcast 95	java/lang/CharSequence
      //   550: iconst_1
      //   551: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   554: if_icmpne +250 -> 804
      //   557: aload 4
      //   559: ldc 95
      //   561: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   564: dup
      //   565: astore 7
      //   567: checkcast 95	java/lang/CharSequence
      //   570: iconst_2
      //   571: aload 4
      //   573: ldc 95
      //   575: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   578: dup
      //   579: astore 7
      //   581: checkcast 95	java/lang/CharSequence
      //   584: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   587: invokestatic 188	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   590: astore 6
      //   592: aload_0
      //   593: aload 6
      //   595: invokevirtual 134	gnu/kawa/slib/srfi37$frame:lambda3findOption	(Ljava/lang/Object;)Ljava/lang/Object;
      //   598: astore 8
      //   600: aload 8
      //   602: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   605: ifeq +8 -> 613
      //   608: aload 8
      //   610: goto +21 -> 631
      //   613: aload 6
      //   615: invokestatic 140	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   618: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   621: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   624: aload_0
      //   625: getfield 143	gnu/kawa/slib/srfi37$frame:unrecognized$Mnoption$Mnproc	Ljava/lang/Object;
      //   628: invokestatic 149	gnu/kawa/slib/srfi37:option	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/srfi37$option-type;
      //   631: astore 7
      //   633: aload 7
      //   635: ldc -101
      //   637: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   640: dup
      //   641: astore 8
      //   643: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   646: invokestatic 161	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   649: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   652: ifeq +90 -> 742
      //   655: aload_3
      //   656: getfield 231	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   659: invokestatic 198	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   662: ifeq +80 -> 742
      //   665: getstatic 172	gnu/kawa/functions/ApplyWithValues:applyWithValues	Lgnu/kawa/functions/ApplyWithValues;
      //   668: getstatic 176	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   671: iconst_5
      //   672: anewarray 178	java/lang/Object
      //   675: dup
      //   676: iconst_0
      //   677: aload 7
      //   679: ldc -101
      //   681: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   684: dup
      //   685: astore 8
      //   687: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   690: invokestatic 183	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   693: aastore
      //   694: dup
      //   695: iconst_1
      //   696: aload 7
      //   698: aastore
      //   699: dup
      //   700: iconst_2
      //   701: aload 6
      //   703: aastore
      //   704: dup
      //   705: iconst_3
      //   706: aload_3
      //   707: getfield 231	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   710: ldc 20
      //   712: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   715: dup
      //   716: astore 8
      //   718: checkcast 20	gnu/lists/Pair
      //   721: invokestatic 39	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   724: aastore
      //   725: dup
      //   726: iconst_4
      //   727: aload_2
      //   728: aastore
      //   729: invokevirtual 192	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   732: aload_3
      //   733: getfield 264	gnu/kawa/slib/srfi37$frame3:lambda$Fn8	Lgnu/expr/ModuleMethod;
      //   736: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   739: goto +182 -> 921
      //   742: getstatic 172	gnu/kawa/functions/ApplyWithValues:applyWithValues	Lgnu/kawa/functions/ApplyWithValues;
      //   745: getstatic 176	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   748: iconst_5
      //   749: anewarray 178	java/lang/Object
      //   752: dup
      //   753: iconst_0
      //   754: aload 7
      //   756: ldc -101
      //   758: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   761: dup
      //   762: astore 8
      //   764: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   767: invokestatic 183	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   770: aastore
      //   771: dup
      //   772: iconst_1
      //   773: aload 7
      //   775: aastore
      //   776: dup
      //   777: iconst_2
      //   778: aload 6
      //   780: aastore
      //   781: dup
      //   782: iconst_3
      //   783: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   786: aastore
      //   787: dup
      //   788: iconst_4
      //   789: aload_2
      //   790: aastore
      //   791: invokevirtual 192	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   794: aload_3
      //   795: getfield 267	gnu/kawa/slib/srfi37$frame3:lambda$Fn9	Lgnu/expr/ModuleMethod;
      //   798: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   801: goto +120 -> 921
      //   804: aload 4
      //   806: ldc 95
      //   808: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   811: dup
      //   812: astore 6
      //   814: checkcast 95	java/lang/CharSequence
      //   817: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   820: iconst_1
      //   821: if_icmple +77 -> 898
      //   824: bipush 45
      //   826: aload 4
      //   828: ldc 95
      //   830: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   833: dup
      //   834: astore 6
      //   836: checkcast 95	java/lang/CharSequence
      //   839: iconst_0
      //   840: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   843: if_icmpne +55 -> 898
      //   846: aload 4
      //   848: ldc 95
      //   850: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   853: dup
      //   854: astore 7
      //   856: checkcast 95	java/lang/CharSequence
      //   859: iconst_1
      //   860: aload 4
      //   862: ldc 95
      //   864: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   867: dup
      //   868: astore 7
      //   870: checkcast 95	java/lang/CharSequence
      //   873: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   876: invokestatic 188	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   879: astore 6
      //   881: aload_0
      //   882: getstatic 270	gnu/kawa/slib/srfi37:Lit2	Lgnu/math/IntNum;
      //   885: aload 6
      //   887: aload_3
      //   888: getfield 231	gnu/kawa/slib/srfi37$frame3:args	Ljava/lang/Object;
      //   891: aload_2
      //   892: invokevirtual 274	gnu/kawa/slib/srfi37$frame:lambda6scanShortOptions	(Lgnu/math/IntNum;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   895: goto +26 -> 921
      //   898: getstatic 172	gnu/kawa/functions/ApplyWithValues:applyWithValues	Lgnu/kawa/functions/ApplyWithValues;
      //   901: getstatic 176	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   904: aload_0
      //   905: getfield 219	gnu/kawa/slib/srfi37$frame:operand$Mnproc	Ljava/lang/Object;
      //   908: aload 4
      //   910: aload_2
      //   911: invokevirtual 223	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   914: aload_3
      //   915: getfield 277	gnu/kawa/slib/srfi37$frame3:lambda$Fn10	Lgnu/expr/ModuleMethod;
      //   918: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   921: areturn
      //   922: new 30	gnu/mapping/WrongType
      //   925: dup_x1
      //   926: swap
      //   927: ldc 32
      //   929: iconst_1
      //   930: aload 5
      //   932: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   935: athrow
      //   936: new 30	gnu/mapping/WrongType
      //   939: dup_x1
      //   940: swap
      //   941: ldc 52
      //   943: iconst_1
      //   944: aload 5
      //   946: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   949: athrow
      //   950: new 30	gnu/mapping/WrongType
      //   953: dup_x1
      //   954: swap
      //   955: ldc -21
      //   957: iconst_2
      //   958: aload 5
      //   960: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   963: athrow
      //   964: new 30	gnu/mapping/WrongType
      //   967: dup_x1
      //   968: swap
      //   969: ldc 97
      //   971: iconst_1
      //   972: aload 6
      //   974: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   977: athrow
      //   978: new 30	gnu/mapping/WrongType
      //   981: dup_x1
      //   982: swap
      //   983: ldc 114
      //   985: iconst_1
      //   986: aload 6
      //   988: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   991: athrow
      //   992: new 30	gnu/mapping/WrongType
      //   995: dup_x1
      //   996: swap
      //   997: ldc 114
      //   999: iconst_1
      //   1000: aload 6
      //   1002: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1005: athrow
      //   1006: new 30	gnu/mapping/WrongType
      //   1009: dup_x1
      //   1010: swap
      //   1011: ldc 114
      //   1013: iconst_1
      //   1014: aload 6
      //   1016: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1019: athrow
      //   1020: new 30	gnu/mapping/WrongType
      //   1023: dup_x1
      //   1024: swap
      //   1025: ldc 97
      //   1027: iconst_1
      //   1028: aload 7
      //   1030: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1033: athrow
      //   1034: new 30	gnu/mapping/WrongType
      //   1037: dup_x1
      //   1038: swap
      //   1039: ldc 114
      //   1041: iconst_1
      //   1042: aload 7
      //   1044: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1047: athrow
      //   1048: new 30	gnu/mapping/WrongType
      //   1051: dup_x1
      //   1052: swap
      //   1053: ldc 114
      //   1055: iconst_2
      //   1056: aload 7
      //   1058: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1061: athrow
      //   1062: new 30	gnu/mapping/WrongType
      //   1065: dup_x1
      //   1066: swap
      //   1067: ldc -71
      //   1069: iconst_1
      //   1070: aload 7
      //   1072: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1075: athrow
      //   1076: new 30	gnu/mapping/WrongType
      //   1079: dup_x1
      //   1080: swap
      //   1081: ldc -71
      //   1083: iconst_3
      //   1084: aload 7
      //   1086: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1089: athrow
      //   1090: new 30	gnu/mapping/WrongType
      //   1093: dup_x1
      //   1094: swap
      //   1095: ldc -71
      //   1097: iconst_1
      //   1098: aload 8
      //   1100: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1103: athrow
      //   1104: new 30	gnu/mapping/WrongType
      //   1107: dup_x1
      //   1108: swap
      //   1109: ldc -71
      //   1111: iconst_2
      //   1112: aload 8
      //   1114: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1117: athrow
      //   1118: new 30	gnu/mapping/WrongType
      //   1121: dup_x1
      //   1122: swap
      //   1123: ldc 97
      //   1125: iconst_1
      //   1126: aload 8
      //   1128: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1131: athrow
      //   1132: new 30	gnu/mapping/WrongType
      //   1135: dup_x1
      //   1136: swap
      //   1137: ldc -76
      //   1139: iconst_0
      //   1140: aload 9
      //   1142: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1145: athrow
      //   1146: new 30	gnu/mapping/WrongType
      //   1149: dup_x1
      //   1150: swap
      //   1151: ldc 97
      //   1153: iconst_1
      //   1154: aload 6
      //   1156: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1159: athrow
      //   1160: new 30	gnu/mapping/WrongType
      //   1163: dup_x1
      //   1164: swap
      //   1165: ldc 114
      //   1167: iconst_1
      //   1168: aload 6
      //   1170: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1173: athrow
      //   1174: new 30	gnu/mapping/WrongType
      //   1177: dup_x1
      //   1178: swap
      //   1179: ldc 114
      //   1181: iconst_1
      //   1182: aload 6
      //   1184: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1187: athrow
      //   1188: new 30	gnu/mapping/WrongType
      //   1191: dup_x1
      //   1192: swap
      //   1193: ldc -71
      //   1195: iconst_1
      //   1196: aload 7
      //   1198: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1201: athrow
      //   1202: new 30	gnu/mapping/WrongType
      //   1205: dup_x1
      //   1206: swap
      //   1207: ldc 97
      //   1209: iconst_1
      //   1210: aload 7
      //   1212: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1215: athrow
      //   1216: new 30	gnu/mapping/WrongType
      //   1219: dup_x1
      //   1220: swap
      //   1221: ldc -99
      //   1223: iconst_0
      //   1224: aload 8
      //   1226: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1229: athrow
      //   1230: new 30	gnu/mapping/WrongType
      //   1233: dup_x1
      //   1234: swap
      //   1235: ldc -76
      //   1237: iconst_0
      //   1238: aload 8
      //   1240: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1243: athrow
      //   1244: new 30	gnu/mapping/WrongType
      //   1247: dup_x1
      //   1248: swap
      //   1249: ldc 32
      //   1251: iconst_1
      //   1252: aload 8
      //   1254: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1257: athrow
      //   1258: new 30	gnu/mapping/WrongType
      //   1261: dup_x1
      //   1262: swap
      //   1263: ldc -76
      //   1265: iconst_0
      //   1266: aload 8
      //   1268: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1271: athrow
      //   1272: new 30	gnu/mapping/WrongType
      //   1275: dup_x1
      //   1276: swap
      //   1277: ldc 97
      //   1279: iconst_1
      //   1280: aload 6
      //   1282: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1285: athrow
      //   1286: new 30	gnu/mapping/WrongType
      //   1289: dup_x1
      //   1290: swap
      //   1291: ldc 114
      //   1293: iconst_1
      //   1294: aload 6
      //   1296: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1299: athrow
      //   1300: new 30	gnu/mapping/WrongType
      //   1303: dup_x1
      //   1304: swap
      //   1305: ldc -71
      //   1307: iconst_1
      //   1308: aload 7
      //   1310: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1313: athrow
      //   1314: new 30	gnu/mapping/WrongType
      //   1317: dup_x1
      //   1318: swap
      //   1319: ldc 97
      //   1321: iconst_1
      //   1322: aload 7
      //   1324: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   1327: athrow
      // Line number table:
      //   Java source line #128	-> byte code offset #0
      //   Java source line #129	-> byte code offset #13
      //   Java source line #130	-> byte code offset #20
      //   Java source line #131	-> byte code offset #33
      //   Java source line #132	-> byte code offset #50
      //   Java source line #135	-> byte code offset #70
      //   Java source line #137	-> byte code offset #70
      //   Java source line #139	-> byte code offset #95
      //   Java source line #145	-> byte code offset #107
      //   Java source line #146	-> byte code offset #129
      //   Java source line #147	-> byte code offset #151
      //   Java source line #148	-> byte code offset #173
      //   Java source line #149	-> byte code offset #193
      //   Java source line #150	-> byte code offset #198
      //   Java source line #152	-> byte code offset #231
      //   Java source line #153	-> byte code offset #258
      //   Java source line #155	-> byte code offset #263
      //   Java source line #135	-> byte code offset #295
      //   Java source line #10000	-> byte code offset #303
      //   Java source line #160	-> byte code offset #303
      //   Java source line #162	-> byte code offset #336
      //   Java source line #163	-> byte code offset #349
      //   Java source line #164	-> byte code offset #370
      //   Java source line #166	-> byte code offset #391
      //   Java source line #167	-> byte code offset #412
      //   Java source line #170	-> byte code offset #423
      //   Java source line #158	-> byte code offset #432
      //   Java source line #172	-> byte code offset #435
      //   Java source line #173	-> byte code offset #463
      //   Java source line #174	-> byte code offset #468
      //   Java source line #175	-> byte code offset #473
      //   Java source line #176	-> byte code offset #478
      //   Java source line #171	-> byte code offset #483
      //   Java source line #179	-> byte code offset #493
      //   Java source line #180	-> byte code offset #515
      //   Java source line #181	-> byte code offset #537
      //   Java source line #183	-> byte code offset #557
      //   Java source line #184	-> byte code offset #592
      //   Java source line #185	-> byte code offset #613
      //   Java source line #186	-> byte code offset #613
      //   Java source line #189	-> byte code offset #624
      //   Java source line #190	-> byte code offset #633
      //   Java source line #191	-> byte code offset #655
      //   Java source line #192	-> byte code offset #665
      //   Java source line #193	-> byte code offset #668
      //   Java source line #194	-> byte code offset #696
      //   Java source line #195	-> byte code offset #701
      //   Java source line #196	-> byte code offset #706
      //   Java source line #197	-> byte code offset #727
      //   Java source line #193	-> byte code offset #732
      //   Java source line #199	-> byte code offset #742
      //   Java source line #200	-> byte code offset #745
      //   Java source line #201	-> byte code offset #773
      //   Java source line #202	-> byte code offset #778
      //   Java source line #204	-> byte code offset #789
      //   Java source line #200	-> byte code offset #794
      //   Java source line #207	-> byte code offset #804
      //   Java source line #208	-> byte code offset #826
      //   Java source line #210	-> byte code offset #846
      //   Java source line #211	-> byte code offset #881
      //   Java source line #213	-> byte code offset #898
      //   Java source line #131	-> byte code offset #922
      //   Java source line #132	-> byte code offset #936
      //   Java source line #137	-> byte code offset #950
      //   Java source line #145	-> byte code offset #964
      //   Java source line #146	-> byte code offset #978
      //   Java source line #147	-> byte code offset #992
      //   Java source line #148	-> byte code offset #1006
      //   Java source line #150	-> byte code offset #1020
      //   Java source line #152	-> byte code offset #1034
      //   Java source line #160	-> byte code offset #1062
      //   Java source line #162	-> byte code offset #1090
      //   Java source line #163	-> byte code offset #1104
      //   Java source line #164	-> byte code offset #1118
      //   Java source line #172	-> byte code offset #1132
      //   Java source line #179	-> byte code offset #1146
      //   Java source line #180	-> byte code offset #1160
      //   Java source line #181	-> byte code offset #1174
      //   Java source line #183	-> byte code offset #1188
      //   Java source line #190	-> byte code offset #1216
      //   Java source line #193	-> byte code offset #1230
      //   Java source line #196	-> byte code offset #1244
      //   Java source line #200	-> byte code offset #1258
      //   Java source line #207	-> byte code offset #1272
      //   Java source line #208	-> byte code offset #1286
      //   Java source line #210	-> byte code offset #1300
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	922	0	this	frame
      //   0	921	1	args	Object
      //   0	921	2	seeds	Object
      //   12	903	3	$heapFrame	srfi37.frame3
      //   48	1	4	localObject1	Object
      //   70	839	4	arg	Object
      //   40	41	5	localObject2	Object
      //   293	666	5	temp	Object
      //   115	67	6	localObject3	Object
      //   196	68	6	index	IntNum
      //   334	212	6	name	Object
      //   590	245	6	name	Object
      //   879	416	6	shorts	CharSequence
      //   208	116	7	localObject4	Object
      //   389	191	7	option$Mnarg	Object
      //   631	692	7	option	Object
      //   344	35	8	localObject5	Object
      //   430	34	8	option	Object
      //   598	669	8	x	Object
      //   397	744	9	x	Object
      //   922	1	20	localClassCastException1	ClassCastException
      //   936	1	21	localClassCastException2	ClassCastException
      //   950	1	22	localClassCastException3	ClassCastException
      //   964	1	23	localClassCastException4	ClassCastException
      //   978	1	24	localClassCastException5	ClassCastException
      //   992	1	25	localClassCastException6	ClassCastException
      //   1006	1	26	localClassCastException7	ClassCastException
      //   1020	1	27	localClassCastException8	ClassCastException
      //   1034	1	28	localClassCastException9	ClassCastException
      //   1048	1	29	localClassCastException10	ClassCastException
      //   1062	1	30	localClassCastException11	ClassCastException
      //   1076	1	31	localClassCastException12	ClassCastException
      //   1090	1	32	localClassCastException13	ClassCastException
      //   1104	1	33	localClassCastException14	ClassCastException
      //   1118	1	34	localClassCastException15	ClassCastException
      //   1132	1	35	localClassCastException16	ClassCastException
      //   1146	1	36	localClassCastException17	ClassCastException
      //   1160	1	37	localClassCastException18	ClassCastException
      //   1174	1	38	localClassCastException19	ClassCastException
      //   1188	1	39	localClassCastException20	ClassCastException
      //   1202	1	40	localClassCastException21	ClassCastException
      //   1216	1	41	localClassCastException22	ClassCastException
      //   1230	1	42	localClassCastException23	ClassCastException
      //   1244	1	43	localClassCastException24	ClassCastException
      //   1258	1	44	localClassCastException25	ClassCastException
      //   1272	1	45	localClassCastException26	ClassCastException
      //   1286	1	46	localClassCastException27	ClassCastException
      //   1300	1	47	localClassCastException28	ClassCastException
      //   1314	1	48	localClassCastException29	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   42	45	922	java/lang/ClassCastException
      //   59	62	936	java/lang/ClassCastException
      //   82	85	950	java/lang/ClassCastException
      //   117	120	964	java/lang/ClassCastException
      //   139	142	978	java/lang/ClassCastException
      //   161	164	992	java/lang/ClassCastException
      //   183	186	1006	java/lang/ClassCastException
      //   210	213	1020	java/lang/ClassCastException
      //   241	244	1034	java/lang/ClassCastException
      //   249	252	1048	java/lang/ClassCastException
      //   313	316	1062	java/lang/ClassCastException
      //   325	331	1076	java/lang/ClassCastException
      //   346	349	1090	java/lang/ClassCastException
      //   364	370	1104	java/lang/ClassCastException
      //   380	383	1118	java/lang/ClassCastException
      //   454	457	1132	java/lang/ClassCastException
      //   503	506	1146	java/lang/ClassCastException
      //   525	528	1160	java/lang/ClassCastException
      //   547	550	1174	java/lang/ClassCastException
      //   567	570	1188	java/lang/ClassCastException
      //   581	584	1202	java/lang/ClassCastException
      //   643	646	1216	java/lang/ClassCastException
      //   687	690	1230	java/lang/ClassCastException
      //   718	721	1244	java/lang/ClassCastException
      //   764	767	1258	java/lang/ClassCastException
      //   814	817	1272	java/lang/ClassCastException
      //   836	839	1286	java/lang/ClassCastException
      //   856	859	1300	java/lang/ClassCastException
      //   870	873	1314	java/lang/ClassCastException
    }
    
    /* Error */
    public static Object lambda2find(Object l, Object $Qu)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic 6	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
      //   4: ifeq +9 -> 13
      //   7: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   10: goto +65 -> 75
      //   13: getstatic 18	kawa/standard/Scheme:applyToArgs	Lgnu/kawa/functions/ApplyToArgs;
      //   16: aload_1
      //   17: aload_0
      //   18: ldc 20
      //   20: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   23: dup
      //   24: astore_2
      //   25: checkcast 20	gnu/lists/Pair
      //   28: invokestatic 39	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   31: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   34: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   37: ifeq +20 -> 57
      //   40: aload_0
      //   41: ldc 20
      //   43: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   46: dup
      //   47: astore_2
      //   48: checkcast 20	gnu/lists/Pair
      //   51: invokestatic 39	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   54: goto +21 -> 75
      //   57: aload_0
      //   58: ldc 20
      //   60: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   63: dup
      //   64: astore_2
      //   65: checkcast 20	gnu/lists/Pair
      //   68: invokestatic 54	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   71: astore_0
      //   72: goto -72 -> 0
      //   75: areturn
      //   76: new 30	gnu/mapping/WrongType
      //   79: dup_x1
      //   80: swap
      //   81: ldc 32
      //   83: iconst_1
      //   84: aload_2
      //   85: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   88: athrow
      //   89: new 30	gnu/mapping/WrongType
      //   92: dup_x1
      //   93: swap
      //   94: ldc 32
      //   96: iconst_1
      //   97: aload_2
      //   98: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   101: athrow
      //   102: new 30	gnu/mapping/WrongType
      //   105: dup_x1
      //   106: swap
      //   107: ldc 52
      //   109: iconst_1
      //   110: aload_2
      //   111: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   114: athrow
      // Line number table:
      //   Java source line #61	-> byte code offset #0
      //   Java source line #62	-> byte code offset #0
      //   Java source line #63	-> byte code offset #16
      //   Java source line #64	-> byte code offset #57
      //   Java source line #63	-> byte code offset #76
      //   Java source line #64	-> byte code offset #102
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	l	Object
      //   0	75	1	$Qu	Object
      // Exception table:
      //   from	to	target	type
      //   25	28	76	java/lang/ClassCastException
      //   48	51	89	java/lang/ClassCastException
      //   65	68	102	java/lang/ClassCastException
    }
    
    public Object lambda3findOption(Object name)
    {
      void tmp7_4 = new srfi37.frame0();74staticLink = this;srfi37.frame0 $heapFrame = tmp7_4;name = name;
      

      return lambda2find(options, lambda$Fn1);
    }
    
    /* Error */
    public Object lambda6scanShortOptions(IntNum index, Object shorts, Object args, Object seeds)
    {
      // Byte code:
      //   0: new 81	gnu/kawa/slib/srfi37$frame1
      //   3: dup
      //   4: invokespecial 82	gnu/kawa/slib/srfi37$frame1:<init>	()V
      //   7: dup
      //   8: aload_0
      //   9: putfield 83	gnu/kawa/slib/srfi37$frame1:staticLink	Lgnu/kawa/slib/srfi37$frame;
      //   12: astore 5
      //   14: aload 5
      //   16: aload_1
      //   17: putfield 87	gnu/kawa/slib/srfi37$frame1:index	Lgnu/math/IntNum;
      //   20: aload 5
      //   22: aload_2
      //   23: putfield 90	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   26: aload 5
      //   28: aload_3
      //   29: putfield 93	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   32: aload 5
      //   34: getfield 87	gnu/kawa/slib/srfi37$frame1:index	Lgnu/math/IntNum;
      //   37: aload 5
      //   39: getfield 90	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   42: ldc 95
      //   44: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   47: dup
      //   48: astore 6
      //   50: checkcast 95	java/lang/CharSequence
      //   53: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   56: i2l
      //   57: invokestatic 109	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
      //   60: ifne +17 -> 77
      //   63: aload_0
      //   64: aload 5
      //   66: getfield 93	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   69: aload 4
      //   71: invokevirtual 112	gnu/kawa/slib/srfi37$frame:lambda1scanArgs	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   74: goto +468 -> 542
      //   77: aload 5
      //   79: getfield 90	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   82: ldc 95
      //   84: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   87: dup
      //   88: astore 7
      //   90: checkcast 95	java/lang/CharSequence
      //   93: aload 5
      //   95: getfield 87	gnu/kawa/slib/srfi37$frame1:index	Lgnu/math/IntNum;
      //   98: dup
      //   99: astore 7
      //   101: invokevirtual 120	java/lang/Number:intValue	()I
      //   104: invokestatic 124	kawa/lib/strings:stringRef	(Ljava/lang/CharSequence;I)I
      //   107: istore 6
      //   109: aload_0
      //   110: iload 6
      //   112: invokestatic 130	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   115: invokevirtual 134	gnu/kawa/slib/srfi37$frame:lambda3findOption	(Ljava/lang/Object;)Ljava/lang/Object;
      //   118: astore 8
      //   120: aload 8
      //   122: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   125: ifeq +8 -> 133
      //   128: aload 8
      //   130: goto +24 -> 154
      //   133: iload 6
      //   135: invokestatic 130	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   138: invokestatic 140	gnu/lists/LList:list1	(Ljava/lang/Object;)Lgnu/lists/Pair;
      //   141: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   144: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   147: aload_0
      //   148: getfield 143	gnu/kawa/slib/srfi37$frame:unrecognized$Mnoption$Mnproc	Ljava/lang/Object;
      //   151: invokestatic 149	gnu/kawa/slib/srfi37:option	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/kawa/slib/srfi37$option-type;
      //   154: astore 7
      //   156: aload 5
      //   158: getfield 87	gnu/kawa/slib/srfi37$frame1:index	Lgnu/math/IntNum;
      //   161: iconst_1
      //   162: invokestatic 153	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
      //   165: aload 5
      //   167: getfield 90	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   170: ldc 95
      //   172: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   175: dup
      //   176: astore 8
      //   178: checkcast 95	java/lang/CharSequence
      //   181: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   184: i2l
      //   185: invokestatic 109	gnu/math/IntNum:compare	(Lgnu/math/IntNum;J)I
      //   188: ifge +174 -> 362
      //   191: aload 7
      //   193: ldc -101
      //   195: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   198: dup
      //   199: astore 9
      //   201: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   204: invokestatic 161	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   207: astore 8
      //   209: aload 8
      //   211: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   214: ifeq +14 -> 228
      //   217: aload 8
      //   219: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   222: ifeq +140 -> 362
      //   225: goto +25 -> 250
      //   228: aload 7
      //   230: ldc -101
      //   232: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   235: dup
      //   236: astore 9
      //   238: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   241: invokestatic 166	gnu/kawa/slib/srfi37:isOptionOptionalArg	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   244: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   247: ifeq +115 -> 362
      //   250: getstatic 172	gnu/kawa/functions/ApplyWithValues:applyWithValues	Lgnu/kawa/functions/ApplyWithValues;
      //   253: getstatic 176	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   256: iconst_5
      //   257: anewarray 178	java/lang/Object
      //   260: dup
      //   261: iconst_0
      //   262: aload 7
      //   264: ldc -101
      //   266: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   269: dup
      //   270: astore 9
      //   272: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   275: invokestatic 183	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   278: aastore
      //   279: dup
      //   280: iconst_1
      //   281: aload 7
      //   283: aastore
      //   284: dup
      //   285: iconst_2
      //   286: iload 6
      //   288: invokestatic 130	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   291: aastore
      //   292: dup
      //   293: iconst_3
      //   294: aload 5
      //   296: getfield 90	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   299: ldc 95
      //   301: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   304: dup
      //   305: astore 9
      //   307: checkcast 95	java/lang/CharSequence
      //   310: aload 5
      //   312: getfield 87	gnu/kawa/slib/srfi37$frame1:index	Lgnu/math/IntNum;
      //   315: invokevirtual 120	java/lang/Number:intValue	()I
      //   318: iconst_1
      //   319: iadd
      //   320: aload 5
      //   322: getfield 90	gnu/kawa/slib/srfi37$frame1:shorts	Ljava/lang/Object;
      //   325: ldc 95
      //   327: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   330: dup
      //   331: astore 9
      //   333: checkcast 95	java/lang/CharSequence
      //   336: invokestatic 103	kawa/lib/strings:stringLength	(Ljava/lang/CharSequence;)I
      //   339: invokestatic 188	kawa/lib/strings:substring	(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
      //   342: aastore
      //   343: dup
      //   344: iconst_4
      //   345: aload 4
      //   347: aastore
      //   348: invokevirtual 192	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   351: aload 5
      //   353: getfield 195	gnu/kawa/slib/srfi37$frame1:lambda$Fn3	Lgnu/expr/ModuleMethod;
      //   356: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   359: goto +183 -> 542
      //   362: aload 7
      //   364: ldc -101
      //   366: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   369: dup
      //   370: astore 8
      //   372: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   375: invokestatic 161	gnu/kawa/slib/srfi37:isOptionRequiredArg	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   378: invokestatic 50	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
      //   381: ifeq +97 -> 478
      //   384: aload 5
      //   386: getfield 93	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   389: invokestatic 198	kawa/lib/lists:isPair	(Ljava/lang/Object;)Z
      //   392: ifeq +86 -> 478
      //   395: getstatic 172	gnu/kawa/functions/ApplyWithValues:applyWithValues	Lgnu/kawa/functions/ApplyWithValues;
      //   398: getstatic 176	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   401: iconst_5
      //   402: anewarray 178	java/lang/Object
      //   405: dup
      //   406: iconst_0
      //   407: aload 7
      //   409: ldc -101
      //   411: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   414: dup
      //   415: astore 8
      //   417: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   420: invokestatic 183	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   423: aastore
      //   424: dup
      //   425: iconst_1
      //   426: aload 7
      //   428: aastore
      //   429: dup
      //   430: iconst_2
      //   431: iload 6
      //   433: invokestatic 130	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   436: aastore
      //   437: dup
      //   438: iconst_3
      //   439: aload 5
      //   441: getfield 93	gnu/kawa/slib/srfi37$frame1:args	Ljava/lang/Object;
      //   444: ldc 20
      //   446: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   449: dup
      //   450: astore 8
      //   452: checkcast 20	gnu/lists/Pair
      //   455: invokestatic 39	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
      //   458: aastore
      //   459: dup
      //   460: iconst_4
      //   461: aload 4
      //   463: aastore
      //   464: invokevirtual 192	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   467: aload 5
      //   469: getfield 201	gnu/kawa/slib/srfi37$frame1:lambda$Fn4	Lgnu/expr/ModuleMethod;
      //   472: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   475: goto +67 -> 542
      //   478: getstatic 172	gnu/kawa/functions/ApplyWithValues:applyWithValues	Lgnu/kawa/functions/ApplyWithValues;
      //   481: getstatic 176	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
      //   484: iconst_5
      //   485: anewarray 178	java/lang/Object
      //   488: dup
      //   489: iconst_0
      //   490: aload 7
      //   492: ldc -101
      //   494: invokestatic 26	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
      //   497: dup
      //   498: astore 8
      //   500: checkcast 155	gnu/kawa/slib/srfi37$option-type
      //   503: invokestatic 183	gnu/kawa/slib/srfi37:optionProcessor	(Lgnu/kawa/slib/srfi37$option-type;)Ljava/lang/Object;
      //   506: aastore
      //   507: dup
      //   508: iconst_1
      //   509: aload 7
      //   511: aastore
      //   512: dup
      //   513: iconst_2
      //   514: iload 6
      //   516: invokestatic 130	gnu/text/Char:make	(I)Lgnu/text/Char;
      //   519: aastore
      //   520: dup
      //   521: iconst_3
      //   522: getstatic 12	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   525: aastore
      //   526: dup
      //   527: iconst_4
      //   528: aload 4
      //   530: aastore
      //   531: invokevirtual 192	gnu/mapping/Procedure:applyN	([Ljava/lang/Object;)Ljava/lang/Object;
      //   534: aload 5
      //   536: getfield 204	gnu/kawa/slib/srfi37$frame1:lambda$Fn5	Lgnu/expr/ModuleMethod;
      //   539: invokevirtual 45	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   542: areturn
      //   543: new 30	gnu/mapping/WrongType
      //   546: dup_x1
      //   547: swap
      //   548: ldc 97
      //   550: iconst_1
      //   551: aload 6
      //   553: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   556: athrow
      //   557: new 30	gnu/mapping/WrongType
      //   560: dup_x1
      //   561: swap
      //   562: ldc 114
      //   564: iconst_1
      //   565: aload 7
      //   567: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   570: athrow
      //   571: new 30	gnu/mapping/WrongType
      //   574: dup_x1
      //   575: swap
      //   576: ldc 114
      //   578: iconst_2
      //   579: aload 7
      //   581: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   584: athrow
      //   585: new 30	gnu/mapping/WrongType
      //   588: dup_x1
      //   589: swap
      //   590: ldc 97
      //   592: iconst_1
      //   593: aload 8
      //   595: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   598: athrow
      //   599: new 30	gnu/mapping/WrongType
      //   602: dup_x1
      //   603: swap
      //   604: ldc -99
      //   606: iconst_0
      //   607: aload 9
      //   609: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   612: athrow
      //   613: new 30	gnu/mapping/WrongType
      //   616: dup_x1
      //   617: swap
      //   618: ldc -93
      //   620: iconst_0
      //   621: aload 9
      //   623: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   626: athrow
      //   627: new 30	gnu/mapping/WrongType
      //   630: dup_x1
      //   631: swap
      //   632: ldc -76
      //   634: iconst_0
      //   635: aload 9
      //   637: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   640: athrow
      //   641: new 30	gnu/mapping/WrongType
      //   644: dup_x1
      //   645: swap
      //   646: ldc -71
      //   648: iconst_1
      //   649: aload 9
      //   651: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   654: athrow
      //   655: new 30	gnu/mapping/WrongType
      //   658: dup_x1
      //   659: swap
      //   660: ldc 97
      //   662: iconst_1
      //   663: aload 9
      //   665: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   668: athrow
      //   669: new 30	gnu/mapping/WrongType
      //   672: dup_x1
      //   673: swap
      //   674: ldc -99
      //   676: iconst_0
      //   677: aload 8
      //   679: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   682: athrow
      //   683: new 30	gnu/mapping/WrongType
      //   686: dup_x1
      //   687: swap
      //   688: ldc -76
      //   690: iconst_0
      //   691: aload 8
      //   693: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   696: athrow
      //   697: new 30	gnu/mapping/WrongType
      //   700: dup_x1
      //   701: swap
      //   702: ldc 32
      //   704: iconst_1
      //   705: aload 8
      //   707: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   710: athrow
      //   711: new 30	gnu/mapping/WrongType
      //   714: dup_x1
      //   715: swap
      //   716: ldc -76
      //   718: iconst_0
      //   719: aload 8
      //   721: invokespecial 36	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
      //   724: athrow
      // Line number table:
      //   Java source line #76	-> byte code offset #0
      //   Java source line #77	-> byte code offset #32
      //   Java source line #78	-> byte code offset #63
      //   Java source line #79	-> byte code offset #77
      //   Java source line #80	-> byte code offset #109
      //   Java source line #81	-> byte code offset #133
      //   Java source line #84	-> byte code offset #147
      //   Java source line #85	-> byte code offset #156
      //   Java source line #86	-> byte code offset #191
      //   Java source line #87	-> byte code offset #228
      //   Java source line #88	-> byte code offset #250
      //   Java source line #89	-> byte code offset #253
      //   Java source line #90	-> byte code offset #281
      //   Java source line #91	-> byte code offset #286
      //   Java source line #92	-> byte code offset #294
      //   Java source line #93	-> byte code offset #294
      //   Java source line #94	-> byte code offset #310
      //   Java source line #95	-> byte code offset #320
      //   Java source line #96	-> byte code offset #345
      //   Java source line #89	-> byte code offset #351
      //   Java source line #98	-> byte code offset #362
      //   Java source line #99	-> byte code offset #384
      //   Java source line #100	-> byte code offset #395
      //   Java source line #101	-> byte code offset #398
      //   Java source line #102	-> byte code offset #426
      //   Java source line #103	-> byte code offset #431
      //   Java source line #104	-> byte code offset #439
      //   Java source line #105	-> byte code offset #461
      //   Java source line #101	-> byte code offset #467
      //   Java source line #108	-> byte code offset #478
      //   Java source line #109	-> byte code offset #481
      //   Java source line #110	-> byte code offset #509
      //   Java source line #111	-> byte code offset #514
      //   Java source line #113	-> byte code offset #528
      //   Java source line #109	-> byte code offset #534
      //   Java source line #77	-> byte code offset #543
      //   Java source line #79	-> byte code offset #557
      //   Java source line #85	-> byte code offset #585
      //   Java source line #86	-> byte code offset #599
      //   Java source line #87	-> byte code offset #613
      //   Java source line #89	-> byte code offset #627
      //   Java source line #93	-> byte code offset #641
      //   Java source line #95	-> byte code offset #655
      //   Java source line #98	-> byte code offset #669
      //   Java source line #101	-> byte code offset #683
      //   Java source line #104	-> byte code offset #697
      //   Java source line #109	-> byte code offset #711
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	543	0	this	frame
      //   0	542	1	index	IntNum
      //   0	542	2	shorts	Object
      //   0	542	3	args	Object
      //   0	542	4	seeds	Object
      //   12	523	5	$heapFrame	srfi37.frame1
      //   48	1	6	localObject1	Object
      //   107	445	6	name	int
      //   88	12	7	localObject2	Object
      //   154	426	7	option	Object
      //   118	59	8	x	Object
      //   207	513	8	x	Object
      //   199	465	9	localObject3	Object
      //   543	1	13	localClassCastException1	ClassCastException
      //   557	1	14	localClassCastException2	ClassCastException
      //   571	1	15	localClassCastException3	ClassCastException
      //   585	1	16	localClassCastException4	ClassCastException
      //   599	1	17	localClassCastException5	ClassCastException
      //   613	1	18	localClassCastException6	ClassCastException
      //   627	1	19	localClassCastException7	ClassCastException
      //   641	1	20	localClassCastException8	ClassCastException
      //   655	1	21	localClassCastException9	ClassCastException
      //   669	1	22	localClassCastException10	ClassCastException
      //   683	1	23	localClassCastException11	ClassCastException
      //   697	1	24	localClassCastException12	ClassCastException
      //   711	1	25	localClassCastException13	ClassCastException
      // Exception table:
      //   from	to	target	type
      //   50	53	543	java/lang/ClassCastException
      //   90	93	557	java/lang/ClassCastException
      //   101	104	571	java/lang/ClassCastException
      //   178	181	585	java/lang/ClassCastException
      //   201	204	599	java/lang/ClassCastException
      //   238	241	613	java/lang/ClassCastException
      //   272	275	627	java/lang/ClassCastException
      //   307	310	641	java/lang/ClassCastException
      //   333	336	655	java/lang/ClassCastException
      //   372	375	669	java/lang/ClassCastException
      //   417	420	683	java/lang/ClassCastException
      //   452	455	697	java/lang/ClassCastException
      //   500	503	711	java/lang/ClassCastException
    }
    
    public Object lambda10scanOperands(Object operands, Object seeds)
    {
      void tmp7_4 = new srfi37.frame2();74staticLink = this;srfi37.frame2 $heapFrame = tmp7_4;operands = operands;
      try
      {
        return kawa.lib.lists.isNull(operands) ? kawa.standard.Scheme.apply.apply2(kawa.lib.misc.values, seeds) : gnu.kawa.functions.ApplyWithValues.applyWithValues.apply2(kawa.standard.Scheme.apply
        
          .apply3(operand$Mnproc, kawa.lib.lists.car((gnu.lists.Pair)(localObject = Promise.force(operands, gnu.lists.Pair.class))), seeds), lambda$Fn6);
      }
      catch (ClassCastException localClassCastException)
      {
        Object localObject;
        throw new gnu.mapping.WrongType(localClassCastException, "car", 1, localObject);
      }
    }
  }
  
  public static Object argsFold$V(Object args, Object options, Object unrecognizedOptionProc, Object operandProc, Object[] argsArray)
  {
    frame $heapFrame = new frame();options = options;unrecognized$Mnoption$Mnproc = unrecognizedOptionProc;operand$Mnproc = operandProc; gnu.lists.LList localLList1; gnu.lists.LList seeds = localLList1 = gnu.lists.LList.makeList(argsArray, 0);
    
































































































































































    return $heapFrame.lambda1scanArgs(args, seeds);
  }
  
  public static option-type option(Object names, Object required$Mnarg$Qu, Object optional$Mnarg$Qu, Object processor)
  {
    option-type tmp = new option-type();names = names;required$Mnarg$Qu = required$Mnarg$Qu;optional$Mnarg$Qu = optional$Mnarg$Qu;processor = processor;
    

































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    return tmp;
  }
  
  static
  {
    Lit8 = Symbol.valueOf("option-processor");
    Lit7 = Symbol.valueOf("option-optional-arg?");
    Lit6 = Symbol.valueOf("option-required-arg?");
    Lit5 = Symbol.valueOf("option-names");
    Lit4 = Symbol.valueOf("option");
    Lit3 = Symbol.valueOf("option?");
    Lit2 = IntNum.valueOf(0);
    Lit1 = IntNum.valueOf(1);
    Lit0 = IntNum.valueOf(3);
    option$Mntype = (gnu.bytecode.ClassType)gnu.bytecode.Type.make(option-type.class);
    $instance = new srfi37();
    srfi37 localSrfi37 = $instance;
    option$Qu = new ModuleMethod(localSrfi37, 11, Lit3, 4097);
    option = new ModuleMethod(localSrfi37, 12, Lit4, 16388);
    option$Mnnames = new ModuleMethod(localSrfi37, 13, Lit5, 4097);
    option$Mnrequired$Mnarg$Qu = new ModuleMethod(localSrfi37, 14, Lit6, 4097);
    option$Mnoptional$Mnarg$Qu = new ModuleMethod(localSrfi37, 15, Lit7, 4097);
    option$Mnprocessor = new ModuleMethod(localSrfi37, 16, Lit8, 4097);
    args$Mnfold = new ModuleMethod(localSrfi37, 17, Lit9, 61444);
    $runBody$();
  }
  
  public srfi37()
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
    //   1: getfield 123	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 17
    //   6: if_icmpne +49 -> 55
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: iconst_0
    //   14: aaload
    //   15: aload_2
    //   16: iconst_1
    //   17: aaload
    //   18: aload_2
    //   19: iconst_2
    //   20: aaload
    //   21: aload_2
    //   22: iconst_3
    //   23: aaload
    //   24: aload_2
    //   25: arraylength
    //   26: iconst_4
    //   27: isub
    //   28: istore_3
    //   29: iload_3
    //   30: anewarray 222	java/lang/Object
    //   33: goto +11 -> 44
    //   36: dup
    //   37: iload_3
    //   38: aload_2
    //   39: iload_3
    //   40: iconst_4
    //   41: iadd
    //   42: aaload
    //   43: aastore
    //   44: iinc 3 -1
    //   47: iload_3
    //   48: ifge -12 -> 36
    //   51: invokestatic 226	gnu/kawa/slib/srfi37:argsFold$V	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: areturn
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokespecial 230	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: areturn
    // Line number table:
    //   Java source line #53	-> byte code offset #12
  }
}
