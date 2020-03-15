// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.mapping.Values;
import gnu.expr.ModuleInfo;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import kawa.standard.syntax_case;
import kawa.lang.TemplateScope;
import gnu.lists.Pair;
import kawa.lib.std_syntax;
import gnu.kawa.io.CharArrayInPort;
import kawa.lib.scheme.eval;
import gnu.kawa.io.InPort;
import kawa.lib.numbers;
import kawa.lib.misc;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.NumberCompare;
import gnu.expr.SourceName;
import gnu.mapping.Procedure;
import gnu.lists.FString;
import kawa.lib.strings;
import gnu.bytecode.Type;
import kawa.lib.ports;
import gnu.kawa.io.OutPort;
import kawa.standard.Scheme;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.expr.KawaConvert;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import gnu.mapping.Promise;
import gnu.lists.LList;
import gnu.lists.Consumer;
import kawa.lib.parameters;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import gnu.bytecode.ClassType;
import gnu.mapping.LocationProc;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class testing extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        testing.test$Mnlog$Mnto$Mnfile = true;
        testing.test$Mnrunner$Mncurrent = parameters.makeParameter(Boolean.FALSE);
        testing.test$Mnrunner$Mnfactory = parameters.makeParameter(testing.test$Mnrunner$Mnsimple);
    }
    
    public static boolean isTestRunner(final Object obj) {
        return obj instanceof test-runner;
    }
    
    public static Object testRunnerPassCount(final test-runner obj) {
        return obj.pass$Mncount;
    }
    
    public static void testRunnerPassCount$Ex(final test-runner obj, final Object value) {
        obj.pass$Mncount = value;
    }
    
    public static Object testRunnerFailCount(final test-runner obj) {
        return obj.fail$Mncount;
    }
    
    public static void testRunnerFailCount$Ex(final test-runner obj, final Object value) {
        obj.fail$Mncount = value;
    }
    
    public static Object testRunnerXpassCount(final test-runner obj) {
        return obj.xpass$Mncount;
    }
    
    public static void testRunnerXpassCount$Ex(final test-runner obj, final Object value) {
        obj.xpass$Mncount = value;
    }
    
    public static Object testRunnerXfailCount(final test-runner obj) {
        return obj.xfail$Mncount;
    }
    
    public static void testRunnerXfailCount$Ex(final test-runner obj, final Object value) {
        obj.xfail$Mncount = value;
    }
    
    public static Object testRunnerSkipCount(final test-runner obj) {
        return obj.skip$Mncount;
    }
    
    public static void testRunnerSkipCount$Ex(final test-runner obj, final Object value) {
        obj.skip$Mncount = value;
    }
    
    public static Object $PcTestRunnerSkipList(final test-runner obj) {
        return obj.skip$Mnlist;
    }
    
    public static void $PcTestRunnerSkipList$Ex(final test-runner obj, final Object value) {
        obj.skip$Mnlist = value;
    }
    
    public static Object $PcTestRunnerFailList(final test-runner obj) {
        return obj.fail$Mnlist;
    }
    
    public static void $PcTestRunnerFailList$Ex(final test-runner obj, final Object value) {
        obj.fail$Mnlist = value;
    }
    
    public static Object testRunnerGroupStack(final test-runner obj) {
        return obj.group$Mnstack;
    }
    
    public static void testRunnerGroupStack$Ex(final test-runner obj, final Object value) {
        obj.group$Mnstack = value;
    }
    
    public static Object testRunnerOnTestBegin(final test-runner obj) {
        return obj.on$Mntest$Mnbegin;
    }
    
    public static void testRunnerOnTestBegin$Ex(final test-runner obj, final Object value) {
        obj.on$Mntest$Mnbegin = value;
    }
    
    public static Object testRunnerOnTestEnd(final test-runner obj) {
        return obj.on$Mntest$Mnend;
    }
    
    public static void testRunnerOnTestEnd$Ex(final test-runner obj, final Object value) {
        obj.on$Mntest$Mnend = value;
    }
    
    public static Object testRunnerOnGroupBegin(final test-runner obj) {
        return obj.on$Mngroup$Mnbegin;
    }
    
    public static void testRunnerOnGroupBegin$Ex(final test-runner obj, final Object value) {
        obj.on$Mngroup$Mnbegin = value;
    }
    
    public static Object testRunnerOnGroupEnd(final test-runner obj) {
        return obj.on$Mngroup$Mnend;
    }
    
    public static void testRunnerOnGroupEnd$Ex(final test-runner obj, final Object value) {
        obj.on$Mngroup$Mnend = value;
    }
    
    public static Object testRunnerOnFinal(final test-runner obj) {
        return obj.on$Mnfinal;
    }
    
    public static void testRunnerOnFinal$Ex(final test-runner obj, final Object value) {
        obj.on$Mnfinal = value;
    }
    
    public static Object testRunnerOnBadCount(final test-runner obj) {
        return obj.on$Mnbad$Mncount;
    }
    
    public static void testRunnerOnBadCount$Ex(final test-runner obj, final Object value) {
        obj.on$Mnbad$Mncount = value;
    }
    
    public static Object testRunnerOnBadEndName(final test-runner obj) {
        return obj.on$Mnbad$Mnend$Mnname;
    }
    
    public static void testRunnerOnBadEndName$Ex(final test-runner obj, final Object value) {
        obj.on$Mnbad$Mnend$Mnname = value;
    }
    
    public static Object testResultAlist(final test-runner obj) {
        return obj.result$Mnalist;
    }
    
    public static void testResultAlist$Ex(final test-runner obj, final Object value) {
        obj.result$Mnalist = value;
    }
    
    public static Object testRunnerAuxValue(final test-runner obj) {
        return obj.aux$Mnvalue;
    }
    
    public static void testRunnerAuxValue$Ex(final test-runner obj, final Object value) {
        obj.aux$Mnvalue = value;
    }
    
    public static void testRunnerReset(final Object runner) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_1       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //    14: invokestatic    gnu/kawa/slib/testing.testResultAlist$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    17: aload_0         /* runner */
        //    18: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    20: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    23: dup            
        //    24: astore_1       
        //    25: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    28: getstatic       gnu/kawa/slib/testing.Lit0:Lgnu/math/IntNum;
        //    31: invokestatic    gnu/kawa/slib/testing.testRunnerPassCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    34: aload_0         /* runner */
        //    35: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore_1       
        //    42: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    45: getstatic       gnu/kawa/slib/testing.Lit0:Lgnu/math/IntNum;
        //    48: invokestatic    gnu/kawa/slib/testing.testRunnerFailCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    51: aload_0         /* runner */
        //    52: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    54: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    57: dup            
        //    58: astore_1       
        //    59: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    62: getstatic       gnu/kawa/slib/testing.Lit0:Lgnu/math/IntNum;
        //    65: invokestatic    gnu/kawa/slib/testing.testRunnerXpassCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    68: aload_0         /* runner */
        //    69: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    71: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    74: dup            
        //    75: astore_1       
        //    76: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    79: getstatic       gnu/kawa/slib/testing.Lit0:Lgnu/math/IntNum;
        //    82: invokestatic    gnu/kawa/slib/testing.testRunnerXfailCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    85: aload_0         /* runner */
        //    86: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    88: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    91: dup            
        //    92: astore_1       
        //    93: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    96: getstatic       gnu/kawa/slib/testing.Lit0:Lgnu/math/IntNum;
        //    99: invokestatic    gnu/kawa/slib/testing.testRunnerSkipCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   102: aload_0         /* runner */
        //   103: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   108: dup            
        //   109: astore_1       
        //   110: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   113: getstatic       gnu/kawa/slib/testing.Lit0:Lgnu/math/IntNum;
        //   116: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerTotalCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   119: aload_0         /* runner */
        //   120: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   122: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   125: dup            
        //   126: astore_1       
        //   127: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   130: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   133: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerCountList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   136: aload_0         /* runner */
        //   137: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   142: dup            
        //   143: astore_1       
        //   144: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   147: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   150: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerRunList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   153: aload_0         /* runner */
        //   154: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   156: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   159: dup            
        //   160: astore_1       
        //   161: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   164: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   167: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   170: aload_0         /* runner */
        //   171: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   176: dup            
        //   177: astore_1       
        //   178: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   181: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   184: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   187: aload_0         /* runner */
        //   188: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   190: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   193: dup            
        //   194: astore_1       
        //   195: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   198: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   201: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipSave$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   204: aload_0         /* runner */
        //   205: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   210: dup            
        //   211: astore_1       
        //   212: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   215: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   218: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailSave$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   221: aload_0         /* runner */
        //   222: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   224: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   227: dup            
        //   228: astore_1       
        //   229: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   232: getstatic       gnu/lists/LList.Empty:Lgnu/lists/EmptyList;
        //   235: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   238: return         
        //   239: new             Lgnu/mapping/WrongType;
        //   242: dup_x1         
        //   243: swap           
        //   244: ldc             "test-result-alist!"
        //   246: iconst_0       
        //   247: aload_1        
        //   248: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   251: athrow         
        //   252: new             Lgnu/mapping/WrongType;
        //   255: dup_x1         
        //   256: swap           
        //   257: ldc             "test-runner-pass-count!"
        //   259: iconst_0       
        //   260: aload_1        
        //   261: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   264: athrow         
        //   265: new             Lgnu/mapping/WrongType;
        //   268: dup_x1         
        //   269: swap           
        //   270: ldc             "test-runner-fail-count!"
        //   272: iconst_0       
        //   273: aload_1        
        //   274: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   277: athrow         
        //   278: new             Lgnu/mapping/WrongType;
        //   281: dup_x1         
        //   282: swap           
        //   283: ldc             "test-runner-xpass-count!"
        //   285: iconst_0       
        //   286: aload_1        
        //   287: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   290: athrow         
        //   291: new             Lgnu/mapping/WrongType;
        //   294: dup_x1         
        //   295: swap           
        //   296: ldc             "test-runner-xfail-count!"
        //   298: iconst_0       
        //   299: aload_1        
        //   300: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   303: athrow         
        //   304: new             Lgnu/mapping/WrongType;
        //   307: dup_x1         
        //   308: swap           
        //   309: ldc             "test-runner-skip-count!"
        //   311: iconst_0       
        //   312: aload_1        
        //   313: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   316: athrow         
        //   317: new             Lgnu/mapping/WrongType;
        //   320: dup_x1         
        //   321: swap           
        //   322: ldc             "%test-runner-total-count!"
        //   324: iconst_0       
        //   325: aload_1        
        //   326: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   329: athrow         
        //   330: new             Lgnu/mapping/WrongType;
        //   333: dup_x1         
        //   334: swap           
        //   335: ldc             "%test-runner-count-list!"
        //   337: iconst_0       
        //   338: aload_1        
        //   339: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   342: athrow         
        //   343: new             Lgnu/mapping/WrongType;
        //   346: dup_x1         
        //   347: swap           
        //   348: ldc             "%test-runner-run-list!"
        //   350: iconst_0       
        //   351: aload_1        
        //   352: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   355: athrow         
        //   356: new             Lgnu/mapping/WrongType;
        //   359: dup_x1         
        //   360: swap           
        //   361: ldc             "%test-runner-skip-list!"
        //   363: iconst_0       
        //   364: aload_1        
        //   365: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   368: athrow         
        //   369: new             Lgnu/mapping/WrongType;
        //   372: dup_x1         
        //   373: swap           
        //   374: ldc             "%test-runner-fail-list!"
        //   376: iconst_0       
        //   377: aload_1        
        //   378: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   381: athrow         
        //   382: new             Lgnu/mapping/WrongType;
        //   385: dup_x1         
        //   386: swap           
        //   387: ldc             "%test-runner-skip-save!"
        //   389: iconst_0       
        //   390: aload_1        
        //   391: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   394: athrow         
        //   395: new             Lgnu/mapping/WrongType;
        //   398: dup_x1         
        //   399: swap           
        //   400: ldc             "%test-runner-fail-save!"
        //   402: iconst_0       
        //   403: aload_1        
        //   404: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   407: athrow         
        //   408: new             Lgnu/mapping/WrongType;
        //   411: dup_x1         
        //   412: swap           
        //   413: ldc             "test-runner-group-stack!"
        //   415: iconst_0       
        //   416: aload_1        
        //   417: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   420: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     239    252    Ljava/lang/ClassCastException;
        //  25     28     252    265    Ljava/lang/ClassCastException;
        //  42     45     265    278    Ljava/lang/ClassCastException;
        //  59     62     278    291    Ljava/lang/ClassCastException;
        //  76     79     291    304    Ljava/lang/ClassCastException;
        //  93     96     304    317    Ljava/lang/ClassCastException;
        //  110    113    317    330    Ljava/lang/ClassCastException;
        //  127    130    330    343    Ljava/lang/ClassCastException;
        //  144    147    343    356    Ljava/lang/ClassCastException;
        //  161    164    356    369    Ljava/lang/ClassCastException;
        //  178    181    369    382    Ljava/lang/ClassCastException;
        //  195    198    382    395    Ljava/lang/ClassCastException;
        //  212    215    395    408    Ljava/lang/ClassCastException;
        //  229    232    408    421    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 225 out of bounds for length 225
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static void $PcTestRunnerTotalCount$Ex(final test-runner obj, final Object value) {
        obj.total$Mncount = value;
    }
    
    static void $PcTestRunnerCountList$Ex(final test-runner obj, final Object value) {
        obj.count$Mnlist = value;
    }
    
    static void $PcTestRunnerRunList$Ex(final test-runner obj, final Object value) {
        obj.run$Mnlist = value;
    }
    
    static void $PcTestRunnerSkipSave$Ex(final test-runner obj, final Object value) {
        obj.skip$Mnsave = value;
    }
    
    static void $PcTestRunnerFailSave$Ex(final test-runner obj, final Object value) {
        obj.fail$Mnsave = value;
    }
    
    public static LList testRunnerGroupPath(final Object runner) {
        Object o2;
        final Object o = o2 = Promise.force(runner, test-runner.class);
        Object o3;
        try {
            o3 = (o2 = Promise.force(testRunnerGroupStack((test-runner)o), LList.class));
            final LList list = (LList)o3;
            return lists.reverse(list);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "test-runner-group-stack", 0, o2);
        }
        try {
            final LList list = (LList)o3;
            return lists.reverse(list);
        }
        catch (ClassCastException ex2) {
            throw new WrongType(ex2, "reverse", 1, o2);
        }
    }
    
    static boolean $PcTestNullCallback(final Object runner) {
        return false;
    }
    
    public static test-runner testRunnerNull() {
        final test-runner runner = $PcTestRunnerAlloc();
        testRunnerReset(runner);
        testRunnerOnGroupBegin$Ex(runner, testing.lambda$Fn1);
        testRunnerOnGroupEnd$Ex(runner, testing.$Pctest$Mnnull$Mncallback);
        testRunnerOnFinal$Ex(runner, testing.$Pctest$Mnnull$Mncallback);
        testRunnerOnTestBegin$Ex(runner, testing.$Pctest$Mnnull$Mncallback);
        testRunnerOnTestEnd$Ex(runner, testing.$Pctest$Mnnull$Mncallback);
        testRunnerOnBadCount$Ex(runner, testing.lambda$Fn2);
        testRunnerOnBadEndName$Ex(runner, testing.lambda$Fn3);
        return runner;
    }
    
    static test-runner $PcTestRunnerAlloc() {
        return new test-runner();
    }
    
    static boolean lambda1(final Object runner, final Object name, final Object count) {
        return false;
    }
    
    static boolean lambda2(final Object runner, final Object count, final Object expected) {
        return false;
    }
    
    static boolean lambda3(final Object runner, final Object begin, final Object end) {
        return false;
    }
    
    public static test-runner testRunnerSimple() {
        final test-runner runner = $PcTestRunnerAlloc();
        testRunnerReset(runner);
        testRunnerOnGroupBegin$Ex(runner, testing.test$Mnon$Mngroup$Mnbegin$Mnsimple);
        testRunnerOnGroupEnd$Ex(runner, testing.test$Mnon$Mngroup$Mnend$Mnsimple);
        testRunnerOnFinal$Ex(runner, testing.test$Mnon$Mnfinal$Mnsimple);
        testRunnerOnTestBegin$Ex(runner, testing.test$Mnon$Mntest$Mnbegin$Mnsimple);
        testRunnerOnTestEnd$Ex(runner, testing.test$Mnon$Mntest$Mnend$Mnsimple);
        testRunnerOnBadCount$Ex(runner, testing.test$Mnon$Mnbad$Mncount$Mnsimple);
        testRunnerOnBadEndName$Ex(runner, testing.test$Mnon$Mnbad$Mnend$Mnname$Mnsimple);
        return runner;
    }
    
    public static Object testRunnerGet() {
        final Object r = testing.test$Mnrunner$Mncurrent.getValue();
        if (!KawaConvert.isTrue(r)) {
            exceptions.error("test-runner not initialized - test-begin missing?");
            throw Special.reachedUnexpected;
        }
        return r;
    }
    
    public static Object testRunnerCreate() {
        return Scheme.applyToArgs.apply1(testing.test$Mnrunner$Mnfactory.getValue());
    }
    
    public static Object $PcTestShouldExecute(final Object runner) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_2       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerRunList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    14: astore_1        /* run */
        //    15: aload_1         /* run */
        //    16: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    19: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    22: istore_3        /* x */
        //    23: iload_3         /* x */
        //    24: ifeq            34
        //    27: iload_3         /* x */
        //    28: ifeq            49
        //    31: goto            45
        //    34: aload_1         /* run */
        //    35: aload_0         /* runner */
        //    36: invokestatic    gnu/kawa/slib/testing.$PcTestAnySpecifierMatches:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    39: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    42: ifeq            49
        //    45: iconst_0       
        //    46: goto            50
        //    49: iconst_1       
        //    50: istore_2        /* x */
        //    51: iload_2         /* x */
        //    52: ifeq            62
        //    55: iload_2         /* x */
        //    56: ifeq            102
        //    59: goto            86
        //    62: aload_0         /* runner */
        //    63: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    65: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    68: dup            
        //    69: astore_3       
        //    70: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    73: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    76: aload_0         /* runner */
        //    77: invokestatic    gnu/kawa/slib/testing.$PcTestAnySpecifierMatches:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    80: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    83: ifeq            102
        //    86: aload_0         /* runner */
        //    87: getstatic       gnu/kawa/slib/testing.Lit1:Lgnu/mapping/SimpleSymbol;
        //    90: getstatic       gnu/kawa/slib/testing.Lit2:Lgnu/mapping/SimpleSymbol;
        //    93: invokestatic    gnu/kawa/slib/testing.testResultSet$Ex:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    96: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    99: goto            145
        //   102: aload_0         /* runner */
        //   103: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   108: dup            
        //   109: astore_3       
        //   110: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   113: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   116: aload_0         /* runner */
        //   117: invokestatic    gnu/kawa/slib/testing.$PcTestAnySpecifierMatches:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   120: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   123: ifeq            142
        //   126: aload_0         /* runner */
        //   127: getstatic       gnu/kawa/slib/testing.Lit1:Lgnu/mapping/SimpleSymbol;
        //   130: getstatic       gnu/kawa/slib/testing.Lit3:Lgnu/mapping/SimpleSymbol;
        //   133: invokestatic    gnu/kawa/slib/testing.testResultSet$Ex:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   136: getstatic       gnu/kawa/slib/testing.Lit3:Lgnu/mapping/SimpleSymbol;
        //   139: goto            145
        //   142: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   145: areturn        
        //   146: new             Lgnu/mapping/WrongType;
        //   149: dup_x1         
        //   150: swap           
        //   151: ldc_w           "%test-runner-run-list"
        //   154: iconst_0       
        //   155: aload_2        
        //   156: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   159: athrow         
        //   160: new             Lgnu/mapping/WrongType;
        //   163: dup_x1         
        //   164: swap           
        //   165: ldc_w           "%test-runner-skip-list"
        //   168: iconst_0       
        //   169: aload_3        
        //   170: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   173: athrow         
        //   174: new             Lgnu/mapping/WrongType;
        //   177: dup_x1         
        //   178: swap           
        //   179: ldc_w           "%test-runner-fail-list"
        //   182: iconst_0       
        //   183: aload_3        
        //   184: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   187: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     146    160    Ljava/lang/ClassCastException;
        //  70     73     160    174    Ljava/lang/ClassCastException;
        //  110    113    174    188    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 91 out of bounds for length 91
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object $PcTestRunnerRunList(final test-runner obj) {
        return obj.run$Mnlist;
    }
    
    static Object $PcTestAnySpecifierMatches(final Object list, final Object runner) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_2        /* result */
        //     2: aload_0         /* list */
        //     3: astore_3        /* l */
        //     4: aload_3         /* l */
        //     5: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //     8: ifeq            27
        //    11: iload_2         /* result */
        //    12: ifeq            21
        //    15: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    18: goto            74
        //    21: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    24: goto            74
        //    27: aload_3         /* l */
        //    28: ldc_w           Lgnu/lists/Pair;.class
        //    31: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    34: dup            
        //    35: astore          4
        //    37: checkcast       Lgnu/lists/Pair;
        //    40: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    43: aload_1         /* runner */
        //    44: invokestatic    gnu/kawa/slib/testing.$PcTestSpecifierMatches:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    47: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    50: ifeq            55
        //    53: iconst_1       
        //    54: istore_2        /* result */
        //    55: aload_3         /* l */
        //    56: ldc_w           Lgnu/lists/Pair;.class
        //    59: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    62: dup            
        //    63: astore          4
        //    65: checkcast       Lgnu/lists/Pair;
        //    68: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    71: goto            3
        //    74: areturn        
        //    75: new             Lgnu/mapping/WrongType;
        //    78: dup_x1         
        //    79: swap           
        //    80: ldc_w           "car"
        //    83: iconst_1       
        //    84: aload           4
        //    86: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    89: athrow         
        //    90: new             Lgnu/mapping/WrongType;
        //    93: dup_x1         
        //    94: swap           
        //    95: ldc_w           "cdr"
        //    98: iconst_1       
        //    99: aload           4
        //   101: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   104: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  37     40     75     90     Ljava/lang/ClassCastException;
        //  65     68     90     105    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0074:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
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
    
    public static void testResultSet$Ex(final Object runner, final Object pname, final Object value) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore          4
        //     9: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    12: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    15: astore_3        /* alist */
        //    16: aload_1         /* pname */
        //    17: aload_3         /* alist */
        //    18: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    21: astore          p
        //    23: aload           p
        //    25: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    28: ifeq            52
        //    31: aload           p
        //    33: ldc_w           Lgnu/lists/Pair;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore          5
        //    42: checkcast       Lgnu/lists/Pair;
        //    45: aload_2         /* value */
        //    46: invokestatic    kawa/lib/lists.setCdr$Ex:(Lgnu/lists/Pair;Ljava/lang/Object;)V
        //    49: goto            76
        //    52: aload_0         /* runner */
        //    53: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    55: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    58: dup            
        //    59: astore          5
        //    61: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    64: aload_1         /* pname */
        //    65: aload_2         /* value */
        //    66: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    69: aload_3         /* alist */
        //    70: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    73: invokestatic    gnu/kawa/slib/testing.testResultAlist$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    76: return         
        //    77: new             Lgnu/mapping/WrongType;
        //    80: dup_x1         
        //    81: swap           
        //    82: ldc_w           "test-result-alist"
        //    85: iconst_0       
        //    86: aload           4
        //    88: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    91: athrow         
        //    92: new             Lgnu/mapping/WrongType;
        //    95: dup_x1         
        //    96: swap           
        //    97: ldc_w           "set-cdr!"
        //   100: iconst_1       
        //   101: aload           5
        //   103: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   106: athrow         
        //   107: new             Lgnu/mapping/WrongType;
        //   110: dup_x1         
        //   111: swap           
        //   112: ldc             "test-result-alist!"
        //   114: iconst_0       
        //   115: aload           5
        //   117: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   120: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  9      12     77     92     Ljava/lang/ClassCastException;
        //  42     45     92     107    Ljava/lang/ClassCastException;
        //  61     64     107    121    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 61 out of bounds for length 61
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void $PcTestBegin(final Object suite$Mnname, final Object count) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
        //     6: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //     9: ifne            22
        //    12: getstatic       gnu/kawa/slib/testing.test$Mnrunner$Mncurrent:Lgnu/mapping/LocationProc;
        //    15: invokestatic    gnu/kawa/slib/testing.testRunnerCreate:()Ljava/lang/Object;
        //    18: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //    21: pop            
        //    22: getstatic       gnu/kawa/slib/testing.test$Mnrunner$Mncurrent:Lgnu/mapping/LocationProc;
        //    25: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
        //    28: astore_2        /* runner */
        //    29: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //    32: aload_2         /* runner */
        //    33: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    35: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    38: dup            
        //    39: astore_3       
        //    40: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    43: invokestatic    gnu/kawa/slib/testing.testRunnerOnGroupBegin:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    46: aload_2         /* runner */
        //    47: aload_0         /* suite$Mnname */
        //    48: aload_1         /* count */
        //    49: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    52: pop            
        //    53: aload_2         /* runner */
        //    54: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    56: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    59: dup            
        //    60: astore_3       
        //    61: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    64: aload_2         /* runner */
        //    65: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: dup            
        //    71: astore_3       
        //    72: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    75: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    78: aload_2         /* runner */
        //    79: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    81: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    84: dup            
        //    85: astore_3       
        //    86: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    89: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipSave:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    92: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    95: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipSave$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    98: aload_2         /* runner */
        //    99: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   101: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   104: dup            
        //   105: astore_3       
        //   106: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   109: aload_2         /* runner */
        //   110: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   115: dup            
        //   116: astore_3       
        //   117: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   120: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   123: aload_2         /* runner */
        //   124: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   126: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   129: dup            
        //   130: astore_3       
        //   131: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   134: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailSave:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   137: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   140: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailSave$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   143: aload_2         /* runner */
        //   144: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   146: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   149: dup            
        //   150: astore_3       
        //   151: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   154: aload_2         /* runner */
        //   155: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   157: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   160: dup            
        //   161: astore_3       
        //   162: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   165: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerTotalCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   168: aload_1         /* count */
        //   169: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   172: aload_2         /* runner */
        //   173: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   175: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   178: dup            
        //   179: astore_3       
        //   180: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   183: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerCountList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   186: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   189: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerCountList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   192: aload_2         /* runner */
        //   193: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   195: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   198: dup            
        //   199: astore_3       
        //   200: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   203: aload_0         /* suite$Mnname */
        //   204: aload_2         /* runner */
        //   205: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   207: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   210: dup            
        //   211: astore_3       
        //   212: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   215: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   218: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   221: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   224: return         
        //   225: new             Lgnu/mapping/WrongType;
        //   228: dup_x1         
        //   229: swap           
        //   230: ldc_w           "test-runner-on-group-begin"
        //   233: iconst_0       
        //   234: aload_3        
        //   235: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   238: athrow         
        //   239: new             Lgnu/mapping/WrongType;
        //   242: dup_x1         
        //   243: swap           
        //   244: ldc             "%test-runner-skip-save!"
        //   246: iconst_0       
        //   247: aload_3        
        //   248: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   251: athrow         
        //   252: new             Lgnu/mapping/WrongType;
        //   255: dup_x1         
        //   256: swap           
        //   257: ldc_w           "%test-runner-skip-list"
        //   260: iconst_0       
        //   261: aload_3        
        //   262: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   265: athrow         
        //   266: new             Lgnu/mapping/WrongType;
        //   269: dup_x1         
        //   270: swap           
        //   271: ldc_w           "%test-runner-skip-save"
        //   274: iconst_0       
        //   275: aload_3        
        //   276: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   279: athrow         
        //   280: new             Lgnu/mapping/WrongType;
        //   283: dup_x1         
        //   284: swap           
        //   285: ldc             "%test-runner-fail-save!"
        //   287: iconst_0       
        //   288: aload_3        
        //   289: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   292: athrow         
        //   293: new             Lgnu/mapping/WrongType;
        //   296: dup_x1         
        //   297: swap           
        //   298: ldc_w           "%test-runner-fail-list"
        //   301: iconst_0       
        //   302: aload_3        
        //   303: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   306: athrow         
        //   307: new             Lgnu/mapping/WrongType;
        //   310: dup_x1         
        //   311: swap           
        //   312: ldc_w           "%test-runner-fail-save"
        //   315: iconst_0       
        //   316: aload_3        
        //   317: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   320: athrow         
        //   321: new             Lgnu/mapping/WrongType;
        //   324: dup_x1         
        //   325: swap           
        //   326: ldc             "%test-runner-count-list!"
        //   328: iconst_0       
        //   329: aload_3        
        //   330: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   333: athrow         
        //   334: new             Lgnu/mapping/WrongType;
        //   337: dup_x1         
        //   338: swap           
        //   339: ldc_w           "%test-runner-total-count"
        //   342: iconst_0       
        //   343: aload_3        
        //   344: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   347: athrow         
        //   348: new             Lgnu/mapping/WrongType;
        //   351: dup_x1         
        //   352: swap           
        //   353: ldc_w           "%test-runner-count-list"
        //   356: iconst_0       
        //   357: aload_3        
        //   358: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   361: athrow         
        //   362: new             Lgnu/mapping/WrongType;
        //   365: dup_x1         
        //   366: swap           
        //   367: ldc             "test-runner-group-stack!"
        //   369: iconst_0       
        //   370: aload_3        
        //   371: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   374: athrow         
        //   375: new             Lgnu/mapping/WrongType;
        //   378: dup_x1         
        //   379: swap           
        //   380: ldc             "test-runner-group-stack"
        //   382: iconst_0       
        //   383: aload_3        
        //   384: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   387: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  40     43     225    239    Ljava/lang/ClassCastException;
        //  61     64     239    252    Ljava/lang/ClassCastException;
        //  72     75     252    266    Ljava/lang/ClassCastException;
        //  86     89     266    280    Ljava/lang/ClassCastException;
        //  106    109    280    293    Ljava/lang/ClassCastException;
        //  117    120    293    307    Ljava/lang/ClassCastException;
        //  131    134    307    321    Ljava/lang/ClassCastException;
        //  151    154    321    334    Ljava/lang/ClassCastException;
        //  162    165    334    348    Ljava/lang/ClassCastException;
        //  180    183    348    362    Ljava/lang/ClassCastException;
        //  200    203    362    375    Ljava/lang/ClassCastException;
        //  212    215    375    388    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 205 out of bounds for length 205
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static Object $PcTestRunnerSkipSave(final test-runner obj) {
        return obj.skip$Mnsave;
    }
    
    static Object $PcTestRunnerFailSave(final test-runner obj) {
        return obj.fail$Mnsave;
    }
    
    static Object $PcTestRunnerTotalCount(final test-runner obj) {
        return obj.total$Mncount;
    }
    
    static Object $PcTestRunnerCountList(final test-runner obj) {
        return obj.count$Mnlist;
    }
    
    public static boolean testOnGroupBeginSimple(final Object runner, final Object suite$Mnname, final Object count) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_3       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    14: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    17: ifeq            136
        //    20: ldc_w           "%%%% Starting test "
        //    23: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //    26: aload_1         /* suite$Mnname */
        //    27: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //    30: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    33: invokestatic    kawa/lib/strings.isString:(Ljava/lang/Object;)Z
        //    36: ifeq            45
        //    39: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    42: goto            62
        //    45: iconst_2       
        //    46: anewarray       Ljava/lang/Object;
        //    49: dup            
        //    50: iconst_0       
        //    51: aload_1         /* suite$Mnname */
        //    52: aastore        
        //    53: dup            
        //    54: iconst_1       
        //    55: ldc_w           ".log"
        //    58: aastore        
        //    59: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //    62: astore_3        /* log$Mnfile$Mnname */
        //    63: aload_3         /* log$Mnfile$Mnname */
        //    64: ldc_w           Lgnu/kawa/io/Path;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: dup            
        //    71: astore          5
        //    73: invokestatic    gnu/kawa/io/Path.valueOf:(Ljava/lang/Object;)Lgnu/kawa/io/Path;
        //    76: invokestatic    kawa/lib/ports.openOutputFile:(Lgnu/kawa/io/Path;)Lgnu/kawa/io/OutPort;
        //    79: astore          log$Mnfile
        //    81: ldc_w           "%%%% Starting test "
        //    84: aload           log$Mnfile
        //    86: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    89: aload_1         /* suite$Mnname */
        //    90: aload           log$Mnfile
        //    92: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    95: aload           log$Mnfile
        //    97: invokestatic    kawa/lib/ports.newline:(Ljava/lang/Object;)V
        //   100: aload_0         /* runner */
        //   101: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   103: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   106: dup            
        //   107: astore          5
        //   109: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   112: aload           log$Mnfile
        //   114: invokestatic    gnu/kawa/slib/testing.testRunnerAuxValue$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   117: ldc_w           "  (Writing full log to \""
        //   120: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   123: aload_3         /* log$Mnfile$Mnname */
        //   124: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   127: ldc_w           "\")"
        //   130: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   133: invokestatic    kawa/lib/ports.newline:()V
        //   136: aload_0         /* runner */
        //   137: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   139: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   142: dup            
        //   143: astore          4
        //   145: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   148: invokestatic    gnu/kawa/slib/testing.testRunnerAuxValue:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   151: astore_3        /* log */
        //   152: aload_3         /* log */
        //   153: invokestatic    kawa/lib/ports.isOutputPort:(Ljava/lang/Object;)Z
        //   156: ifeq            175
        //   159: ldc_w           "Group begin: "
        //   162: aload_3         /* log */
        //   163: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   166: aload_1         /* suite$Mnname */
        //   167: aload_3         /* log */
        //   168: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   171: aload_3         /* log */
        //   172: invokestatic    kawa/lib/ports.newline:(Ljava/lang/Object;)V
        //   175: iconst_0       
        //   176: ireturn        
        //   177: new             Lgnu/mapping/WrongType;
        //   180: dup_x1         
        //   181: swap           
        //   182: ldc             "test-runner-group-stack"
        //   184: iconst_0       
        //   185: aload_3        
        //   186: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   189: athrow         
        //   190: new             Lgnu/mapping/WrongType;
        //   193: dup_x1         
        //   194: swap           
        //   195: ldc_w           "open-output-file"
        //   198: iconst_1       
        //   199: aload           5
        //   201: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   204: athrow         
        //   205: new             Lgnu/mapping/WrongType;
        //   208: dup_x1         
        //   209: swap           
        //   210: ldc_w           "test-runner-aux-value!"
        //   213: iconst_0       
        //   214: aload           5
        //   216: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   219: athrow         
        //   220: new             Lgnu/mapping/WrongType;
        //   223: dup_x1         
        //   224: swap           
        //   225: ldc_w           "test-runner-aux-value"
        //   228: iconst_0       
        //   229: aload           4
        //   231: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   234: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     177    190    Ljava/lang/ClassCastException;
        //  73     76     190    205    Ljava/lang/ClassCastException;
        //  109    112    205    220    Ljava/lang/ClassCastException;
        //  145    148    220    235    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 114 out of bounds for length 114
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean testOnGroupEndSimple(final Object runner) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_2       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: invokestatic    gnu/kawa/slib/testing.testRunnerAuxValue:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    14: astore_1        /* log */
        //    15: aload_1         /* log */
        //    16: invokestatic    kawa/lib/ports.isOutputPort:(Ljava/lang/Object;)Z
        //    19: ifeq            65
        //    22: ldc_w           "Group end: "
        //    25: aload_1         /* log */
        //    26: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    29: aload_0         /* runner */
        //    30: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    32: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    35: dup            
        //    36: astore_2       
        //    37: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    40: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    43: ldc_w           Lgnu/lists/Pair;.class
        //    46: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    49: dup            
        //    50: astore_2       
        //    51: checkcast       Lgnu/lists/Pair;
        //    54: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    57: aload_1         /* log */
        //    58: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    61: aload_1         /* log */
        //    62: invokestatic    kawa/lib/ports.newline:(Ljava/lang/Object;)V
        //    65: iconst_0       
        //    66: ireturn        
        //    67: new             Lgnu/mapping/WrongType;
        //    70: dup_x1         
        //    71: swap           
        //    72: ldc_w           "test-runner-aux-value"
        //    75: iconst_0       
        //    76: aload_2        
        //    77: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    80: athrow         
        //    81: new             Lgnu/mapping/WrongType;
        //    84: dup_x1         
        //    85: swap           
        //    86: ldc             "test-runner-group-stack"
        //    88: iconst_0       
        //    89: aload_2        
        //    90: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    93: athrow         
        //    94: new             Lgnu/mapping/WrongType;
        //    97: dup_x1         
        //    98: swap           
        //    99: ldc_w           "car"
        //   102: iconst_1       
        //   103: aload_2        
        //   104: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   107: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     67     81     Ljava/lang/ClassCastException;
        //  37     40     81     94     Ljava/lang/ClassCastException;
        //  51     54     94     108    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 57 out of bounds for length 57
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void testOnBadCountSimple(final Object runner, final Object count, final Object expected$Mncount) {
        $PcTestOnBadCountWrite(runner, count, expected$Mncount, ports.current$Mnoutput$Mnport.getValue());
        final Object force = Promise.force(runner, test-runner.class);
        try {
            final Object log = testRunnerAuxValue((test-runner)force);
            if (ports.isOutputPort(log)) {
                $PcTestOnBadCountWrite(runner, count, expected$Mncount, log);
            }
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "test-runner-aux-value", 0, force);
        }
    }
    
    static void $PcTestOnBadCountWrite(final Object runner, final Object count, final Object expected$Mncount, final Object port) {
        ports.display("*** Total number of tests was ", port);
        ports.display(count, port);
        ports.display(" but should be ", port);
        ports.display(expected$Mncount, port);
        ports.display(". ***", port);
        ports.newline(port);
        ports.display("*** Discrepancy indicates testsuite error or exceptions. ***", port);
        ports.newline(port);
    }
    
    public static Type.NeverReturns testOnBadEndNameSimple(final Object runner, final Object begin$Mnname, final Object end$Mnname) {
        final FString msg = strings.stringAppend($PcTestFormatLine(runner), "test-end ", begin$Mnname, " does not match test-begin ", end$Mnname);
        exceptions.error(msg);
        throw Special.reachedUnexpected;
    }
    
    static Object $PcTestFormatLine(final Object runner) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_2       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    14: astore_1        /* line$Mninfo */
        //    15: getstatic       gnu/kawa/slib/testing.Lit4:Lgnu/mapping/SimpleSymbol;
        //    18: aload_1         /* line$Mninfo */
        //    19: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    22: astore_2        /* source$Mnfile */
        //    23: getstatic       gnu/kawa/slib/testing.Lit5:Lgnu/mapping/SimpleSymbol;
        //    26: aload_1         /* line$Mninfo */
        //    27: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    30: astore_3        /* source$Mnline */
        //    31: aload_2         /* source$Mnfile */
        //    32: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    35: ifeq            57
        //    38: aload_2         /* source$Mnfile */
        //    39: ldc_w           Lgnu/lists/Pair;.class
        //    42: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    45: dup            
        //    46: astore          5
        //    48: checkcast       Lgnu/lists/Pair;
        //    51: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    54: goto            60
        //    57: ldc_w           ""
        //    60: astore          file
        //    62: aload_3         /* source$Mnline */
        //    63: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    66: ifeq            130
        //    69: iconst_4       
        //    70: anewarray       Ljava/lang/Object;
        //    73: dup            
        //    74: iconst_0       
        //    75: aload           file
        //    77: aastore        
        //    78: dup            
        //    79: iconst_1       
        //    80: ldc_w           ":"
        //    83: aastore        
        //    84: dup            
        //    85: iconst_2       
        //    86: aload_3         /* source$Mnline */
        //    87: ldc_w           Lgnu/lists/Pair;.class
        //    90: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    93: dup            
        //    94: astore          5
        //    96: checkcast       Lgnu/lists/Pair;
        //    99: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   102: ldc_w           Ljava/lang/Number;.class
        //   105: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   108: dup            
        //   109: astore          5
        //   111: checkcast       Ljava/lang/Number;
        //   114: invokestatic    kawa/lib/numbers.number$To$String:(Ljava/lang/Number;)Ljava/lang/CharSequence;
        //   117: aastore        
        //   118: dup            
        //   119: iconst_3       
        //   120: ldc_w           ": "
        //   123: aastore        
        //   124: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //   127: goto            133
        //   130: ldc_w           ""
        //   133: areturn        
        //   134: new             Lgnu/mapping/WrongType;
        //   137: dup_x1         
        //   138: swap           
        //   139: ldc_w           "test-result-alist"
        //   142: iconst_0       
        //   143: aload_2        
        //   144: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   147: athrow         
        //   148: new             Lgnu/mapping/WrongType;
        //   151: dup_x1         
        //   152: swap           
        //   153: ldc_w           "cdr"
        //   156: iconst_1       
        //   157: aload           5
        //   159: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   162: athrow         
        //   163: new             Lgnu/mapping/WrongType;
        //   166: dup_x1         
        //   167: swap           
        //   168: ldc_w           "cdr"
        //   171: iconst_1       
        //   172: aload           5
        //   174: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   177: athrow         
        //   178: new             Lgnu/mapping/WrongType;
        //   181: dup_x1         
        //   182: swap           
        //   183: ldc_w           "number->string"
        //   186: iconst_1       
        //   187: aload           5
        //   189: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   192: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     134    148    Ljava/lang/ClassCastException;
        //  48     51     148    163    Ljava/lang/ClassCastException;
        //  96     99     163    178    Ljava/lang/ClassCastException;
        //  111    114    178    193    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 98 out of bounds for length 98
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void testOnFinalSimple(final Object runner) {
        $PcTestFinalReportSimple(runner, ports.current$Mnoutput$Mnport.getValue());
        final Object force = Promise.force(runner, test-runner.class);
        try {
            final Object log = testRunnerAuxValue((test-runner)force);
            if (ports.isOutputPort(log)) {
                $PcTestFinalReportSimple(runner, log);
            }
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "test-runner-aux-value", 0, force);
        }
    }
    
    static void $PcTestFinalReportSimple(final Object runner, final Object port) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_2       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: invokestatic    gnu/kawa/slib/testing.testRunnerPassCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    14: ldc_w           "# of expected passes      "
        //    17: aload_1         /* port */
        //    18: invokestatic    gnu/kawa/slib/testing.$PcTestFinalReport1:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    21: aload_0         /* runner */
        //    22: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    24: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    27: dup            
        //    28: astore_2       
        //    29: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    32: invokestatic    gnu/kawa/slib/testing.testRunnerXfailCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    35: ldc_w           "# of expected failures    "
        //    38: aload_1         /* port */
        //    39: invokestatic    gnu/kawa/slib/testing.$PcTestFinalReport1:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    42: aload_0         /* runner */
        //    43: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    45: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    48: dup            
        //    49: astore_2       
        //    50: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    53: invokestatic    gnu/kawa/slib/testing.testRunnerXpassCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    56: ldc_w           "# of unexpected successes "
        //    59: aload_1         /* port */
        //    60: invokestatic    gnu/kawa/slib/testing.$PcTestFinalReport1:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    63: aload_0         /* runner */
        //    64: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    66: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    69: dup            
        //    70: astore_2       
        //    71: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    74: invokestatic    gnu/kawa/slib/testing.testRunnerFailCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    77: ldc_w           "# of unexpected failures  "
        //    80: aload_1         /* port */
        //    81: invokestatic    gnu/kawa/slib/testing.$PcTestFinalReport1:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    84: aload_0         /* runner */
        //    85: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    87: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    90: dup            
        //    91: astore_2       
        //    92: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    95: invokestatic    gnu/kawa/slib/testing.testRunnerSkipCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    98: ldc_w           "# of skipped tests        "
        //   101: aload_1         /* port */
        //   102: invokestatic    gnu/kawa/slib/testing.$PcTestFinalReport1:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //   105: return         
        //   106: new             Lgnu/mapping/WrongType;
        //   109: dup_x1         
        //   110: swap           
        //   111: ldc_w           "test-runner-pass-count"
        //   114: iconst_0       
        //   115: aload_2        
        //   116: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   119: athrow         
        //   120: new             Lgnu/mapping/WrongType;
        //   123: dup_x1         
        //   124: swap           
        //   125: ldc_w           "test-runner-xfail-count"
        //   128: iconst_0       
        //   129: aload_2        
        //   130: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   133: athrow         
        //   134: new             Lgnu/mapping/WrongType;
        //   137: dup_x1         
        //   138: swap           
        //   139: ldc_w           "test-runner-xpass-count"
        //   142: iconst_0       
        //   143: aload_2        
        //   144: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   147: athrow         
        //   148: new             Lgnu/mapping/WrongType;
        //   151: dup_x1         
        //   152: swap           
        //   153: ldc_w           "test-runner-fail-count"
        //   156: iconst_0       
        //   157: aload_2        
        //   158: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   161: athrow         
        //   162: new             Lgnu/mapping/WrongType;
        //   165: dup_x1         
        //   166: swap           
        //   167: ldc_w           "test-runner-skip-count"
        //   170: iconst_0       
        //   171: aload_2        
        //   172: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   175: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     106    120    Ljava/lang/ClassCastException;
        //  29     32     120    134    Ljava/lang/ClassCastException;
        //  50     53     134    148    Ljava/lang/ClassCastException;
        //  71     74     148    162    Ljava/lang/ClassCastException;
        //  92     95     162    176    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 91 out of bounds for length 91
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object $PcTestEnd(final Object suite$Mnname, final Object line$Mninfo) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_2        /* r */
        //     4: aload_2         /* r */
        //     5: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     7: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    10: dup            
        //    11: astore          4
        //    13: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    16: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    19: astore_3        /* groups */
        //    20: aload_2         /* r */
        //    21: invokestatic    gnu/kawa/slib/testing.$PcTestFormatLine:(Ljava/lang/Object;)Ljava/lang/Object;
        //    24: astore          line
        //    26: aload_2         /* r */
        //    27: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    29: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    32: dup            
        //    33: astore          5
        //    35: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    38: aload_1         /* line$Mninfo */
        //    39: invokestatic    gnu/kawa/slib/testing.testResultAlist$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    42: aload_3         /* groups */
        //    43: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //    46: ifeq            85
        //    49: iconst_2       
        //    50: anewarray       Ljava/lang/Object;
        //    53: dup            
        //    54: iconst_0       
        //    55: aload           line
        //    57: aastore        
        //    58: dup            
        //    59: iconst_1       
        //    60: ldc_w           "test-end not in a group"
        //    63: aastore        
        //    64: invokestatic    kawa/lib/strings.stringAppend:([Ljava/lang/Object;)Lgnu/lists/FString;
        //    67: astore          msg
        //    69: iconst_1       
        //    70: anewarray       Ljava/lang/Object;
        //    73: dup            
        //    74: iconst_0       
        //    75: aload           msg
        //    77: aastore        
        //    78: invokestatic    kawa/lib/exceptions.error:([Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    81: getstatic       gnu/expr/Special.reachedUnexpected:Ljava/lang/RuntimeException;
        //    84: athrow         
        //    85: aload_0         /* suite$Mnname */
        //    86: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    89: ifeq            164
        //    92: getstatic       kawa/standard/Scheme.isEqual:Lgnu/kawa/functions/IsEqual;
        //    95: aload_0         /* suite$Mnname */
        //    96: aload_3         /* groups */
        //    97: ldc_w           Lgnu/lists/Pair;.class
        //   100: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   103: dup            
        //   104: astore          5
        //   106: checkcast       Lgnu/lists/Pair;
        //   109: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   112: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   115: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   118: ifne            164
        //   121: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   124: aload_2         /* r */
        //   125: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   127: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   130: dup            
        //   131: astore          5
        //   133: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   136: invokestatic    gnu/kawa/slib/testing.testRunnerOnBadEndName:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   139: aload_2         /* r */
        //   140: aload_0         /* suite$Mnname */
        //   141: aload_3         /* groups */
        //   142: ldc_w           Lgnu/lists/Pair;.class
        //   145: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   148: dup            
        //   149: astore          5
        //   151: checkcast       Lgnu/lists/Pair;
        //   154: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   157: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   160: pop            
        //   161: goto            164
        //   164: aload_2         /* r */
        //   165: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   167: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   170: dup            
        //   171: astore          6
        //   173: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   176: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerCountList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   179: astore          count$Mnlist
        //   181: aload           count$Mnlist
        //   183: invokestatic    kawa/lib/lists.cdar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   186: astore          expected$Mncount
        //   188: aload           count$Mnlist
        //   190: invokestatic    kawa/lib/lists.caar:(Ljava/lang/Object;)Ljava/lang/Object;
        //   193: astore          saved$Mncount
        //   195: iconst_m1      
        //   196: aload_2         /* r */
        //   197: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   199: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   202: dup            
        //   203: astore          9
        //   205: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   208: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerTotalCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   211: aload           saved$Mncount
        //   213: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   216: astore          group$Mncount
        //   218: aload           expected$Mncount
        //   220: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   223: ifeq            266
        //   226: aload           expected$Mncount
        //   228: aload           group$Mncount
        //   230: invokestatic    gnu/kawa/functions/NumberCompare.$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   233: ifne            266
        //   236: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   239: aload_2         /* r */
        //   240: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   242: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   245: dup            
        //   246: astore          9
        //   248: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   251: invokestatic    gnu/kawa/slib/testing.testRunnerOnBadCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   254: aload_2         /* r */
        //   255: aload           group$Mncount
        //   257: aload           expected$Mncount
        //   259: invokevirtual   gnu/mapping/Procedure.apply4:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   262: pop            
        //   263: goto            266
        //   266: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   269: aload_2         /* r */
        //   270: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   272: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   275: dup            
        //   276: astore          9
        //   278: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   281: invokestatic    gnu/kawa/slib/testing.testRunnerOnGroupEnd:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   284: aload_2         /* r */
        //   285: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   288: pop            
        //   289: aload_2         /* r */
        //   290: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   292: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   295: dup            
        //   296: astore          9
        //   298: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   301: aload_2         /* r */
        //   302: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   304: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   307: dup            
        //   308: astore          9
        //   310: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   313: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   316: ldc_w           Lgnu/lists/Pair;.class
        //   319: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   322: dup            
        //   323: astore          9
        //   325: checkcast       Lgnu/lists/Pair;
        //   328: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   331: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   334: aload_2         /* r */
        //   335: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   337: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   340: dup            
        //   341: astore          9
        //   343: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   346: aload_2         /* r */
        //   347: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   349: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   352: dup            
        //   353: astore          9
        //   355: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   358: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipSave:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   361: ldc_w           Lgnu/lists/Pair;.class
        //   364: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   367: dup            
        //   368: astore          9
        //   370: checkcast       Lgnu/lists/Pair;
        //   373: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   376: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   379: aload_2         /* r */
        //   380: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   382: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   385: dup            
        //   386: astore          9
        //   388: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   391: aload_2         /* r */
        //   392: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   394: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   397: dup            
        //   398: astore          9
        //   400: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   403: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipSave:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   406: ldc_w           Lgnu/lists/Pair;.class
        //   409: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   412: dup            
        //   413: astore          9
        //   415: checkcast       Lgnu/lists/Pair;
        //   418: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   421: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipSave$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   424: aload_2         /* r */
        //   425: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   427: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   430: dup            
        //   431: astore          9
        //   433: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   436: aload_2         /* r */
        //   437: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   439: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   442: dup            
        //   443: astore          9
        //   445: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   448: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailSave:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   451: ldc_w           Lgnu/lists/Pair;.class
        //   454: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   457: dup            
        //   458: astore          9
        //   460: checkcast       Lgnu/lists/Pair;
        //   463: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   466: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   469: aload_2         /* r */
        //   470: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   472: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   475: dup            
        //   476: astore          9
        //   478: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   481: aload_2         /* r */
        //   482: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   484: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   487: dup            
        //   488: astore          9
        //   490: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   493: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailSave:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   496: ldc_w           Lgnu/lists/Pair;.class
        //   499: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   502: dup            
        //   503: astore          9
        //   505: checkcast       Lgnu/lists/Pair;
        //   508: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   511: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailSave$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   514: aload_2         /* r */
        //   515: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   517: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   520: dup            
        //   521: astore          9
        //   523: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   526: aload           count$Mnlist
        //   528: ldc_w           Lgnu/lists/Pair;.class
        //   531: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   534: dup            
        //   535: astore          9
        //   537: checkcast       Lgnu/lists/Pair;
        //   540: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   543: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerCountList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   546: aload_2         /* r */
        //   547: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   549: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   552: dup            
        //   553: astore          9
        //   555: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   558: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   561: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   564: ifeq            592
        //   567: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   570: aload_2         /* r */
        //   571: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   573: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   576: dup            
        //   577: astore          9
        //   579: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   582: invokestatic    gnu/kawa/slib/testing.testRunnerOnFinal:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   585: aload_2         /* r */
        //   586: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   589: goto            595
        //   592: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   595: areturn        
        //   596: new             Lgnu/mapping/WrongType;
        //   599: dup_x1         
        //   600: swap           
        //   601: ldc             "test-runner-group-stack"
        //   603: iconst_0       
        //   604: aload           4
        //   606: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   609: athrow         
        //   610: new             Lgnu/mapping/WrongType;
        //   613: dup_x1         
        //   614: swap           
        //   615: ldc             "test-result-alist!"
        //   617: iconst_0       
        //   618: aload           5
        //   620: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   623: athrow         
        //   624: new             Lgnu/mapping/WrongType;
        //   627: dup_x1         
        //   628: swap           
        //   629: ldc_w           "car"
        //   632: iconst_1       
        //   633: aload           5
        //   635: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   638: athrow         
        //   639: new             Lgnu/mapping/WrongType;
        //   642: dup_x1         
        //   643: swap           
        //   644: ldc_w           "test-runner-on-bad-end-name"
        //   647: iconst_0       
        //   648: aload           5
        //   650: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   653: athrow         
        //   654: new             Lgnu/mapping/WrongType;
        //   657: dup_x1         
        //   658: swap           
        //   659: ldc_w           "car"
        //   662: iconst_1       
        //   663: aload           5
        //   665: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   668: athrow         
        //   669: new             Lgnu/mapping/WrongType;
        //   672: dup_x1         
        //   673: swap           
        //   674: ldc_w           "%test-runner-count-list"
        //   677: iconst_0       
        //   678: aload           6
        //   680: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   683: athrow         
        //   684: new             Lgnu/mapping/WrongType;
        //   687: dup_x1         
        //   688: swap           
        //   689: ldc_w           "%test-runner-total-count"
        //   692: iconst_0       
        //   693: aload           9
        //   695: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   698: athrow         
        //   699: new             Lgnu/mapping/WrongType;
        //   702: dup_x1         
        //   703: swap           
        //   704: ldc_w           "test-runner-on-bad-count"
        //   707: iconst_0       
        //   708: aload           9
        //   710: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   713: athrow         
        //   714: new             Lgnu/mapping/WrongType;
        //   717: dup_x1         
        //   718: swap           
        //   719: ldc_w           "test-runner-on-group-end"
        //   722: iconst_0       
        //   723: aload           9
        //   725: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   728: athrow         
        //   729: new             Lgnu/mapping/WrongType;
        //   732: dup_x1         
        //   733: swap           
        //   734: ldc             "test-runner-group-stack!"
        //   736: iconst_0       
        //   737: aload           9
        //   739: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   742: athrow         
        //   743: new             Lgnu/mapping/WrongType;
        //   746: dup_x1         
        //   747: swap           
        //   748: ldc             "test-runner-group-stack"
        //   750: iconst_0       
        //   751: aload           9
        //   753: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   756: athrow         
        //   757: new             Lgnu/mapping/WrongType;
        //   760: dup_x1         
        //   761: swap           
        //   762: ldc_w           "cdr"
        //   765: iconst_1       
        //   766: aload           9
        //   768: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   771: athrow         
        //   772: new             Lgnu/mapping/WrongType;
        //   775: dup_x1         
        //   776: swap           
        //   777: ldc             "%test-runner-skip-list!"
        //   779: iconst_0       
        //   780: aload           9
        //   782: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   785: athrow         
        //   786: new             Lgnu/mapping/WrongType;
        //   789: dup_x1         
        //   790: swap           
        //   791: ldc_w           "%test-runner-skip-save"
        //   794: iconst_0       
        //   795: aload           9
        //   797: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   800: athrow         
        //   801: new             Lgnu/mapping/WrongType;
        //   804: dup_x1         
        //   805: swap           
        //   806: ldc_w           "car"
        //   809: iconst_1       
        //   810: aload           9
        //   812: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   815: athrow         
        //   816: new             Lgnu/mapping/WrongType;
        //   819: dup_x1         
        //   820: swap           
        //   821: ldc             "%test-runner-skip-save!"
        //   823: iconst_0       
        //   824: aload           9
        //   826: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   829: athrow         
        //   830: new             Lgnu/mapping/WrongType;
        //   833: dup_x1         
        //   834: swap           
        //   835: ldc_w           "%test-runner-skip-save"
        //   838: iconst_0       
        //   839: aload           9
        //   841: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   844: athrow         
        //   845: new             Lgnu/mapping/WrongType;
        //   848: dup_x1         
        //   849: swap           
        //   850: ldc_w           "cdr"
        //   853: iconst_1       
        //   854: aload           9
        //   856: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   859: athrow         
        //   860: new             Lgnu/mapping/WrongType;
        //   863: dup_x1         
        //   864: swap           
        //   865: ldc             "%test-runner-fail-list!"
        //   867: iconst_0       
        //   868: aload           9
        //   870: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   873: athrow         
        //   874: new             Lgnu/mapping/WrongType;
        //   877: dup_x1         
        //   878: swap           
        //   879: ldc_w           "%test-runner-fail-save"
        //   882: iconst_0       
        //   883: aload           9
        //   885: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   888: athrow         
        //   889: new             Lgnu/mapping/WrongType;
        //   892: dup_x1         
        //   893: swap           
        //   894: ldc_w           "car"
        //   897: iconst_1       
        //   898: aload           9
        //   900: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   903: athrow         
        //   904: new             Lgnu/mapping/WrongType;
        //   907: dup_x1         
        //   908: swap           
        //   909: ldc             "%test-runner-fail-save!"
        //   911: iconst_0       
        //   912: aload           9
        //   914: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   917: athrow         
        //   918: new             Lgnu/mapping/WrongType;
        //   921: dup_x1         
        //   922: swap           
        //   923: ldc_w           "%test-runner-fail-save"
        //   926: iconst_0       
        //   927: aload           9
        //   929: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   932: athrow         
        //   933: new             Lgnu/mapping/WrongType;
        //   936: dup_x1         
        //   937: swap           
        //   938: ldc_w           "cdr"
        //   941: iconst_1       
        //   942: aload           9
        //   944: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   947: athrow         
        //   948: new             Lgnu/mapping/WrongType;
        //   951: dup_x1         
        //   952: swap           
        //   953: ldc             "%test-runner-count-list!"
        //   955: iconst_0       
        //   956: aload           9
        //   958: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   961: athrow         
        //   962: new             Lgnu/mapping/WrongType;
        //   965: dup_x1         
        //   966: swap           
        //   967: ldc_w           "cdr"
        //   970: iconst_1       
        //   971: aload           9
        //   973: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   976: athrow         
        //   977: new             Lgnu/mapping/WrongType;
        //   980: dup_x1         
        //   981: swap           
        //   982: ldc             "test-runner-group-stack"
        //   984: iconst_0       
        //   985: aload           9
        //   987: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   990: athrow         
        //   991: new             Lgnu/mapping/WrongType;
        //   994: dup_x1         
        //   995: swap           
        //   996: ldc_w           "test-runner-on-final"
        //   999: iconst_0       
        //  1000: aload           9
        //  1002: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //  1005: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  13     16     596    610    Ljava/lang/ClassCastException;
        //  35     38     610    624    Ljava/lang/ClassCastException;
        //  106    109    624    639    Ljava/lang/ClassCastException;
        //  133    136    639    654    Ljava/lang/ClassCastException;
        //  151    154    654    669    Ljava/lang/ClassCastException;
        //  173    176    669    684    Ljava/lang/ClassCastException;
        //  205    208    684    699    Ljava/lang/ClassCastException;
        //  248    251    699    714    Ljava/lang/ClassCastException;
        //  278    281    714    729    Ljava/lang/ClassCastException;
        //  298    301    729    743    Ljava/lang/ClassCastException;
        //  310    313    743    757    Ljava/lang/ClassCastException;
        //  325    328    757    772    Ljava/lang/ClassCastException;
        //  343    346    772    786    Ljava/lang/ClassCastException;
        //  355    358    786    801    Ljava/lang/ClassCastException;
        //  370    373    801    816    Ljava/lang/ClassCastException;
        //  388    391    816    830    Ljava/lang/ClassCastException;
        //  400    403    830    845    Ljava/lang/ClassCastException;
        //  415    418    845    860    Ljava/lang/ClassCastException;
        //  433    436    860    874    Ljava/lang/ClassCastException;
        //  445    448    874    889    Ljava/lang/ClassCastException;
        //  460    463    889    904    Ljava/lang/ClassCastException;
        //  478    481    904    918    Ljava/lang/ClassCastException;
        //  490    493    918    933    Ljava/lang/ClassCastException;
        //  505    508    933    948    Ljava/lang/ClassCastException;
        //  523    526    948    962    Ljava/lang/ClassCastException;
        //  537    540    962    977    Ljava/lang/ClassCastException;
        //  555    558    977    991    Ljava/lang/ClassCastException;
        //  579    582    991    1006   Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 497 out of bounds for length 497
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static void testOnTestBeginSimple(final Object runner) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_2       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: invokestatic    gnu/kawa/slib/testing.testRunnerAuxValue:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    14: astore_1        /* log */
        //    15: aload_1         /* log */
        //    16: invokestatic    kawa/lib/ports.isOutputPort:(Ljava/lang/Object;)Z
        //    19: ifeq            140
        //    22: aload_0         /* runner */
        //    23: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    25: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    28: dup            
        //    29: astore_3       
        //    30: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    33: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    36: astore_2        /* results */
        //    37: getstatic       gnu/kawa/slib/testing.Lit4:Lgnu/mapping/SimpleSymbol;
        //    40: aload_2         /* results */
        //    41: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    44: astore_3        /* source$Mnfile */
        //    45: getstatic       gnu/kawa/slib/testing.Lit5:Lgnu/mapping/SimpleSymbol;
        //    48: aload_2         /* results */
        //    49: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    52: astore          source$Mnline
        //    54: getstatic       gnu/kawa/slib/testing.Lit6:Lgnu/mapping/SimpleSymbol;
        //    57: aload_2         /* results */
        //    58: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    61: astore          source$Mnform
        //    63: getstatic       gnu/kawa/slib/testing.Lit7:Lgnu/mapping/SimpleSymbol;
        //    66: aload_2         /* results */
        //    67: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    70: astore          test$Mnname
        //    72: ldc_w           "Test begin:"
        //    75: aload_1         /* log */
        //    76: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    79: aload_1         /* log */
        //    80: invokestatic    kawa/lib/ports.newline:(Ljava/lang/Object;)V
        //    83: aload           test$Mnname
        //    85: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    88: ifeq            97
        //    91: aload           test$Mnname
        //    93: aload_1         /* log */
        //    94: invokestatic    gnu/kawa/slib/testing.$PcTestWriteResult1:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    97: aload_3         /* source$Mnfile */
        //    98: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   101: ifeq            109
        //   104: aload_3         /* source$Mnfile */
        //   105: aload_1         /* log */
        //   106: invokestatic    gnu/kawa/slib/testing.$PcTestWriteResult1:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   109: aload           source$Mnline
        //   111: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   114: ifeq            123
        //   117: aload           source$Mnline
        //   119: aload_1         /* log */
        //   120: invokestatic    gnu/kawa/slib/testing.$PcTestWriteResult1:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   123: aload           source$Mnform
        //   125: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   128: ifeq            140
        //   131: aload           source$Mnform
        //   133: aload_1         /* log */
        //   134: invokestatic    gnu/kawa/slib/testing.$PcTestWriteResult1:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   137: goto            140
        //   140: return         
        //   141: new             Lgnu/mapping/WrongType;
        //   144: dup_x1         
        //   145: swap           
        //   146: ldc_w           "test-runner-aux-value"
        //   149: iconst_0       
        //   150: aload_2        
        //   151: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   154: athrow         
        //   155: new             Lgnu/mapping/WrongType;
        //   158: dup_x1         
        //   159: swap           
        //   160: ldc_w           "test-result-alist"
        //   163: iconst_0       
        //   164: aload_3        
        //   165: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   168: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     141    155    Ljava/lang/ClassCastException;
        //  30     33     155    169    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0097:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
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
    
    static void $PcTestWriteResult1(final Object pair, final Object port) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_1         /* port */
        //     4: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //     7: aload_0         /* pair */
        //     8: ldc_w           Lgnu/lists/Pair;.class
        //    11: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    14: dup            
        //    15: astore_2       
        //    16: checkcast       Lgnu/lists/Pair;
        //    19: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    22: aload_1         /* port */
        //    23: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    26: ldc_w           ": "
        //    29: aload_1         /* port */
        //    30: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //    33: aload_0         /* pair */
        //    34: ldc_w           Lgnu/lists/Pair;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore_2       
        //    42: checkcast       Lgnu/lists/Pair;
        //    45: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    48: aload_1         /* port */
        //    49: ldc_w           Lgnu/kawa/io/OutPort;.class
        //    52: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    55: dup            
        //    56: astore_2       
        //    57: checkcast       Lgnu/kawa/io/OutPort;
        //    60: invokestatic    kawa/lib/ports.write:(Ljava/lang/Object;Lgnu/kawa/io/OutPort;)V
        //    63: aload_1         /* port */
        //    64: invokestatic    kawa/lib/ports.newline:(Ljava/lang/Object;)V
        //    67: return         
        //    68: new             Lgnu/mapping/WrongType;
        //    71: dup_x1         
        //    72: swap           
        //    73: ldc_w           "car"
        //    76: iconst_1       
        //    77: aload_2        
        //    78: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    81: athrow         
        //    82: new             Lgnu/mapping/WrongType;
        //    85: dup_x1         
        //    86: swap           
        //    87: ldc_w           "cdr"
        //    90: iconst_1       
        //    91: aload_2        
        //    92: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    95: athrow         
        //    96: new             Lgnu/mapping/WrongType;
        //    99: dup_x1         
        //   100: swap           
        //   101: ldc_w           "write"
        //   104: iconst_2       
        //   105: aload_2        
        //   106: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   109: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  16     19     68     82     Ljava/lang/ClassCastException;
        //  42     45     82     96     Ljava/lang/ClassCastException;
        //  57     60     96     110    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 56 out of bounds for length 56
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object testOnTestEndSimple(final Object runner) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_2       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: invokestatic    gnu/kawa/slib/testing.testRunnerAuxValue:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    14: astore_1       
        //    15: getstatic       gnu/kawa/slib/testing.Lit1:Lgnu/mapping/SimpleSymbol;
        //    18: aload_0         /* runner */
        //    19: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    21: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    24: dup            
        //    25: astore          4
        //    27: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    30: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    33: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    36: astore_3        /* p */
        //    37: aload_3         /* p */
        //    38: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    41: ifeq            63
        //    44: aload_3         /* p */
        //    45: ldc_w           Lgnu/lists/Pair;.class
        //    48: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    51: dup            
        //    52: astore          4
        //    54: checkcast       Lgnu/lists/Pair;
        //    57: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    60: goto            66
        //    63: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    66: astore_2        /* kind */
        //    67: aload_2         /* kind */
        //    68: getstatic       gnu/kawa/slib/testing.Lit8:Lgnu/lists/PairWithPosition;
        //    71: invokestatic    kawa/lib/lists.memq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    74: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    77: ifeq            274
        //    80: aload_0         /* runner */
        //    81: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    83: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    86: dup            
        //    87: astore          4
        //    89: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    92: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    95: astore_3        /* results */
        //    96: getstatic       gnu/kawa/slib/testing.Lit4:Lgnu/mapping/SimpleSymbol;
        //    99: aload_3         /* results */
        //   100: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: astore          source$Mnfile
        //   105: getstatic       gnu/kawa/slib/testing.Lit5:Lgnu/mapping/SimpleSymbol;
        //   108: aload_3         /* results */
        //   109: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   112: astore          source$Mnline
        //   114: getstatic       gnu/kawa/slib/testing.Lit7:Lgnu/mapping/SimpleSymbol;
        //   117: aload_3         /* results */
        //   118: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   121: astore          test$Mnname
        //   123: aload           source$Mnfile
        //   125: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   128: ifeq            142
        //   131: aload           source$Mnfile
        //   133: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   136: ifeq            218
        //   139: goto            150
        //   142: aload           source$Mnline
        //   144: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   147: ifeq            218
        //   150: aload           source$Mnfile
        //   152: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   155: ifeq            178
        //   158: aload           source$Mnfile
        //   160: ldc_w           Lgnu/lists/Pair;.class
        //   163: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   166: dup            
        //   167: astore          7
        //   169: checkcast       Lgnu/lists/Pair;
        //   172: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   175: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   178: ldc_w           ":"
        //   181: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   184: aload           source$Mnline
        //   186: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   189: ifeq            212
        //   192: aload           source$Mnline
        //   194: ldc_w           Lgnu/lists/Pair;.class
        //   197: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   200: dup            
        //   201: astore          7
        //   203: checkcast       Lgnu/lists/Pair;
        //   206: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   209: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   212: ldc_w           ": "
        //   215: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   218: aload_2         /* kind */
        //   219: getstatic       gnu/kawa/slib/testing.Lit9:Lgnu/mapping/SimpleSymbol;
        //   222: if_acmpne       231
        //   225: ldc_w           "XPASS"
        //   228: goto            234
        //   231: ldc_w           "FAIL"
        //   234: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   237: aload           test$Mnname
        //   239: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   242: ifeq            271
        //   245: ldc_w           " "
        //   248: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   251: aload           test$Mnname
        //   253: ldc_w           Lgnu/lists/Pair;.class
        //   256: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   259: dup            
        //   260: astore          7
        //   262: checkcast       Lgnu/lists/Pair;
        //   265: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   268: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;)V
        //   271: invokestatic    kawa/lib/ports.newline:()V
        //   274: aload_1         /* log */
        //   275: invokestatic    kawa/lib/ports.isOutputPort:(Ljava/lang/Object;)Z
        //   278: ifeq            392
        //   281: ldc_w           "Test end:"
        //   284: aload_1         /* log */
        //   285: invokestatic    kawa/lib/ports.display:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   288: aload_1         /* log */
        //   289: invokestatic    kawa/lib/ports.newline:(Ljava/lang/Object;)V
        //   292: aload_0         /* runner */
        //   293: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   295: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   298: dup            
        //   299: astore_3       
        //   300: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   303: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   306: astore_3        /* list */
        //   307: aload_3         /* list */
        //   308: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //   311: ifeq            386
        //   314: aload_3         /* list */
        //   315: ldc_w           Lgnu/lists/Pair;.class
        //   318: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   321: dup            
        //   322: astore          5
        //   324: checkcast       Lgnu/lists/Pair;
        //   327: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   330: astore          pair
        //   332: aload           pair
        //   334: ldc_w           Lgnu/lists/Pair;.class
        //   337: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   340: dup            
        //   341: astore          5
        //   343: checkcast       Lgnu/lists/Pair;
        //   346: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   349: getstatic       gnu/kawa/slib/testing.Lit10:Lgnu/lists/PairWithPosition;
        //   352: invokestatic    kawa/lib/lists.memq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   355: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //   358: ifne            367
        //   361: aload           pair
        //   363: aload_1         /* log */
        //   364: invokestatic    gnu/kawa/slib/testing.$PcTestWriteResult1:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   367: aload_3         /* list */
        //   368: ldc_w           Lgnu/lists/Pair;.class
        //   371: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   374: dup            
        //   375: astore          5
        //   377: checkcast       Lgnu/lists/Pair;
        //   380: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //   383: goto            306
        //   386: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   389: goto            395
        //   392: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   395: areturn        
        //   396: new             Lgnu/mapping/WrongType;
        //   399: dup_x1         
        //   400: swap           
        //   401: ldc_w           "test-runner-aux-value"
        //   404: iconst_0       
        //   405: aload_2        
        //   406: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   409: athrow         
        //   410: new             Lgnu/mapping/WrongType;
        //   413: dup_x1         
        //   414: swap           
        //   415: ldc_w           "test-result-alist"
        //   418: iconst_0       
        //   419: aload           4
        //   421: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   424: athrow         
        //   425: new             Lgnu/mapping/WrongType;
        //   428: dup_x1         
        //   429: swap           
        //   430: ldc_w           "cdr"
        //   433: iconst_1       
        //   434: aload           4
        //   436: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   439: athrow         
        //   440: new             Lgnu/mapping/WrongType;
        //   443: dup_x1         
        //   444: swap           
        //   445: ldc_w           "test-result-alist"
        //   448: iconst_0       
        //   449: aload           4
        //   451: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   454: athrow         
        //   455: new             Lgnu/mapping/WrongType;
        //   458: dup_x1         
        //   459: swap           
        //   460: ldc_w           "cdr"
        //   463: iconst_1       
        //   464: aload           7
        //   466: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   469: athrow         
        //   470: new             Lgnu/mapping/WrongType;
        //   473: dup_x1         
        //   474: swap           
        //   475: ldc_w           "cdr"
        //   478: iconst_1       
        //   479: aload           7
        //   481: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   484: athrow         
        //   485: new             Lgnu/mapping/WrongType;
        //   488: dup_x1         
        //   489: swap           
        //   490: ldc_w           "cdr"
        //   493: iconst_1       
        //   494: aload           7
        //   496: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   499: athrow         
        //   500: new             Lgnu/mapping/WrongType;
        //   503: dup_x1         
        //   504: swap           
        //   505: ldc_w           "test-result-alist"
        //   508: iconst_0       
        //   509: aload_3        
        //   510: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   513: athrow         
        //   514: new             Lgnu/mapping/WrongType;
        //   517: dup_x1         
        //   518: swap           
        //   519: ldc_w           "car"
        //   522: iconst_1       
        //   523: aload           5
        //   525: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   528: athrow         
        //   529: new             Lgnu/mapping/WrongType;
        //   532: dup_x1         
        //   533: swap           
        //   534: ldc_w           "car"
        //   537: iconst_1       
        //   538: aload           5
        //   540: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   543: athrow         
        //   544: new             Lgnu/mapping/WrongType;
        //   547: dup_x1         
        //   548: swap           
        //   549: ldc_w           "cdr"
        //   552: iconst_1       
        //   553: aload           5
        //   555: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   558: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     396    410    Ljava/lang/ClassCastException;
        //  27     30     410    425    Ljava/lang/ClassCastException;
        //  54     57     425    440    Ljava/lang/ClassCastException;
        //  89     92     440    455    Ljava/lang/ClassCastException;
        //  169    172    455    470    Ljava/lang/ClassCastException;
        //  203    206    470    485    Ljava/lang/ClassCastException;
        //  262    265    485    500    Ljava/lang/ClassCastException;
        //  300    303    500    514    Ljava/lang/ClassCastException;
        //  324    327    514    529    Ljava/lang/ClassCastException;
        //  343    346    529    544    Ljava/lang/ClassCastException;
        //  377    380    544    559    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void testResultClear(final Object runner) {
        final Object force = Promise.force(runner, test-runner.class);
        try {
            testResultAlist$Ex((test-runner)force, LList.Empty);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "test-result-alist!", 0, force);
        }
    }
    
    public static void testResultRemove(final Object runner, final Object pname) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     6: dup            
        //     7: astore_3       
        //     8: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    11: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    14: astore_2        /* alist */
        //    15: aload_1         /* pname */
        //    16: aload_2         /* alist */
        //    17: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    20: astore_3        /* p */
        //    21: aload_3         /* p */
        //    22: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    25: ifeq            48
        //    28: aload_0         /* runner */
        //    29: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    31: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    34: dup            
        //    35: astore          4
        //    37: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    40: aload_3         /* p */
        //    41: aload_2         /* alist */
        //    42: invokestatic    gnu/kawa/slib/testing.lambda4loop:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    45: invokestatic    gnu/kawa/slib/testing.testResultAlist$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //    48: return         
        //    49: new             Lgnu/mapping/WrongType;
        //    52: dup_x1         
        //    53: swap           
        //    54: ldc_w           "test-result-alist"
        //    57: iconst_0       
        //    58: aload_3        
        //    59: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    62: athrow         
        //    63: new             Lgnu/mapping/WrongType;
        //    66: dup_x1         
        //    67: swap           
        //    68: ldc             "test-result-alist!"
        //    70: iconst_0       
        //    71: aload           4
        //    73: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    76: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  8      11     49     63     Ljava/lang/ClassCastException;
        //  37     40     63     77     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0048:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
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
    
    public static Object lambda4loop(final Object p, final Object r) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0         /* p */
        //     2: if_acmpne       23
        //     5: aload_1         /* r */
        //     6: ldc_w           Lgnu/lists/Pair;.class
        //     9: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    12: dup            
        //    13: astore_2       
        //    14: checkcast       Lgnu/lists/Pair;
        //    17: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    20: goto            60
        //    23: aload_1         /* r */
        //    24: ldc_w           Lgnu/lists/Pair;.class
        //    27: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    30: dup            
        //    31: astore_2       
        //    32: checkcast       Lgnu/lists/Pair;
        //    35: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    38: aload_0         /* p */
        //    39: aload_1         /* r */
        //    40: ldc_w           Lgnu/lists/Pair;.class
        //    43: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    46: dup            
        //    47: astore_2       
        //    48: checkcast       Lgnu/lists/Pair;
        //    51: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    54: invokestatic    gnu/kawa/slib/testing.lambda4loop:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    57: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //    60: areturn        
        //    61: new             Lgnu/mapping/WrongType;
        //    64: dup_x1         
        //    65: swap           
        //    66: ldc_w           "cdr"
        //    69: iconst_1       
        //    70: aload_2        
        //    71: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    74: athrow         
        //    75: new             Lgnu/mapping/WrongType;
        //    78: dup_x1         
        //    79: swap           
        //    80: ldc_w           "car"
        //    83: iconst_1       
        //    84: aload_2        
        //    85: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    88: athrow         
        //    89: new             Lgnu/mapping/WrongType;
        //    92: dup_x1         
        //    93: swap           
        //    94: ldc_w           "cdr"
        //    97: iconst_1       
        //    98: aload_2        
        //    99: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   102: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  14     17     61     75     Ljava/lang/ClassCastException;
        //  32     35     75     89     Ljava/lang/ClassCastException;
        //  48     51     89     103    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 53 out of bounds for length 53
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object testResultKind$V(final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore_2       
        //     7: astore_1        /* rest */
        //     8: aload_1         /* rest */
        //     9: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    12: ifeq            27
        //    15: aload_1         /* rest */
        //    16: dup            
        //    17: astore_3       
        //    18: checkcast       Lgnu/lists/Pair;
        //    21: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    24: goto            33
        //    27: getstatic       gnu/kawa/slib/testing.test$Mnrunner$Mncurrent:Lgnu/mapping/LocationProc;
        //    30: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
        //    33: astore_2        /* runner */
        //    34: getstatic       gnu/kawa/slib/testing.Lit1:Lgnu/mapping/SimpleSymbol;
        //    37: aload_2         /* runner */
        //    38: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    40: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    43: dup            
        //    44: astore          4
        //    46: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    49: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    52: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    55: astore_3        /* p */
        //    56: aload_3         /* p */
        //    57: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    60: ifeq            82
        //    63: aload_3         /* p */
        //    64: ldc_w           Lgnu/lists/Pair;.class
        //    67: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    70: dup            
        //    71: astore          4
        //    73: checkcast       Lgnu/lists/Pair;
        //    76: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    79: goto            85
        //    82: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    85: areturn        
        //    86: new             Lgnu/mapping/WrongType;
        //    89: dup_x1         
        //    90: swap           
        //    91: ldc_w           "car"
        //    94: iconst_1       
        //    95: aload_3        
        //    96: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    99: athrow         
        //   100: new             Lgnu/mapping/WrongType;
        //   103: dup_x1         
        //   104: swap           
        //   105: ldc_w           "test-result-alist"
        //   108: iconst_0       
        //   109: aload           4
        //   111: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   114: athrow         
        //   115: new             Lgnu/mapping/WrongType;
        //   118: dup_x1         
        //   119: swap           
        //   120: ldc_w           "cdr"
        //   123: iconst_1       
        //   124: aload           4
        //   126: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   129: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     86     100    Ljava/lang/ClassCastException;
        //  46     49     100    115    Ljava/lang/ClassCastException;
        //  73     76     115    130    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 65 out of bounds for length 65
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object isTestPassed$V(final Object[] argsArray) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iconst_0       
        //     2: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //     5: dup            
        //     6: astore_2       
        //     7: astore_1        /* rest */
        //     8: aload_1         /* rest */
        //     9: invokestatic    kawa/lib/lists.isPair:(Ljava/lang/Object;)Z
        //    12: ifeq            27
        //    15: aload_1         /* rest */
        //    16: dup            
        //    17: astore_3       
        //    18: checkcast       Lgnu/lists/Pair;
        //    21: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    24: goto            30
        //    27: invokestatic    gnu/kawa/slib/testing.testRunnerGet:()Ljava/lang/Object;
        //    30: astore_2        /* runner */
        //    31: getstatic       gnu/kawa/slib/testing.Lit1:Lgnu/mapping/SimpleSymbol;
        //    34: aload_2         /* runner */
        //    35: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    37: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    40: dup            
        //    41: astore          4
        //    43: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    46: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    49: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    52: astore_3        /* p */
        //    53: aload_3         /* p */
        //    54: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    57: ifeq            79
        //    60: aload_3         /* p */
        //    61: ldc_w           Lgnu/lists/Pair;.class
        //    64: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    67: dup            
        //    68: astore          4
        //    70: checkcast       Lgnu/lists/Pair;
        //    73: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    76: goto            82
        //    79: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    82: getstatic       gnu/kawa/slib/testing.Lit11:Lgnu/lists/PairWithPosition;
        //    85: invokestatic    kawa/lib/lists.memq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    88: areturn        
        //    89: new             Lgnu/mapping/WrongType;
        //    92: dup_x1         
        //    93: swap           
        //    94: ldc_w           "car"
        //    97: iconst_1       
        //    98: aload_3        
        //    99: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   102: athrow         
        //   103: new             Lgnu/mapping/WrongType;
        //   106: dup_x1         
        //   107: swap           
        //   108: ldc_w           "test-result-alist"
        //   111: iconst_0       
        //   112: aload           4
        //   114: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   117: athrow         
        //   118: new             Lgnu/mapping/WrongType;
        //   121: dup_x1         
        //   122: swap           
        //   123: ldc_w           "cdr"
        //   126: iconst_1       
        //   127: aload           4
        //   129: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   132: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  18     21     89     103    Ljava/lang/ClassCastException;
        //  43     46     103    118    Ljava/lang/ClassCastException;
        //  70     73     118    133    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 66 out of bounds for length 66
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Object $PcTestReportResult() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_0        /* r */
        //     4: iconst_1       
        //     5: anewarray       Ljava/lang/Object;
        //     8: dup            
        //     9: iconst_0       
        //    10: aload_0         /* r */
        //    11: aastore        
        //    12: invokestatic    gnu/kawa/slib/testing.testResultKind$V:([Ljava/lang/Object;)Ljava/lang/Object;
        //    15: astore_1        /* result$Mnkind */
        //    16: aload_1         /* result$Mnkind */
        //    17: invokevirtual   java/lang/Object.hashCode:()I
        //    20: lookupswitch {
        //          3135262: 64
        //          3433489: 208
        //          113957782: 160
        //          114256009: 112
        //          default: 256
        //        }
        //    64: aload_1         /* result$Mnkind */
        //    65: getstatic       gnu/kawa/slib/testing.Lit12:Lgnu/mapping/SimpleSymbol;
        //    68: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    71: ifeq            256
        //    74: aload_0         /* r */
        //    75: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    77: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    80: dup            
        //    81: astore_2       
        //    82: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    85: iconst_1       
        //    86: getstatic       gnu/kawa/slib/testing.Lit13:Lgnu/math/IntNum;
        //    89: aload_0         /* r */
        //    90: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    92: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    95: dup            
        //    96: astore_2       
        //    97: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   100: invokestatic    gnu/kawa/slib/testing.testRunnerFailCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   103: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   106: invokestatic    gnu/kawa/slib/testing.testRunnerFailCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   109: goto            294
        //   112: aload_1         /* result$Mnkind */
        //   113: getstatic       gnu/kawa/slib/testing.Lit9:Lgnu/mapping/SimpleSymbol;
        //   116: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   119: ifeq            256
        //   122: aload_0         /* r */
        //   123: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   125: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   128: dup            
        //   129: astore_2       
        //   130: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   133: iconst_1       
        //   134: getstatic       gnu/kawa/slib/testing.Lit13:Lgnu/math/IntNum;
        //   137: aload_0         /* r */
        //   138: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   140: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   143: dup            
        //   144: astore_2       
        //   145: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   148: invokestatic    gnu/kawa/slib/testing.testRunnerXpassCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   151: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   154: invokestatic    gnu/kawa/slib/testing.testRunnerXpassCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   157: goto            294
        //   160: aload_1         /* result$Mnkind */
        //   161: getstatic       gnu/kawa/slib/testing.Lit3:Lgnu/mapping/SimpleSymbol;
        //   164: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   167: ifeq            256
        //   170: aload_0         /* r */
        //   171: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   173: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   176: dup            
        //   177: astore_2       
        //   178: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   181: iconst_1       
        //   182: getstatic       gnu/kawa/slib/testing.Lit13:Lgnu/math/IntNum;
        //   185: aload_0         /* r */
        //   186: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   188: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   191: dup            
        //   192: astore_2       
        //   193: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   196: invokestatic    gnu/kawa/slib/testing.testRunnerXfailCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   199: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   202: invokestatic    gnu/kawa/slib/testing.testRunnerXfailCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   205: goto            294
        //   208: aload_1         /* result$Mnkind */
        //   209: getstatic       gnu/kawa/slib/testing.Lit14:Lgnu/mapping/SimpleSymbol;
        //   212: invokestatic    gnu/kawa/functions/IsEqv.apply:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   215: ifeq            256
        //   218: aload_0         /* r */
        //   219: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   221: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   224: dup            
        //   225: astore_2       
        //   226: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   229: iconst_1       
        //   230: getstatic       gnu/kawa/slib/testing.Lit13:Lgnu/math/IntNum;
        //   233: aload_0         /* r */
        //   234: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   236: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   239: dup            
        //   240: astore_2       
        //   241: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   244: invokestatic    gnu/kawa/slib/testing.testRunnerPassCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   247: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   250: invokestatic    gnu/kawa/slib/testing.testRunnerPassCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   253: goto            294
        //   256: aload_0         /* r */
        //   257: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   259: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   262: dup            
        //   263: astore_2       
        //   264: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   267: iconst_1       
        //   268: getstatic       gnu/kawa/slib/testing.Lit13:Lgnu/math/IntNum;
        //   271: aload_0         /* r */
        //   272: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   274: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   277: dup            
        //   278: astore_2       
        //   279: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   282: invokestatic    gnu/kawa/slib/testing.testRunnerSkipCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   285: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   288: invokestatic    gnu/kawa/slib/testing.testRunnerSkipCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   291: goto            294
        //   294: aload_0         /* r */
        //   295: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   297: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   300: dup            
        //   301: astore_2       
        //   302: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   305: iconst_1       
        //   306: getstatic       gnu/kawa/slib/testing.Lit13:Lgnu/math/IntNum;
        //   309: aload_0         /* r */
        //   310: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   312: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   315: dup            
        //   316: astore_2       
        //   317: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   320: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerTotalCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   323: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   326: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerTotalCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   329: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   332: aload_0         /* r */
        //   333: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   335: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   338: dup            
        //   339: astore_2       
        //   340: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   343: invokestatic    gnu/kawa/slib/testing.testRunnerOnTestEnd:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   346: aload_0         /* r */
        //   347: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   350: areturn        
        //   351: new             Lgnu/mapping/WrongType;
        //   354: dup_x1         
        //   355: swap           
        //   356: ldc             "test-runner-fail-count!"
        //   358: iconst_0       
        //   359: aload_2        
        //   360: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   363: athrow         
        //   364: new             Lgnu/mapping/WrongType;
        //   367: dup_x1         
        //   368: swap           
        //   369: ldc_w           "test-runner-fail-count"
        //   372: iconst_0       
        //   373: aload_2        
        //   374: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   377: athrow         
        //   378: new             Lgnu/mapping/WrongType;
        //   381: dup_x1         
        //   382: swap           
        //   383: ldc             "test-runner-xpass-count!"
        //   385: iconst_0       
        //   386: aload_2        
        //   387: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   390: athrow         
        //   391: new             Lgnu/mapping/WrongType;
        //   394: dup_x1         
        //   395: swap           
        //   396: ldc_w           "test-runner-xpass-count"
        //   399: iconst_0       
        //   400: aload_2        
        //   401: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   404: athrow         
        //   405: new             Lgnu/mapping/WrongType;
        //   408: dup_x1         
        //   409: swap           
        //   410: ldc             "test-runner-xfail-count!"
        //   412: iconst_0       
        //   413: aload_2        
        //   414: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   417: athrow         
        //   418: new             Lgnu/mapping/WrongType;
        //   421: dup_x1         
        //   422: swap           
        //   423: ldc_w           "test-runner-xfail-count"
        //   426: iconst_0       
        //   427: aload_2        
        //   428: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   431: athrow         
        //   432: new             Lgnu/mapping/WrongType;
        //   435: dup_x1         
        //   436: swap           
        //   437: ldc             "test-runner-pass-count!"
        //   439: iconst_0       
        //   440: aload_2        
        //   441: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   444: athrow         
        //   445: new             Lgnu/mapping/WrongType;
        //   448: dup_x1         
        //   449: swap           
        //   450: ldc_w           "test-runner-pass-count"
        //   453: iconst_0       
        //   454: aload_2        
        //   455: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   458: athrow         
        //   459: new             Lgnu/mapping/WrongType;
        //   462: dup_x1         
        //   463: swap           
        //   464: ldc             "test-runner-skip-count!"
        //   466: iconst_0       
        //   467: aload_2        
        //   468: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   471: athrow         
        //   472: new             Lgnu/mapping/WrongType;
        //   475: dup_x1         
        //   476: swap           
        //   477: ldc_w           "test-runner-skip-count"
        //   480: iconst_0       
        //   481: aload_2        
        //   482: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   485: athrow         
        //   486: new             Lgnu/mapping/WrongType;
        //   489: dup_x1         
        //   490: swap           
        //   491: ldc             "%test-runner-total-count!"
        //   493: iconst_0       
        //   494: aload_2        
        //   495: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   498: athrow         
        //   499: new             Lgnu/mapping/WrongType;
        //   502: dup_x1         
        //   503: swap           
        //   504: ldc_w           "%test-runner-total-count"
        //   507: iconst_0       
        //   508: aload_2        
        //   509: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   512: athrow         
        //   513: new             Lgnu/mapping/WrongType;
        //   516: dup_x1         
        //   517: swap           
        //   518: ldc_w           "test-runner-on-test-end"
        //   521: iconst_0       
        //   522: aload_2        
        //   523: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   526: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  82     85     351    364    Ljava/lang/ClassCastException;
        //  97     100    364    378    Ljava/lang/ClassCastException;
        //  130    133    378    391    Ljava/lang/ClassCastException;
        //  145    148    391    405    Ljava/lang/ClassCastException;
        //  178    181    405    418    Ljava/lang/ClassCastException;
        //  193    196    418    432    Ljava/lang/ClassCastException;
        //  226    229    432    445    Ljava/lang/ClassCastException;
        //  241    244    445    459    Ljava/lang/ClassCastException;
        //  264    267    459    472    Ljava/lang/ClassCastException;
        //  279    282    472    486    Ljava/lang/ClassCastException;
        //  302    305    486    499    Ljava/lang/ClassCastException;
        //  317    320    499    513    Ljava/lang/ClassCastException;
        //  340    343    513    527    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 251 out of bounds for length 251
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean $PcTestOnTestBegin(final Object r) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    gnu/kawa/slib/testing.$PcTestShouldExecute:(Ljava/lang/Object;)Ljava/lang/Object;
        //     4: pop            
        //     5: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //     8: aload_0         /* r */
        //     9: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    11: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    14: dup            
        //    15: astore_1       
        //    16: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    19: invokestatic    gnu/kawa/slib/testing.testRunnerOnTestBegin:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    22: aload_0         /* r */
        //    23: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    26: pop            
        //    27: getstatic       gnu/kawa/slib/testing.Lit2:Lgnu/mapping/SimpleSymbol;
        //    30: getstatic       gnu/kawa/slib/testing.Lit1:Lgnu/mapping/SimpleSymbol;
        //    33: aload_0         /* r */
        //    34: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore_2       
        //    41: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    44: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    47: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    50: astore_1        /* p */
        //    51: aload_1         /* p */
        //    52: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    55: ifeq            76
        //    58: aload_1         /* p */
        //    59: ldc_w           Lgnu/lists/Pair;.class
        //    62: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    65: dup            
        //    66: astore_2       
        //    67: checkcast       Lgnu/lists/Pair;
        //    70: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    73: goto            79
        //    76: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    79: if_acmpne       86
        //    82: iconst_0       
        //    83: goto            87
        //    86: iconst_1       
        //    87: ireturn        
        //    88: new             Lgnu/mapping/WrongType;
        //    91: dup_x1         
        //    92: swap           
        //    93: ldc_w           "test-runner-on-test-begin"
        //    96: iconst_0       
        //    97: aload_1        
        //    98: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   101: athrow         
        //   102: new             Lgnu/mapping/WrongType;
        //   105: dup_x1         
        //   106: swap           
        //   107: ldc_w           "test-result-alist"
        //   110: iconst_0       
        //   111: aload_2        
        //   112: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   115: athrow         
        //   116: new             Lgnu/mapping/WrongType;
        //   119: dup_x1         
        //   120: swap           
        //   121: ldc_w           "cdr"
        //   124: iconst_1       
        //   125: aload_2        
        //   126: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   129: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  16     19     88     102    Ljava/lang/ClassCastException;
        //  41     44     102    116    Ljava/lang/ClassCastException;
        //  67     70     116    130    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 66 out of bounds for length 66
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void $PcTestOnTestEnd(final Object r, final Object result) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       gnu/kawa/slib/testing.Lit1:Lgnu/mapping/SimpleSymbol;
        //     4: getstatic       gnu/kawa/slib/testing.Lit1:Lgnu/mapping/SimpleSymbol;
        //     7: aload_0         /* r */
        //     8: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    10: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    13: dup            
        //    14: astore_3       
        //    15: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    18: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    21: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    24: astore_2        /* p */
        //    25: aload_2         /* p */
        //    26: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    29: ifeq            50
        //    32: aload_2         /* p */
        //    33: ldc_w           Lgnu/lists/Pair;.class
        //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    39: dup            
        //    40: astore_3       
        //    41: checkcast       Lgnu/lists/Pair;
        //    44: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    47: goto            53
        //    50: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    53: getstatic       gnu/kawa/slib/testing.Lit3:Lgnu/mapping/SimpleSymbol;
        //    56: if_acmpne       78
        //    59: aload_1         /* result */
        //    60: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    63: ifeq            72
        //    66: getstatic       gnu/kawa/slib/testing.Lit9:Lgnu/mapping/SimpleSymbol;
        //    69: goto            94
        //    72: getstatic       gnu/kawa/slib/testing.Lit3:Lgnu/mapping/SimpleSymbol;
        //    75: goto            94
        //    78: aload_1         /* result */
        //    79: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    82: ifeq            91
        //    85: getstatic       gnu/kawa/slib/testing.Lit14:Lgnu/mapping/SimpleSymbol;
        //    88: goto            94
        //    91: getstatic       gnu/kawa/slib/testing.Lit12:Lgnu/mapping/SimpleSymbol;
        //    94: invokestatic    gnu/kawa/slib/testing.testResultSet$Ex:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
        //    97: return         
        //    98: new             Lgnu/mapping/WrongType;
        //   101: dup_x1         
        //   102: swap           
        //   103: ldc_w           "test-result-alist"
        //   106: iconst_0       
        //   107: aload_3        
        //   108: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   111: athrow         
        //   112: new             Lgnu/mapping/WrongType;
        //   115: dup_x1         
        //   116: swap           
        //   117: ldc_w           "cdr"
        //   120: iconst_1       
        //   121: aload_3        
        //   122: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   125: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  15     18     98     112    Ljava/lang/ClassCastException;
        //  41     44     112    126    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0050:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
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
    
    public static Object testRunnerTestName(final Object runner) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0         /* runner */
        //     4: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //     6: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //     9: dup            
        //    10: astore_2       
        //    11: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    14: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    17: invokestatic    kawa/lib/lists.assq:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    20: astore_1        /* p */
        //    21: aload_1         /* p */
        //    22: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    25: ifeq            46
        //    28: aload_1         /* p */
        //    29: ldc_w           Lgnu/lists/Pair;.class
        //    32: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    35: dup            
        //    36: astore_2       
        //    37: checkcast       Lgnu/lists/Pair;
        //    40: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
        //    43: goto            49
        //    46: ldc_w           ""
        //    49: areturn        
        //    50: new             Lgnu/mapping/WrongType;
        //    53: dup_x1         
        //    54: swap           
        //    55: ldc_w           "test-result-alist"
        //    58: iconst_0       
        //    59: aload_2        
        //    60: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    63: athrow         
        //    64: new             Lgnu/mapping/WrongType;
        //    67: dup_x1         
        //    68: swap           
        //    69: ldc_w           "cdr"
        //    72: iconst_1       
        //    73: aload_2        
        //    74: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    77: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  11     14     50     64     Ljava/lang/ClassCastException;
        //  37     40     64     78     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0046:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
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
    
    public static Procedure $PcTestApproximate$Eq(final Object error) {
        public class testing$frame extends ModuleBody
        {
            Object error;
            final ModuleMethod lambda$Fn4;
            
            public testing$frame() {
                final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 1, null, 8194);
                lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:667");
                this.lambda$Fn4 = lambda$Fn4;
            }
            
            boolean lambda5(final Object value, final Object expected) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     3: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //     6: dup            
                //     7: astore          4
                //     9: checkcast       Ljava/lang/Number;
                //    12: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
                //    15: astore_3       
                //    16: aload_1         /* value */
                //    17: ldc             Ljava/lang/Number;.class
                //    19: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    22: dup            
                //    23: astore          5
                //    25: checkcast       Ljava/lang/Number;
                //    28: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
                //    31: astore          4
                //    33: aload_2         /* expected */
                //    34: ldc             Ljava/lang/Number;.class
                //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    39: dup            
                //    40: astore          6
                //    42: checkcast       Ljava/lang/Number;
                //    45: invokestatic    kawa/lib/numbers.realPart:(Ljava/lang/Number;)Ljava/lang/Number;
                //    48: astore          5
                //    50: aload_2         /* expected */
                //    51: ldc             Ljava/lang/Number;.class
                //    53: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    56: dup            
                //    57: astore          7
                //    59: checkcast       Ljava/lang/Number;
                //    62: invokestatic    kawa/lib/numbers.imagPart:(Ljava/lang/Number;)Ljava/lang/Number;
                //    65: astore          iexp
                //    67: aload_3         /* rval */
                //    68: iconst_m1      
                //    69: aload           rexp
                //    71: aload_0         /* this */
                //    72: getfield        gnu/kawa/slib/testing$frame.error:Ljava/lang/Object;
                //    75: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    78: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    81: ifeq            145
                //    84: aload           ival
                //    86: iconst_m1      
                //    87: aload           iexp
                //    89: aload_0         /* this */
                //    90: getfield        gnu/kawa/slib/testing$frame.error:Ljava/lang/Object;
                //    93: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    96: invokestatic    gnu/kawa/functions/NumberCompare.$Gr$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //    99: ifeq            141
                //   102: aload_3         /* rval */
                //   103: iconst_1       
                //   104: aload           rexp
                //   106: aload_0         /* this */
                //   107: getfield        gnu/kawa/slib/testing$frame.error:Ljava/lang/Object;
                //   110: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   113: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   116: ifeq            137
                //   119: aload           ival
                //   121: iconst_1       
                //   122: aload           iexp
                //   124: aload_0         /* this */
                //   125: getfield        gnu/kawa/slib/testing$frame.error:Ljava/lang/Object;
                //   128: invokestatic    gnu/kawa/functions/AddOp.apply2:(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //   131: invokestatic    gnu/kawa/functions/NumberCompare.$Ls$Eq:(Ljava/lang/Object;Ljava/lang/Object;)Z
                //   134: goto            146
                //   137: iconst_0       
                //   138: goto            146
                //   141: iconst_0       
                //   142: goto            146
                //   145: iconst_0       
                //   146: ireturn        
                //   147: new             Lgnu/mapping/WrongType;
                //   150: dup_x1         
                //   151: swap           
                //   152: ldc             "real-part"
                //   154: iconst_1       
                //   155: aload           4
                //   157: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   160: athrow         
                //   161: new             Lgnu/mapping/WrongType;
                //   164: dup_x1         
                //   165: swap           
                //   166: ldc             "imag-part"
                //   168: iconst_1       
                //   169: aload           5
                //   171: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   174: athrow         
                //   175: new             Lgnu/mapping/WrongType;
                //   178: dup_x1         
                //   179: swap           
                //   180: ldc             "real-part"
                //   182: iconst_1       
                //   183: aload           6
                //   185: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   188: athrow         
                //   189: new             Lgnu/mapping/WrongType;
                //   192: dup_x1         
                //   193: swap           
                //   194: ldc             "imag-part"
                //   196: iconst_1       
                //   197: aload           7
                //   199: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   202: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  9      12     147    161    Ljava/lang/ClassCastException;
                //  25     28     161    175    Ljava/lang/ClassCastException;
                //  42     45     175    189    Ljava/lang/ClassCastException;
                //  59     62     189    203    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
            
            @Override
            public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
                if (moduleMethod.selector == 1) {
                    ctx.value1 = o;
                    ctx.value2 = o2;
                    ctx.proc = moduleMethod;
                    ctx.pc = 2;
                    return 0;
                }
                return super.match2(moduleMethod, o, o2, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
                if (method.selector == 1) {
                    return this.lambda5(o, o2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply2(method, o, o2);
            }
        }
        final testing$frame $heapFrame = new testing$frame();
        $heapFrame.error = error;
        return $heapFrame.lambda$Fn4;
    }
    
    public static Object testApply$V(final Object first, final Object[] argsArray) {
        public class testing$frame0 extends ModuleBody
        {
            Object saved$Mnrunner;
            Object r;
            @SourceName(name = "saved-runner")
            Object saved$Mnrunner$1;
            LList rest;
            Object first;
            final ModuleMethod lambda$Fn5;
            final ModuleMethod lambda$Fn6;
            final ModuleMethod lambda$Fn7;
            final ModuleMethod lambda$Fn8;
            final ModuleMethod lambda$Fn9;
            final ModuleMethod lambda$Fn10;
            
            public testing$frame0() {
                this.lambda$Fn5 = new ModuleMethod(this, 2, null, 0);
                this.lambda$Fn6 = new ModuleMethod(this, 3, null, 0);
                final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 4, null, 0);
                lambda$Fn7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:950");
                this.lambda$Fn7 = lambda$Fn7;
                this.lambda$Fn8 = new ModuleMethod(this, 5, null, 0);
                this.lambda$Fn9 = new ModuleMethod(this, 6, null, 0);
                final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 7, null, 0);
                lambda$Fn8.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:950");
                this.lambda$Fn10 = lambda$Fn8;
            }
            
            Object lambda6() {
                return testing.test$Mnrunner$Mncurrent.apply1(this.first);
            }
            
            Object lambda7() {
                return Scheme.apply.apply2(testing.test$Mnapply, this.rest);
            }
            
            Object lambda8() {
                return testing.test$Mnrunner$Mncurrent.apply1(this.saved$Mnrunner$1);
            }
            
            Object lambda9() {
                return testing.test$Mnrunner$Mncurrent.apply1(this.r);
            }
            
            Object lambda10() {
                return Scheme.apply.apply3(testing.test$Mnapply, this.first, this.rest);
            }
            
            Object lambda11() {
                return testing.test$Mnrunner$Mncurrent.apply1(this.saved$Mnrunner);
            }
            
            @Override
            public int match0(final ModuleMethod proc, final CallContext ctx) {
                switch (proc.selector) {
                    case 7: {
                        ctx.proc = proc;
                        return ctx.pc = 0;
                    }
                    case 6: {
                        ctx.proc = proc;
                        return ctx.pc = 0;
                    }
                    case 5: {
                        ctx.proc = proc;
                        return ctx.pc = 0;
                    }
                    case 4: {
                        ctx.proc = proc;
                        return ctx.pc = 0;
                    }
                    case 3: {
                        ctx.proc = proc;
                        return ctx.pc = 0;
                    }
                    case 2: {
                        ctx.proc = proc;
                        return ctx.pc = 0;
                    }
                    default: {
                        return super.match0(proc, ctx);
                    }
                }
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply0(final ModuleMethod method) {
                switch (method.selector) {
                    case 2: {
                        return this.lambda6();
                    }
                    case 3: {
                        return this.lambda7();
                    }
                    case 4: {
                        return this.lambda8();
                    }
                    case 5: {
                        return this.lambda9();
                    }
                    case 6: {
                        return this.lambda10();
                    }
                    case 7: {
                        return this.lambda11();
                    }
                    default: {
                        return super.apply0(method);
                    }
                }
            }
        }
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   gnu/kawa/slib/testing$frame0.<init>:()V
        //     7: astore_3        /* $heapFrame */
        //     8: aload_3         /* $heapFrame */
        //     9: aload_0         /* first */
        //    10: putfield        gnu/kawa/slib/testing$frame0.first:Ljava/lang/Object;
        //    13: aload_3         /* $heapFrame */
        //    14: aload_1         /* argsArray */
        //    15: iconst_0       
        //    16: invokestatic    gnu/lists/LList.makeList:([Ljava/lang/Object;I)Lgnu/lists/LList;
        //    19: dup            
        //    20: astore          4
        //    22: putfield        gnu/kawa/slib/testing$frame0.rest:Lgnu/lists/LList;
        //    25: aload_3         /* $heapFrame */
        //    26: getfield        gnu/kawa/slib/testing$frame0.first:Ljava/lang/Object;
        //    29: invokestatic    gnu/kawa/slib/testing.isTestRunner:(Ljava/lang/Object;)Z
        //    32: ifeq            64
        //    35: getstatic       gnu/kawa/slib/testing.test$Mnrunner$Mncurrent:Lgnu/mapping/LocationProc;
        //    38: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
        //    41: aload_3         /* $heapFrame */
        //    42: swap           
        //    43: putfield        gnu/kawa/slib/testing$frame0.saved$Mnrunner$1:Ljava/lang/Object;
        //    46: aload_3         /* $heapFrame */
        //    47: getfield        gnu/kawa/slib/testing$frame0.lambda$Fn5:Lgnu/expr/ModuleMethod;
        //    50: aload_3         /* $heapFrame */
        //    51: getfield        gnu/kawa/slib/testing$frame0.lambda$Fn6:Lgnu/expr/ModuleMethod;
        //    54: aload_3         /* $heapFrame */
        //    55: getfield        gnu/kawa/slib/testing$frame0.lambda$Fn7:Lgnu/expr/ModuleMethod;
        //    58: invokestatic    kawa/lib/misc.dynamicWind:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    61: goto            297
        //    64: getstatic       gnu/kawa/slib/testing.test$Mnrunner$Mncurrent:Lgnu/mapping/LocationProc;
        //    67: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
        //    70: astore          r
        //    72: aload           r
        //    74: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
        //    77: ifeq            234
        //    80: aload           r
        //    82: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //    84: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    87: dup            
        //    88: astore          6
        //    90: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //    93: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerRunList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //    96: astore          run$Mnlist
        //    98: aload_3         /* $heapFrame */
        //    99: getfield        gnu/kawa/slib/testing$frame0.rest:Lgnu/lists/LList;
        //   102: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
        //   105: ifeq            153
        //   108: aload           r
        //   110: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   112: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   115: dup            
        //   116: astore          6
        //   118: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   121: aload           run$Mnlist
        //   123: ldc             Lgnu/lists/LList;.class
        //   125: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   128: dup            
        //   129: astore          6
        //   131: checkcast       Lgnu/lists/LList;
        //   134: invokestatic    kawa/lib/lists.reverse:(Lgnu/lists/LList;)Lgnu/lists/LList;
        //   137: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerRunList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   140: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   143: aload_3         /* $heapFrame */
        //   144: getfield        gnu/kawa/slib/testing$frame0.first:Ljava/lang/Object;
        //   147: invokevirtual   gnu/mapping/Procedure.apply1:(Ljava/lang/Object;)Ljava/lang/Object;
        //   150: goto            297
        //   153: aload           r
        //   155: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   157: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   160: dup            
        //   161: astore          6
        //   163: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   166: aload           run$Mnlist
        //   168: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   171: if_acmpne       184
        //   174: aload_3         /* $heapFrame */
        //   175: getfield        gnu/kawa/slib/testing$frame0.first:Ljava/lang/Object;
        //   178: invokestatic    gnu/lists/LList.list1:(Ljava/lang/Object;)Lgnu/lists/Pair;
        //   181: goto            193
        //   184: aload_3         /* $heapFrame */
        //   185: getfield        gnu/kawa/slib/testing$frame0.first:Ljava/lang/Object;
        //   188: aload           run$Mnlist
        //   190: invokestatic    kawa/lib/lists.cons:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;
        //   193: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerRunList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   196: getstatic       kawa/standard/Scheme.apply:Lgnu/kawa/functions/Apply;
        //   199: getstatic       gnu/kawa/slib/testing.test$Mnapply:Lgnu/expr/ModuleMethod;
        //   202: aload_3         /* $heapFrame */
        //   203: getfield        gnu/kawa/slib/testing$frame0.rest:Lgnu/lists/LList;
        //   206: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   209: pop            
        //   210: aload           r
        //   212: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   214: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   217: dup            
        //   218: astore          6
        //   220: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   223: aload           run$Mnlist
        //   225: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerRunList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   228: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   231: goto            297
        //   234: invokestatic    gnu/kawa/slib/testing.testRunnerCreate:()Ljava/lang/Object;
        //   237: aload_3         /* $heapFrame */
        //   238: swap           
        //   239: putfield        gnu/kawa/slib/testing$frame0.r:Ljava/lang/Object;
        //   242: getstatic       gnu/kawa/slib/testing.test$Mnrunner$Mncurrent:Lgnu/mapping/LocationProc;
        //   245: invokevirtual   gnu/mapping/LocationProc.getValue:()Ljava/lang/Object;
        //   248: aload_3         /* $heapFrame */
        //   249: swap           
        //   250: putfield        gnu/kawa/slib/testing$frame0.saved$Mnrunner:Ljava/lang/Object;
        //   253: aload_3         /* $heapFrame */
        //   254: getfield        gnu/kawa/slib/testing$frame0.lambda$Fn8:Lgnu/expr/ModuleMethod;
        //   257: aload_3         /* $heapFrame */
        //   258: getfield        gnu/kawa/slib/testing$frame0.lambda$Fn9:Lgnu/expr/ModuleMethod;
        //   261: aload_3         /* $heapFrame */
        //   262: getfield        gnu/kawa/slib/testing$frame0.lambda$Fn10:Lgnu/expr/ModuleMethod;
        //   265: invokestatic    kawa/lib/misc.dynamicWind:(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   268: pop            
        //   269: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
        //   272: aload_3         /* $heapFrame */
        //   273: getfield        gnu/kawa/slib/testing$frame0.r:Ljava/lang/Object;
        //   276: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   278: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   281: dup            
        //   282: astore          5
        //   284: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   287: invokestatic    gnu/kawa/slib/testing.testRunnerOnFinal:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   290: aload_3         /* $heapFrame */
        //   291: getfield        gnu/kawa/slib/testing$frame0.r:Ljava/lang/Object;
        //   294: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   297: areturn        
        //   298: new             Lgnu/mapping/WrongType;
        //   301: dup_x1         
        //   302: swap           
        //   303: ldc_w           "%test-runner-run-list"
        //   306: iconst_0       
        //   307: aload           6
        //   309: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   312: athrow         
        //   313: new             Lgnu/mapping/WrongType;
        //   316: dup_x1         
        //   317: swap           
        //   318: ldc             "%test-runner-run-list!"
        //   320: iconst_0       
        //   321: aload           6
        //   323: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   326: athrow         
        //   327: new             Lgnu/mapping/WrongType;
        //   330: dup_x1         
        //   331: swap           
        //   332: ldc             "reverse"
        //   334: iconst_1       
        //   335: aload           6
        //   337: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   340: athrow         
        //   341: new             Lgnu/mapping/WrongType;
        //   344: dup_x1         
        //   345: swap           
        //   346: ldc             "%test-runner-run-list!"
        //   348: iconst_0       
        //   349: aload           6
        //   351: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   354: athrow         
        //   355: new             Lgnu/mapping/WrongType;
        //   358: dup_x1         
        //   359: swap           
        //   360: ldc             "%test-runner-run-list!"
        //   362: iconst_0       
        //   363: aload           6
        //   365: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   368: athrow         
        //   369: new             Lgnu/mapping/WrongType;
        //   372: dup_x1         
        //   373: swap           
        //   374: ldc_w           "test-runner-on-final"
        //   377: iconst_0       
        //   378: aload           5
        //   380: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   383: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  90     93     298    313    Ljava/lang/ClassCastException;
        //  118    121    313    327    Ljava/lang/ClassCastException;
        //  131    134    327    341    Ljava/lang/ClassCastException;
        //  163    166    341    355    Ljava/lang/ClassCastException;
        //  220    223    355    369    Ljava/lang/ClassCastException;
        //  284    287    369    384    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 180 out of bounds for length 180
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static Procedure $PcTestMatchNth(final Object n, final Object count) {
        public class testing$frame1 extends ModuleBody
        {
            Object count;
            Object n;
            IntNum i;
            final ModuleMethod lambda$Fn11;
            
            public testing$frame1() {
                final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 8, null, 4097);
                lambda$Fn11.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:956");
                this.lambda$Fn11 = lambda$Fn11;
            }
            
            boolean lambda12(final Object runner) {
                this.i = IntNum.add(this.i, 1);
                return NumberCompare.$Gr$Eq(this.i, this.n) && NumberCompare.$Ls(this.i, AddOp.apply2(1, this.n, this.count));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 8) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 8) {
                    return this.lambda12(o) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(method, o);
            }
        }
        final testing$frame1 $heapFrame = new testing$frame1();
        $heapFrame.n = n;
        $heapFrame.count = count;
        $heapFrame.i = testing.Lit0;
        return $heapFrame.lambda$Fn11;
    }
    
    public static Procedure $PcTestMatchAll$V(final Object[] argsArray) {
        public class testing$frame2 extends ModuleBody
        {
            LList pred$Mnlist;
            final ModuleMethod lambda$Fn12;
            
            public testing$frame2() {
                final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 9, null, 4097);
                lambda$Fn12.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:968");
                this.lambda$Fn12 = lambda$Fn12;
            }
            
            Object lambda13(final Object runner) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     2: aload_0         /* this */
                //     3: getfield        gnu/kawa/slib/testing$frame2.pred$Mnlist:Lgnu/lists/LList;
                //     6: astore_3        /* l */
                //     7: aload_3         /* l */
                //     8: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    11: ifeq            30
                //    14: iload_2         /* result */
                //    15: ifeq            24
                //    18: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //    21: goto            78
                //    24: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //    27: goto            78
                //    30: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    33: aload_3         /* l */
                //    34: ldc             Lgnu/lists/Pair;.class
                //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    39: dup            
                //    40: astore          4
                //    42: checkcast       Lgnu/lists/Pair;
                //    45: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    48: aload_1         /* runner */
                //    49: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    52: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    55: ifne            60
                //    58: iconst_0       
                //    59: istore_2        /* result */
                //    60: aload_3         /* l */
                //    61: ldc             Lgnu/lists/Pair;.class
                //    63: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    66: dup            
                //    67: astore          4
                //    69: checkcast       Lgnu/lists/Pair;
                //    72: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    75: goto            6
                //    78: areturn        
                //    79: new             Lgnu/mapping/WrongType;
                //    82: dup_x1         
                //    83: swap           
                //    84: ldc             "car"
                //    86: iconst_1       
                //    87: aload           4
                //    89: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    92: athrow         
                //    93: new             Lgnu/mapping/WrongType;
                //    96: dup_x1         
                //    97: swap           
                //    98: ldc             "cdr"
                //   100: iconst_1       
                //   101: aload           4
                //   103: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   106: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  42     45     79     93     Ljava/lang/ClassCastException;
                //  69     72     93     107    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0078:
                //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
                //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 9) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 9) {
                    return this.lambda13(o);
                }
                return super.apply1(method, o);
            }
        }
        final testing$frame2 $heapFrame = new testing$frame2();
        $heapFrame.pred$Mnlist = LList.makeList(argsArray, 0);
        return $heapFrame.lambda$Fn12;
    }
    
    public static Procedure $PcTestMatchAny$V(final Object[] argsArray) {
        public class testing$frame3 extends ModuleBody
        {
            LList pred$Mnlist;
            final ModuleMethod lambda$Fn13;
            
            public testing$frame3() {
                final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 10, null, 4097);
                lambda$Fn13.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:984");
                this.lambda$Fn13 = lambda$Fn13;
            }
            
            Object lambda14(final Object runner) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     2: aload_0         /* this */
                //     3: getfield        gnu/kawa/slib/testing$frame3.pred$Mnlist:Lgnu/lists/LList;
                //     6: astore_3        /* l */
                //     7: aload_3         /* l */
                //     8: invokestatic    kawa/lib/lists.isNull:(Ljava/lang/Object;)Z
                //    11: ifeq            30
                //    14: iload_2         /* result */
                //    15: ifeq            24
                //    18: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
                //    21: goto            78
                //    24: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
                //    27: goto            78
                //    30: getstatic       kawa/standard/Scheme.applyToArgs:Lgnu/kawa/functions/ApplyToArgs;
                //    33: aload_3         /* l */
                //    34: ldc             Lgnu/lists/Pair;.class
                //    36: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    39: dup            
                //    40: astore          4
                //    42: checkcast       Lgnu/lists/Pair;
                //    45: invokestatic    kawa/lib/lists.car:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    48: aload_1         /* runner */
                //    49: invokevirtual   gnu/mapping/Procedure.apply2:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
                //    52: invokestatic    gnu/expr/KawaConvert.isTrue:(Ljava/lang/Object;)Z
                //    55: ifeq            60
                //    58: iconst_1       
                //    59: istore_2        /* result */
                //    60: aload_3         /* l */
                //    61: ldc             Lgnu/lists/Pair;.class
                //    63: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
                //    66: dup            
                //    67: astore          4
                //    69: checkcast       Lgnu/lists/Pair;
                //    72: invokestatic    kawa/lib/lists.cdr:(Lgnu/lists/Pair;)Ljava/lang/Object;
                //    75: goto            6
                //    78: areturn        
                //    79: new             Lgnu/mapping/WrongType;
                //    82: dup_x1         
                //    83: swap           
                //    84: ldc             "car"
                //    86: iconst_1       
                //    87: aload           4
                //    89: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //    92: athrow         
                //    93: new             Lgnu/mapping/WrongType;
                //    96: dup_x1         
                //    97: swap           
                //    98: ldc             "cdr"
                //   100: iconst_1       
                //   101: aload           4
                //   103: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
                //   106: athrow         
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                          
                //  -----  -----  -----  -----  ------------------------------
                //  42     45     79     93     Ljava/lang/ClassCastException;
                //  69     72     93     107    Ljava/lang/ClassCastException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Expression is linked from several locations: Label_0078:
                //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
                //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 10) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 10) {
                    return this.lambda14(o);
                }
                return super.apply1(method, o);
            }
        }
        final testing$frame3 $heapFrame = new testing$frame3();
        $heapFrame.pred$Mnlist = LList.makeList(argsArray, 0);
        return $heapFrame.lambda$Fn13;
    }
    
    public static Object $PcTestAsSpecifier(final Object specifier) {
        Object o;
        if (misc.isProcedure(specifier)) {
            o = specifier;
        }
        else if (numbers.isInteger(specifier)) {
            o = $PcTestMatchNth(testing.Lit13, specifier);
        }
        else {
            if (!strings.isString(specifier)) {
                exceptions.error("not a valid test specifier");
                throw Special.reachedUnexpected;
            }
            o = testMatchName(specifier);
        }
        return o;
    }
    
    public static Procedure testMatchName(final Object name) {
        public class testing$frame4 extends ModuleBody
        {
            Object name;
            final ModuleMethod lambda$Fn14;
            
            public testing$frame4() {
                final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 11, null, 4097);
                lambda$Fn14.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:1024");
                this.lambda$Fn14 = lambda$Fn14;
            }
            
            Object lambda15(final Object runner) {
                return Scheme.isEqual.apply2(this.name, testing.testRunnerTestName(runner));
            }
            
            @Override
            public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
                if (moduleMethod.selector == 11) {
                    ctx.value1 = o;
                    ctx.proc = moduleMethod;
                    ctx.pc = 1;
                    return 0;
                }
                return super.match1(moduleMethod, o, ctx);
            }
            
            @Override
            public void apply(final CallContext callContext) {
                final int pc = callContext.pc;
                ModuleMethod.applyError();
            }
            
            @Override
            public Object apply1(final ModuleMethod method, final Object o) {
                if (method.selector == 11) {
                    return this.lambda15(o);
                }
                return super.apply1(method, o);
            }
        }
        final testing$frame4 $heapFrame = new testing$frame4();
        $heapFrame.name = name;
        return $heapFrame.lambda$Fn14;
    }
    
    public static Object testReadEvalString(final Object string) {
        final Object force = Promise.force(string, CharSequence.class);
        try {
            final CharArrayInPort port = ports.openInputString((CharSequence)force);
            final Object form = ports.read(port);
            if (ports.readChar(port) == -1) {
                final Object o = form;
                final CallContext $ctx;
                final CallContext callContext = $ctx = CallContext.getInstance();
                final int startFromContext = $ctx.startFromContext();
                try {
                    eval.eval$X(o, callContext);
                }
                finally {
                    $ctx.cleanupFromContext(startFromContext);
                }
                return $ctx.getFromContext(startFromContext);
            }
            exceptions.error("(not at eof)");
            throw Special.reachedUnexpected;
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "open-input-string", 1, force);
        }
    }
    
    static Object $PcTestSpecifierMatches(final Object spec, final Object runner) {
        return Scheme.applyToArgs.apply2(spec, runner);
    }
    
    static void $PcTestFinalReport1(final Object value, final Object label, final Object port) {
        if (NumberCompare.$Gr(value, testing.Lit0)) {
            ports.display(label, port);
            ports.display(value, port);
            ports.newline(port);
        }
    }
    
    static Object $PcTestSyntaxFile(final Object form) {
        return std_syntax.syntaxSource(form);
    }
    
    static Pair $PcTestSourceLine2(final Object form) {
        final Object line = std_syntax.syntaxLine(form);
        final Object file = $PcTestSyntaxFile(form);
        final Object line$Mnpair = KawaConvert.isTrue(line) ? LList.list1(lists.cons(testing.Lit5, line)) : LList.Empty;
        return lists.cons(lists.cons(testing.Lit6, std_syntax.syntaxObject$To$Datum(form)), KawaConvert.isTrue(file) ? lists.cons(lists.cons(testing.Lit4, file), line$Mnpair) : line$Mnpair);
    }
    
    static Object $PcTestComp2(final Object comp, final Object x) {
        final Pair list3 = LList.list3(x, LList.list2(testing.Lit15.execute(null, TemplateScope.make()), $PcTestSourceLine2(x)), comp);
        final Object[] allocVars = SyntaxPattern.allocVars(6, null);
        return testing.Lit16.match(list3, allocVars, 0) ? testing.Lit17.execute(allocVars, TemplateScope.make()) : (testing.Lit18.match(list3, allocVars, 0) ? testing.Lit19.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", list3));
    }
    
    static {
        Lit189 = PairWithPosition.make(Lit9 = Symbol.valueOf("xpass"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2248760);
        Lit188 = PairWithPosition.make(Lit185 = PairWithPosition.make(Lit155 = Symbol.valueOf("test-runner-current"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3874842), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3874842);
        Lit187 = Symbol.valueOf("dynamic-wind");
        Lit186 = Symbol.valueOf("p");
        Lit184 = PairWithPosition.make(Lit169 = PairWithPosition.make(Lit163 = Symbol.valueOf("quote"), PairWithPosition.make(Symbol.valueOf("actual-value"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3432478), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3432478), Lit182 = PairWithPosition.make(Lit181 = Symbol.valueOf("res"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2801707), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2801693);
        Lit183 = Symbol.valueOf("exp");
        Lit180 = Symbol.valueOf("if");
        (Lit179 = new Object[] { null })[0] = testing.Lit163;
        Lit178 = PairWithPosition.make(testing.Lit163, PairWithPosition.make(Lit7 = Symbol.valueOf("test-name"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3670057), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3670057);
        Lit177 = Symbol.valueOf("name");
        Lit176 = PairWithPosition.make(PairWithPosition.make(Lit85 = Symbol.valueOf("%test-report-result"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3452936), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3452936);
        Lit175 = PairWithPosition.make(Lit167 = Symbol.valueOf("et"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3469355);
        Lit174 = Symbol.valueOf("instance?");
        Lit173 = Symbol.valueOf("cond");
        Lit172 = PairWithPosition.make(PairWithPosition.make(testing.Lit163, PairWithPosition.make(Symbol.valueOf("actual-error"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3444768), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3444768), PairWithPosition.make(Lit164 = Symbol.valueOf("ex"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3444781), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3444767);
        Lit171 = Symbol.valueOf("<java.lang.Throwable>");
        Lit170 = PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3436553);
        Lit168 = Symbol.valueOf("try-catch");
        Lit166 = PairWithPosition.make(testing.Lit163, PairWithPosition.make(Symbol.valueOf("expected-error"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3416093), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3416093);
        Lit165 = PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3416108);
        Lit162 = PairWithPosition.make(Lit159 = Symbol.valueOf("r"), Lit158 = PairWithPosition.make(PairWithPosition.make(Lit60 = Symbol.valueOf("test-runner-get"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4169748), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4169748), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3706891);
        Lit161 = PairWithPosition.make(testing.Lit162, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3706890);
        Lit160 = Symbol.valueOf("let*");
        Lit157 = Symbol.valueOf("saved-runner");
        Lit156 = Symbol.valueOf("lambda");
        Lit154 = PairWithPosition.make(Lit150 = Symbol.valueOf("runner"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4182046);
        Lit153 = Symbol.valueOf("cons");
        Lit152 = PairWithPosition.make(PairWithPosition.make(testing.Lit150, testing.Lit158, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4169740), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4169739);
        Lit151 = Symbol.valueOf("let");
        Lit149 = new Object[0];
        Lit148 = Symbol.valueOf("test-read-eval-string");
        Lit147 = Symbol.valueOf("test-match-name");
        Lit146 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", testing.Lit149, 1, "testing.scm:1017"), "\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$Q\u0011\u0018,\b\u0005\u0011\u00184\b\u0003\u0018<", new Object[] { testing.Lit151, testing.Lit152, Lit34 = Symbol.valueOf("%test-runner-fail-list!"), testing.Lit150, testing.Lit153, Lit137 = Symbol.valueOf("test-match-all"), Lit142 = Symbol.valueOf("%test-as-specifier"), PairWithPosition.make(PairWithPosition.make(Lit33 = Symbol.valueOf("%test-runner-fail-list"), testing.Lit154, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4182022), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4182022) }, 1) }, 1, Lit145 = Symbol.valueOf("test-expect-fail"));
        Lit144 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", testing.Lit149, 1, "testing.scm:1009"), "\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$Q\u0011\u0018,\b\u0005\u0011\u00184\b\u0003\u0018<", new Object[] { testing.Lit151, testing.Lit152, Lit32 = Symbol.valueOf("%test-runner-skip-list!"), testing.Lit150, testing.Lit153, testing.Lit137, testing.Lit142, PairWithPosition.make(PairWithPosition.make(Lit31 = Symbol.valueOf("%test-runner-skip-list"), testing.Lit154, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4149254), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 4149254) }, 1) }, 1, Lit143 = Symbol.valueOf("test-skip"));
        Lit141 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", testing.Lit149, 1, "testing.scm:996"), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\b\u0003", new Object[] { Lit139 = Symbol.valueOf("%test-match-any"), testing.Lit142 }, 1) }, 1, Lit140 = Symbol.valueOf("test-match-any"));
        Lit138 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\r\u0007\u0000\b\b", testing.Lit149, 1, "testing.scm:980"), "\u0003", "\u0011\u0018\u0004\b\u0005\u0011\u0018\f\b\u0003", new Object[] { Lit136 = Symbol.valueOf("%test-match-all"), testing.Lit142 }, 1) }, 1, testing.Lit137);
        Lit135 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", testing.Lit149, 1, "testing.scm:962"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", new Object[] { Lit134 = Symbol.valueOf("test-match-nth"), PairWithPosition.make(Lit13 = IntNum.valueOf(1), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3944472) }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", testing.Lit149, 2, "testing.scm:964"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[] { Lit133 = Symbol.valueOf("%test-match-nth") }, 0) }, 2, testing.Lit134);
        Lit132 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\r\u000f\b\b\b", testing.Lit149, 2, "testing.scm:945"), "\u0001\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014Y\u0011\u0018\u001c\t\u0010\b\u0011\u0018$\b\u0003A\u0011\u0018\u001c\t\u0010\b\r\u000b\u0018,", new Object[] { testing.Lit151, PairWithPosition.make(PairWithPosition.make(testing.Lit157, testing.Lit188, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3874828), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3874827), testing.Lit187, testing.Lit156, testing.Lit155, PairWithPosition.make(PairWithPosition.make(testing.Lit156, PairWithPosition.make(LList.Empty, PairWithPosition.make(PairWithPosition.make(testing.Lit155, PairWithPosition.make(testing.Lit157, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891244), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891223), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891223), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891220), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891212), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3891212) }, 1) }, 2, Lit131 = Symbol.valueOf("test-with-runner"));
        Lit130 = Symbol.valueOf("test-apply");
        Lit129 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b\u0013\b\u0011\u0018$\u0011\u0018\u001c\t,\b\u000b", new Object[] { testing.Lit160, testing.Lit161, Lit52 = Symbol.valueOf("test-result-alist!"), testing.Lit159, Lit120 = Symbol.valueOf("%test-error"), Boolean.TRUE }, 0);
        Lit128 = new SyntaxPattern(",\f\u0007\f\u000f\b\f\u0017\b", testing.Lit149, 3, "testing.scm:903");
        Lit127 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b\u001b\b\u0011\u0018$\u0011\u0018\u001c\t\u000b\b\u0013", new Object[] { testing.Lit160, testing.Lit161, testing.Lit52, testing.Lit159, testing.Lit120 }, 0);
        Lit126 = new SyntaxPattern("<\f\u0007\f\u000f\f\u0017\b\f\u001f\b", testing.Lit149, 4, "testing.scm:898");
        Lit125 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004I\u0011\u0018\f\b\u0011\u0018\u0014\b\u000b©\u0011\u0018\u001c\u0011\u0018$\b\u0011\u0018,A\u0011\u0018,\u0011\u00184\b\u000b\b#\b\u0011\u0018<\u0011\u0018$\t\u0013\b\u001b", new Object[] { testing.Lit160, testing.Lit162, testing.Lit177, testing.Lit52, testing.Lit159, testing.Lit153, testing.Lit178, testing.Lit120 }, 0);
        Lit124 = new SyntaxPattern("L\f\u0007\f\u000f\f\u0017\f\u001f\b\f'\b", testing.Lit149, 5, "testing.scm:892");
        Lit123 = new SyntaxTemplate("", "\u0018\u0004", testing.Lit179, 0);
        Lit122 = Symbol.valueOf("test-error");
        Lit121 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u0002\f\u000f\b", new Object[] { Boolean.TRUE }, 2, "testing.scm:832"), "\u0001\u0001", "\u0011\u0018\u0004\b)\u0011\u0018\f\b\u00039\u0011\u0018\u0014\t\u0003\u0018\u001c\u0169\u0011\u0018$\t\u0003\b\u0011\u0018,\u0091\u0011\u00184\t\u0010Q\u0011\u0018\u0014\t\u0003\u0011\u0018<\b\u000b\u0018D\b\u0011\u0018L\u0011\u0018T9\u0011\u0018\u0014\t\u0003\u0018\\\u0018d\u0018l", new Object[] { testing.Lit173, Lit88 = Symbol.valueOf("%test-on-test-begin"), Lit80 = Symbol.valueOf("test-result-set!"), PairWithPosition.make(testing.Lit166, testing.Lit165, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3416092), Lit89 = Symbol.valueOf("%test-on-test-end"), testing.Lit168, testing.Lit151, testing.Lit169, testing.Lit170, testing.Lit164, testing.Lit171, testing.Lit172, testing.Lit165, testing.Lit176 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", testing.Lit149, 3, "testing.scm:844"), "\u0001\u0001\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u00141\b\u0011\u0018\u001c\b\u000b9\u0011\u0018$\t\u0003\u0018,\u0169\u0011\u00184\t\u0003\b\u0011\u0018<\u0091\u0011\u0018\u0014\t\u0010Q\u0011\u0018$\t\u0003\u0011\u0018D\b\u0013\u0018L\b\u0011\u0018T\u0011\u0018\\9\u0011\u0018$\t\u0003\u0018d\u0018l\u0018t", new Object[] { testing.Lit180, testing.Lit88, testing.Lit151, testing.Lit167, testing.Lit80, PairWithPosition.make(testing.Lit166, testing.Lit175, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3469339), testing.Lit89, testing.Lit168, testing.Lit169, testing.Lit170, testing.Lit164, testing.Lit171, testing.Lit172, PairWithPosition.make(PairWithPosition.make(testing.Lit173, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("and"), PairWithPosition.make(PairWithPosition.make(testing.Lit174, PairWithPosition.make(testing.Lit167, PairWithPosition.make(Symbol.valueOf("<gnu.bytecode.ClassType>"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502116), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502113), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502102), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("$lookup$"), Pair.make(Symbol.valueOf("gnu.bytecode.ClassType"), Pair.make(Pair.make(Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf("isSubclass"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506185), PairWithPosition.make(testing.Lit167, PairWithPosition.make(testing.Lit171, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506222), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506219), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506184), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3506184), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502102), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502097), PairWithPosition.make(PairWithPosition.make(testing.Lit174, PairWithPosition.make(testing.Lit164, testing.Lit175, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3510293), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3510282), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3510282), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502096), PairWithPosition.make(PairWithPosition.make(Symbol.valueOf("else"), testing.Lit165, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3514377), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3514377), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502096), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502090), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 3502090), testing.Lit176 }, 0) }, 3, testing.Lit120);
        Lit119 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b#\b\u0011\u0018$\u0011\u0018\u001c)\u0011\u0018,\b\u001b\t\u000b\b\u0013", new Object[] { testing.Lit160, testing.Lit161, testing.Lit52, testing.Lit159, Lit91 = Symbol.valueOf("%test-comp2body"), Lit93 = Symbol.valueOf("%test-approximate=") }, 0);
        Lit118 = new SyntaxPattern("L\f\u0007\f\u000f\f\u0017\f\u001f\b\f'\b", testing.Lit149, 5, "testing.scm:743");
        Lit117 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004I\u0011\u0018\f\b\u0011\u0018\u0014\b\u000b©\u0011\u0018\u001c\u0011\u0018$\b\u0011\u0018,A\u0011\u0018,\u0011\u00184\b\u000b\b+\b\u0011\u0018<\u0011\u0018$)\u0011\u0018D\b#\t\u0013\b\u001b", new Object[] { testing.Lit160, testing.Lit162, testing.Lit177, testing.Lit52, testing.Lit159, testing.Lit153, testing.Lit178, testing.Lit91, testing.Lit93 }, 0);
        Lit116 = new SyntaxPattern("\\\f\u0007\f\u000f\f\u0017\f\u001f\f'\b\f/\b", testing.Lit149, 6, "testing.scm:737");
        Lit115 = new SyntaxTemplate("", "\u0018\u0004", testing.Lit179, 0);
        Lit114 = Symbol.valueOf("test-approximate");
        Lit113 = new SyntaxTemplate("", "\u0018\u0004", new Object[] { Symbol.valueOf("equal?") }, 0);
        Lit112 = Symbol.valueOf("test-equal");
        Lit111 = new SyntaxTemplate("", "\u0018\u0004", new Object[] { Symbol.valueOf("eq?") }, 0);
        Lit110 = Symbol.valueOf("test-eq");
        Lit109 = new SyntaxTemplate("", "\u0018\u0004", new Object[] { Symbol.valueOf("eqv?") }, 0);
        Lit108 = Symbol.valueOf("test-eqv");
        Lit107 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b\u0013\b\u0011\u0018$\u0011\u0018\u001c\b\u000b", new Object[] { testing.Lit160, testing.Lit161, testing.Lit52, testing.Lit159, Lit94 = Symbol.valueOf("%test-comp1body") }, 0);
        Lit106 = new SyntaxPattern(",\f\u0007\f\u000f\b\f\u0017\b", testing.Lit149, 3, "testing.scm:710");
        Lit105 = new SyntaxTemplate("\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004I\u0011\u0018\f\b\u0011\u0018\u0014\b\u000b©\u0011\u0018\u001c\u0011\u0018$\b\u0011\u0018,A\u0011\u0018,\u0011\u00184\b\u000b\b\u001b\b\u0011\u0018<\u0011\u0018$\b\u0013", new Object[] { testing.Lit160, testing.Lit162, testing.Lit177, testing.Lit52, testing.Lit159, testing.Lit153, testing.Lit178, testing.Lit94 }, 0);
        Lit104 = new SyntaxPattern("<\f\u0007\f\u000f\f\u0017\b\f\u001f\b", testing.Lit149, 4, "testing.scm:704");
        Lit103 = new SyntaxTemplate("", "\u0018\u0004", testing.Lit179, 0);
        Lit102 = Symbol.valueOf("test-assert");
        Lit101 = new SyntaxTemplate("\u0001\u0001", "\u0011\u0018\u0004\t\f\b\u000b", new Object[] { Lit71 = Symbol.valueOf("%test-end"), Boolean.FALSE }, 0);
        Lit100 = new SyntaxPattern("\u001c\f\u0007\b\f\u000f\b", testing.Lit149, 2, "testing.scm:698");
        Lit99 = new SyntaxTemplate("\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u000b\b\u0013", new Object[] { testing.Lit71 }, 0);
        Lit98 = new SyntaxPattern(",\f\u0007\f\u000f\b\f\u0017\b", testing.Lit149, 3, "testing.scm:695");
        Lit97 = new SyntaxTemplate("", "\u0018\u0004", testing.Lit179, 0);
        Lit96 = Symbol.valueOf("test-end");
        Lit95 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", testing.Lit149, 2, "testing.scm:679"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0010\u0171\u0011\u0018\f)\u0011\u0018\u0014\b\u0003\b\u0011\u0018\u0004\t\u0010\b\u0011\u0018\u0004Q\b\u0011\u0018\u001c\b\u0011\u0018$\b\u000b9\u0011\u0018,\t\u0003\u00184\b\u0011\u0018<\t\u0003\u0018D\u0018L", new Object[] { testing.Lit151, testing.Lit180, testing.Lit88, testing.Lit181, Lit86 = Symbol.valueOf("%test-evaluate-with-catch"), testing.Lit80, testing.Lit184, testing.Lit89, testing.Lit182, testing.Lit176 }, 0) }, 2, testing.Lit94);
        Lit92 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f\b", testing.Lit149, 4, "testing.scm:656"), "\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0010\u01f1\u0011\u0018\f)\u0011\u0018\u0014\b\u0003\b\u0011\u0018\u00041\b\u0011\u0018\u001c\b\u00139\u0011\u0018$\t\u0003\u0018,\b\u0011\u0018\u0004Q\b\u0011\u00184\b\u0011\u0018<\b\u001b9\u0011\u0018$\t\u0003\u0018D\b\u0011\u0018L\t\u0003\b\t\u000b\u0018T\u0018\\", new Object[] { testing.Lit151, testing.Lit180, testing.Lit88, testing.Lit183, testing.Lit80, PairWithPosition.make(PairWithPosition.make(testing.Lit163, PairWithPosition.make(Symbol.valueOf("expected-value"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2703386), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2703386), PairWithPosition.make(testing.Lit183, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2703401), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2703385), testing.Lit181, testing.Lit86, testing.Lit184, testing.Lit89, PairWithPosition.make(testing.Lit183, testing.Lit182, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2715682), testing.Lit176 }, 0) }, 4, testing.Lit91);
        Lit90 = Symbol.valueOf("test-runner-test-name");
        Lit87 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", testing.Lit149, 1, "testing.scm:582"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", new Object[] { testing.Lit168, PairWithPosition.make(PairWithPosition.make(testing.Lit164, PairWithPosition.make(testing.Lit171, PairWithPosition.make(PairWithPosition.make(testing.Lit80, PairWithPosition.make(testing.Lit185, testing.Lit172, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2396187), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2396169), testing.Lit170, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2396169), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2392073), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2392069), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2392069) }, 0) }, 1, testing.Lit86);
        Lit84 = Symbol.valueOf("test-passed?");
        Lit83 = Symbol.valueOf("test-result-kind");
        Lit82 = Symbol.valueOf("test-result-remove");
        Lit81 = Symbol.valueOf("test-result-clear");
        Lit79 = Symbol.valueOf("test-on-test-end-simple");
        Lit78 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", testing.Lit149, 2, "testing.scm:478"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\u000b\u0018\f", new Object[] { Lit77 = Symbol.valueOf("test-result-ref"), testing.Lit170 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", testing.Lit149, 3, "testing.scm:480"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\u0081\b\u0011\u0018\f\b\u0011\u0018\u0014\t\u000b\b\u0011\u0018\u001c\b\u0003\b\u0011\u0018$\u0011\u0018\f\u0011\u0018,\b\u0013", new Object[] { testing.Lit151, testing.Lit186, Symbol.valueOf("assq"), Lit51 = Symbol.valueOf("test-result-alist"), testing.Lit180, PairWithPosition.make(Symbol.valueOf("cdr"), PairWithPosition.make(testing.Lit186, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1974291), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1974286) }, 0) }, 3, testing.Lit77);
        Lit76 = Symbol.valueOf("test-on-test-begin-simple");
        Lit75 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\b", testing.Lit149, 3, "testing.scm:450"), "\u0001\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\u0011\u0018\u00149\u0011\u0018\u001c\t\u0010\b\u000b\b\u0011\u0018\u001c\t\u0010\b\u0013", new Object[] { Lit72 = Symbol.valueOf("test-group"), testing.Lit187, PairWithPosition.make(testing.Lit156, PairWithPosition.make(LList.Empty, testing.Lit170, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1855500), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1855492), testing.Lit156 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", testing.Lit149, 2, "testing.scm:456"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\t\f\b\u000b", new Object[] { Lit74 = Symbol.valueOf("test-group-with-cleanup"), Boolean.FALSE }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\f\u0017\f\u001f#", testing.Lit149, 5, "testing.scm:458"), "\u0001\u0001\u0001\u0001\u0000", "\u0011\u0018\u0004\t\u00039\u0011\u0018\f\t\u000b\b\u0013\t\u001b\"", new Object[] { testing.Lit74, Symbol.valueOf("begin") }, 0) }, 5, testing.Lit74);
        Lit73 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u000b", testing.Lit149, 2, "testing.scm:438"), "\u0001\u0000", "\u0011\u0018\u0004\u0011\u0018\f\u0099\u0011\u0018\u0014\u0011\u0018\u001c\b\u0011\u0018$\b\u0011\u0018,\u0011\u00184\b\u0003\b\u0011\u0018<\u0011\u0018D\b\u0011\u0018LY\u0011\u0018T\t\u0010\b\u0011\u0018\\\b\u00031\u0011\u0018T\t\u0010\n\b\u0011\u0018T\t\u0010\b\u0011\u0018d\b\u0003", new Object[] { testing.Lit151, PairWithPosition.make(PairWithPosition.make(testing.Lit159, testing.Lit188, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1798156), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1798155), testing.Lit52, testing.Lit159, Symbol.valueOf("list"), testing.Lit153, testing.Lit178, testing.Lit180, PairWithPosition.make(Lit62 = Symbol.valueOf("%test-should-execute"), PairWithPosition.make(testing.Lit159, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1810466), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1810444), testing.Lit187, testing.Lit156, Lit64 = Symbol.valueOf("test-begin"), testing.Lit96 }, 0) }, 2, testing.Lit72);
        Lit70 = Symbol.valueOf("test-on-final-simple");
        Lit69 = Symbol.valueOf("test-on-bad-end-name-simple");
        Lit68 = Symbol.valueOf("test-on-bad-count-simple");
        Lit67 = Symbol.valueOf("test-on-group-end-simple");
        Lit66 = Symbol.valueOf("test-on-group-begin-simple");
        Lit65 = new SyntaxRules(testing.Lit149, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", testing.Lit149, 1, "testing.scm:305"), "\u0001", "\u0011\u0018\u0004\t\u0003\u0018\f", new Object[] { Lit63 = Symbol.valueOf("%test-begin"), testing.Lit170 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", testing.Lit149, 2, "testing.scm:307"), "\u0001\u0001", "\u0011\u0018\u0004\t\u0003\b\u000b", new Object[] { testing.Lit63 }, 0) }, 2, testing.Lit64);
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
        Lit19 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\fA\u0011\u0018\u0014\u0011\u0018\u001c\b\u001b\b\u0011\u0018$\u0011\u0018\u001c\t#\t\u000b\b\u0013", new Object[] { testing.Lit160, testing.Lit161, testing.Lit52, testing.Lit159, testing.Lit91 }, 0);
        Lit18 = new SyntaxPattern("<\f\u0007\f\u000f\f\u0017\b\f\u001f\f'\b", testing.Lit149, 5, "testing.scm:723");
        Lit17 = new SyntaxTemplate("\u0001\u0001\u0001\u0001\u0001\u0001", "\u0011\u0018\u0004I\u0011\u0018\f\b\u0011\u0018\u0014\b\u000b©\u0011\u0018\u001c\u0011\u0018$\b\u0011\u0018,A\u0011\u0018,\u0011\u00184\b\u000b\b#\b\u0011\u0018<\u0011\u0018$\t+\t\u0013\b\u001b", new Object[] { testing.Lit160, testing.Lit162, testing.Lit177, testing.Lit52, testing.Lit159, testing.Lit153, testing.Lit178, testing.Lit91 }, 0);
        Lit16 = new SyntaxPattern("L\f\u0007\f\u000f\f\u0017\f\u001f\b\f'\f/\b", testing.Lit149, 6, "testing.scm:717");
        Lit15 = new SyntaxTemplate("", "\u0018\u0004", testing.Lit179, 0);
        Lit14 = Symbol.valueOf("pass");
        Lit12 = Symbol.valueOf("fail");
        Lit11 = PairWithPosition.make(testing.Lit14, testing.Lit189, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2248754);
        Lit10 = PairWithPosition.make(testing.Lit7, PairWithPosition.make(Lit4 = Symbol.valueOf("source-file"), PairWithPosition.make(Lit5 = Symbol.valueOf("source-line"), PairWithPosition.make(Lit6 = Symbol.valueOf("source-form"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2101290), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2101278), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2101266), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 2101255);
        Lit8 = PairWithPosition.make(testing.Lit12, testing.Lit189, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm", 1994773);
        Lit3 = Symbol.valueOf("xfail");
        Lit2 = Symbol.valueOf("skip");
        Lit1 = Symbol.valueOf("result-kind");
        Lit0 = IntNum.valueOf(0);
        test$Mnrunner = (ClassType)Type.make(test-runner.class);
        testing.$instance = new testing();
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
        final testing $instance = testing.$instance;
        test$Mnrunner$Qu = new ModuleMethod($instance, 12, testing.Lit20, 4097);
        test$Mnrunner$Mnpass$Mncount = new ModuleMethod($instance, 13, testing.Lit21, 4097);
        test$Mnrunner$Mnpass$Mncount$Ex = new ModuleMethod($instance, 14, testing.Lit22, 8194);
        test$Mnrunner$Mnfail$Mncount = new ModuleMethod($instance, 15, testing.Lit23, 4097);
        test$Mnrunner$Mnfail$Mncount$Ex = new ModuleMethod($instance, 16, testing.Lit24, 8194);
        test$Mnrunner$Mnxpass$Mncount = new ModuleMethod($instance, 17, testing.Lit25, 4097);
        test$Mnrunner$Mnxpass$Mncount$Ex = new ModuleMethod($instance, 18, testing.Lit26, 8194);
        test$Mnrunner$Mnxfail$Mncount = new ModuleMethod($instance, 19, testing.Lit27, 4097);
        test$Mnrunner$Mnxfail$Mncount$Ex = new ModuleMethod($instance, 20, testing.Lit28, 8194);
        test$Mnrunner$Mnskip$Mncount = new ModuleMethod($instance, 21, testing.Lit29, 4097);
        test$Mnrunner$Mnskip$Mncount$Ex = new ModuleMethod($instance, 22, testing.Lit30, 8194);
        $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist = new ModuleMethod($instance, 23, testing.Lit31, 4097);
        $Prvt$$Pctest$Mnrunner$Mnskip$Mnlist$Ex = new ModuleMethod($instance, 24, testing.Lit32, 8194);
        $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist = new ModuleMethod($instance, 25, testing.Lit33, 4097);
        $Prvt$$Pctest$Mnrunner$Mnfail$Mnlist$Ex = new ModuleMethod($instance, 26, testing.Lit34, 8194);
        test$Mnrunner$Mngroup$Mnstack = new ModuleMethod($instance, 27, testing.Lit35, 4097);
        test$Mnrunner$Mngroup$Mnstack$Ex = new ModuleMethod($instance, 28, testing.Lit36, 8194);
        test$Mnrunner$Mnon$Mntest$Mnbegin = new ModuleMethod($instance, 29, testing.Lit37, 4097);
        test$Mnrunner$Mnon$Mntest$Mnbegin$Ex = new ModuleMethod($instance, 30, testing.Lit38, 8194);
        test$Mnrunner$Mnon$Mntest$Mnend = new ModuleMethod($instance, 31, testing.Lit39, 4097);
        test$Mnrunner$Mnon$Mntest$Mnend$Ex = new ModuleMethod($instance, 32, testing.Lit40, 8194);
        test$Mnrunner$Mnon$Mngroup$Mnbegin = new ModuleMethod($instance, 33, testing.Lit41, 4097);
        test$Mnrunner$Mnon$Mngroup$Mnbegin$Ex = new ModuleMethod($instance, 34, testing.Lit42, 8194);
        test$Mnrunner$Mnon$Mngroup$Mnend = new ModuleMethod($instance, 35, testing.Lit43, 4097);
        test$Mnrunner$Mnon$Mngroup$Mnend$Ex = new ModuleMethod($instance, 36, testing.Lit44, 8194);
        test$Mnrunner$Mnon$Mnfinal = new ModuleMethod($instance, 37, testing.Lit45, 4097);
        test$Mnrunner$Mnon$Mnfinal$Ex = new ModuleMethod($instance, 38, testing.Lit46, 8194);
        test$Mnrunner$Mnon$Mnbad$Mncount = new ModuleMethod($instance, 39, testing.Lit47, 4097);
        test$Mnrunner$Mnon$Mnbad$Mncount$Ex = new ModuleMethod($instance, 40, testing.Lit48, 8194);
        test$Mnrunner$Mnon$Mnbad$Mnend$Mnname = new ModuleMethod($instance, 41, testing.Lit49, 4097);
        test$Mnrunner$Mnon$Mnbad$Mnend$Mnname$Ex = new ModuleMethod($instance, 42, testing.Lit50, 8194);
        test$Mnresult$Mnalist = new ModuleMethod($instance, 43, testing.Lit51, 4097);
        test$Mnresult$Mnalist$Ex = new ModuleMethod($instance, 44, testing.Lit52, 8194);
        test$Mnrunner$Mnaux$Mnvalue = new ModuleMethod($instance, 45, testing.Lit53, 4097);
        test$Mnrunner$Mnaux$Mnvalue$Ex = new ModuleMethod($instance, 46, testing.Lit54, 8194);
        test$Mnrunner$Mnreset = new ModuleMethod($instance, 47, testing.Lit55, 4097);
        test$Mnrunner$Mngroup$Mnpath = new ModuleMethod($instance, 48, testing.Lit56, 4097);
        $Pctest$Mnnull$Mncallback = new ModuleMethod($instance, 49, testing.Lit57, 4097);
        final ModuleMethod lambda$Fn4 = new ModuleMethod($instance, 50, null, 12291);
        lambda$Fn4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:199");
        lambda$Fn1 = lambda$Fn4;
        final ModuleMethod lambda$Fn5 = new ModuleMethod($instance, 51, null, 12291);
        lambda$Fn5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:204");
        lambda$Fn2 = lambda$Fn5;
        final ModuleMethod lambda$Fn6 = new ModuleMethod($instance, 52, null, 12291);
        lambda$Fn6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:205");
        lambda$Fn3 = lambda$Fn6;
        test$Mnrunner$Mnnull = new ModuleMethod($instance, 53, testing.Lit58, 0);
        test$Mnrunner$Mnsimple = new ModuleMethod($instance, 54, testing.Lit59, 0);
        test$Mnrunner$Mnget = new ModuleMethod($instance, 55, testing.Lit60, 0);
        test$Mnrunner$Mncreate = new ModuleMethod($instance, 56, testing.Lit61, 0);
        $Prvt$$Pctest$Mnshould$Mnexecute = new ModuleMethod($instance, 57, testing.Lit62, 4097);
        $Pctest$Mnbegin = new ModuleMethod($instance, 58, testing.Lit63, 8194);
        test$Mnbegin = Macro.make(testing.Lit64, testing.Lit65, "gnu.kawa.slib.testing");
        test$Mnon$Mngroup$Mnbegin$Mnsimple = new ModuleMethod($instance, 59, testing.Lit66, 12291);
        test$Mnon$Mngroup$Mnend$Mnsimple = new ModuleMethod($instance, 60, testing.Lit67, 4097);
        test$Mnon$Mnbad$Mncount$Mnsimple = new ModuleMethod($instance, 61, testing.Lit68, 12291);
        test$Mnon$Mnbad$Mnend$Mnname$Mnsimple = new ModuleMethod($instance, 62, testing.Lit69, 12291);
        test$Mnon$Mnfinal$Mnsimple = new ModuleMethod($instance, 63, testing.Lit70, 4097);
        $Prvt$$Pctest$Mnend = new ModuleMethod($instance, 64, testing.Lit71, 8194);
        test$Mngroup = Macro.make(testing.Lit72, testing.Lit73, "gnu.kawa.slib.testing");
        test$Mngroup$Mnwith$Mncleanup = Macro.make(testing.Lit74, testing.Lit75, "gnu.kawa.slib.testing");
        test$Mnon$Mntest$Mnbegin$Mnsimple = new ModuleMethod($instance, 65, testing.Lit76, 4097);
        test$Mnresult$Mnref = Macro.make(testing.Lit77, testing.Lit78, "gnu.kawa.slib.testing");
        test$Mnon$Mntest$Mnend$Mnsimple = new ModuleMethod($instance, 66, testing.Lit79, 4097);
        test$Mnresult$Mnset$Ex = new ModuleMethod($instance, 67, testing.Lit80, 12291);
        test$Mnresult$Mnclear = new ModuleMethod($instance, 68, testing.Lit81, 4097);
        test$Mnresult$Mnremove = new ModuleMethod($instance, 69, testing.Lit82, 8194);
        test$Mnresult$Mnkind = new ModuleMethod($instance, 70, testing.Lit83, -4096);
        test$Mnpassed$Qu = new ModuleMethod($instance, 71, testing.Lit84, -4096);
        $Prvt$$Pctest$Mnreport$Mnresult = new ModuleMethod($instance, 72, testing.Lit85, 0);
        $Prvt$$Pctest$Mnevaluate$Mnwith$Mncatch = Macro.make(testing.Lit86, testing.Lit87, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnon$Mntest$Mnbegin = new ModuleMethod($instance, 73, testing.Lit88, 4097);
        $Prvt$$Pctest$Mnon$Mntest$Mnend = new ModuleMethod($instance, 74, testing.Lit89, 8194);
        test$Mnrunner$Mntest$Mnname = new ModuleMethod($instance, 75, testing.Lit90, 4097);
        $Prvt$$Pctest$Mncomp2body = Macro.make(testing.Lit91, testing.Lit92, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnapproximate$Eq = new ModuleMethod($instance, 76, testing.Lit93, 4097);
        $Prvt$$Pctest$Mncomp1body = Macro.make(testing.Lit94, testing.Lit95, "gnu.kawa.slib.testing");
        final SimpleSymbol lit96 = testing.Lit96;
        final ModuleMethod expander = new ModuleMethod(testing.$instance, 77, null, 4097);
        expander.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:693");
        test$Mnend = Macro.make(lit96, expander, "gnu.kawa.slib.testing");
        final SimpleSymbol lit97 = testing.Lit102;
        final ModuleMethod expander2 = new ModuleMethod(testing.$instance, 78, null, 4097);
        expander2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:702");
        test$Mnassert = Macro.make(lit97, expander2, "gnu.kawa.slib.testing");
        final SimpleSymbol lit98 = testing.Lit108;
        final ModuleMethod expander3 = new ModuleMethod(testing.$instance, 79, null, 4097);
        expander3.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:729");
        test$Mneqv = Macro.make(lit98, expander3, "gnu.kawa.slib.testing");
        final SimpleSymbol lit99 = testing.Lit110;
        final ModuleMethod expander4 = new ModuleMethod(testing.$instance, 80, null, 4097);
        expander4.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:731");
        test$Mneq = Macro.make(lit99, expander4, "gnu.kawa.slib.testing");
        final SimpleSymbol lit100 = testing.Lit112;
        final ModuleMethod expander5 = new ModuleMethod(testing.$instance, 81, null, 4097);
        expander5.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:733");
        test$Mnequal = Macro.make(lit100, expander5, "gnu.kawa.slib.testing");
        final SimpleSymbol lit101 = testing.Lit114;
        final ModuleMethod expander6 = new ModuleMethod(testing.$instance, 82, null, 4097);
        expander6.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:735");
        test$Mnapproximate = Macro.make(lit101, expander6, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnerror = Macro.make(testing.Lit120, testing.Lit121, "gnu.kawa.slib.testing");
        final SimpleSymbol lit102 = testing.Lit122;
        final ModuleMethod expander7 = new ModuleMethod(testing.$instance, 83, null, 4097);
        expander7.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/testing.scm:890");
        test$Mnerror = Macro.make(lit102, expander7, "gnu.kawa.slib.testing");
        test$Mnapply = new ModuleMethod($instance, 84, testing.Lit130, -4095);
        test$Mnwith$Mnrunner = Macro.make(testing.Lit131, testing.Lit132, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnmatch$Mnnth = new ModuleMethod($instance, 85, testing.Lit133, 8194);
        test$Mnmatch$Mnnth = Macro.make(testing.Lit134, testing.Lit135, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnmatch$Mnall = new ModuleMethod($instance, 86, testing.Lit136, -4096);
        test$Mnmatch$Mnall = Macro.make(testing.Lit137, testing.Lit138, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnmatch$Mnany = new ModuleMethod($instance, 87, testing.Lit139, -4096);
        test$Mnmatch$Mnany = Macro.make(testing.Lit140, testing.Lit141, "gnu.kawa.slib.testing");
        $Prvt$$Pctest$Mnas$Mnspecifier = new ModuleMethod($instance, 88, testing.Lit142, 4097);
        test$Mnskip = Macro.make(testing.Lit143, testing.Lit144, "gnu.kawa.slib.testing");
        test$Mnexpect$Mnfail = Macro.make(testing.Lit145, testing.Lit146, "gnu.kawa.slib.testing");
        test$Mnmatch$Mnname = new ModuleMethod($instance, 89, testing.Lit147, 4097);
        test$Mnread$Mneval$Mnstring = new ModuleMethod($instance, 90, testing.Lit148, 4097);
        $runBody$();
    }
    
    public testing() {
        ModuleInfo.register(this);
    }
    
    static Object lambda16(final Object x) {
        final Pair list2 = LList.list2(x, LList.list2(testing.Lit97.execute(null, TemplateScope.make()), $PcTestSourceLine2(x)));
        final Object[] allocVars = SyntaxPattern.allocVars(3, null);
        return testing.Lit98.match(list2, allocVars, 0) ? testing.Lit99.execute(allocVars, TemplateScope.make()) : (testing.Lit100.match(list2, allocVars, 0) ? testing.Lit101.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", list2));
    }
    
    static Object lambda17(final Object x) {
        final Pair list2 = LList.list2(x, LList.list2(testing.Lit103.execute(null, TemplateScope.make()), $PcTestSourceLine2(x)));
        final Object[] allocVars = SyntaxPattern.allocVars(4, null);
        return testing.Lit104.match(list2, allocVars, 0) ? testing.Lit105.execute(allocVars, TemplateScope.make()) : (testing.Lit106.match(list2, allocVars, 0) ? testing.Lit107.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", list2));
    }
    
    static Object lambda18(final Object x) {
        return $PcTestComp2(testing.Lit109.execute(null, TemplateScope.make()), x);
    }
    
    static Object lambda19(final Object x) {
        return $PcTestComp2(testing.Lit111.execute(null, TemplateScope.make()), x);
    }
    
    static Object lambda20(final Object x) {
        return $PcTestComp2(testing.Lit113.execute(null, TemplateScope.make()), x);
    }
    
    static Object lambda21(final Object x) {
        final Pair list2 = LList.list2(x, LList.list2(testing.Lit115.execute(null, TemplateScope.make()), $PcTestSourceLine2(x)));
        final Object[] allocVars = SyntaxPattern.allocVars(6, null);
        return testing.Lit116.match(list2, allocVars, 0) ? testing.Lit117.execute(allocVars, TemplateScope.make()) : (testing.Lit118.match(list2, allocVars, 0) ? testing.Lit119.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", list2));
    }
    
    static Object lambda22(final Object x) {
        final Pair list2 = LList.list2(x, LList.list2(testing.Lit123.execute(null, TemplateScope.make()), $PcTestSourceLine2(x)));
        final Object[] allocVars = SyntaxPattern.allocVars(5, null);
        return testing.Lit124.match(list2, allocVars, 0) ? testing.Lit125.execute(allocVars, TemplateScope.make()) : (testing.Lit126.match(list2, allocVars, 0) ? testing.Lit127.execute(allocVars, TemplateScope.make()) : (testing.Lit128.match(list2, allocVars, 0) ? testing.Lit129.execute(allocVars, TemplateScope.make()) : syntax_case.error("syntax-case", list2)));
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 72: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 56: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 55: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 54: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            case 53: {
                ctx.proc = moduleMethod;
                return ctx.pc = 0;
            }
            default: {
                return super.match0(moduleMethod, ctx);
            }
        }
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 83: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 82: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 81: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 80: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 79: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 78: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 77: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 90: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 89: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 88: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 76: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 75: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 73: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 68: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 66: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 65: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 63: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 60: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 57: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 49: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 48: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 47: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 45: {
                final Object force = Promise.force(arg1, test-runner.class);
                if (!(force instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 43: {
                final Object force2 = Promise.force(arg1, test-runner.class);
                if (!(force2 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 41: {
                final Object force3 = Promise.force(arg1, test-runner.class);
                if (!(force3 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 39: {
                final Object force4 = Promise.force(arg1, test-runner.class);
                if (!(force4 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 37: {
                final Object force5 = Promise.force(arg1, test-runner.class);
                if (!(force5 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 35: {
                final Object force6 = Promise.force(arg1, test-runner.class);
                if (!(force6 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 33: {
                final Object force7 = Promise.force(arg1, test-runner.class);
                if (!(force7 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 31: {
                final Object force8 = Promise.force(arg1, test-runner.class);
                if (!(force8 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 29: {
                final Object force9 = Promise.force(arg1, test-runner.class);
                if (!(force9 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 27: {
                final Object force10 = Promise.force(arg1, test-runner.class);
                if (!(force10 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force10;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 25: {
                final Object force11 = Promise.force(arg1, test-runner.class);
                if (!(force11 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 23: {
                final Object force12 = Promise.force(arg1, test-runner.class);
                if (!(force12 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force12;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 21: {
                final Object force13 = Promise.force(arg1, test-runner.class);
                if (!(force13 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force13;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 19: {
                final Object force14 = Promise.force(arg1, test-runner.class);
                if (!(force14 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force14;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 17: {
                final Object force15 = Promise.force(arg1, test-runner.class);
                if (!(force15 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force15;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 15: {
                final Object force16 = Promise.force(arg1, test-runner.class);
                if (!(force16 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force16;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 13: {
                final Object force17 = Promise.force(arg1, test-runner.class);
                if (!(force17 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force17;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 12: {
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
    public int match2(final ModuleMethod proc, final Object arg1, final Object arg2, final CallContext ctx) {
        switch (proc.selector) {
            case 85: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 74: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 69: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 64: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 58: {
                ctx.value1 = arg1;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 46: {
                final Object force = Promise.force(arg1, test-runner.class);
                if (!(force instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 44: {
                final Object force2 = Promise.force(arg1, test-runner.class);
                if (!(force2 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 42: {
                final Object force3 = Promise.force(arg1, test-runner.class);
                if (!(force3 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force3;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 40: {
                final Object force4 = Promise.force(arg1, test-runner.class);
                if (!(force4 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force4;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 38: {
                final Object force5 = Promise.force(arg1, test-runner.class);
                if (!(force5 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force5;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 36: {
                final Object force6 = Promise.force(arg1, test-runner.class);
                if (!(force6 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force6;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 34: {
                final Object force7 = Promise.force(arg1, test-runner.class);
                if (!(force7 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force7;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 32: {
                final Object force8 = Promise.force(arg1, test-runner.class);
                if (!(force8 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force8;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 30: {
                final Object force9 = Promise.force(arg1, test-runner.class);
                if (!(force9 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force9;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 28: {
                final Object force10 = Promise.force(arg1, test-runner.class);
                if (!(force10 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force10;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 26: {
                final Object force11 = Promise.force(arg1, test-runner.class);
                if (!(force11 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force11;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 24: {
                final Object force12 = Promise.force(arg1, test-runner.class);
                if (!(force12 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force12;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 22: {
                final Object force13 = Promise.force(arg1, test-runner.class);
                if (!(force13 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force13;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 20: {
                final Object force14 = Promise.force(arg1, test-runner.class);
                if (!(force14 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force14;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 18: {
                final Object force15 = Promise.force(arg1, test-runner.class);
                if (!(force15 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force15;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 16: {
                final Object force16 = Promise.force(arg1, test-runner.class);
                if (!(force16 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force16;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            case 14: {
                final Object force17 = Promise.force(arg1, test-runner.class);
                if (!(force17 instanceof test-runner)) {
                    return -786431;
                }
                ctx.value1 = force17;
                ctx.value2 = arg2;
                ctx.proc = proc;
                ctx.pc = 2;
                return 0;
            }
            default: {
                return super.match2(proc, arg1, arg2, ctx);
            }
        }
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 67: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 62: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 61: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 59: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 52: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 51: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            case 50: {
                ctx.value1 = o;
                ctx.value2 = o2;
                ctx.value3 = o3;
                ctx.proc = moduleMethod;
                ctx.pc = 3;
                return 0;
            }
            default: {
                return super.match3(moduleMethod, o, o2, o3, ctx);
            }
        }
    }
    
    @Override
    public int matchN(final ModuleMethod moduleMethod, final Object[] array, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 87: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 86: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 84: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 71: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            case 70: {
                ctx.values = array;
                ctx.proc = moduleMethod;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(moduleMethod, array, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply0(final ModuleMethod method) {
        switch (method.selector) {
            case 53: {
                return testRunnerNull();
            }
            case 54: {
                return testRunnerSimple();
            }
            case 55: {
                return testRunnerGet();
            }
            case 56: {
                return testRunnerCreate();
            }
            case 72: {
                return $PcTestReportResult();
            }
            default: {
                return super.apply0(method);
            }
        }
    }
    
    @Override
    public Object apply1(final ModuleMethod p0, final Object p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: tableswitch {
        //               24: 336
        //               25: 353
        //               26: 732
        //               27: 366
        //               28: 732
        //               29: 379
        //               30: 732
        //               31: 392
        //               32: 732
        //               33: 405
        //               34: 732
        //               35: 418
        //               36: 732
        //               37: 431
        //               38: 732
        //               39: 444
        //               40: 732
        //               41: 457
        //               42: 732
        //               43: 470
        //               44: 732
        //               45: 483
        //               46: 732
        //               47: 496
        //               48: 732
        //               49: 509
        //               50: 732
        //               51: 522
        //               52: 732
        //               53: 535
        //               54: 732
        //               55: 548
        //               56: 732
        //               57: 561
        //               58: 732
        //               59: 574
        //               60: 582
        //               61: 587
        //               62: 732
        //               63: 732
        //               64: 732
        //               65: 732
        //               66: 732
        //               67: 732
        //               68: 732
        //               69: 604
        //               70: 732
        //               71: 732
        //               72: 609
        //               73: 732
        //               74: 732
        //               75: 626
        //               76: 732
        //               77: 634
        //               78: 642
        //               79: 732
        //               80: 647
        //               81: 732
        //               82: 732
        //               83: 732
        //               84: 732
        //               85: 655
        //               86: 732
        //               87: 672
        //               88: 677
        //               89: 697
        //               90: 702
        //               91: 707
        //               92: 712
        //               93: 717
        //               94: 722
        //               95: 727
        //               96: 732
        //               97: 732
        //               98: 732
        //               99: 732
        //              100: 682
        //              101: 687
        //              102: 692
        //          default: 732
        //        }
        //   336: aload_2        
        //   337: invokestatic    gnu/kawa/slib/testing.isTestRunner:(Ljava/lang/Object;)Z
        //   340: ifeq            349
        //   343: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   346: goto            352
        //   349: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   352: areturn        
        //   353: aload_2        
        //   354: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   356: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   359: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   362: invokestatic    gnu/kawa/slib/testing.testRunnerPassCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   365: areturn        
        //   366: aload_2        
        //   367: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   369: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   372: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   375: invokestatic    gnu/kawa/slib/testing.testRunnerFailCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   378: areturn        
        //   379: aload_2        
        //   380: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   382: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   385: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   388: invokestatic    gnu/kawa/slib/testing.testRunnerXpassCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   391: areturn        
        //   392: aload_2        
        //   393: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   395: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   398: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   401: invokestatic    gnu/kawa/slib/testing.testRunnerXfailCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   404: areturn        
        //   405: aload_2        
        //   406: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   408: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   411: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   414: invokestatic    gnu/kawa/slib/testing.testRunnerSkipCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   417: areturn        
        //   418: aload_2        
        //   419: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   421: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   424: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   427: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   430: areturn        
        //   431: aload_2        
        //   432: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   434: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   437: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   440: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailList:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   443: areturn        
        //   444: aload_2        
        //   445: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   447: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   450: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   453: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   456: areturn        
        //   457: aload_2        
        //   458: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   460: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   463: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   466: invokestatic    gnu/kawa/slib/testing.testRunnerOnTestBegin:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   469: areturn        
        //   470: aload_2        
        //   471: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   473: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   476: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   479: invokestatic    gnu/kawa/slib/testing.testRunnerOnTestEnd:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   482: areturn        
        //   483: aload_2        
        //   484: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   486: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   489: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   492: invokestatic    gnu/kawa/slib/testing.testRunnerOnGroupBegin:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   495: areturn        
        //   496: aload_2        
        //   497: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   499: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   502: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   505: invokestatic    gnu/kawa/slib/testing.testRunnerOnGroupEnd:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   508: areturn        
        //   509: aload_2        
        //   510: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   512: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   515: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   518: invokestatic    gnu/kawa/slib/testing.testRunnerOnFinal:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   521: areturn        
        //   522: aload_2        
        //   523: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   525: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   528: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   531: invokestatic    gnu/kawa/slib/testing.testRunnerOnBadCount:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   534: areturn        
        //   535: aload_2        
        //   536: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   538: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   541: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   544: invokestatic    gnu/kawa/slib/testing.testRunnerOnBadEndName:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   547: areturn        
        //   548: aload_2        
        //   549: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   551: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   554: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   557: invokestatic    gnu/kawa/slib/testing.testResultAlist:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   560: areturn        
        //   561: aload_2        
        //   562: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   564: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   567: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   570: invokestatic    gnu/kawa/slib/testing.testRunnerAuxValue:(Lgnu/kawa/slib/testing$test-runner;)Ljava/lang/Object;
        //   573: areturn        
        //   574: aload_2        
        //   575: invokestatic    gnu/kawa/slib/testing.testRunnerReset:(Ljava/lang/Object;)V
        //   578: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   581: areturn        
        //   582: aload_2        
        //   583: invokestatic    gnu/kawa/slib/testing.testRunnerGroupPath:(Ljava/lang/Object;)Lgnu/lists/LList;
        //   586: areturn        
        //   587: aload_2        
        //   588: invokestatic    gnu/kawa/slib/testing.$PcTestNullCallback:(Ljava/lang/Object;)Z
        //   591: ifeq            600
        //   594: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   597: goto            603
        //   600: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   603: areturn        
        //   604: aload_2        
        //   605: invokestatic    gnu/kawa/slib/testing.$PcTestShouldExecute:(Ljava/lang/Object;)Ljava/lang/Object;
        //   608: areturn        
        //   609: aload_2        
        //   610: invokestatic    gnu/kawa/slib/testing.testOnGroupEndSimple:(Ljava/lang/Object;)Z
        //   613: ifeq            622
        //   616: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   619: goto            625
        //   622: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   625: areturn        
        //   626: aload_2        
        //   627: invokestatic    gnu/kawa/slib/testing.testOnFinalSimple:(Ljava/lang/Object;)V
        //   630: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   633: areturn        
        //   634: aload_2        
        //   635: invokestatic    gnu/kawa/slib/testing.testOnTestBeginSimple:(Ljava/lang/Object;)V
        //   638: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   641: areturn        
        //   642: aload_2        
        //   643: invokestatic    gnu/kawa/slib/testing.testOnTestEndSimple:(Ljava/lang/Object;)Ljava/lang/Object;
        //   646: areturn        
        //   647: aload_2        
        //   648: invokestatic    gnu/kawa/slib/testing.testResultClear:(Ljava/lang/Object;)V
        //   651: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   654: areturn        
        //   655: aload_2        
        //   656: invokestatic    gnu/kawa/slib/testing.$PcTestOnTestBegin:(Ljava/lang/Object;)Z
        //   659: ifeq            668
        //   662: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   665: goto            671
        //   668: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   671: areturn        
        //   672: aload_2        
        //   673: invokestatic    gnu/kawa/slib/testing.testRunnerTestName:(Ljava/lang/Object;)Ljava/lang/Object;
        //   676: areturn        
        //   677: aload_2        
        //   678: invokestatic    gnu/kawa/slib/testing.$PcTestApproximate$Eq:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   681: areturn        
        //   682: aload_2        
        //   683: invokestatic    gnu/kawa/slib/testing.$PcTestAsSpecifier:(Ljava/lang/Object;)Ljava/lang/Object;
        //   686: areturn        
        //   687: aload_2        
        //   688: invokestatic    gnu/kawa/slib/testing.testMatchName:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   691: areturn        
        //   692: aload_2        
        //   693: invokestatic    gnu/kawa/slib/testing.testReadEvalString:(Ljava/lang/Object;)Ljava/lang/Object;
        //   696: areturn        
        //   697: aload_2        
        //   698: invokestatic    gnu/kawa/slib/testing.lambda16:(Ljava/lang/Object;)Ljava/lang/Object;
        //   701: areturn        
        //   702: aload_2        
        //   703: invokestatic    gnu/kawa/slib/testing.lambda17:(Ljava/lang/Object;)Ljava/lang/Object;
        //   706: areturn        
        //   707: aload_2        
        //   708: invokestatic    gnu/kawa/slib/testing.lambda18:(Ljava/lang/Object;)Ljava/lang/Object;
        //   711: areturn        
        //   712: aload_2        
        //   713: invokestatic    gnu/kawa/slib/testing.lambda19:(Ljava/lang/Object;)Ljava/lang/Object;
        //   716: areturn        
        //   717: aload_2        
        //   718: invokestatic    gnu/kawa/slib/testing.lambda20:(Ljava/lang/Object;)Ljava/lang/Object;
        //   721: areturn        
        //   722: aload_2        
        //   723: invokestatic    gnu/kawa/slib/testing.lambda21:(Ljava/lang/Object;)Ljava/lang/Object;
        //   726: areturn        
        //   727: aload_2        
        //   728: invokestatic    gnu/kawa/slib/testing.lambda22:(Ljava/lang/Object;)Ljava/lang/Object;
        //   731: areturn        
        //   732: aload_0        
        //   733: aload_1        
        //   734: aload_2        
        //   735: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   738: areturn        
        //   739: new             Lgnu/mapping/WrongType;
        //   742: dup_x1         
        //   743: swap           
        //   744: ldc_w           "test-runner-pass-count"
        //   747: iconst_1       
        //   748: aload_2        
        //   749: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   752: athrow         
        //   753: new             Lgnu/mapping/WrongType;
        //   756: dup_x1         
        //   757: swap           
        //   758: ldc_w           "test-runner-fail-count"
        //   761: iconst_1       
        //   762: aload_2        
        //   763: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   766: athrow         
        //   767: new             Lgnu/mapping/WrongType;
        //   770: dup_x1         
        //   771: swap           
        //   772: ldc_w           "test-runner-xpass-count"
        //   775: iconst_1       
        //   776: aload_2        
        //   777: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   780: athrow         
        //   781: new             Lgnu/mapping/WrongType;
        //   784: dup_x1         
        //   785: swap           
        //   786: ldc_w           "test-runner-xfail-count"
        //   789: iconst_1       
        //   790: aload_2        
        //   791: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   794: athrow         
        //   795: new             Lgnu/mapping/WrongType;
        //   798: dup_x1         
        //   799: swap           
        //   800: ldc_w           "test-runner-skip-count"
        //   803: iconst_1       
        //   804: aload_2        
        //   805: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   808: athrow         
        //   809: new             Lgnu/mapping/WrongType;
        //   812: dup_x1         
        //   813: swap           
        //   814: ldc_w           "%test-runner-skip-list"
        //   817: iconst_1       
        //   818: aload_2        
        //   819: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   822: athrow         
        //   823: new             Lgnu/mapping/WrongType;
        //   826: dup_x1         
        //   827: swap           
        //   828: ldc_w           "%test-runner-fail-list"
        //   831: iconst_1       
        //   832: aload_2        
        //   833: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   836: athrow         
        //   837: new             Lgnu/mapping/WrongType;
        //   840: dup_x1         
        //   841: swap           
        //   842: ldc             "test-runner-group-stack"
        //   844: iconst_1       
        //   845: aload_2        
        //   846: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   849: athrow         
        //   850: new             Lgnu/mapping/WrongType;
        //   853: dup_x1         
        //   854: swap           
        //   855: ldc_w           "test-runner-on-test-begin"
        //   858: iconst_1       
        //   859: aload_2        
        //   860: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   863: athrow         
        //   864: new             Lgnu/mapping/WrongType;
        //   867: dup_x1         
        //   868: swap           
        //   869: ldc_w           "test-runner-on-test-end"
        //   872: iconst_1       
        //   873: aload_2        
        //   874: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   877: athrow         
        //   878: new             Lgnu/mapping/WrongType;
        //   881: dup_x1         
        //   882: swap           
        //   883: ldc_w           "test-runner-on-group-begin"
        //   886: iconst_1       
        //   887: aload_2        
        //   888: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   891: athrow         
        //   892: new             Lgnu/mapping/WrongType;
        //   895: dup_x1         
        //   896: swap           
        //   897: ldc_w           "test-runner-on-group-end"
        //   900: iconst_1       
        //   901: aload_2        
        //   902: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   905: athrow         
        //   906: new             Lgnu/mapping/WrongType;
        //   909: dup_x1         
        //   910: swap           
        //   911: ldc_w           "test-runner-on-final"
        //   914: iconst_1       
        //   915: aload_2        
        //   916: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   919: athrow         
        //   920: new             Lgnu/mapping/WrongType;
        //   923: dup_x1         
        //   924: swap           
        //   925: ldc_w           "test-runner-on-bad-count"
        //   928: iconst_1       
        //   929: aload_2        
        //   930: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   933: athrow         
        //   934: new             Lgnu/mapping/WrongType;
        //   937: dup_x1         
        //   938: swap           
        //   939: ldc_w           "test-runner-on-bad-end-name"
        //   942: iconst_1       
        //   943: aload_2        
        //   944: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   947: athrow         
        //   948: new             Lgnu/mapping/WrongType;
        //   951: dup_x1         
        //   952: swap           
        //   953: ldc_w           "test-result-alist"
        //   956: iconst_1       
        //   957: aload_2        
        //   958: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   961: athrow         
        //   962: new             Lgnu/mapping/WrongType;
        //   965: dup_x1         
        //   966: swap           
        //   967: ldc_w           "test-runner-aux-value"
        //   970: iconst_1       
        //   971: aload_2        
        //   972: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   975: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  359    362    739    753    Ljava/lang/ClassCastException;
        //  372    375    753    767    Ljava/lang/ClassCastException;
        //  385    388    767    781    Ljava/lang/ClassCastException;
        //  398    401    781    795    Ljava/lang/ClassCastException;
        //  411    414    795    809    Ljava/lang/ClassCastException;
        //  424    427    809    823    Ljava/lang/ClassCastException;
        //  437    440    823    837    Ljava/lang/ClassCastException;
        //  450    453    837    850    Ljava/lang/ClassCastException;
        //  463    466    850    864    Ljava/lang/ClassCastException;
        //  476    479    864    878    Ljava/lang/ClassCastException;
        //  489    492    878    892    Ljava/lang/ClassCastException;
        //  502    505    892    906    Ljava/lang/ClassCastException;
        //  515    518    906    920    Ljava/lang/ClassCastException;
        //  528    531    920    934    Ljava/lang/ClassCastException;
        //  541    544    934    948    Ljava/lang/ClassCastException;
        //  554    557    948    962    Ljava/lang/ClassCastException;
        //  567    570    962    976    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 335 out of bounds for length 335
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: lookupswitch {
        //               14: 192
        //               16: 209
        //               18: 226
        //               20: 243
        //               22: 260
        //               24: 277
        //               26: 294
        //               28: 311
        //               30: 328
        //               32: 345
        //               34: 362
        //               36: 379
        //               38: 396
        //               40: 413
        //               42: 430
        //               44: 447
        //               46: 464
        //               58: 481
        //               64: 490
        //               69: 496
        //               74: 505
        //               85: 514
        //          default: 520
        //        }
        //   192: aload_2        
        //   193: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   195: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   198: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   201: aload_3        
        //   202: invokestatic    gnu/kawa/slib/testing.testRunnerPassCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   205: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   208: areturn        
        //   209: aload_2        
        //   210: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   212: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   215: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   218: aload_3        
        //   219: invokestatic    gnu/kawa/slib/testing.testRunnerFailCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   222: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   225: areturn        
        //   226: aload_2        
        //   227: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   229: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   232: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   235: aload_3        
        //   236: invokestatic    gnu/kawa/slib/testing.testRunnerXpassCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   239: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   242: areturn        
        //   243: aload_2        
        //   244: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   246: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   249: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   252: aload_3        
        //   253: invokestatic    gnu/kawa/slib/testing.testRunnerXfailCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   256: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   259: areturn        
        //   260: aload_2        
        //   261: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   263: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   266: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   269: aload_3        
        //   270: invokestatic    gnu/kawa/slib/testing.testRunnerSkipCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   273: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   276: areturn        
        //   277: aload_2        
        //   278: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   280: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   283: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   286: aload_3        
        //   287: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerSkipList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   290: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   293: areturn        
        //   294: aload_2        
        //   295: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   297: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   300: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   303: aload_3        
        //   304: invokestatic    gnu/kawa/slib/testing.$PcTestRunnerFailList$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   307: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   310: areturn        
        //   311: aload_2        
        //   312: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   314: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   317: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   320: aload_3        
        //   321: invokestatic    gnu/kawa/slib/testing.testRunnerGroupStack$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   324: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   327: areturn        
        //   328: aload_2        
        //   329: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   331: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   334: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   337: aload_3        
        //   338: invokestatic    gnu/kawa/slib/testing.testRunnerOnTestBegin$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   341: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   344: areturn        
        //   345: aload_2        
        //   346: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   348: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   351: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   354: aload_3        
        //   355: invokestatic    gnu/kawa/slib/testing.testRunnerOnTestEnd$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   358: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   361: areturn        
        //   362: aload_2        
        //   363: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   365: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   368: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   371: aload_3        
        //   372: invokestatic    gnu/kawa/slib/testing.testRunnerOnGroupBegin$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   375: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   378: areturn        
        //   379: aload_2        
        //   380: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   382: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   385: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   388: aload_3        
        //   389: invokestatic    gnu/kawa/slib/testing.testRunnerOnGroupEnd$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   392: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   395: areturn        
        //   396: aload_2        
        //   397: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   399: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   402: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   405: aload_3        
        //   406: invokestatic    gnu/kawa/slib/testing.testRunnerOnFinal$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   409: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   412: areturn        
        //   413: aload_2        
        //   414: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   416: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   419: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   422: aload_3        
        //   423: invokestatic    gnu/kawa/slib/testing.testRunnerOnBadCount$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   426: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   429: areturn        
        //   430: aload_2        
        //   431: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   433: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   436: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   439: aload_3        
        //   440: invokestatic    gnu/kawa/slib/testing.testRunnerOnBadEndName$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   443: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   446: areturn        
        //   447: aload_2        
        //   448: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   450: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   453: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   456: aload_3        
        //   457: invokestatic    gnu/kawa/slib/testing.testResultAlist$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   460: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   463: areturn        
        //   464: aload_2        
        //   465: ldc             Lgnu/kawa/slib/testing$test-runner;.class
        //   467: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   470: checkcast       Lgnu/kawa/slib/testing$test-runner;
        //   473: aload_3        
        //   474: invokestatic    gnu/kawa/slib/testing.testRunnerAuxValue$Ex:(Lgnu/kawa/slib/testing$test-runner;Ljava/lang/Object;)V
        //   477: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   480: areturn        
        //   481: aload_2        
        //   482: aload_3        
        //   483: invokestatic    gnu/kawa/slib/testing.$PcTestBegin:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   486: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   489: areturn        
        //   490: aload_2        
        //   491: aload_3        
        //   492: invokestatic    gnu/kawa/slib/testing.$PcTestEnd:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   495: areturn        
        //   496: aload_2        
        //   497: aload_3        
        //   498: invokestatic    gnu/kawa/slib/testing.testResultRemove:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   501: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   504: areturn        
        //   505: aload_2        
        //   506: aload_3        
        //   507: invokestatic    gnu/kawa/slib/testing.$PcTestOnTestEnd:(Ljava/lang/Object;Ljava/lang/Object;)V
        //   510: getstatic       gnu/mapping/Values.empty:Lgnu/mapping/Values;
        //   513: areturn        
        //   514: aload_2        
        //   515: aload_3        
        //   516: invokestatic    gnu/kawa/slib/testing.$PcTestMatchNth:(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //   519: areturn        
        //   520: aload_0        
        //   521: aload_1        
        //   522: aload_2        
        //   523: aload_3        
        //   524: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   527: areturn        
        //   528: new             Lgnu/mapping/WrongType;
        //   531: dup_x1         
        //   532: swap           
        //   533: ldc             "test-runner-pass-count!"
        //   535: iconst_1       
        //   536: aload_2        
        //   537: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   540: athrow         
        //   541: new             Lgnu/mapping/WrongType;
        //   544: dup_x1         
        //   545: swap           
        //   546: ldc             "test-runner-fail-count!"
        //   548: iconst_1       
        //   549: aload_2        
        //   550: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   553: athrow         
        //   554: new             Lgnu/mapping/WrongType;
        //   557: dup_x1         
        //   558: swap           
        //   559: ldc             "test-runner-xpass-count!"
        //   561: iconst_1       
        //   562: aload_2        
        //   563: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   566: athrow         
        //   567: new             Lgnu/mapping/WrongType;
        //   570: dup_x1         
        //   571: swap           
        //   572: ldc             "test-runner-xfail-count!"
        //   574: iconst_1       
        //   575: aload_2        
        //   576: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   579: athrow         
        //   580: new             Lgnu/mapping/WrongType;
        //   583: dup_x1         
        //   584: swap           
        //   585: ldc             "test-runner-skip-count!"
        //   587: iconst_1       
        //   588: aload_2        
        //   589: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   592: athrow         
        //   593: new             Lgnu/mapping/WrongType;
        //   596: dup_x1         
        //   597: swap           
        //   598: ldc             "%test-runner-skip-list!"
        //   600: iconst_1       
        //   601: aload_2        
        //   602: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   605: athrow         
        //   606: new             Lgnu/mapping/WrongType;
        //   609: dup_x1         
        //   610: swap           
        //   611: ldc             "%test-runner-fail-list!"
        //   613: iconst_1       
        //   614: aload_2        
        //   615: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   618: athrow         
        //   619: new             Lgnu/mapping/WrongType;
        //   622: dup_x1         
        //   623: swap           
        //   624: ldc             "test-runner-group-stack!"
        //   626: iconst_1       
        //   627: aload_2        
        //   628: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   631: athrow         
        //   632: new             Lgnu/mapping/WrongType;
        //   635: dup_x1         
        //   636: swap           
        //   637: ldc_w           "test-runner-on-test-begin!"
        //   640: iconst_1       
        //   641: aload_2        
        //   642: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   645: athrow         
        //   646: new             Lgnu/mapping/WrongType;
        //   649: dup_x1         
        //   650: swap           
        //   651: ldc_w           "test-runner-on-test-end!"
        //   654: iconst_1       
        //   655: aload_2        
        //   656: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   659: athrow         
        //   660: new             Lgnu/mapping/WrongType;
        //   663: dup_x1         
        //   664: swap           
        //   665: ldc_w           "test-runner-on-group-begin!"
        //   668: iconst_1       
        //   669: aload_2        
        //   670: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   673: athrow         
        //   674: new             Lgnu/mapping/WrongType;
        //   677: dup_x1         
        //   678: swap           
        //   679: ldc_w           "test-runner-on-group-end!"
        //   682: iconst_1       
        //   683: aload_2        
        //   684: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   687: athrow         
        //   688: new             Lgnu/mapping/WrongType;
        //   691: dup_x1         
        //   692: swap           
        //   693: ldc_w           "test-runner-on-final!"
        //   696: iconst_1       
        //   697: aload_2        
        //   698: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   701: athrow         
        //   702: new             Lgnu/mapping/WrongType;
        //   705: dup_x1         
        //   706: swap           
        //   707: ldc_w           "test-runner-on-bad-count!"
        //   710: iconst_1       
        //   711: aload_2        
        //   712: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   715: athrow         
        //   716: new             Lgnu/mapping/WrongType;
        //   719: dup_x1         
        //   720: swap           
        //   721: ldc_w           "test-runner-on-bad-end-name!"
        //   724: iconst_1       
        //   725: aload_2        
        //   726: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   729: athrow         
        //   730: new             Lgnu/mapping/WrongType;
        //   733: dup_x1         
        //   734: swap           
        //   735: ldc             "test-result-alist!"
        //   737: iconst_1       
        //   738: aload_2        
        //   739: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   742: athrow         
        //   743: new             Lgnu/mapping/WrongType;
        //   746: dup_x1         
        //   747: swap           
        //   748: ldc_w           "test-runner-aux-value!"
        //   751: iconst_1       
        //   752: aload_2        
        //   753: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   756: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  198    201    528    541    Ljava/lang/ClassCastException;
        //  215    218    541    554    Ljava/lang/ClassCastException;
        //  232    235    554    567    Ljava/lang/ClassCastException;
        //  249    252    567    580    Ljava/lang/ClassCastException;
        //  266    269    580    593    Ljava/lang/ClassCastException;
        //  283    286    593    606    Ljava/lang/ClassCastException;
        //  300    303    606    619    Ljava/lang/ClassCastException;
        //  317    320    619    632    Ljava/lang/ClassCastException;
        //  334    337    632    646    Ljava/lang/ClassCastException;
        //  351    354    646    660    Ljava/lang/ClassCastException;
        //  368    371    660    674    Ljava/lang/ClassCastException;
        //  385    388    674    688    Ljava/lang/ClassCastException;
        //  402    405    688    702    Ljava/lang/ClassCastException;
        //  419    422    702    716    Ljava/lang/ClassCastException;
        //  436    439    716    730    Ljava/lang/ClassCastException;
        //  453    456    730    743    Ljava/lang/ClassCastException;
        //  470    473    743    757    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 304 out of bounds for length 304
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object apply3(final ModuleMethod method, final Object o, final Object o2, final Object o3) {
        switch (method.selector) {
            case 50: {
                return lambda1(o, o2, o3) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 51: {
                return lambda2(o, o2, o3) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 52: {
                return lambda3(o, o2, o3) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 59: {
                return testOnGroupBeginSimple(o, o2, o3) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 61: {
                testOnBadCountSimple(o, o2, o3);
                return Values.empty;
            }
            case 62: {
                return testOnBadEndNameSimple(o, o2, o3);
            }
            case 67: {
                testResultSet$Ex(o, o2, o3);
                return Values.empty;
            }
            default: {
                return super.apply3(method, o, o2, o3);
            }
        }
    }
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        switch (method.selector) {
            case 70: {
                return testResultKind$V(args);
            }
            case 71: {
                return isTestPassed$V(args);
            }
            case 84: {
                final Object first = args[0];
                int n = args.length - 1;
                final Object[] argsArray = new Object[n];
                while (--n >= 0) {
                    argsArray[n] = args[n + 1];
                }
                return testApply$V(first, argsArray);
            }
            case 86: {
                return $PcTestMatchAll$V(args);
            }
            case 87: {
                return $PcTestMatchAny$V(args);
            }
            default: {
                return super.applyN(method, args);
            }
        }
    }
    
    public class test-runner
    {
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
