package gnu.kawa.xml;

import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.Path;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.xml.NodeTree;
import gnu.xml.XMLPrinter;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

public abstract class KNode extends SeqPosition<Object, NodeTree> implements Node, Consumable
{
  public KNode(NodeTree seq, int ipos)
  {
    super(seq, ipos);
  }
  
  public static Object atomicValue(Object value)
  {
    if ((value instanceof KNode))
    {
      KNode node = (KNode)value;
      return ((NodeTree)sequence).typedValue(ipos);
    }
    return value;
  }
  

  public static KNode coerce(Object value)
  {
    if ((value instanceof KNode))
      return (KNode)value;
    if ((value instanceof NodeTree))
    {
      NodeTree ntree = (NodeTree)value;
      return make(ntree, ntree.startPos());
    }
    if (((value instanceof SeqPosition)) && (!(value instanceof gnu.lists.TreePosition)))
    {

      SeqPosition seqp = (SeqPosition)value;
      if ((sequence instanceof NodeTree))
        return make((NodeTree)sequence, ipos);
    }
    return null;
  }
  
  public static KNode make(NodeTree seq, int ipos)
  {
    int index = seq.posToDataIndex(ipos);
    
    while ((index < data.length) && (data[index] == 61714))
    {
      index += 5;
      if (index == gapStart)
        index = gapEnd;
    }
    ipos = index << 1;
    int kind = seq.getNextKindI(index);
    switch (kind)
    {
    case 33: 
      return new KElement(seq, ipos);
    case 35: 
      return new KAttr(seq, ipos);
    case 34: 
      return new KDocument(seq, ipos);
    case 31: 
      return new KCDATASection(seq, ipos);
    case 36: 
      return new KComment(seq, ipos);
    case 37: 
      return new KProcessingInstruction(seq, ipos);
    case 0: 
      if (!seq.isEmpty())
        return null;
      break;
    }
    return new KText(seq, ipos);
  }
  


  public KNode copy()
  {
    return make((NodeTree)sequence, ((NodeTree)sequence).copyPos(getPos()));
  }
  






  public static KNode make(NodeTree seq)
  {
    return make(seq, 0);
  }
  
  public boolean isSupported(String feature, String version)
  {
    return false;
  }
  

  public abstract short getNodeType();
  

  public String getNodeName()
  {
    return ((NodeTree)sequence).getNextTypeName(ipos);
  }
  



  public Symbol getNodeSymbol()
  {
    Object type = ((NodeTree)sequence).getNextTypeObject(ipos);
    if (type == null)
      return null;
    if ((type instanceof Symbol))
      return (Symbol)type;
    return Namespace.EmptyNamespace.getSymbol(type.toString().intern());
  }
  


  public Object getNodeNameObject()
  {
    return ((NodeTree)sequence).getNextTypeObject(ipos);
  }
  
  public String getNamespaceURI()
  {
    return ((NodeTree)sequence).posNamespaceURI(ipos);
  }
  
  public String getPrefix()
  {
    return ((NodeTree)sequence).posPrefix(ipos);
  }
  
  public String getLocalName()
  {
    return ((NodeTree)sequence).posLocalName(ipos);
  }
  
  public static String getNodeValue(NodeTree seq, int ipos)
  {
    StringBuffer sbuf = new StringBuffer();
    getNodeValue(seq, ipos, sbuf);
    return sbuf.toString();
  }
  
  public static void getNodeValue(NodeTree seq, int ipos, StringBuffer sbuf)
  {
    seq.stringValue(seq.posToDataIndex(ipos), sbuf);
  }
  
  public String getNodeValue()
  {
    StringBuffer sbuf = new StringBuffer();
    getNodeValue(sbuf);
    return sbuf.toString();
  }
  
  public void getNodeValue(StringBuffer sbuf)
  {
    getNodeValue((NodeTree)sequence, ipos, sbuf);
  }
  
  public boolean hasChildNodes()
  {
    return ((NodeTree)sequence).posFirstChild(ipos) >= 0;
  }
  
  public String getTextContent()
  {
    StringBuffer sbuf = new StringBuffer();
    getTextContent(sbuf);
    return sbuf.toString();
  }
  

  protected void getTextContent(StringBuffer sbuf)
  {
    getNodeValue(sbuf);
  }
  

  public Node getParentNode()
  {
    int parent = ((NodeTree)sequence).parentPos(ipos);
    if (parent == -1)
      return null;
    return make((NodeTree)sequence, parent);
  }
  
  public Node getPreviousSibling()
  {
    int parent = ((NodeTree)sequence).parentPos(ipos);
    if (parent == -1)
      parent = 0;
    int index = ((NodeTree)sequence).posToDataIndex(ipos);
    int child = ((NodeTree)sequence).firstChildPos(parent);
    int previous = 0;
    for (;;)
    {
      previous = child;
      child = ((NodeTree)sequence).nextPos(child);
      if (child != 0)
      {
        if (((NodeTree)sequence).posToDataIndex(child) == index)
          break; }
    }
    return previous == 0 ? null : make((NodeTree)sequence, previous);
  }
  



  public Node getNextSibling()
  {
    int next = ((NodeTree)sequence).nextPos(ipos);
    return next == 0 ? null : make((NodeTree)sequence, next);
  }
  

  public Node getFirstChild()
  {
    int child = ((NodeTree)sequence).posFirstChild(ipos);
    return make((NodeTree)sequence, child);
  }
  
  public Node getLastChild()
  {
    int last = 0;
    int child = ((NodeTree)sequence).firstChildPos(ipos);
    while (child != 0)
    {
      last = child;
      child = ((NodeTree)sequence).nextPos(child);
    }
    return last == 0 ? null : make((NodeTree)sequence, last);
  }
  
  public NodeList getChildNodes()
  {
    Nodes nodes = new SortedNodes();
    int child = ((NodeTree)sequence).firstChildPos(ipos);
    while (child != 0)
    {
      nodes.writePosition(sequence, child);
      child = ((NodeTree)sequence).nextPos(child);
    }
    return nodes;
  }
  

  public NodeList getElementsByTagName(String tagname)
  {
    throw new UnsupportedOperationException("getElementsByTagName not implemented yet");
  }
  













  public void setNodeValue(String nodeValue)
    throws DOMException
  {
    throw new DOMException((short)7, "setNodeValue not supported");
  }
  

  public void setPrefix(String prefix)
    throws DOMException
  {
    throw new DOMException((short)7, "setPrefix not supported");
  }
  


  public Node insertBefore(Node newChild, Node refChild)
    throws DOMException
  {
    throw new DOMException((short)7, "insertBefore not supported");
  }
  


  public Node replaceChild(Node newChild, Node oldChild)
    throws DOMException
  {
    throw new DOMException((short)7, "replaceChild not supported");
  }
  


  public Node removeChild(Node oldChild)
    throws DOMException
  {
    throw new DOMException((short)7, "removeChild not supported");
  }
  


  public Node appendChild(Node newChild)
    throws DOMException
  {
    throw new DOMException((short)7, "appendChild not supported");
  }
  


  public void setTextContent(String textContent)
    throws DOMException
  {
    throw new DOMException((short)7, "setTextContent not supported");
  }
  


  public Node cloneNode(boolean deep)
  {
    if (!deep)
      throw new UnsupportedOperationException("shallow cloneNode not implemented");
    NodeTree tree = new NodeTree();
    ((NodeTree)sequence).consumeNext(ipos, tree);
    return make(tree);
  }
  
  public Document getOwnerDocument()
  {
    int kind = ((NodeTree)sequence).getNextKind(ipos);
    if (kind == 34)
      return new KDocument((NodeTree)sequence, 0);
    return null;
  }
  
  public org.w3c.dom.NamedNodeMap getAttributes()
  {
    throw new UnsupportedOperationException("getAttributes not implemented yet");
  }
  


  public void normalize() {}
  

  public boolean hasAttributes()
  {
    return false;
  }
  
  public boolean isDefaultNamespace(String namespaceURI)
  {
    return ((NodeTree)sequence).posIsDefaultNamespace(ipos, namespaceURI);
  }
  
  public String lookupNamespaceURI(String prefix)
  {
    return ((NodeTree)sequence).posLookupNamespaceURI(ipos, prefix);
  }
  
  public String lookupPrefix(String namespaceURI)
  {
    return ((NodeTree)sequence).posLookupPrefix(ipos, namespaceURI);
  }
  
  public String getBaseURI()
  {
    Object uri = ((NodeTree)sequence).baseUriOfPos(ipos, true);
    return uri == null ? null : uri.toString();
  }
  
  public Path baseURI()
  {
    return ((NodeTree)sequence).baseUriOfPos(ipos, true);
  }
  

  public short compareDocumentPosition(Node other)
    throws DOMException
  {
    if (!(other instanceof KNode)) {
      throw new DOMException((short)9, "other Node is a " + other.getClass().getName());
    }
    KNode n = (KNode)other;
    AbstractSequence nseq = sequence;
    return (short)(sequence == nseq ? nseq.compare(ipos, ipos) : ((NodeTree)sequence).stableCompare(nseq));
  }
  

  public boolean isSameNode(Node node)
  {
    if (!(node instanceof KNode))
      return false;
    KNode n = (KNode)node;
    if (sequence != sequence)
      return false;
    return ((NodeTree)sequence).equals(ipos, ipos);
  }
  
  public boolean isEqualNode(Node node)
  {
    throw new UnsupportedOperationException("getAttributesisEqualNode not implemented yet");
  }
  

  public String toString()
  {
    CharArrayOutPort wr = new CharArrayOutPort();
    XMLPrinter xp = XMLPrinter.make(wr, "xhtml");
    ((NodeTree)sequence).consumeNext(ipos, xp);
    xp.close();
    wr.close();
    return wr.toString();
  }
  
  public Object getFeature(String feature, String version)
  {
    return null;
  }
  
  public void consume(Consumer out)
  {
    if ((out instanceof PositionConsumer)) {
      ((PositionConsumer)out).writePosition(this);
    } else {
      ((NodeTree)sequence).consumeNext(ipos, out);
    }
  }
  
  public Object setUserData(String key, Object data, UserDataHandler handler)
  {
    throw new UnsupportedOperationException("setUserData not implemented yet");
  }
  
  public Object getUserData(String key)
  {
    return null;
  }
}
