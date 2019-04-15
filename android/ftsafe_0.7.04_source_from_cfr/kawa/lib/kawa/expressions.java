/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.kawa;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.InlineCalls;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.MakeSplice;
import gnu.kawa.functions.Map;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.standard.syntax_case;

public class expressions
extends ModuleBody {
    public static final ModuleMethod $Mn$Grexp;
    public static final ModuleMethod get$Mnvisitor;
    public static final ModuleMethod get$Mncompilation;
    public static final ModuleMethod visit$Mnexp;
    public static final Macro syntax$Mnas$Mnexp;
    public static final Macro define$Mnvalidate;
    public static final ModuleMethod apply$Mnexp;
    public static final ModuleMethod begin$Mnexp;
    public static final ModuleMethod if$Mnexp;
    public static final ModuleMethod set$Mnexp;
    public static final ModuleMethod apply$Mnto$Mnargs$Mnexp;
    public static final Class Declaration;
    public static final Class Expression;
    public static final Class ApplyExp;
    public static final Class QuoteExp;
    public static final Class ReferenceExp;
    public static final Class Compilation;
    public static final Class Type;
    public static final StaticFieldLocation $Prvt$define;
    public static final StaticFieldLocation $Prvt$cond;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$else;
    static final ClassType Lit0;
    public static expressions $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SyntaxPattern Lit6;
    static final SyntaxTemplate Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final Object[] Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final PairWithPosition Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Expression $To$Exp(Object obj) {
        return obj instanceof Expression ? (Expression)Promise.force(obj, Expression.class) : (obj instanceof Declaration ? new ReferenceExp((Declaration)Promise.force(obj, Declaration.class)) : QuoteExp.getInstance(obj));
    }

    public static InlineCalls getVisitor() {
        return InlineCalls.currentVisitor.get();
    }

    public static Compilation getCompilation() {
        return expressions.getVisitor().getCompilation();
    }

    public static Expression visitExp(Expression expression) {
        return expressions.visitExp(expression, null);
    }

    public static Expression visitExp(Expression exp, Type required) {
        return expressions.getVisitor().visit(exp, required);
    }

    public static ApplyExp applyExp$V(Object func, Object[] argsArray) {
        LList lList;
        LList args = lList = LList.makeList(argsArray, 0);
        int n = 2;
        Expression expression = expressions.$To$Exp(func);
        Object object2 = Map.map1((Procedure)$Mn$Grexp, args);
        int n2 = MakeSplice.count(object2);
        n = n2 + n;
        Object[] arrobject = new Object[n];
        arrobject[0] = ApplyExp;
        arrobject[1] = expression;
        int n3 = 2;
        MakeSplice.copyTo(arrobject, n3, n2, object2);
        n3 += n2;
        return (ApplyExp)Promise.force(((Procedure)Invoke.make).applyN(arrobject), ApplyExp.class);
    }

    public static Object applyToArgsExp$V(Object func, Object[] argsArray) {
        Object object2;
        LList lList;
        LList args = lList = LList.makeList(argsArray, 0);
        Expression fexp = expressions.$To$Exp(func);
        Compilation comp = expressions.getCompilation();
        Expression applyFunction = comp.applyFunction(fexp);
        if (applyFunction == null) {
            int n = 2;
            Expression expression = expressions.$To$Exp(func);
            Object object3 = Map.map1((Procedure)$Mn$Grexp, args);
            int n2 = MakeSplice.count(object3);
            n = n2 + n;
            Object[] arrobject = new Object[n];
            arrobject[0] = ApplyExp;
            arrobject[1] = expression;
            int n3 = 2;
            MakeSplice.copyTo(arrobject, n3, n2, object3);
            n3 += n2;
            object2 = ((Procedure)Invoke.make).applyN(arrobject);
        } else {
            int n = 3;
            Expression expression = expressions.$To$Exp(func);
            Object object4 = Map.map1((Procedure)$Mn$Grexp, args);
            int n4 = MakeSplice.count(object4);
            n = n4 + n;
            Object[] arrobject = new Object[n];
            arrobject[0] = ApplyExp;
            arrobject[1] = applyFunction;
            arrobject[2] = expression;
            int n5 = 3;
            MakeSplice.copyTo(arrobject, n5, n4, object4);
            n5 += n4;
            object2 = ((Procedure)Invoke.make).applyN(arrobject);
        }
        return object2;
    }

    public static BeginExp beginExp$V(Object[] argsArray) {
        LList lList;
        LList args = lList = LList.makeList(argsArray, 0);
        int n = 0;
        Object object2 = Map.map1((Procedure)$Mn$Grexp, args);
        int n2 = MakeSplice.count(object2);
        n = n2 + n;
        Expression[] arrexpression = new Expression[n];
        int n3 = 0;
        MakeSplice.copyTo(arrexpression, n3, n2, object2, Lit0);
        n3 += n2;
        return new BeginExp(arrexpression);
    }

    public static IfExp ifExp(Object object2, Object object3) {
        return expressions.ifExp(object2, object3, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static IfExp ifExp(Object a, Object b, Object c) {
        Expression expression;
        if (c != null) {
            expression = expressions.$To$Exp(c);
            return new IfExp(expressions.$To$Exp(a), expressions.$To$Exp(b), expression);
        }
        Object object2 = Promise.force(c, Expression.class);
        try {
            expression = (Expression)object2;
            return new IfExp(expressions.$To$Exp(a), expressions.$To$Exp(b), expression);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.expr.IfExp.<init>(gnu.expr.Expression,gnu.expr.Expression,gnu.expr.Expression)", 3, object2);
        }
    }

    public static SetExp setExp(Declaration var, Object val) {
        SetExp se = new SetExp(var, expressions.$To$Exp(val));
        se.setContextDecl(var);
        var.setCanWrite(true);
        se.setBinding(var);
        var.noteValueFromSet(se);
        return se;
    }

    public static {
        Lit23 = Symbol.valueOf("quasiquote");
        Lit22 = Symbol.valueOf("$lookup$");
        Lit21 = Symbol.valueOf("else");
        Lit20 = Symbol.valueOf("visitor");
        Lit19 = Symbol.valueOf("eq?");
        Lit18 = PairWithPosition.make(null, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340017);
        Lit17 = Symbol.valueOf("ex");
        Lit16 = Symbol.valueOf("::");
        Lit15 = new Object[0];
        Lit13 = Symbol.valueOf("define-validate");
        Lit14 = new SyntaxRules(Lit15, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0017\f\u001f\b\r' \b\b", Lit15, 5, "expressions.scm:76"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\u00f9\t\u0003\t\u000b\u0011\u0018\f\u0011\u0018\u0014\u0011\u0018\u001c\u0011\u0018\f\u0011\u0018$\t\u0013\u0011\u0018\f\u0011\u0018,\t\u001b\u00184\u0011\u0018\f\u0011\u0018<\b\u0011\u0018D\u0099\b\u0011\u0018L\u0011\u0018\f\u0011\u0018<\b\u0011\u0018T\u0011%#\u0018\\\b\u0011\u0018T\u0011\u0018d\u00b1A\u0011\u0018l\u0011\u0018L\b\u000bQ9\u0011\u0018t\t\u000b\u0018|\u0018\u0084\b\u000b\b\u0011\u0018\u008c\b\u0011\u0018\u0094)\u0011\u0018\u009c\b\u000b\b\u0013", new Object[]{Symbol.valueOf("define"), Lit16, Symbol.valueOf("gnu.expr.ApplyExp"), Lit20, Symbol.valueOf("gnu.expr.InlineCalls"), Symbol.valueOf("gnu.bytecode.Type"), PairWithPosition.make(Lit16, PairWithPosition.make(Symbol.valueOf("gnu.mapping.Procedure"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 331797), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 331795), Symbol.valueOf("gnu.expr.Expression"), Symbol.valueOf("let"), Lit17, Symbol.valueOf("cond"), PairWithPosition.make(PairWithPosition.make(Lit21, Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340011), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 340011), PairWithPosition.make(PairWithPosition.make(Lit19, PairWithPosition.make(Lit17, Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344093), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344088), Lit18, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 344087), Lit19, Lit22, Pair.make(Pair.make(Lit23, Pair.make(Symbol.valueOf("visitArgs"), LList.Empty)), LList.Empty), PairWithPosition.make(Lit20, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 356391), Lit21, PairWithPosition.make(Lit22, Pair.make(Lit20, Pair.make(Pair.make(Lit23, Pair.make(Symbol.valueOf("visit"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 368665), PairWithPosition.make(Lit22, Pair.make(Lit17, Pair.make(Pair.make(Lit23, Pair.make(Symbol.valueOf("maybeSetLine"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm", 368680)}, 1)}, 5, Lit13);
        Lit12 = Symbol.valueOf("set-exp");
        Lit11 = Symbol.valueOf("if-exp");
        Lit10 = Symbol.valueOf("begin-exp");
        Lit9 = Symbol.valueOf("apply-to-args-exp");
        Lit8 = Symbol.valueOf("apply-exp");
        Lit7 = new SyntaxTemplate("\u0001", "\u0003", Lit15, 0);
        Lit6 = new SyntaxPattern("\f\u0018\f\u0007\b", Lit15, 1, "expressions.scm:41");
        Lit5 = Symbol.valueOf("syntax-as-exp");
        Lit4 = Symbol.valueOf("visit-exp");
        Lit3 = Symbol.valueOf("get-compilation");
        Lit2 = Symbol.valueOf("get-visitor");
        Lit1 = Symbol.valueOf("->exp");
        Lit0 = ClassType.make("gnu.expr.Expression");
        Type = Type.class;
        Compilation = Compilation.class;
        ReferenceExp = ReferenceExp.class;
        QuoteExp = QuoteExp.class;
        ApplyExp = ApplyExp.class;
        Expression = Expression.class;
        Declaration = Declaration.class;
        $instance = new expressions();
        $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
        $Prvt$cond = StaticFieldLocation.make("kawa.lib.std_syntax", "cond");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$else = StaticFieldLocation.make("kawa.lib.std_syntax", "else");
        expressions expressions2 = $instance;
        $Mn$Grexp = new ModuleMethod(expressions2, 1, Lit1, 4097);
        get$Mnvisitor = new ModuleMethod(expressions2, 2, Lit2, 0);
        get$Mncompilation = new ModuleMethod(expressions2, 3, Lit3, 0);
        visit$Mnexp = new ModuleMethod(expressions2, 4, Lit4, 8193);
        expressions expressions3 = $instance;
        ModuleMethod moduleMethod = new ModuleMethod(expressions3, 6, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/kawa/expressions.scm:39");
        syntax$Mnas$Mnexp = Macro.make(Lit5, moduleMethod, "kawa.lib.kawa.expressions");
        apply$Mnexp = new ModuleMethod(expressions2, 7, Lit8, -4095);
        apply$Mnto$Mnargs$Mnexp = new ModuleMethod(expressions2, 8, Lit9, -4095);
        begin$Mnexp = new ModuleMethod(expressions2, 9, Lit10, -4096);
        if$Mnexp = new ModuleMethod(expressions2, 10, Lit11, 12290);
        set$Mnexp = new ModuleMethod(expressions2, 12, Lit12, 8194);
        define$Mnvalidate = Macro.make(Lit13, Lit14, "kawa.lib.kawa.expressions");
        expressions.$runBody$();
    }

    public expressions() {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(1, null);
        if (((Pattern)Lit6).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = SyntaxForms.rewrite(Lit7.execute(arrobject, templateScope));
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 2: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 6: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 4: {
                Object object3 = Promise.force(object2, Expression.class);
                if (!(object3 instanceof Expression)) {
                    return -786431;
                }
                callContext.value1 = object3;
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
            case 12: {
                Object object4 = Promise.force(object2, Declaration.class);
                if (!(object4 instanceof Declaration)) {
                    return -786431;
                }
                callContext.value1 = object4;
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
            case 4: {
                Object object5 = Promise.force(object2, Expression.class);
                if (!(object5 instanceof Expression)) {
                    return -786431;
                }
                callContext.value1 = object5;
                Object object6 = Promise.force(object3, Type.class);
                if (!(object6 instanceof Type)) {
                    return -786430;
                }
                callContext.value2 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        if (moduleMethod.selector == 10) {
            callContext.value1 = object2;
            callContext.value2 = object3;
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
            case 8: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 7: {
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

    public Object apply0(ModuleMethod moduleMethod) {
        switch (moduleMethod.selector) {
            case 2: {
                return expressions.getVisitor();
            }
            case 3: {
                return expressions.getCompilation();
            }
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
            case 1: {
                return expressions.$To$Exp(object2);
            }
            case 4: {
                return expressions.visitExp((Expression)Promise.force(object2, Expression.class));
            }
            case 6: {
                return expressions.lambda1(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "visit-exp", 1, object2);
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

    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        if (moduleMethod.selector == 10) {
            return expressions.ifExp(object2, object3, object4);
        }
        return super.apply3(moduleMethod, object2, object3, object4);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 7: {
                int n = arrobject.length - 1;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 1];
                }
                return expressions.applyExp$V(arrobject[0], arrobject2);
            }
            case 8: {
                int n = arrobject.length - 1;
                Object[] arrobject3 = new Object[n];
                while (--n >= 0) {
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 1];
                }
                return expressions.applyToArgsExp$V(arrobject[0], arrobject3);
            }
            case 9: {
                return expressions.beginExp$V(arrobject);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

