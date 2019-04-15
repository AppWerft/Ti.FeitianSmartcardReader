/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.WrappedException;

public class ProcLocation
extends Location<Object> {
    Procedure proc;
    Object[] args;

    public ProcLocation(Procedure proc, Object[] args) {
        this.proc = proc;
        this.args = args;
    }

    @Override
    public Object get(Object defaultValue) {
        return this.get();
    }

    @Override
    public Object get() {
        try {
            return this.proc.applyN(this.args);
        }
        catch (Throwable ex) {
            throw WrappedException.rethrow(ex);
        }
    }

    @Override
    public void set(Object value) {
        int len = this.args.length;
        Object[] xargs = new Object[len + 1];
        xargs[len] = value;
        System.arraycopy(this.args, 0, xargs, 0, len);
        try {
            this.proc.setN(xargs);
        }
        catch (Throwable ex) {
            throw WrappedException.rethrow(ex);
        }
    }

    @Override
    public boolean isBound() {
        return true;
    }
}

