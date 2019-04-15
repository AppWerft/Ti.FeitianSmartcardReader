/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqual;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Promise;
import gnu.mapping.Symbol;
import gnu.text.Char;

public class IsEqv
extends Procedure2 {
    Language language;
    IsEq isEq;

    public IsEqv(Language language, String name, IsEq isEq) {
        this.language = language;
        this.isEq = isEq;
        this.setName(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateIsEqv");
    }

    public static boolean apply(Object arg1, Object arg2) {
        if ((arg1 = Promise.force(arg1)) == (arg2 = Promise.force(arg2))) {
            return true;
        }
        if (arg1 instanceof Number && arg2 instanceof Number) {
            return IsEqual.numberEquals((Number)arg1, (Number)arg2);
        }
        if (arg1 instanceof Char || arg1 instanceof Boolean || arg1 instanceof Symbol) {
            return arg1.equals(arg2);
        }
        return false;
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        return this.language.booleanObject(IsEqv.apply(arg1, arg2));
    }
}

