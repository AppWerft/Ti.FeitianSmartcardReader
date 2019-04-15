/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.AbstractScriptEngineFactory;
import gnu.expr.Language;
import java.util.List;
import kawa.standard.Scheme;

public class SchemeScriptEngineFactory
extends AbstractScriptEngineFactory {
    public SchemeScriptEngineFactory() {
        super(Scheme.instance);
    }

    @Override
    protected void getNames(List<String> names) {
        names.add("scheme");
        names.add("kawa");
        names.add("kawa-scheme");
    }
}

