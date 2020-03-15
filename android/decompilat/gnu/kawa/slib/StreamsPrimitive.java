// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import gnu.mapping.Promise;
import gnu.lists.Pair;
import gnu.expr.Special;
import kawa.lib.exceptions;
import gnu.mapping.Lazy;
import kawa.lib.misc;
import gnu.lists.Consumer;
import gnu.mapping.Procedure;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleMethod;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class StreamsPrimitive extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        StreamsPrimitive.stream$Mnnull = new StreamPromise(StreamsPrimitive.lambda$Fn1, false);
    }
    
    public static boolean isStream(final Object value) {
        return value instanceof Stream;
    }
    
    static StreamPromise lambda1() {
        return StreamsType.stream$Mnnull$Mn1;
    }
    
    public static boolean isStreamPair(final Object obj) {
        final boolean x = obj instanceof StreamPair;
        return x ? x : (obj instanceof StreamPromise && isStreamPair(misc.force(obj)));
    }
    
    public static boolean isStreamNull(final Object obj) {
        final boolean x = obj == StreamsType.stream$Mnnull$Mn1;
        boolean b;
        if (x) {
            b = x;
        }
        else if (obj instanceof Lazy) {
            final Object v = ((Lazy)obj).getValue();
            b = (v != obj && isStreamNull(v));
        }
        else {
            b = false;
        }
        return b;
    }
    
    public static Object streamCar(final Object strm) {
        if (isStreamNull(strm)) {
            exceptions.error(StreamsPrimitive.Lit0, "null stream");
            throw Special.reachedUnexpected;
        }
        final Object force = Promise.force(strm, Pair.class);
        try {
            return misc.force(lists.car((Pair)force));
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "car", 1, force);
        }
    }
    
    public static Object streamCdr(final Object strm) {
        if (isStreamNull(strm)) {
            exceptions.error(StreamsPrimitive.Lit1, "null stream");
            throw Special.reachedUnexpected;
        }
        final Object force = Promise.force(strm, Pair.class);
        try {
            return lists.cdr((Pair)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "cdr", 1, force);
        }
    }
    
    static {
        Lit10 = Symbol.valueOf("stream-lazy");
        Lit9 = new Object[0];
        Lit8 = new SyntaxRules(StreamsPrimitive.Lit9, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\r\u0017\u0010\b\b", StreamsPrimitive.Lit9, 3, "StreamsPrimitive.scm:70"), "\u0001\u0001\u0003", "\u0011\u0018\u0004\t\u0003\b\u0011\u0018\f\b\u0011\u0018\u0014\t\u0010\t\u000b\b\u0015\u0013", new Object[] { Symbol.valueOf("lambda"), StreamsPrimitive.Lit10, Symbol.valueOf("let") }, 1) }, 3, Lit7 = Symbol.valueOf("stream-lambda"));
        Lit6 = new SyntaxRules(StreamsPrimitive.Lit9, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\f\u000f\b", StreamsPrimitive.Lit9, 2, "StreamsPrimitive.scm:57"), "\u0001\u0001", "\u0011\u0018\u0004)\u0011\u0018\f\b\u0003\b\u0011\u0018\u0014\b\u000b", new Object[] { Symbol.valueOf("StreamPair"), Symbol.valueOf("stream-delay"), StreamsPrimitive.Lit10 }, 0) }, 2, Lit5 = Symbol.valueOf("stream-cons"));
        Lit4 = Symbol.valueOf("stream-null?");
        Lit3 = Symbol.valueOf("stream-pair?");
        Lit2 = Symbol.valueOf("stream?");
        Lit1 = Symbol.valueOf("stream-cdr");
        Lit0 = Symbol.valueOf("stream-car");
        StreamsPrimitive.$instance = new StreamsPrimitive();
        $Prvt$StreamPair = StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "StreamPair");
        stream$Mntype = StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mntype");
        $Prvt$stream$Mnlazy = StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mnlazy");
        $Prvt$stream$Mndelay = StaticFieldLocation.make("gnu.kawa.slib.StreamsType", "stream$Mndelay");
        final StreamsPrimitive $instance = StreamsPrimitive.$instance;
        stream$Qu = new ModuleMethod($instance, 1, StreamsPrimitive.Lit2, 4097);
        lambda$Fn1 = new ModuleMethod($instance, 2, null, 0);
        stream$Mnpair$Qu = new ModuleMethod($instance, 3, StreamsPrimitive.Lit3, 4097);
        stream$Mnnull$Qu = new ModuleMethod($instance, 4, StreamsPrimitive.Lit4, 4097);
        stream$Mncons = Macro.make(StreamsPrimitive.Lit5, StreamsPrimitive.Lit6, "gnu.kawa.slib.StreamsPrimitive");
        stream$Mncar = new ModuleMethod($instance, 5, StreamsPrimitive.Lit0, 4097);
        stream$Mncdr = new ModuleMethod($instance, 6, StreamsPrimitive.Lit1, 4097);
        stream$Mnlambda = Macro.make(StreamsPrimitive.Lit7, StreamsPrimitive.Lit8, "gnu.kawa.slib.StreamsPrimitive");
        $runBody$();
    }
    
    public StreamsPrimitive() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match0(final ModuleMethod moduleMethod, final CallContext ctx) {
        if (moduleMethod.selector == 2) {
            ctx.proc = moduleMethod;
            return ctx.pc = 0;
        }
        return super.match0(moduleMethod, ctx);
    }
    
    @Override
    public int match1(final ModuleMethod moduleMethod, final Object o, final CallContext ctx) {
        switch (moduleMethod.selector) {
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
    public Object apply0(final ModuleMethod method) {
        if (method.selector == 2) {
            return lambda1();
        }
        return super.apply0(method);
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        switch (method.selector) {
            case 1: {
                return isStream(o) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 3: {
                return isStreamPair(o) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 4: {
                return isStreamNull(o) ? Boolean.TRUE : Boolean.FALSE;
            }
            case 5: {
                return streamCar(o);
            }
            case 6: {
                return streamCdr(o);
            }
            default: {
                return super.apply1(method, o);
            }
        }
    }
}
