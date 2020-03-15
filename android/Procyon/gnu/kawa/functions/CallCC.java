// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.expr.Compilation;
import gnu.expr.ApplyExp;
import kawa.lang.Continuation;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.expr.Inlineable;
import gnu.mapping.MethodProc;

public class CallCC extends MethodProc implements Inlineable
{
    public static final CallCC callcc;
    
    CallCC() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyCallCC");
    }
    
    @Override
    public int numArgs() {
        return 4097;
    }
    
    @Override
    public int match1(final Object proc, final CallContext ctx) {
        if (!(proc instanceof Procedure)) {
            return -786432;
        }
        return super.match1(proc, ctx);
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        Procedure proc = (Procedure)ctx.value1;
        final Continuation cont = new Continuation(ctx);
        proc.check1(cont, ctx);
        proc = ctx.proc;
        ctx.proc = null;
        try {
            proc.apply(ctx);
            ctx.runUntilDone();
            cont.invoked = true;
        }
        catch (Exception ex) {
            Continuation.handleException$X(ex, cont, ctx);
        }
    }
    
    @Override
    public void compile(final ApplyExp exp, final Compilation comp, final Target target) {
        CompileMisc.compileCallCC(exp, comp, target, this);
    }
    
    @Override
    public Type getReturnType(final Expression[] args) {
        return Type.pointer_type;
    }
    
    static {
        callcc = new CallCC();
    }
}
