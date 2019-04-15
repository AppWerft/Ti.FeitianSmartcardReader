/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.BlockExp;
import gnu.expr.CanFinishMap;
import gnu.expr.CaseExp;
import gnu.expr.CatchClause;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExitExp;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.TryExp;
import java.util.HashSet;
import java.util.Set;

public class PushApply
extends ExpVisitor<Expression, Void> {
    CanFinishTracker canFinishTracker;

    public static void pushApply(Expression exp, Compilation comp) {
        PushApply visitor = new PushApply();
        visitor.setContext(comp);
        visitor.visit(exp, null);
    }

    @Override
    protected Expression update(Expression exp, Expression r) {
        return r;
    }

    @Override
    protected Expression defaultValue(Expression r, Void ignored) {
        return r;
    }

    @Override
    protected Expression visitApplyExp(ApplyExp exp, Void ignored) {
        boolean isApplyFunc;
        Declaration fdecl;
        Expression func = exp.func;
        boolean bl = isApplyFunc = this.getCompilation().isApplyFunction(func) && exp.getArgCount() > 0;
        if (isApplyFunc) {
            func = exp.getArg(0);
        }
        if (func instanceof ReferenceExp && (fdecl = ((ReferenceExp)func).getBinding()) != null && !fdecl.hasUnknownValue()) {
            Expression fval;
            if (!fdecl.inExternalModule(this.comp)) {
                fdecl.addCaller(exp);
            }
            if ((fval = Declaration.followAliases(fdecl).getValue()) != null && fval.getClass() == LambdaExp.class && !this.canFinishTracker.ignoreThisFork) {
                this.noteFinishDependency((LambdaExp)fval, this.currentLambda);
            }
        }
        if (func instanceof LetExp && !(func instanceof FluidLetExp)) {
            LetExp let2 = (LetExp)func;
            Expression body = let2.body;
            let2.body = exp;
            if (isApplyFunc) {
                exp.args[0] = body;
            } else {
                exp.func = body;
            }
            return (Expression)this.visit(let2, ignored);
        }
        if (func instanceof BeginExp) {
            BeginExp begin2 = (BeginExp)func;
            Expression[] stmts = begin2.exps;
            int last_index = begin2.exps.length - 1;
            if (isApplyFunc) {
                exp.args[0] = stmts[last_index];
            } else {
                exp.func = stmts[last_index];
            }
            stmts[last_index] = exp;
            return (Expression)this.visit(begin2, ignored);
        }
        exp.visitChildren(this, ignored);
        return exp;
    }

    void noteFinishDependency(LambdaExp callee, LambdaExp caller) {
        if (callee == caller || callee.body.type == Type.neverReturnsType) {
            this.canFinishTracker.dependencyAddedThisFork = true;
            caller.canFinishCondition = CanFinishMap.CANNOT_FINISH;
        } else if (caller.canFinishCondition != CanFinishMap.CAN_FINISH) {
            CanFinishMap deps = this.canFinishDeps();
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
    protected Expression visitIfExp(IfExp exp, Void ignored) {
        Expression test = exp.test;
        if (test instanceof LetExp && !(test instanceof FluidLetExp)) {
            LetExp let2 = (LetExp)test;
            Expression body = let2.body;
            let2.body = exp;
            exp.test = body;
            return (Expression)this.visit(let2, ignored);
        }
        if (test instanceof BeginExp) {
            BeginExp begin2 = (BeginExp)test;
            Expression[] stmts = begin2.exps;
            int last_index = begin2.exps.length - 1;
            exp.test = stmts[last_index];
            stmts[last_index] = exp;
            return (Expression)this.visit(begin2, ignored);
        }
        exp.test = (Expression)this.visit(exp.test, ignored);
        this.forkPush();
        this.canFinishTracker.associatedExpression = exp;
        exp.then_clause = (Expression)this.visit(exp.then_clause, ignored);
        this.forkNext();
        if (exp.else_clause != null) {
            exp.else_clause = (Expression)this.visit(exp.else_clause, ignored);
        }
        this.forkPop();
        return exp;
    }

    @Override
    protected Expression visitCaseExp(CaseExp exp, Void ignored) {
        Expression key = exp.key;
        if (key instanceof LetExp && !(key instanceof FluidLetExp)) {
            LetExp let2 = (LetExp)key;
            Expression body = let2.body;
            let2.body = exp;
            exp.key = body;
            return (Expression)this.visit(let2, ignored);
        }
        if (key instanceof BeginExp) {
            BeginExp begin2 = (BeginExp)key;
            Expression[] stmts = begin2.exps;
            int last_index = begin2.exps.length - 1;
            exp.key = stmts[last_index];
            stmts[last_index] = exp;
            return (Expression)this.visit(begin2, ignored);
        }
        exp.key = (Expression)this.visit(exp.key, ignored);
        this.forkPush();
        this.canFinishTracker.associatedExpression = exp;
        if (exp.clauses.length > 0) {
            exp.clauses[0].exp = (Expression)this.visit(exp.clauses[0].exp, ignored);
            for (int i = 1; i < exp.clauses.length; ++i) {
                this.forkNext();
                exp.clauses[i].exp = (Expression)this.visit(exp.clauses[i].exp, ignored);
            }
            if (exp.elseClause != null) {
                this.forkNext();
            }
        }
        if (exp.elseClause != null) {
            exp.elseClause.exp = (Expression)this.visit(exp.elseClause.exp, ignored);
        }
        this.forkPop();
        return exp;
    }

    @Override
    protected Expression visitTryExp(TryExp exp, Void ignored) {
        this.forkPush();
        this.canFinishTracker.associatedExpression = exp;
        exp.try_clause = (Expression)this.visit(exp.try_clause, ignored);
        for (CatchClause catch_clause = exp.catch_clauses; catch_clause != null; catch_clause = catch_clause.getNext()) {
            this.forkNext();
            this.visit(catch_clause, ignored);
        }
        this.forkPop();
        if (exp.finally_clause != null) {
            exp.finally_clause = (Expression)this.visit(exp.finally_clause, ignored);
        }
        return exp;
    }

    @Override
    protected Expression visitBlockExp(BlockExp exp, Void ignored) {
        this.forkPush();
        this.canFinishTracker.associatedExpression = exp;
        exp.body = (Expression)this.visit(exp.body, ignored);
        if (exp.exitBody != null) {
            this.forkNext();
            exp.exitBody = (Expression)this.visit(exp.exitBody, ignored);
        }
        this.forkPop();
        return exp;
    }

    @Override
    protected Expression visitExitExp(ExitExp exp, Void ignored) {
        exp.result = (Expression)this.visit(exp.result, ignored);
        CanFinishTracker tracker = this.canFinishTracker;
        BlockExp block = exp.block;
        while (tracker != null && tracker.associatedExpression != block) {
            tracker = tracker.outer;
        }
        CanFinishTracker saveTracker = this.canFinishTracker;
        this.canFinishTracker = tracker;
        this.forkNext();
        this.canFinishTracker = saveTracker;
        return exp;
    }

    @Override
    protected Expression visitReferenceExp(ReferenceExp exp, Void ignored) {
        Declaration decl = exp.getBinding();
        if (decl != null) {
            ++decl.numReferences;
            if (decl.context instanceof LetExp) {
                LambdaExp innerLambda;
                for (ScopeExp sc = innerLambda = this.getCurrentLambda(); sc != null; sc = sc.getOuter()) {
                    if (sc == decl.context) {
                        exp.siblingReferencesNext = innerLambda.siblingReferences;
                        innerLambda.siblingReferences = exp;
                        break;
                    }
                    if (!(sc instanceof LambdaExp)) continue;
                    innerLambda = sc;
                }
            }
        }
        return (Expression)super.visitReferenceExp(exp, ignored);
    }

    @Override
    protected Expression visitClassExp(ClassExp exp, Void ignored) {
        exp.declareParts(this.getCompilation());
        return this.visitLambdaExp((LambdaExp)exp, ignored);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Expression visitLambdaExp(LambdaExp exp, Void ignored) {
        CanFinishTracker oldTracker = this.canFinishTracker;
        CanFinishTracker newTracker = new CanFinishTracker();
        newTracker.outer = oldTracker;
        this.canFinishTracker = newTracker;
        this.canFinishTracker.associatedExpression = exp;
        newTracker.dependenciesAtForkStart = CanFinishMap.CAN_FINISH;
        LambdaExp saveLambda = this.currentLambda;
        exp.setFlag(true, 8192);
        this.currentLambda = exp;
        try {
            Expression expression = (Expression)super.visitLambdaExp(exp, ignored);
            return expression;
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

    private static CanFinishMap canFinishDeps(CanFinishTracker outer) {
        if (outer.dependenciesAtForkStart == null) {
            outer.dependenciesAtForkStart = PushApply.canFinishDeps(outer.outer).clone();
        }
        return outer.dependenciesAtForkStart;
    }

    CanFinishMap canFinishDeps() {
        if (this.currentLambda.canFinishCondition == null) {
            this.currentLambda.canFinishCondition = PushApply.canFinishDeps(this.canFinishTracker).clone();
        }
        return this.currentLambda.canFinishCondition;
    }

    public void forkPush() {
        LambdaExp curLambda = this.getCurrentLambda();
        CanFinishTracker oldTracker = this.canFinishTracker;
        CanFinishTracker newTracker = new CanFinishTracker();
        newTracker.dependenciesAtForkStart = curLambda.canFinishCondition;
        curLambda.canFinishCondition = null;
        newTracker.ignoreThisFork = false;
        newTracker.dependencyAddedThisFork = false;
        newTracker.outer = oldTracker;
        this.canFinishTracker = newTracker;
    }

    public void forkNext() {
        LambdaExp curLambda = this.getCurrentLambda();
        if (!this.canFinishTracker.dependencyAddedThisFork) {
            this.canFinishTracker.ignoreThisFork = true;
            this.canFinishTracker.dependenciesPreviousForks = null;
        } else {
            this.canFinishTracker.ignoreThisFork = false;
            this.canFinishTracker.dependencyAddedThisFork = false;
            if (this.canFinishTracker.dependenciesPreviousForks == null || this.canFinishTracker.dependenciesPreviousForks == CanFinishMap.CANNOT_FINISH) {
                this.canFinishTracker.dependenciesPreviousForks = curLambda.canFinishCondition;
            } else if (curLambda.canFinishCondition != CanFinishMap.CANNOT_FINISH) {
                this.canFinishTracker.dependenciesPreviousForks.addPaths(curLambda.canFinishCondition);
            }
            curLambda.canFinishCondition = null;
        }
    }

    public void forkPop() {
        CanFinishTracker oldTracker = this.canFinishTracker;
        this.forkNext();
        LambdaExp curLambda = this.currentLambda;
        curLambda.canFinishCondition = this.canFinishTracker.ignoreThisFork ? this.canFinishTracker.dependenciesAtForkStart : this.canFinishTracker.dependenciesPreviousForks;
        this.canFinishTracker = oldTracker.outer;
    }

    class CanFinishTracker {
        CanFinishTracker outer;
        boolean ignoreThisFork;
        boolean dependencyAddedThisFork;
        CanFinishMap dependenciesAtForkStart;
        CanFinishMap dependenciesPreviousForks;
        Expression associatedExpression;

        CanFinishTracker() {
        }
    }

}

