package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;

public class CatchClause
  extends LetExp
{
  CatchClause next;
  
  public CatchClause() {}
  
  public CatchClause(Declaration decl, Expression body)
  {
    decl.setInitValue(QuoteExp.undefined_exp);
    add(decl);
    this.body = body;
  }
  
  public CatchClause(Object name, Type type, Expression body) {
    this(new Declaration(name, type), body);
  }
  
  public CatchClause(LambdaExp lexp)
  {
    this();
    Declaration decl = lexp.firstDecl();
    decl.setInitValue(QuoteExp.undefined_exp);
    lexp.remove(null, decl);
    add(decl);
    body = body;
  }
  
  public final CatchClause getNext() { return next; }
  public final void setNext(CatchClause next) { this.next = next; }
  
  public final Expression getBody() { return body; }
  public final void setBody(Expression body) { this.body = body; }
  
  protected boolean mustCompile() { return false; }
  

  protected Object evalVariable(Declaration decl, CallContext ctx)
    throws Throwable
  {
    return value1;
  }
  
  public void compile(Compilation comp, Target target)
  {
    CodeAttr code = comp.getCode();
    Declaration catchDecl = firstDecl();
    if (catchDecl.isSimple())
      catchDecl.allocateVariable(code);
    code.enterScope(getVarScope());
    code.emitCatchStart((ClassType)catchDecl.getType());
    catchDecl.compileStore(comp);
    body.compileWithPosition(comp, target);
    code.emitCatchEnd();
    code.popScope();
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d)
  {
    body = visitor.visitAndUpdate(body, d);
  }
  
  public void print(OutPort out)
  {
    out.writeSpaceLinear();
    out.startLogicalBlock("(Catch", ")", 2);
    out.writeSpaceFill();
    decls.printInfo(out);
    out.writeSpaceLinear();
    body.print(out);
    out.endLogicalBlock(")");
  }
}
