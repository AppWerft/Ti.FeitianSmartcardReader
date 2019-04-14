package gnu.kawa.sax;

import gnu.text.SourceMessages;
import gnu.xml.XMLFilter;
import gnu.xml.XMLParser;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

public class KawaXMLReader extends ContentConsumer implements org.xml.sax.XMLReader
{
  ErrorHandler errorHandler;
  
  public KawaXMLReader() {}
  
  public boolean getFeature(String name)
  {
    return false;
  }
  

  public void setFeature(String name, boolean value) {}
  

  public Object getProperty(String name)
  {
    return null;
  }
  


  public void setProperty(String name, Object value) {}
  

  public void setEntityResolver(EntityResolver resolver) {}
  

  public EntityResolver getEntityResolver()
  {
    return null;
  }
  

  public void setDTDHandler(DTDHandler handler) {}
  

  public DTDHandler getDTDHandler()
  {
    return null;
  }
  



  public void setErrorHandler(ErrorHandler handler)
  {
    errorHandler = handler;
  }
  
  public ErrorHandler getErrorHandler()
  {
    return errorHandler;
  }
  
  public void parse(InputSource input)
    throws java.io.IOException, org.xml.sax.SAXException
  {
    java.io.Reader reader = input.getCharacterStream();
    if (reader == null)
      reader = XMLParser.XMLStreamReader(input.getByteStream());
    SourceMessages messages = new SourceMessages();
    XMLFilter filter = new XMLFilter(this);
    gnu.kawa.io.InPort lin = new gnu.kawa.io.InPort(reader);
    filter.setSourceLocator(lin);
    getContentHandler().setDocumentLocator(filter);
    XMLParser.parse(lin, messages, filter);
    String err = messages.toString(20);
    if (err != null) {
      throw new org.xml.sax.SAXParseException(err, filter);
    }
  }
  
  public void parse(String systemId) {}
}
