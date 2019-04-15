package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.util.IdentityHashTable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure0;
import gnu.text.SourceLocator;
import java.io.PrintWriter;

public abstract class Expression extends Procedure0 implements gnu.kawa.format.Printable, SourceLocator
{
  String filename;
  int position;
  
  public Expression() {}
  
  public final Object eval(CallContext ctx) throws Throwable
  {
    int start = ctx.startFromContext();
    try
    {
      match0(ctx);
      return ctx.getFromContext(start);
    }
    catch (Throwable ex)
    {
      ctx.cleanupFromContext(start);
      throw ex;
    }
  }
  
  public final Object eval(Environment env) throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    Environment saveEnv = Environment.setSaveCurrent(env);
    try
    {
      return eval(ctx);
    }
    finally
    {
      Environment.restoreCurrent(saveEnv);
    }
  }
  
  protected abstract boolean mustCompile();
  
  public final int match0(CallContext ctx)
  {
    proc = this;
    pc = 0;
    return 0;
  }
  
  public final Object apply0() throws Throwable
  {
    CallContext ctx = CallContext.getInstance();
    check0(ctx);
    return ctx.runUntilValue();
  }
  




  public void apply(CallContext ctx)
    throws Throwable
  {
    throw new RuntimeException("internal error - " + getClass() + ".eval called");
  }
  

  public final void print(Consumer out)
  {
    if ((out instanceof OutPort)) {
      print((OutPort)out);
    } else if ((out instanceof PrintWriter))
    {
      OutPort port = new OutPort((PrintWriter)out);
      print(port);
      port.close();
    }
    else
    {
      CharArrayOutPort port = new CharArrayOutPort();
      print(port);
      port.close();
      port.writeTo(out);
    }
  }
  


  public abstract void print(OutPort paramOutPort);
  


  public void printLineColumn(OutPort out)
  {
    int line = getLineNumber();
    if (line > 0)
    {
      out.print("line:");
      out.print(line);
      int column = getColumnNumber();
      if (column > 0)
      {
        out.print(':');
        out.print(column);
      }
      out.writeSpaceFill();
    }
  }
  

  public abstract void compile(Compilation paramCompilation, Target paramTarget);
  
  public final void compileWithPosition(Compilation comp, Target target)
  {
    compileWithPosition(comp, target, this);
  }
  


  public final void compileWithPosition(Compilation comp, Target target, Expression position)
  {
    CodeAttr code = comp.getCode();
    if (!code.reachableHere())
      return;
    int line = position.getLineNumber();
    if (line > 0) {
      code.putLineNumber(position.getFileName(), line);
      String saveFilename = comp.getFileName();
      int saveLine = comp.getLineNumber();
      int saveColumn = comp.getColumnNumber();
      comp.setLine(position);
      compile(comp, target);
      



      comp.setLine(saveFilename, saveLine, saveColumn);
    } else {
      compile(comp, target);
    }
  }
  
  public final void compile(Compilation comp, Type type)
  {
    compile(comp, StackTarget.getInstance(type));
  }
  





  public final void compile(Compilation comp, Declaration lhs)
  {
    compile(comp, CheckedTarget.getInstance(lhs));
  }
  






  public static Expression deepCopy(Expression exp, IdentityHashTable mapper)
  {
    if (exp == null)
      return null;
    Object tr = mapper.get(exp);
    if (tr != null) return (Expression)tr;
    Expression copy = exp.deepCopy(mapper);
    mapper.put(exp, copy);
    return copy;
  }
  

  public static Expression[] deepCopy(Expression[] exps, IdentityHashTable mapper)
  {
    if (exps == null)
      return null;
    int nargs = exps.length;
    Expression[] a = new Expression[nargs];
    for (int i = 0; i < nargs; i++)
    {
      Expression ei = exps[i];
      Expression ai = deepCopy(ei, mapper);
      if ((ai == null) && (ei != null))
        return null;
      a[i] = ai;
    }
    return a;
  }
  
  protected static Expression deepCopy(Expression exp)
  {
    return deepCopy(exp, new IdentityHashTable());
  }
  
  protected Expression deepCopy(IdentityHashTable mapper)
  {
    return null;
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitExpression(this, d);
  }
  





  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d) {}
  





  public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl)
  {
    args = visitor.visitExps(args, null);
    return exp;
  }
  



  public static final Expression[] noExpressions = new Expression[0];
  protected Type type;
  protected int flags;
  
  public static Expression makeWhile(Object cond, Object body, Compilation parser) {
    parser.loopStart();
    parser.loopEnter();
    parser.loopCond(parser.parse(cond));
    parser.loopBody(parser.parse(body));
    return parser.loopRepeatDone(new Expression[0]);
  }
  

  public final void setLocation(SourceLocator location)
  {
    filename = location.getFileName();
    setLine(location.getLineNumber(), location.getColumnNumber());
  }
  
  public final Expression setLine(Expression old)
  {
    setLocation(old);
    return this;
  }
  
  public final Expression maybeSetLine(Expression old) {
    if ((position == 0) && (old != null) && (position != 0))
      setLocation(old);
    return this;
  }
  
  public final void setFile(String filename)
  {
    this.filename = filename;
  }
  
  public final void setLine(int lineno, int colno)
  {
    if (lineno < 0)
      lineno = 0;
    if (colno < 0)
      colno = 0;
    position = ((lineno << 12) + colno);
  }
  
  public final void setLine(int lineno)
  {
    setLine(lineno, 0);
  }
  
  public final String getFileName()
  {
    return filename;
  }
  

  public void setLine(Compilation comp)
  {
    int line = comp.getLineNumber();
    if (line > 0)
    {
      setFile(comp.getFileName());
      setLine(line, comp.getColumnNumber());
    }
  }
  
  public String getPublicId()
  {
    return null;
  }
  
  public String getSystemId()
  {
    return filename;
  }
  


  public final int getLineNumber()
  {
    int line = position >> 12;
    return line == 0 ? -1 : line;
  }
  
  public final int getColumnNumber()
  {
    int column = position & 0xFFF;
    return column == 0 ? -1 : column;
  }
  
  public boolean isStableSourceLocation() { return true; }
  



  public final Type getType()
  {
    if (type == null)
    {
      type = Type.objectType;
      type = calculateType();
    }
    return type;
  }
  
  protected Type calculateType()
  {
    return Type.pointer_type;
  }
  
  public final Type getTypeRaw() {
    return type;
  }
  
  public void setType(Type type) {
    this.type = type;
  }
  



  public boolean neverReturns()
  {
    return getType() == Type.neverReturnsType;
  }
  



  public Keyword checkLiteralKeyword()
  {
    if ((this instanceof QuoteExp)) {
      Object val = ((QuoteExp)this).getValue();
      if ((val instanceof Keyword))
        return (Keyword)val;
    }
    return null;
  }
  
  public boolean isSingleValue()
  {
    return OccurrenceType.itemCountIsOne(getType());
  }
  

  public Object valueIfConstant()
  {
    return null;
  }
  

  public static final int VALIDATED = 1;
  
  protected static final int NEXT_AVAIL_FLAG = 2;
  public void setFlag(boolean setting, int flag)
  {
    if (setting) flags |= flag; else {
      flags &= (flag ^ 0xFFFFFFFF);
    }
  }
  
  public void setFlag(int flag) {
    flags |= flag;
  }
  
  public int getFlags()
  {
    return flags;
  }
  
  public boolean getFlag(int flag)
  {
    return (flags & flag) != 0;
  }
  
  public boolean side_effects() {
    return true;
  }
  
  public String toString() {
    String tname = getClass().getName();
    if (tname.startsWith("gnu.expr."))
      tname = tname.substring(9);
    return tname + "@" + Integer.toHexString(hashCode());
  }
}
