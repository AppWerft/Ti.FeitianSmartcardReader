package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;

public class StaticSet extends gnu.mapping.Procedure1 implements gnu.expr.Inlineable
{
  ClassType ctype;
  String fname;
  gnu.bytecode.Field field;
  java.lang.reflect.Field reflectField;
  
  StaticSet(Class clas, String fname)
  {
    ctype = ((ClassType)Type.make(clas));
    this.fname = fname;
  }
  
  public StaticSet(ClassType ctype, String name, Type ftype, int flags)
  {
    this.ctype = ctype;
    fname = name;
    field = ctype.getField(name);
    if (field == null) {
      field = ctype.addField(name, ftype, flags);
    }
  }
  
  public Object apply1(Object arg1) {
    if (reflectField == null)
    {
      Class clas = ctype.getReflectClass();
      try
      {
        reflectField = clas.getField(fname);
      }
      catch (NoSuchFieldException ex)
      {
        throw new RuntimeException("no such field " + fname + " in " + clas.getName());
      }
    }
    
    try
    {
      reflectField.set(null, arg1);
      return gnu.mapping.Values.empty;
    }
    catch (IllegalAccessException ex)
    {
      throw new RuntimeException("illegal access for field " + fname);
    }
  }
  
  public void compile(gnu.expr.ApplyExp exp, Compilation comp, gnu.expr.Target target)
  {
    if (field == null)
    {
      field = ctype.getField(fname);
      if (field == null) {
        field = ctype.addField(fname, Type.make(reflectField.getType()), reflectField.getModifiers());
      }
    }
    exp.getArgs()[0].compile(comp, field.getType());
    gnu.bytecode.CodeAttr code = comp.getCode();
    code.emitPutStatic(field);
    comp.compileConstant(gnu.mapping.Values.empty, target);
  }
  
  public Type getReturnType(gnu.expr.Expression[] args)
  {
    return Type.voidType;
  }
}
