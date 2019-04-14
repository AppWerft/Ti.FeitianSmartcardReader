package gnu.expr;

import gnu.bytecode.Type;

public class IgnoreTarget extends Target { public IgnoreTarget() {}
  
  public Type getType() { return Type.voidType; }
  
  public void compileFromStack(Compilation comp, Type stackType) {
    if (!stackType.isVoid()) {
      gnu.bytecode.CodeAttr code = comp.getCode();
      if (code.reachableHere()) {
        code.emitPop(1);
      }
    }
  }
}
