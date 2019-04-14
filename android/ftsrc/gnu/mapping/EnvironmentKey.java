package gnu.mapping;


















public abstract interface EnvironmentKey
{
  public static final Object FUNCTION = Symbol.FUNCTION;
  
  public abstract Symbol getKeySymbol();
  
  public abstract Object getKeyProperty();
  
  public abstract boolean matches(EnvironmentKey paramEnvironmentKey);
  
  public abstract boolean matches(Symbol paramSymbol, Object paramObject);
}
