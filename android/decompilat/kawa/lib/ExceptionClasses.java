// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.expr.ModuleBody;

public class ExceptionClasses extends ModuleBody
{
    public static ThreadLocal<HandlerLink> current$Mnhandler;
    public static final Class HandlerLink;
    public static final Class ExceptionWithValue;
    public static ExceptionClasses $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
        ExceptionClasses.current$Mnhandler = new ThreadLocal<HandlerLink>();
    }
    
    static {
        ExceptionClasses.$instance = new ExceptionClasses();
        HandlerLink = HandlerLink.class;
        ExceptionWithValue = ExceptionWithValue.class;
        $runBody$();
    }
    
    public ExceptionClasses() {
        ModuleInfo.register(this);
    }
}
