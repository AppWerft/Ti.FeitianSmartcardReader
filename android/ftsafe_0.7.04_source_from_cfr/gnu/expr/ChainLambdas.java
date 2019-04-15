/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.CaseExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExpExpVisitor;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.Convert;
import gnu.text.SourceLocator;

public class ChainLambdas
extends ExpExpVisitor<ScopeExp> {
    boolean unreachableCodeSeen;

    public static void chainLambdas(Expression exp, Compilation comp) {
        ChainLambdas visitor = new ChainLambdas();
        visitor.setContext(comp);
        visitor.visit(exp, null);
    }

    protected void maybeWarnUnreachable(Expression exp) {
        if (!this.unreachableCodeSeen && this.comp.warnUnreachable()) {
            this.comp.error('w', "unreachable code", exp);
        }
        this.unreachableCodeSeen = true;
    }

    @Override
    protected Expression visitBeginExp(BeginExp exp, ScopeExp scope) {
        int neverReturnsIndex = -1;
        int last = exp.length - 1;
        for (int i = 0; i <= last; ++i) {
            Expression e;
            exp.exps[i] = e = (Expression)this.visit(exp.exps[i], scope);
            if (!e.neverReturns() || neverReturnsIndex >= 0) continue;
            neverReturnsIndex = i;
            if (i >= last) continue;
            this.maybeWarnUnreachable(exp.exps[i + 1]);
        }
        if (neverReturnsIndex >= 0) {
            exp.type = Type.neverReturnsType;
            exp.length = neverReturnsIndex + 1;
        }
        return exp;
    }

    @Override
    protected Expression visitApplyExp(ApplyExp exp, ScopeExp scope) {
        Expression f = (Expression)this.visit(exp.func, scope);
        Expression[] args = exp.args;
        int nargs = args.length;
        exp.func = f;
        if (f.neverReturns()) {
            this.maybeWarnUnreachable(nargs > 0 ? args[0] : exp);
            return f;
        }
        for (int i = 0; i < nargs; ++i) {
            Expression e = (Expression)this.visit(args[i], scope);
            if (e.neverReturns() && !(f.valueIfConstant() instanceof Convert)) {
                Expression[] xargs = new Expression[i + 2];
                xargs[0] = exp.func;
                System.arraycopy(args, 0, xargs, 1, i + 1);
                if (i + 1 < nargs || !exp.isAppendValues()) {
                    if (!this.unreachableCodeSeen && this.comp.warnUnreachable()) {
                        this.comp.error('w', "unreachable procedure call", exp);
                        this.comp.error('i', "this operand never finishes", args[i]);
                    }
                    this.unreachableCodeSeen = true;
                }
                BeginExp bexp = new BeginExp(xargs);
                bexp.type = Type.neverReturnsType;
                return bexp;
            }
            args[i] = e;
        }
        return exp;
    }

    @Override
    protected Expression visitSetExp(SetExp sexp, ScopeExp scope) {
        Expression rval;
        Expression r = (Expression)super.visitSetExp(sexp, scope);
        if (r == sexp && (rval = sexp.getNewValue()).neverReturns()) {
            this.maybeWarnUnreachable(sexp);
            return rval;
        }
        return r;
    }

    @Override
    protected Expression visitIfExp(IfExp exp, ScopeExp scope) {
        Expression e = (Expression)this.visit(exp.test, scope);
        if (e.neverReturns()) {
            this.maybeWarnUnreachable(exp.then_clause);
            return e;
        }
        exp.then_clause = (Expression)this.visit(exp.then_clause, scope);
        if (exp.else_clause != null) {
            exp.else_clause = (Expression)this.visit(exp.else_clause, scope);
            if (exp.then_clause.neverReturns() && exp.else_clause.neverReturns()) {
                exp.type = Type.neverReturnsType;
            }
        }
        return exp;
    }

    @Override
    protected Expression visitCaseExp(CaseExp exp, ScopeExp scope) {
        Expression e = (Expression)this.visit(exp.key, scope);
        if (e.neverReturns()) {
            for (int i = 0; i < exp.clauses.length; ++i) {
                this.maybeWarnUnreachable(exp.clauses[i].exp);
            }
            this.maybeWarnUnreachable(exp.elseClause.exp);
            return e;
        }
        boolean neverReturns = true;
        for (int i = 0; i < exp.clauses.length; ++i) {
            exp.clauses[i].exp = (Expression)this.visit(exp.clauses[i].exp, scope);
            if (exp.clauses[i].exp.neverReturns()) continue;
            neverReturns = false;
        }
        if (exp.elseClause != null) {
            exp.elseClause.exp = (Expression)this.visit(exp.elseClause.exp, scope);
            if (!exp.elseClause.exp.neverReturns()) {
                neverReturns = false;
            }
        }
        if (neverReturns) {
            exp.type = Type.neverReturnsType;
        }
        return exp;
    }

    @Override
    protected Expression visitScopeExp(ScopeExp exp, ScopeExp scope) {
        exp.setOuter(scope);
        exp.visitChildren(this, exp);
        exp.setIndexes();
        if (exp.mustCompile()) {
            this.comp.mustCompileHere();
        }
        return exp;
    }

    @Override
    protected Expression visitLetExp(LetExp exp, ScopeExp scope) {
        exp.setOuter(scope);
        int count = 0;
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Expression init = decl.getInitValue();
            Expression e = (Expression)this.visit(init, exp);
            ++count;
            if (e.neverReturns()) {
                if (!this.unreachableCodeSeen && this.comp.warnUnreachable()) {
                    this.comp.error('w', "initialization of " + decl.getName() + " never finishes", init);
                }
                this.unreachableCodeSeen = true;
                Expression[] exps = new Expression[count];
                int i = 0;
                Declaration end = decl.nextDecl();
                for (Declaration d = exp.firstDecl(); d != end; d = d.nextDecl()) {
                    exps[i++] = d.getInitValue();
                }
                return BeginExp.canonicalize(exps);
            }
            decl.setInitValue(e);
        }
        exp.body = (Expression)this.visit(exp.body, exp);
        exp.setIndexes();
        if (exp.mustCompile()) {
            this.comp.mustCompileHere();
        }
        return exp;
    }

    @Override
    protected Expression visitLambdaExp(LambdaExp exp, ScopeExp scope) {
        boolean unreachableSaved = this.unreachableCodeSeen;
        this.unreachableCodeSeen = false;
        LambdaExp parent = this.currentLambda;
        if (parent != null && !(parent instanceof ClassExp)) {
            parent.pushChild(exp);
        }
        exp.setOuter(scope);
        exp.firstChild = null;
        exp.visitChildrenOnly(this, exp);
        exp.visitProperties(this, exp);
        exp.reverseChildList();
        if (exp.getName() == null && exp.nameDecl != null) {
            exp.setName(exp.nameDecl.getName());
        }
        exp.setIndexes();
        if (exp.mustCompile()) {
            this.comp.mustCompileHere();
        }
        this.unreachableCodeSeen = unreachableSaved;
        return exp;
    }

    @Override
    protected Expression visitClassExp(ClassExp exp, ScopeExp scope) {
        LambdaExp parent = this.currentLambda;
        if (parent != null && !(parent instanceof ClassExp)) {
            parent.pushChild(exp);
        }
        this.visitScopeExp((ScopeExp)exp, scope);
        return exp;
    }
}

