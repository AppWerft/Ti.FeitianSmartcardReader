// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.SeqPosition;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.Procedure;
import gnu.expr.Compilation;
import gnu.bytecode.Variable;
import javax.xml.namespace.QName;
import gnu.lists.AbstractSequence;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.mapping.Namespace;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.xml.NamespaceBinding;
import gnu.mapping.Symbol;
import gnu.lists.ElementPredicate;
import java.io.Externalizable;
import gnu.expr.TypeValue;

public class ElementType extends NodeType implements TypeValue, Externalizable, ElementPredicate
{
    public static final String MATCH_ANY_LOCALNAME = "";
    public static final Symbol MATCH_ANY_QNAME;
    Symbol qname;
    public static final ElementType anyElement;
    NamespaceBinding namespaceNodes;
    public static final ClassType typeElementType;
    static final Method coerceMethod;
    static final Method coerceOrNullMethod;
    
    public static ElementType make(final String namespaceURI, final String localName) {
        Symbol qname;
        if (namespaceURI != null) {
            qname = Symbol.make(namespaceURI, localName);
        }
        else if (localName == "") {
            qname = ElementType.MATCH_ANY_QNAME;
        }
        else {
            qname = Symbol.makeUninterned(localName, null);
        }
        return new ElementType(qname);
    }
    
    public static ElementType make(final Symbol qname) {
        return new ElementType(qname);
    }
    
    public ElementType(final Symbol qname) {
        this(null, qname);
    }
    
    public ElementType(final String name, final Symbol qname) {
        super((name != null && name.length() > 0) ? name : ("ELEMENT " + qname + " (*)"));
        this.qname = qname;
    }
    
    @Override
    public Type getImplementationType() {
        return ClassType.make("gnu.kawa.xml.KElement");
    }
    
    public final String getNamespaceURI() {
        return this.qname.getNamespaceURI();
    }
    
    public final String getLocalName() {
        return this.qname.getLocalName();
    }
    
    @Override
    public void emitCoerceFromObject(final CodeAttr code) {
        code.emitPushString(this.qname.getNamespaceURI());
        code.emitPushString(this.qname.getLocalName());
        code.emitInvokeStatic(ElementType.coerceMethod);
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        return coerce(obj, this.qname.getNamespaceURI(), this.qname.getLocalName());
    }
    
    @Override
    public boolean isInstancePos(final AbstractSequence seq, final int ipos) {
        final int kind = seq.getNextKind(ipos);
        if (kind == 33) {
            return this.isInstance(seq, ipos, seq.getNextTypeObject(ipos));
        }
        return kind == 32 && this.isInstance(seq.getPosNext(ipos));
    }
    
    @Override
    public boolean isInstance(final AbstractSequence seq, final int ipos, final Object elementType) {
        final String namespaceURI = this.qname.getNamespaceURI();
        String localName = this.qname.getLocalName();
        String curNamespaceURI;
        String curLocalName;
        if (elementType instanceof Symbol) {
            final Symbol qname = (Symbol)elementType;
            curNamespaceURI = qname.getNamespaceURI();
            curLocalName = qname.getLocalName();
        }
        else if (elementType instanceof QName) {
            final QName qtype = (QName)elementType;
            curNamespaceURI = qtype.getNamespaceURI();
            curLocalName = qtype.getLocalPart();
        }
        else {
            curNamespaceURI = "";
            curLocalName = elementType.toString().intern();
        }
        if (localName != null && localName.length() == 0) {
            localName = null;
        }
        return (localName == curLocalName || localName == null) && (namespaceURI == curNamespaceURI || namespaceURI == null);
    }
    
    @Override
    public boolean isInstance(final Object obj) {
        return coerceOrNull(obj, this.qname.getNamespaceURI(), this.qname.getLocalName()) != null;
    }
    
    public static KElement coerceOrNull(final Object obj, final String namespaceURI, String localName) {
        final KElement pos = (KElement)NodeType.coerceOrNull(obj, 2);
        if (pos == null) {
            return null;
        }
        if (localName != null && localName.length() == 0) {
            localName = null;
        }
        final Object curName = ((SeqPosition<Object, ESEQ>)pos).getNextTypeObject();
        String curNamespaceURI;
        String curLocalName;
        if (curName instanceof Symbol) {
            final Symbol qname = (Symbol)curName;
            curNamespaceURI = qname.getNamespaceURI();
            curLocalName = qname.getLocalName();
        }
        else if (curName instanceof QName) {
            final QName qtype = (QName)curName;
            curNamespaceURI = qtype.getNamespaceURI();
            curLocalName = qtype.getLocalPart();
        }
        else {
            curNamespaceURI = "";
            curLocalName = curName.toString().intern();
        }
        if ((localName == curLocalName || localName == null) && (namespaceURI == curNamespaceURI || namespaceURI == null)) {
            return pos;
        }
        return null;
    }
    
    public static KElement coerce(final Object obj, final String namespaceURI, final String localName) {
        final KElement pos = coerceOrNull(obj, namespaceURI, localName);
        if (pos == null) {
            throw new ClassCastException();
        }
        return pos;
    }
    
    @Override
    protected void emitCoerceOrNullMethod(final Variable incoming, final Compilation comp) {
        final CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        code.emitPushString(this.qname.getNamespaceURI());
        code.emitPushString(this.qname.getLocalName());
        code.emitInvokeStatic(ElementType.coerceOrNullMethod);
    }
    
    public NamespaceBinding getNamespaceNodes() {
        return this.namespaceNodes;
    }
    
    public void setNamespaceNodes(final NamespaceBinding bindings) {
        this.namespaceNodes = bindings;
    }
    
    @Override
    public Procedure getConstructor() {
        final MakeElement element = new MakeElement();
        element.tag = this.qname;
        element.setHandlingKeywordParameters(true);
        if (this.namespaceNodes != null) {
            element.setNamespaceNodes(this.namespaceNodes);
        }
        return element;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        final String name = this.getName();
        out.writeUTF((name == null) ? "" : name);
        out.writeObject(this.qname);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        final String name = in.readUTF();
        if (name.length() > 0) {
            this.setName(name);
        }
        this.qname = (Symbol)in.readObject();
    }
    
    @Override
    public String toString() {
        return "ElementType " + this.qname;
    }
    
    static {
        MATCH_ANY_QNAME = Symbol.makeUninterned("", null);
        anyElement = make(null, (String)null);
        typeElementType = ClassType.make("gnu.kawa.xml.ElementType");
        coerceMethod = ElementType.typeElementType.getDeclaredMethod("coerce", 3);
        coerceOrNullMethod = ElementType.typeElementType.getDeclaredMethod("coerceOrNull", 3);
    }
}
