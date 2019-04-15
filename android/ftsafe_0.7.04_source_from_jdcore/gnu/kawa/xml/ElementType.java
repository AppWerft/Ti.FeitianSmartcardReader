package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.expr.Compilation;
import gnu.lists.AbstractSequence;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.xml.namespace.QName;

public class ElementType extends NodeType implements gnu.expr.TypeValue, java.io.Externalizable, gnu.lists.ElementPredicate
{
  public static final String MATCH_ANY_LOCALNAME = "";
  public static final Symbol MATCH_ANY_QNAME = Symbol.makeUninterned("", null);
  

  Symbol qname;
  
  public static final ElementType anyElement = make((String)null, (String)null);
  
  NamespaceBinding namespaceNodes;
  

  public static ElementType make(String namespaceURI, String localName)
  {
    Symbol qname;
    Symbol qname;
    if (namespaceURI != null) {
      qname = Symbol.make(namespaceURI, localName); } else { Symbol qname;
      if (localName == "") {
        qname = MATCH_ANY_QNAME;
      } else
        qname = Symbol.makeUninterned(localName, null); }
    return new ElementType(qname);
  }
  
  public static ElementType make(Symbol qname)
  {
    return new ElementType(qname);
  }
  
  public ElementType(Symbol qname)
  {
    this(null, qname);
  }
  
  public ElementType(String name, Symbol qname)
  {
    super("ELEMENT " + qname + " (*)");
    
    this.qname = qname;
  }
  
  public gnu.bytecode.Type getImplementationType()
  {
    return ClassType.make("gnu.kawa.xml.KElement");
  }
  
  public final String getNamespaceURI() { return qname.getNamespaceURI(); }
  public final String getLocalName() { return qname.getLocalName(); }
  
  public void emitCoerceFromObject(CodeAttr code)
  {
    code.emitPushString(qname.getNamespaceURI());
    code.emitPushString(qname.getLocalName());
    code.emitInvokeStatic(coerceMethod);
  }
  
  public Object coerceFromObject(Object obj)
  {
    return coerce(obj, qname.getNamespaceURI(), qname.getLocalName());
  }
  
  public boolean isInstancePos(AbstractSequence seq, int ipos)
  {
    int kind = seq.getNextKind(ipos);
    if (kind == 33)
      return isInstance(seq, ipos, seq.getNextTypeObject(ipos));
    if (kind == 32)
      return isInstance(seq.getPosNext(ipos));
    return false;
  }
  
  public boolean isInstance(AbstractSequence seq, int ipos, Object elementType)
  {
    String namespaceURI = this.qname.getNamespaceURI();
    String localName = this.qname.getLocalName();
    String curLocalName;
    String curNamespaceURI;
    String curLocalName; if ((elementType instanceof Symbol))
    {
      Symbol qname = (Symbol)elementType;
      String curNamespaceURI = qname.getNamespaceURI();
      curLocalName = qname.getLocalName();
    } else {
      String curLocalName;
      if ((elementType instanceof QName))
      {
        QName qtype = (QName)elementType;
        
        String curNamespaceURI = qtype.getNamespaceURI();
        curLocalName = qtype.getLocalPart();

      }
      else
      {
        curNamespaceURI = "";
        curLocalName = elementType.toString().intern();
      } }
    if ((localName != null) && (localName.length() == 0))
      localName = null;
    return ((localName == curLocalName) || (localName == null)) && ((namespaceURI == curNamespaceURI) || (namespaceURI == null));
  }
  

  public boolean isInstance(Object obj)
  {
    return coerceOrNull(obj, qname.getNamespaceURI(), qname.getLocalName()) != null;
  }
  


  public static KElement coerceOrNull(Object obj, String namespaceURI, String localName)
  {
    KElement pos = (KElement)NodeType.coerceOrNull(obj, 2);
    if (pos == null)
      return null;
    if ((localName != null) && (localName.length() == 0)) {
      localName = null;
    }
    
    Object curName = pos.getNextTypeObject();
    String curLocalName;
    String curNamespaceURI;
    String curLocalName; if ((curName instanceof Symbol))
    {
      Symbol qname = (Symbol)curName;
      String curNamespaceURI = qname.getNamespaceURI();
      curLocalName = qname.getLocalName();
    } else {
      String curLocalName;
      if ((curName instanceof QName))
      {
        QName qtype = (QName)curName;
        
        String curNamespaceURI = qtype.getNamespaceURI();
        curLocalName = qtype.getLocalPart();

      }
      else
      {
        curNamespaceURI = "";
        curLocalName = curName.toString().intern();
      } }
    if (((localName == curLocalName) || (localName == null)) && ((namespaceURI == curNamespaceURI) || (namespaceURI == null)))
    {
      return pos; }
    return null;
  }
  

  public static KElement coerce(Object obj, String namespaceURI, String localName)
  {
    KElement pos = coerceOrNull(obj, namespaceURI, localName);
    if (pos == null)
      throw new ClassCastException();
    return pos;
  }
  
  protected void emitCoerceOrNullMethod(gnu.bytecode.Variable incoming, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    if (incoming != null)
      code.emitLoad(incoming);
    code.emitPushString(qname.getNamespaceURI());
    code.emitPushString(qname.getLocalName());
    code.emitInvokeStatic(coerceOrNullMethod);
  }
  

  public NamespaceBinding getNamespaceNodes()
  {
    return namespaceNodes;
  }
  
  public void setNamespaceNodes(NamespaceBinding bindings)
  {
    namespaceNodes = bindings;
  }
  
  public gnu.mapping.Procedure getConstructor()
  {
    MakeElement element = new MakeElement();
    tag = qname;
    element.setHandlingKeywordParameters(true);
    if (namespaceNodes != null)
      element.setNamespaceNodes(namespaceNodes);
    return element;
  }
  
  public static final ClassType typeElementType = ClassType.make("gnu.kawa.xml.ElementType");
  
  static final gnu.bytecode.Method coerceMethod = typeElementType.getDeclaredMethod("coerce", 3);
  
  static final gnu.bytecode.Method coerceOrNullMethod = typeElementType.getDeclaredMethod("coerceOrNull", 3);
  
  public void writeExternal(ObjectOutput out)
    throws java.io.IOException
  {
    String name = getName();
    out.writeUTF(name == null ? "" : name);
    out.writeObject(qname);
  }
  
  public void readExternal(ObjectInput in)
    throws java.io.IOException, ClassNotFoundException
  {
    String name = in.readUTF();
    if (name.length() > 0)
      setName(name);
    qname = ((Symbol)in.readObject());
  }
  
  public String toString()
  {
    return "ElementType " + qname;
  }
}
