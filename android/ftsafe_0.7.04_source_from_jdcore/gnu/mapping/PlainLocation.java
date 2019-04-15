package gnu.mapping;



public class PlainLocation<T>
  extends NamedLocation<T>
{
  public PlainLocation(Symbol symbol, Object property)
  {
    super(symbol, property);
  }
  
  public PlainLocation(Symbol symbol, Object property, T value)
  {
    super(symbol, property);
    this.value = value;
  }
  
  public final T get()
  {
    if (base != null) return base.get();
    if (value == Location.UNBOUND) throw new UnboundLocationException(this);
    return value;
  }
  
  public final T get(T defaultValue)
  {
    return value == Location.UNBOUND ? defaultValue : base != null ? base.get(defaultValue) : value;
  }
  

  public boolean isBound()
  {
    return value != Location.UNBOUND ? true : base != null ? base.isBound() : false;
  }
  
  public final void set(T newValue)
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
