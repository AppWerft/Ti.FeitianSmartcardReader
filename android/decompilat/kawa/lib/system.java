// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.mapping.Values;
import gnu.expr.ModuleInfo;
import gnu.mapping.MethodProc;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import java.util.Iterator;
import java.util.Map;
import gnu.lists.LList;
import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.text.SyntaxException;
import kawa.lang.CompileFile;
import gnu.text.SourceMessages;
import java.io.InputStream;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import gnu.expr.Special;
import gnu.lists.Consumer;
import gnu.expr.KawaConvert;
import kawa.standard.Scheme;
import gnu.mapping.CallContext;
import gnu.mapping.Namespace;
import kawa.lang.SyntaxRules;
import gnu.mapping.Symbol;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import gnu.math.IntNum;
import gnu.expr.GenericProc;
import gnu.expr.SourceName;
import kawa.lang.Macro;
import gnu.mapping.Procedure;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class system extends ModuleBody
{
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
    @SourceName(name = "cmd", uri = "http://kawa.gnu.org/construct", prefix = "$construct$")
    public static final Macro cmd;
    @SourceName(name = "sh", uri = "http://kawa.gnu.org/construct", prefix = "$construct$")
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        kawa.lib.system.command$Mnparse = (KawaConvert.isTrue(Scheme.isEqual.apply2(System.getProperty("file.separator"), "/")) ? kawa.lib.system.tokenize$Mnstring$Mnusing$Mnshell : kawa.lib.system.tokenize$Mnstring$Mnto$Mnstring$Mnarray);
        kawa.lib.system.$Pcpipe$Mnprocess.setProperty(kawa.lib.system.Lit1, "kawa.lib.compile_misc:pipeProcessValidateApply");
    }
    
    public static Process makeProcess(final Object args, final Object env) {
        Object o;
        if (vectors.isVector(args)) {
            o = convertVectorToStringArray(args);
        }
        else if (lists.isList(args)) {
            o = convertListToStringArray(args);
        }
        else if (strings.isString(args)) {
            o = kawa.lib.system.command$Mnparse.apply1(args);
        }
        else {
            if (!(args instanceof String[])) {
                exceptions.error("invalid arguments to make-process");
                throw Special.reachedUnexpected;
            }
            o = args;
        }
        final Object arargs = o;
        final Runtime runtime2;
        final Runtime runtime = runtime2 = Runtime.getRuntime();
        Object o3;
        final Object o2 = o3 = Promise.force(arargs);
        String[] array;
        Object o4;
        try {
            array = (String[])o2;
            o4 = (o3 = Promise.force(env));
            final String[] array2 = (String[])o4;
            return runtime2.exec(array, array2);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "java.lang.Runtime.exec(java.lang.String[],java.lang.String[])", 2, o3);
        }
        try {
            final String[] array2 = (String[])o4;
            return runtime2.exec(array, array2);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "java.lang.Runtime.exec(java.lang.String[],java.lang.String[])", 3, o3);
        }
    }
    
    public static Object convertVectorToStringArray(final Object vec) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/lists/FVector;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_2       
        //     8: checkcast       Lgnu/lists/FVector;
        //    11: invokestatic    kawa/lib/vectors.vectorLength:(Lgnu/lists/FVector;)I
        //    14: istore_1        /* count */
        //    15: iload_1         /* count */
        //    16: anewarray       Ljava/lang/String;
        //    19: astore_2        /* arr */
        //    20: getstatic       kawa/lib/system.Lit0:Lgnu/math/IntNum;
        //    23: astore_3        /* i */
        //    24: aload_3         /* i */
        //    25: iload_1         /* count */
        //    26: i2l            
        //    27: invokestatic    gnu/math/IntNum.compare:(Lgnu/math/IntNum;J)I
        //    30: ifeq            86
        //    33: aload_2         /* arr */
        //    34: aload_3         /* i */
        //    35: invokevirtual   java/lang/Number.intValue:()I
        //    38: aload_0         /* vec */
        //    39: ldc             Lgnu/lists/FVector;.class
        //    41: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    44: dup            
        //    45: astore          4
        //    47: checkcast       Lgnu/lists/FVector;
        //    50: aload_3         /* i */
        //    51: dup            
        //    52: astore          4
        //    54: invokevirtual   java/lang/Number.intValue:()I
        //    57: invokestatic    kawa/lib/vectors.vectorRef:(Lgnu/lists/FVector;I)Ljava/lang/Object;
        //    60: ldc             Ljava/lang/String;.class
        //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    65: dup            
        //    66: ifnonnull       74
        //    69: pop            
        //    70: aconst_null    
        //    71: goto            77
        //    74: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    77: aastore        
        //    78: aload_3         /* i */
        //    79: iconst_1       
        //    80: invokestatic    gnu/math/IntNum.add:(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
        //    83: goto            23
        //    86: aload_2         /* arr */
        //    87: areturn        
        //    88: new             Lgnu/mapping/WrongType;
        //    91: dup_x1         
        //    92: swap           
        //    93: ldc             "vector-length"
        //    95: iconst_1       
        //    96: aload_2        
        //    97: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   100: athrow         
        //   101: new             Lgnu/mapping/WrongType;
        //   104: dup_x1         
        //   105: swap           
        //   106: ldc             "vector-ref"
        //   108: iconst_1       
        //   109: aload           4
        //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   114: athrow         
        //   115: new             Lgnu/mapping/WrongType;
        //   118: dup_x1         
        //   119: swap           
        //   120: ldc             "vector-ref"
        //   122: iconst_2       
        //   123: aload           4
        //   125: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   128: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     88     101    Ljava/lang/ClassCastException;
        //  47     50     101    115    Ljava/lang/ClassCastException;
        //  54     57     115    129    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 71 out of bounds for length 71
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
    
    public static Object convertListToStringArray(final Object lst) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //     4: istore_1        /* count */
        //     5: iload_1         /* count */
        //     6: anewarray       Ljava/lang/String;
        //     9: astore_2        /* arr */
        //    10: aload_0         /* lst */
        //    11: iconst_0       
        //    12: istore          4
        //    14: astore_3        /* p */
        //    15: aload_3         /* p */
        //    16: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    19: ifeq            26
        //    22: aload_2         /* arr */
        //    23: goto            78
        //    26: aload_3         /* p */
        //    27: ldc             Lgnu/lists/Pair;.class
        //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    32: dup            
        //    33: astore          6
        //    35: checkcast       Lgnu/lists/Pair;
        //    38: astore          pp
        //    40: aload_2         /* arr */
        //    41: iload           i
        //    43: aload           pp
        //    45: invokevirtual   gnu/lists/Pair.getCar:()Ljava/lang/Object;
        //    48: ldc             Ljava/lang/String;.class
        //    50: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    53: dup            
        //    54: ifnonnull       62
        //    57: pop            
        //    58: aconst_null    
        //    59: goto            65
        //    62: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //    65: aastore        
        //    66: aload           pp
        //    68: invokevirtual   gnu/lists/Pair.getCdr:()Ljava/lang/Object;
        //    71: iinc            i, 1
        //    74: astore_3        /* p */
        //    75: goto            15
        //    78: areturn        
        //    79: new             Lgnu/mapping/WrongType;
        //    82: dup_x1         
        //    83: swap           
        //    84: ldc             "pp"
        //    86: bipush          -2
        //    88: aload           6
        //    90: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    93: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  35     38     79     94     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static InputStream openInputPipe(final Object command) {
        return makeProcess(command, null).getInputStream();
    }
    
    public static int system(final Object command) {
        return makeProcess(command, null).waitFor();
    }
    
    public static Object tokenizeStringToStringArray(final String string) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* string */
        //     5: invokespecial   java/util/StringTokenizer.<init>:(Ljava/lang/String;)V
        //     8: astore_1        /* toks */
        //     9: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    12: astore_3        /* list */
        //    13: aload_1         /* toks */
        //    14: invokevirtual   java/util/StringTokenizer.hasMoreTokens:()Z
        //    17: ifeq            31
        //    20: aload_1         /* toks */
        //    21: invokevirtual   java/util/StringTokenizer.nextToken:()Ljava/lang/String;
        //    24: aload_3         /* list */
        //    25: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    28: goto            12
        //    31: aload_3         /* list */
        //    32: astore_2        /* rlist */
        //    33: aload_2         /* rlist */
        //    34: invokestatic    gnu/lists/Sequences.getSize:(Ljava/lang/Object;)I
        //    37: istore_3        /* count */
        //    38: iload_3         /* count */
        //    39: anewarray       Ljava/lang/String;
        //    42: astore          arr
        //    44: aload_2         /* rlist */
        //    45: iload_3         /* count */
        //    46: iconst_1       
        //    47: isub           
        //    48: istore          6
        //    50: astore          p
        //    52: aload           p
        //    54: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    57: ifeq            65
        //    60: aload           arr
        //    62: goto            120
        //    65: aload           p
        //    67: ldc             Lgnu/lists/Pair;.class
        //    69: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    72: dup            
        //    73: astore          8
        //    75: checkcast       Lgnu/lists/Pair;
        //    78: astore          pp
        //    80: aload           arr
        //    82: iload           i
        //    84: aload           pp
        //    86: invokevirtual   gnu/lists/Pair.getCar:()Ljava/lang/Object;
        //    89: ldc             Ljava/lang/String;.class
        //    91: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    94: dup            
        //    95: ifnonnull       103
        //    98: pop            
        //    99: aconst_null    
        //   100: goto            106
        //   103: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   106: aastore        
        //   107: aload           pp
        //   109: invokevirtual   gnu/lists/Pair.getCdr:()Ljava/lang/Object;
        //   112: iinc            i, -1
        //   115: astore          p
        //   117: goto            52
        //   120: areturn        
        //   121: new             Lgnu/mapping/WrongType;
        //   124: dup_x1         
        //   125: swap           
        //   126: ldc             "pp"
        //   128: bipush          -2
        //   130: aload           8
        //   132: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   135: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  75     78     121    136    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static String[] tokenizeStringUsingShell(final Object string) {
        final String[] array;
        final String[] arr = array = new String[] { "/bin/sh", "-c", null };
        final int n = 2;
        final Object force = Promise.force(string, String.class);
        array[n] = ((force == null) ? null : force.toString());
        return arr;
    }
    
    public static void compileFile(final CharSequence source, final String output) {
        final SourceMessages messages = new SourceMessages();
        final Compilation comp = CompileFile.read(source.toString(), messages);
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
    
    public static Object getEnvironmentVariable(final CharSequence name) {
        final String r = System.getenv(name.toString());
        return (r == null) ? Boolean.FALSE : r;
    }
    
    public static Object getEnvironmentVariables() {
        final Iterator it = System.getenv().entrySet().iterator();
        Object o = LList.Empty;
        while (true) {
            final Object r = o;
            if (!it.hasNext()) {
                return r;
            }
            final Object force = Promise.force(it.next(), Map.Entry.class);
            try {
                final Map.Entry e = (Map.Entry)force;
                o = lists.cons(lists.cons(e.getKey(), e.getValue()), r);
                continue;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "e", -2, force);
            }
        }
    }
    
    public static double currentSecond() {
        return System.currentTimeMillis() * 0.001;
    }
    
    public static long currentJiffy() {
        return System.nanoTime();
    }
    
    public static long jiffiesPerSecond() {
        return 1000000000;
    }
    
    public static int processExitWait(final Process process) {
        return process.waitFor();
    }
    
    public static boolean isProcessExitOk(final Process process) {
        return process.waitFor() == 0;
    }
    
    static {
        Lit30 = Namespace.valueOf("http://kawa.gnu.org/construct", "$construct$");
        Lit29 = Symbol.valueOf("$string-with-delimiter-marks$");
        Lit28 = Symbol.valueOf("run-process");
        Lit27 = Symbol.valueOf("%simple-construct-builder");
        Lit26 = new Object[0];
        Lit25 = Symbol.valueOf("process-exit-ok?");
        Lit24 = Symbol.valueOf("process-exit-wait");
        Lit23 = new SyntaxRules(kawa.lib.system.Lit26, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", kawa.lib.system.Lit26, 1, "system.scm:136"), "\u0001", "\u0003", kawa.lib.system.Lit26, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\u0013", kawa.lib.system.Lit26, 3, "system.scm:137"), "\u0001\u0001\u0000", "\u0011\u0018\u00049\u0011\u0018\f\t\u0003\b\u000b\u0012", new Object[] { Lit22 = Symbol.valueOf("pipe-process"), Symbol.valueOf("%pipe-process") }, 0) }, 3, kawa.lib.system.Lit22);
        Lit21 = new SyntaxRules(kawa.lib.system.Lit26, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", kawa.lib.system.Lit26, 1, "system.scm:131"), "\u0000", "\u0011\u0018\u0004\u0011\u0018\f\t\u0014\u0002", new Object[] { kawa.lib.system.Lit28, Keyword.make("shell"), Boolean.TRUE }, 0) }, 1, Lit20 = Symbol.valueOf("run-process-using-sh"));
        Lit19 = new SyntaxRules(kawa.lib.system.Lit26, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", kawa.lib.system.Lit26, 1, "system.scm:128"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", new Object[] { new SyntaxForms.SimpleSyntaxForm(kawa.lib.system.Lit27, TemplateScope.make("kawa.lib.syntax")), kawa.lib.system.Lit20, kawa.lib.system.Lit29 }, 0) }, 1, Lit18 = Symbol.make(kawa.lib.system.Lit30, "sh"));
        Lit17 = new SyntaxRules(kawa.lib.system.Lit26, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", kawa.lib.system.Lit26, 1, "system.scm:127"), "\u0000", "\t\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0010\u0002", new Object[] { new SyntaxForms.SimpleSyntaxForm(kawa.lib.system.Lit27, TemplateScope.make("kawa.lib.syntax")), kawa.lib.system.Lit28, kawa.lib.system.Lit29 }, 0) }, 1, Lit16 = Symbol.make(kawa.lib.system.Lit30, "cmd"));
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
        kawa.lib.system.$instance = new system();
        $Prvt$$string$Mnwith$Mndelimiter$Mnmarks$ = StaticFieldLocation.make("kawa.lib.syntax", "$string$Mnwith$Mndelimiter$Mnmarks$");
        final system $instance2 = kawa.lib.system.$instance;
        make$Mnprocess = new ModuleMethod($instance2, 1, kawa.lib.system.Lit2, 8194);
        open$Mninput$Mnpipe = new ModuleMethod($instance2, 2, kawa.lib.system.Lit3, 4097);
        system = new ModuleMethod($instance2, 3, kawa.lib.system.Lit4, 4097);
        convert$Mnvector$Mnto$Mnstring$Mnarray = new ModuleMethod($instance2, 4, kawa.lib.system.Lit5, 4097);
        convert$Mnlist$Mnto$Mnstring$Mnarray = new ModuleMethod($instance2, 5, kawa.lib.system.Lit6, 4097);
        tokenize$Mnstring$Mnto$Mnstring$Mnarray = new ModuleMethod($instance2, 6, kawa.lib.system.Lit7, 4097);
        tokenize$Mnstring$Mnusing$Mnshell = new ModuleMethod($instance2, 7, kawa.lib.system.Lit8, 4097);
        compile$Mnfile = new ModuleMethod($instance2, 8, kawa.lib.system.Lit9, 8194);
        process$Mncommand$Mnline$Mnassignments = new ModuleMethod($instance2, 9, kawa.lib.system.Lit10, 0);
        get$Mnenvironment$Mnvariable = new ModuleMethod($instance2, 10, kawa.lib.system.Lit11, 4097);
        get$Mnenvironment$Mnvariables = new ModuleMethod($instance2, 11, kawa.lib.system.Lit12, 0);
        current$Mnsecond = new ModuleMethod($instance2, 12, kawa.lib.system.Lit13, 0);
        current$Mnjiffy = new ModuleMethod($instance2, 13, kawa.lib.system.Lit14, 0);
        jiffies$Mnper$Mnsecond = new ModuleMethod($instance2, 14, kawa.lib.system.Lit15, 0);
        cmd = Macro.make(kawa.lib.system.Lit16, kawa.lib.system.Lit17, "kawa.lib.system");
        sh = Macro.make(kawa.lib.system.Lit18, kawa.lib.system.Lit19, "kawa.lib.system");
        run$Mnprocess$Mnusing$Mnsh = Macro.make(kawa.lib.system.Lit20, kawa.lib.system.Lit21, "kawa.lib.system");
        pipe$Mnprocess = Macro.make(kawa.lib.system.Lit22, kawa.lib.system.Lit23, "kawa.lib.system");
        final GenericProc $Pcpipe$Mnprocess2 = new GenericProc("%pipe-process");
        final system $instance = kawa.lib.system.$instance;
        final ModuleMethod method = new ModuleMethod($instance, 15, null, 8194);
        method.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/system.scm:142");
        $Pcpipe$Mnprocess2.add(method);
        $Pcpipe$Mnprocess = $Pcpipe$Mnprocess2;
        process$Mnexit$Mnwait = new ModuleMethod($instance2, 16, kawa.lib.system.Lit24, 4097);
        process$Mnexit$Mnok$Qu = new ModuleMethod($instance2, 17, kawa.lib.system.Lit25, 4097);
        $runBody$();
    }
    
    public system() {
        ModuleInfo.register(this);
    }
    
    public static RuntimeException lambda1(final Object e1, final Object e2) {
        return new RuntimeException("%pipe-process called");
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 14: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 13: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 12: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 11: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 9: {
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
            case 17: {
                final Object force = Promise.force(o, Process.class);
                if (!(force instanceof Process)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 16: {
                final Object force2 = Promise.force(o, Process.class);
                if (!(force2 instanceof Process)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 10: {
                final Object force3 = Promise.force(o, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value1 = force3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 7: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                ctx.value1 = Promise.force(o, String.class);
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 15: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            case 8: {
                final Object force = Promise.force(o, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value1 = force;
                    ctx.value2 = Promise.force(o2, String.class);
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return -786431;
            }
            case 1: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.proc = moduleMethod;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(moduleMethod, o, o2, ctx);
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
            case 9: {
                processCommandLineAssignments();
                return Values.empty;
            }
            case 11: {
                return getEnvironmentVariables();
            }
            case 12: {
                return currentSecond();
            }
            case 13: {
                return currentJiffy();
            }
            case 14: {
                return jiffiesPerSecond();
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
        //                4: 84
        //                5: 89
        //                6: 97
        //                7: 102
        //                8: 107
        //                9: 129
        //               10: 188
        //               11: 188
        //               12: 134
        //               13: 188
        //               14: 188
        //               15: 188
        //               16: 188
        //               17: 188
        //               18: 147
        //               19: 163
        //          default: 188
        //        }
        //    84: aload_2        
        //    85: invokestatic    kawa/lib/system.openInputPipe:(Ljava/lang/Object;)Ljava/io/InputStream;
        //    88: areturn        
        //    89: aload_2        
        //    90: invokestatic    kawa/lib/system.system:(Ljava/lang/Object;)I
        //    93: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    96: areturn        
        //    97: aload_2        
        //    98: invokestatic    kawa/lib/system.convertVectorToStringArray:(Ljava/lang/Object;)Ljava/lang/Object;
        //   101: areturn        
        //   102: aload_2        
        //   103: invokestatic    kawa/lib/system.convertListToStringArray:(Ljava/lang/Object;)Ljava/lang/Object;
        //   106: areturn        
        //   107: aload_2        
        //   108: ldc             Ljava/lang/String;.class
        //   110: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   113: dup            
        //   114: ifnonnull       122
        //   117: pop            
        //   118: aconst_null    
        //   119: goto            125
        //   122: invokevirtual   java/lang/Object.toString:()Ljava/lang/String;
        //   125: invokestatic    kawa/lib/system.tokenizeStringToStringArray:(Ljava/lang/String;)Ljava/lang/Object;
        //   128: areturn        
        //   129: aload_2        
        //   130: invokestatic    kawa/lib/system.tokenizeStringUsingShell:(Ljava/lang/Object;)[Ljava/lang/String;
        //   133: areturn        
        //   134: aload_2        
        //   135: ldc             Ljava/lang/CharSequence;.class
        //   137: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   140: checkcast       Ljava/lang/CharSequence;
        //   143: invokestatic    kawa/lib/system.getEnvironmentVariable:(Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   146: areturn        
        //   147: aload_2        
        //   148: ldc             Ljava/lang/Process;.class
        //   150: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   153: checkcast       Ljava/lang/Process;
        //   156: invokestatic    kawa/lib/system.processExitWait:(Ljava/lang/Process;)I
        //   159: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   162: areturn        
        //   163: aload_2        
        //   164: ldc             Ljava/lang/Process;.class
        //   166: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   169: checkcast       Ljava/lang/Process;
        //   172: invokestatic    kawa/lib/system.isProcessExitOk:(Ljava/lang/Process;)Z
        //   175: ifeq            184
        //   178: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   181: goto            187
        //   184: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   187: areturn        
        //   188: aload_0        
        //   189: aload_1        
        //   190: aload_2        
        //   191: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   194: areturn        
        //   195: new             Lgnu/mapping/WrongType;
        //   198: dup_x1         
        //   199: swap           
        //   200: ldc_w           "get-environment-variable"
        //   203: iconst_1       
        //   204: aload_2        
        //   205: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   208: athrow         
        //   209: new             Lgnu/mapping/WrongType;
        //   212: dup_x1         
        //   213: swap           
        //   214: ldc_w           "process-exit-wait"
        //   217: iconst_1       
        //   218: aload_2        
        //   219: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   222: athrow         
        //   223: new             Lgnu/mapping/WrongType;
        //   226: dup_x1         
        //   227: swap           
        //   228: ldc_w           "process-exit-ok?"
        //   231: iconst_1       
        //   232: aload_2        
        //   233: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   236: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  140    143    195    209    Ljava/lang/ClassCastException;
        //  153    156    209    223    Ljava/lang/ClassCastException;
        //  169    172    223    237    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 82 out of bounds for length 82
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
    public Object apply2(final ModuleMethod method, final Object argValue, final Object o) {
    Label_0080_Outer:
        while (true) {
            while (true) {
                switch (method.selector) {
                    case 1: {
                        return makeProcess(argValue, o);
                    }
                    case 8: {
                        final Object force = Promise.force(argValue, CharSequence.class);
                        try {
                            final CharSequence source = (CharSequence)force;
                            final Object force2 = Promise.force(o, String.class);
                            compileFile(source, (force2 == null) ? null : force2.toString());
                            return Values.empty;
                            return super.apply2(method, argValue, o);
                            return lambda1(argValue, o);
                        }
                        catch (ClassCastException ex) {
                            throw new WrongType(ex, "compile-file", 1, argValue);
                        }
                        break;
                    }
                    case 15: {
                        continue;
                    }
                    default: {
                        continue Label_0080_Outer;
                    }
                }
                break;
            }
            break;
        }
    }
}
