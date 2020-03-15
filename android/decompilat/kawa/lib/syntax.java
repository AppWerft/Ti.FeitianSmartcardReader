// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.kawa.lispexpr.LispLanguage;
import gnu.mapping.Promise;
import gnu.expr.KawaConvert;
import kawa.lib.scheme.eval;
import gnu.expr.SynchronizedExp;
import gnu.expr.TryExp;
import kawa.lang.SyntaxForms;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import kawa.lang.SyntaxRule;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Quote;
import kawa.standard.syntax_case;
import kawa.lang.TemplateScope;
import gnu.lists.LList;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.math.IntNum;
import gnu.lists.PairWithPosition;
import gnu.expr.Keyword;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import gnu.kawa.reflect.StaticFieldLocation;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class syntax extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static Object $PcStringFormatFormat(final Object default$Mnformat, final Object forms) {
        final Object[] allocVars = SyntaxPattern.allocVars(3, null);
        return syntax.Lit0.match(forms, allocVars, 0) ? LList.Empty : (syntax.Lit1.match(forms, allocVars, 0) ? $PcStringFormatEnclosedFormat(default$Mnformat, syntax.Lit2.execute(allocVars, TemplateScope.make())) : (syntax.Lit3.match(forms, allocVars, 0) ? lists.cons(syntax.Lit4.execute(allocVars, TemplateScope.make()), $PcStringFormatFormat(default$Mnformat, syntax.Lit5.execute(allocVars, TemplateScope.make()))) : (syntax.Lit6.match(forms, allocVars, 0) ? lists.cons(default$Mnformat, $PcStringFormatFormat(default$Mnformat, syntax.Lit7.execute(allocVars, TemplateScope.make()))) : (syntax.Lit8.match(forms, allocVars, 0) ? lists.cons(syntax.Lit9.execute(allocVars, TemplateScope.make()), $PcStringFormatFormat(default$Mnformat, syntax.Lit10.execute(allocVars, TemplateScope.make()))) : syntax_case.error("syntax-case", forms)))));
    }
    
    static Object $PcStringFormatEnclosedFormat(final Object default$Mnformat, final Object forms) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        Object o;
        if (syntax.Lit11.match(forms, allocVars, 0)) {
            o = LList.Empty;
        }
        else if (syntax.Lit12.match(forms, allocVars, 0)) {
            o = $PcStringFormatFormat(default$Mnformat, syntax.Lit13.execute(allocVars, TemplateScope.make()));
        }
        else if (syntax.Lit14.match(forms, allocVars, 0)) {
            final TemplateScope make = TemplateScope.make();
            o = lists.cons(Quote.append$V(new Object[] { syntax.Lit15.execute(allocVars, make), Quote.consX$V(new Object[] { default$Mnformat, syntax.Lit16.execute(allocVars, make) }) }), $PcStringFormatEnclosedFormat(default$Mnformat, syntax.Lit17.execute(allocVars, TemplateScope.make())));
        }
        else {
            o = (syntax.Lit18.match(forms, allocVars, 0) ? lists.cons(default$Mnformat, $PcStringFormatEnclosedFormat(default$Mnformat, syntax.Lit19.execute(allocVars, TemplateScope.make()))) : syntax_case.error("syntax-case", forms));
        }
        return o;
    }
    
    static Object $PcStringFormatArgs(Object forms) {
        Object o;
        while (true) {
            final Object[] allocVars = SyntaxPattern.allocVars(3, null);
            if (syntax.Lit20.match(forms, allocVars, 0)) {
                o = LList.Empty;
                break;
            }
            if (syntax.Lit21.match(forms, allocVars, 0)) {
                o = $PcStringFormatEnclosedArgs(syntax.Lit22.execute(allocVars, TemplateScope.make()));
                break;
            }
            if (syntax.Lit23.match(forms, allocVars, 0)) {
                final TemplateScope make = TemplateScope.make();
                o = Quote.append$V(new Object[] { syntax.Lit24.execute(allocVars, make), $PcStringFormatArgs(syntax.Lit25.execute(allocVars, make)) });
                break;
            }
            if (syntax.Lit26.match(forms, allocVars, 0)) {
                final TemplateScope make2 = TemplateScope.make();
                o = Quote.append$V(new Object[] { syntax.Lit27.execute(allocVars, make2), $PcStringFormatArgs(syntax.Lit28.execute(allocVars, make2)) });
                break;
            }
            if (!syntax.Lit29.match(forms, allocVars, 0)) {
                o = syntax_case.error("syntax-case", forms);
                break;
            }
            forms = syntax.Lit30.execute(allocVars, TemplateScope.make());
        }
        return o;
    }
    
    static Object $PcStringFormatEnclosedArgs(final Object forms) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        Object o;
        if (syntax.Lit31.match(forms, allocVars, 0)) {
            o = LList.Empty;
        }
        else if (syntax.Lit32.match(forms, allocVars, 0)) {
            o = $PcStringFormatArgs(syntax.Lit33.execute(allocVars, TemplateScope.make()));
        }
        else if (syntax.Lit34.match(forms, allocVars, 0)) {
            final TemplateScope make = TemplateScope.make();
            o = Quote.append$V(new Object[] { syntax.Lit35.execute(allocVars, make), $PcStringFormatEnclosedArgs(syntax.Lit36.execute(allocVars, make)) });
        }
        else if (syntax.Lit37.match(forms, allocVars, 0)) {
            final TemplateScope make2 = TemplateScope.make();
            o = Quote.append$V(new Object[] { syntax.Lit38.execute(allocVars, make2), $PcStringFormatEnclosedArgs(syntax.Lit39.execute(allocVars, make2)) });
        }
        else {
            o = syntax_case.error("syntax-case", forms);
        }
        return o;
    }
    
    static {
        (Lit206 = new Object[] { null })[0] = (Lit131 = Symbol.valueOf("$format$"));
        Lit205 = PairWithPosition.make(Lit176 = Symbol.valueOf("quote"), PairWithPosition.make(Symbol.valueOf("toString"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1048612), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1048612);
        Lit204 = Symbol.valueOf("invoke");
        (Lit203 = new Object[] { null })[0] = Symbol.valueOf("$splice$");
        Lit202 = Symbol.valueOf("string-append");
        final Object[] array = Lit201 = new Object[2];
        array[0] = (Lit200 = Symbol.valueOf("%define-macro"));
        array[1] = (Lit181 = Symbol.valueOf("lambda"));
        Lit199 = Symbol.valueOf("form");
        Lit198 = Symbol.valueOf("define-syntax");
        Lit197 = Symbol.valueOf("if");
        final Object[] array2 = Lit196 = new Object[2];
        array2[0] = (Lit183 = Symbol.valueOf("call-with-values"));
        array2[1] = syntax.Lit181;
        (Lit195 = new Object[] { null })[0] = "bind";
        (Lit194 = new Object[] { null })[0] = Symbol.valueOf("x");
        (Lit193 = new Object[] { null })[0] = "mktmp";
        Lit192 = Symbol.valueOf("car");
        Lit191 = Symbol.valueOf("cddr");
        Lit190 = Symbol.valueOf("set-cdr!");
        Lit189 = Symbol.valueOf("cadr");
        Lit188 = PairWithPosition.make(Symbol.valueOf("list"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 610316);
        Lit187 = PairWithPosition.make(Lit185 = Symbol.valueOf("v"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 626700);
        Lit186 = Symbol.valueOf("set!");
        Lit184 = Symbol.valueOf("let");
        Lit182 = Symbol.valueOf("define");
        Lit180 = Symbol.valueOf("wt");
        Lit179 = PairWithPosition.make(Lit156 = IntNum.valueOf(1), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1183809);
        Lit178 = Symbol.valueOf("as");
        Lit177 = PairWithPosition.make(Symbol.valueOf("arg"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 753674);
        Lit175 = Symbol.valueOf("gnu.mapping.LocationProc");
        Lit174 = Symbol.valueOf("constant-fold");
        Lit173 = Symbol.valueOf("gnu.kawa.functions.Format");
        Lit172 = PairWithPosition.make(IntNum.valueOf(-2), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1196075);
        Lit171 = IntNum.valueOf(0);
        Lit170 = Symbol.valueOf("gnu.lists.Range$IntRange");
        (Lit169 = new Object[] { null })[0] = (Lit157 = Keyword.make(">"));
        Lit168 = PairWithPosition.make(Lit158 = Symbol.valueOf("$lookup$"), Pair.make(Lit159 = Symbol.valueOf("gnu.kawa.functions.RangeUtils"), Pair.make(Pair.make(Lit160 = Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf("valueOfUnbounded"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1183760);
        (Lit167 = new Object[] { null })[0] = (Lit153 = Keyword.make("<"));
        Lit166 = Keyword.make("by");
        Lit165 = PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1155132);
        Lit164 = IntNum.valueOf(-1);
        Lit163 = PairWithPosition.make(syntax.Lit158, Pair.make(syntax.Lit159, Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("downto"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1159186);
        Lit162 = Keyword.make(">=");
        Lit161 = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1151035);
        Lit155 = PairWithPosition.make(syntax.Lit158, Pair.make(syntax.Lit159, Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("upto"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1150994);
        Lit154 = Keyword.make("<=");
        Lit152 = Symbol.valueOf("args");
        Lit151 = new Object[0];
        (Lit150 = new Object[] { null })[0] = (Lit149 = Symbol.valueOf("$>>$"));
        (Lit148 = new Object[] { null })[0] = (Lit147 = Symbol.valueOf("$<<$"));
        Lit146 = new SyntaxRules(new Object[] { syntax.Lit147, syntax.Lit149 }, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u0002\u001b", syntax.Lit148, 4, "syntax.scm:327"), "\u0001\u0001\u0003\u0000", "\t\u0003\b\t\u000b\u0011\u0015\u0013\u0011\u0018\u0004\u001a", syntax.Lit148, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u0002\b", syntax.Lit150, 3, "syntax.scm:329"), "\u0001\u0001\u0003", "\t\u0003\b\u0015\u0013", syntax.Lit151, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u0002\u001b", syntax.Lit150, 4, "syntax.scm:331"), "\u0001\u0001\u0003\u0000", "\t\u0003\u0011\u0015\u0013\b\t\u000b\u001a", syntax.Lit151, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\f\u001f#", syntax.Lit151, 5, "syntax.scm:333"), "\u0001\u0001\u0003\u0001\u0000", "\u0011\u0018\u0004\t\u0003\t\u000b)\u0011\u0015\u0013\b\u001b\"", new Object[] { Lit145 = Symbol.valueOf("%simple-construct-builder") }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f,\r\u0017\u0010\b\b\b", syntax.Lit151, 3, "syntax.scm:335"), "\u0001\u0001\u0003", "\t\u0003\b\t\u000b\b\u0015\u0013", syntax.Lit151, 1) }, 5, syntax.Lit145);
        Lit144 = new SyntaxTemplate("\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\u0018\f", new Object[] { Lit137 = Symbol.valueOf("define-simple-constructor"), PairWithPosition.make(Lit127 = Symbol.valueOf("$string$"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1323062) }, 0);
        Lit143 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", syntax.Lit151, 2, "syntax.scm:322");
        Lit142 = new SyntaxTemplate("\u0001\u0001\u0001", "\b\u0011\u0018\u0004\t\u0010\b\u0011\u0018\f\b\u0011\u0018\u0014\t\u000b\t\u0013\u0018\u001c", new Object[] { Symbol.valueOf("syntax-rules"), PairWithPosition.make(Symbol.valueOf("_"), syntax.Lit152, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1310737), syntax.Lit145, PairWithPosition.make(LList.Empty, syntax.Lit152, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1314887) }, 0);
        Lit141 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit198, LList.Empty) }, 0);
        Lit140 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0003", syntax.Lit151, 0);
        Lit139 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0003", syntax.Lit151, 0);
        Lit138 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", syntax.Lit151, 3, "syntax.scm:316");
        Lit136 = new SyntaxRules(new Object[] { syntax.Lit153, syntax.Lit154, syntax.Lit157, syntax.Lit162 }, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", syntax.Lit167, 2, "syntax.scm:281"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\u0018\u0014", new Object[] { syntax.Lit155, syntax.Lit156, syntax.Lit161 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", new Object[] { syntax.Lit154 }, 2, "syntax.scm:282"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\u0018\u0014", new Object[] { syntax.Lit155, syntax.Lit156, syntax.Lit165 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", syntax.Lit169, 2, "syntax.scm:283"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\u0018\u0014", new Object[] { syntax.Lit163, syntax.Lit164, syntax.Lit161 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", new Object[] { syntax.Lit162 }, 2, "syntax.scm:284"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\u0018\u0014", new Object[] { syntax.Lit163, syntax.Lit164, syntax.Lit165 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[] { syntax.Lit166, syntax.Lit153 }, 3, "syntax.scm:285"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0013\u0018\f", new Object[] { syntax.Lit155, syntax.Lit161 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[] { syntax.Lit166, syntax.Lit154 }, 3, "syntax.scm:286"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0013\u0018\f", new Object[] { syntax.Lit155, syntax.Lit165 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[] { syntax.Lit166, syntax.Lit157 }, 3, "syntax.scm:287"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0013\u0018\f", new Object[] { syntax.Lit163, syntax.Lit161 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[] { syntax.Lit166, syntax.Lit162 }, 3, "syntax.scm:288"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\t\u0013\u0018\f", new Object[] { syntax.Lit163, syntax.Lit165 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\b", syntax.Lit167, 1, "syntax.scm:289"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", new Object[] { syntax.Lit168, syntax.Lit179 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", new Object[] { syntax.Lit166 }, 2, "syntax.scm:290"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[] { syntax.Lit168 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\n\f\u0017\b", new Object[] { syntax.Lit166, Keyword.make("size") }, 3, "syntax.scm:291"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\b\u0013", new Object[] { PairWithPosition.make(syntax.Lit158, Pair.make(syntax.Lit159, Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("bySize"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1191967) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0002\b", syntax.Lit167, 0, "syntax.scm:292"), "", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit170, PairWithPosition.make(syntax.Lit171, PairWithPosition.make(syntax.Lit156, syntax.Lit172, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1196073), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1196071)) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0002\b", syntax.Lit169, 0, "syntax.scm:293"), "", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit170, PairWithPosition.make(syntax.Lit171, PairWithPosition.make(syntax.Lit164, syntax.Lit172, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1200169), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1200167)) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", syntax.Lit151, 1, "syntax.scm:294"), "\u0000", "\u0011\u0018\u0004\u0002", new Object[] { Symbol.valueOf("constant-vector") }, 0) }, 3, Lit135 = Symbol.valueOf("$bracket-list$"));
        Lit134 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u000b", syntax.Lit151, 2, "syntax.scm:276"), "\u0001\u0000", "\u0011\u0018\u0004\t\u0003\n", new Object[] { PairWithPosition.make(syntax.Lit158, Pair.make(syntax.Lit173, Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("sprintfToString"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1134599) }, 0) }, 2, Lit133 = Symbol.valueOf("$sprintf$"));
        Lit132 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", syntax.Lit151, 1, "syntax.scm:271"), "\u0000", "\u0011\u0018\u0004\t\f\u0002", new Object[] { PairWithPosition.make(syntax.Lit158, Pair.make(syntax.Lit173, Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("formatToString"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1114119), syntax.Lit171 }, 0) }, 1, syntax.Lit131);
        Lit130 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", syntax.Lit151, 1, "syntax.scm:266"), "\u0000", "\u0011\u0018\u0004\t\f\u0002", new Object[] { Lit118 = Symbol.valueOf("$string-with-default-format$"), "~Q" }, 0) }, 1, Lit129 = Symbol.valueOf("$string-with-delimiter-marks$"));
        Lit128 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", syntax.Lit151, 1, "syntax.scm:261"), "\u0000", "\u0011\u0018\u0004\t\f\u0002", new Object[] { syntax.Lit118, "~a" }, 0) }, 1, syntax.Lit127);
        Lit126 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0012", syntax.Lit151, 0);
        Lit125 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit205, LList.Empty) }, 0);
        Lit124 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0012", syntax.Lit151, 0);
        Lit123 = new SyntaxTemplate("\u0001\u0001\u0000", "\u000b", syntax.Lit151, 0);
        Lit122 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit174, PairWithPosition.make(syntax.Lit202, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1032242)) }, 0);
        Lit121 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit174, PairWithPosition.make(syntax.Lit204, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 1028131)) }, 0);
        Lit120 = new SyntaxTemplate("\u0001\u0001\u0000", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit131, LList.Empty) }, 0);
        Lit119 = new SyntaxPattern("\f\u0007\f\u000f\u0013", syntax.Lit151, 3, "syntax.scm:250");
        Lit117 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", syntax.Lit151, 3, "syntax.scm:178"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u00e9\u0011\u0018\f\t\u0003\u0011\u0018\u0014A\u0011\u0018\u001c\u0011\u0018$\b\u000b\b\u0011\u0018,)\u0011\u00184\b\u0003\b\u0013\b\u0011\u0018<\t\u0003\b\u0011\u0018D\u0011\u0018L\b\u0011\u0018T9\u0011\u0018\\\t\u000b\u0018d\b\u0011\u0018l\u0011\u0018t\b\u0011\u0018|y\b\u0011\u0018\u0084\b\u0011\u0018\u008c\u0011\u0018l\t\u0003\u0018\u0094A\u0011\u0018\u009c\u0011\u0018¤\b\u000b\u0018¬", new Object[] { Lit60 = Symbol.valueOf("begin"), Symbol.valueOf("define-constant"), Symbol.valueOf("::"), Symbol.valueOf("$bracket-apply$"), syntax.Lit175, PairWithPosition.make(syntax.Lit158, Pair.make(syntax.Lit175, Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("makeNamed"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 741380), syntax.Lit176, PairWithPosition.make(syntax.Lit158, Pair.make(syntax.Lit175, Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("pushConverter"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 745481), syntax.Lit181, syntax.Lit177, Symbol.valueOf("try-catch"), syntax.Lit178, syntax.Lit177, Symbol.valueOf("ex"), Symbol.valueOf("<java.lang.ClassCastException>"), syntax.Lit184, syntax.Lit180, PairWithPosition.make(syntax.Lit158, Pair.make(Symbol.valueOf("gnu.mapping.WrongType"), Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("make"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 770068), PairWithPosition.make(PairWithPosition.make(syntax.Lit178, PairWithPosition.make(Symbol.valueOf("<int>"), syntax.Lit179, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 774160), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 774156), syntax.Lit177, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 774156), syntax.Lit186, PairWithPosition.make(Symbol.valueOf("field"), PairWithPosition.make(syntax.Lit180, PairWithPosition.make(PairWithPosition.make(syntax.Lit176, PairWithPosition.make(Symbol.valueOf("expectedType"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778261), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778261), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778260), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778257), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 778250), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("primitive-throw"), PairWithPosition.make(syntax.Lit180, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 782357), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 782340), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 782340) }, 0) }, 3, Lit116 = Symbol.valueOf("define-alias-parameter"));
        Lit115 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\b", syntax.Lit151, 1, "syntax.scm:139"), "\u0001", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u00149\u0011\u0018\u001c\t\u0010\b\u0003\u0018$", new Object[] { syntax.Lit182, Symbol.valueOf("dummy"), syntax.Lit183, syntax.Lit181, PairWithPosition.make(PairWithPosition.make(syntax.Lit181, PairWithPosition.make(syntax.Lit152, syntax.Lit161, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 581650), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 581642), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 581642) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\f\u000f\b", syntax.Lit151, 2, "syntax.scm:143"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[] { syntax.Lit182 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018T\f\u0007\r\u000f\b\b\u0016\f\u0017\b\f\u001f\b", syntax.Lit151, 4, "syntax.scm:145"), "\u0001\u0003\u0001\u0001", "\u0011\u0018\u0004\u0099\u0011\u0018\f\t\u0003\b\u0011\u0018\u00149\u0011\u0018\u001c\t\u0010\b\u001b\u0018$\u0119\r\u0011\u0018\f\t\u000b\b\u0011\u0018,Q\b\u0011\u00184\b\u0011\u0018<\b\u0003Y\u0011\u0018D\t\u0003\b\u0011\u0018L\b\u0003\u0018T\b\u0011\u0018\f\t\u0013\b\u0011\u0018,Q\b\u0011\u00184\b\u0011\u0018<\b\u0003Y\u0011\u0018\\\t\u0003\b\u0011\u0018d\b\u0003\u0018l", new Object[] { syntax.Lit60, syntax.Lit182, syntax.Lit183, syntax.Lit181, syntax.Lit188, syntax.Lit184, syntax.Lit185, syntax.Lit189, syntax.Lit190, syntax.Lit191, syntax.Lit187, syntax.Lit186, syntax.Lit192, syntax.Lit187 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018D\f\u0007\r\u000f\b\b\u000e\u0013\f\u001f\b", syntax.Lit151, 4, "syntax.scm:158"), "\u0001\u0003\u0000\u0001", "\u0011\u0018\u0004\u0099\u0011\u0018\f\t\u0003\b\u0011\u0018\u00149\u0011\u0018\u001c\t\u0010\b\u001b\u0018$\u0119\r\u0011\u0018\f\t\u000b\b\u0011\u0018,Q\b\u0011\u00184\b\u0011\u0018<\b\u0003Y\u0011\u0018D\t\u0003\b\u0011\u0018L\b\u0003\u0018T\b\u0011\u0018\f\t\u0012\b\u0011\u0018,Q\b\u0011\u00184\b\u0011\u0018\\\b\u0003Y\u0011\u0018d\t\u0003\b\u0011\u0018l\b\u0003\u0018t", new Object[] { syntax.Lit60, syntax.Lit182, syntax.Lit183, syntax.Lit181, syntax.Lit188, syntax.Lit184, syntax.Lit185, syntax.Lit189, syntax.Lit190, syntax.Lit191, syntax.Lit187, Symbol.valueOf("cdr"), syntax.Lit186, syntax.Lit192, syntax.Lit187 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", syntax.Lit151, 2, "syntax.scm:171"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f9\u0011\u0018\u0014\t\u0010\b\u000b\u0018\u001c", new Object[] { syntax.Lit182, syntax.Lit183, syntax.Lit181, syntax.Lit188 }, 0) }, 4, Lit114 = Symbol.valueOf("define-values"));
        Lit113 = new SyntaxTemplate("\u0000\u0000", "\n", syntax.Lit151, 0);
        Lit112 = new SyntaxPattern("\u000b", syntax.Lit151, 2, "syntax.scm:132");
        Lit111 = new SyntaxPattern("\b", syntax.Lit151, 1, "syntax.scm:130");
        Lit110 = new SyntaxTemplate("\u0000\u0001\u0000\u0000", "\u001a", syntax.Lit151, 0);
        Lit109 = new SyntaxTemplate("\u0000\u0001\u0000\u0000", "\b\u0011\u0018\u0004\t\u000b\u0012", new Object[] { syntax.Lit181 }, 0);
        Lit108 = new SyntaxPattern("\u001c\f\u000f\u0013\u001b", syntax.Lit151, 4, "syntax.scm:128");
        Lit107 = new SyntaxTemplate("\u0000", "\u0002", syntax.Lit151, 0);
        Lit106 = new SyntaxTemplate("\u0000", "\u0018\u0004", new Object[] { Pair.make(PairWithPosition.make(syntax.Lit158, Pair.make(Symbol.valueOf("gnu.expr.GenericProc"), Pair.make(Pair.make(syntax.Lit160, Pair.make(Symbol.valueOf("makeWithoutSorting"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 512009), LList.Empty) }, 0);
        Lit105 = new SyntaxPattern("\f\u0018\u0003", syntax.Lit151, 1, "syntax.scm:124");
        Lit104 = Symbol.valueOf("case-lambda");
        Lit103 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\r\u000f\b\b\b", syntax.Lit151, 2, "syntax.scm:115"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\r\u000b", new Object[] { syntax.Lit60 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\r\u000f\b\b\b\f\u0017\r\u001f\u0018\b\b", syntax.Lit151, 4, "syntax.scm:118"), "\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\u0011\b\u0003\b\u0011\u0018\f\u0019\b\r\u000b\t\u0013\b\u001d\u001b", new Object[] { Lit65 = Symbol.valueOf("let-values"), Lit102 = Symbol.valueOf("let*-values") }, 1) }, 4, syntax.Lit102);
        Lit101 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0010", syntax.Lit151, 0);
        Lit100 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0010", syntax.Lit151, 0);
        Lit99 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\b3", syntax.Lit151, 0);
        Lit98 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0010", syntax.Lit151, 0);
        Lit97 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0010", syntax.Lit151, 0);
        Lit96 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\b\u000b", syntax.Lit151, 0);
        Lit95 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\b-+", syntax.Lit151, 1);
        Lit94 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\t\u0003\t\u0004\b#", syntax.Lit195, 0);
        Lit93 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\b\u001d\u001b", syntax.Lit151, 1);
        Lit92 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit181, LList.Empty) }, 0);
        Lit91 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0011\u0018\u0004\b\u0011\u0018\f\t\u0010\b\u0013", syntax.Lit196, 0);
        Lit90 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u000b", syntax.Lit151, 0);
        Lit89 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0003\u0001", "\u0018\u0004", syntax.Lit194, 0);
        Lit88 = new SyntaxPattern("\f\u0007\f\u0002\f\u000f\f\u0017,\r\u001f\u0018\b\b\f',\r/(\b\b\f7\b", syntax.Lit193, 7, "syntax.scm:106");
        Lit87 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b;", syntax.Lit151, 0);
        Lit86 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u0010", syntax.Lit151, 0);
        Lit85 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u0010", syntax.Lit151, 0);
        Lit84 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b\u000b", syntax.Lit151, 0);
        Lit83 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b53", syntax.Lit151, 1);
        Lit82 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b+", syntax.Lit151, 0);
        Lit81 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u0010", syntax.Lit151, 0);
        Lit80 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\b%#", syntax.Lit151, 1);
        Lit79 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\t\u0003\t\u0004\t\u0012\b\u001b", syntax.Lit193, 0);
        Lit78 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u000b", syntax.Lit151, 0);
        Lit77 = new SyntaxTemplate("\u0001\u0001\u0000\u0001\u0003\u0001\u0003\u0001", "\u0018\u0004", syntax.Lit194, 0);
        Lit76 = new SyntaxPattern("\f\u0007\f\u0002\u001c\f\u000f\u0013\f\u001f,\r' \b\b\f/,\r70\b\b\f?\b", syntax.Lit193, 8, "syntax.scm:101");
        Lit75 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u000b\b\u0011\u0018\f\t\u0013\b\t\u0003\t\u0014\t\u001b\t#\b+", new Object[] { syntax.Lit183, syntax.Lit181, "bind" }, 0);
        Lit74 = new SyntaxPattern("\f\u0007\f\u0002\f\b\f\u000f\f\u0017\f\u001f\f'\f/\b", syntax.Lit193, 6, "syntax.scm:95");
        Lit73 = new SyntaxTemplate("\u0001\u0001\u0001\u0003\u0001\u0001", "\t\u0003\t\u0004\t\u000b\t\u0013\t\u0010\u0019\b\u001d\u001b\t#\b+", syntax.Lit193, 1);
        Lit72 = new SyntaxPattern("\f\u0007\f\u0002\\,\f\u000f\f\u0017\b\r\u001f\u0018\b\b\f'\f/\b", syntax.Lit195, 6, "syntax.scm:92");
        Lit71 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u000b\b\u0013", new Object[] { syntax.Lit184 }, 0);
        Lit70 = new SyntaxPattern("\f\u0007\f\u0002\f\b\f\u000f\f\u0017\b", syntax.Lit195, 3, "syntax.scm:89");
        Lit69 = new SyntaxTemplate("\u0001\u0003\u0001\u0003", "\t\u0003\t\u0004\u0019\b\r\u000b\t\u0010\b\u0011\u0018\f\t\u0013\b\u001d\u001b", new Object[] { "bind", syntax.Lit60 }, 1);
        Lit68 = new SyntaxPattern("\f\u0007,\r\u000f\b\b\b\f\u0017\r\u001f\u0018\b\b", syntax.Lit151, 4, "syntax.scm:87");
        Lit67 = new SyntaxTemplate("\u0001\u0001\u0001\u0000", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u0013\b\u0011\u0018\f\t\u000b\u001a", syntax.Lit196, 0);
        Lit66 = new SyntaxPattern("\f\u0007<,\f\u000f\f\u0017\b\b\u001b", syntax.Lit151, 4, "syntax.scm:83");
        Lit64 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", syntax.Lit151, 1, "syntax.scm:69"), "\u0000", "\u0011\u0018\u0004\b\u0011\u0018\f\u0002", new Object[] { Lit58 = Symbol.valueOf("begin-for-syntax"), syntax.Lit182 }, 0) }, 1, Lit63 = Symbol.valueOf("define-for-syntax"));
        Lit62 = new SyntaxTemplate("\u0001\u0000", "\u0018\u0004", new Object[] { Values.empty }, 0);
        Lit61 = new SyntaxTemplate("\u0001\u0000", "\n", syntax.Lit151, 0);
        Lit59 = new SyntaxPattern("\f\u0007\u000b", syntax.Lit151, 2, "syntax.scm:63");
        Lit57 = new SyntaxTemplate("\u0001\u0000", "\n", syntax.Lit151, 0);
        Lit56 = new SyntaxTemplate("\u0001\u0000", "\u0003", syntax.Lit151, 0);
        Lit55 = new SyntaxPattern("\f\u0018\f\u0007\u000b", syntax.Lit151, 2, "syntax.scm:54");
        Lit54 = Symbol.valueOf("synchronized");
        Lit53 = new SyntaxTemplate("\u0001\u0001", "\u000b", syntax.Lit151, 0);
        Lit52 = new SyntaxTemplate("\u0001\u0001", "\u0003", syntax.Lit151, 0);
        Lit51 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", syntax.Lit151, 2, "syntax.scm:46");
        Lit50 = Symbol.valueOf("try-finally");
        Lit49 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", syntax.Lit151, 2, "syntax.scm:40"), "\u0001\u0003", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\b\r\u000b", new Object[] { syntax.Lit197, Symbol.valueOf("not"), syntax.Lit60 }, 1) }, 2, Lit48 = Symbol.valueOf("unless"));
        Lit47 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", syntax.Lit151, 2, "syntax.scm:36"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\b\r\u000b", new Object[] { syntax.Lit197, syntax.Lit60 }, 1) }, 2, Lit46 = Symbol.valueOf("when"));
        Lit45 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\u0013", syntax.Lit151, 3, "syntax.scm:30"), "\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\u0011\u0018\u0014\b\u0011\u0018\u001c\u0011\u0018$\t\u000b\u0012", new Object[] { syntax.Lit198, syntax.Lit181, PairWithPosition.make(syntax.Lit199, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 131089), Symbol.valueOf("syntax-case"), syntax.Lit199 }, 0) }, 3, Lit44 = Symbol.valueOf("define-syntax-case"));
        Lit43 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", syntax.Lit151, 3, "syntax.scm:23"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\n\u0012", syntax.Lit201, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", syntax.Lit151, 2, "syntax.scm:25"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[] { syntax.Lit200 }, 0) }, 3, Lit42 = Symbol.valueOf("define-macro"));
        Lit41 = new SyntaxRules(syntax.Lit151, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\u0013", syntax.Lit151, 3, "syntax.scm:18"), "\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\u000b\u0012", syntax.Lit201, 0) }, 3, Lit40 = Symbol.valueOf("defmacro"));
        Lit39 = new SyntaxTemplate("\u0001\u0000", "\n", syntax.Lit151, 0);
        Lit38 = new SyntaxTemplate("\u0001\u0000", "\b\u0003", syntax.Lit151, 0);
        Lit37 = new SyntaxPattern("\f\u0007\u000b", syntax.Lit151, 2, "syntax.scm:244");
        Lit36 = new SyntaxTemplate("\u0001\u0000", "\n", syntax.Lit151, 0);
        Lit35 = new SyntaxTemplate("\u0001\u0000", "\b\u0003", syntax.Lit151, 0);
        Lit34 = new SyntaxPattern(",\f\u0002\f\u0007\b\u000b", syntax.Lit203, 2, "syntax.scm:242");
        Lit33 = new SyntaxTemplate("\u0000", "\u0002", syntax.Lit151, 0);
        Lit32 = new SyntaxPattern("\f\u0002\u0003", syntax.Lit150, 1, "syntax.scm:240");
        Lit31 = new SyntaxPattern("\b", syntax.Lit151, 0, "syntax.scm:239");
        Lit30 = new SyntaxTemplate("\u0001\u0000", "\n", syntax.Lit151, 0);
        Lit29 = new SyntaxPattern("\f\u0007\u000b", syntax.Lit151, 2, "syntax.scm:233");
        Lit28 = new SyntaxTemplate("\u0001\u0000\u0000", "\u0012", syntax.Lit151, 0);
        Lit27 = new SyntaxTemplate("\u0001\u0000\u0000", "\b\t\u0003\n", syntax.Lit151, 0);
        Lit26 = new SyntaxPattern("\u001c\f\u0007\u000b\u0013", syntax.Lit151, 3, "syntax.scm:231");
        Lit25 = new SyntaxTemplate("\u0001\u0003\u0000", "\u0012", syntax.Lit151, 0);
        Lit24 = new SyntaxTemplate("\u0001\u0003\u0000", "\b\r\u000b", syntax.Lit151, 1);
        Lit23 = new SyntaxPattern("L\f\u0002\f\u0007\r\u000f\b\b\b\u0013", syntax.Lit206, 3, "syntax.scm:229");
        Lit22 = new SyntaxTemplate("\u0000", "\u0002", syntax.Lit151, 0);
        Lit21 = new SyntaxPattern("\f\u0002\u0003", syntax.Lit148, 1, "syntax.scm:227");
        Lit20 = new SyntaxPattern("\b", syntax.Lit151, 0, "syntax.scm:226");
        Lit19 = new SyntaxTemplate("\u0001\u0000", "\n", syntax.Lit151, 0);
        Lit18 = new SyntaxPattern("\f\u0007\u000b", syntax.Lit151, 2, "syntax.scm:220");
        Lit17 = new SyntaxTemplate("\u0001\u0000", "\n", syntax.Lit151, 0);
        Lit16 = new SyntaxTemplate("\u0001\u0000", "\u0018\u0004", new Object[] { Pair.make("~}", LList.Empty) }, 0);
        Lit15 = new SyntaxTemplate("\u0001\u0000", "\u0018\u0004", new Object[] { Pair.make(syntax.Lit174, PairWithPosition.make(syntax.Lit202, PairWithPosition.make("~{", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 892971), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 892957)) }, 0);
        Lit14 = new SyntaxPattern(",\f\u0002\f\u0007\b\u000b", syntax.Lit203, 2, "syntax.scm:217");
        Lit13 = new SyntaxTemplate("\u0000", "\u0002", syntax.Lit151, 0);
        Lit12 = new SyntaxPattern("\f\u0002\u0003", syntax.Lit150, 1, "syntax.scm:215");
        Lit11 = new SyntaxPattern("\b", syntax.Lit151, 0, "syntax.scm:214");
        Lit10 = new SyntaxTemplate("\u0001\u0000", "\n", syntax.Lit151, 0);
        Lit9 = new SyntaxTemplate("\u0001\u0000", "\u0011\u0018\u0004\u0011\u0018\fQ\u0011\u0018\u0004\u0011\u0018\f\t\u0003\u0018\u0014\u0018\u001c", new Object[] { syntax.Lit174, syntax.Lit204, PairWithPosition.make(syntax.Lit205, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 843836), PairWithPosition.make(PairWithPosition.make(syntax.Lit176, PairWithPosition.make(Symbol.valueOf("replace"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847902), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847902), PairWithPosition.make("~", PairWithPosition.make("~~", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847914), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm", 847901) }, 0);
        Lit8 = new SyntaxPattern("\f\u0007\u000b", syntax.Lit151, 2, "syntax.scm:205");
        Lit7 = new SyntaxTemplate("\u0001\u0000\u0000", "\u0012", syntax.Lit151, 0);
        Lit6 = new SyntaxPattern("\u001c\f\u0007\u000b\u0013", syntax.Lit151, 3, "syntax.scm:203");
        Lit5 = new SyntaxTemplate("\u0001\u0000\u0000", "\u0012", syntax.Lit151, 0);
        Lit4 = new SyntaxTemplate("\u0001\u0000\u0000", "\u0003", syntax.Lit151, 0);
        Lit3 = new SyntaxPattern(",\f\u0002\f\u0007\u000b\u0013", syntax.Lit206, 3, "syntax.scm:201");
        Lit2 = new SyntaxTemplate("\u0000", "\u0002", syntax.Lit151, 0);
        Lit1 = new SyntaxPattern("\f\u0002\u0003", syntax.Lit148, 1, "syntax.scm:199");
        Lit0 = new SyntaxPattern("\b", syntax.Lit151, 0, "syntax.scm:198");
        syntax.$instance = new syntax();
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
        defmacro = Macro.make(syntax.Lit40, syntax.Lit41, "kawa.lib.syntax");
        define$Mnmacro = Macro.make(syntax.Lit42, syntax.Lit43, "kawa.lib.syntax");
        define$Mnsyntax$Mncase = Macro.make(syntax.Lit44, syntax.Lit45, "kawa.lib.syntax");
        when = Macro.make(syntax.Lit46, syntax.Lit47, "kawa.lib.syntax");
        unless = Macro.make(syntax.Lit48, syntax.Lit49, "kawa.lib.syntax");
        final SimpleSymbol lit50 = syntax.Lit50;
        final ModuleMethod expander = new ModuleMethod(syntax.$instance, 1, null, 4097);
        expander.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:44");
        try$Mnfinally = Macro.makeSkipScanForm(lit50, expander, "kawa.lib.syntax");
        final SimpleSymbol lit51 = syntax.Lit54;
        final ModuleMethod expander2 = new ModuleMethod(syntax.$instance, 2, null, 4097);
        expander2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:52");
        synchronized = Macro.makeSkipScanForm(lit51, expander2, "kawa.lib.syntax");
        final SimpleSymbol lit52 = syntax.Lit58;
        final ModuleMethod expander3 = new ModuleMethod(syntax.$instance, 3, null, 4097);
        expander3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:61");
        begin$Mnfor$Mnsyntax = Macro.make(lit52, expander3, "kawa.lib.syntax");
        define$Mnfor$Mnsyntax = Macro.make(syntax.Lit63, syntax.Lit64, "kawa.lib.syntax");
        final SimpleSymbol lit53 = syntax.Lit65;
        final ModuleMethod expander4 = new ModuleMethod(syntax.$instance, 4, null, 4097);
        expander4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:79");
        let$Mnvalues = Macro.make(lit53, expander4, "kawa.lib.syntax");
        let$St$Mnvalues = Macro.make(syntax.Lit102, syntax.Lit103, "kawa.lib.syntax");
        case$Mnlambda = Macro.make(syntax.Lit104, new ModuleMethod(syntax.$instance, 5, null, 4097), "kawa.lib.syntax");
        define$Mnvalues = Macro.make(syntax.Lit114, syntax.Lit115, "kawa.lib.syntax");
        define$Mnalias$Mnparameter = Macro.make(syntax.Lit116, syntax.Lit117, "kawa.lib.syntax");
        final SimpleSymbol lit54 = syntax.Lit118;
        final ModuleMethod expander5 = new ModuleMethod(syntax.$instance, 6, null, 4097);
        expander5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:248");
        $string$Mnwith$Mndefault$Mnformat$ = Macro.make(lit54, expander5, "kawa.lib.syntax");
        $string$ = Macro.make(syntax.Lit127, syntax.Lit128, "kawa.lib.syntax");
        $string$Mnwith$Mndelimiter$Mnmarks$ = Macro.make(syntax.Lit129, syntax.Lit130, "kawa.lib.syntax");
        $format$ = Macro.make(syntax.Lit131, syntax.Lit132, "kawa.lib.syntax");
        $sprintf$ = Macro.make(syntax.Lit133, syntax.Lit134, "kawa.lib.syntax");
        $bracket$Mnlist$ = Macro.make(syntax.Lit135, syntax.Lit136, "kawa.lib.syntax");
        final SimpleSymbol lit55 = syntax.Lit137;
        final ModuleMethod expander6 = new ModuleMethod(syntax.$instance, 7, null, 4097);
        expander6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/syntax.scm:314");
        define$Mnsimple$Mnconstructor = Macro.make(lit55, expander6, "kawa.lib.syntax");
        $Prvt$$Pcsimple$Mnconstruct$Mnbuilder = Macro.make(syntax.Lit145, syntax.Lit146, "kawa.lib.syntax");
        $runBody$();
    }
    
    public syntax() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object x) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        return syntax.Lit51.match(x, allocVars, 0) ? new TryExp(SyntaxForms.rewrite(syntax.Lit52.execute(allocVars, TemplateScope.make())), SyntaxForms.rewrite(syntax.Lit53.execute(allocVars, TemplateScope.make()))) : syntax_case.error("syntax-case", x);
    }
    
    static Object lambda2(final Object x) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        return syntax.Lit55.match(x, allocVars, 0) ? new SynchronizedExp(SyntaxForms.rewrite(syntax.Lit56.execute(allocVars, TemplateScope.make())), SyntaxForms.rewriteBody(syntax.Lit57.execute(allocVars, TemplateScope.make()))) : syntax_case.error("syntax-case", x);
    }
    
    static Object lambda3(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        if (syntax.Lit59.match(form, allocVars, 0)) {
            final SimpleSymbol lit60 = syntax.Lit60;
            CallContext $ctx = (CallContext)TemplateScope.make();
            final Object syntaxObject$To$Datum = std_syntax.syntaxObject$To$Datum(new Pair(lit60, syntax.Lit61.execute(allocVars, (TemplateScope)$ctx)));
            final CallContext callContext = $ctx = CallContext.getInstance();
            final int startFromContext = $ctx.startFromContext();
            try {
                eval.eval$X(syntaxObject$To$Datum, callContext);
            }
            finally {
                $ctx.cleanupFromContext(startFromContext);
            }
            if (KawaConvert.isTrue($ctx.getFromContext(startFromContext))) {
                return syntax.Lit62.execute(allocVars, TemplateScope.make());
            }
        }
        return syntax_case.error("syntax-case", form);
    }
    
    static Object lambda4(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(8, null);
        Object o;
        if (syntax.Lit66.match(form, allocVars, 0)) {
            o = syntax.Lit67.execute(allocVars, TemplateScope.make());
        }
        else if (syntax.Lit68.match(form, allocVars, 0)) {
            o = syntax.Lit69.execute(allocVars, TemplateScope.make());
        }
        else if (syntax.Lit70.match(form, allocVars, 0)) {
            o = syntax.Lit71.execute(allocVars, TemplateScope.make());
        }
        else if (syntax.Lit72.match(form, allocVars, 0)) {
            o = syntax.Lit73.execute(allocVars, TemplateScope.make());
        }
        else if (syntax.Lit74.match(form, allocVars, 0)) {
            o = syntax.Lit75.execute(allocVars, TemplateScope.make());
        }
        else if (syntax.Lit76.match(form, allocVars, 0)) {
            final Object xvar = std_syntax.datum$To$Syntax(syntax.Lit77.execute(allocVars, TemplateScope.make()), std_syntax.syntax$To$Datum(syntax.Lit78.execute(allocVars, TemplateScope.make())));
            final TemplateScope make = TemplateScope.make();
            o = Quote.append$V(new Object[] { syntax.Lit79.execute(allocVars, make), Pair.make(Quote.append$V(new Object[] { syntax.Lit80.execute(allocVars, make), Quote.consX$V(new Object[] { xvar, syntax.Lit81.execute(allocVars, make) }) }), Quote.append$V(new Object[] { syntax.Lit82.execute(allocVars, make), Pair.make(Quote.append$V(new Object[] { syntax.Lit83.execute(allocVars, make), Pair.make(Quote.append$V(new Object[] { syntax.Lit84.execute(allocVars, make), Quote.consX$V(new Object[] { xvar, syntax.Lit85.execute(allocVars, make) }) }), syntax.Lit86.execute(allocVars, make)) }), syntax.Lit87.execute(allocVars, make)) })) });
        }
        else if (syntax.Lit88.match(form, allocVars, 0)) {
            final Object xvar = std_syntax.datum$To$Syntax(syntax.Lit89.execute(allocVars, TemplateScope.make()), std_syntax.syntax$To$Datum(syntax.Lit90.execute(allocVars, TemplateScope.make())));
            final TemplateScope make2 = TemplateScope.make();
            o = Quote.append$V(new Object[] { syntax.Lit91.execute(allocVars, make2), Pair.make(Quote.append$V(new Object[] { syntax.Lit92.execute(allocVars, make2), Pair.make(Quote.append$V(new Object[] { syntax.Lit93.execute(allocVars, make2), xvar }), Pair.make(Quote.append$V(new Object[] { syntax.Lit94.execute(allocVars, make2), Pair.make(Quote.append$V(new Object[] { syntax.Lit95.execute(allocVars, make2), Pair.make(Quote.append$V(new Object[] { syntax.Lit96.execute(allocVars, make2), Quote.consX$V(new Object[] { xvar, syntax.Lit97.execute(allocVars, make2) }) }), syntax.Lit98.execute(allocVars, make2)) }), syntax.Lit99.execute(allocVars, make2)) }), syntax.Lit100.execute(allocVars, make2))) }), syntax.Lit101.execute(allocVars, make2)) });
        }
        else {
            o = syntax_case.error("syntax-case", form);
        }
        return o;
    }
    
    static Object lambda5(final Object form) {
        public class syntax$frame extends ModuleBody
        {
            Object[] $unnamed$0;
            
            public Object lambda6loop(final Object p0, final Object clauses) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: astore_3       
                //     2: iconst_4       
                //     3: aload_0         /* this */
                //     4: getfield        kawa/lib/syntax$frame.$unnamed$0:[Ljava/lang/Object;
                //     7: invokestatic    kawa/lang/SyntaxPattern.allocVars:(I[Ljava/lang/Object;)[Ljava/lang/Object;
                //    10: astore          4
                //    12: getstatic       kawa/lib/syntax.Lit108:Lkawa/lang/SyntaxPattern;
                //    15: aload_2         /* clauses */
                //    16: aload           4
                //    18: iconst_0       
                //    19: invokevirtual   kawa/lang/Pattern.match:(Ljava/lang/Object;[Ljava/lang/Object;I)Z
                //    22: ifeq            86
                //    25: iconst_2       
                //    26: anewarray       Ljava/lang/Object;
                //    29: dup            
                //    30: iconst_0       
                //    31: getstatic       kawa/lib/syntax.Lit109:Lkawa/lang/SyntaxTemplate;
                //    34: aload           4
                //    36: aload_1        
                //    37: ldc             Lkawa/lang/TemplateScope;.class
                //    39: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    42: dup            
                //    43: astore          5
                //    45: checkcast       Lkawa/lang/TemplateScope;
                //    48: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
                //    51: aastore        
                //    52: dup            
                //    53: iconst_1       
                //    54: aload_0         /* this */
                //    55: aload_1        
                //    56: getstatic       kawa/lib/syntax.Lit110:Lkawa/lang/SyntaxTemplate;
                //    59: aload           4
                //    61: aload_1        
                //    62: ldc             Lkawa/lang/TemplateScope;.class
                //    64: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    67: dup            
                //    68: astore          5
                //    70: checkcast       Lkawa/lang/TemplateScope;
                //    73: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
                //    76: invokevirtual   kawa/lib/syntax$frame.lambda6loop:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    79: aastore        
                //    80: invokestatic    kawa/lang/Quote.append$V:([Ljava/lang/Object;)Ljava/lang/Object;
                //    83: goto            162
                //    86: getstatic       kawa/lib/syntax.Lit111:Lkawa/lang/SyntaxPattern;
                //    89: aload_2         /* clauses */
                //    90: aload           4
                //    92: iconst_0       
                //    93: invokevirtual   kawa/lang/Pattern.match:(Ljava/lang/Object;[Ljava/lang/Object;I)Z
                //    96: ifeq            105
                //    99: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
                //   102: goto            162
                //   105: getstatic       kawa/lib/syntax.Lit112:Lkawa/lang/SyntaxPattern;
                //   108: aload_2         /* clauses */
                //   109: aload           4
                //   111: iconst_0       
                //   112: invokevirtual   kawa/lang/Pattern.match:(Ljava/lang/Object;[Ljava/lang/Object;I)Z
                //   115: ifeq            156
                //   118: getstatic       kawa/lib/syntax.Lit113:Lkawa/lang/SyntaxTemplate;
                //   121: aload           4
                //   123: aload_1        
                //   124: ldc             Lkawa/lang/TemplateScope;.class
                //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //   129: dup            
                //   130: astore          5
                //   132: checkcast       Lkawa/lang/TemplateScope;
                //   135: invokevirtual   kawa/lang/SyntaxTemplate.execute:([Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
                //   138: iconst_1       
                //   139: anewarray       Ljava/lang/Object;
                //   142: dup            
                //   143: iconst_0       
                //   144: ldc             "invalid case-lambda clause"
                //   146: aastore        
                //   147: invokestatic    kawa/lib/prim_syntax.reportSyntaxError:(Ljava/lang/Object;[Ljava/lang/Object;)Lgnu/expr/Expression;
                //   150: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
                //   153: goto            162
                //   156: ldc             "syntax-case"
                //   158: aload_2         /* clauses */
                //   159: invokestatic    kawa/standard/syntax_case.error:(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
                //   162: areturn        
                //   163: new             Lgnu/mapping/WrongType;
                //   166: dup_x1         
                //   167: swap           
                //   168: ldc             "kawa.lang.SyntaxTemplate.execute(java.lang.Object[],kawa.lang.TemplateScope)"
                //   170: iconst_3       
                //   171: aload           5
                //   173: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   176: athrow         
                //   177: new             Lgnu/mapping/WrongType;
                //   180: dup_x1         
                //   181: swap           
                //   182: ldc             "kawa.lang.SyntaxTemplate.execute(java.lang.Object[],kawa.lang.TemplateScope)"
                //   184: iconst_3       
                //   185: aload           5
                //   187: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   190: athrow         
                //   191: new             Lgnu/mapping/WrongType;
                //   194: dup_x1         
                //   195: swap           
                //   196: ldc             "kawa.lang.SyntaxTemplate.execute(java.lang.Object[],kawa.lang.TemplateScope)"
                //   198: iconst_3       
                //   199: aload           5
                //   201: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   204: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  45     48     163    177    Ljava/lang/ClassCastException;
                //  70     73     177    191    Ljava/lang/ClassCastException;
                //  132    135    191    205    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index 104 out of bounds for length 104
                //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
                //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
                //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
                //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
                //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:670)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
                //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
                //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        }
        final syntax$frame $heapFrame = new syntax$frame();
        $heapFrame.$unnamed$0 = SyntaxPattern.allocVars(1, null);
        Object o;
        if (syntax.Lit105.match(form, $heapFrame.$unnamed$0, 0)) {
            final TemplateScope make = TemplateScope.make();
            o = Quote.append$V(new Object[] { syntax.Lit106.execute($heapFrame.$unnamed$0, make), $heapFrame.lambda6loop(make, syntax.Lit107.execute($heapFrame.$unnamed$0, make)) });
        }
        else {
            o = syntax_case.error("syntax-case", form);
        }
        return o;
    }
    
    static Object lambda7(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(3, null);
        Object o;
        if (syntax.Lit119.match(form, allocVars, 0)) {
            final TemplateScope make = TemplateScope.make();
            o = Quote.append$V(new Object[] { syntax.Lit120.execute(allocVars, make), Pair.make(Quote.append$V(new Object[] { syntax.Lit121.execute(allocVars, make), Pair.make(Quote.append$V(new Object[] { syntax.Lit122.execute(allocVars, make), $PcStringFormatFormat(syntax.Lit123.execute(allocVars, make), syntax.Lit124.execute(allocVars, make)) }), syntax.Lit125.execute(allocVars, make)) }), $PcStringFormatArgs(syntax.Lit126.execute(allocVars, make))) });
        }
        else {
            o = syntax_case.error("syntax-case", form);
        }
        return o;
    }
    
    static Object lambda8(final Object form) {
        final Object[] allocVars = SyntaxPattern.allocVars(3, null);
        Object append$V;
        if (syntax.Lit138.match(form, allocVars, 0)) {
            final Object execute = syntax.Lit139.execute(allocVars, TemplateScope.make());
            final Object force = Promise.force(std_syntax.syntax$To$Datum(syntax.Lit140.execute(allocVars, TemplateScope.make())), String.class);
            final Object cname = std_syntax.datum$To$Syntax(execute, Symbol.valueOf((force == null) ? null : force.toString(), LispLanguage.constructNamespace));
            final TemplateScope make = TemplateScope.make();
            append$V = Quote.append$V(new Object[] { syntax.Lit141.execute(allocVars, make), Quote.consX$V(new Object[] { cname, syntax.Lit142.execute(allocVars, make) }) });
        }
        else {
            append$V = (syntax.Lit143.match(form, allocVars, 0) ? syntax.Lit144.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", form));
        }
        return append$V;
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 7: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 6: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 5: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        switch (method.selector) {
            case 1: {
                return lambda1(o);
            }
            case 2: {
                return lambda2(o);
            }
            case 3: {
                return lambda3(o);
            }
            case 4: {
                return lambda4(o);
            }
            case 5: {
                return lambda5(o);
            }
            case 6: {
                return lambda7(o);
            }
            case 7: {
                return lambda8(o);
            }
            default: {
                return super.apply1(method, o);
            }
        }
    }
}
