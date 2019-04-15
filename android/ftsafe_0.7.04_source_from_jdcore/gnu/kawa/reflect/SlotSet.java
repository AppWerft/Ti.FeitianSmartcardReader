package gnu.kawa.reflect;

import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Language;

public class SlotSet extends gnu.mapping.Procedure3 implements gnu.expr.Inlineable
{
  boolean isStatic;
  public static final SlotSet set$Mnfield$Ex = new SlotSet("set-field!", false);
  public static final SlotSet set$Mnstatic$Mnfield$Ex = new SlotSet("set-static-field!", true);
  

  public SlotSet(String name, boolean isStatic)
  {
    super(name);
    this.isStatic = isStatic;
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotSet");
  }
  

  public static void setField(Object obj, String name, Object value)
  {
    apply(false, obj, name, value);
  }
  
  public static void setStaticField(Object obj, String name, Object value)
  {
    apply(true, obj, name, value);
  }
  
  public static void apply(boolean isStatic, Object obj, Object member, Object value)
  {
    Language language = Language.getDefaultLanguage();
    boolean illegalAccess = false;
    Class clas;
    String name;
    String fname;
    Class clas; if (((member instanceof CharSequence)) || ((member instanceof gnu.mapping.SimpleSymbol)))
    {
      String name = member.toString();
      String fname = gnu.expr.Mangling.mangleNameIfNeeded(name);
      clas = isStatic ? SlotGet.coerceToClass(obj) : obj.getClass();
    }
    else {
      fname = name = ((gnu.bytecode.Member)member).getName();
      clas = null;
    }
    try
    {
      java.lang.reflect.Field field = (member instanceof gnu.bytecode.Field) ? ((gnu.bytecode.Field)member).getReflectField() : clas.getField(fname);
      

      Class ftype = field.getType();
      
      field.set(obj, language.coerceFromObject(ftype, value));
      return;


    }
    catch (NoSuchFieldException ex) {}catch (IllegalAccessException ex)
    {

      illegalAccess = true;
    }
    


    try
    {
      java.lang.reflect.Method getmethod = null;
      
      boolean haveSetter = member instanceof gnu.bytecode.Method;
      String setName = haveSetter ? fname : gnu.expr.ClassExp.slotToMethodName("set", name);
      
      if ((haveSetter) && (!setName.startsWith("set"))) {
        haveSetter = false;
      }
      try {
        String getName = haveSetter ? "get" + setName.substring(3) : gnu.expr.ClassExp.slotToMethodName("get", name);
        
        getmethod = clas.getMethod(getName, SlotGet.noClasses);
      } catch (Exception getEx) {
        String getName = haveSetter ? "is" + setName.substring(3) : gnu.expr.ClassExp.slotToMethodName("is", name);
        
        getmethod = clas.getMethod(getName, SlotGet.noClasses);
      }
      
      Class[] setArgTypes = new Class[1];
      setArgTypes[0] = getmethod.getReturnType();
      java.lang.reflect.Method setmethod = clas.getMethod(setName, setArgTypes);
      

      Object[] args = { language.coerceFromObject(setArgTypes[0], value) };
      setmethod.invoke(obj, args);
      return;
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
      throw new RuntimeException("illegal access for field " + name);
    }
    throw new RuntimeException("no such field " + name + " in " + clas.getName());
  }
  

  public Object apply3(Object obj, Object fname, Object value)
  {
    apply(isStatic, obj, fname, value);
    return gnu.mapping.Values.empty;
  }
  
  static final Type[] type1Array = new Type[1];
  









  public static gnu.bytecode.Member lookupMember(ObjectType clas, String name, gnu.bytecode.ClassType caller)
  {
    gnu.bytecode.Field field = clas.getField(gnu.expr.Mangling.mangleNameIfNeeded(name), -1);
    
    if (field != null)
    {
      if (caller == null)
        caller = Type.pointer_type;
      if (caller.isAccessible(field, clas)) {
        return field;
      }
    }
    String setName = gnu.expr.ClassExp.slotToMethodName("set", name);
    gnu.bytecode.Method method = clas.getMethod(setName, type1Array);
    if (method == null) {
      return field;
    }
    return method;
  }
  
  public void compile(gnu.expr.ApplyExp exp, Compilation comp, gnu.expr.Target target)
  {
    Expression[] args = exp.getArgs();
    int nargs = args.length;
    Expression arg0 = args[0];
    Expression arg1 = args[1];
    Expression value = args[2];
    Type type = isStatic ? kawa.standard.Scheme.exp2Type(arg0) : arg0.getType();
    
    if (((type instanceof ObjectType)) && ((arg1 instanceof gnu.expr.QuoteExp)))
    {
      Object val1 = ((gnu.expr.QuoteExp)arg1).getValue();
      ObjectType ctype = (ObjectType)type;
      if ((val1 instanceof gnu.bytecode.Field))
      {
        gnu.bytecode.Field field = (gnu.bytecode.Field)val1;
        gnu.bytecode.CodeAttr code = comp.getCode();
        int modifiers = field.getModifiers();
        boolean isStaticField = (modifiers & 0x8) != 0;
        args[0].compile(comp, isStaticField ? gnu.expr.Target.Ignore : gnu.expr.Target.pushValue(ctype));
        

        Type ftype = comp.getLanguage().getLangTypeFor(field.getType());
        args[2].compile(comp, gnu.expr.CheckedTarget.getInstance(ftype));
        if (isStaticField) {
          code.emitPutStatic(field);
        } else
          code.emitPutField(field);
        comp.compileConstant(gnu.mapping.Values.empty, target);
        return;
      }
    }
    gnu.expr.ApplyExp.compile(exp, comp, target);
  }
}
