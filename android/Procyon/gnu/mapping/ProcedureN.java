// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class ProcedureN extends Procedure
{
    public static final Object[] noArgs;
    
    public ProcedureN() {
    }
    
    public ProcedureN(final String n) {
        super(n);
    }
    
    @Override
    public Object apply0() throws Throwable {
        return this.applyN(ProcedureN.noArgs);
    }
    
    @Override
    public Object apply1(final Object arg1) throws Throwable {
        final Object[] args = { arg1 };
        return this.applyN(args);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) throws Throwable {
        final Object[] args = { arg1, arg2 };
        return this.applyN(args);
    }
    
    @Override
    public Object apply3(final Object arg1, final Object arg2, final Object arg3) throws Throwable {
        final Object[] args = { arg1, arg2, arg3 };
        return this.applyN(args);
    }
    
    @Override
    public Object apply4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) throws Throwable {
        final Object[] args = { arg1, arg2, arg3, arg4 };
        return this.applyN(args);
    }
    
    @Override
    public abstract Object applyN(final Object[] p0) throws Throwable;
    
    static {
        noArgs = new Object[0];
    }
}
