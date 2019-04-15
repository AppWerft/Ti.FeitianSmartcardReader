package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;






public class ReferenceExp
  extends AccessExp
{
  static int counter;
  int id = ++counter;
  
  public static final int DONT_DEREFERENCE = 4;
  
  public static final int PROCEDURE_NAME = 8;
  
  public static final int TYPE_NAME = 16;
  
  public static final int ALLOCATE_ON_STACK_LAST = 32;
  
  ReferenceExp siblingReferencesNext;
  
  public final boolean getDontDereference()
  {
    return (flags & 0x4) != 0;
  }
  
  public final void setDontDereference(boolean setting) {
    setFlag(setting, 4);
  }
  
  public final boolean isUnknown() {
    return Declaration.isUnknown(binding);
  }
  



  public final boolean isProcedureName()
  {
    return (flags & 0x8) != 0;
  }
  

  public final void setProcedureName(boolean setting)
  {
    setFlag(setting, 8);
  }
  
  public ReferenceExp(Object symbol)
  {
    this.symbol = symbol;
  }
  
  public ReferenceExp(Object symbol, Declaration binding)
  {
    this.symbol = symbol;
    this.binding = binding;
  }
  
  public ReferenceExp(Declaration binding)
  {
    this(binding.getSymbol(), binding);
  }
  
  public ReferenceExp(ReferenceExp old) {
    this(symbol, binding);
    setContextDecl(old.contextDecl());
    flags = flags;
  }
  
  protected boolean mustCompile() { return false; }
  
  public final Object valueIfConstant()
  {
    if (binding != null)
    {
      Expression dvalue = binding.getValue();
      if (dvalue != null)
        return dvalue.valueIfConstant();
    }
    return null;
  }
  
  public void apply(CallContext ctx) throws Throwable
  {
    Expression dvalue;
    Object value;
    Object value;
    if ((binding != null) && (binding.isAlias()) && (!getDontDereference()) && (((dvalue = binding.getValueRaw()) instanceof ReferenceExp)))
    {

      ReferenceExp rexp = (ReferenceExp)dvalue;
      if ((rexp.getDontDereference()) && (binding != null))
      {
        Expression v = binding.getValue();
        if (((v instanceof QuoteExp)) || ((v instanceof ReferenceExp)) || ((v instanceof LambdaExp)))
        {

          v.apply(ctx);
          return;
        }
      }
      value = dvalue.eval(ctx);
    } else { Object value;
      if ((binding != null) && (binding.field != null) && (binding.field.getDeclaringClass().isExisting()) && ((!getDontDereference()) || (binding.isIndirectBinding())))
      {

        try
        {

          Object instance = binding.field.getStaticFlag() ? null : contextDecl().getValue().eval(ctx);
          
          value = binding.field.getReflectField().get(instance);
        }
        catch (Exception ex)
        {
          String msg = "exception evaluating " + symbol + " from " + binding.field + " - " + ex;
          

          throw new UnboundLocationException(msg, this);
        }
      }
      else {
        Expression dvalue;
        if ((binding != null) && ((((dvalue = binding.getValue()) instanceof QuoteExp)) || ((dvalue instanceof LambdaExp))) && (dvalue != QuoteExp.undefined_exp) && ((!getDontDereference()) || (binding.isIndirectBinding())))
        {




          value = dvalue.eval(ctx);
        } else {
          if ((binding == null) || ((binding.context instanceof ModuleExp)))
          {
            Environment env = Environment.getCurrent();
            Symbol sym = (symbol instanceof Symbol) ? (Symbol)symbol : env.getSymbol(symbol.toString());
            
            Object property = (getFlag(2)) && (isProcedureName()) ? EnvironmentKey.FUNCTION : null;
            Object value;
            Object value;
            if (getDontDereference()) {
              value = env.getLocation(sym, property);
            }
            else {
              Object unb = Location.UNBOUND;
              value = env.get(sym, property, unb);
              if (value == unb)
                throw new UnboundLocationException(sym, this);
            }
            ctx.writeValue(value);
            return;
          }
          
          value = evalFrames[ScopeExp.nesting(binding.context)][binding.evalIndex]; } } }
    if ((!getDontDereference()) && (binding.isIndirectBinding()))
      value = ((Location)value).get();
    ctx.writeValue(value);
  }
  
  public void compile(Compilation comp, Target target)
  {
    if ((!(target instanceof ConsumerTarget)) || (binding.getFlag(549755813888L)) || (!((ConsumerTarget)target).compileWrite(this, comp)))
    {

      binding.load(this, flags, comp, target);
    }
  }
  
  protected Expression deepCopy(IdentityHashTable mapper) {
    Declaration d = (Declaration)mapper.get(binding, binding);
    Object s = mapper.get(symbol, symbol);
    ReferenceExp copy = new ReferenceExp(s, d);
    flags = getFlags();
    return copy;
  }
  
  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitReferenceExp(this, d);
  }
  

  public Expression validateApply(ApplyExp exp, InlineCalls visitor, Type required, Declaration decl)
  {
    decl = binding;
    if ((decl != null) && (!decl.getFlag(65536L)))
    {
      decl = Declaration.followAliases(decl);
      if (!decl.isIndirectBinding())
      {
        Expression dval = decl.getValue();
        if (dval != null)
          return dval.validateApply(exp, visitor, required, decl);
        Type dtype = type;
        if (((dtype instanceof ClassType)) && (((ClassType)dtype).isSubclass("kawa.lang.Continuation")))
        {
          exp.setType(Type.neverReturnsType);
        }
      }
    } else if ((getSymbol() instanceof Symbol))
    {
      Symbol symbol = (Symbol)getSymbol();
      Object fval = Environment.getCurrent().getFunction(symbol, null);
      if ((fval instanceof Procedure))
        return new QuoteExp(fval).validateApply(exp, visitor, required, null);
    }
    exp.visitArgs(visitor);
    return exp;
  }
  
  public void print(OutPort ps)
  {
    ps.print("(Ref/");
    ps.print(id);
    if (getDontDereference())
      ps.print(",dont-deref");
    if ((symbol != null) && ((binding == null) || (symbol.toString() != binding.getName())))
    {

      ps.print('/');
      ps.print(symbol);
    }
    if (binding != null)
    {
      ps.print('/');
      ps.print(binding);
    }
    ps.print(")");
  }
  
  protected Type calculateType()
  {
    Declaration decl = binding;
    if (decl == null)
      return Type.pointer_type;
    if (getDontDereference())
    {
      if ((field != null) && (!decl.isIndirectBinding())) {
        return field.getStaticFlag() ? Compilation.typeStaticFieldLocation : Compilation.typeFieldLocation;
      }
      
      return Compilation.typeLocation;
    }
    decl = Declaration.followAliases(decl);
    Type type = (decl.isAlias()) && (decl.isIndirectBinding()) ? Type.objectType : decl.getType();
    

    if (type == Type.toStringType)
      type = Type.javalangStringType;
    return type;
  }
  
  public boolean isSingleValue()
  {
    if ((binding != null) && (binding.getFlag(262144L)))
      return true;
    return super.isSingleValue();
  }
  
  public boolean side_effects()
  {
    return (binding == null) || (!binding.isLexical());
  }
  
  public String toString()
  {
    return "RefExp/" + symbol + '/' + id + '/';
  }
}
