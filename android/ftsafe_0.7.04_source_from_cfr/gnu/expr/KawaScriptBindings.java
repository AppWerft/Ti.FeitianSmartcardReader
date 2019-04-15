/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.SimpleEnvironment;
import gnu.mapping.Symbol;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.script.Bindings;

public class KawaScriptBindings
extends AbstractMap<String, Object>
implements Bindings {
    final SimpleEnvironment environment;

    public KawaScriptBindings(SimpleEnvironment environment) {
        this.environment = environment;
    }

    Symbol asSymbol(String name) {
        if (name.length() > 0 && name.charAt(0) == '{') {
            return Symbol.parse(name);
        }
        return this.environment.getSymbol(name);
    }

    @Override
    public Object get(Object key) {
        return this.environment.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return this.environment.put(key, value);
    }

    @Override
    public Set<Map.Entry<String, Object>> entrySet() {
        return new EntrySet();
    }

    class EntrySet
    extends AbstractSet<Map.Entry<String, Object>> {
        EntrySet() {
        }

        @Override
        public Iterator<Map.Entry<String, Object>> iterator() {
            return new Iterator<Map.Entry<String, Object>>(){
                LocationEnumeration locEnum;
                {
                    this.locEnum = KawaScriptBindings.this.environment.enumerateLocations();
                }

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

    class Entry
    implements Map.Entry<String, Object> {
        Location nloc;

        public Entry(Location nloc) {
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
        public Object setValue(Object v) {
            return this.nloc.setValue(v);
        }

        @Override
        public int hashCode() {
            return this.nloc.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry e2 = (Entry)o;
            return (this.getKey() == null ? e2.getKey() == null : this.getKey().equals(e2.getKey())) && (this.getValue() == null ? e2.getValue() == null : this.getValue().equals(e2.getValue()));
        }
    }

}

