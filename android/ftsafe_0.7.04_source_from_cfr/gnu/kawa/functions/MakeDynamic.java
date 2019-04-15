/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Symbol;

public class MakeDynamic
extends Procedure1 {
    public static final MakeDynamic instance = new MakeDynamic();

    @Override
    public Object apply1(Object value) {
        return value;
    }

    static {
        instance.setName("dynamic");
        instance.setProperty(Procedure.validateXApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMakeDynamic");
        instance.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileMakeDynamic");
    }
}

