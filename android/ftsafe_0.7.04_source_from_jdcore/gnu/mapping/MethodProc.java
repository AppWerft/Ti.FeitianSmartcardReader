package gnu.mapping;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;













public abstract class MethodProc
  extends ProcedureN
{
  protected Object argTypes;
  
  public MethodProc() {}
  
  public int isApplicable(Type[] argTypes, Type restType)
  {
    int argCount = argTypes.length;
    int num = numArgs();
    int min = Procedure.minArgs(num);
    int max = Procedure.maxArgs(num);
    if (((argCount < min) && (restType == null)) || ((num >= 0) && (argCount > max)))
    {
      return -1; }
    int result = 1;
    for (int i = 0; 
        (i < argCount) || ((restType != null) && (i < min)); i++)
    {

      Type ptype = getParameterType(i);
      boolean toStringTypeHack = ptype == Type.toStringType;
      


      if (toStringTypeHack)
        ptype = Type.javalangStringType;
      int code = ptype.compare(i < argCount ? argTypes[i] : restType);
      if (code == -3) {
        if (toStringTypeHack) {
          result = 0;
        } else {
          return -1;
        }
      } else if (code < 0)
        result = 0;
    }
    return result;
  }
  

  public int numParameters()
  {
    int num = numArgs();
    int max = num >> 12;
    if (max >= 0) {
      return max;
    }
    int min = num & 0xFFF;
    return min + 1;
  }
  
  static final Type[] unknownArgTypes = { Type.pointer_type };
  public static final int NO_MATCH = -1;
  public static final int NO_MATCH_TOO_FEW_ARGS = -983040;
  
  protected void resolveParameterTypes() {
    argTypes = unknownArgTypes;
  }
  
  public Type getParameterType(int index)
  {
    if (!(argTypes instanceof Type[])) {
      resolveParameterTypes();
    }
    Type[] atypes = (Type[])argTypes;
    if ((index < atypes.length) && ((index < atypes.length - 1) || (maxArgs() >= 0)))
    {
      return atypes[index]; }
    if (maxArgs() < 0)
    {
      Type rtype = atypes[(atypes.length - 1)];
      if ((rtype instanceof ArrayType))
        return ((ArrayType)rtype).getComponentType();
    }
    return Type.objectType;
  }
  





  public static final int NO_MATCH_TOO_MANY_ARGS = -917504;
  




  public static final int NO_MATCH_AMBIGUOUS = -851968;
  




  public static final int NO_MATCH_BAD_TYPE = -786432;
  



  public static RuntimeException matchFailAsException(int code, Procedure proc, Object[] args)
  {
    int arg = (short)code;
    code &= 0xFFFF0000;
    if (code != -786432)
      return new WrongArguments(proc, args.length);
    return new WrongType(proc, arg, arg > 0 ? args[(arg - 1)] : null);
  }
  
  public Object applyN(Object[] args) throws Throwable
  {
    checkArgCount(this, args.length);
    CallContext ctx = CallContext.getInstance();
    checkN(args, ctx);
    return ctx.runUntilValue();
  }
  




  public static MethodProc mostSpecific(MethodProc proc1, MethodProc proc2)
  {
    boolean not1 = false;
    
    boolean not2 = false;
    int min1 = proc1.minArgs();
    int min2 = proc2.minArgs();
    int max1 = proc1.maxArgs();
    int max2 = proc2.maxArgs();
    if (((max1 >= 0) && (max1 < min2)) || ((max2 >= 0) && (max2 < min1)))
    {
      return null; }
    int num1 = proc1.numParameters();
    int num2 = proc2.numParameters();
    int limit = num1 < num2 ? num1 : num2;
    if (max1 != max2)
    {
      if (max1 < 0)
        not1 = true;
      if (max2 < 0)
        not2 = true;
    }
    if (min1 < min2) {
      not1 = true;
    } else if (min1 > min2)
      not2 = true;
    for (int i = 0; i < limit; i++)
    {
      Type t1 = proc1.getParameterType(i);
      Type t2 = proc2.getParameterType(i);
      int comp = t1.compare(t2);
      if (comp == -1)
      {
        not2 = true;
        if (not1)
          return null;
      }
      if (comp == 1)
      {
        not1 = true;
        if (not2)
          return null;
      }
    }
    return not1 ? proc2 : not2 ? proc1 : null;
  }
  
  public static boolean overrideEquivalent(MethodProc proc1, MethodProc proc2)
  {
    int num1 = proc1.numParameters();
    int num2 = proc2.numParameters();
    if (num1 != num2)
      return false;
    for (int i = 1; i < num1; i++) {
      Type t1 = proc1.getParameterType(i);
      Type t2 = proc2.getParameterType(i);
      if (t1.compare(t2) != 0)
        return false;
    }
    return true;
  }
}
