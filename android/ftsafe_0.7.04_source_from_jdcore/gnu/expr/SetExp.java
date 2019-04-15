package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.kawa.io.OutPort;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.math.IntNum;

public class SetExp extends AccessExp
{
  Expression new_value;
  int valueIndex;
  public static final int DEFINING_FLAG = 4;
  public static final int GLOBAL_FLAG = 8;
  public static final int PROCEDURE = 16;
  public static final int SET_IF_UNBOUND = 32;
  public static final int HAS_VALUE = 64;
  public static final int BAD_SHORT = 65536;
  
  public SetExp(Object symbol, Expression val)
  {
    this.symbol = symbol;new_value = val;
  }
  
  public SetExp(Declaration decl, Expression val) { setBinding(decl);
    new_value = val;
  }
  
  public static SetExp makeDefinition(Object symbol, Expression val)
  {
    SetExp sexp = new SetExp(symbol, val);
    sexp.setDefining(true);
    return sexp;
  }
  
  public static SetExp makeDefinition(Declaration decl, Expression val)
  {
    SetExp sexp = new SetExp(decl, val);
    sexp.setDefining(true);
    return sexp;
  }
  

  public final Expression getNewValue() { return new_value; }
  public void setNewValue(Expression newValue) { new_value = newValue; }
  






  public final boolean isDefining()
  {
    return (flags & 0x4) != 0;
  }
  
  public final void setDefining(boolean value)
  {
    if (value) flags |= 0x4; else { flags &= 0xFFFFFFFB;
    }
  }
  

  public final boolean getHasValue() { return (flags & 0x40) != 0; }
  
  public final void setHasValue(boolean value) {
    if (value) flags |= 0x40; else { flags &= 0xFFFFFFBF;
    }
  }
  
  public final boolean isFuncDef() { return (flags & 0x10) != 0; }
  
  public final void setFuncDef(boolean value) {
    if (value) flags |= 0x10; else flags &= 0xFFFFFFEF;
  }
  
  public final boolean isSetIfUnbound() { return (flags & 0x20) != 0; }
  
  public final void setSetIfUnbound(boolean value) {
    if (value) flags |= 0x20; else flags &= 0xFFFFFFDF; }
  
  protected boolean mustCompile() { return false; }
  
  public void apply(gnu.mapping.CallContext ctx) throws Throwable
  {
    Environment env = Environment.getCurrent();
    gnu.mapping.Symbol sym = ((symbol instanceof gnu.mapping.Symbol)) || (symbol == null) ? (gnu.mapping.Symbol)symbol : env.getSymbol(symbol.toString());
    
    Object property = null;
    Language language = Language.getDefaultLanguage();
    if ((isFuncDef()) && (language.hasSeparateFunctionNamespace()))
      property = gnu.mapping.EnvironmentKey.FUNCTION;
    if (isSetIfUnbound())
    {
      Location loc = env.getLocation(sym, property);
      if (!loc.isBound())
        loc.set(new_value.eval(env));
      if (getHasValue())
        ctx.writeValue(loc);
      return;
    }
    
    Object new_val = new_value.eval(env);
    if ((binding != null) && (!(binding.context instanceof ModuleExp)))
    {
      Object[] evalFrame = evalFrames[ScopeExp.nesting(binding.context)];
      if (binding.isIndirectBinding())
      {

        if (isDefining())
          evalFrame[binding.evalIndex] = Location.make(sym);
        Location loc = (Location)evalFrame[binding.evalIndex];
        loc.set(new_value);
      }
      else {
        evalFrame[binding.evalIndex] = new_val;
      }
    } else if (isDefining())
    {





      env.define(sym, property, new_val);
    }
    else
    {
      env.put(sym, property, new_val);
    }
    if (getHasValue()) {
      ctx.writeValue(new_val);
    }
  }
  
  public void compile(Compilation comp, Target target) {
    if (((new_value instanceof LambdaExp)) && ((target instanceof IgnoreTarget)) && (((LambdaExp)new_value).getInlineOnly()))
    {

      return;
    }
    CodeAttr code = comp.getCode();
    
    boolean needValue = (getHasValue()) && (!(target instanceof IgnoreTarget));
    



    boolean valuePushed = false;
    






    Declaration decl = binding;
    Expression declValue = decl.getValue();
    if (((declValue instanceof LambdaExp)) && ((context instanceof ModuleExp)) && (!decl.ignorable()) && (((LambdaExp)declValue).getName() != null) && (declValue == new_value))
    {




      ((LambdaExp)new_value).compileSetField(comp);
    }
    else if (((decl.shouldEarlyInit()) || (decl.isAlias())) && ((context instanceof ModuleExp)) && (isDefining()) && (!decl.ignorable()))
    {


      if ((decl.shouldEarlyInit()) && (field != null) && (!field.hasConstantValueAttr()))
      {
        BindingInitializer.create(decl, new_value, comp); }
      if (needValue)
      {
        decl.load(this, 0, comp, Target.pushObject);
        valuePushed = true;
      }
    }
    else
    {
      AccessExp access = this;
      Declaration owner = contextDecl();
      if (!isDefining())
      {
        while ((decl != null) && (decl.isAlias()))
        {
          declValue = decl.getValue();
          if (!(declValue instanceof ReferenceExp))
            break;
          ReferenceExp rexp = (ReferenceExp)declValue;
          Declaration orig = binding;
          if (orig == null)
            break;
          if ((owner != null) && (orig.needsContext()))
            break;
          owner = rexp.contextDecl();
          access = rexp;
          decl = orig;
        }
      }
      if (decl.ignorable()) {
        new_value.compile(comp, Target.Ignore);
      } else if ((decl.isAlias()) && (isDefining()))
      {
        decl.load(this, 4, comp, Target.pushObject);
        
        ClassType locType = ClassType.make("gnu.mapping.IndirectableLocation");
        
        code.emitCheckcast(locType);
        new_value.compile(comp, Target.pushObject);
        Method meth = locType.getDeclaredMethod("setAlias", 1);
        code.emitInvokeVirtual(meth);
      }
      else if (decl.isIndirectBinding())
      {
        decl.load(access, 4, comp, Target.pushObject);
        
        if (isSetIfUnbound())
        {
          if (needValue)
          {
            code.emitDup();
            valuePushed = true;
          }
          code.pushScope();
          code.emitDup();
          gnu.bytecode.Variable symLoc = code.addLocal(Compilation.typeLocation);
          code.emitStore(symLoc);
          code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("isBound", 0));
          
          code.emitIfIntEqZero();
          code.emitLoad(symLoc);
        }
        new_value.compile(comp, Target.pushObject);
        if ((needValue) && (!isSetIfUnbound()))
        {
          code.emitDupX();
          valuePushed = true;
        }
        String setterName = "set";
        code.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod(setterName, 1));
        
        if (isSetIfUnbound())
        {
          code.emitFi();
          code.popScope();
        }
      }
      else if (decl.isSimple())
      {
        Type type = decl.getType();
        gnu.bytecode.Variable var = decl.getVariable();
        if (var == null)
          var = decl.allocateVariable(code, true);
        int delta = canUseInc(new_value, decl);
        if (delta != 65536)
        {
          comp.getCode().emitInc(var, (short)delta);
          if (needValue)
          {
            code.emitLoad(var);
            valuePushed = true;
          }
        }
        else
        {
          new_value.compile(comp, decl);
          if (!checkReachable(comp))
            return;
          if (needValue)
          {
            code.emitDup(type);
            valuePushed = true;
          }
          code.emitStore(var);
        }
      }
      else
      {
        gnu.bytecode.Field field = field;
        boolean isStatic = (field != null) && (field.getStaticFlag());
        Method setter;
        if (field == null)
        {
          String setName = ClassExp.slotToMethodName("set", decl.getName());
          
          ClassExp cl = (ClassExp)context;
          Method setter = compiledType.getDeclaredMethod(setName, 1);
          comp.usedClass(setter.getDeclaringClass());
        }
        else
        {
          setter = null;
          comp.usedClass(field.getDeclaringClass());
        }
        if (!isStatic)
          decl.loadOwningObject(owner, comp);
        new_value.compile(comp, decl);
        if (!checkReachable(comp))
          return;
        if (isStatic)
        {
          if (needValue)
          {
            code.emitDup();
            valuePushed = true;
          }
          code.emitPutStatic(field);
        }
        else
        {
          if (needValue)
          {
            code.emitDupX();
            valuePushed = true;
          }
          if (field != null) {
            code.emitPutField(field);
          } else {
            code.emitInvoke(setter);
          }
        }
      }
    }
    if ((needValue) && (!valuePushed)) {
      throw new Error("SetExp.compile: not implemented - return value");
    }
    if (needValue) {
      target.compileFromStack(comp, getType());
    } else {
      comp.compileConstant(gnu.mapping.Values.empty, target);
    }
  }
  
  boolean checkReachable(Compilation comp) {
    boolean reachable = comp.getCode().reachableHere();
    if (!reachable)
      comp.error('w', "'" + getSymbol() + "' can never be set because expression never finishes", new_value);
    return reachable;
  }
  











  public static int canUseInc(Expression rhs, Declaration target)
  {
    gnu.bytecode.Variable var = target.getVariable();
    if ((target.isSimple()) && ((rhs instanceof ReferenceExp)))
    {

      ReferenceExp rexp = (ReferenceExp)rhs;
      if ((binding == target) && (!rexp.getDontDereference()))
        return 0;
    }
    ApplyExp aexp;
    if ((target.isSimple()) && (var.getType().getImplementationType().promote() == Type.intType) && ((rhs instanceof ApplyExp)) && ((aexp = (ApplyExp)rhs).getArgCount() == 2))
    {



      Expression funcExp = aexp.getFunction();
      Object func = funcExp.valueIfConstant();
      int sign;
      int sign; if (func == gnu.kawa.functions.AddOp.$Pl) {
        sign = 1;
      } else { if (func != gnu.kawa.functions.AddOp.$Mn) break label315;
        sign = -1;
      }
      
      Expression arg0 = aexp.getArg(0);
      Expression arg1 = aexp.getArg(1);
      if (((arg0 instanceof QuoteExp)) && (sign > 0))
      {
        Expression tmp = arg1;
        arg1 = arg0;
        arg0 = tmp;
      }
      if ((arg0 instanceof ReferenceExp))
      {
        ReferenceExp ref0 = (ReferenceExp)arg0;
        if ((ref0.getBinding() == target) && (!ref0.getDontDereference()))
        {
          Object value1 = arg1.valueIfConstant();
          
          if ((value1 instanceof Integer))
          {
            int val1 = ((Integer)value1).intValue();
            if (sign < 0)
              val1 = -val1;
            if ((short)val1 == val1) {
              return val1;
            }
          } else if ((value1 instanceof IntNum))
          {
            IntNum int1 = (IntNum)value1;
            int hi = 32767;
            int lo = -hi;
            if (sign > 0) {
              lo--;
            } else
              hi++;
            if ((IntNum.compare(int1, lo) >= 0) && (IntNum.compare(int1, hi) <= 0))
            {
              return sign * int1.intValue(); }
          }
        } } }
    label315:
    return 65536;
  }
  
  protected final Type calculateType()
  {
    return binding == null ? Type.pointer_type : !getHasValue() ? Type.voidType : binding.getType();
  }
  

  protected <R, D> R visit(ExpVisitor<R, D> visitor, D d)
  {
    return visitor.visitSetExp(this, d);
  }
  
  protected <R, D> void visitChildren(ExpVisitor<R, D> visitor, D d)
  {
    new_value = visitor.visitAndUpdate(new_value, d);
  }
  
  public void print(OutPort out) {
    out.startLogicalBlock(isDefining() ? "(Define" : "(Set", ")", 2);
    out.writeSpaceFill();
    printLineColumn(out);
    if ((symbol != null) && ((binding == null) || (symbol.toString() != binding.getName())))
    {

      out.print('/');
      out.print(symbol);
    }
    if (binding != null)
    {
      out.print('/');
      out.print(binding);
    }
    out.writeSpaceLinear();
    new_value.print(out);
    out.endLogicalBlock(")");
  }
  
  public String toString()
  {
    return "SetExp[" + symbol + ":=" + new_value + ']';
  }
}
