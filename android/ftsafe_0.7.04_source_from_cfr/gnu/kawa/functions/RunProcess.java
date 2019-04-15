/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.expr.Keyword;
import gnu.kawa.functions.LProcess;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.BinaryOutPort;
import gnu.kawa.io.FilePath;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.lists.ByteVector;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RunProcess
extends MethodProc {
    public static final RunProcess instance = new RunProcess("run-process");
    public static final SimpleSymbol inheritSymbol = Symbol.valueOf("inherit");
    public static final SimpleSymbol pipeSymbol = Symbol.valueOf("pipe");
    public static final SimpleSymbol currentSymbol = Symbol.valueOf("current");
    public static final SimpleSymbol outSymbol = Symbol.valueOf("out");

    public RunProcess(String name) {
        this.setName(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileProcess:validateApplyRunProcess");
    }

    @Override
    public void apply(CallContext ctx) throws Throwable {
        this.doit(ctx.getArgs(), ctx.consumer);
    }

    protected void error(String message) {
        throw new RuntimeException("run-process: " + message);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void doit(Object[] args, Consumer consumer) throws Throwable {
        builder = new ProcessBuilder(new String[0]);
        nargs = args.length;
        useShell = false;
        returnBlob = true;
        inRedirect = null;
        outRedirect = null;
        errRedirect = null;
        outNeedsClose = false;
        errNeedsClose = false;
        inputBytes = null;
        directorySet = false;
        command = null;
        for (iarg = 0; iarg < nargs; ++iarg) {
            arg = args[iarg];
            if (arg instanceof Keyword) {
                key = ((Keyword)arg).getName();
                outSpecifier = key.startsWith("out");
                if (++iarg >= nargs) {
                    this.error("missing keyword value for keyword " + arg);
                }
                kval = args[iarg];
                newRedirect = null;
                if (key.equals("shell")) {
                    useShell = (Boolean)kval;
                } else if (key.equals("in")) {
                    inputBytes = RunProcess.getInputStreamFrom(kval);
                } else if (key.equals("out-to") || key.equals("err-to") || key.equals("in-from")) {
                    inSpecifier = key.equals("in-from");
                    if (kval == RunProcess.currentSymbol) {
                        newRedirect = inSpecifier != false ? InPort.inDefault() : (outSpecifier != false ? OutPort.outDefault() : OutPort.errDefault());
                    } else if (kval == RunProcess.pipeSymbol) {
                        newRedirect = kval;
                    } else if (kval == RunProcess.inheritSymbol && !inSpecifier) {
                        newRedirect = outSpecifier != false ? OutPort.getSystemOut() : OutPort.getSystemErr();
                    } else if (!outSpecifier && !inSpecifier && kval == RunProcess.outSymbol) {
                        this.error("err-to: 'out redirect requires Java 7");
                        newRedirect = null;
                    } else if (inSpecifier != false ? kval instanceof InputStream != false || kval instanceof Reader != false : kval instanceof OutputStream != false || kval instanceof Writer != false) {
                        newRedirect = kval;
                    } else {
                        fpath = FilePath.coerceToFilePathOrNull(kval);
                        if (fpath != null) {
                            file = fpath.toFile();
                            if (inSpecifier) {
                                inputBytes = new FileInputStream(file);
                            } else {
                                newRedirect = new FileOutputStream(file, false);
                                if (outSpecifier) {
                                    outNeedsClose = true;
                                } else {
                                    errNeedsClose = true;
                                }
                            }
                        } else {
                            this.error("unimplemented keyword value for " + arg);
                        }
                    }
                    if (inSpecifier) {
                        inRedirect = newRedirect;
                        newRedirect = null;
                    }
                } else if (key.equals("out-append-to") || key.equals("err-append-to")) {
                    fpath = FilePath.coerceToFilePathOrNull(kval);
                    if (fpath != null) {
                        file = fpath.toFile();
                        newRedirect = new FileOutputStream(file, true);
                    } else {
                        this.error("unimplemented keyword value for " + arg);
                    }
                } else if (key.startsWith("env-") && key.length() > 0) {
                    evar = key.substring(4);
                    evalue = kval.toString();
                    builder.environment().put(evar, evalue);
                } else if (key.toUpperCase().equals(key)) {
                    evalue = kval.toString();
                    builder.environment().put(key, evalue);
                } else if (key.equals("env")) {
                    env = builder.environment();
                    env.clear();
                    env.putAll((Map)kval);
                } else if (key.equals("directory")) {
                    try {
                        directorySet = true;
                        if (kval == RunProcess.inheritSymbol) ** GOTO lbl95
                        fpath = FilePath.coerceToFilePathOrNull(kval);
                        builder.directory(fpath.toFile());
                    }
                    catch (Exception ex) {
                        throw new IllegalArgumentException("invalid directory");
                    }
                } else {
                    this.error("unknown keyword " + arg);
                }
lbl95: // 11 sources:
                if (outSpecifier) {
                    returnBlob = false;
                }
                if (newRedirect == null) continue;
                if (outSpecifier) {
                    outRedirect = newRedirect;
                    continue;
                }
                errRedirect = newRedirect;
                continue;
            }
            if (inputBytes == null && iarg + 2 == nargs) {
                inputBytes = RunProcess.getInputStreamFrom(arg);
                continue;
            }
            if (command == null) {
                command = arg;
                continue;
            }
            this.error("multiple command arguments");
        }
        cmd = null;
        if (!(command instanceof CharSequence)) {
            if (!(command instanceof List)) {
                this.error("command is neither string nor string sequence");
            } else {
                cmd = new ArrayList<String>();
                for (E arg : (List)command) {
                    if (arg instanceof CharSequence) {
                        cmd.add(arg.toString());
                        continue;
                    }
                    this.error("element in command sequence is not a string");
                }
                if (cmd.isEmpty()) {
                    command = null;
                }
            }
        }
        if (command == null) {
            this.error("missing command");
        }
        if (useShell) {
            if (cmd != null) {
                sbuf = new StringBuilder((String)cmd.get(0));
                ncmds = cmd.size();
                for (i = 1; i < ncmds; ++i) {
                    sbuf.append(' ');
                    sbuf.append((String)cmd.get(i));
                }
                command = sbuf;
            }
            cmd = new ArrayList<E>();
            cmd.add("/bin/sh");
            cmd.add("-c");
            commands = command.toString();
            this.tokenize(commands, true, cmd);
        } else if (cmd == null) {
            cmd = new ArrayList<E>();
            commands = command.toString();
            this.tokenize(commands, false, cmd);
        }
        builder.command(cmd);
        if (!directorySet && (cur = Path.currentPath()) != Path.userDirPath) {
            builder.directory(((FilePath)cur).toFile());
        }
        if (errRedirect == null) {
            errRedirect = OutPort.errDefault();
        }
        proc = builder.start();
        if (inRedirect instanceof Reader) {
            if (inRedirect instanceof BinaryInPort) {
                inputBytes = ((BinaryInPort)inRedirect).getInputStream();
            } else {
                outs = new OutputStreamWriter(proc.getOutputStream());
                RunProcess.copyCharsInThread((Reader)inRedirect, outs, false, true);
            }
        }
        if (inRedirect instanceof InputStream) {
            inputBytes = (InputStream)inRedirect;
        }
        if (inputBytes != null) {
            inb = inputBytes;
            RunProcess.copyStreamInThread(inputBytes, proc.getOutputStream(), true);
        }
        if (outRedirect instanceof OutputStream) {
            RunProcess.copyStreamInThread(proc.getInputStream(), (OutputStream)outRedirect, outNeedsClose);
        } else if (outRedirect instanceof Writer) {
            this.copyWriterInThread(proc.getInputStream(), (Writer)outRedirect, outNeedsClose);
        }
        if (errRedirect instanceof OutputStream) {
            RunProcess.copyStreamInThread(proc.getErrorStream(), (OutputStream)errRedirect, errNeedsClose);
        } else if (errRedirect instanceof Writer) {
            this.copyWriterInThread(proc.getErrorStream(), errRedirect, errNeedsClose);
        }
        if (!returnBlob) {
            consumer.writeObject(proc);
            return;
        }
        lproc = new LProcess(proc);
        pout = OutPort.getPassThroughOutPort(consumer);
        if (pout == null) {
            consumer.writeObject(lproc);
            return;
        }
        in = proc.getInputStream();
        if (pout instanceof BinaryOutPort) {
            bout = (BinaryOutPort)pout;
            buffer = new byte[2048];
            do {
                if ((cnt = in.read(buffer, 0, buffer.length)) < 0) {
                    bout.flush();
                    in.close();
                    return;
                }
                bout.writeBytes(buffer, 0, cnt);
            } while (true);
        }
        inr = new InputStreamReader(in);
        buffer = new char[2048];
        do {
            if ((cnt = inr.read(buffer, 0, buffer.length)) < 0) {
                pout.flush();
                inr.close();
                return;
            }
            pout.write(buffer, 0, cnt);
        } while (true);
    }

    public void tokenize(String str, boolean useShell, List<String> arr) {
        StringBuffer sbuf = new StringBuffer(100);
        int state = -1;
        int len = str.length();
        int inGroup = 0;
        int inSubstitution = 0;
        for (int i = 0; i < len; ++i) {
            int ch;
            block37 : {
                block34 : {
                    block41 : {
                        block40 : {
                            block35 : {
                                block39 : {
                                    block38 : {
                                        block36 : {
                                            ch = str.charAt(i);
                                            if (ch == 61952) {
                                                if (inGroup > 0) {
                                                    sbuf.append((char)ch);
                                                }
                                                ++inGroup;
                                                continue;
                                            }
                                            if (ch == 61953) {
                                                if (--inGroup <= 0) continue;
                                                sbuf.append((char)ch);
                                                continue;
                                            }
                                            if (ch == 61954) {
                                                if (inSubstitution > 0) {
                                                    sbuf.append((char)ch);
                                                }
                                                ++inSubstitution;
                                                continue;
                                            }
                                            if (ch == 61955) {
                                                if (--inSubstitution > 0) {
                                                    sbuf.append((char)ch);
                                                    continue;
                                                }
                                                if (state == 1) {
                                                    sbuf.append('\'');
                                                    state = -1;
                                                }
                                                if (inGroup <= 0 || i + 1 >= len || str.charAt(i + 1) != '\uf202') continue;
                                                if (useShell || state == 34 || state == 39) {
                                                    sbuf.append(' ');
                                                    continue;
                                                }
                                                arr.add(sbuf.toString());
                                                sbuf.setLength(0);
                                                continue;
                                            }
                                            if (ch == 10 && inSubstitution > 0 && inGroup == 0) {
                                                int nlCount = 1;
                                                while ((ch = str.charAt(i + nlCount)) == 10) {
                                                    ++nlCount;
                                                }
                                                i += nlCount - 1;
                                                if (ch == 61955) continue;
                                                ch = 10;
                                                if (state == 34 && inGroup == 0) {
                                                    while (--nlCount >= 0) {
                                                        if (useShell) {
                                                            sbuf.append("\" \"");
                                                            continue;
                                                        }
                                                        arr.add(sbuf.toString());
                                                        sbuf.setLength(0);
                                                    }
                                                    continue;
                                                }
                                                if (state <= 1) {
                                                    if (useShell) {
                                                        ch = 32;
                                                    }
                                                } else {
                                                    while (--nlCount > 0) {
                                                        sbuf.append('\n');
                                                    }
                                                }
                                            }
                                            if (!useShell) break block34;
                                            if (inSubstitution <= 0) break block35;
                                            if (state != 34) break block36;
                                            if (ch == 36 || ch == 92) {
                                                sbuf.append('\\');
                                            }
                                            break block37;
                                        }
                                        if (ch != 39) break block38;
                                        if (state == -1) {
                                            sbuf.append("\\'");
                                        } else {
                                            sbuf.append("'\\'");
                                        }
                                        break block37;
                                    }
                                    if (state > 1 || inGroup != 0 || ch != 32 && ch != 9 && ch != 10 && ch != 13) break block39;
                                    if (state == 1) {
                                        sbuf.append('\'');
                                    }
                                    state = -1;
                                    break block37;
                                }
                                if (state != -1) break block37;
                                sbuf.append('\'');
                                state = 1;
                                break block37;
                            }
                            if (ch != 92 || state == 39 || i + 1 >= len) break block40;
                            sbuf.append((char)ch);
                            ch = str.charAt(++i);
                            break block37;
                        }
                        if (state >= 0) break block41;
                        if (ch == 34 || ch == 39) {
                            state = ch;
                        }
                        break block37;
                    }
                    if (ch != state) break block37;
                    state = -1;
                    break block37;
                }
                if (state <= 0 && inGroup == 0 && (ch == 32 || ch == 9 || ch == 10 || ch == 13)) {
                    if (sbuf.length() <= 0 && state != 0) continue;
                    arr.add(sbuf.toString());
                    sbuf.setLength(0);
                    state = -1;
                    continue;
                }
                if (inSubstitution <= 0) {
                    if (state <= 0) {
                        if (ch == 92 || ch == 39 || ch == 34) {
                            state = ch;
                            continue;
                        }
                    } else if (state == 92) {
                        state = 0;
                    } else if (ch == state) {
                        state = 0;
                        continue;
                    }
                }
            }
            sbuf.append((char)ch);
        }
        if (sbuf.length() > 0 || state >= 0 || useShell) {
            arr.add(sbuf.toString());
        }
        if (!(useShell || state <= 0 && inSubstitution <= 0 && inGroup <= 0)) {
            this.error("bad quotes");
        }
    }

    public static InputStream getInputStreamFrom(Object val) {
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
            return new ByteArrayInputStream(((Object)((CharSequence)val)).toString().getBytes());
        }
        throw new ClassCastException("invalid input");
    }

    static void copyStreamInThread(final InputStream in, final OutputStream out, final boolean closeOut) {
        Thread thread2 = new Thread(){

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
        thread2.start();
    }

    void copyWriterInThread(InputStream in, Writer out, boolean closeOut) throws IOException {
        if (out instanceof BinaryOutPort) {
            BinaryOutPort bout = (BinaryOutPort)out;
            RunProcess.copyStreamInThread(in, bout.getOutputStream(), closeOut);
        } else {
            out.flush();
            RunProcess.copyCharsInThread(new InputStreamReader(in), out, true, closeOut);
        }
    }

    static void copyCharsInThread(final Reader in, final Writer out, boolean closeIn, final boolean closeOut) throws IOException {
        new Thread(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                try {
                    char[] buffer = new char[2048];
                    try {
                        block9 : {
                            try {
                                int cnt;
                                while ((cnt = in.read(buffer, 0, buffer.length)) >= 0) {
                                    out.write(buffer, 0, cnt);
                                }
                            }
                            catch (IOException ex) {
                                if ("Broken pipe".equals(ex.getMessage())) break block9;
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
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void copyStream(InputStream in, OutputStream out, boolean closeOut) throws IOException {
        byte[] buffer = new byte[2048];
        try {
            int cnt;
            while ((cnt = in.read(buffer, 0, buffer.length)) >= 0) {
                try {
                    out.write(buffer, 0, cnt);
                }
                catch (IOException ex) {
                    if ("Broken pipe".equals(ex.getMessage())) break;
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

}

