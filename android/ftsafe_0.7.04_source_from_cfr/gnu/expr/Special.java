/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import gnu.kawa.format.Printable;
import gnu.lists.Consumer;
import gnu.lists.Sequence;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class Special
implements Printable,
Externalizable {
    private String name;
    public static final Special undefined = new Special("undefined");
    public static final Special optional = new Special("optional");
    public static final Special rest = new Special("rest");
    public static final Special key = new Special("key");
    public static final Special dfault = new Special("default");
    public static final Special abstractSpecial = new Special("abstract");
    public static final Special nativeSpecial = new Special("native");
    public static final Object eof = Sequence.eofValue;
    public static final RuntimeException reachedUnexpected = new RuntimeException("not supposed to reach this point");

    public Special() {
    }

    private Special(String n) {
        this.name = new String(n);
    }

    public static Special make(String name) {
        if (name == "optional") {
            return optional;
        }
        if (name == "rest") {
            return rest;
        }
        if (name == "key") {
            return key;
        }
        if (name == "default") {
            return dfault;
        }
        return new Special(name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public final String toString() {
        return "#!" + this.name;
    }

    @Override
    public void print(Consumer out) {
        out.write("#!");
        out.write(this.name);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
    }

    public Object readResolve() throws ObjectStreamException {
        return Special.make(this.name);
    }
}

