/*
 * Decompiled with CFR 0.139.
 */
package gnu.commonlisp.lisp;

import gnu.commonlisp.lang.CommonLisp;
import gnu.commonlisp.lang.Symbols;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.format.AbstractFormat;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.io.OutPort;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Sequence;
import gnu.lists.SimpleVector;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.PropertyLocation;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.ports;
import kawa.lib.strings;

public class PrimOps
extends ModuleBody {
    public static final ModuleMethod boundp;
    public static final ModuleMethod symbolp;
    public static final ModuleMethod symbol$Mnname;
    public static final ModuleMethod symbol$Mnplist;
    public static final ModuleMethod setplist;
    public static final ModuleMethod plist$Mnget;
    public static final ModuleMethod plist$Mnput;
    public static final ModuleMethod plist$Mnremprop;
    public static final ModuleMethod plist$Mnmember;
    public static final ModuleMethod get;
    public static final ModuleMethod put;
    public static final ModuleMethod symbol$Mnvalue;
    public static final ModuleMethod set;
    public static final ModuleMethod symbol$Mnfunction;
    public static final ModuleMethod fset;
    public static final ModuleMethod length;
    public static final ModuleMethod arrayp;
    public static final ModuleMethod aref;
    public static final ModuleMethod aset;
    public static final ModuleMethod fillarray;
    public static final ModuleMethod stringp;
    public static final ModuleMethod make$Mnstring;
    public static final ModuleMethod substring;
    public static final ModuleMethod char$Mnto$Mnstring;
    public static final ModuleMethod functionp;
    public static final ModuleMethod princ;
    public static final ModuleMethod prin1;
    static final SimpleSymbol Lit0;
    static final IntNum Lit1;
    public static PrimOps $instance;
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
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static boolean boundp(Object symbol) {
        return Symbols.isBound(symbol);
    }

    public static boolean symbolp(Object x) {
        return Symbols.isSymbol(x);
    }

    public static Object symbolName(Object symbol) {
        return Symbols.getPrintName(symbol);
    }

    public static Object symbolPlist(Object symbol) {
        return PropertyLocation.getPropertyList(symbol);
    }

    public static Object setplist(Object symbol, Object plist) {
        PropertyLocation.setPropertyList(symbol, plist);
        return plist;
    }

    public static Object plistGet(Object object2, Object object3) {
        return PrimOps.plistGet(object2, object3, Boolean.FALSE);
    }

    public static Object plistGet(Object plist, Object prop, Object object2) {
        return PropertyLocation.plistGet(plist, prop, object2);
    }

    public static Object plistPut(Object plist, Object prop, Object value) {
        return PropertyLocation.plistPut(plist, prop, value);
    }

    public static Object plistRemprop(Object plist, Object prop) {
        return PropertyLocation.plistRemove(plist, prop);
    }

    public static Object plistMember(Object plist, Object prop) {
        return PropertyLocation.plistGet(plist, prop, Values.empty) == Values.empty ? LList.Empty : Lit0;
    }

    public static Object get(Symbol symbol, Object object2) {
        return PrimOps.get(symbol, object2, LList.Empty);
    }

    public static Object get(Symbol symbol, Object property, Object object2) {
        return PropertyLocation.getProperty(symbol, property, object2);
    }

    public static void put(Object symbol, Object property, Object value) {
        PropertyLocation.putProperty(symbol, property, value);
    }

    public static Object symbolValue(Object sym) {
        return Environment.getCurrent().get(Symbols.getSymbol(sym));
    }

    public static void set(Object symbol, Object value) {
        Environment.getCurrent().put(Symbols.getSymbol(symbol), value);
    }

    public static Object symbolFunction(Object symbol) {
        return Symbols.getFunctionBinding(symbol);
    }

    public static void fset(Object symbol, Object object2) {
        Symbols.setFunctionBinding(Environment.getCurrent(), symbol, object2);
    }

    public static int length(Sequence x) {
        return x.size();
    }

    public static boolean arrayp(Object x) {
        return x instanceof SimpleVector;
    }

    public static Object aref(SimpleVector array, int k) {
        return array.get(k);
    }

    public static Object aset(SimpleVector array, int k, Object obj) {
        array.set(k, obj);
        return obj;
    }

    public static Object fillarray(SimpleVector array, Object obj) {
        array.fill(obj);
        return obj;
    }

    public static boolean stringp(Object x) {
        return x instanceof CharSequence;
    }

    public static FString makeString(int count, Object ch) {
        return new FString(count, CommonLisp.asChar(ch));
    }

    public static FString substring(CharSequence charSequence, Object object2) {
        return PrimOps.substring(charSequence, object2, LList.Empty);
    }

    public static FString substring(CharSequence str, Object from, Object to) {
        if (to == LList.Empty) {
            to = strings.stringLength(str);
        }
        if (NumberCompare.$Ls(to, Lit1)) {
            to = AddOp.apply2(-1, strings.stringLength(str), to);
        }
        if (NumberCompare.$Ls(from, Lit1)) {
            from = AddOp.apply2(-1, strings.stringLength(str), from);
        }
        return new FString(str, ((Number)Promise.force(from)).intValue(), ((Number)Promise.force(AddOp.apply2(-1, to, from))).intValue());
    }

    public static FString charToString(Object ch) {
        return new FString(1, CommonLisp.asChar(ch));
    }

    public static boolean functionp(Object x) {
        return x instanceof Procedure;
    }

    public static void princ(Object object2) {
        PrimOps.princ(object2, ports.current$Mnoutput$Mnport.getValue());
    }

    public static void princ(Object value, Object out) {
        Object object2 = Promise.force(out, Consumer.class);
        try {
            CommonLisp.displayFormat.format(value, (Consumer)object2);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.format.AbstractFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, object2);
        }
    }

    public static void prin1(Object object2) {
        PrimOps.prin1(object2, ports.current$Mnoutput$Mnport.getValue());
    }

    public static void prin1(Object value, Object out) {
        Object object2 = Promise.force(out, Consumer.class);
        try {
            CommonLisp.writeFormat.format(value, (Consumer)object2);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.format.AbstractFormat.format(java.lang.Object,gnu.lists.Consumer)", 3, object2);
        }
    }

    public static {
        Lit28 = Symbol.valueOf("prin1");
        Lit27 = Symbol.valueOf("princ");
        Lit26 = Symbol.valueOf("functionp");
        Lit25 = Symbol.valueOf("char-to-string");
        Lit24 = Symbol.valueOf("substring");
        Lit23 = Symbol.valueOf("make-string");
        Lit22 = Symbol.valueOf("stringp");
        Lit21 = Symbol.valueOf("fillarray");
        Lit20 = Symbol.valueOf("aset");
        Lit19 = Symbol.valueOf("aref");
        Lit18 = Symbol.valueOf("arrayp");
        Lit17 = Symbol.valueOf("length");
        Lit16 = Symbol.valueOf("fset");
        Lit15 = Symbol.valueOf("symbol-function");
        Lit14 = Symbol.valueOf("set");
        Lit13 = Symbol.valueOf("symbol-value");
        Lit12 = Symbol.valueOf("put");
        Lit11 = Symbol.valueOf("get");
        Lit10 = Symbol.valueOf("plist-member");
        Lit9 = Symbol.valueOf("plist-remprop");
        Lit8 = Symbol.valueOf("plist-put");
        Lit7 = Symbol.valueOf("plist-get");
        Lit6 = Symbol.valueOf("setplist");
        Lit5 = Symbol.valueOf("symbol-plist");
        Lit4 = Symbol.valueOf("symbol-name");
        Lit3 = Symbol.valueOf("symbolp");
        Lit2 = Symbol.valueOf("boundp");
        Lit1 = IntNum.valueOf(0);
        Lit0 = Symbol.valueOf("t");
        PrimOps primOps = $instance = new PrimOps();
        boundp = new ModuleMethod(primOps, 1, Lit2, 4097);
        symbolp = new ModuleMethod(primOps, 2, Lit3, 4097);
        symbol$Mnname = new ModuleMethod(primOps, 3, Lit4, 4097);
        symbol$Mnplist = new ModuleMethod(primOps, 4, Lit5, 4097);
        setplist = new ModuleMethod(primOps, 5, Lit6, 8194);
        plist$Mnget = new ModuleMethod(primOps, 6, Lit7, 12290);
        plist$Mnput = new ModuleMethod(primOps, 8, Lit8, 12291);
        plist$Mnremprop = new ModuleMethod(primOps, 9, Lit9, 8194);
        plist$Mnmember = new ModuleMethod(primOps, 10, Lit10, 8194);
        get = new ModuleMethod(primOps, 11, Lit11, 12290);
        put = new ModuleMethod(primOps, 13, Lit12, 12291);
        symbol$Mnvalue = new ModuleMethod(primOps, 14, Lit13, 4097);
        set = new ModuleMethod(primOps, 15, Lit14, 8194);
        symbol$Mnfunction = new ModuleMethod(primOps, 16, Lit15, 4097);
        fset = new ModuleMethod(primOps, 17, Lit16, 8194);
        length = new ModuleMethod(primOps, 18, Lit17, 4097);
        arrayp = new ModuleMethod(primOps, 19, Lit18, 4097);
        aref = new ModuleMethod(primOps, 20, Lit19, 8194);
        aset = new ModuleMethod(primOps, 21, Lit20, 12291);
        fillarray = new ModuleMethod(primOps, 22, Lit21, 8194);
        stringp = new ModuleMethod(primOps, 23, Lit22, 4097);
        make$Mnstring = new ModuleMethod(primOps, 24, Lit23, 8194);
        substring = new ModuleMethod(primOps, 25, Lit24, 12290);
        char$Mnto$Mnstring = new ModuleMethod(primOps, 27, Lit25, 4097);
        functionp = new ModuleMethod(primOps, 28, Lit26, 4097);
        princ = new ModuleMethod(primOps, 29, Lit27, 8193);
        prin1 = new ModuleMethod(primOps, 31, Lit28, 8193);
        PrimOps.$runBody$();
    }

    public PrimOps() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 31: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 29: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 28: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 27: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 23: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 19: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 18: {
                Object object3 = Promise.force(object2, Sequence.class);
                if (!(object3 instanceof Sequence)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 16: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 14: {
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
            case 1: {
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
            case 31: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 29: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 25: {
                Object object4 = Promise.force(object2, CharSequence.class);
                if (!(object4 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 24: {
                callContext.value1 = Promise.force(object2);
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 22: {
                Object object5 = Promise.force(object2, SimpleVector.class);
                if (!(object5 instanceof SimpleVector)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 20: {
                Object object6 = Promise.force(object2, SimpleVector.class);
                if (!(object6 instanceof SimpleVector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 17: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 15: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 11: {
                Object object7 = Promise.force(object2, Symbol.class);
                if (!(object7 instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 10: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 9: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 6: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 5: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 25: {
                Object object5 = Promise.force(object2, CharSequence.class);
                if (!(object5 instanceof CharSequence)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 21: {
                Object object6 = Promise.force(object2, SimpleVector.class);
                if (!(object6 instanceof SimpleVector)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3);
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 13: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 11: {
                Object object7 = Promise.force(object2, Symbol.class);
                if (!(object7 instanceof Symbol)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 8: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 6: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
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
                Boolean bl;
                if (PrimOps.boundp(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 2: {
                Boolean bl;
                if (PrimOps.symbolp(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 3: {
                return PrimOps.symbolName(object2);
            }
            case 4: {
                return PrimOps.symbolPlist(object2);
            }
            case 14: {
                return PrimOps.symbolValue(object2);
            }
            case 16: {
                return PrimOps.symbolFunction(object2);
            }
            case 18: {
                return PrimOps.length((Sequence)Promise.force(object2, Sequence.class));
            }
            case 19: {
                Boolean bl;
                if (PrimOps.arrayp(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 23: {
                Boolean bl;
                if (PrimOps.stringp(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 27: {
                return PrimOps.charToString(object2);
            }
            case 28: {
                Boolean bl;
                if (PrimOps.functionp(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 29: {
                PrimOps.princ(object2);
                return Values.empty;
            }
            case 31: {
                PrimOps.prin1(object2);
                return Values.empty;
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "length", 1, object2);
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
}

