/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class load
extends ModuleBody {
    public static final StaticFieldLocation load;
    public static load $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new load();
        load = StaticFieldLocation.make("kawa.standard.load", "load");
        load.$runBody$();
    }

    public load() {
        ModuleInfo.register(this);
    }
}

