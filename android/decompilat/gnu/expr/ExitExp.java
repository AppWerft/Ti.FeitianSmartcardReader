// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.kawa.util.IdentityHashTable;
import gnu.bytecode.CodeAttr;
import gnu.mapping.CallContext;

public class ExitExp extends Expression
{
    BlockExp block;
    Expression result;
    
    public ExitExp(final Expression result, final BlockExp block) {
        this.result = result;
        this.block = block;
    }
    
    public ExitExp(final BlockExp block) {
        this.result = QuoteExp.voidExp;
        this.block = block;
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        throw new BlockExitException(this, this.result.eval(ctx));
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        final CodeAttr code = comp.getCode();
        final Expression res = (this.result == null) ? QuoteExp.voidExp : this.result;
        res.compileWithPosition(comp, this.block.exitTarget);
        this.block.exitableBlock.exit();
    }
    
    @Override
    protected Expression deepCopy(final IdentityHashTable mapper) {
        final Expression res = Expression.deepCopy(this.result, mapper);
        if (res == null && this.result != null) {
            return null;
        }
        final Object b = mapper.get(this.block);
        final ExitExp copy = new ExitExp(res, (b == null) ? this.block : ((BlockExp)b));
        copy.flags = this.getFlags();
        return copy;
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        return visitor.visitExitExp(this, d);
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.result = visitor.visitAndUpdate(this.result, d);
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(Exit", false, ")");
        out.writeSpaceFill();
        if (this.block != null) {
            out.print("Block#");
            out.print(this.block.id);
        }
        else if (this.block == null) {
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
