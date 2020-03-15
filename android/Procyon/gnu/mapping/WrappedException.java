// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class WrappedException extends RuntimeException
{
    public WrappedException() {
    }
    
    public WrappedException(final String message) {
        super(message);
    }
    
    public WrappedException(final Throwable e) {
        this((e == null) ? null : e.toString(), e);
    }
    
    public WrappedException(final String message, final Throwable e) {
        super(message, e);
    }
    
    public Throwable getException() {
        return this.getCause();
    }
    
    @Override
    public String toString() {
        return this.getMessage();
    }
    
    public static RuntimeException wrapIfNeeded(final Exception ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException)ex;
        }
        return new WrappedException(ex);
    }
    
    public static RuntimeException rethrow(final Throwable ex) {
        if (ex instanceof Error) {
            throw (Error)ex;
        }
        if (ex instanceof RuntimeException) {
            throw (RuntimeException)ex;
        }
        throw new WrappedException(ex);
    }
}
