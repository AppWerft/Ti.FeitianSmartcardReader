/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class repl
extends ModuleBody {
    public static final StaticFieldLocation interaction$Mnenvironment;
    public static repl $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new repl();
        interaction$Mnenvironment = StaticFieldLocation.make("kawa.lib.misc", "interaction$Mnenvironment");
        repl.$runBody$();
    }

    public repl() {
        ModuleInfo.register(this);
    }
}

