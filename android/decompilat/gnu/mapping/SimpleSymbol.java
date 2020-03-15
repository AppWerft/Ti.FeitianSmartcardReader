// 
// Decompiled by Procyon v0.5.36
// 

package gnu.mapping;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;

public class SimpleSymbol extends Symbol
{
    public SimpleSymbol() {
    }
    
    public SimpleSymbol(final String key) {
        super(key, Namespace.EmptyNamespace);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((String)in.readObject()).intern();
    }
    
    @Override
    public Object readResolve() throws ObjectStreamException {
        return Namespace.EmptyNamespace.getSymbol(this.getName().intern());
    }
}
