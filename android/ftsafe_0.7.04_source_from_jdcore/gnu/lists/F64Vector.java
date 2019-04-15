package gnu.lists;




public class F64Vector
  extends SimpleVector<Double>
  implements Comparable
{
  double[] data;
  


  protected static double[] empty = new double[0];
  
  public F64Vector() {
    data = empty;
  }
  
  public F64Vector(int size, double value) {
    double[] array = new double[size];
    data = array;
    if (value != 0.0D)
      for (;;) { size--; if (size < 0) break;
        array[size] = value;
      }
  }
  
  public F64Vector(int size) {
    this(new double[size]);
  }
  
  public F64Vector(double[] data)
  {
    this.data = data;
  }
  

  public F64Vector(double[] values, int offset, int length)
  {
    this(length);
    System.arraycopy(values, offset, data, 0, length);
  }
  
  public int getBufferLength()
  {
    return data.length;
  }
  
  public void copyBuffer(int length) {
    int oldLength = data.length;
    if (length == -1)
      length = oldLength;
    if (oldLength != length) {
      double[] tmp = new double[length];
      System.arraycopy(data, 0, tmp, 0, oldLength < length ? oldLength : length);
      
      data = tmp;
    }
  }
  
  public double[] getBuffer() { return data; }
  
  protected void setBuffer(Object buffer) { data = ((double[])buffer); }
  
  public final double getDouble(int index) {
    return data[effectiveIndex(index)];
  }
  
  public final double getDoubleRaw(int index) {
    return data[index];
  }
  
  public final Double get(int index) {
    return Double.valueOf(data[effectiveIndex(index)]);
  }
  
  public final Double getRaw(int index) {
    return Double.valueOf(data[index]);
  }
  
  public final void setDouble(int index, double value) {
    checkCanWrite();
    data[effectiveIndex(index)] = value;
  }
  
  public final void setDoubleRaw(int index, double value) {
    data[index] = value;
  }
  
  public final void setRaw(int index, Double value)
  {
    data[index] = value.doubleValue();
  }
  
  public void add(double v) {
    int sz = size();
    addSpace(sz, 1);
    setDouble(sz, v);
  }
  
  protected void clearBuffer(int start, int count) {
    double[] d = data;
    for (;;) { count--; if (count < 0) break;
      d[(start++)] = 0.0D;
    }
  }
  
  protected F64Vector newInstance(int newLength) {
    return new F64Vector(newLength < 0 ? data : new double[newLength]);
  }
  
  public int getElementKind() { return 26; }
  
  public String getTag() { return "f64"; }
  
  public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
    if (out.ignoring())
      return;
    int i = nextIndex(iposStart);
    int end = nextIndex(iposEnd);
    for (; i < end; i++)
      out.writeDouble(getDouble(i));
  }
  
  public int compareTo(Object obj) {
    F64Vector vec2 = (F64Vector)obj;
    double[] arr1 = data;
    double[] arr2 = data;
    int n1 = size();
    int n2 = vec2.size();
    int n = n1 > n2 ? n2 : n1;
    for (int i = 0; i < n; i++) {
      double v1 = arr1[effectiveIndex(i)];
      double v2 = arr2[effectiveIndex(i)];
      if (v1 != v2)
        return v1 > v2 ? 1 : -1;
    }
    return n1 - n2;
  }
}
