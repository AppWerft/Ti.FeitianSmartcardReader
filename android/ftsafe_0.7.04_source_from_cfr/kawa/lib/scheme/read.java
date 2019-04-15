/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class read
extends ModuleBody {
    public static final StaticFieldLocation read;
    public static read $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new read();
        read = StaticFieldLocation.make("kawa.lib.ports", "read");
        read.$runBody$();
    }

    public read() {
        ModuleInfo.register(this);
    }
}

