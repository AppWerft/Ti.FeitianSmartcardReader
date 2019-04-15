/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEqual;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class regex
extends ModuleBody {
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
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static String regexQuote(CharSequence str) {
        CharSequence charSequence = str;
        return Pattern.quote((String)(charSequence == null ? null : ((Object)charSequence).toString()));
    }

    public static boolean isRegexMatch(Object object2, CharSequence charSequence) {
        return regex.isRegexMatch(object2, charSequence, 0);
    }

    public static boolean isRegexMatch(Object object2, CharSequence charSequence, int n) {
        return regex.isRegexMatch(object2, charSequence, n, charSequence.length());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean isRegexMatch(Object re, CharSequence str, int start, int end) {
        Pattern pattern;
        if (re instanceof Pattern) {
            Object object2 = Promise.force(re, Pattern.class);
            pattern = (Pattern)object2;
        } else {
            pattern = Pattern.compile(re.toString());
        }
        Pattern rex = pattern;
        Matcher matcher = rex.matcher(str);
        matcher.region(start, end);
        return matcher.find();
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rex", -2, (Object)matcher);
        }
    }

    public static Object regexMatch(Object object2, CharSequence charSequence) {
        return regex.regexMatch(object2, charSequence, 0);
    }

    public static Object regexMatch(Object object2, CharSequence charSequence, int n) {
        return regex.regexMatch(object2, charSequence, n, charSequence.length());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object regexMatch(Object re, CharSequence str, int start, int end) {
        Boolean bl;
        Matcher matcher;
        block6 : {
            Pattern pattern;
            if (re instanceof Pattern) {
                Object object2 = Promise.force(re, Pattern.class);
                pattern = (Pattern)object2;
            }
            pattern = Pattern.compile(re.toString());
            Pattern rex = pattern;
            matcher = rex.matcher(str);
            matcher.region(start, end);
            if (!matcher.find()) {
                bl = Boolean.FALSE;
                return bl;
            }
            break block6;
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "rex", -2, (Object)matcher);
            }
        }
        EmptyList emptyList = LList.Empty;
        int igroup = matcher.groupCount();
        do {
            Pair r;
            if (igroup < 0) {
                bl = r;
                return bl;
            }
            int start2 = matcher.start(igroup);
            r = lists.cons(start2 < 0 ? Boolean.FALSE : str.subSequence(start2, matcher.end(igroup)), r);
            --igroup;
        } while (true);
    }

    public static Object regexMatchPositions(Object object2, CharSequence charSequence) {
        return regex.regexMatchPositions(object2, charSequence, 0);
    }

    public static Object regexMatchPositions(Object object2, CharSequence charSequence, int n) {
        return regex.regexMatchPositions(object2, charSequence, n, charSequence.length());
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object regexMatchPositions(Object re, CharSequence str, int start, int end) {
        Boolean bl;
        Matcher matcher;
        block6 : {
            Pattern pattern;
            if (re instanceof Pattern) {
                Object object2 = Promise.force(re, Pattern.class);
                pattern = (Pattern)object2;
            }
            pattern = Pattern.compile(re.toString());
            Pattern rex = pattern;
            matcher = rex.matcher(str);
            matcher.region(start, end);
            if (!matcher.find()) {
                bl = Boolean.FALSE;
                return bl;
            }
            break block6;
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "rex", -2, (Object)matcher);
            }
        }
        EmptyList emptyList = LList.Empty;
        int igroup = matcher.groupCount();
        do {
            Pair r;
            if (igroup < 0) {
                bl = r;
                return bl;
            }
            int start2 = matcher.start(igroup);
            r = lists.cons(start2 < 0 ? Boolean.FALSE : lists.cons(start2, matcher.end(igroup)), r);
            --igroup;
        } while (true);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object regexSplit(Object re, CharSequence str) {
        Pattern pattern;
        LList lList;
        if (re instanceof Pattern) {
            Object object2 = Promise.force(re, Pattern.class);
            pattern = (Pattern)object2;
        } else {
            pattern = Pattern.compile(re.toString());
        }
        Pattern rex = pattern;
        Object[] parts = rex.split(str, -1);
        int plen = parts.length;
        LList rlist = LList.makeList(parts, 0);
        if (plen > 1 && KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(parts[plen - 1], "")) && !KawaConvert.isTrue(((Procedure)Scheme.isEqual).apply2(parts[0], "")) && rex.matcher("").matches()) {
            lList = lists.cons("", rlist);
            return lList;
        }
        lList = rlist;
        return lList;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rex", -2, (Object)parts);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static CharSequence regexReplace(Object re, CharSequence str, Object repl2) {
        Pattern pattern;
        String string;
        CharSequence charSequence;
        if (re instanceof Pattern) {
            Object object2 = Promise.force(re, Pattern.class);
            pattern = (Pattern)object2;
        } else {
            pattern = Pattern.compile(re.toString());
        }
        Pattern rex = pattern;
        Matcher matcher = rex.matcher(str);
        if (!matcher.find()) {
            charSequence = str;
            return charSequence;
        }
        StringBuffer sbuf = new StringBuffer();
        if (misc.isProcedure(repl2)) {
            Object object2 = Promise.force(((Procedure)Scheme.applyToArgs).apply2(repl2, matcher.group()), String.class);
            string = Matcher.quoteReplacement((String)(object2 == null ? null : object2.toString()));
        } else {
            Object object3 = Promise.force(repl2, String.class);
            string = object3 == null ? null : object3.toString();
        }
        matcher.appendReplacement(sbuf, string);
        matcher.appendTail(sbuf);
        charSequence = sbuf.toString();
        return charSequence;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rex", -2, (Object)matcher);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static CharSequence regexReplace$St(Object re, CharSequence str, Object repl2) {
        Pattern pattern;
        Object object2;
        String string;
        public class Frame
        extends ModuleBody {
            Procedure loop = new ModuleMethod(this, 1, "loop", 0);
            Object repl;
            StringBuffer sbuf;
            Matcher matcher;

            public String lambda1loop() {
                if (this.matcher.find()) {
                    Object object2 = Promise.force(((Procedure)Scheme.applyToArgs).apply2(this.repl, this.matcher.group()), String.class);
                    this.matcher.appendReplacement(this.sbuf, Matcher.quoteReplacement((String)(object2 == null ? null : object2.toString())));
                }
                this.matcher.appendTail(this.sbuf);
                return this.sbuf.toString();
            }

            public int match0(ModuleMethod moduleMethod, CallContext callContext) {
                if (moduleMethod.selector == 1) {
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                }
                return super.match0(moduleMethod, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply0(ModuleMethod moduleMethod) {
                if (moduleMethod.selector == 1) {
                    return this.lambda1loop();
                }
                return super.apply0(moduleMethod);
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.repl = repl2;
        if (re instanceof Pattern) {
            object2 = Promise.force(re, Pattern.class);
            pattern = (Pattern)object2;
        } else {
            pattern = Pattern.compile(re.toString());
        }
        Pattern rex = pattern;
        $heapFrame.matcher = rex.matcher(str);
        $heapFrame.sbuf = new StringBuffer();
        if (misc.isProcedure($heapFrame.repl)) {
            $heapFrame.loop = $heapFrame.loop;
            string = $heapFrame.lambda1loop();
            return string;
        }
        Object object3 = Promise.force($heapFrame.repl, String.class);
        string = $heapFrame.matcher.replaceAll((String)(object3 == null ? null : object3.toString()));
        return string;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "rex", -2, object2);
        }
    }

    public static {
        Lit6 = Symbol.valueOf("regex-replace*");
        Lit5 = Symbol.valueOf("regex-replace");
        Lit4 = Symbol.valueOf("regex-split");
        Lit3 = Symbol.valueOf("regex-match-positions");
        Lit2 = Symbol.valueOf("regex-match");
        Lit1 = Symbol.valueOf("regex-match?");
        Lit0 = Symbol.valueOf("regex-quote");
        regex regex2 = $instance = new regex();
        regex$Mnquote = new ModuleMethod(regex2, 2, Lit0, 4097);
        regex$Mnmatch$Qu = new ModuleMethod(regex2, 3, Lit1, 16386);
        regex$Mnmatch = new ModuleMethod(regex2, 6, Lit2, 16386);
        regex$Mnmatch$Mnpositions = new ModuleMethod(regex2, 9, Lit3, 16386);
        regex$Mnsplit = new ModuleMethod(regex2, 12, Lit4, 8194);
        regex$Mnreplace = new ModuleMethod(regex2, 13, Lit5, 12291);
        regex$Mnreplace$St = new ModuleMethod(regex2, 14, Lit6, 12291);
        regex.$runBody$();
    }

    public regex() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        if (moduleMethod.selector == 2) {
            Object object3 = Promise.force(object2, CharSequence.class);
            if (!(object3 instanceof CharSequence)) {
                return -786431;
            }
            callContext.value1 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 1;
            return 0;
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 12: {
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
            case 9: {
                callContext.value1 = object2;
                Object object5 = Promise.force(object3, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 6: {
                callContext.value1 = object2;
                Object object6 = Promise.force(object3, CharSequence.class);
                if (!(object6 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                Object object7 = Promise.force(object3, CharSequence.class);
                if (!(object7 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 14: {
                callContext.value1 = object2;
                Object object5 = Promise.force(object3, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 13: {
                callContext.value1 = object2;
                Object object6 = Promise.force(object3, CharSequence.class);
                if (!(object6 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 9: {
                callContext.value1 = object2;
                Object object7 = Promise.force(object3, CharSequence.class);
                if (!(object7 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 6: {
                callContext.value1 = object2;
                Object object8 = Promise.force(object3, CharSequence.class);
                if (!(object8 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                Object object9 = Promise.force(object3, CharSequence.class);
                if (!(object9 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object9;
                callContext.value3 = Promise.force(object4);
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 9: {
                callContext.value1 = object2;
                Object object6 = Promise.force(object3, CharSequence.class);
                if (!(object6 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 6: {
                callContext.value1 = object2;
                Object object7 = Promise.force(object3, CharSequence.class);
                if (!(object7 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                Object object8 = Promise.force(object3, CharSequence.class);
                if (!(object8 instanceof CharSequence)) {
                    return -786430;
                }
                callContext.value2 = object8;
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        if (moduleMethod.selector != 2) return super.apply1(moduleMethod, object2);
        try {
            return regex.regexQuote((CharSequence)Promise.force(object2, CharSequence.class));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "regex-quote", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 3: {
                Boolean bl;
                if (regex.isRegexMatch(object2, (CharSequence)Promise.force(object3, CharSequence.class))) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 6: {
                return regex.regexMatch(object2, (CharSequence)Promise.force(object3, CharSequence.class));
            }
            case 9: {
                return regex.regexMatchPositions(object2, (CharSequence)Promise.force(object3, CharSequence.class));
            }
            case 12: {
                return regex.regexSplit(object2, (CharSequence)Promise.force(object3, CharSequence.class));
            }
        }
        return super.apply2(moduleMethod, object2, object3);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "regex-match?", 2, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "regex-match", 2, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "regex-match-positions", 2, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "regex-split", 2, object3);
        }
    }

    /*
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
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

