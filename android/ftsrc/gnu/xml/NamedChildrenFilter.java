package gnu.xml;

import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.mapping.Symbol;



public class NamedChildrenFilter
  extends FilterConsumer
{
  String namespaceURI;
  String localName;
  int level;
  int matchLevel;
  
  public static NamedChildrenFilter make(String namespaceURI, String localName, Consumer out)
  {
    return new NamedChildrenFilter(namespaceURI, localName, out);
  }
  

  public NamedChildrenFilter(String namespaceURI, String localName, Consumer out)
  {
    super(out);
    this.namespaceURI = namespaceURI;
    this.localName = localName;
    skipping = true;
  }
  
  public void startDocument()
  {
    level += 1;
    super.startDocument();
  }
  
  public void endDocument()
  {
    level -= 1;
    super.endDocument();
  }
  
  public void startElement(Object type)
  {
    if ((skipping) && (level == 1))
    {
      String curLocalName;
      
      String curNamespaceURI;
      
      String curLocalName;
      if ((type instanceof Symbol))
      {
        Symbol qname = (Symbol)type;
        String curNamespaceURI = qname.getNamespaceURI();
        curLocalName = qname.getLocalName();
      }
      else
      {
        curNamespaceURI = "";
        curLocalName = type.toString().intern();
      }
      if (((localName == curLocalName) || (localName == null)) && ((namespaceURI == curNamespaceURI) || (namespaceURI == null)))
      {

        skipping = false;
        matchLevel = level;
      }
    }
    
    super.startElement(type);
    level += 1;
  }
  
  public void endElement()
  {
    level -= 1;
    super.endElement();
    if ((!skipping) && (matchLevel == level)) {
      skipping = true;
    }
  }
  
  public void writeObject(Object val) {
    if ((val instanceof SeqPosition))
    {
      SeqPosition pos = (SeqPosition)val;
      if ((sequence instanceof TreeList))
      {
        ((TreeList)sequence).consumeNext(ipos, this);
        return;
      }
    }
    if ((val instanceof Consumable)) {
      ((Consumable)val).consume(this);
    } else {
      super.writeObject(val);
    }
  }
}
