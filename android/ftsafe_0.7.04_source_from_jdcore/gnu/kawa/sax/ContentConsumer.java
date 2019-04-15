package gnu.kawa.sax;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.SeqPosition;
import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.xml.XName;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;


public class ContentConsumer
  implements Consumer
{
  ContentHandler out;
  int nesting = 0;
  String[] names = new String[15];
  String attrQName;
  String attrURI; String attrLocalName; AttributesImpl attributes = new AttributesImpl();
  
  char[] chBuffer;
  StringBuilder strBuffer = new StringBuilder(200);
  

  int inStartTag;
  


  public ContentConsumer() {}
  


  public ContentConsumer(ContentHandler handler)
  {
    out = handler;
  }
  
  public void error(String method, SAXException ex)
  {
    throw new RuntimeException("caught " + ex + " in " + method);
  }
  
  public void endStartTag()
  {
    if (inStartTag != 1)
      return;
    int i = 3 * (nesting - 1);
    try
    {
      out.startElement(names[i], names[(i + 1)], names[(i + 2)], attributes);
    }
    catch (SAXException ex)
    {
      error("startElement", ex);
    }
    attributes.clear();
    inStartTag = 0;
  }
  
  public void startElement(Object type)
  {
    if (inStartTag == 1)
      endStartTag();
    flushStrBuffer();
    int i = 3 * nesting;
    if (i >= names.length)
    {
      String[] tmp = new String[2 * i];
      System.arraycopy(names, 0, tmp, 0, i);
      names = tmp; }
    String localName;
    String namespaceURI;
    String localName; if ((type instanceof Symbol))
    {
      Symbol sym = (Symbol)type;
      String namespaceURI = sym.getNamespaceURI();
      localName = sym.getLocalName();
    } else { String localName;
      if ((type instanceof XName))
      {
        XName sym = (XName)type;
        String namespaceURI = sym.getNamespaceURI();
        localName = sym.getLocalName();
      }
      else
      {
        namespaceURI = "";
        localName = type.toString();
      } }
    names[i] = namespaceURI;
    names[(i + 1)] = localName;
    names[(i + 2)] = type.toString();
    inStartTag = 1;
    nesting += 1;
  }
  
  public void startAttribute(Object attrType)
  {
    attrURI = ((Symbol)attrType).getNamespaceURI();
    attrLocalName = ((Symbol)attrType).getLocalName();
    attrQName = attrType.toString();
    inStartTag = 2;
  }
  
  public void endAttribute()
  {
    attributes.addAttribute(attrURI, attrLocalName, attrQName, "CDATA", strBuffer.toString());
    
    strBuffer.setLength(0);
    inStartTag = 1;
  }
  
  public void startDocument()
  {
    try
    {
      out.startDocument();
    }
    catch (SAXException ex)
    {
      error("startDocument", ex);
    }
  }
  
  public void endDocument()
  {
    try
    {
      out.endDocument();
    }
    catch (SAXException ex)
    {
      error("endDocument", ex);
    }
  }
  
  public void endElement()
  {
    endStartTag();
    flushStrBuffer();
    nesting -= 1;
    int i = 3 * nesting;
    try
    {
      out.endElement(names[i], names[(i + 1)], names[(i + 2)]);
    }
    catch (SAXException ex)
    {
      error("endElement", ex);
    }
    names[i] = null;
    names[(i + 1)] = null;
    names[(i + 2)] = null;
  }
  
  void flushStrBuffer()
  {
    if (strBuffer.length() > 0)
    {
      if (chBuffer == null) {
        chBuffer = new char['È'];
      }
      try {
        int slen = strBuffer.length();
        int start = 0;
        for (;;)
        {
          int len = slen - start;
          if (len <= 0)
            break;
          if (len > chBuffer.length)
            len = chBuffer.length;
          strBuffer.getChars(start, start + len, chBuffer, start);
          out.characters(chBuffer, 0, len);
          start += len;
        }
        strBuffer.setLength(0);
      }
      catch (SAXException ex)
      {
        error("characters", ex);
      }
    }
  }
  
  public void write(char[] buf, int off, int len)
  {
    if (inStartTag == 1)
      endStartTag();
    if (inStartTag == 2) {
      strBuffer.append(buf, off, len);
    }
    else {
      flushStrBuffer();
      try
      {
        out.characters(buf, off, len);
      }
      catch (SAXException ex)
      {
        error("characters", ex);
      }
    }
  }
  
  public void write(int v)
  {
    if (inStartTag == 1)
      endStartTag();
    if (v >= 65536)
    {
      strBuffer.append((char)((v - 65536 >> 10) + 55296));
      v = (v & 0x3FF) + 56320;
    }
    strBuffer.append((char)v);
  }
  
  public void write(String v)
  {
    if (inStartTag == 1)
      endStartTag();
    strBuffer.append(v);
  }
  




  public void write(CharSequence str, int start, int length)
  {
    if (inStartTag == 1)
      endStartTag();
    strBuffer.append(str, start, start + length);
  }
  

  public ContentConsumer append(char c)
  {
    write(c);
    return this;
  }
  
  public ContentConsumer append(CharSequence csq) {
    if (csq == null)
      csq = "null";
    write(csq, 0, csq.length());
    return this;
  }
  
  public ContentConsumer append(CharSequence csq, int start, int end) {
    if (csq == null)
      csq = "null";
    write(csq, start, end);
    return this;
  }
  


  public void writeObject(Object v)
  {
    if ((v instanceof Consumable)) {
      ((Consumable)v).consume(this);
    } else if ((v instanceof SeqPosition))
    {
      SeqPosition pos = (SeqPosition)v;
      sequence.consumeNext(ipos, this);
    }
    else if ((v instanceof Char)) {
      ((Char)v).print(this);
    } else {
      write(v == null ? "(null)" : v.toString());
    }
  }
  
  public void writeBoolean(boolean v) {
    if (inStartTag == 1) {
      endStartTag();
    }
    strBuffer.append(v);
  }
  
  public void writeLong(long v)
  {
    if (inStartTag == 1) {
      endStartTag();
    }
    strBuffer.append(v);
  }
  
  public void writeInt(int v)
  {
    if (inStartTag == 1) {
      endStartTag();
    }
    strBuffer.append(v);
  }
  
  public void writeFloat(float v)
  {
    if (inStartTag == 1) {
      endStartTag();
    }
    strBuffer.append(v);
  }
  
  public void writeDouble(double v)
  {
    if (inStartTag == 1) {
      endStartTag();
    }
    strBuffer.append(v);
  }
  
  public void finalize()
  {
    flushStrBuffer();
  }
  
  public boolean ignoring()
  {
    return false;
  }
  
  public void setContentHandler(ContentHandler handler)
  {
    out = handler;
  }
  
  public ContentHandler getContentHandler()
  {
    return out;
  }
}
