// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class process-context extends ModuleBody
{
    public static final StaticFieldLocation command$Mnline;
    public static final StaticFieldLocation exit;
    public static final StaticFieldLocation emergency$Mnexit;
    public static final StaticFieldLocation get$Mnenvironment$Mnvariable;
    public static final StaticFieldLocation get$Mnenvironment$Mnvariables;
    public static process-context $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        process-context.$instance = new process-context();
        command$Mnline = StaticFieldLocation.make("kawa.lib.rnrs.programs", "command$Mnline");
        exit = StaticFieldLocation.make("kawa.lib.rnrs.programs", "exit");
        emergency$Mnexit = StaticFieldLocation.make("kawa.lib.rnrs.programs", "emergency$Mnexit");
        get$Mnenvironment$Mnvariable = StaticFieldLocation.make("kawa.lib.system", "get$Mnenvironment$Mnvariable");
        get$Mnenvironment$Mnvariables = StaticFieldLocation.make("kawa.lib.system", "get$Mnenvironment$Mnvariables");
        $runBody$();
    }
    
    public process-context() {
        ModuleInfo.register(this);
    }
}
