// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.slib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Procedure;
import gnu.lists.PairWithPosition;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import gnu.mapping.Symbol;
import kawa.lib.misc;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import kawa.lang.SyntaxRules;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import kawa.lang.Macro;
import gnu.expr.ModuleBody;

public class StreamsType extends ModuleBody
{
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
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        final StreamPromise p = new StreamPromise();
        p.setValue(LList.Empty);
        StreamsType.stream$Mnnull$Mn1 = p;
    }
    
    public static Object streamForce(final Object promise) {
        return misc.force(promise);
    }
    
    public static Object streamEager(final Object expr) {
        return expr;
    }
    
    static {
        Lit8 = Symbol.valueOf("lambda");
        Lit7 = Symbol.valueOf("StreamPromise");
        Lit6 = new Object[0];
        Lit5 = Symbol.valueOf("stream-eager");
        Lit4 = Symbol.valueOf("stream-force");
        Lit3 = new SyntaxRules(StreamsType.Lit6, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", StreamsType.Lit6, 1, "StreamsType.scm:30"), "\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u0003\u0018\u0014", new Object[] { StreamsType.Lit7, StreamsType.Lit8, PairWithPosition.make(Boolean.FALSE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsType.scm", 127015) }, 0) }, 1, Lit2 = Symbol.valueOf("stream-delay"));
        Lit1 = new SyntaxRules(StreamsType.Lit6, new SyntaxRule[] { new SyntaxRule(new SyntaxPattern("\f\u0018\f\u0007\b", StreamsType.Lit6, 1, "StreamsType.scm:25"), "\u0001", "\u0011\u0018\u00049\u0011\u0018\f\t\u0010\b\u0003\u0018\u0014", new Object[] { StreamsType.Lit7, StreamsType.Lit8, PairWithPosition.make(Boolean.TRUE, LList.Empty, "/mnt/hgfs/trunk/kawaForAndroid/kawa-2.4/gnu/kawa/slib/StreamsType.scm", 106534) }, 0) }, 1, Lit0 = Symbol.valueOf("stream-lazy"));
        StreamsType.$instance = new StreamsType();
        Stream = Stream.class;
        StreamPromise = StreamPromise.class;
        StreamPair = StreamPair.class;
        stream$Mntype = Stream.class;
        stream$Mnlazy = Macro.make(StreamsType.Lit0, StreamsType.Lit1, "gnu.kawa.slib.StreamsType");
        stream$Mndelay = Macro.make(StreamsType.Lit2, StreamsType.Lit3, "gnu.kawa.slib.StreamsType");
        final StreamsType $instance = StreamsType.$instance;
        stream$Mnforce = new ModuleMethod($instance, 1, StreamsType.Lit4, 4097);
        stream$Mneager = new ModuleMethod($instance, 2, StreamsType.Lit5, 4097);
        $runBody$();
    }
    
    public StreamsType() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 2: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
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
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object arg1) {
        switch (method.selector) {
            case 1: {
                return streamForce(arg1);
            }
            case 2: {
                return streamEager(arg1);
            }
            default: {
                return super.apply1(method, arg1);
            }
        }
    }
}
