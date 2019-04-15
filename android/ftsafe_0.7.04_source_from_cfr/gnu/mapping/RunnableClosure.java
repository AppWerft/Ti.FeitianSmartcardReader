/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import java.util.concurrent.Callable;

public class RunnableClosure<T>
implements Callable<T>,
Runnable {
    T result;
    CallContext context;
    private InPort in;
    private OutPort out;
    private OutPort err;
    Throwable exception;
    Procedure action;
    String name;
    static int nrunnables = 0;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RunnableClosure(Procedure action) {
        this.setName("r" + nrunnables++);
        this.action = action;
    }

    public RunnableClosure(Procedure action, InPort in, OutPort out, OutPort err) {
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
            Environment env = Environment.getCurrent();
            String name = this.getName();
            if (env != null && env.getSymbol() == null && name != null) {
                env.setName(name);
            }
            if (this.context == null) {
                this.context = CallContext.getInstance();
            } else {
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
            this.result = this.action.apply0();
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex) {
            this.exception = ex;
        }
    }

    public Object getResult() throws Throwable {
        Throwable ex = this.exception;
        if (ex != null) {
            throw ex;
        }
        return this.result;
    }

    @Override
    public T call() throws Exception {
        this.run();
        Throwable ex = this.exception;
        if (ex != null) {
            if (ex instanceof Exception) {
                throw (Exception)ex;
            }
            if (ex instanceof Error) {
                throw (Error)ex;
            }
            throw new RuntimeException(ex);
        }
        return this.result;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("#<runnable ");
        buf.append(this.getName());
        buf.append(">");
        return buf.toString();
    }
}

