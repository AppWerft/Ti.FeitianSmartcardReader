/*
 * Decompiled with CFR 0.139.
 */
package gnu.lists;

import gnu.kawa.io.PrettyWriter;
import gnu.lists.Consumer;
import gnu.lists.ConsumerWriter;
import gnu.lists.XConsumer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class PrintConsumer
extends PrintWriter
implements Appendable,
XConsumer {
    protected boolean skipping;
    protected Consumer base;
    private static Writer dummyWriter = new ConsumerWriter(null);

    public PrintConsumer(Writer out) {
        this(out, false);
    }

    public PrintConsumer(Writer out, boolean autoFlush) {
        super(out == null ? dummyWriter : out, autoFlush);
        if (out == null) {
            this.lock = this;
            this.out = null;
        } else if (out instanceof Consumer) {
            this.base = (Consumer)((Object)out);
        }
    }

    public PrintConsumer(Consumer out, boolean autoFlush) {
        this(out instanceof Writer ? (Writer)((Object)out) : new ConsumerWriter(out), autoFlush);
        this.base = out;
    }

    public PrintConsumer(OutputStream out, boolean autoFlush) {
        super(out, autoFlush);
    }

    public PrettyWriter getPrettyWriter() {
        PrintConsumer cur = this;
        do {
            if (cur instanceof PrettyWriter) {
                return (PrettyWriter)cur;
            }
            Writer next = cur.out;
            if (!(next instanceof PrintConsumer)) break;
            cur = (PrintConsumer)next;
        } while (true);
        return null;
    }

    protected void startNumber() {
        this.writeWordStart();
    }

    protected void endNumber() {
        this.writeWordEnd();
    }

    @Override
    public PrintConsumer append(char c) {
        this.print(c);
        return this;
    }

    @Override
    public PrintConsumer append(CharSequence csq) {
        if (csq == null) {
            csq = "null";
        }
        this.append(csq, 0, csq.length());
        return this;
    }

    @Override
    public PrintConsumer append(CharSequence csq, int start, int end) {
        this.write(csq == null ? "null" : csq, start, end - start);
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(CharSequence csq, int start, int length) {
        if (length == 0) {
            csq = "";
        }
        if (csq instanceof String) {
            this.write((String)csq, start, length);
        } else {
            Object object2 = this.lock;
            synchronized (object2) {
                int end = start + length;
                for (int i = start; i < end; ++i) {
                    this.write(csq.charAt(i));
                }
            }
        }
    }

    public void freshLine() {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).freshLine();
        }
    }

    public void writeSpace(int kind) {
        this.write(32);
        this.writeBreak(kind);
    }

    public void writeBreak(int kind) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).writeBreak(kind);
        }
    }

    public static void writeBreakFill(Consumer out) {
        if (out instanceof PrintConsumer) {
            ((PrintConsumer)out).writeBreakFill();
        }
    }

    public void writeBreakFill() {
        this.writeBreak(70);
    }

    public static void writeSpaceFill(Consumer out) {
        if (out instanceof PrintConsumer) {
            ((PrintConsumer)out).writeSpaceFill();
        } else {
            out.write(32);
        }
    }

    public void writeSpaceFill() {
        this.writeSpace(70);
    }

    public void writeSpaceLinear() {
        this.writeSpace(78);
    }

    public void writeBreakLinear() {
        this.writeBreak(78);
    }

    public void setIndentation(int amount, boolean current) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).setIndentation(amount, current);
        }
    }

    public static void startLogicalBlock(String prefix, boolean perLine, String suffix, Consumer out) {
        if (out instanceof PrintConsumer) {
            ((PrintConsumer)out).startLogicalBlock(prefix, perLine, suffix);
        } else {
            out.write(prefix);
        }
    }

    public void startLogicalBlock(String prefix, boolean perLine, String suffix) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).startLogicalBlock(prefix, perLine, suffix);
        } else {
            this.writeRaw(prefix);
        }
    }

    public void startLogicalBlock(String prefix, String suffix, int indent) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).startLogicalBlock(prefix, suffix, indent);
        } else {
            this.writeRaw(prefix);
        }
    }

    public static void endLogicalBlock(String suffix, Consumer out) {
        if (out instanceof PrintConsumer) {
            ((PrintConsumer)out).endLogicalBlock(suffix);
        } else {
            out.write(suffix);
        }
    }

    public void endLogicalBlock(String suffix) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).endLogicalBlock(suffix);
        } else {
            this.writeRaw(suffix);
        }
    }

    protected void beforeContent() {
    }

    protected void beforeNode() {
    }

    public void writeWordStart() {
        if (this.out instanceof PrintConsumer) {
            ((PrintConsumer)this.out).writeWordStart();
        }
    }

    public void writeWordEnd() {
        if (this.out instanceof PrintConsumer) {
            ((PrintConsumer)this.out).writeWordEnd();
        }
    }

    protected void clearWordEnd() {
        if (this.out instanceof PrintConsumer) {
            ((PrintConsumer)this.out).clearWordEnd();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeBoolean(boolean v) {
        if (this.skipping) {
            return;
        }
        Object object2 = this.lock;
        synchronized (object2) {
            this.writeWordStart();
            if (this.base != null) {
                this.base.writeBoolean(v);
            } else {
                this.print(v);
            }
            this.writeWordEnd();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeFloat(float v) {
        if (this.skipping) {
            return;
        }
        Object object2 = this.lock;
        synchronized (object2) {
            this.startNumber();
            if (this.base != null) {
                this.base.writeFloat(v);
            } else {
                this.print(v);
            }
            this.endNumber();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeDouble(double v) {
        if (this.skipping) {
            return;
        }
        Object object2 = this.lock;
        synchronized (object2) {
            this.startNumber();
            if (this.base != null) {
                this.base.writeDouble(v);
            } else {
                this.print(v);
            }
            this.endNumber();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeInt(int v) {
        if (this.skipping) {
            return;
        }
        Object object2 = this.lock;
        synchronized (object2) {
            this.startNumber();
            if (this.base != null) {
                this.base.writeInt(v);
            } else {
                this.print(v);
            }
            this.endNumber();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeLong(long v) {
        if (this.skipping) {
            return;
        }
        Object object2 = this.lock;
        synchronized (object2) {
            this.startNumber();
            if (this.base != null) {
                this.base.writeLong(v);
            } else {
                this.print(v);
            }
            this.endNumber();
        }
    }

    @Override
    public void startDocument() {
        if (this.base != null && !this.skipping) {
            this.base.startDocument();
        }
    }

    @Override
    public void endDocument() {
        if (this.base != null && !this.skipping) {
            this.base.endDocument();
        }
    }

    @Override
    public void startElement(Object type) {
        if (this.base != null && !this.skipping) {
            this.base.startElement(type);
        }
    }

    @Override
    public void endElement() {
        if (this.base != null && !this.skipping) {
            this.base.endElement();
        }
    }

    @Override
    public void startAttribute(Object attrType) {
    }

    @Override
    public void endAttribute() {
    }

    @Override
    public void writeComment(char[] chars, int offset, int length) {
        if (this.skipping) {
            return;
        }
        this.beforeNode();
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).writeComment(chars, offset, length);
        }
    }

    @Override
    public void writeProcessingInstruction(String target, char[] content, int offset, int length) {
        if (this.skipping) {
            return;
        }
        this.beforeNode();
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).writeProcessingInstruction(target, content, offset, length);
        }
    }

    @Override
    public void writeCDATA(char[] chars, int offset, int length) {
        this.beforeContent();
        if (this.skipping) {
            return;
        }
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).writeCDATA(chars, offset, length);
        } else {
            this.writeRaw(chars, offset, length);
        }
    }

    @Override
    public void beginEntity(Object baseUri) {
        if (this.skipping) {
            return;
        }
        this.beforeNode();
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).beginEntity(baseUri);
        }
    }

    @Override
    public void endEntity() {
        if (this.skipping) {
            return;
        }
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).endEntity();
        }
    }

    protected void writeRaw(int v) {
        try {
            this.out.write(v);
        }
        catch (IOException ex) {
            this.setError();
        }
    }

    protected void writeRaw(String str) {
        try {
            this.out.write(str, 0, str.length());
        }
        catch (IOException ex) {
            this.setError();
        }
    }

    protected void writeRaw(String str, int start, int length) {
        try {
            this.out.write(str, start, length);
        }
        catch (IOException ex) {
            this.setError();
        }
    }

    protected void writeRaw(char[] chars, int start, int length) {
        try {
            this.out.write(chars, start, length);
        }
        catch (IOException ex) {
            this.setError();
        }
    }

    @Override
    public void writeObject(Object v) {
        if (this.out instanceof Consumer) {
            ((Consumer)((Object)this.out)).writeObject(v);
        } else {
            this.print(v);
        }
    }

    @Override
    public boolean ignoring() {
        return false;
    }
}

