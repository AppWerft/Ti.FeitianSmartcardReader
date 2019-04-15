/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.ClassType;
import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.BinaryOutPort;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.CharArrayOutPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.PrettyWriter;
import gnu.kawa.io.TtyInPort;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.Consumer;
import gnu.lists.EofClass;
import gnu.lists.FString;
import gnu.lists.U8Vector;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.LocationProc;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Externalizable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import kawa.SourceMethodType;
import kawa.standard.char_ready_p;
import kawa.standard.read_line;

public class ports
extends ModuleBody {
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
        LocationProc locationProc;
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        current$Mninput$Mnport = locationProc = LocationProc.makeNamed(Lit0, InPort.inLocation);
        current$Mninput$Mnport.pushConverter(lambda$Fn1);
        current$Mnoutput$Mnport = locationProc = LocationProc.makeNamed(Lit2, OutPort.outLocation);
        current$Mnoutput$Mnport.pushConverter(lambda$Fn2);
        current$Mnerror$Mnport = locationProc = LocationProc.makeNamed(Lit4, OutPort.errLocation);
        current$Mnerror$Mnport.pushConverter(lambda$Fn3);
        current$Mnpath = LocationProc.makeNamed(Lit5, new 0());
        port$Mnline.setProperty(Lit6, set$Mnport$Mnline$Ex);
        ModuleMethod port$Mnline = port$Mnline$Fn4;
        ModuleMethod moduleMethod = port$Mnline$Fn4;
        ports.port$Mnline.add(moduleMethod);
        input$Mnport$Mnline$Mnnumber.setProperty(Lit6, set$Mninput$Mnport$Mnline$Mnnumber$Ex);
        ModuleMethod input$Mnport$Mnline$Mnnumber = input$Mnport$Mnline$Mnnumber$Fn5;
        moduleMethod = input$Mnport$Mnline$Mnnumber$Fn5;
        ports.input$Mnport$Mnline$Mnnumber.add(moduleMethod);
        input$Mnport$Mnprompter.setProperty(Lit6, set$Mninput$Mnport$Mnprompter$Ex);
        ModuleMethod input$Mnport$Mnprompter = input$Mnport$Mnprompter$Fn6;
        moduleMethod = input$Mnport$Mnprompter$Fn6;
        ports.input$Mnport$Mnprompter.add(moduleMethod);
    }

    public static InPort openInputFile(Path name) {
        return InPort.openFile(name);
    }

    public static BinaryInPort openBinaryInputFile(Path name) {
        return BinaryInPort.openFile(name);
    }

    public static OutPort openOutputFile(Path name) {
        return OutPort.openFile(name);
    }

    public static BinaryOutPort openBinaryOutputFile(Path name) {
        return BinaryOutPort.openFile(name);
    }

    public static Object callWithPort(Closeable port, Procedure proc) {
        Object object2;
        try {
            object2 = proc.apply1(port);
            Object var4_3 = null;
        }
        catch (Throwable throwable) {
            Object var4_4 = null;
            ports.closePort(port);
            throw throwable;
        }
        ports.closePort(port);
        {
        }
        return object2;
    }

    public static void closePort(Closeable port) {
        port.close();
    }

    public static Object callWithInputFile(Path path, Procedure proc) {
        Object object2;
        InPort port = ports.openInputFile(path);
        try {
            object2 = proc.apply1(port);
            Object var5_4 = null;
        }
        catch (Throwable throwable) {
            Object var5_5 = null;
            ports.closeInputPort(port);
            throw throwable;
        }
        ports.closeInputPort(port);
        {
        }
        return object2;
    }

    public static void closeInputPort(Reader port) {
        port.close();
    }

    public static Object callWithOutputFile(Path path, Procedure proc) {
        Object object2;
        OutPort port = ports.openOutputFile(path);
        try {
            object2 = proc.apply1(port);
            Object var5_4 = null;
        }
        catch (Throwable throwable) {
            Object var5_5 = null;
            ports.closeOutputPort(port);
            throw throwable;
        }
        ports.closeOutputPort(port);
        {
        }
        return object2;
    }

    public static void closeOutputPort(Writer port) {
        port.close();
    }

    public static Object withInputFromFile(Path pathname, Procedure proc) {
        Object object2;
        void port;
        InPort inPort = InPort.openFile(pathname);
        InPort save = InPort.inDefault();
        try {
            InPort.setInDefault((InPort)port);
            object2 = proc.apply0();
            Object var6_5 = null;
        }
        catch (Throwable throwable) {
            Object var6_6 = null;
            InPort.setInDefault(save);
            port.close();
            throw throwable;
        }
        InPort.setInDefault(save);
        port.close();
        {
        }
        return object2;
    }

    public static Object withOutputToFile(Path path, Procedure proc) {
        Object object2;
        OutPort port = OutPort.openFile(path);
        OutPort save = OutPort.outDefault();
        try {
            OutPort.setOutDefault(port);
            object2 = proc.apply0();
            Object var6_5 = null;
        }
        catch (Throwable throwable) {
            Object var6_6 = null;
            OutPort.setOutDefault(save);
            port.close();
            throw throwable;
        }
        OutPort.setOutDefault(save);
        port.close();
        {
        }
        return object2;
    }

    public static boolean isInputPort(Object x) {
        return x instanceof InPort;
    }

    public static boolean isOutputPort(Object x) {
        return x instanceof OutPort;
    }

    public static boolean isTextualPort(Object obj) {
        boolean x = ports.isInputPort(obj);
        return x ? x : ports.isOutputPort(obj);
    }

    public static boolean isBinaryPort(Object obj) {
        boolean x = obj instanceof BinaryInPort;
        return x ? x : obj instanceof BinaryOutPort;
    }

    public static boolean isPort(Object x) {
        boolean x2 = ports.isInputPort(x);
        return x2 ? x2 : ports.isOutputPort(x);
    }

    public static boolean isInputPortOpen(Object port) {
        return port instanceof OutPort ? false : ((InPort)Promise.force(port, InPort.class)).isOpen();
    }

    public static boolean isOutputPortOpen(Object port) {
        return port instanceof InPort ? false : ((OutPort)Promise.force(port, OutPort.class)).isOpen();
    }

    static InPort lambda1(Object arg) {
        InPort inPort;
        try {
            inPort = (InPort)Promise.force(arg, InPort.class);
        }
        catch (ClassCastException ex) {
            WrongType wt = WrongType.make(ex, current$Mninput$Mnport, 1, arg);
            wt.expectedType = Lit1;
            throw wt;
        }
        return inPort;
    }

    static OutPort lambda2(Object arg) {
        OutPort outPort;
        try {
            outPort = (OutPort)Promise.force(arg, OutPort.class);
        }
        catch (ClassCastException ex) {
            WrongType wt = WrongType.make(ex, current$Mnoutput$Mnport, 1, arg);
            wt.expectedType = Lit3;
            throw wt;
        }
        return outPort;
    }

    static OutPort lambda3(Object arg) {
        OutPort outPort;
        try {
            outPort = (OutPort)Promise.force(arg, OutPort.class);
        }
        catch (ClassCastException ex) {
            WrongType wt = WrongType.make(ex, current$Mnerror$Mnport, 1, arg);
            wt.expectedType = Lit3;
            throw wt;
        }
        return outPort;
    }

    @SourceMethodType(value={"", "character"})
    public static void writeChar(int n) {
        ports.writeChar(n, OutPort.outDefault());
    }

    @SourceMethodType(value={"", "character"})
    public static void writeChar(int ch, Appendable port) {
        Char.append(ch, port);
    }

    public static void writeString(CharSequence charSequence) {
        ports.writeString(charSequence, current$Mnoutput$Mnport.getValue(), 0);
    }

    public static void writeString(CharSequence charSequence, Appendable appendable) {
        ports.writeString(charSequence, appendable, 0);
    }

    public static void writeString(CharSequence charSequence, Appendable appendable, int n) {
        ports.writeString(charSequence, appendable, n, charSequence.length());
    }

    public static void writeString(CharSequence str, Appendable port, int start, int end) {
        port.append(str, start, end);
    }

    public static void writeU8(int n) {
        ports.writeU8(n, current$Mnoutput$Mnport.getValue());
    }

    public static void writeU8(int n, Object port) {
        BinaryOutPort.asOutputStream(port).write(n);
    }

    public static void writeBytevector(U8Vector u8Vector) {
        ports.writeBytevector(u8Vector, current$Mnoutput$Mnport.getValue(), 0);
    }

    public static void writeBytevector(U8Vector u8Vector, Object object2) {
        ports.writeBytevector(u8Vector, object2, 0);
    }

    public static void writeBytevector(U8Vector u8Vector, Object object2, int n) {
        ports.writeBytevector(u8Vector, object2, n, u8Vector.size());
    }

    public static void writeBytevector(U8Vector bytes, Object port, int start, int end) {
        bytes.writeTo(start, end - start, BinaryOutPort.asOutputStream(port));
    }

    public static CharArrayInPort openInputString(CharSequence str) {
        return CharArrayInPort.make(str);
    }

    public static CharArrayOutPort openOutputString() {
        return new CharArrayOutPort();
    }

    public static FString getOutputString(CharArrayOutPort output$Mnport) {
        return new FString(output$Mnport.toCharArray());
    }

    public static BinaryInPort openInputBytevector(U8Vector bvector) {
        BinaryInPort p = new BinaryInPort(bvector.getBuffer(), bvector.size(), Path.valueOf("<bytevector>"));
        p.setCharset("ISO-8859-1");
        return p;
    }

    public static BinaryOutPort openOutputBytevector() {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        return new BinaryOutPort(bo, Path.valueOf("<bytevector>"));
    }

    public static U8Vector getOutputBytevector(BinaryOutPort port) {
        ByteArrayOutputStream bo;
        OutputStream outputStream = port.getOutputStream();
        try {
            bo = (ByteArrayOutputStream)outputStream;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "bo", -2, (Object)outputStream);
        }
        return new U8Vector(bo.toByteArray());
    }

    public static Object callWithInputString(CharSequence str, Procedure proc) {
        CharArrayInPort port = CharArrayInPort.make(str);
        Object result = proc.apply1(port);
        ports.closeInputPort(port);
        return result;
    }

    public static FString callWithOutputString(Procedure proc) {
        CharArrayOutPort port = new CharArrayOutPort();
        proc.apply1(port);
        char[] chars = port.toCharArray();
        port.close();
        return new FString(chars);
    }

    public static void flushOutputPort() {
        ports.flushOutputPort(current$Mnoutput$Mnport.getValue());
    }

    public static void flushOutputPort(Object port) {
        if (port instanceof OutputStream) {
            ((OutputStream)Promise.force(port, OutputStream.class)).flush();
        } else {
            ((Writer)Promise.force(port, Writer.class)).flush();
        }
    }

    public static void forceOutput() {
        ports.forceOutput(current$Mnoutput$Mnport.getValue());
    }

    public static void forceOutput(Object port) {
        if (port instanceof OutputStream) {
            ((OutputStream)Promise.force(port, OutputStream.class)).flush();
        } else {
            ((Writer)Promise.force(port, Writer.class)).flush();
        }
    }

    public static void newline() {
        ports.newline(current$Mnoutput$Mnport.getValue());
    }

    public static void newline(Object port) {
        Object object2 = Promise.force(port, OutPort.class);
        try {
            ((OutPort)object2).println();
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.io.OutPort.println()", 1, object2);
        }
    }

    public static boolean isEofObject(Object obj) {
        return Promise.force(obj) == EofClass.eofValue;
    }

    public static EofClass eofObject() {
        return EofClass.eofValue;
    }

    public static boolean isCharReady() {
        return ports.isCharReady(current$Mninput$Mnport.getValue());
    }

    public static boolean isCharReady(Object port) {
        return char_ready_p.ready(port);
    }

    @SourceMethodType(value={"character-or-eof"})
    public static int readChar() {
        return ports.readChar(current$Mninput$Mnport.getValue());
    }

    @SourceMethodType(value={"character-or-eof"})
    public static int readChar(Object port) {
        return port instanceof InputStream ? ((InputStream)Promise.force(port, InputStream.class)).read() : ((InPort)Promise.force(port, InPort.class)).readCodePoint();
    }

    @SourceMethodType(value={"character-or-eof"})
    public static int peekChar() {
        return ports.peekChar(current$Mninput$Mnport.getValue());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @SourceMethodType(value={"character-or-eof"})
    public static int peekChar(Object port) {
        InputStream is;
        int n;
        if (!(port instanceof InputStream)) {
            n = ((InPort)Promise.force(port, InPort.class)).peekCodePoint();
            return n;
        }
        Object object2 = Promise.force(port, InputStream.class);
        try {
            is = (InputStream)object2;
        }
        catch (ClassCastException classCastException) {
            void ch;
            throw new WrongType(classCastException, "is", -2, (Object)ch);
        }
        is.mark(1);
        int ch = is.read();
        is.reset();
        n = ch;
        return n;
    }

    public static Object readString(int n) {
        return ports.readString(n, current$Mninput$Mnport.getValue());
    }

    public static Object readString(int k, InPort port) {
        Externalizable externalizable;
        char[] arr = new char[k];
        int n = 0;
        do {
            int n2;
            int m;
            int seen;
            if ((n2 = port.read(arr, seen = n, m = k - seen)) < 0) {
                if (seen > 0) {
                    externalizable = new FString(arr, 0, seen);
                    break;
                }
                externalizable = EofClass.eofValue;
                break;
            }
            if (n2 == m) {
                externalizable = new FString(arr);
                break;
            }
            n = seen + n2;
        } while (true);
        return externalizable;
    }

    public static Object readU8() {
        return ports.readU8(current$Mninput$Mnport.getValue());
    }

    public static Object readU8(Object port) {
        int b = port instanceof BinaryInPort ? ((BinaryInPort)Promise.force(port, BinaryInPort.class)).readByte() : ((InputStream)Promise.force(port, InputStream.class)).read();
        return b < 0 ? EofClass.eofValue : Integer.valueOf(b);
    }

    public static Object peekU8() {
        return ports.peekU8(current$Mninput$Mnport.getValue());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object peekU8(Object port) {
        Serializable serializable;
        int b;
        int n;
        if (port instanceof BinaryInPort) {
            n = ((BinaryInPort)Promise.force(port, BinaryInPort.class)).peekByte();
        } else {
            Object object2 = Promise.force(port, InputStream.class);
            InputStream ins = (InputStream)object2;
            ins.mark(1);
            int b2 = ins.read();
            ins.reset();
            n = b = b2;
        }
        if (b < 0) {
            serializable = EofClass.eofValue;
            return serializable;
        }
        serializable = Integer.valueOf(b);
        return serializable;
        catch (ClassCastException classCastException) {
            void b2;
            throw new WrongType(classCastException, "ins", -2, (Object)b2);
        }
    }

    public static boolean isU8Ready() {
        return ports.isU8Ready(current$Mninput$Mnport.getValue());
    }

    public static boolean isU8Ready(Object port) {
        return port instanceof BinaryInPort ? ((BinaryInPort)Promise.force(port, BinaryInPort.class)).ready() : ((InputStream)Promise.force(port, InputStream.class)).available() > 0;
    }

    public static Object readBytevector(int n) {
        return ports.readBytevector(n, current$Mninput$Mnport.getValue());
    }

    public static Object readBytevector(int k, Object port) {
        Externalizable externalizable;
        byte[] arr = new byte[k];
        int n = 0;
        do {
            int n2;
            int seen = n;
            int m = k - seen;
            int n3 = n2 = port instanceof BinaryInPort ? ((BinaryInPort)Promise.force(port, BinaryInPort.class)).readBytes(arr, seen, m) : ((InputStream)Promise.force(port, InputStream.class)).read(arr, seen, m);
            if (n2 < 0) {
                if (seen > 0) {
                    externalizable = new U8Vector(arr, 0, seen);
                    break;
                }
                externalizable = EofClass.eofValue;
                break;
            }
            if (n2 == m) {
                externalizable = new U8Vector(arr);
                break;
            }
            n = seen + n2;
        } while (true);
        return externalizable;
    }

    public static Object readBytevector$Ex(U8Vector u8Vector) {
        return ports.readBytevector$Ex(u8Vector, current$Mninput$Mnport.getValue(), 0);
    }

    public static Object readBytevector$Ex(U8Vector u8Vector, Object object2) {
        return ports.readBytevector$Ex(u8Vector, object2, 0);
    }

    public static Object readBytevector$Ex(U8Vector u8Vector, Object object2, int n) {
        return ports.readBytevector$Ex(u8Vector, object2, n, u8Vector.size());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object readBytevector$Ex(U8Vector bv, Object port, int start, int end) {
        int n;
        int n2 = 0;
        do {
            InputStream inputStream;
            Serializable serializable;
            int seen = n2;
            int want = end - start - seen;
            if (port instanceof BinaryInPort) {
                inputStream = ((BinaryInPort)Promise.force(port, BinaryInPort.class)).getInputStream();
            } else {
                Object object2 = Promise.force(port, InputStream.class);
                inputStream = (InputStream)object2;
            }
            InputStream is = inputStream;
            n = bv.readFrom(start + seen, want, is);
            if (n < 0) {
                if (seen > 0) {
                    serializable = Integer.valueOf(seen);
                    return serializable;
                }
                serializable = EofClass.eofValue;
                return serializable;
            }
            if (n == want) {
                serializable = Integer.valueOf(seen + n);
                return serializable;
            }
            n2 = seen + n;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "is", -2, (Object)n);
        }
    }

    public static void writeSimple(Object object2) {
        ports.writeSimple(object2, current$Mnoutput$Mnport.getValue());
    }

    public static void writeSimple(Object value, OutPort out) {
        DisplayFormat.schemeWriteSimpleFormat.format(value, out);
    }

    public static void write(Object object2) {
        ports.write(object2, current$Mnoutput$Mnport.getValue());
    }

    public static void write(Object value, OutPort out) {
        try {
            (IsEqv.apply(((Location)PrettyWriter.isSharing).get(), Boolean.TRUE) ? DisplayFormat.schemeWriteSharedFormat : DisplayFormat.schemeWriteFormat).format(value, out);
        }
        catch (UnboundLocationException unboundLocationException) {
            unboundLocationException.setLine("/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/ports.scm", 289, 14);
            throw unboundLocationException;
        }
    }

    public static void writeShared(Object object2) {
        ports.writeShared(object2, current$Mnoutput$Mnport.getValue());
    }

    public static void writeShared(Object value, OutPort out) {
        DisplayFormat.schemeWriteSharedFormat.format(value, out);
    }

    public static void writeWithSharedStructure(Object object2) {
        ports.writeWithSharedStructure(object2, current$Mnoutput$Mnport.getValue());
    }

    public static void writeWithSharedStructure(Object value, OutPort out) {
        DisplayFormat.schemeWriteSharedFormat.format(value, out);
    }

    public static void display(Object object2) {
        ports.display(object2, current$Mnoutput$Mnport.getValue());
    }

    public static void display(Object value, Object out) {
        Object object2 = Promise.force(out, Consumer.class);
        try {
            DisplayFormat.schemeDisplayFormat.format(value, (Consumer)object2);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.functions.DisplayFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, object2);
        }
    }

    public static char inputPortReadState(Object port) {
        Object object2 = Promise.force(port, InPort.class);
        try {
            return ((InPort)object2).getReadState();
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.io.InPort.getReadState()", 1, object2);
        }
    }

    public static void setPortLine$Ex(InPort port, int line) {
        port.setLineNumber(line);
    }

    public static int portLine(InPort port) {
        return port.getLineNumber();
    }

    /*
     * Exception decompiling
     */
    public static void setInputPortLineNumber$Ex(Object port, Object num) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public static Object inputPortLineNumber(InPort port) {
        return AddOp.apply2(1, Lit7, ((Procedure)port$Mnline).apply1(port));
    }

    public static int portColumn(InPort port) {
        return port.getColumnNumber();
    }

    public static int inputPortColumnNumber(Object port) {
        Object object2 = Promise.force(port, InPort.class);
        try {
            return 1 + ports.portColumn((InPort)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "port-column", 0, object2);
        }
    }

    public static void setInputPortPrompter$Ex(TtyInPort port, Procedure prompter) {
        port.setPrompter(prompter);
    }

    public static Procedure inputPortPrompter(TtyInPort port) {
        return port.getPrompter();
    }

    public static Object read() {
        return ports.read(current$Mninput$Mnport.getValue());
    }

    public static Object read(InPort port) {
        void var2_4;
        LispReader lexer = new LispReader(port);
        lexer.setReturnMutablePairs(true);
        try {
            void ex;
            Object result = lexer.readObject();
            if (lexer.seenErrors()) {
                throw new SyntaxException(lexer.getMessages());
            }
            var2_4 = ex;
        }
        catch (SyntaxException ex) {
            ex.setHeader("syntax error in read:");
            throw ex;
        }
        return var2_4;
    }

    public static Object readLine() {
        return ports.readLine(current$Mninput$Mnport.getValue(), Lit8);
    }

    public static Object readLine(InPort inPort) {
        return ports.readLine(inPort, Lit8);
    }

    public static Object readLine(InPort port, Symbol handling) {
        return read_line.apply(port, handling.toString());
    }

    public static void transcriptOn(Object filename) {
        OutPort.setLogFile(filename.toString());
    }

    public static void transcriptOff() {
        OutPort.closeLogFile();
    }

    public static {
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
        ports ports2 = $instance = new ports();
        open$Mninput$Mnfile = new ModuleMethod(ports2, 1, Lit9, 4097);
        open$Mnbinary$Mninput$Mnfile = new ModuleMethod(ports2, 2, Lit10, 4097);
        open$Mnoutput$Mnfile = new ModuleMethod(ports2, 3, Lit11, 4097);
        open$Mnbinary$Mnoutput$Mnfile = new ModuleMethod(ports2, 4, Lit12, 4097);
        call$Mnwith$Mnport = new ModuleMethod(ports2, 5, Lit13, 8194);
        call$Mnwith$Mninput$Mnfile = new ModuleMethod(ports2, 6, Lit14, 8194);
        call$Mnwith$Mnoutput$Mnfile = new ModuleMethod(ports2, 7, Lit15, 8194);
        with$Mninput$Mnfrom$Mnfile = new ModuleMethod(ports2, 8, Lit16, 8194);
        with$Mnoutput$Mnto$Mnfile = new ModuleMethod(ports2, 9, Lit17, 8194);
        input$Mnport$Qu = new ModuleMethod(ports2, 10, Lit18, 4097);
        output$Mnport$Qu = new ModuleMethod(ports2, 11, Lit19, 4097);
        textual$Mnport$Qu = new ModuleMethod(ports2, 12, Lit20, 4097);
        binary$Mnport$Qu = new ModuleMethod(ports2, 13, Lit21, 4097);
        port$Qu = new ModuleMethod(ports2, 14, Lit22, 4097);
        input$Mnport$Mnopen$Qu = new ModuleMethod(ports2, 15, Lit23, 4097);
        output$Mnport$Mnopen$Qu = new ModuleMethod(ports2, 16, Lit24, 4097);
        lambda$Fn1 = new ModuleMethod(ports2, 17, null, 4097);
        lambda$Fn2 = new ModuleMethod(ports2, 18, null, 4097);
        lambda$Fn3 = new ModuleMethod(ports2, 19, null, 4097);
        write$Mnchar = new ModuleMethod(ports2, 20, Lit25, 8193);
        write$Mnstring = new ModuleMethod(ports2, 22, Lit26, 16385);
        write$Mnu8 = new ModuleMethod(ports2, 26, Lit27, 8193);
        write$Mnbytevector = new ModuleMethod(ports2, 28, Lit28, 16385);
        open$Mninput$Mnstring = new ModuleMethod(ports2, 32, Lit29, 4097);
        open$Mnoutput$Mnstring = new ModuleMethod(ports2, 33, Lit30, 0);
        get$Mnoutput$Mnstring = new ModuleMethod(ports2, 34, Lit31, 4097);
        open$Mninput$Mnbytevector = new ModuleMethod(ports2, 35, Lit32, 4097);
        open$Mnoutput$Mnbytevector = new ModuleMethod(ports2, 36, Lit33, 0);
        get$Mnoutput$Mnbytevector = new ModuleMethod(ports2, 37, Lit34, 4097);
        call$Mnwith$Mninput$Mnstring = new ModuleMethod(ports2, 38, Lit35, 8194);
        call$Mnwith$Mnoutput$Mnstring = new ModuleMethod(ports2, 39, Lit36, 4097);
        flush$Mnoutput$Mnport = new ModuleMethod(ports2, 40, Lit37, 4096);
        force$Mnoutput = new ModuleMethod(ports2, 42, Lit38, 4096);
        newline = new ModuleMethod(ports2, 44, Lit39, 4096);
        ModuleMethod moduleMethod = new ModuleMethod(ports2, 46, Lit40, 4097);
        moduleMethod.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:isEofValidateApply");
        eof$Mnobject$Qu = moduleMethod;
        eof$Mnobject = new ModuleMethod(ports2, 47, Lit41, 0);
        char$Mnready$Qu = new ModuleMethod(ports2, 48, Lit42, 4096);
        read$Mnchar = new ModuleMethod(ports2, 50, Lit43, 4096);
        peek$Mnchar = new ModuleMethod(ports2, 52, Lit44, 4096);
        read$Mnstring = new ModuleMethod(ports2, 54, Lit45, 8193);
        read$Mnu8 = new ModuleMethod(ports2, 56, Lit46, 4096);
        peek$Mnu8 = new ModuleMethod(ports2, 58, Lit47, 4096);
        u8$Mnready$Qu = new ModuleMethod(ports2, 60, Lit48, 4096);
        read$Mnbytevector = new ModuleMethod(ports2, 62, Lit49, 8193);
        read$Mnbytevector$Ex = new ModuleMethod(ports2, 64, Lit50, 16385);
        write$Mnsimple = new ModuleMethod(ports2, 68, Lit51, 8193);
        write = new ModuleMethod(ports2, 70, Lit52, 8193);
        write$Mnshared = new ModuleMethod(ports2, 72, Lit53, 8193);
        write$Mnwith$Mnshared$Mnstructure = new ModuleMethod(ports2, 74, Lit54, 8193);
        display = new ModuleMethod(ports2, 76, Lit55, 8193);
        input$Mnport$Mnread$Mnstate = new ModuleMethod(ports2, 78, Lit56, 4097);
        set$Mnport$Mnline$Ex = new ModuleMethod(ports2, 79, Lit57, 8194);
        port$Mnline = new GenericProc("port-line");
        port$Mnline$Fn4 = new ModuleMethod(ports2, 80, Lit58, 4097);
        set$Mninput$Mnport$Mnline$Mnnumber$Ex = new ModuleMethod(ports2, 81, Lit59, 8194);
        input$Mnport$Mnline$Mnnumber = new GenericProc("input-port-line-number");
        input$Mnport$Mnline$Mnnumber$Fn5 = new ModuleMethod(ports2, 82, Lit60, 4097);
        port$Mncolumn = new ModuleMethod(ports2, 83, Lit61, 4097);
        input$Mnport$Mncolumn$Mnnumber = new ModuleMethod(ports2, 84, Lit62, 4097);
        set$Mninput$Mnport$Mnprompter$Ex = new ModuleMethod(ports2, 85, Lit63, 8194);
        input$Mnport$Mnprompter = new GenericProc("input-port-prompter");
        input$Mnport$Mnprompter$Fn6 = new ModuleMethod(ports2, 86, Lit64, 4097);
        close$Mnport = new ModuleMethod(ports2, 87, Lit65, 4097);
        close$Mninput$Mnport = new ModuleMethod(ports2, 88, Lit66, 4097);
        close$Mnoutput$Mnport = new ModuleMethod(ports2, 89, Lit67, 4097);
        read = new ModuleMethod(ports2, 90, Lit68, 4096);
        read$Mnline = new ModuleMethod(ports2, 92, Lit69, 8192);
        transcript$Mnon = new ModuleMethod(ports2, 95, Lit70, 4097);
        transcript$Mnoff = new ModuleMethod(ports2, 96, Lit71, 0);
        ports.$runBody$();
    }

    public ports() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 96: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 92: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 90: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 60: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 58: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 56: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 52: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 50: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 48: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 47: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 44: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 42: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 40: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 36: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 33: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 95: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 92: {
                Object object3 = Promise.force(object2, InPort.class);
                if (!(object3 instanceof InPort)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 90: {
                Object object4 = Promise.force(object2, InPort.class);
                if (!(object4 instanceof InPort)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 89: {
                Object object5 = Promise.force(object2, Writer.class);
                if (!(object5 instanceof Writer)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 88: {
                Object object6 = Promise.force(object2, Reader.class);
                if (!(object6 instanceof Reader)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 87: {
                Object object7 = Promise.force(object2, Closeable.class);
                if (!(object7 instanceof Closeable)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 86: {
                Object object8 = Promise.force(object2, TtyInPort.class);
                if (!(object8 instanceof TtyInPort)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 84: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 83: {
                Object object9 = Promise.force(object2, InPort.class);
                if (!(object9 instanceof InPort)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 82: {
                Object object10 = Promise.force(object2, InPort.class);
                if (!(object10 instanceof InPort)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 80: {
                Object object11 = Promise.force(object2, InPort.class);
                if (!(object11 instanceof InPort)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 78: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 76: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 74: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 72: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 70: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 68: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 64: {
                Object object12 = Promise.force(object2, U8Vector.class);
                if (!(object12 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 62: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 60: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 58: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 56: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 54: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 52: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 50: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 48: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 46: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 44: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 42: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 40: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 39: {
                Object object13 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object13) == null) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 37: {
                Object object14 = Promise.force(object2, BinaryOutPort.class);
                if (!(object14 instanceof BinaryOutPort)) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 35: {
                Object object15 = Promise.force(object2, U8Vector.class);
                if (!(object15 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 34: {
                Object object16 = Promise.force(object2, CharArrayOutPort.class);
                if (!(object16 instanceof CharArrayOutPort)) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 32: {
                Object object17 = Promise.force(object2, CharSequence.class);
                if (!(object17 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 28: {
                Object object18 = Promise.force(object2, U8Vector.class);
                if (!(object18 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 26: {
                callContext.value1 = Promise.force(object2);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 22: {
                Object object19 = Promise.force(object2, CharSequence.class);
                if (!(object19 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 20: {
                Object object20 = Promise.force(object2);
                if (Char.checkCharOrEof(object20) < 0) {
                    return -786431;
                }
                callContext.value1 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 19: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object21 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object21) == null) {
                    return -786431;
                }
                callContext.value1 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                Object object22 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object22) == null) {
                    return -786431;
                }
                callContext.value1 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                Object object23 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object23) == null) {
                    return -786431;
                }
                callContext.value1 = object23;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                Object object24 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object24) == null) {
                    return -786431;
                }
                callContext.value1 = object24;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 92: {
                Object object4 = Promise.force(object2, InPort.class);
                if (!(object4 instanceof InPort)) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, Symbol.class);
                if (!(object5 instanceof Symbol)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 85: {
                Object object6 = Promise.force(object2, TtyInPort.class);
                if (!(object6 instanceof TtyInPort)) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 81: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 79: {
                Object object8 = Promise.force(object2, InPort.class);
                if (!(object8 instanceof InPort)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 76: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 74: {
                callContext.value1 = object2;
                Object object9 = Promise.force(object3, OutPort.class);
                if (!(object9 instanceof OutPort)) {
                    return -786430;
                }
                callContext.value2 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 72: {
                callContext.value1 = object2;
                Object object10 = Promise.force(object3, OutPort.class);
                if (!(object10 instanceof OutPort)) {
                    return -786430;
                }
                callContext.value2 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 70: {
                callContext.value1 = object2;
                Object object11 = Promise.force(object3, OutPort.class);
                if (!(object11 instanceof OutPort)) {
                    return -786430;
                }
                callContext.value2 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 68: {
                callContext.value1 = object2;
                Object object12 = Promise.force(object3, OutPort.class);
                if (!(object12 instanceof OutPort)) {
                    return -786430;
                }
                callContext.value2 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 64: {
                Object object13 = Promise.force(object2, U8Vector.class);
                if (!(object13 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 62: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 54: {
                callContext.value1 = Promise.force(object2);
                Object object14 = Promise.force(object3, InPort.class);
                if (!(object14 instanceof InPort)) {
                    return -786430;
                }
                callContext.value2 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 38: {
                Object object15 = Promise.force(object2, CharSequence.class);
                if (!(object15 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object15;
                Object object16 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object16) == null) {
                    return -786430;
                }
                callContext.value2 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 28: {
                Object object17 = Promise.force(object2, U8Vector.class);
                if (!(object17 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 26: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 22: {
                Object object18 = Promise.force(object2, CharSequence.class);
                if (!(object18 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object18;
                Object object19 = Promise.force(object3, Appendable.class);
                if (!(object19 instanceof Appendable)) {
                    return -786430;
                }
                callContext.value2 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 20: {
                Object object20 = Promise.force(object2);
                if (Char.checkCharOrEof(object20) < 0) {
                    return -786431;
                }
                callContext.value1 = object20;
                Object object21 = Promise.force(object3, Appendable.class);
                if (!(object21 instanceof Appendable)) {
                    return -786430;
                }
                callContext.value2 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 9: {
                Object object22 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object22) == null) {
                    return -786431;
                }
                callContext.value1 = object22;
                Object object23 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object23) == null) {
                    return -786430;
                }
                callContext.value2 = object23;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 8: {
                Object object24 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object24) == null) {
                    return -786431;
                }
                callContext.value1 = object24;
                Object object25 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object25) == null) {
                    return -786430;
                }
                callContext.value2 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                Object object26 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object26) == null) {
                    return -786431;
                }
                callContext.value1 = object26;
                Object object27 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object27) == null) {
                    return -786430;
                }
                callContext.value2 = object27;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 6: {
                Object object28 = Promise.force(object2, Path.class);
                if (Path.coerceToPathOrNull(object28) == null) {
                    return -786431;
                }
                callContext.value1 = object28;
                Object object29 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object29) == null) {
                    return -786430;
                }
                callContext.value2 = object29;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 5: {
                Object object30 = Promise.force(object2, Closeable.class);
                if (!(object30 instanceof Closeable)) {
                    return -786431;
                }
                callContext.value1 = object30;
                Object object31 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object31) == null) {
                    return -786430;
                }
                callContext.value2 = object31;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 64: {
                Object object5 = Promise.force(object2, U8Vector.class);
                if (!(object5 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 28: {
                Object object6 = Promise.force(object2, U8Vector.class);
                if (!(object6 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 22: {
                Object object7 = Promise.force(object2, CharSequence.class);
                if (!(object7 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = Promise.force(object3, Appendable.class);
                if (!(object8 instanceof Appendable)) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 64: {
                Object object6 = Promise.force(object2, U8Vector.class);
                if (!(object6 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 28: {
                Object object7 = Promise.force(object2, U8Vector.class);
                if (!(object7 instanceof U8Vector)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 22: {
                Object object8 = Promise.force(object2, CharSequence.class);
                if (!(object8 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3, Appendable.class);
                if (!(object9 instanceof Appendable)) {
                    return -786430;
                }
                callContext.value2 = object9;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 33: {
                return ports.openOutputString();
            }
            case 36: {
                return ports.openOutputBytevector();
            }
            case 40: {
                ports.flushOutputPort();
                return Values.empty;
            }
            case 42: {
                ports.forceOutput();
                return Values.empty;
            }
            case 44: {
                ports.newline();
                return Values.empty;
            }
            case 47: {
                return ports.eofObject();
            }
            case 48: {
                return ports.isCharReady() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 50: {
                return Char.makeOrEof(ports.readChar());
            }
            case 52: {
                return Char.makeOrEof(ports.peekChar());
            }
            case 56: {
                return ports.readU8();
            }
            case 58: {
                return ports.peekU8();
            }
            case 60: {
                return ports.isU8Ready() ? Boolean.TRUE : Boolean.FALSE;
            }
            case 90: {
                return ports.read();
            }
            case 92: {
                return ports.readLine();
            }
            case 96: {
                ports.transcriptOff();
                return Values.empty;
            }
        }
        return super.apply0(moduleMethod);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return ports.openInputFile(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 2: {
                return ports.openBinaryInputFile(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 3: {
                return ports.openOutputFile(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 4: {
                return ports.openBinaryOutputFile(Path.valueOf(Promise.force(object2, Path.class)));
            }
            case 10: {
                Boolean bl;
                if (ports.isInputPort(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 11: {
                Boolean bl;
                if (ports.isOutputPort(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 12: {
                Boolean bl;
                if (ports.isTextualPort(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 13: {
                Boolean bl;
                if (ports.isBinaryPort(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 14: {
                Boolean bl;
                if (ports.isPort(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 15: {
                Boolean bl;
                if (ports.isInputPortOpen(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 16: {
                Boolean bl;
                if (ports.isOutputPortOpen(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 17: {
                return ports.lambda1(object2);
            }
            case 18: {
                return ports.lambda2(object2);
            }
            case 19: {
                return ports.lambda3(object2);
            }
            case 20: {
                ports.writeChar(Char.castToCharacter(Promise.force(object2)));
                return Values.empty;
            }
            case 22: {
                ports.writeString((CharSequence)Promise.force(object2, CharSequence.class));
                return Values.empty;
            }
            case 26: {
                ports.writeU8(((Number)Promise.force(object2)).intValue());
                return Values.empty;
            }
            case 28: {
                ports.writeBytevector(LangObjType.coerceToU8Vector(Promise.force(object2, U8Vector.class)));
                return Values.empty;
            }
            case 32: {
                return ports.openInputString((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 34: {
                return ports.getOutputString((CharArrayOutPort)Promise.force(object2, CharArrayOutPort.class));
            }
            case 35: {
                return ports.openInputBytevector(LangObjType.coerceToU8Vector(Promise.force(object2, U8Vector.class)));
            }
            case 37: {
                return ports.getOutputBytevector((BinaryOutPort)Promise.force(object2, BinaryOutPort.class));
            }
            case 39: {
                return ports.callWithOutputString(LangObjType.coerceToProcedure(Promise.force(object2, Procedure.class)));
            }
            case 40: {
                ports.flushOutputPort(object2);
                return Values.empty;
            }
            case 42: {
                ports.forceOutput(object2);
                return Values.empty;
            }
            case 44: {
                ports.newline(object2);
                return Values.empty;
            }
            case 46: {
                Boolean bl;
                if (ports.isEofObject(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 48: {
                Boolean bl;
                if (ports.isCharReady(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 50: {
                return Char.makeOrEof(ports.readChar(object2));
            }
            case 52: {
                return Char.makeOrEof(ports.peekChar(object2));
            }
            case 54: {
                return ports.readString(((Number)Promise.force(object2)).intValue());
            }
            case 56: {
                return ports.readU8(object2);
            }
            case 58: {
                return ports.peekU8(object2);
            }
            case 60: {
                Boolean bl;
                if (ports.isU8Ready(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 62: {
                return ports.readBytevector(((Number)Promise.force(object2)).intValue());
            }
            case 64: {
                return ports.readBytevector$Ex(LangObjType.coerceToU8Vector(Promise.force(object2, U8Vector.class)));
            }
            case 68: {
                ports.writeSimple(object2);
                return Values.empty;
            }
            case 70: {
                ports.write(object2);
                return Values.empty;
            }
            case 72: {
                ports.writeShared(object2);
                return Values.empty;
            }
            case 74: {
                ports.writeWithSharedStructure(object2);
                return Values.empty;
            }
            case 76: {
                ports.display(object2);
                return Values.empty;
            }
            case 78: {
                return Char.make(ports.inputPortReadState(object2));
            }
            case 80: {
                return ports.portLine((InPort)Promise.force(object2, InPort.class));
            }
            case 82: {
                return ports.inputPortLineNumber((InPort)Promise.force(object2, InPort.class));
            }
            case 83: {
                return ports.portColumn((InPort)Promise.force(object2, InPort.class));
            }
            case 84: {
                return ports.inputPortColumnNumber(object2);
            }
            case 86: {
                return ports.inputPortPrompter((TtyInPort)Promise.force(object2, TtyInPort.class));
            }
            case 87: {
                ports.closePort((Closeable)Promise.force(object2, Closeable.class));
                return Values.empty;
            }
            case 88: {
                ports.closeInputPort((Reader)Promise.force(object2, Reader.class));
                return Values.empty;
            }
            case 89: {
                ports.closeOutputPort((Writer)Promise.force(object2, Writer.class));
                return Values.empty;
            }
            case 90: {
                return ports.read((InPort)Promise.force(object2, InPort.class));
            }
            case 92: {
                return ports.readLine((InPort)Promise.force(object2, InPort.class));
            }
            case 95: {
                ports.transcriptOn(object2);
                return Values.empty;
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "open-input-file", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "open-binary-input-file", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "open-output-file", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "open-binary-output-file", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "write-char", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "write-string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "write-u8", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "write-bytevector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "open-input-string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "get-output-string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "open-input-bytevector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "get-output-bytevector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "call-with-output-string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "read-string", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "read-bytevector", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "read-bytevector!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "port-line", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "input-port-line-number", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "port-column", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "input-port-prompter", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "close-port", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "close-input-port", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "close-output-port", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "read", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "read-line", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public class 0
    extends ThreadLocation {
        public 0() {
            super(ports.Lit5, Path.pathLocation);
        }

        public void set(Object new$Mnvalue) {
            super.set(Path.valueOf(new$Mnvalue));
        }
    }

}

