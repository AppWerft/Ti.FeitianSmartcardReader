package gnu.kawa.reflect;

import gnu.expr.Compilation;

public class Throw extends gnu.mapping.Procedure1 implements gnu.expr.Inlineable
{
  public static final Throw primitiveThrow = new Throw("throw");
  
  public Throw(String name) {
    super(name);
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateThrow");
  }
  
  public static void doThrow(Object arg1) throws Throwable
  {
    throw ((Throwable)arg1);
  }
  
  public Object apply1(Object arg1) throws Throwable {
    doThrow(arg1);
    return gnu.mapping.Values.empty;
  }
  
  public void compile(gnu.expr.ApplyExp exp, Compilation comp, gnu.expr.Target target) {
    exp.getArgs()[0].compile(comp, gnu.bytecode.Type.javalangThrowableType);
    comp.getCode().emitThrow();
  }
}
