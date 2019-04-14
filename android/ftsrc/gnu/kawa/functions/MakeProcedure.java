package gnu.kawa.functions;

import gnu.expr.GenericProc;

public class MakeProcedure extends gnu.mapping.ProcedureN
{
  public static final MakeProcedure makeProcedure = new MakeProcedure("make-procedure");
  

  public MakeProcedure(String name)
  {
    super(name);
    setProperty(gnu.mapping.Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakeProcedure");
  }
  

  public static GenericProc makeProcedure$V(Object[] args)
  {
    return GenericProc.make(args);
  }
  
  public Object applyN(Object[] args)
  {
    return GenericProc.make(args);
  }
}
