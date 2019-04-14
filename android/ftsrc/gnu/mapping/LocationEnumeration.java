package gnu.mapping;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;






public class LocationEnumeration
  implements Iterator<Location>, Enumeration<Location>
{
  SimpleEnvironment env;
  NamedLocation prevLoc;
  NamedLocation nextLoc;
  int index;
  LocationEnumeration inherited;
  NamedLocation[] bindings;
  
  public LocationEnumeration(NamedLocation[] bindings, int count)
  {
    this.bindings = bindings;
    index = count;
  }
  
  public LocationEnumeration(SimpleEnvironment env)
  {
    this(table, 1 << log2Size);
  }
  
  public boolean hasMoreElements()
  {
    return env.hasMoreElements(this);
  }
  
  public Location nextElement()
  {
    return nextLocation();
  }
  
  public Location nextLocation()
  {
    if ((nextLoc == null) && (!hasMoreElements()))
      throw new NoSuchElementException();
    NamedLocation oldPrev = prevLoc;
    if (prevLoc == null)
    {
      NamedLocation first = bindings[index];
      if (nextLoc != first)
        prevLoc = first;
    }
    while ((prevLoc != null) && (prevLoc.next != nextLoc))
      prevLoc = prevLoc.next;
    Location r = nextLoc;
    nextLoc = nextLoc.next;
    return r;
  }
  
  public boolean hasNext()
  {
    return hasMoreElements();
  }
  
  public Location next()
  {
    return nextElement();
  }
  
  public void remove()
  {
    NamedLocation curLoc = prevLoc != null ? prevLoc.next : bindings[index];
    if ((curLoc == null) || (next != nextLoc))
      throw new IllegalStateException();
    next = null;
    if (prevLoc != null) {
      prevLoc.next = nextLoc;
    } else
      bindings[index] = nextLoc;
    env.num_bindings -= 1;
  }
}
