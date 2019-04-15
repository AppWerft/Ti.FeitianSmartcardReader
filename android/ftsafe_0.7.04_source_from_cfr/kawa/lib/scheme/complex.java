/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib.scheme;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

public class complex
extends ModuleBody {
    public static final StaticFieldLocation make$Mnrectangular;
    public static final StaticFieldLocation make$Mnpolar;
    public static final StaticFieldLocation real$Mnpart;
    public static final StaticFieldLocation imag$Mnpart;
    public static final StaticFieldLocation magnitude;
    public static final StaticFieldLocation angle;
    public static complex $instance;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static {
        $instance = new complex();
        make$Mnrectangular = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnrectangular");
        make$Mnpolar = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnpolar");
        real$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "real$Mnpart");
        imag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "imag$Mnpart");
        magnitude = StaticFieldLocation.make("kawa.lib.numbers", "magnitude");
        angle = StaticFieldLocation.make("kawa.lib.numbers", "angle");
        complex.$runBody$();
    }

    public complex() {
        ModuleInfo.register(this);
    }
}

