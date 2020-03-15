// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.kawa.io.OutPort;
import gnu.kawa.io.InPort;

public class Future<T> extends Thread implements Lazy<T>
{
    public RunnableClosure<T> closure;
    
    public Future(final Procedure action, final InPort in, final OutPort out, final OutPort err) {
        this.closure = new RunnableClosure<T>(action, in, out, err);
    }
    
    public Future(final Procedure action) {
        this.closure = new RunnableClosure<T>(action);
    }
    
    public static Future make(final Procedure action, final Environment penvironment, final InPort in, final OutPort out, final OutPort err) {
        final Environment saveEnv = Environment.setSaveCurrent(penvironment);
        try {
            return new Future(action, in, out, err);
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
        catch (InterruptedException ex2) {
            throw new RuntimeException("thread join [force] was interrupted");
        }
        final Throwable ex = this.closure.exception;
        if (ex != null) {
            WrappedException.rethrow(ex);
        }
        return this.closure.result;
    }
    
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("#<future ");
        buf.append(this.getName());
        buf.append(">");
        return buf.toString();
    }
}
