/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.BlockExp;
import gnu.expr.CaseExp;
import gnu.expr.CatchClause;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExitExp;
import gnu.expr.ExpExpVisitor;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.SynchronizedExp;
import gnu.expr.TryExp;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindTailCalls
extends ExpExpVisitor<Expression> {
    public HashMap<Expression, Expression> savedReturnContinuations;

    public static void findTailCalls(Expression exp, Compilation comp) {
        FindTailCalls visitor = new FindTailCalls();
        visitor.setContext(comp);
        visitor.visit(exp, exp);
    }

    @Override
    protected Expression visitExpression(Expression exp, Expression returnContinuation) {
        return (Expression)super.visitExpression(exp, exp);
    }

    public Expression[] visitExps(Expression[] exps) {
        int n = exps.length;
        for (int i = 0; i < n; ++i) {
            Expression expi = exps[i];
            exps[i] = (Expression)this.visit(expi, expi);
        }
        return exps;
    }

    @Override
    protected Expression visitApplyExp(ApplyExp exp, Expression returnContinuation) {
        boolean inTailContext;
        LambdaExp effectiveLambda = this.currentLambda;
        while (effectiveLambda.getFlag(16384)) {
            effectiveLambda = effectiveLambda.outerLambda();
        }
        boolean bl = inTailContext = returnContinuation == effectiveLambda;
        if (inTailContext) {
            exp.setTailCall(true);
        }
        exp.context = effectiveLambda;
        LambdaExp lexp = null;
        boolean isAppendValues = false;
        if (exp.func instanceof ReferenceExp) {
            ReferenceExp func = (ReferenceExp)exp.func;
            Declaration binding = Declaration.followAliases(func.binding);
            if (binding != null) {
                if (!binding.getFlag(2048L) && !binding.inExternalModule(this.comp)) {
                    binding.addCaller(exp);
                }
                Compilation comp = this.getCompilation();
                Expression value = binding.getValue();
                if (value instanceof LambdaExp) {
                    lexp = (LambdaExp)value;
                }
            }
        } else if (exp.func instanceof LambdaExp && !(exp.func instanceof ClassExp)) {
            lexp = (LambdaExp)exp.func;
            this.visitLambdaExp(lexp);
        } else if (exp.isAppendValues()) {
            isAppendValues = true;
        } else {
            exp.func = this.visitExpression(exp.func, exp.func);
        }
        if (!(lexp == null || lexp.returnContinuation == returnContinuation || lexp == effectiveLambda && inTailContext)) {
            if (inTailContext) {
                if (lexp.tailCallers == null) {
                    lexp.tailCallers = new LinkedHashSet<LambdaExp>();
                }
                lexp.tailCallers.add(effectiveLambda);
            } else if (lexp.returnContinuation == null && !effectiveLambda.nestedIn(lexp)) {
                lexp.returnContinuation = returnContinuation;
                lexp.inlineHome = this.currentLambda;
            } else {
                lexp.returnContinuation = LambdaExp.unknownContinuation;
                lexp.inlineHome = null;
            }
        }
        exp.args = this.visitExps(exp.args);
        return exp;
    }

    @Override
    protected Expression visitBlockExp(BlockExp exp, Expression returnContinuation) {
        if (this.savedReturnContinuations == null) {
            this.savedReturnContinuations = new HashMap();
        }
        this.savedReturnContinuations.put(exp, returnContinuation);
        exp.body = exp.body.visit(this, returnContinuation);
        if (exp.exitBody != null) {
            exp.exitBody = exp.exitBody.visit(this, returnContinuation);
        }
        return exp;
    }

    @Override
    protected Expression visitExitExp(ExitExp exp, Expression returnContinuation) {
        BlockExp bl = exp.block;
        Expression res = exp.result;
        ExitExp retCont = bl.exitBody != null ? exp : this.savedReturnContinuations.get(bl);
        exp.result = res.visit(this, retCont);
        return exp;
    }

    @Override
    protected Expression visitBeginExp(BeginExp exp, Expression returnContinuation) {
        int n = exp.length - 1;
        for (int i = 0; i <= n; ++i) {
            exp.exps[i] = exp.exps[i].visit(this, i == n ? returnContinuation : exp.exps[i]);
        }
        return exp;
    }

    @Override
    protected Expression visitFluidLetExp(FluidLetExp exp, Expression returnContinuation) {
        this.visitLetDecls(exp);
        exp.body = exp.body.visit(this, exp.body);
        this.postVisitDecls(exp);
        return exp;
    }

    void visitLetDecls(LetExp exp) {
        int i = 0;
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Expression value;
            Expression init = this.visitSetExp(decl, decl.getInitValue());
            if (init == QuoteExp.undefined_exp && ((value = decl.getValue()) instanceof LambdaExp || value != init && value instanceof QuoteExp)) {
                init = value;
            }
            decl.setInitValue(init);
            ++i;
        }
    }

    @Override
    protected Expression visitLetExp(LetExp exp, Expression returnContinuation) {
        exp.clearCallList();
        this.visitLetDecls(exp);
        exp.body = exp.body.visit(this, returnContinuation);
        this.postVisitDecls(exp);
        return exp;
    }

    public void postVisitDecls(ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            Declaration context;
            ReferenceExp rexp;
            Expression value = decl.getValue();
            if (!decl.getFlag(1024L) || !(value instanceof ReferenceExp) || (context = (rexp = (ReferenceExp)value).contextDecl()) == null || !context.isPrivate()) continue;
            context.setFlag(524288L);
        }
    }

    @Override
    protected Expression visitIfExp(IfExp exp, Expression returnContinuation) {
        exp.test = exp.test.visit(this, exp.test);
        exp.then_clause = exp.then_clause.visit(this, returnContinuation);
        Expression else_clause = exp.else_clause;
        if (else_clause != null) {
            exp.else_clause = else_clause.visit(this, returnContinuation);
        }
        return exp;
    }

    @Override
    protected Expression visitCaseExp(CaseExp exp, Expression returnContinuation) {
        exp.key = exp.key.visit(this, exp.key);
        for (int i = 0; i < exp.clauses.length; ++i) {
            exp.clauses[i].exp = exp.clauses[i].exp.visit(this, returnContinuation);
        }
        if (exp.elseClause != null) {
            exp.elseClause.exp = exp.elseClause.exp.visit(this, returnContinuation);
        }
        return exp;
    }

    @Override
    protected Expression visitLambdaExp(LambdaExp exp, Expression returnContinuation) {
        exp.clearCallList();
        this.visitLambdaExp(exp);
        return exp;
    }

    @Override
    public void visitDefaultArgs(LambdaExp exp, Expression d) {
        for (Declaration p = exp.firstDecl(); p != null; p = p.nextDecl()) {
            Expression init = p.getInitValue();
            if (init == null) continue;
            p.setInitValue(this.visitAndUpdate(init, init));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    final void visitLambdaExp(LambdaExp exp) {
        LambdaExp parent = this.currentLambda;
        this.currentLambda = exp;
        try {
            Expression bodyContinuation;
            this.visitDefaultArgs(exp, exp);
            if (exp.getInlineOnly()) {
                ApplyExp expContinuation;
                bodyContinuation = new QuoteExp(null);
                if (exp.returnContinuation instanceof ApplyExp && (expContinuation = (ApplyExp)exp.returnContinuation).isTailCall() && exp.getFlag(16384) && expContinuation.context != null) {
                    bodyContinuation = expContinuation.context;
                }
            } else {
                bodyContinuation = exp;
            }
            if (this.exitValue == null && exp.body != null) {
                exp.body = exp.body.visit(this, bodyContinuation);
            }
        }
        finally {
            this.currentLambda = parent;
        }
        this.postVisitDecls(exp);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Expression visitClassExp(ClassExp exp, Expression returnContinuation) {
        LambdaExp parent = this.currentLambda;
        this.currentLambda = exp;
        try {
            LambdaExp child = exp.firstChild;
            while (child != null && this.exitValue == null) {
                this.visitLambdaExp(child);
                child = child.nextSibling;
            }
        }
        finally {
            this.currentLambda = parent;
        }
        return exp;
    }

    final Expression visitSetExp(Declaration decl, Expression value) {
        if (decl != null && decl.getValue() == value && value instanceof LambdaExp && !(value instanceof ClassExp) && !decl.isPublic()) {
            LambdaExp lexp = (LambdaExp)value;
            this.visitLambdaExp(lexp);
            return lexp;
        }
        return value.visit(this, value);
    }

    @Override
    protected Expression visitSetExp(SetExp exp, Expression returnContinuation) {
        Declaration decl = exp.binding;
        if (decl != null && decl.isAlias()) {
            if (exp.isDefining()) {
                exp.new_value = exp.new_value.visit(this, exp.new_value);
                return exp;
            }
            decl = Declaration.followAliases(decl);
        }
        Expression value = this.visitSetExp(decl, exp.new_value);
        if (decl != null && decl.context instanceof LetExp && value == decl.getValue() && (value instanceof LambdaExp || value instanceof QuoteExp)) {
            return QuoteExp.voidExp;
        }
        exp.new_value = value;
        return exp;
    }

    @Override
    protected Expression visitTryExp(TryExp exp, Expression returnContinuation) {
        Expression tryContinuation = exp.finally_clause == null ? returnContinuation : exp.try_clause;
        exp.try_clause = exp.try_clause.visit(this, tryContinuation);
        for (CatchClause catch_clause = exp.catch_clauses; this.exitValue == null && catch_clause != null; catch_clause = catch_clause.getNext()) {
            Expression clauseContinuation = exp.finally_clause == null ? returnContinuation : catch_clause.body;
            catch_clause.body = catch_clause.body.visit(this, clauseContinuation);
        }
        Expression finally_clause = exp.finally_clause;
        if (finally_clause != null) {
            exp.finally_clause = finally_clause.visit(this, finally_clause);
        }
        return exp;
    }

    @Override
    protected Expression visitSynchronizedExp(SynchronizedExp exp, Expression returnContinuation) {
        exp.object = exp.object.visit(this, exp.object);
        exp.body = exp.body.visit(this, exp.body);
        return exp;
    }

    static boolean checkInlineCycle(LambdaExp from, LambdaExp to) {
        LambdaExp x = from;
        while (x != null) {
            if (x == to) {
                return true;
            }
            x = x.inlineHome;
        }
        return false;
    }

    static Expression checkInlineable(LambdaExp current, Set<LambdaExp> seen) {
        Expression r;
        r = current.returnContinuation;
        if (r == LambdaExp.unknownContinuation || seen.contains(current)) {
            return r;
        }
        if (current.getCanRead() || current.isClassMethod() || current.getFlag(32) || Compilation.avoidInline(current) || current.min_args != current.max_args) {
            current.returnContinuation = r = LambdaExp.unknownContinuation;
            return r;
        }
        seen.add(current);
        if (current.tailCallers != null) {
            for (LambdaExp p : current.tailCallers) {
                Expression t = FindTailCalls.checkInlineable(p, seen);
                if (t == LambdaExp.unknownContinuation) {
                    if (!(r != null && r != p || p.nestedIn(current))) {
                        r = p;
                        continue;
                    }
                    r = t;
                    break;
                }
                if (r == null) {
                    r = t;
                    continue;
                }
                if (t == null || r == t) continue;
                r = LambdaExp.unknownContinuation;
                break;
            }
        }
        if (r != LambdaExp.unknownContinuation) {
            if (current.inlineHome != null) {
                if (FindTailCalls.checkInlineCycle(current.inlineHome, current)) {
                    r = LambdaExp.unknownContinuation;
                }
            } else {
                LambdaExp x = null;
                if (current.returnContinuation instanceof ApplyExp) {
                    x = ((ApplyExp)current.returnContinuation).context;
                } else if (current.returnContinuation instanceof LambdaExp) {
                    x = (LambdaExp)current.returnContinuation;
                }
                if (x != null && !FindTailCalls.checkInlineCycle(x, current)) {
                    current.inlineHome = x;
                } else if (current.tailCallers != null) {
                    for (LambdaExp p : current.tailCallers) {
                        if (FindTailCalls.checkInlineCycle(p, current)) continue;
                        current.inlineHome = p;
                        break;
                    }
                } else {
                    r = LambdaExp.unknownContinuation;
                }
            }
        }
        if (r == LambdaExp.unknownContinuation) {
            current.returnContinuation = r;
            current.inlineHome = null;
        }
        return r;
    }

    static void checkInlineable(LambdaExp exp) {
        LinkedHashSet<LambdaExp> seen = new LinkedHashSet<LambdaExp>();
        Expression caller = FindTailCalls.checkInlineable(exp, seen);
        if (caller != LambdaExp.unknownContinuation) {
            LambdaExp outer;
            exp.setInlineOnly(true);
            if (exp.inlineHome == null && !FindTailCalls.checkInlineCycle(outer = exp.outerLambda(), exp)) {
                exp.inlineHome = outer;
            }
        }
        LambdaExp child = exp.firstChild;
        while (child != null) {
            FindTailCalls.checkInlineable(child);
            child = child.nextSibling;
        }
    }

    @Override
    protected Expression visitModuleExp(ModuleExp exp, Expression returnContinuation) {
        Expression ret = (Expression)super.visitModuleExp(exp, returnContinuation);
        FindTailCalls.checkInlineable(exp);
        return ret;
    }
}

