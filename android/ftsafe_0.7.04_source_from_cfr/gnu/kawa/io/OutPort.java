/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.io;

import gnu.kawa.format.AbstractFormat;
import gnu.kawa.format.Printable;
import gnu.kawa.io.BinaryOutPort;
import gnu.kawa.io.LogWriter;
import gnu.kawa.io.Path;
import gnu.kawa.io.PrettyWriter;
import gnu.kawa.io.WriterManager;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.mapping.Environment;
import gnu.mapping.ThreadLocation;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class OutPort
extends PrintConsumer
implements Printable {
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
    static BinaryOutPort outInitial = BinaryOutPort.makeStandardPort(System.out, "/dev/stdout");
    private static BinaryOutPort errInitial;
    public static final ThreadLocation<OutPort> outLocation;
    public static final ThreadLocation<OutPort> errLocation;
    static Writer logFile;

    protected OutPort(Writer base2, PrettyWriter out, boolean autoflush) {
        super(out, autoflush);
        this.bout = out;
        this.formatter = this.bout;
        this.base = base2;
        if (this.closeOnExit()) {
            this.unregisterRef = WriterManager.instance.register(this);
        }
    }

    protected OutPort(OutPort out, boolean autoflush) {
        this((Writer)out, out.bout, autoflush);
    }

    protected OutPort(Writer out, boolean autoflush) {
        this(out, out instanceof OutPort ? ((OutPort)out).bout : new PrettyWriter(out, true), autoflush);
    }

    public OutPort(Writer base2, boolean printPretty, boolean autoflush) {
        this(base2, new PrettyWriter(base2, printPretty), autoflush);
    }

    public OutPort(Writer base2, boolean printPretty, boolean autoflush, Path path) {
        this(base2, new PrettyWriter(base2, printPretty), autoflush);
        this.path = path;
    }

    public OutPort(OutputStream out) {
        this(out, null);
    }

    public OutPort(OutputStream out, Path path) {
        this((Writer)new OutputStreamWriter(out), true, path);
    }

    public OutPort(Writer out) {
        this(out, out instanceof OutPort ? ((OutPort)out).bout : new PrettyWriter(out, false), false);
    }

    public OutPort(Writer base2, Path path) {
        this(base2, false, false);
        this.path = path;
    }

    public OutPort(Writer base2, boolean autoflush, Path path) {
        this(base2, false, autoflush);
        this.path = path;
    }

    public static BinaryOutPort getSystemOut() {
        return outInitial;
    }

    public static BinaryOutPort getSystemErr() {
        return errInitial;
    }

    public static OutPort outDefault() {
        return outLocation.get();
    }

    public static void setOutDefault(OutPort o) {
        outLocation.set(o);
    }

    public static OutPort errDefault() {
        return errLocation.get();
    }

    public static void setErrDefault(OutPort e) {
        errLocation.set(e);
    }

    public boolean isPrettyPrinting() {
        return this.bout.isPrettyPrinting();
    }

    public static OutPort openFile(Object fname) throws IOException {
        return OutPort.openFile(fname, Environment.user().get("port-char-encoding"));
    }

    public static OutPort openFile(Object fname, Object conv) throws IOException {
        Path path = Path.valueOf(fname);
        OutputStream strm = path.openOutputStream();
        strm = new BufferedOutputStream(strm);
        OutPort op = conv == Boolean.FALSE ? new BinaryOutPort(strm, path) : new OutPort((Writer)(conv == null || conv == Boolean.TRUE ? new OutputStreamWriter(strm) : new OutputStreamWriter(strm, conv.toString())), path);
        op.flags = 2;
        return op;
    }

    public void echo(char[] buf, int off, int len) throws IOException {
        if (this.base instanceof LogWriter) {
            ((LogWriter)this.base).echo(buf, off, len);
        }
    }

    public static void closeLogFile() throws IOException {
        if (logFile != null) {
            logFile.close();
            logFile = null;
        }
        if (OutPort.outInitial.base instanceof LogWriter) {
            ((LogWriter)OutPort.outInitial.base).setLogFile((Writer)null);
        }
        if (OutPort.errInitial.base instanceof LogWriter) {
            ((LogWriter)OutPort.errInitial.base).setLogFile((Writer)null);
        }
    }

    public static void setLogFile(String name) throws IOException {
        if (logFile != null) {
            OutPort.closeLogFile();
        }
        logFile = new PrintWriter(new BufferedWriter(new FileWriter(name)));
        if (OutPort.outInitial.base instanceof LogWriter) {
            ((LogWriter)OutPort.outInitial.base).setLogFile(logFile);
        }
        if (OutPort.errInitial.base instanceof LogWriter) {
            ((LogWriter)OutPort.errInitial.base).setLogFile(logFile);
        }
    }

    protected static final boolean isWordChar(char ch) {
        return Character.isJavaIdentifierPart(ch) || ch == '-' || ch == '+';
    }

    @Override
    public void print(int v) {
        this.formatter.writeInt(v);
    }

    @Override
    public void print(long v) {
        this.formatter.writeLong(v);
    }

    @Override
    public void print(double v) {
        this.formatter.writeDouble(v);
    }

    @Override
    public void print(float v) {
        this.formatter.writeFloat(v);
    }

    @Override
    public void print(boolean v) {
        this.formatter.writeBoolean(v);
    }

    @Override
    public void print(String v) {
        this.write(v == null ? "(null)" : v);
    }

    @Override
    public void print(Object v) {
        this.formatter.writeObject(v);
    }

    @Override
    public void print(Consumer out) {
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
    public void startElement(Object type) {
        this.formatter.startElement(type);
    }

    @Override
    public void endElement() {
        this.formatter.endElement();
    }

    @Override
    public void startAttribute(Object attrType) {
        this.formatter.startAttribute(attrType);
    }

    @Override
    public void endAttribute() {
        this.formatter.endAttribute();
    }

    @Override
    public void write(char[] str, int start, int count) {
        this.formatter.write(str, start, count);
    }

    @Override
    public void write(String str) {
        this.formatter.write(str, 0, str.length());
    }

    @Override
    public void write(String str, int start, int count) {
        this.formatter.write(str, start, count);
    }

    @Override
    public void write(CharSequence str, int start, int count) {
        this.formatter.write(str, start, count);
    }

    @Override
    public void writeObject(Object v) {
        this.formatter.writeObject(v);
    }

    @Override
    public void writeComment(char[] chars, int offset, int length) {
        this.formatter.writeComment(chars, offset, length);
    }

    @Override
    public void writeProcessingInstruction(String target, char[] content, int offset, int length) {
        this.formatter.writeProcessingInstruction(target, content, offset, length);
    }

    @Override
    public void writeCDATA(char[] chars, int offset, int length) {
        this.formatter.writeCDATA(chars, offset, length);
    }

    @Override
    public void beginEntity(Object baseUri) {
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

    public Object pushFormat(AbstractFormat format) {
        PrintConsumer old = this.formatter;
        this.formatter = format.makeConsumer(this.formatter);
        return old;
    }

    public void popFormat(Object old) {
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

    public void setColumnNumber(int column) {
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
        return (this.flags & 4) == 0;
    }

    public boolean isDomTerm() {
        return (this.flags & 8) != 0;
    }

    public void setDomTerm(boolean v) {
        this.flags = v ? (this.flags |= 8) : (this.flags &= -9);
        this.bout.isDomTerm = v;
    }

    public static OutPort getPassThroughOutPort(Consumer out) {
        OutPort port = null;
        do {
            if (out instanceof OutPort) {
                port = (OutPort)out;
                PrintConsumer formatter = port.formatter;
                if (formatter instanceof PrettyWriter) {
                    return port;
                }
                out = formatter;
                continue;
            }
            if (!(out instanceof AbstractFormat.FormatConsumer)) break;
            AbstractFormat.FormatConsumer fcons = (AbstractFormat.FormatConsumer)out;
            if (!fcons.getFormat().textIsCopied()) {
                return null;
            }
            out = fcons.getBase();
        } while (true);
        return port;
    }

    @Override
    public void close() {
        try {
            if (this.base instanceof OutPort && ((OutPort)this.base).bout == this.bout) {
                this.base.close();
                this.base = null;
            } else if (this.out != null) {
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
        if ((this.flags & 1) != 0) {
            this.flush();
        }
        if ((this.flags & 2) != 0) {
            this.close();
        } else {
            this.closeThis();
        }
    }

    public static void runCleanups() {
        WriterManager.instance.run();
    }

    public void setPrettyPrinting(boolean mode) {
        this.bout.setPrettyPrinting(mode);
    }

    @Override
    public void startLogicalBlock(String prefix, boolean perLine, String suffix) {
        this.bout.startLogicalBlock(prefix, perLine, suffix);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void startLogicalBlock(String prefix, String suffix, int indent) {
        Object object2 = this.lock;
        synchronized (object2) {
            this.bout.startLogicalBlock(prefix, false, suffix);
            this.bout.addIndentation(prefix == null ? indent : indent - prefix.length(), false);
        }
    }

    @Override
    public void endLogicalBlock(String suffix) {
        this.bout.endLogicalBlock(suffix);
    }

    @Override
    public void writeBreak(int kind) {
        this.bout.writeBreak(kind);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void writeSpace(int kind) {
        Object object2 = this.lock;
        synchronized (object2) {
            this.write(32);
            this.writeBreak(kind);
        }
    }

    @Override
    public void setIndentation(int amount, boolean current) {
        this.bout.addIndentation(amount, current);
    }

    static {
        OutPort.outInitial.flags = 1;
        errInitial = BinaryOutPort.makeStandardPort(System.err, "/dev/stderr");
        OutPort.errInitial.flags = 1;
        outLocation = new ThreadLocation("out-default");
        outLocation.setGlobal(outInitial);
        errLocation = new ThreadLocation("err-default");
        errLocation.setGlobal(errInitial);
    }
}

