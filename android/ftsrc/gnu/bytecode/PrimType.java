package gnu.bytecode;

public class PrimType extends Type {
  private static final String numberHierarchy = "A:java.lang.Byte;A:gnu.math.UByte;B:java.lang.Short;B:gnu.math.UShort;C:java.lang.Integer;C:gnu.math.UInt;D:java.lang.Long;D:gnu.math.ULong;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;G:gnu.math.IntFraction;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;";
  
  public PrimType(String nam, String sig, int siz, Class reflectClass) { super(nam, sig);
    size = siz;
    this.reflectClass = reflectClass;
    Type.registerTypeForClass(reflectClass, this);
  }
  
  protected PrimType(PrimType type)
  {
    super(this_name, signature);
    size = size;
    reflectClass = reflectClass;
  }
  
  public boolean isUnsigned() {
    char sig1 = signature.charAt(0);
    return (sig1 == 'C') || (sig1 == 'Z');
  }
  
  public Object coerceFromObject(Object obj)
  {
    if (obj.getClass() == reflectClass)
      return obj;
    char sig1 = (signature == null) || (signature.length() != 1) ? ' ' : signature.charAt(0);
    

    switch (sig1) {
    case 'B': 
      return Byte.valueOf(((Number)obj).byteValue());
    case 'S':  return Short.valueOf(((Number)obj).shortValue());
    case 'I':  return Integer.valueOf(((Number)obj).intValue());
    case 'J':  return Long.valueOf(((Number)obj).longValue());
    case 'F':  return Float.valueOf(((Number)obj).floatValue());
    case 'D':  return Double.valueOf(((Number)obj).doubleValue());
    case 'Z':  return Boolean.valueOf(((Boolean)obj).booleanValue());
    }
    
    










    throw new ClassCastException("don't know how to coerce " + obj.getClass().getName() + " to " + getName());
  }
  

  public Object convertToRaw(Object obj)
  {
    return obj;
  }
  


  public char charValue(Object value)
  {
    return ((Character)value).charValue();
  }
  


  public static boolean booleanValue(Object value)
  {
    return (!(value instanceof Boolean)) || (((Boolean)value).booleanValue());
  }
  
  public ClassType boxedType()
  {
    char sig1 = getSignature().charAt(0);
    String cname;
    switch (sig1) {
    case 'Z': 
      cname = "java.lang.Boolean"; break;
    case 'C':  cname = "java.lang.Character"; break;
    case 'B':  cname = "java.lang.Byte"; break;
    case 'S':  cname = "java.lang.Short"; break;
    case 'I':  cname = "java.lang.Integer"; break;
    case 'J':  cname = "java.lang.Long"; break;
    case 'F':  cname = "java.lang.Float"; break;
    case 'D':  cname = "java.lang.Double"; break;
    case 'V':  cname = "java.lang.Void"; break;
    case 'E': case 'G': case 'H': case 'K': case 'L': case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R': case 'T': case 'U': case 'W': case 'X': case 'Y': default:  cname = null;
    }
    return ClassType.make(cname);
  }
  
  public static PrimType unboxedType(Type type)
  {
    if ((type instanceof PrimType))
      return (PrimType)type;
    if (!(type instanceof ClassType))
      return null;
    String name = type.getName();
    if ("java.lang.Boolean".equals(name))
      return Type.booleanType;
    if ("java.lang.Character".equals(name))
      return Type.charType;
    if ("java.lang.Byte".equals(name))
      return Type.byteType;
    if ("java.lang.Short".equals(name))
      return Type.shortType;
    if ("java.lang.Integer".equals(name))
      return Type.intType;
    if ("java.lang.Long".equals(name))
      return Type.longType;
    if ("java.lang.Float".equals(name))
      return Type.floatType;
    if ("java.lang.Double".equals(name))
      return Type.doubleType;
    if ("java.lang.Void".equals(name))
      return Type.voidType;
    return null;
  }
  
  public void emitCoerceToObject(CodeAttr code)
  {
    char sig1 = getSignature().charAt(0);
    ClassType clas = boxedType();
    if (sig1 == 'Z')
    {
      code.emitIfIntNotZero();
      code.emitGetStatic(clas.getDeclaredField("TRUE"));
      code.emitElse();
      code.emitGetStatic(clas.getDeclaredField("FALSE"));
      code.emitFi();
      return;
    }
    
    Type[] args = new Type[1];
    args[0] = this;
    Method method; Method method; if (getMethodgetDeclaringClassclassfileFormatVersion >= 3211264) {
      method = clas.getDeclaredMethod("valueOf", args);
    }
    else {
      method = clas.getDeclaredMethod("<init>", args);
      code.emitNew(clas);
      code.emitDupX();
      code.emitSwap();
    }
    code.emitInvoke(method);
  }
  
  public void emitIsInstance(CodeAttr code)
  {
    char sig1 = (signature == null) || (signature.length() != 1) ? ' ' : signature.charAt(0);
    
    if (sig1 == 'Z') {
      javalangBooleanType.emitIsInstance(code);
    } else if (sig1 == 'V')
    {
      code.emitPop(1);
      code.emitPushInt(1);
    }
    else
    {
      javalangNumberType.emitIsInstance(code);
    }
  }
  
  public void emitCoerceFromObject(CodeAttr code) {
    char sig1 = (signature == null) || (signature.length() != 1) ? ' ' : signature.charAt(0);
    
    if (sig1 == 'Z')
    {
      code.emitCheckcast(javalangBooleanType);
      code.emitInvokeVirtual(booleanValue_method);
    }
    else if (sig1 == 'V') {
      code.emitPop(1);
    }
    else {
      code.emitCheckcast(javalangNumberType);
      if ((sig1 == 'I') || (sig1 == 'S') || (sig1 == 'B')) {
        code.emitInvokeVirtual(intValue_method);
      } else if (sig1 == 'J') {
        code.emitInvokeVirtual(longValue_method);
      } else if (sig1 == 'D') {
        code.emitInvokeVirtual(doubleValue_method);
      } else if (sig1 == 'F') {
        code.emitInvokeVirtual(floatValue_method);
      }
      else
        super.emitCoerceFromObject(code);
    }
  }
  
  public static int compare(PrimType type1, PrimType type2) {
    char sig1 = signature.charAt(0);
    char sig2 = signature.charAt(0);
    
    if (sig1 == sig2) {
      return type1.isUnsigned() == type2.isUnsigned() ? 0 : -2;
    }
    
    if (sig1 == 'V')
      return 1;
    if (sig2 == 'V') {
      return -1;
    }
    


    if ((sig1 == 'Z') || (sig2 == 'Z')) {
      return -3;
    }
    if (sig1 == 'C')
      return size > 2 ? -1 : -3;
    if (sig2 == 'C') {
      return size > 2 ? 1 : -3;
    }
    if (sig1 == 'D')
      return 1;
    if (sig2 == 'D')
      return -1;
    if (sig1 == 'F')
      return 1;
    if (sig2 == 'F')
      return -1;
    int r = sig2 == 'B' ? -1 : sig1 == 'B' ? 1 : sig2 == 'S' ? -1 : sig1 == 'S' ? 1 : sig2 == 'I' ? -1 : sig1 == 'I' ? 1 : sig2 == 'J' ? -1 : sig1 == 'J' ? 1 : -3;
    



    if (((r == 1) && (type1.isUnsigned()) && (!type2.isUnsigned())) || ((r == -1) && (type2.isUnsigned()) && (!type1.isUnsigned())))
    {
      r = -2; }
    return r;
  }
  
  public Type promotedType()
  {
    switch (signature.charAt(0)) {
    case 'B': case 'C': case 'I': 
    case 'S': case 'Z': 
      return Type.intType;
    }
    return getImplementationType();
  }
  





















  private static char findInHierarchy(String cname)
  {
    int pos = "A:java.lang.Byte;A:gnu.math.UByte;B:java.lang.Short;B:gnu.math.UShort;C:java.lang.Integer;C:gnu.math.UInt;D:java.lang.Long;D:gnu.math.ULong;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;G:gnu.math.IntFraction;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;".indexOf(cname) - 2;
    return pos < 0 ? '\000' : "A:java.lang.Byte;A:gnu.math.UByte;B:java.lang.Short;B:gnu.math.UShort;C:java.lang.Integer;C:gnu.math.UInt;D:java.lang.Long;D:gnu.math.ULong;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;G:gnu.math.IntFraction;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;".charAt(pos);
  }
  
  public int compare(Type other)
  {
    if ((other instanceof PrimType))
    {



      if (other.getImplementationType() != other)
        return swappedCompareResult(other.compare(this));
      return compare(this, (PrimType)other);
    }
    if (!(other instanceof ClassType))
    {
      if ((other instanceof ArrayType)) {
        return -3;
      }
      return swappedCompareResult(other.compare(this));
    }
    char sig1 = signature.charAt(0);
    String otherName = other.getName();
    if (otherName == null)
      return -1;
    char thisPriority = '\000';
    switch (sig1)
    {
    case 'V': 
      return 1;
    case 'Z': 
      if (otherName.equals("java.lang.Boolean"))
        return 0;
    case 'C': 
      if (otherName.equals("java.lang.Character"))
        return 0;
      break;
    case 'B':  thisPriority = 'A'; break;
    case 'S':  thisPriority = 'B'; break;
    case 'I':  thisPriority = 'C'; break;
    case 'J':  thisPriority = 'D'; break;
    case 'F':  thisPriority = 'H'; break;
    case 'D':  thisPriority = 'I';
    }
    if (thisPriority != 0)
    {
      char otherPriority = findInHierarchy(otherName);
      if (otherPriority != 0) {
        return otherPriority < thisPriority ? 1 : otherPriority == thisPriority ? 0 : -1;
      }
    }
    if ((otherName.equals("java.lang.Object")) || (other == toStringType))
    {
      return -1; }
    return -3;
  }
}
