/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;

public abstract class Procedure3
extends Procedure {
    public Procedure3() {
    }

    public Procedure3(String n) {
        super(n);
    }

    @Override
    public int numArgs() {
        return 12291;
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
    public abstract Object apply3(Object var1, Object var2, Object var3) throws Throwable;

    @Override
    public Object apply4(Object arg1, Object arg2, Object arg3, Object arg4) {
        throw new WrongArguments(this, 4);
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        if (args.length != 3) {
            throw new WrongArguments(this, args.length);
        }
        return this.apply3(args[0], args[1], args[2]);
    }
}

