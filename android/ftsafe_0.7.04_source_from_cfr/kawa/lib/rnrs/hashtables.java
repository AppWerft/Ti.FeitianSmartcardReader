/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.HashNode;
import gnu.kawa.util.HashUtils;
import gnu.lists.Consumer;
import gnu.lists.FVector;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import java.util.Map;
import kawa.lib.kawa.hashtable;
import kawa.lib.lists;
import kawa.standard.Scheme;

public class hashtables
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    static int hashByIdentity(Object obj) {
        return System.identityHashCode(obj);
    }

    static int hashForEqv(Object obj) {
        return obj.hashCode();
    }

    public static hashtable.HashTable makeEqHashtable() {
        return hashtables.makeEqHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static hashtable.HashTable makeEqHashtable(int k) {
        return new hashtable.HashTable(Scheme.isEq, hash$Mnby$Mnidentity, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static hashtable.HashTable makeEqvHashtable() {
        return hashtables.makeEqvHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static hashtable.HashTable makeEqvHashtable(int k) {
        return new hashtable.HashTable(Scheme.isEqv, hash$Mnfor$Mneqv, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static hashtable.HashTable makeHashtable(Procedure procedure, Procedure procedure2) {
        return hashtables.makeHashtable(procedure, procedure2, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static hashtable.HashTable makeHashtable(Procedure hash$Mnfunction, Procedure comparison, int size) {
        return new hashtable.HashTable(comparison, hash$Mnfunction, size);
    }

    public static boolean isHashtable(Object obj) {
        return obj instanceof hashtable.HashTable;
    }

    public static int hashtableSize(hashtable.HashTable ht) {
        return ht.size();
    }

    public static Object hashtableRef(hashtable.HashTable ht, Object key, Object object2) {
        Map.Entry node = ht.getNode(key);
        return node == null ? object2 : ((HashNode)node).getValue();
    }

    public static void hashtableSet$Ex(hashtable.HashTable ht, Object key, Object value) {
        hashtable.hashtableCheckMutable(ht);
        ht.put(key, value);
    }

    public static void hashtableDelete$Ex(hashtable.HashTable ht, Object key) {
        hashtable.hashtableCheckMutable(ht);
        ht.remove(key);
    }

    public static boolean isHashtableContains(hashtable.HashTable ht, Object key) {
        return ht.getNode(key) != null;
    }

    public static Object hashtableUpdate$Ex(hashtable.HashTable ht, Object key, Procedure proc, Object object2) {
        Object object3;
        hashtable.hashtableCheckMutable(ht);
        Map.Entry node = ht.getNode(key);
        if (node == null) {
            hashtables.hashtableSet$Ex(ht, key, proc.apply1(object2));
            object3 = Values.empty;
        } else {
            object3 = ((HashNode)node).setValue(proc.apply1(((HashNode)node).getValue()));
        }
        return object3;
    }

    public static hashtable.HashTable hashtableCopy(hashtable.HashTable hashTable) {
        return hashtables.hashtableCopy(hashTable, false);
    }

    public static hashtable.HashTable hashtableCopy(hashtable.HashTable ht, boolean mutable) {
        return new hashtable.HashTable(ht, mutable);
    }

    public static void hashtableClear$Ex(hashtable.HashTable hashTable) {
        hashtables.hashtableClear$Ex(hashTable, 64);
    }

    public static void hashtableClear$Ex(hashtable.HashTable ht, int k) {
        hashtable.hashtableCheckMutable(ht);
        ht.clear();
    }

    public static FVector hashtableKeys(hashtable.HashTable ht) {
        return ht.keysVector();
    }

    public static Values hashtableEntries(hashtable.HashTable ht) {
        Pair pair = ht.entriesVectorPair();
        return Values.values2(lists.car(pair), lists.cdr(pair));
    }

    public static Procedure hashtableEquivalenceFunction(hashtable.HashTable ht) {
        return ht.equivalenceFunction;
    }

    public static Object hashtableHashFunction(hashtable.HashTable ht) {
        Object hasher = ht.hashFunction.apply1(ht);
        boolean x = IsEqv.apply(hasher, hash$Mnby$Mnidentity);
        return (x ? x : IsEqv.apply(hasher, hash$Mnfor$Mneqv)) ? Boolean.FALSE : hasher;
    }

    public static boolean isHashtableMutable(hashtable.HashTable ht) {
        return ht.mutable;
    }

    public static int equalHash(Object key) {
        return HashUtils.boundedHash(key);
    }

    public static int stringHash(CharSequence s) {
        return s.hashCode();
    }

    public static int stringCiHash(CharSequence s) {
        return s.toString().toLowerCase().hashCode();
    }

    public static int symbolHash(Symbol s) {
        return s.hashCode();
    }

    public static {
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
        hashtables hashtables2 = $instance = new hashtables();
        hash$Mnby$Mnidentity = new ModuleMethod(hashtables2, 1, Lit0, 4097);
        hash$Mnfor$Mneqv = new ModuleMethod(hashtables2, 2, Lit1, 4097);
        make$Mneq$Mnhashtable = new ModuleMethod(hashtables2, 3, Lit2, 4096);
        make$Mneqv$Mnhashtable = new ModuleMethod(hashtables2, 5, Lit3, 4096);
        make$Mnhashtable = new ModuleMethod(hashtables2, 7, Lit4, 12290);
        hashtable$Qu = new ModuleMethod(hashtables2, 9, Lit5, 4097);
        hashtable$Mnsize = new ModuleMethod(hashtables2, 10, Lit6, 4097);
        hashtable$Mnref = new ModuleMethod(hashtables2, 11, Lit7, 12291);
        hashtable$Mnset$Ex = new ModuleMethod(hashtables2, 12, Lit8, 12291);
        hashtable$Mndelete$Ex = new ModuleMethod(hashtables2, 13, Lit9, 8194);
        hashtable$Mncontains$Qu = new ModuleMethod(hashtables2, 14, Lit10, 8194);
        hashtable$Mnupdate$Ex = new ModuleMethod(hashtables2, 15, Lit11, 16388);
        hashtable$Mncopy = new ModuleMethod(hashtables2, 16, Lit12, 8193);
        hashtable$Mnclear$Ex = new ModuleMethod(hashtables2, 18, Lit13, 8193);
        hashtable$Mnkeys = new ModuleMethod(hashtables2, 20, Lit14, 4097);
        hashtable$Mnentries = new ModuleMethod(hashtables2, 21, Lit15, 4097);
        hashtable$Mnequivalence$Mnfunction = new ModuleMethod(hashtables2, 22, Lit16, 4097);
        hashtable$Mnhash$Mnfunction = new ModuleMethod(hashtables2, 23, Lit17, 4097);
        hashtable$Mnmutable$Qu = new ModuleMethod(hashtables2, 24, Lit18, 4097);
        equal$Mnhash = new ModuleMethod(hashtables2, 25, Lit19, 4097);
        string$Mnhash = new ModuleMethod(hashtables2, 26, Lit20, 4097);
        string$Mnci$Mnhash = new ModuleMethod(hashtables2, 27, Lit21, 4097);
        symbol$Mnhash = new ModuleMethod(hashtables2, 28, Lit22, 4097);
        hashtables.$runBody$();
    }

    public hashtables() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 5: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 3: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 28: {
                Object object3 = Promise.force(object2, Symbol.class);
                if (!(object3 instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 27: {
                Object object4 = Promise.force(object2, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 26: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 25: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 24: {
                Object object6 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object6 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 23: {
                Object object7 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object7 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 22: {
                Object object8 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object8 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 21: {
                Object object9 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object9 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 20: {
                Object object10 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object10 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                Object object11 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object11 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                Object object12 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object12 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                Object object13 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object13 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 18: {
                Object object4 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object4 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 16: {
                Object object5 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object5 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3);
                if (!(object6 instanceof Boolean)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 14: {
                Object object7 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object7 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 13: {
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
            case 7: {
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
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 12: {
                Object object5 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object5 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 11: {
                Object object6 = Promise.force(object2, hashtable.HashTable.class);
                if (!(object6 instanceof hashtable.HashTable)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 7: {
                Object object7 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object8) == null) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        if (moduleMethod.selector == 15) {
            Object object6 = Promise.force(object2, hashtable.HashTable.class);
            if (!(object6 instanceof hashtable.HashTable)) {
                return -786431;
            }
            callContext.value1 = object6;
            callContext.value2 = object3;
            Object object7 = Promise.force(object4, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                return -786429;
            }
            callContext.value3 = object7;
            callContext.value4 = object5;
            callContext.proc = moduleMethod;
            callContext.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 3: {
                return hashtables.makeEqHashtable();
            }
            case 5: {
                return hashtables.makeEqvHashtable();
            }
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
                return hashtables.hashByIdentity(object2);
            }
            case 2: {
                return hashtables.hashForEqv(object2);
            }
            case 3: {
                return hashtables.makeEqHashtable(((Number)Promise.force(object2)).intValue());
            }
            case 5: {
                return hashtables.makeEqvHashtable(((Number)Promise.force(object2)).intValue());
            }
            case 9: {
                Boolean bl;
                if (hashtables.isHashtable(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 10: {
                return hashtables.hashtableSize((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 16: {
                return hashtables.hashtableCopy((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 18: {
                hashtables.hashtableClear$Ex((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
                return Values.empty;
            }
            case 20: {
                return hashtables.hashtableKeys((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 21: {
                return hashtables.hashtableEntries((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 22: {
                return hashtables.hashtableEquivalenceFunction((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 23: {
                return hashtables.hashtableHashFunction((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class));
            }
            case 24: {
                Boolean bl;
                if (hashtables.isHashtableMutable((hashtable.HashTable)Promise.force(object2, hashtable.HashTable.class))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 25: {
                return hashtables.equalHash(object2);
            }
            case 26: {
                return hashtables.stringHash((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 27: {
                return hashtables.stringCiHash((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 28: {
                return hashtables.symbolHash((Symbol)Promise.force(object2, Symbol.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-eq-hashtable", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-eqv-hashtable", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-size", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-copy", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-clear!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-keys", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-entries", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-equivalence-function", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-hash-function", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-mutable?", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-hash", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-ci-hash", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "symbol-hash", 1, object2);
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
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
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
}

