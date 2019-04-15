/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class Streams
extends ModuleBody {
    public static final int $Pcprovide$Pcsrfi$Mn41 = 123;
    public static final StaticFieldLocation stream$Mnnull;
    public static final StaticFieldLocation stream$Mncons;
    public static final StaticFieldLocation stream$Qu;
    public static final StaticFieldLocation stream$Mnnull$Qu;
    public static final StaticFieldLocation stream$Mnpair$Qu;
    public static final StaticFieldLocation stream$Mncar;
    public static final StaticFieldLocation stream$Mncdr;
    public static final StaticFieldLocation stream$Mnlambda;
    public static final StaticFieldLocation define$Mnstream;
    public static final StaticFieldLocation list$Mn$Grstream;
    public static final StaticFieldLocation port$Mn$Grstream;
    public static final StaticFieldLocation stream;
    public static final StaticFieldLocation stream$Mn$Grlist;
    public static final StaticFieldLocation stream$Mnappend;
    public static final StaticFieldLocation stream$Mnconcat;
    public static final StaticFieldLocation stream$Mnconstant;
    public static final StaticFieldLocation stream$Mndrop;
    public static final StaticFieldLocation stream$Mndrop$Mnwhile;
    public static final StaticFieldLocation stream$Mnfilter;
    public static final StaticFieldLocation stream$Mnfold;
    public static final StaticFieldLocation stream$Mnfor$Mneach;
    public static final StaticFieldLocation stream$Mnfrom;
    public static final StaticFieldLocation stream$Mniterate;
    public static final StaticFieldLocation stream$Mnlength;
    public static final StaticFieldLocation stream$Mnlet;
    public static final StaticFieldLocation stream$Mnmap;
    public static final StaticFieldLocation stream$Mnmatch;
    public static final StaticFieldLocation stream$Mnof;
    public static final StaticFieldLocation stream$Mnrange;
    public static final StaticFieldLocation stream$Mnref;
    public static final StaticFieldLocation stream$Mnreverse;
    public static final StaticFieldLocation stream$Mnscan;
    public static final StaticFieldLocation stream$Mntake;
    public static final StaticFieldLocation stream$Mntake$Mnwhile;
    public static final StaticFieldLocation stream$Mnunfold;
    public static final StaticFieldLocation stream$Mnunfolds;
    public static final StaticFieldLocation stream$Mnzip;
    public static Streams $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new Streams();
        stream$Mnnull = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnnull");
        stream$Mncons = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncons");
        stream$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Qu");
        stream$Mnnull$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnnull$Qu");
        stream$Mnpair$Qu = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnpair$Qu");
        stream$Mncar = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncar");
        stream$Mncdr = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mncdr");
        stream$Mnlambda = StaticFieldLocation.make("gnu.kawa.slib.StreamsPrimitive", "stream$Mnlambda");
        define$Mnstream = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "define$Mnstream");
        list$Mn$Grstream = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "list$Mn$Grstream");
        port$Mn$Grstream = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "port$Mn$Grstream");
        stream = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream");
        stream$Mn$Grlist = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mn$Grlist");
        stream$Mnappend = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnappend");
        stream$Mnconcat = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnconcat");
        stream$Mnconstant = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnconstant");
        stream$Mndrop = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mndrop");
        stream$Mndrop$Mnwhile = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mndrop$Mnwhile");
        stream$Mnfilter = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnfilter");
        stream$Mnfold = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnfold");
        stream$Mnfor$Mneach = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnfor$Mneach");
        stream$Mnfrom = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnfrom");
        stream$Mniterate = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mniterate");
        stream$Mnlength = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnlength");
        stream$Mnlet = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnlet");
        stream$Mnmap = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnmap");
        stream$Mnmatch = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnmatch");
        stream$Mnof = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnof");
        stream$Mnrange = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnrange");
        stream$Mnref = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnref");
        stream$Mnreverse = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnreverse");
        stream$Mnscan = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnscan");
        stream$Mntake = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mntake");
        stream$Mntake$Mnwhile = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mntake$Mnwhile");
        stream$Mnunfold = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnunfold");
        stream$Mnunfolds = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnunfolds");
        stream$Mnzip = StaticFieldLocation.make("gnu.kawa.slib.StreamsDerived", "stream$Mnzip");
        Streams.$runBody$();
    }

    public Streams() {
        ModuleInfo.register(this);
    }
}

