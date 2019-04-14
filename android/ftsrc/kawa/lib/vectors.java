package kawa.lib;
import gnu.lists.FVector;

public class vectors extends gnu.expr.ModuleBody { public static final gnu.expr.ModuleMethod vector$Qu; public static final gnu.expr.ModuleMethod make$Mnvector; public static final gnu.expr.ModuleMethod vector$Mnlength; public static final gnu.expr.ModuleMethod vector$Mnset$Ex; public static final gnu.expr.GenericProc vector$Mnref; public static final gnu.expr.ModuleMethod vector$Mn$Grlist; public static final gnu.expr.ModuleMethod list$Mn$Grvector; public static final gnu.expr.ModuleMethod vector$Mn$Grstring; public static final gnu.expr.ModuleMethod string$Mn$Grvector; public static final gnu.expr.ModuleMethod vector$Mncopy; public static final gnu.expr.ModuleMethod vector$Mncopy$Ex; public static boolean isVector(Object x) { return x instanceof FVector; }
  
  public static final gnu.expr.ModuleMethod vector$Mnfill$Ex; public static final gnu.expr.ModuleMethod vector$Mnmap; public static final gnu.expr.ModuleMethod vector$Mnfor$Mneach; static final gnu.expr.Keyword Lit0; static final gnu.expr.ModuleMethod vector$Mnref$Fn1; static final gnu.expr.ModuleMethod vector$Mnfor$Mneach$Mngeneric$Fn2; public static vectors $instance; static final gnu.mapping.SimpleSymbol Lit1;
  public static FVector makeVector(int k, Object fill) { return new FVector(k, fill); }
  
  static final gnu.mapping.SimpleSymbol Lit2; static final gnu.mapping.SimpleSymbol Lit3; static final gnu.mapping.SimpleSymbol Lit4; static final gnu.mapping.SimpleSymbol Lit5; static final gnu.mapping.SimpleSymbol Lit6; static final gnu.mapping.SimpleSymbol Lit7;
  public static int vectorLength(FVector x) { return x.size(); }
  
  static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12;
  public static void vectorSet$Ex(FVector vector, int k, Object obj) { vector.setAt(k, obj); }
  static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14;
  static { Lit14 = gnu.mapping.Symbol.valueOf("vector-for-each-generic");Lit13 = gnu.mapping.Symbol.valueOf("vector-map");Lit12 = gnu.mapping.Symbol.valueOf("vector-fill!");Lit11 = gnu.mapping.Symbol.valueOf("vector-copy!");Lit10 = gnu.mapping.Symbol.valueOf("vector-copy");Lit9 = gnu.mapping.Symbol.valueOf("string->vector");Lit8 = gnu.mapping.Symbol.valueOf("vector->string");Lit7 = gnu.mapping.Symbol.valueOf("list->vector");Lit6 = gnu.mapping.Symbol.valueOf("vector->list");Lit5 = gnu.mapping.Symbol.valueOf("vector-ref");Lit4 = gnu.mapping.Symbol.valueOf("vector-set!");Lit3 = gnu.mapping.Symbol.valueOf("vector-length");Lit2 = gnu.mapping.Symbol.valueOf("make-vector");Lit1 = gnu.mapping.Symbol.valueOf("vector?");Lit0 = gnu.expr.Keyword.make("setter");$instance = new vectors();vectors localVectors = $instance;vector$Qu = new gnu.expr.ModuleMethod(localVectors, 1, Lit1, 4097);make$Mnvector = new gnu.expr.ModuleMethod(localVectors, 2, Lit2, 8193);vector$Mnlength = new gnu.expr.ModuleMethod(localVectors, 4, Lit3, 4097);vector$Mnset$Ex = new gnu.expr.ModuleMethod(localVectors, 5, Lit4, 12291);vector$Mnref = new gnu.expr.GenericProc("vector-ref");vector$Mnref$Fn1 = new gnu.expr.ModuleMethod(localVectors, 6, Lit5, 8194);vector$Mn$Grlist = new gnu.expr.ModuleMethod(localVectors, 7, Lit6, 12289);list$Mn$Grvector = new gnu.expr.ModuleMethod(localVectors, 10, Lit7, 4097);vector$Mn$Grstring = new gnu.expr.ModuleMethod(localVectors, 11, Lit8, 12289);string$Mn$Grvector = new gnu.expr.ModuleMethod(localVectors, 14, Lit9, 12289);vector$Mncopy = new gnu.expr.ModuleMethod(localVectors, 17, Lit10, 12289);vector$Mncopy$Ex = new gnu.expr.ModuleMethod(localVectors, 20, Lit11, 20483);vector$Mnfill$Ex = new gnu.expr.ModuleMethod(localVectors, 23, Lit12, 16386); void tmp410_407 = new gnu.expr.ModuleMethod(localVectors, 26, Lit13, 61442);tmp410_407.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_map:vectorMapValidateApply");vector$Mnmap = tmp410_407;vector$Mnfor$Mneach$Mngeneric$Fn2 = new gnu.expr.ModuleMethod(localVectors, 27, Lit14, 61442); void tmp458_455 = new gnu.expr.ModuleMethod(localVectors, 28, Lit15, 61442);tmp458_455.setProperty(gnu.mapping.Procedure.validateApplyKey, "kawa.lib.compile_map:vectorForEachValidateApply");vector$Mnfor$Mneach = tmp458_455;$runBody$(); } static final gnu.mapping.SimpleSymbol Lit15 = gnu.mapping.Symbol.valueOf("vector-for-each");
  
  public static Object vectorRef(FVector vector, int k)
  {
    return vector.get(k);
  }
  
  private static void $runBody$()
  {
    ;
    gnu.lists.Consumer $result = getInstanceconsumer;
    












    vector$Mnref
      .setProperty(Lit0, vector$Mnset$Ex);
    
    gnu.mapping.Procedure vector$Mnref = vector$Mnref$Fn1;
    gnu.expr.ModuleMethod localModuleMethod;
    vector$Mnref.add(localModuleMethod = vector$Mnref$Fn1);
  }
  
  public static gnu.lists.LList vector$To$List(FVector paramFVector, int paramInt) { return vector$To$List(paramFVector, paramInt, paramFVector.size()); }
  






  public static FVector list$To$Vector(gnu.lists.LList x)
  {
    return new FVector(x);
  }
  
  public static CharSequence vector$To$String(FVector paramFVector, int paramInt) { return vector$To$String(paramFVector, paramInt, paramFVector.size()); }
  









  public static FVector string$To$Vector(CharSequence paramCharSequence, int paramInt)
  {
    return string$To$Vector(paramCharSequence, paramInt, paramCharSequence.length());
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return isVector(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    }
    try {
      return makeVector(((Number)gnu.mapping.Promise.force(paramObject)).intValue()); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      





















































        localClassCastException1, "make-vector", 1, paramObject);
    }
    try
    {
      return Integer.valueOf(vectorLength((FVector)gnu.mapping.Promise.force(paramObject, FVector.class))); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "vector-length", 1, paramObject);
    }
    








    try
    {
      return vector$To$List((FVector)gnu.mapping.Promise.force(paramObject, FVector.class)); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "vector->list", 1, paramObject);
    }
    





    try
    {
      return list$To$Vector((gnu.lists.LList)gnu.mapping.Promise.force(paramObject, gnu.lists.LList.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "list->vector", 1, paramObject);
    }
    try {
      return vector$To$String((FVector)gnu.mapping.Promise.force(paramObject, FVector.class)); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "vector->string", 1, paramObject);
    }
    








    try
    {
      return string$To$Vector((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "string->vector", 1, paramObject);
    }
    








    try
    {
      return vectorCopy((FVector)gnu.mapping.Promise.force(paramObject, FVector.class)); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "vector-copy", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject);
  }
  
  public static FVector vectorCopy(FVector paramFVector, int paramInt) { return vectorCopy(paramFVector, paramInt, paramFVector.size()); }
  
  public static FVector vectorCopy(FVector vec, int start, int end) { FVector result = new FVector(end - start);
    FVector localFVector1 = vec;result.copyFrom(0, vec, start, end);
    return result;
  }
  






















































  public int matchN(gnu.expr.ModuleMethod paramModuleMethod, Object[] paramArrayOfObject, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 28:  values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    







    case 27: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 26: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0;
    case 20: 
      values = paramArrayOfObject;proc = paramModuleMethod;pc = 5;return 0; } return super.matchN(paramModuleMethod, paramArrayOfObject, paramCallContext);
  }
  


  public static void vectorCopy$Ex(FVector paramFVector1, int paramInt1, FVector paramFVector2, int paramInt2) { vectorCopy$Ex(paramFVector1, paramInt1, paramFVector2, paramInt2, paramFVector2.size()); }
  public static void vectorCopy$Ex(FVector to, int at, FVector from, int start, int end) { FVector localFVector; to.copyFrom(at, localFVector = from, start, end);
  }
  
  public static void vectorFill$Ex(FVector paramFVector, Object paramObject, int paramInt) { vectorFill$Ex(paramFVector, paramObject, paramInt, paramFVector.size()); }
  
  public static void vectorFill$Ex(FVector vec, Object fill, int start, int end) { vec.fill(start, end, fill); }
  











  public static FVector vectorMap(gnu.mapping.Procedure proc, Object vec1, Object... vecs)
  {
    Object localObject1 = 
    









      vec1;gnu.mapping.Procedure proc = proc;
    Object vec;
    gnu.mapping.Procedure localProcedure1 = proc;gnu.mapping.Procedure localProcedure2 = localProcedure1;Object localObject2 = vec;Object localObject3 = gnu.mapping.Promise.force(localObject2, gnu.lists.SimpleVector.class);gnu.lists.SimpleVector localSimpleVector1 = (gnu.lists.SimpleVector)localObject3;gnu.lists.SimpleVector localSimpleVector2 = 
      localSimpleVector1;gnu.mapping.Procedure proc = localProcedure2;
    java.util.List vec;
    int len = vec.size();Object[] r = new Object[len];
    
    for (int i = 0; i != len; 
        
        i++) { r[i] = proc.apply1(vec.get(i));
    }
    

    Object[] r = new Object[gnu.lists.Sequences.getSize(vec)];
    java.util.Iterator it = gnu.lists.Sequences.getIterator(vec);
    for (int i = 0; 
        it.hasNext(); 
        
        i++) { r[i] = proc.apply1(it.next());
    }
    

    int nargs = vecs.length + 1;java.util.Iterator[] iterators = new java.util.Iterator[nargs];Object[] elements = new Object[nargs];
    

    FVector result = makeVector(0);
    for (int i = 0; i != nargs; 
        

        i++) { iterators[i] = gnu.lists.Sequences.getIterator(i == 0 ? vec1 : vecs[(i - 1)]);
    }
    int i = 0;
    for (;;) { if (i == nargs) {
        int i = 0;len = elements;i = (r = gnu.kawa.functions.MakeSplice.count(len)) + i; Object[] tmp278_275 = new Object[i];i = 0;gnu.kawa.functions.MakeSplice.copyTo(tmp278_275, i, r, len);i += r;result.add(proc.applyN(tmp278_275));
        break; }
      if (!iterators[i].hasNext()) break label342;
      elements[i] = iterators[i].next();
      i++; }
    label342:
    return vecs.length == 0 ? new FVector(r) : (localObject3 instanceof gnu.lists.SimpleVector) ? new FVector(r) : result;
  }
  







  public static void vectorForEach(gnu.mapping.Procedure f, java.util.List vec, java.util.List... vecs)
  {
    gnu.mapping.Procedure vector$Mnfor$Mneach$Mngeneric = vector$Mnfor$Mneach$Mngeneric$Fn2;
    













    if (vecs.length == 0)
    {
      java.util.List localList1 = 
      




















        vec;gnu.mapping.Procedure f = f;
      java.util.List vec;
      int len = vec.size();
      for (int i = 0; i != len; 
          
          i++) { f.apply1(vec.get(i));
      }
    }
    














    lambda1vectorForEachGeneric(f, vec, vecs);
  }
  
  public static FVector makeVector(int paramInt)
  {
    return makeVector(paramInt, null);
  }
  
  public static gnu.lists.LList vector$To$List(FVector paramFVector)
  {
    return vector$To$List(paramFVector, 0);
  }
  
  /* Error */
  public static gnu.lists.LList vector$To$List(FVector vec, int start, int end)
  {
    // Byte code:
    //   0: getstatic 71	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   3: iload_2
    //   4: istore 4
    //   6: astore_3
    //   7: iinc 4 -1
    //   10: iload 4
    //   12: iload_1
    //   13: if_icmpge +7 -> 20
    //   16: aload_3
    //   17: goto +23 -> 40
    //   20: getstatic 33	kawa/lib/vectors:vector$Mnref	Lgnu/expr/GenericProc;
    //   23: aload_0
    //   24: iload 4
    //   26: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: invokevirtual 83	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   32: aload_3
    //   33: invokestatic 89	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   36: astore_3
    //   37: goto -30 -> 7
    //   40: areturn
    // Line number table:
    //   Java source line #22	-> byte code offset #0
    //   Java source line #25	-> byte code offset #0
    //   Java source line #27	-> byte code offset #7
    //   Java source line #28	-> byte code offset #10
    //   Java source line #30	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	vec	FVector
    //   0	40	1	start	int
    //   0	40	2	end	int
    //   7	33	3	result	gnu.lists.LList
    //   7	33	4	i	int
  }
  
  public static CharSequence vector$To$String(FVector paramFVector)
  {
    return vector$To$String(paramFVector, 0);
  }
  
  /* Error */
  public static CharSequence vector$To$String(FVector vec, int start, int end)
  {
    // Byte code:
    //   0: new 101	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   7: iload_1
    //   8: istore 4
    //   10: astore_3
    //   11: iload 4
    //   13: iload_2
    //   14: if_icmplt +14 -> 28
    //   17: new 106	gnu/lists/FString
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 109	gnu/lists/FString:<init>	(Ljava/lang/StringBuilder;)V
    //   25: goto +69 -> 94
    //   28: getstatic 33	kawa/lib/vectors:vector$Mnref	Lgnu/expr/GenericProc;
    //   31: aload_0
    //   32: iload 4
    //   34: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokevirtual 83	gnu/mapping/Procedure:apply2	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore 5
    //   42: aload 5
    //   44: instanceof 111
    //   47: ifeq +24 -> 71
    //   50: aload_3
    //   51: aload 5
    //   53: ldc 111
    //   55: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   58: checkcast 111	java/lang/Character
    //   61: invokevirtual 121	java/lang/Character:charValue	()C
    //   64: invokevirtual 125	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto +20 -> 88
    //   71: aload 5
    //   73: ldc 127
    //   75: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: checkcast 127	gnu/text/Char
    //   81: invokevirtual 130	gnu/text/Char:intValue	()I
    //   84: aload_3
    //   85: invokestatic 134	gnu/text/Char:print	(ILjava/lang/Appendable;)V
    //   88: iinc 4 1
    //   91: goto -80 -> 11
    //   94: areturn
    // Line number table:
    //   Java source line #35	-> byte code offset #0
    //   Java source line #38	-> byte code offset #0
    //   Java source line #40	-> byte code offset #11
    //   Java source line #41	-> byte code offset #17
    //   Java source line #42	-> byte code offset #28
    //   Java source line #43	-> byte code offset #42
    //   Java source line #44	-> byte code offset #50
    //   Java source line #45	-> byte code offset #71
    //   Java source line #46	-> byte code offset #88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	vec	FVector
    //   0	94	1	start	int
    //   0	94	2	end	int
    //   11	83	3	result	StringBuilder
    //   11	83	4	i	int
    //   42	52	5	ch	Object
  }
  
  public static FVector string$To$Vector(CharSequence paramCharSequence)
  {
    return string$To$Vector(paramCharSequence, 0);
  }
  
  /* Error */
  public static FVector string$To$Vector(CharSequence str, int start, int end)
  {
    // Byte code:
    //   0: iload_2
    //   1: iload_1
    //   2: isub
    //   3: anewarray 148	java/lang/Object
    //   6: iload_1
    //   7: iconst_0
    //   8: istore 5
    //   10: istore 4
    //   12: astore_3
    //   13: iload 4
    //   15: iload_2
    //   16: if_icmplt +14 -> 30
    //   19: new 12	gnu/lists/FVector
    //   22: dup
    //   23: aload_3
    //   24: invokespecial 151	gnu/lists/FVector:<init>	([Ljava/lang/Object;)V
    //   27: goto +31 -> 58
    //   30: aload_0
    //   31: iload 4
    //   33: invokeinterface 155 2 0
    //   38: istore 6
    //   40: aload_3
    //   41: iload 5
    //   43: iload 6
    //   45: invokestatic 159	gnu/text/Char:make	(I)Lgnu/text/Char;
    //   48: aastore
    //   49: iinc 5 1
    //   52: iinc 4 1
    //   55: goto -42 -> 13
    //   58: areturn
    // Line number table:
    //   Java source line #48	-> byte code offset #0
    //   Java source line #51	-> byte code offset #0
    //   Java source line #54	-> byte code offset #13
    //   Java source line #55	-> byte code offset #19
    //   Java source line #57	-> byte code offset #30
    //   Java source line #58	-> byte code offset #40
    //   Java source line #59	-> byte code offset #49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	str	CharSequence
    //   0	58	1	start	int
    //   0	58	2	end	int
    //   13	45	3	result	Object[]
    //   13	45	4	i	int
    //   13	45	5	j	int
    //   40	18	6	ch	char
  }
  
  public static FVector vectorCopy(FVector paramFVector)
  {
    return vectorCopy(paramFVector, 0);
  }
  
  public static void vectorCopy$Ex(FVector paramFVector1, int paramInt, FVector paramFVector2)
  {
    vectorCopy$Ex(paramFVector1, paramInt, paramFVector2, 0);
  }
  
  public static void vectorFill$Ex(FVector paramFVector, Object paramObject)
  {
    vectorFill$Ex(paramFVector, paramObject, 0);
  }
  
  /* Error */
  public static Object lambda1vectorForEachGeneric(gnu.mapping.Procedure f, java.util.List vec, java.util.List... vecs)
  {
    // Byte code:
    //   0: getstatic 71	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   3: aload_1
    //   4: invokeinterface 196 1 0
    //   9: aload_2
    //   10: arraylength
    //   11: iconst_1
    //   12: isub
    //   13: istore 5
    //   15: istore 4
    //   17: astore_3
    //   18: iload 5
    //   20: iflt +63 -> 83
    //   23: aload_2
    //   24: iload 5
    //   26: aaload
    //   27: aload_3
    //   28: invokestatic 89	kawa/lib/lists:cons	(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   31: iconst_2
    //   32: anewarray 148	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload 4
    //   39: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: aload_2
    //   46: iload 5
    //   48: aaload
    //   49: dup
    //   50: astore 6
    //   52: checkcast 12	gnu/lists/FVector
    //   55: invokestatic 253	kawa/lib/vectors:vectorLength	(Lgnu/lists/FVector;)I
    //   58: invokestatic 77	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: aastore
    //   62: invokestatic 258	kawa/lib/numbers:min	([Ljava/lang/Object;)Ljava/lang/Object;
    //   65: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 262	java/lang/Number
    //   71: invokevirtual 263	java/lang/Number:intValue	()I
    //   74: iinc 5 -1
    //   77: istore 4
    //   79: astore_3
    //   80: goto -62 -> 18
    //   83: iconst_0
    //   84: istore 6
    //   86: iload 6
    //   88: iload 4
    //   90: if_icmpeq +130 -> 220
    //   93: getstatic 269	kawa/standard/Scheme:apply	Lgnu/kawa/functions/Apply;
    //   96: aload_0
    //   97: aload_1
    //   98: iload 6
    //   100: invokeinterface 197 2 0
    //   105: aload_3
    //   106: astore 7
    //   108: getstatic 71	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   111: astore 8
    //   113: aconst_null
    //   114: astore 9
    //   116: aload 7
    //   118: getstatic 71	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   121: if_acmpeq +87 -> 208
    //   124: aload 7
    //   126: ldc_w 271
    //   129: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   132: checkcast 271	gnu/lists/Pair
    //   135: astore 10
    //   137: aload 10
    //   139: invokevirtual 274	gnu/lists/Pair:getCar	()Ljava/lang/Object;
    //   142: astore 11
    //   144: new 271	gnu/lists/Pair
    //   147: dup
    //   148: aload 11
    //   150: ldc -61
    //   152: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   155: dup
    //   156: astore 14
    //   158: checkcast 195	java/util/List
    //   161: astore 13
    //   163: aload 13
    //   165: iload 6
    //   167: invokeinterface 197 2 0
    //   172: getstatic 71	gnu/lists/LList:Empty	Lgnu/lists/EmptyList;
    //   175: invokespecial 279	gnu/lists/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   178: aload 9
    //   180: ifnonnull +9 -> 189
    //   183: dup
    //   184: astore 8
    //   186: goto +10 -> 196
    //   189: aload 9
    //   191: swap
    //   192: dup_x1
    //   193: invokevirtual 283	gnu/lists/Pair:setCdr	(Ljava/lang/Object;)V
    //   196: astore 9
    //   198: aload 10
    //   200: invokevirtual 286	gnu/lists/Pair:getCdr	()Ljava/lang/Object;
    //   203: astore 7
    //   205: goto -89 -> 116
    //   208: aload 8
    //   210: invokevirtual 290	gnu/mapping/Procedure:apply3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   213: pop
    //   214: iinc 6 1
    //   217: goto -131 -> 86
    //   220: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   223: areturn
    //   224: new 244	gnu/mapping/WrongType
    //   227: dup_x1
    //   228: swap
    //   229: ldc -10
    //   231: iconst_0
    //   232: aload 6
    //   234: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   237: athrow
    //   238: new 244	gnu/mapping/WrongType
    //   241: dup_x1
    //   242: swap
    //   243: ldc_w 276
    //   246: bipush -2
    //   248: aload 14
    //   250: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   253: athrow
    // Line number table:
    //   Java source line #137	-> byte code offset #0
    //   Java source line #140	-> byte code offset #0
    //   Java source line #141	-> byte code offset #3
    //   Java source line #142	-> byte code offset #9
    //   Java source line #143	-> byte code offset #18
    //   Java source line #144	-> byte code offset #23
    //   Java source line #145	-> byte code offset #31
    //   Java source line #147	-> byte code offset #83
    //   Java source line #149	-> byte code offset #93
    //   Java source line #150	-> byte code offset #105
    //   Java source line #151	-> byte code offset #105
    //   Java source line #150	-> byte code offset #163
    //   Java source line #145	-> byte code offset #224
    //   Java source line #150	-> byte code offset #238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	f	gnu.mapping.Procedure
    //   0	223	1	vec	java.util.List
    //   0	223	2	vecs	java.util.List[]
    //   18	205	3	ls	gnu.lists.LList
    //   18	205	4	len	int
    //   18	205	5	i	int
    //   86	137	6	i	int
    //   163	9	13	v	java.util.List
    // Exception table:
    //   from	to	target	type
    //   52	55	224	java/lang/ClassCastException
    //   158	161	238	java/lang/ClassCastException
  }
  
  public vectors()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+337->341, 1:+320->324, 2:+300->304, 3:+337->341, 4:+264->268, 5:+337->341, 6:+337->341, 7:+228->232, 8:+337->341, 9:+337->341, 10:+192->196, 11:+156->160, 12:+337->341, 13:+337->341, 14:+120->124, 15:+337->341, 16:+337->341, 17:+84->88
    //   88: aload_3
    //   89: aload_2
    //   90: ldc 12
    //   92: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: dup
    //   96: instanceof 12
    //   99: ifeq +6 -> 105
    //   102: goto +7 -> 109
    //   105: ldc_w 428
    //   108: ireturn
    //   109: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   112: aload_3
    //   113: aload_1
    //   114: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   117: aload_3
    //   118: iconst_1
    //   119: putfield 439	gnu/mapping/CallContext:pc	I
    //   122: iconst_0
    //   123: ireturn
    //   124: aload_3
    //   125: aload_2
    //   126: ldc -116
    //   128: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   131: dup
    //   132: instanceof 140
    //   135: ifeq +6 -> 141
    //   138: goto +7 -> 145
    //   141: ldc_w 428
    //   144: ireturn
    //   145: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   148: aload_3
    //   149: aload_1
    //   150: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   153: aload_3
    //   154: iconst_1
    //   155: putfield 439	gnu/mapping/CallContext:pc	I
    //   158: iconst_0
    //   159: ireturn
    //   160: aload_3
    //   161: aload_2
    //   162: ldc 12
    //   164: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   167: dup
    //   168: instanceof 12
    //   171: ifeq +6 -> 177
    //   174: goto +7 -> 181
    //   177: ldc_w 428
    //   180: ireturn
    //   181: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   184: aload_3
    //   185: aload_1
    //   186: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   189: aload_3
    //   190: iconst_1
    //   191: putfield 439	gnu/mapping/CallContext:pc	I
    //   194: iconst_0
    //   195: ireturn
    //   196: aload_3
    //   197: aload_2
    //   198: ldc 67
    //   200: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   203: dup
    //   204: instanceof 67
    //   207: ifeq +6 -> 213
    //   210: goto +7 -> 217
    //   213: ldc_w 428
    //   216: ireturn
    //   217: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   220: aload_3
    //   221: aload_1
    //   222: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   225: aload_3
    //   226: iconst_1
    //   227: putfield 439	gnu/mapping/CallContext:pc	I
    //   230: iconst_0
    //   231: ireturn
    //   232: aload_3
    //   233: aload_2
    //   234: ldc 12
    //   236: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   239: dup
    //   240: instanceof 12
    //   243: ifeq +6 -> 249
    //   246: goto +7 -> 253
    //   249: ldc_w 428
    //   252: ireturn
    //   253: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   256: aload_3
    //   257: aload_1
    //   258: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   261: aload_3
    //   262: iconst_1
    //   263: putfield 439	gnu/mapping/CallContext:pc	I
    //   266: iconst_0
    //   267: ireturn
    //   268: aload_3
    //   269: aload_2
    //   270: ldc 12
    //   272: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   275: dup
    //   276: instanceof 12
    //   279: ifeq +6 -> 285
    //   282: goto +7 -> 289
    //   285: ldc_w 428
    //   288: ireturn
    //   289: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   292: aload_3
    //   293: aload_1
    //   294: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   297: aload_3
    //   298: iconst_1
    //   299: putfield 439	gnu/mapping/CallContext:pc	I
    //   302: iconst_0
    //   303: ireturn
    //   304: aload_3
    //   305: aload_2
    //   306: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   309: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   312: aload_3
    //   313: aload_1
    //   314: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   317: aload_3
    //   318: iconst_1
    //   319: putfield 439	gnu/mapping/CallContext:pc	I
    //   322: iconst_0
    //   323: ireturn
    //   324: aload_3
    //   325: aload_2
    //   326: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   329: aload_3
    //   330: aload_1
    //   331: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   334: aload_3
    //   335: iconst_1
    //   336: putfield 439	gnu/mapping/CallContext:pc	I
    //   339: iconst_0
    //   340: ireturn
    //   341: aload_0
    //   342: aload_1
    //   343: aload_2
    //   344: aload_3
    //   345: invokespecial 443	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   348: ireturn
    // Line number table:
    //   Java source line #61	-> byte code offset #88
    //   Java source line #48	-> byte code offset #124
    //   Java source line #35	-> byte code offset #160
    //   Java source line #32	-> byte code offset #196
    //   Java source line #22	-> byte code offset #232
    //   Java source line #9	-> byte code offset #268
    //   Java source line #6	-> byte code offset #304
    //   Java source line #3	-> byte code offset #324
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+382->386, 2:+353->357, 6:+305->309, 7:+257->261, 11:+209->213, 14:+161->165, 17:+113->117, 23:+68->72
    //   72: aload 4
    //   74: aload_2
    //   75: ldc 12
    //   77: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   80: dup
    //   81: instanceof 12
    //   84: ifeq +6 -> 90
    //   87: goto +7 -> 94
    //   90: ldc_w 428
    //   93: ireturn
    //   94: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   97: aload 4
    //   99: aload_3
    //   100: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   103: aload 4
    //   105: aload_1
    //   106: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   109: aload 4
    //   111: iconst_2
    //   112: putfield 439	gnu/mapping/CallContext:pc	I
    //   115: iconst_0
    //   116: ireturn
    //   117: aload 4
    //   119: aload_2
    //   120: ldc 12
    //   122: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   125: dup
    //   126: instanceof 12
    //   129: ifeq +6 -> 135
    //   132: goto +7 -> 139
    //   135: ldc_w 428
    //   138: ireturn
    //   139: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   142: aload 4
    //   144: aload_3
    //   145: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   148: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   151: aload 4
    //   153: aload_1
    //   154: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   157: aload 4
    //   159: iconst_2
    //   160: putfield 439	gnu/mapping/CallContext:pc	I
    //   163: iconst_0
    //   164: ireturn
    //   165: aload 4
    //   167: aload_2
    //   168: ldc -116
    //   170: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   173: dup
    //   174: instanceof 140
    //   177: ifeq +6 -> 183
    //   180: goto +7 -> 187
    //   183: ldc_w 428
    //   186: ireturn
    //   187: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   190: aload 4
    //   192: aload_3
    //   193: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   196: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   199: aload 4
    //   201: aload_1
    //   202: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   205: aload 4
    //   207: iconst_2
    //   208: putfield 439	gnu/mapping/CallContext:pc	I
    //   211: iconst_0
    //   212: ireturn
    //   213: aload 4
    //   215: aload_2
    //   216: ldc 12
    //   218: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   221: dup
    //   222: instanceof 12
    //   225: ifeq +6 -> 231
    //   228: goto +7 -> 235
    //   231: ldc_w 428
    //   234: ireturn
    //   235: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   238: aload 4
    //   240: aload_3
    //   241: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   244: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   247: aload 4
    //   249: aload_1
    //   250: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   253: aload 4
    //   255: iconst_2
    //   256: putfield 439	gnu/mapping/CallContext:pc	I
    //   259: iconst_0
    //   260: ireturn
    //   261: aload 4
    //   263: aload_2
    //   264: ldc 12
    //   266: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   269: dup
    //   270: instanceof 12
    //   273: ifeq +6 -> 279
    //   276: goto +7 -> 283
    //   279: ldc_w 428
    //   282: ireturn
    //   283: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   286: aload 4
    //   288: aload_3
    //   289: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   292: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   295: aload 4
    //   297: aload_1
    //   298: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   301: aload 4
    //   303: iconst_2
    //   304: putfield 439	gnu/mapping/CallContext:pc	I
    //   307: iconst_0
    //   308: ireturn
    //   309: aload 4
    //   311: aload_2
    //   312: ldc 12
    //   314: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   317: dup
    //   318: instanceof 12
    //   321: ifeq +6 -> 327
    //   324: goto +7 -> 331
    //   327: ldc_w 428
    //   330: ireturn
    //   331: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   334: aload 4
    //   336: aload_3
    //   337: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   340: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   343: aload 4
    //   345: aload_1
    //   346: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   349: aload 4
    //   351: iconst_2
    //   352: putfield 439	gnu/mapping/CallContext:pc	I
    //   355: iconst_0
    //   356: ireturn
    //   357: aload 4
    //   359: aload_2
    //   360: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   363: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   366: aload 4
    //   368: aload_3
    //   369: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   372: aload 4
    //   374: aload_1
    //   375: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   378: aload 4
    //   380: iconst_2
    //   381: putfield 439	gnu/mapping/CallContext:pc	I
    //   384: iconst_0
    //   385: ireturn
    //   386: aload_0
    //   387: aload_1
    //   388: aload_2
    //   389: aload_3
    //   390: aload 4
    //   392: invokespecial 450	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   395: ireturn
    // Line number table:
    //   Java source line #78	-> byte code offset #72
    //   Java source line #61	-> byte code offset #117
    //   Java source line #48	-> byte code offset #165
    //   Java source line #35	-> byte code offset #213
    //   Java source line #22	-> byte code offset #261
    //   Java source line #18	-> byte code offset #309
    //   Java source line #6	-> byte code offset #357
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+484->488, 5:+429->433, 7:+371->375, 11:+313->317, 14:+255->259, 17:+197->201, 20:+123->127, 23:+68->72
    //   72: aload 5
    //   74: aload_2
    //   75: ldc 12
    //   77: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   80: dup
    //   81: instanceof 12
    //   84: ifeq +6 -> 90
    //   87: goto +7 -> 94
    //   90: ldc_w 428
    //   93: ireturn
    //   94: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   97: aload 5
    //   99: aload_3
    //   100: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   103: aload 5
    //   105: aload 4
    //   107: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   110: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   113: aload 5
    //   115: aload_1
    //   116: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   119: aload 5
    //   121: iconst_3
    //   122: putfield 439	gnu/mapping/CallContext:pc	I
    //   125: iconst_0
    //   126: ireturn
    //   127: aload 5
    //   129: aload_2
    //   130: ldc 12
    //   132: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   135: dup
    //   136: instanceof 12
    //   139: ifeq +6 -> 145
    //   142: goto +7 -> 149
    //   145: ldc_w 428
    //   148: ireturn
    //   149: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   152: aload 5
    //   154: aload_3
    //   155: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   158: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   161: aload 5
    //   163: aload 4
    //   165: ldc 12
    //   167: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   170: dup
    //   171: instanceof 12
    //   174: ifeq +6 -> 180
    //   177: goto +7 -> 184
    //   180: ldc_w 454
    //   183: ireturn
    //   184: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   187: aload 5
    //   189: aload_1
    //   190: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   193: aload 5
    //   195: iconst_3
    //   196: putfield 439	gnu/mapping/CallContext:pc	I
    //   199: iconst_0
    //   200: ireturn
    //   201: aload 5
    //   203: aload_2
    //   204: ldc 12
    //   206: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   209: dup
    //   210: instanceof 12
    //   213: ifeq +6 -> 219
    //   216: goto +7 -> 223
    //   219: ldc_w 428
    //   222: ireturn
    //   223: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   226: aload 5
    //   228: aload_3
    //   229: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   232: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   235: aload 5
    //   237: aload 4
    //   239: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   242: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   245: aload 5
    //   247: aload_1
    //   248: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   251: aload 5
    //   253: iconst_3
    //   254: putfield 439	gnu/mapping/CallContext:pc	I
    //   257: iconst_0
    //   258: ireturn
    //   259: aload 5
    //   261: aload_2
    //   262: ldc -116
    //   264: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   267: dup
    //   268: instanceof 140
    //   271: ifeq +6 -> 277
    //   274: goto +7 -> 281
    //   277: ldc_w 428
    //   280: ireturn
    //   281: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   284: aload 5
    //   286: aload_3
    //   287: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   290: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   293: aload 5
    //   295: aload 4
    //   297: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   300: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   303: aload 5
    //   305: aload_1
    //   306: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   309: aload 5
    //   311: iconst_3
    //   312: putfield 439	gnu/mapping/CallContext:pc	I
    //   315: iconst_0
    //   316: ireturn
    //   317: aload 5
    //   319: aload_2
    //   320: ldc 12
    //   322: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   325: dup
    //   326: instanceof 12
    //   329: ifeq +6 -> 335
    //   332: goto +7 -> 339
    //   335: ldc_w 428
    //   338: ireturn
    //   339: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   342: aload 5
    //   344: aload_3
    //   345: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   348: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   351: aload 5
    //   353: aload 4
    //   355: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   358: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   361: aload 5
    //   363: aload_1
    //   364: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   367: aload 5
    //   369: iconst_3
    //   370: putfield 439	gnu/mapping/CallContext:pc	I
    //   373: iconst_0
    //   374: ireturn
    //   375: aload 5
    //   377: aload_2
    //   378: ldc 12
    //   380: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   383: dup
    //   384: instanceof 12
    //   387: ifeq +6 -> 393
    //   390: goto +7 -> 397
    //   393: ldc_w 428
    //   396: ireturn
    //   397: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   400: aload 5
    //   402: aload_3
    //   403: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   406: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   409: aload 5
    //   411: aload 4
    //   413: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   416: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   419: aload 5
    //   421: aload_1
    //   422: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   425: aload 5
    //   427: iconst_3
    //   428: putfield 439	gnu/mapping/CallContext:pc	I
    //   431: iconst_0
    //   432: ireturn
    //   433: aload 5
    //   435: aload_2
    //   436: ldc 12
    //   438: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   441: dup
    //   442: instanceof 12
    //   445: ifeq +6 -> 451
    //   448: goto +7 -> 455
    //   451: ldc_w 428
    //   454: ireturn
    //   455: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   458: aload 5
    //   460: aload_3
    //   461: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   464: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   467: aload 5
    //   469: aload 4
    //   471: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   474: aload 5
    //   476: aload_1
    //   477: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   480: aload 5
    //   482: iconst_3
    //   483: putfield 439	gnu/mapping/CallContext:pc	I
    //   486: iconst_0
    //   487: ireturn
    //   488: aload_0
    //   489: aload_1
    //   490: aload_2
    //   491: aload_3
    //   492: aload 4
    //   494: aload 5
    //   496: invokespecial 458	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   499: ireturn
    // Line number table:
    //   Java source line #78	-> byte code offset #72
    //   Java source line #70	-> byte code offset #127
    //   Java source line #61	-> byte code offset #201
    //   Java source line #48	-> byte code offset #259
    //   Java source line #35	-> byte code offset #317
    //   Java source line #22	-> byte code offset #375
    //   Java source line #12	-> byte code offset #433
  }
  
  /* Error */
  public int match4(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+181->185, 20:+97->101, 21:+181->185, 22:+181->185, 23:+32->36
    //   36: aload 6
    //   38: aload_2
    //   39: ldc 12
    //   41: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   44: dup
    //   45: instanceof 12
    //   48: ifeq +6 -> 54
    //   51: goto +7 -> 58
    //   54: ldc_w 428
    //   57: ireturn
    //   58: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   61: aload 6
    //   63: aload_3
    //   64: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   67: aload 6
    //   69: aload 4
    //   71: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   77: aload 6
    //   79: aload 5
    //   81: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: putfield 461	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   87: aload 6
    //   89: aload_1
    //   90: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   93: aload 6
    //   95: iconst_4
    //   96: putfield 439	gnu/mapping/CallContext:pc	I
    //   99: iconst_0
    //   100: ireturn
    //   101: aload 6
    //   103: aload_2
    //   104: ldc 12
    //   106: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   109: dup
    //   110: instanceof 12
    //   113: ifeq +6 -> 119
    //   116: goto +7 -> 123
    //   119: ldc_w 428
    //   122: ireturn
    //   123: putfield 432	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   126: aload 6
    //   128: aload_3
    //   129: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: putfield 446	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   135: aload 6
    //   137: aload 4
    //   139: ldc 12
    //   141: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   144: dup
    //   145: instanceof 12
    //   148: ifeq +6 -> 154
    //   151: goto +7 -> 158
    //   154: ldc_w 454
    //   157: ireturn
    //   158: putfield 453	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   161: aload 6
    //   163: aload 5
    //   165: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: putfield 461	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   171: aload 6
    //   173: aload_1
    //   174: putfield 436	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   177: aload 6
    //   179: iconst_4
    //   180: putfield 439	gnu/mapping/CallContext:pc	I
    //   183: iconst_0
    //   184: ireturn
    //   185: aload_0
    //   186: aload_1
    //   187: aload_2
    //   188: aload_3
    //   189: aload 4
    //   191: aload 5
    //   193: aload 6
    //   195: invokespecial 465	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   198: ireturn
    // Line number table:
    //   Java source line #78	-> byte code offset #36
    //   Java source line #70	-> byte code offset #101
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
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+215->219, 2:+68->72, 6:+83->87, 7:+106->110, 11:+129->133, 14:+152->156, 17:+175->179, 23:+198->202
    //   72: aload_2
    //   73: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: checkcast 262	java/lang/Number
    //   79: invokevirtual 263	java/lang/Number:intValue	()I
    //   82: aload_3
    //   83: invokestatic 18	kawa/lib/vectors:makeVector	(ILjava/lang/Object;)Lgnu/lists/FVector;
    //   86: areturn
    //   87: aload_2
    //   88: ldc 12
    //   90: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   93: checkcast 12	gnu/lists/FVector
    //   96: aload_3
    //   97: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 262	java/lang/Number
    //   103: invokevirtual 263	java/lang/Number:intValue	()I
    //   106: invokestatic 523	kawa/lib/vectors:vectorRef	(Lgnu/lists/FVector;I)Ljava/lang/Object;
    //   109: areturn
    //   110: aload_2
    //   111: ldc 12
    //   113: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   116: checkcast 12	gnu/lists/FVector
    //   119: aload_3
    //   120: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 262	java/lang/Number
    //   126: invokevirtual 263	java/lang/Number:intValue	()I
    //   129: invokestatic 62	kawa/lib/vectors:vector$To$List	(Lgnu/lists/FVector;I)Lgnu/lists/LList;
    //   132: areturn
    //   133: aload_2
    //   134: ldc 12
    //   136: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   139: checkcast 12	gnu/lists/FVector
    //   142: aload_3
    //   143: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   146: checkcast 262	java/lang/Number
    //   149: invokevirtual 263	java/lang/Number:intValue	()I
    //   152: invokestatic 96	kawa/lib/vectors:vector$To$String	(Lgnu/lists/FVector;I)Ljava/lang/CharSequence;
    //   155: areturn
    //   156: aload_2
    //   157: ldc -116
    //   159: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   162: checkcast 140	java/lang/CharSequence
    //   165: aload_3
    //   166: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   169: checkcast 262	java/lang/Number
    //   172: invokevirtual 263	java/lang/Number:intValue	()I
    //   175: invokestatic 138	kawa/lib/vectors:string$To$Vector	(Ljava/lang/CharSequence;I)Lgnu/lists/FVector;
    //   178: areturn
    //   179: aload_2
    //   180: ldc 12
    //   182: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   185: checkcast 12	gnu/lists/FVector
    //   188: aload_3
    //   189: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: checkcast 262	java/lang/Number
    //   195: invokevirtual 263	java/lang/Number:intValue	()I
    //   198: invokestatic 163	kawa/lib/vectors:vectorCopy	(Lgnu/lists/FVector;I)Lgnu/lists/FVector;
    //   201: areturn
    //   202: aload_2
    //   203: ldc 12
    //   205: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: checkcast 12	gnu/lists/FVector
    //   211: aload_3
    //   212: invokestatic 528	kawa/lib/vectors:vectorFill$Ex	(Lgnu/lists/FVector;Ljava/lang/Object;)V
    //   215: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   218: areturn
    //   219: aload_0
    //   220: aload_1
    //   221: aload_2
    //   222: aload_3
    //   223: invokespecial 531	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   226: areturn
    //   227: new 244	gnu/mapping/WrongType
    //   230: dup_x1
    //   231: swap
    //   232: ldc_w 490
    //   235: iconst_1
    //   236: aload_2
    //   237: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   240: athrow
    //   241: new 244	gnu/mapping/WrongType
    //   244: dup_x1
    //   245: swap
    //   246: ldc_w 345
    //   249: iconst_1
    //   250: aload_2
    //   251: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   254: athrow
    //   255: new 244	gnu/mapping/WrongType
    //   258: dup_x1
    //   259: swap
    //   260: ldc_w 345
    //   263: iconst_2
    //   264: aload_3
    //   265: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   268: athrow
    //   269: new 244	gnu/mapping/WrongType
    //   272: dup_x1
    //   273: swap
    //   274: ldc_w 492
    //   277: iconst_1
    //   278: aload_2
    //   279: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   282: athrow
    //   283: new 244	gnu/mapping/WrongType
    //   286: dup_x1
    //   287: swap
    //   288: ldc_w 492
    //   291: iconst_2
    //   292: aload_3
    //   293: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   296: athrow
    //   297: new 244	gnu/mapping/WrongType
    //   300: dup_x1
    //   301: swap
    //   302: ldc_w 503
    //   305: iconst_1
    //   306: aload_2
    //   307: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   310: athrow
    //   311: new 244	gnu/mapping/WrongType
    //   314: dup_x1
    //   315: swap
    //   316: ldc_w 503
    //   319: iconst_2
    //   320: aload_3
    //   321: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   324: athrow
    //   325: new 244	gnu/mapping/WrongType
    //   328: dup_x1
    //   329: swap
    //   330: ldc_w 508
    //   333: iconst_1
    //   334: aload_2
    //   335: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   338: athrow
    //   339: new 244	gnu/mapping/WrongType
    //   342: dup_x1
    //   343: swap
    //   344: ldc_w 508
    //   347: iconst_2
    //   348: aload_3
    //   349: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   352: athrow
    //   353: new 244	gnu/mapping/WrongType
    //   356: dup_x1
    //   357: swap
    //   358: ldc_w 513
    //   361: iconst_1
    //   362: aload_2
    //   363: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   366: athrow
    //   367: new 244	gnu/mapping/WrongType
    //   370: dup_x1
    //   371: swap
    //   372: ldc_w 513
    //   375: iconst_2
    //   376: aload_3
    //   377: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 244	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc_w 525
    //   389: iconst_1
    //   390: aload_2
    //   391: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    // Line number table:
    //   Java source line #6	-> byte code offset #72
    //   Java source line #18	-> byte code offset #87
    //   Java source line #22	-> byte code offset #110
    //   Java source line #35	-> byte code offset #133
    //   Java source line #48	-> byte code offset #156
    //   Java source line #61	-> byte code offset #179
    //   Java source line #78	-> byte code offset #202
    //   Java source line #6	-> byte code offset #227
    //   Java source line #18	-> byte code offset #241
    //   Java source line #22	-> byte code offset #269
    //   Java source line #23	-> byte code offset #283
    //   Java source line #35	-> byte code offset #297
    //   Java source line #36	-> byte code offset #311
    //   Java source line #48	-> byte code offset #325
    //   Java source line #49	-> byte code offset #339
    //   Java source line #61	-> byte code offset #353
    //   Java source line #63	-> byte code offset #367
    //   Java source line #78	-> byte code offset #381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	vectors
    //   0	395	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	395	2	paramObject1	Object
    //   0	395	3	paramObject2	Object
    //   227	1	4	localClassCastException1	ClassCastException
    //   241	1	5	localClassCastException2	ClassCastException
    //   255	1	6	localClassCastException3	ClassCastException
    //   269	1	7	localClassCastException4	ClassCastException
    //   283	1	8	localClassCastException5	ClassCastException
    //   297	1	9	localClassCastException6	ClassCastException
    //   311	1	10	localClassCastException7	ClassCastException
    //   325	1	11	localClassCastException8	ClassCastException
    //   339	1	12	localClassCastException9	ClassCastException
    //   353	1	13	localClassCastException10	ClassCastException
    //   367	1	14	localClassCastException11	ClassCastException
    //   381	1	15	localClassCastException12	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   76	82	227	java/lang/ClassCastException
    //   93	96	241	java/lang/ClassCastException
    //   100	106	255	java/lang/ClassCastException
    //   116	119	269	java/lang/ClassCastException
    //   123	129	283	java/lang/ClassCastException
    //   139	142	297	java/lang/ClassCastException
    //   146	152	311	java/lang/ClassCastException
    //   162	165	325	java/lang/ClassCastException
    //   169	175	339	java/lang/ClassCastException
    //   185	188	353	java/lang/ClassCastException
    //   192	198	367	java/lang/ClassCastException
    //   208	211	381	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+296->300, 5:+68->72, 7:+96->100, 11:+130->134, 14:+164->168, 17:+198->202, 20:+232->236, 23:+268->272
    //   72: aload_2
    //   73: ldc 12
    //   75: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   78: checkcast 12	gnu/lists/FVector
    //   81: aload_3
    //   82: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   85: checkcast 262	java/lang/Number
    //   88: invokevirtual 263	java/lang/Number:intValue	()I
    //   91: aload 4
    //   93: invokestatic 537	kawa/lib/vectors:vectorSet$Ex	(Lgnu/lists/FVector;ILjava/lang/Object;)V
    //   96: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   99: areturn
    //   100: aload_2
    //   101: ldc 12
    //   103: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   106: checkcast 12	gnu/lists/FVector
    //   109: aload_3
    //   110: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   113: checkcast 262	java/lang/Number
    //   116: invokevirtual 263	java/lang/Number:intValue	()I
    //   119: aload 4
    //   121: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   124: checkcast 262	java/lang/Number
    //   127: invokevirtual 263	java/lang/Number:intValue	()I
    //   130: invokestatic 65	kawa/lib/vectors:vector$To$List	(Lgnu/lists/FVector;II)Lgnu/lists/LList;
    //   133: areturn
    //   134: aload_2
    //   135: ldc 12
    //   137: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   140: checkcast 12	gnu/lists/FVector
    //   143: aload_3
    //   144: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 262	java/lang/Number
    //   150: invokevirtual 263	java/lang/Number:intValue	()I
    //   153: aload 4
    //   155: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   158: checkcast 262	java/lang/Number
    //   161: invokevirtual 263	java/lang/Number:intValue	()I
    //   164: invokestatic 99	kawa/lib/vectors:vector$To$String	(Lgnu/lists/FVector;II)Ljava/lang/CharSequence;
    //   167: areturn
    //   168: aload_2
    //   169: ldc -116
    //   171: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   174: checkcast 140	java/lang/CharSequence
    //   177: aload_3
    //   178: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   181: checkcast 262	java/lang/Number
    //   184: invokevirtual 263	java/lang/Number:intValue	()I
    //   187: aload 4
    //   189: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: checkcast 262	java/lang/Number
    //   195: invokevirtual 263	java/lang/Number:intValue	()I
    //   198: invokestatic 146	kawa/lib/vectors:string$To$Vector	(Ljava/lang/CharSequence;II)Lgnu/lists/FVector;
    //   201: areturn
    //   202: aload_2
    //   203: ldc 12
    //   205: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: checkcast 12	gnu/lists/FVector
    //   211: aload_3
    //   212: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   215: checkcast 262	java/lang/Number
    //   218: invokevirtual 263	java/lang/Number:intValue	()I
    //   221: aload 4
    //   223: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   226: checkcast 262	java/lang/Number
    //   229: invokevirtual 263	java/lang/Number:intValue	()I
    //   232: invokestatic 166	kawa/lib/vectors:vectorCopy	(Lgnu/lists/FVector;II)Lgnu/lists/FVector;
    //   235: areturn
    //   236: aload_2
    //   237: ldc 12
    //   239: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   242: checkcast 12	gnu/lists/FVector
    //   245: aload_3
    //   246: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   249: checkcast 262	java/lang/Number
    //   252: invokevirtual 263	java/lang/Number:intValue	()I
    //   255: aload 4
    //   257: ldc 12
    //   259: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   262: checkcast 12	gnu/lists/FVector
    //   265: invokestatic 542	kawa/lib/vectors:vectorCopy$Ex	(Lgnu/lists/FVector;ILgnu/lists/FVector;)V
    //   268: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   271: areturn
    //   272: aload_2
    //   273: ldc 12
    //   275: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   278: checkcast 12	gnu/lists/FVector
    //   281: aload_3
    //   282: aload 4
    //   284: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   287: checkcast 262	java/lang/Number
    //   290: invokevirtual 263	java/lang/Number:intValue	()I
    //   293: invokestatic 184	kawa/lib/vectors:vectorFill$Ex	(Lgnu/lists/FVector;Ljava/lang/Object;I)V
    //   296: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   299: areturn
    //   300: aload_0
    //   301: aload_1
    //   302: aload_2
    //   303: aload_3
    //   304: aload 4
    //   306: invokespecial 545	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   309: areturn
    //   310: new 244	gnu/mapping/WrongType
    //   313: dup_x1
    //   314: swap
    //   315: ldc_w 533
    //   318: iconst_1
    //   319: aload_2
    //   320: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   323: athrow
    //   324: new 244	gnu/mapping/WrongType
    //   327: dup_x1
    //   328: swap
    //   329: ldc_w 533
    //   332: iconst_2
    //   333: aload_3
    //   334: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   337: athrow
    //   338: new 244	gnu/mapping/WrongType
    //   341: dup_x1
    //   342: swap
    //   343: ldc_w 492
    //   346: iconst_1
    //   347: aload_2
    //   348: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   351: athrow
    //   352: new 244	gnu/mapping/WrongType
    //   355: dup_x1
    //   356: swap
    //   357: ldc_w 492
    //   360: iconst_2
    //   361: aload_3
    //   362: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   365: athrow
    //   366: new 244	gnu/mapping/WrongType
    //   369: dup_x1
    //   370: swap
    //   371: ldc_w 492
    //   374: iconst_3
    //   375: aload 4
    //   377: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   380: athrow
    //   381: new 244	gnu/mapping/WrongType
    //   384: dup_x1
    //   385: swap
    //   386: ldc_w 503
    //   389: iconst_1
    //   390: aload_2
    //   391: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   394: athrow
    //   395: new 244	gnu/mapping/WrongType
    //   398: dup_x1
    //   399: swap
    //   400: ldc_w 503
    //   403: iconst_2
    //   404: aload_3
    //   405: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   408: athrow
    //   409: new 244	gnu/mapping/WrongType
    //   412: dup_x1
    //   413: swap
    //   414: ldc_w 503
    //   417: iconst_3
    //   418: aload 4
    //   420: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   423: athrow
    //   424: new 244	gnu/mapping/WrongType
    //   427: dup_x1
    //   428: swap
    //   429: ldc_w 508
    //   432: iconst_1
    //   433: aload_2
    //   434: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   437: athrow
    //   438: new 244	gnu/mapping/WrongType
    //   441: dup_x1
    //   442: swap
    //   443: ldc_w 508
    //   446: iconst_2
    //   447: aload_3
    //   448: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   451: athrow
    //   452: new 244	gnu/mapping/WrongType
    //   455: dup_x1
    //   456: swap
    //   457: ldc_w 508
    //   460: iconst_3
    //   461: aload 4
    //   463: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   466: athrow
    //   467: new 244	gnu/mapping/WrongType
    //   470: dup_x1
    //   471: swap
    //   472: ldc_w 513
    //   475: iconst_1
    //   476: aload_2
    //   477: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   480: athrow
    //   481: new 244	gnu/mapping/WrongType
    //   484: dup_x1
    //   485: swap
    //   486: ldc_w 513
    //   489: iconst_2
    //   490: aload_3
    //   491: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   494: athrow
    //   495: new 244	gnu/mapping/WrongType
    //   498: dup_x1
    //   499: swap
    //   500: ldc_w 513
    //   503: iconst_3
    //   504: aload 4
    //   506: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   509: athrow
    //   510: new 244	gnu/mapping/WrongType
    //   513: dup_x1
    //   514: swap
    //   515: ldc_w 539
    //   518: iconst_1
    //   519: aload_2
    //   520: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   523: athrow
    //   524: new 244	gnu/mapping/WrongType
    //   527: dup_x1
    //   528: swap
    //   529: ldc_w 539
    //   532: iconst_2
    //   533: aload_3
    //   534: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   537: athrow
    //   538: new 244	gnu/mapping/WrongType
    //   541: dup_x1
    //   542: swap
    //   543: ldc_w 539
    //   546: iconst_3
    //   547: aload 4
    //   549: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   552: athrow
    //   553: new 244	gnu/mapping/WrongType
    //   556: dup_x1
    //   557: swap
    //   558: ldc_w 525
    //   561: iconst_1
    //   562: aload_2
    //   563: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   566: athrow
    //   567: new 244	gnu/mapping/WrongType
    //   570: dup_x1
    //   571: swap
    //   572: ldc_w 525
    //   575: iconst_3
    //   576: aload 4
    //   578: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   581: athrow
    // Line number table:
    //   Java source line #12	-> byte code offset #72
    //   Java source line #22	-> byte code offset #100
    //   Java source line #35	-> byte code offset #134
    //   Java source line #48	-> byte code offset #168
    //   Java source line #61	-> byte code offset #202
    //   Java source line #70	-> byte code offset #236
    //   Java source line #78	-> byte code offset #272
    //   Java source line #12	-> byte code offset #310
    //   Java source line #22	-> byte code offset #338
    //   Java source line #23	-> byte code offset #352
    //   Java source line #35	-> byte code offset #381
    //   Java source line #36	-> byte code offset #395
    //   Java source line #48	-> byte code offset #424
    //   Java source line #49	-> byte code offset #438
    //   Java source line #61	-> byte code offset #467
    //   Java source line #63	-> byte code offset #481
    //   Java source line #64	-> byte code offset #495
    //   Java source line #70	-> byte code offset #510
    //   Java source line #71	-> byte code offset #524
    //   Java source line #72	-> byte code offset #538
    //   Java source line #78	-> byte code offset #553
    //   Java source line #79	-> byte code offset #567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	vectors
    //   0	582	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	582	2	paramObject1	Object
    //   0	582	3	paramObject2	Object
    //   0	582	4	paramObject3	Object
    //   310	1	5	localClassCastException1	ClassCastException
    //   324	1	6	localClassCastException2	ClassCastException
    //   338	1	7	localClassCastException3	ClassCastException
    //   352	1	8	localClassCastException4	ClassCastException
    //   366	1	9	localClassCastException5	ClassCastException
    //   381	1	10	localClassCastException6	ClassCastException
    //   395	1	11	localClassCastException7	ClassCastException
    //   409	1	12	localClassCastException8	ClassCastException
    //   424	1	13	localClassCastException9	ClassCastException
    //   438	1	14	localClassCastException10	ClassCastException
    //   452	1	15	localClassCastException11	ClassCastException
    //   467	1	16	localClassCastException12	ClassCastException
    //   481	1	17	localClassCastException13	ClassCastException
    //   495	1	18	localClassCastException14	ClassCastException
    //   510	1	19	localClassCastException15	ClassCastException
    //   524	1	20	localClassCastException16	ClassCastException
    //   538	1	21	localClassCastException17	ClassCastException
    //   553	1	22	localClassCastException18	ClassCastException
    //   567	1	23	localClassCastException19	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   78	81	310	java/lang/ClassCastException
    //   85	91	324	java/lang/ClassCastException
    //   106	109	338	java/lang/ClassCastException
    //   113	119	352	java/lang/ClassCastException
    //   124	130	366	java/lang/ClassCastException
    //   140	143	381	java/lang/ClassCastException
    //   147	153	395	java/lang/ClassCastException
    //   158	164	409	java/lang/ClassCastException
    //   174	177	424	java/lang/ClassCastException
    //   181	187	438	java/lang/ClassCastException
    //   192	198	452	java/lang/ClassCastException
    //   208	211	467	java/lang/ClassCastException
    //   215	221	481	java/lang/ClassCastException
    //   226	232	495	java/lang/ClassCastException
    //   242	245	510	java/lang/ClassCastException
    //   249	255	524	java/lang/ClassCastException
    //   262	265	538	java/lang/ClassCastException
    //   278	281	553	java/lang/ClassCastException
    //   287	293	567	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+118->122, 20:+32->36, 21:+118->122, 22:+118->122, 23:+79->83
    //   36: aload_2
    //   37: ldc 12
    //   39: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   42: checkcast 12	gnu/lists/FVector
    //   45: aload_3
    //   46: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 262	java/lang/Number
    //   52: invokevirtual 263	java/lang/Number:intValue	()I
    //   55: aload 4
    //   57: ldc 12
    //   59: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: checkcast 12	gnu/lists/FVector
    //   65: aload 5
    //   67: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   70: checkcast 262	java/lang/Number
    //   73: invokevirtual 263	java/lang/Number:intValue	()I
    //   76: invokestatic 177	kawa/lib/vectors:vectorCopy$Ex	(Lgnu/lists/FVector;ILgnu/lists/FVector;I)V
    //   79: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   82: areturn
    //   83: aload_2
    //   84: ldc 12
    //   86: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   89: checkcast 12	gnu/lists/FVector
    //   92: aload_3
    //   93: aload 4
    //   95: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 262	java/lang/Number
    //   101: invokevirtual 263	java/lang/Number:intValue	()I
    //   104: aload 5
    //   106: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 262	java/lang/Number
    //   112: invokevirtual 263	java/lang/Number:intValue	()I
    //   115: invokestatic 187	kawa/lib/vectors:vectorFill$Ex	(Lgnu/lists/FVector;Ljava/lang/Object;II)V
    //   118: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   121: areturn
    //   122: aload_0
    //   123: aload_1
    //   124: aload_2
    //   125: aload_3
    //   126: aload 4
    //   128: aload 5
    //   130: invokespecial 549	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: areturn
    //   134: new 244	gnu/mapping/WrongType
    //   137: dup_x1
    //   138: swap
    //   139: ldc_w 539
    //   142: iconst_1
    //   143: aload_2
    //   144: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   147: athrow
    //   148: new 244	gnu/mapping/WrongType
    //   151: dup_x1
    //   152: swap
    //   153: ldc_w 539
    //   156: iconst_2
    //   157: aload_3
    //   158: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   161: athrow
    //   162: new 244	gnu/mapping/WrongType
    //   165: dup_x1
    //   166: swap
    //   167: ldc_w 539
    //   170: iconst_3
    //   171: aload 4
    //   173: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   176: athrow
    //   177: new 244	gnu/mapping/WrongType
    //   180: dup_x1
    //   181: swap
    //   182: ldc_w 539
    //   185: iconst_4
    //   186: aload 5
    //   188: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   191: athrow
    //   192: new 244	gnu/mapping/WrongType
    //   195: dup_x1
    //   196: swap
    //   197: ldc_w 525
    //   200: iconst_1
    //   201: aload_2
    //   202: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   205: athrow
    //   206: new 244	gnu/mapping/WrongType
    //   209: dup_x1
    //   210: swap
    //   211: ldc_w 525
    //   214: iconst_3
    //   215: aload 4
    //   217: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   220: athrow
    //   221: new 244	gnu/mapping/WrongType
    //   224: dup_x1
    //   225: swap
    //   226: ldc_w 525
    //   229: iconst_4
    //   230: aload 5
    //   232: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   235: athrow
    // Line number table:
    //   Java source line #70	-> byte code offset #36
    //   Java source line #78	-> byte code offset #83
    //   Java source line #70	-> byte code offset #134
    //   Java source line #71	-> byte code offset #148
    //   Java source line #72	-> byte code offset #162
    //   Java source line #74	-> byte code offset #177
    //   Java source line #78	-> byte code offset #192
    //   Java source line #79	-> byte code offset #206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	vectors
    //   0	236	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	236	2	paramObject1	Object
    //   0	236	3	paramObject2	Object
    //   0	236	4	paramObject3	Object
    //   0	236	5	paramObject4	Object
    //   134	1	6	localClassCastException1	ClassCastException
    //   148	1	7	localClassCastException2	ClassCastException
    //   162	1	8	localClassCastException3	ClassCastException
    //   177	1	9	localClassCastException4	ClassCastException
    //   192	1	10	localClassCastException5	ClassCastException
    //   206	1	11	localClassCastException6	ClassCastException
    //   221	1	12	localClassCastException7	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   42	45	134	java/lang/ClassCastException
    //   49	55	148	java/lang/ClassCastException
    //   62	65	162	java/lang/ClassCastException
    //   70	76	177	java/lang/ClassCastException
    //   89	92	192	java/lang/ClassCastException
    //   98	104	206	java/lang/ClassCastException
    //   109	115	221	java/lang/ClassCastException
  }
  
  /* Error */
  public Object applyN(gnu.expr.ModuleMethod arg1, Object[] arg2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 427	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+359->363, 20:+52->56, 21:+359->363, 22:+359->363, 23:+359->363, 24:+359->363, 25:+359->363, 26:+163->167, 27:+216->220, 28:+286->290
    //   56: aload_2
    //   57: arraylength
    //   58: iconst_3
    //   59: isub
    //   60: istore_3
    //   61: aload_2
    //   62: iconst_0
    //   63: aaload
    //   64: ldc 12
    //   66: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   69: dup
    //   70: astore 4
    //   72: checkcast 12	gnu/lists/FVector
    //   75: aload_2
    //   76: iconst_1
    //   77: aaload
    //   78: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: dup
    //   82: astore 4
    //   84: checkcast 262	java/lang/Number
    //   87: invokevirtual 263	java/lang/Number:intValue	()I
    //   90: aload_2
    //   91: iconst_2
    //   92: aaload
    //   93: ldc 12
    //   95: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   98: dup
    //   99: astore 4
    //   101: checkcast 12	gnu/lists/FVector
    //   104: iload_3
    //   105: ifgt +9 -> 114
    //   108: invokestatic 542	kawa/lib/vectors:vectorCopy$Ex	(Lgnu/lists/FVector;ILgnu/lists/FVector;)V
    //   111: goto +52 -> 163
    //   114: iinc 3 -1
    //   117: aload_2
    //   118: iconst_3
    //   119: aaload
    //   120: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   123: dup
    //   124: astore 4
    //   126: checkcast 262	java/lang/Number
    //   129: invokevirtual 263	java/lang/Number:intValue	()I
    //   132: iload_3
    //   133: ifgt +9 -> 142
    //   136: invokestatic 177	kawa/lib/vectors:vectorCopy$Ex	(Lgnu/lists/FVector;ILgnu/lists/FVector;I)V
    //   139: goto +24 -> 163
    //   142: iinc 3 -1
    //   145: aload_2
    //   146: iconst_4
    //   147: aaload
    //   148: invokestatic 260	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: dup
    //   152: astore 4
    //   154: checkcast 262	java/lang/Number
    //   157: invokevirtual 263	java/lang/Number:intValue	()I
    //   160: invokestatic 180	kawa/lib/vectors:vectorCopy$Ex	(Lgnu/lists/FVector;ILgnu/lists/FVector;II)V
    //   163: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   166: areturn
    //   167: aload_2
    //   168: iconst_0
    //   169: aaload
    //   170: ldc 79
    //   172: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   175: dup
    //   176: astore 4
    //   178: invokestatic 555	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   181: aload_2
    //   182: iconst_1
    //   183: aaload
    //   184: aload_2
    //   185: arraylength
    //   186: iconst_2
    //   187: isub
    //   188: istore 4
    //   190: iload 4
    //   192: anewarray 148	java/lang/Object
    //   195: goto +13 -> 208
    //   198: dup
    //   199: iload 4
    //   201: aload_2
    //   202: iload 4
    //   204: iconst_2
    //   205: iadd
    //   206: aaload
    //   207: aastore
    //   208: iinc 4 -1
    //   211: iload 4
    //   213: ifge -15 -> 198
    //   216: invokestatic 561	kawa/lib/vectors:vectorMap	(Lgnu/mapping/Procedure;Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/lists/FVector;
    //   219: areturn
    //   220: aload_2
    //   221: iconst_0
    //   222: aaload
    //   223: ldc 79
    //   225: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   228: dup
    //   229: astore 4
    //   231: invokestatic 555	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   234: aload_2
    //   235: iconst_1
    //   236: aaload
    //   237: ldc -61
    //   239: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   242: dup
    //   243: astore 4
    //   245: checkcast 195	java/util/List
    //   248: aload_2
    //   249: arraylength
    //   250: iconst_2
    //   251: isub
    //   252: istore 4
    //   254: iload 4
    //   256: anewarray 195	java/util/List
    //   259: goto +19 -> 278
    //   262: dup
    //   263: iload 4
    //   265: aload_2
    //   266: iload 4
    //   268: iconst_2
    //   269: iadd
    //   270: aaload
    //   271: dup
    //   272: astore 5
    //   274: checkcast 195	java/util/List
    //   277: aastore
    //   278: iinc 4 -1
    //   281: iload 4
    //   283: ifge -21 -> 262
    //   286: invokestatic 303	kawa/lib/vectors:lambda1vectorForEachGeneric	(Lgnu/mapping/Procedure;Ljava/util/List;[Ljava/util/List;)Ljava/lang/Object;
    //   289: areturn
    //   290: aload_2
    //   291: iconst_0
    //   292: aaload
    //   293: ldc 79
    //   295: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   298: dup
    //   299: astore 4
    //   301: invokestatic 555	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   304: aload_2
    //   305: iconst_1
    //   306: aaload
    //   307: ldc -61
    //   309: invokestatic 117	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   312: dup
    //   313: astore 4
    //   315: checkcast 195	java/util/List
    //   318: aload_2
    //   319: arraylength
    //   320: iconst_2
    //   321: isub
    //   322: istore 4
    //   324: iload 4
    //   326: anewarray 195	java/util/List
    //   329: goto +19 -> 348
    //   332: dup
    //   333: iload 4
    //   335: aload_2
    //   336: iload 4
    //   338: iconst_2
    //   339: iadd
    //   340: aaload
    //   341: dup
    //   342: astore 5
    //   344: checkcast 195	java/util/List
    //   347: aastore
    //   348: iinc 4 -1
    //   351: iload 4
    //   353: ifge -21 -> 332
    //   356: invokestatic 569	kawa/lib/vectors:vectorForEach	(Lgnu/mapping/Procedure;Ljava/util/List;[Ljava/util/List;)V
    //   359: getstatic 296	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   362: areturn
    //   363: aload_0
    //   364: aload_1
    //   365: aload_2
    //   366: invokespecial 572	gnu/expr/ModuleBody:applyN	(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    //   369: areturn
    //   370: new 244	gnu/mapping/WrongType
    //   373: dup_x1
    //   374: swap
    //   375: ldc_w 539
    //   378: iconst_1
    //   379: aload 4
    //   381: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   384: athrow
    //   385: new 244	gnu/mapping/WrongType
    //   388: dup_x1
    //   389: swap
    //   390: ldc_w 539
    //   393: iconst_2
    //   394: aload 4
    //   396: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   399: athrow
    //   400: new 244	gnu/mapping/WrongType
    //   403: dup_x1
    //   404: swap
    //   405: ldc_w 539
    //   408: iconst_3
    //   409: aload 4
    //   411: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   414: athrow
    //   415: new 244	gnu/mapping/WrongType
    //   418: dup_x1
    //   419: swap
    //   420: ldc_w 539
    //   423: iconst_4
    //   424: aload 4
    //   426: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   429: athrow
    //   430: new 244	gnu/mapping/WrongType
    //   433: dup_x1
    //   434: swap
    //   435: ldc_w 539
    //   438: iconst_5
    //   439: aload 4
    //   441: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   444: athrow
    //   445: new 244	gnu/mapping/WrongType
    //   448: dup_x1
    //   449: swap
    //   450: ldc_w 557
    //   453: iconst_1
    //   454: aload 4
    //   456: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   459: athrow
    //   460: new 244	gnu/mapping/WrongType
    //   463: dup_x1
    //   464: swap
    //   465: ldc_w 563
    //   468: iconst_1
    //   469: aload 4
    //   471: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   474: athrow
    //   475: new 244	gnu/mapping/WrongType
    //   478: dup_x1
    //   479: swap
    //   480: ldc_w 563
    //   483: iconst_2
    //   484: aload 4
    //   486: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   489: athrow
    //   490: new 244	gnu/mapping/WrongType
    //   493: dup_x1
    //   494: swap
    //   495: ldc_w 563
    //   498: iconst_0
    //   499: aload 5
    //   501: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   504: athrow
    //   505: new 244	gnu/mapping/WrongType
    //   508: dup_x1
    //   509: swap
    //   510: ldc_w 565
    //   513: iconst_1
    //   514: aload 4
    //   516: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   519: athrow
    //   520: new 244	gnu/mapping/WrongType
    //   523: dup_x1
    //   524: swap
    //   525: ldc_w 565
    //   528: iconst_2
    //   529: aload 4
    //   531: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   534: athrow
    //   535: new 244	gnu/mapping/WrongType
    //   538: dup_x1
    //   539: swap
    //   540: ldc_w 565
    //   543: iconst_0
    //   544: aload 5
    //   546: invokespecial 249	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   549: athrow
    // Line number table:
    //   Java source line #70	-> byte code offset #56
    //   Java source line #87	-> byte code offset #167
    //   Java source line #137	-> byte code offset #220
    //   Java source line #127	-> byte code offset #290
    //   Java source line #70	-> byte code offset #370
    //   Java source line #71	-> byte code offset #385
    //   Java source line #72	-> byte code offset #400
    //   Java source line #74	-> byte code offset #415
    //   Java source line #75	-> byte code offset #430
    //   Java source line #87	-> byte code offset #445
    //   Java source line #137	-> byte code offset #460
    //   Java source line #138	-> byte code offset #475
    //   Java source line #137	-> byte code offset #490
    //   Java source line #127	-> byte code offset #505
    // Exception table:
    //   from	to	target	type
    //   72	75	370	java/lang/ClassCastException
    //   84	90	385	java/lang/ClassCastException
    //   101	104	400	java/lang/ClassCastException
    //   126	132	415	java/lang/ClassCastException
    //   154	160	430	java/lang/ClassCastException
    //   178	181	445	java/lang/ClassCastException
    //   231	234	460	java/lang/ClassCastException
    //   245	248	475	java/lang/ClassCastException
    //   274	277	490	java/lang/ClassCastException
    //   301	304	505	java/lang/ClassCastException
    //   315	318	520	java/lang/ClassCastException
    //   344	347	535	java/lang/ClassCastException
  }
}
