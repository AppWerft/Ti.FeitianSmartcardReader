// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class Setter0 extends Setter
{
    public Setter0(final Procedure getter) {
        super(getter);
    }
    
    @Override
    public int numArgs() {
        return 4097;
    }
    
    @Override
    public Object apply1(final Object result) throws Throwable {
        this.getter.set0(result);
        return Values.empty;
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        final int nargs = args.length;
        if (nargs != 1) {
            throw new WrongArguments(this, nargs);
        }
        this.getter.set0(args[0]);
        return Values.empty;
    }
}
