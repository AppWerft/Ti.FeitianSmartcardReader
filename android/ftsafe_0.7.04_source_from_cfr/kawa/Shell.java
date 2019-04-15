/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import gnu.bytecode.ZipLoader;
import gnu.expr.Compilation;
import gnu.expr.CompiledModule;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.io.BinaryInPort;
import gnu.kawa.io.InPort;
import gnu.kawa.io.NBufferedInputStream;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TtyInPort;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.URL;

public class Shell {
    public static ThreadLocal currentLoadPath = new ThreadLocal();
    private static Class[] noClasses = new Class[0];
    private static Class[] boolClasses = new Class[]{Boolean.TYPE};
    private static Class[] lispPushClasses = new Class[]{OutPort.class, Character.TYPE, Boolean.TYPE};
    private static Class[] xmlPrinterClasses = new Class[]{Consumer.class, Object.class};
    private static Class[] httpPrinterClasses = new Class[]{OutPort.class};
    private static Object consumerArg = "(consumer)";
    static Object[][] formats = new Object[][]{{"scheme", "gnu.kawa.functions.DisplayFormat", "getSchemeFormat", boolClasses, Boolean.FALSE}, {"readable-scheme", "gnu.kawa.functions.DisplayFormat", "getSchemeFormat", boolClasses, Boolean.TRUE}, {"elisp", "gnu.kawa.functions.DisplayFormat", "getEmacsLispFormat", boolClasses, Boolean.FALSE}, {"readable-elisp", "gnu.kawa.functions.DisplayFormat", "getEmacsLispFormat", boolClasses, Boolean.TRUE}, {"clisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.FALSE}, {"readable-clisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.TRUE}, {"commonlisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.FALSE}, {"readable-commonlisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.TRUE}, {"xml", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, consumerArg, null}, {"html", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, consumerArg, "html"}, {"xhtml", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, consumerArg, "xhtml"}, {"cgi", "gnu.kawa.xml.HttpPrinter", "make", httpPrinterClasses, consumerArg}, {"ignore", "gnu.lists.VoidConsumer", "make", new Class[]{Consumer.class}, consumerArg}, {null}};
    public static String defaultFormatName;
    public static Object[] defaultFormatInfo;
    public static Method defaultFormatMethod;
    public static final Procedure1 defaultPrompter;

    public static void setDefaultFormat(String name) {
        defaultFormatName = name = name.intern();
        int i = 0;
        do {
            Object[] info;
            Object iname;
            if ((iname = (info = formats[i])[0]) == null) {
                System.err.println("kawa: unknown output format '" + name + "'");
                System.exit(-1);
            } else if (iname == name) {
                defaultFormatInfo = info;
                try {
                    Class<?> formatClass = Class.forName((String)info[1]);
                    defaultFormatMethod = formatClass.getMethod((String)info[2], (Class[])info[3]);
                }
                catch (Throwable ex) {
                    System.err.println("kawa:  caught " + ex + " while looking for format '" + name + "'");
                    System.exit(-1);
                }
                break;
            }
            ++i;
        } while (true);
        if (!defaultFormatInfo[1].equals("gnu.lists.VoidConsumer")) {
            ModuleBody.setMainPrintValues(true);
        }
    }

    public static Consumer getOutputConsumer(OutPort out) {
        Object[] info = defaultFormatInfo;
        if (out == null) {
            return VoidConsumer.getInstance();
        }
        if (info == null) {
            return Language.getDefaultLanguage().getOutputConsumer(out);
        }
        try {
            Object[] args = new Object[info.length - 4];
            System.arraycopy(info, 4, args, 0, args.length);
            boolean useConsumer = args[0] == consumerArg;
            int i = args.length;
            while (--i >= 0) {
                if (args[i] != consumerArg) continue;
                args[i] = out;
            }
            Object format = defaultFormatMethod.invoke(null, args);
            if (format instanceof AbstractFormat) {
                return ((AbstractFormat)format).makeConsumer(out);
            }
            return (Consumer)format;
        }
        catch (Exception ex) {
            throw new RuntimeException("cannot get output-format '" + defaultFormatName + "' - caught " + ex);
        }
    }

    public static boolean run(Language language, Environment env) {
        OutPort perr;
        InPort inp = InPort.inDefault();
        SourceMessages messages = new SourceMessages();
        if (inp instanceof TtyInPort) {
            ((TtyInPort)inp).setPrompter(defaultPrompter);
            perr = OutPort.errDefault();
        } else {
            perr = null;
        }
        Throwable ex = Shell.run(language, env, inp, OutPort.outDefault(), perr, messages);
        if (ex == null) {
            return true;
        }
        Shell.printError(ex, messages, OutPort.errDefault());
        return false;
    }

    public static Throwable run(Language language, Environment env, InPort inp, OutPort pout, OutPort perr, SourceMessages messages) {
        Consumer out = Shell.getOutputConsumer(pout);
        return Shell.run(language, env, inp, out, perr, null, messages);
    }

    public static boolean run(Language language, Environment env, InPort inp, Consumer out, OutPort perr, URL url) {
        SourceMessages messages = new SourceMessages();
        Throwable ex = Shell.run(language, env, inp, out, perr, url, messages);
        if (ex != null) {
            Shell.printError(ex, messages, perr);
        }
        return ex == null;
    }

    /*
     * Exception decompiling
     */
    public static Throwable run(Language language, Environment env, InPort inp, Consumer out, OutPort perr, URL url, SourceMessages messages) {
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

    static Method getJLineParserMethod(InPort in) {
        Class<?> cls = in.getClass();
        try {
            if (cls.getName().equals("gnu.kawa.io.JLineInPort")) {
                cls = Class.forName("gnu.kawa.io.JLineInPort$KawaParsedLine");
                return cls.getDeclaredMethod("parse", Language.class, Lexer.class);
            }
        }
        catch (Throwable ex) {
            // empty catch block
        }
        return null;
    }

    public static void printError(Throwable ex, SourceMessages messages, OutPort perr) {
        SyntaxException se;
        if (ex instanceof WrongArguments) {
            WrongArguments e = (WrongArguments)ex;
            messages.printAll(perr, 20);
            if (e.usage != null) {
                perr.println("usage: " + e.usage);
            }
            e.printStackTrace(perr);
        } else if (ex instanceof SyntaxException && (se = (SyntaxException)ex).getMessages() == messages) {
            se.printAll(perr, 20);
            se.clear();
        } else {
            messages.printAll(perr, 20);
            ex.printStackTrace(perr);
        }
        perr.flush();
    }

    public static final CompiledModule checkCompiledZip(InputStream fs, Path path, Environment env, Language language) throws IOException {
        try {
            fs.mark(5);
            boolean isZip = fs.read() == 80 && fs.read() == 75 && fs.read() == 3 && fs.read() == 4;
            fs.reset();
            if (!isZip) {
                return null;
            }
        }
        catch (IOException ex) {
            return null;
        }
        fs.close();
        Environment orig_env = Environment.getCurrent();
        String name = path.toString();
        try {
            File zfile;
            if (env != orig_env) {
                Environment.setCurrent(env);
            }
            if ((zfile = path.toFile()) == null) {
                throw new RuntimeException("load: " + name + " - not a file path");
            }
            if (!zfile.exists()) {
                throw new RuntimeException("load: " + name + " - not found");
            }
            if (!zfile.canRead()) {
                throw new RuntimeException("load: " + name + " - not readable");
            }
            ZipLoader loader = new ZipLoader(name);
            Class clas = loader.loadAllClasses();
            CompiledModule compiledModule = CompiledModule.make(clas, language);
            return compiledModule;
        }
        catch (IOException ex) {
            throw new WrappedException("load: " + name + " - " + ex.toString(), ex);
        }
        finally {
            if (env != orig_env) {
                Environment.setCurrent(orig_env);
            }
        }
    }

    static InPort openFile(InputStream fs, Path path) throws IOException {
        Object conv = Environment.user().get("port-char-encoding");
        if (conv == null || conv == Boolean.TRUE) {
            return BinaryInPort.openHeuristicFile(fs, path);
        }
        return InPort.openFile(fs, path, conv);
    }

    public static boolean runFileOrClass(String fname, boolean lineByLine, int skipLines) {
        Language language = Language.getDefaultLanguage();
        try {
            Path path;
            InputStream fs;
            if (fname.equals("-")) {
                path = Path.valueOf("/dev/stdin");
                fs = System.in;
            } else {
                path = Path.valueOf(fname);
                fs = path.openInputStream();
            }
            try {
                Environment env = Environment.getCurrent();
                return Shell.runFile(fs, path, env, lineByLine, skipLines);
            }
            catch (Error e) {
                throw e;
            }
            catch (Throwable e) {
                e.printStackTrace(System.err);
                return false;
            }
        }
        catch (Error e) {
            throw e;
        }
        catch (Throwable e) {
            Class<?> clas;
            try {
                clas = Class.forName(fname);
            }
            catch (Exception ex) {
                System.err.println("Cannot read file " + e.getMessage());
                return false;
            }
            try {
                Shell.runClass(clas, Environment.getCurrent());
                return true;
            }
            catch (Error ex) {
                throw ex;
            }
            catch (Throwable ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }

    public static void runClass(Class clas, Environment env) throws Throwable {
        CompiledModule cmodule = CompiledModule.make(clas, Language.getDefaultLanguage());
        cmodule.evalModule(env, OutPort.outDefault());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final boolean runFile(InputStream fs, Path path, Environment env, boolean lineByLine, int skipLines) throws Throwable {
        if (!(fs instanceof BufferedInputStream) && !(fs instanceof NBufferedInputStream)) {
            fs = new NBufferedInputStream(fs);
        }
        Language language = Language.getDefaultLanguage();
        Path savePath = (Path)currentLoadPath.get();
        try {
            CompiledModule cmodule;
            currentLoadPath.set(path);
            cmodule = Shell.checkCompiledZip(fs, path, env, language);
            if (cmodule == null) {
                InPort src = Shell.openFile(fs, path);
                while (--skipLines >= 0) {
                    src.skipRestOfLine();
                }
                try {
                    SourceMessages messages = new SourceMessages();
                    URL url = path.toURL();
                    OutPort perr = OutPort.errDefault();
                    if (lineByLine) {
                        boolean print = ModuleBody.getMainPrintValues();
                        Consumer out = print ? Shell.getOutputConsumer(OutPort.outDefault()) : new VoidConsumer();
                        Throwable ex = Shell.run(language, env, src, out, perr, url, messages);
                        if (ex instanceof SyntaxException && ((SyntaxException)ex).getMessages() == messages) {
                            messages.printAll(perr, 20);
                            perr.flush();
                            boolean bl = false;
                            return bl;
                        }
                        if (ex != null) {
                            throw ex;
                        }
                    } else {
                        cmodule = Shell.compileSource(src, env, url, language, messages, perr);
                        if (cmodule == null) {
                            boolean print = false;
                            return print;
                        }
                    }
                }
                finally {
                    src.close();
                }
            }
            if (cmodule == null) return true;
            cmodule.evalModule(env, OutPort.outDefault());
            return true;
        }
        finally {
            currentLoadPath.set(savePath);
        }
    }

    static CompiledModule compileSource(InPort port, Environment env, URL url, Language language, SourceMessages messages, OutPort perr) throws SyntaxException, IOException {
        ModuleManager manager = ModuleManager.getInstance();
        ModuleInfo minfo = manager.findWithSourcePath(port.getName());
        Lexer lexer = language.getLexer(port, messages);
        try {
            Compilation comp = language.parse(lexer, 1, minfo);
            CallContext ctx = CallContext.getInstance();
            ctx.values = Values.noArgs;
            Object inst = ModuleExp.evalModule1(env, comp, url, null);
            messages.printAll(perr, 20);
            perr.flush();
            if (inst == null || messages.seenErrors()) {
                return null;
            }
            return new CompiledModule(comp.getModule(), inst, language);
        }
        catch (Error ex) {
            throw ex;
        }
        catch (Throwable ex) {
            if (!(ex instanceof SyntaxException) || ((SyntaxException)ex).getMessages() != messages) {
                lexer.error('e', "unexpected exception while compiling: " + ex);
                messages.printAll(perr, 20);
                ex.printStackTrace(perr);
            } else {
                messages.printAll(perr, 20);
            }
            return null;
        }
    }

    static {
        defaultPrompter = new Prompter();
    }

    static class SigIntHandler
    implements Runnable {
        public Thread thread;
        public Error trace;

        public SigIntHandler(Thread thread2) {
            this.thread = thread2;
        }

        public SigIntHandler() {
            this.thread = Thread.currentThread();
        }

        @Override
        public void run() {
            Error ex = new Error("user interrupt of " + this.thread);
            ex.setStackTrace(this.thread.getStackTrace());
            this.trace = ex;
            this.thread.stop();
        }
    }

    static class Prompter
    extends Procedure1 {
        Prompter() {
        }

        @Override
        public Object apply1(Object arg) {
            return ((TtyInPort)arg).defaultPrompt();
        }
    }

}

