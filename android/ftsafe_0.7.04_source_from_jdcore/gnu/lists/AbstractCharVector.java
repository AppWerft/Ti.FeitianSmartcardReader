package gnu.lists;

import gnu.kawa.io.CharArrayInPort;

public abstract class AbstractCharVector<E>
  extends SimpleVector<E> implements Comparable
{
  protected char[] data;
  
  public AbstractCharVector() {}
  
  protected static char[] empty = new char[0];
  
  public int length() { return size(); }
  
  public int getBufferLength()
  {
    return data.length;
  }
  
  public void copyBuffer(int length) {
    int oldLength = data.length;
    if (length == -1)
      length = oldLength;
    if (oldLength != length) {
      char[] tmp = new char[length];
      System.arraycopy(data, 0, tmp, 0, oldLength < length ? oldLength : length);
      
      data = tmp;
    }
  }
  
  public void ensureBufferLength(int sz) {
    if (sz > data.length) {
      char[] d = new char[sz < 60 ? 120 : 2 * sz];
      System.arraycopy(data, 0, d, 0, data.length);
      data = d;
    }
  }
  

  public char[] getBuffer() { return data; }
  
  protected void setBuffer(Object buffer) { data = ((char[])buffer); }
  
  public final char charAt(int index) {
    return data[effectiveIndex(index)];
  }
  
  public final char getCharRaw(int index) {
    return data[index];
  }
  

  public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
  {
    if ((srcBegin < 0) || (srcBegin > srcEnd))
      throw new StringIndexOutOfBoundsException(srcBegin);
    int size = size();
    if (srcEnd > size)
      throw new StringIndexOutOfBoundsException(srcEnd);
    if (dstBegin + srcEnd - srcBegin > dst.length)
      throw new StringIndexOutOfBoundsException(dstBegin);
    int len = srcEnd - srcBegin;
    if (len <= 0)
      return;
    if (isVerySimple()) {
      System.arraycopy(data, srcBegin, dst, dstBegin, len);
    } else {
      for (int i = 0; i < len; i++)
        dst[(dstBegin + i)] = charAt(srcBegin + i);
    }
  }
  
  protected void clearBuffer(int start, int count) {
    char[] d = data;
    for (;;) { count--; if (count < 0) break;
      d[(start++)] = '\000';
    }
  }
  
  public int hashCode()
  {
    char[] val = data;
    int len = size();
    int hash = 0;
    if (!isVerySimple()) {
      for (int i = 0; i < len; i++)
        hash = 31 * hash + val[effectiveIndex(i)];
    } else {
      for (int i = 0; i < len; i++)
        hash = 31 * hash + val[i];
    }
    return hash;
  }
  

  public abstract boolean equals(Object paramObject);
  
  public static boolean equals(AbstractCharVector<?> c1, AbstractCharVector<?> c2)
  {
    int len1 = c1.size();
    int len2 = c2.size();
    return (len1 == len2) && (compareTo(data, data, len1) == 0);
  }
  
  public int compareTo(Object obj) {
    AbstractCharVector<?> cv1 = this;
    AbstractCharVector<?> cv2 = (AbstractCharVector)obj;
    int n1 = cv1.size();
    int n2 = cv2.size();
    int n = n1 > n2 ? n2 : n1;
    int d = compareTo(cv1, cv2, n);
    return d != 0 ? d : n1 - n2;
  }
  



  public static int compareTo(AbstractCharVector<?> cv1, AbstractCharVector<?> cv2, int length)
  {
    if ((!cv1.isVerySimple()) || (!cv2.isVerySimple())) {
      for (int i = 0; i < length; i++) {
        char c1 = cv1.charAt(i);
        char c2 = cv2.charAt(i);
        int d = c1 - c2;
        if (d != 0)
          return d;
      }
      return 0;
    }
    return compareTo(data, data, length);
  }
  
  public static int compareTo(char[] arr1, char[] arr2, int length)
  {
    for (int i = 0; i < length; i++) {
      char c1 = arr1[i];
      char c2 = arr2[i];
      int d = c1 - c2;
      if (d != 0)
        return d;
    }
    return 0;
  }
  
  public CharArrayInPort openReader() {
    return new CharArrayInPort(this, data, 0, size());
  }
  
  public CharArrayInPort openReader(int start, int end) {
    return new CharArrayInPort(this, data, start, end);
  }
}
