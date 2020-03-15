// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import gnu.lists.Strings;
import gnu.lists.LList;
import java.io.IOException;
import java.io.Writer;
import gnu.kawa.util.IntHashTable;
import gnu.mapping.ThreadLocation;
import gnu.lists.PrintConsumer;

public class PrettyWriter extends PrintConsumer
{
    int lineLength;
    int miserWidth;
    boolean isDomTerm;
    boolean sharing;
    boolean reallySharing;
    public static ThreadLocation lineLengthLoc;
    public static ThreadLocation miserWidthLoc;
    public static ThreadLocation indentLoc;
    public static ThreadLocation isSharing;
    private int prettyPrintingMode;
    private IntHashTable idhash;
    public char[] buffer;
    public int bufferFillPointer;
    int bufferOffset;
    int bufferStartColumn;
    int lineNumber;
    int[] blocks;
    private static final int LOGICAL_BLOCK_LENGTH = 6;
    private static final int BLOCK_START_COLUMN = -1;
    private static final int BLOCK_SECTION_COLUMN = -2;
    private static final int BLOCK_PER_LINE_PREFIX_END = -3;
    private static final int BLOCK_PREFIX_LENGTH = -4;
    private static final int BLOCK_SUFFIX_LENGTH = -5;
    private static final int BLOCK_SECTION_START_LINE = -6;
    int blockDepth;
    char[] prefix;
    char[] suffix;
    static final int QUEUE_INIT_ALLOC_SIZE = 300;
    int[] queueInts;
    String[] queueStrings;
    int queueTail;
    private int queueSize;
    int currentBlock;
    public int pendingBlocksCount;
    static final int QITEM_TYPE_AND_SIZE = 0;
    static final int QITEM_POSN = 1;
    static final int QITEM_BASE_SIZE = 2;
    static final int QITEM_NOP_TYPE = 0;
    static final int QITEM_SECTION_START_SIZE = 4;
    static final int QITEM_SECTION_START_DEPTH = 2;
    static final int QITEM_SECTION_START_SECTION_END = 3;
    static final int QITEM_NEWLINE_TYPE = 2;
    static final int QITEM_NEWLINE_SIZE = 5;
    static final int QITEM_NEWLINE_KIND = 4;
    public static final int NEWLINE_LINEAR = 78;
    public static final int NEWLINE_LITERAL = 76;
    public static final int NEWLINE_FILL = 70;
    public static final int NEWLINE_SPACE = 83;
    public static final int NEWLINE_MISER = 77;
    public static final int NEWLINE_MANDATORY = 82;
    public static final int NEWLINE_DUMMY = 68;
    static final int QITEM_INDENTATION_TYPE = 3;
    static final int QITEM_INDENTATION_SIZE = 4;
    static final int QITEM_INDENTATION_KIND = 2;
    static final char QITEM_INDENTATION_BLOCK = 'B';
    static final char QITEM_INDENTATION_CURRENT = 'C';
    static final int QITEM_INDENTATION_AMOUNT = 3;
    static final int QITEM_BLOCK_START_TYPE = 4;
    static final int QITEM_BLOCK_START_SIZE = 7;
    static final int QITEM_BLOCK_START_BLOCK_END = 4;
    static final int QITEM_BLOCK_START_PREFIX = 5;
    static final int QITEM_BLOCK_START_SUFFIX = 6;
    static final int QITEM_BLOCK_END_TYPE = 5;
    static final int QITEM_BLOCK_END_SIZE = 2;
    static final int QITEM_TAB_TYPE = 6;
    static final int QITEM_TAB_SIZE = 5;
    static final int QITEM_TAB_FLAGS = 2;
    static final int QITEM_TAB_IS_SECTION = 1;
    static final int QITEM_TAB_IS_RELATIVE = 2;
    static final int QITEM_TAB_COLNUM = 3;
    static final int QITEM_TAB_COLINC = 4;
    static final int QITEM_POSNMARKER_TYPE = 7;
    static final int QITEM_POSNMARKER_GROUP_TYPE = 8;
    static final int QITEM_POSNMARKER_SIZE = 3;
    static final int QITEM_POSNMARKER_LOC = 2;
    static final int QITEM_BACKREF_TYPE = 8;
    static final int QITEM_BACKREF_SIZE = 3;
    static final int QITEM_BACKREF_TARGET = 2;
    static final int QITEM_PAIR_END_TYPE = 9;
    static final int QITEM_PAIR_END_SIZE = 3;
    static final int QITEM_PAIR_END_REF = 2;
    static final int QITEM_EOE_TYPE = 10;
    static final int QITEM_EOE_SIZE = 2;
    boolean wordEndSeen;
    
    public PrettyWriter(final Writer out) {
        super(out);
        this.lineLength = 80;
        this.miserWidth = 40;
        this.sharing = false;
        this.reallySharing = false;
        this.buffer = new char[2048];
        this.blocks = new int[60];
        this.blockDepth = 6;
        this.prefix = new char[128];
        this.suffix = new char[128];
        this.queueInts = new int[300];
        this.queueStrings = new String[300];
        this.currentBlock = -1;
        this.setPrettyPrintingMode(1);
    }
    
    public PrettyWriter(final Writer out, final int lineLength) {
        super(out);
        this.lineLength = 80;
        this.miserWidth = 40;
        this.sharing = false;
        this.reallySharing = false;
        this.buffer = new char[2048];
        this.blocks = new int[60];
        this.blockDepth = 6;
        this.prefix = new char[128];
        this.suffix = new char[128];
        this.queueInts = new int[300];
        this.queueStrings = new String[300];
        this.currentBlock = -1;
        this.lineLength = lineLength;
        this.setPrettyPrintingMode((lineLength > 1) ? 1 : 0);
    }
    
    public PrettyWriter(final Writer out, final boolean prettyPrintingMode) {
        super(out);
        this.lineLength = 80;
        this.miserWidth = 40;
        this.sharing = false;
        this.reallySharing = false;
        this.buffer = new char[2048];
        this.blocks = new int[60];
        this.blockDepth = 6;
        this.prefix = new char[128];
        this.suffix = new char[128];
        this.queueInts = new int[300];
        this.queueStrings = new String[300];
        this.currentBlock = -1;
        this.setPrettyPrintingMode(prettyPrintingMode ? 1 : 0);
    }
    
    public boolean isDomTerm() {
        return this.isDomTerm;
    }
    
    public boolean initialiseIDHash() {
        final Object share = PrettyWriter.isSharing.get(null);
        if (this.idhash != null) {
            return false;
        }
        this.idhash = new IntHashTable();
        return true;
    }
    
    public void clearIDHash() {
        this.idhash.clear();
    }
    
    public void finishIDHash() {
        this.idhash.clear();
        this.writeEndOfExpression();
        this.resolveBackReferences();
        this.flush();
        this.idhash = null;
    }
    
    public int IDHashLookup(final Object obj) {
        return this.idhash.lookup(obj);
    }
    
    public int IDHashGetFromIndex(final int index) {
        return this.idhash.getFromIndex(index);
    }
    
    public int IDHashPutAtIndex(final Object obj, final int value, final int index) {
        return this.idhash.putAtIndex(obj, value, index);
    }
    
    public int IDHashRemove(final Object obj) {
        return this.idhash.remove(obj);
    }
    
    public void setPrettyPrintingMode(final int mode) {
        this.prettyPrintingMode = mode;
    }
    
    public void setSharing(final boolean sharing) {
        this.sharing = sharing;
    }
    
    public int getPrettyPrintingMode() {
        return this.prettyPrintingMode;
    }
    
    public boolean isPrettyPrinting() {
        return this.prettyPrintingMode > 0;
    }
    
    public void setPrettyPrinting(final boolean mode) {
        this.setPrettyPrintingMode(mode ? 1 : 0);
    }
    
    private boolean isPassingThrough() {
        return this.buffer.length == 0 && this.out != null;
    }
    
    private int indexPosn(final int index) {
        return index + this.bufferOffset;
    }
    
    private int posnIndex(final int posn) {
        return posn - this.bufferOffset;
    }
    
    private int posnColumn(final int posn) {
        return this.indexColumn(this.posnIndex(posn));
    }
    
    private int getQueueType(final int index) {
        return this.queueInts[index] & 0xFF;
    }
    
    private int getQueueSize(final int index) {
        return this.queueInts[index] >> 16;
    }
    
    private boolean posnMarkerIsGrouping(final int posn) {
        return (this.queueInts[posn] >> 8 & 0x1) != 0x0;
    }
    
    private boolean posnMarkerActive(final int posn) {
        return this.queueInts[posn + 2] != 0;
    }
    
    private int getSectionColumn() {
        return this.blocks[this.blockDepth - 2];
    }
    
    private int getStartColumn() {
        return this.blocks[this.blockDepth - 1];
    }
    
    private int getPerLinePrefixEnd() {
        return this.blocks[this.blockDepth - 3];
    }
    
    private int getPrefixLength() {
        return this.blocks[this.blockDepth - 4];
    }
    
    private int getSuffixLength() {
        return this.blocks[this.blockDepth - 5];
    }
    
    private int getSectionStartLine() {
        return this.blocks[this.blockDepth - 6];
    }
    
    @Override
    public void writeWordEnd() {
        this.wordEndSeen = true;
    }
    
    @Override
    public void writeWordStart() {
        if (this.wordEndSeen) {
            this.write(32);
        }
        this.wordEndSeen = false;
    }
    
    @Override
    protected void clearWordEnd() {
        this.wordEndSeen = false;
    }
    
    @Override
    public void write(final int ch) {
        this.wordEndSeen = false;
        if (this.isPassingThrough()) {
            if (ch == 10 || ch == 13) {
                this.bufferStartColumn = 0;
            }
            this.writeToBase(ch);
        }
        else if (ch == 10 && this.prettyPrintingMode > 0) {
            this.enqueueNewline(76);
        }
        else {
            this.ensureSpaceInBuffer(1);
            final int fillPointer = this.bufferFillPointer;
            this.buffer[fillPointer] = (char)ch;
            this.bufferFillPointer = 1 + fillPointer;
            if (ch == 32 && this.prettyPrintingMode > 1 && this.currentBlock < 0) {
                this.enqueueNewline(83);
            }
        }
    }
    
    @Override
    public void write(final String str) {
        this.write(str, 0, str.length());
    }
    
    @Override
    public void write(final String str, int start, int count) {
        this.wordEndSeen = false;
        if (this.isPassingThrough()) {
            int i = count;
            while (true) {
                while (--i >= 0) {
                    final char ch = str.charAt(start + i);
                    if (ch == '\r' || ch == '\n') {
                        this.bufferStartColumn = count - (i + 1);
                        this.writeToBase(str, start, count);
                        return;
                    }
                }
                this.bufferStartColumn += count;
                continue;
            }
        }
        while (count > 0) {
            int cnt = count;
            final int available = this.ensureSpaceInBuffer(count);
            if (cnt > available) {
                cnt = available;
            }
            int fillPointer = this.bufferFillPointer;
            count -= cnt;
            while (--cnt >= 0) {
                final char ch2 = str.charAt(start++);
                if (ch2 == '\n' && this.prettyPrintingMode > 0) {
                    this.bufferFillPointer = fillPointer;
                    this.enqueueNewline(76);
                    fillPointer = this.bufferFillPointer;
                }
                else {
                    if ((this.buffer[fillPointer++] = ch2) != ' ' || this.prettyPrintingMode <= 1 || this.currentBlock >= 0) {
                        continue;
                    }
                    this.bufferFillPointer = fillPointer;
                    this.enqueueNewline(83);
                    fillPointer = this.bufferFillPointer;
                }
            }
            this.bufferFillPointer = fillPointer;
        }
    }
    
    @Override
    public void write(final char[] str) {
        this.write(str, 0, str.length);
    }
    
    @Override
    public void write(final char[] str, int start, int count) {
        this.wordEndSeen = false;
        if (this.isPassingThrough()) {
            int i = count;
            while (true) {
                while (--i >= 0) {
                    final char ch = str[start + i];
                    if (ch == '\r' || ch == '\n') {
                        this.bufferStartColumn = count - (i + 1);
                        this.writeToBase(str, start, count);
                        return;
                    }
                }
                this.bufferStartColumn += count;
                continue;
            }
        }
        final int end = start + count;
    Label_0087:
        while (count > 0) {
            for (int j = start; j < end; ++j) {
                final char c;
                if (this.prettyPrintingMode > 0 && ((c = str[j]) == '\n' || (c == ' ' && this.currentBlock < 0))) {
                    this.write(str, start, j - start);
                    this.write(c);
                    start = j + 1;
                    count = end - start;
                    continue Label_0087;
                }
            }
            do {
                final int available = this.ensureSpaceInBuffer(count);
                final int cnt = (available < count) ? available : count;
                final int fillPointer = this.bufferFillPointer;
                final int newFillPtr = fillPointer + cnt;
                for (int k = fillPointer; k < newFillPtr; ++k) {
                    this.buffer[k] = str[start++];
                }
                this.bufferFillPointer = newFillPtr;
                count -= cnt;
            } while (count != 0);
        }
    }
    
    private void writeToBase(final char[] buf, final int start, final int count) {
        try {
            this.out.write(buf, start, count);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private void writeToBase(final String str, final int start, final int count) {
        try {
            this.out.write(str, start, count);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private void writeToBase(final String str) {
        this.writeToBase(str, 0, str.length());
    }
    
    private void writeToBase(final int ch) {
        try {
            this.out.write(ch);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public int writePositionMarker(final boolean grouping) {
        final int result = this.enqueue(7, 3);
        this.queueInts[result + 2] = 0;
        final int[] queueInts = this.queueInts;
        final int n = result;
        queueInts[n] |= (grouping ? 1 : 0) << 8;
        return result;
    }
    
    public void writeBackReference(final int posn) {
        if (!this.reallySharing) {
            this.reallySharing = true;
        }
        final int result = this.enqueue(8, 3);
        this.queueInts[result + 2] = posn;
        this.queueInts[posn + 2] = 1;
    }
    
    public void writePairEnd(final Integer posn) {
        final int result = this.enqueue(9, 3);
        this.queueInts[result + 2] = posn;
    }
    
    public void writeEndOfExpression() {
        this.enqueue(10, 2);
    }
    
    private void pushLogicalBlock(final int column, final int perLineEnd, final int prefixLength, final int suffixLength, final int sectionStartLine) {
        final int newLength = this.blockDepth + 6;
        if (newLength >= this.blocks.length) {
            final int[] newBlocks = new int[2 * this.blocks.length];
            System.arraycopy(this.blocks, 0, newBlocks, 0, this.blockDepth);
            this.blocks = newBlocks;
        }
        this.blockDepth = newLength;
        this.blocks[this.blockDepth - 1] = column;
        this.blocks[this.blockDepth - 2] = column;
        this.blocks[this.blockDepth - 3] = perLineEnd;
        this.blocks[this.blockDepth - 4] = prefixLength;
        this.blocks[this.blockDepth - 5] = suffixLength;
        this.blocks[this.blockDepth - 6] = sectionStartLine;
    }
    
    void reallyStartLogicalBlock(final int column, final String prefix, final String suffix) {
        final int perLineEnd = this.getPerLinePrefixEnd();
        final int prefixLength = this.getPrefixLength();
        final int suffixLength = this.getSuffixLength();
        this.pushLogicalBlock(column, perLineEnd, prefixLength, suffixLength, this.lineNumber);
        if (!this.isDomTerm()) {
            this.setIndentation(column);
        }
        if (prefix != null) {
            this.blocks[this.blockDepth - 3] = column;
            final int plen = prefix.length();
            prefix.getChars(0, plen, this.suffix, column - plen);
        }
        if (suffix != null) {
            final char[] totalSuffix = this.suffix;
            int totalSuffixLen = totalSuffix.length;
            final int additional = suffix.length();
            final int newSuffixLen = suffixLength + additional;
            if (newSuffixLen > totalSuffixLen) {
                final int newTotalSuffixLen = enoughSpace(totalSuffixLen, additional);
                System.arraycopy(totalSuffix, totalSuffixLen - suffixLength, this.suffix = new char[newTotalSuffixLen], newTotalSuffixLen - suffixLength, suffixLength);
                totalSuffixLen = newTotalSuffixLen;
            }
            suffix.getChars(0, additional, totalSuffix, totalSuffixLen - newSuffixLen);
            this.blocks[this.blockDepth - 5] = newSuffixLen;
        }
    }
    
    int enqueueTab(final int flags, final int colnum, final int colinc) {
        final int addr = this.enqueue(6, 5);
        this.queueInts[addr + 2] = flags;
        this.queueInts[addr + 3] = colnum;
        this.queueInts[addr + 4] = colinc;
        return addr;
    }
    
    private static int enoughSpace(final int current, final int want) {
        final int scaled = current + (current >> 1);
        final int enough = current + (5 * want >> 2);
        return (scaled > enough) ? scaled : enough;
    }
    
    private void setIndentation(int column) {
        char[] prefix = this.prefix;
        final int prefixLen = prefix.length;
        final int current = this.getPrefixLength();
        final int minimum = this.getPerLinePrefixEnd();
        if (minimum > column) {
            column = minimum;
        }
        if (column > prefixLen) {
            prefix = new char[enoughSpace(prefixLen, column - prefixLen)];
            System.arraycopy(this.prefix, 0, prefix, 0, current);
            this.prefix = prefix;
        }
        if (column > current) {
            for (int i = current; i < column; ++i) {
                prefix[i] = ' ';
            }
        }
        this.blocks[this.blockDepth - 4] = column;
    }
    
    void reallyEndLogicalBlock() {
        final int oldIndent = this.getPrefixLength();
        this.blockDepth -= 6;
        final int newIndent = this.getPrefixLength();
        if (newIndent > oldIndent) {
            for (int i = oldIndent; i < newIndent; ++i) {
                this.prefix[i] = ' ';
            }
        }
    }
    
    public int enqueue(final int kind, final int size) {
        final int oldLength = this.queueInts.length;
        final int endAvail = oldLength - this.queueTail - this.queueSize;
        if (endAvail > 0 && size > endAvail && !this.sharing) {
            this.enqueue(0, endAvail);
        }
        if (endAvail < size && (this.sharing || oldLength - this.queueSize < size)) {
            final int newLength;
            final int enough = newLength = enoughSpace(oldLength, size);
            final int[] newInts = new int[newLength];
            final String[] newStrings = new String[newLength];
            if (this.sharing) {
                System.arraycopy(this.queueInts, 0, newInts, 0, this.queueInts.length);
                System.arraycopy(this.queueStrings, 0, newStrings, 0, this.queueStrings.length);
            }
            else {
                final int queueHead = this.queueTail + this.queueSize - oldLength;
                if (queueHead > 0) {
                    System.arraycopy(this.queueInts, 0, newInts, 0, queueHead);
                    System.arraycopy(this.queueStrings, 0, newStrings, 0, queueHead);
                }
                final int part1Len = oldLength - this.queueTail;
                final int deltaLength = newLength - oldLength;
                System.arraycopy(this.queueInts, this.queueTail, newInts, this.queueTail + deltaLength, part1Len);
                System.arraycopy(this.queueStrings, this.queueTail, newStrings, this.queueTail + deltaLength, part1Len);
                if (this.currentBlock >= this.queueTail) {
                    this.currentBlock += deltaLength;
                }
                this.queueTail += deltaLength;
            }
            this.queueInts = newInts;
            this.queueStrings = newStrings;
        }
        int addr = this.queueTail + this.queueSize;
        if (!this.sharing && addr >= this.queueInts.length) {
            addr -= this.queueInts.length;
        }
        this.queueInts[addr + 0] = (kind | size << 16);
        if (size > 1) {
            this.queueInts[addr + 1] = this.indexPosn(this.bufferFillPointer);
        }
        this.queueSize += size;
        return addr;
    }
    
    private void enqueueNewline(final int kind) {
        this.wordEndSeen = false;
        final int depth = this.pendingBlocksCount;
        final int newline = this.enqueue(2, 5);
        this.queueInts[newline + 4] = kind;
        this.queueInts[newline + 2] = this.pendingBlocksCount;
        this.queueInts[newline + 3] = 0;
        int size;
        for (int entry = this.queueTail, todo = this.queueSize; todo > 0; todo -= size, entry += size) {
            if (entry == this.queueInts.length) {
                entry = 0;
            }
            if (entry == newline) {
                break;
            }
            final int type = this.getQueueType(entry);
            if ((type == 2 || type == 4) && this.queueInts[entry + 3] == 0 && depth <= this.queueInts[entry + 2]) {
                int delta = newline - entry;
                if (delta < 0) {
                    delta += this.queueInts.length;
                }
                this.queueInts[entry + 3] = delta;
            }
            size = this.getQueueSize(entry);
        }
        if (!this.sharing) {
            this.maybeOutput(kind == 76 || kind == 82 || kind == 68, false);
        }
    }
    
    @Override
    public final void writeBreak(final int kind) {
        if (this.prettyPrintingMode > 0 || this.sharing) {
            this.enqueueNewline(kind);
        }
    }
    
    @Override
    public void writeBreakLinear() {
        this.writeBreak(78);
    }
    
    public int enqueueIndent(final char kind, final int amount) {
        final int result = this.enqueue(3, 4);
        this.queueInts[result + 2] = kind;
        this.queueInts[result + 3] = amount;
        return result;
    }
    
    public void addIndentation(final int amount, final boolean current) {
        if (this.prettyPrintingMode > 0) {
            this.enqueueIndent(current ? 'C' : 'B', amount);
        }
    }
    
    @Override
    public void startLogicalBlock(final String prefix, final boolean perLine, final String suffix) {
        if (this.queueSize == 0 && this.bufferFillPointer == 0) {
            final Object llen = PrettyWriter.lineLengthLoc.get(null);
            if (llen == null) {
                this.lineLength = 80;
            }
            else {
                this.lineLength = Integer.parseInt(llen.toString());
            }
            final Object mwidth = PrettyWriter.miserWidthLoc.get(null);
            if (mwidth == null || mwidth == Boolean.FALSE || mwidth == LList.Empty) {
                this.miserWidth = -1;
            }
            else {
                this.miserWidth = Integer.parseInt(mwidth.toString());
            }
            final Object indent = PrettyWriter.indentLoc.get(null);
        }
        if (prefix != null && (!perLine || !this.isDomTerm())) {
            this.write(prefix);
        }
        if (this.prettyPrintingMode == 0) {
            return;
        }
        final int start = this.enqueue(4, 7);
        this.queueInts[start + 2] = this.pendingBlocksCount;
        this.queueStrings[start + 5] = (perLine ? prefix : null);
        this.queueStrings[start + 6] = suffix;
        ++this.pendingBlocksCount;
        int outerBlock = this.currentBlock;
        if (outerBlock < 0) {
            outerBlock = 0;
        }
        else {
            outerBlock -= start;
            if (outerBlock > 0) {
                outerBlock -= this.queueInts.length;
            }
        }
        this.queueInts[start + 4] = outerBlock;
        this.queueInts[start + 3] = 0;
        this.currentBlock = start;
    }
    
    public void endLogicalBlock() {
        final int end = this.enqueue(5, 2);
        --this.pendingBlocksCount;
        if (this.currentBlock < 0) {
            final int suffixLength = this.blocks[this.blockDepth - 5];
            final int suffixPreviousLength = this.blocks[this.blockDepth - 6 - 5];
            if (suffixLength > suffixPreviousLength) {
                this.write(this.suffix, this.suffix.length - suffixLength, suffixLength - suffixPreviousLength);
            }
            this.currentBlock = -1;
            return;
        }
        final int start = this.currentBlock;
        int outerBlock = this.queueInts[start + 4];
        if (outerBlock == 0) {
            this.currentBlock = -1;
        }
        else {
            int qtailFromStart = this.queueTail - start;
            if (qtailFromStart > 0) {
                qtailFromStart -= this.queueInts.length;
            }
            if (outerBlock < qtailFromStart) {
                this.currentBlock = -1;
            }
            else {
                outerBlock += start;
                if (outerBlock < 0) {
                    outerBlock += this.queueInts.length;
                }
                this.currentBlock = outerBlock;
            }
        }
        final String suffix = this.queueStrings[start + 6];
        if (suffix != null) {
            this.write(suffix);
        }
        int endFromStart = end - start;
        if (endFromStart < 0) {
            endFromStart += this.queueInts.length;
        }
        this.queueInts[start + 4] = endFromStart;
    }
    
    @Override
    public void endLogicalBlock(final String suffix) {
        if (this.prettyPrintingMode > 0) {
            this.endLogicalBlock();
        }
        else if (suffix != null) {
            this.write(suffix);
        }
    }
    
    int computeTabSize(final int tab, final int sectionStart, final int column) {
        final int flags = this.queueInts[tab + 2];
        final boolean isSection = (flags & 0x1) != 0x0;
        final boolean isRelative = (flags & 0x2) != 0x0;
        final int origin = isSection ? sectionStart : 0;
        int colnum = this.queueInts[tab + 3];
        int colinc = this.queueInts[tab + 4];
        if (isRelative) {
            if (colinc > 1) {
                final int newposn = column + colnum;
                final int rem = newposn % colinc;
                if (rem != 0) {
                    colnum += (colinc = rem);
                }
            }
            return colnum;
        }
        if (column <= colnum + origin) {
            return column + origin - column;
        }
        return colinc - (column - origin) % colinc;
    }
    
    int indexColumn(final int index) {
        int column = this.bufferStartColumn;
        int sectionStart = this.getSectionColumn();
        final int endPosn = this.indexPosn(index);
        int size;
        for (int op = this.queueTail, todo = this.queueSize; todo > 0; todo -= size, op += size) {
            if (op >= this.queueInts.length) {
                op = 0;
            }
            final int type = this.getQueueType(op);
            if (type != 0) {
                final int posn = this.queueInts[op + 1];
                if (posn >= endPosn) {
                    break;
                }
                if (type == 6) {
                    column += this.computeTabSize(op, sectionStart, column + this.posnIndex(posn));
                }
                else if (type == 2 || type == 4) {
                    sectionStart = column + this.posnIndex(this.queueInts[op + 1]);
                }
            }
            size = this.getQueueSize(op);
        }
        return column + index;
    }
    
    void expandTabs(final int through) {
        int numInsertions = 0;
        int additional = 0;
        int column = this.bufferStartColumn;
        int sectionStart = this.getSectionColumn();
        int op = this.queueTail;
        int todo = this.queueSize;
        final int blocksUsed = 6 * this.pendingBlocksCount;
        while (todo > 0) {
            if (op == this.queueInts.length) {
                op = 0;
            }
            if (op == through) {
                break;
            }
            final int type = this.getQueueType(op);
            if (type == 6) {
                final int index = this.posnIndex(this.queueInts[op + 1]);
                final int tabsize = this.computeTabSize(op, sectionStart, column + index);
                if (tabsize != 0) {
                    if (blocksUsed + 2 * numInsertions + 1 >= this.blocks.length) {
                        final int[] newBlocks = new int[2 * this.blocks.length];
                        System.arraycopy(this.blocks, 0, newBlocks, 0, this.blocks.length);
                        this.blocks = newBlocks;
                    }
                    this.blocks[blocksUsed + 2 * numInsertions] = index;
                    this.blocks[blocksUsed + 2 * numInsertions + 1] = tabsize;
                    ++numInsertions;
                    additional += tabsize;
                    column += tabsize;
                }
            }
            else if (op == 2 || op == 4) {
                sectionStart = column + this.posnIndex(this.queueInts[op + 1]);
            }
            final int size = this.getQueueSize(op);
            todo -= size;
            op += size;
        }
        if (numInsertions > 0) {
            final int fillPtr = this.bufferFillPointer;
            final int newFillPtr = fillPtr + additional;
            char[] newBuffer;
            final char[] buffer = newBuffer = this.buffer;
            final int length = buffer.length;
            int end = fillPtr;
            if (newFillPtr > length) {
                final int newLength = enoughSpace(fillPtr, additional);
                newBuffer = new char[newLength];
                this.buffer = newBuffer;
            }
            this.bufferFillPointer = newFillPtr;
            this.bufferOffset -= additional;
            int i = numInsertions;
            while (--i >= 0) {
                final int srcpos = this.blocks[blocksUsed + 2 * i];
                final int amount = this.blocks[blocksUsed + 2 * i + 1];
                final int dstpos = srcpos + additional;
                System.arraycopy(buffer, srcpos, newBuffer, dstpos, end - srcpos);
                for (int j = dstpos - amount; j < dstpos; ++j) {
                    newBuffer[j] = ' ';
                }
                additional -= amount;
                end = srcpos;
            }
            if (newBuffer != buffer) {
                System.arraycopy(buffer, 0, newBuffer, 0, end);
            }
        }
    }
    
    int ensureSpaceInBuffer(final int want) {
        final char[] buffer = this.buffer;
        final int length = buffer.length;
        final int fillPtr = this.bufferFillPointer;
        final int available = length - fillPtr;
        if (available > 0) {
            return available;
        }
        if (this.out != null && fillPtr > this.lineLength && !this.sharing && !this.isDomTerm()) {
            if (!this.maybeOutput(false, false)) {
                this.outputPartialLine();
            }
            return this.ensureSpaceInBuffer(want);
        }
        final int newLength = enoughSpace(length, want);
        final char[] newBuffer = new char[newLength];
        this.buffer = newBuffer;
        int i = fillPtr;
        while (--i >= 0) {
            newBuffer[i] = buffer[i];
        }
        return newLength - fillPtr;
    }
    
    boolean maybeOutput(final boolean forceNewlines, final boolean flushing) {
        boolean outputAnything = false;
    Label_0953:
        while (this.queueSize > 0) {
            if (this.queueTail >= this.queueInts.length) {
                this.queueTail = 0;
            }
            int next = this.queueTail;
            final int type = this.getQueueType(next);
            if (this.isDomTerm()) {
                if (this.bufferFillPointer > 0 && type != 2 && type != 0) {
                    final int count = this.posnIndex(this.queueInts[next + 1]);
                    if (count > 0) {
                        this.writeToBase(this.buffer, 0, count);
                        System.arraycopy(this.buffer, count, this.buffer, 0, this.bufferFillPointer - count);
                        this.bufferOffset += count;
                        this.bufferFillPointer -= count;
                        this.bufferStartColumn += count;
                    }
                }
                switch (type) {
                    case 2: {
                        outputAnything = true;
                        this.outputLine(next, flushing);
                        break;
                    }
                    case 3: {
                        if (!this.isMisering()) {
                            final int kind = this.queueInts[next + 2];
                            final int indent = this.queueInts[next + 3];
                            final boolean blockRelative = kind == 66;
                            this.writeToBase("\u001b]" + (blockRelative ? "113" : "112") + ";" + indent + "\u0007");
                            break;
                        }
                        break;
                    }
                    case 4: {
                        final String prefix = this.queueStrings[next + 5];
                        final StringBuilder sbuf = new StringBuilder("\u001b]110;");
                        if (prefix != null) {
                            Strings.printJson(prefix, sbuf);
                        }
                        sbuf.append("\u0007");
                        this.writeToBase(sbuf.toString());
                        final String suffix = this.queueStrings[next + 6];
                        this.reallyStartLogicalBlock(this.posnColumn(this.queueInts[next + 1]), "", suffix);
                        if (this.currentBlock == next) {
                            this.currentBlock = -1;
                            break;
                        }
                        break;
                    }
                    case 5: {
                        this.writeToBase("\u001b]111\u0007");
                        this.blockDepth -= 6;
                        break;
                    }
                    case 6: {
                        this.expandTabs(next);
                        break;
                    }
                }
            }
            else {
                switch (type) {
                    case 2: {
                        int fits = -1;
                        boolean cond = false;
                        switch (this.queueInts[next + 4]) {
                            default: {
                                cond = true;
                                break;
                            }
                            case 77: {
                                cond = this.isMisering();
                                break;
                            }
                            case 70: {
                                if (this.isMisering() || this.lineNumber > this.getSectionStartLine()) {
                                    cond = true;
                                    break;
                                }
                            }
                            case 83: {
                                int end = this.queueInts[next + 3];
                                if (end == 0) {
                                    end = -1;
                                }
                                else {
                                    end += next;
                                    if (end >= this.queueInts.length) {
                                        end -= this.queueInts.length;
                                    }
                                }
                                fits = this.fitsOnLine(end, forceNewlines);
                                if (fits > 0) {
                                    cond = false;
                                    break;
                                }
                                if (fits < 0 || flushing) {
                                    cond = true;
                                    break;
                                }
                                break Label_0953;
                            }
                        }
                        if (!cond) {
                            break;
                        }
                        outputAnything = true;
                        if (flushing && fits == 0) {
                            this.outputPartialLine();
                            break;
                        }
                        this.outputLine(next, flushing);
                        break;
                    }
                    case 3: {
                        if (!this.isMisering()) {
                            final int kind2 = this.queueInts[next + 2];
                            int indent2 = this.queueInts[next + 3];
                            if (kind2 == 66) {
                                indent2 += this.getStartColumn();
                            }
                            else {
                                indent2 += this.posnColumn(this.queueInts[next + 1]);
                            }
                            this.setIndentation(indent2);
                            break;
                        }
                        break;
                    }
                    case 4: {
                        final int start = next;
                        int end2 = this.queueInts[next + 3];
                        end2 = ((end2 > 0) ? ((end2 + next) % this.queueInts.length) : -1);
                        final int fits = this.fitsOnLine(end2, forceNewlines);
                        if (fits > 0) {
                            final int endr = this.queueInts[next + 4];
                            next = (endr + next) % this.queueInts.length;
                            this.expandTabs(next);
                            this.queueTail = next;
                            this.queueSize -= endr;
                        }
                        else {
                            if (fits >= 0 && !flushing) {
                                break Label_0953;
                            }
                            final String prefix2 = this.queueStrings[next + 5];
                            final String suffix2 = this.queueStrings[next + 6];
                            this.reallyStartLogicalBlock(this.posnColumn(this.queueInts[next + 1]), prefix2, suffix2);
                        }
                        if (this.currentBlock == start) {
                            this.currentBlock = -1;
                            break;
                        }
                        break;
                    }
                    case 5: {
                        this.reallyEndLogicalBlock();
                        break;
                    }
                    case 6: {
                        this.expandTabs(next);
                        break;
                    }
                }
            }
            final int size = this.getQueueSize(this.queueTail);
            this.queueSize -= size;
            this.queueTail = next + size;
        }
        return outputAnything;
    }
    
    protected int getMiserWidth() {
        return this.miserWidth;
    }
    
    boolean isMisering() {
        final int mwidth = this.getMiserWidth();
        return mwidth > 0 && this.lineLength - this.getStartColumn() <= mwidth;
    }
    
    int getMaxLines() {
        return -1;
    }
    
    boolean printReadably() {
        return true;
    }
    
    int fitsOnLine(final int sectionEnd, final boolean forceNewlines) {
        int available = this.lineLength;
        if (!this.printReadably() && this.getMaxLines() == this.lineNumber) {
            available -= 3;
            available -= this.getSuffixLength();
        }
        if (sectionEnd >= 0) {
            return (this.posnColumn(this.queueInts[sectionEnd + 1]) <= available) ? 1 : -1;
        }
        if (forceNewlines) {
            return -1;
        }
        if (this.indexColumn(this.bufferFillPointer) > available) {
            return -1;
        }
        return 0;
    }
    
    public void lineAbbreviationHappened() {
    }
    
    private void outputLine(final int newline, final boolean flushing) {
        final char[] buffer = this.buffer;
        final int kind = this.queueInts[newline + 4];
        final boolean isLiteral = kind == 76;
        final int amountToConsume = this.posnIndex(this.queueInts[newline + 1]);
        int amountToPrint = 0;
        Label_0105: {
            if (isLiteral || kind == 68 || this.isDomTerm()) {
                amountToPrint = amountToConsume;
            }
            else {
                int i = amountToConsume;
                while (--i >= 0) {
                    if (buffer[i] != ' ') {
                        amountToPrint = i + 1;
                        break Label_0105;
                    }
                }
                amountToPrint = 0;
            }
        }
        this.writeToBase(buffer, 0, amountToPrint);
        int lineNumber = this.lineNumber;
        ++lineNumber;
        if (!this.printReadably()) {
            final int maxLines = this.getMaxLines();
            if (maxLines > 0 && lineNumber >= maxLines) {
                this.writeToBase(" ..");
                final int suffixLength = this.getSuffixLength();
                if (suffixLength != 0) {
                    final char[] suffix = this.suffix;
                    final int len = suffix.length;
                    this.writeToBase(suffix, len - suffixLength, suffixLength);
                }
                this.lineAbbreviationHappened();
            }
        }
        this.lineNumber = lineNumber;
        if (kind != 68) {
            if (this.isDomTerm()) {
                String cmd = null;
                Label_0329: {
                    switch (kind) {
                        case 70:
                        case 83: {
                            cmd = "\u001b]115\u0007";
                            break Label_0329;
                        }
                        case 78: {
                            cmd = "\u001b]116\u0007";
                            break Label_0329;
                        }
                        case 77: {
                            cmd = "\u001b]117\u0007";
                            break Label_0329;
                        }
                        case 76: {
                            if (this.blockDepth == 6) {
                                cmd = "\n";
                                break Label_0329;
                            }
                            break;
                        }
                    }
                    cmd = "\u001b]118\u0007";
                }
                this.writeToBase(cmd);
            }
            else {
                this.writeToBase(10);
            }
        }
        this.bufferStartColumn = ((kind != 68) ? 0 : this.getColumnNumber());
        final int fillPtr = this.bufferFillPointer;
        final int prefixLen = isLiteral ? this.getPerLinePrefixEnd() : this.getPrefixLength();
        final int shift = amountToConsume - prefixLen;
        final int newFillPtr = fillPtr - shift;
        char[] newBuffer = buffer;
        final int bufferLength = buffer.length;
        if (newFillPtr > bufferLength) {
            newBuffer = new char[enoughSpace(bufferLength, newFillPtr - bufferLength)];
            this.buffer = newBuffer;
        }
        System.arraycopy(buffer, amountToConsume, newBuffer, prefixLen, fillPtr - amountToConsume);
        System.arraycopy(this.prefix, 0, newBuffer, 0, prefixLen);
        this.bufferFillPointer = newFillPtr;
        this.bufferOffset += shift;
        if (!isLiteral) {
            this.blocks[this.blockDepth - 2] = prefixLen;
            this.blocks[this.blockDepth - 6] = lineNumber;
        }
    }
    
    void outputPartialLine() {
        int tail = this.queueTail;
        while (this.queueSize > 0 && this.getQueueType(tail) == 0) {
            final int size = this.getQueueSize(tail);
            this.queueSize -= size;
            tail += size;
            if (tail == this.queueInts.length) {
                tail = 0;
            }
            this.queueTail = tail;
        }
        final int fillPtr = this.bufferFillPointer;
        final int count = (this.queueSize > 0) ? this.posnIndex(this.queueInts[tail + 1]) : fillPtr;
        final int newFillPtr = fillPtr - count;
        if (count <= 0) {
            throw new Error("outputPartialLine called when nothing can be output.");
        }
        this.writeToBase(this.buffer, 0, count);
        this.bufferFillPointer = count;
        this.bufferStartColumn = this.getColumnNumber();
        System.arraycopy(this.buffer, count, this.buffer, 0, newFillPtr);
        this.bufferFillPointer = newFillPtr;
        this.bufferOffset += count;
    }
    
    public void resolveBackReferences() {
        if (!this.reallySharing) {
            return;
        }
        int posnMarkerCount = 0;
        final GapBuffer gbuffer = new GapBuffer(this.buffer, this.buffer.length);
        int delta = 0;
        int tail = this.queueTail;
        int next;
        int size;
        for (int todo = this.queueSize; todo > 0; todo -= size, tail = next + size) {
            if (tail >= this.queueInts.length) {
                tail = 0;
            }
            next = tail;
            final int type = this.getQueueType(next);
            if (type != 0) {
                gbuffer.addUpTo(this.posnIndex(this.queueInts[next + 1]));
            }
            switch (type) {
                case 7: {
                    final int oldDelta = delta;
                    if (this.posnMarkerActive(next)) {
                        if (this.posnMarkerIsGrouping(next)) {
                            gbuffer.add('.');
                            gbuffer.add(' ');
                            delta += 2;
                        }
                        gbuffer.add('#');
                        if (this.queueInts[next + 2] == 1) {
                            this.queueInts[next + 2] = posnMarkerCount++;
                        }
                        final int reference = this.queueInts[next + 2];
                        delta += gbuffer.add(reference);
                        gbuffer.add('=');
                        delta += 2;
                        if (this.posnMarkerIsGrouping(next)) {
                            gbuffer.add('(');
                            ++delta;
                        }
                        final int[] queueInts = this.queueInts;
                        final int n = next + 1;
                        queueInts[n] += delta - oldDelta;
                        break;
                    }
                    break;
                }
                case 8: {
                    final int oldDelta = delta;
                    final int relativeAddress = this.queueInts[next + 2];
                    final int count = this.queueInts[relativeAddress + 2];
                    gbuffer.add('#');
                    delta += gbuffer.add(count);
                    gbuffer.add('#');
                    delta += 2;
                    final int[] queueInts2 = this.queueInts;
                    final int n2 = next + 1;
                    queueInts2[n2] += delta - oldDelta;
                    break;
                }
                case 9: {
                    final int relativeAddress = this.queueInts[next + 2];
                    if (this.posnMarkerActive(relativeAddress)) {
                        gbuffer.add(')');
                        ++delta;
                        final int[] queueInts3 = this.queueInts;
                        final int n3 = next + 1;
                        ++queueInts3[n3];
                        break;
                    }
                    break;
                }
                default: {
                    final int[] queueInts4 = this.queueInts;
                    final int n4 = next + 1;
                    queueInts4[n4] += delta;
                    break;
                }
            }
            size = this.getQueueSize(tail);
        }
        this.bufferFillPointer += delta;
        this.buffer = gbuffer.restoreBuffer();
        posnMarkerCount = 1;
    }
    
    public void forcePrettyOutput() {
        this.enqueueNewline(68);
        this.maybeOutput(false, true);
        if (this.bufferFillPointer > 0) {
            this.outputPartialLine();
        }
        this.expandTabs(-1);
        this.bufferStartColumn = this.getColumnNumber();
        this.writeToBase(this.buffer, 0, this.bufferFillPointer);
        this.bufferFillPointer = 0;
        final int queueSize = 0;
        this.bufferOffset = queueSize;
        this.queueTail = queueSize;
        this.queueSize = queueSize;
    }
    
    @Override
    public void flush() {
        if (this.out == null) {
            return;
        }
        try {
            this.forcePrettyOutput();
            this.out.flush();
        }
        catch (IOException ex) {
            throw new RuntimeException(ex.toString());
        }
    }
    
    @Override
    public void close() {
        if (this.out != null) {
            this.forcePrettyOutput();
            super.close();
            this.out = null;
        }
        this.buffer = null;
    }
    
    public void closeThis() throws IOException {
        if (this.out != null) {
            this.forcePrettyOutput();
            this.out = null;
        }
        this.buffer = null;
    }
    
    public boolean atLineStart() {
        return this.getColumnNumber() == 0;
    }
    
    public int getColumnNumber() {
        int i = this.bufferFillPointer;
        while (--i >= 0) {
            final char ch = this.buffer[i];
            if (ch == '\n' || ch == '\r') {
                return this.bufferFillPointer - (i + 1);
            }
        }
        return this.bufferStartColumn + this.bufferFillPointer;
    }
    
    public void setColumnNumber(final int column) {
        this.bufferStartColumn += column - this.getColumnNumber();
    }
    
    public void clearBuffer() {
        this.bufferStartColumn = 0;
        this.bufferFillPointer = 0;
        this.lineNumber = 0;
        this.bufferOffset = 0;
        this.blockDepth = 6;
        this.queueTail = 0;
        this.queueSize = 0;
        this.pendingBlocksCount = 0;
    }
    
    static {
        PrettyWriter.lineLengthLoc = new ThreadLocation("line-length");
        PrettyWriter.miserWidthLoc = new ThreadLocation("miser-width");
        PrettyWriter.indentLoc = new ThreadLocation("indent");
        PrettyWriter.isSharing = new ThreadLocation("print-circle");
    }
    
    private static final class GapBuffer
    {
        char[] buffer;
        char[] existingBuffer;
        int point;
        int existingIndex;
        int gapSize;
        
        public GapBuffer(final char[] existing, final int startSize) {
            this.buffer = new char[startSize];
            this.point = 0;
            this.existingIndex = 0;
            this.existingBuffer = existing;
        }
        
        public int getPoint() {
            return this.point;
        }
        
        public void add(final char ch) {
            if (this.point + 1 >= this.buffer.length) {
                this.expandBuffer(1);
            }
            this.buffer[this.point++] = ch;
        }
        
        public int add(int i) {
            int ndigits = 1;
            if (i >= 10) {
                ndigits += this.add(i / 10);
                i %= 10;
            }
            this.add((char)(48 + i));
            return ndigits;
        }
        
        public void addUpTo(final int end) {
            final int n = end - this.existingIndex;
            if (this.point + n >= this.buffer.length) {
                this.expandBuffer(n);
            }
            while (this.existingIndex < end) {
                this.buffer[this.point++] = this.existingBuffer[this.existingIndex++];
            }
        }
        
        public char[] restoreBuffer() {
            final char[] retBuffer = new char[this.buffer.length];
            System.arraycopy(this.buffer, 0, retBuffer, 0, this.point);
            return retBuffer;
        }
        
        private void expandBuffer(final int n) {
            int newLength = this.buffer.length;
            final int minimum = newLength + n;
            do {
                newLength <<= 1;
            } while (newLength < minimum);
            final char[] newBuffer = new char[newLength];
            System.arraycopy(this.buffer, 0, newBuffer, 0, this.point);
            this.buffer = newBuffer;
        }
    }
}
