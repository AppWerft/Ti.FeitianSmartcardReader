// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Symbol;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import gnu.lists.ByteVector;
import java.util.Iterator;
import java.io.File;
import java.io.InputStreamReader;
import gnu.kawa.io.BinaryOutPort;
import java.io.OutputStreamWriter;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import gnu.kawa.io.FilePath;
import java.io.Writer;
import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStream;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.InPort;
import gnu.expr.Keyword;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.MethodProc;

public class RunProcess extends MethodProc
{
    public static final RunProcess instance;
    public static final SimpleSymbol inheritSymbol;
    public static final SimpleSymbol pipeSymbol;
    public static final SimpleSymbol currentSymbol;
    public static final SimpleSymbol outSymbol;
    
    public RunProcess(final String name) {
        this.setName(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileProcess:validateApplyRunProcess");
    }
    
    @Override
    public void apply(final CallContext ctx) throws Throwable {
        this.doit(ctx.getArgs(), ctx.consumer);
    }
    
    protected void error(final String message) {
        throw new RuntimeException("run-process: " + message);
    }
    
    public void doit(final Object[] args, final Consumer consumer) throws Throwable {
        final ProcessBuilder builder = new ProcessBuilder(new String[0]);
        final int nargs = args.length;
        boolean useShell = false;
        boolean returnBlob = true;
        Object inRedirect = null;
        Object outRedirect = null;
        Object errRedirect = null;
        boolean outNeedsClose = false;
        boolean errNeedsClose = false;
        InputStream inputBytes = null;
        boolean directorySet = false;
        Object command = null;
        for (int iarg = 0; iarg < nargs; ++iarg) {
            final Object arg = args[iarg];
            if (arg instanceof Keyword) {
                final String key = ((Keyword)arg).getName();
                final boolean outSpecifier = key.startsWith("out");
                if (++iarg >= nargs) {
                    this.error("missing keyword value for keyword " + arg);
                }
                final Object kval = args[iarg];
                Object newRedirect = null;
                Label_0765: {
                    if (key.equals("shell")) {
                        useShell = (boolean)kval;
                    }
                    else if (key.equals("in")) {
                        inputBytes = getInputStreamFrom(kval);
                    }
                    else if (key.equals("out-to") || key.equals("err-to") || key.equals("in-from")) {
                        final boolean inSpecifier = key.equals("in-from");
                        Label_0467: {
                            if (kval == RunProcess.currentSymbol) {
                                newRedirect = (inSpecifier ? InPort.inDefault() : (outSpecifier ? OutPort.outDefault() : OutPort.errDefault()));
                            }
                            else if (kval == RunProcess.pipeSymbol) {
                                newRedirect = kval;
                            }
                            else if (kval == RunProcess.inheritSymbol && !inSpecifier) {
                                newRedirect = (outSpecifier ? OutPort.getSystemOut() : OutPort.getSystemErr());
                            }
                            else if (!outSpecifier && !inSpecifier && kval == RunProcess.outSymbol) {
                                this.error("err-to: 'out redirect requires Java 7");
                                newRedirect = null;
                            }
                            else {
                                Label_0376: {
                                    if (inSpecifier) {
                                        if (!(kval instanceof InputStream)) {
                                            if (!(kval instanceof Reader)) {
                                                break Label_0376;
                                            }
                                        }
                                    }
                                    else if (!(kval instanceof OutputStream) && !(kval instanceof Writer)) {
                                        break Label_0376;
                                    }
                                    newRedirect = kval;
                                    break Label_0467;
                                }
                                final FilePath fpath = FilePath.coerceToFilePathOrNull(kval);
                                if (fpath != null) {
                                    final File file = fpath.toFile();
                                    if (inSpecifier) {
                                        inputBytes = new FileInputStream(file);
                                    }
                                    else {
                                        newRedirect = new FileOutputStream(file, false);
                                        if (outSpecifier) {
                                            outNeedsClose = true;
                                        }
                                        else {
                                            errNeedsClose = true;
                                        }
                                    }
                                }
                                else {
                                    this.error("unimplemented keyword value for " + arg);
                                }
                            }
                        }
                        if (inSpecifier) {
                            inRedirect = newRedirect;
                            newRedirect = null;
                        }
                    }
                    else if (key.equals("out-append-to") || key.equals("err-append-to")) {
                        final FilePath fpath2 = FilePath.coerceToFilePathOrNull(kval);
                        if (fpath2 != null) {
                            final File file2 = fpath2.toFile();
                            newRedirect = new FileOutputStream(file2, true);
                        }
                        else {
                            this.error("unimplemented keyword value for " + arg);
                        }
                    }
                    else if (key.startsWith("env-") && key.length() > 0) {
                        final String evar = key.substring(4);
                        final String evalue = kval.toString();
                        builder.environment().put(evar, evalue);
                    }
                    else if (key.toUpperCase().equals(key)) {
                        final String evalue2 = kval.toString();
                        builder.environment().put(key, evalue2);
                    }
                    else if (key.equals("env")) {
                        final Map<String, String> env = builder.environment();
                        env.clear();
                        env.putAll((Map<? extends String, ? extends String>)kval);
                    }
                    else {
                        if (key.equals("directory")) {
                            try {
                                directorySet = true;
                                if (kval != RunProcess.inheritSymbol) {
                                    final FilePath fpath2 = FilePath.coerceToFilePathOrNull(kval);
                                    builder.directory(fpath2.toFile());
                                }
                                break Label_0765;
                            }
                            catch (Exception ex) {
                                throw new IllegalArgumentException("invalid directory");
                            }
                        }
                        this.error("unknown keyword " + arg);
                    }
                }
                if (outSpecifier) {
                    returnBlob = false;
                }
                if (newRedirect != null) {
                    if (outSpecifier) {
                        outRedirect = newRedirect;
                    }
                    else {
                        errRedirect = newRedirect;
                    }
                }
            }
            else if (inputBytes == null && iarg + 2 == nargs) {
                inputBytes = getInputStreamFrom(arg);
            }
            else if (command == null) {
                command = arg;
            }
            else {
                this.error("multiple command arguments");
            }
        }
        List<String> cmd = null;
        if (!(command instanceof CharSequence)) {
            if (command instanceof List) {
                cmd = new ArrayList<String>();
                for (final Object arg2 : (List)command) {
                    if (arg2 instanceof CharSequence) {
                        cmd.add(arg2.toString());
                    }
                    else {
                        this.error("element in command sequence is not a string");
                    }
                }
                if (cmd.isEmpty()) {
                    command = null;
                }
            }
            else {
                this.error("command is neither string nor string sequence");
            }
        }
        if (command == null) {
            this.error("missing command");
        }
        if (useShell) {
            if (cmd != null) {
                final StringBuilder sbuf = new StringBuilder(cmd.get(0));
                for (int ncmds = cmd.size(), i = 1; i < ncmds; ++i) {
                    sbuf.append(' ');
                    sbuf.append(cmd.get(i));
                }
                command = sbuf;
            }
            cmd = new ArrayList<String>();
            cmd.add("/bin/sh");
            cmd.add("-c");
            final String commands = command.toString();
            this.tokenize(commands, true, cmd);
        }
        else if (cmd == null) {
            cmd = new ArrayList<String>();
            final String commands = command.toString();
            this.tokenize(commands, false, cmd);
        }
        builder.command(cmd);
        if (!directorySet) {
            final Path cur = Path.currentPath();
            if (cur != Path.userDirPath) {
                builder.directory(((FilePath)cur).toFile());
            }
        }
        if (errRedirect == null) {
            errRedirect = OutPort.errDefault();
        }
        final Process proc = builder.start();
        if (inRedirect instanceof Reader) {
            if (inRedirect instanceof BinaryInPort) {
                inputBytes = ((BinaryInPort)inRedirect).getInputStream();
            }
            else {
                final OutputStreamWriter outs = new OutputStreamWriter(proc.getOutputStream());
                copyCharsInThread((Reader)inRedirect, outs, false, true);
            }
        }
        if (inRedirect instanceof InputStream) {
            inputBytes = (InputStream)inRedirect;
        }
        if (inputBytes != null) {
            final InputStream inb = inputBytes;
            copyStreamInThread(inputBytes, proc.getOutputStream(), true);
        }
        if (outRedirect instanceof OutputStream) {
            copyStreamInThread(proc.getInputStream(), (OutputStream)outRedirect, outNeedsClose);
        }
        else if (outRedirect instanceof Writer) {
            this.copyWriterInThread(proc.getInputStream(), (Writer)outRedirect, outNeedsClose);
        }
        if (errRedirect instanceof OutputStream) {
            copyStreamInThread(proc.getErrorStream(), (OutputStream)errRedirect, errNeedsClose);
        }
        else if (errRedirect instanceof Writer) {
            this.copyWriterInThread(proc.getErrorStream(), (Writer)errRedirect, errNeedsClose);
        }
        if (returnBlob) {
            final LProcess lproc = new LProcess(proc);
            final OutPort pout = OutPort.getPassThroughOutPort(consumer);
            if (pout != null) {
                final InputStream in = proc.getInputStream();
                if (pout instanceof BinaryOutPort) {
                    final BinaryOutPort bout = (BinaryOutPort)pout;
                    final byte[] buffer = new byte[2048];
                    while (true) {
                        final int cnt = in.read(buffer, 0, buffer.length);
                        if (cnt < 0) {
                            break;
                        }
                        bout.writeBytes(buffer, 0, cnt);
                    }
                    bout.flush();
                    in.close();
                }
                else {
                    final Reader inr = new InputStreamReader(in);
                    final char[] buffer2 = new char[2048];
                    while (true) {
                        final int cnt = inr.read(buffer2, 0, buffer2.length);
                        if (cnt < 0) {
                            break;
                        }
                        pout.write(buffer2, 0, cnt);
                    }
                    pout.flush();
                    inr.close();
                }
            }
            else {
                consumer.writeObject(lproc);
            }
        }
        else {
            consumer.writeObject(proc);
        }
    }
    
    public void tokenize(final String str, final boolean useShell, final List<String> arr) {
        final StringBuffer sbuf = new StringBuffer(100);
        int state = -1;
        final int len = str.length();
        int inGroup = 0;
        int inSubstitution = 0;
        for (int i = 0; i < len; ++i) {
            char ch = str.charAt(i);
            if (ch == '\uf200') {
                if (inGroup > 0) {
                    sbuf.append(ch);
                }
                ++inGroup;
            }
            else if (ch == '\uf201') {
                if (--inGroup > 0) {
                    sbuf.append(ch);
                }
            }
            else if (ch == '\uf202') {
                if (inSubstitution > 0) {
                    sbuf.append(ch);
                }
                ++inSubstitution;
            }
            else if (ch == '\uf203') {
                if (--inSubstitution > 0) {
                    sbuf.append(ch);
                }
                else {
                    if (state == 1) {
                        sbuf.append('\'');
                        state = -1;
                    }
                    if (inGroup > 0 && i + 1 < len && str.charAt(i + 1) == '\uf202') {
                        if (useShell || state == 34 || state == 39) {
                            sbuf.append(' ');
                        }
                        else {
                            arr.add(sbuf.toString());
                            sbuf.setLength(0);
                        }
                    }
                }
            }
            else {
                if (ch == '\n' && inSubstitution > 0 && inGroup == 0) {
                    int nlCount = 1;
                    while (true) {
                        ch = str.charAt(i + nlCount);
                        if (ch != '\n') {
                            break;
                        }
                        ++nlCount;
                    }
                    i += nlCount - 1;
                    if (ch == '\uf203') {
                        continue;
                    }
                    ch = '\n';
                    if (state == 34 && inGroup == 0) {
                        while (--nlCount >= 0) {
                            if (useShell) {
                                sbuf.append("\" \"");
                            }
                            else {
                                arr.add(sbuf.toString());
                                sbuf.setLength(0);
                            }
                        }
                        continue;
                    }
                    if (state <= 1) {
                        if (useShell) {
                            ch = ' ';
                        }
                    }
                    else {
                        while (--nlCount > 0) {
                            sbuf.append('\n');
                        }
                    }
                }
                if (useShell) {
                    if (inSubstitution > 0) {
                        if (state == 34) {
                            if (ch == '$' || ch == '\\') {
                                sbuf.append('\\');
                            }
                        }
                        else if (ch == '\'') {
                            if (state == -1) {
                                sbuf.append("\\'");
                            }
                            else {
                                sbuf.append("'\\'");
                            }
                        }
                        else if (state <= 1 && inGroup == 0 && (ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r')) {
                            if (state == 1) {
                                sbuf.append('\'');
                            }
                            state = -1;
                        }
                        else if (state == -1) {
                            sbuf.append('\'');
                            state = 1;
                        }
                    }
                    else if (ch == '\\' && state != 39 && i + 1 < len) {
                        sbuf.append(ch);
                        ++i;
                        ch = str.charAt(i);
                    }
                    else if (state < 0) {
                        if (ch == '\"' || ch == '\'') {
                            state = ch;
                        }
                    }
                    else if (ch == state) {
                        state = -1;
                    }
                }
                else if (state <= 0 && inGroup == 0 && (ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r')) {
                    if (sbuf.length() > 0 || state == 0) {
                        arr.add(sbuf.toString());
                        sbuf.setLength(0);
                        state = -1;
                    }
                    continue;
                }
                else if (inSubstitution <= 0) {
                    if (state <= 0) {
                        if (ch == '\\' || ch == '\'' || ch == '\"') {
                            state = ch;
                            continue;
                        }
                    }
                    else if (state == 92) {
                        state = 0;
                    }
                    else if (ch == state) {
                        state = 0;
                        continue;
                    }
                }
                sbuf.append(ch);
            }
        }
        if (sbuf.length() > 0 || state >= 0 || useShell) {
            arr.add(sbuf.toString());
        }
        if (!useShell && (state > 0 || inSubstitution > 0 || inGroup > 0)) {
            this.error("bad quotes");
        }
    }
    
    public static InputStream getInputStreamFrom(final Object val) {
        if (val instanceof ByteVector) {
            return ((ByteVector)val).getInputStream();
        }
        if (val instanceof Process) {
            return ((Process)val).getInputStream();
        }
        if (val instanceof byte[]) {
            return new ByteArrayInputStream((byte[])val);
        }
        if (val instanceof CharSequence) {
            return new ByteArrayInputStream(((CharSequence)val).toString().getBytes());
        }
        throw new ClassCastException("invalid input");
    }
    
    static void copyStreamInThread(final InputStream in, final OutputStream out, final boolean closeOut) {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    RunProcess.copyStream(in, out, closeOut);
                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        thread.start();
    }
    
    void copyWriterInThread(final InputStream in, final Writer out, final boolean closeOut) throws IOException {
        if (out instanceof BinaryOutPort) {
            final BinaryOutPort bout = (BinaryOutPort)out;
            copyStreamInThread(in, bout.getOutputStream(), closeOut);
        }
        else {
            out.flush();
            copyCharsInThread(new InputStreamReader(in), out, true, closeOut);
        }
    }
    
    static void copyCharsInThread(final Reader in, final Writer out, final boolean closeIn, final boolean closeOut) throws IOException {
        new Thread() {
            @Override
            public void run() {
                try {
                    final char[] buffer = new char[2048];
                    try {
                        try {
                            while (true) {
                                final int cnt = in.read(buffer, 0, buffer.length);
                                if (cnt < 0) {
                                    break;
                                }
                                out.write(buffer, 0, cnt);
                            }
                        }
                        catch (IOException ex) {
                            if (!"Broken pipe".equals(ex.getMessage())) {
                                throw ex;
                            }
                        }
                        out.flush();
                    }
                    finally {
                        in.close();
                        if (closeOut) {
                            out.close();
                        }
                    }
                }
                catch (IOException ex2) {
                    throw new RuntimeException(ex2);
                }
            }
        }.start();
    }
    
    public static void copyStream(final InputStream in, final OutputStream out, final boolean closeOut) throws IOException {
        final byte[] buffer = new byte[2048];
        try {
            while (true) {
                final int cnt = in.read(buffer, 0, buffer.length);
                if (cnt < 0) {
                    break;
                }
                try {
                    out.write(buffer, 0, cnt);
                }
                catch (IOException ex) {
                    if ("Broken pipe".equals(ex.getMessage())) {
                        break;
                    }
                    throw ex;
                }
            }
            out.flush();
        }
        finally {
            in.close();
            if (closeOut) {
                out.close();
            }
        }
    }
    
    static {
        instance = new RunProcess("run-process");
        inheritSymbol = Symbol.valueOf("inherit");
        pipeSymbol = Symbol.valueOf("pipe");
        currentSymbol = Symbol.valueOf("current");
        outSymbol = Symbol.valueOf("out");
    }
}
