// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public abstract class Procedure3 extends Procedure
{
    public Procedure3() {
    }
    
    public Procedure3(final String n) {
        super(n);
    }
    
    @Override
    public int numArgs() {
        return 12291;
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
    public abstract Object apply3(final Object p0, final Object p1, final Object p2) throws Throwable;
    
    @Override
    public Object apply4(final Object arg1, final Object arg2, final Object arg3, final Object arg4) {
        throw new WrongArguments(this, 4);
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        if (args.length != 3) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply3(args[0], args[1], args[2]);
    }
}
