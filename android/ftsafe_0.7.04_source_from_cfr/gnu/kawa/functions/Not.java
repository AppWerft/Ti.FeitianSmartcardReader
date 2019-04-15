/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.mapping.Symbol;

public class Not
extends Procedure1 {
    Language language;

    public Not(Language language) {
        this.language = language;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileNot");
    }

    public Not(Language language, String name) {
        this(language);
        this.setName(name);
    }

    @Override
    public Object apply1(Object arg1) {
        return this.language.booleanObject(!this.language.isTrue(arg1));
    }
}

