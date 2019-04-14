package kawa.lang;

import gnu.lists.Consumer;

public class VarListPat extends Pattern
{
  int min_length;
  
  public VarListPat(int min) {
    min_length = min;
  }
  






  public boolean match(Object obj, Object[] vars, int start_vars)
  {
    for (int i = 0; i < min_length; i++)
    {
      if ((obj instanceof gnu.lists.Pair))
      {
        gnu.lists.Pair p = (gnu.lists.Pair)obj;
        vars[(start_vars + i)] = p.getCar();
        obj = p.getCdr();
      }
      else {
        return false;
      } }
    vars[(start_vars + i)] = obj;
    return true;
  }
  
  public int varCount() { return min_length + 1; }
  
  public void print(Consumer out)
  {
    out.write("#<varlist-pattern min:");
    out.writeInt(min_length);
    out.write(62);
  }
}
