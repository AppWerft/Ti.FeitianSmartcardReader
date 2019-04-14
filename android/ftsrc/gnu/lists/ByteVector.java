package gnu.lists;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public abstract class ByteVector<E>
  extends PrimIntegerVector<E>
{
  byte[] data;
  protected static byte[] empty = new byte[0];
  
  public ByteVector() {}
  
  public int getBufferLength() { return data.length; }
  
  public void copyBuffer(int length)
  {
    int oldLength = data.length;
    if (length == -1)
      length = oldLength;
    if (oldLength != length) {
      byte[] tmp = new byte[length];
      System.arraycopy(data, 0, tmp, 0, oldLength < length ? oldLength : length);
      
      data = tmp;
    }
  }
  
  public byte[] getBuffer() { return data; }
  
  protected void setBuffer(Object buffer) { data = ((byte[])buffer); }
  
  public final byte getByte(int index) {
    return data[effectiveIndex(index)];
  }
  
  public final byte getByteRaw(int index) {
    return data[index];
  }
  
  public final void setByte(int index, byte value) {
    checkCanWrite();
    data[effectiveIndex(index)] = value;
  }
  
  public final void setByteRaw(int index, byte value) {
    data[index] = value;
  }
  
  public void add(byte v) {
    int sz = size();
    addSpace(sz, 1);
    setByte(sz, v);
  }
  
  protected void clearBuffer(int start, int count) {
    byte[] d = data;
    for (;;) { count--; if (count < 0) break;
      d[(start++)] = 0;
    }
  }
  
  public int readFrom(int start, int count, InputStream in) throws IOException {
    int pos = start;
    while (count > 0) {
      long result = getSegment(pos);
      int where = (int)result;
      int size = (int)(result >> 32);
      if (size > count)
        size = count;
      int n = in.read(data, where, size);
      if (n < 0) {
        if (pos != start) break;
        return -1;
      }
      
      pos += n;
      count -= n;
    }
    return pos - start;
  }
  
  public void writeTo(OutputStream out) throws IOException
  {
    writeTo(0, size(), out);
  }
  
  public void writeTo(int start, int count, OutputStream out) throws IOException
  {
    while (count > 0) {
      long result = getSegment(start);
      int where = (int)result;
      int size = (int)(result >> 32);
      if (size > count)
        size = count;
      out.write(data, where, size);
      start += size;
      count -= size;
    }
  }
  
  public void copyFrom(int index, ByteVector src, int start, int end) {
    int count = end - start;
    int sz = size();
    int src_sz = src.size();
    if ((count < 0) || (index + count > sz) || (end > src_sz))
      throw new ArrayIndexOutOfBoundsException();
    int sseg;
    int dseg; if (((sseg = src.getSegmentReadOnly(start, count)) >= 0) && ((dseg = getSegment(index, count)) >= 0))
    {
      System.arraycopy(data, sseg, data, dseg, count);
    } else {
      for (int i = 0; i < count; i++)
        setByte(index + i, src.getByte(start + i));
    }
  }
  
  public InputStream getInputStream() {
    int sz = size();
    int seg = getSegmentReadOnly(0, sz);
    if (seg >= 0) {
      return new ByteArrayInputStream(data, seg, sz);
    }
    return new ByteVectorInputStream(this);
  }
  
  static class ByteVectorInputStream extends InputStream {
    ByteVector bvec;
    int pos;
    int mark;
    int size;
    
    public ByteVectorInputStream(ByteVector bvec) { this.bvec = bvec;
      size = bvec.size();
    }
    
    public int read() { return pos >= size ? -1 : 0xFF & bvec.getByte(pos++); }
    

    public boolean markSupported() { return true; }
    public void mark(int readLimit) { mark = pos; }
    public void reset() { pos = mark; }
    public void close() {}
    public int available() { return size - pos; }
    
    public long skip(long n) { if (n < 0L) n = 0L;
      if (n < size - pos) { pos = size;return size - pos; }
      pos = ((int)(pos + n));return n;
    }
  }
  
  public String toUtf8(int start, int length)
  {
    if (start + length > size()) throw new IndexOutOfBoundsException();
    int seg = getSegmentReadOnly(start, length);
    byte[] buf;
    if (seg >= 0) {
      byte[] buf = data;
      start = seg;
    } else {
      buf = new byte[length];
      for (int i = 0; i < length; i++)
        buf[i] = getByte(start + i);
    }
    return Strings.toUtf8(buf, start, length);
  }
}
