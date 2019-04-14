package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;


public class KElement
  extends KNode
  implements Element
{
  public KElement(NodeTree seq, int ipos)
  {
    super(seq, ipos);
  }
  
  public short getNodeType() {
    return 1;
  }
  
  public String getTagName()
  {
    return ((NodeTree)sequence).getNextTypeName(ipos);
  }
  
  public String getNodeValue()
  {
    return null;
  }
  
  public boolean hasAttributes()
  {
    return ((NodeTree)sequence).posHasAttributes(ipos);
  }
  
  public String getAttribute(String name)
  {
    if (name == null)
      name = "";
    NodeTree nodes = (NodeTree)sequence;
    int attr = nodes.getAttribute(ipos, null, name);
    if (attr == 0) {
      return "";
    }
    return KNode.getNodeValue(nodes, attr);
  }
  


  public void setAttribute(String name, String value)
    throws DOMException
  {
    throw new DOMException((short)7, "setAttribute not supported");
  }
  


  public void setIdAttribute(String name, boolean isId)
    throws DOMException
  {
    throw new DOMException((short)7, "setIdAttribute not supported");
  }
  



  public void setIdAttributeNS(String namespaceURI, String localName, boolean isId)
    throws DOMException
  {
    throw new DOMException((short)7, "setIdAttributeNS not supported");
  }
  


  public void setIdAttributeNode(Attr idAttr, boolean isId)
    throws DOMException
  {
    throw new DOMException((short)7, "setIdAttributeNode not supported");
  }
  


  public void removeAttribute(String name)
    throws DOMException
  {
    throw new DOMException((short)7, "removeAttribute not supported");
  }
  











  public KAttr getAttributeNode(String name)
  {
    if (name == null)
      name = "";
    NodeTree nodes = (NodeTree)sequence;
    int attr = nodes.getAttribute(ipos, null, name);
    if (attr == 0) {
      return null;
    }
    return new KAttr(nodes, attr);
  }
  


  public Attr setAttributeNode(Attr newAttr)
    throws DOMException
  {
    throw new DOMException((short)7, "setAttributeNode not supported");
  }
  


  public Attr removeAttributeNode(Attr oldAttr)
    throws DOMException
  {
    throw new DOMException((short)7, "removeAttributeNode not supported");
  }
  


  public String getAttributeNS(String namespaceURI, String localName)
  {
    if (namespaceURI == null)
      namespaceURI = "";
    if (localName == null)
      localName = "";
    NodeTree nodes = (NodeTree)sequence;
    int attr = nodes.getAttribute(ipos, namespaceURI, localName);
    if (attr == 0) {
      return "";
    }
    return getNodeValue(nodes, attr);
  }
  


  public void setAttributeNS(String namespaceURI, String qualifiedName, String value)
    throws DOMException
  {
    throw new DOMException((short)7, "setAttributeNS not supported");
  }
  




  public void removeAttributeNS(String namespaceURI, String localName)
    throws DOMException
  {
    throw new DOMException((short)7, "removeAttributeNS not supported");
  }
  











  public KAttr getAttributeNodeNS(String namespaceURI, String localName)
  {
    if (namespaceURI == null)
      namespaceURI = "";
    if (localName == null)
      localName = "";
    NodeTree nodes = (NodeTree)sequence;
    int attr = nodes.getAttribute(ipos, namespaceURI, localName);
    if (attr == 0) {
      return null;
    }
    return new KAttr(nodes, attr);
  }
  


  public Attr setAttributeNodeNS(Attr newAttr)
    throws DOMException
  {
    throw new DOMException((short)7, "setAttributeNodeNS not supported");
  }
  




  public NodeList getElementsByTagNameNS(String namespaceURI, String localName)
  {
    throw new UnsupportedOperationException("getElementsByTagNameNS not implemented yet");
  }
  


  public boolean hasAttribute(String name)
  {
    int attr = ((NodeTree)sequence).getAttribute(ipos, null, name == null ? "" : name);
    return attr != 0;
  }
  
  public boolean hasAttributeNS(String namespaceURI, String localName)
  {
    if (namespaceURI == null)
      namespaceURI = "";
    if (localName == null)
      localName = "";
    int attr = ((NodeTree)sequence).getAttribute(ipos, namespaceURI, localName);
    return attr != 0;
  }
  

  public TypeInfo getSchemaTypeInfo()
  {
    return null;
  }
}
