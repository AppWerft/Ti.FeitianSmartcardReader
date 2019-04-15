/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class time
extends ModuleBody {
    public static final StaticFieldLocation current$Mnsecond;
    public static final StaticFieldLocation current$Mnjiffy;
    public static final StaticFieldLocation jiffies$Mnper$Mnsecond;
    public static time $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new time();
        current$Mnsecond = StaticFieldLocation.make("kawa.lib.system", "current$Mnsecond");
        current$Mnjiffy = StaticFieldLocation.make("kawa.lib.system", "current$Mnjiffy");
        jiffies$Mnper$Mnsecond = StaticFieldLocation.make("kawa.lib.system", "jiffies$Mnper$Mnsecond");
        time.$runBody$();
    }

    public time() {
        ModuleInfo.register(this);
    }
}

