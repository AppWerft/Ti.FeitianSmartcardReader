/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Target;

public interface Inlineable {
    public void compile(ApplyExp var1, Compilation var2, Target var3);
}

