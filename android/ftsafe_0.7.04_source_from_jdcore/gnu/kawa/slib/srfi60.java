package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.numbers;

public class srfi60 extends ModuleBody
{
  public static final int $Pcprovide$Pcsrfi$Mn60 = 123;
  public static final StaticFieldLocation arithmetic$Mnshift;
  public static final StaticFieldLocation ash;
  public static final StaticFieldLocation bitwise$Mnand;
  public static final StaticFieldLocation logand;
  public static final StaticFieldLocation bitwise$Mnior;
  public static final StaticFieldLocation logior;
  public static final StaticFieldLocation bitwise$Mnnot;
  public static final StaticFieldLocation lognot;
  public static final StaticFieldLocation bitwise$Mnxor;
  public static final StaticFieldLocation logxor;
  public static final StaticFieldLocation integer$Mnlength;
  public static final StaticFieldLocation bitwise$Mnif;
  public static final StaticFieldLocation logtest;
  public static final StaticFieldLocation logcount;
  public static ModuleMethod bitwise$Mnmerge;
  public static ModuleMethod any$Mnbits$Mnset$Qu;
  public static ModuleMethod bit$Mncount;
  public static ModuleMethod log2$Mnbinary$Mnfactors;
  public static ModuleMethod first$Mnset$Mnbit;
  public static ModuleMethod bit$Mnfield;
  public static ModuleMethod reverse$Mnbit$Mnfield;
  public static final ModuleMethod logbit$Qu;
  public static Procedure bit$Mnset$Qu;
  public static final ModuleMethod copy$Mnbit$Mnfield;
  public static final ModuleMethod rotate$Mnbit$Mnfield;
  public static final ModuleMethod copy$Mnbit;
  public static final ModuleMethod integer$Mn$Grlist;
  public static final ModuleMethod list$Mn$Grinteger;
  public static final ModuleMethod booleans$Mn$Grinteger;
  static final IntNum Lit0;
  public static srfi60 $instance;
  static final SimpleSymbol Lit1;
  static final SimpleSymbol Lit2;
  static final SimpleSymbol Lit3;
  static final SimpleSymbol Lit4;
  static final SimpleSymbol Lit5;
  static final SimpleSymbol Lit6;
  static final SimpleSymbol Lit7 = Symbol.valueOf("booleans->integer");
  
  public static boolean isLogbit(int index, IntNum n)
  {
    return numbers.isBitwiseBitSet(n, index);
  }
  
  private static void $runBody$()
  {
    ;
    Consumer $result = getInstanceconsumer;
    

























    bitwise$Mnmerge = numbers.bitwise$Mnif;
    any$Mnbits$Mnset$Qu = numbers.logtest;
    bit$Mncount = numbers.logcount;
    log2$Mnbinary$Mnfactors = numbers.bitwise$Mnfirst$Mnbit$Mnset;
    first$Mnset$Mnbit = numbers.bitwise$Mnfirst$Mnbit$Mnset;
    bit$Mnfield = numbers.bitwise$Mnbit$Mnfield;
    reverse$Mnbit$Mnfield = numbers.bitwise$Mnreverse$Mnbit$Mnfield;
    





    bit$Mnset$Qu = logbit$Qu;
  }
  
  public static IntNum copyBitField(IntNum to, IntNum from, int start, int end) {
    return numbers.bitwiseCopyBitField(to, start, end, from);
  }
  
  public static IntNum rotateBitField(IntNum n, int count, int start, int end) {
    return numbers.bitwiseRotateBitField(n, start, end, count);
  }
  


  public static IntNum copyBit(int index, IntNum from, boolean bit)
  {
    return numbers.bitwiseCopyBit(from, index, bit ? 1 : 0);
  }
  

  public static LList integer$To$List(IntNum paramIntNum) { return integer$To$List(paramIntNum, numbers.bitwiseLength(paramIntNum)); }
  
  public static LList integer$To$List(IntNum k, int len) { gnu.lists.EmptyList localEmptyList = LList.Empty;IntNum localIntNum1 = k; Object lst; IntNum k; for (int idx = len - 1; idx >= 0; 
        
        idx--) { lst = lists.cons((k.intValue() & 0x1) != 0 ? Boolean.TRUE : Boolean.FALSE, lst);k = IntNum.shift(k, -1); }
    return lst;
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return integer$To$List(LangObjType.coerceIntNum(Promise.force(paramObject, IntNum.class))); } catch (ClassCastException localClassCastException1) { throw new WrongType(
      





        localClassCastException1, "integer->list", 1, paramObject); } try { return list$To$Integer((LList)Promise.force(paramObject, LList.class)); } catch (ClassCastException localClassCastException2) { throw new WrongType(localClassCastException2, "list->integer", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject);
  }
  
  public int matchN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, CallContext paramCallContext)
  {
    if (selector == 8) { values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); } public Object applyN(ModuleMethod paramModuleMethod, Object[] paramArrayOfObject) { if (selector == 8) return booleans$To$Integer$V(paramArrayOfObject); return super.applyN(paramModuleMethod, paramArrayOfObject); } public static IntNum booleans$To$Integer$V(Object[] argsArray) { LList localLList1; LList bools = localLList1 = LList.makeList(argsArray, 0);
    return list$To$Integer(bools);
  }
  
  /* Error */
  public static IntNum list$To$Integer(LList bools)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 123	gnu/kawa/slib/srfi60:Lit0	Lgnu/math/IntNum;
    //   4: astore_2
    //   5: astore_1
    //   6: aload_1
    //   7: invokestatic 127	kawa/lib/lists:isNull	(Ljava/lang/Object;)Z
    //   10: ifne +57 -> 67
    //   13: aload_1
    //   14: ldc -127
    //   16: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   19: dup
    //   20: astore_3
    //   21: checkcast 129	gnu/lists/Pair
    //   24: invokestatic 148	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   27: aload_1
    //   28: ldc -127
    //   30: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   33: dup
    //   34: astore_3
    //   35: checkcast 129	gnu/lists/Pair
    //   38: invokestatic 152	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   41: invokestatic 157	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   44: ifeq +15 -> 59
    //   47: aload_2
    //   48: aload_2
    //   49: invokestatic 161	gnu/math/IntNum:add	(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   52: iconst_1
    //   53: invokestatic 163	gnu/math/IntNum:add	(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    //   56: goto -52 -> 4
    //   59: aload_2
    //   60: aload_2
    //   61: invokestatic 161	gnu/math/IntNum:add	(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   64: goto -60 -> 4
    //   67: aload_2
    //   68: areturn
    //   69: new 139	gnu/mapping/WrongType
    //   72: dup_x1
    //   73: swap
    //   74: ldc -115
    //   76: iconst_1
    //   77: aload_3
    //   78: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   81: athrow
    //   82: new 139	gnu/mapping/WrongType
    //   85: dup_x1
    //   86: swap
    //   87: ldc -106
    //   89: iconst_1
    //   90: aload_3
    //   91: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   94: athrow
    // Line number table:
    //   Java source line #90	-> byte code offset #0
    //   Java source line #91	-> byte code offset #0
    //   Java source line #93	-> byte code offset #6
    //   Java source line #91	-> byte code offset #13
    //   Java source line #92	-> byte code offset #27
    //   Java source line #91	-> byte code offset #67
    //   Java source line #93	-> byte code offset #67
    //   Java source line #91	-> byte code offset #69
    //   Java source line #92	-> byte code offset #82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	bools	LList
    //   5	23	1	bs	Object
    //   4	1	2	localIntNum1	IntNum
    //   6	62	2	acc	IntNum
    //   20	71	3	localObject1	Object
    //   69	1	5	localClassCastException1	ClassCastException
    //   82	1	6	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   21	24	69	java/lang/ClassCastException
    //   35	38	82	java/lang/ClassCastException
  }
  
  static
  {
    Lit6 = Symbol.valueOf("list->integer");
    Lit5 = Symbol.valueOf("integer->list");
    Lit4 = Symbol.valueOf("copy-bit");
    Lit3 = Symbol.valueOf("rotate-bit-field");
    Lit2 = Symbol.valueOf("copy-bit-field");
    Lit1 = Symbol.valueOf("logbit?");
    Lit0 = IntNum.valueOf(0);
    $instance = new srfi60();
    arithmetic$Mnshift = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashift");
    ash = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashift");
    bitwise$Mnand = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "and");
    logand = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "and");
    bitwise$Mnior = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ior");
    logior = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ior");
    bitwise$Mnnot = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "not");
    lognot = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "not");
    bitwise$Mnxor = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "xor");
    logxor = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "xor");
    integer$Mnlength = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnlength");
    bitwise$Mnif = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnif");
    logtest = StaticFieldLocation.make("kawa.lib.numbers", "logtest");
    logcount = StaticFieldLocation.make("kawa.lib.numbers", "logcount");
    srfi60 localSrfi60 = $instance;
    logbit$Qu = new ModuleMethod(localSrfi60, 1, Lit1, 8194);
    copy$Mnbit$Mnfield = new ModuleMethod(localSrfi60, 2, Lit2, 16388);
    rotate$Mnbit$Mnfield = new ModuleMethod(localSrfi60, 3, Lit3, 16388);
    copy$Mnbit = new ModuleMethod(localSrfi60, 4, Lit4, 12291);
    integer$Mn$Grlist = new ModuleMethod(localSrfi60, 5, Lit5, 8193);
    list$Mn$Grinteger = new ModuleMethod(localSrfi60, 7, Lit6, 4097);
    booleans$Mn$Grinteger = new ModuleMethod(localSrfi60, 8, Lit7, 61440);
    $runBody$();
  }
  
  public srfi60()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(ModuleMethod arg1, Object arg2, CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 304	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+100->104, 5:+64->68, 6:+100->104, 7:+28->32
    //   32: aload_3
    //   33: aload_2
    //   34: ldc 88
    //   36: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   39: dup
    //   40: instanceof 88
    //   43: ifeq +6 -> 49
    //   46: goto +7 -> 53
    //   49: ldc_w 305
    //   52: ireturn
    //   53: putfield 309	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   56: aload_3
    //   57: aload_1
    //   58: putfield 312	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   61: aload_3
    //   62: iconst_1
    //   63: putfield 315	gnu/mapping/CallContext:pc	I
    //   66: iconst_0
    //   67: ireturn
    //   68: aload_3
    //   69: aload_2
    //   70: ldc 94
    //   72: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   75: dup
    //   76: invokestatic 319	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   79: ifnull +6 -> 85
    //   82: goto +7 -> 89
    //   85: ldc_w 305
    //   88: ireturn
    //   89: putfield 309	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   92: aload_3
    //   93: aload_1
    //   94: putfield 312	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   97: aload_3
    //   98: iconst_1
    //   99: putfield 315	gnu/mapping/CallContext:pc	I
    //   102: iconst_0
    //   103: ireturn
    //   104: aload_0
    //   105: aload_1
    //   106: aload_2
    //   107: aload_3
    //   108: invokespecial 323	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   111: ireturn
    // Line number table:
    //   Java source line #90	-> byte code offset #32
    //   Java source line #83	-> byte code offset #68
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 304	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+132->136, 1:+84->88, 2:+132->136, 3:+132->136, 4:+132->136, 5:+36->40
    //   40: aload 4
    //   42: aload_2
    //   43: ldc 94
    //   45: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   48: dup
    //   49: invokestatic 319	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   52: ifnull +6 -> 58
    //   55: goto +7 -> 62
    //   58: ldc_w 305
    //   61: ireturn
    //   62: putfield 309	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   65: aload 4
    //   67: aload_3
    //   68: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: putfield 329	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   74: aload 4
    //   76: aload_1
    //   77: putfield 312	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   80: aload 4
    //   82: iconst_2
    //   83: putfield 315	gnu/mapping/CallContext:pc	I
    //   86: iconst_0
    //   87: ireturn
    //   88: aload 4
    //   90: aload_2
    //   91: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   94: putfield 309	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   97: aload 4
    //   99: aload_3
    //   100: ldc 94
    //   102: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   105: dup
    //   106: invokestatic 319	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   109: ifnull +6 -> 115
    //   112: goto +7 -> 119
    //   115: ldc_w 330
    //   118: ireturn
    //   119: putfield 329	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   122: aload 4
    //   124: aload_1
    //   125: putfield 312	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   128: aload 4
    //   130: iconst_2
    //   131: putfield 315	gnu/mapping/CallContext:pc	I
    //   134: iconst_0
    //   135: ireturn
    //   136: aload_0
    //   137: aload_1
    //   138: aload_2
    //   139: aload_3
    //   140: aload 4
    //   142: invokespecial 334	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   145: ireturn
    // Line number table:
    //   Java source line #83	-> byte code offset #40
    //   Java source line #62	-> byte code offset #88
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 304	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_4
    //   5: if_icmpne +78 -> 83
    //   8: goto +3 -> 11
    //   11: aload 5
    //   13: aload_2
    //   14: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: putfield 309	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   20: aload 5
    //   22: aload_3
    //   23: ldc 94
    //   25: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   28: dup
    //   29: invokestatic 319	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   32: ifnull +6 -> 38
    //   35: goto +7 -> 42
    //   38: ldc_w 330
    //   41: ireturn
    //   42: putfield 329	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   45: aload 5
    //   47: aload 4
    //   49: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: dup
    //   53: instanceof 106
    //   56: ifeq +6 -> 62
    //   59: goto +7 -> 66
    //   62: ldc_w 335
    //   65: ireturn
    //   66: putfield 338	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   69: aload 5
    //   71: aload_1
    //   72: putfield 312	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   75: aload 5
    //   77: iconst_3
    //   78: putfield 315	gnu/mapping/CallContext:pc	I
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: aload_1
    //   85: aload_2
    //   86: aload_3
    //   87: aload 4
    //   89: aload 5
    //   91: invokespecial 342	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   94: ireturn
    // Line number table:
    //   Java source line #77	-> byte code offset #11
  }
  
  /* Error */
  public int match4(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 304	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+176->180, 2:+92->96, 3:+24->28
    //   28: aload 6
    //   30: aload_2
    //   31: ldc 94
    //   33: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   36: dup
    //   37: invokestatic 319	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   40: ifnull +6 -> 46
    //   43: goto +7 -> 50
    //   46: ldc_w 305
    //   49: ireturn
    //   50: putfield 309	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   53: aload 6
    //   55: aload_3
    //   56: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: putfield 329	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   62: aload 6
    //   64: aload 4
    //   66: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: putfield 338	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   72: aload 6
    //   74: aload 5
    //   76: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: putfield 345	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   82: aload 6
    //   84: aload_1
    //   85: putfield 312	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   88: aload 6
    //   90: iconst_4
    //   91: putfield 315	gnu/mapping/CallContext:pc	I
    //   94: iconst_0
    //   95: ireturn
    //   96: aload 6
    //   98: aload_2
    //   99: ldc 94
    //   101: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   104: dup
    //   105: invokestatic 319	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   108: ifnull +6 -> 114
    //   111: goto +7 -> 118
    //   114: ldc_w 305
    //   117: ireturn
    //   118: putfield 309	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   121: aload 6
    //   123: aload_3
    //   124: ldc 94
    //   126: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   129: dup
    //   130: invokestatic 319	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   133: ifnull +6 -> 139
    //   136: goto +7 -> 143
    //   139: ldc_w 330
    //   142: ireturn
    //   143: putfield 329	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   146: aload 6
    //   148: aload 4
    //   150: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: putfield 338	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   156: aload 6
    //   158: aload 5
    //   160: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   163: putfield 345	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   166: aload 6
    //   168: aload_1
    //   169: putfield 312	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   172: aload 6
    //   174: iconst_4
    //   175: putfield 315	gnu/mapping/CallContext:pc	I
    //   178: iconst_0
    //   179: ireturn
    //   180: aload_0
    //   181: aload_1
    //   182: aload_2
    //   183: aload_3
    //   184: aload 4
    //   186: aload 5
    //   188: aload 6
    //   190: invokespecial 349	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   193: ireturn
    // Line number table:
    //   Java source line #70	-> byte code offset #28
    //   Java source line #66	-> byte code offset #96
  }
  
  public void apply(CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 304	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+94->98, 1:+36->40, 2:+94->98, 3:+94->98, 4:+94->98, 5:+71->75
    //   40: aload_2
    //   41: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 100	java/lang/Number
    //   47: invokevirtual 104	java/lang/Number:intValue	()I
    //   50: aload_3
    //   51: ldc 94
    //   53: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   56: invokestatic 365	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   59: invokestatic 382	gnu/kawa/slib/srfi60:isLogbit	(ILgnu/math/IntNum;)Z
    //   62: ifeq +9 -> 71
    //   65: getstatic 110	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   68: goto +6 -> 74
    //   71: getstatic 113	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   74: areturn
    //   75: aload_2
    //   76: ldc 94
    //   78: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   81: invokestatic 365	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   84: aload_3
    //   85: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 100	java/lang/Number
    //   91: invokevirtual 104	java/lang/Number:intValue	()I
    //   94: invokestatic 86	gnu/kawa/slib/srfi60:integer$To$List	(Lgnu/math/IntNum;I)Lgnu/lists/LList;
    //   97: areturn
    //   98: aload_0
    //   99: aload_1
    //   100: aload_2
    //   101: aload_3
    //   102: invokespecial 386	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: areturn
    //   106: new 139	gnu/mapping/WrongType
    //   109: dup_x1
    //   110: swap
    //   111: ldc_w 378
    //   114: iconst_1
    //   115: aload_2
    //   116: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   119: athrow
    //   120: new 139	gnu/mapping/WrongType
    //   123: dup_x1
    //   124: swap
    //   125: ldc_w 378
    //   128: iconst_2
    //   129: aload_3
    //   130: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   133: athrow
    //   134: new 139	gnu/mapping/WrongType
    //   137: dup_x1
    //   138: swap
    //   139: ldc_w 367
    //   142: iconst_1
    //   143: aload_2
    //   144: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   147: athrow
    //   148: new 139	gnu/mapping/WrongType
    //   151: dup_x1
    //   152: swap
    //   153: ldc_w 367
    //   156: iconst_2
    //   157: aload_3
    //   158: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   161: athrow
    // Line number table:
    //   Java source line #62	-> byte code offset #40
    //   Java source line #83	-> byte code offset #75
    //   Java source line #62	-> byte code offset #106
    //   Java source line #83	-> byte code offset #134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	srfi60
    //   0	162	1	paramModuleMethod	ModuleMethod
    //   0	162	2	paramObject1	Object
    //   0	162	3	paramObject2	Object
    //   106	1	4	localClassCastException1	ClassCastException
    //   120	1	5	localClassCastException2	ClassCastException
    //   134	1	6	localClassCastException3	ClassCastException
    //   148	1	7	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   44	50	106	java/lang/ClassCastException
    //   56	59	120	java/lang/ClassCastException
    //   81	84	134	java/lang/ClassCastException
    //   88	94	148	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 304	gnu/expr/ModuleMethod:selector	I
    //   4: iconst_4
    //   5: if_icmpne +45 -> 50
    //   8: goto +3 -> 11
    //   11: aload_2
    //   12: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 100	java/lang/Number
    //   18: invokevirtual 104	java/lang/Number:intValue	()I
    //   21: aload_3
    //   22: ldc 94
    //   24: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: invokestatic 365	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   30: aload 4
    //   32: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: invokestatic 157	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   38: ifeq +7 -> 45
    //   41: iconst_1
    //   42: goto +4 -> 46
    //   45: iconst_0
    //   46: invokestatic 392	gnu/kawa/slib/srfi60:copyBit	(ILgnu/math/IntNum;Z)Lgnu/math/IntNum;
    //   49: areturn
    //   50: aload_0
    //   51: aload_1
    //   52: aload_2
    //   53: aload_3
    //   54: aload 4
    //   56: invokespecial 396	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   59: areturn
    //   60: new 139	gnu/mapping/WrongType
    //   63: dup_x1
    //   64: swap
    //   65: ldc_w 388
    //   68: iconst_1
    //   69: aload_2
    //   70: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   73: athrow
    //   74: new 139	gnu/mapping/WrongType
    //   77: dup_x1
    //   78: swap
    //   79: ldc_w 388
    //   82: iconst_2
    //   83: aload_3
    //   84: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   87: athrow
    //   88: new 139	gnu/mapping/WrongType
    //   91: dup_x1
    //   92: swap
    //   93: ldc_w 388
    //   96: iconst_3
    //   97: aload 4
    //   99: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   102: athrow
    // Line number table:
    //   Java source line #77	-> byte code offset #11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	srfi60
    //   0	103	1	paramModuleMethod	ModuleMethod
    //   0	103	2	paramObject1	Object
    //   0	103	3	paramObject2	Object
    //   0	103	4	paramObject3	Object
    //   60	1	5	localClassCastException1	ClassCastException
    //   74	1	6	localClassCastException2	ClassCastException
    //   88	1	7	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   15	21	60	java/lang/ClassCastException
    //   27	30	74	java/lang/ClassCastException
    //   35	46	88	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 304	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+113->117, 2:+24->28, 3:+68->72
    //   28: aload_2
    //   29: ldc 94
    //   31: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   34: invokestatic 365	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   37: aload_3
    //   38: ldc 94
    //   40: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   43: invokestatic 365	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   46: aload 4
    //   48: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   51: checkcast 100	java/lang/Number
    //   54: invokevirtual 104	java/lang/Number:intValue	()I
    //   57: aload 5
    //   59: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 100	java/lang/Number
    //   65: invokevirtual 104	java/lang/Number:intValue	()I
    //   68: invokestatic 402	gnu/kawa/slib/srfi60:copyBitField	(Lgnu/math/IntNum;Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    //   71: areturn
    //   72: aload_2
    //   73: ldc 94
    //   75: invokestatic 135	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: invokestatic 365	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   81: aload_3
    //   82: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: checkcast 100	java/lang/Number
    //   88: invokevirtual 104	java/lang/Number:intValue	()I
    //   91: aload 4
    //   93: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: checkcast 100	java/lang/Number
    //   99: invokevirtual 104	java/lang/Number:intValue	()I
    //   102: aload 5
    //   104: invokestatic 326	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 100	java/lang/Number
    //   110: invokevirtual 104	java/lang/Number:intValue	()I
    //   113: invokestatic 407	gnu/kawa/slib/srfi60:rotateBitField	(Lgnu/math/IntNum;III)Lgnu/math/IntNum;
    //   116: areturn
    //   117: aload_0
    //   118: aload_1
    //   119: aload_2
    //   120: aload_3
    //   121: aload 4
    //   123: aload 5
    //   125: invokespecial 411	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: areturn
    //   129: new 139	gnu/mapping/WrongType
    //   132: dup_x1
    //   133: swap
    //   134: ldc_w 398
    //   137: iconst_1
    //   138: aload_2
    //   139: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   142: athrow
    //   143: new 139	gnu/mapping/WrongType
    //   146: dup_x1
    //   147: swap
    //   148: ldc_w 398
    //   151: iconst_2
    //   152: aload_3
    //   153: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   156: athrow
    //   157: new 139	gnu/mapping/WrongType
    //   160: dup_x1
    //   161: swap
    //   162: ldc_w 398
    //   165: iconst_3
    //   166: aload 4
    //   168: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   171: athrow
    //   172: new 139	gnu/mapping/WrongType
    //   175: dup_x1
    //   176: swap
    //   177: ldc_w 398
    //   180: iconst_4
    //   181: aload 5
    //   183: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: new 139	gnu/mapping/WrongType
    //   190: dup_x1
    //   191: swap
    //   192: ldc_w 404
    //   195: iconst_1
    //   196: aload_2
    //   197: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: new 139	gnu/mapping/WrongType
    //   204: dup_x1
    //   205: swap
    //   206: ldc_w 404
    //   209: iconst_2
    //   210: aload_3
    //   211: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   214: athrow
    //   215: new 139	gnu/mapping/WrongType
    //   218: dup_x1
    //   219: swap
    //   220: ldc_w 404
    //   223: iconst_3
    //   224: aload 4
    //   226: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   229: athrow
    //   230: new 139	gnu/mapping/WrongType
    //   233: dup_x1
    //   234: swap
    //   235: ldc_w 404
    //   238: iconst_4
    //   239: aload 5
    //   241: invokespecial 145	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   244: athrow
    // Line number table:
    //   Java source line #66	-> byte code offset #28
    //   Java source line #70	-> byte code offset #72
    //   Java source line #66	-> byte code offset #129
    //   Java source line #70	-> byte code offset #187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	srfi60
    //   0	245	1	paramModuleMethod	ModuleMethod
    //   0	245	2	paramObject1	Object
    //   0	245	3	paramObject2	Object
    //   0	245	4	paramObject3	Object
    //   0	245	5	paramObject4	Object
    //   129	1	6	localClassCastException1	ClassCastException
    //   143	1	7	localClassCastException2	ClassCastException
    //   157	1	8	localClassCastException3	ClassCastException
    //   172	1	9	localClassCastException4	ClassCastException
    //   187	1	10	localClassCastException5	ClassCastException
    //   201	1	11	localClassCastException6	ClassCastException
    //   215	1	12	localClassCastException7	ClassCastException
    //   230	1	13	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   34	37	129	java/lang/ClassCastException
    //   43	46	143	java/lang/ClassCastException
    //   51	57	157	java/lang/ClassCastException
    //   62	68	172	java/lang/ClassCastException
    //   78	81	187	java/lang/ClassCastException
    //   85	91	201	java/lang/ClassCastException
    //   96	102	215	java/lang/ClassCastException
    //   107	113	230	java/lang/ClassCastException
  }
}
