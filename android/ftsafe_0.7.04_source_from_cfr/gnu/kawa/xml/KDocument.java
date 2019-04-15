/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class KDocument
extends KNode
implements Document {
    public KDocument(NodeTree seq, int ipos) {
        super(seq, ipos);
    }

    @Override
    public String getNodeName() {
        return "#document";
    }

    @Override
    public DOMImplementation getImplementation() {
        throw new UnsupportedOperationException("getImplementation not implemented");
    }

    @Override
    public DocumentType getDoctype() {
        return null;
    }

    @Override
    public Node getParentNode() {
        return null;
    }

    @Override
    public KElement getDocumentElement() {
        int child = ((NodeTree)this.sequence).posFirstChild(this.ipos);
        do {
            if (child == -1) {
                return null;
            }
            if (((NodeTree)this.sequence).getNextKind(child) != 36) break;
            child = ((NodeTree)this.sequence).nextPos(child);
        } while (true);
        return (KElement)KDocument.make((NodeTree)this.sequence, child);
    }

    @Override
    public short getNodeType() {
        return 9;
    }

    @Override
    public String getNodeValue() {
        return null;
    }

    @Override
    public String getTextContent() {
        return null;
    }

    @Override
    protected void getTextContent(StringBuffer sbuf) {
    }

    @Override
    public Element createElement(String tagName) {
        throw new UnsupportedOperationException("createElement not implemented");
    }

    @Override
    public DocumentFragment createDocumentFragment() {
        throw new UnsupportedOperationException("createDocumentFragment not implemented");
    }

    @Override
    public Text createTextNode(String data) {
        throw new UnsupportedOperationException("createTextNode not implemented");
    }

    @Override
    public Comment createComment(String data) {
        throw new UnsupportedOperationException("createComment not implemented");
    }

    @Override
    public CDATASection createCDATASection(String data) {
        throw new UnsupportedOperationException("createCDATASection not implemented");
    }

    @Override
    public ProcessingInstruction createProcessingInstruction(String target, String data) {
        throw new UnsupportedOperationException("createProcessingInstruction not implemented");
    }

    @Override
    public Attr createAttribute(String name) {
        throw new UnsupportedOperationException("createAttribute not implemented");
    }

    @Override
    public EntityReference createEntityReference(String name) {
        throw new UnsupportedOperationException("createEntityReference implemented");
    }

    @Override
    public Node importNode(Node importedNode, boolean deep) {
        throw new UnsupportedOperationException("importNode not implemented");
    }

    @Override
    public Element createElementNS(String namespaceURI, String qualifiedName) {
        throw new UnsupportedOperationException("createElementNS not implemented");
    }

    @Override
    public Attr createAttributeNS(String namespaceURI, String qualifiedName) {
        throw new UnsupportedOperationException("createAttributeNS not implemented");
    }

    @Override
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        throw new UnsupportedOperationException("getElementsByTagNameNS not implemented yet");
    }

    @Override
    public Element getElementById(String elementId) {
        return null;
    }

    @Override
    public boolean hasAttributes() {
        return false;
    }

    @Override
    public String getInputEncoding() {
        return null;
    }

    @Override
    public String getXmlEncoding() {
        return null;
    }

    @Override
    public boolean getXmlStandalone() {
        return false;
    }

    @Override
    public void setXmlStandalone(boolean xmlStandalone) {
    }

    @Override
    public String getXmlVersion() {
        return "1.1";
    }

    @Override
    public void setXmlVersion(String xmlVersion) {
    }

    @Override
    public boolean getStrictErrorChecking() {
        return false;
    }

    @Override
    public void setStrictErrorChecking(boolean strictErrorChecking) {
    }

    @Override
    public String getDocumentURI() {
        return null;
    }

    @Override
    public void setDocumentURI(String documentURI) {
    }

    @Override
    public Node renameNode(Node n, String namespaceURI, String qualifiedname) throws DOMException {
        throw new DOMException(9, "renameNode not implemented");
    }

    @Override
    public Node adoptNode(Node source) throws DOMException {
        throw new DOMException(9, "adoptNode not implemented");
    }

    @Override
    public void normalizeDocument() {
    }

    @Override
    public DOMConfiguration getDomConfig() {
        throw new DOMException(9, "getDomConfig not implemented");
    }
}

