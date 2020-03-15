// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.rnrs;

import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.kawa.util.HashUtils;
import gnu.kawa.functions.IsEqv;
import gnu.lists.Pair;
import kawa.lib.lists;
import gnu.lists.FVector;
import gnu.mapping.Values;
import gnu.kawa.util.HashNode;
import gnu.mapping.Procedure;
import kawa.standard.Scheme;
import gnu.kawa.util.AbstractHashTable;
import kawa.lib.kawa.hashtable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class hashtables extends ModuleBody
{
    public static final ModuleMethod make$Mneq$Mnhashtable;
    public static final ModuleMethod make$Mneqv$Mnhashtable;
    public static final ModuleMethod make$Mnhashtable;
    public static final ModuleMethod hashtable$Qu;
    public static final ModuleMethod hashtable$Mnsize;
    public static final ModuleMethod hashtable$Mnref;
    public static final ModuleMethod hashtable$Mnset$Ex;
    public static final ModuleMethod hashtable$Mndelete$Ex;
    public static final ModuleMethod hashtable$Mncontains$Qu;
    public static final ModuleMethod hashtable$Mnupdate$Ex;
    public static final ModuleMethod hashtable$Mncopy;
    public static final ModuleMethod hashtable$Mnclear$Ex;
    public static final ModuleMethod hashtable$Mnkeys;
    public static final ModuleMethod hashtable$Mnentries;
    public static final ModuleMethod hashtable$Mnequivalence$Mnfunction;
    public static final ModuleMethod hashtable$Mnhash$Mnfunction;
    public static final ModuleMethod hashtable$Mnmutable$Qu;
    public static final ModuleMethod equal$Mnhash;
    public static final ModuleMethod string$Mnhash;
    public static final ModuleMethod string$Mnci$Mnhash;
    public static final ModuleMethod symbol$Mnhash;
    static final ModuleMethod hash$Mnby$Mnidentity;
    static final ModuleMethod hash$Mnfor$Mneqv;
    public static hashtables $instance;
    static final SimpleSymbol Lit0;
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
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static int hashByIdentity(final Object obj) {
        return System.identityHashCode(obj);
    }
    
    static int hashForEqv(final Object obj) {
        return obj.hashCode();
    }
    
    public static hashtable.HashTable makeEqHashtable() {
        return makeEqHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }
    
    public static hashtable.HashTable makeEqHashtable(final int k) {
        return new hashtable.HashTable(Scheme.isEq, hashtables.hash$Mnby$Mnidentity, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }
    
    public static hashtable.HashTable makeEqvHashtable() {
        return makeEqvHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }
    
    public static hashtable.HashTable makeEqvHashtable(final int k) {
        return new hashtable.HashTable(Scheme.isEqv, hashtables.hash$Mnfor$Mneqv, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }
    
    public static hashtable.HashTable makeHashtable(final Procedure hash$Mnfunction, final Procedure comparison) {
        return makeHashtable(hash$Mnfunction, comparison, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }
    
    public static hashtable.HashTable makeHashtable(final Procedure hash$Mnfunction, final Procedure comparison, final int size) {
        return new hashtable.HashTable(comparison, hash$Mnfunction, size);
    }
    
    public static boolean isHashtable(final Object obj) {
        return obj instanceof hashtable.HashTable;
    }
    
    public static int hashtableSize(final hashtable.HashTable ht) {
        return ht.size();
    }
    
    public static Object hashtableRef(final hashtable.HashTable ht, final Object key, final Object default) {
        final HashNode node = ht.getNode(key);
        return (node == null) ? default : node.getValue();
    }
    
    public static void hashtableSet$Ex(final hashtable.HashTable ht, final Object key, final Object value) {
        hashtable.hashtableCheckMutable(ht);
        ht.put(key, value);
    }
    
    public static void hashtableDelete$Ex(final hashtable.HashTable ht, final Object key) {
        hashtable.hashtableCheckMutable(ht);
        ht.remove(key);
    }
    
    public static boolean isHashtableContains(final hashtable.HashTable ht, final Object key) {
        return ht.getNode(key) != null;
    }
    
    public static Object hashtableUpdate$Ex(final hashtable.HashTable ht, final Object key, final Procedure proc, final Object default) {
        hashtable.hashtableCheckMutable(ht);
        final HashNode node = ht.getNode(key);
        Object o;
        if (node == null) {
            hashtableSet$Ex(ht, key, proc.apply1(default));
            o = Values.empty;
        }
        else {
            o = node.setValue(proc.apply1(node.getValue()));
        }
        return o;
    }
    
    public static hashtable.HashTable hashtableCopy(final hashtable.HashTable ht) {
        return hashtableCopy(ht, false);
    }
    
    public static hashtable.HashTable hashtableCopy(final hashtable.HashTable ht, final boolean mutable) {
        return new hashtable.HashTable(ht, mutable);
    }
    
    public static void hashtableClear$Ex(final hashtable.HashTable ht) {
        hashtableClear$Ex(ht, 64);
    }
    
    public static void hashtableClear$Ex(final hashtable.HashTable ht, final int k) {
        hashtable.hashtableCheckMutable(ht);
        ht.clear();
    }
    
    public static FVector hashtableKeys(final hashtable.HashTable ht) {
        return ht.keysVector();
    }
    
    public static Values hashtableEntries(final hashtable.HashTable ht) {
        final Pair pair = ht.entriesVectorPair();
        return Values.values2(lists.car(pair), lists.cdr(pair));
    }
    
    public static Procedure hashtableEquivalenceFunction(final hashtable.HashTable ht) {
        return ht.equivalenceFunction;
    }
    
    public static Object hashtableHashFunction(final hashtable.HashTable ht) {
        final Object hasher = ht.hashFunction.apply1(ht);
        final boolean x = IsEqv.apply(hasher, hashtables.hash$Mnby$Mnidentity);
        return (x ? x : IsEqv.apply(hasher, hashtables.hash$Mnfor$Mneqv)) ? Boolean.FALSE : hasher;
    }
    
    public static boolean isHashtableMutable(final hashtable.HashTable ht) {
        return ht.mutable;
    }
    
    public static int equalHash(final Object key) {
        return HashUtils.boundedHash(key);
    }
    
    public static int stringHash(final CharSequence s) {
        return s.hashCode();
    }
    
    public static int stringCiHash(final CharSequence s) {
        return s.toString().toLowerCase().hashCode();
    }
    
    public static int symbolHash(final Symbol s) {
        return s.hashCode();
    }
    
    static {
        Lit22 = Symbol.valueOf("symbol-hash");
        Lit21 = Symbol.valueOf("string-ci-hash");
        Lit20 = Symbol.valueOf("string-hash");
        Lit19 = Symbol.valueOf("equal-hash");
        Lit18 = Symbol.valueOf("hashtable-mutable?");
        Lit17 = Symbol.valueOf("hashtable-hash-function");
        Lit16 = Symbol.valueOf("hashtable-equivalence-function");
        Lit15 = Symbol.valueOf("hashtable-entries");
        Lit14 = Symbol.valueOf("hashtable-keys");
        Lit13 = Symbol.valueOf("hashtable-clear!");
        Lit12 = Symbol.valueOf("hashtable-copy");
        Lit11 = Symbol.valueOf("hashtable-update!");
        Lit10 = Symbol.valueOf("hashtable-contains?");
        Lit9 = Symbol.valueOf("hashtable-delete!");
        Lit8 = Symbol.valueOf("hashtable-set!");
        Lit7 = Symbol.valueOf("hashtable-ref");
        Lit6 = Symbol.valueOf("hashtable-size");
        Lit5 = Symbol.valueOf("hashtable?");
        Lit4 = Symbol.valueOf("make-hashtable");
        Lit3 = Symbol.valueOf("make-eqv-hashtable");
        Lit2 = Symbol.valueOf("make-eq-hashtable");
        Lit1 = Symbol.valueOf("hash-for-eqv");
        Lit0 = Symbol.valueOf("hash-by-identity");
        hashtables.$instance = new hashtables();
        final hashtables $instance = hashtables.$instance;
        hash$Mnby$Mnidentity = new ModuleMethod($instance, 1, hashtables.Lit0, 4097);
        hash$Mnfor$Mneqv = new ModuleMethod($instance, 2, hashtables.Lit1, 4097);
        make$Mneq$Mnhashtable = new ModuleMethod($instance, 3, hashtables.Lit2, 4096);
        make$Mneqv$Mnhashtable = new ModuleMethod($instance, 5, hashtables.Lit3, 4096);
        make$Mnhashtable = new ModuleMethod($instance, 7, hashtables.Lit4, 12290);
        hashtable$Qu = new ModuleMethod($instance, 9, hashtables.Lit5, 4097);
        hashtable$Mnsize = new ModuleMethod($instance, 10, hashtables.Lit6, 4097);
        hashtable$Mnref = new ModuleMethod($instance, 11, hashtables.Lit7, 12291);
        hashtable$Mnset$Ex = new ModuleMethod($instance, 12, hashtables.Lit8, 12291);
        hashtable$Mndelete$Ex = new ModuleMethod($instance, 13, hashtables.Lit9, 8194);
        hashtable$Mncontains$Qu = new ModuleMethod($instance, 14, hashtables.Lit10, 8194);
        hashtable$Mnupdate$Ex = new ModuleMethod($instance, 15, hashtables.Lit11, 16388);
        hashtable$Mncopy = new ModuleMethod($instance, 16, hashtables.Lit12, 8193);
        hashtable$Mnclear$Ex = new ModuleMethod($instance, 18, hashtables.Lit13, 8193);
        hashtable$Mnkeys = new ModuleMethod($instance, 20, hashtables.Lit14, 4097);
        hashtable$Mnentries = new ModuleMethod($instance, 21, hashtables.Lit15, 4097);
        hashtable$Mnequivalence$Mnfunction = new ModuleMethod($instance, 22, hashtables.Lit16, 4097);
        hashtable$Mnhash$Mnfunction = new ModuleMethod($instance, 23, hashtables.Lit17, 4097);
        hashtable$Mnmutable$Qu = new ModuleMethod($instance, 24, hashtables.Lit18, 4097);
        equal$Mnhash = new ModuleMethod($instance, 25, hashtables.Lit19, 4097);
        string$Mnhash = new ModuleMethod($instance, 26, hashtables.Lit20, 4097);
        string$Mnci$Mnhash = new ModuleMethod($instance, 27, hashtables.Lit21, 4097);
        symbol$Mnhash = new ModuleMethod($instance, 28, hashtables.Lit22, 4097);
        $runBody$();
    }
    
    public hashtables() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod proc, final CallContext ctx) {
        switch (proc.selector) {
            case 5: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            case 3: {
                ctx.proc = proc;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(proc, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 28: {
                final Object force = Promise.force(o, Symbol.class);
                if (!(force instanceof Symbol)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 27: {
                final Object force2 = Promise.force(o, CharSequence.class);
                if (force2 instanceof CharSequence) {
                    ctx.value1 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 26: {
                final Object force3 = Promise.force(o, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value1 = force3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 25: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 24: {
                final Object force4 = Promise.force(o, hashtable.HashTable.class);
                if (!(force4 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 23: {
                final Object force5 = Promise.force(o, hashtable.HashTable.class);
                if (!(force5 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 22: {
                final Object force6 = Promise.force(o, hashtable.HashTable.class);
                if (!(force6 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 21: {
                final Object force7 = Promise.force(o, hashtable.HashTable.class);
                if (!(force7 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 20: {
                final Object force8 = Promise.force(o, hashtable.HashTable.class);
                if (!(force8 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
                final Object force9 = Promise.force(o, hashtable.HashTable.class);
                if (!(force9 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
                final Object force10 = Promise.force(o, hashtable.HashTable.class);
                if (!(force10 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force10;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 10: {
                final Object force11 = Promise.force(o, hashtable.HashTable.class);
                if (!(force11 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 9: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 18: {
                final Object force = Promise.force(o, hashtable.HashTable.class);
                if (!(force instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = Promise.force(o2);
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 16: {
                final Object force2 = Promise.force(o, hashtable.HashTable.class);
                if (!(force2 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(o2);
                if (force3 instanceof Boolean) {
                    ctx.value2 = force3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 14: {
                final Object force4 = Promise.force(o, hashtable.HashTable.class);
                if (!(force4 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 13: {
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
            case 7: {
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
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 12: {
                final Object force = Promise.force(o, hashtable.HashTable.class);
                if (!(force instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 11: {
                final Object force2 = Promise.force(o, hashtable.HashTable.class);
                if (!(force2 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 7: {
                final Object force3 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force3) == null) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(o2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force4) != null) {
                    ctx.value2 = force4;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector != 15) {
            return super.match4(moduleMethod, o, o2, o3, o4, ctx);
        }
        final Object force = Promise.force(o, hashtable.HashTable.class);
        if (!(force instanceof hashtable.HashTable)) {
            return -786431;
        }
        ctx.value1 = force;
        ctx.value2 = o2;
        final Object force2 = Promise.force(o3, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force2) != null) {
            ctx.value3 = force2;
            ctx.value4 = o4;
            ctx.proc = moduleMethod;
            ctx.pc = 4;
            return 0;
        }
        return -786429;
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 3: {
                return makeEqHashtable();
            }
            case 5: {
                return makeEqvHashtable();
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                2: 132
        //                3: 140
        //                4: 148
        //                5: 371
        //                6: 162
        //                7: 371
        //                8: 371
        //                9: 371
        //               10: 176
        //               11: 193
        //               12: 371
        //               13: 371
        //               14: 371
        //               15: 371
        //               16: 371
        //               17: 209
        //               18: 371
        //               19: 222
        //               20: 371
        //               21: 238
        //               22: 251
        //               23: 264
        //               24: 277
        //               25: 290
        //               26: 315
        //               27: 323
        //               28: 339
        //               29: 355
        //          default: 371
        //        }
        //   132: aload_2        
        //   133: invokestatic    kawa/lib/rnrs/hashtables.hashByIdentity:(Ljava/lang/Object;)I
        //   136: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   139: areturn        
        //   140: aload_2        
        //   141: invokestatic    kawa/lib/rnrs/hashtables.hashForEqv:(Ljava/lang/Object;)I
        //   144: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   147: areturn        
        //   148: aload_2        
        //   149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   152: checkcast       Ljava/lang/Number;
        //   155: invokevirtual   java/lang/Number.intValue:()I
        //   158: invokestatic    kawa/lib/rnrs/hashtables.makeEqHashtable:(I)Lkawa/lib/kawa/hashtable$HashTable;
        //   161: areturn        
        //   162: aload_2        
        //   163: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   166: checkcast       Ljava/lang/Number;
        //   169: invokevirtual   java/lang/Number.intValue:()I
        //   172: invokestatic    kawa/lib/rnrs/hashtables.makeEqvHashtable:(I)Lkawa/lib/kawa/hashtable$HashTable;
        //   175: areturn        
        //   176: aload_2        
        //   177: invokestatic    kawa/lib/rnrs/hashtables.isHashtable:(Ljava/lang/Object;)Z
        //   180: ifeq            189
        //   183: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   186: goto            192
        //   189: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   192: areturn        
        //   193: aload_2        
        //   194: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   196: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   199: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   202: invokestatic    kawa/lib/rnrs/hashtables.hashtableSize:(Lkawa/lib/kawa/hashtable$HashTable;)I
        //   205: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   208: areturn        
        //   209: aload_2        
        //   210: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   212: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   215: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   218: invokestatic    kawa/lib/rnrs/hashtables.hashtableCopy:(Lkawa/lib/kawa/hashtable$HashTable;)Lkawa/lib/kawa/hashtable$HashTable;
        //   221: areturn        
        //   222: aload_2        
        //   223: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   225: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   228: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   231: invokestatic    kawa/lib/rnrs/hashtables.hashtableClear$Ex:(Lkawa/lib/kawa/hashtable$HashTable;)V
        //   234: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   237: areturn        
        //   238: aload_2        
        //   239: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   241: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   244: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   247: invokestatic    kawa/lib/rnrs/hashtables.hashtableKeys:(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/lists/FVector;
        //   250: areturn        
        //   251: aload_2        
        //   252: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   254: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   257: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   260: invokestatic    kawa/lib/rnrs/hashtables.hashtableEntries:(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/mapping/Values;
        //   263: areturn        
        //   264: aload_2        
        //   265: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   267: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   270: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   273: invokestatic    kawa/lib/rnrs/hashtables.hashtableEquivalenceFunction:(Lkawa/lib/kawa/hashtable$HashTable;)Lgnu/mapping/Procedure;
        //   276: areturn        
        //   277: aload_2        
        //   278: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   280: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   283: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   286: invokestatic    kawa/lib/rnrs/hashtables.hashtableHashFunction:(Lkawa/lib/kawa/hashtable$HashTable;)Ljava/lang/Object;
        //   289: areturn        
        //   290: aload_2        
        //   291: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   293: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   296: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   299: invokestatic    kawa/lib/rnrs/hashtables.isHashtableMutable:(Lkawa/lib/kawa/hashtable$HashTable;)Z
        //   302: ifeq            311
        //   305: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   308: goto            314
        //   311: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   314: areturn        
        //   315: aload_2        
        //   316: invokestatic    kawa/lib/rnrs/hashtables.equalHash:(Ljava/lang/Object;)I
        //   319: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   322: areturn        
        //   323: aload_2        
        //   324: ldc             Ljava/lang/CharSequence;.class
        //   326: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   329: checkcast       Ljava/lang/CharSequence;
        //   332: invokestatic    kawa/lib/rnrs/hashtables.stringHash:(Ljava/lang/CharSequence;)I
        //   335: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   338: areturn        
        //   339: aload_2        
        //   340: ldc             Ljava/lang/CharSequence;.class
        //   342: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   345: checkcast       Ljava/lang/CharSequence;
        //   348: invokestatic    kawa/lib/rnrs/hashtables.stringCiHash:(Ljava/lang/CharSequence;)I
        //   351: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   354: areturn        
        //   355: aload_2        
        //   356: ldc             Lgnu/mapping/Symbol;.class
        //   358: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   361: checkcast       Lgnu/mapping/Symbol;
        //   364: invokestatic    kawa/lib/rnrs/hashtables.symbolHash:(Lgnu/mapping/Symbol;)I
        //   367: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   370: areturn        
        //   371: aload_0        
        //   372: aload_1        
        //   373: aload_2        
        //   374: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   377: areturn        
        //   378: new             Lgnu/mapping/WrongType;
        //   381: dup_x1         
        //   382: swap           
        //   383: ldc_w           "make-eq-hashtable"
        //   386: iconst_1       
        //   387: aload_2        
        //   388: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   391: athrow         
        //   392: new             Lgnu/mapping/WrongType;
        //   395: dup_x1         
        //   396: swap           
        //   397: ldc_w           "make-eqv-hashtable"
        //   400: iconst_1       
        //   401: aload_2        
        //   402: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   405: athrow         
        //   406: new             Lgnu/mapping/WrongType;
        //   409: dup_x1         
        //   410: swap           
        //   411: ldc_w           "hashtable-size"
        //   414: iconst_1       
        //   415: aload_2        
        //   416: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   419: athrow         
        //   420: new             Lgnu/mapping/WrongType;
        //   423: dup_x1         
        //   424: swap           
        //   425: ldc_w           "hashtable-copy"
        //   428: iconst_1       
        //   429: aload_2        
        //   430: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   433: athrow         
        //   434: new             Lgnu/mapping/WrongType;
        //   437: dup_x1         
        //   438: swap           
        //   439: ldc_w           "hashtable-clear!"
        //   442: iconst_1       
        //   443: aload_2        
        //   444: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   447: athrow         
        //   448: new             Lgnu/mapping/WrongType;
        //   451: dup_x1         
        //   452: swap           
        //   453: ldc_w           "hashtable-keys"
        //   456: iconst_1       
        //   457: aload_2        
        //   458: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   461: athrow         
        //   462: new             Lgnu/mapping/WrongType;
        //   465: dup_x1         
        //   466: swap           
        //   467: ldc_w           "hashtable-entries"
        //   470: iconst_1       
        //   471: aload_2        
        //   472: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   475: athrow         
        //   476: new             Lgnu/mapping/WrongType;
        //   479: dup_x1         
        //   480: swap           
        //   481: ldc_w           "hashtable-equivalence-function"
        //   484: iconst_1       
        //   485: aload_2        
        //   486: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   489: athrow         
        //   490: new             Lgnu/mapping/WrongType;
        //   493: dup_x1         
        //   494: swap           
        //   495: ldc_w           "hashtable-hash-function"
        //   498: iconst_1       
        //   499: aload_2        
        //   500: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   503: athrow         
        //   504: new             Lgnu/mapping/WrongType;
        //   507: dup_x1         
        //   508: swap           
        //   509: ldc_w           "hashtable-mutable?"
        //   512: iconst_1       
        //   513: aload_2        
        //   514: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   517: athrow         
        //   518: new             Lgnu/mapping/WrongType;
        //   521: dup_x1         
        //   522: swap           
        //   523: ldc_w           "string-hash"
        //   526: iconst_1       
        //   527: aload_2        
        //   528: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   531: athrow         
        //   532: new             Lgnu/mapping/WrongType;
        //   535: dup_x1         
        //   536: swap           
        //   537: ldc_w           "string-ci-hash"
        //   540: iconst_1       
        //   541: aload_2        
        //   542: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   545: athrow         
        //   546: new             Lgnu/mapping/WrongType;
        //   549: dup_x1         
        //   550: swap           
        //   551: ldc_w           "symbol-hash"
        //   554: iconst_1       
        //   555: aload_2        
        //   556: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   559: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  152    158    378    392    Ljava/lang/ClassCastException;
        //  166    172    392    406    Ljava/lang/ClassCastException;
        //  199    202    406    420    Ljava/lang/ClassCastException;
        //  215    218    420    434    Ljava/lang/ClassCastException;
        //  228    231    434    448    Ljava/lang/ClassCastException;
        //  244    247    448    462    Ljava/lang/ClassCastException;
        //  257    260    462    476    Ljava/lang/ClassCastException;
        //  270    273    476    490    Ljava/lang/ClassCastException;
        //  283    286    490    504    Ljava/lang/ClassCastException;
        //  296    299    504    518    Ljava/lang/ClassCastException;
        //  329    332    518    532    Ljava/lang/ClassCastException;
        //  345    348    532    546    Ljava/lang/ClassCastException;
        //  361    364    546    560    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 218 out of bounds for length 218
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
        //                7: 56
        //               13: 78
        //               14: 95
        //               16: 121
        //               18: 149
        //          default: 175
        //        }
        //    56: aload_2        
        //    57: ldc             Lgnu/mapping/Procedure;.class
        //    59: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    62: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    65: aload_3        
        //    66: ldc             Lgnu/mapping/Procedure;.class
        //    68: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    71: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    74: invokestatic    kawa/lib/rnrs/hashtables.makeHashtable:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Lkawa/lib/kawa/hashtable$HashTable;
        //    77: areturn        
        //    78: aload_2        
        //    79: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //    81: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    84: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    87: aload_3        
        //    88: invokestatic    kawa/lib/rnrs/hashtables.hashtableDelete$Ex:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)V
        //    91: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    94: areturn        
        //    95: aload_2        
        //    96: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //    98: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   101: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   104: aload_3        
        //   105: invokestatic    kawa/lib/rnrs/hashtables.isHashtableContains:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;)Z
        //   108: ifeq            117
        //   111: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   114: goto            120
        //   117: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   120: areturn        
        //   121: aload_2        
        //   122: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   124: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   127: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   130: aload_3        
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   134: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   137: ifeq            144
        //   140: iconst_1       
        //   141: goto            145
        //   144: iconst_0       
        //   145: invokestatic    kawa/lib/rnrs/hashtables.hashtableCopy:(Lkawa/lib/kawa/hashtable$HashTable;Z)Lkawa/lib/kawa/hashtable$HashTable;
        //   148: areturn        
        //   149: aload_2        
        //   150: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //   152: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   155: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   158: aload_3        
        //   159: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   162: checkcast       Ljava/lang/Number;
        //   165: invokevirtual   java/lang/Number.intValue:()I
        //   168: invokestatic    kawa/lib/rnrs/hashtables.hashtableClear$Ex:(Lkawa/lib/kawa/hashtable$HashTable;I)V
        //   171: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   174: areturn        
        //   175: aload_0        
        //   176: aload_1        
        //   177: aload_2        
        //   178: aload_3        
        //   179: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   182: areturn        
        //   183: new             Lgnu/mapping/WrongType;
        //   186: dup_x1         
        //   187: swap           
        //   188: ldc_w           "make-hashtable"
        //   191: iconst_1       
        //   192: aload_2        
        //   193: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   196: athrow         
        //   197: new             Lgnu/mapping/WrongType;
        //   200: dup_x1         
        //   201: swap           
        //   202: ldc_w           "make-hashtable"
        //   205: iconst_2       
        //   206: aload_3        
        //   207: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   210: athrow         
        //   211: new             Lgnu/mapping/WrongType;
        //   214: dup_x1         
        //   215: swap           
        //   216: ldc_w           "hashtable-delete!"
        //   219: iconst_1       
        //   220: aload_2        
        //   221: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   224: athrow         
        //   225: new             Lgnu/mapping/WrongType;
        //   228: dup_x1         
        //   229: swap           
        //   230: ldc_w           "hashtable-contains?"
        //   233: iconst_1       
        //   234: aload_2        
        //   235: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   238: athrow         
        //   239: new             Lgnu/mapping/WrongType;
        //   242: dup_x1         
        //   243: swap           
        //   244: ldc_w           "hashtable-copy"
        //   247: iconst_1       
        //   248: aload_2        
        //   249: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   252: athrow         
        //   253: new             Lgnu/mapping/WrongType;
        //   256: dup_x1         
        //   257: swap           
        //   258: ldc_w           "hashtable-copy"
        //   261: iconst_2       
        //   262: aload_3        
        //   263: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   266: athrow         
        //   267: new             Lgnu/mapping/WrongType;
        //   270: dup_x1         
        //   271: swap           
        //   272: ldc_w           "hashtable-clear!"
        //   275: iconst_1       
        //   276: aload_2        
        //   277: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   280: athrow         
        //   281: new             Lgnu/mapping/WrongType;
        //   284: dup_x1         
        //   285: swap           
        //   286: ldc_w           "hashtable-clear!"
        //   289: iconst_2       
        //   290: aload_3        
        //   291: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   294: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  62     65     183    197    Ljava/lang/ClassCastException;
        //  71     74     197    211    Ljava/lang/ClassCastException;
        //  84     87     211    225    Ljava/lang/ClassCastException;
        //  101    104    225    239    Ljava/lang/ClassCastException;
        //  127    130    239    253    Ljava/lang/ClassCastException;
        //  134    145    253    267    Ljava/lang/ClassCastException;
        //  155    158    267    281    Ljava/lang/ClassCastException;
        //  162    168    281    295    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 126 out of bounds for length 126
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
        //     4: tableswitch {
        //               14: 44
        //               15: 112
        //               16: 112
        //               17: 112
        //               18: 77
        //               19: 93
        //          default: 112
        //        }
        //    44: aload_2        
        //    45: ldc             Lgnu/mapping/Procedure;.class
        //    47: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    50: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    53: aload_3        
        //    54: ldc             Lgnu/mapping/Procedure;.class
        //    56: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    59: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    62: aload           4
        //    64: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    67: checkcast       Ljava/lang/Number;
        //    70: invokevirtual   java/lang/Number.intValue:()I
        //    73: invokestatic    kawa/lib/rnrs/hashtables.makeHashtable:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;I)Lkawa/lib/kawa/hashtable$HashTable;
        //    76: areturn        
        //    77: aload_2        
        //    78: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //    80: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    83: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    86: aload_3        
        //    87: aload           4
        //    89: invokestatic    kawa/lib/rnrs/hashtables.hashtableRef:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    92: areturn        
        //    93: aload_2        
        //    94: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //    96: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    99: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //   102: aload_3        
        //   103: aload           4
        //   105: invokestatic    kawa/lib/rnrs/hashtables.hashtableSet$Ex:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Ljava/lang/Object;)V
        //   108: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   111: areturn        
        //   112: aload_0        
        //   113: aload_1        
        //   114: aload_2        
        //   115: aload_3        
        //   116: aload           4
        //   118: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   121: areturn        
        //   122: new             Lgnu/mapping/WrongType;
        //   125: dup_x1         
        //   126: swap           
        //   127: ldc_w           "make-hashtable"
        //   130: iconst_1       
        //   131: aload_2        
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //   136: new             Lgnu/mapping/WrongType;
        //   139: dup_x1         
        //   140: swap           
        //   141: ldc_w           "make-hashtable"
        //   144: iconst_2       
        //   145: aload_3        
        //   146: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   149: athrow         
        //   150: new             Lgnu/mapping/WrongType;
        //   153: dup_x1         
        //   154: swap           
        //   155: ldc_w           "make-hashtable"
        //   158: iconst_3       
        //   159: aload           4
        //   161: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   164: athrow         
        //   165: new             Lgnu/mapping/WrongType;
        //   168: dup_x1         
        //   169: swap           
        //   170: ldc_w           "hashtable-ref"
        //   173: iconst_1       
        //   174: aload_2        
        //   175: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   178: athrow         
        //   179: new             Lgnu/mapping/WrongType;
        //   182: dup_x1         
        //   183: swap           
        //   184: ldc_w           "hashtable-set!"
        //   187: iconst_1       
        //   188: aload_2        
        //   189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   192: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  50     53     122    136    Ljava/lang/ClassCastException;
        //  59     62     136    150    Ljava/lang/ClassCastException;
        //  67     73     150    165    Ljava/lang/ClassCastException;
        //  83     86     165    179    Ljava/lang/ClassCastException;
        //  99     102    179    193    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 81 out of bounds for length 81
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
        //     4: bipush          15
        //     6: if_icmpne       38
        //     9: goto            12
        //    12: aload_2        
        //    13: ldc             Lkawa/lib/kawa/hashtable$HashTable;.class
        //    15: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    18: checkcast       Lkawa/lib/kawa/hashtable$HashTable;
        //    21: aload_3        
        //    22: aload           4
        //    24: ldc             Lgnu/mapping/Procedure;.class
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    29: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    32: aload           5
        //    34: invokestatic    kawa/lib/rnrs/hashtables.hashtableUpdate$Ex:(Lkawa/lib/kawa/hashtable$HashTable;Ljava/lang/Object;Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
        //    37: areturn        
        //    38: aload_0        
        //    39: aload_1        
        //    40: aload_2        
        //    41: aload_3        
        //    42: aload           4
        //    44: aload           5
        //    46: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    49: areturn        
        //    50: new             Lgnu/mapping/WrongType;
        //    53: dup_x1         
        //    54: swap           
        //    55: ldc_w           "hashtable-update!"
        //    58: iconst_1       
        //    59: aload_2        
        //    60: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    63: athrow         
        //    64: new             Lgnu/mapping/WrongType;
        //    67: dup_x1         
        //    68: swap           
        //    69: ldc_w           "hashtable-update!"
        //    72: iconst_3       
        //    73: aload           4
        //    75: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    78: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     50     64     Ljava/lang/ClassCastException;
        //  29     32     64     79     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0038:
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
