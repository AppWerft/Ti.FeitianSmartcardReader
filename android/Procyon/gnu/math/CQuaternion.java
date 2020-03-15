// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class CQuaternion extends Quaternion implements Externalizable
{
    RealNum real;
    RealNum imag;
    RealNum jmag;
    RealNum kmag;
    
    public CQuaternion() {
    }
    
    public CQuaternion(final RealNum real, final RealNum imag, final RealNum jmag, final RealNum kmag) {
        this.real = real;
        this.imag = imag;
        this.jmag = jmag;
        this.kmag = kmag;
    }
    
    @Override
    public RealNum re() {
        return this.real;
    }
    
    @Override
    public RealNum im() {
        return this.imag;
    }
    
    @Override
    public RealNum jm() {
        return this.jmag;
    }
    
    @Override
    public RealNum km() {
        return this.kmag;
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.real);
        out.writeObject(this.imag);
        out.writeObject(this.jmag);
        out.writeObject(this.kmag);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.real = (RealNum)in.readObject();
        this.imag = (RealNum)in.readObject();
        this.jmag = (RealNum)in.readObject();
        this.kmag = (RealNum)in.readObject();
    }
}
