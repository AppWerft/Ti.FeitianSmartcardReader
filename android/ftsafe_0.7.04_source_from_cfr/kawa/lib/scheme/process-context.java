/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class process-context
extends ModuleBody {
    public static final StaticFieldLocation command$Mnline;
    public static final StaticFieldLocation exit;
    public static final StaticFieldLocation emergency$Mnexit;
    public static final StaticFieldLocation get$Mnenvironment$Mnvariable;
    public static final StaticFieldLocation get$Mnenvironment$Mnvariables;
    public static process-context $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new process-context();
        command$Mnline = StaticFieldLocation.make("kawa.lib.rnrs.programs", "command$Mnline");
        exit = StaticFieldLocation.make("kawa.lib.rnrs.programs", "exit");
        emergency$Mnexit = StaticFieldLocation.make("kawa.lib.rnrs.programs", "emergency$Mnexit");
        get$Mnenvironment$Mnvariable = StaticFieldLocation.make("kawa.lib.system", "get$Mnenvironment$Mnvariable");
        get$Mnenvironment$Mnvariables = StaticFieldLocation.make("kawa.lib.system", "get$Mnenvironment$Mnvariables");
        process-context.$runBody$();
    }

    public process-context() {
        ModuleInfo.register(this);
    }
}

