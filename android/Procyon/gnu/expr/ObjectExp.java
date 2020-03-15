// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Variable;
import gnu.bytecode.Method;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.ClassType;

public class ObjectExp extends ClassExp
{
    public ObjectExp() {
        super(true, new ClassType());
    }
    
    @Override
    protected Type calculateType() {
        return this.compiledType;
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitObjectExp(this, d);
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        code.emitNew(this.compiledType);
        code.emitDup(1);
        final Method init = Compilation.getConstructor(this.compiledType, this);
        if (this.closureEnvField != null) {
            final LambdaExp caller = this.outerLambda();
            if (!comp.usingCallContext()) {
                this.getOwningLambda().loadHeapFrame(comp);
            }
            else {
                final Variable closureEnv = (caller.heapFrame != null) ? caller.heapFrame : caller.closureEnv;
                if (closureEnv == null) {
                    code.emitPushThis();
                }
                else {
                    code.emitLoad(closureEnv);
                }
            }
        }
        code.emitInvokeSpecial(init);
        target.compileFromStack(comp, this.getCompiledClassType(comp));
    }
}
