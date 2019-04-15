/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.AbstractSequence;
import gnu.lists.AttributePredicate;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.Convert;
import gnu.lists.ElementPredicate;
import gnu.lists.ItemPredicate;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.Sequence;
import gnu.lists.TreePosition;
import gnu.lists.XConsumer;
import gnu.text.Char;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TreeList
extends AbstractSequence<Object>
implements Appendable,
XConsumer,
PositionConsumer,
Consumable {
    public Object[] objects;
    public int oindex;
    public char[] data;
    public int gapStart;
    public int gapEnd;
    public int attrStart;
    public int docStart;
    public static final int MAX_CHAR_SHORT = 40959;
    static final int MIN_INT_SHORT = -4096;
    static final int MAX_INT_SHORT = 8191;
    static final int INT_SHORT_ZERO = 49152;
    static final int OBJECT_REF_SHORT = 57344;
    static final int OBJECT_REF_SHORT_INDEX_MAX = 4095;
    static final char OBJECT_REF_FOLLOWS = '\uf10d';
    static final char POSITION_REF_FOLLOWS = '\uf10e';
    protected static final char POSITION_PAIR_FOLLOWS = '\uf10f';
    static final int BYTE_PREFIX = 61440;
    static final char BOOL_FALSE = '\uf100';
    static final char BOOL_TRUE = '\uf101';
    public static final int INT_FOLLOWS = 61698;
    static final int LONG_FOLLOWS = 61699;
    static final int FLOAT_FOLLOWS = 61700;
    static final int DOUBLE_FOLLOWS = 61701;
    static final int CHAR_FOLLOWS = 61702;
    static final int COMMENT = 61719;
    protected static final int PROCESSING_INSTRUCTION = 61716;
    static final int CDATA_SECTION = 61717;
    static final int JOINER = 61718;
    protected static final int BEGIN_ATTRIBUTE_LONG = 61705;
    public static final int BEGIN_ATTRIBUTE_LONG_SIZE = 5;
    static final int END_ATTRIBUTE = 61706;
    public static final int END_ATTRIBUTE_SIZE = 1;
    protected static final int BEGIN_DOCUMENT = 61712;
    protected static final int END_DOCUMENT = 61713;
    public static final int BEGIN_ENTITY = 61714;
    public static final int BEGIN_ENTITY_SIZE = 5;
    protected static final int END_ENTITY = 61715;
    protected static final int DOCUMENT_URI = 61720;
    protected static final int BEGIN_ELEMENT_SHORT = 40960;
    protected static final int BEGIN_ELEMENT_SHORT_INDEX_MAX = 4095;
    protected static final int END_ELEMENT_SHORT = 61707;
    protected static final int BEGIN_ELEMENT_LONG = 61704;
    protected static final int END_ELEMENT_LONG = 61708;
    int currentParent = -1;

    public TreeList() {
        this.resizeObjects();
        this.gapEnd = 200;
        this.data = new char[this.gapEnd];
    }

    public TreeList(TreeList list, int startPosition, int endPosition) {
        this();
        list.consumeIRange(startPosition, endPosition, this);
    }

    public TreeList(TreeList list) {
        this(list, 0, list.data.length);
    }

    @Override
    public void clear() {
        this.gapStart = 0;
        this.gapEnd = this.data.length;
        this.attrStart = 0;
        if (this.gapEnd > 1500) {
            this.gapEnd = 200;
            this.data = new char[this.gapEnd];
        }
        this.objects = null;
        this.oindex = 0;
        this.resizeObjects();
    }

    public void ensureSpace(int needed) {
        int avail = this.gapEnd - this.gapStart;
        if (needed > avail) {
            int afterGap;
            int oldSize = this.data.length;
            int newSize = 2 * oldSize;
            int neededSize = oldSize - avail + needed;
            if (newSize < neededSize) {
                newSize = neededSize;
            }
            char[] tmp = new char[newSize];
            if (this.gapStart > 0) {
                System.arraycopy(this.data, 0, tmp, 0, this.gapStart);
            }
            if ((afterGap = oldSize - this.gapEnd) > 0) {
                System.arraycopy(this.data, this.gapEnd, tmp, newSize - afterGap, afterGap);
            }
            this.gapEnd = newSize - afterGap;
            this.data = tmp;
        }
    }

    public final void resizeObjects() {
        Object[] tmp;
        if (this.objects == null) {
            boolean oldLength = false;
            int newLength = 100;
            tmp = new Object[newLength];
        } else {
            int oldLength = this.objects.length;
            int newLength = 2 * oldLength;
            tmp = new Object[newLength];
            System.arraycopy(this.objects, 0, tmp, 0, oldLength);
        }
        this.objects = tmp;
    }

    public int find(Object arg1) {
        if (this.oindex == this.objects.length) {
            this.resizeObjects();
        }
        this.objects[this.oindex] = arg1;
        return this.oindex++;
    }

    protected final int getIntN(int index) {
        return this.data[index] << 16 | this.data[index + 1] & 65535;
    }

    protected final long getLongN(int index) {
        char[] data = this.data;
        return ((long)data[index] & 65535L) << 48 | ((long)data[index + 1] & 65535L) << 32 | ((long)data[index + 2] & 65535L) << 16 | (long)data[index + 3] & 65535L;
    }

    public final void setIntN(int index, int i) {
        this.data[index] = (char)(i >> 16);
        this.data[index + 1] = (char)i;
    }

    @Override
    public void writePosition(SeqPosition position) {
        this.ensureSpace(3);
        int index = this.find(position.copy());
        this.data[this.gapStart++] = 61710;
        this.setIntN(this.gapStart, index);
        this.gapStart += 2;
    }

    @Override
    public void writePosition(AbstractSequence seq, int ipos) {
        this.ensureSpace(5);
        this.data[this.gapStart] = 61711;
        int seq_index = this.find(seq);
        this.setIntN(this.gapStart + 1, seq_index);
        this.setIntN(this.gapStart + 3, ipos);
        this.gapStart += 5;
    }

    @Override
    public void writeObject(Object v) {
        int index;
        if (this.gapEnd - this.gapStart < 3) {
            this.ensureSpace(3);
        }
        if ((index = this.find(v)) < 4096) {
            this.data[this.gapStart++] = (char)(57344 | index);
        } else {
            this.data[this.gapStart++] = 61709;
            this.setIntN(this.gapStart, index);
            this.gapStart += 2;
        }
    }

    public void writeDocumentUri(Object uri) {
        this.ensureSpace(3);
        int index = this.find(uri);
        this.data[this.gapStart++] = 61720;
        this.setIntN(this.gapStart, index);
        this.gapStart += 2;
    }

    @Override
    public void writeComment(char[] chars, int offset, int length) {
        this.ensureSpace(3 + length);
        int i = this.gapStart;
        this.data[i++] = 61719;
        this.setIntN(i, length);
        System.arraycopy(chars, offset, this.data, i += 2, length);
        this.gapStart = i + length;
    }

    public void writeComment(String comment, int offset, int length) {
        this.ensureSpace(3 + length);
        int i = this.gapStart;
        this.data[i++] = 61719;
        this.setIntN(i, length);
        comment.getChars(offset, offset + length, this.data, i += 2);
        this.gapStart = i + length;
    }

    @Override
    public void writeProcessingInstruction(String target, char[] content, int offset, int length) {
        this.ensureSpace(5 + length);
        int i = this.gapStart;
        this.data[i++] = 61716;
        int index = this.find(target);
        this.setIntN(i, index);
        this.setIntN(i + 2, length);
        System.arraycopy(content, offset, this.data, i += 4, length);
        this.gapStart = i + length;
    }

    public void writeProcessingInstruction(String target, String content, int offset, int length) {
        this.ensureSpace(5 + length);
        int i = this.gapStart;
        this.data[i++] = 61716;
        int index = this.find(target);
        this.setIntN(i, index);
        this.setIntN(i + 2, length);
        content.getChars(offset, offset + length, this.data, i += 4);
        this.gapStart = i + length;
    }

    @Override
    public void startElement(Object type) {
        this.startElement(this.find(type));
    }

    @Override
    public void startDocument() {
        this.ensureSpace(6);
        --this.gapEnd;
        int p = this.gapStart;
        this.data[p] = 61712;
        if (this.docStart != 0) {
            throw new Error("nested document");
        }
        this.docStart = p + 1;
        this.setIntN(p + 1, this.gapEnd - this.data.length);
        this.setIntN(p + 3, this.currentParent == -1 ? -1 : this.currentParent - p);
        this.currentParent = p;
        this.gapStart = p + 5;
        this.currentParent = p;
        this.data[this.gapEnd] = 61713;
    }

    @Override
    public void endDocument() {
        if (this.data[this.gapEnd] != '\uf111' || this.docStart <= 0 || this.data[this.currentParent] != '\uf110') {
            throw new Error("unexpected endDocument");
        }
        ++this.gapEnd;
        this.setIntN(this.docStart, this.gapStart - this.docStart + 1);
        this.docStart = 0;
        this.data[this.gapStart++] = 61713;
        int parent = this.getIntN(this.currentParent + 3);
        this.currentParent = parent >= -1 ? parent : this.currentParent + parent;
    }

    @Override
    public void beginEntity(Object base2) {
        if (this.gapStart != 0) {
            return;
        }
        this.ensureSpace(6);
        --this.gapEnd;
        int p = this.gapStart;
        this.data[p] = 61714;
        this.setIntN(p + 1, this.find(base2));
        this.setIntN(p + 3, this.currentParent == -1 ? -1 : this.currentParent - p);
        this.gapStart = p + 5;
        this.currentParent = p;
        this.data[this.gapEnd] = 61715;
    }

    @Override
    public void endEntity() {
        if (this.gapEnd + 1 != this.data.length || this.data[this.gapEnd] != '\uf113') {
            return;
        }
        if (this.data[this.currentParent] != '\uf112') {
            throw new Error("unexpected endEntity");
        }
        ++this.gapEnd;
        this.data[this.gapStart++] = 61715;
        int parent = this.getIntN(this.currentParent + 3);
        this.currentParent = parent >= -1 ? parent : this.currentParent + parent;
    }

    public void startElement(int index) {
        this.ensureSpace(10);
        this.gapEnd -= 7;
        this.data[this.gapStart++] = 61704;
        this.setIntN(this.gapStart, this.gapEnd - this.data.length);
        this.gapStart += 2;
        this.data[this.gapEnd] = 61708;
        this.setIntN(this.gapEnd + 1, index);
        this.setIntN(this.gapEnd + 3, this.gapStart - 3);
        this.setIntN(this.gapEnd + 5, this.currentParent);
        this.currentParent = this.gapStart - 3;
    }

    public void setElementName(int elementIndex, int nameIndex) {
        if (this.data[elementIndex] == '\uf108') {
            int j;
            elementIndex = j + ((j = this.getIntN(elementIndex + 1)) < 0 ? this.data.length : elementIndex);
        }
        if (elementIndex < this.gapEnd) {
            throw new Error("setElementName before gapEnd");
        }
        this.setIntN(elementIndex + 1, nameIndex);
    }

    @Override
    public void endElement() {
        int parent;
        if (this.data[this.gapEnd] != '\uf10c') {
            throw new Error("unexpected endElement");
        }
        int index = this.getIntN(this.gapEnd + 1);
        int begin2 = this.getIntN(this.gapEnd + 3);
        this.currentParent = parent = this.getIntN(this.gapEnd + 5);
        this.gapEnd += 7;
        int offset = this.gapStart - begin2;
        int parentOffset = begin2 - parent;
        if (index < 4095 && offset < 65536 && parentOffset < 65536) {
            this.data[begin2] = (char)(40960 | index);
            this.data[begin2 + 1] = (char)offset;
            this.data[begin2 + 2] = (char)parentOffset;
            this.data[this.gapStart] = 61707;
            this.data[this.gapStart + 1] = (char)offset;
            this.gapStart += 2;
        } else {
            this.data[begin2] = 61704;
            this.setIntN(begin2 + 1, offset);
            this.data[this.gapStart] = 61708;
            this.setIntN(this.gapStart + 1, index);
            this.setIntN(this.gapStart + 3, -offset);
            if (parent >= this.gapStart || begin2 <= this.gapStart) {
                parent -= this.gapStart;
            }
            this.setIntN(this.gapStart + 5, parent);
            this.gapStart += 7;
        }
    }

    @Override
    public void startAttribute(Object attrType) {
        this.startAttribute(this.find(attrType));
    }

    public void startAttribute(int index) {
        this.ensureSpace(6);
        --this.gapEnd;
        this.data[this.gapStart++] = 61705;
        if (this.attrStart != 0) {
            throw new Error("nested attribute");
        }
        this.attrStart = this.gapStart;
        this.setIntN(this.gapStart, index);
        this.setIntN(this.gapStart + 2, this.gapEnd - this.data.length);
        this.gapStart += 4;
        this.data[this.gapEnd] = 61706;
    }

    public void setAttributeName(int attrIndex, int nameIndex) {
        this.setIntN(attrIndex + 1, nameIndex);
    }

    @Override
    public void endAttribute() {
        if (this.attrStart <= 0) {
            return;
        }
        if (this.data[this.gapEnd] != '\uf10a') {
            throw new Error("unexpected endAttribute");
        }
        ++this.gapEnd;
        this.setIntN(this.attrStart + 2, this.gapStart - this.attrStart + 1);
        this.attrStart = 0;
        this.data[this.gapStart++] = 61706;
    }

    @Override
    public Consumer append(char c) {
        this.write(c);
        return this;
    }

    @Override
    public void write(int c) {
        this.ensureSpace(3);
        if (c <= 40959) {
            this.data[this.gapStart++] = (char)c;
        } else if (c < 65536) {
            this.data[this.gapStart++] = 61702;
            this.data[this.gapStart++] = (char)c;
        } else {
            Char.print(c, this);
        }
    }

    @Override
    public void writeBoolean(boolean v) {
        this.ensureSpace(1);
        this.data[this.gapStart++] = v ? 61697 : 61696;
    }

    public void writeByte(int v) {
        this.ensureSpace(1);
        this.data[this.gapStart++] = (char)(61440 + (v & 255));
    }

    @Override
    public void writeInt(int v) {
        this.ensureSpace(3);
        if (v >= -4096 && v <= 8191) {
            this.data[this.gapStart++] = (char)(49152 + v);
        } else {
            this.data[this.gapStart++] = 61698;
            this.setIntN(this.gapStart, v);
            this.gapStart += 2;
        }
    }

    @Override
    public void writeLong(long v) {
        this.ensureSpace(5);
        this.data[this.gapStart++] = 61699;
        this.data[this.gapStart++] = (char)(v >>> 48);
        this.data[this.gapStart++] = (char)(v >>> 32);
        this.data[this.gapStart++] = (char)(v >>> 16);
        this.data[this.gapStart++] = (char)v;
    }

    @Override
    public void writeFloat(float v) {
        this.ensureSpace(3);
        int i = Float.floatToIntBits(v);
        this.data[this.gapStart++] = 61700;
        this.data[this.gapStart++] = (char)(i >>> 16);
        this.data[this.gapStart++] = (char)i;
    }

    @Override
    public void writeDouble(double v) {
        this.ensureSpace(5);
        long l = Double.doubleToLongBits(v);
        this.data[this.gapStart++] = 61701;
        this.data[this.gapStart++] = (char)(l >>> 48);
        this.data[this.gapStart++] = (char)(l >>> 32);
        this.data[this.gapStart++] = (char)(l >>> 16);
        this.data[this.gapStart++] = (char)l;
    }

    @Override
    public boolean ignoring() {
        return false;
    }

    public void writeJoiner() {
        this.ensureSpace(1);
        this.data[this.gapStart++] = 61718;
    }

    @Override
    public void write(char[] buf, int off, int len) {
        if (len == 0) {
            this.writeJoiner();
        }
        this.ensureSpace(len);
        while (len > 0) {
            char ch = buf[off++];
            --len;
            if (ch <= '\u9fff') {
                this.data[this.gapStart++] = ch;
                continue;
            }
            this.write(ch);
            this.ensureSpace(len);
        }
    }

    @Override
    public void write(String str) {
        this.write(str, 0, str.length());
    }

    @Override
    public void write(CharSequence str, int start, int length) {
        if (length == 0) {
            this.writeJoiner();
        }
        this.ensureSpace(length);
        while (length > 0) {
            char ch = str.charAt(start++);
            --length;
            if (ch <= '\u9fff') {
                this.data[this.gapStart++] = ch;
                continue;
            }
            this.write(ch);
            this.ensureSpace(length);
        }
    }

    @Override
    public void writeCDATA(char[] chars, int offset, int length) {
        this.ensureSpace(3 + length);
        int i = this.gapStart;
        this.data[i++] = 61717;
        this.setIntN(i, length);
        System.arraycopy(chars, offset, this.data, i += 2, length);
        this.gapStart = i + length;
    }

    @Override
    public Consumer append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        return this.append(csq, 0, csq.length());
    }

    @Override
    public Consumer append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        for (int i = start; i < end; ++i) {
            this.append(csq.charAt(i));
        }
        return this;
    }

    @Override
    public boolean isEmpty() {
        int pos = this.gapStart == 0 ? this.gapEnd : 0;
        return pos == this.data.length;
    }

    @Override
    public int size() {
        int size = 0;
        int i = 0;
        while ((i = this.nextPos(i)) != 0) {
            ++size;
        }
        return size;
    }

    @Override
    public int createPos(int index, boolean isAfter) {
        return this.createRelativePos(0, index, isAfter);
    }

    public final int posToDataIndex(int ipos) {
        if (ipos == -1) {
            return this.data.length;
        }
        int index = ipos >>> 1;
        if ((ipos & 1) != 0) {
            --index;
        }
        if (index == this.gapStart) {
            index += this.gapEnd - this.gapStart;
        }
        if ((ipos & 1) != 0) {
            if ((index = this.nextDataIndex(index)) < 0) {
                return this.data.length;
            }
            if (index == this.gapStart) {
                index += this.gapEnd - this.gapStart;
            }
        }
        return index;
    }

    @Override
    public int firstChildPos(int ipos) {
        int index = this.gotoChildrenStart(this.posToDataIndex(ipos));
        if (index < 0) {
            return 0;
        }
        return index << 1;
    }

    public final int gotoChildrenStart(int index) {
        if (index == this.data.length) {
            return -1;
        }
        char datum = this.data[index];
        if (datum >= '\ua000' && datum <= '\uafff' || datum == '\uf108') {
            index += 3;
        } else if (datum == '\uf110' || datum == '\uf112') {
            index += 5;
        } else {
            return -1;
        }
        do {
            if (index >= this.gapStart) {
                index += this.gapEnd - this.gapStart;
            }
            if ((datum = this.data[index]) == '\uf109') {
                int end;
                index = end + ((end = this.getIntN(index + 3)) < 0 ? this.data.length : index);
                continue;
            }
            if (datum == '\uf10a' || datum == '\uf116') {
                ++index;
                continue;
            }
            if (datum != '\uf118') break;
            index += 3;
        } while (true);
        return index;
    }

    @Override
    public int parentPos(int ipos) {
        int index = this.posToDataIndex(ipos);
        do {
            if ((index = this.parentOrEntityI(index)) != -1) continue;
            return -1;
        } while (this.data[index] == '\uf112');
        return index << 1;
    }

    public int parentOrEntityPos(int ipos) {
        int index = this.parentOrEntityI(this.posToDataIndex(ipos));
        return index < 0 ? -1 : index << 1;
    }

    public int parentOrEntityI(int index) {
        if (index == this.data.length) {
            return -1;
        }
        char datum = this.data[index];
        if (datum == '\uf110' || datum == '\uf112') {
            int parent_offset = this.getIntN(index + 3);
            if (parent_offset >= -1) {
                return parent_offset;
            }
            return index + parent_offset;
        }
        if (datum >= '\ua000' && datum <= '\uafff') {
            char parent_offset = this.data[index + 2];
            return parent_offset == '\u0000' ? -1 : index - parent_offset;
        }
        if (datum == '\uf108') {
            int end_offset;
            int parent_offset;
            if ((parent_offset = this.getIntN((end_offset += (end_offset = this.getIntN(index + 1)) < 0 ? this.data.length : index) + 5)) == 0) {
                return -1;
            }
            if (parent_offset < 0) {
                parent_offset += end_offset;
            }
            return parent_offset;
        }
        block6 : do {
            if (index == this.gapStart) {
                index = this.gapEnd;
            }
            if (index == this.data.length) {
                return -1;
            }
            datum = this.data[index];
            switch (datum) {
                case '\uf10b': {
                    return index - this.data[index + 1];
                }
                case '\uf10c': {
                    int begin_offset = this.getIntN(index + 3);
                    if (begin_offset < 0) {
                        begin_offset += index;
                    }
                    return begin_offset;
                }
                case '\uf10a': {
                    ++index;
                    continue block6;
                }
                case '\uf111': {
                    return -1;
                }
            }
            if ((index = this.nextDataIndex(index)) < 0) break;
        } while (true);
        return -1;
    }

    public int getAttributeCount(int parent) {
        int n = 0;
        int attr = this.firstAttributePos(parent);
        while (attr != 0 && this.getNextKind(attr) == 35) {
            ++n;
            attr = this.nextPos(attr);
        }
        return n;
    }

    @Override
    public boolean gotoAttributesStart(TreePosition pos) {
        int index = this.gotoAttributesStart(pos.ipos >> 1);
        if (index < 0) {
            return false;
        }
        pos.push(this, index << 1);
        return true;
    }

    @Override
    public int firstAttributePos(int ipos) {
        int index = this.gotoAttributesStart(this.posToDataIndex(ipos));
        return index < 0 ? 0 : index << 1;
    }

    public int gotoAttributesStart(int index) {
        if (index >= this.gapStart) {
            index += this.gapEnd - this.gapStart;
        }
        if (index == this.data.length) {
            return -1;
        }
        char datum = this.data[index];
        if (datum >= '\ua000' && datum <= '\uafff' || datum == '\uf108') {
            return index + 3;
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        int i = 0;
        while (--index >= 0) {
            if ((i = this.nextPos(i)) != 0) continue;
            throw new IndexOutOfBoundsException();
        }
        return this.getPosNext(i);
    }

    @Override
    public boolean consumeNext(int ipos, Consumer out) {
        if (!this.hasNext(ipos)) {
            return false;
        }
        int start = this.posToDataIndex(ipos);
        int end = this.nextNodeIndex(start, Integer.MAX_VALUE);
        if (end == start) {
            end = this.nextDataIndex(start);
        }
        if (end >= 0) {
            this.consumeIRange(start, end, out);
        }
        return true;
    }

    @Override
    public void consumePosRange(int startPos, int endPos, Consumer out) {
        this.consumeIRange(this.posToDataIndex(startPos), this.posToDataIndex(endPos), out);
    }

    public int consumeIRange(int startPosition, int endPosition, Consumer out) {
        int pos;
        block41 : {
            int limit;
            char datum;
            pos = startPosition;
            int n = limit = startPosition <= this.gapStart && endPosition > this.gapStart ? this.gapStart : endPosition;
            block25 : do {
                int index;
                if (pos >= limit) {
                    if (pos != this.gapStart || endPosition <= this.gapEnd) break block41;
                    pos = this.gapEnd;
                    limit = endPosition;
                }
                if ((datum = this.data[pos++]) <= '\u9fff') {
                    int start = pos - 1;
                    int lim = limit;
                    while (pos < lim) {
                        if ((datum = this.data[pos++]) <= '\u9fff') continue;
                        --pos;
                        break;
                    }
                    out.write(this.data, start, pos - start);
                    continue;
                }
                if (datum >= '\ue000' && datum <= '\uefff') {
                    out.writeObject(this.objects[datum - 57344]);
                    continue;
                }
                if (datum >= '\ua000' && datum <= '\uafff') {
                    index = datum - 40960;
                    out.startElement(this.objects[index]);
                    pos += 2;
                    continue;
                }
                if (datum >= '\ub000' && datum <= '\udfff') {
                    out.writeInt(datum - 49152);
                    continue;
                }
                switch (datum) {
                    int length;
                    case '\uf110': {
                        out.startDocument();
                        pos += 4;
                        continue block25;
                    }
                    case '\uf111': {
                        out.endDocument();
                        continue block25;
                    }
                    case '\uf112': {
                        if (out instanceof TreeList) {
                            ((TreeList)out).beginEntity(this.objects[this.getIntN(pos)]);
                        }
                        pos += 4;
                        continue block25;
                    }
                    case '\uf113': {
                        if (!(out instanceof TreeList)) continue block25;
                        ((TreeList)out).endEntity();
                        continue block25;
                    }
                    case '\uf118': {
                        if (out instanceof TreeList) {
                            ((TreeList)out).writeDocumentUri(this.objects[this.getIntN(pos)]);
                        }
                        pos += 2;
                        continue block25;
                    }
                    case '\uf117': {
                        length = this.getIntN(pos);
                        pos += 2;
                        if (out instanceof XConsumer) {
                            ((XConsumer)out).writeComment(this.data, pos, length);
                        }
                        pos += length;
                        continue block25;
                    }
                    case '\uf115': {
                        length = this.getIntN(pos);
                        pos += 2;
                        if (out instanceof XConsumer) {
                            ((XConsumer)out).writeCDATA(this.data, pos, length);
                        } else {
                            out.write(this.data, pos, length);
                        }
                        pos += length;
                        continue block25;
                    }
                    case '\uf114': {
                        String target = (String)this.objects[this.getIntN(pos)];
                        int length2 = this.getIntN(pos + 2);
                        pos += 4;
                        if (out instanceof XConsumer) {
                            ((XConsumer)out).writeProcessingInstruction(target, this.data, pos, length2);
                        }
                        pos += length2;
                        continue block25;
                    }
                    case '\uf100': 
                    case '\uf101': {
                        out.writeBoolean(datum != '\uf100');
                        continue block25;
                    }
                    case '\uf116': {
                        out.write("");
                        continue block25;
                    }
                    case '\uf106': {
                        out.write(this.data, pos, '\u0001' + datum - 61702);
                        ++pos;
                        continue block25;
                    }
                    case '\uf10f': {
                        AbstractSequence seq = (AbstractSequence)this.objects[this.getIntN(pos)];
                        int ipos = this.getIntN(pos + 2);
                        if (out instanceof PositionConsumer) {
                            ((PositionConsumer)((Object)out)).writePosition(seq, ipos);
                        } else {
                            out.writeObject(seq.getIteratorAtPos(ipos));
                        }
                        pos += 4;
                        continue block25;
                    }
                    case '\uf10e': {
                        if (out instanceof PositionConsumer) {
                            ((PositionConsumer)((Object)out)).writePosition((SeqPosition)this.objects[this.getIntN(pos)]);
                            pos += 2;
                            continue block25;
                        }
                    }
                    case '\uf10d': {
                        out.writeObject(this.objects[this.getIntN(pos)]);
                        pos += 2;
                        continue block25;
                    }
                    case '\uf10b': {
                        ++pos;
                        out.endElement();
                        continue block25;
                    }
                    case '\uf108': {
                        index = this.getIntN(pos);
                        index += index >= 0 ? pos - 1 : this.data.length;
                        pos += 2;
                        index = this.getIntN(index + 1);
                        out.startElement(this.objects[index]);
                        continue block25;
                    }
                    case '\uf10c': {
                        index = this.getIntN(pos);
                        out.endElement();
                        pos += 6;
                        continue block25;
                    }
                    case '\uf109': {
                        index = this.getIntN(pos);
                        out.startAttribute(this.objects[index]);
                        pos += 4;
                        continue block25;
                    }
                    case '\uf10a': {
                        out.endAttribute();
                        continue block25;
                    }
                    case '\uf102': {
                        out.writeInt(this.getIntN(pos));
                        pos += 2;
                        continue block25;
                    }
                    case '\uf104': {
                        out.writeFloat(Float.intBitsToFloat(this.getIntN(pos)));
                        pos += 2;
                        continue block25;
                    }
                    case '\uf103': {
                        out.writeLong(this.getLongN(pos));
                        pos += 4;
                        continue block25;
                    }
                    case '\uf105': {
                        out.writeDouble(Double.longBitsToDouble(this.getLongN(pos)));
                        pos += 4;
                        continue block25;
                    }
                }
                break;
            } while (true);
            throw new Error("unknown code:" + datum);
        }
        return pos;
    }

    @Override
    public void toString(String sep, StringBuffer sbuf) {
        int pos = 0;
        int limit = this.gapStart;
        boolean seen = false;
        boolean inStartTag = false;
        boolean inAttribute = false;
        block21 : while (pos < limit || pos == this.gapStart && (pos = this.gapEnd) != (limit = this.data.length)) {
            char datum;
            int index;
            if ((datum = this.data[pos++]) <= '\u9fff') {
                int start = pos - 1;
                int lim = limit;
                while (pos < lim) {
                    if ((datum = this.data[pos++]) <= '\u9fff') continue;
                    --pos;
                    break;
                }
                if (inStartTag) {
                    sbuf.append('>');
                    inStartTag = false;
                }
                sbuf.append(this.data, start, pos - start);
                seen = false;
                continue;
            }
            if (datum >= '\ue000' && datum <= '\uefff') {
                if (inStartTag) {
                    sbuf.append('>');
                    inStartTag = false;
                }
                if (seen) {
                    sbuf.append(sep);
                } else {
                    seen = true;
                }
                sbuf.append(this.objects[datum - 57344]);
                continue;
            }
            if (datum >= '\ua000' && datum <= '\uafff') {
                if (inStartTag) {
                    sbuf.append('>');
                    inStartTag = false;
                }
                index = datum - 40960;
                if (seen) {
                    sbuf.append(sep);
                }
                sbuf.append('<');
                sbuf.append(this.objects[index].toString());
                pos += 2;
                seen = false;
                inStartTag = true;
                continue;
            }
            if (datum >= '\ub000' && datum <= '\udfff') {
                if (inStartTag) {
                    sbuf.append('>');
                    inStartTag = false;
                }
                if (seen) {
                    sbuf.append(sep);
                } else {
                    seen = true;
                }
                sbuf.append(datum - 49152);
                continue;
            }
            switch (datum) {
                case '\uf110': 
                case '\uf112': {
                    pos += 4;
                    continue block21;
                }
                case '\uf118': {
                    pos += 2;
                    continue block21;
                }
                case '\uf117': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    index = this.getIntN(pos);
                    sbuf.append("<!--");
                    sbuf.append(this.data, pos += 2, index);
                    sbuf.append("-->");
                    pos += index;
                    continue block21;
                }
                case '\uf115': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    index = this.getIntN(pos);
                    sbuf.append("<![CDATA[");
                    sbuf.append(this.data, pos += 2, index);
                    sbuf.append("]]>");
                    pos += index;
                    continue block21;
                }
                case '\uf114': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    sbuf.append("<?");
                    index = this.getIntN(pos);
                    sbuf.append(this.objects[index]);
                    index = this.getIntN(pos += 2);
                    pos += 2;
                    if (index > 0) {
                        sbuf.append(' ');
                        sbuf.append(this.data, pos, index);
                        pos += index;
                    }
                    sbuf.append("?>");
                    continue block21;
                }
                case '\uf111': 
                case '\uf113': {
                    continue block21;
                }
                case '\uf100': 
                case '\uf101': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    if (seen) {
                        sbuf.append(sep);
                    } else {
                        seen = true;
                    }
                    sbuf.append(datum != '\uf100');
                    continue block21;
                }
                case '\uf116': {
                    continue block21;
                }
                case '\uf106': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    sbuf.append(this.data, pos, '\u0001' + datum - 61702);
                    seen = false;
                    ++pos;
                    continue block21;
                }
                case '\uf10f': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    if (seen) {
                        sbuf.append(sep);
                    } else {
                        seen = true;
                    }
                    AbstractSequence seq = (AbstractSequence)this.objects[this.getIntN(pos)];
                    int ipos = this.getIntN(pos + 2);
                    sbuf.append(seq.getIteratorAtPos(ipos));
                    pos += 4;
                    continue block21;
                }
                case '\uf10d': 
                case '\uf10e': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    if (seen) {
                        sbuf.append(sep);
                    } else {
                        seen = true;
                    }
                    sbuf.append(this.objects[this.getIntN(pos)]);
                    pos += 2;
                    continue block21;
                }
                case '\uf108': {
                    index = this.getIntN(pos);
                    index += index >= 0 ? pos - 1 : this.data.length;
                    pos += 2;
                    index = this.getIntN(index + 1);
                    if (inStartTag) {
                        sbuf.append('>');
                    } else if (seen) {
                        sbuf.append(sep);
                    }
                    sbuf.append('<');
                    sbuf.append(this.objects[index]);
                    seen = false;
                    inStartTag = true;
                    continue block21;
                }
                case '\uf10b': 
                case '\uf10c': {
                    if (datum == '\uf10b') {
                        index = this.data[pos++];
                        index = this.data[pos - 2 - index] - 40960;
                    } else {
                        index = this.getIntN(pos);
                        pos += 6;
                    }
                    if (inStartTag) {
                        sbuf.append("/>");
                    } else {
                        sbuf.append("</");
                        sbuf.append(this.objects[index]);
                        sbuf.append('>');
                    }
                    inStartTag = false;
                    seen = true;
                    continue block21;
                }
                case '\uf109': {
                    index = this.getIntN(pos);
                    sbuf.append(' ');
                    sbuf.append(this.objects[index]);
                    sbuf.append("=\"");
                    inAttribute = true;
                    inStartTag = false;
                    pos += 4;
                    continue block21;
                }
                case '\uf10a': {
                    sbuf.append('\"');
                    inAttribute = false;
                    inStartTag = true;
                    seen = false;
                    continue block21;
                }
                case '\uf102': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    if (seen) {
                        sbuf.append(sep);
                    } else {
                        seen = true;
                    }
                    sbuf.append(this.getIntN(pos));
                    pos += 2;
                    continue block21;
                }
                case '\uf104': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    if (seen) {
                        sbuf.append(sep);
                    } else {
                        seen = true;
                    }
                    sbuf.append(Float.intBitsToFloat(this.getIntN(pos)));
                    pos += 2;
                    continue block21;
                }
                case '\uf103': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    if (seen) {
                        sbuf.append(sep);
                    } else {
                        seen = true;
                    }
                    sbuf.append(this.getLongN(pos));
                    pos += 4;
                    continue block21;
                }
                case '\uf105': {
                    if (inStartTag) {
                        sbuf.append('>');
                        inStartTag = false;
                    }
                    if (seen) {
                        sbuf.append(sep);
                    } else {
                        seen = true;
                    }
                    sbuf.append(Double.longBitsToDouble(this.getLongN(pos)));
                    pos += 4;
                    continue block21;
                }
            }
            throw new Error("unknown code:" + datum);
        }
    }

    @Override
    public boolean hasNext(int ipos) {
        int index = this.posToDataIndex(ipos);
        if (index == this.data.length) {
            return false;
        }
        char ch = this.data[index];
        return ch != '\uf10a' && ch != '\uf10b' && ch != '\uf10c' && ch != '\uf111';
    }

    @Override
    public int getNextKind(int ipos) {
        return this.getNextKindI(this.posToDataIndex(ipos));
    }

    public int getNextKindI(int index) {
        if (index == this.data.length) {
            return 0;
        }
        char datum = this.data[index];
        if (datum <= '\u9fff') {
            return 29;
        }
        if (datum >= '\ue000' && datum <= '\uefff') {
            return 32;
        }
        if (datum >= '\ua000' && datum <= '\uafff') {
            return 33;
        }
        if ((datum & 65280) == 61440) {
            return 28;
        }
        if (datum >= '\ub000' && datum <= '\udfff') {
            return 22;
        }
        switch (datum) {
            case '\uf100': 
            case '\uf101': {
                return 27;
            }
            case '\uf102': {
                return 22;
            }
            case '\uf103': {
                return 24;
            }
            case '\uf104': {
                return 25;
            }
            case '\uf105': {
                return 26;
            }
            case '\uf106': {
                return 29;
            }
            case '\uf110': {
                return 34;
            }
            case '\uf112': {
                return this.getNextKind(index + 5 << 1);
            }
            case '\uf108': {
                return 33;
            }
            case '\uf10a': 
            case '\uf10b': 
            case '\uf10c': 
            case '\uf111': 
            case '\uf113': {
                return 0;
            }
            case '\uf109': {
                return 35;
            }
            case '\uf115': {
                return 31;
            }
            case '\uf117': {
                return 36;
            }
            case '\uf114': {
                return 37;
            }
        }
        return 32;
    }

    @Override
    public Object getNextTypeObject(int ipos) {
        char datum;
        int index = this.posToDataIndex(ipos);
        do {
            if (index == this.data.length) {
                return null;
            }
            datum = this.data[index];
            if (datum != '\uf112') break;
            index += 5;
        } while (true);
        if (datum >= '\ua000' && datum <= '\uafff') {
            index = datum - 40960;
        } else if (datum == '\uf108') {
            int j;
            index = this.getIntN((j += (j = this.getIntN(index + 1)) < 0 ? this.data.length : index) + 1);
        } else if (datum == '\uf109') {
            index = this.getIntN(index + 1);
        } else if (datum == '\uf114') {
            index = this.getIntN(index + 1);
        } else {
            return null;
        }
        return index < 0 ? null : this.objects[index];
    }

    @Override
    public Object getPosPrevious(int ipos) {
        if ((ipos & 1) != 0 && ipos != -1) {
            return this.getPosNext(ipos - 3);
        }
        return super.getPosPrevious(ipos);
    }

    private Object copyToList(int startPosition, int endPosition) {
        return new TreeList(this, startPosition, endPosition);
    }

    public int getPosNextInt(int ipos) {
        int index = this.posToDataIndex(ipos);
        if (index < this.data.length) {
            char datum = this.data[index];
            if (datum >= '\ub000' && datum <= '\udfff') {
                return datum - 49152;
            }
            if (datum == '\uf102') {
                return this.getIntN(index + 1);
            }
        }
        return ((Number)this.getPosNext(ipos)).intValue();
    }

    @Override
    public Object getPosNext(int ipos) {
        int index = this.posToDataIndex(ipos);
        if (index == this.data.length) {
            return Sequence.eofValue;
        }
        char datum = this.data[index];
        if (datum <= '\u9fff') {
            return Convert.toObject(datum);
        }
        if (datum >= '\ue000' && datum <= '\uefff') {
            return this.objects[datum - 57344];
        }
        if (datum >= '\ua000' && datum <= '\uafff') {
            return this.copyToList(index, index + this.data[index + 1] + 2);
        }
        if (datum >= '\ub000' && datum <= '\udfff') {
            return Convert.toObject(datum - 49152);
        }
        switch (datum) {
            case '\uf110': {
                int end_offset = this.getIntN(index + 1);
                end_offset += end_offset < 0 ? this.data.length : index;
                return this.copyToList(index, ++end_offset);
            }
            case '\uf100': 
            case '\uf101': {
                return Convert.toObject(datum != '\uf100');
            }
            case '\uf102': {
                return Convert.toObject(this.getIntN(index + 1));
            }
            case '\uf103': {
                return Convert.toObject(this.getLongN(index + 1));
            }
            case '\uf104': {
                return Convert.toObject(Float.intBitsToFloat(this.getIntN(index + 1)));
            }
            case '\uf105': {
                return Convert.toObject(Double.longBitsToDouble(this.getLongN(index + 1)));
            }
            case '\uf106': {
                return Convert.toObject(this.data[index + 1]);
            }
            case '\uf109': {
                int end_offset = this.getIntN(index + 3);
                return this.copyToList(index, (end_offset += end_offset < 0 ? this.data.length : index) + 1);
            }
            case '\uf108': {
                int end_offset = this.getIntN(index + 1);
                return this.copyToList(index, (end_offset += end_offset < 0 ? this.data.length : index) + 7);
            }
            case '\uf10a': 
            case '\uf10b': 
            case '\uf10c': 
            case '\uf111': {
                return Sequence.eofValue;
            }
            case '\uf10d': 
            case '\uf10e': {
                return this.objects[this.getIntN(index + 1)];
            }
            case '\uf116': {
                return "";
            }
            case '\uf10f': {
                AbstractSequence seq = (AbstractSequence)this.objects[this.getIntN(index + 1)];
                ipos = this.getIntN(index + 3);
                return seq.getIteratorAtPos(ipos);
            }
        }
        throw this.unsupported("getPosNext, code=" + Integer.toHexString(datum));
    }

    public void stringValue(int startIndex, int endIndex, StringBuffer sbuf) {
        int index = startIndex;
        while (index < endIndex && index >= 0) {
            index = this.stringValue(false, index, sbuf);
        }
    }

    public int stringValue(int index, StringBuffer sbuf) {
        int next = this.nextNodeIndex(index, Integer.MAX_VALUE);
        if (next > index) {
            this.stringValue(index, next, sbuf);
            return index;
        }
        return this.stringValue(false, index, sbuf);
    }

    public int stringValue(boolean inElement, int index, StringBuffer sbuf) {
        Object value = null;
        int doChildren = 0;
        if (index >= this.gapStart) {
            index += this.gapEnd - this.gapStart;
        }
        if (index == this.data.length) {
            return -1;
        }
        char datum = this.data[index];
        ++index;
        boolean spaceNeeded = false;
        if (datum <= '\u9fff') {
            sbuf.append(datum);
            return index;
        }
        if (datum >= '\ue000' && datum <= '\uefff') {
            if (spaceNeeded) {
                sbuf.append(' ');
            }
            value = this.objects[datum - 57344];
            spaceNeeded = false;
        } else if (datum >= '\ua000' && datum <= '\uafff') {
            doChildren = index + 2;
            index = this.data[index] + index + 1;
        } else {
            if ((datum & 65280) == 61440) {
                sbuf.append(datum & 255);
                return index;
            }
            if (datum >= '\ub000' && datum <= '\udfff') {
                sbuf.append(datum - 49152);
                return index;
            }
            switch (datum) {
                case '\uf118': {
                    return index + 2;
                }
                case '\uf114': {
                    index += 2;
                }
                case '\uf115': 
                case '\uf117': {
                    int length = this.getIntN(index);
                    index += 2;
                    if (!inElement || datum == '\uf115') {
                        sbuf.append(this.data, index, length);
                    }
                    return index + length;
                }
                case '\uf100': 
                case '\uf101': {
                    if (spaceNeeded) {
                        sbuf.append(' ');
                    }
                    sbuf.append(datum != '\uf100');
                    spaceNeeded = true;
                    return index;
                }
                case '\uf102': {
                    if (spaceNeeded) {
                        sbuf.append(' ');
                    }
                    sbuf.append(this.getIntN(index));
                    spaceNeeded = true;
                    return index + 2;
                }
                case '\uf103': {
                    if (spaceNeeded) {
                        sbuf.append(' ');
                    }
                    sbuf.append(this.getLongN(index));
                    spaceNeeded = true;
                    return index + 4;
                }
                case '\uf104': {
                    if (spaceNeeded) {
                        sbuf.append(' ');
                    }
                    sbuf.append(Float.intBitsToFloat(this.getIntN(index)));
                    spaceNeeded = true;
                    return index + 2;
                }
                case '\uf105': {
                    if (spaceNeeded) {
                        sbuf.append(' ');
                    }
                    sbuf.append(Double.longBitsToDouble(this.getLongN(index)));
                    spaceNeeded = true;
                    return index + 4;
                }
                case '\uf106': {
                    spaceNeeded = false;
                    sbuf.append(this.data[index]);
                    return index + 1;
                }
                case '\uf110': 
                case '\uf112': {
                    doChildren = index + 4;
                    index = this.nextDataIndex(index - 1);
                    break;
                }
                case '\uf108': {
                    spaceNeeded = false;
                    doChildren = index + 2;
                    int j = this.getIntN(index);
                    index = (j += j < 0 ? this.data.length : index - 1) + 7;
                    break;
                }
                case '\uf116': {
                    spaceNeeded = false;
                    break;
                }
                case '\uf10a': 
                case '\uf10b': 
                case '\uf10c': 
                case '\uf111': 
                case '\uf113': {
                    return -1;
                }
                case '\uf109': {
                    int end;
                    if (!inElement) {
                        doChildren = index + 4;
                    }
                    index = end + ((end = this.getIntN(index + 2)) < 0 ? this.data.length + 1 : index);
                    break;
                }
                case '\uf10f': {
                    AbstractSequence seq = (AbstractSequence)this.objects[this.getIntN(index)];
                    int ipos = this.getIntN(index + 2);
                    ((TreeList)seq).stringValue(inElement, ipos >> 1, sbuf);
                    index += 4;
                    break;
                }
                default: {
                    throw new Error("unimplemented: " + Integer.toHexString(datum) + " at:" + index);
                }
            }
        }
        if (value != null) {
            sbuf.append(value);
        }
        if (doChildren > 0) {
            while ((doChildren = this.stringValue(true, doChildren, sbuf)) >= 0) {
            }
        }
        return index;
    }

    @Override
    public int createRelativePos(int istart, int offset, boolean isAfter) {
        if (isAfter) {
            if (offset == 0) {
                if ((istart & 1) != 0) {
                    return istart;
                }
                if (istart == 0) {
                    return 1;
                }
            }
            --offset;
        }
        if (offset < 0) {
            throw this.unsupported("backwards createRelativePos");
        }
        int pos = this.posToDataIndex(istart);
        while (--offset >= 0) {
            if ((pos = this.nextDataIndex(pos)) >= 0) continue;
            throw new IndexOutOfBoundsException();
        }
        if (pos >= this.gapEnd) {
            pos -= this.gapEnd - this.gapStart;
        }
        return isAfter ? pos + 1 << 1 | 1 : pos << 1;
    }

    public final int nextNodeIndex(int pos, int limit) {
        if ((limit | Integer.MIN_VALUE) == -1) {
            limit = this.data.length;
        }
        block7 : do {
            if (pos == this.gapStart) {
                pos = this.gapEnd;
            }
            if (pos >= limit) {
                return pos;
            }
            char datum = this.data[pos];
            if (datum <= '\u9fff' || datum >= '\ue000' && datum <= '\uefff' || datum >= '\ub000' && datum <= '\udfff' || (datum & 65280) == 61440) {
                ++pos;
                continue;
            }
            if (datum >= '\ua000' && datum <= '\uafff') {
                return pos;
            }
            switch (datum) {
                case '\uf118': {
                    pos += 3;
                    continue block7;
                }
                case '\uf116': {
                    ++pos;
                    continue block7;
                }
                case '\uf108': 
                case '\uf109': 
                case '\uf110': 
                case '\uf114': 
                case '\uf117': {
                    return pos;
                }
                case '\uf112': {
                    pos += 5;
                    continue block7;
                }
                case '\uf10a': 
                case '\uf10b': 
                case '\uf10c': 
                case '\uf111': 
                case '\uf113': {
                    return pos;
                }
            }
            pos = this.nextDataIndex(pos);
        } while (true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int nextMatching(int startPos, ItemPredicate predicate, int endPos, boolean descend) {
        boolean checkNode;
        boolean checkText;
        boolean checkElement;
        int start = this.posToDataIndex(startPos);
        int limit = this.posToDataIndex(endPos);
        int pos = start;
        if (predicate instanceof NodePredicate) {
            pos = this.nextNodeIndex(pos, limit);
        }
        boolean checkAttribute = false;
        if (predicate instanceof ElementPredicate) {
            checkNode = true;
            checkElement = true;
            checkText = false;
        } else if (predicate instanceof AttributePredicate) {
            checkNode = true;
            checkElement = false;
            checkText = false;
        } else {
            checkNode = true;
            checkElement = true;
            checkText = true;
        }
        do {
            int next;
            block45 : {
                char datum;
                block44 : {
                    if (pos == this.gapStart) {
                        pos = this.gapEnd;
                    }
                    if (pos >= limit && limit != -1) {
                        return 0;
                    }
                    datum = this.data[pos];
                    if (datum > '\u9fff' && (datum < '\ue000' || datum > '\uefff') && (datum < '\ub000' || datum > '\udfff')) break block44;
                    if (checkText && predicate.isInstancePos(this, pos << 1)) {
                        if (pos < this.gapEnd) return pos << 1;
                        pos -= this.gapEnd - this.gapStart;
                        return pos << 1;
                    }
                    next = pos + 1;
                    break block45;
                }
                switch (datum) {
                    int j;
                    case '\uf118': {
                        next = pos + 3;
                        break block45;
                    }
                    case '\uf110': {
                        next = pos + 5;
                        if (checkNode) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf112': {
                        next = pos + 5;
                        break block45;
                    }
                    case '\uf102': 
                    case '\uf104': 
                    case '\uf10d': 
                    case '\uf10e': {
                        next = pos + 3;
                        if (checkText) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf106': {
                        next = pos + 2;
                        break block45;
                    }
                    case '\uf10b': {
                        if (!descend) {
                            return 0;
                        }
                        next = pos + 2;
                        break block45;
                    }
                    case '\uf10f': {
                        next = pos + 5;
                        if (checkText) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf10c': {
                        if (!descend) {
                            return 0;
                        }
                        next = pos + 7;
                        break block45;
                    }
                    case '\uf10a': 
                    case '\uf111': {
                        if (!descend) {
                            return 0;
                        }
                    }
                    case '\uf113': {
                        next = pos + 1;
                        break block45;
                    }
                    case '\uf109': {
                        next = checkNode ? j + 1 + ((j = this.getIntN(pos + 3)) < 0 ? this.data.length : pos) : pos + 5;
                        if (checkAttribute) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf100': 
                    case '\uf101': {
                        next = pos + 1;
                        if (checkText) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf116': {
                        next = pos + 1;
                        break block45;
                    }
                    case '\uf103': 
                    case '\uf105': {
                        next = pos + 5;
                        if (checkText) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf114': {
                        next = pos + 5 + this.getIntN(pos + 3);
                        if (checkNode) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf117': {
                        next = pos + 3 + this.getIntN(pos + 1);
                        if (checkNode) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf115': {
                        next = pos + 3 + this.getIntN(pos + 1);
                        if (checkText) {
                            break;
                        }
                        break block45;
                    }
                    case '\uf108': {
                        next = descend ? pos + 3 : j + ((j = this.getIntN(pos + 1)) < 0 ? this.data.length : pos) + 7;
                        if (checkElement) {
                            break;
                        }
                        break block45;
                    }
                    default: {
                        if (datum < '\ua000' || datum > '\uafff') throw new Error("unknown code:" + datum);
                        next = descend ? pos + 3 : pos + this.data[pos + 1] + 2;
                        if (checkElement) {
                            break;
                        }
                        break block45;
                    }
                }
                if (pos > start && predicate.isInstancePos(this, pos << 1)) {
                    if (pos < this.gapEnd) return pos << 1;
                    pos -= this.gapEnd - this.gapStart;
                    return pos << 1;
                }
            }
            pos = next;
        } while (true);
    }

    @Override
    public int nextPos(int position) {
        int index = this.posToDataIndex(position);
        if (index == this.data.length) {
            return 0;
        }
        if (index >= this.gapEnd) {
            index -= this.gapEnd - this.gapStart;
        }
        return (index << 1) + 3;
    }

    public final int nextDataIndex(int pos) {
        char datum;
        if (pos == this.gapStart) {
            pos = this.gapEnd;
        }
        if (pos == this.data.length) {
            return -1;
        }
        if ((datum = this.data[pos++]) <= '\u9fff' || datum >= '\ue000' && datum <= '\uefff' || datum >= '\ub000' && datum <= '\udfff') {
            return pos;
        }
        if (datum >= '\ua000' && datum <= '\uafff') {
            return this.data[pos] + pos + 1;
        }
        switch (datum) {
            case '\uf110': {
                int j = this.getIntN(pos);
                return (j += j < 0 ? this.data.length : pos - 1) + 1;
            }
            case '\uf112': {
                int j = pos + 4;
                do {
                    if (j == this.gapStart) {
                        j = this.gapEnd;
                    }
                    if (j == this.data.length) {
                        return -1;
                    }
                    if (this.data[j] == '\uf113') {
                        return j + 1;
                    }
                    j = this.nextDataIndex(j);
                } while (true);
            }
            case '\uf100': 
            case '\uf101': 
            case '\uf116': {
                return pos;
            }
            case '\uf106': {
                return pos + 1;
            }
            case '\uf102': 
            case '\uf104': 
            case '\uf10d': 
            case '\uf10e': {
                return pos + 2;
            }
            case '\uf10f': {
                return pos + 4;
            }
            case '\uf10a': 
            case '\uf10b': 
            case '\uf10c': 
            case '\uf111': 
            case '\uf113': {
                return -1;
            }
            case '\uf108': {
                int j = this.getIntN(pos);
                return (j += j < 0 ? this.data.length : pos - 1) + 7;
            }
            case '\uf109': {
                int j = this.getIntN(pos + 2);
                return (j += j < 0 ? this.data.length : pos - 1) + 1;
            }
            case '\uf103': 
            case '\uf105': {
                return pos + 4;
            }
            case '\uf114': {
                pos += 2;
            }
            case '\uf115': 
            case '\uf117': {
                return pos + 2 + this.getIntN(pos);
            }
        }
        throw new Error("unknown code:" + Integer.toHexString(datum));
    }

    public Object documentUriOfPos(int pos) {
        int index = this.posToDataIndex(pos);
        if (index == this.data.length) {
            return null;
        }
        if (this.data[index] == '\uf110') {
            int next = index + 5;
            if (next == this.gapStart) {
                next = this.gapEnd;
            }
            if (next < this.data.length && this.data[next] == '\uf118') {
                return this.objects[this.getIntN(next + 1)];
            }
        }
        return null;
    }

    @Override
    public int compare(int ipos1, int ipos2) {
        int i2;
        int i1 = this.posToDataIndex(ipos1);
        return i1 < (i2 = this.posToDataIndex(ipos2)) ? -1 : (i1 > i2 ? 1 : 0);
    }

    @Override
    protected int getIndexDifference(int ipos1, int ipos0) {
        int i;
        int i0 = this.posToDataIndex(ipos0);
        int i1 = this.posToDataIndex(ipos1);
        boolean negate = false;
        if (i0 > i1) {
            negate = true;
            i = i1;
            i1 = i0;
            i0 = i;
        }
        i = 0;
        while (i0 < i1) {
            i0 = this.nextDataIndex(i0);
            ++i;
        }
        return negate ? -i : i;
    }

    @Override
    public int nextIndex(int ipos) {
        return this.getIndexDifference(ipos, this.startPos());
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public void consume(Consumer out) {
        this.consumeIRange(0, this.data.length, out);
    }

    public void statistics() {
        PrintWriter out = new PrintWriter(System.out);
        this.statistics(out);
        out.flush();
    }

    public void statistics(PrintWriter out) {
        out.print("data array length: ");
        out.println(this.data.length);
        out.print("data array gap: ");
        out.println(this.gapEnd - this.gapStart);
        out.print("object array length: ");
        out.println(this.objects.length);
    }

    public void dump() {
        PrintWriter out = new PrintWriter(System.out);
        this.dump(out);
        out.flush();
    }

    public void dump(PrintWriter out) {
        out.println(this.getClass().getName() + " @" + Integer.toHexString(System.identityHashCode(this)) + " gapStart:" + this.gapStart + " gapEnd:" + this.gapEnd + " length:" + this.data.length);
        this.dump(out, 0, this.data.length);
    }

    public void dump(PrintWriter out, int start, int limit) {
        int toskip = 0;
        boolean skipFollowingWords = true;
        for (int i = start; i < limit; ++i) {
            if (i >= this.gapStart && i < this.gapEnd) continue;
            int ch = this.data[i];
            out.print("" + i + ": 0x" + Integer.toHexString(ch) + '=' + (short)ch);
            if (--toskip < 0) {
                int j;
                if (ch <= 40959) {
                    if (ch >= 32 && ch < 127) {
                        out.print("='" + (char)ch + "'");
                    } else if (ch == 10) {
                        out.print("='\\n'");
                    } else {
                        out.print("='\\u" + Integer.toHexString(ch) + "'");
                    }
                } else if (ch >= 57344 && ch <= 61439) {
                    Object obj = this.objects[ch -= 57344];
                    out.print("=Object#");
                    out.print(ch);
                    out.print('=');
                    out.print(obj);
                    if (obj != null) {
                        out.print(':');
                        out.print(obj.getClass().getName());
                    }
                    out.print('@');
                    out.print(Integer.toHexString(System.identityHashCode(obj)));
                } else if (ch >= 40960 && ch <= 45055) {
                    j = this.data[i + 1] + i;
                    out.print("=BEGIN_ELEMENT_SHORT end:" + j + " index#" + ch + "=<" + this.objects[ch -= 40960] + '>');
                    toskip = 2;
                } else if (ch >= 45056 && ch <= 57343) {
                    out.print("= INT_SHORT:" + (ch - 49152));
                } else {
                    switch (ch) {
                        long l;
                        case 61698: {
                            j = this.getIntN(i + 1);
                            out.print("=INT_FOLLOWS value:" + j);
                            toskip = 2;
                            break;
                        }
                        case 61699: {
                            l = this.getLongN(i + 1);
                            out.print("=LONG_FOLLOWS value:" + l);
                            toskip = 4;
                            break;
                        }
                        case 61700: {
                            j = this.getIntN(i + 1);
                            out.write("=FLOAT_FOLLOWS value:" + Float.intBitsToFloat(j));
                            toskip = 2;
                            break;
                        }
                        case 61701: {
                            l = this.getLongN(i + 1);
                            out.print("=DOUBLE_FOLLOWS value:" + Double.longBitsToDouble(l));
                            toskip = 4;
                            break;
                        }
                        case 61712: {
                            j = this.getIntN(i + 1);
                            int n = j < 0 ? this.data.length : i;
                            out.print("=BEGIN_DOCUMENT end:");
                            out.print(j += n);
                            out.print(" parent:");
                            j = this.getIntN(i + 3);
                            out.print(j);
                            toskip = 4;
                            break;
                        }
                        case 61714: {
                            j = this.getIntN(i + 1);
                            out.print("=BEGIN_ENTITY base:");
                            out.print(j);
                            out.print(" parent:");
                            j = this.getIntN(i + 3);
                            out.print(j);
                            toskip = 4;
                            break;
                        }
                        case 61715: {
                            out.print("=END_ENTITY");
                            break;
                        }
                        case 61720: {
                            out.print("=DOCUMENT_URI: ");
                            j = this.getIntN(i + 1);
                            out.print(this.objects[j]);
                            toskip = 2;
                            break;
                        }
                        case 61719: {
                            out.print("=COMMENT: '");
                            j = this.getIntN(i + 1);
                            out.write(this.data, i + 3, j);
                            out.print('\'');
                            toskip = 2 + j;
                            break;
                        }
                        case 61717: {
                            out.print("=CDATA: '");
                            j = this.getIntN(i + 1);
                            out.write(this.data, i + 3, j);
                            out.print('\'');
                            toskip = 2 + j;
                            break;
                        }
                        case 61716: {
                            out.print("=PROCESSING_INSTRUCTION: ");
                            j = this.getIntN(i + 1);
                            out.print(this.objects[j]);
                            out.print(" '");
                            j = this.getIntN(i + 3);
                            out.write(this.data, i + 5, j);
                            out.print('\'');
                            toskip = 4 + j;
                            break;
                        }
                        case 61713: {
                            out.print("=END_DOCUMENT");
                            break;
                        }
                        case 61696: {
                            out.print("= false");
                            break;
                        }
                        case 61697: {
                            out.print("= true");
                            break;
                        }
                        case 61718: {
                            out.print("= joiner");
                            break;
                        }
                        case 61702: {
                            out.print("=CHAR_FOLLOWS");
                            toskip = 1;
                            break;
                        }
                        case 61709: 
                        case 61710: {
                            toskip = 2;
                            break;
                        }
                        case 61707: {
                            out.print("=END_ELEMENT_SHORT begin:");
                            j = i - this.data[i + 1];
                            out.print(j);
                            j = this.data[j] - 40960;
                            out.print(" -> #");
                            out.print(j);
                            out.print("=<");
                            out.print(this.objects[j]);
                            out.print('>');
                            toskip = 1;
                            break;
                        }
                        case 61704: {
                            j = this.getIntN(i + 1);
                            int n = j < 0 ? this.data.length : i;
                            out.print("=BEGIN_ELEMENT_LONG end:");
                            out.print(j += n);
                            j = this.getIntN(j + 1);
                            out.print(" -> #");
                            out.print(j);
                            if (j >= 0 && j + 1 < this.objects.length) {
                                out.print("=<" + this.objects[j] + '>');
                            } else {
                                out.print("=<out-of-bounds>");
                            }
                            toskip = 2;
                            break;
                        }
                        case 61708: {
                            j = this.getIntN(i + 1);
                            out.print("=END_ELEMENT_LONG name:" + j + "=<" + this.objects[j] + '>');
                            j = this.getIntN(i + 3);
                            j = j < 0 ? i + j : j;
                            out.print(" begin:" + j);
                            j = this.getIntN(i + 5);
                            j = j < 0 ? i + j : j;
                            out.print(" parent:" + j);
                            toskip = 6;
                            break;
                        }
                        case 61705: {
                            j = this.getIntN(i + 1);
                            out.print("=BEGIN_ATTRIBUTE name:" + j + "=" + this.objects[j]);
                            j = this.getIntN(i + 3);
                            out.print(" end:" + (j += j < 0 ? this.data.length : i));
                            toskip = 4;
                            break;
                        }
                        case 61706: {
                            out.print("=END_ATTRIBUTE");
                            break;
                        }
                        case 61711: {
                            out.print("=POSITION_PAIR_FOLLOWS seq:");
                            j = this.getIntN(i + 1);
                            out.print(j);
                            out.print('=');
                            Object seq = this.objects[j];
                            out.print(seq == null ? null : seq.getClass().getName());
                            out.print('@');
                            if (seq == null) {
                                out.print("null");
                            } else {
                                out.print(Integer.toHexString(System.identityHashCode(seq)));
                            }
                            out.print(" ipos:");
                            out.print(this.getIntN(i + 3));
                            toskip = 4;
                        }
                    }
                }
            }
            out.println();
            if (!skipFollowingWords || toskip <= 0) continue;
            i += toskip;
            toskip = 0;
        }
    }
}

