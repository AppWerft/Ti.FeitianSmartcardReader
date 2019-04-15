/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

public class WrappedException
extends RuntimeException {
    public WrappedException() {
    }

    public WrappedException(String message) {
        super(message);
    }

    public WrappedException(Throwable e) {
        this(e == null ? null : e.toString(), e);
    }

    public WrappedException(String message, Throwable e) {
        super(message, e);
    }

    public Throwable getException() {
        return this.getCause();
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

    public static RuntimeException wrapIfNeeded(Exception ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException)ex;
        }
        return new WrappedException(ex);
    }

    public static RuntimeException rethrow(Throwable ex) {
        if (ex instanceof Error) {
            throw (Error)ex;
        }
        if (ex instanceof RuntimeException) {
            throw (RuntimeException)ex;
        }
        throw new WrappedException(ex);
    }
}

