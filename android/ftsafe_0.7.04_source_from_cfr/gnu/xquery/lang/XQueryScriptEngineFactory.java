/*
 * Decompiled with CFR 0.139.
 */
package gnu.xquery.lang;

import gnu.expr.AbstractScriptEngineFactory;
import gnu.expr.Language;
import gnu.xquery.lang.XQuery;
import java.util.List;

public class XQueryScriptEngineFactory
extends AbstractScriptEngineFactory {
    public XQueryScriptEngineFactory() {
        super(XQuery.instance);
    }

    @Override
    protected void getNames(List<String> names) {
        names.add("xquery");
        names.add("qexo");
        names.add("kawa-xquery");
    }
}

