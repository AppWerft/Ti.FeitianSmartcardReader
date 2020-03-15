// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.bytecode.Scope;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Variable;
import gnu.bytecode.Type;

public class FluidLetExp extends LetExp
{
    @Override
    protected boolean mustCompile() {
        return true;
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        final Type result_type = (target instanceof IgnoreTarget) ? null : this.getType();
        Target ttarg;
        if (result_type == null) {
            ttarg = Target.Ignore;
        }
        else if (result_type == Type.pointer_type) {
            ttarg = Target.pushObject;
        }
        else {
            ttarg = new StackTarget(result_type);
        }
        final Scope scope = this.getVarScope();
        code.enterScope(scope);
        final Variable ctx = scope.addVariable(code, Compilation.typeCallContext, null);
        comp.loadCallContext();
        code.emitStore(ctx);
        final Variable[] save = new Variable[this.countDecls()];
        Declaration decl = this.firstDecl();
        this.doInits(decl, 0, save, comp, ctx);
        code.emitTryStart(true, result_type);
        this.body.compileWithPosition(comp, ttarg);
        code.emitFinallyStart();
        int i = 0;
        while (decl != null) {
            decl.load(null, 4, comp, Target.pushObject);
            code.emitLoad(save[i]);
            code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setRestore", 1));
            ++i;
            decl = decl.nextDecl();
        }
        code.emitTryCatchEnd();
        this.popScope(code);
        if (result_type != null) {
            target.compileFromStack(comp, result_type);
        }
    }
    
    private void doInits(final Declaration decl, final int i, final Variable[] save, final Compilation comp, final Variable ctx) {
        if (decl == null) {
            return;
        }
        final CodeAttr code = comp.getCode();
        save[i] = code.addLocal(Type.pointer_type);
        decl.allocateVariable(code);
        decl.base.load(null, 4, comp, Target.pushObject);
        code.emitDup();
        code.emitStore(decl.getVariable());
        decl.getInitValue().compile(comp, Target.pushObject);
        this.doInits(decl.nextDecl(), i + 1, save, comp, ctx);
        code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setWithSave", 1));
        code.emitStore(save[i]);
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitFluidLetExp(this, d);
    }
    
    @Override
    public void print(final OutPort out) {
        this.print(out, "(FluidLet", ")");
    }
}
