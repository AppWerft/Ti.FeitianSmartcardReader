/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.Dimensions;
import gnu.math.Unit;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

class MulUnit
extends Unit
implements Externalizable {
    Unit unit1;
    Unit unit2;
    int power1;
    int power2;
    MulUnit next;

    MulUnit(Unit unit1, int power1, Unit unit2, int power2) {
        this.unit1 = unit1;
        this.unit2 = unit2;
        this.power1 = power1;
        this.power2 = power2;
        this.dims = Dimensions.product(unit1.dims, power1, unit2.dims, power2);
        this.factor = power1 == 1 ? unit1.factor : Math.pow(unit1.factor, power1);
        if (power2 < 0) {
            int i = -power2;
            while (--i >= 0) {
                this.factor /= unit2.factor;
            }
        } else {
            int i = power2;
            while (--i >= 0) {
                this.factor *= unit2.factor;
            }
        }
        this.next = unit1.products;
        unit1.products = this;
    }

    MulUnit(Unit unit1, Unit unit2, int power2) {
        this(unit1, 1, unit2, power2);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer(60);
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
        if ((this.power1 & 1) == 0 && (this.power2 & 1) == 0) {
            return MulUnit.times(this.unit1, this.power1 >> 1, this.unit2, this.power2 >> 1);
        }
        return super.sqrt();
    }

    static MulUnit lookup(Unit unit1, int power1, Unit unit2, int power2) {
        MulUnit u = unit1.products;
        while (u != null) {
            if (u.unit1 == unit1 && u.unit2 == unit2 && u.power1 == power1 && u.power2 == power2) {
                return u;
            }
            u = u.next;
        }
        return null;
    }

    public static MulUnit make(Unit unit1, int power1, Unit unit2, int power2) {
        MulUnit u = MulUnit.lookup(unit1, power1, unit2, power2);
        if (u != null) {
            return u;
        }
        return new MulUnit(unit1, power1, unit2, power2);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.unit1);
        out.writeInt(this.power1);
        out.writeObject(this.unit2);
        out.writeInt(this.power2);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.unit1 = (Unit)in.readObject();
        this.power1 = in.readInt();
        this.unit2 = (Unit)in.readObject();
        this.power2 = in.readInt();
    }

    public Object readResolve() throws ObjectStreamException {
        MulUnit u = MulUnit.lookup(this.unit1, this.power1, this.unit2, this.power2);
        if (u != null) {
            return u;
        }
        return this;
    }
}

