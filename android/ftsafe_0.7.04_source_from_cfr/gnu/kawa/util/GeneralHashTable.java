/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.HashNode;
import java.util.Map;

public class GeneralHashTable<K, V>
extends AbstractHashTable<HashNode<K, V>, K, V> {
    public GeneralHashTable() {
    }

    public GeneralHashTable(int capacity) {
        super(capacity);
    }

    @Override
    protected int getEntryHashCode(HashNode<K, V> entry) {
        return entry.keyHash;
    }

    @Override
    protected HashNode<K, V> getEntryNext(HashNode<K, V> entry) {
        return entry.next;
    }

    @Override
    protected void setEntryNext(HashNode<K, V> entry, HashNode<K, V> next) {
        entry.next = next;
    }

    protected HashNode<K, V>[] allocEntries(int n) {
        return new HashNode[n];
    }

    @Override
    protected HashNode<K, V> makeEntry(K key, int hash, V value) {
        return new HashNode<K, V>(key, value, hash);
    }

    @Override
    public HashNode<K, V> getNode(Object key) {
        return (HashNode)super.getNode(key);
    }
}

