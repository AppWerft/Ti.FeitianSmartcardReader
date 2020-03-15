// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.util.Map;

public class GeneralHashTable<K, V> extends AbstractHashTable<HashNode<K, V>, K, V>
{
    public GeneralHashTable() {
    }
    
    public GeneralHashTable(final int capacity) {
        super(capacity);
    }
    
    @Override
    protected int getEntryHashCode(final HashNode<K, V> entry) {
        return entry.keyHash;
    }
    
    @Override
    protected HashNode<K, V> getEntryNext(final HashNode<K, V> entry) {
        return entry.next;
    }
    
    @Override
    protected void setEntryNext(final HashNode<K, V> entry, final HashNode<K, V> next) {
        entry.next = next;
    }
    
    @Override
    protected HashNode<K, V>[] allocEntries(final int n) {
        return (HashNode<K, V>[])new HashNode[n];
    }
    
    @Override
    protected HashNode<K, V> makeEntry(final K key, final int hash, final V value) {
        return new HashNode<K, V>(key, value, hash);
    }
    
    @Override
    public HashNode<K, V> getNode(final Object key) {
        return super.getNode(key);
    }
}
