/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.kawa.functions.CompileMisc;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import kawa.lang.Continuation;

public class CallCC
extends MethodProc
implements Inlineable {
    public static final CallCC callcc = new CallCC();

    CallCC() {
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyCallCC");
    }

    @Override
    public int numArgs() {
        return 4097;
    }

    @Override
    public int match1(Object proc, CallContext ctx) {
        if (!(proc instanceof Procedure)) {
            return -786432;
        }
        return super.match1(proc, ctx);
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Procedure proc = (Procedure)ctx.value1;
        Continuation cont = new Continuation(ctx);
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
    public void compile(ApplyExp exp, Compilation comp, Target target) {
        CompileMisc.compileCallCC(exp, comp, target, this);
    }

    @Override
    public Type getReturnType(Expression[] args) {
        return Type.pointer_type;
    }
}

