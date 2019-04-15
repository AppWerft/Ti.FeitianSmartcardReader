/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.bytecode.Type;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.slib.Stream;
import gnu.kawa.slib.StreamPair;
import gnu.kawa.slib.StreamPromise;
import gnu.kawa.slib.StreamsType;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Lazy;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.exceptions;
import kawa.lib.lists;
import kawa.lib.misc;

public class StreamsPrimitive
extends ModuleBody {
    public static StreamPromise stream$Mnnull;
    public static final Macro stream$Mncons;
    public static final ModuleMethod stream$Qu;
    public static final ModuleMethod stream$Mnnull$Qu;
    public static final StaticFieldLocation stream$Mntype;
    public static final ModuleMethod stream$Mnpair$Qu;
    public static final ModuleMethod stream$Mncar;
    public static final ModuleMethod stream$Mncdr;
    public static final Macro stream$Mnlambda;
    public static final StaticFieldLocation $Prvt$StreamPair;
    public static final StaticFieldLocation $Prvt$stream$Mnlazy;
    public static final StaticFieldLocation $Prvt$stream$Mndelay;
    static final ModuleMethod lambda$Fn1;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    public static StreamsPrimitive $instance;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SyntaxRules Lit6;
    static final SimpleSymbol Lit7;
    static final SyntaxRules Lit8;
    static final Object[] Lit9;
    static final SimpleSymbol Lit10;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        stream$Mnnull = new StreamPromise(lambda$Fn1, false);
    }

    public static boolean isStream(Object value) {
        return value instanceof Stream;
    }

    static StreamPromise lambda1() {
        return StreamsType.stream$Mnnull$Mn1;
    }

    public static boolean isStreamPair(Object obj) {
        boolean x = obj instanceof StreamPair;
        return x ? x : (obj instanceof StreamPromise ? StreamsPrimitive.isStreamPair(misc.force(obj)) : false);
    }

    public static boolean isStreamNull(Object obj) {
        Object v;
        boolean x;
        boolean bl = x = obj == StreamsType.stream$Mnnull$Mn1;
        boolean bl2 = x ? x : (obj instanceof Lazy ? ((v = ((Lazy)obj).getValue()) != obj ? StreamsPrimitive.isStreamNull(v) : false) : false);
        return bl2;
    }

    public static Object streamCar(Object strm) {
        if (StreamsPrimitive.isStreamNull(strm)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit0, "null stream");
            throw Special.reachedUnexpected;
        }
        Object object2 = Promise.force(strm, Pair.class);
        try {
            return misc.force(lists.car((Pair)object2));
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "car", 1, object2);
        }
    }

    public static Object streamCdr(Object strm) {
        if (StreamsPrimitive.isStreamNull(strm)) {
            Type.NeverReturns neverReturns = exceptions.error(Lit1, "null stream");
            throw Special.reachedUnexpected;
        }
        Object object2 = Promise.force(strm, Pair.class);
        try {
            return lists.cdr((Pair)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "cdr", 1, object2);
        }
    }

    public static {
        Lit10 = Symbol.valueOf("stream-lazy");
        Lit9 = new Object[0];
        Lit7 = Symbol.valueOf("stream-lambda");
        Lit8 = new SyntaxRules(Lit9, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", Lit9, 3, "StreamsPrimitive.scm:70"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\b\u0011\u0018\u0014\t\u0010\t\u000b\b\u0015\u0013", new Object[]{Symbol.valueOf("lambda"), Lit10, Symbol.valueOf("let")}, 1)}, 3, Lit7);
        Lit5 = Symbol.valueOf("stream-cons");
        Lit6 = new SyntaxRules(Lit9, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", Lit9, 2, "StreamsPrimitive.scm:57"), "\u0001\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\b\u000b", new Object[]{Symbol.valueOf("StreamPair"), Symbol.valueOf("stream-delay"), Lit10}, 0)}, 2, Lit5);
        Lit4 = Symbol.valueOf("stream-null?");
        Lit3 = Symbol.valueOf("stream-pair?");
        Lit2 = Symbol.valueOf("stream?");
        Lit1 = Symbol.valueOf("stream-cdr");
        Lit0 = Symbol.valueOf("stream-car");
        $instance = new StreamsPrimitive();
        $Prvt$StreamPair = StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "StreamPair");
        stream$Mntype = StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mntype");
        $Prvt$stream$Mnlazy = StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mnlazy");
        $Prvt$stream$Mndelay = StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mndelay");
        StreamsPrimitive streamsPrimitive = $instance;
        stream$Qu = new ModuleMethod(streamsPrimitive, 1, Lit2, 4097);
        lambda$Fn1 = new ModuleMethod(streamsPrimitive, 2, null, 0);
        stream$Mnpair$Qu = new ModuleMethod(streamsPrimitive, 3, Lit3, 4097);
        stream$Mnnull$Qu = new ModuleMethod(streamsPrimitive, 4, Lit4, 4097);
        stream$Mncons = Macro.make(Lit5, Lit6, "gnu.kawa.slib.StreamsPrimitive");
        stream$Mncar = new ModuleMethod(streamsPrimitive, 5, Lit0, 4097);
        stream$Mncdr = new ModuleMethod(streamsPrimitive, 6, Lit1, 4097);
        stream$Mnlambda = Macro.make(Lit7, Lit8, "gnu.kawa.slib.StreamsPrimitive");
        StreamsPrimitive.$runBody$();
    }

    public StreamsPrimitive() {
        ModuleInfo.register(this);
    }

    public int match0(ModuleMethod moduleMethod, CallContext callContext) {
        if (moduleMethod.selector == 2) {
            callContext.proc = moduleMethod;
            callContext.pc = 0;
            return 0;
        }
        return super.match0(moduleMethod, callContext);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
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

    public Object apply0(ModuleMethod moduleMethod) {
        if (moduleMethod.selector == 2) {
            return StreamsPrimitive.lambda1();
        }
        return super.apply0(moduleMethod);
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return StreamsPrimitive.isStream(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 3: {
                return StreamsPrimitive.isStreamPair(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 4: {
                return StreamsPrimitive.isStreamNull(object2) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 5: {
                return StreamsPrimitive.streamCar(object2);
            }
            case 6: {
                return StreamsPrimitive.streamCdr(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }
}

