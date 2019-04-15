package gnu.kawa.io;

import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.mapping.Environment;
import gnu.mapping.ThreadLocation;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;


public class InPort
  extends Reader
  implements Printable
{
  public static final String systemInFilename = "/dev/stdin";
  private static InPort systemInPort;
  public static final String evalPathname = "<eval>";
  public static final String stringPathname = "<string>";
  public static final ThreadLocation<InPort> inLocation;
  protected Reader in;
  public static final int BUFFER_SIZE = 8192;
  public char[] buffer;
  public int pos;
  public int limit;
  int highestPos;
  
  static
  {
    Path systemInPath = Path.valueOf("/dev/stdin");
    if (CheckConsole.haveConsole()) {
      TtyInPort tin = TtyInPort.make(System.in, systemInPath, OutPort.outInitial);
      
      if (CheckConsole.getDomTermVersionInfo() != null)
        tin.setInDomTerm(true);
      systemInPort = tin;
    } else {
      systemInPort = new BinaryInPort(System.in, systemInPath);
    }
    

    inLocation = new ThreadLocation("in-default");
    
    inLocation.setGlobal(systemInPort);
  }
  
  public static InPort inDefault() {
    return (InPort)inLocation.get();
  }
  
  public static void setInDefault(InPort in)
  {
    inLocation.set(in);
  }
  
  public static InPort openFile(Object fname) throws IOException {
    Path path = Path.valueOf(fname);
    return openFile(path.openInputStream(), path);
  }
  
  public static InPort openFile(Object fname, Object conv) throws IOException
  {
    Path path = Path.valueOf(fname);
    return openFile(path.openInputStream(), path, conv);
  }
  
  public static InPort openFile(InputStream strm, Path path) throws UnsupportedEncodingException
  {
    Object conv = Environment.user().get("port-char-encoding");
    return openFile(strm, path, conv);
  }
  
  public static InPort openFile(InputStream strm, Path path, Object conv) throws UnsupportedEncodingException
  {
    if (conv == Boolean.FALSE) {
      return new BinaryInPort(strm, path);
    }
    if (!(strm instanceof BufferedInputStream))
      strm = new BufferedInputStream(strm);
    Reader rdr;
    Reader rdr; if ((conv instanceof Charset)) {
      rdr = new InputStreamReader(strm, (Charset)conv); } else { Reader rdr;
      if ((conv instanceof CharsetDecoder)) {
        rdr = new InputStreamReader(strm, (CharsetDecoder)conv);
      } else if ((conv != null) && (conv != Boolean.TRUE)) {
        String enc = conv.toString();
        try {
          rdr = new InputStreamReader(strm, enc);
        } catch (UnsupportedEncodingException ex) { Reader rdr;
          throw new RuntimeException("unknown character encoding: " + enc);
        }
      } else {
        rdr = new InputStreamReader(strm); } }
    InPort port = new InPort(rdr, path);
    port.setConvertCR(true);
    return port;
  }
  
  public void print(Consumer out)
  {
    out.write("#<input-port");
    String name = getName();
    if (name != null)
    {
      out.write(32);
      out.write(name);
    }
    out.write(62);
  }
  
  public void close() throws IOException {
    synchronized (lock) {
      flags |= 0x20;
      if (in != null)
        try {
          in.close();
        } finally {
          in = null;
          buffer = null;
        }
    }
  }
  
  public boolean isOpen() {
    return (flags & 0x20) == 0;
  }
  
















  public char readState = '\n';
  private int flags;
  private static final int CONVERT_CR = 1;
  
  public char getReadState() {
    return readState;
  }
  



  private static final int USER_BUFFER = 2;
  


  private static final int PREV_WAS_CR = 4;
  


  private static final int DONT_KEEP_FULL_LINES = 8;
  


  private static final int EOF_SEEN = 16;
  


  private static final int IS_CLOSED = 32;
  


  private static final int KEEP_ALL = 64;
  


  private int lineStartPos;
  

  Path path;
  

  protected int lineNumber;
  

  public void setKeepFullLines(boolean keep)
  {
    if (keep) {
      flags &= 0xFFFFFFF7;
    } else
      flags |= 0x8;
  }
  
  public void setKeepAll(boolean keep) {
    if (keep) {
      flags |= 0x40;
    } else if ((flags & 0x40) != 0)
      flags &= 0xFFFFFFBF;
  }
  
  public void resetAndKeep() {
    int lineno = getLineNumber();
    mark(-1);
    pos = 0;
    limit = 0;
    lineStartPos = 0;
    markPos = 0;
    highestPos = 0;
    lineNumber = lineno;
    flags |= 0x40;
  }
  
  public final boolean getConvertCR() {
    return (flags & 0x1) != 0;
  }
  
  public final void setConvertCR(boolean convertCR) {
    if (convertCR) {
      flags |= 0x1;
    } else {
      flags &= 0xFFFFFFFE;
    }
  }
  




















  protected int readAheadLimit = -1;
  

  protected int markPos;
  

  public InPort(Reader in, Path path)
  {
    this(in);
    setPath(path);
  }
  
  public InPort(InputStream in) {
    this(in, new InputStreamReader(in));
  }
  
  public InPort(Object lock, Reader in) {
    super(lock);
    this.in = in;
  }
  
  public InPort(InputStream in, Path path) {
    this(in);
    setPath(path);
  }
  
  public InPort(Reader in) {
    super(in);
    this.in = in;
  }
  













  protected int fill(int len)
    throws IOException
  {
    return in.read(buffer, pos, len);
  }
  

  private void clearMark()
  {
    int oldLimit = readAheadLimit;
    readAheadLimit = -1;
    if (oldLimit <= 0) {
      return;
    }
    int i = lineStartPos < 0 ? 0 : lineStartPos;
    for (;;)
    {
      i++; if (i >= pos)
        break;
      char ch = buffer[(i - 1)];
      if ((ch == '\n') || ((ch == '\r') && ((!getConvertCR()) || (buffer[i] != '\n'))))
      {

        lineNumber += 1;
        lineStartPos = i;
      }
    }
  }
  


  public void setBuffer(char[] buffer)
    throws IOException
  {
    if (buffer == null)
    {
      if (this.buffer != null)
      {
        buffer = new char[this.buffer.length];
        System.arraycopy(this.buffer, 0, buffer, 0, this.buffer.length);
        this.buffer = buffer;
      }
      flags &= 0xFFFFFFFD;
    }
    else
    {
      if (limit - pos > buffer.length)
        throw new IOException("setBuffer - too short");
      flags |= 0x2;
      reserve(buffer, 0);
    }
  }
  



  private void reserve(char[] buffer, int reserve)
  {
    reserve += limit;
    int saveStart; int saveStart; if ((flags & 0x40) != 0) {
      if (reserve > buffer.length) {
        int nlen = 3 * buffer.length >> 1;
        if (nlen < reserve)
          nlen = reserve;
        buffer = new char[nlen];
      }
      saveStart = 0;
    } else { int saveStart;
      if (reserve <= buffer.length) {
        saveStart = 0;
      }
      else {
        saveStart = pos;
        if ((readAheadLimit >= 0) && (markPos < pos))
        {
          if (((readAheadLimit > 0) && (pos - markPos > readAheadLimit)) || (((flags & 0x2) != 0) && (reserve - markPos > buffer.length)))
          {

            clearMark();
          } else {
            saveStart = markPos;
          }
        }
        reserve -= buffer.length;
        if ((reserve > saveStart) || ((saveStart > lineStartPos) && ((flags & 0x8) == 0)))
        {


          if ((reserve <= lineStartPos) && (saveStart > lineStartPos)) {
            saveStart = lineStartPos;
          } else if ((flags & 0x2) != 0) {
            saveStart -= (saveStart - reserve >> 2);
          }
          else {
            if (lineStartPos >= 0)
              saveStart = lineStartPos;
            buffer = new char[2 * buffer.length];
          }
        }
        lineStartPos -= saveStart;
        limit -= saveStart;
        markPos -= saveStart;
        pos -= saveStart;
        highestPos -= saveStart;
      } }
    if (limit > 0)
      System.arraycopy(this.buffer, saveStart, buffer, 0, limit);
    this.buffer = buffer;
  }
  
  public int read() throws IOException {
    synchronized (lock) { char prev;
      char prev;
      if (pos > 0) {
        prev = buffer[(pos - 1)]; } else { char prev;
        if ((flags & 0x4) != 0) {
          prev = '\r'; } else { char prev;
          if (lineStartPos >= 0) {
            prev = '\n';
          } else
            prev = '\000'; } }
      if ((prev == '\r') || (prev == '\n')) {
        if ((lineStartPos < pos) && ((readAheadLimit <= 0) || (pos <= markPos)))
        {
          lineStartPos = pos;
          lineNumber += 1;
        }
        boolean revisited = pos < highestPos;
        if ((prev != '\n') || (pos <= 1 ? (flags & 0x4) == 0 : buffer[(pos - 2)] != '\r'))
        {

          lineStart(revisited);
        }
        if (!revisited) {
          highestPos = (pos + 1);
        }
      }
      if (pos >= limit) {
        if (buffer == null) {
          buffer = new char[' '];
        } else if ((limit == buffer.length) && (!(this instanceof CharArrayInPort)))
        {
          reserve(buffer, 1); }
        if (pos == 0) {
          if (prev == '\r') {
            flags |= 0x4;
          } else
            flags &= 0xFFFFFFFB;
        }
        int readCount = fill(buffer.length - pos);
        if (readCount <= 0) {
          flags |= 0x10;
          return -1;
        }
        limit += readCount;
      }
      
      int ch = buffer[(pos++)];
      if (ch == 10) {
        if (prev == '\r')
        {



          if (lineStartPos == pos - 1) {
            lineNumber -= 1;
            lineStartPos -= 1;
          }
          if (getConvertCR())
            return read();
        }
      } else if ((ch == 13) && 
        (getConvertCR())) {
        return 10;
      }
      return ch;
    }
  }
  
  public int read(char[] cbuf, int off, int len) throws IOException {
    synchronized (lock) {
      int ch;
      int ch;
      if (pos >= limit) {
        ch = 0; } else { int ch;
        if (pos > 0) {
          ch = buffer[(pos - 1)]; } else { int ch;
          if (((flags & 0x4) != 0) || (lineStartPos >= 0)) {
            ch = 10;
          } else
            ch = 0; } }
      int to_do = len;
      while (to_do > 0) {
        if ((pos >= limit) || (ch == 10) || (ch == 13))
        {


          if ((pos >= limit) && (to_do < len))
            return len - to_do;
          ch = read();
          if (ch < 0) {
            len -= to_do;
            return len <= 0 ? -1 : len;
          }
          cbuf[(off++)] = ((char)ch);
          to_do--;
        } else {
          int p = pos;
          int lim = limit;
          if (to_do < lim - p)
            lim = p + to_do;
          while (p < lim) {
            ch = buffer[p];
            

            if ((ch == 10) || (ch == 13))
              break;
            cbuf[(off++)] = ((char)ch);
            p++;
          }
          to_do -= p - pos;
          pos = p;
        }
      }
      return len;
    }
  }
  
  public Path getPath()
  {
    return path;
  }
  
  public void setPath(Path path)
  {
    this.path = path;
  }
  
  public String getName()
  {
    return path == null ? null : path.toString();
  }
  
  public void setName(Object name)
  {
    setPath(Path.valueOf(name));
  }
  

  public int getLineNumber()
  {
    synchronized (lock) {
      int lineno = lineNumber;
      if (readAheadLimit <= 0) {
        if ((pos > 0) && (pos > lineStartPos)) {
          char prev = buffer[(pos - 1)];
          if ((prev == '\n') || (prev == '\r')) {
            lineno++;
          }
        }
      } else {
        lineno += countLines(buffer, lineStartPos < 0 ? 0 : lineStartPos, pos);
      }
      return lineno;
    }
  }
  
  public void setLineNumber(int lineNumber) {
    synchronized (lock) {
      this.lineNumber += lineNumber - getLineNumber();
    }
  }
  
  public void incrLineNumber(int lineDelta, int lineStartPos) {
    synchronized (lock) {
      lineNumber += lineDelta;
      this.lineStartPos = lineStartPos;
    }
  }
  



  public void setSaveStart(int saveStart)
  {
    synchronized (lock) {
      markPos = saveStart;
      readAheadLimit = (saveStart < 0 ? -1 : 0);
    }
  }
  
  public int getColumnNumber()
  {
    synchronized (lock) {
      if (pos > 0) {
        char prev = buffer[(pos - 1)];
        if ((prev == '\n') || (prev == '\r'))
          return 0;
      }
      if (readAheadLimit <= 0) {
        return pos - lineStartPos;
      }
      

      int start = lineStartPos < 0 ? 0 : lineStartPos;
      for (int i = start; i < pos;) {
        char ch = buffer[(i++)];
        if ((ch == '\n') || (ch == '\r'))
          start = i;
      }
      int col = pos - start;
      if (lineStartPos < 0)
        col -= lineStartPos;
      return col;
    }
  }
  
  public boolean markSupported() {
    return true;
  }
  
  public void mark(int readAheadLimit) {
    synchronized (lock) {
      if (this.readAheadLimit >= 0)
        clearMark();
      this.readAheadLimit = readAheadLimit;
      markPos = pos;
    }
  }
  
  public void reset() throws IOException {
    if (readAheadLimit < 0)
      throw new IOException("mark invalid");
    synchronized (lock) {
      if (pos > highestPos)
        highestPos = pos;
      pos = markPos;
      readAheadLimit = -1;
    }
  }
  



  public void readLine(StringBuffer sbuf, char mode)
    throws IOException
  {
    synchronized (lock)
    {
      int ch = read();
      if (ch < 0)
        return;
      int start = --pos;
      while (pos < limit) {
        ch = buffer[(pos++)];
        if ((ch == 13) || (ch == 10)) {
          sbuf.append(buffer, start, pos - 1 - start);
          if (mode == 'P') {
            pos -= 1;
            return;
          }
          if ((getConvertCR()) || (ch == 10)) {
            if (mode != 'I')
              sbuf.append('\n');
          } else {
            if (mode != 'I')
              sbuf.append('\r');
            ch = read();
            if (ch == 10) {
              if (mode != 'I')
                sbuf.append('\n');
            } else if (ch >= 0)
              unread_quick();
          }
          return;
        }
      }
      sbuf.append(buffer, start, pos - start);
    }
  }
  
  public String readLine() throws IOException
  {
    synchronized (lock) {
      int ch = read();
      if (ch < 0)
        return null;
      if ((ch == 13) || (ch == 10))
        return "";
      int start = pos - 1;
      while (pos < limit) {
        ch = buffer[(pos++)];
        if ((ch == 13) || (ch == 10)) {
          int end = pos - 1;
          if ((ch != 10) && (!getConvertCR())) {
            if (pos >= limit) {
              pos -= 1;
              break;
            }
            if (buffer[pos] == '\n')
              pos += 1;
          }
          return new String(buffer, start, end - start);
        }
      }
      StringBuffer sbuf = new StringBuffer(100);
      sbuf.append(buffer, start, pos - start);
      readLine(sbuf, 'I');
      return sbuf.toString();
    }
  }
  
  public int skip(int n) throws IOException
  {
    synchronized (lock) {
      if (n < 0) {
        for (int to_do = -n; 
            (to_do > 0) && (pos > 0); to_do--)
          unread();
        return n + to_do;
      }
      
      int to_do = n;
      int ch;
      int ch; if (pos >= limit) {
        ch = 0; } else { int ch;
        if (pos > 0) {
          ch = buffer[(pos - 1)]; } else { int ch;
          if (((flags & 0x4) != 0) || (lineStartPos >= 0)) {
            ch = 10;
          } else
            ch = 0; } }
      while (to_do > 0) {
        if ((ch == 10) || (ch == 13) || (pos >= limit)) {
          ch = read();
          if (ch < 0)
            return n - to_do;
          to_do--;
        } else {
          int p = pos;
          int lim = limit;
          if (to_do < lim - p)
            lim = p + to_do;
          while (p < lim) {
            ch = buffer[p];
            


            if ((ch == 10) || (ch == 13))
              break;
            p++;
          }
          to_do -= p - pos;
          pos = p;
        }
      }
      return n;
    }
  }
  
  public boolean eofSeen()
  {
    return (flags & 0x10) != 0;
  }
  
  public boolean ready() throws IOException {
    synchronized (lock) {
      return (pos < limit) || ((flags & 0x10) != 0) || (sourceReady());
    }
  }
  
  protected boolean sourceReady() throws IOException {
    return in.ready();
  }
  
  public final void skip_quick()
    throws IOException
  {
    pos += 1;
  }
  
  public void skip() throws IOException
  {
    read();
  }
  
  static int countLines(char[] buffer, int start, int limit)
  {
    int count = 0;
    char prev = '\000';
    for (int i = start; i < limit; i++)
    {
      char ch = buffer[i];
      if (((ch == '\n') && (prev != '\r')) || (ch == '\r'))
        count++;
      prev = ch;
    }
    return count;
  }
  
  public void skipRestOfLine() throws IOException
  {
    synchronized (lock) {
      for (;;) {
        int c = read();
        if (c < 0)
          return;
        if (c == 13) {
          c = read();
          if ((c >= 0) && (c != 10))
            unread();
        } else {
          if (c == 10)
            break;
        }
      }
    }
  }
  
  public void unread() throws IOException {
    synchronized (lock) {
      if (pos == 0)
        throw new IOException("unread too much");
      pos -= 1;
      char ch = buffer[pos];
      if ((ch == '\n') || (ch == '\r')) {
        if ((pos > 0) && (ch == '\n') && (getConvertCR()) && (buffer[(pos - 1)] == '\r'))
        {
          pos -= 1; }
        if (pos < lineStartPos) {
          lineNumber -= 1;
          
          for (int i = pos; i > 0;) {
            ch = buffer[(--i)];
            if ((ch == '\r') || (ch == '\n')) {
              i++;
            }
          }
          
          lineStartPos = i;
        }
      }
    }
  }
  


  public void unread_quick()
  {
    pos -= 1;
  }
  
  public int peek() throws IOException {
    synchronized (lock) {
      if ((pos < limit) && (pos > 0)) {
        char ch = buffer[(pos - 1)];
        if ((ch != '\n') && (ch != '\r')) {
          ch = buffer[pos];
          if ((ch == '\r') && (getConvertCR()))
            ch = '\n';
          return ch;
        }
      }
      int c = read();
      if (c >= 0)
        unread_quick();
      return c;
    }
  }
  

  public static int readCodePoint(Reader in)
    throws IOException
  {
    int c = in.read();
    if ((c >= 55296) && (c <= 56319)) {
      int next = in.read();
      if ((next >= 56320) && (next <= 57343)) {
        c = (c - 55296 << 10) + (next - 56320) + 65536;
      } else
        c = 65533;
    }
    return c;
  }
  
  public int readCodePoint() throws IOException {
    synchronized (lock) {
      return readCodePoint(this);
    }
  }
  
  public static int peekCodePoint(Reader in) throws IOException {
    if ((in instanceof InPort)) {
      return ((InPort)in).peekCodePoint();
    }
    in.mark(2);
    int ch = readCodePoint(in);
    in.reset();
    return ch;
  }
  
  public int peekCodePoint() throws IOException
  {
    synchronized (lock) {
      int ch = peek();
      if ((ch < 55296) || (ch > 56319))
        return ch;
      if ((readAheadLimit > 0) && (pos + 2 - markPos > readAheadLimit))
        clearMark();
      if (readAheadLimit == 0) {
        mark(2);
        ch = readCodePoint(this);
        reset();
      }
      else {
        int savePos = pos;
        ch = readCodePoint(this);
        if (pos > highestPos)
          highestPos = pos;
        pos = savePos;
      }
      return ch;
    }
  }
  
  public void lineStart(boolean revisited)
    throws IOException
  {}
}
