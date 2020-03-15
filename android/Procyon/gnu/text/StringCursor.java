// 
// Decompiled by Procyon v0.5.36
// 

package gnu.text;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public final class StringCursor implements Comparable, Externalizable
{
    int value;
    
    public static StringCursor valueOf(final int value) {
        final StringCursor sc = new StringCursor();
        sc.value = value;
        return sc;
    }
    
    public int getValue() {
        return this.value;
    }
    
    @Override
    public int compareTo(final Object o) {
        return this.value - ((StringCursor)o).value;
    }
    
    public static int checkStringCursor(final Object obj) {
        return (obj instanceof StringCursor) ? ((StringCursor)obj).value : -2;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeInt(this.value);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException {
        this.value = in.readInt();
    }
}
