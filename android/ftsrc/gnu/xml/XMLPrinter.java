package gnu.xml;

import gnu.expr.Keyword;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.UnescapedData;
import gnu.lists.XConsumer;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.math.DFloNum;
import gnu.math.RealNum;
import gnu.text.Char;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;

public class XMLPrinter extends PrintConsumer implements gnu.lists.PositionConsumer, XConsumer
{
  protected int printIndent = -1;
  
  public boolean indentAttributes;
  
  boolean printXMLdecl = false;
  public void setPrintXMLdecl(boolean value) { printXMLdecl = value; }
  
  boolean inDocument; boolean inAttribute = false;
  boolean inStartTag = false;
  
  int inComment;
  boolean needXMLdecl = false;
  boolean canonicalize = true;
  


  public boolean canonicalizeCDATA;
  


  public int useEmptyElementTag = 2;
  public boolean escapeText = true;
  public boolean escapeNonAscii = true;
  boolean isHtml = false;
  boolean isHtmlOrXhtml = false;
  boolean undeclareNamespaces = false;
  Object style;
  public boolean extended = true;
  


  public static final ThreadLocation doctypeSystem = new ThreadLocation("doctype-system");
  



  public static final ThreadLocation doctypePublic = new ThreadLocation("doctype-public");
  
  public static final ThreadLocation<String> indentLoc = new ThreadLocation("xml-indent");
  


  NamespaceBinding namespaceBindings = NamespaceBinding.predefinedXML;
  

  NamespaceBinding[] namespaceSaveStack = new NamespaceBinding[20];
  
  Object[] elementNameStack = new Object[20];
  
  int elementNesting;
  
  private static final int WORD = -2;
  
  private static final int ELEMENT_START = -3;
  
  private static final int ELEMENT_END = -4;
  private static final int COMMENT = -5;
  private static final int KEYWORD = -6;
  private static final int PROC_INST = -7;
  int prev = 32;
  char savedHighSurrogate;
  static final String HtmlEmptyTags = "/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/";
  
  public XMLPrinter(Writer out, boolean autoFlush)
  {
    super(out, autoFlush);
  }
  
  public XMLPrinter(Writer out)
  {
    super(out);
  }
  
  public XMLPrinter(Consumer out) {
    super(out, false);
  }
  
  public XMLPrinter(PrintConsumer out) {
    super(out, false);
  }
  
  public XMLPrinter(OutputStream out)
  {
    super(new OutputStreamWriter(out));
  }
  
  public static XMLPrinter make(Consumer out, Object style)
  {
    XMLPrinter xout = new XMLPrinter(out);
    xout.setStyle(style);
    return xout;
  }
  


  public static String toString(Object value)
  {
    StringWriter stringWriter = new StringWriter();
    new XMLPrinter(stringWriter).writeObject(value);
    return stringWriter.toString();
  }
  
  public void setStyle(Object style)
  {
    this.style = style;
    useEmptyElementTag = (canonicalize ? 0 : 1);
    if ("html".equals(style))
    {
      isHtml = true;
      isHtmlOrXhtml = true;
      useEmptyElementTag = 2;
      
      if (namespaceBindings == NamespaceBinding.predefinedXML) {
        namespaceBindings = XmlNamespace.HTML_BINDINGS;
      }
    } else if (namespaceBindings == XmlNamespace.HTML_BINDINGS) {
      namespaceBindings = NamespaceBinding.predefinedXML; }
    if ("xhtml".equals(style))
    {
      isHtmlOrXhtml = true;
      useEmptyElementTag = 2;
    }
    if ("plain".equals(style))
      escapeText = false;
  }
  
  public void setEscapeText(boolean v) { escapeText = v; }
  public void setEscapeNonAscii(boolean v) { escapeNonAscii = v; }
  public void setCanonicalizeCDATA(boolean v) { canonicalizeCDATA = v; }
  public void setUseEmptyElementTag(int v) { useEmptyElementTag = v; }
  public void setExtended(boolean v) { extended = v; }
  
  public void setIndent(int v)
  {
    printIndent = v;
  }
  
  boolean mustHexEscape(int v) {
    return ((v >= 127) && ((v <= 159) || (escapeNonAscii))) || (v == 8232) || ((v < 32) && ((inAttribute) || ((v != 9) && (v != 10))));
  }
  



  public void write(int v)
  {
    closeTag();
    if ((printIndent >= 0) && (
      (v == 13) || (v == 10))) {
      if ((v != 10) || (prev != 13))
        writeBreak(82);
      if (inComment > 0)
        inComment = 1;
      return;
    }
    
    if (!escapeText) {
      writeRaw(v);
      prev = v;
    } else if (inComment > 0) {
      if (v == 45) {
        if (inComment == 1) {
          inComment = 2;
        } else {
          writeRaw(32);
        }
      } else
        inComment = 1;
      writeRaw(v);
    } else {
      prev = 59;
      if ((v == 60) && ((!isHtml) || (!inAttribute))) {
        writeRaw("&lt;");
      } else if (v == 62) {
        writeRaw("&gt;");
      } else if (v == 38) {
        writeRaw("&amp;");
      } else if ((v == 34) && (inAttribute)) {
        writeRaw("&quot;");
      } else if (mustHexEscape(v)) {
        int i = v;
        if (v >= 55296) {
          if (v < 56320) {
            savedHighSurrogate = ((char)v);
            return; }
          if (v < 57344)
          {

            i = (savedHighSurrogate - 55296) * 1024 + (i - 56320) + 65536;
            
            savedHighSurrogate = '\000';
          }
        }
        writeRaw("&#x" + Integer.toHexString(i).toUpperCase() + ";");
      } else {
        writeRaw(v);
        prev = v;
      }
    }
  }
  
  private void startWord()
  {
    closeTag();
    writeWordStart();
  }
  
  public void writeBoolean(boolean v)
  {
    startWord();
    super.print(v);
    writeWordEnd();
  }
  
  protected void startNumber()
  {
    startWord();
  }
  
  protected void endNumber()
  {
    writeWordEnd();
  }
  
  public void closeTag()
  {
    if ((inStartTag) && (!inAttribute))
    {
      if ((printIndent >= 0) && (indentAttributes))
        endLogicalBlock("");
      writeRaw(">");
      inStartTag = false;
      prev = -3;
    }
    else if (needXMLdecl)
    {

      writeRaw("<?xml version=\"1.0\"?>\n");
      if (printIndent >= 0)
      {
        startLogicalBlock("", "", 2);
      }
      needXMLdecl = false;
      prev = 62;
    }
  }
  
  void setIndentMode()
  {
    Object xmlIndent = indentLoc.get(null);
    String indent = xmlIndent == null ? null : xmlIndent.toString();
    if (indent == null) {
      printIndent = -1;
    } else if (indent.equals("pretty")) {
      printIndent = 0;
    } else if ((indent.equals("always")) || (indent.equals("yes"))) {
      printIndent = 1;
    } else {
      printIndent = -1;
    }
  }
  
  public void startDocument() {
    if (printXMLdecl)
    {


      needXMLdecl = true;
    }
    setIndentMode();
    inDocument = true;
    if ((printIndent >= 0) && (!needXMLdecl)) {
      startLogicalBlock("", "", 2);
    }
  }
  
  public void endDocument() {
    inDocument = false;
    if (printIndent >= 0)
      endLogicalBlock("");
    freshLine();
  }
  

  public void beginEntity(Object base) {}
  

  public void endEntity() {}
  

  protected void writeQName(Object name)
  {
    if ((name instanceof Symbol)) {
      Symbol sname = (Symbol)name;
      String prefix = sname.getPrefix();
      if ((prefix != null) && (prefix.length() > 0)) {
        writeRaw(prefix);
        writeRaw(58);
      }
      writeRaw(sname.getLocalPart());
    }
    else {
      writeRaw(name == null ? "{null name}" : (String)name);
    }
  }
  
  public void writeDoctypeIfDefined(String tagname)
  {
    Object systemIdentifier = doctypeSystem.get(null);
    if (systemIdentifier != null)
    {
      String systemId = systemIdentifier.toString();
      if (systemId.length() > 0)
      {
        Object publicIdentifier = doctypePublic.get(null);
        String publicId = publicIdentifier == null ? null : publicIdentifier.toString();
        
        writeDoctype(tagname, systemId, publicId);
      }
    }
  }
  
  public void writeDoctype(String tagname, String systemId, String publicId)
  {
    writeRaw("<!DOCTYPE ");
    writeRaw(tagname);
    if ((publicId != null) && (publicId.length() > 0)) {
      writeRaw(" PUBLIC \"");
      writeRaw(publicId);
      writeRaw("\" \"");
    } else {
      writeRaw(" SYSTEM \"");
    }
    writeRaw(systemId);
    writeRaw("\">");
    println();
  }
  
  public void startElement(Object type)
  {
    closeTag();
    if (elementNesting == 0)
    {
      if (!inDocument)
        setIndentMode();
      if (prev == -7)
        write(10);
      if (type != null)
        writeDoctypeIfDefined(type.toString());
    }
    if (printIndent >= 0)
    {
      if ((prev == -3) || (prev == -4) || (prev == -5)) {
        writeBreak(printIndent > 0 ? 82 : 78);
      }
      startLogicalBlock("", "", 2);
    }
    writeRaw(60);
    writeQName(type);
    if ((printIndent >= 0) && (indentAttributes))
      startLogicalBlock("", "", 2);
    elementNameStack[elementNesting] = type;
    NamespaceBinding elementBindings = null;
    namespaceSaveStack[(elementNesting++)] = namespaceBindings;
    if ((type instanceof XName))
    {
      elementBindings = namespaceNodes;
      NamespaceBinding join = NamespaceBinding.commonAncestor(elementBindings, namespaceBindings);
      
      int numBindings = elementBindings == null ? 0 : elementBindings.count(join);
      
      NamespaceBinding[] sortedBindings = new NamespaceBinding[numBindings];
      int i = 0;
      boolean sortNamespaces = canonicalize;
      label364:
      for (NamespaceBinding ns = elementBindings; ns != join; ns = next)
      {
        int j = i;
        boolean skip = false;
        String uri = ns.getUri();
        String prefix = ns.getPrefix();
        for (;;) { j--; if (j < 0)
            break;
          NamespaceBinding ns_j = sortedBindings[j];
          
          String prefix_j = ns_j.getPrefix();
          if (prefix == prefix_j) {
            break label364;
          }
          


          if (sortNamespaces)
          {
            if (prefix == null)
              break;
            if ((prefix_j != null) && (prefix.compareTo(prefix_j) <= 0))
              break;
            sortedBindings[(j + 1)] = ns_j;
          } }
        if (sortNamespaces) {
          j++;
        } else
          j = i;
        sortedBindings[j] = ns;
        i++;
      }
      numBindings = i;
      

      i = numBindings; for (;;) { i--; if (i < 0)
          break;
        NamespaceBinding ns = sortedBindings[i];
        String prefix = prefix;
        String uri = uri;
        if ((uri != namespaceBindings.resolve(prefix)) && (
        

          (uri != null) || (prefix == null) || (undeclareNamespaces)))
        {
          writeRaw(32);
          if (prefix == null) {
            writeRaw("xmlns");
          }
          else {
            writeRaw("xmlns:");
            writeRaw(prefix);
          }
          writeRaw("=\"");
          inAttribute = true;
          if (uri != null)
            write(uri);
          inAttribute = false;
          writeRaw(34);
        } }
      if (undeclareNamespaces)
      {



        for (NamespaceBinding ns = namespaceBindings; 
            ns != join; ns = next)
        {
          String prefix = prefix;
          if ((uri != null) && (elementBindings.resolve(prefix) == null))
          {
            writeRaw(32);
            if (prefix == null) {
              writeRaw("xmlns");
            }
            else {
              writeRaw("xmlns:");
              writeRaw(prefix);
            }
            writeRaw("=\"\"");
          }
        }
      }
      namespaceBindings = elementBindings;
    }
    if (elementNesting >= namespaceSaveStack.length)
    {
      NamespaceBinding[] nstmp = new NamespaceBinding[2 * elementNesting];
      System.arraycopy(namespaceSaveStack, 0, nstmp, 0, elementNesting);
      namespaceSaveStack = nstmp;
      Object[] nmtmp = new Object[2 * elementNesting];
      System.arraycopy(elementNameStack, 0, nmtmp, 0, elementNesting);
      elementNameStack = nmtmp;
    }
    
    inStartTag = true;
    
    if (isHtml) {
      String typeName = getHtmlTag(type);
      if (("script".equals(typeName)) || ("style".equals(typeName))) {
        escapeText = false;
      }
    }
  }
  


  public static boolean isHtmlEmptyElementTag(String name)
  {
    int index = "/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/".indexOf(name);
    return (index > 0) && ("/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/".charAt(index - 1) == '/') && ("/area/base/basefont/br/col/command/embed/frame/hr/img/input/isindex/keygen/link/meta/para/param/source/track/wbr/".charAt(index + name.length()) == '/');
  }
  

  protected String getHtmlTag(Object type)
  {
    if ((type instanceof Symbol))
    {
      Symbol sym = (Symbol)type;
      String uri = sym.getNamespaceURI();
      if ((uri == "http://www.w3.org/1999/xhtml") || ((isHtmlOrXhtml) && (uri == "")))
      {
        return sym.getLocalPart();
      }
    } else if (isHtmlOrXhtml) {
      return type.toString(); }
    return null;
  }
  
  public void endElement()
  {
    if (useEmptyElementTag == 0)
      closeTag();
    Object type = elementNameStack[(elementNesting - 1)];
    

    String typeName = getHtmlTag(type);
    
    if (inStartTag)
    {
      if ((printIndent >= 0) && (indentAttributes))
      {
        endLogicalBlock("");
      }
      String end = null;
      boolean isEmpty = (typeName != null) && (isHtmlEmptyElementTag(typeName));
      if ((useEmptyElementTag == 0) || ((typeName != null) && (!isEmpty)))
      {

        if ((type instanceof Symbol))
        {
          Symbol sym = (Symbol)type;
          String prefix = sym.getPrefix();
          String uri = sym.getNamespaceURI();
          String local = sym.getLocalName();
          if (prefix != "") {
            end = "></" + prefix + ":" + local + ">";
          } else if ((uri == "") || (uri == null) || (uri == namespaceBindings.resolve(null)))
          {
            end = "></" + local + ">"; }
        }
      }
      if (end == null)
        end = useEmptyElementTag == 2 ? " />" : (isEmpty) && (isHtml) ? ">" : "/>";
      writeRaw(end);
      inStartTag = false;
    }
    else
    {
      if (printIndent >= 0)
      {
        setIndentation(0, false);
        if (prev == -4) {
          writeBreak(printIndent > 0 ? 82 : 78);
        }
      }
      writeRaw("</");
      writeQName(type);
      writeRaw(">");
    }
    if (printIndent >= 0)
    {
      endLogicalBlock("");
    }
    prev = -4;
    if ((isHtml) && (typeName != null) && (!escapeText) && (("script".equals(typeName)) || ("style".equals(typeName))))
    {
      escapeText = true;
    }
    namespaceBindings = namespaceSaveStack[(--elementNesting)];
    namespaceSaveStack[elementNesting] = null;
    elementNameStack[elementNesting] = null;
  }
  


  public void startAttribute(Object attrType)
  {
    if ((!inStartTag) && (!extended))
      error("attribute not in element", "SENR0001");
    if (inAttribute)
      writeRaw(34);
    inAttribute = true;
    writeRaw(32);
    if (printIndent >= 0)
      writeBreakFill();
    writeRaw(attrType == null ? "{null name}" : attrType.toString());
    writeRaw("=\"");
    prev = 32;
  }
  
  public void endAttribute()
  {
    if (inAttribute)
    {
      if (prev != -6)
      {
        writeRaw(34);
        inAttribute = false;
      }
      prev = 32;
    }
  }
  
  public void writeDouble(double d)
  {
    startWord();
    writeRaw(formatDouble(d));
  }
  
  public void writeFloat(float f)
  {
    startWord();
    writeRaw(formatFloat(f));
  }
  

  public static String formatDouble(double d)
  {
    if (Double.isNaN(d))
      return "NaN";
    boolean neg = d < 0.0D;
    if (Double.isInfinite(d))
      return neg ? "-INF" : "INF";
    double dabs = neg ? -d : d;
    String dstr = Double.toString(d);
    

    if (((dabs >= 1000000.0D) || (dabs < 1.0E-6D)) && (dabs != 0.0D)) {
      return RealNum.toStringScientific(dstr);
    }
    return formatDecimal(RealNum.toStringDecimal(dstr));
  }
  

  public static String formatFloat(float f)
  {
    if (Float.isNaN(f))
      return "NaN";
    boolean neg = f < 0.0F;
    if (Float.isInfinite(f))
      return neg ? "-INF" : "INF";
    float fabs = neg ? -f : f;
    String fstr = Float.toString(f);
    

    if (((fabs >= 1000000.0F) || (fabs < 1.0E-6D)) && (fabs != 0.0D)) {
      return RealNum.toStringScientific(fstr);
    }
    return formatDecimal(RealNum.toStringDecimal(fstr));
  }
  






  public static String formatDecimal(BigDecimal dec)
  {
    return formatDecimal(dec.toPlainString());
  }
  



  static String formatDecimal(String str)
  {
    int dot = str.indexOf('.');
    if (dot >= 0)
    {
      int len = str.length();
      int pos = len;
      for (;;) {
        char ch = str.charAt(--pos);
        if (ch != '0')
        {
          if (ch != '.')
            pos++;
          return pos == len ? str : str.substring(0, pos);
        }
      }
    }
    return str;
  }
  
  public void print(Object v)
  {
    if ((v instanceof BigDecimal)) {
      v = formatDecimal((BigDecimal)v);
    } else if (((v instanceof Double)) || ((v instanceof DFloNum))) {
      v = formatDouble(((Number)v).doubleValue());
    } else if ((v instanceof Float))
      v = formatFloat(((Float)v).floatValue());
    write(v == null ? "(null)" : v.toString());
  }
  
  public void writeObject(Object v)
  {
    if ((v instanceof SeqPosition))
    {
      clearWordEnd();
      SeqPosition pos = (SeqPosition)v;
      sequence.consumeNext(ipos, this);
      if ((sequence instanceof NodeTree))
        prev = 45;
      return;
    }
    if ((v instanceof Consumable))
    {
      ((Consumable)v).consume(this);
      return;
    }
    if ((v instanceof Keyword))
    {
      startAttribute(((Keyword)v).getName());
      prev = -6;
      return;
    }
    closeTag();
    if ((v instanceof UnescapedData))
    {
      clearWordEnd();
      writeRaw(((UnescapedData)v).getData());
      prev = 45;
    }
    else if ((v instanceof Char)) {
      Char.print(((Char)v).intValue(), this);
    }
    else {
      startWord();
      prev = 32;
      print(v);
      writeWordEnd();
      prev = -2;
    }
  }
  






  public boolean ignoring()
  {
    return false;
  }
  
  public void write(String str, int start, int length) {
    if (length > 0) {
      closeTag();
      int limit = start + length;
      int count = 0;
      while (start < limit) {
        char c = str.charAt(start++);
        if ((mustHexEscape(c)) || (inComment > 0 ? (c != '-') || (inComment != 2) : (c == '<') || (c == '>') || (c == '&') || ((inAttribute) && ((c == '"') || (c < ' ')))))
        {


          if (count > 0)
            writeRaw(str, start - 1 - count, count);
          write(c);
          count = 0;
        }
        else {
          count++;
        } }
      if (count > 0)
        writeRaw(str, limit - count, count);
    }
    prev = 45;
  }
  
  public void write(char[] buf, int off, int len)
  {
    if (len > 0)
    {
      closeTag();
      int limit = off + len;
      int count = 0;
      while (off < limit)
      {
        char c = buf[(off++)];
        if ((mustHexEscape(c)) || (inComment > 0 ? (c != '-') || (inComment != 2) : (c == '<') || (c == '>') || (c == '&') || ((inAttribute) && ((c == '"') || (c < ' ')))))
        {



          if (count > 0)
            writeRaw(buf, off - 1 - count, count);
          write(c);
          count = 0;
        }
        else {
          count++;
        } }
      if (count > 0)
        writeRaw(buf, limit - count, count);
    }
    prev = 45;
  }
  
  public void writePosition(AbstractSequence seq, int ipos)
  {
    seq.consumeNext(ipos, this);
  }
  

  public void writeBaseUri(Object uri) {}
  

  public void beginComment()
  {
    closeTag();
    if (printIndent >= 0)
    {
      if ((prev == -3) || (prev == -4) || (prev == -5)) {
        writeBreak(printIndent > 0 ? 82 : 78);
      }
    }
    writeRaw("<!--");
    inComment = 1;
  }
  
  public void endComment()
  {
    writeRaw("-->");
    prev = -5;
    inComment = 0;
  }
  
  public void writeComment(String chars)
  {
    beginComment();
    write(chars);
    endComment();
  }
  
  public void writeComment(char[] chars, int offset, int length)
  {
    beginComment();
    write(chars, offset, length);
    endComment();
  }
  
  public void writeCDATA(char[] chars, int offset, int length)
  {
    if (canonicalizeCDATA)
    {
      write(chars, offset, length);
      return;
    }
    closeTag();
    writeRaw("<![CDATA[");
    int limit = offset + length;
    

    for (int i = offset; i < limit - 2; i++)
    {
      if ((chars[i] == ']') && (chars[(i + 1)] == ']') && (chars[(i + 2)] == '>'))
      {
        if (i > offset)
          writeRaw(chars, offset, i - offset);
        writeRaw("]]]><![CDATA[]>");
        offset = i + 3;
        length = limit - offset;
        i += 2;
      }
    }
    writeRaw(chars, offset, length);
    writeRaw("]]>");
    prev = 62;
  }
  

  public void writeProcessingInstruction(String target, char[] content, int offset, int length)
  {
    if ("xml".equals(target))
      needXMLdecl = false;
    closeTag();
    writeRaw("<?");
    writeRaw(target);
    writeRaw(32);
    writeRaw(content, offset, length);
    writeRaw("?>");
    prev = -7;
  }
  
  public void writePosition(SeqPosition position)
  {
    sequence.consumeNext(ipos, this);
  }
  
  public void error(String msg, String code)
  {
    throw new RuntimeException("serialization error: " + msg + " [" + code + ']');
  }
}
