// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class Procedure1or2 extends Procedure
{
    public Procedure1or2() {
    }
    
    public Procedure1or2(final String n) {
        super(n);
    }
    
    @Override
    public int numArgs() {
        return 8193;
    }
    
    @Override
    public Object apply0() {
        throw new WrongArguments(this, 0);
    }
    
    @Override
    public abstract Object apply1(final Object p0) throws Throwable;
    
    @Override
    public abstract Object apply2(final Object p0, final Object p1) throws Throwable;
    
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
        if (args.length == 1) {
            return this.apply1(args[0]);
        }
        if (args.length == 2) {
            return this.apply2(args[0], args[1]);
        }
        throw new WrongArguments(this, args.length);
    }
}
