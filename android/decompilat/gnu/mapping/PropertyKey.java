// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class PropertyKey<T>
{
    String name;
    
    public PropertyKey(final String name) {
        this.name = name;
    }
    
    public T get(final PropertySet container, final T defaultValue) {
        return (T)container.getProperty(this, defaultValue);
    }
    
    public final T get(final PropertySet container) {
        return this.get(container, null);
    }
    
    public void set(final PropertySet container, final T value) {
        container.setProperty(this, value);
    }
}
