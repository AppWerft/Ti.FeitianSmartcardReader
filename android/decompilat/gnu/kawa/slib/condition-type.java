// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import kawa.lib.misc;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.mapping.Symbol;

public class condition-type
{
    public Symbol name;
    public Object supertype;
    public Object fields;
    public Object all$Mnfields;
    
    public condition-type(final Object name, final Object supertype, final Object fields, final Object all$Mnfields) {
        final Object force = Promise.force(name, Symbol.class);
        try {
            this.name = (Symbol)force;
            this.supertype = supertype;
            this.fields = fields;
            this.all$Mnfields = all$Mnfields;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, (String)null, -4, force);
        }
    }
    
    @Override
    public String toString() {
        final StringBuffer sbuf = new StringBuffer((CharSequence)"#<condition-type ");
        sbuf.append((CharSequence)misc.symbol$To$String(this.name));
        sbuf.append((CharSequence)">");
        return sbuf.toString();
    }
}
