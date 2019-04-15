package gnu.kawa.xml;

import gnu.kawa.io.BinaryOutPort;
import gnu.kawa.io.OutPort;
import gnu.lists.Blob;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.mapping.Symbol;
import gnu.xml.XMLPrinter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;


public class HttpPrinter
  extends PrintConsumer
{
  Vector headers = new Vector();
  
  StringBuilder sbuf = new StringBuilder(100);
  
  Object currentHeader;
  
  private int seenStartDocument;
  
  protected String sawContentType;
  
  private int elementNesting;
  
  protected OutputStream ostream;
  PrintConsumer writer;
  boolean seenXmlHeader;
  
  public HttpPrinter(OutputStream out)
  {
    super(null);
    ostream = out;
  }
  
  public HttpPrinter(PrintConsumer out)
  {
    super(null);
    writer = out;
  }
  
  public static HttpPrinter make(PrintConsumer out)
  {
    return new HttpPrinter(out);
  }
  
  protected void beforeNode()
  {
    if (sawContentType == null)
      addHeader("Content-type", "text/xml");
    beginData();
  }
  
  public void printHeader(String label, String value)
    throws IOException
  {
    writeRaw(label);
    writeRaw(": ");
    writeRaw(value);
    writeRaw("\n");
  }
  
  public void printHeaders()
    throws IOException
  {
    int num = headers.size();
    for (int i = 0; i < num; i += 2) {
      printHeader(headers.elementAt(i).toString(), headers.elementAt(i + 1).toString());
    }
    writeRaw("\n");
  }
  
  public void addHeader(String label, String value)
  {
    if (label.equalsIgnoreCase("Content-type"))
      sawContentType = value;
    headers.addElement(label);
    headers.addElement(value);
  }
  
  public void startAttribute(Object attrType)
  {
    if (base == null) {
      currentHeader = attrType;
    } else {
      base.startAttribute(attrType);
    }
  }
  
  public void endAttribute() {
    if (currentHeader != null)
    {
      addHeader(currentHeader.toString(), sbuf.toString());
      sbuf.setLength(0);
      currentHeader = null;
    }
    else {
      base.endAttribute();
    }
  }
  

  public void beginData()
  {
    if (base == null)
    {
      if (sawContentType == null)
        addHeader("Content-type", "text/plain");
      if (writer == null)
        writer = new OutPort(ostream);
      String style = null;
      if ("text/html".equalsIgnoreCase(sawContentType)) {
        style = "html";
      } else if ("application/xhtml+xml".equalsIgnoreCase(sawContentType)) {
        style = "xhtml";
      } else if ("text/plain".equalsIgnoreCase(sawContentType))
        style = "plain";
      XMLPrinter xout = XMLPrinter.make(writer, style);
      out = xout;
      base = xout;
      if (seenStartDocument == 0)
      {
        base.startDocument();
        seenStartDocument = 1;
      }
      try
      {
        printHeaders();
      }
      catch (Exception ex)
      {
        throw new RuntimeException(ex);
      }
    }
    
    append(sbuf);
    


    sbuf.setLength(0);
  }
  
  public void startElement(Object type)
  {
    if (sawContentType == null) {
      String mimeType;
      String mimeType;
      if (!seenXmlHeader) {
        mimeType = "text/html"; } else { String mimeType;
        if (((type instanceof Symbol)) && ("html".equals(((Symbol)type).getLocalPart())))
        {
          mimeType = "text/xhtml";
        } else
          mimeType = "text/xml"; }
      addHeader("Content-type", mimeType);
    }
    beginData();
    base.startElement(type);
    elementNesting += 1;
  }
  
  public void endElement()
  {
    super.endElement();
    elementNesting -= 1;
    if ((elementNesting == 0) && (seenStartDocument == 1)) {
      endDocument();
    }
  }
  
  public void writeObject(Object v) {
    if ((v instanceof Blob)) {
      OutputStream outs = (writer instanceof BinaryOutPort) ? ((BinaryOutPort)writer).getOutputStream() : ostream;
      


      if (outs == null) {
        writer.write(v.toString());
      } else {
        try {
          ((Blob)v).writeTo(outs);
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
      }
    }
    else if ((v instanceof Consumable)) {
      ((Consumable)v).consume(this);
    }
    else {
      beginData();
      super.writeObject(v);
    }
  }
  




  public void write(CharSequence str, int start, int length)
  {
    if (base == null) {
      sbuf.append(str, start, start + length);
    } else {
      base.write(str, start, length);
    }
  }
  
  public void write(char[] buf, int off, int len) {
    if (base == null) {
      sbuf.append(buf, off, len);
    } else {
      base.write(buf, off, len);
    }
  }
  
  public void startDocument() {
    if (base != null)
      base.startDocument();
    seenStartDocument = 2;
  }
  
  public void endDocument()
  {
    if (base != null) {
      base.endDocument();
    }
    try {
      if (sawContentType == null)
        addHeader("Content-type", "text/plain");
      if (sbuf.length() > 0)
      {
        String str = sbuf.toString();
        sbuf.setLength(0);
        if (writer != null) {
          writer.write(str);
        } else {
          ostream.write(str.getBytes());
        }
      }
      if (writer != null)
        writer.close();
      if (ostream != null) {
        ostream.flush();
      }
    }
    catch (Exception ex) {}
  }
  
  public boolean ignoring()
  {
    return writer != null ? writer.ignoring() : base != null ? base.ignoring() : false;
  }
  






  public boolean reset(boolean headersAlso)
  {
    if (headersAlso)
    {
      headers.clear();
      sawContentType = null;
      currentHeader = null;
      elementNesting = 0;
    }
    sbuf.setLength(0);
    base = null;
    boolean ok = true;
    if (ostream != null)
    {
      ok = writer == null;
      writer = null;
    }
    return ok;
  }
}
