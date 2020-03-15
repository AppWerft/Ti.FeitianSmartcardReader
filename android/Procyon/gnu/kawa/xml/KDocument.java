// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Attr;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Text;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.DocumentType;
import org.w3c.dom.DOMImplementation;
import gnu.xml.NodeTree;
import org.w3c.dom.Document;

public class KDocument extends KNode implements Document
{
    public KDocument(final NodeTree seq, final int ipos) {
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
        for (int child = ((NodeTree)this.sequence).posFirstChild(this.ipos); child != -1; child = ((NodeTree)this.sequence).nextPos(child)) {
            if (((NodeTree)this.sequence).getNextKind(child) != 36) {
                return (KElement)KNode.make((NodeTree)this.sequence, child);
            }
        }
        return null;
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
    protected void getTextContent(final StringBuffer sbuf) {
    }
    
    @Override
    public Element createElement(final String tagName) {
        throw new UnsupportedOperationException("createElement not implemented");
    }
    
    @Override
    public DocumentFragment createDocumentFragment() {
        throw new UnsupportedOperationException("createDocumentFragment not implemented");
    }
    
    @Override
    public Text createTextNode(final String data) {
        throw new UnsupportedOperationException("createTextNode not implemented");
    }
    
    @Override
    public Comment createComment(final String data) {
        throw new UnsupportedOperationException("createComment not implemented");
    }
    
    @Override
    public CDATASection createCDATASection(final String data) {
        throw new UnsupportedOperationException("createCDATASection not implemented");
    }
    
    @Override
    public ProcessingInstruction createProcessingInstruction(final String target, final String data) {
        throw new UnsupportedOperationException("createProcessingInstruction not implemented");
    }
    
    @Override
    public Attr createAttribute(final String name) {
        throw new UnsupportedOperationException("createAttribute not implemented");
    }
    
    @Override
    public EntityReference createEntityReference(final String name) {
        throw new UnsupportedOperationException("createEntityReference implemented");
    }
    
    @Override
    public Node importNode(final Node importedNode, final boolean deep) {
        throw new UnsupportedOperationException("importNode not implemented");
    }
    
    @Override
    public Element createElementNS(final String namespaceURI, final String qualifiedName) {
        throw new UnsupportedOperationException("createElementNS not implemented");
    }
    
    @Override
    public Attr createAttributeNS(final String namespaceURI, final String qualifiedName) {
        throw new UnsupportedOperationException("createAttributeNS not implemented");
    }
    
    @Override
    public NodeList getElementsByTagNameNS(final String namespaceURI, final String localName) {
        throw new UnsupportedOperationException("getElementsByTagNameNS not implemented yet");
    }
    
    @Override
    public Element getElementById(final String elementId) {
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
    public void setXmlStandalone(final boolean xmlStandalone) {
    }
    
    @Override
    public String getXmlVersion() {
        return "1.1";
    }
    
    @Override
    public void setXmlVersion(final String xmlVersion) {
    }
    
    @Override
    public boolean getStrictErrorChecking() {
        return false;
    }
    
    @Override
    public void setStrictErrorChecking(final boolean strictErrorChecking) {
    }
    
    @Override
    public String getDocumentURI() {
        return null;
    }
    
    @Override
    public void setDocumentURI(final String documentURI) {
    }
    
    @Override
    public Node renameNode(final Node n, final String namespaceURI, final String qualifiedname) throws DOMException {
        throw new DOMException((short)9, "renameNode not implemented");
    }
    
    @Override
    public Node adoptNode(final Node source) throws DOMException {
        throw new DOMException((short)9, "adoptNode not implemented");
    }
    
    @Override
    public void normalizeDocument() {
    }
    
    @Override
    public DOMConfiguration getDomConfig() {
        throw new DOMException((short)9, "getDomConfig not implemented");
    }
}
