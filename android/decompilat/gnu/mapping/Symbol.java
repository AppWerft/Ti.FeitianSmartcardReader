// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class Symbol implements EnvironmentKey, Comparable, Externalizable
{
    protected String name;
    Namespace namespace;
    public static final Symbol FUNCTION;
    public static final Symbol PLIST;
    
    @Override
    public final Symbol getKeySymbol() {
        return this;
    }
    
    @Override
    public final Object getKeyProperty() {
        return null;
    }
    
    @Override
    public boolean matches(final EnvironmentKey key) {
        return equals(key.getKeySymbol(), this) && key.getKeyProperty() == null;
    }
    
    @Override
    public boolean matches(final Symbol symbol, final Object property) {
        return equals(symbol, this) && property == null;
    }
    
    public final String getNamespaceURI() {
        final Namespace ns = this.getNamespace();
        final String uri = (ns == null) ? null : ns.getName();
        return (uri == Namespace.UNKNOWN_NAMESPACE) ? "" : uri;
    }
    
    public final String getLocalPart() {
        return this.name;
    }
    
    public final String getPrefix() {
        final Namespace ns = this.namespace;
        return (ns == null) ? "" : ns.prefix;
    }
    
    public final boolean hasEmptyNamespace() {
        final Namespace ns = this.getNamespace();
        final String nsname;
        return ns == null || (nsname = ns.getName()) == null || nsname.length() == 0;
    }
    
    public final boolean hasUnknownNamespace() {
        final Namespace ns = this.getNamespace();
        return ns != null && ns.isUnknownNamespace();
    }
    
    public final String getLocalName() {
        return this.name;
    }
    
    public final String getName() {
        return this.name;
    }
    
    public static Symbol make(final String uri, final String name, final String prefix) {
        return Namespace.valueOf(uri, prefix).getSymbol(name.intern());
    }
    
    public static Symbol make(final Object namespace, final String name) {
        final Namespace ns = (namespace instanceof String) ? Namespace.valueOf((String)namespace) : namespace;
        if (ns == null || name == null) {
            return makeUninterned(name);
        }
        return ns.getSymbol(name.intern());
    }
    
    public static SimpleSymbol valueOf(final String name) {
        return (SimpleSymbol)Namespace.EmptyNamespace.getSymbol(name.intern());
    }
    
    public static Symbol valueOf(final String name, final Object spec) {
        if (spec == null || spec == Boolean.FALSE) {
            return makeUninterned(name);
        }
        Namespace ns;
        if (spec instanceof Namespace) {
            ns = (Namespace)spec;
        }
        else if (spec == Boolean.TRUE) {
            ns = Namespace.EmptyNamespace;
        }
        else {
            ns = Namespace.valueOf(((CharSequence)spec).toString());
        }
        return ns.getSymbol(name.intern());
    }
    
    public static Symbol valueOf(final String name, final String namespace, final String prefix) {
        return Namespace.valueOf(namespace, prefix).getSymbol(name.intern());
    }
    
    public static Symbol parse(final String symbol) {
        final int slen = symbol.length();
        int lbr = -1;
        int rbr = -1;
        int braceCount = 0;
        int mainStart = 0;
        int prefixEnd = 0;
        for (int i = 0; i < slen; ++i) {
            final char ch = symbol.charAt(i);
            if (ch == ':' && braceCount == 0) {
                prefixEnd = i;
                mainStart = i + 1;
                break;
            }
            if (ch == '{') {
                if (lbr < 0) {
                    prefixEnd = i;
                    lbr = i;
                }
                ++braceCount;
            }
            if (ch == '}') {
                if (--braceCount == 0) {
                    rbr = i;
                    mainStart = ((i < slen && symbol.charAt(i + 1) == ':') ? (i + 2) : (i + 1));
                    break;
                }
                if (braceCount < 0) {
                    mainStart = prefixEnd;
                    break;
                }
            }
        }
        if (lbr >= 0 && rbr > 0) {
            final String uri = symbol.substring(lbr + 1, rbr);
            final String prefix = (prefixEnd > 0) ? symbol.substring(0, prefixEnd) : null;
            return valueOf(symbol.substring(mainStart), uri, prefix);
        }
        if (prefixEnd > 0) {
            return makeWithUnknownNamespace(symbol.substring(mainStart), symbol.substring(0, prefixEnd));
        }
        return valueOf(symbol);
    }
    
    public static Symbol makeWithUnknownNamespace(final String local, final String prefix) {
        return Namespace.makeUnknownNamespace(prefix).getSymbol(local.intern());
    }
    
    public Symbol() {
    }
    
    public static Symbol makeUninterned(final String name) {
        return new Symbol(name, null);
    }
    
    public static Symbol makeUninterned(final String name, final Namespace namespace) {
        return new Symbol(name, namespace);
    }
    
    protected Symbol(final String name, final Namespace ns) {
        this.name = name;
        this.namespace = ns;
    }
    
    @Override
    public int compareTo(final Object o) {
        final Symbol other = (Symbol)o;
        if (this.getNamespaceURI() != other.getNamespaceURI()) {
            throw new IllegalArgumentException("comparing Symbols in different namespaces");
        }
        return this.getLocalName().compareTo(other.getLocalName());
    }
    
    public static boolean equals(final Symbol sym1, final Symbol sym2) {
        if (sym1 == sym2) {
            return true;
        }
        if (sym1 == null || sym2 == null) {
            return false;
        }
        if (sym1.name == sym2.name) {
            final Namespace namespace1 = sym1.namespace;
            final Namespace namespace2 = sym2.namespace;
            if (namespace1 != null && namespace2 != null) {
                return namespace1.name == namespace2.name;
            }
        }
        return false;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof Symbol && equals(this, (Symbol)o);
    }
    
    @Override
    public int hashCode() {
        return (this.name == null) ? 0 : this.name.hashCode();
    }
    
    public final Namespace getNamespace() {
        return this.namespace;
    }
    
    public final void setNamespace(final Namespace ns) {
        this.namespace = ns;
    }
    
    @Override
    public String toString() {
        return this.toString('P');
    }
    
    public String toString(final char style) {
        final String uri = this.getNamespaceURI();
        final String prefix = this.getPrefix();
        final boolean hasUri = uri != null && uri.length() > 0;
        final boolean hasPrefix = prefix != null && prefix.length() > 0;
        final String name = this.getName();
        if (hasUri || hasPrefix) {
            final StringBuilder sbuf = new StringBuilder();
            if (hasPrefix && (style != 'U' || !hasUri)) {
                sbuf.append(prefix);
            }
            if (hasUri && (style != 'P' || !hasPrefix)) {
                sbuf.append('{');
                sbuf.append(this.getNamespaceURI());
                sbuf.append('}');
            }
            sbuf.append(':');
            sbuf.append(name);
            return sbuf.toString();
        }
        return name;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        final Namespace ns = this.getNamespace();
        out.writeObject(ns);
        out.writeObject(this.getName());
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.namespace = (Namespace)in.readObject();
        this.name = (String)in.readObject();
    }
    
    public Object readResolve() throws ObjectStreamException {
        if (this.namespace == null) {
            return this;
        }
        return make(this.namespace, this.getName());
    }
    
    static {
        FUNCTION = makeUninterned("(function)");
        PLIST = makeUninterned("(property-list)");
    }
}
