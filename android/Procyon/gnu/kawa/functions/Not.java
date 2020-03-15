// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.expr.Language;
import gnu.mapping.Procedure1;

public class Not extends Procedure1
{
    Language language;
    
    public Not(final Language language) {
        this.language = language;
        this.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplySimpleBoolean");
        this.setProperty(Procedure.compilerXKey, "gnu.kawa.functions.CompileMisc:compileNot");
    }
    
    public Not(final Language language, final String name) {
        this(language);
        this.setName(name);
    }
    
    @Override
    public Object apply1(final Object arg1) {
        return this.language.booleanObject(!this.language.isTrue(arg1));
    }
}
