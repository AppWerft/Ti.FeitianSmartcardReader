// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lang;

import gnu.mapping.Values;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;

public class Continuation extends MethodProc
{
    public boolean invoked;
    static int counter;
    int id;
    
    public Continuation(final CallContext ctx) {
    }
    
    @Override
    public void apply(final CallContext ctx) {
        if (this.invoked) {
            throw new GenericError("implementation restriction: continuation can only be used once");
        }
        throw new CalledContinuation(ctx.values, this, ctx);
    }
    
    public static void handleException$X(final Throwable ex, final Continuation cont, final CallContext ctx) throws Throwable {
        final CalledContinuation cex;
        if (!(ex instanceof CalledContinuation) || (cex = (CalledContinuation)ex).continuation != cont) {
            throw ex;
        }
        cont.invoked = true;
        final Object[] values = cex.values;
        for (int nvalues = values.length, i = 0; i < nvalues; ++i) {
            ctx.consumer.writeObject(values[i]);
        }
    }
    
    public static Object handleException(final Throwable ex, final Continuation cont) throws Throwable {
        final CalledContinuation cex;
        if (!(ex instanceof CalledContinuation) || (cex = (CalledContinuation)ex).continuation != cont) {
            throw ex;
        }
        cont.invoked = true;
        return Values.make(cex.values);
    }
    
    @Override
    public final String toString() {
        return "#<continuation " + this.id + (this.invoked ? " (invoked)>" : ">");
    }
}
