package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;











public class LineNumbersAttr
  extends Attribute
{
  short[] linenumber_table;
  int linenumber_count;
  
  public LineNumbersAttr(CodeAttr code)
  {
    super("LineNumberTable");
    addToFrontOf(code);
    lines = this;
  }
  
  public LineNumbersAttr(short[] numbers, CodeAttr code)
  {
    this(code);
    linenumber_table = numbers;
    linenumber_count = (numbers.length >> 1);
  }
  



  public void put(int linenumber, int PC)
  {
    if (linenumber_table == null) {
      linenumber_table = new short[32];
    } else if (2 * linenumber_count >= linenumber_table.length)
    {
      short[] new_linenumbers = new short[2 * linenumber_table.length];
      System.arraycopy(linenumber_table, 0, new_linenumbers, 0, 2 * linenumber_count);
      
      linenumber_table = new_linenumbers;
    }
    linenumber_table[(2 * linenumber_count)] = ((short)PC);
    linenumber_table[(2 * linenumber_count + 1)] = ((short)linenumber);
    linenumber_count += 1;
  }
  

  public final int getLength() { return 2 + 4 * linenumber_count; }
  
  public int getLineCount() { return linenumber_count; }
  public short[] getLineNumberTable() { return linenumber_table; }
  
  public void write(DataOutputStream dstr) throws IOException
  {
    dstr.writeShort(linenumber_count);
    int count = 2 * linenumber_count;
    for (int i = 0; i < count; i++)
    {
      dstr.writeShort(linenumber_table[i]);
    }
  }
  
  public void print(ClassTypeWriter dst)
  {
    dst.print("Attribute \"");
    dst.print(getName());
    dst.print("\", length:");
    dst.print(getLength());
    dst.print(", count: ");
    dst.println(linenumber_count);
    for (int i = 0; i < linenumber_count; i++)
    {
      dst.print("  line: ");
      dst.print(linenumber_table[(2 * i + 1)] & 0xFFFF);
      dst.print(" at pc: ");
      dst.println(linenumber_table[(2 * i)] & 0xFFFF);
    }
  }
}
