package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.io.OutPort;

public class FluidLetExp
  extends LetExp
{
  public FluidLetExp() {}
  
  protected boolean mustCompile()
  {
    return true;
  }
  
  public void compile(Compilation comp, Target target) {
    CodeAttr code = comp.getCode();
    Type result_type = (target instanceof IgnoreTarget) ? null : getType();
    Target ttarg;
    Target ttarg;
    if (result_type == null) {
      ttarg = Target.Ignore; } else { Target ttarg;
      if (result_type == Type.pointer_type) {
        ttarg = Target.pushObject;
      } else
        ttarg = new StackTarget(result_type); }
    Scope scope = getVarScope();
    code.enterScope(scope);
    Variable ctx = scope.addVariable(code, Compilation.typeCallContext, null);
    comp.loadCallContext();
    code.emitStore(ctx);
    Variable[] save = new Variable[countDecls()];
    
    Declaration decl = firstDecl();
    doInits(decl, 0, save, comp, ctx);
    code.emitTryStart(true, result_type);
    body.compileWithPosition(comp, ttarg);
    code.emitFinallyStart();
    
    for (int i = 0; decl != null; decl = decl.nextDecl())
    {
      decl.load(null, 4, comp, Target.pushObject);
      
      code.emitLoad(save[i]);
      code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setRestore", 1));i++;
    }
    




    code.emitTryCatchEnd();
    popScope(code);
    if (result_type != null) {
      target.compileFromStack(comp, result_type);
    }
  }
  
  private void doInits(Declaration decl, int i, Variable[] save, Compilation comp, Variable ctx)
  {
    if (decl == null)
      return;
    CodeAttr code = comp.getCode();
    save[i] = code.addLocal(Type.pointer_type);
    decl.allocateVariable(code);
    base.load(null, 4, comp, Target.pushObject);
    
    code.emitDup();
    code.emitStore(decl.getVariable());
    decl.getInitValue().compile(comp, Target.pushObject);
    doInits(decl.nextDecl(), i + 1, save, comp, ctx);
    code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setWithSave", 1));
    
    code.emitStore(save[i]);
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitFluidLetExp(this, d);
  }
  
  public void print(OutPort out)
  {
    print(out, "(FluidLet", ")");
  }
}
