// 
// Decompiled by Procyon v0.5.36
// 

package gnu.bytecode;

public class TryState
{
    TryState previous;
    Label end_label;
    Label finally_subr;
    Variable finally_ret_addr;
    Variable saved_result;
    Variable[] savedStack;
    Label start_try;
    Label end_try;
    ClassType try_type;
    Type[] savedTypes;
    ExitableBlock exitCases;
    Variable exception;
    boolean tryClauseDone;
    
    public TryState(final CodeAttr code) {
        this.previous = code.try_stack;
        code.try_stack = this;
        this.start_try = code.getLabel();
    }
    
    static TryState outerHandler(TryState innerTry, final TryState outerTry) {
        while (innerTry != outerTry && (innerTry.finally_subr == null || innerTry.tryClauseDone)) {
            innerTry = innerTry.previous;
        }
        return innerTry;
    }
}
