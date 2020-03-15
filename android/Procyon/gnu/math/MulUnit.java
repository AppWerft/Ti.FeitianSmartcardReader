// 
// Decompiled by Procyon v0.5.36
// 

package gnu.math;

import java.io.ObjectStreamException;
import java.io.ObjectInput;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.Externalizable;

class MulUnit extends Unit implements Externalizable
{
    Unit unit1;
    Unit unit2;
    int power1;
    int power2;
    MulUnit next;
    
    MulUnit(final Unit unit1, final int power1, final Unit unit2, final int power2) {
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.power1 = power1;
        this.power2 = power2;
        this.dims = Dimensions.product(unit1.dims, power1, unit2.dims, power2);
        if (power1 == 1) {
            this.factor = unit1.factor;
        }
        else {
            this.factor = Math.pow(unit1.factor, power1);
        }
        if (power2 < 0) {
            int i = -power2;
            while (--i >= 0) {
                this.factor /= unit2.factor;
            }
        }
        else {
            int i = power2;
            while (--i >= 0) {
                this.factor *= unit2.factor;
            }
        }
        this.next = unit1.products;
        unit1.products = this;
    }
    
    MulUnit(final Unit unit1, final Unit unit2, final int power2) {
        this(unit1, 1, unit2, power2);
    }
    
    @Override
    public String toString() {
        final StringBuffer str = new StringBuffer(60);
        str.append(this.unit1);
        if (this.power1 != 1) {
            str.append('^');
            str.append(this.power1);
        }
        if (this.power2 != 0) {
            str.append('*');
            str.append(this.unit2);
            if (this.power2 != 1) {
                str.append('^');
                str.append(this.power2);
            }
        }
        return str.toString();
    }
    
    @Override
    public Unit sqrt() {
        if ((this.power1 & 0x1) == 0x0 && (this.power2 & 0x1) == 0x0) {
            return Unit.times(this.unit1, this.power1 >> 1, this.unit2, this.power2 >> 1);
        }
        return super.sqrt();
    }
    
    static MulUnit lookup(final Unit unit1, final int power1, final Unit unit2, final int power2) {
        for (MulUnit u = unit1.products; u != null; u = u.next) {
            if (u.unit1 == unit1 && u.unit2 == unit2 && u.power1 == power1 && u.power2 == power2) {
                return u;
            }
        }
        return null;
    }
    
    public static MulUnit make(final Unit unit1, final int power1, final Unit unit2, final int power2) {
        final MulUnit u = lookup(unit1, power1, unit2, power2);
        if (u != null) {
            return u;
        }
        return new MulUnit(unit1, power1, unit2, power2);
    }
    
    @Override
    public void writeExternal(final ObjectOutput out) throws IOException {
        out.writeObject(this.unit1);
        out.writeInt(this.power1);
        out.writeObject(this.unit2);
        out.writeInt(this.power2);
    }
    
    @Override
    public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
        this.unit1 = (Unit)in.readObject();
        this.power1 = in.readInt();
        this.unit2 = (Unit)in.readObject();
        this.power2 = in.readInt();
    }
    
    public Object readResolve() throws ObjectStreamException {
        final MulUnit u = lookup(this.unit1, this.power1, this.unit2, this.power2);
        if (u != null) {
            return u;
        }
        return this;
    }
}
