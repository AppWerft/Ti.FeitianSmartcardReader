package gnu.xquery.util;

import gnu.kawa.functions.Arithmetic;
import gnu.kawa.xml.XDataType;
import gnu.kawa.xml.XIntegerType;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RealNum;
import java.math.BigDecimal;

public class NumberValue extends gnu.mapping.Procedure1
{
  public static final NumberValue numberValue = new NumberValue();
  
  public static final Double NaN = new Double(NaN.0D);
  
  public NumberValue() {}
  
  public static boolean isNaN(Object arg) { return (((arg instanceof Double)) || ((arg instanceof Float)) || ((arg instanceof gnu.math.DFloNum))) && (Double.isNaN(((Number)arg).doubleValue())); }
  



  public Object apply1(Object arg)
  {
    if ((arg != Values.empty) && (arg != null))
    {
      try
      {
        return numberValue(arg);
      }
      catch (Exception ex) {}
    }
    


    return NaN;
  }
  
  public static Number numberCast(Object value)
  {
    if ((value == Values.empty) || (value == null))
      return null;
    if ((value instanceof Values))
    {
      Values vals = (Values)value;
      int ipos = vals.startPos();
      int count = 0;
      while ((ipos = vals.nextPos(ipos)) != 0)
      {
        if (count > 0)
          throw new ClassCastException("non-singleton sequence cast to number");
        value = vals.getPosPrevious(ipos);
        count++;
      }
    }
    if (((value instanceof gnu.kawa.xml.KNode)) || ((value instanceof gnu.kawa.xml.UntypedAtomic)))
      return (Double)XDataType.doubleType.valueOf(gnu.xml.TextUtils.stringValue(value));
    return (Number)value;
  }
  
  public static Object numberValue(Object value)
  {
    value = gnu.kawa.xml.KNode.atomicValue(value);
    double d;
    if (((value instanceof gnu.kawa.xml.UntypedAtomic)) || ((value instanceof String)))
    {
      double d;
      try {
        return XDataType.doubleType.valueOf(gnu.xml.TextUtils.stringValue(value));

      }
      catch (Exception ex)
      {
        d = NaN.0D;
      }
    } else { double d;
      if (((value instanceof Number)) && (((value instanceof RealNum)) || (!(value instanceof Numeric))))
      {
        d = ((Number)value).doubleValue();
      } else
        d = NaN.0D; }
    return XDataType.makeDouble(d);
  }
  
  public static Object abs(Object value)
  {
    if ((value == null) || (value == Values.empty))
      return value;
    value = numberCast(value);
    if ((value instanceof Double))
    {
      Double d = (Double)value;
      double x = d.doubleValue();
      long bits = Double.doubleToRawLongBits(x);
      if (bits >= 0L)
        return d;
      bits &= 0x7FFFFFFFFFFFFFFF;
      x = Double.longBitsToDouble(bits);
      
      return Double.valueOf(x);
    }
    


    if ((value instanceof Float))
    {
      Float d = (Float)value;
      float x = d.floatValue();
      int bits = Float.floatToRawIntBits(x);
      if (bits >= 0)
        return d;
      bits &= 0x7FFFFFFF;
      x = Float.intBitsToFloat(bits);
      
      return Float.valueOf(x);
    }
    


    if ((value instanceof BigDecimal))
    {
      BigDecimal dec = (BigDecimal)value;
      if (dec.signum() < 0)
        dec = dec.negate();
      return dec;
    }
    return ((Numeric)value).abs();
  }
  
  public static Object floor(Object val)
  {
    Number value = numberCast(val);
    if (value == null)
      return val;
    if ((value instanceof Double))
      return XDataType.makeDouble(Math.floor(((Double)value).doubleValue()));
    if ((value instanceof Float))
      return XDataType.makeFloat((float)Math.floor(((Float)value).floatValue()));
    if ((value instanceof BigDecimal))
    {
      BigDecimal dec = (BigDecimal)value;
      return Arithmetic.asIntNum(dec.divide(XDataType.DECIMAL_ONE, 0, 3).toBigInteger());
    }
    return ((RealNum)value).toInt(1);
  }
  
  public static Object ceiling(Object val)
  {
    Number value = numberCast(val);
    if (value == null)
      return val;
    if ((value instanceof Double))
      return XDataType.makeDouble(Math.ceil(((Double)value).doubleValue()));
    if ((value instanceof Float))
      return XDataType.makeFloat((float)Math.ceil(((Float)value).floatValue()));
    if ((value instanceof BigDecimal))
    {
      BigDecimal dec = (BigDecimal)value;
      return Arithmetic.asIntNum(dec.divide(XDataType.DECIMAL_ONE, 0, 2).toBigInteger());
    }
    return ((RealNum)value).toInt(2);
  }
  
  public static Object round(Object arg)
  {
    Number value = numberCast(arg);
    if (value == null)
      return arg;
    if ((value instanceof Double))
    {
      double val = ((Double)value).doubleValue();
      if ((val >= -0.5D) && (val <= 0.0D) && ((val < 0.0D) || (Double.doubleToLongBits(val) < 0L)))
      {
        val = -0.0D;
      } else
        val = Math.floor(val + 0.5D);
      return XDataType.makeDouble(val);
    }
    if ((value instanceof Float))
    {
      float val = ((Float)value).floatValue();
      if ((val >= -0.5D) && (val <= 0.0D) && ((val < 0.0D) || (Float.floatToIntBits(val) < 0)))
      {
        val = -0.0F;
      } else
        val = (float)Math.floor(val + 0.5D);
      return XDataType.makeFloat(val);
    }
    if ((value instanceof BigDecimal))
    {
      BigDecimal dec = (BigDecimal)value;
      int mode = dec.signum() >= 0 ? 4 : 5;
      
      dec = dec.divide(XDataType.DECIMAL_ONE, 0, mode);
      return Arithmetic.asIntNum(dec.toBigInteger());
    }
    return ((RealNum)value).toInt(4);
  }
  
  public static Object roundHalfToEven(Object value, IntNum precision)
  {
    Number number = numberCast(value);
    if (number == null)
      return value;
    if (((value instanceof Double)) || ((value instanceof Float)))
    {
      double v = ((Number)value).doubleValue();
      if ((v == 0.0D) || (Double.isInfinite(v)) || (Double.isNaN(v)))
        return value;
    }
    BigDecimal dec = (BigDecimal)XDataType.decimalType.cast(number);
    int prec = precision.intValue();
    
























    dec = dec.setScale(prec, 6);
    if ((number instanceof Double))
      return XDataType.makeDouble(dec.doubleValue());
    if ((number instanceof Float))
      return XDataType.makeFloat(dec.floatValue());
    if ((number instanceof IntNum))
      return XIntegerType.integerType.cast(dec);
    return dec;
  }
  
  public static Object roundHalfToEven(Object value)
  {
    return roundHalfToEven(value, IntNum.zero());
  }
}
