/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.util;

import gnu.kawa.util.GeneralHashTable;

public class IdentityHashTable<K, V>
extends GeneralHashTable<K, V> {
    public IdentityHashTable() {
    }

    public IdentityHashTable(int capacity) {
        super(capacity);
    }

    @Override
    public int hash(Object key) {
        return System.identityHashCode(key);
    }

    @Override
    public boolean matches(K value1, Object value2) {
        return value1 == value2;
    }
}

