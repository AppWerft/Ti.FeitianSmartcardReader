package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;








public class BlockExp
  extends Expression
{
  Declaration label;
  Expression body;
  Expression exitBody;
  boolean runFinallyBlocks = true;
  
  public BlockExp() {}
  
  public void setBody(Expression body) { this.body = body; }
  

  public void setBody(Expression body, Expression exitBody)
  {
    this.body = body;
    this.exitBody = exitBody;
  }
  
  public void setRunFinallyBlocks(boolean value) {
    runFinallyBlocks = value;
  }
  
  public void setLabel(Declaration label)
  {
    this.label = label;
  }
  

  ExitableBlock exitableBlock;
  Target exitTarget;
  protected boolean mustCompile()
  {
    return false;
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    Object result;
    try {
      result = body.eval(ctx);
    }
    catch (BlockExitException ex)
    {
      if (exit.block != this)
        throw ex;
      result = exit.result;
      if (exitBody != null)
        result = exitBody.eval(ctx);
    }
    ctx.writeValue(result);
  }
  
  public void compile(Compilation comp, Target target)
  {
    CodeAttr code = comp.getCode();
    Type rtype = (exitBody == null) && ((target instanceof StackTarget)) ? target.getType() : null;
    

    ExitableBlock bl = code.startExitableBlock(rtype, runFinallyBlocks);
    exitableBlock = bl;
    exitTarget = (exitBody == null ? target : Target.Ignore);
    body.compileWithPosition(comp, target);
    Label doneLabel;
    if ((exitBody != null) && (code.reachableHere()))
    {
      Label doneLabel = new Label(code);
      code.emitGoto(doneLabel);
    }
    else {
      doneLabel = null; }
    code.endExitableBlock();
    if (exitBody != null)
      exitBody.compileWithPosition(comp, target);
    if (doneLabel != null) {
      doneLabel.define(code);
    }
    exitableBlock = null;
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitBlockExp(this, d);
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d)
  {
    body = visitor.visitAndUpdate(body, d);
    if ((exitValue == null) && (exitBody != null))
      exitBody = visitor.visitAndUpdate(exitBody, d);
  }
  
  int id = ++counter;
  
  public String toString() { return "BlockExp#" + id; }
  
  static int counter;
  public void print(OutPort out) {
    out.startLogicalBlock("(Block#", ")", 2);
    out.print(id);
    if (label != null)
    {
      out.print(' ');
      out.print(label.getName());
    }
    out.writeSpaceLinear();
    body.print(out);
    if (exitBody != null)
    {
      out.writeSpaceLinear();
      out.print("else ");
      exitBody.print(out);
    }
    out.endLogicalBlock(")");
  }
}
