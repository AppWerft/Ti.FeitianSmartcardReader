package gnu.expr;

import gnu.bytecode.Scope;

public abstract class ScopeExp extends Expression
{
  Declaration decls;
  Declaration last;
  protected Scope scope;
  private ScopeExp outer;
  protected int frameSize;
  static int counter;
  
  public Declaration firstDecl()
  {
    return decls;
  }
  
  public Scope getVarScope() {
    Scope sc = scope;
    if (sc == null)
      scope = (sc = new Scope());
    return sc;
  }
  




  public void popScope(gnu.bytecode.CodeAttr code)
  {
    for (Declaration decl = firstDecl(); decl != null; decl = decl.nextDecl())
      var = null;
    code.popScope();
    scope = null;
  }
  
  public void add(Declaration decl)
  {
    if (last == null) {
      decls = decl;
    } else
      last.setNext(decl);
    last = decl;
    context = this;
  }
  


  public void add(Declaration prev, Declaration decl)
  {
    if (prev == null)
    {
      decl.setNext(decls);
      decls = decl;
    }
    else
    {
      decl.setNext(prev.nextDecl());
      prev.setNext(decl);
    }
    if (last == prev)
      last = decl;
    context = this;
  }
  

  public void replaceFollowing(Declaration prev, Declaration newDecl)
  {
    Declaration oldDecl;
    
    if (prev == null)
    {
      Declaration oldDecl = decls;
      decls = newDecl;
    }
    else
    {
      oldDecl = prev.nextDecl();
      prev.setNext(newDecl);
    }
    newDecl.setNext(oldDecl.nextDecl());
    if (last == oldDecl)
      last = newDecl;
    oldDecl.setNext(null);
    context = this;
  }
  
  public void remove(Declaration decl)
  {
    Declaration prev = null;
    for (Declaration cur = firstDecl(); cur != null; cur = cur.nextDecl())
    {
      if (cur == decl)
      {
        remove(prev, decl);
        return;
      }
      prev = cur;
    }
  }
  
  public void remove(Declaration prev, Declaration decl)
  {
    Declaration next = decl.nextDecl();
    if (prev == null) {
      decls = next;
    } else
      prev.setNext(next);
    if (last == decl)
      last = prev;
    decl.setNext(null);
  }
  


  public ScopeExp() {}
  


  public ScopeExp getOuter() { return outer; }
  
  public void setOuter(ScopeExp outer) { this.outer = outer; }
  
  public LambdaExp currentLambda()
  {
    ScopeExp exp = this;
    for (;; exp = exp.getOuter())
    {
      if (exp == null)
        return null;
      if ((exp instanceof LambdaExp)) {
        return (LambdaExp)exp;
      }
    }
  }
  
  public ScopeExp topLevel()
  {
    ScopeExp exp = this;
    for (;;)
    {
      ScopeExp outer = exp.getOuter();
      if ((outer == null) || ((outer instanceof ModuleExp)))
        return exp;
      exp = outer;
    }
  }
  
  public ModuleExp currentModule()
  {
    ScopeExp exp = this;
    for (;; exp = exp.getOuter())
    {
      if (exp == null)
        return null;
      if ((exp instanceof ModuleExp)) {
        return (ModuleExp)exp;
      }
    }
  }
  




  public Declaration lookup(Object sym)
  {
    if (sym != null)
    {
      for (Declaration decl = firstDecl(); 
          decl != null; decl = decl.nextDecl())
      {
        if (sym.equals(symbol))
          return decl;
      }
    }
    return null;
  }
  
  public Declaration lookup(Object sym, Language language, int namespace)
  {
    for (Declaration decl = firstDecl(); 
        decl != null; decl = decl.nextDecl())
    {
      if ((sym.equals(symbol)) && (language.hasNamespace(decl, namespace)))
      {
        return decl; }
    }
    return null;
  }
  

  public Declaration getNoDefine(Object name)
  {
    Declaration decl = lookup(name);
    if (decl == null)
    {
      decl = addDeclaration(name);
      flags |= 0x10200;
    }
    return decl;
  }
  

  public Declaration getDefine(Object name, Compilation parser)
  {
    Declaration decl = lookup(name);
    if (decl == null) {
      decl = addDeclaration(name);
    } else if ((flags & 0x10200) != 0L)
    {
      flags &= 0xFFFFFFFFFFFEFDFF;
    }
    else {
      Declaration newDecl = addDeclaration(name);
      duplicateDeclarationError(decl, newDecl, parser);
      decl = newDecl;
    }
    return decl;
  }
  


  public static void duplicateDeclarationError(Declaration oldDecl, Declaration newDecl, Compilation comp)
  {
    comp.error('e', newDecl, "duplicate declaration of '", "'");
    comp.error('e', oldDecl, "(this is the previous declaration of '", "')");
  }
  




  public final Declaration addDeclaration(Object name)
  {
    Declaration decl = new Declaration(name);
    add(decl);
    return decl;
  }
  





  public final Declaration addDeclaration(Object name, gnu.bytecode.Type type)
  {
    Declaration decl = new Declaration(name, type);
    add(decl);
    return decl;
  }
  



  public final void addDeclaration(Declaration decl)
  {
    add(decl);
  }
  
  public int countDecls()
  {
    int n = 0;
    for (Declaration decl = firstDecl(); decl != null; decl = decl.nextDecl())
      n++;
    return n;
  }
  
  public void clearCallList()
  {
    for (Declaration decl = firstDecl(); decl != null; decl = decl.nextDecl()) {
      decl.clearCallList();
    }
  }
  
  public static int nesting(ScopeExp sc) {
    int n = 0;
    while (sc != null)
    {
      sc = sc.getOuter();
      n++;
    }
    return n;
  }
  

  public boolean nestedIn(ScopeExp outer)
  {
    for (ScopeExp sc = this; sc != null; sc = sc.getOuter())
    {
      if (sc == outer)
        return true;
    }
    return false;
  }
  



  protected void setIndexes()
  {
    int i = 0;
    for (Declaration decl = firstDecl(); decl != null; decl = decl.nextDecl())
    {
      evalIndex = (i++);
    }
    frameSize = i;
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitScopeExp(this, d);
  }
  
  public final boolean isClassGenerated()
  {
    return ((this instanceof ModuleExp)) || ((this instanceof ClassExp));
  }
  
  public String toString() { return getClass().getName() + "#" + id; }
  


  public int id = ++counter;
}
