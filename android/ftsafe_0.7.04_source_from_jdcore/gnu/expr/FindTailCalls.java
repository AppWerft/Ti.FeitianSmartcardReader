package gnu.expr;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;






















































public class FindTailCalls
  extends ExpExpVisitor<Expression>
{
  public HashMap<Expression, Expression> savedReturnContinuations;
  
  public FindTailCalls() {}
  
  public static void findTailCalls(Expression exp, Compilation comp)
  {
    FindTailCalls visitor = new FindTailCalls();
    visitor.setContext(comp);
    visitor.visit(exp, exp);
  }
  


  protected Expression visitExpression(Expression exp, Expression returnContinuation)
  {
    return (Expression)super.visitExpression(exp, exp);
  }
  
  public Expression[] visitExps(Expression[] exps)
  {
    int n = exps.length;
    for (int i = 0; i < n; i++)
    {
      Expression expi = exps[i];
      exps[i] = ((Expression)visit(expi, expi));
    }
    return exps;
  }
  
  protected Expression visitApplyExp(ApplyExp exp, Expression returnContinuation)
  {
    LambdaExp effectiveLambda = currentLambda;
    while (effectiveLambda.getFlag(16384))
      effectiveLambda = effectiveLambda.outerLambda();
    boolean inTailContext = returnContinuation == effectiveLambda;
    if (inTailContext)
      exp.setTailCall(true);
    context = effectiveLambda;
    LambdaExp lexp = null;
    boolean isAppendValues = false;
    if ((func instanceof ReferenceExp))
    {
      ReferenceExp func = (ReferenceExp)func;
      Declaration binding = Declaration.followAliases(binding);
      if (binding != null)
      {



        if ((!binding.getFlag(2048L)) && (!binding.inExternalModule(this.comp)))
        {

          binding.addCaller(exp);
        }
        Compilation comp = getCompilation();
        Expression value = binding.getValue();
        if ((value instanceof LambdaExp)) {
          lexp = (LambdaExp)value;
        }
      }
    } else if (((func instanceof LambdaExp)) && (!(func instanceof ClassExp)))
    {

      lexp = (LambdaExp)func;
      visitLambdaExp(lexp);
    }
    else if (exp.isAppendValues()) {
      isAppendValues = true;
    }
    else {
      func = visitExpression(func, func);
    }
    if (lexp != null)
    {
      if ((returnContinuation != returnContinuation) && (
        (lexp != effectiveLambda) || (!inTailContext)))
      {
        if (inTailContext)
        {

          if (tailCallers == null)
            tailCallers = new LinkedHashSet();
          tailCallers.add(effectiveLambda);
        }
        else if ((returnContinuation == null) && (!effectiveLambda.nestedIn(lexp)))
        {

          returnContinuation = returnContinuation;
          inlineHome = currentLambda;
        }
        else
        {
          returnContinuation = LambdaExp.unknownContinuation;
          inlineHome = null;
        }
      }
    }
    











    args = visitExps(args);
    return exp;
  }
  
  protected Expression visitBlockExp(BlockExp exp, Expression returnContinuation) {
    if (savedReturnContinuations == null)
      savedReturnContinuations = new HashMap();
    savedReturnContinuations.put(exp, returnContinuation);
    body = ((Expression)body.visit(this, returnContinuation));
    if (exitBody != null)
      exitBody = ((Expression)exitBody.visit(this, returnContinuation));
    return exp;
  }
  
  protected Expression visitExitExp(ExitExp exp, Expression returnContinuation) { BlockExp bl = block;
    Expression res = result;
    Expression retCont = exitBody != null ? exp : (Expression)savedReturnContinuations.get(bl);
    
    result = ((Expression)res.visit(this, retCont));
    return exp;
  }
  
  protected Expression visitBeginExp(BeginExp exp, Expression returnContinuation)
  {
    int n = length - 1;
    for (int i = 0; i <= n; i++)
      exps[i] = ((Expression)exps[i].visit(this, i == n ? returnContinuation : exps[i]));
    return exp;
  }
  
  protected Expression visitFluidLetExp(FluidLetExp exp, Expression returnContinuation)
  {
    visitLetDecls(exp);
    body = ((Expression)body.visit(this, body));
    postVisitDecls(exp);
    return exp;
  }
  
  void visitLetDecls(LetExp exp)
  {
    Declaration decl = exp.firstDecl();
    for (int i = 0; decl != null; decl = decl.nextDecl())
    {
      Expression init = visitSetExp(decl, decl.getInitValue());
      
      if (init == QuoteExp.undefined_exp)
      {
        Expression value = decl.getValue();
        if (((value instanceof LambdaExp)) || ((value != init) && ((value instanceof QuoteExp))))
        {
          init = value; }
      }
      decl.setInitValue(init);i++;
    }
  }
  
  protected Expression visitLetExp(LetExp exp, Expression returnContinuation)
  {
    exp.clearCallList();
    visitLetDecls(exp);
    body = ((Expression)body.visit(this, returnContinuation));
    postVisitDecls(exp);
    return exp;
  }
  
  public void postVisitDecls(ScopeExp exp)
  {
    for (Declaration decl = exp.firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      Expression value = decl.getValue();
      if ((decl.getFlag(1024L)) && ((value instanceof ReferenceExp)))
      {

        ReferenceExp rexp = (ReferenceExp)value;
        Declaration context = rexp.contextDecl();
        if ((context != null) && (context.isPrivate())) {
          context.setFlag(524288L);
        }
      }
    }
  }
  
  protected Expression visitIfExp(IfExp exp, Expression returnContinuation) {
    test = ((Expression)test.visit(this, test));
    then_clause = ((Expression)then_clause.visit(this, returnContinuation));
    Expression else_clause = else_clause;
    if (else_clause != null)
      else_clause = ((Expression)else_clause.visit(this, returnContinuation));
    return exp;
  }
  
  protected Expression visitCaseExp(CaseExp exp, Expression returnContinuation) {
    key = ((Expression)key.visit(this, key));
    for (int i = 0; i < clauses.length; i++) {
      clauses[i].exp = ((Expression)clauses[i].exp.visit(this, returnContinuation));
    }
    
    if (elseClause != null) {
      elseClause.exp = ((Expression)elseClause.exp.visit(this, returnContinuation));
    }
    return exp;
  }
  
  protected Expression visitLambdaExp(LambdaExp exp, Expression returnContinuation)
  {
    exp.clearCallList();
    visitLambdaExp(exp);
    return exp;
  }
  
  public void visitDefaultArgs(LambdaExp exp, Expression d)
  {
    for (Declaration p = exp.firstDecl(); p != null; p = p.nextDecl()) {
      Expression init = p.getInitValue();
      if (init != null) {
        p.setInitValue(visitAndUpdate(init, init));
      }
    }
  }
  
  final void visitLambdaExp(LambdaExp exp) {
    LambdaExp parent = currentLambda;
    currentLambda = exp;
    try
    {
      visitDefaultArgs(exp, exp);
      
      Expression bodyContinuation;
      if (exp.getInlineOnly()) {
        Expression bodyContinuation = new QuoteExp(null);
        if ((returnContinuation instanceof ApplyExp)) {
          ApplyExp expContinuation = (ApplyExp)returnContinuation;
          if ((expContinuation.isTailCall()) && (exp.getFlag(16384)) && (context != null))
          {

            bodyContinuation = context;
          }
        }
      } else {
        bodyContinuation = exp;
      }
      if ((exitValue == null) && (body != null)) {
        body = ((Expression)body.visit(this, bodyContinuation));
      }
    }
    finally {
      currentLambda = parent;
    }
    
    postVisitDecls(exp);
  }
  





  protected Expression visitClassExp(ClassExp exp, Expression returnContinuation)
  {
    LambdaExp parent = currentLambda;
    currentLambda = exp;
    try
    {
      for (LambdaExp child = firstChild; 
          (child != null) && (exitValue == null); child = nextSibling) {
        visitLambdaExp(child);
      }
    }
    finally {
      currentLambda = parent;
    }
    
    return exp;
  }
  
  final Expression visitSetExp(Declaration decl, Expression value)
  {
    if ((decl != null) && (decl.getValue() == value) && ((value instanceof LambdaExp)) && (!(value instanceof ClassExp)) && (!decl.isPublic()))
    {


      LambdaExp lexp = (LambdaExp)value;
      visitLambdaExp(lexp);
      return lexp;
    }
    
    return (Expression)value.visit(this, value);
  }
  
  protected Expression visitSetExp(SetExp exp, Expression returnContinuation)
  {
    Declaration decl = binding;
    if ((decl != null) && (decl.isAlias()))
    {
      if (exp.isDefining())
      {
        new_value = ((Expression)new_value.visit(this, new_value));
        return exp;
      }
      decl = Declaration.followAliases(decl);
    }
    Expression value = visitSetExp(decl, new_value);
    if ((decl != null) && ((context instanceof LetExp)) && (value == decl.getValue()) && (((value instanceof LambdaExp)) || ((value instanceof QuoteExp))))
    {




      return QuoteExp.voidExp;
    }
    new_value = value;
    return exp;
  }
  
  protected Expression visitTryExp(TryExp exp, Expression returnContinuation)
  {
    Expression tryContinuation = finally_clause == null ? returnContinuation : try_clause;
    
    try_clause = ((Expression)try_clause.visit(this, tryContinuation));
    CatchClause catch_clause = catch_clauses;
    while ((exitValue == null) && (catch_clause != null))
    {
      Expression clauseContinuation = finally_clause == null ? returnContinuation : body;
      
      body = ((Expression)body.visit(this, clauseContinuation));
      catch_clause = catch_clause.getNext();
    }
    Expression finally_clause = finally_clause;
    if (finally_clause != null)
      finally_clause = ((Expression)finally_clause.visit(this, finally_clause));
    return exp;
  }
  
  protected Expression visitSynchronizedExp(SynchronizedExp exp, Expression returnContinuation)
  {
    object = ((Expression)object.visit(this, object));
    body = ((Expression)body.visit(this, body));
    return exp;
  }
  
  static boolean checkInlineCycle(LambdaExp from, LambdaExp to) {
    for (LambdaExp x = from; x != null; x = inlineHome) {
      if (x == to)
        return true;
    }
    return false;
  }
  
  static Expression checkInlineable(LambdaExp current, Set<LambdaExp> seen)
  {
    Expression r = returnContinuation;
    if ((r == LambdaExp.unknownContinuation) || (seen.contains(current)))
      return r;
    if ((current.getCanRead()) || (current.isClassMethod()) || (current.getFlag(32)) || (Compilation.avoidInline(current)) || (min_args != max_args))
    {



      r = LambdaExp.unknownContinuation;
      returnContinuation = r;
      return r;
    }
    seen.add(current);
    if (tailCallers != null) {
      for (LambdaExp p : tailCallers) {
        Expression t = checkInlineable(p, seen);
        if (t == LambdaExp.unknownContinuation) {
          if (((r == null) || (r == p)) && (!p.nestedIn(current)))
          {
            r = p;
          } else {
            r = t;
            break;
          }
        } else if (r == null) {
          r = t;
        } else if ((t != null) && (r != t)) {
          r = LambdaExp.unknownContinuation;
          break;
        }
      }
    }
    if (r != LambdaExp.unknownContinuation) {
      if (inlineHome != null) {
        if (checkInlineCycle(inlineHome, current)) {
          r = LambdaExp.unknownContinuation;
        }
      } else {
        LambdaExp x = null;
        if ((returnContinuation instanceof ApplyExp)) {
          x = returnContinuation).context;
        } else if ((returnContinuation instanceof LambdaExp))
          x = (LambdaExp)returnContinuation;
        if ((x != null) && (!checkInlineCycle(x, current))) {
          inlineHome = x;
        } else if (tailCallers != null) {
          for (LambdaExp p : tailCallers) {
            if (!checkInlineCycle(p, current)) {
              inlineHome = p;
              break;
            }
          }
        } else
          r = LambdaExp.unknownContinuation;
      }
    }
    if (r == LambdaExp.unknownContinuation) {
      returnContinuation = r;
      inlineHome = null;
    }
    return r;
  }
  
  static void checkInlineable(LambdaExp exp) {
    Set<LambdaExp> seen = new LinkedHashSet();
    Expression caller = checkInlineable(exp, seen);
    if (caller != LambdaExp.unknownContinuation) {
      exp.setInlineOnly(true);
      if (inlineHome == null) {
        LambdaExp outer = exp.outerLambda();
        if (!checkInlineCycle(outer, exp)) {
          inlineHome = outer;
        }
      }
    }
    for (LambdaExp child = firstChild; child != null; 
        child = nextSibling) {
      checkInlineable(child);
    }
  }
  
  protected Expression visitModuleExp(ModuleExp exp, Expression returnContinuation)
  {
    Expression ret = (Expression)super.visitModuleExp(exp, returnContinuation);
    checkInlineable(exp);
    return ret;
  }
}
