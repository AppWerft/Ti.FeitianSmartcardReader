// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.mapping.LocationEnumeration;
import java.util.Iterator;
import java.util.AbstractSet;
import gnu.mapping.Location;
import java.util.Map;
import java.util.Set;
import gnu.mapping.Symbol;
import gnu.mapping.SimpleEnvironment;
import javax.script.Bindings;
import java.util.AbstractMap;

public class KawaScriptBindings extends AbstractMap<String, Object> implements Bindings
{
    final SimpleEnvironment environment;
    
    public KawaScriptBindings(final SimpleEnvironment environment) {
        this.environment = environment;
    }
    
    Symbol asSymbol(final String name) {
        if (name.length() > 0 && name.charAt(0) == '{') {
            return Symbol.parse(name);
        }
        return this.environment.getSymbol(name);
    }
    
    @Override
    public Object get(final Object key) {
        return this.environment.get(key);
    }
    
    @Override
    public Object put(final String key, final Object value) {
        return this.environment.put(key, value);
    }
    
    @Override
    public Set<Map.Entry<String, Object>> entrySet() {
        return new EntrySet();
    }
    
    class Entry implements Map.Entry<String, Object>
    {
        Location nloc;
        
        public Entry(final Location nloc) {
            this.nloc = nloc;
        }
        
        @Override
        public String getKey() {
            return this.nloc.getKeySymbol().toString();
        }
        
        @Override
        public Object getValue() {
            return this.nloc.getValue();
        }
        
        @Override
        public Object setValue(final Object v) {
            return this.nloc.setValue(v);
        }
        
        @Override
        public int hashCode() {
            return this.nloc.hashCode();
        }
        
        @Override
        public boolean equals(final Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            final Entry e2 = (Entry)o;
            if (this.getKey() == null) {
                if (e2.getKey() != null) {
                    return false;
                }
            }
            else if (!this.getKey().equals(e2.getKey())) {
                return false;
            }
            if ((this.getValue() != null) ? this.getValue().equals(e2.getValue()) : (e2.getValue() == null)) {
                return true;
            }
            return false;
        }
    }
    
    class EntrySet extends AbstractSet<Map.Entry<String, Object>>
    {
        @Override
        public Iterator<Map.Entry<String, Object>> iterator() {
            return new Iterator<Map.Entry<String, Object>>() {
                LocationEnumeration locEnum = KawaScriptBindings.this.environment.enumerateLocations();
                
                @Override
                public boolean hasNext() {
                    return this.locEnum.hasNext();
                }
                
                @Override
                public Map.Entry<String, Object> next() {
                    return new Entry(this.locEnum.next());
                }
                
                @Override
                public void remove() {
                    this.locEnum.remove();
                }
            };
        }
        
        @Override
        public int size() {
            return KawaScriptBindings.this.environment.size();
        }
    }
}
