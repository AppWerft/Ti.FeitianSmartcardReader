/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.kawa.xml.KNode;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.SimpleVector;
import gnu.lists.TreeList;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
import gnu.xml.XMLFilter;
import java.io.IOException;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Nodes
extends Values.FromList<SeqPosition>
implements PositionConsumer,
NodeList,
Consumer {
    protected NodeVector vector;
    int nesting = 0;
    boolean inAttribute;
    NodeTree curNode;
    XMLFilter curFragment;

    private Nodes(NodeVector nvector) {
        super(nvector);
        this.vector = nvector;
    }

    public Nodes() {
        this(new NodeVector());
    }

    @Override
    public Consumer append(char c) {
        this.maybeStartTextNode();
        this.curFragment.append(c);
        return this;
    }

    @Override
    public Consumer append(CharSequence csq) {
        this.maybeStartTextNode();
        this.curFragment.append(csq);
        return this;
    }

    @Override
    public boolean ignoring() {
        return false;
    }

    @Override
    public void writePosition(AbstractSequence seq, int ipos) {
        this.vector.writePosition(seq, ipos);
    }

    @Override
    public void writePosition(SeqPosition position) {
        this.vector.writePosition(position);
    }

    @Override
    public void writeObject(Object v) {
        if (this.curFragment != null) {
            if (this.nesting == 0 && (v instanceof SeqPosition || v instanceof TreeList)) {
                this.finishFragment();
            } else {
                this.curFragment.writeObject(v);
                return;
            }
        }
        if (v instanceof SeqPosition) {
            this.writePosition((SeqPosition)v);
            return;
        }
        if (v instanceof TreeList) {
            TreeList tlist = (TreeList)v;
            this.writePosition(tlist, 0);
            return;
        }
        this.handleNonNode();
        this.curFragment.writeObject(v);
    }

    void maybeStartTextNode() {
        if (this.curFragment == null) {
            throw new IllegalArgumentException("non-node where node required");
        }
    }

    void handleNonNode() {
        if (this.curFragment == null) {
            throw new ClassCastException("atomic value where node is required");
        }
    }

    @Override
    public void writeFloat(float v) {
        this.handleNonNode();
        this.curFragment.writeFloat(v);
    }

    @Override
    public void writeDouble(double v) {
        this.handleNonNode();
        this.curFragment.writeDouble(v);
    }

    @Override
    public void writeLong(long v) {
        this.handleNonNode();
        this.curFragment.writeLong(v);
    }

    @Override
    public void writeInt(int v) {
        this.handleNonNode();
        this.curFragment.writeInt(v);
    }

    @Override
    public void writeBoolean(boolean v) {
        this.handleNonNode();
        this.curFragment.writeBoolean(v);
    }

    @Override
    public void write(int v) {
        this.maybeStartTextNode();
        this.curFragment.write(v);
    }

    @Override
    public Consumer append(CharSequence csq, int start, int end) {
        this.maybeStartTextNode();
        this.curFragment.append(csq, start, end);
        return this;
    }

    @Override
    public void write(char[] buf, int off, int len) {
        this.maybeStartTextNode();
        this.curFragment.write(buf, off, len);
    }

    @Override
    public void write(CharSequence str, int start, int length) {
        this.maybeStartTextNode();
        this.curFragment.write(str, start, length);
    }

    @Override
    public void write(String str) {
        this.maybeStartTextNode();
        this.curFragment.write(str);
    }

    private void maybeStartNonTextNode() {
        if (this.curFragment != null && this.nesting == 0) {
            this.finishFragment();
        }
        if (this.curFragment == null) {
            this.startFragment();
        }
        ++this.nesting;
    }

    private void maybeEndNonTextNode() {
        if (--this.nesting == 0) {
            this.finishFragment();
        }
    }

    @Override
    public void startElement(Object type) {
        this.maybeStartNonTextNode();
        this.curFragment.startElement(type);
    }

    @Override
    public void endElement() {
        this.curFragment.endElement();
        this.maybeEndNonTextNode();
    }

    @Override
    public void startAttribute(Object attrType) {
        this.maybeStartNonTextNode();
        this.curFragment.startAttribute(attrType);
        this.inAttribute = true;
    }

    @Override
    public void endAttribute() {
        if (!this.inAttribute) {
            return;
        }
        this.inAttribute = false;
        this.curFragment.endAttribute();
        this.maybeEndNonTextNode();
    }

    public void writeComment(char[] chars, int offset, int length) {
        this.maybeStartNonTextNode();
        this.curFragment.writeComment(chars, offset, length);
        this.maybeEndNonTextNode();
    }

    public void writeCDATA(char[] chars, int offset, int length) {
        this.maybeStartNonTextNode();
        this.curFragment.writeCDATA(chars, offset, length);
    }

    public void writeProcessingInstruction(String target, char[] content, int offset, int length) {
        this.maybeStartNonTextNode();
        this.curFragment.writeProcessingInstruction(target, content, offset, length);
        this.maybeEndNonTextNode();
    }

    @Override
    public void startDocument() {
        this.maybeStartNonTextNode();
        this.curFragment.startDocument();
    }

    @Override
    public void endDocument() {
        this.curFragment.endDocument();
        this.maybeEndNonTextNode();
    }

    public void beginEntity(Object base2) {
        this.maybeStartNonTextNode();
        this.curFragment.beginEntity(base2);
    }

    public void endEntity() {
        this.curFragment.endEntity();
        this.maybeEndNonTextNode();
    }

    void startFragment() {
        this.curNode = new NodeTree();
        this.curFragment = new XMLFilter(this.curNode);
        this.writePosition(this.curNode, 0);
    }

    void finishFragment() {
        this.curNode = null;
        this.curFragment = null;
    }

    @Override
    public int getLength() {
        return this.size();
    }

    @Override
    public Node item(int index) {
        if (index >= this.size()) {
            return null;
        }
        return (Node)this.get(index);
    }

    public AbstractSequence getSeq(int index) {
        if (index >= this.vector.size()) {
            return null;
        }
        return this.vector.getSeq(index);
    }

    public int getPos(int index) {
        return this.vector.getPos(index);
    }

    @Override
    public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
        this.vector.consumePosRange(iposStart, iposEnd, out);
    }

    public static KNode root(NodeTree seq, int ipos) {
        int root = seq.gapStart > 5 && seq.data[0] == '\uf112' ? 10 : 0;
        return KNode.make(seq, root);
    }

    public static class NodeVector
    extends SimpleVector<SeqPosition>
    implements PositionConsumer {
        Object[] odata;
        int[] idata;

        int getLastIndex() {
            return this.getGapStart() - 1;
        }

        @Override
        public int getBufferLength() {
            return this.odata == null ? 0 : this.odata.length;
        }

        @Override
        public void copyBuffer(int length) {
            int oldLength;
            this.checkCanWrite();
            int n = oldLength = this.odata == null ? 0 : this.odata.length;
            if (length == -1) {
                length = oldLength;
            }
            if (oldLength != length) {
                if (oldLength > length) {
                    oldLength = length;
                }
                Object[] otmp = new Object[length];
                int[] itmp = new int[length];
                if (oldLength != 0) {
                    System.arraycopy(this.odata, 0, otmp, 0, oldLength);
                    System.arraycopy(this.idata, 0, itmp, 0, oldLength);
                }
                this.odata = otmp;
                this.idata = itmp;
            }
        }

        @Override
        protected Object getBuffer() {
            throw new Error();
        }

        @Override
        protected void setBuffer(Object buffer) {
            throw new Error();
        }

        @Override
        public SeqPosition getRaw(int index) {
            Object obj = this.odata[index];
            if (obj instanceof SeqPosition) {
                return (SeqPosition)obj;
            }
            return NodeVector.makeSeqPos((AbstractSequence)obj, this.idata[index]);
        }

        public AbstractSequence getSeq(int index) {
            return this.getSeqRaw(this.effectiveIndex(index));
        }

        public AbstractSequence getSeqRaw(int index) {
            Object obj = this.odata[index];
            if (obj instanceof SeqPosition) {
                return ((SeqPosition)obj).sequence;
            }
            return (AbstractSequence)obj;
        }

        public int getPos(int index) {
            return this.getPosRaw(this.effectiveIndex(index));
        }

        public int getPosRaw(int index) {
            Object obj = this.odata[index];
            if (obj instanceof SeqPosition) {
                return ((SeqPosition)obj).ipos;
            }
            return this.idata[index];
        }

        protected static SeqPosition makeSeqPos(AbstractSequence seq, int ipos) {
            if (seq instanceof NodeTree) {
                return KNode.make((NodeTree)seq, ipos);
            }
            return new SeqPosition(seq, ipos);
        }

        @Override
        public void setRaw(int index, SeqPosition value) {
            this.checkCanWrite();
            this.odata[index] = value;
            this.idata[index] = 0;
        }

        protected void setBuffer(int index, AbstractSequence seq, int ipos) {
            this.checkCanWrite();
            this.odata[index] = seq;
            this.idata[index] = ipos;
        }

        @Override
        protected void clearBuffer(int start, int count) {
            this.checkCanWrite();
            Object[] d = this.odata;
            while (--count >= 0) {
                d[start++] = null;
            }
        }

        @Override
        protected NodeVector newInstance(int newLength) {
            NodeVector nvec = new NodeVector();
            if (newLength < 0) {
                nvec.odata = this.odata;
                nvec.idata = this.idata;
            } else {
                nvec.odata = new Object[newLength];
                nvec.idata = new int[newLength];
            }
            return nvec;
        }

        @Override
        public void writePosition(SeqPosition seq) {
            this.add(seq);
        }

        @Override
        public void writePosition(AbstractSequence seq, int ipos) {
            int sz = this.size();
            this.add(null);
            this.odata[sz] = seq;
            this.idata[sz] = ipos;
        }

        @Override
        public void shift(int srcStart, int dstStart, int count) {
            this.checkCanWrite();
            System.arraycopy(this.odata, srcStart, this.odata, dstStart, count);
            System.arraycopy(this.idata, srcStart, this.idata, dstStart, count);
        }

        @Override
        public void consumePosRange(int iposStart, int iposEnd, Consumer out) {
            int size;
            if (out.ignoring()) {
                return;
            }
            int i = this.nextIndex(iposStart);
            int end = this.nextIndex(iposEnd);
            if (end > (size = this.size())) {
                end = size;
            }
            while (i < end) {
                int ii = this.effectiveIndex(i);
                if (out instanceof PositionConsumer) {
                    PositionConsumer pout = (PositionConsumer)((Object)out);
                    Object obj = this.odata[ii];
                    if (obj instanceof SeqPosition) {
                        pout.writePosition((SeqPosition)obj);
                    } else {
                        pout.writePosition((AbstractSequence)obj, this.idata[ii]);
                    }
                } else {
                    out.writeObject(this.getRaw(ii));
                }
                ++i;
            }
        }
    }

}

