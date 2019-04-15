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
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.NodeType;
import gnu.lists.AbstractSequence;
import gnu.lists.ElementPredicate;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.xml.namespace.QName;

public class ElementType
extends NodeType
implements TypeValue,
Externalizable,
ElementPredicate {
    public static final String MATCH_ANY_LOCALNAME = "";
    public static final Symbol MATCH_ANY_QNAME = Symbol.makeUninterned("", null);
    Symbol qname;
    public static final ElementType anyElement = ElementType.make(null, null);
    NamespaceBinding namespaceNodes;
    public static final ClassType typeElementType = ClassType.make("gnu.kawa.xml.ElementType");
    static final Method coerceMethod = typeElementType.getDeclaredMethod("coerce", 3);
    static final Method coerceOrNullMethod = typeElementType.getDeclaredMethod("coerceOrNull", 3);

    public static ElementType make(String namespaceURI, String localName) {
        Symbol qname = namespaceURI != null ? Symbol.make(namespaceURI, localName) : (localName == MATCH_ANY_LOCALNAME ? MATCH_ANY_QNAME : Symbol.makeUninterned(localName, null));
        return new ElementType(qname);
    }

    public static ElementType make(Symbol qname) {
        return new ElementType(qname);
    }

    public ElementType(Symbol qname) {
        this(null, qname);
    }

    public ElementType(String name, Symbol qname) {
        super(name != null && name.length() > 0 ? name : "ELEMENT " + qname + " (*)");
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
    public void emitCoerceFromObject(CodeAttr code) {
        code.emitPushString(this.qname.getNamespaceURI());
        code.emitPushString(this.qname.getLocalName());
        code.emitInvokeStatic(coerceMethod);
    }

    @Override
    public Object coerceFromObject(Object obj) {
        return ElementType.coerce(obj, this.qname.getNamespaceURI(), this.qname.getLocalName());
    }

    @Override
    public boolean isInstancePos(AbstractSequence seq, int ipos) {
        int kind = seq.getNextKind(ipos);
        if (kind == 33) {
            return this.isInstance(seq, ipos, seq.getNextTypeObject(ipos));
        }
        if (kind == 32) {
            return this.isInstance(seq.getPosNext(ipos));
        }
        return false;
    }

    @Override
    public boolean isInstance(AbstractSequence seq, int ipos, Object elementType) {
        String curLocalName;
        String curNamespaceURI;
        String namespaceURI = this.qname.getNamespaceURI();
        String localName = this.qname.getLocalName();
        if (elementType instanceof Symbol) {
            Symbol qname = (Symbol)elementType;
            curNamespaceURI = qname.getNamespaceURI();
            curLocalName = qname.getLocalName();
        } else if (elementType instanceof QName) {
            QName qtype = (QName)elementType;
            curNamespaceURI = qtype.getNamespaceURI();
            curLocalName = qtype.getLocalPart();
        } else {
            curNamespaceURI = MATCH_ANY_LOCALNAME;
            curLocalName = elementType.toString().intern();
        }
        if (localName != null && localName.length() == 0) {
            localName = null;
        }
        return !(localName != curLocalName && localName != null || namespaceURI != curNamespaceURI && namespaceURI != null);
    }

    @Override
    public boolean isInstance(Object obj) {
        return ElementType.coerceOrNull(obj, this.qname.getNamespaceURI(), this.qname.getLocalName()) != null;
    }

    public static KElement coerceOrNull(Object obj, String namespaceURI, String localName) {
        String curLocalName;
        Object curName;
        String curNamespaceURI;
        KElement pos = (KElement)NodeType.coerceOrNull(obj, 2);
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
            curNamespaceURI = MATCH_ANY_LOCALNAME;
            curLocalName = curName.toString().intern();
        }
        if (!(localName != curLocalName && localName != null || namespaceURI != curNamespaceURI && namespaceURI != null)) {
            return pos;
        }
        return null;
    }

    public static KElement coerce(Object obj, String namespaceURI, String localName) {
        KElement pos = ElementType.coerceOrNull(obj, namespaceURI, localName);
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

    public NamespaceBinding getNamespaceNodes() {
        return this.namespaceNodes;
    }

    public void setNamespaceNodes(NamespaceBinding bindings) {
        this.namespaceNodes = bindings;
    }

    @Override
    public Procedure getConstructor() {
        MakeElement element = new MakeElement();
        element.tag = this.qname;
        element.setHandlingKeywordParameters(true);
        if (this.namespaceNodes != null) {
            element.setNamespaceNodes(this.namespaceNodes);
        }
        return element;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        String name = this.getName();
        out.writeUTF(name == null ? MATCH_ANY_LOCALNAME : name);
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
        return "ElementType " + this.qname;
    }
}

