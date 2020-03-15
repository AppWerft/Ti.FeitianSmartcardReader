// 
// Decompiled by Procyon v0.5.36
// 

package gnu.xquery.lang;

import java.util.List;
import gnu.expr.Language;
import gnu.expr.AbstractScriptEngineFactory;

public class XQueryScriptEngineFactory extends AbstractScriptEngineFactory
{
    public XQueryScriptEngineFactory() {
        super(XQuery.instance);
    }
    
    @Override
    protected void getNames(final List<String> names) {
        names.add("xquery");
        names.add("qexo");
        names.add("kawa-xquery");
    }
}
