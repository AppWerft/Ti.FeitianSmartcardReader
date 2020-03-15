// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class Procedure1 extends Procedure
{
    public Procedure1() {
    }
    
    public Procedure1(final String n) {
        super(n);
    }
    
    @Override
    public int numArgs() {
        return 4097;
    }
    
    @Override
    public Object apply0() throws Throwable {
        throw new WrongArguments(this, 0);
    }
    
    @Override
    public abstract Object apply1(final Object p0) throws Throwable;
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) throws Throwable {
        throw new WrongArguments(this, 2);
    }
    
    @Override
    public Object apply3(final Object arg1, final Object arg2, final Object arg3) throws Throwable {
        throw new WrongArguments(this, 3);
    }
    
    @Override
    public Object apply4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) throws Throwable {
        throw new WrongArguments(this, 4);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        if (args.length != 1) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply1(args[0]);
    }
}
