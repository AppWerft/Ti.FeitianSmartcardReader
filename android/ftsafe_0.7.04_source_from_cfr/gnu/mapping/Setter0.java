/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.Setter;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;

public class Setter0
extends Setter {
    public Setter0(Procedure getter) {
        super(getter);
    }

    @Override
    public int numArgs() {
        return 4097;
    }

    @Override
    public Object apply1(Object result) throws Throwable {
        this.getter.set0(result);
        return Values.empty;
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        int nargs = args.length;
        if (nargs != 1) {
            throw new WrongArguments(this, nargs);
        }
        this.getter.set0(args[0]);
        return Values.empty;
    }
}

