// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.mapping.Symbol;

public class Notation
{
    Symbol qname;
    
    public boolean equals(final Notation n1, final Notation n2) {
        return n1.qname.equals(n2.qname);
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Notation && this.equals(this, (Notation)obj);
    }
    
    @Override
    public int hashCode() {
        return this.qname.hashCode();
    }
}
