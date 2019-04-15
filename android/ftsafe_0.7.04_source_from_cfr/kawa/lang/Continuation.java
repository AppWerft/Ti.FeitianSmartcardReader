/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import kawa.lang.CalledContinuation;
import kawa.lang.GenericError;

public class Continuation
extends MethodProc {
    public boolean invoked;
    static int counter;
    int id;

    public Continuation(CallContext ctx) {
    }

    @Override
    public void apply(CallContext ctx) {
        if (this.invoked) {
            throw new GenericError("implementation restriction: continuation can only be used once");
        }
        throw new CalledContinuation(ctx.values, this, ctx);
    }

    public static void handleException$X(Throwable ex, Continuation cont, CallContext ctx) throws Throwable {
        CalledContinuation cex;
        block4 : {
            block3 : {
                if (!(ex instanceof CalledContinuation)) break block3;
                cex = (CalledContinuation)ex;
                if (cex.continuation == cont) break block4;
            }
            throw ex;
        }
        cont.invoked = true;
        Object[] values = cex.values;
        int nvalues = values.length;
        for (int i = 0; i < nvalues; ++i) {
            ctx.consumer.writeObject(values[i]);
        }
    }

    public static Object handleException(Throwable ex, Continuation cont) throws Throwable {
        CalledContinuation cex;
        block3 : {
            block2 : {
                if (!(ex instanceof CalledContinuation)) break block2;
                cex = (CalledContinuation)ex;
                if (cex.continuation == cont) break block3;
            }
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

