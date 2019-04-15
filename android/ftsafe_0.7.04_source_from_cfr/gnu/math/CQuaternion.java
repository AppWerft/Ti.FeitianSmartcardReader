/*
 * Decompiled with CFR 0.139.
 */
package gnu.math;

import gnu.math.Quaternion;
import gnu.math.RealNum;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class CQuaternion
extends Quaternion
implements Externalizable {
    RealNum real;
    RealNum imag;
    RealNum jmag;
    RealNum kmag;

    public CQuaternion() {
    }

    public CQuaternion(RealNum real, RealNum imag, RealNum jmag, RealNum kmag) {
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
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.real);
        out.writeObject(this.imag);
        out.writeObject(this.jmag);
        out.writeObject(this.kmag);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.real = (RealNum)in.readObject();
        this.imag = (RealNum)in.readObject();
        this.jmag = (RealNum)in.readObject();
        this.kmag = (RealNum)in.readObject();
    }
}

