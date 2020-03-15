// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import gnu.text.StringCursor;
import gnu.mapping.Promise;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.text.Char;
import kawa.standard.Scheme;
import kawa.SourceMethodType;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class string-cursors extends ModuleBody
{
    public static final ModuleMethod string$Mncursor$Mnstart;
    public static final ModuleMethod string$Mncursor$Mnend;
    public static final ModuleMethod string$Mncursor$Mnref;
    public static final ModuleMethod substring$Mncursor;
    public static final ModuleMethod string$Mncursor$Mnnext;
    public static final ModuleMethod string$Mncursor$Mnnext$Mnquick;
    public static final ModuleMethod string$Mncursor$Mnprev;
    public static final ModuleMethod string$Mncursor$Ls$Qu;
    public static final ModuleMethod string$Mncursor$Ls$Eq$Qu;
    public static final ModuleMethod string$Mncursor$Eq$Qu;
    public static final ModuleMethod string$Mncursor$Gr$Qu;
    public static final ModuleMethod string$Mncursor$Gr$Eq$Qu;
    public static final StaticFieldLocation string$Mncursor;
    public static final ModuleMethod string$Mncursor$Mnfor$Mneach;
    public static string-cursors $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
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
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    @SourceMethodType({ "string-cursor" })
    public static int stringCursorStart(final CharSequence str) {
        return 0;
    }
    
    @SourceMethodType({ "string-cursor" })
    public static int stringCursorEnd(final CharSequence str) {
        return str.length();
    }
    
    @SourceMethodType({ "character", "", "string-cursor" })
    public static int stringCursorRef(final CharSequence str, final int cursor) {
        final int cursor2 = cursor;
        final int ch1 = str.charAt(cursor2);
        final boolean x = ch1 < 55296;
        Label_0046: {
            if (x) {
                if (!x) {
                    break Label_0046;
                }
            }
            else if (ch1 <= 57343) {
                break Label_0046;
            }
            return ch1;
        }
        int n;
        if (ch1 >= 55296 && ch1 <= 56319) {
            final int ch2 = (cursor2 == str.length()) ? '\0' : str.charAt(cursor2 + 1);
            final boolean x2 = ch2 < 56320;
            n = ((x2 ? x2 : (ch2 > 57343)) ? ch1 : ((ch1 - 55296) * 1024 + (ch2 - 56320) + 65536));
        }
        else {
            final int ch3 = (cursor2 == 0) ? '\0' : str.charAt(cursor2 - 1);
            n = ((ch3 >= 55296 && ch3 <= 56319) ? 2097151 : ch1);
        }
        return n;
    }
    
    @SourceMethodType({ "string-cursor", "", "string-cursor" })
    public static int stringCursorNext(final CharSequence str, final int cursor) {
        return stringCursorNext(str, cursor, 1);
    }
    
    @SourceMethodType({ "string-cursor", "", "string-cursor" })
    public static int stringCursorNext(final CharSequence str, final int cursor, final int count) {
        return Character.offsetByCodePoints(str, cursor, count);
    }
    
    @SourceMethodType({ "string-cursor", "string-cursor" })
    public static int stringCursorNextQuick(final int cursor) {
        return 1 + cursor;
    }
    
    @SourceMethodType({ "string-cursor", "", "string-cursor" })
    public static int stringCursorPrev(final CharSequence str, final int cursor) {
        return stringCursorPrev(str, cursor, 1);
    }
    
    @SourceMethodType({ "string-cursor", "", "string-cursor" })
    public static int stringCursorPrev(final CharSequence str, final int cursor, final int count) {
        return Character.offsetByCodePoints(str, cursor, -count);
    }
    
    @SourceMethodType({ "", "", "string-cursor" })
    public static CharSequence substringCursor(final CharSequence str, final int cs1) {
        return substringCursor(str, cs1, str.length());
    }
    
    @SourceMethodType({ "", "", "string-cursor", "string-cursor" })
    public static CharSequence substringCursor(final CharSequence str, final int cs1, final int cs2) {
        return str.subSequence(cs1, cs2);
    }
    
    @SourceMethodType({ "", "string-cursor", "string-cursor" })
    public static boolean isStringCursor$Ls(final int cs1, final int cs2) {
        return cs1 < cs2;
    }
    
    @SourceMethodType({ "", "string-cursor", "string-cursor" })
    public static boolean isStringCursor$Ls$Eq(final int cs1, final int cs2) {
        return cs1 <= cs2;
    }
    
    @SourceMethodType({ "", "string-cursor", "string-cursor" })
    public static boolean isStringCursor$Eq(final int cs1, final int cs2) {
        return cs1 == cs2;
    }
    
    @SourceMethodType({ "", "string-cursor", "string-cursor" })
    public static boolean isStringCursor$Gr(final int cs1, final int cs2) {
        return cs1 > cs2;
    }
    
    @SourceMethodType({ "", "string-cursor", "string-cursor" })
    public static boolean isStringCursor$Gr$Eq(final int cs1, final int cs2) {
        return cs1 >= cs2;
    }
    
    public static void stringCursorForEach(final Object o, final CharSequence charSequence) {
        stringCursorForEach(o, charSequence, 0);
    }
    
    @SourceMethodType({ "", "", "", "string-cursor" })
    public static void stringCursorForEach(final Object proc, final CharSequence charSequence, final int start) {
        stringCursorForEach(proc, charSequence, start, stringCursorEnd(charSequence));
    }
    
    @SourceMethodType({ "", "", "", "string-cursor", "string-cursor" })
    public static void stringCursorForEach(final Object proc, final CharSequence str, final int start, final int end) {
        int stringCursorNext = start;
        while (true) {
            final int cursor = stringCursorNext;
            if (isStringCursor$Gr$Eq(cursor, end)) {
                break;
            }
            Scheme.applyToArgs.apply2(proc, Char.make(stringCursorRef(str, cursor)));
            stringCursorNext = stringCursorNext(str, cursor);
        }
    }
    
    static {
        Lit12 = Symbol.valueOf("string-cursor-for-each");
        Lit11 = Symbol.valueOf("string-cursor>=?");
        Lit10 = Symbol.valueOf("string-cursor>?");
        Lit9 = Symbol.valueOf("string-cursor=?");
        Lit8 = Symbol.valueOf("string-cursor<=?");
        Lit7 = Symbol.valueOf("string-cursor<?");
        Lit6 = Symbol.valueOf("substring-cursor");
        Lit5 = Symbol.valueOf("string-cursor-prev");
        Lit4 = Symbol.valueOf("string-cursor-next-quick");
        Lit3 = Symbol.valueOf("string-cursor-next");
        Lit2 = Symbol.valueOf("string-cursor-ref");
        Lit1 = Symbol.valueOf("string-cursor-end");
        Lit0 = Symbol.valueOf("string-cursor-start");
        string-cursors.$instance = new string-cursors();
        string$Mncursor = StaticFieldLocation.make("gnu.kawa.lispexpr.LangPrimType", "stringCursorType");
        final string-cursors $instance = string-cursors.$instance;
        string$Mncursor$Mnstart = new ModuleMethod($instance, 1, string-cursors.Lit0, 4097);
        string$Mncursor$Mnend = new ModuleMethod($instance, 2, string-cursors.Lit1, 4097);
        string$Mncursor$Mnref = new ModuleMethod($instance, 3, string-cursors.Lit2, 8194);
        string$Mncursor$Mnnext = new ModuleMethod($instance, 4, string-cursors.Lit3, 12290);
        string$Mncursor$Mnnext$Mnquick = new ModuleMethod($instance, 6, string-cursors.Lit4, 4097);
        string$Mncursor$Mnprev = new ModuleMethod($instance, 7, string-cursors.Lit5, 12290);
        substring$Mncursor = new ModuleMethod($instance, 9, string-cursors.Lit6, 12290);
        final ModuleMethod string$Mncursor$Ls$Qu2 = new ModuleMethod($instance, 11, string-cursors.Lit7, 8194);
        string$Mncursor$Ls$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Ls$Qu = string$Mncursor$Ls$Qu2;
        final ModuleMethod string$Mncursor$Ls$Eq$Qu2 = new ModuleMethod($instance, 12, string-cursors.Lit8, 8194);
        string$Mncursor$Ls$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Ls$Eq$Qu = string$Mncursor$Ls$Eq$Qu2;
        final ModuleMethod string$Mncursor$Eq$Qu2 = new ModuleMethod($instance, 13, string-cursors.Lit9, 8194);
        string$Mncursor$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Eq$Qu = string$Mncursor$Eq$Qu2;
        final ModuleMethod string$Mncursor$Gr$Qu2 = new ModuleMethod($instance, 14, string-cursors.Lit10, 8194);
        string$Mncursor$Gr$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Gr$Qu = string$Mncursor$Gr$Qu2;
        final ModuleMethod string$Mncursor$Gr$Eq$Qu2 = new ModuleMethod($instance, 15, string-cursors.Lit11, 8194);
        string$Mncursor$Gr$Eq$Qu2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Gr$Eq$Qu = string$Mncursor$Gr$Eq$Qu2;
        final ModuleMethod string$Mncursor$Mnfor$Mneach2 = new ModuleMethod($instance, 16, string-cursors.Lit12, 16386);
        string$Mncursor$Mnfor$Mneach2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:stringCursorForEachValidateApply");
        string$Mncursor$Mnfor$Mneach = string$Mncursor$Mnfor$Mneach2;
        $runBody$();
    }
    
    public string-cursors() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 6: {
                final Object force = Promise.force(o);
                if (StringCursor.checkStringCursor(force) >= 0) {
                    ctx.value1 = force;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 2: {
                final Object force2 = Promise.force(o, CharSequence.class);
                if (force2 instanceof CharSequence) {
                    ctx.value1 = force2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            case 1: {
                final Object force3 = Promise.force(o, CharSequence.class);
                if (force3 instanceof CharSequence) {
                    ctx.value1 = force3;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return -786431;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 16: {
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
            case 15: {
                final Object force2 = Promise.force(arg1);
                if (StringCursor.checkStringCursor(force2) < 0) {
                    return -786431;
                }
                ctx.value1 = force2;
                final Object force3 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force3) >= 0) {
                    ctx.value2 = force3;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 14: {
                final Object force4 = Promise.force(arg1);
                if (StringCursor.checkStringCursor(force4) < 0) {
                    return -786431;
                }
                ctx.value1 = force4;
                final Object force5 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force5) >= 0) {
                    ctx.value2 = force5;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 13: {
                final Object force6 = Promise.force(arg1);
                if (StringCursor.checkStringCursor(force6) < 0) {
                    return -786431;
                }
                ctx.value1 = force6;
                final Object force7 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force7) >= 0) {
                    ctx.value2 = force7;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 12: {
                final Object force8 = Promise.force(arg1);
                if (StringCursor.checkStringCursor(force8) < 0) {
                    return -786431;
                }
                ctx.value1 = force8;
                final Object force9 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force9) >= 0) {
                    ctx.value2 = force9;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 11: {
                final Object force10 = Promise.force(arg1);
                if (StringCursor.checkStringCursor(force10) < 0) {
                    return -786431;
                }
                ctx.value1 = force10;
                final Object force11 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force11) >= 0) {
                    ctx.value2 = force11;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 9: {
                final Object force12 = Promise.force(arg1, CharSequence.class);
                if (!(force12 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force12;
                final Object force13 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force13) >= 0) {
                    ctx.value2 = force13;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 7: {
                final Object force14 = Promise.force(arg1, CharSequence.class);
                if (!(force14 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force14;
                final Object force15 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force15) >= 0) {
                    ctx.value2 = force15;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 4: {
                final Object force16 = Promise.force(arg1, CharSequence.class);
                if (!(force16 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force16;
                final Object force17 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force17) >= 0) {
                    ctx.value2 = force17;
                    ctx.proc = proc;
                    ctx.pc = 2;
                    return 0;
                }
                return -786430;
            }
            case 3: {
                final Object force18 = Promise.force(arg1, CharSequence.class);
                if (!(force18 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force18;
                final Object force19 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force19) >= 0) {
                    ctx.value2 = force19;
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
    public int match3(final ModuleMethod proc, final Object arg1, final Object arg2, final Object arg3, final CallContext ctx) {
        switch (proc.selector) {
            case 16: {
                ctx.value1 = arg1;
                final Object force = Promise.force(arg2, CharSequence.class);
                if (!(force instanceof CharSequence)) {
                    return -786430;
                }
                ctx.value2 = force;
                final Object force2 = Promise.force(arg3);
                if (StringCursor.checkStringCursor(force2) >= 0) {
                    ctx.value3 = force2;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 9: {
                final Object force3 = Promise.force(arg1, CharSequence.class);
                if (!(force3 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force3;
                final Object force4 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force4) < 0) {
                    return -786430;
                }
                ctx.value2 = force4;
                final Object force5 = Promise.force(arg3);
                if (StringCursor.checkStringCursor(force5) >= 0) {
                    ctx.value3 = force5;
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786429;
            }
            case 7: {
                final Object force6 = Promise.force(arg1, CharSequence.class);
                if (!(force6 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force6;
                final Object force7 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force7) >= 0) {
                    ctx.value2 = force7;
                    ctx.value3 = Promise.force(arg3);
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            case 4: {
                final Object force8 = Promise.force(arg1, CharSequence.class);
                if (!(force8 instanceof CharSequence)) {
                    return -786431;
                }
                ctx.value1 = force8;
                final Object force9 = Promise.force(arg2);
                if (StringCursor.checkStringCursor(force9) >= 0) {
                    ctx.value2 = force9;
                    ctx.value3 = Promise.force(arg3);
                    ctx.proc = proc;
                    ctx.pc = 3;
                    return 0;
                }
                return -786430;
            }
            default: {
                return super.match3(proc, arg1, arg2, arg3, ctx);
            }
        }
    }
    
    @Override
    public int match4(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final Object o4, final CallContext ctx) {
        if (moduleMethod.selector != 16) {
            return super.match4(moduleMethod, o, o2, o3, o4, ctx);
        }
        ctx.value1 = o;
        final Object force = Promise.force(o2, CharSequence.class);
        if (!(force instanceof CharSequence)) {
            return -786430;
        }
        ctx.value2 = force;
        final Object force2 = Promise.force(o3);
        if (StringCursor.checkStringCursor(force2) < 0) {
            return -786429;
        }
        ctx.value3 = force2;
        final Object force3 = Promise.force(o4);
        if (StringCursor.checkStringCursor(force3) >= 0) {
            ctx.value4 = force3;
            ctx.proc = moduleMethod;
            ctx.pc = 4;
            return 0;
        }
        return -786428;
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
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
        //                2: 44
        //                3: 60
        //                4: 93
        //                5: 93
        //                6: 93
        //                7: 76
        //          default: 93
        //        }
        //    44: aload_2        
        //    45: ldc             Ljava/lang/CharSequence;.class
        //    47: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    50: checkcast       Ljava/lang/CharSequence;
        //    53: invokestatic    kawa/lib/kawa/string-cursors.stringCursorStart:(Ljava/lang/CharSequence;)I
        //    56: invokestatic    gnu/text/StringCursor.valueOf:(I)Lgnu/text/StringCursor;
        //    59: areturn        
        //    60: aload_2        
        //    61: ldc             Ljava/lang/CharSequence;.class
        //    63: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    66: checkcast       Ljava/lang/CharSequence;
        //    69: invokestatic    kawa/lib/kawa/string-cursors.stringCursorEnd:(Ljava/lang/CharSequence;)I
        //    72: invokestatic    gnu/text/StringCursor.valueOf:(I)Lgnu/text/StringCursor;
        //    75: areturn        
        //    76: aload_2        
        //    77: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    80: checkcast       Lgnu/text/StringCursor;
        //    83: invokevirtual   gnu/text/StringCursor.getValue:()I
        //    86: invokestatic    kawa/lib/kawa/string-cursors.stringCursorNextQuick:(I)I
        //    89: invokestatic    gnu/text/StringCursor.valueOf:(I)Lgnu/text/StringCursor;
        //    92: areturn        
        //    93: aload_0        
        //    94: aload_1        
        //    95: aload_2        
        //    96: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //    99: areturn        
        //   100: new             Lgnu/mapping/WrongType;
        //   103: dup_x1         
        //   104: swap           
        //   105: ldc_w           "string-cursor-start"
        //   108: iconst_1       
        //   109: aload_2        
        //   110: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   113: athrow         
        //   114: new             Lgnu/mapping/WrongType;
        //   117: dup_x1         
        //   118: swap           
        //   119: ldc_w           "string-cursor-end"
        //   122: iconst_1       
        //   123: aload_2        
        //   124: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   127: athrow         
        //   128: new             Lgnu/mapping/WrongType;
        //   131: dup_x1         
        //   132: swap           
        //   133: ldc_w           "string-cursor-next-quick"
        //   136: iconst_1       
        //   137: aload_2        
        //   138: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   141: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  50     53     100    114    Ljava/lang/ClassCastException;
        //  66     69     114    128    Ljava/lang/ClassCastException;
        //  80     86     128    142    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 53 out of bounds for length 53
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
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //                6: 76
        //                7: 102
        //                8: 374
        //                9: 374
        //               10: 128
        //               11: 374
        //               12: 154
        //               13: 374
        //               14: 177
        //               15: 213
        //               16: 249
        //               17: 285
        //               18: 321
        //               19: 357
        //          default: 374
        //        }
        //    76: aload_2        
        //    77: ldc             Ljava/lang/CharSequence;.class
        //    79: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    82: checkcast       Ljava/lang/CharSequence;
        //    85: aload_3        
        //    86: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    89: checkcast       Lgnu/text/StringCursor;
        //    92: invokevirtual   gnu/text/StringCursor.getValue:()I
        //    95: invokestatic    kawa/lib/kawa/string-cursors.stringCursorRef:(Ljava/lang/CharSequence;I)I
        //    98: invokestatic    gnu/text/Char.make:(I)Lgnu/text/Char;
        //   101: areturn        
        //   102: aload_2        
        //   103: ldc             Ljava/lang/CharSequence;.class
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   108: checkcast       Ljava/lang/CharSequence;
        //   111: aload_3        
        //   112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   115: checkcast       Lgnu/text/StringCursor;
        //   118: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   121: invokestatic    kawa/lib/kawa/string-cursors.stringCursorNext:(Ljava/lang/CharSequence;I)I
        //   124: invokestatic    gnu/text/StringCursor.valueOf:(I)Lgnu/text/StringCursor;
        //   127: areturn        
        //   128: aload_2        
        //   129: ldc             Ljava/lang/CharSequence;.class
        //   131: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   134: checkcast       Ljava/lang/CharSequence;
        //   137: aload_3        
        //   138: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   141: checkcast       Lgnu/text/StringCursor;
        //   144: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   147: invokestatic    kawa/lib/kawa/string-cursors.stringCursorPrev:(Ljava/lang/CharSequence;I)I
        //   150: invokestatic    gnu/text/StringCursor.valueOf:(I)Lgnu/text/StringCursor;
        //   153: areturn        
        //   154: aload_2        
        //   155: ldc             Ljava/lang/CharSequence;.class
        //   157: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   160: checkcast       Ljava/lang/CharSequence;
        //   163: aload_3        
        //   164: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   167: checkcast       Lgnu/text/StringCursor;
        //   170: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   173: invokestatic    kawa/lib/kawa/string-cursors.substringCursor:(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;
        //   176: areturn        
        //   177: aload_2        
        //   178: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   181: checkcast       Lgnu/text/StringCursor;
        //   184: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   187: aload_3        
        //   188: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   191: checkcast       Lgnu/text/StringCursor;
        //   194: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   197: invokestatic    kawa/lib/kawa/string-cursors.isStringCursor$Ls:(II)Z
        //   200: ifeq            209
        //   203: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   206: goto            212
        //   209: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   212: areturn        
        //   213: aload_2        
        //   214: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   217: checkcast       Lgnu/text/StringCursor;
        //   220: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   223: aload_3        
        //   224: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   227: checkcast       Lgnu/text/StringCursor;
        //   230: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   233: invokestatic    kawa/lib/kawa/string-cursors.isStringCursor$Ls$Eq:(II)Z
        //   236: ifeq            245
        //   239: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   242: goto            248
        //   245: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   248: areturn        
        //   249: aload_2        
        //   250: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   253: checkcast       Lgnu/text/StringCursor;
        //   256: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   259: aload_3        
        //   260: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   263: checkcast       Lgnu/text/StringCursor;
        //   266: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   269: invokestatic    kawa/lib/kawa/string-cursors.isStringCursor$Eq:(II)Z
        //   272: ifeq            281
        //   275: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   278: goto            284
        //   281: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   284: areturn        
        //   285: aload_2        
        //   286: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   289: checkcast       Lgnu/text/StringCursor;
        //   292: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   295: aload_3        
        //   296: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   299: checkcast       Lgnu/text/StringCursor;
        //   302: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   305: invokestatic    kawa/lib/kawa/string-cursors.isStringCursor$Gr:(II)Z
        //   308: ifeq            317
        //   311: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   314: goto            320
        //   317: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   320: areturn        
        //   321: aload_2        
        //   322: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   325: checkcast       Lgnu/text/StringCursor;
        //   328: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   331: aload_3        
        //   332: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   335: checkcast       Lgnu/text/StringCursor;
        //   338: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   341: invokestatic    kawa/lib/kawa/string-cursors.isStringCursor$Gr$Eq:(II)Z
        //   344: ifeq            353
        //   347: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   350: goto            356
        //   353: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   356: areturn        
        //   357: aload_2        
        //   358: aload_3        
        //   359: ldc             Ljava/lang/CharSequence;.class
        //   361: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   364: checkcast       Ljava/lang/CharSequence;
        //   367: invokestatic    kawa/lib/kawa/string-cursors.stringCursorForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;)V
        //   370: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   373: areturn        
        //   374: aload_0        
        //   375: aload_1        
        //   376: aload_2        
        //   377: aload_3        
        //   378: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   381: areturn        
        //   382: new             Lgnu/mapping/WrongType;
        //   385: dup_x1         
        //   386: swap           
        //   387: ldc_w           "string-cursor-ref"
        //   390: iconst_1       
        //   391: aload_2        
        //   392: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   395: athrow         
        //   396: new             Lgnu/mapping/WrongType;
        //   399: dup_x1         
        //   400: swap           
        //   401: ldc_w           "string-cursor-ref"
        //   404: iconst_2       
        //   405: aload_3        
        //   406: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   409: athrow         
        //   410: new             Lgnu/mapping/WrongType;
        //   413: dup_x1         
        //   414: swap           
        //   415: ldc_w           "string-cursor-next"
        //   418: iconst_1       
        //   419: aload_2        
        //   420: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   423: athrow         
        //   424: new             Lgnu/mapping/WrongType;
        //   427: dup_x1         
        //   428: swap           
        //   429: ldc_w           "string-cursor-next"
        //   432: iconst_2       
        //   433: aload_3        
        //   434: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   437: athrow         
        //   438: new             Lgnu/mapping/WrongType;
        //   441: dup_x1         
        //   442: swap           
        //   443: ldc_w           "string-cursor-prev"
        //   446: iconst_1       
        //   447: aload_2        
        //   448: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   451: athrow         
        //   452: new             Lgnu/mapping/WrongType;
        //   455: dup_x1         
        //   456: swap           
        //   457: ldc_w           "string-cursor-prev"
        //   460: iconst_2       
        //   461: aload_3        
        //   462: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   465: athrow         
        //   466: new             Lgnu/mapping/WrongType;
        //   469: dup_x1         
        //   470: swap           
        //   471: ldc_w           "substring-cursor"
        //   474: iconst_1       
        //   475: aload_2        
        //   476: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   479: athrow         
        //   480: new             Lgnu/mapping/WrongType;
        //   483: dup_x1         
        //   484: swap           
        //   485: ldc_w           "substring-cursor"
        //   488: iconst_2       
        //   489: aload_3        
        //   490: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   493: athrow         
        //   494: new             Lgnu/mapping/WrongType;
        //   497: dup_x1         
        //   498: swap           
        //   499: ldc_w           "string-cursor<?"
        //   502: iconst_1       
        //   503: aload_2        
        //   504: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   507: athrow         
        //   508: new             Lgnu/mapping/WrongType;
        //   511: dup_x1         
        //   512: swap           
        //   513: ldc_w           "string-cursor<?"
        //   516: iconst_2       
        //   517: aload_3        
        //   518: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   521: athrow         
        //   522: new             Lgnu/mapping/WrongType;
        //   525: dup_x1         
        //   526: swap           
        //   527: ldc_w           "string-cursor<=?"
        //   530: iconst_1       
        //   531: aload_2        
        //   532: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   535: athrow         
        //   536: new             Lgnu/mapping/WrongType;
        //   539: dup_x1         
        //   540: swap           
        //   541: ldc_w           "string-cursor<=?"
        //   544: iconst_2       
        //   545: aload_3        
        //   546: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   549: athrow         
        //   550: new             Lgnu/mapping/WrongType;
        //   553: dup_x1         
        //   554: swap           
        //   555: ldc_w           "string-cursor=?"
        //   558: iconst_1       
        //   559: aload_2        
        //   560: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   563: athrow         
        //   564: new             Lgnu/mapping/WrongType;
        //   567: dup_x1         
        //   568: swap           
        //   569: ldc_w           "string-cursor=?"
        //   572: iconst_2       
        //   573: aload_3        
        //   574: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   577: athrow         
        //   578: new             Lgnu/mapping/WrongType;
        //   581: dup_x1         
        //   582: swap           
        //   583: ldc_w           "string-cursor>?"
        //   586: iconst_1       
        //   587: aload_2        
        //   588: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   591: athrow         
        //   592: new             Lgnu/mapping/WrongType;
        //   595: dup_x1         
        //   596: swap           
        //   597: ldc_w           "string-cursor>?"
        //   600: iconst_2       
        //   601: aload_3        
        //   602: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   605: athrow         
        //   606: new             Lgnu/mapping/WrongType;
        //   609: dup_x1         
        //   610: swap           
        //   611: ldc_w           "string-cursor>=?"
        //   614: iconst_1       
        //   615: aload_2        
        //   616: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   619: athrow         
        //   620: new             Lgnu/mapping/WrongType;
        //   623: dup_x1         
        //   624: swap           
        //   625: ldc_w           "string-cursor>=?"
        //   628: iconst_2       
        //   629: aload_3        
        //   630: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   633: athrow         
        //   634: new             Lgnu/mapping/WrongType;
        //   637: dup_x1         
        //   638: swap           
        //   639: ldc_w           "string-cursor-for-each"
        //   642: iconst_2       
        //   643: aload_3        
        //   644: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   647: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  82     85     382    396    Ljava/lang/ClassCastException;
        //  89     95     396    410    Ljava/lang/ClassCastException;
        //  108    111    410    424    Ljava/lang/ClassCastException;
        //  115    121    424    438    Ljava/lang/ClassCastException;
        //  134    137    438    452    Ljava/lang/ClassCastException;
        //  141    147    452    466    Ljava/lang/ClassCastException;
        //  160    163    466    480    Ljava/lang/ClassCastException;
        //  167    173    480    494    Ljava/lang/ClassCastException;
        //  181    187    494    508    Ljava/lang/ClassCastException;
        //  191    197    508    522    Ljava/lang/ClassCastException;
        //  217    223    522    536    Ljava/lang/ClassCastException;
        //  227    233    536    550    Ljava/lang/ClassCastException;
        //  253    259    550    564    Ljava/lang/ClassCastException;
        //  263    269    564    578    Ljava/lang/ClassCastException;
        //  289    295    578    592    Ljava/lang/ClassCastException;
        //  299    305    592    606    Ljava/lang/ClassCastException;
        //  325    331    606    620    Ljava/lang/ClassCastException;
        //  335    341    620    634    Ljava/lang/ClassCastException;
        //  364    367    634    648    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 282 out of bounds for length 282
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
        //                4: 48
        //                7: 85
        //                9: 122
        //               16: 156
        //          default: 184
        //        }
        //    48: aload_2        
        //    49: ldc             Ljava/lang/CharSequence;.class
        //    51: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    54: checkcast       Ljava/lang/CharSequence;
        //    57: aload_3        
        //    58: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    61: checkcast       Lgnu/text/StringCursor;
        //    64: invokevirtual   gnu/text/StringCursor.getValue:()I
        //    67: aload           4
        //    69: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    72: checkcast       Ljava/lang/Number;
        //    75: invokevirtual   java/lang/Number.intValue:()I
        //    78: invokestatic    kawa/lib/kawa/string-cursors.stringCursorNext:(Ljava/lang/CharSequence;II)I
        //    81: invokestatic    gnu/text/StringCursor.valueOf:(I)Lgnu/text/StringCursor;
        //    84: areturn        
        //    85: aload_2        
        //    86: ldc             Ljava/lang/CharSequence;.class
        //    88: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    91: checkcast       Ljava/lang/CharSequence;
        //    94: aload_3        
        //    95: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    98: checkcast       Lgnu/text/StringCursor;
        //   101: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   104: aload           4
        //   106: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   109: checkcast       Ljava/lang/Number;
        //   112: invokevirtual   java/lang/Number.intValue:()I
        //   115: invokestatic    kawa/lib/kawa/string-cursors.stringCursorPrev:(Ljava/lang/CharSequence;II)I
        //   118: invokestatic    gnu/text/StringCursor.valueOf:(I)Lgnu/text/StringCursor;
        //   121: areturn        
        //   122: aload_2        
        //   123: ldc             Ljava/lang/CharSequence;.class
        //   125: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   128: checkcast       Ljava/lang/CharSequence;
        //   131: aload_3        
        //   132: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   135: checkcast       Lgnu/text/StringCursor;
        //   138: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   141: aload           4
        //   143: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   146: checkcast       Lgnu/text/StringCursor;
        //   149: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   152: invokestatic    kawa/lib/kawa/string-cursors.substringCursor:(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;
        //   155: areturn        
        //   156: aload_2        
        //   157: aload_3        
        //   158: ldc             Ljava/lang/CharSequence;.class
        //   160: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   163: checkcast       Ljava/lang/CharSequence;
        //   166: aload           4
        //   168: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //   171: checkcast       Lgnu/text/StringCursor;
        //   174: invokevirtual   gnu/text/StringCursor.getValue:()I
        //   177: invokestatic    kawa/lib/kawa/string-cursors.stringCursorForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;I)V
        //   180: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   183: areturn        
        //   184: aload_0        
        //   185: aload_1        
        //   186: aload_2        
        //   187: aload_3        
        //   188: aload           4
        //   190: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   193: areturn        
        //   194: new             Lgnu/mapping/WrongType;
        //   197: dup_x1         
        //   198: swap           
        //   199: ldc_w           "string-cursor-next"
        //   202: iconst_1       
        //   203: aload_2        
        //   204: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   207: athrow         
        //   208: new             Lgnu/mapping/WrongType;
        //   211: dup_x1         
        //   212: swap           
        //   213: ldc_w           "string-cursor-next"
        //   216: iconst_2       
        //   217: aload_3        
        //   218: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   221: athrow         
        //   222: new             Lgnu/mapping/WrongType;
        //   225: dup_x1         
        //   226: swap           
        //   227: ldc_w           "string-cursor-next"
        //   230: iconst_3       
        //   231: aload           4
        //   233: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   236: athrow         
        //   237: new             Lgnu/mapping/WrongType;
        //   240: dup_x1         
        //   241: swap           
        //   242: ldc_w           "string-cursor-prev"
        //   245: iconst_1       
        //   246: aload_2        
        //   247: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   250: athrow         
        //   251: new             Lgnu/mapping/WrongType;
        //   254: dup_x1         
        //   255: swap           
        //   256: ldc_w           "string-cursor-prev"
        //   259: iconst_2       
        //   260: aload_3        
        //   261: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   264: athrow         
        //   265: new             Lgnu/mapping/WrongType;
        //   268: dup_x1         
        //   269: swap           
        //   270: ldc_w           "string-cursor-prev"
        //   273: iconst_3       
        //   274: aload           4
        //   276: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   279: athrow         
        //   280: new             Lgnu/mapping/WrongType;
        //   283: dup_x1         
        //   284: swap           
        //   285: ldc_w           "substring-cursor"
        //   288: iconst_1       
        //   289: aload_2        
        //   290: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   293: athrow         
        //   294: new             Lgnu/mapping/WrongType;
        //   297: dup_x1         
        //   298: swap           
        //   299: ldc_w           "substring-cursor"
        //   302: iconst_2       
        //   303: aload_3        
        //   304: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   307: athrow         
        //   308: new             Lgnu/mapping/WrongType;
        //   311: dup_x1         
        //   312: swap           
        //   313: ldc_w           "substring-cursor"
        //   316: iconst_3       
        //   317: aload           4
        //   319: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   322: athrow         
        //   323: new             Lgnu/mapping/WrongType;
        //   326: dup_x1         
        //   327: swap           
        //   328: ldc_w           "string-cursor-for-each"
        //   331: iconst_2       
        //   332: aload_3        
        //   333: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   336: athrow         
        //   337: new             Lgnu/mapping/WrongType;
        //   340: dup_x1         
        //   341: swap           
        //   342: ldc_w           "string-cursor-for-each"
        //   345: iconst_3       
        //   346: aload           4
        //   348: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   351: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  54     57     194    208    Ljava/lang/ClassCastException;
        //  61     67     208    222    Ljava/lang/ClassCastException;
        //  72     78     222    237    Ljava/lang/ClassCastException;
        //  91     94     237    251    Ljava/lang/ClassCastException;
        //  98     104    251    265    Ljava/lang/ClassCastException;
        //  109    115    265    280    Ljava/lang/ClassCastException;
        //  128    131    280    294    Ljava/lang/ClassCastException;
        //  135    141    294    308    Ljava/lang/ClassCastException;
        //  146    152    308    323    Ljava/lang/ClassCastException;
        //  163    166    323    337    Ljava/lang/ClassCastException;
        //  171    177    337    352    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 154 out of bounds for length 154
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
        //     4: bipush          16
        //     6: if_icmpne       51
        //     9: goto            12
        //    12: aload_2        
        //    13: aload_3        
        //    14: ldc             Ljava/lang/CharSequence;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: checkcast       Ljava/lang/CharSequence;
        //    22: aload           4
        //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    27: checkcast       Lgnu/text/StringCursor;
        //    30: invokevirtual   gnu/text/StringCursor.getValue:()I
        //    33: aload           5
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;)Ljava/lang/Object;
        //    38: checkcast       Lgnu/text/StringCursor;
        //    41: invokevirtual   gnu/text/StringCursor.getValue:()I
        //    44: invokestatic    kawa/lib/kawa/string-cursors.stringCursorForEach:(Ljava/lang/Object;Ljava/lang/CharSequence;II)V
        //    47: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //    50: areturn        
        //    51: aload_0        
        //    52: aload_1        
        //    53: aload_2        
        //    54: aload_3        
        //    55: aload           4
        //    57: aload           5
        //    59: invokespecial   gnu/expr/ModuleBody.apply4:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    62: areturn        
        //    63: new             Lgnu/mapping/WrongType;
        //    66: dup_x1         
        //    67: swap           
        //    68: ldc_w           "string-cursor-for-each"
        //    71: iconst_2       
        //    72: aload_3        
        //    73: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    76: athrow         
        //    77: new             Lgnu/mapping/WrongType;
        //    80: dup_x1         
        //    81: swap           
        //    82: ldc_w           "string-cursor-for-each"
        //    85: iconst_3       
        //    86: aload           4
        //    88: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    91: athrow         
        //    92: new             Lgnu/mapping/WrongType;
        //    95: dup_x1         
        //    96: swap           
        //    97: ldc_w           "string-cursor-for-each"
        //   100: iconst_4       
        //   101: aload           5
        //   103: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   106: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  19     22     63     77     Ljava/lang/ClassCastException;
        //  27     33     77     92     Ljava/lang/ClassCastException;
        //  38     44     92     107    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 53 out of bounds for length 53
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
