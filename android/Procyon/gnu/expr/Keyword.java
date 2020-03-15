// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.Namespace;
import java.io.Externalizable;
import gnu.mapping.Symbol;

public class Keyword extends Symbol implements Externalizable
{
    public static final Namespace keywordNamespace;
    
    public Keyword() {
    }
    
    private Keyword(final String name) {
        super(name, Keyword.keywordNamespace);
    }
    
    public Keyword(final Namespace namespace, final String name) {
        super(name, namespace);
    }
    
    public Symbol asSymbol() {
        return Namespace.EmptyNamespace.getSymbol(this.getName());
    }
    
    public static Keyword make(final String name) {
        final int hash = name.hashCode();
        Keyword keyword = (Keyword)Keyword.keywordNamespace.lookup(name, hash, false);
        if (keyword == null) {
            keyword = new Keyword(name);
            Keyword.keywordNamespace.add(keyword, hash);
        }
        return keyword;
    }
    
    public static boolean isKeyword(final Object obj) {
        return obj instanceof Keyword;
    }
    
    @Override
    public final String toString() {
        return this.getName() + ':';
    }
    
    public static Object searchForKeyword(final Object[] vals, final int offset, final Object keyword) {
        for (int i = offset; i < vals.length; i += 2) {
            if (vals[i] == keyword) {
                return vals[i + 1];
            }
        }
        return Special.dfault;
    }
    
    public static Object searchForKeyword(final Object[] vals, final int offset, final Object keyword, final Object dfault) {
        for (int i = offset; i < vals.length; i += 2) {
            if (vals[i] == keyword) {
                return vals[i + 1];
            }
        }
        return dfault;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String)in.readObject();
    }
    
    @Override
    public Object readResolve() throws ObjectStreamException {
        return Symbol.make(Keyword.keywordNamespace, this.getName());
    }
    
    static {
        (keywordNamespace = Namespace.create()).setName("(keywords)");
    }
}
