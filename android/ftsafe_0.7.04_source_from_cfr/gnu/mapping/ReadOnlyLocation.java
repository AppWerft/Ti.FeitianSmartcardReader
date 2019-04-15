/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.ConstrainedLocation;
import gnu.mapping.Location;
import gnu.mapping.Symbol;

public class ReadOnlyLocation
extends ConstrainedLocation {
    public static ReadOnlyLocation make(Location base2) {
        ReadOnlyLocation rloc = new ReadOnlyLocation();
        rloc.base = base2;
        return rloc;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    protected Object coerce(Object newValue) {
        StringBuffer sbuf = new StringBuffer("attempt to modify read-only location");
        Symbol name = this.getKeySymbol();
        if (name != null) {
            sbuf.append(": ");
            sbuf.append(name);
        }
        throw new IllegalStateException(sbuf.toString());
    }
}

