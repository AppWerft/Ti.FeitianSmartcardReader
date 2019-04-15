/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.sax;

import gnu.kawa.io.InPort;
import gnu.kawa.sax.ContentConsumer;
import gnu.lists.Consumer;
import gnu.text.SourceMessages;
import gnu.xml.XMLFilter;
import gnu.xml.XMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

public class KawaXMLReader
extends ContentConsumer
implements XMLReader {
    ErrorHandler errorHandler;

    @Override
    public boolean getFeature(String name) {
        return false;
    }

    @Override
    public void setFeature(String name, boolean value) {
    }

    @Override
    public Object getProperty(String name) {
        return null;
    }

    @Override
    public void setProperty(String name, Object value) {
    }

    @Override
    public void setEntityResolver(EntityResolver resolver) {
    }

    @Override
    public EntityResolver getEntityResolver() {
        return null;
    }

    @Override
    public void setDTDHandler(DTDHandler handler) {
    }

    @Override
    public DTDHandler getDTDHandler() {
        return null;
    }

    @Override
    public void setErrorHandler(ErrorHandler handler) {
        this.errorHandler = handler;
    }

    @Override
    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    @Override
    public void parse(InputSource input) throws IOException, SAXException {
        Reader reader = input.getCharacterStream();
        if (reader == null) {
            reader = XMLParser.XMLStreamReader(input.getByteStream());
        }
        SourceMessages messages = new SourceMessages();
        XMLFilter filter = new XMLFilter(this);
        InPort lin = new InPort(reader);
        filter.setSourceLocator(lin);
        this.getContentHandler().setDocumentLocator(filter);
        XMLParser.parse(lin, messages, filter);
        String err = messages.toString(20);
        if (err != null) {
            throw new SAXParseException(err, filter);
        }
    }

    @Override
    public void parse(String systemId) {
    }
}

