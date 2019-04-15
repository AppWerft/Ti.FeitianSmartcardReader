/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class lazy
extends ModuleBody {
    public static final StaticFieldLocation promise$Qu;
    public static final StaticFieldLocation make$Mnpromise;
    public static final StaticFieldLocation force;
    public static final StaticFieldLocation delay;
    public static final StaticFieldLocation delay$Mnforce;
    public static lazy $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new lazy();
        promise$Qu = StaticFieldLocation.make("kawa.lib.misc", "promise$Qu");
        make$Mnpromise = StaticFieldLocation.make("kawa.lib.misc", "make$Mnpromise");
        force = StaticFieldLocation.make("kawa.lib.misc", "force");
        delay = StaticFieldLocation.make("kawa.lib.std_syntax", "delay");
        delay$Mnforce = StaticFieldLocation.make("kawa.lib.std_syntax", "delay$Mnforce");
        lazy.$runBody$();
    }

    public lazy() {
        ModuleInfo.register(this);
    }
}

