// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class DynamicLocation<T> extends NamedLocation<T> implements Named
{
    private int hash;
    static SimpleEnvironment env;
    
    public DynamicLocation(final Symbol name, final Object property) {
        super(name, property);
        this.hash = (name.hashCode() ^ System.identityHashCode(property));
    }
    
    public NamedLocation<T> getLocation() {
        final Environment curenv = Environment.getCurrent();
        final NamedLocation<T> loc = (NamedLocation<T>)curenv.getLocation(this.name, this.property, this.hash, true);
        return loc;
    }
    
    @Override
    public T get() {
        return this.getLocation().get();
    }
    
    @Override
    public T get(final T defaultValue) {
        return this.getLocation().get(defaultValue);
    }
    
    @Override
    public boolean isBound() {
        return this.getLocation().isBound();
    }
    
    @Override
    public void set(final T value) {
        this.getLocation().set(value);
    }
    
    @Override
    public Object setWithSave(final T newValue) {
        return this.getLocation().setWithSave(newValue);
    }
    
    @Override
    public void setRestore(final Object oldValue) {
        this.getLocation().setRestore(oldValue);
    }
    
    @Override
    public void undefine() {
        this.getLocation().undefine();
    }
    
    @Override
    public String getName() {
        return (this.name == null) ? null : this.name.toString();
    }
    
    @Override
    public Object getSymbol() {
        return this.name;
    }
    
    @Override
    public void setName(final String name) {
        throw new RuntimeException("setName not allowed");
    }
    
    public static synchronized DynamicLocation getInstance(final Symbol name, final Object property) {
        if (DynamicLocation.env == null) {
            DynamicLocation.env = new SimpleEnvironment("[thread-locations]");
        }
        final IndirectableLocation loc = (IndirectableLocation)DynamicLocation.env.getLocation(name, property);
        if (loc.base != null) {
            return (DynamicLocation)loc.base;
        }
        final DynamicLocation tloc = new DynamicLocation(name, property);
        return (DynamicLocation)(loc.base = (Location<T>)tloc);
    }
}
