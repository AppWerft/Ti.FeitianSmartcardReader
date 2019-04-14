package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;

public class SetFieldProc extends gnu.mapping.Procedure2 implements gnu.expr.Inlineable
{
  ClassType ctype;
  gnu.bytecode.Field field;
  
  public SetFieldProc(Class clas, String fname)
  {
    this((ClassType)Type.make(clas), fname);
  }
  
  public SetFieldProc(ClassType ctype, String fname)
  {
    this.ctype = ctype;
    field = gnu.bytecode.Field.searchField(ctype.getFields(), fname);
  }
  
  public SetFieldProc(ClassType ctype, String name, Type ftype, int flags)
  {
    this.ctype = ctype;
    field = ctype.getField(name);
    if (field == null) {
      field = ctype.addField(name, ftype, flags);
    }
  }
  
  public Object apply2(Object arg1, Object arg2)
  {
    try {
      java.lang.reflect.Field reflectField = field.getReflectField();
      arg2 = field.getType().coerceFromObject(arg2);
      reflectField.set(arg1, arg2);
    }
    catch (NoSuchFieldException ex)
    {
      throw new RuntimeException("no such field " + field.getSourceName() + " in " + ctype.getName());

    }
    catch (IllegalAccessException ex)
    {
      throw new RuntimeException("illegal access for field " + field.getSourceName());
    }
    
    return gnu.mapping.Values.empty;
  }
  
  public void compile(ApplyExp exp, gnu.expr.Compilation comp, gnu.expr.Target target)
  {
    ClassLoader loader = ctype.getReflectClass().getClassLoader();
    if ((loader instanceof gnu.bytecode.ArrayClassLoader))
    {
      ApplyExp.compile(exp, comp, target);
      return;
    }
    Expression[] args = exp.getArgs();
    args[0].compile(comp, ctype);
    args[1].compile(comp, field.getType());
    gnu.bytecode.CodeAttr code = comp.getCode();
    code.emitPutField(field);
    comp.compileConstant(gnu.mapping.Values.empty, target);
  }
  
  public Type getReturnType(Expression[] args)
  {
    return Type.voidType;
  }
}
