// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class ProcLocation extends Location<Object>
{
    Procedure proc;
    Object[] args;
    
    public ProcLocation(final Procedure proc, final Object[] args) {
        this.proc = proc;
        this.args = args;
    }
    
    @Override
    public Object get(final Object defaultValue) {
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
    public void set(final Object value) {
        final int len = this.args.length;
        final Object[] xargs = new Object[len + 1];
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
