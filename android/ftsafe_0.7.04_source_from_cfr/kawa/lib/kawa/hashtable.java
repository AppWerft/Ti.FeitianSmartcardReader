/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.GeneralHashTable;
import gnu.kawa.util.HashNode;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.exceptions;
import kawa.lib.lists;

public class hashtable
extends ModuleBody {
    public static final Class hashtable;
    public static final ModuleMethod hashtable$Mncheck$Mnmutable;
    public static final StaticFieldLocation $Prvt$let$St;
    public static final StaticFieldLocation $Prvt$do;
    public static final Class $Prvt$hashnode;
    public static hashtable $instance;
    static final SimpleSymbol Lit0;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static void hashtableCheckMutable(HashTable ht) {
        if (!ht.mutable) {
            Type.NeverReturns neverReturns = exceptions.error("cannot modify non-mutable hashtable");
            throw Special.reachedUnexpected;
        }
    }

    public static {
        Lit0 = Symbol.valueOf("hashtable-check-mutable");
        $Prvt$hashnode = HashNode.class;
        $instance = new hashtable();
        $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
        $Prvt$do = StaticFieldLocation.make("kawa.lib.std_syntax", "do");
        hashtable = HashTable.class;
        hashtable hashtable2 = $instance;
        hashtable$Mncheck$Mnmutable = new ModuleMethod(hashtable2, 1, Lit0, 4097);
        hashtable.$runBody$();
    }

    public hashtable() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            Object object3 = Promise.force(object2, HashTable.class);
            if (!(object3 instanceof HashTable)) {
                return -786431;
            }
            callContext.value1 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector != 1) return super.apply1(moduleMethod, object2);
        try {
            hashtable.hashtableCheckMutable((HashTable)Promise.force(object2, HashTable.class));
            return Values.empty;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "hashtable-check-mutable", 1, object2);
        }
    }

    public class HashTable
    extends GeneralHashTable {
        public Procedure equivalenceFunction;
        public Procedure hashFunction;
        public boolean mutable;

        private void $finit$() {
            this.mutable = true;
        }

        public HashTable(Procedure eq, Procedure h, int sz) {
            super(sz);
            this.$finit$();
            this.equivalenceFunction = eq;
            this.hashFunction = h;
        }

        public HashTable(Procedure procedure, Procedure procedure2) {
            void eq;
            void h;
            this.$finit$();
            this.equivalenceFunction = eq;
            this.hashFunction = h;
        }

        public HashTable(HashTable ht, boolean mutable) {
            this(ht.equivalenceFunction, ht.hashFunction, mutable ? ht.size() + 100 : ht.size());
            this.putAll(ht);
            this.mutable = mutable;
        }

        public int hash(Object key) {
            return ((Number)Promise.force(this.hashFunction.apply1(key))).intValue();
        }

        public boolean matches(Object value1, Object value2) {
            return KawaConvert.isTrue(Promise.force(this.equivalenceFunction.apply2(value1, value2)));
        }

        public void walk(Procedure proc) {
            HashNode[] table;
            Entry[] arrEntry = this.table;
            try {
                table = (HashNode[])arrEntry;
            }
            catch (ClassCastException classCastException) {
                void length;
                throw new WrongType(classCastException, "table", -2, (Object)length);
            }
            int length = table.length;
            for (int i = length - 1; i >= 0; --i) {
                HashNode node;
                HashNode hashNode = table[i];
                while ((node = hashNode) != null) {
                    proc.apply2(node.getKey(), node.getValue());
                    HashNode hashNode2 = node;
                    hashNode = this.getEntryNext(hashNode2);
                }
            }
            return;
        }

        public Object fold(Procedure proc, Object acc) {
            HashNode[] table;
            Entry[] arrEntry = this.table;
            try {
                table = (HashNode[])arrEntry;
            }
            catch (ClassCastException classCastException) {
                void length;
                throw new WrongType(classCastException, "table", -2, (Object)length);
            }
            int length = table.length;
            for (int i = length - 1; i >= 0; --i) {
                HashNode node;
                HashNode hashNode = table[i];
                while ((node = hashNode) != null) {
                    acc = proc.apply3(node.getKey(), node.getValue(), acc);
                    HashNode hashNode2 = node;
                    hashNode = this.getEntryNext(hashNode2);
                }
            }
            return acc;
        }

        public FVector keysVector() {
            HashNode[] table;
            FVector v = new FVector();
            Entry[] arrEntry = this.table;
            try {
                table = (HashNode[])arrEntry;
            }
            catch (ClassCastException classCastException) {
                void length;
                throw new WrongType(classCastException, "table", -2, (Object)length);
            }
            int length = table.length;
            for (int i = length - 1; i >= 0; --i) {
                HashNode node;
                HashNode hashNode = table[i];
                while ((node = hashNode) != null) {
                    v.add(node.getKey());
                    HashNode hashNode2 = node;
                    hashNode = this.getEntryNext(hashNode2);
                }
            }
            return v;
        }

        public Pair entriesVectorPair() {
            void keys;
            HashNode[] table;
            FVector fVector = new FVector();
            FVector vals = new FVector();
            Entry[] arrEntry = this.table;
            try {
                table = (HashNode[])arrEntry;
            }
            catch (ClassCastException classCastException) {
                void length;
                throw new WrongType(classCastException, "table", -2, (Object)length);
            }
            int length = table.length;
            for (int i = length - 1; i >= 0; --i) {
                HashNode node;
                HashNode hashNode = table[i];
                while ((node = hashNode) != null) {
                    keys.add(node.getKey());
                    vals.add(node.getValue());
                    HashNode hashNode2 = node;
                    hashNode = this.getEntryNext(hashNode2);
                }
            }
            return lists.cons(keys, vals);
        }

        public Object toAlist() {
            HashNode[] table;
            LList result = LList.Empty;
            Entry[] arrEntry = this.table;
            try {
                table = (HashNode[])arrEntry;
            }
            catch (ClassCastException classCastException) {
                void length;
                throw new WrongType(classCastException, "table", -2, (Object)length);
            }
            int length = table.length;
            for (int i = length - 1; i >= 0; --i) {
                HashNode node;
                HashNode hashNode = table[i];
                while ((node = hashNode) != null) {
                    result = lists.cons(lists.cons(node.getKey(), node.getValue()), result);
                    HashNode hashNode2 = node;
                    hashNode = this.getEntryNext(hashNode2);
                }
            }
            return result;
        }

        public LList toNodeList() {
            HashNode[] table;
            LList result = LList.Empty;
            Entry[] arrEntry = this.table;
            try {
                table = (HashNode[])arrEntry;
            }
            catch (ClassCastException classCastException) {
                void length;
                throw new WrongType(classCastException, "table", -2, (Object)length);
            }
            int length = table.length;
            for (int i = length - 1; i >= 0; --i) {
                HashNode node;
                HashNode hashNode = table[i];
                while ((node = hashNode) != null) {
                    result = lists.cons(node, result);
                    HashNode hashNode2 = node;
                    hashNode = this.getEntryNext(hashNode2);
                }
            }
            return (LList)Promise.force(result, LList.class);
        }

        public HashNode[] toNodeArray() {
            HashNode[] table;
            int n = this.size();
            HashNode[] result = new HashNode[n];
            int i = 0;
            Entry[] arrEntry = this.table;
            try {
                table = (HashNode[])arrEntry;
            }
            catch (ClassCastException classCastException) {
                void length;
                throw new WrongType(classCastException, "table", -2, (Object)length);
            }
            int length = table.length;
            for (int i2 = length - 1; i2 >= 0; --i2) {
                HashNode node;
                HashNode hashNode = table[i2];
                while ((node = hashNode) != null) {
                    result[i] = node;
                    ++i;
                    HashNode hashNode2 = node;
                    hashNode = this.getEntryNext(hashNode2);
                }
            }
            return result;
        }

        public void putAll(HashTable other) {
            HashNode[] table;
            Entry[] arrEntry = other.table;
            try {
                table = (HashNode[])arrEntry;
            }
            catch (ClassCastException classCastException) {
                void length;
                throw new WrongType(classCastException, "table", -2, (Object)length);
            }
            int length = table.length;
            for (int i = length - 1; i >= 0; --i) {
                HashNode node;
                HashNode hashNode = table[i];
                while ((node = hashNode) != null) {
                    this.put(node.getKey(), node.getValue());
                    HashNode hashNode2 = node;
                    hashNode = other.getEntryNext(hashNode2);
                }
            }
            return;
        }

        public Object clone() {
            return new HashTable(this, true);
        }
    }

}

