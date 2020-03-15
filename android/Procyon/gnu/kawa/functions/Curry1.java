// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;

public class Curry1 extends Procedure1
{
    public static final Curry1 makeConverter;
    Procedure proc2;
    
    public Curry1(final String name, final Procedure proc2) {
        super(name);
        this.proc2 = proc2;
    }
    
    @Override
    public Object apply1(final Object arg) {
        return new Curried1(this.proc2, arg);
    }
    
    static {
        makeConverter = new Curry1("make-converter", Convert.cast);
    }
    
    static class Curried1 extends Procedure1
    {
        Object arg1;
        Procedure proc2;
        
        public Curried1(final Procedure proc2, final Object arg1) {
            this.proc2 = proc2;
            this.arg1 = arg1;
        }
        
        @Override
        public Object apply1(final Object arg2) throws Throwable {
            return this.proc2.apply2(this.arg1, arg2);
        }
    }
}
