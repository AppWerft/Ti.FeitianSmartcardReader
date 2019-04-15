/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.AccessExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.LetExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;

public class FluidLetExp
extends LetExp {
    @Override
    protected boolean mustCompile() {
        return true;
    }

    @Override
    public void compile(Compilation comp, Target target) {
        Declaration decl;
        Type result_type;
        CodeAttr code = comp.getCode();
        Type type = result_type = target instanceof IgnoreTarget ? null : this.getType();
        Target ttarg = result_type == null ? Target.Ignore : (result_type == Type.pointer_type ? Target.pushObject : new StackTarget(result_type));
        Scope scope = this.getVarScope();
        code.enterScope(scope);
        Variable ctx = scope.addVariable(code, Compilation.typeCallContext, null);
        comp.loadCallContext();
        code.emitStore(ctx);
        Variable[] save = new Variable[this.countDecls()];
        this.doInits(decl, 0, save, comp, ctx);
        code.emitTryStart(true, result_type);
        this.body.compileWithPosition(comp, ttarg);
        code.emitFinallyStart();
        int i = 0;
        for (decl = this.firstDecl(); decl != null; decl = decl.nextDecl()) {
            decl.load(null, 4, comp, Target.pushObject);
            code.emitLoad(save[i]);
            code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setRestore", 1));
            ++i;
        }
        code.emitTryCatchEnd();
        this.popScope(code);
        if (result_type != null) {
            target.compileFromStack(comp, result_type);
        }
    }

    private void doInits(Declaration decl, int i, Variable[] save, Compilation comp, Variable ctx) {
        if (decl == null) {
            return;
        }
        CodeAttr code = comp.getCode();
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
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitFluidLetExp(this, d);
    }

    @Override
    public void print(OutPort out) {
        this.print(out, "(FluidLet", ")");
    }
}

