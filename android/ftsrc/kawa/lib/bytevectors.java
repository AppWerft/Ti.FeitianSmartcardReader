package kawa.lib; import gnu.lists.U8Vector;

public class bytevectors extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.expr.ModuleMethod bytevector$Qu;
  public static final gnu.expr.ModuleMethod make$Mnbytevector;
  
  public static boolean isBytevector(Object x) { return x instanceof U8Vector; }
  
  public static U8Vector makeBytevector(int n, int init) {
    return new U8Vector(n, (byte)init);
  }
  
  public static int bytevectorLength(U8Vector v) { return v.size(); }
  
  public static int bytevectorU8Ref(U8Vector v, int i) {
    return v.getInt(i);
  }
  
  public static void bytevectorU8Set$Ex(U8Vector v, int i, int x) { v.setByte(i, (byte)x); }
  

  public static U8Vector bytevectorCopy(U8Vector paramU8Vector, int paramInt) { return bytevectorCopy(paramU8Vector, paramInt, paramU8Vector.size()); }
  
  public static U8Vector bytevectorCopy(U8Vector v, int start, int end) { U8Vector result = new U8Vector(end - start);
    result.copyFrom(0, v, start, end);
    return result; }
  
  public static final gnu.expr.ModuleMethod bytevector$Mnlength;
  public static final gnu.expr.ModuleMethod bytevector$Mnu8$Mnref;
  public static final gnu.expr.ModuleMethod bytevector$Mnu8$Mnset$Ex;
  public static final gnu.expr.ModuleMethod bytevector$Mncopy;
  public static final gnu.expr.ModuleMethod bytevector$Mncopy$Ex;
  public static final gnu.expr.ModuleMethod bytevector$Mnappend;
  public static final gnu.expr.ModuleMethod utf8$Mn$Grstring;
  public static final gnu.expr.ModuleMethod string$Mn$Grutf8;
  public int matchN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext) { switch (selector) {case 13:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 10: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  
  public static void bytevectorCopy$Ex(U8Vector paramU8Vector1, int paramInt1, U8Vector paramU8Vector2, int paramInt2)
  {
    bytevectorCopy$Ex(paramU8Vector1, paramInt1, paramU8Vector2, paramInt2, paramU8Vector2.size()); }
  public static void bytevectorCopy$Ex(U8Vector to, int at, U8Vector from, int start, int end) { to.copyFrom(at, from, start, end); }
  
  public static Object bytevectorAppend(U8Vector... bvs) {
    int nbvs = bvs.length;
    
    int i = 0; int sz; for (int i = 0; 
        i < nbvs; 
        i++) { sz += bvs[i].size();
    }
    int size = sz;
    

    U8Vector result = new U8Vector(size);
    int j = 0; int off; for (int i = 0; 
        i < nbvs; 
        


        i++)
    {
      U8Vector bv = bvs[i];
      int bvlength = bv.size();
      result.copyFrom(off, bv, 0, bvlength);
      off += bvlength;
    }
    return result;
  }
  

  public static bytevectors $instance;
  static final gnu.mapping.SimpleSymbol Lit0;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  
  public static CharSequence utf8$To$String(U8Vector paramU8Vector, int paramInt) { return utf8$To$String(paramU8Vector, paramInt, paramU8Vector.size()); }
  
  public static CharSequence utf8$To$String(U8Vector v, int start, int end) { return v.toUtf8(start, end - start);
  }
  
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final gnu.mapping.SimpleSymbol Lit6;
  static final gnu.mapping.SimpleSymbol Lit7;
  static final gnu.mapping.SimpleSymbol Lit8;
  static final gnu.mapping.SimpleSymbol Lit9 = gnu.mapping.Symbol.valueOf("string->utf8");
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isBytevector(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    try {
      return makeBytevector(((Number)gnu.mapping.Promise.force(paramObject)).intValue()); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      
















































        localClassCastException1, "make-bytevector", 1, paramObject);
    }
    try
    {
      return Integer.valueOf(bytevectorLength(gnu.kawa.lispexpr.LangObjType.coerceToU8Vector(gnu.mapping.Promise.force(paramObject, U8Vector.class)))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "bytevector-length", 1, paramObject);
    }
    




    try
    {
      return bytevectorCopy(gnu.kawa.lispexpr.LangObjType.coerceToU8Vector(gnu.mapping.Promise.force(paramObject, U8Vector.class))); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "bytevector-copy", 1, paramObject);
    }
    


























    try
    {
      return utf8$To$String(gnu.kawa.lispexpr.LangObjType.coerceToU8Vector(gnu.mapping.Promise.force(paramObject, U8Vector.class))); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "utf8->string", 1, paramObject);
    }
    


    try
    {
      return string$To$Utf8((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class));
    } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "string->utf8", 1, paramObject);
    }
    return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static U8Vector string$To$Utf8(CharSequence paramCharSequence, int paramInt) {
    return string$To$Utf8(paramCharSequence, paramInt, paramCharSequence.length());
  }
  
  public static U8Vector string$To$Utf8(CharSequence v, int start, int end)
  {
    return new U8Vector(v.toString().substring(start, end).getBytes("UTF-8"));
  }
  
  public static U8Vector makeBytevector(int paramInt)
  {
    return makeBytevector(paramInt, 0);
  }
  
  public static U8Vector bytevectorCopy(U8Vector paramU8Vector)
  {
    return bytevectorCopy(paramU8Vector, 0);
  }
  
  public static void bytevectorCopy$Ex(U8Vector paramU8Vector1, int paramInt, U8Vector paramU8Vector2)
  {
    bytevectorCopy$Ex(paramU8Vector1, paramInt, paramU8Vector2, 0);
  }
  
  public static CharSequence utf8$To$String(U8Vector paramU8Vector)
  {
    return utf8$To$String(paramU8Vector, 0);
  }
  
  public static U8Vector string$To$Utf8(CharSequence paramCharSequence)
  {
    return string$To$Utf8(paramCharSequence, 0);
  }
  
  static
  {
    Lit8 = gnu.mapping.Symbol.valueOf("utf8->string");
    Lit7 = gnu.mapping.Symbol.valueOf("bytevector-append");
    Lit6 = gnu.mapping.Symbol.valueOf("bytevector-copy!");
    Lit5 = gnu.mapping.Symbol.valueOf("bytevector-copy");
    Lit4 = gnu.mapping.Symbol.valueOf("bytevector-u8-set!");
    Lit3 = gnu.mapping.Symbol.valueOf("bytevector-u8-ref");
    Lit2 = gnu.mapping.Symbol.valueOf("bytevector-length");
    Lit1 = gnu.mapping.Symbol.valueOf("make-bytevector");
    Lit0 = gnu.mapping.Symbol.valueOf("bytevector?");
    $instance = new bytevectors();
    bytevectors localBytevectors = $instance;
    bytevector$Qu = new gnu.expr.ModuleMethod(localBytevectors, 1, Lit0, 4097);
    make$Mnbytevector = new gnu.expr.ModuleMethod(localBytevectors, 2, Lit1, 8193);
    bytevector$Mnlength = new gnu.expr.ModuleMethod(localBytevectors, 4, Lit2, 4097);
    bytevector$Mnu8$Mnref = new gnu.expr.ModuleMethod(localBytevectors, 5, Lit3, 8194);
    bytevector$Mnu8$Mnset$Ex = new gnu.expr.ModuleMethod(localBytevectors, 6, Lit4, 12291);
    bytevector$Mncopy = new gnu.expr.ModuleMethod(localBytevectors, 7, Lit5, 12289);
    bytevector$Mncopy$Ex = new gnu.expr.ModuleMethod(localBytevectors, 10, Lit6, 20483);
    bytevector$Mnappend = new gnu.expr.ModuleMethod(localBytevectors, 13, Lit7, 61440);
    utf8$Mn$Grstring = new gnu.expr.ModuleMethod(localBytevectors, 14, Lit8, 12289);
    string$Mn$Grutf8 = new gnu.expr.ModuleMethod(localBytevectors, 17, Lit9, 12289);
    $runBody$();
  }
  
  public bytevectors()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 185	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+237->241, 1:+220->224, 2:+200->204, 4:+165->169, 7:+130->134, 14:+95->99, 17:+60->64
    //   64: aload_3
    //   65: aload_2
    //   66: ldc 71
    //   68: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   71: dup
    //   72: instanceof 71
    //   75: ifeq +6 -> 81
    //   78: goto +6 -> 84
    //   81: ldc -64
    //   83: ireturn
    //   84: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   87: aload_3
    //   88: aload_1
    //   89: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   92: aload_3
    //   93: iconst_1
    //   94: putfield 203	gnu/mapping/CallContext:pc	I
    //   97: iconst_0
    //   98: ireturn
    //   99: aload_3
    //   100: aload_2
    //   101: ldc 12
    //   103: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   106: dup
    //   107: instanceof 12
    //   110: ifeq +6 -> 116
    //   113: goto +6 -> 119
    //   116: ldc -64
    //   118: ireturn
    //   119: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   122: aload_3
    //   123: aload_1
    //   124: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   127: aload_3
    //   128: iconst_1
    //   129: putfield 203	gnu/mapping/CallContext:pc	I
    //   132: iconst_0
    //   133: ireturn
    //   134: aload_3
    //   135: aload_2
    //   136: ldc 12
    //   138: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   141: dup
    //   142: instanceof 12
    //   145: ifeq +6 -> 151
    //   148: goto +6 -> 154
    //   151: ldc -64
    //   153: ireturn
    //   154: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   157: aload_3
    //   158: aload_1
    //   159: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   162: aload_3
    //   163: iconst_1
    //   164: putfield 203	gnu/mapping/CallContext:pc	I
    //   167: iconst_0
    //   168: ireturn
    //   169: aload_3
    //   170: aload_2
    //   171: ldc 12
    //   173: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   176: dup
    //   177: instanceof 12
    //   180: ifeq +6 -> 186
    //   183: goto +6 -> 189
    //   186: ldc -64
    //   188: ireturn
    //   189: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   192: aload_3
    //   193: aload_1
    //   194: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   197: aload_3
    //   198: iconst_1
    //   199: putfield 203	gnu/mapping/CallContext:pc	I
    //   202: iconst_0
    //   203: ireturn
    //   204: aload_3
    //   205: aload_2
    //   206: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   209: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   212: aload_3
    //   213: aload_1
    //   214: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   217: aload_3
    //   218: iconst_1
    //   219: putfield 203	gnu/mapping/CallContext:pc	I
    //   222: iconst_0
    //   223: ireturn
    //   224: aload_3
    //   225: aload_2
    //   226: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   229: aload_3
    //   230: aload_1
    //   231: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   234: aload_3
    //   235: iconst_1
    //   236: putfield 203	gnu/mapping/CallContext:pc	I
    //   239: iconst_0
    //   240: ireturn
    //   241: aload_0
    //   242: aload_1
    //   243: aload_2
    //   244: aload_3
    //   245: invokespecial 210	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   248: ireturn
    // Line number table:
    //   Java source line #58	-> byte code offset #64
    //   Java source line #51	-> byte code offset #99
    //   Java source line #20	-> byte code offset #134
    //   Java source line #11	-> byte code offset #169
    //   Java source line #8	-> byte code offset #204
    //   Java source line #5	-> byte code offset #224
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 185	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+272->276, 2:+240->244, 5:+193->197, 7:+146->150, 14:+99->103, 17:+52->56
    //   56: aload 4
    //   58: aload_2
    //   59: ldc 71
    //   61: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: instanceof 71
    //   68: ifeq +6 -> 74
    //   71: goto +6 -> 77
    //   74: ldc -64
    //   76: ireturn
    //   77: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   80: aload 4
    //   82: aload_3
    //   83: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   89: aload 4
    //   91: aload_1
    //   92: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   95: aload 4
    //   97: iconst_2
    //   98: putfield 203	gnu/mapping/CallContext:pc	I
    //   101: iconst_0
    //   102: ireturn
    //   103: aload 4
    //   105: aload_2
    //   106: ldc 12
    //   108: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   111: dup
    //   112: instanceof 12
    //   115: ifeq +6 -> 121
    //   118: goto +6 -> 124
    //   121: ldc -64
    //   123: ireturn
    //   124: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   127: aload 4
    //   129: aload_3
    //   130: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   133: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   136: aload 4
    //   138: aload_1
    //   139: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   142: aload 4
    //   144: iconst_2
    //   145: putfield 203	gnu/mapping/CallContext:pc	I
    //   148: iconst_0
    //   149: ireturn
    //   150: aload 4
    //   152: aload_2
    //   153: ldc 12
    //   155: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   158: dup
    //   159: instanceof 12
    //   162: ifeq +6 -> 168
    //   165: goto +6 -> 171
    //   168: ldc -64
    //   170: ireturn
    //   171: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   174: aload 4
    //   176: aload_3
    //   177: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   180: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   183: aload 4
    //   185: aload_1
    //   186: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   189: aload 4
    //   191: iconst_2
    //   192: putfield 203	gnu/mapping/CallContext:pc	I
    //   195: iconst_0
    //   196: ireturn
    //   197: aload 4
    //   199: aload_2
    //   200: ldc 12
    //   202: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   205: dup
    //   206: instanceof 12
    //   209: ifeq +6 -> 215
    //   212: goto +6 -> 218
    //   215: ldc -64
    //   217: ireturn
    //   218: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   221: aload 4
    //   223: aload_3
    //   224: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   227: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   230: aload 4
    //   232: aload_1
    //   233: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   236: aload 4
    //   238: iconst_2
    //   239: putfield 203	gnu/mapping/CallContext:pc	I
    //   242: iconst_0
    //   243: ireturn
    //   244: aload 4
    //   246: aload_2
    //   247: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   250: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   253: aload 4
    //   255: aload_3
    //   256: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   259: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   262: aload 4
    //   264: aload_1
    //   265: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   268: aload 4
    //   270: iconst_2
    //   271: putfield 203	gnu/mapping/CallContext:pc	I
    //   274: iconst_0
    //   275: ireturn
    //   276: aload_0
    //   277: aload_1
    //   278: aload_2
    //   279: aload_3
    //   280: aload 4
    //   282: invokespecial 217	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   285: ireturn
    // Line number table:
    //   Java source line #58	-> byte code offset #56
    //   Java source line #51	-> byte code offset #103
    //   Java source line #20	-> byte code offset #150
    //   Java source line #14	-> byte code offset #197
    //   Java source line #8	-> byte code offset #244
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 185	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+352->356, 6:+295->299, 7:+238->242, 10:+166->170, 14:+109->113, 17:+52->56
    //   56: aload 5
    //   58: aload_2
    //   59: ldc 71
    //   61: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: instanceof 71
    //   68: ifeq +6 -> 74
    //   71: goto +6 -> 77
    //   74: ldc -64
    //   76: ireturn
    //   77: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   80: aload 5
    //   82: aload_3
    //   83: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   89: aload 5
    //   91: aload 4
    //   93: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   96: putfield 220	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   99: aload 5
    //   101: aload_1
    //   102: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   105: aload 5
    //   107: iconst_3
    //   108: putfield 203	gnu/mapping/CallContext:pc	I
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 5
    //   115: aload_2
    //   116: ldc 12
    //   118: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   121: dup
    //   122: instanceof 12
    //   125: ifeq +6 -> 131
    //   128: goto +6 -> 134
    //   131: ldc -64
    //   133: ireturn
    //   134: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   137: aload 5
    //   139: aload_3
    //   140: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   143: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   146: aload 5
    //   148: aload 4
    //   150: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: putfield 220	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   156: aload 5
    //   158: aload_1
    //   159: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   162: aload 5
    //   164: iconst_3
    //   165: putfield 203	gnu/mapping/CallContext:pc	I
    //   168: iconst_0
    //   169: ireturn
    //   170: aload 5
    //   172: aload_2
    //   173: ldc 12
    //   175: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   178: dup
    //   179: instanceof 12
    //   182: ifeq +6 -> 188
    //   185: goto +6 -> 191
    //   188: ldc -64
    //   190: ireturn
    //   191: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   194: aload 5
    //   196: aload_3
    //   197: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   200: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   203: aload 5
    //   205: aload 4
    //   207: ldc 12
    //   209: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   212: dup
    //   213: instanceof 12
    //   216: ifeq +6 -> 222
    //   219: goto +6 -> 225
    //   222: ldc -35
    //   224: ireturn
    //   225: putfield 220	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   228: aload 5
    //   230: aload_1
    //   231: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   234: aload 5
    //   236: iconst_3
    //   237: putfield 203	gnu/mapping/CallContext:pc	I
    //   240: iconst_0
    //   241: ireturn
    //   242: aload 5
    //   244: aload_2
    //   245: ldc 12
    //   247: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   250: dup
    //   251: instanceof 12
    //   254: ifeq +6 -> 260
    //   257: goto +6 -> 263
    //   260: ldc -64
    //   262: ireturn
    //   263: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   266: aload 5
    //   268: aload_3
    //   269: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   272: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   275: aload 5
    //   277: aload 4
    //   279: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   282: putfield 220	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   285: aload 5
    //   287: aload_1
    //   288: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   291: aload 5
    //   293: iconst_3
    //   294: putfield 203	gnu/mapping/CallContext:pc	I
    //   297: iconst_0
    //   298: ireturn
    //   299: aload 5
    //   301: aload_2
    //   302: ldc 12
    //   304: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   307: dup
    //   308: instanceof 12
    //   311: ifeq +6 -> 317
    //   314: goto +6 -> 320
    //   317: ldc -64
    //   319: ireturn
    //   320: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   323: aload 5
    //   325: aload_3
    //   326: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   329: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   332: aload 5
    //   334: aload 4
    //   336: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   339: putfield 220	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   342: aload 5
    //   344: aload_1
    //   345: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   348: aload 5
    //   350: iconst_3
    //   351: putfield 203	gnu/mapping/CallContext:pc	I
    //   354: iconst_0
    //   355: ireturn
    //   356: aload_0
    //   357: aload_1
    //   358: aload_2
    //   359: aload_3
    //   360: aload 4
    //   362: aload 5
    //   364: invokespecial 225	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   367: ireturn
    // Line number table:
    //   Java source line #58	-> byte code offset #56
    //   Java source line #51	-> byte code offset #113
    //   Java source line #27	-> byte code offset #170
    //   Java source line #20	-> byte code offset #242
    //   Java source line #17	-> byte code offset #299
  }
  
  /* Error */
  public int match4(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 185	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 10
    //   6: if_icmpne +88 -> 94
    //   9: goto +3 -> 12
    //   12: aload 6
    //   14: aload_2
    //   15: ldc 12
    //   17: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: instanceof 12
    //   24: ifeq +6 -> 30
    //   27: goto +6 -> 33
    //   30: ldc -64
    //   32: ireturn
    //   33: putfield 196	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   36: aload 6
    //   38: aload_3
    //   39: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   42: putfield 213	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   45: aload 6
    //   47: aload 4
    //   49: ldc 12
    //   51: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   54: dup
    //   55: instanceof 12
    //   58: ifeq +6 -> 64
    //   61: goto +6 -> 67
    //   64: ldc -35
    //   66: ireturn
    //   67: putfield 220	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   70: aload 6
    //   72: aload 5
    //   74: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   77: putfield 228	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   80: aload 6
    //   82: aload_1
    //   83: putfield 200	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   86: aload 6
    //   88: iconst_4
    //   89: putfield 203	gnu/mapping/CallContext:pc	I
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_0
    //   95: aload_1
    //   96: aload_2
    //   97: aload_3
    //   98: aload 4
    //   100: aload 5
    //   102: aload 6
    //   104: invokespecial 232	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   107: ireturn
    // Line number table:
    //   Java source line #27	-> byte code offset #12
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
    //   1: getfield 185	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+171->175, 2:+52->56, 5:+76->80, 7:+102->106, 14:+125->129, 17:+148->152
    //   56: aload_2
    //   57: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 258	java/lang/Number
    //   63: invokevirtual 261	java/lang/Number:intValue	()I
    //   66: aload_3
    //   67: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 258	java/lang/Number
    //   73: invokevirtual 261	java/lang/Number:intValue	()I
    //   76: invokestatic 18	kawa/lib/bytevectors:makeBytevector	(II)Lgnu/lists/U8Vector;
    //   79: areturn
    //   80: aload_2
    //   81: ldc 12
    //   83: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   86: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   89: aload_3
    //   90: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 258	java/lang/Number
    //   96: invokevirtual 261	java/lang/Number:intValue	()I
    //   99: invokestatic 316	kawa/lib/bytevectors:bytevectorU8Ref	(Lgnu/lists/U8Vector;I)I
    //   102: invokestatic 291	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: areturn
    //   106: aload_2
    //   107: ldc 12
    //   109: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   112: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   115: aload_3
    //   116: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 258	java/lang/Number
    //   122: invokevirtual 261	java/lang/Number:intValue	()I
    //   125: invokestatic 37	kawa/lib/bytevectors:bytevectorCopy	(Lgnu/lists/U8Vector;I)Lgnu/lists/U8Vector;
    //   128: areturn
    //   129: aload_2
    //   130: ldc 12
    //   132: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   135: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   138: aload_3
    //   139: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   142: checkcast 258	java/lang/Number
    //   145: invokevirtual 261	java/lang/Number:intValue	()I
    //   148: invokestatic 58	kawa/lib/bytevectors:utf8$To$String	(Lgnu/lists/U8Vector;I)Ljava/lang/CharSequence;
    //   151: areturn
    //   152: aload_2
    //   153: ldc 71
    //   155: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   158: checkcast 71	java/lang/CharSequence
    //   161: aload_3
    //   162: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: checkcast 258	java/lang/Number
    //   168: invokevirtual 261	java/lang/Number:intValue	()I
    //   171: invokestatic 69	kawa/lib/bytevectors:string$To$Utf8	(Ljava/lang/CharSequence;I)Lgnu/lists/U8Vector;
    //   174: areturn
    //   175: aload_0
    //   176: aload_1
    //   177: aload_2
    //   178: aload_3
    //   179: invokespecial 320	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: areturn
    //   183: new 265	gnu/mapping/WrongType
    //   186: dup_x1
    //   187: swap
    //   188: ldc_w 267
    //   191: iconst_1
    //   192: aload_2
    //   193: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //   197: new 265	gnu/mapping/WrongType
    //   200: dup_x1
    //   201: swap
    //   202: ldc_w 267
    //   205: iconst_2
    //   206: aload_3
    //   207: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   210: athrow
    //   211: new 265	gnu/mapping/WrongType
    //   214: dup_x1
    //   215: swap
    //   216: ldc_w 312
    //   219: iconst_1
    //   220: aload_2
    //   221: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   224: athrow
    //   225: new 265	gnu/mapping/WrongType
    //   228: dup_x1
    //   229: swap
    //   230: ldc_w 312
    //   233: iconst_2
    //   234: aload_3
    //   235: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: new 265	gnu/mapping/WrongType
    //   242: dup_x1
    //   243: swap
    //   244: ldc_w 293
    //   247: iconst_1
    //   248: aload_2
    //   249: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   252: athrow
    //   253: new 265	gnu/mapping/WrongType
    //   256: dup_x1
    //   257: swap
    //   258: ldc_w 293
    //   261: iconst_2
    //   262: aload_3
    //   263: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    //   267: new 265	gnu/mapping/WrongType
    //   270: dup_x1
    //   271: swap
    //   272: ldc_w 298
    //   275: iconst_1
    //   276: aload_2
    //   277: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: new 265	gnu/mapping/WrongType
    //   284: dup_x1
    //   285: swap
    //   286: ldc_w 298
    //   289: iconst_2
    //   290: aload_3
    //   291: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   294: athrow
    //   295: new 265	gnu/mapping/WrongType
    //   298: dup_x1
    //   299: swap
    //   300: ldc_w 303
    //   303: iconst_1
    //   304: aload_2
    //   305: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   308: athrow
    //   309: new 265	gnu/mapping/WrongType
    //   312: dup_x1
    //   313: swap
    //   314: ldc_w 303
    //   317: iconst_2
    //   318: aload_3
    //   319: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   322: athrow
    // Line number table:
    //   Java source line #8	-> byte code offset #56
    //   Java source line #14	-> byte code offset #80
    //   Java source line #20	-> byte code offset #106
    //   Java source line #51	-> byte code offset #129
    //   Java source line #58	-> byte code offset #152
    //   Java source line #8	-> byte code offset #183
    //   Java source line #14	-> byte code offset #211
    //   Java source line #20	-> byte code offset #239
    //   Java source line #21	-> byte code offset #253
    //   Java source line #51	-> byte code offset #267
    //   Java source line #53	-> byte code offset #281
    //   Java source line #59	-> byte code offset #295
    //   Java source line #61	-> byte code offset #309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	bytevectors
    //   0	323	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	323	2	paramObject1	Object
    //   0	323	3	paramObject2	Object
    //   183	1	4	localClassCastException1	ClassCastException
    //   197	1	5	localClassCastException2	ClassCastException
    //   211	1	6	localClassCastException3	ClassCastException
    //   225	1	7	localClassCastException4	ClassCastException
    //   239	1	8	localClassCastException5	ClassCastException
    //   253	1	9	localClassCastException6	ClassCastException
    //   267	1	10	localClassCastException7	ClassCastException
    //   281	1	11	localClassCastException8	ClassCastException
    //   295	1	12	localClassCastException9	ClassCastException
    //   309	1	13	localClassCastException10	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   60	66	183	java/lang/ClassCastException
    //   70	76	197	java/lang/ClassCastException
    //   86	89	211	java/lang/ClassCastException
    //   93	99	225	java/lang/ClassCastException
    //   112	115	239	java/lang/ClassCastException
    //   119	125	253	java/lang/ClassCastException
    //   135	138	267	java/lang/ClassCastException
    //   142	148	281	java/lang/ClassCastException
    //   158	161	295	java/lang/ClassCastException
    //   165	171	309	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 185	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+227->231, 6:+52->56, 7:+89->93, 10:+123->127, 14:+159->163, 17:+193->197
    //   56: aload_2
    //   57: ldc 12
    //   59: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   65: aload_3
    //   66: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   69: checkcast 258	java/lang/Number
    //   72: invokevirtual 261	java/lang/Number:intValue	()I
    //   75: aload 4
    //   77: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 258	java/lang/Number
    //   83: invokevirtual 261	java/lang/Number:intValue	()I
    //   86: invokestatic 326	kawa/lib/bytevectors:bytevectorU8Set$Ex	(Lgnu/lists/U8Vector;II)V
    //   89: getstatic 332	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   92: areturn
    //   93: aload_2
    //   94: ldc 12
    //   96: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   99: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   102: aload_3
    //   103: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 258	java/lang/Number
    //   109: invokevirtual 261	java/lang/Number:intValue	()I
    //   112: aload 4
    //   114: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   117: checkcast 258	java/lang/Number
    //   120: invokevirtual 261	java/lang/Number:intValue	()I
    //   123: invokestatic 40	kawa/lib/bytevectors:bytevectorCopy	(Lgnu/lists/U8Vector;II)Lgnu/lists/U8Vector;
    //   126: areturn
    //   127: aload_2
    //   128: ldc 12
    //   130: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   133: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   136: aload_3
    //   137: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   140: checkcast 258	java/lang/Number
    //   143: invokevirtual 261	java/lang/Number:intValue	()I
    //   146: aload 4
    //   148: ldc 12
    //   150: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   153: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   156: invokestatic 337	kawa/lib/bytevectors:bytevectorCopy$Ex	(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;)V
    //   159: getstatic 332	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   162: areturn
    //   163: aload_2
    //   164: ldc 12
    //   166: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   169: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   172: aload_3
    //   173: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   176: checkcast 258	java/lang/Number
    //   179: invokevirtual 261	java/lang/Number:intValue	()I
    //   182: aload 4
    //   184: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 258	java/lang/Number
    //   190: invokevirtual 261	java/lang/Number:intValue	()I
    //   193: invokestatic 61	kawa/lib/bytevectors:utf8$To$String	(Lgnu/lists/U8Vector;II)Ljava/lang/CharSequence;
    //   196: areturn
    //   197: aload_2
    //   198: ldc 71
    //   200: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   203: checkcast 71	java/lang/CharSequence
    //   206: aload_3
    //   207: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 258	java/lang/Number
    //   213: invokevirtual 261	java/lang/Number:intValue	()I
    //   216: aload 4
    //   218: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   221: checkcast 258	java/lang/Number
    //   224: invokevirtual 261	java/lang/Number:intValue	()I
    //   227: invokestatic 77	kawa/lib/bytevectors:string$To$Utf8	(Ljava/lang/CharSequence;II)Lgnu/lists/U8Vector;
    //   230: areturn
    //   231: aload_0
    //   232: aload_1
    //   233: aload_2
    //   234: aload_3
    //   235: aload 4
    //   237: invokespecial 341	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   240: areturn
    //   241: new 265	gnu/mapping/WrongType
    //   244: dup_x1
    //   245: swap
    //   246: ldc_w 322
    //   249: iconst_1
    //   250: aload_2
    //   251: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   254: athrow
    //   255: new 265	gnu/mapping/WrongType
    //   258: dup_x1
    //   259: swap
    //   260: ldc_w 322
    //   263: iconst_2
    //   264: aload_3
    //   265: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   268: athrow
    //   269: new 265	gnu/mapping/WrongType
    //   272: dup_x1
    //   273: swap
    //   274: ldc_w 322
    //   277: iconst_3
    //   278: aload 4
    //   280: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   283: athrow
    //   284: new 265	gnu/mapping/WrongType
    //   287: dup_x1
    //   288: swap
    //   289: ldc_w 293
    //   292: iconst_1
    //   293: aload_2
    //   294: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   297: athrow
    //   298: new 265	gnu/mapping/WrongType
    //   301: dup_x1
    //   302: swap
    //   303: ldc_w 293
    //   306: iconst_2
    //   307: aload_3
    //   308: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   311: athrow
    //   312: new 265	gnu/mapping/WrongType
    //   315: dup_x1
    //   316: swap
    //   317: ldc_w 293
    //   320: iconst_3
    //   321: aload 4
    //   323: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   326: athrow
    //   327: new 265	gnu/mapping/WrongType
    //   330: dup_x1
    //   331: swap
    //   332: ldc_w 334
    //   335: iconst_1
    //   336: aload_2
    //   337: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   340: athrow
    //   341: new 265	gnu/mapping/WrongType
    //   344: dup_x1
    //   345: swap
    //   346: ldc_w 334
    //   349: iconst_2
    //   350: aload_3
    //   351: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   354: athrow
    //   355: new 265	gnu/mapping/WrongType
    //   358: dup_x1
    //   359: swap
    //   360: ldc_w 334
    //   363: iconst_3
    //   364: aload 4
    //   366: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   369: athrow
    //   370: new 265	gnu/mapping/WrongType
    //   373: dup_x1
    //   374: swap
    //   375: ldc_w 298
    //   378: iconst_1
    //   379: aload_2
    //   380: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   383: athrow
    //   384: new 265	gnu/mapping/WrongType
    //   387: dup_x1
    //   388: swap
    //   389: ldc_w 298
    //   392: iconst_2
    //   393: aload_3
    //   394: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   397: athrow
    //   398: new 265	gnu/mapping/WrongType
    //   401: dup_x1
    //   402: swap
    //   403: ldc_w 298
    //   406: iconst_3
    //   407: aload 4
    //   409: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   412: athrow
    //   413: new 265	gnu/mapping/WrongType
    //   416: dup_x1
    //   417: swap
    //   418: ldc_w 303
    //   421: iconst_1
    //   422: aload_2
    //   423: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   426: athrow
    //   427: new 265	gnu/mapping/WrongType
    //   430: dup_x1
    //   431: swap
    //   432: ldc_w 303
    //   435: iconst_2
    //   436: aload_3
    //   437: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   440: athrow
    //   441: new 265	gnu/mapping/WrongType
    //   444: dup_x1
    //   445: swap
    //   446: ldc_w 303
    //   449: iconst_3
    //   450: aload 4
    //   452: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   455: athrow
    // Line number table:
    //   Java source line #17	-> byte code offset #56
    //   Java source line #20	-> byte code offset #93
    //   Java source line #27	-> byte code offset #127
    //   Java source line #51	-> byte code offset #163
    //   Java source line #58	-> byte code offset #197
    //   Java source line #17	-> byte code offset #241
    //   Java source line #20	-> byte code offset #284
    //   Java source line #21	-> byte code offset #298
    //   Java source line #27	-> byte code offset #327
    //   Java source line #28	-> byte code offset #341
    //   Java source line #29	-> byte code offset #355
    //   Java source line #51	-> byte code offset #370
    //   Java source line #53	-> byte code offset #384
    //   Java source line #54	-> byte code offset #398
    //   Java source line #59	-> byte code offset #413
    //   Java source line #61	-> byte code offset #427
    //   Java source line #62	-> byte code offset #441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	bytevectors
    //   0	456	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	456	2	paramObject1	Object
    //   0	456	3	paramObject2	Object
    //   0	456	4	paramObject3	Object
    //   241	1	5	localClassCastException1	ClassCastException
    //   255	1	6	localClassCastException2	ClassCastException
    //   269	1	7	localClassCastException3	ClassCastException
    //   284	1	8	localClassCastException4	ClassCastException
    //   298	1	9	localClassCastException5	ClassCastException
    //   312	1	10	localClassCastException6	ClassCastException
    //   327	1	11	localClassCastException7	ClassCastException
    //   341	1	12	localClassCastException8	ClassCastException
    //   355	1	13	localClassCastException9	ClassCastException
    //   370	1	14	localClassCastException10	ClassCastException
    //   384	1	15	localClassCastException11	ClassCastException
    //   398	1	16	localClassCastException12	ClassCastException
    //   413	1	17	localClassCastException13	ClassCastException
    //   427	1	18	localClassCastException14	ClassCastException
    //   441	1	19	localClassCastException15	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   62	65	241	java/lang/ClassCastException
    //   69	75	255	java/lang/ClassCastException
    //   80	86	269	java/lang/ClassCastException
    //   99	102	284	java/lang/ClassCastException
    //   106	112	298	java/lang/ClassCastException
    //   117	123	312	java/lang/ClassCastException
    //   133	136	327	java/lang/ClassCastException
    //   140	146	341	java/lang/ClassCastException
    //   153	156	355	java/lang/ClassCastException
    //   169	172	370	java/lang/ClassCastException
    //   176	182	384	java/lang/ClassCastException
    //   187	193	398	java/lang/ClassCastException
    //   203	206	413	java/lang/ClassCastException
    //   210	216	427	java/lang/ClassCastException
    //   221	227	441	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 185	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 10
    //   6: if_icmpne +53 -> 59
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: ldc 12
    //   15: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   21: aload_3
    //   22: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 258	java/lang/Number
    //   28: invokevirtual 261	java/lang/Number:intValue	()I
    //   31: aload 4
    //   33: ldc 12
    //   35: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   38: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   41: aload 5
    //   43: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 258	java/lang/Number
    //   49: invokevirtual 261	java/lang/Number:intValue	()I
    //   52: invokestatic 51	kawa/lib/bytevectors:bytevectorCopy$Ex	(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;I)V
    //   55: getstatic 332	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   58: areturn
    //   59: aload_0
    //   60: aload_1
    //   61: aload_2
    //   62: aload_3
    //   63: aload 4
    //   65: aload 5
    //   67: invokespecial 345	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   70: areturn
    //   71: new 265	gnu/mapping/WrongType
    //   74: dup_x1
    //   75: swap
    //   76: ldc_w 334
    //   79: iconst_1
    //   80: aload_2
    //   81: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   84: athrow
    //   85: new 265	gnu/mapping/WrongType
    //   88: dup_x1
    //   89: swap
    //   90: ldc_w 334
    //   93: iconst_2
    //   94: aload_3
    //   95: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   98: athrow
    //   99: new 265	gnu/mapping/WrongType
    //   102: dup_x1
    //   103: swap
    //   104: ldc_w 334
    //   107: iconst_3
    //   108: aload 4
    //   110: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   113: athrow
    //   114: new 265	gnu/mapping/WrongType
    //   117: dup_x1
    //   118: swap
    //   119: ldc_w 334
    //   122: iconst_4
    //   123: aload 5
    //   125: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   128: athrow
    // Line number table:
    //   Java source line #27	-> byte code offset #12
    //   Java source line #28	-> byte code offset #85
    //   Java source line #29	-> byte code offset #99
    //   Java source line #31	-> byte code offset #114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	bytevectors
    //   0	129	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	129	2	paramObject1	Object
    //   0	129	3	paramObject2	Object
    //   0	129	4	paramObject3	Object
    //   0	129	5	paramObject4	Object
    //   71	1	6	localClassCastException1	ClassCastException
    //   85	1	7	localClassCastException2	ClassCastException
    //   99	1	8	localClassCastException3	ClassCastException
    //   114	1	9	localClassCastException4	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	21	71	java/lang/ClassCastException
    //   25	31	85	java/lang/ClassCastException
    //   38	41	99	java/lang/ClassCastException
    //   46	52	114	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(gnu.expr.ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 185	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+181->185, 10:+32->36, 11:+181->185, 12:+181->185, 13:+143->147
    //   36: aload_2
    //   37: arraylength
    //   38: iconst_3
    //   39: isub
    //   40: istore_3
    //   41: aload_2
    //   42: iconst_0
    //   43: aaload
    //   44: ldc 12
    //   46: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: astore 4
    //   52: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   55: aload_2
    //   56: iconst_1
    //   57: aaload
    //   58: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: dup
    //   62: astore 4
    //   64: checkcast 258	java/lang/Number
    //   67: invokevirtual 261	java/lang/Number:intValue	()I
    //   70: aload_2
    //   71: iconst_2
    //   72: aaload
    //   73: ldc 12
    //   75: invokestatic 191	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: dup
    //   79: astore 4
    //   81: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   84: iload_3
    //   85: ifgt +9 -> 94
    //   88: invokestatic 337	kawa/lib/bytevectors:bytevectorCopy$Ex	(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;)V
    //   91: goto +52 -> 143
    //   94: iinc 3 -1
    //   97: aload_2
    //   98: iconst_3
    //   99: aaload
    //   100: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: dup
    //   104: astore 4
    //   106: checkcast 258	java/lang/Number
    //   109: invokevirtual 261	java/lang/Number:intValue	()I
    //   112: iload_3
    //   113: ifgt +9 -> 122
    //   116: invokestatic 51	kawa/lib/bytevectors:bytevectorCopy$Ex	(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;I)V
    //   119: goto +24 -> 143
    //   122: iinc 3 -1
    //   125: aload_2
    //   126: iconst_4
    //   127: aaload
    //   128: invokestatic 206	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: dup
    //   132: astore 4
    //   134: checkcast 258	java/lang/Number
    //   137: invokevirtual 261	java/lang/Number:intValue	()I
    //   140: invokestatic 54	kawa/lib/bytevectors:bytevectorCopy$Ex	(Lgnu/lists/U8Vector;ILgnu/lists/U8Vector;II)V
    //   143: getstatic 332	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   146: areturn
    //   147: aload_2
    //   148: arraylength
    //   149: istore 4
    //   151: iload 4
    //   153: anewarray 12	gnu/lists/U8Vector
    //   156: goto +17 -> 173
    //   159: dup
    //   160: iload 4
    //   162: aload_2
    //   163: iload 4
    //   165: aaload
    //   166: dup
    //   167: astore 5
    //   169: invokestatic 279	gnu/kawa/lispexpr/LangObjType:coerceToU8Vector	(Ljava/lang/Object;)Lgnu/lists/U8Vector;
    //   172: aastore
    //   173: iinc 4 -1
    //   176: iload 4
    //   178: ifge -19 -> 159
    //   181: invokestatic 351	kawa/lib/bytevectors:bytevectorAppend	([Lgnu/lists/U8Vector;)Ljava/lang/Object;
    //   184: areturn
    //   185: aload_0
    //   186: aload_1
    //   187: aload_2
    //   188: invokespecial 355	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   191: areturn
    //   192: new 265	gnu/mapping/WrongType
    //   195: dup_x1
    //   196: swap
    //   197: ldc_w 334
    //   200: iconst_1
    //   201: aload 4
    //   203: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   206: athrow
    //   207: new 265	gnu/mapping/WrongType
    //   210: dup_x1
    //   211: swap
    //   212: ldc_w 334
    //   215: iconst_2
    //   216: aload 4
    //   218: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   221: athrow
    //   222: new 265	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc_w 334
    //   230: iconst_3
    //   231: aload 4
    //   233: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   236: athrow
    //   237: new 265	gnu/mapping/WrongType
    //   240: dup_x1
    //   241: swap
    //   242: ldc_w 334
    //   245: iconst_4
    //   246: aload 4
    //   248: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   251: athrow
    //   252: new 265	gnu/mapping/WrongType
    //   255: dup_x1
    //   256: swap
    //   257: ldc_w 334
    //   260: iconst_5
    //   261: aload 4
    //   263: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    //   267: new 265	gnu/mapping/WrongType
    //   270: dup_x1
    //   271: swap
    //   272: ldc_w 347
    //   275: iconst_0
    //   276: aload 5
    //   278: invokespecial 270	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   281: athrow
    // Line number table:
    //   Java source line #27	-> byte code offset #36
    //   Java source line #35	-> byte code offset #147
    //   Java source line #27	-> byte code offset #192
    //   Java source line #28	-> byte code offset #207
    //   Java source line #29	-> byte code offset #222
    //   Java source line #31	-> byte code offset #237
    //   Java source line #32	-> byte code offset #252
    //   Java source line #35	-> byte code offset #267
    // Exception table:
    //   from	to	target	type
    //   52	55	192	java/lang/ClassCastException
    //   64	70	207	java/lang/ClassCastException
    //   81	84	222	java/lang/ClassCastException
    //   106	112	237	java/lang/ClassCastException
    //   134	140	252	java/lang/ClassCastException
    //   169	172	267	java/lang/ClassCastException
  }
}
