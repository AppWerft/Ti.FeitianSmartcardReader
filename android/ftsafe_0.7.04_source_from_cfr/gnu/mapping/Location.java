/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Environment;
import gnu.mapping.IndirectableLocation;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.PlainLocation;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import java.io.PrintWriter;

public abstract class Location<T> {
    public static final String UNBOUND = new String("(unbound)");

    public Symbol getKeySymbol() {
        return null;
    }

    public Object getKeyProperty() {
        return null;
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(this.getClass().getName());
        Symbol sym = this.getKeySymbol();
        sbuf.append('[');
        if (sym != null) {
            sbuf.append(sym);
            Object property = this.getKeyProperty();
            if (property != null && property != this) {
                sbuf.append('/');
                sbuf.append(property);
            }
        }
        sbuf.append("]");
        return sbuf.toString();
    }

    public T get(T defaultValue) {
        return this.isBound() ? this.get() : defaultValue;
    }

    public abstract T get();

    public abstract void set(T var1);

    public void undefine() {
        throw new UnsupportedOperationException();
    }

    public Object setWithSave(T newValue) {
        String old = this.isBound() ? this.get() : UNBOUND;
        this.set(newValue);
        return old;
    }

    public void setRestore(Object oldValue) {
        if (oldValue == UNBOUND) {
            this.undefine();
        } else {
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

    public final T setValue(T newValue) {
        T value = this.get(null);
        this.set(newValue);
        return value;
    }

    public boolean entered() {
        return false;
    }

    public void print(PrintWriter ps) {
        ps.print("#<location ");
        Symbol name = this.getKeySymbol();
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
        } else {
            ps.print("(unbound)");
        }
        ps.print('>');
    }

    public static Location make(Object init, String name) {
        ThreadLocation<Object> loc = new ThreadLocation<Object>(name);
        loc.setGlobal(init);
        return loc;
    }

    public static IndirectableLocation make(String name) {
        Symbol sym = Namespace.EmptyNamespace.getSymbol(name.intern());
        PlainLocation<T> loc = new PlainLocation<T>(sym, null);
        loc.base = null;
        loc.value = UNBOUND;
        return loc;
    }

    public static IndirectableLocation make(Symbol name) {
        PlainLocation<T> loc = new PlainLocation<T>(name, null);
        loc.base = null;
        loc.value = UNBOUND;
        return loc;
    }

    public static Location define(Symbol name) {
        int hash;
        Environment env = Environment.getCurrent();
        NamedLocation loc = env.getLocation(name, null, hash = name.hashCode(), true);
        if (loc.isConstant()) {
            String value = loc.get(UNBOUND);
            loc.value = value;
            loc.base = null;
        }
        return loc;
    }
}

