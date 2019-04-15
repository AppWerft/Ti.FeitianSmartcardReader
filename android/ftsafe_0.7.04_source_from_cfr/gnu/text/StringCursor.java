/*
 * Decompiled with CFR 0.139.
 */
package gnu.text;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class StringCursor
implements Comparable,
Externalizable {
    int value;

    public static StringCursor valueOf(int value) {
        StringCursor sc = new StringCursor();
        sc.value = value;
        return sc;
    }

    public int getValue() {
        return this.value;
    }

    public int compareTo(Object o) {
        return this.value - ((StringCursor)o).value;
    }

    public static int checkStringCursor(Object obj) {
        return obj instanceof StringCursor ? ((StringCursor)obj).value : -2;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        this.value = in.readInt();
    }
}

