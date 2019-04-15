/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class write
extends ModuleBody {
    public static final StaticFieldLocation write$Mnsimple;
    public static final StaticFieldLocation write;
    public static final StaticFieldLocation write$Mnshared;
    public static final StaticFieldLocation display;
    public static write $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new write();
        write$Mnsimple = StaticFieldLocation.make("kawa.lib.ports", "write$Mnsimple");
        write = StaticFieldLocation.make("kawa.lib.ports", "write");
        write$Mnshared = StaticFieldLocation.make("kawa.lib.ports", "write$Mnshared");
        display = StaticFieldLocation.make("kawa.lib.ports", "display");
        write.$runBody$();
    }

    public write() {
        ModuleInfo.register(this);
    }
}

