package gnu.bytecode;




public class ExitableBlock
{
  Variable resultVariable;
  


  CodeAttr code;
  


  Type resultType;
  


  TryState initialTryState;
  


  Label endLabel;
  


  ExitableBlock outer;
  


  TryState currentTryState;
  


  ExitableBlock nextCase;
  

  int switchCase;
  

  int startStackSize;
  


  ExitableBlock(Type resultType, CodeAttr code, boolean runFinallyBlocks)
  {
    this.code = code;
    this.resultType = resultType;
    startStackSize = SP;
    initialTryState = try_stack;
    if ((runFinallyBlocks) && (resultType != null))
    {
      code.pushScope();
      Variable var = code.addLocal(resultType);
      resultVariable = var;
      
      code.emitStoreDefaultValue(var);
      switchCase = (++exitableBlockLevel);
    }
    endLabel = new Label(code);
  }
  
  void finish()
  {
    boolean reachable = code.reachableHere();
    if ((resultVariable != null) && (reachable))
      code.emitStore(resultVariable);
    endLabel.define(code);
    if ((!reachable) && (!endLabel.needsStackMapEntry)) {
      code.setUnreachable();
    } else if (resultVariable != null)
      code.emitLoad(resultVariable);
    if (resultVariable != null)
    {
      code.popScope();
      code.exitableBlockLevel -= 1;
    }
  }
  


  public void exit()
  {
    if (resultVariable != null)
      code.emitStore(resultVariable);
    exit(TryState.outerHandler(code.try_stack, initialTryState));
  }
  



  public Label exitIsGoto()
  {
    if (TryState.outerHandler(code.try_stack, initialTryState) == initialTryState) {
      return endLabel;
    }
    return null;
  }
  
  private void popStack(CodeAttr code) {
    int retSize = resultType.size > 4 ? 2 : (resultVariable != null) || (resultType == null) ? 0 : 1;
    
    if (SP == startStackSize + retSize)
      return;
    Variable resultVar;
    if (retSize > 0) {
      code.pushScope();
      Variable resultVar = code.addLocal(resultType);
      code.emitStore(resultVar);
    }
    else {
      resultVar = null; }
    code.emitPop(SP - startStackSize);
    if (resultVar != null) {
      code.emitLoad(resultVar);
      code.popScope();
    }
  }
  

  void exit(TryState activeTry)
  {
    if (!code.reachableHere())
      return;
    popStack(code);
    if (activeTry == initialTryState) {
      code.emitGoto(endLabel);
    } else if (code.useJsr())
    {
      for (TryState stack = code.try_stack; 
          stack != initialTryState; stack = previous)
      {
        if ((finally_subr != null) && (finally_ret_addr == null))
        {

          code.emitJsr(finally_subr);
        }
      }
      code.emitGoto(endLabel);
    }
    else
    {
      if (currentTryState == null)
        linkCase(activeTry);
      if (saved_result != null)
        code.emitStoreDefaultValue(saved_result);
      code.emitPushInt(switchCase);
      code.emitPushNull();
      code.emitGoto(finally_subr);
    }
  }
  
  void linkCase(TryState tryState)
  {
    if (currentTryState != tryState)
    {
      if (currentTryState != null)
        throw new Error();
      nextCase = exitCases;
      exitCases = this;
      currentTryState = tryState;
    }
  }
}
