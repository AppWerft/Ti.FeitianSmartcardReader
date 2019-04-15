/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.slib.Stream;
import gnu.kawa.slib.StreamPair;
import gnu.kawa.slib.StreamPromise;
import gnu.lists.Consumer;
import gnu.lists.EmptyList;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.misc;

public class StreamsType
extends ModuleBody {
    public static final Class Stream;
    public static final Class StreamPromise;
    public static final Class StreamPair;
    public static final Class stream$Mntype;
    public static StreamPromise stream$Mnnull$Mn1;
    public static final Macro stream$Mnlazy;
    public static final Macro stream$Mndelay;
    public static final ModuleMethod stream$Mnforce;
    public static final ModuleMethod stream$Mneager;
    public static StreamsType $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final Object[] Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        StreamPromise p = new StreamPromise();
        p.setValue(LList.Empty);
        stream$Mnnull$Mn1 = p;
    }

    public static Object streamForce(Object promise) {
        return misc.force(promise);
    }

    public static Object streamEager(Object expr) {
        return expr;
    }

    public static {
        Lit8 = Symbol.valueOf("lambda");
        Lit7 = Symbol.valueOf("StreamPromise");
        Lit6 = new Object[0];
        Lit5 = Symbol.valueOf("stream-eager");
        Lit4 = Symbol.valueOf("stream-force");
        Lit2 = Symbol.valueOf("stream-delay");
        Lit3 = new SyntaxRules(Lit6, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit6, 1, "StreamsType.scm:30"), "\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u0003\u0018\u0014", new Object[]{Lit7, Lit8, PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsType.scm", 127015)}, 0)}, 1, Lit2);
        Lit0 = Symbol.valueOf("stream-lazy");
        Lit1 = new SyntaxRules(Lit6, new SyntaxRule[]{new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", Lit6, 1, "StreamsType.scm:25"), "\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u0003\u0018\u0014", new Object[]{Lit7, Lit8, PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsType.scm", 106534)}, 0)}, 1, Lit0);
        $instance = new StreamsType();
        Stream = Stream.class;
        StreamPromise = StreamPromise.class;
        StreamPair = StreamPair.class;
        stream$Mntype = Stream.class;
        stream$Mnlazy = Macro.make(Lit0, Lit1, "gnu.kawa.slib.StreamsType");
        stream$Mndelay = Macro.make(Lit2, Lit3, "gnu.kawa.slib.StreamsType");
        StreamsType streamsType = $instance;
        stream$Mnforce = new ModuleMethod(streamsType, 1, Lit4, 4097);
        stream$Mneager = new ModuleMethod(streamsType, 2, Lit5, 4097);
        StreamsType.$runBody$();
    }

    public StreamsType() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
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
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return StreamsType.streamForce(object2);
            }
            case 2: {
                return StreamsType.streamEager(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }
}

