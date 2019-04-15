package kawa.lib.kawa;
import gnu.kawa.reflect.StaticFieldLocation;

public class quaternions extends gnu.expr.ModuleBody { public static final StaticFieldLocation quaternion; public static final StaticFieldLocation quaternion$Qu; public static final StaticFieldLocation real$Mnpart; public static final StaticFieldLocation imag$Mnpart; public static final StaticFieldLocation jmag$Mnpart; public static final StaticFieldLocation kmag$Mnpart; public static final gnu.expr.ModuleMethod complex$Mnpart; public static final gnu.expr.ModuleMethod vector$Mnpart; public static final gnu.expr.ModuleMethod unit$Mnquaternion; public static final StaticFieldLocation unit$Mnvector; public static final gnu.expr.ModuleMethod vector$Mnquaternion$Qu; public static final gnu.expr.ModuleMethod make$Mnvector$Mnquaternion; public static final gnu.expr.ModuleMethod vector$Mnquaternion$Mn$Grlist; public static final StaticFieldLocation magnitude; public static final StaticFieldLocation angle; public static final gnu.expr.ModuleMethod colatitude; public static final gnu.expr.ModuleMethod longitude; public static final StaticFieldLocation make$Mnrectangular; public static final StaticFieldLocation make$Mnpolar; public static final StaticFieldLocation $Pl; public static final StaticFieldLocation $Mn; public static final StaticFieldLocation $St; public static final StaticFieldLocation $Sl; public static final gnu.expr.ModuleMethod dot$Mnproduct; public static final gnu.expr.ModuleMethod cross$Mnproduct; public static final gnu.expr.ModuleMethod conjugate; public static final StaticFieldLocation exp; public static final StaticFieldLocation log; public static final StaticFieldLocation expt; public static final StaticFieldLocation sqrt; public static final StaticFieldLocation sin; public static final StaticFieldLocation cos; private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final StaticFieldLocation tan;
  public static final StaticFieldLocation asin;
  public static final StaticFieldLocation acos;
  public static final StaticFieldLocation atan;
  static final gnu.math.IntNum Lit0;
  static final gnu.math.IntNum Lit1;
  static final gnu.math.IntNum Lit2;
  static final gnu.math.DFloNum Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  public static quaternions $instance;
  static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7; static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14 = gnu.mapping.Symbol.valueOf("conjugate"); static { Lit13 = gnu.mapping.Symbol.valueOf("vector-quaternion->list");Lit12 = gnu.mapping.Symbol.valueOf("make-vector-quaternion");Lit11 = gnu.mapping.Symbol.valueOf("vector-quaternion?");Lit10 = gnu.mapping.Symbol.valueOf("unit-quaternion");Lit9 = gnu.mapping.Symbol.valueOf("longitude");Lit8 = gnu.mapping.Symbol.valueOf("colatitude");Lit7 = gnu.mapping.Symbol.valueOf("vector-part");Lit6 = gnu.mapping.Symbol.valueOf("complex-part");Lit5 = gnu.mapping.Symbol.valueOf("cross-product");Lit4 = gnu.mapping.Symbol.valueOf("dot-product");Lit3 = gnu.math.DFloNum.valueOf(NaN.0D);Lit2 = gnu.math.IntNum.valueOf(1);Lit1 = gnu.math.IntNum.valueOf(-1);Lit0 = gnu.math.IntNum.valueOf(0);$instance = new quaternions();$Pl = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Pl");$Mn = StaticFieldLocation.make("gnu.kawa.functions.AddOp", "$Mn");
    $Sl = StaticFieldLocation.make("gnu.kawa.functions.DivideOp", "$Sl");
    $St = StaticFieldLocation.make("gnu.kawa.functions.MultiplyOp", "$St");
    expt = StaticFieldLocation.make("kawa.standard.expt", "expt");
    quaternion = StaticFieldLocation.make("kawa.lib.numbers", "quaternion");quaternion$Qu = StaticFieldLocation.make("kawa.lib.numbers", "quaternion$Qu");real$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "real$Mnpart");imag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "imag$Mnpart");jmag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "jmag$Mnpart");kmag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "kmag$Mnpart");unit$Mnvector = StaticFieldLocation.make("kawa.lib.numbers", "unit$Mnvector");magnitude = StaticFieldLocation.make("kawa.lib.numbers", "magnitude");angle = StaticFieldLocation.make("kawa.lib.numbers", "angle");make$Mnrectangular = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnrectangular");make$Mnpolar = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnpolar");exp = StaticFieldLocation.make("kawa.lib.numbers", "exp");log = StaticFieldLocation.make("kawa.lib.numbers", "log");sqrt = StaticFieldLocation.make("kawa.lib.numbers", "sqrt");sin = StaticFieldLocation.make("kawa.lib.numbers", "sin");cos = StaticFieldLocation.make("kawa.lib.numbers", "cos");tan = StaticFieldLocation.make("kawa.lib.numbers", "tan");asin = StaticFieldLocation.make("kawa.lib.numbers", "asin");acos = StaticFieldLocation.make("kawa.lib.numbers", "acos");atan = StaticFieldLocation.make("kawa.lib.numbers", "atan");quaternions localQuaternions = $instance;complex$Mnpart = new gnu.expr.ModuleMethod(localQuaternions, 1, Lit6, 4097);vector$Mnpart = new gnu.expr.ModuleMethod(localQuaternions, 2, Lit7, 4097);colatitude = new gnu.expr.ModuleMethod(localQuaternions, 3, Lit8, 4097);longitude = new gnu.expr.ModuleMethod(localQuaternions, 4, Lit9, 4097);unit$Mnquaternion = new gnu.expr.ModuleMethod(localQuaternions, 5, Lit10, 4097);vector$Mnquaternion$Qu = new gnu.expr.ModuleMethod(localQuaternions, 6, Lit11, 4097);make$Mnvector$Mnquaternion = new gnu.expr.ModuleMethod(localQuaternions, 7, Lit12, 12291);vector$Mnquaternion$Mn$Grlist = new gnu.expr.ModuleMethod(localQuaternions, 8, Lit13, 4097);dot$Mnproduct = new gnu.expr.ModuleMethod(localQuaternions, 9, Lit4, 8194);cross$Mnproduct = new gnu.expr.ModuleMethod(localQuaternions, 10, Lit5, 8194);conjugate = new gnu.expr.ModuleMethod(localQuaternions, 11, Lit14, 4097);$runBody$();
  }
  

























































  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 11:  Object tmp71_68 = gnu.mapping.Promise.force(paramObject, Number.class);
      

















































































      if (!(tmp71_68 instanceof Number)) return -786431; value1 = tmp71_68;proc = paramModuleMethod;pc = 1;return 0;
    case 8: 
      Object tmp104_101 = gnu.mapping.Promise.force(paramObject, gnu.math.Quaternion.class);
      

































































      if (!(tmp104_101 instanceof gnu.math.Quaternion)) return -786431; value1 = tmp104_101;proc = paramModuleMethod;pc = 1;return 0;
    case 6: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 5: 
      Object tmp154_151 = gnu.mapping.Promise.force(paramObject, Number.class);
      
















































      if (!(tmp154_151 instanceof Number)) return -786431; value1 = tmp154_151;proc = paramModuleMethod;pc = 1;return 0;
    case 4: 
      Object tmp187_184 = gnu.mapping.Promise.force(paramObject, Number.class);
      











































      if (!(tmp187_184 instanceof Number)) return -786431; value1 = tmp187_184;proc = paramModuleMethod;pc = 1;return 0;
    case 3: 
      Object tmp220_217 = gnu.mapping.Promise.force(paramObject, Number.class);
      






































      if (!(tmp220_217 instanceof Number)) return -786431; value1 = tmp220_217;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      Object tmp253_250 = gnu.mapping.Promise.force(paramObject, Number.class);
      

































      if (!(tmp253_250 instanceof Number)) return -786431; value1 = tmp253_250;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      Object tmp286_283 = gnu.mapping.Promise.force(paramObject, Number.class);
      




























      if (!(tmp286_283 instanceof Number)) return -786431; value1 = tmp286_283;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static gnu.math.Complex complexPart(Number x) { return (x instanceof gnu.math.Quaternion) ? 
      ((gnu.math.Quaternion)x).complexPart() : (gnu.math.Complex)x; }
  

  public static gnu.math.Quaternion vectorPart(Number x)
  {
    return (x instanceof gnu.math.Quaternion) ? 
      ((gnu.math.Quaternion)x).vectorPart() : Lit0;
  }
  
  public static Number colatitude(Number x)
  {
    return (x instanceof gnu.math.Quaternion) ? 
      ((gnu.math.Quaternion)x).colatitude() : Lit0;
  }
  
  public static Number longitude(Number x)
  {
    return (x instanceof gnu.math.Quaternion) ? 
      ((gnu.math.Quaternion)x).longitude() : Lit0;
  }
  


  public static Number unitQuaternion(Number x)
  {
    if ((x instanceof gnu.math.Quantity)) {}
    try {
      tmpTernaryOp = gnu.math.Quantity.make((gnu.math.Quaternion)(localNumber = unitQuaternion(((gnu.math.Quantity)x).number())), ((gnu.math.Quantity)x).unit());
    } catch (ClassCastException localClassCastException2) {
      for (;;) { Number localNumber;
        try { localNumber = x;
        }
        catch (ClassCastException localClassCastException2)
        {
          throw new gnu.mapping.WrongType(localClassCastException2, "negative?", 1, localNumber);
        }
        try { return (x instanceof gnu.math.Quaternion) ? ((gnu.math.Quaternion)x).unitQuaternion() : kawa.lib.numbers.isPositive(gnu.kawa.lispexpr.LangObjType.coerceRealNum(x)) ? Lit2 : Lit3;
        }
        catch (ClassCastException localClassCastException3)
        {
          throw new gnu.mapping.WrongType(localClassCastException3, "positive?", 1, localNumber);
        }
      }
      throw new gnu.mapping.WrongType(
      



        localClassCastException1, "gnu.math.Quantity.make(gnu.math.Quaternion,gnu.math.Unit)", 1, localNumber);
    }
    localNumber = x;
  }
  
  public static boolean isVectorQuaternion(Object o)
  {
    if (kawa.lib.numbers.isQuaternion(o)) {} try { tmpTernaryOp = kawa.lib.numbers.isZero(kawa.lib.numbers.realPart((Number)(localObject = gnu.mapping.Promise.force(o, Number.class))));return false; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "real-part", 1, localObject);
    } }
  
  public static gnu.math.Quaternion makeVectorQuaternion(gnu.math.RealNum x, gnu.math.RealNum y, gnu.math.RealNum z) { return (gnu.math.Quaternion)gnu.mapping.Promise.force(kawa.lib.numbers.make$Mnrectangular.apply4(Lit0, x, y, z), gnu.math.Quaternion.class); }
  
  public static gnu.lists.LList vectorQuaternion$To$List(gnu.math.Quaternion vec) {
    return gnu.lists.LList.list3(kawa.lib.numbers.imagPart(vec), kawa.lib.numbers.jmagPart(vec), kawa.lib.numbers.kmagPart(vec));
  }
  





  public int match2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 10:  Object tmp36_33 = gnu.mapping.Promise.force(paramObject1, Number.class);
      












































































      if (!(tmp36_33 instanceof Number)) return -786431; value1 = tmp36_33; Object tmp58_55 = gnu.mapping.Promise.force(paramObject2, Number.class); if (!(tmp58_55 instanceof Number)) return -786430; value2 = tmp58_55;proc = paramModuleMethod;pc = 2;return 0;
    case 9: 
      Object tmp94_91 = gnu.mapping.Promise.force(paramObject1, Number.class);
      




































































      if (!(tmp94_91 instanceof Number)) return -786431; value1 = tmp94_91; Object tmp116_113 = gnu.mapping.Promise.force(paramObject2, Number.class); if (!(tmp116_113 instanceof Number)) return -786430; value2 = tmp116_113;proc = paramModuleMethod;pc = 2;return 0; } return super.match2(paramModuleMethod, paramObject1, paramObject2, paramCallContext); }
  public static gnu.math.RealNum dotProduct(Number x, Number y) { if ((!isVectorQuaternion(x)) || (!isVectorQuaternion(y))) {
      throw gnu.expr.Special.reachedUnexpected;
    }
    

    return gnu.kawa.lispexpr.LangObjType.coerceRealNum(gnu.mapping.Promise.force(gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.AddOp.apply2(1, gnu.kawa.functions.MultiplyOp.$St.apply2(kawa.lib.numbers.imagPart(x), kawa.lib.numbers.imagPart(y)), gnu.kawa.functions.MultiplyOp.$St.apply2(kawa.lib.numbers.jmagPart(x), kawa.lib.numbers.jmagPart(y))), gnu.kawa.functions.MultiplyOp.$St.apply2(kawa.lib.numbers.kmagPart(x), kawa.lib.numbers.kmagPart(y))), gnu.math.RealNum.class));
  }
  
  public static gnu.math.Quaternion crossProduct(Number x, Number y) { if ((!isVectorQuaternion(x)) || (!isVectorQuaternion(y)))
      throw gnu.expr.Special.reachedUnexpected;
    try { return vectorPart((Number)(localObject = gnu.mapping.Promise.force(gnu.kawa.functions.MultiplyOp.$St.apply2(x, y), Number.class))); } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "vector-part", 0, localObject);
    }
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return complexPart((Number)gnu.mapping.Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      



















































        localClassCastException1, "complex-part", 1, paramObject);
    }
    try
    {
      return vectorPart((Number)gnu.mapping.Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "vector-part", 1, paramObject);
    }
    
    try
    {
      return colatitude((Number)gnu.mapping.Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "colatitude", 1, paramObject);
    }
    
    try
    {
      return longitude((Number)gnu.mapping.Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "longitude", 1, paramObject);
    }
    
    try
    {
      return unitQuaternion((Number)gnu.mapping.Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "unit-quaternion", 1, paramObject);
    }
    








    return isVectorQuaternion(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    


    try
    {
      return vectorQuaternion$To$List((gnu.math.Quaternion)gnu.mapping.Promise.force(paramObject, gnu.math.Quaternion.class)); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "vector-quaternion->list", 1, paramObject);
    }
    











    try
    {
      return conjugate((Number)gnu.mapping.Promise.force(paramObject, Number.class)); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "conjugate", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static Number conjugate(Number x) { return (x instanceof gnu.math.Quaternion) ? 
      ((gnu.math.Quaternion)x).conjugate() : x; }
  
  public quaternions()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 390	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 7
    //   6: if_icmpne +96 -> 102
    //   9: goto +3 -> 12
    //   12: aload 5
    //   14: aload_2
    //   15: ldc -77
    //   17: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: invokestatic 417	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   24: ifnull +6 -> 30
    //   27: goto +7 -> 34
    //   30: ldc_w 391
    //   33: ireturn
    //   34: putfield 395	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   37: aload 5
    //   39: aload_3
    //   40: ldc -77
    //   42: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   45: dup
    //   46: invokestatic 417	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   49: ifnull +6 -> 55
    //   52: goto +7 -> 59
    //   55: ldc_w 407
    //   58: ireturn
    //   59: putfield 410	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   62: aload 5
    //   64: aload 4
    //   66: ldc -77
    //   68: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   71: dup
    //   72: invokestatic 417	gnu/math/RealNum:asRealNumOrNull	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   75: ifnull +6 -> 81
    //   78: goto +7 -> 85
    //   81: ldc_w 418
    //   84: ireturn
    //   85: putfield 421	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   88: aload 5
    //   90: aload_1
    //   91: putfield 399	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   94: aload 5
    //   96: iconst_3
    //   97: putfield 402	gnu/mapping/CallContext:pc	I
    //   100: iconst_0
    //   101: ireturn
    //   102: aload_0
    //   103: aload_1
    //   104: aload_2
    //   105: aload_3
    //   106: aload 4
    //   108: aload 5
    //   110: invokespecial 425	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   113: ireturn
    // Line number table:
    //   Java source line #64	-> byte code offset #12
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    gnu.expr.ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 390	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+68->72, 9:+24->28, 10:+46->50
    //   28: aload_2
    //   29: ldc 103
    //   31: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   34: checkcast 103	java/lang/Number
    //   37: aload_3
    //   38: ldc 103
    //   40: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   43: checkcast 103	java/lang/Number
    //   46: invokestatic 469	kawa/lib/kawa/quaternions:dotProduct	(Ljava/lang/Number;Ljava/lang/Number;)Lgnu/math/RealNum;
    //   49: areturn
    //   50: aload_2
    //   51: ldc 103
    //   53: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   56: checkcast 103	java/lang/Number
    //   59: aload_3
    //   60: ldc 103
    //   62: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   65: checkcast 103	java/lang/Number
    //   68: invokestatic 475	kawa/lib/kawa/quaternions:crossProduct	(Ljava/lang/Number;Ljava/lang/Number;)Lgnu/math/Quaternion;
    //   71: areturn
    //   72: aload_0
    //   73: aload_1
    //   74: aload_2
    //   75: aload_3
    //   76: invokespecial 478	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: areturn
    //   80: new 50	gnu/mapping/WrongType
    //   83: dup_x1
    //   84: swap
    //   85: ldc_w 465
    //   88: iconst_1
    //   89: aload_2
    //   90: invokespecial 56	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   93: athrow
    //   94: new 50	gnu/mapping/WrongType
    //   97: dup_x1
    //   98: swap
    //   99: ldc_w 465
    //   102: iconst_2
    //   103: aload_3
    //   104: invokespecial 56	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   107: athrow
    //   108: new 50	gnu/mapping/WrongType
    //   111: dup_x1
    //   112: swap
    //   113: ldc_w 471
    //   116: iconst_1
    //   117: aload_2
    //   118: invokespecial 56	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   121: athrow
    //   122: new 50	gnu/mapping/WrongType
    //   125: dup_x1
    //   126: swap
    //   127: ldc_w 471
    //   130: iconst_2
    //   131: aload_3
    //   132: invokespecial 56	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    // Line number table:
    //   Java source line #70	-> byte code offset #28
    //   Java source line #78	-> byte code offset #50
    //   Java source line #70	-> byte code offset #80
    //   Java source line #78	-> byte code offset #108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	quaternions
    //   0	136	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	136	2	paramObject1	Object
    //   0	136	3	paramObject2	Object
    //   80	1	4	localClassCastException1	ClassCastException
    //   94	1	5	localClassCastException2	ClassCastException
    //   108	1	6	localClassCastException3	ClassCastException
    //   122	1	7	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   34	37	80	java/lang/ClassCastException
    //   43	46	94	java/lang/ClassCastException
    //   56	59	108	java/lang/ClassCastException
    //   65	68	122	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 390	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 7
    //   6: if_icmpne +38 -> 44
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: ldc -77
    //   15: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: invokestatic 76	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   21: aload_3
    //   22: ldc -77
    //   24: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   27: invokestatic 76	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   30: aload 4
    //   32: ldc -77
    //   34: invokestatic 109	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   37: invokestatic 76	gnu/kawa/lispexpr/LangObjType:coerceRealNum	(Ljava/lang/Object;)Lgnu/math/RealNum;
    //   40: invokestatic 484	kawa/lib/kawa/quaternions:makeVectorQuaternion	(Lgnu/math/RealNum;Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Quaternion;
    //   43: areturn
    //   44: aload_0
    //   45: aload_1
    //   46: aload_2
    //   47: aload_3
    //   48: aload 4
    //   50: invokespecial 488	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: areturn
    //   54: new 50	gnu/mapping/WrongType
    //   57: dup_x1
    //   58: swap
    //   59: ldc_w 480
    //   62: iconst_1
    //   63: aload_2
    //   64: invokespecial 56	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   67: athrow
    //   68: new 50	gnu/mapping/WrongType
    //   71: dup_x1
    //   72: swap
    //   73: ldc_w 480
    //   76: iconst_2
    //   77: aload_3
    //   78: invokespecial 56	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   81: athrow
    //   82: new 50	gnu/mapping/WrongType
    //   85: dup_x1
    //   86: swap
    //   87: ldc_w 480
    //   90: iconst_3
    //   91: aload 4
    //   93: invokespecial 56	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   96: athrow
    // Line number table:
    //   Java source line #64	-> byte code offset #12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	quaternions
    //   0	97	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	97	2	paramObject1	Object
    //   0	97	3	paramObject2	Object
    //   0	97	4	paramObject3	Object
    //   54	1	5	localClassCastException1	ClassCastException
    //   68	1	6	localClassCastException2	ClassCastException
    //   82	1	7	localClassCastException3	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	21	54	java/lang/ClassCastException
    //   27	30	68	java/lang/ClassCastException
    //   37	40	82	java/lang/ClassCastException
  }
}
