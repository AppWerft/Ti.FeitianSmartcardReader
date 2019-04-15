/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.kawa.slib.Stream;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;

public class StreamPromise
extends Promise
implements Stream {
    public StreamPromise(Procedure thunk, boolean lazy2) {
        super(thunk);
        this.setForceValueIfPromise(lazy2);
    }

    public StreamPromise() {
    }
}

