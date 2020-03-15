// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import gnu.lists.Consumer;
import java.io.IOException;
import gnu.kawa.format.Printable;

public class Promise<T> implements Printable, Lazy<T>
{
    Procedure thunk;
    boolean forceValueIfPromise;
    private volatile Object result;
    private Throwable throwable;
    
    public void setForceValueIfPromise(final boolean value) {
        this.forceValueIfPromise = value;
    }
    
    public Promise() {
        this.result = Location.UNBOUND;
    }
    
    public Promise(final Procedure thunk) {
        this.result = Location.UNBOUND;
        this.thunk = thunk;
    }
    
    public static <T> Lazy<T> makeBoundPromise(final T value) {
        final Promise<T> p = new Promise<T>(null);
        p.result = value;
        return p;
    }
    
    public static Lazy<Object> coerceToLazy(final Object value) {
        if (value instanceof Lazy) {
            return (Lazy<Object>)value;
        }
        final Promise<Object> p = new Promise<Object>(null);
        p.result = value;
        return p;
    }
    
    @Override
    public synchronized T getValue() {
        Object r;
        while (true) {
            synchronized (this) {
                while (this.isBlank()) {
                    try {
                        this.wait();
                    }
                    catch (InterruptedException ex2) {}
                }
                r = this.result;
                if (r == Location.UNBOUND && this.throwable == null) {
                    try {
                        r = this.thunk.apply0();
                        if (this.result == Location.UNBOUND) {
                            this.result = r;
                        }
                        else {
                            r = this.result;
                        }
                        if (this.forceValueIfPromise && r instanceof Promise) {
                            final Promise pr = (Promise)r;
                            synchronized (r) {
                                if (!pr.isBlank()) {
                                    this.moveFrom(pr);
                                    continue;
                                }
                            }
                        }
                    }
                    catch (Throwable ex) {
                        this.throwable = ex;
                    }
                    this.thunk = null;
                }
                if (this.throwable != null) {
                    WrappedException.rethrow(this.throwable);
                }
            }
            break;
        }
        if (this.forceValueIfPromise && r instanceof Lazy) {
            return ((Lazy)r).getValue();
        }
        return (T)r;
    }
    
    private void moveFrom(final Promise other) {
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
    
    public synchronized void setValue(final Object value) {
        this.checkBlank();
        this.result = value;
        this.notifyAll();
    }
    
    public synchronized void setAlias(final Lazy promise) {
        this.checkBlank();
        this.result = promise;
        this.setForceValueIfPromise(true);
        this.notifyAll();
    }
    
    public synchronized void setException(final Throwable exception) {
        this.checkBlank();
        this.throwable = exception;
        this.notifyAll();
    }
    
    public synchronized void setThunk(final Procedure thunk) {
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
        while (arg instanceof Lazy) {
            final Object val = ((Lazy)arg).getValue();
            if (arg == val) {
                break;
            }
            arg = val;
        }
        return arg;
    }
    
    public static Object force(Object arg, final Class target) {
        while (arg instanceof Lazy && !target.isInstance(arg)) {
            final Object val = ((Lazy)arg).getValue();
            if (arg == val) {
                break;
            }
            arg = val;
        }
        return arg;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        try {
            this.print(sb);
        }
        catch (IOException ex) {
            return "caught " + ex;
        }
        return sb.toString();
    }
    
    @Override
    public void print(final Consumer out) {
        try {
            this.print((Appendable)out);
        }
        catch (IOException ex) {
            out.write("caught " + ex);
        }
    }
    
    public void print(final Appendable out) throws IOException {
        final Object r = this.result;
        if (r == Location.UNBOUND) {
            synchronized (this) {
                if (this.throwable != null) {
                    out.append("#<promise - force threw a ");
                    out.append(this.throwable.getClass().getName());
                    out.append('>');
                }
                else {
                    out.append("#<promise - not forced yet>");
                }
            }
        }
        else if (r == null) {
            out.append("#<promise - forced to null>");
        }
        else {
            out.append("#<promise - forced to a ");
            out.append(r.getClass().getName());
            out.append('>');
        }
    }
}
