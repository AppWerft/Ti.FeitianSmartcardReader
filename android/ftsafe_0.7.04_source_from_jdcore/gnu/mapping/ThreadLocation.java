package gnu.mapping;

public class ThreadLocation<T>
  extends NamedLocation<T>
  implements Named
{
  static int counter;
  
  private static synchronized int nextCounter()
  {
    return ++counter;
  }
  
  static final Object NULL_PROXY = new Object();
  private ThreadLocal thLocal;
  private boolean stringName;
  private boolean importedThreadLocal;
  
  private boolean importedThreadLocal()
  {
    return importedThreadLocal;
  }
  
  public ThreadLocation() {
    this("param#" + nextCounter());
  }
  

  public ThreadLocation(String name)
  {
    this(Symbol.makeUninterned(name));
  }
  
  public ThreadLocation(Symbol name) {
    super(name, null);
    thLocal = new ThreadLocalWithDefault(null);
  }
  
  public ThreadLocation(Symbol name, ThreadLocal<T> thLocal) {
    super(name, null);
    this.thLocal = thLocal;
    importedThreadLocal = true;
  }
  


  public static ThreadLocation makeAnonymous(String name)
  {
    ThreadLocation loc = new ThreadLocation(name);
    stringName = true;
    return loc;
  }
  


  public static ThreadLocation makeAnonymous(Symbol name)
  {
    return new ThreadLocation(name);
  }
  
  public void setGlobal(T value)
  {
    synchronized (this) {
      ((ThreadLocalWithDefault)thLocal).setDefault(value);
    }
  }
  
  public T get() {
    Object value = thLocal.get();
    if (importedThreadLocal())
      return value;
    if (value == Location.UNBOUND)
      throw new UnboundLocationException(this);
    return value == NULL_PROXY ? null : value;
  }
  
  public T get(T defaultValue) {
    Object value = thLocal.get();
    if (importedThreadLocal())
      return value;
    if (value == UNBOUND)
      return defaultValue;
    return value == NULL_PROXY ? null : value;
  }
  
  public boolean isBound() {
    return (importedThreadLocal()) || (thLocal.get() != Location.UNBOUND);
  }
  
  public void set(T value) {
    thLocal.set((value == null) && (!importedThreadLocal()) ? NULL_PROXY : value);
  }
  
  public Object setWithSave(T newValue)
  {
    Object old = thLocal.get();
    
    set(newValue);
    return old;
  }
  
  public void setRestore(Object oldValue) {
    thLocal.set(oldValue);
  }
  
  public void undefine() {
    if (importedThreadLocal()) {
      thLocal.remove();
    } else
      thLocal.set(UNBOUND);
  }
  
  public String getName() { return name == null ? null : name.toString(); }
  




  public Object getSymbol()
  {
    if (stringName)
      return name.toString();
    return name;
  }
  
  public void setName(String name) { throw new RuntimeException("setName not allowed"); }
  
  static class ThreadLocalWithDefault<T> extends InheritableThreadLocal<T> {
    T defaultValue;
    
    public ThreadLocalWithDefault(T defaultValue) {
      this.defaultValue = defaultValue;
    }
    
    public void setDefault(T value) { defaultValue = value; }
    
    protected T initialValue() { return defaultValue; }
  }
}
