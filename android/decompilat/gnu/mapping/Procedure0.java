// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class Procedure0 extends Procedure
{
    public Procedure0() {
    }
    
    public Procedure0(final String n) {
        super(n);
    }
    
    @Override
    public int numArgs() {
        return 0;
    }
    
    @Override
    public abstract Object apply0() throws Throwable;
    
    @Override
    public Object apply1(final Object arg1) {
        throw new WrongArguments(this, 1);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        throw new WrongArguments(this, 2);
    }
    
    @Override
    public Object apply3(final Object arg1, final Object arg2, final Object arg3) {
        throw new WrongArguments(this, 3);
    }
    
    @Override
    public Object apply4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
        throw new WrongArguments(this, 4);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        if (args.length != 0) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply0();
    }
}
