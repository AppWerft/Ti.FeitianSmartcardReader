package gnu.mapping;



public class KeyPair
  implements EnvironmentKey
{
  Symbol name;
  
  Object property;
  

  public KeyPair(Symbol name, Object property)
  {
    this.name = name;
    this.property = property;
  }
  
  public Symbol getKeySymbol() { return name; }
  public Object getKeyProperty() { return property; }
  
  public final boolean matches(EnvironmentKey key)
  {
    return (Symbol.equals(key.getKeySymbol(), name)) && (key.getKeyProperty() == property);
  }
  

  public final boolean matches(Symbol symbol, Object property)
  {
    return (Symbol.equals(symbol, name)) && (property == this.property);
  }
  
  public boolean equals(Object x)
  {
    if (!(x instanceof KeyPair))
      return false;
    KeyPair e2 = (KeyPair)x;
    return (property == property) && (name == null ? name == null : name.equals(name));
  }
  

  public int hashCode()
  {
    return name.hashCode() ^ System.identityHashCode(property);
  }
  
  public String toString() { return "KeyPair[sym:" + name + " prop:" + property + "]"; }
}
