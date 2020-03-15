// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.util.HashSet;
import gnu.bytecode.Type;

public class PushApply extends ExpVisitor<Expression, Void>
{
    CanFinishTracker canFinishTracker;
    
    public static void pushApply(final Expression exp, final Compilation comp) {
        final PushApply visitor = new PushApply();
        visitor.setContext(comp);
        ((ExpVisitor<Object, Void>)visitor).visit(exp, null);
    }
    
    @Override
    protected Expression update(final Expression exp, final Expression r) {
        return r;
    }
    
    @Override
    protected Expression defaultValue(final Expression r, final Void ignored) {
        return r;
    }
    
    @Override
    protected Expression visitApplyExp(final ApplyExp exp, final Void ignored) {
        Expression func = exp.func;
        final boolean isApplyFunc = this.getCompilation().isApplyFunction(func) && exp.getArgCount() > 0;
        if (isApplyFunc) {
            func = exp.getArg(0);
        }
        if (func instanceof ReferenceExp) {
            final Declaration fdecl = ((ReferenceExp)func).getBinding();
            if (fdecl != null && !fdecl.hasUnknownValue()) {
                if (!fdecl.inExternalModule(this.comp)) {
                    fdecl.addCaller(exp);
                }
                final Expression fval = Declaration.followAliases(fdecl).getValue();
                if (fval != null && fval.getClass() == LambdaExp.class && !this.canFinishTracker.ignoreThisFork) {
                    this.noteFinishDependency((LambdaExp)fval, this.currentLambda);
                }
            }
        }
        if (func instanceof LetExp && !(func instanceof FluidLetExp)) {
            final LetExp let = (LetExp)func;
            final Expression body = let.body;
            let.body = exp;
            if (isApplyFunc) {
                exp.args[0] = body;
            }
            else {
                exp.func = body;
            }
            return this.visit(let, ignored);
        }
        if (func instanceof BeginExp) {
            final BeginExp begin = (BeginExp)func;
            final Expression[] stmts = begin.exps;
            final int last_index = begin.exps.length - 1;
            if (isApplyFunc) {
                exp.args[0] = stmts[last_index];
            }
            else {
                exp.func = stmts[last_index];
            }
            stmts[last_index] = exp;
            return this.visit(begin, ignored);
        }
        exp.visitChildren((ExpVisitor<Object, Void>)this, ignored);
        return exp;
    }
    
    void noteFinishDependency(final LambdaExp callee, final LambdaExp caller) {
        if (callee == caller || callee.body.type == Type.neverReturnsType) {
            this.canFinishTracker.dependencyAddedThisFork = true;
            caller.canFinishCondition = CanFinishMap.CANNOT_FINISH;
        }
        else if (caller.canFinishCondition != CanFinishMap.CAN_FINISH) {
            final CanFinishMap deps = this.canFinishDeps();
            if (deps != CanFinishMap.CANNOT_FINISH && deps.addDependency(callee)) {
                this.canFinishTracker.dependencyAddedThisFork = true;
            }
            if (callee.canFinishListeners == null) {
                callee.canFinishListeners = new HashSet<LambdaExp>();
            }
            callee.canFinishListeners.add(caller);
        }
    }
    
    @Override
    protected Expression visitIfExp(final IfExp exp, final Void ignored) {
        final Expression test = exp.test;
        if (test instanceof LetExp && !(test instanceof FluidLetExp)) {
            final LetExp let = (LetExp)test;
            final Expression body = let.body;
            let.body = exp;
            exp.test = body;
            return this.visit(let, ignored);
        }
        if (test instanceof BeginExp) {
            final BeginExp begin = (BeginExp)test;
            final Expression[] stmts = begin.exps;
            final int last_index = begin.exps.length - 1;
            exp.test = stmts[last_index];
            stmts[last_index] = exp;
            return this.visit(begin, ignored);
        }
        exp.test = this.visit(exp.test, ignored);
        this.forkPush();
        this.canFinishTracker.associatedExpression = exp;
        exp.then_clause = this.visit(exp.then_clause, ignored);
        this.forkNext();
        if (exp.else_clause != null) {
            exp.else_clause = this.visit(exp.else_clause, ignored);
        }
        this.forkPop();
        return exp;
    }
    
    @Override
    protected Expression visitCaseExp(final CaseExp exp, final Void ignored) {
        final Expression key = exp.key;
        if (key instanceof LetExp && !(key instanceof FluidLetExp)) {
            final LetExp let = (LetExp)key;
            final Expression body = let.body;
            let.body = exp;
            exp.key = body;
            return this.visit(let, ignored);
        }
        if (key instanceof BeginExp) {
            final BeginExp begin = (BeginExp)key;
            final Expression[] stmts = begin.exps;
            final int last_index = begin.exps.length - 1;
            exp.key = stmts[last_index];
            stmts[last_index] = exp;
            return this.visit(begin, ignored);
        }
        exp.key = this.visit(exp.key, ignored);
        this.forkPush();
        this.canFinishTracker.associatedExpression = exp;
        if (exp.clauses.length > 0) {
            exp.clauses[0].exp = this.visit(exp.clauses[0].exp, ignored);
            for (int i = 1; i < exp.clauses.length; ++i) {
                this.forkNext();
                exp.clauses[i].exp = this.visit(exp.clauses[i].exp, ignored);
            }
            if (exp.elseClause != null) {
                this.forkNext();
            }
        }
        if (exp.elseClause != null) {
            exp.elseClause.exp = this.visit(exp.elseClause.exp, ignored);
        }
        this.forkPop();
        return exp;
    }
    
    @Override
    protected Expression visitTryExp(final TryExp exp, final Void ignored) {
        this.forkPush();
        this.canFinishTracker.associatedExpression = exp;
        exp.try_clause = this.visit(exp.try_clause, ignored);
        for (CatchClause catch_clause = exp.catch_clauses; catch_clause != null; catch_clause = catch_clause.getNext()) {
            this.forkNext();
            ((ExpVisitor<Object, Void>)this).visit(catch_clause, ignored);
        }
        this.forkPop();
        if (exp.finally_clause != null) {
            exp.finally_clause = this.visit(exp.finally_clause, ignored);
        }
        return exp;
    }
    
    @Override
    protected Expression visitBlockExp(final BlockExp exp, final Void ignored) {
        this.forkPush();
        this.canFinishTracker.associatedExpression = exp;
        exp.body = this.visit(exp.body, ignored);
        if (exp.exitBody != null) {
            this.forkNext();
            exp.exitBody = this.visit(exp.exitBody, ignored);
        }
        this.forkPop();
        return exp;
    }
    
    @Override
    protected Expression visitExitExp(final ExitExp exp, final Void ignored) {
        exp.result = this.visit(exp.result, ignored);
        CanFinishTracker tracker = this.canFinishTracker;
        for (BlockExp block = exp.block; tracker != null && tracker.associatedExpression != block; tracker = tracker.outer) {}
        final CanFinishTracker saveTracker = this.canFinishTracker;
        this.canFinishTracker = tracker;
        this.forkNext();
        this.canFinishTracker = saveTracker;
        return exp;
    }
    
    @Override
    protected Expression visitReferenceExp(final ReferenceExp exp, final Void ignored) {
        final Declaration decl = exp.getBinding();
        if (decl != null) {
            final Declaration declaration = decl;
            ++declaration.numReferences;
            if (decl.context instanceof LetExp) {
                ScopeExp sc;
                for (LambdaExp innerLambda = (LambdaExp)(sc = this.getCurrentLambda()); sc != null; sc = sc.getOuter()) {
                    if (sc == decl.context) {
                        exp.siblingReferencesNext = innerLambda.siblingReferences;
                        innerLambda.siblingReferences = exp;
                        break;
                    }
                    if (sc instanceof LambdaExp) {
                        innerLambda = (LambdaExp)sc;
                    }
                }
            }
        }
        return super.visitReferenceExp(exp, ignored);
    }
    
    @Override
    protected Expression visitClassExp(final ClassExp exp, final Void ignored) {
        exp.declareParts(this.getCompilation());
        return this.visitLambdaExp(exp, ignored);
    }
    
    @Override
    protected Expression visitLambdaExp(final LambdaExp exp, final Void ignored) {
        final CanFinishTracker oldTracker = this.canFinishTracker;
        final CanFinishTracker newTracker = new CanFinishTracker();
        newTracker.outer = oldTracker;
        this.canFinishTracker = newTracker;
        this.canFinishTracker.associatedExpression = exp;
        newTracker.dependenciesAtForkStart = CanFinishMap.CAN_FINISH;
        final LambdaExp saveLambda = this.currentLambda;
        exp.setFlag(true, 8192);
        this.currentLambda = exp;
        try {
            return super.visitLambdaExp(exp, ignored);
        }
        finally {
            exp.setFlag(false, 8192);
            if (exp.canFinishCondition == null) {
                exp.canFinishCondition = CanFinishMap.CAN_FINISH;
            }
            exp.checkCanFinish();
            this.currentLambda = saveLambda;
            this.canFinishTracker = oldTracker;
        }
    }
    
    private static CanFinishMap canFinishDeps(final CanFinishTracker outer) {
        if (outer.dependenciesAtForkStart == null) {
            outer.dependenciesAtForkStart = canFinishDeps(outer.outer).clone();
        }
        return outer.dependenciesAtForkStart;
    }
    
    CanFinishMap canFinishDeps() {
        if (this.currentLambda.canFinishCondition == null) {
            this.currentLambda.canFinishCondition = canFinishDeps(this.canFinishTracker).clone();
        }
        return this.currentLambda.canFinishCondition;
    }
    
    public void forkPush() {
        final LambdaExp curLambda = this.getCurrentLambda();
        final CanFinishTracker oldTracker = this.canFinishTracker;
        final CanFinishTracker newTracker = new CanFinishTracker();
        newTracker.dependenciesAtForkStart = curLambda.canFinishCondition;
        curLambda.canFinishCondition = null;
        newTracker.ignoreThisFork = false;
        newTracker.dependencyAddedThisFork = false;
        newTracker.outer = oldTracker;
        this.canFinishTracker = newTracker;
    }
    
    public void forkNext() {
        final LambdaExp curLambda = this.getCurrentLambda();
        if (!this.canFinishTracker.dependencyAddedThisFork) {
            this.canFinishTracker.ignoreThisFork = true;
            this.canFinishTracker.dependenciesPreviousForks = null;
        }
        else {
            this.canFinishTracker.ignoreThisFork = false;
            this.canFinishTracker.dependencyAddedThisFork = false;
            if (this.canFinishTracker.dependenciesPreviousForks == null || this.canFinishTracker.dependenciesPreviousForks == CanFinishMap.CANNOT_FINISH) {
                this.canFinishTracker.dependenciesPreviousForks = curLambda.canFinishCondition;
            }
            else if (curLambda.canFinishCondition != CanFinishMap.CANNOT_FINISH) {
                this.canFinishTracker.dependenciesPreviousForks.addPaths(curLambda.canFinishCondition);
            }
            curLambda.canFinishCondition = null;
        }
    }
    
    public void forkPop() {
        final CanFinishTracker oldTracker = this.canFinishTracker;
        this.forkNext();
        final LambdaExp curLambda = this.currentLambda;
        if (this.canFinishTracker.ignoreThisFork) {
            curLambda.canFinishCondition = this.canFinishTracker.dependenciesAtForkStart;
        }
        else {
            curLambda.canFinishCondition = this.canFinishTracker.dependenciesPreviousForks;
        }
        this.canFinishTracker = oldTracker.outer;
    }
    
    class CanFinishTracker
    {
        CanFinishTracker outer;
        boolean ignoreThisFork;
        boolean dependencyAddedThisFork;
        CanFinishMap dependenciesAtForkStart;
        CanFinishMap dependenciesPreviousForks;
        Expression associatedExpression;
    }
}
