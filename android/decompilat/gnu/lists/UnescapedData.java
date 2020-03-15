// 
// Decompiled by Procyon v0.5.36
// 

package gnu.lists;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class UnescapedData implements CharSequence, Externalizable
{
    String data;
    
    public UnescapedData() {
    }
    
    public UnescapedData(final String data) {
        this.data = data;
    }
    
    public final String getData() {
        return this.data;
    }
    
    @Override
    public final String toString() {
        return this.data;
    }
    
    @Override
    public final boolean equals(final Object other) {
        return other instanceof UnescapedData && this.data.equals(other.toString());
    }
    
    @Override
    public final int hashCode() {
        return (this.data == null) ? 0 : this.data.hashCode();
    }
    
    @Override
    public int length() {
        return this.data.length();
    }
    
    @Override
    public char charAt(final int index) {
        return this.data.charAt(index);
    }
    
    @Override
    public CharSequence subSequence(final int start, final int end) {
        return new UnescapedData(this.data.substring(start, end));
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.data);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.data = (String)in.readObject();
    }
}
