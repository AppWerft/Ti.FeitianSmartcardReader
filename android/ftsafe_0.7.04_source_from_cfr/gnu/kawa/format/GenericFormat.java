/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.format;

import gnu.kawa.format.AbstractFormat;
import gnu.lists.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericFormat
extends AbstractFormat {
    protected AbstractFormat next;
    List<Entry> entries = new ArrayList<Entry>();
    Map<Class, Object[]> map = new HashMap<Class, Object[]>();

    public GenericFormat() {
    }

    public GenericFormat(AbstractFormat next) {
        this.next = next;
    }

    public void add(Entry entry) {
        this.entries.add(entry);
    }

    public void add(Class cls, String mname) {
        this.add(Entry.valueOf(cls, mname));
    }

    public void addInvalidatingCache(Entry entry, Class cls) {
        this.invalidateCache(cls);
        this.entries.add(entry);
    }

    public void invalidateCache(Class cls) {
        Iterator<Class> it = this.map.keySet().iterator();
        while (it.hasNext()) {
            Class key = it.next();
            if (!cls.isAssignableFrom(key)) continue;
            it.remove();
        }
    }

    @Override
    public void writeObject(Object value, Consumer out) {
        AbstractFormat next;
        GenericFormat curFormat = this;
        do {
            if (curFormat.tryFormat(value, this, out)) {
                return;
            }
            next = curFormat.next;
            if (!(next instanceof GenericFormat)) break;
            curFormat = (GenericFormat)next;
        } while (true);
        if (next != null) {
            next.writeObject(value, out);
        } else {
            out.write(value == null ? "(null)" : value.toString());
        }
    }

    public boolean tryFormat(Object value, AbstractFormat format, Consumer out) {
        int oldestEntry;
        Class cls = value == null ? Object.class : value.getClass();
        Object[] cache = this.map.get(cls);
        int j = 0;
        if (cache != null) {
            Object entry;
            while ((entry = cache[j]) instanceof Entry) {
                TryFormatResult res = ((Entry)entry).tryFormat(value, format, out);
                if (res == TryFormatResult.HANDLED) {
                    return true;
                }
                ++j;
            }
            oldestEntry = (Integer)entry;
        } else {
            oldestEntry = this.entries.size();
            cache = new Object[8];
            j = 0;
        }
        int i = oldestEntry;
        while (--i >= 0) {
            Entry entry = this.entries.get(i);
            TryFormatResult res = entry.tryFormat(value, format, out);
            if (res == TryFormatResult.INVALID_CLASS) continue;
            if (j + 2 >= cache.length) {
                Object[] tmp = new Object[3 * cache.length >> 1];
                System.arraycopy(cache, 0, tmp, 0, cache.length);
                cache = tmp;
            }
            cache[j++] = entry;
            if (res != TryFormatResult.HANDLED) continue;
            cache[j++] = i;
            this.map.put(cls, cache);
            return true;
        }
        cache[j++] = 0;
        this.map.put(cls, cache);
        return false;
    }

    public static class MethodEntry
    extends Entry {
        Method method;
        private static final Class[] mtype = new Class[]{Object.class, AbstractFormat.class, Consumer.class};

        @Override
        public TryFormatResult tryFormat(Object value, AbstractFormat format, Consumer out) {
            try {
                return (TryFormatResult)((Object)this.method.invoke(null, value, format, out));
            }
            catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static class Entry {
        public static Entry defaultInstance = new Entry();

        public TryFormatResult tryFormat(Object value, AbstractFormat format, Consumer out) {
            out.write(value == null ? "(null)" : value.toString());
            return TryFormatResult.HANDLED;
        }

        public static Entry valueOf(Class cls, String mname) {
            MethodEntry entry = new MethodEntry();
            try {
                entry.method = cls.getDeclaredMethod(mname, MethodEntry.mtype);
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            return entry;
        }
    }

    public static enum TryFormatResult {
        INVALID_CLASS,
        INVALID,
        HANDLED;
        
    }

}

