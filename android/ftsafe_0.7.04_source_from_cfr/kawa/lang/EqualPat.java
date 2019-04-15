/*
 * Decompiled with CFR 0.139.
 */
package kawa.lang;

import gnu.kawa.format.Printable;
import gnu.kawa.format.ReportFormat;
import gnu.lists.Consumer;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kawa.lang.Pattern;

public class EqualPat
extends Pattern
implements Printable,
Externalizable {
    Object value;

    public EqualPat() {
    }

    public EqualPat(Object obj) {
        this.value = obj;
    }

    public static EqualPat make(Object obj) {
        return new EqualPat(obj);
    }

    @Override
    public boolean match(Object obj, Object[] vars, int start_vars) {
        if (this.value instanceof String && obj instanceof Symbol) {
            obj = ((Symbol)obj).getName();
        }
        return this.value.equals(obj);
    }

    @Override
    public int varCount() {
        return 0;
    }

    @Override
    public void print(Consumer out) {
        out.write("#<equals: ");
        ReportFormat.print(this.value, out);
        out.write(62);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.value = in.readObject();
    }
}

