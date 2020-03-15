// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class Procedure4 extends Procedure
{
    public Procedure4() {
    }
    
    public Procedure4(final String n) {
        super(n);
    }
    
    @Override
    public int numArgs() {
        return 16388;
    }
    
    @Override
    public Object apply0() {
        throw new WrongArguments(this, 0);
    }
    
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
    public abstract Object apply4(final Object p0, final Object p1, final Object p2, final Object p3) throws Throwable;
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        if (args.length != 4) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply4(args[0], args[1], args[2], args[3]);
    }
}
