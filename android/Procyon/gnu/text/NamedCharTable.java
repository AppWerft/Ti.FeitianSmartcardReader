// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import gnu.kawa.util.AbstractHashTable;
import java.util.Map;
import gnu.kawa.util.HashNode;
import gnu.kawa.util.GeneralHashTable;

public class NamedCharTable extends GeneralHashTable<String, String>
{
    @Override
    protected HashNode<String, String> makeEntry(final String key, final int hash, final String value) {
        return new Entry(key, value, hash);
    }
    
    public boolean appendTo(final String key, final Appendable out) {
        final Entry e = (Entry)this.getNode(key);
        if (e == null) {
            return false;
        }
        e.appendTo(out);
        return true;
    }
    
    public void put(final String name, final int char1) {
        ((AbstractHashTable<Entry, K, V>)this).put((K)name, null);
        final Entry e = (Entry)this.getNode(name);
        e.char1 = char1;
    }
    
    public void put(final String name, final int char1, final int char2) {
        ((AbstractHashTable<Entry, K, V>)this).put((K)name, null);
        final Entry e = (Entry)this.getNode(name);
        e.char1 = char1;
        e.char2 = char2;
    }
    
    static class Entry extends HashNode<String, String>
    {
        int char1;
        int char2;
        
        public Entry(final String key, final String value, final int hash) {
            super(key, value, hash);
        }
        
        public void appendTo(final Appendable out) {
            Char.print(this.char1, out);
            if (this.char2 != 0) {
                Char.print(this.char2, out);
            }
        }
        
        @Override
        public synchronized String getValue() {
            String v = super.getValue();
            if (v == null) {
                final StringBuilder sb = new StringBuilder((this.char2 == 0) ? 1 : 2);
                this.appendTo(sb);
                v = sb.toString();
                super.setValue(v);
            }
            return v;
        }
    }
}
