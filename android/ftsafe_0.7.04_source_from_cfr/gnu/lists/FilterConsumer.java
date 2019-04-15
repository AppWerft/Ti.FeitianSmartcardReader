/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import java.io.IOException;

public class FilterConsumer
implements XConsumer {
    protected Consumer base;
    protected boolean skipping;
    protected boolean inAttribute;
    protected Object attributeType;

    public FilterConsumer(Consumer base2) {
        this.base = base2;
    }

    protected void beforeContent() {
    }

    protected void beforeNode() {
    }

    @Override
    public void write(int v) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.write(v);
        }
    }

    @Override
    public void writeBoolean(boolean v) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.writeBoolean(v);
        }
    }

    @Override
    public void writeFloat(float v) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.writeFloat(v);
        }
    }

    @Override
    public void writeDouble(double v) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.writeDouble(v);
        }
    }

    @Override
    public void writeInt(int v) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.writeInt(v);
        }
    }

    @Override
    public void writeLong(long v) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.writeLong(v);
        }
    }

    @Override
    public void startDocument() {
        if (!this.skipping) {
            this.base.startDocument();
        }
    }

    @Override
    public void endDocument() {
        if (!this.skipping) {
            this.base.endDocument();
        }
    }

    @Override
    public void startElement(Object type) {
        if (!this.skipping) {
            this.beforeNode();
            this.base.startElement(type);
        }
    }

    @Override
    public void endElement() {
        if (!this.skipping) {
            this.base.endElement();
        }
    }

    @Override
    public void startAttribute(Object attrType) {
        this.attributeType = attrType;
        this.inAttribute = true;
        if (!this.skipping) {
            this.beforeNode();
            this.base.startAttribute(attrType);
        }
    }

    @Override
    public void endAttribute() {
        if (!this.skipping) {
            this.base.endAttribute();
        }
        this.inAttribute = false;
    }

    @Override
    public void writeComment(char[] chars, int offset, int length) {
        if (!this.skipping) {
            this.beforeNode();
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeComment(chars, offset, length);
            }
        }
    }

    @Override
    public void writeProcessingInstruction(String target, char[] content, int offset, int length) {
        if (!this.skipping) {
            this.beforeNode();
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeProcessingInstruction(target, content, offset, length);
            }
        }
    }

    @Override
    public void writeCDATA(char[] chars, int offset, int length) {
        this.beforeContent();
        if (!this.skipping) {
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).writeCDATA(chars, offset, length);
            } else {
                this.base.write(chars, offset, length);
            }
        }
    }

    @Override
    public void beginEntity(Object baseUri) {
        if (!this.skipping) {
            this.beforeNode();
            if (this.base instanceof XConsumer) {
                ((XConsumer)this.base).beginEntity(baseUri);
            }
        }
    }

    @Override
    public void endEntity() {
        if (!this.skipping && this.base instanceof XConsumer) {
            ((XConsumer)this.base).endEntity();
        }
    }

    @Override
    public void writeObject(Object v) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.writeObject(v);
        }
    }

    @Override
    public boolean ignoring() {
        return this.base.ignoring();
    }

    @Override
    public void write(char[] buf, int off, int len) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.write(buf, off, len);
        }
    }

    @Override
    public void write(String str) {
        this.write(str, 0, str.length());
    }

    @Override
    public void write(CharSequence str, int start, int length) {
        this.beforeContent();
        if (!this.skipping) {
            this.base.write(str, start, length);
        }
    }

    @Override
    public Consumer append(char c) {
        this.write(c);
        return this;
    }

    @Override
    public Consumer append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        this.write(csq, 0, csq.length());
        return this;
    }

    @Override
    public Consumer append(CharSequence csq, int start, int end) {
        if (csq == null) {
            csq = "null";
        }
        this.write(csq, start, end - start);
        return this;
    }
}

