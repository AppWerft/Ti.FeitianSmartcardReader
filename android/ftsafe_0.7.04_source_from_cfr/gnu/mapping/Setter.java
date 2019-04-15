/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;

public class Setter
extends ProcedureN {
    protected Procedure getter;

    public Setter(Procedure getter) {
        this.getter = getter;
        String name = getter.getName();
        if (name != null) {
            this.setName("(setter " + name + ")");
        }
    }

    @Override
    public int numArgs() {
        int get_args = this.getter.numArgs();
        if (get_args < 0) {
            return get_args + 1;
        }
        return get_args + 4097;
    }

    @Override
    public Object applyN(Object[] args) throws Throwable {
        this.getter.setN(args);
        return Values.empty;
    }
}

