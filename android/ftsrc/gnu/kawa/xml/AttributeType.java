package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import gnu.mapping.Symbol;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.xml.namespace.QName;

public class AttributeType extends NodeType implements gnu.expr.TypeValue, java.io.Externalizable, gnu.lists.AttributePredicate
{
  Symbol qname;
  
  public static AttributeType make(String namespaceURI, String localName)
  {
    Symbol qname;
    Symbol qname;
    if (namespaceURI != null) {
      qname = Symbol.make(namespaceURI, localName); } else { Symbol qname;
      if (localName == "") {
        qname = ElementType.MATCH_ANY_QNAME;
      } else
        qname = Symbol.makeUninterned(localName, null); }
    return new AttributeType(qname);
  }
  
  public static AttributeType make(Symbol qname)
  {
    return new AttributeType(qname);
  }
  
  public AttributeType(Symbol qname)
  {
    this(null, qname);
  }
  
  public AttributeType(String name, Symbol qname)
  {
    super("ATTRIBUTE " + qname + " (*)");
    
    this.qname = qname;
  }
  
  public gnu.bytecode.Type getImplementationType()
  {
    return ClassType.make("gnu.kawa.xml.KAttr");
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
    if (kind == 35)
      return isInstance(seq, ipos, seq.getNextTypeObject(ipos));
    if (kind == 32)
      return isInstance(seq.getPosNext(ipos));
    return false;
  }
  
  public boolean isInstance(AbstractSequence seq, int ipos, Object attrType)
  {
    String namespaceURI = this.qname.getNamespaceURI();
    String localName = this.qname.getLocalName();
    String curLocalName;
    String curNamespaceURI;
    String curLocalName; if ((attrType instanceof Symbol))
    {
      Symbol qname = (Symbol)attrType;
      String curNamespaceURI = qname.getNamespaceURI();
      curLocalName = qname.getLocalName();
    } else {
      String curLocalName;
      if ((attrType instanceof QName))
      {
        QName qtype = (QName)attrType;
        
        String curNamespaceURI = qtype.getNamespaceURI();
        curLocalName = qtype.getLocalPart();

      }
      else
      {
        curNamespaceURI = "";
        curLocalName = attrType.toString().intern();
      } }
    if ((localName != null) && (localName.length() == 0))
      localName = null;
    return ((localName == curLocalName) || (localName == null)) && ((namespaceURI == curNamespaceURI) || (namespaceURI == null));
  }
  

  public boolean isInstance(Object obj)
  {
    return coerceOrNull(obj, qname.getNamespaceURI(), qname.getLocalName()) != null;
  }
  


  public static KAttr coerceOrNull(Object obj, String namespaceURI, String localName)
  {
    KNode pos = NodeType.coerceOrNull(obj, 4);
    if (pos == null)
      return null;
    if ((localName != null) && (localName.length() == 0))
      localName = null;
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
      return (KAttr)pos; }
    return null;
  }
  

  public static SeqPosition coerce(Object obj, String namespaceURI, String localName)
  {
    SeqPosition pos = coerceOrNull(obj, namespaceURI, localName);
    if (pos == null)
      throw new ClassCastException();
    return pos;
  }
  
  protected void emitCoerceOrNullMethod(Variable incoming, Compilation comp)
  {
    CodeAttr code = comp.getCode();
    if (incoming != null)
      code.emitLoad(incoming);
    code.emitPushString(qname.getNamespaceURI());
    code.emitPushString(qname.getLocalName());
    code.emitInvokeStatic(coerceOrNullMethod);
  }
  
  public static final ClassType typeAttributeType = ClassType.make("gnu.kawa.xml.AttributeType");
  
  static final Method coerceMethod = typeAttributeType.getDeclaredMethod("coerce", 3);
  
  static final Method coerceOrNullMethod = typeAttributeType.getDeclaredMethod("coerceOrNull", 3);
  
  public void writeExternal(ObjectOutput out)
    throws IOException
  {
    String name = getName();
    out.writeUTF(name == null ? "" : name);
    out.writeObject(qname);
  }
  
  public void readExternal(ObjectInput in)
    throws IOException, ClassNotFoundException
  {
    String name = in.readUTF();
    if (name.length() > 0)
      setName(name);
    qname = ((Symbol)in.readObject());
  }
  
  public String toString()
  {
    return "AttributeType " + qname;
  }
}
