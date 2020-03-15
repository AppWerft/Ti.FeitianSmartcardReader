// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.mapping.Promise;
import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.mapping.Procedure2;

public class IsEqv extends Procedure2
{
    Language language;
    IsEq isEq;
    
    public IsEqv(final Language language, final String name, final IsEq isEq) {
        this.language = language;
        this.isEq = isEq;
        this.setName(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateIsEqv");
    }
    
    public static boolean apply(Object arg1, Object arg2) {
        arg1 = Promise.force(arg1);
        arg2 = Promise.force(arg2);
        if (arg1 == arg2) {
            return true;
        }
        if (arg1 instanceof Number && arg2 instanceof Number) {
            return IsEqual.numberEquals((Number)arg1, (Number)arg2);
        }
        return (arg1 instanceof Char || arg1 instanceof Boolean || arg1 instanceof Symbol) && arg1.equals(arg2);
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        return this.language.booleanObject(apply(arg1, arg2));
    }
}
