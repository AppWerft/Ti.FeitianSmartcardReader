// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import org.w3c.dom.TypeInfo;
import org.w3c.dom.NodeList;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import gnu.xml.NodeTree;
import org.w3c.dom.Element;

public class KElement extends KNode implements Element
{
    public KElement(final NodeTree seq, final int ipos) {
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
        if (name == null) {
            name = "";
        }
        final NodeTree nodes = (NodeTree)this.sequence;
        final int attr = nodes.getAttribute(this.ipos, null, name);
        if (attr == 0) {
            return "";
        }
        return KNode.getNodeValue(nodes, attr);
    }
    
    @Override
    public void setAttribute(final String name, final String value) throws DOMException {
        throw new DOMException((short)7, "setAttribute not supported");
    }
    
    @Override
    public void setIdAttribute(final String name, final boolean isId) throws DOMException {
        throw new DOMException((short)7, "setIdAttribute not supported");
    }
    
    @Override
    public void setIdAttributeNS(final String namespaceURI, final String localName, final boolean isId) throws DOMException {
        throw new DOMException((short)7, "setIdAttributeNS not supported");
    }
    
    @Override
    public void setIdAttributeNode(final Attr idAttr, final boolean isId) throws DOMException {
        throw new DOMException((short)7, "setIdAttributeNode not supported");
    }
    
    @Override
    public void removeAttribute(final String name) throws DOMException {
        throw new DOMException((short)7, "removeAttribute not supported");
    }
    
    @Override
    public KAttr getAttributeNode(String name) {
        if (name == null) {
            name = "";
        }
        final NodeTree nodes = (NodeTree)this.sequence;
        final int attr = nodes.getAttribute(this.ipos, null, name);
        if (attr == 0) {
            return null;
        }
        return new KAttr(nodes, attr);
    }
    
    @Override
    public Attr setAttributeNode(final Attr newAttr) throws DOMException {
        throw new DOMException((short)7, "setAttributeNode not supported");
    }
    
    @Override
    public Attr removeAttributeNode(final Attr oldAttr) throws DOMException {
        throw new DOMException((short)7, "removeAttributeNode not supported");
    }
    
    @Override
    public String getAttributeNS(String namespaceURI, String localName) {
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        if (localName == null) {
            localName = "";
        }
        final NodeTree nodes = (NodeTree)this.sequence;
        final int attr = nodes.getAttribute(this.ipos, namespaceURI, localName);
        if (attr == 0) {
            return "";
        }
        return KNode.getNodeValue(nodes, attr);
    }
    
    @Override
    public void setAttributeNS(final String namespaceURI, final String qualifiedName, final String value) throws DOMException {
        throw new DOMException((short)7, "setAttributeNS not supported");
    }
    
    @Override
    public void removeAttributeNS(final String namespaceURI, final String localName) throws DOMException {
        throw new DOMException((short)7, "removeAttributeNS not supported");
    }
    
    @Override
    public KAttr getAttributeNodeNS(String namespaceURI, String localName) {
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        if (localName == null) {
            localName = "";
        }
        final NodeTree nodes = (NodeTree)this.sequence;
        final int attr = nodes.getAttribute(this.ipos, namespaceURI, localName);
        if (attr == 0) {
            return null;
        }
        return new KAttr(nodes, attr);
    }
    
    @Override
    public Attr setAttributeNodeNS(final Attr newAttr) throws DOMException {
        throw new DOMException((short)7, "setAttributeNodeNS not supported");
    }
    
    @Override
    public NodeList getElementsByTagNameNS(final String namespaceURI, final String localName) {
        throw new UnsupportedOperationException("getElementsByTagNameNS not implemented yet");
    }
    
    @Override
    public boolean hasAttribute(final String name) {
        final int attr = ((NodeTree)this.sequence).getAttribute(this.ipos, null, (name == null) ? "" : name);
        return attr != 0;
    }
    
    @Override
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        if (namespaceURI == null) {
            namespaceURI = "";
        }
        if (localName == null) {
            localName = "";
        }
        final int attr = ((NodeTree)this.sequence).getAttribute(this.ipos, namespaceURI, localName);
        return attr != 0;
    }
    
    @Override
    public TypeInfo getSchemaTypeInfo() {
        return null;
    }
}
