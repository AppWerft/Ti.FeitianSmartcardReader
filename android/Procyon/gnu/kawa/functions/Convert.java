// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.bytecode.Type;
import gnu.mapping.Procedure2;

public class Convert extends Procedure2
{
    boolean lenient;
    public static final Convert as;
    public static final Convert cast;
    
    public Convert(final String name, final boolean lenient) {
        super(name);
        this.lenient = lenient;
    }
    
    public static Convert getInstance() {
        return Convert.as;
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        Type type;
        if (arg1 instanceof Class) {
            type = Type.make((Class)arg1);
        }
        else {
            type = (Type)arg1;
        }
        return type.coerceFromObject(arg2);
    }
    
    static {
        (as = new Convert("as", true)).setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConvert");
        Convert.as.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileConvert");
        (cast = new Convert("cast", false)).setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConvert");
        Convert.cast.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileConvert");
    }
}
