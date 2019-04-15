package gnu.mapping;



public class DynamicLocation<T>
  extends NamedLocation<T>
  implements Named
{
  private int hash;
  
  static SimpleEnvironment env;
  

  public DynamicLocation(Symbol name, Object property)
  {
    super(name, property);
    hash = (name.hashCode() ^ System.identityHashCode(property));
  }
  
  public NamedLocation<T> getLocation()
  {
    Environment curenv = Environment.getCurrent();
    NamedLocation<T> loc = curenv.getLocation(name, property, hash, true);
    return loc;
  }
  
  public T get() {
    return getLocation().get();
  }
  
  public T get(T defaultValue) {
    return getLocation().get(defaultValue);
  }
  
  public boolean isBound() {
    return getLocation().isBound();
  }
  
  public void set(T value) {
    getLocation().set(value);
  }
  
  public Object setWithSave(T newValue) {
    return getLocation().setWithSave(newValue);
  }
  
  public void setRestore(Object oldValue) {
    getLocation().setRestore(oldValue);
  }
  
  public void undefine() {
    getLocation().undefine();
  }
  
  public String getName() { return name == null ? null : name.toString(); }
  
  public Object getSymbol() { return name; }
  
  public void setName(String name) {
    throw new RuntimeException("setName not allowed");
  }
  


  public static synchronized DynamicLocation getInstance(Symbol name, Object property)
  {
    if (env == null)
      env = new SimpleEnvironment("[thread-locations]");
    IndirectableLocation loc = (IndirectableLocation)env.getLocation(name, property);
    
    if (base != null)
      return (DynamicLocation)base;
    DynamicLocation tloc = new DynamicLocation(name, property);
    base = tloc;
    return tloc;
  }
}
