// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class EofClass implements Externalizable
{
    public static final EofClass eofValue;
    
    @Override
    public final String toString() {
        return "#!eof";
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
    }
    
    public Object readResolve() throws ObjectStreamException {
        return Sequence.eofValue;
    }
    
    static {
        eofValue = new EofClass();
    }
}
