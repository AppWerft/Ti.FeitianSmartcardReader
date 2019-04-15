/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Pair;

public class ImmutablePair
extends Pair {
    public ImmutablePair(Object carval, Object cdrval) {
        super(carval, cdrval);
    }

    public ImmutablePair() {
    }

    @Override
    public void setCar(Object car) {
        throw new UnsupportedOperationException("cannot modify read-only pair");
    }

    @Override
    public void setCdr(Object cdr) {
        throw new UnsupportedOperationException("cannot modify read-only pair");
    }
}

