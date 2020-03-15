// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import kawa.lib.lists;
import gnu.lists.Pair;
import gnu.lists.LList;
import kawa.lib.numbers;
import gnu.lists.Sequences;
import kawa.lib.rnrs.hashtables;
import gnu.kawa.util.HashNode;
import gnu.expr.Special;
import kawa.lib.exceptions;
import kawa.lib.strings;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Promise;
import gnu.expr.KawaConvert;
import kawa.standard.Scheme;
import gnu.mapping.Procedure;
import kawa.lib.kawa.hashtable;
import gnu.kawa.util.HashUtils;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class srfi69 extends ModuleBody
{
    public static final int $Pcprovide$Pcsrfi$Mn69 = 123;
    public static final int $Pcprovide$Pchash$Mntable = 123;
    public static final ModuleMethod make$Mnhash$Mntable;
    public static final StaticFieldLocation hash$Mntable$Qu;
    public static final ModuleMethod alist$Mn$Grhash$Mntable;
    public static final ModuleMethod hash$Mntable$Mnequivalence$Mnfunction;
    public static final ModuleMethod hash$Mntable$Mnhash$Mnfunction;
    public static final ModuleMethod hash$Mntable$Mnref;
    public static final ModuleMethod hash$Mntable$Mnref$Sldefault;
    public static final StaticFieldLocation hash$Mntable$Mnset$Ex;
    public static final StaticFieldLocation hash$Mntable$Mndelete$Ex;
    public static final StaticFieldLocation hash$Mntable$Mnexists$Qu;
    public static final ModuleMethod hash$Mntable$Mnupdate$Ex;
    public static final ModuleMethod hash$Mntable$Mnupdate$Ex$Sldefault;
    public static final StaticFieldLocation hash$Mntable$Mnsize;
    public static final ModuleMethod hash$Mntable$Mnkeys;
    public static final ModuleMethod hash$Mntable$Mnvalues;
    public static final ModuleMethod hash$Mntable$Mnwalk;
    public static final ModuleMethod hash$Mntable$Mnfold;
    public static final ModuleMethod hash$Mntable$Mn$Gralist;
    public static final ModuleMethod hash$Mntable$Mncopy;
    public static final ModuleMethod hash$Mntable$Mnmerge$Ex;
    public static final ModuleMethod hash;
    public static final ModuleMethod string$Mnhash;
    public static final ModuleMethod string$Mnci$Mnhash;
    public static final ModuleMethod hash$Mnby$Mnidentity;
    static final IntNum Lit0;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn3;
    public static srfi69 $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static IntNum stringHash(final CharSequence s) {
        return stringHash(s, null);
    }
    
    public static IntNum stringHash(final CharSequence s, final IntNum bound) {
        final int h = s.hashCode();
        return (bound == null) ? IntNum.make(h) : IntNum.modulo(IntNum.make(h), bound);
    }
    
    public static IntNum stringCiHash(final Object s) {
        return stringCiHash(s, null);
    }
    
    public static IntNum stringCiHash(final Object s, final IntNum bound) {
        final int h = s.toString().toLowerCase().hashCode();
        return (bound == null) ? IntNum.make(h) : IntNum.modulo(IntNum.make(h), bound);
    }
    
    public static IntNum hash(final Object obj) {
        return hash(obj, null);
    }
    
    public static IntNum hash(final Object obj, final IntNum bound) {
        final int h = HashUtils.boundedHash(obj);
        return (bound == null) ? IntNum.make(h) : IntNum.modulo(IntNum.make(h), bound);
    }
    
    public static IntNum hashByIdentity(final Object obj) {
        return hashByIdentity(obj, null);
    }
    
    public static IntNum hashByIdentity(final Object obj, final IntNum bound) {
        final int h = System.identityHashCode(obj);
        return (bound == null) ? IntNum.make(h) : IntNum.modulo(IntNum.make(h), bound);
    }
    
    public static Procedure hashTableEquivalenceFunction(final hashtable.HashTable hash$Mntable) {
        return hash$Mntable.equivalenceFunction;
    }
    
    public static Procedure hashTableHashFunction(final hashtable.HashTable hash$Mntable) {
        return hash$Mntable.hashFunction;
    }
    
    public static hashtable.HashTable makeHashTable() {
        return makeHashTable(Scheme.isEqual);
    }
    
    public static hashtable.HashTable makeHashTable(final Procedure procedure) {
        return makeHashTable(procedure, appropriateHashFunctionFor(procedure), 64);
    }
    
    public static hashtable.HashTable makeHashTable(final Procedure comparison, final Procedure hash) {
        return makeHashTable(comparison, hash, 64);
    }
    
    public static hashtable.HashTable makeHashTable(final Procedure comparison, final Procedure hash, final int size) {
        return new hashtable.HashTable(comparison, hash, size);
    }
    
    static Procedure appropriateHashFunctionFor(final Object comparison) {
        final Object x = (comparison == Scheme.isEq) ? srfi69.hash$Mnby$Mnidentity : Boolean.FALSE;
        Procedure procedure;
        if (KawaConvert.isTrue(x)) {
            procedure = LangObjType.coerceToProcedure(Promise.force(x, Procedure.class));
        }
        else {
            final Object x2 = (comparison == strings.string$Eq$Qu) ? srfi69.string$Mnhash : Boolean.FALSE;
            if (KawaConvert.isTrue(x2)) {
                procedure = LangObjType.coerceToProcedure(Promise.force(x2, Procedure.class));
            }
            else {
                final Object x3 = (comparison == strings.string$Mnci$Eq$Qu) ? srfi69.string$Mnci$Mnhash : Boolean.FALSE;
                procedure = (KawaConvert.isTrue(x3) ? LangObjType.coerceToProcedure(Promise.force(x3, Procedure.class)) : srfi69.hash);
            }
        }
        return procedure;
    }
    
    public static Object hashTableRef(final hashtable.HashTable hash$Mntable, final Object key) {
        return hashTableRef(hash$Mntable, key, Boolean.FALSE);
    }
    
    public static Object hashTableRef(final hashtable.HashTable hash$Mntable, final Object key, final Object default) {
        final HashNode node = hash$Mntable.getNode(key);
        Object o;
        if (node == null) {
            if (!KawaConvert.isTrue(default)) {
                exceptions.error("hash-table-ref: no value associated with", key);
                throw Special.reachedUnexpected;
            }
            o = Scheme.applyToArgs.apply1(default);
        }
        else {
            o = node.getValue();
        }
        return o;
    }
    
    public static Object hashTableRef$SlDefault(final hashtable.HashTable hash$Mntable, final Object key, final Object default) {
        return hash$Mntable.get(key, default);
    }
    
    public static void hashTableUpdate$Ex(final hashtable.HashTable hash$Mntable, final Object key, final Object function) {
        hashTableUpdate$Ex(hash$Mntable, key, function, Boolean.FALSE);
    }
    
    public static void hashTableUpdate$Ex(final hashtable.HashTable hash$Mntable, final Object key, final Object function, final Object thunk) {
        hashtable.hashtableCheckMutable(hash$Mntable);
        final HashNode node = hash$Mntable.getNode(key);
        if (node == null) {
            if (!KawaConvert.isTrue(thunk)) {
                exceptions.error("hash-table-update!: no value exists for key", key);
                throw Special.reachedUnexpected;
            }
            hashtables.hashtableSet$Ex(hash$Mntable, key, Scheme.applyToArgs.apply2(function, Scheme.applyToArgs.apply1(thunk)));
        }
        else {
            node.setValue(Scheme.applyToArgs.apply2(function, node.getValue()));
        }
    }
    
    public static void hashTableUpdate$Ex$SlDefault(final hashtable.HashTable hash$Mntable, final Object key, final Object function, final Object default) {
        hashtable.hashtableCheckMutable(hash$Mntable);
        final HashNode node = hash$Mntable.getNode(key);
        if (node == null) {
            hashtables.hashtableSet$Ex(hash$Mntable, key, Scheme.applyToArgs.apply2(function, default));
        }
        else {
            node.setValue(Scheme.applyToArgs.apply2(function, node.getValue()));
        }
    }
    
    public static void hashTableWalk(final hashtable.HashTable hash$Mntable, final Procedure proc) {
        hash$Mntable.walk(proc);
    }
    
    public static Object hashTableFold(final hashtable.HashTable hash$Mntable, final Procedure proc, final Object acc) {
        return hash$Mntable.fold(proc, acc);
    }
    
    public static hashtable.HashTable alist$To$HashTable(final Object o) {
        return alist$To$HashTable(o, Scheme.isEqual);
    }
    
    public static hashtable.HashTable alist$To$HashTable(final Object o, final Object comparison) {
        return alist$To$HashTable(o, comparison, appropriateHashFunctionFor(comparison));
    }
    
    public static hashtable.HashTable alist$To$HashTable(final Object o, final Object comparison, final Object hash) {
        return alist$To$HashTable(o, comparison, hash, numbers.max(srfi69.Lit0, 2 * Sequences.getSize(o)));
    }
    
    public static hashtable.HashTable alist$To$HashTable(final Object alist, final Object comparison, final Object hash, final Object size) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/mapping/Procedure;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          5
        //     9: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    12: aload_2         /* hash */
        //    13: ldc             Lgnu/mapping/Procedure;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: dup            
        //    19: astore          5
        //    21: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    24: aload_3         /* size */
        //    25: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    28: dup            
        //    29: astore          5
        //    31: checkcast       Ljava/lang/Number;
        //    34: invokevirtual   java/lang/Number.intValue:()I
        //    37: invokestatic    gnu/kawa/slib/srfi69.makeHashTable:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
        //    40: astore          hash$Mntable
        //    42: aload_0         /* alist */
        //    43: invokestatic    gnu/lists/Sequences.getIterator:(Ljava/lang/Object;)Ljava/util/Iterator;
        //    46: astore          5
        //    48: aload           5
        //    50: invokeinterface java/util/Iterator.hasNext:()Z
        //    55: ifeq            110
        //    58: aload           5
        //    60: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    65: astore          6
        //    67: aload           hash$Mntable
        //    69: aload           6
        //    71: ldc             Lgnu/lists/Pair;.class
        //    73: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    76: dup            
        //    77: astore          7
        //    79: checkcast       Lgnu/lists/Pair;
        //    82: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    85: getstatic       gnu/kawa/slib/srfi69.lambda$Fn1:Lgnu/expr/ModuleMethod;
        //    88: aload           6
        //    90: ldc             Lgnu/lists/Pair;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: dup            
        //    96: astore          7
        //    98: checkcast       Lgnu/lists/Pair;
        //   101: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   104: invokestatic    gnu/kawa/slib/srfi69.hashTableUpdate$Ex$SlDefault:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   107: goto            48
        //   110: aload           hash$Mntable
        //   112: areturn        
        //   113: new             Lgnu/mapping/WrongType;
        //   116: dup_x1         
        //   117: swap           
        //   118: ldc             "make-hash-table"
        //   120: iconst_0       
        //   121: aload           5
        //   123: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   126: athrow         
        //   127: new             Lgnu/mapping/WrongType;
        //   130: dup_x1         
        //   131: swap           
        //   132: ldc             "make-hash-table"
        //   134: iconst_1       
        //   135: aload           5
        //   137: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   140: athrow         
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc             "make-hash-table"
        //   148: iconst_2       
        //   149: aload           5
        //   151: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   154: athrow         
        //   155: new             Lgnu/mapping/WrongType;
        //   158: dup_x1         
        //   159: swap           
        //   160: ldc             "car"
        //   162: iconst_1       
        //   163: aload           7
        //   165: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   168: athrow         
        //   169: new             Lgnu/mapping/WrongType;
        //   172: dup_x1         
        //   173: swap           
        //   174: ldc_w           "cdr"
        //   177: iconst_1       
        //   178: aload           7
        //   180: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   183: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  9      12     113    127    Ljava/lang/ClassCastException;
        //  21     24     127    141    Ljava/lang/ClassCastException;
        //  31     37     141    155    Ljava/lang/ClassCastException;
        //  79     82     155    169    Ljava/lang/ClassCastException;
        //  98     101    169    184    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 89 out of bounds for length 89
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object lambda1(final Object x) {
        return x;
    }
    
    public static Object hashTable$To$Alist(final hashtable.HashTable hash$Mntable) {
        return hash$Mntable.toAlist();
    }
    
    public static hashtable.HashTable hashTableCopy(final hashtable.HashTable hash$Mntable) {
        return new hashtable.HashTable(hash$Mntable, true);
    }
    
    public static void hashTableMerge$Ex(final hashtable.HashTable hash$Mntable1, final hashtable.HashTable hash$Mntable2) {
        hash$Mntable1.putAll(hash$Mntable2);
    }
    
    public static Object hashTableKeys(final hashtable.HashTable hash$Mntable) {
        return hashTableFold(hash$Mntable, srfi69.lambda$Fn2, LList.Empty);
    }
    
    static Pair lambda2(final Object key, final Object val, final Object acc) {
        return lists.cons(key, acc);
    }
    
    public static Object hashTableValues(final hashtable.HashTable hash$Mntable) {
        return hashTableFold(hash$Mntable, srfi69.lambda$Fn3, LList.Empty);
    }
    
    static Pair lambda3(final Object key, final Object val, final Object acc) {
        return lists.cons(val, acc);
    }
    
    static {
        Lit19 = Symbol.valueOf("hash-table-values");
        Lit18 = Symbol.valueOf("hash-table-keys");
        Lit17 = Symbol.valueOf("hash-table-merge!");
        Lit16 = Symbol.valueOf("hash-table-copy");
        Lit15 = Symbol.valueOf("hash-table->alist");
        Lit14 = Symbol.valueOf("alist->hash-table");
        Lit13 = Symbol.valueOf("hash-table-fold");
        Lit12 = Symbol.valueOf("hash-table-walk");
        Lit11 = Symbol.valueOf("hash-table-update!/default");
        Lit10 = Symbol.valueOf("hash-table-update!");
        Lit9 = Symbol.valueOf("hash-table-ref/default");
        Lit8 = Symbol.valueOf("hash-table-ref");
        Lit7 = Symbol.valueOf("make-hash-table");
        Lit6 = Symbol.valueOf("hash-table-hash-function");
        Lit5 = Symbol.valueOf("hash-table-equivalence-function");
        Lit4 = Symbol.valueOf("hash-by-identity");
        Lit3 = Symbol.valueOf("hash");
        Lit2 = Symbol.valueOf("string-ci-hash");
        Lit1 = Symbol.valueOf("string-hash");
        Lit0 = IntNum.valueOf(64);
        srfi69.$instance = new srfi69();
        hash$Mntable$Mndelete$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mndelete$Ex");
        hash$Mntable$Mnexists$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mncontains$Qu");
        hash$Mntable$Mnset$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnset$Ex");
        hash$Mntable$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Qu");
        hash$Mntable$Mnsize = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnsize");
        final srfi69 $instance = srfi69.$instance;
        string$Mnhash = new ModuleMethod($instance, 1, srfi69.Lit1, 8193);
        string$Mnci$Mnhash = new ModuleMethod($instance, 3, srfi69.Lit2, 8193);
        hash = new ModuleMethod($instance, 5, srfi69.Lit3, 8193);
        hash$Mnby$Mnidentity = new ModuleMethod($instance, 7, srfi69.Lit4, 8193);
        hash$Mntable$Mnequivalence$Mnfunction = new ModuleMethod($instance, 9, srfi69.Lit5, 4097);
        hash$Mntable$Mnhash$Mnfunction = new ModuleMethod($instance, 10, srfi69.Lit6, 4097);
        make$Mnhash$Mntable = new ModuleMethod($instance, 11, srfi69.Lit7, 12288);
        hash$Mntable$Mnref = new ModuleMethod($instance, 15, srfi69.Lit8, 12290);
        hash$Mntable$Mnref$Sldefault = new ModuleMethod($instance, 17, srfi69.Lit9, 12291);
        hash$Mntable$Mnupdate$Ex = new ModuleMethod($instance, 18, srfi69.Lit10, 16387);
        hash$Mntable$Mnupdate$Ex$Sldefault = new ModuleMethod($instance, 20, srfi69.Lit11, 16388);
        hash$Mntable$Mnwalk = new ModuleMethod($instance, 21, srfi69.Lit12, 8194);
        hash$Mntable$Mnfold = new ModuleMethod($instance, 22, srfi69.Lit13, 12291);
        final ModuleMethod lambda$Fn4 = new ModuleMethod($instance, 23, null, 4097);
        lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:158");
        lambda$Fn1 = lambda$Fn4;
        alist$Mn$Grhash$Mntable = new ModuleMethod($instance, 24, srfi69.Lit14, 16385);
        hash$Mntable$Mn$Gralist = new ModuleMethod($instance, 28, srfi69.Lit15, 4097);
        hash$Mntable$Mncopy = new ModuleMethod($instance, 29, srfi69.Lit16, 4097);
        hash$Mntable$Mnmerge$Ex = new ModuleMethod($instance, 30, srfi69.Lit17, 8194);
        final ModuleMethod lambda$Fn5 = new ModuleMethod($instance, 31, null, 12291);
        lambda$Fn5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:175");
        lambda$Fn2 = lambda$Fn5;
        hash$Mntable$Mnkeys = new ModuleMethod($instance, 32, srfi69.Lit18, 4097);
        final ModuleMethod lambda$Fn6 = new ModuleMethod($instance, 33, null, 12291);
        lambda$Fn6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:178");
        lambda$Fn3 = lambda$Fn6;
        hash$Mntable$Mnvalues = new ModuleMethod($instance, 34, srfi69.Lit19, 4097);
        $runBody$();
    }
    
    public srfi69() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        if (moduleMethod.selector == 11) {
            ctx.proc = moduleMethod;
            return ctx.pc = 0;
        }
        return super.match0(moduleMethod, ctx);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 34: {
                final Object force = Promise.force(o, hashtable.HashTable.class);
                if (!(force instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 32: {
                final Object force2 = Promise.force(o, hashtable.HashTable.class);
                if (!(force2 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 29: {
                final Object force3 = Promise.force(o, hashtable.HashTable.class);
                if (!(force3 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 28: {
                final Object force4 = Promise.force(o, hashtable.HashTable.class);
                if (!(force4 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 24: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 23: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 11: {
                final Object force5 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force5) != null) {
                    ctx.value1 = force5;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 10: {
                final Object force6 = Promise.force(o, hashtable.HashTable.class);
                if (!(force6 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 9: {
                final Object force7 = Promise.force(o, hashtable.HashTable.class);
                if (!(force7 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 7: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                final Object force8 = Promise.force(o, CharSequence.class);
                if (force8 instanceof CharSequence) {
                    ctx.value1 = force8;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 30: {
                final Object force = Promise.force(o, hashtable.HashTable.class);
                if (!(force instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(o2, hashtable.HashTable.class);
                if (!(force2 instanceof hashtable.HashTable)) {
                    return -786430;
                }
                ctx.value2 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 24: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 21: {
                final Object force3 = Promise.force(o, hashtable.HashTable.class);
                if (!(force3 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(o2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force4) != null) {
                    ctx.value2 = force4;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 15: {
                final Object force5 = Promise.force(o, hashtable.HashTable.class);
                if (!(force5 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 11: {
                final Object force6 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force6) == null) {
                    return -786431;
                }
                ctx.value1 = force6;
                final Object force7 = Promise.force(o2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force7) != null) {
                    ctx.value2 = force7;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 7: {
                ctx.value1 = o;
                final Object force8 = Promise.force(o2, IntNum.class);
                if (IntNum.asIntNumOrNull(force8) != null) {
                    ctx.value2 = force8;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 5: {
                ctx.value1 = o;
                final Object force9 = Promise.force(o2, IntNum.class);
                if (IntNum.asIntNumOrNull(force9) != null) {
                    ctx.value2 = force9;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 3: {
                ctx.value1 = o;
                final Object force10 = Promise.force(o2, IntNum.class);
                if (IntNum.asIntNumOrNull(force10) != null) {
                    ctx.value2 = force10;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 1: {
                final Object force11 = Promise.force(o, CharSequence.class);
                if (!(force11 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force11;
                final Object force12 = Promise.force(o2, IntNum.class);
                if (IntNum.asIntNumOrNull(force12) != null) {
                    ctx.value2 = force12;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 33: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 31: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 24: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 22: {
                final Object force = Promise.force(arg1, hashtable.HashTable.class);
                if (!(force instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force2) != null) {
                    ctx.value2 = force2;
                    ctx.value3 = arg3;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 18: {
                final Object force3 = Promise.force(arg1, hashtable.HashTable.class);
                if (!(force3 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 17: {
                final Object force4 = Promise.force(arg1, hashtable.HashTable.class);
                if (!(force4 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 15: {
                final Object force5 = Promise.force(arg1, hashtable.HashTable.class);
                if (!(force5 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.value2 = arg2;
                ctx.value3 = arg3;
                ctx.proc = proc;
                ctx.pc = 3;
                return 0;
            }
            case 11: {
                final Object force6 = Promise.force(arg1, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force6) == null) {
                    return -786431;
                }
                ctx.value1 = force6;
                final Object force7 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force7) != null) {
                    ctx.value2 = force7;
                    ctx.value3 = Promise.force(arg3);
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 24: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.value4 = o4;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 20: {
                final Object force = Promise.force(o, hashtable.HashTable.class);
                if (!(force instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.value4 = o4;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            case 18: {
                final Object force2 = Promise.force(o, hashtable.HashTable.class);
                if (!(force2 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.value4 = o4;
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            default: {
                return super.match4(moduleMethod, o, o2, o3, o4, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        if (method.selector == 11) {
            return makeHashTable();
        }
        return super.apply0(method);
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                1: 120
        //                3: 134
        //                5: 139
        //                7: 144
        //                9: 149
        //               10: 162
        //               11: 175
        //               23: 188
        //               24: 193
        //               28: 198
        //               29: 211
        //               32: 224
        //               34: 237
        //          default: 250
        //        }
        //   120: aload_2        
        //   121: ldc_w           Ljava/lang/CharSequence;.class
        //   124: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   127: checkcast       Ljava/lang/CharSequence;
        //   130: invokestatic    gnu/kawa/slib/srfi69.stringHash:(Ljava/lang/CharSequence;)Lgnu/math/IntNum;
        //   133: areturn        
        //   134: aload_2        
        //   135: invokestatic    gnu/kawa/slib/srfi69.stringCiHash:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   138: areturn        
        //   139: aload_2        
        //   140: invokestatic    gnu/kawa/slib/srfi69.hash:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   143: areturn        
        //   144: aload_2        
        //   145: invokestatic    gnu/kawa/slib/srfi69.hashByIdentity:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   148: areturn        
        //   149: aload_2        
        //   150: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   152: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   155: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   158: invokestatic    gnu/kawa/slib/srfi69.hashTableEquivalenceFunction:(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/mapping/Procedure;
        //   161: areturn        
        //   162: aload_2        
        //   163: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   165: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   168: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   171: invokestatic    gnu/kawa/slib/srfi69.hashTableHashFunction:(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/mapping/Procedure;
        //   174: areturn        
        //   175: aload_2        
        //   176: ldc             Lgnu/mapping/Procedure;.class
        //   178: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   181: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   184: invokestatic    gnu/kawa/slib/srfi69.makeHashTable:(Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
        //   187: areturn        
        //   188: aload_2        
        //   189: invokestatic    gnu/kawa/slib/srfi69.lambda1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   192: areturn        
        //   193: aload_2        
        //   194: invokestatic    gnu/kawa/slib/srfi69.alist$To$HashTable:(Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
        //   197: areturn        
        //   198: aload_2        
        //   199: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   201: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   204: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   207: invokestatic    gnu/kawa/slib/srfi69.hashTable$To$Alist:(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
        //   210: areturn        
        //   211: aload_2        
        //   212: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   214: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   217: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   220: invokestatic    gnu/kawa/slib/srfi69.hashTableCopy:(Lkawa/lib/kawa/hashtable$HashTable;)Lkawa/lib/kawa/hashtable$HashTable;
        //   223: areturn        
        //   224: aload_2        
        //   225: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   227: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   230: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   233: invokestatic    gnu/kawa/slib/srfi69.hashTableKeys:(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
        //   236: areturn        
        //   237: aload_2        
        //   238: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   240: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   243: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   246: invokestatic    gnu/kawa/slib/srfi69.hashTableValues:(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
        //   249: areturn        
        //   250: aload_0        
        //   251: aload_1        
        //   252: aload_2        
        //   253: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   256: areturn        
        //   257: new             Lgnu/mapping/WrongType;
        //   260: dup_x1         
        //   261: swap           
        //   262: ldc_w           "string-hash"
        //   265: iconst_1       
        //   266: aload_2        
        //   267: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   270: athrow         
        //   271: new             Lgnu/mapping/WrongType;
        //   274: dup_x1         
        //   275: swap           
        //   276: ldc_w           "hash-table-equivalence-function"
        //   279: iconst_1       
        //   280: aload_2        
        //   281: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   284: athrow         
        //   285: new             Lgnu/mapping/WrongType;
        //   288: dup_x1         
        //   289: swap           
        //   290: ldc_w           "hash-table-hash-function"
        //   293: iconst_1       
        //   294: aload_2        
        //   295: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   298: athrow         
        //   299: new             Lgnu/mapping/WrongType;
        //   302: dup_x1         
        //   303: swap           
        //   304: ldc             "make-hash-table"
        //   306: iconst_1       
        //   307: aload_2        
        //   308: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   311: athrow         
        //   312: new             Lgnu/mapping/WrongType;
        //   315: dup_x1         
        //   316: swap           
        //   317: ldc_w           "hash-table->alist"
        //   320: iconst_1       
        //   321: aload_2        
        //   322: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   325: athrow         
        //   326: new             Lgnu/mapping/WrongType;
        //   329: dup_x1         
        //   330: swap           
        //   331: ldc_w           "hash-table-copy"
        //   334: iconst_1       
        //   335: aload_2        
        //   336: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   339: athrow         
        //   340: new             Lgnu/mapping/WrongType;
        //   343: dup_x1         
        //   344: swap           
        //   345: ldc_w           "hash-table-keys"
        //   348: iconst_1       
        //   349: aload_2        
        //   350: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   353: athrow         
        //   354: new             Lgnu/mapping/WrongType;
        //   357: dup_x1         
        //   358: swap           
        //   359: ldc_w           "hash-table-values"
        //   362: iconst_1       
        //   363: aload_2        
        //   364: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   367: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  127    130    257    271    Ljava/lang/ClassCastException;
        //  155    158    271    285    Ljava/lang/ClassCastException;
        //  168    171    285    299    Ljava/lang/ClassCastException;
        //  181    184    299    312    Ljava/lang/ClassCastException;
        //  204    207    312    326    Ljava/lang/ClassCastException;
        //  217    220    326    340    Ljava/lang/ClassCastException;
        //  230    233    340    354    Ljava/lang/ClassCastException;
        //  243    246    354    368    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 135 out of bounds for length 135
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                1: 88
        //                3: 111
        //                5: 125
        //                7: 139
        //               11: 153
        //               15: 175
        //               21: 189
        //               24: 214
        //               30: 220
        //          default: 245
        //        }
        //    88: aload_2        
        //    89: ldc_w           Ljava/lang/CharSequence;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: checkcast       Ljava/lang/CharSequence;
        //    98: aload_3        
        //    99: ldc             Lgnu/math/IntNum;.class
        //   101: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   104: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   107: invokestatic    gnu/kawa/slib/srfi69.stringHash:(Ljava/lang/CharSequence;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //   110: areturn        
        //   111: aload_2        
        //   112: aload_3        
        //   113: ldc             Lgnu/math/IntNum;.class
        //   115: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   118: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   121: invokestatic    gnu/kawa/slib/srfi69.stringCiHash:(Ljava/lang/Object;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //   124: areturn        
        //   125: aload_2        
        //   126: aload_3        
        //   127: ldc             Lgnu/math/IntNum;.class
        //   129: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   132: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   135: invokestatic    gnu/kawa/slib/srfi69.hash:(Ljava/lang/Object;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //   138: areturn        
        //   139: aload_2        
        //   140: aload_3        
        //   141: ldc             Lgnu/math/IntNum;.class
        //   143: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   146: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceIntNum:(Ljava/lang/Object;)Lgnu/math/IntNum;
        //   149: invokestatic    gnu/kawa/slib/srfi69.hashByIdentity:(Ljava/lang/Object;Lgnu/math/IntNum;)Lgnu/math/IntNum;
        //   152: areturn        
        //   153: aload_2        
        //   154: ldc             Lgnu/mapping/Procedure;.class
        //   156: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   159: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   162: aload_3        
        //   163: ldc             Lgnu/mapping/Procedure;.class
        //   165: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   168: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   171: invokestatic    gnu/kawa/slib/srfi69.makeHashTable:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
        //   174: areturn        
        //   175: aload_2        
        //   176: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   178: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   181: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   184: aload_3        
        //   185: invokestatic    gnu/kawa/slib/srfi69.hashTableRef:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Ljava/lang/Object;
        //   188: areturn        
        //   189: aload_2        
        //   190: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   192: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   195: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   198: aload_3        
        //   199: ldc             Lgnu/mapping/Procedure;.class
        //   201: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   204: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   207: invokestatic    gnu/kawa/slib/srfi69.hashTableWalk:(Lkawa/lib/kawa/hashtable$HashTable;Lgnu/mapping/Procedure;)V
        //   210: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   213: areturn        
        //   214: aload_2        
        //   215: aload_3        
        //   216: invokestatic    gnu/kawa/slib/srfi69.alist$To$HashTable:(Ljava/lang/Object;Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
        //   219: areturn        
        //   220: aload_2        
        //   221: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   223: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   226: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   229: aload_3        
        //   230: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   232: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   235: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   238: invokestatic    gnu/kawa/slib/srfi69.hashTableMerge$Ex:(Lkawa/lib/kawa/hashtable$HashTable;Lkawa/lib/kawa/hashtable$HashTable;)V
        //   241: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   244: areturn        
        //   245: aload_0        
        //   246: aload_1        
        //   247: aload_2        
        //   248: aload_3        
        //   249: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   252: areturn        
        //   253: new             Lgnu/mapping/WrongType;
        //   256: dup_x1         
        //   257: swap           
        //   258: ldc_w           "string-hash"
        //   261: iconst_1       
        //   262: aload_2        
        //   263: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   266: athrow         
        //   267: new             Lgnu/mapping/WrongType;
        //   270: dup_x1         
        //   271: swap           
        //   272: ldc_w           "string-hash"
        //   275: iconst_2       
        //   276: aload_3        
        //   277: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   280: athrow         
        //   281: new             Lgnu/mapping/WrongType;
        //   284: dup_x1         
        //   285: swap           
        //   286: ldc_w           "string-ci-hash"
        //   289: iconst_2       
        //   290: aload_3        
        //   291: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   294: athrow         
        //   295: new             Lgnu/mapping/WrongType;
        //   298: dup_x1         
        //   299: swap           
        //   300: ldc_w           "hash"
        //   303: iconst_2       
        //   304: aload_3        
        //   305: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   308: athrow         
        //   309: new             Lgnu/mapping/WrongType;
        //   312: dup_x1         
        //   313: swap           
        //   314: ldc_w           "hash-by-identity"
        //   317: iconst_2       
        //   318: aload_3        
        //   319: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   322: athrow         
        //   323: new             Lgnu/mapping/WrongType;
        //   326: dup_x1         
        //   327: swap           
        //   328: ldc             "make-hash-table"
        //   330: iconst_1       
        //   331: aload_2        
        //   332: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   335: athrow         
        //   336: new             Lgnu/mapping/WrongType;
        //   339: dup_x1         
        //   340: swap           
        //   341: ldc             "make-hash-table"
        //   343: iconst_2       
        //   344: aload_3        
        //   345: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   348: athrow         
        //   349: new             Lgnu/mapping/WrongType;
        //   352: dup_x1         
        //   353: swap           
        //   354: ldc_w           "hash-table-ref"
        //   357: iconst_1       
        //   358: aload_2        
        //   359: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   362: athrow         
        //   363: new             Lgnu/mapping/WrongType;
        //   366: dup_x1         
        //   367: swap           
        //   368: ldc_w           "hash-table-walk"
        //   371: iconst_1       
        //   372: aload_2        
        //   373: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   376: athrow         
        //   377: new             Lgnu/mapping/WrongType;
        //   380: dup_x1         
        //   381: swap           
        //   382: ldc_w           "hash-table-walk"
        //   385: iconst_2       
        //   386: aload_3        
        //   387: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   390: athrow         
        //   391: new             Lgnu/mapping/WrongType;
        //   394: dup_x1         
        //   395: swap           
        //   396: ldc_w           "hash-table-merge!"
        //   399: iconst_1       
        //   400: aload_2        
        //   401: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   404: athrow         
        //   405: new             Lgnu/mapping/WrongType;
        //   408: dup_x1         
        //   409: swap           
        //   410: ldc_w           "hash-table-merge!"
        //   413: iconst_2       
        //   414: aload_3        
        //   415: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   418: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  95     98     253    267    Ljava/lang/ClassCastException;
        //  104    107    267    281    Ljava/lang/ClassCastException;
        //  118    121    281    295    Ljava/lang/ClassCastException;
        //  132    135    295    309    Ljava/lang/ClassCastException;
        //  146    149    309    323    Ljava/lang/ClassCastException;
        //  159    162    323    336    Ljava/lang/ClassCastException;
        //  168    171    336    349    Ljava/lang/ClassCastException;
        //  181    184    349    363    Ljava/lang/ClassCastException;
        //  195    198    363    377    Ljava/lang/ClassCastException;
        //  204    207    377    391    Ljava/lang/ClassCastException;
        //  226    229    391    405    Ljava/lang/ClassCastException;
        //  235    238    405    419    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 179 out of bounds for length 179
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               11: 80
        //               15: 113
        //               17: 129
        //               18: 145
        //               22: 164
        //               24: 188
        //               31: 196
        //               33: 204
        //          default: 212
        //        }
        //    80: aload_2        
        //    81: ldc             Lgnu/mapping/Procedure;.class
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    86: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    89: aload_3        
        //    90: ldc             Lgnu/mapping/Procedure;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    98: aload           4
        //   100: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   103: checkcast       Ljava/lang/Number;
        //   106: invokevirtual   java/lang/Number.intValue:()I
        //   109: invokestatic    gnu/kawa/slib/srfi69.makeHashTable:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
        //   112: areturn        
        //   113: aload_2        
        //   114: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   119: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   122: aload_3        
        //   123: aload           4
        //   125: invokestatic    gnu/kawa/slib/srfi69.hashTableRef:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   128: areturn        
        //   129: aload_2        
        //   130: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   132: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   135: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   138: aload_3        
        //   139: aload           4
        //   141: invokestatic    gnu/kawa/slib/srfi69.hashTableRef$SlDefault:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   144: areturn        
        //   145: aload_2        
        //   146: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   148: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   151: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   154: aload_3        
        //   155: aload           4
        //   157: invokestatic    gnu/kawa/slib/srfi69.hashTableUpdate$Ex:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)V
        //   160: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   163: areturn        
        //   164: aload_2        
        //   165: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   167: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   170: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   173: aload_3        
        //   174: ldc             Lgnu/mapping/Procedure;.class
        //   176: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   179: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   182: aload           4
        //   184: invokestatic    gnu/kawa/slib/srfi69.hashTableFold:(Lkawa/lib/kawa/hashtable$HashTable;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //   187: areturn        
        //   188: aload_2        
        //   189: aload_3        
        //   190: aload           4
        //   192: invokestatic    gnu/kawa/slib/srfi69.alist$To$HashTable:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
        //   195: areturn        
        //   196: aload_2        
        //   197: aload_3        
        //   198: aload           4
        //   200: invokestatic    gnu/kawa/slib/srfi69.lambda2:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   203: areturn        
        //   204: aload_2        
        //   205: aload_3        
        //   206: aload           4
        //   208: invokestatic    gnu/kawa/slib/srfi69.lambda3:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   211: areturn        
        //   212: aload_0        
        //   213: aload_1        
        //   214: aload_2        
        //   215: aload_3        
        //   216: aload           4
        //   218: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   221: areturn        
        //   222: new             Lgnu/mapping/WrongType;
        //   225: dup_x1         
        //   226: swap           
        //   227: ldc             "make-hash-table"
        //   229: iconst_1       
        //   230: aload_2        
        //   231: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   234: athrow         
        //   235: new             Lgnu/mapping/WrongType;
        //   238: dup_x1         
        //   239: swap           
        //   240: ldc             "make-hash-table"
        //   242: iconst_2       
        //   243: aload_3        
        //   244: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   247: athrow         
        //   248: new             Lgnu/mapping/WrongType;
        //   251: dup_x1         
        //   252: swap           
        //   253: ldc             "make-hash-table"
        //   255: iconst_3       
        //   256: aload           4
        //   258: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   261: athrow         
        //   262: new             Lgnu/mapping/WrongType;
        //   265: dup_x1         
        //   266: swap           
        //   267: ldc_w           "hash-table-ref"
        //   270: iconst_1       
        //   271: aload_2        
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //   276: new             Lgnu/mapping/WrongType;
        //   279: dup_x1         
        //   280: swap           
        //   281: ldc_w           "hash-table-ref/default"
        //   284: iconst_1       
        //   285: aload_2        
        //   286: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   289: athrow         
        //   290: new             Lgnu/mapping/WrongType;
        //   293: dup_x1         
        //   294: swap           
        //   295: ldc_w           "hash-table-update!"
        //   298: iconst_1       
        //   299: aload_2        
        //   300: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   303: athrow         
        //   304: new             Lgnu/mapping/WrongType;
        //   307: dup_x1         
        //   308: swap           
        //   309: ldc_w           "hash-table-fold"
        //   312: iconst_1       
        //   313: aload_2        
        //   314: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   317: athrow         
        //   318: new             Lgnu/mapping/WrongType;
        //   321: dup_x1         
        //   322: swap           
        //   323: ldc_w           "hash-table-fold"
        //   326: iconst_2       
        //   327: aload_3        
        //   328: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   331: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  86     89     222    235    Ljava/lang/ClassCastException;
        //  95     98     235    248    Ljava/lang/ClassCastException;
        //  103    109    248    262    Ljava/lang/ClassCastException;
        //  119    122    262    276    Ljava/lang/ClassCastException;
        //  135    138    276    290    Ljava/lang/ClassCastException;
        //  151    154    290    304    Ljava/lang/ClassCastException;
        //  170    173    304    318    Ljava/lang/ClassCastException;
        //  179    182    318    332    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 139 out of bounds for length 139
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply4(final ModuleMethod p0, final Object p1, final Object p2, final Object p3, final Object p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //               36: 48
        //               37: 100
        //               38: 69
        //               39: 100
        //               40: 100
        //               41: 100
        //               42: 90
        //          default: 100
        //        }
        //    48: aload_2        
        //    49: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    57: aload_3        
        //    58: aload           4
        //    60: aload           5
        //    62: invokestatic    gnu/kawa/slib/srfi69.hashTableUpdate$Ex:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    65: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    68: areturn        
        //    69: aload_2        
        //    70: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //    72: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    75: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    78: aload_3        
        //    79: aload           4
        //    81: aload           5
        //    83: invokestatic    gnu/kawa/slib/srfi69.hashTableUpdate$Ex$SlDefault:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    86: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    89: areturn        
        //    90: aload_2        
        //    91: aload_3        
        //    92: aload           4
        //    94: aload           5
        //    96: invokestatic    gnu/kawa/slib/srfi69.alist$To$HashTable:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkawa/lib/kawa/hashtable$HashTable;
        //    99: areturn        
        //   100: aload_0        
        //   101: aload_1        
        //   102: aload_2        
        //   103: aload_3        
        //   104: aload           4
        //   106: aload           5
        //   108: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   111: areturn        
        //   112: new             Lgnu/mapping/WrongType;
        //   115: dup_x1         
        //   116: swap           
        //   117: ldc_w           "hash-table-update!"
        //   120: iconst_1       
        //   121: aload_2        
        //   122: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   125: athrow         
        //   126: new             Lgnu/mapping/WrongType;
        //   129: dup_x1         
        //   130: swap           
        //   131: ldc_w           "hash-table-update!/default"
        //   134: iconst_1       
        //   135: aload_2        
        //   136: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   139: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  54     57     112    126    Ljava/lang/ClassCastException;
        //  75     78     126    140    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0090:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
