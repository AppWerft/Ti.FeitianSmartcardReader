package gnu.kawa.io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;







public class BinaryOutPort
  extends OutPort
{
  OutputStream strm;
  
  public OutputStream getOutputStream()
  {
    flushBuffer();
    return strm;
  }
  


  public BinaryOutPort(OutputStream strm, Path path)
  {
    this(strm, new OutputStreamWriterSimple(strm, false), path);
  }
  





  public BinaryOutPort(OutputStream strm, Writer out, Path path, boolean printPretty, boolean autoflush)
  {
    super(out, printPretty, autoflush, path);
    this.strm = strm;
  }
  
  private BinaryOutPort(OutputStream strm, Writer out, Path path) {
    super(out, path);
    this.strm = strm;
  }
  










  private static Writer makeConvertWriter(MyBufferedOutputStream strm, Charset conv)
  {
    String cname = conv.name();
    boolean isUtf8 = "UTF-8".equals(cname);
    if ((isUtf8) || ("ISO_8859_1".equals(cname))) {
      return new OutputStreamWriterSimple(strm, isUtf8);
    }
    return new OutputStreamWriter(strm, conv);
  }
  
  public static BinaryOutPort makeStandardPort(OutputStream strm, String path) {
    MyBufferedOutputStream bufstrm = new MyBufferedOutputStream(strm);
    Writer wr = makeConvertWriter(bufstrm, Charset.defaultCharset());
    return new BinaryOutPort(bufstrm, new LogWriter(wr), Path.valueOf(path), true, true);
  }
  


  public static BinaryOutPort openFile(OutputStream strm, Path path, Charset conv)
  {
    MyBufferedOutputStream bufstrm = new MyBufferedOutputStream(strm);
    Writer wr = makeConvertWriter(bufstrm, conv);
    return new BinaryOutPort(bufstrm, wr, path);
  }
  
  public static BinaryOutPort openFile(Object fname) throws IOException
  {
    return (BinaryOutPort)OutPort.openFile(fname, Boolean.FALSE);
  }
  

  void flushBuffer()
  {
    if ((strm instanceof MyBufferedOutputStream)) {
      MyBufferedOutputStream mstr = (MyBufferedOutputStream)strm;
      mstr.disableFlush(true);
      try {
        flush();
      } finally {
        mstr.disableFlush(false);
      }
    } else {
      super.flushBuffer();
    }
  }
  
  public void writeBytes(byte[] buf, int off, int len) throws IOException { flushBuffer();
    strm.write(buf, off, len);
  }
  
  public void writeByte(int b) throws IOException {
    flushBuffer();
    strm.write(b);
  }
  
  public static OutputStream asOutputStream(Object obj) {
    if ((obj instanceof BinaryOutPort)) {
      return ((BinaryOutPort)obj).getOutputStream();
    }
    return (OutputStream)obj;
  }
  
  static class MyBufferedOutputStream extends BufferedOutputStream
  {
    boolean flushDisabled;
    
    public MyBufferedOutputStream(OutputStream out)
    {
      super();
    }
    
    public void disableFlush(boolean flushDisabled)
    {
      this.flushDisabled = flushDisabled;
    }
    
    public void flush() throws IOException
    {
      if (!flushDisabled) {
        super.flush();
      }
    }
  }
  

  public static class OutputStreamWriterSimple
    extends Writer
  {
    OutputStream strm;
    boolean utf8;
    int pendingHighSurrogate;
    
    public OutputStreamWriterSimple(OutputStream strm, boolean utf8)
    {
      super();
      this.strm = strm;
      this.utf8 = utf8;
    }
    
    private void write1(int ch) throws IOException {
      if (ch <= (utf8 ? 127 : 255)) {
        strm.write(ch);
      } else if (!utf8) {
        strm.write(63);
      } else {
        int cont = 0;
        if (ch < 2047) {
          strm.write(0xC0 | ch >> 6 & 0x1F);
          cont = 1;
        } else { if ((ch >= 55296) && (ch <= 56319)) {
            pendingHighSurrogate = ch;
            return; }
          if ((ch >= 56320) && (ch <= 57343) && (pendingHighSurrogate > 0))
          {
            ch = (pendingHighSurrogate - 55296) * 1024 + (ch - 56320) + 65536;
            
            strm.write(0xF0 | ch >> 18 & 0x7);
            cont = 3;
            pendingHighSurrogate = 0;
          } else {
            strm.write(0xE0 | ch >> 12 & 0xF);
            cont = 2;
          } }
        for (;;) { cont--; if (cont < 0) break;
          strm.write(0x80 | ch >> 6 * cont & 0x3F);
        }
      }
    }
    
    public void write(int ch) throws IOException
    {
      synchronized (lock) {
        write1(ch);
      }
    }
    
    public void write(char[] cbuf, int off, int len) throws IOException {
      synchronized (lock) {
        for (int i = 0; i < len; i++) {
          char ch = cbuf[(off + i)];
          write1(ch);
        }
      }
    }
    
    public void write(String str, int off, int len) throws IOException
    {
      synchronized (lock) {
        for (int i = 0; i < len; i++) {
          char ch = str.charAt(off + i);
          write1(ch);
        }
      }
    }
    
    public void flush() throws IOException
    {
      synchronized (lock) {
        strm.flush();
      }
    }
    
    public void close() throws IOException {
      synchronized (lock) {
        strm.close();
      }
    }
  }
}
