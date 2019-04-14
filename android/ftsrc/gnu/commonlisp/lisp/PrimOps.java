package gnu.commonlisp.lisp;

import gnu.expr.ModuleMethod;

public class PrimOps extends gnu.expr.ModuleBody { public static final ModuleMethod boundp;
  
  private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer;
  }
  


  public static final ModuleMethod symbolp;
  

  public static final ModuleMethod symbol$Mnname;
  

  public static final ModuleMethod symbol$Mnplist;
  

  public static final ModuleMethod setplist;
  

  public static final ModuleMethod plist$Mnget;
  

  public static final ModuleMethod plist$Mnput;
  

  public static final ModuleMethod plist$Mnremprop;
  

  public static final ModuleMethod plist$Mnmember;
  

  public static final ModuleMethod get;
  

  public static final ModuleMethod put;
  

  public static final ModuleMethod symbol$Mnvalue;
  

  public static final ModuleMethod set;
  

  public static final ModuleMethod symbol$Mnfunction;
  

  public static final ModuleMethod fset;
  

  public static final ModuleMethod length;
  

  public static final ModuleMethod arrayp;
  

  public static final ModuleMethod aref;
  

  public static final ModuleMethod aset;
  

  public static final ModuleMethod fillarray;
  

  public static final ModuleMethod stringp;
  

  public static final ModuleMethod make$Mnstring;
  

  public static final ModuleMethod substring;
  
  public static final ModuleMethod char$Mnto$Mnstring;
  
  public static final ModuleMethod functionp;
  
  public static final ModuleMethod princ;
  
  public static final ModuleMethod prin1;
  
  static final gnu.mapping.SimpleSymbol Lit0;
  
  static final gnu.math.IntNum Lit1;
  
  public static PrimOps $instance;
  
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
  
  static final gnu.mapping.SimpleSymbol Lit19;
  
  static final gnu.mapping.SimpleSymbol Lit20;
  
  static final gnu.mapping.SimpleSymbol Lit21;
  
  static final gnu.mapping.SimpleSymbol Lit22;
  
  static final gnu.mapping.SimpleSymbol Lit23;
  
  static final gnu.mapping.SimpleSymbol Lit24;
  
  static final gnu.mapping.SimpleSymbol Lit25;
  
  static final gnu.mapping.SimpleSymbol Lit26;
  
  static final gnu.mapping.SimpleSymbol Lit27;
  
  static final gnu.mapping.SimpleSymbol Lit28 = gnu.mapping.Symbol.valueOf("prin1");
  
  public int match1(ModuleMethod paramModuleMethod, Object paramObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 31:  value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 29: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 28: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 27: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 23: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 19: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 18: 
      Object tmp229_226 = gnu.mapping.Promise.force(paramObject, gnu.lists.Sequence.class);
      


































































































      if (!(tmp229_226 instanceof gnu.lists.Sequence)) return -786431; value1 = tmp229_226;proc = paramModuleMethod;pc = 1;return 0;
    case 16: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 14: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 4: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 3: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 2: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0;
    case 1: 
      value1 = paramObject;proc = paramModuleMethod;pc = 1;return 0; } return super.match1(paramModuleMethod, paramObject, paramCallContext);
  }
  
  public static boolean boundp(Object symbol) { return gnu.commonlisp.lang.Symbols.isBound(symbol); }
  
  public static boolean symbolp(Object x) {
    return gnu.commonlisp.lang.Symbols.isSymbol(x);
  }
  
  public static Object symbolName(Object symbol) { return gnu.commonlisp.lang.Symbols.getPrintName(symbol); }
  











  public static Object symbolPlist(Object symbol) { return gnu.mapping.PropertyLocation.getPropertyList(symbol); }
  
  public static Object setplist(Object symbol, Object plist) {
    gnu.mapping.PropertyLocation.setPropertyList(symbol, plist);
    return plist;
  }
  
  public static Object plistGet(Object plist, Object prop, Object default) { return gnu.mapping.PropertyLocation.plistGet(plist, prop, default); }
  
  public static Object plistPut(Object plist, Object prop, Object value) {
    return gnu.mapping.PropertyLocation.plistPut(plist, prop, value);
  }
  
  public static Object plistRemprop(Object plist, Object prop) { return gnu.mapping.PropertyLocation.plistRemove(plist, prop); }
  
  public static Object plistMember(Object plist, Object prop)
  {
    return gnu.mapping.PropertyLocation.plistGet(plist, prop, gnu.mapping.Values.empty) == gnu.mapping.Values.empty ? gnu.lists.LList.Empty : Lit0;
  }
  
  public static Object get(gnu.mapping.Symbol symbol, Object property, Object default)
  {
    return gnu.mapping.PropertyLocation.getProperty(symbol, property, default);
  }
  
  public static void put(Object symbol, Object property, Object value) { gnu.mapping.PropertyLocation.putProperty(symbol, property, value); }
  




  public static Object symbolValue(Object sym)
  {
    return gnu.mapping.Environment.getCurrent().get(gnu.commonlisp.lang.Symbols.getSymbol(sym));
  }
  




  public static void set(Object symbol, Object value)
  {
    gnu.mapping.Environment.getCurrent().put(gnu.commonlisp.lang.Symbols.getSymbol(symbol), value);
  }
  











  public static Object symbolFunction(Object symbol)
  {
    return gnu.commonlisp.lang.Symbols.getFunctionBinding(symbol);
  }
  




  public static void fset(Object symbol, Object object)
  {
    gnu.commonlisp.lang.Symbols.setFunctionBinding(gnu.mapping.Environment.getCurrent(), symbol, object);
  }
  
  public static int length(gnu.lists.Sequence x)
  {
    return x.size();
  }
  
  public static boolean arrayp(Object x) { return x instanceof gnu.lists.SimpleVector; }
  

  public static Object aref(gnu.lists.SimpleVector array, int k)
  {
    return array.get(k);
  }
  
  public static Object aset(gnu.lists.SimpleVector array, int k, Object obj)
  {
    array.set(k, obj);
    return obj;
  }
  
  public static Object fillarray(gnu.lists.SimpleVector array, Object obj) { array.fill(obj);
    return obj;
  }
  
  public static boolean stringp(Object x)
  {
    return x instanceof CharSequence;
  }
  
  public static gnu.lists.FString makeString(int count, Object ch) { return new gnu.lists.FString(count, gnu.commonlisp.lang.CommonLisp.asChar(ch)); }
  
  public static gnu.lists.FString substring(CharSequence str, Object from, Object to) {
    if (to == gnu.lists.LList.Empty)
      to = Integer.valueOf(kawa.lib.strings.stringLength(str));
    if (gnu.kawa.functions.NumberCompare.$Ls(to, Lit1))
      to = gnu.kawa.functions.AddOp.apply2(-1, Integer.valueOf(kawa.lib.strings.stringLength(str)), to);
    if (gnu.kawa.functions.NumberCompare.$Ls(from, Lit1))
      from = gnu.kawa.functions.AddOp.apply2(-1, Integer.valueOf(kawa.lib.strings.stringLength(str)), from);
    return new gnu.lists.FString(str, ((Number)gnu.mapping.Promise.force(from)).intValue(), ((Number)gnu.mapping.Promise.force(gnu.kawa.functions.AddOp.apply2(-1, to, from))).intValue());
  }
  
  public static gnu.lists.FString charToString(Object ch) { return new gnu.lists.FString(1, gnu.commonlisp.lang.CommonLisp.asChar(ch)); }
  

  public static boolean functionp(Object x) { return x instanceof gnu.mapping.Procedure; }
  
  public static void princ(Object paramObject) { princ(paramObject, (gnu.kawa.io.OutPort)kawa.lib.ports.current$Mnoutput$Mnport.getValue()); }
  public static void princ(Object value, Object out) { try { gnu.commonlisp.lang.CommonLisp.displayFormat.format(value, (gnu.lists.Consumer)(localObject = gnu.mapping.Promise.force(out, gnu.lists.Consumer.class)));return; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "gnu.kawa.format.AbstractFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, localObject); } }
  
  public static void prin1(Object paramObject) { prin1(paramObject, (gnu.kawa.io.OutPort)kawa.lib.ports.current$Mnoutput$Mnport.getValue());
  }
  
  public Object apply1(ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return boundp(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    


    case 2: 
      return symbolp(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    
    case 3: 
      return symbolName(paramObject);
    










    case 4: 
      return symbolPlist(paramObject);
    






























    case 14: 
      return symbolValue(paramObject);
    





















    case 16: 
      return symbolFunction(paramObject);
    }
    
    









    try
    {
      return Integer.valueOf(length((gnu.lists.Sequence)gnu.mapping.Promise.force(paramObject, gnu.lists.Sequence.class))); } catch (ClassCastException localClassCastException) { throw new gnu.mapping.WrongType(
      













































        localClassCastException, "length", 1, paramObject);
    }
    return arrayp(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    


















    return stringp(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    













    return charToString(paramObject);
    

    return functionp(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    

    princ(paramObject);return gnu.mapping.Values.empty;
    

    prin1(paramObject);return gnu.mapping.Values.empty;return super.apply1(paramModuleMethod, paramObject); }
  public static void prin1(Object value, Object out) { try { gnu.commonlisp.lang.CommonLisp.writeFormat.format(value, (gnu.lists.Consumer)(localObject = gnu.mapping.Promise.force(out, gnu.lists.Consumer.class)));return; } catch (ClassCastException localClassCastException) { Object localObject; throw new gnu.mapping.WrongType(localClassCastException, "gnu.kawa.format.AbstractFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, localObject);
    }
  }
  
  public static Object plistGet(Object paramObject1, Object paramObject2)
  {
    return plistGet(paramObject1, paramObject2, Boolean.FALSE);
  }
  
  public static Object get(gnu.mapping.Symbol paramSymbol, Object paramObject)
  {
    return get(paramSymbol, paramObject, gnu.lists.LList.Empty);
  }
  
  public static gnu.lists.FString substring(CharSequence paramCharSequence, Object paramObject)
  {
    return substring(paramCharSequence, paramObject, gnu.lists.LList.Empty);
  }
  
  static
  {
    Lit27 = gnu.mapping.Symbol.valueOf("princ");
    Lit26 = gnu.mapping.Symbol.valueOf("functionp");
    Lit25 = gnu.mapping.Symbol.valueOf("char-to-string");
    Lit24 = gnu.mapping.Symbol.valueOf("substring");
    Lit23 = gnu.mapping.Symbol.valueOf("make-string");
    Lit22 = gnu.mapping.Symbol.valueOf("stringp");
    Lit21 = gnu.mapping.Symbol.valueOf("fillarray");
    Lit20 = gnu.mapping.Symbol.valueOf("aset");
    Lit19 = gnu.mapping.Symbol.valueOf("aref");
    Lit18 = gnu.mapping.Symbol.valueOf("arrayp");
    Lit17 = gnu.mapping.Symbol.valueOf("length");
    Lit16 = gnu.mapping.Symbol.valueOf("fset");
    Lit15 = gnu.mapping.Symbol.valueOf("symbol-function");
    Lit14 = gnu.mapping.Symbol.valueOf("set");
    Lit13 = gnu.mapping.Symbol.valueOf("symbol-value");
    Lit12 = gnu.mapping.Symbol.valueOf("put");
    Lit11 = gnu.mapping.Symbol.valueOf("get");
    Lit10 = gnu.mapping.Symbol.valueOf("plist-member");
    Lit9 = gnu.mapping.Symbol.valueOf("plist-remprop");
    Lit8 = gnu.mapping.Symbol.valueOf("plist-put");
    Lit7 = gnu.mapping.Symbol.valueOf("plist-get");
    Lit6 = gnu.mapping.Symbol.valueOf("setplist");
    Lit5 = gnu.mapping.Symbol.valueOf("symbol-plist");
    Lit4 = gnu.mapping.Symbol.valueOf("symbol-name");
    Lit3 = gnu.mapping.Symbol.valueOf("symbolp");
    Lit2 = gnu.mapping.Symbol.valueOf("boundp");
    Lit1 = gnu.math.IntNum.valueOf(0);
    Lit0 = gnu.mapping.Symbol.valueOf("t");
    $instance = new PrimOps();
    PrimOps localPrimOps = $instance;
    boundp = new ModuleMethod(localPrimOps, 1, Lit2, 4097);
    symbolp = new ModuleMethod(localPrimOps, 2, Lit3, 4097);
    symbol$Mnname = new ModuleMethod(localPrimOps, 3, Lit4, 4097);
    symbol$Mnplist = new ModuleMethod(localPrimOps, 4, Lit5, 4097);
    setplist = new ModuleMethod(localPrimOps, 5, Lit6, 8194);
    plist$Mnget = new ModuleMethod(localPrimOps, 6, Lit7, 12290);
    plist$Mnput = new ModuleMethod(localPrimOps, 8, Lit8, 12291);
    plist$Mnremprop = new ModuleMethod(localPrimOps, 9, Lit9, 8194);
    plist$Mnmember = new ModuleMethod(localPrimOps, 10, Lit10, 8194);
    get = new ModuleMethod(localPrimOps, 11, Lit11, 12290);
    put = new ModuleMethod(localPrimOps, 13, Lit12, 12291);
    symbol$Mnvalue = new ModuleMethod(localPrimOps, 14, Lit13, 4097);
    set = new ModuleMethod(localPrimOps, 15, Lit14, 8194);
    symbol$Mnfunction = new ModuleMethod(localPrimOps, 16, Lit15, 4097);
    fset = new ModuleMethod(localPrimOps, 17, Lit16, 8194);
    length = new ModuleMethod(localPrimOps, 18, Lit17, 4097);
    arrayp = new ModuleMethod(localPrimOps, 19, Lit18, 4097);
    aref = new ModuleMethod(localPrimOps, 20, Lit19, 8194);
    aset = new ModuleMethod(localPrimOps, 21, Lit20, 12291);
    fillarray = new ModuleMethod(localPrimOps, 22, Lit21, 8194);
    stringp = new ModuleMethod(localPrimOps, 23, Lit22, 4097);
    make$Mnstring = new ModuleMethod(localPrimOps, 24, Lit23, 8194);
    substring = new ModuleMethod(localPrimOps, 25, Lit24, 12290);
    char$Mnto$Mnstring = new ModuleMethod(localPrimOps, 27, Lit25, 4097);
    functionp = new ModuleMethod(localPrimOps, 28, Lit26, 4097);
    princ = new ModuleMethod(localPrimOps, 29, Lit27, 8193);
    prin1 = new ModuleMethod(localPrimOps, 31, Lit28, 8193);
    $runBody$();
  }
  
  public PrimOps()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match2(ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 414	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+536->540, 5:+510->514, 6:+484->488, 7:+536->540, 8:+536->540, 9:+458->462, 10:+432->436, 11:+389->393, 12:+536->540, 13:+536->540, 14:+536->540, 15:+363->367, 16:+536->540, 17:+337->341, 18:+536->540, 19:+536->540, 20:+292->296, 21:+536->540, 22:+250->254, 23:+536->540, 24:+221->225, 25:+176->180, 26:+536->540, 27:+536->540, 28:+536->540, 29:+150->154, 30:+536->540, 31:+124->128
    //   128: aload 4
    //   130: aload_2
    //   131: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   134: aload 4
    //   136: aload_3
    //   137: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   140: aload 4
    //   142: aload_1
    //   143: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   146: aload 4
    //   148: iconst_2
    //   149: putfield 425	gnu/mapping/CallContext:pc	I
    //   152: iconst_0
    //   153: ireturn
    //   154: aload 4
    //   156: aload_2
    //   157: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   160: aload 4
    //   162: aload_3
    //   163: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   166: aload 4
    //   168: aload_1
    //   169: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   172: aload 4
    //   174: iconst_2
    //   175: putfield 425	gnu/mapping/CallContext:pc	I
    //   178: iconst_0
    //   179: ireturn
    //   180: aload 4
    //   182: aload_2
    //   183: ldc 124
    //   185: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   188: dup
    //   189: instanceof 124
    //   192: ifeq +6 -> 198
    //   195: goto +7 -> 202
    //   198: ldc_w 426
    //   201: ireturn
    //   202: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   205: aload 4
    //   207: aload_3
    //   208: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   211: aload 4
    //   213: aload_1
    //   214: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   217: aload 4
    //   219: iconst_2
    //   220: putfield 425	gnu/mapping/CallContext:pc	I
    //   223: iconst_0
    //   224: ireturn
    //   225: aload 4
    //   227: aload_2
    //   228: invokestatic 173	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   231: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   234: aload 4
    //   236: aload_3
    //   237: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   240: aload 4
    //   242: aload_1
    //   243: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   246: aload 4
    //   248: iconst_2
    //   249: putfield 425	gnu/mapping/CallContext:pc	I
    //   252: iconst_0
    //   253: ireturn
    //   254: aload 4
    //   256: aload_2
    //   257: ldc 111
    //   259: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   262: dup
    //   263: instanceof 111
    //   266: ifne +7 -> 273
    //   269: ldc_w 426
    //   272: ireturn
    //   273: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   276: aload 4
    //   278: aload_3
    //   279: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   282: aload 4
    //   284: aload_1
    //   285: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   288: aload 4
    //   290: iconst_2
    //   291: putfield 425	gnu/mapping/CallContext:pc	I
    //   294: iconst_0
    //   295: ireturn
    //   296: aload 4
    //   298: aload_2
    //   299: ldc 111
    //   301: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   304: dup
    //   305: instanceof 111
    //   308: ifne +7 -> 315
    //   311: ldc_w 426
    //   314: ireturn
    //   315: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   318: aload 4
    //   320: aload_3
    //   321: invokestatic 173	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   324: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   327: aload 4
    //   329: aload_1
    //   330: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   333: aload 4
    //   335: iconst_2
    //   336: putfield 425	gnu/mapping/CallContext:pc	I
    //   339: iconst_0
    //   340: ireturn
    //   341: aload 4
    //   343: aload_2
    //   344: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   347: aload 4
    //   349: aload_3
    //   350: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   353: aload 4
    //   355: aload_1
    //   356: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   359: aload 4
    //   361: iconst_2
    //   362: putfield 425	gnu/mapping/CallContext:pc	I
    //   365: iconst_0
    //   366: ireturn
    //   367: aload 4
    //   369: aload_2
    //   370: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   373: aload 4
    //   375: aload_3
    //   376: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   379: aload 4
    //   381: aload_1
    //   382: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   385: aload 4
    //   387: iconst_2
    //   388: putfield 425	gnu/mapping/CallContext:pc	I
    //   391: iconst_0
    //   392: ireturn
    //   393: aload 4
    //   395: aload_2
    //   396: ldc_w 435
    //   399: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   402: dup
    //   403: instanceof 435
    //   406: ifne +7 -> 413
    //   409: ldc_w 426
    //   412: ireturn
    //   413: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   416: aload 4
    //   418: aload_3
    //   419: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   422: aload 4
    //   424: aload_1
    //   425: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   428: aload 4
    //   430: iconst_2
    //   431: putfield 425	gnu/mapping/CallContext:pc	I
    //   434: iconst_0
    //   435: ireturn
    //   436: aload 4
    //   438: aload_2
    //   439: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   442: aload 4
    //   444: aload_3
    //   445: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   448: aload 4
    //   450: aload_1
    //   451: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   454: aload 4
    //   456: iconst_2
    //   457: putfield 425	gnu/mapping/CallContext:pc	I
    //   460: iconst_0
    //   461: ireturn
    //   462: aload 4
    //   464: aload_2
    //   465: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   468: aload 4
    //   470: aload_3
    //   471: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   474: aload 4
    //   476: aload_1
    //   477: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   480: aload 4
    //   482: iconst_2
    //   483: putfield 425	gnu/mapping/CallContext:pc	I
    //   486: iconst_0
    //   487: ireturn
    //   488: aload 4
    //   490: aload_2
    //   491: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   494: aload 4
    //   496: aload_3
    //   497: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   500: aload 4
    //   502: aload_1
    //   503: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   506: aload 4
    //   508: iconst_2
    //   509: putfield 425	gnu/mapping/CallContext:pc	I
    //   512: iconst_0
    //   513: ireturn
    //   514: aload 4
    //   516: aload_2
    //   517: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   520: aload 4
    //   522: aload_3
    //   523: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   526: aload 4
    //   528: aload_1
    //   529: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   532: aload 4
    //   534: iconst_2
    //   535: putfield 425	gnu/mapping/CallContext:pc	I
    //   538: iconst_0
    //   539: ireturn
    //   540: aload_0
    //   541: aload_1
    //   542: aload_2
    //   543: aload_3
    //   544: aload 4
    //   546: invokespecial 439	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   549: ireturn
    // Line number table:
    //   Java source line #147	-> byte code offset #128
    //   Java source line #144	-> byte code offset #154
    //   Java source line #129	-> byte code offset #180
    //   Java source line #126	-> byte code offset #225
    //   Java source line #117	-> byte code offset #254
    //   Java source line #106	-> byte code offset #296
    //   Java source line #93	-> byte code offset #341
    //   Java source line #68	-> byte code offset #367
    //   Java source line #50	-> byte code offset #393
    //   Java source line #44	-> byte code offset #436
    //   Java source line #41	-> byte code offset #462
    //   Java source line #35	-> byte code offset #488
    //   Java source line #31	-> byte code offset #514
  }
  
  /* Error */
  public int match3(ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 414	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+313->317, 6:+280->284, 8:+247->251, 11:+197->201, 13:+164->168, 21:+112->116, 25:+60->64
    //   64: aload 5
    //   66: aload_2
    //   67: ldc 124
    //   69: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   72: dup
    //   73: instanceof 124
    //   76: ifeq +6 -> 82
    //   79: goto +7 -> 86
    //   82: ldc_w 426
    //   85: ireturn
    //   86: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   89: aload 5
    //   91: aload_3
    //   92: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   95: aload 5
    //   97: aload 4
    //   99: putfield 442	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   102: aload 5
    //   104: aload_1
    //   105: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   108: aload 5
    //   110: iconst_3
    //   111: putfield 425	gnu/mapping/CallContext:pc	I
    //   114: iconst_0
    //   115: ireturn
    //   116: aload 5
    //   118: aload_2
    //   119: ldc 111
    //   121: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   124: dup
    //   125: instanceof 111
    //   128: ifne +7 -> 135
    //   131: ldc_w 426
    //   134: ireturn
    //   135: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   138: aload 5
    //   140: aload_3
    //   141: invokestatic 173	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   144: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   147: aload 5
    //   149: aload 4
    //   151: putfield 442	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   154: aload 5
    //   156: aload_1
    //   157: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   160: aload 5
    //   162: iconst_3
    //   163: putfield 425	gnu/mapping/CallContext:pc	I
    //   166: iconst_0
    //   167: ireturn
    //   168: aload 5
    //   170: aload_2
    //   171: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   174: aload 5
    //   176: aload_3
    //   177: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   180: aload 5
    //   182: aload 4
    //   184: putfield 442	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   187: aload 5
    //   189: aload_1
    //   190: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   193: aload 5
    //   195: iconst_3
    //   196: putfield 425	gnu/mapping/CallContext:pc	I
    //   199: iconst_0
    //   200: ireturn
    //   201: aload 5
    //   203: aload_2
    //   204: ldc_w 435
    //   207: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   210: dup
    //   211: instanceof 435
    //   214: ifne +7 -> 221
    //   217: ldc_w 426
    //   220: ireturn
    //   221: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   224: aload 5
    //   226: aload_3
    //   227: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   230: aload 5
    //   232: aload 4
    //   234: putfield 442	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   237: aload 5
    //   239: aload_1
    //   240: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   243: aload 5
    //   245: iconst_3
    //   246: putfield 425	gnu/mapping/CallContext:pc	I
    //   249: iconst_0
    //   250: ireturn
    //   251: aload 5
    //   253: aload_2
    //   254: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   257: aload 5
    //   259: aload_3
    //   260: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   263: aload 5
    //   265: aload 4
    //   267: putfield 442	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   270: aload 5
    //   272: aload_1
    //   273: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   276: aload 5
    //   278: iconst_3
    //   279: putfield 425	gnu/mapping/CallContext:pc	I
    //   282: iconst_0
    //   283: ireturn
    //   284: aload 5
    //   286: aload_2
    //   287: putfield 418	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   290: aload 5
    //   292: aload_3
    //   293: putfield 433	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   296: aload 5
    //   298: aload 4
    //   300: putfield 442	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   303: aload 5
    //   305: aload_1
    //   306: putfield 422	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   309: aload 5
    //   311: iconst_3
    //   312: putfield 425	gnu/mapping/CallContext:pc	I
    //   315: iconst_0
    //   316: ireturn
    //   317: aload_0
    //   318: aload_1
    //   319: aload_2
    //   320: aload_3
    //   321: aload 4
    //   323: aload 5
    //   325: invokespecial 446	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   328: ireturn
    // Line number table:
    //   Java source line #129	-> byte code offset #64
    //   Java source line #111	-> byte code offset #116
    //   Java source line #53	-> byte code offset #168
    //   Java source line #50	-> byte code offset #201
    //   Java source line #38	-> byte code offset #251
    //   Java source line #35	-> byte code offset #284
  }
  
  public void apply(gnu.mapping.CallContext paramCallContext)
  {
    ModuleMethod.applyError();
  }
  
  /* Error */
  public Object apply2(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 414	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+265->269, 5:+124->128, 6:+130->134, 7:+265->269, 8:+265->269, 9:+136->140, 10:+142->146, 11:+148->152, 12:+265->269, 13:+265->269, 14:+265->269, 15:+163->167, 16:+265->269, 17:+172->176, 18:+265->269, 19:+265->269, 20:+181->185, 21:+265->269, 22:+204->208, 23:+265->269, 24:+218->222, 25:+233->237, 26:+265->269, 27:+265->269, 28:+265->269, 29:+247->251, 30:+265->269, 31:+256->260
    //   128: aload_2
    //   129: aload_3
    //   130: invokestatic 492	gnu/commonlisp/lisp/PrimOps:setplist	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: areturn
    //   134: aload_2
    //   135: aload_3
    //   136: invokestatic 494	gnu/commonlisp/lisp/PrimOps:plistGet	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: areturn
    //   140: aload_2
    //   141: aload_3
    //   142: invokestatic 497	gnu/commonlisp/lisp/PrimOps:plistRemprop	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: areturn
    //   146: aload_2
    //   147: aload_3
    //   148: invokestatic 500	gnu/commonlisp/lisp/PrimOps:plistMember	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: areturn
    //   152: aload_2
    //   153: ldc_w 435
    //   156: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   159: checkcast 435	gnu/mapping/Symbol
    //   162: aload_3
    //   163: invokestatic 504	gnu/commonlisp/lisp/PrimOps:get	(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    //   166: areturn
    //   167: aload_2
    //   168: aload_3
    //   169: invokestatic 506	gnu/commonlisp/lisp/PrimOps:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   172: getstatic 58	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   175: areturn
    //   176: aload_2
    //   177: aload_3
    //   178: invokestatic 508	gnu/commonlisp/lisp/PrimOps:fset	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   181: getstatic 58	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   184: areturn
    //   185: aload_2
    //   186: ldc 111
    //   188: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   191: checkcast 111	gnu/lists/SimpleVector
    //   194: aload_3
    //   195: invokestatic 173	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   198: checkcast 175	java/lang/Number
    //   201: invokevirtual 178	java/lang/Number:intValue	()I
    //   204: invokestatic 512	gnu/commonlisp/lisp/PrimOps:aref	(Lgnu/lists/SimpleVector;I)Ljava/lang/Object;
    //   207: areturn
    //   208: aload_2
    //   209: ldc 111
    //   211: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   214: checkcast 111	gnu/lists/SimpleVector
    //   217: aload_3
    //   218: invokestatic 516	gnu/commonlisp/lisp/PrimOps:fillarray	(Lgnu/lists/SimpleVector;Ljava/lang/Object;)Ljava/lang/Object;
    //   221: areturn
    //   222: aload_2
    //   223: invokestatic 173	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   226: checkcast 175	java/lang/Number
    //   229: invokevirtual 178	java/lang/Number:intValue	()I
    //   232: aload_3
    //   233: invokestatic 522	gnu/commonlisp/lisp/PrimOps:makeString	(ILjava/lang/Object;)Lgnu/lists/FString;
    //   236: areturn
    //   237: aload_2
    //   238: ldc 124
    //   240: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   243: checkcast 124	java/lang/CharSequence
    //   246: aload_3
    //   247: invokestatic 526	gnu/commonlisp/lisp/PrimOps:substring	(Ljava/lang/CharSequence;Ljava/lang/Object;)Lgnu/lists/FString;
    //   250: areturn
    //   251: aload_2
    //   252: aload_3
    //   253: invokestatic 200	gnu/commonlisp/lisp/PrimOps:princ	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   256: getstatic 58	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   259: areturn
    //   260: aload_2
    //   261: aload_3
    //   262: invokestatic 227	gnu/commonlisp/lisp/PrimOps:prin1	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   265: getstatic 58	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   268: areturn
    //   269: aload_0
    //   270: aload_1
    //   271: aload_2
    //   272: aload_3
    //   273: invokespecial 529	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: areturn
    //   277: new 213	gnu/mapping/WrongType
    //   280: dup_x1
    //   281: swap
    //   282: ldc_w 501
    //   285: iconst_1
    //   286: aload_2
    //   287: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   290: athrow
    //   291: new 213	gnu/mapping/WrongType
    //   294: dup_x1
    //   295: swap
    //   296: ldc_w 509
    //   299: iconst_1
    //   300: aload_2
    //   301: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   304: athrow
    //   305: new 213	gnu/mapping/WrongType
    //   308: dup_x1
    //   309: swap
    //   310: ldc_w 509
    //   313: iconst_2
    //   314: aload_3
    //   315: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   318: athrow
    //   319: new 213	gnu/mapping/WrongType
    //   322: dup_x1
    //   323: swap
    //   324: ldc_w 513
    //   327: iconst_1
    //   328: aload_2
    //   329: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   332: athrow
    //   333: new 213	gnu/mapping/WrongType
    //   336: dup_x1
    //   337: swap
    //   338: ldc_w 518
    //   341: iconst_1
    //   342: aload_2
    //   343: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   346: athrow
    //   347: new 213	gnu/mapping/WrongType
    //   350: dup_x1
    //   351: swap
    //   352: ldc_w 523
    //   355: iconst_1
    //   356: aload_2
    //   357: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   360: athrow
    // Line number table:
    //   Java source line #31	-> byte code offset #128
    //   Java source line #35	-> byte code offset #134
    //   Java source line #41	-> byte code offset #140
    //   Java source line #44	-> byte code offset #146
    //   Java source line #50	-> byte code offset #152
    //   Java source line #68	-> byte code offset #167
    //   Java source line #93	-> byte code offset #176
    //   Java source line #106	-> byte code offset #185
    //   Java source line #117	-> byte code offset #208
    //   Java source line #126	-> byte code offset #222
    //   Java source line #129	-> byte code offset #237
    //   Java source line #144	-> byte code offset #251
    //   Java source line #147	-> byte code offset #260
    //   Java source line #50	-> byte code offset #277
    //   Java source line #107	-> byte code offset #291
    //   Java source line #108	-> byte code offset #305
    //   Java source line #117	-> byte code offset #319
    //   Java source line #126	-> byte code offset #333
    //   Java source line #129	-> byte code offset #347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	PrimOps
    //   0	361	1	paramModuleMethod	ModuleMethod
    //   0	361	2	paramObject1	Object
    //   0	361	3	paramObject2	Object
    //   277	1	4	localClassCastException1	ClassCastException
    //   291	1	5	localClassCastException2	ClassCastException
    //   305	1	6	localClassCastException3	ClassCastException
    //   319	1	7	localClassCastException4	ClassCastException
    //   333	1	8	localClassCastException5	ClassCastException
    //   347	1	9	localClassCastException6	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   159	162	277	java/lang/ClassCastException
    //   191	194	291	java/lang/ClassCastException
    //   198	204	305	java/lang/ClassCastException
    //   214	217	319	java/lang/ClassCastException
    //   226	232	333	java/lang/ClassCastException
    //   243	246	347	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 414	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+145->149, 6:+60->64, 8:+68->72, 11:+76->80, 13:+93->97, 21:+104->108, 25:+129->133
    //   64: aload_2
    //   65: aload_3
    //   66: aload 4
    //   68: invokestatic 44	gnu/commonlisp/lisp/PrimOps:plistGet	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   71: areturn
    //   72: aload_2
    //   73: aload_3
    //   74: aload 4
    //   76: invokestatic 530	gnu/commonlisp/lisp/PrimOps:plistPut	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   79: areturn
    //   80: aload_2
    //   81: ldc_w 435
    //   84: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   87: checkcast 435	gnu/mapping/Symbol
    //   90: aload_3
    //   91: aload 4
    //   93: invokestatic 72	gnu/commonlisp/lisp/PrimOps:get	(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: areturn
    //   97: aload_2
    //   98: aload_3
    //   99: aload 4
    //   101: invokestatic 532	gnu/commonlisp/lisp/PrimOps:put	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   104: getstatic 58	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   107: areturn
    //   108: aload_2
    //   109: ldc 111
    //   111: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   114: checkcast 111	gnu/lists/SimpleVector
    //   117: aload_3
    //   118: invokestatic 173	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   121: checkcast 175	java/lang/Number
    //   124: invokevirtual 178	java/lang/Number:intValue	()I
    //   127: aload 4
    //   129: invokestatic 536	gnu/commonlisp/lisp/PrimOps:aset	(Lgnu/lists/SimpleVector;ILjava/lang/Object;)Ljava/lang/Object;
    //   132: areturn
    //   133: aload_2
    //   134: ldc 124
    //   136: invokestatic 209	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   139: checkcast 124	java/lang/CharSequence
    //   142: aload_3
    //   143: aload 4
    //   145: invokestatic 140	gnu/commonlisp/lisp/PrimOps:substring	(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/FString;
    //   148: areturn
    //   149: aload_0
    //   150: aload_1
    //   151: aload_2
    //   152: aload_3
    //   153: aload 4
    //   155: invokespecial 540	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   158: areturn
    //   159: new 213	gnu/mapping/WrongType
    //   162: dup_x1
    //   163: swap
    //   164: ldc_w 501
    //   167: iconst_1
    //   168: aload_2
    //   169: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   172: athrow
    //   173: new 213	gnu/mapping/WrongType
    //   176: dup_x1
    //   177: swap
    //   178: ldc_w 533
    //   181: iconst_1
    //   182: aload_2
    //   183: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   186: athrow
    //   187: new 213	gnu/mapping/WrongType
    //   190: dup_x1
    //   191: swap
    //   192: ldc_w 533
    //   195: iconst_2
    //   196: aload_3
    //   197: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   200: athrow
    //   201: new 213	gnu/mapping/WrongType
    //   204: dup_x1
    //   205: swap
    //   206: ldc_w 523
    //   209: iconst_1
    //   210: aload_2
    //   211: invokespecial 218	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   214: athrow
    // Line number table:
    //   Java source line #35	-> byte code offset #64
    //   Java source line #38	-> byte code offset #72
    //   Java source line #50	-> byte code offset #80
    //   Java source line #53	-> byte code offset #97
    //   Java source line #111	-> byte code offset #108
    //   Java source line #129	-> byte code offset #133
    //   Java source line #50	-> byte code offset #159
    //   Java source line #111	-> byte code offset #173
    //   Java source line #112	-> byte code offset #187
    //   Java source line #129	-> byte code offset #201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	PrimOps
    //   0	215	1	paramModuleMethod	ModuleMethod
    //   0	215	2	paramObject1	Object
    //   0	215	3	paramObject2	Object
    //   0	215	4	paramObject3	Object
    //   159	1	5	localClassCastException1	ClassCastException
    //   173	1	6	localClassCastException2	ClassCastException
    //   187	1	7	localClassCastException3	ClassCastException
    //   201	1	8	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   87	90	159	java/lang/ClassCastException
    //   114	117	173	java/lang/ClassCastException
    //   121	127	187	java/lang/ClassCastException
    //   139	142	201	java/lang/ClassCastException
  }
}
