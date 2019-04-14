package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.text.Options;
import java.util.Vector;

















public class BeginExp
  extends Expression
{
  Expression[] exps;
  int length;
  Vector compileOptions;
  
  public BeginExp() {}
  
  public BeginExp(Expression[] ex)
  {
    exps = ex;length = ex.length;
  }
  
  public BeginExp(Expression exp0, Expression exp1) {
    exps = new Expression[2];
    exps[0] = exp0;
    exps[1] = exp1;
    length = 2;
  }
  



  public static final Expression canonicalize(Expression exp)
  {
    if ((exp instanceof BeginExp))
    {
      BeginExp bexp = (BeginExp)exp;
      if (compileOptions != null)
        return exp;
      int len = length;
      if (len == 0)
        return QuoteExp.voidExp;
      if (len == 1)
        return canonicalize(exps[0]);
    }
    return exp;
  }
  
  public static final Expression canonicalize(Expression[] exps)
  {
    int len = exps.length;
    if (len == 0)
      return QuoteExp.voidExp;
    if (len == 1)
      return canonicalize(exps[0]);
    return new BeginExp(exps);
  }
  
  public final void add(Expression exp)
  {
    if (exps == null)
      exps = new Expression[8];
    if (length == exps.length)
    {
      Expression[] ex = new Expression[2 * length];
      System.arraycopy(exps, 0, ex, 0, length);
      exps = ex;
    }
    exps[(length++)] = exp;
  }
  
  public final Expression[] getExpressions() { return exps; }
  public final int getExpressionCount() { return length; }
  
  public final void setExpressions(Expression[] exps)
  {
    this.exps = exps;
    length = exps.length;
  }
  
  public void setCompileOptions(Vector options)
  {
    compileOptions = options;
  }
  
  protected boolean mustCompile() { return false; }
  
  public void apply(CallContext ctx) throws Throwable
  {
    int n = length;
    
    Consumer consumerSave = consumer;
    consumer = VoidConsumer.instance;
    int i;
    try {
      for (i = 0; i < n - 1; i++) {
        exps[i].eval(ctx);
      }
    }
    finally {
      consumer = consumerSave;
    }
    exps[i].apply(ctx);
  }
  
  public void pushOptions(Compilation comp)
  {
    if ((compileOptions != null) && (comp != null)) {
      currentOptions.pushOptionValues(compileOptions);
    }
  }
  
  public void popOptions(Compilation comp) {
    if ((compileOptions != null) && (comp != null)) {
      currentOptions.popOptionValues(compileOptions);
    }
  }
  
  public void compile(Compilation comp, Target target) {
    pushOptions(comp);
    try
    {
      int n = length;
      CodeAttr code = comp.getCode();
      for (int i = 0; i < n - 1;)
      {
        exps[i].compileWithPosition(comp, Target.Ignore);
        if (!code.reachableHere())
        {
          if (comp.warnUnreachable()) {
            comp.error('w', "unreachable code", exps[(i + 1)]);
          }
          return;
        }
        i++;
      }
      







      exps[i].compileWithPosition(comp, target);
    }
    finally
    {
      popOptions(comp);
    }
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    pushOptions(comp);
    try
    {
      return visitor.visitBeginExp(this, d);
    }
    finally
    {
      popOptions(comp);
    }
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d)
  {
    exps = visitor.visitExps(exps, length, d);
  }
  
  public void print(OutPort out)
  {
    out.startLogicalBlock("(Begin", ")", 2);
    out.writeSpaceFill();
    printLineColumn(out);
    if (compileOptions != null)
    {
      out.writeSpaceFill();
      out.startLogicalBlock("(CompileOptions", ")", 2);
      int sizeOptions = compileOptions.size();
      for (int i = 0; i < sizeOptions; i += 3)
      {
        Object key = compileOptions.elementAt(i);
        Object value = compileOptions.elementAt(i + 2);
        out.writeSpaceFill();
        out.startLogicalBlock("", "", 2);
        out.print(key);out.print(':');
        out.writeSpaceLinear();
        out.print(value);
        out.endLogicalBlock("");
      }
      out.endLogicalBlock(")");
    }
    int n = length;
    for (int i = 0; i < n; i++)
    {
      out.writeSpaceLinear();
      exps[i].print(out);
    }
    out.endLogicalBlock(")");
  }
  
  protected Type calculateType()
  {
    return exps[(length - 1)].getType();
  }
}
