package kawa.lang;

import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class EqualPat
  extends Pattern
  implements Printable, Externalizable
{
  Object value;
  
  public EqualPat() {}
  
  public EqualPat(Object obj) { value = obj; }
  
  public static EqualPat make(Object obj) { return new EqualPat(obj); }
  


  public boolean match(Object obj, Object[] vars, int start_vars)
  {
    if (((value instanceof String)) && ((obj instanceof Symbol)))
      obj = ((Symbol)obj).getName();
    return value.equals(obj);
  }
  
  public int varCount() { return 0; }
  
  public void print(Consumer out)
  {
    out.write("#<equals: ");
    gnu.kawa.format.ReportFormat.print(value, out);
    out.write(62);
  }
  


  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(value);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    value = in.readObject();
  }
}
