/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;

public class IsEq
extends Procedure2 {
    Language language;

    public IsEq(Language language, String name) {
        this.language = language;
        this.setName(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileEq");
    }

    public boolean apply(Object arg1, Object arg2) {
        return arg1 == arg2;
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        return this.language.booleanObject(arg1 == arg2);
    }
}

