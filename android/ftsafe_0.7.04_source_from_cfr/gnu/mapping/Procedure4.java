/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;

public abstract class Procedure4
extends Procedure {
    public Procedure4() {
    }

    public Procedure4(String n) {
        super(n);
    }

    @Override
    public int numArgs() {
        return 16388;
    }

    @Override
    public Object apply0() {
        throw new WrongArguments(this, 0);
    }

    @Override
    public Object apply1(Object arg1) {
        throw new WrongArguments(this, 1);
    }

    @Override
    public Object apply2(Object arg1, Object arg2) {
        throw new WrongArguments(this, 2);
    }

    @Override
    public Object apply3(Object arg1, Object arg2, Object arg3) {
        throw new WrongArguments(this, 3);
    }

    @Override
    public abstract Object apply4(Object var1, Object var2, Object var3, Object var4) throws Throwable;

    @Override
    public Object applyN(Object[] args) throws Throwable {
        if (args.length != 4) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply4(args[0], args[1], args[2], args[3]);
    }
}

