/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.lispexpr.ReadTableEntry;
import gnu.kawa.lispexpr.ReaderDispatch;
import gnu.kawa.lispexpr.ReaderDispatchMacro;
import gnu.kawa.lispexpr.ReaderMacro;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;

public class readtable
extends ModuleBody {
    public static final ModuleMethod current$Mnreadtable;
    public static final ModuleMethod readtable$Qu;
    public static final ModuleMethod set$Mnmacro$Mncharacter;
    public static final ModuleMethod make$Mndispatch$Mnmacro$Mncharacter;
    public static final ModuleMethod set$Mndispatch$Mnmacro$Mncharacter;
    public static final ModuleMethod get$Mndispatch$Mnmacro$Mntable;
    public static final ModuleMethod define$Mnreader$Mnctor;
    public static readtable $instance;
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

    public static ReadTable currentReadtable() {
        return ReadTable.getCurrent();
    }

    public static boolean isReadtable(Object obj) {
        return obj instanceof ReadTable;
    }

    public static void setMacroCharacter(char c, Object object2) {
        readtable.setMacroCharacter(c, object2, false);
    }

    public static void setMacroCharacter(char c, Object object2, boolean bl) {
        readtable.setMacroCharacter(c, object2, bl, readtable.currentReadtable());
    }

    public static void setMacroCharacter(char c, Object function2, boolean non$Mnterminating, ReadTable readtable2) {
        Object object2 = Promise.force(function2, Procedure.class);
        try {
            readtable2.set(c, new ReaderMacro((Procedure)object2, non$Mnterminating));
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.lispexpr.ReaderMacro.<init>(gnu.mapping.Procedure,boolean)", 1, object2);
        }
    }

    public static void makeDispatchMacroCharacter(char c) {
        readtable.makeDispatchMacroCharacter(c, false);
    }

    public static void makeDispatchMacroCharacter(char c, boolean bl) {
        readtable.makeDispatchMacroCharacter(c, bl, readtable.currentReadtable());
    }

    public static void makeDispatchMacroCharacter(char c, boolean non$Mnterminating, ReadTable readtable2) {
        readtable2.set(c, new ReaderDispatch(non$Mnterminating));
    }

    public static void setDispatchMacroCharacter(char c, char c2, Object object2) {
        readtable.setDispatchMacroCharacter(c, c2, object2, readtable.currentReadtable());
    }

    public static void setDispatchMacroCharacter(char disp$Mnchar, char sub$Mnchar, Object function2, ReadTable readtable2) {
        ReaderDispatch entry;
        Object object2 = readtable2.lookup(disp$Mnchar);
        try {
            entry = (ReaderDispatch)object2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "entry", -2, object2);
        }
        object2 = Promise.force(function2, Procedure.class);
        try {
            entry.set(sub$Mnchar, new ReaderDispatchMacro((Procedure)object2));
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.kawa.lispexpr.ReaderDispatchMacro.<init>(gnu.mapping.Procedure)", 1, object2);
        }
    }

    public static Object getDispatchMacroTable(char c, char c2) {
        return readtable.getDispatchMacroTable(c, c2, readtable.currentReadtable());
    }

    public static Object getDispatchMacroTable(char disp$Mnchar, char sub$Mnchar, ReadTable readtable2) {
        ReadTableEntry sub$Mnentry;
        ReaderDispatch disp$Mnentry;
        ReadTableEntry readTableEntry = readtable2.lookup(disp$Mnchar);
        try {
            disp$Mnentry = (ReaderDispatch)readTableEntry;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "disp-entry", -2, (Object)sub$Mnentry);
        }
        sub$Mnentry = disp$Mnentry.lookup(sub$Mnchar);
        return sub$Mnentry == null ? Boolean.FALSE : sub$Mnentry;
    }

    public static void defineReaderCtor(SimpleSymbol simpleSymbol, Procedure procedure) {
        readtable.defineReaderCtor(simpleSymbol, procedure, readtable.currentReadtable());
    }

    public static void defineReaderCtor(SimpleSymbol key, Procedure proc, ReadTable readtable2) {
        readtable2.putReaderCtor(key.getName(), proc);
    }

    public static {
        Lit6 = Symbol.valueOf("define-reader-ctor");
        Lit5 = Symbol.valueOf("get-dispatch-macro-table");
        Lit4 = Symbol.valueOf("set-dispatch-macro-character");
        Lit3 = Symbol.valueOf("make-dispatch-macro-character");
        Lit2 = Symbol.valueOf("set-macro-character");
        Lit1 = Symbol.valueOf("readtable?");
        Lit0 = Symbol.valueOf("current-readtable");
        readtable readtable2 = $instance = new readtable();
        current$Mnreadtable = new ModuleMethod(readtable2, 1, Lit0, 0);
        readtable$Qu = new ModuleMethod(readtable2, 2, Lit1, 4097);
        set$Mnmacro$Mncharacter = new ModuleMethod(readtable2, 3, Lit2, 16386);
        make$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod(readtable2, 6, Lit3, 12289);
        set$Mndispatch$Mnmacro$Mncharacter = new ModuleMethod(readtable2, 9, Lit4, 16387);
        get$Mndispatch$Mnmacro$Mntable = new ModuleMethod(readtable2, 11, Lit5, 12290);
        define$Mnreader$Mnctor = new ModuleMethod(readtable2, 13, Lit6, 12290);
        readtable.$runBody$();
    }

    public readtable() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.proc = moduleMethod;
            callContext.pc = 0;
            return 0;
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 6: {
                Object object3 = Promise.force(object2);
                if (Char.checkCharOrEof(object3) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object3;
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
            case 13: {
                Object object4 = Promise.force(object2, SimpleSymbol.class);
                if (!(object4 instanceof SimpleSymbol)) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 11: {
                Object object6 = Promise.force(object2);
                if (Char.checkCharOrEof(object6) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3);
                if (Char.checkCharOrEof(object7) >>> 16 != 0) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 6: {
                Object object8 = Promise.force(object2);
                if (Char.checkCharOrEof(object8) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3);
                if (!(object9 instanceof Boolean)) {
                    return -786430;
                }
                callContext.value2 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 3: {
                Object object10 = Promise.force(object2);
                if (Char.checkCharOrEof(object10) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object10;
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
            case 13: {
                Object object5 = Promise.force(object2, SimpleSymbol.class);
                if (!(object5 instanceof SimpleSymbol)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                    return -786430;
                }
                callContext.value2 = object6;
                Object object7 = Promise.force(object4, ReadTable.class);
                if (!(object7 instanceof ReadTable)) {
                    return -786429;
                }
                callContext.value3 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 11: {
                Object object8 = Promise.force(object2);
                if (Char.checkCharOrEof(object8) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object8;
                Object object9 = Promise.force(object3);
                if (Char.checkCharOrEof(object9) >>> 16 != 0) {
                    return -786430;
                }
                callContext.value2 = object9;
                Object object10 = Promise.force(object4, ReadTable.class);
                if (!(object10 instanceof ReadTable)) {
                    return -786429;
                }
                callContext.value3 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 9: {
                Object object11 = Promise.force(object2);
                if (Char.checkCharOrEof(object11) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object11;
                Object object12 = Promise.force(object3);
                if (Char.checkCharOrEof(object12) >>> 16 != 0) {
                    return -786430;
                }
                callContext.value2 = object12;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 6: {
                Object object13 = Promise.force(object2);
                if (Char.checkCharOrEof(object13) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object13;
                Object object14 = Promise.force(object3);
                if (!(object14 instanceof Boolean)) {
                    return -786430;
                }
                callContext.value2 = object14;
                Object object15 = Promise.force(object4, ReadTable.class);
                if (!(object15 instanceof ReadTable)) {
                    return -786429;
                }
                callContext.value3 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 3: {
                Object object16 = Promise.force(object2);
                if (Char.checkCharOrEof(object16) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.value2 = object3;
                Object object17 = Promise.force(object4);
                if (!(object17 instanceof Boolean)) {
                    return -786429;
                }
                callContext.value3 = object17;
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
                Object object6 = Promise.force(object2);
                if (Char.checkCharOrEof(object6) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object6;
                Object object7 = Promise.force(object3);
                if (Char.checkCharOrEof(object7) >>> 16 != 0) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.value3 = object4;
                Object object8 = Promise.force(object5, ReadTable.class);
                if (!(object8 instanceof ReadTable)) {
                    return -786428;
                }
                callContext.value4 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 4;
                return 0;
            }
            case 3: {
                Object object9 = Promise.force(object2);
                if (Char.checkCharOrEof(object9) >>> 16 != 0) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = object3;
                Object object10 = Promise.force(object4);
                if (!(object10 instanceof Boolean)) {
                    return -786429;
                }
                callContext.value3 = object10;
                Object object11 = Promise.force(object5, ReadTable.class);
                if (!(object11 instanceof ReadTable)) {
                    return -786428;
                }
                callContext.value4 = object11;
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

    public Object apply0(ModuleMethod moduleMethod) {
        if (moduleMethod.selector == 1) {
            return readtable.currentReadtable();
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
                Boolean bl;
                if (readtable.isReadtable(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 6: {
                readtable.makeDispatchMacroCharacter(Char.castToChar(Promise.force(object2)));
                return Values.empty;
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "make-dispatch-macro-character", 1, object2);
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

