/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.HashNode;
import gnu.kawa.util.HashUtils;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import java.util.Map;
import kawa.lib.exceptions;
import kawa.lib.kawa.hashtable;
import kawa.lib.lists;
import kawa.lib.numbers;
import kawa.lib.rnrs.hashtables;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class srfi69
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static IntNum stringHash(CharSequence charSequence) {
        return srfi69.stringHash(charSequence, null);
    }

    public static IntNum stringHash(CharSequence s, IntNum bound) {
        int h = s.hashCode();
        return bound == null ? IntNum.make(h) : IntNum.modulo(IntNum.make(h), bound);
    }

    public static IntNum stringCiHash(Object object2) {
        return srfi69.stringCiHash(object2, null);
    }

    public static IntNum stringCiHash(Object s, IntNum bound) {
        int h = s.toString().toLowerCase().hashCode();
        return bound == null ? IntNum.make(h) : IntNum.modulo(IntNum.make(h), bound);
    }

    public static IntNum hash(Object object2) {
        return srfi69.hash(object2, null);
    }

    public static IntNum hash(Object obj, IntNum bound) {
        int h = HashUtils.boundedHash(obj);
        return bound == null ? IntNum.make(h) : IntNum.modulo(IntNum.make(h), bound);
    }

    public static IntNum hashByIdentity(Object object2) {
        return srfi69.hashByIdentity(object2, null);
    }

    public static IntNum hashByIdentity(Object obj, IntNum bound) {
        int h = System.identityHashCode(obj);
        return bound == null ? IntNum.make(h) : IntNum.modulo(IntNum.make(h), bound);
    }

    public static Procedure hashTableEquivalenceFunction(hashtable.HashTable hash$Mntable) {
        return hash$Mntable.equivalenceFunction;
    }

    public static Procedure hashTableHashFunction(hashtable.HashTable hash$Mntable) {
        return hash$Mntable.hashFunction;
    }

    public static hashtable.HashTable makeHashTable() {
        return srfi69.makeHashTable(Scheme.isEqual);
    }

    public static hashtable.HashTable makeHashTable(Procedure procedure) {
        return srfi69.makeHashTable(procedure, srfi69.appropriateHashFunctionFor(procedure), 64);
    }

    public static hashtable.HashTable makeHashTable(Procedure procedure, Procedure procedure2) {
        return srfi69.makeHashTable(procedure, procedure2, 64);
    }

    public static hashtable.HashTable makeHashTable(Procedure comparison, Procedure hash, int size) {
        return new hashtable.HashTable(comparison, hash, size);
    }

    static Procedure appropriateHashFunctionFor(Object comparison) {
        Procedure procedure;
        Object x;
        Object object2 = x = comparison == Scheme.isEq ? hash$Mnby$Mnidentity : Boolean.FALSE;
        if (KawaConvert.isTrue(x)) {
            procedure = LangObjType.coerceToProcedure(Promise.force(x, Procedure.class));
        } else {
            Object x2;
            Object object3 = x2 = comparison == strings.string$Eq$Qu ? string$Mnhash : Boolean.FALSE;
            if (KawaConvert.isTrue(x2)) {
                procedure = LangObjType.coerceToProcedure(Promise.force(x2, Procedure.class));
            } else {
                Object x3 = comparison == strings.string$Mnci$Eq$Qu ? string$Mnci$Mnhash : Boolean.FALSE;
                procedure = KawaConvert.isTrue(x3) ? LangObjType.coerceToProcedure(Promise.force(x3, Procedure.class)) : hash;
            }
        }
        return procedure;
    }

    public static Object hashTableRef(hashtable.HashTable hashTable, Object object2) {
        return srfi69.hashTableRef(hashTable, object2, Boolean.FALSE);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Object hashTableRef(hashtable.HashTable hash$Mntable, Object key, Object object2) {
        Object object3;
        Map.Entry node = hash$Mntable.getNode(key);
        if (node != null) {
            object3 = ((HashNode)node).getValue();
            return object3;
        }
        if (KawaConvert.isTrue(object2)) {
            object3 = ((Procedure)Scheme.applyToArgs).apply1(object2);
            return object3;
        }
        Type.NeverReturns neverReturns = exceptions.error("hash-table-ref: no value associated with", key);
        throw Special.reachedUnexpected;
    }

    public static Object hashTableRef$SlDefault(hashtable.HashTable hash$Mntable, Object key, Object object2) {
        return hash$Mntable.get(key, object2);
    }

    public static void hashTableUpdate$Ex(hashtable.HashTable hashTable, Object object2, Object object3) {
        srfi69.hashTableUpdate$Ex(hashTable, object2, object3, Boolean.FALSE);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void hashTableUpdate$Ex(hashtable.HashTable hash$Mntable, Object key, Object function2, Object thunk) {
        hashtable.hashtableCheckMutable(hash$Mntable);
        Map.Entry node = hash$Mntable.getNode(key);
        if (node != null) {
            ((HashNode)node).setValue(((Procedure)Scheme.applyToArgs).apply2(function2, ((HashNode)node).getValue()));
            return;
        }
        if (KawaConvert.isTrue(thunk)) {
            hashtables.hashtableSet$Ex(hash$Mntable, key, ((Procedure)Scheme.applyToArgs).apply2(function2, ((Procedure)Scheme.applyToArgs).apply1(thunk)));
            return;
        }
        Type.NeverReturns neverReturns = exceptions.error("hash-table-update!: no value exists for key", key);
        throw Special.reachedUnexpected;
    }

    public static void hashTableUpdate$Ex$SlDefault(hashtable.HashTable hash$Mntable, Object key, Object function2, Object object2) {
        hashtable.hashtableCheckMutable(hash$Mntable);
        Map.Entry node = hash$Mntable.getNode(key);
        if (node == null) {
            hashtables.hashtableSet$Ex(hash$Mntable, key, ((Procedure)Scheme.applyToArgs).apply2(function2, object2));
        } else {
            ((HashNode)node).setValue(((Procedure)Scheme.applyToArgs).apply2(function2, ((HashNode)node).getValue()));
        }
    }

    public static void hashTableWalk(hashtable.HashTable hash$Mntable, Procedure proc) {
        hash$Mntable.walk(proc);
    }

    public static Object hashTableFold(hashtable.HashTable hash$Mntable, Procedure proc, Object acc) {
        return hash$Mntable.fold(proc, acc);
    }

    public static hashtable.HashTable alist$To$HashTable(Object object2) {
        return srfi69.alist$To$HashTable(object2, Scheme.isEqual);
    }

    public static hashtable.HashTable alist$To$HashTable(Object object2, Object object3) {
        return srfi69.alist$To$HashTable(object2, object3, srfi69.appropriateHashFunctionFor(object3));
    }

    public static hashtable.HashTable alist$To$HashTable(Object object2, Object object3, Object object4) {
        return srfi69.alist$To$HashTable(object2, object3, object4, numbers.max(Lit0, 2 * Sequences.getSize(object2)));
    }

    /*
     * Exception decompiling
     */
    public static hashtable.HashTable alist$To$HashTable(Object alist, Object comparison, Object hash, Object size) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    static Object lambda1(Object x) {
        return x;
    }

    public static Object hashTable$To$Alist(hashtable.HashTable hash$Mntable) {
        return hash$Mntable.toAlist();
    }

    public static hashtable.HashTable hashTableCopy(hashtable.HashTable hash$Mntable) {
        return new hashtable.HashTable(hash$Mntable, true);
    }

    public static void hashTableMerge$Ex(hashtable.HashTable hash$Mntable1, hashtable.HashTable hash$Mntable2) {
        hash$Mntable1.putAll(hash$Mntable2);
    }

    public static Object hashTableKeys(hashtable.HashTable hash$Mntable) {
        return srfi69.hashTableFold(hash$Mntable, lambda$Fn2, LList.Empty);
    }

    static Pair lambda2(Object key, Object val, Object acc) {
        return lists.cons(key, acc);
    }

    public static Object hashTableValues(hashtable.HashTable hash$Mntable) {
        return srfi69.hashTableFold(hash$Mntable, lambda$Fn3, LList.Empty);
    }

    static Pair lambda3(Object key, Object val, Object acc) {
        return lists.cons(val, acc);
    }

    public static {
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
        $instance = new srfi69();
        hash$Mntable$Mndelete$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mndelete$Ex");
        hash$Mntable$Mnexists$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mncontains$Qu");
        hash$Mntable$Mnset$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnset$Ex");
        hash$Mntable$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Qu");
        hash$Mntable$Mnsize = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnsize");
        srfi69 srfi692 = $instance;
        string$Mnhash = new ModuleMethod(srfi692, 1, Lit1, 8193);
        string$Mnci$Mnhash = new ModuleMethod(srfi692, 3, Lit2, 8193);
        hash = new ModuleMethod(srfi692, 5, Lit3, 8193);
        hash$Mnby$Mnidentity = new ModuleMethod(srfi692, 7, Lit4, 8193);
        hash$Mntable$Mnequivalence$Mnfunction = new ModuleMethod(srfi692, 9, Lit5, 4097);
        hash$Mntable$Mnhash$Mnfunction = new ModuleMethod(srfi692, 10, Lit6, 4097);
        make$Mnhash$Mntable = new ModuleMethod(srfi692, 11, Lit7, 12288);
        hash$Mntable$Mnref = new ModuleMethod(srfi692, 15, Lit8, 12290);
        hash$Mntable$Mnref$Sldefault = new ModuleMethod(srfi692, 17, Lit9, 12291);
        hash$Mntable$Mnupdate$Ex = new ModuleMethod(srfi692, 18, Lit10, 16387);
        hash$Mntable$Mnupdate$Ex$Sldefault = new ModuleMethod(srfi692, 20, Lit11, 16388);
        hash$Mntable$Mnwalk = new ModuleMethod(srfi692, 21, Lit12, 8194);
        hash$Mntable$Mnfold = new ModuleMethod(srfi692, 22, Lit13, 12291);
        ModuleMethod moduleMethod = new ModuleMethod(srfi692, 23, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:158");
        lambda$Fn1 = moduleMethod;
        alist$Mn$Grhash$Mntable = new ModuleMethod(srfi692, 24, Lit14, 16385);
        hash$Mntable$Mn$Gralist = new ModuleMethod(srfi692, 28, Lit15, 4097);
        hash$Mntable$Mncopy = new ModuleMethod(srfi692, 29, Lit16, 4097);
        hash$Mntable$Mnmerge$Ex = new ModuleMethod(srfi692, 30, Lit17, 8194);
        ModuleMethod moduleMethod2 = new ModuleMethod(srfi692, 31, null, 12291);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:175");
        lambda$Fn2 = moduleMethod2;
        hash$Mntable$Mnkeys = new ModuleMethod(srfi692, 32, Lit18, 4097);
        ModuleMethod moduleMethod3 = new ModuleMethod(srfi692, 33, null, 12291);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi69.scm:178");
        lambda$Fn3 = moduleMethod3;
        hash$Mntable$Mnvalues = new ModuleMethod(srfi692, 34, Lit19, 4097);
        srfi69.$runBody$();
    }

    public srfi69() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        if (moduleMethod.selector == 11) {
            callContext.proc = moduleMethod;
            callContext.pc = 0;
            return 0;
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 34: {
                Object object3 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object3 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                Object object4 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object4 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 29: {
                Object object5 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object5 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 28: {
                Object object6 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object6 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 24: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 23: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                Object object7 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                Object object8 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object8 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                Object object9 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object9 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                Object object10 = Promise.force(object2, CharSequence.class);
                if (!(object10 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 30: {
                Object object4 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object4 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, hashtable.HashTable.class);
                if (!(object5 instanceof hashtable.HashTable)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 24: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 21: {
                Object object6 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object6 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                Object object8 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object8 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 11: {
                Object object9 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object9) == null) {
                    return -786431;
                }
                callContext.value1 = object9;
                Object object10 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object10) == null) {
                    return -786430;
                }
                callContext.value2 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                callContext.value1 = object2;
                Object object11 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object11) == null) {
                    return -786430;
                }
                callContext.value2 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 5: {
                callContext.value1 = object2;
                Object object12 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object12) == null) {
                    return -786430;
                }
                callContext.value2 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                Object object13 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object13) == null) {
                    return -786430;
                }
                callContext.value2 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 1: {
                Object object14 = Promise.force(object2, CharSequence.class);
                if (!(object14 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object14;
                Object object15 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object15) == null) {
                    return -786430;
                }
                callContext.value2 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 33: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 31: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 24: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 22: {
                Object object5 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object5 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 18: {
                Object object7 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object7 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 17: {
                Object object8 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object8 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 15: {
                Object object9 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object9 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 11: {
                Object object10 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object10) == null) {
                    return -786431;
                }
                callContext.value1 = object10;
                Object object11 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object11) == null) {
                    return -786430;
                }
                callContext.value2 = object11;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 24: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 20: {
                Object object6 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object6 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 18: {
                Object object7 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object7 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.value4 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        if (moduleMethod.selector == 11) {
            return srfi69.makeHashTable();
        }
        return super.apply0(moduleMethod);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return srfi69.stringHash((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 3: {
                return srfi69.stringCiHash(object2);
            }
            case 5: {
                return srfi69.hash(object2);
            }
            case 7: {
                return srfi69.hashByIdentity(object2);
            }
            case 9: {
                return srfi69.hashTableEquivalenceFunction((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 10: {
                return srfi69.hashTableHashFunction((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 11: {
                return srfi69.makeHashTable(LangObjType.coerceToProcedure(Promise.force(object2, Procedure.class)));
            }
            case 23: {
                return srfi69.lambda1(object2);
            }
            case 24: {
                return srfi69.alist$To$HashTable(object2);
            }
            case 28: {
                return srfi69.hashTable$To$Alist((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 29: {
                return srfi69.hashTableCopy((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 32: {
                return srfi69.hashTableKeys((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 34: {
                return srfi69.hashTableValues((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-hash", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hash-table-equivalence-function", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hash-table-hash-function", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-hash-table", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hash-table->alist", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hash-table-copy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hash-table-keys", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hash-table-values", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5) {
        switch (moduleMethod.selector) {
            case 18: {
                srfi69.hashTableUpdate$Ex((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class), object3, object4, object5);
                return Values.empty;
            }
            case 20: {
                srfi69.hashTableUpdate$Ex$SlDefault((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class), object3, object4, object5);
                return Values.empty;
            }
            case 24: {
                return srfi69.alist$To$HashTable(object2, object3, object4, object5);
            }
        }
        return super.apply4(moduleMethod, object2, object3, object4, object5);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hash-table-update!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hash-table-update!/default", 1, object2);
        }
    }
}

