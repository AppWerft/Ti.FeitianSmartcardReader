/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.kawa.slib.Stream;
import gnu.lists.ImmutablePair;

public class StreamPair
extends ImmutablePair
implements Stream {
    public StreamPair(Object x, Object y) {
        super(x, y);
    }

    public Object getValue() {
        return this;
    }
}

