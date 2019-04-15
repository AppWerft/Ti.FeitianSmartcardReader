/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.Setter;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;

public class Setter1
extends Setter {
    public Setter1(Procedure getter) {
        super(getter);
    }

    @Override
    public int numArgs() {
        return 8194;
    }

    @Override
    public Object apply2(Object arg, Object value) throws Throwable {
        this.getter.set1(arg, value);
        return Values.empty;
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        int nargs = args.length;
        if (nargs != 2) {
            throw new WrongArguments(this, nargs);
        }
        this.getter.set1(args[0], args[1]);
        return Values.empty;
    }
}

