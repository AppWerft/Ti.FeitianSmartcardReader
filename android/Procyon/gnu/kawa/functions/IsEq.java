// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.mapping.Procedure2;

public class IsEq extends Procedure2
{
    Language language;
    
    public IsEq(final Language language, final String name) {
        this.language = language;
        this.setName(name);
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileEq");
    }
    
    public boolean apply(final Object arg1, final Object arg2) {
        return arg1 == arg2;
    }
    
    @Override
    public Object apply2(final Object arg1, final Object arg2) {
        return this.language.booleanObject(arg1 == arg2);
    }
}
