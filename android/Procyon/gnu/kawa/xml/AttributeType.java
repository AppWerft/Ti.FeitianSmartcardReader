// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.expr.Compilation;
import gnu.bytecode.Variable;
import gnu.lists.SeqPosition;
import javax.xml.namespace.QName;
import gnu.lists.AbstractSequence;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.mapping.Namespace;
import gnu.bytecode.Method;
import gnu.bytecode.ClassType;
import gnu.mapping.Symbol;
import gnu.lists.AttributePredicate;
import java.io.Externalizable;
import gnu.expr.TypeValue;

public class AttributeType extends NodeType implements TypeValue, Externalizable, AttributePredicate
{
    Symbol qname;
    public static final ClassType typeAttributeType;
    static final Method coerceMethod;
    static final Method coerceOrNullMethod;
    
    public static AttributeType make(final String namespaceURI, final String localName) {
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
        return new AttributeType(qname);
    }
    
    public static AttributeType make(final Symbol qname) {
        return new AttributeType(qname);
    }
    
    public AttributeType(final Symbol qname) {
        this(null, qname);
    }
    
    public AttributeType(final String name, final Symbol qname) {
        super((name != null && name.length() > 0) ? name : ("ATTRIBUTE " + qname + " (*)"));
        this.qname = qname;
    }
    
    @Override
    public Type getImplementationType() {
        return ClassType.make("gnu.kawa.xml.KAttr");
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
        code.emitInvokeStatic(AttributeType.coerceMethod);
    }
    
    @Override
    public Object coerceFromObject(final Object obj) {
        return coerce(obj, this.qname.getNamespaceURI(), this.qname.getLocalName());
    }
    
    @Override
    public boolean isInstancePos(final AbstractSequence seq, final int ipos) {
        final int kind = seq.getNextKind(ipos);
        if (kind == 35) {
            return this.isInstance(seq, ipos, seq.getNextTypeObject(ipos));
        }
        return kind == 32 && this.isInstance(seq.getPosNext(ipos));
    }
    
    @Override
    public boolean isInstance(final AbstractSequence seq, final int ipos, final Object attrType) {
        final String namespaceURI = this.qname.getNamespaceURI();
        String localName = this.qname.getLocalName();
        String curNamespaceURI;
        String curLocalName;
        if (attrType instanceof Symbol) {
            final Symbol qname = (Symbol)attrType;
            curNamespaceURI = qname.getNamespaceURI();
            curLocalName = qname.getLocalName();
        }
        else if (attrType instanceof QName) {
            final QName qtype = (QName)attrType;
            curNamespaceURI = qtype.getNamespaceURI();
            curLocalName = qtype.getLocalPart();
        }
        else {
            curNamespaceURI = "";
            curLocalName = attrType.toString().intern();
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
    
    public static KAttr coerceOrNull(final Object obj, final String namespaceURI, String localName) {
        final KNode pos = NodeType.coerceOrNull(obj, 4);
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
            return (KAttr)pos;
        }
        return null;
    }
    
    public static SeqPosition coerce(final Object obj, final String namespaceURI, final String localName) {
        final SeqPosition pos = coerceOrNull(obj, namespaceURI, localName);
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
        code.emitInvokeStatic(AttributeType.coerceOrNullMethod);
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
        return "AttributeType " + this.qname;
    }
    
    static {
        typeAttributeType = ClassType.make("gnu.kawa.xml.AttributeType");
        coerceMethod = AttributeType.typeAttributeType.getDeclaredMethod("coerce", 3);
        coerceOrNullMethod = AttributeType.typeAttributeType.getDeclaredMethod("coerceOrNull", 3);
    }
}
