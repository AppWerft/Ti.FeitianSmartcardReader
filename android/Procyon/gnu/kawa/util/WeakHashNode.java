// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.util;

import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.lang.ref.WeakReference;

public class WeakHashNode<K, V> extends WeakReference<K> implements Map.Entry<K, V>
{
    public WeakHashNode<K, V> next;
    public int hash;
    public V value;
    
    public WeakHashNode(final K key, final ReferenceQueue<K> q, final int hash) {
        super(key, q);
        this.hash = hash;
    }
    
    @Override
    public K getKey() {
        return this.get();
    }
    
    @Override
    public V getValue() {
        return this.value;
    }
    
    @Override
    public V setValue(final V value) {
        final V old = this.value;
        this.value = value;
        return old;
    }
}
