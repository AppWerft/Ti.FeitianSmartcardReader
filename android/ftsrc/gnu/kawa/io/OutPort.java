package gnu.kawa.io;

import gnu.kawa.format.AbstractFormat;
import gnu.kawa.format.AbstractFormat.FormatConsumer;
import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.mapping.Environment;
import gnu.mapping.ThreadLocation;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;





public class OutPort
  extends PrintConsumer
  implements Printable
{
  PrintConsumer formatter;
  Path path;
  protected Writer base;
  static final int FLUSH_ON_FINALIZE = 1;
  static final int CLOSE_ON_FINALIZE = 2;
  static final int IS_CLOSED = 4;
  static final int IS_DOMTERM = 8;
  int flags;
  protected PrettyWriter bout;
  protected WriterManager.WriterRef unregisterRef;
  
  protected OutPort(Writer base, PrettyWriter out, boolean autoflush)
  {
    super(out, autoflush);
    bout = out;
    formatter = bout;
    this.base = base;
    if (closeOnExit()) {
      unregisterRef = WriterManager.instance.register(this);
    }
  }
  
  protected OutPort(OutPort out, boolean autoflush) {
    this(out, bout, autoflush);
  }
  
  protected OutPort(Writer out, boolean autoflush)
  {
    this(out, (out instanceof OutPort) ? bout : new PrettyWriter(out, true), autoflush);
  }
  



  public OutPort(Writer base, boolean printPretty, boolean autoflush)
  {
    this(base, new PrettyWriter(base, printPretty), autoflush);
  }
  

  public OutPort(Writer base, boolean printPretty, boolean autoflush, Path path)
  {
    this(base, new PrettyWriter(base, printPretty), autoflush);
    this.path = path;
  }
  
  public OutPort(OutputStream out)
  {
    this(out, null);
  }
  
  public OutPort(OutputStream out, Path path)
  {
    this(new OutputStreamWriter(out), true, path);
  }
  
  public OutPort(Writer out)
  {
    this(out, (out instanceof OutPort) ? bout : new PrettyWriter(out, false), false);
  }
  



  public OutPort(Writer base, Path path)
  {
    this(base, false, false);
    this.path = path;
  }
  
  public OutPort(Writer base, boolean autoflush, Path path)
  {
    this(base, false, autoflush);
    this.path = path;
  }
  
  static BinaryOutPort outInitial = BinaryOutPort.makeStandardPort(System.out, "/dev/stdout");
  
  private static BinaryOutPort errInitial;
  
  public static final ThreadLocation<OutPort> outLocation;
  public static final ThreadLocation<OutPort> errLocation;
  static Writer logFile;
  
  public static BinaryOutPort getSystemOut() { return outInitial; }
  public static BinaryOutPort getSystemErr() { return errInitial; }
  
  static
  {
    outInitialflags = 1;
    
    errInitial = BinaryOutPort.makeStandardPort(System.err, "/dev/stderr");
    
    errInitialflags = 1;
    



    outLocation = new ThreadLocation("out-default");
    
    outLocation.setGlobal(outInitial);
    errLocation = new ThreadLocation("err-default");
    
    errLocation.setGlobal(errInitial);
  }
  
  public static OutPort outDefault() { return (OutPort)outLocation.get(); }
  

  public static void setOutDefault(OutPort o)
  {
    outLocation.set(o);
  }
  
  public static OutPort errDefault()
  {
    return (OutPort)errLocation.get();
  }
  
  public static void setErrDefault(OutPort e)
  {
    errLocation.set(e);
  }
  
  public boolean isPrettyPrinting() { return bout.isPrettyPrinting(); }
  
  public static OutPort openFile(Object fname) throws IOException
  {
    return openFile(fname, Environment.user().get("port-char-encoding"));
  }
  
  public static OutPort openFile(Object fname, Object conv) throws IOException
  {
    Path path = Path.valueOf(fname);
    OutputStream strm = path.openOutputStream();
    strm = new BufferedOutputStream(strm);
    

    OutPort op = conv == Boolean.FALSE ? new BinaryOutPort(strm, path) : new OutPort((conv == null) || (conv == Boolean.TRUE) ? new OutputStreamWriter(strm) : new OutputStreamWriter(strm, conv.toString()), path);
    




    flags = 2;
    return op;
  }
  
  public void echo(char[] buf, int off, int len) throws IOException
  {
    if ((base instanceof LogWriter)) {
      ((LogWriter)base).echo(buf, off, len);
    }
  }
  
  public static void closeLogFile()
    throws IOException
  {
    if (logFile != null)
    {
      logFile.close();
      logFile = null;
    }
    if ((outInitialbase instanceof LogWriter))
      ((LogWriter)outInitialbase).setLogFile((Writer)null);
    if ((errInitialbase instanceof LogWriter)) {
      ((LogWriter)errInitialbase).setLogFile((Writer)null);
    }
  }
  
  public static void setLogFile(String name) throws IOException {
    if (logFile != null)
      closeLogFile();
    logFile = new PrintWriter(new BufferedWriter(new FileWriter(name)));
    if ((outInitialbase instanceof LogWriter))
      ((LogWriter)outInitialbase).setLogFile(logFile);
    if ((errInitialbase instanceof LogWriter)) {
      ((LogWriter)errInitialbase).setLogFile(logFile);
    }
  }
  













  protected static final boolean isWordChar(char ch)
  {
    return (Character.isJavaIdentifierPart(ch)) || (ch == '-') || (ch == '+');
  }
  

  public void print(int v)
  {
    formatter.writeInt(v);
  }
  

  public void print(long v)
  {
    formatter.writeLong(v);
  }
  

  public void print(double v)
  {
    formatter.writeDouble(v);
  }
  

  public void print(float v)
  {
    formatter.writeFloat(v);
  }
  

  public void print(boolean v)
  {
    formatter.writeBoolean(v);
  }
  

  public void print(String v)
  {
    write(v == null ? "(null)" : v);
  }
  

  public void print(Object v)
  {
    formatter.writeObject(v);
  }
  
  public void print(Consumer out)
  {
    out.write("#<output-port");
    if (path != null)
    {
      out.write(32);
      out.write(path.toString());
    }
    out.write(62);
  }
  
  public void startDocument()
  {
    formatter.startDocument();
  }
  
  public void endDocument()
  {
    formatter.endDocument();
  }
  

  public void startElement(Object type)
  {
    formatter.startElement(type);
  }
  

  public void endElement()
  {
    formatter.endElement();
  }
  



  public void startAttribute(Object attrType)
  {
    formatter.startAttribute(attrType);
  }
  


  public void endAttribute()
  {
    formatter.endAttribute();
  }
  
  public void write(char[] str, int start, int count) {
    formatter.write(str, start, count);
  }
  
  public void write(String str) {
    formatter.write(str, 0, str.length());
  }
  
  public void write(String str, int start, int count) {
    formatter.write(str, start, count);
  }
  
  public void write(CharSequence str, int start, int count) {
    formatter.write(str, start, count);
  }
  
  public void writeObject(Object v) {
    formatter.writeObject(v);
  }
  
  public void writeComment(char[] chars, int offset, int length) {
    formatter.writeComment(chars, offset, length);
  }
  
  public void writeProcessingInstruction(String target, char[] content, int offset, int length)
  {
    formatter.writeProcessingInstruction(target, content, offset, length);
  }
  
  public void writeCDATA(char[] chars, int offset, int length) {
    formatter.writeCDATA(chars, offset, length);
  }
  
  public void beginEntity(Object baseUri) {
    formatter.beginEntity(baseUri);
  }
  
  public void endEntity() { formatter.endEntity(); }
  


  public void writeWordEnd()
  {
    formatter.writeWordEnd();
  }
  




  public void writeWordStart()
  {
    formatter.writeWordStart();
  }
  
  public Object pushFormat(AbstractFormat format) {
    Object old = formatter;
    formatter = format.makeConsumer(formatter);
    return old;
  }
  
  public void popFormat(Object old) { formatter = ((PrintConsumer)old); }
  

  public void freshLine()
  {
    if (!atLineStart()) {
      println();
    }
  }
  
  public int getColumnNumber()
  {
    return bout.getColumnNumber();
  }
  
  public void setColumnNumber(int column)
  {
    bout.setColumnNumber(column);
  }
  
  public boolean atLineStart() {
    return bout.atLineStart();
  }
  
  void flushBuffer() {
    bout.forcePrettyOutput();
  }
  
  public void clearBuffer()
  {
    bout.clearBuffer();
  }
  

  public void closeThis()
  {
    try
    {
      if ((!(base instanceof OutPort)) || (base).bout != bout)) {
        bout.closeThis();
        base = null;
        out = null;
      }
    }
    catch (IOException ex)
    {
      setError();
    }
    WriterManager.instance.unregister(unregisterRef);
    unregisterRef = null;
  }
  
  public boolean isOpen() { return (flags & 0x4) == 0; }
  public boolean isDomTerm() { return (flags & 0x8) != 0; }
  
  public void setDomTerm(boolean v) { if (v) flags |= 0x8; else
      flags &= 0xFFFFFFF7;
    bout.isDomTerm = v;
  }
  



  public static OutPort getPassThroughOutPort(Consumer out)
  {
    OutPort port = null;
    for (;;) {
      if ((out instanceof OutPort)) {
        port = (OutPort)out;
        PrintConsumer formatter = formatter;
        if ((formatter instanceof PrettyWriter))
          return port;
        out = formatter;
      } else { if (!(out instanceof AbstractFormat.FormatConsumer)) break;
        AbstractFormat.FormatConsumer fcons = (AbstractFormat.FormatConsumer)out;
        if (!fcons.getFormat().textIsCopied())
          return null;
        out = fcons.getBase();
      }
    }
    return port;
  }
  


  public void close()
  {
    try
    {
      if (((base instanceof OutPort)) && (base).bout == bout)) {
        base.close();
        base = null;
      }
      else if (out != null) {
        out.close();
        out = null;
      }
    }
    catch (IOException ex)
    {
      setError();
    }
    WriterManager.instance.unregister(unregisterRef);
    unregisterRef = null;
    flags = 4;
  }
  


  protected boolean closeOnExit()
  {
    return true;
  }
  
  public void finalize()
  {
    if ((flags & 0x1) != 0)
      flush();
    if ((flags & 0x2) != 0) {
      close();
    } else {
      closeThis();
    }
  }
  
  public static void runCleanups() {
    WriterManager.instance.run();
  }
  
  public void setPrettyPrinting(boolean mode) {
    bout.setPrettyPrinting(mode);
  }
  
  public void startLogicalBlock(String prefix, boolean perLine, String suffix)
  {
    bout.startLogicalBlock(prefix, perLine, suffix);
  }
  
  public void startLogicalBlock(String prefix, String suffix, int indent)
  {
    synchronized (lock) {
      bout.startLogicalBlock(prefix, false, suffix);
      bout.addIndentation(prefix == null ? indent : indent - prefix.length(), false);
    }
  }
  

  public void endLogicalBlock(String suffix)
  {
    bout.endLogicalBlock(suffix);
  }
  
  public void writeBreak(int kind) {
    bout.writeBreak(kind);
  }
  
  public void writeSpace(int kind)
  {
    synchronized (lock) {
      write(32);
      writeBreak(kind);
    }
  }
  
  public void setIndentation(int amount, boolean current)
  {
    bout.addIndentation(amount, current);
  }
}
