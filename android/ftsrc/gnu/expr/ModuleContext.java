package gnu.expr;

import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;







public class ModuleContext
{
  static ModuleContext global = new ModuleContext(ModuleManager.instance);
  
  ModuleManager manager;
  public static int IN_HTTP_SERVER = 1;
  public static int IN_SERVLET = 2;
  
  public int getFlags() { return flags; }
  public void setFlags(int flags) { this.flags = flags; }
  public void addFlags(int flags) { this.flags |= flags; }
  
  public ModuleContext(ModuleManager manager)
  {
    this.manager = manager;
  }
  

  int flags;
  public static ModuleContext getContext()
  {
    return global;
  }
  
  public ModuleManager getManager()
  {
    return manager;
  }
  
  private ClassToInstanceMap table = new ClassToInstanceMap();
  

  public synchronized Object findInstance(ModuleInfo info)
  {
    Class clas;
    try
    {
      clas = info.getModuleClass();
    }
    catch (ClassNotFoundException ex)
    {
      String cname = info.getClassName();
      throw new WrappedException("cannot find module " + cname, ex);
    }
    return findInstance(clas);
  }
  
  public synchronized Object searchInstance(Class clas)
  {
    return table.get(clas);
  }
  
  public synchronized Object findInstance(Class clas)
  {
    Object inst = table.get(clas);
    if (inst == null)
    {
      try
      {
        try
        {
          inst = clas.getDeclaredField("$instance").get(null);

        }
        catch (NoSuchFieldException ex)
        {
          inst = clas.newInstance();
        }
      }
      catch (Exception ex)
      {
        throw new WrappedException("exception while initializing module " + clas.getName(), ex);
      }
      
      setInstance(inst);
    }
    return inst;
  }
  
  public synchronized void setInstance(Object instance)
  {
    table.put(instance.getClass(), instance);
  }
  
  public ModuleInfo findFromInstance(Object instance)
  {
    Class instanceClass = instance.getClass();
    synchronized (this)
    {
      ModuleInfo info = ModuleManager.findWithClass(instanceClass);
      setInstance(instance);
      return info;
    }
  }
  



  public synchronized void clear()
  {
    table.clear();
  }
  
  static class ClassToInstanceMap extends AbstractWeakHashTable<Class, Object> {
    ClassToInstanceMap() {}
    
    protected Class getKeyFromValue(Object instance) {
      return instance.getClass();
    }
    
    protected boolean matches(Class oldValue, Class newValue)
    {
      return oldValue == newValue;
    }
  }
}
