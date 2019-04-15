/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.BeginExp;
import gnu.expr.BlockExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.reflect.TypeSwitch;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
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
import kawa.standard.syntax_case;
import kawa.standard.syntax_error;
import kawa.standard.try_catch;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class prim_syntax
extends ModuleBody {
    public static final Macro define$Mnsyntax;
    public static final Macro define;
    public static final Macro define$Mnprivate;
    public static final Macro define$Mnconstant;
    public static final Macro define$Mnearly$Mnconstant;
    public static final Macro define$Mnvariable;
    public static final ModuleMethod report$Mnsyntax$Mnerror;
    public static final Macro syntax$Mn$Grexpression;
    public static final Macro syntax$Mnbody$Mn$Grexpression;
    public static final Macro if;
    public static final Macro try$Mncatch;
    public static final Macro letrec;
    public static final StaticFieldLocation $Prvt$$Pcdefine;
    public static final StaticFieldLocation $Prvt$$Pcdefine$Mnsyntax;
    public static final StaticFieldLocation $Prvt$$Pclet;
    public static final StaticFieldLocation $Prvt$set$Ex;
    public static final StaticFieldLocation $Prvt$lambda;
    public static final StaticFieldLocation $Prvt$mlambda;
    public static final Macro $Prvt$$Pcif$Mnand$Mnx;
    public static prim_syntax $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
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
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final SimpleSymbol Lit15;
    static final SyntaxRules Lit16;
    static final SimpleSymbol Lit17;
    static final SyntaxPattern Lit18;
    static final SyntaxTemplate Lit19;
    static final SyntaxTemplate Lit20;
    static final SyntaxPattern Lit21;
    static final SyntaxTemplate Lit22;
    static final SimpleSymbol Lit23;
    static final SyntaxPattern Lit24;
    static final SyntaxTemplate Lit25;
    static final SyntaxTemplate Lit26;
    static final SyntaxTemplate Lit27;
    static final SyntaxPattern Lit28;
    static final SyntaxTemplate Lit29;
    static final SyntaxPattern Lit30;
    static final SyntaxTemplate Lit31;
    static final SyntaxPattern Lit32;
    static final SyntaxTemplate Lit33;
    static final SyntaxPattern Lit34;
    static final SyntaxTemplate Lit35;
    static final SyntaxPattern Lit36;
    static final SyntaxTemplate Lit37;
    static final SyntaxTemplate Lit38;
    static final SyntaxPattern Lit39;
    static final SyntaxTemplate Lit40;
    static final SyntaxTemplate Lit41;
    static final SyntaxTemplate Lit42;
    static final SyntaxPattern Lit43;
    static final SyntaxTemplate Lit44;
    static final SyntaxPattern Lit45;
    static final SyntaxTemplate Lit46;
    static final SimpleSymbol Lit47;
    static final SyntaxPattern Lit48;
    static final SyntaxTemplate Lit49;
    static final SyntaxTemplate Lit50;
    static final SimpleSymbol Lit51;
    static final SyntaxPattern Lit52;
    static final SyntaxTemplate Lit53;
    static final SyntaxPattern Lit54;
    static final SyntaxPattern Lit55;
    static final SyntaxTemplate Lit56;
    static final SyntaxTemplate Lit57;
    static final SyntaxTemplate Lit58;
    static final SyntaxPattern Lit59;
    static final SyntaxTemplate Lit60;
    static final SyntaxTemplate Lit61;
    static final SyntaxTemplate Lit62;
    static final SyntaxPattern Lit63;
    static final SyntaxPattern Lit64;
    static final SyntaxTemplate Lit65;
    static final SyntaxTemplate Lit66;
    static final Object[] Lit67;
    static final Object[] Lit68;
    static final Object[] Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final PairWithPosition Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final PairWithPosition Lit76;
    static final Object[] Lit77;
    static final Object[] Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final Object[] Lit82;
    static final PairWithPosition Lit83;
    static final SimpleSymbol Lit84;
    static final IntNum Lit85;
    static final IntNum Lit86;
    static final Object[] Lit87;
    static final Object[] Lit88;
    static final Object[] Lit89;
    static final IntNum Lit90;
    static final IntNum Lit91;
    static final IntNum Lit92;
    static final IntNum Lit93;
    static final IntNum Lit94;
    static final IntNum Lit95;
    static final IntNum Lit96;
    static final IntNum Lit97;
    static final SimpleSymbol Lit98;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static /* varargs */ Expression reportSyntaxError(Object id, Object ... msg) {
        return syntax_error.error(id, msg);
    }

    public static {
        Lit98 = Symbol.valueOf("%define-syntax");
        Lit97 = IntNum.valueOf(0);
        Lit96 = IntNum.valueOf(1);
        Lit95 = IntNum.valueOf(4);
        Lit94 = IntNum.valueOf(5);
        Lit93 = IntNum.valueOf(8);
        Lit92 = IntNum.valueOf(9);
        Lit91 = IntNum.valueOf(24);
        Lit90 = IntNum.valueOf(25);
        Object[] arrobject = new Object[1];
        Lit89 = arrobject;
        Lit79 = Symbol.valueOf("$lookup$");
        arrobject[0] = Lit79;
        Object[] arrobject2 = new Object[2];
        Lit88 = arrobject2;
        arrobject2[0] = Lit79;
        Lit71 = Symbol.valueOf("::");
        arrobject2[1] = Lit71;
        Object[] arrobject3 = new Object[2];
        Lit87 = arrobject3;
        arrobject3[0] = Lit71;
        arrobject3[1] = Lit79;
        Lit86 = IntNum.valueOf(32);
        Lit85 = IntNum.valueOf(33);
        Lit84 = Symbol.valueOf("%define");
        Lit83 = PairWithPosition.make(Special.undefined, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 753726);
        Object[] arrobject4 = new Object[1];
        Lit82 = arrobject4;
        arrobject4[0] = Lit71;
        Lit81 = Symbol.valueOf("quasiquote");
        Lit80 = Symbol.valueOf("kawa.lang.SyntaxForms");
        Object[] arrobject5 = new Object[1];
        Lit78 = arrobject5;
        Lit75 = Symbol.valueOf("and");
        arrobject5[0] = Lit75;
        Object[] arrobject6 = new Object[1];
        Lit77 = arrobject6;
        Lit74 = Symbol.valueOf("?");
        arrobject6[0] = Lit74;
        Lit76 = PairWithPosition.make(Values.empty, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 520224);
        Lit73 = PairWithPosition.make(Symbol.valueOf("unused"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 561171);
        Lit72 = Symbol.valueOf("lambda");
        Lit70 = Symbol.valueOf("mlambda");
        Object[] arrobject7 = new Object[1];
        Lit69 = arrobject7;
        arrobject7[0] = Lit83;
        Object[] arrobject8 = new Object[1];
        Lit68 = arrobject8;
        arrobject8[0] = Symbol.valueOf("set!");
        Lit67 = new Object[0];
        Lit66 = new SyntaxTemplate("\u0001\u0000", "\n", Lit67, 0);
        Lit65 = new SyntaxTemplate("\u0001\u0000", "\u0018\u0004", new Object[]{Pair.make(Symbol.valueOf("%let"), LList.Empty)}, 0);
        Lit64 = new SyntaxPattern("\u0013", Lit67, 3, "prim_syntax.scm:189");
        Lit63 = new SyntaxPattern("\u001c\f\u0017\b\u001b", Lit67, 4, "prim_syntax.scm:187");
        Lit62 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0001\u0001\u0000", "2", Lit67, 0);
        Lit61 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0013\b+", Lit68, 0);
        Lit60 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0001\u0001\u0000", "\t\u0013\t\u001b\t#\u0018\u0004", Lit69, 0);
        Lit59 = new SyntaxPattern("L\f\u0017\f\u001f\f'\f/\b3", Lit67, 7, "prim_syntax.scm:182");
        Lit58 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0000", "\"", Lit67, 0);
        Lit57 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0013\b\u001b", Lit68, 0);
        Lit56 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0000", "\t\u0013\u0018\u0004", Lit69, 0);
        Lit55 = new SyntaxPattern(",\f\u0017\f\u001f\b#", Lit67, 5, "prim_syntax.scm:176");
        Lit54 = new SyntaxPattern("\b", Lit67, 2, "prim_syntax.scm:175");
        Lit53 = new SyntaxTemplate("\u0001\u0000", "\u0003", Lit67, 0);
        Lit52 = new SyntaxPattern("\f\u0018\f\u0007\u000b", Lit67, 2, "prim_syntax.scm:168");
        Lit51 = Symbol.valueOf("letrec");
        Lit50 = new SyntaxTemplate("\u0001\u0003\u0003\u0002", "(\b\rA\b\t\u000b\u0011\u0018\u0004\b\u0013\u001a", Lit82, 1);
        Lit49 = new SyntaxTemplate("\u0001\u0003\u0003\u0002", "\u0003", Lit67, 0);
        Lit48 = new SyntaxPattern("\f\u0018\f\u0007-\f\u000f\f\u0017\u001b\b\u0018\b", Lit67, 4, "prim_syntax.scm:158");
        Lit47 = Symbol.valueOf("try-catch");
        Lit46 = new SyntaxTemplate("\u0000", "\u0002", Lit67, 0);
        Lit45 = new SyntaxPattern("\f\u0018\u0003", Lit67, 1, "prim_syntax.scm:151");
        Lit44 = new SyntaxTemplate("\u0001\u0001\u0001\u0000", "\u001a", Lit67, 0);
        Lit43 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\u001b", Lit67, 4, "prim_syntax.scm:148");
        Lit42 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0013", Lit67, 0);
        Lit41 = new SyntaxTemplate("\u0001\u0001\u0001", "\u000b", Lit67, 0);
        Lit40 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0003", Lit67, 0);
        Lit39 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit67, 3, "prim_syntax.scm:143");
        Lit38 = new SyntaxTemplate("\u0001\u0001", "\u000b", Lit67, 0);
        Lit37 = new SyntaxTemplate("\u0001\u0001", "\u0003", Lit67, 0);
        Lit36 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit67, 2, "prim_syntax.scm:138");
        Lit35 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\t\u000bA\u0011\u0018\u0004\u0011\b\u0003\b\u0013\b\u0011\u0018\f\u0011\u0018\u0014\b\u001b", new Object[]{Lit70, Lit72, Lit73}, 0);
        Lit34 = new SyntaxPattern("\f\u0018<\f\u0002\f\u0007\f\u000f\b\f\u0017\f\u001f\b", Lit77, 4, "prim_syntax.scm:133");
        Lit33 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001", "\t\u0013i\u0011\u0018\u00049\t\u0003\u0011\u0018\f\b\u000b\b\u001b\b\u0011\u0018\u0014\u0011\u0018\u001c\b#", new Object[]{Lit70, Lit71, Lit72, Lit73}, 0);
        Lit32 = new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007\f\n\f\u000f\f\u0017\b\f\u001f\f'\b", new Object[]{Lit74, Lit71}, 5, "prim_syntax.scm:128");
        Object[] arrobject9 = new Object[3];
        Lit23 = Symbol.valueOf("if");
        arrobject9[0] = Lit23;
        arrobject9[1] = Lit75;
        arrobject9[2] = Lit76;
        Lit31 = new SyntaxTemplate("\u0000\u0001", "\u0011\u0018\u0004!\u0011\u0018\f\u0002\t\u000b\u0018\u0014", arrobject9, 0);
        Lit30 = new SyntaxPattern("\f\u0018\u001c\f\u0002\u0003\f\u000f\b", Lit78, 2, "prim_syntax.scm:126");
        Lit29 = new SyntaxTemplate("\u0000\u0001", "\u0011\u0018\u0004!\u0011\u0018\f\u0002\t\u000b\u0018\u0014", new Object[]{Lit23, Lit74, Lit76}, 0);
        Lit28 = new SyntaxPattern("\f\u0018\u001c\f\u0002\u0003\f\u000f\b", Lit77, 2, "prim_syntax.scm:124");
        Lit27 = new SyntaxTemplate("\u0000\u0001\u0001", "\u0013", Lit67, 0);
        Lit26 = new SyntaxTemplate("\u0000\u0001\u0001", "\t\u000b\u0002", Lit67, 0);
        Object[] arrobject10 = new Object[1];
        Lit17 = Symbol.valueOf("%if-and-x");
        arrobject10[0] = Pair.make(Lit17, LList.Empty);
        Lit25 = new SyntaxTemplate("\u0000\u0001\u0001", "\u0018\u0004", arrobject10, 0);
        Lit24 = new SyntaxPattern("\f\u0018\u001c\f\u0002\u0003\f\u000f\f\u0017\b", Lit78, 3, "prim_syntax.scm:116");
        Lit22 = new SyntaxTemplate("\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0013\b\u0011\u0018\f\t\u0003\t\u000b\u001a", new Object[]{Lit23, Lit17}, 0);
        Lit21 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\u001b", Lit67, 4, "prim_syntax.scm:109");
        Lit20 = new SyntaxTemplate("\u0001\u0001", "\u0003", Lit67, 0);
        Lit19 = new SyntaxTemplate("\u0001\u0001", "\u000b", Lit67, 0);
        Lit18 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit67, 2, "prim_syntax.scm:107");
        Lit15 = Symbol.valueOf("syntax-body->expression");
        Lit16 = new SyntaxRules(Lit67, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit67, 1, "prim_syntax.scm:101"), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[]{PairWithPosition.make(Lit79, Pair.make(Lit80, Pair.make(Pair.make(Lit81, Pair.make(Symbol.valueOf("rewriteBody"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 417799)}, 0)}, 1, Lit15);
        Lit13 = Symbol.valueOf("syntax->expression");
        Lit14 = new SyntaxRules(Lit67, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit67, 1, "prim_syntax.scm:96"), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[]{PairWithPosition.make(Lit79, Pair.make(Lit80, Pair.make(Pair.make(Lit81, Pair.make(Symbol.valueOf("rewrite"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 397319)}, 0)}, 1, Lit13);
        Lit12 = Symbol.valueOf("report-syntax-error");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[6];
        Object[] arrobject11 = new Object[3];
        Lit10 = Symbol.valueOf("define-variable");
        arrobject11[0] = Lit10;
        arrobject11[1] = Lit71;
        arrobject11[2] = Lit83;
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", Lit82, 2, "prim_syntax.scm:78"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\t\u000b\u0018\u0014", arrobject11, 0);
        arrsyntaxRule[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit67, 1, "prim_syntax.scm:80"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", new Object[]{Lit10, Lit83}, 0);
        arrsyntaxRule[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", Lit88, 5, "prim_syntax.scm:82"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[]{Lit84, Lit79, Lit85}, 0);
        Object[] arrobject12 = new Object[4];
        arrobject12[0] = Lit84;
        arrobject12[1] = Lit79;
        arrobject12[2] = Lit86;
        arrsyntaxRule[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", Lit89, 4, "prim_syntax.scm:84"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", arrobject12, 0);
        arrsyntaxRule[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", Lit82, 3, "prim_syntax.scm:86"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[]{Lit84, Lit85}, 0);
        Object[] arrobject13 = new Object[3];
        arrobject13[0] = Lit84;
        arrobject13[1] = Lit86;
        arrsyntaxRule[5] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit67, 2, "prim_syntax.scm:88"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", arrobject13, 0);
        Lit11 = new SyntaxRules(Lit87, arrsyntaxRule, 5, Lit10);
        SyntaxRule[] arrsyntaxRule2 = new SyntaxRule[4];
        arrsyntaxRule2[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", Lit88, 5, "prim_syntax.scm:67"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[]{Lit84, Lit79, Lit90}, 0);
        Object[] arrobject14 = new Object[4];
        arrobject14[0] = Lit84;
        arrobject14[1] = Lit79;
        arrobject14[2] = Lit91;
        arrsyntaxRule2[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", Lit89, 4, "prim_syntax.scm:69"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", arrobject14, 0);
        arrsyntaxRule2[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", Lit82, 3, "prim_syntax.scm:71"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[]{Lit84, Lit90}, 0);
        Object[] arrobject15 = new Object[3];
        arrobject15[0] = Lit84;
        arrobject15[1] = Lit91;
        arrsyntaxRule2[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit67, 2, "prim_syntax.scm:73"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", arrobject15, 0);
        Lit8 = Symbol.valueOf("define-early-constant");
        Lit9 = new SyntaxRules(Lit87, arrsyntaxRule2, 5, Lit8);
        SyntaxRule[] arrsyntaxRule3 = new SyntaxRule[4];
        arrsyntaxRule3[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", Lit88, 5, "prim_syntax.scm:56"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[]{Lit84, Lit79, Lit92}, 0);
        Object[] arrobject16 = new Object[4];
        arrobject16[0] = Lit84;
        arrobject16[1] = Lit79;
        arrobject16[2] = Lit93;
        arrsyntaxRule3[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", Lit89, 4, "prim_syntax.scm:58"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", arrobject16, 0);
        arrsyntaxRule3[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", Lit82, 3, "prim_syntax.scm:60"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[]{Lit84, Lit92}, 0);
        Object[] arrobject17 = new Object[3];
        arrobject17[0] = Lit84;
        arrobject17[1] = Lit93;
        arrsyntaxRule3[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit67, 2, "prim_syntax.scm:62"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", arrobject17, 0);
        Lit6 = Symbol.valueOf("define-constant");
        Lit7 = new SyntaxRules(Lit87, arrsyntaxRule3, 5, Lit6);
        SyntaxRule[] arrsyntaxRule4 = new SyntaxRule[5];
        arrsyntaxRule4[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", Lit88, 5, "prim_syntax.scm:43"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[]{Lit84, Lit79, Lit94}, 0);
        Object[] arrobject18 = new Object[4];
        arrobject18[0] = Lit84;
        arrobject18[1] = Lit79;
        arrobject18[2] = Lit95;
        arrsyntaxRule4[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", Lit89, 4, "prim_syntax.scm:45"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", arrobject18, 0);
        arrsyntaxRule4[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", Lit67, 3, "prim_syntax.scm:47"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\t\f\t\u0014\t\n\u0012", new Object[]{Lit84, IntNum.valueOf(6), Boolean.TRUE}, 0);
        arrsyntaxRule4[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", Lit82, 3, "prim_syntax.scm:49"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[]{Lit84, Lit94}, 0);
        Object[] arrobject19 = new Object[3];
        arrobject19[0] = Lit84;
        arrobject19[1] = Lit95;
        arrsyntaxRule4[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit67, 2, "prim_syntax.scm:51"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", arrobject19, 0);
        Lit4 = Symbol.valueOf("define-private");
        Lit5 = new SyntaxRules(Lit87, arrsyntaxRule4, 5, Lit4);
        SyntaxRule[] arrsyntaxRule5 = new SyntaxRule[5];
        arrsyntaxRule5[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", Lit88, 5, "prim_syntax.scm:30"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[]{Lit84, Lit79, Lit96}, 0);
        Object[] arrobject20 = new Object[4];
        arrobject20[0] = Lit84;
        arrobject20[1] = Lit79;
        arrobject20[2] = Lit97;
        arrsyntaxRule5[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", Lit89, 4, "prim_syntax.scm:32"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", arrobject20, 0);
        arrsyntaxRule5[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", Lit67, 3, "prim_syntax.scm:34"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\t\f\t\u0014\t\n\u0012", new Object[]{Lit84, IntNum.valueOf(2), Boolean.TRUE}, 0);
        arrsyntaxRule5[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", Lit82, 3, "prim_syntax.scm:36"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[]{Lit84, Lit96}, 0);
        Object[] arrobject21 = new Object[3];
        arrobject21[0] = Lit84;
        arrobject21[1] = Lit97;
        arrsyntaxRule5[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit67, 2, "prim_syntax.scm:38"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", arrobject21, 0);
        Lit2 = Symbol.valueOf("define");
        Lit3 = new SyntaxRules(Lit87, arrsyntaxRule5, 5, Lit2);
        Lit0 = Symbol.valueOf("define-syntax");
        Lit1 = new SyntaxRules(Lit89, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018l\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\u001b#", Lit89, 5, "prim_syntax.scm:17"), "\u0001\u0001\u0001\u0000\u0000", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\b\u0011\u0018\u0014\t\u001a\"", new Object[]{Lit98, Lit79, Lit72}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", Lit89, 4, "prim_syntax.scm:20"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\b\u001b", new Object[]{Lit98, Lit79}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", Lit67, 3, "prim_syntax.scm:22"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\n\u0012", new Object[]{Lit98, Lit72}, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit67, 2, "prim_syntax.scm:25"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[]{Lit98}, 0)}, 5, Lit0);
        $instance = new prim_syntax();
        $Prvt$$Pcdefine = StaticFieldLocation.make("kawa.standard.define", "defineRaw");
        $Prvt$$Pcdefine$Mnsyntax = StaticFieldLocation.make("kawa.standard.define_syntax", "define_syntax");
        $Prvt$$Pclet = StaticFieldLocation.make("kawa.standard.let", "let");
        $Prvt$set$Ex = StaticFieldLocation.make("kawa.standard.set_b", "set");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        $Prvt$mlambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "mlambda");
        define$Mnsyntax = Macro.make(Lit0, Lit1, "kawa.lib.prim_syntax");
        define = Macro.make(Lit2, Lit3, "kawa.lib.prim_syntax");
        define$Mnprivate = Macro.make(Lit4, Lit5, "kawa.lib.prim_syntax");
        define$Mnconstant = Macro.make(Lit6, Lit7, "kawa.lib.prim_syntax");
        define$Mnearly$Mnconstant = Macro.make(Lit8, Lit9, "kawa.lib.prim_syntax");
        define$Mnvariable = Macro.make(Lit10, Lit11, "kawa.lib.prim_syntax");
        prim_syntax prim_syntax2 = $instance;
        report$Mnsyntax$Mnerror = new ModuleMethod(prim_syntax2, 1, Lit12, -4095);
        syntax$Mn$Grexpression = Macro.make(Lit13, Lit14, "kawa.lib.prim_syntax");
        syntax$Mnbody$Mn$Grexpression = Macro.make(Lit15, Lit16, "kawa.lib.prim_syntax");
        prim_syntax prim_syntax3 = $instance;
        ModuleMethod moduleMethod = new ModuleMethod(prim_syntax3, 2, null, 4097);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:105");
        $Prvt$$Pcif$Mnand$Mnx = Macro.make(Lit17, moduleMethod, "kawa.lib.prim_syntax");
        prim_syntax prim_syntax4 = $instance;
        ModuleMethod moduleMethod2 = new ModuleMethod(prim_syntax4, 3, null, 4097);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:114");
        if = Macro.makeSkipScanForm(Lit23, moduleMethod2, "kawa.lib.prim_syntax");
        prim_syntax prim_syntax5 = $instance;
        ModuleMethod moduleMethod3 = new ModuleMethod(prim_syntax5, 4, null, 4097);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:156");
        try$Mncatch = Macro.makeSkipScanForm(Lit47, moduleMethod3, "kawa.lib.prim_syntax");
        prim_syntax prim_syntax6 = $instance;
        ModuleMethod moduleMethod4 = new ModuleMethod(prim_syntax6, 5, null, 4097);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:165");
        letrec = Macro.make(Lit51, moduleMethod4, "kawa.lib.prim_syntax");
        prim_syntax.$runBody$();
    }

    public prim_syntax() {
        ModuleInfo.register(this);
    }

    /*
     * Exception decompiling
     */
    static Object lambda1(Object x) {
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

    static Object lambda2(Object x) {
        Object object2;
        Object object3 = x;
        Object[] arrobject = SyntaxPattern.allocVars(5, null);
        if (((Pattern)Lit24).match(x, arrobject, 0)) {
            BlockExp bl = new BlockExp();
            bl.setRunFinallyBlocks(false);
            TemplateScope templateScope = TemplateScope.make();
            Object[] arrobject2 = new Object[]{Lit25.execute(arrobject, templateScope), Quote.consX$V(new Object[]{bl, Lit26.execute(arrobject, templateScope)})};
            templateScope = TemplateScope.make();
            bl.setBody(new BeginExp(SyntaxForms.rewrite(Quote.append$V(arrobject2)), SyntaxForms.rewrite(Lit27.execute(arrobject, templateScope))));
            object2 = bl;
        } else if (((Pattern)Lit28).match(x, arrobject, 0)) {
            TemplateScope bl = TemplateScope.make();
            object2 = Lit29.execute(arrobject, bl);
        } else if (((Pattern)Lit30).match(x, arrobject, 0)) {
            TemplateScope bl = TemplateScope.make();
            object2 = Lit31.execute(arrobject, bl);
        } else if (((Pattern)Lit32).match(x, arrobject, 0)) {
            TemplateScope bl = TemplateScope.make();
            object2 = Quote.consX$V(new Object[]{TypeSwitch.typeSwitch, Lit33.execute(arrobject, bl)});
        } else if (((Pattern)Lit34).match(x, arrobject, 0)) {
            TemplateScope bl = TemplateScope.make();
            object2 = Quote.consX$V(new Object[]{TypeSwitch.typeSwitch, Lit35.execute(arrobject, bl)});
        } else if (((Pattern)Lit36).match(x, arrobject, 0)) {
            IfExp ifExp;
            object2 = ifExp;
            TemplateScope bl = TemplateScope.make();
            Expression expression = SyntaxForms.rewrite(Lit37.execute(arrobject, bl));
            bl = TemplateScope.make();
            ifExp = new IfExp(expression, SyntaxForms.rewrite(Lit38.execute(arrobject, bl)), null);
        } else if (((Pattern)Lit39).match(x, arrobject, 0)) {
            IfExp ifExp;
            object2 = ifExp;
            TemplateScope bl = TemplateScope.make();
            Expression expression = SyntaxForms.rewrite(Lit40.execute(arrobject, bl));
            bl = TemplateScope.make();
            Expression expression2 = SyntaxForms.rewrite(Lit41.execute(arrobject, bl));
            bl = TemplateScope.make();
            ifExp = new IfExp(expression, expression2, SyntaxForms.rewrite(Lit42.execute(arrobject, bl)));
        } else if (((Pattern)Lit43).match(x, arrobject, 0)) {
            TemplateScope bl = TemplateScope.make();
            object2 = prim_syntax.reportSyntaxError(Lit44.execute(arrobject, bl), "too many expressions for 'if'");
        } else if (((Pattern)Lit45).match(x, arrobject, 0)) {
            TemplateScope bl = TemplateScope.make();
            object2 = prim_syntax.reportSyntaxError(Lit46.execute(arrobject, bl), "too few expressions for 'if'");
        } else {
            object2 = syntax_case.error("syntax-case", x);
        }
        return object2;
    }

    static Object lambda3(Object x) {
        Object object2;
        Object object3 = x;
        Object[] arrobject = SyntaxPattern.allocVars(4, null);
        if (((Pattern)Lit48).match(x, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            Object object4 = Lit49.execute(arrobject, templateScope);
            templateScope = TemplateScope.make();
            object2 = try_catch.rewrite(object4, Lit50.execute(arrobject, templateScope));
        } else {
            object2 = syntax_case.error("syntax-case", x);
        }
        return object2;
    }

    static Object lambda4(Object form) {
        Object object2;
        EmptyList emptyList = LList.Empty;
        LList out$Mninits = LList.Empty;
        Object object3 = form;
        Object[] arrobject = SyntaxPattern.allocVars(2, null);
        if (((Pattern)Lit52).match(form, arrobject, 0)) {
            LList out$Mnbindings;
            Object b;
            block8 : {
                Object[] arrobject2;
                TemplateScope templateScope = TemplateScope.make();
                Object object4 = Lit53.execute(arrobject, templateScope);
                do {
                    TemplateScope templateScope2;
                    Object object5 = b = object4;
                    arrobject2 = SyntaxPattern.allocVars(7, arrobject);
                    if (((Pattern)Lit54).match(b, arrobject2, 0)) break block8;
                    if (((Pattern)Lit55).match(b, arrobject2, 0)) {
                        templateScope2 = TemplateScope.make();
                        out$Mnbindings = new Pair(Lit56.execute(arrobject2, templateScope2), out$Mnbindings);
                        templateScope2 = TemplateScope.make();
                        out$Mninits = new Pair(Lit57.execute(arrobject2, templateScope2), out$Mninits);
                        templateScope2 = TemplateScope.make();
                        object4 = Lit58.execute(arrobject2, templateScope2);
                        continue;
                    }
                    if (!((Pattern)Lit59).match(b, arrobject2, 0)) break;
                    templateScope2 = TemplateScope.make();
                    out$Mnbindings = new Pair(Lit60.execute(arrobject2, templateScope2), out$Mnbindings);
                    templateScope2 = TemplateScope.make();
                    out$Mninits = new Pair(Lit61.execute(arrobject2, templateScope2), out$Mninits);
                    templateScope2 = TemplateScope.make();
                    object4 = Lit62.execute(arrobject2, templateScope2);
                } while (true);
                if (((Pattern)Lit63).match(b, arrobject2, 0)) {
                    prim_syntax.reportSyntaxError(b, "missing initializion in letrec");
                } else if (((Pattern)Lit64).match(b, arrobject2, 0)) {
                    prim_syntax.reportSyntaxError(b, "invalid bindings syntax in letrec");
                } else {
                    syntax_case.error("syntax-case", b);
                }
            }
            out$Mnbindings = LList.reverseInPlace(out$Mnbindings);
            out$Mninits = LList.reverseInPlace(out$Mninits);
            b = TemplateScope.make();
            object2 = Quote.append$V(new Object[]{Lit65.execute(arrobject, (TemplateScope)b), Quote.consX$V(new Object[]{out$Mnbindings, Quote.append$V(new Object[]{out$Mninits, Lit66.execute(arrobject, (TemplateScope)b)})})});
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
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        if (moduleMethod.selector == 1) {
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

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 2: {
                return prim_syntax.lambda1(object2);
            }
            case 3: {
                return prim_syntax.lambda2(object2);
            }
            case 4: {
                return prim_syntax.lambda3(object2);
            }
            case 5: {
                return prim_syntax.lambda4(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        if (moduleMethod.selector == 1) {
            int n = arrobject.length - 1;
            Object[] arrobject2 = new Object[n];
            while (--n >= 0) {
                arrobject2 = arrobject2;
                arrobject2[n] = arrobject[n + 1];
            }
            return prim_syntax.reportSyntaxError(arrobject[0], arrobject2);
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

