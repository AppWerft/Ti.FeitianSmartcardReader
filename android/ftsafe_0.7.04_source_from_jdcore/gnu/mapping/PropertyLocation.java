package gnu.mapping;

import gnu.lists.LList;
import gnu.lists.Pair;





public class PropertyLocation
  extends Location<Object>
{
  Pair pair;
  
  public PropertyLocation() {}
  
  public final Object get()
  {
    return pair.getCar();
  }
  
  public boolean isBound()
  {
    return true;
  }
  
  public final void set(Object newValue)
  {
    pair.setCar(newValue);
  }
  




  public static Object getPropertyList(Object symbol, Environment env)
  {
    return env.get(Symbol.PLIST, symbol, LList.Empty);
  }
  





  public static Object getPropertyList(Object symbol)
  {
    return Environment.getCurrent().get(Symbol.PLIST, symbol, LList.Empty);
  }
  







  public static void setPropertyList(Object symbol, Object plist, Environment env)
  {
    synchronized (env)
    {
      Location lloc = env.lookup(Symbol.PLIST, symbol);
      if ((symbol instanceof Symbol))
      {
        Symbol sym = (Symbol)symbol;
        Object old = lloc.get(LList.Empty);
        Object p = old;
        


        while ((p instanceof Pair))
        {
          Pair pair = (Pair)p;
          Object property = pair.getCar();
          if (plistGet(plist, property, null) != null)
            env.remove(sym, property);
          p = ((Pair)pair.getCdr()).getCdr();
        }
        
        p = plist;
        

        while ((p instanceof Pair))
        {
          Pair pair = (Pair)p;
          Object property = pair.getCar();
          Location loc = env.lookup(sym, property);
          PropertyLocation ploc;
          PropertyLocation ploc; if ((loc != null) && (((loc = loc.getBase()) instanceof PropertyLocation)))
          {

            ploc = (PropertyLocation)loc;
          }
          else
          {
            ploc = new PropertyLocation();
            env.addLocation(sym, property, ploc);
          }
          Pair valuePair = (Pair)pair.getCdr();
          pair = valuePair;
          
          p = valuePair.getCdr();
        }
      }
      lloc.set(plist);
    }
  }
  




  public static void setPropertyList(Object symbol, Object plist)
  {
    setPropertyList(symbol, plist, Environment.getCurrent());
  }
  









  public static Object getProperty(Object symbol, Object property, Object defaultValue, Environment env)
  {
    if (!(symbol instanceof Symbol))
    {
      if ((symbol instanceof String)) {
        symbol = Namespace.getDefaultSymbol((String)symbol);
      } else {
        return plistGet(env.get(Symbol.PLIST, symbol, LList.Empty), property, defaultValue);
      }
    }
    return env.get((Symbol)symbol, property, defaultValue);
  }
  





  public static Object getProperty(Object symbol, Object property, Object defaultValue)
  {
    return getProperty(symbol, property, defaultValue, Environment.getCurrent());
  }
  


  public static void putProperty(Object symbol, Object property, Object newValue, Environment env)
  {
    if (!(symbol instanceof Symbol))
    {
      if ((symbol instanceof String)) {
        symbol = Namespace.getDefaultSymbol((String)symbol);
      }
      else {
        Location lloc = env.getLocation(Symbol.PLIST, symbol);
        lloc.set(plistPut(lloc.get(LList.Empty), property, newValue));
        return;
      }
    }
    Location loc = env.lookup((Symbol)symbol, property);
    if ((loc != null) && (((loc = loc.getBase()) instanceof PropertyLocation))) {
      ((PropertyLocation)loc).set(newValue);
    }
    else {
      Location lloc = env.getLocation(Symbol.PLIST, symbol);
      Object plist = lloc.get(LList.Empty);
      Pair pair = null;
      




















      pair = new Pair(newValue, plist);
      plist = new Pair(property, pair);
      lloc.set(plist);
      PropertyLocation ploc = new PropertyLocation();
      
      pair = pair;
      env.addLocation((Symbol)symbol, property, ploc);
    }
  }
  




  public static void putProperty(Object symbol, Object property, Object newValue)
  {
    putProperty(symbol, property, newValue, Environment.getCurrent());
  }
  



  public static boolean removeProperty(Object symbol, Object property, Environment env)
  {
    Location ploc = env.lookup(Symbol.PLIST, symbol);
    if (ploc == null)
      return false;
    Object plist = ploc.get(LList.Empty);
    if (!(plist instanceof Pair))
      return false;
    Pair pair = (Pair)plist;
    Pair prev = null;
    

    while (pair.getCar() != property)
    {
      Object next = pair.getCdr();
      if (!(next instanceof Pair))
        return false;
      prev = pair;
      pair = (Pair)next;
    }
    Object tail = ((Pair)pair.getCdr()).getCdr();
    if (prev == null)
    {
      plist = tail;
      ploc.set(plist);
    }
    else {
      prev.setCdr(tail); }
    if ((symbol instanceof Symbol))
      env.remove((Symbol)symbol, property);
    return true;
  }
  



  public static boolean removeProperty(Object symbol, Object property)
  {
    return removeProperty(symbol, property, Environment.getCurrent());
  }
  



  public static Object plistGet(Object plist, Object prop, Object dfault)
  {
    while ((plist instanceof Pair))
    {
      Pair pair = (Pair)plist;
      if (pair.getCar() == prop)
        return ((Pair)pair.getCdr()).getCar();
    }
    return dfault;
  }
  



  public static Object plistPut(Object plist, Object prop, Object value)
  {
    for (Object p = plist; (p instanceof Pair);)
    {
      Pair pair = (Pair)p;
      Pair next = (Pair)pair.getCdr();
      if (pair.getCar() == prop)
      {
        next.setCar(value);
        return plist;
      }
      p = next.getCdr();
    }
    return new Pair(prop, new Pair(value, plist));
  }
  



  public static Object plistRemove(Object plist, Object prop)
  {
    Pair prev = null;
    for (Object p = plist; (p instanceof Pair);)
    {
      Pair pair = (Pair)p;
      Pair next = (Pair)pair.getCdr();
      p = next.getCdr();
      if (pair.getCar() == prop)
      {
        if (prev == null)
          return p;
        prev.setCdr(p);
        return plist;
      }
      prev = next;
    }
    return plist;
  }
}
