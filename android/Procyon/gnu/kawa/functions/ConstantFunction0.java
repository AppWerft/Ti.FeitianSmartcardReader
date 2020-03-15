// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.expr.QuoteExp;
import gnu.mapping.Procedure0;

public class ConstantFunction0 extends Procedure0
{
    final Object value;
    final QuoteExp constant;
    
    public ConstantFunction0(final String name, final Object value) {
        this(name, QuoteExp.getInstance(value));
    }
    
    public ConstantFunction0(final String name, final QuoteExp constant) {
        super(name);
        this.value = constant.getValue();
        this.constant = constant;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConstantFunction0");
    }
    
    @Override
    public Object apply0() {
        return this.value;
    }
}
