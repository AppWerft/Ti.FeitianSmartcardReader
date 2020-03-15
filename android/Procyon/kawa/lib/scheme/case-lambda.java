// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.scheme;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class case-lambda extends ModuleBody
{
    public static final StaticFieldLocation case$Mnlambda;
    public static case-lambda $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        case-lambda.$instance = new case-lambda();
        case$Mnlambda = StaticFieldLocation.make("kawa.lib.syntax", "case$Mnlambda");
        $runBody$();
    }
    
    public case-lambda() {
        ModuleInfo.register(this);
    }
}
