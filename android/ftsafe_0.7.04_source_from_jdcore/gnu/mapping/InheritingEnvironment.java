package gnu.mapping;


public class InheritingEnvironment
  extends SimpleEnvironment
{
  int numInherited;
  
  Environment[] inherited;
  int baseTimestamp;
  
  public InheritingEnvironment(String name, Environment parent)
  {
    super(name);
    addParent(parent);
    if ((parent instanceof SimpleEnvironment))
    {
      int timestamp = ++currentTimestamp;
      baseTimestamp = timestamp;
      currentTimestamp = timestamp;
    }
  }
  
  public final int getNumParents() { return numInherited; }
  public final Environment getParent(int index) { return inherited[index]; }
  
  public void addParent(Environment env)
  {
    if (numInherited == 0) {
      inherited = new Environment[4];
    } else if (numInherited <= inherited.length)
    {
      Environment[] newInherited = new Environment[2 * numInherited];
      
      System.arraycopy(inherited, 0, newInherited, 0, numInherited);
      inherited = newInherited;
    }
    inherited[numInherited] = env;
    numInherited += 1;
  }
  
  public NamedLocation lookupInherited(Symbol name, Object property, int hash)
  {
    for (int i = 0; i < numInherited; i++)
    {
      Symbol sym = name;
      Object prop = property;
      NamedLocation loc = inherited[i].lookup(sym, prop, hash);
      if ((loc != null) && (loc.isBound()))
      {
        if ((!(loc instanceof SharedLocation)) || (timestamp < baseTimestamp))
        {
          return loc; }
      }
    }
    return null;
  }
  
  public NamedLocation lookup(Symbol name, Object property, int hash)
  {
    NamedLocation loc = super.lookup(name, property, hash);
    if ((loc != null) && (loc.isBound()))
      return loc;
    return lookupInherited(name, property, hash);
  }
  

  public synchronized NamedLocation getLocation(Symbol name, Object property, int hash, boolean create)
  {
    NamedLocation loc = lookupDirect(name, property, hash);
    if ((loc != null) && ((create) || (loc.isBound())))
      return loc;
    if (((flags & 0x20) != 0) && (create)) {
      loc = inherited[0].getLocation(name, property, hash, true);
    } else {
      loc = lookupInherited(name, property, hash);
    }
    if (loc != null)
    {
      if (create)
      {
        NamedLocation xloc = addUnboundLocation(name, property, hash);
        if (((flags & 0x1) == 0) && (loc.isBound()))
          redefineError(name, property, xloc);
        base = loc;
        if (value == IndirectableLocation.INDIRECT_FLUIDS) {
          value = value;
        } else if ((flags & 0x10) != 0) {
          value = IndirectableLocation.DIRECT_ON_SET;
        } else
          value = null;
        if ((xloc instanceof SharedLocation))
          timestamp = baseTimestamp;
        return xloc;
      }
      
      return loc;
    }
    return create ? addUnboundLocation(name, property, hash) : null;
  }
  
  public LocationEnumeration enumerateAllLocations()
  {
    LocationEnumeration it = new LocationEnumeration(table, 1 << log2Size);
    env = this;
    if ((inherited != null) && (inherited.length > 0))
    {
      inherited = inherited[0].enumerateAllLocations();
      index = 0;
    }
    return it;
  }
  
  protected boolean hasMoreElements(LocationEnumeration it)
  {
    if (inherited != null)
    {
      for (;;)
      {
        NamedLocation loc = nextLoc;
        for (;;)
        {
          inherited.nextLoc = loc;
          if (!inherited.hasMoreElements())
          {
            prevLoc = null;
            nextLoc = inherited.nextLoc;
            break;
          }
          loc = inherited.nextLoc;
          if (lookup(name, property) == loc)
          {
            nextLoc = loc;
            return true;
          }
          loc = next;
        }
        if (++index == numInherited)
          break;
        inherited = inherited[index].enumerateAllLocations();
      }
      inherited = null;
      bindings = table;
      index = (1 << log2Size);
    }
    return super.hasMoreElements(it);
  }
  
  protected void toStringBase(StringBuffer sbuf)
  {
    sbuf.append(" baseTs:");
    sbuf.append(baseTimestamp);
    for (int i = 0; i < numInherited; i++)
    {
      sbuf.append(" base:");
      sbuf.append(inherited[i].toStringVerbose());
    }
  }
}
