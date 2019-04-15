package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.kawa.functions.Arithmetic;
import gnu.math.IntNum;
import gnu.math.RealNum;
import java.math.BigDecimal;










public class XIntegerType
  extends XDataType
{
  public final IntNum minValue;
  public final IntNum maxValue;
  static ClassType typeIntNum = ClassType.make("gnu.math.IntNum");
  
  boolean isUnsignedType;
  
  public boolean isUnsignedType()
  {
    return isUnsignedType;
  }
  
  public static final XIntegerType integerType = new XIntegerType("integer", decimalType, 5, null, null);
  

  public static final XIntegerType longType = new XIntegerType("long", integerType, 8, IntNum.make(Long.MIN_VALUE), IntNum.make(Long.MAX_VALUE));
  

  public static final XIntegerType intType = new XIntegerType("int", longType, 9, IntNum.make(Integer.MIN_VALUE), IntNum.make(Integer.MAX_VALUE));
  


  public static final XIntegerType shortType = new XIntegerType("short", intType, 10, IntNum.make(32768), IntNum.make(32767));
  


  public static final XIntegerType byteType = new XIntegerType("byte", shortType, 11, IntNum.make(-128), IntNum.make(127));
  


  public static final XIntegerType nonPositiveIntegerType = new XIntegerType("nonPositiveInteger", integerType, 6, null, IntNum.zero());
  


  public static final XIntegerType negativeIntegerType = new XIntegerType("negativeInteger", nonPositiveIntegerType, 7, null, IntNum.minusOne());
  


  public static final XIntegerType nonNegativeIntegerType = new XIntegerType("nonNegativeInteger", integerType, 12, IntNum.zero(), null);
  


  public static final XIntegerType unsignedLongType = new XIntegerType("unsignedLong", nonNegativeIntegerType, 13, IntNum.zero(), IntNum.valueOf("18446744073709551615"));
  


  public static final XIntegerType unsignedIntType = new XIntegerType("unsignedInt", unsignedLongType, 14, IntNum.zero(), IntNum.make(4294967295L));
  


  public static final XIntegerType unsignedShortType = new XIntegerType("unsignedShort", unsignedIntType, 15, IntNum.zero(), IntNum.make(65535));
  


  public static final XIntegerType unsignedByteType = new XIntegerType("unsignedByte", unsignedShortType, 16, IntNum.zero(), IntNum.make(255));
  


  public static final XIntegerType positiveIntegerType = new XIntegerType("positiveInteger", nonNegativeIntegerType, 17, IntNum.one(), null);
  





  public XIntegerType(String name, XDataType base, int typeCode, IntNum min, IntNum max)
  {
    this(name, base, typeCode, min, max);
    isUnsignedType = name.startsWith("unsigned");
  }
  

  public XIntegerType(Object name, XDataType base, int typeCode, IntNum min, IntNum max)
  {
    super(name, typeIntNum, typeCode);
    minValue = min;
    maxValue = max;
    baseType = base;
  }
  
  public boolean isInstance(Object obj)
  {
    if (!(obj instanceof IntNum))
      return false;
    if (this == integerType)
      return true;
    XDataType objType = (obj instanceof XInteger) ? ((XInteger)obj).getIntegerType() : integerType;
    

    while (objType != null)
    {
      if (objType == this)
        return true;
      objType = baseType;
    }
    return false;
  }
  
  public Object coerceFromObject(Object obj)
  {
    IntNum ival = IntNum.asIntNumOrNull(obj);
    if (ival == null)
      throw new ClassCastException("cannot cast " + obj + " to " + name);
    return valueOf(ival);
  }
  
  public IntNum valueOf(IntNum value)
  {
    if (this != integerType)
    {
      if (((minValue != null) && (IntNum.compare(value, minValue) < 0)) || ((maxValue != null) && (IntNum.compare(value, maxValue) > 0)))
      {
        throw new ClassCastException("cannot cast " + value + " to " + name); }
      return new XInteger(value, this);
    }
    return value;
  }
  
  public Object cast(Object value)
  {
    if ((value instanceof Boolean)) {
      return valueOf(((Boolean)value).booleanValue() ? IntNum.one() : IntNum.zero());
    }
    if ((value instanceof IntNum))
      return valueOf((IntNum)value);
    if ((value instanceof BigDecimal))
      return valueOf(Arithmetic.asIntNum((BigDecimal)value));
    if ((value instanceof RealNum))
      return valueOf(((RealNum)value).toExactInt(3));
    if (RealNum.isReal(value))
      return valueOf(RealNum.toExactInt(((Number)value).doubleValue(), 3));
    return super.cast(value);
  }
  
  public Object valueOf(String value)
  {
    return valueOf(IntNum.valueOf(value.trim(), 10));
  }
  
  public IntNum valueOf(String value, int radix)
  {
    return valueOf(IntNum.valueOf(value.trim(), radix));
  }
}
