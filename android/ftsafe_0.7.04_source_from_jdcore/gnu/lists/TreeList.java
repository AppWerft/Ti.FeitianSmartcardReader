package gnu.lists;

import gnu.text.Char;
import java.io.PrintWriter;







public class TreeList
  extends AbstractSequence<Object>
  implements Appendable, XConsumer, PositionConsumer, Consumable
{
  public Object[] objects;
  public int oindex;
  public char[] data;
  public int gapStart;
  public int gapEnd;
  public int attrStart;
  public int docStart;
  public static final int MAX_CHAR_SHORT = 40959;
  static final int MIN_INT_SHORT = -4096;
  static final int MAX_INT_SHORT = 8191;
  static final int INT_SHORT_ZERO = 49152;
  static final int OBJECT_REF_SHORT = 57344;
  static final int OBJECT_REF_SHORT_INDEX_MAX = 4095;
  static final char OBJECT_REF_FOLLOWS = '';
  static final char POSITION_REF_FOLLOWS = '';
  protected static final char POSITION_PAIR_FOLLOWS = '';
  static final int BYTE_PREFIX = 61440;
  static final char BOOL_FALSE = '';
  static final char BOOL_TRUE = '';
  public static final int INT_FOLLOWS = 61698;
  static final int LONG_FOLLOWS = 61699;
  
  public TreeList()
  {
    resizeObjects();
    gapEnd = 200;
    data = new char[gapEnd];
  }
  






  public TreeList(TreeList list, int startPosition, int endPosition)
  {
    this();
    list.consumeIRange(startPosition, endPosition, this);
  }
  
  public TreeList(TreeList list)
  {
    this(list, 0, data.length);
  }
  
  public void clear()
  {
    gapStart = 0;
    gapEnd = data.length;
    attrStart = 0;
    if (gapEnd > 1500)
    {
      gapEnd = 200;
      data = new char[gapEnd];
    }
    objects = null;
    oindex = 0;
    resizeObjects();
  }
  










  static final int FLOAT_FOLLOWS = 61700;
  









  static final int DOUBLE_FOLLOWS = 61701;
  









  static final int CHAR_FOLLOWS = 61702;
  









  static final int COMMENT = 61719;
  









  protected static final int PROCESSING_INSTRUCTION = 61716;
  









  static final int CDATA_SECTION = 61717;
  









  static final int JOINER = 61718;
  









  protected static final int BEGIN_ATTRIBUTE_LONG = 61705;
  









  public static final int BEGIN_ATTRIBUTE_LONG_SIZE = 5;
  









  static final int END_ATTRIBUTE = 61706;
  









  public static final int END_ATTRIBUTE_SIZE = 1;
  









  protected static final int BEGIN_DOCUMENT = 61712;
  









  protected static final int END_DOCUMENT = 61713;
  









  public static final int BEGIN_ENTITY = 61714;
  









  public static final int BEGIN_ENTITY_SIZE = 5;
  









  protected static final int END_ENTITY = 61715;
  









  protected static final int DOCUMENT_URI = 61720;
  









  protected static final int BEGIN_ELEMENT_SHORT = 40960;
  








  protected static final int BEGIN_ELEMENT_SHORT_INDEX_MAX = 4095;
  








  protected static final int END_ELEMENT_SHORT = 61707;
  








  protected static final int BEGIN_ELEMENT_LONG = 61704;
  








  protected static final int END_ELEMENT_LONG = 61708;
  








  int currentParent = -1;
  
  public void ensureSpace(int needed)
  {
    int avail = gapEnd - gapStart;
    if (needed > avail)
    {
      int oldSize = data.length;
      int neededSize = oldSize - avail + needed;
      int newSize = 2 * oldSize;
      if (newSize < neededSize)
        newSize = neededSize;
      char[] tmp = new char[newSize];
      if (gapStart > 0)
        System.arraycopy(data, 0, tmp, 0, gapStart);
      int afterGap = oldSize - gapEnd;
      if (afterGap > 0)
        System.arraycopy(data, gapEnd, tmp, newSize - afterGap, afterGap);
      gapEnd = (newSize - afterGap);
      data = tmp;
    }
  }
  

  public final void resizeObjects()
  {
    Object[] tmp;
    Object[] tmp;
    if (objects == null)
    {
      int oldLength = 0;
      int newLength = 100;
      tmp = new Object[newLength];
    }
    else
    {
      int oldLength = objects.length;
      int newLength = 2 * oldLength;
      tmp = new Object[newLength];
      System.arraycopy(objects, 0, tmp, 0, oldLength);
    }
    objects = tmp;
  }
  
  public int find(Object arg1)
  {
    if (oindex == objects.length)
      resizeObjects();
    objects[oindex] = arg1;
    return oindex++;
  }
  

  protected final int getIntN(int index)
  {
    return data[index] << '\020' | data[(index + 1)] & 0xFFFF;
  }
  

  protected final long getLongN(int index)
  {
    char[] data = this.data;
    return (data[index] & 0xFFFF) << 48 | (data[(index + 1)] & 0xFFFF) << 32 | (data[(index + 2)] & 0xFFFF) << 16 | data[(index + 3)] & 0xFFFF;
  }
  



  public final void setIntN(int index, int i)
  {
    data[index] = ((char)(i >> 16));
    data[(index + 1)] = ((char)i);
  }
  
  public void writePosition(SeqPosition position)
  {
    ensureSpace(3);
    
    int index = find(position.copy());
    data[(gapStart++)] = 61710;
    setIntN(gapStart, index);
    gapStart += 2;
  }
  
  public void writePosition(AbstractSequence seq, int ipos)
  {
    ensureSpace(5);
    data[gapStart] = 61711;
    int seq_index = find(seq);
    setIntN(gapStart + 1, seq_index);
    setIntN(gapStart + 3, ipos);
    gapStart += 5;
  }
  
  public void writeObject(Object v)
  {
    if (gapEnd - gapStart < 3)
      ensureSpace(3);
    int index = find(v);
    if (index < 4096) {
      data[(gapStart++)] = ((char)(0xE000 | index));
    }
    else {
      data[(gapStart++)] = 61709;
      setIntN(gapStart, index);
      gapStart += 2;
    }
  }
  


  public void writeDocumentUri(Object uri)
  {
    ensureSpace(3);
    int index = find(uri);
    data[(gapStart++)] = 61720;
    setIntN(gapStart, index);
    gapStart += 2;
  }
  
  public void writeComment(char[] chars, int offset, int length)
  {
    ensureSpace(3 + length);
    int i = gapStart;
    data[(i++)] = 61719;
    setIntN(i, length);
    i += 2;
    System.arraycopy(chars, offset, data, i, length);
    gapStart = (i + length);
  }
  
  public void writeComment(String comment, int offset, int length)
  {
    ensureSpace(3 + length);
    int i = gapStart;
    data[(i++)] = 61719;
    setIntN(i, length);
    i += 2;
    comment.getChars(offset, offset + length, data, i);
    gapStart = (i + length);
  }
  

  public void writeProcessingInstruction(String target, char[] content, int offset, int length)
  {
    ensureSpace(5 + length);
    int i = gapStart;
    data[(i++)] = 61716;
    int index = find(target);
    setIntN(i, index);
    setIntN(i + 2, length);
    i += 4;
    System.arraycopy(content, offset, data, i, length);
    gapStart = (i + length);
  }
  

  public void writeProcessingInstruction(String target, String content, int offset, int length)
  {
    ensureSpace(5 + length);
    int i = gapStart;
    data[(i++)] = 61716;
    int index = find(target);
    setIntN(i, index);
    setIntN(i + 2, length);
    i += 4;
    content.getChars(offset, offset + length, data, i);
    gapStart = (i + length);
  }
  
  public void startElement(Object type)
  {
    startElement(find(type));
  }
  
  public void startDocument()
  {
    ensureSpace(6);
    gapEnd -= 1;
    int p = gapStart;
    data[p] = 61712;
    if (docStart != 0)
      throw new Error("nested document");
    docStart = (p + 1);
    setIntN(p + 1, gapEnd - data.length);
    setIntN(p + 3, currentParent == -1 ? -1 : currentParent - p);
    currentParent = p;
    gapStart = (p + 5);
    currentParent = p;
    data[gapEnd] = 61713;
  }
  
  public void endDocument()
  {
    if ((data[gapEnd] != 61713) || (docStart <= 0) || (data[currentParent] != 61712))
    {
      throw new Error("unexpected endDocument");
    }
    gapEnd += 1;
    setIntN(docStart, gapStart - docStart + 1);
    docStart = 0;
    data[(gapStart++)] = 61713;
    int parent = getIntN(currentParent + 3);
    currentParent = (parent >= -1 ? parent : currentParent + parent);
  }
  




  public void beginEntity(Object base)
  {
    if (gapStart != 0)
      return;
    ensureSpace(6);
    gapEnd -= 1;
    int p = gapStart;
    data[p] = 61714;
    setIntN(p + 1, find(base));
    setIntN(p + 3, currentParent == -1 ? -1 : currentParent - p);
    gapStart = (p + 5);
    currentParent = p;
    data[gapEnd] = 61715;
  }
  

  public void endEntity()
  {
    if ((gapEnd + 1 != data.length) || (data[gapEnd] != 61715))
      return;
    if (data[currentParent] != 61714)
    {
      throw new Error("unexpected endEntity");
    }
    gapEnd += 1;
    data[(gapStart++)] = 61715;
    int parent = getIntN(currentParent + 3);
    currentParent = (parent >= -1 ? parent : currentParent + parent);
  }
  
  public void startElement(int index)
  {
    ensureSpace(10);
    gapEnd -= 7;
    data[(gapStart++)] = 61704;
    setIntN(gapStart, gapEnd - data.length);
    gapStart += 2;
    data[gapEnd] = 61708;
    setIntN(gapEnd + 1, index);
    setIntN(gapEnd + 3, gapStart - 3);
    setIntN(gapEnd + 5, currentParent);
    currentParent = (gapStart - 3);
  }
  
  public void setElementName(int elementIndex, int nameIndex)
  {
    if (data[elementIndex] == 61704)
    {
      int j = getIntN(elementIndex + 1);
      elementIndex = j + (j < 0 ? data.length : elementIndex);
    }
    if (elementIndex < gapEnd)
      throw new Error("setElementName before gapEnd");
    setIntN(elementIndex + 1, nameIndex);
  }
  
  public void endElement()
  {
    if (data[gapEnd] != 61708)
      throw new Error("unexpected endElement");
    int index = getIntN(gapEnd + 1);
    int begin = getIntN(gapEnd + 3);
    int parent = getIntN(gapEnd + 5);
    currentParent = parent;
    gapEnd += 7;
    int offset = gapStart - begin;
    int parentOffset = begin - parent;
    if ((index < 4095) && (offset < 65536) && (parentOffset < 65536))
    {

      data[begin] = ((char)(0xA000 | index));
      data[(begin + 1)] = ((char)offset);
      data[(begin + 2)] = ((char)parentOffset);
      data[gapStart] = 61707;
      data[(gapStart + 1)] = ((char)offset);
      gapStart += 2;
    }
    else
    {
      data[begin] = 61704;
      setIntN(begin + 1, offset);
      data[gapStart] = 61708;
      setIntN(gapStart + 1, index);
      setIntN(gapStart + 3, -offset);
      if ((parent >= gapStart) || (begin <= gapStart))
        parent -= gapStart;
      setIntN(gapStart + 5, parent);
      gapStart += 7;
    }
  }
  
  public void startAttribute(Object attrType)
  {
    startAttribute(find(attrType));
  }
  




















  public void startAttribute(int index)
  {
    ensureSpace(6);
    gapEnd -= 1;
    data[(gapStart++)] = 61705;
    if (attrStart != 0)
      throw new Error("nested attribute");
    attrStart = gapStart;
    setIntN(gapStart, index);
    setIntN(gapStart + 2, gapEnd - data.length);
    gapStart += 4;
    data[gapEnd] = 61706;
  }
  
  public void setAttributeName(int attrIndex, int nameIndex)
  {
    setIntN(attrIndex + 1, nameIndex);
  }
  
  public void endAttribute()
  {
    if (attrStart <= 0)
      return;
    if (data[gapEnd] != 61706) {
      throw new Error("unexpected endAttribute");
    }
    gapEnd += 1;
    setIntN(attrStart + 2, gapStart - attrStart + 1);
    attrStart = 0;
    data[(gapStart++)] = 61706;
  }
  
  public Consumer append(char c)
  {
    write(c);
    return this;
  }
  
  public void write(int c)
  {
    ensureSpace(3);
    if (c <= 40959) {
      data[(gapStart++)] = ((char)c);
    } else if (c < 65536)
    {
      data[(gapStart++)] = 61702;
      data[(gapStart++)] = ((char)c);
    }
    else {
      Char.print(c, this);
    }
  }
  
  public void writeBoolean(boolean v) {
    ensureSpace(1);
    data[(gapStart++)] = (v ? 61697 : 61696);
  }
  
  public void writeByte(int v)
  {
    ensureSpace(1);
    data[(gapStart++)] = ((char)(61440 + (v & 0xFF)));
  }
  
  public void writeInt(int v)
  {
    ensureSpace(3);
    if ((v >= 61440) && (v <= 8191)) {
      data[(gapStart++)] = ((char)(49152 + v));
    }
    else {
      data[(gapStart++)] = 61698;
      setIntN(gapStart, v);
      gapStart += 2;
    }
  }
  
  public void writeLong(long v)
  {
    ensureSpace(5);
    data[(gapStart++)] = 61699;
    data[(gapStart++)] = ((char)(int)(v >>> 48));
    data[(gapStart++)] = ((char)(int)(v >>> 32));
    data[(gapStart++)] = ((char)(int)(v >>> 16));
    data[(gapStart++)] = ((char)(int)v);
  }
  
  public void writeFloat(float v)
  {
    ensureSpace(3);
    int i = Float.floatToIntBits(v);
    data[(gapStart++)] = 61700;
    data[(gapStart++)] = ((char)(i >>> 16));
    data[(gapStart++)] = ((char)i);
  }
  
  public void writeDouble(double v)
  {
    ensureSpace(5);
    long l = Double.doubleToLongBits(v);
    data[(gapStart++)] = 61701;
    data[(gapStart++)] = ((char)(int)(l >>> 48));
    data[(gapStart++)] = ((char)(int)(l >>> 32));
    data[(gapStart++)] = ((char)(int)(l >>> 16));
    data[(gapStart++)] = ((char)(int)l);
  }
  
  public boolean ignoring()
  {
    return false;
  }
  
  public void writeJoiner()
  {
    ensureSpace(1);
    data[(gapStart++)] = 61718;
  }
  
  public void write(char[] buf, int off, int len)
  {
    if (len == 0)
      writeJoiner();
    ensureSpace(len);
    while (len > 0)
    {
      char ch = buf[(off++)];
      len--;
      if (ch <= 40959) {
        data[(gapStart++)] = ch;
      }
      else {
        write(ch);
        ensureSpace(len);
      }
    }
  }
  
  public void write(String str)
  {
    write(str, 0, str.length());
  }
  




  public void write(CharSequence str, int start, int length)
  {
    if (length == 0)
      writeJoiner();
    ensureSpace(length);
    while (length > 0)
    {
      char ch = str.charAt(start++);
      length--;
      if (ch <= 40959) {
        data[(gapStart++)] = ch;
      }
      else {
        write(ch);
        ensureSpace(length);
      }
    }
  }
  
  public void writeCDATA(char[] chars, int offset, int length)
  {
    ensureSpace(3 + length);
    int i = gapStart;
    data[(i++)] = 61717;
    setIntN(i, length);
    i += 2;
    System.arraycopy(chars, offset, data, i, length);
    gapStart = (i + length);
  }
  

  public Consumer append(CharSequence csq)
  {
    if (csq == null)
      csq = "null";
    return append(csq, 0, csq.length());
  }
  
  public Consumer append(CharSequence csq, int start, int end)
  {
    if (csq == null)
      csq = "null";
    for (int i = start; i < end; i++)
      append(csq.charAt(i));
    return this;
  }
  












  public boolean isEmpty()
  {
    int pos = gapStart == 0 ? gapEnd : 0;
    return pos == data.length;
  }
  
  public int size()
  {
    int size = 0;
    int i = 0;
    for (;;)
    {
      i = nextPos(i);
      if (i == 0)
        return size;
      size++;
    }
  }
  
  public int createPos(int index, boolean isAfter)
  {
    return createRelativePos(0, index, isAfter);
  }
  
  public final int posToDataIndex(int ipos)
  {
    if (ipos == -1)
      return data.length;
    int index = ipos >>> 1;
    if ((ipos & 0x1) != 0)
      index--;
    if (index == gapStart)
      index += gapEnd - gapStart;
    if ((ipos & 0x1) != 0)
    {
      index = nextDataIndex(index);
      if (index < 0)
        return data.length;
      if (index == gapStart)
        index += gapEnd - gapStart;
    }
    return index;
  }
  
  public int firstChildPos(int ipos)
  {
    int index = gotoChildrenStart(posToDataIndex(ipos));
    if (index < 0)
      return 0;
    return index << 1;
  }
  
  public final int gotoChildrenStart(int index)
  {
    if (index == data.length)
      return -1;
    char datum = data[index];
    if (((datum >= 40960) && (datum <= 45055)) || (datum == 61704))
    {

      index += 3;
    } else if ((datum == 61712) || (datum == 61714)) {
      index += 5;
    } else {
      return -1;
    }
    for (;;) {
      if (index >= gapStart)
        index += gapEnd - gapStart;
      datum = data[index];
      if (datum == 61705)
      {
        int end = getIntN(index + 3);
        index = end + (end < 0 ? data.length : index);
      }
      else if ((datum == 61706) || (datum == 61718)) {
        index++;
      } else { if (datum != 61720) break;
        index += 3;
      }
    }
    
    return index;
  }
  
  public int parentPos(int ipos)
  {
    int index = posToDataIndex(ipos);
    do
    {
      index = parentOrEntityI(index);
      if (index == -1)
        return -1;
    } while (data[index] == 61714);
    return index << 1;
  }
  

  public int parentOrEntityPos(int ipos)
  {
    int index = parentOrEntityI(posToDataIndex(ipos));
    return index < 0 ? -1 : index << 1;
  }
  
  public int parentOrEntityI(int index)
  {
    if (index == data.length)
      return -1;
    char datum = data[index];
    if ((datum == 61712) || (datum == 61714))
    {
      int parent_offset = getIntN(index + 3);
      if (parent_offset >= -1) {
        return parent_offset;
      }
      return index + parent_offset;
    }
    if ((datum >= 40960) && (datum <= 45055))
    {

      int parent_offset = data[(index + 2)];
      return parent_offset == 0 ? -1 : index - parent_offset;
    }
    if (datum == 61704)
    {
      int end_offset = getIntN(index + 1);
      end_offset += (end_offset < 0 ? data.length : index);
      int parent_offset = getIntN(end_offset + 5);
      if (parent_offset == 0)
        return -1;
      if (parent_offset < 0)
        parent_offset += end_offset;
      return parent_offset;
    }
    for (;;)
    {
      if (index == gapStart)
        index = gapEnd;
      if (index == data.length)
        return -1;
      datum = data[index];
      switch (datum)
      {
      case '': 
        return index - data[(index + 1)];
      case '': 
        int begin_offset = getIntN(index + 3);
        if (begin_offset < 0)
          begin_offset += index;
        return begin_offset;
      case '': 
        index++;
        break;
      case '': 
        return -1;
      case '': case '': case '': case '': default: 
        index = nextDataIndex(index);
        
        if (index < 0) break label270;
        break; } }
    label270:
    return -1;
  }
  
  public int getAttributeCount(int parent)
  {
    int n = 0;
    for (int attr = firstAttributePos(parent); 
        (attr != 0) && (getNextKind(attr) == 35); 
        attr = nextPos(attr))
      n++;
    return n;
  }
  
  public boolean gotoAttributesStart(TreePosition pos)
  {
    int index = gotoAttributesStart(ipos >> 1);
    if (index < 0)
      return false;
    pos.push(this, index << 1);
    return true;
  }
  
  public int firstAttributePos(int ipos)
  {
    int index = gotoAttributesStart(posToDataIndex(ipos));
    return index < 0 ? 0 : index << 1;
  }
  
  public int gotoAttributesStart(int index)
  {
    if (index >= gapStart)
      index += gapEnd - gapStart;
    if (index == data.length)
      return -1;
    char datum = data[index];
    if (((datum >= 40960) && (datum <= 45055)) || (datum == 61704))
    {

      return index + 3;
    }
    return -1;
  }
  
  public Object get(int index)
  {
    int i = 0;
    do { index--; if (index < 0)
        break;
      i = nextPos(i);
    } while (i != 0);
    throw new IndexOutOfBoundsException();
    
    return getPosNext(i);
  }
  
  public boolean consumeNext(int ipos, Consumer out)
  {
    if (!hasNext(ipos))
      return false;
    int start = posToDataIndex(ipos);
    int end = nextNodeIndex(start, Integer.MAX_VALUE);
    if (end == start)
      end = nextDataIndex(start);
    if (end >= 0)
      consumeIRange(start, end, out);
    return true;
  }
  
  public void consumePosRange(int startPos, int endPos, Consumer out)
  {
    consumeIRange(posToDataIndex(startPos), posToDataIndex(endPos), out);
  }
  
  public int consumeIRange(int startPosition, int endPosition, Consumer out)
  {
    int pos = startPosition;
    int limit = (startPosition <= gapStart) && (endPosition > gapStart) ? gapStart : endPosition;
    
    char datum;
    for (;;)
    {
      if (pos >= limit)
      {
        if ((pos != gapStart) || (endPosition <= gapEnd))
          break;
        pos = gapEnd;
        limit = endPosition;
      }
      



      datum = data[(pos++)];
      
      if (datum <= 40959)
      {
        int start = pos - 1;
        int lim = limit;
        

        while (pos < lim)
        {
          datum = data[(pos++)];
          if (datum > 40959)
          {
            pos--;
          }
        }
        
        out.write(data, start, pos - start);

      }
      else if ((datum >= 57344) && (datum <= 61439))
      {

        out.writeObject(objects[(datum - 57344)]);

      }
      else if ((datum >= 40960) && (datum <= 45055))
      {

        int index = datum - 40960;
        out.startElement(objects[index]);
        pos += 2;








      }
      else if ((datum >= 45056) && (datum <= 57343))
      {

        out.writeInt(datum - 49152);
      } else {
        int index;
        switch (datum)
        {
        case '': 
          out.startDocument();
          pos += 4;
          break;
        case '': 
          out.endDocument();
          break;
        case '': 
          if ((out instanceof TreeList))
            ((TreeList)out).beginEntity(objects[getIntN(pos)]);
          pos += 4;
          break;
        case '': 
          if ((out instanceof TreeList))
            ((TreeList)out).endEntity();
          break;
        case '': 
          if ((out instanceof TreeList))
            ((TreeList)out).writeDocumentUri(objects[getIntN(pos)]);
          pos += 2;
          break;
        
        case '': 
          int length = getIntN(pos);
          pos += 2;
          if ((out instanceof XConsumer))
            ((XConsumer)out).writeComment(data, pos, length);
          pos += length;
          
          break;
        
        case '': 
          int length = getIntN(pos);
          pos += 2;
          if ((out instanceof XConsumer)) {
            ((XConsumer)out).writeCDATA(data, pos, length);
          } else
            out.write(data, pos, length);
          pos += length;
          
          break;
        
        case '': 
          String target = (String)objects[getIntN(pos)];
          int length = getIntN(pos + 2);
          pos += 4;
          if ((out instanceof XConsumer)) {
            ((XConsumer)out).writeProcessingInstruction(target, data, pos, length);
          }
          pos += length;
          
          break;
        case '': 
        case '': 
          out.writeBoolean(datum != 61696);
          break;
        case '': 
          out.write("");
          break;
        case '': 
          out.write(data, pos, '\001' + datum - 61702);
          pos++;
          break;
        
        case '': 
          AbstractSequence seq = (AbstractSequence)objects[getIntN(pos)];
          int ipos = getIntN(pos + 2);
          if ((out instanceof PositionConsumer)) {
            ((PositionConsumer)out).writePosition(seq, ipos);
          } else
            out.writeObject(seq.getIteratorAtPos(ipos));
          pos += 4;
          
          break;
        case '': 
          if ((out instanceof PositionConsumer))
          {
            ((PositionConsumer)out).writePosition((SeqPosition)objects[getIntN(pos)]);
            pos += 2; }
          break;
        

        case '': 
          out.writeObject(objects[getIntN(pos)]);
          pos += 2;
          break;
        case '': 
          pos++;
          out.endElement();
          break;
        case '': 
          index = getIntN(pos);
          index += (index >= 0 ? pos - 1 : data.length);
          pos += 2;
          index = getIntN(index + 1);
          out.startElement(objects[index]);
          break;
        case '': 
          index = getIntN(pos);
          out.endElement();
          pos += 6;
          break;
        case '': 
          index = getIntN(pos);
          out.startAttribute(objects[index]);
          pos += 4;
          break;
        case '': 
          out.endAttribute();
          break;
        case '': 
          out.writeInt(getIntN(pos));
          pos += 2;
          break;
        case '': 
          out.writeFloat(Float.intBitsToFloat(getIntN(pos)));
          pos += 2;
          break;
        case '': 
          out.writeLong(getLongN(pos));
          pos += 4;
          break;
        case '': 
          out.writeDouble(Double.longBitsToDouble(getLongN(pos)));
          pos += 4; }
      }
    }
    throw new Error("unknown code:" + datum);
    

    return pos;
  }
  
  public void toString(String sep, StringBuffer sbuf)
  {
    int pos = 0;
    int limit = gapStart;
    
    boolean seen = false;
    boolean inStartTag = false;
    boolean inAttribute = false;
    char datum;
    for (;;) {
      if (pos >= limit)
      {
        if (pos != gapStart)
          break;
        pos = gapEnd;
        limit = data.length;
        if (pos == limit) {
          break;
        }
      }
      


      datum = data[(pos++)];
      
      if (datum <= 40959)
      {
        int start = pos - 1;
        int lim = limit;
        

        while (pos < lim)
        {
          datum = data[(pos++)];
          if (datum > 40959)
          {
            pos--;
          }
        }
        
        if (inStartTag) { sbuf.append('>');inStartTag = false; }
        sbuf.append(data, start, pos - start);
        seen = false;

      }
      else if ((datum >= 57344) && (datum <= 61439))
      {

        if (inStartTag) { sbuf.append('>');inStartTag = false; }
        if (seen) sbuf.append(sep); else seen = true;
        sbuf.append(objects[(datum - 57344)]);

      }
      else if ((datum >= 40960) && (datum <= 45055))
      {

        if (inStartTag) { sbuf.append('>');inStartTag = false; }
        int index = datum - 40960;
        if (seen) sbuf.append(sep);
        sbuf.append('<');
        sbuf.append(objects[index].toString());
        pos += 2;
        seen = false;
        inStartTag = true;

      }
      else if ((datum >= 45056) && (datum <= 57343))
      {

        if (inStartTag) { sbuf.append('>');inStartTag = false; }
        if (seen) sbuf.append(sep); else seen = true;
        sbuf.append(datum - 49152);
      } else { int index;
        int index;
        switch (datum)
        {
        case '': 
        case '': 
          pos += 4;
          break;
        case '': 
          pos += 2;
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          index = getIntN(pos);
          pos += 2;
          sbuf.append("<!--");
          sbuf.append(data, pos, index);
          sbuf.append("-->");
          pos += index;
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          index = getIntN(pos);
          pos += 2;
          sbuf.append("<![CDATA[");
          sbuf.append(data, pos, index);
          sbuf.append("]]>");
          pos += index;
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          sbuf.append("<?");
          index = getIntN(pos);
          pos += 2;
          sbuf.append(objects[index]);
          index = getIntN(pos);
          pos += 2;
          if (index > 0)
          {
            sbuf.append(' ');
            sbuf.append(data, pos, index);
            pos += index;
          }
          sbuf.append("?>");
          break;
        case '': 
        case '': 
          break;
        case '': 
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          if (seen) sbuf.append(sep); else seen = true;
          sbuf.append(datum != 61696);
          break;
        case '': 
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          sbuf.append(data, pos, '\001' + datum - 61702);
          seen = false;
          pos++;
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          if (seen) sbuf.append(sep); else { seen = true;
          }
          AbstractSequence seq = (AbstractSequence)objects[getIntN(pos)];
          int ipos = getIntN(pos + 2);
          
          sbuf.append(seq.getIteratorAtPos(ipos));
          pos += 4;
          
          break;
        case '': 
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          if (seen) sbuf.append(sep); else seen = true;
          sbuf.append(objects[getIntN(pos)]);
          pos += 2;
          break;
        case '': 
          index = getIntN(pos);
          index += (index >= 0 ? pos - 1 : data.length);
          pos += 2;
          index = getIntN(index + 1);
          if (inStartTag) { sbuf.append('>');
          } else if (seen) sbuf.append(sep);
          sbuf.append('<');
          sbuf.append(objects[index]);
          seen = false;
          inStartTag = true;
          break;
        case '': 
        case '': 
          if (datum == 61707)
          {
            index = data[(pos++)];
            index = data[(pos - 2 - index)] - 40960;
          }
          else
          {
            index = getIntN(pos);
            pos += 6;
          }
          if (inStartTag) {
            sbuf.append("/>");
          }
          else {
            sbuf.append("</");
            sbuf.append(objects[index]);
            sbuf.append('>');
          }
          inStartTag = false;
          seen = true;
          break;
        case '': 
          index = getIntN(pos);
          sbuf.append(' ');
          sbuf.append(objects[index]);
          sbuf.append("=\"");
          inAttribute = true;
          inStartTag = false;
          pos += 4;
          break;
        case '': 
          sbuf.append('"');
          inAttribute = false;
          inStartTag = true;
          seen = false;
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          if (seen) sbuf.append(sep); else seen = true;
          sbuf.append(getIntN(pos));
          pos += 2;
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          if (seen) sbuf.append(sep); else seen = true;
          sbuf.append(Float.intBitsToFloat(getIntN(pos)));
          pos += 2;
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          if (seen) sbuf.append(sep); else seen = true;
          sbuf.append(getLongN(pos));
          pos += 4;
          break;
        case '': 
          if (inStartTag) { sbuf.append('>');inStartTag = false; }
          if (seen) sbuf.append(sep); else seen = true;
          sbuf.append(Double.longBitsToDouble(getLongN(pos)));
          pos += 4; }
      }
    }
    throw new Error("unknown code:" + datum);
  }
  


  public boolean hasNext(int ipos)
  {
    int index = posToDataIndex(ipos);
    if (index == data.length)
      return false;
    char ch = data[index];
    return (ch != 61706) && (ch != 61707) && (ch != 61708) && (ch != 61713);
  }
  

  public int getNextKind(int ipos)
  {
    return getNextKindI(posToDataIndex(ipos));
  }
  
  public int getNextKindI(int index)
  {
    if (index == data.length)
      return 0;
    char datum = data[index];
    if (datum <= 40959)
      return 29;
    if ((datum >= 57344) && (datum <= 61439))
    {
      return 32; }
    if ((datum >= 40960) && (datum <= 45055))
    {
      return 33; }
    if ((datum & 0xFF00) == 61440)
      return 28;
    if ((datum >= 45056) && (datum <= 57343))
    {
      return 22; }
    switch (datum)
    {
    case '': 
    case '': 
      return 27;
    case '': 
      return 22;
    case '': 
      return 24;
    case '': 
      return 25;
    case '': 
      return 26;
    case '': 
      return 29;
    case '': 
      return 34;
    case '': 
      return getNextKind(index + 5 << 1);
    case '': 
      return 33;
    case '': 
    case '': 
    case '': 
    case '': 
    case '': 
      return 0;
    case '': 
      return 35;
    case '': 
      return 31;
    case '': 
      return 36;
    case '': 
      return 37;
    }
    
    



    return 32;
  }
  


  public Object getNextTypeObject(int ipos)
  {
    int index = posToDataIndex(ipos);
    char datum;
    for (;;)
    {
      if (index == data.length)
        return null;
      datum = data[index];
      if (datum != 61714)
        break;
      index += 5;
    }
    if ((datum >= 40960) && (datum <= 45055))
    {
      index = datum - 40960;
    } else if (datum == 61704)
    {
      int j = getIntN(index + 1);
      j += (j < 0 ? data.length : index);
      index = getIntN(j + 1);
    }
    else if (datum == 61705) {
      index = getIntN(index + 1);
    } else if (datum == 61716) {
      index = getIntN(index + 1);
    } else {
      return null; }
    return index < 0 ? null : objects[index];
  }
  
  public Object getPosPrevious(int ipos)
  {
    if (((ipos & 0x1) != 0) && (ipos != -1)) {
      return getPosNext(ipos - 3);
    }
    return super.getPosPrevious(ipos);
  }
  
  private Object copyToList(int startPosition, int endPosition)
  {
    return new TreeList(this, startPosition, endPosition);
  }
  

  public int getPosNextInt(int ipos)
  {
    int index = posToDataIndex(ipos);
    if (index < data.length)
    {
      char datum = data[index];
      if ((datum >= 45056) && (datum <= 57343))
      {
        return datum - 49152; }
      if (datum == 61698)
        return getIntN(index + 1);
    }
    return ((Number)getPosNext(ipos)).intValue();
  }
  
  public Object getPosNext(int ipos)
  {
    int index = posToDataIndex(ipos);
    if (index == data.length)
      return Sequence.eofValue;
    char datum = data[index];
    if (datum <= 40959)
      return Convert.toObject(datum);
    if ((datum >= 57344) && (datum <= 61439))
    {
      return objects[(datum - 57344)]; }
    if ((datum >= 40960) && (datum <= 45055))
    {
      return copyToList(index, index + data[(index + 1)] + 2);
    }
    


    if ((datum >= 45056) && (datum <= 57343))
    {
      return Convert.toObject(datum - 49152); }
    switch (datum)
    {

    case '': 
      int end_offset = getIntN(index + 1);
      end_offset += (end_offset < 0 ? data.length : index);
      end_offset++;
      





      return copyToList(index, end_offset);
    
    case '': 
    case '': 
      return Convert.toObject(datum != 61696);
    case '': 
      return Convert.toObject(getIntN(index + 1));
    case '': 
      return Convert.toObject(getLongN(index + 1));
    case '': 
      return Convert.toObject(Float.intBitsToFloat(getIntN(index + 1)));
    case '': 
      return Convert.toObject(Double.longBitsToDouble(getLongN(index + 1)));
    case '': 
      return Convert.toObject(data[(index + 1)]);
    
    case '': 
      int end_offset = getIntN(index + 3);
      end_offset += (end_offset < 0 ? data.length : index);
      return copyToList(index, end_offset + 1);
    

    case '': 
      int end_offset = getIntN(index + 1);
      end_offset += (end_offset < 0 ? data.length : index);
      return copyToList(index, end_offset + 7);
    
    case '': 
    case '': 
    case '': 
    case '': 
      return Sequence.eofValue;
    case '': 
    case '': 
      return objects[getIntN(index + 1)];
    case '': 
      return "";
    case '': 
      AbstractSequence seq = (AbstractSequence)objects[getIntN(index + 1)];
      ipos = getIntN(index + 3);
      return seq.getIteratorAtPos(ipos); }
    
    throw unsupported("getPosNext, code=" + Integer.toHexString(datum));
  }
  

  public void stringValue(int startIndex, int endIndex, StringBuffer sbuf)
  {
    int index = startIndex;
    while ((index < endIndex) && (index >= 0)) {
      index = stringValue(false, index, sbuf);
    }
  }
  
  public int stringValue(int index, StringBuffer sbuf) {
    int next = nextNodeIndex(index, Integer.MAX_VALUE);
    if (next > index)
    {
      stringValue(index, next, sbuf);
      return index;
    }
    
    return stringValue(false, index, sbuf);
  }
  
  public int stringValue(boolean inElement, int index, StringBuffer sbuf)
  {
    Object value = null;
    int doChildren = 0;
    if (index >= gapStart)
      index += gapEnd - gapStart;
    if (index == data.length)
      return -1;
    char datum = data[index];
    index++;
    boolean spaceNeeded = false;
    if (datum <= 40959)
    {
      sbuf.append(datum);
      return index;
    }
    if ((datum >= 57344) && (datum <= 61439))
    {

      if (spaceNeeded)
        sbuf.append(' ');
      value = objects[(datum - 57344)];
      spaceNeeded = false;
    }
    else if ((datum >= 40960) && (datum <= 45055))
    {

      doChildren = index + 2;
      index = data[index] + index + 1;
    } else {
      if ((datum & 0xFF00) == 61440)
      {
        sbuf.append(datum & 0xFF);
        return index;
      }
      if ((datum >= 45056) && (datum <= 57343))
      {

        sbuf.append(datum - 49152);
        return index;
      }
      

      switch (datum)
      {
      case '': 
        return index + 2;
      case '': 
        index += 2;
      

      case '': 
      case '': 
        int length = getIntN(index);
        index += 2;
        if ((!inElement) || (datum == 61717))
          sbuf.append(data, index, length);
        return index + length;
      
      case '': 
      case '': 
        if (spaceNeeded)
          sbuf.append(' ');
        sbuf.append(datum != 61696);
        spaceNeeded = true;
        return index;
      case '': 
        if (spaceNeeded)
          sbuf.append(' ');
        sbuf.append(getIntN(index));
        spaceNeeded = true;
        return index + 2;
      case '': 
        if (spaceNeeded)
          sbuf.append(' ');
        sbuf.append(getLongN(index));
        spaceNeeded = true;
        return index + 4;
      case '': 
        if (spaceNeeded)
          sbuf.append(' ');
        sbuf.append(Float.intBitsToFloat(getIntN(index)));
        spaceNeeded = true;
        return index + 2;
      case '': 
        if (spaceNeeded)
          sbuf.append(' ');
        sbuf.append(Double.longBitsToDouble(getLongN(index)));
        spaceNeeded = true;
        return index + 4;
      case '': 
        spaceNeeded = false;
        sbuf.append(data[index]);
        return index + 1;
      case '': 
      case '': 
        doChildren = index + 4;
        index = nextDataIndex(index - 1);
        break;
      case '': 
        spaceNeeded = false;
        doChildren = index + 2;
        int j = getIntN(index);
        j += (j < 0 ? data.length : index - 1);
        index = j + 7;
        break;
      case '': 
        spaceNeeded = false;
        break;
      case '': 
      case '': 
      case '': 
      case '': 
      case '': 
        return -1;
      case '': 
        if (!inElement)
          doChildren = index + 4;
        int end = getIntN(index + 2);
        index = end + (end < 0 ? data.length + 1 : index);
        break;
      
      case '': 
        AbstractSequence seq = (AbstractSequence)objects[getIntN(index)];
        int ipos = getIntN(index + 2);
        ((TreeList)seq).stringValue(inElement, ipos >> 1, sbuf);
        index += 4;
        
        break;
      case '': case '': 
      case '': 
      default: 
        throw new Error("unimplemented: " + Integer.toHexString(datum) + " at:" + index);
      }
    }
    if (value != null)
      sbuf.append(value);
    if (doChildren > 0)
    {
      do
      {
        doChildren = stringValue(true, doChildren, sbuf);
      }
      while (doChildren >= 0);
    }
    return index;
  }
  
  public int createRelativePos(int istart, int offset, boolean isAfter)
  {
    if (isAfter)
    {
      if (offset == 0)
      {
        if ((istart & 0x1) != 0)
          return istart;
        if (istart == 0)
          return 1;
      }
      offset--;
    }
    if (offset < 0)
      throw unsupported("backwards createRelativePos");
    int pos = posToDataIndex(istart);
    do { offset--; if (offset < 0)
        break;
      pos = nextDataIndex(pos);
    } while (pos >= 0);
    throw new IndexOutOfBoundsException();
    
    if (pos >= gapEnd)
      pos -= gapEnd - gapStart;
    return isAfter ? pos + 1 << 1 | 0x1 : pos << 1;
  }
  

  public final int nextNodeIndex(int pos, int limit)
  {
    if ((limit | 0x80000000) == -1) {
      limit = data.length;
    }
    for (;;) {
      if (pos == gapStart)
        pos = gapEnd;
      if (pos >= limit)
        return pos;
      char datum = data[pos];
      if ((datum <= 40959) || ((datum >= 57344) && (datum <= 61439)) || ((datum >= 45056) && (datum <= 57343)) || ((datum & 0xFF00) == 61440))
      {





        pos++;
      }
      else {
        if ((datum >= 40960) && (datum <= 45055))
        {
          return pos; }
        switch (datum)
        {
        case '': 
          pos += 3;
          break;
        case '': 
          pos++;
          break;
        case '': 
        case '': 
        case '': 
        case '': 
        case '': 
          return pos;
        case '': 
          pos += 5;
          break;
        case '': 
        case '': 
        case '': 
        case '': 
        case '': 
          return pos;
        case '': case '': case '': 
        case '': default: 
          pos = nextDataIndex(pos);
        }
        
      }
    }
  }
  
  public int nextMatching(int startPos, ItemPredicate predicate, int endPos, boolean descend)
  {
    int start = posToDataIndex(startPos);
    int limit = posToDataIndex(endPos);
    int pos = start;
    if ((predicate instanceof NodePredicate))
      pos = nextNodeIndex(pos, limit);
    boolean checkAttribute = false;
    boolean checkText;
    boolean checkNode;
    boolean checkElement;
    boolean checkText; if ((predicate instanceof ElementPredicate))
    {
      boolean checkNode = true;
      boolean checkElement = true;
      checkText = false;
    } else { boolean checkText;
      if ((predicate instanceof AttributePredicate))
      {
        boolean checkNode = true;
        boolean checkElement = false;
        checkText = false;
      }
      else
      {
        checkNode = true;
        checkElement = true;
        checkText = true;
      } }
    int next;
    for (;; pos = next)
    {
      if (pos == gapStart)
        pos = gapEnd;
      if ((pos >= limit) && (limit != -1)) {
        return 0;
      }
      char datum = data[pos];
      int next; if ((datum <= 40959) || ((datum >= 57344) && (datum <= 61439)) || ((datum >= 45056) && (datum <= 57343)))
      {




        if ((checkText) && (predicate.isInstancePos(this, pos << 1)))
        {
          if (pos >= gapEnd)
            pos -= gapEnd - gapStart;
          return pos << 1;
        }
        next = pos + 1; } else { int next;
        int next;
        int next;
        switch (datum)
        {
        case '': 
          next = pos + 3;
          break;
        case '': 
          next = pos + 5;
          if (!checkNode)
            continue;
          break;
        case '':  next = pos + 5;
          break;
        case '': 
        case '': 
        case '': 
        case '': 
          next = pos + 3;
          if (!checkText)
            continue;
          break;
        case '':  next = pos + 2;
          break;
        case '': 
          if (!descend)
            return 0;
          next = pos + 2;
          break;
        case '': 
          next = pos + 5;
          if (!checkText)
            continue;
          break;
        case '':  if (!descend)
            return 0;
          next = pos + 7;
          break;
        case '': 
        case '': 
          if (!descend) {
            return 0;
          }
        case '': 
          next = pos + 1;
          break;
        case '': 
          if (checkNode)
          {
            int j = getIntN(pos + 3);
            next = j + 1 + (j < 0 ? data.length : pos);
          }
          else {
            next = pos + 5; }
          if (!checkAttribute)
            continue;
          break;
        case '': case '': 
          next = pos + 1;
          if (!checkText)
            continue;
          break;
        case '':  next = pos + 1;
          break;
        case '': 
        case '': 
          next = pos + 5;
          if (!checkText)
            continue;
          break;
        case '':  next = pos + 5 + getIntN(pos + 3);
          if (!checkNode)
            continue;
          break;
        case '':  next = pos + 3 + getIntN(pos + 1);
          if (!checkNode)
            continue;
          break;
        case '':  next = pos + 3 + getIntN(pos + 1);
          if (!checkText)
            continue;
          break;
        case '':  if (descend) {
            next = pos + 3;
          }
          else {
            int j = getIntN(pos + 1);
            next = j + (j < 0 ? data.length : pos) + 7;
          }
          if (!checkElement)
            continue;
          break; }
        if ((datum >= 40960) && (datum <= 45055))
        {
          int next;
          if (descend) {
            next = pos + 3;
          } else
            next = pos + data[(pos + 1)] + 2;
          if (!checkElement)
            continue;
        } else {
          throw new Error("unknown code:" + datum);
        }
        
        if ((pos > start) && (predicate.isInstancePos(this, pos << 1)))
        {
          if (pos >= gapEnd)
            pos -= gapEnd - gapStart;
          return pos << 1;
        }
      }
    }
  }
  
  public int nextPos(int position) {
    int index = posToDataIndex(position);
    if (index == data.length)
      return 0;
    if (index >= gapEnd)
      index -= gapEnd - gapStart;
    return (index << 1) + 3;
  }
  
  public final int nextDataIndex(int pos)
  {
    if (pos == gapStart)
      pos = gapEnd;
    if (pos == data.length) {
      return -1;
    }
    char datum = data[(pos++)];
    if ((datum <= 40959) || ((datum >= 57344) && (datum <= 61439)) || ((datum >= 45056) && (datum <= 57343)))
    {



      return pos; }
    if ((datum >= 40960) && (datum <= 45055))
    {
      return data[pos] + pos + 1; }
    int j; switch (datum)
    {
    case '': 
      j = getIntN(pos);
      j += (j < 0 ? data.length : pos - 1);
      return j + 1;
    case '': 
      j = pos + 4;
      for (;;)
      {
        if (j == gapStart)
          j = gapEnd;
        if (j == data.length)
          return -1;
        if (data[j] == 61715)
          return j + 1;
        j = nextDataIndex(j);
      }
    case '': 
    case '': 
    case '': 
      return pos;
    case '': 
      return pos + 1;
    case '': 
    case '': 
    case '': 
    case '': 
      return pos + 2;
    case '': 
      return pos + 4;
    case '': 
    case '': 
    case '': 
    case '': 
    case '': 
      return -1;
    case '': 
      j = getIntN(pos);
      j += (j < 0 ? data.length : pos - 1);
      return j + 7;
    case '': 
      j = getIntN(pos + 2);
      j += (j < 0 ? data.length : pos - 1);
      return j + 1;
    case '': 
    case '': 
      return pos + 4;
    case '': 
      pos += 2;
    
    case '': 
    case '': 
      return pos + 2 + getIntN(pos);
    }
    throw new Error("unknown code:" + Integer.toHexString(datum));
  }
  

  public Object documentUriOfPos(int pos)
  {
    int index = posToDataIndex(pos);
    if (index == data.length)
      return null;
    if (data[index] == 61712)
    {
      int next = index + 5;
      if (next == gapStart)
        next = gapEnd;
      if ((next < data.length) && (data[next] == 61720))
        return objects[getIntN(next + 1)];
    }
    return null;
  }
  






  public int compare(int ipos1, int ipos2)
  {
    int i1 = posToDataIndex(ipos1);
    int i2 = posToDataIndex(ipos2);
    return i1 > i2 ? 1 : i1 < i2 ? -1 : 0;
  }
  
  protected int getIndexDifference(int ipos1, int ipos0)
  {
    int i0 = posToDataIndex(ipos0);
    int i1 = posToDataIndex(ipos1);
    boolean negate = false;
    if (i0 > i1)
    {
      negate = true;
      int i = i1;i1 = i0;i0 = i;
    }
    int i = 0;
    while (i0 < i1)
    {
      i0 = nextDataIndex(i0);
      i++;
    }
    return negate ? -i : i;
  }
  
  public int nextIndex(int ipos)
  {
    return getIndexDifference(ipos, startPos());
  }
  

  public int hashCode()
  {
    return System.identityHashCode(this);
  }
  
  public void consume(Consumer out)
  {
    consumeIRange(0, data.length, out);
  }
  
  public void statistics()
  {
    PrintWriter out = new PrintWriter(System.out);
    statistics(out);
    out.flush();
  }
  
  public void statistics(PrintWriter out)
  {
    out.print("data array length: ");out.println(data.length);
    out.print("data array gap: ");out.println(gapEnd - gapStart);
    out.print("object array length: ");out.println(objects.length);
  }
  

  public void dump()
  {
    PrintWriter out = new PrintWriter(System.out);
    
    dump(out);
    out.flush();
  }
  
  public void dump(PrintWriter out)
  {
    out.println(getClass().getName() + " @" + Integer.toHexString(System.identityHashCode(this)) + " gapStart:" + gapStart + " gapEnd:" + gapEnd + " length:" + data.length);
    
    dump(out, 0, data.length);
  }
  
  public void dump(PrintWriter out, int start, int limit)
  {
    int toskip = 0;
    
    boolean skipFollowingWords = true;
    for (int i = start; i < limit; i++)
    {

      if ((i < gapStart) || (i >= gapEnd))
      {

        int ch = data[i];
        out.print("" + i + ": 0x" + Integer.toHexString(ch) + '=' + (short)ch);
        toskip--; if (toskip < 0)
        {
          if (ch <= 40959)
          {
            if ((ch >= 32) && (ch < 127)) {
              out.print("='" + (char)ch + "'");
            } else if (ch == 10) {
              out.print("='\\n'");
            } else {
              out.print("='\\u" + Integer.toHexString(ch) + "'");
            }
          } else if ((ch >= 57344) && (ch <= 61439))
          {

            ch -= 57344;
            Object obj = objects[ch];
            out.print("=Object#");
            out.print(ch);
            out.print('=');
            out.print(obj);
            if (obj != null) {
              out.print(':');
              out.print(obj.getClass().getName());
            }
            out.print('@');
            out.print(Integer.toHexString(System.identityHashCode(obj)));
          }
          else if ((ch >= 40960) && (ch <= 45055))
          {

            ch -= 40960;
            int j = data[(i + 1)] + i;
            out.print("=BEGIN_ELEMENT_SHORT end:" + j + " index#" + ch + "=<" + objects[ch] + '>');
            toskip = 2;
          }
          else if ((ch >= 45056) && (ch <= 57343))
          {

            out.print("= INT_SHORT:" + (ch - 49152));
          } else {
            int j;
            long l;
            switch (ch)
            {
            case 61698: 
              j = getIntN(i + 1);
              out.print("=INT_FOLLOWS value:" + j);
              toskip = 2;
              break;
            case 61699: 
              l = getLongN(i + 1);
              out.print("=LONG_FOLLOWS value:" + l);
              toskip = 4;
              break;
            case 61700: 
              j = getIntN(i + 1);
              out.write("=FLOAT_FOLLOWS value:" + Float.intBitsToFloat(j));
              
              toskip = 2;
              break;
            case 61701: 
              l = getLongN(i + 1);
              out.print("=DOUBLE_FOLLOWS value:" + Double.longBitsToDouble(l));
              
              toskip = 4;
              break;
            case 61712: 
              j = getIntN(i + 1);
              j += (j < 0 ? data.length : i);
              out.print("=BEGIN_DOCUMENT end:");
              out.print(j);
              out.print(" parent:");
              j = getIntN(i + 3);
              out.print(j);
              toskip = 4;
              break;
            case 61714: 
              j = getIntN(i + 1);
              out.print("=BEGIN_ENTITY base:");
              out.print(j);
              out.print(" parent:");
              j = getIntN(i + 3);
              out.print(j);
              toskip = 4;
              break;
            case 61715: 
              out.print("=END_ENTITY");
              break;
            case 61720: 
              out.print("=DOCUMENT_URI: ");
              j = getIntN(i + 1);
              out.print(objects[j]);
              toskip = 2;
              break;
            case 61719: 
              out.print("=COMMENT: '");
              j = getIntN(i + 1);
              out.write(data, i + 3, j);
              out.print('\'');
              toskip = 2 + j;
              break;
            case 61717: 
              out.print("=CDATA: '");
              j = getIntN(i + 1);
              out.write(data, i + 3, j);
              out.print('\'');
              toskip = 2 + j;
              break;
            case 61716: 
              out.print("=PROCESSING_INSTRUCTION: ");
              j = getIntN(i + 1);
              out.print(objects[j]);
              out.print(" '");
              j = getIntN(i + 3);
              out.write(data, i + 5, j);
              out.print('\'');
              toskip = 4 + j;
              break;
            case 61713: 
              out.print("=END_DOCUMENT");
              break;
            case 61696:  out.print("= false"); break;
            case 61697:  out.print("= true"); break;
            case 61718:  out.print("= joiner"); break;
            case 61702: 
              out.print("=CHAR_FOLLOWS");toskip = 1; break;
            case 61709: 
            case 61710: 
              toskip = 2; break;
            case 61707: 
              out.print("=END_ELEMENT_SHORT begin:");
              j = i - data[(i + 1)];
              out.print(j);
              j = data[j] - 40960;
              out.print(" -> #");
              out.print(j);
              out.print("=<");
              out.print(objects[j]);
              out.print('>');
              toskip = 1; break;
            case 61704: 
              j = getIntN(i + 1);
              j += (j < 0 ? data.length : i);
              out.print("=BEGIN_ELEMENT_LONG end:");
              out.print(j);
              j = getIntN(j + 1);
              out.print(" -> #");
              out.print(j);
              if ((j >= 0) && (j + 1 < objects.length)) {
                out.print("=<" + objects[j] + '>');
              } else
                out.print("=<out-of-bounds>");
              toskip = 2;
              break;
            case 61708: 
              j = getIntN(i + 1);
              out.print("=END_ELEMENT_LONG name:" + j + "=<" + objects[j] + '>');
              
              j = getIntN(i + 3);
              j = j < 0 ? i + j : j;
              out.print(" begin:" + j);
              j = getIntN(i + 5);
              j = j < 0 ? i + j : j;
              out.print(" parent:" + j);
              toskip = 6;
              break;
            case 61705: 
              j = getIntN(i + 1);
              out.print("=BEGIN_ATTRIBUTE name:" + j + "=" + objects[j]);
              
              j = getIntN(i + 3);
              j += (j < 0 ? data.length : i);
              out.print(" end:" + j);
              toskip = 4;
              break;
            case 61706:  out.print("=END_ATTRIBUTE"); break;
            case 61711: 
              out.print("=POSITION_PAIR_FOLLOWS seq:");
              
              j = getIntN(i + 1);out.print(j);
              out.print('=');
              Object seq = objects[j];
              out.print(seq == null ? null : seq.getClass().getName());
              out.print('@');
              if (seq == null) out.print("null"); else
                out.print(Integer.toHexString(System.identityHashCode(seq)));
              out.print(" ipos:");
              out.print(getIntN(i + 3));
              
              toskip = 4;
            }
            
          }
        }
        



        out.println();
        if ((skipFollowingWords) && (toskip > 0))
        {
          i += toskip;
          toskip = 0;
        }
      }
    }
  }
}
