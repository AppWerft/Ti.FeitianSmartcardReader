// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.kawa.lispexpr.LangObjType;
import gnu.expr.ModuleInfo;
import gnu.mapping.MethodProc;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.lists.Pair;
import java.io.IOException;
import java.io.FileNotFoundException;
import gnu.text.SyntaxException;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import kawa.lang.GenericError;
import gnu.kawa.reflect.Throw;
import kawa.lang.NamedException;
import gnu.mapping.Promise;
import gnu.mapping.Symbol;
import gnu.expr.Special;
import gnu.bytecode.Type;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.expr.Keyword;
import kawa.lang.Macro;
import gnu.expr.ModuleMethod;
import gnu.expr.GenericProc;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class exceptions extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        exceptions.with$Mnexception$Mnhandler.setProperty(exceptions.Lit0, "gnu.kawa.functions.CompileMisc:validateApplyWithExceptionHandler");
    }
    
    public static Type.NeverReturns raise(final Object obj) {
        throw ExceptionWithValue.wrap(obj);
    }
    
    public static Object raiseContinuable(final Object obj) {
        final HandlerLink save = ExceptionClasses.current$Mnhandler.get();
        if (save == null) {
            raise(obj);
            throw Special.reachedUnexpected;
        }
        Object apply1;
        try {
            ExceptionClasses.current$Mnhandler.set(save.outer);
            apply1 = save.handlerProc.apply1(obj);
        }
        finally {
            ExceptionClasses.current$Mnhandler.set(save);
        }
        return apply1;
    }
    
    public static Type.NeverReturns throw(final Object... args) {
        final int len = args.length;
        Label_0057: {
            if (len <= 0) {
                break Label_0057;
            }
            final Object key = args[0];
            Label_0038: {
                if (!misc.isSymbol(key)) {
                    break Label_0038;
                }
                final Object force = Promise.force(key, Symbol.class);
                try {
                    throw new NamedException((Symbol)force, args);
                    while (true) {
                        Throw.doThrow(key);
                        throw new GenericError("bad arguments to throw");
                        continue;
                    }
                }
                // iftrue(Label_0057:, !key instanceof Throwable || len != 1)
                catch (ClassCastException ex) {
                    throw new WrongType(ex, "kawa.lang.NamedException.<init>(gnu.mapping.Symbol,java.lang.Object[])", 1, force);
                }
            }
        }
    }
    
    public static Type.NeverReturns error(final Object... args) {
        throw NamedException.makeError(args);
    }
    
    public static Object catch(final Object key, final Procedure thunk, final Procedure handler) {
        Object o;
        try {
            o = thunk.apply0();
        }
        catch (NamedException ex) {
            o = ex.applyHandler(key, handler);
        }
        return o;
    }
    
    public static boolean isErrorObject(final Object obj) {
        return obj instanceof NamedException;
    }
    
    public static Object errorObjectMessage(final NamedException err) {
        return err.getObjectMessage();
    }
    
    public static LList errorObjectIrritants(final NamedException err) {
        return err.getObjectIrritants();
    }
    
    public static boolean isReadError(final Object obj) {
        return obj instanceof SyntaxException;
    }
    
    public static boolean isFileError(final Object obj) {
        final boolean x = obj instanceof FileNotFoundException;
        return x ? x : (obj instanceof IOException && ((IOException)Promise.force(obj, IOException.class)).getMessage().startsWith("cannot delete"));
    }
    
    static {
        Lit31 = Symbol.valueOf("save");
        Lit30 = PairWithPosition.make(Lit24 = Symbol.valueOf("$lookup$"), Pair.make(Lit25 = Symbol.valueOf("current-handler"), Pair.make(Pair.make(Lit26 = Symbol.valueOf("quasiquote"), Pair.make(Symbol.valueOf("set"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200717);
        Lit29 = PairWithPosition.make(Symbol.valueOf("primitive-throw"), Lit28 = PairWithPosition.make(Lit27 = Symbol.valueOf("ex"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213023), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213006);
        Lit23 = Symbol.valueOf("begin");
        Lit22 = new Object[0];
        Lit21 = PairWithPosition.make(Lit17 = Symbol.valueOf("temp"), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 274452);
        Lit20 = Symbol.valueOf("if");
        Lit19 = Symbol.valueOf("let");
        (Lit18 = new Object[] { null })[0] = (Lit16 = Symbol.valueOf("=>"));
        Lit15 = Symbol.valueOf("else");
        Lit14 = Symbol.valueOf("file-error?");
        Lit13 = Symbol.valueOf("read-error?");
        Lit12 = Symbol.valueOf("error-object-irritants");
        Lit11 = Symbol.valueOf("error-object-message");
        Lit10 = Symbol.valueOf("error-object?");
        Lit9 = Symbol.valueOf("catch");
        Lit8 = Symbol.valueOf("error");
        Lit7 = Symbol.valueOf("throw");
        Lit6 = new SyntaxRules(new Object[] { exceptions.Lit15, exceptions.Lit16 }, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u0002\f\u000f\r\u0017\u0010\b\b\b", new Object[] { exceptions.Lit15 }, 3, "exceptions.scm:62"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000b\b\u0015\u0013", new Object[] { exceptions.Lit23 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\b", exceptions.Lit18, 3, "exceptions.scm:64"), "\u0001\u0001\u0001", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0003", new Object[] { exceptions.Lit19, exceptions.Lit17, exceptions.Lit20, exceptions.Lit21 }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007<\f\u000f\f\u0002\f\u0017\b\f\u001f\r' \b\b", exceptions.Lit18, 5, "exceptions.scm:69"), "\u0001\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f!\t\u0013\u0018\u001c\b\u0011\u0018$\t\u0003\t\u001b\b%#", new Object[] { exceptions.Lit19, exceptions.Lit17, exceptions.Lit20, exceptions.Lit21, Lit5 = Symbol.valueOf("guard-aux") }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\b", exceptions.Lit22, 2, "exceptions.scm:75"), "\u0001\u0001", "\u0011\u0018\u0004\t\u000b\b\u0003", new Object[] { Symbol.valueOf("or") }, 0), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\u001c\f\u000f\b\f\u0017\r\u001f\u0018\b\b", exceptions.Lit22, 4, "exceptions.scm:77"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u00041\b\u0011\u0018\f\b\u000b\b\u0011\u0018\u0014\u0011\u0018\f\u0011\u0018\f\b\u0011\u0018\u001c\t\u0003\t\u0013\b\u001d\u001b", new Object[] { exceptions.Lit19, exceptions.Lit17, exceptions.Lit20, exceptions.Lit5 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\b", exceptions.Lit22, 4, "exceptions.scm:82"), "\u0001\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0003", new Object[] { exceptions.Lit20, exceptions.Lit23 }, 1), new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007L\f\u000f\f\u0017\r\u001f\u0018\b\b\f'\r/(\b\b", exceptions.Lit22, 6, "exceptions.scm:86"), "\u0001\u0001\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\t\u000bA\u0011\u0018\f\t\u0013\b\u001d\u001b\b\u0011\u0018\u0014\t\u0003\t#\b-+", new Object[] { exceptions.Lit20, exceptions.Lit23, exceptions.Lit5 }, 1) }, 6, exceptions.Lit5);
        Lit4 = new SyntaxRules(exceptions.Lit22, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018<\f\u0007\r\u000f\b\b\b\f\u0017\r\u001f\u0018\b\b", exceptions.Lit22, 4, "exceptions.scm:44"), "\u0001\u0003\u0001\u0003", "\u0011\u0018\u0004\u0011\u0018\f\b\u0011\u0018\u0014\u0169\u0011\u0018\u001cY\u0011\u0018$\u0011\u0018,\t\u0013\b\u001d\u001b\u0011\u00184\b\u0011\u0018<\u0011\u0018D\b\u0011\u0018\u0004)\b\t\u0003\u0018L\b\u0011\u0018T\u0011\u0018\\\b\r\u000b\u0018d", new Object[] { exceptions.Lit19, PairWithPosition.make(PairWithPosition.make(exceptions.Lit31, PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(exceptions.Lit24, Pair.make(exceptions.Lit25, Pair.make(Pair.make(exceptions.Lit26, Pair.make(Symbol.valueOf("get"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184339), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184338), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184338), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184332), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 184331), Symbol.valueOf("try-finally"), Symbol.valueOf("try-catch"), exceptions.Lit23, PairWithPosition.make(exceptions.Lit30, PairWithPosition.make(null, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200737), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 200716), PairWithPosition.make(exceptions.Lit27, PairWithPosition.make(Symbol.valueOf("gnu.kawa.util.ExitCalled"), PairWithPosition.make(exceptions.Lit29, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 213006), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 208910), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 208906), exceptions.Lit27, Symbol.valueOf("java.lang.Throwable"), PairWithPosition.make(PairWithPosition.make(PairWithPosition.make(exceptions.Lit24, Pair.make(Symbol.valueOf("ExceptionWithValue"), Pair.make(Pair.make(exceptions.Lit26, Pair.make(Symbol.valueOf("unwrap"), LList.Empty)), LList.Empty)), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221210), exceptions.Lit28, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221209), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 221209), exceptions.Lit5, exceptions.Lit29, PairWithPosition.make(PairWithPosition.make(exceptions.Lit30, PairWithPosition.make(exceptions.Lit31, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237598), "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237577), LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm", 237577) }, 1) }, 4, Lit3 = Symbol.valueOf("guard"));
        Lit2 = Symbol.valueOf("raise-continuable");
        Lit1 = Symbol.valueOf("raise");
        Lit0 = Keyword.make("validate-apply");
        exceptions.$instance = new exceptions();
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
        final GenericProc with$Mnexception$Mnhandler2 = new GenericProc("with-exception-handler");
        final exceptions $instance = exceptions.$instance;
        final ModuleMethod method = new ModuleMethod($instance, 1, "with-exception-handler", 8194);
        method.setProperty("source-location", "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/kawa/lib/exceptions.scm:12");
        with$Mnexception$Mnhandler2.add(method);
        with$Mnexception$Mnhandler = with$Mnexception$Mnhandler2;
        final exceptions $instance2 = exceptions.$instance;
        final ModuleMethod raise2 = new ModuleMethod($instance2, 2, exceptions.Lit1, 4097);
        raise2.setProperty(Procedure.validateApplyKey, "kawa.lib.compile_misc:raiseValidateApply");
        raise = raise2;
        raise$Mncontinuable = new ModuleMethod($instance2, 3, exceptions.Lit2, 4097);
        guard = Macro.make(exceptions.Lit3, exceptions.Lit4, "kawa.lib.exceptions");
        guard$Mnaux = Macro.make(exceptions.Lit5, exceptions.Lit6, "kawa.lib.exceptions");
        throw = new ModuleMethod($instance2, 4, exceptions.Lit7, -4096);
        error = new ModuleMethod($instance2, 5, exceptions.Lit8, -4096);
        catch = new ModuleMethod($instance2, 6, exceptions.Lit9, 12291);
        error$Mnobject$Qu = new ModuleMethod($instance2, 7, exceptions.Lit10, 4097);
        error$Mnobject$Mnmessage = new ModuleMethod($instance2, 8, exceptions.Lit11, 4097);
        error$Mnobject$Mnirritants = new ModuleMethod($instance2, 9, exceptions.Lit12, 4097);
        read$Mnerror$Qu = new ModuleMethod($instance2, 10, exceptions.Lit13, 4097);
        file$Mnerror$Qu = new ModuleMethod($instance2, 11, exceptions.Lit14, 4097);
        $runBody$();
    }
    
    public exceptions() {
        ModuleInfo.register(this);
    }
    
    public static Object withExceptionHandler(final Procedure handler, final Procedure thunk) {
        final HandlerLink link = HandlerLink.push(handler);
        Object o;
        try {
            final Object apply0 = thunk.apply0();
            link.pop();
            o = apply0;
        }
        catch (Throwable ex) {
            throw link.handle(ex);
        }
        return o;
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
            case 11: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 10: {
                ctx.value1 = o;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 9: {
                final Object force = Promise.force(o, NamedException.class);
                if (!(force instanceof NamedException)) {
                    return -786431;
                }
                ctx.value1 = force;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 8: {
                final Object force2 = Promise.force(o, NamedException.class);
                if (!(force2 instanceof NamedException)) {
                    return -786431;
                }
                ctx.value1 = force2;
                ctx.proc = moduleMethod;
                ctx.pc = 1;
                return 0;
            }
            case 7: {
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
            default: {
                return super.match1(moduleMethod, o, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        if (moduleMethod.selector != 1) {
            return super.match2(moduleMethod, o, o2, ctx);
        }
        final Object force = Promise.force(o, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force) == null) {
            return -786431;
        }
        ctx.value1 = force;
        final Object force2 = Promise.force(o2, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force2) != null) {
            ctx.value2 = force2;
            ctx.proc = moduleMethod;
            ctx.pc = 2;
            return 0;
        }
        return -786430;
    }
    
    @Override
    public int match3(final ModuleMethod moduleMethod, final Object o, final Object o2, final Object o3, final CallContext ctx) {
        if (moduleMethod.selector != 6) {
            return super.match3(moduleMethod, o, o2, o3, ctx);
        }
        ctx.value1 = o;
        final Object force = Promise.force(o2, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force) == null) {
            return -786430;
        }
        ctx.value2 = force;
        final Object force2 = Promise.force(o3, Procedure.class);
        if (LangObjType.coerceToProcedureOrNull(force2) != null) {
            ctx.value3 = force2;
            ctx.proc = moduleMethod;
            ctx.pc = 3;
            return 0;
        }
        return -786429;
    }
    
    @Override
    public int matchN(final ModuleMethod proc, final Object[] args, final CallContext ctx) {
        switch (proc.selector) {
            case 5: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            case 4: {
                ctx.values = args;
                ctx.proc = proc;
                ctx.pc = 5;
                return 0;
            }
            default: {
                return super.matchN(proc, args, ctx);
            }
        }
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
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
        //                4: 60
        //                5: 65
        //                6: 147
        //                7: 147
        //                8: 147
        //                9: 70
        //               10: 87
        //               11: 100
        //               12: 113
        //               13: 130
        //          default: 147
        //        }
        //    60: aload_2        
        //    61: invokestatic    kawa/lib/exceptions.raise:(Ljava/lang/Object;)Lgnu/bytecode/Type$NeverReturns;
        //    64: areturn        
        //    65: aload_2        
        //    66: invokestatic    kawa/lib/exceptions.raiseContinuable:(Ljava/lang/Object;)Ljava/lang/Object;
        //    69: areturn        
        //    70: aload_2        
        //    71: invokestatic    kawa/lib/exceptions.isErrorObject:(Ljava/lang/Object;)Z
        //    74: ifeq            83
        //    77: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    80: goto            86
        //    83: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //    86: areturn        
        //    87: aload_2        
        //    88: ldc             Lkawa/lang/NamedException;.class
        //    90: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    93: checkcast       Lkawa/lang/NamedException;
        //    96: invokestatic    kawa/lib/exceptions.errorObjectMessage:(Lkawa/lang/NamedException;)Ljava/lang/Object;
        //    99: areturn        
        //   100: aload_2        
        //   101: ldc             Lkawa/lang/NamedException;.class
        //   103: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //   106: checkcast       Lkawa/lang/NamedException;
        //   109: invokestatic    kawa/lib/exceptions.errorObjectIrritants:(Lkawa/lang/NamedException;)Lgnu/lists/LList;
        //   112: areturn        
        //   113: aload_2        
        //   114: invokestatic    kawa/lib/exceptions.isReadError:(Ljava/lang/Object;)Z
        //   117: ifeq            126
        //   120: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   123: goto            129
        //   126: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   129: areturn        
        //   130: aload_2        
        //   131: invokestatic    kawa/lib/exceptions.isFileError:(Ljava/lang/Object;)Z
        //   134: ifeq            143
        //   137: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //   140: goto            146
        //   143: getstatic       java/lang/Boolean.FALSE:Ljava/lang/Boolean;
        //   146: areturn        
        //   147: aload_0        
        //   148: aload_1        
        //   149: aload_2        
        //   150: invokespecial   gnu/expr/ModuleBody.apply1:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
        //   153: areturn        
        //   154: new             Lgnu/mapping/WrongType;
        //   157: dup_x1         
        //   158: swap           
        //   159: ldc_w           "error-object-message"
        //   162: iconst_1       
        //   163: aload_2        
        //   164: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   167: athrow         
        //   168: new             Lgnu/mapping/WrongType;
        //   171: dup_x1         
        //   172: swap           
        //   173: ldc_w           "error-object-irritants"
        //   176: iconst_1       
        //   177: aload_2        
        //   178: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //   181: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  93     96     154    168    Ljava/lang/ClassCastException;
        //  106    109    168    182    Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0113:
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
    
    @Override
    public Object apply2(final ModuleMethod p0, final Object p1, final Object p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: iconst_1       
        //     5: if_icmpne       33
        //     8: goto            11
        //    11: aload_2        
        //    12: ldc             Lgnu/mapping/Procedure;.class
        //    14: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    17: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    20: aload_3        
        //    21: ldc             Lgnu/mapping/Procedure;.class
        //    23: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    26: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    29: invokestatic    kawa/lib/exceptions.withExceptionHandler:(Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //    32: areturn        
        //    33: aload_0        
        //    34: aload_1        
        //    35: aload_2        
        //    36: aload_3        
        //    37: invokespecial   gnu/expr/ModuleBody.apply2:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    40: areturn        
        //    41: new             Lgnu/mapping/WrongType;
        //    44: dup_x1         
        //    45: swap           
        //    46: ldc             "with-exception-handler"
        //    48: iconst_1       
        //    49: aload_2        
        //    50: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    53: athrow         
        //    54: new             Lgnu/mapping/WrongType;
        //    57: dup_x1         
        //    58: swap           
        //    59: ldc             "with-exception-handler"
        //    61: iconst_2       
        //    62: aload_3        
        //    63: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    66: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  17     20     41     54     Ljava/lang/ClassCastException;
        //  26     29     54     67     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0033:
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
    
    @Override
    public Object apply3(final ModuleMethod p0, final Object p1, final Object p2, final Object p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        gnu/expr/ModuleMethod.selector:I
        //     4: bipush          6
        //     6: if_icmpne       36
        //     9: goto            12
        //    12: aload_2        
        //    13: aload_3        
        //    14: ldc             Lgnu/mapping/Procedure;.class
        //    16: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    19: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    22: aload           4
        //    24: ldc             Lgnu/mapping/Procedure;.class
        //    26: invokestatic    gnu/mapping/Promise.force:(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
        //    29: invokestatic    gnu/kawa/lispexpr/LangObjType.coerceToProcedure:(Ljava/lang/Object;)Lgnu/mapping/Procedure;
        //    32: invokestatic    kawa/lib/exceptions.catch:(Ljava/lang/Object;Lgnu/mapping/Procedure;Lgnu/mapping/Procedure;)Ljava/lang/Object;
        //    35: areturn        
        //    36: aload_0        
        //    37: aload_1        
        //    38: aload_2        
        //    39: aload_3        
        //    40: aload           4
        //    42: invokespecial   gnu/expr/ModuleBody.apply3:(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    45: areturn        
        //    46: new             Lgnu/mapping/WrongType;
        //    49: dup_x1         
        //    50: swap           
        //    51: ldc_w           "catch"
        //    54: iconst_2       
        //    55: aload_3        
        //    56: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    59: athrow         
        //    60: new             Lgnu/mapping/WrongType;
        //    63: dup_x1         
        //    64: swap           
        //    65: ldc_w           "catch"
        //    68: iconst_3       
        //    69: aload           4
        //    71: invokespecial   gnu/mapping/WrongType.<init>:(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V
        //    74: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                          
        //  -----  -----  -----  -----  ------------------------------
        //  19     22     46     60     Ljava/lang/ClassCastException;
        //  29     32     60     75     Ljava/lang/ClassCastException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0036:
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
    
    @Override
    public Object applyN(final ModuleMethod method, final Object[] args) {
        switch (method.selector) {
            case 4: {
                return throw(args);
            }
            case 5: {
                return error(args);
            }
            default: {
                return super.applyN(method, args);
            }
        }
    }
}
