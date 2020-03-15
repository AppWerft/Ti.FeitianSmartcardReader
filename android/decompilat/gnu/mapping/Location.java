// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.io.PrintWriter;

public abstract class Location<T>
{
    public static final String UNBOUND;
    
    public Symbol getKeySymbol() {
        return null;
    }
    
    public Object getKeyProperty() {
        return null;
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer();
        sbuf.append(this.getClass().getName());
        final Symbol sym = this.getKeySymbol();
        sbuf.append('[');
        if (sym != null) {
            sbuf.append(sym);
            final Object property = this.getKeyProperty();
            if (property != null && property != this) {
                sbuf.append('/');
                sbuf.append(property);
            }
        }
        sbuf.append("]");
        return sbuf.toString();
    }
    
    public T get(final T defaultValue) {
        return this.isBound() ? this.get() : defaultValue;
    }
    
    public abstract T get();
    
    public abstract void set(final T p0);
    
    public void undefine() {
        throw new UnsupportedOperationException();
    }
    
    public Object setWithSave(final T newValue) {
        final Object old = this.isBound() ? this.get() : Location.UNBOUND;
        this.set(newValue);
        return old;
    }
    
    public void setRestore(final Object oldValue) {
        if (oldValue == Location.UNBOUND) {
            this.undefine();
        }
        else {
            this.set(oldValue);
        }
    }
    
    public abstract boolean isBound();
    
    public boolean isConstant() {
        return false;
    }
    
    public Location getBase() {
        return this;
    }
    
    public final T getValue() {
        return this.get(null);
    }
    
    public final T setValue(final T newValue) {
        final T value = this.get(null);
        this.set(newValue);
        return value;
    }
    
    public boolean entered() {
        return false;
    }
    
    public void print(final PrintWriter ps) {
        ps.print("#<location ");
        final Symbol name = this.getKeySymbol();
        if (name != null) {
            ps.print(name);
        }
        if (this.isBound()) {
            ps.print(" -> ");
            try {
                ps.print(this.get());
            }
            catch (Exception ex) {
                ps.print("<caught " + ex + ">");
            }
        }
        else {
            ps.print("(unbound)");
        }
        ps.print('>');
    }
    
    public static Location make(final Object init, final String name) {
        final ThreadLocation loc = new ThreadLocation(name);
        loc.setGlobal(init);
        return loc;
    }
    
    public static IndirectableLocation make(final String name) {
        final Symbol sym = Namespace.EmptyNamespace.getSymbol(name.intern());
        final PlainLocation loc = new PlainLocation(sym, null);
        loc.base = null;
        loc.value = Location.UNBOUND;
        return loc;
    }
    
    public static IndirectableLocation make(final Symbol name) {
        final PlainLocation loc = new PlainLocation(name, null);
        loc.base = null;
        loc.value = Location.UNBOUND;
        return loc;
    }
    
    public static Location define(final Symbol name) {
        final Environment env = Environment.getCurrent();
        final int hash = name.hashCode();
        final NamedLocation loc = env.getLocation(name, null, hash, true);
        if (loc.isConstant()) {
            final Object value = loc.get(Location.UNBOUND);
            loc.value = value;
            loc.base = null;
        }
        return loc;
    }
    
    static {
        UNBOUND = new String("(unbound)");
    }
}
