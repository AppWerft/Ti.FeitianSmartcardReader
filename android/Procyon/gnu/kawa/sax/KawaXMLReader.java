// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.sax;

import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.Reader;
import org.xml.sax.SAXParseException;
import org.xml.sax.Locator;
import gnu.kawa.io.InPort;
import gnu.lists.Consumer;
import gnu.xml.XMLFilter;
import gnu.text.SourceMessages;
import gnu.xml.XMLParser;
import org.xml.sax.InputSource;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.XMLReader;

public class KawaXMLReader extends ContentConsumer implements XMLReader
{
    ErrorHandler errorHandler;
    
    @Override
    public boolean getFeature(final String name) {
        return false;
    }
    
    @Override
    public void setFeature(final String name, final boolean value) {
    }
    
    @Override
    public Object getProperty(final String name) {
        return null;
    }
    
    @Override
    public void setProperty(final String name, final Object value) {
    }
    
    @Override
    public void setEntityResolver(final EntityResolver resolver) {
    }
    
    @Override
    public EntityResolver getEntityResolver() {
        return null;
    }
    
    @Override
    public void setDTDHandler(final DTDHandler handler) {
    }
    
    @Override
    public DTDHandler getDTDHandler() {
        return null;
    }
    
    @Override
    public void setErrorHandler(final ErrorHandler handler) {
        this.errorHandler = handler;
    }
    
    @Override
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }
    
    @Override
    public void parse(final InputSource input) throws IOException, SAXException {
        Reader reader = input.getCharacterStream();
        if (reader == null) {
            reader = XMLParser.XMLStreamReader(input.getByteStream());
        }
        final SourceMessages messages = new SourceMessages();
        final XMLFilter filter = new XMLFilter(this);
        final InPort lin = new InPort(reader);
        filter.setSourceLocator(lin);
        this.getContentHandler().setDocumentLocator(filter);
        XMLParser.parse(lin, messages, filter);
        final String err = messages.toString(20);
        if (err != null) {
            throw new SAXParseException(err, filter);
        }
    }
    
    @Override
    public void parse(final String systemId) {
    }
}
