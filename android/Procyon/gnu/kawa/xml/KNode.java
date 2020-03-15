// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import org.w3c.dom.UserDataHandler;
import gnu.lists.PositionConsumer;
import gnu.xml.XMLPrinter;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.Path;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Document;
import gnu.lists.Consumer;
import org.w3c.dom.DOMException;
import gnu.lists.AbstractSequence;
import org.w3c.dom.NodeList;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.lists.TreePosition;
import gnu.lists.Consumable;
import org.w3c.dom.Node;
import gnu.xml.NodeTree;
import gnu.lists.SeqPosition;

public abstract class KNode extends SeqPosition<Object, NodeTree> implements Node, Consumable
{
    public KNode(final NodeTree seq, final int ipos) {
        super(seq, ipos);
    }
    
    public static Object atomicValue(final Object value) {
        if (value instanceof KNode) {
            final KNode node = (KNode)value;
            return ((NodeTree)node.sequence).typedValue(node.ipos);
        }
        return value;
    }
    
    public static KNode coerce(final Object value) {
        if (value instanceof KNode) {
            return (KNode)value;
        }
        if (value instanceof NodeTree) {
            final NodeTree ntree = (NodeTree)value;
            return make(ntree, ntree.startPos());
        }
        if (value instanceof SeqPosition && !(value instanceof TreePosition)) {
            final SeqPosition seqp = (SeqPosition)value;
            if (seqp.sequence instanceof NodeTree) {
                return make((NodeTree)seqp.sequence, seqp.ipos);
            }
        }
        return null;
    }
    
    public static KNode make(final NodeTree seq, int ipos) {
        int index;
        for (index = seq.posToDataIndex(ipos); index < seq.data.length && seq.data[index] == '\uf112'; index = seq.gapEnd) {
            index += 5;
            if (index == seq.gapStart) {}
        }
        ipos = index << 1;
        final int kind = seq.getNextKindI(index);
        switch (kind) {
            case 33: {
                return new KElement(seq, ipos);
            }
            case 35: {
                return new KAttr(seq, ipos);
            }
            case 34: {
                return new KDocument(seq, ipos);
            }
            case 31: {
                return new KCDATASection(seq, ipos);
            }
            case 36: {
                return new KComment(seq, ipos);
            }
            case 37: {
                return new KProcessingInstruction(seq, ipos);
            }
            case 0: {
                if (!seq.isEmpty()) {
                    return null;
                }
                break;
            }
        }
        return new KText(seq, ipos);
    }
    
    @Override
    public KNode copy() {
        return make((NodeTree)this.sequence, ((NodeTree)this.sequence).copyPos(this.getPos()));
    }
    
    public static KNode make(final NodeTree seq) {
        return make(seq, 0);
    }
    
    @Override
    public boolean isSupported(final String feature, final String version) {
        return false;
    }
    
    @Override
    public abstract short getNodeType();
    
    @Override
    public String getNodeName() {
        return ((NodeTree)this.sequence).getNextTypeName(this.ipos);
    }
    
    public Symbol getNodeSymbol() {
        final Object type = ((NodeTree)this.sequence).getNextTypeObject(this.ipos);
        if (type == null) {
            return null;
        }
        if (type instanceof Symbol) {
            return (Symbol)type;
        }
        return Namespace.EmptyNamespace.getSymbol(type.toString().intern());
    }
    
    public Object getNodeNameObject() {
        return ((NodeTree)this.sequence).getNextTypeObject(this.ipos);
    }
    
    @Override
    public String getNamespaceURI() {
        return ((NodeTree)this.sequence).posNamespaceURI(this.ipos);
    }
    
    @Override
    public String getPrefix() {
        return ((NodeTree)this.sequence).posPrefix(this.ipos);
    }
    
    @Override
    public String getLocalName() {
        return ((NodeTree)this.sequence).posLocalName(this.ipos);
    }
    
    public static String getNodeValue(final NodeTree seq, final int ipos) {
        final StringBuffer sbuf = new StringBuffer();
        getNodeValue(seq, ipos, sbuf);
        return sbuf.toString();
    }
    
    public static void getNodeValue(final NodeTree seq, final int ipos, final StringBuffer sbuf) {
        seq.stringValue(seq.posToDataIndex(ipos), sbuf);
    }
    
    @Override
    public String getNodeValue() {
        final StringBuffer sbuf = new StringBuffer();
        this.getNodeValue(sbuf);
        return sbuf.toString();
    }
    
    public void getNodeValue(final StringBuffer sbuf) {
        getNodeValue((NodeTree)this.sequence, this.ipos, sbuf);
    }
    
    @Override
    public boolean hasChildNodes() {
        return ((NodeTree)this.sequence).posFirstChild(this.ipos) >= 0;
    }
    
    @Override
    public String getTextContent() {
        final StringBuffer sbuf = new StringBuffer();
        this.getTextContent(sbuf);
        return sbuf.toString();
    }
    
    protected void getTextContent(final StringBuffer sbuf) {
        this.getNodeValue(sbuf);
    }
    
    @Override
    public Node getParentNode() {
        final int parent = ((NodeTree)this.sequence).parentPos(this.ipos);
        if (parent == -1) {
            return null;
        }
        return make((NodeTree)this.sequence, parent);
    }
    
    @Override
    public Node getPreviousSibling() {
        int parent = ((NodeTree)this.sequence).parentPos(this.ipos);
        if (parent == -1) {
            parent = 0;
        }
        final int index = ((NodeTree)this.sequence).posToDataIndex(this.ipos);
        int child = ((NodeTree)this.sequence).firstChildPos(parent);
        int previous = 0;
        do {
            previous = child;
            child = ((NodeTree)this.sequence).nextPos(child);
            if (child == 0) {
                break;
            }
        } while (((NodeTree)this.sequence).posToDataIndex(child) != index);
        return (previous == 0) ? null : make((NodeTree)this.sequence, previous);
    }
    
    @Override
    public Node getNextSibling() {
        final int next = ((NodeTree)this.sequence).nextPos(this.ipos);
        return (next == 0) ? null : make((NodeTree)this.sequence, next);
    }
    
    @Override
    public Node getFirstChild() {
        final int child = ((NodeTree)this.sequence).posFirstChild(this.ipos);
        return make((NodeTree)this.sequence, child);
    }
    
    @Override
    public Node getLastChild() {
        int last = 0;
        for (int child = ((NodeTree)this.sequence).firstChildPos(this.ipos); child != 0; child = ((NodeTree)this.sequence).nextPos(child)) {
            last = child;
        }
        return (last == 0) ? null : make((NodeTree)this.sequence, last);
    }
    
    @Override
    public NodeList getChildNodes() {
        final Nodes nodes = new SortedNodes();
        for (int child = ((NodeTree)this.sequence).firstChildPos(this.ipos); child != 0; child = ((NodeTree)this.sequence).nextPos(child)) {
            nodes.writePosition(this.sequence, child);
        }
        return nodes;
    }
    
    public NodeList getElementsByTagName(final String tagname) {
        throw new UnsupportedOperationException("getElementsByTagName not implemented yet");
    }
    
    @Override
    public void setNodeValue(final String nodeValue) throws DOMException {
        throw new DOMException((short)7, "setNodeValue not supported");
    }
    
    @Override
    public void setPrefix(final String prefix) throws DOMException {
        throw new DOMException((short)7, "setPrefix not supported");
    }
    
    @Override
    public Node insertBefore(final Node newChild, final Node refChild) throws DOMException {
        throw new DOMException((short)7, "insertBefore not supported");
    }
    
    @Override
    public Node replaceChild(final Node newChild, final Node oldChild) throws DOMException {
        throw new DOMException((short)7, "replaceChild not supported");
    }
    
    @Override
    public Node removeChild(final Node oldChild) throws DOMException {
        throw new DOMException((short)7, "removeChild not supported");
    }
    
    @Override
    public Node appendChild(final Node newChild) throws DOMException {
        throw new DOMException((short)7, "appendChild not supported");
    }
    
    @Override
    public void setTextContent(final String textContent) throws DOMException {
        throw new DOMException((short)7, "setTextContent not supported");
    }
    
    @Override
    public Node cloneNode(final boolean deep) {
        if (!deep) {
            throw new UnsupportedOperationException("shallow cloneNode not implemented");
        }
        final NodeTree tree = new NodeTree();
        ((NodeTree)this.sequence).consumeNext(this.ipos, tree);
        return make(tree);
    }
    
    @Override
    public Document getOwnerDocument() {
        final int kind = ((NodeTree)this.sequence).getNextKind(this.ipos);
        if (kind == 34) {
            return new KDocument((NodeTree)this.sequence, 0);
        }
        return null;
    }
    
    @Override
    public NamedNodeMap getAttributes() {
        throw new UnsupportedOperationException("getAttributes not implemented yet");
    }
    
    @Override
    public void normalize() {
    }
    
    @Override
    public boolean hasAttributes() {
        return false;
    }
    
    @Override
    public boolean isDefaultNamespace(final String namespaceURI) {
        return ((NodeTree)this.sequence).posIsDefaultNamespace(this.ipos, namespaceURI);
    }
    
    @Override
    public String lookupNamespaceURI(final String prefix) {
        return ((NodeTree)this.sequence).posLookupNamespaceURI(this.ipos, prefix);
    }
    
    @Override
    public String lookupPrefix(final String namespaceURI) {
        return ((NodeTree)this.sequence).posLookupPrefix(this.ipos, namespaceURI);
    }
    
    @Override
    public String getBaseURI() {
        final Object uri = ((NodeTree)this.sequence).baseUriOfPos(this.ipos, true);
        return (uri == null) ? null : uri.toString();
    }
    
    public Path baseURI() {
        return ((NodeTree)this.sequence).baseUriOfPos(this.ipos, true);
    }
    
    @Override
    public short compareDocumentPosition(final Node other) throws DOMException {
        if (!(other instanceof KNode)) {
            throw new DOMException((short)9, "other Node is a " + other.getClass().getName());
        }
        final KNode n = (KNode)other;
        final AbstractSequence nseq = n.sequence;
        return (short)((this.sequence == nseq) ? nseq.compare(this.ipos, n.ipos) : ((NodeTree)this.sequence).stableCompare(nseq));
    }
    
    @Override
    public boolean isSameNode(final Node node) {
        if (!(node instanceof KNode)) {
            return false;
        }
        final KNode n = (KNode)node;
        return this.sequence == n.sequence && ((NodeTree)this.sequence).equals(this.ipos, n.ipos);
    }
    
    @Override
    public boolean isEqualNode(final Node node) {
        throw new UnsupportedOperationException("getAttributesisEqualNode not implemented yet");
    }
    
    @Override
    public String toString() {
        final CharArrayOutPort wr = new CharArrayOutPort();
        final XMLPrinter xp = XMLPrinter.make(wr, "xhtml");
        ((NodeTree)this.sequence).consumeNext(this.ipos, xp);
        xp.close();
        wr.close();
        return wr.toString();
    }
    
    @Override
    public Object getFeature(final String feature, final String version) {
        return null;
    }
    
    @Override
    public void consume(final Consumer out) {
        if (out instanceof PositionConsumer) {
            ((PositionConsumer)out).writePosition(this);
        }
        else {
            ((NodeTree)this.sequence).consumeNext(this.ipos, out);
        }
    }
    
    @Override
    public Object setUserData(final String key, final Object data, final UserDataHandler handler) {
        throw new UnsupportedOperationException("setUserData not implemented yet");
    }
    
    @Override
    public Object getUserData(final String key) {
        return null;
    }
}
