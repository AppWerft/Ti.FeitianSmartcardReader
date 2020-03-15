// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.mapping.Procedure;
import kawa.lib.misc;
import gnu.expr.KawaConvert;
import kawa.standard.Scheme;
import gnu.lists.EmptyList;
import kawa.lib.lists;
import gnu.lists.LList;
import java.util.regex.Matcher;
import gnu.mapping.WrongType;
import gnu.mapping.Promise;
import java.util.regex.Pattern;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class regex extends ModuleBody
{
    public static final ModuleMethod regex$Mnquote;
    public static final ModuleMethod regex$Mnmatch$Qu;
    public static final ModuleMethod regex$Mnmatch;
    public static final ModuleMethod regex$Mnmatch$Mnpositions;
    public static final ModuleMethod regex$Mnsplit;
    public static final ModuleMethod regex$Mnreplace;
    public static final ModuleMethod regex$Mnreplace$St;
    public static regex $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static String regexQuote(final CharSequence str) {
        return Pattern.quote((str == null) ? null : str.toString());
    }
    
    public static boolean isRegexMatch(final Object o, final CharSequence charSequence) {
        return isRegexMatch(o, charSequence, 0);
    }
    
    public static boolean isRegexMatch(final Object re, final CharSequence str, final int start) {
        return isRegexMatch(re, str, start, str.length());
    }
    
    public static boolean isRegexMatch(final Object re, final CharSequence str, final int start, final int end) {
        Label_0022: {
            if (!(re instanceof Pattern)) {
                break Label_0022;
            }
            final Object force = Promise.force(re, Pattern.class);
            try {
                Pattern compile = (Pattern)force;
                while (true) {
                    final Pattern rex = compile;
                    final Matcher matcher = rex.matcher(str);
                    matcher.region(start, end);
                    return matcher.find();
                    compile = Pattern.compile(re.toString());
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "rex", -2, force);
            }
        }
    }
    
    public static Object regexMatch(final Object o, final CharSequence charSequence) {
        return regexMatch(o, charSequence, 0);
    }
    
    public static Object regexMatch(final Object re, final CharSequence str, final int start) {
        return regexMatch(re, str, start, str.length());
    }
    
    public static Object regexMatch(final Object re, final CharSequence str, final int start, final int end) {
        Label_0022: {
            if (!(re instanceof Pattern)) {
                break Label_0022;
            }
            final Object force = Promise.force(re, Pattern.class);
            try {
                Pattern compile = (Pattern)force;
                while (true) {
                    final Pattern rex = compile;
                    final Matcher matcher = rex.matcher(str);
                    matcher.region(start, end);
                    Object false;
                    if (matcher.find()) {
                        final int groupCount = matcher.groupCount();
                        final EmptyList empty = LList.Empty;
                        Object r = null;
                        for (int igroup = groupCount; igroup >= 0; --igroup) {
                            final int start2 = matcher.start(igroup);
                            r = lists.cons((start2 < 0) ? Boolean.FALSE : str.subSequence(start2, matcher.end(igroup)), r);
                        }
                        false = r;
                    }
                    else {
                        false = Boolean.FALSE;
                    }
                    return false;
                    compile = Pattern.compile(re.toString());
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "rex", -2, force);
            }
        }
    }
    
    public static Object regexMatchPositions(final Object o, final CharSequence charSequence) {
        return regexMatchPositions(o, charSequence, 0);
    }
    
    public static Object regexMatchPositions(final Object re, final CharSequence str, final int start) {
        return regexMatchPositions(re, str, start, str.length());
    }
    
    public static Object regexMatchPositions(final Object re, final CharSequence str, final int start, final int end) {
        Label_0022: {
            if (!(re instanceof Pattern)) {
                break Label_0022;
            }
            final Object force = Promise.force(re, Pattern.class);
            try {
                Pattern compile = (Pattern)force;
                while (true) {
                    final Pattern rex = compile;
                    final Matcher matcher = rex.matcher(str);
                    matcher.region(start, end);
                    Object false;
                    if (matcher.find()) {
                        final int groupCount = matcher.groupCount();
                        final EmptyList empty = LList.Empty;
                        Object r = null;
                        for (int igroup = groupCount; igroup >= 0; --igroup) {
                            final int start2 = matcher.start(igroup);
                            r = lists.cons((start2 < 0) ? Boolean.FALSE : lists.cons(start2, matcher.end(igroup)), r);
                        }
                        false = r;
                    }
                    else {
                        false = Boolean.FALSE;
                    }
                    return false;
                    compile = Pattern.compile(re.toString());
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "rex", -2, force);
            }
        }
    }
    
    public static Object regexSplit(final Object re, final CharSequence str) {
        Label_0021: {
            if (!(re instanceof Pattern)) {
                break Label_0021;
            }
            final Object force = Promise.force(re, Pattern.class);
            try {
                Pattern compile = (Pattern)force;
                while (true) {
                    final Pattern rex = compile;
                    final String[] parts = rex.split(str, -1);
                    final int plen = parts.length;
                    final LList rlist = LList.makeList(parts, 0);
                    return (plen > 1 && KawaConvert.isTrue(Scheme.isEqual.apply2(parts[plen - 1], "")) && !KawaConvert.isTrue(Scheme.isEqual.apply2(parts[0], "")) && rex.matcher("").matches()) ? lists.cons("", rlist) : rlist;
                    compile = Pattern.compile(re.toString());
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "rex", -2, force);
            }
        }
    }
    
    public static CharSequence regexReplace(final Object re, final CharSequence str, final Object repl) {
        Label_0022: {
            if (!(re instanceof Pattern)) {
                break Label_0022;
            }
            final Object force = Promise.force(re, Pattern.class);
            try {
                Pattern compile = (Pattern)force;
                while (true) {
                    final Pattern rex = compile;
                    final Matcher matcher = rex.matcher(str);
                    CharSequence string;
                    if (matcher.find()) {
                        final StringBuffer sbuf = new StringBuffer();
                        final Matcher matcher2 = matcher;
                        final StringBuffer sb = sbuf;
                        String quoteReplacement;
                        if (misc.isProcedure(repl)) {
                            final Object force2 = Promise.force(Scheme.applyToArgs.apply2(repl, matcher.group()), String.class);
                            quoteReplacement = Matcher.quoteReplacement((force2 == null) ? null : force2.toString());
                        }
                        else {
                            final Object force3 = Promise.force(repl, String.class);
                            quoteReplacement = ((force3 == null) ? null : force3.toString());
                        }
                        matcher2.appendReplacement(sb, quoteReplacement);
                        matcher.appendTail(sbuf);
                        string = sbuf.toString();
                    }
                    else {
                        string = str;
                    }
                    return string;
                    compile = Pattern.compile(re.toString());
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "rex", -2, force);
            }
        }
    }
    
    public static CharSequence regexReplace$St(final Object re, final CharSequence str, final Object repl) {
        public class regex$frame extends ModuleBody
        {
            Procedure loop;
            Object repl;
            StringBuffer sbuf;
            Matcher matcher;
            
            public regex$frame() {
                this.loop = new ModuleMethod(this, 1, "loop", 0);
            }
            
            public String lambda1loop() {
                if (this.matcher.find()) {
                    final Matcher matcher = this.matcher;
                    final StringBuffer sbuf = this.sbuf;
                    final Object force = Promise.force(Scheme.applyToArgs.apply2(this.repl, this.matcher.group()), String.class);
                    matcher.appendReplacement(sbuf, Matcher.quoteReplacement((force == null) ? null : force.toString()));
                }
                this.matcher.appendTail(this.sbuf);
                return this.sbuf.toString();
            }
            
            @Override
            public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
                if (moduleMethod.selector == 1) {
                    ctx.proc = moduleMethod;
                    return ctx.pc = 0;
                }
                return super.match0(moduleMethod, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply0(final ModuleMethod method) {
                if (method.selector == 1) {
                    return this.lambda1loop();
                }
                return super.apply0(method);
            }
        }
        final regex$frame $heapFrame = new regex$frame();
        $heapFrame.repl = repl;
        Label_0035: {
            if (!(re instanceof Pattern)) {
                break Label_0035;
            }
            final Object force = Promise.force(re, Pattern.class);
            try {
                Pattern compile = (Pattern)force;
                while (true) {
                    final Pattern rex = compile;
                    $heapFrame.matcher = rex.matcher(str);
                    $heapFrame.sbuf = new StringBuffer();
                    String s;
                    if (misc.isProcedure($heapFrame.repl)) {
                        $heapFrame.loop = $heapFrame.loop;
                        s = $heapFrame.lambda1loop();
                    }
                    else {
                        final Matcher matcher = $heapFrame.matcher;
                        final Object force2 = Promise.force($heapFrame.repl, String.class);
                        s = matcher.replaceAll((force2 == null) ? null : force2.toString());
                    }
                    return s;
                    compile = Pattern.compile(re.toString());
                    continue;
                }
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "rex", -2, force);
            }
        }
    }
    
    static {
        Lit6 = Symbol.valueOf("regex-replace*");
        Lit5 = Symbol.valueOf("regex-replace");
        Lit4 = Symbol.valueOf("regex-split");
        Lit3 = Symbol.valueOf("regex-match-positions");
        Lit2 = Symbol.valueOf("regex-match");
        Lit1 = Symbol.valueOf("regex-match?");
        Lit0 = Symbol.valueOf("regex-quote");
        regex.$instance = new regex();
        final regex $instance = regex.$instance;
        regex$Mnquote = new ModuleMethod($instance, 2, regex.Lit0, 4097);
        regex$Mnmatch$Qu = new ModuleMethod($instance, 3, regex.Lit1, 16386);
        regex$Mnmatch = new ModuleMethod($instance, 6, regex.Lit2, 16386);
        regex$Mnmatch$Mnpositions = new ModuleMethod($instance, 9, regex.Lit3, 16386);
        regex$Mnsplit = new ModuleMethod($instance, 12, regex.Lit4, 8194);
        regex$Mnreplace = new ModuleMethod($instance, 13, regex.Lit5, 12291);
        regex$Mnreplace$St = new ModuleMethod($instance, 14, regex.Lit6, 12291);
        $runBody$();
    }
    
    public regex() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        if (moduleMethod.selector != 2) {
            return super.match1(moduleMethod, o, ctx);
        }
        final Object force = Promise.force(o, CharSequence.class);
        if (force instanceof CharSequence) {
            ctx.value1 = force;
            ctx.proc = moduleMethod;
            ctx.pc = 1;
            return 0;
        }
        return -786431;
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 12: {
                ctx.value1 = arg1;
                final Object force = Promise.force(arg2, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value2 = force;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 9: {
                ctx.value1 = arg1;
                final Object force2 = Promise.force(arg2, CharSequence.class);
                if (force2 instanceof CharSequence) {
                    ctx.value2 = force2;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 6: {
                ctx.value1 = arg1;
                final Object force3 = Promise.force(arg2, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value2 = force3;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 3: {
                ctx.value1 = arg1;
                final Object force4 = Promise.force(arg2, CharSequence.class);
                if (force4 instanceof CharSequence) {
                    ctx.value2 = force4;
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
            case 14: {
                ctx.value1 = o;
                final Object force = Promise.force(o2, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value2 = force;
                    ctx.value3 = o3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 13: {
                ctx.value1 = o;
                final Object force2 = Promise.force(o2, CharSequence.class);
                if (force2 instanceof CharSequence) {
                    ctx.value2 = force2;
                    ctx.value3 = o3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 9: {
                ctx.value1 = o;
                final Object force3 = Promise.force(o2, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value2 = force3;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 6: {
                ctx.value1 = o;
                final Object force4 = Promise.force(o2, CharSequence.class);
                if (force4 instanceof CharSequence) {
                    ctx.value2 = force4;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 3: {
                ctx.value1 = o;
                final Object force5 = Promise.force(o2, CharSequence.class);
                if (force5 instanceof CharSequence) {
                    ctx.value2 = force5;
                    ctx.value3 = Promise.force(o3);
                    ctx.proc = moduleMethod;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 9: {
                ctx.value1 = o;
                final Object force = Promise.force(o2, CharSequence.class);
                if (force instanceof CharSequence) {
                    ctx.value2 = force;
                    ctx.value3 = Promise.force(o3);
                    ctx.value4 = Promise.force(o4);
                    ctx.proc = moduleMethod;
                    ctx.pc = 4;
                    return 0;
                }
                return -786430;
            }
            case 6: {
                ctx.value1 = o;
                final Object force2 = Promise.force(o2, CharSequence.class);
                if (force2 instanceof CharSequence) {
                    ctx.value2 = force2;
                    ctx.value3 = Promise.force(o3);
                    ctx.value4 = Promise.force(o4);
                    ctx.proc = moduleMethod;
                    ctx.pc = 4;
                    return 0;
                }
                return -786430;
            }
            case 3: {
                ctx.value1 = o;
                final Object force3 = Promise.force(o2, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value2 = force3;
                    ctx.value3 = Promise.force(o3);
                    ctx.value4 = Promise.force(o4);
                    ctx.proc = moduleMethod;
                    ctx.pc = 4;
                    return 0;
                }
                return -786430;
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
    public Object apply1(final ModuleMethod method, final Object argValue) {
        Label_0024: {
            if (method.selector != 2) {
                break Label_0024;
            }
            final Object force = Promise.force(argValue, CharSequence.class);
            try {
                return regexQuote((CharSequence)force);
                return super.apply1(method, argValue);
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "regex-quote", 1, argValue);
            }
        }
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
        //                3: 48
        //                6: 74
        //                9: 88
        //               12: 102
        //          default: 116
        //        }
        //    48: aload_2        
        //    49: aload_3        
        //    50: ldc             Ljava/lang/CharSequence;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: checkcast       Ljava/lang/CharSequence;
        //    58: invokestatic    kawa/lib/kawa/regex.isRegexMatch:(Ljava/lang/Object;Ljava/lang/CharSequence;)Z
        //    61: ifeq            70
        //    64: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    67: goto            73
        //    70: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    73: areturn        
        //    74: aload_2        
        //    75: aload_3        
        //    76: ldc             Ljava/lang/CharSequence;.class
        //    78: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    81: checkcast       Ljava/lang/CharSequence;
        //    84: invokestatic    kawa/lib/kawa/regex.regexMatch:(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/Object;
        //    87: areturn        
        //    88: aload_2        
        //    89: aload_3        
        //    90: ldc             Ljava/lang/CharSequence;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: checkcast       Ljava/lang/CharSequence;
        //    98: invokestatic    kawa/lib/kawa/regex.regexMatchPositions:(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   101: areturn        
        //   102: aload_2        
        //   103: aload_3        
        //   104: ldc             Ljava/lang/CharSequence;.class
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   109: checkcast       Ljava/lang/CharSequence;
        //   112: invokestatic    kawa/lib/kawa/regex.regexSplit:(Ljava/lang/Object;Ljava/lang/CharSequence;)Ljava/lang/Object;
        //   115: areturn        
        //   116: aload_0        
        //   117: aload_1        
        //   118: aload_2        
        //   119: aload_3        
        //   120: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   123: areturn        
        //   124: new             Lgnu/mapping/WrongType;
        //   127: dup_x1         
        //   128: swap           
        //   129: ldc_w           "regex-match?"
        //   132: iconst_2       
        //   133: aload_3        
        //   134: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   137: athrow         
        //   138: new             Lgnu/mapping/WrongType;
        //   141: dup_x1         
        //   142: swap           
        //   143: ldc_w           "regex-match"
        //   146: iconst_2       
        //   147: aload_3        
        //   148: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   151: athrow         
        //   152: new             Lgnu/mapping/WrongType;
        //   155: dup_x1         
        //   156: swap           
        //   157: ldc_w           "regex-match-positions"
        //   160: iconst_2       
        //   161: aload_3        
        //   162: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   165: athrow         
        //   166: new             Lgnu/mapping/WrongType;
        //   169: dup_x1         
        //   170: swap           
        //   171: ldc_w           "regex-split"
        //   174: iconst_2       
        //   175: aload_3        
        //   176: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   179: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  55     58     124    138    Ljava/lang/ClassCastException;
        //  81     84     138    152    Ljava/lang/ClassCastException;
        //  95     98     152    166    Ljava/lang/ClassCastException;
        //  109    112    166    180    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 73 out of bounds for length 73
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
        //                3: 56
        //                6: 93
        //                9: 118
        //               13: 143
        //               14: 159
        //          default: 175
        //        }
        //    56: aload_2        
        //    57: aload_3        
        //    58: ldc             Ljava/lang/CharSequence;.class
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    63: checkcast       Ljava/lang/CharSequence;
        //    66: aload           4
        //    68: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    71: checkcast       Ljava/lang/Number;
        //    74: invokevirtual   java/lang/Number.intValue:()I
        //    77: invokestatic    kawa/lib/kawa/regex.isRegexMatch:(Ljava/lang/Object;Ljava/lang/CharSequence;I)Z
        //    80: ifeq            89
        //    83: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    86: goto            92
        //    89: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    92: areturn        
        //    93: aload_2        
        //    94: aload_3        
        //    95: ldc             Ljava/lang/CharSequence;.class
        //    97: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   100: checkcast       Ljava/lang/CharSequence;
        //   103: aload           4
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   108: checkcast       Ljava/lang/Number;
        //   111: invokevirtual   java/lang/Number.intValue:()I
        //   114: invokestatic    kawa/lib/kawa/regex.regexMatch:(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;
        //   117: areturn        
        //   118: aload_2        
        //   119: aload_3        
        //   120: ldc             Ljava/lang/CharSequence;.class
        //   122: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   125: checkcast       Ljava/lang/CharSequence;
        //   128: aload           4
        //   130: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   133: checkcast       Ljava/lang/Number;
        //   136: invokevirtual   java/lang/Number.intValue:()I
        //   139: invokestatic    kawa/lib/kawa/regex.regexMatchPositions:(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;
        //   142: areturn        
        //   143: aload_2        
        //   144: aload_3        
        //   145: ldc             Ljava/lang/CharSequence;.class
        //   147: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   150: checkcast       Ljava/lang/CharSequence;
        //   153: aload           4
        //   155: invokestatic    kawa/lib/kawa/regex.regexReplace:(Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   158: areturn        
        //   159: aload_2        
        //   160: aload_3        
        //   161: ldc             Ljava/lang/CharSequence;.class
        //   163: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   166: checkcast       Ljava/lang/CharSequence;
        //   169: aload           4
        //   171: invokestatic    kawa/lib/kawa/regex.regexReplace$St:(Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/Object;)Ljava/lang/CharSequence;
        //   174: areturn        
        //   175: aload_0        
        //   176: aload_1        
        //   177: aload_2        
        //   178: aload_3        
        //   179: aload           4
        //   181: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   184: areturn        
        //   185: new             Lgnu/mapping/WrongType;
        //   188: dup_x1         
        //   189: swap           
        //   190: ldc_w           "regex-match?"
        //   193: iconst_2       
        //   194: aload_3        
        //   195: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   198: athrow         
        //   199: new             Lgnu/mapping/WrongType;
        //   202: dup_x1         
        //   203: swap           
        //   204: ldc_w           "regex-match?"
        //   207: iconst_3       
        //   208: aload           4
        //   210: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   213: athrow         
        //   214: new             Lgnu/mapping/WrongType;
        //   217: dup_x1         
        //   218: swap           
        //   219: ldc_w           "regex-match"
        //   222: iconst_2       
        //   223: aload_3        
        //   224: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   227: athrow         
        //   228: new             Lgnu/mapping/WrongType;
        //   231: dup_x1         
        //   232: swap           
        //   233: ldc_w           "regex-match"
        //   236: iconst_3       
        //   237: aload           4
        //   239: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   242: athrow         
        //   243: new             Lgnu/mapping/WrongType;
        //   246: dup_x1         
        //   247: swap           
        //   248: ldc_w           "regex-match-positions"
        //   251: iconst_2       
        //   252: aload_3        
        //   253: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   256: athrow         
        //   257: new             Lgnu/mapping/WrongType;
        //   260: dup_x1         
        //   261: swap           
        //   262: ldc_w           "regex-match-positions"
        //   265: iconst_3       
        //   266: aload           4
        //   268: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   271: athrow         
        //   272: new             Lgnu/mapping/WrongType;
        //   275: dup_x1         
        //   276: swap           
        //   277: ldc_w           "regex-replace"
        //   280: iconst_2       
        //   281: aload_3        
        //   282: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   285: athrow         
        //   286: new             Lgnu/mapping/WrongType;
        //   289: dup_x1         
        //   290: swap           
        //   291: ldc_w           "regex-replace*"
        //   294: iconst_2       
        //   295: aload_3        
        //   296: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   299: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  63     66     185    199    Ljava/lang/ClassCastException;
        //  71     77     199    214    Ljava/lang/ClassCastException;
        //  100    103    214    228    Ljava/lang/ClassCastException;
        //  108    114    228    243    Ljava/lang/ClassCastException;
        //  125    128    243    257    Ljava/lang/ClassCastException;
        //  133    139    257    272    Ljava/lang/ClassCastException;
        //  150    153    272    286    Ljava/lang/ClassCastException;
        //  166    169    286    300    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 127 out of bounds for length 127
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
        //     4: tableswitch {
        //                6: 48
        //                7: 168
        //                8: 168
        //                9: 96
        //               10: 168
        //               11: 168
        //               12: 132
        //          default: 168
        //        }
        //    48: aload_2        
        //    49: aload_3        
        //    50: ldc             Ljava/lang/CharSequence;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: checkcast       Ljava/lang/CharSequence;
        //    58: aload           4
        //    60: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    63: checkcast       Ljava/lang/Number;
        //    66: invokevirtual   java/lang/Number.intValue:()I
        //    69: aload           5
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    74: checkcast       Ljava/lang/Number;
        //    77: invokevirtual   java/lang/Number.intValue:()I
        //    80: invokestatic    kawa/lib/kawa/regex.isRegexMatch:(Ljava/lang/Object;Ljava/lang/CharSequence;II)Z
        //    83: ifeq            92
        //    86: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    89: goto            95
        //    92: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    95: areturn        
        //    96: aload_2        
        //    97: aload_3        
        //    98: ldc             Ljava/lang/CharSequence;.class
        //   100: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   103: checkcast       Ljava/lang/CharSequence;
        //   106: aload           4
        //   108: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   111: checkcast       Ljava/lang/Number;
        //   114: invokevirtual   java/lang/Number.intValue:()I
        //   117: aload           5
        //   119: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   122: checkcast       Ljava/lang/Number;
        //   125: invokevirtual   java/lang/Number.intValue:()I
        //   128: invokestatic    kawa/lib/kawa/regex.regexMatch:(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
        //   131: areturn        
        //   132: aload_2        
        //   133: aload_3        
        //   134: ldc             Ljava/lang/CharSequence;.class
        //   136: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   139: checkcast       Ljava/lang/CharSequence;
        //   142: aload           4
        //   144: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   147: checkcast       Ljava/lang/Number;
        //   150: invokevirtual   java/lang/Number.intValue:()I
        //   153: aload           5
        //   155: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   158: checkcast       Ljava/lang/Number;
        //   161: invokevirtual   java/lang/Number.intValue:()I
        //   164: invokestatic    kawa/lib/kawa/regex.regexMatchPositions:(Ljava/lang/Object;Ljava/lang/CharSequence;II)Ljava/lang/Object;
        //   167: areturn        
        //   168: aload_0        
        //   169: aload_1        
        //   170: aload_2        
        //   171: aload_3        
        //   172: aload           4
        //   174: aload           5
        //   176: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   179: areturn        
        //   180: new             Lgnu/mapping/WrongType;
        //   183: dup_x1         
        //   184: swap           
        //   185: ldc_w           "regex-match?"
        //   188: iconst_2       
        //   189: aload_3        
        //   190: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   193: athrow         
        //   194: new             Lgnu/mapping/WrongType;
        //   197: dup_x1         
        //   198: swap           
        //   199: ldc_w           "regex-match?"
        //   202: iconst_3       
        //   203: aload           4
        //   205: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   208: athrow         
        //   209: new             Lgnu/mapping/WrongType;
        //   212: dup_x1         
        //   213: swap           
        //   214: ldc_w           "regex-match?"
        //   217: iconst_4       
        //   218: aload           5
        //   220: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   223: athrow         
        //   224: new             Lgnu/mapping/WrongType;
        //   227: dup_x1         
        //   228: swap           
        //   229: ldc_w           "regex-match"
        //   232: iconst_2       
        //   233: aload_3        
        //   234: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   237: athrow         
        //   238: new             Lgnu/mapping/WrongType;
        //   241: dup_x1         
        //   242: swap           
        //   243: ldc_w           "regex-match"
        //   246: iconst_3       
        //   247: aload           4
        //   249: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   252: athrow         
        //   253: new             Lgnu/mapping/WrongType;
        //   256: dup_x1         
        //   257: swap           
        //   258: ldc_w           "regex-match"
        //   261: iconst_4       
        //   262: aload           5
        //   264: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   267: athrow         
        //   268: new             Lgnu/mapping/WrongType;
        //   271: dup_x1         
        //   272: swap           
        //   273: ldc_w           "regex-match-positions"
        //   276: iconst_2       
        //   277: aload_3        
        //   278: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   281: athrow         
        //   282: new             Lgnu/mapping/WrongType;
        //   285: dup_x1         
        //   286: swap           
        //   287: ldc_w           "regex-match-positions"
        //   290: iconst_3       
        //   291: aload           4
        //   293: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   296: athrow         
        //   297: new             Lgnu/mapping/WrongType;
        //   300: dup_x1         
        //   301: swap           
        //   302: ldc_w           "regex-match-positions"
        //   305: iconst_4       
        //   306: aload           5
        //   308: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   311: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  55     58     180    194    Ljava/lang/ClassCastException;
        //  63     69     194    209    Ljava/lang/ClassCastException;
        //  74     80     209    224    Ljava/lang/ClassCastException;
        //  103    106    224    238    Ljava/lang/ClassCastException;
        //  111    117    238    253    Ljava/lang/ClassCastException;
        //  122    128    253    268    Ljava/lang/ClassCastException;
        //  139    142    268    282    Ljava/lang/ClassCastException;
        //  147    153    282    297    Ljava/lang/ClassCastException;
        //  158    164    297    312    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 132 out of bounds for length 132
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
}
