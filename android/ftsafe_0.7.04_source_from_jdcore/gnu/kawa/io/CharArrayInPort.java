package gnu.kawa.io;

import gnu.lists.AbstractCharVector;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import java.io.IOException;


public class CharArrayInPort
  extends InPort
{
  static final Path stringPath = Path.valueOf("<string>");
  private AbstractCharVector string;
  int limitIndex;
  int start;
  int end;
  
  public static CharArrayInPort make(CharSequence seq)
  {
    if ((seq instanceof FString)) {
      return ((FString)seq).openReader(0, seq.length());
    }
    return make(seq, "");
  }
  
  public static CharArrayInPort make(CharSequence seq, CharSequence suffix) {
    int len1 = seq.length();
    int len2 = suffix.length();
    char[] buf = new char[len1 + len2];
    if ((seq instanceof String)) {
      ((String)seq).getChars(0, len1, buf, 0);
    } else if (!(seq instanceof CharSeq)) {
      int i = len1; for (;;) { i--; if (i < 0) break;
        buf[i] = seq.charAt(i);
      }
    } else { ((CharSeq)seq).getChars(0, len1, buf, 0); }
    int i = len2; for (;;) { i--; if (i < 0) break;
      buf[(i + len1)] = suffix.charAt(i); }
    return new CharArrayInPort(buf, len1 + len2);
  }
  
  public CharArrayInPort(char[] buffer, int len)
  {
    super(NullReader.nullReader, stringPath);
    try
    {
      setBuffer(buffer);
    }
    catch (IOException ex)
    {
      throw new Error(ex.toString());
    }
    limit = len;
  }
  
  public CharArrayInPort(char[] buffer)
  {
    this(buffer, buffer.length);
  }
  
  public CharArrayInPort(String string)
  {
    this(string.toCharArray());
  }
  
  public CharArrayInPort(AbstractCharVector string, char[] buffer, int start, int end)
  {
    this(buffer, 0);
    this.string = string;
    this.start = start;
    this.end = end;
    limitIndex = start;
  }
  
  protected int fill(int len) throws IOException
  {
    if (string != null) {
      long result = string.getSegment(limitIndex);
      int where = (int)result;
      int size = (int)(result >> 32);
      if (size <= 0)
        return -1;
      limitIndex += size;
      if (limitIndex > end) {
        size -= limitIndex - end;
        limitIndex = end;
      }
      pos = where;
      limit = pos;
      return size;
    }
    return -1;
  }
  
  public void mark(int readAheadLimit)
  {
    synchronized (lock)
    {





      super.mark(readAheadLimit);
    }
  }
  











  public void reset()
    throws IOException
  {
    super.reset();
  }
}
