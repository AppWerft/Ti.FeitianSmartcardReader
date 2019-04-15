/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.Path;
import gnu.kawa.xml.KAttr;
import gnu.kawa.xml.KCDATASection;
import gnu.kawa.xml.KComment;
import gnu.kawa.xml.KDocument;
import gnu.kawa.xml.KElement;
import gnu.kawa.xml.KProcessingInstruction;
import gnu.kawa.xml.KText;
import gnu.kawa.xml.Nodes;
import gnu.kawa.xml.SortedNodes;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreePosition;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.xml.NodeTree;
import gnu.xml.XMLPrinter;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

public abstract class KNode
extends SeqPosition<Object, NodeTree>
implements Node,
Consumable {
    public KNode(NodeTree seq, int ipos) {
        super(seq, ipos);
    }

    public static Object atomicValue(Object value) {
        if (value instanceof KNode) {
            KNode node = (KNode)value;
            return ((NodeTree)node.sequence).typedValue(node.ipos);
        }
        return value;
    }

    public static KNode coerce(Object value) {
        if (value instanceof KNode) {
            return (KNode)value;
        }
        if (value instanceof NodeTree) {
            NodeTree ntree = (NodeTree)value;
            return KNode.make(ntree, ntree.startPos());
        }
        if (value instanceof SeqPosition && !(value instanceof TreePosition)) {
            SeqPosition seqp = (SeqPosition)value;
            if (seqp.sequence instanceof NodeTree) {
                return KNode.make((NodeTree)seqp.sequence, seqp.ipos);
            }
        }
        return null;
    }

    public static KNode make(NodeTree seq, int ipos) {
        int index = seq.posToDataIndex(ipos);
        while (index < seq.data.length && seq.data[index] == '\uf112') {
            if ((index += 5) != seq.gapStart) continue;
            index = seq.gapEnd;
        }
        ipos = index << 1;
        int kind = seq.getNextKindI(index);
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
                if (seq.isEmpty()) break;
                return null;
            }
        }
        return new KText(seq, ipos);
    }

    public KNode copy() {
        return KNode.make((NodeTree)this.sequence, ((NodeTree)this.sequence).copyPos(this.getPos()));
    }

    public static KNode make(NodeTree seq) {
        return KNode.make(seq, 0);
    }

    @Override
    public boolean isSupported(String feature, String version) {
        return false;
    }

    @Override
    public abstract short getNodeType();

    @Override
    public String getNodeName() {
        return ((NodeTree)this.sequence).getNextTypeName(this.ipos);
    }

    public Symbol getNodeSymbol() {
        Object type = ((NodeTree)this.sequence).getNextTypeObject(this.ipos);
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

    public static String getNodeValue(NodeTree seq, int ipos) {
        StringBuffer sbuf = new StringBuffer();
        KNode.getNodeValue(seq, ipos, sbuf);
        return sbuf.toString();
    }

    public static void getNodeValue(NodeTree seq, int ipos, StringBuffer sbuf) {
        seq.stringValue(seq.posToDataIndex(ipos), sbuf);
    }

    @Override
    public String getNodeValue() {
        StringBuffer sbuf = new StringBuffer();
        this.getNodeValue(sbuf);
        return sbuf.toString();
    }

    public void getNodeValue(StringBuffer sbuf) {
        KNode.getNodeValue((NodeTree)this.sequence, this.ipos, sbuf);
    }

    @Override
    public boolean hasChildNodes() {
        return ((NodeTree)this.sequence).posFirstChild(this.ipos) >= 0;
    }

    @Override
    public String getTextContent() {
        StringBuffer sbuf = new StringBuffer();
        this.getTextContent(sbuf);
        return sbuf.toString();
    }

    protected void getTextContent(StringBuffer sbuf) {
        this.getNodeValue(sbuf);
    }

    @Override
    public Node getParentNode() {
        int parent = ((NodeTree)this.sequence).parentPos(this.ipos);
        if (parent == -1) {
            return null;
        }
        return KNode.make((NodeTree)this.sequence, parent);
    }

    @Override
    public Node getPreviousSibling() {
        int parent = ((NodeTree)this.sequence).parentPos(this.ipos);
        if (parent == -1) {
            parent = 0;
        }
        int index = ((NodeTree)this.sequence).posToDataIndex(this.ipos);
        int child = ((NodeTree)this.sequence).firstChildPos(parent);
        int previous = 0;
        do {
            previous = child;
        } while ((child = ((NodeTree)this.sequence).nextPos(child)) != 0 && ((NodeTree)this.sequence).posToDataIndex(child) != index);
        return previous == 0 ? null : KNode.make((NodeTree)this.sequence, previous);
    }

    @Override
    public Node getNextSibling() {
        int next = ((NodeTree)this.sequence).nextPos(this.ipos);
        return next == 0 ? null : KNode.make((NodeTree)this.sequence, next);
    }

    @Override
    public Node getFirstChild() {
        int child = ((NodeTree)this.sequence).posFirstChild(this.ipos);
        return KNode.make((NodeTree)this.sequence, child);
    }

    @Override
    public Node getLastChild() {
        int last = 0;
        int child = ((NodeTree)this.sequence).firstChildPos(this.ipos);
        while (child != 0) {
            last = child;
            child = ((NodeTree)this.sequence).nextPos(child);
        }
        return last == 0 ? null : KNode.make((NodeTree)this.sequence, last);
    }

    @Override
    public NodeList getChildNodes() {
        SortedNodes nodes = new SortedNodes();
        int child = ((NodeTree)this.sequence).firstChildPos(this.ipos);
        while (child != 0) {
            ((Nodes)nodes).writePosition(this.sequence, child);
            child = ((NodeTree)this.sequence).nextPos(child);
        }
        return nodes;
    }

    public NodeList getElementsByTagName(String tagname) {
        throw new UnsupportedOperationException("getElementsByTagName not implemented yet");
    }

    @Override
    public void setNodeValue(String nodeValue) throws DOMException {
        throw new DOMException(7, "setNodeValue not supported");
    }

    @Override
    public void setPrefix(String prefix) throws DOMException {
        throw new DOMException(7, "setPrefix not supported");
    }

    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        throw new DOMException(7, "insertBefore not supported");
    }

    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        throw new DOMException(7, "replaceChild not supported");
    }

    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        throw new DOMException(7, "removeChild not supported");
    }

    @Override
    public Node appendChild(Node newChild) throws DOMException {
        throw new DOMException(7, "appendChild not supported");
    }

    @Override
    public void setTextContent(String textContent) throws DOMException {
        throw new DOMException(7, "setTextContent not supported");
    }

    @Override
    public Node cloneNode(boolean deep) {
        if (!deep) {
            throw new UnsupportedOperationException("shallow cloneNode not implemented");
        }
        NodeTree tree = new NodeTree();
        ((NodeTree)this.sequence).consumeNext(this.ipos, tree);
        return KNode.make(tree);
    }

    @Override
    public Document getOwnerDocument() {
        int kind = ((NodeTree)this.sequence).getNextKind(this.ipos);
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
    public boolean isDefaultNamespace(String namespaceURI) {
        return ((NodeTree)this.sequence).posIsDefaultNamespace(this.ipos, namespaceURI);
    }

    @Override
    public String lookupNamespaceURI(String prefix) {
        return ((NodeTree)this.sequence).posLookupNamespaceURI(this.ipos, prefix);
    }

    @Override
    public String lookupPrefix(String namespaceURI) {
        return ((NodeTree)this.sequence).posLookupPrefix(this.ipos, namespaceURI);
    }

    @Override
    public String getBaseURI() {
        Path uri = ((NodeTree)this.sequence).baseUriOfPos(this.ipos, true);
        return uri == null ? null : uri.toString();
    }

    public Path baseURI() {
        return ((NodeTree)this.sequence).baseUriOfPos(this.ipos, true);
    }

    @Override
    public short compareDocumentPosition(Node other) throws DOMException {
        if (!(other instanceof KNode)) {
            throw new DOMException(9, "other Node is a " + other.getClass().getName());
        }
        KNode n = (KNode)other;
        AbstractSequence nseq = n.sequence;
        return (short)(this.sequence == nseq ? nseq.compare(this.ipos, n.ipos) : ((NodeTree)this.sequence).stableCompare(nseq));
    }

    @Override
    public boolean isSameNode(Node node) {
        if (!(node instanceof KNode)) {
            return false;
        }
        KNode n = (KNode)node;
        if (this.sequence != n.sequence) {
            return false;
        }
        return ((NodeTree)this.sequence).equals(this.ipos, n.ipos);
    }

    @Override
    public boolean isEqualNode(Node node) {
        throw new UnsupportedOperationException("getAttributesisEqualNode not implemented yet");
    }

    @Override
    public String toString() {
        CharArrayOutPort wr = new CharArrayOutPort();
        XMLPrinter xp = XMLPrinter.make(wr, "xhtml");
        ((NodeTree)this.sequence).consumeNext(this.ipos, xp);
        xp.close();
        wr.close();
        return wr.toString();
    }

    @Override
    public Object getFeature(String feature, String version) {
        return null;
    }

    @Override
    public void consume(Consumer out) {
        if (out instanceof PositionConsumer) {
            ((PositionConsumer)((Object)out)).writePosition(this);
        } else {
            ((NodeTree)this.sequence).consumeNext(this.ipos, out);
        }
    }

    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        throw new UnsupportedOperationException("setUserData not implemented yet");
    }

    @Override
    public Object getUserData(String key) {
        return null;
    }
}

