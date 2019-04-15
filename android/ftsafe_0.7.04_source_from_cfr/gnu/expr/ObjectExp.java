/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.ExpVisitor;
import gnu.expr.LambdaExp;
import gnu.expr.Target;

public class ObjectExp
extends ClassExp {
    public ObjectExp() {
        super(true, new ClassType());
    }

    @Override
    protected Type calculateType() {
        return this.compiledType;
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitObjectExp(this, d);
    }

    @Override
    public void compile(Compilation comp, Target target) {
        CodeAttr code = comp.getCode();
        code.emitNew(this.compiledType);
        code.emitDup(1);
        Method init = Compilation.getConstructor(this.compiledType, this);
        if (this.closureEnvField != null) {
            LambdaExp caller = this.outerLambda();
            if (!comp.usingCallContext()) {
                this.getOwningLambda().loadHeapFrame(comp);
            } else {
                Variable closureEnv;
                Variable variable = closureEnv = caller.heapFrame != null ? caller.heapFrame : caller.closureEnv;
                if (closureEnv == null) {
                    code.emitPushThis();
                } else {
                    code.emitLoad(closureEnv);
                }
            }
        }
        code.emitInvokeSpecial(init);
        target.compileFromStack(comp, this.getCompiledClassType(comp));
    }
}

