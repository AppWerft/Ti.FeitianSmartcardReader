/*
 * Decompiled with CFR 0.139.
 */
package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.kawa.functions.GetNamedPart;
import gnu.mapping.Namespace;
import gnu.mapping.WrappedException;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;

public class ClassNamespace
extends Namespace
implements Externalizable {
    ClassType ctype;

    public ClassType getClassType() {
        return this.ctype;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ClassNamespace getInstance(String name, ClassType ctype) {
        Hashtable hashtable2 = nsTable;
        synchronized (hashtable2) {
            Object old = nsTable.get(name);
            if (old instanceof ClassNamespace) {
                return (ClassNamespace)old;
            }
            ClassNamespace ns = new ClassNamespace(ctype);
            nsTable.put(name, ns);
            return ns;
        }
    }

    public ClassNamespace() {
    }

    public ClassNamespace(ClassType ctype) {
        this.setName("class:" + ctype.getName());
        this.ctype = ctype;
    }

    @Override
    public Object get(String name) {
        try {
            return GetNamedPart.getTypePart(this.ctype, name);
        }
        catch (Throwable ex) {
            throw WrappedException.rethrow(ex);
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.ctype);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.ctype = (ClassType)in.readObject();
        this.setName("class:" + this.ctype.getName());
    }

    @Override
    public Object readResolve() throws ObjectStreamException {
        String name = this.getName();
        if (name != null) {
            Namespace ns = (Namespace)nsTable.get(name);
            if (ns instanceof ClassNamespace) {
                return ns;
            }
            nsTable.put(name, this);
        }
        return this;
    }
}

