package gnu.expr;

import gnu.mapping.SimpleSymbol;









public class Symbols
{
  private static int gensym_counter;
  
  private Symbols() {}
  
  static synchronized int generateInt()
  {
    return ++gensym_counter;
  }
  


































  public static final SimpleSymbol gentemp()
  {
    return SimpleSymbol.valueOf("GS." + Integer.toString(generateInt()));
  }
  





  public static String make(String name)
  {
    return name.intern();
  }
  
  public static final String intern(String name)
  {
    return make(name);
  }
}
