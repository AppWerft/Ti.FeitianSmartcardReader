package gnu.expr;





public class ResolveNames
  extends ExpExpVisitor<Void>
{
  protected NameLookup lookup;
  



  public ResolveNames() {}
  



  public ResolveNames(Compilation comp)
  {
    setContext(comp);
    lookup = lexical;
  }
  
  public void resolveModule(ModuleExp exp)
  {
    Compilation saveComp = Compilation.setSaveCurrent(comp);
    try
    {
      push(exp);
      exp.visitChildren(this, null);
    }
    finally
    {
      Compilation.restoreCurrent(saveComp);
    }
  }
  


  protected void push(ScopeExp exp)
  {
    lookup.push(exp);
  }
  
  protected Expression visitScopeExp(ScopeExp exp, Void ignored)
  {
    visitDeclarationTypes(exp);
    push(exp);
    exp.visitChildren(this, ignored);
    lookup.pop(exp);
    return exp;
  }
  
  protected Expression visitLetExp(LetExp exp, Void ignored)
  {
    visitDeclarationTypes(exp);
    exp.visitInitializers(this, ignored);
    push(exp);
    body = ((Expression)visit(body, ignored));
    lookup.pop(exp);
    return exp;
  }
  
  public Declaration lookup(Expression exp, Object symbol, boolean function)
  {
    return lookup.lookup(symbol, function);
  }
  
  protected Expression visitReferenceExp(ReferenceExp exp, Void ignored)
  {
    Declaration decl = exp.getBinding();
    if (decl == null)
    {
      decl = lookup(exp, exp.getSymbol(), exp.isProcedureName());
      if (decl != null)
        exp.setBinding(decl);
    }
    return exp;
  }
  
  protected Expression visitSetExp(SetExp exp, Void ignored)
  {
    if (binding == null)
    {
      Declaration decl = lookup(exp, exp.getSymbol(), exp.isFuncDef());
      if (decl != null)
        decl.setCanWrite(true);
      binding = decl;
    }
    return (Expression)super.visitSetExp(exp, ignored);
  }
}
