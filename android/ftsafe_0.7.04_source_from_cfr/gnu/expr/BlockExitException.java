/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.expr.ExitExp;

class BlockExitException
extends RuntimeException {
    ExitExp exit;
    Object result;

    public BlockExitException(ExitExp exit, Object result) {
        this.exit = exit;
        this.result = result;
    }
}

