package gnu.bytecode;



public class TryState
{
  TryState previous;
  

  Label end_label;
  

  Label finally_subr;
  

  Variable finally_ret_addr;
  

  Variable saved_result;
  

  Variable[] savedStack;
  

  Label start_try;
  

  Label end_try;
  

  ClassType try_type;
  

  Type[] savedTypes;
  

  ExitableBlock exitCases;
  
  Variable exception;
  
  boolean tryClauseDone;
  

  public TryState(CodeAttr code)
  {
    previous = try_stack;
    try_stack = this;
    start_try = code.getLabel();
  }
  



  static TryState outerHandler(TryState innerTry, TryState outerTry)
  {
    while ((innerTry != outerTry) && ((finally_subr == null) || (tryClauseDone)))
      innerTry = previous;
    return innerTry;
  }
}
