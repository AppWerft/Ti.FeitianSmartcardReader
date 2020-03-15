// 
// Decompiled by Procyon v0.5.36
// 

package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.ReferenceExp;
import gnu.lists.Pair;
import gnu.expr.Expression;
import kawa.lang.Translator;
import kawa.lang.Syntax;

public class Scan extends Syntax
{
    public static final Scan scan;
    
    @Override
    public Expression rewrite(final Object obj, final Translator tr) {
        if (Translator.listLength(obj) != 1) {
            return tr.syntaxError("'scan' requires a single argument");
        }
        final Translator.ScanContext savedScanContext = tr.getScanContext();
        if (savedScanContext == null) {
            tr.error('e', "'scan' not in a '...'- context");
        }
        try {
            tr.setScanContext(null);
            final Expression scanExp = tr.rewrite_car((Pair)obj, false);
            final Declaration paramDecl = savedScanContext.getLambda().addParameter(null);
            savedScanContext.addSeqExpression(scanExp);
            return new ReferenceExp(paramDecl);
        }
        finally {
            tr.setScanContext(savedScanContext);
        }
    }
    
    static {
        (scan = new Scan()).setName("scan");
    }
}
