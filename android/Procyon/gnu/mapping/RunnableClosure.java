// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.kawa.io.OutPort;
import gnu.kawa.io.InPort;
import java.util.concurrent.Callable;

public class RunnableClosure<T> implements Callable<T>, Runnable
{
    T result;
    CallContext context;
    private InPort in;
    private OutPort out;
    private OutPort err;
    Throwable exception;
    Procedure action;
    String name;
    static int nrunnables;
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public RunnableClosure(final Procedure action) {
        this.setName("r" + RunnableClosure.nrunnables++);
        this.action = action;
    }
    
    public RunnableClosure(final Procedure action, final InPort in, final OutPort out, final OutPort err) {
        this(action);
        this.in = in;
        this.out = out;
        this.err = err;
    }
    
    public final CallContext getCallContext() {
        return this.context;
    }
    
    @Override
    public void run() {
        try {
            final Environment env = Environment.getCurrent();
            final String name = this.getName();
            if (env != null && env.getSymbol() == null && name != null) {
                env.setName(name);
            }
            if (this.context == null) {
                this.context = CallContext.getInstance();
            }
            else {
                CallContext.setInstance(this.context);
            }
            if (this.in != null) {
                InPort.setInDefault(this.in);
            }
            if (this.out != null) {
                OutPort.setOutDefault(this.out);
            }
            if (this.err != null) {
                OutPort.setErrDefault(this.err);
            }
            this.result = (T)this.action.apply0();
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex2) {
            this.exception = ex2;
        }
    }
    
    public Object getResult() throws Throwable {
        final Throwable ex = this.exception;
        if (ex != null) {
            throw ex;
        }
        return this.result;
    }
    
    @Override
    public T call() throws Exception {
        this.run();
        final Throwable ex = this.exception;
        if (ex == null) {
            return this.result;
        }
        if (ex instanceof Exception) {
            throw (Exception)ex;
        }
        if (ex instanceof Error) {
            throw (Error)ex;
        }
        throw new RuntimeException(ex);
    }
    
    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("#<runnable ");
        buf.append(this.getName());
        buf.append(">");
        return buf.toString();
    }
    
    static {
        RunnableClosure.nrunnables = 0;
    }
}
