/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Symbol;
import java.lang.ref.WeakReference;
import java.util.Map;

class SymbolRef
extends WeakReference<Symbol>
implements Map.Entry<String, Symbol> {
    SymbolRef next;

    String getName() {
        Symbol sym = this.getSymbol();
        return sym == null ? null : sym.getName();
    }

    SymbolRef(Symbol sym) {
        super(sym);
    }

    @Override
    public String getKey() {
        Symbol sym = this.getSymbol();
        return sym == null ? null : sym.getName();
    }

    @Override
    public Symbol getValue() {
        return this.getSymbol();
    }

    @Override
    public int hashCode() {
        Symbol sym = this.getSymbol();
        return sym == null ? 0 : sym.hashCode();
    }

    @Override
    public Symbol setValue(Symbol value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SymbolRef && this.get() == ((SymbolRef)o).get();
    }

    Symbol getSymbol() {
        return (Symbol)this.get();
    }

    public String toString() {
        return "SymbolRef[" + this.getSymbol() + "]";
    }
}

