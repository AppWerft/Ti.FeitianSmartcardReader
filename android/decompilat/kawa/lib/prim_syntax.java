// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.lists.EmptyList;
import kawa.standard.try_catch;
import gnu.expr.IfExp;
import gnu.kawa.reflect.TypeSwitch;
import gnu.expr.BeginExp;
import kawa.lang.Quote;
import gnu.mapping.WrongType;
import kawa.standard.syntax_case;
import gnu.expr.ExitExp;
import gnu.mapping.Promise;
import gnu.expr.BlockExp;
import kawa.lang.SyntaxForms;
import kawa.lang.TemplateScope;
import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import kawa.lang.SyntaxRule;
import gnu.lists.Pair;
import gnu.mapping.Values;
import gnu.lists.LList;
import gnu.expr.Special;
import gnu.mapping.Symbol;
import kawa.standard.syntax_error;
import gnu.expr.Expression;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.math.IntNum;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxTemplate;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class prim_syntax extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static Expression reportSyntaxError(final Object id, final Object... msg) {
        return syntax_error.error(id, msg);
    }
    
    static {
        Lit98 = Symbol.valueOf("%define-syntax");
        Lit97 = IntNum.valueOf(0);
        Lit96 = IntNum.valueOf(1);
        Lit95 = IntNum.valueOf(4);
        Lit94 = IntNum.valueOf(5);
        Lit93 = IntNum.valueOf(8);
        Lit92 = IntNum.valueOf(9);
        Lit91 = IntNum.valueOf(24);
        Lit90 = IntNum.valueOf(25);
        (Lit89 = new Object[] { null })[0] = (Lit79 = Symbol.valueOf("$lookup$"));
        final Object[] lit88 = new Object[2];
        (Lit88 = lit88)[0] = prim_syntax.Lit79;
        lit88[1] = (Lit71 = Symbol.valueOf("::"));
        final Object[] lit89 = new Object[2];
        (Lit87 = lit89)[0] = prim_syntax.Lit71;
        lit89[1] = prim_syntax.Lit79;
        Lit86 = IntNum.valueOf(32);
        Lit85 = IntNum.valueOf(33);
        Lit84 = Symbol.valueOf("%define");
        Lit83 = PairWithPosition.make(Special.undefined, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 753726);
        (Lit82 = new Object[] { null })[0] = prim_syntax.Lit71;
        Lit81 = Symbol.valueOf("quasiquote");
        Lit80 = Symbol.valueOf("kawa.lang.SyntaxForms");
        (Lit78 = new Object[] { null })[0] = (Lit75 = Symbol.valueOf("and"));
        (Lit77 = new Object[] { null })[0] = (Lit74 = Symbol.valueOf("?"));
        Lit76 = PairWithPosition.make(Values.empty, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 520224);
        Lit73 = PairWithPosition.make(Symbol.valueOf("unused"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 561171);
        Lit72 = Symbol.valueOf("lambda");
        Lit70 = Symbol.valueOf("mlambda");
        (Lit69 = new Object[] { null })[0] = prim_syntax.Lit83;
        (Lit68 = new Object[] { null })[0] = Symbol.valueOf("set!");
        Lit67 = new Object[0];
        Lit66 = new SyntaxTemplate("\u0001\u0000", "\n", prim_syntax.Lit67, 0);
        Lit65 = new SyntaxTemplate("\u0001\u0000", "\u0018\u0004", new Object[] { Pair.make(Symbol.valueOf("%let"), LList.Empty) }, 0);
        Lit64 = new SyntaxPattern("\u0013", prim_syntax.Lit67, 3, "prim_syntax.scm:189");
        Lit63 = new SyntaxPattern("\u001c\f\u0017\b\u001b", prim_syntax.Lit67, 4, "prim_syntax.scm:187");
        Lit62 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0001\u0001\u0000", "2", prim_syntax.Lit67, 0);
        Lit61 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0013\b+", prim_syntax.Lit68, 0);
        Lit60 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0001\u0001\u0000", "\t\u0013\t\u001b\t#\u0018\u0004", prim_syntax.Lit69, 0);
        Lit59 = new SyntaxPattern("L\f\u0017\f\u001f\f'\f/\b3", prim_syntax.Lit67, 7, "prim_syntax.scm:182");
        Lit58 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0000", "\"", prim_syntax.Lit67, 0);
        Lit57 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0013\b\u001b", prim_syntax.Lit68, 0);
        Lit56 = new SyntaxTemplate("\u0001\u0000\u0001\u0001\u0000", "\t\u0013\u0018\u0004", prim_syntax.Lit69, 0);
        Lit55 = new SyntaxPattern(",\f\u0017\f\u001f\b#", prim_syntax.Lit67, 5, "prim_syntax.scm:176");
        Lit54 = new SyntaxPattern("\b", prim_syntax.Lit67, 2, "prim_syntax.scm:175");
        Lit53 = new SyntaxTemplate("\u0001\u0000", "\u0003", prim_syntax.Lit67, 0);
        Lit52 = new SyntaxPattern("\f\u0018\f\u0007\u000b", prim_syntax.Lit67, 2, "prim_syntax.scm:168");
        Lit51 = Symbol.valueOf("letrec");
        Lit50 = new SyntaxTemplate("\u0001\u0003\u0003\u0002", "(\b\rA\b\t\u000b\u0011\u0018\u0004\b\u0013\u001a", prim_syntax.Lit82, 1);
        Lit49 = new SyntaxTemplate("\u0001\u0003\u0003\u0002", "\u0003", prim_syntax.Lit67, 0);
        Lit48 = new SyntaxPattern("\f\u0018\f\u0007-\f\u000f\f\u0017\u001b\b\u0018\b", prim_syntax.Lit67, 4, "prim_syntax.scm:158");
        Lit47 = Symbol.valueOf("try-catch");
        Lit46 = new SyntaxTemplate("\u0000", "\u0002", prim_syntax.Lit67, 0);
        Lit45 = new SyntaxPattern("\f\u0018\u0003", prim_syntax.Lit67, 1, "prim_syntax.scm:151");
        Lit44 = new SyntaxTemplate("\u0001\u0001\u0001\u0000", "\u001a", prim_syntax.Lit67, 0);
        Lit43 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\u001b", prim_syntax.Lit67, 4, "prim_syntax.scm:148");
        Lit42 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0013", prim_syntax.Lit67, 0);
        Lit41 = new SyntaxTemplate("\u0001\u0001\u0001", "\u000b", prim_syntax.Lit67, 0);
        Lit40 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0003", prim_syntax.Lit67, 0);
        Lit39 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", prim_syntax.Lit67, 3, "prim_syntax.scm:143");
        Lit38 = new SyntaxTemplate("\u0001\u0001", "\u000b", prim_syntax.Lit67, 0);
        Lit37 = new SyntaxTemplate("\u0001\u0001", "\u0003", prim_syntax.Lit67, 0);
        Lit36 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", prim_syntax.Lit67, 2, "prim_syntax.scm:138");
        Lit35 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\t\u000bA\u0011\u0018\u0004\u0011\b\u0003\b\u0013\b\u0011\u0018\f\u0011\u0018\u0014\b\u001b", new Object[] { prim_syntax.Lit70, prim_syntax.Lit72, prim_syntax.Lit73 }, 0);
        Lit34 = new SyntaxPattern("\f\u0018<\f\u0002\f\u0007\f\u000f\b\f\u0017\f\u001f\b", prim_syntax.Lit77, 4, "prim_syntax.scm:133");
        Lit33 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001", "\t\u0013i\u0011\u0018\u00049\t\u0003\u0011\u0018\f\b\u000b\b\u001b\b\u0011\u0018\u0014\u0011\u0018\u001c\b#", new Object[] { prim_syntax.Lit70, prim_syntax.Lit71, prim_syntax.Lit72, prim_syntax.Lit73 }, 0);
        Lit32 = new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007\f\n\f\u000f\f\u0017\b\f\u001f\f'\b", new Object[] { prim_syntax.Lit74, prim_syntax.Lit71 }, 5, "prim_syntax.scm:128");
        Lit31 = new SyntaxTemplate("\u0000\u0001", "\u0011\u0018\u0004!\u0011\u0018\f\u0002\t\u000b\u0018\u0014", new Object[] { Lit23 = Symbol.valueOf("if"), prim_syntax.Lit75, prim_syntax.Lit76 }, 0);
        Lit30 = new SyntaxPattern("\f\u0018\u001c\f\u0002\u0003\f\u000f\b", prim_syntax.Lit78, 2, "prim_syntax.scm:126");
        Lit29 = new SyntaxTemplate("\u0000\u0001", "\u0011\u0018\u0004!\u0011\u0018\f\u0002\t\u000b\u0018\u0014", new Object[] { prim_syntax.Lit23, prim_syntax.Lit74, prim_syntax.Lit76 }, 0);
        Lit28 = new SyntaxPattern("\f\u0018\u001c\f\u0002\u0003\f\u000f\b", prim_syntax.Lit77, 2, "prim_syntax.scm:124");
        Lit27 = new SyntaxTemplate("\u0000\u0001\u0001", "\u0013", prim_syntax.Lit67, 0);
        Lit26 = new SyntaxTemplate("\u0000\u0001\u0001", "\t\u000b\u0002", prim_syntax.Lit67, 0);
        Lit25 = new SyntaxTemplate("\u0000\u0001\u0001", "\u0018\u0004", new Object[] { Pair.make(Lit17 = Symbol.valueOf("%if-and-x"), LList.Empty) }, 0);
        Lit24 = new SyntaxPattern("\f\u0018\u001c\f\u0002\u0003\f\u000f\f\u0017\b", prim_syntax.Lit78, 3, "prim_syntax.scm:116");
        Lit22 = new SyntaxTemplate("\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u0013\b\u0011\u0018\f\t\u0003\t\u000b\u001a", new Object[] { prim_syntax.Lit23, prim_syntax.Lit17 }, 0);
        Lit21 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\u001b", prim_syntax.Lit67, 4, "prim_syntax.scm:109");
        Lit20 = new SyntaxTemplate("\u0001\u0001", "\u0003", prim_syntax.Lit67, 0);
        Lit19 = new SyntaxTemplate("\u0001\u0001", "\u000b", prim_syntax.Lit67, 0);
        Lit18 = new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", prim_syntax.Lit67, 2, "prim_syntax.scm:107");
        Lit16 = new SyntaxRules(prim_syntax.Lit67, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", prim_syntax.Lit67, 1, "prim_syntax.scm:101"), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[] { PairWithPosition.make(prim_syntax.Lit79, Pair.make(prim_syntax.Lit80, Pair.make(Pair.make(prim_syntax.Lit81, Pair.make(Symbol.valueOf("rewriteBody"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 417799) }, 0) }, 1, Lit15 = Symbol.valueOf("syntax-body->expression"));
        Lit14 = new SyntaxRules(prim_syntax.Lit67, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", prim_syntax.Lit67, 1, "prim_syntax.scm:96"), "\u0001", "\u0011\u0018\u0004\b\u0003", new Object[] { PairWithPosition.make(prim_syntax.Lit79, Pair.make(prim_syntax.Lit80, Pair.make(Pair.make(prim_syntax.Lit81, Pair.make(Symbol.valueOf("rewrite"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm", 397319) }, 0) }, 1, Lit13 = Symbol.valueOf("syntax->expression"));
        Lit12 = Symbol.valueOf("report-syntax-error");
        Lit11 = new SyntaxRules(prim_syntax.Lit87, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", prim_syntax.Lit82, 2, "prim_syntax.scm:78"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\u0011\u0018\f\t\u000b\u0018\u0014", new Object[] { Lit10 = Symbol.valueOf("define-variable"), prim_syntax.Lit71, prim_syntax.Lit83 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", prim_syntax.Lit67, 1, "prim_syntax.scm:80"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", new Object[] { prim_syntax.Lit10, prim_syntax.Lit83 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", prim_syntax.Lit88, 5, "prim_syntax.scm:82"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit85 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", prim_syntax.Lit89, 4, "prim_syntax.scm:84"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit86, null }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", prim_syntax.Lit82, 3, "prim_syntax.scm:86"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[] { prim_syntax.Lit84, prim_syntax.Lit85 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", prim_syntax.Lit67, 2, "prim_syntax.scm:88"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit86, null }, 0) }, 5, prim_syntax.Lit10);
        Lit9 = new SyntaxRules(prim_syntax.Lit87, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", prim_syntax.Lit88, 5, "prim_syntax.scm:67"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit90 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", prim_syntax.Lit89, 4, "prim_syntax.scm:69"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit91, null }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", prim_syntax.Lit82, 3, "prim_syntax.scm:71"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[] { prim_syntax.Lit84, prim_syntax.Lit90 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", prim_syntax.Lit67, 2, "prim_syntax.scm:73"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit91, null }, 0) }, 5, Lit8 = Symbol.valueOf("define-early-constant"));
        Lit7 = new SyntaxRules(prim_syntax.Lit87, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", prim_syntax.Lit88, 5, "prim_syntax.scm:56"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit92 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", prim_syntax.Lit89, 4, "prim_syntax.scm:58"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit93, null }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", prim_syntax.Lit82, 3, "prim_syntax.scm:60"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[] { prim_syntax.Lit84, prim_syntax.Lit92 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", prim_syntax.Lit67, 2, "prim_syntax.scm:62"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit93, null }, 0) }, 5, Lit6 = Symbol.valueOf("define-constant"));
        Lit5 = new SyntaxRules(prim_syntax.Lit87, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", prim_syntax.Lit88, 5, "prim_syntax.scm:43"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit94 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", prim_syntax.Lit89, 4, "prim_syntax.scm:45"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit95, null }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", prim_syntax.Lit67, 3, "prim_syntax.scm:47"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\t\f\t\u0014\t\n\u0012", new Object[] { prim_syntax.Lit84, IntNum.valueOf(6), Boolean.TRUE }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", prim_syntax.Lit82, 3, "prim_syntax.scm:49"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[] { prim_syntax.Lit84, prim_syntax.Lit94 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", prim_syntax.Lit67, 2, "prim_syntax.scm:51"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit95, null }, 0) }, 5, Lit4 = Symbol.valueOf("define-private"));
        Lit3 = new SyntaxRules(prim_syntax.Lit87, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\n\f\u001f\f'\b", prim_syntax.Lit88, 5, "prim_syntax.scm:30"), "\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\t\u001b\b#", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit96 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", prim_syntax.Lit89, 4, "prim_syntax.scm:32"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\t\u0014\u0011\u0018\u001c\b\u001b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit79, prim_syntax.Lit97, null }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", prim_syntax.Lit67, 3, "prim_syntax.scm:34"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\t\f\t\u0014\t\n\u0012", new Object[] { prim_syntax.Lit84, IntNum.valueOf(2), Boolean.TRUE }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\f\u0017\b", prim_syntax.Lit82, 3, "prim_syntax.scm:36"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\t\u000b\b\u0013", new Object[] { prim_syntax.Lit84, prim_syntax.Lit96 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", prim_syntax.Lit67, 2, "prim_syntax.scm:38"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\u0011\u0018\u0014\b\u000b", new Object[] { prim_syntax.Lit84, prim_syntax.Lit97, null }, 0) }, 5, Lit2 = Symbol.valueOf("define"));
        Lit1 = new SyntaxRules(prim_syntax.Lit89, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018l\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\u001b#", prim_syntax.Lit89, 5, "prim_syntax.scm:17"), "\u0001\u0001\u0001\u0000\u0000", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\b\u0011\u0018\u0014\t\u001a\"", new Object[] { prim_syntax.Lit98, prim_syntax.Lit79, prim_syntax.Lit72 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\\\f\u0002\f\u0007,\f\u000f\f\u0017\b\b\f\u001f\b", prim_syntax.Lit89, 4, "prim_syntax.scm:20"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004Q\u0011\u0018\f\t\u0003\b\t\u000b\b\u0013\b\u001b", new Object[] { prim_syntax.Lit98, prim_syntax.Lit79 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\u001c\f\u0007\u000b\u0013", prim_syntax.Lit67, 3, "prim_syntax.scm:22"), "\u0001\u0000\u0000", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\t\n\u0012", new Object[] { prim_syntax.Lit98, prim_syntax.Lit72 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", prim_syntax.Lit67, 2, "prim_syntax.scm:25"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[] { prim_syntax.Lit98 }, 0) }, 5, Lit0 = Symbol.valueOf("define-syntax"));
        prim_syntax.$instance = new prim_syntax();
        $Prvt$$Pcdefine = StaticFieldLocation.make("kawa.standard.define", "defineRaw");
        $Prvt$$Pcdefine$Mnsyntax = StaticFieldLocation.make("kawa.standard.define_syntax", "define_syntax");
        $Prvt$$Pclet = StaticFieldLocation.make("kawa.standard.let", "let");
        $Prvt$set$Ex = StaticFieldLocation.make("kawa.standard.set_b", "set");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        $Prvt$mlambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "mlambda");
        define$Mnsyntax = Macro.make(prim_syntax.Lit0, prim_syntax.Lit1, "kawa.lib.prim_syntax");
        define = Macro.make(prim_syntax.Lit2, prim_syntax.Lit3, "kawa.lib.prim_syntax");
        define$Mnprivate = Macro.make(prim_syntax.Lit4, prim_syntax.Lit5, "kawa.lib.prim_syntax");
        define$Mnconstant = Macro.make(prim_syntax.Lit6, prim_syntax.Lit7, "kawa.lib.prim_syntax");
        define$Mnearly$Mnconstant = Macro.make(prim_syntax.Lit8, prim_syntax.Lit9, "kawa.lib.prim_syntax");
        define$Mnvariable = Macro.make(prim_syntax.Lit10, prim_syntax.Lit11, "kawa.lib.prim_syntax");
        report$Mnsyntax$Mnerror = new ModuleMethod(prim_syntax.$instance, 1, prim_syntax.Lit12, -4095);
        syntax$Mn$Grexpression = Macro.make(prim_syntax.Lit13, prim_syntax.Lit14, "kawa.lib.prim_syntax");
        syntax$Mnbody$Mn$Grexpression = Macro.make(prim_syntax.Lit15, prim_syntax.Lit16, "kawa.lib.prim_syntax");
        final SimpleSymbol lit90 = prim_syntax.Lit17;
        final ModuleMethod expander = new ModuleMethod(prim_syntax.$instance, 2, null, 4097);
        expander.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:105");
        $Prvt$$Pcif$Mnand$Mnx = Macro.make(lit90, expander, "kawa.lib.prim_syntax");
        final SimpleSymbol lit91 = prim_syntax.Lit23;
        final ModuleMethod expander2 = new ModuleMethod(prim_syntax.$instance, 3, null, 4097);
        expander2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:114");
        if = Macro.makeSkipScanForm(lit91, expander2, "kawa.lib.prim_syntax");
        final SimpleSymbol lit92 = prim_syntax.Lit47;
        final ModuleMethod expander3 = new ModuleMethod(prim_syntax.$instance, 4, null, 4097);
        expander3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:156");
        try$Mncatch = Macro.makeSkipScanForm(lit92, expander3, "kawa.lib.prim_syntax");
        final SimpleSymbol lit93 = prim_syntax.Lit51;
        final ModuleMethod expander4 = new ModuleMethod(prim_syntax.$instance, 5, null, 4097);
        expander4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/prim_syntax.scm:165");
        letrec = Macro.make(lit93, expander4, "kawa.lib.prim_syntax");
        $runBody$();
    }
    
    public prim_syntax() {
        ModuleInfo.register(this);
    }
    
    static Object lambda1(final Object x) {
        final Object[] allocVars = SyntaxPattern.allocVars(4, null);
        Label_0068: {
            if (!prim_syntax.Lit18.match(x, allocVars, 0)) {
                break Label_0068;
            }
            ExitExp exitExp = null;
            Object o = exitExp;
            final Expression rewrite = SyntaxForms.rewrite(prim_syntax.Lit19.execute(allocVars, TemplateScope.make()));
            final Object force = Promise.force(prim_syntax.Lit20.execute(allocVars, TemplateScope.make()), BlockExp.class);
            try {
                exitExp = new ExitExp(rewrite, (BlockExp)force);
                return o;
                o = (prim_syntax.Lit21.match(x, allocVars, 0) ? prim_syntax.Lit22.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", x));
                return o;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "gnu.expr.ExitExp.<init>(gnu.expr.Expression,gnu.expr.BlockExp)", 2, force);
            }
        }
    }
    
    static Object lambda2(final Object x) {
        final Object[] allocVars = SyntaxPattern.allocVars(5, null);
        Object o;
        if (prim_syntax.Lit24.match(x, allocVars, 0)) {
            final BlockExp bl = new BlockExp();
            bl.setRunFinallyBlocks(false);
            final BlockExp blockExp = bl;
            final TemplateScope make = TemplateScope.make();
            blockExp.setBody(new BeginExp(SyntaxForms.rewrite(Quote.append$V(new Object[] { prim_syntax.Lit25.execute(allocVars, make), Quote.consX$V(new Object[] { bl, prim_syntax.Lit26.execute(allocVars, make) }) })), SyntaxForms.rewrite(prim_syntax.Lit27.execute(allocVars, TemplateScope.make()))));
            o = bl;
        }
        else {
            o = (prim_syntax.Lit28.match(x, allocVars, 0) ? prim_syntax.Lit29.execute(allocVars, TemplateScope.make()) : (prim_syntax.Lit30.match(x, allocVars, 0) ? prim_syntax.Lit31.execute(allocVars, TemplateScope.make()) : (prim_syntax.Lit32.match(x, allocVars, 0) ? Quote.consX$V(new Object[] { TypeSwitch.typeSwitch, prim_syntax.Lit33.execute(allocVars, TemplateScope.make()) }) : (prim_syntax.Lit34.match(x, allocVars, 0) ? Quote.consX$V(new Object[] { TypeSwitch.typeSwitch, prim_syntax.Lit35.execute(allocVars, TemplateScope.make()) }) : (prim_syntax.Lit36.match(x, allocVars, 0) ? new IfExp(SyntaxForms.rewrite(prim_syntax.Lit37.execute(allocVars, TemplateScope.make())), SyntaxForms.rewrite(prim_syntax.Lit38.execute(allocVars, TemplateScope.make())), null) : (prim_syntax.Lit39.match(x, allocVars, 0) ? new IfExp(SyntaxForms.rewrite(prim_syntax.Lit40.execute(allocVars, TemplateScope.make())), SyntaxForms.rewrite(prim_syntax.Lit41.execute(allocVars, TemplateScope.make())), SyntaxForms.rewrite(prim_syntax.Lit42.execute(allocVars, TemplateScope.make()))) : (prim_syntax.Lit43.match(x, allocVars, 0) ? reportSyntaxError(prim_syntax.Lit44.execute(allocVars, TemplateScope.make()), "too many expressions for 'if'") : (prim_syntax.Lit45.match(x, allocVars, 0) ? reportSyntaxError(prim_syntax.Lit46.execute(allocVars, TemplateScope.make()), "too few expressions for 'if'") : syntax_case.error("syntax-case", x)))))))));
        }
        return o;
    }
    
    static Object lambda3(final Object x) {
        final Object[] allocVars = SyntaxPattern.allocVars(4, null);
        return prim_syntax.Lit48.match(x, allocVars, 0) ? try_catch.rewrite(prim_syntax.Lit49.execute(allocVars, TemplateScope.make()), prim_syntax.Lit50.execute(allocVars, TemplateScope.make())) : syntax_case.error("syntax-case", x);
    }
    
    static Object lambda4(final Object form) {
        final EmptyList empty = LList.Empty;
        Object out$Mninits = LList.Empty;
        final Object[] allocVars = SyntaxPattern.allocVars(2, null);
        Object o2;
        if (prim_syntax.Lit52.match(form, allocVars, 0)) {
            Object o = prim_syntax.Lit53.execute(allocVars, TemplateScope.make());
            Object out$Mnbindings = null;
            while (true) {
                final Object b = o;
                final Object[] allocVars2 = SyntaxPattern.allocVars(7, allocVars);
                if (prim_syntax.Lit54.match(b, allocVars2, 0)) {
                    break;
                }
                if (prim_syntax.Lit55.match(b, allocVars2, 0)) {
                    out$Mnbindings = new Pair(prim_syntax.Lit56.execute(allocVars2, TemplateScope.make()), out$Mnbindings);
                    out$Mninits = new Pair(prim_syntax.Lit57.execute(allocVars2, TemplateScope.make()), out$Mninits);
                    o = prim_syntax.Lit58.execute(allocVars2, TemplateScope.make());
                }
                else if (prim_syntax.Lit59.match(b, allocVars2, 0)) {
                    out$Mnbindings = new Pair(prim_syntax.Lit60.execute(allocVars2, TemplateScope.make()), out$Mnbindings);
                    out$Mninits = new Pair(prim_syntax.Lit61.execute(allocVars2, TemplateScope.make()), out$Mninits);
                    o = prim_syntax.Lit62.execute(allocVars2, TemplateScope.make());
                }
                else {
                    if (prim_syntax.Lit63.match(b, allocVars2, 0)) {
                        reportSyntaxError(b, "missing initializion in letrec");
                        break;
                    }
                    if (prim_syntax.Lit64.match(b, allocVars2, 0)) {
                        reportSyntaxError(b, "invalid bindings syntax in letrec");
                        break;
                    }
                    syntax_case.error("syntax-case", b);
                    break;
                }
            }
            out$Mnbindings = LList.reverseInPlace(out$Mnbindings);
            out$Mninits = LList.reverseInPlace(out$Mninits);
            final TemplateScope make = TemplateScope.make();
            o2 = Quote.append$V(new Object[] { prim_syntax.Lit65.execute(allocVars, make), Quote.consX$V(new Object[] { out$Mnbindings, Quote.append$V(new Object[] { out$Mninits, prim_syntax.Lit66.execute(allocVars, make) }) }) });
        }
        else {
            o2 = syntax_case.error("syntax-case", form);
        }
        return o2;
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 5: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 4: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 3: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 2: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(proc, arg1, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.values = array;
            ctx.proc = moduleMethod;
            ctx.pc = 5;
            return 0;
        }
        return super.matchN(moduleMethod, array, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 2: {
                return lambda1(arg1);
            }
            case 3: {
                return lambda2(arg1);
            }
            case 4: {
                return lambda3(arg1);
            }
            case 5: {
                return lambda4(arg1);
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        if (method.selector == 1) {
            final Object id = args[0];
            int n = args.length - 1;
            final Object[] msg = new Object[n];
            while (--n >= 0) {
                msg[n] = args[n + 1];
            }
            return reportSyntaxError(id, msg);
        }
        return super.applyN(method, args);
    }
}
