// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class Procedure2 extends Procedure
{
    public Procedure2(final String n) {
        super(n);
    }
    
    public Procedure2() {
    }
    
    @Override
    public int numArgs() {
        return 8194;
    }
    
    @Override
    public Object apply0() throws Throwable {
        throw new WrongArguments(this.getName(), 2, "(?)");
    }
    
    @Override
    public Object apply1(final Object arg1) throws Throwable {
        throw new WrongArguments(this, 1);
    }
    
    @Override
    public abstract Object apply2(final Object p0, final Object p1) throws Throwable;
    
    @Override
    public Object apply3(final Object arg1, final Object arg2, final Object arg3) {
        throw new WrongArguments(this, 3);
    }
    
    @Override
    public Object apply4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) throws Throwable {
        throw new WrongArguments(this, 4);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        if (args.length != 2) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply2(args[0], args[1]);
    }
}
