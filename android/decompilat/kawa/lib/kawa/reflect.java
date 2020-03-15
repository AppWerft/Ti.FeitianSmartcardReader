// 
// Decompiled by Procyon v0.5.36
// 

package kawa.lib.kawa;

import gnu.expr.ModuleInfo;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.expr.ModuleBody;

public class reflect extends ModuleBody
{
    public static final StaticFieldLocation invoke;
    public static final StaticFieldLocation invoke$Mnstatic;
    public static final StaticFieldLocation invoke$Mnspecial;
    public static final StaticFieldLocation field;
    public static final StaticFieldLocation static$Mnfield;
    public static final StaticFieldLocation set$Mnfield$Ex;
    public static final StaticFieldLocation set$Mnstatic$Mnfield$Ex;
    public static final StaticFieldLocation make;
    public static final StaticFieldLocation instance$Qu;
    public static final StaticFieldLocation as;
    public static final StaticFieldLocation primitive$Mnthrow;
    public static reflect $instance;
    
    private static void $runBody$() {
        final CallContext $ctx;
        final Consumer $result = ($ctx = CallContext.getInstance()).consumer;
    }
    
    static {
        reflect.$instance = new reflect();
        invoke = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "invoke");
        invoke$Mnstatic = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "invokeStatic");
        invoke$Mnspecial = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "invokeSpecial");
        make = StaticFieldLocation.make("gnu.kawa.reflect.Invoke", "make");
        field = StaticFieldLocation.make("gnu.kawa.reflect.SlotGet", "field");
        static$Mnfield = StaticFieldLocation.make("gnu.kawa.reflect.SlotGet", "staticField");
        set$Mnfield$Ex = StaticFieldLocation.make("gnu.kawa.reflect.SlotSet", "set$Mnfield$Ex");
        set$Mnstatic$Mnfield$Ex = StaticFieldLocation.make("gnu.kawa.reflect.SlotSet", "set$Mnstatic$Mnfield$Ex");
        primitive$Mnthrow = StaticFieldLocation.make("gnu.kawa.reflect.Throw", "primitiveThrow");
        instance$Qu = StaticFieldLocation.make("kawa.standard.Scheme", "instanceOf");
        as = StaticFieldLocation.make("gnu.kawa.functions.Convert", "as");
        $runBody$();
    }
    
    public reflect() {
        ModuleInfo.register(this);
    }
}
