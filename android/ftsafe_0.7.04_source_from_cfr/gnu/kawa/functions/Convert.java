/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;

public class Convert
extends Procedure2 {
    boolean lenient;
    public static final Convert as = new Convert("as", true);
    public static final Convert cast;

    public Convert(String name, boolean lenient) {
        super(name);
        this.lenient = lenient;
    }

    public static Convert getInstance() {
        return as;
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        Type type = arg1 instanceof Class ? Type.make((Class)arg1) : (Type)arg1;
        return type.coerceFromObject(arg2);
    }

    static {
        as.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConvert");
        as.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileConvert");
        cast = new Convert("cast", false);
        cast.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConvert");
        cast.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileConvert");
    }
}

