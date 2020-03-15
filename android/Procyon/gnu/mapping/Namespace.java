// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.util.Map;
import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.util.Hashtable;
import java.io.Externalizable;
import gnu.kawa.util.AbstractHashTable;

public class Namespace extends AbstractHashTable<SymbolRef, String, Symbol> implements Externalizable, HasNamedParts
{
    protected static final Hashtable nsTable;
    public static final Namespace EmptyNamespace;
    String name;
    protected String prefix;
    public static final String UNKNOWN_NAMESPACE;
    
    public final String getName() {
        return this.name;
    }
    
    public final void setName(final String name) {
        this.name = name;
    }
    
    public final String getPrefix() {
        return this.prefix;
    }
    
    public Namespace() {
        this(64);
    }
    
    protected Namespace(final int capacity) {
        super(capacity);
        this.prefix = "";
    }
    
    public static Namespace create(final int capacity) {
        return new Namespace(capacity);
    }
    
    public static Namespace create() {
        return new Namespace(64);
    }
    
    public static Namespace getDefault() {
        return Namespace.EmptyNamespace;
    }
    
    public static Symbol getDefaultSymbol(final String name) {
        return Namespace.EmptyNamespace.getSymbol(name);
    }
    
    public static Namespace valueOf() {
        return Namespace.EmptyNamespace;
    }
    
    public static Namespace valueOf(String name) {
        if (name == null) {
            name = "";
        }
        synchronized (Namespace.nsTable) {
            Namespace ns = Namespace.nsTable.get(name);
            if (ns != null) {
                return ns;
            }
            ns = new Namespace();
            ns.setName(name.intern());
            Namespace.nsTable.put(name, ns);
            return ns;
        }
    }
    
    public static Namespace valueOfNoCreate(String name) {
        if (name == null) {
            name = "";
        }
        return Namespace.nsTable.get(name);
    }
    
    public static Namespace valueOf(String uri, final String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return valueOf(uri);
        }
        final String xname = prefix + " -> " + uri;
        synchronized (Namespace.nsTable) {
            final Object old = Namespace.nsTable.get(xname);
            if (old instanceof Namespace) {
                return (Namespace)old;
            }
            final Namespace ns = new Namespace();
            if (uri != Namespace.UNKNOWN_NAMESPACE) {
                uri = uri.intern();
            }
            ns.setName(uri);
            ns.prefix = prefix.intern();
            Namespace.nsTable.put(xname, ns);
            return ns;
        }
    }
    
    public static Namespace valueOf(final String uri, final SimpleSymbol prefix) {
        return valueOf(uri, (prefix == null) ? null : prefix.getName());
    }
    
    public boolean isUnknownNamespace() {
        return this.name == Namespace.UNKNOWN_NAMESPACE;
    }
    
    public static Namespace makeUnknownNamespace(final String prefix) {
        final String uri = (prefix == null || prefix == "") ? "" : Namespace.UNKNOWN_NAMESPACE;
        return valueOf(uri, prefix);
    }
    
    @Override
    public Object get(final String key) {
        return Environment.getCurrent().get(this.getSymbol(key));
    }
    
    @Override
    public boolean isConstant(final String key) {
        return false;
    }
    
    public Symbol getSymbol(final String key) {
        return this.lookup(key, key.hashCode(), true);
    }
    
    public Symbol lookup(final String key) {
        return this.lookup(key, key.hashCode(), false);
    }
    
    protected final Symbol lookupInternal(final String key, final int hash) {
        final int index = this.hashToIndex(hash);
        SymbolRef prev = null;
        SymbolRef next;
        for (SymbolRef ref = ((SymbolRef[])this.table)[index]; ref != null; ref = next) {
            next = ref.next;
            final Symbol sym = ref.getSymbol();
            if (sym == null) {
                if (prev == null) {
                    ((SymbolRef[])this.table)[index] = next;
                }
                else {
                    prev.next = next;
                }
                --this.num_bindings;
            }
            else {
                if (sym.getLocalPart().equals(key)) {
                    return sym;
                }
                prev = ref;
            }
        }
        return null;
    }
    
    public Symbol add(final Symbol sym, final int hash) {
        ((AbstractHashTable<Entry, String, Symbol>)this).put(sym.getName(), hash, sym);
        return sym;
    }
    
    @Override
    public Symbol get(final Object key, final Symbol defaultValue) {
        if (key instanceof String) {
            final Symbol sym = this.lookup((String)key, key.hashCode(), false);
            if (sym != null) {
                return sym;
            }
        }
        return defaultValue;
    }
    
    public Symbol lookup(final String key, final int hash, final boolean create) {
        synchronized (this) {
            Symbol sym = this.lookupInternal(key, hash);
            if (sym != null) {
                return sym;
            }
            if (create) {
                if (this == Namespace.EmptyNamespace) {
                    sym = new SimpleSymbol(key);
                }
                else {
                    sym = new Symbol(key, this);
                }
                return this.add(sym, hash);
            }
            return null;
        }
    }
    
    public boolean remove(final Symbol symbol) {
        synchronized (this) {
            final String name = symbol.getLocalPart();
            return this.remove(name) != null;
        }
    }
    
    @Override
    protected int getEntryHashCode(final SymbolRef entry) {
        return entry.hashCode();
    }
    
    @Override
    protected SymbolRef getEntryNext(final SymbolRef entry) {
        return entry.next;
    }
    
    @Override
    protected void setEntryNext(final SymbolRef entry, final SymbolRef next) {
        entry.next = next;
    }
    
    @Override
    protected SymbolRef[] allocEntries(final int n) {
        return new SymbolRef[n];
    }
    
    @Override
    protected SymbolRef makeEntry(final String key, final int hash, final Symbol value) {
        return new SymbolRef(value);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.prefix);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((String)in.readObject()).intern();
        this.prefix = (String)in.readObject();
    }
    
    public Object readResolve() throws ObjectStreamException {
        final String name = this.getName();
        if (name != null) {
            final String xname = (this.prefix == null || this.prefix.length() == 0) ? name : (this.prefix + " -> " + name);
            final Namespace ns = Namespace.nsTable.get(xname);
            if (ns != null) {
                return ns;
            }
            Namespace.nsTable.put(xname, this);
        }
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder sbuf = new StringBuilder("#,(namespace \"");
        sbuf.append(this.name);
        sbuf.append('\"');
        if (this.prefix != null && this.prefix != "") {
            sbuf.append(' ');
            sbuf.append(this.prefix);
        }
        sbuf.append(')');
        return sbuf.toString();
    }
    
    static {
        nsTable = new Hashtable(50);
        EmptyNamespace = valueOf("");
        UNKNOWN_NAMESPACE = new String("$unknown$");
    }
}
