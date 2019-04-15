/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Type;
import gnu.expr.BlockExitException;
import gnu.expr.BlockExp;
import gnu.expr.Compilation;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;

public class ExitExp
extends Expression {
    BlockExp block;
    Expression result;

    public ExitExp(Expression result, BlockExp block) {
        this.result = result;
        this.block = block;
    }

    public ExitExp(BlockExp block) {
        this.result = QuoteExp.voidExp;
        this.block = block;
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        throw new BlockExitException(this, this.result.eval(ctx));
    }

    @Override
    public void compile(Compilation comp, Target target) {
        CodeAttr code = comp.getCode();
        Expression res = this.result == null ? QuoteExp.voidExp : this.result;
        res.compileWithPosition(comp, this.block.exitTarget);
        this.block.exitableBlock.exit();
    }

    @Override
    protected Expression deepCopy(IdentityHashTable mapper) {
        Expression res = ExitExp.deepCopy(this.result, mapper);
        if (res == null && this.result != null) {
            return null;
        }
        Object b = mapper.get(this.block);
        ExitExp copy = new ExitExp(res, b == null ? this.block : (BlockExp)b);
        copy.flags = this.getFlags();
        return copy;
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitExitExp(this, d);
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.result = visitor.visitAndUpdate(this.result, d);
    }

    @Override
    public void print(OutPort out) {
        out.startLogicalBlock("(Exit", false, ")");
        out.writeSpaceFill();
        if (this.block != null) {
            out.print("Block#");
            out.print(this.block.id);
        } else if (this.block == null) {
            out.print("<unknown>");
        }
        if (this.result != null) {
            out.writeSpaceLinear();
            this.result.print(out);
        }
        out.endLogicalBlock(")");
    }

    @Override
    protected Type calculateType() {
        return Type.neverReturnsType;
    }
}

