/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.ClassType;
import gnu.expr.CaseExp;
import gnu.expr.Expression;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.QuoteExp;
import gnu.kawa.functions.MakeSplice;
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
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.lib.prim_syntax;
import kawa.standard.append;
import kawa.standard.syntax_case;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class case_syntax
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$else;
    public static final Object $LsCaseClause$Gr;
    public static final Class $LsCaseExp$Gr;
    public static final Class $LsExpression$Gr;
    public static final Class $LsQuoteExp$Gr;
    public static final ModuleMethod syntax$Mnform$Mn$Grdatum;
    public static final ModuleMethod clause$Mndatums$Mn$Grexps;
    public static final ModuleMethod syntax$Mn$Grcase$Mnclauses;
    public static final ModuleMethod case$Mnclause$Mn$Grexpression;
    public static final Macro case;
    public static final Macro $Pccase;
    static final Class Lit0;
    static final ClassType Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    public static case_syntax $instance;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
    static final SimpleSymbol Lit10;
    static final SyntaxPattern Lit11;
    static final SyntaxTemplate Lit12;
    static final SyntaxTemplate Lit13;
    static final SyntaxTemplate Lit14;
    static final ClassType Lit15;
    static final SyntaxTemplate Lit16;
    static final SyntaxTemplate Lit17;
    static final SyntaxPattern Lit18;
    static final SyntaxTemplate Lit19;
    static final SyntaxTemplate Lit20;
    static final SyntaxTemplate Lit21;
    static final Object[] Lit22;
    static final Object[] Lit23;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        $LsCaseClause$Gr = Lit0;
    }

    public static Object syntaxForm$To$Datum(Object obj) {
        return obj instanceof SyntaxForm ? ((SyntaxForm)Promise.force(obj, SyntaxForm.class)).getDatum() : obj;
    }

    /*
     * Exception decompiling
     */
    public static Object clauseDatums$To$Exps(Object datums) {
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
    public static Object syntax$To$CaseClauses(Object s$Mnclauses, Object key) {
        Object datums;
        Object rest;
        Object clause;
        LList lList;
        int n;
        if (lists.isNull(s$Mnclauses)) {
            lList = LList.Empty;
            return lList;
        }
        Object object3 = Promise.force(s$Mnclauses, Pair.class);
        try {
            clause = lists.car((Pair)object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, datums);
        }
        Object object4 = Promise.force(clause, Pair.class);
        try {
            datums = lists.car((Pair)object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, rest);
        }
        Object object2 = Promise.force(s$Mnclauses, Pair.class);
        try {
            rest = lists.cdr((Pair)object2);
            n = 0;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        Object object5 = case_syntax.clauseDatums$To$Exps(datums);
        int n2 = MakeSplice.count(object5);
        n = n2 + n;
        Expression[] arrexpression = new Expression[n];
        int n3 = 0;
        MakeSplice.copyTo(arrexpression, n3, n2, object5, Lit1);
        n3 += n2;
        lList = lists.cons(new CaseExp.CaseClause(arrexpression, case_syntax.caseClause$To$Expression(clause, key)), case_syntax.syntax$To$CaseClauses(rest, key));
        return lList;
    }

    public static Expression caseClause$To$Expression(Object s$Mnclause, Object key) {
        Expression expression;
        block12 : {
            Object exp;
            Object object2;
            block13 : {
                Object exp2;
                block9 : {
                    block8 : {
                        block11 : {
                            block10 : {
                                boolean x = lists.isNull(s$Mnclause);
                                if (!x) break block10;
                                if (!x) break block8;
                                break block11;
                            }
                            Object object3 = Promise.force(s$Mnclause, Pair.class);
                            try {
                                if (!lists.isNull(lists.cdr((Pair)object3))) break block8;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "cdr", 1, exp2);
                            }
                        }
                        expression = prim_syntax.reportSyntaxError(s$Mnclause, "too few expressions for a 'case' clause");
                        break block12;
                    }
                    Object object4 = Promise.force(s$Mnclause, Pair.class);
                    try {
                        exp2 = lists.cdr((Pair)object4);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, exp);
                    }
                    Object object5 = Promise.force(exp2, Pair.class);
                    try {
                        if (lists.car((Pair)object5) != Lit2) break block9;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, object5);
                    }
                    Object[] arrobject = new Object[2];
                    object5 = Promise.force(exp2, Pair.class);
                    try {
                        arrobject[0] = lists.cdr((Pair)object5);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, object5);
                    }
                    arrobject[1] = LList.list1(key);
                    object2 = LList.list1(append.append$V(arrobject));
                    break block13;
                }
                object2 = exp2;
            }
            exp = object2;
            expression = SyntaxForms.rewrite(lists.cons(Lit3, exp));
        }
        return expression;
    }

    public static {
        Object[] arrobject = new Object[1];
        Lit23 = arrobject;
        arrobject[0] = Symbol.valueOf("else");
        Lit22 = new Object[0];
        Lit21 = new SyntaxTemplate("\u0001\u0003", "\u0003", Lit22, 0);
        Lit20 = new SyntaxTemplate("\u0001\u0003", "\b\r\u000b", Lit22, 1);
        Lit19 = new SyntaxTemplate("\u0001\u0003", "\u0003", Lit22, 0);
        Lit18 = new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit22, 2, "case_syntax.scm:67");
        Lit17 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0003", Lit22, 0);
        Lit16 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0011\u0018\u0004\b\u0015\u0013", Lit23, 1);
        Lit15 = ClassType.make("gnu.expr.CaseExp$CaseClause");
        Lit14 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0003", Lit22, 0);
        Lit13 = new SyntaxTemplate("\u0001\u0003\u0003", "\b\r\u000b", Lit22, 1);
        Lit12 = new SyntaxTemplate("\u0001\u0003\u0003", "\u0003", Lit22, 0);
        Lit11 = new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\u0016<\f\u0002\r\u0017\u0010\b\b\b", Lit23, 3, "case_syntax.scm:58");
        Lit10 = Symbol.valueOf("%case");
        Lit8 = Symbol.valueOf("case");
        Lit9 = new SyntaxRules(Lit22, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit22, 2, "case_syntax.scm:51"), "\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f\b\r\u000b", new Object[]{Symbol.valueOf("let"), Symbol.valueOf("tmp"), Lit10}, 1)}, 2, Lit8);
        Lit7 = Symbol.valueOf("case-clause->expression");
        Lit6 = Symbol.valueOf("syntax->case-clauses");
        Lit5 = Symbol.valueOf("clause-datums->exps");
        Lit4 = Symbol.valueOf("syntax-form->datum");
        Lit3 = Symbol.valueOf("begin");
        Lit2 = Symbol.valueOf("=>");
        Lit1 = ClassType.make("gnu.expr.Expression");
        Lit0 = CaseExp.CaseClause.class;
        $LsQuoteExp$Gr = QuoteExp.class;
        $LsExpression$Gr = Expression.class;
        $LsCaseExp$Gr = CaseExp.class;
        $instance = new case_syntax();
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$else = StaticFieldLocation.make("kawa.lib.std_syntax", "else");
        case_syntax case_syntax2 = $instance;
        syntax$Mnform$Mn$Grdatum = new ModuleMethod(case_syntax2, 1, Lit4, 4097);
        clause$Mndatums$Mn$Grexps = new ModuleMethod(case_syntax2, 2, Lit5, 4097);
        syntax$Mn$Grcase$Mnclauses = new ModuleMethod(case_syntax2, 3, Lit6, 8194);
        case$Mnclause$Mn$Grexpression = new ModuleMethod(case_syntax2, 4, Lit7, 8194);
        case = Macro.make(Lit8, Lit9, "kawa.lib.case_syntax");
        case_syntax case_syntax3 = $instance;
        ModuleMethod moduleMethod = new ModuleMethod(case_syntax3, 5, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/case_syntax.scm:56");
        $Pccase = Macro.makeSkipScanForm(Lit10, moduleMethod, "kawa.lib.case_syntax");
        case_syntax.$runBody$();
    }

    public case_syntax() {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object x) {
        Object object2;
        Object object3 = x;
        Object[] arrobject = SyntaxPattern.allocVars(3, null);
        if (((Pattern)Lit11).match(x, arrobject, 0)) {
            CaseExp caseExp;
            object2 = caseExp;
            TemplateScope templateScope = TemplateScope.make();
            int n = 0;
            Object object4 = TemplateScope.make();
            Object object5 = Lit13.execute(arrobject, (TemplateScope)object4);
            object4 = TemplateScope.make();
            object4 = case_syntax.syntax$To$CaseClauses(object5, Lit14.execute(arrobject, (TemplateScope)object4));
            int n2 = MakeSplice.count(object4);
            n = n2 + n;
            CaseExp.CaseClause[] arrcaseClause = new CaseExp.CaseClause[n];
            int n3 = 0;
            MakeSplice.copyTo(arrcaseClause, n3, n2, object4, Lit15);
            n3 += n2;
            TemplateScope templateScope2 = TemplateScope.make();
            Object object6 = Lit16.execute(arrobject, templateScope2);
            templateScope2 = TemplateScope.make();
            caseExp = new CaseExp(SyntaxForms.rewrite(Lit12.execute(arrobject, templateScope)), arrcaseClause, new CaseExp.CaseClause(case_syntax.caseClause$To$Expression(object6, Lit17.execute(arrobject, templateScope2))));
        } else if (((Pattern)Lit18).match(x, arrobject, 0)) {
            CaseExp caseExp;
            object2 = caseExp;
            TemplateScope templateScope = TemplateScope.make();
            int n = 0;
            Object object7 = TemplateScope.make();
            Object object8 = Lit20.execute(arrobject, (TemplateScope)object7);
            object7 = TemplateScope.make();
            object7 = case_syntax.syntax$To$CaseClauses(object8, Lit21.execute(arrobject, (TemplateScope)object7));
            int n4 = MakeSplice.count(object7);
            n = n4 + n;
            CaseExp.CaseClause[] arrcaseClause = new CaseExp.CaseClause[n];
            int n5 = 0;
            MakeSplice.copyTo(arrcaseClause, n5, n4, object7, Lit15);
            n5 += n4;
            caseExp = new CaseExp(SyntaxForms.rewrite(Lit19.execute(arrobject, templateScope)), arrcaseClause);
        } else {
            object2 = syntax_case.error("syntax-case", x);
        }
        return object2;
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
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
            case 4: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 3: {
                callContext.value1 = object2;
                callContext.value2 = object3;
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

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return case_syntax.syntaxForm$To$Datum(object2);
            }
            case 2: {
                return case_syntax.clauseDatums$To$Exps(object2);
            }
            case 5: {
                return case_syntax.lambda1(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 3: {
                return case_syntax.syntax$To$CaseClauses(object2, object3);
            }
            case 4: {
                return case_syntax.caseClause$To$Expression(object2, object3);
            }
        }
        return super.apply2(moduleMethod, object2, object3);
    }
}

