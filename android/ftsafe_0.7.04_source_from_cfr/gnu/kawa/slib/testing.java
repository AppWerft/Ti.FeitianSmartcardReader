/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.SourceName;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.IsEqv;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.io.CharArrayInPort;
import gnu.kawa.io.OutPort;
import gnu.kawa.io.Path;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Macro;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.parameters;
import kawa.lib.ports;
import kawa.lib.scheme.eval;
import kawa.lib.std_syntax;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.syntax_case;

public class testing
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$cons;
    public static final StaticFieldLocation $Prvt$cdr;
    public static final StaticFieldLocation $Prvt$assq;
    public static final StaticFieldLocation $Prvt$dynamic$Mnwind;
    public static final StaticFieldLocation $Prvt$if;
    public static final StaticFieldLocation $Prvt$cond;
    public static final StaticFieldLocation $Prvt$and;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$let$St;
    public static final StaticFieldLocation $Prvt$else;
    public static final StaticFieldLocation $Prvt$define$Mnrecord$Mntype;
    public static final StaticFieldLocation $Prvt$begin;
    public static final StaticFieldLocation $Prvt$eq$Qu;
    public static final StaticFieldLocation $Prvt$equal$Qu;
    public static final StaticFieldLocation $Prvt$eqv$Qu;
    public static final StaticFieldLocation $Prvt$lambda;
    public static final StaticFieldLocation $Prvt$list;
    public static final StaticFieldLocation $Prvt$quasiquote;
    public static final StaticFieldLocation $Prvt$quote;
    public static final StaticFieldLocation $Prvt$try$Mncatch;
    public static final int $Pcprovide$Pcsrfi$Mn64 = 123;
    public static final int $Pcprovide$Pctesting = 123;
    public static final ModuleMethod $Pctest$Mnbegin;
    public static final Macro test$Mnbegin;
    public static final Macro test$Mnend;
    public static final Macro test$Mnassert;
    public static final Macro test$Mneqv;
    public static final Macro test$Mneq;
    public static final Macro test$Mnequal;
    public static final Macro test$Mnapproximate;
    public static final Macro test$Mnerror;
    public static final ModuleMethod test$Mnapply;
    public static final Macro test$Mnwith$Mnrunner;
    public static final Macro test$Mnmatch$Mnnth;
    public static final Macro test$Mnmatch$Mnall;
    public static final Macro test$Mnmatch$Mnany;
    public static final ModuleMethod test$Mnmatch$Mnname;
    public static final Macro test$Mnskip;
    public static final Macro test$Mnexpect$Mnfail;
    public static final ModuleMethod test$Mnread$Mneval$Mnstring;
    public static final ModuleMethod test$Mnrunner$Mngroup$Mnpath;
    public static final Macro test$Mngroup;
    public static final Macro test$Mngroup$Mnwith$Mncleanup;
    public static final Macro test$Mnresult$Mnref;
    public static final ModuleMethod test$Mnresult$Mnset$Ex;
    public static final ModuleMethod test$Mnresult$Mnclear;
    public static final ModuleMethod test$Mnresult$Mnremove;
    public static final ModuleMethod test$Mnresult$Mnkind;
    public static final ModuleMethod test$Mnpassed$Qu;
    public static boolean test$Mnlog$Mnto$Mnfile;
    public static final ModuleMethod test$Mnrunner$Qu;
    public static final ModuleMethod test$Mnrunner$Mnreset;
    public static final ModuleMethod test$Mnrunner$Mnnull;
    public static final ModuleMethod test$Mnrunner$Mnsimple;
    public static LocationProc test$Mnrunner$Mncurrent;
    public static LocationProc test$Mnrunner$Mnfactory;
    public static final ModuleMethod test$Mnrunner$Mnget;
    public static final ModuleMethod test$Mnrunner$Mncreate;
    public static final ModuleMethod test$Mnrunner$Mntest$Mnname;
    public static final ModuleMethod test$Mnrunner$Mnpass$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnpass$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnfail$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnfail$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnxpass$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnxpass$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnxfail$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnxfail$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnskip$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnskip$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mngroup$Mnstack;
    public static final ModuleMethod test$Mnrunner$Mngroup$Mnstack$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnbegin;
    public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnbegin$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnend;
    public static final ModuleMethod test$Mnrunner$Mnon$Mntest$Mnend$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnbegin;
    public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnend;
    public static final ModuleMethod test$Mnrunner$Mnon$Mngroup$Mnend$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnfinal;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnfinal$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mncount;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mncount$Ex;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mnend$Mnname;
    public static final ModuleMethod test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex;
    public static final ModuleMethod test$Mnresult$Mnalist;
    public static final ModuleMethod test$Mnresult$Mnalist$Ex;
    public static final ModuleMethod test$Mnrunner$Mnaux$Mnvalue;
    public static final ModuleMethod test$Mnrunner$Mnaux$Mnvalue$Ex;
    public static final ModuleMethod test$Mnon$Mngroup$Mnbegin$Mnsimple;
    public static final ModuleMethod test$Mnon$Mngroup$Mnend$Mnsimple;
    public static final ModuleMethod test$Mnon$Mnbad$Mncount$Mnsimple;
    public static final ModuleMethod test$Mnon$Mnbad$Mnend$Mnname$Mnsimple;
    public static final ModuleMethod test$Mnon$Mnfinal$Mnsimple;
    public static final ModuleMethod test$Mnon$Mntest$Mnend$Mnsimple;
    static final ClassType test$Mnrunner;
    public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist;
    public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex;
    public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist;
    public static final ModuleMethod $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex;
    static final ModuleMethod $Pctest$Mnnull$Mncallback;
    public static final ModuleMethod $Prvt$$Pctest$Mnshould$Mnexecute;
    public static final ModuleMethod $Prvt$$Pctest$Mnend;
    static final ModuleMethod test$Mnon$Mntest$Mnbegin$Mnsimple;
    public static final ModuleMethod $Prvt$$Pctest$Mnreport$Mnresult;
    public static final Macro $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch;
    public static final ModuleMethod $Prvt$$Pctest$Mnon$Mntest$Mnbegin;
    public static final ModuleMethod $Prvt$$Pctest$Mnon$Mntest$Mnend;
    public static final Macro $Prvt$$Pctest$Mncomp2body;
    public static final ModuleMethod $Prvt$$Pctest$Mnapproximate$Eq;
    public static final Macro $Prvt$$Pctest$Mncomp1body;
    public static final Macro $Prvt$$Pctest$Mnerror;
    public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnnth;
    public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnall;
    public static final ModuleMethod $Prvt$$Pctest$Mnmatch$Mnany;
    public static final ModuleMethod $Prvt$$Pctest$Mnas$Mnspecifier;
    static final IntNum Lit0;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn3;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final PairWithPosition Lit8;
    static final SimpleSymbol Lit9;
    static final PairWithPosition Lit10;
    static final PairWithPosition Lit11;
    static final SimpleSymbol Lit12;
    static final IntNum Lit13;
    static final SimpleSymbol Lit14;
    static final SyntaxTemplate Lit15;
    static final SyntaxPattern Lit16;
    static final SyntaxTemplate Lit17;
    static final SyntaxPattern Lit18;
    static final SyntaxTemplate Lit19;
    public static testing $instance;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SyntaxRules Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SyntaxRules Lit73;
    static final SimpleSymbol Lit74;
    static final SyntaxRules Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SyntaxRules Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final SimpleSymbol Lit82;
    static final SimpleSymbol Lit83;
    static final SimpleSymbol Lit84;
    static final SimpleSymbol Lit85;
    static final SimpleSymbol Lit86;
    static final SyntaxRules Lit87;
    static final SimpleSymbol Lit88;
    static final SimpleSymbol Lit89;
    static final SimpleSymbol Lit90;
    static final SimpleSymbol Lit91;
    static final SyntaxRules Lit92;
    static final SimpleSymbol Lit93;
    static final SimpleSymbol Lit94;
    static final SyntaxRules Lit95;
    static final SimpleSymbol Lit96;
    static final SyntaxTemplate Lit97;
    static final SyntaxPattern Lit98;
    static final SyntaxTemplate Lit99;
    static final SyntaxPattern Lit100;
    static final SyntaxTemplate Lit101;
    static final SimpleSymbol Lit102;
    static final SyntaxTemplate Lit103;
    static final SyntaxPattern Lit104;
    static final SyntaxTemplate Lit105;
    static final SyntaxPattern Lit106;
    static final SyntaxTemplate Lit107;
    static final SimpleSymbol Lit108;
    static final SyntaxTemplate Lit109;
    static final SimpleSymbol Lit110;
    static final SyntaxTemplate Lit111;
    static final SimpleSymbol Lit112;
    static final SyntaxTemplate Lit113;
    static final SimpleSymbol Lit114;
    static final SyntaxTemplate Lit115;
    static final SyntaxPattern Lit116;
    static final SyntaxTemplate Lit117;
    static final SyntaxPattern Lit118;
    static final SyntaxTemplate Lit119;
    static final SimpleSymbol Lit120;
    static final SyntaxRules Lit121;
    static final SimpleSymbol Lit122;
    static final SyntaxTemplate Lit123;
    static final SyntaxPattern Lit124;
    static final SyntaxTemplate Lit125;
    static final SyntaxPattern Lit126;
    static final SyntaxTemplate Lit127;
    static final SyntaxPattern Lit128;
    static final SyntaxTemplate Lit129;
    static final SimpleSymbol Lit130;
    static final SimpleSymbol Lit131;
    static final SyntaxRules Lit132;
    static final SimpleSymbol Lit133;
    static final SimpleSymbol Lit134;
    static final SyntaxRules Lit135;
    static final SimpleSymbol Lit136;
    static final SimpleSymbol Lit137;
    static final SyntaxRules Lit138;
    static final SimpleSymbol Lit139;
    static final SimpleSymbol Lit140;
    static final SyntaxRules Lit141;
    static final SimpleSymbol Lit142;
    static final SimpleSymbol Lit143;
    static final SyntaxRules Lit144;
    static final SimpleSymbol Lit145;
    static final SyntaxRules Lit146;
    static final SimpleSymbol Lit147;
    static final SimpleSymbol Lit148;
    static final Object[] Lit149;
    static final SimpleSymbol Lit150;
    static final SimpleSymbol Lit151;
    static final PairWithPosition Lit152;
    static final SimpleSymbol Lit153;
    static final PairWithPosition Lit154;
    static final SimpleSymbol Lit155;
    static final SimpleSymbol Lit156;
    static final SimpleSymbol Lit157;
    static final PairWithPosition Lit158;
    static final SimpleSymbol Lit159;
    static final SimpleSymbol Lit160;
    static final PairWithPosition Lit161;
    static final PairWithPosition Lit162;
    static final SimpleSymbol Lit163;
    static final SimpleSymbol Lit164;
    static final PairWithPosition Lit165;
    static final PairWithPosition Lit166;
    static final SimpleSymbol Lit167;
    static final SimpleSymbol Lit168;
    static final PairWithPosition Lit169;
    static final PairWithPosition Lit170;
    static final SimpleSymbol Lit171;
    static final PairWithPosition Lit172;
    static final SimpleSymbol Lit173;
    static final SimpleSymbol Lit174;
    static final PairWithPosition Lit175;
    static final PairWithPosition Lit176;
    static final SimpleSymbol Lit177;
    static final PairWithPosition Lit178;
    static final Object[] Lit179;
    static final SimpleSymbol Lit180;
    static final SimpleSymbol Lit181;
    static final PairWithPosition Lit182;
    static final SimpleSymbol Lit183;
    static final PairWithPosition Lit184;
    static final PairWithPosition Lit185;
    static final SimpleSymbol Lit186;
    static final SimpleSymbol Lit187;
    static final PairWithPosition Lit188;
    static final PairWithPosition Lit189;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        test$Mnlog$Mnto$Mnfile = true;
        test$Mnrunner$Mncurrent = parameters.makeParameter(Boolean.FALSE);
        test$Mnrunner$Mnfactory = parameters.makeParameter(test$Mnrunner$Mnsimple);
    }

    public static boolean isTestRunner(Object obj) {
        return obj instanceof test-runner;
    }

    public static Object testRunnerPassCount(test-runner obj) {
        return obj.pass$Mncount;
    }

    public static void testRunnerPassCount$Ex(test-runner obj, Object value) {
        obj.pass$Mncount = value;
    }

    public static Object testRunnerFailCount(test-runner obj) {
        return obj.fail$Mncount;
    }

    public static void testRunnerFailCount$Ex(test-runner obj, Object value) {
        obj.fail$Mncount = value;
    }

    public static Object testRunnerXpassCount(test-runner obj) {
        return obj.xpass$Mncount;
    }

    public static void testRunnerXpassCount$Ex(test-runner obj, Object value) {
        obj.xpass$Mncount = value;
    }

    public static Object testRunnerXfailCount(test-runner obj) {
        return obj.xfail$Mncount;
    }

    public static void testRunnerXfailCount$Ex(test-runner obj, Object value) {
        obj.xfail$Mncount = value;
    }

    public static Object testRunnerSkipCount(test-runner obj) {
        return obj.skip$Mncount;
    }

    public static void testRunnerSkipCount$Ex(test-runner obj, Object value) {
        obj.skip$Mncount = value;
    }

    public static Object $PcTestRunnerSkipList(test-runner obj) {
        return obj.skip$Mnlist;
    }

    public static void $PcTestRunnerSkipList$Ex(test-runner obj, Object value) {
        obj.skip$Mnlist = value;
    }

    public static Object $PcTestRunnerFailList(test-runner obj) {
        return obj.fail$Mnlist;
    }

    public static void $PcTestRunnerFailList$Ex(test-runner obj, Object value) {
        obj.fail$Mnlist = value;
    }

    public static Object testRunnerGroupStack(test-runner obj) {
        return obj.group$Mnstack;
    }

    public static void testRunnerGroupStack$Ex(test-runner obj, Object value) {
        obj.group$Mnstack = value;
    }

    public static Object testRunnerOnTestBegin(test-runner obj) {
        return obj.on$Mntest$Mnbegin;
    }

    public static void testRunnerOnTestBegin$Ex(test-runner obj, Object value) {
        obj.on$Mntest$Mnbegin = value;
    }

    public static Object testRunnerOnTestEnd(test-runner obj) {
        return obj.on$Mntest$Mnend;
    }

    public static void testRunnerOnTestEnd$Ex(test-runner obj, Object value) {
        obj.on$Mntest$Mnend = value;
    }

    public static Object testRunnerOnGroupBegin(test-runner obj) {
        return obj.on$Mngroup$Mnbegin;
    }

    public static void testRunnerOnGroupBegin$Ex(test-runner obj, Object value) {
        obj.on$Mngroup$Mnbegin = value;
    }

    public static Object testRunnerOnGroupEnd(test-runner obj) {
        return obj.on$Mngroup$Mnend;
    }

    public static void testRunnerOnGroupEnd$Ex(test-runner obj, Object value) {
        obj.on$Mngroup$Mnend = value;
    }

    public static Object testRunnerOnFinal(test-runner obj) {
        return obj.on$Mnfinal;
    }

    public static void testRunnerOnFinal$Ex(test-runner obj, Object value) {
        obj.on$Mnfinal = value;
    }

    public static Object testRunnerOnBadCount(test-runner obj) {
        return obj.on$Mnbad$Mncount;
    }

    public static void testRunnerOnBadCount$Ex(test-runner obj, Object value) {
        obj.on$Mnbad$Mncount = value;
    }

    public static Object testRunnerOnBadEndName(test-runner obj) {
        return obj.on$Mnbad$Mnend$Mnname;
    }

    public static void testRunnerOnBadEndName$Ex(test-runner obj, Object value) {
        obj.on$Mnbad$Mnend$Mnname = value;
    }

    public static Object testResultAlist(test-runner obj) {
        return obj.result$Mnalist;
    }

    public static void testResultAlist$Ex(test-runner obj, Object value) {
        obj.result$Mnalist = value;
    }

    public static Object testRunnerAuxValue(test-runner obj) {
        return obj.aux$Mnvalue;
    }

    public static void testRunnerAuxValue$Ex(test-runner obj, Object value) {
        obj.aux$Mnvalue = value;
    }

    public static void testRunnerReset(Object runner) {
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testResultAlist$Ex((test-runner)object2, LList.Empty);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testRunnerPassCount$Ex((test-runner)object2, Lit0);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-pass-count!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testRunnerFailCount$Ex((test-runner)object2, Lit0);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-fail-count!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testRunnerXpassCount$Ex((test-runner)object2, Lit0);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-xpass-count!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testRunnerXfailCount$Ex((test-runner)object2, Lit0);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-xfail-count!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testRunnerSkipCount$Ex((test-runner)object2, Lit0);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-skip-count!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestRunnerTotalCount$Ex((test-runner)object2, Lit0);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-total-count!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestRunnerCountList$Ex((test-runner)object2, LList.Empty);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-count-list!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestRunnerRunList$Ex((test-runner)object2, Boolean.TRUE);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-run-list!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestRunnerSkipList$Ex((test-runner)object2, LList.Empty);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-skip-list!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestRunnerFailList$Ex((test-runner)object2, LList.Empty);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-fail-list!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestRunnerSkipSave$Ex((test-runner)object2, LList.Empty);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-skip-save!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestRunnerFailSave$Ex((test-runner)object2, LList.Empty);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-fail-save!", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testRunnerGroupStack$Ex((test-runner)object2, LList.Empty);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-group-stack!", 0, object2);
        }
    }

    static void $PcTestRunnerTotalCount$Ex(test-runner obj, Object value) {
        obj.total$Mncount = value;
    }

    static void $PcTestRunnerCountList$Ex(test-runner obj, Object value) {
        obj.count$Mnlist = value;
    }

    static void $PcTestRunnerRunList$Ex(test-runner obj, Object value) {
        obj.run$Mnlist = value;
    }

    static void $PcTestRunnerSkipSave$Ex(test-runner obj, Object value) {
        obj.skip$Mnsave = value;
    }

    static void $PcTestRunnerFailSave$Ex(test-runner obj, Object value) {
        obj.fail$Mnsave = value;
    }

    public static LList testRunnerGroupPath(Object runner) {
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            object2 = Promise.force(testing.testRunnerGroupStack((test-runner)object2), LList.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-group-stack", 0, object2);
        }
        try {
            return lists.reverse((LList)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse", 1, object2);
        }
    }

    static boolean $PcTestNullCallback(Object runner) {
        return false;
    }

    public static test-runner testRunnerNull() {
        test-runner runner = testing.$PcTestRunnerAlloc();
        testing.testRunnerReset(runner);
        testing.testRunnerOnGroupBegin$Ex(runner, lambda$Fn1);
        testing.testRunnerOnGroupEnd$Ex(runner, $Pctest$Mnnull$Mncallback);
        testing.testRunnerOnFinal$Ex(runner, $Pctest$Mnnull$Mncallback);
        testing.testRunnerOnTestBegin$Ex(runner, $Pctest$Mnnull$Mncallback);
        testing.testRunnerOnTestEnd$Ex(runner, $Pctest$Mnnull$Mncallback);
        testing.testRunnerOnBadCount$Ex(runner, lambda$Fn2);
        testing.testRunnerOnBadEndName$Ex(runner, lambda$Fn3);
        return runner;
    }

    static test-runner $PcTestRunnerAlloc() {
        return new test-runner();
    }

    static boolean lambda1(Object runner, Object name, Object count) {
        return false;
    }

    static boolean lambda2(Object runner, Object count, Object expected) {
        return false;
    }

    static boolean lambda3(Object runner, Object begin2, Object end) {
        return false;
    }

    public static test-runner testRunnerSimple() {
        test-runner runner = testing.$PcTestRunnerAlloc();
        testing.testRunnerReset(runner);
        testing.testRunnerOnGroupBegin$Ex(runner, test$Mnon$Mngroup$Mnbegin$Mnsimple);
        testing.testRunnerOnGroupEnd$Ex(runner, test$Mnon$Mngroup$Mnend$Mnsimple);
        testing.testRunnerOnFinal$Ex(runner, test$Mnon$Mnfinal$Mnsimple);
        testing.testRunnerOnTestBegin$Ex(runner, test$Mnon$Mntest$Mnbegin$Mnsimple);
        testing.testRunnerOnTestEnd$Ex(runner, test$Mnon$Mntest$Mnend$Mnsimple);
        testing.testRunnerOnBadCount$Ex(runner, test$Mnon$Mnbad$Mncount$Mnsimple);
        testing.testRunnerOnBadEndName$Ex(runner, test$Mnon$Mnbad$Mnend$Mnname$Mnsimple);
        return runner;
    }

    public static Object testRunnerGet() {
        Object r = test$Mnrunner$Mncurrent.getValue();
        if (!KawaConvert.isTrue(r)) {
            Type.NeverReturns neverReturns = exceptions.error("test-runner not initialized - test-begin missing?");
            throw Special.reachedUnexpected;
        }
        return r;
    }

    public static Object testRunnerCreate() {
        return ((Procedure)Scheme.applyToArgs).apply1(test$Mnrunner$Mnfactory.getValue());
    }

    public static Object $PcTestShouldExecute(Object runner) {
        Comparable<Boolean> comparable;
        block10 : {
            block7 : {
                block6 : {
                    block9 : {
                        block8 : {
                            Object run;
                            boolean x2;
                            Object object2 = Promise.force(runner, test-runner.class);
                            try {
                                run = testing.$PcTestRunnerRunList((test-runner)object2);
                            }
                            catch (ClassCastException classCastException) {
                                void x2;
                                throw new WrongType(classCastException, "%test-runner-run-list", 0, (Object)x2);
                            }
                            boolean x3 = IsEqv.apply(run, Boolean.TRUE);
                            boolean bl = (x3 ? x3 : KawaConvert.isTrue(testing.$PcTestAnySpecifierMatches(run, runner))) ? false : (x2 = true);
                            if (!x2) break block8;
                            if (!x2) break block6;
                            break block9;
                        }
                        Object x3 = Promise.force(runner, test-runner.class);
                        try {
                            if (!KawaConvert.isTrue(testing.$PcTestAnySpecifierMatches(testing.$PcTestRunnerSkipList((test-runner)x3), runner))) break block6;
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "%test-runner-skip-list", 0, x3);
                        }
                    }
                    testing.testResultSet$Ex(runner, Lit1, Lit2);
                    comparable = Boolean.FALSE;
                    break block10;
                }
                Object x3 = Promise.force(runner, test-runner.class);
                try {
                    if (!KawaConvert.isTrue(testing.$PcTestAnySpecifierMatches(testing.$PcTestRunnerFailList((test-runner)x3), runner))) break block7;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "%test-runner-fail-list", 0, x3);
                }
                testing.testResultSet$Ex(runner, Lit1, Lit3);
                comparable = Lit3;
                break block10;
            }
            comparable = Boolean.TRUE;
        }
        return comparable;
    }

    static Object $PcTestRunnerRunList(test-runner obj) {
        return obj.run$Mnlist;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object $PcTestAnySpecifierMatches(Object list, Object runner) {
        result = false;
        v0 = list;
        do {
            if (lists.isNull(l = v0)) {
                if (result) {
                    v1 = Boolean.TRUE;
                    return v1;
                }
                v1 = Boolean.FALSE;
                return v1;
            }
            object2 = Promise.force(l, Pair.class);
            if (!KawaConvert.isTrue(testing.$PcTestSpecifierMatches(lists.car((Pair)object2), runner))) ** break block7
            result = true;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "car", 1, object2);
        }
        {
            
            object2 = Promise.force(l, Pair.class);
            v0 = lists.cdr((Pair)object2);
            continue;
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "cdr", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void testResultSet$Ex(Object runner, Object pname, Object value) {
        Object object2;
        Object p;
        Object alist;
        Object object3 = Promise.force(runner, test-runner.class);
        try {
            alist = testing.testResultAlist((test-runner)object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, p);
        }
        p = lists.assq(pname, alist);
        if (KawaConvert.isTrue(p)) {
            object2 = Promise.force(p, Pair.class);
            lists.setCdr$Ex((Pair)object2, value);
            return;
        }
        Object object4 = Promise.force(runner, test-runner.class);
        try {
            testing.testResultAlist$Ex((test-runner)object4, lists.cons(lists.cons(pname, value), alist));
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist!", 0, object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public static void $PcTestBegin(Object suite$Mnname, Object count) {
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

    static Object $PcTestRunnerSkipSave(test-runner obj) {
        return obj.skip$Mnsave;
    }

    static Object $PcTestRunnerFailSave(test-runner obj) {
        return obj.fail$Mnsave;
    }

    static Object $PcTestRunnerTotalCount(test-runner obj) {
        return obj.total$Mncount;
    }

    static Object $PcTestRunnerCountList(test-runner obj) {
        return obj.count$Mnlist;
    }

    public static boolean testOnGroupBeginSimple(Object runner, Object suite$Mnname, Object count) {
        Object log$Mnfile;
        Object log;
        block9 : {
            Object object2 = Promise.force(runner, test-runner.class);
            try {
                if (!lists.isNull(testing.testRunnerGroupStack((test-runner)object2))) break block9;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "test-runner-group-stack", 0, log);
            }
            ports.display("%%%% Starting test ");
            ports.display(suite$Mnname);
            Boolean log$Mnfile$Mnname = strings.isString(Boolean.TRUE) ? Boolean.TRUE : strings.stringAppend(suite$Mnname, ".log");
            Object object3 = Promise.force(log$Mnfile$Mnname, Path.class);
            try {
                log$Mnfile = ports.openOutputFile(Path.valueOf(object3));
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "open-output-file", 1, object3);
            }
            ports.display("%%%% Starting test ", log$Mnfile);
            ports.display(suite$Mnname, log$Mnfile);
            ports.newline(log$Mnfile);
            object3 = Promise.force(runner, test-runner.class);
            try {
                testing.testRunnerAuxValue$Ex((test-runner)object3, log$Mnfile);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "test-runner-aux-value!", 0, object3);
            }
            ports.display("  (Writing full log to \"");
            ports.display(log$Mnfile$Mnname);
            ports.display("\")");
            ports.newline();
        }
        log$Mnfile = Promise.force(runner, test-runner.class);
        try {
            log = testing.testRunnerAuxValue((test-runner)log$Mnfile);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-aux-value", 0, log$Mnfile);
        }
        if (ports.isOutputPort(log)) {
            ports.display("Group begin: ", log);
            ports.display(suite$Mnname, log);
            ports.newline(log);
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean testOnGroupEndSimple(Object runner) {
        Object log;
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            log = testing.testRunnerAuxValue((test-runner)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-aux-value", 0, object2);
        }
        if (!ports.isOutputPort(log)) return false;
        ports.display("Group end: ", log);
        object2 = Promise.force(runner, test-runner.class);
        try {
            object2 = Promise.force(testing.testRunnerGroupStack((test-runner)object2), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-group-stack", 0, object2);
        }
        try {
            ports.display(lists.car((Pair)object2), log);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        ports.newline(log);
        return false;
    }

    public static void testOnBadCountSimple(Object runner, Object count, Object expected$Mncount) {
        Object log;
        testing.$PcTestOnBadCountWrite(runner, count, expected$Mncount, ports.current$Mnoutput$Mnport.getValue());
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            log = testing.testRunnerAuxValue((test-runner)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-aux-value", 0, object2);
        }
        if (ports.isOutputPort(log)) {
            testing.$PcTestOnBadCountWrite(runner, count, expected$Mncount, log);
        }
    }

    static void $PcTestOnBadCountWrite(Object runner, Object count, Object expected$Mncount, Object port) {
        ports.display("*** Total number of tests was ", port);
        ports.display(count, port);
        ports.display(" but should be ", port);
        ports.display(expected$Mncount, port);
        ports.display(". ***", port);
        ports.newline(port);
        ports.display("*** Discrepancy indicates testsuite error or exceptions. ***", port);
        ports.newline(port);
    }

    public static Type.NeverReturns testOnBadEndNameSimple(Object runner, Object begin$Mnname, Object end$Mnname) {
        FString msg = strings.stringAppend(testing.$PcTestFormatLine(runner), "test-end ", begin$Mnname, " does not match test-begin ", end$Mnname);
        Type.NeverReturns neverReturns = exceptions.error(msg);
        throw Special.reachedUnexpected;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static Object $PcTestFormatLine(Object runner) {
        Object line$Mninfo;
        Object object2;
        Object object3;
        Object source$Mnfile;
        String file2;
        Object object4 = Promise.force(runner, test-runner.class);
        try {
            line$Mninfo = testing.testResultAlist((test-runner)object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, source$Mnfile);
        }
        source$Mnfile = lists.assq(Lit4, line$Mninfo);
        Object source$Mnline = lists.assq(Lit5, line$Mninfo);
        if (KawaConvert.isTrue(source$Mnfile)) {
            object3 = Promise.force(source$Mnfile, Pair.class);
            object2 = lists.cdr((Pair)object3);
        }
        object2 = file2 = "";
        if (!KawaConvert.isTrue(source$Mnline)) {
            return "";
        }
        Object[] arrobject = new Object[4];
        arrobject[0] = file2;
        arrobject[1] = ":";
        object3 = Promise.force(source$Mnline, Pair.class);
        try {
            object3 = Promise.force(lists.cdr((Pair)object3), Number.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        try {
            arrobject[2] = numbers.number$To$String((Number)object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "number->string", 1, object3);
        }
        arrobject[3] = ": ";
        CharSequence charSequence = strings.stringAppend(arrobject);
        return charSequence;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    public static void testOnFinalSimple(Object runner) {
        Object log;
        testing.$PcTestFinalReportSimple(runner, ports.current$Mnoutput$Mnport.getValue());
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            log = testing.testRunnerAuxValue((test-runner)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-aux-value", 0, object2);
        }
        if (ports.isOutputPort(log)) {
            testing.$PcTestFinalReportSimple(runner, log);
        }
    }

    static void $PcTestFinalReportSimple(Object runner, Object port) {
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestFinalReport1(testing.testRunnerPassCount((test-runner)object2), "# of expected passes      ", port);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-pass-count", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestFinalReport1(testing.testRunnerXfailCount((test-runner)object2), "# of expected failures    ", port);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-xfail-count", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestFinalReport1(testing.testRunnerXpassCount((test-runner)object2), "# of unexpected successes ", port);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-xpass-count", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestFinalReport1(testing.testRunnerFailCount((test-runner)object2), "# of unexpected failures  ", port);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-fail-count", 0, object2);
        }
        object2 = Promise.force(runner, test-runner.class);
        try {
            testing.$PcTestFinalReport1(testing.testRunnerSkipCount((test-runner)object2), "# of skipped tests        ", port);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-skip-count", 0, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object $PcTestEnd(Object suite$Mnname, Object line$Mninfo) {
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
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static void testOnTestBeginSimple(Object runner) {
        Object results;
        Object source$Mnfile;
        Object log;
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            log = testing.testRunnerAuxValue((test-runner)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-aux-value", 0, results);
        }
        if (!ports.isOutputPort(log)) return;
        Object object3 = Promise.force(runner, test-runner.class);
        try {
            results = testing.testResultAlist((test-runner)object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, source$Mnfile);
        }
        source$Mnfile = lists.assq(Lit4, results);
        Object source$Mnline = lists.assq(Lit5, results);
        Object source$Mnform = lists.assq(Lit6, results);
        Object test$Mnname = lists.assq(Lit7, results);
        ports.display("Test begin:", log);
        ports.newline(log);
        if (KawaConvert.isTrue(test$Mnname)) {
            testing.$PcTestWriteResult1(test$Mnname, log);
        }
        if (KawaConvert.isTrue(source$Mnfile)) {
            testing.$PcTestWriteResult1(source$Mnfile, log);
        }
        if (KawaConvert.isTrue(source$Mnline)) {
            testing.$PcTestWriteResult1(source$Mnline, log);
        }
        if (!KawaConvert.isTrue(source$Mnform)) return;
        testing.$PcTestWriteResult1(source$Mnform, log);
    }

    /*
     * Exception decompiling
     */
    static void $PcTestWriteResult1(Object pair, Object port) {
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
    public static Object testOnTestEndSimple(Object runner) {
        Values values;
        Object results;
        Object list;
        Object p;
        Boolean kind;
        Object source$Mnline;
        Object object3;
        Object pair;
        Object object2;
        Object object4;
        void log;
        Object object42 = Promise.force(runner, test-runner.class);
        try {
            Object object5 = testing.testRunnerAuxValue((test-runner)object42);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-aux-value", 0, (Object)kind);
        }
        Object object6 = Promise.force(runner, test-runner.class);
        try {
            p = lists.assq(Lit1, testing.testResultAlist((test-runner)object6));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, pair);
        }
        if (KawaConvert.isTrue(p)) {
            object6 = Promise.force(p, Pair.class);
            object2 = lists.cdr((Pair)object6);
        }
        object2 = kind = Boolean.FALSE;
        if (KawaConvert.isTrue(lists.memq(kind, Lit8))) {
            object6 = Promise.force(runner, test-runner.class);
            results = testing.testResultAlist((test-runner)object6);
            Object source$Mnfile = lists.assq(Lit4, results);
            source$Mnline = lists.assq(Lit5, results);
            Object test$Mnname = lists.assq(Lit7, results);
            if (KawaConvert.isTrue(source$Mnfile) ? KawaConvert.isTrue(source$Mnfile) : KawaConvert.isTrue(source$Mnline)) {
                if (KawaConvert.isTrue(source$Mnfile)) {
                    object3 = Promise.force(source$Mnfile, Pair.class);
                    ports.display(lists.cdr((Pair)object3));
                }
                ports.display(":");
                if (KawaConvert.isTrue(source$Mnline)) {
                    object3 = Promise.force(source$Mnline, Pair.class);
                    ports.display(lists.cdr((Pair)object3));
                }
                ports.display(": ");
            }
            ports.display(kind == Lit9 ? "XPASS" : "FAIL");
            if (KawaConvert.isTrue(test$Mnname)) {
                ports.display(" ");
                object3 = Promise.force(test$Mnname, Pair.class);
                ports.display(lists.cdr((Pair)object3));
            }
            ports.newline();
        }
        if (!ports.isOutputPort(log)) {
            values = Values.empty;
            return values;
        }
        ports.display("Test end:", log);
        ports.newline(log);
        results = Promise.force(runner, test-runner.class);
        try {
            object4 = testing.testResultAlist((test-runner)results);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, list);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, pair);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, pair);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        do {
            if (!lists.isPair(list = object4)) {
                values = Values.empty;
                return values;
            }
            source$Mnline = Promise.force(list, Pair.class);
            pair = lists.car((Pair)source$Mnline);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, source$Mnline);
        }
        {
            block31 : {
                source$Mnline = Promise.force(pair, Pair.class);
                if (KawaConvert.isTrue(lists.memq(lists.car((Pair)source$Mnline), Lit10))) break block31;
                testing.$PcTestWriteResult1(pair, log);
            }
            source$Mnline = Promise.force(list, Pair.class);
            object4 = lists.cdr((Pair)source$Mnline);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, source$Mnline);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, source$Mnline);
        }
    }

    public static void testResultClear(Object runner) {
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testResultAlist$Ex((test-runner)object2, LList.Empty);
            return;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist!", 0, object2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void testResultRemove(Object runner, Object pname) {
        Object p;
        Object alist;
        Object object3 = Promise.force(runner, test-runner.class);
        try {
            alist = testing.testResultAlist((test-runner)object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, p);
        }
        p = lists.assq(pname, alist);
        if (!KawaConvert.isTrue(p)) return;
        Object object2 = Promise.force(runner, test-runner.class);
        try {
            testing.testResultAlist$Ex((test-runner)object2, testing.lambda4loop(p, alist));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist!", 0, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object lambda4loop(Object p, Object r) {
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
    public static Object testResultKind$V(Object[] argsArray) {
        Object p;
        Object object2;
        Object object3;
        LList lList = LList.makeList(argsArray, 0);
        LList rest = lList;
        if (lists.isPair(rest)) {
            LList lList2 = rest;
            object2 = lists.car((Pair)lList2);
        }
        object2 = test$Mnrunner$Mncurrent.getValue();
        Object runner = object2;
        Object object4 = Promise.force(runner, test-runner.class);
        try {
            p = lists.assq(Lit1, testing.testResultAlist((test-runner)object4));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, object4);
        }
        if (!KawaConvert.isTrue(p)) {
            object3 = Boolean.FALSE;
            return object3;
        }
        object4 = Promise.force(p, Pair.class);
        try {
            object3 = lists.cdr((Pair)object4);
            return object3;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, p);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object isTestPassed$V(Object[] argsArray) {
        Object p;
        Object object2;
        Object object3;
        LList lList = LList.makeList(argsArray, 0);
        LList rest = lList;
        if (lists.isPair(rest)) {
            LList lList2 = rest;
            object2 = lists.car((Pair)lList2);
        }
        object2 = testing.testRunnerGet();
        Object runner = object2;
        Object object4 = Promise.force(runner, test-runner.class);
        try {
            p = lists.assq(Lit1, testing.testResultAlist((test-runner)object4));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, object4);
        }
        if (!KawaConvert.isTrue(p)) {
            object3 = Boolean.FALSE;
            return lists.memq(object3, Lit11);
        }
        object4 = Promise.force(p, Pair.class);
        try {
            object3 = lists.cdr((Pair)object4);
            return lists.memq(object3, Lit11);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, p);
        }
    }

    /*
     * Exception decompiling
     */
    public static Object $PcTestReportResult() {
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
    public static boolean $PcTestOnTestBegin(Object r) {
        Object p;
        Object object2;
        testing.$PcTestShouldExecute(r);
        Object object3 = Promise.force(r, test-runner.class);
        try {
            ((Procedure)Scheme.applyToArgs).apply2(testing.testRunnerOnTestBegin((test-runner)object3), r);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-test-begin", 0, p);
        }
        Object object4 = Promise.force(r, test-runner.class);
        try {
            p = lists.assq(Lit1, testing.testResultAlist((test-runner)object4));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, object4);
        }
        if (KawaConvert.isTrue(p)) {
            object4 = Promise.force(p, Pair.class);
            object2 = lists.cdr((Pair)object4);
        } else {
            object2 = Boolean.FALSE;
        }
        if (Lit2 != object2) return true;
        return false;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object4);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static void $PcTestOnTestEnd(Object r, Object result) {
        Object object2;
        Object p;
        Object object3 = Promise.force(r, test-runner.class);
        try {
            p = lists.assq(Lit1, testing.testResultAlist((test-runner)object3));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, object3);
        }
        if (KawaConvert.isTrue(p)) {
            object3 = Promise.force(p, Pair.class);
            object2 = lists.cdr((Pair)object3);
        } else {
            object2 = Boolean.FALSE;
        }
        testing.testResultSet$Ex(r, Lit1, object2 == Lit3 ? (KawaConvert.isTrue(result) ? Lit9 : Lit3) : (KawaConvert.isTrue(result) ? Lit14 : Lit12));
        return;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Object testRunnerTestName(Object runner) {
        Object p;
        Object object2;
        Object object3 = Promise.force(runner, test-runner.class);
        try {
            p = lists.assq(Lit7, testing.testResultAlist((test-runner)object3));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 0, object3);
        }
        if (!KawaConvert.isTrue(p)) return "";
        object3 = Promise.force(p, Pair.class);
        try {
            object2 = lists.cdr((Pair)object3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        return object2;
    }

    public static Procedure $PcTestApproximate$Eq(Object error) {
        public class Frame
        extends ModuleBody {
            Object error;
            final ModuleMethod lambda$Fn4;

            public Frame() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 1, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:667");
                this.lambda$Fn4 = moduleMethod;
            }

            boolean lambda5(Object value, Object expected) {
                void ival;
                void rval;
                Number iexp;
                void rexp;
                Object object2 = Promise.force(value, Number.class);
                try {
                    Number number = numbers.realPart((Number)object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "real-part", 1, (Object)ival);
                }
                Object object3 = Promise.force(value, Number.class);
                try {
                    object2 = numbers.imagPart((Number)object3);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "imag-part", 1, (Object)rexp);
                }
                Object object4 = Promise.force(expected, Number.class);
                try {
                    object3 = numbers.realPart((Number)object4);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "real-part", 1, (Object)iexp);
                }
                Object object5 = Promise.force(expected, Number.class);
                try {
                    iexp = numbers.imagPart((Number)object5);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "imag-part", 1, object5);
                }
                return NumberCompare.$Gr$Eq(rval, AddOp.apply2(-1, rexp, this.error)) ? (NumberCompare.$Gr$Eq(ival, AddOp.apply2(-1, iexp, this.error)) ? (NumberCompare.$Ls$Eq(rval, AddOp.apply2(1, rexp, this.error)) ? NumberCompare.$Ls$Eq(ival, AddOp.apply2(1, iexp, this.error)) : false) : false) : false;
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                if (moduleMethod.selector == 1) {
                    callContext.value1 = object2;
                    callContext.value2 = object3;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                }
                return super.match2(moduleMethod, object2, object3, callContext);
            }

            public void apply(CallContext callContext) {
                ModuleMethod.applyError();
            }

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                if (moduleMethod.selector == 1) {
                    return this.lambda5(object2, object3) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.error = error;
        return $heapFrame.lambda$Fn4;
    }

    /*
     * Exception decompiling
     */
    public static Object testApply$V(Object first, Object[] argsArray) {
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

    public static Procedure $PcTestMatchNth(Object n, Object count) {
        public class Frame1
        extends ModuleBody {
            Object count;
            Object n;
            IntNum i;
            final ModuleMethod lambda$Fn11;

            public Frame1() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 8, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:956");
                this.lambda$Fn11 = moduleMethod;
            }

            boolean lambda12(Object runner) {
                this.i = IntNum.add(this.i, 1);
                return NumberCompare.$Gr$Eq(this.i, this.n) ? NumberCompare.$Ls(this.i, AddOp.apply2(1, this.n, this.count)) : false;
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 8) {
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
                if (moduleMethod.selector == 8) {
                    return this.lambda12(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame1 $heapFrame = new Frame1();
        $heapFrame.n = n;
        $heapFrame.count = count;
        $heapFrame.i = Lit0;
        return $heapFrame.lambda$Fn11;
    }

    public static Procedure $PcTestMatchAll$V(Object[] argsArray) {
        LList lList;
        public class Frame2
        extends ModuleBody {
            LList pred$Mnlist;
            final ModuleMethod lambda$Fn12;

            public Frame2() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 9, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:968");
                this.lambda$Fn12 = moduleMethod;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            Object lambda13(Object runner) {
                result = true;
                v0 = this.pred$Mnlist;
                do {
                    if (lists.isNull(l = v0)) {
                        if (result) {
                            v1 = Boolean.TRUE;
                            return v1;
                        }
                        v1 = Boolean.FALSE;
                        return v1;
                    }
                    object2 = Promise.force(l, Pair.class);
                    if (KawaConvert.isTrue(Scheme.applyToArgs.apply2(lists.car((Pair)object2), runner))) ** break block7
                    result = false;
                    break;
                } while (true);
                catch (ClassCastException v2) {
                    throw new WrongType(v2, "car", 1, object2);
                }
                {
                    
                    object2 = Promise.force(l, Pair.class);
                    v0 = lists.cdr((Pair)object2);
                    continue;
                }
                catch (ClassCastException v3) {
                    throw new WrongType(v3, "cdr", 1, object2);
                }
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 9) {
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
                if (moduleMethod.selector == 9) {
                    return this.lambda13(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame2 $heapFrame = new Frame2();
        $heapFrame.pred$Mnlist = lList = LList.makeList(argsArray, 0);
        return $heapFrame.lambda$Fn12;
    }

    public static Procedure $PcTestMatchAny$V(Object[] argsArray) {
        LList lList;
        public class Frame3
        extends ModuleBody {
            LList pred$Mnlist;
            final ModuleMethod lambda$Fn13;

            public Frame3() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 10, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:984");
                this.lambda$Fn13 = moduleMethod;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            Object lambda14(Object runner) {
                result = false;
                v0 = this.pred$Mnlist;
                do {
                    if (lists.isNull(l = v0)) {
                        if (result) {
                            v1 = Boolean.TRUE;
                            return v1;
                        }
                        v1 = Boolean.FALSE;
                        return v1;
                    }
                    object2 = Promise.force(l, Pair.class);
                    if (!KawaConvert.isTrue(Scheme.applyToArgs.apply2(lists.car((Pair)object2), runner))) ** break block7
                    result = true;
                    break;
                } while (true);
                catch (ClassCastException v2) {
                    throw new WrongType(v2, "car", 1, object2);
                }
                {
                    
                    object2 = Promise.force(l, Pair.class);
                    v0 = lists.cdr((Pair)object2);
                    continue;
                }
                catch (ClassCastException v3) {
                    throw new WrongType(v3, "cdr", 1, object2);
                }
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 10) {
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
                if (moduleMethod.selector == 10) {
                    return this.lambda14(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame3 $heapFrame = new Frame3();
        $heapFrame.pred$Mnlist = lList = LList.makeList(argsArray, 0);
        return $heapFrame.lambda$Fn13;
    }

    public static Object $PcTestAsSpecifier(Object specifier) {
        Object object2;
        if (misc.isProcedure(specifier)) {
            object2 = specifier;
        } else if (numbers.isInteger(specifier)) {
            object2 = testing.$PcTestMatchNth(Lit13, specifier);
        } else if (strings.isString(specifier)) {
            object2 = testing.testMatchName(specifier);
        } else {
            Type.NeverReturns neverReturns = exceptions.error("not a valid test specifier");
            throw Special.reachedUnexpected;
        }
        return object2;
    }

    public static Procedure testMatchName(Object name) {
        public class Frame4
        extends ModuleBody {
            Object name;
            final ModuleMethod lambda$Fn14;

            public Frame4() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 11, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:1024");
                this.lambda$Fn14 = moduleMethod;
            }

            Object lambda15(Object runner) {
                return ((Procedure)Scheme.isEqual).apply2(this.name, testing.testRunnerTestName(runner));
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 11) {
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
                if (moduleMethod.selector == 11) {
                    return this.lambda15(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame4 $heapFrame = new Frame4();
        $heapFrame.name = name;
        return $heapFrame.lambda$Fn14;
    }

    public static Object testReadEvalString(Object string) {
        CallContext $ctx;
        int n;
        CharArrayInPort port;
        Object form;
        Object object2 = Promise.force(string, CharSequence.class);
        try {
            port = ports.openInputString((CharSequence)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "open-input-string", 1, form);
        }
        form = ports.read(port);
        if (ports.readChar(port) == -1) {
            $ctx = CallContext.getInstance();
            n = $ctx.startFromContext();
            try {
                eval.eval$X(form, $ctx);
            }
            catch (Throwable throwable) {
                $ctx.cleanupFromContext(n);
                throw throwable;
            }
        } else {
            Type.NeverReturns neverReturns = exceptions.error("(not at eof)");
            throw Special.reachedUnexpected;
        }
        return $ctx.getFromContext(n);
    }

    static Object $PcTestSpecifierMatches(Object spec, Object runner) {
        return ((Procedure)Scheme.applyToArgs).apply2(spec, runner);
    }

    static void $PcTestFinalReport1(Object value, Object label, Object port) {
        if (NumberCompare.$Gr(value, Lit0)) {
            ports.display(label, port);
            ports.display(value, port);
            ports.newline(port);
        }
    }

    static Object $PcTestSyntaxFile(Object form) {
        return std_syntax.syntaxSource(form);
    }

    static Pair $PcTestSourceLine2(Object form) {
        Object line = std_syntax.syntaxLine(form);
        Object file2 = testing.$PcTestSyntaxFile(form);
        EmptyList line$Mnpair = KawaConvert.isTrue(line) ? LList.list1(lists.cons(Lit5, line)) : LList.Empty;
        return lists.cons(lists.cons(Lit6, std_syntax.syntaxObject$To$Datum(form)), KawaConvert.isTrue(file2) ? lists.cons(lists.cons(Lit4, file2), line$Mnpair) : line$Mnpair);
    }

    static Object $PcTestComp2(Object comp, Object x) {
        Object object2;
        Object[] arrobject = TemplateScope.make();
        Pair pair = LList.list3(x, LList.list2(Lit15.execute(null, (TemplateScope)arrobject), testing.$PcTestSourceLine2(x)), comp);
        arrobject = SyntaxPattern.allocVars(6, null);
        if (((Pattern)Lit16).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit17.execute(arrobject, templateScope);
        } else if (((Pattern)Lit18).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit19.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", pair);
        }
        return object2;
    }

    public static {
        Lit9 = Symbol.valueOf("xpass");
        Lit189 = PairWithPosition.make(Lit9, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2248760);
        Lit155 = Symbol.valueOf("test-runner-current");
        Lit185 = PairWithPosition.make(Lit155, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3874842);
        Lit188 = PairWithPosition.make(Lit185, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3874842);
        Lit187 = Symbol.valueOf("dynamic-wind");
        Lit186 = Symbol.valueOf("p");
        Lit163 = Symbol.valueOf("quote");
        Lit169 = PairWithPosition.make(Lit163, PairWithPosition.make(Symbol.valueOf("actual-value"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3432478), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3432478);
        Lit181 = Symbol.valueOf("res");
        Lit182 = PairWithPosition.make(Lit181, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2801707);
        Lit184 = PairWithPosition.make(Lit169, Lit182, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2801693);
        Lit183 = Symbol.valueOf("exp");
        Lit180 = Symbol.valueOf("if");
        Object[] arrobject = new Object[1];
        Lit179 = arrobject;
        arrobject[0] = Lit163;
        Lit7 = Symbol.valueOf("test-name");
        Lit178 = PairWithPosition.make(Lit163, PairWithPosition.make(Lit7, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3670057), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3670057);
        Lit177 = Symbol.valueOf("name");
        Lit85 = Symbol.valueOf("%test-report-result");
        Lit176 = PairWithPosition.make(PairWithPosition.make(Lit85, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3452936), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3452936);
        Lit167 = Symbol.valueOf("et");
        Lit175 = PairWithPosition.make(Lit167, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3469355);
        Lit174 = Symbol.valueOf("instance?");
        Lit173 = Symbol.valueOf("cond");
        Lit164 = Symbol.valueOf("ex");
        Lit172 = PairWithPosition.make(PairWithPosition.make(Lit163, PairWithPosition.make(Symbol.valueOf("actual-error"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3444768), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3444768), PairWithPosition.make(Lit164, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3444781), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3444767);
        Lit171 = Symbol.valueOf("<java.lang.Throwable>");
        Lit170 = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3436553);
        Lit168 = Symbol.valueOf("try-catch");
        Lit166 = PairWithPosition.make(Lit163, PairWithPosition.make(Symbol.valueOf("expected-error"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3416093), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3416093);
        Lit165 = PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3416108);
        Lit159 = Symbol.valueOf("r");
        Lit60 = Symbol.valueOf("test-runner-get");
        Lit158 = PairWithPosition.make(PairWithPosition.make(Lit60, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4169748), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4169748);
        Lit162 = PairWithPosition.make(Lit159, Lit158, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3706891);
        Lit161 = PairWithPosition.make(Lit162, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3706890);
        Lit160 = Symbol.valueOf("let*");
        Lit157 = Symbol.valueOf("saved-runner");
        Lit156 = Symbol.valueOf("lambda");
        Lit150 = Symbol.valueOf("runner");
        Lit154 = PairWithPosition.make(Lit150, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4182046);
        Lit153 = Symbol.valueOf("cons");
        Lit152 = PairWithPosition.make(PairWithPosition.make(Lit150, Lit158, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4169740), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4169739);
        Lit151 = Symbol.valueOf("let");
        Lit149 = new Object[0];
        Lit148 = Symbol.valueOf("test-read-eval-string");
        Lit147 = Symbol.valueOf("test-match-name");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject2 = new Object[8];
        arrobject2[0] = Lit151;
        arrobject2[1] = Lit152;
        Lit34 = Symbol.valueOf("%test-runner-fail-list!");
        arrobject2[2] = Lit34;
        arrobject2[3] = Lit150;
        arrobject2[4] = Lit153;
        Lit137 = Symbol.valueOf("test-match-all");
        arrobject2[5] = Lit137;
        Lit142 = Symbol.valueOf("%test-as-specifier");
        arrobject2[6] = Lit142;
        Lit33 = Symbol.valueOf("%test-runner-fail-list");
        arrobject2[7] = PairWithPosition.make(PairWithPosition.make(Lit33, Lit154, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4182022), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4182022);
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", Lit149, 1, "testing.scm:1017"), "\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$Q\u0011\u0018,\b\u0005\u0011\u00184\b\u0003\u0018<", arrobject2, 1);
        Lit145 = Symbol.valueOf("test-expect-fail");
        Lit146 = new SyntaxRules(Lit149, arrsyntaxRule, 1, Lit145);
        SyntaxRule[] arrsyntaxRule2 = new SyntaxRule[1];
        Object[] arrobject3 = new Object[8];
        arrobject3[0] = Lit151;
        arrobject3[1] = Lit152;
        Lit32 = Symbol.valueOf("%test-runner-skip-list!");
        arrobject3[2] = Lit32;
        arrobject3[3] = Lit150;
        arrobject3[4] = Lit153;
        arrobject3[5] = Lit137;
        arrobject3[6] = Lit142;
        Lit31 = Symbol.valueOf("%test-runner-skip-list");
        arrobject3[7] = PairWithPosition.make(PairWithPosition.make(Lit31, Lit154, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4149254), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4149254);
        arrsyntaxRule2[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", Lit149, 1, "testing.scm:1009"), "\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$Q\u0011\u0018,\b\u0005\u0011\u00184\b\u0003\u0018<", arrobject3, 1);
        Lit143 = Symbol.valueOf("test-skip");
        Lit144 = new SyntaxRules(Lit149, arrsyntaxRule2, 1, Lit143);
        SyntaxRule[] arrsyntaxRule3 = new SyntaxRule[1];
        Object[] arrobject4 = new Object[2];
        Lit139 = Symbol.valueOf("%test-match-any");
        arrobject4[0] = Lit139;
        arrobject4[1] = Lit142;
        arrsyntaxRule3[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", Lit149, 1, "testing.scm:996"), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\b\u0003", arrobject4, 1);
        Lit140 = Symbol.valueOf("test-match-any");
        Lit141 = new SyntaxRules(Lit149, arrsyntaxRule3, 1, Lit140);
        SyntaxRule[] arrsyntaxRule4 = new SyntaxRule[1];
        Object[] arrobject5 = new Object[2];
        Lit136 = Symbol.valueOf("%test-match-all");
        arrobject5[0] = Lit136;
        arrobject5[1] = Lit142;
        arrsyntaxRule4[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", Lit149, 1, "testing.scm:980"), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\b\u0003", arrobject5, 1);
        Lit138 = new SyntaxRules(Lit149, arrsyntaxRule4, 1, Lit137);
        SyntaxRule[] arrsyntaxRule5 = new SyntaxRule[2];
        Object[] arrobject6 = new Object[2];
        Lit134 = Symbol.valueOf("test-match-nth");
        arrobject6[0] = Lit134;
        Lit13 = IntNum.valueOf(1);
        arrobject6[1] = PairWithPosition.make(Lit13, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3944472);
        arrsyntaxRule5[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit149, 1, "testing.scm:962"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", arrobject6, 0);
        Object[] arrobject7 = new Object[1];
        Lit133 = Symbol.valueOf("%test-match-nth");
        arrobject7[0] = Lit133;
        arrsyntaxRule5[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit149, 2, "testing.scm:964"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", arrobject7, 0);
        Lit135 = new SyntaxRules(Lit149, arrsyntaxRule5, 2, Lit134);
        Lit131 = Symbol.valueOf("test-with-runner");
        Lit132 = new SyntaxRules(Lit149, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", Lit149, 2, "testing.scm:945"), "\u0001\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014Y\u0011\u0018\u001c\t\u0010\b\u0011\u0018$\b\u0003A\u0011\u0018\u001c\t\u0010\b\r\u000b\u0018,", new Object[]{Lit151, PairWithPosition.make(PairWithPosition.make(Lit157, Lit188, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3874828), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3874827), Lit187, Lit156, Lit155, PairWithPosition.make(PairWithPosition.make(Lit156, PairWithPosition.make(LList.Empty, PairWithPosition.make(PairWithPosition.make(Lit155, PairWithPosition.make(Lit157, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891244), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891223), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891223), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891220), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891212), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891212)}, 1)}, 2, Lit131);
        Lit130 = Symbol.valueOf("test-apply");
        Object[] arrobject8 = new Object[6];
        arrobject8[0] = Lit160;
        arrobject8[1] = Lit161;
        Lit52 = Symbol.valueOf("test-result-alist!");
        arrobject8[2] = Lit52;
        arrobject8[3] = Lit159;
        Lit120 = Symbol.valueOf("%test-error");
        arrobject8[4] = Lit120;
        arrobject8[5] = Boolean.TRUE;
        Lit129 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b\u0013\b\u0011\u0018$\u0011\u0018\u001c\t,\b\u000b", arrobject8, 0);
        Lit128 = new SyntaxPattern(",\f\u0007\f\u000f\b\f\u0017\b", Lit149, 3, "testing.scm:903");
        Lit127 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b\u001b\b\u0011\u0018$\u0011\u0018\u001c\t\u000b\b\u0013", new Object[]{Lit160, Lit161, Lit52, Lit159, Lit120}, 0);
        Lit126 = new SyntaxPattern("<\f\u0007\f\u000f\f\u0017\b\f\u001f\b", Lit149, 4, "testing.scm:898");
        Lit125 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004I\u0011\u0018\f\b\u0011\u0018\u0014\b\u000b\u00a9\u0011\u0018\u001c\u0011\u0018$\b\u0011\u0018,A\u0011\u0018,\u0011\u00184\b\u000b\b#\b\u0011\u0018<\u0011\u0018$\t\u0013\b\u001b", new Object[]{Lit160, Lit162, Lit177, Lit52, Lit159, Lit153, Lit178, Lit120}, 0);
        Lit124 = new SyntaxPattern("L\f\u0007\f\u000f\f\u0017\f\u001f\b\f'\b", Lit149, 5, "testing.scm:892");
        Lit123 = new SyntaxTemplate("", "\u0018\u0004", Lit179, 0);
        Lit122 = Symbol.valueOf("test-error");
        SyntaxRule[] arrsyntaxRule6 = new SyntaxRule[2];
        Object[] arrobject9 = new Object[14];
        arrobject9[0] = Lit173;
        Lit88 = Symbol.valueOf("%test-on-test-begin");
        arrobject9[1] = Lit88;
        Lit80 = Symbol.valueOf("test-result-set!");
        arrobject9[2] = Lit80;
        arrobject9[3] = PairWithPosition.make(Lit166, Lit165, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3416092);
        Lit89 = Symbol.valueOf("%test-on-test-end");
        arrobject9[4] = Lit89;
        arrobject9[5] = Lit168;
        arrobject9[6] = Lit151;
        arrobject9[7] = Lit169;
        arrobject9[8] = Lit170;
        arrobject9[9] = Lit164;
        arrobject9[10] = Lit171;
        arrobject9[11] = Lit172;
        arrobject9[12] = Lit165;
        arrobject9[13] = Lit176;
        arrsyntaxRule6[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", new Object[]{Boolean.TRUE}, 2, "testing.scm:832"), "\u0001\u0001", "\u0011\u0018\u0004\b)\u0011\u0018\f\b\u00039\u0011\u0018\u0014\t\u0003\u0018\u001c\u0169\u0011\u0018$\t\u0003\b\u0011\u0018,\u0091\u0011\u00184\t\u0010Q\u0011\u0018\u0014\t\u0003\u0011\u0018<\b\u000b\u0018D\b\u0011\u0018L\u0011\u0018T9\u0011\u0018\u0014\t\u0003\u0018\\\u0018d\u0018l", arrobject9, 0);
        arrsyntaxRule6[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit149, 3, "testing.scm:844"), "\u0001\u0001\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u00141\b\u0011\u0018\u001c\b\u000b9\u0011\u0018$\t\u0003\u0018,\u0169\u0011\u00184\t\u0003\b\u0011\u0018<\u0091\u0011\u0018\u0014\t\u0010Q\u0011\u0018$\t\u0003\u0011\u0018D\b\u0013\u0018L\b\u0011\u0018T\u0011\u0018\\9\u0011\u0018$\t\u0003\u0018d\u0018l\u0018t", new Object[]{Lit180, Lit88, Lit151, Lit167, Lit80, PairWithPosition.make(Lit166, Lit175, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3469339), Lit89, Lit168, Lit169, Lit170, Lit164, Lit171, Lit172, PairWithPosition.make(PairWithPosition.make(Lit173, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("and"), PairWithPosition.make(PairWithPosition.make(Lit174, PairWithPosition.make(Lit167, PairWithPosition.make(Symbol.valueOf("<gnu.bytecode.ClassType>"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502116), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502113), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502102), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Symbol.valueOf("gnu.bytecode.ClassType"), Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf("isSubclass"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506185), PairWithPosition.make(Lit167, PairWithPosition.make(Lit171, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506222), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506219), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506184), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506184), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502102), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502097), PairWithPosition.make(PairWithPosition.make(Lit174, PairWithPosition.make(Lit164, Lit175, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3510293), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3510282), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3510282), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502096), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("else"), Lit165, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3514377), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3514377), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502096), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502090), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502090), Lit176}, 0);
        Lit121 = new SyntaxRules(Lit149, arrsyntaxRule6, 3, Lit120);
        Object[] arrobject10 = new Object[6];
        arrobject10[0] = Lit160;
        arrobject10[1] = Lit161;
        arrobject10[2] = Lit52;
        arrobject10[3] = Lit159;
        Lit91 = Symbol.valueOf("%test-comp2body");
        arrobject10[4] = Lit91;
        Lit93 = Symbol.valueOf("%test-approximate=");
        arrobject10[5] = Lit93;
        Lit119 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b#\b\u0011\u0018$\u0011\u0018\u001c)\u0011\u0018,\b\u001b\t\u000b\b\u0013", arrobject10, 0);
        Lit118 = new SyntaxPattern("L\f\u0007\f\u000f\f\u0017\f\u001f\b\f'\b", Lit149, 5, "testing.scm:743");
        Lit117 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004I\u0011\u0018\f\b\u0011\u0018\u0014\b\u000b\u00a9\u0011\u0018\u001c\u0011\u0018$\b\u0011\u0018,A\u0011\u0018,\u0011\u00184\b\u000b\b+\b\u0011\u0018<\u0011\u0018$)\u0011\u0018D\b#\t\u0013\b\u001b", new Object[]{Lit160, Lit162, Lit177, Lit52, Lit159, Lit153, Lit178, Lit91, Lit93}, 0);
        Lit116 = new SyntaxPattern("\\\f\u0007\f\u000f\f\u0017\f\u001f\f'\b\f/\b", Lit149, 6, "testing.scm:737");
        Lit115 = new SyntaxTemplate("", "\u0018\u0004", Lit179, 0);
        Lit114 = Symbol.valueOf("test-approximate");
        Lit113 = new SyntaxTemplate("", "\u0018\u0004", new Object[]{Symbol.valueOf("equal?")}, 0);
        Lit112 = Symbol.valueOf("test-equal");
        Lit111 = new SyntaxTemplate("", "\u0018\u0004", new Object[]{Symbol.valueOf("eq?")}, 0);
        Lit110 = Symbol.valueOf("test-eq");
        Lit109 = new SyntaxTemplate("", "\u0018\u0004", new Object[]{Symbol.valueOf("eqv?")}, 0);
        Lit108 = Symbol.valueOf("test-eqv");
        Object[] arrobject11 = new Object[5];
        arrobject11[0] = Lit160;
        arrobject11[1] = Lit161;
        arrobject11[2] = Lit52;
        arrobject11[3] = Lit159;
        Lit94 = Symbol.valueOf("%test-comp1body");
        arrobject11[4] = Lit94;
        Lit107 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b\u0013\b\u0011\u0018$\u0011\u0018\u001c\b\u000b", arrobject11, 0);
        Lit106 = new SyntaxPattern(",\f\u0007\f\u000f\b\f\u0017\b", Lit149, 3, "testing.scm:710");
        Lit105 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004I\u0011\u0018\f\b\u0011\u0018\u0014\b\u000b\u00a9\u0011\u0018\u001c\u0011\u0018$\b\u0011\u0018,A\u0011\u0018,\u0011\u00184\b\u000b\b\u001b\b\u0011\u0018<\u0011\u0018$\b\u0013", new Object[]{Lit160, Lit162, Lit177, Lit52, Lit159, Lit153, Lit178, Lit94}, 0);
        Lit104 = new SyntaxPattern("<\f\u0007\f\u000f\f\u0017\b\f\u001f\b", Lit149, 4, "testing.scm:704");
        Lit103 = new SyntaxTemplate("", "\u0018\u0004", Lit179, 0);
        Lit102 = Symbol.valueOf("test-assert");
        Object[] arrobject12 = new Object[2];
        Lit71 = Symbol.valueOf("%test-end");
        arrobject12[0] = Lit71;
        arrobject12[1] = Boolean.FALSE;
        Lit101 = new SyntaxTemplate("\u0001\u0001", "\u0011\u0018\u0004\t\f\b\u000b", arrobject12, 0);
        Lit100 = new SyntaxPattern("\u001c\f\u0007\b\f\u000f\b", Lit149, 2, "testing.scm:698");
        Lit99 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u000b\b\u0013", new Object[]{Lit71}, 0);
        Lit98 = new SyntaxPattern(",\f\u0007\f\u000f\b\f\u0017\b", Lit149, 3, "testing.scm:695");
        Lit97 = new SyntaxTemplate("", "\u0018\u0004", Lit179, 0);
        Lit96 = Symbol.valueOf("test-end");
        SyntaxRule[] arrsyntaxRule7 = new SyntaxRule[1];
        Object[] arrobject13 = new Object[10];
        arrobject13[0] = Lit151;
        arrobject13[1] = Lit180;
        arrobject13[2] = Lit88;
        arrobject13[3] = Lit181;
        Lit86 = Symbol.valueOf("%test-evaluate-with-catch");
        arrobject13[4] = Lit86;
        arrobject13[5] = Lit80;
        arrobject13[6] = Lit184;
        arrobject13[7] = Lit89;
        arrobject13[8] = Lit182;
        arrobject13[9] = Lit176;
        arrsyntaxRule7[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit149, 2, "testing.scm:679"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0010\u0171\u0011\u0018\f)\u0011\u0018\u0014\b\u0003\b\u0011\u0018\u0004\t\u0010\b\u0011\u0018\u0004Q\b\u0011\u0018\u001c\b\u0011\u0018$\b\u000b9\u0011\u0018,\t\u0003\u00184\b\u0011\u0018<\t\u0003\u0018D\u0018L", arrobject13, 0);
        Lit95 = new SyntaxRules(Lit149, arrsyntaxRule7, 2, Lit94);
        Lit92 = new SyntaxRules(Lit149, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\b", Lit149, 4, "testing.scm:656"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0010\u01f1\u0011\u0018\f)\u0011\u0018\u0014\b\u0003\b\u0011\u0018\u00041\b\u0011\u0018\u001c\b\u00139\u0011\u0018$\t\u0003\u0018,\b\u0011\u0018\u0004Q\b\u0011\u00184\b\u0011\u0018<\b\u001b9\u0011\u0018$\t\u0003\u0018D\b\u0011\u0018L\t\u0003\b\t\u000b\u0018T\u0018\\", new Object[]{Lit151, Lit180, Lit88, Lit183, Lit80, PairWithPosition.make(PairWithPosition.make(Lit163, PairWithPosition.make(Symbol.valueOf("expected-value"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2703386), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2703386), PairWithPosition.make(Lit183, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2703401), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2703385), Lit181, Lit86, Lit184, Lit89, PairWithPosition.make(Lit183, Lit182, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2715682), Lit176}, 0)}, 4, Lit91);
        Lit90 = Symbol.valueOf("test-runner-test-name");
        Lit87 = new SyntaxRules(Lit149, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit149, 1, "testing.scm:582"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", new Object[]{Lit168, PairWithPosition.make(PairWithPosition.make(Lit164, PairWithPosition.make(Lit171, PairWithPosition.make(PairWithPosition.make(Lit80, PairWithPosition.make(Lit185, Lit172, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2396187), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2396169), Lit170, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2396169), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2392073), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2392069), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2392069)}, 0)}, 1, Lit86);
        Lit84 = Symbol.valueOf("test-passed?");
        Lit83 = Symbol.valueOf("test-result-kind");
        Lit82 = Symbol.valueOf("test-result-remove");
        Lit81 = Symbol.valueOf("test-result-clear");
        Lit79 = Symbol.valueOf("test-on-test-end-simple");
        SyntaxRule[] arrsyntaxRule8 = new SyntaxRule[2];
        Object[] arrobject14 = new Object[2];
        Lit77 = Symbol.valueOf("test-result-ref");
        arrobject14[0] = Lit77;
        arrobject14[1] = Lit170;
        arrsyntaxRule8[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit149, 2, "testing.scm:478"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\u0018\f", arrobject14, 0);
        Object[] arrobject15 = new Object[6];
        arrobject15[0] = Lit151;
        arrobject15[1] = Lit186;
        arrobject15[2] = Symbol.valueOf("assq");
        Lit51 = Symbol.valueOf("test-result-alist");
        arrobject15[3] = Lit51;
        arrobject15[4] = Lit180;
        arrobject15[5] = PairWithPosition.make(Symbol.valueOf("cdr"), PairWithPosition.make(Lit186, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1974291), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1974286);
        arrsyntaxRule8[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit149, 3, "testing.scm:480"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0081\b\u0011\u0018\f\b\u0011\u0018\u0014\t\u000b\b\u0011\u0018\u001c\b\u0003\b\u0011\u0018$\u0011\u0018\f\u0011\u0018,\b\u0013", arrobject15, 0);
        Lit78 = new SyntaxRules(Lit149, arrsyntaxRule8, 3, Lit77);
        Lit76 = Symbol.valueOf("test-on-test-begin-simple");
        SyntaxRule[] arrsyntaxRule9 = new SyntaxRule[3];
        Object[] arrobject16 = new Object[4];
        Lit72 = Symbol.valueOf("test-group");
        arrobject16[0] = Lit72;
        arrobject16[1] = Lit187;
        arrobject16[2] = PairWithPosition.make(Lit156, PairWithPosition.make(LList.Empty, Lit170, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1855500), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1855492);
        arrobject16[3] = Lit156;
        arrsyntaxRule9[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", Lit149, 3, "testing.scm:450"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\u0011\u0018\u00149\u0011\u0018\u001c\t\u0010\b\u000b\b\u0011\u0018\u001c\t\u0010\b\u0013", arrobject16, 0);
        Object[] arrobject17 = new Object[2];
        Lit74 = Symbol.valueOf("test-group-with-cleanup");
        arrobject17[0] = Lit74;
        arrobject17[1] = Boolean.FALSE;
        arrsyntaxRule9[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit149, 2, "testing.scm:456"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\b\u000b", arrobject17, 0);
        arrsyntaxRule9[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f#", Lit149, 5, "testing.scm:458"), "\u0001\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u00039\u0011\u0018\f\t\u000b\b\u0013\t\u001b\"", new Object[]{Lit74, Symbol.valueOf("begin")}, 0);
        Lit75 = new SyntaxRules(Lit149, arrsyntaxRule9, 5, Lit74);
        SyntaxRule[] arrsyntaxRule10 = new SyntaxRule[1];
        Object[] arrobject18 = new Object[13];
        arrobject18[0] = Lit151;
        arrobject18[1] = PairWithPosition.make(PairWithPosition.make(Lit159, Lit188, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1798156), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1798155);
        arrobject18[2] = Lit52;
        arrobject18[3] = Lit159;
        arrobject18[4] = Symbol.valueOf("list");
        arrobject18[5] = Lit153;
        arrobject18[6] = Lit178;
        arrobject18[7] = Lit180;
        Lit62 = Symbol.valueOf("%test-should-execute");
        arrobject18[8] = PairWithPosition.make(Lit62, PairWithPosition.make(Lit159, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1810466), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1810444);
        arrobject18[9] = Lit187;
        arrobject18[10] = Lit156;
        Lit64 = Symbol.valueOf("test-begin");
        arrobject18[11] = Lit64;
        arrobject18[12] = Lit96;
        arrsyntaxRule10[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u000b", Lit149, 2, "testing.scm:438"), "\u0001\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0099\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\b\u0011\u0018,\u0011\u00184\b\u0003\b\u0011\u0018<\u0011\u0018D\b\u0011\u0018LY\u0011\u0018T\t\u0010\b\u0011\u0018\\\b\u00031\u0011\u0018T\t\u0010\n\b\u0011\u0018T\t\u0010\b\u0011\u0018d\b\u0003", arrobject18, 0);
        Lit73 = new SyntaxRules(Lit149, arrsyntaxRule10, 2, Lit72);
        Lit70 = Symbol.valueOf("test-on-final-simple");
        Lit69 = Symbol.valueOf("test-on-bad-end-name-simple");
        Lit68 = Symbol.valueOf("test-on-bad-count-simple");
        Lit67 = Symbol.valueOf("test-on-group-end-simple");
        Lit66 = Symbol.valueOf("test-on-group-begin-simple");
        SyntaxRule[] arrsyntaxRule11 = new SyntaxRule[2];
        Object[] arrobject19 = new Object[2];
        Lit63 = Symbol.valueOf("%test-begin");
        arrobject19[0] = Lit63;
        arrobject19[1] = Lit170;
        arrsyntaxRule11[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit149, 1, "testing.scm:305"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", arrobject19, 0);
        arrsyntaxRule11[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit149, 2, "testing.scm:307"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[]{Lit63}, 0);
        Lit65 = new SyntaxRules(Lit149, arrsyntaxRule11, 2, Lit64);
        Lit61 = Symbol.valueOf("test-runner-create");
        Lit59 = Symbol.valueOf("test-runner-simple");
        Lit58 = Symbol.valueOf("test-runner-null");
        Lit57 = Symbol.valueOf("%test-null-callback");
        Lit56 = Symbol.valueOf("test-runner-group-path");
        Lit55 = Symbol.valueOf("test-runner-reset");
        Lit54 = Symbol.valueOf("test-runner-aux-value!");
        Lit53 = Symbol.valueOf("test-runner-aux-value");
        Lit50 = Symbol.valueOf("test-runner-on-bad-end-name!");
        Lit49 = Symbol.valueOf("test-runner-on-bad-end-name");
        Lit48 = Symbol.valueOf("test-runner-on-bad-count!");
        Lit47 = Symbol.valueOf("test-runner-on-bad-count");
        Lit46 = Symbol.valueOf("test-runner-on-final!");
        Lit45 = Symbol.valueOf("test-runner-on-final");
        Lit44 = Symbol.valueOf("test-runner-on-group-end!");
        Lit43 = Symbol.valueOf("test-runner-on-group-end");
        Lit42 = Symbol.valueOf("test-runner-on-group-begin!");
        Lit41 = Symbol.valueOf("test-runner-on-group-begin");
        Lit40 = Symbol.valueOf("test-runner-on-test-end!");
        Lit39 = Symbol.valueOf("test-runner-on-test-end");
        Lit38 = Symbol.valueOf("test-runner-on-test-begin!");
        Lit37 = Symbol.valueOf("test-runner-on-test-begin");
        Lit36 = Symbol.valueOf("test-runner-group-stack!");
        Lit35 = Symbol.valueOf("test-runner-group-stack");
        Lit30 = Symbol.valueOf("test-runner-skip-count!");
        Lit29 = Symbol.valueOf("test-runner-skip-count");
        Lit28 = Symbol.valueOf("test-runner-xfail-count!");
        Lit27 = Symbol.valueOf("test-runner-xfail-count");
        Lit26 = Symbol.valueOf("test-runner-xpass-count!");
        Lit25 = Symbol.valueOf("test-runner-xpass-count");
        Lit24 = Symbol.valueOf("test-runner-fail-count!");
        Lit23 = Symbol.valueOf("test-runner-fail-count");
        Lit22 = Symbol.valueOf("test-runner-pass-count!");
        Lit21 = Symbol.valueOf("test-runner-pass-count");
        Lit20 = Symbol.valueOf("test-runner?");
        Lit19 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b\u001b\b\u0011\u0018$\u0011\u0018\u001c\t#\t\u000b\b\u0013", new Object[]{Lit160, Lit161, Lit52, Lit159, Lit91}, 0);
        Lit18 = new SyntaxPattern("<\f\u0007\f\u000f\f\u0017\b\f\u001f\f'\b", Lit149, 5, "testing.scm:723");
        Lit17 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004I\u0011\u0018\f\b\u0011\u0018\u0014\b\u000b\u00a9\u0011\u0018\u001c\u0011\u0018$\b\u0011\u0018,A\u0011\u0018,\u0011\u00184\b\u000b\b#\b\u0011\u0018<\u0011\u0018$\t+\t\u0013\b\u001b", new Object[]{Lit160, Lit162, Lit177, Lit52, Lit159, Lit153, Lit178, Lit91}, 0);
        Lit16 = new SyntaxPattern("L\f\u0007\f\u000f\f\u0017\f\u001f\b\f'\f/\b", Lit149, 6, "testing.scm:717");
        Lit15 = new SyntaxTemplate("", "\u0018\u0004", Lit179, 0);
        Lit14 = Symbol.valueOf("pass");
        Lit12 = Symbol.valueOf("fail");
        Lit11 = PairWithPosition.make(Lit14, Lit189, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2248754);
        Lit4 = Symbol.valueOf("source-file");
        Lit5 = Symbol.valueOf("source-line");
        Lit6 = Symbol.valueOf("source-form");
        Lit10 = PairWithPosition.make(Lit7, PairWithPosition.make(Lit4, PairWithPosition.make(Lit5, PairWithPosition.make(Lit6, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2101290), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2101278), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2101266), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2101255);
        Lit8 = PairWithPosition.make(Lit12, Lit189, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1994773);
        Lit3 = Symbol.valueOf("xfail");
        Lit2 = Symbol.valueOf("skip");
        Lit1 = Symbol.valueOf("result-kind");
        Lit0 = IntNum.valueOf(0);
        test$Mnrunner = (ClassType)Type.make(test-runner.class);
        $instance = new testing();
        $Prvt$cons = StaticFieldLocation.make("kawa.lib.lists", "cons");
        $Prvt$cdr = StaticFieldLocation.make("kawa.lib.lists", "cdr");
        $Prvt$assq = StaticFieldLocation.make("kawa.lib.lists", "assq");
        $Prvt$dynamic$Mnwind = StaticFieldLocation.make("kawa.lib.misc", "dynamic$Mnwind");
        $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
        $Prvt$cond = StaticFieldLocation.make("kawa.lib.std_syntax", "cond");
        $Prvt$and = StaticFieldLocation.make("kawa.lib.std_syntax", "and");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
        $Prvt$else = StaticFieldLocation.make("kawa.lib.std_syntax", "else");
        $Prvt$define$Mnrecord$Mntype = StaticFieldLocation.make("kawa.lib.DefineRecordType", "define$Mnrecord$Mntype");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$eq$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "isEq");
        $Prvt$equal$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "isEqual");
        $Prvt$eqv$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "isEqv");
        $Prvt$lambda = StaticFieldLocation.make("kawa.standard.SchemeCompilation", "lambda");
        $Prvt$list = StaticFieldLocation.make("gnu.kawa.lispexpr.LangObjType", "listType");
        $Prvt$quasiquote = StaticFieldLocation.make("kawa.lang.Quote", "quasiQuote");
        $Prvt$quote = StaticFieldLocation.make("kawa.lang.Quote", "plainQuote");
        $Prvt$try$Mncatch = StaticFieldLocation.make("kawa.lib.prim_syntax", "try$Mncatch");
        testing testing2 = $instance;
        test$Mnrunner$Qu = new ModuleMethod(testing2, 12, Lit20, 4097);
        test$Mnrunner$Mnpass$Mncount = new ModuleMethod(testing2, 13, Lit21, 4097);
        test$Mnrunner$Mnpass$Mncount$Ex = new ModuleMethod(testing2, 14, Lit22, 8194);
        test$Mnrunner$Mnfail$Mncount = new ModuleMethod(testing2, 15, Lit23, 4097);
        test$Mnrunner$Mnfail$Mncount$Ex = new ModuleMethod(testing2, 16, Lit24, 8194);
        test$Mnrunner$Mnxpass$Mncount = new ModuleMethod(testing2, 17, Lit25, 4097);
        test$Mnrunner$Mnxpass$Mncount$Ex = new ModuleMethod(testing2, 18, Lit26, 8194);
        test$Mnrunner$Mnxfail$Mncount = new ModuleMethod(testing2, 19, Lit27, 4097);
        test$Mnrunner$Mnxfail$Mncount$Ex = new ModuleMethod(testing2, 20, Lit28, 8194);
        test$Mnrunner$Mnskip$Mncount = new ModuleMethod(testing2, 21, Lit29, 4097);
        test$Mnrunner$Mnskip$Mncount$Ex = new ModuleMethod(testing2, 22, Lit30, 8194);
        $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist = new ModuleMethod(testing2, 23, Lit31, 4097);
        $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex = new ModuleMethod(testing2, 24, Lit32, 8194);
        $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist = new ModuleMethod(testing2, 25, Lit33, 4097);
        $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex = new ModuleMethod(testing2, 26, Lit34, 8194);
        test$Mnrunner$Mngroup$Mnstack = new ModuleMethod(testing2, 27, Lit35, 4097);
        test$Mnrunner$Mngroup$Mnstack$Ex = new ModuleMethod(testing2, 28, Lit36, 8194);
        test$Mnrunner$Mnon$Mntest$Mnbegin = new ModuleMethod(testing2, 29, Lit37, 4097);
        test$Mnrunner$Mnon$Mntest$Mnbegin$Ex = new ModuleMethod(testing2, 30, Lit38, 8194);
        test$Mnrunner$Mnon$Mntest$Mnend = new ModuleMethod(testing2, 31, Lit39, 4097);
        test$Mnrunner$Mnon$Mntest$Mnend$Ex = new ModuleMethod(testing2, 32, Lit40, 8194);
        test$Mnrunner$Mnon$Mngroup$Mnbegin = new ModuleMethod(testing2, 33, Lit41, 4097);
        test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex = new ModuleMethod(testing2, 34, Lit42, 8194);
        test$Mnrunner$Mnon$Mngroup$Mnend = new ModuleMethod(testing2, 35, Lit43, 4097);
        test$Mnrunner$Mnon$Mngroup$Mnend$Ex = new ModuleMethod(testing2, 36, Lit44, 8194);
        test$Mnrunner$Mnon$Mnfinal = new ModuleMethod(testing2, 37, Lit45, 4097);
        test$Mnrunner$Mnon$Mnfinal$Ex = new ModuleMethod(testing2, 38, Lit46, 8194);
        test$Mnrunner$Mnon$Mnbad$Mncount = new ModuleMethod(testing2, 39, Lit47, 4097);
        test$Mnrunner$Mnon$Mnbad$Mncount$Ex = new ModuleMethod(testing2, 40, Lit48, 8194);
        test$Mnrunner$Mnon$Mnbad$Mnend$Mnname = new ModuleMethod(testing2, 41, Lit49, 4097);
        test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex = new ModuleMethod(testing2, 42, Lit50, 8194);
        test$Mnresult$Mnalist = new ModuleMethod(testing2, 43, Lit51, 4097);
        test$Mnresult$Mnalist$Ex = new ModuleMethod(testing2, 44, Lit52, 8194);
        test$Mnrunner$Mnaux$Mnvalue = new ModuleMethod(testing2, 45, Lit53, 4097);
        test$Mnrunner$Mnaux$Mnvalue$Ex = new ModuleMethod(testing2, 46, Lit54, 8194);
        test$Mnrunner$Mnreset = new ModuleMethod(testing2, 47, Lit55, 4097);
        test$Mnrunner$Mngroup$Mnpath = new ModuleMethod(testing2, 48, Lit56, 4097);
        $Pctest$Mnnull$Mncallback = new ModuleMethod(testing2, 49, Lit57, 4097);
        ModuleMethod moduleMethod = new ModuleMethod(testing2, 50, null, 12291);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:199");
        lambda$Fn1 = moduleMethod;
        ModuleMethod moduleMethod2 = new ModuleMethod(testing2, 51, null, 12291);
        moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:204");
        lambda$Fn2 = moduleMethod2;
        ModuleMethod moduleMethod3 = new ModuleMethod(testing2, 52, null, 12291);
        moduleMethod3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:205");
        lambda$Fn3 = moduleMethod3;
        test$Mnrunner$Mnnull = new ModuleMethod(testing2, 53, Lit58, 0);
        test$Mnrunner$Mnsimple = new ModuleMethod(testing2, 54, Lit59, 0);
        test$Mnrunner$Mnget = new ModuleMethod(testing2, 55, Lit60, 0);
        test$Mnrunner$Mncreate = new ModuleMethod(testing2, 56, Lit61, 0);
        $Prvt$$Pctest$Mnshould$Mnexecute = new ModuleMethod(testing2, 57, Lit62, 4097);
        $Pctest$Mnbegin = new ModuleMethod(testing2, 58, Lit63, 8194);
        test$Mnbegin = Macro.make(Lit64, Lit65, "gnu.kawa.slib.testing");
        test$Mnon$Mngroup$Mnbegin$Mnsimple = new ModuleMethod(testing2, 59, Lit66, 12291);
        test$Mnon$Mngroup$Mnend$Mnsimple = new ModuleMethod(testing2, 60, Lit67, 4097);
        test$Mnon$Mnbad$Mncount$Mnsimple = new ModuleMethod(testing2, 61, Lit68, 12291);
        test$Mnon$Mnbad$Mnend$Mnname$Mnsimple = new ModuleMethod(testing2, 62, Lit69, 12291);
        test$Mnon$Mnfinal$Mnsimple = new ModuleMethod(testing2, 63, Lit70, 4097);
        $Prvt$$Pctest$Mnend = new ModuleMethod(testing2, 64, Lit71, 8194);
        test$Mngroup = Macro.make(Lit72, Lit73, "gnu.kawa.slib.testing");
        test$Mngroup$Mnwith$Mncleanup = Macro.make(Lit74, Lit75, "gnu.kawa.slib.testing");
        test$Mnon$Mntest$Mnbegin$Mnsimple = new ModuleMethod(testing2, 65, Lit76, 4097);
        test$Mnresult$Mnref = Macro.make(Lit77, Lit78, "gnu.kawa.slib.testing");
        test$Mnon$Mntest$Mnend$Mnsimple = new ModuleMethod(testing2, 66, Lit79, 4097);
        test$Mnresult$Mnset$Ex = new ModuleMethod(testing2, 67, Lit80, 12291);
        test$Mnresult$Mnclear = new ModuleMethod(testing2, 68, Lit81, 4097);
        test$Mnresult$Mnremove = new ModuleMethod(testing2, 69, Lit82, 8194);
        test$Mnresult$Mnkind = new ModuleMethod(testing2, 70, Lit83, -4096);
        test$Mnpassed$Qu = new ModuleMethod(testing2, 71, Lit84, -4096);
        $Prvt$$Pctest$Mnreport$Mnresult = new ModuleMethod(testing2, 72, Lit85, 0);
        $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch = Macro.make(Lit86, Lit87, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnon$Mntest$Mnbegin = new ModuleMethod(testing2, 73, Lit88, 4097);
        $Prvt$$Pctest$Mnon$Mntest$Mnend = new ModuleMethod(testing2, 74, Lit89, 8194);
        test$Mnrunner$Mntest$Mnname = new ModuleMethod(testing2, 75, Lit90, 4097);
        $Prvt$$Pctest$Mncomp2body = Macro.make(Lit91, Lit92, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnapproximate$Eq = new ModuleMethod(testing2, 76, Lit93, 4097);
        $Prvt$$Pctest$Mncomp1body = Macro.make(Lit94, Lit95, "gnu.kawa.slib.testing");
        testing testing3 = $instance;
        ModuleMethod moduleMethod4 = new ModuleMethod(testing3, 77, null, 4097);
        moduleMethod4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:693");
        test$Mnend = Macro.make(Lit96, moduleMethod4, "gnu.kawa.slib.testing");
        testing testing4 = $instance;
        ModuleMethod moduleMethod5 = new ModuleMethod(testing4, 78, null, 4097);
        moduleMethod5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:702");
        test$Mnassert = Macro.make(Lit102, moduleMethod5, "gnu.kawa.slib.testing");
        testing testing5 = $instance;
        ModuleMethod moduleMethod6 = new ModuleMethod(testing5, 79, null, 4097);
        moduleMethod6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:729");
        test$Mneqv = Macro.make(Lit108, moduleMethod6, "gnu.kawa.slib.testing");
        testing testing6 = $instance;
        ModuleMethod moduleMethod7 = new ModuleMethod(testing6, 80, null, 4097);
        moduleMethod7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:731");
        test$Mneq = Macro.make(Lit110, moduleMethod7, "gnu.kawa.slib.testing");
        testing testing7 = $instance;
        ModuleMethod moduleMethod8 = new ModuleMethod(testing7, 81, null, 4097);
        moduleMethod8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:733");
        test$Mnequal = Macro.make(Lit112, moduleMethod8, "gnu.kawa.slib.testing");
        testing testing8 = $instance;
        ModuleMethod moduleMethod9 = new ModuleMethod(testing8, 82, null, 4097);
        moduleMethod9.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:735");
        test$Mnapproximate = Macro.make(Lit114, moduleMethod9, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnerror = Macro.make(Lit120, Lit121, "gnu.kawa.slib.testing");
        testing testing9 = $instance;
        ModuleMethod moduleMethod10 = new ModuleMethod(testing9, 83, null, 4097);
        moduleMethod10.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:890");
        test$Mnerror = Macro.make(Lit122, moduleMethod10, "gnu.kawa.slib.testing");
        test$Mnapply = new ModuleMethod(testing2, 84, Lit130, -4095);
        test$Mnwith$Mnrunner = Macro.make(Lit131, Lit132, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnmatch$Mnnth = new ModuleMethod(testing2, 85, Lit133, 8194);
        test$Mnmatch$Mnnth = Macro.make(Lit134, Lit135, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnmatch$Mnall = new ModuleMethod(testing2, 86, Lit136, -4096);
        test$Mnmatch$Mnall = Macro.make(Lit137, Lit138, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnmatch$Mnany = new ModuleMethod(testing2, 87, Lit139, -4096);
        test$Mnmatch$Mnany = Macro.make(Lit140, Lit141, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnas$Mnspecifier = new ModuleMethod(testing2, 88, Lit142, 4097);
        test$Mnskip = Macro.make(Lit143, Lit144, "gnu.kawa.slib.testing");
        test$Mnexpect$Mnfail = Macro.make(Lit145, Lit146, "gnu.kawa.slib.testing");
        test$Mnmatch$Mnname = new ModuleMethod(testing2, 89, Lit147, 4097);
        test$Mnread$Mneval$Mnstring = new ModuleMethod(testing2, 90, Lit148, 4097);
        testing.$runBody$();
    }

    public testing() {
        ModuleInfo.register(this);
    }

    static Object lambda16(Object x) {
        Object object2;
        Object[] arrobject = TemplateScope.make();
        Pair pair = LList.list2(x, LList.list2(Lit97.execute(null, (TemplateScope)arrobject), testing.$PcTestSourceLine2(x)));
        arrobject = SyntaxPattern.allocVars(3, null);
        if (((Pattern)Lit98).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit99.execute(arrobject, templateScope);
        } else if (((Pattern)Lit100).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit101.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", pair);
        }
        return object2;
    }

    static Object lambda17(Object x) {
        Object object2;
        Object[] arrobject = TemplateScope.make();
        Pair pair = LList.list2(x, LList.list2(Lit103.execute(null, (TemplateScope)arrobject), testing.$PcTestSourceLine2(x)));
        arrobject = SyntaxPattern.allocVars(4, null);
        if (((Pattern)Lit104).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit105.execute(arrobject, templateScope);
        } else if (((Pattern)Lit106).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit107.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", pair);
        }
        return object2;
    }

    static Object lambda18(Object x) {
        TemplateScope templateScope = TemplateScope.make();
        return testing.$PcTestComp2(Lit109.execute(null, templateScope), x);
    }

    static Object lambda19(Object x) {
        TemplateScope templateScope = TemplateScope.make();
        return testing.$PcTestComp2(Lit111.execute(null, templateScope), x);
    }

    static Object lambda20(Object x) {
        TemplateScope templateScope = TemplateScope.make();
        return testing.$PcTestComp2(Lit113.execute(null, templateScope), x);
    }

    static Object lambda21(Object x) {
        Object object2;
        Object[] arrobject = TemplateScope.make();
        Pair pair = LList.list2(x, LList.list2(Lit115.execute(null, (TemplateScope)arrobject), testing.$PcTestSourceLine2(x)));
        arrobject = SyntaxPattern.allocVars(6, null);
        if (((Pattern)Lit116).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit117.execute(arrobject, templateScope);
        } else if (((Pattern)Lit118).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit119.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", pair);
        }
        return object2;
    }

    static Object lambda22(Object x) {
        Object object2;
        Object[] arrobject = TemplateScope.make();
        Pair pair = LList.list2(x, LList.list2(Lit123.execute(null, (TemplateScope)arrobject), testing.$PcTestSourceLine2(x)));
        arrobject = SyntaxPattern.allocVars(5, null);
        if (((Pattern)Lit124).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit125.execute(arrobject, templateScope);
        } else if (((Pattern)Lit126).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit127.execute(arrobject, templateScope);
        } else if (((Pattern)Lit128).match(pair, arrobject, 0)) {
            TemplateScope templateScope = TemplateScope.make();
            object2 = Lit129.execute(arrobject, templateScope);
        } else {
            object2 = syntax_case.error("syntax-case", pair);
        }
        return object2;
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 72: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 56: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 55: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 54: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
            case 53: {
                callContext.proc = moduleMethod;
                callContext.pc = 0;
                return 0;
            }
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 83: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 82: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 81: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 80: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 79: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 78: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 77: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 90: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 89: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 88: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 76: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 75: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 73: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 68: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 66: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 65: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 63: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 60: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 57: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 49: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 48: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 47: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 45: {
                Object object3 = Promise.force(object2, test-runner.class);
                if (!(object3 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 43: {
                Object object4 = Promise.force(object2, test-runner.class);
                if (!(object4 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 41: {
                Object object5 = Promise.force(object2, test-runner.class);
                if (!(object5 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 39: {
                Object object6 = Promise.force(object2, test-runner.class);
                if (!(object6 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 37: {
                Object object7 = Promise.force(object2, test-runner.class);
                if (!(object7 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 35: {
                Object object8 = Promise.force(object2, test-runner.class);
                if (!(object8 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 33: {
                Object object9 = Promise.force(object2, test-runner.class);
                if (!(object9 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 31: {
                Object object10 = Promise.force(object2, test-runner.class);
                if (!(object10 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 29: {
                Object object11 = Promise.force(object2, test-runner.class);
                if (!(object11 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 27: {
                Object object12 = Promise.force(object2, test-runner.class);
                if (!(object12 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 25: {
                Object object13 = Promise.force(object2, test-runner.class);
                if (!(object13 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 23: {
                Object object14 = Promise.force(object2, test-runner.class);
                if (!(object14 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 21: {
                Object object15 = Promise.force(object2, test-runner.class);
                if (!(object15 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 19: {
                Object object16 = Promise.force(object2, test-runner.class);
                if (!(object16 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 17: {
                Object object17 = Promise.force(object2, test-runner.class);
                if (!(object17 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 15: {
                Object object18 = Promise.force(object2, test-runner.class);
                if (!(object18 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 13: {
                Object object19 = Promise.force(object2, test-runner.class);
                if (!(object19 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object19;
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
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 85: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 74: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 69: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 64: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 58: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 46: {
                Object object4 = Promise.force(object2, test-runner.class);
                if (!(object4 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 44: {
                Object object5 = Promise.force(object2, test-runner.class);
                if (!(object5 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 42: {
                Object object6 = Promise.force(object2, test-runner.class);
                if (!(object6 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 40: {
                Object object7 = Promise.force(object2, test-runner.class);
                if (!(object7 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 38: {
                Object object8 = Promise.force(object2, test-runner.class);
                if (!(object8 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 36: {
                Object object9 = Promise.force(object2, test-runner.class);
                if (!(object9 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 34: {
                Object object10 = Promise.force(object2, test-runner.class);
                if (!(object10 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object10;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 32: {
                Object object11 = Promise.force(object2, test-runner.class);
                if (!(object11 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object11;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 30: {
                Object object12 = Promise.force(object2, test-runner.class);
                if (!(object12 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 28: {
                Object object13 = Promise.force(object2, test-runner.class);
                if (!(object13 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 26: {
                Object object14 = Promise.force(object2, test-runner.class);
                if (!(object14 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 24: {
                Object object15 = Promise.force(object2, test-runner.class);
                if (!(object15 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 22: {
                Object object16 = Promise.force(object2, test-runner.class);
                if (!(object16 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object16;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 20: {
                Object object17 = Promise.force(object2, test-runner.class);
                if (!(object17 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object17;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 18: {
                Object object18 = Promise.force(object2, test-runner.class);
                if (!(object18 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object18;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 16: {
                Object object19 = Promise.force(object2, test-runner.class);
                if (!(object19 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object19;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 14: {
                Object object20 = Promise.force(object2, test-runner.class);
                if (!(object20 instanceof test-runner)) {
                    return -786431;
                }
                callContext.value1 = object20;
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
            case 67: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 62: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 61: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 59: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 52: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 51: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 50: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 87: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 86: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 84: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 71: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 70: {
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
            case 53: {
                return testing.testRunnerNull();
            }
            case 54: {
                return testing.testRunnerSimple();
            }
            case 55: {
                return testing.testRunnerGet();
            }
            case 56: {
                return testing.testRunnerCreate();
            }
            case 72: {
                return testing.$PcTestReportResult();
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
            case 12: {
                Boolean bl;
                if (testing.isTestRunner(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 13: {
                return testing.testRunnerPassCount((test-runner)Promise.force(object2, test-runner.class));
            }
            case 15: {
                return testing.testRunnerFailCount((test-runner)Promise.force(object2, test-runner.class));
            }
            case 17: {
                return testing.testRunnerXpassCount((test-runner)Promise.force(object2, test-runner.class));
            }
            case 19: {
                return testing.testRunnerXfailCount((test-runner)Promise.force(object2, test-runner.class));
            }
            case 21: {
                return testing.testRunnerSkipCount((test-runner)Promise.force(object2, test-runner.class));
            }
            case 23: {
                return testing.$PcTestRunnerSkipList((test-runner)Promise.force(object2, test-runner.class));
            }
            case 25: {
                return testing.$PcTestRunnerFailList((test-runner)Promise.force(object2, test-runner.class));
            }
            case 27: {
                return testing.testRunnerGroupStack((test-runner)Promise.force(object2, test-runner.class));
            }
            case 29: {
                return testing.testRunnerOnTestBegin((test-runner)Promise.force(object2, test-runner.class));
            }
            case 31: {
                return testing.testRunnerOnTestEnd((test-runner)Promise.force(object2, test-runner.class));
            }
            case 33: {
                return testing.testRunnerOnGroupBegin((test-runner)Promise.force(object2, test-runner.class));
            }
            case 35: {
                return testing.testRunnerOnGroupEnd((test-runner)Promise.force(object2, test-runner.class));
            }
            case 37: {
                return testing.testRunnerOnFinal((test-runner)Promise.force(object2, test-runner.class));
            }
            case 39: {
                return testing.testRunnerOnBadCount((test-runner)Promise.force(object2, test-runner.class));
            }
            case 41: {
                return testing.testRunnerOnBadEndName((test-runner)Promise.force(object2, test-runner.class));
            }
            case 43: {
                return testing.testResultAlist((test-runner)Promise.force(object2, test-runner.class));
            }
            case 45: {
                return testing.testRunnerAuxValue((test-runner)Promise.force(object2, test-runner.class));
            }
            case 47: {
                testing.testRunnerReset(object2);
                return Values.empty;
            }
            case 48: {
                return testing.testRunnerGroupPath(object2);
            }
            case 49: {
                Boolean bl;
                if (testing.$PcTestNullCallback(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 57: {
                return testing.$PcTestShouldExecute(object2);
            }
            case 60: {
                Boolean bl;
                if (testing.testOnGroupEndSimple(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 63: {
                testing.testOnFinalSimple(object2);
                return Values.empty;
            }
            case 65: {
                testing.testOnTestBeginSimple(object2);
                return Values.empty;
            }
            case 66: {
                return testing.testOnTestEndSimple(object2);
            }
            case 68: {
                testing.testResultClear(object2);
                return Values.empty;
            }
            case 73: {
                Boolean bl;
                if (testing.$PcTestOnTestBegin(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 75: {
                return testing.testRunnerTestName(object2);
            }
            case 76: {
                return testing.$PcTestApproximate$Eq(object2);
            }
            case 88: {
                return testing.$PcTestAsSpecifier(object2);
            }
            case 89: {
                return testing.testMatchName(object2);
            }
            case 90: {
                return testing.testReadEvalString(object2);
            }
            case 77: {
                return testing.lambda16(object2);
            }
            case 78: {
                return testing.lambda17(object2);
            }
            case 79: {
                return testing.lambda18(object2);
            }
            case 80: {
                return testing.lambda19(object2);
            }
            case 81: {
                return testing.lambda20(object2);
            }
            case 82: {
                return testing.lambda21(object2);
            }
            case 83: {
                return testing.lambda22(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-pass-count", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-fail-count", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-xpass-count", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-xfail-count", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-skip-count", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-skip-list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-fail-list", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-group-stack", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-test-begin", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-test-end", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-group-begin", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-group-end", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-final", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-bad-count", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-bad-end-name", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-aux-value", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        switch (moduleMethod.selector) {
            case 14: {
                testing.testRunnerPassCount$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 16: {
                testing.testRunnerFailCount$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 18: {
                testing.testRunnerXpassCount$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 20: {
                testing.testRunnerXfailCount$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 22: {
                testing.testRunnerSkipCount$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 24: {
                testing.$PcTestRunnerSkipList$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 26: {
                testing.$PcTestRunnerFailList$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 28: {
                testing.testRunnerGroupStack$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 30: {
                testing.testRunnerOnTestBegin$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 32: {
                testing.testRunnerOnTestEnd$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 34: {
                testing.testRunnerOnGroupBegin$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 36: {
                testing.testRunnerOnGroupEnd$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 38: {
                testing.testRunnerOnFinal$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 40: {
                testing.testRunnerOnBadCount$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 42: {
                testing.testRunnerOnBadEndName$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 44: {
                testing.testResultAlist$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 46: {
                testing.testRunnerAuxValue$Ex((test-runner)Promise.force(object2, test-runner.class), object3);
                return Values.empty;
            }
            case 58: {
                testing.$PcTestBegin(object2, object3);
                return Values.empty;
            }
            case 64: {
                return testing.$PcTestEnd(object2, object3);
            }
            case 69: {
                testing.testResultRemove(object2, object3);
                return Values.empty;
            }
            case 74: {
                testing.$PcTestOnTestEnd(object2, object3);
                return Values.empty;
            }
            case 85: {
                return testing.$PcTestMatchNth(object2, object3);
            }
        }
        return super.apply2(moduleMethod, object2, object3);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-pass-count!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-fail-count!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-xpass-count!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-xfail-count!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-skip-count!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-skip-list!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "%test-runner-fail-list!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-group-stack!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-test-begin!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-test-end!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-group-begin!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-group-end!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-final!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-bad-count!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-on-bad-end-name!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-result-alist!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "test-runner-aux-value!", 1, object2);
        }
    }

    public Object apply3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4) {
        switch (moduleMethod.selector) {
            case 50: {
                return testing.lambda1(object2, object3, object4) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 51: {
                return testing.lambda2(object2, object3, object4) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 52: {
                return testing.lambda3(object2, object3, object4) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 59: {
                return testing.testOnGroupBeginSimple(object2, object3, object4) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 61: {
                testing.testOnBadCountSimple(object2, object3, object4);
                return Values.empty;
            }
            case 62: {
                return testing.testOnBadEndNameSimple(object2, object3, object4);
            }
            case 67: {
                testing.testResultSet$Ex(object2, object3, object4);
                return Values.empty;
            }
        }
        return super.apply3(moduleMethod, object2, object3, object4);
    }

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 70: {
                return testing.testResultKind$V(arrobject);
            }
            case 71: {
                return testing.isTestPassed$V(arrobject);
            }
            case 84: {
                int n = arrobject.length - 1;
                Object[] arrobject2 = new Object[n];
                while (--n >= 0) {
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 1];
                }
                return testing.testApply$V(arrobject[0], arrobject2);
            }
            case 86: {
                return testing.$PcTestMatchAll$V(arrobject);
            }
            case 87: {
                return testing.$PcTestMatchAny$V(arrobject);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }

    public class test-runner {
        public Object pass$Mncount;
        public Object fail$Mncount;
        public Object xpass$Mncount;
        public Object xfail$Mncount;
        public Object skip$Mncount;
        public Object skip$Mnlist;
        public Object fail$Mnlist;
        public Object run$Mnlist;
        public Object skip$Mnsave;
        public Object fail$Mnsave;
        public Object group$Mnstack;
        public Object on$Mntest$Mnbegin;
        public Object on$Mntest$Mnend;
        public Object on$Mngroup$Mnbegin;
        public Object on$Mngroup$Mnend;
        public Object on$Mnfinal;
        public Object on$Mnbad$Mncount;
        public Object on$Mnbad$Mnend$Mnname;
        public Object total$Mncount;
        public Object count$Mnlist;
        public Object result$Mnalist;
        public Object aux$Mnvalue;
    }

}

