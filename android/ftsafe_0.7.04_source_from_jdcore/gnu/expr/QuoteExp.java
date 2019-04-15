package gnu.expr;

import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;


public class QuoteExp
  extends Expression
{
  Object value;
  public static final int EXPLICITLY_TYPED = 2;
  public static final int SHARED_CONSTANT = 4;
  public static final int IS_KEYWORD = 8;
  
  public final Object getValue() { return value; }
  
  public final Object valueIfConstant() { return value; }
  




  public final Type getRawType() { return type; }
  
  protected final Type calculateType() {
    if (value == Values.empty)
      return Type.voidType;
    if (value == null)
      return Type.nullType;
    if ((value instanceof Class))
      return new gnu.bytecode.ParameterizedType(Type.javalangClassType, new Type[] { Type.make((Class)value) });
    if (this == undefined_exp) {
      return Type.pointer_type;
    }
    return Type.make(value.getClass());
  }
  
  public void setType(Type type)
  {
    super.setType(type);
    setFlag(2);
  }
  
  public boolean isExplicitlyTyped()
  {
    return getFlag(2);
  }
  
  public boolean isSharedConstant()
  {
    return getFlag(4);
  }
  
  public static QuoteExp undefined_exp = makeShared(Special.undefined);
  public static QuoteExp abstractExp = makeShared(Special.abstractSpecial);
  public static QuoteExp nativeExp = makeShared(Special.nativeSpecial);
  public static QuoteExp voidExp = makeShared(Values.empty, Type.voidType);
  
  public static QuoteExp voidObjectExp = makeShared(Values.empty, Type.objectType);
  public static QuoteExp trueExp = makeShared(Boolean.TRUE, Type.booleanType);
  public static QuoteExp falseExp = makeShared(Boolean.FALSE, Type.booleanType);
  public static QuoteExp trueObjExp = makeShared(Boolean.TRUE);
  public static QuoteExp falseObjExp = makeShared(Boolean.FALSE);
  public static QuoteExp emptyExp = makeShared(gnu.lists.LList.Empty);
  public static QuoteExp nullExp = makeShared(null, Type.nullType);
  public static final QuoteExp classObjectExp = makeShared(Type.objectType);
  
  public static QuoteExp getInstance(Object value)
  {
    return getInstance(value, null);
  }
  
  public static QuoteExp getInstance(Object value, gnu.text.SourceLocator position)
  {
    if (value == null)
      return nullExp;
    if (value == Type.pointer_type)
      return classObjectExp;
    if (value == Special.undefined)
      return undefined_exp;
    if (value == Values.empty) {
      return voidExp;
    }
    if ((value instanceof Boolean))
      return ((Boolean)value).booleanValue() ? trueObjExp : falseObjExp;
    QuoteExp q = new QuoteExp(value);
    if (position != null)
      q.setLocation(position);
    return q;
  }
  
  static QuoteExp makeShared(Object value)
  {
    QuoteExp exp = new QuoteExp(value);
    exp.setFlag(4);
    return exp;
  }
  
  public static QuoteExp makeShared(Object value, Type type)
  {
    QuoteExp exp = new QuoteExp(value, type);
    exp.setFlag(4);
    return exp;
  }
  
  public QuoteExp(Object val) { value = val; }
  
  public QuoteExp(Object val, Type type) { value = val;setType(type); }
  
  protected boolean mustCompile() { return false; }
  
  public void apply(gnu.mapping.CallContext ctx)
  {
    ctx.writeValue(value);
  }
  
  public void compile(Compilation comp, Target target) {
    Type targetType;
    if ((type == null) || (type == Type.pointer_type) || ((target instanceof IgnoreTarget)) || (((type instanceof gnu.bytecode.ObjectType)) && (type.isInstance(value))) || (((type instanceof gnu.bytecode.PrimType)) && (((targetType = target.getType()) == Type.objectType) || (targetType == ((gnu.bytecode.PrimType)type).boxedType()))))
    {







      comp.compileConstant(value, target);
    } else {
      Type vtype = type.isVoid() ? Type.objectType : type;
      comp.compileConstant(value, StackTarget.getInstance(vtype));
      target.compileFromStack(comp, vtype);
    }
  }
  
  public Expression deepCopy(gnu.kawa.util.IdentityHashTable mapper)
  {
    return this;
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitQuoteExp(this, d);
  }
  

  public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl)
  {
    if (this == undefined_exp)
      return exp;
    Object fval = getValue();
    if (!(fval instanceof gnu.mapping.Procedure)) {
      return visitor.noteError("calling " + decl.getName() + " which is a " + fval.getClass().getName());
    }
    
    gnu.mapping.Procedure proc = (gnu.mapping.Procedure)fval;
    int nargs = exp.getArgCount();
    int spliceCount = exp.spliceCount();
    String msg = gnu.mapping.WrongArguments.checkArgCount(proc, nargs - spliceCount, spliceCount > 0);
    
    if (msg != null)
      return visitor.noteError(msg);
    Expression inlined = visitor.maybeInline(exp, required, proc);
    if (inlined != null)
      return inlined;
    Expression[] args = args;
    MethodProc asMProc = (proc instanceof MethodProc) ? (MethodProc)proc : null;
    



    for (int i = 0; i < nargs; i++)
    {
      Type ptype = asMProc != null ? asMProc.getParameterType(i) : null;
      
      if ((i == nargs - 1) && (ptype != null) && (asMProc.maxArgs() < 0) && (i == asMProc.minArgs()))
      {
        ptype = null; }
      args[i] = visitor.visit(args[i], InlineCalls.ValueNeededType.make(ptype));
    }
    
    Compilation comp = visitor.getCompilation();
    if (exp.getFlag(4))
    {
      Expression e = exp.inlineIfConstant(proc, visitor);
      if (e != exp)
        return visitor.visit(e, required);
      if ((proc == gnu.kawa.reflect.MakeAnnotation.makeMethodProc) && (nargs == 1) && (visitor.processingAnnotations()))
      {
        Object name = null;
        if ((args[0] instanceof ReferenceExp))
          name = ((ReferenceExp)args[0]).getName();
        msg = "unknown annotation type";
        if (name != null)
          msg = msg + " '" + name + '\'';
        comp.error('e', msg, args[0]);
      }
    }
    if ((comp.inlineOk(proc)) && (exp.isSimple()) && (!ApplyExp.isInlineable(proc)))
    {

      PrimProcedure mproc = PrimProcedure.getMethodFor(proc, decl, args, comp.getLanguage());
      

      if (mproc != null) {
        ApplyExp nexp;
        ApplyExp nexp;
        if ((mproc.getStaticFlag()) || (decl == null)) {
          nexp = new ApplyExp(mproc, args);
        } else { if (base == null) {
            return exp;
          }
          
          Expression[] margs = new Expression[1 + nargs];
          System.arraycopy(exp.getArgs(), 0, margs, 1, nargs);
          margs[0] = new ReferenceExp(base);
          nexp = new ApplyExp(mproc, margs);
        }
        return nexp.setLine(exp);
      }
    }
    return exp;
  }
  
  public boolean side_effects() { return false; }
  
  public String toString()
  {
    return "QuoteExp[" + value + "]";
  }
  
  public void print(OutPort out) {
    out.startLogicalBlock("(Quote", ")", 2);
    out.writeSpaceFill();
    Object val = value;
    if ((val instanceof Expression))
      val = val.toString();
    gnu.kawa.format.AbstractFormat format = Language.getDefaultLanguage().getFormat(true);
    
    if (format == null) {
      out.print(val);
    } else
      format.format(val, out);
    if (type != null) {
      out.writeSpaceFill();
      out.print("::");
      out.print(type.getName());
    }
    out.endLogicalBlock(")");
  }
}
