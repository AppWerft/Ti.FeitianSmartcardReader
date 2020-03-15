// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class repl extends ModuleBody
{
    public static final StaticFieldLocation interaction$Mnenvironment;
    public static repl $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        repl.$instance = new repl();
        interaction$Mnenvironment = StaticFieldLocation.make("kawa.lib.misc", "interaction$Mnenvironment");
        $runBody$();
    }
    
    public repl() {
        ModuleInfo.register(this);
    }
}
