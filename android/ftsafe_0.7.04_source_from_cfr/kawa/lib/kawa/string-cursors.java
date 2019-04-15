/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import gnu.text.StringCursor;
import kawa.SourceMethodType;
import kawa.standard.Scheme;

public class string-cursors
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    @SourceMethodType(value={"string-cursor"})
    public static int stringCursorStart(CharSequence str) {
        return 0;
    }

    @SourceMethodType(value={"string-cursor"})
    public static int stringCursorEnd(CharSequence str) {
        return str.length();
    }

    @SourceMethodType(value={"character", "", "string-cursor"})
    public static int stringCursorRef(CharSequence str, int cursor) {
        boolean x;
        int n;
        int cursor0 = cursor;
        int ch1 = str.charAt(cursor0);
        boolean bl = x = ch1 < 55296;
        if (x ? x : ch1 > 57343) {
            n = ch1;
        } else if (ch1 >= 55296 && ch1 <= 56319) {
            boolean x2;
            char ch2 = cursor0 == str.length() ? (char)'\u0000' : str.charAt(cursor0 + 1);
            boolean bl2 = x2 = ch2 < '\udc00';
            n = (x2 ? x2 : ch2 > '\udfff') ? ch1 : (ch1 - 55296) * 1024 + (ch2 - 56320) + 65536;
        } else {
            char ch0 = cursor0 == 0 ? (char)'\u0000' : str.charAt(cursor0 - 1);
            n = ch0 >= '\ud800' && ch0 <= '\udbff' ? 2097151 : ch1;
        }
        return n;
    }

    @SourceMethodType(value={"string-cursor", "", "string-cursor"})
    public static int stringCursorNext(CharSequence charSequence, int n) {
        return string-cursors.stringCursorNext(charSequence, n, 1);
    }

    @SourceMethodType(value={"string-cursor", "", "string-cursor"})
    public static int stringCursorNext(CharSequence str, int cursor, int count) {
        return Character.offsetByCodePoints(str, cursor, count);
    }

    @SourceMethodType(value={"string-cursor", "string-cursor"})
    public static int stringCursorNextQuick(int cursor) {
        return 1 + cursor;
    }

    @SourceMethodType(value={"string-cursor", "", "string-cursor"})
    public static int stringCursorPrev(CharSequence charSequence, int n) {
        return string-cursors.stringCursorPrev(charSequence, n, 1);
    }

    @SourceMethodType(value={"string-cursor", "", "string-cursor"})
    public static int stringCursorPrev(CharSequence str, int cursor, int count) {
        return Character.offsetByCodePoints(str, cursor, -count);
    }

    @SourceMethodType(value={"", "", "string-cursor"})
    public static CharSequence substringCursor(CharSequence charSequence, int n) {
        return string-cursors.substringCursor(charSequence, n, charSequence.length());
    }

    @SourceMethodType(value={"", "", "string-cursor", "string-cursor"})
    public static CharSequence substringCursor(CharSequence str, int cs1, int cs2) {
        return str.subSequence(cs1, cs2);
    }

    @SourceMethodType(value={"", "string-cursor", "string-cursor"})
    public static boolean isStringCursor$Ls(int cs1, int cs2) {
        return cs1 < cs2;
    }

    @SourceMethodType(value={"", "string-cursor", "string-cursor"})
    public static boolean isStringCursor$Ls$Eq(int cs1, int cs2) {
        return cs1 <= cs2;
    }

    @SourceMethodType(value={"", "string-cursor", "string-cursor"})
    public static boolean isStringCursor$Eq(int cs1, int cs2) {
        return cs1 == cs2;
    }

    @SourceMethodType(value={"", "string-cursor", "string-cursor"})
    public static boolean isStringCursor$Gr(int cs1, int cs2) {
        return cs1 > cs2;
    }

    @SourceMethodType(value={"", "string-cursor", "string-cursor"})
    public static boolean isStringCursor$Gr$Eq(int cs1, int cs2) {
        return cs1 >= cs2;
    }

    public static void stringCursorForEach(Object object2, CharSequence charSequence) {
        string-cursors.stringCursorForEach(object2, charSequence, 0);
    }

    @SourceMethodType(value={"", "", "", "string-cursor"})
    public static void stringCursorForEach(Object object2, CharSequence charSequence, int n) {
        string-cursors.stringCursorForEach(object2, charSequence, n, string-cursors.stringCursorEnd(charSequence));
    }

    @SourceMethodType(value={"", "", "", "string-cursor", "string-cursor"})
    public static void stringCursorForEach(Object proc, CharSequence str, int start, int end) {
        int cursor;
        int n = start;
        while (!string-cursors.isStringCursor$Gr$Eq(cursor = n, end)) {
            ((Procedure)Scheme.applyToArgs).apply2(proc, Char.make(string-cursors.stringCursorRef(str, cursor)));
            n = string-cursors.stringCursorNext(str, cursor);
        }
    }

    public static {
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
        $instance = new string-cursors();
        string$Mncursor = StaticFieldLocation.make("gnu.kawa.lispexpr.LangPrimType", "stringCursorType");
        string-cursors string-cursors2 = $instance;
        string$Mncursor$Mnstart = new ModuleMethod(string-cursors2, 1, Lit0, 4097);
        string$Mncursor$Mnend = new ModuleMethod(string-cursors2, 2, Lit1, 4097);
        string$Mncursor$Mnref = new ModuleMethod(string-cursors2, 3, Lit2, 8194);
        string$Mncursor$Mnnext = new ModuleMethod(string-cursors2, 4, Lit3, 12290);
        string$Mncursor$Mnnext$Mnquick = new ModuleMethod(string-cursors2, 6, Lit4, 4097);
        string$Mncursor$Mnprev = new ModuleMethod(string-cursors2, 7, Lit5, 12290);
        substring$Mncursor = new ModuleMethod(string-cursors2, 9, Lit6, 12290);
        ModuleMethod moduleMethod = new ModuleMethod(string-cursors2, 11, Lit7, 8194);
        moduleMethod.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Ls$Qu = moduleMethod;
        ModuleMethod moduleMethod2 = new ModuleMethod(string-cursors2, 12, Lit8, 8194);
        moduleMethod2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Ls$Eq$Qu = moduleMethod2;
        ModuleMethod moduleMethod3 = new ModuleMethod(string-cursors2, 13, Lit9, 8194);
        moduleMethod3.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Eq$Qu = moduleMethod3;
        ModuleMethod moduleMethod4 = new ModuleMethod(string-cursors2, 14, Lit10, 8194);
        moduleMethod4.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Gr$Qu = moduleMethod4;
        ModuleMethod moduleMethod5 = new ModuleMethod(string-cursors2, 15, Lit11, 8194);
        moduleMethod5.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:stringCursorCompareValidateApply");
        string$Mncursor$Gr$Eq$Qu = moduleMethod5;
        ModuleMethod moduleMethod6 = new ModuleMethod(string-cursors2, 16, Lit12, 16386);
        moduleMethod6.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_map:stringCursorForEachValidateApply");
        string$Mncursor$Mnfor$Mneach = moduleMethod6;
        string-cursors.$runBody$();
    }

    public string-cursors() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 6: {
                Object object3 = Promise.force(object2);
                if (StringCursor.checkStringCursor(object3) < 0) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 2: {
                Object object4 = Promise.force(object2, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 16: {
                callContext.value1 = object2;
                Object object4 = Promise.force(object3, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                Object object5 = Promise.force(object2);
                if (StringCursor.checkStringCursor(object5) < 0) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object6) < 0) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 14: {
                Object object7 = Promise.force(object2);
                if (StringCursor.checkStringCursor(object7) < 0) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object8) < 0) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 13: {
                Object object9 = Promise.force(object2);
                if (StringCursor.checkStringCursor(object9) < 0) {
                    return -786431;
                }
                callContext.value1 = object9;
                Object object10 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object10) < 0) {
                    return -786430;
                }
                callContext.value2 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 12: {
                Object object11 = Promise.force(object2);
                if (StringCursor.checkStringCursor(object11) < 0) {
                    return -786431;
                }
                callContext.value1 = object11;
                Object object12 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object12) < 0) {
                    return -786430;
                }
                callContext.value2 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 11: {
                Object object13 = Promise.force(object2);
                if (StringCursor.checkStringCursor(object13) < 0) {
                    return -786431;
                }
                callContext.value1 = object13;
                Object object14 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object14) < 0) {
                    return -786430;
                }
                callContext.value2 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 9: {
                Object object15 = Promise.force(object2, CharSequence.class);
                if (!(object15 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object15;
                Object object16 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object16) < 0) {
                    return -786430;
                }
                callContext.value2 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                Object object17 = Promise.force(object2, CharSequence.class);
                if (!(object17 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object17;
                Object object18 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object18) < 0) {
                    return -786430;
                }
                callContext.value2 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 4: {
                Object object19 = Promise.force(object2, CharSequence.class);
                if (!(object19 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object19;
                Object object20 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object20) < 0) {
                    return -786430;
                }
                callContext.value2 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 3: {
                Object object21 = Promise.force(object2, CharSequence.class);
                if (!(object21 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object21;
                Object object22 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object22) < 0) {
                    return -786430;
                }
                callContext.value2 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 16: {
                callContext.value1 = object2;
                Object object5 = Promise.force(object3, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object5;
                Object object6 = Promise.force(object4);
                if (StringCursor.checkStringCursor(object6) < 0) {
                    return -786429;
                }
                callContext.value3 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 9: {
                Object object7 = Promise.force(object2, CharSequence.class);
                if (!(object7 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object8) < 0) {
                    return -786430;
                }
                callContext.value2 = object8;
                Object object9 = Promise.force(object4);
                if (StringCursor.checkStringCursor(object9) < 0) {
                    return -786429;
                }
                callContext.value3 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 7: {
                Object object10 = Promise.force(object2, CharSequence.class);
                if (!(object10 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object10;
                Object object11 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object11) < 0) {
                    return -786430;
                }
                callContext.value2 = object11;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 4: {
                Object object12 = Promise.force(object2, CharSequence.class);
                if (!(object12 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object12;
                Object object13 = Promise.force(object3);
                if (StringCursor.checkStringCursor(object13) < 0) {
                    return -786430;
                }
                callContext.value2 = object13;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        if (moduleMethod.selector == 16) {
            callContext.value1 = object2;
            Object object6 = Promise.force(object3, CharSequence.class);
            if (!(object6 instanceof CharSequence)) {
                return -786430;
            }
            callContext.value2 = object6;
            Object object7 = Promise.force(object4);
            if (StringCursor.checkStringCursor(object7) < 0) {
                return -786429;
            }
            callContext.value3 = object7;
            Object object8 = Promise.force(object5);
            if (StringCursor.checkStringCursor(object8) < 0) {
                return -786428;
            }
            callContext.value4 = object8;
            callContext.proc = moduleMethod;
            callContext.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
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
            case 1: {
                return StringCursor.valueOf(string-cursors.stringCursorStart((CharSequence)Promise.force(object2, CharSequence.class)));
            }
            case 2: {
                return StringCursor.valueOf(string-cursors.stringCursorEnd((CharSequence)Promise.force(object2, CharSequence.class)));
            }
            case 6: {
                return StringCursor.valueOf(string-cursors.stringCursorNextQuick(((StringCursor)Promise.force(object2)).getValue()));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-cursor-start", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-cursor-end", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "string-cursor-next-quick", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply2(ModuleMethod var1_1, Object var2_2, Object var3_3) {
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
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
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

    /*
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
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
}

