/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Named;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;

public abstract class PropertySet
implements Named {
    private Object[] properties;
    public static final Symbol nameKey = Namespace.EmptyNamespace.getSymbol("name");

    @Override
    public String getName() {
        Object symbol = this.getProperty(nameKey, null);
        return symbol == null ? null : (symbol instanceof Symbol ? ((Symbol)symbol).getName() : symbol.toString());
    }

    @Override
    public Object getSymbol() {
        return this.getProperty(nameKey, null);
    }

    public final void setSymbol(Object name) {
        this.setProperty(nameKey, name);
    }

    @Override
    public final void setName(String name) {
        this.setProperty(nameKey, name);
    }

    public Object getProperty(Object key, Object defaultValue) {
        if (this.properties != null) {
            int i = this.properties.length;
            while ((i -= 2) >= 0) {
                if (this.properties[i] != key) continue;
                return this.properties[i + 1];
            }
        }
        return defaultValue;
    }

    public synchronized void setProperty(Object key, Object value) {
        this.properties = PropertySet.setProperty(this.properties, key, value);
    }

    public static Object[] setProperty(Object[] properties, Object key, Object value) {
        int avail;
        Object[] props = properties;
        if (props == null) {
            properties = props = new Object[10];
            avail = 0;
        } else {
            avail = -1;
            int i = props.length;
            while ((i -= 2) >= 0) {
                Object k = props[i];
                if (k == key) {
                    Object old = props[i + 1];
                    props[i + 1] = value;
                    return properties;
                }
                if (k != null) continue;
                avail = i;
            }
            if (avail < 0) {
                avail = props.length;
                properties = new Object[2 * avail];
                System.arraycopy(props, 0, properties, 0, avail);
                props = properties;
            }
        }
        props[avail] = key;
        props[avail + 1] = value;
        return properties;
    }

    public Object removeProperty(Object key) {
        Object[] props = this.properties;
        if (props == null) {
            return null;
        }
        int i = props.length;
        while ((i -= 2) >= 0) {
            Object k = props[i];
            if (k != key) continue;
            Object old = props[i + 1];
            props[i] = null;
            props[i + 1] = null;
            return old;
        }
        return null;
    }
}

