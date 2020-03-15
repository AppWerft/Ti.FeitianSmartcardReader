// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class load extends ModuleBody
{
    public static final StaticFieldLocation load;
    public static load $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        kawa.lib.scheme.load.$instance = new load();
        load = StaticFieldLocation.make("kawa.standard.load", "load");
        $runBody$();
    }
    
    public load() {
        ModuleInfo.register(this);
    }
}
