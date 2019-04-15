package gnu.expr;

import gnu.bytecode.Field;



public abstract class Initializer
{
  Initializer next;
  public Field field;
  
  public Initializer() {}
  
  public abstract void emit(Compilation paramCompilation);
  
  public static Initializer reverse(Initializer list)
  {
    Initializer prev = null;
    while (list != null)
    {
      Initializer next = list.next;
      list.next = prev;
      prev = list;
      list = next;
    }
    return prev;
  }
  
  public void reportError(String message, Compilation comp)
  {
    comp.error('e', message + "field " + field);
  }
}
