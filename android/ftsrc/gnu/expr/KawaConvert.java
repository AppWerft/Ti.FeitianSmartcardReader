package gnu.expr;

import gnu.lists.Convert;
import gnu.mapping.Lazy;
import gnu.math.IntNum;
import gnu.text.Char;

public class KawaConvert extends Convert
{
  public KawaConvert() {}
  
  public static Convert instance = new KawaConvert();
  
  public static Convert getInstance() { return instance; }
  
  public static void setInstance(Convert value) { instance = value; }
  
  public Object charToObject(char ch)
  {
    return Char.make(ch);
  }
  
  public char objectToChar(Object obj)
  {
    return ((Char)obj).charValue();
  }
  
  public Object byteToObject(byte value)
  {
    return IntNum.valueOf(value);
  }
  
  public Object shortToObject(short value)
  {
    return IntNum.valueOf(value);
  }
  
  public Object intToObject(int value)
  {
    return IntNum.valueOf(value);
  }
  
  public Object longToObject(long value)
  {
    return IntNum.valueOf(value);
  }
  
  public Object byteToObjectUnsigned(byte value)
  {
    return IntNum.valueOf(value & 0xFF);
  }
  
  public Object shortToObjectUnsigned(short value)
  {
    return IntNum.valueOf(value & 0xFFFF);
  }
  
  public Object intToObjectUnsigned(int value)
  {
    return IntNum.valueOf(value & 0xFFFFFFFF);
  }
  
  public Object longToObjectUnsigned(long value)
  {
    return IntNum.valueOfUnsigned(value);
  }
  
  public Object floatToObject(float value)
  {
    return gnu.math.DFloNum.valueOf(value);
  }
  
  public Object doubleToObject(double value) {
    return gnu.math.DFloNum.valueOf(value);
  }
  
  public static boolean isTrue(Object value) {
    for (;;) {
      if ((value instanceof Boolean))
        return ((Boolean)value).booleanValue();
      if (value == null)
        return false;
      if (!(value instanceof Lazy)) break;
      value = ((Lazy)value).getValue();
    }
    return true;
  }
}
