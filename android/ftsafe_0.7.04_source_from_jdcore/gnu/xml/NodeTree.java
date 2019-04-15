package gnu.xml;

import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.URIPath;
import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.lists.TreeList;
import gnu.mapping.Symbol;

public class NodeTree extends TreeList
{
  static int counter;
  int id;
  String[] idNames;
  int[] idOffsets;
  int idCount;
  
  public NodeTree() {}
  
  public int nextPos(int position)
  {
    boolean isAfter = (position & 0x1) != 0;
    int index = posToDataIndex(position);
    int next = nextNodeIndex(index, Integer.MAX_VALUE);
    if (next != index)
      return next << 1;
    if (index == data.length)
      return 0;
    return (index << 1) + 3;
  }
  
  public static NodeTree make()
  {
    return new NodeTree();
  }
  




  public int getId()
  {
    if (id == 0)
      id = (++counter);
    return id;
  }
  
  public int stableCompare(AbstractSequence other)
  {
    if (this == other) {
      return 0;
    }
    



    int comp = super.stableCompare(other);
    if ((comp == 0) && ((other instanceof NodeTree)))
    {
      int id1 = getId();
      int id2 = ((NodeTree)other).getId();
      comp = id1 > id2 ? 1 : id1 < id2 ? -1 : 0;
    }
    return comp;
  }
  
  public gnu.lists.SeqPosition getIteratorAtPos(int ipos)
  {
    return KNode.make(this, ipos);
  }
  
  public String posNamespaceURI(int ipos)
  {
    Object type = getNextTypeObject(ipos);
    if ((type instanceof XName))
      return ((XName)type).getNamespaceURI();
    if ((type instanceof Symbol))
      return ((Symbol)type).getNamespaceURI();
    return null;
  }
  
  public String posPrefix(int ipos)
  {
    String name = getNextTypeName(ipos);
    if (name == null)
      return null;
    int colon = name.indexOf(':');
    return colon < 0 ? null : name.substring(0, colon);
  }
  
  public String posLocalName(int ipos)
  {
    Object type = getNextTypeObject(ipos);
    if ((type instanceof XName))
      return ((XName)type).getLocalPart();
    if ((type instanceof Symbol))
      return ((Symbol)type).getLocalName();
    return getNextTypeName(ipos);
  }
  
  public boolean posIsDefaultNamespace(int ipos, String namespaceURI)
  {
    throw new Error("posIsDefaultNamespace not implemented");
  }
  
  public String posLookupNamespaceURI(int ipos, String prefix)
  {
    int kind = getNextKind(ipos);
    if (kind != 33)
      throw new IllegalArgumentException("argument must be an element");
    Object type = getNextTypeObject(ipos);
    if ((type instanceof XName)) {
      return ((XName)type).lookupNamespaceURI(prefix);
    }
    return null;
  }
  
  public String posLookupPrefix(int ipos, String namespaceURI)
  {
    throw new Error("posLookupPrefix not implemented");
  }
  
  public int posFirstChild(int ipos)
  {
    int index = gotoChildrenStart(posToDataIndex(ipos));
    if (index < 0)
      return -1;
    char datum = data[index];
    if ((datum == 61707) || (datum == 61708) || (datum == 61713))
    {
      return -1; }
    return index << 1;
  }
  
  public boolean posHasAttributes(int ipos)
  {
    int index = gotoAttributesStart(posToDataIndex(ipos));
    if (index < 0)
      return false;
    return (index >= 0) && (data[index] == 61705);
  }
  







  public int getAttribute(int parent, String namespaceURI, String localName)
  {
    return getAttributeI(parent, namespaceURI == null ? null : namespaceURI.intern(), localName == null ? null : localName.intern());
  }
  







  public int getAttributeI(int parent, String namespaceURI, String localName)
  {
    int attr = firstAttributePos(parent);
    for (;;)
    {
      if ((attr == 0) || (getNextKind(attr) != 35))
        return 0;
      if (((localName == null) || (posLocalName(attr) == localName)) && ((namespaceURI == null) || (posNamespaceURI(attr) == namespaceURI)))
      {
        return attr; }
      attr = nextPos(attr);
    }
  }
  


  public Object typedValue(int ipos)
  {
    StringBuffer sbuf = new StringBuffer();
    stringValue(posToDataIndex(ipos), sbuf);
    String str = sbuf.toString();
    int kind = getNextKind(ipos);
    if ((kind == 37) || (kind == 36))
    {
      return str; }
    return new gnu.kawa.xml.UntypedAtomic(str);
  }
  

  public String posTarget(int ipos)
  {
    int index = posToDataIndex(ipos);
    if (data[index] != 61716)
      throw new ClassCastException("expected process-instruction");
    return (String)objects[getIntN(index + 1)];
  }
  






  public int ancestorAttribute(int ipos, String namespace, String name)
  {
    for (;;)
    {
      if (ipos == -1)
        return 0;
      int attr = getAttributeI(ipos, namespace, name);
      if (attr != 0)
        return attr;
      ipos = parentPos(ipos);
    }
  }
  

  public Path baseUriOfPos(int pos, boolean resolveRelative)
  {
    Path uri = null;
    int index = posToDataIndex(pos);
    for (;;)
    {
      if (index == data.length)
        return null;
      char datum = data[index];
      Path base = null;
      if (datum == 61714)
      {
        int oindex = getIntN(index + 1);
        if (oindex >= 0) {
          base = URIPath.makeURI(objects[oindex]);
        }
      } else if (((datum >= 40960) && (datum <= 45055)) || (datum == 61704))
      {


        int attr = getAttributeI(pos, "http://www.w3.org/XML/1998/namespace", "base");
        if (attr != 0)
          base = URIPath.valueOf(KNode.getNodeValue(this, attr));
      }
      if (base != null)
      {
        uri = (uri == null) || (!resolveRelative) ? base : base.resolve(uri);
        if ((uri.isAbsolute()) || (!resolveRelative))
          return uri;
      }
      index = parentOrEntityI(index);
      if (index == -1)
        return uri;
      pos = index << 1;
    }
  }
  
  public String toString()
  {
    CharArrayOutPort wr = new CharArrayOutPort();
    XMLPrinter xp = new XMLPrinter(wr);
    consume(xp);
    wr.close();
    return wr.toString();
  }
  









  public void makeIDtableIfNeeded()
  {
    if (idNames != null) {
      return;
    }
    
    int size = 64;
    idNames = new String[size];
    idOffsets = new int[size];
    int limit = endPos();
    int ipos = 0;
    for (;;)
    {
      ipos = nextMatching(ipos, gnu.kawa.xml.ElementType.anyElement, limit, true);
      if (ipos == 0) {
        break;
      }
      
      int attr = getAttributeI(ipos, "http://www.w3.org/XML/1998/namespace", "id");
      if (attr != 0)
      {
        enterID(KNode.getNodeValue(this, attr), ipos);
      }
    }
  }
  

  void enterID(String name, int offset)
  {
    String[] tmpNames = idNames;
    int[] tmpOffsets = idOffsets;
    int size; if (tmpNames == null)
    {
      int size = 64;
      idNames = new String[size];
      idOffsets = new int[size];
    }
    else if (4 * idCount >= 3 * (size = idNames.length))
    {
      idNames = new String[2 * size];
      idOffsets = new int[2 * size];
      idCount = 0;
      int i = size; for (;;) { i--; if (i < 0)
          break;
        String oldName = tmpNames[i];
        if (oldName != null)
          enterID(oldName, tmpOffsets[i]);
      }
      tmpNames = idNames;
      tmpOffsets = idOffsets;
      size = 2 * size;
    }
    int hash = name.hashCode();
    int mask = size - 1;
    int index = hash & mask;
    
    int step = (hash ^ 0xFFFFFFFF) << 1 | 0x1;
    for (;;)
    {
      String oldName = tmpNames[index];
      if (oldName == null)
      {
        tmpNames[index] = name;
        tmpOffsets[index] = offset;
        break;
      }
      if (oldName.equals(name))
      {

        return;
      }
      index = index + step & mask;
    }
    idCount += 1;
  }
  






  public int lookupID(String name)
  {
    String[] tmpNames = idNames;
    int[] tmpOffsets = idOffsets;
    int size = idNames.length;
    int hash = name.hashCode();
    int mask = size - 1;
    int index = hash & mask;
    
    int step = (hash ^ 0xFFFFFFFF) << 1 | 0x1;
    for (;;)
    {
      String oldName = tmpNames[index];
      if (oldName == null)
        return -1;
      if (oldName.equals(name))
      {
        return tmpOffsets[index];
      }
      index = index + step & mask;
    }
  }
}
