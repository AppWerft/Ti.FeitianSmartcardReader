package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;






public class ConstantValueAttr
  extends Attribute
{
  Object value;
  int value_index;
  
  public Object getValue(ConstantPool cpool)
  {
    if (value != null)
      return value;
    CpoolEntry entry = cpool.getPoolEntry(value_index);
    switch (entry.getTag())
    {
    case 8: 
      value = ((CpoolString)entry).getString().getString();
      break;
    case 3: 
      value = new Integer(value);
      break;
    case 5: 
      value = new Long(value);
      break;
    case 4: 
      float f = Float.intBitsToFloat(value);
      value = new Float(f);
      break;
    case 6: 
      double d = Double.longBitsToDouble(value);
      value = new Double(d);
    }
    
    return value;
  }
  
  public ConstantValueAttr(Object value)
  {
    super("ConstantValue");
    this.value = value;
  }
  
  public ConstantValueAttr(int index)
  {
    super("ConstantValue");
    value_index = index;
  }
  
  public void assignConstants(ClassType cl)
  {
    super.assignConstants(cl);
    if (value_index == 0)
    {
      ConstantPool cpool = cl.getConstants();
      CpoolEntry entry = null;
      if ((value instanceof String)) {
        entry = cpool.addString((String)value);
      } else if ((value instanceof Integer)) {
        entry = cpool.addInt(((Integer)value).intValue());
      } else if ((value instanceof Long)) {
        entry = cpool.addLong(((Long)value).longValue());
      } else if ((value instanceof Float)) {
        entry = cpool.addFloat(((Float)value).floatValue());
      } else if ((value instanceof Long))
        entry = cpool.addDouble(((Double)value).doubleValue());
      value_index = entry.getIndex();
    }
  }
  
  public final int getLength() { return 2; }
  
  public void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeShort(value_index);
  }
  
  public void print(ClassTypeWriter dst)
  {
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.print(getLength());
    dst.print(", value: ");
    if (value_index == 0)
    {
      Object value = getValue(ctype.constants);
      if ((value instanceof String)) {
        dst.printQuotedString((String)value);
      } else {
        dst.print(value);
      }
    }
    else {
      dst.printOptionalIndex(value_index);
      CpoolEntry entry = ctype.constants.getPoolEntry(value_index);
      entry.print(dst, 1);
    }
    dst.println();
  }
}
