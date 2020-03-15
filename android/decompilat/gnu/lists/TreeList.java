// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import gnu.text.Char;

public class TreeList extends AbstractSequence<Object> implements Appendable, XConsumer, PositionConsumer, Consumable
{
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
    int currentParent;
    
    public TreeList() {
        this.currentParent = -1;
        this.resizeObjects();
        this.gapEnd = 200;
        this.data = new char[this.gapEnd];
    }
    
    public TreeList(final TreeList list, final int startPosition, final int endPosition) {
        this();
        list.consumeIRange(startPosition, endPosition, this);
    }
    
    public TreeList(final TreeList list) {
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
    
    public void ensureSpace(final int needed) {
        final int avail = this.gapEnd - this.gapStart;
        if (needed > avail) {
            final int oldSize = this.data.length;
            final int neededSize = oldSize - avail + needed;
            int newSize = 2 * oldSize;
            if (newSize < neededSize) {
                newSize = neededSize;
            }
            final char[] tmp = new char[newSize];
            if (this.gapStart > 0) {
                System.arraycopy(this.data, 0, tmp, 0, this.gapStart);
            }
            final int afterGap = oldSize - this.gapEnd;
            if (afterGap > 0) {
                System.arraycopy(this.data, this.gapEnd, tmp, newSize - afterGap, afterGap);
            }
            this.gapEnd = newSize - afterGap;
            this.data = tmp;
        }
    }
    
    public final void resizeObjects() {
        Object[] tmp;
        if (this.objects == null) {
            final int oldLength = 0;
            final int newLength = 100;
            tmp = new Object[newLength];
        }
        else {
            final int oldLength = this.objects.length;
            final int newLength = 2 * oldLength;
            tmp = new Object[newLength];
            System.arraycopy(this.objects, 0, tmp, 0, oldLength);
        }
        this.objects = tmp;
    }
    
    public int find(final Object arg1) {
        if (this.oindex == this.objects.length) {
            this.resizeObjects();
        }
        this.objects[this.oindex] = arg1;
        return this.oindex++;
    }
    
    protected final int getIntN(final int index) {
        return this.data[index] << 16 | (this.data[index + 1] & '\uffff');
    }
    
    protected final long getLongN(final int index) {
        final char[] data = this.data;
        return ((long)data[index] & 0xFFFFL) << 48 | ((long)data[index + 1] & 0xFFFFL) << 32 | ((long)data[index + 2] & 0xFFFFL) << 16 | ((long)data[index + 3] & 0xFFFFL);
    }
    
    public final void setIntN(final int index, final int i) {
        this.data[index] = (char)(i >> 16);
        this.data[index + 1] = (char)i;
    }
    
    @Override
    public void writePosition(final SeqPosition position) {
        this.ensureSpace(3);
        final int index = this.find(position.copy());
        this.data[this.gapStart++] = '\uf10e';
        this.setIntN(this.gapStart, index);
        this.gapStart += 2;
    }
    
    @Override
    public void writePosition(final AbstractSequence seq, final int ipos) {
        this.ensureSpace(5);
        this.data[this.gapStart] = '\uf10f';
        final int seq_index = this.find(seq);
        this.setIntN(this.gapStart + 1, seq_index);
        this.setIntN(this.gapStart + 3, ipos);
        this.gapStart += 5;
    }
    
    @Override
    public void writeObject(final Object v) {
        if (this.gapEnd - this.gapStart < 3) {
            this.ensureSpace(3);
        }
        final int index = this.find(v);
        if (index < 4096) {
            this.data[this.gapStart++] = (char)(0xE000 | index);
        }
        else {
            this.data[this.gapStart++] = '\uf10d';
            this.setIntN(this.gapStart, index);
            this.gapStart += 2;
        }
    }
    
    public void writeDocumentUri(final Object uri) {
        this.ensureSpace(3);
        final int index = this.find(uri);
        this.data[this.gapStart++] = '\uf118';
        this.setIntN(this.gapStart, index);
        this.gapStart += 2;
    }
    
    @Override
    public void writeComment(final char[] chars, final int offset, final int length) {
        this.ensureSpace(3 + length);
        int i = this.gapStart;
        this.data[i++] = '\uf117';
        this.setIntN(i, length);
        i += 2;
        System.arraycopy(chars, offset, this.data, i, length);
        this.gapStart = i + length;
    }
    
    public void writeComment(final String comment, final int offset, final int length) {
        this.ensureSpace(3 + length);
        int i = this.gapStart;
        this.data[i++] = '\uf117';
        this.setIntN(i, length);
        i += 2;
        comment.getChars(offset, offset + length, this.data, i);
        this.gapStart = i + length;
    }
    
    @Override
    public void writeProcessingInstruction(final String target, final char[] content, final int offset, final int length) {
        this.ensureSpace(5 + length);
        int i = this.gapStart;
        this.data[i++] = '\uf114';
        final int index = this.find(target);
        this.setIntN(i, index);
        this.setIntN(i + 2, length);
        i += 4;
        System.arraycopy(content, offset, this.data, i, length);
        this.gapStart = i + length;
    }
    
    public void writeProcessingInstruction(final String target, final String content, final int offset, final int length) {
        this.ensureSpace(5 + length);
        int i = this.gapStart;
        this.data[i++] = '\uf114';
        final int index = this.find(target);
        this.setIntN(i, index);
        this.setIntN(i + 2, length);
        i += 4;
        content.getChars(offset, offset + length, this.data, i);
        this.gapStart = i + length;
    }
    
    @Override
    public void startElement(final Object type) {
        this.startElement(this.find(type));
    }
    
    @Override
    public void startDocument() {
        this.ensureSpace(6);
        --this.gapEnd;
        final int p = this.gapStart;
        this.data[p] = '\uf110';
        if (this.docStart != 0) {
            throw new Error("nested document");
        }
        this.setIntN(this.docStart = p + 1, this.gapEnd - this.data.length);
        this.setIntN(p + 3, (this.currentParent == -1) ? -1 : (this.currentParent - p));
        this.currentParent = p;
        this.gapStart = p + 5;
        this.currentParent = p;
        this.data[this.gapEnd] = '\uf111';
    }
    
    @Override
    public void endDocument() {
        if (this.data[this.gapEnd] != '\uf111' || this.docStart <= 0 || this.data[this.currentParent] != '\uf110') {
            throw new Error("unexpected endDocument");
        }
        ++this.gapEnd;
        this.setIntN(this.docStart, this.gapStart - this.docStart + 1);
        this.docStart = 0;
        this.data[this.gapStart++] = '\uf111';
        final int parent = this.getIntN(this.currentParent + 3);
        this.currentParent = ((parent >= -1) ? parent : (this.currentParent + parent));
    }
    
    @Override
    public void beginEntity(final Object base) {
        if (this.gapStart != 0) {
            return;
        }
        this.ensureSpace(6);
        --this.gapEnd;
        final int p = this.gapStart;
        this.data[p] = '\uf112';
        this.setIntN(p + 1, this.find(base));
        this.setIntN(p + 3, (this.currentParent == -1) ? -1 : (this.currentParent - p));
        this.gapStart = p + 5;
        this.currentParent = p;
        this.data[this.gapEnd] = '\uf113';
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
        this.data[this.gapStart++] = '\uf113';
        final int parent = this.getIntN(this.currentParent + 3);
        this.currentParent = ((parent >= -1) ? parent : (this.currentParent + parent));
    }
    
    public void startElement(final int index) {
        this.ensureSpace(10);
        this.gapEnd -= 7;
        this.data[this.gapStart++] = '\uf108';
        this.setIntN(this.gapStart, this.gapEnd - this.data.length);
        this.gapStart += 2;
        this.data[this.gapEnd] = '\uf10c';
        this.setIntN(this.gapEnd + 1, index);
        this.setIntN(this.gapEnd + 3, this.gapStart - 3);
        this.setIntN(this.gapEnd + 5, this.currentParent);
        this.currentParent = this.gapStart - 3;
    }
    
    public void setElementName(int elementIndex, final int nameIndex) {
        if (this.data[elementIndex] == '\uf108') {
            final int j = this.getIntN(elementIndex + 1);
            elementIndex = j + ((j < 0) ? this.data.length : elementIndex);
        }
        if (elementIndex < this.gapEnd) {
            throw new Error("setElementName before gapEnd");
        }
        this.setIntN(elementIndex + 1, nameIndex);
    }
    
    @Override
    public void endElement() {
        if (this.data[this.gapEnd] != '\uf10c') {
            throw new Error("unexpected endElement");
        }
        final int index = this.getIntN(this.gapEnd + 1);
        final int begin = this.getIntN(this.gapEnd + 3);
        int parent = this.getIntN(this.gapEnd + 5);
        this.currentParent = parent;
        this.gapEnd += 7;
        final int offset = this.gapStart - begin;
        final int parentOffset = begin - parent;
        if (index < 4095 && offset < 65536 && parentOffset < 65536) {
            this.data[begin] = (char)(0xA000 | index);
            this.data[begin + 1] = (char)offset;
            this.data[begin + 2] = (char)parentOffset;
            this.data[this.gapStart] = '\uf10b';
            this.data[this.gapStart + 1] = (char)offset;
            this.gapStart += 2;
        }
        else {
            this.data[begin] = '\uf108';
            this.setIntN(begin + 1, offset);
            this.data[this.gapStart] = '\uf10c';
            this.setIntN(this.gapStart + 1, index);
            this.setIntN(this.gapStart + 3, -offset);
            if (parent >= this.gapStart || begin <= this.gapStart) {
                parent -= this.gapStart;
            }
            this.setIntN(this.gapStart + 5, parent);
            this.gapStart += 7;
        }
    }
    
    @Override
    public void startAttribute(final Object attrType) {
        this.startAttribute(this.find(attrType));
    }
    
    public void startAttribute(final int index) {
        this.ensureSpace(6);
        --this.gapEnd;
        this.data[this.gapStart++] = '\uf109';
        if (this.attrStart != 0) {
            throw new Error("nested attribute");
        }
        this.attrStart = this.gapStart;
        this.setIntN(this.gapStart, index);
        this.setIntN(this.gapStart + 2, this.gapEnd - this.data.length);
        this.gapStart += 4;
        this.data[this.gapEnd] = '\uf10a';
    }
    
    public void setAttributeName(final int attrIndex, final int nameIndex) {
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
        this.data[this.gapStart++] = '\uf10a';
    }
    
    @Override
    public Consumer append(final char c) {
        this.write(c);
        return this;
    }
    
    @Override
    public void write(final int c) {
        this.ensureSpace(3);
        if (c <= 40959) {
            this.data[this.gapStart++] = (char)c;
        }
        else if (c < 65536) {
            this.data[this.gapStart++] = '\uf106';
            this.data[this.gapStart++] = (char)c;
        }
        else {
            Char.print(c, this);
        }
    }
    
    @Override
    public void writeBoolean(final boolean v) {
        this.ensureSpace(1);
        this.data[this.gapStart++] = (v ? '\uf101' : '\uf100');
    }
    
    public void writeByte(final int v) {
        this.ensureSpace(1);
        this.data[this.gapStart++] = (char)(61440 + (v & 0xFF));
    }
    
    @Override
    public void writeInt(final int v) {
        this.ensureSpace(3);
        if (v >= -4096 && v <= 8191) {
            this.data[this.gapStart++] = (char)(49152 + v);
        }
        else {
            this.data[this.gapStart++] = '\uf102';
            this.setIntN(this.gapStart, v);
            this.gapStart += 2;
        }
    }
    
    @Override
    public void writeLong(final long v) {
        this.ensureSpace(5);
        this.data[this.gapStart++] = '\uf103';
        this.data[this.gapStart++] = (char)(v >>> 48);
        this.data[this.gapStart++] = (char)(v >>> 32);
        this.data[this.gapStart++] = (char)(v >>> 16);
        this.data[this.gapStart++] = (char)v;
    }
    
    @Override
    public void writeFloat(final float v) {
        this.ensureSpace(3);
        final int i = Float.floatToIntBits(v);
        this.data[this.gapStart++] = '\uf104';
        this.data[this.gapStart++] = (char)(i >>> 16);
        this.data[this.gapStart++] = (char)i;
    }
    
    @Override
    public void writeDouble(final double v) {
        this.ensureSpace(5);
        final long l = Double.doubleToLongBits(v);
        this.data[this.gapStart++] = '\uf105';
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
        this.data[this.gapStart++] = '\uf116';
    }
    
    @Override
    public void write(final char[] buf, int off, int len) {
        if (len == 0) {
            this.writeJoiner();
        }
        this.ensureSpace(len);
        while (len > 0) {
            final char ch = buf[off++];
            --len;
            if (ch <= '\u9fff') {
                this.data[this.gapStart++] = ch;
            }
            else {
                this.write(ch);
                this.ensureSpace(len);
            }
        }
    }
    
    @Override
    public void write(final String str) {
        this.write(str, 0, str.length());
    }
    
    @Override
    public void write(final CharSequence str, int start, int length) {
        if (length == 0) {
            this.writeJoiner();
        }
        this.ensureSpace(length);
        while (length > 0) {
            final char ch = str.charAt(start++);
            --length;
            if (ch <= '\u9fff') {
                this.data[this.gapStart++] = ch;
            }
            else {
                this.write(ch);
                this.ensureSpace(length);
            }
        }
    }
    
    @Override
    public void writeCDATA(final char[] chars, final int offset, final int length) {
        this.ensureSpace(3 + length);
        int i = this.gapStart;
        this.data[i++] = '\uf115';
        this.setIntN(i, length);
        i += 2;
        System.arraycopy(chars, offset, this.data, i, length);
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
    public Consumer append(CharSequence csq, final int start, final int end) {
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
        final int pos = (this.gapStart == 0) ? this.gapEnd : 0;
        return pos == this.data.length;
    }
    
    @Override
    public int size() {
        int size = 0;
        int i = 0;
        while (true) {
            i = this.nextPos(i);
            if (i == 0) {
                break;
            }
            ++size;
        }
        return size;
    }
    
    @Override
    public int createPos(final int index, final boolean isAfter) {
        return this.createRelativePos(0, index, isAfter);
    }
    
    public final int posToDataIndex(final int ipos) {
        if (ipos == -1) {
            return this.data.length;
        }
        int index = ipos >>> 1;
        if ((ipos & 0x1) != 0x0) {
            --index;
        }
        if (index == this.gapStart) {
            index += this.gapEnd - this.gapStart;
        }
        if ((ipos & 0x1) != 0x0) {
            index = this.nextDataIndex(index);
            if (index < 0) {
                return this.data.length;
            }
            if (index == this.gapStart) {
                index += this.gapEnd - this.gapStart;
            }
        }
        return index;
    }
    
    @Override
    public int firstChildPos(final int ipos) {
        final int index = this.gotoChildrenStart(this.posToDataIndex(ipos));
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
        if ((datum >= '\ua000' && datum <= '\uafff') || datum == '\uf108') {
            index += 3;
        }
        else {
            if (datum != '\uf110' && datum != '\uf112') {
                return -1;
            }
            index += 5;
        }
        while (true) {
            if (index >= this.gapStart) {
                index += this.gapEnd - this.gapStart;
            }
            datum = this.data[index];
            if (datum == '\uf109') {
                final int end = this.getIntN(index + 3);
                index = end + ((end < 0) ? this.data.length : index);
            }
            else if (datum == '\uf10a' || datum == '\uf116') {
                ++index;
            }
            else {
                if (datum != '\uf118') {
                    break;
                }
                index += 3;
            }
        }
        return index;
    }
    
    @Override
    public int parentPos(final int ipos) {
        int index = this.posToDataIndex(ipos);
        do {
            index = this.parentOrEntityI(index);
            if (index == -1) {
                return -1;
            }
        } while (this.data[index] == '\uf112');
        return index << 1;
    }
    
    public int parentOrEntityPos(final int ipos) {
        final int index = this.parentOrEntityI(this.posToDataIndex(ipos));
        return (index < 0) ? -1 : (index << 1);
    }
    
    public int parentOrEntityI(int index) {
        if (index == this.data.length) {
            return -1;
        }
        char datum = this.data[index];
        if (datum == '\uf110' || datum == '\uf112') {
            final int parent_offset = this.getIntN(index + 3);
            if (parent_offset >= -1) {
                return parent_offset;
            }
            return index + parent_offset;
        }
        else {
            if (datum >= '\ua000' && datum <= '\uafff') {
                final int parent_offset = this.data[index + 2];
                return (parent_offset == 0) ? -1 : (index - parent_offset);
            }
            if (datum == '\uf108') {
                int end_offset = this.getIntN(index + 1);
                end_offset += ((end_offset < 0) ? this.data.length : index);
                int parent_offset2 = this.getIntN(end_offset + 5);
                if (parent_offset2 == 0) {
                    return -1;
                }
                if (parent_offset2 < 0) {
                    parent_offset2 += end_offset;
                }
                return parent_offset2;
            }
            else {
                while (true) {
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
                            continue;
                        }
                        case '\uf111': {
                            return -1;
                        }
                        default: {
                            index = this.nextDataIndex(index);
                            if (index < 0) {
                                return -1;
                            }
                            continue;
                        }
                    }
                }
            }
        }
    }
    
    public int getAttributeCount(final int parent) {
        int n = 0;
        for (int attr = this.firstAttributePos(parent); attr != 0 && this.getNextKind(attr) == 35; attr = this.nextPos(attr)) {
            ++n;
        }
        return n;
    }
    
    public boolean gotoAttributesStart(final TreePosition pos) {
        final int index = this.gotoAttributesStart(pos.ipos >> 1);
        if (index < 0) {
            return false;
        }
        pos.push(this, index << 1);
        return true;
    }
    
    @Override
    public int firstAttributePos(final int ipos) {
        final int index = this.gotoAttributesStart(this.posToDataIndex(ipos));
        return (index < 0) ? 0 : (index << 1);
    }
    
    public int gotoAttributesStart(int index) {
        if (index >= this.gapStart) {
            index += this.gapEnd - this.gapStart;
        }
        if (index == this.data.length) {
            return -1;
        }
        final char datum = this.data[index];
        if ((datum >= '\ua000' && datum <= '\uafff') || datum == '\uf108') {
            return index + 3;
        }
        return -1;
    }
    
    @Override
    public Object get(int index) {
        int i = 0;
        while (--index >= 0) {
            i = this.nextPos(i);
            if (i == 0) {
                throw new IndexOutOfBoundsException();
            }
        }
        return this.getPosNext(i);
    }
    
    @Override
    public boolean consumeNext(final int ipos, final Consumer out) {
        if (!this.hasNext(ipos)) {
            return false;
        }
        final int start = this.posToDataIndex(ipos);
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
    public void consumePosRange(final int startPos, final int endPos, final Consumer out) {
        this.consumeIRange(this.posToDataIndex(startPos), this.posToDataIndex(endPos), out);
    }
    
    public int consumeIRange(final int startPosition, final int endPosition, final Consumer out) {
        int pos = startPosition;
        int limit = (startPosition <= this.gapStart && endPosition > this.gapStart) ? this.gapStart : endPosition;
    Label_0029:
        while (true) {
            if (pos >= limit) {
                if (pos != this.gapStart || endPosition <= this.gapEnd) {
                    return pos;
                }
                pos = this.gapEnd;
                limit = endPosition;
            }
            char datum = this.data[pos++];
            if (datum <= '\u9fff') {
                final int start = pos - 1;
                final int lim = limit;
                while (true) {
                    while (pos < lim) {
                        datum = this.data[pos++];
                        if (datum > '\u9fff') {
                            --pos;
                            out.write(this.data, start, pos - start);
                            continue Label_0029;
                        }
                    }
                    continue;
                }
            }
            if (datum >= '\ue000' && datum <= '\uefff') {
                out.writeObject(this.objects[datum - '\ue000']);
            }
            else if (datum >= '\ua000' && datum <= '\uafff') {
                final int index = datum - '\ua000';
                out.startElement(this.objects[index]);
                pos += 2;
            }
            else if (datum >= '\ub000' && datum <= '\udfff') {
                out.writeInt(datum - '\uc000');
            }
            else {
                switch (datum) {
                    case '\uf110': {
                        out.startDocument();
                        pos += 4;
                        continue;
                    }
                    case '\uf111': {
                        out.endDocument();
                        continue;
                    }
                    case '\uf112': {
                        if (out instanceof TreeList) {
                            ((TreeList)out).beginEntity(this.objects[this.getIntN(pos)]);
                        }
                        pos += 4;
                        continue;
                    }
                    case '\uf113': {
                        if (out instanceof TreeList) {
                            ((TreeList)out).endEntity();
                            continue;
                        }
                        continue;
                    }
                    case '\uf118': {
                        if (out instanceof TreeList) {
                            ((TreeList)out).writeDocumentUri(this.objects[this.getIntN(pos)]);
                        }
                        pos += 2;
                        continue;
                    }
                    case '\uf117': {
                        final int length = this.getIntN(pos);
                        pos += 2;
                        if (out instanceof XConsumer) {
                            ((XConsumer)out).writeComment(this.data, pos, length);
                        }
                        pos += length;
                        continue;
                    }
                    case '\uf115': {
                        final int length = this.getIntN(pos);
                        pos += 2;
                        if (out instanceof XConsumer) {
                            ((XConsumer)out).writeCDATA(this.data, pos, length);
                        }
                        else {
                            out.write(this.data, pos, length);
                        }
                        pos += length;
                        continue;
                    }
                    case '\uf114': {
                        final String target = (String)this.objects[this.getIntN(pos)];
                        final int length2 = this.getIntN(pos + 2);
                        pos += 4;
                        if (out instanceof XConsumer) {
                            ((XConsumer)out).writeProcessingInstruction(target, this.data, pos, length2);
                        }
                        pos += length2;
                        continue;
                    }
                    case '\uf100':
                    case '\uf101': {
                        out.writeBoolean(datum != '\uf100');
                        continue;
                    }
                    case '\uf116': {
                        out.write("");
                        continue;
                    }
                    case '\uf106': {
                        out.write(this.data, pos, '\u0001' + datum - 61702);
                        ++pos;
                        continue;
                    }
                    case '\uf10f': {
                        final AbstractSequence seq = (AbstractSequence)this.objects[this.getIntN(pos)];
                        final int ipos = this.getIntN(pos + 2);
                        if (out instanceof PositionConsumer) {
                            ((PositionConsumer)out).writePosition(seq, ipos);
                        }
                        else {
                            out.writeObject(seq.getIteratorAtPos(ipos));
                        }
                        pos += 4;
                        continue;
                    }
                    case '\uf10e': {
                        if (out instanceof PositionConsumer) {
                            ((PositionConsumer)out).writePosition((SeqPosition)this.objects[this.getIntN(pos)]);
                            pos += 2;
                            continue;
                        }
                    }
                    case '\uf10d': {
                        out.writeObject(this.objects[this.getIntN(pos)]);
                        pos += 2;
                        continue;
                    }
                    case '\uf10b': {
                        ++pos;
                        out.endElement();
                        continue;
                    }
                    case '\uf108': {
                        int index = this.getIntN(pos);
                        index += ((index >= 0) ? (pos - 1) : this.data.length);
                        pos += 2;
                        index = this.getIntN(index + 1);
                        out.startElement(this.objects[index]);
                        continue;
                    }
                    case '\uf10c': {
                        final int index = this.getIntN(pos);
                        out.endElement();
                        pos += 6;
                        continue;
                    }
                    case '\uf109': {
                        final int index = this.getIntN(pos);
                        out.startAttribute(this.objects[index]);
                        pos += 4;
                        continue;
                    }
                    case '\uf10a': {
                        out.endAttribute();
                        continue;
                    }
                    case '\uf102': {
                        out.writeInt(this.getIntN(pos));
                        pos += 2;
                        continue;
                    }
                    case '\uf104': {
                        out.writeFloat(Float.intBitsToFloat(this.getIntN(pos)));
                        pos += 2;
                        continue;
                    }
                    case '\uf103': {
                        out.writeLong(this.getLongN(pos));
                        pos += 4;
                        continue;
                    }
                    case '\uf105': {
                        out.writeDouble(Double.longBitsToDouble(this.getLongN(pos)));
                        pos += 4;
                        continue;
                    }
                    default: {
                        throw new Error("unknown code:" + (int)datum);
                    }
                }
            }
        }
    }
    
    @Override
    public void toString(final String sep, final StringBuffer sbuf) {
        int pos = 0;
        int limit = this.gapStart;
        boolean seen = false;
        boolean inStartTag = false;
        boolean inAttribute = false;
    Label_0017:
        while (true) {
            if (pos >= limit) {
                if (pos != this.gapStart) {
                    break;
                }
                pos = this.gapEnd;
                limit = this.data.length;
                if (pos == limit) {
                    break;
                }
            }
            char datum = this.data[pos++];
            if (datum <= '\u9fff') {
                final int start = pos - 1;
                final int lim = limit;
                while (true) {
                    while (pos < lim) {
                        datum = this.data[pos++];
                        if (datum > '\u9fff') {
                            --pos;
                            if (inStartTag) {
                                sbuf.append('>');
                                inStartTag = false;
                            }
                            sbuf.append(this.data, start, pos - start);
                            seen = false;
                            continue Label_0017;
                        }
                    }
                    continue;
                }
            }
            if (datum >= '\ue000' && datum <= '\uefff') {
                if (inStartTag) {
                    sbuf.append('>');
                    inStartTag = false;
                }
                if (seen) {
                    sbuf.append(sep);
                }
                else {
                    seen = true;
                }
                sbuf.append(this.objects[datum - '\ue000']);
            }
            else if (datum >= '\ua000' && datum <= '\uafff') {
                if (inStartTag) {
                    sbuf.append('>');
                    inStartTag = false;
                }
                final int index = datum - '\ua000';
                if (seen) {
                    sbuf.append(sep);
                }
                sbuf.append('<');
                sbuf.append(this.objects[index].toString());
                pos += 2;
                seen = false;
                inStartTag = true;
            }
            else if (datum >= '\ub000' && datum <= '\udfff') {
                if (inStartTag) {
                    sbuf.append('>');
                    inStartTag = false;
                }
                if (seen) {
                    sbuf.append(sep);
                }
                else {
                    seen = true;
                }
                sbuf.append(datum - '\uc000');
            }
            else {
                switch (datum) {
                    case '\uf110':
                    case '\uf112': {
                        pos += 4;
                        continue;
                    }
                    case '\uf118': {
                        pos += 2;
                        continue;
                    }
                    case '\uf117': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        final int index = this.getIntN(pos);
                        pos += 2;
                        sbuf.append("<!--");
                        sbuf.append(this.data, pos, index);
                        sbuf.append("-->");
                        pos += index;
                        continue;
                    }
                    case '\uf115': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        final int index = this.getIntN(pos);
                        pos += 2;
                        sbuf.append("<![CDATA[");
                        sbuf.append(this.data, pos, index);
                        sbuf.append("]]>");
                        pos += index;
                        continue;
                    }
                    case '\uf114': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        sbuf.append("<?");
                        int index = this.getIntN(pos);
                        pos += 2;
                        sbuf.append(this.objects[index]);
                        index = this.getIntN(pos);
                        pos += 2;
                        if (index > 0) {
                            sbuf.append(' ');
                            sbuf.append(this.data, pos, index);
                            pos += index;
                        }
                        sbuf.append("?>");
                        continue;
                    }
                    case '\uf111':
                    case '\uf113': {
                        continue;
                    }
                    case '\uf100':
                    case '\uf101': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        if (seen) {
                            sbuf.append(sep);
                        }
                        else {
                            seen = true;
                        }
                        sbuf.append(datum != '\uf100');
                        continue;
                    }
                    case '\uf116': {
                        continue;
                    }
                    case '\uf106': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        sbuf.append(this.data, pos, '\u0001' + datum - 61702);
                        seen = false;
                        ++pos;
                        continue;
                    }
                    case '\uf10f': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        if (seen) {
                            sbuf.append(sep);
                        }
                        else {
                            seen = true;
                        }
                        final AbstractSequence seq = (AbstractSequence)this.objects[this.getIntN(pos)];
                        final int ipos = this.getIntN(pos + 2);
                        sbuf.append(seq.getIteratorAtPos(ipos));
                        pos += 4;
                        continue;
                    }
                    case '\uf10d':
                    case '\uf10e': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        if (seen) {
                            sbuf.append(sep);
                        }
                        else {
                            seen = true;
                        }
                        sbuf.append(this.objects[this.getIntN(pos)]);
                        pos += 2;
                        continue;
                    }
                    case '\uf108': {
                        int index = this.getIntN(pos);
                        index += ((index >= 0) ? (pos - 1) : this.data.length);
                        pos += 2;
                        index = this.getIntN(index + 1);
                        if (inStartTag) {
                            sbuf.append('>');
                        }
                        else if (seen) {
                            sbuf.append(sep);
                        }
                        sbuf.append('<');
                        sbuf.append(this.objects[index]);
                        seen = false;
                        inStartTag = true;
                        continue;
                    }
                    case '\uf10b':
                    case '\uf10c': {
                        int index;
                        if (datum == '\uf10b') {
                            index = this.data[pos++];
                            index = this.data[pos - 2 - index] - '\ua000';
                        }
                        else {
                            index = this.getIntN(pos);
                            pos += 6;
                        }
                        if (inStartTag) {
                            sbuf.append("/>");
                        }
                        else {
                            sbuf.append("</");
                            sbuf.append(this.objects[index]);
                            sbuf.append('>');
                        }
                        inStartTag = false;
                        seen = true;
                        continue;
                    }
                    case '\uf109': {
                        final int index = this.getIntN(pos);
                        sbuf.append(' ');
                        sbuf.append(this.objects[index]);
                        sbuf.append("=\"");
                        inAttribute = true;
                        inStartTag = false;
                        pos += 4;
                        continue;
                    }
                    case '\uf10a': {
                        sbuf.append('\"');
                        inAttribute = false;
                        inStartTag = true;
                        seen = false;
                        continue;
                    }
                    case '\uf102': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        if (seen) {
                            sbuf.append(sep);
                        }
                        else {
                            seen = true;
                        }
                        sbuf.append(this.getIntN(pos));
                        pos += 2;
                        continue;
                    }
                    case '\uf104': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        if (seen) {
                            sbuf.append(sep);
                        }
                        else {
                            seen = true;
                        }
                        sbuf.append(Float.intBitsToFloat(this.getIntN(pos)));
                        pos += 2;
                        continue;
                    }
                    case '\uf103': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        if (seen) {
                            sbuf.append(sep);
                        }
                        else {
                            seen = true;
                        }
                        sbuf.append(this.getLongN(pos));
                        pos += 4;
                        continue;
                    }
                    case '\uf105': {
                        if (inStartTag) {
                            sbuf.append('>');
                            inStartTag = false;
                        }
                        if (seen) {
                            sbuf.append(sep);
                        }
                        else {
                            seen = true;
                        }
                        sbuf.append(Double.longBitsToDouble(this.getLongN(pos)));
                        pos += 4;
                        continue;
                    }
                    default: {
                        throw new Error("unknown code:" + (int)datum);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean hasNext(final int ipos) {
        final int index = this.posToDataIndex(ipos);
        if (index == this.data.length) {
            return false;
        }
        final char ch = this.data[index];
        return ch != '\uf10a' && ch != '\uf10b' && ch != '\uf10c' && ch != '\uf111';
    }
    
    @Override
    public int getNextKind(final int ipos) {
        return this.getNextKindI(this.posToDataIndex(ipos));
    }
    
    public int getNextKindI(final int index) {
        if (index == this.data.length) {
            return 0;
        }
        final char datum = this.data[index];
        if (datum <= '\u9fff') {
            return 29;
        }
        if (datum >= '\ue000' && datum <= '\uefff') {
            return 32;
        }
        if (datum >= '\ua000' && datum <= '\uafff') {
            return 33;
        }
        if ((datum & '\uff00') == 0xF000) {
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
            default: {
                return 32;
            }
        }
    }
    
    @Override
    public Object getNextTypeObject(final int ipos) {
        for (int index = this.posToDataIndex(ipos); index != this.data.length; index += 5) {
            final char datum = this.data[index];
            if (datum != '\uf112') {
                if (datum >= '\ua000' && datum <= '\uafff') {
                    index = datum - '\ua000';
                }
                else if (datum == '\uf108') {
                    int j = this.getIntN(index + 1);
                    j += ((j < 0) ? this.data.length : index);
                    index = this.getIntN(j + 1);
                }
                else if (datum == '\uf109') {
                    index = this.getIntN(index + 1);
                }
                else {
                    if (datum != '\uf114') {
                        return null;
                    }
                    index = this.getIntN(index + 1);
                }
                return (index < 0) ? null : this.objects[index];
            }
        }
        return null;
    }
    
    @Override
    public Object getPosPrevious(final int ipos) {
        if ((ipos & 0x1) != 0x0 && ipos != -1) {
            return this.getPosNext(ipos - 3);
        }
        return super.getPosPrevious(ipos);
    }
    
    private Object copyToList(final int startPosition, final int endPosition) {
        return new TreeList(this, startPosition, endPosition);
    }
    
    public int getPosNextInt(final int ipos) {
        final int index = this.posToDataIndex(ipos);
        if (index < this.data.length) {
            final char datum = this.data[index];
            if (datum >= '\ub000' && datum <= '\udfff') {
                return datum - '\uc000';
            }
            if (datum == '\uf102') {
                return this.getIntN(index + 1);
            }
        }
        return ((Number)this.getPosNext(ipos)).intValue();
    }
    
    @Override
    public Object getPosNext(int ipos) {
        final int index = this.posToDataIndex(ipos);
        if (index == this.data.length) {
            return Sequence.eofValue;
        }
        final char datum = this.data[index];
        if (datum <= '\u9fff') {
            return Convert.toObject(datum);
        }
        if (datum >= '\ue000' && datum <= '\uefff') {
            return this.objects[datum - '\ue000'];
        }
        if (datum >= '\ua000' && datum <= '\uafff') {
            return this.copyToList(index, index + this.data[index + 1] + 2);
        }
        if (datum >= '\ub000' && datum <= '\udfff') {
            return Convert.toObject(datum - '\uc000');
        }
        switch (datum) {
            case '\uf110': {
                int end_offset = this.getIntN(index + 1);
                end_offset += ((end_offset < 0) ? this.data.length : index);
                ++end_offset;
                return this.copyToList(index, end_offset);
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
                end_offset += ((end_offset < 0) ? this.data.length : index);
                return this.copyToList(index, end_offset + 1);
            }
            case '\uf108': {
                int end_offset = this.getIntN(index + 1);
                end_offset += ((end_offset < 0) ? this.data.length : index);
                return this.copyToList(index, end_offset + 7);
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
                final AbstractSequence seq = (AbstractSequence)this.objects[this.getIntN(index + 1)];
                ipos = this.getIntN(index + 3);
                return seq.getIteratorAtPos(ipos);
            }
            default: {
                throw this.unsupported("getPosNext, code=" + Integer.toHexString(datum));
            }
        }
    }
    
    public void stringValue(final int startIndex, final int endIndex, final StringBuffer sbuf) {
        for (int index = startIndex; index < endIndex && index >= 0; index = this.stringValue(false, index, sbuf)) {}
    }
    
    public int stringValue(final int index, final StringBuffer sbuf) {
        final int next = this.nextNodeIndex(index, Integer.MAX_VALUE);
        if (next > index) {
            this.stringValue(index, next, sbuf);
            return index;
        }
        return this.stringValue(false, index, sbuf);
    }
    
    public int stringValue(final boolean inElement, int index, final StringBuffer sbuf) {
        Object value = null;
        int doChildren = 0;
        if (index >= this.gapStart) {
            index += this.gapEnd - this.gapStart;
        }
        if (index == this.data.length) {
            return -1;
        }
        final char datum = this.data[index];
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
            value = this.objects[datum - '\ue000'];
            spaceNeeded = false;
        }
        else if (datum >= '\ua000' && datum <= '\uafff') {
            doChildren = index + 2;
            index = this.data[index] + index + 1;
        }
        else {
            if ((datum & '\uff00') == 0xF000) {
                sbuf.append(datum & '\u00ff');
                return index;
            }
            if (datum >= '\ub000' && datum <= '\udfff') {
                sbuf.append(datum - '\uc000');
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
                    final int length = this.getIntN(index);
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
                    j += ((j < 0) ? this.data.length : (index - 1));
                    index = j + 7;
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
                    if (!inElement) {
                        doChildren = index + 4;
                    }
                    final int end = this.getIntN(index + 2);
                    index = end + ((end < 0) ? (this.data.length + 1) : index);
                    break;
                }
                case '\uf10f': {
                    final AbstractSequence seq = (AbstractSequence)this.objects[this.getIntN(index)];
                    final int ipos = this.getIntN(index + 2);
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
            do {
                doChildren = this.stringValue(true, doChildren, sbuf);
            } while (doChildren >= 0);
        }
        return index;
    }
    
    @Override
    public int createRelativePos(final int istart, int offset, final boolean isAfter) {
        if (isAfter) {
            if (offset == 0) {
                if ((istart & 0x1) != 0x0) {
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
            pos = this.nextDataIndex(pos);
            if (pos < 0) {
                throw new IndexOutOfBoundsException();
            }
        }
        if (pos >= this.gapEnd) {
            pos -= this.gapEnd - this.gapStart;
        }
        return isAfter ? (pos + 1 << 1 | 0x1) : (pos << 1);
    }
    
    public final int nextNodeIndex(int pos, int limit) {
        if ((limit | Integer.MIN_VALUE) == -1) {
            limit = this.data.length;
        }
        while (true) {
            if (pos == this.gapStart) {
                pos = this.gapEnd;
            }
            if (pos >= limit) {
                return pos;
            }
            final char datum = this.data[pos];
            if (datum <= '\u9fff' || (datum >= '\ue000' && datum <= '\uefff') || (datum >= '\ub000' && datum <= '\udfff') || (datum & '\uff00') == 0xF000) {
                ++pos;
            }
            else {
                if (datum >= '\ua000' && datum <= '\uafff') {
                    return pos;
                }
                switch (datum) {
                    case '\uf118': {
                        pos += 3;
                        continue;
                    }
                    case '\uf116': {
                        ++pos;
                        continue;
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
                        continue;
                    }
                    case '\uf10a':
                    case '\uf10b':
                    case '\uf10c':
                    case '\uf111':
                    case '\uf113': {
                        return pos;
                    }
                    default: {
                        pos = this.nextDataIndex(pos);
                        continue;
                    }
                }
            }
        }
    }
    
    @Override
    public int nextMatching(final int startPos, final ItemPredicate predicate, final int endPos, final boolean descend) {
        final int start = this.posToDataIndex(startPos);
        final int limit = this.posToDataIndex(endPos);
        int pos = start;
        if (predicate instanceof NodePredicate) {
            pos = this.nextNodeIndex(pos, limit);
        }
        final boolean checkAttribute = false;
        boolean checkNode;
        boolean checkElement;
        boolean checkText;
        if (predicate instanceof ElementPredicate) {
            checkNode = true;
            checkElement = true;
            checkText = false;
        }
        else if (predicate instanceof AttributePredicate) {
            checkNode = true;
            checkElement = false;
            checkText = false;
        }
        else {
            checkNode = true;
            checkElement = true;
            checkText = true;
        }
        while (true) {
            if (pos == this.gapStart) {
                pos = this.gapEnd;
            }
            if (pos >= limit && limit != -1) {
                return 0;
            }
            final char datum = this.data[pos];
            int next = 0;
            Label_0794: {
                if (datum <= '\u9fff' || (datum >= '\ue000' && datum <= '\uefff') || (datum >= '\ub000' && datum <= '\udfff')) {
                    if (checkText && predicate.isInstancePos(this, pos << 1)) {
                        if (pos >= this.gapEnd) {
                            pos -= this.gapEnd - this.gapStart;
                        }
                        return pos << 1;
                    }
                    next = pos + 1;
                }
                else {
                    switch (datum) {
                        case '\uf118': {
                            next = pos + 3;
                            break Label_0794;
                        }
                        case '\uf110': {
                            next = pos + 5;
                            if (checkNode) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf112': {
                            next = pos + 5;
                            break Label_0794;
                        }
                        case '\uf102':
                        case '\uf104':
                        case '\uf10d':
                        case '\uf10e': {
                            next = pos + 3;
                            if (checkText) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf106': {
                            next = pos + 2;
                            break Label_0794;
                        }
                        case '\uf10b': {
                            if (!descend) {
                                return 0;
                            }
                            next = pos + 2;
                            break Label_0794;
                        }
                        case '\uf10f': {
                            next = pos + 5;
                            if (checkText) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf10c': {
                            if (!descend) {
                                return 0;
                            }
                            next = pos + 7;
                            break Label_0794;
                        }
                        case '\uf10a':
                        case '\uf111': {
                            if (!descend) {
                                return 0;
                            }
                        }
                        case '\uf113': {
                            next = pos + 1;
                            break Label_0794;
                        }
                        case '\uf109': {
                            if (checkNode) {
                                final int j = this.getIntN(pos + 3);
                                next = j + 1 + ((j < 0) ? this.data.length : pos);
                            }
                            else {
                                next = pos + 5;
                            }
                            if (checkAttribute) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf100':
                        case '\uf101': {
                            next = pos + 1;
                            if (checkText) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf116': {
                            next = pos + 1;
                            break Label_0794;
                        }
                        case '\uf103':
                        case '\uf105': {
                            next = pos + 5;
                            if (checkText) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf114': {
                            next = pos + 5 + this.getIntN(pos + 3);
                            if (checkNode) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf117': {
                            next = pos + 3 + this.getIntN(pos + 1);
                            if (checkNode) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf115': {
                            next = pos + 3 + this.getIntN(pos + 1);
                            if (checkText) {
                                break;
                            }
                            break Label_0794;
                        }
                        case '\uf108': {
                            if (descend) {
                                next = pos + 3;
                            }
                            else {
                                final int j = this.getIntN(pos + 1);
                                next = j + ((j < 0) ? this.data.length : pos) + 7;
                            }
                            if (checkElement) {
                                break;
                            }
                            break Label_0794;
                        }
                        default: {
                            if (datum < '\ua000' || datum > '\uafff') {
                                throw new Error("unknown code:" + (int)datum);
                            }
                            if (descend) {
                                next = pos + 3;
                            }
                            else {
                                next = pos + this.data[pos + 1] + 2;
                            }
                            if (checkElement) {
                                break;
                            }
                            break Label_0794;
                        }
                    }
                    if (pos > start && predicate.isInstancePos(this, pos << 1)) {
                        if (pos >= this.gapEnd) {
                            pos -= this.gapEnd - this.gapStart;
                        }
                        return pos << 1;
                    }
                }
            }
            pos = next;
        }
    }
    
    @Override
    public int nextPos(final int position) {
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
        if (pos == this.gapStart) {
            pos = this.gapEnd;
        }
        if (pos == this.data.length) {
            return -1;
        }
        final char datum = this.data[pos++];
        if (datum <= '\u9fff' || (datum >= '\ue000' && datum <= '\uefff') || (datum >= '\ub000' && datum <= '\udfff')) {
            return pos;
        }
        if (datum >= '\ua000' && datum <= '\uafff') {
            return this.data[pos] + pos + 1;
        }
        switch (datum) {
            case '\uf110': {
                int j = this.getIntN(pos);
                j += ((j < 0) ? this.data.length : (pos - 1));
                return j + 1;
            }
            case '\uf112': {
                int j = pos + 4;
                while (true) {
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
                }
                break;
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
                j += ((j < 0) ? this.data.length : (pos - 1));
                return j + 7;
            }
            case '\uf109': {
                int j = this.getIntN(pos + 2);
                j += ((j < 0) ? this.data.length : (pos - 1));
                return j + 1;
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
            default: {
                throw new Error("unknown code:" + Integer.toHexString(datum));
            }
        }
    }
    
    public Object documentUriOfPos(final int pos) {
        final int index = this.posToDataIndex(pos);
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
    public int compare(final int ipos1, final int ipos2) {
        final int i1 = this.posToDataIndex(ipos1);
        final int i2 = this.posToDataIndex(ipos2);
        return (i1 < i2) ? -1 : ((i1 > i2) ? 1 : 0);
    }
    
    @Override
    protected int getIndexDifference(final int ipos1, final int ipos0) {
        int i0 = this.posToDataIndex(ipos0);
        int i2 = this.posToDataIndex(ipos1);
        boolean negate = false;
        if (i0 > i2) {
            negate = true;
            final int j = i2;
            i2 = i0;
            i0 = j;
        }
        int j;
        for (j = 0; i0 < i2; i0 = this.nextDataIndex(i0), ++j) {}
        return negate ? (-j) : j;
    }
    
    public int nextIndex(final int ipos) {
        return this.getIndexDifference(ipos, this.startPos());
    }
    
    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
    
    @Override
    public void consume(final Consumer out) {
        this.consumeIRange(0, this.data.length, out);
    }
    
    public void statistics() {
        final PrintWriter out = new PrintWriter(System.out);
        this.statistics(out);
        out.flush();
    }
    
    public void statistics(final PrintWriter out) {
        out.print("data array length: ");
        out.println(this.data.length);
        out.print("data array gap: ");
        out.println(this.gapEnd - this.gapStart);
        out.print("object array length: ");
        out.println(this.objects.length);
    }
    
    public void dump() {
        final PrintWriter out = new PrintWriter(System.out);
        this.dump(out);
        out.flush();
    }
    
    public void dump(final PrintWriter out) {
        out.println(this.getClass().getName() + " @" + Integer.toHexString(System.identityHashCode(this)) + " gapStart:" + this.gapStart + " gapEnd:" + this.gapEnd + " length:" + this.data.length);
        this.dump(out, 0, this.data.length);
    }
    
    public void dump(final PrintWriter out, final int start, final int limit) {
        int toskip = 0;
        final boolean skipFollowingWords = true;
        for (int i = start; i < limit; ++i) {
            if (i < this.gapStart || i >= this.gapEnd) {
                int ch = this.data[i];
                out.print("" + i + ": 0x" + Integer.toHexString(ch) + '=' + (short)ch);
                if (--toskip < 0) {
                    if (ch <= 40959) {
                        if (ch >= 32 && ch < 127) {
                            out.print("='" + (char)ch + "'");
                        }
                        else if (ch == 10) {
                            out.print("='\\n'");
                        }
                        else {
                            out.print("='\\u" + Integer.toHexString(ch) + "'");
                        }
                    }
                    else if (ch >= 57344 && ch <= 61439) {
                        ch -= 57344;
                        final Object obj = this.objects[ch];
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
                    }
                    else if (ch >= 40960 && ch <= 45055) {
                        ch -= 40960;
                        final int j = this.data[i + 1] + i;
                        out.print("=BEGIN_ELEMENT_SHORT end:" + j + " index#" + ch + "=<" + this.objects[ch] + '>');
                        toskip = 2;
                    }
                    else if (ch >= 45056 && ch <= 57343) {
                        out.print("= INT_SHORT:" + (ch - 49152));
                    }
                    else {
                        switch (ch) {
                            case 61698: {
                                final int j = this.getIntN(i + 1);
                                out.print("=INT_FOLLOWS value:" + j);
                                toskip = 2;
                                break;
                            }
                            case 61699: {
                                final long l = this.getLongN(i + 1);
                                out.print("=LONG_FOLLOWS value:" + l);
                                toskip = 4;
                                break;
                            }
                            case 61700: {
                                final int j = this.getIntN(i + 1);
                                out.write("=FLOAT_FOLLOWS value:" + Float.intBitsToFloat(j));
                                toskip = 2;
                                break;
                            }
                            case 61701: {
                                final long l = this.getLongN(i + 1);
                                out.print("=DOUBLE_FOLLOWS value:" + Double.longBitsToDouble(l));
                                toskip = 4;
                                break;
                            }
                            case 61712: {
                                int j = this.getIntN(i + 1);
                                j += ((j < 0) ? this.data.length : i);
                                out.print("=BEGIN_DOCUMENT end:");
                                out.print(j);
                                out.print(" parent:");
                                j = this.getIntN(i + 3);
                                out.print(j);
                                toskip = 4;
                                break;
                            }
                            case 61714: {
                                int j = this.getIntN(i + 1);
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
                                final int j = this.getIntN(i + 1);
                                out.print(this.objects[j]);
                                toskip = 2;
                                break;
                            }
                            case 61719: {
                                out.print("=COMMENT: '");
                                final int j = this.getIntN(i + 1);
                                out.write(this.data, i + 3, j);
                                out.print('\'');
                                toskip = 2 + j;
                                break;
                            }
                            case 61717: {
                                out.print("=CDATA: '");
                                final int j = this.getIntN(i + 1);
                                out.write(this.data, i + 3, j);
                                out.print('\'');
                                toskip = 2 + j;
                                break;
                            }
                            case 61716: {
                                out.print("=PROCESSING_INSTRUCTION: ");
                                int j = this.getIntN(i + 1);
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
                                int j = i - this.data[i + 1];
                                out.print(j);
                                j = this.data[j] - '\ua000';
                                out.print(" -> #");
                                out.print(j);
                                out.print("=<");
                                out.print(this.objects[j]);
                                out.print('>');
                                toskip = 1;
                                break;
                            }
                            case 61704: {
                                int j = this.getIntN(i + 1);
                                j += ((j < 0) ? this.data.length : i);
                                out.print("=BEGIN_ELEMENT_LONG end:");
                                out.print(j);
                                j = this.getIntN(j + 1);
                                out.print(" -> #");
                                out.print(j);
                                if (j >= 0 && j + 1 < this.objects.length) {
                                    out.print("=<" + this.objects[j] + '>');
                                }
                                else {
                                    out.print("=<out-of-bounds>");
                                }
                                toskip = 2;
                                break;
                            }
                            case 61708: {
                                int j = this.getIntN(i + 1);
                                out.print("=END_ELEMENT_LONG name:" + j + "=<" + this.objects[j] + '>');
                                j = this.getIntN(i + 3);
                                j = ((j < 0) ? (i + j) : j);
                                out.print(" begin:" + j);
                                j = this.getIntN(i + 5);
                                j = ((j < 0) ? (i + j) : j);
                                out.print(" parent:" + j);
                                toskip = 6;
                                break;
                            }
                            case 61705: {
                                int j = this.getIntN(i + 1);
                                out.print("=BEGIN_ATTRIBUTE name:" + j + "=" + this.objects[j]);
                                j = this.getIntN(i + 3);
                                j += ((j < 0) ? this.data.length : i);
                                out.print(" end:" + j);
                                toskip = 4;
                                break;
                            }
                            case 61706: {
                                out.print("=END_ATTRIBUTE");
                                break;
                            }
                            case 61711: {
                                out.print("=POSITION_PAIR_FOLLOWS seq:");
                                final int j = this.getIntN(i + 1);
                                out.print(j);
                                out.print('=');
                                final Object seq = this.objects[j];
                                out.print((seq == null) ? null : seq.getClass().getName());
                                out.print('@');
                                if (seq == null) {
                                    out.print("null");
                                }
                                else {
                                    out.print(Integer.toHexString(System.identityHashCode(seq)));
                                }
                                out.print(" ipos:");
                                out.print(this.getIntN(i + 3));
                                toskip = 4;
                                break;
                            }
                        }
                    }
                }
                out.println();
                if (skipFollowingWords && toskip > 0) {
                    i += toskip;
                    toskip = 0;
                }
            }
        }
    }
}
