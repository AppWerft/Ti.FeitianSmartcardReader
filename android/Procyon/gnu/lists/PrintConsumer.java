// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.IOException;
import gnu.kawa.io.PrettyWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.io.PrintWriter;

public class PrintConsumer extends PrintWriter implements Appendable, XConsumer
{
    protected boolean skipping;
    protected Consumer base;
    private static Writer dummyWriter;
    
    public PrintConsumer(final Writer out) {
        this(out, false);
    }
    
    public PrintConsumer(final Writer out, final boolean autoFlush) {
        super((out == null) ? PrintConsumer.dummyWriter : out, autoFlush);
        if (out == null) {
            this.lock = this;
            this.out = null;
        }
        else if (out instanceof Consumer) {
            this.base = (Consumer)out;
        }
    }
    
    public PrintConsumer(final Consumer out, final boolean autoFlush) {
        this((out instanceof Writer) ? out : new ConsumerWriter(out), autoFlush);
        this.base = out;
    }
    
    public PrintConsumer(final OutputStream out, final boolean autoFlush) {
        super(out, autoFlush);
    }
    
    public PrettyWriter getPrettyWriter() {
        PrintConsumer cur;
        Writer next;
        for (cur = this; !(cur instanceof PrettyWriter); cur = (PrintConsumer)next) {
            next = cur.out;
            if (!(next instanceof PrintConsumer)) {
                return null;
            }
        }
        return (PrettyWriter)cur;
    }
    
    protected void startNumber() {
        this.writeWordStart();
    }
    
    protected void endNumber() {
        this.writeWordEnd();
    }
    
    @Override
    public PrintConsumer append(final char c) {
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
    public PrintConsumer append(final CharSequence csq, final int start, final int end) {
        this.write((csq == null) ? "null" : csq, start, end - start);
        return this;
    }
    
    @Override
    public void write(CharSequence csq, final int start, final int length) {
        if (length == 0) {
            csq = "";
        }
        if (csq instanceof String) {
            this.write((String)csq, start, length);
        }
        else {
            synchronized (this.lock) {
                for (int end = start + length, i = start; i < end; ++i) {
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
    
    public void writeSpace(final int kind) {
        this.write(32);
        this.writeBreak(kind);
    }
    
    public void writeBreak(final int kind) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).writeBreak(kind);
        }
    }
    
    public static void writeBreakFill(final Consumer out) {
        if (out instanceof PrintConsumer) {
            ((PrintConsumer)out).writeBreakFill();
        }
    }
    
    public void writeBreakFill() {
        this.writeBreak(70);
    }
    
    public static void writeSpaceFill(final Consumer out) {
        if (out instanceof PrintConsumer) {
            ((PrintConsumer)out).writeSpaceFill();
        }
        else {
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
    
    public void setIndentation(final int amount, final boolean current) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).setIndentation(amount, current);
        }
    }
    
    public static void startLogicalBlock(final String prefix, final boolean perLine, final String suffix, final Consumer out) {
        if (out instanceof PrintConsumer) {
            ((PrintConsumer)out).startLogicalBlock(prefix, perLine, suffix);
        }
        else {
            out.write(prefix);
        }
    }
    
    public void startLogicalBlock(final String prefix, final boolean perLine, final String suffix) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).startLogicalBlock(prefix, perLine, suffix);
        }
        else {
            this.writeRaw(prefix);
        }
    }
    
    public void startLogicalBlock(final String prefix, final String suffix, final int indent) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).startLogicalBlock(prefix, suffix, indent);
        }
        else {
            this.writeRaw(prefix);
        }
    }
    
    public static void endLogicalBlock(final String suffix, final Consumer out) {
        if (out instanceof PrintConsumer) {
            ((PrintConsumer)out).endLogicalBlock(suffix);
        }
        else {
            out.write(suffix);
        }
    }
    
    public void endLogicalBlock(final String suffix) {
        if (this.base instanceof PrintConsumer) {
            ((PrintConsumer)this.base).endLogicalBlock(suffix);
        }
        else {
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
    
    @Override
    public void writeBoolean(final boolean v) {
        if (this.skipping) {
            return;
        }
        synchronized (this.lock) {
            this.writeWordStart();
            if (this.base != null) {
                this.base.writeBoolean(v);
            }
            else {
                this.print(v);
            }
            this.writeWordEnd();
        }
    }
    
    @Override
    public void writeFloat(final float v) {
        if (this.skipping) {
            return;
        }
        synchronized (this.lock) {
            this.startNumber();
            if (this.base != null) {
                this.base.writeFloat(v);
            }
            else {
                this.print(v);
            }
            this.endNumber();
        }
    }
    
    @Override
    public void writeDouble(final double v) {
        if (this.skipping) {
            return;
        }
        synchronized (this.lock) {
            this.startNumber();
            if (this.base != null) {
                this.base.writeDouble(v);
            }
            else {
                this.print(v);
            }
            this.endNumber();
        }
    }
    
    @Override
    public void writeInt(final int v) {
        if (this.skipping) {
            return;
        }
        synchronized (this.lock) {
            this.startNumber();
            if (this.base != null) {
                this.base.writeInt(v);
            }
            else {
                this.print(v);
            }
            this.endNumber();
        }
    }
    
    @Override
    public void writeLong(final long v) {
        if (this.skipping) {
            return;
        }
        synchronized (this.lock) {
            this.startNumber();
            if (this.base != null) {
                this.base.writeLong(v);
            }
            else {
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
    public void startElement(final Object type) {
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
    public void startAttribute(final Object attrType) {
    }
    
    @Override
    public void endAttribute() {
    }
    
    @Override
    public void writeComment(final char[] chars, final int offset, final int length) {
        if (this.skipping) {
            return;
        }
        this.beforeNode();
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).writeComment(chars, offset, length);
        }
    }
    
    @Override
    public void writeProcessingInstruction(final String target, final char[] content, final int offset, final int length) {
        if (this.skipping) {
            return;
        }
        this.beforeNode();
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).writeProcessingInstruction(target, content, offset, length);
        }
    }
    
    @Override
    public void writeCDATA(final char[] chars, final int offset, final int length) {
        this.beforeContent();
        if (this.skipping) {
            return;
        }
        if (this.base instanceof XConsumer) {
            ((XConsumer)this.base).writeCDATA(chars, offset, length);
        }
        else {
            this.writeRaw(chars, offset, length);
        }
    }
    
    @Override
    public void beginEntity(final Object baseUri) {
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
    
    protected void writeRaw(final int v) {
        try {
            this.out.write(v);
        }
        catch (IOException ex) {
            this.setError();
        }
    }
    
    protected void writeRaw(final String str) {
        try {
            this.out.write(str, 0, str.length());
        }
        catch (IOException ex) {
            this.setError();
        }
    }
    
    protected void writeRaw(final String str, final int start, final int length) {
        try {
            this.out.write(str, start, length);
        }
        catch (IOException ex) {
            this.setError();
        }
    }
    
    protected void writeRaw(final char[] chars, final int start, final int length) {
        try {
            this.out.write(chars, start, length);
        }
        catch (IOException ex) {
            this.setError();
        }
    }
    
    @Override
    public void writeObject(final Object v) {
        if (this.out instanceof Consumer) {
            ((Consumer)this.out).writeObject(v);
        }
        else {
            this.print(v);
        }
    }
    
    @Override
    public boolean ignoring() {
        return false;
    }
    
    static {
        PrintConsumer.dummyWriter = new ConsumerWriter(null);
    }
}
