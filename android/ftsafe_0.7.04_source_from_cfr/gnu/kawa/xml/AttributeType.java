/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.TypeValue;
import gnu.kawa.xml.ElementType;
import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.NodeType;
import gnu.lists.AbstractSequence;
import gnu.lists.AttributePredicate;
import gnu.lists.SeqPosition;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.xml.namespace.QName;

public class AttributeType
extends NodeType
implements TypeValue,
Externalizable,
AttributePredicate {
    Symbol qname;
    public static final ClassType typeAttributeType = ClassType.make("gnu.kawa.xml.AttributeType");
    static final Method coerceMethod = typeAttributeType.getDeclaredMethod("coerce", 3);
    static final Method coerceOrNullMethod = typeAttributeType.getDeclaredMethod("coerceOrNull", 3);

    public static AttributeType make(String namespaceURI, String localName) {
        Symbol qname = namespaceURI != null ? Symbol.make(namespaceURI, localName) : (localName == "" ? ElementType.MATCH_ANY_QNAME : Symbol.makeUninterned(localName, null));
        return new AttributeType(qname);
    }

    public static AttributeType make(Symbol qname) {
        return new AttributeType(qname);
    }

    public AttributeType(Symbol qname) {
        this(null, qname);
    }

    public AttributeType(String name, Symbol qname) {
        super(name != null && name.length() > 0 ? name : "ATTRIBUTE " + qname + " (*)");
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
    public void emitCoerceFromObject(CodeAttr code) {
        code.emitPushString(this.qname.getNamespaceURI());
        code.emitPushString(this.qname.getLocalName());
        code.emitInvokeStatic(coerceMethod);
    }

    @Override
    public Object coerceFromObject(Object obj) {
        return AttributeType.coerce(obj, this.qname.getNamespaceURI(), this.qname.getLocalName());
    }

    @Override
    public boolean isInstancePos(AbstractSequence seq, int ipos) {
        int kind = seq.getNextKind(ipos);
        if (kind == 35) {
            return this.isInstance(seq, ipos, seq.getNextTypeObject(ipos));
        }
        if (kind == 32) {
            return this.isInstance(seq.getPosNext(ipos));
        }
        return false;
    }

    @Override
    public boolean isInstance(AbstractSequence seq, int ipos, Object attrType) {
        String curLocalName;
        String curNamespaceURI;
        String namespaceURI = this.qname.getNamespaceURI();
        String localName = this.qname.getLocalName();
        if (attrType instanceof Symbol) {
            Symbol qname = (Symbol)attrType;
            curNamespaceURI = qname.getNamespaceURI();
            curLocalName = qname.getLocalName();
        } else if (attrType instanceof QName) {
            QName qtype = (QName)attrType;
            curNamespaceURI = qtype.getNamespaceURI();
            curLocalName = qtype.getLocalPart();
        } else {
            curNamespaceURI = "";
            curLocalName = attrType.toString().intern();
        }
        if (localName != null && localName.length() == 0) {
            localName = null;
        }
        return !(localName != curLocalName && localName != null || namespaceURI != curNamespaceURI && namespaceURI != null);
    }

    @Override
    public boolean isInstance(Object obj) {
        return AttributeType.coerceOrNull(obj, this.qname.getNamespaceURI(), this.qname.getLocalName()) != null;
    }

    public static KAttr coerceOrNull(Object obj, String namespaceURI, String localName) {
        String curLocalName;
        Object curName;
        String curNamespaceURI;
        KNode pos = NodeType.coerceOrNull(obj, 4);
        if (pos == null) {
            return null;
        }
        if (localName != null && localName.length() == 0) {
            localName = null;
        }
        if ((curName = pos.getNextTypeObject()) instanceof Symbol) {
            Symbol qname = (Symbol)curName;
            curNamespaceURI = qname.getNamespaceURI();
            curLocalName = qname.getLocalName();
        } else if (curName instanceof QName) {
            QName qtype = (QName)curName;
            curNamespaceURI = qtype.getNamespaceURI();
            curLocalName = qtype.getLocalPart();
        } else {
            curNamespaceURI = "";
            curLocalName = curName.toString().intern();
        }
        if (!(localName != curLocalName && localName != null || namespaceURI != curNamespaceURI && namespaceURI != null)) {
            return (KAttr)pos;
        }
        return null;
    }

    public static SeqPosition coerce(Object obj, String namespaceURI, String localName) {
        KAttr pos = AttributeType.coerceOrNull(obj, namespaceURI, localName);
        if (pos == null) {
            throw new ClassCastException();
        }
        return pos;
    }

    @Override
    protected void emitCoerceOrNullMethod(Variable incoming, Compilation comp) {
        CodeAttr code = comp.getCode();
        if (incoming != null) {
            code.emitLoad(incoming);
        }
        code.emitPushString(this.qname.getNamespaceURI());
        code.emitPushString(this.qname.getLocalName());
        code.emitInvokeStatic(coerceOrNullMethod);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        String name = this.getName();
        out.writeUTF(name == null ? "" : name);
        out.writeObject(this.qname);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        String name = in.readUTF();
        if (name.length() > 0) {
            this.setName(name);
        }
        this.qname = (Symbol)in.readObject();
    }

    @Override
    public String toString() {
        return "AttributeType " + this.qname;
    }
}

