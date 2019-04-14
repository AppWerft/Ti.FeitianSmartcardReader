package gnu.expr;

import gnu.bytecode.Field;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.util.Hashtable;

public class FindCapturedVars extends ExpExpVisitor<Void>
{
  public FindCapturedVars() {}
  
  public static void findCapturedVars(Expression exp, Compilation comp)
  {
    FindCapturedVars visitor = new FindCapturedVars();
    visitor.setContext(comp);
    exp.visit(visitor, null);
  }
  
  int backJumpPossible = 0;
  



  protected final void visitDeclarationType(Declaration decl) {}
  


  protected Expression visitApplyExp(ApplyExp exp, Void ignored)
  {
    int oldBackJumpPossible = backJumpPossible;
    boolean skipFunc = false;
    boolean skipArgs = false;
    









    if (((func instanceof ReferenceExp)) && (getCompilation().currentCallConvention() <= 1))
    {

      Declaration decl = Declaration.followAliases(func).binding);
      
      if ((decl != null) && ((context instanceof ModuleExp)) && (!decl.isPublic()) && (!decl.getFlag(4096L)))
      {


        Expression value = decl.getValue();
        if ((value instanceof LambdaExp))
        {
          LambdaExp lexp = (LambdaExp)value;
          if (!lexp.getNeedsClosureEnv()) {
            skipFunc = true;
          }
          
        }
      }
    }
    else if (((func instanceof QuoteExp)) && (exp.getArgCount() > 0))
    {
      Object val = ((QuoteExp)func).getValue();
      Expression arg0 = exp.getArg(0);
      if (((val instanceof PrimProcedure)) && (((PrimProcedure)val).isConstructor()) && ((arg0 instanceof ReferenceExp)))
      {


        Declaration decl = Declaration.followAliases(binding);
        
        if ((decl != null) && (context == comp.getModule()) && (!decl.getFlag(4096L)))
        {

          Expression value = decl.getValue();
          if ((value instanceof ClassExp))
          {
            Expression[] args = exp.getArgs();
            LambdaExp lexp = (LambdaExp)value;
            if (!lexp.getNeedsClosureEnv())
            {
              decl.addCaller(exp);
              for (int i = 1; i < args.length; i++)
                args[i].visit(this, ignored);
              skipFunc = skipArgs = 1;
            }
          }
        }
      }
    }
    if (!skipFunc)
      func = ((Expression)func.visit(this, ignored));
    if ((exitValue == null) && (!skipArgs)) {
      int nargs = args.length;
      for (int i = 0; i < nargs; i++) {
        Expression arg = (Expression)visit(args[i], null);
        


        int inserted = args.length - nargs;
        i += inserted;
        args[i] = arg;
        nargs += inserted;
      }
    }
    if (backJumpPossible > oldBackJumpPossible)
      exp.setFlag(8);
    return exp;
  }
  
  public void visitDefaultArgs(LambdaExp exp, Void ignored)
  {
    super.visitDefaultArgs(exp, ignored);
    






    for (Declaration param = exp.firstDecl(); 
        param != null; param = param.nextDecl())
    {
      if (!param.isSimple())
      {
        exp.setFlag(true, 512);
        break;
      }
    }
  }
  
  protected Expression visitClassExp(ClassExp exp, Void ignored)
  {
    Expression ret = (Expression)super.visitClassExp(exp, ignored);
    if ((!explicitInit) && (!instanceType.isInterface()))
    {
      Compilation.getConstructor(instanceType, exp);
    } else if (exp.getNeedsClosureEnv())
    {
      for (LambdaExp child = firstChild; child != null; 
          child = nextSibling)
      {
        if ("*init*".equals(child.getName()))
          child.setNeedsStaticLink(true);
      }
    }
    if ((exp.isSimple()) && (exp.getNeedsClosureEnv()) && (nameDecl != null) && (nameDecl.getType() == Compilation.typeClass))
    {
      nameDecl.setType(Compilation.typeClassType); }
    return ret;
  }
  
  protected Expression visitModuleExp(ModuleExp exp, Void ignored)
  {
    ModuleExp saveModule = currentModule;
    Hashtable saveDecls = unknownDecls;
    currentModule = exp;
    unknownDecls = null;
    try
    {
      return visitLambdaExp(exp, ignored);
    }
    finally
    {
      currentModule = saveModule;
      unknownDecls = saveDecls;
    }
  }
  

  void maybeWarnNoDeclarationSeen(Object name, boolean function, Compilation comp, SourceLocator location)
  {
    if (comp.resolve(name, function) == null) {
      maybeWarnNoDeclarationSeen(name, comp, location);
    }
  }
  
  void maybeWarnNoDeclarationSeen(Object name, Compilation comp, SourceLocator location) {
    if (comp.warnUndefinedVariable()) {
      comp.error('w', "no declaration seen for " + name, location);
    }
  }
  
  protected Expression visitFluidLetExp(FluidLetExp exp, Void ignored) {
    for (Declaration decl = exp.firstDecl(); decl != null; decl = decl.nextDecl())
    {
      if (base == null)
      {
        Object name = decl.getSymbol();
        Declaration bind = allocUnboundDecl(name, false);
        if (!decl.getFlag(268435456L))
          maybeWarnNoDeclarationSeen(name, comp, exp);
        capture(bind, null);
        base = bind;
      }
    }
    return (Expression)super.visitLetExp(exp, ignored);
  }
  
  protected Expression visitLetExp(LetExp exp, Void ignored)
  {
    if ((body instanceof BeginExp))
    {








      Expression[] exps = body).exps;
      int init_index = 0;
      Declaration decl = exp.firstDecl();
      for (int begin_index = 0; 
          (begin_index < exps.length) && (decl != null); 
          begin_index++)
      {
        Expression st = exps[begin_index];
        if ((st instanceof SetExp))
        {
          SetExp set = (SetExp)st;
          if ((binding == decl) && (decl.getInitValue() == QuoteExp.nullExp) && (set.isDefining()))
          {


            Expression new_value = new_value;
            if ((((new_value instanceof QuoteExp)) || ((new_value instanceof LambdaExp))) && (decl.getValue() == new_value))
            {


              decl.setInitValue(new_value);
              exps[begin_index] = QuoteExp.voidExp;
            }
            init_index++;
            decl = decl.nextDecl();
          }
        }
      }
    }
    return (Expression)super.visitLetExp(exp, ignored);
  }
  
  protected Expression visitLambdaExp(LambdaExp exp, Void ignored)
  {
    if (exp.getInlineOnly())
      backJumpPossible += 1;
    return (Expression)super.visitLambdaExp(exp, ignored);
  }
  
  protected Expression visitCaseExp(CaseExp exp, Void ignored)
  {
    key = ((Expression)visit(key, ignored));
    for (int i = 0; i < clauses.length; i++) {
      Expression e = clauses[i].exp;
      e = (Expression)visit(e, ignored);
    }
    
    CaseExp.CaseClause ecl = elseClause;
    if (ecl != null) {
      exp = ((Expression)visit(exp, ignored));
    }
    return exp;
  }
  
  public void capture(Declaration decl, ReferenceExp rexp)
  {
    if (!decl.getCanReadOrCall())
      return;
    if ((field != null) && (field.getStaticFlag())) {
      return;
    }
    
    if ((comp.immediate) && (decl.hasConstantValue())) {
      return;
    }
    LambdaExp curLambda = getCurrentLambda();
    ScopeExp sc = decl.getContext();
    LambdaExp declLambda = sc.currentLambda();
    














    LambdaExp oldParent = null;
    LambdaExp chain = null;
    while ((curLambda != declLambda) && (curLambda.getInlineOnly()))
    {
      LambdaExp curParent = curLambda.outerLambda();
      if (curParent != oldParent)
      {

        chain = firstChild;
        oldParent = curParent;
      }
      if ((chain == null) || (inlineHome == null))
      {

        return;
      }
      curLambda = curLambda.getCaller();
      chain = nextSibling;
    }
    if (comp.usingCPStyle())
    {
      if (!(curLambda instanceof ModuleExp)) {}


    }
    else if (curLambda == declLambda) {
      return;
    }
    
    Expression value = decl.getValue();
    LambdaExp declValue;
    LambdaExp declValue; if ((value == null) || (!(value instanceof LambdaExp))) {
      declValue = null;
    }
    else {
      declValue = (LambdaExp)value;
      if (declValue.getInlineOnly())
        return;
      if (declValue.isHandlingTailCalls()) {
        declValue = null;
      } else if ((declValue == curLambda) && (!decl.getCanRead())) {
        return;
      }
    }
    if (decl.getFlag(65536L))
    {

      for (LambdaExp parent = curLambda; 
          
          parent != declLambda; parent = parent.outerLambda())
      {


        if ((nameDecl != null) && (nameDecl.getFlag(2048L)))
        {

          decl.setFlag(2048L);
          break;
        }
      }
    }
    if (base != null)
    {
      base.setCanRead(true);
      capture(base, null);
    }
    else if ((decl.getCanReadOrCall()) || (declValue == null)) { LambdaExp heapLambda;
      LambdaExp outer;
      if (!decl.isStatic())
      {
        heapLambda = curLambda;
        







        if ((rexp != null) && (nvalues == 1) && (!decl.hasUnknownValue()) && (!(decl.getValueRaw() instanceof LambdaExp)) && (!decl.getFlag(1099511627776L)) && (!curLambda.getInlineOnly()) && (!curLambda.getCanRead()) && (nameDecl != null) && (!nameDecl.context.isClassGenerated()) && (min_args == max_args))
        {







          Declaration ndecl = null;
          for (ndecl = curLambda.firstDecl(); ndecl != null; 
              ndecl = ndecl.nextDecl()) {
            if ((ndecl.getFlag(131072L)) && (base == decl)) {
              break;
            }
          }
          if (ndecl == null) {
            ndecl = new Declaration(decl.getSymbol());
            base = decl;
            ndecl.setFlag(131072L);
            ndecl.setCanRead(true);
            curLambda.add(null, ndecl);
            min_args += 1;
            max_args += 1;
            for (ApplyExp exp = nameDecl.firstCall; 
                exp != null; exp = nextCall) {
              LambdaExp context = context;
              Expression[] args = exp.getArgs();
              Expression[] nargs = new Expression[args.length + 1];
              boolean recursive = context == curLambda;
              ReferenceExp ref = new ReferenceExp(recursive ? ndecl : decl);
              
              nargs[0] = ref;
              System.arraycopy(args, 0, nargs, 1, args.length);
              exp.setArgs(nargs);
              LambdaExp saveLambda = currentLambda;
              currentLambda = context;
              capture(decl, ref);
              currentLambda = saveLambda;
            }
          }
          rexp.setBinding(ndecl);
          return;
        }
        
        if ((context instanceof ClassExp)) {
          if (heapLambda.getOuter() == context)
            return;
          ScopeExp methodLambda = heapLambda;
          while (methodLambda != null) {
            ScopeExp outer = methodLambda.getOuter();
            if (outer == context) {
              Declaration thisDecl = methodLambda.firstDecl();
              if ((thisDecl == null) || (!thisDecl.isThisParameter())) break;
              capture(thisDecl, null);
              return;
            }
            

            methodLambda = outer;
          }
        }
        if (!decl.isFluid()) {
          heapLambda.setImportsLexVars();
        }
        LambdaExp parent = heapLambda.outerLambda();
        for (outer = parent; (outer != declLambda) && (outer != null);)
        {
          heapLambda = outer;
          if ((!decl.getCanReadOrCall()) && (declValue == outer))
            break;
          Declaration heapDecl = nameDecl;
          if ((heapDecl != null) && (heapDecl.getFlag(2048L)))
          {

            comp.error('e', "static " + heapLambda.getName() + " references non-static " + decl.getName());
          }
          
          if (((heapLambda instanceof ClassExp)) && (heapLambda.getName() != null) && (((ClassExp)heapLambda).isSimple()))
          {

            comp.error('w', nameDecl, "simple class ", " requiring lexical link (because of reference to " + decl.getName() + ") - use define-class instead");
          }
          heapLambda.setNeedsStaticLink();
          outer = heapLambda.outerLambda();
        }
      }
      declLambda.capture(decl);
    }
  }
  
  Hashtable unknownDecls = null;
  ModuleExp currentModule = null;
  

  Declaration allocUnboundDecl(Object name, boolean function)
  {
    Object key = name;
    if ((function) && ((name instanceof Symbol)))
    {
      if (!getCompilation().getLanguage().hasSeparateFunctionNamespace()) {
        function = false;
      } else
        key = new gnu.mapping.KeyPair((Symbol)name, EnvironmentKey.FUNCTION); }
    Declaration decl;
    Declaration decl; if (unknownDecls == null)
    {
      unknownDecls = new Hashtable(100);
      decl = null;
    }
    else {
      decl = (Declaration)unknownDecls.get(key); }
    if (decl == null)
    {
      decl = currentModule.addDeclaration(name);
      decl.setSimple(false);
      decl.setPrivate(true);
      if (function)
        decl.setProcedureDecl(true);
      if (currentModule.isStatic())
        decl.setFlag(2048L);
      decl.setCanRead(true);
      decl.setCanWrite(true);
      decl.noteValueUnknown();
      



      decl.setFlag(327680L);
      decl.setIndirectBinding(true);
      unknownDecls.put(key, decl);
    }
    return decl;
  }
  
  protected Expression visitReferenceExp(ReferenceExp exp, Void ignored)
  {
    Declaration decl = exp.getBinding();
    if (decl == null)
    {
      decl = allocUnboundDecl(exp.getSymbol(), exp.isProcedureName());
      
      exp.setBinding(decl);
    }
    if (decl.getFlag(65536L)) {
      maybeWarnNoDeclarationSeen(exp.getSymbol(), exp.isProcedureName(), comp, exp);
    }
    
    capture(exp.contextDecl(), decl, exp);
    return exp;
  }
  
  void capture(Declaration containing, Declaration decl, ReferenceExp exp)
  {
    Expression dvalue;
    if ((decl.isAlias()) && (((dvalue = decl.getValue()) instanceof ReferenceExp)))
    {
      ReferenceExp rexp = (ReferenceExp)dvalue;
      Declaration orig = binding;
      if ((orig != null) && ((containing == null) || (!orig.needsContext())))
      {

        capture(rexp.contextDecl(), orig, null);
        return;
      }
    }
    while ((decl.isFluid()) && ((context instanceof FluidLetExp)))
    {
      decl = base;
    }
    if ((containing != null) && (decl.needsContext())) {
      capture(containing, null);
    } else {
      capture(decl, exp);
    }
  }
  
  protected Expression visitThisExp(ThisExp exp, Void ignored) {
    if (exp.isForContext())
    {


      LambdaExp curLambda = getCurrentLambda();
      if ((!(curLambda instanceof ModuleExp)) || (!((ModuleExp)curLambda).staticInitRun()))
      {
        curLambda.setImportsLexVars(); }
      return exp;
    }
    
    return visitReferenceExp(exp, ignored);
  }
  
  protected Expression visitSetExp(SetExp exp, Void ignored)
  {
    Declaration decl = binding;
    if (decl == null)
    {
      decl = allocUnboundDecl(exp.getSymbol(), exp.isFuncDef());
      binding = decl;
    }
    if (decl.getFlag(65536L))
      maybeWarnNoDeclarationSeen(exp.getSymbol(), false, comp, exp);
    if (!decl.ignorable())
    {
      if (!exp.isDefining())
        decl = Declaration.followAliases(decl);
      capture(exp.contextDecl(), decl, null);
    }
    return (Expression)super.visitSetExp(exp, ignored);
  }
}
