// 
// Decompiled by Procyon v0.5.36
// 

package kawa;

import gnu.kawa.io.WriterManager;
import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import java.awt.Desktop;
import gnu.kawa.servlet.KawaHttpHandler;
import gnu.kawa.io.TermErrorStream;
import gnu.expr.ModuleBody;
import gnu.kawa.util.ExitCalled;
import gnu.text.SyntaxException;
import gnu.expr.Mangling;
import java.io.FileNotFoundException;
import gnu.expr.ModuleInfo;
import java.io.OutputStream;
import gnu.kawa.io.CheckConsole;
import kawa.lang.SyntaxPattern;
import gnu.expr.ModuleExp;
import gnu.kawa.servlet.HttpRequestContext;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import gnu.expr.ModuleManager;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.CharArrayInPort;
import gnu.text.SourceMessages;
import gnu.expr.ApplicationMainSupport;
import java.io.InputStream;
import gnu.kawa.io.Path;
import gnu.lists.FString;
import java.io.File;
import java.util.List;
import java.util.Collections;
import gnu.expr.Compilation;
import java.io.PrintStream;
import gnu.mapping.Values;
import gnu.mapping.Environment;
import gnu.expr.Language;
import gnu.mapping.Procedure0or1;

public class repl extends Procedure0or1
{
    public static String compilationTopname;
    Language language;
    static Language previousLanguage;
    static int defaultParseOptions;
    public static String messagePrefix;
    public static String homeDirectory;
    static boolean shutdownRegistered;
    int nextActionArgCount;
    boolean usedActionArgCount;
    private static boolean checkedDomTerm;
    
    public repl() {
        this.nextActionArgCount = -1;
        this.usedActionArgCount = false;
    }
    
    public repl(final Language language) {
        this.nextActionArgCount = -1;
        this.usedActionArgCount = false;
        this.language = language;
    }
    
    @Override
    public Object apply0() {
        Shell.run(this.language, Environment.getCurrent());
        return Values.empty;
    }
    
    @Override
    public Object apply1(final Object env) {
        Shell.run(this.language, (Environment)env);
        return Values.empty;
    }
    
    protected void error(String message) {
        if (repl.messagePrefix != null) {
            message = repl.messagePrefix + message;
        }
        System.err.println(message);
        System.exit(-1);
    }
    
    void bad_option(String str) {
        str = "bad option '" + str + "'";
        if (repl.messagePrefix != null) {
            str = repl.messagePrefix + str;
        }
        System.err.println(str);
        printOptions(System.err);
        System.exit(-1);
    }
    
    public static void printOption(final PrintStream out, final String option, final String doc) {
        out.print(" ");
        out.print(option);
        for (int len = option.length() + 1, i = 0; i < 30 - len; ++i) {
            out.print(" ");
        }
        out.print(" ");
        out.println(doc);
    }
    
    public static void printOptions(final PrintStream out) {
        out.println("Usage: [java kawa.repl | kawa] [options ...]");
        out.println();
        out.println(" Generic options:");
        printOption(out, "--help", "Show help about options");
        printOption(out, "--author", "Show author information");
        printOption(out, "--version", "Show version information");
        out.println();
        out.println(" Options");
        printOption(out, "-e <expr>", "Evaluate expression <expr>");
        printOption(out, "-c <expr>", "Same as -e, but make sure ~/.kawarc.scm is run first");
        printOption(out, "-f <filename>", "File to interpret");
        printOption(out, "-s| --", "Start reading commands interactively from console");
        printOption(out, "-w", "Launch the interpreter in a GUI window");
        printOption(out, "--server <port>", "Start a server accepting telnet connections on <port>");
        printOption(out, "--debug-dump-zip", "Compiled interactive expressions to a zip archive");
        printOption(out, "--debug-print-expr", "Print generated internal expressions");
        printOption(out, "--debug-print-final-expr", "Print expression after any optimizations");
        printOption(out, "--debug-error-prints-stack-trace", "Print stack trace with errors");
        printOption(out, "--debug-warning-prints-stack-trace", "Print stack trace with warnings");
        printOption(out, "--[no-]full-tailcalls", "(Don't) use full tail-calls");
        printOption(out, "-C <filename> ...", "Compile named files to Java class files");
        printOption(out, "--output-format <format>", "Use <format> when printing top-level output");
        printOption(out, "--<language>", "Select source language, one of:");
        final String[][] languages = Language.getLanguages();
        for (int i = 0; i < languages.length; ++i) {
            out.print("   ");
            final String[] lang = languages[i];
            for (int nwords = lang.length - 1, j = 0; j < nwords; ++j) {
                out.print(lang[j] + " ");
            }
            if (i == 0) {
                out.print("[default]");
            }
            out.println();
        }
        out.println(" Compilation options, must be specified before -C");
        printOption(out, "-d <dirname>", "Directory to place .class files in");
        printOption(out, "-P <prefix>", "Prefix to prepand to class names");
        printOption(out, "-T <topname>", "name to give to top-level class");
        printOption(out, "--applet", "Generate an applet");
        printOption(out, "--servlet", "Generate a servlet");
        printOption(out, "--module-static", "Top-level definitions are by default static");
        final List<String> keys = Compilation.options.keys();
        Collections.sort(keys);
        for (int k = 0; k < keys.size(); ++k) {
            final String name = keys.get(k);
            printOption(out, "--" + name, Compilation.options.getDoc(name));
        }
        out.println();
        out.println("For more information go to:  http://www.gnu.org/software/kawa/");
    }
    
    static void checkInitFile() {
        if (repl.homeDirectory == null) {
            final File initFile = getInitFile();
            if (initFile != null && initFile.exists() && !Shell.runFileOrClass(initFile.getPath(), true, 0)) {
                System.exit(-1);
            }
        }
    }
    
    static File getInitFile() {
        File initFile = null;
        repl.homeDirectory = System.getProperty("user.home");
        Object scmHomeDirectory;
        if (repl.homeDirectory != null) {
            scmHomeDirectory = new FString(repl.homeDirectory);
            final String file_separator = System.getProperty("file.separator");
            String kawarc_name = new String();
            if (Language.getDefaultLanguage().getName().equals("Emacs-Lisp")) {
                kawarc_name = ".jemacs";
            }
            else {
                kawarc_name = ("/".equals(file_separator) ? ".kawarc.scm" : "kawarc.scm");
            }
            initFile = new File(repl.homeDirectory, kawarc_name);
        }
        else {
            scmHomeDirectory = Boolean.FALSE;
        }
        Environment.getCurrent().put("home-directory", scmHomeDirectory);
        return initFile;
    }
    
    public static String evalInitFileWithErrorMessage() {
        final File initFile = getInitFile();
        if (initFile != null && initFile.exists()) {
            try {
                final Path path = Path.valueOf(initFile.getPath());
                final InputStream fs = path.openInputStream();
                final Environment env = Environment.getCurrent();
                Shell.runFile(fs, path, env, true, 0);
            }
            catch (Error e) {
                throw e;
            }
            catch (Throwable e2) {
                return "An error occurred while loading '" + initFile + "' : " + e2;
            }
        }
        return null;
    }
    
    int getArgs(final String[] args, int iArg) {
        final int avail = args.length - iArg;
        if (this.nextActionArgCount >= 0) {
            if (this.nextActionArgCount > avail) {
                this.error("there are only " + avail + " arguments remaining");
            }
            ApplicationMainSupport.setArgs(args, iArg, this.nextActionArgCount);
            iArg += this.nextActionArgCount;
            this.nextActionArgCount = -1;
            this.usedActionArgCount = true;
        }
        else {
            ApplicationMainSupport.setArgs(args, iArg, avail);
            this.usedActionArgCount = false;
        }
        return iArg;
    }
    
    public static void setArgs(final String[] args, final int arg_start) {
        ApplicationMainSupport.setArgs(args, arg_start, args.length - arg_start);
    }
    
    public static void getLanguageFromFilenameExtension(final String name) {
        if (repl.previousLanguage == null) {
            repl.previousLanguage = Language.getInstanceFromFilenameExtension(name);
            if (repl.previousLanguage != null) {
                Language.setDefaults(repl.previousLanguage);
                return;
            }
        }
        getLanguage();
    }
    
    public static void getLanguage() {
        if (repl.previousLanguage == null) {
            Language.setDefaults(repl.previousLanguage = Language.getInstance(null));
        }
    }
    
    public static Language setLanguage(final String name) {
        final Language lang = Language.getInstance(name);
        if (lang != null) {
            if (repl.previousLanguage == null) {
                Language.setDefaults(lang);
            }
            else {
                Language.setCurrentLanguage(lang);
            }
            repl.previousLanguage = lang;
        }
        return lang;
    }
    
    public static int processArgs(final String[] args, final int iArg, final int maxArg) {
        return new repl().processArgs(args, iArg, maxArg, true);
    }
    
    public int processArgs(String[] args, int iArg, int maxArg, final boolean argsOnly) {
        boolean something_done = false;
        final boolean checkedDomTerm = false;
        int returnDelta = 0;
        if (iArg == maxArg || !"--connect".equals(args[iArg])) {
            checkDomTerm();
        }
        while (iArg < maxArg) {
            String arg = args[iArg++];
            if (arg.equals("-c") || arg.equals("-e")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                final String expr = args[iArg++];
                getLanguage();
                iArg = this.getArgs(args, iArg);
                if (arg.equals("-c")) {
                    checkInitFile();
                }
                final Language language = Language.getDefaultLanguage();
                final SourceMessages messages = new SourceMessages();
                final Throwable ex = Shell.run(language, Environment.getCurrent(), new CharArrayInPort(expr), OutPort.outDefault(), OutPort.errDefault(), messages);
                if (ex != null) {
                    Shell.printError(ex, messages, OutPort.errDefault());
                    System.exit(-1);
                }
                something_done = true;
            }
            else if (arg.equals("-f")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                final String filename = args[iArg++];
                getLanguageFromFilenameExtension(filename);
                iArg = this.getArgs(args, iArg);
                checkInitFile();
                if (!Shell.runFileOrClass(filename, true, 0)) {
                    System.exit(-1);
                }
                something_done = true;
            }
            else {
                if (arg.startsWith("--script")) {
                    final String count = arg.substring(8);
                    int skipLines = 0;
                    if (count.length() > 0) {
                        try {
                            skipLines = Integer.parseInt(count);
                        }
                        catch (Exception ex3) {
                            iArg = maxArg;
                        }
                    }
                    if (iArg == maxArg) {
                        this.bad_option(arg);
                    }
                    final String filename2 = args[iArg++];
                    getLanguageFromFilenameExtension(filename2);
                    iArg = this.getArgs(args, iArg);
                    checkInitFile();
                    if (!Shell.runFileOrClass(filename2, true, skipLines)) {
                        System.exit(-1);
                    }
                    return -1;
                }
                if (arg.equals("\\")) {
                    if (iArg == maxArg) {
                        this.bad_option(arg);
                    }
                    final String filename = args[iArg];
                    ApplicationMainSupport.commandName.set(filename);
                    final SourceMessages messages = new SourceMessages();
                    try {
                        final InputStream fstream = new BufferedInputStream(new FileInputStream(filename));
                        int ch = fstream.read();
                        if (ch == 35) {
                            final StringBuffer sbuf = new StringBuffer(100);
                            final ArrayList<String> xargs = new ArrayList<String>(10);
                            int state = 0;
                            while (ch != 10 && ch != 13 && ch >= 0) {
                                ch = fstream.read();
                            }
                            while (true) {
                                ch = fstream.read();
                                if (ch < 0) {
                                    System.err.println("unexpected end-of-file processing argument line for: '" + filename + '\'');
                                    System.exit(-1);
                                }
                                if (state == 0) {
                                    if (ch == 92 || ch == 39 || ch == 34) {
                                        state = ch;
                                        continue;
                                    }
                                    if (ch == 10 || ch == 13) {
                                        break;
                                    }
                                    if (ch == 32 || ch == 9) {
                                        if (sbuf.length() > 0) {
                                            xargs.add(sbuf.toString());
                                            sbuf.setLength(0);
                                            continue;
                                        }
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
                                sbuf.append((char)ch);
                            }
                            if (sbuf.length() > 0) {
                                xargs.add(sbuf.toString());
                            }
                            final int nxargs = xargs.size();
                            final String[] nargs = new String[maxArg + nxargs - 1];
                            --iArg;
                            System.arraycopy(args, 0, nargs, 0, iArg);
                            for (int i = 0; i < nxargs; ++i) {
                                nargs[iArg + i] = xargs.get(i);
                            }
                            System.arraycopy(args, iArg + 1, nargs, iArg + nxargs, maxArg - iArg - 1);
                            maxArg = nargs.length;
                            returnDelta += maxArg - args.length;
                            args = nargs;
                            continue;
                        }
                    }
                    catch (Throwable ex) {
                        Shell.printError(ex, messages, OutPort.errDefault());
                        System.exit(1);
                    }
                    return -1;
                }
                if (arg.equals("-s") || arg.equals("--")) {
                    getLanguage();
                    iArg = this.getArgs(args, iArg);
                    checkInitFile();
                    Shell.run(Language.getDefaultLanguage(), Environment.getCurrent());
                    something_done = true;
                    if (!this.usedActionArgCount) {
                        return -1;
                    }
                    continue;
                }
                else if (arg.startsWith("-w")) {
                    getLanguage();
                    iArg = this.getArgs(args, iArg);
                    checkInitFile();
                    final String msg = startGuiConsole(arg.substring(2));
                    if (msg != null) {
                        this.error(arg + " failed: " + msg);
                    }
                    something_done = true;
                }
                else if (arg.equals("-d")) {
                    if (iArg == maxArg) {
                        this.bad_option(arg);
                    }
                    final ModuleManager manager = ModuleManager.getInstance();
                    manager.setCompilationDirectory(args[iArg++]);
                }
                else if (arg.equals("--target") || arg.equals("-target")) {
                    if (iArg == maxArg) {
                        this.bad_option(arg);
                    }
                    arg = args[iArg++];
                    int version = -1;
                    if (arg.equals("8") || arg.equals("1.8")) {
                        version = 3407872;
                    }
                    else if (arg.equals("7") || arg.equals("1.7")) {
                        version = 3342336;
                    }
                    else if (arg.equals("6") || arg.equals("1.6")) {
                        version = 3276800;
                    }
                    else if (arg.equals("5") || arg.equals("1.5")) {
                        version = 3211264;
                    }
                    else if (arg.equals("1.4")) {
                        version = 3145728;
                    }
                    else if (arg.equals("1.3")) {
                        version = 3080192;
                    }
                    else if (arg.equals("1.2")) {
                        version = 3014656;
                    }
                    else if (arg.equals("1.1")) {
                        version = 2949123;
                    }
                    else {
                        this.bad_option(arg);
                    }
                    Compilation.defaultClassFileVersion = version;
                }
                else if (arg.equals("-P")) {
                    if (iArg == maxArg) {
                        this.bad_option(arg);
                    }
                    Compilation.classPrefixDefault = args[iArg++];
                }
                else if (arg.equals("-T")) {
                    if (iArg == maxArg) {
                        this.bad_option(arg);
                    }
                    repl.compilationTopname = args[iArg++];
                }
                else if (arg.equals("--main")) {
                    repl.defaultParseOptions |= 0x100;
                }
                else if (arg.startsWith("--with-arg-count=")) {
                    final String count = arg.substring(17);
                    if (count.length() <= 0) {
                        continue;
                    }
                    try {
                        this.nextActionArgCount = Integer.parseInt(count);
                    }
                    catch (Exception ex4) {
                        this.error("non-integer value to --with-arg-count");
                    }
                }
                else {
                    if (arg.equals("-C")) {
                        if (iArg == maxArg) {
                            this.bad_option(arg);
                        }
                        compileFiles(args, iArg, maxArg);
                        return -1;
                    }
                    if (arg.equals("--output-format") || arg.equals("--format")) {
                        if (iArg == maxArg) {
                            this.bad_option(arg);
                        }
                        Shell.setDefaultFormat(args[iArg++]);
                    }
                    else if (arg.equals("--connect")) {
                        if (iArg == maxArg) {
                            this.bad_option(arg);
                        }
                        final String portArg = args[iArg++];
                        int port;
                        if (portArg.equals("-")) {
                            port = 0;
                        }
                        else {
                            try {
                                port = Integer.parseInt(portArg);
                            }
                            catch (NumberFormatException ex5) {
                                this.bad_option("--connect port#");
                                port = -1;
                            }
                        }
                        try {
                            final Socket socket = new Socket(InetAddress.getByName(null), port);
                            final Telnet conn = new Telnet(socket, true);
                            final InputStream sin = conn.getInputStream();
                            final OutputStream sout = conn.getOutputStream();
                            final PrintStream pout = new PrintStream(sout, true);
                            System.setIn(sin);
                            System.setOut(pout);
                            System.setErr(pout);
                            checkDomTerm();
                        }
                        catch (IOException ex2) {
                            ex2.printStackTrace(System.err);
                            throw new Error(ex2.toString());
                        }
                    }
                    else {
                        if (arg.equals("--server")) {
                            getLanguage();
                            if (iArg == maxArg) {
                                this.bad_option(arg);
                            }
                            final String portArg = args[iArg++];
                            int port;
                            if (portArg.equals("-")) {
                                port = 0;
                            }
                            else {
                                try {
                                    port = Integer.parseInt(portArg);
                                }
                                catch (NumberFormatException ex5) {
                                    this.bad_option("--server port#");
                                    port = -1;
                                }
                            }
                            try {
                                final ServerSocket ssocket = new ServerSocket(port);
                                port = ssocket.getLocalPort();
                                System.err.println("Listening on port " + port);
                                while (true) {
                                    System.err.print("waiting ... ");
                                    System.err.flush();
                                    final Socket client = ssocket.accept();
                                    System.err.println("got connection from " + client.getInetAddress() + " port:" + client.getPort());
                                    TelnetRepl.serve(Language.getDefaultLanguage(), client);
                                }
                            }
                            catch (IOException ex2) {
                                throw new Error(ex2.toString());
                            }
                        }
                        if (arg.equals("--http-auto-handler")) {
                            if (iArg + 1 >= maxArg) {
                                this.bad_option(arg);
                            }
                            System.err.println("kawa: HttpServer classes not found");
                            System.exit(-1);
                        }
                        else if (arg.equals("--http-start")) {
                            if (iArg >= maxArg) {
                                this.bad_option("missing httpd port argument");
                            }
                            System.err.println("kawa: HttpServer classes not found");
                            System.exit(-1);
                        }
                        else if (arg.equals("--applet")) {
                            repl.defaultParseOptions |= 0x10;
                        }
                        else if (arg.equals("--servlet")) {
                            repl.defaultParseOptions |= 0x20;
                            HttpRequestContext.importServletDefinitions = 2;
                        }
                        else if (arg.startsWith("--browse-manual")) {
                            String rest = arg.substring(15);
                            if (rest.length() > 0 && rest.charAt(0) == '=') {
                                rest = rest.substring(1);
                            }
                            final String msg2 = browseManual(null, rest);
                            if (msg2 != null) {
                                this.error(arg + " failed: " + msg2);
                            }
                            something_done = true;
                        }
                        else if (arg.equals("--debug-dump-zip")) {
                            ModuleExp.dumpZipPrefix = "kawa-zip-dump-";
                        }
                        else if (arg.equals("--enable-anf")) {
                            Compilation.enableANF = true;
                        }
                        else if (arg.equals("--debug-print-anf") && Compilation.enableANF) {
                            Compilation.debugPrintANF = true;
                        }
                        else if (arg.equals("--debug-print-expr")) {
                            Compilation.debugPrintExpr = true;
                        }
                        else if (arg.equals("--debug-print-final-expr")) {
                            Compilation.debugPrintFinalExpr = true;
                        }
                        else if (arg.equals("--debug-syntax-pattern-match")) {
                            SyntaxPattern.printSyntaxPatternMatch = true;
                        }
                        else if (arg.equals("--debug-error-prints-stack-trace")) {
                            SourceMessages.debugStackTraceOnError = true;
                        }
                        else if (arg.equals("--debug-warning-prints-stack-trace")) {
                            SourceMessages.debugStackTraceOnWarning = true;
                        }
                        else if (arg.equals("--diagnostic-strip-directories")) {
                            SourceMessages.stripDirectoriesDefault = true;
                        }
                        else if (arg.equals("--module-nonstatic") || arg.equals("--no-module-static")) {
                            Compilation.moduleStatic = -1;
                        }
                        else if (arg.equals("--module-static")) {
                            Compilation.moduleStatic = 1;
                        }
                        else if (arg.equals("--module-static-run")) {
                            Compilation.moduleStatic = 2;
                        }
                        else if (arg.equals("--no-inline") || arg.equals("--inline=none")) {
                            Compilation.inlineOk = false;
                        }
                        else if (arg.equals("--no-console")) {
                            CheckConsole.setHaveConsole(false);
                        }
                        else if (arg.equals("--console")) {
                            CheckConsole.setHaveConsole(true);
                        }
                        else if (arg.equals("--inline")) {
                            Compilation.inlineOk = true;
                        }
                        else if (arg.equals("--cps")) {
                            Compilation.defaultCallConvention = 4;
                        }
                        else if (arg.equals("--full-tailcalls")) {
                            Compilation.defaultCallConvention = 3;
                        }
                        else if (arg.equals("--no-full-tailcalls")) {
                            Compilation.defaultCallConvention = 1;
                        }
                        else if (arg.equals("--pedantic")) {
                            Language.requirePedantic = true;
                        }
                        else if (arg.equals("--help")) {
                            printOptions(System.out);
                            System.exit(0);
                        }
                        else if (arg.equals("--author")) {
                            System.out.println("Per Bothner <per@bothner.com>");
                            System.exit(0);
                        }
                        else if (arg.equals("--version")) {
                            System.out.print("Kawa ");
                            System.out.print(Version.getVersion());
                            System.out.println();
                            System.out.println("Copyright (C) 2017 Per Bothner");
                            something_done = true;
                        }
                        else if (arg.startsWith("-D")) {
                            final int eq = arg.indexOf(61);
                            if (eq == 2) {
                                this.error("bad option '" + arg + "' - empty key before '='");
                            }
                            String key;
                            String val;
                            if (eq < 0) {
                                key = arg.substring(2);
                                val = "";
                            }
                            else {
                                key = arg.substring(2, eq);
                                val = arg.substring(eq + 1);
                            }
                            System.setProperty(key, val);
                        }
                        else if (arg.length() > 0 && arg.charAt(0) == '-') {
                            final boolean doubleDash = arg.length() > 2 && arg.charAt(1) == '-';
                            String name = arg.substring(doubleDash ? 2 : 1);
                            final Language lang = setLanguage(name);
                            if (lang != null) {
                                continue;
                            }
                            final int eq2 = name.indexOf(61);
                            String opt_value;
                            if (eq2 < 0) {
                                opt_value = null;
                            }
                            else {
                                opt_value = name.substring(eq2 + 1);
                                name = name.substring(0, eq2);
                            }
                            final boolean startsWithNo = name.startsWith("no-") && name.length() > 3;
                            boolean addedNo = false;
                            if (opt_value == null && startsWithNo) {
                                opt_value = "no";
                                name = name.substring(3);
                                addedNo = true;
                            }
                            String msg3 = Compilation.options.set(name, opt_value);
                            if (msg3 == null) {
                                continue;
                            }
                            if (msg3 == "unknown option name") {
                                if (addedNo) {
                                    msg3 = "unknown option '" + name + "'";
                                }
                                else if (startsWithNo) {
                                    msg3 = "both '--no-' prefix and '=" + opt_value + "' specified";
                                }
                            }
                            if (msg3 == "unknown option name") {
                                this.bad_option(arg);
                            }
                            else {
                                this.error("bad option '" + arg + "': " + msg3);
                            }
                        }
                        else {
                            if (ApplicationMainSupport.processSetProperty(arg)) {
                                continue;
                            }
                            if (argsOnly) {
                                break;
                            }
                            if (something_done && !this.usedActionArgCount) {
                                break;
                            }
                            final String filename = arg;
                            getLanguageFromFilenameExtension(filename);
                            iArg = this.getArgs(args, iArg);
                            checkInitFile();
                            if (!Shell.runFileOrClass(filename, false, 0)) {
                                System.exit(-1);
                            }
                            something_done = true;
                            if (!this.usedActionArgCount) {
                                break;
                            }
                            continue;
                        }
                    }
                }
            }
        }
        if (!something_done) {
            getLanguage();
            iArg = this.getArgs(args, iArg);
            checkInitFile();
            if (!CheckConsole.haveConsole()) {
                startGuiConsole("");
            }
            else {
                final boolean ok = Shell.run(Language.getDefaultLanguage(), Environment.getCurrent());
                if (!ok) {
                    System.exit(-1);
                }
            }
        }
        return something_done ? -1 : (iArg - returnDelta);
    }
    
    public static void compileFiles(final String[] args, final int iArg, final int maxArg) {
        final ModuleManager manager = ModuleManager.getInstance();
        final Compilation[] comps = new Compilation[maxArg - iArg];
        final ModuleInfo[] infos = new ModuleInfo[maxArg - iArg];
        final SourceMessages messages = new SourceMessages();
        for (int i = iArg; i < maxArg; ++i) {
            final String arg = args[i];
            getLanguageFromFilenameExtension(arg);
            final Language language = Language.getDefaultLanguage();
            Compilation comp = null;
            try {
                InPort fstream;
                try {
                    final Path path = Path.valueOf(arg);
                    fstream = Shell.openFile(path.openInputStream(), path);
                }
                catch (FileNotFoundException ex) {
                    System.err.println(ex);
                    System.exit(-1);
                    break;
                }
                final ModuleInfo minfo = manager.findWithSourcePath(arg);
                if (repl.compilationTopname != null) {
                    String cname = Mangling.mangleNameIfNeeded(repl.compilationTopname);
                    if (Compilation.classPrefixDefault != null) {
                        cname = Compilation.classPrefixDefault + cname;
                    }
                    minfo.setClassName(cname);
                }
                comp = language.parse(fstream, messages, repl.defaultParseOptions, minfo);
                infos[i - iArg] = minfo;
                comps[i - iArg] = comp;
            }
            catch (Exception ex2) {
                if (!(ex2 instanceof SyntaxException) || ((SyntaxException)ex2).getMessages() != messages) {
                    internalError(ex2, comp, arg);
                }
            }
            if (messages.seenErrorsOrWarnings()) {
                System.err.println("(compiling " + arg + ')');
                if (messages.checkErrors(System.err, 20)) {
                    System.exit(1);
                }
            }
        }
        for (int i = iArg; i < maxArg; ++i) {
            final String arg = args[i];
            final Compilation comp2 = comps[i - iArg];
            try {
                System.err.println("(compiling " + arg + " to " + comp2.mainClass.getName() + ')');
                infos[i - iArg].loadByStages(16);
                boolean sawErrors = messages.seenErrors();
                messages.checkErrors(System.err, 50);
                if (sawErrors) {
                    System.exit(-1);
                }
                comps[i - iArg] = comp2;
                sawErrors = messages.seenErrors();
                messages.checkErrors(System.err, 50);
                if (sawErrors) {
                    System.exit(-1);
                }
            }
            catch (Exception ex3) {
                internalError(ex3, comp2, arg);
            }
        }
    }
    
    static void internalError(final Throwable ex, final Compilation comp, final Object arg) {
        try {
            comp.getMessages().checkErrors(System.err, 50);
        }
        catch (Exception ex2) {}
        final StringBuffer sbuf = new StringBuffer();
        if (comp != null) {
            final String file = comp.getFileName();
            final int line = comp.getLineNumber();
            if (file != null && line > 0) {
                sbuf.append(file);
                sbuf.append(':');
                sbuf.append(line);
                sbuf.append(": ");
            }
        }
        sbuf.append("internal error while compiling ");
        sbuf.append(arg);
        System.err.println(sbuf.toString());
        ex.printStackTrace(System.err);
        System.exit(-1);
    }
    
    public static void main(final String[] args) {
        try {
            ExitCalled.push();
            new repl().processArgs(args, 0, args.length, false);
        }
        finally {
            if (!repl.shutdownRegistered) {
                OutPort.runCleanups();
            }
            ModuleBody.exitDecrement();
            ExitCalled.pop();
        }
    }
    
    public static void checkDomTerm() {
        if (repl.checkedDomTerm) {
            return;
        }
        repl.checkedDomTerm = true;
        final String dversion = CheckConsole.getDomTermVersionInfo();
        if (dversion != null) {
            if (dversion.indexOf("err-handled;") < 0) {
                TermErrorStream.setSystemErr(false);
            }
            OutPort.getSystemOut().setDomTerm(true);
            OutPort.getSystemErr().setDomTerm(true);
        }
    }
    
    private static boolean isAnsiTerminal() {
        return CheckConsole.haveConsole();
    }
    
    private static Throwable startJfxConsole() {
        try {
            final Object replBackend = Class.forName("kawa.DomTermBackend").newInstance();
            Class.forName("org.domterm.javafx.WebTerminalApp").getMethod("startApp", Class.forName("org.domterm.Backend"), String.class, String[].class).invoke(null, replBackend, "Kawa (DomTerm)", null);
            return null;
        }
        catch (Throwable ex) {
            return ex;
        }
    }
    
    public static String startGuiConsole(String command) {
        try {
            if ("".equals(command)) {
                final String defaults = CheckConsole.consoleType();
                String rest = ";" + defaults + ";";
                while (true) {
                    final int semi = rest.indexOf(59, 1);
                    if (semi < 0) {
                        return "no window type (" + defaults + ") worked";
                    }
                    final String cur = rest.substring(1, semi).trim();
                    rest = rest.substring(semi);
                    if (cur.length() > 0 && startGuiConsole(cur) == null) {
                        return null;
                    }
                }
            }
            else {
                if ("javafx".equals(command)) {
                    final Throwable ex = startJfxConsole();
                    return (ex == null) ? null : ex.toString();
                }
                if ("swing".equals(command)) {
                    Class.forName("kawa.GuiConsole").newInstance();
                    return null;
                }
                if ("console".equals(command)) {
                    Shell.run(Language.getDefaultLanguage(), Environment.getCurrent());
                    return null;
                }
                if ("qtdomterm".equals(command)) {
                    command = "browser=qtdomterm --connect localhost:%W";
                }
                final Object result = Class.forName("kawa.DomTermBackend").getMethod("startDomTermConsole", String.class).invoke(null, command);
                return (result == null) ? null : result.toString();
            }
        }
        catch (Throwable ex) {
            return "caught exception " + ex.toString();
        }
    }
    
    public static String browseManual(String path, String browserCommand) {
        try {
            final String kawaHome = System.getProperty("kawa.home");
            if (kawaHome == null) {
                return "kawa.home not set";
            }
            final File manualFile = new File(kawaHome + "/doc/kawa-manual.epub");
            if (!manualFile.exists()) {
                return manualFile + " does not exist";
            }
            if (browserCommand == null || browserCommand.length() == 0) {
                browserCommand = "browser";
            }
            if (browserCommand.equals("javafx")) {
                final String filename = kawaHome + "/doc/browse-kawa-manual";
                setLanguage("scheme");
                Shell.runFileOrClass(filename, false, 0);
                return null;
            }
            final String defaultUrl = "index.xhtml";
            final String pathPrefix = "jar:file:" + manualFile + "!/OEBPS";
            KawaHttpHandler.addStaticFileHandler("/kawa-manual/", pathPrefix, defaultUrl, true);
            int htport = 0;
            final HttpServer httpHandler = KawaHttpHandler.startServer(htport, System.err);
            htport = httpHandler.getAddress().getPort();
            if (path == null || path.length() == 0) {
                path = defaultUrl;
            }
            final String webUrl = "http://127.0.0.1:" + htport + "/kawa-manual/" + path;
            if (browserCommand.equals("google-chrome")) {
                browserCommand = "google-chrome --app=%U";
            }
            if (!browserCommand.equals("browser")) {
                if (browserCommand.indexOf(37) < 0) {
                    browserCommand += " %U";
                }
                try {
                    Runtime.getRuntime().exec(browserCommand.replace("%U", webUrl));
                }
                catch (Throwable ex2) {
                    return "cannot read manual (using command: " + browserCommand + ")";
                }
                return null;
            }
            if (!Desktop.isDesktopSupported()) {
                return "using default desktop browser not supported";
            }
            Desktop.getDesktop().browse(new URI(webUrl));
            return null;
        }
        catch (Throwable ex) {
            return "caught exception " + ex.toString();
        }
    }
    
    static {
        repl.compilationTopname = null;
        repl.defaultParseOptions = 72;
        repl.messagePrefix = "kawa: ";
        repl.shutdownRegistered = WriterManager.instance.registerShutdownHook();
    }
}
