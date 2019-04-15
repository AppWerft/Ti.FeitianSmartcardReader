/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import java.lang.ref.WeakReference;

class Entry {
    Entry chain;
    Object value;
    Object key1;
    Object key2;

    Entry() {
    }

    public Object getKey1() {
        if (this.key1 instanceof WeakReference) {
            return ((WeakReference)this.key1).get();
        }
        return this.key1;
    }

    public Object getKey2() {
        if (this.key2 instanceof WeakReference) {
            return ((WeakReference)this.key2).get();
        }
        return this.key2;
    }

    public boolean matches(Object key1, Object key2) {
        return key1 == this.getKey1() && key2 == this.getKey2();
    }

    public Object getValue() {
        return this.value == this ? null : this.value;
    }
}

