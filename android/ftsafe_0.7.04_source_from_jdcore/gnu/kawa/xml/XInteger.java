package gnu.kawa.xml;

import gnu.math.IntNum;







public class XInteger
  extends IntNum
{
  private XIntegerType type;
  
  public XIntegerType getIntegerType()
  {
    return type;
  }
  
  XInteger(IntNum value, XIntegerType type)
  {
    words = words;
    ival = ival;
    this.type = type;
  }
}
