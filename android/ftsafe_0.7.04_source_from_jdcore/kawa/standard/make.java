package kawa.standard;

import gnu.bytecode.ClassType;

public class make extends gnu.mapping.ProcedureN {
  public make() {}
  
  public int numArgs() { return 61441; }
  
  public Object applyN(Object[] args)
  {
    int nargs = args.length;
    if (nargs == 0)
      throw new gnu.mapping.WrongArguments(this, nargs);
    Object arg_0 = args[0];
    Class clas;
    Class clas; if ((arg_0 instanceof Class)) {
      clas = (Class)arg_0; } else { Class clas;
      if ((arg_0 instanceof ClassType)) {
        clas = ((ClassType)arg_0).getReflectClass();
      } else
        clas = null; }
    if (clas == null) {
      throw new gnu.mapping.WrongType(this, 1, arg_0, "class");
    }
    Object result;
    try {
      result = clas.newInstance();
    }
    catch (Exception ex)
    {
      throw new gnu.mapping.WrappedException(ex);
    }
    for (int i = 1; i < nargs;)
    {
      gnu.expr.Keyword key = (gnu.expr.Keyword)args[(i++)];
      Object arg = args[(i++)];
      kawa.lang.Record.set1(arg, key.getName(), result);
    }
    return result;
  }
}
