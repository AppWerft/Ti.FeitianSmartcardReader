// 
// Decompiled by Procyon v0.5.36
// 

package gnu.kawa.xml;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;

public class NodeSetType extends OccurrenceType
{
    public NodeSetType(final Type itemType) {
        super(itemType, 0, -1);
    }
    
    public static Type getInstance(final Type base) {
        return new NodeSetType(base);
    }
    
    @Override
    public String toString() {
        return super.toString() + "node-set";
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.getBase());
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.setBase((Type)in.readObject());
    }
}
