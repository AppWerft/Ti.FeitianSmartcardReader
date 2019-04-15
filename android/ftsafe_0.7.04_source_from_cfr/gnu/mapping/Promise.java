/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.mapping.Lazy;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import java.io.IOException;

public class Promise<T>
implements Printable,
Lazy<T> {
    Procedure thunk;
    boolean forceValueIfPromise;
    private volatile Object result = Location.UNBOUND;
    private Throwable throwable;

    public void setForceValueIfPromise(boolean value) {
        this.forceValueIfPromise = value;
    }

    public Promise() {
    }

    public Promise(Procedure thunk) {
        this.thunk = thunk;
    }

    public static <T> Lazy<T> makeBoundPromise(T value) {
        Promise<T> p = new Promise<T>(null);
        p.result = value;
        return p;
    }

    public static Lazy<Object> coerceToLazy(Object value) {
        if (value instanceof Lazy) {
            return (Lazy)value;
        }
        Promise<Object> p = new Promise<Object>(null);
        p.result = value;
        return p;
    }

    /*
     * Exception decompiling
     */
    @Override
    public synchronized T getValue() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[UNCONDITIONALDOLOOP]], but top level block is 13[SIMPLE_IF_TAKEN]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    private void moveFrom(Promise other) {
        this.thunk = other.thunk;
        this.forceValueIfPromise = other.forceValueIfPromise;
        this.throwable = other.throwable;
        this.result = other.result;
        other.result = this;
        other.forceValueIfPromise = true;
        other.thunk = null;
        other.throwable = null;
    }

    public final synchronized boolean isBlank() {
        return this.thunk == null && this.result == Location.UNBOUND && this.throwable == null;
    }

    public void checkBlank() {
        if (!this.isBlank()) {
            throw new IllegalStateException();
        }
    }

    public synchronized void setValue(Object value) {
        this.checkBlank();
        this.result = value;
        this.notifyAll();
    }

    public synchronized void setAlias(Lazy promise) {
        this.checkBlank();
        this.result = promise;
        this.setForceValueIfPromise(true);
        this.notifyAll();
    }

    public synchronized void setException(Throwable exception) {
        this.checkBlank();
        this.throwable = exception;
        this.notifyAll();
    }

    public synchronized void setThunk(Procedure thunk) {
        this.checkBlank();
        this.thunk = thunk;
        this.notifyAll();
    }

    public static Object force1(Object arg) {
        if (arg instanceof Lazy) {
            arg = ((Lazy)arg).getValue();
        }
        return arg;
    }

    public static Object force(Object arg) {
        Object val;
        while (arg instanceof Lazy && arg != (val = ((Lazy)arg).getValue())) {
            arg = val;
        }
        return arg;
    }

    public static Object force(Object arg, Class target) {
        Object val;
        while (arg instanceof Lazy && !target.isInstance(arg) && arg != (val = ((Lazy)arg).getValue())) {
            arg = val;
        }
        return arg;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            this.print(sb);
        }
        catch (IOException ex) {
            return "caught " + ex;
        }
        return sb.toString();
    }

    @Override
    public void print(Consumer out) {
        try {
            this.print((Appendable)out);
        }
        catch (IOException ex) {
            out.write("caught " + ex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void print(Appendable out) throws IOException {
        Object r = this.result;
        if (r == Location.UNBOUND) {
            Promise promise = this;
            synchronized (promise) {
                if (this.throwable != null) {
                    out.append("#<promise - force threw a ");
                    out.append(this.throwable.getClass().getName());
                    out.append('>');
                } else {
                    out.append("#<promise - not forced yet>");
                }
            }
        } else if (r == null) {
            out.append("#<promise - forced to null>");
        } else {
            out.append("#<promise - forced to a ");
            out.append(r.getClass().getName());
            out.append('>');
        }
    }
}

