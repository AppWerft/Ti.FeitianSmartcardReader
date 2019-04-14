package gnu.lists;





public class StableManager
{
  SimpleVector base;
  



  protected int[] positions;
  



  protected int free;
  



  protected static final int FREE_POSITION = -2;
  



  static final int START_POSITION = 0;
  



  static final int END_POSITION = 1;
  




  protected void chainFreelist()
  {
    free = -1;
    int i = positions.length; for (;;) { i--; if (i <= 1)
        break;
      int pos = positions[i];
      if (pos == -2)
      {
        positions[i] = free;
        free = i;
      }
    }
  }
  

  protected void unchainFreelist()
  {
    for (int i = free; i >= 0;)
    {
      int next = positions[i];
      positions[i] = -2;
      i = next;
    }
    free = -2;
  }
  








  public int startPos() { return 0; }
  public int endPos() { return 1; }
  
  public StableManager(SimpleVector base)
  {
    this.base = base;
    base.gapReserveGeneric(base.size(), 0);
    positions = new int[16];
    positions[0] = 0;
    positions[1] = (base.getBufferLength() << 1 | 0x1);
    free = -1;
    int i = positions.length; for (;;) { i--; if (i <= 1)
        break;
      positions[i] = free;
      free = i;
    }
  }
  
  protected int allocPositionIndex()
  {
    if (free == -2)
      chainFreelist();
    if (free < 0)
    {
      int oldLength = positions.length;
      int[] tmp = new int[2 * oldLength];
      System.arraycopy(positions, 0, tmp, 0, oldLength);
      int i = 2 * oldLength; for (;;) { i--; if (i < oldLength)
          break;
        tmp[i] = free;
        free = i;
      }
      positions = tmp;
    }
    int pos = free;
    free = positions[free];
    return pos;
  }
  
  public int createPos(int index, boolean isAfter)
  {
    if ((index == 0) && (!isAfter))
      return 0;
    if ((isAfter) && (index == base.size()))
      return 1;
    int gapStart = base.getGapStart();
    int gapEnd = base.getGapEnd();
    if ((index > gapStart) || ((index == gapStart) && (isAfter)))
      index += gapEnd - gapStart;
    int ipos = allocPositionIndex();
    positions[ipos] = (index << 1 | (isAfter ? 1 : 0));
    return ipos;
  }
  
  protected boolean isAfterPos(int ipos)
  {
    return (positions[ipos] & 0x1) != 0;
  }
  
  public boolean hasNext(int ipos)
  {
    int ppos = positions[ipos];
    int index = ppos >>> 1;
    int gapStart = base.getGapStart();
    if (index >= gapStart)
      index += base.getGapEnd() - gapStart;
    return index < base.getBufferLength();
  }
  
  public int nextPos(int ipos)
  {
    int ppos = positions[ipos];
    int index = ppos >>> 1;
    int gapStart = base.getGapStart();
    int gapEnd = base.getGapEnd();
    if (index >= gapStart)
      index += gapEnd - gapStart;
    if (index >= base.getBufferLength())
    {
      releasePos(ipos);
      return 0;
    }
    if (ipos == 0)
      ipos = createPos(0, true);
    positions[ipos] = (ppos | 0x1);
    return ipos;
  }
  
  public int nextIndex(int ipos)
  {
    int index = positions[ipos] >>> 1;
    int gapStart = base.getGapStart();
    int gapEnd = base.getGapEnd();
    if (index > gapStart)
      index -= gapEnd - gapStart;
    return index;
  }
  
  public void releasePos(int ipos)
  {
    if (ipos >= 2)
    {
      if (free == -2)
        chainFreelist();
      positions[ipos] = free;
      free = ipos;
    }
  }
  
  public int copyPos(int ipos)
  {
    if (ipos > 1)
    {
      int i = allocPositionIndex();
      positions[i] = positions[ipos];
      ipos = i;
    }
    return ipos;
  }
  

  protected void gapReserve(SimpleVector base, int where, int needed)
  {
    int oldGapEnd = base.getGapEnd();
    int oldGapStart = base.getGapStart();
    int oldLength = base.getBufferLength();
    base.gapReserveGeneric(where, needed);
    if (needed > oldGapEnd - oldGapStart) {
      int newLength = base.getBufferLength();
      if (where == oldGapStart) {
        adjustPositions(oldGapEnd << 1, newLength << 1 | 0x1, newLength - oldLength << 1);

      }
      else
      {
        adjustPositions(oldGapEnd << 1, oldLength << 1 | 0x1, oldGapStart - oldGapEnd << 1);
        
        int gapStart = base.getGapStart();
        int gapEnd = base.getGapEnd();
        adjustPositions(gapStart << 1, newLength << 1 | 0x1, gapEnd - gapStart << 1);
      }
    } else if (where != oldGapStart) {
      int delta = where - oldGapStart;
      int low;
      int high; int adjust; if (delta > 0) {
        int low = oldGapEnd;
        int high = low + delta;
        int adjust = oldGapStart - low << 1;
        

        low <<= 1;
        high <<= 1;
      }
      else
      {
        low = (where << 1) + 1;
        high = (oldGapStart << 1) + 1;
        adjust = oldGapEnd - oldGapStart << 1;
      }
      adjustPositions(low, high, adjust);
    }
  }
  











  protected void adjustPositions(int low, int high, int delta)
  {
    if (free >= -1) {
      unchainFreelist();
    }
    


    low ^= 0x80000000;
    high ^= 0x80000000;
    
    int i = positions.length; for (;;) { i--; if (i <= 0)
        break;
      int pos = positions[i];
      if (pos != -2)
      {
        int index = pos ^ 0x80000000;
        if ((index >= low) && (index <= high)) {
          positions[i] = (pos + delta);
        }
      }
    }
  }
  



















  protected void removePosRange(int ipos0, int ipos1)
  {
    throw new Error();
  }
  



































  public void consumePosRange(int iposStart, int iposEnd, Consumer out)
  {
    throw new Error();
  }
}
