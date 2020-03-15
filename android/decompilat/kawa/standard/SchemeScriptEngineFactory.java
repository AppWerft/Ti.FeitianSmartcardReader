// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import java.util.List;
import gnu.expr.Language;
import gnu.expr.AbstractScriptEngineFactory;

public class SchemeScriptEngineFactory extends AbstractScriptEngineFactory
{
    public SchemeScriptEngineFactory() {
        super(Scheme.instance);
    }
    
    @Override
    protected void getNames(final List<String> names) {
        names.add("scheme");
        names.add("kawa");
        names.add("kawa-scheme");
    }
}
