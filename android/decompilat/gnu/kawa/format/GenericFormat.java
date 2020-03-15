// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.format;

import java.lang.reflect.Method;
import gnu.lists.Consumer;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class GenericFormat extends AbstractFormat
{
    protected AbstractFormat next;
    List<Entry> entries;
    Map<Class, Object[]> map;
    
    public GenericFormat() {
        this.entries = new ArrayList<Entry>();
        this.map = new HashMap<Class, Object[]>();
    }
    
    public GenericFormat(final AbstractFormat next) {
        this.entries = new ArrayList<Entry>();
        this.map = new HashMap<Class, Object[]>();
        this.next = next;
    }
    
    public void add(final Entry entry) {
        this.entries.add(entry);
    }
    
    public void add(final Class cls, final String mname) {
        this.add(Entry.valueOf(cls, mname));
    }
    
    public void addInvalidatingCache(final Entry entry, final Class cls) {
        this.invalidateCache(cls);
        this.entries.add(entry);
    }
    
    public void invalidateCache(final Class cls) {
        final Iterator<Class> it = (Iterator<Class>)this.map.keySet().iterator();
        while (it.hasNext()) {
            final Class key = it.next();
            if (cls.isAssignableFrom(key)) {
                it.remove();
            }
        }
    }
    
    @Override
    public void writeObject(final Object value, final Consumer out) {
        AbstractFormat next;
        for (GenericFormat curFormat = this; !curFormat.tryFormat(value, this, out); curFormat = (GenericFormat)next) {
            next = curFormat.next;
            if (!(next instanceof GenericFormat)) {
                if (next != null) {
                    next.writeObject(value, out);
                }
                else {
                    out.write((value == null) ? "(null)" : value.toString());
                }
                return;
            }
        }
    }
    
    public boolean tryFormat(final Object value, final AbstractFormat format, final Consumer out) {
        final Class cls = (value == null) ? Object.class : value.getClass();
        Object[] cache = this.map.get(cls);
        int j = 0;
        int oldestEntry;
        if (cache != null) {
            while (true) {
                final Object entry = cache[j];
                if (!(entry instanceof Entry)) {
                    oldestEntry = (int)entry;
                    break;
                }
                final TryFormatResult res = ((Entry)entry).tryFormat(value, format, out);
                if (res == TryFormatResult.HANDLED) {
                    return true;
                }
                ++j;
            }
        }
        else {
            oldestEntry = this.entries.size();
            cache = new Object[8];
            j = 0;
        }
        int i = oldestEntry;
        while (--i >= 0) {
            final Entry entry2 = this.entries.get(i);
            final TryFormatResult res2 = entry2.tryFormat(value, format, out);
            if (res2 == TryFormatResult.INVALID_CLASS) {
                continue;
            }
            if (j + 2 >= cache.length) {
                final Object[] tmp = new Object[3 * cache.length >> 1];
                System.arraycopy(cache, 0, tmp, 0, cache.length);
                cache = tmp;
            }
            cache[j++] = entry2;
            if (res2 == TryFormatResult.HANDLED) {
                cache[j++] = i;
                this.map.put(cls, cache);
                return true;
            }
        }
        cache[j++] = 0;
        this.map.put(cls, cache);
        return false;
    }
    
    public enum TryFormatResult
    {
        INVALID_CLASS, 
        INVALID, 
        HANDLED;
    }
    
    public static class Entry
    {
        public static Entry defaultInstance;
        
        public TryFormatResult tryFormat(final Object value, final AbstractFormat format, final Consumer out) {
            out.write((value == null) ? "(null)" : value.toString());
            return TryFormatResult.HANDLED;
        }
        
        public static Entry valueOf(final Class cls, final String mname) {
            final MethodEntry entry = new MethodEntry();
            try {
                entry.method = cls.getDeclaredMethod(mname, (Class[])MethodEntry.mtype);
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            return entry;
        }
        
        static {
            Entry.defaultInstance = new Entry();
        }
    }
    
    public static class MethodEntry extends Entry
    {
        Method method;
        private static final Class[] mtype;
        
        @Override
        public TryFormatResult tryFormat(final Object value, final AbstractFormat format, final Consumer out) {
            try {
                return (TryFormatResult)this.method.invoke(null, value, format, out);
            }
            catch (Throwable ex) {
                throw new RuntimeException(ex);
            }
        }
        
        static {
            mtype = new Class[] { Object.class, AbstractFormat.class, Consumer.class };
        }
    }
}
