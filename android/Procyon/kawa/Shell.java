// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import gnu.mapping.Values;
import gnu.expr.ModuleManager;
import gnu.kawa.io.NBufferedInputStream;
import java.io.BufferedInputStream;
import gnu.kawa.io.BinaryInPort;
import java.io.File;
import gnu.mapping.WrappedException;
import gnu.bytecode.ZipLoader;
import java.io.IOException;
import gnu.expr.CompiledModule;
import gnu.kawa.io.Path;
import java.io.InputStream;
import gnu.mapping.WrongArguments;
import gnu.text.Lexer;
import java.io.PrintWriter;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.text.SyntaxException;
import gnu.expr.ModuleInfo;
import java.lang.reflect.InvocationTargetException;
import gnu.expr.Compilation;
import gnu.kawa.util.Signals;
import gnu.bytecode.ArrayClassLoader;
import gnu.mapping.CallContext;
import java.net.URL;
import gnu.mapping.Procedure;
import gnu.kawa.io.TtyInPort;
import gnu.text.SourceMessages;
import gnu.kawa.io.InPort;
import gnu.mapping.Environment;
import gnu.kawa.format.AbstractFormat;
import java.io.Writer;
import gnu.expr.Language;
import gnu.lists.VoidConsumer;
import gnu.lists.Consumer;
import gnu.kawa.io.OutPort;
import gnu.expr.ModuleBody;
import gnu.mapping.Procedure1;
import java.lang.reflect.Method;

public class Shell
{
    public static ThreadLocal currentLoadPath;
    private static Class[] noClasses;
    private static Class[] boolClasses;
    private static Class[] lispPushClasses;
    private static Class[] xmlPrinterClasses;
    private static Class[] httpPrinterClasses;
    private static Object consumerArg;
    static Object[][] formats;
    public static String defaultFormatName;
    public static Object[] defaultFormatInfo;
    public static Method defaultFormatMethod;
    public static final Procedure1 defaultPrompter;
    
    public static void setDefaultFormat(String name) {
        name = (Shell.defaultFormatName = name.intern());
        int i = 0;
        Object[] info;
        while (true) {
            info = Shell.formats[i];
            final Object iname = info[0];
            if (iname == null) {
                System.err.println("kawa: unknown output format '" + name + "'");
                System.exit(-1);
            }
            else if (iname == name) {
                break;
            }
            ++i;
        }
        Shell.defaultFormatInfo = info;
        try {
            final Class formatClass = Class.forName((String)info[1]);
            Shell.defaultFormatMethod = formatClass.getMethod((String)info[2], (Class[])info[3]);
        }
        catch (Throwable ex) {
            System.err.println("kawa:  caught " + ex + " while looking for format '" + name + "'");
            System.exit(-1);
        }
        if (!Shell.defaultFormatInfo[1].equals("gnu.lists.VoidConsumer")) {
            ModuleBody.setMainPrintValues(true);
        }
    }
    
    public static Consumer getOutputConsumer(final OutPort out) {
        final Object[] info = Shell.defaultFormatInfo;
        if (out == null) {
            return VoidConsumer.getInstance();
        }
        if (info == null) {
            return Language.getDefaultLanguage().getOutputConsumer(out);
        }
        try {
            final Object[] args = new Object[info.length - 4];
            System.arraycopy(info, 4, args, 0, args.length);
            final boolean useConsumer = args[0] == Shell.consumerArg;
            int i = args.length;
            while (--i >= 0) {
                if (args[i] == Shell.consumerArg) {
                    args[i] = out;
                }
            }
            final Object format = Shell.defaultFormatMethod.invoke(null, args);
            if (format instanceof AbstractFormat) {
                return ((AbstractFormat)format).makeConsumer(out);
            }
            return (Consumer)format;
        }
        catch (Exception ex) {
            throw new RuntimeException("cannot get output-format '" + Shell.defaultFormatName + "' - caught " + ex);
        }
    }
    
    public static boolean run(final Language language, final Environment env) {
        final InPort inp = InPort.inDefault();
        final SourceMessages messages = new SourceMessages();
        OutPort perr;
        if (inp instanceof TtyInPort) {
            ((TtyInPort)inp).setPrompter(Shell.defaultPrompter);
            perr = OutPort.errDefault();
        }
        else {
            perr = null;
        }
        final Throwable ex = run(language, env, inp, OutPort.outDefault(), perr, messages);
        if (ex == null) {
            return true;
        }
        printError(ex, messages, OutPort.errDefault());
        return false;
    }
    
    public static Throwable run(final Language language, final Environment env, final InPort inp, final OutPort pout, final OutPort perr, final SourceMessages messages) {
        final Consumer out = getOutputConsumer(pout);
        return run(language, env, inp, out, perr, null, messages);
    }
    
    public static boolean run(final Language language, final Environment env, final InPort inp, final Consumer out, final OutPort perr, final URL url) {
        final SourceMessages messages = new SourceMessages();
        final Throwable ex = run(language, env, inp, out, perr, url, messages);
        if (ex != null) {
            printError(ex, messages, perr);
        }
        return ex == null;
    }
    
    public static Throwable run(final Language language, final Environment env, final InPort inp, final Consumer out, final OutPort perr, final URL url, final SourceMessages messages) {
        final Language saveLanguage = Language.setSaveCurrent(language);
        final Lexer lexer = language.getLexer(inp, messages);
        final boolean interactive = inp instanceof TtyInPort;
        lexer.setInteractive(interactive);
        final CallContext ctx = CallContext.getInstance();
        Consumer saveConsumer = null;
        if (out != null) {
            saveConsumer = ctx.consumer;
            ctx.consumer = out;
        }
        try {
            final Thread thread = Thread.currentThread();
            final ClassLoader parentLoader = thread.getContextClassLoader();
            if (!(parentLoader instanceof ArrayClassLoader)) {
                thread.setContextClassLoader(new ArrayClassLoader(parentLoader));
            }
        }
        catch (SecurityException ex2) {}
        final Method parserMethod = getJLineParserMethod(inp);
        final Environment saveEnv = Environment.setSaveCurrent(env);
        try {
            SigIntHandler sigIntHandler = null;
            if (interactive) {
                sigIntHandler = new SigIntHandler();
                ((TtyInPort)inp).sigIntHandler = sigIntHandler;
            }
            while (true) {
                Object oldIntHandler = null;
                final int opts = 135;
                try {
                    if (interactive) {
                        oldIntHandler = Signals.register("INT", ((TtyInPort)inp).sigIntHandler);
                    }
                    Compilation comp = null;
                    Label_0208: {
                        if (parserMethod != null) {
                            try {
                                comp = (Compilation)parserMethod.invoke(null, language, lexer);
                                break Label_0208;
                            }
                            catch (InvocationTargetException ex) {
                                throw ex.getTargetException();
                            }
                        }
                        comp = language.parse(lexer, opts, null);
                    }
                    boolean sawError;
                    if (interactive) {
                        sawError = messages.checkErrors(perr, 20);
                        perr.flush();
                    }
                    else {
                        if (messages.seenErrors()) {
                            throw new SyntaxException(messages);
                        }
                        sawError = false;
                    }
                    if (comp == null) {
                        break;
                    }
                    if (sawError) {
                        comp.lexical.pop(comp.mainLambda);
                        continue;
                    }
                    if (!ModuleExp.evalModule(env, ctx, comp, url, perr)) {
                        throw new SyntaxException(messages);
                    }
                    if (out instanceof Writer) {
                        ((Writer)out).flush();
                    }
                    if (inp.eofSeen()) {
                        break;
                    }
                    continue;
                }
                catch (ThreadDeath e) {
                    if (!interactive) {
                        throw e;
                    }
                    if (sigIntHandler == null || sigIntHandler.trace == null) {
                        e.printStackTrace(perr);
                    }
                    else {
                        sigIntHandler.trace.printStackTrace(perr);
                    }
                    Thread.interrupted();
                    continue;
                }
                catch (Error e2) {
                    throw e2;
                }
                catch (Throwable e3) {
                    if (!interactive) {
                        return e3;
                    }
                    printError(e3, messages, perr);
                    continue;
                }
                finally {
                    if (oldIntHandler != null) {
                        Signals.unregister("INT", oldIntHandler);
                    }
                }
            }
        }
        finally {
            Environment.restoreCurrent(saveEnv);
            if (out != null) {
                ctx.consumer = saveConsumer;
            }
            Language.restoreCurrent(saveLanguage);
        }
        return null;
    }
    
    static Method getJLineParserMethod(final InPort in) {
        Class cls = in.getClass();
        try {
            if (cls.getName().equals("gnu.kawa.io.JLineInPort")) {
                cls = Class.forName("gnu.kawa.io.JLineInPort$KawaParsedLine");
                return cls.getDeclaredMethod("parse", Language.class, Lexer.class);
            }
        }
        catch (Throwable t) {}
        return null;
    }
    
    public static void printError(final Throwable ex, final SourceMessages messages, final OutPort perr) {
        if (ex instanceof WrongArguments) {
            final WrongArguments e = (WrongArguments)ex;
            messages.printAll(perr, 20);
            if (e.usage != null) {
                perr.println("usage: " + e.usage);
            }
            e.printStackTrace(perr);
        }
        else {
            final SyntaxException se;
            if (ex instanceof SyntaxException && (se = (SyntaxException)ex).getMessages() == messages) {
                se.printAll(perr, 20);
                se.clear();
            }
            else {
                messages.printAll(perr, 20);
                ex.printStackTrace(perr);
            }
        }
        perr.flush();
    }
    
    public static final CompiledModule checkCompiledZip(final InputStream fs, final Path path, final Environment env, final Language language) throws IOException {
        try {
            fs.mark(5);
            final boolean isZip = fs.read() == 80 && fs.read() == 75 && fs.read() == 3 && fs.read() == 4;
            fs.reset();
            if (!isZip) {
                return null;
            }
        }
        catch (IOException ex2) {
            return null;
        }
        fs.close();
        final Environment orig_env = Environment.getCurrent();
        final String name = path.toString();
        try {
            if (env != orig_env) {
                Environment.setCurrent(env);
            }
            final File zfile = path.toFile();
            if (zfile == null) {
                throw new RuntimeException("load: " + name + " - not a file path");
            }
            if (!zfile.exists()) {
                throw new RuntimeException("load: " + name + " - not found");
            }
            if (!zfile.canRead()) {
                throw new RuntimeException("load: " + name + " - not readable");
            }
            final ZipLoader loader = new ZipLoader(name);
            final Class clas = loader.loadAllClasses();
            return CompiledModule.make(clas, language);
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
    
    static InPort openFile(final InputStream fs, final Path path) throws IOException {
        final Object conv = Environment.user().get("port-char-encoding");
        if (conv == null || conv == Boolean.TRUE) {
            return BinaryInPort.openHeuristicFile(fs, path);
        }
        return InPort.openFile(fs, path, conv);
    }
    
    public static boolean runFileOrClass(final String fname, final boolean lineByLine, final int skipLines) {
        final Language language = Language.getDefaultLanguage();
        try {
            Path path;
            InputStream fs;
            if (fname.equals("-")) {
                path = Path.valueOf("/dev/stdin");
                fs = System.in;
            }
            else {
                path = Path.valueOf(fname);
                fs = path.openInputStream();
            }
            try {
                final Environment env = Environment.getCurrent();
                return runFile(fs, path, env, lineByLine, skipLines);
            }
            catch (Error e) {
                throw e;
            }
            catch (Throwable e2) {
                e2.printStackTrace(System.err);
                return false;
            }
        }
        catch (Error e3) {
            throw e3;
        }
        catch (Throwable e4) {
            Class clas;
            try {
                clas = Class.forName(fname);
            }
            catch (Exception ex3) {
                System.err.println("Cannot read file " + e4.getMessage());
                return false;
            }
            try {
                runClass(clas, Environment.getCurrent());
                return true;
            }
            catch (Error ex) {
                throw ex;
            }
            catch (Throwable ex2) {
                ex2.printStackTrace();
                return false;
            }
        }
    }
    
    public static void runClass(final Class clas, final Environment env) throws Throwable {
        final CompiledModule cmodule = CompiledModule.make(clas, Language.getDefaultLanguage());
        cmodule.evalModule(env, OutPort.outDefault());
    }
    
    public static final boolean runFile(InputStream fs, final Path path, final Environment env, final boolean lineByLine, int skipLines) throws Throwable {
        if (!(fs instanceof BufferedInputStream) && !(fs instanceof NBufferedInputStream)) {
            fs = new NBufferedInputStream(fs);
        }
        final Language language = Language.getDefaultLanguage();
        final Path savePath = Shell.currentLoadPath.get();
        try {
            Shell.currentLoadPath.set(path);
            CompiledModule cmodule = checkCompiledZip(fs, path, env, language);
            if (cmodule == null) {
                final InPort src = openFile(fs, path);
                while (--skipLines >= 0) {
                    src.skipRestOfLine();
                }
                try {
                    final SourceMessages messages = new SourceMessages();
                    final URL url = path.toURL();
                    final OutPort perr = OutPort.errDefault();
                    if (lineByLine) {
                        final boolean print = ModuleBody.getMainPrintValues();
                        final Consumer out = print ? getOutputConsumer(OutPort.outDefault()) : new VoidConsumer();
                        final Throwable ex = run(language, env, src, out, perr, url, messages);
                        if (ex instanceof SyntaxException && ((SyntaxException)ex).getMessages() == messages) {
                            messages.printAll(perr, 20);
                            perr.flush();
                            return false;
                        }
                        if (ex != null) {
                            throw ex;
                        }
                    }
                    else {
                        cmodule = compileSource(src, env, url, language, messages, perr);
                        if (cmodule == null) {
                            return false;
                        }
                    }
                }
                finally {
                    src.close();
                }
            }
            if (cmodule != null) {
                cmodule.evalModule(env, OutPort.outDefault());
            }
        }
        finally {
            Shell.currentLoadPath.set(savePath);
        }
        return true;
    }
    
    static CompiledModule compileSource(final InPort port, final Environment env, final URL url, final Language language, final SourceMessages messages, final OutPort perr) throws SyntaxException, IOException {
        final ModuleManager manager = ModuleManager.getInstance();
        final ModuleInfo minfo = manager.findWithSourcePath(port.getName());
        final Lexer lexer = language.getLexer(port, messages);
        try {
            final Compilation comp = language.parse(lexer, 1, minfo);
            final CallContext ctx = CallContext.getInstance();
            ctx.values = Values.noArgs;
            final Object inst = ModuleExp.evalModule1(env, comp, url, null);
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
        catch (Throwable ex2) {
            if (!(ex2 instanceof SyntaxException) || ((SyntaxException)ex2).getMessages() != messages) {
                lexer.error('e', "unexpected exception while compiling: " + ex2);
                messages.printAll(perr, 20);
                ex2.printStackTrace(perr);
            }
            else {
                messages.printAll(perr, 20);
            }
            return null;
        }
    }
    
    static {
        Shell.currentLoadPath = new ThreadLocal();
        Shell.noClasses = new Class[0];
        Shell.boolClasses = new Class[] { Boolean.TYPE };
        Shell.lispPushClasses = new Class[] { OutPort.class, Character.TYPE, Boolean.TYPE };
        Shell.xmlPrinterClasses = new Class[] { Consumer.class, Object.class };
        Shell.httpPrinterClasses = new Class[] { OutPort.class };
        Shell.consumerArg = "(consumer)";
        Shell.formats = new Object[][] { { "scheme", "gnu.kawa.functions.DisplayFormat", "getSchemeFormat", Shell.boolClasses, Boolean.FALSE }, { "readable-scheme", "gnu.kawa.functions.DisplayFormat", "getSchemeFormat", Shell.boolClasses, Boolean.TRUE }, { "elisp", "gnu.kawa.functions.DisplayFormat", "getEmacsLispFormat", Shell.boolClasses, Boolean.FALSE }, { "readable-elisp", "gnu.kawa.functions.DisplayFormat", "getEmacsLispFormat", Shell.boolClasses, Boolean.TRUE }, { "clisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", Shell.boolClasses, Boolean.FALSE }, { "readable-clisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", Shell.boolClasses, Boolean.TRUE }, { "commonlisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", Shell.boolClasses, Boolean.FALSE }, { "readable-commonlisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", Shell.boolClasses, Boolean.TRUE }, { "xml", "gnu.xml.XMLPrinter", "make", Shell.xmlPrinterClasses, Shell.consumerArg, null }, { "html", "gnu.xml.XMLPrinter", "make", Shell.xmlPrinterClasses, Shell.consumerArg, "html" }, { "xhtml", "gnu.xml.XMLPrinter", "make", Shell.xmlPrinterClasses, Shell.consumerArg, "xhtml" }, { "cgi", "gnu.kawa.xml.HttpPrinter", "make", Shell.httpPrinterClasses, Shell.consumerArg }, { "ignore", "gnu.lists.VoidConsumer", "make", { Consumer.class }, Shell.consumerArg }, { null } };
        defaultPrompter = new Prompter();
    }
    
    static class Prompter extends Procedure1
    {
        @Override
        public Object apply1(final Object arg) {
            return ((TtyInPort)arg).defaultPrompt();
        }
    }
    
    static class SigIntHandler implements Runnable
    {
        public Thread thread;
        public Error trace;
        
        public SigIntHandler(final Thread thread) {
            this.thread = thread;
        }
        
        public SigIntHandler() {
            this.thread = Thread.currentThread();
        }
        
        @Override
        public void run() {
            final Error ex = new Error("user interrupt of " + this.thread);
            ex.setStackTrace(this.thread.getStackTrace());
            this.trace = ex;
            this.thread.stop();
        }
    }
}
