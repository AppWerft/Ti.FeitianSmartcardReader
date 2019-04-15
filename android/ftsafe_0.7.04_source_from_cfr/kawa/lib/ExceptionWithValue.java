/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.mapping.Promise;

public class ExceptionWithValue
extends RuntimeException {
    public Object payload;

    public String getMessage() {
        return this.payload.toString();
    }

    public static Throwable wrap(Object value) {
        Throwable throwable;
        if (value instanceof Throwable) {
            throwable = (Throwable)Promise.force(value, Throwable.class);
        } else {
            throwable = new ExceptionWithValue();
            new ExceptionWithValue().payload = value;
        }
        return throwable;
    }

    public static Object unwrap(Object ex) {
        return ex instanceof ExceptionWithValue ? ((ExceptionWithValue)Promise.force((Object)ex, ExceptionWithValue.class)).payload : ex;
    }
}

