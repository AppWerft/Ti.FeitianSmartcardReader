// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.mapping.CallContext;

public class CalledContinuation extends RuntimeException
{
    public Object[] values;
    public Continuation continuation;
    public CallContext ctx;
    
    CalledContinuation(final Object[] values, final Continuation continuation, final CallContext ctx) {
        super("call/cc called");
        this.values = values;
        this.continuation = continuation;
        this.ctx = ctx;
    }
}
