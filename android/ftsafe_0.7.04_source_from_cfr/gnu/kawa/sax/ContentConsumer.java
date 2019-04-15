/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.sax;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.SeqPosition;
import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.xml.XName;
import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class ContentConsumer
implements Consumer {
    ContentHandler out;
    int nesting = 0;
    String[] names = new String[15];
    String attrQName;
    String attrURI;
    String attrLocalName;
    AttributesImpl attributes = new AttributesImpl();
    char[] chBuffer;
    StringBuilder strBuffer = new StringBuilder(200);
    int inStartTag;

    public ContentConsumer() {
    }

    public ContentConsumer(ContentHandler handler) {
        this.out = handler;
    }

    public void error(String method, SAXException ex) {
        throw new RuntimeException("caught " + ex + " in " + method);
    }

    public void endStartTag() {
        if (this.inStartTag != 1) {
            return;
        }
        int i = 3 * (this.nesting - 1);
        try {
            this.out.startElement(this.names[i], this.names[i + 1], this.names[i + 2], this.attributes);
        }
        catch (SAXException ex) {
            this.error("startElement", ex);
        }
        this.attributes.clear();
        this.inStartTag = 0;
    }

    @Override
    public void startElement(Object type) {
        String localName;
        String namespaceURI;
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.flushStrBuffer();
        int i = 3 * this.nesting;
        if (i >= this.names.length) {
            String[] tmp = new String[2 * i];
            System.arraycopy(this.names, 0, tmp, 0, i);
            this.names = tmp;
        }
        if (type instanceof Symbol) {
            Symbol sym = (Symbol)type;
            namespaceURI = sym.getNamespaceURI();
            localName = sym.getLocalName();
        } else if (type instanceof XName) {
            XName sym = (XName)type;
            namespaceURI = sym.getNamespaceURI();
            localName = sym.getLocalName();
        } else {
            namespaceURI = "";
            localName = type.toString();
        }
        this.names[i] = namespaceURI;
        this.names[i + 1] = localName;
        this.names[i + 2] = type.toString();
        this.inStartTag = 1;
        ++this.nesting;
    }

    @Override
    public void startAttribute(Object attrType) {
        this.attrURI = ((Symbol)attrType).getNamespaceURI();
        this.attrLocalName = ((Symbol)attrType).getLocalName();
        this.attrQName = attrType.toString();
        this.inStartTag = 2;
    }

    @Override
    public void endAttribute() {
        this.attributes.addAttribute(this.attrURI, this.attrLocalName, this.attrQName, "CDATA", this.strBuffer.toString());
        this.strBuffer.setLength(0);
        this.inStartTag = 1;
    }

    @Override
    public void startDocument() {
        try {
            this.out.startDocument();
        }
        catch (SAXException ex) {
            this.error("startDocument", ex);
        }
    }

    @Override
    public void endDocument() {
        try {
            this.out.endDocument();
        }
        catch (SAXException ex) {
            this.error("endDocument", ex);
        }
    }

    @Override
    public void endElement() {
        this.endStartTag();
        this.flushStrBuffer();
        --this.nesting;
        int i = 3 * this.nesting;
        try {
            this.out.endElement(this.names[i], this.names[i + 1], this.names[i + 2]);
        }
        catch (SAXException ex) {
            this.error("endElement", ex);
        }
        this.names[i] = null;
        this.names[i + 1] = null;
        this.names[i + 2] = null;
    }

    void flushStrBuffer() {
        if (this.strBuffer.length() > 0) {
            if (this.chBuffer == null) {
                this.chBuffer = new char[200];
            }
            try {
                int len;
                int slen = this.strBuffer.length();
                int start = 0;
                while ((len = slen - start) > 0) {
                    if (len > this.chBuffer.length) {
                        len = this.chBuffer.length;
                    }
                    this.strBuffer.getChars(start, start + len, this.chBuffer, start);
                    this.out.characters(this.chBuffer, 0, len);
                    start += len;
                }
                this.strBuffer.setLength(0);
            }
            catch (SAXException ex) {
                this.error("characters", ex);
            }
        }
    }

    @Override
    public void write(char[] buf, int off, int len) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        if (this.inStartTag == 2) {
            this.strBuffer.append(buf, off, len);
        } else {
            this.flushStrBuffer();
            try {
                this.out.characters(buf, off, len);
            }
            catch (SAXException ex) {
                this.error("characters", ex);
            }
        }
    }

    @Override
    public void write(int v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        if (v >= 65536) {
            this.strBuffer.append((char)((v - 65536 >> 10) + 55296));
            v = (v & 1023) + 56320;
        }
        this.strBuffer.append((char)v);
    }

    @Override
    public void write(String v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }

    @Override
    public void write(CharSequence str, int start, int length) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(str, start, start + length);
    }

    @Override
    public ContentConsumer append(char c) {
        this.write(c);
        return this;
    }

    @Override
    public ContentConsumer append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        this.write(csq, 0, csq.length());
        return this;
    }

    @Override
    public ContentConsumer append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        this.write(csq, start, end);
        return this;
    }

    @Override
    public void writeObject(Object v) {
        if (v instanceof Consumable) {
            ((Consumable)v).consume(this);
        } else if (v instanceof SeqPosition) {
            SeqPosition pos = (SeqPosition)v;
            ((AbstractSequence)pos.sequence).consumeNext(pos.ipos, this);
        } else if (v instanceof Char) {
            ((Char)v).print(this);
        } else {
            this.write(v == null ? "(null)" : v.toString());
        }
    }

    @Override
    public void writeBoolean(boolean v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }

    @Override
    public void writeLong(long v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }

    @Override
    public void writeInt(int v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }

    @Override
    public void writeFloat(float v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }

    @Override
    public void writeDouble(double v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }

    public void finalize() {
        this.flushStrBuffer();
    }

    @Override
    public boolean ignoring() {
        return false;
    }

    public void setContentHandler(ContentHandler handler) {
        this.out = handler;
    }

    public ContentHandler getContentHandler() {
        return this.out;
    }
}

