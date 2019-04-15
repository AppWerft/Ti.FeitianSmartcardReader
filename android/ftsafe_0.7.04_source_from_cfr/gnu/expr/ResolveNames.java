/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpExpVisitor;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;

public class ResolveNames
extends ExpExpVisitor<Void> {
    protected NameLookup lookup;

    public ResolveNames() {
    }

    public ResolveNames(Compilation comp) {
        this.setContext(comp);
        this.lookup = comp.lexical;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resolveModule(ModuleExp exp) {
        Compilation saveComp = Compilation.setSaveCurrent(this.comp);
        try {
            this.push(exp);
            exp.visitChildren(this, null);
        }
        finally {
            Compilation.restoreCurrent(saveComp);
        }
    }

    protected void push(ScopeExp exp) {
        this.lookup.push(exp);
    }

    @Override
    protected Expression visitScopeExp(ScopeExp exp, Void ignored) {
        this.visitDeclarationTypes(exp);
        this.push(exp);
        exp.visitChildren(this, ignored);
        this.lookup.pop(exp);
        return exp;
    }

    @Override
    protected Expression visitLetExp(LetExp exp, Void ignored) {
        this.visitDeclarationTypes(exp);
        exp.visitInitializers(this, ignored);
        this.push(exp);
        exp.body = (Expression)this.visit(exp.body, ignored);
        this.lookup.pop(exp);
        return exp;
    }

    public Declaration lookup(Expression exp, Object symbol, boolean function2) {
        return this.lookup.lookup(symbol, function2);
    }

    @Override
    protected Expression visitReferenceExp(ReferenceExp exp, Void ignored) {
        Declaration decl = exp.getBinding();
        if (decl == null && (decl = this.lookup(exp, exp.getSymbol(), exp.isProcedureName())) != null) {
            exp.setBinding(decl);
        }
        return exp;
    }

    @Override
    protected Expression visitSetExp(SetExp exp, Void ignored) {
        if (exp.binding == null) {
            Declaration decl = this.lookup(exp, exp.getSymbol(), exp.isFuncDef());
            if (decl != null) {
                decl.setCanWrite(true);
            }
            exp.binding = decl;
        }
        return (Expression)super.visitSetExp(exp, ignored);
    }
}

