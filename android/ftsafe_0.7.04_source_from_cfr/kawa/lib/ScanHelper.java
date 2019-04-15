/*
 * Decompiled with CFR 0.139.
 */
package kawa.lib;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;

public abstract class ScanHelper {
    public Compilation comp;

    public abstract void init(Expression var1);

    public abstract Expression test();

    public abstract Declaration eval();

    public Expression incr(Declaration value) {
        return QuoteExp.voidExp;
    }
}

