// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class read extends ModuleBody
{
    public static final StaticFieldLocation read;
    public static read $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        kawa.lib.scheme.read.$instance = new read();
        read = StaticFieldLocation.make("kawa.lib.ports", "read");
        $runBody$();
    }
    
    public read() {
        ModuleInfo.register(this);
    }
}
