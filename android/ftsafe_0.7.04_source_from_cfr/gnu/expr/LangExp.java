/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Compilation;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.kawa.io.OutPort;

public class LangExp
extends Expression {
    Object hook;

    public Object getLangValue() {
        return this.hook;
    }

    public void setLangValue(Object value) {
        this.hook = value;
    }

    public LangExp() {
    }

    public LangExp(Object value) {
        this.hook = value;
    }

    @Override
    protected boolean mustCompile() {
        return false;
    }

    @Override
    public void print(OutPort out) {
        out.print("(LangExp ???)");
    }

    @Override
    protected <R, D> R visit(ExpVisitor<R, D> visitor, D d) {
        return visitor.visitLangExp(this, d);
    }

    @Override
    public void compile(Compilation comp, Target target) {
        throw new RuntimeException("compile called on LangExp");
    }
}

