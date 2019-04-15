package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;










public class Pair
  extends LList
  implements Externalizable
{
  protected Object car;
  protected Object cdr;
  public static final Pair incompleteListMarker = new ImmutablePair("<incomplete>", LList.Empty);
  

  public Pair(Object carval, Object cdrval)
  {
    car = carval;
    cdr = cdrval;
  }
  

  public Pair() {}
  

  public Object getCar() { return car; }
  public Object getCdr() { return cdr; }
  public void setCar(Object car) { this.car = car; }
  public void setCdr(Object cdr) { this.cdr = cdr; }
  

  public void setCarBackdoor(Object car) { this.car = car; }
  public void setCdrBackdoor(Object cdr) { this.cdr = cdr; }
  
  public int size()
  {
    int n = listLength(this, true);
    if (n >= 0)
      return n;
    if (n == -1)
      return Integer.MAX_VALUE;
    throw new RuntimeException("not a true list");
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  




  public int length()
  {
    int n = 0;
    Object slow = this;
    Object fast = this;
    for (;;)
    {
      if (fast == Empty)
        return n;
      if (!(fast instanceof Pair))
      {
        if ((fast instanceof Sequence))
        {
          int j = ((Sequence)fast).size();
          return j >= 0 ? n + j : j;
        }
        return -2;
      }
      Pair fast_pair = (Pair)fast;
      Object fast_pair_cdr = fast_pair.getCdr();
      if (fast_pair_cdr == Empty)
        return n + 1;
      if ((fast == slow) && (n > 0))
        return -1;
      if (!(fast_pair_cdr instanceof Pair))
      {
        n++;
        fast = fast_pair_cdr;
      }
      else {
        if (!(slow instanceof Pair))
          return -2;
        slow = ((Pair)slow).getCdr();
        fast = ((Pair)fast_pair_cdr).getCdr();
        n += 2;
      }
    }
  }
  
  public boolean hasNext(int ipos) {
    if (ipos <= 0)
      return ipos == 0;
    return PositionManager.getPositionObject(ipos).hasNext();
  }
  
  public int nextPos(int ipos)
  {
    if (ipos <= 0)
    {
      if (ipos < 0)
        return 0;
      return PositionManager.manager.register(new LListPosition(this, 1, true));
    }
    
    LListPosition it = (LListPosition)PositionManager.getPositionObject(ipos);
    return it.gotoNext() ? ipos : 0;
  }
  
  public Object getPosNext(int ipos)
  {
    if (ipos <= 0)
      return ipos == 0 ? getCar() : eofValue;
    return PositionManager.getPositionObject(ipos).getNext();
  }
  
  public Object getPosPrevious(int ipos)
  {
    if (ipos <= 0)
      return ipos == 0 ? eofValue : lastPair().getCar();
    return PositionManager.getPositionObject(ipos).getPrevious();
  }
  
  public Pair lastPair()
  {
    Pair pair = this;
    for (;;)
    {
      Object next = pair.getCdr();
      if ((next instanceof Pair)) {
        pair = (Pair)next;
      } else {
        return pair;
      }
    }
  }
  








  public static boolean equals(Pair pair1, Pair pair2)
  {
    if (pair1 == pair2)
      return true;
    if ((pair1 == null) || (pair2 == null)) {
      return false;
    }
    for (;;) {
      Object x1 = pair1.getCar();
      Object x2 = pair2.getCar();
      if ((x1 != x2) && ((x1 == null) || (!x1.equals(x2))))
        return false;
      x1 = pair1.getCdr();
      x2 = pair2.getCdr();
      if (x1 == x2)
        return true;
      if ((x1 == null) || (x2 == null))
        return false;
      if ((!(x1 instanceof Pair)) || (!(x2 instanceof Pair)))
        return x1.equals(x2);
      pair1 = (Pair)x1;
      pair2 = (Pair)x2;
    }
  }
  


  public static int compareTo(Pair pair1, Pair pair2)
  {
    if (pair1 == pair2)
      return 0;
    if (pair1 == null)
      return -1;
    if (pair2 == null) {
      return 1;
    }
    for (;;) {
      Object x1 = pair1.getCar();
      Object x2 = pair2.getCar();
      int d = ((Comparable)x1).compareTo((Comparable)x2);
      if (d != 0)
        return d;
      x1 = cdr;
      x2 = cdr;
      if (x1 == x2)
        return 0;
      if (x1 == null)
        return -1;
      if (x2 == null)
        return 1;
      if ((!(x1 instanceof Pair)) || (!(x2 instanceof Pair)))
        return ((Comparable)x1).compareTo((Comparable)x2);
      pair1 = (Pair)x1;
      pair2 = (Pair)x2;
    }
  }
  
  public int compareTo(Object obj)
  {
    if (obj == Empty) {
      return 1;
    }
    return compareTo(this, (Pair)obj);
  }
  

  public Object get(int index)
  {
    Pair pair = this;
    int i = index;
    while (i > 0)
    {
      i--;
      Object pair_cdr = pair.getCdr();
      if ((pair_cdr instanceof Pair)) {
        pair = (Pair)pair_cdr;
      } else { if (!(pair_cdr instanceof Sequence)) break;
        return ((Sequence)pair_cdr).get(i);
      }
    }
    
    if (i == 0) {
      return pair.getCar();
    }
    throw new IndexOutOfBoundsException();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj != null) && ((obj instanceof Pair))) {
      return equals(this, (Pair)obj);
    }
    return false;
  }
  
  public static Pair make(Object car, Object cdr)
  {
    return new Pair(car, cdr);
  }
  
  public Object[] toArray()
  {
    int len = size();
    Object[] arr = new Object[len];
    int i = 0;
    Sequence rest = this;
    for (; (i < len) && ((rest instanceof Pair)); i++)
    {
      Pair pair = (Pair)rest;
      arr[i] = pair.getCar();
      rest = (Sequence)pair.getCdr();
    }
    int prefix = i;
    for (; i < len; i++)
    {
      arr[i] = rest.get(i - prefix);
    }
    return arr;
  }
  
  public Object[] toArray(Object[] arr)
  {
    int alen = arr.length;
    int len = length();
    if (len > alen)
    {

      arr = new Object[len];
      alen = len;
    }
    int i = 0;
    Sequence rest = this;
    for (; (i < len) && ((rest instanceof Pair)); i++)
    {
      Pair pair = (Pair)rest;
      arr[i] = pair.getCar();
      rest = (Sequence)pair.getCdr();
    }
    int prefix = i;
    for (; i < len; i++)
    {
      arr[i] = rest.get(i - prefix);
    }
    if (len < alen)
      arr[len] = null;
    return arr;
  }
  


  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeObject(car);
    out.writeObject(cdr);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    car = in.readObject();
    cdr = in.readObject();
  }
  
  public Object readResolve()
    throws ObjectStreamException
  {
    return this;
  }
}
