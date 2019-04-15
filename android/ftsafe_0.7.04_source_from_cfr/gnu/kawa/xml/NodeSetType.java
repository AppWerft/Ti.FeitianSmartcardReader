/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class NodeSetType
extends OccurrenceType {
    public NodeSetType(Type itemType) {
        super(itemType, 0, -1);
    }

    public static Type getInstance(Type base2) {
        return new NodeSetType(base2);
    }

    @Override
    public String toString() {
        return super.toString() + "node-set";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getBase());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.setBase((Type)in.readObject());
    }
}

