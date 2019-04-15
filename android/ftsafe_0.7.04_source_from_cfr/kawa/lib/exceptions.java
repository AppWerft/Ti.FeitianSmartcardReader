/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.bytecode.Type;
import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.reflect.Throw;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;
import kawa.lang.GenericError;
import kawa.lang.Macro;
import kawa.lang.NamedException;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.ExceptionClasses;
import kawa.lib.ExceptionWithValue;
import kawa.lib.HandlerLink;
import kawa.lib.misc;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class exceptions
extends ModuleBody {
    public static final StaticFieldLocation $Prvt$current$Mnhandler;
    public static final StaticFieldLocation $Prvt$ExceptionWithValue;
    public static final StaticFieldLocation $Prvt$or;
    public static final StaticFieldLocation $Prvt$let;
    public static final StaticFieldLocation $Prvt$try$Mnfinally;
    public static final StaticFieldLocation $Prvt$if;
    public static final StaticFieldLocation $Prvt$try$Mncatch;
    public static final StaticFieldLocation $Prvt$begin;
    public static final StaticFieldLocation $Prvt$quasiquote;
    public static final StaticFieldLocation $Prvt$primitive$Mnthrow;
    public static final GenericProc with$Mnexception$Mnhandler;
    public static final ModuleMethod raise;
    public static final ModuleMethod raise$Mncontinuable;
    public static final Macro guard;
    public static final Macro guard$Mnaux;
    public static final ModuleMethod throw;
    public static final ModuleMethod error;
    public static final ModuleMethod catch;
    public static final ModuleMethod error$Mnobject$Qu;
    public static final ModuleMethod error$Mnobject$Mnmessage;
    public static final ModuleMethod error$Mnobject$Mnirritants;
    public static final ModuleMethod read$Mnerror$Qu;
    public static final ModuleMethod file$Mnerror$Qu;
    static final Keyword Lit0;
    public static exceptions $instance;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SyntaxRules Lit4;
    static final SimpleSymbol Lit5;
    static final SyntaxRules Lit6;
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
    static final Object[] Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit20;
    static final PairWithPosition Lit21;
    static final Object[] Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final PairWithPosition Lit28;
    static final PairWithPosition Lit29;
    static final PairWithPosition Lit30;
    static final SimpleSymbol Lit31;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        with$Mnexception$Mnhandler.setProperty(Lit0, "gnu.kawa.functions.CompileMisc:validateApplyWithExceptionHandler");
    }

    public static Type.NeverReturns raise(Object obj) {
        throw ExceptionWithValue.wrap(obj);
    }

    public static Object raiseContinuable(Object obj) {
        Object object2;
        HandlerLink save = ExceptionClasses.current$Mnhandler.get();
        if (save == null) {
            Type.NeverReturns neverReturns = exceptions.raise(obj);
            throw Special.reachedUnexpected;
        }
        try {
            ExceptionClasses.current$Mnhandler.set(save.outer);
            object2 = save.handlerProc.apply1(obj);
            Object var4_3 = null;
            ExceptionClasses.current$Mnhandler.set(save);
        }
        catch (Throwable throwable) {
            Object var4_4 = null;
            ExceptionClasses.current$Mnhandler.set(save);
            throw throwable;
        }
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static /* varargs */ Type.NeverReturns throw(Object ... args) {
        int len = args.length;
        if (len <= 0) throw new GenericError("bad arguments to throw");
        Object key = args[0];
        if (!misc.isSymbol(key)) {
            if (!(key instanceof Throwable)) throw new GenericError("bad arguments to throw");
            if (len != 1) throw new GenericError("bad arguments to throw");
            Throw.doThrow(key);
            throw new GenericError("bad arguments to throw");
        }
        Object object2 = Promise.force(key, Symbol.class);
        try {
            throw new NamedException((Symbol)object2, args);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "kawa.lang.NamedException.<init>(gnu.mapping.Symbol,java.lang.Object[])", 1, object2);
        }
    }

    public static /* varargs */ Type.NeverReturns error(Object ... args) {
        throw NamedException.makeError(args);
    }

    public static Object catch(Object key, Procedure thunk, Procedure handler) {
        Object object2;
        try {
            object2 = thunk.apply0();
        }
        catch (NamedException ex) {
            object2 = ex.applyHandler(key, handler);
        }
        return object2;
    }

    public static boolean isErrorObject(Object obj) {
        return obj instanceof NamedException;
    }

    public static Object errorObjectMessage(NamedException err) {
        return err.getObjectMessage();
    }

    public static LList errorObjectIrritants(NamedException err) {
        return err.getObjectIrritants();
    }

    public static boolean isReadError(Object obj) {
        return obj instanceof SyntaxException;
    }

    public static boolean isFileError(Object obj) {
        boolean x = obj instanceof FileNotFoundException;
        return x ? x : (obj instanceof IOException ? ((IOException)Promise.force(obj, IOException.class)).getMessage().startsWith("cannot delete") : false);
    }

    public static {
        Lit31 = Symbol.valueOf("save");
        Lit24 = Symbol.valueOf("$lookup$");
        Lit25 = Symbol.valueOf("current-handler");
        Lit26 = Symbol.valueOf("quasiquote");
        Lit30 = PairWithPosition.make(Lit24, Pair.make(Lit25, Pair.make(Pair.make(Lit26, Pair.make(Symbol.valueOf("set"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200717);
        Lit27 = Symbol.valueOf("ex");
        Lit28 = PairWithPosition.make(Lit27, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213023);
        Lit29 = PairWithPosition.make(Symbol.valueOf("primitive-throw"), Lit28, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213006);
        Lit23 = Symbol.valueOf("begin");
        Lit22 = new Object[0];
        Lit17 = Symbol.valueOf("temp");
        Lit21 = PairWithPosition.make(Lit17, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 274452);
        Lit20 = Symbol.valueOf("if");
        Lit19 = Symbol.valueOf("let");
        Object[] arrobject = new Object[1];
        Lit18 = arrobject;
        Lit16 = Symbol.valueOf("=>");
        arrobject[0] = Lit16;
        Lit15 = Symbol.valueOf("else");
        Lit14 = Symbol.valueOf("file-error?");
        Lit13 = Symbol.valueOf("read-error?");
        Lit12 = Symbol.valueOf("error-object-irritants");
        Lit11 = Symbol.valueOf("error-object-message");
        Lit10 = Symbol.valueOf("error-object?");
        Lit9 = Symbol.valueOf("catch");
        Lit8 = Symbol.valueOf("error");
        Lit7 = Symbol.valueOf("throw");
        SyntaxRule[] arrsyntaxRule = new SyntaxRule[7];
        arrsyntaxRule[0] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u0002\f\u000f\r\u0017\u0010\b\b\b", new Object[]{Lit15}, 3, "exceptions.scm:62"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0015\u0013", new Object[]{Lit23}, 1);
        arrsyntaxRule[1] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\b", Lit18, 3, "exceptions.scm:64"), "\u0001\u0001\u0001", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0003", new Object[]{Lit19, Lit17, Lit20, Lit21}, 0);
        Object[] arrobject2 = new Object[5];
        arrobject2[0] = Lit19;
        arrobject2[1] = Lit17;
        arrobject2[2] = Lit20;
        arrobject2[3] = Lit21;
        Lit5 = Symbol.valueOf("guard-aux");
        arrobject2[4] = Lit5;
        arrsyntaxRule[2] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\f\u001f\r' \b\b", Lit18, 5, "exceptions.scm:69"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0011\u0018$\t\u0003\t\u001b\b%#", arrobject2, 1);
        arrsyntaxRule[3] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\b", Lit22, 2, "exceptions.scm:75"), "\u0001\u0001", "\u0011\u0018\u0004\t\u000b\b\u0003", new Object[]{Symbol.valueOf("or")}, 0);
        arrsyntaxRule[4] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\f\u0017\r\u001f\u0018\b\b", Lit22, 4, "exceptions.scm:77"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f\u0011\u0018\f\b\u0011\u0018\u001c\t\u0003\t\u0013\b\u001d\u001b", new Object[]{Lit19, Lit17, Lit20, Lit5}, 1);
        arrsyntaxRule[5] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\b", Lit22, 4, "exceptions.scm:82"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0003", new Object[]{Lit20, Lit23}, 1);
        arrsyntaxRule[6] = new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\f'\r/(\b\b", Lit22, 6, "exceptions.scm:86"), "\u0001\u0001\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0011\u0018\u0014\t\u0003\t#\b-+", new Object[]{Lit20, Lit23, Lit5}, 1);
        Lit6 = new SyntaxRules(new Object[]{Lit15, Lit16}, arrsyntaxRule, 6, Lit5);
        Lit3 = Symbol.valueOf("guard");
        Lit4 = new SyntaxRules(Lit22, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\r\u000f\b\b\b\f\u0017\r\u001f\u0018\b\b", Lit22, 4, "exceptions.scm:44"), "\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\u0169\u0011\u0018\u001cY\u0011\u0018$\u0011\u0018,\t\u0013\b\u001d\u001b\u0011\u00184\b\u0011\u0018<\u0011\u0018D\b\u0011\u0018\u0004)\b\t\u0003\u0018L\b\u0011\u0018T\u0011\u0018\\\b\r\u000b\u0018d", new Object[]{Lit19, PairWithPosition.make(PairWithPosition.make(Lit31, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit24, Pair.make(Lit25, Pair.make(Pair.make(Lit26, Pair.make(Symbol.valueOf("get"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184339), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184338), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184338), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184332), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184331), Symbol.valueOf("try-finally"), Symbol.valueOf("try-catch"), Lit23, PairWithPosition.make(Lit30, PairWithPosition.make(null, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200737), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200716), PairWithPosition.make(Lit27, PairWithPosition.make(Symbol.valueOf("gnu.kawa.util.ExitCalled"), PairWithPosition.make(Lit29, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213006), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 208910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 208906), Lit27, Symbol.valueOf("java.lang.Throwable"), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(Lit24, Pair.make(Symbol.valueOf("ExceptionWithValue"), Pair.make(Pair.make(Lit26, Pair.make(Symbol.valueOf("unwrap"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221210), Lit28, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221209), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221209), Lit5, Lit29, PairWithPosition.make(PairWithPosition.make(Lit30, PairWithPosition.make(Lit31, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237598), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237577), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237577)}, 1)}, 4, Lit3);
        Lit2 = Symbol.valueOf("raise-continuable");
        Lit1 = Symbol.valueOf("raise");
        Lit0 = Keyword.make("validate-apply");
        $instance = new exceptions();
        $Prvt$current$Mnhandler = StaticFieldLocation.make("kawa.lib.ExceptionClasses", "current$Mnhandler");
        $Prvt$ExceptionWithValue = StaticFieldLocation.make("kawa.lib.ExceptionClasses", "ExceptionWithValue");
        $Prvt$or = StaticFieldLocation.make("kawa.lib.std_syntax", "or");
        $Prvt$let = StaticFieldLocation.make("kawa.lib.std_syntax", "let");
        $Prvt$try$Mnfinally = StaticFieldLocation.make("kawa.lib.syntax", "try$Mnfinally");
        $Prvt$if = StaticFieldLocation.make("kawa.lib.prim_syntax", "if");
        $Prvt$try$Mncatch = StaticFieldLocation.make("kawa.lib.prim_syntax", "try$Mncatch");
        $Prvt$begin = StaticFieldLocation.make("kawa.standard.begin", "begin");
        $Prvt$quasiquote = StaticFieldLocation.make("kawa.lang.Quote", "quasiQuote");
        $Prvt$primitive$Mnthrow = StaticFieldLocation.make("gnu.kawa.reflect.Throw", "primitiveThrow");
        GenericProc genericProc = new GenericProc("with-exception-handler");
        exceptions $instance = exceptions.$instance;
        ModuleMethod moduleMethod = new ModuleMethod($instance, 1, "with-exception-handler", 8194);
        moduleMethod.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm:12");
        genericProc.add(moduleMethod);
        with$Mnexception$Mnhandler = genericProc;
        exceptions exceptions2 = exceptions.$instance;
        ModuleMethod moduleMethod2 = new ModuleMethod(exceptions2, 2, Lit1, 4097);
        moduleMethod2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:raiseValidateApply");
        raise = moduleMethod2;
        raise$Mncontinuable = new ModuleMethod(exceptions2, 3, Lit2, 4097);
        guard = Macro.make(Lit3, Lit4, "kawa.lib.exceptions");
        guard$Mnaux = Macro.make(Lit5, Lit6, "kawa.lib.exceptions");
        throw = new ModuleMethod(exceptions2, 4, Lit7, -4096);
        error = new ModuleMethod(exceptions2, 5, Lit8, -4096);
        catch = new ModuleMethod(exceptions2, 6, Lit9, 12291);
        error$Mnobject$Qu = new ModuleMethod(exceptions2, 7, Lit10, 4097);
        error$Mnobject$Mnmessage = new ModuleMethod(exceptions2, 8, Lit11, 4097);
        error$Mnobject$Mnirritants = new ModuleMethod(exceptions2, 9, Lit12, 4097);
        read$Mnerror$Qu = new ModuleMethod(exceptions2, 10, Lit13, 4097);
        file$Mnerror$Qu = new ModuleMethod(exceptions2, 11, Lit14, 4097);
        exceptions.$runBody$();
    }

    public exceptions() {
        ModuleInfo.register(this);
    }

    public static Object withExceptionHandler(Procedure handler, Procedure thunk) {
        void var3_5;
        HandlerLink link = HandlerLink.push(handler);
        try {
            void ex;
            Object v = thunk.apply0();
            link.pop();
            var3_5 = ex;
        }
        catch (Throwable ex) {
            throw link.handle(ex);
        }
        return var3_5;
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 11: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 10: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 9: {
                Object object3 = Promise.force(object2, NamedException.class);
                if (!(object3 instanceof NamedException)) {
                    return -786431;
                }
                callContext.value1 = object3;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 8: {
                Object object4 = Promise.force(object2, NamedException.class);
                if (!(object4 instanceof NamedException)) {
                    return -786431;
                }
                callContext.value1 = object4;
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

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            Object object4 = Promise.force(object2, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object4) == null) {
                return -786431;
            }
            callContext.value1 = object4;
            Object object5 = Promise.force(object3, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                return -786430;
            }
            callContext.value2 = object5;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public int match3(ModuleMethod moduleMethod, Object object2, Object object3, Object object4, CallContext callContext) {
        if (moduleMethod.selector == 6) {
            callContext.value1 = object2;
            Object object5 = Promise.force(object3, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object5) == null) {
                return -786430;
            }
            callContext.value2 = object5;
            Object object6 = Promise.force(object4, Procedure.class);
            if (LangObjType.coerceToProcedureOrNull(object6) == null) {
                return -786429;
            }
            callContext.value3 = object6;
            callContext.proc = moduleMethod;
            callContext.pc = 3;
            return 0;
        }
        return super.match3(moduleMethod, object2, object3, object4, callContext);
    }

    public int matchN(ModuleMethod moduleMethod, Object[] arrobject, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 5: {
                callContext.values = arrobject;
                callContext.proc = moduleMethod;
                callContext.pc = 5;
                return 0;
            }
            case 4: {
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
            case 2: {
                return exceptions.raise(object2);
            }
            case 3: {
                return exceptions.raiseContinuable(object2);
            }
            case 7: {
                Boolean bl;
                if (exceptions.isErrorObject(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 8: {
                return exceptions.errorObjectMessage((NamedException)Promise.force(object2, NamedException.class));
            }
            case 9: {
                return exceptions.errorObjectIrritants((NamedException)Promise.force(object2, NamedException.class));
            }
            case 10: {
                Boolean bl;
                if (exceptions.isReadError(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
            case 11: {
                Boolean bl;
                if (exceptions.isFileError(object2)) {
                    bl = Boolean.TRUE;
                    return bl;
                }
                bl = Boolean.FALSE;
                return bl;
            }
        }
        return super.apply1(moduleMethod, object2);
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "error-object-message", 1, object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "error-object-irritants", 1, object2);
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

    public Object applyN(ModuleMethod moduleMethod, Object[] arrobject) {
        switch (moduleMethod.selector) {
            case 4: {
                return exceptions.throw(arrobject);
            }
            case 5: {
                return exceptions.error(arrobject);
            }
        }
        return super.applyN(moduleMethod, arrobject);
    }
}

