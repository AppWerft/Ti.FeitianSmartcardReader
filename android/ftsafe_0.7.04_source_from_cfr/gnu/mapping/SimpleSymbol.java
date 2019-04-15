/*
 * Decompiled with CFR 0.139.
 */
package gnu.mapping;

import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class SimpleSymbol
extends Symbol {
    public SimpleSymbol() {
    }

    public SimpleSymbol(String key) {
        super(key, Namespace.EmptyNamespace);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((String)in.readObject()).intern();
    }

    @Override
    public Object readResolve() throws ObjectStreamException {
        return Namespace.EmptyNamespace.getSymbol(this.getName().intern());
    }
}

