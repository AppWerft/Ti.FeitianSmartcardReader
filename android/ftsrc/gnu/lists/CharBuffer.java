package gnu.lists;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;





public class CharBuffer
  extends FString
{
  StableManager manager;
  
  public CharBuffer(FString str)
  {
    super(str);
    manager = new StableManager(this);
  }
  
  public CharBuffer(int initialSize) {
    super(initialSize);
    setGapBounds(0, initialSize);
    manager = new StableManager(this);
  }
  
  protected CharBuffer() {
    manager = new StableManager(this);
  }
  
  public int length() { return size(); }
  
  public char[] getArray() { return (char[])getBuffer(); }
  
  public void consume(int start, int count, Consumer dest)
  {
    throw new Error();
  }
  

















  public int startPos() { return manager.startPos(); }
  public int endPos() { return manager.endPos(); }
  public boolean isAfterPos(int ipos) { return manager.isAfterPos(ipos); }
  public boolean hasNext(int ipos) { return manager.hasNext(ipos); }
  public int nextPos(int ipos) { return manager.nextPos(ipos); }
  public int copyPos(int ipos) { return manager.copyPos(ipos); }
  
  public int nextIndex(int ipos) { return manager.nextIndex(ipos); }
  
  public void releasePos(int ipos) { manager.releasePos(ipos); }
  
  public int createPos(int index, boolean isAfter) {
    return manager.createPos(index, isAfter);
  }
  
  public void insert(int where, int ch, boolean beforeMarkers)
  {
    super.insert(where, ch, beforeMarkers);
    if (beforeMarkers)
    {
      int len = ch >= 65536 ? 2 : 1;
      int oldPos = getGapStart() - len << 1;
      manager.adjustPositions(oldPos, oldPos + 1, len << 1);
    }
  }
  
  public void insert(int where, String str, boolean beforeMarkers)
  {
    super.insert(where, str, beforeMarkers);
    if (beforeMarkers)
    {
      int len = str.length();
      int oldPos = getGapStart() - len << 1;
      manager.adjustPositions(oldPos, oldPos + 1, len << 1);
    }
  }
  
  protected void gapReserve(int where, int needed)
  {
    manager.gapReserve(this, where, needed);
  }
  
  public String toString()
  {
    int len = size();
    int start = getSegment(0, len);
    return new String(getArray(), start, len);
  }
  

  public void writeTo(int start, int count, Appendable dest)
    throws IOException
  {
    if ((dest instanceof Writer)) {
      writeTo(start, count, (Writer)dest);
    } else {
      dest.append(this, start, start + count);
    }
  }
  
  public void writeTo(Appendable dest) throws IOException
  {
    writeTo(0, size(), dest);
  }
  

  public void dump()
  {
    System.err.println("Buffer Content dump.  size:" + size() + "  buffer:" + getArray().length);
    int gapStart = getGapStart();
    int gapEnd = getGapEnd();
    int[] positions = manager.positions;
    int free = manager.free;
    System.err.print("before gap: \"");
    System.err.print(new String(getArray(), 0, gapStart));
    System.err.println("\" (gapStart:" + gapStart + " gapEnd:" + gapEnd + ')');
    System.err.print("after gap: \"");
    System.err.print(new String(getArray(), gapEnd, getArray().length - gapEnd));
    System.err.println("\"");
    int poslen = positions == null ? 0 : positions.length;
    System.err.println("Positions (size: " + poslen + " free:" + free + "):");
    boolean[] isFree = null;
    if (free != -2)
    {
      isFree = new boolean[positions.length];
      for (int i = free; i >= 0; i = positions[i])
        isFree[i] = true;
    }
    for (int i = 0; i < poslen; i++)
    {
      int pos = positions[i];
      if (free == -2 ? pos != -2 : isFree[i] == 0) {
        int p = pos >> 1;
        if (p > gapStart)
          p -= gapEnd - gapStart;
        System.err.println("position#" + i + ": [raw:" + pos + "]=" + p + " isAfter:" + (pos & 0x1));
      }
    }
  }
}
