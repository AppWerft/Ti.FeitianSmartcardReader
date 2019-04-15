/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class case-lambda
extends ModuleBody {
    public static final StaticFieldLocation case$Mnlambda;
    public static case-lambda $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new case-lambda();
        case$Mnlambda = StaticFieldLocation.make("kawa.lib.syntax", "case$Mnlambda");
        case-lambda.$runBody$();
    }

    public case-lambda() {
        ModuleInfo.register(this);
    }
}

