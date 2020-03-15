// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

public class IdentityHashTable<K, V> extends GeneralHashTable<K, V>
{
    public IdentityHashTable() {
    }
    
    public IdentityHashTable(final int capacity) {
        super(capacity);
    }
    
    @Override
    public int hash(final Object key) {
        return System.identityHashCode(key);
    }
    
    public boolean matches(final K value1, final Object value2) {
        return value1 == value2;
    }
}
