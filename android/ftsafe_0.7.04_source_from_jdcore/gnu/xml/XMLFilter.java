package gnu.xml;

import gnu.expr.Keyword;
import gnu.kawa.io.InPort;
import gnu.kawa.sax.ContentConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.CharSeq;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.lists.UnescapedData;
import gnu.lists.XConsumer;
import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;














public class XMLFilter
  implements DocumentHandler, ContentHandler, SourceLocator, XConsumer, PositionConsumer
{
  TreeList tlist;
  public Consumer out;
  private Consumer base;
  public static final int COPY_NAMESPACES_PRESERVE = 1;
  public static final int COPY_NAMESPACES_INHERIT = 2;
  public transient int copyNamespacesMode = 1;
  

  Object[] workStack;
  
  NamespaceBinding namespaceBindings;
  
  private SourceMessages messages;
  
  SourceLocator locator;
  
  InPort in;
  
  protected int nesting;
  

  public void setSourceLocator(InPort in)
  {
    this.in = in;locator = this; }
  
  public void setSourceLocator(SourceLocator locator) { this.locator = locator; }
  
  public void setMessages(SourceMessages messages) { this.messages = messages; }
  



  int previous = 0;
  


  private static final int SAW_KEYWORD = 1;
  


  private static final int SAW_WORD = 2;
  


  protected int stringizingLevel;
  

  protected int stringizingElementNesting = -1;
  



  protected int ignoringLevel;
  


  int[] startIndexes = null;
  



  int attrCount = -1;
  

  boolean inStartTag;
  

  String attrLocalName;
  

  String attrPrefix;
  

  String currentNamespacePrefix;
  

  public boolean namespacePrefixes = false;
  









  MappingInfo[] mappingTable = new MappingInfo[''];
  int mappingTableMask = mappingTable.length - 1;
  


  boolean mismatchReported;
  



  public NamespaceBinding findNamespaceBinding(String prefix, String uri, NamespaceBinding oldBindings)
  {
    int hash = uri == null ? 0 : uri.hashCode();
    if (prefix != null)
      hash ^= prefix.hashCode();
    int bucket = hash & mappingTableMask;
    MappingInfo info = mappingTable[bucket];
    for (;; info = nextInBucket)
    {
      if (info == null)
      {
        info = new MappingInfo();
        nextInBucket = mappingTable[bucket];
        mappingTable[bucket] = info;
        tagHash = hash;
        prefix = prefix;
        local = uri;
        uri = uri;
        if (uri == "")
          uri = null;
        NamespaceBinding namespaces = new NamespaceBinding(prefix, uri, oldBindings);
        
        namespaces = namespaces;
        return namespaces;
      }
      NamespaceBinding namespaces;
      if ((tagHash == hash) && (prefix == prefix) && ((namespaces = namespaces) != null) && (namespaces.getNext() == namespaceBindings) && (namespaces.getPrefix() == prefix) && (uri == uri))
      {





        return namespaces;
      }
    }
  }
  










  public MappingInfo lookupNamespaceBinding(String prefix, char[] uriChars, int uriStart, int uriLength, int uriHash, NamespaceBinding oldBindings)
  {
    int hash = prefix == null ? uriHash : prefix.hashCode() ^ uriHash;
    




    int bucket = hash & mappingTableMask;
    MappingInfo info = mappingTable[bucket];
    for (;; info = nextInBucket)
    {
      if (info == null)
      {
        info = new MappingInfo();
        nextInBucket = mappingTable[bucket];
        mappingTable[bucket] = info;
        String uri = new String(uriChars, uriStart, uriLength).intern();
        



        tagHash = hash;
        prefix = prefix;
        local = uri;
        uri = uri;
        if (uri == "")
          uri = null;
        NamespaceBinding namespaces = new NamespaceBinding(prefix, uri, oldBindings);
        
        namespaces = namespaces;
        return info;
      }
      NamespaceBinding namespaces;
      if ((tagHash == hash) && (prefix == prefix) && ((namespaces = namespaces) != null) && (namespaces.getNext() == namespaceBindings) && (namespaces.getPrefix() == prefix) && (MappingInfo.equals(uri, uriChars, uriStart, uriLength)))
      {





        return info;
      }
    }
  }
  
  public void endAttribute()
  {
    if (attrLocalName == null)
      return;
    if (previous == 1)
    {
      previous = 0;
      return;
    }
    if (stringizingElementNesting >= 0)
      ignoringLevel -= 1;
    if (--stringizingLevel == 0)
    {
      if ((attrLocalName == "id") && (attrPrefix == "xml"))
      {

        int valStart = startIndexes[(attrCount - 1)] + 5;
        
        int valEnd = tlist.gapStart;
        char[] data = tlist.data;
        int i = valStart;
        
        while (i < valEnd)
        {



          char datum = data[(i++)];
          if (((datum & 0xFFFF) > 40959) || (datum == '\t') || (datum == '\r') || (datum == '\n') || ((datum == ' ') && ((i == valEnd) || (data[i] == ' '))))
          {








            StringBuffer sbuf = new StringBuffer();
            tlist.stringValue(valStart, valEnd, sbuf);
            tlist.gapStart = valStart;
            tlist.write(TextUtils.replaceWhitespace(sbuf.toString(), true));
            
            break;
          }
        }
      }
      
      attrLocalName = null;
      attrPrefix = null;
      if ((currentNamespacePrefix == null) || (namespacePrefixes))
        tlist.endAttribute();
      if (currentNamespacePrefix != null)
      {

        int attrStart = startIndexes[(attrCount - 1)];
        int uriStart = attrStart;
        int uriEnd = tlist.gapStart;
        int uriLength = uriEnd - uriStart;
        char[] data = tlist.data;
        



        int uriHash = 0;
        for (int i = uriStart; i < uriEnd; i++)
        {
          char datum = data[i];
          if ((datum & 0xFFFF) > 40959)
          {
            StringBuffer sbuf = new StringBuffer();
            tlist.stringValue(uriStart, uriEnd, sbuf);
            uriHash = sbuf.hashCode();
            uriStart = 0;
            uriEnd = uriLength = sbuf.length();
            data = new char[sbuf.length()];
            sbuf.getChars(0, uriEnd, data, 0);
            break;
          }
          uriHash = 31 * uriHash + datum;
        }
        tlist.gapStart = attrStart;
        
        String prefix = currentNamespacePrefix == "" ? null : currentNamespacePrefix;
        
        MappingInfo info = lookupNamespaceBinding(prefix, data, uriStart, uriLength, uriHash, namespaceBindings);
        

        namespaceBindings = namespaces;
        
        currentNamespacePrefix = null;
      }
    }
  }
  
  private String resolve(String prefix, boolean isAttribute)
  {
    if ((isAttribute) && (prefix == null))
      return "";
    String uri = namespaceBindings.resolve(prefix);
    if (uri != null)
      return uri;
    if (prefix != null)
      error('e', "unknown namespace prefix '" + prefix + '\'');
    return "";
  }
  
  void closeStartTag()
  {
    if ((attrCount < 0) || (stringizingLevel > 0))
      return;
    inStartTag = false;
    previous = 0;
    
    if (attrLocalName != null)
      endAttribute();
    NamespaceBinding outer = nesting == 0 ? NamespaceBinding.predefinedXML : (NamespaceBinding)workStack[(nesting - 2)];
    

    NamespaceBinding bindings = namespaceBindings;
    


    for (int i = 0; i <= attrCount; i++)
    {
      Object saved = workStack[(nesting + i - 1)];
      if ((saved instanceof Symbol))
      {
        Symbol sym = (Symbol)saved;
        String prefix = sym.getPrefix();
        if (prefix == "")
          prefix = null;
        String uri = sym.getNamespaceURI();
        if (uri == "")
          uri = null;
        if ((i <= 0) || (prefix != null) || (uri != null))
        {
          boolean isOuter = false;
          for (NamespaceBinding ns = bindings;; ns = next)
          {
            if (ns == outer)
              isOuter = true;
            if (ns == null)
            {
              if ((prefix == null) && (uri == null)) break;
              bindings = findNamespaceBinding(prefix, uri, bindings); break;
            }
            
            if (prefix == prefix)
            {
              if (uri == uri)
                break;
              if (isOuter) {
                bindings = findNamespaceBinding(prefix, uri, bindings); break;
              }
              


              NamespaceBinding ns2 = bindings;
              for (;; ns2 = next)
              {
                if (ns2 == null)
                {

                  for (int j = 1;; j++)
                  {
                    String nprefix = ("_ns_" + j).intern();
                    if (bindings.resolve(nprefix) == null) {
                      break;
                    }
                  }
                }
                else if (uri == uri)
                {
                  String nprefix = prefix;
                  if (bindings.resolve(nprefix) == uri)
                    break;
                } }
              String nprefix;
              bindings = findNamespaceBinding(nprefix, uri, bindings);
              String local = sym.getLocalName();
              if (uri == null)
                uri = "";
              workStack[(nesting + i - 1)] = Symbol.make(uri, local, nprefix);
              
              break;
            }
          }
        }
      }
    }
    


    for (int i = 0; i <= attrCount; i++)
    {
      Object saved = workStack[(nesting + i - 1)];
      
      boolean isNsNode = false;
      String uri;
      String local; MappingInfo info; if (((saved instanceof MappingInfo)) || (out == tlist)) { String uri;
        String prefix;
        String local; String uri; if ((saved instanceof MappingInfo))
        {
          MappingInfo info = (MappingInfo)saved;
          String prefix = prefix;
          String local = local;
          String uri; if ((i > 0) && (((prefix == null) && (local == "xmlns")) || (prefix == "xmlns")))
          {


            isNsNode = true;
            uri = "(namespace-node)";
          }
          else {
            uri = resolve(prefix, i > 0);
          }
        } else { if (!(saved instanceof Symbol)) {
            throw new ClassCastException("expected element start tag (a symbol) - instead got a " + saved.getClass().getName());
          }
          
          Symbol symbol = (Symbol)saved;
          info = lookupTag(symbol);
          prefix = prefix;
          local = local;
          uri = symbol.getNamespaceURI();
        }
        int hash = tagHash;
        int bucket = hash & mappingTableMask;
        
        MappingInfo info = mappingTable[bucket];
        MappingInfo tagMatch = null;
        for (;; 
            info = nextInBucket)
        {
          if (info == null)
          {
            info = tagMatch;
            info = new MappingInfo();
            tagHash = hash;
            prefix = prefix;
            local = local;
            nextInBucket = mappingTable[bucket];
            mappingTable[bucket] = info;
            uri = uri;
            qname = Symbol.make(uri, local, prefix);
            if (i != 0)
              break;
            XName xname = new XName(qname, bindings);
            Object type = xname;
            type = xname;
            namespaces = bindings;
            break;
          }
          
          if ((tagHash == hash) && (local == local) && (prefix == prefix))
          {


            if (uri == null)
            {
              uri = uri;
              qname = Symbol.make(uri, local, prefix);
            } else {
              if (uri != uri)
                continue;
              if (qname == null)
                qname = Symbol.make(uri, local, prefix); }
            if (i == 0)
            {
              if ((namespaces == bindings) || (namespaces == null))
              {

                Object type = type;
                namespaces = bindings;
                if (type != null)
                  break;
                XName xname = new XName(qname, bindings);
                type = xname;
                type = xname;
                break;
              }
              
            }
            else
            {
              Object type = qname;
              break;
            }
          }
        }
        workStack[(nesting + i - 1)] = info;
      }
      else
      {
        Symbol sym = (Symbol)saved;
        uri = sym.getNamespaceURI();
        local = sym.getLocalName();
        info = null;
      }
      

      for (int j = 1; j < i; j++)
      {
        Object other = workStack[(nesting + j - 1)];
        Symbol osym;
        Symbol osym; if ((other instanceof Symbol)) {
          osym = (Symbol)other;
        } else { if (!(other instanceof MappingInfo)) continue;
          osym = qname;
        }
        
        if ((local == osym.getLocalPart()) && (uri == osym.getNamespaceURI()))
        {

          Object tag = workStack[(nesting - 1)];
          if ((tag instanceof MappingInfo))
            tag = qname;
          error('e', duplicateAttributeMessage(osym, tag));
        }
      }
      
      if (out == tlist)
      {
        Object type = i == 0 ? type : qname;
        int index = index;
        if ((index <= 0) || (tlist.objects[index] != type))
        {

          index = tlist.find(type);
          index = index;
        }
        if (i == 0) {
          tlist.setElementName(tlist.gapEnd, index);
        } else if ((!isNsNode) || (namespacePrefixes)) {
          tlist.setAttributeName(startIndexes[(i - 1)], index);
        }
      }
      else {
        Object type = i == 0 ? type : info == null ? saved : qname;
        
        if (i == 0) {
          out.startElement(type);
        } else if ((!isNsNode) || (namespacePrefixes))
        {
          out.startAttribute(type);
          int start = startIndexes[(i - 1)];
          int end = i < attrCount ? startIndexes[i] : tlist.gapStart;
          tlist.consumeIRange(start + 5, end - 1, out);
          

          out.endAttribute();
        }
      }
    }
    

    if ((out instanceof ContentConsumer)) {
      ((ContentConsumer)out).endStartTag();
    }
    
    for (int i = 1; i <= attrCount; i++)
      workStack[(nesting + i - 1)] = null;
    if (out != tlist)
    {
      base = out;
      
      tlist.clear();
    }
    attrCount = -1;
  }
  
  protected boolean checkWriteAtomic()
  {
    previous = 0;
    if (ignoringLevel > 0)
      return false;
    closeStartTag();
    return true;
  }
  
  public void write(int v)
  {
    if (checkWriteAtomic()) {
      base.write(v);
    }
  }
  
  public void writeBoolean(boolean v) {
    if (checkWriteAtomic()) {
      base.writeBoolean(v);
    }
  }
  
  public void writeFloat(float v) {
    if (checkWriteAtomic()) {
      base.writeFloat(v);
    }
  }
  
  public void writeDouble(double v) {
    if (checkWriteAtomic()) {
      base.writeDouble(v);
    }
  }
  
  public void writeInt(int v) {
    if (checkWriteAtomic()) {
      base.writeInt(v);
    }
  }
  
  public void writeLong(long v) {
    if (checkWriteAtomic()) {
      base.writeLong(v);
    }
  }
  
  public void writeDocumentUri(Object uri) {
    if ((nesting == 2) && ((base instanceof TreeList))) {
      ((TreeList)base).writeDocumentUri(uri);
    }
  }
  
  public void writePosition(SeqPosition position) {
    writePosition(sequence, ipos);
  }
  
  public void writePosition(AbstractSequence seq, int ipos)
  {
    if (ignoringLevel > 0)
      return;
    if ((stringizingLevel > 0) && (previous == 2))
    {
      if (stringizingElementNesting < 0)
        write(32);
      previous = 0;
    }
    seq.consumeNext(ipos, this);
    if ((stringizingLevel > 0) && (stringizingElementNesting < 0)) {
      previous = 2;
    }
  }
  
  public void writeObject(Object v)
  {
    if (ignoringLevel > 0)
      return;
    if ((v instanceof SeqPosition))
    {
      SeqPosition pos = (SeqPosition)v;
      writePosition(sequence, pos.getPos());
    }
    else if ((v instanceof TreeList)) {
      ((TreeList)v).consume(this);
    } else if (((v instanceof List)) && (!(v instanceof CharSeq)))
    {
      List seq = (List)v;
      Iterator it = seq.iterator();
      boolean wasAtomic = false;
      for (int i = 0; it.hasNext(); i++) {
        writeObject(it.next());
      }
    } else if ((v instanceof Keyword))
    {
      Keyword k = (Keyword)v;
      startAttribute(k.asSymbol());
      previous = 1;
    }
    else
    {
      boolean inImplicitAttr = previous == 1;
      if (!inImplicitAttr)
        closeStartTag();
      if ((v instanceof UnescapedData))
      {
        base.writeObject(v);
        previous = 0;
      }
      else
      {
        if (previous == 2)
          write(32);
        TextUtils.textValue(v, this);
        previous = 2;
      }
      if (inImplicitAttr) {
        endAttribute();
      }
    }
  }
  
  public XMLFilter(Consumer out) {
    base = out;
    this.out = out;
    if ((out instanceof NodeTree)) {
      tlist = ((NodeTree)out);
    } else {
      tlist = new TreeList();
    }
    namespaceBindings = NamespaceBinding.predefinedXML;
  }
  

  public void write(char[] data, int start, int length)
  {
    if (length == 0) {
      writeJoiner();
    } else if (checkWriteAtomic()) {
      base.write(data, start, length);
    }
  }
  
  public void write(String str) {
    write(str, 0, str.length());
  }
  




  public void write(CharSequence str, int start, int length)
  {
    if (length == 0) {
      writeJoiner();
    } else if (checkWriteAtomic()) {
      base.write(str, start, length);
    }
  }
  
  final boolean inElement() {
    int i = nesting;
    
    while ((i > 0) && (workStack[(i - 1)] == null))
      i -= 2;
    return i != 0;
  }
  
  public void linefeedFromParser()
  {
    if ((inElement()) && (checkWriteAtomic())) {
      base.write(10);
    }
  }
  
  public void textFromParser(char[] data, int start, int length)
  {
    if (!inElement())
    {
      for (int i = 0;; i++)
      {
        if (i == length)
          return;
        if (!Character.isWhitespace(data[(start + i)]))
        {
          error('e', "text at document level");
          break;
        }
      }
    }
    else if (length > 0)
    {
      if (!checkWriteAtomic()) {
        return;
      }
      base.write(data, start, length);
    }
  }
  
  protected void writeJoiner()
  {
    previous = 0;
    if ((ignoringLevel == 0) && 
      ((base instanceof TreeList))) {
      ((TreeList)base).writeJoiner();
    }
  }
  



  public void writeCDATA(char[] data, int start, int length)
  {
    if (checkWriteAtomic())
    {
      if ((base instanceof XConsumer)) {
        ((XConsumer)base).writeCDATA(data, start, length);
      } else {
        write(data, start, length);
      }
    }
  }
  
  protected void startElementCommon() {
    closeStartTag();
    if (stringizingLevel == 0)
    {
      ensureSpaceInWorkStack(nesting);
      workStack[nesting] = namespaceBindings;
      tlist.startElement(0);
      base = tlist;
      attrCount = 0;
    }
    else
    {
      if ((previous == 2) && (stringizingElementNesting < 0))
        write(32);
      previous = 0;
      if (stringizingElementNesting < 0)
        stringizingElementNesting = nesting;
    }
    nesting += 2;
  }
  

  public void emitStartElement(char[] data, int start, int count)
  {
    closeStartTag();
    MappingInfo info = lookupTag(data, start, count);
    startElementCommon();
    ensureSpaceInWorkStack(nesting - 1);
    workStack[(nesting - 1)] = info;
  }
  
  public void startElement(Object type)
  {
    startElementCommon();
    if (stringizingLevel == 0)
    {
      ensureSpaceInWorkStack(nesting - 1);
      workStack[(nesting - 1)] = type;
      if (copyNamespacesMode == 0) {
        namespaceBindings = NamespaceBinding.predefinedXML;
      } else if ((copyNamespacesMode == 1) || (nesting == 2))
      {
        namespaceBindings = ((type instanceof XName) ? ((XName)type).getNamespaceNodes() : NamespaceBinding.predefinedXML);


      }
      else
      {

        for (int i = 2;; i += 2)
        {
          if (i == nesting)
          {
            NamespaceBinding inherited = null;
            break;
          }
          if (workStack[(i + 1)] != null)
          {
            NamespaceBinding inherited = (NamespaceBinding)workStack[i];
            break;
          } }
        NamespaceBinding inherited;
        if (inherited == null)
        {

          namespaceBindings = ((type instanceof XName) ? ((XName)type).getNamespaceNodes() : NamespaceBinding.predefinedXML);


        }
        else if (copyNamespacesMode == 2) {
          namespaceBindings = inherited;
        } else if ((type instanceof XName))
        {
          NamespaceBinding preserved = ((XName)type).getNamespaceNodes();
          NamespaceBinding join = NamespaceBinding.commonAncestor(inherited, preserved);
          if (join == inherited) {
            namespaceBindings = preserved;
          } else {
            namespaceBindings = mergeHelper(inherited, preserved);
          }
        } else {
          namespaceBindings = inherited;
        }
      }
    }
  }
  
  private NamespaceBinding mergeHelper(NamespaceBinding list, NamespaceBinding node)
  {
    if (node == NamespaceBinding.predefinedXML)
      return list;
    list = mergeHelper(list, next);
    String uri = uri;
    if (list == null)
    {
      if (uri == null)
        return list;
      list = NamespaceBinding.predefinedXML;
    }
    String prefix = prefix;
    String found = list.resolve(prefix);
    if (found == null ? uri == null : found.equals(uri))
      return list;
    return findNamespaceBinding(prefix, uri, list);
  }
  
  private boolean startAttributeCommon()
  {
    if (stringizingElementNesting >= 0)
      ignoringLevel += 1;
    if (stringizingLevel++ > 0) {
      return false;
    }
    if (attrCount < 0)
      attrCount = 0;
    ensureSpaceInWorkStack(nesting + attrCount);
    ensureSpaceInStartIndexes(attrCount);
    startIndexes[attrCount] = tlist.gapStart;
    attrCount += 1;
    return true;
  }
  
  public void startAttribute(Object attrType) {
    previous = 0;
    Symbol sym = (Symbol)attrType;
    String local = sym.getLocalPart();
    attrLocalName = local;
    attrPrefix = sym.getPrefix();
    String uri = sym.getNamespaceURI();
    if ((uri == "http://www.w3.org/2000/xmlns/") || ((uri == "") && (local == "xmlns")))
    {
      error('e', "attribute name cannot be 'xmlns' or in xmlns namespace");
    }
    if ((nesting == 2) && (workStack[1] == null) && (stringizingLevel == 0))
      error('e', "attribute not allowed at document level");
    if ((attrCount < 0) && (nesting > 0))
      error('e', "attribute '" + attrType + "' follows non-attribute content");
    if (startAttributeCommon()) {
      workStack[(nesting + attrCount - 1)] = attrType;
      if (nesting == 0) {
        base.startAttribute(attrType);
      } else {
        tlist.startAttribute(0);
      }
    }
  }
  




  public void emitStartAttribute(char[] data, int start, int count)
  {
    if (attrLocalName != null)
      endAttribute();
    if (!startAttributeCommon()) {
      return;
    }
    MappingInfo info = lookupTag(data, start, count);
    workStack[(nesting + attrCount - 1)] = info;
    String prefix = prefix;
    String local = local;
    attrLocalName = local;
    attrPrefix = prefix;
    if (prefix != null)
    {
      if (prefix == "xmlns")
      {
        currentNamespacePrefix = local;
      }
      

    }
    else if ((local == "xmlns") && (prefix == null))
    {
      currentNamespacePrefix = "";
    }
    
    if ((currentNamespacePrefix == null) || (namespacePrefixes)) {
      tlist.startAttribute(0);
    }
  }
  

  public void emitEndAttributes()
  {
    if (attrLocalName != null)
      endAttribute();
    closeStartTag();
  }
  



  public void emitEndElement(char[] data, int start, int length)
  {
    if (attrLocalName != null)
    {
      error('e', "unclosed attribute");
      endAttribute();
    }
    if (!inElement())
    {
      error('e', "unmatched end element");
      return;
    }
    if (data != null)
    {
      MappingInfo info = lookupTag(data, start, length);
      Object old = workStack[(nesting - 1)];
      if (((old instanceof MappingInfo)) && (!mismatchReported))
      {
        MappingInfo mold = (MappingInfo)old;
        if ((local != local) || (prefix != prefix))
        {
          StringBuffer sbuf = new StringBuffer("</");
          sbuf.append(data, start, length);
          sbuf.append("> matching <");
          String oldPrefix = prefix;
          if (oldPrefix != null)
          {
            sbuf.append(oldPrefix);
            sbuf.append(':');
          }
          sbuf.append(local);
          sbuf.append('>');
          error('e', sbuf.toString());
          mismatchReported = true;
        }
      }
    }
    closeStartTag();
    if (nesting <= 0)
      return;
    endElement();
  }
  
  public void endElement()
  {
    closeStartTag();
    nesting -= 2;
    previous = 0;
    if (stringizingLevel == 0)
    {
      namespaceBindings = ((NamespaceBinding)workStack[nesting]);
      workStack[nesting] = null;
      workStack[(nesting + 1)] = null;
      base.endElement();
    }
    else if (stringizingElementNesting == nesting)
    {
      stringizingElementNesting = -1;
      previous = 2;
    }
  }
  











  public void emitEntityReference(char[] name, int start, int length)
  {
    char c0 = name[start];
    char ch = '?';
    if ((length == 2) && (name[(start + 1)] == 't'))
    {

      if (c0 == 'l') {
        ch = '<';
      } else if (c0 == 'g') {
        ch = '>';
      }
    } else if (length == 3)
    {
      if ((c0 == 'a') && (name[(start + 1)] == 'm') && (name[(start + 2)] == 'p')) {
        ch = '&';
      }
    } else if (length == 4)
    {
      char c1 = name[(start + 1)];
      char c2 = name[(start + 2)];
      char c3 = name[(start + 3)];
      if ((c0 == 'q') && (c1 == 'u') && (c2 == 'o') && (c3 == 't')) {
        ch = '"';
      } else if ((c0 == 'a') && (c1 == 'p') && (c2 == 'o') && (c3 == 's'))
        ch = '\'';
    }
    write(ch);
  }
  



  public void emitCharacterReference(int value, char[] name, int start, int length)
  {
    if (value >= 65536) {
      Char.print(value, this);
    } else {
      write(value);
    }
  }
  
  protected void checkValidComment(char[] chars, int offset, int length) {
    int i = length;
    boolean sawHyphen = true;
    for (;;) { i--; if (i < 0)
        break;
      boolean curHyphen = chars[(offset + i)] == '-';
      if ((sawHyphen) && (curHyphen))
      {
        error('e', "consecutive or final hyphen in XML comment");
        break;
      }
      sawHyphen = curHyphen;
    }
  }
  



  public void writeComment(char[] chars, int start, int length)
  {
    checkValidComment(chars, start, length);
    commentFromParser(chars, start, length);
  }
  



  public void commentFromParser(char[] chars, int start, int length)
  {
    if (stringizingLevel == 0)
    {
      closeStartTag();
      if ((base instanceof XConsumer)) {
        ((XConsumer)base).writeComment(chars, start, length);
      }
    } else if (stringizingElementNesting < 0) {
      base.write(chars, start, length);
    }
  }
  
  public void writeProcessingInstruction(String target, char[] content, int offset, int length)
  {
    target = TextUtils.replaceWhitespace(target, true);
    int i = offset + length; for (;;) { i--; if (i < offset)
        break;
      char ch = content[i];
      while (ch == '>') { i--; if (i >= offset)
        {
          ch = content[i];
          if (ch == '?')
          {
            error('e', "'?>' is not allowed in a processing-instruction");
          }
        }
      }
    }
    
    if ("xml".equalsIgnoreCase(target)) {
      error('e', "processing-instruction target may not be 'xml' (ignoring case)");
    }
    if (!XName.isNCName(target)) {
      error('e', "processing-instruction target '" + target + "' is not a valid Name");
    }
    
    processingInstructionCommon(target, content, offset, length);
  }
  

  void processingInstructionCommon(String target, char[] content, int offset, int length)
  {
    if (stringizingLevel == 0)
    {
      closeStartTag();
      if ((base instanceof XConsumer)) {
        ((XConsumer)base).writeProcessingInstruction(target, content, offset, length);
      }
    }
    else if (stringizingElementNesting < 0) {
      base.write(content, offset, length);
    }
  }
  



  public void processingInstructionFromParser(char[] buffer, int tstart, int tlength, int dstart, int dlength)
  {
    if ((tlength == 3) && (!inElement()) && (buffer[tstart] == 'x') && (buffer[(tstart + 1)] == 'm') && (buffer[(tstart + 2)] == 'l'))
    {


      return; }
    String target = new String(buffer, tstart, tlength);
    processingInstructionCommon(target, buffer, dstart, dlength);
  }
  
  public void startDocument()
  {
    closeStartTag();
    if (stringizingLevel > 0) {
      writeJoiner();
    }
    else
    {
      if (nesting == 0) {
        base.startDocument();
      } else
        writeJoiner();
      ensureSpaceInWorkStack(nesting);
      workStack[nesting] = namespaceBindings;
      


      workStack[(nesting + 1)] = null;
      nesting += 2;
    }
  }
  
  public void endDocument()
  {
    if (stringizingLevel > 0)
    {
      writeJoiner();
      return;
    }
    nesting -= 2;
    namespaceBindings = ((NamespaceBinding)workStack[nesting]);
    workStack[nesting] = null;
    workStack[(nesting + 1)] = null;
    if (nesting == 0) {
      base.endDocument();
    } else {
      writeJoiner();
    }
  }
  






  public void emitDoctypeDecl(char[] buffer, int target, int tlength, int data, int dlength) {}
  






  public void beginEntity(Object baseUri)
  {
    if ((base instanceof XConsumer)) {
      ((XConsumer)base).beginEntity(baseUri);
    }
  }
  
  public void endEntity() {
    if ((base instanceof XConsumer)) {
      ((XConsumer)base).endEntity();
    }
  }
  
  public XMLFilter append(char c)
  {
    write(c);
    return this;
  }
  
  public XMLFilter append(CharSequence csq)
  {
    if (csq == null)
      csq = "null";
    append(csq, 0, csq.length());
    return this;
  }
  
  public XMLFilter append(CharSequence csq, int start, int end)
  {
    if (csq == null)
      csq = "null";
    write(csq, start, end - start);
    return this;
  }
  

  MappingInfo lookupTag(Symbol qname)
  {
    String local = qname.getLocalPart();
    String prefix = qname.getPrefix();
    if (prefix == "")
      prefix = null;
    String uri = qname.getNamespaceURI();
    int hash = MappingInfo.hash(prefix, local);
    int index = hash & mappingTableMask;
    MappingInfo first = mappingTable[index];
    MappingInfo info = first;
    for (;;)
    {
      if (info == null)
      {

        info = new MappingInfo();
        qname = qname;
        prefix = prefix;
        uri = uri;
        local = local;
        tagHash = hash;
        nextInBucket = first;
        mappingTable[index] = first;
        return info;
      }
      if (qname == qname)
        return info;
      if ((local == local) && (qname == null) && ((uri == uri) || (uri == null)) && (prefix == prefix))
      {


        uri = uri;
        qname = qname;
        return info;
      }
      info = nextInBucket;
    }
  }
  









  MappingInfo lookupTag(char[] data, int start, int length)
  {
    int hash = 0;
    int prefixHash = 0;
    int colon = -1;
    for (int i = 0; i < length; i++)
    {
      char ch = data[(start + i)];
      if ((ch == ':') && (colon < 0))
      {
        colon = i;
        prefixHash = hash;
        hash = 0;
      }
      else {
        hash = 31 * hash + ch;
      } }
    hash = prefixHash ^ hash;
    int index = hash & mappingTableMask;
    MappingInfo first = mappingTable[index];
    MappingInfo info = first;
    for (;;)
    {
      if (info == null)
      {

        info = new MappingInfo();
        tagHash = hash;
        if (colon >= 0)
        {
          prefix = new String(data, start, colon).intern();
          colon++;
          int lstart = start + colon;
          local = new String(data, lstart, length - colon).intern();
        }
        else
        {
          prefix = null;
          local = new String(data, start, length).intern();
        }
        nextInBucket = first;
        mappingTable[index] = first;
        return info;
      }
      if ((hash == tagHash) && (info.match(data, start, length)))
      {
        return info; }
      info = nextInBucket;
    }
  }
  
  private void ensureSpaceInWorkStack(int oldSize)
  {
    if (workStack == null)
    {
      workStack = new Object[20];
    }
    else if (oldSize >= workStack.length)
    {
      Object[] tmpn = new Object[2 * workStack.length];
      System.arraycopy(workStack, 0, tmpn, 0, oldSize);
      workStack = tmpn;
    }
  }
  
  private void ensureSpaceInStartIndexes(int oldSize)
  {
    if (startIndexes == null)
    {
      startIndexes = new int[20];
    }
    else if (oldSize >= startIndexes.length)
    {
      int[] tmpn = new int[2 * startIndexes.length];
      System.arraycopy(startIndexes, 0, tmpn, 0, oldSize);
      startIndexes = tmpn;
    }
  }
  

  public static String duplicateAttributeMessage(Symbol attrSymbol, Object elementName)
  {
    StringBuffer sbuf = new StringBuffer("duplicate attribute: ");
    String uri = attrSymbol.getNamespaceURI();
    if ((uri != null) && (uri.length() > 0))
    {
      sbuf.append('{');
      sbuf.append('}');
      sbuf.append(uri);
    }
    sbuf.append(attrSymbol.getLocalPart());
    if (elementName != null)
    {
      sbuf.append(" in <");
      sbuf.append(elementName);
      sbuf.append('>');
    }
    return sbuf.toString();
  }
  
  public void error(char severity, String message)
  {
    if (messages == null)
      throw new RuntimeException(message);
    if (locator != null) {
      messages.error(severity, locator, message);
    } else {
      messages.error(severity, message);
    }
  }
  
  public boolean ignoring() {
    return ignoringLevel > 0;
  }
  

  public void setDocumentLocator(Locator locator)
  {
    if ((locator instanceof SourceLocator)) {
      this.locator = ((SourceLocator)locator);
    }
  }
  


  public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
  {
    startElement(Symbol.make(namespaceURI, localName));
    int numAttributes = atts.getLength();
    for (int i = 0; i < numAttributes; i++)
    {
      startAttribute(Symbol.make(atts.getURI(i), atts.getLocalName(i)));
      write(atts.getValue(i));
      endAttribute();
    }
  }
  

  public void endElement(String namespaceURI, String localName, String qName)
  {
    endElement();
  }
  
  public void startElement(String name, AttributeList atts)
  {
    name = name.intern();
    startElement(name);
    int attrLength = atts.getLength();
    for (int i = 0; i < attrLength; i++)
    {
      name = atts.getName(i);
      name = name.intern();
      String type = atts.getType(i);
      String value = atts.getValue(i);
      startAttribute(name);
      write(value);
      endAttribute();
    }
  }
  
  public void endElement(String name)
    throws SAXException
  {
    endElement();
  }
  
  public void characters(char[] ch, int start, int length)
    throws SAXException
  {
    write(ch, start, length);
  }
  
  public void ignorableWhitespace(char[] ch, int start, int length)
    throws SAXException
  {
    write(ch, start, length);
  }
  



  public void processingInstruction(String target, String data)
  {
    char[] chars = data.toCharArray();
    processingInstructionCommon(target, chars, 0, chars.length);
  }
  
  public void startPrefixMapping(String prefix, String uri)
  {
    namespaceBindings = findNamespaceBinding(prefix.intern(), uri.intern(), namespaceBindings);
  }
  


  public void endPrefixMapping(String prefix)
  {
    namespaceBindings = namespaceBindings.getNext();
  }
  


  public void skippedEntity(String name) {}
  

  public String getPublicId()
  {
    return null;
  }
  
  public String getSystemId()
  {
    return in == null ? null : in.getName();
  }
  
  public String getFileName()
  {
    return in == null ? null : in.getName();
  }
  
  public int getLineNumber()
  {
    if (in == null)
      return -1;
    int line = in.getLineNumber();
    return line < 0 ? -1 : line + 1;
  }
  
  public int getColumnNumber()
  {
    int col;
    return (in != null) && ((col = in.getColumnNumber()) > 0) ? col : -1;
  }
  
  public boolean isStableSourceLocation()
  {
    return false;
  }
}
