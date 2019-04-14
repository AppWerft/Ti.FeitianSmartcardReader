package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.TypeSwitch;
import java.util.Vector;








































































public class ANormalize
  extends ExpExpVisitor<Context>
{
  static abstract class MultiContext
  {
    MultiContext() {}
    
    abstract Expression invoke(Expression[] paramArrayOfExpression, int paramInt);
  }
  
  static final Context identity = new Context();
  
  static class Context {
    Context() {}
    
    Expression invoke(Expression expr) { return expr; }
  }
  

  public ANormalize() {}
  

  public static void aNormalize(Expression exp, Compilation comp)
  {
    ANormalize visitor = new ANormalize();
    visitor.setContext(comp);
    


    visitor.visit(exp, identity);
  }
  






  Declaration genLetDeclaration(Expression val, LetExp let, Declaration providedDecl)
  {
    boolean isProvided = providedDecl != null;
    

    Declaration decl = isProvided ? providedDecl : new Declaration((Object)null);
    


    let.add(decl);
    decl.setInitValue(val);
    decl.setFlag(262144L);
    decl.setNext(null);
    
    if (!isProvided)
    {

      decl.setCanRead();
      decl.setType(val.getType());
      if (val.getClass() == LambdaExp.class)
        decl.setCanCall();
      decl.noteValueFromLet(let);
      numReferences += 1;

    }
    else
    {
      for (int i = 0; i < nvalues; i++) {
        if (values[i].kind == 3)
        {
          values[i].base = let;
        }
      }
    }
    
    if (val.getClass() == LambdaExp.class) {
      LambdaExp lexp = (LambdaExp)val;
      decl.setCanRead(lexp.getCanRead());
    }
    
    return decl;
  }
  
  Declaration genLetDeclaration(Expression val, LetExp let) {
    return genLetDeclaration(val, let, null);
  }
  



  protected Expression normalizeTerm(Expression exp)
  {
    return (Expression)visit(exp, identity);
  }
  



  protected static boolean isAtomic(Expression exp)
  {
    return ((exp instanceof QuoteExp)) || ((exp instanceof ReferenceExp)) || (MakeSplice.argIfSplice(exp) != null) || (isGetNamedPart(exp)) || (isBracketList(exp)) || (isTypeSwitch(exp));
  }
  




  int varCount;
  



  protected Expression normalizeName(Expression exp, final Context context)
  {
    Context newContext = new Context()
    {
      Expression invoke(Expression expr) {
        if (ANormalize.isAtomic(expr)) {
          return context.invoke(expr);
        }
        
        LetExp newlet = new LetExp();
        


        Declaration decl = genLetDeclaration(expr, newlet);
        



        body = context.invoke(new ReferenceExp(decl));
        return newlet;
      }
      

    };
    return (Expression)visit(exp, newContext);
  }
  





  protected Expression normalizeNames(final Expression[] exps, final int index, final MultiContext context)
  {
    if ((exps.length == 0) || (index == exps.length)) {
      return context.invoke(exps, exps.length - 1);
    }
    Context newContext = new Context()
    {
      Expression invoke(final Expression expr)
      {
        ANormalize.MultiContext newNewContext = new ANormalize.MultiContext()
        {
          Expression invoke(Expression[] exprs, int ind)
          {
            exprs[ind] = expr;
            return val$context.invoke(exprs, ind - 1);
          }
        };
        return normalizeNames(exps, index + 1, newNewContext);
      }
      
    };
    return normalizeName(exps[index], newContext);
  }
  
  protected Expression visitQuoteExp(QuoteExp exp, Context context)
  {
    return context.invoke(exp);
  }
  
  protected Expression visitReferenceExp(ReferenceExp exp, Context context) {
    return context.invoke(exp);
  }
  
  protected Expression visitApplyExp(final ApplyExp exp, final Context context) {
    Expression func = exp.getFunction();
    

    if (((isApplyToArgs(func)) && ((args[0] instanceof QuoteExp)) && ((((QuoteExp)args[0]).getValue() instanceof Type))) || (isGetNamedPart(exp)) || (isBracketList(exp)))
    {




      for (int i = 0; i < args.length; i++) {
        args[i] = normalizeTerm(args[i]);
      }
      return context.invoke(exp);
    }
    if ((MakeSplice.argIfSplice(exp) != null) || (isTypeSwitch(exp)))
    {

      args[0] = normalizeTerm(args[0]);
      return context.invoke(exp);
    }
    if (isSetter(func)) {
      return context.invoke(exp);
    }
    
    int startIndex;
    
    final int startIndex;
    if (isApplyToArgs(func)) {
      func = args[0];
      startIndex = 1;
    } else {
      startIndex = 0;
    }
    
    Context newContext = new Context()
    {
      Expression invoke(final Expression expr)
      {
        ANormalize.MultiContext newNewContext = new ANormalize.MultiContext()
        {
          Expression invoke(Expression[] exprs, int ind)
          {
            if (ind > -1) {
              exprs[ind] = expr;
            } else
              val$exp.func = expr;
            val$exp.args = exprs;
            return val$context.invoke(val$exp);
          }
        };
        return normalizeNames(expargs, startIndex, newNewContext);
      }
      
    };
    return normalizeName(func, newContext);
  }
  
  private static boolean isApplyToArgs(Expression func) {
    return ((func instanceof ReferenceExp)) && (func.getName() != null) && (func.getName().equals("applyToArgs"));
  }
  

  private static Expression getApplyFunc(ApplyExp aexp)
  {
    return isApplyToArgs(aexp.getFunction()) ? args[0] : aexp.getFunction();
  }
  

  private static boolean isSetter(Expression aexp)
  {
    return ((aexp instanceof ApplyExp)) && (((ApplyExp)aexp).getFunction().getType() == ClassType.make("gnu.kawa.functions.Setter"));
  }
  

  private static boolean isGetNamedPart(Expression exp)
  {
    if ((exp instanceof ApplyExp)) {
      ApplyExp aexp = (ApplyExp)exp;
      Expression func = aexp.getFunction();
      return ((func instanceof QuoteExp)) && (((QuoteExp)func).getValue() == GetNamedPart.getNamedPart);
    }
    

    return false;
  }
  
  private static boolean isBracketList(Expression exp) {
    if ((exp instanceof ApplyExp)) {
      ApplyExp aexp = (ApplyExp)exp;
      Expression func = getApplyFunc(aexp);
      return ((func instanceof ReferenceExp)) && (((ReferenceExp)func).getSymbol() == LispLanguage.bracket_list_sym);
    }
    

    return false;
  }
  
  private static boolean isTypeSwitch(Expression exp) {
    if ((exp instanceof ApplyExp)) {
      ApplyExp aexp = (ApplyExp)exp;
      Expression func = getApplyFunc(aexp);
      return ((func instanceof QuoteExp)) && (((QuoteExp)func).getValue() == TypeSwitch.typeSwitch);
    }
    

    return false;
  }
  

  protected Expression visitBeginExp(BeginExp exp, Context context)
  {
    Vector co = compileOptions;
    
    LetExp firstLet = new LetExp();
    LetExp previous = firstLet;
    

    for (int i = 0; 
        (i < exps.length - 1) && (exps[(i + 1)] != null); i++) {
      if (exps[i] != QuoteExp.voidExp)
      {



        genLetDeclaration(exps[i], previous);
        body = new LetExp();
        previous = (LetExp)body;
      }
    }
    
    body = exps[i];
    


    Expression result = visitLetExp(firstLet, context);
    

    if (co != null) {
      result = new BeginExp(new Expression[] { result });
      compileOptions = co;
    }
    
    return result;
  }
  



  protected Expression visitLetExp(final LetExp exp, Context context)
  {
    final Declaration first = exp.firstDecl();
    if (((exp instanceof FluidLetExp)) && (context != identity))
      return context.invoke(normalizeTerm(exp));
    if (first == null) {
      return (Expression)visit(body, context);
    }
    
    decls = decls.nextDecl();
    
    final Expression innerLet = visitLetExp(exp, context);
    

    Expression firstLetVal = first.getInitValue();
    
    Context newContext = new Context()
    {
      Expression invoke(Expression expr) {
        if (expr != QuoteExp.voidExp)
        {
          LetExp newlet = (exp instanceof FluidLetExp) ? new FluidLetExp() : new LetExp();
          



          genLetDeclaration(expr, newlet, first);
          
          body = innerLet;
          return newlet;
        }
        return innerLet;
      }
      
    };
    return (Expression)visit(firstLetVal, newContext);
  }
  
  protected Expression visitIfExp(final IfExp exp, final Context context)
  {
    Context newContext = new Context()
    {
      Expression invoke(Expression expr)
      {
        expthen_clause = normalizeTerm(expthen_clause);
        expelse_clause = (expelse_clause != null ? normalizeTerm(expelse_clause) : null);
        


        exptest = expr;
        
        return context.invoke(exp);
      }
    };
    return normalizeName(test, newContext);
  }
  
  protected Expression visitCaseExp(final CaseExp exp, final Context context) {
    Context newContext = new Context()
    {

      Expression invoke(Expression expr)
      {
        for (int i = 0; i < expclauses.length; i++) {
          expclauses[i].exp = normalizeTerm(expclauses[i].exp);
        }
        if (expelseClause != null) {
          expelseClause.exp = normalizeTerm(expelseClause.exp);
        }
        expkey = expr;
        
        return context.invoke(exp);
      }
    };
    return normalizeName(key, newContext);
  }
  
  protected Expression visitLambdaExp(LambdaExp exp, Context context) {
    body = normalizeTerm(body);
    return context.invoke(exp);
  }
  
  protected Expression visitSetExp(final SetExp exp, final Context context)
  {
    Declaration bin = exp.getBinding();
    
    if (bin != null) {
      bin.setCanWrite();
      

      if (bin.getInitValue() == QuoteExp.undefined_exp) {
        Expression value = bin.getValue();
        if (((value instanceof LambdaExp)) || ((value != bin.getInitValue()) && ((value instanceof QuoteExp))))
        {
          bin.setInitValue(normalizeTerm(value));
          return context.invoke(QuoteExp.voidExp);
        }
      }
    }
    

    if (exp.isDefining())
    {
      if ((!(new_value instanceof ReferenceExp)) && (!(new_value instanceof QuoteExp)))
      {
        new_value = normalizeTerm(new_value);
      }
      return context.invoke(exp);
    }
    
    Context newContext = new Context()
    {

      Expression invoke(Expression expr)
      {
        LetExp newlet = new LetExp();
        

        expnew_value = expr;
        


        genLetDeclaration(exp, newlet);
        
        body = context.invoke(QuoteExp.voidExp);
        return newlet;
      }
    };
    return normalizeName(new_value, newContext);
  }
  
  protected Expression visitModuleExp(ModuleExp exp, Context context) {
    if ((body instanceof ApplyExp)) {
      ApplyExp body = (ApplyExp)body;
      for (int i = 0; i < args.length; i++) {
        args[i] = ((Expression)visit(args[i], context));
      }
      return exp;
    }
    
    return (Expression)visitExpression(exp, context);
  }
  
  protected Expression visitTryExp(TryExp exp, Context context) {
    try_clause = normalizeTerm(try_clause);
    if (catch_clauses != null) {
      catch_clauses = toCatchClause((LetExp)normalizeTerm(catch_clauses), catch_clauses.next);
      
      for (CatchClause c = catch_clauses; next != null; c = next)
        next = toCatchClause((LetExp)normalizeTerm(next), next.next);
    }
    if (finally_clause != null)
      finally_clause = normalizeTerm(finally_clause);
    return context.invoke(exp);
  }
  
  protected CatchClause toCatchClause(LetExp exp, CatchClause next) {
    CatchClause clause = new CatchClause(decls, body);
    next = next;
    return clause;
  }
  

  protected Expression visitSynchronizedExp(final SynchronizedExp exp, final Context context)
  {
    Context newContext = new Context()
    {
      Expression invoke(Expression expr)
      {
        expbody = normalizeTerm(expbody);
        expobject = expr;
        
        return context.invoke(exp);
      }
      
    };
    return normalizeName(object, newContext);
  }
  
  protected Expression visitBlockExp(BlockExp exp, Context context) {
    body = normalizeTerm(body);
    if (exitBody != null)
      exitBody = normalizeTerm(exitBody);
    return context.invoke(exp);
  }
  
  protected Expression visitExitExp(ExitExp exp, Context context) {
    result = normalizeTerm(result);
    return context.invoke(exp);
  }
  
  protected Expression visitClassExp(ClassExp exp, Context context) {
    for (Declaration decl = exp.firstDecl(); decl != null; 
        decl = decl.nextDecl()) {
      Expression e = decl.getValue();
      if (e != null)
        if ((e instanceof LambdaExp)) {
          decl.setValue(normalizeClassMethod((LambdaExp)e));
        } else
          decl.setValue(normalizeTerm(e));
    }
    if (firstChild != null) {
      LambdaExp next = firstChild.nextSibling;
      firstChild = ((LambdaExp)normalizeClassMethod(firstChild));
      firstChild.nextSibling = next;
      for (LambdaExp child = firstChild; nextSibling != null; 
          child = nextSibling) {
        next = nextSibling.nextSibling;
        nextSibling = ((LambdaExp)normalizeClassMethod(nextSibling));
        nextSibling.nextSibling = next;
      }
    }
    
    return context.invoke(exp);
  }
  


  private Expression normalizeClassMethod(LambdaExp exp)
  {
    if (exp.isClassMethod()) {
      if ("*init*".equals(exp.getName())) {
        if ((body instanceof BeginExp)) {
          Expression bodyFirst = exp.getBodyFirstExpression();
          body).exps[0] = QuoteExp.voidExp;
          body = new BeginExp(bodyFirst, normalizeTerm(body));
        }
      } else {
        return normalizeTerm(exp);
      }
    } else
      throw new Error();
    return exp;
  }
}
