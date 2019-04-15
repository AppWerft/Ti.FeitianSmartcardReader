/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;

public abstract class ProcedureN
extends Procedure {
    public static final Object[] noArgs = new Object[0];

    public ProcedureN() {
    }

    public ProcedureN(String n) {
        super(n);
    }

    @Override
    public Object apply0() throws Throwable {
        return this.applyN(noArgs);
    }

    @Override
    public Object apply1(Object arg1) throws Throwable {
        Object[] args = new Object[]{arg1};
        return this.applyN(args);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) throws Throwable {
        Object[] args = new Object[]{arg1, arg2};
        return this.applyN(args);
    }

    @Override
    public Object apply3(Object arg1, Object arg2, Object arg3) throws Throwable {
        Object[] args = new Object[]{arg1, arg2, arg3};
        return this.applyN(args);
    }

    @Override
    public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4) throws Throwable {
        Object[] args = new Object[]{arg1, arg2, arg3, arg4};
        return this.applyN(args);
    }

    @Override
    public abstract Object applyN(Object[] var1) throws Throwable;
}

