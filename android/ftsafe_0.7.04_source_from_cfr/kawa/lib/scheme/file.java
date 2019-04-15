/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class file
extends ModuleBody {
    public static final StaticFieldLocation file$Mnexists$Qu;
    public static final StaticFieldLocation delete$Mnfile;
    public static final StaticFieldLocation open$Mninput$Mnfile;
    public static final StaticFieldLocation open$Mnbinary$Mninput$Mnfile;
    public static final StaticFieldLocation open$Mnoutput$Mnfile;
    public static final StaticFieldLocation open$Mnbinary$Mnoutput$Mnfile;
    public static final StaticFieldLocation call$Mnwith$Mninput$Mnfile;
    public static final StaticFieldLocation call$Mnwith$Mnoutput$Mnfile;
    public static final StaticFieldLocation with$Mninput$Mnfrom$Mnfile;
    public static final StaticFieldLocation with$Mnoutput$Mnto$Mnfile;
    public static file $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new file();
        file$Mnexists$Qu = StaticFieldLocation.make("kawa.lib.files", "file$Mnexists$Qu");
        delete$Mnfile = StaticFieldLocation.make("kawa.lib.files", "delete$Mnfile");
        open$Mninput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "open$Mninput$Mnfile");
        open$Mnbinary$Mninput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "open$Mnbinary$Mninput$Mnfile");
        open$Mnoutput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "open$Mnoutput$Mnfile");
        open$Mnbinary$Mnoutput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "open$Mnbinary$Mnoutput$Mnfile");
        call$Mnwith$Mninput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "call$Mnwith$Mninput$Mnfile");
        call$Mnwith$Mnoutput$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "call$Mnwith$Mnoutput$Mnfile");
        with$Mninput$Mnfrom$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "with$Mninput$Mnfrom$Mnfile");
        with$Mnoutput$Mnto$Mnfile = StaticFieldLocation.make("kawa.lib.ports", "with$Mnoutput$Mnto$Mnfile");
        file.$runBody$();
    }

    public file() {
        ModuleInfo.register(this);
    }
}

