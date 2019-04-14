package gnu.expr;

import gnu.bytecode.Type;
import gnu.kawa.functions.Convert;





public class ChainLambdas
  extends ExpExpVisitor<ScopeExp>
{
  boolean unreachableCodeSeen;
  
  public ChainLambdas() {}
  
  public static void chainLambdas(Expression exp, Compilation comp)
  {
    ChainLambdas visitor = new ChainLambdas();
    visitor.setContext(comp);
    visitor.visit(exp, null);
  }
  
  protected void maybeWarnUnreachable(Expression exp) {
    if ((!unreachableCodeSeen) && (comp.warnUnreachable()))
      comp.error('w', "unreachable code", exp);
    unreachableCodeSeen = true;
  }
  


  protected Expression visitBeginExp(BeginExp exp, ScopeExp scope)
  {
    int neverReturnsIndex = -1;
    int last = length - 1;
    for (int i = 0; i <= last; i++) {
      Expression e = (Expression)visit(exps[i], scope);
      exps[i] = e;
      if ((e.neverReturns()) && (neverReturnsIndex < 0)) {
        neverReturnsIndex = i;
        if (i < last)
          maybeWarnUnreachable(exps[(i + 1)]);
      }
    }
    if (neverReturnsIndex >= 0) {
      type = Type.neverReturnsType;
      length = (neverReturnsIndex + 1);
    }
    return exp;
  }
  
  protected Expression visitApplyExp(ApplyExp exp, ScopeExp scope) {
    Expression f = (Expression)visit(func, scope);
    Expression[] args = args;
    int nargs = args.length;
    func = f;
    if (f.neverReturns()) {
      maybeWarnUnreachable(nargs > 0 ? args[0] : exp);
      return f;
    }
    for (int i = 0; i < nargs; i++) {
      Expression e = (Expression)visit(args[i], scope);
      if ((e.neverReturns()) && (!(f.valueIfConstant() instanceof Convert)))
      {



        Expression[] xargs = new Expression[i + 2];
        xargs[0] = func;
        System.arraycopy(args, 0, xargs, 1, i + 1);
        if ((i + 1 < nargs) || (!exp.isAppendValues())) {
          if ((!unreachableCodeSeen) && (comp.warnUnreachable())) {
            comp.error('w', "unreachable procedure call", exp);
            comp.error('i', "this operand never finishes", args[i]);
          }
          unreachableCodeSeen = true;
        }
        BeginExp bexp = new BeginExp(xargs);
        type = Type.neverReturnsType;
        return bexp;
      }
      args[i] = e;
    }
    return exp;
  }
  
  protected Expression visitSetExp(SetExp sexp, ScopeExp scope) {
    Expression r = (Expression)super.visitSetExp(sexp, scope);
    if (r == sexp) {
      Expression rval = sexp.getNewValue();
      if (rval.neverReturns()) {
        maybeWarnUnreachable(sexp);
        return rval;
      }
    }
    return r;
  }
  
  protected Expression visitIfExp(IfExp exp, ScopeExp scope) {
    Expression e = (Expression)visit(test, scope);
    if (e.neverReturns()) {
      maybeWarnUnreachable(then_clause);
      return e;
    }
    then_clause = ((Expression)visit(then_clause, scope));
    if (else_clause != null) {
      else_clause = ((Expression)visit(else_clause, scope));
      if ((then_clause.neverReturns()) && (else_clause.neverReturns()))
      {
        type = Type.neverReturnsType; }
    }
    return exp;
  }
  
  protected Expression visitCaseExp(CaseExp exp, ScopeExp scope)
  {
    Expression e = (Expression)visit(key, scope);
    if (e.neverReturns()) {
      for (int i = 0; i < clauses.length; i++) {
        maybeWarnUnreachable(clauses[i].exp);
      }
      maybeWarnUnreachable(elseClause.exp);
      return e;
    }
    
    boolean neverReturns = true;
    for (int i = 0; i < clauses.length; i++) {
      clauses[i].exp = ((Expression)visit(clauses[i].exp, scope));
      if (!clauses[i].exp.neverReturns()) {
        neverReturns = false;
      }
    }
    if (elseClause != null) {
      elseClause.exp = ((Expression)visit(elseClause.exp, scope));
      if (!elseClause.exp.neverReturns()) {
        neverReturns = false;
      }
    }
    if (neverReturns) {
      type = Type.neverReturnsType;
    }
    return exp;
  }
  
  protected Expression visitScopeExp(ScopeExp exp, ScopeExp scope)
  {
    exp.setOuter(scope);
    exp.visitChildren(this, exp);
    exp.setIndexes();
    if (exp.mustCompile())
      comp.mustCompileHere();
    return exp;
  }
  
  protected Expression visitLetExp(LetExp exp, ScopeExp scope)
  {
    exp.setOuter(scope);
    int count = 0;
    for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl())
    {
      Expression init = decl.getInitValue();
      Expression e = (Expression)visit(init, exp);
      count++;
      if (e.neverReturns()) {
        if ((!unreachableCodeSeen) && (comp.warnUnreachable()))
          comp.error('w', "initialization of " + decl.getName() + " never finishes", init);
        unreachableCodeSeen = true;
        Expression[] exps = new Expression[count];
        int i = 0;
        Declaration end = decl.nextDecl();
        for (Declaration d = exp.firstDecl(); d != end; d = d.nextDecl())
          exps[(i++)] = d.getInitValue();
        return BeginExp.canonicalize(exps);
      }
      decl.setInitValue(e);
    }
    body = ((Expression)visit(body, exp));
    exp.setIndexes();
    if (exp.mustCompile())
      comp.mustCompileHere();
    return exp;
  }
  
  protected Expression visitLambdaExp(LambdaExp exp, ScopeExp scope)
  {
    boolean unreachableSaved = unreachableCodeSeen;
    unreachableCodeSeen = false;
    LambdaExp parent = currentLambda;
    if ((parent != null) && (!(parent instanceof ClassExp))) {
      parent.pushChild(exp);
    }
    exp.setOuter(scope);
    firstChild = null;
    exp.visitChildrenOnly(this, exp);
    exp.visitProperties(this, exp);
    

    exp.reverseChildList();
    
    if ((exp.getName() == null) && (nameDecl != null))
      exp.setName(nameDecl.getName());
    exp.setIndexes();
    if (exp.mustCompile())
      comp.mustCompileHere();
    unreachableCodeSeen = unreachableSaved;
    return exp;
  }
  
  protected Expression visitClassExp(ClassExp exp, ScopeExp scope)
  {
    LambdaExp parent = currentLambda;
    if ((parent != null) && (!(parent instanceof ClassExp))) {
      parent.pushChild(exp);
    }
    visitScopeExp(exp, scope);
    
    return exp;
  }
}
