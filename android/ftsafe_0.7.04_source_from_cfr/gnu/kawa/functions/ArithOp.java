/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.functions;

import gnu.mapping.ProcedureN;
import gnu.math.IntNum;

public abstract class ArithOp
extends ProcedureN {
    static final int ADD = 1;
    static final int SUB = 2;
    static final int MUL = 3;
    public static final int DIVIDE_GENERIC = 4;
    public static final int DIVIDE_INEXACT = 5;
    public static final int QUOTIENT = 6;
    public static final int QUOTIENT_EXACT = 7;
    public static final int MODULO = 8;
    public static final int ASHIFT_GENERAL = 9;
    public static final int ASHIFT_LEFT = 10;
    public static final int ASHIFT_RIGHT = 11;
    public static final int LSHIFT_RIGHT = 12;
    public static final int AND = 13;
    public static final int IOR = 14;
    public static final int XOR = 15;
    public static final int NOT = 16;
    final int op;

    public ArithOp(String name, int op) {
        super(name);
        this.op = op;
    }

    public Object defaultResult() {
        return IntNum.zero();
    }

    @Override
    public boolean isSideEffectFree() {
        return true;
    }
}

