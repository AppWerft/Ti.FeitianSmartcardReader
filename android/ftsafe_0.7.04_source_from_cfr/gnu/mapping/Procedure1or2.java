/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;

public abstract class Procedure1or2
extends Procedure {
    public Procedure1or2() {
    }

    public Procedure1or2(String n) {
        super(n);
    }

    @Override
    public int numArgs() {
        return 8193;
    }

    @Override
    public Object apply0() {
        throw new WrongArguments(this, 0);
    }

    @Override
    public abstract Object apply1(Object var1) throws Throwable;

    @Override
    public abstract Object apply2(Object var1, Object var2) throws Throwable;

    @Override
    public Object apply3(Object arg1, Object arg2, Object arg3) {
        throw new WrongArguments(this, 3);
    }

    @Override
    public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4) {
        throw new WrongArguments(this, 4);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        if (args.length == 1) {
            return this.apply1(args[0]);
        }
        if (args.length == 2) {
            return this.apply2(args[0], args[1]);
        }
        throw new WrongArguments(this, args.length);
    }
}

