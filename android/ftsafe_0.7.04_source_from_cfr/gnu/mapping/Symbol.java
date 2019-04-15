/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class Symbol
implements EnvironmentKey,
Comparable,
Externalizable {
    protected String name;
    Namespace namespace;
    public static final Symbol FUNCTION = Symbol.makeUninterned("(function)");
    public static final Symbol PLIST = Symbol.makeUninterned("(property-list)");

    @Override
    public final Symbol getKeySymbol() {
        return this;
    }

    @Override
    public final Object getKeyProperty() {
        return null;
    }

    @Override
    public boolean matches(EnvironmentKey key) {
        return Symbol.equals(key.getKeySymbol(), this) && key.getKeyProperty() == null;
    }

    @Override
    public boolean matches(Symbol symbol, Object property) {
        return Symbol.equals(symbol, this) && property == null;
    }

    public final String getNamespaceURI() {
        Namespace ns = this.getNamespace();
        String uri = ns == null ? null : ns.getName();
        return uri == Namespace.UNKNOWN_NAMESPACE ? "" : uri;
    }

    public final String getLocalPart() {
        return this.name;
    }

    public final String getPrefix() {
        Namespace ns = this.namespace;
        return ns == null ? "" : ns.prefix;
    }

    public final boolean hasEmptyNamespace() {
        String nsname;
        Namespace ns = this.getNamespace();
        return ns == null || (nsname = ns.getName()) == null || nsname.length() == 0;
    }

    public final boolean hasUnknownNamespace() {
        Namespace ns = this.getNamespace();
        return ns != null && ns.isUnknownNamespace();
    }

    public final String getLocalName() {
        return this.name;
    }

    public final String getName() {
        return this.name;
    }

    public static Symbol make(String uri, String name, String prefix) {
        return Namespace.valueOf(uri, prefix).getSymbol(name.intern());
    }

    public static Symbol make(Object namespace, String name) {
        Namespace ns;
        Namespace namespace2 = ns = namespace instanceof String ? Namespace.valueOf((String)namespace) : (Namespace)namespace;
        if (ns == null || name == null) {
            return Symbol.makeUninterned(name);
        }
        return ns.getSymbol(name.intern());
    }

    public static SimpleSymbol valueOf(String name) {
        return (SimpleSymbol)Namespace.EmptyNamespace.getSymbol(name.intern());
    }

    public static Symbol valueOf(String name, Object spec) {
        if (spec == null || spec == Boolean.FALSE) {
            return Symbol.makeUninterned(name);
        }
        Namespace ns = spec instanceof Namespace ? (Namespace)spec : (spec == Boolean.TRUE ? Namespace.EmptyNamespace : Namespace.valueOf(((Object)((CharSequence)spec)).toString()));
        return ns.getSymbol(name.intern());
    }

    public static Symbol valueOf(String name, String namespace, String prefix) {
        return Namespace.valueOf(namespace, prefix).getSymbol(name.intern());
    }

    public static Symbol parse(String symbol) {
        int slen = symbol.length();
        int lbr = -1;
        int rbr = -1;
        int braceCount = 0;
        int mainStart = 0;
        int prefixEnd = 0;
        for (int i = 0; i < slen; ++i) {
            char ch = symbol.charAt(i);
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
            if (ch != '}') continue;
            if (--braceCount == 0) {
                rbr = i;
                mainStart = i < slen && symbol.charAt(i + 1) == ':' ? i + 2 : i + 1;
                break;
            }
            if (braceCount >= 0) continue;
            mainStart = prefixEnd;
            break;
        }
        if (lbr >= 0 && rbr > 0) {
            String uri = symbol.substring(lbr + 1, rbr);
            String prefix = prefixEnd > 0 ? symbol.substring(0, prefixEnd) : null;
            return Symbol.valueOf(symbol.substring(mainStart), uri, prefix);
        }
        if (prefixEnd > 0) {
            return Symbol.makeWithUnknownNamespace(symbol.substring(mainStart), symbol.substring(0, prefixEnd));
        }
        return Symbol.valueOf(symbol);
    }

    public static Symbol makeWithUnknownNamespace(String local, String prefix) {
        return Namespace.makeUnknownNamespace(prefix).getSymbol(local.intern());
    }

    public Symbol() {
    }

    public static Symbol makeUninterned(String name) {
        return new Symbol(name, null);
    }

    public static Symbol makeUninterned(String name, Namespace namespace) {
        return new Symbol(name, namespace);
    }

    protected Symbol(String name, Namespace ns) {
        this.name = name;
        this.namespace = ns;
    }

    public int compareTo(Object o) {
        Symbol other = (Symbol)o;
        if (this.getNamespaceURI() != other.getNamespaceURI()) {
            throw new IllegalArgumentException("comparing Symbols in different namespaces");
        }
        return this.getLocalName().compareTo(other.getLocalName());
    }

    public static boolean equals(Symbol sym1, Symbol sym2) {
        if (sym1 == sym2) {
            return true;
        }
        if (sym1 == null || sym2 == null) {
            return false;
        }
        if (sym1.name == sym2.name) {
            Namespace namespace1 = sym1.namespace;
            Namespace namespace2 = sym2.namespace;
            if (namespace1 != null && namespace2 != null) {
                return namespace1.name == namespace2.name;
            }
        }
        return false;
    }

    public final boolean equals(Object o) {
        return o instanceof Symbol && Symbol.equals(this, (Symbol)o);
    }

    public int hashCode() {
        return this.name == null ? 0 : this.name.hashCode();
    }

    public final Namespace getNamespace() {
        return this.namespace;
    }

    public final void setNamespace(Namespace ns) {
        this.namespace = ns;
    }

    public String toString() {
        return this.toString('P');
    }

    public String toString(char style) {
        String uri = this.getNamespaceURI();
        String prefix = this.getPrefix();
        boolean hasUri = uri != null && uri.length() > 0;
        boolean hasPrefix = prefix != null && prefix.length() > 0;
        String name = this.getName();
        if (hasUri || hasPrefix) {
            StringBuilder sbuf = new StringBuilder();
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
    public void writeExternal(ObjectOutput out) throws IOException {
        Namespace ns = this.getNamespace();
        out.writeObject(ns);
        out.writeObject(this.getName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.namespace = (Namespace)in.readObject();
        this.name = (String)in.readObject();
    }

    public Object readResolve() throws ObjectStreamException {
        if (this.namespace == null) {
            return this;
        }
        return Symbol.make(this.namespace, this.getName());
    }
}

