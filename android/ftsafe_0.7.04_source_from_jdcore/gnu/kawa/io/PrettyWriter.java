package gnu.kawa.io;

import gnu.kawa.util.IntHashTable;
import gnu.lists.LList;
import gnu.lists.PrintConsumer;
import gnu.lists.Strings;
import gnu.mapping.ThreadLocation;
import java.io.IOException;
import java.io.Writer;





































































public class PrettyWriter
  extends PrintConsumer
{
  public PrettyWriter(Writer out)
  {
    super(out);
    setPrettyPrintingMode(1);
  }
  








  public PrettyWriter(Writer out, int lineLength)
  {
    super(out);
    this.lineLength = lineLength;
    setPrettyPrintingMode(lineLength > 1 ? 1 : 0);
  }
  






  public PrettyWriter(Writer out, boolean prettyPrintingMode)
  {
    super(out);
    setPrettyPrintingMode(prettyPrintingMode ? 1 : 0);
  }
  

  int lineLength = 80;
  








  int miserWidth = 40;
  boolean isDomTerm;
  
  public boolean isDomTerm() { return isDomTerm; }
  







  boolean sharing = false;
  






  boolean reallySharing = false;
  
  public static ThreadLocation lineLengthLoc = new ThreadLocation("line-length");
  
  public static ThreadLocation miserWidthLoc = new ThreadLocation("miser-width");
  
  public static ThreadLocation indentLoc = new ThreadLocation("indent");
  







  public static ThreadLocation isSharing = new ThreadLocation("print-circle");
  

  private int prettyPrintingMode;
  
  private IntHashTable idhash;
  

  public boolean initialiseIDHash()
  {
    Object share = isSharing.get(null);
    if (idhash != null)
      return false;
    idhash = new IntHashTable();
    return true;
  }
  
  public void clearIDHash()
  {
    idhash.clear();
  }
  
  public void finishIDHash() {
    idhash.clear();
    writeEndOfExpression();
    resolveBackReferences();
    flush();
    idhash = null;
  }
  
  public int IDHashLookup(Object obj) {
    return idhash.lookup(obj);
  }
  
  public int IDHashGetFromIndex(int index) {
    return idhash.getFromIndex(index);
  }
  
  public int IDHashPutAtIndex(Object obj, int value, int index) {
    return idhash.putAtIndex(obj, value, index);
  }
  
  public int IDHashRemove(Object obj) {
    return idhash.remove(obj);
  }
  





  public void setPrettyPrintingMode(int mode)
  {
    prettyPrintingMode = mode;
  }
  
  public void setSharing(boolean sharing) {
    this.sharing = sharing;
  }
  

  public int getPrettyPrintingMode()
  {
    return prettyPrintingMode;
  }
  
  public boolean isPrettyPrinting() { return prettyPrintingMode > 0; }
  



  public void setPrettyPrinting(boolean mode)
  {
    setPrettyPrintingMode(mode ? 1 : 0);
  }
  



  private boolean isPassingThrough()
  {
    return (buffer.length == 0) && (out != null);
  }
  

  public char[] buffer = new char['ࠀ'];
  





  public int bufferFillPointer;
  





  int bufferOffset;
  




  int bufferStartColumn;
  




  int lineNumber;
  





  private int indexPosn(int index)
  {
    return index + bufferOffset;
  }
  







  private int posnIndex(int posn)
  {
    return posn - bufferOffset;
  }
  





  private int posnColumn(int posn)
  {
    return indexColumn(posnIndex(posn));
  }
  



  int[] blocks = new int[60];
  
  private static final int LOGICAL_BLOCK_LENGTH = 6;
  
  private static final int BLOCK_START_COLUMN = -1;
  private static final int BLOCK_SECTION_COLUMN = -2;
  private static final int BLOCK_PER_LINE_PREFIX_END = -3;
  private static final int BLOCK_PREFIX_LENGTH = -4;
  private static final int BLOCK_SUFFIX_LENGTH = -5;
  private static final int BLOCK_SECTION_START_LINE = -6;
  int blockDepth = 6;
  



  char[] prefix = new char[''];
  



  char[] suffix = new char[''];
  








  static final int QUEUE_INIT_ALLOC_SIZE = 300;
  








  int[] queueInts = new int['Ĭ'];
  

  String[] queueStrings = new String['Ĭ'];
  

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
  
  private int getQueueType(int index) { return queueInts[index] & 0xFF; }
  private int getQueueSize(int index) { return queueInts[index] >> 16; }
  



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
  

  private boolean posnMarkerIsGrouping(int posn)
  {
    return (queueInts[posn] >> 8 & 0x1) != 0;
  }
  






  private boolean posnMarkerActive(int posn)
  {
    return queueInts[(posn + 2)] != 0;
  }
  
  private int getSectionColumn()
  {
    return blocks[(blockDepth + -2)];
  }
  
  private int getStartColumn()
  {
    return blocks[(blockDepth + -1)];
  }
  
  private int getPerLinePrefixEnd()
  {
    return blocks[(blockDepth + -3)];
  }
  
  private int getPrefixLength()
  {
    return blocks[(blockDepth + -4)];
  }
  
  private int getSuffixLength()
  {
    return blocks[(blockDepth + -5)];
  }
  
  private int getSectionStartLine()
  {
    return blocks[(blockDepth + -6)];
  }
  



  public void writeWordEnd()
  {
    wordEndSeen = true;
  }
  




  public void writeWordStart()
  {
    if (wordEndSeen)
      write(32);
    wordEndSeen = false;
  }
  
  protected void clearWordEnd()
  {
    wordEndSeen = false;
  }
  










  public void write(int ch)
  {
    wordEndSeen = false;
    
    if (isPassingThrough()) {
      if ((ch == 10) || (ch == 13))
        bufferStartColumn = 0;
      writeToBase(ch);
    }
    else if ((ch == 10) && (prettyPrintingMode > 0)) {
      enqueueNewline(76);
    }
    else {
      ensureSpaceInBuffer(1);
      int fillPointer = bufferFillPointer;
      buffer[fillPointer] = ((char)ch);
      bufferFillPointer = (1 + fillPointer);
      if ((ch == 32) && (prettyPrintingMode > 1) && (currentBlock < 0)) {
        enqueueNewline(83);
      }
    }
  }
  
  public void write(String str) {
    write(str, 0, str.length());
  }
  








  public void write(String str, int start, int count)
  {
    wordEndSeen = false;
    
    if (isPassingThrough()) {
      int i = count;
      for (;;) { i--; if (i < 0) {
          bufferStartColumn += count;
          break;
        }
        char ch = str.charAt(start + i);
        if ((ch == '\r') || (ch == '\n')) {
          bufferStartColumn = (count - (i + 1));
          break;
        }
      }
      writeToBase(str, start, count);
      return;
    }
    while (count > 0)
    {
      int cnt = count;
      
      int available = ensureSpaceInBuffer(count);
      if (cnt > available)
        cnt = available;
      int fillPointer = bufferFillPointer;
      count -= cnt;
      for (;;) { cnt--; if (cnt < 0)
          break;
        char ch = str.charAt(start++);
        if ((ch == '\n') && (prettyPrintingMode > 0))
        {
          bufferFillPointer = fillPointer;
          enqueueNewline(76);
          fillPointer = bufferFillPointer;
        }
        else
        {
          buffer[(fillPointer++)] = ch;
          if ((ch == ' ') && (prettyPrintingMode > 1) && (currentBlock < 0))
          {
            bufferFillPointer = fillPointer;
            enqueueNewline(83);
            fillPointer = bufferFillPointer;
          }
        }
      }
      bufferFillPointer = fillPointer;
    }
  }
  
  public void write(char[] str)
  {
    write(str, 0, str.length);
  }
  
  public void write(char[] str, int start, int count)
  {
    wordEndSeen = false;
    
    if (isPassingThrough()) {
      int i = count;
      for (;;) { i--; if (i < 0) {
          bufferStartColumn += count;
          break;
        }
        char ch = str[(start + i)];
        if ((ch == '\r') || (ch == '\n')) {
          bufferStartColumn = (count - (i + 1));
          break;
        }
      }
      writeToBase(str, start, count);
      return;
    }
    int end = start + count;
    
    if (count > 0)
    {

      for (int i = start;; i++) { if (i >= end)
          break label169;
        char c;
        if ((prettyPrintingMode > 0) && (((c = str[i]) == '\n') || ((c == ' ') && (currentBlock < 0))))
        {


          write(str, start, i - start);
          write(c);
          start = i + 1;
          count = end - start;
          break;
        }
      }
      for (;;)
      {
        label169:
        int available = ensureSpaceInBuffer(count);
        int cnt = available < count ? available : count;
        int fillPointer = bufferFillPointer;
        int newFillPtr = fillPointer + cnt;
        for (int i = fillPointer; i < newFillPtr; i++)
          buffer[i] = str[(start++)];
        bufferFillPointer = newFillPtr;
        count -= cnt;
        if (count == 0) {
          break;
        }
      }
    }
  }
  
  private void writeToBase(char[] buf, int start, int count) {
    try {
      out.write(buf, start, count);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  private void writeToBase(String str, int start, int count)
  {
    try {
      out.write(str, start, count);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  
  private void writeToBase(String str) {
    writeToBase(str, 0, str.length());
  }
  
  private void writeToBase(int ch)
  {
    try {
      out.write(ch);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }
  












  public int writePositionMarker(boolean grouping)
  {
    int result = enqueue(7, 3);
    
    queueInts[(result + 2)] = 0;
    
    queueInts[result] |= (grouping ? 1 : 0) << 8;
    

    return result;
  }
  











  public void writeBackReference(int posn)
  {
    if (!reallySharing)
      reallySharing = true;
    int result = enqueue(8, 3);
    
    queueInts[(result + 2)] = posn;
    
    queueInts[(posn + 2)] = 1;
  }
  











  public void writePairEnd(Integer posn)
  {
    int result = enqueue(9, 3);
    
    queueInts[(result + 2)] = posn.intValue();
  }
  
  public void writeEndOfExpression()
  {
    enqueue(10, 2);
  }
  



  private void pushLogicalBlock(int column, int perLineEnd, int prefixLength, int suffixLength, int sectionStartLine)
  {
    int newLength = blockDepth + 6;
    if (newLength >= blocks.length)
    {
      int[] newBlocks = new int[2 * blocks.length];
      System.arraycopy(blocks, 0, newBlocks, 0, blockDepth);
      blocks = newBlocks;
    }
    blockDepth = newLength;
    blocks[(blockDepth + -1)] = column;
    blocks[(blockDepth + -2)] = column;
    blocks[(blockDepth + -3)] = perLineEnd;
    blocks[(blockDepth + -4)] = prefixLength;
    blocks[(blockDepth + -5)] = suffixLength;
    blocks[(blockDepth + -6)] = sectionStartLine;
  }
  






  void reallyStartLogicalBlock(int column, String prefix, String suffix)
  {
    int perLineEnd = getPerLinePrefixEnd();
    int prefixLength = getPrefixLength();
    int suffixLength = getSuffixLength();
    pushLogicalBlock(column, perLineEnd, prefixLength, suffixLength, lineNumber);
    
    if (!isDomTerm())
      setIndentation(column);
    if (prefix != null)
    {
      blocks[(blockDepth + -3)] = column;
      int plen = prefix.length();
      prefix.getChars(0, plen, this.suffix, column - plen);
    }
    if (suffix != null)
    {



      char[] totalSuffix = this.suffix;
      int totalSuffixLen = totalSuffix.length;
      int additional = suffix.length();
      int newSuffixLen = suffixLength + additional;
      if (newSuffixLen > totalSuffixLen)
      {
        int newTotalSuffixLen = enoughSpace(totalSuffixLen, additional);
        this.suffix = new char[newTotalSuffixLen];
        System.arraycopy(totalSuffix, totalSuffixLen - suffixLength, this.suffix, newTotalSuffixLen - suffixLength, suffixLength);
        

        totalSuffixLen = newTotalSuffixLen;
      }
      suffix.getChars(0, additional, totalSuffix, totalSuffixLen - newSuffixLen);
      
      blocks[(blockDepth + -5)] = newSuffixLen;
    }
  }
  

  int enqueueTab(int flags, int colnum, int colinc)
  {
    int addr = enqueue(6, 5);
    queueInts[(addr + 2)] = flags;
    queueInts[(addr + 3)] = colnum;
    queueInts[(addr + 4)] = colinc;
    return addr;
  }
  




  private static int enoughSpace(int current, int want)
  {
    int scaled = current + (current >> 1);
    int enough = current + (5 * want >> 2);
    return scaled > enough ? scaled : enough;
  }
  
  private void setIndentation(int column)
  {
    char[] prefix = this.prefix;
    int prefixLen = prefix.length;
    int current = getPrefixLength();
    int minimum = getPerLinePrefixEnd();
    if (minimum > column)
      column = minimum;
    if (column > prefixLen)
    {
      prefix = new char[enoughSpace(prefixLen, column - prefixLen)];
      System.arraycopy(this.prefix, 0, prefix, 0, current);
      this.prefix = prefix;
    }
    if (column > current)
    {
      for (int i = current; i < column; i++)
        prefix[i] = ' ';
    }
    blocks[(blockDepth + -4)] = column;
  }
  
  void reallyEndLogicalBlock()
  {
    int oldIndent = getPrefixLength();
    blockDepth -= 6;
    int newIndent = getPrefixLength();
    if (newIndent > oldIndent)
    {
      for (int i = oldIndent; i < newIndent; i++) {
        prefix[i] = ' ';
      }
    }
  }
  














  public int enqueue(int kind, int size)
  {
    int oldLength = queueInts.length;
    int endAvail = oldLength - queueTail - queueSize;
    



    if ((endAvail > 0) && (size > endAvail) && (!sharing))
      enqueue(0, endAvail);
    if ((endAvail < size) && ((sharing) || (oldLength - queueSize < size)))
    {
      int enough = enoughSpace(oldLength, size);
      int newLength = enough;
      
      int[] newInts = new int[newLength];
      String[] newStrings = new String[newLength];
      
      if (sharing)
      {

        System.arraycopy(queueInts, 0, newInts, 0, queueInts.length);
        System.arraycopy(queueStrings, 0, newStrings, 0, queueStrings.length);

      }
      else
      {

        int queueHead = queueTail + queueSize - oldLength;
        if (queueHead > 0)
        {
          System.arraycopy(queueInts, 0, newInts, 0, queueHead);
          System.arraycopy(queueStrings, 0, newStrings, 0, queueHead);
        }
        int part1Len = oldLength - queueTail;
        int deltaLength = newLength - oldLength;
        System.arraycopy(queueInts, queueTail, newInts, queueTail + deltaLength, part1Len);
        

        System.arraycopy(queueStrings, queueTail, newStrings, queueTail + deltaLength, part1Len);
        


        if (currentBlock >= queueTail)
          currentBlock += deltaLength;
        queueTail += deltaLength;
      }
      queueInts = newInts;
      queueStrings = newStrings;
    }
    int addr = queueTail + queueSize;
    
    if ((!sharing) && (addr >= queueInts.length))
      addr -= queueInts.length;
    queueInts[(addr + 0)] = (kind | size << 16);
    if (size > 1) {
      queueInts[(addr + 1)] = indexPosn(bufferFillPointer);
    }
    queueSize += size;
    return addr;
  }
  








  private void enqueueNewline(int kind)
  {
    wordEndSeen = false;
    int depth = pendingBlocksCount;
    
    int newline = enqueue(2, 5);
    queueInts[(newline + 4)] = kind;
    queueInts[(newline + 2)] = pendingBlocksCount;
    queueInts[(newline + 3)] = 0;
    int entry = queueTail;
    int todo = queueSize;
    while (todo > 0)
    {
      if (entry == queueInts.length)
        entry = 0;
      if (entry == newline)
        break;
      int type = getQueueType(entry);
      if (((type == 2) || (type == 4)) && (queueInts[(entry + 3)] == 0) && (depth <= queueInts[(entry + 2)]))
      {



        int delta = newline - entry;
        if (delta < 0)
          delta += queueInts.length;
        queueInts[(entry + 3)] = delta;
      }
      int size = getQueueSize(entry);
      todo -= size;
      entry += size;
    }
    if (!sharing) {
      maybeOutput((kind == 76) || (kind == 82) || (kind == 68), false);
    }
  }
  
  public final void writeBreak(int kind) {
    if ((prettyPrintingMode > 0) || (sharing)) {
      enqueueNewline(kind);
    }
  }
  



  public void writeBreakLinear()
  {
    writeBreak(78);
  }
  

  public int enqueueIndent(char kind, int amount)
  {
    int result = enqueue(3, 4);
    queueInts[(result + 2)] = kind;
    queueInts[(result + 3)] = amount;
    return result;
  }
  
  public void addIndentation(int amount, boolean current)
  {
    if (prettyPrintingMode > 0) {
      enqueueIndent(current ? 'C' : 'B', amount);
    }
  }
  

  public void startLogicalBlock(String prefix, boolean perLine, String suffix)
  {
    Object indent;
    
    if ((queueSize == 0) && (bufferFillPointer == 0))
    {
      Object llen = lineLengthLoc.get(null);
      if (llen == null) {
        lineLength = 80;
      } else {
        lineLength = Integer.parseInt(llen.toString());
      }
      Object mwidth = miserWidthLoc.get(null);
      if ((mwidth == null) || (mwidth == Boolean.FALSE) || (mwidth == LList.Empty))
      {

        miserWidth = -1;
      } else {
        miserWidth = Integer.parseInt(mwidth.toString());
      }
      indent = indentLoc.get(null);
    }
    
    if ((prefix != null) && ((!perLine) || (!isDomTerm())))
      write(prefix);
    if (prettyPrintingMode == 0)
      return;
    int start = enqueue(4, 7);
    
    queueInts[(start + 2)] = pendingBlocksCount;
    queueStrings[(start + 5)] = (perLine ? prefix : null);
    
    queueStrings[(start + 6)] = suffix;
    pendingBlocksCount += 1;
    int outerBlock = currentBlock;
    if (outerBlock < 0) {
      outerBlock = 0;
    }
    else {
      outerBlock -= start;
      if (outerBlock > 0)
        outerBlock -= queueInts.length;
    }
    queueInts[(start + 4)] = outerBlock;
    queueInts[(start + 3)] = 0;
    currentBlock = start;
  }
  
  public void endLogicalBlock()
  {
    int end = enqueue(5, 2);
    pendingBlocksCount -= 1;
    if (currentBlock < 0)
    {



      int suffixLength = blocks[(blockDepth + -5)];
      int suffixPreviousLength = blocks[(blockDepth - 6 + -5)];
      
      if (suffixLength > suffixPreviousLength) {
        write(this.suffix, this.suffix.length - suffixLength, suffixLength - suffixPreviousLength);
      }
      
      currentBlock = -1;
      return;
    }
    int start = currentBlock;
    int outerBlock = queueInts[(start + 4)];
    if (outerBlock == 0) {
      currentBlock = -1;
    }
    else {
      int qtailFromStart = queueTail - start;
      if (qtailFromStart > 0)
        qtailFromStart -= queueInts.length;
      if (outerBlock < qtailFromStart)
      {


        currentBlock = -1;

      }
      else
      {
        outerBlock += start;
        if (outerBlock < 0)
          outerBlock += queueInts.length;
        currentBlock = outerBlock;
      }
    }
    String suffix = queueStrings[(start + 6)];
    if (suffix != null)
      write(suffix);
    int endFromStart = end - start;
    if (endFromStart < 0)
      endFromStart += queueInts.length;
    queueInts[(start + 4)] = endFromStart;
  }
  

  public void endLogicalBlock(String suffix)
  {
    if (prettyPrintingMode > 0) {
      endLogicalBlock();
    } else if (suffix != null) {
      write(suffix);
    }
  }
  

  int computeTabSize(int tab, int sectionStart, int column)
  {
    int flags = queueInts[(tab + 2)];
    boolean isSection = (flags & 0x1) != 0;
    boolean isRelative = (flags & 0x2) != 0;
    int origin = isSection ? sectionStart : 0;
    int colnum = queueInts[(tab + 3)];
    int colinc = queueInts[(tab + 4)];
    if (isRelative)
    {
      if (colinc > 1)
      {
        int newposn = column + colnum;
        int rem = newposn % colinc;
        if (rem != 0)
          colnum += (colinc = rem);
      }
      return colnum;
    }
    if (column <= colnum + origin) {
      return column + origin - column;
    }
    return colinc - (column - origin) % colinc;
  }
  
  int indexColumn(int index)
  {
    int column = bufferStartColumn;
    int sectionStart = getSectionColumn();
    int endPosn = indexPosn(index);
    int op = queueTail;
    int todo = queueSize;
    while (todo > 0)
    {

      if (op >= queueInts.length)
        op = 0;
      int type = getQueueType(op);
      if (type != 0)
      {
        int posn = queueInts[(op + 1)];
        if (posn >= endPosn)
          break;
        if (type == 6) {
          column += computeTabSize(op, sectionStart, column + posnIndex(posn));
        }
        else if ((type == 2) || (type == 4))
        {
          sectionStart = column + posnIndex(queueInts[(op + 1)]);
        }
      }
      int size = getQueueSize(op);
      todo -= size;
      op += size;
    }
    return column + index;
  }
  
  void expandTabs(int through)
  {
    int numInsertions = 0;
    int additional = 0;
    int column = bufferStartColumn;
    int sectionStart = getSectionColumn();
    int op = queueTail;
    int todo = queueSize;
    int blocksUsed = 6 * pendingBlocksCount;
    while (todo > 0)
    {
      if (op == queueInts.length)
        op = 0;
      if (op == through)
        break;
      int type = getQueueType(op);
      if (type == 6)
      {
        int index = posnIndex(queueInts[(op + 1)]);
        int tabsize = computeTabSize(op, sectionStart, column + index);
        if (tabsize != 0)
        {

          if (blocksUsed + 2 * numInsertions + 1 >= blocks.length)
          {
            int[] newBlocks = new int[2 * blocks.length];
            System.arraycopy(blocks, 0, newBlocks, 0, blocks.length);
            blocks = newBlocks;
          }
          blocks[(blocksUsed + 2 * numInsertions)] = index;
          blocks[(blocksUsed + 2 * numInsertions + 1)] = tabsize;
          numInsertions++;
          additional += tabsize;
          column += tabsize;
        }
      }
      else if ((op == 2) || (op == 4))
      {
        sectionStart = column + posnIndex(queueInts[(op + 1)]);
      }
      int size = getQueueSize(op);
      todo -= size;
      op += size;
    }
    if (numInsertions > 0)
    {
      int fillPtr = bufferFillPointer;
      int newFillPtr = fillPtr + additional;
      char[] buffer = this.buffer;
      char[] newBuffer = buffer;
      int length = buffer.length;
      int end = fillPtr;
      if (newFillPtr > length)
      {
        int newLength = enoughSpace(fillPtr, additional);
        newBuffer = new char[newLength];
        this.buffer = newBuffer;
      }
      bufferFillPointer = newFillPtr;
      bufferOffset -= additional;
      int i = numInsertions; for (;;) { i--; if (i < 0)
          break;
        int srcpos = blocks[(blocksUsed + 2 * i)];
        int amount = blocks[(blocksUsed + 2 * i + 1)];
        int dstpos = srcpos + additional;
        System.arraycopy(buffer, srcpos, newBuffer, dstpos, end - srcpos);
        for (int j = dstpos - amount; j < dstpos; j++)
          newBuffer[j] = ' ';
        additional -= amount;
        end = srcpos;
      }
      if (newBuffer != buffer) {
        System.arraycopy(buffer, 0, newBuffer, 0, end);
      }
    }
  }
  









  int ensureSpaceInBuffer(int want)
  {
    char[] buffer = this.buffer;
    int length = buffer.length;
    int fillPtr = bufferFillPointer;
    int available = length - fillPtr;
    if (available > 0)
      return available;
    if ((out != null) && (fillPtr > lineLength) && (!sharing) && (!isDomTerm()))
    {
      if (!maybeOutput(false, false))
        outputPartialLine();
      return ensureSpaceInBuffer(want);
    }
    

    int newLength = enoughSpace(length, want);
    char[] newBuffer = new char[newLength];
    this.buffer = newBuffer;
    int i = fillPtr; for (;;) { i--; if (i < 0) break;
      newBuffer[i] = buffer[i]; }
    return newLength - fillPtr;
  }
  










  boolean maybeOutput(boolean forceNewlines, boolean flushing)
  {
    boolean outputAnything = false;
    

    while (queueSize > 0)
    {
      if (queueTail >= queueInts.length)
        queueTail = 0;
      int next = queueTail;
      int type = getQueueType(next);
      if (isDomTerm()) {
        if ((bufferFillPointer > 0) && (type != 2) && (type != 0)) {
          int count = posnIndex(queueInts[(next + 1)]);
          if (count > 0) {
            writeToBase(buffer, 0, count);
            System.arraycopy(buffer, count, buffer, 0, bufferFillPointer - count);
            bufferOffset += count;
            bufferFillPointer -= count;
            bufferStartColumn += count;
          }
        }
        switch (type)
        {
        case 2: 
          outputAnything = true;
          outputLine(next, flushing);
          break;
        case 3: 
          if (!isMisering())
          {
            int kind = queueInts[(next + 2)];
            int indent = queueInts[(next + 3)];
            boolean blockRelative = kind == 66;
            writeToBase("\033]" + (blockRelative ? "113" : "112") + ";" + indent + "\007");
          }
          
          break;
        
        case 4: 
          String prefix = queueStrings[(next + 5)];
          StringBuilder sbuf = new StringBuilder("\033]110;");
          if (prefix != null)
            Strings.printJson(prefix, sbuf);
          sbuf.append("\007");
          writeToBase(sbuf.toString());
          String suffix = queueStrings[(next + 6)];
          reallyStartLogicalBlock(posnColumn(queueInts[(next + 1)]), "", suffix);
          
          if (currentBlock == next)
            currentBlock = -1;
          break;
        case 5: 
          writeToBase("\033]111\007");
          blockDepth -= 6;
          break;
        
        case 6: 
          expandTabs(next);
        }
      }
      else {
        int fits;
        switch (type)
        {

        case 2: 
          fits = -1;
          boolean cond; switch (queueInts[(next + 4)])
          {
          default: 
            cond = true;
            break;
          case 77: 
            cond = isMisering();
            break;
          case 70: 
            if ((isMisering()) || (lineNumber > getSectionStartLine()))
            {

              cond = true; }
            break;
          }
          
          
          int end = queueInts[(next + 3)];
          if (end == 0) {
            end = -1;
          }
          else {
            end = next + end;
            if (end >= queueInts.length)
              end -= queueInts.length;
          }
          fits = fitsOnLine(end, forceNewlines);
          boolean cond; boolean cond; if (fits > 0) {
            cond = false;
          } else { if ((fits >= 0) && (!flushing)) return outputAnything;
            cond = true;
          }
          


          if (cond)
          {
            outputAnything = true;
            if ((flushing) && (fits == 0)) {
              outputPartialLine();
            } else
              outputLine(next, flushing);
          }
          break;
        case 3: 
          if (!isMisering())
          {
            int kind = queueInts[(next + 2)];
            int indent = queueInts[(next + 3)];
            if (kind == 66) {
              indent += getStartColumn();
            } else {
              indent += posnColumn(queueInts[(next + 1)]);
            }
            setIndentation(indent); }
          break;
        
        case 4: 
          int start = next;
          int end = queueInts[(next + 3)];
          
          end = end > 0 ? (end + next) % queueInts.length : -1;
          fits = fitsOnLine(end, forceNewlines);
          
          if (fits > 0)
          {


            int endr = queueInts[(next + 4)];
            
            next = (endr + next) % queueInts.length;
            expandTabs(next);
            queueTail = next;
            queueSize -= endr;
          }
          else {
            if ((fits >= 0) && (!flushing))
              return outputAnything;
            String prefix = queueStrings[(next + 5)];
            String suffix = queueStrings[(next + 6)];
            
            reallyStartLogicalBlock(posnColumn(queueInts[(next + 1)]), prefix, suffix);
          }
          


          if (currentBlock == start) {
            currentBlock = -1;
          }
          break;
        case 5: 
          reallyEndLogicalBlock();
          break;
        case 6: 
          expandTabs(next); }
        
      }
      int size = getQueueSize(queueTail);
      queueSize -= size;
      
      queueTail = (next + size);
    }
    return outputAnything;
  }
  

  protected int getMiserWidth()
  {
    return miserWidth;
  }
  
  boolean isMisering()
  {
    int mwidth = getMiserWidth();
    return (mwidth > 0) && (lineLength - getStartColumn() <= mwidth);
  }
  


  int getMaxLines()
  {
    return -1;
  }
  

  boolean printReadably()
  {
    return true;
  }
  

  int fitsOnLine(int sectionEnd, boolean forceNewlines)
  {
    int available = lineLength;
    if ((!printReadably()) && (getMaxLines() == lineNumber))
    {
      available -= 3;
      available -= getSuffixLength();
    }
    if (sectionEnd >= 0)
      return posnColumn(queueInts[(sectionEnd + 1)]) <= available ? 1 : -1;
    if (forceNewlines)
      return -1;
    if (indexColumn(bufferFillPointer) > available)
      return -1;
    return 0;
  }
  




  public void lineAbbreviationHappened() {}
  



  private void outputLine(int newline, boolean flushing)
  {
    char[] buffer = this.buffer;
    int kind = queueInts[(newline + 4)];
    boolean isLiteral = kind == 76;
    int amountToConsume = posnIndex(queueInts[(newline + 1)]);
    int amountToPrint;
    int amountToPrint; if ((isLiteral) || (kind == 68) || (isDomTerm())) {
      amountToPrint = amountToConsume;
    }
    else
    {
      int i = amountToConsume;
      do {
        i--; if (i < 0)
        {
          int amountToPrint = 0;
          break;
        }
      } while (buffer[i] == ' ');
      
      amountToPrint = i + 1;
    }
    


    writeToBase(buffer, 0, amountToPrint);
    int lineNumber = this.lineNumber;
    lineNumber++;
    if (!printReadably())
    {
      int maxLines = getMaxLines();
      if ((maxLines > 0) && (lineNumber >= maxLines))
      {
        writeToBase(" ..");
        int suffixLength = getSuffixLength();
        if (suffixLength != 0)
        {
          char[] suffix = this.suffix;
          int len = suffix.length;
          writeToBase(suffix, len - suffixLength, suffixLength);
        }
        
        lineAbbreviationHappened();
      }
    }
    this.lineNumber = lineNumber;
    if (kind != 68)
    {
      if (isDomTerm()) {
        String cmd;
        switch (kind) {
        case 70: 
        case 83: 
          cmd = "\033]115\007"; break;
        case 78: 
          cmd = "\033]116\007"; break;
        case 77: 
          cmd = "\033]117\007"; break;
        case 76: 
          if (blockDepth == 6)
            cmd = "\n";
          break;
        }
        
        
        String cmd = "\033]118\007";
        
        writeToBase(cmd);
      } else {
        writeToBase(10);
      } }
    bufferStartColumn = (kind != 68 ? 0 : getColumnNumber());
    int fillPtr = bufferFillPointer;
    int prefixLen = isLiteral ? getPerLinePrefixEnd() : getPrefixLength();
    int shift = amountToConsume - prefixLen;
    int newFillPtr = fillPtr - shift;
    char[] newBuffer = buffer;
    int bufferLength = buffer.length;
    if (newFillPtr > bufferLength)
    {
      newBuffer = new char[enoughSpace(bufferLength, newFillPtr - bufferLength)];
      
      this.buffer = newBuffer;
    }
    System.arraycopy(buffer, amountToConsume, newBuffer, prefixLen, fillPtr - amountToConsume);
    
    System.arraycopy(prefix, 0, newBuffer, 0, prefixLen);
    bufferFillPointer = newFillPtr;
    bufferOffset += shift;
    if (!isLiteral)
    {
      blocks[(blockDepth + -2)] = prefixLen;
      blocks[(blockDepth + -6)] = lineNumber;
    }
  }
  

  void outputPartialLine()
  {
    int tail = queueTail;
    while ((queueSize > 0) && (getQueueType(tail) == 0))
    {
      int size = getQueueSize(tail);
      queueSize -= size;
      tail += size;
      if (tail == queueInts.length)
        tail = 0;
      queueTail = tail;
    }
    int fillPtr = bufferFillPointer;
    int count = queueSize > 0 ? posnIndex(queueInts[(tail + 1)]) : fillPtr;
    
    int newFillPtr = fillPtr - count;
    if (count <= 0)
      throw new Error("outputPartialLine called when nothing can be output.");
    writeToBase(buffer, 0, count);
    bufferFillPointer = count;
    bufferStartColumn = getColumnNumber();
    System.arraycopy(buffer, count, buffer, 0, newFillPtr);
    bufferFillPointer = newFillPtr;
    bufferOffset += count;
  }
  














  public void resolveBackReferences()
  {
    if (!reallySharing)
      return;
    int posnMarkerCount = 0;
    GapBuffer gbuffer = new GapBuffer(buffer, buffer.length);
    

    int delta = 0;
    




    int tail = queueTail;
    int todo = queueSize;
    while (todo > 0)
    {
      if (tail >= queueInts.length) {
        tail = 0;
      }
      int next = tail;
      int type = getQueueType(next);
      




      if (type != 0)
        gbuffer.addUpTo(posnIndex(queueInts[(next + 1)]));
      int oldDelta;
      int relativeAddress; switch (type)
      {
      case 7: 
        oldDelta = delta;
        
        if (posnMarkerActive(next))
        {
          if (posnMarkerIsGrouping(next))
          {
            gbuffer.add('.');
            gbuffer.add(' ');
            delta += 2;
          }
          gbuffer.add('#');
          

          if (queueInts[(next + 2)] == 1)
          {
            queueInts[(next + 2)] = (posnMarkerCount++);
          }
          
          int reference = queueInts[(next + 2)];
          

          delta += gbuffer.add(reference);
          gbuffer.add('=');
          delta += 2;
          
          if (posnMarkerIsGrouping(next))
          {
            gbuffer.add('(');
            delta++;
          }
          




          queueInts[(next + 1)] += delta - oldDelta; }
        break;
      
      case 8: 
        oldDelta = delta;
        
        relativeAddress = queueInts[(next + 2)];
        

        int count = queueInts[(relativeAddress + 2)];
        gbuffer.add('#');
        

        delta += gbuffer.add(count);
        gbuffer.add('#');
        delta += 2;
        

        queueInts[(next + 1)] += delta - oldDelta;
        break;
      case 9: 
        relativeAddress = queueInts[(next + 2)];
        
        if (posnMarkerActive(relativeAddress))
        {
          gbuffer.add(')');
          delta++;
          queueInts[(next + 1)] += 1;
        }
        
        break;
      default: 
        queueInts[(next + 1)] += delta;
      }
      
      int size = getQueueSize(tail);
      
      todo -= size;
      
      tail = next + size;
    }
    

    bufferFillPointer += delta;
    
    buffer = gbuffer.restoreBuffer();
    posnMarkerCount = 1;
  }
  
  public void forcePrettyOutput()
  {
    enqueueNewline(68);
    maybeOutput(false, true);
    if (bufferFillPointer > 0)
      outputPartialLine();
    expandTabs(-1);
    bufferStartColumn = getColumnNumber();
    writeToBase(buffer, 0, bufferFillPointer);
    bufferFillPointer = 0;
    queueSize = (this.queueTail = this.bufferOffset = 0);
  }
  
  public void flush()
  {
    if (out == null) {
      return;
    }
    try {
      forcePrettyOutput();
      out.flush();
    }
    catch (IOException ex)
    {
      throw new RuntimeException(ex.toString());
    }
  }
  
  public void close()
  {
    if (out != null)
    {
      forcePrettyOutput();
      super.close();
      out = null;
    }
    buffer = null;
  }
  
  public void closeThis()
    throws IOException
  {
    if (out != null)
    {
      forcePrettyOutput();
      out = null;
    }
    buffer = null;
  }
  
  public boolean atLineStart()
  {
    return getColumnNumber() == 0;
  }
  


  public int getColumnNumber()
  {
    int i = bufferFillPointer;
    for (;;)
    {
      i--; if (i < 0)
        return bufferStartColumn + bufferFillPointer;
      char ch = buffer[i];
      if ((ch == '\n') || (ch == '\r')) {
        return bufferFillPointer - (i + 1);
      }
    }
  }
  
  public void setColumnNumber(int column) {
    bufferStartColumn += column - getColumnNumber();
  }
  
  public void clearBuffer()
  {
    bufferStartColumn = 0;
    bufferFillPointer = 0;
    lineNumber = 0;
    bufferOffset = 0;
    blockDepth = 6;
    queueTail = 0;
    queueSize = 0;
    pendingBlocksCount = 0;
  }
  
  private static final class GapBuffer
  {
    char[] buffer;
    char[] existingBuffer;
    int point;
    int existingIndex;
    int gapSize;
    
    public GapBuffer(char[] existing, int startSize)
    {
      buffer = new char[startSize];
      point = 0;
      existingIndex = 0;
      existingBuffer = existing;
    }
    




    public int getPoint()
    {
      return point;
    }
    




    public void add(char ch)
    {
      if (point + 1 >= buffer.length)
      {
        expandBuffer(1);
      }
      buffer[(point++)] = ch;
    }
    





    public int add(int i)
    {
      int ndigits = 1;
      if (i >= 10)
      {
        ndigits += add(i / 10);
        i %= 10;
      }
      add((char)(48 + i));
      return ndigits;
    }
    




    public void addUpTo(int end)
    {
      int n = end - existingIndex;
      if (point + n >= buffer.length)
      {
        expandBuffer(n);
      }
      while (existingIndex < end)
      {
        buffer[(point++)] = existingBuffer[(existingIndex++)];
      }
    }
    



    public char[] restoreBuffer()
    {
      char[] retBuffer = new char[buffer.length];
      System.arraycopy(buffer, 0, retBuffer, 0, point);
      return retBuffer;
    }
    
    private void expandBuffer(int n)
    {
      int newLength = buffer.length;
      int minimum = newLength + n;
      do
      {
        newLength <<= 1;
      } while (newLength < minimum);
      
      char[] newBuffer = new char[newLength];
      System.arraycopy(buffer, 0, newBuffer, 0, point);
      buffer = newBuffer;
    }
  }
}
