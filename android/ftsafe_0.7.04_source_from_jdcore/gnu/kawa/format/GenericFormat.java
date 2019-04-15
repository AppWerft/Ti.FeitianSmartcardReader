package gnu.kawa.format;

import gnu.lists.Consumer;

public class GenericFormat extends AbstractFormat
{
  protected AbstractFormat next;
  
  public GenericFormat() {}
  
  java.util.List<Entry> entries = new java.util.ArrayList();
  
  java.util.Map<Class, Object[]> map = new java.util.HashMap();
  
  public GenericFormat(AbstractFormat next) {
    this.next = next;
  }
  
  public void add(Entry entry)
  {
    entries.add(entry);
  }
  
  public void add(Class cls, String mname) { add(Entry.valueOf(cls, mname)); }
  


  public void addInvalidatingCache(Entry entry, Class cls)
  {
    invalidateCache(cls);
    entries.add(entry);
  }
  
  public void invalidateCache(Class cls) {
    java.util.Iterator<Class> it = map.keySet().iterator();
    while (it.hasNext()) {
      Class key = (Class)it.next();
      if (cls.isAssignableFrom(key))
        it.remove();
    }
  }
  
  public void writeObject(Object value, Consumer out) {
    GenericFormat curFormat = this;
    for (;;) {
      if (curFormat.tryFormat(value, this, out))
        return;
      AbstractFormat next = next;
      if ((next instanceof GenericFormat)) {
        curFormat = (GenericFormat)next;
      } else {
        if (next != null) {
          next.writeObject(value, out);
        } else
          out.write(value == null ? "(null)" : value.toString());
        return;
      }
    }
  }
  
  public boolean tryFormat(Object value, AbstractFormat format, Consumer out) {
    Class cls = value == null ? Object.class : value.getClass();
    Object[] cache = (Object[])map.get(cls);
    



    int j = 0;
    


    if (cache != null) {
      for (;;) {
        Object entry = cache[j];
        if ((entry instanceof Entry)) {
          TryFormatResult res = ((Entry)entry).tryFormat(value, format, out);
          
          if (res == TryFormatResult.HANDLED)
            return true;
          j++;
        } else {
          int oldestEntry = ((Integer)entry).intValue();
          break;
        }
      }
    }
    int oldestEntry = entries.size();
    cache = new Object[8];
    j = 0;
    
    int i = oldestEntry; for (;;) { i--; if (i < 0) break;
      Entry entry = (Entry)entries.get(i);
      TryFormatResult res = entry.tryFormat(value, format, out);
      if (res != TryFormatResult.INVALID_CLASS)
      {
        if (j + 2 >= cache.length) {
          Object[] tmp = new Object[3 * cache.length >> 1];
          System.arraycopy(cache, 0, tmp, 0, cache.length);
          cache = tmp;
        }
        cache[(j++)] = entry;
        if (res == TryFormatResult.HANDLED) {
          cache[(j++)] = Integer.valueOf(i);
          map.put(cls, cache);
          return true;
        }
      } }
    cache[(j++)] = Integer.valueOf(0);
    map.put(cls, cache);
    return false;
  }
  

  public static enum TryFormatResult
  {
    INVALID_CLASS, 
    INVALID, 
    HANDLED;
    
    private TryFormatResult() {} }
  
  public static class Entry { public static Entry defaultInstance = new Entry();
    
    public Entry() {}
    
    public GenericFormat.TryFormatResult tryFormat(Object value, AbstractFormat format, Consumer out)
    {
      out.write(value == null ? "(null)" : value.toString());
      return GenericFormat.TryFormatResult.HANDLED;
    }
    
    public static Entry valueOf(Class cls, String mname) { GenericFormat.MethodEntry entry = new GenericFormat.MethodEntry();
      


      try
      {
        method = cls.getDeclaredMethod(mname, GenericFormat.MethodEntry.mtype);
      }
      catch (Exception ex) {
        throw new RuntimeException(ex);
      }
      return entry;
    }
  }
  



  public static class MethodEntry
    extends GenericFormat.Entry
  {
    java.lang.reflect.Method method;
    


    private static final Class[] mtype = { Object.class, AbstractFormat.class, Consumer.class };
    

    public MethodEntry() {}
    

    public GenericFormat.TryFormatResult tryFormat(Object value, AbstractFormat format, Consumer out)
    {
      try
      {
        return (GenericFormat.TryFormatResult)method.invoke(null, new Object[] { value, format, out });
      }
      catch (Throwable ex)
      {
        throw new RuntimeException(ex);
      }
    }
  }
}
