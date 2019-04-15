/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;

public class SynchronizedExp
extends Expression {
    Expression object;
    Expression body;

    public SynchronizedExp(Expression object2, Expression body) {
        this.object = object2;
        this.body = body;
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void apply(CallContext ctx) throws Throwable {
        Object value;
        Object result;
        Object object2 = value = this.object.eval(ctx);
        synchronized (object2) {
            result = this.body.eval(ctx);
        }
        ctx.writeValue(result);
    }

    @Override
    public void compile(Compilation comp, Target target) {
        CodeAttr code = comp.getCode();
        this.object.compile(comp, Target.pushObject);
        code.emitDup(1);
        Scope scope = code.pushScope();
        Variable objvar = scope.addVariable(code, Type.pointer_type, null);
        code.emitStore(objvar);
        code.emitMonitorEnter();
        code.emitTryStart(false, target instanceof IgnoreTarget || target instanceof ConsumerTarget ? null : target.getType());
        this.body.compileWithPosition(comp, target);
        code.emitLoad(objvar);
        code.emitMonitorExit();
        code.emitCatchStart((ClassType)null);
        code.emitLoad(objvar);
        code.emitMonitorExit();
        code.emitThrow();
        code.emitCatchEnd();
        code.emitTryCatchEnd();
        code.popScope();
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitSynchronizedExp(this, d);
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.object = visitor.visitAndUpdate(this.object, d);
        if (visitor.exitValue == null) {
            this.body = visitor.visitAndUpdate(this.body, d);
        }
    }

    @Override
    public void print(OutPort ps) {
        ps.print("(Synchronized ");
        this.object.print(ps);
        ps.print(" ");
        this.body.print(ps);
        ps.print(")");
    }
}

