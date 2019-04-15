/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import gnu.kawa.util.GeneralHashTable;
import gnu.kawa.util.HashNode;
import gnu.text.Char;
import java.util.Map;

public class NamedCharTable
extends GeneralHashTable<String, String> {
    @Override
    protected HashNode<String, String> makeEntry(String key, int hash, String value) {
        return new Entry(key, value, hash);
    }

    public boolean appendTo(String key, Appendable out) {
        Entry e = (Entry)this.getNode(key);
        if (e == null) {
            return false;
        }
        e.appendTo(out);
        return true;
    }

    @Override
    public void put(String name, int char1) {
        this.put(name, null);
        Entry e = (Entry)this.getNode(name);
        e.char1 = char1;
    }

    @Override
    public void put(String name, int char1, int char2) {
        this.put(name, null);
        Entry e = (Entry)this.getNode(name);
        e.char1 = char1;
        e.char2 = char2;
    }

    static class Entry
    extends HashNode<String, String> {
        int char1;
        int char2;

        public Entry(String key, String value, int hash) {
            super(key, value, hash);
        }

        public void appendTo(Appendable out) {
            Char.print(this.char1, out);
            if (this.char2 != 0) {
                Char.print(this.char2, out);
            }
        }

        @Override
        public synchronized String getValue() {
            String v = (String)super.getValue();
            if (v == null) {
                StringBuilder sb = new StringBuilder(this.char2 == 0 ? 1 : 2);
                this.appendTo(sb);
                v = sb.toString();
                super.setValue(v);
            }
            return v;
        }
    }

}

