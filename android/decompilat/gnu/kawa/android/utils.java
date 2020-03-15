// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.android;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import kawa.lib.parameters;
import gnu.mapping.CallContext;
import gnu.mapping.LocationProc;
import gnu.expr.ModuleBody;

public class utils extends ModuleBody
{
    public static final LocationProc current$Mnactivity;
    public static utils $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        current$Mnactivity = parameters.makeParameter(null);
    }
    
    static {
        utils.$instance = new utils();
        $runBody$();
    }
    
    public utils() {
        ModuleInfo.register(this);
    }
}
