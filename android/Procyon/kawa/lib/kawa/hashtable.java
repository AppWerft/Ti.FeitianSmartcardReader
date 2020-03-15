// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import kawa.lib.lists;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.FVector;
import gnu.expr.KawaConvert;
import gnu.mapping.Procedure;
import gnu.kawa.util.GeneralHashTable;
import gnu.mapping.WrongType;
import gnu.mapping.Values;
import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.kawa.util.HashNode;
import gnu.mapping.Symbol;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class hashtable extends ModuleBody
{
    public static final Class hashtable;
    public static final ModuleMethod hashtable$Mncheck$Mnmutable;
    public static final StaticFieldLocation $Prvt$let$St;
    public static final StaticFieldLocation $Prvt$do;
    public static final Class $Prvt$hashnode;
    public static hashtable $instance;
    static final SimpleSymbol Lit0;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static void hashtableCheckMutable(final HashTable ht) {
        if (!ht.mutable) {
            exceptions.error("cannot modify non-mutable hashtable");
            throw Special.reachedUnexpected;
        }
    }
    
    static {
        Lit0 = Symbol.valueOf("hashtable-check-mutable");
        $Prvt$hashnode = HashNode.class;
        kawa.lib.kawa.hashtable.$instance = new hashtable();
        $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
        $Prvt$do = StaticFieldLocation.make("kawa.lib.std_syntax", "do");
        hashtable = HashTable.class;
        hashtable$Mncheck$Mnmutable = new ModuleMethod(kawa.lib.kawa.hashtable.$instance, 1, kawa.lib.kawa.hashtable.Lit0, 4097);
        $runBody$();
    }
    
    public hashtable() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector != 1) {
            return super.match1(moduleMethod, o, ctx);
        }
        final Object force = Promise.force(o, HashTable.class);
        if (!(force instanceof HashTable)) {
            return -786431;
        }
        ctx.value1 = force;
        ctx.proc = moduleMethod;
        ctx.pc = 1;
        return 0;
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object argValue) {
        Label_0027: {
            if (method.selector != 1) {
                break Label_0027;
            }
            final Object force = Promise.force(argValue, HashTable.class);
            try {
                hashtableCheckMutable((HashTable)force);
                return Values.empty;
                return super.apply1(method, argValue);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "hashtable-check-mutable", 1, argValue);
            }
        }
    }
    
    public class HashTable extends GeneralHashTable
    {
        public Procedure equivalenceFunction;
        public Procedure hashFunction;
        public boolean mutable;
        
        private void $finit$() {
            this.mutable = true;
        }
        
        public HashTable(final Procedure eq, final Procedure h, final int sz) {
            super(sz);
            this.$finit$();
            this.equivalenceFunction = eq;
            this.hashFunction = h;
        }
        
        public HashTable(final Procedure eq, final Procedure h) {
            this.$finit$();
            this.equivalenceFunction = eq;
            this.hashFunction = h;
        }
        
        public HashTable(final HashTable ht, final boolean mutable) {
            this(ht.equivalenceFunction, ht.hashFunction, mutable ? (ht.size() + 100) : ht.size());
            this.putAll(ht);
            this.mutable = mutable;
        }
        
        @Override
        public int hash(final Object key) {
            return ((Number)Promise.force(this.hashFunction.apply1(key))).intValue();
        }
        
        public boolean matches(final Object value1, final Object value2) {
            return KawaConvert.isTrue(Promise.force(this.equivalenceFunction.apply2(value1, value2)));
        }
        
        public void walk(final Procedure proc) {
            final Entry[] table2 = (Entry[])super.table;
            try {
                final HashNode[] table = (HashNode[])table2;
                final int length = table.length;
                for (int i = length - 1; i >= 0; --i) {
                    HashNode<Object, Object> entryNext = (HashNode<Object, Object>)table[i];
                    while (true) {
                        final HashNode node = entryNext;
                        if (node == null) {
                            break;
                        }
                        proc.apply2(node.getKey(), node.getValue());
                        entryNext = this.getEntryNext((HashNode<Object, Object>)node);
                    }
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "table", -2, table2);
            }
        }
        
        public Object fold(final Procedure proc, Object acc) {
            final Entry[] table2 = (Entry[])super.table;
            try {
                final HashNode[] table = (HashNode[])table2;
                final int length = table.length;
                for (int i = length - 1; i >= 0; --i) {
                    HashNode<Object, Object> entryNext = (HashNode<Object, Object>)table[i];
                    while (true) {
                        final HashNode node = entryNext;
                        if (node == null) {
                            break;
                        }
                        acc = proc.apply3(node.getKey(), node.getValue(), acc);
                        entryNext = this.getEntryNext((HashNode<Object, Object>)node);
                    }
                }
                return acc;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "table", -2, table2);
            }
        }
        
        public FVector keysVector() {
            final FVector v = new FVector();
            final Entry[] table2 = (Entry[])super.table;
            try {
                final HashNode[] table = (HashNode[])table2;
                final int length = table.length;
                for (int i = length - 1; i >= 0; --i) {
                    HashNode<Object, Object> entryNext = (HashNode<Object, Object>)table[i];
                    while (true) {
                        final HashNode node = entryNext;
                        if (node == null) {
                            break;
                        }
                        v.add(node.getKey());
                        entryNext = this.getEntryNext((HashNode<Object, Object>)node);
                    }
                }
                return v;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "table", -2, table2);
            }
        }
        
        public Pair entriesVectorPair() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: dup            
            //     4: invokespecial   gnu/lists/FVector.<init>:()V
            //     7: astore_1       
            //     8: new             Lgnu/lists/FVector;
            //    11: dup            
            //    12: invokespecial   gnu/lists/FVector.<init>:()V
            //    15: astore_2        /* vals */
            //    16: aload_0         /* this */
            //    17: getfield        gnu/kawa/util/AbstractHashTable.table:[Ljava/util/Map$Entry;
            //    20: dup            
            //    21: astore          4
            //    23: checkcast       [Lgnu/kawa/util/HashNode;
            //    26: astore_3        /* table */
            //    27: aload_3         /* table */
            //    28: arraylength    
            //    29: istore          length
            //    31: iload           length
            //    33: iconst_1       
            //    34: isub           
            //    35: istore          i
            //    37: iload           i
            //    39: iflt            91
            //    42: aload_3         /* table */
            //    43: iload           i
            //    45: aaload         
            //    46: astore          node
            //    48: aload           node
            //    50: ifnull          85
            //    53: aload_1         /* keys */
            //    54: aload           node
            //    56: invokevirtual   gnu/kawa/util/HashNode.getKey:()Ljava/lang/Object;
            //    59: invokevirtual   gnu/lists/FVector.add:(Ljava/lang/Object;)Z
            //    62: pop            
            //    63: aload_2         /* vals */
            //    64: aload           node
            //    66: invokevirtual   gnu/kawa/util/HashNode.getValue:()Ljava/lang/Object;
            //    69: invokevirtual   gnu/lists/FVector.add:(Ljava/lang/Object;)Z
            //    72: pop            
            //    73: aload_0         /* this */
            //    74: aload           node
            //    76: dup            
            //    77: astore          7
            //    79: invokevirtual   kawa/lib/kawa/hashtable$HashTable.getEntryNext:(Lgnu/kawa/util/HashNode;)Lgnu/kawa/util/HashNode;
            //    82: goto            46
            //    85: iinc            i, -1
            //    88: goto            37
            //    91: aload_1         /* keys */
            //    92: aload_2         /* vals */
            //    93: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
            //    96: areturn        
            //    97: new             Lgnu/mapping/WrongType;
            //   100: dup_x1         
            //   101: swap           
            //   102: ldc             "table"
            //   104: bipush          -2
            //   106: aload           4
            //   108: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
            //   111: athrow         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                          
            //  -----  -----  -----  -----  ------------------------------
            //  23     26     97     112    Ljava/lang/ClassCastException;
            // 
            // The error that occurred was:
            // 
            // java.lang.NullPointerException
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        public Object toAlist() {
            Object result = LList.Empty;
            final Entry[] table2 = (Entry[])super.table;
            try {
                final HashNode[] table = (HashNode[])table2;
                final int length = table.length;
                for (int i = length - 1; i >= 0; --i) {
                    HashNode<Object, Object> entryNext = (HashNode<Object, Object>)table[i];
                    while (true) {
                        final HashNode node = entryNext;
                        if (node == null) {
                            break;
                        }
                        result = lists.cons(lists.cons(node.getKey(), node.getValue()), result);
                        entryNext = this.getEntryNext((HashNode<Object, Object>)node);
                    }
                }
                return result;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "table", -2, table2);
            }
        }
        
        public LList toNodeList() {
            Object result = LList.Empty;
            final Entry[] table2 = (Entry[])super.table;
            try {
                final HashNode[] table = (HashNode[])table2;
                final int length = table.length;
                for (int i = length - 1; i >= 0; --i) {
                    HashNode<Object, Object> entryNext = (HashNode<Object, Object>)table[i];
                    while (true) {
                        final HashNode node = entryNext;
                        if (node == null) {
                            break;
                        }
                        result = lists.cons(node, result);
                        entryNext = this.getEntryNext((HashNode<Object, Object>)node);
                    }
                }
                return (LList)Promise.force(result, LList.class);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "table", -2, table2);
            }
        }
        
        public HashNode[] toNodeArray() {
            final int n = this.size();
            final HashNode[] result = new HashNode[n];
            int i = 0;
            final Entry[] table2 = (Entry[])super.table;
            try {
                final HashNode[] table = (HashNode[])table2;
                final int length = table.length;
                for (int j = length - 1; j >= 0; --j) {
                    HashNode<Object, Object> entryNext = (HashNode<Object, Object>)table[j];
                    while (true) {
                        final HashNode node = entryNext;
                        if (node == null) {
                            break;
                        }
                        result[i] = node;
                        ++i;
                        entryNext = this.getEntryNext((HashNode<Object, Object>)node);
                    }
                }
                return result;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "table", -2, table2);
            }
        }
        
        public void putAll(final HashTable other) {
            final Entry[] table2 = other.table;
            try {
                final HashNode[] table = (HashNode[])table2;
                final int length = table.length;
                for (int i = length - 1; i >= 0; --i) {
                    HashNode<Object, Object> entryNext = (HashNode<Object, Object>)table[i];
                    while (true) {
                        final HashNode node = entryNext;
                        if (node == null) {
                            break;
                        }
                        this.put(node.getKey(), node.getValue());
                        entryNext = other.getEntryNext((HashNode<Object, Object>)node);
                    }
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "table", -2, table2);
            }
        }
        
        public Object clone() {
            return new HashTable(this, true);
        }
    }
}
