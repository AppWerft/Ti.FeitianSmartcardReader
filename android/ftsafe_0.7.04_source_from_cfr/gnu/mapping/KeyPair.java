/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.EnvironmentKey;
import gnu.mapping.Symbol;

public class KeyPair
implements EnvironmentKey {
    Symbol name;
    Object property;

    public KeyPair(Symbol name, Object property) {
        this.name = name;
        this.property = property;
    }

    @Override
    public Symbol getKeySymbol() {
        return this.name;
    }

    @Override
    public Object getKeyProperty() {
        return this.property;
    }

    @Override
    public final boolean matches(EnvironmentKey key) {
        return Symbol.equals(key.getKeySymbol(), this.name) && key.getKeyProperty() == this.property;
    }

    @Override
    public final boolean matches(Symbol symbol, Object property) {
        return Symbol.equals(symbol, this.name) && property == this.property;
    }

    public boolean equals(Object x) {
        if (!(x instanceof KeyPair)) {
            return false;
        }
        KeyPair e2 = (KeyPair)x;
        return this.property == e2.property && (this.name == null ? e2.name == null : this.name.equals(e2.name));
    }

    public int hashCode() {
        return this.name.hashCode() ^ System.identityHashCode(this.property);
    }

    public String toString() {
        return "KeyPair[sym:" + this.name + " prop:" + this.property + "]";
    }
}

