// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.sax;

import java.io.IOException;
import gnu.text.Char;
import gnu.lists.SeqPosition;
import gnu.lists.Consumable;
import gnu.xml.XName;
import gnu.mapping.Symbol;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.ContentHandler;
import gnu.lists.Consumer;

public class ContentConsumer implements Consumer
{
    ContentHandler out;
    int nesting;
    String[] names;
    String attrQName;
    String attrURI;
    String attrLocalName;
    AttributesImpl attributes;
    char[] chBuffer;
    StringBuilder strBuffer;
    int inStartTag;
    
    public ContentConsumer() {
        this.nesting = 0;
        this.names = new String[15];
        this.attributes = new AttributesImpl();
        this.strBuffer = new StringBuilder(200);
    }
    
    public ContentConsumer(final ContentHandler handler) {
        this.nesting = 0;
        this.names = new String[15];
        this.attributes = new AttributesImpl();
        this.strBuffer = new StringBuilder(200);
        this.out = handler;
    }
    
    public void error(final String method, final SAXException ex) {
        throw new RuntimeException("caught " + ex + " in " + method);
    }
    
    public void endStartTag() {
        if (this.inStartTag != 1) {
            return;
        }
        final int i = 3 * (this.nesting - 1);
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
    public void startElement(final Object type) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.flushStrBuffer();
        final int i = 3 * this.nesting;
        if (i >= this.names.length) {
            final String[] tmp = new String[2 * i];
            System.arraycopy(this.names, 0, tmp, 0, i);
            this.names = tmp;
        }
        String namespaceURI;
        String localName;
        if (type instanceof Symbol) {
            final Symbol sym = (Symbol)type;
            namespaceURI = sym.getNamespaceURI();
            localName = sym.getLocalName();
        }
        else if (type instanceof XName) {
            final XName sym2 = (XName)type;
            namespaceURI = sym2.getNamespaceURI();
            localName = sym2.getLocalName();
        }
        else {
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
    public void startAttribute(final Object attrType) {
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
        final int i = 3 * this.nesting;
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
                final int slen = this.strBuffer.length();
                int start = 0;
                while (true) {
                    int len = slen - start;
                    if (len <= 0) {
                        break;
                    }
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
    public void write(final char[] buf, final int off, final int len) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        if (this.inStartTag == 2) {
            this.strBuffer.append(buf, off, len);
        }
        else {
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
            v = (v & 0x3FF) + 56320;
        }
        this.strBuffer.append((char)v);
    }
    
    @Override
    public void write(final String v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }
    
    @Override
    public void write(final CharSequence str, final int start, final int length) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(str, start, start + length);
    }
    
    @Override
    public ContentConsumer append(final char c) {
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
    public ContentConsumer append(CharSequence csq, final int start, final int end) {
        if (csq == null) {
            csq = "null";
        }
        this.write(csq, start, end);
        return this;
    }
    
    @Override
    public void writeObject(final Object v) {
        if (v instanceof Consumable) {
            ((Consumable)v).consume(this);
        }
        else if (v instanceof SeqPosition) {
            final SeqPosition pos = (SeqPosition)v;
            pos.sequence.consumeNext(pos.ipos, this);
        }
        else if (v instanceof Char) {
            ((Char)v).print(this);
        }
        else {
            this.write((v == null) ? "(null)" : v.toString());
        }
    }
    
    @Override
    public void writeBoolean(final boolean v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }
    
    @Override
    public void writeLong(final long v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }
    
    @Override
    public void writeInt(final int v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }
    
    @Override
    public void writeFloat(final float v) {
        if (this.inStartTag == 1) {
            this.endStartTag();
        }
        this.strBuffer.append(v);
    }
    
    @Override
    public void writeDouble(final double v) {
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
    
    public void setContentHandler(final ContentHandler handler) {
        this.out = handler;
    }
    
    public ContentHandler getContentHandler() {
        return this.out;
    }
}
