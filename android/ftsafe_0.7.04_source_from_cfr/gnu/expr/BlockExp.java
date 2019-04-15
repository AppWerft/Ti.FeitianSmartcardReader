/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.expr.BlockExitException;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExitExp;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;

public class BlockExp
extends Expression {
    Declaration label;
    Expression body;
    Expression exitBody;
    boolean runFinallyBlocks = true;
    ExitableBlock exitableBlock;
    Target exitTarget;
    int id = ++counter;
    static int counter;

    public void setBody(Expression body) {
        this.body = body;
    }

    public void setBody(Expression body, Expression exitBody) {
        this.body = body;
        this.exitBody = exitBody;
    }

    public void setRunFinallyBlocks(boolean value) {
        this.runFinallyBlocks = value;
    }

    public void setLabel(Declaration label) {
        this.label = label;
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        Object result;
        block3 : {
            try {
                result = this.body.eval(ctx);
            }
            catch (BlockExitException ex) {
                if (ex.exit.block != this) {
                    throw ex;
                }
                result = ex.exit.result;
                if (this.exitBody == null) break block3;
                result = this.exitBody.eval(ctx);
            }
        }
        ctx.writeValue(result);
    }

    @Override
    public void compile(Compilation comp, Target target) {
        ExitableBlock bl;
        Label doneLabel;
        CodeAttr code = comp.getCode();
        Type rtype = this.exitBody == null && target instanceof StackTarget ? target.getType() : null;
        this.exitableBlock = bl = code.startExitableBlock(rtype, this.runFinallyBlocks);
        this.exitTarget = this.exitBody == null ? target : Target.Ignore;
        this.body.compileWithPosition(comp, target);
        if (this.exitBody != null && code.reachableHere()) {
            doneLabel = new Label(code);
            code.emitGoto(doneLabel);
        } else {
            doneLabel = null;
        }
        code.endExitableBlock();
        if (this.exitBody != null) {
            this.exitBody.compileWithPosition(comp, target);
        }
        if (doneLabel != null) {
            doneLabel.define(code);
        }
        this.exitableBlock = null;
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitBlockExp(this, d);
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.body = visitor.visitAndUpdate(this.body, d);
        if (visitor.exitValue == null && this.exitBody != null) {
            this.exitBody = visitor.visitAndUpdate(this.exitBody, d);
        }
    }

    @Override
    public String toString() {
        return "BlockExp#" + this.id;
    }

    @Override
    public void print(OutPort out) {
        out.startLogicalBlock("(Block#", ")", 2);
        out.print(this.id);
        if (this.label != null) {
            out.print(' ');
            out.print(this.label.getName());
        }
        out.writeSpaceLinear();
        this.body.print(out);
        if (this.exitBody != null) {
            out.writeSpaceLinear();
            out.print("else ");
            this.exitBody.print(out);
        }
        out.endLogicalBlock(")");
    }
}

