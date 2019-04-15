/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.GenericProc;
import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequences;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import kawa.lang.CompileFile;
import kawa.lang.Macro;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.standard.Scheme;

public class system
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$$string$Mnwith$Mndelimiter$Mnmarks$;
    public static final ModuleMethod make$Mnprocess;
    public static final ModuleMethod open$Mninput$Mnpipe;
    public static final ModuleMethod system;
    public static final ModuleMethod convert$Mnvector$Mnto$Mnstring$Mnarray;
    public static final ModuleMethod convert$Mnlist$Mnto$Mnstring$Mnarray;
    public static final ModuleMethod tokenize$Mnstring$Mnto$Mnstring$Mnarray;
    public static final ModuleMethod tokenize$Mnstring$Mnusing$Mnshell;
    public static Procedure command$Mnparse;
    public static final ModuleMethod compile$Mnfile;
    public static final ModuleMethod process$Mncommand$Mnline$Mnassignments;
    public static final ModuleMethod get$Mnenvironment$Mnvariable;
    public static final ModuleMethod get$Mnenvironment$Mnvariables;
    public static final ModuleMethod current$Mnsecond;
    public static final ModuleMethod current$Mnjiffy;
    public static final ModuleMethod jiffies$Mnper$Mnsecond;
    @SourceName(name="cmd", uri="http://kawa.gnu.org/construct", prefix="$construct$")
    public static final Macro cmd;
    @SourceName(name="sh", uri="http://kawa.gnu.org/construct", prefix="$construct$")
    public static final Macro sh;
    public static final Macro run$Mnprocess$Mnusing$Mnsh;
    public static final Macro pipe$Mnprocess;
    public static final GenericProc $Pcpipe$Mnprocess;
    public static final ModuleMethod process$Mnexit$Mnwait;
    public static final ModuleMethod process$Mnexit$Mnok$Qu;
    static final IntNum Lit0;
    static final Keyword Lit1;
    public static system $instance;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final Symbol Lit16;
    static final SyntaxRules Lit17;
    static final Symbol Lit18;
    static final SyntaxRules Lit19;
    static final SimpleSymbol Lit20;
    static final SyntaxRules Lit21;
    static final SimpleSymbol Lit22;
    static final SyntaxRules Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final Object[] Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final Namespace Lit30;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        command$Mnparse = KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(System.getProperty("file.separator"), "/")) ? tokenize$Mnstring$Mnusing$Mnshell : tokenize$Mnstring$Mnto$Mnstring$Mnarray;
        $Pcpipe$Mnprocess.setProperty(Lit1, "kawa.lib.compile_misc:pipeProcessValidateApply");
    }

    /*
     * Exception decompiling
     */
    public static Process makeProcess(Object args, Object env) {
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
    public static Object convertVectorToStringArray(Object vec) {
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object convertListToStringArray(Object lst) {
        count = Sequences.getSize(lst);
        arr = new String[count];
        bl = false;
        p = lst;
        do lbl-1000: // 2 sources:
        {
            if (lists.isNull(p)) {
                return arr;
            }
            object2 = Promise.force(p, Pair.class);
            pp2 = (Pair)object2;
            break;
        } while (true);
        catch (ClassCastException v0) {
            throw new WrongType(v0, "pp", -2, object2);
        }
        {
            v1 = Promise.force(pp2.getCar(), String.class);
            arr[i] = v1 == null ? null : v1.toString();
            ++i;
            p = pp2.getCdr();
            ** while (true)
        }
    }

    public static InputStream openInputPipe(Object command) {
        return system.makeProcess(command, null).getInputStream();
    }

    public static int system(Object command) {
        return system.makeProcess(command, null).waitFor();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object tokenizeStringToStringArray(String string) {
        toks = new StringTokenizer(string);
        v0 /* !! */  = list = LList.Empty;
        while (toks.hasMoreTokens()) {
            v0 /* !! */  = lists.cons(toks.nextToken(), list);
        }
        rlist = list;
        count = Sequences.getSize(rlist);
        arr = new String[count];
        n = count - 1;
        p = rlist;
        do lbl-1000: // 2 sources:
        {
            if (lists.isNull(p)) {
                return arr;
            }
            object2 = Promise.force(p, Pair.class);
            pp2 = (Pair)object2;
            break;
        } while (true);
        catch (ClassCastException v1) {
            throw new WrongType(v1, "pp", -2, object2);
        }
        {
            v2 = Promise.force(pp2.getCar(), String.class);
            arr[i] = v2 == null ? null : v2.toString();
            --i;
            p = pp2.getCdr();
            ** while (true)
        }
    }

    public static String[] tokenizeStringUsingShell(Object string) {
        String[] arr = new String[3];
        arr[0] = "/bin/sh";
        arr[1] = "-c";
        Object object2 = Promise.force(string, String.class);
        arr[2] = object2 == null ? null : object2.toString();
        return arr;
    }

    public static void compileFile(CharSequence source, String output) {
        SourceMessages messages = new SourceMessages();
        Compilation comp = CompileFile.read(source.toString(), messages);
        comp.explicit = true;
        if (messages.seenErrors()) {
            throw new SyntaxException(messages);
        }
        comp.compileToArchive(comp.getModule(), output);
        if (messages.seenErrors()) {
            throw new SyntaxException(messages);
        }
    }

    public static void processCommandLineAssignments() {
        ApplicationMainSupport.processSetProperties();
    }

    public static Object getEnvironmentVariable(CharSequence name) {
        String r = System.getenv(name.toString());
        return r == null ? Boolean.FALSE : r;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object getEnvironmentVariables() {
        it = System.getenv().entrySet().iterator();
        v0 /* !! */  = LList.Empty;
        do lbl-1000: // 2 sources:
        {
            r = v0 /* !! */ ;
            if (it.hasNext() == false) return r;
            object2 = Promise.force(it.next(), Map.Entry.class);
            e = (Map.Entry)object2;
            break;
        } while (true);
        catch (ClassCastException v1) {
            throw new WrongType(v1, "e", -2, object2);
        }
        {
            v0 /* !! */  = lists.cons(lists.cons((String)e.getKey(), (String)e.getValue()), r);
            ** while (true)
        }
    }

    public static double currentSecond() {
        return (double)System.currentTimeMillis() * 0.001;
    }

    public static long currentJiffy() {
        return System.nanoTime();
    }

    public static long jiffiesPerSecond() {
        return 1000000000;
    }

    public static int processExitWait(Process process) {
        return process.waitFor();
    }

    public static boolean isProcessExitOk(Process process) {
        return process.waitFor() == 0;
    }

    public static {
        Lit30 = Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
        Lit29 = Symbol.valueOf("$string-with-delimiter-marks$");
        Lit28 = Symbol.valueOf("run-process");
        Lit27 = Symbol.valueOf("%simple-construct-builder");
        Lit26 = new Object[0];
        Lit25 = Symbol.valueOf("process-exit-ok?");
        Lit24 = Symbol.valueOf("process-exit-wait");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[2];
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit26, 1, "system.scm:136"), "\u0001", "\u0003", Lit26, 0);
        Object[] arrobject = new Object[2];
        Lit22 = Symbol.valueOf("pipe-process");
        arrobject[0] = Lit22;
        arrobject[1] = Symbol.valueOf("%pipe-process");
        arrsyntaxRule[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\u0013", Lit26, 3, "system.scm:137"), "\u0001\u0001\u0000", "\u0011\u0018\u00049\u0011\u0018\f\t\u0003\b\u000b\u0012", arrobject, 0);
        Lit23 = new SyntaxRules(Lit26, arrsyntaxRule, 3, Lit22);
        Lit20 = Symbol.valueOf("run-process-using-sh");
        Lit21 = new SyntaxRules(Lit26, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit26, 1, "system.scm:131"), "\u0000", "\u0011\u0018\u0004\u0011\u0018\f\t\u0014\u0002", new Object[]{Lit28, Keyword.make("shell"), Boolean.TRUE}, 0)}, 1, Lit20);
        Lit18 = Symbol.make(Lit30, "sh");
        Lit19 = new SyntaxRules(Lit26, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit26, 1, "system.scm:128"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", new Object[]{new SyntaxForms.SimpleSyntaxForm(Lit27, TemplateScope.make("kawa.lib.syntax")), Lit20, Lit29}, 0)}, 1, Lit18);
        Lit16 = Symbol.make(Lit30, "cmd");
        Lit17 = new SyntaxRules(Lit26, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit26, 1, "system.scm:127"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", new Object[]{new SyntaxForms.SimpleSyntaxForm(Lit27, TemplateScope.make("kawa.lib.syntax")), Lit28, Lit29}, 0)}, 1, Lit16);
        Lit15 = Symbol.valueOf("jiffies-per-second");
        Lit14 = Symbol.valueOf("current-jiffy");
        Lit13 = Symbol.valueOf("current-second");
        Lit12 = Symbol.valueOf("get-environment-variables");
        Lit11 = Symbol.valueOf("get-environment-variable");
        Lit10 = Symbol.valueOf("process-command-line-assignments");
        Lit9 = Symbol.valueOf("compile-file");
        Lit8 = Symbol.valueOf("tokenize-string-using-shell");
        Lit7 = Symbol.valueOf("tokenize-string-to-string-array");
        Lit6 = Symbol.valueOf("convert-list-to-string-array");
        Lit5 = Symbol.valueOf("convert-vector-to-string-array");
        Lit4 = Symbol.valueOf("system");
        Lit3 = Symbol.valueOf("open-input-pipe");
        Lit2 = Symbol.valueOf("make-process");
        Lit1 = Keyword.make("validate-apply");
        Lit0 = IntNum.valueOf(0);
        $instance = new system();
        $Prvt$$string$Mnwith$Mndelimiter$Mnmarks$ = StaticFieldLocation.make("kawa.lib.syntax", "$string$Mnwith$Mndelimiter$Mnmarks$");
        system system2 = $instance;
        make$Mnprocess = new ModuleMethod(system2, 1, Lit2, 8194);
        open$Mninput$Mnpipe = new ModuleMethod(system2, 2, Lit3, 4097);
        system = new ModuleMethod(system2, 3, Lit4, 4097);
        convert$Mnvector$Mnto$Mnstring$Mnarray = new ModuleMethod(system2, 4, Lit5, 4097);
        convert$Mnlist$Mnto$Mnstring$Mnarray = new ModuleMethod(system2, 5, Lit6, 4097);
        tokenize$Mnstring$Mnto$Mnstring$Mnarray = new ModuleMethod(system2, 6, Lit7, 4097);
        tokenize$Mnstring$Mnusing$Mnshell = new ModuleMethod(system2, 7, Lit8, 4097);
        compile$Mnfile = new ModuleMethod(system2, 8, Lit9, 8194);
        process$Mncommand$Mnline$Mnassignments = new ModuleMethod(system2, 9, Lit10, 0);
        get$Mnenvironment$Mnvariable = new ModuleMethod(system2, 10, Lit11, 4097);
        get$Mnenvironment$Mnvariables = new ModuleMethod(system2, 11, Lit12, 0);
        current$Mnsecond = new ModuleMethod(system2, 12, Lit13, 0);
        current$Mnjiffy = new ModuleMethod(system2, 13, Lit14, 0);
        jiffies$Mnper$Mnsecond = new ModuleMethod(system2, 14, Lit15, 0);
        cmd = Macro.make(Lit16, Lit17, "kawa.lib.system");
        sh = Macro.make(Lit18, Lit19, "kawa.lib.system");
        run$Mnprocess$Mnusing$Mnsh = Macro.make(Lit20, Lit21, "kawa.lib.system");
        pipe$Mnprocess = Macro.make(Lit22, Lit23, "kawa.lib.system");
        GenericProc genericProc = new GenericProc("%pipe-process");
        system $instance = system.$instance;
        ModuleMethod moduleMethod = new ModuleMethod($instance, 15, null, 8194);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/system.scm:142");
        genericProc.add(moduleMethod);
        $Pcpipe$Mnprocess = genericProc;
        process$Mnexit$Mnwait = new ModuleMethod(system2, 16, Lit24, 4097);
        process$Mnexit$Mnok$Qu = new ModuleMethod(system2, 17, Lit25, 4097);
        system.$runBody$();
    }

    public system() {
        ModuleInfo.register(this);
    }

    public static RuntimeException lambda1(Object e1, Object e2) {
        return new RuntimeException("%pipe-process called");
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 14: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 13: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 12: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 11: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 9: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 17: {
                Object object3 = Promise.force(object2, Process.class);
                if (!(object3 instanceof Process)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                Object object4 = Promise.force(object2, Process.class);
                if (!(object4 instanceof Process)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 7: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
                callContext.value1 = Promise.force(object2, String.class);
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 15: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 8: {
                Object object4 = Promise.force(object2, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = Promise.force(object3, String.class);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 9: {
                system.processCommandLineAssignments();
                return Values.empty;
            }
            case 11: {
                return system.getEnvironmentVariables();
            }
            case 12: {
                return system.currentSecond();
            }
            case 13: {
                return system.currentJiffy();
            }
            case 14: {
                return system.jiffiesPerSecond();
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
            case 2: {
                return system.openInputPipe(object2);
            }
            case 3: {
                return system.system(object2);
            }
            case 4: {
                return system.convertVectorToStringArray(object2);
            }
            case 5: {
                return system.convertListToStringArray(object2);
            }
            case 6: {
                String string;
                Object object3 = Promise.force(object2, String.class);
                if (object3 == null) {
                    string = null;
                    return system.tokenizeStringToStringArray(string);
                }
                string = object3.toString();
                return system.tokenizeStringToStringArray(string);
            }
            case 7: {
                return system.tokenizeStringUsingShell(object2);
            }
            case 10: {
                return system.getEnvironmentVariable((CharSequence)Promise.force(object2, CharSequence.class));
            }
            case 16: {
                return system.processExitWait((Process)Promise.force(object2, Process.class));
            }
            case 17: {
                Boolean bl;
                if (system.isProcessExitOk((Process)Promise.force(object2, Process.class))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "get-environment-variable", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "process-exit-wait", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "process-exit-ok?", 1, object2);
        }
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 1: {
                return system.makeProcess(object2, object3);
            }
            case 8: {
                Object object4 = Promise.force(object3, String.class);
                {
                    system.compileFile((CharSequence)Promise.force(object2, CharSequence.class), (String)(object4 == null ? null : object4.toString()));
                }
                return Values.empty;
            }
            case 15: {
                return system.lambda1(object2, object3);
            }
        }
        return super.apply2(moduleMethod, object2, object3);
    }
}

