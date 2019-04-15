/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.android;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import kawa.lib.parameters;

public class utils
extends ModuleBody {
    public static final LocationProc current$Mnactivity;
    public static utils $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
        current$Mnactivity = parameters.makeParameter(null);
    }

    public static {
        $instance = new utils();
        utils.$runBody$();
    }

    public utils() {
        ModuleInfo.register(this);
    }
}

