// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Values;
import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.ModuleInfo;
import kawa.standard.read_line;
import gnu.text.SyntaxException;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.functions.AddOp;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.io.PrettyWriter;
import gnu.kawa.functions.DisplayFormat;
import java.io.Serializable;
import java.io.Externalizable;
import java.io.InputStream;
import kawa.standard.char_ready_p;
import gnu.lists.EofClass;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import gnu.lists.FString;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.CharArrayInPort;
import gnu.lists.U8Vector;
import gnu.text.Char;
import kawa.SourceMethodType;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import java.io.Writer;
import java.io.Reader;
import java.io.Closeable;
import gnu.kawa.io.BinaryOutPort;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.Path;
import gnu.lists.Consumer;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Location;
import gnu.mapping.Symbol;
import gnu.mapping.CallContext;
import gnu.math.IntNum;
import gnu.expr.Keyword;
import gnu.bytecode.ClassType;
import gnu.mapping.SimpleSymbol;
import gnu.expr.GenericProc;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.InPort;
import gnu.mapping.LocationProc;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class ports extends ModuleBody
{
    public static final ModuleMethod open$Mninput$Mnfile;
    public static final ModuleMethod open$Mnbinary$Mninput$Mnfile;
    public static final ModuleMethod open$Mnoutput$Mnfile;
    public static final ModuleMethod open$Mnbinary$Mnoutput$Mnfile;
    public static final ModuleMethod call$Mnwith$Mnport;
    public static final ModuleMethod call$Mnwith$Mninput$Mnfile;
    public static final ModuleMethod call$Mnwith$Mnoutput$Mnfile;
    public static final ModuleMethod with$Mninput$Mnfrom$Mnfile;
    public static final ModuleMethod with$Mnoutput$Mnto$Mnfile;
    public static final ModuleMethod input$Mnport$Qu;
    public static final ModuleMethod output$Mnport$Qu;
    public static final ModuleMethod textual$Mnport$Qu;
    public static final ModuleMethod binary$Mnport$Qu;
    public static final ModuleMethod port$Qu;
    public static final ModuleMethod input$Mnport$Mnopen$Qu;
    public static final ModuleMethod output$Mnport$Mnopen$Qu;
    public static final LocationProc<InPort> current$Mninput$Mnport;
    public static final LocationProc<OutPort> current$Mnoutput$Mnport;
    public static final LocationProc<OutPort> current$Mnerror$Mnport;
    public static final LocationProc current$Mnpath;
    public static final ModuleMethod write$Mnchar;
    public static final ModuleMethod write$Mnstring;
    public static final ModuleMethod write$Mnu8;
    public static final ModuleMethod write$Mnbytevector;
    public static final ModuleMethod open$Mninput$Mnstring;
    public static final ModuleMethod open$Mnoutput$Mnstring;
    public static final ModuleMethod get$Mnoutput$Mnstring;
    public static final ModuleMethod open$Mninput$Mnbytevector;
    public static final ModuleMethod open$Mnoutput$Mnbytevector;
    public static final ModuleMethod get$Mnoutput$Mnbytevector;
    public static final ModuleMethod call$Mnwith$Mninput$Mnstring;
    public static final ModuleMethod call$Mnwith$Mnoutput$Mnstring;
    public static final ModuleMethod flush$Mnoutput$Mnport;
    public static final ModuleMethod force$Mnoutput;
    public static final ModuleMethod newline;
    public static final ModuleMethod eof$Mnobject$Qu;
    public static final ModuleMethod eof$Mnobject;
    public static final ModuleMethod char$Mnready$Qu;
    public static final ModuleMethod read$Mnchar;
    public static final ModuleMethod peek$Mnchar;
    public static final ModuleMethod read$Mnstring;
    public static final ModuleMethod read$Mnu8;
    public static final ModuleMethod peek$Mnu8;
    public static final ModuleMethod u8$Mnready$Qu;
    public static final ModuleMethod read$Mnbytevector;
    public static final ModuleMethod read$Mnbytevector$Ex;
    public static final ModuleMethod write$Mnsimple;
    public static final ModuleMethod write;
    public static final ModuleMethod write$Mnshared;
    public static final ModuleMethod write$Mnwith$Mnshared$Mnstructure;
    public static final ModuleMethod display;
    public static final ModuleMethod input$Mnport$Mnread$Mnstate;
    public static final ModuleMethod set$Mnport$Mnline$Ex;
    public static final GenericProc port$Mnline;
    public static final ModuleMethod set$Mninput$Mnport$Mnline$Mnnumber$Ex;
    public static final GenericProc input$Mnport$Mnline$Mnnumber;
    public static final ModuleMethod port$Mncolumn;
    public static final ModuleMethod input$Mnport$Mncolumn$Mnnumber;
    public static final ModuleMethod set$Mninput$Mnport$Mnprompter$Ex;
    public static final GenericProc input$Mnport$Mnprompter;
    public static final ModuleMethod close$Mnport;
    public static final ModuleMethod close$Mninput$Mnport;
    public static final ModuleMethod close$Mnoutput$Mnport;
    public static final ModuleMethod read;
    public static final ModuleMethod read$Mnline;
    public static final ModuleMethod transcript$Mnon;
    public static final ModuleMethod transcript$Mnoff;
    static final SimpleSymbol Lit0;
    static final ModuleMethod lambda$Fn1;
    static final ClassType Lit1;
    static final SimpleSymbol Lit2;
    static final ModuleMethod lambda$Fn2;
    static final ClassType Lit3;
    static final SimpleSymbol Lit4;
    static final ModuleMethod lambda$Fn3;
    static final SimpleSymbol Lit5;
    static final Keyword Lit6;
    static final ModuleMethod port$Mnline$Fn4;
    static final IntNum Lit7;
    static final ModuleMethod input$Mnport$Mnline$Mnnumber$Fn5;
    static final ModuleMethod input$Mnport$Mnprompter$Fn6;
    static final SimpleSymbol Lit8;
    public static ports $instance;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        (current$Mninput$Mnport = LocationProc.makeNamed(ports.Lit0, InPort.inLocation)).pushConverter(ports.lambda$Fn1);
        (current$Mnoutput$Mnport = LocationProc.makeNamed(ports.Lit2, OutPort.outLocation)).pushConverter(ports.lambda$Fn2);
        (current$Mnerror$Mnport = LocationProc.makeNamed(ports.Lit4, OutPort.errLocation)).pushConverter(ports.lambda$Fn3);
        current$Mnpath = LocationProc.makeNamed(ports.Lit5, new 0());
        ports.port$Mnline.setProperty(ports.Lit6, ports.set$Mnport$Mnline$Ex);
        final GenericProc port$Mnline2 = ports.port$Mnline;
        final Procedure port$Mnline = ports.port$Mnline$Fn4;
        port$Mnline2.add(ports.port$Mnline$Fn4);
        ports.input$Mnport$Mnline$Mnnumber.setProperty(ports.Lit6, ports.set$Mninput$Mnport$Mnline$Mnnumber$Ex);
        final GenericProc input$Mnport$Mnline$Mnnumber2 = ports.input$Mnport$Mnline$Mnnumber;
        final Procedure input$Mnport$Mnline$Mnnumber = ports.input$Mnport$Mnline$Mnnumber$Fn5;
        input$Mnport$Mnline$Mnnumber2.add(ports.input$Mnport$Mnline$Mnnumber$Fn5);
        ports.input$Mnport$Mnprompter.setProperty(ports.Lit6, ports.set$Mninput$Mnport$Mnprompter$Ex);
        final GenericProc input$Mnport$Mnprompter2 = ports.input$Mnport$Mnprompter;
        final Procedure input$Mnport$Mnprompter = ports.input$Mnport$Mnprompter$Fn6;
        input$Mnport$Mnprompter2.add(ports.input$Mnport$Mnprompter$Fn6);
    }
    
    public static InPort openInputFile(final Path name) {
        return InPort.openFile(name);
    }
    
    public static BinaryInPort openBinaryInputFile(final Path name) {
        return BinaryInPort.openFile(name);
    }
    
    public static OutPort openOutputFile(final Path name) {
        return OutPort.openFile(name);
    }
    
    public static BinaryOutPort openBinaryOutputFile(final Path name) {
        return BinaryOutPort.openFile(name);
    }
    
    public static Object callWithPort(final Closeable port, final Procedure proc) {
        Object apply1;
        try {
            apply1 = proc.apply1(port);
        }
        finally {
            closePort(port);
        }
        return apply1;
    }
    
    public static void closePort(final Closeable port) {
        port.close();
    }
    
    public static Object callWithInputFile(final Path path, final Procedure proc) {
        final InPort port = openInputFile(path);
        Object apply1;
        try {
            apply1 = proc.apply1(port);
        }
        finally {
            closeInputPort(port);
        }
        return apply1;
    }
    
    public static void closeInputPort(final Reader port) {
        port.close();
    }
    
    public static Object callWithOutputFile(final Path path, final Procedure proc) {
        final OutPort port = openOutputFile(path);
        Object apply1;
        try {
            apply1 = proc.apply1(port);
        }
        finally {
            closeOutputPort(port);
        }
        return apply1;
    }
    
    public static void closeOutputPort(final Writer port) {
        port.close();
    }
    
    public static Object withInputFromFile(final Path pathname, final Procedure proc) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/io/InPort.openFile:(Ljava/lang/Object;)Lgnu/kawa/io/InPort;
        //     4: astore_2       
        //     5: invokestatic    gnu/kawa/io/InPort.inDefault:()Lgnu/kawa/io/InPort;
        //     8: astore_3        /* save */
        //     9: aload_2         /* port */
        //    10: invokestatic    gnu/kawa/io/InPort.setInDefault:(Lgnu/kawa/io/InPort;)V
        //    13: aload_1         /* proc */
        //    14: invokevirtual   gnu/mapping/Procedure.apply0:()Ljava/lang/Object;
        //    17: astore          4
        //    19: jsr             33
        //    22: goto            45
        //    25: astore          5
        //    27: jsr             33
        //    30: aload           5
        //    32: athrow         
        //    33: astore          6
        //    35: aload_3         /* save */
        //    36: invokestatic    gnu/kawa/io/InPort.setInDefault:(Lgnu/kawa/io/InPort;)V
        //    39: aload_2         /* port */
        //    40: invokevirtual   gnu/kawa/io/InPort.close:()V
        //    43: ret             6
        //    45: aload           4
        //    47: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  9      25     25     33     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object withOutputToFile(final Path path, final Procedure proc) {
        final OutPort port = OutPort.openFile(path);
        final OutPort save = OutPort.outDefault();
        Object apply0;
        try {
            OutPort.setOutDefault(port);
            apply0 = proc.apply0();
        }
        finally {
            OutPort.setOutDefault(save);
            port.close();
        }
        return apply0;
    }
    
    public static boolean isInputPort(final Object x) {
        return x instanceof InPort;
    }
    
    public static boolean isOutputPort(final Object x) {
        return x instanceof OutPort;
    }
    
    public static boolean isTextualPort(final Object obj) {
        final boolean x = isInputPort(obj);
        return x ? x : isOutputPort(obj);
    }
    
    public static boolean isBinaryPort(final Object obj) {
        final boolean x = obj instanceof BinaryInPort;
        return x ? x : (obj instanceof BinaryOutPort);
    }
    
    public static boolean isPort(final Object x) {
        final boolean x2 = isInputPort(x);
        return x2 ? x2 : isOutputPort(x);
    }
    
    public static boolean isInputPortOpen(final Object port) {
        return !(port instanceof OutPort) && ((InPort)Promise.force(port, InPort.class)).isOpen();
    }
    
    public static boolean isOutputPortOpen(final Object port) {
        return !(port instanceof InPort) && ((OutPort)Promise.force(port, OutPort.class)).isOpen();
    }
    
    static InPort lambda1(final Object arg) {
        InPort inPort;
        try {
            inPort = (InPort)Promise.force(arg, InPort.class);
        }
        catch (ClassCastException ex) {
            final WrongType wt = WrongType.make(ex, ports.current$Mninput$Mnport, 1, arg);
            wt.expectedType = ports.Lit1;
            throw wt;
        }
        return inPort;
    }
    
    static OutPort lambda2(final Object arg) {
        OutPort outPort;
        try {
            outPort = (OutPort)Promise.force(arg, OutPort.class);
        }
        catch (ClassCastException ex) {
            final WrongType wt = WrongType.make(ex, ports.current$Mnoutput$Mnport, 1, arg);
            wt.expectedType = ports.Lit3;
            throw wt;
        }
        return outPort;
    }
    
    static OutPort lambda3(final Object arg) {
        OutPort outPort;
        try {
            outPort = (OutPort)Promise.force(arg, OutPort.class);
        }
        catch (ClassCastException ex) {
            final WrongType wt = WrongType.make(ex, ports.current$Mnerror$Mnport, 1, arg);
            wt.expectedType = ports.Lit3;
            throw wt;
        }
        return outPort;
    }
    
    @SourceMethodType({ "", "character" })
    public static void writeChar(final int ch) {
        writeChar(ch, OutPort.outDefault());
    }
    
    @SourceMethodType({ "", "character" })
    public static void writeChar(final int ch, final Appendable port) {
        Char.append(ch, port);
    }
    
    public static void writeString(final CharSequence charSequence) {
        writeString(charSequence, ports.current$Mnoutput$Mnport.getValue(), 0);
    }
    
    public static void writeString(final CharSequence charSequence, final Appendable appendable) {
        writeString(charSequence, appendable, 0);
    }
    
    public static void writeString(final CharSequence str, final Appendable port, final int start) {
        writeString(str, port, start, str.length());
    }
    
    public static void writeString(final CharSequence str, final Appendable port, final int start, final int end) {
        port.append(str, start, end);
    }
    
    public static void writeU8(final int byte1) {
        writeU8(byte1, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void writeU8(final int byte, final Object port) {
        BinaryOutPort.asOutputStream(port).write(byte);
    }
    
    public static void writeBytevector(final U8Vector u8Vector) {
        writeBytevector(u8Vector, ports.current$Mnoutput$Mnport.getValue(), 0);
    }
    
    public static void writeBytevector(final U8Vector u8Vector, final Object o) {
        writeBytevector(u8Vector, o, 0);
    }
    
    public static void writeBytevector(final U8Vector bytes, final Object port, final int start) {
        writeBytevector(bytes, port, start, bytes.size());
    }
    
    public static void writeBytevector(final U8Vector bytes, final Object port, final int start, final int end) {
        bytes.writeTo(start, end - start, BinaryOutPort.asOutputStream(port));
    }
    
    public static CharArrayInPort openInputString(final CharSequence str) {
        return CharArrayInPort.make(str);
    }
    
    public static CharArrayOutPort openOutputString() {
        return new CharArrayOutPort();
    }
    
    public static FString getOutputString(final CharArrayOutPort output$Mnport) {
        return new FString(output$Mnport.toCharArray());
    }
    
    public static BinaryInPort openInputBytevector(final U8Vector bvector) {
        final BinaryInPort p = new BinaryInPort(bvector.getBuffer(), bvector.size(), Path.valueOf("<bytevector>"));
        p.setCharset("ISO-8859-1");
        return p;
    }
    
    public static BinaryOutPort openOutputBytevector() {
        final ByteArrayOutputStream bo = new ByteArrayOutputStream();
        return new BinaryOutPort(bo, Path.valueOf("<bytevector>"));
    }
    
    public static U8Vector getOutputBytevector(final BinaryOutPort port) {
        final OutputStream outputStream = port.getOutputStream();
        try {
            final ByteArrayOutputStream bo = (ByteArrayOutputStream)outputStream;
            return new U8Vector(bo.toByteArray());
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "bo", -2, outputStream);
        }
    }
    
    public static Object callWithInputString(final CharSequence str, final Procedure proc) {
        final CharArrayInPort port = CharArrayInPort.make(str);
        final Object result = proc.apply1(port);
        closeInputPort(port);
        return result;
    }
    
    public static FString callWithOutputString(final Procedure proc) {
        final CharArrayOutPort port = new CharArrayOutPort();
        proc.apply1(port);
        final char[] chars = port.toCharArray();
        port.close();
        return new FString(chars);
    }
    
    public static void flushOutputPort() {
        flushOutputPort(ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void flushOutputPort(final Object port) {
        if (port instanceof OutputStream) {
            ((OutputStream)Promise.force(port, OutputStream.class)).flush();
        }
        else {
            ((Writer)Promise.force(port, Writer.class)).flush();
        }
    }
    
    public static void forceOutput() {
        forceOutput(ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void forceOutput(final Object port) {
        if (port instanceof OutputStream) {
            ((OutputStream)Promise.force(port, OutputStream.class)).flush();
        }
        else {
            ((Writer)Promise.force(port, Writer.class)).flush();
        }
    }
    
    public static void newline() {
        newline(ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void newline(final Object port) {
        final Object force = Promise.force(port, OutPort.class);
        try {
            ((OutPort)force).println();
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.kawa.io.OutPort.println()", 1, force);
        }
    }
    
    public static boolean isEofObject(final Object obj) {
        return Promise.force(obj) == EofClass.eofValue;
    }
    
    public static EofClass eofObject() {
        return EofClass.eofValue;
    }
    
    public static boolean isCharReady() {
        return isCharReady(ports.current$Mninput$Mnport.getValue());
    }
    
    public static boolean isCharReady(final Object port) {
        return char_ready_p.ready(port);
    }
    
    @SourceMethodType({ "character-or-eof" })
    public static int readChar() {
        return readChar(ports.current$Mninput$Mnport.getValue());
    }
    
    @SourceMethodType({ "character-or-eof" })
    public static int readChar(final Object port) {
        return (port instanceof InputStream) ? ((InputStream)Promise.force(port, InputStream.class)).read() : ((InPort)Promise.force(port, InPort.class)).readCodePoint();
    }
    
    @SourceMethodType({ "character-or-eof" })
    public static int peekChar() {
        return peekChar(ports.current$Mninput$Mnport.getValue());
    }
    
    @SourceMethodType({ "character-or-eof" })
    public static int peekChar(final Object port) {
        Label_0038: {
            if (!(port instanceof InputStream)) {
                break Label_0038;
            }
            final Object force = Promise.force(port, InputStream.class);
            try {
                final InputStream is = (InputStream)force;
                is.mark(1);
                final int ch = is.read();
                is.reset();
                return ch;
                peekCodePoint = ((InPort)Promise.force(port, InPort.class)).peekCodePoint();
                return peekCodePoint;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "is", -2, force);
            }
        }
    }
    
    public static Object readString(final int k) {
        return readString(k, ports.current$Mninput$Mnport.getValue());
    }
    
    public static Object readString(final int k, final InPort port) {
        final char[] arr = new char[k];
        int n2 = 0;
        Externalizable externalizable;
        while (true) {
            final int seen = n2;
            final int m = k - seen;
            final int n = port.read(arr, seen, m);
            if (n < 0) {
                externalizable = ((seen > 0) ? new FString(arr, 0, seen) : EofClass.eofValue);
                break;
            }
            if (n == m) {
                externalizable = new FString(arr);
                break;
            }
            n2 = seen + n;
        }
        return externalizable;
    }
    
    public static Object readU8() {
        return readU8(ports.current$Mninput$Mnport.getValue());
    }
    
    public static Object readU8(final Object port) {
        final int b = (port instanceof BinaryInPort) ? ((BinaryInPort)Promise.force(port, BinaryInPort.class)).readByte() : ((InputStream)Promise.force(port, InputStream.class)).read();
        return (b < 0) ? EofClass.eofValue : Integer.valueOf(b);
    }
    
    public static Object peekU8() {
        return peekU8(ports.current$Mninput$Mnport.getValue());
    }
    
    public static Object peekU8(final Object port) {
        Label_0050: {
            if (port instanceof BinaryInPort) {
                final int peekByte = ((BinaryInPort)Promise.force(port, BinaryInPort.class)).peekByte();
                break Label_0050;
            }
            final Object force = Promise.force(port, InputStream.class);
            try {
                final InputStream ins = (InputStream)force;
                ins.mark(1);
                final int b = ins.read();
                ins.reset();
                final int peekByte = b;
                final int b2 = peekByte;
                return (b2 < 0) ? EofClass.eofValue : Integer.valueOf(b2);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "ins", -2, force);
            }
        }
    }
    
    public static boolean isU8Ready() {
        return isU8Ready(ports.current$Mninput$Mnport.getValue());
    }
    
    public static boolean isU8Ready(final Object port) {
        return (port instanceof BinaryInPort) ? ((BinaryInPort)Promise.force(port, BinaryInPort.class)).ready() : (((InputStream)Promise.force(port, InputStream.class)).available() > 0);
    }
    
    public static Object readBytevector(final int k) {
        return readBytevector(k, ports.current$Mninput$Mnport.getValue());
    }
    
    public static Object readBytevector(final int k, final Object port) {
        final byte[] arr = new byte[k];
        int n2 = 0;
        Externalizable externalizable;
        while (true) {
            final int seen = n2;
            final int m = k - seen;
            final int n = (port instanceof BinaryInPort) ? ((BinaryInPort)Promise.force(port, BinaryInPort.class)).readBytes(arr, seen, m) : ((InputStream)Promise.force(port, InputStream.class)).read(arr, seen, m);
            if (n < 0) {
                externalizable = ((seen > 0) ? new U8Vector(arr, 0, seen) : EofClass.eofValue);
                break;
            }
            if (n == m) {
                externalizable = new U8Vector(arr);
                break;
            }
            n2 = seen + n;
        }
        return externalizable;
    }
    
    public static Object readBytevector$Ex(final U8Vector u8Vector) {
        return readBytevector$Ex(u8Vector, ports.current$Mninput$Mnport.getValue(), 0);
    }
    
    public static Object readBytevector$Ex(final U8Vector u8Vector, final Object o) {
        return readBytevector$Ex(u8Vector, o, 0);
    }
    
    public static Object readBytevector$Ex(final U8Vector bv, final Object port, final int start) {
        return readBytevector$Ex(bv, port, start, bv.size());
    }
    
    public static Object readBytevector$Ex(final U8Vector bv, final Object port, final int start, final int end) {
        int n2 = 0;
        while (true) {
            final int seen = n2;
            final int want = end - start - seen;
            Label_0046: {
                if (port instanceof BinaryInPort) {
                    final InputStream inputStream = ((BinaryInPort)Promise.force(port, BinaryInPort.class)).getInputStream();
                    break Label_0046;
                }
                final Object force = Promise.force(port, InputStream.class);
                try {
                    final InputStream inputStream = (InputStream)force;
                    final InputStream is = inputStream;
                    final int n = bv.readFrom(start + seen, want, is);
                    Serializable value;
                    if (n < 0) {
                        value = ((seen > 0) ? Integer.valueOf(seen) : EofClass.eofValue);
                    }
                    else {
                        if (n != want) {
                            n2 = seen + n;
                            continue;
                        }
                        value = seen + n;
                    }
                    return value;
                }
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "is", -2, force);
                }
            }
        }
    }
    
    public static void writeSimple(final Object value) {
        writeSimple(value, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void writeSimple(final Object value, final OutPort out) {
        DisplayFormat.schemeWriteSimpleFormat.format(value, out);
    }
    
    public static void write(final Object value) {
        write(value, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void write(final Object value, final OutPort out) {
        final ThreadLocation isSharing = PrettyWriter.isSharing;
        try {
            (IsEqv.apply(isSharing.get(), Boolean.TRUE) ? DisplayFormat.schemeWriteSharedFormat : DisplayFormat.schemeWriteFormat).format(value, out);
        }
        catch (UnboundLocationException ex) {
            ex.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/ports.scm", 289, 14);
            throw ex;
        }
    }
    
    public static void writeShared(final Object value) {
        writeShared(value, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void writeShared(final Object value, final OutPort out) {
        DisplayFormat.schemeWriteSharedFormat.format(value, out);
    }
    
    public static void writeWithSharedStructure(final Object value) {
        writeWithSharedStructure(value, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void writeWithSharedStructure(final Object value, final OutPort out) {
        DisplayFormat.schemeWriteSharedFormat.format(value, out);
    }
    
    public static void display(final Object value) {
        display(value, ports.current$Mnoutput$Mnport.getValue());
    }
    
    public static void display(final Object value, final Object out) {
        final DisplayFormat schemeDisplayFormat = DisplayFormat.schemeDisplayFormat;
        final Object force = Promise.force(out, Consumer.class);
        try {
            schemeDisplayFormat.format(value, (Consumer)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.kawa.functions.DisplayFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, force);
        }
    }
    
    public static char inputPortReadState(final Object port) {
        final Object force = Promise.force(port, InPort.class);
        try {
            return ((InPort)force).getReadState();
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.kawa.io.InPort.getReadState()", 1, force);
        }
    }
    
    public static void setPortLine$Ex(final InPort port, final int line) {
        port.setLineNumber(line);
    }
    
    public static int portLine(final InPort port) {
        return port.getLineNumber();
    }
    
    public static void setInputPortLineNumber$Ex(final Object port, final Object num) {
        Object o2;
        final Object o = o2 = Promise.force(port, InPort.class);
        InPort inPort;
        Object o3;
        try {
            inPort = (InPort)o;
            o3 = (o2 = Promise.force(AddOp.apply2(-1, num, ports.Lit7)));
            final Number n = (Number)o3;
            final int n2 = n.intValue();
            setPortLine$Ex(inPort, n2);
            return;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "set-port-line!", 0, o2);
        }
        try {
            final Number n = (Number)o3;
            final int n2 = n.intValue();
            setPortLine$Ex(inPort, n2);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "set-port-line!", 1, o2);
        }
    }
    
    public static Object inputPortLineNumber(final InPort port) {
        return AddOp.apply2(1, ports.Lit7, ports.port$Mnline.apply1(port));
    }
    
    public static int portColumn(final InPort port) {
        return port.getColumnNumber();
    }
    
    public static int inputPortColumnNumber(final Object port) {
        final int n = 1;
        final Object force = Promise.force(port, InPort.class);
        try {
            return n + portColumn((InPort)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "port-column", 0, force);
        }
    }
    
    public static void setInputPortPrompter$Ex(final TtyInPort port, final Procedure prompter) {
        port.setPrompter(prompter);
    }
    
    public static Procedure inputPortPrompter(final TtyInPort port) {
        return port.getPrompter();
    }
    
    public static Object read() {
        return read(ports.current$Mninput$Mnport.getValue());
    }
    
    public static Object read(final InPort port) {
        final LispReader lexer = new LispReader(port);
        lexer.setReturnMutablePairs(true);
        Object o;
        try {
            final Object object = lexer.readObject();
            if (lexer.seenErrors()) {
                throw new SyntaxException(lexer.getMessages());
            }
            o = object;
        }
        catch (SyntaxException ex) {
            ex.setHeader("syntax error in read:");
            throw ex;
        }
        return o;
    }
    
    public static Object readLine() {
        return readLine(ports.current$Mninput$Mnport.getValue(), ports.Lit8);
    }
    
    public static Object readLine(final InPort port) {
        return readLine(port, ports.Lit8);
    }
    
    public static Object readLine(final InPort port, final Symbol handling) {
        return read_line.apply(port, handling.toString());
    }
    
    public static void transcriptOn(final Object filename) {
        OutPort.setLogFile(filename.toString());
    }
    
    public static void transcriptOff() {
        OutPort.closeLogFile();
    }
    
    static {
        Lit71 = Symbol.valueOf("transcript-off");
        Lit70 = Symbol.valueOf("transcript-on");
        Lit69 = Symbol.valueOf("read-line");
        Lit68 = Symbol.valueOf("read");
        Lit67 = Symbol.valueOf("close-output-port");
        Lit66 = Symbol.valueOf("close-input-port");
        Lit65 = Symbol.valueOf("close-port");
        Lit64 = Symbol.valueOf("input-port-prompter");
        Lit63 = Symbol.valueOf("set-input-port-prompter!");
        Lit62 = Symbol.valueOf("input-port-column-number");
        Lit61 = Symbol.valueOf("port-column");
        Lit60 = Symbol.valueOf("input-port-line-number");
        Lit59 = Symbol.valueOf("set-input-port-line-number!");
        Lit58 = Symbol.valueOf("port-line");
        Lit57 = Symbol.valueOf("set-port-line!");
        Lit56 = Symbol.valueOf("input-port-read-state");
        Lit55 = Symbol.valueOf("display");
        Lit54 = Symbol.valueOf("write-with-shared-structure");
        Lit53 = Symbol.valueOf("write-shared");
        Lit52 = Symbol.valueOf("write");
        Lit51 = Symbol.valueOf("write-simple");
        Lit50 = Symbol.valueOf("read-bytevector!");
        Lit49 = Symbol.valueOf("read-bytevector");
        Lit48 = Symbol.valueOf("u8-ready?");
        Lit47 = Symbol.valueOf("peek-u8");
        Lit46 = Symbol.valueOf("read-u8");
        Lit45 = Symbol.valueOf("read-string");
        Lit44 = Symbol.valueOf("peek-char");
        Lit43 = Symbol.valueOf("read-char");
        Lit42 = Symbol.valueOf("char-ready?");
        Lit41 = Symbol.valueOf("eof-object");
        Lit40 = Symbol.valueOf("eof-object?");
        Lit39 = Symbol.valueOf("newline");
        Lit38 = Symbol.valueOf("force-output");
        Lit37 = Symbol.valueOf("flush-output-port");
        Lit36 = Symbol.valueOf("call-with-output-string");
        Lit35 = Symbol.valueOf("call-with-input-string");
        Lit34 = Symbol.valueOf("get-output-bytevector");
        Lit33 = Symbol.valueOf("open-output-bytevector");
        Lit32 = Symbol.valueOf("open-input-bytevector");
        Lit31 = Symbol.valueOf("get-output-string");
        Lit30 = Symbol.valueOf("open-output-string");
        Lit29 = Symbol.valueOf("open-input-string");
        Lit28 = Symbol.valueOf("write-bytevector");
        Lit27 = Symbol.valueOf("write-u8");
        Lit26 = Symbol.valueOf("write-string");
        Lit25 = Symbol.valueOf("write-char");
        Lit24 = Symbol.valueOf("output-port-open?");
        Lit23 = Symbol.valueOf("input-port-open?");
        Lit22 = Symbol.valueOf("port?");
        Lit21 = Symbol.valueOf("binary-port?");
        Lit20 = Symbol.valueOf("textual-port?");
        Lit19 = Symbol.valueOf("output-port?");
        Lit18 = Symbol.valueOf("input-port?");
        Lit17 = Symbol.valueOf("with-output-to-file");
        Lit16 = Symbol.valueOf("with-input-from-file");
        Lit15 = Symbol.valueOf("call-with-output-file");
        Lit14 = Symbol.valueOf("call-with-input-file");
        Lit13 = Symbol.valueOf("call-with-port");
        Lit12 = Symbol.valueOf("open-binary-output-file");
        Lit11 = Symbol.valueOf("open-output-file");
        Lit10 = Symbol.valueOf("open-binary-input-file");
        Lit9 = Symbol.valueOf("open-input-file");
        Lit8 = Symbol.valueOf("trim");
        Lit7 = IntNum.valueOf(1);
        Lit6 = Keyword.make("setter");
        Lit5 = Symbol.valueOf("current-path");
        Lit4 = Symbol.valueOf("current-error-port");
        Lit3 = ClassType.make("gnu.kawa.io.OutPort");
        Lit2 = Symbol.valueOf("current-output-port");
        Lit1 = ClassType.make("gnu.kawa.io.InPort");
        Lit0 = Symbol.valueOf("current-input-port");
        ports.$instance = new ports();
        final ports $instance = ports.$instance;
        open$Mninput$Mnfile = new ModuleMethod($instance, 1, ports.Lit9, 4097);
        open$Mnbinary$Mninput$Mnfile = new ModuleMethod($instance, 2, ports.Lit10, 4097);
        open$Mnoutput$Mnfile = new ModuleMethod($instance, 3, ports.Lit11, 4097);
        open$Mnbinary$Mnoutput$Mnfile = new ModuleMethod($instance, 4, ports.Lit12, 4097);
        call$Mnwith$Mnport = new ModuleMethod($instance, 5, ports.Lit13, 8194);
        call$Mnwith$Mninput$Mnfile = new ModuleMethod($instance, 6, ports.Lit14, 8194);
        call$Mnwith$Mnoutput$Mnfile = new ModuleMethod($instance, 7, ports.Lit15, 8194);
        with$Mninput$Mnfrom$Mnfile = new ModuleMethod($instance, 8, ports.Lit16, 8194);
        with$Mnoutput$Mnto$Mnfile = new ModuleMethod($instance, 9, ports.Lit17, 8194);
        input$Mnport$Qu = new ModuleMethod($instance, 10, ports.Lit18, 4097);
        output$Mnport$Qu = new ModuleMethod($instance, 11, ports.Lit19, 4097);
        textual$Mnport$Qu = new ModuleMethod($instance, 12, ports.Lit20, 4097);
        binary$Mnport$Qu = new ModuleMethod($instance, 13, ports.Lit21, 4097);
        port$Qu = new ModuleMethod($instance, 14, ports.Lit22, 4097);
        input$Mnport$Mnopen$Qu = new ModuleMethod($instance, 15, ports.Lit23, 4097);
        output$Mnport$Mnopen$Qu = new ModuleMethod($instance, 16, ports.Lit24, 4097);
        lambda$Fn1 = new ModuleMethod($instance, 17, null, 4097);
        lambda$Fn2 = new ModuleMethod($instance, 18, null, 4097);
        lambda$Fn3 = new ModuleMethod($instance, 19, null, 4097);
        write$Mnchar = new ModuleMethod($instance, 20, ports.Lit25, 8193);
        write$Mnstring = new ModuleMethod($instance, 22, ports.Lit26, 16385);
        write$Mnu8 = new ModuleMethod($instance, 26, ports.Lit27, 8193);
        write$Mnbytevector = new ModuleMethod($instance, 28, ports.Lit28, 16385);
        open$Mninput$Mnstring = new ModuleMethod($instance, 32, ports.Lit29, 4097);
        open$Mnoutput$Mnstring = new ModuleMethod($instance, 33, ports.Lit30, 0);
        get$Mnoutput$Mnstring = new ModuleMethod($instance, 34, ports.Lit31, 4097);
        open$Mninput$Mnbytevector = new ModuleMethod($instance, 35, ports.Lit32, 4097);
        open$Mnoutput$Mnbytevector = new ModuleMethod($instance, 36, ports.Lit33, 0);
        get$Mnoutput$Mnbytevector = new ModuleMethod($instance, 37, ports.Lit34, 4097);
        call$Mnwith$Mninput$Mnstring = new ModuleMethod($instance, 38, ports.Lit35, 8194);
        call$Mnwith$Mnoutput$Mnstring = new ModuleMethod($instance, 39, ports.Lit36, 4097);
        flush$Mnoutput$Mnport = new ModuleMethod($instance, 40, ports.Lit37, 4096);
        force$Mnoutput = new ModuleMethod($instance, 42, ports.Lit38, 4096);
        newline = new ModuleMethod($instance, 44, ports.Lit39, 4096);
        final ModuleMethod eof$Mnobject$Qu2 = new ModuleMethod($instance, 46, ports.Lit40, 4097);
        eof$Mnobject$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:isEofValidateApply");
        eof$Mnobject$Qu = eof$Mnobject$Qu2;
        eof$Mnobject = new ModuleMethod($instance, 47, ports.Lit41, 0);
        char$Mnready$Qu = new ModuleMethod($instance, 48, ports.Lit42, 4096);
        read$Mnchar = new ModuleMethod($instance, 50, ports.Lit43, 4096);
        peek$Mnchar = new ModuleMethod($instance, 52, ports.Lit44, 4096);
        read$Mnstring = new ModuleMethod($instance, 54, ports.Lit45, 8193);
        read$Mnu8 = new ModuleMethod($instance, 56, ports.Lit46, 4096);
        peek$Mnu8 = new ModuleMethod($instance, 58, ports.Lit47, 4096);
        u8$Mnready$Qu = new ModuleMethod($instance, 60, ports.Lit48, 4096);
        read$Mnbytevector = new ModuleMethod($instance, 62, ports.Lit49, 8193);
        read$Mnbytevector$Ex = new ModuleMethod($instance, 64, ports.Lit50, 16385);
        write$Mnsimple = new ModuleMethod($instance, 68, ports.Lit51, 8193);
        write = new ModuleMethod($instance, 70, ports.Lit52, 8193);
        write$Mnshared = new ModuleMethod($instance, 72, ports.Lit53, 8193);
        write$Mnwith$Mnshared$Mnstructure = new ModuleMethod($instance, 74, ports.Lit54, 8193);
        display = new ModuleMethod($instance, 76, ports.Lit55, 8193);
        input$Mnport$Mnread$Mnstate = new ModuleMethod($instance, 78, ports.Lit56, 4097);
        set$Mnport$Mnline$Ex = new ModuleMethod($instance, 79, ports.Lit57, 8194);
        port$Mnline = new GenericProc("port-line");
        port$Mnline$Fn4 = new ModuleMethod($instance, 80, ports.Lit58, 4097);
        set$Mninput$Mnport$Mnline$Mnnumber$Ex = new ModuleMethod($instance, 81, ports.Lit59, 8194);
        input$Mnport$Mnline$Mnnumber = new GenericProc("input-port-line-number");
        input$Mnport$Mnline$Mnnumber$Fn5 = new ModuleMethod($instance, 82, ports.Lit60, 4097);
        port$Mncolumn = new ModuleMethod($instance, 83, ports.Lit61, 4097);
        input$Mnport$Mncolumn$Mnnumber = new ModuleMethod($instance, 84, ports.Lit62, 4097);
        set$Mninput$Mnport$Mnprompter$Ex = new ModuleMethod($instance, 85, ports.Lit63, 8194);
        input$Mnport$Mnprompter = new GenericProc("input-port-prompter");
        input$Mnport$Mnprompter$Fn6 = new ModuleMethod($instance, 86, ports.Lit64, 4097);
        close$Mnport = new ModuleMethod($instance, 87, ports.Lit65, 4097);
        close$Mninput$Mnport = new ModuleMethod($instance, 88, ports.Lit66, 4097);
        close$Mnoutput$Mnport = new ModuleMethod($instance, 89, ports.Lit67, 4097);
        read = new ModuleMethod($instance, 90, ports.Lit68, 4096);
        read$Mnline = new ModuleMethod($instance, 92, ports.Lit69, 8192);
        transcript$Mnon = new ModuleMethod($instance, 95, ports.Lit70, 4097);
        transcript$Mnoff = new ModuleMethod($instance, 96, ports.Lit71, 0);
        $runBody$();
    }
    
    public ports() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 96: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 92: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 90: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 60: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 58: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 56: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 52: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 50: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 48: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 47: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 44: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 42: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 40: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 36: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 33: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(moduleMethod, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 95: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 92: {
                final Object force = Promise.force(o, InPort.class);
                if (!(force instanceof InPort)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 90: {
                final Object force2 = Promise.force(o, InPort.class);
                if (!(force2 instanceof InPort)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 89: {
                final Object force3 = Promise.force(o, Writer.class);
                if (!(force3 instanceof Writer)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 88: {
                final Object force4 = Promise.force(o, Reader.class);
                if (!(force4 instanceof Reader)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 87: {
                final Object force5 = Promise.force(o, Closeable.class);
                if (!(force5 instanceof Closeable)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 86: {
                final Object force6 = Promise.force(o, TtyInPort.class);
                if (!(force6 instanceof TtyInPort)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 84: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 83: {
                final Object force7 = Promise.force(o, InPort.class);
                if (!(force7 instanceof InPort)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 82: {
                final Object force8 = Promise.force(o, InPort.class);
                if (!(force8 instanceof InPort)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 80: {
                final Object force9 = Promise.force(o, InPort.class);
                if (!(force9 instanceof InPort)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 78: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 76: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 74: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 72: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 70: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 68: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 64: {
                final Object force10 = Promise.force(o, U8Vector.class);
                if (force10 instanceof U8Vector) {
                    ctx.value1 = force10;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 62: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 60: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 58: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 56: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 54: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 52: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 50: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 48: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 46: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 44: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 42: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 40: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 39: {
                final Object force11 = Promise.force(o, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force11) != null) {
                    ctx.value1 = force11;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 37: {
                final Object force12 = Promise.force(o, BinaryOutPort.class);
                if (!(force12 instanceof BinaryOutPort)) {
                    return -786431;
                }
                ctx.value1 = force12;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 35: {
                final Object force13 = Promise.force(o, U8Vector.class);
                if (force13 instanceof U8Vector) {
                    ctx.value1 = force13;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 34: {
                final Object force14 = Promise.force(o, CharArrayOutPort.class);
                if (!(force14 instanceof CharArrayOutPort)) {
                    return -786431;
                }
                ctx.value1 = force14;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 32: {
                final Object force15 = Promise.force(o, CharSequence.class);
                if (force15 instanceof CharSequence) {
                    ctx.value1 = force15;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 28: {
                final Object force16 = Promise.force(o, U8Vector.class);
                if (force16 instanceof U8Vector) {
                    ctx.value1 = force16;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 26: {
                ctx.value1 = Promise.force(o);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 22: {
                final Object force17 = Promise.force(o, CharSequence.class);
                if (force17 instanceof CharSequence) {
                    ctx.value1 = force17;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 20: {
                final Object force18 = Promise.force(o);
                if (Char.checkCharOrEof(force18) >= 0) {
                    ctx.value1 = force18;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 19: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 18: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 17: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 15: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 14: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 13: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 12: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 11: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 10: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                final Object force19 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force19) != null) {
                    ctx.value1 = force19;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 3: {
                final Object force20 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force20) != null) {
                    ctx.value1 = force20;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                final Object force21 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force21) != null) {
                    ctx.value1 = force21;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 1: {
                final Object force22 = Promise.force(o, Path.class);
                if (Path.coerceToPathOrNull(force22) != null) {
                    ctx.value1 = force22;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 92: {
                final Object force = Promise.force(arg1, InPort.class);
                if (!(force instanceof InPort)) {
                    return -786431;
                }
                ctx.value1 = force;
                final Object force2 = Promise.force(arg2, Symbol.class);
                if (!(force2 instanceof Symbol)) {
                    return -786430;
                }
                ctx.value2 = force2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 85: {
                final Object force3 = Promise.force(arg1, TtyInPort.class);
                if (!(force3 instanceof TtyInPort)) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force4) != null) {
                    ctx.value2 = force4;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 81: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 79: {
                final Object force5 = Promise.force(arg1, InPort.class);
                if (!(force5 instanceof InPort)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.value2 = Promise.force(arg2);
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 76: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 74: {
                ctx.value1 = arg1;
                final Object force6 = Promise.force(arg2, OutPort.class);
                if (!(force6 instanceof OutPort)) {
                    return -786430;
                }
                ctx.value2 = force6;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 72: {
                ctx.value1 = arg1;
                final Object force7 = Promise.force(arg2, OutPort.class);
                if (!(force7 instanceof OutPort)) {
                    return -786430;
                }
                ctx.value2 = force7;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 70: {
                ctx.value1 = arg1;
                final Object force8 = Promise.force(arg2, OutPort.class);
                if (!(force8 instanceof OutPort)) {
                    return -786430;
                }
                ctx.value2 = force8;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 68: {
                ctx.value1 = arg1;
                final Object force9 = Promise.force(arg2, OutPort.class);
                if (!(force9 instanceof OutPort)) {
                    return -786430;
                }
                ctx.value2 = force9;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 64: {
                final Object force10 = Promise.force(arg1, U8Vector.class);
                if (force10 instanceof U8Vector) {
                    ctx.value1 = force10;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 62: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 54: {
                ctx.value1 = Promise.force(arg1);
                final Object force11 = Promise.force(arg2, InPort.class);
                if (!(force11 instanceof InPort)) {
                    return -786430;
                }
                ctx.value2 = force11;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 38: {
                final Object force12 = Promise.force(arg1, CharSequence.class);
                if (!(force12 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force12;
                final Object force13 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force13) != null) {
                    ctx.value2 = force13;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 28: {
                final Object force14 = Promise.force(arg1, U8Vector.class);
                if (force14 instanceof U8Vector) {
                    ctx.value1 = force14;
                    ctx.value2 = arg2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 26: {
                ctx.value1 = Promise.force(arg1);
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 22: {
                final Object force15 = Promise.force(arg1, CharSequence.class);
                if (!(force15 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force15;
                final Object force16 = Promise.force(arg2, Appendable.class);
                if (!(force16 instanceof Appendable)) {
                    return -786430;
                }
                ctx.value2 = force16;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 20: {
                final Object force17 = Promise.force(arg1);
                if (Char.checkCharOrEof(force17) < 0) {
                    return -786431;
                }
                ctx.value1 = force17;
                final Object force18 = Promise.force(arg2, Appendable.class);
                if (!(force18 instanceof Appendable)) {
                    return -786430;
                }
                ctx.value2 = force18;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 9: {
                final Object force19 = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force19) == null) {
                    return -786431;
                }
                ctx.value1 = force19;
                final Object force20 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force20) != null) {
                    ctx.value2 = force20;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 8: {
                final Object force21 = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force21) == null) {
                    return -786431;
                }
                ctx.value1 = force21;
                final Object force22 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force22) != null) {
                    ctx.value2 = force22;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 7: {
                final Object force23 = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force23) == null) {
                    return -786431;
                }
                ctx.value1 = force23;
                final Object force24 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force24) != null) {
                    ctx.value2 = force24;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 6: {
                final Object force25 = Promise.force(arg1, Path.class);
                if (Path.coerceToPathOrNull(force25) == null) {
                    return -786431;
                }
                ctx.value1 = force25;
                final Object force26 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force26) != null) {
                    ctx.value2 = force26;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 5: {
                final Object force27 = Promise.force(arg1, Closeable.class);
                if (!(force27 instanceof Closeable)) {
                    return -786431;
                }
                ctx.value1 = force27;
                final Object force28 = Promise.force(arg2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(force28) != null) {
                    ctx.value2 = force28;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 64: {
                final Object force = Promise.force(o, U8Vector.class);
                if (force instanceof U8Vector) {
                    ctx.value1 = force;
                    ctx.value2 = o2;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 28: {
                final Object force2 = Promise.force(o, U8Vector.class);
                if (force2 instanceof U8Vector) {
                    ctx.value1 = force2;
                    ctx.value2 = o2;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786431;
            }
            case 22: {
                final Object force3 = Promise.force(o, CharSequence.class);
                if (!(force3 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(o2, Appendable.class);
                if (!(force4 instanceof Appendable)) {
                    return -786430;
                }
                ctx.value2 = force4;
                ctx.value3 = Promise.force(o3);
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 64: {
                final Object force = Promise.force(o, U8Vector.class);
                if (force instanceof U8Vector) {
                    ctx.value1 = force;
                    ctx.value2 = o2;
                    ctx.value3 = Promise.force(o3);
                    ctx.value4 = Promise.force(o4);
                    ctx.proc = moduleMethod;
                    ctx.pc = 4;
                    return 0;
                }
                return -786431;
            }
            case 28: {
                final Object force2 = Promise.force(o, U8Vector.class);
                if (force2 instanceof U8Vector) {
                    ctx.value1 = force2;
                    ctx.value2 = o2;
                    ctx.value3 = Promise.force(o3);
                    ctx.value4 = Promise.force(o4);
                    ctx.proc = moduleMethod;
                    ctx.pc = 4;
                    return 0;
                }
                return -786431;
            }
            case 22: {
                final Object force3 = Promise.force(o, CharSequence.class);
                if (!(force3 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(o2, Appendable.class);
                if (!(force4 instanceof Appendable)) {
                    return -786430;
                }
                ctx.value2 = force4;
                ctx.value3 = Promise.force(o3);
                ctx.value4 = Promise.force(o4);
                ctx.proc = moduleMethod;
                ctx.pc = 4;
                return 0;
            }
            default: {
                return super.match4(moduleMethod, o, o2, o3, o4, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 33: {
                return openOutputString();
            }
            case 36: {
                return openOutputBytevector();
            }
            case 40: {
                flushOutputPort();
                return Values.empty;
            }
            case 42: {
                forceOutput();
                return Values.empty;
            }
            case 44: {
                newline();
                return Values.empty;
            }
            case 47: {
                return eofObject();
            }
            case 48: {
                return isCharReady() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 50: {
                return Char.makeOrEof(readChar());
            }
            case 52: {
                return Char.makeOrEof(peekChar());
            }
            case 56: {
                return readU8();
            }
            case 58: {
                return peekU8();
            }
            case 60: {
                return isU8Ready() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 90: {
                return read();
            }
            case 92: {
                return readLine();
            }
            case 96: {
                transcriptOff();
                return Values.empty;
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                2: 400
        //                3: 414
        //                4: 428
        //                5: 442
        //                6: 1060
        //                7: 1060
        //                8: 1060
        //                9: 1060
        //               10: 1060
        //               11: 456
        //               12: 473
        //               13: 490
        //               14: 507
        //               15: 524
        //               16: 541
        //               17: 558
        //               18: 575
        //               19: 580
        //               20: 585
        //               21: 590
        //               22: 1060
        //               23: 604
        //               24: 1060
        //               25: 1060
        //               26: 1060
        //               27: 620
        //               28: 1060
        //               29: 637
        //               30: 1060
        //               31: 1060
        //               32: 1060
        //               33: 653
        //               34: 1060
        //               35: 666
        //               36: 679
        //               37: 1060
        //               38: 692
        //               39: 1060
        //               40: 705
        //               41: 718
        //               42: 1060
        //               43: 726
        //               44: 1060
        //               45: 734
        //               46: 1060
        //               47: 742
        //               48: 1060
        //               49: 759
        //               50: 1060
        //               51: 776
        //               52: 1060
        //               53: 784
        //               54: 1060
        //               55: 792
        //               56: 1060
        //               57: 806
        //               58: 1060
        //               59: 811
        //               60: 1060
        //               61: 816
        //               62: 1060
        //               63: 833
        //               64: 1060
        //               65: 847
        //               66: 1060
        //               67: 1060
        //               68: 1060
        //               69: 860
        //               70: 1060
        //               71: 868
        //               72: 1060
        //               73: 876
        //               74: 1060
        //               75: 884
        //               76: 1060
        //               77: 892
        //               78: 1060
        //               79: 900
        //               80: 1060
        //               81: 908
        //               82: 1060
        //               83: 924
        //               84: 937
        //               85: 953
        //               86: 1060
        //               87: 961
        //               88: 975
        //               89: 992
        //               90: 1009
        //               91: 1026
        //               92: 1060
        //               93: 1039
        //               94: 1060
        //               95: 1060
        //               96: 1052
        //          default: 1060
        //        }
        //   400: aload_2        
        //   401: ldc_w           Lgnu/kawa/io/Path;.class
        //   404: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   407: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   410: invokestatic    kawa/lib/ports.openInputFile:(Lgnu/kawa/io/Path;)Lgnu/kawa/io/InPort;
        //   413: areturn        
        //   414: aload_2        
        //   415: ldc_w           Lgnu/kawa/io/Path;.class
        //   418: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   421: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   424: invokestatic    kawa/lib/ports.openBinaryInputFile:(Lgnu/kawa/io/Path;)Lgnu/kawa/io/BinaryInPort;
        //   427: areturn        
        //   428: aload_2        
        //   429: ldc_w           Lgnu/kawa/io/Path;.class
        //   432: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   435: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   438: invokestatic    kawa/lib/ports.openOutputFile:(Lgnu/kawa/io/Path;)Lgnu/kawa/io/OutPort;
        //   441: areturn        
        //   442: aload_2        
        //   443: ldc_w           Lgnu/kawa/io/Path;.class
        //   446: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   449: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   452: invokestatic    kawa/lib/ports.openBinaryOutputFile:(Lgnu/kawa/io/Path;)Lgnu/kawa/io/BinaryOutPort;
        //   455: areturn        
        //   456: aload_2        
        //   457: invokestatic    kawa/lib/ports.isInputPort:(Ljava/lang/Object;)Z
        //   460: ifeq            469
        //   463: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   466: goto            472
        //   469: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   472: areturn        
        //   473: aload_2        
        //   474: invokestatic    kawa/lib/ports.isOutputPort:(Ljava/lang/Object;)Z
        //   477: ifeq            486
        //   480: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   483: goto            489
        //   486: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   489: areturn        
        //   490: aload_2        
        //   491: invokestatic    kawa/lib/ports.isTextualPort:(Ljava/lang/Object;)Z
        //   494: ifeq            503
        //   497: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   500: goto            506
        //   503: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   506: areturn        
        //   507: aload_2        
        //   508: invokestatic    kawa/lib/ports.isBinaryPort:(Ljava/lang/Object;)Z
        //   511: ifeq            520
        //   514: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   517: goto            523
        //   520: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   523: areturn        
        //   524: aload_2        
        //   525: invokestatic    kawa/lib/ports.isPort:(Ljava/lang/Object;)Z
        //   528: ifeq            537
        //   531: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   534: goto            540
        //   537: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   540: areturn        
        //   541: aload_2        
        //   542: invokestatic    kawa/lib/ports.isInputPortOpen:(Ljava/lang/Object;)Z
        //   545: ifeq            554
        //   548: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   551: goto            557
        //   554: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   557: areturn        
        //   558: aload_2        
        //   559: invokestatic    kawa/lib/ports.isOutputPortOpen:(Ljava/lang/Object;)Z
        //   562: ifeq            571
        //   565: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   568: goto            574
        //   571: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   574: areturn        
        //   575: aload_2        
        //   576: invokestatic    kawa/lib/ports.lambda1:(Ljava/lang/Object;)Lgnu/kawa/io/InPort;
        //   579: areturn        
        //   580: aload_2        
        //   581: invokestatic    kawa/lib/ports.lambda2:(Ljava/lang/Object;)Lgnu/kawa/io/OutPort;
        //   584: areturn        
        //   585: aload_2        
        //   586: invokestatic    kawa/lib/ports.lambda3:(Ljava/lang/Object;)Lgnu/kawa/io/OutPort;
        //   589: areturn        
        //   590: aload_2        
        //   591: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   594: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   597: invokestatic    kawa/lib/ports.writeChar:(I)V
        //   600: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   603: areturn        
        //   604: aload_2        
        //   605: ldc             Ljava/lang/CharSequence;.class
        //   607: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   610: checkcast       Ljava/lang/CharSequence;
        //   613: invokestatic    kawa/lib/ports.writeString:(Ljava/lang/CharSequence;)V
        //   616: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   619: areturn        
        //   620: aload_2        
        //   621: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   624: checkcast       Ljava/lang/Number;
        //   627: invokevirtual   java/lang/Number.intValue:()I
        //   630: invokestatic    kawa/lib/ports.writeU8:(I)V
        //   633: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   636: areturn        
        //   637: aload_2        
        //   638: ldc             Lgnu/lists/U8Vector;.class
        //   640: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   643: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   646: invokestatic    kawa/lib/ports.writeBytevector:(Lgnu/lists/U8Vector;)V
        //   649: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   652: areturn        
        //   653: aload_2        
        //   654: ldc             Ljava/lang/CharSequence;.class
        //   656: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   659: checkcast       Ljava/lang/CharSequence;
        //   662: invokestatic    kawa/lib/ports.openInputString:(Ljava/lang/CharSequence;)Lgnu/kawa/io/CharArrayInPort;
        //   665: areturn        
        //   666: aload_2        
        //   667: ldc             Lgnu/kawa/io/CharArrayOutPort;.class
        //   669: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   672: checkcast       Lgnu/kawa/io/CharArrayOutPort;
        //   675: invokestatic    kawa/lib/ports.getOutputString:(Lgnu/kawa/io/CharArrayOutPort;)Lgnu/lists/FString;
        //   678: areturn        
        //   679: aload_2        
        //   680: ldc             Lgnu/lists/U8Vector;.class
        //   682: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   685: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   688: invokestatic    kawa/lib/ports.openInputBytevector:(Lgnu/lists/U8Vector;)Lgnu/kawa/io/BinaryInPort;
        //   691: areturn        
        //   692: aload_2        
        //   693: ldc             Lgnu/kawa/io/BinaryOutPort;.class
        //   695: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   698: checkcast       Lgnu/kawa/io/BinaryOutPort;
        //   701: invokestatic    kawa/lib/ports.getOutputBytevector:(Lgnu/kawa/io/BinaryOutPort;)Lgnu/lists/U8Vector;
        //   704: areturn        
        //   705: aload_2        
        //   706: ldc             Lgnu/mapping/Procedure;.class
        //   708: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   711: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   714: invokestatic    kawa/lib/ports.callWithOutputString:(Lgnu/mapping/Procedure;)Lgnu/lists/FString;
        //   717: areturn        
        //   718: aload_2        
        //   719: invokestatic    kawa/lib/ports.flushOutputPort:(Ljava/lang/Object;)V
        //   722: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   725: areturn        
        //   726: aload_2        
        //   727: invokestatic    kawa/lib/ports.forceOutput:(Ljava/lang/Object;)V
        //   730: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   733: areturn        
        //   734: aload_2        
        //   735: invokestatic    kawa/lib/ports.newline:(Ljava/lang/Object;)V
        //   738: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   741: areturn        
        //   742: aload_2        
        //   743: invokestatic    kawa/lib/ports.isEofObject:(Ljava/lang/Object;)Z
        //   746: ifeq            755
        //   749: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   752: goto            758
        //   755: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   758: areturn        
        //   759: aload_2        
        //   760: invokestatic    kawa/lib/ports.isCharReady:(Ljava/lang/Object;)Z
        //   763: ifeq            772
        //   766: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   769: goto            775
        //   772: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   775: areturn        
        //   776: aload_2        
        //   777: invokestatic    kawa/lib/ports.readChar:(Ljava/lang/Object;)I
        //   780: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
        //   783: areturn        
        //   784: aload_2        
        //   785: invokestatic    kawa/lib/ports.peekChar:(Ljava/lang/Object;)I
        //   788: invokestatic    gnu/text/Char.makeOrEof:(I)Ljava/lang/Object;
        //   791: areturn        
        //   792: aload_2        
        //   793: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   796: checkcast       Ljava/lang/Number;
        //   799: invokevirtual   java/lang/Number.intValue:()I
        //   802: invokestatic    kawa/lib/ports.readString:(I)Ljava/lang/Object;
        //   805: areturn        
        //   806: aload_2        
        //   807: invokestatic    kawa/lib/ports.readU8:(Ljava/lang/Object;)Ljava/lang/Object;
        //   810: areturn        
        //   811: aload_2        
        //   812: invokestatic    kawa/lib/ports.peekU8:(Ljava/lang/Object;)Ljava/lang/Object;
        //   815: areturn        
        //   816: aload_2        
        //   817: invokestatic    kawa/lib/ports.isU8Ready:(Ljava/lang/Object;)Z
        //   820: ifeq            829
        //   823: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   826: goto            832
        //   829: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   832: areturn        
        //   833: aload_2        
        //   834: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   837: checkcast       Ljava/lang/Number;
        //   840: invokevirtual   java/lang/Number.intValue:()I
        //   843: invokestatic    kawa/lib/ports.readBytevector:(I)Ljava/lang/Object;
        //   846: areturn        
        //   847: aload_2        
        //   848: ldc             Lgnu/lists/U8Vector;.class
        //   850: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   853: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   856: invokestatic    kawa/lib/ports.readBytevector$Ex:(Lgnu/lists/U8Vector;)Ljava/lang/Object;
        //   859: areturn        
        //   860: aload_2        
        //   861: invokestatic    kawa/lib/ports.writeSimple:(Ljava/lang/Object;)V
        //   864: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   867: areturn        
        //   868: aload_2        
        //   869: invokestatic    kawa/lib/ports.write:(Ljava/lang/Object;)V
        //   872: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   875: areturn        
        //   876: aload_2        
        //   877: invokestatic    kawa/lib/ports.writeShared:(Ljava/lang/Object;)V
        //   880: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   883: areturn        
        //   884: aload_2        
        //   885: invokestatic    kawa/lib/ports.writeWithSharedStructure:(Ljava/lang/Object;)V
        //   888: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   891: areturn        
        //   892: aload_2        
        //   893: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   896: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   899: areturn        
        //   900: aload_2        
        //   901: invokestatic    kawa/lib/ports.inputPortReadState:(Ljava/lang/Object;)C
        //   904: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   907: areturn        
        //   908: aload_2        
        //   909: ldc             Lgnu/kawa/io/InPort;.class
        //   911: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   914: checkcast       Lgnu/kawa/io/InPort;
        //   917: invokestatic    kawa/lib/ports.portLine:(Lgnu/kawa/io/InPort;)I
        //   920: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   923: areturn        
        //   924: aload_2        
        //   925: ldc             Lgnu/kawa/io/InPort;.class
        //   927: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   930: checkcast       Lgnu/kawa/io/InPort;
        //   933: invokestatic    kawa/lib/ports.inputPortLineNumber:(Lgnu/kawa/io/InPort;)Ljava/lang/Object;
        //   936: areturn        
        //   937: aload_2        
        //   938: ldc             Lgnu/kawa/io/InPort;.class
        //   940: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   943: checkcast       Lgnu/kawa/io/InPort;
        //   946: invokestatic    kawa/lib/ports.portColumn:(Lgnu/kawa/io/InPort;)I
        //   949: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   952: areturn        
        //   953: aload_2        
        //   954: invokestatic    kawa/lib/ports.inputPortColumnNumber:(Ljava/lang/Object;)I
        //   957: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   960: areturn        
        //   961: aload_2        
        //   962: ldc_w           Lgnu/kawa/io/TtyInPort;.class
        //   965: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   968: checkcast       Lgnu/kawa/io/TtyInPort;
        //   971: invokestatic    kawa/lib/ports.inputPortPrompter:(Lgnu/kawa/io/TtyInPort;)Lgnu/mapping/Procedure;
        //   974: areturn        
        //   975: aload_2        
        //   976: ldc_w           Ljava/io/Closeable;.class
        //   979: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   982: checkcast       Ljava/io/Closeable;
        //   985: invokestatic    kawa/lib/ports.closePort:(Ljava/io/Closeable;)V
        //   988: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   991: areturn        
        //   992: aload_2        
        //   993: ldc_w           Ljava/io/Reader;.class
        //   996: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   999: checkcast       Ljava/io/Reader;
        //  1002: invokestatic    kawa/lib/ports.closeInputPort:(Ljava/io/Reader;)V
        //  1005: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //  1008: areturn        
        //  1009: aload_2        
        //  1010: ldc_w           Ljava/io/Writer;.class
        //  1013: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1016: checkcast       Ljava/io/Writer;
        //  1019: invokestatic    kawa/lib/ports.closeOutputPort:(Ljava/io/Writer;)V
        //  1022: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //  1025: areturn        
        //  1026: aload_2        
        //  1027: ldc             Lgnu/kawa/io/InPort;.class
        //  1029: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1032: checkcast       Lgnu/kawa/io/InPort;
        //  1035: invokestatic    kawa/lib/ports.read:(Lgnu/kawa/io/InPort;)Ljava/lang/Object;
        //  1038: areturn        
        //  1039: aload_2        
        //  1040: ldc             Lgnu/kawa/io/InPort;.class
        //  1042: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //  1045: checkcast       Lgnu/kawa/io/InPort;
        //  1048: invokestatic    kawa/lib/ports.readLine:(Lgnu/kawa/io/InPort;)Ljava/lang/Object;
        //  1051: areturn        
        //  1052: aload_2        
        //  1053: invokestatic    kawa/lib/ports.transcriptOn:(Ljava/lang/Object;)V
        //  1056: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //  1059: areturn        
        //  1060: aload_0        
        //  1061: aload_1        
        //  1062: aload_2        
        //  1063: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //  1066: areturn        
        //  1067: new             Lgnu/mapping/WrongType;
        //  1070: dup_x1         
        //  1071: swap           
        //  1072: ldc_w           "open-input-file"
        //  1075: iconst_1       
        //  1076: aload_2        
        //  1077: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1080: athrow         
        //  1081: new             Lgnu/mapping/WrongType;
        //  1084: dup_x1         
        //  1085: swap           
        //  1086: ldc_w           "open-binary-input-file"
        //  1089: iconst_1       
        //  1090: aload_2        
        //  1091: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1094: athrow         
        //  1095: new             Lgnu/mapping/WrongType;
        //  1098: dup_x1         
        //  1099: swap           
        //  1100: ldc_w           "open-output-file"
        //  1103: iconst_1       
        //  1104: aload_2        
        //  1105: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1108: athrow         
        //  1109: new             Lgnu/mapping/WrongType;
        //  1112: dup_x1         
        //  1113: swap           
        //  1114: ldc_w           "open-binary-output-file"
        //  1117: iconst_1       
        //  1118: aload_2        
        //  1119: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1122: athrow         
        //  1123: new             Lgnu/mapping/WrongType;
        //  1126: dup_x1         
        //  1127: swap           
        //  1128: ldc_w           "write-char"
        //  1131: iconst_1       
        //  1132: aload_2        
        //  1133: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1136: athrow         
        //  1137: new             Lgnu/mapping/WrongType;
        //  1140: dup_x1         
        //  1141: swap           
        //  1142: ldc_w           "write-string"
        //  1145: iconst_1       
        //  1146: aload_2        
        //  1147: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1150: athrow         
        //  1151: new             Lgnu/mapping/WrongType;
        //  1154: dup_x1         
        //  1155: swap           
        //  1156: ldc_w           "write-u8"
        //  1159: iconst_1       
        //  1160: aload_2        
        //  1161: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1164: athrow         
        //  1165: new             Lgnu/mapping/WrongType;
        //  1168: dup_x1         
        //  1169: swap           
        //  1170: ldc_w           "write-bytevector"
        //  1173: iconst_1       
        //  1174: aload_2        
        //  1175: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1178: athrow         
        //  1179: new             Lgnu/mapping/WrongType;
        //  1182: dup_x1         
        //  1183: swap           
        //  1184: ldc_w           "open-input-string"
        //  1187: iconst_1       
        //  1188: aload_2        
        //  1189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1192: athrow         
        //  1193: new             Lgnu/mapping/WrongType;
        //  1196: dup_x1         
        //  1197: swap           
        //  1198: ldc_w           "get-output-string"
        //  1201: iconst_1       
        //  1202: aload_2        
        //  1203: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1206: athrow         
        //  1207: new             Lgnu/mapping/WrongType;
        //  1210: dup_x1         
        //  1211: swap           
        //  1212: ldc_w           "open-input-bytevector"
        //  1215: iconst_1       
        //  1216: aload_2        
        //  1217: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1220: athrow         
        //  1221: new             Lgnu/mapping/WrongType;
        //  1224: dup_x1         
        //  1225: swap           
        //  1226: ldc_w           "get-output-bytevector"
        //  1229: iconst_1       
        //  1230: aload_2        
        //  1231: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1234: athrow         
        //  1235: new             Lgnu/mapping/WrongType;
        //  1238: dup_x1         
        //  1239: swap           
        //  1240: ldc_w           "call-with-output-string"
        //  1243: iconst_1       
        //  1244: aload_2        
        //  1245: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1248: athrow         
        //  1249: new             Lgnu/mapping/WrongType;
        //  1252: dup_x1         
        //  1253: swap           
        //  1254: ldc_w           "read-string"
        //  1257: iconst_1       
        //  1258: aload_2        
        //  1259: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1262: athrow         
        //  1263: new             Lgnu/mapping/WrongType;
        //  1266: dup_x1         
        //  1267: swap           
        //  1268: ldc_w           "read-bytevector"
        //  1271: iconst_1       
        //  1272: aload_2        
        //  1273: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1276: athrow         
        //  1277: new             Lgnu/mapping/WrongType;
        //  1280: dup_x1         
        //  1281: swap           
        //  1282: ldc_w           "read-bytevector!"
        //  1285: iconst_1       
        //  1286: aload_2        
        //  1287: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1290: athrow         
        //  1291: new             Lgnu/mapping/WrongType;
        //  1294: dup_x1         
        //  1295: swap           
        //  1296: ldc_w           "port-line"
        //  1299: iconst_1       
        //  1300: aload_2        
        //  1301: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1304: athrow         
        //  1305: new             Lgnu/mapping/WrongType;
        //  1308: dup_x1         
        //  1309: swap           
        //  1310: ldc_w           "input-port-line-number"
        //  1313: iconst_1       
        //  1314: aload_2        
        //  1315: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1318: athrow         
        //  1319: new             Lgnu/mapping/WrongType;
        //  1322: dup_x1         
        //  1323: swap           
        //  1324: ldc_w           "port-column"
        //  1327: iconst_1       
        //  1328: aload_2        
        //  1329: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1332: athrow         
        //  1333: new             Lgnu/mapping/WrongType;
        //  1336: dup_x1         
        //  1337: swap           
        //  1338: ldc_w           "input-port-prompter"
        //  1341: iconst_1       
        //  1342: aload_2        
        //  1343: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1346: athrow         
        //  1347: new             Lgnu/mapping/WrongType;
        //  1350: dup_x1         
        //  1351: swap           
        //  1352: ldc_w           "close-port"
        //  1355: iconst_1       
        //  1356: aload_2        
        //  1357: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1360: athrow         
        //  1361: new             Lgnu/mapping/WrongType;
        //  1364: dup_x1         
        //  1365: swap           
        //  1366: ldc_w           "close-input-port"
        //  1369: iconst_1       
        //  1370: aload_2        
        //  1371: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1374: athrow         
        //  1375: new             Lgnu/mapping/WrongType;
        //  1378: dup_x1         
        //  1379: swap           
        //  1380: ldc_w           "close-output-port"
        //  1383: iconst_1       
        //  1384: aload_2        
        //  1385: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1388: athrow         
        //  1389: new             Lgnu/mapping/WrongType;
        //  1392: dup_x1         
        //  1393: swap           
        //  1394: ldc_w           "read"
        //  1397: iconst_1       
        //  1398: aload_2        
        //  1399: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1402: athrow         
        //  1403: new             Lgnu/mapping/WrongType;
        //  1406: dup_x1         
        //  1407: swap           
        //  1408: ldc_w           "read-line"
        //  1411: iconst_1       
        //  1412: aload_2        
        //  1413: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1416: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  407    410    1067   1081   Ljava/lang/ClassCastException;
        //  421    424    1081   1095   Ljava/lang/ClassCastException;
        //  435    438    1095   1109   Ljava/lang/ClassCastException;
        //  449    452    1109   1123   Ljava/lang/ClassCastException;
        //  594    597    1123   1137   Ljava/lang/ClassCastException;
        //  610    613    1137   1151   Ljava/lang/ClassCastException;
        //  624    630    1151   1165   Ljava/lang/ClassCastException;
        //  643    646    1165   1179   Ljava/lang/ClassCastException;
        //  659    662    1179   1193   Ljava/lang/ClassCastException;
        //  672    675    1193   1207   Ljava/lang/ClassCastException;
        //  685    688    1207   1221   Ljava/lang/ClassCastException;
        //  698    701    1221   1235   Ljava/lang/ClassCastException;
        //  711    714    1235   1249   Ljava/lang/ClassCastException;
        //  796    802    1249   1263   Ljava/lang/ClassCastException;
        //  837    843    1263   1277   Ljava/lang/ClassCastException;
        //  853    856    1277   1291   Ljava/lang/ClassCastException;
        //  914    917    1291   1305   Ljava/lang/ClassCastException;
        //  930    933    1305   1319   Ljava/lang/ClassCastException;
        //  943    946    1319   1333   Ljava/lang/ClassCastException;
        //  968    971    1333   1347   Ljava/lang/ClassCastException;
        //  982    985    1347   1361   Ljava/lang/ClassCastException;
        //  999    1002   1361   1375   Ljava/lang/ClassCastException;
        //  1016   1019   1375   1389   Ljava/lang/ClassCastException;
        //  1032   1035   1389   1403   Ljava/lang/ClassCastException;
        //  1045   1048   1403   1417   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 503 out of bounds for length 503
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //                5: 192
        //                6: 215
        //                7: 238
        //                8: 261
        //                9: 284
        //               20: 307
        //               22: 330
        //               26: 355
        //               28: 373
        //               38: 390
        //               54: 412
        //               62: 435
        //               64: 450
        //               68: 464
        //               70: 481
        //               72: 498
        //               74: 515
        //               76: 532
        //               79: 541
        //               81: 567
        //               85: 576
        //               92: 602
        //          default: 625
        //        }
        //   192: aload_2        
        //   193: ldc_w           Ljava/io/Closeable;.class
        //   196: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   199: checkcast       Ljava/io/Closeable;
        //   202: aload_3        
        //   203: ldc             Lgnu/mapping/Procedure;.class
        //   205: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   208: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   211: invokestatic    kawa/lib/ports.callWithPort:(Ljava/io/Closeable;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   214: areturn        
        //   215: aload_2        
        //   216: ldc_w           Lgnu/kawa/io/Path;.class
        //   219: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   222: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   225: aload_3        
        //   226: ldc             Lgnu/mapping/Procedure;.class
        //   228: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   231: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   234: invokestatic    kawa/lib/ports.callWithInputFile:(Lgnu/kawa/io/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   237: areturn        
        //   238: aload_2        
        //   239: ldc_w           Lgnu/kawa/io/Path;.class
        //   242: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   245: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   248: aload_3        
        //   249: ldc             Lgnu/mapping/Procedure;.class
        //   251: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   254: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   257: invokestatic    kawa/lib/ports.callWithOutputFile:(Lgnu/kawa/io/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   260: areturn        
        //   261: aload_2        
        //   262: ldc_w           Lgnu/kawa/io/Path;.class
        //   265: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   268: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   271: aload_3        
        //   272: ldc             Lgnu/mapping/Procedure;.class
        //   274: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   277: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   280: invokestatic    kawa/lib/ports.withInputFromFile:(Lgnu/kawa/io/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   283: areturn        
        //   284: aload_2        
        //   285: ldc_w           Lgnu/kawa/io/Path;.class
        //   288: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   291: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //   294: aload_3        
        //   295: ldc             Lgnu/mapping/Procedure;.class
        //   297: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   300: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   303: invokestatic    kawa/lib/ports.withOutputToFile:(Lgnu/kawa/io/Path;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   306: areturn        
        //   307: aload_2        
        //   308: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   311: invokestatic    gnu/text/Char.castToCharacter:(Ljava/lang/Object;)I
        //   314: aload_3        
        //   315: ldc             Ljava/lang/Appendable;.class
        //   317: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   320: checkcast       Ljava/lang/Appendable;
        //   323: invokestatic    kawa/lib/ports.writeChar:(ILjava/lang/Appendable;)V
        //   326: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   329: areturn        
        //   330: aload_2        
        //   331: ldc             Ljava/lang/CharSequence;.class
        //   333: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   336: checkcast       Ljava/lang/CharSequence;
        //   339: aload_3        
        //   340: ldc             Ljava/lang/Appendable;.class
        //   342: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   345: checkcast       Ljava/lang/Appendable;
        //   348: invokestatic    kawa/lib/ports.writeString:(Ljava/lang/CharSequence;Ljava/lang/Appendable;)V
        //   351: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   354: areturn        
        //   355: aload_2        
        //   356: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   359: checkcast       Ljava/lang/Number;
        //   362: invokevirtual   java/lang/Number.intValue:()I
        //   365: aload_3        
        //   366: invokestatic    kawa/lib/ports.writeU8:(ILjava/lang/Object;)V
        //   369: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   372: areturn        
        //   373: aload_2        
        //   374: ldc             Lgnu/lists/U8Vector;.class
        //   376: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   379: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   382: aload_3        
        //   383: invokestatic    kawa/lib/ports.writeBytevector:(Lgnu/lists/U8Vector;Ljava/lang/Object;)V
        //   386: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   389: areturn        
        //   390: aload_2        
        //   391: ldc             Ljava/lang/CharSequence;.class
        //   393: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   396: checkcast       Ljava/lang/CharSequence;
        //   399: aload_3        
        //   400: ldc             Lgnu/mapping/Procedure;.class
        //   402: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   405: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   408: invokestatic    kawa/lib/ports.callWithInputString:(Ljava/lang/CharSequence;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //   411: areturn        
        //   412: aload_2        
        //   413: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   416: checkcast       Ljava/lang/Number;
        //   419: invokevirtual   java/lang/Number.intValue:()I
        //   422: aload_3        
        //   423: ldc             Lgnu/kawa/io/InPort;.class
        //   425: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   428: checkcast       Lgnu/kawa/io/InPort;
        //   431: invokestatic    kawa/lib/ports.readString:(ILgnu/kawa/io/InPort;)Ljava/lang/Object;
        //   434: areturn        
        //   435: aload_2        
        //   436: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   439: checkcast       Ljava/lang/Number;
        //   442: invokevirtual   java/lang/Number.intValue:()I
        //   445: aload_3        
        //   446: invokestatic    kawa/lib/ports.readBytevector:(ILjava/lang/Object;)Ljava/lang/Object;
        //   449: areturn        
        //   450: aload_2        
        //   451: ldc             Lgnu/lists/U8Vector;.class
        //   453: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   456: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   459: aload_3        
        //   460: invokestatic    kawa/lib/ports.readBytevector$Ex:(Lgnu/lists/U8Vector;Ljava/lang/Object;)Ljava/lang/Object;
        //   463: areturn        
        //   464: aload_2        
        //   465: aload_3        
        //   466: ldc             Lgnu/kawa/io/OutPort;.class
        //   468: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   471: checkcast       Lgnu/kawa/io/OutPort;
        //   474: invokestatic    kawa/lib/ports.writeSimple:(Ljava/lang/Object;Lgnu/kawa/io/OutPort;)V
        //   477: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   480: areturn        
        //   481: aload_2        
        //   482: aload_3        
        //   483: ldc             Lgnu/kawa/io/OutPort;.class
        //   485: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   488: checkcast       Lgnu/kawa/io/OutPort;
        //   491: invokestatic    kawa/lib/ports.write:(Ljava/lang/Object;Lgnu/kawa/io/OutPort;)V
        //   494: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   497: areturn        
        //   498: aload_2        
        //   499: aload_3        
        //   500: ldc             Lgnu/kawa/io/OutPort;.class
        //   502: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   505: checkcast       Lgnu/kawa/io/OutPort;
        //   508: invokestatic    kawa/lib/ports.writeShared:(Ljava/lang/Object;Lgnu/kawa/io/OutPort;)V
        //   511: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   514: areturn        
        //   515: aload_2        
        //   516: aload_3        
        //   517: ldc             Lgnu/kawa/io/OutPort;.class
        //   519: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   522: checkcast       Lgnu/kawa/io/OutPort;
        //   525: invokestatic    kawa/lib/ports.writeWithSharedStructure:(Ljava/lang/Object;Lgnu/kawa/io/OutPort;)V
        //   528: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   531: areturn        
        //   532: aload_2        
        //   533: aload_3        
        //   534: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   537: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   540: areturn        
        //   541: aload_2        
        //   542: ldc             Lgnu/kawa/io/InPort;.class
        //   544: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   547: checkcast       Lgnu/kawa/io/InPort;
        //   550: aload_3        
        //   551: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   554: checkcast       Ljava/lang/Number;
        //   557: invokevirtual   java/lang/Number.intValue:()I
        //   560: invokestatic    kawa/lib/ports.setPortLine$Ex:(Lgnu/kawa/io/InPort;I)V
        //   563: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   566: areturn        
        //   567: aload_2        
        //   568: aload_3        
        //   569: invokestatic    kawa/lib/ports.setInputPortLineNumber$Ex:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   572: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   575: areturn        
        //   576: aload_2        
        //   577: ldc_w           Lgnu/kawa/io/TtyInPort;.class
        //   580: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   583: checkcast       Lgnu/kawa/io/TtyInPort;
        //   586: aload_3        
        //   587: ldc             Lgnu/mapping/Procedure;.class
        //   589: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   592: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   595: invokestatic    kawa/lib/ports.setInputPortPrompter$Ex:(Lgnu/kawa/io/TtyInPort;Lgnu/mapping/Procedure;)V
        //   598: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   601: areturn        
        //   602: aload_2        
        //   603: ldc             Lgnu/kawa/io/InPort;.class
        //   605: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   608: checkcast       Lgnu/kawa/io/InPort;
        //   611: aload_3        
        //   612: ldc_w           Lgnu/mapping/Symbol;.class
        //   615: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   618: checkcast       Lgnu/mapping/Symbol;
        //   621: invokestatic    kawa/lib/ports.readLine:(Lgnu/kawa/io/InPort;Lgnu/mapping/Symbol;)Ljava/lang/Object;
        //   624: areturn        
        //   625: aload_0        
        //   626: aload_1        
        //   627: aload_2        
        //   628: aload_3        
        //   629: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   632: areturn        
        //   633: new             Lgnu/mapping/WrongType;
        //   636: dup_x1         
        //   637: swap           
        //   638: ldc_w           "call-with-port"
        //   641: iconst_1       
        //   642: aload_2        
        //   643: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   646: athrow         
        //   647: new             Lgnu/mapping/WrongType;
        //   650: dup_x1         
        //   651: swap           
        //   652: ldc_w           "call-with-port"
        //   655: iconst_2       
        //   656: aload_3        
        //   657: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   660: athrow         
        //   661: new             Lgnu/mapping/WrongType;
        //   664: dup_x1         
        //   665: swap           
        //   666: ldc_w           "call-with-input-file"
        //   669: iconst_1       
        //   670: aload_2        
        //   671: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   674: athrow         
        //   675: new             Lgnu/mapping/WrongType;
        //   678: dup_x1         
        //   679: swap           
        //   680: ldc_w           "call-with-input-file"
        //   683: iconst_2       
        //   684: aload_3        
        //   685: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   688: athrow         
        //   689: new             Lgnu/mapping/WrongType;
        //   692: dup_x1         
        //   693: swap           
        //   694: ldc_w           "call-with-output-file"
        //   697: iconst_1       
        //   698: aload_2        
        //   699: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   702: athrow         
        //   703: new             Lgnu/mapping/WrongType;
        //   706: dup_x1         
        //   707: swap           
        //   708: ldc_w           "call-with-output-file"
        //   711: iconst_2       
        //   712: aload_3        
        //   713: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   716: athrow         
        //   717: new             Lgnu/mapping/WrongType;
        //   720: dup_x1         
        //   721: swap           
        //   722: ldc_w           "with-input-from-file"
        //   725: iconst_1       
        //   726: aload_2        
        //   727: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   730: athrow         
        //   731: new             Lgnu/mapping/WrongType;
        //   734: dup_x1         
        //   735: swap           
        //   736: ldc_w           "with-input-from-file"
        //   739: iconst_2       
        //   740: aload_3        
        //   741: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   744: athrow         
        //   745: new             Lgnu/mapping/WrongType;
        //   748: dup_x1         
        //   749: swap           
        //   750: ldc_w           "with-output-to-file"
        //   753: iconst_1       
        //   754: aload_2        
        //   755: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   758: athrow         
        //   759: new             Lgnu/mapping/WrongType;
        //   762: dup_x1         
        //   763: swap           
        //   764: ldc_w           "with-output-to-file"
        //   767: iconst_2       
        //   768: aload_3        
        //   769: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   772: athrow         
        //   773: new             Lgnu/mapping/WrongType;
        //   776: dup_x1         
        //   777: swap           
        //   778: ldc_w           "write-char"
        //   781: iconst_1       
        //   782: aload_2        
        //   783: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   786: athrow         
        //   787: new             Lgnu/mapping/WrongType;
        //   790: dup_x1         
        //   791: swap           
        //   792: ldc_w           "write-char"
        //   795: iconst_2       
        //   796: aload_3        
        //   797: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   800: athrow         
        //   801: new             Lgnu/mapping/WrongType;
        //   804: dup_x1         
        //   805: swap           
        //   806: ldc_w           "write-string"
        //   809: iconst_1       
        //   810: aload_2        
        //   811: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   814: athrow         
        //   815: new             Lgnu/mapping/WrongType;
        //   818: dup_x1         
        //   819: swap           
        //   820: ldc_w           "write-string"
        //   823: iconst_2       
        //   824: aload_3        
        //   825: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   828: athrow         
        //   829: new             Lgnu/mapping/WrongType;
        //   832: dup_x1         
        //   833: swap           
        //   834: ldc_w           "write-u8"
        //   837: iconst_1       
        //   838: aload_2        
        //   839: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   842: athrow         
        //   843: new             Lgnu/mapping/WrongType;
        //   846: dup_x1         
        //   847: swap           
        //   848: ldc_w           "write-bytevector"
        //   851: iconst_1       
        //   852: aload_2        
        //   853: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   856: athrow         
        //   857: new             Lgnu/mapping/WrongType;
        //   860: dup_x1         
        //   861: swap           
        //   862: ldc_w           "call-with-input-string"
        //   865: iconst_1       
        //   866: aload_2        
        //   867: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   870: athrow         
        //   871: new             Lgnu/mapping/WrongType;
        //   874: dup_x1         
        //   875: swap           
        //   876: ldc_w           "call-with-input-string"
        //   879: iconst_2       
        //   880: aload_3        
        //   881: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   884: athrow         
        //   885: new             Lgnu/mapping/WrongType;
        //   888: dup_x1         
        //   889: swap           
        //   890: ldc_w           "read-string"
        //   893: iconst_1       
        //   894: aload_2        
        //   895: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   898: athrow         
        //   899: new             Lgnu/mapping/WrongType;
        //   902: dup_x1         
        //   903: swap           
        //   904: ldc_w           "read-string"
        //   907: iconst_2       
        //   908: aload_3        
        //   909: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   912: athrow         
        //   913: new             Lgnu/mapping/WrongType;
        //   916: dup_x1         
        //   917: swap           
        //   918: ldc_w           "read-bytevector"
        //   921: iconst_1       
        //   922: aload_2        
        //   923: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   926: athrow         
        //   927: new             Lgnu/mapping/WrongType;
        //   930: dup_x1         
        //   931: swap           
        //   932: ldc_w           "read-bytevector!"
        //   935: iconst_1       
        //   936: aload_2        
        //   937: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   940: athrow         
        //   941: new             Lgnu/mapping/WrongType;
        //   944: dup_x1         
        //   945: swap           
        //   946: ldc_w           "write-simple"
        //   949: iconst_2       
        //   950: aload_3        
        //   951: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   954: athrow         
        //   955: new             Lgnu/mapping/WrongType;
        //   958: dup_x1         
        //   959: swap           
        //   960: ldc_w           "write"
        //   963: iconst_2       
        //   964: aload_3        
        //   965: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   968: athrow         
        //   969: new             Lgnu/mapping/WrongType;
        //   972: dup_x1         
        //   973: swap           
        //   974: ldc_w           "write-shared"
        //   977: iconst_2       
        //   978: aload_3        
        //   979: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   982: athrow         
        //   983: new             Lgnu/mapping/WrongType;
        //   986: dup_x1         
        //   987: swap           
        //   988: ldc_w           "write-with-shared-structure"
        //   991: iconst_2       
        //   992: aload_3        
        //   993: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   996: athrow         
        //   997: new             Lgnu/mapping/WrongType;
        //  1000: dup_x1         
        //  1001: swap           
        //  1002: ldc_w           "set-port-line!"
        //  1005: iconst_1       
        //  1006: aload_2        
        //  1007: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1010: athrow         
        //  1011: new             Lgnu/mapping/WrongType;
        //  1014: dup_x1         
        //  1015: swap           
        //  1016: ldc_w           "set-port-line!"
        //  1019: iconst_2       
        //  1020: aload_3        
        //  1021: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1024: athrow         
        //  1025: new             Lgnu/mapping/WrongType;
        //  1028: dup_x1         
        //  1029: swap           
        //  1030: ldc_w           "set-input-port-prompter!"
        //  1033: iconst_1       
        //  1034: aload_2        
        //  1035: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1038: athrow         
        //  1039: new             Lgnu/mapping/WrongType;
        //  1042: dup_x1         
        //  1043: swap           
        //  1044: ldc_w           "set-input-port-prompter!"
        //  1047: iconst_2       
        //  1048: aload_3        
        //  1049: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1052: athrow         
        //  1053: new             Lgnu/mapping/WrongType;
        //  1056: dup_x1         
        //  1057: swap           
        //  1058: ldc_w           "read-line"
        //  1061: iconst_1       
        //  1062: aload_2        
        //  1063: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1066: athrow         
        //  1067: new             Lgnu/mapping/WrongType;
        //  1070: dup_x1         
        //  1071: swap           
        //  1072: ldc_w           "read-line"
        //  1075: iconst_2       
        //  1076: aload_3        
        //  1077: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1080: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  199    202    633    647    Ljava/lang/ClassCastException;
        //  208    211    647    661    Ljava/lang/ClassCastException;
        //  222    225    661    675    Ljava/lang/ClassCastException;
        //  231    234    675    689    Ljava/lang/ClassCastException;
        //  245    248    689    703    Ljava/lang/ClassCastException;
        //  254    257    703    717    Ljava/lang/ClassCastException;
        //  268    271    717    731    Ljava/lang/ClassCastException;
        //  277    280    731    745    Ljava/lang/ClassCastException;
        //  291    294    745    759    Ljava/lang/ClassCastException;
        //  300    303    759    773    Ljava/lang/ClassCastException;
        //  311    314    773    787    Ljava/lang/ClassCastException;
        //  320    323    787    801    Ljava/lang/ClassCastException;
        //  336    339    801    815    Ljava/lang/ClassCastException;
        //  345    348    815    829    Ljava/lang/ClassCastException;
        //  359    365    829    843    Ljava/lang/ClassCastException;
        //  379    382    843    857    Ljava/lang/ClassCastException;
        //  396    399    857    871    Ljava/lang/ClassCastException;
        //  405    408    871    885    Ljava/lang/ClassCastException;
        //  416    422    885    899    Ljava/lang/ClassCastException;
        //  428    431    899    913    Ljava/lang/ClassCastException;
        //  439    445    913    927    Ljava/lang/ClassCastException;
        //  456    459    927    941    Ljava/lang/ClassCastException;
        //  471    474    941    955    Ljava/lang/ClassCastException;
        //  488    491    955    969    Ljava/lang/ClassCastException;
        //  505    508    969    983    Ljava/lang/ClassCastException;
        //  522    525    983    997    Ljava/lang/ClassCastException;
        //  547    550    997    1011   Ljava/lang/ClassCastException;
        //  554    560    1011   1025   Ljava/lang/ClassCastException;
        //  583    586    1025   1039   Ljava/lang/ClassCastException;
        //  592    595    1039   1053   Ljava/lang/ClassCastException;
        //  608    611    1053   1067   Ljava/lang/ClassCastException;
        //  618    621    1067   1081   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 460 out of bounds for length 460
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               22: 40
        //               28: 76
        //               64: 104
        //          default: 129
        //        }
        //    40: aload_2        
        //    41: ldc             Ljava/lang/CharSequence;.class
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    46: checkcast       Ljava/lang/CharSequence;
        //    49: aload_3        
        //    50: ldc             Ljava/lang/Appendable;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: checkcast       Ljava/lang/Appendable;
        //    58: aload           4
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    63: checkcast       Ljava/lang/Number;
        //    66: invokevirtual   java/lang/Number.intValue:()I
        //    69: invokestatic    kawa/lib/ports.writeString:(Ljava/lang/CharSequence;Ljava/lang/Appendable;I)V
        //    72: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    75: areturn        
        //    76: aload_2        
        //    77: ldc             Lgnu/lists/U8Vector;.class
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    82: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    85: aload_3        
        //    86: aload           4
        //    88: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    91: checkcast       Ljava/lang/Number;
        //    94: invokevirtual   java/lang/Number.intValue:()I
        //    97: invokestatic    kawa/lib/ports.writeBytevector:(Lgnu/lists/U8Vector;Ljava/lang/Object;I)V
        //   100: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   103: areturn        
        //   104: aload_2        
        //   105: ldc             Lgnu/lists/U8Vector;.class
        //   107: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   110: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   113: aload_3        
        //   114: aload           4
        //   116: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   119: checkcast       Ljava/lang/Number;
        //   122: invokevirtual   java/lang/Number.intValue:()I
        //   125: invokestatic    kawa/lib/ports.readBytevector$Ex:(Lgnu/lists/U8Vector;Ljava/lang/Object;I)Ljava/lang/Object;
        //   128: areturn        
        //   129: aload_0        
        //   130: aload_1        
        //   131: aload_2        
        //   132: aload_3        
        //   133: aload           4
        //   135: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   138: areturn        
        //   139: new             Lgnu/mapping/WrongType;
        //   142: dup_x1         
        //   143: swap           
        //   144: ldc_w           "write-string"
        //   147: iconst_1       
        //   148: aload_2        
        //   149: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   152: athrow         
        //   153: new             Lgnu/mapping/WrongType;
        //   156: dup_x1         
        //   157: swap           
        //   158: ldc_w           "write-string"
        //   161: iconst_2       
        //   162: aload_3        
        //   163: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   166: athrow         
        //   167: new             Lgnu/mapping/WrongType;
        //   170: dup_x1         
        //   171: swap           
        //   172: ldc_w           "write-string"
        //   175: iconst_3       
        //   176: aload           4
        //   178: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   181: athrow         
        //   182: new             Lgnu/mapping/WrongType;
        //   185: dup_x1         
        //   186: swap           
        //   187: ldc_w           "write-bytevector"
        //   190: iconst_1       
        //   191: aload_2        
        //   192: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   195: athrow         
        //   196: new             Lgnu/mapping/WrongType;
        //   199: dup_x1         
        //   200: swap           
        //   201: ldc_w           "write-bytevector"
        //   204: iconst_3       
        //   205: aload           4
        //   207: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   210: athrow         
        //   211: new             Lgnu/mapping/WrongType;
        //   214: dup_x1         
        //   215: swap           
        //   216: ldc_w           "read-bytevector!"
        //   219: iconst_1       
        //   220: aload_2        
        //   221: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   224: athrow         
        //   225: new             Lgnu/mapping/WrongType;
        //   228: dup_x1         
        //   229: swap           
        //   230: ldc_w           "read-bytevector!"
        //   233: iconst_3       
        //   234: aload           4
        //   236: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   239: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  46     49     139    153    Ljava/lang/ClassCastException;
        //  55     58     153    167    Ljava/lang/ClassCastException;
        //  63     69     167    182    Ljava/lang/ClassCastException;
        //  82     85     182    196    Ljava/lang/ClassCastException;
        //  91     97     196    211    Ljava/lang/ClassCastException;
        //  110    113    211    225    Ljava/lang/ClassCastException;
        //  119    125    225    240    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 104 out of bounds for length 104
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply4(final ModuleMethod p0, final Object p1, final Object p2, final Object p3, final Object p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               22: 40
        //               28: 87
        //               64: 126
        //          default: 162
        //        }
        //    40: aload_2        
        //    41: ldc             Ljava/lang/CharSequence;.class
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    46: checkcast       Ljava/lang/CharSequence;
        //    49: aload_3        
        //    50: ldc             Ljava/lang/Appendable;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: checkcast       Ljava/lang/Appendable;
        //    58: aload           4
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    63: checkcast       Ljava/lang/Number;
        //    66: invokevirtual   java/lang/Number.intValue:()I
        //    69: aload           5
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: checkcast       Ljava/lang/Number;
        //    77: invokevirtual   java/lang/Number.intValue:()I
        //    80: invokestatic    kawa/lib/ports.writeString:(Ljava/lang/CharSequence;Ljava/lang/Appendable;II)V
        //    83: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    86: areturn        
        //    87: aload_2        
        //    88: ldc             Lgnu/lists/U8Vector;.class
        //    90: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    93: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //    96: aload_3        
        //    97: aload           4
        //    99: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   102: checkcast       Ljava/lang/Number;
        //   105: invokevirtual   java/lang/Number.intValue:()I
        //   108: aload           5
        //   110: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   113: checkcast       Ljava/lang/Number;
        //   116: invokevirtual   java/lang/Number.intValue:()I
        //   119: invokestatic    kawa/lib/ports.writeBytevector:(Lgnu/lists/U8Vector;Ljava/lang/Object;II)V
        //   122: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   125: areturn        
        //   126: aload_2        
        //   127: ldc             Lgnu/lists/U8Vector;.class
        //   129: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   132: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToU8Vector:(Ljava/lang/Object;)Lgnu/lists/U8Vector;
        //   135: aload_3        
        //   136: aload           4
        //   138: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   141: checkcast       Ljava/lang/Number;
        //   144: invokevirtual   java/lang/Number.intValue:()I
        //   147: aload           5
        //   149: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   152: checkcast       Ljava/lang/Number;
        //   155: invokevirtual   java/lang/Number.intValue:()I
        //   158: invokestatic    kawa/lib/ports.readBytevector$Ex:(Lgnu/lists/U8Vector;Ljava/lang/Object;II)Ljava/lang/Object;
        //   161: areturn        
        //   162: aload_0        
        //   163: aload_1        
        //   164: aload_2        
        //   165: aload_3        
        //   166: aload           4
        //   168: aload           5
        //   170: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   173: areturn        
        //   174: new             Lgnu/mapping/WrongType;
        //   177: dup_x1         
        //   178: swap           
        //   179: ldc_w           "write-string"
        //   182: iconst_1       
        //   183: aload_2        
        //   184: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   187: athrow         
        //   188: new             Lgnu/mapping/WrongType;
        //   191: dup_x1         
        //   192: swap           
        //   193: ldc_w           "write-string"
        //   196: iconst_2       
        //   197: aload_3        
        //   198: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   201: athrow         
        //   202: new             Lgnu/mapping/WrongType;
        //   205: dup_x1         
        //   206: swap           
        //   207: ldc_w           "write-string"
        //   210: iconst_3       
        //   211: aload           4
        //   213: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   216: athrow         
        //   217: new             Lgnu/mapping/WrongType;
        //   220: dup_x1         
        //   221: swap           
        //   222: ldc_w           "write-string"
        //   225: iconst_4       
        //   226: aload           5
        //   228: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   231: athrow         
        //   232: new             Lgnu/mapping/WrongType;
        //   235: dup_x1         
        //   236: swap           
        //   237: ldc_w           "write-bytevector"
        //   240: iconst_1       
        //   241: aload_2        
        //   242: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   245: athrow         
        //   246: new             Lgnu/mapping/WrongType;
        //   249: dup_x1         
        //   250: swap           
        //   251: ldc_w           "write-bytevector"
        //   254: iconst_3       
        //   255: aload           4
        //   257: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   260: athrow         
        //   261: new             Lgnu/mapping/WrongType;
        //   264: dup_x1         
        //   265: swap           
        //   266: ldc_w           "write-bytevector"
        //   269: iconst_4       
        //   270: aload           5
        //   272: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   275: athrow         
        //   276: new             Lgnu/mapping/WrongType;
        //   279: dup_x1         
        //   280: swap           
        //   281: ldc_w           "read-bytevector!"
        //   284: iconst_1       
        //   285: aload_2        
        //   286: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   289: athrow         
        //   290: new             Lgnu/mapping/WrongType;
        //   293: dup_x1         
        //   294: swap           
        //   295: ldc_w           "read-bytevector!"
        //   298: iconst_3       
        //   299: aload           4
        //   301: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   304: athrow         
        //   305: new             Lgnu/mapping/WrongType;
        //   308: dup_x1         
        //   309: swap           
        //   310: ldc_w           "read-bytevector!"
        //   313: iconst_4       
        //   314: aload           5
        //   316: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   319: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  46     49     174    188    Ljava/lang/ClassCastException;
        //  55     58     188    202    Ljava/lang/ClassCastException;
        //  63     69     202    217    Ljava/lang/ClassCastException;
        //  74     80     217    232    Ljava/lang/ClassCastException;
        //  93     96     232    246    Ljava/lang/ClassCastException;
        //  102    108    246    261    Ljava/lang/ClassCastException;
        //  113    119    261    276    Ljava/lang/ClassCastException;
        //  132    135    276    290    Ljava/lang/ClassCastException;
        //  141    147    290    305    Ljava/lang/ClassCastException;
        //  152    158    305    320    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 141 out of bounds for length 141
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public class 0 extends ThreadLocation
    {
        public 0() {
            super(ports.Lit5, Path.pathLocation);
        }
        
        @Override
        public void set(final Object new$Mnvalue) {
            super.set(Path.valueOf(new$Mnvalue));
        }
    }
}
