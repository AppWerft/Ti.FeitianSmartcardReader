// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class Setter1 extends Setter
{
    public Setter1(final Procedure getter) {
        super(getter);
    }
    
    @Override
    public int numArgs() {
        return 8194;
    }
    
    @Override
    public Object apply2(final Object arg, final Object value) throws Throwable {
        this.getter.set1(arg, value);
        return Values.empty;
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        final int nargs = args.length;
        if (nargs != 2) {
            throw new WrongArguments(this, nargs);
        }
        this.getter.set1(args[0], args[1]);
        return Values.empty;
    }
}
