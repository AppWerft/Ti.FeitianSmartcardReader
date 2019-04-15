/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
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
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.numbers;

public class srfi60
extends ModuleBody {
    public static final int $Pcprovide$Pcsrfi$Mn60 = 123;
    public static final StaticFieldLocation arithmetic$Mnshift;
    public static final StaticFieldLocation ash;
    public static final StaticFieldLocation bitwise$Mnand;
    public static final StaticFieldLocation logand;
    public static final StaticFieldLocation bitwise$Mnior;
    public static final StaticFieldLocation logior;
    public static final StaticFieldLocation bitwise$Mnnot;
    public static final StaticFieldLocation lognot;
    public static final StaticFieldLocation bitwise$Mnxor;
    public static final StaticFieldLocation logxor;
    public static final StaticFieldLocation integer$Mnlength;
    public static final StaticFieldLocation bitwise$Mnif;
    public static final StaticFieldLocation logtest;
    public static final StaticFieldLocation logcount;
    public static ModuleMethod bitwise$Mnmerge;
    public static ModuleMethod any$Mnbits$Mnset$Qu;
    public static ModuleMethod bit$Mncount;
    public static ModuleMethod log2$Mnbinary$Mnfactors;
    public static ModuleMethod first$Mnset$Mnbit;
    public static ModuleMethod bit$Mnfield;
    public static ModuleMethod reverse$Mnbit$Mnfield;
    public static final ModuleMethod logbit$Qu;
    public static Procedure bit$Mnset$Qu;
    public static final ModuleMethod copy$Mnbit$Mnfield;
    public static final ModuleMethod rotate$Mnbit$Mnfield;
    public static final ModuleMethod copy$Mnbit;
    public static final ModuleMethod integer$Mn$Grlist;
    public static final ModuleMethod list$Mn$Grinteger;
    public static final ModuleMethod booleans$Mn$Grinteger;
    static final IntNum Lit0;
    public static srfi60 $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        bitwise$Mnmerge = numbers.bitwise$Mnif;
        any$Mnbits$Mnset$Qu = numbers.logtest;
        bit$Mncount = numbers.logcount;
        log2$Mnbinary$Mnfactors = numbers.bitwise$Mnfirst$Mnbit$Mnset;
        first$Mnset$Mnbit = numbers.bitwise$Mnfirst$Mnbit$Mnset;
        bit$Mnfield = numbers.bitwise$Mnbit$Mnfield;
        reverse$Mnbit$Mnfield = numbers.bitwise$Mnreverse$Mnbit$Mnfield;
        bit$Mnset$Qu = logbit$Qu;
    }

    public static boolean isLogbit(int index, IntNum n) {
        return numbers.isBitwiseBitSet(n, index);
    }

    public static IntNum copyBitField(IntNum to, IntNum from, int start, int end) {
        return numbers.bitwiseCopyBitField(to, start, end, from);
    }

    public static IntNum rotateBitField(IntNum n, int count, int start, int end) {
        return numbers.bitwiseRotateBitField(n, start, end, count);
    }

    public static IntNum copyBit(int index, IntNum from, boolean bit) {
        return numbers.bitwiseCopyBit(from, index, bit ? 1 : 0);
    }

    public static LList integer$To$List(IntNum intNum) {
        return srfi60.integer$To$List(intNum, numbers.bitwiseLength(intNum));
    }

    public static LList integer$To$List(IntNum k, int len) {
        Pair lst;
        EmptyList emptyList = LList.Empty;
        IntNum k2 = k;
        for (int idx = len - 1; idx >= 0; --idx) {
            lst = lists.cons((((Number)k2).intValue() & 1) != 0 ? Boolean.TRUE : Boolean.FALSE, lst);
            k2 = IntNum.shift(k2, -1);
        }
        return lst;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static IntNum list$To$Integer(LList bools) {
        v0 = bools;
        v1 = srfi60.Lit0;
        do lbl-1000: // 3 sources:
        {
            acc = v1;
            bs = v0;
            if (lists.isNull(bs) != false) return acc;
            object2 = Promise.force(bs, Pair.class);
            v0 = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "cdr", 1, object2);
        }
        {
            block5 : {
                object2 = Promise.force(bs, Pair.class);
                if (!KawaConvert.isTrue(lists.car((Pair)object2))) break block5;
                v1 = IntNum.add(IntNum.add(acc, acc), 1);
                continue;
            }
            v1 = IntNum.add(acc, acc);
            ** while (true)
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "car", 1, object2);
        }
    }

    public static IntNum booleans$To$Integer$V(Object[] argsArray) {
        LList lList;
        LList bools = lList = LList.makeList(argsArray, 0);
        return srfi60.list$To$Integer(bools);
    }

    public static {
        Lit7 = Symbol.valueOf("booleans->integer");
        Lit6 = Symbol.valueOf("list->integer");
        Lit5 = Symbol.valueOf("integer->list");
        Lit4 = Symbol.valueOf("copy-bit");
        Lit3 = Symbol.valueOf("rotate-bit-field");
        Lit2 = Symbol.valueOf("copy-bit-field");
        Lit1 = Symbol.valueOf("logbit?");
        Lit0 = IntNum.valueOf(0);
        $instance = new srfi60();
        arithmetic$Mnshift = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashift");
        ash = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ashift");
        bitwise$Mnand = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "and");
        logand = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "and");
        bitwise$Mnior = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ior");
        logior = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "ior");
        bitwise$Mnnot = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "not");
        lognot = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "not");
        bitwise$Mnxor = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "xor");
        logxor = StaticFieldLocation.make("gnu.kawa.functions.BitwiseOp", "xor");
        integer$Mnlength = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnlength");
        bitwise$Mnif = StaticFieldLocation.make("kawa.lib.numbers", "bitwise$Mnif");
        logtest = StaticFieldLocation.make("kawa.lib.numbers", "logtest");
        logcount = StaticFieldLocation.make("kawa.lib.numbers", "logcount");
        srfi60 srfi602 = $instance;
        logbit$Qu = new ModuleMethod(srfi602, 1, Lit1, 8194);
        copy$Mnbit$Mnfield = new ModuleMethod(srfi602, 2, Lit2, 16388);
        rotate$Mnbit$Mnfield = new ModuleMethod(srfi602, 3, Lit3, 16388);
        copy$Mnbit = new ModuleMethod(srfi602, 4, Lit4, 12291);
        integer$Mn$Grlist = new ModuleMethod(srfi602, 5, Lit5, 8193);
        list$Mn$Grinteger = new ModuleMethod(srfi602, 7, Lit6, 4097);
        booleans$Mn$Grinteger = new ModuleMethod(srfi602, 8, Lit7, -4096);
        srfi60.$runBody$();
    }

    public srfi60() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 7: {
                Object object3 = Promise.force(object2, LList.class);
                if (!(object3 instanceof LList)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 5: {
                Object object4 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 5: {
                Object object4 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 1: {
                callContext.value1 = Promise.force(object2);
                Object object5 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object5) == null) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        if (moduleMethod.selector == 4) {
            callContext.value1 = Promise.force(object2);
            Object object5 = Promise.force(object3, IntNum.class);
            if (IntNum.asIntNumOrNull(object5) == null) {
                return -786430;
            }
            callContext.value2 = object5;
            Object object6 = Promise.force(object4);
            if (!(object6 instanceof Boolean)) {
                return -786429;
            }
            callContext.value3 = object6;
            callContext.proc = moduleMethod;
            callContext.pc = 3;
            return 0;
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3: {
                Object object6 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = Promise.force(object4);
                callContext.value4 = Promise.force(object5);
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 2: {
                Object object7 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object8) == null) {
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

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        if (moduleMethod.selector == 8) {
            callContext.values = arrobject;
            callContext.proc = moduleMethod;
            callContext.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, arrobject, callContext);
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
            case 5: {
                return srfi60.integer$To$List(LangObjType.coerceIntNum(Promise.force(object2, IntNum.class)));
            }
            case 7: {
                return srfi60.list$To$Integer((LList)Promise.force(object2, LList.class));
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "integer->list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "list->integer", 1, object2);
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
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        if (moduleMethod.selector == 8) {
            return srfi60.booleans$To$Integer$V(arrobject);
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

