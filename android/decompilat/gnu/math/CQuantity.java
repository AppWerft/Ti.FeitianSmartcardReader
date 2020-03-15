// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

public class CQuantity extends Quantity implements Externalizable
{
    Quaternion num;
    Unit unt;
    
    public CQuantity(final Quaternion num, final Unit unit) {
        this.num = num;
        this.unt = unit;
    }
    
    public CQuantity(final RealNum real, final RealNum imag, final Unit unit) {
        this.num = new CComplex(real, imag);
        this.unt = unit;
    }
    
    public CQuantity(final RealNum real, final RealNum imag, final RealNum jmag, final RealNum kmag, final Unit unit) {
        this.num = new CQuaternion(real, imag, jmag, kmag);
        this.unt = unit;
    }
    
    @Override
    public Quaternion number() {
        return this.num;
    }
    
    @Override
    public Unit unit() {
        return this.unt;
    }
    
    @Override
    public boolean isExact() {
        return this.num.isExact();
    }
    
    @Override
    public boolean isZero() {
        return this.num.isZero();
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.num);
        out.writeObject(this.unt);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.num = (Quaternion)in.readObject();
        this.unt = (Unit)in.readObject();
    }
}
