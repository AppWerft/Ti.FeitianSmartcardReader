// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.io;

import gnu.kawa.format.AbstractFormat;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedOutputStream;
import java.io.IOException;
import gnu.mapping.Environment;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import gnu.lists.Consumer;
import gnu.mapping.ThreadLocation;
import java.io.Writer;
import gnu.kawa.format.Printable;
import gnu.lists.PrintConsumer;

public class OutPort extends PrintConsumer implements Printable
{
    PrintConsumer formatter;
    Path path;
    protected Writer base;
    static final int FLUSH_ON_FINALIZE = 1;
    static final int CLOSE_ON_FINALIZE = 2;
    static final int IS_CLOSED = 4;
    static final int IS_DOMTERM = 8;
    int flags;
    protected PrettyWriter bout;
    protected WriterManager.WriterRef unregisterRef;
    static BinaryOutPort outInitial;
    private static BinaryOutPort errInitial;
    public static final ThreadLocation<OutPort> outLocation;
    public static final ThreadLocation<OutPort> errLocation;
    static Writer logFile;
    
    protected OutPort(final Writer base, final PrettyWriter out, final boolean autoflush) {
        super((Consumer)out, autoflush);
        this.bout = out;
        this.formatter = this.bout;
        this.base = base;
        if (this.closeOnExit()) {
            this.unregisterRef = WriterManager.instance.register(this);
        }
    }
    
    protected OutPort(final OutPort out, final boolean autoflush) {
        this(out, out.bout, autoflush);
    }
    
    protected OutPort(final Writer out, final boolean autoflush) {
        this(out, (out instanceof OutPort) ? ((OutPort)out).bout : new PrettyWriter(out, true), autoflush);
    }
    
    public OutPort(final Writer base, final boolean printPretty, final boolean autoflush) {
        this(base, new PrettyWriter(base, printPretty), autoflush);
    }
    
    public OutPort(final Writer base, final boolean printPretty, final boolean autoflush, final Path path) {
        this(base, new PrettyWriter(base, printPretty), autoflush);
        this.path = path;
    }
    
    public OutPort(final OutputStream out) {
        this(out, null);
    }
    
    public OutPort(final OutputStream out, final Path path) {
        this(new OutputStreamWriter(out), true, path);
    }
    
    public OutPort(final Writer out) {
        this(out, (out instanceof OutPort) ? ((OutPort)out).bout : new PrettyWriter(out, false), false);
    }
    
    public OutPort(final Writer base, final Path path) {
        this(base, false, false);
        this.path = path;
    }
    
    public OutPort(final Writer base, final boolean autoflush, final Path path) {
        this(base, false, autoflush);
        this.path = path;
    }
    
    public static BinaryOutPort getSystemOut() {
        return OutPort.outInitial;
    }
    
    public static BinaryOutPort getSystemErr() {
        return OutPort.errInitial;
    }
    
    public static OutPort outDefault() {
        return OutPort.outLocation.get();
    }
    
    public static void setOutDefault(final OutPort o) {
        OutPort.outLocation.set(o);
    }
    
    public static OutPort errDefault() {
        return OutPort.errLocation.get();
    }
    
    public static void setErrDefault(final OutPort e) {
        OutPort.errLocation.set(e);
    }
    
    public boolean isPrettyPrinting() {
        return this.bout.isPrettyPrinting();
    }
    
    public static OutPort openFile(final Object fname) throws IOException {
        return openFile(fname, Environment.user().get("port-char-encoding"));
    }
    
    public static OutPort openFile(final Object fname, final Object conv) throws IOException {
        final Path path = Path.valueOf(fname);
        OutputStream strm = path.openOutputStream();
        strm = new BufferedOutputStream(strm);
        OutPort outPort;
        if (conv == Boolean.FALSE) {
            outPort = new BinaryOutPort(strm, path);
        }
        else {
            final OutPort outPort2;
            outPort = outPort2;
            outPort2 = new OutPort((conv == null || conv == Boolean.TRUE) ? new OutputStreamWriter(strm) : new OutputStreamWriter(strm, conv.toString()), path);
        }
        final OutPort op = outPort;
        op.flags = 2;
        return op;
    }
    
    public void echo(final char[] buf, final int off, final int len) throws IOException {
        if (this.base instanceof LogWriter) {
            ((LogWriter)this.base).echo(buf, off, len);
        }
    }
    
    public static void closeLogFile() throws IOException {
        if (OutPort.logFile != null) {
            OutPort.logFile.close();
            OutPort.logFile = null;
        }
        if (OutPort.outInitial.base instanceof LogWriter) {
            ((LogWriter)OutPort.outInitial.base).setLogFile((Writer)null);
        }
        if (OutPort.errInitial.base instanceof LogWriter) {
            ((LogWriter)OutPort.errInitial.base).setLogFile((Writer)null);
        }
    }
    
    public static void setLogFile(final String name) throws IOException {
        if (OutPort.logFile != null) {
            closeLogFile();
        }
        OutPort.logFile = new PrintWriter(new BufferedWriter(new FileWriter(name)));
        if (OutPort.outInitial.base instanceof LogWriter) {
            ((LogWriter)OutPort.outInitial.base).setLogFile(OutPort.logFile);
        }
        if (OutPort.errInitial.base instanceof LogWriter) {
            ((LogWriter)OutPort.errInitial.base).setLogFile(OutPort.logFile);
        }
    }
    
    protected static final boolean isWordChar(final char ch) {
        return Character.isJavaIdentifierPart(ch) || ch == '-' || ch == '+';
    }
    
    @Override
    public void print(final int v) {
        this.formatter.writeInt(v);
    }
    
    @Override
    public void print(final long v) {
        this.formatter.writeLong(v);
    }
    
    @Override
    public void print(final double v) {
        this.formatter.writeDouble(v);
    }
    
    @Override
    public void print(final float v) {
        this.formatter.writeFloat(v);
    }
    
    @Override
    public void print(final boolean v) {
        this.formatter.writeBoolean(v);
    }
    
    @Override
    public void print(final String v) {
        this.write((v == null) ? "(null)" : v);
    }
    
    @Override
    public void print(final Object v) {
        this.formatter.writeObject(v);
    }
    
    @Override
    public void print(final Consumer out) {
        out.write("#<output-port");
        if (this.path != null) {
            out.write(32);
            out.write(this.path.toString());
        }
        out.write(62);
    }
    
    @Override
    public void startDocument() {
        this.formatter.startDocument();
    }
    
    @Override
    public void endDocument() {
        this.formatter.endDocument();
    }
    
    @Override
    public void startElement(final Object type) {
        this.formatter.startElement(type);
    }
    
    @Override
    public void endElement() {
        this.formatter.endElement();
    }
    
    @Override
    public void startAttribute(final Object attrType) {
        this.formatter.startAttribute(attrType);
    }
    
    @Override
    public void endAttribute() {
        this.formatter.endAttribute();
    }
    
    @Override
    public void write(final char[] str, final int start, final int count) {
        this.formatter.write(str, start, count);
    }
    
    @Override
    public void write(final String str) {
        this.formatter.write(str, 0, str.length());
    }
    
    @Override
    public void write(final String str, final int start, final int count) {
        this.formatter.write(str, start, count);
    }
    
    @Override
    public void write(final CharSequence str, final int start, final int count) {
        this.formatter.write(str, start, count);
    }
    
    @Override
    public void writeObject(final Object v) {
        this.formatter.writeObject(v);
    }
    
    @Override
    public void writeComment(final char[] chars, final int offset, final int length) {
        this.formatter.writeComment(chars, offset, length);
    }
    
    @Override
    public void writeProcessingInstruction(final String target, final char[] content, final int offset, final int length) {
        this.formatter.writeProcessingInstruction(target, content, offset, length);
    }
    
    @Override
    public void writeCDATA(final char[] chars, final int offset, final int length) {
        this.formatter.writeCDATA(chars, offset, length);
    }
    
    @Override
    public void beginEntity(final Object baseUri) {
        this.formatter.beginEntity(baseUri);
    }
    
    @Override
    public void endEntity() {
        this.formatter.endEntity();
    }
    
    @Override
    public void writeWordEnd() {
        this.formatter.writeWordEnd();
    }
    
    @Override
    public void writeWordStart() {
        this.formatter.writeWordStart();
    }
    
    public Object pushFormat(final AbstractFormat format) {
        final Object old = this.formatter;
        this.formatter = format.makeConsumer(this.formatter);
        return old;
    }
    
    public void popFormat(final Object old) {
        this.formatter = (PrintConsumer)old;
    }
    
    @Override
    public void freshLine() {
        if (!this.atLineStart()) {
            this.println();
        }
    }
    
    public int getColumnNumber() {
        return this.bout.getColumnNumber();
    }
    
    public void setColumnNumber(final int column) {
        this.bout.setColumnNumber(column);
    }
    
    public boolean atLineStart() {
        return this.bout.atLineStart();
    }
    
    void flushBuffer() {
        this.bout.forcePrettyOutput();
    }
    
    public void clearBuffer() {
        this.bout.clearBuffer();
    }
    
    public void closeThis() {
        try {
            if (!(this.base instanceof OutPort) || ((OutPort)this.base).bout != this.bout) {
                this.bout.closeThis();
                this.base = null;
                this.out = null;
            }
        }
        catch (IOException ex) {
            this.setError();
        }
        WriterManager.instance.unregister(this.unregisterRef);
        this.unregisterRef = null;
    }
    
    public boolean isOpen() {
        return (this.flags & 0x4) == 0x0;
    }
    
    public boolean isDomTerm() {
        return (this.flags & 0x8) != 0x0;
    }
    
    public void setDomTerm(final boolean v) {
        if (v) {
            this.flags |= 0x8;
        }
        else {
            this.flags &= 0xFFFFFFF7;
        }
        this.bout.isDomTerm = v;
    }
    
    public static OutPort getPassThroughOutPort(Consumer out) {
        OutPort port = null;
        while (true) {
            if (out instanceof OutPort) {
                port = (OutPort)out;
                final PrintConsumer formatter = port.formatter;
                if (formatter instanceof PrettyWriter) {
                    return port;
                }
                out = formatter;
            }
            else {
                if (!(out instanceof AbstractFormat.FormatConsumer)) {
                    return port;
                }
                final AbstractFormat.FormatConsumer fcons = (AbstractFormat.FormatConsumer)out;
                if (!fcons.getFormat().textIsCopied()) {
                    return null;
                }
                out = fcons.getBase();
            }
        }
    }
    
    @Override
    public void close() {
        try {
            if (this.base instanceof OutPort && ((OutPort)this.base).bout == this.bout) {
                this.base.close();
                this.base = null;
            }
            else if (this.out != null) {
                this.out.close();
                this.out = null;
            }
        }
        catch (IOException ex) {
            this.setError();
        }
        WriterManager.instance.unregister(this.unregisterRef);
        this.unregisterRef = null;
        this.flags = 4;
    }
    
    protected boolean closeOnExit() {
        return true;
    }
    
    public void finalize() {
        if ((this.flags & 0x1) != 0x0) {
            this.flush();
        }
        if ((this.flags & 0x2) != 0x0) {
            this.close();
        }
        else {
            this.closeThis();
        }
    }
    
    public static void runCleanups() {
        WriterManager.instance.run();
    }
    
    public void setPrettyPrinting(final boolean mode) {
        this.bout.setPrettyPrinting(mode);
    }
    
    @Override
    public void startLogicalBlock(final String prefix, final boolean perLine, final String suffix) {
        this.bout.startLogicalBlock(prefix, perLine, suffix);
    }
    
    @Override
    public void startLogicalBlock(final String prefix, final String suffix, final int indent) {
        synchronized (this.lock) {
            this.bout.startLogicalBlock(prefix, false, suffix);
            this.bout.addIndentation((prefix == null) ? indent : (indent - prefix.length()), false);
        }
    }
    
    @Override
    public void endLogicalBlock(final String suffix) {
        this.bout.endLogicalBlock(suffix);
    }
    
    @Override
    public void writeBreak(final int kind) {
        this.bout.writeBreak(kind);
    }
    
    @Override
    public void writeSpace(final int kind) {
        synchronized (this.lock) {
            this.write(32);
            this.writeBreak(kind);
        }
    }
    
    @Override
    public void setIndentation(final int amount, final boolean current) {
        this.bout.addIndentation(amount, current);
    }
    
    static {
        OutPort.outInitial = BinaryOutPort.makeStandardPort(System.out, "/dev/stdout");
        OutPort.outInitial.flags = 1;
        OutPort.errInitial = BinaryOutPort.makeStandardPort(System.err, "/dev/stderr");
        OutPort.errInitial.flags = 1;
        (outLocation = new ThreadLocation<OutPort>("out-default")).setGlobal(OutPort.outInitial);
        (errLocation = new ThreadLocation<OutPort>("err-default")).setGlobal(OutPort.errInitial);
    }
}
