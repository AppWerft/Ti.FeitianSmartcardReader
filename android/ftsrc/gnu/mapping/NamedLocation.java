package gnu.mapping;

import java.util.Map.Entry;



public abstract class NamedLocation<T>
  extends IndirectableLocation<T>
  implements Map.Entry<EnvironmentKey, T>, EnvironmentKey
{
  NamedLocation next;
  final Symbol name;
  final Object property;
  
  public boolean entered()
  {
    return next != null;
  }
  
  public Environment getEnvironment()
  {
    for (NamedLocation loc = this; loc != null; loc = next)
    {
      if (name == null)
      {
        Environment env = (Environment)value;
        if (env != null)
          return env;
      }
    }
    return super.getEnvironment();
  }
  



  public NamedLocation(NamedLocation loc)
  {
    name = name;
    property = property;
  }
  
  public NamedLocation(Symbol name, Object property)
  {
    this.name = name;
    this.property = property;
  }
  
  public final Symbol getKeySymbol()
  {
    return name;
  }
  
  public final Object getKeyProperty()
  {
    return property;
  }
  
  public final boolean matches(EnvironmentKey key)
  {
    return (Symbol.equals(key.getKeySymbol(), name)) && (key.getKeyProperty() == property);
  }
  

  public final boolean matches(Symbol symbol, Object property)
  {
    return (Symbol.equals(symbol, name)) && (property == this.property);
  }
  
  public final EnvironmentKey getKey()
  {
    if (property == null) {
      return name;
    }
    return this;
  }
  
  public boolean equals(Object x)
  {
    if (!(x instanceof NamedLocation))
      return false;
    NamedLocation e2 = (NamedLocation)x;
    if (name == null ? name != null : !name.equals(name))
      return false;
    if (property != property)
      return false;
    Object val1 = getValue();
    Object val2 = e2.getValue();
    if (val1 == val2)
      return true;
    if ((val1 == null) || (val2 == null))
      return false;
    return val1.equals(val2);
  }
  
  public int hashCode()
  {
    int h = name.hashCode() ^ System.identityHashCode(property);
    Object val = getValue();
    if (val != null)
      h ^= val.hashCode();
    return h;
  }
  
  public synchronized Object setWithSave(T newValue) {
    Object old;
    if (base != null) {
      if (value == INDIRECT_FLUIDS)
        return base.setWithSave(newValue);
      Object old = base;
      base = null;
    } else {
      old = value;
    }
    value = newValue;
    return old;
  }
  
  public synchronized void setRestore(Object oldValue)
  {
    if (value == INDIRECT_FLUIDS) {
      base.setRestore(oldValue);

    }
    else if ((oldValue instanceof Location))
    {
      value = null;
      base = ((Location)oldValue);
    }
    else
    {
      value = oldValue;
      base = null;
    }
  }
}
