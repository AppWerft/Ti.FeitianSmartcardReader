/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;

public abstract class Procedure1
extends Procedure {
    public Procedure1() {
    }

    public Procedure1(String n) {
        super(n);
    }

    @Override
    public int numArgs() {
        return 4097;
    }

    @Override
    public Object apply0() throws Throwable {
        throw new WrongArguments(this, 0);
    }

    @Override
    public abstract Object apply1(Object var1) throws Throwable;

    @Override
    public Object apply2(Object arg1, Object arg2) throws Throwable {
        throw new WrongArguments(this, 2);
    }

    @Override
    public Object apply3(Object arg1, Object arg2, Object arg3) throws Throwable {
        throw new WrongArguments(this, 3);
    }

    @Override
    public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4) throws Throwable {
        throw new WrongArguments(this, 4);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        if (args.length != 1) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply1(args[0]);
    }
}

