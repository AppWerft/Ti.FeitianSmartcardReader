package kawa.lib; import gnu.lists.Array;

public class arrays extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  

  public static final Class $Lsarray$Gr;
  
  public static final gnu.expr.ModuleMethod array$Qu;
  
  public static final gnu.expr.ModuleMethod shape;
  
  public static final gnu.expr.ModuleMethod make$Mnarray;
  
  public static final gnu.expr.ModuleMethod array;
  
  public static final gnu.expr.ModuleMethod array$Mnrank;
  
  public static final gnu.expr.ModuleMethod array$Mnsize;
  
  public static final gnu.expr.ModuleMethod array$Mnstart;
  
  public static final gnu.expr.ModuleMethod array$Mnend;
  
  public static final gnu.expr.ModuleMethod share$Mnarray;
  
  public static final gnu.expr.ModuleMethod array$Mnindex$Mnref;
  
  public static final gnu.expr.ModuleMethod array$Mnindex$Mnshare;
  
  public static final gnu.expr.ModuleMethod array$Mnflatten;
  
  public static final gnu.expr.ModuleMethod array$Mn$Grvector;
  
  public static final gnu.expr.ModuleMethod index$Mnarray;
  
  public static final gnu.expr.ModuleMethod array$Mncopy$Ex;
  
  public static final gnu.expr.ModuleMethod array$Mnfill$Ex;
  
  public static final gnu.expr.ModuleMethod array$Mntransform;
  
  public static final gnu.expr.ModuleMethod build$Mnarray;
  
  public static final gnu.expr.ModuleMethod array$Mnreshape;
  
  public static final gnu.expr.ModuleMethod format$Mnarray;
  
  public static arrays $instance;
  
  static final gnu.mapping.SimpleSymbol Lit0;
  
  static final gnu.mapping.SimpleSymbol Lit1;
  
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
  static final gnu.mapping.SimpleSymbol Lit13;
  static final gnu.mapping.SimpleSymbol Lit14;
  static final gnu.mapping.SimpleSymbol Lit15;
  static final gnu.mapping.SimpleSymbol Lit16;
  static final gnu.mapping.SimpleSymbol Lit17;
  static final gnu.mapping.SimpleSymbol Lit18;
  static final gnu.mapping.SimpleSymbol Lit19 = gnu.mapping.Symbol.valueOf("format-array");
  public int match1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 20:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 14: 
      Object tmp96_93 = gnu.mapping.Promise.force(paramObject, Array.class);
      














































      if (!(tmp96_93 instanceof Array)) return -786431; value1 = tmp96_93;proc = paramModuleMethod;pc = 1;return 0;
    case 13: 
      Object tmp129_126 = gnu.mapping.Promise.force(paramObject, Array.class);
      











































      if (!(tmp129_126 instanceof Array)) return -786431; value1 = tmp129_126;proc = paramModuleMethod;pc = 1;return 0;
    case 12: 
      Object tmp162_159 = gnu.mapping.Promise.force(paramObject, Array.class);
      








































      if (!(tmp162_159 instanceof Array)) return -786431; value1 = tmp162_159;proc = paramModuleMethod;pc = 1;return 0;
    case 6: 
      Object tmp195_192 = gnu.mapping.Promise.force(paramObject, Array.class);
      





















      if (!(tmp195_192 instanceof Array)) return -786431; value1 = tmp195_192;proc = paramModuleMethod;pc = 1;return 0;
    case 5: 
      Object tmp228_225 = gnu.mapping.Promise.force(paramObject, Array.class);
      


















      if (!(tmp228_225 instanceof Array)) return -786431; value1 = tmp228_225;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext); }
  public static boolean isArray(Object x) { return x instanceof Array; }
  



























  public int matchN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 11:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 10: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 4: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 3: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 2: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext); }
  public static Array shape(Object... args) { return gnu.kawa.functions.Arrays.shape(args); }
  
  public static Array makeArray(Array shape, Object... obj) {
    return gnu.kawa.functions.Arrays.makeFromValues(shape, obj);
  }
  
  public static Array array(Array shape, Object... vals) {
    return gnu.kawa.functions.Arrays.makeSimple(shape, new gnu.lists.FVector(vals));
  }
  
  public static int arrayRank(Array array) { return array.rank(); }
  
  public static int arraySize(Array arr) {
    return arr.getSize();
  }
  
  public static int arrayStart(Array array, int k) { return array.getLowBound(k); }
  
  public static int arrayEnd(Array array, int k) {
    return array.getLowBound(k) + array.getSize(k);
  }
  
  public static Array shareArray(Array array, Array shape, gnu.mapping.Procedure mapper) {
    return gnu.kawa.functions.Arrays.shareArray(array, shape, mapper);
  }
  
  public static Object arrayIndexRef(Array arr, Object... indexes) { return gnu.lists.ComposedArray.generalIndex(arr, false, indexes); }
  

  public static Object arrayIndexShare(Array arr, Object... indexes) { return gnu.lists.ComposedArray.generalIndex(arr, true, indexes); }
  
  public static gnu.lists.SimpleVector<Object> arrayFlatten(Array arr) {
    Array localArray = arr;return gnu.lists.Arrays.flattenCopy(arr, true);
  }
  
  public static gnu.lists.AVector<Object> array$To$Vector(Array arr) { Array localArray = arr;return gnu.lists.FlattenedArray.flatten(arr);
  }
  
  public static Array indexArray(Array shape) { gnu.lists.GeneralArray arr = gnu.kawa.functions.Arrays.allocateArray(shape);
    gnu.lists.Range.IntRange localIntRange; arr.setBase(localIntRange = gnu.lists.Range.zeroAndUp);
    return arr;
  }
  
  public static void arrayCopy$Ex(Array dst, Array src) { Array localArray = dst;gnu.lists.Arrays.copy(dst, localArray = src);
  }
  
  public static void arrayFill$Ex(Array arr, Object value) { Array localArray = arr;gnu.lists.Arrays.fill(arr, value);
  }
  
  public static Array arrayTransform(Array arr, Array shape, gnu.mapping.Procedure mapper) { Array localArray = arr;return gnu.kawa.functions.Arrays.getTransformed(arr, mapper, shape);
  }
  
  public static Array buildArray(Array shape, gnu.mapping.Procedure proc) { return gnu.kawa.functions.Arrays.getBuiltArray(shape, proc); }
  
  public static Array arrayReshape(Array arr, Array shape) {
    gnu.lists.GeneralArray result = gnu.kawa.functions.Arrays.allocateArray(shape);
    Array localArray = arr;gnu.lists.AVector vec = gnu.lists.FlattenedArray.flatten(arr);
    int vsz = vec.size();
    int sz = result.getSize();
    if (sz != vsz) {
      throw gnu.expr.Special.reachedUnexpected;
    }
    result.setBase(vec);
    return result;
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isArray(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    
    







    try
    {
      return Integer.valueOf(arrayRank((Array)gnu.mapping.Promise.force(paramObject, Array.class))); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      






















































        localClassCastException1, "array-rank", 1, paramObject);
    }
    try
    {
      return Integer.valueOf(arraySize((Array)gnu.mapping.Promise.force(paramObject, Array.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "array-size", 1, paramObject);
    }
    














    try
    {
      return arrayFlatten((Array)gnu.mapping.Promise.force(paramObject, Array.class)); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "array-flatten", 1, paramObject);
    }
    try {
      return array$To$Vector((Array)gnu.mapping.Promise.force(paramObject, Array.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "array->vector", 1, paramObject);
    }
    try {
      return indexArray((Array)gnu.mapping.Promise.force(paramObject, Array.class)); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "index-array", 1, paramObject);
    }
    

























    return formatArray(paramObject);return super.apply1(paramModuleMethod, paramObject); }
  public static CharSequence formatArray(Object value, CharSequence elementFormat) { CharSequence tmp2_1 = elementFormat;tmp2_1;return gnu.kawa.functions.ArrayPrint.print(value, tmp2_1 == null ? null : tmp2_1.toString());
  }
  
  public static CharSequence formatArray(Object paramObject)
  {
    return formatArray(paramObject, null);
  }
  
  static
  {
    Lit18 = gnu.mapping.Symbol.valueOf("array-reshape");
    Lit17 = gnu.mapping.Symbol.valueOf("build-array");
    Lit16 = gnu.mapping.Symbol.valueOf("array-transform");
    Lit15 = gnu.mapping.Symbol.valueOf("array-fill!");
    Lit14 = gnu.mapping.Symbol.valueOf("array-copy!");
    Lit13 = gnu.mapping.Symbol.valueOf("index-array");
    Lit12 = gnu.mapping.Symbol.valueOf("array->vector");
    Lit11 = gnu.mapping.Symbol.valueOf("array-flatten");
    Lit10 = gnu.mapping.Symbol.valueOf("array-index-share");
    Lit9 = gnu.mapping.Symbol.valueOf("array-index-ref");
    Lit8 = gnu.mapping.Symbol.valueOf("share-array");
    Lit7 = gnu.mapping.Symbol.valueOf("array-end");
    Lit6 = gnu.mapping.Symbol.valueOf("array-start");
    Lit5 = gnu.mapping.Symbol.valueOf("array-size");
    Lit4 = gnu.mapping.Symbol.valueOf("array-rank");
    Lit3 = gnu.mapping.Symbol.valueOf("array");
    Lit2 = gnu.mapping.Symbol.valueOf("make-array");
    Lit1 = gnu.mapping.Symbol.valueOf("shape");
    Lit0 = gnu.mapping.Symbol.valueOf("array?");
    $Lsarray$Gr = Array.class;
    $instance = new arrays();
    arrays localArrays = $instance;
    array$Qu = new gnu.expr.ModuleMethod(localArrays, 1, Lit0, 4097);
    shape = new gnu.expr.ModuleMethod(localArrays, 2, Lit1, 61440);
    make$Mnarray = new gnu.expr.ModuleMethod(localArrays, 3, Lit2, 61441);
    array = new gnu.expr.ModuleMethod(localArrays, 4, Lit3, 61441);
    array$Mnrank = new gnu.expr.ModuleMethod(localArrays, 5, Lit4, 4097);
    array$Mnsize = new gnu.expr.ModuleMethod(localArrays, 6, Lit5, 4097);
    array$Mnstart = new gnu.expr.ModuleMethod(localArrays, 7, Lit6, 8194);
    array$Mnend = new gnu.expr.ModuleMethod(localArrays, 8, Lit7, 8194);
    share$Mnarray = new gnu.expr.ModuleMethod(localArrays, 9, Lit8, 12291);
    array$Mnindex$Mnref = new gnu.expr.ModuleMethod(localArrays, 10, Lit9, 61441);
    array$Mnindex$Mnshare = new gnu.expr.ModuleMethod(localArrays, 11, Lit10, 61441);
    array$Mnflatten = new gnu.expr.ModuleMethod(localArrays, 12, Lit11, 4097);
    array$Mn$Grvector = new gnu.expr.ModuleMethod(localArrays, 13, Lit12, 4097);
    index$Mnarray = new gnu.expr.ModuleMethod(localArrays, 14, Lit13, 4097);
    array$Mncopy$Ex = new gnu.expr.ModuleMethod(localArrays, 15, Lit14, 8194);
    array$Mnfill$Ex = new gnu.expr.ModuleMethod(localArrays, 16, Lit15, 8194);
    array$Mntransform = new gnu.expr.ModuleMethod(localArrays, 17, Lit16, 12291);
    build$Mnarray = new gnu.expr.ModuleMethod(localArrays, 18, Lit17, 8194);
    array$Mnreshape = new gnu.expr.ModuleMethod(localArrays, 19, Lit18, 8194);
    format$Mnarray = new gnu.expr.ModuleMethod(localArrays, 20, Lit19, 8193);
    $runBody$();
  }
  
  public arrays()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 298	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+428->432, 7:+383->387, 8:+338->342, 9:+428->432, 10:+428->432, 11:+428->432, 12:+428->432, 13:+428->432, 14:+428->432, 15:+280->284, 16:+238->242, 17:+428->432, 18:+176->180, 19:+118->122, 20:+72->76
    //   76: aload 4
    //   78: aload_2
    //   79: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   82: aload 4
    //   84: aload_3
    //   85: ldc_w 322
    //   88: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   91: dup
    //   92: instanceof 322
    //   95: ifeq +6 -> 101
    //   98: goto +7 -> 105
    //   101: ldc_w 323
    //   104: ireturn
    //   105: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   108: aload 4
    //   110: aload_1
    //   111: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   114: aload 4
    //   116: iconst_2
    //   117: putfield 309	gnu/mapping/CallContext:pc	I
    //   120: iconst_0
    //   121: ireturn
    //   122: aload 4
    //   124: aload_2
    //   125: ldc 12
    //   127: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   130: dup
    //   131: instanceof 12
    //   134: ifne +7 -> 141
    //   137: ldc_w 316
    //   140: ireturn
    //   141: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   144: aload 4
    //   146: aload_3
    //   147: ldc 12
    //   149: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   152: dup
    //   153: instanceof 12
    //   156: ifne +7 -> 163
    //   159: ldc_w 323
    //   162: ireturn
    //   163: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   166: aload 4
    //   168: aload_1
    //   169: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   172: aload 4
    //   174: iconst_2
    //   175: putfield 309	gnu/mapping/CallContext:pc	I
    //   178: iconst_0
    //   179: ireturn
    //   180: aload 4
    //   182: aload_2
    //   183: ldc 12
    //   185: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   188: dup
    //   189: instanceof 12
    //   192: ifne +7 -> 199
    //   195: ldc_w 316
    //   198: ireturn
    //   199: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   202: aload 4
    //   204: aload_3
    //   205: ldc_w 328
    //   208: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   211: dup
    //   212: invokestatic 334	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   215: ifnull +6 -> 221
    //   218: goto +7 -> 225
    //   221: ldc_w 323
    //   224: ireturn
    //   225: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   228: aload 4
    //   230: aload_1
    //   231: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   234: aload 4
    //   236: iconst_2
    //   237: putfield 309	gnu/mapping/CallContext:pc	I
    //   240: iconst_0
    //   241: ireturn
    //   242: aload 4
    //   244: aload_2
    //   245: ldc 12
    //   247: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   250: dup
    //   251: instanceof 12
    //   254: ifne +7 -> 261
    //   257: ldc_w 316
    //   260: ireturn
    //   261: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   264: aload 4
    //   266: aload_3
    //   267: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   270: aload 4
    //   272: aload_1
    //   273: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   276: aload 4
    //   278: iconst_2
    //   279: putfield 309	gnu/mapping/CallContext:pc	I
    //   282: iconst_0
    //   283: ireturn
    //   284: aload 4
    //   286: aload_2
    //   287: ldc 12
    //   289: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   292: dup
    //   293: instanceof 12
    //   296: ifne +7 -> 303
    //   299: ldc_w 316
    //   302: ireturn
    //   303: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   306: aload 4
    //   308: aload_3
    //   309: ldc 12
    //   311: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   314: dup
    //   315: instanceof 12
    //   318: ifne +7 -> 325
    //   321: ldc_w 323
    //   324: ireturn
    //   325: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   328: aload 4
    //   330: aload_1
    //   331: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   334: aload 4
    //   336: iconst_2
    //   337: putfield 309	gnu/mapping/CallContext:pc	I
    //   340: iconst_0
    //   341: ireturn
    //   342: aload 4
    //   344: aload_2
    //   345: ldc 12
    //   347: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   350: dup
    //   351: instanceof 12
    //   354: ifne +7 -> 361
    //   357: ldc_w 316
    //   360: ireturn
    //   361: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   364: aload 4
    //   366: aload_3
    //   367: invokestatic 337	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   370: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   373: aload 4
    //   375: aload_1
    //   376: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   379: aload 4
    //   381: iconst_2
    //   382: putfield 309	gnu/mapping/CallContext:pc	I
    //   385: iconst_0
    //   386: ireturn
    //   387: aload 4
    //   389: aload_2
    //   390: ldc 12
    //   392: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   395: dup
    //   396: instanceof 12
    //   399: ifne +7 -> 406
    //   402: ldc_w 316
    //   405: ireturn
    //   406: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   409: aload 4
    //   411: aload_3
    //   412: invokestatic 337	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   415: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   418: aload 4
    //   420: aload_1
    //   421: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   424: aload 4
    //   426: iconst_2
    //   427: putfield 309	gnu/mapping/CallContext:pc	I
    //   430: iconst_0
    //   431: ireturn
    //   432: aload_0
    //   433: aload_1
    //   434: aload_2
    //   435: aload_3
    //   436: aload 4
    //   438: invokespecial 341	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   441: ireturn
    // Line number table:
    //   Java source line #76	-> byte code offset #76
    //   Java source line #65	-> byte code offset #122
    //   Java source line #62	-> byte code offset #180
    //   Java source line #56	-> byte code offset #242
    //   Java source line #53	-> byte code offset #284
    //   Java source line #29	-> byte code offset #342
    //   Java source line #26	-> byte code offset #387
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 298	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+198->202, 9:+113->117, 17:+28->32
    //   32: aload 5
    //   34: aload_2
    //   35: ldc 12
    //   37: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   40: dup
    //   41: instanceof 12
    //   44: ifne +7 -> 51
    //   47: ldc_w 316
    //   50: ireturn
    //   51: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   54: aload 5
    //   56: aload_3
    //   57: ldc 12
    //   59: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: dup
    //   63: instanceof 12
    //   66: ifne +7 -> 73
    //   69: ldc_w 323
    //   72: ireturn
    //   73: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   76: aload 5
    //   78: aload 4
    //   80: ldc_w 328
    //   83: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   86: dup
    //   87: invokestatic 334	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   90: ifnull +6 -> 96
    //   93: goto +7 -> 100
    //   96: ldc_w 342
    //   99: ireturn
    //   100: putfield 345	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   103: aload 5
    //   105: aload_1
    //   106: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   109: aload 5
    //   111: iconst_3
    //   112: putfield 309	gnu/mapping/CallContext:pc	I
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 5
    //   119: aload_2
    //   120: ldc 12
    //   122: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   125: dup
    //   126: instanceof 12
    //   129: ifne +7 -> 136
    //   132: ldc_w 316
    //   135: ireturn
    //   136: putfield 302	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   139: aload 5
    //   141: aload_3
    //   142: ldc 12
    //   144: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   147: dup
    //   148: instanceof 12
    //   151: ifne +7 -> 158
    //   154: ldc_w 323
    //   157: ireturn
    //   158: putfield 326	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   161: aload 5
    //   163: aload 4
    //   165: ldc_w 328
    //   168: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   171: dup
    //   172: invokestatic 334	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   175: ifnull +6 -> 181
    //   178: goto +7 -> 185
    //   181: ldc_w 342
    //   184: ireturn
    //   185: putfield 345	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   188: aload 5
    //   190: aload_1
    //   191: putfield 306	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   194: aload 5
    //   196: iconst_3
    //   197: putfield 309	gnu/mapping/CallContext:pc	I
    //   200: iconst_0
    //   201: ireturn
    //   202: aload_0
    //   203: aload_1
    //   204: aload_2
    //   205: aload_3
    //   206: aload 4
    //   208: aload 5
    //   210: invokespecial 349	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   213: ireturn
    // Line number table:
    //   Java source line #59	-> byte code offset #32
    //   Java source line #32	-> byte code offset #117
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
    //   1: getfield 298	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+226->230, 7:+72->76, 8:+98->102, 9:+226->230, 10:+226->230, 11:+226->230, 12:+226->230, 13:+226->230, 14:+226->230, 15:+124->128, 16:+149->153, 17:+226->230, 18:+166->170, 19:+189->193, 20:+211->215
    //   76: aload_2
    //   77: ldc 12
    //   79: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   82: checkcast 12	gnu/lists/Array
    //   85: aload_3
    //   86: invokestatic 337	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   89: checkcast 419	java/lang/Number
    //   92: invokevirtual 422	java/lang/Number:intValue	()I
    //   95: invokestatic 426	kawa/lib/arrays:arrayStart	(Lgnu/lists/Array;I)I
    //   98: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: areturn
    //   102: aload_2
    //   103: ldc 12
    //   105: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   108: checkcast 12	gnu/lists/Array
    //   111: aload_3
    //   112: invokestatic 337	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 419	java/lang/Number
    //   118: invokevirtual 422	java/lang/Number:intValue	()I
    //   121: invokestatic 431	kawa/lib/arrays:arrayEnd	(Lgnu/lists/Array;I)I
    //   124: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: areturn
    //   128: aload_2
    //   129: ldc 12
    //   131: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   134: checkcast 12	gnu/lists/Array
    //   137: aload_3
    //   138: ldc 12
    //   140: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   143: checkcast 12	gnu/lists/Array
    //   146: invokestatic 436	kawa/lib/arrays:arrayCopy$Ex	(Lgnu/lists/Array;Lgnu/lists/Array;)V
    //   149: getstatic 442	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   152: areturn
    //   153: aload_2
    //   154: ldc 12
    //   156: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   159: checkcast 12	gnu/lists/Array
    //   162: aload_3
    //   163: invokestatic 447	kawa/lib/arrays:arrayFill$Ex	(Lgnu/lists/Array;Ljava/lang/Object;)V
    //   166: getstatic 442	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   169: areturn
    //   170: aload_2
    //   171: ldc 12
    //   173: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   176: checkcast 12	gnu/lists/Array
    //   179: aload_3
    //   180: ldc_w 328
    //   183: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   186: invokestatic 452	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   189: invokestatic 455	kawa/lib/arrays:buildArray	(Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
    //   192: areturn
    //   193: aload_2
    //   194: ldc 12
    //   196: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   199: checkcast 12	gnu/lists/Array
    //   202: aload_3
    //   203: ldc 12
    //   205: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: checkcast 12	gnu/lists/Array
    //   211: invokestatic 461	kawa/lib/arrays:arrayReshape	(Lgnu/lists/Array;Lgnu/lists/Array;)Lgnu/lists/Array;
    //   214: areturn
    //   215: aload_2
    //   216: aload_3
    //   217: ldc_w 322
    //   220: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   223: checkcast 322	java/lang/CharSequence
    //   226: invokestatic 139	kawa/lib/arrays:formatArray	(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   229: areturn
    //   230: aload_0
    //   231: aload_1
    //   232: aload_2
    //   233: aload_3
    //   234: invokespecial 467	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: areturn
    //   238: new 377	gnu/mapping/WrongType
    //   241: dup_x1
    //   242: swap
    //   243: ldc_w 417
    //   246: iconst_1
    //   247: aload_2
    //   248: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   251: athrow
    //   252: new 377	gnu/mapping/WrongType
    //   255: dup_x1
    //   256: swap
    //   257: ldc_w 417
    //   260: iconst_2
    //   261: aload_3
    //   262: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   265: athrow
    //   266: new 377	gnu/mapping/WrongType
    //   269: dup_x1
    //   270: swap
    //   271: ldc_w 428
    //   274: iconst_1
    //   275: aload_2
    //   276: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   279: athrow
    //   280: new 377	gnu/mapping/WrongType
    //   283: dup_x1
    //   284: swap
    //   285: ldc_w 428
    //   288: iconst_2
    //   289: aload_3
    //   290: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   293: athrow
    //   294: new 377	gnu/mapping/WrongType
    //   297: dup_x1
    //   298: swap
    //   299: ldc_w 433
    //   302: iconst_1
    //   303: aload_2
    //   304: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   307: athrow
    //   308: new 377	gnu/mapping/WrongType
    //   311: dup_x1
    //   312: swap
    //   313: ldc_w 433
    //   316: iconst_2
    //   317: aload_3
    //   318: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   321: athrow
    //   322: new 377	gnu/mapping/WrongType
    //   325: dup_x1
    //   326: swap
    //   327: ldc_w 444
    //   330: iconst_1
    //   331: aload_2
    //   332: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   335: athrow
    //   336: new 377	gnu/mapping/WrongType
    //   339: dup_x1
    //   340: swap
    //   341: ldc_w 449
    //   344: iconst_1
    //   345: aload_2
    //   346: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   349: athrow
    //   350: new 377	gnu/mapping/WrongType
    //   353: dup_x1
    //   354: swap
    //   355: ldc_w 449
    //   358: iconst_2
    //   359: aload_3
    //   360: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   363: athrow
    //   364: new 377	gnu/mapping/WrongType
    //   367: dup_x1
    //   368: swap
    //   369: ldc_w 457
    //   372: iconst_1
    //   373: aload_2
    //   374: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   377: athrow
    //   378: new 377	gnu/mapping/WrongType
    //   381: dup_x1
    //   382: swap
    //   383: ldc_w 457
    //   386: iconst_2
    //   387: aload_3
    //   388: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   391: athrow
    //   392: new 377	gnu/mapping/WrongType
    //   395: dup_x1
    //   396: swap
    //   397: ldc_w 463
    //   400: iconst_2
    //   401: aload_3
    //   402: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   405: athrow
    // Line number table:
    //   Java source line #26	-> byte code offset #76
    //   Java source line #29	-> byte code offset #102
    //   Java source line #53	-> byte code offset #128
    //   Java source line #56	-> byte code offset #153
    //   Java source line #62	-> byte code offset #170
    //   Java source line #65	-> byte code offset #193
    //   Java source line #76	-> byte code offset #215
    //   Java source line #26	-> byte code offset #238
    //   Java source line #29	-> byte code offset #266
    //   Java source line #53	-> byte code offset #294
    //   Java source line #56	-> byte code offset #322
    //   Java source line #62	-> byte code offset #336
    //   Java source line #65	-> byte code offset #364
    //   Java source line #76	-> byte code offset #392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	arrays
    //   0	406	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	406	2	paramObject1	Object
    //   0	406	3	paramObject2	Object
    //   238	1	4	localClassCastException1	ClassCastException
    //   252	1	5	localClassCastException2	ClassCastException
    //   266	1	6	localClassCastException3	ClassCastException
    //   280	1	7	localClassCastException4	ClassCastException
    //   294	1	8	localClassCastException5	ClassCastException
    //   308	1	9	localClassCastException6	ClassCastException
    //   322	1	10	localClassCastException7	ClassCastException
    //   336	1	11	localClassCastException8	ClassCastException
    //   350	1	12	localClassCastException9	ClassCastException
    //   364	1	13	localClassCastException10	ClassCastException
    //   378	1	14	localClassCastException11	ClassCastException
    //   392	1	15	localClassCastException12	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   82	85	238	java/lang/ClassCastException
    //   89	95	252	java/lang/ClassCastException
    //   108	111	266	java/lang/ClassCastException
    //   115	121	280	java/lang/ClassCastException
    //   134	137	294	java/lang/ClassCastException
    //   143	146	308	java/lang/ClassCastException
    //   159	162	322	java/lang/ClassCastException
    //   176	179	336	java/lang/ClassCastException
    //   186	189	350	java/lang/ClassCastException
    //   199	202	364	java/lang/ClassCastException
    //   208	211	378	java/lang/ClassCastException
    //   223	226	392	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 298	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+94->98, 9:+28->32, 17:+61->65
    //   32: aload_2
    //   33: ldc 12
    //   35: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   38: checkcast 12	gnu/lists/Array
    //   41: aload_3
    //   42: ldc 12
    //   44: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   47: checkcast 12	gnu/lists/Array
    //   50: aload 4
    //   52: ldc_w 328
    //   55: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   58: invokestatic 452	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   61: invokestatic 470	kawa/lib/arrays:shareArray	(Lgnu/lists/Array;Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
    //   64: areturn
    //   65: aload_2
    //   66: ldc 12
    //   68: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   71: checkcast 12	gnu/lists/Array
    //   74: aload_3
    //   75: ldc 12
    //   77: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   80: checkcast 12	gnu/lists/Array
    //   83: aload 4
    //   85: ldc_w 328
    //   88: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   91: invokestatic 452	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   94: invokestatic 475	kawa/lib/arrays:arrayTransform	(Lgnu/lists/Array;Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
    //   97: areturn
    //   98: aload_0
    //   99: aload_1
    //   100: aload_2
    //   101: aload_3
    //   102: aload 4
    //   104: invokespecial 479	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: areturn
    //   108: new 377	gnu/mapping/WrongType
    //   111: dup_x1
    //   112: swap
    //   113: ldc_w 469
    //   116: iconst_1
    //   117: aload_2
    //   118: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   121: athrow
    //   122: new 377	gnu/mapping/WrongType
    //   125: dup_x1
    //   126: swap
    //   127: ldc_w 469
    //   130: iconst_2
    //   131: aload_3
    //   132: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    //   136: new 377	gnu/mapping/WrongType
    //   139: dup_x1
    //   140: swap
    //   141: ldc_w 469
    //   144: iconst_3
    //   145: aload 4
    //   147: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   150: athrow
    //   151: new 377	gnu/mapping/WrongType
    //   154: dup_x1
    //   155: swap
    //   156: ldc_w 472
    //   159: iconst_1
    //   160: aload_2
    //   161: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   164: athrow
    //   165: new 377	gnu/mapping/WrongType
    //   168: dup_x1
    //   169: swap
    //   170: ldc_w 472
    //   173: iconst_2
    //   174: aload_3
    //   175: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   178: athrow
    //   179: new 377	gnu/mapping/WrongType
    //   182: dup_x1
    //   183: swap
    //   184: ldc_w 472
    //   187: iconst_3
    //   188: aload 4
    //   190: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   193: athrow
    // Line number table:
    //   Java source line #32	-> byte code offset #32
    //   Java source line #59	-> byte code offset #65
    //   Java source line #32	-> byte code offset #108
    //   Java source line #33	-> byte code offset #136
    //   Java source line #59	-> byte code offset #151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	arrays
    //   0	194	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	194	2	paramObject1	Object
    //   0	194	3	paramObject2	Object
    //   0	194	4	paramObject3	Object
    //   108	1	5	localClassCastException1	ClassCastException
    //   122	1	6	localClassCastException2	ClassCastException
    //   136	1	7	localClassCastException3	ClassCastException
    //   151	1	8	localClassCastException4	ClassCastException
    //   165	1	9	localClassCastException5	ClassCastException
    //   179	1	10	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   38	41	108	java/lang/ClassCastException
    //   47	50	122	java/lang/ClassCastException
    //   58	61	136	java/lang/ClassCastException
    //   71	74	151	java/lang/ClassCastException
    //   80	83	165	java/lang/ClassCastException
    //   91	94	179	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(gnu.expr.ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 298	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+237->241, 2:+56->60, 3:+61->65, 4:+105->109, 5:+237->241, 6:+237->241, 7:+237->241, 8:+237->241, 9:+237->241, 10:+149->153, 11:+193->197
    //   60: aload_2
    //   61: invokestatic 480	kawa/lib/arrays:shape	([Ljava/lang/Object;)Lgnu/lists/Array;
    //   64: areturn
    //   65: aload_2
    //   66: iconst_0
    //   67: aaload
    //   68: ldc 12
    //   70: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   73: dup
    //   74: astore_3
    //   75: checkcast 12	gnu/lists/Array
    //   78: aload_2
    //   79: arraylength
    //   80: iconst_1
    //   81: isub
    //   82: istore_3
    //   83: iload_3
    //   84: anewarray 107	java/lang/Object
    //   87: goto +11 -> 98
    //   90: dup
    //   91: iload_3
    //   92: aload_2
    //   93: iload_3
    //   94: iconst_1
    //   95: iadd
    //   96: aaload
    //   97: aastore
    //   98: iinc 3 -1
    //   101: iload_3
    //   102: ifge -12 -> 90
    //   105: invokestatic 485	kawa/lib/arrays:makeArray	(Lgnu/lists/Array;[Ljava/lang/Object;)Lgnu/lists/Array;
    //   108: areturn
    //   109: aload_2
    //   110: iconst_0
    //   111: aaload
    //   112: ldc 12
    //   114: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: dup
    //   118: astore_3
    //   119: checkcast 12	gnu/lists/Array
    //   122: aload_2
    //   123: arraylength
    //   124: iconst_1
    //   125: isub
    //   126: istore_3
    //   127: iload_3
    //   128: anewarray 107	java/lang/Object
    //   131: goto +11 -> 142
    //   134: dup
    //   135: iload_3
    //   136: aload_2
    //   137: iload_3
    //   138: iconst_1
    //   139: iadd
    //   140: aaload
    //   141: aastore
    //   142: iinc 3 -1
    //   145: iload_3
    //   146: ifge -12 -> 134
    //   149: invokestatic 488	kawa/lib/arrays:array	(Lgnu/lists/Array;[Ljava/lang/Object;)Lgnu/lists/Array;
    //   152: areturn
    //   153: aload_2
    //   154: iconst_0
    //   155: aaload
    //   156: ldc 12
    //   158: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   161: dup
    //   162: astore_3
    //   163: checkcast 12	gnu/lists/Array
    //   166: aload_2
    //   167: arraylength
    //   168: iconst_1
    //   169: isub
    //   170: istore_3
    //   171: iload_3
    //   172: anewarray 107	java/lang/Object
    //   175: goto +11 -> 186
    //   178: dup
    //   179: iload_3
    //   180: aload_2
    //   181: iload_3
    //   182: iconst_1
    //   183: iadd
    //   184: aaload
    //   185: aastore
    //   186: iinc 3 -1
    //   189: iload_3
    //   190: ifge -12 -> 178
    //   193: invokestatic 494	kawa/lib/arrays:arrayIndexRef	(Lgnu/lists/Array;[Ljava/lang/Object;)Ljava/lang/Object;
    //   196: areturn
    //   197: aload_2
    //   198: iconst_0
    //   199: aaload
    //   200: ldc 12
    //   202: invokestatic 315	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   205: dup
    //   206: astore_3
    //   207: checkcast 12	gnu/lists/Array
    //   210: aload_2
    //   211: arraylength
    //   212: iconst_1
    //   213: isub
    //   214: istore_3
    //   215: iload_3
    //   216: anewarray 107	java/lang/Object
    //   219: goto +11 -> 230
    //   222: dup
    //   223: iload_3
    //   224: aload_2
    //   225: iload_3
    //   226: iconst_1
    //   227: iadd
    //   228: aaload
    //   229: aastore
    //   230: iinc 3 -1
    //   233: iload_3
    //   234: ifge -12 -> 222
    //   237: invokestatic 499	kawa/lib/arrays:arrayIndexShare	(Lgnu/lists/Array;[Ljava/lang/Object;)Ljava/lang/Object;
    //   240: areturn
    //   241: aload_0
    //   242: aload_1
    //   243: aload_2
    //   244: invokespecial 503	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   247: areturn
    //   248: new 377	gnu/mapping/WrongType
    //   251: dup_x1
    //   252: swap
    //   253: ldc_w 482
    //   256: iconst_1
    //   257: aload_3
    //   258: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   261: athrow
    //   262: new 377	gnu/mapping/WrongType
    //   265: dup_x1
    //   266: swap
    //   267: ldc_w 486
    //   270: iconst_1
    //   271: aload_3
    //   272: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   275: athrow
    //   276: new 377	gnu/mapping/WrongType
    //   279: dup_x1
    //   280: swap
    //   281: ldc_w 490
    //   284: iconst_1
    //   285: aload_3
    //   286: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   289: athrow
    //   290: new 377	gnu/mapping/WrongType
    //   293: dup_x1
    //   294: swap
    //   295: ldc_w 496
    //   298: iconst_1
    //   299: aload_3
    //   300: invokespecial 382	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   303: athrow
    // Line number table:
    //   Java source line #10	-> byte code offset #60
    //   Java source line #13	-> byte code offset #65
    //   Java source line #16	-> byte code offset #109
    //   Java source line #36	-> byte code offset #153
    //   Java source line #39	-> byte code offset #197
    //   Java source line #13	-> byte code offset #248
    //   Java source line #16	-> byte code offset #262
    //   Java source line #36	-> byte code offset #276
    //   Java source line #39	-> byte code offset #290
    // Exception table:
    //   from	to	target	type
    //   75	78	248	java/lang/ClassCastException
    //   119	122	262	java/lang/ClassCastException
    //   163	166	276	java/lang/ClassCastException
    //   207	210	290	java/lang/ClassCastException
  }
}
