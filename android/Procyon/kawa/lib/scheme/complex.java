// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class complex extends ModuleBody
{
    public static final StaticFieldLocation make$Mnrectangular;
    public static final StaticFieldLocation make$Mnpolar;
    public static final StaticFieldLocation real$Mnpart;
    public static final StaticFieldLocation imag$Mnpart;
    public static final StaticFieldLocation magnitude;
    public static final StaticFieldLocation angle;
    public static complex $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        complex.$instance = new complex();
        make$Mnrectangular = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnrectangular");
        make$Mnpolar = StaticFieldLocation.make("kawa.lib.numbers", "make$Mnpolar");
        real$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "real$Mnpart");
        imag$Mnpart = StaticFieldLocation.make("kawa.lib.numbers", "imag$Mnpart");
        magnitude = StaticFieldLocation.make("kawa.lib.numbers", "magnitude");
        angle = StaticFieldLocation.make("kawa.lib.numbers", "angle");
        $runBody$();
    }
    
    public complex() {
        ModuleInfo.register(this);
    }
}
