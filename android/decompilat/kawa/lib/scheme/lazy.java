// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class lazy extends ModuleBody
{
    public static final StaticFieldLocation promise$Qu;
    public static final StaticFieldLocation make$Mnpromise;
    public static final StaticFieldLocation force;
    public static final StaticFieldLocation delay;
    public static final StaticFieldLocation delay$Mnforce;
    public static lazy $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        lazy.$instance = new lazy();
        promise$Qu = StaticFieldLocation.make("kawa.lib.misc", "promise$Qu");
        make$Mnpromise = StaticFieldLocation.make("kawa.lib.misc", "make$Mnpromise");
        force = StaticFieldLocation.make("kawa.lib.misc", "force");
        delay = StaticFieldLocation.make("kawa.lib.std_syntax", "delay");
        delay$Mnforce = StaticFieldLocation.make("kawa.lib.std_syntax", "delay$Mnforce");
        $runBody$();
    }
    
    public lazy() {
        ModuleInfo.register(this);
    }
}
