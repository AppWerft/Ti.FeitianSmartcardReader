package gnu.expr;

import gnu.bytecode.Type;
import java.util.HashSet;
import java.util.Set;












public class PushApply
  extends ExpVisitor<Expression, Void>
{
  CanFinishTracker canFinishTracker;
  
  public PushApply() {}
  
  public static void pushApply(Expression exp, Compilation comp)
  {
    PushApply visitor = new PushApply();
    visitor.setContext(comp);
    visitor.visit(exp, null);
  }
  
  protected Expression update(Expression exp, Expression r)
  {
    return r;
  }
  
  protected Expression defaultValue(Expression r, Void ignored)
  {
    return r;
  }
  
  protected Expression visitApplyExp(ApplyExp exp, Void ignored) {
    Expression func = func;
    boolean isApplyFunc = (getCompilation().isApplyFunction(func)) && (exp.getArgCount() > 0);
    
    if (isApplyFunc) {
      func = exp.getArg(0);
    }
    if ((func instanceof ReferenceExp)) {
      Declaration fdecl = ((ReferenceExp)func).getBinding();
      if ((fdecl != null) && (!fdecl.hasUnknownValue())) {
        if (!fdecl.inExternalModule(comp))
          fdecl.addCaller(exp);
        Expression fval = Declaration.followAliases(fdecl).getValue();
        if ((fval != null) && (fval.getClass() == LambdaExp.class) && (!canFinishTracker.ignoreThisFork))
        {
          noteFinishDependency((LambdaExp)fval, currentLambda);
        }
      }
    }
    if (((func instanceof LetExp)) && (!(func instanceof FluidLetExp)))
    {



      LetExp let = (LetExp)func;
      Expression body = body;
      body = exp;
      if (isApplyFunc) {
        args[0] = body;
      } else
        func = body;
      return (Expression)visit(let, ignored);
    }
    if ((func instanceof BeginExp))
    {


      BeginExp begin = (BeginExp)func;
      Expression[] stmts = exps;
      int last_index = exps.length - 1;
      if (isApplyFunc) {
        args[0] = stmts[last_index];
      } else
        func = stmts[last_index];
      stmts[last_index] = exp;
      return (Expression)visit(begin, ignored);
    }
    exp.visitChildren(this, ignored);
    return exp;
  }
  
  void noteFinishDependency(LambdaExp callee, LambdaExp caller) {
    if ((callee == caller) || (body.type == Type.neverReturnsType)) {
      canFinishTracker.dependencyAddedThisFork = true;
      canFinishCondition = CanFinishMap.CANNOT_FINISH;
    } else if (canFinishCondition != CanFinishMap.CAN_FINISH) {
      CanFinishMap deps = canFinishDeps();
      if ((deps != CanFinishMap.CANNOT_FINISH) && (deps.addDependency(callee)))
      {
        canFinishTracker.dependencyAddedThisFork = true; }
      if (canFinishListeners == null)
        canFinishListeners = new HashSet();
      canFinishListeners.add(caller);
    }
  }
  
  protected Expression visitIfExp(IfExp exp, Void ignored) { Expression test = test;
    if (((test instanceof LetExp)) && (!(test instanceof FluidLetExp)))
    {


      LetExp let = (LetExp)test;
      Expression body = body;
      body = exp;
      test = body;
      return (Expression)visit(let, ignored);
    }
    if ((test instanceof BeginExp))
    {

      BeginExp begin = (BeginExp)test;
      Expression[] stmts = exps;
      int last_index = exps.length - 1;
      test = stmts[last_index];
      stmts[last_index] = exp;
      return (Expression)visit(begin, ignored);
    }
    
    test = ((Expression)visit(test, ignored));
    forkPush();
    canFinishTracker.associatedExpression = exp;
    then_clause = ((Expression)visit(then_clause, ignored));
    forkNext();
    if (else_clause != null)
      else_clause = ((Expression)visit(else_clause, ignored));
    forkPop();
    return exp;
  }
  
  protected Expression visitCaseExp(CaseExp exp, Void ignored)
  {
    Expression key = key;
    if (((key instanceof LetExp)) && (!(key instanceof FluidLetExp)))
    {


      LetExp let = (LetExp)key;
      Expression body = body;
      body = exp;
      key = body;
      return (Expression)visit(let, ignored); }
    if ((key instanceof BeginExp))
    {


      BeginExp begin = (BeginExp)key;
      Expression[] stmts = exps;
      int last_index = exps.length - 1;
      key = stmts[last_index];
      stmts[last_index] = exp;
      return (Expression)visit(begin, ignored);
    }
    key = ((Expression)visit(key, ignored));
    forkPush();
    canFinishTracker.associatedExpression = exp;
    if (clauses.length > 0) {
      clauses[0].exp = ((Expression)visit(clauses[0].exp, ignored));
      for (int i = 1; i < clauses.length; i++) {
        forkNext();
        clauses[i].exp = ((Expression)visit(clauses[i].exp, ignored));
      }
      if (elseClause != null)
        forkNext();
    }
    if (elseClause != null)
      elseClause.exp = ((Expression)visit(elseClause.exp, ignored));
    forkPop();
    return exp;
  }
  

  protected Expression visitTryExp(TryExp exp, Void ignored)
  {
    forkPush();
    canFinishTracker.associatedExpression = exp;
    try_clause = ((Expression)visit(try_clause, ignored));
    CatchClause catch_clause = catch_clauses;
    while (catch_clause != null) {
      forkNext();
      visit(catch_clause, ignored);
      catch_clause = catch_clause.getNext();
    }
    forkPop();
    
    if (finally_clause != null)
      finally_clause = ((Expression)visit(finally_clause, ignored));
    return exp;
  }
  
  protected Expression visitBlockExp(BlockExp exp, Void ignored)
  {
    forkPush();
    canFinishTracker.associatedExpression = exp;
    body = ((Expression)visit(body, ignored));
    if (exitBody != null) {
      forkNext();
      exitBody = ((Expression)visit(exitBody, ignored));
    }
    forkPop();
    return exp;
  }
  
  protected Expression visitExitExp(ExitExp exp, Void ignored)
  {
    result = ((Expression)visit(result, ignored));
    CanFinishTracker tracker = canFinishTracker;
    BlockExp block = block;
    while ((tracker != null) && (associatedExpression != block))
      tracker = outer;
    CanFinishTracker saveTracker = canFinishTracker;
    canFinishTracker = tracker;
    forkNext();
    canFinishTracker = saveTracker;
    return exp;
  }
  
  protected Expression visitReferenceExp(ReferenceExp exp, Void ignored)
  {
    Declaration decl = exp.getBinding();
    if (decl != null)
    {
      numReferences += 1;
      

      if ((context instanceof LetExp))
      {
        LambdaExp innerLambda = getCurrentLambda();
        for (ScopeExp sc = innerLambda; sc != null; sc = sc.getOuter())
        {
          if (sc == context)
          {

            siblingReferencesNext = siblingReferences;
            siblingReferences = exp;
            break;
          }
          if ((sc instanceof LambdaExp))
            innerLambda = (LambdaExp)sc;
        }
      }
    }
    return (Expression)super.visitReferenceExp(exp, ignored);
  }
  



  protected Expression visitClassExp(ClassExp exp, Void ignored)
  {
    exp.declareParts(getCompilation());
    return visitLambdaExp(exp, ignored);
  }
  
  protected Expression visitLambdaExp(LambdaExp exp, Void ignored) {
    CanFinishTracker oldTracker = canFinishTracker;
    CanFinishTracker newTracker = new CanFinishTracker();
    outer = oldTracker;
    canFinishTracker = newTracker;
    canFinishTracker.associatedExpression = exp;
    dependenciesAtForkStart = CanFinishMap.CAN_FINISH;
    LambdaExp saveLambda = currentLambda;
    exp.setFlag(true, 8192);
    currentLambda = exp;
    try {
      return (Expression)super.visitLambdaExp(exp, ignored);
    }
    finally {
      exp.setFlag(false, 8192);
      
      if (canFinishCondition == null)
        canFinishCondition = CanFinishMap.CAN_FINISH;
      exp.checkCanFinish();
      currentLambda = saveLambda;
      canFinishTracker = oldTracker;
    }
  }
  
















  private static CanFinishMap canFinishDeps(CanFinishTracker outer)
  {
    if (dependenciesAtForkStart == null)
      dependenciesAtForkStart = canFinishDeps(outer.outer).clone();
    return dependenciesAtForkStart;
  }
  
  CanFinishMap canFinishDeps() {
    if (currentLambda.canFinishCondition == null)
      currentLambda.canFinishCondition = canFinishDeps(canFinishTracker).clone();
    return currentLambda.canFinishCondition;
  }
  
  public void forkPush() {
    LambdaExp curLambda = getCurrentLambda();
    CanFinishTracker oldTracker = canFinishTracker;
    CanFinishTracker newTracker = new CanFinishTracker();
    dependenciesAtForkStart = canFinishCondition;
    canFinishCondition = null;
    ignoreThisFork = false;
    dependencyAddedThisFork = false;
    outer = oldTracker;
    canFinishTracker = newTracker;
  }
  
  public void forkNext() {
    LambdaExp curLambda = getCurrentLambda();
    if (!canFinishTracker.dependencyAddedThisFork) {
      canFinishTracker.ignoreThisFork = true;
      canFinishTracker.dependenciesPreviousForks = null;
    } else {
      canFinishTracker.ignoreThisFork = false;
      canFinishTracker.dependencyAddedThisFork = false;
      if ((canFinishTracker.dependenciesPreviousForks == null) || (canFinishTracker.dependenciesPreviousForks == CanFinishMap.CANNOT_FINISH))
      {
        canFinishTracker.dependenciesPreviousForks = canFinishCondition;
      } else if (canFinishCondition != CanFinishMap.CANNOT_FINISH) {
        canFinishTracker.dependenciesPreviousForks.addPaths(canFinishCondition);
      }
      canFinishCondition = null;
    }
  }
  
  public void forkPop() {
    CanFinishTracker oldTracker = canFinishTracker;
    forkNext();
    LambdaExp curLambda = currentLambda;
    if (canFinishTracker.ignoreThisFork) {
      canFinishCondition = canFinishTracker.dependenciesAtForkStart;
    } else
      canFinishCondition = canFinishTracker.dependenciesPreviousForks;
    canFinishTracker = outer;
  }
  
  class CanFinishTracker
  {
    CanFinishTracker outer;
    boolean ignoreThisFork;
    boolean dependencyAddedThisFork;
    CanFinishMap dependenciesAtForkStart;
    CanFinishMap dependenciesPreviousForks;
    Expression associatedExpression;
    
    CanFinishTracker() {}
  }
}
