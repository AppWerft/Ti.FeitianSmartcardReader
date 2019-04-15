package gnu.mapping;

import java.io.PrintWriter;











public abstract class Location<T>
{
  public Location() {}
  
  public Symbol getKeySymbol()
  {
    return null;
  }
  
  public Object getKeyProperty()
  {
    return null;
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer();
    sbuf.append(getClass().getName());
    Symbol sym = getKeySymbol();
    sbuf.append('[');
    if (sym != null)
    {
      sbuf.append(sym);
      Object property = getKeyProperty();
      

      if ((property != null) && (property != this))
      {
        sbuf.append('/');
        sbuf.append(property);
      }
    }
    



    sbuf.append("]");
    return sbuf.toString();
  }
  

  public static final String UNBOUND = new String("(unbound)");
  
  public T get(T defaultValue)
  {
    return isBound() ? get() : defaultValue;
  }
  

  public abstract T get();
  

  public abstract void set(T paramT);
  
  public void undefine()
  {
    throw new UnsupportedOperationException();
  }
  



  public Object setWithSave(T newValue)
  {
    Object old = isBound() ? get() : UNBOUND;
    set(newValue);
    return old;
  }
  


  public void setRestore(Object oldValue)
  {
    if (oldValue == UNBOUND) {
      undefine();
    } else {
      set(oldValue);
    }
  }
  
  public abstract boolean isBound();
  
  public boolean isConstant() {
    return false;
  }
  
  public Location getBase()
  {
    return this;
  }
  
  public final T getValue()
  {
    return get(null);
  }
  
  public final T setValue(T newValue)
  {
    T value = get(null);
    set(newValue);
    return value;
  }
  

  public boolean entered()
  {
    return false;
  }
  
  public void print(PrintWriter ps)
  {
    ps.print("#<location ");
    Symbol name = getKeySymbol();
    if (name != null)
      ps.print(name);
    if (isBound())
    {
      ps.print(" -> ");
      try
      {
        ps.print(get());
      }
      catch (Exception ex)
      {
        ps.print("<caught " + ex + ">");
      }
    }
    else {
      ps.print("(unbound)"); }
    ps.print('>');
  }
  

  public static Location make(Object init, String name)
  {
    ThreadLocation loc = new ThreadLocation(name);
    loc.setGlobal(init);
    return loc;
  }
  

  public static IndirectableLocation make(String name)
  {
    Symbol sym = Namespace.EmptyNamespace.getSymbol(name.intern());
    PlainLocation loc = new PlainLocation(sym, null);
    base = null;
    value = UNBOUND;
    return loc;
  }
  
  public static IndirectableLocation make(Symbol name)
  {
    PlainLocation loc = new PlainLocation(name, null);
    base = null;
    value = UNBOUND;
    return loc;
  }
  





  public static Location define(Symbol name)
  {
    Environment env = Environment.getCurrent();
    int hash = name.hashCode();
    NamedLocation loc = env.getLocation(name, null, hash, true);
    if (loc.isConstant()) {
      Object value = loc.get(UNBOUND);
      value = value;
      base = null;
    }
    return loc;
  }
}
