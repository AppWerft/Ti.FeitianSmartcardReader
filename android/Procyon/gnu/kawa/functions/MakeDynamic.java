// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;

public class MakeDynamic extends Procedure1
{
    public static final MakeDynamic instance;
    
    @Override
    public Object apply1(final Object value) {
        return value;
    }
    
    static {
        (instance = new MakeDynamic()).setName("dynamic");
        MakeDynamic.instance.setProperty(Procedure.validateXApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakeDynamic");
        MakeDynamic.instance.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileMakeDynamic");
    }
}
