// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ModuleInfo;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.mapping.Location;
import gnu.mapping.Promise;
import gnu.mapping.Procedure;
import gnu.mapping.ThreadLocation;
import kawa.standard.Scheme;
import gnu.mapping.LocationProc;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.expr.ModuleMethod;
import gnu.expr.ModuleBody;

public class parameters extends ModuleBody
{
    public static final ModuleMethod make$Mnparameter;
    public static final ModuleMethod as$Mnlocation$Pc;
    public static parameters $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    public static LocationProc makeParameter(final Object init) {
        return makeParameter(init, null);
    }
    
    public static LocationProc makeParameter(Object init, final Object converter) {
        if (converter != null) {
            init = Scheme.applyToArgs.apply2(converter, init);
        }
        final ThreadLocation loc = new ThreadLocation();
        loc.setGlobal(init);
        final ThreadLocation loc2 = loc;
        final Object force = Promise.force(converter, Procedure.class);
        try {
            return new LocationProc(loc2, (Procedure)force);
        }
        catch (ClassCastException ex) {
            throw new WrongType(ex, "gnu.mapping.LocationProc.<init>(gnu.mapping.Location,gnu.mapping.Procedure)", 2, force);
        }
    }
    
    public static Location asLocation$Pc(final Object param) {
        Label_0024: {
            if (!(param instanceof LocationProc)) {
                break Label_0024;
            }
            final Object force = Promise.force(param, LocationProc.class);
            try {
                return ((LocationProc)force).getLocation();
                location = (Location)Promise.force(param, Location.class);
                return location;
            }
            catch (ClassCastException ex) {
                throw new WrongType(ex, "gnu.mapping.LocationProc.getLocation()", 1, force);
            }
        }
    }
    
    static {
        Lit1 = Symbol.valueOf("as-location%");
        Lit0 = Symbol.valueOf("make-parameter");
        parameters.$instance = new parameters();
        final parameters $instance = parameters.$instance;
        make$Mnparameter = new ModuleMethod($instance, 1, parameters.Lit0, 8193);
        as$Mnlocation$Pc = new ModuleMethod($instance, 3, parameters.Lit1, 4097);
        $runBody$();
    }
    
    public parameters() {
        ModuleInfo.register(this);
    }
    
    @Override
    public int match1(final ModuleMethod proc, final Object arg1, final CallContext ctx) {
        switch (proc.selector) {
            case 3: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            case 1: {
                ctx.value1 = arg1;
                ctx.proc = proc;
                ctx.pc = 1;
                return 0;
            }
            default: {
                return super.match1(proc, arg1, ctx);
            }
        }
    }
    
    @Override
    public int match2(final ModuleMethod moduleMethod, final Object o, final Object o2, final CallContext ctx) {
        if (moduleMethod.selector == 1) {
            ctx.value1 = o;
            ctx.value2 = o2;
            ctx.proc = moduleMethod;
            ctx.pc = 2;
            return 0;
        }
        return super.match2(moduleMethod, o, o2, ctx);
    }
    
    @Override
    public void apply(final CallContext callContext) {
        final int pc = callContext.pc;
        ModuleMethod.applyError();
    }
    
    @Override
    public Object apply1(final ModuleMethod method, final Object o) {
        switch (method.selector) {
            case 1: {
                return makeParameter(o);
            }
            case 3: {
                return asLocation$Pc(o);
            }
            default: {
                return super.apply1(method, o);
            }
        }
    }
    
    @Override
    public Object apply2(final ModuleMethod method, final Object o, final Object o2) {
        if (method.selector == 1) {
            return makeParameter(o, o2);
        }
        return super.apply2(method, o, o2);
    }
}
