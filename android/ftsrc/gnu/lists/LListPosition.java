package gnu.lists;

import java.util.NoSuchElementException;






















class LListPosition
  extends ExtPosition<Object, LList>
{
  Object xpos;
  
  public LListPosition(LListPosition old)
  {
    sequence = sequence;
    ipos = ipos;
    xpos = xpos;
  }
  
  public LListPosition copy()
  {
    return new LListPosition(this);
  }
  
  public LListPosition(LList seq, int index, boolean isAfter)
  {
    set(seq, index, isAfter);
  }
  
  public void set(LList seq, int index, boolean isAfter)
  {
    sequence = seq;
    ipos = (index << 1 | (isAfter ? 1 : 0));
    int skip = index;
    if (isAfter)
    {
      skip -= 2;
    }
    else
    {
      skip--;
    }
    if (skip >= 0)
    {
      Object p = seq;
      for (;;) { skip--; if (skip < 0)
          break;
        p = ((Pair)p).getCdr();
      }
      xpos = p;
    }
    else {
      xpos = null;
    }
  }
  
  public boolean hasNext()
  {
    if (xpos == null)
    {
      if (ipos >> 1 == 0)
        return sequence != LList.Empty;
      return ((Pair)sequence).getCdr() != LList.Empty;
    }
    
    Object next = ((Pair)xpos).getCdr();
    if ((ipos & 0x1) > 0)
      next = ((Pair)next).getCdr();
    return next != LList.Empty;
  }
  
  public boolean hasPrevious()
  {
    return ipos >>> 1 != 0;
  }
  

  public Pair getNextPair()
  {
    int isAfter = ipos & 0x1;
    Object next;
    Object next; if (isAfter > 0)
    {
      if (xpos == null)
      {
        Object next = sequence;
        if (ipos >> 1 != 0) {
          next = ((Pair)next).getCdr();
        }
      } else {
        next = ((Pair)((Pair)xpos).getCdr()).getCdr();
      }
    } else {
      Object next;
      if (xpos == null) {
        next = sequence;
      } else
        next = ((Pair)xpos).getCdr();
    }
    if (next == LList.Empty)
      return null;
    return (Pair)next;
  }
  
  public Object getNext()
  {
    Pair pair = getNextPair();
    return pair == null ? LList.eofValue : pair.getCar();
  }
  
  public void setNext(Object value)
  {
    Pair pair = getNextPair();
    car = value;
  }
  

  public Pair getPreviousPair()
  {
    int isAfter = ipos & 0x1;
    Object p = xpos;
    if (isAfter > 0) {
      p = p == null ? sequence : ((Pair)p).getCdr();
    } else if (p == null)
      return null;
    if (p == LList.Empty)
      return null;
    return (Pair)p;
  }
  
  public Object getPrevious()
  {
    Pair pair = getPreviousPair();
    return pair == null ? LList.eofValue : pair.getCar();
  }
  
  public void setPrevious(Object value)
  {
    Pair pair = getPreviousPair();
    car = value;
  }
  
  public int nextIndex()
  {
    return ipos >> 1;
  }
  
  public Object next()
  {
    Pair pair = getNextPair();
    if ((pair == null) || (!gotoNext()))
      throw new NoSuchElementException();
    return pair.getCar();
  }
  
  public boolean gotoNext() {
    boolean isAfter = (ipos & 0x1) != 0;
    int old_i = ipos;
    Object xp = xpos;
    if (xp != null)
    {
      if (isAfter)
        xp = ((Pair)xp).getCdr();
      if (((Pair)xp).getCdr() == LList.Empty)
        return false;
      xpos = xp;
      ipos = ((ipos | 0x1) + 2);
    }
    else if (ipos >> 1 == 0)
    {
      if (sequence == LList.Empty)
        return false;
      ipos = 3;
    }
    else
    {
      xp = sequence;
      if (((Pair)xp).getCdr() == LList.Empty)
        return false;
      ipos = 5;
      xpos = xp;
    }
    return true;
  }
  
  public boolean gotoPrevious()
  {
    if (ipos >>> 1 == 0)
      return false;
    if ((ipos & 0x1) != 0)
    {

      ipos -= 3;
      return true;
    }
    int index = nextIndex();
    set((LList)sequence, index - 1, false);
    return true;
  }
  
  public String toString()
  {
    StringBuffer sbuf = new StringBuffer();
    sbuf.append("LListPos[");
    
    sbuf.append("index:");
    sbuf.append(ipos);
    if (isAfter())
      sbuf.append(" after");
    if (position >= 0)
    {
      sbuf.append(" position:");
      sbuf.append(position);
    }
    sbuf.append(']');
    return sbuf.toString();
  }
}
