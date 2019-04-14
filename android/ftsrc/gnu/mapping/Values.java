package gnu.mapping;

import gnu.kawa.format.Printable;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.ItemPredicate;
import gnu.lists.TreeList;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public abstract class Values<E> extends AbstractSequence<E> implements gnu.lists.Consumable, java.io.Externalizable
{
  public static final Object[] noArgs = new Object[0];
  
  public static final Values empty = new FromArray(noArgs);
  

  protected Values() {}
  
  public Object[] getValues()
  {
    int sz = size();
    Object[] arr = new Object[sz];
    int it = 0; for (int i = 0; (it = nextPos(it)) != 0;) {
      arr[(i++)] = getPosPrevious(it);
    }
    return arr;
  }
  
  public static Object values(Object... vals) {
    return make(vals);
  }
  
  public static <E, V1 extends E, V2 extends E> Values2<E, V1, V2> values2(V1 val1, V2 val2) {
    return new Values2(val1, val2);
  }
  
  public static Values make() {
    return new FromTreeList();
  }
  




  public static <E> Object make(E[] vals)
  {
    if (vals.length == 1)
      return vals[0];
    if (vals.length == 0) {
      return empty;
    }
    return new FromArray(vals);
  }
  
  public static <E> Values<E> makeFromArray(E... vals) {
    return new FromArray(vals);
  }
  




  public static <E> Object make(List<E> seq)
  {
    int count = seq == null ? 0 : seq.size();
    if (count == 0)
      return empty;
    if (count == 1)
      return seq.get(0);
    return new FromList(seq);
  }
  



  public static Object make(TreeList list, int startPosition, int endPosition)
  {
    int next;
    

    if ((startPosition == endPosition) || ((next = list.nextDataIndex(startPosition)) <= 0))
    {
      return empty; }
    int next; if ((next == endPosition) || (list.nextDataIndex(next) < 0))
      return list.getPosNext(startPosition << 1);
    FromTreeList vals = new FromTreeList();
    list.consumeIRange(startPosition, endPosition, buffer);
    return vals;
  }
  


  public Object canonicalize()
  {
    int sz = size();
    if (sz == 0) return empty;
    if (sz == 1) return get(0);
    return this;
  }
  
  public Object call_with(Procedure proc) throws Throwable
  {
    return proc.applyN(getValues());
  }
  
  public void check_with(Procedure proc, CallContext ctx) {
    proc.checkN(getValues(), ctx);
  }
  
  public void print(Consumer out) {
    if (this == empty) {
      out.write("#!void");
      return;
    }
    boolean readable = true;
    if (readable)
      out.write("#<values");
    for (int it = 0; (it = nextPos(it)) != 0;) {
      out.write(32);
      Object val = getPosPrevious(it);
      if ((val instanceof Printable)) {
        ((Printable)val).print(out);
      } else
        out.writeObject(val);
    }
    if (readable) {
      out.write(62);
    }
  }
  

  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    out.writeInt(size());
    int it = 0; for (int i = 0; (it = nextPos(it)) != 0;) {
      out.writeObject(getPosPrevious(it));
    }
  }
  
  public Object readResolve() throws java.io.ObjectStreamException {
    return canonicalize();
  }
  
  public static int incrPos(Object values, int pos) {
    if ((values instanceof Values)) {
      return ((Values)values).nextPos(pos);
    }
    return 1 - pos;
  }
  
  public static Object getFromPos(Object values, int pos) {
    if (pos == 0)
      throw new IndexOutOfBoundsException("not enough values");
    if ((values instanceof Values)) {
      return ((Values)values).getPosPrevious(pos);
    }
    return values;
  }
  
  public static Object getFromPosFinal(Object values, int pos) {
    Object r = getFromPos(values, pos);
    checkFinalPos(values, pos);
    return r;
  }
  
  public static void checkFinalPos(Object values, int pos) {
    if (incrPos(values, pos) != 0) {
      throw new IndexOutOfBoundsException("too many values");
    }
  }
  




  public static int nextIndex(Object values, int curIndex)
  {
    if ((values instanceof Values)) {
      if (curIndex == Integer.MAX_VALUE)
        curIndex = -1;
      int next = ((Values)values).nextPos(curIndex);
      return next == -1 ? Integer.MAX_VALUE : next == 0 ? -1 : next;
    }
    return curIndex == 0 ? 1 : -1;
  }
  




  public static Object nextValue(Object values, int curIndex)
  {
    if ((values instanceof Values)) {
      if (curIndex == Integer.MAX_VALUE)
        curIndex = -1;
      return ((Values)values).getPosNext(curIndex);
    }
    return values;
  }
  
  protected int nextIndex(int ipos) {
    if (ipos == -1) return size();
    return ipos >>> 1;
  }
  
  public static void writeValues(Object value, Consumer out) {
    if ((value instanceof Values)) {
      ((Values)value).consume(out);





    }
    else
    {




      out.writeObject(value); }
  }
  
  public static int countValues(Object value) {
    return (value instanceof Values) ? ((Values)value).size() : 1;
  }
  
  public static class FromArray<E> extends Values<E>
  {
    E[] data;
    
    public FromArray(E[] data)
    {
      this.data = data;
    }
    
    public int size()
    {
      return data.length;
    }
    
    public E get(int index)
    {
      return data[index];
    }
    
    public Object[] getValues()
    {
      return data;
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
      int len = in.readInt();
      E[] arr = (Object[])new Object[len];
      for (int i = 0; i < len; i++)
        arr[i] = in.readObject();
      data = arr;
    }
  }
  
  public static class FromList<E> extends Values<E>
  {
    private List<E> list;
    
    public FromList(List<E> list)
    {
      this.list = list;
    }
    
    public int size()
    {
      return list.size();
    }
    
    public E get(int index)
    {
      return list.get(index);
    }
    
    public Object[] getValues()
    {
      return list.toArray();
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
      int len = in.readInt();
      ArrayList<E> lst = new ArrayList(len);
      for (int i = 0; i < len; i++)
        lst.add(in.readObject());
      list = lst;
    }
  }
  



















  public static class Values2<E, V1 extends E, V2 extends E>
    extends Values<E>
  {
    V1 value1;
    


















    V2 value2;
    


















    public Values2(V1 value1, V2 value2)
    {
      this.value1 = value1;
      this.value2 = value2; }
    
    public V1 getValue1() { return value1; }
    public V2 getValue2() { return value2; }
    
    public Object call_with(Procedure proc) throws Throwable
    {
      return proc.apply2(value1, value2);
    }
    
    public void check_with(Procedure proc, CallContext ctx)
    {
      proc.check2(value1, value2, ctx);
    }
    
    public int size()
    {
      return 2;
    }
    
    public E get(int index)
    {
      if (index == 0) return value1;
      if (index == 1) return value2;
      throw new IndexOutOfBoundsException();
    }
    
    public Object[] getValues()
    {
      return new Object[] { value1, value2 };
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
      int len = in.readInt();
      if (len != 2)
        throw new IOException("inconsistent readExternal");
      value1 = in.readObject();
      value2 = in.readObject();
    }
    
    public Object canonicalize()
    {
      return this;
    }
  }
  
  public static class FromTreeList
    extends Values<Object> implements Printable, Consumer, gnu.lists.PositionConsumer
  {
    protected final TreeList buffer;
    
    public FromTreeList(Object[] values)
    {
      this();
      for (int i = 0; i < values.length; i++)
        buffer.writeObject(values[i]);
    }
    
    public FromTreeList() {
      buffer = new TreeList();
    }
    
    public FromTreeList(TreeList list) {
      buffer = list;
    }
    
    public int size()
    {
      return buffer.size();
    }
    
    public Object get(int index)
    {
      return buffer.get(index);
    }
    
    public int createPos(int index, boolean isAfter)
    {
      return buffer.createPos(index, isAfter);
    }
    
    public Object canonicalize()
    {
      if (buffer.gapEnd == buffer.data.length) {
        if (buffer.gapStart == 0)
          return empty;
        if (buffer.nextDataIndex(0) == buffer.gapStart)
          return buffer.getPosNext(0);
      }
      return this;
    }
    
    public Object[] getValues()
    {
      return buffer.isEmpty() ? noArgs : buffer.toArray();
    }
    

    public int nextMatching(int startPos, ItemPredicate type, int endPos, boolean descend)
    {
      return buffer.nextMatching(startPos, type, endPos, descend);
    }
    
    public void clear() {
      buffer.clear();
    }
    
    public int createRelativePos(int pos, int delta, boolean isAfter) {
      return buffer.createRelativePos(pos, delta, isAfter);
    }
    
    protected int nextIndex(int ipos) {
      return buffer.nextIndex(ipos);
    }
    
    public boolean hasNext(int ipos) {
      return buffer.hasNext(ipos);
    }
    
    public int getNextKind(int ipos)
    {
      return buffer.getNextKind(ipos);
    }
    
    public Object getNextTypeObject(int ipos)
    {
      return buffer.getNextTypeObject(ipos);
    }
    
    public int nextPos(int ipos)
    {
      return buffer.nextPos(ipos);
    }
    
    public int firstChildPos(int ipos) {
      return buffer.firstChildPos(ipos);
    }
    
    public int firstAttributePos(int ipos) {
      return buffer.firstAttributePos(ipos);
    }
    
    public int parentPos(int ipos) {
      return buffer.parentPos(ipos);
    }
    
    public boolean gotoAttributesStart(gnu.lists.TreePosition pos) {
      return buffer.gotoAttributesStart(pos);
    }
    
    public Object getPosNext(int ipos) {
      return buffer.getPosNext(ipos);
    }
    
    public Object getPosPrevious(int ipos) {
      return buffer.getPosPrevious(ipos);
    }
    
    public int compare(int ipos1, int ipos2) {
      return buffer.compare(ipos1, ipos2);
    }
    
    public int hashCode() {
      return buffer.hashCode();
    }
    
    public boolean consumeNext(int ipos, Consumer out) {
      return buffer.consumeNext(ipos, out);
    }
    
    public void consumePosRange(int startPos, int endPos, Consumer out) {
      buffer.consumePosRange(startPos, endPos, out);
    }
    
    public void consume(Consumer out) {
      buffer.consume(out);
    }
    
    public void toString(String sep, StringBuffer sbuf) {
      buffer.toString(sep, sbuf);
    }
    
    public void writeBoolean(boolean v) { buffer.writeBoolean(v); }
    public void writeFloat(float v) { buffer.writeFloat(v); }
    public void writeDouble(double v) { buffer.writeDouble(v); }
    public void writeInt(int v) { buffer.writeInt(v); }
    public void writeLong(long v) { buffer.writeLong(v); }
    public void startDocument() { buffer.startDocument(); }
    public void endDocument() { buffer.endDocument(); }
    public void startElement(Object type) { buffer.startElement(type); }
    public void endElement() { buffer.endElement(); }
    public void startAttribute(Object t) { buffer.startAttribute(t); }
    public void endAttribute() { buffer.endAttribute(); }
    public void writeObject(Object v) { buffer.writeObject(v); }
    public boolean ignoring() { return buffer.ignoring(); }
    public void write(int ch) { buffer.write(ch); }
    public void write(String string) { buffer.write(string); }
    public void write(CharSequence s, int i, int l) { buffer.write(s, i, l); }
    public void write(char[] b, int s, int l) { buffer.write(b, s, l); }
    public Consumer append(char c) { return buffer.append(c); }
    public Consumer append(CharSequence csq) { return buffer.append(csq); }
    public Consumer append(CharSequence csq, int start, int end) { return buffer.append(csq, start, end); }
    public void writePosition(gnu.lists.SeqPosition spos) { buffer.writePosition(spos); }
    
    public void writePosition(AbstractSequence seq, int ipos) { buffer.writePosition(seq, ipos); }
    
    public void readExternal(ObjectInput in)
      throws IOException, ClassNotFoundException
    {
      int len = in.readInt();
      for (int i = 0; i < len; i++) {
        writeObject(in.readObject());
      }
    }
  }
}
