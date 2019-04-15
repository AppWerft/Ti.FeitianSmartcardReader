/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.PropertySet;

public class PropertyKey<T> {
    String name;

    public PropertyKey(String name) {
        this.name = name;
    }

    public T get(PropertySet container, T defaultValue) {
        return (T)container.getProperty(this, defaultValue);
    }

    public final T get(PropertySet container) {
        return this.get(container, null);
    }

    public void set(PropertySet container, T value) {
        container.setProperty(this, value);
    }
}

