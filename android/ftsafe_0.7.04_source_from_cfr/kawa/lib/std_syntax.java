/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.KawaConvert;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.QuoteExp;
import gnu.expr.Symbols;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.MakePromise;
import gnu.kawa.functions.NumberCompare;
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
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.Quote;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxForms;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lang.Translator;
import kawa.lib.prim_syntax;
import kawa.standard.syntax_case;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class std_syntax
extends ModuleBody {
    public static final Macro cond;
    public static final Macro and;
    public static final Macro or;
    public static final Macro let;
    public static final Macro let$St;
    public static final Macro do;
    public static final Macro delay;
    public static final Macro lazy;
    public static final Macro delay$Mnforce;
    public static final Macro else;
    public static final Macro $Dt$Dt$Dt;
    public static final Macro $Qu;
    public static final Macro $Eq$Gr;
    public static final Macro _;
    public static final Macro unquote;
    public static final Macro unquote$Mnsplicing;
    public static final ModuleMethod syntax$Mn$Grdatum;
    public static final ModuleMethod datum$Mn$Grsyntax;
    public static final Macro with$Mnsyntax;
    public static final ModuleMethod syntax$Mnobject$Mn$Grdatum;
    public static final ModuleMethod datum$Mn$Grsyntax$Mnobject;
    public static final ModuleMethod generate$Mntemporaries;
    public static final Macro define$Mnprocedure;
    public static final ModuleMethod identifier$Qu;
    public static final ModuleMethod free$Mnidentifier$Eq$Qu;
    public static final ModuleMethod bound$Mnidentifier$Eq$Qu;
    public static final ModuleMethod syntax$Mnsource;
    public static final ModuleMethod syntax$Mnline;
    public static final ModuleMethod syntax$Mncolumn;
    public static final StaticFieldLocation $Prvt$if;
    public static final StaticFieldLocation $Prvt$letrec;
    public static final StaticFieldLocation $Prvt$syntax$Mncase;
    public static final StaticFieldLocation $Prvt$$Pclet;
    public static final StaticFieldLocation $Prvt$$Pcdefine;
    public static final StaticFieldLocation $Prvt$lambda;
    public static final StaticFieldLocation $Prvt$not;
    public static final StaticFieldLocation $Prvt$begin;
    public static final StaticFieldLocation $Prvt$syntax$Mnerror;
    public static final Macro $Prvt$$Pclet$Mnlambda1;
    public static final Macro $Prvt$$Pclet$Mnlambda2;
    public static final Macro $Prvt$$Pclet$Mninit;
    public static final Macro $Prvt$$Pcdo$Mnstep;
    public static final Macro $Prvt$$Pcdo$Mninit;
    public static final Macro $Prvt$$Pcdo$Mnlambda1;
    public static final Macro $Prvt$$Pcdo$Mnlambda2;
    static final IntNum Lit0;
    static final IntNum Lit1;
    public static std_syntax $instance;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit6;
    static final SyntaxRules Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
    static final SimpleSymbol Lit10;
    static final SyntaxRules Lit11;
    static final SimpleSymbol Lit12;
    static final SyntaxRules Lit13;
    static final SimpleSymbol Lit14;
    static final SyntaxRules Lit15;
    static final SimpleSymbol Lit16;
    static final SyntaxRules Lit17;
    static final SimpleSymbol Lit18;
    static final SyntaxPattern Lit19;
    static final SyntaxPattern Lit20;
    static final SyntaxTemplate Lit21;
    static final SyntaxPattern Lit22;
    static final SyntaxTemplate Lit23;
    static final SimpleSymbol Lit24;
    static final SyntaxPattern Lit25;
    static final SyntaxPattern Lit26;
    static final SyntaxTemplate Lit27;
    static final SyntaxPattern Lit28;
    static final SyntaxTemplate Lit29;
    static final SimpleSymbol Lit30;
    static final SyntaxRules Lit31;
    static final SimpleSymbol Lit32;
    static final SyntaxRules Lit33;
    static final SimpleSymbol Lit34;
    static final SyntaxRules Lit35;
    static final SimpleSymbol Lit36;
    static final SyntaxRules Lit37;
    static final SimpleSymbol Lit38;
    static final SyntaxRules Lit39;
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
    static final SimpleSymbol Lit53;
    static final SyntaxPattern Lit54;
    static final SyntaxTemplate Lit55;
    static final SimpleSymbol Lit56;
    static final SyntaxPattern Lit57;
    static final SyntaxTemplate Lit58;
    static final SimpleSymbol Lit59;
    static final SyntaxRules Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SyntaxRules Lit73;
    static final Object[] Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final Object[] Lit77;
    static final Object[] Lit78;
    static final SimpleSymbol Lit79;
    static final Object[] Lit80;
    static final Object[] Lit81;
    static final Object[] Lit82;
    static final SimpleSymbol Lit83;
    static final Object[] Lit84;
    static final SimpleSymbol Lit85;
    static final SimpleSymbol Lit86;
    static final Object[] Lit87;
    static final Object[] Lit88;
    static final SimpleSymbol Lit89;
    static final Object[] Lit90;
    static final Object[] Lit91;
    static final SimpleSymbol Lit92;
    static final Object[] Lit93;
    static final PairWithPosition Lit94;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static Object syntax$To$Datum(Object obj) {
        return Quote.quote(obj);
    }

    public static Object syntaxObject$To$Datum(Object obj) {
        return std_syntax.syntax$To$Datum(obj);
    }

    public static Object datum$To$Syntax(Object object2, Object object3) {
        return std_syntax.datum$To$Syntax(object2, object3, null);
    }

    public static Object datum$To$Syntax(Object template$Mnidentifier, Object obj, Object srcloc) {
        return SyntaxForms.makeWithTemplate(template$Mnidentifier, obj, srcloc);
    }

    public static Object datum$To$SyntaxObject(Object template$Mnidentifier, Object obj) {
        return std_syntax.datum$To$Syntax(template$Mnidentifier, obj);
    }

    public static Object generateTemporaries(Object list) {
        Integer n;
        EmptyList lst;
        Object object2 = Translator.listLength(list);
        LList lList = lst = LList.Empty;
        while (!NumberCompare.$Eq(n = object2, Lit0)) {
            object2 = AddOp.apply2(-1, n, Lit1);
            lList = new Pair(std_syntax.datum$To$SyntaxObject(list, Symbols.gentemp()), lst);
        }
        return lst;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isIdentifier(Object form) {
        boolean bl;
        boolean x = form instanceof Symbol;
        if (x) {
            bl = x;
            return bl;
        }
        if (!(form instanceof SyntaxForm)) {
            return false;
        }
        Object object2 = Promise.force(form, SyntaxForm.class);
        try {
            bl = SyntaxForms.isIdentifier((SyntaxForm)object2);
            return bl;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "kawa.lang.SyntaxForms.isIdentifier(kawa.lang.SyntaxForm)", 1, object2);
        }
    }

    public static boolean isFreeIdentifier$Eq(Object id1, Object id2) {
        return std_syntax.isIdentifier(id1) && std_syntax.isIdentifier(id2) ? SyntaxForms.identifierEquals(id1, id2, false) : KawaConvert.isTrue(prim_syntax.reportSyntaxError(std_syntax.isIdentifier(id1) ? id2 : id1, "free-identifier-? - argument is not an identifier"));
    }

    public static boolean isBoundIdentifier$Eq(Object id1, Object id2) {
        return std_syntax.isIdentifier(id1) && std_syntax.isIdentifier(id2) ? SyntaxForms.identifierEquals(id1, id2, true) : KawaConvert.isTrue(prim_syntax.reportSyntaxError(std_syntax.isIdentifier(id1) ? id2 : id1, "bound-identifier-? - argument is not an identifier"));
    }

    public static Object syntaxSource(Object form) {
        String str;
        while (form instanceof SyntaxForm) {
            form = ((SyntaxForm)Promise.force(form, SyntaxForm.class)).getDatum();
        }
        return form instanceof PairWithPosition ? ((str = ((PairWithPosition)Promise.force(form, PairWithPosition.class)).getFileName()) == null ? Boolean.FALSE : str) : Boolean.FALSE;
    }

    public static Object syntaxLine(Object form) {
        while (form instanceof SyntaxForm) {
            form = ((SyntaxForm)Promise.force(form, SyntaxForm.class)).getDatum();
        }
        return form instanceof PairWithPosition ? (Comparable<Integer>)((PairWithPosition)Promise.force(form, PairWithPosition.class)).getLineNumber() : (Comparable<Integer>)Boolean.FALSE;
    }

    public static Object syntaxColumn(Object form) {
        return form instanceof SyntaxForm ? std_syntax.syntaxLine(((SyntaxForm)Promise.force(form, SyntaxForm.class)).getDatum()) : (form instanceof PairWithPosition ? (Comparable<Integer>)(((PairWithPosition)Promise.force(form, PairWithPosition.class)).getColumnNumber() - 0) : (Comparable<Integer>)Boolean.FALSE);
    }

    public static {
        Lit92 = Symbol.valueOf("temp");
        Lit94 = PairWithPosition.make(Lit92, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 294935);
        Object[] arrobject = new Object[1];
        Lit93 = arrobject;
        Lit4 = Symbol.valueOf("=>");
        arrobject[0] = Lit4;
        Object[] arrobject2 = new Object[1];
        Lit91 = arrobject2;
        Lit10 = Symbol.valueOf("else");
        arrobject2[0] = Lit10;
        Object[] arrobject3 = new Object[1];
        Lit90 = arrobject3;
        Lit75 = Symbol.valueOf("begin");
        arrobject3[0] = Lit75;
        Lit89 = Symbol.valueOf("if");
        Object[] arrobject4 = new Object[1];
        Lit88 = arrobject4;
        Lit32 = Symbol.valueOf("%let-lambda2");
        arrobject4[0] = Lit32;
        Object[] arrobject5 = new Object[2];
        Lit87 = arrobject5;
        Lit30 = Symbol.valueOf("%let-lambda1");
        arrobject5[0] = Lit30;
        Lit79 = Symbol.valueOf("::");
        arrobject5[1] = Lit79;
        Lit86 = Symbol.valueOf("letrec");
        Lit85 = Symbol.valueOf("%let");
        Object[] arrobject6 = new Object[1];
        Lit84 = arrobject6;
        arrobject6[0] = Lit85;
        Lit83 = Symbol.valueOf("syntax-error");
        Object[] arrobject7 = new Object[1];
        Lit82 = arrobject7;
        Lit46 = Symbol.valueOf("%do-lambda2");
        arrobject7[0] = Lit46;
        Object[] arrobject8 = new Object[1];
        Lit81 = arrobject8;
        Lit44 = Symbol.valueOf("%do-lambda1");
        arrobject8[0] = Lit44;
        Object[] arrobject9 = new Object[2];
        Lit80 = arrobject9;
        arrobject9[0] = Lit44;
        arrobject9[1] = Lit79;
        Object[] arrobject10 = new Object[1];
        Lit78 = arrobject10;
        arrobject10[0] = Lit79;
        Object[] arrobject11 = new Object[1];
        Lit77 = arrobject11;
        arrobject11[0] = Symbol.valueOf("lambda");
        Lit76 = Symbol.valueOf("syntax-case");
        Lit74 = new Object[0];
        Lit72 = Symbol.valueOf("with-syntax");
        Lit73 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\r\u000f\b\b\b", Lit74, 2, "std_syntax.scm:357"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\r\u000b", Lit90, 1), new SyntaxRule(new SyntaxPattern("\f\u0018<,\f\u0007\f\u000f\b\b\f\u0017\r\u001f\u0018\b\b", Lit74, 4, "std_syntax.scm:359"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\t\u0010\b\t\u0003\b\u0011\u0018\f\t\u0013\b\u001d\u001b", new Object[]{Lit76, Lit75}, 1), new SyntaxRule(new SyntaxPattern("\f\u0018L-\f\u0007\f\u000f\b\u0000\u0010\b\f\u0017\r\u001f\u0018\b\b", Lit74, 4, "std_syntax.scm:361"), "\u0003\u0003\u0001\u0003", "\u0011\u0018\u00041\u0011\u0018\f\b\r\u000b\t\u0010\b\u0019\b\u0005\u0003\b\u0011\u0018\u0014\t\u0013\b\u001d\u001b", new Object[]{Lit76, Symbol.valueOf("list"), Lit75}, 1)}, 4, Lit72);
        Lit71 = Symbol.valueOf("syntax-column");
        Lit70 = Symbol.valueOf("syntax-line");
        Lit69 = Symbol.valueOf("syntax-source");
        Lit68 = Symbol.valueOf("bound-identifier=?");
        Lit67 = Symbol.valueOf("free-identifier=?");
        Lit66 = Symbol.valueOf("identifier?");
        Lit65 = Symbol.valueOf("generate-temporaries");
        Lit64 = Symbol.valueOf("datum->syntax-object");
        Lit63 = Symbol.valueOf("datum->syntax");
        Lit62 = Symbol.valueOf("syntax-object->datum");
        Lit61 = Symbol.valueOf("syntax->datum");
        Lit59 = Symbol.valueOf("define-procedure");
        Lit60 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u000b", Lit74, 2, "std_syntax.scm:275"), "\u0001\u0000", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\n", new Object[]{Symbol.valueOf("%define"), IntNum.valueOf(27), Symbol.valueOf("gnu.expr.GenericProc")}, 0)}, 2, Lit59);
        Lit58 = new SyntaxTemplate("\u0001\u0001", "\u0011\u0018\u0004\t\u0010\b\u000b", Lit77, 0);
        Lit57 = new SyntaxPattern("\f\u0007\f\u000f\b", Lit74, 2, "std_syntax.scm:269");
        Lit56 = Symbol.valueOf("delay");
        Lit55 = new SyntaxTemplate("\u0001", "\u0011\u0018\u0004\t\u0010\b\u0003", Lit77, 0);
        Lit54 = new SyntaxPattern("\f\u0018\f\u0007\b", Lit74, 1, "std_syntax.scm:263");
        Lit53 = Symbol.valueOf("delay-force");
        Lit52 = new SyntaxTemplate("\u0001", "\u0011\u0018\u0004\t\u0010\b\u0003", Lit77, 0);
        Lit51 = new SyntaxPattern("\f\u0018\f\u0007\b", Lit74, 1, "std_syntax.scm:257");
        Lit50 = Symbol.valueOf("lazy");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject12 = new Object[9];
        arrobject12[0] = Lit86;
        arrobject12[1] = Symbol.valueOf("%do%loop");
        arrobject12[2] = Lit44;
        arrobject12[3] = Lit89;
        arrobject12[4] = Symbol.valueOf("not");
        arrobject12[5] = Lit75;
        Lit40 = Symbol.valueOf("%do-step");
        arrobject12[6] = Lit40;
        arrobject12[7] = Values.empty;
        Lit42 = Symbol.valueOf("%do-init");
        arrobject12[8] = Lit42;
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\u001c\f\u000f\u0013\r\u001f\u0018\b\b", Lit74, 4, "std_syntax.scm:237"), "\u0003\u0001\u0000\u0003", "\u0011\u0018\u0004\u0189\b\u0011\u0018\f\b\u0011\u0018\u0014\u0019\b\u0005\u0003\t\u0010\b\u0011\u0018\u001c)\u0011\u0018$\b\u000b\u0081\u0011\u0018,\u0011\u001d\u001b\b\u0011\u0018\f\b\u0005\u0011\u00184\u0003\b\u0011\u0018,\u0011\u0018<\u0012\b\u0011\u0018\f\b\u0005\u0011\u0018D\b\u0003", arrobject12, 1);
        Lit48 = Symbol.valueOf("do");
        Lit49 = new SyntaxRules(Lit78, arrsyntaxRule, 4, Lit48);
        Lit47 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\f\u0017\f\u001f\b", Lit74, 4, "std_syntax.scm:230"), "\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\n\u0019\t\u0003\u0013\b\u001b", Lit82, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\f\u000f\b", Lit74, 2, "std_syntax.scm:232"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", Lit77, 0)}, 4, Lit46);
        Lit45 = new SyntaxRules(Lit78, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018l\\\f\u0007\f\u0002\f\u000f\f\u0017\f\u001f\b#\f/\f7\b", Lit78, 7, "std_syntax.scm:216"), "\u0001\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\"I9\t\u0003\u0011\u0018\f\b\u000b+\b3", Lit80, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\L\f\u0007\f\u0002\f\u000f\f\u0017\b\u001b\f'\f/\b", Lit78, 6, "std_syntax.scm:218"), "\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u001aI9\t\u0003\u0011\u0018\f\b\u000b#\b+", Lit80, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L<\f\u0007\f\u000f\f\u0017\b\u001b\f'\f/\b", Lit74, 6, "std_syntax.scm:220"), "\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u001a\u0019\t\u0003#\b+", Lit81, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<,\f\u0007\f\u000f\b\u0013\f\u001f\f'\b", Lit74, 5, "std_syntax.scm:222"), "\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u0012\u0019\t\u0003\u001b\b#", Lit81, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\f\u000f\b", Lit74, 2, "std_syntax.scm:224"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u0010\b\u000b", Lit82, 0)}, 7, Lit44);
        Lit43 = new SyntaxRules(Lit78, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0007\f\u0002\f\u000f\f\u0017\f\u001f\b\b", Lit78, 4, "std_syntax.scm:198"), "\u0001\u0001\u0001\u0001", "\u0013", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u0002\f\u000f\f\u0017\b\b", Lit78, 3, "std_syntax.scm:200"), "\u0001\u0001\u0001", "\u0013", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u000f\f\u0017\b\b", Lit74, 3, "std_syntax.scm:202"), "\u0001\u0001\u0001", "\u000b", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018,\f\u0007\f\u000f\b\b", Lit74, 2, "std_syntax.scm:204"), "\u0001\u0001", "\u000b", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u000f\f\u0017\b\b", Lit74, 3, "std_syntax.scm:206"), "\u0001\u0001\u0001", "\u0013", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\b", Lit74, 1, "std_syntax.scm:208"), "\u0001", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("do binding with no value", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 856082))}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\f\u0017\f\u001f\b\b", Lit74, 4, "std_syntax.scm:210"), "\u0001\u0001\u0001\u0001", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("do binding must have syntax: (var [:: type] init [step])", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 868357))}, 0)}, 4, Lit42);
        Lit41 = new SyntaxRules(Lit78, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\f\u001f\b", Lit78, 4, "std_syntax.scm:191"), "\u0001\u0001\u0001\u0001", "\u001b", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", Lit78, 3, "std_syntax.scm:192"), "\u0001\u0001\u0001", "\u0003", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit74, 3, "std_syntax.scm:193"), "\u0001\u0001\u0001", "\u0013", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit74, 2, "std_syntax.scm:194"), "\u0001\u0001", "\u0003", Lit74, 0)}, 4, Lit40);
        SyntaxRule[] arrsyntaxRule2 = new SyntaxRule[5];
        arrsyntaxRule2[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\u0003", Lit74, 1, "std_syntax.scm:173"), "\u0000", "\u0011\u0018\u0004\t\u0010\u0002", Lit84, 0);
        arrsyntaxRule2[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\u000b", Lit74, 2, "std_syntax.scm:174"), "\u0001\u0000", "\u0011\u0018\u0004\u0011\b\u0003\n", Lit84, 0);
        Object[] arrobject13 = new Object[2];
        arrobject13[0] = Lit85;
        Lit38 = Symbol.valueOf("let*");
        arrobject13[1] = Lit38;
        arrsyntaxRule2[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", Lit74, 3, "std_syntax.scm:176"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\u0011\b\u0003\b\u0011\u0018\f\t\n\u0012", arrobject13, 0);
        arrsyntaxRule2[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u000b", Lit74, 2, "std_syntax.scm:179"), "\u0001\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("invalid bindings list in let*", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 741383))}, 0);
        arrsyntaxRule2[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit74, 1, "std_syntax.scm:182"), "\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("missing bindings list in let*", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 753671))}, 0);
        Lit39 = new SyntaxRules(Lit74, arrsyntaxRule2, 3, Lit38);
        SyntaxRule[] arrsyntaxRule3 = new SyntaxRule[2];
        arrsyntaxRule3[0] = new SyntaxRule(new SyntaxPattern("\f\u0018,\r\u0007\u0000\b\b\u000b", Lit74, 2, "std_syntax.scm:157"), "\u0003\u0000", "\u0011\u0018\u0004\u0019\b\u0005\u0003\n", Lit84, 1);
        Object[] arrobject14 = new Object[3];
        arrobject14[0] = Lit86;
        arrobject14[1] = Lit30;
        Lit34 = Symbol.valueOf("%let-init");
        arrobject14[2] = Lit34;
        arrsyntaxRule3[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007,\r\u000f\b\b\b\u0013", Lit74, 3, "std_syntax.scm:164"), "\u0001\u0003\u0000", "\u00a9\u0011\u0018\u0004y\b\t\u0003\b\u0011\u0018\f\u0019\b\r\u000b\t\u0010\b\u0012\b\u0003\b\r\u0011\u0018\u0014\b\u000b", arrobject14, 1);
        Lit36 = Symbol.valueOf("let");
        Lit37 = new SyntaxRules(Lit74, arrsyntaxRule3, 3, Lit36);
        Lit35 = new SyntaxRules(Lit78, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018,\f\u0007\f\u000f\b\b", Lit74, 2, "std_syntax.scm:143"), "\u0001\u0001", "\u000b", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u0002\f\u000f\f\u0017\b\b", Lit78, 3, "std_syntax.scm:145"), "\u0001\u0001\u0001", "\u0013", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u000f\f\u0017\b\b", Lit74, 3, "std_syntax.scm:147"), "\u0001\u0001\u0001", "\u0013", Lit74, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\b", Lit74, 1, "std_syntax.scm:149"), "\u0001", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("let binding with no value", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 614418))}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\f\u0017\f\u001f\b\b", Lit74, 4, "std_syntax.scm:151"), "\u0001\u0001\u0001\u0001", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("let binding must have syntax: (var [type] init)", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 626693))}, 0)}, 4, Lit34);
        Lit33 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\f\u0017\f\u001f\b", Lit74, 4, "std_syntax.scm:136"), "\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\n\u0019\t\u0003\u0013\b\u001b", Lit88, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\f\u000f\b", Lit74, 2, "std_syntax.scm:138"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u000b", Lit77, 0)}, 4, Lit32);
        Lit31 = new SyntaxRules(Lit78, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018L<\f\u0007\f\u000f\f\u0017\b\u001b\f'\f/\b", Lit74, 6, "std_syntax.scm:124"), "\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u001aI9\t\u0003\u0011\u0018\f\b\u000b#\b+", Lit87, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\L\f\u0007\f\u0002\f\u000f\f\u0017\b\u001b\f'\f/\b", Lit78, 6, "std_syntax.scm:126"), "\u0001\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u001aI9\t\u0003\u0011\u0018\f\b\u000b#\b+", Lit87, 0), new SyntaxRule(new SyntaxPattern("\f\u0018<,\f\u0007\f\u000f\b\u0013\f\u001f\f'\b", Lit74, 5, "std_syntax.scm:128"), "\u0001\u0001\u0000\u0001\u0001", "\u0011\u0018\u0004\t\u0012\u0019\t\u0003\u001b\b#", new Object[]{Lit30}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\b\f\u0007\f\u000f\b", Lit74, 2, "std_syntax.scm:130"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u0010\b\u000b", Lit88, 0)}, 6, Lit30);
        Object[] arrobject15 = new Object[4];
        arrobject15[0] = Lit85;
        arrobject15[1] = Symbol.valueOf("x");
        arrobject15[2] = Lit89;
        Lit24 = Symbol.valueOf("or");
        arrobject15[3] = Lit24;
        Lit29 = new SyntaxTemplate("\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f\u0011\u0018\f\b\u0011\u0018\u001c\b\r\u000b", arrobject15, 1);
        Lit28 = new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit74, 2, "std_syntax.scm:116");
        Lit27 = new SyntaxTemplate("\u0001", "\u0003", Lit74, 0);
        Lit26 = new SyntaxPattern("\f\u0018\f\u0007\b", Lit74, 1, "std_syntax.scm:115");
        Lit25 = new SyntaxPattern("\f\u0018\b", Lit74, 0, "std_syntax.scm:114");
        Object[] arrobject16 = new Object[3];
        arrobject16[0] = Lit89;
        Lit18 = Symbol.valueOf("and");
        arrobject16[1] = Lit18;
        arrobject16[2] = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 446499);
        Lit23 = new SyntaxTemplate("\u0001\u0000", "\u0011\u0018\u0004\t\u0003!\u0011\u0018\f\n\u0018\u0014", arrobject16, 0);
        Lit22 = new SyntaxPattern("\f\u0018\f\u0007\u000b", Lit74, 2, "std_syntax.scm:108");
        Lit21 = new SyntaxTemplate("\u0001", "\u0003", Lit74, 0);
        Lit20 = new SyntaxPattern("\f\u0018\f\u0007\b", Lit74, 1, "std_syntax.scm:107");
        Lit19 = new SyntaxPattern("\f\u0018\b", Lit74, 0, "std_syntax.scm:106");
        SyntaxRule[] arrsyntaxRule4 = new SyntaxRule[8];
        arrsyntaxRule4[0] = new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0002\f\u0007\r\u000f\b\b\b\b", Lit91, 2, "std_syntax.scm:64"), "\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\r\u000b", Lit90, 1);
        arrsyntaxRule4[1] = new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0002\f\u0007\r\u000f\b\b\b\r\u0017\u0010\b\b", Lit91, 3, "std_syntax.scm:67"), "\u0001\u0003\u0003", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("else clause must be last clause of cond", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 278546))}, 0);
        arrsyntaxRule4[2] = new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u0002\f\u000f\b\b", Lit93, 2, "std_syntax.scm:70"), "\u0001\u0001", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f\b\t\u000b\u0018\u001c", new Object[]{Lit85, Lit92, Lit89, Lit94}, 0);
        Object[] arrobject17 = new Object[5];
        arrobject17[0] = Lit85;
        arrobject17[1] = Lit92;
        arrobject17[2] = Lit89;
        arrobject17[3] = Lit94;
        Lit16 = Symbol.valueOf("cond");
        arrobject17[4] = Lit16;
        arrsyntaxRule4[3] = new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\f\u0002\f\u000f\b\f\u0017\r\u001f\u0018\b\b", Lit93, 4, "std_syntax.scm:74"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\u0011\u0018\f!\t\u000b\u0018\u001c\b\u0011\u0018$\t\u0013\b\u001d\u001b", arrobject17, 1);
        arrsyntaxRule4[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\b", Lit74, 1, "std_syntax.scm:80"), "\u0001", "\u0003", Lit74, 0);
        arrsyntaxRule4[5] = new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\b\f\u000f\r\u0017\u0010\b\b", Lit74, 3, "std_syntax.scm:83"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\u000b\b\u0015\u0013", new Object[]{Lit24, Lit16}, 1);
        arrsyntaxRule4[6] = new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\r\u0017\u0010\b\b\b", Lit74, 3, "std_syntax.scm:86"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\u000b\b\u0015\u0013", new Object[]{Lit89, Lit75}, 1);
        arrsyntaxRule4[7] = new SyntaxRule(new SyntaxPattern("\f\u0018L\f\u0007\f\u000f\r\u0017\u0010\b\b\f\u001f\r' \b\b", Lit74, 5, "std_syntax.scm:89"), "\u0001\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\t\u0003A\u0011\u0018\f\t\u000b\b\u0015\u0013\b\u0011\u0018\u0014\t\u001b\b%#", new Object[]{Lit89, Lit75, Lit16}, 1);
        Lit17 = new SyntaxRules(new Object[]{Lit10, Lit4}, arrsyntaxRule4, 5, Lit16);
        Lit14 = Symbol.valueOf("unquote-splicing");
        Lit15 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit74, 1, "std_syntax.scm:56"), "\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("invalid use of 'unquote-splicing", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 233492))}, 0)}, 1, Lit14);
        Lit12 = Symbol.valueOf("unquote");
        Lit13 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit74, 1, "std_syntax.scm:51"), "\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("invalid use of 'unquote", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 213012))}, 0)}, 1, Lit12);
        Lit11 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit74, 1, "std_syntax.scm:46"), "\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("invalid use of 'else", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 192532))}, 0)}, 1, Lit10);
        Lit8 = Symbol.valueOf("_");
        Lit9 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit74, 1, "std_syntax.scm:41"), "\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("invalid use of '_", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 172052))}, 0)}, 1, Lit8);
        Lit6 = Symbol.valueOf("...");
        Lit7 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit74, 1, "std_syntax.scm:36"), "\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("invalid use of '...", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 151572))}, 0)}, 1, Lit6);
        Lit5 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit74, 1, "std_syntax.scm:31"), "\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("invalid use of '=>", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 131092))}, 0)}, 1, Lit4);
        Lit2 = Symbol.valueOf("?");
        Lit3 = new SyntaxRules(Lit74, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit74, 3, "std_syntax.scm:24"), "\u0001\u0001\u0001", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("missing init expression for '?'", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 102420))}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u0003", Lit74, 1, "std_syntax.scm:26"), "\u0000", "\u0018\u0004", new Object[]{Pair.make(Lit83, PairWithPosition.make("'?' is only allowed in a conditional e.g. 'if' or 'and'", LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/std_syntax.scm", 110612))}, 0)}, 3, Lit2);
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(0);
        $instance = new std_syntax();
        $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
        $Prvt$letrec = StaticFieldLocation.make("kawa.lib.prim_syntax", "letrec");
        $Prvt$syntax$Mncase = StaticFieldLocation.make("kawa.standard.syntax_case", "syntax_case");
        $Prvt$$Pclet = StaticFieldLocation.make("kawa.standard.let", "let");
        $Prvt$$Pcdefine = StaticFieldLocation.make("kawa.standard.define", "defineRaw");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        $Prvt$not = StaticFieldLocation.make("kawa.standard.Scheme", "not");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$syntax$Mnerror = StaticFieldLocation.make("kawa.standard.syntax_error", "syntax_error");
        $Qu = Macro.make(Lit2, Lit3, "kawa.lib.std_syntax");
        $Eq$Gr = Macro.make(Lit4, Lit5, "kawa.lib.std_syntax");
        $Dt$Dt$Dt = Macro.make(Lit6, Lit7, "kawa.lib.std_syntax");
        _ = Macro.make(Lit8, Lit9, "kawa.lib.std_syntax");
        else = Macro.make(Lit10, Lit11, "kawa.lib.std_syntax");
        unquote = Macro.make(Lit12, Lit13, "kawa.lib.std_syntax");
        unquote$Mnsplicing = Macro.make(Lit14, Lit15, "kawa.lib.std_syntax");
        cond = Macro.make(Lit16, Lit17, "kawa.lib.std_syntax");
        std_syntax std_syntax2 = $instance;
        and = Macro.make(Lit18, new ModuleMethod(std_syntax2, 1, null, 4097), "kawa.lib.std_syntax");
        std_syntax std_syntax3 = $instance;
        or = Macro.make(Lit24, new ModuleMethod(std_syntax3, 2, null, 4097), "kawa.lib.std_syntax");
        $Prvt$$Pclet$Mnlambda1 = Macro.make(Lit30, Lit31, "kawa.lib.std_syntax");
        $Prvt$$Pclet$Mnlambda2 = Macro.make(Lit32, Lit33, "kawa.lib.std_syntax");
        $Prvt$$Pclet$Mninit = Macro.make(Lit34, Lit35, "kawa.lib.std_syntax");
        let = Macro.make(Lit36, Lit37, "kawa.lib.std_syntax");
        let$St = Macro.make(Lit38, Lit39, "kawa.lib.std_syntax");
        $Prvt$$Pcdo$Mnstep = Macro.make(Lit40, Lit41, "kawa.lib.std_syntax");
        $Prvt$$Pcdo$Mninit = Macro.make(Lit42, Lit43, "kawa.lib.std_syntax");
        $Prvt$$Pcdo$Mnlambda1 = Macro.make(Lit44, Lit45, "kawa.lib.std_syntax");
        $Prvt$$Pcdo$Mnlambda2 = Macro.make(Lit46, Lit47, "kawa.lib.std_syntax");
        do = Macro.make(Lit48, Lit49, "kawa.lib.std_syntax");
        std_syntax std_syntax4 = $instance;
        lazy = Macro.make(Lit50, new ModuleMethod(std_syntax4, 3, null, 4097), "kawa.lib.std_syntax");
        std_syntax std_syntax5 = $instance;
        delay$Mnforce = Macro.make(Lit53, new ModuleMethod(std_syntax5, 4, null, 4097), "kawa.lib.std_syntax");
        std_syntax std_syntax6 = $instance;
        delay = Macro.make(Lit56, new ModuleMethod(std_syntax6, 5, null, 4097), "kawa.lib.std_syntax");
        define$Mnprocedure = Macro.make(Lit59, Lit60, "kawa.lib.std_syntax");
        std_syntax std_syntax7 = $instance;
        syntax$Mn$Grdatum = new ModuleMethod(std_syntax7, 6, Lit61, 4097);
        syntax$Mnobject$Mn$Grdatum = new ModuleMethod(std_syntax7, 7, Lit62, 4097);
        datum$Mn$Grsyntax = new ModuleMethod(std_syntax7, 8, Lit63, 12290);
        datum$Mn$Grsyntax$Mnobject = new ModuleMethod(std_syntax7, 10, Lit64, 8194);
        generate$Mntemporaries = new ModuleMethod(std_syntax7, 11, Lit65, 4097);
        identifier$Qu = new ModuleMethod(std_syntax7, 12, Lit66, 4097);
        free$Mnidentifier$Eq$Qu = new ModuleMethod(std_syntax7, 13, Lit67, 8194);
        bound$Mnidentifier$Eq$Qu = new ModuleMethod(std_syntax7, 14, Lit68, 8194);
        syntax$Mnsource = new ModuleMethod(std_syntax7, 15, Lit69, 4097);
        syntax$Mnline = new ModuleMethod(std_syntax7, 16, Lit70, 4097);
        syntax$Mncolumn = new ModuleMethod(std_syntax7, 17, Lit71, 4097);
        with$Mnsyntax = Macro.make(Lit72, Lit73, "kawa.lib.std_syntax");
        std_syntax.$runBody$();
    }

    public std_syntax() {
        ModuleInfo.register(this);
    }

    static Object lambda1(Object f) {
        Object object2;
        Object object3 = f;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit19).match(f, arrobject, 0)) {
            object2 = new QuoteExp(Language.getDefaultLanguage().booleanObject(true));
        } else if (((Pattern)Lit20).match(f, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit21.execute(arrobject, templateScope);
        } else if (((Pattern)Lit22).match(f, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit23.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", f);
        }
        return object2;
    }

    static Object lambda2(Object f) {
        Object object2;
        Object object3 = f;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit25).match(f, arrobject, 0)) {
            object2 = new QuoteExp(Language.getDefaultLanguage().booleanObject(false));
        } else if (((Pattern)Lit26).match(f, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit27.execute(arrobject, templateScope);
        } else if (((Pattern)Lit28).match(f, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit29.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", f);
        }
        return object2;
    }

    static Object lambda3(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(1, null);
        if (((Pattern)Lit51).match(form, arrobject, 0)) {
            Expression[] arrexpression;
            object2 = new ApplyExp(MakePromise.makeLazy, arrexpression);
            arrexpression = new Expression[1];
            TemplateScope templateScope = TemplateScope.make();
            arrexpression[0] = SyntaxForms.rewrite(Lit52.execute(arrobject, templateScope));
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    static Object lambda4(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(1, null);
        if (((Pattern)Lit54).match(form, arrobject, 0)) {
            Expression[] arrexpression;
            object2 = new ApplyExp(MakePromise.makeLazy, arrexpression);
            arrexpression = new Expression[1];
            TemplateScope templateScope = TemplateScope.make();
            arrexpression[0] = SyntaxForms.rewrite(Lit55.execute(arrobject, templateScope));
        } else {
            object2 = syntax_case.error("syntax-case", form);
        }
        return object2;
    }

    static Object lambda5(Object form) {
        Object object2;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit57).match(form, arrobject, 0)) {
            Expression[] arrexpression;
            object2 = new ApplyExp(MakePromise.makeDelay, arrexpression);
            arrexpression = new Expression[1];
            TemplateScope templateScope = TemplateScope.make();
            arrexpression[0] = SyntaxForms.rewrite(Lit58.execute(arrobject, templateScope));
        } else {
            object2 = syntax_case.error("syntax-case", form);
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
            case 17: {
                callContext.value1 = object2;
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
            case 15: {
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
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 14: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 13: {
                callContext.value1 = object2;
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
            case 8: {
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
        if (moduleMethod.selector == 8) {
            callContext.value1 = object2;
            callContext.value2 = object3;
            callContext.value3 = object4;
            callContext.proc = moduleMethod;
            callContext.pc = 3;
            return 0;
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 6: {
                return std_syntax.syntax$To$Datum(object2);
            }
            case 7: {
                return std_syntax.syntaxObject$To$Datum(object2);
            }
            case 11: {
                return std_syntax.generateTemporaries(object2);
            }
            case 12: {
                return std_syntax.isIdentifier(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 15: {
                return std_syntax.syntaxSource(object2);
            }
            case 16: {
                return std_syntax.syntaxLine(object2);
            }
            case 17: {
                return std_syntax.syntaxColumn(object2);
            }
            case 1: {
                return std_syntax.lambda1(object2);
            }
            case 2: {
                return std_syntax.lambda2(object2);
            }
            case 3: {
                return std_syntax.lambda3(object2);
            }
            case 4: {
                return std_syntax.lambda4(object2);
            }
            case 5: {
                return std_syntax.lambda5(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 8: {
                return std_syntax.datum$To$Syntax(object2, object3);
            }
            case 10: {
                return std_syntax.datum$To$SyntaxObject(object2, object3);
            }
            case 13: {
                return std_syntax.isFreeIdentifier$Eq(object2, object3) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 14: {
                return std_syntax.isBoundIdentifier$Eq(object2, object3) ? Boolean.TRUE : Boolean.FALSE;
            }
        }
        return super.apply2(moduleMethod, object2, object3);
    }

    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        if (moduleMethod.selector == 8) {
            return std_syntax.datum$To$Syntax(object2, object3, object4);
        }
        return super.apply3(moduleMethod, object2, object3, object4);
    }
}

