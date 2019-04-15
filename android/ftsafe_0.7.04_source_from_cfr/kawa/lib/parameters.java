/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.ApplyToArgs;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.LocationProc;
import gnu.mapping.Procedure;
import gnu.mapping.Promise;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

public class parameters
extends ModuleBody {
    public static final ModuleMethod make$Mnparameter;
    public static final ModuleMethod as$Mnlocation$Pc;
    public static parameters $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;

    private static void $runBody$() {
        CallContext $ctx = CallContext.getInstance();
        Consumer $result = $ctx.consumer;
    }

    public static LocationProc makeParameter(Object object2) {
        return parameters.makeParameter(object2, null);
    }

    public static LocationProc makeParameter(Object init, Object converter) {
        if (converter != null) {
            init = ((Procedure)Scheme.applyToArgs).apply2(converter, init);
        }
        ThreadLocation<Object> loc = new ThreadLocation<Object>();
        loc.setGlobal(init);
        Object object2 = Promise.force(converter, Procedure.class);
        try {
            return new LocationProc(loc, (Procedure)object2);
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.mapping.LocationProc.<init>(gnu.mapping.Location,gnu.mapping.Procedure)", 2, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Location asLocation$Pc(Object param) {
        Location location2;
        if (!(param instanceof LocationProc)) {
            location2 = (Location)Promise.force(param, Location.class);
            return location2;
        }
        Object object2 = Promise.force(param, LocationProc.class);
        try {
            location2 = ((LocationProc)object2).getLocation();
            return location2;
        }
        catch (ClassCastException classCastException) {
            throw new WrongType(classCastException, "gnu.mapping.LocationProc.getLocation()", 1, object2);
        }
    }

    public static {
        Lit1 = Symbol.valueOf("as-location%");
        Lit0 = Symbol.valueOf("make-parameter");
        parameters parameters2 = $instance = new parameters();
        make$Mnparameter = new ModuleMethod(parameters2, 1, Lit0, 8193);
        as$Mnlocation$Pc = new ModuleMethod(parameters2, 3, Lit1, 4097);
        parameters.$runBody$();
    }

    public parameters() {
        ModuleInfo.register(this);
    }

    public int match1(ModuleMethod moduleMethod, Object object2, CallContext callContext) {
        switch (moduleMethod.selector) {
            case 3: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
            case 1: {
                callContext.value1 = object2;
                callContext.proc = moduleMethod;
                callContext.pc = 1;
                return 0;
            }
        }
        return super.match1(moduleMethod, object2, callContext);
    }

    public int match2(ModuleMethod moduleMethod, Object object2, Object object3, CallContext callContext) {
        if (moduleMethod.selector == 1) {
            callContext.value1 = object2;
            callContext.value2 = object3;
            callContext.proc = moduleMethod;
            callContext.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, object2, object3, callContext);
    }

    public void apply(CallContext callContext) {
        ModuleMethod.applyError();
    }

    public Object apply1(ModuleMethod moduleMethod, Object object2) {
        switch (moduleMethod.selector) {
            case 1: {
                return parameters.makeParameter(object2);
            }
            case 3: {
                return parameters.asLocation$Pc(object2);
            }
        }
        return super.apply1(moduleMethod, object2);
    }

    public Object apply2(ModuleMethod moduleMethod, Object object2, Object object3) {
        if (moduleMethod.selector == 1) {
            return parameters.makeParameter(object2, object3);
        }
        return super.apply2(moduleMethod, object2, object3);
    }
}

