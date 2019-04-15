package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.io.OutPort;
import gnu.mapping.CallContext;
import gnu.mapping.Values;




public class IfExp
  extends Expression
{
  Expression test;
  Expression then_clause;
  Expression else_clause;
  
  public IfExp(Expression i, Expression t, Expression e)
  {
    test = i;then_clause = t;else_clause = e;
  }
  
  public Expression getTest() { return test; }
  public Expression getThenClause() { return then_clause; }
  public Expression getElseClause() { return else_clause; }
  
  protected final Language getLanguage()
  {
    return Language.getDefaultLanguage();
  }
  
  protected boolean mustCompile() { return false; }
  
  public void apply(CallContext ctx) throws Throwable
  {
    if (getLanguage().isTrue(test.eval(ctx))) {
      then_clause.apply(ctx);
    } else if (else_clause != null) {
      else_clause.apply(ctx);
    }
  }
  
  Expression select(boolean truth) {
    return else_clause == null ? QuoteExp.voidExp : truth ? then_clause : else_clause;
  }
  


  public void compile(Compilation comp, Target target)
  {
    compile(test, then_clause, else_clause == null ? QuoteExp.voidExp : else_clause, comp, target);
  }
  




  public static void compile(Expression test, Expression then_clause, Expression else_clause, Compilation comp, Target target)
  {
    Language language = comp.getLanguage();
    CodeAttr code = comp.getCode();
    Label falseLabel = null;
    

    boolean falseInherited;
    
    if (((target instanceof ConditionalTarget)) && ((else_clause instanceof QuoteExp)))
    {

      boolean falseInherited = true;
      Object value = ((QuoteExp)else_clause).getValue();
      if (language.isTrue(value)) {
        falseLabel = ifTrue;
      } else {
        falseLabel = ifFalse;



      }
      



    }
    else
    {



      falseInherited = false; }
    if (falseLabel == null)
    {
      falseLabel = new Label(code);
    }
    Label trueLabel;
    boolean trueInherited;
    Label trueLabel;
    if ((test == then_clause) && ((target instanceof ConditionalTarget)) && ((then_clause instanceof ReferenceExp)))
    {

      boolean trueInherited = true;
      trueLabel = ifTrue;
    }
    else
    {
      trueInherited = false;
      trueLabel = new Label(code);
    }
    ConditionalTarget ctarget = new ConditionalTarget(trueLabel, falseLabel, language);
    
    if (trueInherited)
      trueBranchComesFirst = false;
    test.compile(comp, ctarget);
    code.emitIfThen();
    if ((!trueInherited) && (trueLabel.isUsed()))
    {
      trueLabel.define(code);
      


      Variable callContextSave = callContextVar;
      then_clause.compileWithPosition(comp, target);
      callContextVar = callContextSave;
    }
    if (!falseInherited)
    {
      code.emitElse();
      if (falseLabel.isUsed())
      {
        falseLabel.define(code);
        
        Variable callContextSave = callContextVar;
        if (else_clause == null) {
          comp.compileConstant(Values.empty, target);
        } else
          else_clause.compileWithPosition(comp, target);
        callContextVar = callContextSave;
      }
      else {
        code.setUnreachable();
      } }
    code.emitFi();
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitIfExp(this, d);
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d)
  {
    test = visitor.visitAndUpdate(test, d);
    if (exitValue == null)
      then_clause = visitor.visitAndUpdate(then_clause, d);
    if ((exitValue == null) && (else_clause != null)) {
      else_clause = visitor.visitAndUpdate(else_clause, d);
    }
  }
  
  protected Type calculateType() {
    Type t1 = then_clause.getType();
    Type t2 = else_clause == null ? Type.voidType : else_clause.getType();
    return Language.unionType(t1, t2);
  }
  
  public void print(OutPort out)
  {
    out.startLogicalBlock("(If ", false, ")");
    out.setIndentation(-2, false);
    test.print(out);
    out.writeSpaceLinear();
    then_clause.print(out);
    if (else_clause != null)
    {
      out.writeSpaceLinear();
      else_clause.print(out);
    }
    out.endLogicalBlock(")");
  }
}
