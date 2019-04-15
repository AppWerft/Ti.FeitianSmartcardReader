/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Lazy;
import gnu.mapping.Procedure;
import gnu.mapping.RunnableClosure;
import gnu.mapping.WrappedException;

public class Future<T>
extends Thread
implements Lazy<T> {
    public RunnableClosure<T> closure;

    public Future(Procedure action, InPort in, OutPort out, OutPort err) {
        this.closure = new RunnableClosure(action, in, out, err);
    }

    public Future(Procedure action) {
        this.closure = new RunnableClosure(action);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Future make(Procedure action, Environment penvironment, InPort in, OutPort out, OutPort err) {
        Environment saveEnv = Environment.setSaveCurrent(penvironment);
        try {
            Future<T> future = new Future<T>(action, in, out, err);
            return future;
        }
        finally {
            Environment.restoreCurrent(saveEnv);
        }
    }

    public final CallContext getCallContext() {
        return this.closure.getCallContext();
    }

    @Override
    public void run() {
        this.closure.run();
    }

    @Override
    public T getValue() {
        try {
            this.join();
        }
        catch (InterruptedException ex) {
            throw new RuntimeException("thread join [force] was interrupted");
        }
        Throwable ex = this.closure.exception;
        if (ex != null) {
            WrappedException.rethrow(ex);
        }
        return this.closure.result;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("#<future ");
        buf.append(this.getName());
        buf.append(">");
        return buf.toString();
    }
}

