/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.GenericProc;
import gnu.expr.KawaConvert;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.Map;
import gnu.kawa.functions.MultiplyOp;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangObjType;
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
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.math.Numeric;
import kawa.lang.Continuation;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.numbers;
import kawa.standard.Scheme;
import kawa.standard.append;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class srfi1
extends ModuleBody {
    public static final int $Pcprovide$Pcsrfi$Mn1 = 123;
    public static final int $Pcprovide$Pclist$Mnlib = 123;
    public static final ModuleMethod xcons;
    public static final ModuleMethod list$Mntabulate;
    public static final ModuleMethod cons$St;
    public static final ModuleMethod iota;
    public static final ModuleMethod circular$Mnlist;
    public static final ModuleMethod proper$Mnlist$Qu;
    public static final ModuleMethod dotted$Mnlist$Qu;
    public static final ModuleMethod circular$Mnlist$Qu;
    public static final ModuleMethod not$Mnpair$Qu;
    public static final ModuleMethod null$Mnlist$Qu;
    public static final ModuleMethod list$Eq;
    public static final ModuleMethod length$Pl;
    public static final ModuleMethod zip;
    public static GenericProc first;
    public static GenericProc second;
    public static GenericProc third;
    public static GenericProc fourth;
    public static final ModuleMethod fifth;
    public static final ModuleMethod sixth;
    public static final ModuleMethod seventh;
    public static final ModuleMethod eighth;
    public static final ModuleMethod ninth;
    public static final ModuleMethod tenth;
    public static final ModuleMethod car$Plcdr;
    public static final ModuleMethod take;
    public static final ModuleMethod drop;
    public static final ModuleMethod take$Ex;
    public static final ModuleMethod take$Mnright;
    public static final ModuleMethod drop$Mnright;
    public static final ModuleMethod drop$Mnright$Ex;
    public static final ModuleMethod split$Mnat;
    public static final ModuleMethod split$Mnat$Ex;
    public static final ModuleMethod last;
    public static final ModuleMethod last$Mnpair;
    public static final ModuleMethod unzip1;
    public static final ModuleMethod unzip2;
    public static final ModuleMethod unzip3;
    public static final ModuleMethod unzip4;
    public static final ModuleMethod unzip5;
    public static final ModuleMethod append$Ex;
    public static final ModuleMethod append$Mnreverse;
    public static final ModuleMethod append$Mnreverse$Ex;
    public static final ModuleMethod concatenate;
    public static final ModuleMethod concatenate$Ex;
    public static final ModuleMethod count;
    public static final ModuleMethod unfold$Mnright;
    public static final ModuleMethod unfold;
    public static final ModuleMethod fold;
    public static final ModuleMethod fold$Mnright;
    public static final ModuleMethod pair$Mnfold$Mnright;
    public static final ModuleMethod pair$Mnfold;
    public static final ModuleMethod reduce;
    public static final ModuleMethod reduce$Mnright;
    public static final ModuleMethod append$Mnmap;
    public static final ModuleMethod append$Mnmap$Ex;
    public static final ModuleMethod pair$Mnfor$Mneach;
    public static final ModuleMethod map$Ex;
    public static final ModuleMethod filter$Mnmap;
    public static Map map$Mnin$Mnorder;
    public static final ModuleMethod filter;
    public static final ModuleMethod filter$Ex;
    public static final ModuleMethod partition;
    public static final ModuleMethod partition$Ex;
    public static final ModuleMethod remove;
    public static final ModuleMethod remove$Ex;
    public static final ModuleMethod delete;
    public static final ModuleMethod delete$Ex;
    public static final ModuleMethod delete$Mnduplicates;
    public static final ModuleMethod delete$Mnduplicates$Ex;
    public static final ModuleMethod alist$Mncons;
    public static final ModuleMethod alist$Mncopy;
    public static final ModuleMethod alist$Mndelete;
    public static final ModuleMethod alist$Mndelete$Ex;
    public static final ModuleMethod find;
    public static final ModuleMethod find$Mntail;
    public static final ModuleMethod take$Mnwhile;
    public static final ModuleMethod drop$Mnwhile;
    public static final ModuleMethod take$Mnwhile$Ex;
    public static final ModuleMethod span;
    public static final ModuleMethod span$Ex;
    public static final ModuleMethod break;
    public static final ModuleMethod break$Ex;
    public static final ModuleMethod any;
    public static final ModuleMethod every;
    public static final Macro $Pcevery;
    public static final ModuleMethod list$Mnindex;
    public static final ModuleMethod lset$Ls$Eq;
    public static final ModuleMethod lset$Eq;
    public static final ModuleMethod lset$Mnadjoin;
    public static final ModuleMethod lset$Mnunion;
    public static final ModuleMethod lset$Mnunion$Ex;
    public static final ModuleMethod lset$Mnintersection;
    public static final ModuleMethod lset$Mnintersection$Ex;
    public static final ModuleMethod lset$Mndifference;
    public static final ModuleMethod lset$Mndifference$Ex;
    public static final ModuleMethod lset$Mnxor;
    public static final ModuleMethod lset$Mnxor$Ex;
    public static final ModuleMethod lset$Mndiff$Plintersection;
    public static final ModuleMethod lset$Mndiff$Plintersection$Ex;
    static final IntNum Lit0;
    static final IntNum Lit1;
    static final SimpleSymbol Lit2;
    public static srfi1 $instance;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
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
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit81;
    static final SimpleSymbol Lit82;
    static final SyntaxRules Lit83;
    static final SimpleSymbol Lit84;
    static final SimpleSymbol Lit85;
    static final SimpleSymbol Lit86;
    static final SimpleSymbol Lit87;
    static final SimpleSymbol Lit88;
    static final SimpleSymbol Lit89;
    static final SimpleSymbol Lit90;
    static final SimpleSymbol Lit91;
    static final SimpleSymbol Lit92;
    static final SimpleSymbol Lit93;
    static final SimpleSymbol Lit94;
    static final SimpleSymbol Lit95;
    static final SimpleSymbol Lit96;
    static final SimpleSymbol Lit97;
    static final Object[] Lit98;
    static final SimpleSymbol Lit99;
    static final SimpleSymbol Lit100;
    static final SimpleSymbol Lit101;
    static final SimpleSymbol Lit102;
    static final PairWithPosition Lit103;
    static final SimpleSymbol Lit104;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        first = lists.car;
        second = lists.cadr;
        third = lists.caddr;
        fourth = lists.cadddr;
        map$Mnin$Mnorder = Scheme.map;
    }

    public static Pair xcons(Object d, Object a) {
        return lists.cons(a, d);
    }

    public static Object listTabulate(Object len, Procedure proc) {
        Object i;
        EmptyList ans;
        boolean x;
        boolean bl = x = !numbers.isInteger(len);
        if (x ? x : NumberCompare.$Ls(len, Lit0)) {
            Type.NeverReturns neverReturns = exceptions.error("list-tabulate arg#1 must be a non-negative integer");
            throw Special.reachedUnexpected;
        }
        Object object2 = AddOp.apply2(-1, len, Lit1);
        LList lList = ans = LList.Empty;
        while (!NumberCompare.$Ls(i = object2, Lit0)) {
            object2 = AddOp.apply2(-1, i, Lit1);
            lList = lists.cons(proc.apply1(i), ans);
        }
        return ans;
    }

    public static /* varargs */ Object cons$St(Object ... args) {
        return LList.consX(args);
    }

    public static Object iota(IntNum intNum) {
        return srfi1.iota(intNum, Lit0, Lit1);
    }

    public static Object iota(IntNum intNum, Numeric numeric) {
        return srfi1.iota(intNum, numeric, Lit1);
    }

    public static Object iota(IntNum count, Numeric start, Numeric step) {
        IntNum count2;
        LList lList;
        void ans;
        IntNum intNum;
        Object object2;
        if (IntNum.compare(count, 0L) < 0) {
            Type.NeverReturns neverReturns = exceptions.error("Negative step count", iota, count);
            throw Special.reachedUnexpected;
        }
        Object object3 = Promise.force(AddOp.apply2(1, start, ((Procedure)MultiplyOp.$St).apply2(IntNum.add(count, -1), step)), Numeric.class);
        try {
            Numeric last$Mnval = LangObjType.coerceNumeric(object3);
            intNum = count;
            object2 = last$Mnval;
            lList = LList.Empty;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "last-val", -2, (Object)count2);
        }
        do {
            void val;
            EmptyList emptyList = lList;
            Numeric numeric = object2;
            count2 = intNum;
            if (IntNum.compare(count2, 0L) <= 0) break;
            intNum = IntNum.add(count2, -1);
            object2 = AddOp.apply2(-1, val, step);
            lList = lists.cons(val, ans);
        } while (true);
        return ans;
    }

    public static Pair circularList$V(Object val1, Object[] argsArray) {
        LList lList;
        LList vals = lList = LList.makeList(argsArray, 0);
        Pair ans = lists.cons(val1, vals);
        Object object2 = Promise.force(srfi1.lastPair(ans), Pair.class);
        try {
            lists.setCdr$Ex((Pair)object2, ans);
            return ans;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object lastPair(Pair lis) {
        v0 = lis;
        do lbl-1000: // 2 sources:
        {
            lis2 = v0;
            object2 = Promise.force(lis2, Pair.class);
            tail = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException v1) {
            throw new WrongType(v1, "cdr", 1, object2);
        }
        {
            if (lists.isPair(tail) == false) return lis2;
            v0 = tail;
            ** while (true)
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object isProperList(Object x) {
        Object lag2;
        Boolean bl;
        void x3;
        Object x2;
        Object object2;
        Object lag;
        Object object3 = x;
        Object object4 = lag2 = x;
        while (lists.isPair(x2 = object3)) {
            Object object5 = Promise.force(x2, Pair.class);
            Object x4 = lists.cdr((Pair)object5);
            if (lists.isPair(x4)) {
                Object object6 = Promise.force(x4, Pair.class);
                object5 = lists.cdr((Pair)object6);
                object2 = Promise.force(lag2, Pair.class);
                lag = lists.cdr((Pair)object2);
                if (x3 == lag) {
                    bl = Boolean.FALSE;
                    return bl;
                }
                object3 = x3;
                object4 = lag;
                continue;
            }
            if (lists.isNull(x4)) {
                bl = Boolean.TRUE;
                return bl;
            }
            bl = Boolean.FALSE;
            return bl;
        }
        if (lists.isNull(x2)) {
            bl = Boolean.TRUE;
            return bl;
        }
        bl = Boolean.FALSE;
        return bl;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)x3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, lag);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object isDottedList(Object x) {
        Object lag2;
        Boolean bl;
        void x3;
        Object x2;
        Object object2;
        Object lag;
        Object object3 = x;
        Object object4 = lag2 = x;
        while (lists.isPair(x2 = object3)) {
            Object object5 = Promise.force(x2, Pair.class);
            Object x4 = lists.cdr((Pair)object5);
            if (lists.isPair(x4)) {
                Object object6 = Promise.force(x4, Pair.class);
                object5 = lists.cdr((Pair)object6);
                object2 = Promise.force(lag2, Pair.class);
                lag = lists.cdr((Pair)object2);
                if (x3 == lag) {
                    bl = Boolean.FALSE;
                    return bl;
                }
                object3 = x3;
                object4 = lag;
                continue;
            }
            if (lists.isNull(x4)) {
                bl = Boolean.FALSE;
                return bl;
            }
            bl = Boolean.TRUE;
            return bl;
        }
        if (lists.isNull(x2)) {
            bl = Boolean.FALSE;
            return bl;
        }
        bl = Boolean.TRUE;
        return bl;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, (Object)x3);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, lag);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object isCircularList(Object x) {
        v0 = x;
        v1 = lag = x;
        do lbl-1000: // 2 sources:
        {
            if (!lists.isPair(x = v0)) {
                v2 = Boolean.FALSE;
                return v2;
            }
            var4_4 = Promise.force(x, Pair.class);
            x = lists.cdr((Pair)var4_4);
            break;
        } while (true);
        catch (ClassCastException v3) {
            throw new WrongType(v3, "cdr", 1, (Object)x);
        }
        {
            if (!lists.isPair(x)) {
                v2 = Boolean.FALSE;
                return v2;
            }
            var5_5 = Promise.force(x, Pair.class);
            var4_4 = lists.cdr((Pair)var5_5);
            var6_7 = Promise.force(lag, Pair.class);
            lag = lists.cdr((Pair)var6_7);
            v4 = x = x == lag;
            if (x) {
                if (x) {
                    v2 = Boolean.TRUE;
                    return v2;
                }
                v2 = Boolean.FALSE;
                return v2;
            }
            v0 = x;
            v1 = lag;
            ** while (true)
        }
        catch (ClassCastException v5) {
            throw new WrongType(v5, "cdr", 1, lag);
        }
        catch (ClassCastException v6) {
            throw new WrongType(v6, "cdr", 1, (Object)x);
        }
    }

    public static boolean isNotPair(Object x) {
        return !lists.isPair(x);
    }

    public static boolean isNullList(Object l) {
        boolean bl;
        if (l instanceof Pair) {
            bl = false;
        } else if (l == LList.Empty) {
            bl = true;
        } else {
            Type.NeverReturns neverReturns = exceptions.error("null-list?: argument out of domain", l);
            throw Special.reachedUnexpected;
        }
        return bl;
    }

    /*
     * Exception decompiling
     */
    public static Object list$Eq$V(Object $Eq, Object[] argsArray) {
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
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object length$Pl(Object x) {
        v0 = x;
        v1 = x;
        v2 = srfi1.Lit0;
        do lbl-1000: // 2 sources:
        {
            intNum = v2;
            lag2 = v1;
            x4 = v0;
            if (!lists.isPair(x4)) {
                v3 = len3;
                return v3;
            }
            object6 = Promise.force(x4, Pair.class);
            object7 = lists.cdr((Pair)object6);
            break;
        } while (true);
        catch (ClassCastException v4) {
            throw new WrongType(v4, "cdr", 1, len);
        }
        {
            len = AddOp.apply2(1, len3, srfi1.Lit1);
            if (!lists.isPair(x3)) {
                v3 = len;
                return v3;
            }
            object8 = Promise.force(x3, Pair.class);
            object9 = lists.cdr((Pair)object8);
            object10 = Promise.force(lag2, Pair.class);
            object8 = lists.cdr((Pair)object10);
            len2 = AddOp.apply2(1, len, srfi1.Lit1);
            if (x2 == lag) {
                v3 = Boolean.FALSE;
                return v3;
            }
            v0 = x2;
            v1 = lag;
            v2 = len2;
            ** while (true)
        }
        catch (ClassCastException v5) {
            throw new WrongType(v5, "cdr", 1, (Object)lag);
        }
        catch (ClassCastException v6) {
            throw new WrongType(v6, "cdr", 1, len2);
        }
    }

    public static Object zip$V(Object list1, Object[] argsArray) {
        LList lList;
        LList more$Mnlists = lList = LList.makeList(argsArray, 0);
        return ((Procedure)Scheme.apply).apply4(Scheme.map, LangObjType.listType, list1, more$Mnlists);
    }

    public static Object fifth(Object x) {
        Object object2 = Promise.force(lists.cddddr(x), Pair.class);
        try {
            return lists.car((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    public static Object sixth(Object x) {
        return lists.cadr(lists.cddddr(x));
    }

    public static Object seventh(Object x) {
        return lists.caddr(lists.cddddr(x));
    }

    public static Object eighth(Object x) {
        return lists.cadddr(lists.cddddr(x));
    }

    public static Object ninth(Object x) {
        Object object2 = Promise.force(lists.cddddr(lists.cddddr(x)), Pair.class);
        try {
            return lists.car((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    public static Object tenth(Object x) {
        return lists.cadr(lists.cddddr(lists.cddddr(x)));
    }

    /*
     * Exception decompiling
     */
    public static Values car$PlCdr(Object pair) {
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
    public static Object take(Object lis, IntNum k) {
        Object object2;
        void res;
        IntNum k2;
        Object lis2;
        Object object3 = lis;
        IntNum intNum = k;
        LList lList = LList.Empty;
        do {
            EmptyList emptyList = lList;
            k2 = intNum;
            lis2 = object3;
            if (numbers.isZero(k2)) {
                object2 = Promise.force(res, LList.class);
                return lists.reverse$Ex((LList)object2);
            }
            object2 = Promise.force(lis2, Pair.class);
            object3 = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        {
            intNum = IntNum.add(k2, -1);
            object2 = Promise.force(lis2, Pair.class);
            lList = lists.cons(lists.car((Pair)object2), res);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object drop(Object lis, IntNum k) {
        v0 = lis;
        v1 = k;
        do lbl-1000: // 2 sources:
        {
            k2 = v1;
            lis2 = v0;
            if (numbers.isZero(k2)) {
                return lis2;
            }
            object2 = Promise.force(lis2, Pair.class);
            v0 = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "cdr", 1, object2);
        }
        {
            v1 = IntNum.add(k2, -1);
            ** while (true)
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object take$Ex(Object lis, IntNum k) {
        Object object2;
        if (numbers.isZero(k)) {
            object2 = LList.Empty;
            return object2;
        }
        Object object22 = Promise.force(srfi1.drop(lis, IntNum.add(k, -1)), Pair.class);
        try {
            lists.setCdr$Ex((Pair)object22, LList.Empty);
            object2 = lis;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object22);
        }
        return object2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object takeRight(Object lis, IntNum k) {
        Object object2;
        Object lead;
        Object object3 = lis;
        Object object4 = srfi1.drop(lis, k);
        do {
            lead = object4;
            Object lag = object3;
            if (!lists.isPair(lead)) return lag;
            object2 = Promise.force(lag, Pair.class);
            object3 = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        {
            object2 = Promise.force(lead, Pair.class);
            object4 = lists.cdr((Pair)object2);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    public static Object dropRight(Object lis, IntNum k) {
        return srfi1.lambda1recur(lis, srfi1.drop(lis, k));
    }

    /*
     * Exception decompiling
     */
    public static Object lambda1recur(Object lag, Object lead) {
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object dropRight$Ex(Object lis, IntNum k) {
        Object lag;
        Object object2;
        Object object3;
        Object object32;
        Object lead = srfi1.drop(lis, k);
        if (!lists.isPair(lead)) {
            object2 = LList.Empty;
            return object2;
        }
        Object object4 = lis;
        Object object5 = Promise.force(lead, Pair.class);
        try {
            object3 = lists.cdr((Pair)object5);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, lag);
        }
        do {
            void lead2;
            Object object7 = object3;
            lag = object4;
            if (!lists.isPair(lead2)) break;
            object32 = Promise.force(lag, Pair.class);
            object4 = lists.cdr((Pair)object32);
            object32 = Promise.force(lead2, Pair.class);
            object3 = lists.cdr((Pair)object32);
            continue;
            break;
        } while (true);
        object32 = Promise.force(lag, Pair.class);
        try {
            lists.setCdr$Ex((Pair)object32, LList.Empty);
            object2 = lis;
            return object2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object32);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object32);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object32);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object splitAt(Object x, IntNum k) {
        v0 /* !! */  = LList.Empty;
        v1 = x;
        v2 = k;
        do lbl-1000: // 2 sources:
        {
            intNum2 = v2;
            suffix = v1;
            prefix = v0 /* !! */ ;
            if (numbers.isZero((Number)k2)) {
                object2 = Promise.force(prefix, LList.class);
                return Values.values2(lists.reverse$Ex((LList)object2), suffix);
            }
            object2 = Promise.force(suffix, Pair.class);
            v0 /* !! */  = lists.cons(lists.car((Pair)object2), prefix);
            break;
        } while (true);
        catch (ClassCastException v3) {
            throw new WrongType(v3, "car", 1, object2);
        }
        {
            object2 = Promise.force(suffix, Pair.class);
            v1 = lists.cdr((Pair)object2);
            v2 = IntNum.add((IntNum)k2, -1);
            ** while (true)
        }
        catch (ClassCastException v4) {
            throw new WrongType(v4, "cdr", 1, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object splitAt$Ex(Object x, IntNum k) {
        Values.Values2 values2;
        Object suffix;
        if (numbers.isZero(k)) {
            values2 = Values.values2(LList.Empty, x);
            return values2;
        }
        Object prev = srfi1.drop(x, IntNum.add(k, -1));
        Object object2 = Promise.force(prev, Pair.class);
        try {
            suffix = lists.cdr((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        object2 = Promise.force(prev, Pair.class);
        try {
            lists.setCdr$Ex((Pair)object2, LList.Empty);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
        values2 = Values.values2(x, suffix);
        return values2;
    }

    public static Object last(Object lis) {
        Object object2 = Promise.force(lis, Pair.class);
        try {
            object2 = Promise.force(srfi1.lastPair((Pair)object2), Pair.class);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "last-pair", 0, object2);
        }
        try {
            return lists.car((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    /*
     * Exception decompiling
     */
    public static LList unzip1(Object lis) {
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

    public static Object unzip2(Object lis) {
        return srfi1.lambda2recur(lis);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object lambda2recur(Object lis) {
        int n;
        Values.Values2 values2;
        Object elt;
        if (srfi1.isNullList(lis)) {
            values2 = Values.values2(lis, lis);
            return values2;
        }
        Object object2 = Promise.force(lis, Pair.class);
        try {
            elt = lists.car((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        Object object4 = Promise.force(lis, Pair.class);
        try {
            object2 = srfi1.lambda2recur(lists.cdr((Pair)object4));
            n = 0;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object4);
        }
        n = Values.incrPos(object2, n);
        Object object5 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object b = Values.getFromPosFinal(object2, n);
        Object object3 = Promise.force(elt, Pair.class);
        try {
            void a;
            values2 = Values.values2(lists.cons(lists.car((Pair)object3), a), lists.cons(lists.cadr(elt), b));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object3);
        }
        return values2;
    }

    public static Object unzip3(Object lis) {
        return srfi1.lambda3recur(lis);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object lambda3recur(Object lis) {
        Values<Object> values;
        void b;
        int n;
        Object elt;
        if (srfi1.isNullList(lis)) {
            values = Values.makeFromArray(lis, lis, lis);
            return values;
        }
        Object object4 = Promise.force(lis, Pair.class);
        try {
            elt = lists.car((Pair)object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object4);
        }
        Object object3 = Promise.force(lis, Pair.class);
        try {
            object4 = srfi1.lambda3recur(lists.cdr((Pair)object3));
            n = 0;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        n = Values.incrPos(object4, n);
        Object object5 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object object6 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object c = Values.getFromPosFinal(object4, n);
        Object[] arrobject = new Object[3];
        Object object2 = Promise.force(elt, Pair.class);
        try {
            void a;
            arrobject[0] = lists.cons(lists.car((Pair)object2), a);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        arrobject[1] = lists.cons(lists.cadr(elt), b);
        arrobject[2] = lists.cons(lists.caddr(elt), c);
        values = Values.makeFromArray(arrobject);
        return values;
    }

    public static Object unzip4(Object lis) {
        return srfi1.lambda4recur(lis);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object lambda4recur(Object lis) {
        void c;
        Values<Object> values;
        void b;
        int n;
        Object elt;
        if (srfi1.isNullList(lis)) {
            values = Values.makeFromArray(lis, lis, lis, lis);
            return values;
        }
        Object object4 = Promise.force(lis, Pair.class);
        try {
            elt = lists.car((Pair)object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object4);
        }
        Object object3 = Promise.force(lis, Pair.class);
        try {
            object4 = srfi1.lambda4recur(lists.cdr((Pair)object3));
            n = 0;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
        n = Values.incrPos(object4, n);
        Object object5 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object object6 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object object7 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object d = Values.getFromPosFinal(object4, n);
        Object[] arrobject = new Object[4];
        Object object2 = Promise.force(elt, Pair.class);
        try {
            void a;
            arrobject[0] = lists.cons(lists.car((Pair)object2), a);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        arrobject[1] = lists.cons(lists.cadr(elt), b);
        arrobject[2] = lists.cons(lists.caddr(elt), c);
        arrobject[3] = lists.cons(lists.cadddr(elt), d);
        values = Values.makeFromArray(arrobject);
        return values;
    }

    public static Object unzip5(Object lis) {
        return srfi1.lambda5recur(lis);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object lambda5recur(Object lis) {
        void c;
        Values<Object> values;
        void b;
        void d;
        int n;
        Object elt;
        if (srfi1.isNullList(lis)) {
            values = Values.makeFromArray(lis, lis, lis, lis, lis);
            return values;
        }
        Object object4 = Promise.force(lis, Pair.class);
        try {
            elt = lists.car((Pair)object4);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object4);
        }
        Object object2 = Promise.force(lis, Pair.class);
        try {
            object4 = srfi1.lambda5recur(lists.cdr((Pair)object2));
            n = 0;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        n = Values.incrPos(object4, n);
        Object object5 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object object6 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object object7 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object object8 = Values.getFromPos(object4, n);
        n = Values.incrPos(object4, n);
        Object e = Values.getFromPosFinal(object4, n);
        Object[] arrobject = new Object[5];
        Object object3 = Promise.force(elt, Pair.class);
        try {
            void a;
            arrobject[0] = lists.cons(lists.car((Pair)object3), a);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object3);
        }
        arrobject[1] = lists.cons(lists.cadr(elt), b);
        arrobject[2] = lists.cons(lists.caddr(elt), c);
        arrobject[3] = lists.cons(lists.cadddr(elt), d);
        object3 = Promise.force(lists.cddddr(elt), Pair.class);
        try {
            arrobject[4] = lists.cons(lists.car((Pair)object3), e);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object3);
        }
        values = Values.makeFromArray(arrobject);
        return values;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object append$Ex$V(Object[] argsArray) {
        lists2 = lList = LList.makeList(argsArray, 0);
        v0 = lists2;
        v1 = prev = LList.Empty;
        do {
            if (!lists.isPair(lists3 = v0)) {
                v2 = prev;
                return v2;
            }
            object7 = Promise.force(lists3, Pair.class);
            object8 = lists.car((Pair)object7);
            object32 = Promise.force(lists3, Pair.class);
            rest = lists.cdr((Pair)object32);
            if (lists.isPair(first)) break;
            v0 = rest;
            v1 = first;
        } while (true);
        object32 = Promise.force(first, Pair.class);
        try {
            v3 = srfi1.lastPair((Pair)object32);
            v4 = rest;
        }
        catch (ClassCastException v5) {
            throw new WrongType(v5, "last-pair", 0, tail$Mncons);
        }
        catch (ClassCastException v6) {
            throw new WrongType(v6, "car", 1, rest);
        }
        catch (ClassCastException v7) {
            throw new WrongType(v7, "cdr", 1, tail$Mncons);
        }
        do lbl-1000: // 2 sources:
        {
            object9 = v4;
            tail$Mncons = v3;
            if (!lists.isPair(rest3)) {
                v2 = first;
                return v2;
            }
            object10 = Promise.force(rest3, Pair.class);
            object11 = lists.car((Pair)object10);
            break;
        } while (true);
        catch (ClassCastException v8) {
            throw new WrongType(v8, "car", 1, rest2);
        }
        {
            object2 = Promise.force(rest3, Pair.class);
            rest2 = lists.cdr((Pair)object2);
            object2 = Promise.force(tail$Mncons, Pair.class);
            lists.setCdr$Ex((Pair)object2, next);
            if (lists.isPair(next)) {
                object2 = Promise.force(next, Pair.class);
                v3 = srfi1.lastPair((Pair)object2);
            } else {
                v3 = tail$Mncons;
            }
            v4 = rest2;
            ** while (true)
        }
        catch (ClassCastException v9) {
            throw new WrongType(v9, "cdr", 1, object2);
        }
        catch (ClassCastException v10) {
            throw new WrongType(v10, "set-cdr!", 1, object2);
        }
        catch (ClassCastException v11) {
            throw new WrongType(v11, "last-pair", 0, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object appendReverse(Object rev$Mnhead, Object tail) {
        Object object2;
        Object rev$Mnhead2;
        Object tail2;
        Object object3 = rev$Mnhead;
        Object object4 = tail2 = tail;
        do {
            if (srfi1.isNullList(rev$Mnhead2 = object3)) {
                return tail2;
            }
            object2 = Promise.force(rev$Mnhead2, Pair.class);
            object3 = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        {
            object2 = Promise.force(rev$Mnhead2, Pair.class);
            object4 = lists.cons(lists.car((Pair)object2), tail2);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object appendReverse$Ex(Object rev$Mnhead, Object tail) {
        Object object2;
        Object next$Mnrev;
        Object rev$Mnhead2;
        Object tail2;
        Object object3 = rev$Mnhead;
        Object object4 = tail2 = tail;
        do {
            if (srfi1.isNullList(rev$Mnhead2 = object3)) {
                return tail2;
            }
            object2 = Promise.force(rev$Mnhead2, Pair.class);
            next$Mnrev = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        {
            object2 = Promise.force(rev$Mnhead2, Pair.class);
            lists.setCdr$Ex((Pair)object2, tail2);
            object3 = next$Mnrev;
            object4 = rev$Mnhead2;
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
    }

    public static Object concatenate(Object lists2) {
        return srfi1.reduceRight(append.append, LList.Empty, lists2);
    }

    /*
     * Exception decompiling
     */
    public static Object reduceRight(Procedure f, Object ridentity, Object lis) {
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

    public static Object concatenate$Ex(Object lists2) {
        return srfi1.reduceRight(append$Ex, LList.Empty, lists2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object count$V(Procedure pred, Object list1, Object[] argsArray) {
        lList = LList.makeList(argsArray, 0);
        lists3 = lList;
        if (lists.isPair(lists3)) {
            v0 = list1;
            v1 = lists3;
            v2 = srfi1.Lit0;
            do lbl-1000: // 3 sources:
            {
                intNum = v2;
                lList2 = v1;
                list12 = v0;
                if (srfi1.isNullList(list12)) {
                    v3 = i2222;
                    return v3;
                }
                split = srfi1.$PcCars$PlCdrs$SlPair(lists22222);
                a$Mns = lists.car(split);
                d$Mns = lists.cdr(split);
                if (lists.isNull(a$Mns)) {
                    v3 = i2222;
                    return v3;
                }
                object2 = Promise.force(list12, Pair.class);
                v0 = lists.cdr((Pair)object2);
                v1 = d$Mns;
                break;
            } while (true);
            catch (ClassCastException v4) {
                throw new WrongType(v4, "cdr", 1, object2);
            }
            {
                block14 : {
                    object2 = Promise.force(list12, Pair.class);
                    if (!KawaConvert.isTrue(Scheme.apply.apply3(pred, lists.car((Pair)object2), a$Mns))) break block14;
                    v2 = AddOp.apply2(1, i2222, srfi1.Lit1);
                    continue;
                }
                v2 = i2222;
                ** while (true)
            }
            catch (ClassCastException v5) {
                throw new WrongType(v5, "car", 1, object2);
            }
        }
        v6 = list1;
        v7 = srfi1.Lit0;
        do lbl-1000: // 3 sources:
        {
            lists22222 = v7;
            lis = v6;
            if (srfi1.isNullList(lis)) {
                v3 = i3;
                return v3;
            }
            i2222 = Promise.force(lis, Pair.class);
            v6 = lists.cdr((Pair)i2222);
            break;
        } while (true);
        catch (ClassCastException v8) {
            throw new WrongType(v8, "cdr", 1, i2222);
        }
        {
            block15 : {
                i2222 = Promise.force(lis, Pair.class);
                if (!KawaConvert.isTrue(pred.apply1(lists.car((Pair)i2222)))) break block15;
                v7 = AddOp.apply2(1, i3, srfi1.Lit1);
                continue;
            }
            v7 = i3;
            ** while (true)
        }
        catch (ClassCastException v9) {
            throw new WrongType(v9, "car", 1, i2222);
        }
    }

    static Pair $PcCars$PlCdrs$SlPair(Object lists2) {
        void cars;
        Object object2 = srfi1.$PcCars$PlCdrs(lists2);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object cdrs = Values.getFromPosFinal(object2, n);
        return lists.cons(cars, cdrs);
    }

    public static Object unfoldRight(Procedure procedure, Procedure procedure2, Procedure procedure3, Object object2) {
        return srfi1.unfoldRight(procedure, procedure2, procedure3, object2, LList.Empty);
    }

    public static Object unfoldRight(Procedure p, Procedure f, Procedure g, Object seed, Object maybe$Mntail) {
        void ans;
        Object seed2;
        Object object2;
        Object object3 = seed;
        Object object4 = object2 = maybe$Mntail;
        while (!KawaConvert.isTrue(p.apply1(seed2 = object3))) {
            object3 = g.apply1(seed2);
            object4 = lists.cons(f.apply1(seed2), ans);
        }
        return ans;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object unfold$V(Procedure p, Procedure f, Procedure g, Object seed, Object[] argsArray) {
        lList = LList.makeList(argsArray, 0);
        maybe$Mntail$Mngen = lList;
        if (lists.isPair(maybe$Mntail$Mngen)) {
            lList2 = maybe$Mntail$Mngen;
            try {
                tail$Mngen = lists.car((Pair)lList2);
                lList2 = maybe$Mntail$Mngen;
            }
            catch (ClassCastException v0) {
                throw new WrongType(v0, "car", 1, (Object)res22222);
            }
            try {
                ** if (!lists.isPair((Object)lists.cdr((Pair)((Pair)lList2)))) goto lbl-1000
            }
            catch (ClassCastException v2) {
                throw new WrongType(v2, "cdr", 1, (Object)res22222);
            }
lbl-1000: // 1 sources:
            {
                v1 = Scheme.apply.applyN(new Object[]{exceptions.error, "Too many arguments", srfi1.unfold, p, f, g, seed, maybe$Mntail$Mngen});
                return v1;
            }
lbl-1000: // 1 sources:
            {
            }
            v3 = seed;
            v4 /* !! */  = LList.Empty;
            do {
                emptyList = v4 /* !! */ ;
                seed22222 = v3;
                if (KawaConvert.isTrue(p.apply1(seed22222))) {
                    v1 = srfi1.appendReverse$Ex(res3222, Scheme.applyToArgs.apply2(tail$Mngen, seed22222));
                    return v1;
                }
                v3 = g.apply1(seed22222);
                v4 /* !! */  = lists.cons(f.apply1(seed22222), res3222);
            } while (true);
        }
        v5 = seed;
        v6 /* !! */  = LList.Empty;
        do {
            seed22222 = v6 /* !! */ ;
            seed3 = v5;
            if (KawaConvert.isTrue(p.apply1(seed3))) {
                res3222 = Promise.force(res22222, LList.class);
                v1 = lists.reverse$Ex((LList)res3222);
                return v1;
            }
            v5 = g.apply1(seed3);
            v6 /* !! */  = lists.cons(f.apply1(seed3), res22222);
        } while (true);
        catch (ClassCastException v7) {
            throw new WrongType(v7, "reverse!", 1, res3222);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object fold$V(Procedure kons, Object knil, Object lis1, Object[] argsArray) {
        Object lis;
        void v2;
        Object object2;
        void ans;
        LList lList = LList.makeList(argsArray, 0);
        LList lists2 = lList;
        if (lists.isPair(lists2)) {
            Object object3 = lists.cons(lis1, lists2);
            Object object4 = knil;
            do {
                void ans2222;
                void cars$Plans;
                Object object6 = object4;
                Pair lists3 = object3;
                Object object7 = srfi1.$PcCars$PlCdrs$Pl(lists3, ans2222);
                int n = 0;
                n = Values.incrPos(object7, n);
                Object object8 = Values.getFromPos(object7, n);
                n = Values.incrPos(object7, n);
                Object cdrs = Values.getFromPosFinal(object7, n);
                if (lists.isNull(cars$Plans)) {
                    v2 = ans2222;
                    return v2;
                }
                object3 = cdrs;
                object4 = ((Procedure)Scheme.apply).apply2(kons, cars$Plans);
            } while (true);
        }
        Object object5 = lis1;
        Object object6 = knil;
        do {
            Object ans2222 = object6;
            lis = object5;
            if (srfi1.isNullList(lis)) {
                v2 = ans;
                return v2;
            }
            object2 = Promise.force(lis, Pair.class);
            object5 = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        {
            object2 = Promise.force(lis, Pair.class);
            object6 = kons.apply2(lists.car((Pair)object2), ans);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    static Object $PcCars$PlCdrs$Pl(Object lists2, Object carsFinal) {
        Object object2;
        public class Frame38
        extends ModuleBody {
            Object cars$Mnfinal;
        }
        Frame38 $heapFrame = new Frame38();
        $heapFrame.cars$Mnfinal = carsFinal;
        CallContext $ctx = CallContext.getInstance();
        Continuation continuation = new Continuation($ctx);
        try {
            Continuation abort = continuation;
            new Frame39().staticLink = $heapFrame;
            public class Frame39
            extends ModuleBody {
                Continuation abort;
                Frame38 staticLink;

                public Object lambda49recur(Object lists2) {
                    Values.Values2 values2;
                    if (lists.isPair(lists2)) {
                        void list;
                        Values values = srfi1.car$PlCdr(lists2);
                        int n = 0;
                        n = Values.incrPos(values, n);
                        Object object2 = Values.getFromPos(values, n);
                        n = Values.incrPos(values, n);
                        Object other$Mnlists = Values.getFromPosFinal(values, n);
                        if (srfi1.isNullList(list)) {
                            values2 = ((Procedure)this.abort).apply2(LList.Empty, LList.Empty);
                        } else {
                            void cars;
                            void a;
                            Values values3 = srfi1.car$PlCdr(list);
                            int n2 = 0;
                            n2 = Values.incrPos(values3, n2);
                            Object object3 = Values.getFromPos(values3, n2);
                            n2 = Values.incrPos(values3, n2);
                            Object d = Values.getFromPosFinal(values3, n2);
                            Object object4 = this.lambda49recur(other$Mnlists);
                            int n3 = 0;
                            n3 = Values.incrPos(object4, n3);
                            Object object5 = Values.getFromPos(object4, n3);
                            n3 = Values.incrPos(object4, n3);
                            Object cdrs = Values.getFromPosFinal(object4, n3);
                            values2 = Values.values2(lists.cons(a, cars), lists.cons(d, cdrs));
                        }
                    } else {
                        values2 = Values.values2(LList.list1(this.staticLink.cars$Mnfinal), LList.Empty);
                    }
                    return values2;
                }
            }
            Frame39 $heapFrame2 = new Frame39();
            $heapFrame2.abort = abort;
            continuation.invoked = true;
            object2 = $heapFrame2.lambda49recur(lists2);
        }
        catch (Throwable throwable) {
            object2 = Continuation.handleException(throwable, continuation);
        }
        return object2;
    }

    public static Object foldRight$V(Procedure kons, Object knil, Object lis1, Object[] argsArray) {
        public class Frame
        extends ModuleBody {
            Procedure kons;
            Object knil;

            public Object lambda6recur(Object lists2) {
                Object cdrs = srfi1.$PcCdrs(lists2);
                return lists.isNull(cdrs) ? this.knil : ((Procedure)Scheme.apply).apply2(this.kons, srfi1.$PcCars$Pl(lists2, this.lambda6recur(cdrs)));
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda7recur(Object lis) {
                Object head;
                Object object2;
                if (srfi1.isNullList(lis)) {
                    object2 = this.knil;
                    return object2;
                }
                Object object22 = Promise.force(lis, Pair.class);
                try {
                    head = lists.car((Pair)object22);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object22);
                }
                object22 = Promise.force(lis, Pair.class);
                try {
                    object2 = this.kons.apply2(head, this.lambda7recur(lists.cdr((Pair)object22)));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object22);
                }
                return object2;
            }
        }
        Frame $heapFrame = new Frame();
        $heapFrame.kons = kons;
        $heapFrame.knil = knil;
        LList lList = LList.makeList(argsArray, 0);
        LList lists2 = lList;
        return lists.isPair(lists2) ? $heapFrame.lambda6recur(lists.cons(lis1, lists2)) : $heapFrame.lambda7recur(lis1);
    }

    static Object $PcCdrs(Object lists2) {
        Object object2;
        CallContext $ctx = CallContext.getInstance();
        Continuation continuation = new Continuation($ctx);
        try {
            Continuation abort = continuation;
            public class Frame35
            extends ModuleBody {
                Continuation abort;

                /*
                 * Exception decompiling
                 */
                public Object lambda46recur(Object lists) {
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
                    // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:773)
                    // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:870)
                    // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
                    // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
                    // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
                    // org.benf.cfr.reader.Main.main(Main.java:48)
                    throw new IllegalStateException("Decompilation failed");
                }
            }
            Frame35 $heapFrame = new Frame35();
            $heapFrame.abort = abort;
            continuation.invoked = true;
            object2 = $heapFrame.lambda46recur(lists2);
        }
        catch (Throwable throwable) {
            object2 = Continuation.handleException(throwable, continuation);
        }
        return object2;
    }

    static Object $PcCars$Pl(Object lists2, Object lastElt) {
        public class Frame36
        extends ModuleBody {
            Object last$Mnelt;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda47recur(Object lists2) {
                Pair pair;
                if (!lists.isPair(lists2)) {
                    pair = LList.list1(this.last$Mnelt);
                    return pair;
                }
                Object object2 = Promise.force(lists2, Pair.class);
                try {
                    pair = lists.cons(lists.caar(lists2), this.lambda47recur(lists.cdr((Pair)object2)));
                    return pair;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object2);
                }
            }
        }
        Frame36 $heapFrame = new Frame36();
        $heapFrame.last$Mnelt = lastElt;
        return $heapFrame.lambda47recur(lists2);
    }

    public static Object pairFoldRight$V(Procedure f, Object zero, Object lis1, Object[] argsArray) {
        public class Frame0
        extends ModuleBody {
            Procedure f;
            Object zero;

            public Object lambda8recur(Object lists2) {
                Object cdrs = srfi1.$PcCdrs(lists2);
                return lists.isNull(cdrs) ? this.zero : ((Procedure)Scheme.apply).apply2(this.f, srfi1.append$Ex$V(new Object[]{lists2, LList.list1(this.lambda8recur(cdrs))}));
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda9recur(Object lis) {
                Object object2;
                if (srfi1.isNullList(lis)) {
                    object2 = this.zero;
                    return object2;
                }
                Object object22 = Promise.force(lis, Pair.class);
                try {
                    object2 = this.f.apply2(lis, this.lambda9recur(lists.cdr((Pair)object22)));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object22);
                }
                return object2;
            }
        }
        Frame0 $heapFrame = new Frame0();
        $heapFrame.f = f;
        $heapFrame.zero = zero;
        LList lList = LList.makeList(argsArray, 0);
        LList lists2 = lList;
        return lists.isPair(lists2) ? $heapFrame.lambda8recur(lists.cons(lis1, lists2)) : $heapFrame.lambda9recur(lis1);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object pairFold$V(Procedure f, Object zero, Object lis1, Object[] argsArray) {
        lList = LList.makeList(argsArray, 0);
        lists2 = lList;
        if (lists.isPair(lists2)) {
            v0 = lists.cons(lis1, lists2);
            v1 = zero;
            do {
                object4 = v1;
                lists3 = v0;
                tails = srfi1.$PcCdrs(lists3);
                if (lists.isNull(tails)) {
                    v2 = ans222;
                    return v2;
                }
                v0 = tails;
                v1 = Scheme.apply.apply2(f, srfi1.append$Ex$V(new Object[]{lists3, LList.list1(ans222)}));
            } while (true);
        }
        v3 = lis1;
        v4 = zero;
        do lbl-1000: // 2 sources:
        {
            ans222 = v4;
            lis = v3;
            if (srfi1.isNullList(lis)) {
                v2 = ans;
                return v2;
            }
            object2 = Promise.force(lis, Pair.class);
            v3 = tail = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException v5) {
            throw new WrongType(v5, "cdr", 1, object2);
        }
        {
            v4 = f.apply2(lis, ans);
            ** while (true)
        }
    }

    /*
     * Exception decompiling
     */
    public static Object reduce(Procedure f, Object ridentity, Object lis) {
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

    public static Object appendMap$V(Object f, Object lis1, Object[] argsArray) {
        Object object2;
        Object object3 = LList.makeList(argsArray, 0);
        Object lists2 = object3;
        if (lists.isPair(lists2)) {
            object2 = ((Procedure)Scheme.apply).apply2(append.append, ((Procedure)Scheme.apply).apply4(Scheme.map, f, lis1, lists2));
        } else {
            object3 = Sequences.getIterator(lis1);
            LList lList = LList.Empty;
            Pair pair = null;
            while (object3.hasNext()) {
                Pair pair2;
                Object e = object3.next();
                if (pair == null) {
                    pair2 = new Pair(((Procedure)Scheme.applyToArgs).apply2(f, e), LList.Empty);
                } else {
                    pair2 = lList;
                    pair.setCdr(lList);
                }
                pair = pair2;
            }
            object2 = ((Procedure)Scheme.apply).apply2(append.append, lList);
        }
        return object2;
    }

    public static Object appendMap$Ex$V(Object f, Object lis1, Object[] argsArray) {
        Object object2;
        Object object3 = LList.makeList(argsArray, 0);
        Object lists2 = object3;
        if (lists.isPair(lists2)) {
            object2 = ((Procedure)Scheme.apply).apply2(append$Ex, ((Procedure)Scheme.apply).apply4(Scheme.map, f, lis1, lists2));
        } else {
            object3 = Sequences.getIterator(lis1);
            LList lList = LList.Empty;
            Pair pair = null;
            while (object3.hasNext()) {
                Pair pair2;
                Object e = object3.next();
                if (pair == null) {
                    pair2 = new Pair(((Procedure)Scheme.applyToArgs).apply2(f, e), LList.Empty);
                } else {
                    pair2 = lList;
                    pair.setCdr(lList);
                }
                pair = pair2;
            }
            object2 = ((Procedure)Scheme.apply).apply2(append$Ex, lList);
        }
        return object2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object pairForEach$V(Procedure proc, Object lis1, Object[] argsArray) {
        lList = LList.makeList(argsArray, 0);
        lists2 = lList;
        if (lists.isPair(lists2)) {
            v0 = lists.cons(lis1, lists2);
            do {
                if (!lists.isPair(tails = srfi1.$PcCdrs(lists3 = v0))) {
                    v1 = Values.empty;
                    return v1;
                }
                Scheme.apply.apply2(proc, lists3);
                v0 = tails;
            } while (true);
        }
        v2 = lis1;
        do lbl-1000: // 2 sources:
        {
            if (srfi1.isNullList(lis = v2)) {
                v1 = Values.empty;
                return v1;
            }
            object2 = Promise.force(lis, Pair.class);
            tail = lists.cdr((Pair)object2);
            break;
        } while (true);
        catch (ClassCastException v3) {
            throw new WrongType(v3, "cdr", 1, object2);
        }
        {
            proc.apply1(lis);
            v2 = tail;
            ** while (true)
        }
    }

    /*
     * Exception decompiling
     */
    public static Object map$Ex$V(Procedure f, Object lis1, Object[] argsArray) {
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

    static Pair $PcCars$PlCdrs$SlNoTest$SlPair(Object lists2) {
        void cars;
        Object object2 = srfi1.$PcCars$PlCdrs$SlNoTest(lists2);
        int n = 0;
        n = Values.incrPos(object2, n);
        Object object3 = Values.getFromPos(object2, n);
        n = Values.incrPos(object2, n);
        Object cdrs = Values.getFromPosFinal(object2, n);
        return lists.cons(cars, cdrs);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object filterMap$V(Procedure f, Object lis1, Object[] argsArray) {
        Object tail;
        Object cars22222222;
        void head2;
        LList lList;
        LList lList2 = LList.makeList(argsArray, 0);
        LList lists2 = lList2;
        if (lists.isPair(lists2)) {
            Object head;
            Object object2 = lists.cons(lis1, lists2);
            LList lList3 = LList.Empty;
            block8 : do {
                EmptyList emptyList = lList3;
                Object lists3 = object2;
                do {
                    void cars22222222;
                    void res;
                    Object object3 = srfi1.$PcCars$PlCdrs(lists3);
                    int n = 0;
                    n = Values.incrPos(object3, n);
                    Object object4 = Values.getFromPos(object3, n);
                    n = Values.incrPos(object3, n);
                    Object cdrs = Values.getFromPosFinal(object3, n);
                    if (srfi1.isNotPair(cars22222222)) {
                        Object object5 = Promise.force(res, LList.class);
                        lList = lists.reverse$Ex((LList)object5);
                        return lList;
                    }
                    head = ((Procedure)Scheme.apply).apply2(f, cars22222222);
                    if (KawaConvert.isTrue(head)) {
                        object2 = cdrs;
                        lList3 = lists.cons(head, res);
                        continue block8;
                    }
                    lists3 = cdrs;
                } while (true);
                break;
            } while (true);
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "reverse!", 1, head);
            }
        }
        Object object3 = lis1;
        LList lList4 = LList.Empty;
        block10 : do {
            EmptyList res = lList4;
            Object lis = object3;
            do {
                Object object7;
                if (srfi1.isNullList(lis)) {
                    object7 = Promise.force(res, LList.class);
                    lList = lists.reverse$Ex((LList)object7);
                    return lList;
                }
                Object object8 = Promise.force(lis, Pair.class);
                object7 = f.apply1(lists.car((Pair)object8));
                cars22222222 = Promise.force(lis, Pair.class);
                tail = lists.cdr((Pair)cars22222222);
                if (KawaConvert.isTrue(head2)) {
                    object3 = tail;
                    lList4 = lists.cons(head2, res);
                    continue block10;
                }
                lis = tail;
            } while (true);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse!", 1, (Object)head2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, tail);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, cars22222222);
        }
    }

    static Object $PcCars$PlCdrs(Object lists2) {
        Object object2;
        CallContext $ctx = CallContext.getInstance();
        Continuation continuation = new Continuation($ctx);
        try {
            Continuation abort = continuation;
            public class Frame37
            extends ModuleBody {
                Continuation abort;

                public Object lambda48recur(Object lists2) {
                    Values.Values2 values2;
                    if (lists.isPair(lists2)) {
                        void list;
                        Values values = srfi1.car$PlCdr(lists2);
                        int n = 0;
                        n = Values.incrPos(values, n);
                        Object object2 = Values.getFromPos(values, n);
                        n = Values.incrPos(values, n);
                        Object other$Mnlists = Values.getFromPosFinal(values, n);
                        if (srfi1.isNullList(list)) {
                            values2 = ((Procedure)this.abort).apply2(LList.Empty, LList.Empty);
                        } else {
                            void cars;
                            void a;
                            Values values3 = srfi1.car$PlCdr(list);
                            int n2 = 0;
                            n2 = Values.incrPos(values3, n2);
                            Object object3 = Values.getFromPos(values3, n2);
                            n2 = Values.incrPos(values3, n2);
                            Object d = Values.getFromPosFinal(values3, n2);
                            Object object4 = this.lambda48recur(other$Mnlists);
                            int n3 = 0;
                            n3 = Values.incrPos(object4, n3);
                            Object object5 = Values.getFromPos(object4, n3);
                            n3 = Values.incrPos(object4, n3);
                            Object cdrs = Values.getFromPosFinal(object4, n3);
                            values2 = Values.values2(lists.cons(a, cars), lists.cons(d, cdrs));
                        }
                    } else {
                        values2 = Values.values2(LList.Empty, LList.Empty);
                    }
                    return values2;
                }
            }
            Frame37 $heapFrame = new Frame37();
            $heapFrame.abort = abort;
            continuation.invoked = true;
            object2 = $heapFrame.lambda48recur(lists2);
        }
        catch (Throwable throwable) {
            object2 = Continuation.handleException(throwable, continuation);
        }
        return object2;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public static Object filter(Procedure pred, Object lis) {
        Object object2;
        Object object3;
        Object tail;
        Object object4 = lis;
        LList lList = LList.Empty;
        block6 : do {
            EmptyList res = lList;
            Object lis2 = object4;
            do {
                void head;
                if (srfi1.isNullList(lis2)) {
                    object2 = Promise.force(res, LList.class);
                    break block6;
                }
                Object object5 = Promise.force(lis2, Pair.class);
                object2 = lists.car((Pair)object5);
                object3 = Promise.force(lis2, Pair.class);
                tail = lists.cdr((Pair)object3);
                if (KawaConvert.isTrue(pred.apply1(head))) {
                    object4 = tail;
                    lList = lists.cons(head, res);
                    continue block6;
                }
                lis2 = tail;
            } while (true);
            break;
        } while (true);
        return lists.reverse$Ex((LList)object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, tail);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object3);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object filter$Ex(Procedure pred, Object lis) {
        Object object2;
        Object ans;
        Object object3;
        block26 : {
            Object prev;
            void lis2;
            Object object4;
            Object object5;
            Object prev2;
            Object object6 = lis;
            do {
                if (srfi1.isNullList(ans = object6)) {
                    object3 = ans;
                    return object3;
                }
                object4 = Promise.force(ans, Pair.class);
                if (KawaConvert.isTrue(pred.apply1(lists.car((Pair)object4)))) break;
                object4 = Promise.force(ans, Pair.class);
                object6 = lists.cdr((Pair)object4);
                continue;
                break;
            } while (true);
            Object object7 = ans;
            object4 = Promise.force(ans, Pair.class);
            try {
                object5 = lists.cdr((Pair)object4);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, prev);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, prev);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, prev);
            }
            block23 : do {
                Object object8;
                Object object9;
                void lis4;
                block27 : {
                    Object object92 = object5;
                    prev = object7;
                    if (!lists.isPair(lis4)) break block26;
                    object8 = Promise.force(lis4, Pair.class);
                    try {
                        if (!KawaConvert.isTrue(pred.apply1(lists.car((Pair)object8)))) break block27;
                        object7 = lis4;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, prev2);
                    }
                    object8 = Promise.force(lis4, Pair.class);
                    try {
                        object5 = lists.cdr((Pair)object8);
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "cdr", 1, prev2);
                    }
                }
                object8 = Promise.force(lis4, Pair.class);
                try {
                    void lis3;
                    Object object10 = lists.cdr((Pair)object8);
                    prev2 = prev;
                    object9 = lis3;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, prev2);
                }
                while (lists.isPair(lis2 = object9)) {
                    block28 : {
                        object2 = Promise.force(lis2, Pair.class);
                        if (!KawaConvert.isTrue(pred.apply1(lists.car((Pair)object2)))) break block28;
                        object2 = Promise.force(prev2, Pair.class);
                        lists.setCdr$Ex((Pair)object2, lis2);
                        object7 = lis2;
                        object2 = Promise.force(lis2, Pair.class);
                        object5 = lists.cdr((Pair)object2);
                        continue block23;
                    }
                    object2 = Promise.force(lis2, Pair.class);
                    object9 = lists.cdr((Pair)object2);
                }
                break;
            } while (true);
            object2 = Promise.force(prev2, Pair.class);
            try {
                lists.setCdr$Ex((Pair)object2, lis2);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "set-cdr!", 1, object2);
            }
        }
        object3 = ans;
        return object3;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object partition(Procedure pred, Object lis) {
        var4_2 = LList.Empty;
        in /* !! */  = LList.Empty;
        lis = lis;
        do lbl-1000: // 3 sources:
        {
            if (srfi1.isNullList(lis)) {
                v0 = Promise.force(in /* !! */ , LList.class);
                var5_5 = v0;
                var5_5 = Promise.force(out, LList.class);
                return Values.values2(lists.reverse$Ex((LList)v0), lists.reverse$Ex((LList)var5_5));
            }
            var6_6 = Promise.force(lis, Pair.class);
            var5_5 = lists.car((Pair)var6_6);
            break;
        } while (true);
        catch (ClassCastException v1) {
            throw new WrongType(v1, "car", 1, tail);
        }
        {
            var7_7 = Promise.force(lis, Pair.class);
            tail = lists.cdr((Pair)var7_7);
            if (KawaConvert.isTrue(pred.apply1(head))) {
                in /* !! */  = lists.cons(head, in /* !! */ );
                lis = tail;
                continue;
            }
            out = lists.cons(head, out);
            lis = tail;
            ** while (true)
        }
        catch (ClassCastException v2) {
            throw new WrongType(v2, "cdr", 1, var7_7);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object partition$Ex(Procedure pred, Object lis) {
        void in$Mnhead;
        Object object2;
        Pair pair = lists.cons(Lit2, LList.Empty);
        Pair out$Mnhead = lists.cons(Lit2, LList.Empty);
        Object object3 = lis;
        Pair pair2 = out$Mnhead;
        void in = in$Mnhead;
        do {
            void out;
            Object lis2;
            block16 : {
                if (srfi1.isNotPair(lis2)) {
                    object2 = Promise.force(in, Pair.class);
                    lists.setCdr$Ex((Pair)object2, LList.Empty);
                    object2 = Promise.force(out, Pair.class);
                    lists.setCdr$Ex((Pair)object2, LList.Empty);
                    return Values.values2(lists.cdr((Pair)in$Mnhead), lists.cdr(out$Mnhead));
                }
                object2 = Promise.force(lis2, Pair.class);
                if (!KawaConvert.isTrue(pred.apply1(lists.car((Pair)object2)))) break block16;
                object2 = Promise.force(in, Pair.class);
                lists.setCdr$Ex((Pair)object2, lis2);
                void v0 = lis2;
                object2 = Promise.force(lis2, Pair.class);
                lis2 = lists.cdr((Pair)object2);
                in = v0;
                continue;
            }
            object2 = Promise.force(out, Pair.class);
            lists.setCdr$Ex((Pair)object2, lis2);
            void v1 = lis2;
            object2 = Promise.force(lis2, Pair.class);
            lis2 = lists.cdr((Pair)object2);
            out = v1;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "set-cdr!", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    public static Object remove(Object pred, Object l) {
        public class Frame3
        extends ModuleBody {
            Object pred;
            final ModuleMethod lambda$Fn2;

            public Frame3() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 2, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1186");
                this.lambda$Fn2 = moduleMethod;
            }

            boolean lambda12(Object x) {
                return !KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply2(this.pred, x));
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 2) {
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
                if (moduleMethod.selector == 2) {
                    return this.lambda12(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame3 $heapFrame = new Frame3();
        $heapFrame.pred = pred;
        return srfi1.filter($heapFrame.lambda$Fn2, l);
    }

    public static Object remove$Ex(Object pred, Object l) {
        public class Frame4
        extends ModuleBody {
            Object pred;
            final ModuleMethod lambda$Fn3;

            public Frame4() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 3, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1187");
                this.lambda$Fn3 = moduleMethod;
            }

            boolean lambda13(Object x) {
                return !KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply2(this.pred, x));
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 3) {
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
                if (moduleMethod.selector == 3) {
                    return this.lambda13(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame4 $heapFrame = new Frame4();
        $heapFrame.pred = pred;
        return srfi1.filter$Ex($heapFrame.lambda$Fn3, l);
    }

    public static Object delete(Object object2, Object object3) {
        return srfi1.delete(object2, object3, Scheme.isEqual);
    }

    public static Object delete(Object x, Object lis, Object maybe$Mn$Eq) {
        public class Frame5
        extends ModuleBody {
            Object x;
            Object maybe$Mn$Eq;
            final ModuleMethod lambda$Fn4;

            public Frame5() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 4, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1209");
                this.lambda$Fn4 = moduleMethod;
            }

            boolean lambda14(Object y) {
                return !KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply3(this.maybe$Mn$Eq, this.x, y));
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 4) {
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
                if (moduleMethod.selector == 4) {
                    return this.lambda14(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame5 $heapFrame = new Frame5();
        $heapFrame.x = x;
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return srfi1.filter($heapFrame.lambda$Fn4, lis);
    }

    public static Object delete$Ex(Object object2, Object object3) {
        return srfi1.delete$Ex(object2, object3, Scheme.isEqual);
    }

    public static Object delete$Ex(Object x, Object lis, Object maybe$Mn$Eq) {
        public class Frame6
        extends ModuleBody {
            Object x;
            Object maybe$Mn$Eq;
            final ModuleMethod lambda$Fn5;

            public Frame6() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 5, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1212");
                this.lambda$Fn5 = moduleMethod;
            }

            boolean lambda15(Object y) {
                return !KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply3(this.maybe$Mn$Eq, this.x, y));
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 5) {
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
                if (moduleMethod.selector == 5) {
                    return this.lambda15(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame6 $heapFrame = new Frame6();
        $heapFrame.x = x;
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return srfi1.filter$Ex($heapFrame.lambda$Fn5, lis);
    }

    public static Object deleteDuplicates(Object object2) {
        return srfi1.deleteDuplicates(object2, Scheme.isEqual);
    }

    public static Object deleteDuplicates(Object lis, Procedure maybe$Mn$Eq) {
        public class Frame7
        extends ModuleBody {
            Procedure maybe$Mn$Eq;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda16recur(Object lis) {
                Object tail;
                Object new$Mntail;
                Object x;
                Object object2;
                if (srfi1.isNullList(lis)) {
                    object2 = lis;
                    return object2;
                }
                Object object3 = Promise.force(lis, Pair.class);
                try {
                    x = lists.car((Pair)object3);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, tail);
                }
                Object object4 = Promise.force(lis, Pair.class);
                try {
                    tail = lists.cdr((Pair)object4);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, new$Mntail);
                }
                new$Mntail = this.lambda16recur(srfi1.delete(x, tail, this.maybe$Mn$Eq));
                if (tail == new$Mntail) {
                    object2 = lis;
                    return object2;
                }
                object2 = lists.cons(x, new$Mntail);
                return object2;
            }
        }
        Frame7 $heapFrame = new Frame7();
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return $heapFrame.lambda16recur(lis);
    }

    public static Object deleteDuplicates$Ex(Object object2) {
        return srfi1.deleteDuplicates$Ex(object2, Scheme.isEqual);
    }

    public static Object deleteDuplicates$Ex(Object lis, Procedure maybe$Mn$Eq) {
        public class Frame8
        extends ModuleBody {
            Procedure maybe$Mn$Eq;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda17recur(Object lis) {
                Object tail;
                Object new$Mntail;
                Object x;
                Object object2;
                if (srfi1.isNullList(lis)) {
                    object2 = lis;
                    return object2;
                }
                Object object3 = Promise.force(lis, Pair.class);
                try {
                    x = lists.car((Pair)object3);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, tail);
                }
                Object object4 = Promise.force(lis, Pair.class);
                try {
                    tail = lists.cdr((Pair)object4);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, new$Mntail);
                }
                new$Mntail = this.lambda17recur(srfi1.delete$Ex(x, tail, this.maybe$Mn$Eq));
                if (tail == new$Mntail) {
                    object2 = lis;
                    return object2;
                }
                object2 = lists.cons(x, new$Mntail);
                return object2;
            }
        }
        Frame8 $heapFrame = new Frame8();
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return $heapFrame.lambda17recur(lis);
    }

    public static Pair alistCons(Object key, Object datum, Object alist) {
        return lists.cons(lists.cons(key, datum), alist);
    }

    /*
     * Exception decompiling
     */
    public static LList alistCopy(Object alist) {
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

    public static Object alistDelete(Object object2, Object object3) {
        return srfi1.alistDelete(object2, object3, Scheme.isEqual);
    }

    public static Object alistDelete(Object key, Object alist, Object maybe$Mn$Eq) {
        public class Frame9
        extends ModuleBody {
            Object key;
            Object maybe$Mn$Eq;
            final ModuleMethod lambda$Fn6;

            public Frame9() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 6, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1267");
                this.lambda$Fn6 = moduleMethod;
            }

            boolean lambda18(Object elt) {
                Object object2 = Promise.force(elt, Pair.class);
                try {
                    return !KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply3(this.maybe$Mn$Eq, this.key, lists.car((Pair)object2)));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object2);
                }
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 6) {
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
                if (moduleMethod.selector == 6) {
                    return this.lambda18(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame9 $heapFrame = new Frame9();
        $heapFrame.key = key;
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return srfi1.filter($heapFrame.lambda$Fn6, alist);
    }

    public static Object alistDelete$Ex(Object object2, Object object3) {
        return srfi1.alistDelete$Ex(object2, object3, Scheme.isEqual);
    }

    public static Object alistDelete$Ex(Object key, Object alist, Object maybe$Mn$Eq) {
        public class Frame10
        extends ModuleBody {
            Object key;
            Object maybe$Mn$Eq;
            final ModuleMethod lambda$Fn7;

            public Frame10() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 7, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1270");
                this.lambda$Fn7 = moduleMethod;
            }

            boolean lambda19(Object elt) {
                Object object2 = Promise.force(elt, Pair.class);
                try {
                    return !KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply3(this.maybe$Mn$Eq, this.key, lists.car((Pair)object2)));
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object2);
                }
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 7) {
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
                if (moduleMethod.selector == 7) {
                    return this.lambda19(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame10 $heapFrame = new Frame10();
        $heapFrame.key = key;
        $heapFrame.maybe$Mn$Eq = maybe$Mn$Eq;
        return srfi1.filter$Ex($heapFrame.lambda$Fn7, alist);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object find(Object pred, Object list) {
        Object temp;
        Object object2;
        Object object3 = Promise.force(pred, Procedure.class);
        try {
            temp = srfi1.findTail(LangObjType.coerceToProcedure(object3), list);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "find-tail", 0, object3);
        }
        if (!KawaConvert.isTrue(temp)) {
            object2 = Boolean.FALSE;
            return object2;
        }
        object3 = Promise.force(temp, Pair.class);
        try {
            object2 = lists.car((Pair)object3);
            return object2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object3);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object findTail(Procedure pred, Object list) {
        v0 = list;
        do {
            if (srfi1.isNullList(list2 = v0)) {
                v1 = Boolean.FALSE;
                return v1;
            }
            object2 = Promise.force(list2, Pair.class);
            if (!KawaConvert.isTrue(pred.apply1(lists.car((Pair)object2)))) ** break block6
            v1 = list2;
            return v1;
            break;
        } while (true);
        catch (ClassCastException v2) {
            throw new WrongType(v2, "car", 1, object2);
        }
        {
            
            object2 = Promise.force(list2, Pair.class);
            v0 = lists.cdr((Pair)object2);
            continue;
        }
        catch (ClassCastException v3) {
            throw new WrongType(v3, "cdr", 1, object2);
        }
    }

    public static Object takeWhile(Procedure pred, Object lis) {
        public class Frame11
        extends ModuleBody {
            Procedure pred;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public Object lambda20recur(Object lis) {
                Object x;
                LList lList;
                if (srfi1.isNullList(lis)) {
                    lList = LList.Empty;
                    return lList;
                }
                Object object2 = Promise.force(lis, Pair.class);
                try {
                    x = lists.car((Pair)object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object2);
                }
                if (!KawaConvert.isTrue(this.pred.apply1(x))) {
                    lList = LList.Empty;
                    return lList;
                }
                object2 = Promise.force(lis, Pair.class);
                try {
                    lList = lists.cons(x, this.lambda20recur(lists.cdr((Pair)object2)));
                    return lList;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "cdr", 1, object2);
                }
            }
        }
        Frame11 $heapFrame = new Frame11();
        $heapFrame.pred = pred;
        return $heapFrame.lambda20recur(lis);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object dropWhile(Procedure pred, Object lis) {
        Object object2;
        Object lis2;
        Object object3;
        Object object4 = lis;
        do {
            if (srfi1.isNullList(lis2 = object4)) {
                object3 = LList.Empty;
                return object3;
            }
            object2 = Promise.force(lis2, Pair.class);
            if (!KawaConvert.isTrue(pred.apply1(lists.car((Pair)object2)))) break;
            object2 = Promise.force(lis2, Pair.class);
            object4 = lists.cdr((Pair)object2);
            continue;
            break;
        } while (true);
        object3 = lis2;
        return object3;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object takeWhile$Ex(Procedure pred, Object lis) {
        Object object22;
        Object object2;
        block12 : {
            Object prev;
            Object object4;
            Object object3;
            block11 : {
                block14 : {
                    block13 : {
                        boolean x = srfi1.isNullList(lis);
                        if (!x) break block13;
                        if (!x) break block11;
                        break block14;
                    }
                    object4 = Promise.force(lis, Pair.class);
                    try {
                        if (KawaConvert.isTrue(pred.apply1(lists.car((Pair)object4)))) break block11;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, prev);
                    }
                }
                object2 = LList.Empty;
                return object2;
            }
            Object object5 = lis;
            object4 = Promise.force(lis, Pair.class);
            try {
                object3 = lists.cdr((Pair)object4);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, prev);
            }
            do {
                void rest;
                Object object7 = object3;
                prev = object5;
                if (!lists.isPair(rest)) break block12;
                object22 = Promise.force(rest, Pair.class);
                Object x = lists.car((Pair)object22);
                if (!KawaConvert.isTrue(pred.apply1(x))) break;
                object5 = rest;
                object22 = Promise.force(rest, Pair.class);
                object3 = lists.cdr((Pair)object22);
                continue;
                break;
            } while (true);
            object22 = Promise.force(prev, Pair.class);
            try {
                lists.setCdr$Ex((Pair)object22, LList.Empty);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "set-cdr!", 1, object22);
            }
        }
        object2 = lis;
        return object2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object22);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object22);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object span(Procedure pred, Object lis) {
        Object head;
        Object object2;
        Values.Values2 values2;
        Object lis2;
        EmptyList res;
        Object object3 = lis;
        LList lList = res = LList.Empty;
        do {
            if (srfi1.isNullList(lis2 = object3)) {
                Object object4 = Promise.force(res, LList.class);
                values2 = Values.values2(lists.reverse$Ex((LList)object4), lis2);
                return values2;
            }
            object2 = Promise.force(lis2, Pair.class);
            head = lists.car((Pair)object2);
            if (!KawaConvert.isTrue(pred.apply1(head))) break;
            object2 = Promise.force(lis2, Pair.class);
            object3 = lists.cdr((Pair)object2);
            lList = lists.cons(head, res);
        } while (true);
        object2 = Promise.force(res, LList.class);
        try {
            values2 = Values.values2(lists.reverse$Ex((LList)object2), lis2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse!", 1, object2);
        }
        return values2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "reverse!", 1, head);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object span$Ex(Procedure pred, Object lis) {
        Values.Values2 values2;
        void suffix;
        Object object2;
        void v5;
        block13 : {
            void rest;
            Object object3;
            Object prev;
            block12 : {
                block15 : {
                    block14 : {
                        boolean x = srfi1.isNullList(lis);
                        if (!x) break block14;
                        if (!x) break block12;
                        break block15;
                    }
                    Object object32 = Promise.force(lis, Pair.class);
                    try {
                        if (KawaConvert.isTrue(pred.apply1(lists.car((Pair)object32)))) break block12;
                    }
                    catch (ClassCastException classCastException) {
                        throw new WrongType(classCastException, "car", 1, (Object)suffix);
                    }
                }
                values2 = Values.values2(LList.Empty, lis);
                return values2;
            }
            Object object4 = lis;
            Object object5 = Promise.force(lis, Pair.class);
            try {
                object3 = lists.cdr((Pair)object5);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, prev);
            }
            do {
                Object object7 = object3;
                prev = object4;
                if (srfi1.isNullList(rest)) {
                    v5 = rest;
                    break block13;
                }
                object2 = Promise.force(rest, Pair.class);
                Object x = lists.car((Pair)object2);
                if (!KawaConvert.isTrue(pred.apply1(x))) break;
                object4 = rest;
                object2 = Promise.force(rest, Pair.class);
                object3 = lists.cdr((Pair)object2);
                continue;
                break;
            } while (true);
            object2 = Promise.force(prev, Pair.class);
            try {
                lists.setCdr$Ex((Pair)object2, LList.Empty);
                v5 = rest;
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "set-cdr!", 1, object2);
            }
        }
        suffix = v5;
        values2 = Values.values2(lis, suffix);
        return values2;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    public static Object break(Object pred, Object lis) {
        public class Frame12
        extends ModuleBody {
            Object pred;
            final ModuleMethod lambda$Fn8;

            public Frame12() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 8, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1330");
                this.lambda$Fn8 = moduleMethod;
            }

            boolean lambda21(Object x) {
                return !KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply2(this.pred, x));
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
                    return this.lambda21(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame12 $heapFrame = new Frame12();
        $heapFrame.pred = pred;
        return srfi1.span($heapFrame.lambda$Fn8, lis);
    }

    public static Object break$Ex(Object pred, Object lis) {
        public class Frame13
        extends ModuleBody {
            Object pred;
            final ModuleMethod lambda$Fn9;

            public Frame13() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 9, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1331");
                this.lambda$Fn9 = moduleMethod;
            }

            boolean lambda22(Object x) {
                return !KawaConvert.isTrue(((Procedure)Scheme.applyToArgs).apply2(this.pred, x));
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
                    return this.lambda22(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame13 $heapFrame = new Frame13();
        $heapFrame.pred = pred;
        return srfi1.span$Ex($heapFrame.lambda$Fn9, lis);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object any$V(Procedure pred, Object lis1, Object[] argsArray) {
        void tail;
        Object tails22222222;
        Object head;
        Object object2;
        Object object3;
        Object object4;
        Object object32 = LList.makeList(argsArray, 0);
        Object lists2 = object32;
        if (!lists.isPair(lists2)) {
            if (srfi1.isNullList(lis1)) {
                object2 = Boolean.FALSE;
                return object2;
            }
            object32 = Promise.force(lis1, Pair.class);
            try {
                object3 = lists.car((Pair)object32);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "car", 1, head);
            }
            object32 = Promise.force(lis1, Pair.class);
            try {
                object4 = lists.cdr((Pair)object32);
            }
            catch (ClassCastException classCastException) {
                throw new WrongType(classCastException, "cdr", 1, head);
            }
        } else {
            void heads;
            object32 = srfi1.$PcCars$PlCdrs(lists.cons(lis1, lists2));
            int n = 0;
            n = Values.incrPos(object32, n);
            Object object42 = Values.getFromPos(object32, n);
            n = Values.incrPos(object32, n);
            Object tails22222222 = Values.getFromPosFinal(object32, n);
            if (!lists.isPair(heads)) {
                object2 = Boolean.FALSE;
                return object2;
            }
            Object object5 = heads;
            Object object6 = tails22222222;
            do {
                void tails3;
                Object object7 = object6;
                void heads2 = object5;
                Pair split = srfi1.$PcCars$PlCdrs$SlPair(tails3);
                Object next$Mnheads = lists.car(split);
                Object next$Mntails = lists.cdr(split);
                if (!lists.isPair(next$Mnheads)) {
                    object2 = ((Procedure)Scheme.apply).apply2(pred, heads2);
                    return object2;
                }
                Object x = ((Procedure)Scheme.apply).apply2(pred, heads2);
                if (KawaConvert.isTrue(x)) {
                    object2 = x;
                    return object2;
                }
                object5 = next$Mnheads;
                object6 = next$Mntails;
            } while (true);
        }
        do {
            Object object10 = object4;
            head = object3;
            if (srfi1.isNullList(tail)) {
                object2 = pred.apply1(head);
                return object2;
            }
            Object x = pred.apply1(head);
            if (KawaConvert.isTrue(x)) {
                object2 = x;
                return object2;
            }
            tails22222222 = Promise.force(tail, Pair.class);
            object3 = lists.car((Pair)tails22222222);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, tails22222222);
        }
        {
            tails22222222 = Promise.force(tail, Pair.class);
            object4 = lists.cdr((Pair)tails22222222);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, tails22222222);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object every$V(Procedure pred, Object lis1, Object[] argsArray) {
        void tail;
        Object object2;
        Object head;
        Object object3;
        Object object4;
        Object tails22222222;
        Object object32 = LList.makeList(argsArray, 0);
        Object lists2 = object32;
        if (lists.isPair(lists2)) {
            boolean x;
            void heads2;
            object32 = srfi1.$PcCars$PlCdrs(lists.cons(lis1, lists2));
            int n = 0;
            n = Values.incrPos(object32, n);
            Object object42 = Values.getFromPos(object32, n);
            n = Values.incrPos(object32, n);
            Object tails22222222 = Values.getFromPosFinal(object32, n);
            boolean bl = x = !lists.isPair(heads2);
            if (x) {
                if (x) {
                    object2 = Boolean.TRUE;
                    return object2;
                }
                object2 = Boolean.FALSE;
                return object2;
            }
            void v2 = heads2;
            Object object5 = tails22222222;
            do {
                void tails3;
                void next$Mnheads;
                Object object6 = object5;
                void heads = v2;
                Object object7 = srfi1.$PcCars$PlCdrs(tails3);
                int n2 = 0;
                n2 = Values.incrPos(object7, n2);
                Object object8 = Values.getFromPos(object7, n2);
                n2 = Values.incrPos(object7, n2);
                Object next$Mntails = Values.getFromPosFinal(object7, n2);
                if (!lists.isPair(next$Mnheads)) {
                    object2 = ((Procedure)Scheme.apply).apply2(pred, heads);
                    return object2;
                }
                if (!KawaConvert.isTrue(((Procedure)Scheme.apply).apply2(pred, heads))) {
                    object2 = Boolean.FALSE;
                    return object2;
                }
                v2 = next$Mnheads;
                object5 = next$Mntails;
            } while (true);
        }
        boolean x = srfi1.isNullList(lis1);
        if (x) {
            if (x) {
                object2 = Boolean.TRUE;
                return object2;
            }
            object2 = Boolean.FALSE;
            return object2;
        }
        Object object9 = Promise.force(lis1, Pair.class);
        try {
            object3 = lists.car((Pair)object9);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, head);
        }
        object9 = Promise.force(lis1, Pair.class);
        try {
            object4 = lists.cdr((Pair)object9);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, head);
        }
        do {
            Object heads2 = object4;
            head = object3;
            if (srfi1.isNullList(tail)) {
                object2 = pred.apply1(head);
                return object2;
            }
            if (!KawaConvert.isTrue(pred.apply1(head))) {
                object2 = Boolean.FALSE;
                return object2;
            }
            tails22222222 = Promise.force(tail, Pair.class);
            object3 = lists.car((Pair)tails22222222);
            break;
        } while (true);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, tails22222222);
        }
        {
            tails22222222 = Promise.force(tail, Pair.class);
            object4 = lists.cdr((Pair)tails22222222);
            continue;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, tails22222222);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object listIndex$V(Procedure pred, Object lis1, Object[] argsArray) {
        lList = LList.makeList(argsArray, 0);
        lists2 = lList;
        if (lists.isPair(lists2)) {
            v0 = lists.cons(lis1, lists2);
            v1 = srfi1.Lit0;
            do {
                intNum2 = v1;
                lists3 = v0;
                object4 = srfi1.$PcCars$PlCdrs(lists3);
                n22 = 0;
                n22 = Values.incrPos(object4, n22);
                object5 = Values.getFromPos(object4, n22);
                n22 = Values.incrPos(object4, n22);
                tails = Values.getFromPosFinal(object4, n22);
                if (!lists.isPair(heads)) {
                    v2 = Boolean.FALSE;
                    return v2;
                }
                if (KawaConvert.isTrue(Scheme.apply.apply2(pred, heads))) {
                    v2 = n2;
                    return v2;
                }
                v0 = tails;
                v1 = IntNum.add((IntNum)n2, 1);
            } while (true);
        }
        v3 = lis1;
        v4 = srfi1.Lit0;
        do lbl-1000: // 2 sources:
        {
            n2 = v4;
            lis = v3;
            if (srfi1.isNullList(lis)) {
                v2 = Boolean.FALSE;
                return v2;
            }
            object2 = Promise.force(lis, Pair.class);
            if (!KawaConvert.isTrue(pred.apply1(lists.car((Pair)object2)))) ** break block10
            v2 = n;
            return v2;
            break;
        } while (true);
        catch (ClassCastException v5) {
            throw new WrongType(v5, "car", 1, object2);
        }
        {
            
            object2 = Promise.force(lis, Pair.class);
            v3 = lists.cdr((Pair)object2);
            v4 = IntNum.add((IntNum)n, 1);
            ** while (true)
        }
        catch (ClassCastException v6) {
            throw new WrongType(v6, "cdr", 1, object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object lset$Ls$Eq$V(Procedure $Eq, Object[] argsArray) {
        boolean x;
        Object s1;
        Object object2;
        Object object3;
        Boolean bl;
        Object rest;
        LList lList = LList.makeList(argsArray, 0);
        LList lists2 = lList;
        boolean bl2 = x = !lists.isPair(lists2);
        if (x) {
            if (x) {
                bl = Boolean.TRUE;
                return bl;
            }
            bl = Boolean.FALSE;
            return bl;
        }
        LList lList2 = lists2;
        try {
            object2 = lists.car((Pair)lList2);
            lList2 = lists2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, s1);
        }
        try {
            object3 = lists.cdr((Pair)lList2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, s1);
        }
        do {
            boolean x2;
            void s2;
            void rest2;
            boolean x3;
            Object object4 = object3;
            s1 = object2;
            boolean bl3 = x2 = !lists.isPair(rest2);
            if (x2) {
                if (x2) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            Object object5 = Promise.force(rest2, Pair.class);
            Object object6 = lists.car((Pair)object5);
            Object object7 = Promise.force(rest2, Pair.class);
            rest = lists.cdr((Pair)object7);
            boolean bl4 = x3 = s2 == s1;
            if (!(x3 ? x3 : KawaConvert.isTrue(srfi1.$PcLset2$Ls$Eq($Eq, s1, s2)))) break;
            object2 = s2;
            object3 = rest;
        } while (true);
        bl = Boolean.FALSE;
        return bl;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, rest);
        }
        catch (ClassCastException classCastException) {
            void x3;
            throw new WrongType(classCastException, "cdr", 1, (Object)x3);
        }
    }

    static Object $PcLset2$Ls$Eq(Object $Eq, Object lis1, Object lis2) {
        public class Frame40
        extends ModuleBody {
            Object $Eq;
            Object lis2;
            final ModuleMethod lambda$Fn33;

            public Frame40() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 33, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1430");
                this.lambda$Fn33 = moduleMethod;
            }

            Object lambda51(Object x) {
                Object object2 = Promise.force(this.$Eq, Procedure.class);
                try {
                    return lists.member(x, this.lis2, (Procedure)object2);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "member", 3, object2);
                }
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 33) {
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
                if (moduleMethod.selector == 33) {
                    return this.lambda51(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame40 $heapFrame = new Frame40();
        $heapFrame.$Eq = $Eq;
        $heapFrame.lis2 = lis2;
        return srfi1.every$V($heapFrame.lambda$Fn33, lis1, new Object[0]);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static Object lset$Eq$V(Procedure $Eq, Object[] argsArray) {
        boolean x;
        Object s1;
        Object object2;
        Object object3;
        Boolean bl;
        Object rest;
        LList lList = LList.makeList(argsArray, 0);
        LList lists2 = lList;
        boolean bl2 = x = !lists.isPair(lists2);
        if (x) {
            if (x) {
                bl = Boolean.TRUE;
                return bl;
            }
            bl = Boolean.FALSE;
            return bl;
        }
        LList lList2 = lists2;
        try {
            object2 = lists.car((Pair)lList2);
            lList2 = lists2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, s1);
        }
        try {
            object3 = lists.cdr((Pair)lList2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, s1);
        }
        do {
            boolean x2;
            void s2;
            void rest2;
            boolean x3;
            Object object4 = object3;
            s1 = object2;
            boolean bl3 = x2 = !lists.isPair(rest2);
            if (x2) {
                if (x2) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            Object object5 = Promise.force(rest2, Pair.class);
            Object object6 = lists.car((Pair)object5);
            Object object7 = Promise.force(rest2, Pair.class);
            rest = lists.cdr((Pair)object7);
            boolean bl4 = x3 = s1 == s2;
            if (!(x3 ? x3 : KawaConvert.isTrue(srfi1.$PcLset2$Ls$Eq($Eq, s1, s2)) && KawaConvert.isTrue(srfi1.$PcLset2$Ls$Eq($Eq, s2, s1)))) break;
            object2 = s2;
            object3 = rest;
        } while (true);
        bl = Boolean.FALSE;
        return bl;
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, rest);
        }
        catch (ClassCastException classCastException) {
            void x3;
            throw new WrongType(classCastException, "cdr", 1, (Object)x3);
        }
    }

    public static Object lsetAdjoin$V(Procedure $Eq, Object lis, Object[] argsArray) {
        LList lList;
        public class Frame14
        extends ModuleBody {
            Procedure $Eq;
            final ModuleMethod lambda$Fn10;

            public Frame14() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 10, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1453");
                this.lambda$Fn10 = moduleMethod;
            }

            Object lambda23(Object elt, Object ans) {
                return KawaConvert.isTrue(lists.member(elt, ans, this.$Eq)) ? ans : lists.cons(elt, ans);
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                if (moduleMethod.selector == 10) {
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
                if (moduleMethod.selector == 10) {
                    return this.lambda23(object2, object3);
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame14 $heapFrame = new Frame14();
        $heapFrame.$Eq = $Eq;
        LList elts = lList = LList.makeList(argsArray, 0);
        return srfi1.fold$V($heapFrame.lambda$Fn10, lis, elts, new Object[0]);
    }

    public static Object lsetUnion$V(Procedure $Eq, Object[] argsArray) {
        LList lList;
        public class Frame15
        extends ModuleBody {
            Procedure $Eq;
            final ModuleMethod lambda$Fn11;
            final ModuleMethod lambda$Fn12;

            public Frame15() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 12, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1463");
                this.lambda$Fn12 = moduleMethod;
                ModuleMethod moduleMethod2 = new ModuleMethod(this, 13, null, 8194);
                moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1458");
                this.lambda$Fn11 = moduleMethod2;
            }

            Object lambda24(Object lis, Object ans) {
                return lists.isNull(lis) ? ans : (lists.isNull(ans) ? lis : (lis == ans ? ans : srfi1.fold$V(this.lambda$Fn12, ans, lis, new Object[0])));
            }

            Object lambda25(Object elt, Object ans) {
                new Frame16().staticLink = this;
                public class Frame16
                extends ModuleBody {
                    Object elt;
                    Frame15 staticLink;
                    final ModuleMethod lambda$Fn13;

                    public Frame16() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 11, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1463");
                        this.lambda$Fn13 = moduleMethod;
                    }

                    Object lambda26(Object x) {
                        return this.staticLink.$Eq.apply2(x, this.elt);
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
                            return this.lambda26(object2);
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame16 $heapFrame = new Frame16();
                $heapFrame.elt = elt;
                return KawaConvert.isTrue(srfi1.any$V($heapFrame.lambda$Fn13, ans, new Object[0])) ? ans : lists.cons($heapFrame.elt, ans);
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                switch (moduleMethod.selector) {
                    case 13: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 12: {
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

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                switch (moduleMethod.selector) {
                    case 12: {
                        return this.lambda25(object2, object3);
                    }
                    case 13: {
                        return this.lambda24(object2, object3);
                    }
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame15 $heapFrame = new Frame15();
        $heapFrame.$Eq = $Eq;
        LList lists2 = lList = LList.makeList(argsArray, 0);
        return srfi1.reduce($heapFrame.lambda$Fn11, LList.Empty, lists2);
    }

    public static Object lsetUnion$Ex$V(Procedure $Eq, Object[] argsArray) {
        LList lList;
        public class Frame17
        extends ModuleBody {
            Procedure $Eq;
            final ModuleMethod lambda$Fn14;
            final ModuleMethod lambda$Fn15;

            public Frame17() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 15, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1475");
                this.lambda$Fn15 = moduleMethod;
                ModuleMethod moduleMethod2 = new ModuleMethod(this, 16, null, 8194);
                moduleMethod2.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1470");
                this.lambda$Fn14 = moduleMethod2;
            }

            Object lambda27(Object lis, Object ans) {
                return lists.isNull(lis) ? ans : (lists.isNull(ans) ? lis : (lis == ans ? ans : srfi1.pairFold$V(this.lambda$Fn15, ans, lis, new Object[0])));
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            Object lambda28(Object pair, Object ans) {
                Object object2;
                new Frame18().staticLink = this;
                public class Frame18
                extends ModuleBody {
                    Object elt;
                    Frame17 staticLink;
                    final ModuleMethod lambda$Fn16;

                    public Frame18() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 14, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1477");
                        this.lambda$Fn16 = moduleMethod;
                    }

                    Object lambda29(Object x) {
                        return this.staticLink.$Eq.apply2(x, this.elt);
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 14) {
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
                        if (moduleMethod.selector == 14) {
                            return this.lambda29(object2);
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame18 $heapFrame = new Frame18();
                Object object3 = Promise.force(pair, Pair.class);
                try {
                    $heapFrame.elt = lists.car((Pair)object3);
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "car", 1, object3);
                }
                if (KawaConvert.isTrue(srfi1.any$V($heapFrame.lambda$Fn16, ans, new Object[0]))) {
                    object2 = ans;
                    return object2;
                }
                object3 = Promise.force(pair, Pair.class);
                try {
                    lists.setCdr$Ex((Pair)object3, ans);
                    object2 = pair;
                }
                catch (ClassCastException classCastException) {
                    throw new WrongType(classCastException, "set-cdr!", 1, object3);
                }
                return object2;
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                switch (moduleMethod.selector) {
                    case 16: {
                        callContext.value1 = object2;
                        callContext.value2 = object3;
                        callContext.proc = moduleMethod;
                        callContext.pc = 2;
                        return 0;
                    }
                    case 15: {
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

            public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
                switch (moduleMethod.selector) {
                    case 15: {
                        return this.lambda28(object2, object3);
                    }
                    case 16: {
                        return this.lambda27(object2, object3);
                    }
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame17 $heapFrame = new Frame17();
        $heapFrame.$Eq = $Eq;
        LList lists2 = lList = LList.makeList(argsArray, 0);
        return srfi1.reduce($heapFrame.lambda$Fn14, LList.Empty, lists2);
    }

    public static Object lsetIntersection$V(Procedure $Eq, Object lis1, Object[] argsArray) {
        LList lList;
        public class Frame19
        extends ModuleBody {
            Object lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn17;

            public Frame19() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 18, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1488");
                this.lambda$Fn17 = moduleMethod;
            }

            Object lambda30(Object x) {
                new Frame20().staticLink = this;
                public class Frame20
                extends ModuleBody {
                    Object x;
                    Frame19 staticLink;
                    final ModuleMethod lambda$Fn18;

                    public Frame20() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 17, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1489");
                        this.lambda$Fn18 = moduleMethod;
                    }

                    Object lambda31(Object lis) {
                        return lists.member(this.x, lis, this.staticLink.$Eq);
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 17) {
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
                        if (moduleMethod.selector == 17) {
                            return this.lambda31(object2);
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame20 $heapFrame = new Frame20();
                $heapFrame.x = x;
                return srfi1.every$V($heapFrame.lambda$Fn18, this.lists, new Object[0]);
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 18) {
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
                if (moduleMethod.selector == 18) {
                    return this.lambda30(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame19 $heapFrame = new Frame19();
        $heapFrame.$Eq = $Eq;
        LList lists2 = lList = LList.makeList(argsArray, 0);
        $heapFrame.lists = srfi1.delete(lis1, lists2, Scheme.isEq);
        return KawaConvert.isTrue(srfi1.any$V(null$Mnlist$Qu, $heapFrame.lists, new Object[0])) ? LList.Empty : (lists.isNull($heapFrame.lists) ? lis1 : srfi1.filter($heapFrame.lambda$Fn17, lis1));
    }

    public static Object lsetIntersection$Ex$V(Procedure $Eq, Object lis1, Object[] argsArray) {
        LList lList;
        public class Frame21
        extends ModuleBody {
            Object lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn19;

            public Frame21() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 20, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1496");
                this.lambda$Fn19 = moduleMethod;
            }

            Object lambda32(Object x) {
                new Frame22().staticLink = this;
                public class Frame22
                extends ModuleBody {
                    Object x;
                    Frame21 staticLink;
                    final ModuleMethod lambda$Fn20;

                    public Frame22() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 19, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1497");
                        this.lambda$Fn20 = moduleMethod;
                    }

                    Object lambda33(Object lis) {
                        return lists.member(this.x, lis, this.staticLink.$Eq);
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 19) {
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
                        if (moduleMethod.selector == 19) {
                            return this.lambda33(object2);
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame22 $heapFrame = new Frame22();
                $heapFrame.x = x;
                return srfi1.every$V($heapFrame.lambda$Fn20, this.lists, new Object[0]);
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 20) {
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
                if (moduleMethod.selector == 20) {
                    return this.lambda32(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame21 $heapFrame = new Frame21();
        $heapFrame.$Eq = $Eq;
        LList lists2 = lList = LList.makeList(argsArray, 0);
        $heapFrame.lists = srfi1.delete(lis1, lists2, Scheme.isEq);
        return KawaConvert.isTrue(srfi1.any$V(null$Mnlist$Qu, $heapFrame.lists, new Object[0])) ? LList.Empty : (lists.isNull($heapFrame.lists) ? lis1 : srfi1.filter$Ex($heapFrame.lambda$Fn19, lis1));
    }

    public static Object lsetDifference$V(Procedure $Eq, Object lis1, Object[] argsArray) {
        LList lList;
        public class Frame23
        extends ModuleBody {
            Object lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn21;

            public Frame23() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 22, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1505");
                this.lambda$Fn21 = moduleMethod;
            }

            Object lambda34(Object x) {
                new Frame24().staticLink = this;
                public class Frame24
                extends ModuleBody {
                    Object x;
                    Frame23 staticLink;
                    final ModuleMethod lambda$Fn22;

                    public Frame24() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 21, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1506");
                        this.lambda$Fn22 = moduleMethod;
                    }

                    boolean lambda35(Object lis) {
                        return !KawaConvert.isTrue(lists.member(this.x, lis, this.staticLink.$Eq));
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 21) {
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
                        if (moduleMethod.selector == 21) {
                            return this.lambda35(object2) ? Boolean.TRUE : Boolean.FALSE;
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame24 $heapFrame = new Frame24();
                $heapFrame.x = x;
                return srfi1.every$V($heapFrame.lambda$Fn22, this.lists, new Object[0]);
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 22) {
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
                if (moduleMethod.selector == 22) {
                    return this.lambda34(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame23 $heapFrame = new Frame23();
        $heapFrame.$Eq = $Eq;
        LList lists2 = lList = LList.makeList(argsArray, 0);
        $heapFrame.lists = srfi1.filter(lists.pair$Qu, lists2);
        return lists.isNull($heapFrame.lists) ? lis1 : (KawaConvert.isTrue(lists.memq(lis1, $heapFrame.lists)) ? LList.Empty : srfi1.filter($heapFrame.lambda$Fn21, lis1));
    }

    public static Object lsetDifference$Ex$V(Procedure $Eq, Object lis1, Object[] argsArray) {
        LList lList;
        public class Frame25
        extends ModuleBody {
            Object lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn23;

            public Frame25() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 24, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1514");
                this.lambda$Fn23 = moduleMethod;
            }

            Object lambda36(Object x) {
                new Frame26().staticLink = this;
                public class Frame26
                extends ModuleBody {
                    Object x;
                    Frame25 staticLink;
                    final ModuleMethod lambda$Fn24;

                    public Frame26() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 23, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1515");
                        this.lambda$Fn24 = moduleMethod;
                    }

                    boolean lambda37(Object lis) {
                        return !KawaConvert.isTrue(lists.member(this.x, lis, this.staticLink.$Eq));
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 23) {
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
                        if (moduleMethod.selector == 23) {
                            return this.lambda37(object2) ? Boolean.TRUE : Boolean.FALSE;
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame26 $heapFrame = new Frame26();
                $heapFrame.x = x;
                return srfi1.every$V($heapFrame.lambda$Fn24, this.lists, new Object[0]);
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 24) {
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
                if (moduleMethod.selector == 24) {
                    return this.lambda36(object2);
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame25 $heapFrame = new Frame25();
        $heapFrame.$Eq = $Eq;
        LList lists2 = lList = LList.makeList(argsArray, 0);
        $heapFrame.lists = srfi1.filter(lists.pair$Qu, lists2);
        return lists.isNull($heapFrame.lists) ? lis1 : (KawaConvert.isTrue(lists.memq(lis1, $heapFrame.lists)) ? LList.Empty : srfi1.filter$Ex($heapFrame.lambda$Fn23, lis1));
    }

    public static Object lsetXor$V(Procedure $Eq, Object[] argsArray) {
        LList lList;
        public class Frame27
        extends ModuleBody {
            Procedure $Eq;
            final ModuleMethod lambda$Fn25;

            public Frame27() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 26, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1521");
                this.lambda$Fn25 = moduleMethod;
            }

            Object lambda38(Object b, Object a) {
                void a$Mnb;
                new Frame28().staticLink = this;
                public class Frame28
                extends ModuleBody {
                    Object a$Mnint$Mnb;
                    Frame27 staticLink;
                    final ModuleMethod lambda$Fn26;

                    public Frame28() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 25, null, 8194);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1534");
                        this.lambda$Fn26 = moduleMethod;
                    }

                    Object lambda39(Object xb, Object ans) {
                        return KawaConvert.isTrue(lists.member(xb, this.a$Mnint$Mnb, this.staticLink.$Eq)) ? ans : lists.cons(xb, ans);
                    }

                    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                        if (moduleMethod.selector == 25) {
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
                        if (moduleMethod.selector == 25) {
                            return this.lambda39(object2, object3);
                        }
                        return super.apply2(moduleMethod, object2, object3);
                    }
                }
                Frame28 $heapFrame = new Frame28();
                Object object2 = srfi1.lsetDiff$PlIntersection$V(this.$Eq, a, new Object[]{b});
                int n = 0;
                n = Values.incrPos(object2, n);
                Object object3 = Values.getFromPos(object2, n);
                n = Values.incrPos(object2, n);
                $heapFrame.a$Mnint$Mnb = Values.getFromPosFinal(object2, n);
                return lists.isNull(a$Mnb) ? srfi1.lsetDifference$V(this.$Eq, b, new Object[]{a}) : (lists.isNull($heapFrame.a$Mnint$Mnb) ? append.append$V(new Object[]{b, a}) : srfi1.fold$V($heapFrame.lambda$Fn26, a$Mnb, b, new Object[0]));
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                if (moduleMethod.selector == 26) {
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
                if (moduleMethod.selector == 26) {
                    return this.lambda38(object2, object3);
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame27 $heapFrame = new Frame27();
        $heapFrame.$Eq = $Eq;
        LList lists2 = lList = LList.makeList(argsArray, 0);
        return srfi1.reduce($heapFrame.lambda$Fn25, LList.Empty, lists2);
    }

    public static Object lsetDiff$PlIntersection$V(Procedure $Eq, Object lis1, Object[] argsArray) {
        LList lList;
        public class Frame31
        extends ModuleBody {
            LList lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn29;

            public Frame31() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 30, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1566");
                this.lambda$Fn29 = moduleMethod;
            }

            boolean lambda42(Object elt) {
                new Frame32().staticLink = this;
                public class Frame32
                extends ModuleBody {
                    Object elt;
                    Frame31 staticLink;
                    final ModuleMethod lambda$Fn30;

                    public Frame32() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 29, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1567");
                        this.lambda$Fn30 = moduleMethod;
                    }

                    Object lambda43(Object lis) {
                        return lists.member(this.elt, lis, this.staticLink.$Eq);
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 29) {
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
                        if (moduleMethod.selector == 29) {
                            return this.lambda43(object2);
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame32 $heapFrame = new Frame32();
                $heapFrame.elt = elt;
                return !KawaConvert.isTrue(srfi1.any$V($heapFrame.lambda$Fn30, this.lists, new Object[0]));
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 30) {
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
                if (moduleMethod.selector == 30) {
                    return this.lambda42(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame31 $heapFrame = new Frame31();
        $heapFrame.$Eq = $Eq;
        $heapFrame.lists = lList = LList.makeList(argsArray, 0);
        return KawaConvert.isTrue(srfi1.every$V(null$Mnlist$Qu, $heapFrame.lists, new Object[0])) ? Values.values2(lis1, LList.Empty) : (KawaConvert.isTrue(lists.memq(lis1, $heapFrame.lists)) ? Values.values2(LList.Empty, lis1) : srfi1.partition($heapFrame.lambda$Fn29, lis1));
    }

    public static Object lsetXor$Ex$V(Procedure $Eq, Object[] argsArray) {
        LList lList;
        public class Frame29
        extends ModuleBody {
            Procedure $Eq;
            final ModuleMethod lambda$Fn27;

            public Frame29() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 28, null, 8194);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1542");
                this.lambda$Fn27 = moduleMethod;
            }

            Object lambda40(Object b, Object a) {
                void a$Mnb;
                new Frame30().staticLink = this;
                public class Frame30
                extends ModuleBody {
                    Object a$Mnint$Mnb;
                    Frame29 staticLink;
                    final ModuleMethod lambda$Fn28;

                    public Frame30() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 27, null, 8194);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1555");
                        this.lambda$Fn28 = moduleMethod;
                    }

                    Object lambda41(Object b$Mnpair, Object ans) {
                        Object object2;
                        Object object3;
                        block4 : {
                            object2 = Promise.force(b$Mnpair, Pair.class);
                            try {
                                if (!KawaConvert.isTrue(lists.member(lists.car((Pair)object2), this.a$Mnint$Mnb, this.staticLink.$Eq))) break block4;
                                object3 = ans;
                            }
                            catch (ClassCastException classCastException) {
                                throw new WrongType(classCastException, "car", 1, object2);
                            }
                        }
                        object2 = Promise.force(b$Mnpair, Pair.class);
                        try {
                            lists.setCdr$Ex((Pair)object2, ans);
                            object3 = b$Mnpair;
                        }
                        catch (ClassCastException classCastException) {
                            throw new WrongType(classCastException, "set-cdr!", 1, object2);
                        }
                        return object3;
                    }

                    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                        if (moduleMethod.selector == 27) {
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
                        if (moduleMethod.selector == 27) {
                            return this.lambda41(object2, object3);
                        }
                        return super.apply2(moduleMethod, object2, object3);
                    }
                }
                Frame30 $heapFrame = new Frame30();
                Object object2 = srfi1.lsetDiff$PlIntersection$Ex$V(this.$Eq, a, new Object[]{b});
                int n = 0;
                n = Values.incrPos(object2, n);
                Object object3 = Values.getFromPos(object2, n);
                n = Values.incrPos(object2, n);
                $heapFrame.a$Mnint$Mnb = Values.getFromPosFinal(object2, n);
                return lists.isNull(a$Mnb) ? srfi1.lsetDifference$Ex$V(this.$Eq, b, new Object[]{a}) : (lists.isNull($heapFrame.a$Mnint$Mnb) ? srfi1.append$Ex$V(new Object[]{b, a}) : srfi1.pairFold$V($heapFrame.lambda$Fn28, a$Mnb, b, new Object[0]));
            }

            public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
                if (moduleMethod.selector == 28) {
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
                if (moduleMethod.selector == 28) {
                    return this.lambda40(object2, object3);
                }
                return super.apply2(moduleMethod, object2, object3);
            }
        }
        Frame29 $heapFrame = new Frame29();
        $heapFrame.$Eq = $Eq;
        LList lists2 = lList = LList.makeList(argsArray, 0);
        return srfi1.reduce($heapFrame.lambda$Fn27, LList.Empty, lists2);
    }

    public static Object lsetDiff$PlIntersection$Ex$V(Procedure $Eq, Object lis1, Object[] argsArray) {
        LList lList;
        public class Frame33
        extends ModuleBody {
            LList lists;
            Procedure $Eq;
            final ModuleMethod lambda$Fn31;

            public Frame33() {
                ModuleMethod moduleMethod = new ModuleMethod(this, 32, null, 4097);
                moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1574");
                this.lambda$Fn31 = moduleMethod;
            }

            boolean lambda44(Object elt) {
                new Frame34().staticLink = this;
                public class Frame34
                extends ModuleBody {
                    Object elt;
                    Frame33 staticLink;
                    final ModuleMethod lambda$Fn32;

                    public Frame34() {
                        ModuleMethod moduleMethod = new ModuleMethod(this, 31, null, 4097);
                        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm:1575");
                        this.lambda$Fn32 = moduleMethod;
                    }

                    Object lambda45(Object lis) {
                        return lists.member(this.elt, lis, this.staticLink.$Eq);
                    }

                    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                        if (moduleMethod.selector == 31) {
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
                        if (moduleMethod.selector == 31) {
                            return this.lambda45(object2);
                        }
                        return super.apply1(moduleMethod, object2);
                    }
                }
                Frame34 $heapFrame = new Frame34();
                $heapFrame.elt = elt;
                return !KawaConvert.isTrue(srfi1.any$V($heapFrame.lambda$Fn32, this.lists, new Object[0]));
            }

            public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
                if (moduleMethod.selector == 32) {
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
                if (moduleMethod.selector == 32) {
                    return this.lambda44(object2) ? Boolean.TRUE : Boolean.FALSE;
                }
                return super.apply1(moduleMethod, object2);
            }
        }
        Frame33 $heapFrame = new Frame33();
        $heapFrame.$Eq = $Eq;
        $heapFrame.lists = lList = LList.makeList(argsArray, 0);
        return KawaConvert.isTrue(srfi1.every$V(null$Mnlist$Qu, $heapFrame.lists, new Object[0])) ? Values.values2(lis1, LList.Empty) : (KawaConvert.isTrue(lists.memq(lis1, $heapFrame.lists)) ? Values.values2(LList.Empty, lis1) : srfi1.partition$Ex($heapFrame.lambda$Fn31, lis1));
    }

    static Object $PcCars$PlCdrs$SlNoTest(Object lists2) {
        return srfi1.lambda50recur(lists2);
    }

    public static Object lambda50recur(Object lists2) {
        Values.Values2 values2;
        if (lists.isPair(lists2)) {
            void list;
            void a;
            void cars;
            Values values = srfi1.car$PlCdr(lists2);
            int n = 0;
            n = Values.incrPos(values, n);
            Object object2 = Values.getFromPos(values, n);
            n = Values.incrPos(values, n);
            Object other$Mnlists = Values.getFromPosFinal(values, n);
            Values values3 = srfi1.car$PlCdr(list);
            int n2 = 0;
            n2 = Values.incrPos(values3, n2);
            Object object3 = Values.getFromPos(values3, n2);
            n2 = Values.incrPos(values3, n2);
            Object d = Values.getFromPosFinal(values3, n2);
            Object object4 = srfi1.lambda50recur(other$Mnlists);
            int n3 = 0;
            n3 = Values.incrPos(object4, n3);
            Object object5 = Values.getFromPos(object4, n3);
            n3 = Values.incrPos(object4, n3);
            Object cdrs = Values.getFromPosFinal(object4, n3);
            values2 = Values.values2(lists.cons(a, cars), lists.cons(d, cdrs));
        } else {
            values2 = Values.values2(LList.Empty, LList.Empty);
        }
        return values2;
    }

    public static {
        Lit104 = Symbol.valueOf("cdr");
        Lit99 = Symbol.valueOf("tail");
        Lit103 = PairWithPosition.make(Lit99, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668888);
        Lit102 = Symbol.valueOf("car");
        Lit101 = Symbol.valueOf("lp");
        Lit100 = Symbol.valueOf("head");
        Lit98 = new Object[0];
        Lit97 = Symbol.valueOf("lset-diff+intersection!");
        Lit96 = Symbol.valueOf("lset-diff+intersection");
        Lit95 = Symbol.valueOf("lset-xor!");
        Lit94 = Symbol.valueOf("lset-xor");
        Lit93 = Symbol.valueOf("lset-difference!");
        Lit92 = Symbol.valueOf("lset-difference");
        Lit91 = Symbol.valueOf("lset-intersection!");
        Lit90 = Symbol.valueOf("lset-intersection");
        Lit89 = Symbol.valueOf("lset-union!");
        Lit88 = Symbol.valueOf("lset-union");
        Lit87 = Symbol.valueOf("lset-adjoin");
        Lit86 = Symbol.valueOf("lset=");
        Lit85 = Symbol.valueOf("lset<=");
        Lit84 = Symbol.valueOf("list-index");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[1];
        Object[] arrobject = new Object[10];
        arrobject[0] = Symbol.valueOf("let");
        arrobject[1] = Lit101;
        arrobject[2] = Lit100;
        arrobject[3] = Lit102;
        arrobject[4] = Lit99;
        arrobject[5] = Lit104;
        arrobject[6] = Symbol.valueOf("and");
        Lit12 = Symbol.valueOf("null-list?");
        arrobject[7] = PairWithPosition.make(Lit12, Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668876);
        arrobject[8] = PairWithPosition.make(Lit100, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668900);
        arrobject[9] = PairWithPosition.make(PairWithPosition.make(Lit101, PairWithPosition.make(PairWithPosition.make(Lit102, Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668910), PairWithPosition.make(PairWithPosition.make(Lit104, Lit103, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668921), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668921), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668906), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/srfi1.scm", 5668906);
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit98, 2, "srfi1.scm:1382"), "\u0001\u0001", "\u0011\u0018\u0004\u0011\u0018\f\u00a1I\u0011\u0018\u0014\b\u0011\u0018\u001c\b\u000b\b\u0011\u0018$\b\u0011\u0018,\b\u000b\b\u0011\u00184\u0011\u0018<!\t\u0003\u0018D\u0018L", arrobject, 0);
        Lit82 = Symbol.valueOf("%every");
        Lit83 = new SyntaxRules(Lit98, arrsyntaxRule, 2, Lit82);
        Lit81 = Symbol.valueOf("every");
        Lit80 = Symbol.valueOf("any");
        Lit79 = Symbol.valueOf("break!");
        Lit78 = Symbol.valueOf("break");
        Lit77 = Symbol.valueOf("span!");
        Lit76 = Symbol.valueOf("span");
        Lit75 = Symbol.valueOf("take-while!");
        Lit74 = Symbol.valueOf("drop-while");
        Lit73 = Symbol.valueOf("take-while");
        Lit72 = Symbol.valueOf("find-tail");
        Lit71 = Symbol.valueOf("find");
        Lit70 = Symbol.valueOf("alist-delete!");
        Lit69 = Symbol.valueOf("alist-delete");
        Lit68 = Symbol.valueOf("alist-copy");
        Lit67 = Symbol.valueOf("alist-cons");
        Lit66 = Symbol.valueOf("delete-duplicates!");
        Lit65 = Symbol.valueOf("delete-duplicates");
        Lit64 = Symbol.valueOf("delete!");
        Lit63 = Symbol.valueOf("delete");
        Lit62 = Symbol.valueOf("remove!");
        Lit61 = Symbol.valueOf("remove");
        Lit60 = Symbol.valueOf("partition!");
        Lit59 = Symbol.valueOf("partition");
        Lit58 = Symbol.valueOf("filter!");
        Lit57 = Symbol.valueOf("filter");
        Lit56 = Symbol.valueOf("filter-map");
        Lit55 = Symbol.valueOf("map!");
        Lit54 = Symbol.valueOf("pair-for-each");
        Lit53 = Symbol.valueOf("append-map!");
        Lit52 = Symbol.valueOf("append-map");
        Lit51 = Symbol.valueOf("reduce-right");
        Lit50 = Symbol.valueOf("reduce");
        Lit49 = Symbol.valueOf("pair-fold");
        Lit48 = Symbol.valueOf("pair-fold-right");
        Lit47 = Symbol.valueOf("fold-right");
        Lit46 = Symbol.valueOf("fold");
        Lit45 = Symbol.valueOf("unfold");
        Lit44 = Symbol.valueOf("unfold-right");
        Lit43 = Symbol.valueOf("count");
        Lit42 = Symbol.valueOf("concatenate!");
        Lit41 = Symbol.valueOf("concatenate");
        Lit40 = Symbol.valueOf("append-reverse!");
        Lit39 = Symbol.valueOf("append-reverse");
        Lit38 = Symbol.valueOf("append!");
        Lit37 = Symbol.valueOf("unzip5");
        Lit36 = Symbol.valueOf("unzip4");
        Lit35 = Symbol.valueOf("unzip3");
        Lit34 = Symbol.valueOf("unzip2");
        Lit33 = Symbol.valueOf("unzip1");
        Lit32 = Symbol.valueOf("last-pair");
        Lit31 = Symbol.valueOf("last");
        Lit30 = Symbol.valueOf("split-at!");
        Lit29 = Symbol.valueOf("split-at");
        Lit28 = Symbol.valueOf("drop-right!");
        Lit27 = Symbol.valueOf("drop-right");
        Lit26 = Symbol.valueOf("take-right");
        Lit25 = Symbol.valueOf("take!");
        Lit24 = Symbol.valueOf("drop");
        Lit23 = Symbol.valueOf("take");
        Lit22 = Symbol.valueOf("car+cdr");
        Lit21 = Symbol.valueOf("tenth");
        Lit20 = Symbol.valueOf("ninth");
        Lit19 = Symbol.valueOf("eighth");
        Lit18 = Symbol.valueOf("seventh");
        Lit17 = Symbol.valueOf("sixth");
        Lit16 = Symbol.valueOf("fifth");
        Lit15 = Symbol.valueOf("zip");
        Lit14 = Symbol.valueOf("length+");
        Lit13 = Symbol.valueOf("list=");
        Lit11 = Symbol.valueOf("not-pair?");
        Lit10 = Symbol.valueOf("circular-list?");
        Lit9 = Symbol.valueOf("dotted-list?");
        Lit8 = Symbol.valueOf("proper-list?");
        Lit7 = Symbol.valueOf("circular-list");
        Lit6 = Symbol.valueOf("iota");
        Lit5 = Symbol.valueOf("cons*");
        Lit4 = Symbol.valueOf("list-tabulate");
        Lit3 = Symbol.valueOf("xcons");
        Lit2 = Symbol.valueOf("tmp");
        Lit1 = IntNum.valueOf(1);
        Lit0 = IntNum.valueOf(0);
        srfi1 srfi12 = $instance = new srfi1();
        xcons = new ModuleMethod(srfi12, 34, Lit3, 8194);
        list$Mntabulate = new ModuleMethod(srfi12, 35, Lit4, 8194);
        cons$St = new ModuleMethod(srfi12, 36, Lit5, -4096);
        iota = new ModuleMethod(srfi12, 37, Lit6, 12289);
        circular$Mnlist = new ModuleMethod(srfi12, 40, Lit7, -4095);
        proper$Mnlist$Qu = new ModuleMethod(srfi12, 41, Lit8, 4097);
        dotted$Mnlist$Qu = new ModuleMethod(srfi12, 42, Lit9, 4097);
        circular$Mnlist$Qu = new ModuleMethod(srfi12, 43, Lit10, 4097);
        not$Mnpair$Qu = new ModuleMethod(srfi12, 44, Lit11, 4097);
        null$Mnlist$Qu = new ModuleMethod(srfi12, 45, Lit12, 4097);
        list$Eq = new ModuleMethod(srfi12, 46, Lit13, -4095);
        length$Pl = new ModuleMethod(srfi12, 47, Lit14, 4097);
        zip = new ModuleMethod(srfi12, 48, Lit15, -4095);
        fifth = new ModuleMethod(srfi12, 49, Lit16, 4097);
        sixth = new ModuleMethod(srfi12, 50, Lit17, 4097);
        seventh = new ModuleMethod(srfi12, 51, Lit18, 4097);
        eighth = new ModuleMethod(srfi12, 52, Lit19, 4097);
        ninth = new ModuleMethod(srfi12, 53, Lit20, 4097);
        tenth = new ModuleMethod(srfi12, 54, Lit21, 4097);
        car$Plcdr = new ModuleMethod(srfi12, 55, Lit22, 4097);
        take = new ModuleMethod(srfi12, 56, Lit23, 8194);
        drop = new ModuleMethod(srfi12, 57, Lit24, 8194);
        take$Ex = new ModuleMethod(srfi12, 58, Lit25, 8194);
        take$Mnright = new ModuleMethod(srfi12, 59, Lit26, 8194);
        drop$Mnright = new ModuleMethod(srfi12, 60, Lit27, 8194);
        drop$Mnright$Ex = new ModuleMethod(srfi12, 61, Lit28, 8194);
        split$Mnat = new ModuleMethod(srfi12, 62, Lit29, 8194);
        split$Mnat$Ex = new ModuleMethod(srfi12, 63, Lit30, 8194);
        last = new ModuleMethod(srfi12, 64, Lit31, 4097);
        last$Mnpair = new ModuleMethod(srfi12, 65, Lit32, 4097);
        unzip1 = new ModuleMethod(srfi12, 66, Lit33, 4097);
        unzip2 = new ModuleMethod(srfi12, 67, Lit34, 4097);
        unzip3 = new ModuleMethod(srfi12, 68, Lit35, 4097);
        unzip4 = new ModuleMethod(srfi12, 69, Lit36, 4097);
        unzip5 = new ModuleMethod(srfi12, 70, Lit37, 4097);
        append$Ex = new ModuleMethod(srfi12, 71, Lit38, -4096);
        append$Mnreverse = new ModuleMethod(srfi12, 72, Lit39, 8194);
        append$Mnreverse$Ex = new ModuleMethod(srfi12, 73, Lit40, 8194);
        concatenate = new ModuleMethod(srfi12, 74, Lit41, 4097);
        concatenate$Ex = new ModuleMethod(srfi12, 75, Lit42, 4097);
        count = new ModuleMethod(srfi12, 76, Lit43, -4094);
        unfold$Mnright = new ModuleMethod(srfi12, 77, Lit44, 20484);
        unfold = new ModuleMethod(srfi12, 79, Lit45, -4092);
        fold = new ModuleMethod(srfi12, 80, Lit46, -4093);
        fold$Mnright = new ModuleMethod(srfi12, 81, Lit47, -4093);
        pair$Mnfold$Mnright = new ModuleMethod(srfi12, 82, Lit48, -4093);
        pair$Mnfold = new ModuleMethod(srfi12, 83, Lit49, -4093);
        reduce = new ModuleMethod(srfi12, 84, Lit50, 12291);
        reduce$Mnright = new ModuleMethod(srfi12, 85, Lit51, 12291);
        append$Mnmap = new ModuleMethod(srfi12, 86, Lit52, -4094);
        append$Mnmap$Ex = new ModuleMethod(srfi12, 87, Lit53, -4094);
        pair$Mnfor$Mneach = new ModuleMethod(srfi12, 88, Lit54, -4094);
        map$Ex = new ModuleMethod(srfi12, 89, Lit55, -4094);
        filter$Mnmap = new ModuleMethod(srfi12, 90, Lit56, -4094);
        filter = new ModuleMethod(srfi12, 91, Lit57, 8194);
        filter$Ex = new ModuleMethod(srfi12, 92, Lit58, 8194);
        partition = new ModuleMethod(srfi12, 93, Lit59, 8194);
        partition$Ex = new ModuleMethod(srfi12, 94, Lit60, 8194);
        remove = new ModuleMethod(srfi12, 95, Lit61, 8194);
        remove$Ex = new ModuleMethod(srfi12, 96, Lit62, 8194);
        delete = new ModuleMethod(srfi12, 97, Lit63, 12290);
        delete$Ex = new ModuleMethod(srfi12, 99, Lit64, 12290);
        delete$Mnduplicates = new ModuleMethod(srfi12, 101, Lit65, 8193);
        delete$Mnduplicates$Ex = new ModuleMethod(srfi12, 103, Lit66, 8193);
        alist$Mncons = new ModuleMethod(srfi12, 105, Lit67, 12291);
        alist$Mncopy = new ModuleMethod(srfi12, 106, Lit68, 4097);
        alist$Mndelete = new ModuleMethod(srfi12, 107, Lit69, 12290);
        alist$Mndelete$Ex = new ModuleMethod(srfi12, 109, Lit70, 12290);
        find = new ModuleMethod(srfi12, 111, Lit71, 8194);
        find$Mntail = new ModuleMethod(srfi12, 112, Lit72, 8194);
        take$Mnwhile = new ModuleMethod(srfi12, 113, Lit73, 8194);
        drop$Mnwhile = new ModuleMethod(srfi12, 114, Lit74, 8194);
        take$Mnwhile$Ex = new ModuleMethod(srfi12, 115, Lit75, 8194);
        span = new ModuleMethod(srfi12, 116, Lit76, 8194);
        span$Ex = new ModuleMethod(srfi12, 117, Lit77, 8194);
        break = new ModuleMethod(srfi12, 118, Lit78, 8194);
        break$Ex = new ModuleMethod(srfi12, 119, Lit79, 8194);
        any = new ModuleMethod(srfi12, 120, Lit80, -4094);
        every = new ModuleMethod(srfi12, 121, Lit81, -4094);
        $Pcevery = Macro.make(Lit82, Lit83, "gnu.kawa.slib.srfi1");
        list$Mnindex = new ModuleMethod(srfi12, 122, Lit84, -4094);
        lset$Ls$Eq = new ModuleMethod(srfi12, 123, Lit85, -4095);
        lset$Eq = new ModuleMethod(srfi12, 124, Lit86, -4095);
        lset$Mnadjoin = new ModuleMethod(srfi12, 125, Lit87, -4094);
        lset$Mnunion = new ModuleMethod(srfi12, 126, Lit88, -4095);
        lset$Mnunion$Ex = new ModuleMethod(srfi12, 127, Lit89, -4095);
        lset$Mnintersection = new ModuleMethod(srfi12, 128, Lit90, -4094);
        lset$Mnintersection$Ex = new ModuleMethod(srfi12, 129, Lit91, -4094);
        lset$Mndifference = new ModuleMethod(srfi12, 130, Lit92, -4094);
        lset$Mndifference$Ex = new ModuleMethod(srfi12, 131, Lit93, -4094);
        lset$Mnxor = new ModuleMethod(srfi12, 132, Lit94, -4095);
        lset$Mnxor$Ex = new ModuleMethod(srfi12, 133, Lit95, -4095);
        lset$Mndiff$Plintersection = new ModuleMethod(srfi12, 134, Lit96, -4094);
        lset$Mndiff$Plintersection$Ex = new ModuleMethod(srfi12, 135, Lit97, -4094);
        srfi1.$runBody$();
    }

    public srfi1() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 106: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 103: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 101: {
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
            case 74: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 70: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 69: {
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
            case 67: {
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
                Object object3 = Promise.force(object2, Pair.class);
                if (!(object3 instanceof Pair)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 64: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 55: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 54: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 53: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 52: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 51: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 50: {
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
            case 47: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 45: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 44: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 43: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 42: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 41: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 37: {
                Object object4 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 119: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 118: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 117: {
                Object object4 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object4) == null) {
                    return -786431;
                }
                callContext.value1 = object4;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 116: {
                Object object5 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 115: {
                Object object6 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 114: {
                Object object7 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 113: {
                Object object8 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object8) == null) {
                    return -786431;
                }
                callContext.value1 = object8;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 112: {
                Object object9 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object9) == null) {
                    return -786431;
                }
                callContext.value1 = object9;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 111: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 109: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 107: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 103: {
                callContext.value1 = object2;
                Object object10 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object10) == null) {
                    return -786430;
                }
                callContext.value2 = object10;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 101: {
                callContext.value1 = object2;
                Object object11 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object11) == null) {
                    return -786430;
                }
                callContext.value2 = object11;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 99: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 97: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 96: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 95: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 94: {
                Object object12 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object12) == null) {
                    return -786431;
                }
                callContext.value1 = object12;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 93: {
                Object object13 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object13) == null) {
                    return -786431;
                }
                callContext.value1 = object13;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 92: {
                Object object14 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object14) == null) {
                    return -786431;
                }
                callContext.value1 = object14;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 91: {
                Object object15 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object15) == null) {
                    return -786431;
                }
                callContext.value1 = object15;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 73: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 72: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 63: {
                callContext.value1 = object2;
                Object object16 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object16) == null) {
                    return -786430;
                }
                callContext.value2 = object16;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 62: {
                callContext.value1 = object2;
                Object object17 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object17) == null) {
                    return -786430;
                }
                callContext.value2 = object17;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 61: {
                callContext.value1 = object2;
                Object object18 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object18) == null) {
                    return -786430;
                }
                callContext.value2 = object18;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 60: {
                callContext.value1 = object2;
                Object object19 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object19) == null) {
                    return -786430;
                }
                callContext.value2 = object19;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 59: {
                callContext.value1 = object2;
                Object object20 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object20) == null) {
                    return -786430;
                }
                callContext.value2 = object20;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 58: {
                callContext.value1 = object2;
                Object object21 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object21) == null) {
                    return -786430;
                }
                callContext.value2 = object21;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 57: {
                callContext.value1 = object2;
                Object object22 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object22) == null) {
                    return -786430;
                }
                callContext.value2 = object22;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 56: {
                callContext.value1 = object2;
                Object object23 = Promise.force(object3, IntNum.class);
                if (IntNum.asIntNumOrNull(object23) == null) {
                    return -786430;
                }
                callContext.value2 = object23;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 37: {
                Object object24 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object24) == null) {
                    return -786431;
                }
                callContext.value1 = object24;
                Object object25 = Promise.force(object3, Numeric.class);
                if (Numeric.asNumericOrNull(object25) == null) {
                    return -786430;
                }
                callContext.value2 = object25;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 35: {
                callContext.value1 = object2;
                Object object26 = Promise.force(object3, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object26) == null) {
                    return -786430;
                }
                callContext.value2 = object26;
                callContext.proc = moduleMethod;
                callContext.pc = 2;
                return 0;
            }
            case 34: {
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
        switch (moduleMethod.selector) {
            case 109: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 107: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 105: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 99: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 97: {
                callContext.value1 = object2;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 85: {
                Object object5 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                    return -786431;
                }
                callContext.value1 = object5;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 84: {
                Object object6 = Promise.force(object2, Procedure.class);
                if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                    return -786431;
                }
                callContext.value1 = object6;
                callContext.value2 = object3;
                callContext.value3 = object4;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
            case 37: {
                Object object7 = Promise.force(object2, IntNum.class);
                if (IntNum.asIntNumOrNull(object7) == null) {
                    return -786431;
                }
                callContext.value1 = object7;
                Object object8 = Promise.force(object3, Numeric.class);
                if (Numeric.asNumericOrNull(object8) == null) {
                    return -786430;
                }
                callContext.value2 = object8;
                Object object9 = Promise.force(object4, Numeric.class);
                if (Numeric.asNumericOrNull(object9) == null) {
                    return -786429;
                }
                callContext.value3 = object9;
                callContext.proc = moduleMethod;
                callContext.pc = 3;
                return 0;
            }
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int match4(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, Object object5, CallContext callContext) {
        if (moduleMethod.selector == 77) {
            Object object6 = Promise.force(object2, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                return -786431;
            }
            callContext.value1 = object6;
            Object object7 = Promise.force(object3, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object7) == null) {
                return -786430;
            }
            callContext.value2 = object7;
            Object object8 = Promise.force(object4, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object8) == null) {
                return -786429;
            }
            callContext.value3 = object8;
            callContext.value4 = object5;
            callContext.proc = moduleMethod;
            callContext.pc = 4;
            return 0;
        }
        return super.match4(moduleMethod, object2, object3, object4, object5, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 135: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 134: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 133: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 132: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 131: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 130: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 129: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 128: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 127: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 126: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 125: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 124: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 123: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 122: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 121: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 120: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 90: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 89: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 88: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
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
            case 83: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 82: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 81: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 80: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 79: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 77: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 76: {
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
            case 48: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 46: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 40: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 36: {
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 37: {
                return srfi1.iota(LangObjType.coerceIntNum(Promise.force(object2, IntNum.class)));
            }
            case 41: {
                return srfi1.isProperList(object2);
            }
            case 42: {
                return srfi1.isDottedList(object2);
            }
            case 43: {
                return srfi1.isCircularList(object2);
            }
            case 44: {
                Boolean bl;
                if (srfi1.isNotPair(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 45: {
                Boolean bl;
                if (srfi1.isNullList(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 47: {
                return srfi1.length$Pl(object2);
            }
            case 49: {
                return srfi1.fifth(object2);
            }
            case 50: {
                return srfi1.sixth(object2);
            }
            case 51: {
                return srfi1.seventh(object2);
            }
            case 52: {
                return srfi1.eighth(object2);
            }
            case 53: {
                return srfi1.ninth(object2);
            }
            case 54: {
                return srfi1.tenth(object2);
            }
            case 55: {
                return srfi1.car$PlCdr(object2);
            }
            case 64: {
                return srfi1.last(object2);
            }
            case 65: {
                return srfi1.lastPair((Pair)Promise.force(object2, Pair.class));
            }
            case 66: {
                return srfi1.unzip1(object2);
            }
            case 67: {
                return srfi1.unzip2(object2);
            }
            case 68: {
                return srfi1.unzip3(object2);
            }
            case 69: {
                return srfi1.unzip4(object2);
            }
            case 70: {
                return srfi1.unzip5(object2);
            }
            case 74: {
                return srfi1.concatenate(object2);
            }
            case 75: {
                return srfi1.concatenate$Ex(object2);
            }
            case 101: {
                return srfi1.deleteDuplicates(object2);
            }
            case 103: {
                return srfi1.deleteDuplicates$Ex(object2);
            }
            case 106: {
                return srfi1.alistCopy(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "iota", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "last-pair", 1, object2);
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

    /*
     * Exception decompiling
     */
    public Object apply3(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4) {
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

    /*
     * Exception decompiling
     */
    public Object apply4(ModuleMethod var1_1, Object var2_2, Object var3_3, Object var4_4, Object var5_5) {
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        Object object2;
        switch (moduleMethod.selector) {
            case 36: {
                return srfi1.cons$St(arrobject);
            }
            case 40: {
                int n = arrobject.length - 1;
                Object[] arrobject2 = new Object[n];
                do {
                    if (--n < 0) {
                        return srfi1.circularList$V(arrobject[0], arrobject2);
                    }
                    arrobject2 = arrobject2;
                    arrobject2[n] = arrobject[n + 1];
                } while (true);
            }
            case 46: {
                int n = arrobject.length - 1;
                Object[] arrobject3 = new Object[n];
                do {
                    if (--n < 0) {
                        return srfi1.list$Eq$V(arrobject[0], arrobject3);
                    }
                    arrobject3 = arrobject3;
                    arrobject3[n] = arrobject[n + 1];
                } while (true);
            }
            case 48: {
                int n = arrobject.length - 1;
                Object[] arrobject4 = new Object[n];
                do {
                    if (--n < 0) {
                        return srfi1.zip$V(arrobject[0], arrobject4);
                    }
                    arrobject4 = arrobject4;
                    arrobject4[n] = arrobject[n + 1];
                } while (true);
            }
            case 71: {
                return srfi1.append$Ex$V(arrobject);
            }
            case 76: {
                Object object3 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject5 = new Object[n];
                while (--n >= 0) {
                    arrobject5 = arrobject5;
                    arrobject5[n] = arrobject[n + 2];
                }
                return srfi1.count$V(LangObjType.coerceToProcedure(object3), arrobject[1], arrobject5);
            }
            case 77: {
                Object object3;
                int n = arrobject.length - 4;
                object2 = Promise.force(arrobject[0], Procedure.class);
                Procedure procedure = LangObjType.coerceToProcedure(object2);
                object2 = Promise.force(arrobject[1], Procedure.class);
                Procedure procedure2 = LangObjType.coerceToProcedure(object2);
                object2 = Promise.force(arrobject[2], Procedure.class);
                Procedure procedure3 = LangObjType.coerceToProcedure(object2);
                Object object4 = arrobject[3];
                if (n <= 0) {
                    object3 = srfi1.unfoldRight(procedure, procedure2, procedure3, object4);
                    return object3;
                }
                --n;
                object3 = srfi1.unfoldRight(procedure, procedure2, procedure3, object4, arrobject[4]);
                return object3;
            }
            case 79: {
                Object object5 = Promise.force(arrobject[0], Procedure.class);
                Object object7 = object5;
                Object object6 = Promise.force(arrobject[1], Procedure.class);
                object7 = object6;
                object7 = Promise.force(arrobject[2], Procedure.class);
                int n = arrobject.length - 4;
                Object[] arrobject6 = new Object[n];
                while (--n >= 0) {
                    arrobject6 = arrobject6;
                    arrobject6[n] = arrobject[n + 4];
                }
                return srfi1.unfold$V(LangObjType.coerceToProcedure(object5), LangObjType.coerceToProcedure(object6), LangObjType.coerceToProcedure(object7), arrobject[3], arrobject6);
            }
            case 80: {
                Object object9 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 3;
                Object[] arrobject7 = new Object[n];
                while (--n >= 0) {
                    arrobject7 = arrobject7;
                    arrobject7[n] = arrobject[n + 3];
                }
                return srfi1.fold$V(LangObjType.coerceToProcedure(object9), arrobject[1], arrobject[2], arrobject7);
            }
            case 81: {
                Object object10 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 3;
                Object[] arrobject8 = new Object[n];
                while (--n >= 0) {
                    arrobject8 = arrobject8;
                    arrobject8[n] = arrobject[n + 3];
                }
                return srfi1.foldRight$V(LangObjType.coerceToProcedure(object10), arrobject[1], arrobject[2], arrobject8);
            }
            case 82: {
                Object object11 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 3;
                Object[] arrobject9 = new Object[n];
                while (--n >= 0) {
                    arrobject9 = arrobject9;
                    arrobject9[n] = arrobject[n + 3];
                }
                return srfi1.pairFoldRight$V(LangObjType.coerceToProcedure(object11), arrobject[1], arrobject[2], arrobject9);
            }
            case 83: {
                Object object12 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 3;
                Object[] arrobject10 = new Object[n];
                while (--n >= 0) {
                    arrobject10 = arrobject10;
                    arrobject10[n] = arrobject[n + 3];
                }
                return srfi1.pairFold$V(LangObjType.coerceToProcedure(object12), arrobject[1], arrobject[2], arrobject10);
            }
            case 86: {
                int n = arrobject.length - 2;
                Object[] arrobject11 = new Object[n];
                do {
                    if (--n < 0) {
                        return srfi1.appendMap$V(arrobject[0], arrobject[1], arrobject11);
                    }
                    arrobject11 = arrobject11;
                    arrobject11[n] = arrobject[n + 2];
                } while (true);
            }
            case 87: {
                int n = arrobject.length - 2;
                Object[] arrobject12 = new Object[n];
                do {
                    if (--n < 0) {
                        return srfi1.appendMap$Ex$V(arrobject[0], arrobject[1], arrobject12);
                    }
                    arrobject12 = arrobject12;
                    arrobject12[n] = arrobject[n + 2];
                } while (true);
            }
            case 88: {
                Object object13 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject13 = new Object[n];
                while (--n >= 0) {
                    arrobject13 = arrobject13;
                    arrobject13[n] = arrobject[n + 2];
                }
                return srfi1.pairForEach$V(LangObjType.coerceToProcedure(object13), arrobject[1], arrobject13);
            }
            case 89: {
                Object object14 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject14 = new Object[n];
                while (--n >= 0) {
                    arrobject14 = arrobject14;
                    arrobject14[n] = arrobject[n + 2];
                }
                return srfi1.map$Ex$V(LangObjType.coerceToProcedure(object14), arrobject[1], arrobject14);
            }
            case 90: {
                Object object15 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject15 = new Object[n];
                while (--n >= 0) {
                    arrobject15 = arrobject15;
                    arrobject15[n] = arrobject[n + 2];
                }
                return srfi1.filterMap$V(LangObjType.coerceToProcedure(object15), arrobject[1], arrobject15);
            }
            case 120: {
                Object object16 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject16 = new Object[n];
                while (--n >= 0) {
                    arrobject16 = arrobject16;
                    arrobject16[n] = arrobject[n + 2];
                }
                return srfi1.any$V(LangObjType.coerceToProcedure(object16), arrobject[1], arrobject16);
            }
            case 121: {
                Object object17 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject17 = new Object[n];
                while (--n >= 0) {
                    arrobject17 = arrobject17;
                    arrobject17[n] = arrobject[n + 2];
                }
                return srfi1.every$V(LangObjType.coerceToProcedure(object17), arrobject[1], arrobject17);
            }
            case 122: {
                Object object18 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject18 = new Object[n];
                while (--n >= 0) {
                    arrobject18 = arrobject18;
                    arrobject18[n] = arrobject[n + 2];
                }
                return srfi1.listIndex$V(LangObjType.coerceToProcedure(object18), arrobject[1], arrobject18);
            }
            case 123: {
                Object object19 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 1;
                Object[] arrobject19 = new Object[n];
                while (--n >= 0) {
                    arrobject19 = arrobject19;
                    arrobject19[n] = arrobject[n + 1];
                }
                return srfi1.lset$Ls$Eq$V(LangObjType.coerceToProcedure(object19), arrobject19);
            }
            case 124: {
                Object object20 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 1;
                Object[] arrobject20 = new Object[n];
                while (--n >= 0) {
                    arrobject20 = arrobject20;
                    arrobject20[n] = arrobject[n + 1];
                }
                return srfi1.lset$Eq$V(LangObjType.coerceToProcedure(object20), arrobject20);
            }
            case 125: {
                Object object21 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject21 = new Object[n];
                while (--n >= 0) {
                    arrobject21 = arrobject21;
                    arrobject21[n] = arrobject[n + 2];
                }
                return srfi1.lsetAdjoin$V(LangObjType.coerceToProcedure(object21), arrobject[1], arrobject21);
            }
            case 126: {
                Object object22 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 1;
                Object[] arrobject22 = new Object[n];
                while (--n >= 0) {
                    arrobject22 = arrobject22;
                    arrobject22[n] = arrobject[n + 1];
                }
                return srfi1.lsetUnion$V(LangObjType.coerceToProcedure(object22), arrobject22);
            }
            case 127: {
                Object object23 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 1;
                Object[] arrobject23 = new Object[n];
                while (--n >= 0) {
                    arrobject23 = arrobject23;
                    arrobject23[n] = arrobject[n + 1];
                }
                return srfi1.lsetUnion$Ex$V(LangObjType.coerceToProcedure(object23), arrobject23);
            }
            case 128: {
                Object object24 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject24 = new Object[n];
                while (--n >= 0) {
                    arrobject24 = arrobject24;
                    arrobject24[n] = arrobject[n + 2];
                }
                return srfi1.lsetIntersection$V(LangObjType.coerceToProcedure(object24), arrobject[1], arrobject24);
            }
            case 129: {
                Object object25 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject25 = new Object[n];
                while (--n >= 0) {
                    arrobject25 = arrobject25;
                    arrobject25[n] = arrobject[n + 2];
                }
                return srfi1.lsetIntersection$Ex$V(LangObjType.coerceToProcedure(object25), arrobject[1], arrobject25);
            }
            case 130: {
                Object object26 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject26 = new Object[n];
                while (--n >= 0) {
                    arrobject26 = arrobject26;
                    arrobject26[n] = arrobject[n + 2];
                }
                return srfi1.lsetDifference$V(LangObjType.coerceToProcedure(object26), arrobject[1], arrobject26);
            }
            case 131: {
                Object object27 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject27 = new Object[n];
                while (--n >= 0) {
                    arrobject27 = arrobject27;
                    arrobject27[n] = arrobject[n + 2];
                }
                return srfi1.lsetDifference$Ex$V(LangObjType.coerceToProcedure(object27), arrobject[1], arrobject27);
            }
            case 132: {
                Object object28 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 1;
                Object[] arrobject28 = new Object[n];
                while (--n >= 0) {
                    arrobject28 = arrobject28;
                    arrobject28[n] = arrobject[n + 1];
                }
                return srfi1.lsetXor$V(LangObjType.coerceToProcedure(object28), arrobject28);
            }
            case 133: {
                Object object29 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 1;
                Object[] arrobject29 = new Object[n];
                while (--n >= 0) {
                    arrobject29 = arrobject29;
                    arrobject29[n] = arrobject[n + 1];
                }
                return srfi1.lsetXor$Ex$V(LangObjType.coerceToProcedure(object29), arrobject29);
            }
            case 134: {
                Object object30 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject30 = new Object[n];
                while (--n >= 0) {
                    arrobject30 = arrobject30;
                    arrobject30[n] = arrobject[n + 2];
                }
                return srfi1.lsetDiff$PlIntersection$V(LangObjType.coerceToProcedure(object30), arrobject[1], arrobject30);
            }
            case 135: {
                Object object31 = Promise.force(arrobject[0], Procedure.class);
                int n = arrobject.length - 2;
                Object[] arrobject31 = new Object[n];
                while (--n >= 0) {
                    arrobject31 = arrobject31;
                    arrobject31[n] = arrobject[n + 2];
                }
                return srfi1.lsetDiff$PlIntersection$Ex$V(LangObjType.coerceToProcedure(object31), arrobject[1], arrobject31);
            }
        }
        return super.applyN(moduleMethod, arrobject);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unfold-right", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unfold-right", 2, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "unfold-right", 3, object2);
        }
    }

}

