package gnu.mapping;


public abstract class PropertySet
  implements Named
{
  private Object[] properties;
  public static final Symbol nameKey = Namespace.EmptyNamespace.getSymbol("name");
  
  public PropertySet() {}
  
  public String getName() { Object symbol = getProperty(nameKey, null);
    return (symbol instanceof Symbol) ? ((Symbol)symbol).getName() : symbol == null ? null : symbol.toString();
  }
  


  public Object getSymbol()
  {
    return getProperty(nameKey, null);
  }
  
  public final void setSymbol(Object name)
  {
    setProperty(nameKey, name);
  }
  
  public final void setName(String name)
  {
    setProperty(nameKey, name);
  }
  
  public Object getProperty(Object key, Object defaultValue)
  {
    if (properties != null)
    {
      int i = properties.length; do { i -= 2; if (i < 0)
          break;
      } while (properties[i] != key);
      return properties[(i + 1)];
    }
    
    return defaultValue;
  }
  
  public synchronized void setProperty(Object key, Object value)
  {
    properties = setProperty(properties, key, value);
  }
  








  public static Object[] setProperty(Object[] properties, Object key, Object value)
  {
    Object[] props = properties;
    int avail; int avail; if (props == null)
    {
      properties = props = new Object[10];
      avail = 0;
    }
    else
    {
      avail = -1;
      int i = props.length; for (;;) { i -= 2; if (i < 0)
          break;
        Object k = props[i];
        if (k == key)
        {
          Object old = props[(i + 1)];
          props[(i + 1)] = value;
          return properties;
        }
        if (k == null)
          avail = i;
      }
      if (avail < 0)
      {
        avail = props.length;
        properties = new Object[2 * avail];
        System.arraycopy(props, 0, properties, 0, avail);
        props = properties;
      }
    }
    props[avail] = key;
    props[(avail + 1)] = value;
    return properties;
  }
  
  public Object removeProperty(Object key)
  {
    Object[] props = properties;
    if (props == null)
      return null;
    int i = props.length; for (;;) { i -= 2; if (i < 0)
        break;
      Object k = props[i];
      if (k == key)
      {
        Object old = props[(i + 1)];
        props[i] = null;
        props[(i + 1)] = null;
        return old;
      }
    }
    return null;
  }
}
