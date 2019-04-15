package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;

public class CompileReflect
{
  public CompileReflect() {}
  
  public static int checkKnownClass(Type type, Compilation comp)
  {
    if (((type instanceof ClassType)) && (type.isExisting()))
    {
      try
      {
        type.getReflectClass();
        return 1;
      }
      catch (Exception ex)
      {
        comp.error('e', "unknown class: " + type.getName());
        return -1;
      }
    }
    return 0;
  }
  




  public static ApplyExp inlineClassName(ApplyExp exp, int carg, InlineCalls walker)
  {
    Compilation comp = walker.getCompilation();
    gnu.expr.Language language = comp.getLanguage();
    Expression[] args = exp.getArgs();
    if (args.length > carg)
    {
      Type type = language.getTypeFor(args[carg]);
      if (!(type instanceof Type))
        return exp;
      if (checkKnownClass(type, comp) >= 0)
      {
        args[carg] = new QuoteExp(type);
        return exp;
      }
    }
    return exp;
  }
  

  public static Expression validateApplyInstanceOf(ApplyExp exp, InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Expression origTypeExp = exp.getArgCount() >= 2 ? exp.getArg(1) : null;
    exp.visitArgs(visitor);
    exp = inlineClassName(exp, 1, visitor);
    Expression[] args = exp.getArgs();
    if (args.length == 2)
    {
      Expression value = args[0];
      Expression texp = args[1];
      if ((texp instanceof QuoteExp))
      {
        Object t = ((QuoteExp)texp).getValue();
        if ((t instanceof Type))
        {
          Type type = (Type)t;
          if ((type instanceof gnu.bytecode.PrimType))
            type = ((gnu.bytecode.PrimType)type).boxedType();
          if ((value instanceof QuoteExp)) {
            return type.isInstance(((QuoteExp)value).getValue()) ? QuoteExp.trueExp : QuoteExp.falseExp;
          }
          if ((!value.side_effects()) && ((type instanceof ClassType)))
          {
            int comp = type.compare(value.getType());
            if ((comp == 1) || (comp == 0))
              return QuoteExp.trueExp;
            if (comp == -3)
              return QuoteExp.falseExp;
          }
        }
      }
      Type texpType = texp.getType();
      if ((Compilation.typeType.isCompatibleWithValue(texpType) < 0) && (Type.javalangClassType.isCompatibleWithValue(texpType) < 0))
      {
        visitor.getCompilation().error('w', "not a type or class expression", origTypeExp); }
    }
    return exp;
  }
  

  public static Expression validateApplySlotGet(ApplyExp exp, InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Compilation comp = visitor.getCompilation();
    gnu.expr.Language language = comp.getLanguage();
    SlotGet gproc = (SlotGet)proc;
    boolean isStatic = isStatic;
    
    Expression[] args = exp.getArgs();
    Expression arg0 = args[0];
    Expression arg1 = args[1];
    Object val1 = arg1.valueIfConstant();
    String name = null;
    if (((val1 instanceof CharSequence)) || ((val1 instanceof gnu.mapping.Symbol))) {
      name = val1.toString();
    } else
      return exp;
    Type type; if (isStatic)
    {
      Type type = language.getTypeFor(arg0);
      int known = checkKnownClass(type, comp);
      if ((known < 0) || ("class".equals(name)))
        return exp;
      if (type != null)
      {
        Expression[] nargs = { new QuoteExp(type), arg1 };
        
        ApplyExp nexp = new ApplyExp(exp.getFunction(), nargs);
        nexp.setLine(exp);
        exp = nexp;
      }
    }
    else
    {
      type = arg0.getType();
      if (((type instanceof gnu.bytecode.ArrayType)) && ("length".equals(name)))
      {
        exp.setType(Type.intType);
        return exp;
      }
    }
    Type rtype = null;
    if ((type instanceof gnu.bytecode.ObjectType))
    {
      gnu.bytecode.ObjectType ctype = (gnu.bytecode.ObjectType)type;
      ClassType caller = curClass != null ? curClass : mainClass;
      
      gnu.bytecode.Member part = SlotGet.lookupMember(ctype, name, caller);
      if ((part instanceof gnu.bytecode.Field))
      {
        gnu.bytecode.Field field = (gnu.bytecode.Field)part;
        int modifiers = field.getModifiers();
        boolean isStaticField = (modifiers & 0x8) != 0;
        if ((isStatic) && (!isStaticField)) {
          return new gnu.expr.ErrorExp("cannot access non-static field `" + name + "' using `" + proc.getName() + '\'', comp);
        }
        if ((caller != null) && (!caller.isAccessible(field, ctype)))
        {
          return new gnu.expr.ErrorExp("field " + field.getDeclaringClass().getName() + '.' + name + " is not accessible here", comp);
        }
        


        if ((isStatic) && ((modifiers & 0x4010) == 16400))
        {
          try
          {

            return new QuoteExp(field.getReflectField().get(null), field.getType());
          }
          catch (Exception ex) {}
        }
        


        rtype = field.getType();
      }
      else if ((part instanceof gnu.bytecode.Method))
      {
        gnu.bytecode.Method method = (gnu.bytecode.Method)part;
        ClassType dtype = method.getDeclaringClass();
        int modifiers = method.getModifiers();
        boolean isStaticMethod = method.getStaticFlag();
        if ((isStatic) && (!isStaticMethod)) {
          return new gnu.expr.ErrorExp("cannot call non-static getter method `" + name + "' using `" + proc.getName() + '\'', comp);
        }
        if ((caller != null) && (!caller.isAccessible(dtype, ctype, modifiers))) {
          return new gnu.expr.ErrorExp("method " + method + " is not accessible here", comp);
        }
        rtype = method.getReturnType();
      }
      else if (((part instanceof ClassType)) && (((ClassType)part).getStaticFlag()))
      {
        Object result = part;
        if ((arg0.valueIfConstant() instanceof Class))
        {
          Class cls = ((ClassType)part).getReflectClass();
          if (cls != null)
            result = cls;
        }
        return QuoteExp.getInstance(result);
      }
      if (part != null)
      {
        Expression[] nargs = { arg0, new QuoteExp(part) };
        
        ApplyExp nexp = new ApplyExp(exp.getFunction(), nargs);
        nexp.setLine(exp);
        nexp.setType(rtype);
        return nexp;
      }
      
      if ((part == null) && ((type instanceof ClassType)) && (isStatic))
      {
        ClassType mcl = ((ClassType)type).getDeclaredClass(name);
        if (mcl != null)
        {
          if ((arg0.valueIfConstant() instanceof Class))
          {
            try
            {
              return new QuoteExp(mcl.getReflectClass());
            }
            catch (Exception ex) {}
          }
          

          return new QuoteExp(mcl);
        }
      }
      
      if ((type != Type.pointer_type) && (type != gnu.kawa.lispexpr.LangObjType.dynamicType) && (comp.warnUnknownMember()))
      {
        comp.error('w', "no slot `" + name + "' in " + ctype.getName());
      }
    }
    String fname = gnu.expr.Mangling.mangleNameIfNeeded(name);
    

    fname = fname.intern();
    String getName = gnu.expr.ClassExp.slotToMethodName("get", name);
    String isName = gnu.expr.ClassExp.slotToMethodName("is", name);
    ApplyExp nexp = new ApplyExp(Invoke.invokeStatic, new Expression[] { QuoteExp.getInstance("gnu.kawa.reflect.SlotGet"), QuoteExp.getInstance("getSlotValue"), isStatic ? QuoteExp.trueExp : QuoteExp.falseExp, args[0], QuoteExp.getInstance(name), QuoteExp.getInstance(fname), QuoteExp.getInstance(getName), QuoteExp.getInstance(isName), QuoteExp.getInstance(language) });
    










    nexp.setLine(exp);
    return visitor.visitApplyOnly(nexp, required);
  }
  

  public static Expression validateApplySlotSet(ApplyExp exp, InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Expression[] args = exp.getArgs();
    SlotSet sproc = (SlotSet)proc;
    boolean isStatic = isStatic;
    args[0] = visitor.visit(args[0], null);
    args[1] = visitor.visit(args[1], null);
    Type type = isStatic ? kawa.standard.Scheme.exp2Type(args[0]) : args[0].getType();
    
    Object val1 = args[1].valueIfConstant();
    String name = null;
    Compilation comp = visitor.getCompilation();
    ClassType caller = curClass != null ? curClass : mainClass;
    if (((val1 instanceof CharSequence)) || ((val1 instanceof gnu.mapping.SimpleSymbol)))
    {

      name = val1.toString();
      if ((type instanceof ClassType))
      {
        ClassType ctype = (ClassType)type;
        
        gnu.bytecode.Member part = SlotSet.lookupMember(ctype, name, caller);
        if (part == null)
        {
          if ((type != Type.pointer_type) && (comp.warnUnknownMember())) {
            comp.error('w', "no slot `" + name + "' in " + ctype.getName());
          }
        }
        else {
          return visitor.visit(makeSetterCall(args[0], part, args[2]), Type.voidType);
        }
      }
    }
    else if ((val1 instanceof gnu.bytecode.Member))
    {
      gnu.bytecode.Member part = (gnu.bytecode.Member)val1;
      name = part.getName();
      ClassType ctype = part.getDeclaringClass();
      if ((caller != null) && (!caller.isAccessible(part, ctype)))
      {
        return new gnu.expr.ErrorExp("slot '" + name + "' in " + ctype.getName() + " not accessible here", comp);
      }
      
      if ((part instanceof gnu.bytecode.Field))
      {
        gnu.bytecode.Field field = (gnu.bytecode.Field)part;
        boolean isStaticField = field.getStaticFlag();
        Type ftype = comp.getLanguage().getLangTypeFor(((gnu.bytecode.Field)val1).getType());
        if ((isStatic) && (!isStaticField)) {
          return new gnu.expr.ErrorExp("cannot access non-static field `" + name + "' using `" + proc.getName() + '\'', comp);
        }
        args[2] = visitor.visit(args[2], ftype);
      }
    }
    args[2] = visitor.visit(args[2], null);
    if ((isStatic) && (getCompilationmustCompile))
      exp = inlineClassName(exp, 0, visitor);
    exp.setType(Type.voidType);
    return exp;
  }
  
  public static Expression validateApplyTypeSwitch(ApplyExp exp, InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    exp.visitArgs(visitor);
    Expression[] args = exp.getArgs();
    for (int i = 1; i < args.length; i++) {
      if ((args[i] instanceof gnu.expr.LambdaExp)) {
        gnu.expr.LambdaExp lexp = (gnu.expr.LambdaExp)args[i];
        lexp.setInlineOnly(exp, visitor.getCurrentLambda());
        lexp.setFlag(16384);
      }
    }
    return exp;
  }
  
  public static Expression makeSetterCall(Expression receiver, Object slot, Expression newValue) {
    gnu.mapping.Procedure p;
    gnu.mapping.Procedure p;
    if ((slot instanceof gnu.bytecode.Field))
    {
      p = SlotSet.set$Mnfield$Ex;

    }
    else
    {

      slot = ((gnu.bytecode.Member)slot).getName();
      p = Invoke.invoke;
    }
    Expression[] sargs = { receiver, new QuoteExp(slot), newValue };
    return new ApplyExp(p, sargs);
  }
  
  public static Expression validateThrow(ApplyExp exp, InlineCalls visitor, Type required, gnu.mapping.Procedure proc)
  {
    Expression[] args = exp.getArgs();
    args[0] = visitor.visit(args[0], Type.javalangThrowableType);
    exp.setType(Type.neverReturnsType);
    return exp;
  }
}
