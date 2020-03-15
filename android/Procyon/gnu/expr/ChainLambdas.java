// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import gnu.kawa.functions.Convert;
import gnu.bytecode.Type;
import gnu.text.SourceLocator;

public class ChainLambdas extends ExpExpVisitor<ScopeExp>
{
    boolean unreachableCodeSeen;
    
    public static void chainLambdas(final Expression exp, final Compilation comp) {
        final ChainLambdas visitor = new ChainLambdas();
        visitor.setContext(comp);
        ((ExpVisitor<Object, D>)visitor).visit(exp, null);
    }
    
    protected void maybeWarnUnreachable(final Expression exp) {
        if (!this.unreachableCodeSeen && this.comp.warnUnreachable()) {
            this.comp.error('w', "unreachable code", exp);
        }
        this.unreachableCodeSeen = true;
    }
    
    protected Expression visitBeginExp(final BeginExp exp, final ScopeExp scope) {
        int neverReturnsIndex = -1;
        for (int last = exp.length - 1, i = 0; i <= last; ++i) {
            final Expression e = this.visit(exp.exps[i], (D)scope);
            exp.exps[i] = e;
            if (e.neverReturns() && neverReturnsIndex < 0 && (neverReturnsIndex = i) < last) {
                this.maybeWarnUnreachable(exp.exps[i + 1]);
            }
        }
        if (neverReturnsIndex >= 0) {
            exp.type = Type.neverReturnsType;
            exp.length = neverReturnsIndex + 1;
        }
        return exp;
    }
    
    protected Expression visitApplyExp(final ApplyExp exp, final ScopeExp scope) {
        final Expression f = this.visit(exp.func, (D)scope);
        final Expression[] args = exp.args;
        final int nargs = args.length;
        exp.func = f;
        if (f.neverReturns()) {
            this.maybeWarnUnreachable((nargs > 0) ? args[0] : exp);
            return f;
        }
        for (int i = 0; i < nargs; ++i) {
            final Expression e = this.visit(args[i], (D)scope);
            if (e.neverReturns() && !(f.valueIfConstant() instanceof Convert)) {
                final Expression[] xargs = new Expression[i + 2];
                xargs[0] = exp.func;
                System.arraycopy(args, 0, xargs, 1, i + 1);
                if (i + 1 < nargs || !exp.isAppendValues()) {
                    if (!this.unreachableCodeSeen && this.comp.warnUnreachable()) {
                        this.comp.error('w', "unreachable procedure call", exp);
                        this.comp.error('i', "this operand never finishes", args[i]);
                    }
                    this.unreachableCodeSeen = true;
                }
                final BeginExp bexp = new BeginExp(xargs);
                bexp.type = Type.neverReturnsType;
                return bexp;
            }
            args[i] = e;
        }
        return exp;
    }
    
    protected Expression visitSetExp(final SetExp sexp, final ScopeExp scope) {
        final Expression r = super.visitSetExp(sexp, (D)scope);
        if (r == sexp) {
            final Expression rval = sexp.getNewValue();
            if (rval.neverReturns()) {
                this.maybeWarnUnreachable(sexp);
                return rval;
            }
        }
        return r;
    }
    
    protected Expression visitIfExp(final IfExp exp, final ScopeExp scope) {
        final Expression e = this.visit(exp.test, (D)scope);
        if (e.neverReturns()) {
            this.maybeWarnUnreachable(exp.then_clause);
            return e;
        }
        exp.then_clause = this.visit(exp.then_clause, (D)scope);
        if (exp.else_clause != null) {
            exp.else_clause = this.visit(exp.else_clause, (D)scope);
            if (exp.then_clause.neverReturns() && exp.else_clause.neverReturns()) {
                exp.type = Type.neverReturnsType;
            }
        }
        return exp;
    }
    
    protected Expression visitCaseExp(final CaseExp exp, final ScopeExp scope) {
        final Expression e = this.visit(exp.key, (D)scope);
        if (e.neverReturns()) {
            for (int i = 0; i < exp.clauses.length; ++i) {
                this.maybeWarnUnreachable(exp.clauses[i].exp);
            }
            this.maybeWarnUnreachable(exp.elseClause.exp);
            return e;
        }
        boolean neverReturns = true;
        for (int j = 0; j < exp.clauses.length; ++j) {
            exp.clauses[j].exp = this.visit(exp.clauses[j].exp, (D)scope);
            if (!exp.clauses[j].exp.neverReturns()) {
                neverReturns = false;
            }
        }
        if (exp.elseClause != null) {
            exp.elseClause.exp = this.visit(exp.elseClause.exp, (D)scope);
            if (!exp.elseClause.exp.neverReturns()) {
                neverReturns = false;
            }
        }
        if (neverReturns) {
            exp.type = Type.neverReturnsType;
        }
        return exp;
    }
    
    protected Expression visitScopeExp(final ScopeExp exp, final ScopeExp scope) {
        exp.setOuter(scope);
        exp.visitChildren((ExpVisitor<Object, ScopeExp>)this, exp);
        exp.setIndexes();
        if (exp.mustCompile()) {
            this.comp.mustCompileHere();
        }
        return exp;
    }
    
    protected Expression visitLetExp(final LetExp exp, final ScopeExp scope) {
        exp.setOuter(scope);
        int count = 0;
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            final Expression init = decl.getInitValue();
            final Expression e = this.visit(init, (D)exp);
            ++count;
            if (e.neverReturns()) {
                if (!this.unreachableCodeSeen && this.comp.warnUnreachable()) {
                    this.comp.error('w', "initialization of " + decl.getName() + " never finishes", init);
                }
                this.unreachableCodeSeen = true;
                final Expression[] exps = new Expression[count];
                int i = 0;
                for (Declaration end = decl.nextDecl(), d = exp.firstDecl(); d != end; d = d.nextDecl()) {
                    exps[i++] = d.getInitValue();
                }
                return BeginExp.canonicalize(exps);
            }
            decl.setInitValue(e);
        }
        exp.body = this.visit(exp.body, (D)exp);
        exp.setIndexes();
        if (exp.mustCompile()) {
            this.comp.mustCompileHere();
        }
        return exp;
    }
    
    protected Expression visitLambdaExp(final LambdaExp exp, final ScopeExp scope) {
        final boolean unreachableSaved = this.unreachableCodeSeen;
        this.unreachableCodeSeen = false;
        final LambdaExp parent = this.currentLambda;
        if (parent != null && !(parent instanceof ClassExp)) {
            parent.pushChild(exp);
        }
        exp.setOuter(scope);
        exp.firstChild = null;
        exp.visitChildrenOnly((ExpVisitor<Object, LambdaExp>)this, exp);
        exp.visitProperties((ExpVisitor<Object, LambdaExp>)this, exp);
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
    
    protected Expression visitClassExp(final ClassExp exp, final ScopeExp scope) {
        final LambdaExp parent = this.currentLambda;
        if (parent != null && !(parent instanceof ClassExp)) {
            parent.pushChild(exp);
        }
        this.visitScopeExp(exp, scope);
        return exp;
    }
}
