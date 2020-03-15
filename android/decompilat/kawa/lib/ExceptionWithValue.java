// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Promise;

public class ExceptionWithValue extends RuntimeException
{
    public Object payload;
    
    @Override
    public String getMessage() {
        return this.payload.toString();
    }
    
    public static Throwable wrap(final Object value) {
        Throwable t;
        if (value instanceof Throwable) {
            t = (Throwable)Promise.force(value, Throwable.class);
        }
        else {
            ((ExceptionWithValue)(t = new ExceptionWithValue())).payload = value;
        }
        return t;
    }
    
    public static Object unwrap(final Object ex) {
        return (ex instanceof ExceptionWithValue) ? ((ExceptionWithValue)Promise.force(ex, ExceptionWithValue.class)).payload : ex;
    }
}
