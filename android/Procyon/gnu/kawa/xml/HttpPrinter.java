// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import gnu.lists.Consumable;
import gnu.kawa.io.BinaryOutPort;
import gnu.lists.Blob;
import gnu.mapping.Symbol;
import gnu.lists.Consumer;
import gnu.xml.XMLPrinter;
import gnu.kawa.io.OutPort;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStream;
import java.util.Vector;
import gnu.lists.PrintConsumer;

public class HttpPrinter extends PrintConsumer
{
    Vector headers;
    StringBuilder sbuf;
    Object currentHeader;
    private int seenStartDocument;
    protected String sawContentType;
    private int elementNesting;
    protected OutputStream ostream;
    PrintConsumer writer;
    boolean seenXmlHeader;
    
    public HttpPrinter(final OutputStream out) {
        super((Writer)null);
        this.headers = new Vector();
        this.sbuf = new StringBuilder(100);
        this.ostream = out;
    }
    
    public HttpPrinter(final PrintConsumer out) {
        super((Writer)null);
        this.headers = new Vector();
        this.sbuf = new StringBuilder(100);
        this.writer = out;
    }
    
    public static HttpPrinter make(final PrintConsumer out) {
        return new HttpPrinter(out);
    }
    
    @Override
    protected void beforeNode() {
        if (this.sawContentType == null) {
            this.addHeader("Content-type", "text/xml");
        }
        this.beginData();
    }
    
    public void printHeader(final String label, final String value) throws IOException {
        this.writeRaw(label);
        this.writeRaw(": ");
        this.writeRaw(value);
        this.writeRaw("\n");
    }
    
    public void printHeaders() throws IOException {
        for (int num = this.headers.size(), i = 0; i < num; i += 2) {
            this.printHeader(this.headers.elementAt(i).toString(), this.headers.elementAt(i + 1).toString());
        }
        this.writeRaw("\n");
    }
    
    public void addHeader(final String label, final String value) {
        if (label.equalsIgnoreCase("Content-type")) {
            this.sawContentType = value;
        }
        this.headers.addElement(label);
        this.headers.addElement(value);
    }
    
    @Override
    public void startAttribute(final Object attrType) {
        if (this.base == null) {
            this.currentHeader = attrType;
        }
        else {
            this.base.startAttribute(attrType);
        }
    }
    
    @Override
    public void endAttribute() {
        if (this.currentHeader != null) {
            this.addHeader(this.currentHeader.toString(), this.sbuf.toString());
            this.sbuf.setLength(0);
            this.currentHeader = null;
        }
        else {
            this.base.endAttribute();
        }
    }
    
    public void beginData() {
        if (this.base == null) {
            if (this.sawContentType == null) {
                this.addHeader("Content-type", "text/plain");
            }
            if (this.writer == null) {
                this.writer = new OutPort(this.ostream);
            }
            String style = null;
            if ("text/html".equalsIgnoreCase(this.sawContentType)) {
                style = "html";
            }
            else if ("application/xhtml+xml".equalsIgnoreCase(this.sawContentType)) {
                style = "xhtml";
            }
            else if ("text/plain".equalsIgnoreCase(this.sawContentType)) {
                style = "plain";
            }
            final XMLPrinter xout = XMLPrinter.make(this.writer, style);
            this.out = xout;
            this.base = xout;
            if (this.seenStartDocument == 0) {
                this.base.startDocument();
                this.seenStartDocument = 1;
            }
            try {
                this.printHeaders();
            }
            catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        this.append(this.sbuf);
        this.sbuf.setLength(0);
    }
    
    @Override
    public void startElement(final Object type) {
        if (this.sawContentType == null) {
            String mimeType;
            if (!this.seenXmlHeader) {
                mimeType = "text/html";
            }
            else if (type instanceof Symbol && "html".equals(((Symbol)type).getLocalPart())) {
                mimeType = "text/xhtml";
            }
            else {
                mimeType = "text/xml";
            }
            this.addHeader("Content-type", mimeType);
        }
        this.beginData();
        this.base.startElement(type);
        ++this.elementNesting;
    }
    
    @Override
    public void endElement() {
        super.endElement();
        --this.elementNesting;
        if (this.elementNesting == 0 && this.seenStartDocument == 1) {
            this.endDocument();
        }
    }
    
    @Override
    public void writeObject(final Object v) {
        if (v instanceof Blob) {
            final OutputStream outs = (this.writer instanceof BinaryOutPort) ? ((BinaryOutPort)this.writer).getOutputStream() : this.ostream;
            if (outs == null) {
                this.writer.write(v.toString());
            }
            else {
                try {
                    ((Blob)v).writeTo(outs);
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        else if (v instanceof Consumable) {
            ((Consumable)v).consume(this);
        }
        else {
            this.beginData();
            super.writeObject(v);
        }
    }
    
    @Override
    public void write(final CharSequence str, final int start, final int length) {
        if (this.base == null) {
            this.sbuf.append(str, start, start + length);
        }
        else {
            this.base.write(str, start, length);
        }
    }
    
    @Override
    public void write(final char[] buf, final int off, final int len) {
        if (this.base == null) {
            this.sbuf.append(buf, off, len);
        }
        else {
            this.base.write(buf, off, len);
        }
    }
    
    @Override
    public void startDocument() {
        if (this.base != null) {
            this.base.startDocument();
        }
        this.seenStartDocument = 2;
    }
    
    @Override
    public void endDocument() {
        if (this.base != null) {
            this.base.endDocument();
        }
        try {
            if (this.sawContentType == null) {
                this.addHeader("Content-type", "text/plain");
            }
            if (this.sbuf.length() > 0) {
                final String str = this.sbuf.toString();
                this.sbuf.setLength(0);
                if (this.writer != null) {
                    this.writer.write(str);
                }
                else {
                    this.ostream.write(str.getBytes());
                }
            }
            if (this.writer != null) {
                this.writer.close();
            }
            if (this.ostream != null) {
                this.ostream.flush();
            }
        }
        catch (Exception ex) {}
    }
    
    @Override
    public boolean ignoring() {
        return (this.base != null) ? this.base.ignoring() : (this.writer != null && this.writer.ignoring());
    }
    
    public boolean reset(final boolean headersAlso) {
        if (headersAlso) {
            this.headers.clear();
            this.sawContentType = null;
            this.currentHeader = null;
            this.elementNesting = 0;
        }
        this.sbuf.setLength(0);
        this.base = null;
        boolean ok = true;
        if (this.ostream != null) {
            ok = (this.writer == null);
            this.writer = null;
        }
        return ok;
    }
}
