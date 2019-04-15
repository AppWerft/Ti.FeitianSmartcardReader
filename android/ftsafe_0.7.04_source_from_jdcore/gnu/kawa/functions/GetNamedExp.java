package gnu.kawa.functions;

import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.PrimProcedure;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.CompileInvoke;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Symbol;


















































































































































































































































































































































































class GetNamedExp
  extends ApplyExp
{
  char kind;
  PrimProcedure[] methods;
  ObjectType otype;
  String mname;
  public String combinedName;
  
  public void apply(CallContext ctx)
    throws Throwable
  {
    if (combinedName != null)
    {
      Environment env = Environment.getCurrent();
      Symbol sym = env.getSymbol(combinedName);
      Object unb = Location.UNBOUND;
      Object property = null;
      Object value = env.get(sym, property, unb);
      if (value != unb)
      {
        ctx.writeValue(value);
        return;
      }
    }
    super.apply(ctx);
  }
  
  public GetNamedExp(Expression[] args)
  {
    super(GetNamedPart.getNamedPart, args);
  }
  






  protected GetNamedExp setProcedureKind(char kind)
  {
    type = Compilation.typeProcedure;
    this.kind = kind;
    return this;
  }
  

  public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl)
  {
    Expression[] pargs = getArgs();
    Expression context = pargs[0];
    Expression[] args = exp.getArgs();
    Expression[] xargs;
    int adjust;
    switch (kind)
    {
    case 'M': 
      decl = invokeDecl;
      xargs = new Expression[args.length + 2];
      xargs[0] = pargs[0];
      xargs[1] = pargs[1];
      System.arraycopy(args, 0, xargs, 2, args.length);
      adjust = 2;
      break;
    case 'N': 
      decl = makeDecl;
      xargs = new Expression[args.length + 1];
      System.arraycopy(args, 0, xargs, 1, args.length);
      xargs[0] = context;
      adjust = 1;
      break;
    case 'I': 
      decl = instanceOfDecl;
      xargs = new Expression[args.length + 1];
      System.arraycopy(args, 1, xargs, 2, args.length - 1);
      xargs[0] = args[0];
      xargs[1] = context;
      adjust = firstSpliceArg > 0 ? 1 : 0;
      break;
    case 'C': 
      decl = castDecl;
      xargs = new Expression[args.length + 1];
      System.arraycopy(args, 0, xargs, 1, args.length);
      xargs[0] = context;
      adjust = 1;
      break;
    case 'S': 
      decl = invokeStaticDecl;
      xargs = new Expression[args.length + 2];
      xargs[0] = context;
      xargs[1] = pargs[1];
      System.arraycopy(args, 0, xargs, 2, args.length);
      adjust = 2;
      break;
    default: 
      return exp;
    }
    ApplyExp result = new ApplyExp(new ReferenceExp(decl), xargs);
    if (firstSpliceArg >= 0)
      firstSpliceArg += adjust;
    result.setLine(exp);
    if ((methods != null) && (kind == 'S')) {
      return CompileInvoke.validateNamedInvoke(result, visitor, otype, mname, methods, Invoke.invokeStatic, required);
    }
    



    return visitor.visit(result, required);
  }
  


  public boolean side_effects()
  {
    if ((kind == 'S') || (kind == 'N') || (kind == 'C') || (kind == 'I'))
      return false;
    if (kind == 'M')
      return getArgs()[0].side_effects();
    return true;
  }
  
  static final Declaration fieldDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.SlotGet", "field");
  

  static final Declaration staticFieldDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.SlotGet", "staticField");
  

  static final Declaration makeDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "make");
  

  static final Declaration invokeDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "invoke");
  

  static final Declaration invokeStaticDecl = Declaration.getDeclarationFromStatic("gnu.kawa.reflect.Invoke", "invokeStatic");
  

  static final Declaration instanceOfDecl = Declaration.getDeclarationFromStatic("kawa.standard.Scheme", "instanceOf");
  

  static final Declaration castDecl = Declaration.getDeclarationFromStatic("gnu.kawa.functions.Convert", "as");
}
