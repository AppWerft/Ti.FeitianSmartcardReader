package gnu.kawa.slib;

import kawa.lib.kawa.hashtable.HashTable;

public class srfi69 extends gnu.expr.ModuleBody { public static final int $Pcprovide$Pcsrfi$Mn69 = 123;
  public static final int $Pcprovide$Pchash$Mntable = 123;
  public static final gnu.expr.ModuleMethod make$Mnhash$Mntable;
  public static final gnu.kawa.reflect.StaticFieldLocation hash$Mntable$Qu;
  public static final gnu.expr.ModuleMethod alist$Mn$Grhash$Mntable;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnequivalence$Mnfunction;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnhash$Mnfunction;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnref;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnref$Sldefault;
  public static final gnu.kawa.reflect.StaticFieldLocation hash$Mntable$Mnset$Ex;
  public static final gnu.kawa.reflect.StaticFieldLocation hash$Mntable$Mndelete$Ex;
  public static final gnu.kawa.reflect.StaticFieldLocation hash$Mntable$Mnexists$Qu;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnupdate$Ex;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnupdate$Ex$Sldefault;
  public static final gnu.kawa.reflect.StaticFieldLocation hash$Mntable$Mnsize;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnkeys;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnvalues;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnwalk;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mnfold;
  public static final gnu.expr.ModuleMethod hash$Mntable$Mn$Gralist; public static final gnu.expr.ModuleMethod hash$Mntable$Mncopy; public static final gnu.expr.ModuleMethod hash$Mntable$Mnmerge$Ex; public static final gnu.expr.ModuleMethod hash; public static final gnu.expr.ModuleMethod string$Mnhash; public static final gnu.expr.ModuleMethod string$Mnci$Mnhash; public static final gnu.expr.ModuleMethod hash$Mnby$Mnidentity; static final gnu.math.IntNum Lit0; static final gnu.expr.ModuleMethod lambda$Fn1;
  private static void $runBody$() { ; gnu.lists.Consumer $result = getInstanceconsumer; }
  
  static final gnu.expr.ModuleMethod lambda$Fn2;
  static final gnu.expr.ModuleMethod lambda$Fn3;
  public static srfi69 $instance;
  static final gnu.mapping.SimpleSymbol Lit1;
  static final gnu.mapping.SimpleSymbol Lit2;
  static final gnu.mapping.SimpleSymbol Lit3;
  static final gnu.mapping.SimpleSymbol Lit4;
  static final gnu.mapping.SimpleSymbol Lit5;
  static final gnu.mapping.SimpleSymbol Lit6;
  static final gnu.mapping.SimpleSymbol Lit7;
  static final gnu.mapping.SimpleSymbol Lit8; static final gnu.mapping.SimpleSymbol Lit9; static final gnu.mapping.SimpleSymbol Lit10; static final gnu.mapping.SimpleSymbol Lit11; static final gnu.mapping.SimpleSymbol Lit12; static final gnu.mapping.SimpleSymbol Lit13; static final gnu.mapping.SimpleSymbol Lit14; static final gnu.mapping.SimpleSymbol Lit15;
  static { Lit18 = gnu.mapping.Symbol.valueOf("hash-table-keys");Lit17 = gnu.mapping.Symbol.valueOf("hash-table-merge!");Lit16 = gnu.mapping.Symbol.valueOf("hash-table-copy");Lit15 = gnu.mapping.Symbol.valueOf("hash-table->alist");Lit14 = gnu.mapping.Symbol.valueOf("alist->hash-table");Lit13 = gnu.mapping.Symbol.valueOf("hash-table-fold");Lit12 = gnu.mapping.Symbol.valueOf("hash-table-walk");Lit11 = gnu.mapping.Symbol.valueOf("hash-table-update!/default");Lit10 = gnu.mapping.Symbol.valueOf("hash-table-update!");Lit9 = gnu.mapping.Symbol.valueOf("hash-table-ref/default");Lit8 = gnu.mapping.Symbol.valueOf("hash-table-ref");Lit7 = gnu.mapping.Symbol.valueOf("make-hash-table");Lit6 = gnu.mapping.Symbol.valueOf("hash-table-hash-function");Lit5 = gnu.mapping.Symbol.valueOf("hash-table-equivalence-function");Lit4 = gnu.mapping.Symbol.valueOf("hash-by-identity");Lit3 = gnu.mapping.Symbol.valueOf("hash");Lit2 = gnu.mapping.Symbol.valueOf("string-ci-hash");Lit1 = gnu.mapping.Symbol.valueOf("string-hash");Lit0 = gnu.math.IntNum.valueOf(64);$instance = new srfi69();hash$Mntable$Mndelete$Ex = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mndelete$Ex");hash$Mntable$Mnexists$Qu = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mncontains$Qu");hash$Mntable$Mnset$Ex = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnset$Ex");hash$Mntable$Qu = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Qu");hash$Mntable$Mnsize = gnu.kawa.reflect.StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnsize");srfi69 localSrfi69 = $instance;string$Mnhash = new gnu.expr.ModuleMethod(localSrfi69, 1, Lit1, 8193);string$Mnci$Mnhash = new gnu.expr.ModuleMethod(localSrfi69, 3, Lit2, 8193);hash = new gnu.expr.ModuleMethod(localSrfi69, 5, Lit3, 8193);hash$Mnby$Mnidentity = new gnu.expr.ModuleMethod(localSrfi69, 7, Lit4, 8193);hash$Mntable$Mnequivalence$Mnfunction = new gnu.expr.ModuleMethod(localSrfi69, 9, Lit5, 4097);hash$Mntable$Mnhash$Mnfunction = new gnu.expr.ModuleMethod(localSrfi69, 10, Lit6, 4097);make$Mnhash$Mntable = new gnu.expr.ModuleMethod(localSrfi69, 11, Lit7, 12288);hash$Mntable$Mnref = new gnu.expr.ModuleMethod(localSrfi69, 15, Lit8, 12290);hash$Mntable$Mnref$Sldefault = new gnu.expr.ModuleMethod(localSrfi69, 17, Lit9, 12291);hash$Mntable$Mnupdate$Ex = new gnu.expr.ModuleMethod(localSrfi69, 18, Lit10, 16387);hash$Mntable$Mnupdate$Ex$Sldefault = new gnu.expr.ModuleMethod(localSrfi69, 20, Lit11, 16388);hash$Mntable$Mnwalk = new gnu.expr.ModuleMethod(localSrfi69, 21, Lit12, 8194);hash$Mntable$Mnfold = new gnu.expr.ModuleMethod(localSrfi69, 22, Lit13, 12291); void tmp510_507 = new gnu.expr.ModuleMethod(localSrfi69, 23, null, 4097);tmp510_507.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:158");lambda$Fn1 = tmp510_507;alist$Mn$Grhash$Mntable = new gnu.expr.ModuleMethod(localSrfi69, 24, Lit14, 16385);hash$Mntable$Mn$Gralist = new gnu.expr.ModuleMethod(localSrfi69, 28, Lit15, 4097);hash$Mntable$Mncopy = new gnu.expr.ModuleMethod(localSrfi69, 29, Lit16, 4097);hash$Mntable$Mnmerge$Ex = new gnu.expr.ModuleMethod(localSrfi69, 30, Lit17, 8194); void tmp613_610 = new gnu.expr.ModuleMethod(localSrfi69, 31, null, 12291);tmp613_610.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:175");lambda$Fn2 = tmp613_610;hash$Mntable$Mnkeys = new gnu.expr.ModuleMethod(localSrfi69, 32, Lit18, 4097); void tmp659_656 = new gnu.expr.ModuleMethod(localSrfi69, 33, null, 12291);tmp659_656.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:178");lambda$Fn3 = tmp659_656;hash$Mntable$Mnvalues = new gnu.expr.ModuleMethod(localSrfi69, 34, Lit19, 4097);$runBody$(); } static final gnu.mapping.SimpleSymbol Lit16; static final gnu.mapping.SimpleSymbol Lit17; static final gnu.mapping.SimpleSymbol Lit18; static final gnu.mapping.SimpleSymbol Lit19 = gnu.mapping.Symbol.valueOf("hash-table-values");
  







  public static gnu.math.IntNum stringHash(CharSequence s, gnu.math.IntNum bound)
  {
    int h = s.hashCode();
    return bound == null ? gnu.math.IntNum.make(h) : gnu.math.IntNum.modulo(gnu.math.IntNum.make(h), bound);
  }
  


  public static gnu.math.IntNum stringCiHash(Object s, gnu.math.IntNum bound)
  {
    int h = s.toString().toLowerCase().hashCode();
    return bound == null ? gnu.math.IntNum.make(h) : gnu.math.IntNum.modulo(gnu.math.IntNum.make(h), bound);
  }
  
  public static gnu.math.IntNum hash(Object obj, gnu.math.IntNum bound) { int h = gnu.kawa.util.HashUtils.boundedHash(obj);
    return bound == null ? gnu.math.IntNum.make(h) : gnu.math.IntNum.modulo(gnu.math.IntNum.make(h), bound);
  }
  
  public static gnu.math.IntNum hashByIdentity(Object obj, gnu.math.IntNum bound) { int h = System.identityHashCode(obj);
    return bound == null ? gnu.math.IntNum.make(h) : gnu.math.IntNum.modulo(gnu.math.IntNum.make(h), bound);
  }
  
  public static gnu.mapping.Procedure hashTableEquivalenceFunction(hashtable.HashTable hash$Mntable) {
    return equivalenceFunction;
  }
  
  public static gnu.mapping.Procedure hashTableHashFunction(hashtable.HashTable hash$Mntable) {
    return hashFunction;
  }
  
  static gnu.mapping.Procedure appropriateHashFunctionFor(Object comparison)
  {
    Object x = comparison == kawa.standard.Scheme.isEq ? hash$Mnby$Mnidentity : Boolean.FALSE;
    Object x = comparison == kawa.lib.strings.string$Eq$Qu ? string$Mnhash : Boolean.FALSE;
    Object x = comparison == kawa.lib.strings.string$Mnci$Eq$Qu ? string$Mnci$Mnhash : Boolean.FALSE;return gnu.expr.KawaConvert.isTrue(x) ? gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(x, gnu.mapping.Procedure.class)) : gnu.expr.KawaConvert.isTrue(x) ? gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(x, gnu.mapping.Procedure.class)) : gnu.expr.KawaConvert.isTrue(x) ? gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(x, gnu.mapping.Procedure.class)) : hash;
  }
  


  public int match0(gnu.expr.ModuleMethod paramModuleMethod, gnu.mapping.CallContext paramCallContext)
  {
    if (selector == 11) { proc = paramModuleMethod;pc = 0;return 0; } return super.match0(paramModuleMethod, paramCallContext); } public Object apply0(gnu.expr.ModuleMethod paramModuleMethod) { if (selector == 11) return makeHashTable(); return super.apply0(paramModuleMethod);
  }
  
  public static hashtable.HashTable makeHashTable(gnu.mapping.Procedure paramProcedure) { return makeHashTable(paramProcedure, appropriateHashFunctionFor(paramProcedure), 64); }
  
  public static hashtable.HashTable makeHashTable(gnu.mapping.Procedure comparison, gnu.mapping.Procedure hash, int size) {
    return new hashtable.HashTable(comparison, hash, size);
  }
  














  public static Object hashTableRef(hashtable.HashTable hash$Mntable, Object key, Object default)
  {
    gnu.kawa.util.HashNode node = hash$Mntable.getNode(key);
    if (node == null)
    {
      throw gnu.expr.Special.reachedUnexpected; }
    return gnu.expr.KawaConvert.isTrue(default) ? kawa.standard.Scheme.applyToArgs.apply1(default) : node.getValue();
  }
  
  public static Object hashTableRef$SlDefault(hashtable.HashTable hash$Mntable, Object key, Object default) {
    return hash$Mntable.get(key, default);
  }
  
























  public int match4(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, gnu.mapping.CallContext paramCallContext)
  {
    switch (selector) {case 24:  value1 = paramObject1;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0;
    case 20: 
      Object tmp96_93 = gnu.mapping.Promise.force(paramObject1, hashtable.HashTable.class);
      

































































































































      if (!(tmp96_93 instanceof hashtable.HashTable)) return -786431; value1 = tmp96_93;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0;
    case 18: 
      Object tmp152_149 = gnu.mapping.Promise.force(paramObject1, hashtable.HashTable.class);
      























































































































      if (!(tmp152_149 instanceof hashtable.HashTable)) return -786431; value1 = tmp152_149;value2 = paramObject2;value3 = paramObject3;value4 = paramObject4;proc = paramModuleMethod;pc = 4;return 0; } return super.match4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4, paramCallContext); }
  
  public static void hashTableUpdate$Ex(hashtable.HashTable hash$Mntable, Object key, Object function, Object thunk) { kawa.lib.kawa.hashtable.hashtableCheckMutable(hash$Mntable);
    gnu.kawa.util.HashNode node = hash$Mntable.getNode(key);
    if (node == null) {
      if (gnu.expr.KawaConvert.isTrue(thunk))
        kawa.lib.rnrs.hashtables.hashtableSet$Ex(hash$Mntable, key, kawa.standard.Scheme.applyToArgs.apply2(function, kawa.standard.Scheme.applyToArgs.apply1(thunk))); else
        throw gnu.expr.Special.reachedUnexpected;
    } else node.setValue(kawa.standard.Scheme.applyToArgs.apply2(function, node.getValue()));
  }
  
  public static void hashTableUpdate$Ex$SlDefault(hashtable.HashTable hash$Mntable, Object key, Object function, Object default) { kawa.lib.kawa.hashtable.hashtableCheckMutable(hash$Mntable);
    gnu.kawa.util.HashNode node = hash$Mntable.getNode(key);
    if (node == null)
      kawa.lib.rnrs.hashtables.hashtableSet$Ex(hash$Mntable, key, kawa.standard.Scheme.applyToArgs.apply2(function, default)); else {
      node.setValue(kawa.standard.Scheme.applyToArgs.apply2(function, node.getValue()));
    }
  }
  
  public static void hashTableWalk(hashtable.HashTable hash$Mntable, gnu.mapping.Procedure proc) {
    hash$Mntable.walk(proc);
  }
  
  public static Object hashTableFold(hashtable.HashTable hash$Mntable, gnu.mapping.Procedure proc, Object acc)
  {
    return hash$Mntable.fold(proc, acc);
  }
  
  public Object apply4(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    switch (selector) {} try { hashTableUpdate$Ex((hashtable.HashTable)gnu.mapping.Promise.force(paramObject1, hashtable.HashTable.class), paramObject2, paramObject3, paramObject4);return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      

























        localClassCastException1, "hash-table-update!", 1, paramObject1);
    }
    try
    {
      hashTableUpdate$Ex$SlDefault((hashtable.HashTable)gnu.mapping.Promise.force(paramObject1, hashtable.HashTable.class), paramObject2, paramObject3, paramObject4);return gnu.mapping.Values.empty; } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "hash-table-update!/default", 1, paramObject1);
    }
    














    return alist$To$HashTable(paramObject1, paramObject2, paramObject3, paramObject4);return super.apply4(paramModuleMethod, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  public static hashtable.HashTable alist$To$HashTable(Object paramObject1, Object paramObject2) { return alist$To$HashTable(paramObject1, paramObject2, appropriateHashFunctionFor(paramObject2)); }
  
  public static hashtable.HashTable alist$To$HashTable(Object paramObject1, Object paramObject2, Object paramObject3) { return alist$To$HashTable(paramObject1, paramObject2, paramObject3, kawa.lib.numbers.max(new Object[] { Lit0, Integer.valueOf(2 * gnu.lists.Sequences.getSize(paramObject1)) })); }
  

  static Object lambda1(Object x)
  {
    return x;
  }
  
  public static Object hashTable$To$Alist(hashtable.HashTable hash$Mntable)
  {
    return hash$Mntable.toAlist();
  }
  
  public static hashtable.HashTable hashTableCopy(hashtable.HashTable hash$Mntable) { return new hashtable.HashTable(hash$Mntable, true); }
  

  public static void hashTableMerge$Ex(hashtable.HashTable hash$Mntable1, hashtable.HashTable hash$Mntable2)
  {
    hash$Mntable1.putAll(hash$Mntable2);
  }
  

  public static Object hashTableKeys(hashtable.HashTable hash$Mntable) { return hashTableFold(hash$Mntable, lambda$Fn2, gnu.lists.LList.Empty); } static gnu.lists.Pair lambda2(Object key, Object val, Object acc) { return kawa.lib.lists.cons(key, acc);
  }
  
  public Object apply1(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject)
  {
    switch (selector) {} try { return stringHash((CharSequence)gnu.mapping.Promise.force(paramObject, CharSequence.class)); } catch (ClassCastException localClassCastException1) { throw new gnu.mapping.WrongType(
      































































































































        localClassCastException1, "string-hash", 1, paramObject);
    }
    return stringCiHash(paramObject);
    






    return hash(paramObject);
    


    return hashByIdentity(paramObject);
    


    try
    {
      return hashTableEquivalenceFunction((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException2) { throw new gnu.mapping.WrongType(localClassCastException2, "hash-table-equivalence-function", 1, paramObject);
    }
    try
    {
      return hashTableHashFunction((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException3) { throw new gnu.mapping.WrongType(localClassCastException3, "hash-table-hash-function", 1, paramObject);
    }
    







    try
    {
      return makeHashTable(gnu.kawa.lispexpr.LangObjType.coerceToProcedure(gnu.mapping.Promise.force(paramObject, gnu.mapping.Procedure.class)));
    } catch (ClassCastException localClassCastException4) { throw new gnu.mapping.WrongType(localClassCastException4, "make-hash-table", 1, paramObject);
    }
    




































































    return lambda1(paramObject);return alist$To$HashTable(paramObject);
    
    try
    {
      return hashTable$To$Alist((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException5) { throw new gnu.mapping.WrongType(localClassCastException5, "hash-table->alist", 1, paramObject);
    }
    try {
      return hashTableCopy((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException6) { throw new gnu.mapping.WrongType(localClassCastException6, "hash-table-copy", 1, paramObject);
    }
    




    try
    {
      return hashTableKeys((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException7) { throw new gnu.mapping.WrongType(localClassCastException7, "hash-table-keys", 1, paramObject);
    }
    try {
      return hashTableValues((hashtable.HashTable)gnu.mapping.Promise.force(paramObject, hashtable.HashTable.class)); } catch (ClassCastException localClassCastException8) { throw new gnu.mapping.WrongType(localClassCastException8, "hash-table-values", 1, paramObject); } return super.apply1(paramModuleMethod, paramObject); }
  public static Object hashTableValues(hashtable.HashTable hash$Mntable) { return hashTableFold(hash$Mntable, lambda$Fn3, gnu.lists.LList.Empty); } static gnu.lists.Pair lambda3(Object key, Object val, Object acc) { return kawa.lib.lists.cons(val, acc); }
  
  public static gnu.math.IntNum stringHash(CharSequence paramCharSequence)
  {
    return stringHash(paramCharSequence, null);
  }
  
  public static gnu.math.IntNum stringCiHash(Object paramObject)
  {
    return stringCiHash(paramObject, null);
  }
  
  public static gnu.math.IntNum hash(Object paramObject)
  {
    return hash(paramObject, null);
  }
  
  public static gnu.math.IntNum hashByIdentity(Object paramObject)
  {
    return hashByIdentity(paramObject, null);
  }
  
  public static hashtable.HashTable makeHashTable()
  {
    return makeHashTable(kawa.standard.Scheme.isEqual);
  }
  
  public static hashtable.HashTable makeHashTable(gnu.mapping.Procedure paramProcedure1, gnu.mapping.Procedure paramProcedure2)
  {
    return makeHashTable(paramProcedure1, paramProcedure2, 64);
  }
  
  public static Object hashTableRef(hashtable.HashTable paramHashTable, Object paramObject)
  {
    return hashTableRef(paramHashTable, paramObject, Boolean.FALSE);
  }
  
  public static void hashTableUpdate$Ex(hashtable.HashTable paramHashTable, Object paramObject1, Object paramObject2)
  {
    hashTableUpdate$Ex(paramHashTable, paramObject1, paramObject2, Boolean.FALSE);
  }
  
  public static hashtable.HashTable alist$To$HashTable(Object paramObject)
  {
    return alist$To$HashTable(paramObject, kawa.standard.Scheme.isEqual);
  }
  
  /* Error */
  public static hashtable.HashTable alist$To$HashTable(Object alist, Object comparison, Object hash, Object size)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 120
    //   3: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   6: dup
    //   7: astore 5
    //   9: invokestatic 222	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   12: aload_2
    //   13: ldc 120
    //   15: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   18: dup
    //   19: astore 5
    //   21: invokestatic 222	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   24: aload_3
    //   25: invokestatic 233	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: dup
    //   29: astore 5
    //   31: checkcast 235	java/lang/Number
    //   34: invokevirtual 238	java/lang/Number:intValue	()I
    //   37: invokestatic 90	gnu/kawa/slib/srfi69:makeHashTable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
    //   40: astore 4
    //   42: aload_0
    //   43: invokestatic 242	gnu/lists/Sequences:getIterator	(Ljava/lang/Object;)Ljava/util/Iterator;
    //   46: astore 5
    //   48: aload 5
    //   50: invokeinterface 248 1 0
    //   55: ifeq +55 -> 110
    //   58: aload 5
    //   60: invokeinterface 251 1 0
    //   65: astore 6
    //   67: aload 4
    //   69: aload 6
    //   71: ldc -3
    //   73: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   76: dup
    //   77: astore 7
    //   79: checkcast 253	gnu/lists/Pair
    //   82: invokestatic 260	kawa/lib/lists:car	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   85: getstatic 264	gnu/kawa/slib/srfi69:lambda$Fn1	Lgnu/expr/ModuleMethod;
    //   88: aload 6
    //   90: ldc -3
    //   92: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: dup
    //   96: astore 7
    //   98: checkcast 253	gnu/lists/Pair
    //   101: invokestatic 268	kawa/lib/lists:cdr	(Lgnu/lists/Pair;)Ljava/lang/Object;
    //   104: invokestatic 271	gnu/kawa/slib/srfi69:hashTableUpdate$Ex$SlDefault	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   107: goto -59 -> 48
    //   110: aload 4
    //   112: areturn
    //   113: new 226	gnu/mapping/WrongType
    //   116: dup_x1
    //   117: swap
    //   118: ldc -28
    //   120: iconst_0
    //   121: aload 5
    //   123: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   126: athrow
    //   127: new 226	gnu/mapping/WrongType
    //   130: dup_x1
    //   131: swap
    //   132: ldc -28
    //   134: iconst_1
    //   135: aload 5
    //   137: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   140: athrow
    //   141: new 226	gnu/mapping/WrongType
    //   144: dup_x1
    //   145: swap
    //   146: ldc -28
    //   148: iconst_2
    //   149: aload 5
    //   151: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   154: athrow
    //   155: new 226	gnu/mapping/WrongType
    //   158: dup_x1
    //   159: swap
    //   160: ldc -1
    //   162: iconst_1
    //   163: aload 7
    //   165: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   168: athrow
    //   169: new 226	gnu/mapping/WrongType
    //   172: dup_x1
    //   173: swap
    //   174: ldc_w 266
    //   177: iconst_1
    //   178: aload 7
    //   180: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   183: athrow
    // Line number table:
    //   Java source line #148	-> byte code offset #0
    //   Java source line #154	-> byte code offset #0
    //   Java source line #155	-> byte code offset #42
    //   Java source line #159	-> byte code offset #42
    //   Java source line #157	-> byte code offset #67
    //   Java source line #158	-> byte code offset #67
    //   Java source line #160	-> byte code offset #110
    //   Java source line #154	-> byte code offset #113
    //   Java source line #158	-> byte code offset #155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	alist	Object
    //   0	112	1	comparison	Object
    //   0	112	2	hash	Object
    //   0	112	3	size	Object
    //   40	71	4	hash$Mntable	hashtable.HashTable
    //   7	143	5	localObject1	Object
    //   65	24	6	localObject2	Object
    //   77	102	7	localObject3	Object
    //   113	1	8	localClassCastException1	ClassCastException
    //   127	1	9	localClassCastException2	ClassCastException
    //   141	1	10	localClassCastException3	ClassCastException
    //   155	1	11	localClassCastException4	ClassCastException
    //   169	1	12	localClassCastException5	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   9	12	113	java/lang/ClassCastException
    //   21	24	127	java/lang/ClassCastException
    //   31	37	141	java/lang/ClassCastException
    //   79	82	155	java/lang/ClassCastException
    //   98	101	169	java/lang/ClassCastException
  }
  
  public srfi69()
  {
    gnu.expr.ModuleInfo.register(this);
  }
  
  /* Error */
  public int match1(gnu.expr.ModuleMethod arg1, Object arg2, gnu.mapping.CallContext arg3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 501	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+472->476, 1:+435->439, 3:+418->422, 5:+401->405, 7:+384->388, 9:+351->355, 10:+318->322, 11:+282->286, 23:+265->269, 24:+248->252, 28:+215->219, 29:+182->186, 32:+149->153, 34:+116->120
    //   120: aload_3
    //   121: aload_2
    //   122: ldc 66
    //   124: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   127: dup
    //   128: instanceof 66
    //   131: ifne +7 -> 138
    //   134: ldc_w 512
    //   137: ireturn
    //   138: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   141: aload_3
    //   142: aload_1
    //   143: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   146: aload_3
    //   147: iconst_1
    //   148: putfield 507	gnu/mapping/CallContext:pc	I
    //   151: iconst_0
    //   152: ireturn
    //   153: aload_3
    //   154: aload_2
    //   155: ldc 66
    //   157: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   160: dup
    //   161: instanceof 66
    //   164: ifne +7 -> 171
    //   167: ldc_w 512
    //   170: ireturn
    //   171: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   174: aload_3
    //   175: aload_1
    //   176: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   179: aload_3
    //   180: iconst_1
    //   181: putfield 507	gnu/mapping/CallContext:pc	I
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_3
    //   187: aload_2
    //   188: ldc 66
    //   190: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   193: dup
    //   194: instanceof 66
    //   197: ifne +7 -> 204
    //   200: ldc_w 512
    //   203: ireturn
    //   204: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   207: aload_3
    //   208: aload_1
    //   209: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   212: aload_3
    //   213: iconst_1
    //   214: putfield 507	gnu/mapping/CallContext:pc	I
    //   217: iconst_0
    //   218: ireturn
    //   219: aload_3
    //   220: aload_2
    //   221: ldc 66
    //   223: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   226: dup
    //   227: instanceof 66
    //   230: ifne +7 -> 237
    //   233: ldc_w 512
    //   236: ireturn
    //   237: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   240: aload_3
    //   241: aload_1
    //   242: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   245: aload_3
    //   246: iconst_1
    //   247: putfield 507	gnu/mapping/CallContext:pc	I
    //   250: iconst_0
    //   251: ireturn
    //   252: aload_3
    //   253: aload_2
    //   254: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   257: aload_3
    //   258: aload_1
    //   259: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   262: aload_3
    //   263: iconst_1
    //   264: putfield 507	gnu/mapping/CallContext:pc	I
    //   267: iconst_0
    //   268: ireturn
    //   269: aload_3
    //   270: aload_2
    //   271: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   274: aload_3
    //   275: aload_1
    //   276: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   279: aload_3
    //   280: iconst_1
    //   281: putfield 507	gnu/mapping/CallContext:pc	I
    //   284: iconst_0
    //   285: ireturn
    //   286: aload_3
    //   287: aload_2
    //   288: ldc 120
    //   290: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   293: dup
    //   294: invokestatic 519	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   297: ifnull +6 -> 303
    //   300: goto +7 -> 307
    //   303: ldc_w 512
    //   306: ireturn
    //   307: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   310: aload_3
    //   311: aload_1
    //   312: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   315: aload_3
    //   316: iconst_1
    //   317: putfield 507	gnu/mapping/CallContext:pc	I
    //   320: iconst_0
    //   321: ireturn
    //   322: aload_3
    //   323: aload_2
    //   324: ldc 66
    //   326: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   329: dup
    //   330: instanceof 66
    //   333: ifne +7 -> 340
    //   336: ldc_w 512
    //   339: ireturn
    //   340: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   343: aload_3
    //   344: aload_1
    //   345: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   348: aload_3
    //   349: iconst_1
    //   350: putfield 507	gnu/mapping/CallContext:pc	I
    //   353: iconst_0
    //   354: ireturn
    //   355: aload_3
    //   356: aload_2
    //   357: ldc 66
    //   359: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   362: dup
    //   363: instanceof 66
    //   366: ifne +7 -> 373
    //   369: ldc_w 512
    //   372: ireturn
    //   373: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   376: aload_3
    //   377: aload_1
    //   378: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   381: aload_3
    //   382: iconst_1
    //   383: putfield 507	gnu/mapping/CallContext:pc	I
    //   386: iconst_0
    //   387: ireturn
    //   388: aload_3
    //   389: aload_2
    //   390: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   393: aload_3
    //   394: aload_1
    //   395: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   398: aload_3
    //   399: iconst_1
    //   400: putfield 507	gnu/mapping/CallContext:pc	I
    //   403: iconst_0
    //   404: ireturn
    //   405: aload_3
    //   406: aload_2
    //   407: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   410: aload_3
    //   411: aload_1
    //   412: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   415: aload_3
    //   416: iconst_1
    //   417: putfield 507	gnu/mapping/CallContext:pc	I
    //   420: iconst_0
    //   421: ireturn
    //   422: aload_3
    //   423: aload_2
    //   424: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   427: aload_3
    //   428: aload_1
    //   429: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   432: aload_3
    //   433: iconst_1
    //   434: putfield 507	gnu/mapping/CallContext:pc	I
    //   437: iconst_0
    //   438: ireturn
    //   439: aload_3
    //   440: aload_2
    //   441: ldc_w 521
    //   444: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   447: dup
    //   448: instanceof 521
    //   451: ifeq +6 -> 457
    //   454: goto +7 -> 461
    //   457: ldc_w 512
    //   460: ireturn
    //   461: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   464: aload_3
    //   465: aload_1
    //   466: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   469: aload_3
    //   470: iconst_1
    //   471: putfield 507	gnu/mapping/CallContext:pc	I
    //   474: iconst_0
    //   475: ireturn
    //   476: aload_0
    //   477: aload_1
    //   478: aload_2
    //   479: aload_3
    //   480: invokespecial 525	gnu/expr/ModuleBody:match1	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   483: ireturn
    // Line number table:
    //   Java source line #177	-> byte code offset #120
    //   Java source line #174	-> byte code offset #153
    //   Java source line #165	-> byte code offset #186
    //   Java source line #162	-> byte code offset #219
    //   Java source line #148	-> byte code offset #252
    //   Java source line #158	-> byte code offset #269
    //   Java source line #86	-> byte code offset #286
    //   Java source line #74	-> byte code offset #322
    //   Java source line #70	-> byte code offset #355
    //   Java source line #64	-> byte code offset #388
    //   Java source line #60	-> byte code offset #405
    //   Java source line #52	-> byte code offset #422
    //   Java source line #48	-> byte code offset #439
  }
  
  /* Error */
  public int match2(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, gnu.mapping.CallContext arg4)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 501	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+535->539, 1:+470->474, 3:+425->429, 5:+380->384, 7:+335->339, 11:+271->275, 15:+229->233, 21:+168->172, 24:+142->146, 30:+84->88
    //   88: aload 4
    //   90: aload_2
    //   91: ldc 66
    //   93: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   96: dup
    //   97: instanceof 66
    //   100: ifne +7 -> 107
    //   103: ldc_w 512
    //   106: ireturn
    //   107: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   110: aload 4
    //   112: aload_3
    //   113: ldc 66
    //   115: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   118: dup
    //   119: instanceof 66
    //   122: ifne +7 -> 129
    //   125: ldc_w 526
    //   128: ireturn
    //   129: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   132: aload 4
    //   134: aload_1
    //   135: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   138: aload 4
    //   140: iconst_2
    //   141: putfield 507	gnu/mapping/CallContext:pc	I
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 4
    //   148: aload_2
    //   149: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   152: aload 4
    //   154: aload_3
    //   155: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   158: aload 4
    //   160: aload_1
    //   161: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   164: aload 4
    //   166: iconst_2
    //   167: putfield 507	gnu/mapping/CallContext:pc	I
    //   170: iconst_0
    //   171: ireturn
    //   172: aload 4
    //   174: aload_2
    //   175: ldc 66
    //   177: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   180: dup
    //   181: instanceof 66
    //   184: ifne +7 -> 191
    //   187: ldc_w 512
    //   190: ireturn
    //   191: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   194: aload 4
    //   196: aload_3
    //   197: ldc 120
    //   199: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   202: dup
    //   203: invokestatic 519	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   206: ifnull +6 -> 212
    //   209: goto +7 -> 216
    //   212: ldc_w 526
    //   215: ireturn
    //   216: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   219: aload 4
    //   221: aload_1
    //   222: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   225: aload 4
    //   227: iconst_2
    //   228: putfield 507	gnu/mapping/CallContext:pc	I
    //   231: iconst_0
    //   232: ireturn
    //   233: aload 4
    //   235: aload_2
    //   236: ldc 66
    //   238: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   241: dup
    //   242: instanceof 66
    //   245: ifne +7 -> 252
    //   248: ldc_w 512
    //   251: ireturn
    //   252: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   255: aload 4
    //   257: aload_3
    //   258: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   261: aload 4
    //   263: aload_1
    //   264: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   267: aload 4
    //   269: iconst_2
    //   270: putfield 507	gnu/mapping/CallContext:pc	I
    //   273: iconst_0
    //   274: ireturn
    //   275: aload 4
    //   277: aload_2
    //   278: ldc 120
    //   280: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   283: dup
    //   284: invokestatic 519	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   287: ifnull +6 -> 293
    //   290: goto +7 -> 297
    //   293: ldc_w 512
    //   296: ireturn
    //   297: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   300: aload 4
    //   302: aload_3
    //   303: ldc 120
    //   305: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   308: dup
    //   309: invokestatic 519	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   312: ifnull +6 -> 318
    //   315: goto +7 -> 322
    //   318: ldc_w 526
    //   321: ireturn
    //   322: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   325: aload 4
    //   327: aload_1
    //   328: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   331: aload 4
    //   333: iconst_2
    //   334: putfield 507	gnu/mapping/CallContext:pc	I
    //   337: iconst_0
    //   338: ireturn
    //   339: aload 4
    //   341: aload_2
    //   342: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   345: aload 4
    //   347: aload_3
    //   348: ldc 25
    //   350: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   353: dup
    //   354: invokestatic 533	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   357: ifnull +6 -> 363
    //   360: goto +7 -> 367
    //   363: ldc_w 526
    //   366: ireturn
    //   367: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   370: aload 4
    //   372: aload_1
    //   373: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   376: aload 4
    //   378: iconst_2
    //   379: putfield 507	gnu/mapping/CallContext:pc	I
    //   382: iconst_0
    //   383: ireturn
    //   384: aload 4
    //   386: aload_2
    //   387: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   390: aload 4
    //   392: aload_3
    //   393: ldc 25
    //   395: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   398: dup
    //   399: invokestatic 533	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   402: ifnull +6 -> 408
    //   405: goto +7 -> 412
    //   408: ldc_w 526
    //   411: ireturn
    //   412: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   415: aload 4
    //   417: aload_1
    //   418: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   421: aload 4
    //   423: iconst_2
    //   424: putfield 507	gnu/mapping/CallContext:pc	I
    //   427: iconst_0
    //   428: ireturn
    //   429: aload 4
    //   431: aload_2
    //   432: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   435: aload 4
    //   437: aload_3
    //   438: ldc 25
    //   440: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   443: dup
    //   444: invokestatic 533	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   447: ifnull +6 -> 453
    //   450: goto +7 -> 457
    //   453: ldc_w 526
    //   456: ireturn
    //   457: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   460: aload 4
    //   462: aload_1
    //   463: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   466: aload 4
    //   468: iconst_2
    //   469: putfield 507	gnu/mapping/CallContext:pc	I
    //   472: iconst_0
    //   473: ireturn
    //   474: aload 4
    //   476: aload_2
    //   477: ldc_w 521
    //   480: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   483: dup
    //   484: instanceof 521
    //   487: ifeq +6 -> 493
    //   490: goto +7 -> 497
    //   493: ldc_w 512
    //   496: ireturn
    //   497: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   500: aload 4
    //   502: aload_3
    //   503: ldc 25
    //   505: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   508: dup
    //   509: invokestatic 533	gnu/math/IntNum:asIntNumOrNull	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   512: ifnull +6 -> 518
    //   515: goto +7 -> 522
    //   518: ldc_w 526
    //   521: ireturn
    //   522: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   525: aload 4
    //   527: aload_1
    //   528: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   531: aload 4
    //   533: iconst_2
    //   534: putfield 507	gnu/mapping/CallContext:pc	I
    //   537: iconst_0
    //   538: ireturn
    //   539: aload_0
    //   540: aload_1
    //   541: aload_2
    //   542: aload_3
    //   543: aload 4
    //   545: invokespecial 537	gnu/expr/ModuleBody:match2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   548: ireturn
    // Line number table:
    //   Java source line #168	-> byte code offset #88
    //   Java source line #148	-> byte code offset #146
    //   Java source line #138	-> byte code offset #172
    //   Java source line #108	-> byte code offset #233
    //   Java source line #86	-> byte code offset #275
    //   Java source line #64	-> byte code offset #339
    //   Java source line #60	-> byte code offset #384
    //   Java source line #52	-> byte code offset #429
    //   Java source line #48	-> byte code offset #474
  }
  
  /* Error */
  public int match3(gnu.expr.ModuleMethod arg1, Object arg2, Object arg3, Object arg4, gnu.mapping.CallContext arg5)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 501	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+464->468, 11:+390->394, 15:+341->345, 17:+292->296, 18:+243->247, 22:+175->179, 24:+142->146, 31:+109->113, 33:+76->80
    //   80: aload 5
    //   82: aload_2
    //   83: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   86: aload 5
    //   88: aload_3
    //   89: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   92: aload 5
    //   94: aload 4
    //   96: putfield 540	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   99: aload 5
    //   101: aload_1
    //   102: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   105: aload 5
    //   107: iconst_3
    //   108: putfield 507	gnu/mapping/CallContext:pc	I
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 5
    //   115: aload_2
    //   116: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   119: aload 5
    //   121: aload_3
    //   122: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   125: aload 5
    //   127: aload 4
    //   129: putfield 540	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   132: aload 5
    //   134: aload_1
    //   135: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   138: aload 5
    //   140: iconst_3
    //   141: putfield 507	gnu/mapping/CallContext:pc	I
    //   144: iconst_0
    //   145: ireturn
    //   146: aload 5
    //   148: aload_2
    //   149: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   152: aload 5
    //   154: aload_3
    //   155: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   158: aload 5
    //   160: aload 4
    //   162: putfield 540	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   165: aload 5
    //   167: aload_1
    //   168: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   171: aload 5
    //   173: iconst_3
    //   174: putfield 507	gnu/mapping/CallContext:pc	I
    //   177: iconst_0
    //   178: ireturn
    //   179: aload 5
    //   181: aload_2
    //   182: ldc 66
    //   184: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   187: dup
    //   188: instanceof 66
    //   191: ifne +7 -> 198
    //   194: ldc_w 512
    //   197: ireturn
    //   198: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   201: aload 5
    //   203: aload_3
    //   204: ldc 120
    //   206: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   209: dup
    //   210: invokestatic 519	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   213: ifnull +6 -> 219
    //   216: goto +7 -> 223
    //   219: ldc_w 526
    //   222: ireturn
    //   223: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   226: aload 5
    //   228: aload 4
    //   230: putfield 540	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   233: aload 5
    //   235: aload_1
    //   236: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   239: aload 5
    //   241: iconst_3
    //   242: putfield 507	gnu/mapping/CallContext:pc	I
    //   245: iconst_0
    //   246: ireturn
    //   247: aload 5
    //   249: aload_2
    //   250: ldc 66
    //   252: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   255: dup
    //   256: instanceof 66
    //   259: ifne +7 -> 266
    //   262: ldc_w 512
    //   265: ireturn
    //   266: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   269: aload 5
    //   271: aload_3
    //   272: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   275: aload 5
    //   277: aload 4
    //   279: putfield 540	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   282: aload 5
    //   284: aload_1
    //   285: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   288: aload 5
    //   290: iconst_3
    //   291: putfield 507	gnu/mapping/CallContext:pc	I
    //   294: iconst_0
    //   295: ireturn
    //   296: aload 5
    //   298: aload_2
    //   299: ldc 66
    //   301: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   304: dup
    //   305: instanceof 66
    //   308: ifne +7 -> 315
    //   311: ldc_w 512
    //   314: ireturn
    //   315: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   318: aload 5
    //   320: aload_3
    //   321: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   324: aload 5
    //   326: aload 4
    //   328: putfield 540	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   331: aload 5
    //   333: aload_1
    //   334: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   337: aload 5
    //   339: iconst_3
    //   340: putfield 507	gnu/mapping/CallContext:pc	I
    //   343: iconst_0
    //   344: ireturn
    //   345: aload 5
    //   347: aload_2
    //   348: ldc 66
    //   350: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   353: dup
    //   354: instanceof 66
    //   357: ifne +7 -> 364
    //   360: ldc_w 512
    //   363: ireturn
    //   364: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   367: aload 5
    //   369: aload_3
    //   370: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   373: aload 5
    //   375: aload 4
    //   377: putfield 540	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   380: aload 5
    //   382: aload_1
    //   383: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   386: aload 5
    //   388: iconst_3
    //   389: putfield 507	gnu/mapping/CallContext:pc	I
    //   392: iconst_0
    //   393: ireturn
    //   394: aload 5
    //   396: aload_2
    //   397: ldc 120
    //   399: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   402: dup
    //   403: invokestatic 519	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   406: ifnull +6 -> 412
    //   409: goto +7 -> 416
    //   412: ldc_w 512
    //   415: ireturn
    //   416: putfield 516	gnu/mapping/CallContext:value1	Ljava/lang/Object;
    //   419: aload 5
    //   421: aload_3
    //   422: ldc 120
    //   424: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   427: dup
    //   428: invokestatic 519	gnu/kawa/lispexpr/LangObjType:coerceToProcedureOrNull	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   431: ifnull +6 -> 437
    //   434: goto +7 -> 441
    //   437: ldc_w 526
    //   440: ireturn
    //   441: putfield 529	gnu/mapping/CallContext:value2	Ljava/lang/Object;
    //   444: aload 5
    //   446: aload 4
    //   448: invokestatic 233	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   451: putfield 540	gnu/mapping/CallContext:value3	Ljava/lang/Object;
    //   454: aload 5
    //   456: aload_1
    //   457: putfield 504	gnu/mapping/CallContext:proc	Lgnu/mapping/Procedure;
    //   460: aload 5
    //   462: iconst_3
    //   463: putfield 507	gnu/mapping/CallContext:pc	I
    //   466: iconst_0
    //   467: ireturn
    //   468: aload_0
    //   469: aload_1
    //   470: aload_2
    //   471: aload_3
    //   472: aload 4
    //   474: aload 5
    //   476: invokespecial 544	gnu/expr/ModuleBody:match3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    //   479: ireturn
    // Line number table:
    //   Java source line #178	-> byte code offset #80
    //   Java source line #175	-> byte code offset #113
    //   Java source line #148	-> byte code offset #146
    //   Java source line #143	-> byte code offset #179
    //   Java source line #121	-> byte code offset #247
    //   Java source line #117	-> byte code offset #296
    //   Java source line #108	-> byte code offset #345
    //   Java source line #86	-> byte code offset #394
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
    //   1: getfield 501	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+241->245, 1:+84->88, 3:+107->111, 5:+121->125, 7:+135->139, 11:+149->153, 15:+171->175, 21:+185->189, 24:+210->214, 30:+216->220
    //   88: aload_2
    //   89: ldc_w 521
    //   92: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: checkcast 521	java/lang/CharSequence
    //   98: aload_3
    //   99: ldc 25
    //   101: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   104: invokestatic 617	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   107: invokestatic 17	gnu/kawa/slib/srfi69:stringHash	(Ljava/lang/CharSequence;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   110: areturn
    //   111: aload_2
    //   112: aload_3
    //   113: ldc 25
    //   115: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   118: invokestatic 617	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   121: invokestatic 37	gnu/kawa/slib/srfi69:stringCiHash	(Ljava/lang/Object;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   124: areturn
    //   125: aload_2
    //   126: aload_3
    //   127: ldc 25
    //   129: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   132: invokestatic 617	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   135: invokestatic 50	gnu/kawa/slib/srfi69:hash	(Ljava/lang/Object;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   138: areturn
    //   139: aload_2
    //   140: aload_3
    //   141: ldc 25
    //   143: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   146: invokestatic 617	gnu/kawa/lispexpr/LangObjType:coerceIntNum	(Ljava/lang/Object;)Lgnu/math/IntNum;
    //   149: invokestatic 59	gnu/kawa/slib/srfi69:hashByIdentity	(Ljava/lang/Object;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    //   152: areturn
    //   153: aload_2
    //   154: ldc 120
    //   156: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   159: invokestatic 222	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   162: aload_3
    //   163: ldc 120
    //   165: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   168: invokestatic 222	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   171: invokestatic 625	gnu/kawa/slib/srfi69:makeHashTable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
    //   174: areturn
    //   175: aload_2
    //   176: ldc 66
    //   178: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   181: checkcast 66	kawa/lib/kawa/hashtable$HashTable
    //   184: aload_3
    //   185: invokestatic 630	gnu/kawa/slib/srfi69:hashTableRef	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: areturn
    //   189: aload_2
    //   190: ldc 66
    //   192: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   195: checkcast 66	kawa/lib/kawa/hashtable$HashTable
    //   198: aload_3
    //   199: ldc 120
    //   201: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   204: invokestatic 222	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   207: invokestatic 636	gnu/kawa/slib/srfi69:hashTableWalk	(Lkawa/lib/kawa/hashtable$HashTable;Lgnu/mapping/Procedure;)V
    //   210: getstatic 642	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   213: areturn
    //   214: aload_2
    //   215: aload_3
    //   216: invokestatic 184	gnu/kawa/slib/srfi69:alist$To$HashTable	(Ljava/lang/Object;Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
    //   219: areturn
    //   220: aload_2
    //   221: ldc 66
    //   223: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   226: checkcast 66	kawa/lib/kawa/hashtable$HashTable
    //   229: aload_3
    //   230: ldc 66
    //   232: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   235: checkcast 66	kawa/lib/kawa/hashtable$HashTable
    //   238: invokestatic 648	gnu/kawa/slib/srfi69:hashTableMerge$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Lkawa/lib/kawa/hashtable$HashTable;)V
    //   241: getstatic 642	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   244: areturn
    //   245: aload_0
    //   246: aload_1
    //   247: aload_2
    //   248: aload_3
    //   249: invokespecial 651	gnu/expr/ModuleBody:apply2	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: areturn
    //   253: new 226	gnu/mapping/WrongType
    //   256: dup_x1
    //   257: swap
    //   258: ldc_w 563
    //   261: iconst_1
    //   262: aload_2
    //   263: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   266: athrow
    //   267: new 226	gnu/mapping/WrongType
    //   270: dup_x1
    //   271: swap
    //   272: ldc_w 563
    //   275: iconst_2
    //   276: aload_3
    //   277: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   280: athrow
    //   281: new 226	gnu/mapping/WrongType
    //   284: dup_x1
    //   285: swap
    //   286: ldc_w 619
    //   289: iconst_2
    //   290: aload_3
    //   291: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   294: athrow
    //   295: new 226	gnu/mapping/WrongType
    //   298: dup_x1
    //   299: swap
    //   300: ldc_w 620
    //   303: iconst_2
    //   304: aload_3
    //   305: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   308: athrow
    //   309: new 226	gnu/mapping/WrongType
    //   312: dup_x1
    //   313: swap
    //   314: ldc_w 622
    //   317: iconst_2
    //   318: aload_3
    //   319: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   322: athrow
    //   323: new 226	gnu/mapping/WrongType
    //   326: dup_x1
    //   327: swap
    //   328: ldc -28
    //   330: iconst_1
    //   331: aload_2
    //   332: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   335: athrow
    //   336: new 226	gnu/mapping/WrongType
    //   339: dup_x1
    //   340: swap
    //   341: ldc -28
    //   343: iconst_2
    //   344: aload_3
    //   345: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   348: athrow
    //   349: new 226	gnu/mapping/WrongType
    //   352: dup_x1
    //   353: swap
    //   354: ldc_w 627
    //   357: iconst_1
    //   358: aload_2
    //   359: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   362: athrow
    //   363: new 226	gnu/mapping/WrongType
    //   366: dup_x1
    //   367: swap
    //   368: ldc_w 632
    //   371: iconst_1
    //   372: aload_2
    //   373: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   376: athrow
    //   377: new 226	gnu/mapping/WrongType
    //   380: dup_x1
    //   381: swap
    //   382: ldc_w 632
    //   385: iconst_2
    //   386: aload_3
    //   387: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   390: athrow
    //   391: new 226	gnu/mapping/WrongType
    //   394: dup_x1
    //   395: swap
    //   396: ldc_w 644
    //   399: iconst_1
    //   400: aload_2
    //   401: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   404: athrow
    //   405: new 226	gnu/mapping/WrongType
    //   408: dup_x1
    //   409: swap
    //   410: ldc_w 644
    //   413: iconst_2
    //   414: aload_3
    //   415: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   418: athrow
    // Line number table:
    //   Java source line #48	-> byte code offset #88
    //   Java source line #52	-> byte code offset #111
    //   Java source line #60	-> byte code offset #125
    //   Java source line #64	-> byte code offset #139
    //   Java source line #86	-> byte code offset #153
    //   Java source line #108	-> byte code offset #175
    //   Java source line #138	-> byte code offset #189
    //   Java source line #148	-> byte code offset #214
    //   Java source line #168	-> byte code offset #220
    //   Java source line #48	-> byte code offset #253
    //   Java source line #52	-> byte code offset #281
    //   Java source line #60	-> byte code offset #295
    //   Java source line #64	-> byte code offset #309
    //   Java source line #87	-> byte code offset #323
    //   Java source line #88	-> byte code offset #336
    //   Java source line #108	-> byte code offset #349
    //   Java source line #138	-> byte code offset #363
    //   Java source line #139	-> byte code offset #377
    //   Java source line #168	-> byte code offset #391
    //   Java source line #169	-> byte code offset #405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	srfi69
    //   0	419	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	419	2	paramObject1	Object
    //   0	419	3	paramObject2	Object
    //   253	1	4	localClassCastException1	ClassCastException
    //   267	1	5	localClassCastException2	ClassCastException
    //   281	1	6	localClassCastException3	ClassCastException
    //   295	1	7	localClassCastException4	ClassCastException
    //   309	1	8	localClassCastException5	ClassCastException
    //   323	1	9	localClassCastException6	ClassCastException
    //   336	1	10	localClassCastException7	ClassCastException
    //   349	1	11	localClassCastException8	ClassCastException
    //   363	1	12	localClassCastException9	ClassCastException
    //   377	1	13	localClassCastException10	ClassCastException
    //   391	1	14	localClassCastException11	ClassCastException
    //   405	1	15	localClassCastException12	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   95	98	253	java/lang/ClassCastException
    //   104	107	267	java/lang/ClassCastException
    //   118	121	281	java/lang/ClassCastException
    //   132	135	295	java/lang/ClassCastException
    //   146	149	309	java/lang/ClassCastException
    //   159	162	323	java/lang/ClassCastException
    //   168	171	336	java/lang/ClassCastException
    //   181	184	349	java/lang/ClassCastException
    //   195	198	363	java/lang/ClassCastException
    //   204	207	377	java/lang/ClassCastException
    //   226	229	391	java/lang/ClassCastException
    //   235	238	405	java/lang/ClassCastException
  }
  
  /* Error */
  public Object apply3(gnu.expr.ModuleMethod paramModuleMethod, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 501	gnu/expr/ModuleMethod:selector	I
    //   4: lookupswitch	default:+208->212, 11:+76->80, 15:+109->113, 17:+125->129, 18:+141->145, 22:+160->164, 24:+184->188, 31:+192->196, 33:+200->204
    //   80: aload_2
    //   81: ldc 120
    //   83: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   86: invokestatic 222	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   89: aload_3
    //   90: ldc 120
    //   92: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   95: invokestatic 222	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   98: aload 4
    //   100: invokestatic 233	gnu/mapping/Promise:force	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast 235	java/lang/Number
    //   106: invokevirtual 238	java/lang/Number:intValue	()I
    //   109: invokestatic 90	gnu/kawa/slib/srfi69:makeHashTable	(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
    //   112: areturn
    //   113: aload_2
    //   114: ldc 66
    //   116: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   119: checkcast 66	kawa/lib/kawa/hashtable$HashTable
    //   122: aload_3
    //   123: aload 4
    //   125: invokestatic 104	gnu/kawa/slib/srfi69:hashTableRef	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: areturn
    //   129: aload_2
    //   130: ldc 66
    //   132: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   135: checkcast 66	kawa/lib/kawa/hashtable$HashTable
    //   138: aload_3
    //   139: aload 4
    //   141: invokestatic 656	gnu/kawa/slib/srfi69:hashTableRef$SlDefault	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: areturn
    //   145: aload_2
    //   146: ldc 66
    //   148: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   151: checkcast 66	kawa/lib/kawa/hashtable$HashTable
    //   154: aload_3
    //   155: aload 4
    //   157: invokestatic 660	gnu/kawa/slib/srfi69:hashTableUpdate$Ex	(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)V
    //   160: getstatic 642	gnu/mapping/Values:empty	Lgnu/mapping/Values;
    //   163: areturn
    //   164: aload_2
    //   165: ldc 66
    //   167: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   170: checkcast 66	kawa/lib/kawa/hashtable$HashTable
    //   173: aload_3
    //   174: ldc 120
    //   176: invokestatic 217	gnu/mapping/Promise:force	(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   179: invokestatic 222	gnu/kawa/lispexpr/LangObjType:coerceToProcedure	(Ljava/lang/Object;)Lgnu/mapping/Procedure;
    //   182: aload 4
    //   184: invokestatic 297	gnu/kawa/slib/srfi69:hashTableFold	(Lkawa/lib/kawa/hashtable$HashTable;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: areturn
    //   188: aload_2
    //   189: aload_3
    //   190: aload 4
    //   192: invokestatic 187	gnu/kawa/slib/srfi69:alist$To$HashTable	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
    //   195: areturn
    //   196: aload_2
    //   197: aload_3
    //   198: aload 4
    //   200: invokestatic 666	gnu/kawa/slib/srfi69:lambda2	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   203: areturn
    //   204: aload_2
    //   205: aload_3
    //   206: aload 4
    //   208: invokestatic 669	gnu/kawa/slib/srfi69:lambda3	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
    //   211: areturn
    //   212: aload_0
    //   213: aload_1
    //   214: aload_2
    //   215: aload_3
    //   216: aload 4
    //   218: invokespecial 673	gnu/expr/ModuleBody:apply3	(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   221: areturn
    //   222: new 226	gnu/mapping/WrongType
    //   225: dup_x1
    //   226: swap
    //   227: ldc -28
    //   229: iconst_1
    //   230: aload_2
    //   231: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   234: athrow
    //   235: new 226	gnu/mapping/WrongType
    //   238: dup_x1
    //   239: swap
    //   240: ldc -28
    //   242: iconst_2
    //   243: aload_3
    //   244: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   247: athrow
    //   248: new 226	gnu/mapping/WrongType
    //   251: dup_x1
    //   252: swap
    //   253: ldc -28
    //   255: iconst_3
    //   256: aload 4
    //   258: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   261: athrow
    //   262: new 226	gnu/mapping/WrongType
    //   265: dup_x1
    //   266: swap
    //   267: ldc_w 627
    //   270: iconst_1
    //   271: aload_2
    //   272: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   275: athrow
    //   276: new 226	gnu/mapping/WrongType
    //   279: dup_x1
    //   280: swap
    //   281: ldc_w 653
    //   284: iconst_1
    //   285: aload_2
    //   286: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   289: athrow
    //   290: new 226	gnu/mapping/WrongType
    //   293: dup_x1
    //   294: swap
    //   295: ldc_w 658
    //   298: iconst_1
    //   299: aload_2
    //   300: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   303: athrow
    //   304: new 226	gnu/mapping/WrongType
    //   307: dup_x1
    //   308: swap
    //   309: ldc_w 662
    //   312: iconst_1
    //   313: aload_2
    //   314: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   317: athrow
    //   318: new 226	gnu/mapping/WrongType
    //   321: dup_x1
    //   322: swap
    //   323: ldc_w 662
    //   326: iconst_2
    //   327: aload_3
    //   328: invokespecial 231	gnu/mapping/WrongType:<init>	(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
    //   331: athrow
    // Line number table:
    //   Java source line #86	-> byte code offset #80
    //   Java source line #108	-> byte code offset #113
    //   Java source line #117	-> byte code offset #129
    //   Java source line #121	-> byte code offset #145
    //   Java source line #143	-> byte code offset #164
    //   Java source line #148	-> byte code offset #188
    //   Java source line #175	-> byte code offset #196
    //   Java source line #178	-> byte code offset #204
    //   Java source line #87	-> byte code offset #222
    //   Java source line #88	-> byte code offset #235
    //   Java source line #90	-> byte code offset #248
    //   Java source line #108	-> byte code offset #262
    //   Java source line #117	-> byte code offset #276
    //   Java source line #121	-> byte code offset #290
    //   Java source line #143	-> byte code offset #304
    //   Java source line #144	-> byte code offset #318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	srfi69
    //   0	332	1	paramModuleMethod	gnu.expr.ModuleMethod
    //   0	332	2	paramObject1	Object
    //   0	332	3	paramObject2	Object
    //   0	332	4	paramObject3	Object
    //   222	1	5	localClassCastException1	ClassCastException
    //   235	1	6	localClassCastException2	ClassCastException
    //   248	1	7	localClassCastException3	ClassCastException
    //   262	1	8	localClassCastException4	ClassCastException
    //   276	1	9	localClassCastException5	ClassCastException
    //   290	1	10	localClassCastException6	ClassCastException
    //   304	1	11	localClassCastException7	ClassCastException
    //   318	1	12	localClassCastException8	ClassCastException
    // Exception table:
    //   from	to	target	type
    //   86	89	222	java/lang/ClassCastException
    //   95	98	235	java/lang/ClassCastException
    //   103	109	248	java/lang/ClassCastException
    //   119	122	262	java/lang/ClassCastException
    //   135	138	276	java/lang/ClassCastException
    //   151	154	290	java/lang/ClassCastException
    //   170	173	304	java/lang/ClassCastException
    //   179	182	318	java/lang/ClassCastException
  }
}
