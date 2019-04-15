/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.util.IntHashTable;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.PrintConsumer;
import gnu.lists.Strings;
import gnu.mapping.ThreadLocation;
import java.io.IOException;
import java.io.Writer;

public class PrettyWriter
extends PrintConsumer {
    int lineLength = 80;
    int miserWidth = 40;
    boolean isDomTerm;
    boolean sharing = false;
    boolean reallySharing = false;
    public static ThreadLocation lineLengthLoc = new ThreadLocation("line-length");
    public static ThreadLocation miserWidthLoc = new ThreadLocation("miser-width");
    public static ThreadLocation indentLoc = new ThreadLocation("indent");
    public static ThreadLocation isSharing = new ThreadLocation("print-circle");
    private int prettyPrintingMode;
    private IntHashTable idhash;
    public char[] buffer = new char[2048];
    public int bufferFillPointer;
    int bufferOffset;
    int bufferStartColumn;
    int lineNumber;
    int[] blocks = new int[60];
    private static final int LOGICAL_BLOCK_LENGTH = 6;
    private static final int BLOCK_START_COLUMN = -1;
    private static final int BLOCK_SECTION_COLUMN = -2;
    private static final int BLOCK_PER_LINE_PREFIX_END = -3;
    private static final int BLOCK_PREFIX_LENGTH = -4;
    private static final int BLOCK_SUFFIX_LENGTH = -5;
    private static final int BLOCK_SECTION_START_LINE = -6;
    int blockDepth = 6;
    char[] prefix = new char[128];
    char[] suffix = new char[128];
    static final int QUEUE_INIT_ALLOC_SIZE = 300;
    int[] queueInts = new int[300];
    String[] queueStrings = new String[300];
    int queueTail;
    private int queueSize;
    int currentBlock = -1;
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

    public PrettyWriter(Writer out) {
        super(out);
        this.setPrettyPrintingMode(1);
    }

    public PrettyWriter(Writer out, int lineLength) {
        super(out);
        this.lineLength = lineLength;
        this.setPrettyPrintingMode(lineLength > 1 ? 1 : 0);
    }

    public PrettyWriter(Writer out, boolean prettyPrintingMode) {
        super(out);
        this.setPrettyPrintingMode(prettyPrintingMode ? 1 : 0);
    }

    public boolean isDomTerm() {
        return this.isDomTerm;
    }

    public boolean initialiseIDHash() {
        Object share = isSharing.get(null);
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

    public int IDHashLookup(Object obj) {
        return this.idhash.lookup(obj);
    }

    public int IDHashGetFromIndex(int index) {
        return this.idhash.getFromIndex(index);
    }

    public int IDHashPutAtIndex(Object obj, int value, int index) {
        return this.idhash.putAtIndex(obj, value, index);
    }

    public int IDHashRemove(Object obj) {
        return this.idhash.remove(obj);
    }

    public void setPrettyPrintingMode(int mode) {
        this.prettyPrintingMode = mode;
    }

    public void setSharing(boolean sharing) {
        this.sharing = sharing;
    }

    public int getPrettyPrintingMode() {
        return this.prettyPrintingMode;
    }

    public boolean isPrettyPrinting() {
        return this.prettyPrintingMode > 0;
    }

    public void setPrettyPrinting(boolean mode) {
        this.setPrettyPrintingMode(mode ? 1 : 0);
    }

    private boolean isPassingThrough() {
        return this.buffer.length == 0 && this.out != null;
    }

    private int indexPosn(int index) {
        return index + this.bufferOffset;
    }

    private int posnIndex(int posn) {
        return posn - this.bufferOffset;
    }

    private int posnColumn(int posn) {
        return this.indexColumn(this.posnIndex(posn));
    }

    private int getQueueType(int index) {
        return this.queueInts[index] & 255;
    }

    private int getQueueSize(int index) {
        return this.queueInts[index] >> 16;
    }

    private boolean posnMarkerIsGrouping(int posn) {
        return (this.queueInts[posn] >> 8 & 1) != 0;
    }

    private boolean posnMarkerActive(int posn) {
        return this.queueInts[posn + 2] != 0;
    }

    private int getSectionColumn() {
        return this.blocks[this.blockDepth + -2];
    }

    private int getStartColumn() {
        return this.blocks[this.blockDepth + -1];
    }

    private int getPerLinePrefixEnd() {
        return this.blocks[this.blockDepth + -3];
    }

    private int getPrefixLength() {
        return this.blocks[this.blockDepth + -4];
    }

    private int getSuffixLength() {
        return this.blocks[this.blockDepth + -5];
    }

    private int getSectionStartLine() {
        return this.blocks[this.blockDepth + -6];
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
    public void write(int ch) {
        this.wordEndSeen = false;
        if (this.isPassingThrough()) {
            if (ch == 10 || ch == 13) {
                this.bufferStartColumn = 0;
            }
            this.writeToBase(ch);
        } else if (ch == 10 && this.prettyPrintingMode > 0) {
            this.enqueueNewline(76);
        } else {
            this.ensureSpaceInBuffer(1);
            int fillPointer = this.bufferFillPointer;
            this.buffer[fillPointer] = (char)ch;
            this.bufferFillPointer = 1 + fillPointer;
            if (ch == 32 && this.prettyPrintingMode > 1 && this.currentBlock < 0) {
                this.enqueueNewline(83);
            }
        }
    }

    @Override
    public void write(String str) {
        this.write(str, 0, str.length());
    }

    @Override
    public void write(String str, int start, int count) {
        this.wordEndSeen = false;
        if (this.isPassingThrough()) {
            block6 : {
                char ch;
                int i = count;
                do {
                    if (--i >= 0) continue;
                    this.bufferStartColumn += count;
                    break block6;
                } while ((ch = str.charAt(start + i)) != '\r' && ch != '\n');
                this.bufferStartColumn = count - (i + 1);
            }
            this.writeToBase(str, start, count);
            return;
        }
        while (count > 0) {
            int cnt = count;
            int available = this.ensureSpaceInBuffer(count);
            if (cnt > available) {
                cnt = available;
            }
            int fillPointer = this.bufferFillPointer;
            count -= cnt;
            while (--cnt >= 0) {
                char ch;
                if ((ch = str.charAt(start++)) == '\n' && this.prettyPrintingMode > 0) {
                    this.bufferFillPointer = fillPointer;
                    this.enqueueNewline(76);
                    fillPointer = this.bufferFillPointer;
                    continue;
                }
                this.buffer[fillPointer++] = ch;
                if (ch != ' ' || this.prettyPrintingMode <= 1 || this.currentBlock >= 0) continue;
                this.bufferFillPointer = fillPointer;
                this.enqueueNewline(83);
                fillPointer = this.bufferFillPointer;
            }
            this.bufferFillPointer = fillPointer;
        }
    }

    @Override
    public void write(char[] str) {
        this.write(str, 0, str.length);
    }

    @Override
    public void write(char[] str, int start, int count) {
        this.wordEndSeen = false;
        if (this.isPassingThrough()) {
            block6 : {
                char ch;
                int i = count;
                do {
                    if (--i >= 0) continue;
                    this.bufferStartColumn += count;
                    break block6;
                } while ((ch = str[start + i]) != '\r' && ch != '\n');
                this.bufferStartColumn = count - (i + 1);
            }
            this.writeToBase(str, start, count);
            return;
        }
        int end = start + count;
        block1 : while (count > 0) {
            int cnt;
            for (int i = start; i < end; ++i) {
                char c;
                if (this.prettyPrintingMode <= 0 || (c = str[i]) != '\n' && (c != ' ' || this.currentBlock >= 0)) continue;
                this.write(str, start, i - start);
                this.write(c);
                start = i + 1;
                count = end - start;
                continue block1;
            }
            do {
                int available;
                cnt = (available = this.ensureSpaceInBuffer(count)) < count ? available : count;
                int fillPointer = this.bufferFillPointer;
                int newFillPtr = fillPointer + cnt;
                for (int i = fillPointer; i < newFillPtr; ++i) {
                    this.buffer[i] = str[start++];
                }
                this.bufferFillPointer = newFillPtr;
            } while ((count -= cnt) != 0);
        }
    }

    private void writeToBase(char[] buf, int start, int count) {
        try {
            this.out.write(buf, start, count);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void writeToBase(String str, int start, int count) {
        try {
            this.out.write(str, start, count);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void writeToBase(String str) {
        this.writeToBase(str, 0, str.length());
    }

    private void writeToBase(int ch) {
        try {
            this.out.write(ch);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int writePositionMarker(boolean grouping) {
        int result = this.enqueue(7, 3);
        this.queueInts[result + 2] = 0;
        int[] arrn = this.queueInts;
        int n = result;
        arrn[n] = arrn[n] | (grouping ? 1 : 0) << 8;
        return result;
    }

    public void writeBackReference(int posn) {
        if (!this.reallySharing) {
            this.reallySharing = true;
        }
        int result = this.enqueue(8, 3);
        this.queueInts[result + 2] = posn;
        this.queueInts[posn + 2] = 1;
    }

    public void writePairEnd(Integer posn) {
        int result = this.enqueue(9, 3);
        this.queueInts[result + 2] = posn;
    }

    public void writeEndOfExpression() {
        this.enqueue(10, 2);
    }

    private void pushLogicalBlock(int column, int perLineEnd, int prefixLength, int suffixLength, int sectionStartLine) {
        int newLength = this.blockDepth + 6;
        if (newLength >= this.blocks.length) {
            int[] newBlocks = new int[2 * this.blocks.length];
            System.arraycopy(this.blocks, 0, newBlocks, 0, this.blockDepth);
            this.blocks = newBlocks;
        }
        this.blockDepth = newLength;
        this.blocks[this.blockDepth + -1] = column;
        this.blocks[this.blockDepth + -2] = column;
        this.blocks[this.blockDepth + -3] = perLineEnd;
        this.blocks[this.blockDepth + -4] = prefixLength;
        this.blocks[this.blockDepth + -5] = suffixLength;
        this.blocks[this.blockDepth + -6] = sectionStartLine;
    }

    void reallyStartLogicalBlock(int column, String prefix, String suffix) {
        int perLineEnd = this.getPerLinePrefixEnd();
        int prefixLength = this.getPrefixLength();
        int suffixLength = this.getSuffixLength();
        this.pushLogicalBlock(column, perLineEnd, prefixLength, suffixLength, this.lineNumber);
        if (!this.isDomTerm()) {
            this.setIndentation(column);
        }
        if (prefix != null) {
            this.blocks[this.blockDepth + -3] = column;
            int plen = prefix.length();
            prefix.getChars(0, plen, this.suffix, column - plen);
        }
        if (suffix != null) {
            char[] totalSuffix = this.suffix;
            int totalSuffixLen = totalSuffix.length;
            int additional = suffix.length();
            int newSuffixLen = suffixLength + additional;
            if (newSuffixLen > totalSuffixLen) {
                int newTotalSuffixLen = PrettyWriter.enoughSpace(totalSuffixLen, additional);
                this.suffix = new char[newTotalSuffixLen];
                System.arraycopy(totalSuffix, totalSuffixLen - suffixLength, this.suffix, newTotalSuffixLen - suffixLength, suffixLength);
                totalSuffixLen = newTotalSuffixLen;
            }
            suffix.getChars(0, additional, totalSuffix, totalSuffixLen - newSuffixLen);
            this.blocks[this.blockDepth + -5] = newSuffixLen;
        }
    }

    int enqueueTab(int flags, int colnum, int colinc) {
        int addr = this.enqueue(6, 5);
        this.queueInts[addr + 2] = flags;
        this.queueInts[addr + 3] = colnum;
        this.queueInts[addr + 4] = colinc;
        return addr;
    }

    private static int enoughSpace(int current, int want) {
        int scaled = current + (current >> 1);
        int enough = current + (5 * want >> 2);
        return scaled > enough ? scaled : enough;
    }

    private void setIndentation(int column) {
        char[] prefix = this.prefix;
        int prefixLen = prefix.length;
        int current = this.getPrefixLength();
        int minimum = this.getPerLinePrefixEnd();
        if (minimum > column) {
            column = minimum;
        }
        if (column > prefixLen) {
            prefix = new char[PrettyWriter.enoughSpace(prefixLen, column - prefixLen)];
            System.arraycopy(this.prefix, 0, prefix, 0, current);
            this.prefix = prefix;
        }
        if (column > current) {
            for (int i = current; i < column; ++i) {
                prefix[i] = 32;
            }
        }
        this.blocks[this.blockDepth + -4] = column;
    }

    void reallyEndLogicalBlock() {
        int oldIndent = this.getPrefixLength();
        this.blockDepth -= 6;
        int newIndent = this.getPrefixLength();
        if (newIndent > oldIndent) {
            for (int i = oldIndent; i < newIndent; ++i) {
                this.prefix[i] = 32;
            }
        }
    }

    public int enqueue(int kind, int size) {
        int oldLength = this.queueInts.length;
        int endAvail = oldLength - this.queueTail - this.queueSize;
        if (endAvail > 0 && size > endAvail && !this.sharing) {
            this.enqueue(0, endAvail);
        }
        if (endAvail < size && (this.sharing || oldLength - this.queueSize < size)) {
            int enough;
            int newLength = enough = PrettyWriter.enoughSpace(oldLength, size);
            int[] newInts = new int[newLength];
            String[] newStrings = new String[newLength];
            if (this.sharing) {
                System.arraycopy(this.queueInts, 0, newInts, 0, this.queueInts.length);
                System.arraycopy(this.queueStrings, 0, newStrings, 0, this.queueStrings.length);
            } else {
                int queueHead = this.queueTail + this.queueSize - oldLength;
                if (queueHead > 0) {
                    System.arraycopy(this.queueInts, 0, newInts, 0, queueHead);
                    System.arraycopy(this.queueStrings, 0, newStrings, 0, queueHead);
                }
                int part1Len = oldLength - this.queueTail;
                int deltaLength = newLength - oldLength;
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
        this.queueInts[addr + 0] = kind | size << 16;
        if (size > 1) {
            this.queueInts[addr + 1] = this.indexPosn(this.bufferFillPointer);
        }
        this.queueSize += size;
        return addr;
    }

    private void enqueueNewline(int kind) {
        this.wordEndSeen = false;
        int depth = this.pendingBlocksCount;
        int newline = this.enqueue(2, 5);
        this.queueInts[newline + 4] = kind;
        this.queueInts[newline + 2] = this.pendingBlocksCount;
        this.queueInts[newline + 3] = 0;
        int entry = this.queueTail;
        int todo = this.queueSize;
        while (todo > 0) {
            if (entry == this.queueInts.length) {
                entry = 0;
            }
            if (entry == newline) break;
            int type = this.getQueueType(entry);
            if ((type == 2 || type == 4) && this.queueInts[entry + 3] == 0 && depth <= this.queueInts[entry + 2]) {
                int delta = newline - entry;
                if (delta < 0) {
                    delta += this.queueInts.length;
                }
                this.queueInts[entry + 3] = delta;
            }
            int size = this.getQueueSize(entry);
            todo -= size;
            entry += size;
        }
        if (!this.sharing) {
            this.maybeOutput(kind == 76 || kind == 82 || kind == 68, false);
        }
    }

    @Override
    public final void writeBreak(int kind) {
        if (this.prettyPrintingMode > 0 || this.sharing) {
            this.enqueueNewline(kind);
        }
    }

    @Override
    public void writeBreakLinear() {
        this.writeBreak(78);
    }

    public int enqueueIndent(char kind, int amount) {
        int result = this.enqueue(3, 4);
        this.queueInts[result + 2] = kind;
        this.queueInts[result + 3] = amount;
        return result;
    }

    public void addIndentation(int amount, boolean current) {
        if (this.prettyPrintingMode > 0) {
            this.enqueueIndent(current ? (char)'C' : 'B', amount);
        }
    }

    @Override
    public void startLogicalBlock(String prefix, boolean perLine, String suffix) {
        if (this.queueSize == 0 && this.bufferFillPointer == 0) {
            Object llen = lineLengthLoc.get(null);
            this.lineLength = llen == null ? 80 : Integer.parseInt(llen.toString());
            Object mwidth = miserWidthLoc.get(null);
            this.miserWidth = mwidth == null || mwidth == Boolean.FALSE || mwidth == LList.Empty ? -1 : Integer.parseInt(mwidth.toString());
            Object indent = indentLoc.get(null);
        }
        if (!(prefix == null || perLine && this.isDomTerm())) {
            this.write(prefix);
        }
        if (this.prettyPrintingMode == 0) {
            return;
        }
        int start = this.enqueue(4, 7);
        this.queueInts[start + 2] = this.pendingBlocksCount;
        this.queueStrings[start + 5] = perLine ? prefix : null;
        this.queueStrings[start + 6] = suffix;
        ++this.pendingBlocksCount;
        int outerBlock = this.currentBlock;
        if (outerBlock < 0) {
            outerBlock = 0;
        } else if ((outerBlock -= start) > 0) {
            outerBlock -= this.queueInts.length;
        }
        this.queueInts[start + 4] = outerBlock;
        this.queueInts[start + 3] = 0;
        this.currentBlock = start;
    }

    public void endLogicalBlock() {
        int endFromStart;
        int end = this.enqueue(5, 2);
        --this.pendingBlocksCount;
        if (this.currentBlock < 0) {
            int suffixLength = this.blocks[this.blockDepth + -5];
            int suffixPreviousLength = this.blocks[this.blockDepth - 6 + -5];
            if (suffixLength > suffixPreviousLength) {
                this.write(this.suffix, this.suffix.length - suffixLength, suffixLength - suffixPreviousLength);
            }
            this.currentBlock = -1;
            return;
        }
        int start = this.currentBlock;
        int outerBlock = this.queueInts[start + 4];
        if (outerBlock == 0) {
            this.currentBlock = -1;
        } else {
            int qtailFromStart = this.queueTail - start;
            if (qtailFromStart > 0) {
                qtailFromStart -= this.queueInts.length;
            }
            if (outerBlock < qtailFromStart) {
                this.currentBlock = -1;
            } else {
                if ((outerBlock += start) < 0) {
                    outerBlock += this.queueInts.length;
                }
                this.currentBlock = outerBlock;
            }
        }
        String suffix = this.queueStrings[start + 6];
        if (suffix != null) {
            this.write(suffix);
        }
        if ((endFromStart = end - start) < 0) {
            endFromStart += this.queueInts.length;
        }
        this.queueInts[start + 4] = endFromStart;
    }

    @Override
    public void endLogicalBlock(String suffix) {
        if (this.prettyPrintingMode > 0) {
            this.endLogicalBlock();
        } else if (suffix != null) {
            this.write(suffix);
        }
    }

    int computeTabSize(int tab, int sectionStart, int column) {
        int flags = this.queueInts[tab + 2];
        boolean isSection = (flags & 1) != 0;
        boolean isRelative = (flags & 2) != 0;
        int origin = isSection ? sectionStart : 0;
        int colnum = this.queueInts[tab + 3];
        int colinc = this.queueInts[tab + 4];
        if (isRelative) {
            int newposn;
            int rem;
            if (colinc > 1 && (rem = (newposn = column + colnum) % colinc) != 0) {
                colinc = rem;
                colnum += colinc;
            }
            return colnum;
        }
        if (column <= colnum + origin) {
            return column + origin - column;
        }
        return colinc - (column - origin) % colinc;
    }

    int indexColumn(int index) {
        int column = this.bufferStartColumn;
        int sectionStart = this.getSectionColumn();
        int endPosn = this.indexPosn(index);
        int op = this.queueTail;
        int todo = this.queueSize;
        while (todo > 0) {
            int type;
            if (op >= this.queueInts.length) {
                op = 0;
            }
            if ((type = this.getQueueType(op)) != 0) {
                int posn = this.queueInts[op + 1];
                if (posn >= endPosn) break;
                if (type == 6) {
                    column += this.computeTabSize(op, sectionStart, column + this.posnIndex(posn));
                } else if (type == 2 || type == 4) {
                    sectionStart = column + this.posnIndex(this.queueInts[op + 1]);
                }
            }
            int size = this.getQueueSize(op);
            todo -= size;
            op += size;
        }
        return column + index;
    }

    void expandTabs(int through) {
        int numInsertions = 0;
        int additional = 0;
        int column = this.bufferStartColumn;
        int sectionStart = this.getSectionColumn();
        int op = this.queueTail;
        int todo = this.queueSize;
        int blocksUsed = 6 * this.pendingBlocksCount;
        while (todo > 0) {
            if (op == this.queueInts.length) {
                op = 0;
            }
            if (op == through) break;
            int type = this.getQueueType(op);
            if (type == 6) {
                int index = this.posnIndex(this.queueInts[op + 1]);
                int tabsize = this.computeTabSize(op, sectionStart, column + index);
                if (tabsize != 0) {
                    if (blocksUsed + 2 * numInsertions + 1 >= this.blocks.length) {
                        int[] newBlocks = new int[2 * this.blocks.length];
                        System.arraycopy(this.blocks, 0, newBlocks, 0, this.blocks.length);
                        this.blocks = newBlocks;
                    }
                    this.blocks[blocksUsed + 2 * numInsertions] = index;
                    this.blocks[blocksUsed + 2 * numInsertions + 1] = tabsize;
                    ++numInsertions;
                    additional += tabsize;
                    column += tabsize;
                }
            } else if (op == 2 || op == 4) {
                sectionStart = column + this.posnIndex(this.queueInts[op + 1]);
            }
            int size = this.getQueueSize(op);
            todo -= size;
            op += size;
        }
        if (numInsertions > 0) {
            char[] buffer;
            int fillPtr = this.bufferFillPointer;
            int newFillPtr = fillPtr + additional;
            char[] newBuffer = buffer = this.buffer;
            int length = buffer.length;
            int end = fillPtr;
            if (newFillPtr > length) {
                int newLength = PrettyWriter.enoughSpace(fillPtr, additional);
                this.buffer = newBuffer = new char[newLength];
            }
            this.bufferFillPointer = newFillPtr;
            this.bufferOffset -= additional;
            int i = numInsertions;
            while (--i >= 0) {
                int srcpos = this.blocks[blocksUsed + 2 * i];
                int amount = this.blocks[blocksUsed + 2 * i + 1];
                int dstpos = srcpos + additional;
                System.arraycopy(buffer, srcpos, newBuffer, dstpos, end - srcpos);
                for (int j = dstpos - amount; j < dstpos; ++j) {
                    newBuffer[j] = 32;
                }
                additional -= amount;
                end = srcpos;
            }
            if (newBuffer != buffer) {
                System.arraycopy(buffer, 0, newBuffer, 0, end);
            }
        }
    }

    int ensureSpaceInBuffer(int want) {
        char[] buffer = this.buffer;
        int length = buffer.length;
        int fillPtr = this.bufferFillPointer;
        int available = length - fillPtr;
        if (available > 0) {
            return available;
        }
        if (this.out != null && fillPtr > this.lineLength && !this.sharing && !this.isDomTerm()) {
            if (!this.maybeOutput(false, false)) {
                this.outputPartialLine();
            }
            return this.ensureSpaceInBuffer(want);
        }
        int newLength = PrettyWriter.enoughSpace(length, want);
        char[] newBuffer = new char[newLength];
        this.buffer = newBuffer;
        int i = fillPtr;
        while (--i >= 0) {
            newBuffer[i] = buffer[i];
        }
        return newLength - fillPtr;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    boolean maybeOutput(boolean forceNewlines, boolean flushing) {
        outputAnything = false;
        while (this.queueSize > 0) {
            if (this.queueTail >= this.queueInts.length) {
                this.queueTail = 0;
            }
            next = this.queueTail;
            type = this.getQueueType(next);
            if (this.isDomTerm()) {
                if (this.bufferFillPointer > 0 && type != 2 && type != 0 && (count = this.posnIndex(this.queueInts[next + 1])) > 0) {
                    this.writeToBase(this.buffer, 0, count);
                    System.arraycopy(this.buffer, count, this.buffer, 0, this.bufferFillPointer - count);
                    this.bufferOffset += count;
                    this.bufferFillPointer -= count;
                    this.bufferStartColumn += count;
                }
                switch (type) {
                    case 2: {
                        outputAnything = true;
                        this.outputLine(next, flushing);
                        break;
                    }
                    case 3: {
                        if (this.isMisering()) break;
                        kind = this.queueInts[next + 2];
                        indent = this.queueInts[next + 3];
                        blockRelative = kind == 66;
                        this.writeToBase("\u001b]" + (blockRelative != false ? "113" : "112") + ";" + indent + "\u0007");
                        break;
                    }
                    case 4: {
                        prefix = this.queueStrings[next + 5];
                        sbuf = new StringBuilder("\u001b]110;");
                        if (prefix != null) {
                            Strings.printJson(prefix, sbuf);
                        }
                        sbuf.append("\u0007");
                        this.writeToBase(sbuf.toString());
                        suffix = this.queueStrings[next + 6];
                        this.reallyStartLogicalBlock(this.posnColumn(this.queueInts[next + 1]), "", suffix);
                        if (this.currentBlock != next) break;
                        this.currentBlock = -1;
                        break;
                    }
                    case 5: {
                        this.writeToBase("\u001b]111\u0007");
                        this.blockDepth -= 6;
                        break;
                    }
                    case 6: {
                        this.expandTabs(next);
                    }
                }
            } else {
                switch (type) {
                    case 2: {
                        fits = -1;
                        switch (this.queueInts[next + 4]) {
                            default: {
                                cond = true;
                                ** break;
                            }
                            case 77: {
                                cond = this.isMisering();
                                ** break;
                            }
                            case 70: {
                                if (!this.isMisering() && this.lineNumber <= this.getSectionStartLine()) break;
                                cond = true;
                                ** break;
                            }
                            case 83: 
                        }
                        end = this.queueInts[next + 3];
                        if (end == 0) {
                            end = -1;
                        } else if ((end = next + end) >= this.queueInts.length) {
                            end -= this.queueInts.length;
                        }
                        fits = this.fitsOnLine(end, forceNewlines);
                        if (fits > 0) {
                            cond = false;
                            ** break;
                        }
                        if (fits >= 0) {
                            if (flushing == false) return outputAnything;
                        }
                        cond = true;
lbl73: // 5 sources:
                        if (!cond) break;
                        outputAnything = true;
                        if (flushing && fits == 0) {
                            this.outputPartialLine();
                            break;
                        }
                        this.outputLine(next, flushing);
                        break;
                    }
                    case 3: {
                        if (this.isMisering()) break;
                        kind = this.queueInts[next + 2];
                        indent = this.queueInts[next + 3];
                        indent = kind == 66 ? (indent += this.getStartColumn()) : (indent += this.posnColumn(this.queueInts[next + 1]));
                        this.setIndentation(indent);
                        break;
                    }
                    case 4: {
                        start = next;
                        end = this.queueInts[next + 3];
                        end = end > 0 ? (end + next) % this.queueInts.length : -1;
                        fits = this.fitsOnLine(end, forceNewlines);
                        if (fits > 0) {
                            endr = this.queueInts[next + 4];
                            next = (endr + next) % this.queueInts.length;
                            this.expandTabs(next);
                            this.queueTail = next;
                            this.queueSize -= endr;
                        } else {
                            if (fits >= 0) {
                                if (flushing == false) return outputAnything;
                            }
                            prefix = this.queueStrings[next + 5];
                            suffix = this.queueStrings[next + 6];
                            this.reallyStartLogicalBlock(this.posnColumn(this.queueInts[next + 1]), prefix, suffix);
                        }
                        if (this.currentBlock != start) break;
                        this.currentBlock = -1;
                        break;
                    }
                    case 5: {
                        this.reallyEndLogicalBlock();
                        break;
                    }
                    case 6: {
                        this.expandTabs(next);
                    }
                }
            }
            size = this.getQueueSize(this.queueTail);
            this.queueSize -= size;
            this.queueTail = next + size;
        }
        return outputAnything;
    }

    protected int getMiserWidth() {
        return this.miserWidth;
    }

    boolean isMisering() {
        int mwidth = this.getMiserWidth();
        return mwidth > 0 && this.lineLength - this.getStartColumn() <= mwidth;
    }

    int getMaxLines() {
        return -1;
    }

    boolean printReadably() {
        return true;
    }

    int fitsOnLine(int sectionEnd, boolean forceNewlines) {
        int available = this.lineLength;
        if (!this.printReadably() && this.getMaxLines() == this.lineNumber) {
            available -= 3;
            available -= this.getSuffixLength();
        }
        if (sectionEnd >= 0) {
            return this.posnColumn(this.queueInts[sectionEnd + 1]) <= available ? 1 : -1;
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

    private void outputLine(int newline, boolean flushing) {
        int kind;
        char[] buffer;
        int maxLines;
        int amountToConsume;
        int amountToPrint;
        boolean isLiteral;
        block17 : {
            buffer = this.buffer;
            kind = this.queueInts[newline + 4];
            isLiteral = kind == 76;
            amountToConsume = this.posnIndex(this.queueInts[newline + 1]);
            if (isLiteral || kind == 68 || this.isDomTerm()) {
                amountToPrint = amountToConsume;
            } else {
                int i = amountToConsume;
                do {
                    if (--i >= 0) continue;
                    amountToPrint = 0;
                    break block17;
                } while (buffer[i] == ' ');
                amountToPrint = i + 1;
            }
        }
        this.writeToBase(buffer, 0, amountToPrint);
        int lineNumber = this.lineNumber;
        if (!this.printReadably() && (maxLines = this.getMaxLines()) > 0 && ++lineNumber >= maxLines) {
            this.writeToBase(" ..");
            int suffixLength = this.getSuffixLength();
            if (suffixLength != 0) {
                char[] suffix = this.suffix;
                int len = suffix.length;
                this.writeToBase(suffix, len - suffixLength, suffixLength);
            }
            this.lineAbbreviationHappened();
        }
        this.lineNumber = lineNumber;
        if (kind != 68) {
            if (this.isDomTerm()) {
                String cmd;
                switch (kind) {
                    case 70: 
                    case 83: {
                        cmd = "\u001b]115\u0007";
                        break;
                    }
                    case 78: {
                        cmd = "\u001b]116\u0007";
                        break;
                    }
                    case 77: {
                        cmd = "\u001b]117\u0007";
                        break;
                    }
                    case 76: {
                        if (this.blockDepth == 6) {
                            cmd = "\n";
                            break;
                        }
                    }
                    default: {
                        cmd = "\u001b]118\u0007";
                    }
                }
                this.writeToBase(cmd);
            } else {
                this.writeToBase(10);
            }
        }
        this.bufferStartColumn = kind != 68 ? 0 : this.getColumnNumber();
        int fillPtr = this.bufferFillPointer;
        int prefixLen = isLiteral ? this.getPerLinePrefixEnd() : this.getPrefixLength();
        int shift = amountToConsume - prefixLen;
        int newFillPtr = fillPtr - shift;
        char[] newBuffer = buffer;
        int bufferLength = buffer.length;
        if (newFillPtr > bufferLength) {
            this.buffer = newBuffer = new char[PrettyWriter.enoughSpace(bufferLength, newFillPtr - bufferLength)];
        }
        System.arraycopy(buffer, amountToConsume, newBuffer, prefixLen, fillPtr - amountToConsume);
        System.arraycopy(this.prefix, 0, newBuffer, 0, prefixLen);
        this.bufferFillPointer = newFillPtr;
        this.bufferOffset += shift;
        if (!isLiteral) {
            this.blocks[this.blockDepth + -2] = prefixLen;
            this.blocks[this.blockDepth + -6] = lineNumber;
        }
    }

    void outputPartialLine() {
        int tail = this.queueTail;
        while (this.queueSize > 0 && this.getQueueType(tail) == 0) {
            int size = this.getQueueSize(tail);
            this.queueSize -= size;
            if ((tail += size) == this.queueInts.length) {
                tail = 0;
            }
            this.queueTail = tail;
        }
        int fillPtr = this.bufferFillPointer;
        int count = this.queueSize > 0 ? this.posnIndex(this.queueInts[tail + 1]) : fillPtr;
        int newFillPtr = fillPtr - count;
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
        int size;
        if (!this.reallySharing) {
            return;
        }
        int posnMarkerCount = 0;
        GapBuffer gbuffer = new GapBuffer(this.buffer, this.buffer.length);
        int delta = 0;
        int tail = this.queueTail;
        for (int todo = this.queueSize; todo > 0; todo -= size) {
            int type;
            int next;
            if (tail >= this.queueInts.length) {
                tail = 0;
            }
            if ((type = this.getQueueType(next = tail)) != 0) {
                gbuffer.addUpTo(this.posnIndex(this.queueInts[next + 1]));
            }
            switch (type) {
                int relativeAddress;
                int oldDelta;
                case 7: {
                    oldDelta = delta;
                    if (!this.posnMarkerActive(next)) break;
                    if (this.posnMarkerIsGrouping(next)) {
                        gbuffer.add('.');
                        gbuffer.add(' ');
                        delta += 2;
                    }
                    gbuffer.add('#');
                    if (this.queueInts[next + 2] == 1) {
                        this.queueInts[next + 2] = posnMarkerCount++;
                    }
                    int reference = this.queueInts[next + 2];
                    delta += gbuffer.add(reference);
                    gbuffer.add('=');
                    delta += 2;
                    if (this.posnMarkerIsGrouping(next)) {
                        gbuffer.add('(');
                        ++delta;
                    }
                    int[] arrn = this.queueInts;
                    int n = next + 1;
                    arrn[n] = arrn[n] + (delta - oldDelta);
                    break;
                }
                case 8: {
                    oldDelta = delta;
                    relativeAddress = this.queueInts[next + 2];
                    int count = this.queueInts[relativeAddress + 2];
                    gbuffer.add('#');
                    delta += gbuffer.add(count);
                    gbuffer.add('#');
                    int[] arrn = this.queueInts;
                    int n = next + 1;
                    arrn[n] = arrn[n] + ((delta += 2) - oldDelta);
                    break;
                }
                case 9: {
                    relativeAddress = this.queueInts[next + 2];
                    if (!this.posnMarkerActive(relativeAddress)) break;
                    gbuffer.add(')');
                    ++delta;
                    int[] arrn = this.queueInts;
                    int n = next + 1;
                    arrn[n] = arrn[n] + 1;
                    break;
                }
                default: {
                    int[] arrn = this.queueInts;
                    int n = next + 1;
                    arrn[n] = arrn[n] + delta;
                }
            }
            size = this.getQueueSize(tail);
            tail = next + size;
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
        this.bufferOffset = 0;
        this.queueTail = 0;
        this.queueSize = 0;
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
        char ch;
        int i = this.bufferFillPointer;
        do {
            if (--i >= 0) continue;
            return this.bufferStartColumn + this.bufferFillPointer;
        } while ((ch = this.buffer[i]) != '\n' && ch != '\r');
        return this.bufferFillPointer - (i + 1);
    }

    public void setColumnNumber(int column) {
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

    private static final class GapBuffer {
        char[] buffer;
        char[] existingBuffer;
        int point;
        int existingIndex;
        int gapSize;

        public GapBuffer(char[] existing, int startSize) {
            this.buffer = new char[startSize];
            this.point = 0;
            this.existingIndex = 0;
            this.existingBuffer = existing;
        }

        public int getPoint() {
            return this.point;
        }

        public void add(char ch) {
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

        public void addUpTo(int end) {
            int n = end - this.existingIndex;
            if (this.point + n >= this.buffer.length) {
                this.expandBuffer(n);
            }
            while (this.existingIndex < end) {
                this.buffer[this.point++] = this.existingBuffer[this.existingIndex++];
            }
        }

        public char[] restoreBuffer() {
            char[] retBuffer = new char[this.buffer.length];
            System.arraycopy(this.buffer, 0, retBuffer, 0, this.point);
            return retBuffer;
        }

        private void expandBuffer(int n) {
            int newLength = this.buffer.length;
            int minimum = newLength + n;
            while ((newLength <<= 1) < minimum) {
            }
            char[] newBuffer = new char[newLength];
            System.arraycopy(this.buffer, 0, newBuffer, 0, this.point);
            this.buffer = newBuffer;
        }
    }

}

