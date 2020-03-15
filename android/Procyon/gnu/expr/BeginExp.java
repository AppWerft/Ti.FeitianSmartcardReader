// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.bytecode.CodeAttr;
import gnu.text.SourceLocator;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import java.util.Vector;

public class BeginExp extends Expression
{
    Expression[] exps;
    int length;
    Vector compileOptions;
    
    public BeginExp() {
    }
    
    public BeginExp(final Expression[] ex) {
        this.exps = ex;
        this.length = ex.length;
    }
    
    public BeginExp(final Expression exp0, final Expression exp1) {
        (this.exps = new Expression[2])[0] = exp0;
        this.exps[1] = exp1;
        this.length = 2;
    }
    
    public static final Expression canonicalize(final Expression exp) {
        if (exp instanceof BeginExp) {
            final BeginExp bexp = (BeginExp)exp;
            if (bexp.compileOptions != null) {
                return exp;
            }
            final int len = bexp.length;
            if (len == 0) {
                return QuoteExp.voidExp;
            }
            if (len == 1) {
                return canonicalize(bexp.exps[0]);
            }
        }
        return exp;
    }
    
    public static final Expression canonicalize(final Expression[] exps) {
        final int len = exps.length;
        if (len == 0) {
            return QuoteExp.voidExp;
        }
        if (len == 1) {
            return canonicalize(exps[0]);
        }
        return new BeginExp(exps);
    }
    
    public final void add(final Expression exp) {
        if (this.exps == null) {
            this.exps = new Expression[8];
        }
        if (this.length == this.exps.length) {
            final Expression[] ex = new Expression[2 * this.length];
            System.arraycopy(this.exps, 0, ex, 0, this.length);
            this.exps = ex;
        }
        this.exps[this.length++] = exp;
    }
    
    public final Expression[] getExpressions() {
        return this.exps;
    }
    
    public final int getExpressionCount() {
        return this.length;
    }
    
    public final void setExpressions(final Expression[] exps) {
        this.exps = exps;
        this.length = exps.length;
    }
    
    public void setCompileOptions(final Vector options) {
        this.compileOptions = options;
    }
    
    @Override
    protected boolean mustCompile() {
        return false;
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        final int n = this.length;
        final Consumer consumerSave = ctx.consumer;
        ctx.consumer = VoidConsumer.instance;
        int i;
        try {
            for (i = 0; i < n - 1; ++i) {
                this.exps[i].eval(ctx);
            }
        }
        finally {
            ctx.consumer = consumerSave;
        }
        this.exps[i].apply(ctx);
    }
    
    public void pushOptions(final Compilation comp) {
        if (this.compileOptions != null && comp != null) {
            comp.currentOptions.pushOptionValues(this.compileOptions);
        }
    }
    
    public void popOptions(final Compilation comp) {
        if (this.compileOptions != null && comp != null) {
            comp.currentOptions.popOptionValues(this.compileOptions);
        }
    }
    
    @Override
    public void compile(final Compilation comp, final Target target) {
        this.pushOptions(comp);
        try {
            final int n = this.length;
            final CodeAttr code = comp.getCode();
            int i;
            for (i = 0; i < n - 1; ++i) {
                this.exps[i].compileWithPosition(comp, Target.Ignore);
                if (!code.reachableHere()) {
                    if (comp.warnUnreachable()) {
                        comp.error('w', "unreachable code", this.exps[i + 1]);
                    }
                    return;
                }
            }
            this.exps[i].compileWithPosition(comp, target);
        }
        finally {
            this.popOptions(comp);
        }
    }
    
    @Override
    protected <R, D> R visit(final ExpVisitor<R, D> visitor, final D d) {
        this.pushOptions(visitor.comp);
        try {
            return visitor.visitBeginExp(this, d);
        }
        finally {
            this.popOptions(visitor.comp);
        }
    }
    
    @Override
    protected <R, D> void visitChildren(final ExpVisitor<R, D> visitor, final D d) {
        this.exps = visitor.visitExps(this.exps, this.length, d);
    }
    
    @Override
    public void print(final OutPort out) {
        out.startLogicalBlock("(Begin", ")", 2);
        out.writeSpaceFill();
        this.printLineColumn(out);
        if (this.compileOptions != null) {
            out.writeSpaceFill();
            out.startLogicalBlock("(CompileOptions", ")", 2);
            for (int sizeOptions = this.compileOptions.size(), i = 0; i < sizeOptions; i += 3) {
                final Object key = this.compileOptions.elementAt(i);
                final Object value = this.compileOptions.elementAt(i + 2);
                out.writeSpaceFill();
                out.startLogicalBlock("", "", 2);
                out.print(key);
                out.print(':');
                out.writeSpaceLinear();
                out.print(value);
                out.endLogicalBlock("");
            }
            out.endLogicalBlock(")");
        }
        for (int n = this.length, i = 0; i < n; ++i) {
            out.writeSpaceLinear();
            this.exps[i].print(out);
        }
        out.endLogicalBlock(")");
    }
    
    @Override
    protected Type calculateType() {
        return this.exps[this.length - 1].getType();
    }
}
