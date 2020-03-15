// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.bytecode.Variable;
import gnu.bytecode.Scope;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;

public class SynchronizedExp extends Expression
{
    Expression object;
    Expression body;
    
    public SynchronizedExp(final Expression object, final Expression body) {
        this.object = object;
        this.body = body;
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final Object value = this.object.eval(ctx);
        final Object result;
        synchronized (value) {
            result = this.body.eval(ctx);
        }
        ctx.writeValue(result);
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        this.object.compile(comp, Target.pushObject);
        code.emitDup(1);
        final Scope scope = code.pushScope();
        final Variable objvar = scope.addVariable(code, Type.pointer_type, null);
        code.emitStore(objvar);
        code.emitMonitorEnter();
        code.emitTryStart(false, (target instanceof IgnoreTarget || target instanceof ConsumerTarget) ? null : target.getType());
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
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitSynchronizedExp(this, d);
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.object = visitor.visitAndUpdate(this.object, d);
        if (visitor.exitValue == null) {
            this.body = visitor.visitAndUpdate(this.body, d);
        }
    }
    
    @Override
    public void print(final OutPort ps) {
        ps.print("(Synchronized ");
        this.object.print(ps);
        ps.print(" ");
        this.body.print(ps);
        ps.print(")");
    }
}
