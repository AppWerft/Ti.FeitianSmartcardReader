// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

public class Setter extends ProcedureN
{
    protected Procedure getter;
    
    public Setter(final Procedure getter) {
        this.getter = getter;
        final String name = getter.getName();
        if (name != null) {
            this.setName("(setter " + name + ")");
        }
    }
    
    @Override
    public int numArgs() {
        final int get_args = this.getter.numArgs();
        if (get_args < 0) {
            return get_args + 1;
        }
        return get_args + 4097;
    }
    
    @Override
    public Object applyN(final Object[] args) throws Throwable {
        this.getter.setN(args);
        return Values.empty;
    }
}
