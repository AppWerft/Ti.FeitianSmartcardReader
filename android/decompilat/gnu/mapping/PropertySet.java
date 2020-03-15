// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class PropertySet implements Named
{
    private Object[] properties;
    public static final Symbol nameKey;
    
    @Override
    public String getName() {
        final Object symbol = this.getProperty(PropertySet.nameKey, null);
        return (symbol == null) ? null : ((symbol instanceof Symbol) ? ((Symbol)symbol).getName() : symbol.toString());
    }
    
    @Override
    public Object getSymbol() {
        return this.getProperty(PropertySet.nameKey, null);
    }
    
    public final void setSymbol(final Object name) {
        this.setProperty(PropertySet.nameKey, name);
    }
    
    @Override
    public final void setName(final String name) {
        this.setProperty(PropertySet.nameKey, name);
    }
    
    public Object getProperty(final Object key, final Object defaultValue) {
        if (this.properties != null) {
            int i = this.properties.length;
            do {
                i -= 2;
                if (i >= 0) {
                    continue;
                }
                return defaultValue;
            } while (this.properties[i] != key);
            return this.properties[i + 1];
        }
        return defaultValue;
    }
    
    public synchronized void setProperty(final Object key, final Object value) {
        this.properties = setProperty(this.properties, key, value);
    }
    
    public static Object[] setProperty(Object[] properties, final Object key, final Object value) {
        Object[] props = properties;
        int avail;
        if (props == null) {
            props = (properties = new Object[10]);
            avail = 0;
        }
        else {
            avail = -1;
            int i = props.length;
            while (true) {
                i -= 2;
                if (i >= 0) {
                    final Object k = props[i];
                    if (k == key) {
                        final Object old = props[i + 1];
                        props[i + 1] = value;
                        return properties;
                    }
                    if (k != null) {
                        continue;
                    }
                    avail = i;
                }
                else {
                    if (avail < 0) {
                        avail = props.length;
                        properties = new Object[2 * avail];
                        System.arraycopy(props, 0, properties, 0, avail);
                        props = properties;
                        break;
                    }
                    break;
                }
            }
        }
        props[avail] = key;
        props[avail + 1] = value;
        return properties;
    }
    
    public Object removeProperty(final Object key) {
        final Object[] props = this.properties;
        if (props == null) {
            return null;
        }
        int i = props.length;
        while (true) {
            i -= 2;
            if (i < 0) {
                return null;
            }
            final Object k = props[i];
            if (k == key) {
                final Object old = props[i + 1];
                props[i + 1] = (props[i] = null);
                return old;
            }
        }
    }
    
    static {
        nameKey = Namespace.EmptyNamespace.getSymbol("name");
    }
}
