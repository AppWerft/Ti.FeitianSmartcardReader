// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.SimpleVector;
import java.io.IOException;
import org.w3c.dom.Node;
import gnu.lists.TreeList;
import gnu.lists.AbstractSequence;
import java.util.List;
import gnu.xml.XMLFilter;
import gnu.xml.NodeTree;
import gnu.lists.Consumer;
import org.w3c.dom.NodeList;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.mapping.Values;

public class Nodes extends FromList<SeqPosition> implements PositionConsumer, NodeList, Consumer
{
    protected NodeVector vector;
    int nesting;
    boolean inAttribute;
    NodeTree curNode;
    XMLFilter curFragment;
    
    private Nodes(final NodeVector nvector) {
        super(nvector);
        this.nesting = 0;
        this.vector = nvector;
    }
    
    public Nodes() {
        this(new NodeVector());
    }
    
    @Override
    public Consumer append(final char c) {
        this.maybeStartTextNode();
        this.curFragment.append(c);
        return this;
    }
    
    @Override
    public Consumer append(final CharSequence csq) {
        this.maybeStartTextNode();
        this.curFragment.append(csq);
        return this;
    }
    
    @Override
    public boolean ignoring() {
        return false;
    }
    
    @Override
    public void writePosition(final AbstractSequence seq, final int ipos) {
        this.vector.writePosition(seq, ipos);
    }
    
    @Override
    public void writePosition(final SeqPosition position) {
        this.vector.writePosition(position);
    }
    
    @Override
    public void writeObject(final Object v) {
        if (this.curFragment != null) {
            if (this.nesting != 0 || (!(v instanceof SeqPosition) && !(v instanceof TreeList))) {
                this.curFragment.writeObject(v);
                return;
            }
            this.finishFragment();
        }
        if (v instanceof SeqPosition) {
            this.writePosition((SeqPosition)v);
            return;
        }
        if (v instanceof TreeList) {
            final TreeList tlist = (TreeList)v;
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
    public void writeFloat(final float v) {
        this.handleNonNode();
        this.curFragment.writeFloat(v);
    }
    
    @Override
    public void writeDouble(final double v) {
        this.handleNonNode();
        this.curFragment.writeDouble(v);
    }
    
    @Override
    public void writeLong(final long v) {
        this.handleNonNode();
        this.curFragment.writeLong(v);
    }
    
    @Override
    public void writeInt(final int v) {
        this.handleNonNode();
        this.curFragment.writeInt(v);
    }
    
    @Override
    public void writeBoolean(final boolean v) {
        this.handleNonNode();
        this.curFragment.writeBoolean(v);
    }
    
    @Override
    public void write(final int v) {
        this.maybeStartTextNode();
        this.curFragment.write(v);
    }
    
    @Override
    public Consumer append(final CharSequence csq, final int start, final int end) {
        this.maybeStartTextNode();
        this.curFragment.append(csq, start, end);
        return this;
    }
    
    @Override
    public void write(final char[] buf, final int off, final int len) {
        this.maybeStartTextNode();
        this.curFragment.write(buf, off, len);
    }
    
    @Override
    public void write(final CharSequence str, final int start, final int length) {
        this.maybeStartTextNode();
        this.curFragment.write(str, start, length);
    }
    
    @Override
    public void write(final String str) {
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
        final int nesting = this.nesting - 1;
        this.nesting = nesting;
        if (nesting == 0) {
            this.finishFragment();
        }
    }
    
    @Override
    public void startElement(final Object type) {
        this.maybeStartNonTextNode();
        this.curFragment.startElement(type);
    }
    
    @Override
    public void endElement() {
        this.curFragment.endElement();
        this.maybeEndNonTextNode();
    }
    
    @Override
    public void startAttribute(final Object attrType) {
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
    
    public void writeComment(final char[] chars, final int offset, final int length) {
        this.maybeStartNonTextNode();
        this.curFragment.writeComment(chars, offset, length);
        this.maybeEndNonTextNode();
    }
    
    public void writeCDATA(final char[] chars, final int offset, final int length) {
        this.maybeStartNonTextNode();
        this.curFragment.writeCDATA(chars, offset, length);
    }
    
    public void writeProcessingInstruction(final String target, final char[] content, final int offset, final int length) {
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
    
    public void beginEntity(final Object base) {
        this.maybeStartNonTextNode();
        this.curFragment.beginEntity(base);
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
    public Node item(final int index) {
        if (index >= this.size()) {
            return null;
        }
        return ((FromList<Node>)this).get(index);
    }
    
    public AbstractSequence getSeq(final int index) {
        if (index >= this.vector.size()) {
            return null;
        }
        return this.vector.getSeq(index);
    }
    
    public int getPos(final int index) {
        return this.vector.getPos(index);
    }
    
    @Override
    public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
        this.vector.consumePosRange(iposStart, iposEnd, out);
    }
    
    public static KNode root(final NodeTree seq, final int ipos) {
        int root;
        if (seq.gapStart > 5 && seq.data[0] == '\uf112') {
            root = 10;
        }
        else {
            root = 0;
        }
        return KNode.make(seq, root);
    }
    
    public static class NodeVector extends SimpleVector<SeqPosition> implements PositionConsumer
    {
        Object[] odata;
        int[] idata;
        
        int getLastIndex() {
            return this.getGapStart() - 1;
        }
        
        @Override
        public int getBufferLength() {
            return (this.odata == null) ? 0 : this.odata.length;
        }
        
        @Override
        public void copyBuffer(int length) {
            this.checkCanWrite();
            int oldLength = (this.odata == null) ? 0 : this.odata.length;
            if (length == -1) {
                length = oldLength;
            }
            if (oldLength != length) {
                if (oldLength > length) {
                    oldLength = length;
                }
                final Object[] otmp = new Object[length];
                final int[] itmp = new int[length];
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
        protected void setBuffer(final Object buffer) {
            throw new Error();
        }
        
        @Override
        public SeqPosition getRaw(final int index) {
            final Object obj = this.odata[index];
            if (obj instanceof SeqPosition) {
                return (SeqPosition)obj;
            }
            return makeSeqPos((AbstractSequence)obj, this.idata[index]);
        }
        
        public AbstractSequence getSeq(final int index) {
            return this.getSeqRaw(this.effectiveIndex(index));
        }
        
        public AbstractSequence getSeqRaw(final int index) {
            final Object obj = this.odata[index];
            if (obj instanceof SeqPosition) {
                return ((SeqPosition)obj).sequence;
            }
            return (AbstractSequence)obj;
        }
        
        public int getPos(final int index) {
            return this.getPosRaw(this.effectiveIndex(index));
        }
        
        public int getPosRaw(final int index) {
            final Object obj = this.odata[index];
            if (obj instanceof SeqPosition) {
                return ((SeqPosition)obj).ipos;
            }
            return this.idata[index];
        }
        
        protected static SeqPosition makeSeqPos(final AbstractSequence seq, final int ipos) {
            if (seq instanceof NodeTree) {
                return KNode.make((NodeTree)seq, ipos);
            }
            return new SeqPosition((ESEQ)seq, ipos);
        }
        
        @Override
        public void setRaw(final int index, final SeqPosition value) {
            this.checkCanWrite();
            this.odata[index] = value;
            this.idata[index] = 0;
        }
        
        protected void setBuffer(final int index, final AbstractSequence seq, final int ipos) {
            this.checkCanWrite();
            this.odata[index] = seq;
            this.idata[index] = ipos;
        }
        
        @Override
        protected void clearBuffer(int start, int count) {
            this.checkCanWrite();
            final Object[] d = this.odata;
            while (--count >= 0) {
                d[start++] = null;
            }
        }
        
        @Override
        protected NodeVector newInstance(final int newLength) {
            final NodeVector nvec = new NodeVector();
            if (newLength < 0) {
                nvec.odata = this.odata;
                nvec.idata = this.idata;
            }
            else {
                nvec.odata = new Object[newLength];
                nvec.idata = new int[newLength];
            }
            return nvec;
        }
        
        @Override
        public void writePosition(final SeqPosition seq) {
            this.add(seq);
        }
        
        @Override
        public void writePosition(final AbstractSequence seq, final int ipos) {
            final int sz = this.size();
            this.add(null);
            this.odata[sz] = seq;
            this.idata[sz] = ipos;
        }
        
        @Override
        public void shift(final int srcStart, final int dstStart, final int count) {
            this.checkCanWrite();
            System.arraycopy(this.odata, srcStart, this.odata, dstStart, count);
            System.arraycopy(this.idata, srcStart, this.idata, dstStart, count);
        }
        
        @Override
        public void consumePosRange(final int iposStart, final int iposEnd, final Consumer out) {
            if (out.ignoring()) {
                return;
            }
            int i = this.nextIndex(iposStart);
            int end = this.nextIndex(iposEnd);
            final int size = this.size();
            if (end > size) {
                end = size;
            }
            while (i < end) {
                final int ii = this.effectiveIndex(i);
                if (out instanceof PositionConsumer) {
                    final PositionConsumer pout = (PositionConsumer)out;
                    final Object obj = this.odata[ii];
                    if (obj instanceof SeqPosition) {
                        pout.writePosition((SeqPosition)obj);
                    }
                    else {
                        pout.writePosition((AbstractSequence)obj, this.idata[ii]);
                    }
                }
                else {
                    out.writeObject(this.getRaw(ii));
                }
                ++i;
            }
        }
    }
}
