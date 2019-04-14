package kawa.lib.rnrs; import kawa.lib.kawa.hashtable.HashTable;

public class hashtables extends gnu.expr.ModuleBody { private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  public static final gnu.expr.ModuleMethod make$Mneq$Mnhashtable;
  public static final gnu.expr.ModuleMethod make$Mneqv$Mnhashtable;
  public static final gnu.expr.ModuleMethod make$Mnhashtable;
  public static final gnu.expr.ModuleMethod hashtable$Qu;
  public static final gnu.expr.ModuleMethod hashtable$Mnsize;
  public static final gnu.expr.ModuleMethod hashtable$Mnref;
  public static final gnu.expr.ModuleMethod hashtable$Mnset$Ex;
  public static final gnu.expr.ModuleMethod hashtable$Mndelete$Ex;
  public static final gnu.expr.ModuleMethod hashtable$Mncontains$Qu;
  public static final gnu.expr.ModuleMethod hashtable$Mnupdate$Ex;
  public static final gnu.expr.ModuleMethod hashtable$Mncopy;
  public static final gnu.expr.ModuleMethod hashtable$Mnclear$Ex;
  public static final gnu.expr.ModuleMethod hashtable$Mnkeys; public static final gnu.expr.ModuleMethod hashtable$Mnentries;
  static int hashByIdentity(Object obj) { return System.identityHashCode(obj); }
  
  public static final gnu.expr.ModuleMethod hashtable$Mnequivalence$Mnfunction;
  static int hashForEqv(Object obj) { return obj.hashCode(); }
  
  public static final gnu.expr.ModuleMethod hashtable$Mnhash$Mnfunction;
  public static final gnu.expr.ModuleMethod hashtable$Mnmutable$Qu;
  public static final gnu.expr.ModuleMethod equal$Mnhash;
  public static final gnu.expr.ModuleMethod string$Mnhash;
  public static final gnu.expr.ModuleMethod string$Mnci$Mnhash;
  public int match0(gnu.expr.ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext) { switch (selector) {case 5:  proc = paramModuleMethod;pc = 0;return 0;
    case 3: 
      proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); }
  
  public static final gnu.expr.ModuleMethod symbol$Mnhash;
  public static hashtable.HashTable makeEqHashtable(int k) { return new hashtable.HashTable(kawa.standard.Scheme.isEq, hash$Mnby$Mnidentity, gnu.kawa.util.AbstractHashTable.DEFAULT_INITIAL_SIZE); }
  
  static final gnu.expr.ModuleMethod hash$Mnby$Mnidentity;
  static final gnu.expr.ModuleMethod hash$Mnfor$Mneqv;
  public static hashtables $instance;
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
  
  public Object apply0(gnu.expr.ModuleMethod paramModuleMethod)
  {
    switch (selector) {case 3:  return makeEqHashtable();
    


    case 5: 
      return makeEqvHashtable(); } return super.apply0(paramModuleMethod);
  }
  
  public static hashtable.HashTable makeEqvHashtable(int k) { return new hashtable.HashTable(kawa.standard.Scheme.isEqv, hash$Mnfor$Mneqv, gnu.kawa.util.AbstractHashTable.DEFAULT_INITIAL_SIZE); }
  
  static final gnu.mapping.SimpleSymbol Lit19;
  static final gnu.mapping.SimpleSymbol Lit20;
  static final gnu.mapping.SimpleSymbol Lit21;
  static final gnu.mapping.SimpleSymbol Lit22 = gnu.mapping.Symbol.valueOf("symbol-hash");
  public static hashtable.HashTable makeHashtable(gnu.mapping.Procedure hash$Mnfunction, gnu.mapping.Procedure comparison, int size) {
    return new hashtable.HashTable(comparison, hash$Mnfunction, size); }
  

  public static boolean isHashtable(Object obj) { return obj instanceof hashtable.HashTable; }
  

  public static int hashtableSize(hashtable.HashTable ht) { return ht.size(); }
  
  public static Object hashtableRef(hashtable.HashTable ht, Object key, Object default) {
    gnu.kawa.util.HashNode node = ht.getNode(key);
    

    return node == null ? default : node.getValue();
  }
  
  public static void hashtableSet$Ex(hashtable.HashTable ht, Object key, Object value) { kawa.lib.kawa.hashtable.hashtableCheckMutable(ht);
    ht.put(key, value);
  }
  
  public static void hashtableDelete$Ex(hashtable.HashTable ht, Object key) { kawa.lib.kawa.hashtable.hashtableCheckMutable(ht);
    ht.remove(key);
  }
  
  public static boolean isHashtableContains(hashtable.HashTable ht, Object key) { return ht.getNode(key) != null; }
  
  public static Object hashtableUpdate$Ex(hashtable.HashTable ht, Object key, gnu.mapping.Procedure proc, Object default)
  {
    kawa.lib.kawa.hashtable.hashtableCheckMutable(ht);
    gnu.kawa.util.HashNode node = ht.getNode(key);
    
    hashtableSet$Ex(ht, key, proc.apply1(default));
    return node == null ? gnu.mapping.Values.empty : node.setValue(proc.apply1(node.getValue()));
  }
  
  public static hashtable.HashTable hashtableCopy(hashtable.HashTable ht, boolean mutable) {
    return new hashtable.HashTable(ht, mutable);
  }
  

  public static void hashtableClear$Ex(hashtable.HashTable ht, int k)
  {
    kawa.lib.kawa.hashtable.hashtableCheckMutable(ht);
    ht.clear();
  }
  
  public static gnu.lists.FVector hashtableKeys(hashtable.HashTable ht) { return ht.keysVector(); }
  
  public static gnu.mapping.Values hashtableEntries(hashtable.HashTable ht) {
    gnu.lists.Pair pair = ht.entriesVectorPair();
    return gnu.mapping.Values.values2(kawa.lib.lists.car(pair), kawa.lib.lists.cdr(pair));
  }
  
  public static gnu.mapping.Procedure hashtableEquivalenceFunction(hashtable.HashTable ht) { return equivalenceFunction; }
  
  public static Object hashtableHashFunction(hashtable.HashTable ht) {
    Object hasher = hashFunction.apply1(ht);
    boolean x = gnu.kawa.functions.IsEqv.apply(hasher, hash$Mnby$Mnidentity);return x ? x : 
      gnu.kawa.functions.IsEqv.apply(hasher, hash$Mnfor$Mneqv) ? Boolean.FALSE : hasher;
  }
  

  public static boolean isHashtableMutable(hashtable.HashTable ht)
  {
    return mutable;
  }
  
  public static int equalHash(Object key) { return gnu.kawa.util.HashUtils.boundedHash(key); }
  
  public static int stringHash(CharSequence s) {
    return s.hashCode();
  }
  


  public static int stringCiHash(CharSequence s)
  {
    return s.toString().toLowerCase().hashCode();
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {case 1:  return Integer.valueOf(hashByIdentity(paramObject));
    
    case 2: 
      return Integer.valueOf(hashForEqv(paramObject));
    }
    try {
      return makeEqHashtable(((Number)gnu.mapping.Promise.force(paramObject)).intValue());
    } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      

























































































        localClassCastException1, "make-eq-hashtable", 1, paramObject);
    }
    try
    {
      return makeEqvHashtable(((Number)gnu.mapping.Promise.force(paramObject)).intValue());
    } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "make-eqv-hashtable", 1, paramObject);
    }
    








    return isHashtable(paramObject) ? Boolean.TRUE : Boolean.FALSE;
    for (;;) {
      try {
        return Integer.valueOf(hashtableSize((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class))); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "hashtable-size", 1, paramObject);
      }
      























      try
      {
        return hashtableCopy((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "hashtable-copy", 1, paramObject);
      }
      try
      {
        hashtableClear$Ex((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class));return gnu.mapping.Values.empty;
      } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "hashtable-clear!", 1, paramObject);
      }
      

      try
      {
        return hashtableKeys((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "hashtable-keys", 1, paramObject);
      }
      try {
        return hashtableEntries((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "hashtable-entries", 1, paramObject);
      }
      try
      {
        return hashtableEquivalenceFunction((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "hashtable-equivalence-function", 1, paramObject);
      }
      try {
        return hashtableHashFunction((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException9) { throw new gnu.mapping.WrongType(localClassCastException9, "hashtable-hash-function", 1, paramObject);
      }
      


      try
      {
        return isHashtableMutable((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)) ? Boolean.TRUE : Boolean.FALSE; } catch (ClassCastException localClassCastException10) { throw new gnu.mapping.WrongType(localClassCastException10, "hashtable-mutable?", 1, paramObject);
      }
    }
    return Integer.valueOf(equalHash(paramObject));
    try
    {
      return Integer.valueOf(stringHash((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class))); } catch (ClassCastException localClassCastException11) { throw new gnu.mapping.WrongType(localClassCastException11, "string-hash", 1, paramObject);
    }
    try {
      return Integer.valueOf(stringCiHash((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class))); } catch (ClassCastException localClassCastException12) { throw new gnu.mapping.WrongType(localClassCastException12, "string-ci-hash", 1, paramObject);
    }
    


    try
    {
      return Integer.valueOf(symbolHash((gnu.mapping.Symbol)gnu.mapping.Promise.force(paramObject, gnu.mapping.Symbol.class))); } catch (ClassCastException localClassCastException13) { throw new gnu.mapping.WrongType(localClassCastException13, "symbol-hash", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static int symbolHash(gnu.mapping.Symbol s) { return s.hashCode(); }
  
  public static hashtable.HashTable makeEqHashtable()
  {
    return makeEqHashtable(gnu.kawa.util.AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }
  
  public static hashtable.HashTable makeEqvHashtable()
  {
    return makeEqvHashtable(gnu.kawa.util.AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }
  
  public static hashtable.HashTable makeHashtable(gnu.mapping.Procedure paramProcedure1, gnu.mapping.Procedure paramProcedure2)
  {
    return makeHashtable(paramProcedure1, paramProcedure2, gnu.kawa.util.AbstractHashTable.DEFAULT_INITIAL_SIZE);
  }
  
  public static hashtable.HashTable hashtableCopy(hashtable.HashTable paramHashTable)
  {
    return hashtableCopy(paramHashTable, false);
  }
  
  public static void hashtableClear$Ex(hashtable.HashTable paramHashTable)
  {
    hashtableClear$Ex(paramHashTable, 64);
  }
  
  static
  {
    Lit21 = gnu.mapping.Symbol.valueOf("string-ci-hash");
    Lit20 = gnu.mapping.Symbol.valueOf("string-hash");
    Lit19 = gnu.mapping.Symbol.valueOf("equal-hash");
    Lit18 = gnu.mapping.Symbol.valueOf("hashtable-mutable?");
    Lit17 = gnu.mapping.Symbol.valueOf("hashtable-hash-function");
    Lit16 = gnu.mapping.Symbol.valueOf("hashtable-equivalence-function");
    Lit15 = gnu.mapping.Symbol.valueOf("hashtable-entries");
    Lit14 = gnu.mapping.Symbol.valueOf("hashtable-keys");
    Lit13 = gnu.mapping.Symbol.valueOf("hashtable-clear!");
    Lit12 = gnu.mapping.Symbol.valueOf("hashtable-copy");
    Lit11 = gnu.mapping.Symbol.valueOf("hashtable-update!");
    Lit10 = gnu.mapping.Symbol.valueOf("hashtable-contains?");
    Lit9 = gnu.mapping.Symbol.valueOf("hashtable-delete!");
    Lit8 = gnu.mapping.Symbol.valueOf("hashtable-set!");
    Lit7 = gnu.mapping.Symbol.valueOf("hashtable-ref");
    Lit6 = gnu.mapping.Symbol.valueOf("hashtable-size");
    Lit5 = gnu.mapping.Symbol.valueOf("hashtable?");
    Lit4 = gnu.mapping.Symbol.valueOf("make-hashtable");
    Lit3 = gnu.mapping.Symbol.valueOf("make-eqv-hashtable");
    Lit2 = gnu.mapping.Symbol.valueOf("make-eq-hashtable");
    Lit1 = gnu.mapping.Symbol.valueOf("hash-for-eqv");
    Lit0 = gnu.mapping.Symbol.valueOf("hash-by-identity");
    $instance = new hashtables();
    hashtables localHashtables = $instance;
    hash$Mnby$Mnidentity = new gnu.expr.ModuleMethod(localHashtables, 1, Lit0, 4097);
    hash$Mnfor$Mneqv = new gnu.expr.ModuleMethod(localHashtables, 2, Lit1, 4097);
    make$Mneq$Mnhashtable = new gnu.expr.ModuleMethod(localHashtables, 3, Lit2, 4096);
    make$Mneqv$Mnhashtable = new gnu.expr.ModuleMethod(localHashtables, 5, Lit3, 4096);
    make$Mnhashtable = new gnu.expr.ModuleMethod(localHashtables, 7, Lit4, 12290);
    hashtable$Qu = new gnu.expr.ModuleMethod(localHashtables, 9, Lit5, 4097);
    hashtable$Mnsize = new gnu.expr.ModuleMethod(localHashtables, 10, Lit6, 4097);
    hashtable$Mnref = new gnu.expr.ModuleMethod(localHashtables, 11, Lit7, 12291);
    hashtable$Mnset$Ex = new gnu.expr.ModuleMethod(localHashtables, 12, Lit8, 12291);
    hashtable$Mndelete$Ex = new gnu.expr.ModuleMethod(localHashtables, 13, Lit9, 8194);
    hashtable$Mncontains$Qu = new gnu.expr.ModuleMethod(localHashtables, 14, Lit10, 8194);
    hashtable$Mnupdate$Ex = new gnu.expr.ModuleMethod(localHashtables, 15, Lit11, 16388);
    hashtable$Mncopy = new gnu.expr.ModuleMethod(localHashtables, 16, Lit12, 8193);
    hashtable$Mnclear$Ex = new gnu.expr.ModuleMethod(localHashtables, 18, Lit13, 8193);
    hashtable$Mnkeys = new gnu.expr.ModuleMethod(localHashtables, 20, Lit14, 4097);
    hashtable$Mnentries = new gnu.expr.ModuleMethod(localHashtables, 21, Lit15, 4097);
    hashtable$Mnequivalence$Mnfunction = new gnu.expr.ModuleMethod(localHashtables, 22, Lit16, 4097);
    hashtable$Mnhash$Mnfunction = new gnu.expr.ModuleMethod(localHashtables, 23, Lit17, 4097);
    hashtable$Mnmutable$Qu = new gnu.expr.ModuleMethod(localHashtables, 24, Lit18, 4097);
    equal$Mnhash = new gnu.expr.ModuleMethod(localHashtables, 25, Lit19, 4097);
    string$Mnhash = new gnu.expr.ModuleMethod(localHashtables, 26, Lit20, 4097);
    string$Mnci$Mnhash = new gnu.expr.ModuleMethod(localHashtables, 27, Lit21, 4097);
    symbol$Mnhash = new gnu.expr.ModuleMethod(localHashtables, 28, Lit22, 4097);
    $runBody$();
  }
  
  public hashtables()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 347	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+605->609, 1:+588->592, 2:+571->575, 3:+551->555, 4:+605->609, 5:+531->535, 6:+605->609, 7:+605->609, 8:+605->609, 9:+514->518, 10:+481->485, 11:+605->609, 12:+605->609, 13:+605->609, 14:+605->609, 15:+605->609, 16:+448->452, 17:+605->609, 18:+415->419, 19:+605->609, 20:+382->386, 21:+349->353, 22:+316->320, 23:+283->287, 24:+250->254, 25:+233->237, 26:+197->201, 27:+161->165, 28:+128->132
    //   132: aload_3
    //   133: aload_2
    //   134: ldc -69
    //   136: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   139: dup
    //   140: instanceof 187
    //   143: ifne +7 -> 150
    //   146: ldc_w 364
    //   149: ireturn
    //   150: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   153: aload_3
    //   154: aload_1
    //   155: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   158: aload_3
    //   159: iconst_1
    //   160: putfield 353	gnu/mapping/CallContext:pc	I
    //   163: iconst_0
    //   164: ireturn
    //   165: aload_3
    //   166: aload_2
    //   167: ldc -81
    //   169: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   172: dup
    //   173: instanceof 175
    //   176: ifeq +6 -> 182
    //   179: goto +7 -> 186
    //   182: ldc_w 364
    //   185: ireturn
    //   186: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   189: aload_3
    //   190: aload_1
    //   191: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   194: aload_3
    //   195: iconst_1
    //   196: putfield 353	gnu/mapping/CallContext:pc	I
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_3
    //   202: aload_2
    //   203: ldc -81
    //   205: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   208: dup
    //   209: instanceof 175
    //   212: ifeq +6 -> 218
    //   215: goto +7 -> 222
    //   218: ldc_w 364
    //   221: ireturn
    //   222: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   225: aload_3
    //   226: aload_1
    //   227: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   230: aload_3
    //   231: iconst_1
    //   232: putfield 353	gnu/mapping/CallContext:pc	I
    //   235: iconst_0
    //   236: ireturn
    //   237: aload_3
    //   238: aload_2
    //   239: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   242: aload_3
    //   243: aload_1
    //   244: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   247: aload_3
    //   248: iconst_1
    //   249: putfield 353	gnu/mapping/CallContext:pc	I
    //   252: iconst_0
    //   253: ireturn
    //   254: aload_3
    //   255: aload_2
    //   256: ldc 36
    //   258: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   261: dup
    //   262: instanceof 36
    //   265: ifne +7 -> 272
    //   268: ldc_w 364
    //   271: ireturn
    //   272: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   275: aload_3
    //   276: aload_1
    //   277: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   280: aload_3
    //   281: iconst_1
    //   282: putfield 353	gnu/mapping/CallContext:pc	I
    //   285: iconst_0
    //   286: ireturn
    //   287: aload_3
    //   288: aload_2
    //   289: ldc 36
    //   291: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   294: dup
    //   295: instanceof 36
    //   298: ifne +7 -> 305
    //   301: ldc_w 364
    //   304: ireturn
    //   305: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   308: aload_3
    //   309: aload_1
    //   310: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   313: aload_3
    //   314: iconst_1
    //   315: putfield 353	gnu/mapping/CallContext:pc	I
    //   318: iconst_0
    //   319: ireturn
    //   320: aload_3
    //   321: aload_2
    //   322: ldc 36
    //   324: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   327: dup
    //   328: instanceof 36
    //   331: ifne +7 -> 338
    //   334: ldc_w 364
    //   337: ireturn
    //   338: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   341: aload_3
    //   342: aload_1
    //   343: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   346: aload_3
    //   347: iconst_1
    //   348: putfield 353	gnu/mapping/CallContext:pc	I
    //   351: iconst_0
    //   352: ireturn
    //   353: aload_3
    //   354: aload_2
    //   355: ldc 36
    //   357: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   360: dup
    //   361: instanceof 36
    //   364: ifne +7 -> 371
    //   367: ldc_w 364
    //   370: ireturn
    //   371: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   374: aload_3
    //   375: aload_1
    //   376: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   379: aload_3
    //   380: iconst_1
    //   381: putfield 353	gnu/mapping/CallContext:pc	I
    //   384: iconst_0
    //   385: ireturn
    //   386: aload_3
    //   387: aload_2
    //   388: ldc 36
    //   390: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   393: dup
    //   394: instanceof 36
    //   397: ifne +7 -> 404
    //   400: ldc_w 364
    //   403: ireturn
    //   404: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   407: aload_3
    //   408: aload_1
    //   409: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   412: aload_3
    //   413: iconst_1
    //   414: putfield 353	gnu/mapping/CallContext:pc	I
    //   417: iconst_0
    //   418: ireturn
    //   419: aload_3
    //   420: aload_2
    //   421: ldc 36
    //   423: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   426: dup
    //   427: instanceof 36
    //   430: ifne +7 -> 437
    //   433: ldc_w 364
    //   436: ireturn
    //   437: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   440: aload_3
    //   441: aload_1
    //   442: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   445: aload_3
    //   446: iconst_1
    //   447: putfield 353	gnu/mapping/CallContext:pc	I
    //   450: iconst_0
    //   451: ireturn
    //   452: aload_3
    //   453: aload_2
    //   454: ldc 36
    //   456: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   459: dup
    //   460: instanceof 36
    //   463: ifne +7 -> 470
    //   466: ldc_w 364
    //   469: ireturn
    //   470: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   473: aload_3
    //   474: aload_1
    //   475: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   478: aload_3
    //   479: iconst_1
    //   480: putfield 353	gnu/mapping/CallContext:pc	I
    //   483: iconst_0
    //   484: ireturn
    //   485: aload_3
    //   486: aload_2
    //   487: ldc 36
    //   489: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   492: dup
    //   493: instanceof 36
    //   496: ifne +7 -> 503
    //   499: ldc_w 364
    //   502: ireturn
    //   503: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   506: aload_3
    //   507: aload_1
    //   508: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   511: aload_3
    //   512: iconst_1
    //   513: putfield 353	gnu/mapping/CallContext:pc	I
    //   516: iconst_0
    //   517: ireturn
    //   518: aload_3
    //   519: aload_2
    //   520: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   523: aload_3
    //   524: aload_1
    //   525: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   528: aload_3
    //   529: iconst_1
    //   530: putfield 353	gnu/mapping/CallContext:pc	I
    //   533: iconst_0
    //   534: ireturn
    //   535: aload_3
    //   536: aload_2
    //   537: invokestatic 370	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   540: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   543: aload_3
    //   544: aload_1
    //   545: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   548: aload_3
    //   549: iconst_1
    //   550: putfield 353	gnu/mapping/CallContext:pc	I
    //   553: iconst_0
    //   554: ireturn
    //   555: aload_3
    //   556: aload_2
    //   557: invokestatic 370	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   560: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   563: aload_3
    //   564: aload_1
    //   565: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   568: aload_3
    //   569: iconst_1
    //   570: putfield 353	gnu/mapping/CallContext:pc	I
    //   573: iconst_0
    //   574: ireturn
    //   575: aload_3
    //   576: aload_2
    //   577: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   580: aload_3
    //   581: aload_1
    //   582: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   585: aload_3
    //   586: iconst_1
    //   587: putfield 353	gnu/mapping/CallContext:pc	I
    //   590: iconst_0
    //   591: ireturn
    //   592: aload_3
    //   593: aload_2
    //   594: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   597: aload_3
    //   598: aload_1
    //   599: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   602: aload_3
    //   603: iconst_1
    //   604: putfield 353	gnu/mapping/CallContext:pc	I
    //   607: iconst_0
    //   608: ireturn
    //   609: aload_0
    //   610: aload_1
    //   611: aload_2
    //   612: aload_3
    //   613: invokespecial 374	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   616: ireturn
    // Line number table:
    //   Java source line #113	-> byte code offset #132
    //   Java source line #106	-> byte code offset #165
    //   Java source line #103	-> byte code offset #201
    //   Java source line #100	-> byte code offset #237
    //   Java source line #97	-> byte code offset #254
    //   Java source line #90	-> byte code offset #287
    //   Java source line #87	-> byte code offset #320
    //   Java source line #83	-> byte code offset #353
    //   Java source line #80	-> byte code offset #386
    //   Java source line #73	-> byte code offset #419
    //   Java source line #69	-> byte code offset #452
    //   Java source line #41	-> byte code offset #485
    //   Java source line #38	-> byte code offset #518
    //   Java source line #26	-> byte code offset #535
    //   Java source line #21	-> byte code offset #555
    //   Java source line #18	-> byte code offset #575
    //   Java source line #15	-> byte code offset #592
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 347	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+304->308, 7:+240->244, 13:+198->202, 14:+156->160, 16:+97->101, 18:+52->56
    //   56: aload 4
    //   58: aload_2
    //   59: ldc 36
    //   61: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   64: dup
    //   65: instanceof 36
    //   68: ifne +7 -> 75
    //   71: ldc_w 364
    //   74: ireturn
    //   75: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   78: aload 4
    //   80: aload_3
    //   81: invokestatic 370	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   87: aload 4
    //   89: aload_1
    //   90: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   93: aload 4
    //   95: iconst_2
    //   96: putfield 353	gnu/mapping/CallContext:pc	I
    //   99: iconst_0
    //   100: ireturn
    //   101: aload 4
    //   103: aload_2
    //   104: ldc 36
    //   106: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   109: dup
    //   110: instanceof 36
    //   113: ifne +7 -> 120
    //   116: ldc_w 364
    //   119: ireturn
    //   120: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   123: aload 4
    //   125: aload_3
    //   126: invokestatic 370	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   129: dup
    //   130: instanceof 160
    //   133: ifeq +6 -> 139
    //   136: goto +7 -> 143
    //   139: ldc_w 378
    //   142: ireturn
    //   143: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   146: aload 4
    //   148: aload_1
    //   149: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   152: aload 4
    //   154: iconst_2
    //   155: putfield 353	gnu/mapping/CallContext:pc	I
    //   158: iconst_0
    //   159: ireturn
    //   160: aload 4
    //   162: aload_2
    //   163: ldc 36
    //   165: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   168: dup
    //   169: instanceof 36
    //   172: ifne +7 -> 179
    //   175: ldc_w 364
    //   178: ireturn
    //   179: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   182: aload 4
    //   184: aload_3
    //   185: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   188: aload 4
    //   190: aload_1
    //   191: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   194: aload 4
    //   196: iconst_2
    //   197: putfield 353	gnu/mapping/CallContext:pc	I
    //   200: iconst_0
    //   201: ireturn
    //   202: aload 4
    //   204: aload_2
    //   205: ldc 36
    //   207: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   210: dup
    //   211: instanceof 36
    //   214: ifne +7 -> 221
    //   217: ldc_w 364
    //   220: ireturn
    //   221: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   224: aload 4
    //   226: aload_3
    //   227: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   230: aload 4
    //   232: aload_1
    //   233: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   236: aload 4
    //   238: iconst_2
    //   239: putfield 353	gnu/mapping/CallContext:pc	I
    //   242: iconst_0
    //   243: ireturn
    //   244: aload 4
    //   246: aload_2
    //   247: ldc 93
    //   249: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   252: dup
    //   253: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   256: ifnull +6 -> 262
    //   259: goto +7 -> 266
    //   262: ldc_w 364
    //   265: ireturn
    //   266: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   269: aload 4
    //   271: aload_3
    //   272: ldc 93
    //   274: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   277: dup
    //   278: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   281: ifnull +6 -> 287
    //   284: goto +7 -> 291
    //   287: ldc_w 378
    //   290: ireturn
    //   291: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   294: aload 4
    //   296: aload_1
    //   297: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   300: aload 4
    //   302: iconst_2
    //   303: putfield 353	gnu/mapping/CallContext:pc	I
    //   306: iconst_0
    //   307: ireturn
    //   308: aload_0
    //   309: aload_1
    //   310: aload_2
    //   311: aload_3
    //   312: aload 4
    //   314: invokespecial 388	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   317: ireturn
    // Line number table:
    //   Java source line #73	-> byte code offset #56
    //   Java source line #69	-> byte code offset #101
    //   Java source line #58	-> byte code offset #160
    //   Java source line #54	-> byte code offset #202
    //   Java source line #31	-> byte code offset #244
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 347	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+212->216, 7:+138->142, 8:+212->216, 9:+212->216, 10:+212->216, 11:+89->93, 12:+40->44
    //   44: aload 5
    //   46: aload_2
    //   47: ldc 36
    //   49: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   52: dup
    //   53: instanceof 36
    //   56: ifne +7 -> 63
    //   59: ldc_w 364
    //   62: ireturn
    //   63: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   66: aload 5
    //   68: aload_3
    //   69: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   72: aload 5
    //   74: aload 4
    //   76: putfield 391	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   79: aload 5
    //   81: aload_1
    //   82: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   85: aload 5
    //   87: iconst_3
    //   88: putfield 353	gnu/mapping/CallContext:pc	I
    //   91: iconst_0
    //   92: ireturn
    //   93: aload 5
    //   95: aload_2
    //   96: ldc 36
    //   98: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   101: dup
    //   102: instanceof 36
    //   105: ifne +7 -> 112
    //   108: ldc_w 364
    //   111: ireturn
    //   112: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   115: aload 5
    //   117: aload_3
    //   118: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   121: aload 5
    //   123: aload 4
    //   125: putfield 391	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   128: aload 5
    //   130: aload_1
    //   131: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   134: aload 5
    //   136: iconst_3
    //   137: putfield 353	gnu/mapping/CallContext:pc	I
    //   140: iconst_0
    //   141: ireturn
    //   142: aload 5
    //   144: aload_2
    //   145: ldc 93
    //   147: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   150: dup
    //   151: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   154: ifnull +6 -> 160
    //   157: goto +7 -> 164
    //   160: ldc_w 364
    //   163: ireturn
    //   164: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   167: aload 5
    //   169: aload_3
    //   170: ldc 93
    //   172: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   175: dup
    //   176: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   179: ifnull +6 -> 185
    //   182: goto +7 -> 189
    //   185: ldc_w 378
    //   188: ireturn
    //   189: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   192: aload 5
    //   194: aload 4
    //   196: invokestatic 370	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   199: putfield 391	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   202: aload 5
    //   204: aload_1
    //   205: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   208: aload 5
    //   210: iconst_3
    //   211: putfield 353	gnu/mapping/CallContext:pc	I
    //   214: iconst_0
    //   215: ireturn
    //   216: aload_0
    //   217: aload_1
    //   218: aload_2
    //   219: aload_3
    //   220: aload 4
    //   222: aload 5
    //   224: invokespecial 395	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   227: ireturn
    // Line number table:
    //   Java source line #50	-> byte code offset #44
    //   Java source line #44	-> byte code offset #93
    //   Java source line #31	-> byte code offset #142
  }
  
  /* Error */
  public int match4(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, Object arg5, gnu.mapping.CallContext arg6)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 347	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 15
    //   6: if_icmpne +81 -> 87
    //   9: goto +3 -> 12
    //   12: aload 6
    //   14: aload_2
    //   15: ldc 36
    //   17: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   20: dup
    //   21: instanceof 36
    //   24: ifne +7 -> 31
    //   27: ldc_w 364
    //   30: ireturn
    //   31: putfield 368	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   34: aload 6
    //   36: aload_3
    //   37: putfield 377	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   40: aload 6
    //   42: aload 4
    //   44: ldc 93
    //   46: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   49: dup
    //   50: invokestatic 384	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   53: ifnull +6 -> 59
    //   56: goto +7 -> 63
    //   59: ldc_w 396
    //   62: ireturn
    //   63: putfield 391	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   66: aload 6
    //   68: aload 5
    //   70: putfield 399	gnu/mapping/CallContext:value4	Ljava/lang/Object;
    //   73: aload 6
    //   75: aload_1
    //   76: putfield 350	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   79: aload 6
    //   81: iconst_4
    //   82: putfield 353	gnu/mapping/CallContext:pc	I
    //   85: iconst_0
    //   86: ireturn
    //   87: aload_0
    //   88: aload_1
    //   89: aload_2
    //   90: aload_3
    //   91: aload 4
    //   93: aload 5
    //   95: aload 6
    //   97: invokespecial 403	gnu/expr/ModuleBody:match4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   100: ireturn
    // Line number table:
    //   Java source line #61	-> byte code offset #12
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
    //   1: getfield 347	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+171->175, 7:+52->56, 13:+74->78, 14:+91->95, 16:+117->121, 18:+145->149
    //   56: aload_2
    //   57: ldc 93
    //   59: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   62: invokestatic 521	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   65: aload_3
    //   66: ldc 93
    //   68: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   71: invokestatic 521	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   74: invokestatic 526	kawa/lib/rnrs/hashtables:makeHashtable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
    //   77: areturn
    //   78: aload_2
    //   79: ldc 36
    //   81: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   84: checkcast 36	kawa/lib/kawa/hashtable$HashTable
    //   87: aload_3
    //   88: invokestatic 532	kawa/lib/rnrs/hashtables:hashtableDelete$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)V
    //   91: getstatic 106	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   94: areturn
    //   95: aload_2
    //   96: ldc 36
    //   98: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   101: checkcast 36	kawa/lib/kawa/hashtable$HashTable
    //   104: aload_3
    //   105: invokestatic 538	kawa/lib/rnrs/hashtables:isHashtableContains	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Z
    //   108: ifeq +9 -> 117
    //   111: getstatic 450	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   114: goto +6 -> 120
    //   117: getstatic 164	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   120: areturn
    //   121: aload_2
    //   122: ldc 36
    //   124: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   127: checkcast 36	kawa/lib/kawa/hashtable$HashTable
    //   130: aload_3
    //   131: invokestatic 370	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: invokestatic 543	gnu/expr/KawaConvert:isTrue	(Ljava/lang/Object;)Z
    //   137: ifeq +7 -> 144
    //   140: iconst_1
    //   141: goto +4 -> 145
    //   144: iconst_0
    //   145: invokestatic 113	kawa/lib/rnrs/hashtables:hashtableCopy	(Lkawa/lib/kawa/hashtable$HashTable;Z)Lkawa/lib/kawa/hashtable$HashTable;
    //   148: areturn
    //   149: aload_2
    //   150: ldc 36
    //   152: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   155: checkcast 36	kawa/lib/kawa/hashtable$HashTable
    //   158: aload_3
    //   159: invokestatic 370	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   162: checkcast 429	java/lang/Number
    //   165: invokevirtual 432	java/lang/Number:intValue	()I
    //   168: invokestatic 120	kawa/lib/rnrs/hashtables:hashtableClear$Ex	(Lkawa/lib/kawa/hashtable$HashTable;I)V
    //   171: getstatic 106	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   174: areturn
    //   175: aload_0
    //   176: aload_1
    //   177: aload_2
    //   178: aload_3
    //   179: invokespecial 547	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: areturn
    //   183: new 436	gnu/mapping/WrongType
    //   186: dup_x1
    //   187: swap
    //   188: ldc_w 523
    //   191: iconst_1
    //   192: aload_2
    //   193: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   196: athrow
    //   197: new 436	gnu/mapping/WrongType
    //   200: dup_x1
    //   201: swap
    //   202: ldc_w 523
    //   205: iconst_2
    //   206: aload_3
    //   207: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   210: athrow
    //   211: new 436	gnu/mapping/WrongType
    //   214: dup_x1
    //   215: swap
    //   216: ldc_w 528
    //   219: iconst_1
    //   220: aload_2
    //   221: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   224: athrow
    //   225: new 436	gnu/mapping/WrongType
    //   228: dup_x1
    //   229: swap
    //   230: ldc_w 534
    //   233: iconst_1
    //   234: aload_2
    //   235: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   238: athrow
    //   239: new 436	gnu/mapping/WrongType
    //   242: dup_x1
    //   243: swap
    //   244: ldc_w 458
    //   247: iconst_1
    //   248: aload_2
    //   249: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   252: athrow
    //   253: new 436	gnu/mapping/WrongType
    //   256: dup_x1
    //   257: swap
    //   258: ldc_w 458
    //   261: iconst_2
    //   262: aload_3
    //   263: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    //   267: new 436	gnu/mapping/WrongType
    //   270: dup_x1
    //   271: swap
    //   272: ldc_w 463
    //   275: iconst_1
    //   276: aload_2
    //   277: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: new 436	gnu/mapping/WrongType
    //   284: dup_x1
    //   285: swap
    //   286: ldc_w 463
    //   289: iconst_2
    //   290: aload_3
    //   291: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   294: athrow
    // Line number table:
    //   Java source line #31	-> byte code offset #56
    //   Java source line #54	-> byte code offset #78
    //   Java source line #58	-> byte code offset #95
    //   Java source line #69	-> byte code offset #121
    //   Java source line #73	-> byte code offset #149
    //   Java source line #32	-> byte code offset #183
    //   Java source line #33	-> byte code offset #197
    //   Java source line #54	-> byte code offset #211
    //   Java source line #58	-> byte code offset #225
    //   Java source line #69	-> byte code offset #239
    //   Java source line #74	-> byte code offset #267
    //   Java source line #75	-> byte code offset #281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	hashtables
    //   0	295	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	295	2	paramObject1	Object
    //   0	295	3	paramObject2	Object
    //   183	1	4	localClassCastException1	ClassCastException
    //   197	1	5	localClassCastException2	ClassCastException
    //   211	1	6	localClassCastException3	ClassCastException
    //   225	1	7	localClassCastException4	ClassCastException
    //   239	1	8	localClassCastException5	ClassCastException
    //   253	1	9	localClassCastException6	ClassCastException
    //   267	1	10	localClassCastException7	ClassCastException
    //   281	1	11	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   62	65	183	java/lang/ClassCastException
    //   71	74	197	java/lang/ClassCastException
    //   84	87	211	java/lang/ClassCastException
    //   101	104	225	java/lang/ClassCastException
    //   127	130	239	java/lang/ClassCastException
    //   134	145	253	java/lang/ClassCastException
    //   155	158	267	java/lang/ClassCastException
    //   162	168	281	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 347	gnu/expr/ModuleMethod:selector	I
    //   4: tableswitch	default:+108->112, 7:+40->44, 8:+108->112, 9:+108->112, 10:+108->112, 11:+73->77, 12:+89->93
    //   44: aload_2
    //   45: ldc 93
    //   47: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   50: invokestatic 521	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   53: aload_3
    //   54: ldc 93
    //   56: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   59: invokestatic 521	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   62: aload 4
    //   64: invokestatic 370	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 429	java/lang/Number
    //   70: invokevirtual 432	java/lang/Number:intValue	()I
    //   73: invokestatic 64	kawa/lib/rnrs/hashtables:makeHashtable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
    //   76: areturn
    //   77: aload_2
    //   78: ldc 36
    //   80: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   83: checkcast 36	kawa/lib/kawa/hashtable$HashTable
    //   86: aload_3
    //   87: aload 4
    //   89: invokestatic 553	kawa/lib/rnrs/hashtables:hashtableRef	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: areturn
    //   93: aload_2
    //   94: ldc 36
    //   96: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   99: checkcast 36	kawa/lib/kawa/hashtable$HashTable
    //   102: aload_3
    //   103: aload 4
    //   105: invokestatic 100	kawa/lib/rnrs/hashtables:hashtableSet$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)V
    //   108: getstatic 106	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   111: areturn
    //   112: aload_0
    //   113: aload_1
    //   114: aload_2
    //   115: aload_3
    //   116: aload 4
    //   118: invokespecial 559	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   121: areturn
    //   122: new 436	gnu/mapping/WrongType
    //   125: dup_x1
    //   126: swap
    //   127: ldc_w 523
    //   130: iconst_1
    //   131: aload_2
    //   132: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   135: athrow
    //   136: new 436	gnu/mapping/WrongType
    //   139: dup_x1
    //   140: swap
    //   141: ldc_w 523
    //   144: iconst_2
    //   145: aload_3
    //   146: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   149: athrow
    //   150: new 436	gnu/mapping/WrongType
    //   153: dup_x1
    //   154: swap
    //   155: ldc_w 523
    //   158: iconst_3
    //   159: aload 4
    //   161: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   164: athrow
    //   165: new 436	gnu/mapping/WrongType
    //   168: dup_x1
    //   169: swap
    //   170: ldc_w 549
    //   173: iconst_1
    //   174: aload_2
    //   175: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   178: athrow
    //   179: new 436	gnu/mapping/WrongType
    //   182: dup_x1
    //   183: swap
    //   184: ldc_w 555
    //   187: iconst_1
    //   188: aload_2
    //   189: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   192: athrow
    // Line number table:
    //   Java source line #31	-> byte code offset #44
    //   Java source line #44	-> byte code offset #77
    //   Java source line #50	-> byte code offset #93
    //   Java source line #32	-> byte code offset #122
    //   Java source line #33	-> byte code offset #136
    //   Java source line #34	-> byte code offset #150
    //   Java source line #44	-> byte code offset #165
    //   Java source line #50	-> byte code offset #179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	hashtables
    //   0	193	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	193	2	paramObject1	Object
    //   0	193	3	paramObject2	Object
    //   0	193	4	paramObject3	Object
    //   122	1	5	localClassCastException1	ClassCastException
    //   136	1	6	localClassCastException2	ClassCastException
    //   150	1	7	localClassCastException3	ClassCastException
    //   165	1	8	localClassCastException4	ClassCastException
    //   179	1	9	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   50	53	122	java/lang/ClassCastException
    //   59	62	136	java/lang/ClassCastException
    //   67	73	150	java/lang/ClassCastException
    //   83	86	165	java/lang/ClassCastException
    //   99	102	179	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply4(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 347	gnu/expr/ModuleMethod:selector	I
    //   4: bipush 15
    //   6: if_icmpne +32 -> 38
    //   9: goto +3 -> 12
    //   12: aload_2
    //   13: ldc 36
    //   15: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: checkcast 36	kawa/lib/kawa/hashtable$HashTable
    //   21: aload_3
    //   22: aload 4
    //   24: ldc 93
    //   26: invokestatic 363	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   29: invokestatic 521	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   32: aload 5
    //   34: invokestatic 565	kawa/lib/rnrs/hashtables:hashtableUpdate$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: areturn
    //   38: aload_0
    //   39: aload_1
    //   40: aload_2
    //   41: aload_3
    //   42: aload 4
    //   44: aload 5
    //   46: invokespecial 569	gnu/expr/ModuleBody:apply4	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: areturn
    //   50: new 436	gnu/mapping/WrongType
    //   53: dup_x1
    //   54: swap
    //   55: ldc_w 561
    //   58: iconst_1
    //   59: aload_2
    //   60: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   63: athrow
    //   64: new 436	gnu/mapping/WrongType
    //   67: dup_x1
    //   68: swap
    //   69: ldc_w 561
    //   72: iconst_3
    //   73: aload 4
    //   75: invokespecial 441	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   78: athrow
    // Line number table:
    //   Java source line #61	-> byte code offset #12
    //   Java source line #62	-> byte code offset #64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	hashtables
    //   0	79	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	79	2	paramObject1	Object
    //   0	79	3	paramObject2	Object
    //   0	79	4	paramObject3	Object
    //   0	79	5	paramObject4	Object
    //   50	1	6	localClassCastException1	ClassCastException
    //   64	1	7	localClassCastException2	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   18	21	50	java/lang/ClassCastException
    //   29	32	64	java/lang/ClassCastException
  }
}
