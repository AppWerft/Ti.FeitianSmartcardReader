/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;

public abstract class Procedure2
extends Procedure {
    public Procedure2(String n) {
        super(n);
    }

    public Procedure2() {
    }

    @Override
    public int numArgs() {
        return 8194;
    }

    @Override
    public Object apply0() throws Throwable {
        throw new WrongArguments(this.getName(), 2, "(?)");
    }

    @Override
    public Object apply1(Object arg1) throws Throwable {
        throw new WrongArguments(this, 1);
    }

    @Override
    public abstract Object apply2(Object var1, Object var2) throws Throwable;

    @Override
    public Object apply3(Object arg1, Object arg2, Object arg3) {
        throw new WrongArguments(this, 3);
    }

    @Override
    public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4) throws Throwable {
        throw new WrongArguments(this, 4);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        if (args.length != 2) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply2(args[0], args[1]);
    }
}

