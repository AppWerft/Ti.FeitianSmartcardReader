package kawa.lang;

import gnu.lists.Consumer;
import gnu.lists.Pair;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ListRepeatPat extends Pattern implements gnu.kawa.format.Printable, java.io.Externalizable
{
  Pattern element_pattern;
  
  public ListRepeatPat() {}
  
  public ListRepeatPat(Pattern element_pattern)
  {
    this.element_pattern = element_pattern;
  }
  
  public static ListRepeatPat make(Pattern element_pattern)
  {
    return new ListRepeatPat(element_pattern);
  }
  
  public void print(Consumer out)
  {
    out.write("#<list-repeat-pattern ");
    element_pattern.print(out);
    out.write(62);
  }
  







  public boolean match(Object obj, Object[] vars, int start_vars)
  {
    int length = gnu.lists.LList.listLength(obj, false);
    if (length < 0) {
      return false;
    }
    int var_count = element_pattern.varCount();
    int i = var_count; for (;;) { i--; if (i < 0) break;
      vars[(start_vars + i)] = new Object[length]; }
    Object[] element_vars = new Object[var_count];
    for (int j = 0; j < length; j++)
    {
      Pair pair = (Pair)obj;
      






      if (!element_pattern.match(pair.getCar(), element_vars, 0))
        return false;
      for (int i = 0; i < var_count; i++)
        ((Object[])vars[(start_vars + i)])[j] = element_vars[i];
      obj = pair.getCdr();
    }
    return true;
  }
  
  public int varCount() { return element_pattern.varCount(); }
  


  public void writeExternal(ObjectOutput out)
    throws java.io.IOException
  {
    out.writeObject(element_pattern);
  }
  
  public void readExternal(ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    element_pattern = ((Pattern)in.readObject());
  }
}
