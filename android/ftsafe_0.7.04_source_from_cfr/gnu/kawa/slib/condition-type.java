/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.mapping.Promise;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lib.misc;

public class condition-type {
    public Symbol name;
    public Object supertype;
    public Object fields;
    public Object all$Mnfields;

    public condition-type(Object object2, Object object3, Object object4, Object object5) {
        void name;
        void fields;
        void supertype;
        void all$Mnfields;
        Object object6 = Promise.force(name, Symbol.class);
        try {
            this.name = (Symbol)object6;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, null, -4, object6);
        }
        this.supertype = supertype;
        this.fields = fields;
        this.all$Mnfields = all$Mnfields;
    }

    public String toString() {
        StringBuffer sbuf = new StringBuffer((CharSequence)"#<condition-type ");
        sbuf.append((CharSequence)misc.symbol$To$String(this.name));
        sbuf.append((CharSequence)">");
        return sbuf.toString();
    }
}

