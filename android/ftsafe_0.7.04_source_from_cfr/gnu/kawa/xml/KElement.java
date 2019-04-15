/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class KElement
extends KNode
implements Element {
    public KElement(NodeTree seq, int ipos) {
        super(seq, ipos);
    }

    @Override
    public short getNodeType() {
        return 1;
    }

    @Override
    public String getTagName() {
        return ((NodeTree)this.sequence).getNextTypeName(this.ipos);
    }

    @Override
    public String getNodeValue() {
        return null;
    }

    @Override
    public boolean hasAttributes() {
        return ((NodeTree)this.sequence).posHasAttributes(this.ipos);
    }

    @Override
    public String getAttribute(String name) {
        NodeTree nodes;
        int attr;
        if (name == null) {
            name = "";
        }
        if ((attr = (nodes = (NodeTree)this.sequence).getAttribute(this.ipos, null, name)) == 0) {
            return "";
        }
        return KNode.getNodeValue(nodes, attr);
    }

    @Override
    public void setAttribute(String name, String value) throws DOMException {
        throw new DOMException(7, "setAttribute not supported");
    }

    @Override
    public void setIdAttribute(String name, boolean isId) throws DOMException {
        throw new DOMException(7, "setIdAttribute not supported");
    }

    @Override
    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
        throw new DOMException(7, "setIdAttributeNS not supported");
    }

    @Override
    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        throw new DOMException(7, "setIdAttributeNode not supported");
    }

    @Override
    public void removeAttribute(String name) throws DOMException {
        throw new DOMException(7, "removeAttribute not supported");
    }

    @Override
    public KAttr getAttributeNode(String name) {
        NodeTree nodes;
        int attr;
        if (name == null) {
            name = "";
        }
        if ((attr = (nodes = (NodeTree)this.sequence).getAttribute(this.ipos, null, name)) == 0) {
            return null;
        }
        return new KAttr(nodes, attr);
    }

    @Override
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        throw new DOMException(7, "setAttributeNode not supported");
    }

    @Override
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        throw new DOMException(7, "removeAttributeNode not supported");
    }

    @Override
    public String getAttributeNS(String namespaceURI, String localName) {
        NodeTree nodes;
        int attr;
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        if (localName == null) {
            localName = "";
        }
        if ((attr = (nodes = (NodeTree)this.sequence).getAttribute(this.ipos, namespaceURI, localName)) == 0) {
            return "";
        }
        return KElement.getNodeValue(nodes, attr);
    }

    @Override
    public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException {
        throw new DOMException(7, "setAttributeNS not supported");
    }

    @Override
    public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
        throw new DOMException(7, "removeAttributeNS not supported");
    }

    @Override
    public KAttr getAttributeNodeNS(String namespaceURI, String localName) {
        NodeTree nodes;
        int attr;
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        if (localName == null) {
            localName = "";
        }
        if ((attr = (nodes = (NodeTree)this.sequence).getAttribute(this.ipos, namespaceURI, localName)) == 0) {
            return null;
        }
        return new KAttr(nodes, attr);
    }

    @Override
    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        throw new DOMException(7, "setAttributeNodeNS not supported");
    }

    @Override
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        throw new UnsupportedOperationException("getElementsByTagNameNS not implemented yet");
    }

    @Override
    public boolean hasAttribute(String name) {
        int attr = ((NodeTree)this.sequence).getAttribute(this.ipos, null, name == null ? "" : name);
        return attr != 0;
    }

    @Override
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        int attr;
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        if (localName == null) {
            localName = "";
        }
        return (attr = ((NodeTree)this.sequence).getAttribute(this.ipos, namespaceURI, localName)) != 0;
    }

    @Override
    public TypeInfo getSchemaTypeInfo() {
        return null;
    }
}

