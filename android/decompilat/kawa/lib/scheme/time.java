// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class time extends ModuleBody
{
    public static final StaticFieldLocation current$Mnsecond;
    public static final StaticFieldLocation current$Mnjiffy;
    public static final StaticFieldLocation jiffies$Mnper$Mnsecond;
    public static time $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        time.$instance = new time();
        current$Mnsecond = StaticFieldLocation.make("kawa.lib.system", "current$Mnsecond");
        current$Mnjiffy = StaticFieldLocation.make("kawa.lib.system", "current$Mnjiffy");
        jiffies$Mnper$Mnsecond = StaticFieldLocation.make("kawa.lib.system", "jiffies$Mnper$Mnsecond");
        $runBody$();
    }
    
    public time() {
        ModuleInfo.register(this);
    }
}
