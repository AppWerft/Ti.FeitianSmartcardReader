/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.CComplex;
import gnu.math.CQuaternion;
import gnu.math.Quantity;
import gnu.math.Quaternion;
import gnu.math.RealNum;
import gnu.math.Unit;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CQuantity
extends Quantity
implements Externalizable {
    Quaternion num;
    Unit unt;

    public CQuantity(Quaternion num, Unit unit) {
        this.num = num;
        this.unt = unit;
    }

    public CQuantity(RealNum real, RealNum imag, Unit unit) {
        this.num = new CComplex(real, imag);
        this.unt = unit;
    }

    public CQuantity(RealNum real, RealNum imag, RealNum jmag, RealNum kmag, Unit unit) {
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
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.num);
        out.writeObject(this.unt);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.num = (Quaternion)in.readObject();
        this.unt = (Unit)in.readObject();
    }
}

