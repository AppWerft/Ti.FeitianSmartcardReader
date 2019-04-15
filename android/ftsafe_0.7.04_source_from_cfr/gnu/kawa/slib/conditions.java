/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEq;
import gnu.kawa.slib.condition;
import gnu.kawa.slib.condition-type;
import gnu.kawa.slib.srfi1;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.Sequences;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.util.Iterator;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.standard.Scheme;
import kawa.standard.append;

public class conditions
extends ModuleBody {
    public static final ModuleMethod make$Mncondition$Mntype;
    public static final ModuleMethod condition$Mntype$Qu;
    public static final ModuleMethod make$Mncondition;
    public static final ModuleMethod condition$Qu;
    public static final ModuleMethod condition$Mnhas$Mntype$Qu;
    public static final ModuleMethod condition$Mnref;
    public static final ModuleMethod message$Mncondition$Qu;
    public static final ModuleMethod serious$Mncondition$Qu;
    public static final ModuleMethod error$Qu;
    public static final ModuleMethod condition$Mnmessage;
    public static final ModuleMethod condition$Mntype$Mnfield$Mnsupertype;
    public static final ModuleMethod check$Mncondition$Mntype$Mnfield$Mnalist;
    public static final ModuleMethod make$Mncompound$Mncondition;
    public static final ModuleMethod extract$Mncondition;
    public static final Macro define$Mncondition$Mntype;
    public static final Macro condition;
    public static condition-type $Amcondition;
    public static condition-type $Ammessage;
    public static condition-type $Amserious;
    public static condition-type $Amerror;
    public static final int $Pcprovide$Pcsrfi$Mn35 = 123;
    public static final int $Pcprovide$Pccondition = 123;
    public static final int $Pcprovide$Pcconditions = 123;
    static final Class $Lscondition$Mntype$Gr;
    public static final Class $Prvt$$Lscondition$Gr;
    static final Macro condition$Mntype$Mnfield$Mnalist;
    public static final ModuleMethod $Prvt$type$Mnfield$Mnalist$Mn$Grcondition;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final PairWithPosition Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    public static conditions $instance;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SyntaxRules Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SyntaxRules Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final Object[] Lit27;
    static final SimpleSymbol Lit28;
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit30;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        $Amcondition = new condition-type(Lit0, Boolean.FALSE, LList.Empty, LList.Empty);
        $Ammessage = conditions.makeConditionType(Lit1, $Amcondition, Lit2);
        $Amserious = conditions.makeConditionType(Lit4, $Amcondition, LList.Empty);
        $Amerror = conditions.makeConditionType(Lit5, $Amserious, LList.Empty);
    }

    public static boolean isConditionType(Object obj) {
        return obj instanceof condition-type;
    }

    public static condition-type makeConditionType(Symbol name, condition-type supertype, Object fields) {
        if (!lists.isNull(srfi1.lsetIntersection$V(Scheme.isEq, supertype.all$Mnfields, new Object[]{fields}))) {
            Type.NeverReturns neverReturns = exceptions.error("duplicate field name");
            throw Special.reachedUnexpected;
        }
        return new condition-type(name, supertype, fields, append.append$V(new Object[]{supertype.all$Mnfields, fields}));
    }

    public static Object conditionTypeFieldSupertype(condition-type condition$Mntype, Object field) {
        Object object2;
        condition-type condition-type2 = condition$Mntype;
        do {
            condition-type condition$Mntype2;
            if ((condition$Mntype2 = condition-type2) == null) {
                object2 = Boolean.FALSE;
                break;
            }
            if (KawaConvert.isTrue(lists.memq(field, condition$Mntype2.fields))) {
                object2 = condition$Mntype2;
                break;
            }
            condition-type2 = (condition-type)Promise.force(condition$Mntype2.supertype, condition-type.class);
        } while (true);
        return object2;
    }

    public static boolean isCondition(Object obj) {
        return obj instanceof condition;
    }

    /*
     * Exception decompiling
     */
    public static condition makeCondition$V(condition-type type, Object[] argsArray) {
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object lambda1label(Object plist) {
        LList lList;
        if (lists.isNull(plist)) {
            lList = LList.Empty;
            return lList;
        }
        Object object2 = Promise.force(plist, Pair.class);
        try {
            lList = lists.cons(lists.cons(lists.car((Pair)object2), lists.cadr(plist)), conditions.lambda1label(lists.cddr(plist)));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        return lList;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static boolean isConditionHasType(Object condition2, condition-type type) {
        LList types;
        Object object2;
        Object object3 = conditions.conditionTypes(condition2);
        do {
            types = object3;
            object2 = Promise.force(types, Pair.class);
            object2 = Promise.force(lists.car((Pair)object2), condition-type.class);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        {
            block7 : {
                boolean x = conditions.isConditionSubtype((condition-type)object2, type);
                if (!x) break block7;
                return x;
            }
            object2 = Promise.force(types, Pair.class);
            object3 = lists.cdr((Pair)object2);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "condition-subtype?", 0, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    static LList conditionTypes(Object condition) {
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

    static boolean isConditionSubtype(condition-type subtype, condition-type supertype) {
        boolean bl;
        condition-type condition-type2 = subtype;
        do {
            condition-type subtype2;
            if ((subtype2 = condition-type2) == null) {
                bl = false;
                break;
            }
            if (subtype2 == supertype) {
                bl = true;
                break;
            }
            condition-type2 = (condition-type)Promise.force(subtype2.supertype, condition-type.class);
        } while (true);
        return bl;
    }

    public static Object conditionRef(condition condition2, Object field) {
        return conditions.typeFieldAlistRef(condition2.type$Mnfield$Mnalist, field);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object typeFieldAlistRef(Object type$Mnfield$Mnalist, Object field) {
        Object object2;
        Object type$Mnfield$Mnalist2;
        Object object3 = type$Mnfield$Mnalist;
        do {
            if (lists.isNull(type$Mnfield$Mnalist2 = object3)) {
                Type.NeverReturns neverReturns = exceptions.error("type-field-alist-ref: field not found", type$Mnfield$Mnalist2, field);
                throw Special.reachedUnexpected;
            }
            object2 = Promise.force(type$Mnfield$Mnalist2, Pair.class);
            object2 = Promise.force(lists.car((Pair)object2), Pair.class);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        {
            Object temp = lists.assq(field, lists.cdr((Pair)object2));
            if (KawaConvert.isTrue(temp)) {
                object2 = Promise.force(temp, Pair.class);
                return lists.cdr((Pair)object2);
            }
            object2 = Promise.force(type$Mnfield$Mnalist2, Pair.class);
            object3 = lists.cdr((Pair)object2);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    public static condition makeCompoundCondition$V(Object condition$Mn1, Object[] argsArray) {
        Object object2 = LList.makeList(argsArray, 0);
        LList conditions2 = object2;
        Iterator iterator = Sequences.getIterator(lists.cons(condition$Mn1, conditions2));
        LList lList = LList.Empty;
        Pair pair = null;
        while (iterator.hasNext()) {
            Pair pair2;
            Object e = iterator.next();
            if (pair == null) {
                pair2 = new Pair(((Procedure)Scheme.applyToArgs).apply2(condition$Mntype$Mnfield$Mnalist, e), LList.Empty);
            } else {
                pair2 = lList;
                pair.setCdr(lList);
            }
            pair = pair2;
        }
        object2 = ((Procedure)Scheme.apply).apply2(append.append, lList);
        return new condition(object2);
    }

    /*
     * Exception decompiling
     */
    public static condition extractCondition(condition condition, condition-type type) {
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
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static condition typeFieldAlist$To$Condition(Object type$Mnfield$Mnalist) {
        Object object3;
        Iterator iterator = Sequences.getIterator(type$Mnfield$Mnalist);
        LList lList = LList.Empty;
        Pair pair = null;
        do {
            Pair pair3;
            Pair pair4;
            Pair pair2;
            if (!iterator.hasNext()) {
                EmptyList emptyList = lList;
                return new condition(emptyList);
            }
            Object e = iterator.next();
            Object object2 = Promise.force(e, Pair.class);
            Object object5 = object2;
            Object object22 = Promise.force(e, Pair.class);
            try {
                object5 = Sequences.getIterator(((condition-type)Promise.force((Object)lists.car((Pair)((Pair)object22)), condition-type.class)).all$Mnfields);
                object22 = LList.Empty;
                pair4 = null;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, object22);
            }
            while (object5.hasNext()) {
                Pair pair5;
                Object e2 = object5.next();
                object3 = Promise.force(e, Pair.class);
                Object x = lists.assq(e2, lists.cdr((Pair)object3));
                if (pair4 == null) {
                    pair5 = new Pair(KawaConvert.isTrue(x) ? x : lists.cons(e2, conditions.typeFieldAlistRef(type$Mnfield$Mnalist, e2)), LList.Empty);
                } else {
                    pair5 = object22;
                    pair4.setCdr(object22);
                }
                pair4 = pair5;
            }
            {
                pair3 = lists.cons(lists.car((Pair)object2), object22);
            }
            if (pair == null) {
                pair2 = new Pair(pair3, LList.Empty);
            } else {
                pair2 = lList;
                pair.setCdr(lList);
            }
            pair = pair2;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object checkConditionTypeFieldAlist(Object the$Mntype$Mnfield$Mnalist) {
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

    public static boolean isMessageCondition(Object thing) {
        return conditions.isCondition(thing) ? conditions.isConditionHasType(thing, $Ammessage) : false;
    }

    public static Object conditionMessage(Object condition2) {
        Object object2 = Promise.force(condition2, condition.class);
        try {
            return conditions.conditionRef(conditions.extractCondition((condition)object2, $Ammessage), Lit3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "extract-condition", 0, object2);
        }
    }

    public static boolean isSeriousCondition(Object thing) {
        return conditions.isCondition(thing) ? conditions.isConditionHasType(thing, $Amserious) : false;
    }

    public static boolean isError(Object thing) {
        return conditions.isCondition(thing) ? conditions.isConditionHasType(thing, $Amerror) : false;
    }

    public static {
        Lit30 = Symbol.valueOf("thing");
        Lit29 = PairWithPosition.make(Lit30, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 339996);
        Lit28 = Symbol.valueOf("quote");
        Lit27 = new Object[0];
        Lit26 = Symbol.valueOf("error?");
        Lit25 = Symbol.valueOf("serious-condition?");
        Lit24 = Symbol.valueOf("condition-message");
        Lit23 = Symbol.valueOf("message-condition?");
        Lit22 = Symbol.valueOf("check-condition-type-field-alist");
        Lit21 = Symbol.valueOf("type-field-alist->condition");
        Lit19 = Symbol.valueOf("condition");
        Lit20 = new SyntaxRules(Lit27, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018]\f\u0007-\f\u000f\f\u0017\b\b\u0010\b\u0000\u0018\b", Lit27, 3, "conditions.scm:183"), "\u0003\u0005\u0005", "\u0011\u0018\u0004\b\u0011\u0018\f\b\u0005\u0011\u0018\u0014\t\u0003\b\u0011\u0018\f\b\r\u0011\u0018\u0014)\u0011\u0018\u001c\b\u000b\b\u0013", new Object[]{Lit21, Symbol.valueOf("list"), Symbol.valueOf("cons"), Lit28}, 2)}, 3, Lit19);
        Lit18 = Symbol.valueOf("extract-condition");
        Lit17 = Symbol.valueOf("make-compound-condition");
        Lit16 = Symbol.valueOf("condition-ref");
        Lit14 = Symbol.valueOf("condition-type-field-alist");
        Lit15 = new SyntaxRules(Lit27, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit27, 1, "conditions.scm:144"), "\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\u0011\u0018\u0014\b\u0003", new Object[]{PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Symbol.valueOf("*"), Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf(".type-field-alist"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 593927), Symbol.valueOf("as"), Symbol.valueOf("<condition>")}, 0)}, 1, Lit14);
        Lit13 = Symbol.valueOf("condition-has-type?");
        Lit12 = Symbol.valueOf("make-condition");
        Lit11 = Symbol.valueOf("condition?");
        Lit10 = Symbol.valueOf("condition-type-field-supertype");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[13];
        arrobject[0] = Symbol.valueOf("begin");
        arrobject[1] = Symbol.valueOf("define");
        Lit7 = Symbol.valueOf("make-condition-type");
        arrobject[2] = Lit7;
        arrobject[3] = Lit28;
        arrobject[4] = Lit29;
        arrobject[5] = Symbol.valueOf("and");
        arrobject[6] = PairWithPosition.make(Lit11, Lit29, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 344079);
        arrobject[7] = Lit13;
        arrobject[8] = Lit30;
        arrobject[9] = PairWithPosition.make(Lit19, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 352284);
        arrobject[10] = Lit16;
        arrobject[11] = Lit18;
        arrobject[12] = Lit19;
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017-\f\u001f\f'\b\u0018\u0010\b", Lit27, 5, "conditions.scm:76"), "\u0001\u0001\u0001\u0003\u0003", "\u0011\u0018\u0004\u00c9\u0011\u0018\f\t\u0003\b\u0011\u0018\u0014)\u0011\u0018\u001c\b\u0003\t\u000b\b\u0011\u0018\u001c\b\b\u001d\u001b\u00c1\u0011\u0018\f!\t\u0013\u0018$\b\u0011\u0018,\u0011\u00184\b\u0011\u0018<\u0011\u0018D\b\u0003\b%\u0011\u0018\f!\t#\u0018L\b\u0011\u0018TA\u0011\u0018\\\u0011\u0018d\b\u0003\b\u0011\u0018\u001c\b\u001b", arrobject, 1);
        Lit8 = Symbol.valueOf("define-condition-type");
        Lit9 = new SyntaxRules(Lit27, arrsyntaxRule, 5, Lit8);
        Lit6 = Symbol.valueOf("condition-type?");
        Lit5 = Symbol.valueOf("&error");
        Lit4 = Symbol.valueOf("&serious");
        Lit3 = Symbol.valueOf("message");
        Lit2 = PairWithPosition.make(Lit3, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/conditions.scm", 937987);
        Lit1 = Symbol.valueOf("&message");
        Lit0 = Symbol.valueOf("&condition");
        $instance = new conditions();
        $Lscondition$Mntype$Gr = condition-type.class;
        conditions conditions2 = $instance;
        condition$Mntype$Qu = new ModuleMethod(conditions2, 2, Lit6, 4097);
        make$Mncondition$Mntype = new ModuleMethod(conditions2, 3, Lit7, 12291);
        define$Mncondition$Mntype = Macro.make(Lit8, Lit9, "gnu.kawa.slib.conditions");
        condition$Mntype$Mnfield$Mnsupertype = new ModuleMethod(conditions2, 4, Lit10, 8194);
        $Prvt$$Lscondition$Gr = condition.class;
        condition$Qu = new ModuleMethod(conditions2, 5, Lit11, 4097);
        make$Mncondition = new ModuleMethod(conditions2, 6, Lit12, -4095);
        condition$Mnhas$Mntype$Qu = new ModuleMethod(conditions2, 7, Lit13, 8194);
        condition$Mntype$Mnfield$Mnalist = Macro.make(Lit14, Lit15, "gnu.kawa.slib.conditions");
        condition$Mnref = new ModuleMethod(conditions2, 8, Lit16, 8194);
        make$Mncompound$Mncondition = new ModuleMethod(conditions2, 9, Lit17, -4095);
        extract$Mncondition = new ModuleMethod(conditions2, 10, Lit18, 8194);
        condition = Macro.make(Lit19, Lit20, "gnu.kawa.slib.conditions");
        $Prvt$type$Mnfield$Mnalist$Mn$Grcondition = new ModuleMethod(conditions2, 11, Lit21, 4097);
        check$Mncondition$Mntype$Mnfield$Mnalist = new ModuleMethod(conditions2, 12, Lit22, 4097);
        message$Mncondition$Qu = new ModuleMethod(conditions2, 13, Lit23, 4097);
        condition$Mnmessage = new ModuleMethod(conditions2, 14, Lit24, 4097);
        serious$Mncondition$Qu = new ModuleMethod(conditions2, 15, Lit25, 4097);
        error$Qu = new ModuleMethod(conditions2, 16, Lit26, 4097);
        conditions.$runBody$();
    }

    public conditions() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 16: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
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
            case 13: {
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
                callContext.value1 = object2;
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
            case 10: {
                Object object4 = Promise.force(object2, condition.class);
                if (!(object4 instanceof condition)) {
                    return -786431;
                }
                callContext.value1 = object4;
                Object object5 = Promise.force(object3, condition-type.class);
                if (!(object5 instanceof condition-type)) {
                    return -786430;
                }
                callContext.value2 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 8: {
                Object object6 = Promise.force(object2, condition.class);
                if (!(object6 instanceof condition)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 7: {
                callContext.value1 = object2;
                Object object7 = Promise.force(object3, condition-type.class);
                if (!(object7 instanceof condition-type)) {
                    return -786430;
                }
                callContext.value2 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 4: {
                Object object8 = Promise.force(object2, condition-type.class);
                if (!(object8 instanceof condition-type)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        if (moduleMethod.selector == 3) {
            Object object5 = Promise.force(object2, Symbol.class);
            if (!(object5 instanceof Symbol)) {
                return -786431;
            }
            callContext.value1 = object5;
            Object object6 = Promise.force(object3, condition-type.class);
            if (!(object6 instanceof condition-type)) {
                return -786430;
            }
            callContext.value2 = object6;
            callContext.value3 = object4;
            callContext.proc = moduleMethod;
            callContext.pc = 3;
            return 0;
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 9: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 6: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
        }
        return super.matchN(moduleMethod, arrobject, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 2: {
                return conditions.isConditionType(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 5: {
                return conditions.isCondition(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 11: {
                return conditions.typeFieldAlist$To$Condition(object2);
            }
            case 12: {
                return conditions.checkConditionTypeFieldAlist(object2);
            }
            case 13: {
                return conditions.isMessageCondition(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 14: {
                return conditions.conditionMessage(object2);
            }
            case 15: {
                return conditions.isSeriousCondition(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 16: {
                return conditions.isError(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
        }
        return super.apply1(moduleMethod, object2);
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

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 6: {
                Object object2 = Promise.force(arrobject[0], condition-type.class);
                int n = arrobject.length - 1;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 1];
                }
                return conditions.makeCondition$V((condition-type)object2, arrobject2);
            }
            case 9: {
                int n = arrobject.length - 1;
                Object[] arrobject3 = new Object[n];
                while (--n >= 0) {
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 1];
                }
                return conditions.makeCompoundCondition$V(arrobject[0], arrobject3);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }

}

