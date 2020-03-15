// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.lispexpr;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.mapping.WrappedException;
import gnu.bytecode.Type;
import gnu.kawa.functions.GetNamedPart;
import gnu.bytecode.ClassType;
import java.io.Externalizable;
import gnu.mapping.Namespace;

public class ClassNamespace extends Namespace implements Externalizable
{
    ClassType ctype;
    
    public ClassType getClassType() {
        return this.ctype;
    }
    
    public static ClassNamespace getInstance(final String name, final ClassType ctype) {
        synchronized (ClassNamespace.nsTable) {
            final Object old = ClassNamespace.nsTable.get(name);
            if (old instanceof ClassNamespace) {
                return (ClassNamespace)old;
            }
            final ClassNamespace ns = new ClassNamespace(ctype);
            ClassNamespace.nsTable.put(name, ns);
            return ns;
        }
    }
    
    public ClassNamespace() {
    }
    
    public ClassNamespace(final ClassType ctype) {
        this.setName("class:" + ctype.getName());
        this.ctype = ctype;
    }
    
    @Override
    public Object get(final String name) {
        try {
            return GetNamedPart.getTypePart(this.ctype, name);
        }
        catch (Throwable ex) {
            throw WrappedException.rethrow(ex);
        }
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.ctype);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.ctype = (ClassType)in.readObject();
        this.setName("class:" + this.ctype.getName());
    }
    
    @Override
    public Object readResolve() throws ObjectStreamException {
        final String name = this.getName();
        if (name != null) {
            final Namespace ns = ClassNamespace.nsTable.get(name);
            if (ns instanceof ClassNamespace) {
                return ns;
            }
            ClassNamespace.nsTable.put(name, this);
        }
        return this;
    }
}
