/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.text.Options;
import gnu.text.SourceLocator;
import java.util.Vector;

public class BeginExp
extends Expression {
    Expression[] exps;
    int length;
    Vector compileOptions;

    public BeginExp() {
    }

    public BeginExp(Expression[] ex) {
        this.exps = ex;
        this.length = ex.length;
    }

    public BeginExp(Expression exp0, Expression exp1) {
        this.exps = new Expression[2];
        this.exps[0] = exp0;
        this.exps[1] = exp1;
        this.length = 2;
    }

    public static final Expression canonicalize(Expression exp) {
        if (exp instanceof BeginExp) {
            BeginExp bexp = (BeginExp)exp;
            if (bexp.compileOptions != null) {
                return exp;
            }
            int len = bexp.length;
            if (len == 0) {
                return QuoteExp.voidExp;
            }
            if (len == 1) {
                return BeginExp.canonicalize(bexp.exps[0]);
            }
        }
        return exp;
    }

    public static final Expression canonicalize(Expression[] exps) {
        int len = exps.length;
        if (len == 0) {
            return QuoteExp.voidExp;
        }
        if (len == 1) {
            return BeginExp.canonicalize(exps[0]);
        }
        return new BeginExp(exps);
    }

    public final void add(Expression exp) {
        if (this.exps == null) {
            this.exps = new Expression[8];
        }
        if (this.length == this.exps.length) {
            Expression[] ex = new Expression[2 * this.length];
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

    public final void setExpressions(Expression[] exps) {
        this.exps = exps;
        this.length = exps.length;
    }

    public void setCompileOptions(Vector options) {
        this.compileOptions = options;
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void apply(CallContext ctx) throws Throwable {
        int i;
        int n = this.length;
        Consumer consumerSave = ctx.consumer;
        ctx.consumer = VoidConsumer.instance;
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

    public void pushOptions(Compilation comp) {
        if (this.compileOptions != null && comp != null) {
            comp.currentOptions.pushOptionValues(this.compileOptions);
        }
    }

    public void popOptions(Compilation comp) {
        if (this.compileOptions != null && comp != null) {
            comp.currentOptions.popOptionValues(this.compileOptions);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void compile(Compilation comp, Target target) {
        this.pushOptions(comp);
        try {
            int i;
            int n = this.length;
            CodeAttr code = comp.getCode();
            for (i = 0; i < n - 1; ++i) {
                this.exps[i].compileWithPosition(comp, Target.Ignore);
                if (code.reachableHere()) continue;
                if (comp.warnUnreachable()) {
                    comp.error('w', "unreachable code", this.exps[i + 1]);
                }
                return;
            }
            this.exps[i].compileWithPosition(comp, target);
        }
        finally {
            this.popOptions(comp);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        this.pushOptions(visitor.comp);
        try {
            R r = visitor.visitBeginExp(this, d);
            return r;
        }
        finally {
            this.popOptions(visitor.comp);
        }
    }

    @Override
    protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {
        this.exps = visitor.visitExps(this.exps, this.length, d);
    }

    @Override
    public void print(OutPort out) {
        int i;
        out.startLogicalBlock("(Begin", ")", 2);
        out.writeSpaceFill();
        this.printLineColumn(out);
        if (this.compileOptions != null) {
            out.writeSpaceFill();
            out.startLogicalBlock("(CompileOptions", ")", 2);
            int sizeOptions = this.compileOptions.size();
            for (i = 0; i < sizeOptions; i += 3) {
                Object key = this.compileOptions.elementAt(i);
                Object value = this.compileOptions.elementAt(i + 2);
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
        int n = this.length;
        for (i = 0; i < n; ++i) {
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

