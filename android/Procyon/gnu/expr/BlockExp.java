// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.io.OutPort;
import gnu.bytecode.Type;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.mapping.CallContext;
import gnu.bytecode.ExitableBlock;

public class BlockExp extends Expression
{
    Declaration label;
    Expression body;
    Expression exitBody;
    boolean runFinallyBlocks;
    ExitableBlock exitableBlock;
    Target exitTarget;
    int id;
    static int counter;
    
    public BlockExp() {
        this.runFinallyBlocks = true;
        this.id = ++BlockExp.counter;
    }
    
    public void setBody(final Expression body) {
        this.body = body;
    }
    
    public void setBody(final Expression body, final Expression exitBody) {
        this.body = body;
        this.exitBody = exitBody;
    }
    
    public void setRunFinallyBlocks(final boolean value) {
        this.runFinallyBlocks = value;
    }
    
    public void setLabel(final Declaration label) {
        this.label = label;
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        Object result;
        try {
            result = this.body.eval(ctx);
        }
        catch (BlockExitException ex) {
            if (ex.exit.block != this) {
                throw ex;
            }
            result = ex.exit.result;
            if (this.exitBody != null) {
                result = this.exitBody.eval(ctx);
            }
        }
        ctx.writeValue(result);
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        final Type rtype = (this.exitBody == null && target instanceof StackTarget) ? target.getType() : null;
        final ExitableBlock bl = code.startExitableBlock(rtype, this.runFinallyBlocks);
        this.exitableBlock = bl;
        this.exitTarget = ((this.exitBody == null) ? target : Target.Ignore);
        this.body.compileWithPosition(comp, target);
        Label doneLabel;
        if (this.exitBody != null && code.reachableHere()) {
            doneLabel = new Label(code);
            code.emitGoto(doneLabel);
        }
        else {
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
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitBlockExp(this, d);
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
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
    public void print(final OutPort out) {
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
