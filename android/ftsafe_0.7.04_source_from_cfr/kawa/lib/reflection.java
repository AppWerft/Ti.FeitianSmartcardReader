/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Mangling;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.GetFieldProc;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Record;
import kawa.lang.RecordConstructor;
import kawa.lang.SetFieldProc;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.std_syntax;
import kawa.standard.syntax_case;

public class reflection
extends ModuleBody {
    public static final Macro primitive$Mnconstructor;
    public static final ModuleMethod make$Mnrecord$Mntype;
    public static final ModuleMethod record$Mnconstructor;
    public static final ModuleMethod record$Mnaccessor;
    public static final ModuleMethod record$Mnmodifier;
    public static final ModuleMethod record$Qu;
    public static final ModuleMethod record$Mnpredicate;
    public static final ModuleMethod record$Mntype$Mndescriptor;
    public static final ModuleMethod record$Mntype$Mnname;
    public static final ModuleMethod record$Mntype$Mnfield$Mnnames;
    public static final Macro primitive$Mnarray$Mnnew;
    public static final Macro primitive$Mnarray$Mnset;
    public static final Macro primitive$Mnarray$Mnget;
    public static final Macro primitive$Mnarray$Mnlength;
    public static final Macro primitive$Mnget$Mnfield;
    public static final Macro primitive$Mnset$Mnfield;
    public static final Macro primitive$Mnget$Mnstatic;
    public static final Macro primitive$Mnset$Mnstatic;
    public static final ModuleMethod subtype$Qu;
    public static reflection $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxPattern Lit1;
    static final SyntaxTemplate Lit2;
    static final SyntaxPattern Lit3;
    static final SyntaxTemplate Lit4;
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
    static final SyntaxRules Lit15;
    static final SimpleSymbol Lit16;
    static final SyntaxRules Lit17;
    static final SimpleSymbol Lit18;
    static final SyntaxRules Lit19;
    static final SimpleSymbol Lit20;
    static final SyntaxRules Lit21;
    static final SimpleSymbol Lit22;
    static final SyntaxRules Lit23;
    static final SimpleSymbol Lit24;
    static final SyntaxRules Lit25;
    static final SimpleSymbol Lit26;
    static final SyntaxRules Lit27;
    static final SimpleSymbol Lit28;
    static final SyntaxRules Lit29;
    static final SimpleSymbol Lit30;
    static final Object[] Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final PairWithPosition Lit34;
    static final PairWithPosition Lit35;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static ClassType makeRecordType(String name, LList fnames) {
        return Record.makeRecordType(name, fnames);
    }

    public static RecordConstructor recordConstructor(ClassType classType) {
        return reflection.recordConstructor(classType, null);
    }

    public static RecordConstructor recordConstructor(ClassType cl, Object flds) {
        return new RecordConstructor(cl, flds);
    }

    public static GetFieldProc recordAccessor(ClassType classType, String fname) {
        return new GetFieldProc(classType, fname);
    }

    public static SetFieldProc recordModifier(ClassType classType, String fname) {
        return new SetFieldProc(classType, fname);
    }

    public static boolean isRecord(Object obj) {
        return obj instanceof Record;
    }

    public static Procedure recordPredicate(Object rtype) {
        public class Frame
        extends ModuleBody {
            Object rtype;
            final ModuleMethod lambda$Fn1;

            public Frame() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm:30");
                this.lambda$Fn1 = moduleMethod;
            }

            boolean lambda1(Object object2) {
                Object object3 = Promise.force(this.rtype, Type.class);
                try {
                    return ((Type)object3).isInstance(object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "gnu.bytecode.Type.isInstance(java.lang.Object)", 1, object3);
                }
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 1) {
                    callContext.value1 = object2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, object2, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply1(ModuleMethod moduleMethod, Object object2) {
                if (moduleMethod.selector == 1) {
                    return this.lambda1(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.rtype = rtype;
        return $heapFrame.lambda$Fn1;
    }

    public static Type recordTypeDescriptor(Object object2) {
        return Type.make(object2.getClass());
    }

    public static String recordTypeName(ClassType rtd) {
        return Mangling.demangleName(rtd.getName(), true);
    }

    public static LList recordTypeFieldNames(Object rtd) {
        Object object2 = Promise.force(rtd, ClassType.class);
        try {
            return Record.typeFieldNames(LangObjType.coerceToClassType(object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "kawa.lang.Record.typeFieldNames(class-type)", 1, object2);
        }
    }

    public static boolean isSubtype(Type t1, Type t2) {
        return t1.isSubtype(t2);
    }

    public static {
        Lit35 = PairWithPosition.make(IntNum.valueOf(1), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm", 397335);
        Lit34 = PairWithPosition.make(IntNum.valueOf(9), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/reflection.scm", 450583);
        Lit33 = Symbol.valueOf("make");
        Lit32 = Symbol.valueOf("constant-fold");
        Lit31 = new Object[0];
        Lit30 = Symbol.valueOf("subtype?");
        Lit28 = Symbol.valueOf("primitive-set-static");
        Lit29 = new SyntaxRules(Lit31, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit31, 3, "reflection.scm:107"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0003\t\u000b\t\u0013\u0018\u001c", new Object[]{Lit32, Lit33, Symbol.valueOf("<gnu.kawa.reflect.StaticSet>"), Lit34}, 0)}, 3, Lit28);
        Lit26 = Symbol.valueOf("primitive-get-static");
        Lit27 = new SyntaxRules(Lit31, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit31, 3, "reflection.scm:101"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0003\t\u000b\t\u0013\u0018\u001c", new Object[]{Lit32, Lit33, Symbol.valueOf("<gnu.kawa.reflect.StaticGet>"), Lit34}, 0)}, 3, Lit26);
        Lit24 = Symbol.valueOf("primitive-set-field");
        Lit25 = new SyntaxRules(Lit31, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit31, 3, "reflection.scm:94"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0003\t\u000b\t\u0013\u0018\u001c", new Object[]{Lit32, Lit33, Symbol.valueOf("<kawa.lang.SetFieldProc>"), Lit35}, 0)}, 3, Lit24);
        Lit22 = Symbol.valueOf("primitive-get-field");
        Lit23 = new SyntaxRules(Lit31, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit31, 3, "reflection.scm:88"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\t\u0003\t\u000b\t\u0013\u0018\u001c", new Object[]{Lit32, Lit33, Symbol.valueOf("<kawa.lang.GetFieldProc>"), Lit35}, 0)}, 3, Lit22);
        Lit20 = Symbol.valueOf("primitive-array-length");
        Lit21 = new SyntaxRules(Lit31, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit31, 1, "reflection.scm:83"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[]{Lit32, Lit33, Symbol.valueOf("<gnu.kawa.reflect.ArrayLength>")}, 0)}, 1, Lit20);
        Lit18 = Symbol.valueOf("primitive-array-get");
        Lit19 = new SyntaxRules(Lit31, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit31, 1, "reflection.scm:77"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[]{Lit32, Lit33, Symbol.valueOf("<gnu.kawa.reflect.ArrayGet>")}, 0)}, 1, Lit18);
        Lit16 = Symbol.valueOf("primitive-array-set");
        Lit17 = new SyntaxRules(Lit31, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit31, 1, "reflection.scm:71"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[]{Lit32, Lit33, Symbol.valueOf("<gnu.kawa.reflect.ArraySet>")}, 0)}, 1, Lit16);
        Lit14 = Symbol.valueOf("primitive-array-new");
        Lit15 = new SyntaxRules(Lit31, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit31, 1, "reflection.scm:65"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[]{Lit32, Lit33, Symbol.valueOf("<gnu.kawa.reflect.ArrayNew>")}, 0)}, 1, Lit14);
        Lit13 = Symbol.valueOf("record-type-field-names");
        Lit12 = Symbol.valueOf("record-type-name");
        Lit11 = Symbol.valueOf("record-type-descriptor");
        Lit10 = Symbol.valueOf("record-predicate");
        Lit9 = Symbol.valueOf("record?");
        Lit8 = Symbol.valueOf("record-modifier");
        Lit7 = Symbol.valueOf("record-accessor");
        Lit6 = Symbol.valueOf("record-constructor");
        Lit5 = Symbol.valueOf("make-record-type");
        Lit4 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0011\u0018\u0004\u0019\b\u0015\u0013\u0011\u0018\f\t\u0003\b\u0011\u0018\u0014\t\u0003\b\r\u0011\u0018\u001c\t\u000b\b\u0013", new Object[]{Symbol.valueOf("lambda"), Symbol.valueOf("::"), Lit33, Symbol.valueOf("as")}, 1);
        Lit3 = new SyntaxPattern("\r\u0017\u0010\b\b", Lit31, 3, "reflection.scm:8");
        Lit2 = new SyntaxTemplate("\u0001\u0003", "\b\r\u000b", Lit31, 1);
        Lit1 = new SyntaxPattern("\f\u0018\f\u0007,\r\u000f\b\b\b\b", Lit31, 2, "reflection.scm:6");
        Lit0 = Symbol.valueOf("primitive-constructor");
        reflection reflection2 = $instance = new reflection();
        primitive$Mnconstructor = Macro.make(Lit0, new ModuleMethod(reflection2, 2, null, 4097), "kawa.lib.reflection");
        reflection reflection3 = $instance;
        make$Mnrecord$Mntype = new ModuleMethod(reflection3, 3, Lit5, 8194);
        record$Mnconstructor = new ModuleMethod(reflection3, 4, Lit6, 8193);
        record$Mnaccessor = new ModuleMethod(reflection3, 6, Lit7, 8194);
        record$Mnmodifier = new ModuleMethod(reflection3, 7, Lit8, 8194);
        record$Qu = new ModuleMethod(reflection3, 8, Lit9, 4097);
        record$Mnpredicate = new ModuleMethod(reflection3, 9, Lit10, 4097);
        record$Mntype$Mndescriptor = new ModuleMethod(reflection3, 10, Lit11, 4097);
        record$Mntype$Mnname = new ModuleMethod(reflection3, 11, Lit12, 4097);
        record$Mntype$Mnfield$Mnnames = new ModuleMethod(reflection3, 12, Lit13, 4097);
        primitive$Mnarray$Mnnew = Macro.make(Lit14, Lit15, "kawa.lib.reflection");
        primitive$Mnarray$Mnset = Macro.make(Lit16, Lit17, "kawa.lib.reflection");
        primitive$Mnarray$Mnget = Macro.make(Lit18, Lit19, "kawa.lib.reflection");
        primitive$Mnarray$Mnlength = Macro.make(Lit20, Lit21, "kawa.lib.reflection");
        primitive$Mnget$Mnfield = Macro.make(Lit22, Lit23, "kawa.lib.reflection");
        primitive$Mnset$Mnfield = Macro.make(Lit24, Lit25, "kawa.lib.reflection");
        primitive$Mnget$Mnstatic = Macro.make(Lit26, Lit27, "kawa.lib.reflection");
        primitive$Mnset$Mnstatic = Macro.make(Lit28, Lit29, "kawa.lib.reflection");
        subtype$Qu = new ModuleMethod(reflection3, 13, Lit30, 8194);
        reflection.$runBody$();
    }

    public reflection() {
        ModuleInfo.register(this);
    }

    static Object lambda2(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit1).match(form, arrobject, 0)) {
            Object[] arrobject2 = TemplateScope.make();
            Object object4 = std_syntax.generateTemporaries(Lit2.execute(arrobject, (TemplateScope)arrobject2));
            arrobject2 = SyntaxPattern.allocVars(3, arrobject);
            if (((Pattern)Lit3).match(object4, arrobject2, 0)) {
                TemplateScope templateScope = TemplateScope.make();
                object2 = Lit4.execute(arrobject2, templateScope);
            } else {
                object2 = syntax_case.error("syntax-case", object4);
            }
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 2: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 12: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 11: {
                Object object3 = Promise.force(object2, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(object3) == null) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 8: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object4 = Promise.force(object2, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(object4) == null) {
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
            case 13: {
                Object object4 = Promise.force(object2, Type.class);
                if (LangObjType.coerceToTypeOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, Type.class);
                if (LangObjType.coerceToTypeOrNull(object5) == null) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                Object object6 = Promise.force(object2, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = Promise.force(object3, String.class);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 6: {
                Object object7 = Promise.force(object2, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = Promise.force(object3, String.class);
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 4: {
                Object object8 = Promise.force(object2, ClassType.class);
                if (LangObjType.coerceToClassTypeOrNull(object8) == null) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 3: {
                callContext.value1 = Promise.force(object2, String.class);
                Object object9 = Promise.force(object3, LList.class);
                if (!(object9 instanceof LList)) {
                    return -786430;
                }
                callContext.value2 = object9;
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 4: {
                return reflection.recordConstructor(LangObjType.coerceToClassType(Promise.force(object2, ClassType.class)));
            }
            case 8: {
                Boolean bl;
                if (reflection.isRecord(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 9: {
                return reflection.recordPredicate(object2);
            }
            case 10: {
                return reflection.recordTypeDescriptor(object2);
            }
            case 11: {
                return reflection.recordTypeName(LangObjType.coerceToClassType(Promise.force(object2, ClassType.class)));
            }
            case 12: {
                return reflection.recordTypeFieldNames(object2);
            }
            case 2: {
                return reflection.lambda2(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "record-constructor", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "record-type-name", 1, object2);
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

}

