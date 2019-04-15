package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;

public class ObjectExp extends ClassExp
{
  public ObjectExp()
  {
    super(true, new ClassType());
  }
  
  protected Type calculateType() { return compiledType; }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitObjectExp(this, d);
  }
  
  public void compile(Compilation comp, Target target)
  {
    CodeAttr code = comp.getCode();
    code.emitNew(compiledType);
    code.emitDup(1);
    Method init = Compilation.getConstructor(compiledType, this);
    if (closureEnvField != null)
    {
      LambdaExp caller = outerLambda();
      if (!comp.usingCallContext()) {
        getOwningLambda().loadHeapFrame(comp);
      } else {
        Variable closureEnv = heapFrame != null ? heapFrame : closureEnv;
        
        if (closureEnv == null) {
          code.emitPushThis();
        } else
          code.emitLoad(closureEnv);
      }
    }
    code.emitInvokeSpecial(init);
    
    target.compileFromStack(comp, getCompiledClassType(comp));
  }
}
