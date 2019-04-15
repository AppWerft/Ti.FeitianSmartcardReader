/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.text.SourceLocator;

public abstract class ExpExpVisitor<D>
extends ExpVisitor<Expression, D> {
    @Override
    protected Expression update(Expression exp, Expression r) {
        return r;
    }

    @Override
    protected Expression defaultValue(Expression r, D d) {
        return r;
    }

    public ErrorExp error(String msg) {
        return this.comp.syntaxError(msg);
    }

    public ErrorExp error(char severity, String message, SourceLocator location2) {
        this.comp.error(severity, message, location2);
        return new ErrorExp(message);
    }
}

