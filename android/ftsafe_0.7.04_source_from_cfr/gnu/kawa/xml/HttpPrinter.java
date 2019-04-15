/*
 * Decompiled with CFR 0.139.
 */
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
import java.io.Writer;
import java.util.Vector;

public class HttpPrinter
extends PrintConsumer {
    Vector headers = new Vector();
    StringBuilder sbuf = new StringBuilder(100);
    Object currentHeader;
    private int seenStartDocument;
    protected String sawContentType;
    private int elementNesting;
    protected OutputStream ostream;
    PrintConsumer writer;
    boolean seenXmlHeader;

    public HttpPrinter(OutputStream out) {
        super(null);
        this.ostream = out;
    }

    public HttpPrinter(PrintConsumer out) {
        super(null);
        this.writer = out;
    }

    public static HttpPrinter make(PrintConsumer out) {
        return new HttpPrinter(out);
    }

    @Override
    protected void beforeNode() {
        if (this.sawContentType == null) {
            this.addHeader("Content-type", "text/xml");
        }
        this.beginData();
    }

    public void printHeader(String label, String value) throws IOException {
        this.writeRaw(label);
        this.writeRaw(": ");
        this.writeRaw(value);
        this.writeRaw("\n");
    }

    public void printHeaders() throws IOException {
        int num = this.headers.size();
        for (int i = 0; i < num; i += 2) {
            this.printHeader(this.headers.elementAt(i).toString(), this.headers.elementAt(i + 1).toString());
        }
        this.writeRaw("\n");
    }

    public void addHeader(String label, String value) {
        if (label.equalsIgnoreCase("Content-type")) {
            this.sawContentType = value;
        }
        this.headers.addElement(label);
        this.headers.addElement(value);
    }

    @Override
    public void startAttribute(Object attrType) {
        if (this.base == null) {
            this.currentHeader = attrType;
        } else {
            this.base.startAttribute(attrType);
        }
    }

    @Override
    public void endAttribute() {
        if (this.currentHeader != null) {
            this.addHeader(this.currentHeader.toString(), this.sbuf.toString());
            this.sbuf.setLength(0);
            this.currentHeader = null;
        } else {
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
            } else if ("application/xhtml+xml".equalsIgnoreCase(this.sawContentType)) {
                style = "xhtml";
            } else if ("text/plain".equalsIgnoreCase(this.sawContentType)) {
                style = "plain";
            }
            XMLPrinter xout = XMLPrinter.make(this.writer, style);
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
    public void startElement(Object type) {
        if (this.sawContentType == null) {
            String mimeType = !this.seenXmlHeader ? "text/html" : (type instanceof Symbol && "html".equals(((Symbol)type).getLocalPart()) ? "text/xhtml" : "text/xml");
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
    public void writeObject(Object v) {
        if (v instanceof Blob) {
            OutputStream outs;
            OutputStream outputStream = outs = this.writer instanceof BinaryOutPort ? ((BinaryOutPort)this.writer).getOutputStream() : this.ostream;
            if (outs == null) {
                this.writer.write(v.toString());
            } else {
                try {
                    ((Blob)v).writeTo(outs);
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } else if (v instanceof Consumable) {
            ((Consumable)v).consume(this);
        } else {
            this.beginData();
            super.writeObject(v);
        }
    }

    @Override
    public void write(CharSequence str, int start, int length) {
        if (this.base == null) {
            this.sbuf.append(str, start, start + length);
        } else {
            this.base.write(str, start, length);
        }
    }

    @Override
    public void write(char[] buf, int off, int len) {
        if (this.base == null) {
            this.sbuf.append(buf, off, len);
        } else {
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
                String str = this.sbuf.toString();
                this.sbuf.setLength(0);
                if (this.writer != null) {
                    this.writer.write(str);
                } else {
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
        catch (Exception ex) {
            // empty catch block
        }
    }

    @Override
    public boolean ignoring() {
        return this.base != null ? this.base.ignoring() : (this.writer != null ? this.writer.ignoring() : false);
    }

    public boolean reset(boolean headersAlso) {
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
            ok = this.writer == null;
            this.writer = null;
        }
        return ok;
    }
}

