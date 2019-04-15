package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;

public class CompileNamedPart
{
  public CompileNamedPart() {}
  
  public static Expression validateGetNamedPart(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    if ((args.length != 2) || (!(args[1] instanceof QuoteExp)) || (!(exp instanceof GetNamedExp)))
    {
      return exp; }
    Expression context = args[0];
    gnu.expr.Declaration decl = null;
    if ((context instanceof gnu.expr.ReferenceExp))
    {
      gnu.expr.ReferenceExp rexp = (gnu.expr.ReferenceExp)context;
      if ("*".equals(rexp.getName()))
        return makeGetNamedInstancePartExp(args[1]);
      decl = rexp.getBinding();
    }
    
    String mname = ((QuoteExp)args[1]).getValue().toString();
    Type type = context.getType();
    
    if (type == gnu.kawa.lispexpr.LangObjType.dynamicType)
    {

      exp.setType(gnu.kawa.lispexpr.LangObjType.dynamicType);
      return exp;
    }
    
    boolean isInstanceOperator = context == QuoteExp.nullExp;
    gnu.expr.Compilation comp = visitor.getCompilation();
    gnu.expr.Language language = comp.getLanguage();
    Type typeval = language.getTypeFor(context, false);
    gnu.bytecode.ClassType caller = curClass != null ? curClass : comp == null ? null : mainClass;
    

    GetNamedExp nexp = (GetNamedExp)exp;
    
    if (typeval != null)
    {
      if (mname.equals("<>")) {
        return new QuoteExp(typeval);
      }
      if ((typeval instanceof gnu.bytecode.ObjectType))
      {
        if (mname.equals("new"))
          return nexp.setProcedureKind('N');
        if (mname.equals("instance?"))
          return nexp.setProcedureKind('I');
        if (mname.equals("@"))
          return nexp.setProcedureKind('C');
      }
    }
    if ((typeval instanceof gnu.bytecode.ObjectType))
    {
      if ((mname.length() > 1) && (mname.charAt(0) == '.'))
      {



        return new QuoteExp(new NamedPart(typeval, mname, 'D'));
      }
      if (gnu.kawa.reflect.CompileReflect.checkKnownClass(typeval, comp) < 0)
        return exp;
      gnu.bytecode.ObjectType otype = (gnu.bytecode.ObjectType)typeval;
      gnu.expr.PrimProcedure[] methods = gnu.kawa.reflect.ClassMethods.getMethods(otype, gnu.expr.Mangling.mangleName(mname), '\000', caller, language);
      


      if ((methods != null) && (methods.length > 0))
      {
        methods = methods;
        otype = otype;
        mname = mname;
        return nexp.setProcedureKind('S');
      }
      ApplyExp aexp = new ApplyExp(gnu.kawa.reflect.SlotGet.staticField, args);
      aexp.setLine(exp);
      return visitor.visitApplyOnly(aexp, required);
    }
    
    if ((typeval == null) || (
    










      (type.isSubtype(gnu.expr.Compilation.typeClassType)) || (type.isSubtype(Type.javalangClassType))))
    {



      return exp;
    }
    if ((type instanceof gnu.bytecode.ObjectType))
    {
      gnu.bytecode.ObjectType otype = (gnu.bytecode.ObjectType)type;
      gnu.expr.PrimProcedure[] methods = gnu.kawa.reflect.ClassMethods.getMethods(otype, gnu.expr.Mangling.mangleName(mname), 'V', caller, language);
      

      if ((methods != null) && (methods.length > 0))
      {
        methods = methods;
        return nexp.setProcedureKind('M');
      }
      
      if (type.isSubtype(typeHasNamedParts))
      {
        Object val;
        if ((decl != null) && ((val = gnu.expr.Declaration.followAliases(decl).getConstantValue()) != null))
        {

          gnu.mapping.HasNamedParts value = (gnu.mapping.HasNamedParts)val;
          if (value.isConstant(mname))
          {
            val = value.get(mname);
            return QuoteExp.getInstance(val);
          }
        }
        args = new Expression[] { args[0], QuoteExp.getInstance(mname) };
        return new ApplyExp(typeHasNamedParts.getDeclaredMethod("get", 1), args).setLine(exp);
      }
      

      gnu.bytecode.Member part = gnu.kawa.reflect.SlotGet.lookupMember(otype, mname, caller);
      if ((part != null) || ((mname.equals("length")) && ((type instanceof gnu.bytecode.ArrayType))))
      {



        ApplyExp aexp = new ApplyExp(gnu.kawa.reflect.SlotGet.field, args);
        aexp.setLine(exp);
        return visitor.visitApplyOnly(aexp, required);
      }
    }
    
    if (comp.warnUnknownMember())
      comp.error('w', "no known slot '" + mname + "' in " + type.getName());
    return exp;
  }
  

  public static Expression validateSetNamedPart(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Expression[] args = exp.getArgs();
    if ((args.length != 3) || (!(args[1] instanceof QuoteExp)))
    {
      exp.visitArgs(visitor);
      return exp;
    }
    args[0] = visitor.visit(args[0], null);
    args[1] = visitor.visit(args[1], null);
    
    Expression context = args[0];
    String mname = ((QuoteExp)args[1]).getValue().toString();
    Type type = context.getType();
    gnu.expr.Compilation comp = visitor.getCompilation();
    gnu.expr.Language language = comp.getLanguage();
    Type typeval = language.getTypeFor(context);
    gnu.bytecode.ClassType caller = curClass != null ? curClass : comp == null ? null : mainClass;
    

    ApplyExp original = exp;
    if ((typeval instanceof gnu.bytecode.ClassType))
    {
      exp = new ApplyExp(gnu.kawa.reflect.SlotSet.set$Mnstatic$Mnfield$Ex, args);
    }
    else if ((type instanceof gnu.bytecode.ClassType))
    {
      gnu.bytecode.Member part = gnu.kawa.reflect.SlotSet.lookupMember((gnu.bytecode.ClassType)type, mname, caller);
      if (part != null)
        return visitor.visit(gnu.kawa.reflect.CompileReflect.makeSetterCall(args[0], part, args[2]), Type.voidType);
    }
    exp.setType(Type.voidType);
    if (exp == original)
    {
      args[2] = visitor.visit(args[2], null);
      return exp;
    }
    exp.setLine(original);
    return visitor.visit(exp, required);
  }
  

  public static Expression makeExp(Expression clas, Expression member)
  {
    String combinedName = combineName(clas, member);
    gnu.mapping.Environment env = gnu.mapping.Environment.getCurrent();
    if (combinedName != null)
    {
      kawa.lang.Translator tr = (kawa.lang.Translator)gnu.expr.Compilation.getCurrent();
      gnu.mapping.Symbol symbol = gnu.mapping.Namespace.EmptyNamespace.getSymbol(combinedName);
      gnu.expr.Declaration decl = lexical.lookup(symbol, false);
      if (!gnu.expr.Declaration.isUnknown(decl)) {
        return new gnu.expr.ReferenceExp(decl);
      }
      Object property = null;
      if ((symbol != null) && (env.isBound(symbol, property)))
        return new gnu.expr.ReferenceExp(combinedName); }
    gnu.expr.ReferenceExp rexp;
    if (((clas instanceof gnu.expr.ReferenceExp)) && ((rexp = (gnu.expr.ReferenceExp)clas).isUnknown()))
    {

      Object rsym = rexp.getSymbol();
      gnu.mapping.Symbol sym = (rsym instanceof gnu.mapping.Symbol) ? (gnu.mapping.Symbol)rsym : env.getSymbol(rsym.toString());
      
      if (env.get(sym, null) == null)
      {
        String name = rexp.getName();
        try
        {
          Class cl = gnu.bytecode.ClassType.getContextClass(name);
          clas = QuoteExp.getInstance(Type.make(cl));
        }
        catch (Exception ex) {}
      }
    }
    

    Expression[] args = { clas, member };
    GetNamedExp exp = new GetNamedExp(args);
    combinedName = combinedName;
    return exp;
  }
  
  public static String combineName(Expression part1, Expression part2) {
    Object name2;
    String name1;
    String name1;
    if ((((name2 = part2.valueIfConstant()) instanceof gnu.mapping.SimpleSymbol)) && ((((part1 instanceof gnu.expr.ReferenceExp)) && ((name1 = ((gnu.expr.ReferenceExp)part1).getSimpleName()) != null)) || (((part1 instanceof GetNamedExp)) && ((name1 = combinedName) != null))))
    {



      return (name1 + ':' + name2).intern(); }
    return null;
  }
  
  public static Expression makeExp(Expression clas, String member)
  {
    return makeExp(clas, new QuoteExp(member));
  }
  
  public static Expression makeExp(Type type, String member)
  {
    return makeExp(new QuoteExp(type), new QuoteExp(member));
  }
  

  public static Expression validateNamedPart(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    NamedPart namedPart = (NamedPart)proc;
    switch (kind)
    {
    case 'D': 
      String fname = member.toString().substring(1);
      Expression[] xargs = new Expression[2];
      xargs[1] = QuoteExp.getInstance(fname);
      gnu.kawa.reflect.SlotGet slotProc;
      gnu.kawa.reflect.SlotGet slotProc; if (args.length > 0)
      {
        xargs[0] = gnu.expr.Compilation.makeCoercion(args[0], new QuoteExp(container));
        
        slotProc = gnu.kawa.reflect.SlotGet.field;
      }
      else
      {
        xargs[0] = QuoteExp.getInstance(container);
        slotProc = gnu.kawa.reflect.SlotGet.staticField;
      }
      ApplyExp aexp = new ApplyExp(slotProc, xargs);
      aexp.setLine(exp);
      return visitor.visitApplyOnly(aexp, required);
    }
    return exp;
  }
  

  public static Expression validateNamedPartSetter(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    NamedPart get = (NamedPart)((NamedPart.Setter)proc).getGetter();
    if (kind == 'D')
    {
      Expression[] xargs = new Expression[3];
      xargs[1] = QuoteExp.getInstance(member.toString().substring(1));
      xargs[2] = exp.getArgs()[0];
      gnu.kawa.reflect.SlotSet slotProc;
      if (exp.getArgCount() == 1)
      {
        xargs[0] = QuoteExp.getInstance(container);
        slotProc = gnu.kawa.reflect.SlotSet.set$Mnstatic$Mnfield$Ex;
      } else { gnu.kawa.reflect.SlotSet slotProc;
        if (exp.getArgCount() == 2)
        {
          xargs[0] = gnu.expr.Compilation.makeCoercion(exp.getArgs()[0], new QuoteExp(container));
          
          slotProc = gnu.kawa.reflect.SlotSet.set$Mnfield$Ex;
        }
        else {
          return exp; } }
      gnu.kawa.reflect.SlotSet slotProc; ApplyExp aexp = new ApplyExp(slotProc, xargs);
      aexp.setLine(exp);
      return visitor.visitApplyOnly(aexp, required);
    }
    return exp;
  }
  
  static final gnu.bytecode.ClassType typeHasNamedParts = gnu.bytecode.ClassType.make("gnu.mapping.HasNamedParts");
  


  public static Expression makeGetNamedInstancePartExp(Expression member)
  {
    if ((member instanceof QuoteExp))
    {
      Object val = ((QuoteExp)member).getValue();
      if ((val instanceof gnu.mapping.SimpleSymbol))
        return QuoteExp.getInstance(new GetNamedInstancePart(val.toString()));
    }
    return new ApplyExp(gnu.kawa.reflect.Invoke.make, new Expression[] { new QuoteExp(gnu.bytecode.ClassType.make("gnu.kawa.functions.GetNamedInstancePart")), member });
  }
  



  public static Expression validateGetNamedInstancePart(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    

    GetNamedInstancePart gproc = (GetNamedInstancePart)proc;
    gnu.mapping.Procedure property; Expression[] xargs; gnu.mapping.Procedure property; if (isField)
    {
      Expression[] xargs = { args[0], new QuoteExp(pname) };
      property = gnu.kawa.reflect.SlotGet.field;
    }
    else
    {
      int nargs = args.length;
      xargs = new Expression[nargs + 1];
      xargs[0] = args[0];
      xargs[1] = new QuoteExp(pname);
      System.arraycopy(args, 1, xargs, 2, nargs - 1);
      property = gnu.kawa.reflect.Invoke.invoke;
    }
    return visitor.visitApplyOnly(new ApplyExp(property, xargs), required);
  }
  

  public static Expression validateSetNamedInstancePart(ApplyExp exp, gnu.expr.InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    String pname = pname;
    Expression[] xargs = { args[0], new QuoteExp(pname), args[1] };
    
    return visitor.visitApplyOnly(new ApplyExp(gnu.kawa.reflect.SlotSet.set$Mnfield$Ex, xargs), required);
  }
}
