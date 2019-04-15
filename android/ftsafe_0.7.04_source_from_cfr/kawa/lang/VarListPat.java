/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.lists.Consumer;
import gnu.lists.Pair;
import kawa.lang.Pattern;

public class VarListPat
extends Pattern {
    int min_length;

    public VarListPat(int min) {
        this.min_length = min;
    }

    @Override
    public boolean match(Object obj, Object[] vars, int start_vars) {
        for (int i = 0; i < this.min_length; ++i) {
            if (!(obj instanceof Pair)) {
                return false;
            }
            Pair p = (Pair)obj;
            vars[start_vars + i] = p.getCar();
            obj = p.getCdr();
        }
        vars[start_vars + i] = obj;
        return true;
    }

    @Override
    public int varCount() {
        return this.min_length + 1;
    }

    @Override
    public void print(Consumer out) {
        out.write("#<varlist-pattern min:");
        out.writeInt(this.min_length);
        out.write(62);
    }
}

