package gnu.kawa.reflect;

import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.Target;

public class SlotGet extends gnu.mapping.Procedure2 implements gnu.mapping.HasSetter, gnu.expr.Inlineable
{
  static Class[] noClasses = new Class[0];
  
  boolean isStatic;
  
  gnu.mapping.Procedure setter;
  
  public static final SlotGet field = new SlotGet("field", false, SlotSet.set$Mnfield$Ex);
  
  public static final SlotGet slotRef = new SlotGet("slot-ref", false, SlotSet.set$Mnfield$Ex);
  
  public static final SlotGet staticField = new SlotGet("static-field", true, SlotSet.set$Mnstatic$Mnfield$Ex);
  

  public SlotGet(String name, boolean isStatic)
  {
    super(name);
    this.isStatic = isStatic;
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotGet");
  }
  

  public SlotGet(String name, boolean isStatic, gnu.mapping.Procedure setter)
  {
    this(name, isStatic);
    this.setter = setter;
  }
  
  public static Object field(Object obj, String fname)
  {
    return field.apply2(obj, fname);
  }
  
  public static Object staticField(Object obj, String fname)
  {
    return staticField.apply2(obj, fname);
  }
  

  public Object apply2(Object arg1, Object arg2)
  {
    String getName = null;String isName = null;
    String name; if ((arg2 instanceof gnu.bytecode.Field))
    {
      String fname = ((gnu.bytecode.Field)arg2).getName();
      name = gnu.expr.Mangling.demangleName(fname, true);
    } else {
      if ((arg2 instanceof gnu.bytecode.ClassType))
      {
        return arg2; }
      String fname;
      if ((arg2 instanceof gnu.bytecode.Method))
      {
        String mname = ((gnu.bytecode.Method)arg2).getName();
        String name = gnu.expr.Mangling.demangleName(mname, false);
        if (mname.startsWith("get")) {
          getName = mname;
        } else if (mname.startsWith("is"))
          isName = mname;
        fname = null;
      } else { String fname;
        if (((arg2 instanceof gnu.mapping.SimpleSymbol)) || ((arg2 instanceof CharSequence)))
        {
          String name = arg2.toString();
          fname = gnu.expr.Mangling.mangleNameIfNeeded(name);
        }
        else {
          throw new gnu.mapping.WrongType(this, 2, arg2, "string"); } } }
    String fname;
    String name; if ("class".equals(fname)) {
      fname = "class";
    } else if ("length".equals(fname))
      fname = "length";
    return getSlotValue(isStatic, arg1, name, fname, getName, isName, gnu.expr.Language.getDefaultLanguage());
  }
  









  public static Object getSlotValue(boolean isStatic, Object obj, String name, String fname, String getName, String isName, gnu.expr.Language language)
  {
    Class clas = isStatic ? coerceToClass(obj) : obj.getClass();
    if ((fname == "length") && (clas.isArray()))
    {
      int length = java.lang.reflect.Array.getLength(obj);
      
      return Integer.valueOf(length);
    }
    


    if (fname == "class")
      return clas;
    boolean illegalAccess = false;
    if (fname != null)
    {
      java.lang.reflect.Field field;
      try
      {
        field = clas.getField(fname);

      }
      catch (Exception ex)
      {
        Class[] memberClasses = clas.getClasses();
        int i = memberClasses.length; for (;;) { i--; if (i < 0)
            break;
          Class memberClass = memberClasses[i];
          if (memberClass.getSimpleName().equals(fname))
            return memberClass;
        }
        field = null;
      }
      if (field != null)
      {
        if ((isStatic) && ((field.getModifiers() & 0x8) == 0))
        {
          throw new RuntimeException("cannot access non-static field '" + fname + '\'');
        }
        try
        {
          return language.coerceToObject(field.getType(), field.get(obj));
        }
        catch (IllegalAccessException ex)
        {
          illegalAccess = true;
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
      }
    }
    

    try
    {
      String mname = null;
      java.lang.reflect.Method getmethod = null;
      try
      {
        mname = getName != null ? getName : gnu.expr.ClassExp.slotToMethodName("get", name);
        
        getmethod = clas.getMethod(mname, noClasses);
      } catch (Exception getEx) {
        mname = isName != null ? isName : gnu.expr.ClassExp.slotToMethodName("is", name);
        
        getmethod = clas.getMethod(mname, noClasses);
      }
      
      if ((isStatic) && ((getmethod.getModifiers() & 0x8) == 0))
      {
        throw new RuntimeException("cannot call non-static getter method '" + mname + '\'');
      }
      Object result = getmethod.invoke(obj, gnu.mapping.Values.noArgs);
      return language.coerceToObject(getmethod.getReturnType(), result);

    }
    catch (java.lang.reflect.InvocationTargetException ex)
    {
      gnu.mapping.WrappedException.rethrow(ex.getTargetException());
    }
    catch (IllegalAccessException ex)
    {
      illegalAccess = true;
    }
    catch (NoSuchMethodException ex) {}
    

    if (illegalAccess) {
      throw new RuntimeException("illegal access for field " + fname);
    }
    throw new RuntimeException("no such field " + fname + " in " + clas.getName());
  }
  

  static Class coerceToClass(Object obj)
  {
    if ((obj instanceof Class))
      return (Class)obj;
    if ((obj instanceof Type))
      return ((Type)obj).getReflectClass();
    throw new RuntimeException("argument is neither Class nor Type");
  }
  
  public void setN(Object[] args)
  {
    int nargs = args.length;
    if (nargs != 3)
      throw new gnu.mapping.WrongArguments(getSetter(), nargs);
    set2(args[0], args[1], args[2]);
  }
  
  public void set2(Object obj, Object name, Object value)
  {
    SlotSet.apply(isStatic, obj, (String)name, value);
  }
  





  public static gnu.bytecode.Member lookupMember(ObjectType clas, String name, gnu.bytecode.ClassType caller)
  {
    String mname = gnu.expr.Mangling.mangleNameIfNeeded(name);
    gnu.bytecode.Member member = clas.getField(mname, -1);
    if ((member == null) && ((clas instanceof gnu.bytecode.ClassType)))
      member = ((gnu.bytecode.ClassType)clas).getDeclaredClass(mname);
    if (member != null)
    {
      if (caller == null)
        caller = Type.pointer_type;
      if (caller.isAccessible(member, clas)) {
        return member;
      }
    }
    
    String getname = gnu.expr.ClassExp.slotToMethodName("get", name);
    gnu.bytecode.Method method = clas.getMethod(getname, Type.typeArray0);
    if (method == null) {
      method = clas.getMethod(gnu.expr.ClassExp.slotToMethodName("is", name), Type.typeArray0);
    }
    if (method == null) {
      return member;
    }
    return method;
  }
  
  public void compile(gnu.expr.ApplyExp exp, gnu.expr.Compilation comp, Target target)
  {
    Expression[] args = exp.getArgs();
    Expression arg0 = args[0];
    Expression arg1 = args[1];
    gnu.expr.Language language = comp.getLanguage();
    Type type = isStatic ? language.getTypeFor(arg0) : arg0.getType();
    
    gnu.bytecode.CodeAttr code = comp.getCode();
    
    if (((type instanceof ObjectType)) && ((arg1 instanceof gnu.expr.QuoteExp)))
    {
      ObjectType ctype = (ObjectType)type;
      Object part = ((gnu.expr.QuoteExp)arg1).getValue();
      if ((isStatic) && ((part instanceof gnu.mapping.SimpleSymbol)) && ("class".equals(((gnu.mapping.SimpleSymbol)part).getName())))
      {
        comp.loadClassRef((ObjectType)type);
        target.compileFromStack(comp, gnu.expr.Compilation.typeClass);
        return;
      }
      if ((part instanceof gnu.bytecode.Field))
      {
        gnu.bytecode.Field field = (gnu.bytecode.Field)part;
        int modifiers = field.getModifiers();
        boolean isStaticField = (modifiers & 0x8) != 0;
        args[0].compile(comp, isStaticField ? Target.Ignore : Target.pushValue(ctype));
        

        if (isStaticField)
        {
          boolean inlined = false;
          






























          if (!inlined) {
            code.emitGetStatic(field);
          }
        } else {
          code.emitGetField(field); }
        Type ftype = language.getLangTypeFor(field.getType());
        target.compileFromStack(comp, ftype);
        return;
      }
      if ((part instanceof gnu.bytecode.Method))
      {
        gnu.bytecode.Method method = (gnu.bytecode.Method)part;
        int modifiers = method.getModifiers();
        boolean isStaticMethod = method.getStaticFlag();
        args[0].compile(comp, isStaticMethod ? Target.Ignore : Target.pushValue(ctype));
        

        if (isStaticMethod) {
          code.emitInvokeStatic(method);
        } else
          code.emitInvoke(method);
        target.compileFromStack(comp, method.getReturnType());
        return;
      }
    }
    String name = ClassMethods.checkName(arg1);
    if (((type instanceof gnu.bytecode.ArrayType)) && ("length".equals(name)) && (!isStatic))
    {
      args[0].compile(comp, Target.pushValue(type));
      code.emitArrayLength();
      target.compileFromStack(comp, gnu.kawa.lispexpr.LangPrimType.intType);
      return;
    }
    gnu.expr.ApplyExp.compile(exp, comp, target);
  }
  
  public gnu.mapping.Procedure getSetter()
  {
    return setter == null ? super.getSetter() : setter;
  }
  






  public static gnu.expr.ApplyExp makeGetField(Expression value, String fieldName)
  {
    Expression[] args = new Expression[2];
    args[0] = value;
    args[1] = new gnu.expr.QuoteExp(fieldName);
    return new gnu.expr.ApplyExp(field, args);
  }
}
