// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class CComplex extends Complex implements Externalizable
{
    RealNum real;
    RealNum imag;
    
    public CComplex() {
    }
    
    public CComplex(final RealNum real, final RealNum imag) {
        this.real = real;
        this.imag = imag;
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
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.real);
        out.writeObject(this.imag);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.real = (RealNum)in.readObject();
        this.imag = (RealNum)in.readObject();
    }
}
