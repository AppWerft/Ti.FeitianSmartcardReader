package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;

public class ThisExp
  extends ReferenceExp
{
  public static final String THIS_NAME = new String("$this$");
  



  static int EVAL_TO_CONTEXT = 4;
  

  ScopeExp context;
  

  public final boolean isForContext()
  {
    return (flags & EVAL_TO_CONTEXT) != 0;
  }
  
  public void apply(CallContext ctx)
    throws Throwable
  {
    if (isForContext()) {
      ctx.writeValue(context);
    } else
      super.apply(ctx);
  }
  
  public ScopeExp getContextScope() { return context; }
  
  public ThisExp()
  {
    super(THIS_NAME);
  }
  
  public ThisExp(ScopeExp context)
  {
    this();
    this.context = context;
  }
  
  public ThisExp(Declaration binding)
  {
    super(THIS_NAME, binding);
  }
  
  public ThisExp(ClassType type)
  {
    this(new Declaration(THIS_NAME, type));
  }
  
  public static ThisExp makeGivingContext(ScopeExp context)
  {
    ThisExp exp = new ThisExp(context);
    flags |= EVAL_TO_CONTEXT;
    return exp;
  }
  
  public void compile(Compilation comp, Target target)
  {
    if ((target instanceof IgnoreTarget))
      return;
    if (isForContext())
    {

      CodeAttr code = comp.getCode();
      ModuleExp module;
      if (((context instanceof ModuleExp)) && ((module = (ModuleExp)context).staticInitRun()))
      {
        code.emitPushString(module.getMinfo().getClassName());
      } else if (method.getStaticFlag()) {
        code.emitGetStatic(moduleInstanceMainField);
      } else
        code.emitPushThis();
      target.compileFromStack(comp, getType());
    }
    else
    {
      super.compile(comp, target);
    }
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitThisExp(this, d);
  }
  
  protected final Type calculateType()
  {
    if (binding != null)
      return binding.getType();
    if (((context instanceof ClassExp)) || ((context instanceof ModuleExp)))
      return context.getType();
    return Type.pointer_type;
  }
}
