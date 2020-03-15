// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class write extends ModuleBody
{
    public static final StaticFieldLocation write$Mnsimple;
    public static final StaticFieldLocation write;
    public static final StaticFieldLocation write$Mnshared;
    public static final StaticFieldLocation display;
    public static write $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        kawa.lib.scheme.write.$instance = new write();
        write$Mnsimple = StaticFieldLocation.make("kawa.lib.ports", "write$Mnsimple");
        write = StaticFieldLocation.make("kawa.lib.ports", "write");
        write$Mnshared = StaticFieldLocation.make("kawa.lib.ports", "write$Mnshared");
        display = StaticFieldLocation.make("kawa.lib.ports", "display");
        $runBody$();
    }
    
    public write() {
        ModuleInfo.register(this);
    }
}
