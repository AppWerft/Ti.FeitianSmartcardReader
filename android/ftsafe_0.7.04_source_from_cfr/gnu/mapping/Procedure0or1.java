/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;

public abstract class Procedure0or1
extends Procedure {
    public Procedure0or1() {
    }

    public Procedure0or1(String n) {
        super(n);
    }

    @Override
    public int numArgs() {
        return 4096;
    }

    @Override
    public abstract Object apply0() throws Throwable;

    @Override
    public abstract Object apply1(Object var1) throws Throwable;

    @Override
    public Object apply2(Object arg1, Object arg2) {
        throw new WrongArguments(this, 2);
    }

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
        if (args.length == 0) {
            return this.apply0();
        }
        if (args.length == 1) {
            return this.apply1(args[0]);
        }
        throw new WrongArguments(this, args.length);
    }
}

