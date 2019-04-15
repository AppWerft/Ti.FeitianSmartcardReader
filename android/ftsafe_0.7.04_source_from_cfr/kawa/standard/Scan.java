/*
 * Decompiled with CFR 0.139.
 */
package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.ReferenceExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class Scan
extends Syntax {
    public static final Scan scan = new Scan();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Expression rewrite(Object obj, Translator tr) {
        if (Translator.listLength(obj) != 1) {
            return tr.syntaxError("'scan' requires a single argument");
        }
        Translator.ScanContext savedScanContext = tr.getScanContext();
        if (savedScanContext == null) {
            tr.error('e', "'scan' not in a '...'- context");
        }
        try {
            tr.setScanContext(null);
            Expression scanExp = tr.rewrite_car((Pair)obj, false);
            Declaration paramDecl = savedScanContext.getLambda().addParameter(null);
            savedScanContext.addSeqExpression(scanExp);
            ReferenceExp referenceExp = new ReferenceExp(paramDecl);
            return referenceExp;
        }
        finally {
            tr.setScanContext(savedScanContext);
        }
    }

    static {
        scan.setName("scan");
    }
}

