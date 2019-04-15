package gnu.mapping;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;
import java.util.Set;

public class SimpleEnvironment extends Environment
{
  NamedLocation[] table;
  int log2Size;
  private int mask;
  int num_bindings;
  int currentTimestamp;
  NamedLocation sharedTail;
  
  public int size()
  {
    return num_bindings;
  }
  
  public static Location getCurrentLocation(String name) {
    return getCurrent().getLocation(name, true);
  }
  
  public static Object lookup_global(Symbol name)
    throws UnboundLocationException
  {
    Location binding = getCurrent().lookup(name);
    if (binding == null)
      throw new UnboundLocationException(name);
    return binding.get();
  }
  



  public SimpleEnvironment()
  {
    this(64);
  }
  
  public SimpleEnvironment(String name)
  {
    this();
    setName(name);
  }
  
  public SimpleEnvironment(int capacity)
  {
    log2Size = 4;
    while (capacity > 1 << log2Size)
      log2Size += 1;
    capacity = 1 << log2Size;
    table = new NamedLocation[capacity];
    mask = (capacity - 1);
    
    sharedTail = new PlainLocation(null, null, this);
  }
  
  public NamedLocation lookup(Symbol name, Object property, int hash)
  {
    return lookupDirect(name, property, hash);
  }
  
  public NamedLocation lookupDirect(Symbol name, Object property, int hash)
  {
    int index = hash & mask;
    for (NamedLocation loc = table[index]; 
        loc != null; loc = next)
    {
      if (loc.matches(name, property))
        return loc;
    }
    return null;
  }
  

  public synchronized NamedLocation getLocation(Symbol name, Object property, int hash, boolean create)
  {
    NamedLocation loc = lookup(name, property, hash);
    if (loc != null)
      return loc;
    if (!create)
      return null;
    return addUnboundLocation(name, property, hash);
  }
  

  protected NamedLocation addUnboundLocation(Symbol name, Object property, int hash)
  {
    int index = hash & mask;
    NamedLocation loc = newEntry(name, property, index);
    base = null;
    value = Location.UNBOUND;
    return loc;
  }
  
  public void put(Symbol key, Object property, Object newValue)
  {
    boolean create = (flags & 0x4) != 0;
    Location loc = getLocation(key, property, create);
    if (loc == null)
      throw new UnboundLocationException(key);
    if (loc.isConstant()) {
      throw new IllegalStateException("attempt to modify read-only location: " + key + " in " + this + " loc:" + loc);
    }
    loc.set(newValue);
  }
  

  protected NamedLocation newLocation(Symbol name, Object property)
  {
    if ((flags & 0x8) != 0) {
      return new SharedLocation(name, property, currentTimestamp);
    }
    return new PlainLocation(name, property);
  }
  
  NamedLocation newEntry(Symbol name, Object property, int index)
  {
    NamedLocation loc = newLocation(name, property);
    NamedLocation first = table[index];
    next = (first == null ? sharedTail : first);
    table[index] = loc;
    num_bindings += 1;
    if (num_bindings >= table.length)
      rehash();
    return loc;
  }
  

  public NamedLocation define(Symbol sym, Object property, int hash, Object newValue)
  {
    int index = hash & mask;
    NamedLocation first = table[index];
    NamedLocation loc = first;
    for (;;)
    {
      if (loc == null)
      {

        loc = newEntry(sym, property, index);
        loc.set(newValue);
        return loc;
      }
      if (loc.matches(sym, property))
      {
        if (loc.isBound() ? !getCanDefine() : !getCanRedefine())
          redefineError(sym, property, loc);
        base = null;
        value = newValue;
        return loc;
      }
      loc = next;
    }
  }
  
  public void define(Symbol sym, Object property, Object newValue)
  {
    int hash = sym.hashCode() ^ System.identityHashCode(property);
    define(sym, property, hash, newValue);
  }
  
  protected void redefineError(Symbol name, Object property, Location loc)
  {
    throw new IllegalStateException("prohibited define/redefine of " + name + " in " + this);
  }
  

  public NamedLocation addLocation(Symbol name, Object property, Location loc)
  {
    return addLocation(name, property, name.hashCode() ^ System.identityHashCode(property), loc);
  }
  


  NamedLocation addLocation(Symbol name, Object property, int hash, Location loc)
  {
    if (((loc instanceof DynamicLocation)) && (property == property))
    {
      loc = ((DynamicLocation)loc).getLocation(); }
    NamedLocation nloc = lookupDirect(name, property, hash);
    if (loc == nloc)
      return nloc;
    boolean bound = nloc != null;
    if (!bound)
      nloc = addUnboundLocation(name, property, hash);
    if ((flags & 0x3) != 3)
    {
      if (bound) {
        bound = nloc.isBound();
      }
      

      if (bound ? (flags & 0x2) == 0 : ((flags & 0x1) == 0) && (loc.isBound()))
      {

        redefineError(name, property, nloc); }
    }
    if ((flags & 0x20) != 0) {
      base = ((SimpleEnvironment)((InheritingEnvironment)this).getParent(0)).addLocation(name, property, hash, loc);
    } else
      base = loc;
    value = IndirectableLocation.INDIRECT_FLUIDS;
    return nloc;
  }
  
  void rehash()
  {
    NamedLocation[] oldTable = table;
    int oldCapacity = oldTable.length;
    int newCapacity = 2 * oldCapacity;
    NamedLocation[] newTable = new NamedLocation[newCapacity];
    int newMask = newCapacity - 1;
    int i = oldCapacity; for (;;) { i--; if (i < 0)
        break;
      NamedLocation element = oldTable[i];
      while ((element != null) && (element != sharedTail))
      {
        NamedLocation next = next;
        Symbol name = name;
        Object property = property;
        int hash = name.hashCode() ^ System.identityHashCode(property);
        int j = hash & newMask;
        NamedLocation head = newTable[j];
        if (head == null)
          head = sharedTail;
        next = head;
        newTable[j] = element;
        element = next;
      }
    }
    table = newTable;
    log2Size += 1;
    mask = newMask;
  }
  
  public Location unlink(Symbol symbol, Object property, int hash)
  {
    int index = hash & mask;
    NamedLocation prev = null;
    NamedLocation loc = table[index];
    while (loc != null)
    {
      NamedLocation next = next;
      if (loc.matches(symbol, property))
      {
        if (!getCanRedefine())
          redefineError(symbol, property, loc);
        if (prev == null) {
          table[index] = next;
        } else
          next = loc;
        num_bindings -= 1;
        return loc;
      }
      prev = loc;
      loc = next;
    }
    return null;
  }
  

  public LocationEnumeration enumerateLocations()
  {
    LocationEnumeration it = new LocationEnumeration(table, 1 << log2Size);
    env = this;
    return it;
  }
  

  public LocationEnumeration enumerateAllLocations()
  {
    return enumerateLocations();
  }
  
  protected boolean hasMoreElements(LocationEnumeration it)
  {
    for (;;)
    {
      if (nextLoc == null)
      {
        prevLoc = null;
        if (--index < 0)
          return false;
        nextLoc = bindings[index];
        if (nextLoc == null) {}
      }
      else {
        if (nextLoc.name != null) break;
        nextLoc = nextLoc.next;
      }
    }
    
    return true;
  }
  
  public void writeExternal(ObjectOutput out) throws IOException
  {
    out.writeObject(getSymbol());
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    setSymbol(in.readObject());
  }
  
  public Object readResolve() throws ObjectStreamException
  {
    String name = getName();
    Environment env = (Environment)envTable.get(name);
    if (env != null)
      return env;
    envTable.put(name, this);
    return this;
  }
  


  public Set entrySet()
  {
    return new EnvironmentMappings(this);
  }
  

  public String toStringVerbose()
  {
    StringBuffer sbuf = new StringBuffer();
    toStringBase(sbuf);
    return "#<environment " + getName() + " num:" + num_bindings + " ts:" + currentTimestamp + sbuf + '>';
  }
  
  protected void toStringBase(StringBuffer sbuf) {}
}
