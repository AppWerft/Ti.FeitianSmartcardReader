/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kawa.lang.Pattern;

public class AnyPat
extends Pattern
implements Printable,
Externalizable {
    public static AnyPat make() {
        return new AnyPat();
    }

    @Override
    public void print(Consumer out) {
        out.write("#<match any>");
    }

    @Override
    public boolean match(Object obj, Object[] vars, int start_vars) {
        vars[start_vars] = obj;
        return true;
    }

    @Override
    public int varCount() {
        return 1;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    }
}

