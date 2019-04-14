package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class KDocument extends KNode implements Document
{
  public KDocument(NodeTree seq, int ipos)
  {
    super(seq, ipos);
  }
  
  public String getNodeName()
  {
    return "#document";
  }
  

  public org.w3c.dom.DOMImplementation getImplementation()
  {
    throw new UnsupportedOperationException("getImplementation not implemented");
  }
  
  public org.w3c.dom.DocumentType getDoctype()
  {
    return null;
  }
  
  public Node getParentNode()
  {
    return null;
  }
  

  public KElement getDocumentElement()
  {
    int child = ((NodeTree)sequence).posFirstChild(ipos);
    for (;;)
    {
      if (child == -1)
        return null;
      if (((NodeTree)sequence).getNextKind(child) != 36)
        break;
      child = ((NodeTree)sequence).nextPos(child);
    }
    return (KElement)make((NodeTree)sequence, child);
  }
  
  public short getNodeType() {
    return 9;
  }
  
  public String getNodeValue()
  {
    return null;
  }
  
  public String getTextContent()
  {
    return null;
  }
  



  protected void getTextContent(StringBuffer sbuf) {}
  


  public Element createElement(String tagName)
  {
    throw new UnsupportedOperationException("createElement not implemented");
  }
  

  public DocumentFragment createDocumentFragment()
  {
    throw new UnsupportedOperationException("createDocumentFragment not implemented");
  }
  

  public org.w3c.dom.Text createTextNode(String data)
  {
    throw new UnsupportedOperationException("createTextNode not implemented");
  }
  

  public Comment createComment(String data)
  {
    throw new UnsupportedOperationException("createComment not implemented");
  }
  

  public CDATASection createCDATASection(String data)
  {
    throw new UnsupportedOperationException("createCDATASection not implemented");
  }
  


  public org.w3c.dom.ProcessingInstruction createProcessingInstruction(String target, String data)
  {
    throw new UnsupportedOperationException("createProcessingInstruction not implemented");
  }
  

  public Attr createAttribute(String name)
  {
    throw new UnsupportedOperationException("createAttribute not implemented");
  }
  

  public org.w3c.dom.EntityReference createEntityReference(String name)
  {
    throw new UnsupportedOperationException("createEntityReference implemented");
  }
  

  public Node importNode(Node importedNode, boolean deep)
  {
    throw new UnsupportedOperationException("importNode not implemented");
  }
  

  public Element createElementNS(String namespaceURI, String qualifiedName)
  {
    throw new UnsupportedOperationException("createElementNS not implemented");
  }
  


  public Attr createAttributeNS(String namespaceURI, String qualifiedName)
  {
    throw new UnsupportedOperationException("createAttributeNS not implemented");
  }
  

  public org.w3c.dom.NodeList getElementsByTagNameNS(String namespaceURI, String localName)
  {
    throw new UnsupportedOperationException("getElementsByTagNameNS not implemented yet");
  }
  
  public Element getElementById(String elementId)
  {
    return null;
  }
  

  public boolean hasAttributes()
  {
    return false;
  }
  
  public String getInputEncoding()
  {
    return null;
  }
  
  public String getXmlEncoding()
  {
    return null;
  }
  
  public boolean getXmlStandalone()
  {
    return false;
  }
  

  public void setXmlStandalone(boolean xmlStandalone) {}
  

  public String getXmlVersion()
  {
    return "1.1";
  }
  

  public void setXmlVersion(String xmlVersion) {}
  

  public boolean getStrictErrorChecking()
  {
    return false;
  }
  

  public void setStrictErrorChecking(boolean strictErrorChecking) {}
  

  public String getDocumentURI()
  {
    return null;
  }
  


  public void setDocumentURI(String documentURI) {}
  

  public Node renameNode(Node n, String namespaceURI, String qualifiedname)
    throws DOMException
  {
    throw new DOMException((short)9, "renameNode not implemented");
  }
  

  public Node adoptNode(Node source)
    throws DOMException
  {
    throw new DOMException((short)9, "adoptNode not implemented");
  }
  



  public void normalizeDocument() {}
  


  public DOMConfiguration getDomConfig()
  {
    throw new DOMException((short)9, "getDomConfig not implemented");
  }
}
