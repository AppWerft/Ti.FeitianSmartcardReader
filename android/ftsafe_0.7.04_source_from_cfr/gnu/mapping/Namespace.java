/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.kawa.util.AbstractHashTable;
import gnu.mapping.Environment;
import gnu.mapping.HasNamedParts;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.SymbolRef;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;
import java.util.Map;

public class Namespace
extends AbstractHashTable<SymbolRef, String, Symbol>
implements Externalizable,
HasNamedParts {
    protected static final Hashtable nsTable = new Hashtable(50);
    public static final Namespace EmptyNamespace = Namespace.valueOf("");
    String name;
    protected String prefix = "";
    public static final String UNKNOWN_NAMESPACE = new String("$unknown$");

    public final String getName() {
        return this.name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public Namespace() {
        this(64);
    }

    protected Namespace(int capacity) {
        super(capacity);
    }

    public static Namespace create(int capacity) {
        return new Namespace(capacity);
    }

    public static Namespace create() {
        return new Namespace(64);
    }

    public static Namespace getDefault() {
        return EmptyNamespace;
    }

    public static Symbol getDefaultSymbol(String name) {
        return EmptyNamespace.getSymbol(name);
    }

    public static Namespace valueOf() {
        return EmptyNamespace;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Namespace valueOf(String name) {
        if (name == null) {
            name = "";
        }
        Hashtable hashtable2 = nsTable;
        synchronized (hashtable2) {
            Namespace ns = (Namespace)nsTable.get(name);
            if (ns != null) {
                return ns;
            }
            ns = new Namespace();
            ns.setName(name.intern());
            nsTable.put(name, ns);
            return ns;
        }
    }

    public static Namespace valueOfNoCreate(String name) {
        if (name == null) {
            name = "";
        }
        return (Namespace)nsTable.get(name);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Namespace valueOf(String uri, String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return Namespace.valueOf(uri);
        }
        String xname = prefix + " -> " + uri;
        Hashtable hashtable2 = nsTable;
        synchronized (hashtable2) {
            Object old = nsTable.get(xname);
            if (old instanceof Namespace) {
                return (Namespace)old;
            }
            Namespace ns = new Namespace();
            if (uri != UNKNOWN_NAMESPACE) {
                uri = uri.intern();
            }
            ns.setName(uri);
            ns.prefix = prefix.intern();
            nsTable.put(xname, ns);
            return ns;
        }
    }

    public static Namespace valueOf(String uri, SimpleSymbol prefix) {
        return Namespace.valueOf(uri, prefix == null ? null : prefix.getName());
    }

    public boolean isUnknownNamespace() {
        return this.name == UNKNOWN_NAMESPACE;
    }

    public static Namespace makeUnknownNamespace(String prefix) {
        String uri = prefix == null || prefix == "" ? "" : UNKNOWN_NAMESPACE;
        return Namespace.valueOf(uri, prefix);
    }

    @Override
    public Object get(String key) {
        return Environment.getCurrent().get(this.getSymbol(key));
    }

    @Override
    public boolean isConstant(String key) {
        return false;
    }

    public Symbol getSymbol(String key) {
        return this.lookup(key, key.hashCode(), true);
    }

    public Symbol lookup(String key) {
        return this.lookup(key, key.hashCode(), false);
    }

    protected final Symbol lookupInternal(String key, int hash) {
        int index = this.hashToIndex(hash);
        SymbolRef prev = null;
        SymbolRef ref = ((SymbolRef[])this.table)[index];
        while (ref != null) {
            SymbolRef next = ref.next;
            Symbol sym = ref.getSymbol();
            if (sym == null) {
                if (prev == null) {
                    ((SymbolRef[])this.table)[index] = next;
                } else {
                    prev.next = next;
                }
                --this.num_bindings;
            } else {
                if (sym.getLocalPart().equals(key)) {
                    return sym;
                }
                prev = ref;
            }
            ref = next;
        }
        return null;
    }

    public Symbol add(Symbol sym, int hash) {
        this.put(sym.getName(), hash, sym);
        return sym;
    }

    @Override
    public Symbol get(Object key, Symbol defaultValue) {
        Symbol sym;
        if (key instanceof String && (sym = this.lookup((String)key, key.hashCode(), false)) != null) {
            return sym;
        }
        return defaultValue;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Symbol lookup(String key, int hash, boolean create) {
        Namespace namespace = this;
        synchronized (namespace) {
            Symbol sym = this.lookupInternal(key, hash);
            if (sym != null) {
                return sym;
            }
            if (create) {
                sym = this == EmptyNamespace ? new SimpleSymbol(key) : new Symbol(key, this);
                return this.add(sym, hash);
            }
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean remove(Symbol symbol) {
        Namespace namespace = this;
        synchronized (namespace) {
            String name = symbol.getLocalPart();
            return this.remove(name) != null;
        }
    }

    @Override
    protected int getEntryHashCode(SymbolRef entry) {
        return entry.hashCode();
    }

    @Override
    protected SymbolRef getEntryNext(SymbolRef entry) {
        return entry.next;
    }

    @Override
    protected void setEntryNext(SymbolRef entry, SymbolRef next) {
        entry.next = next;
    }

    protected SymbolRef[] allocEntries(int n) {
        return new SymbolRef[n];
    }

    @Override
    protected SymbolRef makeEntry(String key, int hash, Symbol value) {
        return new SymbolRef(value);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.prefix);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((String)in.readObject()).intern();
        this.prefix = (String)in.readObject();
    }

    public Object readResolve() throws ObjectStreamException {
        String name = this.getName();
        if (name != null) {
            String xname = this.prefix == null || this.prefix.length() == 0 ? name : this.prefix + " -> " + name;
            Namespace ns = (Namespace)nsTable.get(xname);
            if (ns != null) {
                return ns;
            }
            nsTable.put(xname, this);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sbuf = new StringBuilder("#,(namespace \"");
        sbuf.append(this.name);
        sbuf.append('\"');
        if (this.prefix != null && this.prefix != "") {
            sbuf.append(' ');
            sbuf.append(this.prefix);
        }
        sbuf.append(')');
        return sbuf.toString();
    }
}

