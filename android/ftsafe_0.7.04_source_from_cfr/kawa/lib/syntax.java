/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.Expression;
import gnu.expr.KawaConvert;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SynchronizedExp;
import gnu.expr.TryExp;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.lists;
import kawa.lib.prim_syntax;
import kawa.lib.scheme.eval;
import kawa.lib.std_syntax;
import kawa.standard.syntax_case;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class syntax
extends ModuleBody {
    public static final Macro defmacro;
    public static final Macro define$Mnmacro;
    public static final Macro define$Mnsyntax$Mncase;
    public static final Macro begin$Mnfor$Mnsyntax;
    public static final Macro define$Mnfor$Mnsyntax;
    public static final Macro when;
    public static final Macro unless;
    public static final Macro try$Mnfinally;
    public static final Macro synchronized;
    public static final Macro let$Mnvalues;
    public static final Macro let$St$Mnvalues;
    public static final Macro case$Mnlambda;
    public static final Macro define$Mnvalues;
    public static final Macro define$Mnalias$Mnparameter;
    public static final Macro $bracket$Mnlist$;
    public static final Macro $string$;
    public static final Macro $string$Mnwith$Mndefault$Mnformat$;
    public static final Macro $format$;
    public static final Macro $sprintf$;
    public static final Macro $string$Mnwith$Mndelimiter$Mnmarks$;
    public static final Macro define$Mnsimple$Mnconstructor;
    public static final StaticFieldLocation $Prvt$define$Mnsyntax;
    public static final StaticFieldLocation $Prvt$define;
    public static final StaticFieldLocation $Prvt$define$Mnconstant;
    public static final StaticFieldLocation $Prvt$if;
    public static final StaticFieldLocation $Prvt$try$Mncatch;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$_;
    public static final StaticFieldLocation $Prvt$set$Mncdr$Ex;
    public static final StaticFieldLocation $Prvt$car;
    public static final StaticFieldLocation $Prvt$cdr;
    public static final StaticFieldLocation $Prvt$cadr;
    public static final StaticFieldLocation $Prvt$cddr;
    public static final StaticFieldLocation $Prvt$begin;
    public static final StaticFieldLocation $Prvt$call$Mnwith$Mnvalues;
    public static final StaticFieldLocation $Prvt$lambda;
    public static final StaticFieldLocation $Prvt$list;
    public static final StaticFieldLocation $Prvt$not;
    public static final StaticFieldLocation $Prvt$quasiquote;
    public static final StaticFieldLocation $Prvt$quote;
    public static final StaticFieldLocation $Prvt$set$Ex;
    public static final StaticFieldLocation $Prvt$syntax$Mnrules;
    public static final Macro $Prvt$$Pcsimple$Mnconstruct$Mnbuilder;
    static final SyntaxPattern Lit0;
    static final SyntaxPattern Lit1;
    static final SyntaxTemplate Lit2;
    static final SyntaxPattern Lit3;
    static final SyntaxTemplate Lit4;
    static final SyntaxTemplate Lit5;
    static final SyntaxPattern Lit6;
    static final SyntaxTemplate Lit7;
    static final SyntaxPattern Lit8;
    static final SyntaxTemplate Lit9;
    static final SyntaxTemplate Lit10;
    static final SyntaxPattern Lit11;
    static final SyntaxPattern Lit12;
    static final SyntaxTemplate Lit13;
    static final SyntaxPattern Lit14;
    static final SyntaxTemplate Lit15;
    static final SyntaxTemplate Lit16;
    static final SyntaxTemplate Lit17;
    static final SyntaxPattern Lit18;
    static final SyntaxTemplate Lit19;
    static final SyntaxPattern Lit20;
    static final SyntaxPattern Lit21;
    static final SyntaxTemplate Lit22;
    static final SyntaxPattern Lit23;
    static final SyntaxTemplate Lit24;
    static final SyntaxTemplate Lit25;
    static final SyntaxPattern Lit26;
    static final SyntaxTemplate Lit27;
    static final SyntaxTemplate Lit28;
    static final SyntaxPattern Lit29;
    static final SyntaxTemplate Lit30;
    static final SyntaxPattern Lit31;
    static final SyntaxPattern Lit32;
    static final SyntaxTemplate Lit33;
    static final SyntaxPattern Lit34;
    static final SyntaxTemplate Lit35;
    static final SyntaxTemplate Lit36;
    static final SyntaxPattern Lit37;
    static final SyntaxTemplate Lit38;
    static final SyntaxTemplate Lit39;
    public static syntax $instance;
    static final SimpleSymbol Lit40;
    static final SyntaxRules Lit41;
    static final SimpleSymbol Lit42;
    static final SyntaxRules Lit43;
    static final SimpleSymbol Lit44;
    static final SyntaxRules Lit45;
    static final SimpleSymbol Lit46;
    static final SyntaxRules Lit47;
    static final SimpleSymbol Lit48;
    static final SyntaxRules Lit49;
    static final SimpleSymbol Lit50;
    static final SyntaxPattern Lit51;
    static final SyntaxTemplate Lit52;
    static final SyntaxTemplate Lit53;
    static final SimpleSymbol Lit54;
    static final SyntaxPattern Lit55;
    static final SyntaxTemplate Lit56;
    static final SyntaxTemplate Lit57;
    static final SimpleSymbol Lit58;
    static final SyntaxPattern Lit59;
    static final SimpleSymbol Lit60;
    static final SyntaxTemplate Lit61;
    static final SyntaxTemplate Lit62;
    static final SimpleSymbol Lit63;
    static final SyntaxRules Lit64;
    static final SimpleSymbol Lit65;
    static final SyntaxPattern Lit66;
    static final SyntaxTemplate Lit67;
    static final SyntaxPattern Lit68;
    static final SyntaxTemplate Lit69;
    static final SyntaxPattern Lit70;
    static final SyntaxTemplate Lit71;
    static final SyntaxPattern Lit72;
    static final SyntaxTemplate Lit73;
    static final SyntaxPattern Lit74;
    static final SyntaxTemplate Lit75;
    static final SyntaxPattern Lit76;
    static final SyntaxTemplate Lit77;
    static final SyntaxTemplate Lit78;
    static final SyntaxTemplate Lit79;
    static final SyntaxTemplate Lit80;
    static final SyntaxTemplate Lit81;
    static final SyntaxTemplate Lit82;
    static final SyntaxTemplate Lit83;
    static final SyntaxTemplate Lit84;
    static final SyntaxTemplate Lit85;
    static final SyntaxTemplate Lit86;
    static final SyntaxTemplate Lit87;
    static final SyntaxPattern Lit88;
    static final SyntaxTemplate Lit89;
    static final SyntaxTemplate Lit90;
    static final SyntaxTemplate Lit91;
    static final SyntaxTemplate Lit92;
    static final SyntaxTemplate Lit93;
    static final SyntaxTemplate Lit94;
    static final SyntaxTemplate Lit95;
    static final SyntaxTemplate Lit96;
    static final SyntaxTemplate Lit97;
    static final SyntaxTemplate Lit98;
    static final SyntaxTemplate Lit99;
    static final SyntaxTemplate Lit100;
    static final SyntaxTemplate Lit101;
    static final SimpleSymbol Lit102;
    static final SyntaxRules Lit103;
    static final SimpleSymbol Lit104;
    static final SyntaxPattern Lit105;
    static final SyntaxTemplate Lit106;
    static final SyntaxTemplate Lit107;
    static final SyntaxPattern Lit108;
    static final SyntaxTemplate Lit109;
    static final SyntaxTemplate Lit110;
    static final SyntaxPattern Lit111;
    static final SyntaxPattern Lit112;
    static final SyntaxTemplate Lit113;
    static final SimpleSymbol Lit114;
    static final SyntaxRules Lit115;
    static final SimpleSymbol Lit116;
    static final SyntaxRules Lit117;
    static final SimpleSymbol Lit118;
    static final SyntaxPattern Lit119;
    static final SyntaxTemplate Lit120;
    static final SyntaxTemplate Lit121;
    static final SyntaxTemplate Lit122;
    static final SyntaxTemplate Lit123;
    static final SyntaxTemplate Lit124;
    static final SyntaxTemplate Lit125;
    static final SyntaxTemplate Lit126;
    static final SimpleSymbol Lit127;
    static final SyntaxRules Lit128;
    static final SimpleSymbol Lit129;
    static final SyntaxRules Lit130;
    static final SimpleSymbol Lit131;
    static final SyntaxRules Lit132;
    static final SimpleSymbol Lit133;
    static final SyntaxRules Lit134;
    static final SimpleSymbol Lit135;
    static final SyntaxRules Lit136;
    static final SimpleSymbol Lit137;
    static final SyntaxPattern Lit138;
    static final SyntaxTemplate Lit139;
    static final SyntaxTemplate Lit140;
    static final SyntaxTemplate Lit141;
    static final SyntaxTemplate Lit142;
    static final SyntaxPattern Lit143;
    static final SyntaxTemplate Lit144;
    static final SimpleSymbol Lit145;
    static final SyntaxRules Lit146;
    static final SimpleSymbol Lit147;
    static final Object[] Lit148;
    static final SimpleSymbol Lit149;
    static final Object[] Lit150;
    static final Object[] Lit151;
    static final SimpleSymbol Lit152;
    static final Keyword Lit153;
    static final Keyword Lit154;
    static final PairWithPosition Lit155;
    static final IntNum Lit156;
    static final Keyword Lit157;
    static final SimpleSymbol Lit158;
    static final SimpleSymbol Lit159;
    static final SimpleSymbol Lit160;
    static final PairWithPosition Lit161;
    static final Keyword Lit162;
    static final PairWithPosition Lit163;
    static final IntNum Lit164;
    static final PairWithPosition Lit165;
    static final Keyword Lit166;
    static final Object[] Lit167;
    static final PairWithPosition Lit168;
    static final Object[] Lit169;
    static final SimpleSymbol Lit170;
    static final IntNum Lit171;
    static final PairWithPosition Lit172;
    static final SimpleSymbol Lit173;
    static final SimpleSymbol Lit174;
    static final SimpleSymbol Lit175;
    static final SimpleSymbol Lit176;
    static final PairWithPosition Lit177;
    static final SimpleSymbol Lit178;
    static final PairWithPosition Lit179;
    static final SimpleSymbol Lit180;
    static final SimpleSymbol Lit181;
    static final SimpleSymbol Lit182;
    static final SimpleSymbol Lit183;
    static final SimpleSymbol Lit184;
    static final SimpleSymbol Lit185;
    static final SimpleSymbol Lit186;
    static final PairWithPosition Lit187;
    static final PairWithPosition Lit188;
    static final SimpleSymbol Lit189;
    static final SimpleSymbol Lit190;
    static final SimpleSymbol Lit191;
    static final SimpleSymbol Lit192;
    static final Object[] Lit193;
    static final Object[] Lit194;
    static final Object[] Lit195;
    static final Object[] Lit196;
    static final SimpleSymbol Lit197;
    static final SimpleSymbol Lit198;
    static final SimpleSymbol Lit199;
    static final SimpleSymbol Lit200;
    static final Object[] Lit201;
    static final SimpleSymbol Lit202;
    static final Object[] Lit203;
    static final SimpleSymbol Lit204;
    static final PairWithPosition Lit205;
    static final Object[] Lit206;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    static Object $PcStringFormatFormat(Object default$Mnformat, Object forms) {
        Object object2;
        Object object3 = forms;
        Object[] arrobject = SyntaxPattern.allocVars(3, null);
        if (((Pattern)Lit0).match(forms, arrobject, 0)) {
            object2 = LList.Empty;
        } else if (((Pattern)Lit1).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = syntax.$PcStringFormatEnclosedFormat(default$Mnformat, Lit2.execute(arrobject, templateScope));
        } else if (((Pattern)Lit3).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object4 = Lit4.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            object2 = lists.cons(object4, syntax.$PcStringFormatFormat(default$Mnformat, Lit5.execute(arrobject, templateScope)));
        } else if (((Pattern)Lit6).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = lists.cons(default$Mnformat, syntax.$PcStringFormatFormat(default$Mnformat, Lit7.execute(arrobject, templateScope)));
        } else if (((Pattern)Lit8).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object5 = Lit9.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            object2 = lists.cons(object5, syntax.$PcStringFormatFormat(default$Mnformat, Lit10.execute(arrobject, templateScope)));
        } else {
            object2 = syntax_case.error("syntax-case", forms);
        }
        return object2;
    }

    static Object $PcStringFormatEnclosedFormat(Object default$Mnformat, Object forms) {
        Object object2;
        Object object3 = forms;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit11).match(forms, arrobject, 0)) {
            object2 = LList.Empty;
        } else if (((Pattern)Lit12).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = syntax.$PcStringFormatFormat(default$Mnformat, Lit13.execute(arrobject, templateScope));
        } else if (((Pattern)Lit14).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object[] arrobject2 = new Object[]{Lit15.execute(arrobject, templateScope), Quote.consX$V(new Object[]{default$Mnformat, Lit16.execute(arrobject, templateScope)})};
            templateScope = TemplateScope.make();
            object2 = lists.cons(Quote.append$V(arrobject2), syntax.$PcStringFormatEnclosedFormat(default$Mnformat, Lit17.execute(arrobject, templateScope)));
        } else if (((Pattern)Lit18).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = lists.cons(default$Mnformat, syntax.$PcStringFormatEnclosedFormat(default$Mnformat, Lit19.execute(arrobject, templateScope)));
        } else {
            object2 = syntax_case.error("syntax-case", forms);
        }
        return object2;
    }

    static Object $PcStringFormatArgs(Object forms) {
        Object object2;
        block5 : {
            do {
                TemplateScope templateScope;
                Object object3 = forms;
                Object[] arrobject = SyntaxPattern.allocVars(3, null);
                if (((Pattern)Lit20).match(forms, arrobject, 0)) {
                    object2 = LList.Empty;
                    break block5;
                }
                if (((Pattern)Lit21).match(forms, arrobject, 0)) {
                    templateScope = TemplateScope.make();
                    object2 = syntax.$PcStringFormatEnclosedArgs(Lit22.execute(arrobject, templateScope));
                    break block5;
                }
                if (((Pattern)Lit23).match(forms, arrobject, 0)) {
                    templateScope = TemplateScope.make();
                    object2 = Quote.append$V(new Object[]{Lit24.execute(arrobject, templateScope), syntax.$PcStringFormatArgs(Lit25.execute(arrobject, templateScope))});
                    break block5;
                }
                if (((Pattern)Lit26).match(forms, arrobject, 0)) {
                    templateScope = TemplateScope.make();
                    object2 = Quote.append$V(new Object[]{Lit27.execute(arrobject, templateScope), syntax.$PcStringFormatArgs(Lit28.execute(arrobject, templateScope))});
                    break block5;
                }
                if (!((Pattern)Lit29).match(forms, arrobject, 0)) break;
                templateScope = TemplateScope.make();
                forms = Lit30.execute(arrobject, templateScope);
            } while (true);
            object2 = syntax_case.error("syntax-case", forms);
        }
        return object2;
    }

    static Object $PcStringFormatEnclosedArgs(Object forms) {
        Object object2;
        Object object3 = forms;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit31).match(forms, arrobject, 0)) {
            object2 = LList.Empty;
        } else if (((Pattern)Lit32).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = syntax.$PcStringFormatArgs(Lit33.execute(arrobject, templateScope));
        } else if (((Pattern)Lit34).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit35.execute(arrobject, templateScope), syntax.$PcStringFormatEnclosedArgs(Lit36.execute(arrobject, templateScope))});
        } else if (((Pattern)Lit37).match(forms, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit38.execute(arrobject, templateScope), syntax.$PcStringFormatEnclosedArgs(Lit39.execute(arrobject, templateScope))});
        } else {
            object2 = syntax_case.error("syntax-case", forms);
        }
        return object2;
    }

    public static {
        Object[] arrobject = new Object[1];
        Lit206 = arrobject;
        Lit131 = Symbol.valueOf("$format$");
        arrobject[0] = Lit131;
        Lit176 = Symbol.valueOf("quote");
        Lit205 = PairWithPosition.make(Lit176, PairWithPosition.make(Symbol.valueOf("toString"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1048612), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1048612);
        Lit204 = Symbol.valueOf("invoke");
        Object[] arrobject2 = new Object[1];
        Lit203 = arrobject2;
        arrobject2[0] = Symbol.valueOf("$splice$");
        Lit202 = Symbol.valueOf("string-append");
        Object[] arrobject3 = new Object[2];
        Lit201 = arrobject3;
        Lit200 = Symbol.valueOf("%define-macro");
        arrobject3[0] = Lit200;
        Lit181 = Symbol.valueOf("lambda");
        arrobject3[1] = Lit181;
        Lit199 = Symbol.valueOf("form");
        Lit198 = Symbol.valueOf("define-syntax");
        Lit197 = Symbol.valueOf("if");
        Object[] arrobject4 = new Object[2];
        Lit196 = arrobject4;
        Lit183 = Symbol.valueOf("call-with-values");
        arrobject4[0] = Lit183;
        arrobject4[1] = Lit181;
        Object[] arrobject5 = new Object[1];
        Lit195 = arrobject5;
        arrobject5[0] = "bind";
        Object[] arrobject6 = new Object[1];
        Lit194 = arrobject6;
        arrobject6[0] = Symbol.valueOf("x");
        Object[] arrobject7 = new Object[1];
        Lit193 = arrobject7;
        arrobject7[0] = "mktmp";
        Lit192 = Symbol.valueOf("car");
        Lit191 = Symbol.valueOf("cddr");
        Lit190 = Symbol.valueOf("set-cdr!");
        Lit189 = Symbol.valueOf("cadr");
        Lit188 = PairWithPosition.make(Symbol.valueOf("list"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 610316);
        Lit185 = Symbol.valueOf("v");
        Lit187 = PairWithPosition.make(Lit185, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 626700);
        Lit186 = Symbol.valueOf("set!");
        Lit184 = Symbol.valueOf("let");
        Lit182 = Symbol.valueOf("define");
        Lit180 = Symbol.valueOf("wt");
        Lit156 = IntNum.valueOf(1);
        Lit179 = PairWithPosition.make(Lit156, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1183809);
        Lit178 = Symbol.valueOf("as");
        Lit177 = PairWithPosition.make(Symbol.valueOf("arg"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 753674);
        Lit175 = Symbol.valueOf("gnu.mapping.LocationProc");
        Lit174 = Symbol.valueOf("constant-fold");
        Lit173 = Symbol.valueOf("gnu.kawa.functions.Format");
        Lit172 = PairWithPosition.make(IntNum.valueOf(-2), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1196075);
        Lit171 = IntNum.valueOf(0);
        Lit170 = Symbol.valueOf("gnu.lists.Range$IntRange");
        Object[] arrobject8 = new Object[1];
        Lit169 = arrobject8;
        Lit157 = Keyword.make(">");
        arrobject8[0] = Lit157;
        Lit158 = Symbol.valueOf("$lookup$");
        Lit159 = Symbol.valueOf("gnu.kawa.functions.RangeUtils");
        Lit160 = Symbol.valueOf("quasiquote");
        Lit168 = PairWithPosition.make(Lit158, Pair.make(Lit159, Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("valueOfUnbounded"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1183760);
        Object[] arrobject9 = new Object[1];
        Lit167 = arrobject9;
        Lit153 = Keyword.make("<");
        arrobject9[0] = Lit153;
        Lit166 = Keyword.make("by");
        Lit165 = PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1155132);
        Lit164 = IntNum.valueOf(-1);
        Lit163 = PairWithPosition.make(Lit158, Pair.make(Lit159, Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("downto"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1159186);
        Lit162 = Keyword.make(">=");
        Lit161 = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1151035);
        Lit155 = PairWithPosition.make(Lit158, Pair.make(Lit159, Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("upto"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1150994);
        Lit154 = Keyword.make("<=");
        Lit152 = Symbol.valueOf("args");
        Lit151 = new Object[0];
        Object[] arrobject10 = new Object[1];
        Lit150 = arrobject10;
        Lit149 = Symbol.valueOf("$>>$");
        arrobject10[0] = Lit149;
        Object[] arrobject11 = new Object[1];
        Lit148 = arrobject11;
        Lit147 = Symbol.valueOf("$<<$");
        arrobject11[0] = Lit147;
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[5];
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u0002\u001b", Lit148, 4, "syntax.scm:327"), "\u0001\u0001\u0003\u0000", "\t\u0003\b\t\u000b\u0011\u0015\u0013\u0011\u0018\u0004\u001a", Lit148, 1);
        arrsyntaxRule[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u0002\b", Lit150, 3, "syntax.scm:329"), "\u0001\u0001\u0003", "\t\u0003\b\u0015\u0013", Lit151, 1);
        arrsyntaxRule[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u0002\u001b", Lit150, 4, "syntax.scm:331"), "\u0001\u0001\u0003\u0000", "\t\u0003\u0011\u0015\u0013\b\t\u000b\u001a", Lit151, 1);
        Object[] arrobject12 = new Object[1];
        Lit145 = Symbol.valueOf("%simple-construct-builder");
        arrobject12[0] = Lit145;
        arrsyntaxRule[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u001f#", Lit151, 5, "syntax.scm:333"), "\u0001\u0001\u0003\u0001\u0000", "\u0011\u0018\u0004\t\u0003\t\u000b)\u0011\u0015\u0013\b\u001b\"", arrobject12, 1);
        arrsyntaxRule[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\b", Lit151, 3, "syntax.scm:335"), "\u0001\u0001\u0003", "\t\u0003\b\t\u000b\b\u0015\u0013", Lit151, 1);
        Lit146 = new SyntaxRules(new Object[]{Lit147, Lit149}, arrsyntaxRule, 5, Lit145);
        Object[] arrobject13 = new Object[2];
        Lit137 = Symbol.valueOf("define-simple-constructor");
        arrobject13[0] = Lit137;
        Lit127 = Symbol.valueOf("$string$");
        arrobject13[1] = PairWithPosition.make(Lit127, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1323062);
        Lit144 = new SyntaxTemplate("\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\u0018\f", arrobject13, 0);
        Lit143 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit151, 2, "syntax.scm:322");
        Lit142 = new SyntaxTemplate("\u0001\u0001\u0001", "\b\u0011\u0018\u0004\t\u0010\b\u0011\u0018\f\b\u0011\u0018\u0014\t\u000b\t\u0013\u0018\u001c", new Object[]{Symbol.valueOf("syntax-rules"), PairWithPosition.make(Symbol.valueOf("_"), Lit152, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1310737), Lit145, PairWithPosition.make(LList.Empty, Lit152, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1314887)}, 0);
        Lit141 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0018\u0004", new Object[]{Pair.make(Lit198, LList.Empty)}, 0);
        Lit140 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0003", Lit151, 0);
        Lit139 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0003", Lit151, 0);
        Lit138 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit151, 3, "syntax.scm:316");
        Lit135 = Symbol.valueOf("$bracket-list$");
        Lit136 = new SyntaxRules(new Object[]{Lit153, Lit154, Lit157, Lit162}, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", Lit167, 2, "syntax.scm:281"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\u0018\u0014", new Object[]{Lit155, Lit156, Lit161}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", new Object[]{Lit154}, 2, "syntax.scm:282"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\u0018\u0014", new Object[]{Lit155, Lit156, Lit165}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", Lit169, 2, "syntax.scm:283"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\u0018\u0014", new Object[]{Lit163, Lit164, Lit161}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", new Object[]{Lit162}, 2, "syntax.scm:284"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\u0018\u0014", new Object[]{Lit163, Lit164, Lit165}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[]{Lit166, Lit153}, 3, "syntax.scm:285"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0013\u0018\f", new Object[]{Lit155, Lit161}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[]{Lit166, Lit154}, 3, "syntax.scm:286"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0013\u0018\f", new Object[]{Lit155, Lit165}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[]{Lit166, Lit157}, 3, "syntax.scm:287"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0013\u0018\f", new Object[]{Lit163, Lit161}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[]{Lit166, Lit162}, 3, "syntax.scm:288"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0013\u0018\f", new Object[]{Lit163, Lit165}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\b", Lit167, 1, "syntax.scm:289"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", new Object[]{Lit168, Lit179}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", new Object[]{Lit166}, 2, "syntax.scm:290"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[]{Lit168}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[]{Lit166, Keyword.make("size")}, 3, "syntax.scm:291"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\b\u0013", new Object[]{PairWithPosition.make(Lit158, Pair.make(Lit159, Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("bySize"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1191967)}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0002\b", Lit167, 0, "syntax.scm:292"), "", "\u0018\u0004", new Object[]{Pair.make(Lit170, PairWithPosition.make(Lit171, PairWithPosition.make(Lit156, Lit172, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1196073), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1196071))}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0002\b", Lit169, 0, "syntax.scm:293"), "", "\u0018\u0004", new Object[]{Pair.make(Lit170, PairWithPosition.make(Lit171, PairWithPosition.make(Lit164, Lit172, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1200169), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1200167))}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit151, 1, "syntax.scm:294"), "\u0000", "\u0011\u0018\u0004\u0002", new Object[]{Symbol.valueOf("constant-vector")}, 0)}, 3, Lit135);
        Lit133 = Symbol.valueOf("$sprintf$");
        Lit134 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u000b", Lit151, 2, "syntax.scm:276"), "\u0001\u0000", "\u0011\u0018\u0004\t\u0003\n", new Object[]{PairWithPosition.make(Lit158, Pair.make(Lit173, Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("sprintfToString"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1134599)}, 0)}, 2, Lit133);
        Lit132 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit151, 1, "syntax.scm:271"), "\u0000", "\u0011\u0018\u0004\t\f\u0002", new Object[]{PairWithPosition.make(Lit158, Pair.make(Lit173, Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("formatToString"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1114119), Lit171}, 0)}, 1, Lit131);
        SyntaxRule[] arrsyntaxRule2 = new SyntaxRule[1];
        Object[] arrobject14 = new Object[2];
        Lit118 = Symbol.valueOf("$string-with-default-format$");
        arrobject14[0] = Lit118;
        arrobject14[1] = "~Q";
        arrsyntaxRule2[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit151, 1, "syntax.scm:266"), "\u0000", "\u0011\u0018\u0004\t\f\u0002", arrobject14, 0);
        Lit129 = Symbol.valueOf("$string-with-delimiter-marks$");
        Lit130 = new SyntaxRules(Lit151, arrsyntaxRule2, 1, Lit129);
        Lit128 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit151, 1, "syntax.scm:261"), "\u0000", "\u0011\u0018\u0004\t\f\u0002", new Object[]{Lit118, "~a"}, 0)}, 1, Lit127);
        Lit126 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0012", Lit151, 0);
        Lit125 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit205, LList.Empty)}, 0);
        Lit124 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0012", Lit151, 0);
        Lit123 = new SyntaxTemplate("\u0001\u0001\u0000", "\u000b", Lit151, 0);
        Lit122 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit174, PairWithPosition.make(Lit202, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1032242))}, 0);
        Lit121 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit174, PairWithPosition.make(Lit204, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1028131))}, 0);
        Lit120 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit131, LList.Empty)}, 0);
        Lit119 = new SyntaxPattern("\f\u0007\f\u000f\u0013", Lit151, 3, "syntax.scm:250");
        SyntaxRule[] arrsyntaxRule3 = new SyntaxRule[1];
        Object[] arrobject15 = new Object[22];
        Lit60 = Symbol.valueOf("begin");
        arrobject15[0] = Lit60;
        arrobject15[1] = Symbol.valueOf("define-constant");
        arrobject15[2] = Symbol.valueOf("::");
        arrobject15[3] = Symbol.valueOf("$bracket-apply$");
        arrobject15[4] = Lit175;
        arrobject15[5] = PairWithPosition.make(Lit158, Pair.make(Lit175, Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("makeNamed"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 741380);
        arrobject15[6] = Lit176;
        arrobject15[7] = PairWithPosition.make(Lit158, Pair.make(Lit175, Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("pushConverter"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 745481);
        arrobject15[8] = Lit181;
        arrobject15[9] = Lit177;
        arrobject15[10] = Symbol.valueOf("try-catch");
        arrobject15[11] = Lit178;
        arrobject15[12] = Lit177;
        arrobject15[13] = Symbol.valueOf("ex");
        arrobject15[14] = Symbol.valueOf("<java.lang.ClassCastException>");
        arrobject15[15] = Lit184;
        arrobject15[16] = Lit180;
        arrobject15[17] = PairWithPosition.make(Lit158, Pair.make(Symbol.valueOf("gnu.mapping.WrongType"), Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("make"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 770068);
        arrobject15[18] = PairWithPosition.make(PairWithPosition.make(Lit178, PairWithPosition.make(Symbol.valueOf("<int>"), Lit179, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 774160), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 774156), Lit177, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 774156);
        arrobject15[19] = Lit186;
        arrobject15[20] = PairWithPosition.make(Symbol.valueOf("field"), PairWithPosition.make(Lit180, PairWithPosition.make(PairWithPosition.make(Lit176, PairWithPosition.make(Symbol.valueOf("expectedType"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778261), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778261), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778250);
        arrobject15[21] = PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("primitive-throw"), PairWithPosition.make(Lit180, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 782357), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 782340), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 782340);
        arrsyntaxRule3[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit151, 3, "syntax.scm:178"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u00e9\u0011\u0018\f\t\u0003\u0011\u0018\u0014A\u0011\u0018\u001c\u0011\u0018$\b\u000b\b\u0011\u0018,)\u0011\u00184\b\u0003\b\u0013\b\u0011\u0018<\t\u0003\b\u0011\u0018D\u0011\u0018L\b\u0011\u0018T9\u0011\u0018\\\t\u000b\u0018d\b\u0011\u0018l\u0011\u0018t\b\u0011\u0018|y\b\u0011\u0018\u0084\b\u0011\u0018\u008c\u0011\u0018l\t\u0003\u0018\u0094A\u0011\u0018\u009c\u0011\u0018\u00a4\b\u000b\u0018\u00ac", arrobject15, 0);
        Lit116 = Symbol.valueOf("define-alias-parameter");
        Lit117 = new SyntaxRules(Lit151, arrsyntaxRule3, 3, Lit116);
        Lit114 = Symbol.valueOf("define-values");
        Lit115 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\b", Lit151, 1, "syntax.scm:139"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u00149\u0011\u0018\u001c\t\u0010\b\u0003\u0018$", new Object[]{Lit182, Symbol.valueOf("dummy"), Lit183, Lit181, PairWithPosition.make(PairWithPosition.make(Lit181, PairWithPosition.make(Lit152, Lit161, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 581650), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 581642), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 581642)}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\f\u000f\b", Lit151, 2, "syntax.scm:143"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[]{Lit182}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018T\f\u0007\r\u000f\b\b\u0016\f\u0017\b\f\u001f\b", Lit151, 4, "syntax.scm:145"), "\u0001\u0003\u0001\u0001", "\u0011\u0018\u0004\u0099\u0011\u0018\f\t\u0003\b\u0011\u0018\u00149\u0011\u0018\u001c\t\u0010\b\u001b\u0018$\u0119\r\u0011\u0018\f\t\u000b\b\u0011\u0018,Q\b\u0011\u00184\b\u0011\u0018<\b\u0003Y\u0011\u0018D\t\u0003\b\u0011\u0018L\b\u0003\u0018T\b\u0011\u0018\f\t\u0013\b\u0011\u0018,Q\b\u0011\u00184\b\u0011\u0018<\b\u0003Y\u0011\u0018\\\t\u0003\b\u0011\u0018d\b\u0003\u0018l", new Object[]{Lit60, Lit182, Lit183, Lit181, Lit188, Lit184, Lit185, Lit189, Lit190, Lit191, Lit187, Lit186, Lit192, Lit187}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018D\f\u0007\r\u000f\b\b\u000e\u0013\f\u001f\b", Lit151, 4, "syntax.scm:158"), "\u0001\u0003\u0000\u0001", "\u0011\u0018\u0004\u0099\u0011\u0018\f\t\u0003\b\u0011\u0018\u00149\u0011\u0018\u001c\t\u0010\b\u001b\u0018$\u0119\r\u0011\u0018\f\t\u000b\b\u0011\u0018,Q\b\u0011\u00184\b\u0011\u0018<\b\u0003Y\u0011\u0018D\t\u0003\b\u0011\u0018L\b\u0003\u0018T\b\u0011\u0018\f\t\u0012\b\u0011\u0018,Q\b\u0011\u00184\b\u0011\u0018\\\b\u0003Y\u0011\u0018d\t\u0003\b\u0011\u0018l\b\u0003\u0018t", new Object[]{Lit60, Lit182, Lit183, Lit181, Lit188, Lit184, Lit185, Lit189, Lit190, Lit191, Lit187, Symbol.valueOf("cdr"), Lit186, Lit192, Lit187}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit151, 2, "syntax.scm:171"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f9\u0011\u0018\u0014\t\u0010\b\u000b\u0018\u001c", new Object[]{Lit182, Lit183, Lit181, Lit188}, 0)}, 4, Lit114);
        Lit113 = new SyntaxTemplate("\u0000\u0000", "\n", Lit151, 0);
        Lit112 = new SyntaxPattern("\u000b", Lit151, 2, "syntax.scm:132");
        Lit111 = new SyntaxPattern("\b", Lit151, 1, "syntax.scm:130");
        Lit110 = new SyntaxTemplate("\u0000\u0001\u0000\u0000", "\u001a", Lit151, 0);
        Lit109 = new SyntaxTemplate("\u0000\u0001\u0000\u0000", "\b\u0011\u0018\u0004\t\u000b\u0012", new Object[]{Lit181}, 0);
        Lit108 = new SyntaxPattern("\u001c\f\u000f\u0013\u001b", Lit151, 4, "syntax.scm:128");
        Lit107 = new SyntaxTemplate("\u0000", "\u0002", Lit151, 0);
        Lit106 = new SyntaxTemplate("\u0000", "\u0018\u0004", new Object[]{Pair.make(PairWithPosition.make(Lit158, Pair.make(Symbol.valueOf("gnu.expr.GenericProc"), Pair.make(Pair.make(Lit160, Pair.make(Symbol.valueOf("makeWithoutSorting"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 512009), LList.Empty)}, 0);
        Lit105 = new SyntaxPattern("\f\u0018\u0003", Lit151, 1, "syntax.scm:124");
        Lit104 = Symbol.valueOf("case-lambda");
        SyntaxRule[] arrsyntaxRule4 = new SyntaxRule[2];
        arrsyntaxRule4[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\r\u000f\b\b\b", Lit151, 2, "syntax.scm:115"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\r\u000b", new Object[]{Lit60}, 1);
        Object[] arrobject16 = new Object[2];
        Lit65 = Symbol.valueOf("let-values");
        arrobject16[0] = Lit65;
        Lit102 = Symbol.valueOf("let*-values");
        arrobject16[1] = Lit102;
        arrsyntaxRule4[1] = new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\r\u000f\b\b\b\f\u0017\r\u001f\u0018\b\b", Lit151, 4, "syntax.scm:118"), "\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\u0011\b\u0003\b\u0011\u0018\f\u0019\b\r\u000b\t\u0013\b\u001d\u001b", arrobject16, 1);
        Lit103 = new SyntaxRules(Lit151, arrsyntaxRule4, 4, Lit102);
        Lit101 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0010", Lit151, 0);
        Lit100 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0010", Lit151, 0);
        Lit99 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\b3", Lit151, 0);
        Lit98 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0010", Lit151, 0);
        Lit97 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0010", Lit151, 0);
        Lit96 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\b\u000b", Lit151, 0);
        Lit95 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\b-+", Lit151, 1);
        Lit94 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\t\u0003\t\u0004\b#", Lit195, 0);
        Lit93 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\b\u001d\u001b", Lit151, 1);
        Lit92 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0018\u0004", new Object[]{Pair.make(Lit181, LList.Empty)}, 0);
        Lit91 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\t\u0010\b\u0013", Lit196, 0);
        Lit90 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u000b", Lit151, 0);
        Lit89 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0018\u0004", Lit194, 0);
        Lit88 = new SyntaxPattern("\f\u0007\f\u0002\f\u000f\f\u0017,\r\u001f\u0018\b\b\f',\r/(\b\b\f7\b", Lit193, 7, "syntax.scm:106");
        Lit87 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b;", Lit151, 0);
        Lit86 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u0010", Lit151, 0);
        Lit85 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u0010", Lit151, 0);
        Lit84 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b\u000b", Lit151, 0);
        Lit83 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b53", Lit151, 1);
        Lit82 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b+", Lit151, 0);
        Lit81 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u0010", Lit151, 0);
        Lit80 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b%#", Lit151, 1);
        Lit79 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\t\u0003\t\u0004\t\u0012\b\u001b", Lit193, 0);
        Lit78 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u000b", Lit151, 0);
        Lit77 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u0018\u0004", Lit194, 0);
        Lit76 = new SyntaxPattern("\f\u0007\f\u0002\u001c\f\u000f\u0013\f\u001f,\r' \b\b\f/,\r70\b\b\f?\b", Lit193, 8, "syntax.scm:101");
        Lit75 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u000b\b\u0011\u0018\f\t\u0013\b\t\u0003\t\u0014\t\u001b\t#\b+", new Object[]{Lit183, Lit181, "bind"}, 0);
        Lit74 = new SyntaxPattern("\f\u0007\f\u0002\f\b\f\u000f\f\u0017\f\u001f\f'\f/\b", Lit193, 6, "syntax.scm:95");
        Lit73 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0001", "\t\u0003\t\u0004\t\u000b\t\u0013\t\u0010\u0019\b\u001d\u001b\t#\b+", Lit193, 1);
        Lit72 = new SyntaxPattern("\f\u0007\f\u0002\\,\f\u000f\f\u0017\b\r\u001f\u0018\b\b\f'\f/\b", Lit195, 6, "syntax.scm:92");
        Lit71 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u000b\b\u0013", new Object[]{Lit184}, 0);
        Lit70 = new SyntaxPattern("\f\u0007\f\u0002\f\b\f\u000f\f\u0017\b", Lit195, 3, "syntax.scm:89");
        Lit69 = new SyntaxTemplate("\u0001\u0003\u0001\u0003", "\t\u0003\t\u0004\u0019\b\r\u000b\t\u0010\b\u0011\u0018\f\t\u0013\b\u001d\u001b", new Object[]{"bind", Lit60}, 1);
        Lit68 = new SyntaxPattern("\f\u0007,\r\u000f\b\b\b\f\u0017\r\u001f\u0018\b\b", Lit151, 4, "syntax.scm:87");
        Lit67 = new SyntaxTemplate("\u0001\u0001\u0001\u0000", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u0013\b\u0011\u0018\f\t\u000b\u001a", Lit196, 0);
        Lit66 = new SyntaxPattern("\f\u0007<,\f\u000f\f\u0017\b\b\u001b", Lit151, 4, "syntax.scm:83");
        SyntaxRule[] arrsyntaxRule5 = new SyntaxRule[1];
        Object[] arrobject17 = new Object[2];
        Lit58 = Symbol.valueOf("begin-for-syntax");
        arrobject17[0] = Lit58;
        arrobject17[1] = Lit182;
        arrsyntaxRule5[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit151, 1, "syntax.scm:69"), "\u0000", "\u0011\u0018\u0004\b\u0011\u0018\f\u0002", arrobject17, 0);
        Lit63 = Symbol.valueOf("define-for-syntax");
        Lit64 = new SyntaxRules(Lit151, arrsyntaxRule5, 1, Lit63);
        Lit62 = new SyntaxTemplate("\u0001\u0000", "\u0018\u0004", new Object[]{Values.empty}, 0);
        Lit61 = new SyntaxTemplate("\u0001\u0000", "\n", Lit151, 0);
        Lit59 = new SyntaxPattern("\f\u0007\u000b", Lit151, 2, "syntax.scm:63");
        Lit57 = new SyntaxTemplate("\u0001\u0000", "\n", Lit151, 0);
        Lit56 = new SyntaxTemplate("\u0001\u0000", "\u0003", Lit151, 0);
        Lit55 = new SyntaxPattern("\f\u0018\f\u0007\u000b", Lit151, 2, "syntax.scm:54");
        Lit54 = Symbol.valueOf("synchronized");
        Lit53 = new SyntaxTemplate("\u0001\u0001", "\u000b", Lit151, 0);
        Lit52 = new SyntaxTemplate("\u0001\u0001", "\u0003", Lit151, 0);
        Lit51 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit151, 2, "syntax.scm:46");
        Lit50 = Symbol.valueOf("try-finally");
        Lit48 = Symbol.valueOf("unless");
        Lit49 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit151, 2, "syntax.scm:40"), "\u0001\u0003", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\b\r\u000b", new Object[]{Lit197, Symbol.valueOf("not"), Lit60}, 1)}, 2, Lit48);
        Lit46 = Symbol.valueOf("when");
        Lit47 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit151, 2, "syntax.scm:36"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\b\r\u000b", new Object[]{Lit197, Lit60}, 1)}, 2, Lit46);
        Lit44 = Symbol.valueOf("define-syntax-case");
        Lit45 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\u0013", Lit151, 3, "syntax.scm:30"), "\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\u0011\u0018\u0014\b\u0011\u0018\u001c\u0011\u0018$\t\u000b\u0012", new Object[]{Lit198, Lit181, PairWithPosition.make(Lit199, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 131089), Symbol.valueOf("syntax-case"), Lit199}, 0)}, 3, Lit44);
        Lit42 = Symbol.valueOf("define-macro");
        Lit43 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", Lit151, 3, "syntax.scm:23"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\n\u0012", Lit201, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit151, 2, "syntax.scm:25"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[]{Lit200}, 0)}, 3, Lit42);
        Lit40 = Symbol.valueOf("defmacro");
        Lit41 = new SyntaxRules(Lit151, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\u0013", Lit151, 3, "syntax.scm:18"), "\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\u000b\u0012", Lit201, 0)}, 3, Lit40);
        Lit39 = new SyntaxTemplate("\u0001\u0000", "\n", Lit151, 0);
        Lit38 = new SyntaxTemplate("\u0001\u0000", "\b\u0003", Lit151, 0);
        Lit37 = new SyntaxPattern("\f\u0007\u000b", Lit151, 2, "syntax.scm:244");
        Lit36 = new SyntaxTemplate("\u0001\u0000", "\n", Lit151, 0);
        Lit35 = new SyntaxTemplate("\u0001\u0000", "\b\u0003", Lit151, 0);
        Lit34 = new SyntaxPattern(",\f\u0002\f\u0007\b\u000b", Lit203, 2, "syntax.scm:242");
        Lit33 = new SyntaxTemplate("\u0000", "\u0002", Lit151, 0);
        Lit32 = new SyntaxPattern("\f\u0002\u0003", Lit150, 1, "syntax.scm:240");
        Lit31 = new SyntaxPattern("\b", Lit151, 0, "syntax.scm:239");
        Lit30 = new SyntaxTemplate("\u0001\u0000", "\n", Lit151, 0);
        Lit29 = new SyntaxPattern("\f\u0007\u000b", Lit151, 2, "syntax.scm:233");
        Lit28 = new SyntaxTemplate("\u0001\u0000\u0000", "\u0012", Lit151, 0);
        Lit27 = new SyntaxTemplate("\u0001\u0000\u0000", "\b\t\u0003\n", Lit151, 0);
        Lit26 = new SyntaxPattern("\u001c\f\u0007\u000b\u0013", Lit151, 3, "syntax.scm:231");
        Lit25 = new SyntaxTemplate("\u0001\u0003\u0000", "\u0012", Lit151, 0);
        Lit24 = new SyntaxTemplate("\u0001\u0003\u0000", "\b\r\u000b", Lit151, 1);
        Lit23 = new SyntaxPattern("L\f\u0002\f\u0007\r\u000f\b\b\b\u0013", Lit206, 3, "syntax.scm:229");
        Lit22 = new SyntaxTemplate("\u0000", "\u0002", Lit151, 0);
        Lit21 = new SyntaxPattern("\f\u0002\u0003", Lit148, 1, "syntax.scm:227");
        Lit20 = new SyntaxPattern("\b", Lit151, 0, "syntax.scm:226");
        Lit19 = new SyntaxTemplate("\u0001\u0000", "\n", Lit151, 0);
        Lit18 = new SyntaxPattern("\f\u0007\u000b", Lit151, 2, "syntax.scm:220");
        Lit17 = new SyntaxTemplate("\u0001\u0000", "\n", Lit151, 0);
        Lit16 = new SyntaxTemplate("\u0001\u0000", "\u0018\u0004", new Object[]{Pair.make("~}", LList.Empty)}, 0);
        Lit15 = new SyntaxTemplate("\u0001\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit174, PairWithPosition.make(Lit202, PairWithPosition.make("~{", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 892971), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 892957))}, 0);
        Lit14 = new SyntaxPattern(",\f\u0002\f\u0007\b\u000b", Lit203, 2, "syntax.scm:217");
        Lit13 = new SyntaxTemplate("\u0000", "\u0002", Lit151, 0);
        Lit12 = new SyntaxPattern("\f\u0002\u0003", Lit150, 1, "syntax.scm:215");
        Lit11 = new SyntaxPattern("\b", Lit151, 0, "syntax.scm:214");
        Lit10 = new SyntaxTemplate("\u0001\u0000", "\n", Lit151, 0);
        Lit9 = new SyntaxTemplate("\u0001\u0000", "\u0011\u0018\u0004\u0011\u0018\fQ\u0011\u0018\u0004\u0011\u0018\f\t\u0003\u0018\u0014\u0018\u001c", new Object[]{Lit174, Lit204, PairWithPosition.make(Lit205, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 843836), PairWithPosition.make(PairWithPosition.make(Lit176, PairWithPosition.make(Symbol.valueOf("replace"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847902), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847902), PairWithPosition.make("~", PairWithPosition.make("~~", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847914), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847901)}, 0);
        Lit8 = new SyntaxPattern("\f\u0007\u000b", Lit151, 2, "syntax.scm:205");
        Lit7 = new SyntaxTemplate("\u0001\u0000\u0000", "\u0012", Lit151, 0);
        Lit6 = new SyntaxPattern("\u001c\f\u0007\u000b\u0013", Lit151, 3, "syntax.scm:203");
        Lit5 = new SyntaxTemplate("\u0001\u0000\u0000", "\u0012", Lit151, 0);
        Lit4 = new SyntaxTemplate("\u0001\u0000\u0000", "\u0003", Lit151, 0);
        Lit3 = new SyntaxPattern(",\f\u0002\f\u0007\u000b\u0013", Lit206, 3, "syntax.scm:201");
        Lit2 = new SyntaxTemplate("\u0000", "\u0002", Lit151, 0);
        Lit1 = new SyntaxPattern("\f\u0002\u0003", Lit148, 1, "syntax.scm:199");
        Lit0 = new SyntaxPattern("\b", Lit151, 0, "syntax.scm:198");
        $instance = new syntax();
        $Prvt$define$Mnsyntax = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnsyntax");
        $Prvt$define = StaticFieldLocation.make("kawa.lib.prim_syntax", "define");
        $Prvt$define$Mnconstant = StaticFieldLocation.make("kawa.lib.prim_syntax", "define$Mnconstant");
        $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
        $Prvt$try$Mncatch = StaticFieldLocation.make("kawa.lib.prim_syntax", "try$Mncatch");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$_ = StaticFieldLocation.make("kawa.lib.std_syntax", "_");
        $Prvt$set$Mncdr$Ex = StaticFieldLocation.make("kawa.lib.lists", "set$Mncdr$Ex");
        $Prvt$car = StaticFieldLocation.make("kawa.lib.lists", "car");
        $Prvt$cdr = StaticFieldLocation.make("kawa.lib.lists", "cdr");
        $Prvt$cadr = StaticFieldLocation.make("kawa.lib.lists", "cadr");
        $Prvt$cddr = StaticFieldLocation.make("kawa.lib.lists", "cddr");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$call$Mnwith$Mnvalues = StaticFieldLocation.make("gnu.kawa.functions.CallWithValues", "callWithValues");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        $Prvt$list = StaticFieldLocation.make("gnu.kawa.lispexpr.LangObjType", "listType");
        $Prvt$not = StaticFieldLocation.make("kawa.standard.Scheme", "not");
        $Prvt$quasiquote = StaticFieldLocation.make("kawa.lang.Quote", "quasiQuote");
        $Prvt$quote = StaticFieldLocation.make("kawa.lang.Quote", "plainQuote");
        $Prvt$set$Ex = StaticFieldLocation.make("kawa.standard.set_b", "set");
        $Prvt$syntax$Mnrules = StaticFieldLocation.make("kawa.standard.syntax_rules", "syntax_rules");
        defmacro = Macro.make(Lit40, Lit41, "kawa.lib.syntax");
        define$Mnmacro = Macro.make(Lit42, Lit43, "kawa.lib.syntax");
        define$Mnsyntax$Mncase = Macro.make(Lit44, Lit45, "kawa.lib.syntax");
        when = Macro.make(Lit46, Lit47, "kawa.lib.syntax");
        unless = Macro.make(Lit48, Lit49, "kawa.lib.syntax");
        syntax syntax2 = $instance;
        ModuleMethod moduleMethod = new ModuleMethod(syntax2, 1, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:44");
        try$Mnfinally = Macro.makeSkipScanForm(Lit50, moduleMethod, "kawa.lib.syntax");
        syntax syntax3 = $instance;
        ModuleMethod moduleMethod2 = new ModuleMethod(syntax3, 2, null, 4097);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:52");
        synchronized = Macro.makeSkipScanForm(Lit54, moduleMethod2, "kawa.lib.syntax");
        syntax syntax4 = $instance;
        ModuleMethod moduleMethod3 = new ModuleMethod(syntax4, 3, null, 4097);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:61");
        begin$Mnfor$Mnsyntax = Macro.make(Lit58, moduleMethod3, "kawa.lib.syntax");
        define$Mnfor$Mnsyntax = Macro.make(Lit63, Lit64, "kawa.lib.syntax");
        syntax syntax5 = $instance;
        ModuleMethod moduleMethod4 = new ModuleMethod(syntax5, 4, null, 4097);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:79");
        let$Mnvalues = Macro.make(Lit65, moduleMethod4, "kawa.lib.syntax");
        let$St$Mnvalues = Macro.make(Lit102, Lit103, "kawa.lib.syntax");
        syntax syntax6 = $instance;
        case$Mnlambda = Macro.make(Lit104, new ModuleMethod(syntax6, 5, null, 4097), "kawa.lib.syntax");
        define$Mnvalues = Macro.make(Lit114, Lit115, "kawa.lib.syntax");
        define$Mnalias$Mnparameter = Macro.make(Lit116, Lit117, "kawa.lib.syntax");
        syntax syntax7 = $instance;
        ModuleMethod moduleMethod5 = new ModuleMethod(syntax7, 6, null, 4097);
        moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:248");
        $string$Mnwith$Mndefault$Mnformat$ = Macro.make(Lit118, moduleMethod5, "kawa.lib.syntax");
        $string$ = Macro.make(Lit127, Lit128, "kawa.lib.syntax");
        $string$Mnwith$Mndelimiter$Mnmarks$ = Macro.make(Lit129, Lit130, "kawa.lib.syntax");
        $format$ = Macro.make(Lit131, Lit132, "kawa.lib.syntax");
        $sprintf$ = Macro.make(Lit133, Lit134, "kawa.lib.syntax");
        $bracket$Mnlist$ = Macro.make(Lit135, Lit136, "kawa.lib.syntax");
        syntax syntax8 = $instance;
        ModuleMethod moduleMethod6 = new ModuleMethod(syntax8, 7, null, 4097);
        moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:314");
        define$Mnsimple$Mnconstructor = Macro.make(Lit137, moduleMethod6, "kawa.lib.syntax");
        $Prvt$$Pcsimple$Mnconstruct$Mnbuilder = Macro.make(Lit145, Lit146, "kawa.lib.syntax");
        syntax.$runBody$();
    }

    public syntax() {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object x) {
        Object object2;
        Object object3 = x;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit51).match(x, arrobject, 0)) {
            TryExp tryExp;
            object2 = tryExp;
            TemplateScope templateScope = TemplateScope.make();
            Expression expression = SyntaxForms.rewrite(Lit52.execute(arrobject, templateScope));
            templateScope = TemplateScope.make();
            tryExp = new TryExp(expression, SyntaxForms.rewrite(Lit53.execute(arrobject, templateScope)));
        } else {
            object2 = syntax_case.error("syntax-case", x);
        }
        return object2;
    }

    static Object lambda2(Object x) {
        Object object2;
        Object object3 = x;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit55).match(x, arrobject, 0)) {
            SynchronizedExp synchronizedExp;
            object2 = synchronizedExp;
            TemplateScope templateScope = TemplateScope.make();
            Expression expression = SyntaxForms.rewrite(Lit56.execute(arrobject, templateScope));
            templateScope = TemplateScope.make();
            synchronizedExp = new SynchronizedExp(expression, SyntaxForms.rewriteBody(Lit57.execute(arrobject, templateScope)));
        } else {
            object2 = syntax_case.error("syntax-case", x);
        }
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Object lambda3(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit59).match(form, arrobject, 0)) {
            Object $ctx = TemplateScope.make();
            Pair pair = new Pair(Lit60, Lit61.execute(arrobject, (TemplateScope)$ctx));
            $ctx = CallContext.getInstance();
            int n = ((CallContext)$ctx).startFromContext();
            try {
                eval.eval$X(std_syntax.syntaxObject$To$Datum(pair), (CallContext)$ctx);
            }
            catch (Throwable throwable) {
                ((CallContext)$ctx).cleanupFromContext(n);
                throw throwable;
            }
            if (KawaConvert.isTrue(((CallContext)$ctx).getFromContext(n))) {
                TemplateScope templateScope = TemplateScope.make();
                object2 = Lit62.execute(arrobject, templateScope);
                return object2;
            }
        }
        object2 = syntax_case.error("syntax-case", form);
        return object2;
    }

    static Object lambda4(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(8, null);
        if (((Pattern)Lit66).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit67.execute(arrobject, templateScope);
        } else if (((Pattern)Lit68).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit69.execute(arrobject, templateScope);
        } else if (((Pattern)Lit70).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit71.execute(arrobject, templateScope);
        } else if (((Pattern)Lit72).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit73.execute(arrobject, templateScope);
        } else if (((Pattern)Lit74).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit75.execute(arrobject, templateScope);
        } else if (((Pattern)Lit76).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object4 = Lit77.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            Object xvar = std_syntax.datum$To$Syntax(object4, std_syntax.syntax$To$Datum(Lit78.execute(arrobject, templateScope)));
            templateScope = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit79.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit80.execute(arrobject, templateScope), Quote.consX$V(new Object[]{xvar, Lit81.execute(arrobject, templateScope)})}), Quote.append$V(new Object[]{Lit82.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit83.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit84.execute(arrobject, templateScope), Quote.consX$V(new Object[]{xvar, Lit85.execute(arrobject, templateScope)})}), Lit86.execute(arrobject, templateScope))}), Lit87.execute(arrobject, templateScope))}))});
        } else if (((Pattern)Lit88).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object5 = Lit89.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            Object xvar = std_syntax.datum$To$Syntax(object5, std_syntax.syntax$To$Datum(Lit90.execute(arrobject, templateScope)));
            templateScope = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit91.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit92.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit93.execute(arrobject, templateScope), xvar}), Pair.make(Quote.append$V(new Object[]{Lit94.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit95.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit96.execute(arrobject, templateScope), Quote.consX$V(new Object[]{xvar, Lit97.execute(arrobject, templateScope)})}), Lit98.execute(arrobject, templateScope))}), Lit99.execute(arrobject, templateScope))}), Lit100.execute(arrobject, templateScope)))}), Lit101.execute(arrobject, templateScope))});
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    static Object lambda5(Object form) {
        Object object2;
        public class Frame
        extends ModuleBody {
            Object[] $unnamed$0;

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public Object lambda6loop(Object object2, Object clauses) {
                Object object3;
                Object object4;
                Object object5 = clauses;
                Object[] arrobject = SyntaxPattern.allocVars(4, this.$unnamed$0);
                if (((Pattern)syntax.Lit108).match(clauses, arrobject, 0)) {
                    Object[] arrobject2 = new Object[2];
                    object3 = Promise.force(object2, TemplateScope.class);
                    arrobject2[0] = syntax.Lit109.execute(arrobject, (TemplateScope)object3);
                    object3 = Promise.force(object2, TemplateScope.class);
                    arrobject2[1] = this.lambda6loop(object2, syntax.Lit110.execute(arrobject, (TemplateScope)object3));
                    object4 = Quote.append$V(arrobject2);
                    return object4;
                }
                if (((Pattern)syntax.Lit111).match(clauses, arrobject, 0)) {
                    object4 = LList.Empty;
                    return object4;
                }
                if (!((Pattern)syntax.Lit112).match(clauses, arrobject, 0)) {
                    object4 = syntax_case.error("syntax-case", clauses);
                    return object4;
                }
                Object object6 = Promise.force(object2, TemplateScope.class);
                {
                    object4 = LList.list1(prim_syntax.reportSyntaxError(syntax.Lit113.execute(arrobject, (TemplateScope)object6), "invalid case-lambda clause"));
                }
                return object4;
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "kawa.lang.SyntaxTemplate.execute(java.lang.Object[],kawa.lang.TemplateScope)", 3, object3);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "kawa.lang.SyntaxTemplate.execute(java.lang.Object[],kawa.lang.TemplateScope)", 3, object3);
                }
            }
        }
        Frame $heapFrame = new Frame();
        Object object3 = form;
        $heapFrame.$unnamed$0 = SyntaxPattern.allocVars(1, null);
        if (((Pattern)Lit105).match(form, $heapFrame.$unnamed$0, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit106.execute($heapFrame.$unnamed$0, templateScope), $heapFrame.lambda6loop(templateScope, Lit107.execute($heapFrame.$unnamed$0, templateScope))});
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    static Object lambda7(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(3, null);
        if (((Pattern)Lit119).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit120.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit121.execute(arrobject, templateScope), Pair.make(Quote.append$V(new Object[]{Lit122.execute(arrobject, templateScope), syntax.$PcStringFormatFormat(Lit123.execute(arrobject, templateScope), Lit124.execute(arrobject, templateScope))}), Lit125.execute(arrobject, templateScope))}), syntax.$PcStringFormatArgs(Lit126.execute(arrobject, templateScope)))});
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    static Object lambda8(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(3, null);
        if (((Pattern)Lit138).match(form, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object4 = Lit139.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            Object object5 = Promise.force(std_syntax.syntax$To$Datum(Lit140.execute(arrobject, templateScope)), String.class);
            Object cname = std_syntax.datum$To$Syntax(object4, Symbol.valueOf((String)(object5 == null ? null : object5.toString()), LispLanguage.constructNamespace));
            templateScope = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit141.execute(arrobject, templateScope), Quote.consX$V(new Object[]{cname, Lit142.execute(arrobject, templateScope)})});
        } else if (((Pattern)Lit143).match(form, arrobject, 0)) {
            TemplateScope cname = TemplateScope.make();
            object2 = Lit144.execute(arrobject, cname);
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 7: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 6: {
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

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return syntax.lambda1(object2);
            }
            case 2: {
                return syntax.lambda2(object2);
            }
            case 3: {
                return syntax.lambda3(object2);
            }
            case 4: {
                return syntax.lambda4(object2);
            }
            case 5: {
                return syntax.lambda5(object2);
            }
            case 6: {
                return syntax.lambda7(object2);
            }
            case 7: {
                return syntax.lambda8(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }

}

