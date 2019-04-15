/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.mapping.CallContext;
import kawa.lang.Continuation;

public class CalledContinuation
extends RuntimeException {
    public Object[] values;
    public Continuation continuation;
    public CallContext ctx;

    CalledContinuation(Object[] values, Continuation continuation, CallContext ctx) {
        super("call/cc called");
        this.values = values;
        this.continuation = continuation;
        this.ctx = ctx;
    }
}

