/*
 * Decompiled with CFR 0.139.
 */
package kawa;

import com.sun.net.httpserver.HttpServer;
import gnu.bytecode.ClassType;
import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.Mangling;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.CheckConsole;
import gnu.kawa.io.InPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.io.TermErrorStream;
import gnu.kawa.io.WriterManager;
import gnu.kawa.servlet.HttpRequestContext;
import gnu.kawa.servlet.KawaHttpHandler;
import gnu.kawa.util.ExitCalled;
import gnu.lists.FString;
import gnu.mapping.Environment;
import gnu.mapping.Procedure0or1;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import gnu.text.Options;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import kawa.Shell;
import kawa.Telnet;
import kawa.TelnetInputStream;
import kawa.TelnetOutputStream;
import kawa.TelnetRepl;
import kawa.Version;
import kawa.lang.SyntaxPattern;

public class repl
extends Procedure0or1 {
    public static String compilationTopname = null;
    Language language;
    static Language previousLanguage;
    static int defaultParseOptions;
    public static String messagePrefix;
    public static String homeDirectory;
    static boolean shutdownRegistered;
    int nextActionArgCount = -1;
    boolean usedActionArgCount = false;
    private static boolean checkedDomTerm;

    public repl() {
    }

    public repl(Language language) {
        this.language = language;
    }

    @Override
    public Object apply0() {
        Shell.run(this.language, Environment.getCurrent());
        return Values.empty;
    }

    @Override
    public Object apply1(Object env) {
        Shell.run(this.language, (Environment)env);
        return Values.empty;
    }

    protected void error(String message) {
        if (messagePrefix != null) {
            message = messagePrefix + message;
        }
        System.err.println(message);
        System.exit(-1);
    }

    void bad_option(String str) {
        str = "bad option '" + str + "'";
        if (messagePrefix != null) {
            str = messagePrefix + str;
        }
        System.err.println(str);
        repl.printOptions(System.err);
        System.exit(-1);
    }

    public static void printOption(PrintStream out, String option, String doc) {
        out.print(" ");
        out.print(option);
        int len = option.length() + 1;
        for (int i = 0; i < 30 - len; ++i) {
            out.print(" ");
        }
        out.print(" ");
        out.println(doc);
    }

    public static void printOptions(PrintStream out) {
        out.println("Usage: [java kawa.repl | kawa] [options ...]");
        out.println();
        out.println(" Generic options:");
        repl.printOption(out, "--help", "Show help about options");
        repl.printOption(out, "--author", "Show author information");
        repl.printOption(out, "--version", "Show version information");
        out.println();
        out.println(" Options");
        repl.printOption(out, "-e <expr>", "Evaluate expression <expr>");
        repl.printOption(out, "-c <expr>", "Same as -e, but make sure ~/.kawarc.scm is run first");
        repl.printOption(out, "-f <filename>", "File to interpret");
        repl.printOption(out, "-s| --", "Start reading commands interactively from console");
        repl.printOption(out, "-w", "Launch the interpreter in a GUI window");
        repl.printOption(out, "--server <port>", "Start a server accepting telnet connections on <port>");
        repl.printOption(out, "--debug-dump-zip", "Compiled interactive expressions to a zip archive");
        repl.printOption(out, "--debug-print-expr", "Print generated internal expressions");
        repl.printOption(out, "--debug-print-final-expr", "Print expression after any optimizations");
        repl.printOption(out, "--debug-error-prints-stack-trace", "Print stack trace with errors");
        repl.printOption(out, "--debug-warning-prints-stack-trace", "Print stack trace with warnings");
        repl.printOption(out, "--[no-]full-tailcalls", "(Don't) use full tail-calls");
        repl.printOption(out, "-C <filename> ...", "Compile named files to Java class files");
        repl.printOption(out, "--output-format <format>", "Use <format> when printing top-level output");
        repl.printOption(out, "--<language>", "Select source language, one of:");
        String[][] languages = Language.getLanguages();
        for (int i = 0; i < languages.length; ++i) {
            out.print("   ");
            String[] lang = languages[i];
            int nwords = lang.length - 1;
            for (int j = 0; j < nwords; ++j) {
                out.print(lang[j] + " ");
            }
            if (i == 0) {
                out.print("[default]");
            }
            out.println();
        }
        out.println(" Compilation options, must be specified before -C");
        repl.printOption(out, "-d <dirname>", "Directory to place .class files in");
        repl.printOption(out, "-P <prefix>", "Prefix to prepand to class names");
        repl.printOption(out, "-T <topname>", "name to give to top-level class");
        repl.printOption(out, "--applet", "Generate an applet");
        repl.printOption(out, "--servlet", "Generate a servlet");
        repl.printOption(out, "--module-static", "Top-level definitions are by default static");
        ArrayList<String> keys = Compilation.options.keys();
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); ++i) {
            String name = (String)keys.get(i);
            repl.printOption(out, "--" + name, Compilation.options.getDoc(name));
        }
        out.println();
        out.println("For more information go to:  http://www.gnu.org/software/kawa/");
    }

    static void checkInitFile() {
        File initFile;
        if (homeDirectory == null && (initFile = repl.getInitFile()) != null && initFile.exists() && !Shell.runFileOrClass(initFile.getPath(), true, 0)) {
            System.exit(-1);
        }
    }

    static File getInitFile() {
        Comparable<Boolean> scmHomeDirectory;
        File initFile = null;
        homeDirectory = System.getProperty("user.home");
        if (homeDirectory != null) {
            scmHomeDirectory = new FString(homeDirectory);
            String file_separator = System.getProperty("file.separator");
            String kawarc_name = new String();
            kawarc_name = Language.getDefaultLanguage().getName().equals("Emacs-Lisp") ? ".jemacs" : ("/".equals(file_separator) ? ".kawarc.scm" : "kawarc.scm");
            initFile = new File(homeDirectory, kawarc_name);
        } else {
            scmHomeDirectory = Boolean.FALSE;
        }
        Environment.getCurrent().put("home-directory", (Object)scmHomeDirectory);
        return initFile;
    }

    public static String evalInitFileWithErrorMessage() {
        File initFile = repl.getInitFile();
        if (initFile != null && initFile.exists()) {
            try {
                Path path = Path.valueOf(initFile.getPath());
                InputStream fs = path.openInputStream();
                Environment env = Environment.getCurrent();
                Shell.runFile(fs, path, env, true, 0);
            }
            catch (Error e) {
                throw e;
            }
            catch (Throwable e) {
                return "An error occurred while loading '" + initFile + "' : " + e;
            }
        }
        return null;
    }

    int getArgs(String[] args, int iArg) {
        int avail = args.length - iArg;
        if (this.nextActionArgCount >= 0) {
            if (this.nextActionArgCount > avail) {
                this.error("there are only " + avail + " arguments remaining");
            }
            ApplicationMainSupport.setArgs(args, iArg, this.nextActionArgCount);
            iArg += this.nextActionArgCount;
            this.nextActionArgCount = -1;
            this.usedActionArgCount = true;
        } else {
            ApplicationMainSupport.setArgs(args, iArg, avail);
            this.usedActionArgCount = false;
        }
        return iArg;
    }

    public static void setArgs(String[] args, int arg_start) {
        ApplicationMainSupport.setArgs(args, arg_start, args.length - arg_start);
    }

    public static void getLanguageFromFilenameExtension(String name) {
        if (previousLanguage == null && (previousLanguage = Language.getInstanceFromFilenameExtension(name)) != null) {
            Language.setDefaults(previousLanguage);
            return;
        }
        repl.getLanguage();
    }

    public static void getLanguage() {
        if (previousLanguage == null) {
            previousLanguage = Language.getInstance(null);
            Language.setDefaults(previousLanguage);
        }
    }

    public static Language setLanguage(String name) {
        Language lang = Language.getInstance(name);
        if (lang != null) {
            if (previousLanguage == null) {
                Language.setDefaults(lang);
            } else {
                Language.setCurrentLanguage(lang);
            }
            previousLanguage = lang;
        }
        return lang;
    }

    public static int processArgs(String[] args, int iArg, int maxArg) {
        return new repl().processArgs(args, iArg, maxArg, true);
    }

    public int processArgs(String[] args, int iArg, int maxArg, boolean argsOnly) {
        boolean something_done = false;
        boolean checkedDomTerm = false;
        int returnDelta = 0;
        if (iArg == maxArg || !"--connect".equals(args[iArg])) {
            repl.checkDomTerm();
        }
        while (iArg < maxArg) {
            String filename;
            SourceMessages messages;
            String portArg;
            String count;
            String arg;
            if ((arg = args[iArg++]).equals("-c") || arg.equals("-e")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                String expr = args[iArg++];
                repl.getLanguage();
                iArg = this.getArgs(args, iArg);
                if (arg.equals("-c")) {
                    repl.checkInitFile();
                }
                Language language = Language.getDefaultLanguage();
                messages = new SourceMessages();
                Throwable ex = Shell.run(language, Environment.getCurrent(), (InPort)new CharArrayInPort(expr), OutPort.outDefault(), OutPort.errDefault(), messages);
                if (ex != null) {
                    Shell.printError(ex, messages, OutPort.errDefault());
                    System.exit(-1);
                }
                something_done = true;
                continue;
            }
            if (arg.equals("-f")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                filename = args[iArg++];
                repl.getLanguageFromFilenameExtension(filename);
                iArg = this.getArgs(args, iArg);
                repl.checkInitFile();
                if (!Shell.runFileOrClass(filename, true, 0)) {
                    System.exit(-1);
                }
                something_done = true;
                continue;
            }
            if (arg.startsWith("--script")) {
                count = arg.substring(8);
                int skipLines = 0;
                if (count.length() > 0) {
                    try {
                        skipLines = Integer.parseInt(count);
                    }
                    catch (Exception ex) {
                        iArg = maxArg;
                    }
                }
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                String filename2 = args[iArg++];
                repl.getLanguageFromFilenameExtension(filename2);
                iArg = this.getArgs(args, iArg);
                repl.checkInitFile();
                if (!Shell.runFileOrClass(filename2, true, skipLines)) {
                    System.exit(-1);
                }
                return -1;
            }
            if (arg.equals("\\")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                filename = args[iArg];
                ApplicationMainSupport.commandName.set(filename);
                messages = new SourceMessages();
                try {
                    BufferedInputStream fstream = new BufferedInputStream(new FileInputStream(filename));
                    int ch = ((InputStream)fstream).read();
                    if (ch == 35) {
                        StringBuffer sbuf = new StringBuffer(100);
                        ArrayList<String> xargs = new ArrayList<String>(10);
                        int state = 0;
                        while (ch != 10 && ch != 13 && ch >= 0) {
                            ch = ((InputStream)fstream).read();
                        }
                        do {
                            if ((ch = ((InputStream)fstream).read()) < 0) {
                                System.err.println("unexpected end-of-file processing argument line for: '" + filename + '\'');
                                System.exit(-1);
                            }
                            if (state == 0) {
                                if (ch == 92 || ch == 39 || ch == 34) {
                                    state = ch;
                                    continue;
                                }
                                if (ch == 10 || ch == 13) break;
                                if (ch == 32 || ch == 9) {
                                    if (sbuf.length() <= 0) continue;
                                    xargs.add(sbuf.toString());
                                    sbuf.setLength(0);
                                    continue;
                                }
                            } else if (state == 92) {
                                state = 0;
                            } else if (ch == state) {
                                state = 0;
                                continue;
                            }
                            sbuf.append((char)ch);
                        } while (true);
                        if (sbuf.length() > 0) {
                            xargs.add(sbuf.toString());
                        }
                        int nxargs = xargs.size();
                        String[] nargs = new String[maxArg + nxargs - 1];
                        System.arraycopy(args, 0, nargs, 0, --iArg);
                        for (int i = 0; i < nxargs; ++i) {
                            nargs[iArg + i] = (String)xargs.get(i);
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
                repl.getLanguage();
                iArg = this.getArgs(args, iArg);
                repl.checkInitFile();
                Shell.run(Language.getDefaultLanguage(), Environment.getCurrent());
                something_done = true;
                if (this.usedActionArgCount) continue;
                return -1;
            }
            if (arg.startsWith("-w")) {
                repl.getLanguage();
                iArg = this.getArgs(args, iArg);
                repl.checkInitFile();
                String msg = repl.startGuiConsole(arg.substring(2));
                if (msg != null) {
                    this.error(arg + " failed: " + msg);
                }
                something_done = true;
                continue;
            }
            if (arg.equals("-d")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                ModuleManager manager = ModuleManager.getInstance();
                manager.setCompilationDirectory(args[iArg++]);
                continue;
            }
            if (arg.equals("--target") || arg.equals("-target")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                arg = args[iArg++];
                int version = -1;
                if (arg.equals("8") || arg.equals("1.8")) {
                    version = 3407872;
                } else if (arg.equals("7") || arg.equals("1.7")) {
                    version = 3342336;
                } else if (arg.equals("6") || arg.equals("1.6")) {
                    version = 3276800;
                } else if (arg.equals("5") || arg.equals("1.5")) {
                    version = 3211264;
                } else if (arg.equals("1.4")) {
                    version = 3145728;
                } else if (arg.equals("1.3")) {
                    version = 3080192;
                } else if (arg.equals("1.2")) {
                    version = 3014656;
                } else if (arg.equals("1.1")) {
                    version = 2949123;
                } else {
                    this.bad_option(arg);
                }
                Compilation.defaultClassFileVersion = version;
                continue;
            }
            if (arg.equals("-P")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                Compilation.classPrefixDefault = args[iArg++];
                continue;
            }
            if (arg.equals("-T")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                compilationTopname = args[iArg++];
                continue;
            }
            if (arg.equals("--main")) {
                defaultParseOptions |= 256;
                continue;
            }
            if (arg.startsWith("--with-arg-count=")) {
                count = arg.substring(17);
                if (count.length() <= 0) continue;
                try {
                    this.nextActionArgCount = Integer.parseInt(count);
                }
                catch (Exception ex) {
                    this.error("non-integer value to --with-arg-count");
                }
                continue;
            }
            if (arg.equals("-C")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                repl.compileFiles(args, iArg, maxArg);
                return -1;
            }
            if (arg.equals("--output-format") || arg.equals("--format")) {
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                Shell.setDefaultFormat(args[iArg++]);
                continue;
            }
            if (arg.equals("--connect")) {
                int port;
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                if ((portArg = args[iArg++]).equals("-")) {
                    port = 0;
                } else {
                    try {
                        port = Integer.parseInt(portArg);
                    }
                    catch (NumberFormatException ex) {
                        this.bad_option("--connect port#");
                        port = -1;
                    }
                }
                try {
                    Socket socket = new Socket(InetAddress.getByName(null), port);
                    Telnet conn = new Telnet(socket, true);
                    TelnetInputStream sin = conn.getInputStream();
                    TelnetOutputStream sout = conn.getOutputStream();
                    PrintStream pout = new PrintStream(sout, true);
                    System.setIn(sin);
                    System.setOut(pout);
                    System.setErr(pout);
                    repl.checkDomTerm();
                    continue;
                }
                catch (IOException ex) {
                    ex.printStackTrace(System.err);
                    throw new Error(ex.toString());
                }
            }
            if (arg.equals("--server")) {
                int port;
                repl.getLanguage();
                if (iArg == maxArg) {
                    this.bad_option(arg);
                }
                if ((portArg = args[iArg++]).equals("-")) {
                    port = 0;
                } else {
                    try {
                        port = Integer.parseInt(portArg);
                    }
                    catch (NumberFormatException ex) {
                        this.bad_option("--server port#");
                        port = -1;
                    }
                }
                try {
                    ServerSocket ssocket = new ServerSocket(port);
                    port = ssocket.getLocalPort();
                    System.err.println("Listening on port " + port);
                    do {
                        System.err.print("waiting ... ");
                        System.err.flush();
                        Socket client = ssocket.accept();
                        System.err.println("got connection from " + client.getInetAddress() + " port:" + client.getPort());
                        TelnetRepl.serve(Language.getDefaultLanguage(), client);
                    } while (true);
                }
                catch (IOException ex) {
                    throw new Error(ex.toString());
                }
            }
            if (arg.equals("--http-auto-handler")) {
                if (iArg + 1 >= maxArg) {
                    this.bad_option(arg);
                }
                System.err.println("kawa: HttpServer classes not found");
                System.exit(-1);
                continue;
            }
            if (arg.equals("--http-start")) {
                if (iArg >= maxArg) {
                    this.bad_option("missing httpd port argument");
                }
                System.err.println("kawa: HttpServer classes not found");
                System.exit(-1);
                continue;
            }
            if (arg.equals("--applet")) {
                defaultParseOptions |= 16;
                continue;
            }
            if (arg.equals("--servlet")) {
                defaultParseOptions |= 32;
                HttpRequestContext.importServletDefinitions = 2;
                continue;
            }
            if (arg.startsWith("--browse-manual")) {
                String msg;
                String rest = arg.substring(15);
                if (rest.length() > 0 && rest.charAt(0) == '=') {
                    rest = rest.substring(1);
                }
                if ((msg = repl.browseManual(null, rest)) != null) {
                    this.error(arg + " failed: " + msg);
                }
                something_done = true;
                continue;
            }
            if (arg.equals("--debug-dump-zip")) {
                ModuleExp.dumpZipPrefix = "kawa-zip-dump-";
                continue;
            }
            if (arg.equals("--enable-anf")) {
                Compilation.enableANF = true;
                continue;
            }
            if (arg.equals("--debug-print-anf") && Compilation.enableANF) {
                Compilation.debugPrintANF = true;
                continue;
            }
            if (arg.equals("--debug-print-expr")) {
                Compilation.debugPrintExpr = true;
                continue;
            }
            if (arg.equals("--debug-print-final-expr")) {
                Compilation.debugPrintFinalExpr = true;
                continue;
            }
            if (arg.equals("--debug-syntax-pattern-match")) {
                SyntaxPattern.printSyntaxPatternMatch = true;
                continue;
            }
            if (arg.equals("--debug-error-prints-stack-trace")) {
                SourceMessages.debugStackTraceOnError = true;
                continue;
            }
            if (arg.equals("--debug-warning-prints-stack-trace")) {
                SourceMessages.debugStackTraceOnWarning = true;
                continue;
            }
            if (arg.equals("--diagnostic-strip-directories")) {
                SourceMessages.stripDirectoriesDefault = true;
                continue;
            }
            if (arg.equals("--module-nonstatic") || arg.equals("--no-module-static")) {
                Compilation.moduleStatic = -1;
                continue;
            }
            if (arg.equals("--module-static")) {
                Compilation.moduleStatic = 1;
                continue;
            }
            if (arg.equals("--module-static-run")) {
                Compilation.moduleStatic = 2;
                continue;
            }
            if (arg.equals("--no-inline") || arg.equals("--inline=none")) {
                Compilation.inlineOk = false;
                continue;
            }
            if (arg.equals("--no-console")) {
                CheckConsole.setHaveConsole(false);
                continue;
            }
            if (arg.equals("--console")) {
                CheckConsole.setHaveConsole(true);
                continue;
            }
            if (arg.equals("--inline")) {
                Compilation.inlineOk = true;
                continue;
            }
            if (arg.equals("--cps")) {
                Compilation.defaultCallConvention = 4;
                continue;
            }
            if (arg.equals("--full-tailcalls")) {
                Compilation.defaultCallConvention = 3;
                continue;
            }
            if (arg.equals("--no-full-tailcalls")) {
                Compilation.defaultCallConvention = 1;
                continue;
            }
            if (arg.equals("--pedantic")) {
                Language.requirePedantic = true;
                continue;
            }
            if (arg.equals("--help")) {
                repl.printOptions(System.out);
                System.exit(0);
                continue;
            }
            if (arg.equals("--author")) {
                System.out.println("Per Bothner <per@bothner.com>");
                System.exit(0);
                continue;
            }
            if (arg.equals("--version")) {
                System.out.print("Kawa ");
                System.out.print(Version.getVersion());
                System.out.println();
                System.out.println("Copyright (C) 2017 Per Bothner");
                something_done = true;
                continue;
            }
            if (arg.startsWith("-D")) {
                String val;
                String key;
                int eq = arg.indexOf(61);
                if (eq == 2) {
                    this.error("bad option '" + arg + "' - empty key before '='");
                }
                if (eq < 0) {
                    key = arg.substring(2);
                    val = "";
                } else {
                    key = arg.substring(2, eq);
                    val = arg.substring(eq + 1);
                }
                System.setProperty(key, val);
                continue;
            }
            if (arg.length() > 0 && arg.charAt(0) == '-') {
                String opt_value;
                String msg;
                boolean doubleDash = arg.length() > 2 && arg.charAt(1) == '-';
                String name = arg.substring(doubleDash ? 2 : 1);
                Language lang = repl.setLanguage(name);
                if (lang != null) continue;
                int eq = name.indexOf(61);
                if (eq < 0) {
                    opt_value = null;
                } else {
                    opt_value = name.substring(eq + 1);
                    name = name.substring(0, eq);
                }
                boolean startsWithNo = name.startsWith("no-") && name.length() > 3;
                boolean addedNo = false;
                if (opt_value == null && startsWithNo) {
                    opt_value = "no";
                    name = name.substring(3);
                    addedNo = true;
                }
                if ((msg = Compilation.options.set(name, opt_value)) == null) continue;
                if (msg == "unknown option name") {
                    if (addedNo) {
                        msg = "unknown option '" + name + "'";
                    } else if (startsWithNo) {
                        msg = "both '--no-' prefix and '=" + opt_value + "' specified";
                    }
                }
                if (msg == "unknown option name") {
                    this.bad_option(arg);
                    continue;
                }
                this.error("bad option '" + arg + "': " + msg);
                continue;
            }
            if (ApplicationMainSupport.processSetProperty(arg)) continue;
            if (argsOnly || something_done && !this.usedActionArgCount) break;
            filename = arg;
            repl.getLanguageFromFilenameExtension(filename);
            iArg = this.getArgs(args, iArg);
            repl.checkInitFile();
            if (!Shell.runFileOrClass(filename, false, 0)) {
                System.exit(-1);
            }
            something_done = true;
            if (this.usedActionArgCount) continue;
            break;
        }
        if (!something_done) {
            repl.getLanguage();
            iArg = this.getArgs(args, iArg);
            repl.checkInitFile();
            if (!CheckConsole.haveConsole()) {
                repl.startGuiConsole("");
            } else {
                boolean ok = Shell.run(Language.getDefaultLanguage(), Environment.getCurrent());
                if (!ok) {
                    System.exit(-1);
                }
            }
        }
        return something_done ? -1 : iArg - returnDelta;
    }

    public static void compileFiles(String[] args, int iArg, int maxArg) {
        String arg;
        int i;
        ModuleManager manager = ModuleManager.getInstance();
        Compilation[] comps = new Compilation[maxArg - iArg];
        ModuleInfo[] infos = new ModuleInfo[maxArg - iArg];
        SourceMessages messages = new SourceMessages();
        for (i = iArg; i < maxArg; ++i) {
            block11 : {
                arg = args[i];
                repl.getLanguageFromFilenameExtension(arg);
                Language language = Language.getDefaultLanguage();
                Compilation comp = null;
                try {
                    InPort fstream;
                    try {
                        Path path = Path.valueOf(arg);
                        fstream = Shell.openFile(path.openInputStream(), path);
                    }
                    catch (FileNotFoundException ex) {
                        System.err.println(ex);
                        System.exit(-1);
                        break;
                    }
                    ModuleInfo minfo = manager.findWithSourcePath(arg);
                    if (compilationTopname != null) {
                        String cname = Mangling.mangleNameIfNeeded(compilationTopname);
                        if (Compilation.classPrefixDefault != null) {
                            cname = Compilation.classPrefixDefault + cname;
                        }
                        minfo.setClassName(cname);
                    }
                    comp = language.parse(fstream, messages, defaultParseOptions, minfo);
                    infos[i - iArg] = minfo;
                    comps[i - iArg] = comp;
                }
                catch (Exception ex) {
                    if (ex instanceof SyntaxException && ((SyntaxException)ex).getMessages() == messages) break block11;
                    repl.internalError(ex, comp, arg);
                }
            }
            if (!messages.seenErrorsOrWarnings()) continue;
            System.err.println("(compiling " + arg + ')');
            if (!messages.checkErrors(System.err, 20)) continue;
            System.exit(1);
        }
        for (i = iArg; i < maxArg; ++i) {
            arg = args[i];
            Compilation comp = comps[i - iArg];
            try {
                System.err.println("(compiling " + arg + " to " + comp.mainClass.getName() + ')');
                infos[i - iArg].loadByStages(16);
                boolean sawErrors = messages.seenErrors();
                messages.checkErrors(System.err, 50);
                if (sawErrors) {
                    System.exit(-1);
                }
                comps[i - iArg] = comp;
                sawErrors = messages.seenErrors();
                messages.checkErrors(System.err, 50);
                if (!sawErrors) continue;
                System.exit(-1);
                continue;
            }
            catch (Exception ex) {
                repl.internalError(ex, comp, arg);
            }
        }
    }

    static void internalError(Throwable ex, Compilation comp, Object arg) {
        try {
            comp.getMessages().checkErrors(System.err, 50);
        }
        catch (Exception e) {
            // empty catch block
        }
        StringBuffer sbuf = new StringBuffer();
        if (comp != null) {
            String file2 = comp.getFileName();
            int line = comp.getLineNumber();
            if (file2 != null && line > 0) {
                sbuf.append(file2);
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] args) {
        try {
            ExitCalled.push();
            new repl().processArgs(args, 0, args.length, false);
        }
        finally {
            if (!shutdownRegistered) {
                OutPort.runCleanups();
            }
            ModuleBody.exitDecrement();
            ExitCalled.pop();
        }
    }

    public static void checkDomTerm() {
        if (checkedDomTerm) {
            return;
        }
        checkedDomTerm = true;
        String dversion = CheckConsole.getDomTermVersionInfo();
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
            Object replBackend = Class.forName("kawa.DomTermBackend").newInstance();
            Class.forName("org.domterm.javafx.WebTerminalApp").getMethod("startApp", Class.forName("org.domterm.Backend"), String.class, String[].class).invoke(null, replBackend, "Kawa (DomTerm)", null);
            return null;
        }
        catch (Throwable ex) {
            return ex;
        }
    }

    public static String startGuiConsole(String command) {
        try {
            Object result;
            if ("".equals(command)) {
                int semi;
                String defaults = CheckConsole.consoleType();
                String rest = ";" + defaults + ";";
                while ((semi = rest.indexOf(59, 1)) >= 0) {
                    String cur = rest.substring(1, semi).trim();
                    rest = rest.substring(semi);
                    if (cur.length() <= 0 || repl.startGuiConsole(cur) != null) continue;
                    return null;
                }
                return "no window type (" + defaults + ") worked";
            }
            if ("javafx".equals(command)) {
                Throwable ex = repl.startJfxConsole();
                return ex == null ? null : ex.toString();
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
            return (result = Class.forName("kawa.DomTermBackend").getMethod("startDomTermConsole", String.class).invoke(null, command)) == null ? null : result.toString();
        }
        catch (Throwable ex) {
            return "caught exception " + ex.toString();
        }
    }

    public static String browseManual(String path, String browserCommand) {
        try {
            String kawaHome = System.getProperty("kawa.home");
            if (kawaHome == null) {
                return "kawa.home not set";
            }
            File manualFile = new File(kawaHome + "/doc/kawa-manual.epub");
            if (!manualFile.exists()) {
                return manualFile + " does not exist";
            }
            if (browserCommand == null || browserCommand.length() == 0) {
                browserCommand = "browser";
            }
            if (browserCommand.equals("javafx")) {
                String filename = kawaHome + "/doc/browse-kawa-manual";
                repl.setLanguage("scheme");
                Shell.runFileOrClass(filename, false, 0);
                return null;
            }
            String defaultUrl = "index.xhtml";
            String pathPrefix = "jar:file:" + manualFile + "!/OEBPS";
            KawaHttpHandler.addStaticFileHandler("/kawa-manual/", pathPrefix, defaultUrl, true);
            int htport = 0;
            HttpServer httpHandler = KawaHttpHandler.startServer(htport, System.err);
            htport = httpHandler.getAddress().getPort();
            if (path == null || path.length() == 0) {
                path = defaultUrl;
            }
            String webUrl = "http://127.0.0.1:" + htport + "/kawa-manual/" + path;
            if (browserCommand.equals("google-chrome")) {
                browserCommand = "google-chrome --app=%U";
            }
            if (browserCommand.equals("browser")) {
                if (!Desktop.isDesktopSupported()) {
                    return "using default desktop browser not supported";
                }
                Desktop.getDesktop().browse(new URI(webUrl));
                return null;
            }
            if (browserCommand.indexOf(37) < 0) {
                browserCommand = browserCommand + " %U";
            }
            try {
                Runtime.getRuntime().exec(browserCommand.replace("%U", webUrl));
            }
            catch (Throwable ex) {
                return "cannot read manual (using command: " + browserCommand + ")";
            }
            return null;
        }
        catch (Throwable ex) {
            return "caught exception " + ex.toString();
        }
    }

    static {
        defaultParseOptions = 72;
        messagePrefix = "kawa: ";
        shutdownRegistered = WriterManager.instance.registerShutdownHook();
    }
}

