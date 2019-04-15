package gnu.mapping;




public class SharedLocation<T>
  extends NamedLocation<T>
{
  int timestamp;
  


  public SharedLocation(Symbol symbol, Object property, int timestamp)
  {
    super(symbol, property);
    this.timestamp = timestamp;
  }
  
  public final synchronized T get()
  {
    if (base != null) return base.get();
    if (value == Location.UNBOUND) throw new UnboundLocationException(this);
    return value;
  }
  
  public final synchronized T get(T defaultValue)
  {
    return value == Location.UNBOUND ? defaultValue : base != null ? base.get(defaultValue) : value;
  }
  

  public synchronized boolean isBound()
  {
    return value != Location.UNBOUND ? true : base != null ? base.isBound() : false;
  }
  
  public final synchronized void set(T newValue)
  {
    if (base == null) {
      value = newValue;
    } else if (value == DIRECT_ON_SET)
    {
      base = null;
      value = newValue;
    }
    else if (base.isConstant()) {
      getEnvironment().put(getKeySymbol(), getKeyProperty(), newValue);
    } else {
      base.set(newValue);
    }
  }
}
