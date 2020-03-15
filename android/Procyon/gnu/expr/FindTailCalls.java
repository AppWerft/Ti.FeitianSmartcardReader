// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.util.Iterator;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashMap;

public class FindTailCalls extends ExpExpVisitor<Expression>
{
    public HashMap<Expression, Expression> savedReturnContinuations;
    
    public static void findTailCalls(final Expression exp, final Compilation comp) {
        final FindTailCalls visitor = new FindTailCalls();
        visitor.setContext(comp);
        ((ExpVisitor<Object, D>)visitor).visit(exp, (D)exp);
    }
    
    protected Expression visitExpression(final Expression exp, final Expression returnContinuation) {
        return super.visitExpression(exp, (D)exp);
    }
    
    public Expression[] visitExps(final Expression[] exps) {
        for (int n = exps.length, i = 0; i < n; ++i) {
            final Expression expi = exps[i];
            exps[i] = this.visit(expi, (D)expi);
        }
        return exps;
    }
    
    protected Expression visitApplyExp(final ApplyExp exp, final Expression returnContinuation) {
        LambdaExp effectiveLambda;
        for (effectiveLambda = this.currentLambda; effectiveLambda.getFlag(16384); effectiveLambda = effectiveLambda.outerLambda()) {}
        final boolean inTailContext = returnContinuation == effectiveLambda;
        if (inTailContext) {
            exp.setTailCall(true);
        }
        exp.context = effectiveLambda;
        LambdaExp lexp = null;
        boolean isAppendValues = false;
        if (exp.func instanceof ReferenceExp) {
            final ReferenceExp func = (ReferenceExp)exp.func;
            final Declaration binding = Declaration.followAliases(func.binding);
            if (binding != null) {
                if (!binding.getFlag(2048L) && !binding.inExternalModule(this.comp)) {
                    binding.addCaller(exp);
                }
                final Compilation comp = this.getCompilation();
                final Expression value = binding.getValue();
                if (value instanceof LambdaExp) {
                    lexp = (LambdaExp)value;
                }
            }
        }
        else if (exp.func instanceof LambdaExp && !(exp.func instanceof ClassExp)) {
            lexp = (LambdaExp)exp.func;
            this.visitLambdaExp(lexp);
        }
        else if (exp.isAppendValues()) {
            isAppendValues = true;
        }
        else {
            exp.func = this.visitExpression(exp.func, exp.func);
        }
        if (lexp != null) {
            if (lexp.returnContinuation != returnContinuation) {
                if (lexp != effectiveLambda || !inTailContext) {
                    if (inTailContext) {
                        if (lexp.tailCallers == null) {
                            lexp.tailCallers = new LinkedHashSet<LambdaExp>();
                        }
                        lexp.tailCallers.add(effectiveLambda);
                    }
                    else if (lexp.returnContinuation == null && !effectiveLambda.nestedIn(lexp)) {
                        lexp.returnContinuation = returnContinuation;
                        lexp.inlineHome = this.currentLambda;
                    }
                    else {
                        lexp.returnContinuation = LambdaExp.unknownContinuation;
                        lexp.inlineHome = null;
                    }
                }
            }
        }
        exp.args = this.visitExps(exp.args);
        return exp;
    }
    
    protected Expression visitBlockExp(final BlockExp exp, final Expression returnContinuation) {
        if (this.savedReturnContinuations == null) {
            this.savedReturnContinuations = new HashMap<Expression, Expression>();
        }
        this.savedReturnContinuations.put(exp, returnContinuation);
        exp.body = exp.body.visit((ExpVisitor<Expression, Expression>)this, returnContinuation);
        if (exp.exitBody != null) {
            exp.exitBody = exp.exitBody.visit((ExpVisitor<Expression, Expression>)this, returnContinuation);
        }
        return exp;
    }
    
    protected Expression visitExitExp(final ExitExp exp, final Expression returnContinuation) {
        final BlockExp bl = exp.block;
        final Expression res = exp.result;
        final Expression retCont = (bl.exitBody != null) ? exp : this.savedReturnContinuations.get(bl);
        exp.result = res.visit((ExpVisitor<Expression, Expression>)this, retCont);
        return exp;
    }
    
    protected Expression visitBeginExp(final BeginExp exp, final Expression returnContinuation) {
        for (int n = exp.length - 1, i = 0; i <= n; ++i) {
            exp.exps[i] = exp.exps[i].visit((ExpVisitor<Expression, Expression>)this, (i == n) ? returnContinuation : exp.exps[i]);
        }
        return exp;
    }
    
    protected Expression visitFluidLetExp(final FluidLetExp exp, final Expression returnContinuation) {
        this.visitLetDecls(exp);
        exp.body = exp.body.visit((ExpVisitor<Expression, Expression>)this, exp.body);
        this.postVisitDecls(exp);
        return exp;
    }
    
    void visitLetDecls(final LetExp exp) {
        Declaration decl = exp.firstDecl();
        int i = 0;
        while (decl != null) {
            Expression init = this.visitSetExp(decl, decl.getInitValue());
            if (init == QuoteExp.undefined_exp) {
                final Expression value = decl.getValue();
                if (value instanceof LambdaExp || (value != init && value instanceof QuoteExp)) {
                    init = value;
                }
            }
            decl.setInitValue(init);
            ++i;
            decl = decl.nextDecl();
        }
    }
    
    protected Expression visitLetExp(final LetExp exp, final Expression returnContinuation) {
        exp.clearCallList();
        this.visitLetDecls(exp);
        exp.body = exp.body.visit((ExpVisitor<Expression, Expression>)this, returnContinuation);
        this.postVisitDecls(exp);
        return exp;
    }
    
    public void postVisitDecls(final ScopeExp exp) {
        for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl()) {
            final Expression value = decl.getValue();
            if (decl.getFlag(1024L) && value instanceof ReferenceExp) {
                final ReferenceExp rexp = (ReferenceExp)value;
                final Declaration context = rexp.contextDecl();
                if (context != null && context.isPrivate()) {
                    context.setFlag(524288L);
                }
            }
        }
    }
    
    protected Expression visitIfExp(final IfExp exp, final Expression returnContinuation) {
        exp.test = exp.test.visit((ExpVisitor<Expression, Expression>)this, exp.test);
        exp.then_clause = exp.then_clause.visit((ExpVisitor<Expression, Expression>)this, returnContinuation);
        final Expression else_clause = exp.else_clause;
        if (else_clause != null) {
            exp.else_clause = else_clause.visit((ExpVisitor<Expression, Expression>)this, returnContinuation);
        }
        return exp;
    }
    
    protected Expression visitCaseExp(final CaseExp exp, final Expression returnContinuation) {
        exp.key = exp.key.visit((ExpVisitor<Expression, Expression>)this, exp.key);
        for (int i = 0; i < exp.clauses.length; ++i) {
            exp.clauses[i].exp = exp.clauses[i].exp.visit((ExpVisitor<Expression, Expression>)this, returnContinuation);
        }
        if (exp.elseClause != null) {
            exp.elseClause.exp = exp.elseClause.exp.visit((ExpVisitor<Expression, Expression>)this, returnContinuation);
        }
        return exp;
    }
    
    protected Expression visitLambdaExp(final LambdaExp exp, final Expression returnContinuation) {
        exp.clearCallList();
        this.visitLambdaExp(exp);
        return exp;
    }
    
    public void visitDefaultArgs(final LambdaExp exp, final Expression d) {
        for (Declaration p = exp.firstDecl(); p != null; p = p.nextDecl()) {
            final Expression init = p.getInitValue();
            if (init != null) {
                p.setInitValue(((ExpVisitor<R, D>)this).visitAndUpdate(init, (D)init));
            }
        }
    }
    
    final void visitLambdaExp(final LambdaExp exp) {
        final LambdaExp parent = this.currentLambda;
        this.currentLambda = exp;
        try {
            this.visitDefaultArgs(exp, exp);
            Expression bodyContinuation;
            if (exp.getInlineOnly()) {
                bodyContinuation = new QuoteExp((Object)null);
                if (exp.returnContinuation instanceof ApplyExp) {
                    final ApplyExp expContinuation = (ApplyExp)exp.returnContinuation;
                    if (expContinuation.isTailCall() && exp.getFlag(16384) && expContinuation.context != null) {
                        bodyContinuation = expContinuation.context;
                    }
                }
            }
            else {
                bodyContinuation = exp;
            }
            if (this.exitValue == null && exp.body != null) {
                exp.body = exp.body.visit((ExpVisitor<Expression, Expression>)this, bodyContinuation);
            }
        }
        finally {
            this.currentLambda = parent;
        }
        this.postVisitDecls(exp);
    }
    
    protected Expression visitClassExp(final ClassExp exp, final Expression returnContinuation) {
        final LambdaExp parent = this.currentLambda;
        this.currentLambda = exp;
        try {
            for (LambdaExp child = exp.firstChild; child != null && this.exitValue == null; child = child.nextSibling) {
                this.visitLambdaExp(child);
            }
        }
        finally {
            this.currentLambda = parent;
        }
        return exp;
    }
    
    final Expression visitSetExp(final Declaration decl, final Expression value) {
        if (decl != null && decl.getValue() == value && value instanceof LambdaExp && !(value instanceof ClassExp) && !decl.isPublic()) {
            final LambdaExp lexp = (LambdaExp)value;
            this.visitLambdaExp(lexp);
            return lexp;
        }
        return value.visit((ExpVisitor<Expression, Expression>)this, value);
    }
    
    protected Expression visitSetExp(final SetExp exp, final Expression returnContinuation) {
        Declaration decl = exp.binding;
        if (decl != null && decl.isAlias()) {
            if (exp.isDefining()) {
                exp.new_value = exp.new_value.visit((ExpVisitor<Expression, Expression>)this, exp.new_value);
                return exp;
            }
            decl = Declaration.followAliases(decl);
        }
        final Expression value = this.visitSetExp(decl, exp.new_value);
        if (decl != null && decl.context instanceof LetExp && value == decl.getValue() && (value instanceof LambdaExp || value instanceof QuoteExp)) {
            return QuoteExp.voidExp;
        }
        exp.new_value = value;
        return exp;
    }
    
    protected Expression visitTryExp(final TryExp exp, final Expression returnContinuation) {
        final Expression tryContinuation = (exp.finally_clause == null) ? returnContinuation : exp.try_clause;
        exp.try_clause = exp.try_clause.visit((ExpVisitor<Expression, Expression>)this, tryContinuation);
        for (CatchClause catch_clause = exp.catch_clauses; this.exitValue == null && catch_clause != null; catch_clause = catch_clause.getNext()) {
            final Expression clauseContinuation = (exp.finally_clause == null) ? returnContinuation : catch_clause.body;
            catch_clause.body = catch_clause.body.visit((ExpVisitor<Expression, Expression>)this, clauseContinuation);
        }
        final Expression finally_clause = exp.finally_clause;
        if (finally_clause != null) {
            exp.finally_clause = finally_clause.visit((ExpVisitor<Expression, Expression>)this, finally_clause);
        }
        return exp;
    }
    
    protected Expression visitSynchronizedExp(final SynchronizedExp exp, final Expression returnContinuation) {
        exp.object = exp.object.visit((ExpVisitor<Expression, Expression>)this, exp.object);
        exp.body = exp.body.visit((ExpVisitor<Expression, Expression>)this, exp.body);
        return exp;
    }
    
    static boolean checkInlineCycle(final LambdaExp from, final LambdaExp to) {
        for (LambdaExp x = from; x != null; x = x.inlineHome) {
            if (x == to) {
                return true;
            }
        }
        return false;
    }
    
    static Expression checkInlineable(final LambdaExp current, final Set<LambdaExp> seen) {
        Expression r = current.returnContinuation;
        if (r == LambdaExp.unknownContinuation || seen.contains(current)) {
            return r;
        }
        if (current.getCanRead() || current.isClassMethod() || current.getFlag(32) || Compilation.avoidInline(current) || current.min_args != current.max_args) {
            r = LambdaExp.unknownContinuation;
            return current.returnContinuation = r;
        }
        seen.add(current);
        if (current.tailCallers != null) {
            for (final LambdaExp p : current.tailCallers) {
                final Expression t = checkInlineable(p, seen);
                if (t == LambdaExp.unknownContinuation) {
                    if ((r != null && r != p) || p.nestedIn(current)) {
                        r = t;
                        break;
                    }
                    r = p;
                }
                else if (r == null) {
                    r = t;
                }
                else {
                    if (t != null && r != t) {
                        r = LambdaExp.unknownContinuation;
                        break;
                    }
                    continue;
                }
            }
        }
        if (r != LambdaExp.unknownContinuation) {
            if (current.inlineHome != null) {
                if (checkInlineCycle(current.inlineHome, current)) {
                    r = LambdaExp.unknownContinuation;
                }
            }
            else {
                LambdaExp x = null;
                if (current.returnContinuation instanceof ApplyExp) {
                    x = ((ApplyExp)current.returnContinuation).context;
                }
                else if (current.returnContinuation instanceof LambdaExp) {
                    x = (LambdaExp)current.returnContinuation;
                }
                if (x != null && !checkInlineCycle(x, current)) {
                    current.inlineHome = x;
                }
                else if (current.tailCallers != null) {
                    for (final LambdaExp p2 : current.tailCallers) {
                        if (!checkInlineCycle(p2, current)) {
                            current.inlineHome = p2;
                            break;
                        }
                    }
                }
                else {
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
    
    static void checkInlineable(final LambdaExp exp) {
        final Set<LambdaExp> seen = new LinkedHashSet<LambdaExp>();
        final Expression caller = checkInlineable(exp, seen);
        if (caller != LambdaExp.unknownContinuation) {
            exp.setInlineOnly(true);
            if (exp.inlineHome == null) {
                final LambdaExp outer = exp.outerLambda();
                if (!checkInlineCycle(outer, exp)) {
                    exp.inlineHome = outer;
                }
            }
        }
        for (LambdaExp child = exp.firstChild; child != null; child = child.nextSibling) {
            checkInlineable(child);
        }
    }
    
    protected Expression visitModuleExp(final ModuleExp exp, final Expression returnContinuation) {
        final Expression ret = super.visitModuleExp(exp, (D)returnContinuation);
        checkInlineable(exp);
        return ret;
    }
}
